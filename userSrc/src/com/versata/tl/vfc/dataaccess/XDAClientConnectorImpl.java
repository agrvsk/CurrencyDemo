package com.versata.tl.vfc.dataaccess;

import com.versata.tl.api.logging.VersataLogger;
import com.versata.tl.common.CoLocatedResultSet;
import com.versata.tl.common.MetaColumn;
import com.versata.tl.common.QueryRequest;
import com.versata.tl.common.QueryResponse;
import com.versata.tl.common.RowSeqHolder;
import com.versata.tl.common.VSORBResultSetPackage.atEndException;
import com.versata.tl.common.VSORBSessionPackage.ORBRow;
import com.versata.tl.common.VSORBSessionPackage.ORBRows;
import com.versata.tl.common.VSSession;
import com.versata.tl.common.VSSessionFailedListener;
import com.versata.tl.common.XDAAppServerConnector;
import com.versata.tl.common.Property;
import com.versata.tl.common.ObjectInputStreamLoader;
import com.versata.tl.common.businessobject.BusinessObject;
import com.versata.tl.common.exception.ServerDownException;
import com.versata.tl.common.exception.TierSessionLimitException;
import com.versata.tl.common.exception.VSApiException;
import com.versata.tl.common.exception.VSException;
import com.versata.tl.common.meta.VSMetaColumn;
import com.versata.tl.common.meta.VSMetaQuery;
import com.versata.tl.common.meta.VSMetaTable;
import com.versata.tl.common.security.VSSecurityObjectHolder;
import com.versata.tl.common.text.ErrorMsgCode;
import com.versata.tl.common.text.RuntimeMsgCode;
import com.versata.tl.common.text.VSapiMsgCode;
import com.versata.tl.common.util.AppEnvironment;
import com.versata.tl.common.util.CommonEnvironment;
import com.versata.tl.common.util.DataConst;
import com.versata.tl.common.util.Parameter;
import com.versata.tl.common.util.SearchRequest;
import com.versata.tl.common.util.VSDate;
import com.versata.tl.common.util.Util;
import com.versata.tl.common.util.VersionHolder;
import com.versata.tl.common.vlsobject.VSORBAppServer;
import com.versata.tl.common.vlsobject.VSORBException;
import com.versata.tl.common.vlsobject.VSORBResultSet;
import com.versata.tl.common.vlsobject.VSORBSession;
import com.versata.tl.util.SerializationUtil;
import com.versata.tl.util.VFCResourcesProps;
import com.versata.tl.util.StreamUtils;
import com.versata.tl.vfc.services.VSApplicationContext;
import com.versata.tl.vfc.services.controlsupport.VSDBException;
import com.versata.tl.vfc.text.VFCMsgCode;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;
import javax.naming.NamingException;
import javax.transaction.UserTransaction;
import org.omg.CORBA.NO_IMPLEMENT;
import org.omg.CORBA.OBJECT_NOT_EXIST;
import org.omg.CORBA.TRANSIENT;

/**
 * @internal.tle not intended to be called or subclassed directly.
 * <p/>
 * For API documentation, see {@link XDAConnector}, {@link com.versata.tl.common.XDAAppServerConnector}
 */

public class XDAClientConnectorImpl implements XDAConnector, XDAAppServerConnector, Serializable {
    private static final String _RCS_HEADER =
        "$Header: //depot/main/products/brms/runtime/src/core/com/versata/tl/vfc/dataaccess/XDAClientConnectorImpl.java#1 $";

    static {
        VersataLogger.getRCSTraceLogger().trace(_RCS_HEADER);
    }

    private static final VersataLogger _LOGGER = VersataLogger.getLogger(XDAClientConnectorImpl.class);

    private static final String PACKAGE_EXCEPTION = "com.versata.tl.common.VSORBResultSetPackage.atEndException";
    private static final String NULL_KEY = "@@NULL@@";
    private static final String NC_KEY = "@@NC@@";
    private static final String ISO_TYPE = "ISO-8859-1";

    // Variables for query, result set and session information
    public String componentName;
    protected VSSession vsSession;
    protected transient QueryResponse queryResponse;
    protected transient VSORBResultSet remoteResultSet;
    protected transient String[][] queryBuffer;
    protected transient Object[][] queryObjectBuffer;
    protected transient String[][] refreshBuffer;
    private transient int rowIndex;
    private transient int bufferSize;
    boolean fetchEnd;
    boolean fetchTerminated;
    private int maxRowsPerFetch = 16;
    private short columnProjectionLevel = DataConst.NONE_IMAGE;
    transient VSMetaColumn[] metaColumns;
    boolean preFetchRowCount;
    int rowCount = -1;
    private boolean serverPreFetch;
    protected transient AppEnvironment env;
    protected transient boolean connected;
    protected String encodeType = "";
    public transient VSORBAppServer appServer;
    public static final int CHAR = 1;
    /**
     * <br>JDBC constant for type codes returned by the JDBC ResultSet; value is 12.
     */
    public static final int VARCHAR = 12;
    /**
     * <br>JDBC constant for type codes returned by the JDBC ResultSet; value is -1.
     */
    public static final int LONGVARCHAR = -1;

    protected String queryText; // SQL text generated from meta uery
    SearchRequest sorter = new SearchRequest();
    // SQL order-by clause for this stance

    private int requestRandomAccessPos = -1;

    SearchRequest addedFilter = new SearchRequest();
    Vector params;

    transient VSMetaQuery metaQuery;
    int[] columnTypes;
    protected transient VSSessionFailedListener sessionFailedListener = new SessionFailedListener();

    protected transient RowSeqHolder rowHolder = new RowSeqHolder();

    // internal use, count conversion error frequence
    transient int errCount;

    private boolean blnIsAutoCloseResultSet;
    //private boolean blnIsAutoCloseResultSet = CommonEnvironment.getInstance().getVFCProperties().getProperty("useStatelessRS","false").equalsIgnoreCase("true");

    protected static Properties bundle;

    private boolean blnIsCompressRows = CommonEnvironment.getInstance()
        .isCompressRows();
    private static final long serialVersionUID = -157433587945827660L;

    public XDAClientConnectorImpl() {
        //TODO is this really needed?
        bundle = VFCResourcesProps.getInstance();
    }

    // Public Instance Methods

    /**
     * Executes an Ad-Hoc query, returns Result set from the query execution as a VSResultSet
     *
     * @param queryText select text to be executed.
     * @see XDAConnector#execute(String)
     */
    public void execute(String queryText) {
        execute(queryText, vsSession.getDefaultDataServerForSQL());
    }

    /**
     * Executes an Ad-Hoc query
     *
     * @param queryText select text to be executed. Returns result set from the query execution as a VSResultSet
     * @param dataServerName String
     * @see XDAConnector#execute(String, String)
     */
    public void execute(String queryText, String dataServerName) {

        resetFlagAndCounters();
        try {
            QueryRequest qr = getNewQueryRequest();
            qr.setSQL(queryText);
            qr.setDataServerName(dataServerName);
            qr.setMaxRowsPerFetch(maxRowsPerFetch);
            qr.setServerPreFetch(serverPreFetch);
            qr.setRequestRandomAccessPos(requestRandomAccessPos);
            qr.setUseStatelessRS(getUseStatelessRS());
            qr.setPrefetchRowCount(preFetchRowCount);
            qr.setIsCompressRows(isCompressRows());

            queryResponse = executeQuery(qr);
            getSession().addSessionFailedListener(sessionFailedListener);
            buildMetaColumnsForAdhocQuery();
        } catch (VSORBException orbEx) {
            throw new VSException(VFCMsgCode.FAILED_EXECUTE_ADHOC_QUERY, new Object[]{queryText, dataServerName}, orbEx);
        } catch (Exception re) { //TODO-EBAS
            if (isServerDownException(re)) {
                if (getSession().sessionTerminated()) {
                    execute(queryText, dataServerName);
                }
            } else {
                throw new VSException(VFCMsgCode.FAILED_EXECUTE_ADHOC_QUERY, new Object[]{queryText, dataServerName}, re);
            }
        }
    }

    /**
     * Method execute.
     *
     * @throws VSException
     * @see XDAConnector#execute()
     */
    public void execute() throws VSException {
        execute(false); //do not fetch from cache
    }

