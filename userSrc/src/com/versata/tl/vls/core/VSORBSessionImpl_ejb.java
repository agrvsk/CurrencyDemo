package com.versata.tl.vls.core;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import javax.ejb.EJBObject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.transaction.UserTransaction;

import com.versata.tl.api.logging.VersataLogger;
import com.versata.tl.common.QueryRequest;
import com.versata.tl.common.QueryResponse;
import com.versata.tl.common.exception.ServerException;
import com.versata.tl.common.exception.ServerSecurityException;
import com.versata.tl.common.meta.VSMetaQuery;
import com.versata.tl.common.meta.VSMetaTable;
import com.versata.tl.common.text.AdminMsgCode;
import com.versata.tl.common.text.ErrorMsgCode;
import com.versata.tl.common.text.RuntimeMsgCode;
import com.versata.tl.common.transaction.Current;
import com.versata.tl.common.transaction.NoTransactionException;
import com.versata.tl.common.transaction.SubtransactionsUnavailableException;
import com.versata.tl.common.util.DataConst;
import com.versata.tl.common.util.Parameter;
import com.versata.tl.common.util.SearchRequest;
import com.versata.tl.common.util.Util;
import com.versata.tl.common.util.VLSClassLoader;
import com.versata.tl.common.vlsobject.VSORBException;
import com.versata.tl.common.vlsobject.VSORBResultSet;
import com.versata.tl.common.vstrace.VSTrace;
import com.versata.tl.common.vstrace.VSTraceHelper;
import com.versata.tl.util.SerializationUtil;
import com.versata.tl.vls.admin.AppDataSourceLocationImpl;
import com.versata.tl.vls.admin.AppRoleImpl;
import com.versata.tl.vls.admin.AppUserImpl;
import com.versata.tl.vls.cmdconsole.CMDConsoleServer;
import com.versata.tl.vls.dataaccess.BOCollectionImpl;
import com.versata.tl.vls.dataaccess.ResultSet;
import com.versata.tl.vls.dataaccess.VSORBResultSetImpl;
import com.versata.tl.vls.dataaccess.XDASQLConnector;
import com.versata.tl.vls.dataaccess.connection.Connection;
import com.versata.tl.vls.dataaccess.connection.VSJdbc;
import com.versata.tl.vls.dataaccess.connection.VSJdbcStatement;
import com.versata.tl.vls.dataaccess.sqlgenerator.SqlGeneratorFactory;
import com.versata.tl.vls.resource.AppServerResourceAccessorFactory;
import com.versata.tl.vls.service.GenericComponentFactory;
import com.versata.tl.vls.service.ServerEnvironment;
import com.versata.tl.vls.transaction.CurrentTransaction;

/**
 */
public abstract class VSORBSessionImpl_ejb extends VSORBSessionImpl_Base {
    private static final String _RCS_HEADER =
        "$Header: //depot/main/products/brms/runtime/src/core/com/versata/tl/vls/core/VSORBSessionImpl_ejb.java#2 $";

    static {
        VersataLogger.getRCSTraceLogger().trace(_RCS_HEADER);
    }

    protected static VersataLogger _LOGGER = VersataLogger.getLogger(VSORBSessionImpl_ejb.class);

    protected static Properties bundle;

    // this is the bean that holds this object, since the bean is cached by the appserver,
    // it (and this) will not be gc'ed unless we call remove on it.
    // For Corba, this variable is never set.
    protected EJBObject vlsContextBean;
    protected CurrentTransaction currentTransaction;
    static SessionsMonitor sessionsMonitor;
    
    /**
     * DO NOT CALL THIS CONSTRUCTOR DIRECTLY, as it will create numerous problems. To add a new session, please call
     * getSession(.....) on this server's instance of VSORBAppServerImpl.
     *
     * @param p_AppServer VSORBAppServerImpl
     * @param p_userName String
     * @param p_securitySession boolean
     * @param internalSession boolean
     * @throws ServerSecurityException
     */
    protected VSORBSessionImpl_ejb(VSORBAppServerImpl p_AppServer, String p_userName, boolean p_securitySession, boolean internalSession)
        throws ServerSecurityException {
        super(p_AppServer, p_userName, p_securitySession, internalSession);
    }

    /**
     * Constructor for VSORBSessionImpl_ejb.
     *
     * @param p_AppServer VSORBAppServerImpl
     * @param roleList Vector
     * @param p_userName String
     * @param p_securitySession boolean
     * @param internalSession boolean
     * @throws ServerSecurityException
     */
    protected VSORBSessionImpl_ejb(VSORBAppServerImpl p_AppServer, Vector roleList, String p_userName, boolean p_securitySession, boolean internalSession)
        throws ServerSecurityException {
        super(p_AppServer, roleList, p_userName, p_securitySession, internalSession);
    }

    /**
     * Constructor for VSORBSessionImpl_ejb.
     *
     * @param p_AppServer VSORBAppServerImpl
     * @param p_userName String
     * @param p_password String
     * @param p_clientAppName String
     * @param internalSession boolean
     * @param repositoryName String
     * @param p_securitySession boolean
     * @throws ServerSecurityException
     */
    protected VSORBSessionImpl_ejb(VSORBAppServerImpl p_AppServer, String p_userName, String p_password, String p_clientAppName, boolean internalSession, String repositoryName, boolean p_securitySession)
        throws ServerSecurityException {

        sessionIDForTracing = Integer.toString(System.identityHashCode(this));
        setProperty(VST_SESSION_ID_PROPERTY, sessionIDForTracing);

        //Session info gathered after authentication
        theAppServer = p_AppServer;
        userName = p_userName;
        password = p_password;
        setRepositoryName(repositoryName);
        m_appName = p_clientAppName;
        //setSecuritySession(p_securitySession);
        securitySession = p_securitySession;
        // not sure :(
        VLSClassLoader.create(repositoryName, ServerEnvironment.getComponentClassPath());
        
        if (authenticateUser(new SecurityObject(p_userName, p_password), p_clientAppName, internalSession, true)) {
            // any failure is returned as an exception
            //_transactionContext = new TransactionContextImpl(this);

            // change this to be passed in as parameter
            setExpiryTime();
        }

        // Create a sessions monitor
        if (sessionsMonitor == null) {
            sessionsMonitor = new SessionsMonitor(theAppServer);
            sessionsMonitor.start();
        }
    }

