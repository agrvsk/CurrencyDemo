package com.versata.tl.vls.core;

import com.versata.tl.api.logging.VersataLogger;
import com.versata.tl.common.CoLocatedResultSet;
import com.versata.tl.common.MetaColumn;
import com.versata.tl.common.QueryRequest;
import com.versata.tl.common.RowSeqHolder;
import com.versata.tl.common.VSORBResultSetPackage.atEndException;
import com.versata.tl.common.exception.VSApiException;
import com.versata.tl.common.exception.ServerException;
import com.versata.tl.common.meta.VSMetaQuery;
import com.versata.tl.common.text.ErrorMsgCode;
import com.versata.tl.common.text.VSapiMsgCode;
import com.versata.tl.common.text.AdminMsgCode;
import com.versata.tl.common.transaction.NoTransactionException;
import com.versata.tl.common.util.SearchRequest;
import com.versata.tl.common.vlsobject.VSORBException;
import com.versata.tl.common.vlsobject.VSORBResultSet;
import com.versata.tl.vls.dataaccess.BOCollectionImpl;
import com.versata.tl.vls.dataaccess.ResultSet;
import com.versata.tl.vls.dataaccess.VSORBResultSetImpl;
import com.versata.tl.vls.dataaccess.XDAConnector;
import com.versata.tl.vls.service.ServerEnvironment;

/**
 * @internal.tle
 */
public class VSQueryResultsImpl implements ResultSet, CoLocatedResultSet {

    private static final String _RCS_HEADER = "$Header: //depot/main/products/brms/runtime/src/core/com/versata/tl/vls/core/VSQueryResultsImpl.java#1 $";

    static {
        VersataLogger.getRCSTraceLogger().trace(_RCS_HEADER);
    }

    private static final VersataLogger _LOGGER = VersataLogger.getLogger(
        VSQueryResultsImpl.class);

    private VSORBResultSet remoteReference;
    private VSORBResultSet wrapper;

    private VSORBSessionImpl sessionReference;

    private MetaColumn[] mcols;
    private String[][] rowsAsStrings;
    private Object[][] rowsAsObjects;
    private boolean isAlreadyFetched;
    private int rowCount;
    private int prefetchCount;
    public int maxRowPerFetch;

    private VSMetaQuery metaQuery;
    private XDAConnector xdac;
    private SearchRequest sr;

    private QueryRequest qr;

    /**
     * Constructor for VSQueryResultsImpl.
     * @param session Session
     */
    public VSQueryResultsImpl(Session session) {
        sessionReference = (VSORBSessionImpl)session;
    }

    private boolean blnHasMoreRows;

    /**
     * Method hasMoreRows.
     * @return boolean
     */
    public boolean hasMoreRows() {
        return blnHasMoreRows;
    }

    /**
     * Method fetchAllRows.
     * @param resultset ResultSet
     * @throws ServerException
     */
    public void fetchAllRows(ResultSet resultset) throws ServerException {
        try {
            if (qr.getUseCache()) {
                if (sessionReference.getCoLocated()) {
                    rowsAsObjects = ((BOCollectionImpl)resultset).localFetch();
                    if (rowsAsObjects != null) {
                        rowCount = rowsAsObjects.length;
                    }
                } else {
                    rowsAsStrings = resultset.fetchRows();
                    if (rowsAsStrings != null) {
                        rowCount = rowsAsStrings.length;
                    }
                }
                if (qr.getPrefetchRowCount()) {
                    prefetchCount = getCount();
                }
                return;
            }

            //Need to store the meta query, XDA and search request to get the row count.
            metaQuery = ((VSORBResultSetImpl)resultset).metaQuery;
            xdac = ((VSORBResultSetImpl)resultset).xdac;
            sr = ((VSORBResultSetImpl)resultset).sr;

            if (!sessionReference.isSecuritySession() &&
                !sessionReference.isConsoleSession()) {
                mcols = resultset.registerMetaData();
            }

            if (sessionReference.getCoLocated()) {
                rowsAsObjects = ((VSORBResultSetImpl)resultset).localFetch();
                if (rowsAsObjects != null) {
                    rowCount = rowsAsObjects.length;
                }
            } else {
                rowsAsStrings = resultset.fetchRows();
                if (rowsAsStrings != null) {
                    rowCount = rowsAsStrings.length;
                }
            }
            if (qr.getPrefetchRowCount()) {
                prefetchCount = getCount();
            }
        } catch (atEndException endExException) {
            // Ignore the atEndException exception.
            resultset.close();
            resultset = null;
            blnHasMoreRows = false;
        } catch (VSORBException e) {
            throw e;
        } catch (ServerException e) {
            throw e;
        } catch (Exception ex) {
            throw new ServerException(AdminMsgCode.SYSTEM_ERROR, ex);
        } finally {
            if (qr.getUseStatelessRS() || rowCount < qr.getMaxRowsPerFetch()) {
                if (resultset != null) {
                    resultset.close();
                }
                blnHasMoreRows = false;
                System.out.println("VSQueryResultsImpl fetchAllRows(rs) finally Alla rader har lästs. RS Stängs!");
            } else {
                blnHasMoreRows = true;
                System.out.println("VSQueryResultsImpl fetchAllRows(rs) finally Olästa rader finns. RS Bevaras!");

            }
            if (_LOGGER.isDebugEnabled()) {
                _LOGGER.debug("rowCount : " + rowCount + " hasMoreRows() : " + blnHasMoreRows);
            }
        }
    }

