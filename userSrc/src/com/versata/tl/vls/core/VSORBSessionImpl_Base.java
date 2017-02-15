
package com.versata.tl.vls.core;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import com.versata.tl.api.itext.MessageLocalizer;
import com.versata.tl.api.logging.VersataLogger;
import com.versata.tl.common.Property;
import com.versata.tl.common.QueryRequest;
import com.versata.tl.common.QueryResponse;
import com.versata.tl.common.ServerEvent;
import com.versata.tl.common.VSORBSessionPackage.ORBRows;
import com.versata.tl.common.cache.Cache;
import com.versata.tl.common.cache.GlobalCache;
import com.versata.tl.common.exception.MailException;
import com.versata.tl.common.exception.ServerException;
import com.versata.tl.common.exception.ServerSecurityException;
import com.versata.tl.common.meta.VSMetaColumn;
import com.versata.tl.common.meta.VSMetaKey;
import com.versata.tl.common.meta.VSMetaQuery;
import com.versata.tl.common.meta.VSMetaTable;
import com.versata.tl.common.statistics.DataServiceStatistics;
import com.versata.tl.common.statistics.ServerStatistics;
import com.versata.tl.common.text.AdminMsgCode;
import com.versata.tl.common.text.ErrorMsgCode;
import com.versata.tl.common.text.RuntimeMsgCode;
import com.versata.tl.common.transaction.Current;
import com.versata.tl.common.transaction.NoTransactionException;
import com.versata.tl.common.transaction.Status;
import com.versata.tl.common.transaction.SubtransactionsUnavailableException;
import com.versata.tl.common.util.DataConst;
import com.versata.tl.common.util.Parameter;
import com.versata.tl.common.util.SearchRequest;
import com.versata.tl.common.util.UnSynchronizedVector;
import com.versata.tl.common.util.Util;
import com.versata.tl.common.util.VersionHolder;
import com.versata.tl.common.vlsobject.VSORBException;
import com.versata.tl.common.vlsobject.VSORBResultSet;
import com.versata.tl.common.vlsobject.VSORBSecuritySession;
import com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations;
import com.versata.tl.common.vlsobject.VSORBSession;
import com.versata.tl.common.vstrace.IVSTraceVocab;
import com.versata.tl.common.vstrace.VSTrace;
import com.versata.tl.common.vstrace.VSTraceHelper;
import com.versata.tl.util.ClassCache;
import com.versata.tl.util.SerializationUtil;
import com.versata.tl.vls.admin.AppComponentLoader;
import com.versata.tl.vls.admin.AppDataSourceLocationImpl;
import com.versata.tl.vls.admin.AppObjectImpl;
import com.versata.tl.vls.admin.AppObjectPrivilegeImpl;
import com.versata.tl.vls.admin.AppRoleImpl;
import com.versata.tl.vls.admin.AppSrvSecXDAConnector;
import com.versata.tl.vls.admin.AppUserImpl;
import com.versata.tl.vls.admin.AppUserObjectPrivilege;
import com.versata.tl.vls.admin.AppUserRoleImpl;
import com.versata.tl.vls.admin.DataLine;
import com.versata.tl.vls.admin.security.VSSecurityManager;
import com.versata.tl.vls.cmdconsole.CMDConsoleServer;
import com.versata.tl.vls.dataaccess.BOCollectionImpl;
import com.versata.tl.vls.dataaccess.ResultSet;
import com.versata.tl.vls.dataaccess.VSORBResultSetImpl;
import com.versata.tl.vls.dataaccess.XDAConnector;
import com.versata.tl.vls.dataaccess.XDASQLConnector;
import com.versata.tl.vls.dataaccess.connection.Connection;
import com.versata.tl.vls.dataaccess.connection.VSJdbc;
import com.versata.tl.vls.dataaccess.connection.VSJdbcStatement;
import com.versata.tl.vls.service.GenericComponentFactory;
import com.versata.tl.vls.service.ObjectHashtable;
import com.versata.tl.vls.service.Response;
import com.versata.tl.vls.service.SendMail;
import com.versata.tl.vls.service.SendMailException;
import com.versata.tl.vls.service.ServerEnvironment;
import com.versata.tl.vls.service.ServerEventDispatch;
import com.versata.tl.vls.service.SessionListener;
import com.versata.tl.vls.service.TransactionEventListener;

/**
 * This class represents a session with the Versata Logic Server for each client login.
 *
 * @see com.versata.tl.common.vlsobject.VSORBSession
 * @see Session
 */

abstract class VSORBSessionImpl_Base implements Session, VSORBSecuritySessionOperations, IVSTraceVocab {
	private static final VersataLogger _DIAGNOSTICLOGGER=ServerEnvironment.getServer().getConnectionSnapshotLogger();
	
	private static final ClassCache localClassCache = new ClassCache(); 
	
	private static final String _RCS_HEADER = "$Header: //depot/main/products/brms/runtime/src/core/com/versata/tl/vls/core/VSORBSessionImpl_Base.java#2 $";
    
    static {
        VersataLogger.getRCSTraceLogger().trace(_RCS_HEADER);
    }
    
    private static final int _APPLICATION_OBJECT = 0;
    private static final int _BUSINESS_OBJECT = 1;
    
    private static final int _REGISTER_OBJECT = 1;
    private static final int _SET_PRIVILEGE = 2;
    private static final int _SET_PROPERTY = 3;
    private static final int _REGISTER_USER = 4;
    private static final int _SET_USER_ASSIGNMENT = 5;
    private static final int _SET_USER_DATA_SERVER_LOGIN = 6;
    private static final int _SET_USER_PROPERTY = 7;
    private static final int _SET_USER_ASSIGNMENT_PROPERTY = 8;
    private static final int _SET_ROLE_PROPERTY = 9;
    private static final int _SET_PRIVILEGE_PROPERTY = 10;
    private static final int _REGISTER_ROLE = 11;
    private static final int _SET_SERVER_PROPERTY = 12;
    
    protected static VersataLogger _LOGGER = VersataLogger.getLogger(VSORBSessionImpl_Base.class);
    
    /**
     * Logger used to output rule execution summary
     */
    static VersataLogger ruleLogger = VersataLogger.getRuleTraceLogger();
    
    /**
     * String definition beeing used to retrieve the global cache
     */
    private static final String PRIVILEGES_CACHE = "com.versata.tl.vls.core.VSORBSessionImpl_Base.privileges";
    
    // TT# CHG14197
    private Comparator fTxEventListenerSortingComparator = null;
    
    protected Vector container = new Vector(3);
    
    String m_appName;
    // internal flag to keep track whether we need to rollback or not
    protected boolean rollback_only;
    
    
    /**
     * @deprecated Since 5.6
     */
    public String userDefinedEvent = "";
    
    private long mvExpireTime = 60000 * 10; //10 minutes
    boolean securitySession;
  
  // private boolean securitySession;
   /*public void setSecuritySession(boolean securitySession)
   {
     try
     {
       throw new Exception("Gaurav finding the caller");
     } catch (Exception e) {
       System.out.println("setting the session to " + securitySession);
       e.printStackTrace();

       this.securitySession = securitySession;
     }
   }*/
    
  
    
    
    
    /**
     * Will be set to false once the user-modified data has cleared security so that data modified indirectly by rules does not have
     * to pass security.
     */
    private boolean checkSecurity = true;
    
    protected HashMap sessionAttributes;
    protected Properties properties;
    
    Vector m_roleList;
    
    Properties m_Privileges;
    protected Hashtable readOnlyCaches = new Hashtable(3);
    
    private Hashtable sessionReadOnlyCache;
    private VSORBSession remoteReference;
    
    VSORBSecuritySession remoteReferenceSecuritySession;
    
    VSORBSecuritySession localReferenceSecuritySession;
    
    /**
     * @internal.tle
     */
    public boolean coLocated;
    
    // AMR. contains all the resultsets that have been made remote for this session.
    // mapping of (VSORBResultSetImpl) to VSORBResultSetImpl
    private Hashtable remoteResultSets = new Hashtable();
    
    // AMR. We use this for instrumentation. We also pass it to client with setProperty
    String sessionIDForTracing;
    
    //Holds the security manager instance associated with this session.
    //Set by VSORBAppServerImpl when creating a session. Used by getServerSecurityObject remote method to return the current
    // instance of Security object. See the notes below for the requirement and solution (raghu)
    private VSSecurityManager securityManager;
    
    /**
     * @internal.tle Lock object for read transaction.
     */
    public Object readTxLock = new Object();
    
    private boolean readTxInProgress;
    
    /**
     * @internal.tle
     */
    protected VSORBSessionImpl_Base() {
        // empty constructor
    }
    
    /**
     * @param p_AppServer VSORBAppServerImpl
     * @param p_userName String
     * @param p_securitySession boolean
     * @param internalSession boolean
     * @throws ServerSecurityException
     * @internal.tle DO NOT CALL THIS CONSTRUCTOR DIRECTLY, as it will create numerous problems. To add a new session, please call
     * getSession(.....) on this server's instance of VSORBAppServerImpl.
     */
    protected VSORBSessionImpl_Base(VSORBAppServerImpl p_AppServer, String p_userName, boolean p_securitySession,
        boolean internalSession) throws ServerSecurityException {
        
        sessionIDForTracing = Integer.toString(System.identityHashCode(this));
        setProperty(VST_SESSION_ID_PROPERTY, sessionIDForTracing);
        
        //Session info gathered after authentication
        theAppServer = p_AppServer;
        userName = p_userName;
        password = null;
        setRepositoryName(null);
        m_appName = null;
        securitySession = p_securitySession;
        
        //VLSClassLoader.create(boPackageName, ServerEnvironment.getComponentClassPath());
        authenticateUser(new SecurityObject(p_userName, null), m_appName, internalSession, false);
        
    }
    
    /**
     * @param p_AppServer VSORBAppServerImpl
     * @param roleList Vector
     * @param p_userName String
     * @param p_securitySession boolean
     * @param internalSession boolean
     * @throws ServerSecurityException
     * @internal.tle
     */
    protected VSORBSessionImpl_Base(VSORBAppServerImpl p_AppServer, Vector roleList, String p_userName, boolean p_securitySession,
        boolean internalSession) throws ServerSecurityException {
        
        sessionIDForTracing = Integer.toString(System.identityHashCode(this));
        setProperty(VST_SESSION_ID_PROPERTY, sessionIDForTracing);
        
        //Session info gathered after authentication
        theAppServer = p_AppServer;
        userName = p_userName;
        password = null;
        setRepositoryName(null);
        m_appName = null;
        securitySession = p_securitySession;
        m_roleList = new Vector();
        m_roleList.addElement(getRoleForRoleName("Public"));
        if (roleList != null) {
            for (int i = 1; i <= roleList.size(); i++) {
                AppRoleImpl rl = getRoleForRoleName(roleList.elementAt(i - 1).toString());
                if (rl != null) {
                    m_roleList.addElement(rl);
                }
            }
        }
        if (m_roleList.size() == 0) {
            throw new ServerSecurityException(AdminMsgCode.ONLY_ADMIN_EXECUTE);
        }
        // TODO: make authenticateUser(Vector) abstract
        
        //VLSClassLoader.create(boPackageName, ServerEnvironment.getComponentClassPath());
        ((VSORBSessionImpl)this).authenticateUser(roleList, new SecurityObject(userName, password), m_appName, internalSession);
        
    }
    
    // Client session should set this after getting a new ORB session. Server gets
    // coLocated property from here
    
    /**
     * {@inheritDoc}
     *
     * @return boolean
     */
    public boolean getCoLocated() {
        return coLocated;
    }
    
    /**
     * @param c boolean
     * @internal.tle
     * @see Session#setCoLocated(boolean)
     */
    public void setCoLocated(boolean c) {
        coLocated = c;
    }
    
    /**
     * @return VSORBSecuritySession
     * @internal.tle
     */
    public VSORBSecuritySession getLocalReferenceForSecuritySession() {
        if (localReferenceSecuritySession == null) {
            localReferenceSecuritySession = ServerEnvironment.getFactoryImpl().makeVLSSecuritySessionWrapper(this);
        }
        return localReferenceSecuritySession;
    }
    
    /**
     * @return VSORBSession
     * @internal.tle
     */
    public VSORBSession getRemoteReference() {
        if (remoteReference == null) {
            remoteReference = ServerEnvironment.getFactoryImpl().makeVLSSession(this);
        }
        return remoteReference;
    }
    
    /**
     * @internal.tle
     */
    public void releaseRemoteReference() {
        //FINIS merge. This check should be in the FrameworkFactoryImpl
        //for both CORBA, WL and WS
        if (remoteReference == null) {
            return;
        }
        ServerEnvironment.getFactoryImpl().releaseRemoteReference(remoteReference);
        remoteReference = null;
    }
    
    /**
     * @return VSORBSecuritySession
     * @internal.tle
     */
    public VSORBSecuritySession getRemoteReferenceForSecuritySession() {
        if (remoteReferenceSecuritySession == null) {
            remoteReferenceSecuritySession = ServerEnvironment.getFactoryImpl().makeVLSSecuritySession(this);
        }
        return remoteReferenceSecuritySession;
    }
    
    /**
     * @return A Vector of Strings representing roles assigned for this session
     */
    public Vector getRoleList() {
        return m_roleList;
    }
    
    /**
     * @return boolean
     * @internal.tle
     */
    public boolean preAuthenticated() {
        return getRoleList() != null;
    }
    
    /**
     * The sendMail method uses javaMail APIs to send mail to recipients.
     *
     * @param to as address : The sender which may be an array of strings
     * @param cc additional recipients
     * @param from as address : the recipients in the form of a String Array
     * @param mailServer as String : The IP address of mail server as a String
     * @param subject as String : the message header of the message
     * @param msg as String : The actual message
     * @param transactionalType can take values com.versata.tl.vls.service.SendMail.NON_TRANSACTIONAL
     * com.versata.tl.vls.service.SendMail.ON_COMMIT or com.versata.tl.vls.service.SendMail.ON_ROLLBACK
     * @throws MailException
     * @throws com.versata.tl.common.exception.MailException
     * @see com.versata.tl.common.VSSession#sendMail
     */
    public void sendMail(String[] to, String[] cc, String from, String mailServer, String subject, String msg,
        short transactionalType) throws MailException {
        try {
            
            SendMail sm = new SendMail(mailServer);
            // not a multi-part message
            sm.setRecipientsTo(to);
            //Client sets a empty cc address for null
            if (!(cc == null || cc.length == 0 || cc[0].trim().length() == 0)) {
                sm.setRecipientsCC(cc);
            }
            sm.setFrom(from);
            sm.setMsg(msg);
            sm.setSubject(subject);
            sm.send((int)transactionalType, this);
        } catch (SendMailException e) {
            throw new MailException(AdminMsgCode.SENDMAIL_ERROR, e);
        }
    }
    
    /**
     * Query object on the data source and create a result set through direct SQL
     *
     * @param SQL Any valid SQL query statement in String format
     * @param dataServerName an Unique name to identify a data server, its properties will direct session how to make a connection
     * to data source
     * @param maxRowsPerFetch Number of rows will be sent back to client at a time
     * @param prefetch boolean
     * @return ResultSet            a remote resultset handle
     * @throws VSORBException
     * @throws com.versata.tl.common.vlsobject.VSORBException Data return from this resultset are read only
     * @see Session#getResultSetBySQL1(String, String, int, boolean)
     */
    public ResultSet getResultSetBySQL1(String SQL, String dataServerName, int maxRowsPerFetch, boolean prefetch)
    throws VSORBException {
        return getResultSetBySQL1(SQL, dataServerName, maxRowsPerFetch, prefetch, -1);
    }
    
    /**
     * Query object on the data source and create a result set through direct SQL
     *
     * @param SQL Any valid SQL query statement in String format
     * @param dataServerName an Unique name to identify a data server, its properties will direct session how to make a connection
     * to data source
     * @param maxRowsPerFetch Number of rows will be sent back to client at a time
     * @param prefetch boolean
     * @param randomAccessPos int
     * @return ResultSet            a remote resultset handle
     * @throws VSORBException
     * @throws com.versata.tl.common.vlsobject.VSORBException Data return from this resultset are read only
     */
    public ResultSet getResultSetBySQL1(String SQL, String dataServerName, int maxRowsPerFetch, boolean prefetch,
        int randomAccessPos) throws VSORBException {
        // implement operation...
        VSTraceHelper trh = null;
        if (VSTrace.IS_ON) {
            trh = new VSTraceHelper(_LOGGER, "VSORBSessionImpl_Base.getResultSetBySQL1");
            trh.set(VST_USER, getUserID());
            trh.set(VST_SESSION_ID, sessionIDForTracing);
        }
        
        //Create the object and register with BOA
        VSORBResultSetImpl aResultSet = null;
        
        try {
            XDASQLConnector xdac = new XDASQLConnector();
            
            Properties props = getMyDataServiceLogin(dataServerName);
            //        System.out.println(dataServerName+ "  " + props);
            
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
            
            // AMR change for scrollable resultset
            if (randomAccessPos >= 0) {
                aResultSet.setRequestRandomAccessMode(true);
            }
            
            if (randomAccessPos > 0) {
                aResultSet.setCursorPosition(randomAccessPos);
            }
            
            if (prefetch) {
                aResultSet.enablePreFetch();
            }
            
            //       this.appendTraceString("Reading via SQL: " + SQL, true);
            //addServerEvent("Reading via SQL", SQL, Session.DB_EVENT);
            
        } catch (ServerException se) {
            throw ServerEnvironment.createORBException(se);
        } catch (VSORBException e) {
            throw e;
        } catch (Throwable e) {
            // Log the error trace in baslog.out
            throw new VSORBException(ErrorMsgCode.VSMSG_UnCheckedException, e);
            
        } finally {
            if (trh != null) {
                trh.end();
            }
        }
        return aResultSet;
    }
    
    /**
     * {@inheritDoc}
     *
     * @param SQL String
     * @param dataServerName String
     * @param maxRowsPerFetch int
     * @param prefetch boolean
     * @return VSORBResultSet
     * @throws VSORBException
     */
    public VSORBResultSet getResultSetBySQLRemote(String SQL, String dataServerName, int maxRowsPerFetch, boolean prefetch)
    throws VSORBException {
        
        return getResultSetBySQLRemote1(SQL, dataServerName, maxRowsPerFetch, prefetch, -1, false);
    }
    
    // This will create a new connection which is not in transaction, as you can get that from
    // transactioninfo
    
    /**
     * Look up a sharable connection either from session's local pool or server's global pool.Connection type is determined by data
     * server properties
     *
     * @param dataServerName an Unique name use to identify a data server
     * @return Connection        a sharable connection
     * @see Session#getConnection(String)
     */
    public Connection getConnection(String dataServerName) {
        XDASQLConnector xdac = new XDASQLConnector();
        xdac.setProperties(getMyDataServiceLogin(dataServerName));
        return getConnection(xdac, true);
    }
    
    /**
     * Directly issue a SQL update and automatically commit if it runs successfully
     *
     * @param sql Any valid sql in String format. e.g. a SQL update statement, store procedure call
     * @param dataServerName an Unique name to identify a data server, its properties will direct session connect to a specific data
     * source
     * @return int    Number of rows effected
     * @see Session#executeUpdate(String, String)
     */
    public int executeUpdate(String sql, String dataServerName) {
        XDASQLConnector xdac = new XDASQLConnector();
        
        Properties props = getMyDataServiceLogin(dataServerName);
        xdac.setProperties(props);
        xdac.setSession(this);
        
        String allowQuery = props.getProperty("SQL Allowed");
        if (allowQuery == null || !"True".equalsIgnoreCase(allowQuery)) {
            throw new ServerException(AdminMsgCode.NO_EXEC_SQL, dataServerName);
        }
        int count = 0;
        
        VSJdbc con = (VSJdbc)xdac.getConnection(false);
        VSJdbcStatement stmt = con.createJdbcStatement();
        
        try {
            con.beginTransaction();
            stmt.executeSQL(sql);
            count = stmt.getRowsAffected();
            con.commit();
        } catch (ServerException se) {
            con.rollback();
            throw se;
        } finally {
            try {
                stmt.close();
            } catch (ServerException e) {
                //do nothing as it must be already closed
            }
        }
        return count;
    }
    
    /**
     * overload method, where joinTransaction is true, update will be part of ongoing transaction if current session is in
     * transaction
     *
     * @param sql
     * @param dataServerName
     * @param joinTransaction
     * @return number of rows affected
     * @see Session#executeUpdate(String, String, boolean)
     */
    public int executeUpdate(String sql, String dataServerName, boolean joinTransaction) {
        if (!joinTransaction || !isTransactionInProgress()) {
            return executeUpdate(sql, dataServerName);
        }
        
        XDASQLConnector xdac = new XDASQLConnector();
        
        Properties props = getMyDataServiceLogin(dataServerName);
        xdac.setProperties(props);
        xdac.setSession(this);
        
        String allowQuery = props.getProperty("SQL Allowed");
        if (allowQuery == null || !"True".equalsIgnoreCase(allowQuery)) {
            throw new ServerException(AdminMsgCode.NO_EXEC_SQL, dataServerName);
        }
        int count = 0;
        
        VSJdbc con = (VSJdbc)getTransactionInfo().getConnection(xdac);
        VSJdbcStatement stmt = con.createJdbcStatement();
        
        try {
            stmt.executeSQL(sql);
            count = stmt.getRowsAffected();
        } finally {
            try {
                stmt.close();
            } catch (ServerException e) {
                //do nothing as it must be already closed
            }
        }
        return count;
    }
    
    /**
     * This method returns a boolean indicating whether the current session is also a security session.  If it is a security
     * session, it may be casted to a VSORBsecuritySession in order to perform update operations on security information.
     *
     * @return boolean    Is this session also a security session?
     * @see Session#isSecuritySession()
     */
    public boolean isSecuritySession() {
        return securitySession;
    }
    
   
    /**
     * This method returns a boolean indicating whether the current session is running the VLS Console.  A console session is also a
     * security session, so it may be casted to a VSORBsecuritySession in order to perform update operations on security
     * information.
     *
     * @return boolean    Is this session also a security session?
     * @see Session#isConsoleSession()
     */
    public boolean isConsoleSession() {
        return securitySession && ("VersataESM".equalsIgnoreCase(m_appName) || "VLSConsole".equalsIgnoreCase(m_appName));
    }
    
    /**
     * Method cloneSession.
     *
     * @return Session
     * @see Session#cloneSession()
     */
    public Session cloneSession() {
        try {
            
            VSSecurityManager origMgr = getSecurityManager();
            //Sharing the security manager to fix BUG12152  V6Port: cloneSession is giving nullpointerexception
            //Since the security manager was not set for cloned session
            //cloneSession() is provided to support multiple transactions in
            //parallel and to support the initiation of a new transaction from within a
            //transaction. So sharing security manager is safe.
            VSORBSessionImpl retSession;
            if (!origMgr.externalAuthentication()) {
                retSession = new VSORBSessionImpl(theAppServer, userName, password, m_appName, false,
                    getRepositoryName(), securitySession);
            } else {
                retSession = new VSORBSessionImpl(theAppServer, origMgr.getRoles(), origMgr.getLogin(), origMgr
                    .getPassword(), m_appName, false, getRepositoryName(), securitySession);
            }           
            retSession.setSecurityManager(origMgr);
            return retSession;
        } catch (ServerSecurityException e) {
            _LOGGER.warn(e);
            return null;
        }
    }
    
    /**
     * Query object on the data source and create a result set
     *
     * @param componentName Name of Business object to be retrieved
     * @param filterInByteArray SearchRequest in binary stream form
     * @param sorterInByteArray SearchRequest in binary stream form
     * @param maxRowsPerFetch Number of rows will be sent back to client per fetch
     * @return VSORBResultSet    a remote resultset handle
     * @throws VSORBException
     * @throws com.versata.tl.common.vlsobject.VSORBException
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getResultSetByRequest(String, byte[], byte[], int)
     */
    public VSORBResultSet getResultSetByRequest(String componentName, byte[] filterInByteArray, byte[] sorterInByteArray,
        int maxRowsPerFetch) throws VSORBException {
        VSTraceHelper trh = null;
        if (VSTrace.IS_ON) {
            trh = new VSTraceHelper(_LOGGER, "VSORBSessionImpl_Base.getResultSetByRequest");
            trh.set(VST_USER, getUserID());
            trh.set(VST_SESSION_ID, sessionIDForTracing);
        }
        
        VSORBResultSet remoteResultSet = null;
        try {
            SearchRequest filter = (SearchRequest)SerializationUtil.deserializeFromByteArray(filterInByteArray, SearchRequest.class);
            SearchRequest sorter = (SearchRequest)SerializationUtil.deserializeFromByteArray(sorterInByteArray, SearchRequest.class);
            
            String packageName = VSRepositoryMetaCache.get(getRepositoryName()).getPackageName(componentName);
            VSORBResultSetImpl aResultSet = (VSORBResultSetImpl)GenericComponentFactory.getResultSet(packageName,
                componentName, filter, sorter, maxRowsPerFetch, (VSORBSessionImpl)this);
            
            remoteResultSet = aResultSet.getRemoteReference();
        } catch (ServerException se) {
            throw ServerEnvironment.createORBException(se);
        } catch (VSORBException e) {
            throw e;
        } catch (Throwable e) {
            // Log the error trace in baslog.out
            throw new VSORBException(ErrorMsgCode.VSMSG_UnCheckedException, e);
        } finally {
            if (trh != null) {
                trh.end();
            }
        }
        return remoteResultSet;
    }
    