    /**
     * execute: Get the result from cache on the server, cache it if its not
     *
     * @param fetchFromCache boolean
     * @throws VSException
     * @see XDAConnector#execute(boolean)
     */
    public void execute(boolean fetchFromCache) throws VSException {

        resetFlagAndCounters();
        try {
            //Check if its to be fetched from cache on the appserver

            QueryRequest qr = getNewQueryRequest();
            qr.setComponentName(componentName);
            qr.setMaxRowsPerFetch(maxRowsPerFetch);
            qr.setUseStatelessRS(getUseStatelessRS());
            qr.setPrefetchRowCount(preFetchRowCount);
            qr.setIsCompressRows(isCompressRows());

            if (fetchFromCache) {
                qr.setUseCache(true);
            } else {
                qr.setFilter(getSerialized(addedFilter));
                qr.setSorter(getSerialized(sorter));
                qr.setColumnProjectionLevel(columnProjectionLevel);
                qr.setServerPreFetch(serverPreFetch);
                qr.setRequestRandomAccessPos(requestRandomAccessPos);
            }
            if (_LOGGER.isDebugEnabled()) {
                _LOGGER.debug("XDAClientConnectorImpl.execute - > " + qr.toString());
            }

            queryResponse = executeQuery(qr);
            getSession().addSessionFailedListener(sessionFailedListener);

            // If we need to prefetch the row count, try here
            if (preFetchRowCount) {
                rowCount = queryResponse.getCount();
                if (_LOGGER.isDebugEnabled()) {
                    _LOGGER.debug("$$:" + rowCount);
                }
            }
        } catch (VSORBException orbEx) {
            if (_LOGGER.isDebugEnabled()) {
                _LOGGER.debug("XDAClientConnectorImpl.execute ->  recasting VSORBException to VSException");
            }
            throw new VSException(orbEx.getMsgCode(), orbEx.getI15dMessage().getArgs(), orbEx);
        } catch (Exception re) { //TODO-EBAS
            if (isServerDownException(re)) {
                if (getSession().sessionTerminated()) {
                    execute(fetchFromCache);
                }
            } else {
                if (_LOGGER.isDebugEnabled()) {
                    _LOGGER.debug("XDAClientConnectorImpl.execute -> " + re);
                }
                throw new VSException(VFCMsgCode.FAILED_EXECUTE_ADHOC_QUERY_1, re);
            }
        }
        buildTypeArray();
    }

    /**
     * Executes the query in the server and returns the query response.
     *
     * @param qreq the query request passed to server
     * @return QueryResponse the query results from server for the given query request.
     */
    private QueryResponse executeQuery(QueryRequest qreq) throws Exception {

        if (_LOGGER.isDebugEnabled()) {
            _LOGGER.debug("XDAClientConnectorImpl.executeQuery qreq -> " + qreq.toString());
        }

        QueryResponse qres = (QueryResponse)getORBSession().executeQuery(qreq);

        if (_LOGGER.isDebugEnabled()) {
            _LOGGER.debug("XDAClientConnectorImpl.executeQuery qres -> " + qres.toString());
        }

        return qres;
    }

    /**
     * Method initXDAConnector.
     *
     * @param s VSSession
     * @see XDAConnector#initXDAConnector(VSSession)
     */
    public void initXDAConnector(VSSession s) {
        vsSession = s;
    }

    /**
     * Method initXDAConnector.
     *
     * @param session VSSession
     * @param componentName String
     * @param addedWhere String
     * @param addedOrderBy String
     * @see XDAConnector#initXDAConnector(VSSession, String, String, String)
     */
    public void initXDAConnector(VSSession session, String componentName, String addedWhere, String addedOrderBy) {
        vsSession = session;
        this.componentName = componentName;

        if (addedWhere != null && addedWhere.trim().length() != 0) {
            addedFilter.add(addedWhere);

            int pos = -1;
            int index = 0;
            while ((pos = addedWhere.indexOf('?', pos + 1)) != -1) {
                index++;
            }
            if (index > 0) {
                params = new Vector(index);
            }
        }

        if (addedOrderBy != null && addedOrderBy.trim().length() != 0) {
            sorter.add(addedOrderBy);
        }

        // MetaQuery will be fetched from server now
        metaQuery = session.getMetaQuery(componentName);
        isValidMetaQuery(componentName);
    }

    private void isValidMetaQuery(String componentName) {
        if (metaQuery == null) {
            throw new VSException(ErrorMsgCode.VSMSG_AnotherQueryDefLoadError, componentName);
        }
    }

    /**
     * Method initXDAConnector.
     *
     * @param session VSSession
     * @param componentName String
     * @param addedFilter SearchRequest
     * @param addedSorter SearchRequest
     * @see XDAConnector#initXDAConnector(VSSession, String, SearchRequest, SearchRequest)
     */
    public void initXDAConnector(VSSession session, String componentName, SearchRequest addedFilter, SearchRequest addedSorter) {
        vsSession = session;
        this.componentName = componentName;
        sorter = addedSorter;
        this.addedFilter = addedFilter;
        // MetaQuery will be fetched from server now
        metaQuery = getSession().getMetaQuery(componentName);
        isValidMetaQuery(componentName);
    }

    //Called from the sub class

    /**
     * Method initXDAConnector.
     *
     * @param session VSSession
     * @param rs VSORBResultSet
     * @param metaQuery VSMetaQuery
     * @throws VSORBException
     */
    protected void initXDAConnector(VSSession session, VSORBResultSet rs, VSMetaQuery metaQuery) throws VSORBException {
        vsSession = session;
        if (metaQuery != null) {
            this.metaQuery = metaQuery;
            componentName = metaQuery.getName();
        }
        resetFlagAndCounters();

        //remoteResultSet = rs;
        queryResponse = getNewQueryResponse();
        queryResponse.setRS(rs);
        queryResponse.setQueryRequest(getNewQueryRequest());

        getSession().addSessionFailedListener(sessionFailedListener);
        if (metaQuery == null) { //Adhoc resultset
            buildMetaColumnsForAdhocQuery();
        } else {
            buildTypeArray();
        }
    }

    /**
     * Method buildMetaColumnsForAdhocQuery.
     *
     * @throws VSORBException
     */
    protected void buildMetaColumnsForAdhocQuery() throws VSORBException {
        MetaColumn[] mcols;
        try {
            mcols = queryResponse.registerMetaData();
        } catch (Exception re) { //TODO-EBAS
            throw new VSException(VFCMsgCode.FAILED_TO_REGISTER_METADATA, re);
        }
        int len = mcols.length;
        columnTypes = new int[len];
        VSMetaColumn[] vsmc = new VSMetaColumn[len];
        for (int i = 0; i < len; i++) {
            vsmc[i] = new VSMetaColumn(mcols[i].name);
            vsmc[i].setColumnType(mcols[i].type);
            vsmc[i].setNullability(mcols[i].nullable);
            vsmc[i].setAutoIncrement(mcols[i].autoIncrement);
            // build type array
            columnTypes[i] = mcols[i].type;
        }
        metaColumns = vsmc;
    }

    // Dynamically build column type array to accelerate data conversion
    protected void buildTypeArray() {
        if (columnTypes != null) {
            return;
        }

        int count = metaQuery.getColumnCount();
        columnTypes = new int[count];
        MetaColumn[] mcols = null;

        for (int i = 1; i <= count; i++) {
            VSMetaColumn mc = metaQuery.getMetaColumn(i);
            // base column even it is virtual has meta column, but aggregate
            // column doesn't
            if (mc != null) {
                columnTypes[i - 1] = mc.getColumnType();
            } else {
                // For aggregate columns such as sum, count, there is no
                // metacolumn, so there is no type info,
                // We need get meta data from data source dynamically
                // Do the same thing for ad hoc query, we will get meta info
                // for all columns, but only use them for aggregated columns
                // !!! We try to use generate meta data as much as possible!!!
                if (mcols == null) {
                    try {
                        mcols = queryResponse.registerMetaData();
                    } catch (NO_IMPLEMENT ex_no_impl) {
                        VSApplicationContext.handleUnavailableRemoteObject();
                    } catch (OBJECT_NOT_EXIST obj_not_exist) {
                        VSApplicationContext.handleUnavailableRemoteObject();
                    } catch (TRANSIENT ex) {
                        VSApplicationContext.handleUnavailableRemoteObject();
                    } catch (VSORBException orbEx) {
                        throw new VSException(VFCMsgCode.FAILED_TO_REGISTER_METADATA, orbEx);
                    } catch (Exception re) { //TODO-EBAS
                        throw new VSException(VFCMsgCode.FAILED_TO_REGISTER_METADATA, re);
                    }
                    int len = mcols.length;
                    VSMetaColumn[] vsmc = new VSMetaColumn[len];

                    for (int j = 0; j < len; j++) {
                        vsmc[j] = new VSMetaColumn(mcols[j].name);
                        vsmc[j].setColumnType(mcols[j].type);
                        vsmc[j].setNullability(mcols[j].nullable);
                        vsmc[j].setAutoIncrement(mcols[j].autoIncrement);
                    }

                    metaColumns = vsmc;
                }
                // it's not efficient, but using name match works in case of there is virtual column
                for (int j = 0; j < mcols.length; j++) {
                    if (metaQuery.getQueryColumnList()[i - 1].getName().equalsIgnoreCase(mcols[j].name)) {
                        columnTypes[i - 1] = mcols[j].type;
                        metaQuery.getQueryColumnList()[i - 1].setMetaColumn(metaColumns[j]);
                        break;
                    }
                }
            }
        }
    }