    /**
     * @internal.tle
     * @return MetaColumn[]
     * @see com.versata.tl.common.vlsobject.VSORBResultSetOperations#registerMetaData()
     */
    public MetaColumn[] registerMetaData() {
        return mcols;
    }

    /**
     * Returns the first block of rows as array of String. Throws atEndException
     * exception for the second fetch.
     *
     * @return first block of rows as array of String.
     * @throws atEndException
     * @see com.versata.tl.common.vlsobject.VSORBResultSetOperations#fetchRows()
     */
    public String[][] fetchRows() throws atEndException {
        validateRowsAlreadyFetched();
        return rowsAsStrings;
    }

    /**
     * Returns the first block of rows as array of byte. Throws atEndException
     * exception for the second fetch.
     *
     * @return first block of rows as array of bytes.
     * @throws atEndException
     * @see com.versata.tl.common.vlsobject.VSORBResultSetOperations#fetchRowsAsBytes()
     */
    public byte[] fetchRowsAsBytes() throws atEndException {
        throw new VSApiException(VSapiMsgCode.NOT_IMPLEMENTED);
    }

    /**
     * Method setCursorPosition.
     * @param position int
     * @return boolean
     * @see com.versata.tl.common.vlsobject.VSORBResultSetOperations#setCursorPosition(int)
     */
    public boolean setCursorPosition(int position) {
        throw new VSApiException(VSapiMsgCode.NOT_IMPLEMENTED);
    }

    /**
     * Method fetch.
     * @param Rows RowSeqHolder
     * @return int
     * @throws atEndException
     * @throws VSORBException
     * @see com.versata.tl.common.vlsobject.VSORBResultSetOperations#fetch(RowSeqHolder)
     */
    public int fetch(RowSeqHolder Rows) throws atEndException, VSORBException {
        throw new VSApiException(VSapiMsgCode.NOT_IMPLEMENTED);
    }

    /**
     * @internal.tle Returns the first block of rows as array of Object. Throws
     * atEndException exception for the second fetch.
     * @return first block of rows as array of Object.
     * @throws atEndException
     * @throws VSORBException
     * @see com.versata.tl.common.CoLocatedResultSet#localFetch()
     */
    public Object[][] localFetch() throws atEndException, VSORBException {
        validateRowsAlreadyFetched();
        return rowsAsObjects;
    }

    private void validateRowsAlreadyFetched() throws atEndException {
        if (isAlreadyFetched) {
            if (_LOGGER.isDebugEnabled()) {
                _LOGGER.debug("Throwing atEndException exception ...");
            }
            throw new atEndException(AdminMsgCode.SYSTEM_ERROR);
        }
        isAlreadyFetched = true;
    }

    /**
     * Returns next DataRow in the collection. If the collection is at end it will
     * return null.
     *
     * @return next row. Returns null if the collection is reached at end.
     * @throws com.versata.tl.common.exception.ServerException
     * @see com.versata.tl.vls.dataaccess.ResultSet#fetch()
     */
    public DataRow fetch() throws ServerException {
        throw new VSApiException(VSapiMsgCode.NOT_IMPLEMENTED);
    }

    /**
     * Method fetch.
     * @param virtual boolean
     * @return DataRow
     * @see com.versata.tl.vls.dataaccess.ResultSet#fetch(boolean)
     */
    public DataRow fetch(boolean virtual) {
        throw new VSApiException(VSapiMsgCode.NOT_IMPLEMENTED);
    }

    /**
     * Method getPreFetchCount.
     * @return int
     */
    public int getPreFetchCount() {
        return prefetchCount;
    }

