package CurrencyDemo.Kryptering;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.rmi.RemoteException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import javax.ejb.EJBObject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.servlet.http.HttpServletRequest;

import com.versata.tl.common.MetaColumn;
import com.versata.tl.common.QueryResponse;
import com.versata.tl.common.VSSession;
import com.versata.tl.common.exception.ServerException;
import com.versata.tl.common.exception.TierSessionLimitException;
import com.versata.tl.common.exception.VSException;
import com.versata.tl.common.meta.VSMetaQuery;
import com.versata.tl.common.meta.VSMetaTable;
import com.versata.tl.common.meta.VSQueryDefinition;
import com.versata.tl.common.security.VSMapSecurityInfo;
import com.versata.tl.common.security.VSSecurityObjectHolder;
import com.versata.tl.common.security.VSSecurityObjectImpl;
import com.versata.tl.common.text.RuntimeMsgCode;
import com.versata.tl.common.util.SearchRequest;
import com.versata.tl.common.util.UnSynchronizedVector;
import com.versata.tl.common.vlsobject.VSORBAppServer;
import com.versata.tl.common.vlsobject.VSORBException;
import com.versata.tl.common.vlsobject.VSORBResultSet;
import com.versata.tl.common.vlsobject.VSORBSecuritySession;
import com.versata.tl.common.vlsobject.VSORBSession;
import com.versata.tl.common.vstrace.IVSTraceVocab;
import com.versata.tl.util.ClassCache;
import com.versata.tl.util.SerializationUtil;
import com.versata.tl.vfc.dataaccess.XDAEJBConnector;
import com.versata.tl.vfc.pls.common.PLSORBSession;
import com.versata.tl.vfc.pls.common.XDAPLSEJBConnector;
import com.versata.tl.vfc.ui.swing.control.IVSORBSessionWrapper;
import com.versata.tl.vfc.ui.swing.control.VSORBSessionWrapperImpl;
import com.versata.tl.vls.core.DataRow;
import com.versata.tl.vls.core.Session;
import com.versata.tl.vls.dataaccess.XDAConnector;
import com.versata.tl.vls.dataaccess.XDASQLConnector;
import com.versata.tl.vls.dataaccess.connection.Connection;
import com.versata.tl.vls.dataaccess.connection.VSJdbc;
import com.versata.tl.vls.ejb.VLSContext;
import com.versata.tl.vls.ejb.VLSContextBean;
import com.versata.tl.vls.ejb.VLSContextHome;
//import com.versata.tl.vls.ejb._VLSContextHome_Stub;
//import com.versata.tl.vls.ejb._VLSContext_Stub;