    /**
     * Method closeRemoteResultSet.
     *
     * @throws VSException
     */
    public void closeRemoteResultSet() throws VSException {
        rowHolder.value = null;

        if (queryResponse != null) {
            try {
                queryResponse.close();
            } catch (NO_IMPLEMENT ex_no_impl) {
                getSession().sessionTerminated();
            } catch (OBJECT_NOT_EXIST obj_not_exist) {
                getSession().sessionTerminated();
            } catch (TRANSIENT ex) {
                getSession().sessionTerminated();
            } catch (NoSuchObjectException no_such_object) {
                //Ok to ignore this exception.
                // The resultset might have closed by VLS.
            } catch (Exception dex) {
                if (_LOGGER.isDebugEnabled()) {
                    _LOGGER.debug("XDAClientConnectorImpl.closeRemoteResultSet ->" + dex);
                }
            } finally {
                queryResponse = null;
                getSession().removeSessionFailedListener(sessionFailedListener);
            }
        }
    }

    /**
     * Method getDelegate.
     *
     * @param obj Object
     * @return CoLocatedResultSet
     */
    public CoLocatedResultSet getDelegate(Object obj) {
        return null;
    }

    /**
     * Method getUserTransaction.
     *
     * @return UserTransaction
     * @throws NamingException
     * @throws Exception
     * @see com.versata.tl.common.XDAAppServerConnector#getUserTransaction()
     */
    public UserTransaction getUserTransaction() throws NamingException, Exception {
        return null;
    }

    /**
     * Method fetchNextRow.
     *
     * @param rowValues Object[]
     * @return boolean
     * @throws VSException
     * @see VSRowProvider#fetchNextRow(Object[])
     */
    public boolean fetchNextRow(Object[] rowValues) throws VSException {
        if (rowIndex == bufferSize) {
            if (fetchTerminated) {
                throw new VSException(RuntimeMsgCode.XDACLIENTCONNECTORIMPL211);
            }

            if (fetchEnd) {
                return false;
            } else {
                fetchData();
            }
        }

        if (rowIndex != bufferSize) {
            if ( getSession().isCoLocated() ) {
                int columnCount = rowValues.length;
                System.arraycopy(queryObjectBuffer[rowIndex], 0, rowValues, 0, columnCount);
            } else {
                populateRow(rowValues, rowIndex, queryBuffer);
            }
            rowIndex++;
            return true;
        } else {
            queryObjectBuffer = null;
            queryBuffer = null;
            return false;
        }
    }

    protected void fetchData() {
        if (fetchEnd) {
            return;
        }

        try {
            if (getSession().isCoLocated()) {
                queryObjectBuffer = queryResponse.localFetch();
                bufferSize = queryObjectBuffer.length;
            } else {
                queryBuffer = queryResponse.fetchRows();
                bufferSize = queryBuffer.length;
            }

            if (bufferSize != maxRowsPerFetch) {
                closeRemoteResultSet();
                fetchEnd = true;
            }
        } catch (atEndException endExException) {
            closeRemoteResultSet();
            bufferSize = 0;
            fetchEnd = true;
        } catch (VSORBException orbEx) {
            throw new VSException(VFCMsgCode.FAILED_FETCH_DATA, orbEx);
        } catch (Exception ex) {
            if (isServerDownException(ex)) {
                getSession().sessionTerminated();
            } else if (ex.getMessage().indexOf(PACKAGE_EXCEPTION) > 0) {
                closeRemoteResultSet();
                bufferSize = 0;
                fetchEnd = true;
            }
            // BTS TaskID: 26648 Workaround for IBM JDK 1.2.2.  The 1.2.2 JDK loses track of the
            // com.versata.tl.common.VSORBResultSetPackage.atEndException that actually got thrown here.  Instead,
            // this CORBA Unknown Maybe exception is caught here.  The IBM JDK 1.3 has fixed the
            // problem.  So, future WAS that uses the new JDK will not need the following catch
            // block.
            else if (ex.getMessage().indexOf("completed: Maybe") > 0) {
                closeRemoteResultSet();
                bufferSize = 0;
                fetchEnd = true;
            } else {
                throw new VSException(VFCMsgCode.FAILED_FETCH_DATA, ex);
            }
        }
        rowIndex = 0;
    }

    /**
     * Method populateRow.
     *
     * @param rowValues Object[]
     * @param rowIndex int
     * @param buffer String[][]
     */
    protected void populateRow(Object[] rowValues, int rowIndex, String[][] buffer) {
        int columnCount = buffer[rowIndex].length;
        for (int i = 0; i < columnCount; i++) {
            rowValues[i] = convertData(buffer[rowIndex][i], i);
        }

        if (errCount > 0) {
            if (_LOGGER.isDebugEnabled()) {
                _LOGGER.debug(RuntimeMsgCode.XDAORBCONNECTOR310, String.valueOf(errCount));
            }
        }
        errCount = 0;
    }

    /**
     * Method convertData.
     *
     * @param data String
     * @param index int
     * @return Object
     */
    protected Object convertData(String data, int index) {
        try {
            if (data == null || NULL_KEY.equals(data)) {
                return null;
            }

            buildTypeArray();

            switch (columnTypes[index]) {
                case DataConst.BIT: // stored as Boolean
                    if ("TRUE".equalsIgnoreCase(data)) {
                        return Boolean.valueOf(true);
                    } else if ("FALSE".equalsIgnoreCase(data)) {
                        return Boolean.valueOf(false);
                    } else {
                        int dotIndex = data.indexOf(".");
                        if (dotIndex != -1) {
                            data = data.substring(0, dotIndex);
                        }
                        return Boolean.valueOf(!"0".equals(data.trim()));
                    }

                case DataConst.TINYINT: // stored as Integer
                case DataConst.SMALLINT: // stored as Integer
                case DataConst.INTEGER: // stored as Integer
                    return Integer.valueOf(data);
                case DataConst.BIGINT: // stored as Long
                    return Long.valueOf(data);
                case DataConst.REAL: // stored as Float
                case DataConst.FLOAT: // stored as Double
                    return Float.valueOf(data);
                case DataConst.DOUBLE: // stored as Double
                    return Double.valueOf(data);
                case DataConst.NUMERIC: // stored as java.lang.BigDecimal
                case DataConst.DECIMAL: // stored as java.lang.BigDecimal
                    return new BigDecimal(data);
                case DataConst.CHAR: // stored as String
                case DataConst.VARCHAR: // stored as String
                case DataConst.LONGVARCHAR: // stored as String
                    return data;
                case DataConst.BINARY: // stored as byte[]
                case DataConst.VARBINARY: // stored as byte[]
                case DataConst.LONGVARBINARY: // stored as byte[]
                    return data==null?null:data.getBytes(ISO_TYPE);
                    // WE should return byte[]
                case DataConst.TIME:
                case DataConst.DATE: // stored as VSData
                case DataConst.TIMESTAMP: // stored as java.lang.Timestamp
                    return VSDate.valueOf(data);
                case DataConst.NULL: // @@ Should it return null ?
                case DataConst.OTHER:
                default :
                    return null;
            }
        } catch (Exception ex) {
            errCount++;

            int dotIndex = data.indexOf(".");
            if (dotIndex != -1) {
                data = data.substring(0, dotIndex);
            }

            switch (columnTypes[index]) {
                case DataConst.TINYINT: // stored as Integer
                case DataConst.SMALLINT: // stored as Integer
                case DataConst.INTEGER: // stored as Integer
                    return Integer.valueOf(data);
                case DataConst.BIGINT: // stored as Long
                    return Long.valueOf(data);
                case DataConst.BIT:
                    // It must accessing oracle, where boolean saved as numeric
                    return Boolean.valueOf(!"0".equals(data.trim()));
                default :
                    return null;
            }
        }
    }

    /**
     * Method update.
     *
     * @param e Enumeration
     * @throws VSException
     * @see XDAConnector#update(Enumeration)
     */
    public void update(Enumeration e) throws VSException {
        updateWithBO(e);
    }

    /**
     * Method getRowCount.
     *
     * @return int
     * @throws VSException
     * @see XDAConnector#getRowCount()
     */
    public int getRowCount() throws VSException {
        return rowCount;
    }

    /**
     * Method getRowCount.
     *
     * @param bforce boolean
     * @return int
     * @throws VSException
     * @throws atEndException
     */
    public int getRowCount(boolean bforce) throws VSException, atEndException {
        //MD!!! VIT 46331
        if (preFetchRowCount && bforce) {
            if (queryResponse == null) {
                execute();
            }

            try {
                rowCount = queryResponse.getRowCount(true);
            } catch (RemoteException ex) {
                if (_LOGGER.isDebugEnabled()) {
                    _LOGGER.debug("XDAClientConnectorImpl.getRowCount -> " + ex);
                }
            }
        }
        return rowCount;
    }

    /**
     * Method createRow.
     *
     * @param vsrs VSResultSet
     * @param modified boolean
     * @return VSRow
     * @see XDAConnector#createRow(VSResultSet, boolean)
     */
    public VSRow createRow(VSResultSet vsrs, boolean modified) {
        return modified ? new VSRowBasic(vsrs, modified) : new VSRowBasic(vsrs);
    }