    private void setExpiryTime() {
        if (m_appName != null && "VersataESM".equalsIgnoreCase(m_appName)) {
            setExpireTime(40000); //40 seconds
        } else {
            try {
                String timeoutStr = theAppServer.getProperty("SessionTimeout");
                setExpireTime(1000 * Integer.parseInt(timeoutStr));
            } catch (Exception ex) {
                setExpireTime(60000 * 5); //5 minutes for timeout default
            }
        }
    }
    //SANJAY Security Code Begin

    /**
     * DO NOT CALL THIS CONSTRUCTOR DIRECTLY, as it will create numerous problems. To add a new session, please call
     * getSession(.....) on this server's instance of VSORBAppServerImpl.
     *
     * @param p_AppServer VSORBAppServerImpl
     * @param roleList Vector
     * @param p_userName String
     * @param p_password String
     * @param p_clientAppName String
     * @param internalSession boolean
     * @param repository String
     * @param p_securitySession boolean
     * @throws ServerSecurityException
     */
    protected VSORBSessionImpl_ejb(VSORBAppServerImpl p_AppServer, Vector roleList, String p_userName, String p_password, String p_clientAppName, boolean internalSession, String repositoryName, boolean p_securitySession)
        throws ServerSecurityException {

        sessionIDForTracing = Integer.toString(System.identityHashCode(this));
        setProperty(VST_SESSION_ID_PROPERTY, sessionIDForTracing);

        //Session info gathered after authentication
        if (roleList == null || roleList.size() == 0) {
            throw new ServerSecurityException(ErrorMsgCode.VSMSG_SecurityNotEnabled);
        }
        theAppServer = p_AppServer;
        userName = p_userName;
        password = p_password;
        setRepositoryName(repositoryName);
        m_appName = p_clientAppName;
        //securitySession = p_securitySession;
        securitySession = p_securitySession;
        m_roleList = new Vector();
        m_roleList.addElement(getRoleForRoleName("Public"));
        for (int i = 1; i <= roleList.size(); i++) {
            AppRoleImpl rl = getRoleForRoleName(roleList.elementAt(i - 1).toString());
            if (rl != null) {
                m_roleList.addElement(rl);
            }
        }
        if (m_roleList.size() == 0) {
            throw new ServerSecurityException(ErrorMsgCode.VSMSG_NoRoles);
        }

        // not sure :(
        VLSClassLoader.create(repositoryName, ServerEnvironment.getComponentClassPath());
        if (authenticateUser(roleList, new SecurityObject(p_userName, p_password), p_clientAppName, internalSession)) {
            // any failure is returned as an exception
            //_transactionContext = new TransactionContextImpl(this);

            // change this to be passed in as parameter
            setExpiryTime();
        }
    }

    public void releaseRemoteReferenceForSecuritySession() {
        ServerEnvironment.getFactoryImpl().releaseRemoteReference(remoteReferenceSecuritySession);
        remoteReferenceSecuritySession = null;
    }

    /**
     * Method authenticateUser.
     *
     * @param roleList Vector
     * @param secObject SecurityObject
     * @param clientAppName String
     * @param internalSession boolean
     * @return boolean
     * @throws ServerSecurityException
     */
    protected boolean authenticateUser(Vector roleList, SecurityObject secObject, String clientAppName, boolean internalSession)
        throws ServerSecurityException {

        // User is preAuthenticated.
        Parameter[] filter = new Parameter[1];
        filter[0] = new Parameter("AppUser", "UserName", "System Administrator");
        userComponent = (AppUserImpl)AppUserImpl.getObjectByKey(new SearchRequest(filter), getServer().getInternalSession());

        if (secObject != null) { // Fix for 42350
            userComponent.setAppSvrLoginID(secObject.getLoginID());
            userComponent.setAppSvrPassword(secObject.getPassword());
            userComponent.setUserName(secObject.getLoginID());
        }

        try {
            Properties props = getRoleProperties(roleList);

            if (((Boolean)props.get(DataConst.AppRoleImpl_SYSADMIN)).booleanValue()) {
                return true;
            }

            if (!((Boolean)props.get(DataConst.AppRoleImpl_CONNECT)).booleanValue()) {
                throw new ServerSecurityException(AdminMsgCode.NO_APPLICATION_EXECUTE_PRIV);
            }

            if (isSecuritySession()) {
                if (!((Boolean)props.get(DataConst.AppRoleImpl_SECADMIN)).booleanValue()) {
                    throw new ServerSecurityException(AdminMsgCode.NO_APPLICATION_EXECUTE_PRIV);
                }

                if (isConsoleSession()) {
                    return true;
                }
            }

            if (clientAppName != null) {
                if (!getMyPrivilegeToObjectNameInternal(DataConst.AppObjectPrivilegeImpl_EXECUTE, clientAppName,
                    DataConst.AppObjectTypeCodeImpl_APPLICATION_OBJECT)) {
                    throw new ServerSecurityException(AdminMsgCode.NO_APPLICATION_EXECUTE_PRIV);
                }
            }

        } catch (VSORBException e) {
            throw new ServerSecurityException(AdminMsgCode.NO_APPLICATION_EXECUTE_PRIV, null, e);
        } catch (ServerSecurityException e) {
            throw e;
        } catch (Throwable e) {
            throw new ServerSecurityException(AdminMsgCode.NO_APPLICATION_EXECUTE_PRIV, null, (Exception)e);
        }

        return true;
    }