    /**
     * Returns the element count of the collection. This object will never throw
     * unknownCount exception.
     * @return int
     * @throws VSORBException
     * @see com.versata.tl.common.vlsobject.VSORBResultSetOperations#getCount()
     */
    public int getCount() throws VSORBException {
        boolean useJTS = Boolean.valueOf(
            sessionReference.getServerProperty("usejts")).booleanValue();
        int prefetchCount;

        if (sessionReference.isTransactionInProgress()) {
            prefetchCount = xdac.getPreFetchedCount(metaQuery, sr, sessionReference.getTransactionInfo().getConnection(xdac));
        } else {
            if (useJTS) {
                synchronized (sessionReference.readTxLock) {
                    boolean IStartedTx = false;
                    try {
                        if (!sessionReference.isTransactionInProgress()) {
                            sessionReference.beginTransaction();
                            IStartedTx = true;
                            sessionReference.setReadTransactionInProgress(true);
                            if (_LOGGER.isDebugEnabled()) {
                                _LOGGER.debug("<<< Read Transaction Started >>>");
                            }
                        }

                        prefetchCount = xdac.getPreFetchedCount(metaQuery, sr, sessionReference.getConnection(xdac, true));

                        if (IStartedTx && sessionReference.isTransactionInProgress()) {
                            sessionReference.commit();
                            IStartedTx = false;
                            sessionReference.setReadTransactionInProgress(false);
                            if (_LOGGER.isDebugEnabled()) {
                                _LOGGER.debug("<<< Read Transaction Committed >>>");
                            }
                        }
                    } catch (ServerException e) {
                        throw ServerEnvironment.createORBException(e);
                    } catch (VSORBException e) {
                        throw e;
                    } catch (Throwable e) {
                        throw new VSORBException(ErrorMsgCode.VSMSG_UnCheckedException, e);
                    } finally {
                        try {
                            if (IStartedTx && sessionReference.isTransactionInProgress()) {
                                sessionReference.rollback();
                                IStartedTx = false;
                                sessionReference.setReadTransactionInProgress(false);
                                if (_LOGGER.isDebugEnabled()) {
                                    _LOGGER.debug("<<< Read Transaction Rolled back >>>");
                                }
                            }
                        } catch (NoTransactionException e) {
                            _LOGGER.warn(e);
                        } catch (Exception e) {
                            _LOGGER.error(e);
                        }
                    }
                }
            } else {
                prefetchCount = xdac.getPreFetchedCount(metaQuery, sr,
                    sessionReference.getConnection(xdac, true));
            }
        }

        if (_LOGGER.isDebugEnabled()) {
            _LOGGER.debug("Buffer rowCount : " + rowCount + " prefetchCount  : " + prefetchCount);
        }
        return prefetchCount;
    }

    /**
     * Close the collection and free associated memory. Call this method when the
     * collection is not required.
     * @see com.versata.tl.vls.dataaccess.ResultSet#close()
     */
    public void close() {

        if (_LOGGER.isDebugEnabled()) {
            _LOGGER.debug("Close() called : " + rowCount);
        }

        try {
            releaseRemoteReference();
            registerWithSession(null);
        } catch (Exception ex) {
            _LOGGER.error(ex);
        }
    }

    /**
     * To avoid leaking memory incase close is never called, the creater of this
     * object might choose to register it with a a session that will make sure it
     * gets closed at some point. This method will add itself to
     * sess.addRemoteResultSet and keep a WeakReference to the session so that it
     * can do sess.removeRemoteResultSet when this.close is called.
     *
     * @param sess the session this VSORBResultSet will be registered with. If it
     * was previously registered, it will be unregistered with the previous
     * session.
     */
    public void registerWithSession(VSORBSessionImpl sess) {

        // unregister with previous session
        if (sessionReference != null) {
            sessionReference.removeRemoteResultSet(this);
        }

        if (sess != null) {
            sess.addRemoteResultSet(this);
        }
        sessionReference = sess;
    }

    /**
     * Method getRemoteReference.
     * @return VSORBResultSet
     */
    public VSORBResultSet getRemoteReference() {
        if (remoteReference == null) {
            remoteReference = ServerEnvironment.getFactoryImpl().makeVLSResultSet(this);
        }

        return remoteReference;
    }

    /**
     * Method getWrapper.
     * @return VSORBResultSet
     */
    public VSORBResultSet getWrapper() {
        if (wrapper == null) {
            wrapper = ServerEnvironment.getFactoryImpl().makeResultSetWrapper(this);
        }
        return wrapper;
    }

    private void releaseRemoteReference() {
        if (remoteReference != null) {
            ServerEnvironment.getFactoryImpl().releaseRemoteReference(remoteReference);
            remoteReference = null;
        }
        if (wrapper != null) {
            ServerEnvironment.getFactoryImpl().releaseResultSetWrapper(wrapper);
            wrapper = null;
        }
    }

    /**
     * Sets the max rows per fetch property. This property is used to control the
     * number of rows transferred from server to client in a single fetch routine.
     * Default is 16.
     *
     * @param	n	Number of rows transferred in single fetch call.
     */
    public void setMaxRowsPerFetch(int n) {
        throw new VSApiException(VSapiMsgCode.NOT_IMPLEMENTED);
    }

    /**
     * IGNORED FOR THIS CLASS
     * @return int
     */
    public int getColumnProjectionLevel() {
        throw new VSApiException(VSapiMsgCode.NOT_IMPLEMENTED);
    }

    /**
     * @internal.tle
     * @param level int
     * @see com.versata.tl.common.vlsobject.VSORBResultSetOperations#setColumnProjectionLevel(int)
     */
    public void setColumnProjectionLevel(int level) {
        throw new VSApiException(VSapiMsgCode.NOT_IMPLEMENTED);
    }

    /**
     * @internal.tle
     * @return Session
     * @see com.versata.tl.vls.dataaccess.ResultSet#getSession()
     */
    // this result set may not have a session.
    public Session getSession() {
        return null;
    }

    /**
     * @internal.tle
     * @param qr QueryRequest
     * @see com.versata.tl.vls.dataaccess.ResultSet#setQueryRequest(QueryRequest)
     */
    public void setQueryRequest(QueryRequest qr) {
        this.qr = qr;
    }
}