    /**
     * @internal.tle
     */
    public final void resetAppServerHandle() {
        theAppServer = null;
    }
    
    /**
     * @internal.tle
     */
    public void deactivate() {
        releaseRemoteReference();
    }
    
    /**
     * For each row, it build the DataRow and trigger its save to persistenet data source. If save proceed successfully, it package
     * the refreshed rows back to client If it fails, exception will be raised containing the position of the first problem row The
     * encoding and decoding of the ORBRow is done at this stage
     *
     * @param orbRows To be updated records
     * @return String[][]    Refreshed rows
     * @throws VSORBException
     * @throws SecurityException
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#save(ORBRows)
     */
    public String[][] save(ORBRows orbRows) throws VSORBException, SecurityException {
        // implement operation...
        //empty result applicable for all deletes or error
        String[][] returnRows = new String[1][1];
        //check for valid metaqueryname and no of rows to update
        int rowCount;
        if (orbRows.componentName.length() == 0 || (rowCount = orbRows.rows.length) == 0) {
            return returnRows;
        }
        
        try {
            if (!isTransactionInProgress()) {
                beginTransaction();
                IStartedTx = true;
            }
        } catch (SubtransactionsUnavailableException stxu) {
            _LOGGER.warn(stxu);
        } catch (VSORBException e) {
            throw e;
        } catch (Throwable e) {
            // Log the error trace in baslog.out
            throw new VSORBException(ErrorMsgCode.VSMSG_UnCheckedException, e);
        }
        
        //Keeps the list of row which need to be saved.
        //This list is populated in the first loop and is used to save
        //the rows in second loop
        UnSynchronizedVector dataRowList = new UnSynchronizedVector();
        // create a index to datarow mapping. This is required to find
        //the index of row in case of error.
        HashMap rowIndexMap = new HashMap(rowCount);
        
        VSTraceHelper trh = null;
        if (VSTrace.IS_ON) {
            trh = new VSTraceHelper(_LOGGER, "VSORBSessionImpl_Base.save");
            trh.set(VST_USER, getUserID());
            trh.set(VST_SESSION_ID, sessionIDForTracing);
            trh.set(VST_CATEGORY, VST_TRANSACTION);
            trh.set(VST_OBJECT_NAME, orbRows.componentName);
        }
        
        try {
            int refreshDelay = 0;
            String componentName = orbRows.componentName;
            String packageName = VSRepositoryMetaCache.get(getRepositoryName()).getPackageName(componentName);
            // get the metaQuery
            VSMetaQuery metaQuery = GenericComponentFactory.getMetaQuery(packageName, componentName);
            
            Properties dsProperties = getMyDataServiceLoginForObject(orbRows.componentName);
            if (dsProperties != null) {
                String refreshDelayString = dsProperties.getProperty("RefreshDelay");
                
                // default to 1 second for access database
                if (refreshDelayString != null) {
                    refreshDelay = Integer.parseInt(refreshDelayString);
                }
            }
            //Refresh list is the list of rows which need to be refreshed
            //in the end. True refresh from the database is
            //only done in case of server started transaction.
            
            // By Default, only QueryObject will refresh, this can be change thru object's extend properties
            List refreshList = new ArrayList();
            
            //???? IMPORTANT PLEASE READ
            //Not that in first loop we are only adding rows to the cache.
            //Only in second loop (of refreshList) we call save functions.
            //This is required for consistency. RefreshList is also used
            //in the end to do refresh before returning rows.
            int index = 0;
            while (index < rowCount) {
                short ops = orbRows.rows[index].op;
                DataRow dataRow;
                switch (ops) {
                    case VSORBSession.insert:
                        dataRow = new DataRow(this, metaQuery, orbRows.rows[index], null);
                    
                    //We dont call save here instead we just put into the list.
                    //This is required because we want to put all rows in cache before
                    //saving them.
                    dataRow.addToCache(metaQuery, dataRowList, repositoryName);
                    rowIndexMap.put(dataRow, Integer.valueOf(index));
                    refreshList.add(dataRow);
                    break;
                    case VSORBSession.update:
                        dataRow = new DataRow(this, metaQuery, orbRows.rows[index], orbRows.rows[index + 1]);
                    
                    dataRow.addToCache(metaQuery, dataRowList, repositoryName);
                    rowIndexMap.put(dataRow, Integer.valueOf(index));
                    refreshList.add(dataRow);
                    //Extra index increment for oldRow
                    index++;
                    break;
                    case VSORBSession.delete:
                        dataRow = new DataRow(this, metaQuery, orbRows.rows[index], null);
                    dataRow.addToCache(metaQuery, dataRowList, repositoryName);
                    rowIndexMap.put(dataRow, Integer.valueOf(index));
                    break;
                    default:
                        break;
                } //end switch
                index++;
                
            } //end while (index < rowCount)
            
            //Now again loop to save the rows.
            for (int i = 0; i < dataRowList.size(); i++) {
                DataRow row = (DataRow)dataRowList.elementAt(i);
                DataRow cacheRow = null;
                
                if (row.getMetaQuery().getChildMostTable() != null && row.isDataObjectRow()) {
                    //If the row is created by previous save we need to synchronize old row with the new row.
                    DataObject cacheBO = getTransactionInfo().getObjectFromWriteCache(row.getMetaQuery(), row.getPkeyParams());
                    if (cacheBO != null) {
                        cacheRow = cacheBO.getRow();
                    }
                }
                boolean syncRequired = false;
                
                if (cacheRow != null) {
                    //Already delete continue don't do anything.
                    if (row.isDelete() && cacheRow.isDelete()) {
                        continue;
                    }
                    if (!row.isInsert() && !cacheRow.isInsert()) {
                        syncRequired = true;
                    }
                }
                
                if (syncRequired) {
                    try {
                        cacheRow.synchronizeDataSource(row);
                        cacheRow.save();
                    } catch (ServerException e) {
                        throw e;
                    }
                    //Since we are saving cacheRow instead of new row
                    //we need to put that row in refresh list.
                    int ii = refreshList.indexOf(row);
                    if (ii != -1) {
                        refreshList.set(ii, cacheRow);
                    }
                } else {
                    row.save();
                }
            }
            
            if (IStartedTx) {
                try {
                    commit();
                    IStartedTx = false;
                } catch (NoTransactionException ntx) {
                    IStartedTx = false;
                }
            } else {
                //If client side transaction flush the cache before returning.
                if (isFlushAfterSave()) {
                    getTransactionInfo().flushCache(true);
                }
            }
            //Package return values
            boolean refreshAfterUpdate = metaQuery.refreshAfterUpdate();
            // Check default refresh flag
            
            // Check refresh flag from extended property, the value will override the default flag
            // FIX in ESM: this property should be default with value
            Properties p = getObjectProperties(metaQuery.getName(), DataConst.AppObjectTypeCodeImpl_BUSINESS_OBJECT);
            if (p != null) {
                String refreshAfterUpdateStr = p.getProperty("RefreshAfterUpdate");
                if (refreshAfterUpdateStr != null && refreshAfterUpdateStr.trim().length() != 0) {
                    refreshAfterUpdate = Boolean.valueOf(refreshAfterUpdateStr).booleanValue();
                }
            }
            
            if (refreshDelay > 0) {
                Thread.sleep(refreshDelay);
            }
            
            returnRows = getRefreshRows(refreshList, metaQuery.getColumnCount(), refreshAfterUpdate, metaQuery.hasVirtualField(),
                orbRows.getColumnProjectionLevel());
            
            //cleanup
            refreshList.removeAll(refreshList);
        } catch (ServerException se) {
            //If did not started transaction then mark transaction for rollback
            if (!IStartedTx && isTransactionInProgress()) {
                try {
                    get_current().rollback_only();
                } catch (Exception ex) {
                    _LOGGER.error(ex);
                }
            }
            
            // This maybe the only place we need provide more infomation than plain message
            // to client
            /*
             if (se.row != null) {
             Integer i = (Integer)rowIndexMap.get(se.row);
             // TODO:If a row is created by component, we don't have a correspondent index here, now just put at first
              // This makes absolutely no sense what so ever
               if (i != null) {
               int rowIndex = i.intValue();
               }
               }
               */
            addServerEvent(se.getLocalizedMessage(), se.toString(), 1);
            throw new VSORBException(se);
        } catch (Throwable e) { // In case any other exception, set row index to 0 as I don't know the right value.
            //If did not started transaction then mark transaction for rollback
            if (isTransactionInProgress() && !IStartedTx) {
                try {
                    get_current().rollback_only();
                } catch (Exception ex) {
                    _LOGGER.error(ex);
                }
            }
            addServerEvent(MessageLocalizer.getLocalizedMessage(RuntimeMsgCode.VSORBSESSIONIMPL778, e.getMessage()), e.toString(),
                1);
            if (e instanceof VSORBException) {
                throw (VSORBException)e;
            }
            throw new VSORBException(ErrorMsgCode.VSMSG_UnCheckedException, null, e);
        } finally {
            if (IStartedTx && isTransactionInProgress()) {
                try {
                    rollback();
                } catch (Exception nt) {
                    _LOGGER.warn(nt);
                }
                IStartedTx = false;
            }
            // TODO vstrace: review if this is truly in a finally
            if (trh != null) {
                trh.end();
            }
        }
        return returnRows;
    }
    
    /**
     * @param eventName String
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#setUserDefinedEvent(String)
     * @deprecated Since 5.6
     */
    public void setUserDefinedEvent(String eventName) {
        userDefinedEvent = eventName;
    }
    
    /**
     * @return String    the value in the current event
     * @see Session#getCurrentEvent()
     * @deprecated Since 5.6 This method returns the name of the current event. The current event is used to let business rules
     *             operate in various ways based upon the current event's value.  This is now a somewhat obsolete, but still
     *             supported mechanism to passing additional information about how an update should be processed. Business objects
     *             methods now provide a generally easier mechanism for accomplishing the same tasks.
     */
    public String getCurrentEvent() {
        return userDefinedEvent;
    }
    
    /**
     * This routine returns the value of a session level property
     *
     * @param propName The name of the property entry for which the value is being requested.
     * @return String    a value of the property for this session
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getProperty(String)
     */
    public String getProperty(String propName) {
        String value = "";
        if (properties != null) {
            value = properties.getProperty(propName);
        }
        return value != null ? value : "";
    }
    
    /**
     * This routine sets the value of a session level property.  These are defined for the life of the session.  It will update an
     * existing property if it finds it, or it will add a new property
     *
     * @param property The name of the property entry which should be updated by this call
     * @param value The value that the property should be updated to.
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#setProperty(String, String)
     */
    public void setProperty(String property, String value) {
        setPropertyInternal(property, value);
    }
    
    /**
     * Removes a property previously stored using {@link #setPropertyAsObject} or {@link #setProperty}.
     *
     * @param property the property to remove
     * @return returns the object removed and null if object has been removed or does not exist
     */
    public Object removeProperty(String property) {
        // NEW12158 -- Customer request
        return properties != null ? properties.remove(property) : null;
    }
    
    /**
     * Similar to setProperty, however values are not limited to Strings, any Object is permitted. Retreive stored objects with
     * getPropertyAsObject.
     *
     * @param property The name of the property entry which should be updated by this call
     * @param value The value that the property should be updated to.
     * @see {@link #setProperty}, {@link #getPropertyAsObject }
     */
    public void setPropertyAsObject(String property, Object value) {
        // NEW12158 -- Customer request
        setPropertyInternal(property, value);
    }
    
    /**
     * Allows retrieval of an object stored with setPropertyAsObject
     *
     * @param propertyName
     * @return the value that was stored under the the <code>propertyName</code> before, null is returned in case null was stored or
     *         the property was never set before.
     * @see #setPropertyAsObject
     */
    public Object getPropertyAsObject(String propertyName) {
        // NEW12158 -- Customer request
        return properties == null ? null : properties.get(propertyName);
    }
    
    /**
     * Used by setProperty and SetPropertyAsObject because strings are objects too
     *
     * @param property The name of the property entry which should be updated by this call
     * @param value The value that the property should be updated to.
     */
    protected void setPropertyInternal(String property, Object value) {
        if (properties == null) {
            properties = new Properties();
        }
        
        properties.put(property, value);
    }
    
    /**
     * This routine returns all the values for all session level properties in a PropertySeq structure.  A PropertySeq can be
     * converted to a Java Properties object using method Util.ConvertToJavaProps.
     *
     * @return PropertySeq    An Array of property objects defined in the IDL file
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getPropertyList()
     */
    public Property[] getPropertyList() {
        if (properties == null || properties.size() == 0) {
            return new Property[0];
        }
        
        synchronized (properties) {
            Property[] props = new Property[properties.size()];
            int i = 0;
            for (Enumeration e = properties.propertyNames(); e.hasMoreElements(); i++) {
                String name = (String)e.nextElement();
                String value = properties.getProperty(name);
                if (value == null) {
                    value = "";
                }
                props[i] = new Property(name, value);
            }
            return props;
        }
    }
    
    /**
     * This routine returns the value of a server level property, defined in the Versata Logic Server Console.
     *
     * @param propName The name of the property entry for which the value is being requested.
     * @return String    a value of the property for this session
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#getServerProperty(String)
     */
    public String getServerProperty(String propName) {
        return VSORBAppServerImpl.getProperty(propName);
    }
    
    private void havePermission(String exceptionExpression, boolean sysAndSec) throws ServerSecurityException {
        try {
            if (sysAndSec) {
                if (!getMyUserPrivilege(DataConst.AppRoleImpl_SYSADMIN) && !getMyUserPrivilege(DataConst.AppRoleImpl_SECADMIN)) {
                    throw new ServerSecurityException(AdminMsgCode.SYSADMIN_ONLY, exceptionExpression);
                }
            } else {
                if (!getMyUserPrivilege(DataConst.AppRoleImpl_SYSADMIN)) {
                    throw new ServerSecurityException(AdminMsgCode.SYSADMIN_ONLY, exceptionExpression);
                }
            }
        } catch (VSORBException ex) {
            throw new ServerSecurityException(AdminMsgCode.SYSADMIN_ONLY, exceptionExpression);
        }
    }
    
    /**
     * This routine sets the value of a server level property.  These are defined for the permamnently after this call, and will be
     * listed in the Versata Logic Server Console heretofore.  It will update an existing property if it finds it, or it will add a
     * new property.  Only a system administrator may call this function, other sill receive a ServerSecurityException.
     *
     * @param property The name of the property entry which should be updated by this call
     * @param value The value that the property should be updated to.
     * @param flush boolean
     * @throws ServerSecurityException
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#setServerProperty(String, String, boolean)
     */
    public void setServerProperty(String property, String value, boolean flush) throws ServerSecurityException {
        havePermission("setProperty", false);
        VSORBAppServerImpl.setProperty(property, value, flush);
    }
    
    /**
     * This routine returns all the values for all server level properties in a PropertySeq structure.  A PropertySeq can be
     * converted to a Java Properties object using method Util.ConvertToJavaProps.
     *
     * @return PropertySeq    An Array of property objects defined in the IDL file
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#getServerPropertyList()
     */
    public Property[] getServerPropertyList() {
        return theAppServer.getPropertyList();
    }
    
    /**
     * @param componentName as String The components to be retrieved from the data cache.
     * @param maxRowsPerFetch as int : The number of rows to fetch at a time.
     * @return VSORBResultSet
     * @throws VSORBException
     * @throws com.versata.tl.common.vlsobject.VSORBException
     * @see com.versata.tl.common.vlsobject.VSORBResultSet
     * @deprecated as of 11/18/03. Use executeQuery(Object queryResponse) Returns the VSORBResultSet as results which are of
     *             ComponentName type and are residing in the cache.
     */
    public VSORBResultSet getResultSetFromCache(String componentName, int maxRowsPerFetch) throws VSORBException {
        VSORBResultSet remoteResultSet;
        
        try {
            QueryRequest qr = getNewQueryRequest();
            qr.setComponentName(componentName);
            qr.setMaxRowsPerFetch(maxRowsPerFetch);
            qr.setUseStatelessRS(false);
            
            ResultSet resultSet = getResultSetFromCache(qr);
            
            if (getCoLocated()) {
                remoteResultSet = ((BOCollectionImpl)resultSet).getWrapper();
            } else {
                remoteResultSet = ((BOCollectionImpl)resultSet).getRemoteReference();
            }
        } catch (ServerException se) {
            throw ServerEnvironment.createORBException(se);
        } catch (VSORBException e) {
            throw e;
        } catch (Throwable e) {
            // Log the error trace in baslog.out
            throw new VSORBException(ErrorMsgCode.VSMSG_UnCheckedException, e);
        }
        return remoteResultSet;
    }
    
    /**
     * @param qreq QueryRequest
     * @return ResultSet
     * @throws VSORBException
     * @throws ServerSecurityException
     * @internal.tle
     */
    public ResultSet getResultSetFromCache(QueryRequest qreq) throws VSORBException, ServerSecurityException {
        // implement operation...
        if (_LOGGER.isDebugEnabled()) {
            _LOGGER.debug("VSORBSessionImpl_ejb.getResultSetFromCache qreq -> " + qreq);
        }
        ResultSet resultset;
        
        try {
            String componentName = qreq.getComponentName();
            int maxRowsPerFetch = qreq.getMaxRowsPerFetch();
            boolean isStatelessRS = qreq.getUseStatelessRS();
            
            addServerEvent(MessageLocalizer.getLocalizedMessage(RuntimeMsgCode.VSORBSESSIONIMPL671, componentName), "",
                Session.INFO_EVENT);
            if (!getMyPrivilegeToObjectName(DataConst.AppObjectPrivilegeImpl_READ, componentName,
                DataConst.AppObjectTypeCodeImpl_BUSINESS_OBJECT)) {
                throw new ServerSecurityException(AdminMsgCode.SYSADMIN_ONLY_1, new Object[] { "code table", componentName });
            }
            
            String packageName = VSRepositoryMetaCache.get(getRepositoryName()).getPackageName(componentName);
            resultset = theAppServer.dataObjectCache.getLocalResultSet(packageName, componentName, maxRowsPerFetch,
                (VSORBSessionImpl)this);
            
            //      this.appendTraceString("Reading: " + componentName, true);
            
            ServerEnvironment.getFactoryImpl().releaseRemoteReference(remoteReference);
            
            if (isStatelessRS) {
                //ResultSet resultSet = (ResultSet)ServerEnvironment.getFactoryImpl().getResultSetDelegate(aResultSet);
                VSQueryResultsImpl queryResults = new VSQueryResultsImpl(this);
                queryResults.setQueryRequest(qreq);
                queryResults.fetchAllRows(resultset);
                resultset = queryResults;
            } else {
                resultset.setQueryRequest(qreq);
            }
            
        } catch (ServerException se) {
            throw Util.createORBException(se);
        } catch (VSORBException e) {
            throw e;
        } catch (Throwable e) {
            // Log the error trace in baslog.out
            throw new VSORBException(ErrorMsgCode.VSMSG_UnCheckedException, e);
        }
        return resultset;
    }
    
    /**
     * This routine sets the value of a session level property.  These are defined for the life of the session.  It will update an
     * existing property if it finds it, or it will add a new property
     *
     * @param newProperties The name/value pairs in a 2-D string array to be set in the properties hash
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#setProperties(String[][])
     */
    public void setProperties(String[][] newProperties) {
        
        if (newProperties != null) {
            if (properties == null) {
                properties = new Properties();
            }
            
            for (int i = 0; i < newProperties.length; i++) {
                setProperty(newProperties[i][0], newProperties[i][1]);
                if (_LOGGER.isDebugEnabled()) {
                    _LOGGER.debug("Setting property (name/value) : " + newProperties[i][0] + '/' + newProperties[i][1]);
                }
            }
        }
    }
    
    /**
     * Method getMetaQuery.
     *
     * @param repositoryName String
     * @param componentName String
     * @return byte[]
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getMetaQuery(String, String)
     */
    public byte[] getMetaQuery(String repositoryName, String componentName) {
        byte[] b = null;
        try {
            String packageName = VSRepositoryMetaCache.get(repositoryName).getPackageName(componentName);
            b = theAppServer.getMetaQuery(packageName, componentName);
        } catch (Exception ex) {
            _LOGGER.error(ex);
        }
        return b;
    }

    
    /**
     * Method canUpdatePackage.
     *
     * @param id String
     * @return boolean
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#canUpdatePackage(String)
     */
    public boolean canUpdatePackage(String id) {
        return theAppServer.canUpdatePackage(id);
    }
    
    /**
     * Method setUpdatePackage.
     *
     * @param id String
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#setUpdatePackage(String)
     */
    public void setUpdatePackage(String id) {
        theAppServer.setUpdatePackage(id);
    }
    
    /**
     * Method setUpdatePackageForApp.
     *
     * @param id String
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#setUpdatePackageForApp(String)
     */
    public void setUpdatePackageForApp(String id) {
        theAppServer.setUpdatePackageForApp(id);
        
    }
    
    /**
     * Method getName.
     *
     * @return String
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getName()
     */
    public String getName() {
        return theAppServer.getName();
    }
    
    /**
     * Method getProductVersion.
     *
     * @return String
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getProductVersion()
     */
    public String getProductVersion() {
        return theAppServer.getProductVersion();
    }
    
    /**
     * Method getSecurityMetadataVersion.
     *
     * @return String
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getSecurityMetadataVersion()
     */
    public String getSecurityMetadataVersion() {
        return theAppServer.getSecurityMetadataVersion();
    }
    
    /**
     * Method pushSecurityDataWithLogin.
     *
     * @param sd byte[]
     * @param masterVersion int
     * @param login String
     * @param password String
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#pushSecurityDataWithLogin(byte[], int, String, String)
     */
    public void pushSecurityDataWithLogin(byte[] sd, int masterVersion, String login, String password) {
        try {
            theAppServer.pushSecurityDataWithLogin(sd, masterVersion, login, password);
        } catch (Exception ex) {
            _LOGGER.error(ex);
        }
    }
    
    // NON-ORB Code
    
    private String[][] getRefreshRows(List refreshList, int colCount, boolean refresh, boolean hasVirtualField,
        short columnProjectionLevel) {
        
        VSTraceHelper trh = null;
        if (VSTrace.IS_ON) {
            trh = new VSTraceHelper(_LOGGER, "VSORBSessionImpl_Base.getRefreshRows");
            trh.set(VST_CATEGORY, VST_TRANSACTION);
        }
        try {
            int rowCount = refreshList.size();
            enableReadOnlyCacheForQuery(Thread.currentThread());
            String[][] refreshRows = new String[rowCount][colCount];
            
            String currentQueryName = "";
            boolean[] colSecurityBitmap = null;
            for (int i = 0; i < rowCount; i++) {
                DataRow row = (DataRow)refreshList.get(i);
                
                try {
                    //If transaction is in progress then everything is in cache, and no need for refresh.
                    if (!isTransactionInProgress()) {
                        if (refresh) {
                            row.refresh();
                        }
                        
                        // only after refresh we need to force recalculate virtual column
                        if (hasVirtualField) {
                            row.getBusinessObject().calculateAllVirtualValues();
                        }
                    }
                    if (!currentQueryName.equals(row.getMetaQuery().getName())) {
                        colSecurityBitmap = VSORBResultSetImpl.getColSecurityBitmap(row.getBusinessObject(),
                            (VSORBSessionImpl)this, row.getMetaQuery());
                    }
                    if (colSecurityBitmap != null) {
                        VSORBResultSetImpl.removeUnreadableCols(row, colSecurityBitmap);
                    }
                } catch (Exception e) {
                    _LOGGER.warn(e);
                }
                if (columnProjectionLevel == DataConst.ALLTYPES) {
                    refreshRows[i] = row.getORBRow();
                } else {
                    refreshRows[i] = row.getORBRowWithoutLOB();
                }
            }
            
            disableReadOnlyCacheForQuery(Thread.currentThread());
            return refreshRows;
        } finally {
            if (trh != null) {
                trh.end();
            }
        }
    }
    
    //Transaction Interface
    //Session interface
    
    /**
     * Method getConnection.
     *
     * @param xdac XDAConnector
     * @param sharable boolean
     * @return Connection
     * @throws ServerException
     * @see Session#getConnection(XDAConnector, boolean)
     */
    public Connection getConnection(XDAConnector xdac, boolean sharable) throws ServerException {
        Connection con = null;
        
        if (sharable) {
            con = reuseActiveConnection(xdac);
        }
        
        if (con == null) {
            con = registerNewConnection(xdac);
            con.setSharable(sharable);
        }
        
        // temp code
        if (databaseTypeName == null && con instanceof VSJdbc) {
            databaseTypeName = ((VSJdbc)con).getProductName();
        }
        
        if (con instanceof VSJdbc) {
            locale = ((VSJdbc)con).getLocaleStrings();
        }
        return con;
    }
    