    /**
     * @param SQL Any valid SQL query statement in String format
     * @param dataServerName an Unique name to identify a data server, its properties will direct session how to make a connection
     * to data source
     * @param maxRowsPerFetch Number of rows will be sent back to client at a time
     * @return ResultSet            a remote resultset handle
     * @throws VSORBException
     * @throws com.versata.tl.common.vlsobject.VSORBException Data return from this resultset are read only
     * @see Session#getResultSetBySQL(String, String, int)
     * @deprecated as of 11/18/03. Use executeQuery(Object queryRequest) Query object on the data source and create a result set
     *             through direct SQL
     */
    public ResultSet getResultSetBySQL(String SQL, String dataServerName, int maxRowsPerFetch) throws VSORBException {
        // implement operation...

        // set user and session id
        VSTraceHelper trh = null;
        if (VSTrace.IS_ON) {
            trh = new VSTraceHelper(_LOGGER, "VSORBSessionImpl_ejb.getResultSetBySQL");
            trh.set(VST_USER, getUserID());
            trh.set(VST_SESSION_ID, sessionIDForTracing);
        }

        //Create the object and register with BOA
        VSORBResultSetImpl aResultSet = null;
        try {
            XDASQLConnector xdac = new XDASQLConnector();
            Properties props = getMyDataServiceLogin(dataServerName);

            String allowQuery = props.getProperty("SQL Allowed");
            if (allowQuery == null || !"True".equalsIgnoreCase(allowQuery)) {
                throw new ServerException(AdminMsgCode.NO_EXEC_SQL, dataServerName);
            }

            xdac.setProperties(props);
            //If this session has transaction in progress
            //then use the connection from transaction else get a connection from pool.
            Connection conn;
            if (isTransactionInProgress()) {
                conn = getTransactionInfo().getConnection(xdac);
            } else {
                conn = getConnection(xdac, true);
            }
            aResultSet = new VSORBResultSetImpl(SQL, maxRowsPerFetch, xdac, conn);

//		 this.appendTraceString("Reading via SQL: " + SQL, true);
            //addServerEvent("Reading via SQL", SQL, Session.DB_EVENT);

        } catch (ServerException se) {
            throw ServerEnvironment.createORBException(se);
        } catch (Throwable e) {
            return handleThrowableException(e);
        } finally {
            if (trh != null) {
                trh.end();
            }
        }
        return aResultSet;
    }

    private ResultSet handleThrowableException(Throwable e) {
        if (e instanceof VSORBException) {
            throw (VSORBException)e;
        }
        // Log the error trace in baslog.out
        throw new VSORBException(ErrorMsgCode.VSMSG_UnCheckedException, e);
    }

    /**
     * @param SQL String
     * @param dataServerName String
     * @param maxRowsPerFetch int
     * @param prefetch boolean
     * @param randomAccessPos int
     * @param isAutoCloseResultSet boolean
     * @return VSORBResultSet
     * @throws VSORBException
     * @internal.tle
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getResultSetBySQLRemote1(String, String, int, boolean, int,
     *      boolean)
     * @deprecated as of 11/18/03. Use executeQuery(Object queryRequest)
     */
    public VSORBResultSet getResultSetBySQLRemote1(String SQL, String dataServerName, int maxRowsPerFetch, boolean prefetch, int randomAccessPos, boolean isAutoCloseResultSet)
        throws VSORBException {

        VSORBResultSet remoteResultSet = null;
        try {

            QueryRequest qr = getNewQueryRequest();
            qr.setSQL(SQL);
            qr.setDataServerName(dataServerName);
            qr.setMaxRowsPerFetch(maxRowsPerFetch);
            qr.setServerPreFetch(prefetch);
            qr.setRequestRandomAccessPos(randomAccessPos);
            qr.setUseStatelessRS(isAutoCloseResultSet);
            if (_LOGGER.isDebugEnabled()) {
                _LOGGER.debug("VSORBSessionImpl_ejb.getResultSetBySQLRemote1 -> " + qr.toString());
            }

            ResultSet resultSet = getResultSetBySQLRemote1(qr);

            if (getCoLocated()) {
                remoteResultSet = ((VSORBResultSetImpl)resultSet).getWrapper();
            } else {
                remoteResultSet = ((VSORBResultSetImpl)resultSet).getRemoteReference();
            }

        } catch (ServerException se) {
            throw ServerEnvironment.createORBException(se);
        } catch (Throwable e) {
            handleThrowableException(e);
        }
        return remoteResultSet;
    }

    private ResultSet getResultSetBySQLRemote1(QueryRequest qreq) throws VSORBException {

        String SQL = qreq.getSQL();
        String dataServerName = qreq.getDataServerName();
        int maxRowsPerFetch = qreq.getMaxRowsPerFetch();
        boolean prefetch = qreq.getServerPreFetch();
        int randomAccessPos = qreq.getRequestRandomAccessPos();
        boolean isAutoCloseResultSet = qreq.getUseStatelessRS();
        String componentName = qreq.getComponentName();
        String packageName = VSRepositoryMetaCache.get(getRepositoryName()).getPackageName(componentName);

        boolean useJTS = Boolean.valueOf(getServerProperty("usejts")).booleanValue();
        Properties props = getMyDataServiceLogin(dataServerName);

        String dataSourceType;
        if (Boolean.valueOf(props.getProperty("Use External Connection Pooling")).booleanValue()) {
            dataSourceType = props.getProperty("DriverTypeForExternalPool");
        } else {
            dataSourceType = props.getProperty("DriverType");
        }

        boolean useNativePoolForVersataReadTx = Boolean.valueOf(props.getProperty("Use Native Pool for Versata Read Tx", "true"))
            .booleanValue();
        boolean isUsingXADriver = Boolean.valueOf(props.getProperty("Is Using XA Driver", "false")).booleanValue();

        if (_LOGGER.isDebugEnabled()) {
            _LOGGER.debug("VSORBSessionImpl_ejb.getResultSetBySQLRemote1 ->  isAutoCloseResultSet :" + isAutoCloseResultSet +
                "getPackageName() :" + packageName + "dataServerName :" + dataServerName +
                "Use Native Pool for Versata Read Tx :" + useNativePoolForVersataReadTx + "isUsingXADriver :" + isUsingXADriver +
                "useJTS :" + useJTS + "isTransactionInProgress :" + isTransactionInProgress() + "dataSourceType :" +
                dataSourceType);
        }

        validateDriverType(dataSourceType, dataServerName);
        validateDataServerConfiguration(isAutoCloseResultSet, isUsingXADriver, useNativePoolForVersataReadTx);

        if (isAutoCloseResultSet && useJTS && !useNativePoolForVersataReadTx && !isSecuritySession() && !isConsoleSession()) {
            //return getResultSetBySQLRemote1Tx(SQL,dataServerName,maxRowsPerFetch,prefetch, randomAccessPos,isAutoCloseResultSet);
            return getResultSetBySQLRemote1Tx(qreq);
        } else {
            ResultSet resultset = null;
            try {
                resultset = getResultSetBySQL1(SQL, dataServerName, maxRowsPerFetch, prefetch, randomAccessPos);

                resultset = setQueryRequest(isAutoCloseResultSet, qreq, resultset);
            } catch (Exception ex) {
                _LOGGER.error(ex);
            }
            return resultset;
        }
    }

    private ResultSet setQueryRequest(boolean autoCloseResultSet, QueryRequest qreq, ResultSet resultset) {
        if (autoCloseResultSet) {
            VSQueryResultsImpl queryResults = new VSQueryResultsImpl(this);
            queryResults.setQueryRequest(qreq);
            queryResults.fetchAllRows(resultset);
            resultset = queryResults;
        } else {
            resultset.setQueryRequest(qreq);
        }
        return resultset;
    }

