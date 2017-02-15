// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VSORBSessionImpl.java

package com.versata.tl.vls.core;

import com.versata.tl.api.itext.MessageLocalizer;
import com.versata.tl.api.logging.VersataLogger;
import com.versata.tl.common.QueryRequest;
import com.versata.tl.common.QueryResponse;
import com.versata.tl.common.ServerEvent;
import com.versata.tl.common.exception.ServerException;
import com.versata.tl.common.exception.ServerSecurityException;
import com.versata.tl.common.text.AdminMsgCode;
import com.versata.tl.common.text.ErrorMsgCode;
import com.versata.tl.common.text.RuntimeMsgCode;
import com.versata.tl.common.transaction.*;
import com.versata.tl.common.util.Parameter;
import com.versata.tl.common.util.SearchRequest;
import com.versata.tl.common.util.Util;
import com.versata.tl.common.vlsobject.*;
import com.versata.tl.common.vstrace.VSTraceHelper;
import com.versata.tl.vls.admin.*;
import com.versata.tl.vls.dataaccess.BOCollectionImpl;
import com.versata.tl.vls.dataaccess.ResultSet;
import com.versata.tl.vls.dataaccess.VSORBResultSetImpl;
import com.versata.tl.vls.dataaccess.XDASQLConnector;
import com.versata.tl.vls.dataaccess.connection.Connection;
import com.versata.tl.vls.service.*;
import com.versata.tl.vls.transaction.CurrentTransaction;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.util.*;
import javax.ejb.EJBObject;

// Referenced classes of package com.versata.tl.vls.core:
//            VSORBSessionImpl_Common, VSORBAppServerImpl, VLSSingleton

public class VSORBSessionImpl extends VSORBSessionImpl_Common
{

    public VSORBSessionImpl(VSORBAppServerImpl p_AppServer, String p_userName, boolean p_securitySession, boolean internalSession)
        throws ServerSecurityException
    {
        super(p_AppServer, p_userName, p_securitySession, internalSession);
        if(_DIAGNOSTICLOGGER.isDebugEnabled())
            _DIAGNOSTICLOGGER.debug(RuntimeMsgCode.EMPTY_MSG, (new StringBuilder()).append(" Creating session for user : ").append(p_userName).toString() != null ? ((Object) (p_userName)) : "null user");
    }

    public VSORBSessionImpl(VSORBAppServerImpl p_AppServer, Vector roleList, String p_userName, boolean p_securitySession, boolean internalSession)
        throws ServerSecurityException
    {
        super(p_AppServer, roleList, p_userName, p_securitySession, internalSession);
        if(_DIAGNOSTICLOGGER.isDebugEnabled())
            _DIAGNOSTICLOGGER.debug(RuntimeMsgCode.EMPTY_MSG, (new StringBuilder()).append(" Creating session for user : ").append(p_userName).toString() != null ? ((Object) (p_userName)) : "null user");
    }

    public VSORBSessionImpl(VSORBAppServerImpl p_AppServer, String p_userName, String p_password, String p_clientAppName, boolean internalSession, String repositoryName, boolean p_securitySession)
        throws ServerSecurityException
    {
        super(p_AppServer, p_userName, p_password, p_clientAppName, internalSession, repositoryName, p_securitySession);
        if(_DIAGNOSTICLOGGER.isDebugEnabled())
            _DIAGNOSTICLOGGER.debug(RuntimeMsgCode.EMPTY_MSG, (new StringBuilder()).append(" Creating session for user : ").append(p_userName).toString() != null ? ((Object) (p_userName)) : "null user");
    }

    public VSORBSessionImpl(VSORBAppServerImpl p_AppServer, Vector roleList, String p_userName, String p_password, String p_clientAppName, boolean internalSession, String repositoryName, 
            boolean p_securitySession)
        throws ServerSecurityException
    {
        super(p_AppServer, roleList, p_userName, p_password, p_clientAppName, internalSession, repositoryName, p_securitySession);
        if(_DIAGNOSTICLOGGER.isDebugEnabled())
            _DIAGNOSTICLOGGER.debug(RuntimeMsgCode.EMPTY_MSG, (new StringBuilder()).append(" Creating session for user : ").append(p_userName).toString() != null ? ((Object) (p_userName)) : "null user");
    }