public class VSKConnector extends XDAEJBConnector 
implements Serializable
{
	private static final long serialVersionUID = 1L;

	public VSKConnector() 
    {
    	super();
    	System.setProperty("javax.net.ssl.trustStore","C:/Versata/BRMS-2016/workbench/workspace_VSK_CurrencyDemo/CurrencyDemo/userSrc/src/CurrencyDemo/Kryptering/SSL/client.keystore");
        System.setProperty("javax.net.ssl.trustStorePassword","123456");
    	System.out.println("VSKConnector()");
    }

	
    public InitialContext getInitialContext(String server)
    throws Exception
    {
    	InitialContext ic = super.getInitialContext(server);
    	System.out.println("VSKConnector.getInitialContext()");
    	return ic;
    }
    protected String getDefaultProviderUrl(Properties vsJndiprop)
    {
        String dpu = super.getDefaultProviderUrl(vsJndiprop);
//    	System.out.println("VSKConnector.getDefaultProviderUrl()");
    	return dpu;
    }

    public boolean isServerDownException(Throwable th)
    {
    	boolean bDOWN = super.isServerDownException(th);
//    	System.out.println("VSKConnector.isServerDownException()"+bDOWN);
    	return  bDOWN;
    }
    public boolean fetchNextRow(java.lang.Object rowValues[])  throws VSException
	{
    	boolean bok = super.fetchNextRow(rowValues);
//    	System.out.println("VSKConnector.fetchNextRow() "+getComponentName());
    	return  bok;
   	/*******************************************
	    if(rowIndex == bufferSize)
	    {
	        if(fetchTerminated)
	            throw new VSException(RuntimeMsgCode.XDACLIENTCONNECTORIMPL211);
	        if(fetchEnd)
	            return false;
	        fetchData();
	    }
	    if(rowIndex != bufferSize)
	    {
	        if(getSession().isCoLocated())
	        {
	            int columnCount = rowValues.length;
	            System.arraycopy(((java.lang.Object) (queryObjectBuffer[rowIndex])), 0, ((java.lang.Object) (rowValues)), 0, columnCount);
	        } else
	        {
	            populateRow(rowValues, rowIndex, queryBuffer);
	        }
	        rowIndex++;
	        return true;
	    } else
	    {
	        queryObjectBuffer = (java.lang.Object[][])null;
	        queryBuffer = (String[][])null;
	        return false;
	    }
	    **********************************************/
	}

    protected void fetchData()
    {
    	super.fetchData();
//    	System.out.println("VSKConnector.fetchData()  "+getComponentName());

    	/****************************
        if(fetchEnd)
            return;
        try
        {
            if(getSession().isCoLocated())
            {
                queryObjectBuffer = queryResponse.localFetch();
                bufferSize = queryObjectBuffer.length;
            } else
            {
                queryBuffer = queryResponse.fetchRows();
                bufferSize = queryBuffer.length;
            }
            if(bufferSize != maxRowsPerFetch)
            {
                closeRemoteResultSet();
                fetchEnd = true;
            }
        }
        catch(atEndException endExException)
        {
            closeRemoteResultSet();
            bufferSize = 0;
            fetchEnd = true;
        }
        catch(VSORBException orbEx)
        {
            throw new VSException(VFCMsgCode.FAILED_FETCH_DATA, orbEx);
        }
        catch(Exception ex)
        {
            if(isServerDownException(ex))
                getSession().sessionTerminated();
            else
            if(ex.getMessage().indexOf("com.versata.tl.common.VSORBResultSetPackage.atEndException") > 0)
            {
                closeRemoteResultSet();
                bufferSize = 0;
                fetchEnd = true;
            } else
            if(ex.getMessage().indexOf("completed: Maybe") > 0)
            {
                closeRemoteResultSet();
                bufferSize = 0;
                fetchEnd = true;
            } else
            {
                throw new VSException(VFCMsgCode.FAILED_FETCH_DATA, ex);
            }
        }
        rowIndex = 0;
        ****************************************/
    }

    
    public VSORBSession connect(String newServer, String newLogin, String newPwd, String appName, String repositoryName, VSSecurityObjectHolder security_object)
    throws TierSessionLimitException
    {
    	System.out.println("VSKConnector.connect(.....)");
//    	for(int i=10001 ; i<=10009 ;i++)
//    		System.out.println("...Port "+i+" = " +VSKConnector.available(i) );

    	//getSecuritySessionJ2EE(newServer, newLogin, newPwd, ejbRefName);
    	//connectJ2EE(newServer, newLogin, newPwd, appName, repositoryName, security_object, ejbRefName);
    	//getSecuritySessionJNDI(newServer, newLogin, newPwd, JNDIName);
    	//connectJNDI(newServer, newLogin, newPwd, appName, repositoryName, security_object, JNDIName);
    	//XDAEJBConnector_Common
    	
    	
    	String md5PW = getMD5code( newPwd );
    	String SHAPW = cryptPassword( newPwd );
    	System.out.println("VSKConnector.connect(pw:"+newPwd+" kan krypteras till "+md5PW+")");

//    	VSSecurityObjectImpl so = (VSSecurityObjectImpl)security_object.getSecurityObject();
//    	newLogin = so.getLogin();
//    	so = new VSSecurityObjectImpl(newLogin, md5PW);
//    	security_object.setSecurityObject(so);
    	
    	VSORBSession s = super.connect(newServer,newLogin,newPwd,appName,repositoryName,security_object);
//    	for(int i=10001 ; i<=10009 ;i++)
//    		System.out.println("...Port "+i+" = " +VSKConnector.available(i) );
    	return s;
    	
//    	return super.connect(newServer,newLogin,md5PW ,appName,repositoryName,security_object);
    }
    
    public VSORBAppServer  getAppServer()
    {
    	System.out.println("VSKConnector.getAppServer()");
    	return super.getAppServer();
    }
    
	public VSORBSession getSecuritySessionJ2EE(String newServer, String newLogin, String newPwd, String ejbRefName)
	{
    	System.out.println("VSKConnector.getSecuritySessionJ2EE()");
		return super.getSecuritySessionJ2EE(newServer, newLogin, newPwd, ejbRefName);
	}
	
	public VSORBSession connectJ2EE(String newServer, String newLogin, String newPwd, String appName, String repositoryName, VSSecurityObjectHolder security_object, String ejbRefName)
	{
    	System.out.println("VSKConnector.connectJ2EE()");
		return super.connectJ2EE(newServer, newLogin, newPwd, appName, repositoryName, security_object, ejbRefName);
	}
	
	public VSORBSession getSecuritySessionJNDI(String newServer, String newLogin, String newPwd, String JNDIName)
	{
    	System.out.println("VSKConnector.getSecuritySessionJNDI()");
		return super.getSecuritySessionJNDI(newServer, newLogin, newPwd, JNDIName);
	}
	
	public VSORBSession connectJNDI(String newServer, String newLogin, String newPwd, String appName, String repositoryName, VSSecurityObjectHolder security_object, String JNDIName)
	{
    	System.out.println("*VSKConnector.connectJNDI(.....)");
//    	System.out.println("VSKConnector.connectJNDI.Port 10001 = " +VSKConnector.available(10001) );
    	
    	VSORBSession os = super.connectJNDI(newServer, newLogin, newPwd, appName, repositoryName, security_object, JNDIName);

//    	System.out.println("VSKConnector.connectJNDI.Port 10001 = " +VSKConnector.available(10001) );
  
    	return os;
//		return super.connectJNDI(newServer, newLogin, newPwd, appName, repositoryName, security_object, JNDIName);
	}

   
    public VSORBSession connectInternal(String newServer, String newLogin, String newPwd, String appName, String repositoryName, VSSecurityObjectHolder security_object, String ejbName, 
            boolean isJ2EE)
        throws TierSessionLimitException
    {
    	
//    	return super.connectInternal(newServer, newLogin, newPwd, appName, repositoryName, security_object, ejbName, isJ2EE);
    	
    	
/***********************************************************/    	
        VSORBSession sessionWrapper;
        String providerURL = getProviderURL(newServer);
        p_security_object = security_object;
        
//        if(_LOGGER.isDebugEnabled())
//            _LOGGER.debug(RuntimeMsgCode.XDAEJBCONNECTOR197);
        String sessionHomeName = bundle.getProperty("SessionHomeName");
//        if(_LOGGER.isDebugEnabled())
//            _LOGGER.debug(RuntimeMsgCode.XDAEJBCONNECTOR198);
        VLSContextHome sessionHome;
        try
        {
            if(ejbName == null)
                ejbName = sessionHomeName;
            sessionHome = (VLSContextHome)getEJBHome(ejbName, Class.forName("com.versata.tl.vls.ejb.VLSContextHome"), providerURL, isJ2EE);
        	System.out.println("sessionHome instans av VLSContextBean: "+(sessionHome instanceof VLSContextBean));

        }
        catch(Exception ex)
        {
            throw new VSException(RuntimeMsgCode.XDAEJBCONNECTOR199, providerURL, ex);
        }
        
    	System.out.println("VSKConnector.connectInternal.1.Port 10001 = " +VSKConnector.available(10001) );

        
//        if(_LOGGER.isDebugEnabled())
//            _LOGGER.debug(RuntimeMsgCode.XDAEJBCONNECTOR200);
        
        
        sessionWrapper = loadSessionWrapper();
        if(sessionWrapper == null) return null;	//?

    	System.out.println("VSKConnector.connectInternal.2.Port 10001 = " +VSKConnector.available(10001) );

        
        VSORBSession session;
        VLSContext blscontext;
        try
        {
            if("VersataESM".equals(appName) && repositoryName == null)
            {
                blscontext = sessionHome.create(newLogin, newPwd, "VersataESM");
//                System.out.println("sessionHome:"+sessionHome.getClass().getName()+"   "+(sessionHome instanceof _VLSContext_Stub));
//                System.out.println("blscontext :"+blscontext .getClass().getName()+"   "+(sessionHome instanceof _VLSContext_Stub));

                blscontext.init();
                session = blscontext.getRemoteDelegate();	
                return session;
            }
            else
            {
            	VLSContextHome x;
                blscontext = sessionHome.create(SerializationUtil.serializeToByteArray(security_object), appName, repositoryName);
//                System.out.println("sessionHome:"+sessionHome.getClass().getName()+"   "+(sessionHome instanceof _VLSContextHome_Stub));
//                System.out.println("blscontext :"+blscontext .getClass().getName()+"   "+(sessionHome instanceof _VLSContextHome_Stub));
            	System.out.println("blscontext :"+blscontext .getClass().getName()+"   "+(blscontext  instanceof VLSContextBean));


                blscontext.init();
                
//                org.jboss.ejb.client.EJBInvocationHandler i;
//				_VLSContextHome_Stub                
//				_VLSContext_Stub                
                
                session = null;
//                try
//                {
                    session = blscontext.getRemoteDelegate();	//<<< Binder port 10001 (VLSContextBean)
//                }
//                catch(Throwable th)
//                {
//                	System.err.println(th.toString());
//                }
//                
                if(session != null)
                    ((IVSORBSessionWrapper)sessionWrapper).initialize(session);
                else
                    sessionWrapper = null;

            }

        }
        catch(RemoteException e)
        {
            Throwable tr = e;
            if(e.getCause() != null)
                tr = e.getCause();
            throw new VSException(RuntimeMsgCode.EMPTY_MSG, tr.getLocalizedMessage(), e);
        }
        catch(Exception e)
        {
            throw new VSException(RuntimeMsgCode.PLSORBSESSIONIMPL44, e.getLocalizedMessage(), e);
        }

        System.out.println("VSKConnector.connectInternal.3.Port 10001 = " +VSKConnector.available(10001) );
        

//        if(_LOGGER.isDebugEnabled())
//            _LOGGER.debug(RuntimeMsgCode.XDAEJBCONNECTOR204);
        return sessionWrapper;

/*************************************************/

    }

    private static final ClassCache localClassCache = new ClassCache();
    private VSORBSession loadSessionWrapper()
    {
        String sessionWrapperClassName = bundle.getProperty("VSORBSessionWrapper");
        if(sessionWrapperClassName == null)
            sessionWrapperClassName = "com.versata.tl.vfc.ui.swing.control.VSORBSessionWrapperImpl";
        VSORBSession wc;
        try
        {
            Class c = localClassCache.getClass(sessionWrapperClassName);
            Class parameterTypes[] = new Class[0];
            Constructor constructor = c.getConstructor(parameterTypes);
            Object initargs[] = new Object[0];
            wc = (VSORBSession)constructor.newInstance(initargs);
        }
        catch(Exception e)
        {
            wc = new VSORBSessionWrapperImpl();
//            _LOGGER.warn(RuntimeMsgCode.OBJECTACTIVATOR448, sessionWrapperClassName, e);
        }
        return wc;
    }
    
    
	
    public static boolean available(int port) 
    {
    	
//        if (port < MIN_PORT_NUMBER || port > MAX_PORT_NUMBER) {
//            throw new IllegalArgumentException("Invalid start port: " + port);
//        }

        ServerSocket ss = null;
        DatagramSocket ds = null;
        try {
            ss = new ServerSocket(port);
            ss.setReuseAddress(true);
            ds = new DatagramSocket(port);
            ds.setReuseAddress(true);
            return true;
        } catch (IOException e) {
        } finally {
            if (ds != null) {
                ds.close();
            }

            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    /* should not be thrown */
                }
            }
        }

        return false;
    }
	
    
    
    