    /**
     * Method close.
     *
     * @throws VSException
     * @see XDAConnector#close()
     */
    public void close() throws VSException {
        try {
            closeRemoteResultSet();
        } catch (VSException ex) {
            if (isServerDownException(ex)) {
                getSession().sessionTerminated();
            }
        } finally {
            queryBuffer = null;
            queryObjectBuffer = null;
            columnTypes = null;
            vsSession = null;
            metaColumns = null;
            sorter = null;
            addedFilter = null;
            metaQuery = null;
            columnTypes = null;
            rowHolder = null;

            if (params != null) {
                params.removeAllElements();
                params = null;
            }

        }
    }

    /**
     * Method cancel.
     *
     * @see XDAConnector#cancel()
     */
    public void cancel() {
    }

    /**
     * Method getSession.
     *
     * @return VSSession
     * @see XDAConnector#getSession()
     */
    public VSSession getSession() {
        return vsSession;
    }

    /**
     * Method getORBSession.
     *
     * @return VSORBSession
     */
    public VSORBSession getORBSession() {
        return vsSession.getORBSession();
    }

    /**
     * Method replaceSortingCriteria.
     *
     * @param aSorter SearchRequest
     * @see XDAConnector#replaceSortingCriteria(SearchRequest)
     */
    public void replaceSortingCriteria(SearchRequest aSorter) {
        sorter = aSorter;
    }

    /**
     * Method addFilter.
     *
     * @param aFilter SearchRequest
     * @see XDAConnector#addFilter(SearchRequest)
     */
    public void addFilter(SearchRequest aFilter) {
    	  	 
        if (aFilter != null) {
        	if(addedFilter==null)
            {
            	addedFilter=new SearchRequest();
            }
            Vector stringList = aFilter.get(SearchRequest.STRING);
            for (int i = 0; i < stringList.size(); i++) {
                addedFilter.add((String)stringList.elementAt(i));
            }

            Vector objList = aFilter.get(SearchRequest.OBJECT);
            for (int i = 0; i < objList.size(); i++) {
                addedFilter.add(objList.elementAt(i));
            }

            Vector paramList = aFilter.get(SearchRequest.PARAMETER);
            for (int i = 0; i < paramList.size(); i++) {
                addedFilter.add((Parameter)paramList.elementAt(i));
            }            
			if (aFilter.searchOption != null) {
                if (addedFilter.searchOption==null)
                    addedFilter.searchOption=aFilter.searchOption;
                else
                    addedFilter.searchOption.putAll(aFilter.searchOption);
            }
        }
    }

    /**
     * Method setParamValue.
     *
     * @param index int
     * @param aData VSData
     * @throws VSException
     * @see XDAConnector#setParamValue(int, VSData)
     */
    public void setParamValue(int index, VSData aData) throws VSException {
        if (aData == null) {
            throw new VSException(ErrorMsgCode.VSMSG_NullQueryParameter);
        }

        if (index > params.capacity()) {
            if (_LOGGER.isDebugEnabled()) {
                _LOGGER.debug(RuntimeMsgCode.XDAORBCONNECTOR312);
            }
        } else {
            params.addElement(aData);
        }

        // If all params have been setin, covnert where clause now
        if (params.size() == params.capacity()) {
            Vector stringFilter = addedFilter.get(SearchRequest.STRING);
            String replaceWhereClause = VSSqlGenerator.convertPreparedSQL((String)stringFilter.elementAt(0), params, getSession());
            stringFilter.setElementAt(replaceWhereClause, 0);
        }
    }

    private byte[] getSerialized(Serializable obj) {
        return SerializationUtil.serializeToByteArray(obj);
    }

    /**
     * Method refreshRow.
     *
     * @param aRow VSRow
     * @param pkeyParams SearchRequest
     * @throws VSException
     * @see XDAConnector#refreshRow(VSRow, SearchRequest)
     */
    public void refreshRow(VSRow aRow, SearchRequest pkeyParams) throws VSException {

        QueryResponse _queryResponse;
        try {
            // As I know pkey value, use addedWhere is unnecessary
            QueryRequest qr = getNewQueryRequest();
            qr.setComponentName(componentName);
            qr.setFilter(getSerialized(pkeyParams));
            qr.setSorter(getSerialized(sorter));
            qr.setMaxRowsPerFetch(2);
            qr.setColumnProjectionLevel(columnProjectionLevel);
            qr.setServerPreFetch(false);
            qr.setRequestRandomAccessPos(0);
            qr.setUseStatelessRS(true);
            _queryResponse = executeQuery(qr);
        } catch (Exception e) {
            if (isServerDownException(e)) {
                if (getSession().sessionTerminated()) {
                    refreshRow(aRow, pkeyParams);
                }
            }
            if (_LOGGER.isDebugEnabled()) {
                _LOGGER.debug("XDAClientConnectorImpl.refreshRow -> " + e);
            }
            return;
        }
        String[][] _queryBuffer = null;
        Object[][] _queryObjectBuffer = null;
        int _bufferSize;

        try {
            if ( getSession().isCoLocated() ) {
                _queryObjectBuffer = _queryResponse.localFetch();
                _bufferSize = _queryObjectBuffer.length;
            } else {
                _queryBuffer = _queryResponse.fetchRows();
                _bufferSize = _queryBuffer.length;
            }
        } catch (atEndException e) {
            throw new VSException(ErrorMsgCode.VSMSG_RecordNotFound, e);
        } catch (Exception e) {
            if (isServerDownException(e)) {
                if (getSession().sessionTerminated()) {
                    refreshRow(aRow, pkeyParams);
                }
            }
            _LOGGER.warn(e);
            return;
        }

        //String[][] _queryBuffer = _rowHolder.value;
        if (_bufferSize == 1) {
            if (getSession().isCoLocated()) {
                int columnCount = _queryObjectBuffer[0].length;
                for (int i = 1; i <= columnCount; i++) {
                    VSData data = aRow.getData(i);
                    data.setObject(_queryObjectBuffer[0][i - 1]);
                }
            } else {
                int columnCount = _queryBuffer[0].length;
                for (int i = 1; i <= columnCount; i++) {
                    VSData data = aRow.getData(i);
                    Object rsValue = convertData(_queryBuffer[0][i - 1], i - 1);
                    data.setObject(rsValue);
                }
            }
        }

        try {
            if (_queryResponse != null) {
                _queryResponse.close();
            }
        } catch (Exception dex) {
            _LOGGER.warn(dex);
        }
    }

    /**
     * Method initXDAConnector.
     *
     * @param session VSSession
     * @param v VSQuery
     * @param d VSMetaQuery
     * @param a String
     * @param e String
     */
    public void initXDAConnector(VSSession session, VSQuery v, VSMetaQuery d, String a, String e) {
        vsSession = session;
    }

    /**
     * Method getMetaQuery.
     *
     * @return VSMetaQuery
     * @see XDAConnector#getMetaQuery()
     */
    public VSMetaQuery getMetaQuery() {
        return metaQuery;
    }

    /**
     * Method isReadOnly.
     *
     * @return boolean
     * @see VSRowProvider#isReadOnly()
     */
    public boolean isReadOnly() {
        return metaQuery == null;
    }

    /**
     * Method getMetaColumns.
     *
     * @return VSMetaColumn[]
     * @see VSRowProvider#getMetaColumns()
     */
    public VSMetaColumn[] getMetaColumns() {
        return metaColumns;
    }

    /**
     * Method getUser.
     *
     * @return String
     * @see XDAConnector#getUser()
     */
    public String getUser() {
        String user = null;
        try {
            user = getORBSession().getUserID();
        } catch (RemoteException e) {
            _LOGGER.warn(e);
        }
        return user;
    }

    /**
     * Method getSecuritySession.
     *
     * @param server String
     * @param login String
     * @param password String
     * @return VSORBSession
     * @throws VSException
     * @see com.versata.tl.common.XDAAppServerConnector#getSecuritySession(String, String, String)
     */
    public VSORBSession getSecuritySession(String server, String login, String password) throws VSException {
        throw new VSApiException(VSapiMsgCode.NOT_SUPPORTED);
    }

    /**
     * Method getSecuritySessionJNDI.
     *
     * @param server String
     * @param login String
     * @param password String
     * @param JNDIName String
     * @return VSORBSession
     * @throws VSException
     * @see com.versata.tl.common.XDAAppServerConnector#getSecuritySessionJNDI(String, String, String, String)
     */
    public VSORBSession getSecuritySessionJNDI(String server, String login, String password, String JNDIName) throws VSException {
        throw new VSApiException(VSapiMsgCode.NOT_SUPPORTED);
    }

    /**
     * Method getSecuritySessionRepository.
     *
     * @param server String
     * @param login String
     * @param password String
     * @param repositoryName String
     * @return VSORBSession
     * @throws VSException
     * @see com.versata.tl.common.XDAAppServerConnector#getSecuritySessionRepository(String, String, String, String)
     */
    public VSORBSession getSecuritySessionRepository(String server, String login, String password, String repositoryName)
        throws VSException {
        throw new VSApiException(VSapiMsgCode.NOT_SUPPORTED);
    }

    /**
     * Method getSequenceNumber.
     *
     * @param sqlType int
     * @param table VSMetaTable
     * @return Object
     */
    public Object getSequenceNumber(int sqlType, VSMetaTable table) {
        // should not be called
        return null;
    }