    /**
     * @param xdac XDAConnector
     * @return Connection
     * @throws ServerException
     * @internal.tle
     */
    public Connection registerNewConnection(XDAConnector xdac) throws ServerException {
        
        synchronized (connections) {
            Connection con = theAppServer.getConnection(xdac);
            
            // be sure that no other thread waiting on this connection before it has been used
            // by the requester
            con.inTransition(true);
            
            connections.addElement(con);
            con.setSession((VSORBSessionImpl)this);
            return con;
        }
    }
    
    /**
     * @param con Connection
     * @internal.tle
     * @see Session#unregisterConnection(Connection)
     */
    public void unregisterConnection(Connection con) {
        
        // added additional checks for NPE if it happens (issue was tied to theAppServer
        // reference being null too early in the close() call on the session, but just
        // to be safe incase.....        
        if (connections != null) {
            synchronized(connections) {
                connections.removeElement(con);
                con.setSession(null);
                con.setSharable(true);
                con.inTransition(false);
                
                if (theAppServer != null) {
                    theAppServer.returnIdleConnection(con);
                }
            }
        }
    }
    
    protected void unregisterAllConnections() {
    	if(_DIAGNOSTICLOGGER.isDebugEnabled()) {
    		_DIAGNOSTICLOGGER.debug(RuntimeMsgCode.EMPTY_MSG, "unregisterAllConnections () ,unregistering " + connections.size() + " connections ");
    	}
        synchronized (connections) {
            for (int i = 0; i < connections.size(); i++) {
                Connection con = (Connection)connections.elementAt(i);                
                con.release();
                con.setSession(null);
                if (_LOGGER.isDebugEnabled()) {
                    _LOGGER.debug("NPE of vsjdbc.release fixed in unregisterAllConnections");
                }
                con.setSharable(true);
                con.inTransition(false);
                if (con.getID() != null)
                	theAppServer.returnIdleConnection(con);
            }
            connections.removeAllElements();
        }
    }
    
    // TODO: Assume no mixed connection type per session
    private Connection reuseActiveConnection(XDAConnector xdac) {
        //TODO: Build and use a xdac-type based list
        synchronized (connections) {
            for (int i = 0; i < connections.size(); i++) {
                Connection con = (Connection)connections.elementAt(i);
                if (!con.inTransition() && con.isSharable() && !con.isOrphan() && !con.invalid()
                                && xdac.getDataServiceID().equalsIgnoreCase(con.getDataServiceID())
                                && con.getID().equalsIgnoreCase(xdac.getConnectionID())) {
                    con.inTransition(true);
                    return con;
                }
            }
        }
        
        return null;
    }
    
    /**
     * @return String
     * @internal.tle
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getDatabaseTypeName()
     */
    public String getDatabaseTypeName() {
        return databaseTypeName == null ? "" : databaseTypeName;
    }
    
    /**
     * @param databaseName String
     * @param schema String
     * @internal.tle
     */
    public void setTableSchema(String databaseName, String schema) {
        this.databaseName = databaseName;
        this.schema = schema;
        clientOverrideSchema = true;
    }
    
    /**
     * @return String[]
     * @internal.tle
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getLocaleStrings()
     */
    public String[] getLocaleStrings() {
        if (locale == null) {
            String[] l = new String[2];
            l[0] = "en"; // language
            l[1] = "us"; // country
            return l;
        } else {
            return locale;
        }
    }
    
    /**
     * @return String
     * @internal.tle
     */
    public String getOverridedDatabaseName() {
        return databaseName;
    }
    
    /**
     * @return String
     * @internal.tle
     */
    public String getOverridedSchema() {
        return schema;
    }
    
    /**
     * @return boolean
     * @internal.tle
     */
    public boolean clientOverrideSchema() {
        return clientOverrideSchema;
    }
    
    //*************************** Transaction Related Routines *********
    //******************************************************************
    
    protected VSTransactionInfo transactionInfo;
    //protected CurrentTransaction currentTransaction = null;
    
    /**
     * The number of transactions executed by the server
     */
    public static int nTx;
    
    /**
     * The number of transactions aborted by the server
     */
    public static int nAbortTx;
    
    /**
     * The number of transactions committed by the server
     */
    public static int nCommitTx;
    
    boolean IStartedTx;
    
    private Vector m_txEvtListeners = new Vector();
    private boolean bFlushAfterSave = true;
    
    /**
     * @return boolean
     * @internal.tle
     * @see Session#isOTSEnvironment()
     */
    public boolean isOTSEnvironment() {
        return false;
    }
    
    /**
     * Method beginTransaction.
     *
     * @return Current
     * @throws SubtransactionsUnavailableException
     * @see Session#beginTransaction()
     */
    public Current beginTransaction() throws SubtransactionsUnavailableException {
        //      appendTraceString("Starting Transaction", true);
        return ((VSORBSessionImpl)this).beginTrans(true);
    }
    
    /**
     * mark current transaction as rollback_only
     *
     * @see Session#rollback_only()
     */
    public void rollback_only() {
        rollback_only = true;
    }
    
    /**
     * Method flushAfterSave.
     *
     * @param value boolean
     * @return boolean
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#flushAfterSave(boolean)
     */
    public boolean flushAfterSave(boolean value) {
        boolean oldVal = bFlushAfterSave;
        bFlushAfterSave = value;
        return oldVal;
    }
    
    /**
     * Method isFlushAfterSave.
     *
     * @return boolean
     * @see Session#isFlushAfterSave()
     */
    public boolean isFlushAfterSave() {
        return bFlushAfterSave;
    }
    
    /**
     * Method isTransactionInProgress.
     *
     * @return boolean
     * @see Session#isTransactionInProgress()
     */
    public boolean isTransactionInProgress() {
        Current current = get_current();
        if (current == null) {
            return false;
        }
        try {
            return current.get_status().value() != Status._StatusNoTransaction;
        } catch (Exception e) { //TODO-EBAS
            printTransactionInfo();
            throw new ServerException(AdminMsgCode.INVALID_TX_STATUS, e);
        }
    }
    
    /**
     * Method getTransactionInfo.
     *
     * @return VSTransactionInfo
     * @see Session#getTransactionInfo()
     */
    public VSTransactionInfo getTransactionInfo() {
        return transactionInfo;
    }
    
    protected void printTransactionInfo() {
        if (_LOGGER.isDebugEnabled()) {
    		_LOGGER.debug(RuntimeMsgCode.VSORBSESSIONIMPL679, new Object[] { String.valueOf(nTx), String.valueOf(nCommitTx),
    				String.valueOf(nAbortTx) });
    	}
    }
    
    // TT# CHG14197
    
    /**
     * @param comparator
     * @internal.tle
     */
    public void setTxEventListenerSortingComparator(Comparator comparator) {
        fTxEventListenerSortingComparator = comparator;
    }
    
    /**
     * @param listener TransactionEventListener
     * @internal.tle
     * @see Session#addTransactionEventListener(TransactionEventListener)
     */
    public void addTransactionEventListener(TransactionEventListener listener) {
        //check if listener already exist in the list
        if (m_txEvtListeners.indexOf(listener) == -1) {
            m_txEvtListeners.addElement(listener);
            
            // TT# CHG14197
            if (fTxEventListenerSortingComparator != null) {
                Collections.sort(m_txEvtListeners, fTxEventListenerSortingComparator);
            }
        }
    }
    
    /**
     * @param listener TransactionEventListener
     * @internal.tle
     * @see Session#removeTransactionEventListener(TransactionEventListener)
     */
    public void removeTransactionEventListener(TransactionEventListener listener) {
        m_txEvtListeners.removeElement(listener);
    }
    
    /**
     * @internal.tle
     */
    private TransactionEventListener[] getTxEventListeners() {
        synchronized (m_txEvtListeners) {
            TransactionEventListener[] listeners = new TransactionEventListener[m_txEvtListeners.size()];
            m_txEvtListeners.copyInto(listeners);
            return listeners;
        }
    }
    
    /**
     * @return Response
     * @internal.tle
     */
    protected Response postBeforeCommit() {
        TransactionEventListener[] listeners = getTxEventListeners();
        for (int i = 0; i < listeners.length; i++) {
            TransactionEventListener listener = listeners[i];
            Response response = new Response();
            listener.beforeCommit(this, response);
            if (response.rejected()) {
                return response;
            }
        }
        return new Response();
    }
    
    /**
     * @internal.tle
     */
    protected void postAfterCommit() {
        TransactionEventListener[] listeners = getTxEventListeners();
        RuntimeException aRuntimeExeption = null;
        
        // Calls all listeners even if one of them throws an exception
        // If more than one listener throws an exception then the last
        // one is returned
        for (int i = 0; i < listeners.length; i++) {
            TransactionEventListener listener = listeners[i];
            
            try {
                listener.afterCommit(this);
            } catch (RuntimeException ex) {
                ex.fillInStackTrace();
                aRuntimeExeption = ex;
                _LOGGER.warn(RuntimeMsgCode.VSORBSESSIONIMPL680, null, ex);
            }
        } // for
        
        if (aRuntimeExeption != null) {
            throw aRuntimeExeption;
        }
    }
    
    /**
     * @return boolean
     * @internal.tle
     */
    protected boolean postBeginTrans() {
        TransactionEventListener[] listeners = getTxEventListeners();
        for (int i = 0; i < listeners.length; i++) {
            TransactionEventListener listener = listeners[i];
            listener.beginTrans(this);
        }
        return true;
    }
    
    /**
     * @internal.tle
     */
    protected void postBeforeRollback() {
        TransactionEventListener[] listeners = getTxEventListeners();
        for (int i = 0; i < listeners.length; i++) {
            TransactionEventListener listener = listeners[i];
            listener.beforeRollback(this);
        }
    }
    
    /**
     * @internal.tle
     */
    protected void postAfterRollback() {
        TransactionEventListener[] listeners = getTxEventListeners();
        RuntimeException aRuntimeExeption = null;
        
        // Calls all listeners even if one of them throws an exception
        // If more than one listener throws an exception then the last
        // one is returned
        for (int i = 0; i < listeners.length; i++) {
            TransactionEventListener listener = listeners[i];
            try {
                listener.afterRollback(this);
            } catch (RuntimeException ex) {
                ex.fillInStackTrace();
                aRuntimeExeption = ex;
                _LOGGER.warn(RuntimeMsgCode.VSORBSESSIONIMPL681, null, ex);
            }
        } // for
        
        if (aRuntimeExeption != null) {
            throw aRuntimeExeption;
        }
    }
    
    //**********************************************************************
    //*** ESM Methods - Begin
    //**********************************************************************
    
    /**
     * @internal.tle
     */
    public Date lastPing = new Date();
    
    /**
     * @internal.tle
     */
    public int ID;
    
    /**
     * @deprecated Since 5.6 This variable will not be public in the next major release.
     */
    public Vector serverEventListeners = new Vector(1, 1);
    
    /**
     * This method adds an entry that is displayed in the Versata Logic Server Console trace log if one is currently tracing.
     * <p/>
     * The entry is also logged with the Logger named "versata.trace.ruleExec" at INFO level.
     * <p/>
     * Its primary usage if for debugging of server code, but it can also be useful for re-posting information to administrators
     * through the trace about system performance, operating environments, or any other interesting information.
     *
     * @param title the trace information that will appear in the console's trace listing.
     * @param details the trace information that will appear in the console's detail area as each item is selected. If null, no
     * details are logged. If equal to details, not logged.
     * @param type the possible types (???_EVENT) are defined in this interface file.
     * @see Session#addServerEvent(String, String, int)
     */
    public void addServerEvent(String title, String details, int type) {
        // this prevents useless server events being logged as the system boots
        if (ServerEnvironment.hasInitialized()) {
            if (ruleLogger.isInfoEnabled()) {
                Object[] args = new Object[3];
                args[0] = title;
                args[1] = !title.equals(details) ? details : "";
                args[2] = Integer.valueOf(type);
                
                ruleLogger.info(RuntimeMsgCode.VSORBSESSIONIMPL11690, args);
            }
            
            // Nothing more to do if no one is listening
            // FINIS merge, check for NULL
            if (serverEventListeners != null && serverEventListeners.size() != 0) {
                
                // Create a new event (VLSConsole will be able to trace these)
                ServerEvent evt = new ServerEvent();
                evt.type = type;
                evt.title = getIndent() + title;
                evt.description = details;
                evt.user = userName;
                
                //TODO: make addServerEvent2() abstract
                ((VSORBSessionImpl)this).addServerEvent2(evt);
            }
        }
    }
    
    /**
     * This method should be checked before calling addServerEvent if there is significant cost associated with constructing the
     * parameters to that method.
     *
     * @return true if server event tracing is enabled
     */
    public boolean isServerEventTracingEnabled() {
        return ruleLogger.isInfoEnabled() || (serverEventListeners != null && serverEventListeners.size() > 0);
    }
    
    /**
     * This method the user name of the logged in user.  If the user name is blank, it returns the loginID of the logged in user.
     *
     * @return String    the name or login ID of the current user
     * @see Session#getUserName()
     */
    public String getUserName() {
        String name = userComponent.getUserName();
        return name == null || "".equals(name.trim()) ? userComponent.getAppSvrLoginID() : name;
    }
    
    /**
     * This method returns the loginID of the logged in user.
     *
     * @return String    the login ID of the current user
     * @see com.versata.tl.vls.core.Session#getUserID()
     */
    public String getUserID() {
        return userComponent != null ? userComponent.getAppSvrLoginID() : "";
    }
    
    /**
     * This method returns the password used when connecting to the application server.  It should be used very carefully, as it is
     * not encrypted.  It should never be printed or saved.
     *
     * @return String    the password for the current user
     * @see Session#getPassword()
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * @internal.tle Called by ESM to validate that the user is logged on
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#ping2()
     */
    public void ping2() {
        if (theAppServer == null) {
            throw new ServerException(RuntimeMsgCode.VSORBSESSIONIMPL683);
        }
    }
    
    /**
     * @param userSessionId int
     * @param state boolean
     * @internal.tle
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#setTraceEnable(int, boolean)
     */
    public void setTraceEnable(int userSessionId, boolean state) {
        VSORBSessionImpl userSession;
        if ((userSession = theAppServer.getExistingSession(userSessionId)) != null) {
            userSession.setTraceEnable(getRemoteReferenceForSecuritySession(), state);
        }
    }
    
    /**
     * @param adminSession VSORBSecuritySession
     * @param state boolean
     * @internal.tle
     */
    public void setTraceEnable(VSORBSecuritySession adminSession, boolean state) {
        // Get event dispatcher
        ServerEventDispatch sed;
        try {
            sed = getServerEventDispatch(adminSession.getSessionID());
            if (sed != null) {
                sed.traceEnabled = state;
            }
        } catch (Exception e) {
            throw new ServerException(AdminMsgCode.FAILED_TRACE_ENABLED);
        }
    }
    
    /**
     * @param id int
     * @internal.tle
     */
    public void setSessionID(int id) {
        ID = id;
    }
    
    /**
     * @return int
     * @internal.tle
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getSessionID()
     */
    public int getSessionID() {
        return ID;
    }
    
    /**
     * @param userSessionId int
     * @throws ServerSecurityException
     * @internal.tle
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#addEventListener(int)
     */
    public void addEventListener(int userSessionId) throws ServerSecurityException {
        havePermission("addEventListener", false);
        VSORBSessionImpl userSession;
        if ((userSession = theAppServer.getExistingSession(userSessionId)) != null) {
            userSession.addEventListener(getRemoteReferenceForSecuritySession());
        }
    }
    
    /**
     * @param adminSession VSORBSecuritySession
     * @internal.tle
     */
    public void addEventListener(VSORBSecuritySession adminSession) {
        
        // Add this listener if we haven't already
        try {
            if (getServerEventDispatch(adminSession.getSessionID()) == null) {
                serverEventListeners.addElement(new ServerEventDispatch(adminSession.getSessionID(), false));
            }
        } catch (Exception e) {
            throw new ServerException(AdminMsgCode.FAILED_ADD_EVENT_LISTENER);
        }
    }
    
    /**
     * Method addSessionListener.
     *
     * @param aListener SessionListener
     * @see Session#addSessionListener(SessionListener)
     */
    public void addSessionListener(SessionListener aListener) {
        
        // Add this listener if we haven't already
        if (!container.contains(aListener)) {
            container.addElement(aListener);
        }
    }
    
    /**
     * Method removeSessionListener.
     *
     * @param aListener SessionListener
     * @see Session#removeSessionListener(SessionListener)
     */
    public void removeSessionListener(SessionListener aListener) {
        container.removeElement(aListener);
    }
    
    /**
     * @param userSessionId int
     * @internal.tle
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#removeEventListener(int)
     */
    public void removeEventListener(int userSessionId) {
        VSORBSessionImpl userSession;
        if ((userSession = theAppServer.getExistingSession(userSessionId)) != null) {
            userSession.removeEventListener(getRemoteReferenceForSecuritySession());
        }
    }
    
    /**
     * @param adminSession VSORBSecuritySession
     * @internal.tle
     */
    public void removeEventListener(VSORBSecuritySession adminSession) {
        ServerEventDispatch sed;
        try {
            sed = getServerEventDispatch(adminSession.getSessionID());
        } catch (Exception e) {
            throw new ServerException(AdminMsgCode.FAILED_REMOVE_EVENT_LISTENER);
        }
        if (sed != null) {
            serverEventListeners.removeElement(sed);
        }
    }
    
    /**
     * @param userSessionId int
     * @return ServerEvent[]
     * @throws ServerSecurityException
     * @internal.tle
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#getNextServerEvents(int)
     */
    public ServerEvent[] getNextServerEvents(int userSessionId) throws ServerSecurityException {
        
        havePermission("getNextServerEvents", false);
        VSORBSessionImpl userSession;
        if ((userSession = theAppServer.getExistingSession(userSessionId)) != null) {
            return userSession.getNextServerEvents(getRemoteReferenceForSecuritySession());
        } else {
            // Create a dummy event
            ServerEvent evt = new ServerEvent();
            evt.date = "";
            evt.time = "";
            evt.user = "";
            evt.title = "";
            evt.description = "";
            
            ServerEvent[] retVal = new ServerEvent[1];
            retVal[0] = evt;
            return retVal;
        }
    }
    
    /**
     * @param adminSession VSORBSecuritySession
     * @return ServerEvent[]
     * @internal.tle
     */
    public ServerEvent[] getNextServerEvents(VSORBSecuritySession adminSession) {
        
        // Create a dummy event
        ServerEvent evt = new ServerEvent();
        evt.date = "";
        evt.time = "";
        evt.user = "";
        evt.title = "";
        evt.description = "";
        
        // Get event dispatcher
        ServerEventDispatch sed;
        try {
            sed = getServerEventDispatch(adminSession.getSessionID());
        } catch (Exception e) {
            throw new ServerException(AdminMsgCode.FAILED_SERVER_EVENT_DISPATCH);
        }
        ServerEvent[] retVal;
        
        if (sed == null || sed.serverEvents.size() == 0) {
            retVal = new ServerEvent[1];
            retVal[0] = evt;
        } else {
            // Clone the current sessions vector
            Vector tempVector = (Vector)sed.serverEvents.clone();
            tempVector.insertElementAt(evt, 0);
            
            // Remove old events
            sed.serverEvents.removeAllElements();
            
            // Create an array of sessions
            retVal = new ServerEvent[tempVector.size()];
            
            // Copy the sessions from the vector into the array.
            tempVector.copyInto(retVal);
        }
        return retVal;
    }
    
    /**
     * @internal.tle
     */
    private ServerEventDispatch getServerEventDispatch(int id) {
        for (Enumeration e = serverEventListeners.elements(); e.hasMoreElements();) {
            ServerEventDispatch sed = (ServerEventDispatch)e.nextElement();
            if (sed.ID == id) {
                return sed;
            }
        }
        return null;
    }
    
    /**
     * Returns the current version of security data.  Used to manage security caching.
     *
     * @return int
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getCurrentVersion()
     */
    public int getCurrentVersion() {
        return AppSrvSecXDAConnector.getDataStoreVersion();
    }
    
    /**
     * This method returns a handle to the VSORBAppServerImpl, which is the object representing the server.  With this handle it is
     * possible to call any oth the methods on that object, in order to create new sessions, replicate security data, or execute
     * various other tasks.
     *
     * @return VSORBAppServerImpl    reference to the application server object
     * @see Session#getServer()
     */
    public VSORBAppServerImpl getServer() {
        return theAppServer;
    }
    //**********************************************************************
    //*** ESM Methods - End
    //**********************************************************************
    
    //Session info
    
    /**
     * @deprecated Since 5.6.0 Will be made private
     */
    public String userName;
    
    /**
     * @deprecated Since 5.6.0 Will be made private
     */
    public String password;
    
    /**
     * @deprecated Since 5.6.0 Will be made private
     */
    public VSORBAppServerImpl theAppServer;
    
    private String repositoryName;
    
    //connections belonging to this session
    private Vector connections = new Vector(2);
    
    private boolean clientOverrideSchema;
    private String databaseName;
    private String schema;
    private String databaseTypeName;
    private String[] locale;
    
    //**********************************************************************
    //*** Security Methods - Beginning
    //**********************************************************************
    AppUserImpl userComponent;
    
    /**
     * @param secObject SecurityObject
     * @param clientAppName String
     * @param internalSession boolean
     * @param validatePassword boolean
     * @return boolean
     * @throws ServerSecurityException
     * @internal.tle Called to check security rights when session is opened 1. Check that user exists 2. Check that the password is
     * correct 3. Check if SysAdmin, if so, be happy and return true 4. Check if user has connect privilege through a role 5.
     * Special step for running VersataESM or other security session.  Check that user has manage user privilege. 6. Check that user
     * has access to the currently executing client application
     */
    
    protected boolean authenticateUser(SecurityObject secObject, String clientAppName, boolean internalSession,
        boolean validatePassword) throws ServerSecurityException {
        if (internalSession ) {
            Parameter[] filter = new Parameter[1];
            filter[0] = new Parameter("AppUser", "UserName", "System Administrator");
            if (theAppServer.getInternalSession() != null) {
                userComponent = (AppUserImpl)AppUserImpl.getObjectByKey(new SearchRequest(filter), theAppServer
                    .getInternalSession());
            }
            if (userComponent == null) {
                userComponent = new AppUserImpl();
                userComponent.initBusinessObject(this, new DataRow(this, GenericComponentFactory.getMetaQuery(
                    "com.versata.tl.vls.admin", "AppUser"), true));
                userComponent.setAppSvrLoginID("sa");
                userComponent.setAppSvrPassword("sa");
                userComponent.setUserName("System Administrator");
            }
            
            return true;
        }
        if (isSecuritySession() ) {
            SearchRequest filter = new SearchRequest();
            filter.add(new Parameter("AppUser", "AppSvrLoginID", secObject.getLoginID()));
            userComponent = (AppUserImpl)AppUserImpl.getObjectByKey(filter, this);
        } else {
            userComponent = AppUserImpl.getUserObject(secObject.getLoginID(), theAppServer.getInternalSession());
        }
        
        try {
            if (userComponent == null) {
                throw new ServerSecurityException(ErrorMsgCode.VSMSG_loginError, secObject.getLoginID());
            }
            
            if (validatePassword) {
                if (!userComponent.validatePassword(secObject)) {
                    throw new ServerSecurityException(ErrorMsgCode.VSMSG_passwordError);
                }
            }
            
            Properties props = userComponent.getUserPrivileges();
            
            if (((Boolean)props.get(DataConst.AppRoleImpl_SYSADMIN)).booleanValue()) {
                return true;
            }
            
            if (!((Boolean)props.get(DataConst.AppRoleImpl_CONNECT)).booleanValue()) {
                throw new ServerSecurityException(ErrorMsgCode.VSMSG_connectError);
            }
            
            if (isSecuritySession()) {
                if (!((Boolean)props.get(DataConst.AppRoleImpl_SECADMIN)).booleanValue()) {
                    throw new ServerSecurityException(ErrorMsgCode.VSMSG_appExecuteError);
                }
                
                if (isConsoleSession()) {
                    return true;
                }
            }
            
            if (clientAppName != null) {
                if (!getMyPrivilegeToObjectNameInternal(DataConst.AppObjectPrivilegeImpl_EXECUTE, clientAppName,
                    DataConst.AppObjectTypeCodeImpl_APPLICATION_OBJECT)) {
                    throw new ServerSecurityException(ErrorMsgCode.VSMSG_appExecuteError);
                }
            }
        } catch (VSORBException ex) {
            throw new ServerSecurityException(ErrorMsgCode.VSMSG_appExecuteError, ex);
        } catch (ServerSecurityException ex) {
            throw ex;
        } catch (ServerException e) {
            throw new ServerSecurityException(ErrorMsgCode.VSMSG_appExecuteError, e);
        }
        
        return true;
    }
    
    /**
     * @return AppUserImpl
     * @internal.tle
     */
    public AppUserImpl getCurrentAppUser() {
        return userComponent;
    }
    