    private void validateDriverType(String dataSourceType, String dataServerName) {
        // Check for the driver type in the data server. Throws exception if the driver type is null.
        // This is also checked in the lower driver layers, but doing it at this high level is more reliable...
    	
    	
    	 
        if ((dataSourceType == null || "".equals(dataSourceType)) && !isSecuritySession() && !isConsoleSession()) {
            throw ServerEnvironment.createORBException(new ServerException(ErrorMsgCode.VSMSG_MissingDriverType, dataServerName));
        }
    }

    private ResultSet getResultSetBySQLRemote1Tx(QueryRequest qreq) throws VSORBException {

        ResultSet resultset = null;

        String SQL = qreq.getSQL();
        String dataServerName = qreq.getDataServerName();
        int maxRowsPerFetch = qreq.getMaxRowsPerFetch();
        boolean prefetch = qreq.getServerPreFetch();
        int randomAccessPos = qreq.getRequestRandomAccessPos();
        boolean isAutoCloseResultSet = qreq.getUseStatelessRS();

        synchronized (readTxLock) {
            try {
                if (!isTransactionInProgress()) {
                    beginTransaction();
                    IStartedTx = true;
                    setReadTransactionInProgress(true);
                    if (_LOGGER.isDebugEnabled()) {
                        _LOGGER.debug("VSORBSessionImpl_ejb.getResultSetBySQLRemote1Tx <<< Read Transaction Started >>>");
                    }
                }

                VSORBResultSetImpl aResultSet =
                    (VSORBResultSetImpl)getResultSetBySQL1(SQL, dataServerName, maxRowsPerFetch, prefetch, randomAccessPos);

                if (isAutoCloseResultSet) {
                    VSQueryResultsImpl queryResults = new VSQueryResultsImpl(this);
                    queryResults.setQueryRequest(qreq);
                    queryResults.fetchAllRows(aResultSet);
                    resultset = queryResults;
                } else {
                    aResultSet.setQueryRequest(qreq);
                    resultset = aResultSet;
                }

                if (IStartedTx && isTransactionInProgress()) {
                    commit();
                    IStartedTx = false;
                    setReadTransactionInProgress(false);
                    if (_LOGGER.isDebugEnabled()) {
                        _LOGGER.debug("VSORBSessionImpl_ejb.getResultSetBySQLRemote1Tx <<< Read Transaction Committed >>>");
                    }
                }
            } catch (Exception ex) {
                _LOGGER.error(ex);
            } finally {
                try {
                    if (IStartedTx && isTransactionInProgress()) {
                        rollback();
                        IStartedTx = false;
                        setReadTransactionInProgress(false);
                        if (_LOGGER.isDebugEnabled()) {
                            _LOGGER.debug("VSORBSessionImpl_ejb.getResultSetBySQLRemote1Tx <<< Read Transaction Rolled back >>>");
                        }
                    }
                } catch (NoTransactionException noTxException) {
                    _LOGGER.warn(noTxException);
                } catch (Exception ex) {
                    _LOGGER.error(ex);
                }
            }
        }
        return resultset;
    }

    /**
     * @param isAutoCloseResultSet boolean
     * @param isUsingXADriver boolean
     * @param useNativePoolForVersataReadTx boolean
     * @throws VSORBException
     * @internal.tle
     */
    public void validateDataServerConfiguration(boolean isAutoCloseResultSet, boolean isUsingXADriver, boolean useNativePoolForVersataReadTx)
        throws VSORBException {
        if (!isAutoCloseResultSet) {
            if (isUsingXADriver && !useNativePoolForVersataReadTx) {
                throw new VSORBException(AdminMsgCode.INVALID_CONFIG);
            }
        }
    }

    /**
     * @param qr Object
     * @return Object
     * @throws VSORBException
     * @internal.tle Generic method to execute the query.
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#executeQuery(Object)
     */
    public Object executeQuery(QueryRequest qr) throws VSORBException {
        QueryRequest qreq = (QueryRequest)qr;
        QueryResponse qres = getNewQueryResponse();

        qres.setQueryRequest(qreq);
        try {

            if (_LOGGER.isDebugEnabled()) {
                _LOGGER.debug("VSORBSessionImpl_ejb.executeQuery qreq -> " + qreq);
            }
            ResultSet resultSet;

            if (qreq.getUseCache()) {
                if (_LOGGER.isDebugEnabled()) {
                    _LOGGER.debug("VSORBSessionImpl_ejb.executeQuery Using Cache");
                }
                resultSet = getResultSetFromCache(qreq);
            } else if (qreq.isAdhocQuery()) {
                if (_LOGGER.isDebugEnabled()) {
                    _LOGGER.debug("VSORBSessionImpl_ejb.executeQuery is AdhocQuery");
                }
                resultSet = getResultSetBySQLRemote1(qreq);
            } else {
                if (_LOGGER.isDebugEnabled()) {
                    _LOGGER.debug("VSORBSessionImpl_ejb.executeQuery going directly to the source");
                }
                resultSet = getResultSetByRequest1(qreq);
            }

            if (qreq.getUseStatelessRS()) {

                if (getCoLocated()) {
                    qres.setRowsAsObjects(((VSQueryResultsImpl)resultSet).localFetch());
                } else {
                    qres.setRows(resultSet.fetchRows());
                }

                if (qreq.getPrefetchRowCount()) {
                    qres.setRowCount(((VSQueryResultsImpl)resultSet).getPreFetchCount());
                }

                qres.setMetaColumn(resultSet.registerMetaData());
            } else {

                VSQueryResultsImpl queryResults = new VSQueryResultsImpl(this);
                queryResults.setQueryRequest(qreq);
                queryResults.fetchAllRows(resultSet);
                VSORBResultSet remoteResultSet;

                if (qreq.getUseCache()) {
                    if (getCoLocated()) {
                        qres.setRowsAsObjects(queryResults.localFetch());
                        if (queryResults.hasMoreRows()) {
                            remoteResultSet = ((BOCollectionImpl)resultSet).getWrapper();
                            qres.setRS(remoteResultSet);
                        }
                    } else {
                        qres.setRows(queryResults.fetchRows());
                        if (queryResults.hasMoreRows()) {
                            remoteResultSet = ((BOCollectionImpl)resultSet).getRemoteReference();
                            qres.setRS(remoteResultSet);
                        }

                    }

                } else {

                    if (getCoLocated()) {
                        qres.setRowsAsObjects(queryResults.localFetch());
                        if (queryResults.hasMoreRows()) {
                            remoteResultSet = ((VSORBResultSetImpl)resultSet).getWrapper();
                            qres.setRS(remoteResultSet);
                        }
                    } else {
                        qres.setRows(queryResults.fetchRows());
                        if (queryResults.hasMoreRows()) {
                            remoteResultSet = ((VSORBResultSetImpl)resultSet).getRemoteReference();
                            qres.setRS(remoteResultSet);
                            System.out.println("VSORBSessionImpl_ejb executeQuery(qr) respons förses med Remote pekare");
                        }
                        else
                        {
                            System.out.println("VSORBSessionImpl_ejb executeQuery(qr) respons saknar Remote pekare");
                        }
                    }
                }

                if (qreq.getPrefetchRowCount()) {
                    qres.setRowCount(queryResults.getPreFetchCount());
                }

                qres.setMetaColumn(queryResults.registerMetaData());
            }
        } catch (VSORBException e) {
            throw e;
        } catch (ServerException se) {
            throw Util.createORBException(se);
        } catch (Throwable e) {
            handleThrowableException(e);
        }
        return qres;
    }