    /**
     * Method getBusinessObject.
     *
     * @param row VSRow
     * @return BusinessObject
     * @throws VSException
     */
    public BusinessObject getBusinessObject(VSRow row) throws VSException {
        //TODO-EBAS
        //  ORBRow[] rowArray = getORBRow(row);
        //  return (BusinessObject)getBusinessObject( componentName, rowArray );
        return null;
    }

    /**
     * Method getORBRow.
     *
     * @param row VSRow
     * @return ORBRow[]
     */
    protected ORBRow[] getORBRow(VSRow row) {

        int columnCount = metaQuery.getColumnCount();
        ORBRow[] rowArray;

        if (row.updateInDb()) {
            rowArray = new ORBRow[2];
        } else {
            rowArray = new ORBRow[1];
        }
        try {
            ORBRow orbRow;
            String[] serverRow;
            if (row.deleteInDb() || row.updateInDb()) {
                orbRow = modifyRow(row);
                serverRow = new String[columnCount];
                // transfer updated data to serverRow
                for (int i = 1; i <= columnCount; i++) {
                    String value = NULL_KEY;
                    if (isBinary(row, i)) {
// ?? Don't send old value as they are not be used for rule or opt locking
                    } else {
                        if (row.getData(i).getOriginalObject() != null) {
                            value = row.getData(i).getOriginalObject().toString();
                        }
                    }

                    serverRow[i - 1] = value;
                }
                orbRow.row = serverRow;
                rowArray[0] = orbRow;
            }

            if (row.insertInDb() || row.updateInDb() || !row.saveInDB()) {
                orbRow = modifyRow(row);
                serverRow = new String[columnCount];
                // transfer updated data to serverRow
                for (int i = 1; i <= columnCount; i++) {
                    String value = NULL_KEY;

                    if (row.getData(i).modified()) {
                        Object o;
                        if ((o = row.getData(i).getObject()) != null) {
                            if (isBinary(row, i)) {
                                value = new String((byte[])row.getData(i).getObject(), ISO_TYPE);
                            } else {
                                value = o.toString();
                            }
                        }
                    } else {
                        value = NC_KEY;
                    }

                    serverRow[i - 1] = value;
                }
                orbRow.row = serverRow;
                if (row.updateInDb()) {
                    rowArray[1] = orbRow;
                } else {
                    rowArray[0] = orbRow;
                }
            }
        } catch (Exception e) {
            _LOGGER.warn(e);
        }
        return rowArray;
    }

    private boolean isBinary(VSRow row, int i) {
        return DataConst.isValidBinary(row.getData(i).getTypeCode());
    }

    private ORBRow modifyRow(VSRow row) {
        ORBRow orbRow = new ORBRow();
        orbRow.op = 0;
        if (row.getUserDefinedEvent() != null) {
            orbRow.eventName = row.getUserDefinedEvent().getEventName();
        } else {
            orbRow.eventName = "";
        }
        // Set Operation flag
        if (row.insertInDb()) {
            orbRow.op = VSORBSession.insert;
        } else if (row.updateInDb()) {
            orbRow.op = VSORBSession.update;
        } else if (row.deleteInDb()) {
            orbRow.op = VSORBSession.delete;
        }
        return orbRow;
    }

    /**
     * Method getOldValues.
     *
     * @param row VSRow
     * @return Properties
     */
    public Properties getOldValues(VSRow row) {

        Properties oldValues = new Properties();
        if (row.insertInDb()) {
            return oldValues;
        }

        int columnCount = metaQuery.getColumnCount();

        int lockMode = metaQuery.getChildMostTable().getOptLock();

        try {
            for (int i = 1; i <= columnCount; i++) {
                VSData data = row.getData(i);
                VSMetaColumn metaCol = data.getMetaColumn();
                if (metaCol == null) {
                    continue;
                }

                if (metaQuery.getName().equals(metaQuery.getChildMostTableName())) {
                    //Its a DataObject
                    if (metaCol.isVirtual()) {
                        continue;
                    }

                    if (!data.modified() &&
                        (lockMode == DataConst.OptLockingOnChanged || lockMode == DataConst.NoOptLocking || !metaCol.inOptLock())) {
                        continue;
                    }

                    if (DataConst.isValidBinary(data.getTypeCode())) {
                        continue;
                    }
                }
                Object originalObject = data.getOriginalObject();
                String value = originalObject != null ? originalObject.toString() : NULL_KEY;
                oldValues.put(data.getName(), value);
            }

        } catch (Exception e) {
            _LOGGER.warn(e);
        }
        return oldValues;
    }

    /**
     * Method getNewValues.
     *
     * @param row VSRow
     * @return Properties
     */
    public Properties getNewValues(VSRow row) {
        Properties newValues = new Properties();

        if (!row.saveInDB()) {
            return newValues;
        }

        if (row.deleteInDb()) {
            return newValues;
        }

        int columnCount = metaQuery.getColumnCount();

        try {
            for (int i = 1; i <= columnCount; i++) {
                VSData data = row.getData(i);
                if (!data.modified()) {
                    continue;
                }

                String value = NULL_KEY;
                Object o;
                if ((o = row.getData(i).getObject()) != null) {
                    if (DataConst.isValidBinary(data.getTypeCode())) {
                        value = new String((byte[])row.getData(i).getObject(), ISO_TYPE);
                    } else {
                        value = o.toString();
                    }
                }

                newValues.put(data.getName(), value);
            }
        } catch (Exception e) {
            _LOGGER.warn(e);
        }
        return newValues;
    }

    private void updateWithBO(Enumeration e) throws VSException {
        ArrayList toBeRefreshedRows = new ArrayList();
        int columnCount = metaQuery.getColumnCount();
        ArrayList tempList = new ArrayList(); // Store orb rows, convert to array
        Vector errorRows = new Vector();

        while (e.hasMoreElements()) {// use rowIndex from server to locate a VSrow For each changed row
            VSRow row = (VSRow)e.nextElement();
            if (!row.saveInDB()) {
                continue;
            }
            String[] serverRow;
            ORBRow orbRow;
            String eventName="";
        	if (row.getUserDefinedEvent() != null) eventName = row.getUserDefinedEvent().getEventName();
            if (row.deleteInDb()) {//to deal delete
                orbRow = new ORBRow();
                orbRow.eventName = eventName;
                orbRow.op = VSORBSession.delete;// Set Operation flag
                serverRow = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {// transfer updated data to serverRow
                	Object originalObject=row.getData(i).getOriginalObject();
                    if (originalObject != null) {
                    	serverRow[i - 1] = originalObject.toString();
                    }
                    else
                    	serverRow[i - 1] = NULL_KEY;
                }
                orbRow.row = serverRow;
                tempList.add(orbRow);
                errorRows.addElement(row);
            }else  if (row.insertInDb()) {//to deal insert
                orbRow = new ORBRow();
                orbRow.eventName = eventName;
                orbRow.op = VSORBSession.insert;// Set Operation flag
                serverRow = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {// transfer updated data to serverRow
                    String value = NC_KEY;
                    VSData columnData = row.getData(i);
                    if (columnData.modified()) {
                        Object o=columnData.getObject();
                        if (o != null) {
                            if (isBinary(row, i)) {
                                value = columnData.getString();
                            } else {
                                value = o.toString();
                            }
                        }
                    }
                    else
                    {
                    	Object o=columnData.getObject();
                    	if(o!=null)
                    	{
                    		value=o.toString();
                    	}
                    }
                    serverRow[i - 1] = value;
                }
                orbRow.row = serverRow;
                tempList.add(orbRow);
                errorRows.addElement(row);
                toBeRefreshedRows.add(row);
            }else  if (row.updateInDb()) {//to deal update
                orbRow = new ORBRow(); // The ORBRow object which contains the original row in update
                orbRow.eventName = eventName;
                orbRow.op = VSORBSession.update; // Set Operation flag
                serverRow = new String[columnCount];//The String array which contains the original row data
                
                ORBRow modifiedOrbRow = new ORBRow();//The ORBRow object which contains the modified of a update row
                modifiedOrbRow.eventName = eventName;
                modifiedOrbRow.op = VSORBSession.update;// Set Operation flag
                String[] modifiedServerRow = new String[columnCount];//The String array which contains the modified of a update row data
                for (int i = 1; i <= columnCount; i++) {// transfer updated data to serverRow and modifiedServerRow
                	VSData columnData = row.getData(i);//get column data object
                	Object originalObject=columnData.getOriginalObject();//get the original data of this column
                    if (originalObject != null) {
                    	serverRow[i - 1] = originalObject.toString();//store original data value
            }
                    else
                    	serverRow[i - 1] = NULL_KEY;//"@@NULL@@"
                    String value = NC_KEY;//"@@NC@@"

                    if (columnData.modified()) {
                        Object o=columnData.getObject();//get the modified data of this column
                        if (o != null) {
                            if (isBinary(row, i)) {
                                value = columnData.getString();
                            } else {
                            	value = o.toString();
                            }
                        }else{						//fix issue #16
                        	    value=null;				//fix issue #46 
                        }
                    } 
                    modifiedServerRow[i - 1] = value;//store modified data value
                }
                orbRow.row = serverRow;
                tempList.add(orbRow);
                modifiedOrbRow.row=modifiedServerRow;
                tempList.add(modifiedOrbRow);
                errorRows.addElement(row);
                toBeRefreshedRows.add(row);
            }
        }
        ORBRows updateBuffer = new ORBRows();//After all row be transfered, send to server
        int size = tempList.size();
        ORBRow[] tempOrbrows=new ORBRow[size];
        for (int i = 0; i < size; i++) {
        	tempOrbrows[i]=(ORBRow)tempList.get(i);
        }
        updateBuffer.rows = tempOrbrows; 
        updateBuffer.componentName = componentName;
        updateBuffer.setColumnProjectionLevel(getColumnProjectionLevel());

        String[][] refreshBuffer = save(updateBuffer, errorRows);//commit to db

        refreshRows(toBeRefreshedRows, columnCount, refreshBuffer);//refresh UI
    }
    /**
     * Now the server side transaction already committed, so refresh
     * will not cause exception, UI should be reset anyway
     * @param toBeRefreshedRows the Vector of store inserted or updated VSRow data row
     * @param columnCount the count of VSRow's column ,come from metaQuery
     * @param refreshBuffer return buffer after transaction committed
     */
    private void refreshRows(ArrayList toBeRefreshedRows, int columnCount,
            String[][] refreshBuffer) {
        int refreshedRowsSize= toBeRefreshedRows.size();
        boolean isTransactionInProgress = getSession().isTransactionInProgress();
        for (int j = 0; j < refreshedRowsSize; j++) {
            VSRow row = (VSRow)toBeRefreshedRows.get(j);
            for (int i = 1; i <= columnCount; i++) {
                VSData data = row.getData(i);
                int columnType = data.getColumnType();
                // ignore LOB columns' value, as they will not be refresh back from server for better performance
                if (getColumnProjectionLevel() != DataConst.ALLTYPES && columnType == DataConst.LONGVARBINARY ||
                		columnType == DataConst.LONGVARCHAR) {
                    continue;
                }
                Object rsValue = convertData(refreshBuffer[j][i - 1], i - 1);
                data.setObject(rsValue);
            }
            if (!isTransactionInProgress) {
                row.resetInsertedDeletedState();
            }
        }
    }