    /**
     * This method returns a resultset of all the roles for which the current user has granting privileges.  Since this is a
     * resultset, it could be mapped to a VSResultset and then displayed and updated in bound controls.  Programming such a feature
     * requires detailed knowledge of the VFC.  Please review the VFC documentation for how to set up a resultset and assign it to a
     * data control. This method can return a VSORBException if errors occur, and returns a ServerSecurityException if the current
     * session does not have PRIVILEGE_MANAGE_USERS or PRIVILEGE_SYSADMIN.
     *
     * @return VSORBResultSet    Resultset contains all roles to which the current user has granting rights
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getMyRolesToGrant()
     */
    public VSORBResultSet getMyRolesToGrant() throws VSORBException, ServerSecurityException {
        
        Properties privs = userComponent.getUserPrivileges();
        VSORBResultSetImpl rs;

        String packageName = VSRepositoryMetaCache.get(getRepositoryName()).getPackageName("AppRole");
        
        if (getUserName().equalsIgnoreCase(DataConst.AppUserImpl_SYSADMIN_USERNAME)
                        || ((Boolean)privs.get(DataConst.AppRoleImpl_SYSADMIN)).booleanValue()) {
            Parameter[] sorter = new Parameter[1];
            sorter[0] = new Parameter("AppRole", "RoleName", "ASC");
            rs = (VSORBResultSetImpl)GenericComponentFactory.getResultSet(packageName, "AppRole", null, new SearchRequest(
                sorter), 1, (VSORBSessionImpl)this);
        } else if (((Boolean)privs.get(DataConst.AppRoleImpl_SECADMIN)).booleanValue()) {
            if (!preAuthenticated()) {
                rs = userComponent.getRolesToGrant((VSORBSessionImpl)this);
            } else {
                Parameter[] filter = new Parameter[1];
                filter[0] = new Parameter("AppRole", "RoleID", "0");
                rs = (VSORBResultSetImpl)GenericComponentFactory.getResultSet(packageName, "AppRole",
                    new SearchRequest(filter), null, 1, (VSORBSessionImpl)this);
            }
        } else {
            throw new ServerSecurityException(RuntimeMsgCode.VSORBSESSIONIMPL686);
        }
        VSORBResultSet remoteResultSet = rs.getRemoteReference();
        ServerEnvironment.getFactoryImpl().registerRemoteReference(remoteResultSet);
        return remoteResultSet;
    }
    
    /**
     * This method returns a Property array which indicate if the user of this session is a system administrator
     * (PRIVILEGE_SYSADMIN), if he/she has the Manage User privilege (PRIVILEGE_MANAGE_USERS), and if he/she  have connect
     * privileges (PRIVILEGE_CONNECT). These privileges are determined by looking at all the roles that the user is assigned to.
     * This method can return a VSORBException if errors occur retrieving the data.  A PropertySeq can be converted to a Java
     * Properties object using method Util.ConvertToJavaProps.
     *
     * @return PropertySeq    An Array of property objects defined in the IDL file
     * @throws VSORBException
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getMyUserPrivileges()
     */
    public Property[] getMyUserPrivileges() throws VSORBException {
        return !preAuthenticated() ? convertToCorbaProps(userComponent.getUserPrivileges())
            : convertToCorbaProps(getMyUserPrivilegesAsProperties());
    }
    
    // TODO make getRoleProperties(Vector) abstract
    
    /**
     * Method getMyUserPrivilegesAsProperties.
     *
     * @return Properties
     * @throws VSORBException
     */
    public Properties getMyUserPrivilegesAsProperties() throws VSORBException {
        return ((VSORBSessionImpl)this).getRoleProperties(getRoleList());
    }
    
    /**
     * This method returns a Property array which indicate what rights the current user has to the current object.  If the object
     * was a business object, the properties returned in the structure are PRIVILEGE_READ, PRIVILEGE_CREATE, PRIVILEGE_UPDATE, and
     * PRIVILEGE_DELETE.  Otherwise, the property returned is PRIVILEGE_EXECUTE.  The algorithm to determine privileges works by
     * looking at the privileges for all roles to which the user is assigned.  The object name should NOT include the repository as
     * part of the name, because that is included within this method. This method can return a VSORBException if errors occur
     * retrieving the data.  A PropertySeq can be converted to a Java Properties object using method Util.ConvertToJavaProps.
     *
     * @param objectName the name of the object where security info is requested. Do not include repostory name as part of object
     * name.
     * @param objectType The name of the object where security info is requested. See DataConst for Object type constants.
     * @return PropertySeq    An Array of propety objects defined in the IDL file
     * @throws VSORBException
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getMyObjectPrivileges(String, String)
     */
    public Property[] getMyObjectPrivileges(String objectName, String objectType) throws VSORBException {
    	
    	if(!getSecurityCheck()) {
    		return prepareAllTruePrivilegeProps(objectType);
    	}
    	
        String repositoryName = getRepositoryName();
        if (!preAuthenticated()) {
            return convertToCorbaProps(userComponent.getUserObjectPrivileges(repositoryName, objectName, objectType));
        } else {
            Properties systemPrivs = ((VSORBSessionImpl)this).getRoleProperties(getRoleList());
            if (((Boolean)systemPrivs.get(DataConst.AppRoleImpl_SYSADMIN)).booleanValue()) {
                return prepareAllTruePrivilegeProps(objectType);
            }
            Properties props = new Properties();            
            Properties securityPrivs = checkSecurityTables(objectName, objectType, systemPrivs, repositoryName);
            if (securityPrivs != null) {
                return convertToCorbaProps(securityPrivs);
            }
            
            AppObjectImpl appObject = AppObjectImpl.getBusinessObject(repositoryName, objectName, theAppServer
                .getInternalSession());
            AppUserObjectPrivilege objectPrivilege = getObjPrivs(Integer.valueOf((int)appObject.getObjectID()), appObject
                .getEnforceColumnSecurity());
            
            // since objectPrivilege should never be null, maybe add an else which throws exception??
            if (objectPrivilege != null) {
                if (DataConst.isValidObjectType(objectType)) {
                    props.put(DataConst.AppObjectPrivilegeImpl_READ, Boolean.valueOf(objectPrivilege.readPrivilege));
                    props.put(DataConst.AppObjectPrivilegeImpl_CREATE, Boolean.valueOf(objectPrivilege.createPrivilege));
                    props.put(DataConst.AppObjectPrivilegeImpl_UPDATE, Boolean.valueOf(objectPrivilege.updatePrivilege));
                    props.put(DataConst.AppObjectPrivilegeImpl_DELETE, Boolean.valueOf(objectPrivilege.deletePrivilege));
                } else {
                    props.put(DataConst.AppObjectPrivilegeImpl_EXECUTE, Boolean.valueOf(objectPrivilege.executePrivilege));
                }
            }
            
            return convertToCorbaProps(props);
        }
    }

	/**
	 * This method prepares a property array with all privileges set to true. In case of business object
	 * the property contains TRUE for read, create, update, delete. Otherwise it contains true for execute. 
	 * @param objectType
	 * @return
	 */
	private Property[] prepareAllTruePrivilegeProps(String objectType) {
		Properties props = new Properties();
		if (DataConst.isValidObjectType(objectType)) {
		    setProps(props, true);
		} else {
		    props.put(DataConst.AppObjectPrivilegeImpl_EXECUTE, Boolean.valueOf(true));
		}
		return convertToCorbaProps(props);
	}
    