    public void close()
    {
        if(_DIAGNOSTICLOGGER.isDebugEnabled())
            _DIAGNOSTICLOGGER.debug(RuntimeMsgCode.EMPTY_MSG, (new StringBuilder()).append(" closing session for user : ").append(getUserID()).toString() != null ? ((Object) (getUserID())) : "null user");
        if(_LOGGER.isDebugEnabled())
            _LOGGER.debug((new StringBuilder()).append("close session called: session details are").append(this).append("Thread ID is").append(Thread.currentThread().getId()).toString());
        if(container == null)
            return;
        Enumeration e = container.elements();
        if(sessionTxMapReverse.get(this) != null)
        {
            sessionTxMap.remove(sessionTxMapReverse.get(this));
            sessionTxMapReverse.remove(this);
            if(_LOGGER.isDebugEnabled())
                _LOGGER.debug("close session : removed sessionid from MAP (sessionTxMap)");
        }
        while(e.hasMoreElements()) 
        {
            SessionListener l = (SessionListener)e.nextElement();
            try
            {
                l.beforeSessionClosed(this);
            }
            catch(Exception ex)
            {
                _LOGGER.warn(ex);
            }
        }
        container.removeAllElements();
        container = null;
        CurrentTransaction currentTx = (CurrentTransaction)get_current();
        if(_LOGGER.isDebugEnabled())
        {
            _LOGGER.debug((new StringBuilder()).append("Current Transaction : ").append(currentTx).toString());
            if(currentTx != null)
                _LOGGER.debug((new StringBuilder()).append("Is Current Transaction External JTS? - ").append(currentTx.isExternalJTS()).toString());
        }
        if(currentTx != null && !currentTx.isExternalJTS())
            try
            {
                rollback();
            }
            catch(NoTransactionException ex)
            {
                _LOGGER.warn(ex);
            }
        unregisterAllConnections();
        if(isConsoleSession() && !isAnotherEsmRunning())
        {
            VSORBSession sessions[] = theAppServer.getSessions();
            if(sessions != null)
            {
                for(int i = 0; i < sessions.length; i++)
                    ServerEnvironment.getFactoryImpl().getVLSSecuritySessionDelegate((VSORBSecuritySession)sessions[i]).removeEventListener(ID);

            }
        }
        if(!ServerEnvironment.isConfigAdminDataPerEAR() && isUpdateModeConsoleSession)
            VLSSingleton.getSingleton().unLockConsole();
        if(serverEventListeners != null)
        {
            serverEventListeners.removeAllElements();
            serverEventListeners = null;
        }
        currentTransaction = null;
        lastPing = null;
        transactionInfo = null;
        if(theAppServer != null)
        {
            theAppServer.removeSession(this);
            theAppServer = null;
        }
        disableReadOnlyCacheForSession();
        if(readOnlyCaches != null)
        {
            readOnlyCaches.clear();
            readOnlyCaches = null;
        }
        closeRemoteResultSets();
        releaseRemoteReferenceForSecuritySession();
        releaseRemoteReference();
        if(vlsContextBean != null)
            try
            {
                vlsContextBean.remove();
                vlsContextBean = null;
            }
            catch(NoSuchObjectException noe)
            {
                _LOGGER.error(noe);
            }
            catch(Exception ex)
            {
                _LOGGER.error(ex);
            }
        if(sessionAttributes != null)
        {
            sessionAttributes.clear();
            sessionAttributes = null;
        }
        theAppServer = null;
        if(_LOGGER.isDebugEnabled())
            _LOGGER.debug(RuntimeMsgCode.VSORBSESSIONIMPL668, userName);
    }

    public void ping()
    {
        if(theAppServer == null)
            throw new RuntimeException(MessageLocalizer.getLocalizedMessageWithCodePrefix(RuntimeMsgCode.VSORBSESSIONIMPL683));
        lastPing = new Date();
        if(!ServerEnvironment.isConfigAdminDataPerEAR() && isUpdateModeConsoleSession)
            VLSSingleton.getSingleton().updateConsoleLock();
    }