    /**
     * @param qr byte[]
     * @return byte[]
     * @throws VSORBException
     * @internal.tle Generic method to execute the query.
     */
    public byte[] executeQuery(byte[] qr) throws VSORBException {
        QueryResponse qres = (QueryResponse)executeQuery((QueryRequest)SerializationUtil.deserializeFromByteArray(qr, QueryResponse.class));
        return SerializationUtil.serializeToByteArray(qres);
    }

    /**
     * @param componentName Name of Business object to be retrieved
     * @param filterInByteArray SearchRequest in binary stream form
     * @param sorterInByteArray SearchRequest in binary stream form
     * @param maxRowsPerFetch Number of rows will be sent back to client per fetch
     * @param columnProjectionLevel what kind of columns will be selected
     * @param prefetch boolean
     * @param randomAccessPos int
     * @param isAutoCloseResultSet boolean
     * @return VSORBResultSet    a remote resultset handle
     * @throws VSORBException
     * @throws com.versata.tl.common.vlsobject.VSORBException
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getResultSetByRequest1(String, byte[], byte[], int, short,
     *      boolean, int, boolean)
     * @deprecated as of 11/18/03. Use executeQuery(Object queryRequest) Query object on the data source and create a result set
     */
    public VSORBResultSet getResultSetByRequest1(String componentName, byte[] filterInByteArray, byte[] sorterInByteArray, int maxRowsPerFetch, short columnProjectionLevel, boolean prefetch, int randomAccessPos, boolean isAutoCloseResultSet)
        throws VSORBException {
        VSORBResultSet remoteResultSet = null;

        try {
            QueryRequest qr = getNewQueryRequest();
            qr.setComponentName(componentName);
            qr.setFilter(filterInByteArray);
            qr.setSorter(sorterInByteArray);
            qr.setMaxRowsPerFetch(maxRowsPerFetch);
            qr.setColumnProjectionLevel(columnProjectionLevel);
            qr.setServerPreFetch(prefetch);
            qr.setRequestRandomAccessPos(randomAccessPos);
            qr.setUseStatelessRS(isAutoCloseResultSet);
            if (_LOGGER.isDebugEnabled()) {
                _LOGGER.debug("VSORBSessionImpl_ejb.getResultSetByRequest1 -> " + qr.toString());
            }

            ResultSet resultSet = getResultSetByRequest1(qr);

            if (getCoLocated()) {
                remoteResultSet = ((VSORBResultSetImpl)resultSet).getWrapper();
            } else {
                remoteResultSet = ((VSORBResultSetImpl)resultSet).getRemoteReference();
            }

        } catch (ServerException se) {
            throw ServerEnvironment.createORBException(se);
        } catch (Throwable e) {
            handleThrowableException(e);
        }
        return remoteResultSet;
    }

    /**
     * @param qreq The query request.
     * @return ResultSet   local resultset.
     * @throws VSORBException
     * @throws com.versata.tl.common.vlsobject.VSORBException
     */
    protected ResultSet getResultSetByRequest1(QueryRequest qreq) throws VSORBException {
        VSTraceHelper trh = null;
        if (VSTrace.IS_ON) {
            trh = new VSTraceHelper(_LOGGER, "VSORBSessionImpl.getResultSetByRequest1");
            trh.set(VST_USER, getUserID());
            trh.set(VST_SESSION_ID, sessionIDForTracing);
        }

        ResultSet resultset = null;

        String componentName = qreq.getComponentName();
        int maxRowsPerFetch = qreq.getMaxRowsPerFetch();
        short columnProjectionLevel = qreq.getColumnProjectionLevel();
        boolean prefetch = qreq.getServerPreFetch();
        int randomAccessPos = qreq.getRequestRandomAccessPos();
        boolean isAutoCloseResultSet = qreq.getUseStatelessRS();
        String packageName = VSRepositoryMetaCache.get(getRepositoryName()).getPackageName(componentName);

        try {
            SearchRequest filter = (SearchRequest)SerializationUtil.deserializeFromByteArray(qreq.getFilter(), SearchRequest.class);
            SearchRequest sorter = (SearchRequest)SerializationUtil.deserializeFromByteArray(qreq.getSorter(), SearchRequest.class);
            qreq.setSorterAsSR(sorter);
            qreq.setFilterAsSR(filter);

            //There is no data server for security object.
            String dataServerName = null;
            boolean useJTS = Boolean.valueOf(getServerProperty("usejts")).booleanValue();
            boolean useNativePoolForVersataReadTx = true;
            boolean isUsingXADriver = false;
            String dataSourceType = null;

            if (!"com.versata.tl.vls.admin".equals(packageName)&&(!"VLSWebConsole".equals(packageName))) {
                if (Boolean.valueOf(getDataServerProperty(componentName, "Use External Connection Pooling")).booleanValue()) {
                    dataSourceType = getDataServerProperty(componentName, "DriverTypeForExternalPool");
                } else {
                    dataSourceType = getDataServerProperty(componentName, "DriverType");
                }
                dataServerName = getDataServerForObject(componentName);
                useNativePoolForVersataReadTx = Boolean
                    .valueOf(getDataServerProperty(componentName, "Use Native Pool for Versata Read Tx")).booleanValue();
                isUsingXADriver = Boolean.valueOf(getDataServerProperty(componentName, "Is Using XA Driver"))
                    .booleanValue();
            }

            if (_LOGGER.isDebugEnabled()) {
                _LOGGER.debug("VSORBSessionImpl_ejb.getResultSetByRequest1 -> isAutoCloseResultSet : " + isAutoCloseResultSet +
                    " componentName : " + componentName + " getPackageName() :" + packageName + " dataServerName : " +
                    dataServerName + " Use Native Pool for Versata Read Tx : " + useNativePoolForVersataReadTx + " useJTS : " +
                    useJTS + " isUsingXADriver : " + isUsingXADriver + " isTransactionInProgress : " + isTransactionInProgress() +
                    " dataSourceType : " + dataSourceType);
            }

            validateDriverType(dataSourceType, dataServerName);
            validateDataServerConfiguration(isAutoCloseResultSet, isUsingXADriver, useNativePoolForVersataReadTx);

            if (isAutoCloseResultSet && useJTS && !useNativePoolForVersataReadTx && !isSecuritySession() && !isConsoleSession()) {
                //return getResultSetByRequest1Tx(componentName,filter,sorter,maxRowsPerFetch,columnProjectionLevel,prefetch, randomAccessPos, isAutoCloseResultSet);
                return getResultSetByRequest1Tx(qreq);
            } else {

                VSORBResultSetImpl aResultSet = (VSORBResultSetImpl)GenericComponentFactory.getResultSet(packageName,
                    componentName, filter, sorter, maxRowsPerFetch, columnProjectionLevel, randomAccessPos, (VSORBSessionImpl)this);

                if (prefetch) {
                    aResultSet.enablePreFetch();
                }

                if (isAutoCloseResultSet) {
                    VSQueryResultsImpl queryResults = new VSQueryResultsImpl(this);
                    queryResults.setQueryRequest(qreq);
                    queryResults.fetchAllRows(aResultSet);
                    resultset = queryResults;
                } else {
                    resultset = aResultSet;
                }
                resultset.setQueryRequest(qreq);
            }

        } catch (ServerException se) {
            throw ServerEnvironment.createORBException(se);
        } catch (VSORBException e) {
            throw e;
        } catch (Throwable e) {
            handleThrowableException(e);
        } finally {
            if (trh != null) {
                trh.end();
            }
        }
        return resultset;
    }