    /**
     * This method returns a Hashtable which includes what rights the current user does not have to the attributes of a business
     * object.  If the object was not a business object or column security is not enabled for the business object, an empty
     * hashtable is returned.  Otherwise, the hashtable includes each attribute which cannot be viewed, and each attribute which
     * cannot be edited (so the same attribute can appear twice.  Each entry is prepended with a DataConst.VIEW_SIGN or a
     * DataConst.EDIT_SIGN. The algorithm to determine privileges works by looking at the attribute privileges for all roles to
     * which the user is assigned.  The object name should NOT include the repository as part of the name, because that is included
     * within this method. This method can return a VSORBException if errors occur retrieving the data.
     *
     * @param objectName the name of the object where security info is requested. Do not include repostory name as part of object
     * name.
     * @return Hashtable    An hashtable of entries containing column security exceptions
     * @throws VSORBException
     * @see Session#getMyAttributeSecurityExceptions(String)
     */
    public Hashtable getMyAttributeSecurityExceptions(String objectName) throws VSORBException {
        
        String repositoryName = getRepositoryName();
        
        if (!"com.versata.tl.vls.admin".equals(repositoryName)&&(!"VLSWebConsole".equals(repositoryName))) {
            if (!preAuthenticated()) {
                return userComponent.getAttributeSecurityExceptions(repositoryName, objectName);
            } else {
                Properties systemPrivs = ((VSORBSessionImpl)this).getRoleProperties(getRoleList());
                if (!((Boolean)systemPrivs.get(DataConst.AppRoleImpl_SYSADMIN)).booleanValue()) {
                    Properties securityPrivs =checkSecurityTables(objectName, DataConst.DATA_OBJECT, systemPrivs, repositoryName);
                    if (securityPrivs == null) {
                        AppObjectImpl obj = AppObjectImpl.getBusinessObject(repositoryName, objectName, theAppServer
                            .getInternalSession());
                        if (obj != null) {
                            AppUserObjectPrivilege objectPrivilege = getObjPrivs(Integer.valueOf((int)obj.getObjectID()), obj
                                .getEnforceColumnSecurity());
                            if (objectPrivilege != null) {
                                return objectPrivilege.getColumnExceptions();
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
    
    /**
     * This method returns a properties object which contains an entry for attributes in the object to which the user does not have
     * viewing rights. By default, a user has view privileges to all attributes unless the Attribute security enforcement flag is
     * turned on, hence this properties object may often be empty.  Also, if the GetNonReadableFields method in the BusinessObject
     * is overridden or column security is turned on, there could be a list of non-viewable attributes.  The object name should NOT
     * include the repository as part of the name, because that is included within this method. This method can return a
     * VSORBException if errors occur retrieving the data. A PropertySeq can be converted to a Java Properties object using method
     * Util.ConvertToJavaProps.
     *
     * @param objectName the name of the data or query object where attribute info is requested. Do not include repostory name as
     * part of object name.
     * @return StringSeq    An Array of attribute names
     * @throws VSORBException
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getMyNonViewableColumnPrivileges(String)
     */
    public Property[] getMyNonViewableColumnPrivileges(String objectName) //exposed via CORBA
    throws VSORBException {
        String packageName = VSRepositoryMetaCache.get(getRepositoryName()).getPackageName(objectName);
        BusinessObjectImpl comp = GenericComponentFactory.getBusinessObject(packageName, objectName);
        VSMetaQuery mq = GenericComponentFactory.getMetaQuery(packageName, objectName);
        comp.initBusinessObject(this, new DataRow(this, mq, false));
        return convertToCorbaProps(comp.getNonReadableFields(true));
    }
    
    /**
     * This method returns a Property array structure which contains an entry for all attributes in the object (this is the key),
     * and a Boolean value to indicate whether this user has update privileges to each attribute.  By default, a user has update
     * privileges to all attributes unless the GetUpdateableFields method in the BusinessObject is overridden.  The object name
     * should NOT include the repository as part of the name, because that is included within this method. This method can return a
     * VSORBException if errors occur retrieving the data.  A PropertySeq can be converted to a Java Properties object using method
     * Util.ConvertToJavaProps.
     *
     * @param objectName the name of the data or query object where attribute info is requested. Do not include repostory name as
     * part of object name.
     * @return PropertySeq    An Array of property objects defined in the IDL file
     * @throws VSORBException
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getMyUpdateableColumnPrivileges(String)
     */
    public Property[] getMyUpdateableColumnPrivileges(String objectName) //exposed via CORBA
    throws VSORBException {
        String packageName = VSRepositoryMetaCache.get(getRepositoryName()).getPackageName(objectName);
        BusinessObjectImpl comp = GenericComponentFactory.getBusinessObject(packageName, objectName);
        VSMetaQuery mq = GenericComponentFactory.getMetaQuery(packageName, objectName);
        comp.initBusinessObject(this, new DataRow(this, mq, false));
        return convertToCorbaProps(comp.getUpdateableFields(true));
    }
    
    private Property[] convertToCorbaProps(Hashtable propsIn) {
        Property[] propsOut = new Property[propsIn.size()];
        Enumeration hashKeys = propsIn.keys();
        for (int x = 0; hashKeys.hasMoreElements(); x++) {
            String keyName = (String)hashKeys.nextElement();
            propsOut[x] = new Property(keyName, propsIn.get(keyName).toString());
        }
        return propsOut;
    }
    
    /**
     * This method returns a boolean which indicate if the user of this session has the privilege being asked about.  You may pass
     * in any user privilege type. The privilege value is determined by looking at all the roles that the user is assigned to.  This
     * method can return a VSORBException if errors occur retrieving the data.
     *
     * @param privilegeType The privilege type for which the method is getting security info. See DataConst for privilege type
     * constants.
     * @return boolean    a flag indicating whether the user had the specified privilege
     * @throws VSORBException
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getMyUserPrivilege(String)
     */
    public boolean getMyUserPrivilege(String privilegeType) throws VSORBException {
        if (preAuthenticated()) {
            Properties props = ((VSORBSessionImpl)this).getRoleProperties(getRoleList());
            
            if (((Boolean)props.get(DataConst.AppRoleImpl_SYSADMIN)).booleanValue()) {
                // if you have sysadmin, you have everything
                return true;
            }
            
            if (privilegeType.equals(DataConst.AppRoleImpl_CONNECT)
                            && ((Boolean)props.get(DataConst.AppRoleImpl_CONNECT)).booleanValue()) {
                return true;
            }
            
            return privilegeType.equals(DataConst.AppRoleImpl_SECADMIN)
            && ((Boolean)props.get(DataConst.AppRoleImpl_SECADMIN)).booleanValue();
            
        } else {
            return userComponent.getUserPrivilege(privilegeType);
        }
    }
    
    /**
     * This method returns a boolean which indicate if the user of this session has the specified privilege to the object being
     * asked about.  You may pass in any of the object privilege types appropriate for the object type.  The privilege value are
     * determined by looking at all the roles that the user is assigned to. The object name should NOT include the repository as
     * part of the name, because that is included within this method.  This method can return a VSORBException if errors occur
     * retrieving the data.
     *
     * @param privilegeType The privilege type for which the method is getting security info. See DataConst for privilege type
     * constants.
     * @param objectName the name of the object where security info is requested. Do not include repostory name as part of object
     * name.
     * @param objectType The name of the object where security info is requested. See DataConst for Object type constants.
     * @return boolean    a flag indicating whether the user had the specified privilege
     * @throws VSORBException
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getMyPrivilegeToObjectName(String, String, String)
     */
    public boolean getMyPrivilegeToObjectName(String privilegeType, String objectName, String objectType) throws VSORBException {
        
        // KLC - Return true if server side security is turned off
        return !getSecurityCheck() || getMyPrivilegeToObjectNameInternal(privilegeType, objectName, objectType);
        
    }
    
    /*
     *  Used by the authenticateUser method to avoid the checkObjectSecurity=false property
     *  short-circuiting the check for role permissions on login.  Only intended to be used by
     *  the authenticateUser method, internally.
     */
    protected boolean getMyPrivilegeToObjectNameInternal(String privilegeType, String objectName, String objectType) {
        
        String repositoryName = getRepositoryName();
        if (privilegeType.equals(DataConst.AppObjectPrivilegeImpl_READ) && "com.versata.tl.vls.admin".equals(repositoryName)) {
            return isSecuritySession();
        }
        if (privilegeType.equals(DataConst.AppObjectPrivilegeImpl_READ) && "VLSWebConsole".equals(repositoryName)) {
            return isSecuritySession();
        }
        if (privilegeType.equals(DataConst.AppObjectPrivilegeImpl_READ) && "VLSWebConsole".equals(repositoryName)) {
            return isSecuritySession();
        }
        
        if (preAuthenticated()) {
            Properties systemPrivs = ((VSORBSessionImpl)this).getRoleProperties(getRoleList());
            
            if (((Boolean)systemPrivs.get(DataConst.AppRoleImpl_SYSADMIN)).booleanValue()) {
                return true;
            }
            Properties securityPrivs = checkSecurityTables(objectName, objectType, systemPrivs, repositoryName);
            if (securityPrivs != null) {
                if (privilegeType.equals(DataConst.AppObjectPrivilegeImpl_READ)) {
                    return ((Boolean)securityPrivs.get(DataConst.AppObjectPrivilegeImpl_READ)).booleanValue();
                }
                if (privilegeType.equals(DataConst.AppObjectPrivilegeImpl_CREATE)) {
                    return ((Boolean)securityPrivs.get(DataConst.AppObjectPrivilegeImpl_CREATE)).booleanValue();
                }
                if (privilegeType.equals(DataConst.AppObjectPrivilegeImpl_UPDATE)) {
                    return ((Boolean)securityPrivs.get(DataConst.AppObjectPrivilegeImpl_UPDATE)).booleanValue();
                }
                if (privilegeType.equals(DataConst.AppObjectPrivilegeImpl_DELETE)) {
                    return ((Boolean)securityPrivs.get(DataConst.AppObjectPrivilegeImpl_DELETE)).booleanValue();
                }
            }
            
            if (DataConst.isValidObjectType(objectType)) {
                AppObjectImpl obj = AppObjectImpl
                .getBusinessObject(repositoryName, objectName, theAppServer.getInternalSession());
                return getUserPrivilegeToObject(privilegeType, Integer.valueOf((int)obj.getObjectID()), obj.getEnforceColumnSecurity());
            } else {
                return getUserPrivilegeToObject(privilegeType, Integer.valueOf(AppObjectImpl.getObjectIDFromName(repositoryName,
                    objectName, objectType, theAppServer.getInternalSession())), false);
            }
        } else {
            return userComponent.getUserPrivilegeToObject(privilegeType, repositoryName, objectName, objectType);
        }
    }
    
    private boolean getUserPrivilegeToObject(String privilegeType, Integer objectID, boolean enforceColumnSecurity)
    throws ServerException {
        
        AppUserObjectPrivilege objectPrivilege = getObjPrivs(objectID, enforceColumnSecurity);
        return objectPrivilege != null && objectPrivilege.getPrivilege(privilegeType);
    }
    
    /**
     * This method returns a boolean which indicate if the user of this session has PRIVILEGE_EXECUTE to the method in the business
     * object being asked about. The privilege value are determined by looking at all the roles that the user is assigned to, and
     * seeing if any have execute privileges to that method. The object name should NOT include the repository as part of the name,
     * because that is included within this method.  This method can return a VSORBException if errors occur retrieving the data.
     *
     * @param privilegeType The privilege type for which the method is getting security info. See DataConst for privilege type
     * constants.
     * @param objectName the name of the data or query object which contains the method. Do not include repostory name as part of
     * object name.
     * @param methodOrColumnName The name of the method for which security info is requested. See DataConst for Object type
     * constants.
     * @return boolean    a flag indicating whether the user had the specified privilege
     * @throws VSORBException
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getMyPrivilegeToMethod(String, String, String)
     */
    public boolean getMyPrivilegeToMethod(String privilegeType, String objectName, String methodOrColumnName) throws VSORBException {
        boolean result = true;
        String repositoryName = getRepositoryName();
        // KLC - return true if server side security is turned off
        if (getSecurityCheck()) {
            if (!preAuthenticated()) {
                return userComponent.getUserPrivilegeToObject(privilegeType, repositoryName, objectName, DataConst.METHOD_OBJECT,
                    methodOrColumnName);
            } else {
                Properties systemPrivs = ((VSORBSessionImpl)this).getRoleProperties(getRoleList());
                if (!((Boolean)systemPrivs.get(DataConst.AppRoleImpl_SYSADMIN)).booleanValue()) {
                    return getUserPrivilegeToObject(privilegeType, Integer.valueOf(AppObjectImpl.getObjectIDFromNameWithParent(
                        repositoryName, methodOrColumnName, objectName, DataConst.METHOD_OBJECT, theAppServer
                        .getInternalSession())), false);
                }
            }
        }
        return result;
    }
    
    /**
     * This method returns a boolean which indicate if the user of this session has PRIVILEGE_EXECUTE to the page in the application
     * object being asked about. The privilege value are determined by looking at all the roles that the user is assigned to, and
     * seeing if any have execute privileges to that page.  The object name should NOT include the repository as part of the name,
     * because that is included within this method.  This method can return a VSORBException if errors occur retrieving the data.
     *
     * @param appName the name of the application which contains the page. Do not include repository name as part of the name.
     * @param pageName The name of the page for which security info is requested. See DataConst for Object type constants.
     * @return boolean    a flag indicating whether the user had the specified privilege
     * @throws VSORBException
     */
    public boolean getMyPrivilegeToAppPage(String appName, String pageName) throws VSORBException {
        return getMyPrivilegeToAppForm(appName, pageName);
    }
    
    /**
     * This method returns a boolean which indicate if the user of this session has PRIVILEGE_EXECUTE to the application
     * object being asked about. The privilege value are determined by looking at all the roles that the user is assigned to, and
     * seeing if any have execute privileges to that application. The object name should NOT include the repository as part of the name,
     * because that is included within this method.  This method can return a VSORBException if errors occur retrieving the data.
     *
     * @param appName the name of the application. Do not include repository name as part of the name.
     * @return boolean    a flag indicating whether the user had the specified privilege
     * @throws VSORBException
     */
    public boolean getMyPrivilegeToApp(String appName) throws VSORBException {
        // For apps packageName is same as repositoryName
        String repositoryName = getRepositoryName();
         if (preAuthenticated()) {
             int id = AppObjectImpl.getObjectIDFromName(repositoryName, appName, DataConst.APPLICATION_OBJECT,
                      theAppServer.getInternalSession());
                if (id == -1) {
                    throw new VSORBException(ErrorMsgCode.VSMSG_InadequateAccessPermission, appName);
                }
             return getUserPrivilegeToObject(DataConst.PRIVILEGE_EXECUTE, Integer.valueOf(id), false);
         }
         else {
             return userComponent.getUserPrivilegeToObject(DataConst.PRIVILEGE_EXECUTE, repositoryName, appName,
                     DataConst.APPLICATION_OBJECT);
         }
    }
    
    /**
     * This method returns a boolean which indicate if the user of this session has PRIVILEGE_EXECUTE to the form in the application
     * object being asked about. The privilege value are determined by looking at all the roles that the user is assigned to, and
     * seeing if any have execute privileges to that form.  The object name should NOT include the repository as part of the name,
     * because that is included within this method.  This method can return a VSORBException if errors occur retrieving the data.
     *
     * @param appName the name of the application which contains the form. Do not include repository name as part of object name.
     * @param formName The name of the form for which security info is requested. See DataConst for Object type constants.
     * @return boolean    a flag indicating whether the user had the specified privilege
     * @throws VSORBException
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getMyPrivilegeToAppForm(String, String)
     */
    public boolean getMyPrivilegeToAppForm(String appName, String formName) throws VSORBException {
        if (appName == null)
            return false;
        
        // BUG13984 -  Prevent backdoor from external link to versata application that user can
        //               not log in to when that application does not have page security.  
        if (!appName.equals(m_appName)) {
            // Fix for Bug16085. The earlier code would work fine if there is NO custom security manager in place. 
            // However, if there is a custom security manager in place there was a side effect that we need to 
            // create the users in the VLS console as well, inspite of having a custom security manager. 
            // If users were not created in the VLS console we got a NPE. Fixing this issue. 
            try {
                if(!getMyPrivilegeToApp(appName)) {
                    return false;
                }
            } catch (VSORBException e) {
              return false;
            }
        }
        // End --BUG13984
       
        // For apps packageName is same as repository name.
        String repositoryName = getRepositoryName();
        
        int id = AppObjectImpl.getObjectIDFromNameWithParent(repositoryName, formName, appName, DataConst.FORM_OBJECT,
            theAppServer.getInternalSession());
        if (id == -1)
            return true;
        
        if (!preAuthenticated())
            return userComponent.getUserPrivilegeToObject(DataConst.PRIVILEGE_EXECUTE, repositoryName, appName,
                DataConst.FORM_OBJECT, formName);
        return getUserPrivilegeToObject(DataConst.PRIVILEGE_EXECUTE, Integer.valueOf(AppObjectImpl.getObjectIDFromNameWithParent(
            repositoryName, formName, appName, DataConst.FORM_OBJECT, theAppServer.getInternalSession())), false);
    }
    
    /**
     * This method returns a boolean which indicate if the user of this session is assigned to a specific role.  This can be used to
     * add additional security features.  For instance, you might set up a role called Email, and any used assigned to this
     * privilege would have the ability to send e-mails from an application.  This method can return a VSORBException if errors
     * occur retrieving the data.
     *
     * @param roleName The role for which user assignment is being checked
     * @return boolean    a flag indicating whether the user is assigned to the specified role
     * @throws VSORBException
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getMyAccessToRole(String)
     */
    public boolean getMyAccessToRole(String roleName) throws VSORBException {
        if (!preAuthenticated()) {
            return userComponent.getUserAccessToRole(roleName);
        } else {
            for (int i = 1; i <= getRoleList().size(); i++) {
                String rl = ((AppRoleImpl)getRoleList().elementAt(i - 1)).getRoleName();
                if (rl.equalsIgnoreCase(roleName)) {
                    return true;
                }
            }
            return false;
        }
    }
    
    /**
     * Test if the caller has a given security role.
     *
     * @param roleName The name of the security role.
     * @return True if the caller has the specified role.
     * @see Session#isCallerInRole(String)
     */
    public boolean isCallerInRole(String roleName) {
        return getMyAccessToRole(roleName);
    }
    
    /**
     * Returns the name of the data server to which a particular data or query object is assigned to. This is most likely that
     * passed back to the server as the data server to be used when executing a SQL statement directly against the data server.
     *
     * @param objectName the name of the data or query object attribute info is requested. Do not include repostory name as part of
     * object name.
     * @return String    The name of a data server
     * @see Session#getDataServerForObject(String)
     */
    public String getDataServerForObject(String objectName) {
        Properties props = userComponent.getUserDataServiceLoginForObject(getRepositoryName(), objectName);
        return props != null ? (String)props.get("DataServerName") : "";
    }
    
    /**
     * This method returns a Java properties structure which contains all the properties defined for the data server that this
     * object is associated with. All the information necessary to connect is included in the properties, including login and
     * password. This information is generally for use by an XDAconnector to establish a data server connection or submit rerad or
     * update requests. The properties in the structure vary according to the type of the data server.
     *
     * @param objectName the name of the business object for which data server connection properties should be retrieved.  Do not
     * include the repository name
     * @return Properties    Java Properties Object containing all defined properties used to create a connection to the data
     *         server
     * @throws ServerException
     * @see Session#getMyDataServiceLoginForObject(String)
     */
    public Properties getMyDataServiceLoginForObject(String objectName) throws ServerException {
        String repositoryName = getRepositoryName();
        if ("com.versata.tl.vls.admin".equals(repositoryName)) {
            return new Properties();
        }
        if ("VLSWebConsole".equals(repositoryName)) {
            return new Properties();
        }
        if ("VLSWebConsole".equals(repositoryName)) {
            return new Properties();
        }
        if (!preAuthenticated() || (getUserID().length()>0)) {
            return userComponent.getUserDataServiceLoginForObject(repositoryName, objectName);
        } else {
            if ("AppObject".equals(objectName)) {
                return new Properties();
            }
            // selva
            if (_LOGGER.isDebugEnabled()) {
                if (theAppServer == null) {
                    _LOGGER.debug("AppServer is null in session, session possibly closed");
                    _LOGGER.debug("threadID is" + Thread.currentThread().getId());
                }
            }
            AppObjectImpl appObject = AppObjectImpl.getBusinessObject(repositoryName, objectName, theAppServer
                .getInternalSession());
            if (appObject == null) {
                throw new ServerException(AdminMsgCode.BUSINESS_OBJECT_NOT_FOUND, new Object[] { repositoryName + '.'
                    + objectName });
            }
            
            AppDataSourceLocationImpl dataServer = appObject.getDataServer();
            if (dataServer == null) {
                throw new ServerException(AdminMsgCode.NO_DATASERVER_ASSIGNED, new Object[] { repositoryName + '.' + objectName });
            }
            
            return dataServer.getAnonymousConProperties();
        }
    }
    
    /**
     * This method returns a Java properties structure which contains all the properties defined for this data server.  All the
     * information necessary to connect is included in the properties, including login and password.  This information is generally
     * for use by an XDAconnector to establish a data server connection or submit rerad or update requests.  The properties in the
     * structure vary according to the type of the data server.
     *
     * @param dsLocationName the name of the data server
     * @return Properties        Java Properties Object containing all defined properties used to create a connection to the data
     *         server
     */
    public Properties getMyDataServiceLogin(String dsLocationName) {
        return userComponent.getUserDataServiceLoginSecurityInfo(dsLocationName);
    }
        
    /**
     * returns the name of the repository.
     */
    public String getRepositoryName() {
        return repositoryName;
    }
    
    /**
     * @return the client App name set in the constructor. Might be null.
     */
    public String getAppName() {
        return m_appName;
    }
    
    /**
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#setRepositoryName(String)
     */
    public void setRepositoryName(String repositoryName){
        this.repositoryName = repositoryName;
    }
    
    private String getIndent() {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < getGlobalNestLevel(); i++) {
            ret.append("....");
        }
        return ret.toString();
    }
    
    /**
     * @return global nest level
     * @internal.tle TODO: REVIEW ILogConnector uses some of these
     */
    public int getGlobalNestLevel() {
        VSTransactionInfo tx = getTransactionInfo();
        return tx == null ? 0 : tx.getGlobalNestLevel();
    }
    
    /*  BML - Keep around for testing
     public void testExtPropFunctions()
     {
     try {
     System.out.println("role1: " + getRoleProperties("NewRole"));
     System.out.println("role2: " + getRoleProperties(3));
     System.out.println("object1: " + getObjectProperties("SampDB1.ORDERS", "D"));
     System.out.println("object2: " + getObjectProperties(1));
     System.out.println("object3: " + getObjectProperties("SampDB1.Demo", "A"));
     System.out.println("user: " + getUserProperties("Guest"));
     System.out.println("userRole1: " + getUserRoleProperties("Guest", "NewRole"));
     System.out.println("userRole2: " + getUserRoleProperties("Guest", 3));
     
     Properties[] pp = getUserRolePropertiesForUser("Guest");
     System.out.println("userRole3: entries = " + pp.length);
     for (int x = 0; x < pp.length; x++)
     System.out.println("      prop = " + pp[x]);
     
     System.out.println("objPriv1: " + getObjectPrivilegeProperties("SampDB1.ORDERS", "D", "NewRole"));
     System.out.println("objPriv2: " + getObjectPrivilegeProperties(1, 3));
     
     pp = getObjectPrivilegePropertiesForObject("SampDB1.ORDERS", "D");
     System.out.println("objPriv3: entries = " + pp.length);
     for (int x = 0; x < pp.length; x++)
     System.out.println("      prop = " + pp[x]);
     
     System.out.println("objPriv4: " + getObjectPrivilegeProperties("SampDB1.Demo", "A", "NewRole"));
     System.out.println("objPriv5: " + getObjectPrivilegeProperties("SampDB1.OrderJoinSalesRep", "Q", "NewRole"));
     
     pp = getObjectPrivilegePropertiesForObject("SampDB1.Demo", "A");
     System.out.println("objPriv6: entries = " + pp.length);
     for (int x = 0; x < pp.length; x++)
     System.out.println("      prop = " + pp[x]);
     
     } catch (Exception e) {
     Util.logWarning (logger, e);
     }
     }
     end testing code */
    
    /**
     * @internal.tle
     */
    protected void clearSecurityCache() {
        //This is called in response to commit of security transaction.
        //FINIS merge
        if (isConsoleSession()) {
            AppDataSourceLocationImpl.clearCache();
            AppObjectImpl.clearCache();
            AppUserImpl.clearCache();
            AppRoleImpl.clearCache();
            BusinessObjectImpl.clearColumnSecurityCaches();
        }
    }
    
    /**
     * This method returns a Java properties structure which contains all the role properties defined for this installation, and all
     * the values assigned to those properties for this particular role.  The property name is the key of the Properties object, and
     * the value of the property is the object of each Property's instance value.  The name passed into the routine is the name of
     * the role instance.
     *
     * @param name the name of the role for which properties should be retrieved
     * @return Properties    Java Properties Object containing all defined properties for this role
     * @see Session#getRoleProperties(String)
     */
    public Properties getRoleProperties(String name) {
        SearchRequest filter = new SearchRequest();
        filter.add(new Parameter("AppRole", "RoleName", name));
        AppRoleImpl role = (AppRoleImpl)AppRoleImpl.getObjectByKey(filter, getServer().getInternalSession());
        return role != null ? role.getProperties() : null;
    }
    
    /**
     * This method returns a Java properties structure which contains all the role properties defined for this installation, and all
     * the values assigned to those properties for this particular role.  The property name is the key of the Properties object, and
     * the value of the property is the object of each Property's instance value.  The id passed into the routine is the internal id
     * of the role instance.
     *
     * @param id the internal ID of the role for which properties should be retrieved
     * @return Properties    Java Properties Object containing all defined properties for this role
     * @see Session#getRoleProperties(long)
     */
    public Properties getRoleProperties(long id) {
        SearchRequest filter = new SearchRequest();
        filter.add(new Parameter("AppRole", "RoleID", Long.toString(id)));
        AppRoleImpl role = (AppRoleImpl)AppRoleImpl.getObjectByKey(filter, getServer().getInternalSession());
        return role != null ? role.getProperties() : null;
    }
    
    /**
     * This method returns a Java properties structure which contains all the properties defined for this object type at this
     * installation, and all the values assigned to those properties for this particular object.  The object type may be an
     * APPLICATION_OBJECT, or one of the business object types (DATA_OBJECT, QUERY_OBJECT, BUSINESS_OBJECT).  These will return all
     * application properties or all business object properties.  The property name is the key of the Properties object, and the
     * value of the property is the object of each Property's instance value.  The name passed into the routine is the name of the
     * application or business object, without the repository name (which is prepended internally).
     *
     * @param name the name of the object for which properties should be retrieved Do not include the repository name
     * @param type the type of the object for which properties should be retrieved
     * @return Properties    Java Properties Object containing all defined properties for this object
     * @see DataConst
     */
    public Properties getObjectProperties(String name, String type) {
        AppObjectImpl obj;
        String repositoryName = getRepositoryName();
        if (type.equals(DataConst.AppObjectTypeCodeImpl_DATA_OBJECT)
                        || type.equals(DataConst.AppObjectTypeCodeImpl_BUSINESS_OBJECT)
                        || type.equals(DataConst.AppObjectTypeCodeImpl_QUERY_OBJECT)) {
            obj = AppObjectImpl.getBusinessObject(repositoryName, name, getServer().getInternalSession());
        } else {
            SearchRequest filter = new SearchRequest();
            filter.add(new Parameter("AppObject", "ObjectName", name));
            filter.add(new Parameter("AppObject", "ObjectType", type));
            filter.add(new Parameter("AppObject", "RepositoryName", repositoryName));
            obj = (AppObjectImpl)AppObjectImpl.getObjectByKey(filter, getServer().getInternalSession());
        }
        return obj != null ? obj.getProperties() : null;
    }
    
    /**
     * This method returns a Java properties structure which contains all the properties defined for this object type at this
     * installation, and all the values assigned to those properties for this particular object.  These will return all application
     * properties or all business object properties, depending upon the type of the object selected. The property name is the key of
     * the Properties object, and the value of the property is the object of each Property's instance value.  The id passed into the
     * routine is the internal object ID of the application or business object.
     *
     * @param id the internal ID of the object for which properties should be retrieved
     * @return Properties    Java Properties Object containing all defined properties for this object
     * @see Session#getObjectProperties(long)
     */
    public Properties getObjectProperties(long id) {
        SearchRequest filter = new SearchRequest();
        filter.add(new Parameter("AppObject", "ObjectID", Long.toString(id)));
        AppObjectImpl obj = (AppObjectImpl)AppObjectImpl.getObjectByKey(filter, getServer().getInternalSession());
        return obj != null ? obj.getProperties() : null;
    }
    
    /**
     * This method returns a Java properties structure which contains all the user properties defined for this installation, and all
     * the values assigned to those properties for this particular user.  The property name is the key of the Properties object, and
     * the value of the property is the object of each Property's instance value.
     *
     * @param loginID the login ID of the user for which properties should be retrieved
     * @return Properties    Java Properties Object containing all defined properties for this user
     * @see Session#getUserProperties(String)
     */
    public Properties getUserProperties(String loginID) {
        AppUserImpl user = AppUserImpl.getUserObject(loginID, getServer().getInternalSession());
        return user != null ? user.getProperties() : null;
    }
    
    /**
     * This method returns a Java Properties structure which contains all the User Role properties defined for this installation,
     * and all the values assigned to those properties for this particular user/role assignment.  The property name is the key of
     * the Properties object, and the value of the property is the object of each Property's instance value.
     *
     * @param loginID the login ID of the user for which user role properties should be retrieved
     * @param roleName the name of the role for which user role properties should be retrieved
     * @return Properties    Java Properties Object containing all defined properties for this user role
     * @see Session#getUserRoleProperties(String, String)
     */
    public Properties getUserRoleProperties(String loginID, String roleName) {
        Session ses = getServer().getInternalSession();
        SearchRequest filter = new SearchRequest();
        filter.add(new Parameter("AppRole", "RoleName", roleName));
        AppRoleImpl role = (AppRoleImpl)AppRoleImpl.getObjectByKey(filter, ses);
        AppUserRoleImpl userRole;
        if (role != null) {
            filter = new SearchRequest();
            filter.add(new Parameter("AppUserRole", "AppUserLoginID", loginID));
            filter.add(new Parameter("AppUserRole", "RoleID", Long.toString(role.getRoleID())));
            userRole = (AppUserRoleImpl)AppUserRoleImpl.getObjectByKey(filter, ses);
            if (userRole == null) {
                AppUserImpl user = AppUserImpl.getUserObject(loginID, ses);
                if (user != null) {
                    userRole = AppUserRoleImpl.getNewObject(ses, true);
                    userRole.setAppUserLoginID(loginID);
                    userRole.setRoleID(role.getRoleID());
                } else {
                    return null;
                }
            }
        } else {
            return null;
        }
        return userRole.getProperties();
    }
    
    /**
     * This method returns an array of Java Properties structures.  Each Properties structure contains all the User Role properties
     * defined for this installation, and all the values assigned to those properties for this particular user/role assignment.  It
     * also contains the name of the role these properties are associated with, and an internal RoleID. Using the array, you can
     * loop through all the properties for each privilege to which you might have access. The property name is the key of the
     * Properties object, and the value of the property is the object of each Property's instance value. There are additional keys
     * called RoleName and RoleID in each Properties structure as well.
     *
     * @param loginID the login ID of the user for which all user role properties should be retrieved
     * @return Properties[]    Java Properties array containing all defined properties for all user roles assigned to this user
     * @see Session#getUserRolePropertiesForUser(String)
     */
    public Properties[] getUserRolePropertiesForUser(String loginID) {
        return AppUserRoleImpl.getUserRolePropertiesForUser(loginID, getServer().getInternalSession());
    }
    
    /**
     * This method returns a Java Properties structure which contains all the application privileges or business object privileges
     * (dependent on ObjectType)  properties defined for this installation, and all the values assigned to those properties for this
     * particular object/role combination. The property name is the key of the Properties object, and the value of the property is
     * the object of each Property's instance value. The object type may be an APPLICATION_OBJECT, or one of the business object
     * types (DATA_OBJECT, QUERY_OBJECT, BUSINESS_OBJECT).  These will return all application properties or all business object
     * properties.
     *
     * @param objectName the name of the object for which properties should be retrieved Do not include the repository name
     * @param objectType the type of the object for which properties should be retrieved
     * @param roleName the name of the role for which object privilege properties should be retrieved
     * @return Properties    Java Properties Object containing all defined properties for this object privilege
     * @see DataConst
     */
    public Properties getObjectPrivilegeProperties(String objectName, String objectType, String roleName) {
        
        Session ses = getServer().getInternalSession();
        String repositoryName = getRepositoryName();
        SearchRequest filter;
        AppObjectImpl obj;
        if (objectType.equals(DataConst.AppObjectTypeCodeImpl_DATA_OBJECT)
                        || objectType.equals(DataConst.AppObjectTypeCodeImpl_QUERY_OBJECT)) {
            obj = AppObjectImpl.getBusinessObject(repositoryName, objectName, ses);
        } else {
            filter = new SearchRequest();
            filter.add(new Parameter("AppObject", "ObjectName", objectName));
            filter.add(new Parameter("AppObject", "ObjectType", objectType));
            filter.add(new Parameter("AppObject", "RepositoryName", repositoryName));
            obj = (AppObjectImpl)AppObjectImpl.getObjectByKey(filter, ses);
        }
        if (obj == null) {
            return null;
        }
        
        filter = new SearchRequest();
        filter.add(new Parameter("AppRole", "RoleName", roleName));
        AppRoleImpl role = (AppRoleImpl)AppRoleImpl.getObjectByKey(filter, ses);
        if (role == null) {
            return null;
        }
        
        filter = new SearchRequest();
        filter.add(new Parameter("AppObjectPrivilege", "ObjectID", Long.toString(obj.getObjectID())));
        filter.add(new Parameter("AppObjectPrivilege", "RoleID", Long.toString(role.getRoleID())));
        AppObjectPrivilegeImpl objPriv = (AppObjectPrivilegeImpl)AppObjectPrivilegeImpl.getObjectByKey(filter, ses);
        if (objPriv == null) {
            objPriv = AppObjectPrivilegeImpl.getNewObject(ses, true);
            objPriv.setObjectID(obj.getObjectID());
            objPriv.setRoleID(role.getRoleID());
        }
        return objPriv.getProperties();
    }
    
    /**
     * This method returns a Java Properties structure which contains all the application privileges or business object privileges
     * (dependent on ObjectType)  properties defined for this installation, and all the values assigned to those properties for this
     * particular object/role combination. The property name is the key of the Properties object, and the value of the property is
     * the object of each Property's instance value. The object type may be an APPLICATION_OBJECT, or one of the business object
     * types (DATA_OBJECT, QUERY_OBJECT, BUSINESS_OBJECT).  These will return all application properties or all business object
     * properties.
     *
     * @param objectID the internal ID of the object for which properties should be retrieved
     * @param roleID the internal ID of the role for which object privilege properties should be retrieved
     * @return Properties    Java Properties Object containing all defined properties for this object privilege
     * @see DataConst
     */
    public Properties getObjectPrivilegeProperties(long objectID, long roleID) {
        Session ses = getServer().getInternalSession();
        SearchRequest filter = new SearchRequest();
        filter.add(new Parameter("AppObjectPrivilege", "ObjectID", Long.toString(objectID)));
        filter.add(new Parameter("AppObjectPrivilege", "RoleID", Long.toString(roleID)));
        AppObjectPrivilegeImpl objPriv = (AppObjectPrivilegeImpl)AppObjectPrivilegeImpl.getObjectByKey(filter, ses);
        if (objPriv == null) {
            filter = new SearchRequest();
            filter.add(new Parameter("AppRole", "RoleID", Long.toString(roleID)));
            AppRoleImpl role = (AppRoleImpl)AppRoleImpl.getObjectByKey(filter, ses);
            if (role != null) {
                filter = new SearchRequest();
                filter.add(new Parameter("AppObject", "ObjectID", Long.toString(objectID)));
                AppObjectImpl obj = (AppObjectImpl)AppObjectImpl.getObjectByKey(filter, ses);
                if (obj != null) {
                    objPriv = AppObjectPrivilegeImpl.getNewObject(ses, true);
                    objPriv.setObjectID(objectID);
                    objPriv.setRoleID(roleID);
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
        return objPriv.getProperties();
    }
    
    /**
     * This method returns an array of Java Properties structures.  Each Properties structure contains all the application
     * privileges or business object privileges (dependent on ObjectType)  properties defined for this installation, and all the
     * values assigned to those properties for this particular object/role combination.  It also contains the name of the role these
     * properties are associated with, and an internal RoleID.  Using the array, you can loop through all the properties for each
     * privilege to which you might have access. The property name is the key of the Properties object, and the value of the
     * property is the object of each Property's instance value. There are additional keys called RoleName and RoleID in each
     * Properties structure as well. The object type may be an APPLICATION_OBJECT, or one of the business object types (DATA_OBJECT,
     * QUERY_OBJECT, BUSINESS_OBJECT). These will return all application properties or all business object properties.
     *
     * @param objectName the name of the object for which properties should be retrieved Do not include the repository name
     * @param objectType the type of the object for which properties should be retrieved
     * @return Properties[]    Java Properties array containing all defined properties for all object privileges assigned to this
     *         object
     * @see Session#getObjectPrivilegePropertiesForObject(String, String)
     */
    public Properties[] getObjectPrivilegePropertiesForObject(String objectName, String objectType) {
        return AppObjectPrivilegeImpl.getObjectPrivilegePropertiesForObject(getRepositoryName(), objectName, objectType, getServer()
            .getInternalSession());
    }
    
    // TODO: This code is added for a customer request to impliment dynamic role assignment. This will be
    //      reviewed and may be deprecated in favor of a better impl.
    
    /**
     * @internal.tle TODO: review Clears the object privilege cache.
     */
    public void clearPrivilegeCache() {
        // SKL clear the global security cache
        GlobalCache.getSingleton().getCache(VSORBSessionImpl_Base.PRIVILEGES_CACHE).clear();
    }
    
    /**
     * @param flag boolean
     * @internal.tle
     */
    public void setSecurityCheck(boolean flag) {
        checkSecurity = flag;
    }
    
    /**
     * Returns a boolean indicating whether a security check should be performed. Security checks apply only to the BusinessObjects
     * that the user modified and do not apply to data modified indirectly by system rules.  Therefore the system will turn off
     * security checks for the duration of the remote method after checking security on the user-modified data.
     *
     * @return boolean    does security need to be checked?
     * @see VSORBAppServerImpl#isSecurityDisabled()
     */
    public boolean getSecurityCheck() {
        // FINIS merge,  VIT49613
    	// Fixing bug that was introduced during some refactoring. See Changelist no. 37324 in perforce.
    	//The ! was wrongly added
        if (theAppServer == null || theAppServer.isSecurityDisabled()) {
            return false;
        }
        /// object access check can be turned off globally
        return checkSecurity;
    }
    
    /**
     * @internal.tle
     */
    public void resetSecurityCheck() {
        checkSecurity = true;
    }
    
    /**
     * sets the timeout period for this session
     *
     * @param expireTime the amount of time this session should wait before timing out.
     */
    public void setExpireTime(long expireTime) {
        mvExpireTime = expireTime;
    }
    
    /**
     * returns the timeout period for this session
     *
     * @return long    returns the amount of time this session waits before timing out.
     */
    public long getExpireTime() {
        // AMR. This logic is here so that the client (PLSApp) can set this through properties.
        String timeoutStr = getProperty("SessionTimeout");
        if (timeoutStr != null && !"".equals(timeoutStr)) {
            try {
                mvExpireTime = 1000 * Integer.parseInt(timeoutStr);
                properties.remove("SessionTimeout");
            } catch (NumberFormatException nfe) {
                _LOGGER.warn(RuntimeMsgCode.EMPTY_MSG, '<' + timeoutStr + "> cannot be parsed as an Integer");
            } catch (Exception e) {
                // FIXME at least write some log
                _LOGGER.warn(e);
            }
        }
        return mvExpireTime;
    }
    
    /**
     * Returns true if errors were found during initial security data load.
     *
     * @return boolean
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getErrorsAtStartup()
     */
    public boolean getErrorsAtStartup() {
        return AppSrvSecXDAConnector.getErrorsAtStartup() || theAppServer.getYtsenohFlag();
    }
    
    /**
     * @throws ServerSecurityException
     * @internal.tle
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#clearErrorsAtStartup()
     */
    public void clearErrorsAtStartup() throws ServerSecurityException {
        havePermission("clearErrorsAtStartup", false);
        AppSrvSecXDAConnector.setErrorsAtStartup(false);
        theAppServer.setYtsenohFlag(false);
    }
    
    /**
     * This method is used to build a custom feature which allows a user to update their own password. Passwords are initially
     * assigned to a user when a user record is created by an administrator. This feature allows you to build a facility where a
     * user can update their own password. It is expected that every production system will call this routine at least once, either
     * through a special option on an regular application or a custom utility built just for this purpose.  This method can return a
     * VSORBException if errors occur, which would include if the loginID or old password are incorrect for this user.
     *
     * @param login The business lgic server login ID of the user about the change their password
     * @param oldPassword The old password of the user about the change their password, Used for verification.
     * @param newPassword The new password the the user wishes to make permanent
     * @param confirmPassword The new password again, used to confirm that they are not types incorrectly
     * @throws VSORBException
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#changeMyPassword(String, String, String, String)
     */
    public void changeMyPassword(String login, String oldPassword, String newPassword, String confirmPassword)
    throws VSORBException {
        if (newPassword == null) {
            newPassword = "";
        }
        if (confirmPassword == null) {
            confirmPassword = "";
        }
        if (!newPassword.equalsIgnoreCase(confirmPassword)) {
            throw new VSORBException(ErrorMsgCode.VSMSG_PasswordMismatch);
        }
        
        if (!userComponent.validatePassword(new SecurityObject(login, oldPassword))) {
            throw new VSORBException(ErrorMsgCode.VSMSG_LoginPasswordReconfirmError);
        }
        
        try {
            userComponent.setAppSvrPassword(newPassword);
            userComponent.setUpdate();
            userComponent.executeRules();
        } catch (VSORBException e) {
            throw e;
        } catch (Throwable e) {
            // Log the error trace in baslog.out
            throw new VSORBException(ErrorMsgCode.VSMSG_UnCheckedException, null, e);
        }
    }
    
    /**
     * @return VSORBSession[]
     * @throws ServerSecurityException
     * @internal.tle
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#getSessions()
     */
    public VSORBSession[] getSessions() throws ServerSecurityException {
        //FINIS merge VIT49613
        
        havePermission("getSessions", false);
        return theAppServer == null ? new VSORBSession[0] : theAppServer.getSessions();
    }
    
    /**
     * @return ServerStatistics
     * @internal.tle
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#getServerStatistics()
     */
    public ServerStatistics getServerStatistics() {
        //FINIS merge
        // VIT49613
        return theAppServer == null ? new ServerStatistics() : theAppServer.getServerStatistics();
    }
    
    /**
     * @return String[]
     * @throws ServerSecurityException
     * @internal.tle
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#getDataServiceIDs()
     */
    public String[] getDataServiceIDs() throws ServerSecurityException {
        havePermission("getDataServiceIDs", false);
        return theAppServer.getDataServiceIDs();
    }
    
    /**
     * @param s String
     * @return DataServiceStatistics
     * @internal.tle
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#getDataServiceStatistics(String)
     */
    public DataServiceStatistics getDataServiceStatistics(String s) {
        return theAppServer.getDataServiceStatistics(s);
    }
    
    /**
     * @internal.tle
     */
    public FileWriter logFileWriter;
    
    /**
     * Method startLogDump.
     *
     * @param fileName String
     * @param append boolean
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#startLogDump(String, boolean)
     */
    public void startLogDump(String fileName, boolean append) {
        try {
            // AMR. 9-10-01. The fileName is passed relative to vls/bin,
            // we need to make it an absolute path.
            logFileWriter = new FileWriter(ServerEnvironment.getBinPath() + fileName, append);
        } catch (Exception ex) {
            _LOGGER.error(ex);
        }
    }
    
    /**
     * @param logString String
     * @internal.tle
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#writeLogString(String)
     */
    public void writeLogString(String logString) {
        try {
            logFileWriter.write(logString + "\r\n");
        } catch (Exception ex) {
            _LOGGER.error(ex);
        }
    }
    
    /**
     * @internal.tle
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#stopLogDump()
     */
    public void stopLogDump() {
        try {
            logFileWriter.flush();
            logFileWriter.close();
            logFileWriter = null;
        } catch (Exception ex) {
            _LOGGER.error(ex);
        }
    }
    
    /**
     * This routine automatically shuts the server down after 5 seconds.  Any operation in progress is rolled back, and all clinet
     * sessions lose their server connection.  Only a system administrator may call this routine.
     *
     * @throws ServerSecurityException
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#shutDownTheServer()
     */
    public void shutDownTheServer() throws ServerSecurityException {
        havePermission("shutDownTheServer", false);
        theAppServer.shutDownTheServer();
    }
    
    /**
     * Returns the amount of time that should be waited between each ping of the server by the client application.  This is defined
     * in server properties.
     *
     * @return int
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getSessionPingRate()
     */
    public int getSessionPingRate() {
        int pingRate = 60000;
        try {
            pingRate = Integer.parseInt(VSORBAppServerImpl.getProperty("SessionPingRate"));
        } catch (Exception ex) {
            if (_LOGGER.isDebugEnabled()) {
                _LOGGER.debug("VSORBSessionImpl_Base.getSessionPingRate Defaulting pingrate to " + pingRate);
            }
        }
        return pingRate;
    }
    
    /**
     * This method creates a new user or modifies an existing user, after matching on the appServerLogin. It sets the password and
     * the userName according to the parameters supplied. This method can return a VSORBException if errors occur, and returns a
     * ServerSecurityException if the current session does not have PRIVILEGE_MANAGE_USERS or PRIVILEGE_SYSADMIN.
     *
     * @param appServerlogin The login ID of the user to be added or modified
     * @param password The new password for the user
     * @param userName The new user name for the user
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see DataConst
     */
    public void registerUser(String appServerlogin, String password, String userName) throws VSORBException,
    ServerSecurityException {
        
        havePermission("registerUser", true);
        
        DataLine datLine = new DataLine();
        datLine.setLogin(appServerlogin);
        datLine.setPassword(password);
        datLine.setName(userName);
        load(_REGISTER_USER, datLine);
    }
    
    /**
     * This method creates a new role or modifies an existing role, after matching on roleName. It sets the PRIVILEGE_MANAGE_USERS
     * and PRIVILEGE_CONNECT according to the supplied parameters. This method can return a VSORBException if errors occur, and
     * returns a ServerSecurityException if the current session does not have PRIVILEGE_SYSADMIN.
     *
     * @param roleName The new role name
     * @param manageUser boolean
     * @param connect boolean
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see DataConst
     */
    public void registerRole(String roleName, boolean manageUser, boolean connect) throws VSORBException, ServerSecurityException {
        havePermission("registerRole", false);
        
        Properties props = new Properties();
        props.put("CONNECTER", Boolean.toString(connect));
        props.put("SYSADMIN", "FALSE");
        props.put("SECADMIN", Boolean.toString(manageUser));
        
        DataLine datLine = new DataLine();
        datLine.setName(roleName);
        datLine.setProperties(props);
        
        load(_REGISTER_ROLE, datLine);
    }
    
    private void load(int thingToLoad, DataLine dataLine) {
        load(thingToLoad, dataLine, null, false);
    }
    
    private void load(int thingToLoad, DataLine dataLine, String repoName) {
        load(thingToLoad, dataLine, repoName, false);
    }
    
    // TODO -- re-evaluate the location of this logic...
    // This is loading logic that could be pushed into the AppComponentLoader
    //
    // Also, load methods in AppComponentLoader do more than load. They load if the object exists, other wise they create a new component
    // and if the component already exists it overwrite. Yowzers!!!  No we won't rename loadObject to loadOrCreateOrModifyObject...
    private void load(int thingToLoad, DataLine dataLine, String repoName, boolean useExistingConnection) {
        AppComponentLoader compLoader = new AppComponentLoader(this);
        
        try {
            switch (thingToLoad) {
                case _REGISTER_OBJECT:
                    compLoader.loadObject(dataLine, repoName, useExistingConnection);
                    break;
                case _SET_PRIVILEGE:
                    compLoader.loadObjectPrivilege(dataLine, repoName);
                    break;
                case _SET_PROPERTY:
                    compLoader.loadObjectExtendedProperty(dataLine, repoName);
                    break;
                case _REGISTER_USER:
                    compLoader.loadUser(dataLine);
                    break;
                case _SET_USER_ASSIGNMENT:
                    compLoader.loadUserRole(dataLine);
                    break;
                case _SET_USER_DATA_SERVER_LOGIN:
                    compLoader.loadUserDataServerLogin(dataLine);
                    break;
                case _SET_USER_PROPERTY:
                    compLoader.loadUserExtendedProperty(dataLine);
                    break;
                case _SET_USER_ASSIGNMENT_PROPERTY:
                    compLoader.loadUserRoleExtendedProperty(dataLine);
                    break;
                case _SET_ROLE_PROPERTY:
                    compLoader.loadRoleExtendedProperty(dataLine);
                    break;
                case _SET_PRIVILEGE_PROPERTY:
                    compLoader.loadObjPrivExtendedProperty(dataLine, repoName);
                    break;
                case _REGISTER_ROLE:
                    compLoader.loadRole(dataLine);
                    break;
                case _SET_SERVER_PROPERTY:
                    compLoader.loadDataServerProperty(dataLine);
                    break;
                default:
                    //do nothing - invalid type passed
            }
        } catch (Throwable e) {
            handleExceptions(e);
        }
    }
    
    /**
     * This method creates a new application called repositoryName.applicationName if one does not exist.  This method can return a
     * VSORBException if errors occur, and returns a ServerSecurityException if the current session does not have
     * PRIVILEGE_SYSADMIN.
     *
     * @param appName the name of the new application
     * @param repositoryName the repository for the new application
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see DataConst
     */
    public void registerApplication(String appName, String repositoryName) throws VSORBException, ServerSecurityException {
        
        havePermission("registerApplication", false);
        
        DataLine datLine = new DataLine();
        datLine.setName(appName);
        datLine.setObjType(DataLine.APPLICATION_OBJECT_ROW);
        
        load(_REGISTER_OBJECT, datLine, repositoryName, false);
    }
    
    /**
     * This method registers a new method for the business object called repositoryName.businessObjectName, if one does not exist.
     * This method can return a VSORBException if errors occur, and returns a ServerSecurityException if the current session does
     * not have PRIVILEGE_SYSADMIN.
     *
     * @param methodName the name of the new method
     * @param businessObjectName the business object which will get a new method
     * @param repositoryName the repository for the business object
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#registerMethod(String, String, String)
     */
    public void registerMethod(String methodName, String businessObjectName, String repositoryName) throws VSORBException,
    ServerSecurityException {
        registerObjWithParent(DataLine.METHOD_OBJECT_ROW, methodName, businessObjectName, repositoryName, "registerMethod");
    }
    
    /**
     * This method registers a new attribute for the business object called repositoryName.businessObjectName, if one does not
     * exist. This method can return a VSORBException if errors occur, and returns a ServerSecurityException if the current session
     * does not have PRIVILEGE_SYSADMIN.
     *
     * @param attributeName the name of the new attribute
     * @param businessObjectName the business object which will get a new attribute
     * @param repositoryName the repository for the business object
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#registerObjectAttribute(String, String, String)
     */
    public void registerObjectAttribute(String attributeName, String businessObjectName, String repositoryName)
    throws VSORBException, ServerSecurityException {
        registerObjWithParent(DataLine.ATTRIBUTE_OBJECT_ROW, attributeName, businessObjectName, repositoryName,
        "registerObjectAttribute");
    }
    
    /**
     * This method registers a new form for the java application called repositoryName.applicationName, if one does not exist.  This
     * method can return a VSORBException if errors occur, and returns a ServerSecurityException if the current session does not
     * have PRIVILEGE_SYSADMIN.
     *
     * @param formName the name of the new form
     * @param applicationName the application which will get a new form
     * @param repositoryName the repository for the application
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#registerAppForm(String, String, String)
     */
    public void registerAppForm(String formName, String applicationName, String repositoryName) throws VSORBException,
    ServerSecurityException {
        registerObjWithParent(DataLine.FORM_OBJECT_ROW, formName, applicationName, repositoryName, "registerAppForm");
    }
    
    /**
     * This method registers a new page for the HTML application called repositoryName.applicationName, if one does not exist.  This
     * method can return a VSORBException if errors occur, and returns a ServerSecurityException if the current session does not
     * have PRIVILEGE_SYSADMIN.
     *
     * @param pageName the name of the new page
     * @param applicationName the application which will get a new page
     * @param repositoryName the repository for the application
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#registerAppPage(String, String, String)
     */
    public void registerAppPage(String pageName, String applicationName, String repositoryName) throws VSORBException,
    ServerSecurityException {
        registerObjWithParent(DataLine.FORM_OBJECT_ROW, pageName, applicationName, repositoryName, "registerAppPage");
    }
    
    private void registerObjWithParent(String datalineType, String objectName, String businessObjectName, String repositoryName,
        String callerName) throws VSORBException, ServerSecurityException {
        
        havePermission(callerName, false);
        
        Properties props = new Properties();
        props.put("PARENTNAME", businessObjectName);
        
        DataLine datLine = new DataLine();
        datLine.setName(objectName);
        datLine.setObjType(datalineType);
        datLine.setProperties(props);
        
        load(_REGISTER_OBJECT, datLine, repositoryName, false);
    }
    
    /**
     * This method sets the PRIVILEGE_EXECUTE for an application named repositoryName.applicationName and the role specified.  The
     * execute parameter controls whether to set the PRIVILEGE_EXECUTE value to true or false.  This method can return a
     * VSORBException if errors occur, including if the application or the role does not exist.  It can return a
     * ServerSecurityException if the current session does not have PRIVILEGE_SYSADMIN.
     *
     * @param appName the name of the application
     * @param repositoryName the repository for the application
     * @param roleName the name of the role getting the privilege
     * @param execute a boolean representing how the execute privilege should be set
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see DataConst
     */
    public void setApplicationPrivilege(String appName, String repositoryName, String roleName, boolean execute)
    throws VSORBException, ServerSecurityException {
        
        havePermission("setApplicationPrivilege", false);
        
        Properties props = new Properties();
        props.put("ROLE", roleName);
        props.put("EXECUTE", Boolean.toString(execute));
        
        DataLine datLine = new DataLine();
        datLine.setName(appName);
        datLine.setObjType(DataLine.APPLICATION_OBJECT_ROW);
        datLine.setProperties(props);
        
        load(_SET_PRIVILEGE, datLine, repositoryName);
    }
    
    /**
     * This method sets the PRIVILEGE_EXECUTE for the specified method of a business object named repositoryName.businessObjectName
     * and the role specified.  The execute parameter controls whether to set the PRIVILEGE_EXECUTE value to true or false.  This
     * method can return a VSORBException if errors occur, including if the method or the role does not exist.  It can return a
     * ServerSecurityException if the current session does not have PRIVILEGE_SYSADMIN.
     *
     * @param methodName the name of the method getting a privilege change
     * @param businessObjectName the business object which the method is associated with
     * @param repositoryName the repository for the business object
     * @param roleName the name of the role getting the privilege
     * @param execute a boolean representing how the execute privilege should be set
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see DataConst
     */
    public void setMethodPrivilege(String methodName, String businessObjectName, String repositoryName, String roleName,
        boolean execute) throws VSORBException, ServerSecurityException {
        setObjWithParentPrivilege(DataLine.METHOD_OBJECT_ROW, methodName, businessObjectName, repositoryName, roleName,
            DataLine.EXECUTE_PRIVILEGE_TYPE, execute, "setMethodPrivilege");
    }
    
    /**
     * This method sets the PRIVILEGE_EXECUTE for the specified form of a java application named repositoryName.applicationName and
     * the role specified. The execute parameter controls whether to set the PRIVILEGE_EXECUTE value to true or false.  This method
     * can return a VSORBException if errors occur, including if the form or the role does not exist.  It can return a
     * ServerSecurityException if the current session does not have PRIVILEGE_SYSADMIN.
     *
     * @param appFormName the name of the form getting a privilege change
     * @param applicationName the business object which the form is associated with
     * @param repositoryName the repository for the business object
     * @param roleName the name of the role getting the privilege
     * @param execute a boolean representing how the execute privilege should be set
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see DataConst
     */
    public void setAppFormPrivilege(String appFormName, String applicationName, String repositoryName, String roleName,
        boolean execute) throws VSORBException, ServerSecurityException {
        setObjWithParentPrivilege(DataLine.FORM_OBJECT_ROW, appFormName, applicationName, repositoryName, roleName,
            DataLine.EXECUTE_PRIVILEGE_TYPE, execute, "setAppFormPrivilege");
    }
    
    /**
     * This method sets the PRIVILEGE_EXECUTE for the specified page of an HTML application named repositoryName.applicationName and
     * the role specified. The execute parameter controls whether to set the PRIVILEGE_EXECUTE value to true or false.  This method
     * can return a VSORBException if errors occur, including if the page or the role does not exist.  It can return a
     * ServerSecurityException if the current session does not have PRIVILEGE_SYSADMIN.
     *
     * @param appPageName the name of the page getting a privilege change
     * @param applicationName the business object which the page is associated with
     * @param repositoryName the repository for the business object
     * @param roleName the name of the role getting the privilege
     * @param execute a boolean representing how the execute privilege should be set
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see DataConst
     */
    public void setAppPagePrivilege(String appPageName, String applicationName, String repositoryName, String roleName,
        boolean execute) throws VSORBException, ServerSecurityException {
        setObjWithParentPrivilege(DataLine.FORM_OBJECT_ROW, appPageName, applicationName, repositoryName, roleName,
            DataLine.EXECUTE_PRIVILEGE_TYPE, execute, "setAppPagePrivilege");
    }
    
    private void setObjWithParentPrivilege(String datalineType, String objectName, String businessObjectName,
        String repositoryName, String roleName, String privilegeType, boolean privilegeValue, String callerName)
    throws VSORBException, ServerSecurityException {
        
        havePermission(callerName, false);
        
        Properties props = new Properties();
        props.put("PARENTNAME", businessObjectName);
        props.put("ROLE", roleName);
        props.put(privilegeType, Boolean.toString(privilegeValue));
        
        DataLine datLine = new DataLine();
        datLine.setName(objectName);
        datLine.setObjType(datalineType);
        datLine.setProperties(props);
        
        load(_SET_PRIVILEGE, datLine, repositoryName);
    }
    
    /**
     * This method sets the PRIVILEGE_VIEW and PRIVILEGE_EDIT for the specified attribute of a business object named
     * repositoryName.businessObjectName and the role specified.  The view and edit parameters controls whether to set the
     * privileges to true or false.  This method can return a VSORBException if errors occur, including if the method or the role
     * does not exist. It can return a ServerSecurityException if the current session does not have PRIVILEGE_SYSADMIN.
     *
     * @param attributeName the name of the attribute getting a privilege change
     * @param businessObjectName the business object which the method is associated with
     * @param repositoryName the repository for the business object
     * @param roleName the name of the role getting the privilege
     * @param edit a boolean representing how the edit privilege should be set
     * @param view a boolean representing how the view privilege should be set
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see DataConst
     */
    public void setObjectAttributePrivilege(String attributeName, String businessObjectName, String repositoryName,
        String roleName, boolean edit, boolean view) throws VSORBException, ServerSecurityException {
        havePermission("setObjectAttributePrivilege", false);
        
        Properties props = new Properties();
        props.put("PARENTNAME", businessObjectName);
        props.put("ROLE", roleName);
        props.put(DataLine.VIEW_PRIVILEGE_TYPE, Boolean.toString(view));
        props.put(DataLine.EDIT_PRIVILEGE_TYPE, Boolean.toString(edit));
        
        DataLine datLine = new DataLine();
        datLine.setName(attributeName);
        datLine.setObjType(DataLine.ATTRIBUTE_OBJECT_ROW);
        datLine.setProperties(props);
        
        load(_SET_PRIVILEGE, datLine, repositoryName);
    }
    
    /**
     * This method sets all privileges for the business object named repositoryName.businessObjectName and the role specified.  The
     * four boolean parameter control whether to set the PRIVILEGE_READ, PRIVILEGE_CREATE, PRIVILEGE_UPDATE, PRIVILEGE_DELETE values
     * to true or false.  This method can return a VSORBException if errors occur, including if the business object or the role does
     * not exist.  It can return a ServerSecurityException if the current session does not have PRIVILEGE_SYSADMIN.
     *
     * @param businessObjectName the business object which is having privileges set
     * @param repositoryName the repository for the business object
     * @param roleName the name of the role getting the privileges
     * @param read a boolean representing how the read privilege should be set
     * @param create a boolean representing how the create privilege should be set
     * @param update a boolean representing how the update privilege should be set
     * @param delete a boolean representing how the delete privilege should be set
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see com.versata.tl.common.util.DataConst
     */
    public void setBusinessObjectPrivileges(String businessObjectName, String repositoryName, String roleName, boolean read,
        boolean create, boolean update, boolean delete) throws VSORBException, ServerSecurityException {
        
        havePermission("setBusinessObjectPrivileges", false);
        
        Properties props = new Properties();
        props.put("ROLE", roleName);
        props.put(DataLine.READ_PRIVILEGE_TYPE, Boolean.toString(read));
        props.put(DataLine.CREATE_PRIVILEGE_TYPE, Boolean.toString(create));
        props.put(DataLine.UPDATE_PRIVILEGE_TYPE, Boolean.toString(update));
        props.put(DataLine.DELETE_PRIVILEGE_TYPE, Boolean.toString(delete));
        
        DataLine datLine = new DataLine();
        datLine.setName(businessObjectName);
        datLine.setObjType(DataLine.BUSINESS_OBJECT_ROW);
        datLine.setProperties(props);
        
        load(_SET_PRIVILEGE, datLine, repositoryName);
    }
    
    /**
     * This method sets the assignment and granting privilege for the specified user and the role specified.  The two boolean
     * parameter control whether to set the assignment flag and granting flag values to true or false, respectively.  This method
     * can return a VSORBException if errors occur, including if the user or the role does not exist.  It can return a
     * ServerSecurityException if the current session does not have PRIVILEGE_SYSADMIN or PRIVILEGE_MANAGE_USERS with granting
     * rights to the role being modified.
     *
     * @param appServerlogin the name of the user getting an assignment
     * @param roleName the name of the role getting assigned to user
     * @param assigned a boolean representing how the assigned privilege should be set
     * @param granting a boolean representing how the granting privilege should be set
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see DataConst
     */
    public void setUserAssignment(String appServerlogin, String roleName, boolean assigned, boolean granting)
    throws VSORBException, ServerSecurityException {
        
        havePermission("setUserAssignment", true);
        
        Properties props = new Properties();
        props.put("USERID", appServerlogin);
        props.put("ROLE", roleName);
        props.put("RIGHT", Boolean.toString(assigned));
        props.put("GRANTING", Boolean.toString(granting));
        
        DataLine datLine = new DataLine();
        datLine.setProperties(props);
        
        load(_SET_USER_ASSIGNMENT, datLine);
    }
    
    /**
     * This method set up a login override for the specified user against the specified data server. The override is assigned a
     * login and password using the dataServerLogin and dataServerPassword parameters, respectively.  Once this is committed, the
     * specified user will log into the data server using the override login and password, instead of the default login and password
     * for the data server.  This method can return a VSORBException if errors occur, including if the user or the data server does
     * not exist.  It can return a ServerSecurityException if the current session does not have PRIVILEGE_SYSADMIN.
     *
     * @param appServerlogin the name of the user having an override added for data server connection
     * @param dataServer the name of the data server whose default login/password will be overridden
     * @param dataServerLogin the login ID to be used for this user when connecting to data server
     * @param dataServerPassword the password to be used for this user when connecting to data server
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see DataConst
     */
    public void setUserDataServerLogin(String appServerlogin, String dataServer, String dataServerLogin, String dataServerPassword)
    throws VSORBException, ServerSecurityException {
        
        havePermission("setUserDataServerLogin", false);
        
        DataLine datLine = new DataLine();
        datLine.setLogin(dataServerLogin);
        datLine.setPassword(dataServerPassword);
        datLine.setDSName(dataServer);
        
        Properties props = new Properties();
        props.put("USERID", appServerlogin);
        datLine.setProperties(props);
        
        load(_SET_USER_DATA_SERVER_LOGIN, datLine);
    }
    
    /**
     * This method allows the value to be changed for a property (also known as attribute) of a data server.  Data servers have
     * various properties, which are defined by the data server's type. Any property may be modified except the default login and
     * default password of the data server, which must be set through the Console.  This method can return a VSORBException if
     * errors occur, including if the property or the data server does not exist.  It can return a ServerSecurityException if the
     * current session does not have PRIVILEGE_SYSADMIN.
     *
     * @param dataServer the name of the data server whose property(attribute) will be modified
     * @param property the name of the property(attribute) which will be modified
     * @param value the value that will be assigned to the property(attribute)
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see DataConst
     */
    public void setDataServerProperty(String dataServer, String property, String value) throws VSORBException,
    ServerSecurityException {
        
        havePermission("setDataServerProperty", false);
        
        DataLine datLine = new DataLine();
        datLine.setDSName(dataServer);
        
        Properties props = new Properties();
        props.put(property, value);
        datLine.setProperties(props);
        
        load(_SET_SERVER_PROPERTY, datLine);
    }
    
    /**
     * This method allows to read a dataserver property
     *
     * @param objectName the name of the object whose property(attribute) will be returned
     * @param property the name of the property(attribute) which will be returned
     * @return value    the value of this property
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getDataServerProperty(String, String)
     */
    public String getDataServerProperty(String objectName, String property) throws ServerSecurityException {
        String repositoryName = getRepositoryName();
        if(repositoryName.equals("VLSWebConsole")){
        	try{
        		return ServerEnvironment_Base.getAdminDBProperties().getProperty(property);
        	}catch(Exception e){
        		throw new ServerSecurityException(AdminMsgCode.PROPERTY_NOT_DEFINED, e);
        	}
        }
        if (!preAuthenticated()) {
            return userComponent.getUserDataServiceLoginForObject(repositoryName, objectName).getProperty(property);
        } else {
            AppDataSourceLocationImpl dataServer = null;
            AppObjectImpl appObject = AppObjectImpl.getBusinessObject(repositoryName, objectName, theAppServer
                .getInternalSession());
            
            if (appObject != null) {
                dataServer = appObject.getDataServer();
            }
            
            if (appObject == null || dataServer == null) {
                throw new ServerSecurityException(AdminMsgCode.SYSADMIN_ONLY_1, objectName);
            }
            
            return dataServer.getAnonymousConProperties().getProperty(property);
        }
    }
    
    // This is added to support QueryDef Test/Validate functionality in
    // in Versata System 5.0,
    // Attention EJB Developer: Make sure it works with EJB
    // Eric
    
    /**
     * Method getDataServerProperties.
     *
     * @param dataServer String
     * @return Property[]
     * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#getDataServerProperties(String)
     */
    public Property[] getDataServerProperties(String dataServer) {
        
        Property[] props = null;
        Properties properties = getMyDataServiceLogin(dataServer);
        
        if (properties != null && properties.size() != 0) {
            synchronized (properties) {
                props = new Property[properties.size()];
                int i = 0;
                for (Enumeration e = properties.propertyNames(); e.hasMoreElements(); i++) {
                    String name = (String)e.nextElement();
                    String value = properties.getProperty(name);
                    if (value == null) {
                        value = "";
                    }
                    props[i] = new Property(name, value);
                }
            }
        }
        return props == null ? new Property[0] : props;
    }
    
    /**
     * This method sets the value of a user property.  It looks up the user using the appLoginID parameter, finds the property using
     * the property parameter, and sets the value of the property using the value parameter, overlaying an existing property value
     * if one exists.  This method can return a VSORBException if errors occur, including if the user or the property does not
     * exist.  It can return a ServerSecurityException if the current session does not have PRIVILEGE_SYSADMIN or
     * PRIVILEGE_MANAGE_USERS with granting rights to all roles for the user being modified.
     *
     * @param appLoginID the ID of the user whose property will be modified
     * @param property the name of the property which will be modified
     * @param value the value that will be assigned to the property
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see DataConst
     */
    public void setUserProperty(String appLoginID, String property, String value) throws VSORBException, ServerSecurityException {
        
        havePermission("setUserProperty", true);
        
        Properties props = new Properties();
        props.put("USERID", appLoginID);
        props.put(property, value);
        
        DataLine datLine = new DataLine();
        datLine.setProperties(props);
        load(_SET_USER_PROPERTY, datLine);
    }
    
    /**
     * This method sets the value of a userRole property.  It looks up the user using the appLoginID parameter and the roles using
     * the roleName parameter. Then it finds the property using the property parameter, and sets the value of the property using the
     * value parameter, overlaying an existing property value if one exists.  This method can return a VSORBException if errors
     * occur, including if the user, role or property does not exist.  It can return a ServerSecurityException if the current
     * session does not have PRIVILEGE_SYSADMIN or PRIVILEGE_MANAGE_USERS with granting rights to the specified role.
     *
     * @param appLoginID the ID of the user whose assignment property will be modified
     * @param roleName the name of the role whose assignment property will be modified
     * @param property the name of the property which will be modified
     * @param value the value that will be assigned to the property
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see DataConst
     */
    public void setUserAssignmentProperty(String appLoginID, String roleName, String property, String value) throws VSORBException,
    ServerSecurityException {
        
        havePermission("setUserAssignmentProperty", true);
        
        Properties props = new Properties();
        props.put("USERID", appLoginID);
        props.put("ROLE", roleName);
        props.put(property, value);
        
        DataLine datLine = new DataLine();
        datLine.setProperties(props);
        load(_SET_USER_ASSIGNMENT_PROPERTY, datLine);
    }
    
    /**
     * This method sets the value of a role property.  It looks up the role using the roleName parameter, finds the property using
     * the property parameter, and sets the value of the property using the value parameter, overlaying an existing property value
     * if one exists.  This method can return a VSORBException if errors occur, including if the role or the property does not
     * exist.  It can return a ServerSecurityException if the role does not have PRIVILEGE_SYSADMIN.
     *
     * @param roleName the name of the role whose property will be modified
     * @param property the name of the property which will be modified
     * @param value the value that will be assigned to the property
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see DataConst
     */
    public void setRoleProperty(String roleName, String property, String value) throws VSORBException, ServerSecurityException {
        
        havePermission("setRoleProperty", false);
        
        DataLine datLine = new DataLine();
        datLine.setName(roleName);
        
        Properties props = new Properties();
        props.put(property, value);
        datLine.setProperties(props);
        
        load(_SET_ROLE_PROPERTY, datLine);
    }
    
    /**
     * This method sets the value of an ObjectPrivilege property for an application (Application Privilege Property).  It looks up
     * the object using repositoryName.applicationName parameters and the roles using the roleName parameter.  Then it finds the
     * property using the property parameter, and sets the value of the property using the value parameter, overlaying an existing
     * property value if one exists.  This method can return a VSORBException if errors occur, including if the application, role or
     * property does not exist.  It can return a ServerSecurityException if the current session does not have PRIVILEGE_SYSADMIN.
     *
     * @param applicationName the name of the application whose privilege property will be modified
     * @param repositoryName the repository for the application
     * @param roleName the name of the role whose privilege property will be modified
     * @param property the name of the property which will be modified
     * @param value the value that will be assigned to the property
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see DataConst
     */
    public void setApplicationPrivilegeProperty(String applicationName, String repositoryName, String roleName, String property,
        String value) throws VSORBException, ServerSecurityException {
        
        setPriviledgeProperty(applicationName, repositoryName, roleName, property, value, _APPLICATION_OBJECT);
    }
    
    /**
     * This method sets the value of an ObjectPrivilege property for a businessObject (Business Object Privilege Property).  It
     * looks up the object using repositoryName.businessObjectName parameters and the roles using the roleName parameter.  Then it
     * finds the property using the property parameter, and sets the value of the property using the value parameter, overlaying an
     * existing property value if one exists.  This method can return a VSORBException if errors occur, including if the
     * application, role or property does not exist.  It can return a ServerSecurityException if the current session does not have
     * PRIVILEGE_SYSADMIN.
     *
     * @param businessObjectName the business object whose privilege property will be modified
     * @param repositoryName the repository for the business object
     * @param roleName the name of the role whose privilege property will be modified
     * @param property the name of the property which will be modified
     * @param value the value that will be assigned to the property
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see DataConst
     */
    public void setBusinessObjectPrivilegeProperty(String businessObjectName, String repositoryName, String roleName,
        String property, String value) throws VSORBException, ServerSecurityException {
        
        setPriviledgeProperty(businessObjectName, repositoryName, roleName, property, value, _BUSINESS_OBJECT);
    }
    
    private void setPriviledgeProperty(String name, String repositoryName, String roleName, String property, String value, int type)
    throws ServerSecurityException {
        
        DataLine datLine = new DataLine();
        datLine.setName(name);
        
        switch (type) {
            case _BUSINESS_OBJECT:
                havePermission("setBusinessObjectPrivilegeProperty", false);
                datLine.setObjType(DataLine.BUSINESS_OBJECT_ROW);
                break;
            case _APPLICATION_OBJECT:
                havePermission("setApplicationPrivilegeProperty", false);
                datLine.setObjType(DataLine.APPLICATION_OBJECT_ROW);
                break;
            default:
                break;
        }
        
        Properties props = new Properties();
        props.put("ROLE", roleName);
        props.put(property, value);
        datLine.setProperties(props);
        
        load(_SET_PRIVILEGE_PROPERTY, datLine, repositoryName);
    }
    
    /**
     * This method sets the value of a businessObject property.  It looks up the object using repositoryName.businessObjectName
     * parameters, finds the property using the property parameter, and sets the value of the property using the value parameter,
     * overlaying an existing property value if one exists.  This method can return a VSORBException if errors occur, including if
     * the business object or the property does not exist.  It can return a ServerSecurityException if the role does not have
     * PRIVILEGE_SYSADMIN.
     *
     * @param businessObjectName the business object whose property will be modified
     * @param repositoryName the repository for the business object
     * @param property the name of the property which will be modified
     * @param value the value that will be assigned to the property
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see DataConst
     */
    public void setBusinessObjectProperty(String businessObjectName, String repositoryName, String property, String value)
    throws VSORBException, ServerSecurityException {
        
        setProperty(businessObjectName, repositoryName, property, value, _BUSINESS_OBJECT);
    }
    
    /**
     * This method sets the value of a appllication property.  It looks up the object using repositoryName.applicationName
     * parameters, finds the property using the property parameter, and sets the value of the property using the value parameter,
     * overlaying an existing property value if one exists.  This method can return a VSORBException if errors occur, including if
     * the business object or the property does not exist.  It can return a ServerSecurityException if the role does not have
     * PRIVILEGE_SYSADMIN.
     *
     * @param applicationName the name of the application whose property will be modified
     * @param repositoryName the repository for the application
     * @param property the name of the property which will be modified
     * @param value the value that will be assigned to the property
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see DataConst
     */
    public void setApplicationProperty(String applicationName, String repositoryName, String property, String value)
    throws VSORBException, ServerSecurityException {
        
        setProperty(applicationName, repositoryName, property, value, _APPLICATION_OBJECT);
    }
    
    private void setProperty(String name, String repositoryName, String property, String value, int type)
    throws ServerSecurityException {
        
        DataLine datLine = new DataLine();
        datLine.setName(name);
        
        switch (type) {
            case _BUSINESS_OBJECT:
                havePermission("setBusinessObjectPrivilegeProperty", false);
                datLine.setObjType(DataLine.BUSINESS_OBJECT_ROW);
                break;
            case _APPLICATION_OBJECT:
                havePermission("setApplicationPrivilegeProperty", false);
                datLine.setObjType(DataLine.APPLICATION_OBJECT_ROW);
                break;
            default:
                break;
        }
        
        Properties props = new Properties();
        props.put(property, value);
        datLine.setProperties(props);
        load(_SET_PROPERTY, datLine, repositoryName);
    }
    
    /**
     * This method deletes a user from the security data.  It looks up the user using the appServerLogin parameter.  This method can
     * return a VSORBException if errors occur, including if the user does not exist.  It can return a ServerSecurityException if
     * the current session does not have PRIVILEGE_SYSADMIN or PRIVILEGE_MANAGE_USERS with granting rights to all roles for the user
     * being modified.
     *
     * @param appServerlogin the ID of the user to be deleted
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see DataConst
     */
    public void deleteUser(String appServerlogin) throws VSORBException, ServerSecurityException {
        
        havePermission("deleteUser", true);
        try {
            if (appServerlogin == null) {
                throw new ServerException(AdminMsgCode.SYSTEM_ERROR, MessageLocalizer
                    .getLocalizedMessage(RuntimeMsgCode.VSORBSESSIONIMPL735));
            }
            
            Parameter[] filter = new Parameter[1];
            filter[0] = new Parameter("AppUser", "AppSvrLoginID", appServerlogin);
            AppUserImpl userLoc = (AppUserImpl)AppUserImpl.getObjectByKey(new SearchRequest(filter), this);
            
            if (userLoc == null) {
                throw new ServerException(AdminMsgCode.SYSTEM_ERROR, MessageLocalizer
                    .getLocalizedMessage(RuntimeMsgCode.VSORBSESSIONIMPL737));
            }
            
            userLoc.setDelete();
            userLoc.executeRules();
            
        } catch (Throwable e) {
            handleExceptions(e);
        }
    }
    
    /**
     * This method deletes a role from the security data.  It looks up the role using the roleName parameter.  This method can
     * return a VSORBException if errors occur, including if the role does not exist.  It can return a ServerSecurityException if
     * the current session does not have PRIVILEGE_SYSADMIN.
     *
     * @param roleName the name of the role to be deleted
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see DataConst
     */
    public void deleteRole(String roleName) throws VSORBException, ServerSecurityException {
        
        havePermission("deleteRole", false);
        
        try {
            if (roleName == null) {
                throw new ServerException(AdminMsgCode.SYSTEM_ERROR, MessageLocalizer
                    .getLocalizedMessage(RuntimeMsgCode.APPCOMPONENTLOADER650));
            }
            
            Parameter[] filter = new Parameter[1];
            filter[0] = new Parameter("AppRole", "RoleName", roleName);
            AppRoleImpl roleLoc = (AppRoleImpl)AppRoleImpl.getObjectByKey(new SearchRequest(filter), this);
            
            if (roleLoc == null) {
                throw new ServerException(AdminMsgCode.SYSTEM_ERROR, MessageLocalizer
                    .getLocalizedMessage(RuntimeMsgCode.VSORBSESSIONIMPL743));
            }
            
            roleLoc.setDelete();
            roleLoc.executeRules();
            
        } catch (Throwable e) {
            handleExceptions(e);
        }
    }
    
    /**
     * This method deletes an application from the security data.  It does not delete the actual application code stored on disk,
     * nor the entry in the repository.  It looks up the application using the repositoryName.applicationName parameters.  This
     * method can return a VSORBException if errors occur, including if the application does not exist.  It can return a
     * ServerSecurityException if the current session does not have PRIVILEGE_SYSADMIN.
     *
     * @param applicationName the name of the application to be deleted
     * @param repositoryName the repository for the application
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see DataConst
     */
    public void deleteApplication(String applicationName, String repositoryName) throws VSORBException, ServerSecurityException {
        
        havePermission("deleteApplication", false);
        
        try {
            if (applicationName == null || repositoryName == null) {
                throw new ServerException(AdminMsgCode.SYSTEM_ERROR, MessageLocalizer
                    .getLocalizedMessage(RuntimeMsgCode.VSORBSESSIONIMPL747));
            }
            
            Parameter[] filter = new Parameter[3];
            filter[0] = new Parameter("AppObject", "ObjectName", applicationName);
            filter[1] = new Parameter("AppObject", "ObjectType", DataConst.AppObjectTypeCodeImpl_APPLICATION_OBJECT);
            filter[2] = new Parameter("AppObject", "RepositoryName", repositoryName);
            AppObjectImpl objectLoc = (AppObjectImpl)AppObjectImpl.getObjectByKey(new SearchRequest(filter), this);
            
            if (objectLoc == null) {
                throw new ServerException(AdminMsgCode.SYSTEM_ERROR, MessageLocalizer
                    .getLocalizedMessage(RuntimeMsgCode.VSORBSESSIONIMPL749));
            }
            
            objectLoc.setDelete();
            objectLoc.executeRules();
            
        } catch (Throwable e) {
            handleExceptions(e);
        }
    }
    
    /**
     * This method deletes a business object from the security data.  It does not delete from the physical device where the data
     * object's data resides, nor the entry in the repository, nor the class which implements the business object.  It looks up the
     * object using the repositoryName.businessObjectName parameters.  This method can return a VSORBException if errors occur,
     * including if the business object does not exist.  It can return a ServerSecurityException if the current session does not
     * have PRIVILEGE_SYSADMIN.
     *
     * @param businessObjectName the name of the business object to be deleted
     * @param repositoryName the repository for the business object
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see DataConst
     */
    public void deleteBusinessObject(String businessObjectName, String repositoryName) throws VSORBException,
    ServerSecurityException {
        
        havePermission("deleteBusinessObject", false);
        
        try {
            if (businessObjectName == null || repositoryName == null) {
                throw new ServerException(AdminMsgCode.SYSTEM_ERROR, MessageLocalizer
                    .getLocalizedMessage(RuntimeMsgCode.VSORBSESSIONIMPL771));
            }
            
            Parameter[] filter = new Parameter[4];
            filter[0] = new Parameter("AppObject", "ObjectName", businessObjectName);
            filter[1] = new Parameter("AppObject", "ObjectType", DataConst.AppObjectTypeCodeImpl_DATA_OBJECT);
            filter[2] = new Parameter("AppObject", "ObjectType", DataConst.AppObjectTypeCodeImpl_QUERY_OBJECT);
            filter[3] = new Parameter("AppObject", "RepositoryName", repositoryName);
            AppObjectImpl objectLoc = (AppObjectImpl)AppObjectImpl.getObjectByKey(new SearchRequest(filter), this);
            
            if (objectLoc == null) {
                throw new ServerException(AdminMsgCode.SYSTEM_ERROR, MessageLocalizer
                    .getLocalizedMessage(RuntimeMsgCode.VSORBSESSIONIMPL774));
            }
            
            objectLoc.setDelete();
            objectLoc.executeRules();
            
        } catch (Throwable e) {
            handleExceptions(e);
        }
    }
    
    /**
     * This method deletes a method registered for a business object from the security data.  It does not delete the method itself,
     * this would have to be done by changing the code and re-deploying. It looks up the business object using the
     * repositoryName.businessObjectName parameters, and then finds the method for that business object.  This method can return a
     * VSORBException if errors occur, including if the business object or method does not exist.  It can return a
     * ServerSecurityException if the current session does not have PRIVILEGE_SYSADMIN.
     *
     * @param methodName the name of the method to be deleted
     * @param businessObjectName the name of the business object which contains the method
     * @param repositoryName the repository for the business object
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see DataConst
     */
    public void deleteMethod(String methodName, String businessObjectName, String repositoryName) throws VSORBException,
    ServerSecurityException {
        deleteObjWithParent(DataConst.METHOD_OBJECT, methodName, businessObjectName, repositoryName, DataConst.BUSINESS_OBJECT,
        "deleteMethod");
    }
    
    /**
     * This method deletes an attribute registered for a business object from the security data.  It does not delete the attribute
     * itself, this would have to be done by changing the table in the BRD and re-deploying.  It looks up the business object using
     * the repositoryName.businessObjectName parameters, and then finds the attribute for that business object.  This method can
     * return a VSORBException if errors occur, including if the business object or method does not exist.  It can return a
     * ServerSecurityException if the current session does not have PRIVILEGE_SYSADMIN.
     *
     * @param attributeName the name of the attribute to be deleted
     * @param businessObjectName the name of the business object which contains the attribute
     * @param repositoryName the repository for the business object
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see DataConst
     */
    public void deleteObjectAttribute(String attributeName, String businessObjectName, String repositoryName)
    throws VSORBException, ServerSecurityException {
        deleteObjWithParent(DataConst.ATTRIBUTE_OBJECT, attributeName, businessObjectName, repositoryName,
            DataConst.BUSINESS_OBJECT, "deleteObjectAttribute");
    }
    
    /**
     * This method deletes a form registered for an application from the security data.  It does not delete the form itself, this
     * would have to be done by changing the application design and re-deploying.  It looks up the application using the
     * repositoryName.applicationName parameters, and then finds the form for that application.  This method can return a
     * VSORBException if errors occur, including if the business object or method does not exist.  It can return a
     * ServerSecurityException if the current session does not have PRIVILEGE_SYSADMIN.
     *
     * @param formName the name of the form to be deleted
     * @param applicationName the name of the application which contains the form
     * @param repositoryName the repository for the business object
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see DataConst
     */
    public void deleteAppForm(String formName, String applicationName, String repositoryName) throws VSORBException,
    ServerSecurityException {
        deleteObjWithParent(DataConst.FORM_OBJECT, formName, applicationName, repositoryName, DataConst.APPLICATION_OBJECT,
        "deleteAppForm");
    }
    
    /**
     * This method deletes a page registered for an application from the security data.  It does not delete the page itself, this
     * would have to be done by changing the application design and re-deploying.  It looks up the application using the
     * repositoryName.applicationName parameters, and then finds the form for that application.  This method can return a
     * VSORBException if errors occur, including if the business object or method does not exist.  It can return a
     * ServerSecurityException if the current session does not have PRIVILEGE_SYSADMIN.
     *
     * @param pageName the name of the page to be deleted
     * @param applicationName the name of the application which contains the page
     * @param repositoryName the repository for the business object
     * @throws VSORBException
     * @throws ServerSecurityException
     * @see DataConst
     */
    public void deleteAppPage(String pageName, String applicationName, String repositoryName) throws VSORBException,
    ServerSecurityException {
        deleteObjWithParent(DataConst.FORM_OBJECT, pageName, applicationName, repositoryName, DataConst.APPLICATION_OBJECT,
        "deleteAppForm");
    }
    
    private void deleteObjWithParent(String objectType, String objectName, String businessObjectName, String repositoryName,
        String parentObjectType, String callerName) throws VSORBException, ServerSecurityException {
        
        havePermission(callerName, false);
        
        try {
            if (objectName == null) {
                throw new ServerException(AdminMsgCode.SYSTEM_ERROR, MessageLocalizer
                    .getLocalizedMessage(RuntimeMsgCode.VSORBSESSIONIMPL759));
            }
            
            if (businessObjectName == null || repositoryName == null) {
                throw new ServerException(AdminMsgCode.SYSTEM_ERROR, MessageLocalizer
                    .getLocalizedMessage(RuntimeMsgCode.VSORBSESSIONIMPL771));
            }
            
            Parameter[] filter = setFilter(businessObjectName, repositoryName, parentObjectType);
            AppObjectImpl parentObjectLoc = (AppObjectImpl)AppObjectImpl.getObjectByKey(new SearchRequest(filter), this);
            
            if (parentObjectLoc == null) {
                throw new ServerException(AdminMsgCode.SYSTEM_ERROR, MessageLocalizer
                    .getLocalizedMessage(RuntimeMsgCode.VSORBSESSIONIMPL774));
            }
            
            filter = new Parameter[3];
            filter[0] = new Parameter("AppObject", "ObjectName", objectName);
            filter[1] = new Parameter("AppObject", "ObjectType", objectType);
            filter[2] = new Parameter("AppObject", "ParentObjectID", Long.toString(parentObjectLoc.getObjectID()));
            AppObjectImpl objectLoc = (AppObjectImpl)AppObjectImpl.getObjectByKey(new SearchRequest(filter), this);
            
            if (objectLoc == null) {
                throw new ServerException(AdminMsgCode.SYSTEM_ERROR, MessageLocalizer
                    .getLocalizedMessage(RuntimeMsgCode.VSORBSESSIONIMPL765));
            }
            
            objectLoc.setDelete();
            objectLoc.executeRules();
        } catch (Throwable e) {
            handleExceptions(e);
        }
    }
    
    /**
     * This method returns an array of registered users.  Each array element contains the login ID for a user.  This list can be
     * used for numerous purposes, including to drive a batch operation which updates all users, or simply to check to see that a
     * single loginID is already used.  At this time, there is no filtering or ordering, although that may be added in future
     * releases. This method can return a VSORBException if errors occur.
     *
     * @return NameList        An array of user login IDs
     * @throws VSORBException
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#getRegisteredUserList()
     */
    public String[] getRegisteredUserList() throws VSORBException {
        String[] userArray = null;
        try {
            Enumeration users = AppUserImpl.getObjects((SearchRequest)null, this);
            Vector userVector = new Vector();
            while (users.hasMoreElements()) {
                userVector.addElement(users.nextElement());
            }
            
            users = userVector.elements();
            userArray = new String[userVector.size()];
            int x = 0;
            while (users.hasMoreElements()) {
                userArray[x++] = ((AppUserImpl)users.nextElement()).getAppSvrLoginID();
            }
        } catch (Throwable e) {
            handleExceptions(e);
        }
        return userArray;
    }
    
    /**
     * This method returns an array of registered roles.  Each array element contains the role name of a role.  This list can be
     * used for various purposes, including to drive a batch operation which updates all role.  At this time, there is no filtering
     * or ordering, although that may be added in future releases.  This method can return a VSORBException if errors occur.
     *
     * @return NameList        An array of role names
     * @throws VSORBException
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#getRegisteredRoleList()
     */
    public String[] getRegisteredRoleList() throws VSORBException {
        String[] roleArray = null;
        try {
            Enumeration roles = AppRoleImpl.getObjects((SearchRequest)null, this);
            Vector roleVector = new Vector();
            while (roles.hasMoreElements()) {
                roleVector.addElement(roles.nextElement());
            }
            
            roles = roleVector.elements();
            roleArray = new String[roleVector.size()];
            int x = 0;
            while (roles.hasMoreElements()) {
                roleArray[x++] = ((AppRoleImpl)roles.nextElement()).getRoleName();
            }
        } catch (Throwable e) {
            handleExceptions(e);
        }
        return roleArray;
    }
    
    /**
     * This method returns an array of registered application.  Each array element contains the full application name, which means
     * it will read repositoryName.applicationName.  This list can be used for various programming purposes.  At this time, there is
     * no filtering or ordering, although that may be added in future releases.  This method can return a VSORBException if errors
     * occur.
     *
     * @return NameList        An array of application names
     * @throws VSORBException
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#getRegisteredApplicationList()
     */
    public String[] getRegisteredApplicationList() throws VSORBException {
        String[] objectArray = null;
        try {
            SearchRequest filter = new SearchRequest();
            filter.addParameter("AppObject", "ObjectType", DataConst.AppObjectTypeCodeImpl_APPLICATION_OBJECT);
            Enumeration objects = AppObjectImpl.getObjects(filter, this);
            Vector objectVector = new Vector();
            while (objects.hasMoreElements()) {
                objectVector.addElement(objects.nextElement());
            }
            
            objects = objectVector.elements();
            objectArray = new String[objectVector.size()];
            int x = 0;
            while (objects.hasMoreElements()) {
                AppObjectImpl obj1 = (AppObjectImpl)objects.nextElement();
                objectArray[x++] = obj1.getRepositoryName() + '.' + obj1.getObjectName();
            }
        } catch (Throwable e) {
            handleExceptions(e);
        }
        return objectArray;
    }
    
    /**
     * This method returns an array of registered methods for a business objects. Each array element contains the method name.  This
     * list can be used for various purposes, such as deleting obsolete methods.  At this time, there is no filtering or ordering,
     * although that may be added in future releases. This method can return a VSORBException if errors occur.
     *
     * @param businessObjectName the name of the business object which contains the methods
     * @param repositoryName the repository for the business object
     * @return NameList        An array of business object names
     * @throws VSORBException
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#getRegisteredMethodListForObject(String, String)
     */
    public String[] getRegisteredMethodListForObject(String businessObjectName, String repositoryName) throws VSORBException {
        return getRegisteredSubObjectListForObjWithParent(DataConst.METHOD_OBJECT, businessObjectName, repositoryName,
            DataConst.BUSINESS_OBJECT);
    }
    
    /**
     * This method returns an array of registered attributes for a business objects. Each array element contains the attribute name.
     * This list can be used for various purposes, such as deleting obsolete attributes.  At this time, there is no filtering or
     * ordering, although that may be added in future releases.  This method can return a VSORBException if errors occur.
     *
     * @param businessObjectName the name of the business object which contains the attributes
     * @param repositoryName the repository for the business object
     * @return NameList        An array of business object names
     * @throws VSORBException
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#getRegisteredAttributeListForObject(String, String)
     */
    public String[] getRegisteredAttributeListForObject(String businessObjectName, String repositoryName) throws VSORBException {
        return getRegisteredSubObjectListForObjWithParent(DataConst.ATTRIBUTE_OBJECT, businessObjectName, repositoryName,
            DataConst.BUSINESS_OBJECT);
    }
    
    /**
     * This method returns an array of registered forms for a Java application. Each array element contains a form name.  Note that
     * this list does not contain the first form displayed. This list can be used for various purposes, such as deleting obsolete
     * forms.  At this time, there is no filtering or ordering, although that may be added in future releases.  This method can
     * return a VSORBException if errors occur.
     *
     * @param applicationName the name of the business object which contains the attributes
     * @param repositoryName the repository for the business object
     * @return NameList        An array of business object names
     * @throws VSORBException
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#getRegisteredFormListForApplication(String, String)
     */
    public String[] getRegisteredFormListForApplication(String applicationName, String repositoryName) throws VSORBException {
        return getRegisteredSubObjectListForObjWithParent(DataConst.FORM_OBJECT, applicationName, repositoryName,
            DataConst.APPLICATION_OBJECT);
    }
    
    /**
     * This method returns an array of registered pages for an HTML application. Each array element contains a page name.  Note that
     * this list does not contain the first page displayed. This list can be used for various purposes, such as deleting obsolete
     * pages.  At this time, there is no filtering or ordering, although that may be added in future releases.  This method can
     * return a VSORBException if errors occur.
     *
     * @param applicationName the name of the business object which contains the attributes
     * @param repositoryName the repository for the business object
     * @return NameList        An array of business object names
     * @throws VSORBException
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#getRegisteredPageListForApplication(String, String)
     */
    public String[] getRegisteredPageListForApplication(String applicationName, String repositoryName) throws VSORBException {
        return getRegisteredSubObjectListForObjWithParent(DataConst.FORM_OBJECT, applicationName, repositoryName,
            DataConst.APPLICATION_OBJECT);
    }
    
    private String[] getRegisteredSubObjectListForObjWithParent(String objectType, String businessObjectName,
        String repositoryName, String parentObjectType) throws VSORBException {
        String[] nameArray = null;
        try {
            if (businessObjectName == null || repositoryName == null) {
                throw new VSORBException(RuntimeMsgCode.VSORBSESSIONIMPL778);
            }
            
            Parameter[] filter = setFilter(businessObjectName, repositoryName, parentObjectType);
            AppObjectImpl parentObjectLoc = (AppObjectImpl)AppObjectImpl.getObjectByKey(new SearchRequest(filter), this);
            
            if (parentObjectLoc == null) {
                throw new VSORBException(RuntimeMsgCode.VSORBSESSIONIMPL774);
            }
            
            filter = new Parameter[2];
            filter[0] = new Parameter("AppObject", "ObjectType", objectType);
            filter[1] = new Parameter("AppObject", "ParentObjectID", Long.toString(parentObjectLoc.getObjectID()));
            Enumeration objects = AppObjectImpl.getObjects(new SearchRequest(filter), this);
            Vector nameVector = new Vector();
            while (objects.hasMoreElements()) {
                AppObjectImpl obj = (AppObjectImpl)objects.nextElement();
                nameVector.addElement(obj.getObjectName());
            }
            
            nameArray = new String[nameVector.size()];
            nameVector.copyInto(nameArray);
        } catch (Throwable e) {
            handleExceptions(e);
        }
        return nameArray;
    }
    
    private Parameter[] setFilter(String businessObjectName, String repositoryName, String parentObjectType) {
        
        Parameter[] filter;
        if (parentObjectType.equals(DataConst.BUSINESS_OBJECT)) {
            filter = new Parameter[4];
            filter[0] = new Parameter("AppObject", "ObjectName", businessObjectName);
            filter[1] = new Parameter("AppObject", "ObjectType", DataConst.AppObjectTypeCodeImpl_DATA_OBJECT);
            filter[2] = new Parameter("AppObject", "ObjectType", DataConst.AppObjectTypeCodeImpl_QUERY_OBJECT);
            filter[3] = new Parameter("AppObject", "RepositoryName", repositoryName);
        } else {
            filter = new Parameter[3];
            filter[0] = new Parameter("AppObject", "ObjectName", businessObjectName);
            filter[1] = new Parameter("AppObject", "ObjectType", parentObjectType);
            filter[2] = new Parameter("AppObject", "RepositoryName", repositoryName);
        }
        return filter;
    }
    
    /**
     * This method returns an array of registered methods against a single business object.  The repositoryName and
     * businessObjectName are concatenated together in the search for the business object to use.  Each array element contains a
     * method name.  This list can be used for various purposes, such as adding execute privileges to all methods for new users.  At
     * this time, there is no filtering or ordering, although that may be added in future releases.  This method can return a
     * VSORBException if errors occur.<br>
     *
     * @return NameList        An array of method names
     * @throws VSORBException
     * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#getRegisteredBusinessObjectList()
     */
    public String[] getRegisteredBusinessObjectList() throws VSORBException {
        String[] objectArray = null;
        try {
            SearchRequest filter = new SearchRequest();
            filter.addParameter("AppObject", "ObjectType", DataConst.AppObjectTypeCodeImpl_QUERY_OBJECT);
            filter.addParameter("AppObject", "ObjectType", DataConst.AppObjectTypeCodeImpl_DATA_OBJECT);
            Enumeration objects = AppObjectImpl.getObjects(filter, this);
            Vector objectVector = new Vector();
            while (objects.hasMoreElements()) {
                objectVector.addElement(objects.nextElement());
            }
            
            objects = objectVector.elements();
            objectArray = new String[objectVector.size()];
            int x = 0;
            while (objects.hasMoreElements()) {
                AppObjectImpl obj1 = (AppObjectImpl)objects.nextElement();
                objectArray[x++] = obj1.getRepositoryName() + '.' + obj1.getObjectName();
            }
        } catch (Throwable e) {
            handleExceptions(e);
        }
        return objectArray;
    }
    
    private void handleExceptions(Throwable e) {
        addServerEvent(MessageLocalizer.getLocalizedMessage(RuntimeMsgCode.VSORBSESSIONIMPL778, e.toString()), e.toString(), 1);
        if (e instanceof ServerException) {
            throw new VSORBException((ServerException)e);
        } else {
            if (e instanceof VSORBException) {
                throw (VSORBException)e;
            } else {
                throw new VSORBException(ErrorMsgCode.VSMSG_UnCheckedException, e);
            }
        }
    }
    
    /**
     * @param name String
     * @return AppRoleImpl
     * @internal.tle
     */
    public AppRoleImpl getRoleForRoleName(String name) {
        AppRoleImpl role = null;
        try {
            SearchRequest filter = new SearchRequest();
            filter.add(new Parameter("AppRole", "RoleName", name));
            role = (AppRoleImpl)AppRoleImpl.getObjectByKey(filter, getServer().getInternalSession());
        } catch (Exception ex) {
            _LOGGER.warn(ex);
        }
        return role != null ? role : null;
    }
    
    private Properties checkSecurityTables(String objectName, String objectType, Properties systemPrivs, String repositoryName) {
        if (DataConst.isValidObjectType(objectType)) {
            String packageName = VSRepositoryMetaCache.get(repositoryName).getPackageName(objectName);
            
            BusinessObjectImpl bo = GenericComponentFactory.getBusinessObject(packageName, objectName);
            if (bo.isSecurityObject()) {
                boolean sysAdmin = ((Boolean)systemPrivs.get(DataConst.AppRoleImpl_SYSADMIN)).booleanValue();
                boolean secAdmin = ((Boolean)systemPrivs.get(DataConst.AppRoleImpl_SECADMIN)).booleanValue();
                Properties retProps = new Properties();
                setProps(retProps, false);
                
                if (objectName.indexOf("AppUser") >= 0 || objectName.indexOf("AppExtendedPropValue") >= 0
                                || objectName.indexOf("AppUserRole") >= 0 || objectName.indexOf("AppUserDataSourceLogin") >= 0) {
                    if (sysAdmin || secAdmin) {
                        setProps(retProps, true);
                    }
                    return retProps;
                }
                
                if (objectName.indexOf("AppDataSourceLocation") >= 0 || objectName.indexOf("AppExtendedPropDef") >= 0
                                || objectName.indexOf("AppObjectPrivilege") >= 0 || objectName.indexOf("AppRole") >= 0) {
                    if (sysAdmin) {
                        setProps(retProps, true);
                    } else if (secAdmin) {
                        retProps.put(DataConst.AppObjectPrivilegeImpl_READ, Boolean.valueOf(true));
                    }
                    return retProps;
                }
                
                if (objectName.indexOf("AppDataSourceLocationAttribute") >= 0
                                || objectName.indexOf("AppDataSourceTypeAttribute") >= 0 || objectName.indexOf("AppDataSourceType") >= 0
                                || objectName.indexOf("AppObject") >= 0 || objectName.indexOf("AppObjectTypeCode") >= 0) {
                    if (sysAdmin) {
                        setProps(retProps, true);
                    }
                    return retProps;
                }
            }
        }
        return null;
    }
    
    private void setProps(Properties props, boolean value) {
        props.put(DataConst.AppObjectPrivilegeImpl_READ, Boolean.valueOf(value));
        props.put(DataConst.AppObjectPrivilegeImpl_CREATE, Boolean.valueOf(value));
        props.put(DataConst.AppObjectPrivilegeImpl_UPDATE, Boolean.valueOf(value));
        props.put(DataConst.AppObjectPrivilegeImpl_DELETE, Boolean.valueOf(value));
    }
    
    // SKL VIT53459 not needed, using global JVM wide cache
    // private Hashtable m_objectPrivilege = new Hashtable();
    
    private AppUserObjectPrivilege getObjPrivs(Integer objectID, boolean enforceColumnSecurity) throws ServerException {
        // ask the JVM-wide cache for privileges
        Cache global = GlobalCache.getSingleton().getCache(PRIVILEGES_CACHE, 500);
        String key = getRepositoryName() + '_' + getUserID();
        Cache m_objectPrivilege = global.getCache(key);
        
        AppUserObjectPrivilege objectPrivilege = (AppUserObjectPrivilege)m_objectPrivilege.get(objectID);
        if (objectPrivilege != null) {
            return objectPrivilege;
        }
        
        Enumeration components = getRoleList().elements();
        
        SearchRequest filter = new SearchRequest();
        while (components.hasMoreElements()) {
            long roleID = ((AppRoleImpl)components.nextElement()).getRoleID();
            filter.add(new Parameter("AppObjectPrivilege", "RoleID", Long.toString(roleID)));
        }
        
        // filter.add(new Parameter("AppObjectPrivilege", "RoleID",
        // AppRoleImpl.getPublicRoleID((Session)theAppServer.getInternalSession()).toString()));
        filter.add(new Parameter("AppObjectPrivilege", "ObjectID", objectID.toString()));
        components = AppObjectPrivilegeImpl.getObjectsWithBlob(filter, theAppServer.getInternalSession());
        
        objectPrivilege = new AppUserObjectPrivilege();
        if (enforceColumnSecurity) {
            objectPrivilege.columnExceptions = new Hashtable();
        }
        
        boolean firstEditExceptionsLoaded = false;
        boolean firstViewExceptionsLoaded = false;
        
        while (components.hasMoreElements()) {
            AppObjectPrivilegeImpl appObjPriv = (AppObjectPrivilegeImpl)components.nextElement();
            if (appObjPriv.getValue1()) {
                objectPrivilege.readPrivilege = true;
                objectPrivilege.executePrivilege = true;
            }
            if (appObjPriv.getValue2()) {
                objectPrivilege.createPrivilege = true;
            }
            if (appObjPriv.getValue3()) {
                objectPrivilege.updatePrivilege = true;
            }
            if (appObjPriv.getValue4()) {
                objectPrivilege.deletePrivilege = true;
            }
            
            if (enforceColumnSecurity) {
                Object colSecurityObj = appObjPriv.getValue("AttrSecurityObject");
                if (objectPrivilege.readPrivilege) {
                    AppUserImpl.loadColPrivs(objectPrivilege.columnExceptions, colSecurityObj, firstViewExceptionsLoaded,
                        DataConst.VIEW_SIGN);
                    firstViewExceptionsLoaded = true;
                }
                
                if (objectPrivilege.createPrivilege || objectPrivilege.updatePrivilege) {
                    AppUserImpl.loadColPrivs(objectPrivilege.columnExceptions, colSecurityObj, firstEditExceptionsLoaded,
                        DataConst.EDIT_SIGN);
                    firstEditExceptionsLoaded = true;
                }
            }
        }
        synchronized (m_objectPrivilege) {
            m_objectPrivilege.put(objectID, objectPrivilege);
        }
        return objectPrivilege;
    }
    
    /**
     * Method enableReadOnlyCacheForQuery.
     *
     * @param thd Thread
     * @see Session#enableReadOnlyCacheForQuery(Thread)
     */
    public void enableReadOnlyCacheForQuery(Thread thd) {
        // if user have manully enable session caching, just use it
        if (sessionReadOnlyCache != null) {
            return;
        }
        
        getReadOnlyCaches().put(thd, new Hashtable(3));
    }
    
    /**
     * Method disableReadOnlyCacheForQuery.
     *
     * @param thd Thread
     * @see Session#disableReadOnlyCacheForQuery(Thread)
     */
    public void disableReadOnlyCacheForQuery(Thread thd) {
        Hashtable cache = (Hashtable)getReadOnlyCaches().get(thd);
        if (cache != null) {
            cache.clear();
        }
        
        getReadOnlyCaches().remove(thd);
    }
    
    /**
     * Method enableReadOnlyCacheForSession.
     *
     * @see Session#enableReadOnlyCacheForSession()
     */
    public void enableReadOnlyCacheForSession() {
        sessionReadOnlyCache = new Hashtable(3);
    }
    
    /**
     * Method disableReadOnlyCacheForSession.
     *
     * @see Session#disableReadOnlyCacheForSession()
     */
    public void disableReadOnlyCacheForSession() {
        if (sessionReadOnlyCache != null) {
            sessionReadOnlyCache.clear();
        }
        
        sessionReadOnlyCache = null;
    }
    
    private static final short VALID_KEY = 1;
    private static final short UNIQUE_KEY = 2;
    private static final short INVALID_KEY = -1;
    
    private int checkKey(Vector key, VSMetaQuery metaQuery) {
        //Get the primary key from meta data
        VSMetaKey metaKey = metaQuery.getChildMostTable().getUniqueKey();
        if (metaKey == null) {
            return UNIQUE_KEY;
        }
        boolean isDifferentKey = false;
        
        int colIndex = 0;
        for (Enumeration e = metaKey.getMetaColumns(); e.hasMoreElements(); colIndex++) {
            VSMetaColumn pkeyCol = (VSMetaColumn)e.nextElement();
            Parameter param = null;
            int i;
            for (i = 0; i < key.size(); i++) {
                param = (Parameter)key.elementAt(i);
                if (param.value == null) {
                    return INVALID_KEY;
                }
                if (pkeyCol.getName().equalsIgnoreCase(param.fieldName)) {
                    break;
                }
            }
            
            if (i >= key.size() || colIndex >= key.size()) {
                isDifferentKey = true;
                break;
            }
            
            if (colIndex != i) {
                //Swap so that they are sorted in the end
                Parameter param2 = (Parameter)key.elementAt(colIndex);
                key.setElementAt(param, colIndex);
                key.setElementAt(param2, i);
            }
        }
        
        if (isDifferentKey) {
            return UNIQUE_KEY;
        } else {
            return VALID_KEY;
        }
    }
    
    /**
     * Method getObjectByKey.
     *
     * @param metaQuery VSMetaQuery
     * @param xdac XDAConnector
     * @param pkey SearchRequest
     * @return DataObject
     * @see Session#getObjectByKey(VSMetaQuery, XDAConnector, SearchRequest)
     */
    public DataObject getObjectByKey(VSMetaQuery metaQuery, XDAConnector xdac, SearchRequest pkey) {
        Vector keyParam = pkey.parameterList;
        Hashtable readCache = sessionReadOnlyCache;
        if (readCache == null) {
            readCache = (Hashtable)getReadOnlyCaches().get(Thread.currentThread());
        }
        ObjectHashtable objectCache = null;
        
        //caching enabled
        if (readCache != null) {
            objectCache = (ObjectHashtable)readCache.get(metaQuery);
            if (objectCache == null) {
                objectCache = new ObjectHashtable();
                readCache.put(metaQuery, objectCache);
            } else {
                DataObject bo = objectCache.get(keyParam);
                // If we find the dummy object, it means we have search the database but no able
                // to find record, so return null
                if (bo == DataObject.dummy) {
                    return null;
                }
                
                if (bo != null) {
                    return bo;
                }
                
            }
        }
        
        int ck = checkKey(keyParam, metaQuery);
        if (ck == INVALID_KEY) {
            return null;
        }
        
        VSORBResultSetImpl rs = new VSORBResultSetImpl(metaQuery, pkey, null, -1, DataConst.NONE_LOB, -1, xdac, xdac
            .getConnection(true));
        
        GenericComponentFactory.raiseAfterQueryEvent(metaQuery, rs, null);
        DataRow row = rs.fetch();
        
        if (row == null) {
            rs.close();
            // We can't store null to object cache, but need a flag to indicate we have search
            // the database but could not find the record, late call will skip the database query
            // if get dummy for the keyparam
            if (objectCache != null) {
                objectCache.put(keyParam, DataObject.dummy);
            }
            
            return null;
        } else {
            DataObject bo = row.getComponent();
            if (objectCache != null) {
                objectCache.put(keyParam, bo);
            }
            
            rs.close();
            return bo;
        }
    }
    
    // overloaded method for better cache lookup
    
    /**
     * Method getObjectByKey.
     *
     * @param metaQuery VSMetaQuery
     * @param pkey SearchRequest
     * @return DataObject
     * @see Session#getObjectByKey(VSMetaQuery, SearchRequest)
     */
    public DataObject getObjectByKey(VSMetaQuery metaQuery, SearchRequest pkey) {
        Vector keyParam = pkey.parameterList;
        
        int ck = checkKey(keyParam, metaQuery);
        if (ck == INVALID_KEY) {
            return null;
        }
        
        Hashtable readCache = sessionReadOnlyCache;
        if (readCache == null) {
            readCache = (Hashtable)getReadOnlyCaches().get(Thread.currentThread());
        }
        DataObject bo;
        ObjectHashtable objectCache = null;
        
        //caching enabled
        if (readCache != null) {
            objectCache = (ObjectHashtable)readCache.get(metaQuery);
            if (objectCache == null) {
                objectCache = new ObjectHashtable();
                readCache.put(metaQuery, objectCache);
            } else {
                bo = objectCache.get(keyParam);
                // If we find the dummy object, it means we have search the database but no able
                // to find record, so return null
                if (bo != null && bo == DataObject.dummy) {
                    return null;
                }
                
                if (bo != null) {
                    return bo;
                }
            }
        }
        
        XDAConnector xdac = createXDAConnector(metaQuery);
        
        VSORBResultSetImpl rs = new VSORBResultSetImpl(metaQuery, pkey, null, -1, DataConst.NONE_LOB, -1, xdac, xdac
            .getConnection(true));
        
        GenericComponentFactory.raiseAfterQueryEvent(metaQuery, rs, null);
        
        DataRow row = rs.fetch();
        
        if (row == null) {
            rs.close();
            // We can't store null to object cache, but need a flag to indicate we have search
            // the database but could not find the record, late call will skip the database query
            // if get dummy for the keyparam
            if (objectCache != null) {
                objectCache.put(keyParam, DataObject.dummy);
            }
            
            return null;
        } else {
            bo = row.getComponent();
            if (objectCache != null) {
                objectCache.put(keyParam, bo);
            }
            
            rs.close();
            return bo;
        }
    }
    
    /**
     * @param metaQuery VSMetaQuery
     * @return XDAConnector
     * @throws ServerException
     * @internal.tle
     */
    public XDAConnector createXDAConnector(VSMetaQuery metaQuery) throws ServerException {
        XDAConnector xda = null;
        try {
            VSMetaTable table = metaQuery.getChildMostTable();
            if (table != null) {
                xda = (XDAConnector)localClassCache.getClass(table.getXDAConnectorClassName()).newInstance();
            } else {                
                xda = VersionHolder.enterpriseVersion ? (XDAConnector)XDASQLConnector.class.newInstance() : 
                	(XDAConnector)Class.forName("com.versata.tl.vls.dataaccess.XDASQLConnector").newInstance();
            }
        } catch (Exception ex) {
            _LOGGER.error(ex);
        }
        
        if (xda != null) {
            xda.setSession(this);
            xda.setProperties(getMyDataServiceLoginForObject(metaQuery.getName()));
        }
        
        return xda;
    }
    
    /**
     * This routine returns the value of a object cached at session level.
     *
     * @param name The name for which the value is being requested.
     * @return Object    a value of the entry
     * @see com.versata.tl.vls.core.Session#getAttribute(String)
     */
    public Object getAttribute(String name) {
        return sessionAttributes == null ? null : sessionAttributes.get(name);
    }
    
    /**
     * This routine sets the value to a session level cache.  These are defined for the life of the session.  This method will
     * update an existing entry if it finds it, or it will add a new entry.
     *
     * @param name The name of the entry which should be updated by this call
     * @param value The value to which the entry should be updated.
     * @see Session#setAttribute(String, Object)
     */
    public void setAttribute(String name, Object value) {
        if (sessionAttributes == null) {
            sessionAttributes = new HashMap(3);
        }
        sessionAttributes.put(name, value);
    }
    
    /**
     * This routine removes the entry from the session level cache.
     *
     * @param name The name of the entry which should be removed by this call
     * @see com.versata.tl.vls.core.Session#removeAttribute(String)
     */
    public void removeAttribute(String name) {
        if (sessionAttributes != null) {
            sessionAttributes.remove(name);
        }
    }
    
    /**
     * remove all objects cached within current session
     *
     * @see Session#removeAllAttributes()
     */
    public void removeAllAttributes() {
        if (sessionAttributes != null) {
            sessionAttributes.clear();
        }
    }
    
    /**
     * @param name
     * @return byte array
     * @throws VSORBException
     * @internal.tle
     */
    public byte[] getSerializableAttribute(String name) throws VSORBException {
        return SerializationUtil.serializeToByteArray(name);
    }
    
    /**
     * @param name
     * @param value
     * @internal.tle
     */
    public void setSerializableAttribute(String name, byte[] value) {
        setAttribute(name, SerializationUtil.deserializeFromByteArray(value, Object.class));
    }
    
    CMDConsoleServer cmdConsoleServer;
    
    /**
     * @param rs
     * @internal.tle This will keep track of the remote RS and close it on session.close
     */
    public void addRemoteResultSet(ResultSet rs) {
        remoteResultSets.put(rs, rs);
    }
    
    /**
     * @param rs
     * @internal.tle This will keep track of the remote RS and close it on session.close
     */
    public void removeRemoteResultSet(ResultSet rs) {
        remoteResultSets.remove(rs);
    }
    
    /**
     * @internal.tle This will keep track of the remote RS and close it on session.close
     */
    public void closeRemoteResultSets() {
        Enumeration e = remoteResultSets.keys();
        while (e.hasMoreElements()) {
            ((ResultSet)e.nextElement()).close();
        }
        remoteResultSets.clear();
    }
    
    /**
     * Sets the instance of the security manager for this session
     *
     * @param securityManager the security manager instance to be associated with this session
     */
    public void setSecurityManager(VSSecurityManager securityManager) {
        this.securityManager = securityManager;
    }
    
    /**
     * Return the instance of the security manager for this session
     *
     * @return the security manager instance to be associated with this session
     */
    public VSSecurityManager getSecurityManager() {
        return securityManager;
    }
    
    /**
     * Method isReadTransactionInProgress.
     *
     * @return boolean
     * @see Session#isReadTransactionInProgress()
     */
    public boolean isReadTransactionInProgress() {
        return readTxInProgress;
    }
    
    /**
     * @param isReadTransactionInProgress boolean
     * @internal.tle
     * @see Session#setReadTransactionInProgress(boolean)
     */
    public void setReadTransactionInProgress(boolean isReadTransactionInProgress) {
        readTxInProgress = isReadTransactionInProgress;
    }
    
    /**
     * @return QueryResponse
     * @internal.tle Returns the new instance of QueryResponse
     */
    protected QueryResponse getNewQueryResponse() {
        return new QueryResponse();
    }
    
    /**
     * @return QueryRequest
     * @internal.tle Returns the new instance of QueryRequest
     */
    protected QueryRequest getNewQueryRequest() {
        return new QueryRequest();
    }
    
    protected synchronized Hashtable getReadOnlyCaches() {
        if (readOnlyCaches == null) {
            readOnlyCaches = new Hashtable();
        }
        return readOnlyCaches;
    }

    public Vector getConnections() {
        return connections;
    }
}