    public boolean isAnotherEsmRunning()
    {
    	/**********************************ERROR
        if(ServerEnvironment.isConfigAdminDataPerEAR())
            break MISSING_BLOCK_LABEL_65;
        if(VLSSingleton.getSingleton().isConsoleLocked())
            break MISSING_BLOCK_LABEL_50;
        if(!isConsoleSession())
            break MISSING_BLOCK_LABEL_48;
        if(VLSSingleton.getSingleton().lockConsole(getRepositoryName(), getSessionPingRate()))
        {
            isUpdateModeConsoleSession = true;
            return false;
        }
        try
        {
            return true;
        }
        catch(Exception e)
        {
            throw new ServerException(AdminMsgCode.SYSTEM_ERROR, e);
        }
        return false;
        return true;
        VSORBSession sess[] = theAppServer.getSessions();
        int x = 0;
_L1:
        if(x >= sess.length)
            break MISSING_BLOCK_LABEL_139;
        VSORBSessionImpl session = (VSORBSessionImpl)ServerEnvironment.getFactoryImpl().getVLSSecuritySessionDelegate((VSORBSecuritySession)sess[x]);
        if(session != this && sess[x].isConsoleSession())
            return true;
        try
        {
            x++;
        }
        catch(RemoteException e)
        {
            throw new ServerException(AdminMsgCode.SYSTEM_ERROR, e);
        }
         goto _L1
         ***************/
        return false;
    }

    public Properties getUserRoleProperties(String loginID, long roleID)
    {
        Session ses = getServer().getInternalSession();
        SearchRequest filter = new SearchRequest();
        filter.add(new Parameter("AppUserRole", "AppUserLoginID", loginID));
        filter.add(new Parameter("AppUserRole", "RoleID", Long.toString(roleID)));
        AppUserRoleImpl userRole = (AppUserRoleImpl)AppUserRoleImpl.getObjectByKey(filter, ses);
        if(userRole == null)
        {
            filter = new SearchRequest();
            filter.add(new Parameter("AppRole", "RoleID", Long.toString(roleID)));
            AppRoleImpl role = (AppRoleImpl)AppRoleImpl.getObjectByKey(filter, ses);
            if(role == null)
                return null;
            AppUserImpl user = AppUserImpl.getUserObject(loginID, ses);
            if(user == null)
                return null;
            userRole = AppUserRoleImpl.getNewObject(ses, true);
            userRole.setAppUserLoginID(loginID);
            userRole.setRoleID(roleID);
        }
        return userRole.getProperties();
    }

    public  void replicateToInternal(String x0, String x1, String x2, String x3, String x4)	//volatile
        throws ServerSecurityException
    {
        super.replicateToInternal(x0, x1, x2, x3, x4);
    }

    public  void addServerEvent2(ServerEvent x0)	//volatile
    {
        super.addServerEvent2(x0);
    }

    public  void rollback()	//volatile
        throws NoTransactionException
    {
        super.rollback();
    }

    public  void commit()	//volatile
        throws NoTransactionException, ServerException, VSORBException
    {
        super.commit();
    }

    public  Current get_current()	//volatile
    {
        return super.get_current();
    }

    public  Current beginTrans(boolean x0)	//volatile
        throws SubtransactionsUnavailableException
    {
        return super.beginTrans(x0);
    }

    public static final String _RCS_HEADER = "$Header: //depot/main/products/brms/runtime/src/core/com/versata/tl/vls/core/VSORBSessionImpl.java#2 $";
    private static final VersataLogger _DIAGNOSTICLOGGER = VSORBAppServerImpl.getConnectionSnapshotLogger();
    private boolean isUpdateModeConsoleSession;