//    public VSORBSecuritySession getRemoteDelegate()
//    throws RemoteException
//    {
//    	super.getRemoteDelegate();
//    }
    
    
    
    
    public static String cryptPassword( String pwd ) 
    {
		 if( pwd == null || pwd.length() == 0 ) 
		 {
		 	return null;
		 }
		 
		 byte[] buf= new byte[pwd.length()];
		 java.security.MessageDigest algorithm=null;
		 try 
		 {
		     buf = pwd.getBytes("UTF-8"); 
		     algorithm = java.security.MessageDigest.getInstance("SHA-1");
		 }
		 catch (Exception e) 
		 {
		     e.printStackTrace();
		     return null;
		 }
		 algorithm.reset();
		 algorithm.update(buf);
		 
		 byte[] encrypt = algorithm.digest();
		 try 
		 {
		     return new String( encrypt ,"UTF-8" );
		 }
		 catch (Exception e) 
		 {
		     return new String( encrypt );
		 }
	 }
   
	private String getMD5code(String original) //throws Exception 
	{
		StringBuffer sb = new StringBuffer();
		try 
		{
			MessageDigest md = MessageDigest.getInstance("MD5");
			original="qwdd"+original+"salt";
			md.update(original.getBytes());

			byte[] digest = md.digest();
			for (int i = 0; i < digest.length; ++i) 
			{
		       sb.append(Integer.toHexString((digest[i] & 0xFF) | 0x100).substring(1,3));
		    }
		} 
		catch (NoSuchAlgorithmException e) 
		{
			e.printStackTrace();
		}
		return sb.toString() ;
	}
    


    
	//överridet från XDAClientConnectorImpl
	public void execute(String queryText, String dataServerName)
    {
		System.out.println("VSKConnector.execute(queryText,dataServerName) 1.");
		super.execute(queryText, dataServerName);
		System.out.println("VSKConnector.execute(queryText,dataServerName) 2.");
    }
	public void execute(boolean fetchFromCache)
    throws VSException
    {
		super.execute(fetchFromCache);
    }