    /**
     * Method save.
     *
     * @param updateBuffer ORBRows
     * @param errorRows Vector
     * @return String[][]
     */
    protected String[][] save(ORBRows updateBuffer, Vector errorRows) {
        try {

            return getORBSession().save(updateBuffer);
            //  System.out.println("size of ret buf:"+ refreshBuffer.length );
        } catch (Exception ex) {
            if (isServerDownException(ex)) {
                boolean txInProgress = getSession().isTransactionInProgress();
                getSession().sessionTerminated();
                if (!txInProgress) {
                    return save(updateBuffer, errorRows);
                } else {
                    throw new ServerDownException(VFCMsgCode.SERVER_DOWN, ex);
                }
            } else {
                VSORBException orbEx = null;
                if (ex instanceof VSORBException) {
                    orbEx = (VSORBException)ex;
                } else if (ex instanceof RemoteException && ((RemoteException)ex).detail instanceof VSORBException) {
                    orbEx = (VSORBException)((RemoteException)ex).detail;
                }
                if (orbEx != null) {
                    // Construct Client Exception based on the info from ServerException
                    int index = orbEx.rowIndex;
                    if (index == -1) {
                        index = 0;
                    }

                    throw new VSDBException(orbEx, (VSRow)errorRows.elementAt(index));
                }
                throw new VSException(VFCMsgCode.SYSTEM_ERROR, ex);
            }
        }
    }

    class SessionFailedListener implements VSSessionFailedListener {

        /**
         * Method sessionTerminated.
         *
         * @param session VSSession
         * @return boolean
         * @see com.versata.tl.common.VSSessionFailedListener#sessionTerminated(VSSession)
         */
        public boolean sessionTerminated(VSSession session) {
            if (queryResponse != null && !fetchEnd) {
                fetchTerminated = true;
            }
            queryResponse = null;
            session.removeSessionFailedListener(this);
            return false;
        }

        /**
         * Method beforeReconnect.
         *
         * @param session VSSession
         * @return boolean
         * @see com.versata.tl.common.VSSessionFailedListener#beforeReconnect(VSSession)
         */
        public boolean beforeReconnect(VSSession session) {
            return false;
        }

        /**
         * Method reconnectFailed.
         *
         * @param session VSSession
         * @see com.versata.tl.common.VSSessionFailedListener#reconnectFailed(VSSession)
         */
        public void reconnectFailed(VSSession session) {
        }

        /**
         * Method afterReconnect.
         *
         * @param session VSSession
         * @see com.versata.tl.common.VSSessionFailedListener#afterReconnect(VSSession)
         */
        public void afterReconnect(VSSession session) {
        }
    }

    // To support execute same query multiple times
    private void resetFlagAndCounters() {
        rowIndex = 0;
        bufferSize = 0;
        fetchEnd = false;
        fetchTerminated = false;
        if (getSession() != null) {
            getSession().removeSessionFailedListener(sessionFailedListener);
        }

    }

    /**
     * Method getColumnProjectionLevel.
     *
     * @return short
     * @see XDAConnector#getColumnProjectionLevel()
     */
    public short getColumnProjectionLevel() {
        return columnProjectionLevel;
    }

    /**
     * Method setColumnProjectionLevel.
     *
     * @param level short
     * @see XDAConnector#setColumnProjectionLevel(short)
     */
    public void setColumnProjectionLevel(short level) {
        columnProjectionLevel = level;
    }

    /**
     * <br> Sets how many rows will be fetched from the JDBC resultset at once.
     *
     * @param count Number of rows that will be fetched at once.
     * @see com.versata.tl.vfc.dataaccess.XDAConnector#setMaxRowsPerFetch(int)
     */
    public void setMaxRowsPerFetch(int count) {
        maxRowsPerFetch = count;
    }

    /**
     * Method getMaxRowsPerFetch.
     *
     * @return int
     * @see XDAConnector#getMaxRowsPerFetch()
     */
    public int getMaxRowsPerFetch() {
        return maxRowsPerFetch;
    }

    /**
     * Method setPreFetchRowCount.
     *
     * @param preFetchOn boolean
     * @see XDAConnector#setPreFetchRowCount(boolean)
     */
    public void setPreFetchRowCount(boolean preFetchOn) {
        preFetchRowCount = preFetchOn;
    }

    /**
     * Method setServerPreFetch.
     *
     * @param preFetchOn boolean
     * @see XDAConnector#setServerPreFetch(boolean)
     */
    public void setServerPreFetch(boolean preFetchOn) {
        serverPreFetch = preFetchOn;
    }
    //From VSSession

    /**
     * Method getEnv.
     *
     * @return AppEnvironment
     */
    public AppEnvironment getEnv() {
        if (vsSession != null) {
            return vsSession.getEnv();
        }
        return null;
    }

    /**
     * Method init.
     *
     * @param session VSSession
     * @see com.versata.tl.common.XDAAppServerConnector#init(VSSession)
     */
    public void init(VSSession session) {
        initXDAConnector(session);
    }

    /**
     * Method connect.
     *
     * @param server String
     * @param login String
     * @param password String
     * @param appName String
     * @param repositoryName String
     * @param p_security_object VSSecurityObjectHolder
     * @return VSORBSession
     * @throws TierSessionLimitException
     * @see com.versata.tl.common.XDAAppServerConnector#connect(String, String, String, String, String, VSSecurityObjectHolder)
     */
    public VSORBSession connect(String server, String login, String password, String appName, String repositoryName, VSSecurityObjectHolder p_security_object)
        throws TierSessionLimitException {
        return null;
    }

    /**
     * Method connect.
     *
     * @param server String
     * @param login String
     * @param password String
     * @param appName String
     * @param repositoryName String
     * @param p_security_object VSSecurityObjectHolder
     * @param prob Properties
     * @return VSORBSession
     * @throws TierSessionLimitException
     * @see com.versata.tl.common.XDAAppServerConnector#connect(String, String, String, String, String, VSSecurityObjectHolder,
     *      Properties)
     */
    public VSORBSession connect(String server, String login, String password, String appName, String repositoryName, VSSecurityObjectHolder p_security_object, Properties prob)
        throws TierSessionLimitException {
        return null;
    }

    /**
     * Method connectJ2EE.
     *
     * @param newServer String
     * @param newLogin String
     * @param newPwd String
     * @param appName String
     * @param repositoryName String
     * @param security_object VSSecurityObjectHolder
     * @param ejbRefName String
     * @return VSORBSession
     * @throws TierSessionLimitException
     * @see com.versata.tl.common.XDAAppServerConnector#connectJ2EE(String, String, String, String, String, VSSecurityObjectHolder,
     *      String)
     */
    public VSORBSession connectJ2EE(String newServer, String newLogin, String newPwd, String appName, String repositoryName, VSSecurityObjectHolder security_object, String ejbRefName)
        throws TierSessionLimitException {
        throw new VSApiException(VSapiMsgCode.NOT_SUPPORTED);
    }