    private ResultSet getResultSetByRequest1Tx(QueryRequest qreq) throws VSORBException {

        ResultSet resultset = null;

        String componentName = qreq.getComponentName();
        SearchRequest filter = qreq.getFilterAsSR();
        SearchRequest sorter = qreq.getSorterAsSR();
        int maxRowsPerFetch = qreq.getMaxRowsPerFetch();
        short columnProjectionLevel = qreq.getColumnProjectionLevel();
        int randomAccessPos = qreq.getRequestRandomAccessPos();
        boolean isAutoCloseResultSet = qreq.getUseStatelessRS();

        synchronized (readTxLock) {
            boolean IStartedTx = false;
            try {

                if (!isTransactionInProgress()) {
                    beginTransaction();
                    IStartedTx = true;
                    setReadTransactionInProgress(true);
                    if (_LOGGER.isDebugEnabled()) {
                        _LOGGER.debug("<<< Read Transaction Started >>>");
                    }
                }

                String packageName = VSRepositoryMetaCache.get(getRepositoryName()).getPackageName(componentName);
                resultset = GenericComponentFactory.getResultSet(packageName, componentName, filter, sorter, maxRowsPerFetch,
                    columnProjectionLevel, randomAccessPos, (VSORBSessionImpl)this);

                resultset = setQueryRequest(isAutoCloseResultSet, qreq, resultset);

                if (IStartedTx && isTransactionInProgress()) {
                    commit();
                    IStartedTx = false;
                    setReadTransactionInProgress(false);
                    if (_LOGGER.isDebugEnabled()) {
                        _LOGGER.debug("<<< Read Transaction Committed >>>");
                    }
                }

            } catch (ServerException se) {
                _LOGGER.warn(se);
                throw ServerEnvironment.createORBException(se);

            } catch (Throwable e) {
                handleThrowableException(e);
            } finally {

                try {
                    if (IStartedTx && isTransactionInProgress()) {
                        rollback();
                        IStartedTx = false;
                        setReadTransactionInProgress(false);
                        if (_LOGGER.isDebugEnabled()) {
                            _LOGGER.debug("<<< Read Transaction Rolled back >>>");
                        }
                    }
                } catch (NoTransactionException noTxException) {
                    Util.logWarning(_LOGGER, noTxException);
                } catch (Exception ex) {
                    _LOGGER.error(ex);
                }
            }
        }
        return resultset;
    }

    /**
     * Method refresh.
     *
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#refresh()
     */
    public void refresh() {
        theAppServer.refreshSecurityData();
    }

    /**
     * Method refreshRepositorySecurityData.
     *
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#refresh()
     */
    public void refreshRepoSecurityData() {
        theAppServer.refreshRepoSecurityData();
    }
    
    protected static final Hashtable sessionTxMap = new Hashtable(17, 0.7f);
    protected static final Hashtable sessionTxMapReverse = new Hashtable(17, 0.7f);
    protected Throwable txException;

    // TODO: make beginTrans() abstract

    /**
     * Method begin.
     *
     * @return Current
     * @throws SubtransactionsUnavailableException
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#begin()
     */
    public Current begin() throws SubtransactionsUnavailableException {
        Current current = ((VSORBSessionImpl)this).beginTrans(false);
        ((CurrentTransaction)current).registerRemoteReference();
        return current;
    }

    /**
     * @param newHostName String
     * @param newServerName String
     * @param login String
     * @param password String
     * @param JNDIName String
     * @throws ServerSecurityException
     * @internal.tle
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#replicateTo(String, String, String, String, String)
     */
    public void replicateTo(String newHostName, String newServerName, String login, String password, String JNDIName)
        throws ServerSecurityException {
        // TODO: make replicateToInternal() abstract
        ((VSORBSessionImpl)this).replicateToInternal(newHostName, newServerName, login, password, JNDIName);

    }

    /**
     * @param newHostName String
     * @param newServerName String
     * @param login String
     * @param password String
     * @throws ServerSecurityException
     * @internal.tle
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#replicateTo(String, String, String, String)
     */
    public void replicateTo(String newHostName, String newServerName, String login, String password)
        throws ServerSecurityException {
        // TODO: make replicateToInternal() abstract
        ((VSORBSessionImpl)this).replicateToInternal(newHostName, newServerName, login, password, null);
    }