//	private QueryResponse executeQuery(QueryRequest qreq)
//    throws Exception
//{
//    QueryResponse qres = (QueryResponse)getORBSession().executeQuery(qreq);
//    return qres;
//}
    protected void initXDAConnector(VSSession session, VSORBResultSet rs, VSMetaQuery metaQuery)
    throws VSORBException
{
    	super.initXDAConnector(session, rs, metaQuery);
//    vsSession = session;
//    if(metaQuery != null)
//    {
//        this.metaQuery = metaQuery;
//        componentName = metaQuery.getName();
//    }
//    resetFlagAndCounters();
//    queryResponse = getNewQueryResponse();
//    queryResponse.setRS(rs);
//    queryResponse.setQueryRequest(getNewQueryRequest());
//    getSession().addSessionFailedListener(sessionFailedListener);
//    if(metaQuery == null)
//        buildMetaColumnsForAdhocQuery();
//    else
//        buildTypeArray();
}
    protected void buildMetaColumnsForAdhocQuery()
    throws VSORBException
{
    	super.buildMetaColumnsForAdhocQuery();
//    MetaColumn mcols[];
//    try
//    {
//        mcols = queryResponse.registerMetaData();
//    }
//    catch(Exception re)
//    {
//        throw new VSException(VFCMsgCode.FAILED_TO_REGISTER_METADATA, re);
//    }
//    int len = mcols.length;
//    columnTypes = new int[len];
//    VSMetaColumn vsmc[] = new VSMetaColumn[len];
//    for(int i = 0; i < len; i++)
//    {
//        vsmc[i] = new VSMetaColumn(mcols[i].name);
//        vsmc[i].setColumnType(mcols[i].type);
//        vsmc[i].setNullability(mcols[i].nullable);
//        vsmc[i].setAutoIncrement(mcols[i].autoIncrement);
//        columnTypes[i] = mcols[i].type;
//    }
//
//    metaColumns = vsmc;
}    
//    protected void buildTypeArray()
//    {
//    }
	
	
//---------------------------------------------------------------------------------------------------------------------------------------	
//	  XDAClientConnectorImpl	
//    public void execute(String queryText, String dataServerName)
//    {
//        resetFlagAndCounters();
//        try
//        {
//            QueryRequest qr = getNewQueryRequest();
//            qr.setSQL(queryText);
//            qr.setDataServerName(dataServerName);
//            qr.setMaxRowsPerFetch(maxRowsPerFetch);
//            qr.setServerPreFetch(serverPreFetch);
//            qr.setRequestRandomAccessPos(requestRandomAccessPos);
//            qr.setUseStatelessRS(getUseStatelessRS());
//            qr.setPrefetchRowCount(preFetchRowCount);
//            qr.setIsCompressRows(isCompressRows());
//            queryResponse = executeQuery(qr);
//            getSession().addSessionFailedListener(sessionFailedListener);
//            buildMetaColumnsForAdhocQuery();
//        }
//        catch(VSORBException orbEx)
//        {
//            throw new VSException(VFCMsgCode.FAILED_EXECUTE_ADHOC_QUERY, new java.lang.Object[] {
//                queryText, dataServerName
//            }, orbEx);
//        }
//        catch(Exception re)
//        {
//            if(isServerDownException(re))
//            {
//                if(getSession().sessionTerminated())
//                    execute(queryText, dataServerName);
//            } else
//            {
//                throw new VSException(VFCMsgCode.FAILED_EXECUTE_ADHOC_QUERY, new java.lang.Object[] {
//                    queryText, dataServerName
//                }, re);
//            }
//        }
//    }
//    private QueryResponse executeQuery(QueryRequest qreq)
//    throws Exception
//{
//    if(_LOGGER.isDebugEnabled())
//        _LOGGER.debug((new StringBuilder()).append("XDAClientConnectorImpl.executeQuery qreq -> ").append(qreq.toString()).toString());
//    QueryResponse qres = (QueryResponse)getORBSession().executeQuery(qreq);
//    if(_LOGGER.isDebugEnabled())
//        _LOGGER.debug((new StringBuilder()).append("XDAClientConnectorImpl.executeQuery qres -> ").append(qres.toString()).toString());
//    return qres;
//}
//    public VSORBSession getORBSession()
//    {
//        return vsSession.getORBSession();
//    }
//    protected VSSession vsSession;
//	  vsSession sätts i metoderna initXDAConnector(...)	
//---------------------------------------------------------------------------------------------------------------------------------------	

	
//---------------------------------------------------------------------------------------------------------------------------------------	
	  public VSORBSession getORBSession()
	  {
		  System.out.println("VSKConnector.getORBSession() 1.");
//		  VSORBSession o = (Vsk_tie_VSORBSecuritySession)super.getORBSession();
		  VSORBSession o = super.getORBSession();
		  System.out.println("VSKConnector.getORBSession() 2."+o.getClass().getName());	//VSKSesssionWrapperImpl
		  return o;
	  }
	  public VSSession getSession()
	  {
//		  System.out.println("VSKConnector.getSession() 1.");
		  VSSession vsSession = super.getSession();
		  VSORBSession orb = vsSession.getORBSession();
//		  System.out.println("VSKConnector.getSession() 2."+vsSession.getClass().getName());
//		  System.out.println("VSKConnector.getSession() 3."+orb.getClass().getName());
		  return vsSession;
	  }
	    