    /**
     * Method connectJNDI.
     *
     * @param newServer String
     * @param newLogin String
     * @param newPwd String
     * @param appName String
     * @param repositoryName String
     * @param security_object VSSecurityObjectHolder
     * @param JNDIName String
     * @return VSORBSession
     * @throws TierSessionLimitException
     * @see com.versata.tl.common.XDAAppServerConnector#connectJNDI(String, String, String, String, String, VSSecurityObjectHolder,
     *      String)
     */
    public VSORBSession connectJNDI(String newServer, String newLogin, String newPwd, String appName, String repositoryName, VSSecurityObjectHolder security_object, String JNDIName)
        throws TierSessionLimitException {
        throw new VSApiException(VSapiMsgCode.NOT_SUPPORTED);
    }

    /**
     * Method connectRepository.
     *
     * @param newServer String
     * @param newLogin String
     * @param newPwd String
     * @param appName String
     * @param repositoryName String
     * @param security_object VSSecurityObjectHolder
     * @return VSORBSession
     * @throws TierSessionLimitException
     * @see com.versata.tl.common.XDAAppServerConnector#connectRepository(String, String, String, String, String,
     *      VSSecurityObjectHolder)
     */
    public VSORBSession connectRepository(String newServer, String newLogin, String newPwd, String appName, String repositoryName, VSSecurityObjectHolder security_object)
        throws TierSessionLimitException {
        throw new VSApiException(VSapiMsgCode.NOT_SUPPORTED);
    }

    /**
     * Method isJ2EEClient.
     *
     * @return boolean
     * @see com.versata.tl.common.XDAAppServerConnector#isJ2EEClient()
     */
    public boolean isJ2EEClient() {
        return false;
    }

    /**
     * Method getVLSJNDIName.
     *
     * @return String
     * @see com.versata.tl.common.XDAAppServerConnector#getVLSJNDIName()
     */
    public String getVLSJNDIName() {
        throw new VSApiException(VSapiMsgCode.NOT_SUPPORTED);
    }

    /**
     * Method setVLSJNDIName.
     *
     * @param JNDIName String
     * @see com.versata.tl.common.XDAAppServerConnector#setVLSJNDIName(String)
     */
    public void setVLSJNDIName(String JNDIName) {
        throw new VSApiException(VSapiMsgCode.NOT_SUPPORTED);
    }

    /**
     * Method closeSession.
     *
     * @see com.versata.tl.common.XDAAppServerConnector#closeSession()
     */
    public void closeSession() {
    }

    /**
     * Method createRemoteObject.
     *
     * @param interface_name String
     * @return Object
     * @throws VSException
     * @see com.versata.tl.common.XDAAppServerConnector#createRemoteObject(String)
     */
    public Object createRemoteObject(String interface_name) throws VSException {
        return null;
    }

    /**
     * Method findObject.
     *
     * @param interface_name String
     * @param object_name String
     * @return Object
     * @see com.versata.tl.common.XDAAppServerConnector#findObject(String, String)
     */
    public Object findObject(String interface_name, String object_name) {
        return null;
    }

    /**
     * Method getAppServer.
     *
     * @return VSORBAppServer
     * @see com.versata.tl.common.XDAAppServerConnector#getAppServer()
     */
    public VSORBAppServer getAppServer() {
        return appServer;
    }

    /**
     * Method getMetaQueryFromServer.
     *
     * @param name String
     * @return VSMetaQuery
     * @see com.versata.tl.common.XDAAppServerConnector#getMetaQueryFromServer(String)
     */
    public VSMetaQuery getMetaQueryFromServer(String name) {
        try {
            return getMetaQueryFromServer(name, appServer);
        } catch (ServerDownException sdx) {
            if (getSession().sessionTerminated()) {
                return getMetaQueryFromServer(name);
            }
            throw sdx;
        }
    }

    /**
     * Method getMetaQueryFromServer.
     *
     * @param name String
     * @param appServer VSORBAppServer
     * @return VSMetaQuery
     * @see com.versata.tl.common.XDAAppServerConnector#getMetaQueryFromServer(String, VSORBAppServer)
     */
    public VSMetaQuery getMetaQueryFromServer(String name, VSORBAppServer appServer) {
        ByteArrayInputStream is = null;
        ObjectInputStreamLoader s = null;
        try {
             byte[] buf;

            if (appServer != null) {
                buf = appServer.getMetaQuery(vsSession.getDeployedProjectName(), name);
            } else {
                buf = getORBSession().getMetaQuery(vsSession.getDeployedProjectName(), name);
            }
            if (_LOGGER.isDebugEnabled()) {
                _LOGGER.debug(RuntimeMsgCode.XDAEJBCONNECTOR206, String.valueOf(buf.length));
            }
            // It's client code, don't use common SerializationUtil, review SVN Logs.
            is = new ByteArrayInputStream(buf);
            s = new ObjectInputStreamLoader(is, null);
            s.setObject(getSession());
            return (VSMetaQuery)s.readObject();
        } catch (VSORBException ex) {
            throw new VSException(ErrorMsgCode.VSMSG_ErrorGettingMetaData, ex);
        } catch (Exception ex) {
            isServerDown(ex);
            throw new VSException(ErrorMsgCode.VSMSG_ErrorGettingMetaData, ex);
        } finally {
            StreamUtils.closeStreams(s, is);
        }
    }

    private void isServerDown(Exception ex) {
        if (isServerDownException(ex)) {
            throw new ServerDownException(VFCMsgCode.SERVER_DOWN, ex);
        }
    }

    /**
     * Method getDatabaseTypeName.
     *
     * @return String
     * @see com.versata.tl.common.XDAAppServerConnector#getDatabaseTypeName()
     */
    public String getDatabaseTypeName() {
        String databaseTypeName;
        try {
            databaseTypeName = getORBSession().getDatabaseTypeName();
        } catch (Exception e) {
            if (isServerDownException(e)) {
                if (getSession().sessionTerminated()) {
                    return getDatabaseTypeName();
                }
            }
            throw new VSException(VFCMsgCode.FAILED_GET_DBTYPE, e);
        }

        return databaseTypeName;
    }

    /**
     * Method getLocaleStrings.
     *
     * @return String[]
     * @see com.versata.tl.common.XDAAppServerConnector#getLocaleStrings()
     */
    public String[] getLocaleStrings() {
        String[] l;
        try {
            l = getORBSession().getLocaleStrings();
        } catch (Exception e) {
            if (isServerDownException(e)) {
                if (getSession().sessionTerminated()) {
                    return getLocaleStrings();
                }
            }
            throw new VSException(VFCMsgCode.FAILED_GET_LOCALE, e);
        }

        return l;
    }

    /**
     * Method getMyPrivilegeToAppForm.
     *
     * @param appName String
     * @param formName String
     * @return boolean
     * @see com.versata.tl.common.XDAAppServerConnector#getMyPrivilegeToAppForm(String, String)
     */
    public boolean getMyPrivilegeToAppForm(String appName, String formName) {
        try {
            return getMyPrivilegeToAppForm(appName, formName, getORBSession());
        } catch (ServerDownException sdx) {
            if (getSession().sessionTerminated()) {
                return getMyPrivilegeToAppForm(appName, formName);
            }
            throw sdx;
        }
    }

    /**
     * Method getMyPrivilegeToAppForm.
     *
     * @param appName String
     * @param formName String
     * @param session VSORBSession
     * @return boolean
     * @see com.versata.tl.common.XDAAppServerConnector#getMyPrivilegeToAppForm(String, String, VSORBSession)
     */
    public boolean getMyPrivilegeToAppForm(String appName, String formName, VSORBSession session) {
        try {
            return session.getMyPrivilegeToAppForm(appName, formName);
        } catch (VSORBException ex) {
            throw new VSException(RuntimeMsgCode.XDAEJBCONNECTOR210, ex);
        } catch (Exception ex) {
            isServerDown(ex);
            throw new VSException(RuntimeMsgCode.XDAORBCONNECTOR954, ex);
        }
    }

    /**
     * Method getQuerySecurity.
     *
     * @param name String
     * @return Properties
     * @see com.versata.tl.common.XDAAppServerConnector#getQuerySecurity(String)
     */
    public Properties getQuerySecurity(String name) {
        try {
            return getQuerySecurity(name, getORBSession());
        } catch (ServerDownException sdx) {
            if (getSession().sessionTerminated()) {
                return getQuerySecurity(name);
            }
            throw sdx;
        }
    }

    /**
     * Method getQuerySecurity.
     *
     * @param name String
     * @param session VSORBSession
     * @return Properties
     * @see com.versata.tl.common.XDAAppServerConnector#getQuerySecurity(String, VSORBSession)
     */
    public Properties getQuerySecurity(String name, VSORBSession session) {
        try {
            Property[] inProps = session.getMyObjectPrivileges(name, DataConst.AppObjectTypeCodeImpl_BUSINESS_OBJECT);
            return Util.convertToJavaProps(inProps);
        } catch (VSORBException ex) {
            throw new VSException(RuntimeMsgCode.XDAEJBCONNECTOR210, ex);
        } catch (Exception ex) {
            isServerDown(ex);
            throw new VSException(RuntimeMsgCode.XDAEJBCONNECTOR212);
        }
    }