    /**
     * Method getRoleProperties.
     *
     * @param v Vector
     * @return Properties
     * @throws VSORBException
     * @throws ServerException
     */
    public synchronized Properties getRoleProperties(Vector v) throws VSORBException, ServerException {
        if (m_Privileges != null) {
            return m_Privileges;
        }
        Properties props = new Properties();

        props.put(DataConst.AppRoleImpl_CONNECT, Boolean.valueOf(false));
        props.put(DataConst.AppRoleImpl_SYSADMIN, Boolean.valueOf(false));
        props.put(DataConst.AppRoleImpl_SECADMIN, Boolean.valueOf(false));

        Enumeration e = v.elements();
        while (e.hasMoreElements()) {
            AppRoleImpl role = getRoleForRoleName(e.nextElement().toString());
            if (role != null) { //Fix for 41742, 45913

                //If it is SystemAdmin then just break;
                if (role.getSysAdmin()) {
                    props.put(DataConst.AppRoleImpl_SYSADMIN, Boolean.valueOf(true));
                    break;
                }

                if (role.getConnecter()) {
                    props.put(DataConst.AppRoleImpl_CONNECT, Boolean.valueOf(true));
                }

                if (role.getSecAdmin()) {
                    props.put(DataConst.AppRoleImpl_SECADMIN, Boolean.valueOf(true));
                }
            }
        }

        if (!((Boolean)props.get(DataConst.AppRoleImpl_SYSADMIN)).booleanValue()) {
            Properties publicProps = AppRoleImpl.getPublicRolePrivileges(getServer().getInternalSession());
            if (((Boolean)publicProps.get(DataConst.AppRoleImpl_CONNECT)).booleanValue()) {
                props.put(DataConst.AppRoleImpl_CONNECT, Boolean.valueOf(true));
            }
            if (((Boolean)publicProps.get(DataConst.AppRoleImpl_SECADMIN)).booleanValue()) {
                props.put(DataConst.AppRoleImpl_SECADMIN, Boolean.valueOf(true));
            }
            if (((Boolean)publicProps.get(DataConst.AppRoleImpl_SYSADMIN)).booleanValue()) {
                props.put(DataConst.AppRoleImpl_SYSADMIN, Boolean.valueOf(true));
            }
        }

        if (((Boolean)props.get(DataConst.AppRoleImpl_SYSADMIN)).booleanValue()) {
            props.put(DataConst.AppRoleImpl_CONNECT, Boolean.valueOf(true));
            props.put(DataConst.AppRoleImpl_SECADMIN, Boolean.valueOf(true));
        }

        m_Privileges = props;
        return props;
    }

    /**
     * Method getEJBHome.
     *
     * @param homeJNDIName String
     * @param homeClass Class
     * @param providerURL String
     * @return Object
     * @throws Exception
     */
    protected static Object getEJBHome(String homeJNDIName, Class homeClass, String providerURL) throws Exception {

        //Get initial context
    
        Properties p = new Properties();
        p.put(Context.PROVIDER_URL, providerURL);
        p.put(Context.INITIAL_CONTEXT_FACTORY, bundle.getProperty("nameService"));
        InitialContext initCtxt = new InitialContext(p);

        //Get the home interface

        Object home = initCtxt.lookup(homeJNDIName);
        home = PortableRemoteObject.narrow(home, homeClass);
       
        return home;
    } //getEJBHome

    /**
     * Method executeCommand.
     *
     * @param command String
     * @return String
     * @throws VSORBException
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#executeCommand(String)
     */
    public String executeCommand(String command) throws VSORBException {
        if (cmdConsoleServer == null) {
            cmdConsoleServer = new CMDConsoleServer();
        }
        return cmdConsoleServer.executeCommand(this, command);
    }

    /**
     * Method setVLSContextBean.
     *
     * @param bean EJBObject
     */
    public void setVLSContextBean(EJBObject bean) {
        vlsContextBean = bean;
    }

    /*
     * Return the Security object associated with the security manager for this session
     * @return   the security manager instance to be associated with this session
     */

    /**
     * Method getServerSecurityObject.
     *
     * @return Object
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getServerSecurityObject()
     */
    public Object getServerSecurityObject() {
        if (getSecurityManager() != null) {
            return getSecurityManager().getSecurityObject();
        }
        return null;
    }

    /**
     * @param dataSourceName String
     * @param userLogin String
     * @return boolean
     * @throws VSORBException
     * @throws ServerSecurityException
     * @internal.tle
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#testConnectionProperties(String, String)
     */
    public boolean testConnectionProperties(String dataSourceName, String userLogin)
        throws VSORBException, ServerSecurityException {

//????This things need to be done now. It will be removed
//when Nilesh fixes the client side transaction.
        if (isTransactionInProgress()) {
            getTransactionInfo().flushCache();
            getTransactionInfo().clearCache();
        }

        SearchRequest filter = new SearchRequest();

//find user record, and use it for all testing
        filter.add(new Parameter("AppDataSourceLocation", "DSLocationName", dataSourceName));
        AppDataSourceLocationImpl dsComponent = (AppDataSourceLocationImpl)AppDataSourceLocationImpl.getObjectByKey(filter, this);

//		AppUserImpl testUserComponent;
//		if (userLogin == null || userLogin.equals("") )
//			testUserComponent = userComponent;
//		else {
//			filter = new SearchRequest();
//			filter.add(new Parameter("AppUser", "AppSvrLoginID", userLogin));
//			testUserComponent = (AppUserImpl)AppUserImpl.getObjectByKey(filter, this);
//
//			if (testUserComponent == null)
//				throw new ServerSecurityException(0,
//					VSErrors.getErrorString(VSErrors.VSMSG_loginError));
//		}

        Properties conProps = dsComponent.getTestingConProperties();
        try {
            VSORBException firstOrbEx = null;
            try {

                //Test external or internal based on the "Use External Connection Pool" property
                if (Boolean.valueOf(conProps.getProperty("Use External Connection Pooling", "false"))
                    .booleanValue()) {
                    conProps.setProperty("getConnectionFromExternalPool", "true");

                    if (_LOGGER.isDebugEnabled()) {
                        _LOGGER.debug("Testing external connection...");
                    }

                    testConnectionPropertiesInternal(conProps, dsComponent);

                    if (_LOGGER.isDebugEnabled()) {
                        _LOGGER.debug("Testing external connection... done...");
                    }
                } else {
                    if (_LOGGER.isDebugEnabled()) {
                        _LOGGER.debug("Testing native connection...");
                    }

                    conProps.setProperty("getConnectionFromExternalPool", "false");

                    testConnectionPropertiesInternal(conProps, dsComponent);

                    if (_LOGGER.isDebugEnabled()) {
                        _LOGGER.debug("Testing native connection... done...");
                    }
                }
            } catch (VSORBException orbEx) {
                if (orbEx.getMsgCode().equals(RuntimeMsgCode.VSORBSESSIONIMPL696)) {
                    throw orbEx;
                } else {
                    firstOrbEx = orbEx;
                }
            }

            //Test native pool if 'Use Native Pool for Versata Read Tx' is set true while using ECP
            if (Boolean.valueOf(conProps.getProperty("Use External Connection Pooling", "false"))
                .booleanValue() && Boolean.valueOf(conProps.getProperty("Use Native Pool for Versata Read Tx", "true"))
                .booleanValue()) {
                conProps.setProperty("getConnectionFromExternalPool", "false");
                if (_LOGGER.isDebugEnabled()) {
                    _LOGGER.debug("Testing native connection in addition to external connection...");
                }

                testConnectionPropertiesInternal(conProps, dsComponent);

                if (_LOGGER.isDebugEnabled()) {
                    _LOGGER.debug("Testing native connection in addition to external connection...done...");
                }

            } else {
                if (firstOrbEx != null) {
                    throw firstOrbEx;
                }
            }
        } catch (VSORBException orbEx) {
            throw orbEx;
        } catch (Exception ex) {
            _LOGGER.error(ex);
        }

        return true;  // since I did not get exceptions
    }