//	  VSORBSessionWrapper
//	    public Object executeQuery(QueryRequest queryRequest)
//        throws VSORBException, RemoteException
//    {
//        return session.executeQuery(queryRequest);
//    }
	  
	  
	  
//-------------------------------------------------------------------------------------------------------------	  
//		VSORBSessionImpl_Base
//-------------------------------------------------------------------------------------------------------------	  
//	    public VSORBSecuritySession getRemoteReferenceForSecuritySession()
//	    {
//	        if(remoteReferenceSecuritySession == null)
//	            remoteReferenceSecuritySession = ServerEnvironment.getFactoryImpl().makeVLSSecuritySession(this);
//	        return remoteReferenceSecuritySession;
//	    }	  
//	    public VSORBSecuritySession getLocalReferenceForSecuritySession()
//	    {
//	        if(localReferenceSecuritySession == null)
//	            localReferenceSecuritySession = ServerEnvironment.getFactoryImpl().makeVLSSecuritySessionWrapper(this);
//	        return localReferenceSecuritySession;
//	    }
	  
//-------------------------------------------------------------------------------------------------------------	  
//		VSORBAppServerImpl
//-------------------------------------------------------------------------------------------------------------	  
//	    protected final VSORBSession getSession(String user, String password, String clientAppName, String projectName, boolean coLocated, VSSecurityManager secmgr)
//        throws ServerSecurityException, MaxSessionExceededException, TierSessionLimitException
//    {
//        VSORBSessionImpl aSession = createSession(user, password, clientAppName, projectName);
//        if(secmgr != null)
//            aSession.setSecurityManager(secmgr);
//        aSession.setCoLocated(coLocated);
//        VSORBSession remoteSession;
//        if(coLocated)
//            remoteSession = aSession.getLocalReferenceForSecuritySession();
//        else
//            remoteSession = aSession.getRemoteReferenceForSecuritySession();
//        initializeTrace(aSession);
//        sessions.put(aSession, remoteSession);
//        afterSessionCreate(aSession);
//        return remoteSession;
//    }
	  