    static 
    {
        ServerEnvironment.getServer();
        VersataLogger.getRCSTraceLogger().trace("$Header: //depot/main/products/brms/runtime/src/core/com/versata/tl/vls/core/VSORBSessionImpl.java#2 $");
    }
    
    
    
    
    
    
    
    
    
    
    public Object executeQuery(QueryRequest qr)
    throws VSORBException
{
    QueryRequest qreq = qr;
    QueryResponse qres = getNewQueryResponse();	//<<<OBJEKTET SOM KLIENTEN FÅR TILLBAKA!!!
    qres.setQueryRequest(qreq);
    try
    {
        if(_LOGGER.isDebugEnabled())
            _LOGGER.debug((new StringBuilder()).append("VSORBSessionImpl_ejb.executeQuery qreq -> ").append(qreq).toString());
        ResultSet resultSet;
        //implements by VSQueryResultsImpl, VSORBResultSetImpl
        if(qreq.getUseCache())
        {
            if(_LOGGER.isDebugEnabled())
                _LOGGER.debug("VSORBSessionImpl_ejb.executeQuery Using Cache");
            resultSet = getResultSetFromCache(qreq);
        } else
        if(qreq.isAdhocQuery())
        {
            if(_LOGGER.isDebugEnabled())
                _LOGGER.debug("VSORBSessionImpl_ejb.executeQuery is AdhocQuery");
            resultSet = getResultSetBySQLRemote1(qreq);
        } else
        {
            if(_LOGGER.isDebugEnabled())
                _LOGGER.debug("VSORBSessionImpl_ejb.executeQuery going directly to the source");
            resultSet = getResultSetByRequest1(qreq);
        }
        
        if(qreq.getUseStatelessRS())
        {
            if(getCoLocated())
                qres.setRowsAsObjects(((VSQueryResultsImpl)resultSet).localFetch());
            else
                qres.setRows(resultSet.fetchRows());
            if(qreq.getPrefetchRowCount())
                qres.setRowCount(((VSQueryResultsImpl)resultSet).getPreFetchCount());
            qres.setMetaColumn(resultSet.registerMetaData());
        } else
        {
            VSQueryResultsImpl queryResults = new VSQueryResultsImpl(this);
            queryResults.setQueryRequest(qreq);
            //TEST
//            System.out.println(resultSet.getClass().getName());
//            if(resultSet instanceof VSORBResultSetImpl){
//            	VSORBResultSet rs =	queryResults.getRemoteReference();
////            VSORBResultSet rs = ((VSORBResultSetImpl)resultSet).getRemoteReference();
//            }
            //---------------------
            queryResults.fetchAllRows(resultSet);
            
            if(qreq.getUseCache())
            {
                if(getCoLocated())
                {
                    qres.setRowsAsObjects(queryResults.localFetch());
                    if(queryResults.hasMoreRows())
                    {
                        VSORBResultSet remoteResultSet = ((BOCollectionImpl)resultSet).getWrapper();
                        qres.setRS(remoteResultSet);
                    }
                } else
                {
                    qres.setRows(queryResults.fetchRows());
                    if(queryResults.hasMoreRows())
                    {
                        VSORBResultSet remoteResultSet = ((BOCollectionImpl)resultSet).getRemoteReference();
                        qres.setRS(remoteResultSet);
                    }
                }
            } else
            if(getCoLocated())
            {
                qres.setRowsAsObjects(queryResults.localFetch());
                if(queryResults.hasMoreRows())
                {
                    VSORBResultSet remoteResultSet = ((VSORBResultSetImpl)resultSet).getWrapper();
                    qres.setRS(remoteResultSet);
                }
            } else
            {
//            	VSORBResultSet remoteResultSet = ((VSORBResultSetImpl)resultSet).getRemoteReference();
//            	qres.setRS(remoteResultSet);
            	
                qres.setRows(queryResults.fetchRows());
                if(queryResults.hasMoreRows())
                {
                    VSORBResultSet remoteResultSet = ((VSORBResultSetImpl)resultSet).getRemoteReference();
                    qres.setRS(remoteResultSet);
                }
            }
            if(qreq.getPrefetchRowCount())
                qres.setRowCount(queryResults.getPreFetchCount());
            qres.setMetaColumn(queryResults.registerMetaData());
        }
    }
    catch(VSORBException e)
    {
        throw e;
    }
    catch(ServerException se)
    {
        throw Util.createORBException(se);
    }
    catch(Throwable e)
    {
    	System.err.println(e.toString());
//        handleThrowableException(e);
    }
    return qres;
}

    
   
    
    private ResultSet getResultSetBySQLRemote1(QueryRequest qreq)
    throws VSORBException
{
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
    if(Boolean.valueOf(props.getProperty("Use External Connection Pooling")).booleanValue())
        dataSourceType = props.getProperty("DriverTypeForExternalPool");
    else
        dataSourceType = props.getProperty("DriverType");
    boolean useNativePoolForVersataReadTx = Boolean.valueOf(props.getProperty("Use Native Pool for Versata Read Tx", "true")).booleanValue();
    boolean isUsingXADriver = Boolean.valueOf(props.getProperty("Is Using XA Driver", "false")).booleanValue();
    if(_LOGGER.isDebugEnabled())
        _LOGGER.debug((new StringBuilder()).append("VSORBSessionImpl_ejb.getResultSetBySQLRemote1 ->  isAutoCloseResultSet :").append(isAutoCloseResultSet).append("getPackageName() :").append(packageName).append("dataServerName :").append(dataServerName).append("Use Native Pool for Versata Read Tx :").append(useNativePoolForVersataReadTx).append("isUsingXADriver :").append(isUsingXADriver).append("useJTS :").append(useJTS).append("isTransactionInProgress :").append(isTransactionInProgress()).append("dataSourceType :").append(dataSourceType).toString());
    validateDriverType(dataSourceType, dataServerName);
    validateDataServerConfiguration(isAutoCloseResultSet, isUsingXADriver, useNativePoolForVersataReadTx);
    if(isAutoCloseResultSet && useJTS && !useNativePoolForVersataReadTx && !isSecuritySession() && !isConsoleSession())
        return getResultSetBySQLRemote1Tx(qreq);
    ResultSet resultset = null;
    try
    {
        resultset = getResultSetBySQL1(SQL, dataServerName, maxRowsPerFetch, prefetch, randomAccessPos);
        resultset = setQueryRequest(isAutoCloseResultSet, qreq, resultset);
    }
    catch(Exception ex)
    {
        _LOGGER.error(ex);
    }
    return resultset;
}

 
    private void validateDriverType(String dataSourceType, String dataServerName)
    {
        if((dataSourceType == null || "".equals(dataSourceType)) && !isSecuritySession() && !isConsoleSession())
            throw ServerEnvironment.createORBException(new ServerException(ErrorMsgCode.VSMSG_MissingDriverType, dataServerName));
        else
            return;
    }
    
    
    private ResultSet getResultSetBySQLRemote1Tx(QueryRequest qreq)
    throws VSORBException
{
    ResultSet resultset = null;
    String SQL = qreq.getSQL();
    String dataServerName = qreq.getDataServerName();
    int maxRowsPerFetch = qreq.getMaxRowsPerFetch();
    boolean prefetch = qreq.getServerPreFetch();
    int randomAccessPos = qreq.getRequestRandomAccessPos();
    boolean isAutoCloseResultSet = qreq.getUseStatelessRS();
    synchronized(readTxLock)
    {
        try
        {
            if(!isTransactionInProgress())
            {
                beginTransaction();
                IStartedTx = true;
                setReadTransactionInProgress(true);
                if(_LOGGER.isDebugEnabled())
                    _LOGGER.debug("VSORBSessionImpl_ejb.getResultSetBySQLRemote1Tx <<< Read Transaction Started >>>");
            }
            VSORBResultSetImpl aResultSet = (VSORBResultSetImpl)getResultSetBySQL1(SQL, dataServerName, maxRowsPerFetch, prefetch, randomAccessPos);
            if(isAutoCloseResultSet)
            {
                VSQueryResultsImpl queryResults = new VSQueryResultsImpl(this);
                queryResults.setQueryRequest(qreq);
                queryResults.fetchAllRows(aResultSet);
                resultset = queryResults;
            } else
            {
                aResultSet.setQueryRequest(qreq);
                resultset = aResultSet;
            }
            if(IStartedTx && isTransactionInProgress())
            {
                commit();
                IStartedTx = false;
                setReadTransactionInProgress(false);
                if(_LOGGER.isDebugEnabled())
                    _LOGGER.debug("VSORBSessionImpl_ejb.getResultSetBySQLRemote1Tx <<< Read Transaction Committed >>>");
            }
        }
        catch(Exception ex)
        {
            _LOGGER.error(ex);
        }
        finally
        {
            try
            {
                if(IStartedTx && isTransactionInProgress())
                {
                    rollback();
                    IStartedTx = false;
                    setReadTransactionInProgress(false);
                    if(_LOGGER.isDebugEnabled())
                        _LOGGER.debug("VSORBSessionImpl_ejb.getResultSetBySQLRemote1Tx <<< Read Transaction Rolled back >>>");
                }
            }
            catch(NoTransactionException noTxException)
            {
                _LOGGER.warn(noTxException);
            }
            catch(Exception ex)
            {
                _LOGGER.error(ex);
            }
        }
    }
    return resultset;
}
    private ResultSet setQueryRequest(boolean autoCloseResultSet, QueryRequest qreq, ResultSet resultset)
    {
        if(autoCloseResultSet)
        {
            VSQueryResultsImpl queryResults = new VSQueryResultsImpl(this);
            queryResults.setQueryRequest(qreq);
            queryResults.fetchAllRows(resultset);
            resultset = queryResults;
        } else
        {
            resultset.setQueryRequest(qreq);
        }
        return resultset;
    }
    
    
    public VSORBResultSet getResultSetBySQLRemote1(String SQL, String dataServerName, int maxRowsPerFetch, boolean prefetch, int randomAccessPos, boolean isAutoCloseResultSet)
    throws VSORBException
{
    VSORBResultSet remoteResultSet = null;
    try
    {
        QueryRequest qr = getNewQueryRequest();
        qr.setSQL(SQL);
        qr.setDataServerName(dataServerName);
        qr.setMaxRowsPerFetch(maxRowsPerFetch);
        qr.setServerPreFetch(prefetch);
        qr.setRequestRandomAccessPos(randomAccessPos);
        qr.setUseStatelessRS(isAutoCloseResultSet);
        if(_LOGGER.isDebugEnabled())
            _LOGGER.debug((new StringBuilder()).append("VSORBSessionImpl_ejb.getResultSetBySQLRemote1 -> ").append(qr.toString()).toString());
        ResultSet resultSet = getResultSetBySQLRemote1(qr);
        if(getCoLocated())
            remoteResultSet = ((VSORBResultSetImpl)resultSet).getWrapper();
        else
            remoteResultSet = ((VSORBResultSetImpl)resultSet).getRemoteReference();
    }
    catch(ServerException se)
    {
        throw ServerEnvironment.createORBException(se);
    }
    catch(Throwable e)
    {
        System.out.println(e.toString());
//    	handleThrowableException(e);
    }
    return remoteResultSet;
}

    
    