    private boolean testConnectionPropertiesInternal(Properties conProps, AppDataSourceLocationImpl dsComponent)
        throws VSORBException {

        UserTransaction ut = null;
        boolean IStartedTx = false;

        try {
            if (Boolean.valueOf(conProps.getProperty("getConnectionFromExternalPool")).booleanValue()) {

                try {
                    // We don't consider console session to start the JTS Tx. So the
                    // User Transaction.begin() is used instead of beginTransaction().
                    ut = getUserTransaction();
                    ut.begin();
                    IStartedTx = true;
                    if (_LOGGER.isDebugEnabled()) {
                        _LOGGER.debug("<<< Read Transaction Started >>>");
                    }
                } catch (Exception ex) {
                    _LOGGER.error(ex);
                }
            }
            VSJdbc connection = null;

            try {
                //set up JDBC connection
                connection = new VSJdbc(conProps, false);

            } catch (Throwable e) {
                if (connection != null) {
                    connection.close();
                }
                throw new VSORBException(RuntimeMsgCode.VSORBSESSIONIMPL687, new Object[] { e.getMessage() });
            }

            //find data object for this data source to use for testing
            SearchRequest filter = new SearchRequest();
            filter.add(new Parameter("AppObject", "LocationID", Long.toString(dsComponent.getDSLocationID())));
            filter.add(new Parameter("AppObject", "ObjectType", "D")); // data object
            SearchRequest sorter = new SearchRequest();
            sorter.add(new Parameter("AppObject", "ObjectName", ""));
            ResultSet rs = GenericComponentFactory.getResultSet("com.versata.tl.vls.admin", "AppObject", filter, sorter, 1,
                (VSORBSessionImpl)this);
            
            //Take the first DataObject, get its storage table list from the meta cache and execute the test query on it.

            String packageName = null;
            VSJdbcStatement statement = null;
            String tableName = null;

            DataRow row = rs.fetch();
            if (row == null) {
                connection.close();
                throw new VSORBException(RuntimeMsgCode.VSORBSESSIONIMPL690);
            }
            String objName = (String)row.getValue("ObjectName");
            String repositoryName = (String)row.getValue("RepositoryName");

            VSBusinessObjectMetaCache metaCache = VSRepositoryMetaCache.get(repositoryName);
            packageName = metaCache.getPackageName(objName);
            List tableNames = metaCache.getStorageTableList(objName);
            if(tableNames == null || tableNames.size() == 0){
                connection.close();
                throw new VSORBException(RuntimeMsgCode.VSORBSESSIONIMPL696);
            }
            tableName = (String)tableNames.get(0);

            try {
                //Getting meta query : just to get the flag useQuotedIdentifier from any VSMetaTable
                VLSClassLoader.create(packageName, ServerEnvironment.getComponentClassPath());
                VSMetaQuery aQry = GenericComponentFactory.getMetaQuery(packageName, objName);
                VSMetaTable aTable = aQry.getBaseTableByTableName(objName);
                
                //now build a statement and execute it
                statement = new VSJdbcStatement(connection, false);
                String tblName = SqlGeneratorFactory.getInstance().getSqlGenerator(connection).qualifiedTableNameForInheritance(connection, tableName, aTable.useQuotedIdentifier());//modify by xinge
                String qry = "Select * from " + tblName + " where 1 = 0 ";
                statement.execute(qry);
                if (_LOGGER.isDebugEnabled()) {
                    _LOGGER.debug("Connection tested Successfully on table : " + tblName);
                }
                statement.close();
                statement = null;
                connection.close();
                connection = null;
            } catch (Throwable e) {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
                throw new VSORBException(RuntimeMsgCode.VSORBSESSIONIMPL696, new Object[] { objName, e.getMessage() });
            }

            if (IStartedTx) {
                ut.commit();
                IStartedTx = false;
                if (_LOGGER.isDebugEnabled()) {
                    _LOGGER.debug("<<< Read Transaction Committed >>>");
                }
            }
        } catch (VSORBException orbEx) {
            throw orbEx;
        } catch (Exception ex) {
            _LOGGER.error(ex);
        } finally {
            try {
                if (IStartedTx) {
                    ut.rollback();
                    IStartedTx = false;
                    if (_LOGGER.isDebugEnabled()) {
                        _LOGGER.debug("<<< Read Transaction Rolled back >>>");
                    }
                }
            } catch (Exception ex) {
                _LOGGER.error(ex);
            }
        }
        return true; // since I did not get exceptions
    }

    /**
     * @return UserTransaction
     * @throws Exception
     * @internal.tle
     */
    public UserTransaction getUserTransaction() throws Exception {
        return AppServerResourceAccessorFactory.getInstance().getUserTransaction();
    }
}