//	    protected final VSORBSession getSession(Vector roleList, String user, String password, String clientAppName, String projectName, VSSecurityManager secmgr)
//        throws ServerSecurityException, MaxSessionExceededException, TierSessionLimitException
//    {
//        beforeSessionCreate(user, password, clientAppName, projectName);
//        validateConnection();
//        VSORBSessionImpl aSession = new VSORBSessionImpl(this, roleList, user, password, clientAppName, false, projectName, false);
//        aSession.setSecurityManager(secmgr);
//        VSORBSession remoteSession = aSession.getRemoteReferenceForSecuritySession();
//        initializeTrace(aSession);
//        sessions.put(aSession, remoteSession);
//        afterSessionCreate(aSession);
//        return remoteSession;
//    }
  
//	    public VSORBSecuritySession getSecuritySession(String user, String password, String clientAppName)
//        throws ServerSecurityException, MaxSessionExceededException, TierSessionLimitForSecurityException
//    {
//        VSORBSessionImpl aSession = new VSORBSessionImpl(this, user, password, clientAppName, false, "com.versata.tl.vls.admin", true);
//        VSORBSecuritySession remoteSession = aSession.getRemoteReferenceForSecuritySession();
//        initializeTrace(aSession);
//        sessions.put(aSession, remoteSession);
//        return remoteSession;
//    }	
	  