    public ResultSet getResultSetBySQL1(String SQL, String dataServerName, int maxRowsPerFetch, boolean prefetch, int randomAccessPos)
    throws VSORBException
{
//    VSTraceHelper trh = null;
//    if(VSTrace.IS_ON)
//    {
//        trh = new VSTraceHelper(_LOGGER, "VSORBSessionImpl_Base.getResultSetBySQL1");
//        trh.set("User", getUserID());
//        trh.set("SessionID", sessionIDForTracing);
//    }
    VSORBResultSetImpl aResultSet = null;
    try
    {
        XDASQLConnector xdac = new XDASQLConnector();
        Properties props = getMyDataServiceLogin(dataServerName);
        String allowQuery = props.getProperty("SQL Allowed");
        if(allowQuery == null || !"True".equalsIgnoreCase(allowQuery))
            throw new ServerException(AdminMsgCode.NO_EXEC_SQL, dataServerName);
        xdac.setProperties(props);
        Connection conn;
        if(isTransactionInProgress())
            conn = getTransactionInfo().getConnection(xdac);
        else
            conn = getConnection(xdac, true);
        aResultSet = new VSORBResultSetImpl(SQL, maxRowsPerFetch, xdac, conn);
        if(randomAccessPos >= 0)
            aResultSet.setRequestRandomAccessMode(true);
        if(randomAccessPos > 0)
            aResultSet.setCursorPosition(randomAccessPos);
        if(prefetch)
            aResultSet.enablePreFetch();
    }
    catch(ServerException se)
    {
        throw ServerEnvironment.createORBException(se);
    }
    catch(VSORBException e)
    {
        throw e;
    }
    catch(Throwable e)
    {
        throw new VSORBException(ErrorMsgCode.VSMSG_UnCheckedException, e);
    }
    finally
    {
//        if(trh != null)
//            trh.end();
    }
    return aResultSet;
} 
    
/***************************************************************    
    protected ResultSet getResultSetByRequest1(QueryRequest qreq)
    throws VSORBException
{
    VSTraceHelper trh;
    ResultSet resultset;
    String componentName;
    int maxRowsPerFetch;
    short columnProjectionLevel;
    boolean prefetch;
    int randomAccessPos;
    boolean isAutoCloseResultSet;
    String packageName;
    trh = null;
//    if(VSTrace.IS_ON)
//    {
//        trh = new VSTraceHelper(_LOGGER, "VSORBSessionImpl.getResultSetByRequest1");
//        trh.set("User", getUserID());
//        trh.set("SessionID", sessionIDForTracing);
//    }
    resultset = null;
    componentName = qreq.getComponentName();
    maxRowsPerFetch = qreq.getMaxRowsPerFetch();
    columnProjectionLevel = qreq.getColumnProjectionLevel();
    prefetch = qreq.getServerPreFetch();
    randomAccessPos = qreq.getRequestRandomAccessPos();
    isAutoCloseResultSet = qreq.getUseStatelessRS();
    packageName = VSRepositoryMetaCache.get(getRepositoryName()).getPackageName(componentName);
    SearchRequest filter;
    SearchRequest sorter;
    ResultSet resultset1;
    filter = (SearchRequest)SerializationUtil.deserializeFromByteArray(qreq.getFilter(), com.versata.tl.common.util.SearchRequest);
    sorter = (SearchRequest)SerializationUtil.deserializeFromByteArray(qreq.getSorter(), com.versata.tl.common.util.SearchRequest);
    qreq.setSorterAsSR(sorter);
    qreq.setFilterAsSR(filter);
    String dataServerName = null;
    boolean useJTS = Boolean.valueOf(getServerProperty("usejts")).booleanValue();
    boolean useNativePoolForVersataReadTx = true;
    boolean isUsingXADriver = false;
    String dataSourceType = null;
    if(!"com.versata.tl.vls.admin".equals(packageName) && !"VLSWebConsole".equals(packageName))
    {
        if(Boolean.valueOf(getDataServerProperty(componentName, "Use External Connection Pooling")).booleanValue())
            dataSourceType = getDataServerProperty(componentName, "DriverTypeForExternalPool");
        else
            dataSourceType = getDataServerProperty(componentName, "DriverType");
        dataServerName = getDataServerForObject(componentName);
        useNativePoolForVersataReadTx = Boolean.valueOf(getDataServerProperty(componentName, "Use Native Pool for Versata Read Tx")).booleanValue();
        isUsingXADriver = Boolean.valueOf(getDataServerProperty(componentName, "Is Using XA Driver")).booleanValue();
    }
    if(_LOGGER.isDebugEnabled())
        _LOGGER.debug((new StringBuilder()).append("VSORBSessionImpl_ejb.getResultSetByRequest1 -> isAutoCloseResultSet : ").append(isAutoCloseResultSet).append(" componentName : ").append(componentName).append(" getPackageName() :").append(packageName).append(" dataServerName : ").append(dataServerName).append(" Use Native Pool for Versata Read Tx : ").append(useNativePoolForVersataReadTx).append(" useJTS : ").append(useJTS).append(" isUsingXADriver : ").append(isUsingXADriver).append(" isTransactionInProgress : ").append(isTransactionInProgress()).append(" dataSourceType : ").append(dataSourceType).toString());
    validateDriverType(dataSourceType, dataServerName);
    validateDataServerConfiguration(isAutoCloseResultSet, isUsingXADriver, useNativePoolForVersataReadTx);
    if(!isAutoCloseResultSet || !useJTS || useNativePoolForVersataReadTx || isSecuritySession() || isConsoleSession())
        break MISSING_BLOCK_LABEL_440;
    resultset1 = getResultSetByRequest1Tx(qreq);
    return resultset1;
    try
    {
        VSORBResultSetImpl aResultSet = (VSORBResultSetImpl)GenericComponentFactory.getResultSet(packageName, componentName, filter, sorter, maxRowsPerFetch, columnProjectionLevel, randomAccessPos, (VSORBSessionImpl)this);
        if(prefetch)
            aResultSet.enablePreFetch();
        if(isAutoCloseResultSet)
        {
            VSQueryResultsImpl queryResults = new VSQueryResultsImpl(this);
            queryResults.setQueryRequest(qreq);
            queryResults.fetchAllRows(aResultSet);
            resultset = queryResults;
        } else
        {
            resultset = aResultSet;
        }
        resultset.setQueryRequest(qreq);
    }
    catch(ServerException se)
    {
        throw ServerEnvironment.createORBException(se);
    }
    catch(VSORBException e)
    {
        throw e;
    }
    catch(Throwable e)
    {
        //handleThrowableException(e);
    }
    break MISSING_BLOCK_LABEL_574;
    local;
    if(trh != null)
        trh.end();
    JVM INSTR ret 21;
    return resultset;
}
******************************************/   
    
    
    
    
    
    
}