    /**
     * Method getUpdateableColumnSecurity.
     *
     * @param name String
     * @return Properties
     * @see com.versata.tl.common.XDAAppServerConnector#getUpdateableColumnSecurity(String)
     */
    public Properties getUpdateableColumnSecurity(String name) {
        try {
            return getUpdateableColumnSecurity(name, getORBSession());
        } catch (ServerDownException sdx) {
            if (getSession().sessionTerminated()) {
                return getUpdateableColumnSecurity(name);
            }
            throw sdx;
        }
    }

    /**
     * Method getUpdateableColumnSecurity.
     *
     * @param name String
     * @param session VSORBSession
     * @return Properties
     * @see com.versata.tl.common.XDAAppServerConnector#getUpdateableColumnSecurity(String, VSORBSession)
     */
    public Properties getUpdateableColumnSecurity(String name, VSORBSession session) {
        try {
            return Util.convertToJavaProps(session.getMyUpdateableColumnPrivileges(name));
        } catch (Exception ex) {
            return handleException(ex);
        }
    }

    private Properties handleException(Exception ex) {
        isServerDown(ex);
        throw new VSException(ErrorMsgCode.VSMSG_ErrorGettingSecData, ex);
    }

    /**
     * Method getNonViewableColumnSecurity.
     *
     * @param name String
     * @return Properties
     * @see com.versata.tl.common.XDAAppServerConnector#getNonViewableColumnSecurity(String)
     */
    public Properties getNonViewableColumnSecurity(String name) {
        try {
            return getNonViewableColumnSecurity(name, getORBSession());
        } catch (ServerDownException sdx) {
            if (getSession().sessionTerminated()) {
                return getNonViewableColumnSecurity(name);
            }
            throw sdx;
        }
    }

    /**
     * Method getNonViewableColumnSecurity.
     *
     * @param name String
     * @param session VSORBSession
     * @return Properties
     * @see com.versata.tl.common.XDAAppServerConnector#getNonViewableColumnSecurity(String, VSORBSession)
     */
    public Properties getNonViewableColumnSecurity(String name, VSORBSession session) {
        try {
            return Util.convertToJavaProps(session.getMyNonViewableColumnPrivileges(name));
        } catch (Exception ex) {
            handleException(ex);
        }
        return null; // this is never reached
    }

    /**
     * Method isServerDownException.
     *
     * @param th Throwable
     * @return boolean
     * @see XDAConnector#isServerDownException(Throwable)
     */
    public boolean isServerDownException(Throwable th) {
        //Will be implemented by its subclass
        return false;
    }

    private void readObject(ObjectInputStream s) throws ClassNotFoundException, IOException {
        s.defaultReadObject();
        if (!fetchEnd) {
            fetchTerminated = true;
        }
        env = getEnv();
        fetchEnd = true;
        metaQuery = vsSession.getMetaQuery(componentName);
        rowHolder = new RowSeqHolder();
        sessionFailedListener = new SessionFailedListener();
    }

    /**
     * Method setCursorPosition.
     *
     * @param position int
     * @return boolean
     * @throws VSORBException
     * @see XDAConnector#setCursorPosition(int)
     */
    public boolean setCursorPosition(int position) throws VSORBException {
        try {
            return queryResponse.setCursorPosition(position);
        } catch (Exception e) {
            throw new VSORBException(VFCMsgCode.SYSTEM_ERROR, e);
        }
    }

    /**
     * Method setRequestRandomAccessPosition.
     *
     * @param r int
     * @see XDAConnector#setRequestRandomAccessPosition(int)
     */
    public void setRequestRandomAccessPosition(int r) {
        requestRandomAccessPos = r;
    }

    /**
     * Method getRequestRandomAccessPosition.
     *
     * @return int
     * @see XDAConnector#getRequestRandomAccessPosition()
     */
    public int getRequestRandomAccessPosition() {
        return requestRandomAccessPos;
    }

    /**
     * Method setRequestRandomAccessRS.
     *
     * @param requestRA boolean
     * @see XDAConnector#setRequestRandomAccessRS(boolean)
     */
    public void setRequestRandomAccessRS(boolean requestRA) {
        if (requestRA) {
            requestRandomAccessPos = 1;
        } else {
            requestRandomAccessPos = -1;
        }
    }

    /**
     * Method getRequestRandomAccessRS.
     *
     * @return boolean
     * @see XDAConnector#getRequestRandomAccessRS()
     */
    public boolean getRequestRandomAccessRS() {
        return requestRandomAccessPos >= 0;
    }

    /**
     * Method getUseStatelessRS.
     *
     * @return boolean
     * @see XDAConnector#getUseStatelessRS()
     */
    public boolean getUseStatelessRS() {
        return blnIsAutoCloseResultSet;
    }

    /**
     * Method setUseStatelessRS.
     *
     * @param isAutoCloseResultSet boolean
     * @see XDAConnector#setUseStatelessRS(boolean)
     */
    public void setUseStatelessRS(boolean isAutoCloseResultSet) {
        blnIsAutoCloseResultSet = isAutoCloseResultSet;
    }

    /**
     * Method isUsingNativePoolForVersataReadTx.
     *
     * @param dataServerName String
     * @return boolean
     * @see XDAConnector#isUsingNativePoolForVersataReadTx(String)
     */
    public boolean isUsingNativePoolForVersataReadTx(String dataServerName) {

        if (_LOGGER.isDebugEnabled()) {
            _LOGGER.debug(" dataServerName :" + dataServerName);
            _LOGGER.debug(" componentName :" + componentName);
        }

        String value = "false";

        if (dataServerName == null) { // It must be a component name
            try {
                value = getORBSession().getDataServerProperty(componentName, "Use Native Pool for Versata Read Tx");
            } catch (Exception ex) {
                // Exeption will be thrown from server for security related business objects. These objects
                // doesn't have any dataserver. In this case we want to default to true.
                return true;
            }
        } else {
            try {
                Property[] prop = getORBSession().getDataServerProperties(dataServerName);
                for (int i = 0; i < prop.length; i++) {
                    if ("Use Native Pool for Versata Read Tx".equals(prop[i].name)) {
                        value = prop[i].value;
                    }
                }
            } catch (Exception ex) {
                // Exeption will be thrown from server for security related business objects. These objects
                // doesn't have any dataserver. In this case we want to default to true.
                return true;
            }
        }
        return Boolean.valueOf(value).booleanValue();
    }

    /**
     * Method getComponentName.
     *
     * @return String
     * @see XDAConnector#getComponentName()
     */
    public String getComponentName() {
        return componentName;
    }

    /**
     * Method getVLSEJBRefName.
     *
     * @return String
     */
    protected String getVLSEJBRefName() {
        return getEnv().getVLSEJBRefName();
    }

    /**
     * Method setVLSEJBRefName.
     *
     * @param ejbRefName String
     */
    protected void setVLSEJBRefName(String ejbRefName) {
        getEnv().setVLSEJBRefName(ejbRefName);
    }

    /**
     * Method isSecuritySession.
     *
     * @return boolean
     */
    protected boolean isSecuritySession() {
        return getEnv().isSecuritySession();
    }

    /**
     * Method getConnectType.
     *
     * @return int
     */
    protected int getConnectType() {
        return getEnv().getConnectType();
    }

    /**
     * Method setConnectType.
     *
     * @param connectType int
     */
    protected void setConnectType(int connectType) {
        getEnv().setConnectType(connectType);
    }

    /**
     * Method getAppName.
     *
     * @return String
     */
    protected String getAppName() {
        return getEnv().getAppName();
    }

    /**
     * Method getRepositoryName.
     *
     * @return String
     */
    protected String getRepositoryName() {
        return getEnv().getDeployedProjectName();
    }

    /**
     * Method isApplication.
     *
     * @return boolean
     */
    protected boolean isApplication() {
        return getEnv().isApplication();
    }

    /**
     * @return QueryRequest
     * @internal.tle Returns a new instance of QueryRequest
     */
    protected QueryRequest getNewQueryRequest() {
        return new QueryRequest();
    }

    /**
     * @return QueryResponse
     * @internal.tle Returns a new instance of QueryResponse
     */
    protected QueryResponse getNewQueryResponse() {
        return new QueryResponse();
    }

    /**
     * If this flag is enabled then the rows will be compressed by server before sending to client. Then the client will decompress the
     * rows. This value will override the "CompressResultSetRows" settings in the VFCResource properties
     *
     * @param isCompressRows boolean
     * @see XDAConnector#setIsCompressRows(boolean)
     */
    public void setIsCompressRows(boolean isCompressRows) {
        blnIsCompressRows = isCompressRows;
    }

    /**
     * @return boolean
     * @internal.tle
     */
    public boolean isCompressRows() {
        return blnIsCompressRows;
}
    }