//	  public VSORBSessionImpl getSecuritySessionInternal(String user, String password, String clientAppName)
//    throws ServerSecurityException, MaxSessionExceededException, TierSessionLimitForSecurityException
//{
//    VSORBSessionImpl aSession = new VSORBSessionImpl(this, user, password, clientAppName, false, "com.versata.tl.vls.admin", true);
//    initializeTrace(aSession);
//    return aSession;
//}
	  
//-------------------------------------------------------------------------------------------------------------	  
//	  VLSContextBean
//-------------------------------------------------------------------------------------------------------------	  
//	    public VSORBSecuritySession getRemoteDelegate()
//      throws RemoteException
//  {
//      System.out.println("VLSContextBean().getRemoteDelegate()");
//      if(_flddelegate == null)
//          try
//          {
//              initializeDelegate();
//          }
//          catch(ServerSecurityException e)
//          {
//              throw new RemoteException(e.getLocalizedMessage());
//          }
//      VSORBSecuritySession obj = ((VSORBSessionImpl)_flddelegate).getRemoteReferenceForSecuritySession();
//      VSORBSecuritySession tmp = (VSORBSecuritySession)UnicastRemoteObject.exportObject(obj, RemoteObjectProperties.getInstance().getUnicastExportPort());
//      return tmp;
//  }
//	    private transient VSORBSecuritySessionOperations _flddelegate;

//	    private void initializeDelegate()
//        throws ServerSecurityException
//    {
//        System.out.println("VLSContextBean().initializeDelegate()");
//        if(securityHolder == null && usr == null)
//        {
//            initializeDelegateWithKey();
//        } else
//        {
//            appServer.refreshSecurityData();
//            VSORBSessionImpl session;
//            if(securityHolder != null)
//                session = appServer.getSession1InternalEJB(securityHolder, applicationName, packageName, sessionContext);
//            else
//                session = appServer.getSecuritySessionInternal(usr, pwd, applicationName);
//            _flddelegate = session;
//            ((VSORBSessionImpl)_flddelegate).setVLSContextBean(sessionContext.getEJBObject());
//        }
//    }
//	    private void initializeDelegateWithKey()
//	    {
//	        System.out.println("VLSContextBean().initializeDelegateWithKey()");
//	        if(_LOGGER.isDebugEnabled())
//	            _LOGGER.debug(RuntimeMsgCode.VLSCONTEXTBEAN563, MessageLocalizer.getLocalizedMessage(RuntimeMsgCode.VLSCONTEXTBEAN561, String.valueOf(key)));
//	        _flddelegate = (VSORBSecuritySessionOperations)EJBFrameworkFactoryImpl.getSessionDelegate(key);
//	        ((VSORBSessionImpl)_flddelegate).setVLSContextBean(sessionContext.getEJBObject());
//	        if(_LOGGER.isDebugEnabled())
//	            _LOGGER.debug(RuntimeMsgCode.VLSCONTEXTBEAN563, MessageLocalizer.getLocalizedMessage(RuntimeMsgCode.VLSCONTEXTBEAN563));
//	    }

	  
	  
	  
/*****************************	  
	    public Object getEJBHome(String ejbName, Class homeClass, String server, boolean isJ2EE)
        throws Exception
    {
        String homeJNDIName;
        InitialContext ic;
        if(isJ2EE)
        {
            ic = new InitialContext();
            homeJNDIName = (new StringBuilder("java:comp/env/ejb/")).append(ejbName).toString();
        } 
        else
        {
            ic = getInitialContext(server);
            homeJNDIName = ejbName;
        }
        Object home = null;
        try
        {
            System.out.println("Lookup.Name: "+homeJNDIName);
            System.out.println("Lookup.Home: "+homeClass);
        	home = PortableRemoteObject.narrow(ic.lookup(homeJNDIName), homeClass);
        	System.out.println("Lookup.Obj : "+home.getClass().getName());
        	System.out.println("instans av VLSContextBean: "+(home instanceof VLSContextBean));
        	
        }
        catch(NamingException naming_ex)
        {
            initCtxt = null;
            if(isJ2EE)
            {
                ic = new InitialContext();
                homeJNDIName = (new StringBuilder("java:comp/env/ejb/")).append(ejbName).toString();
            } else
            {
                ic = getInitialContext(server);
                homeJNDIName = ejbName;
            }
            try
            {
                home = PortableRemoteObject.narrow(ic.lookup(homeJNDIName), homeClass);
            }
            catch(Exception e)
            {
                ic = new InitialContext();
                homeJNDIName = (new StringBuilder("java:comp/env/ejb/")).append(ejbName).toString();
                try
                {
                    home = PortableRemoteObject.narrow(ic.lookup(homeJNDIName), homeClass);
                }
                catch(Exception ex)
                {
                	System.err.println(ex.toString());
//                    handleException(ex, homeJNDIName, homeClass);
                }
            }
        }
        catch(Exception e)
        {
        	System.err.println(e.toString());
//            handleException(e, homeJNDIName, homeClass);
        }
        return home;
    }
************************************/	    

	    
}




