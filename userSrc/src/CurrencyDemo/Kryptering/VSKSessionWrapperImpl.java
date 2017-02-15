package CurrencyDemo.Kryptering;

import com.versata.tl.common.Property;
import com.versata.tl.common.QueryRequest;
import com.versata.tl.common.QueryResponse;
import com.versata.tl.common.RemoteObjectProperties;
import com.versata.tl.common.ServerEvent;
import com.versata.tl.common._tie_VSORBSecuritySession;
import com.versata.tl.common.vlsobject.VSORBException;
import com.versata.tl.common.vlsobject.VSORBResultSet;
import com.versata.tl.common.vlsobject.VSORBSecuritySession;
import com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations;
import com.versata.tl.common.vlsobject.VSORBSession;
import com.versata.tl.common.VSORBResultSetPackage.atEndException;
import com.versata.tl.common.VSORBSessionPackage.ORBRows;
import com.versata.tl.common.ejb.VLSRemoteObject;
import com.versata.tl.common.exception.MailException;
import com.versata.tl.common.exception.ServerSecurityException;
import com.versata.tl.common.statistics.DataServiceStatistics;
import com.versata.tl.common.statistics.ServerStatistics;
import com.versata.tl.common.transaction.Current;
import com.versata.tl.common.transaction.NoTransactionException;
import com.versata.tl.common.transaction.SubtransactionsUnavailableException;
import com.versata.tl.util.SerializationUtil;
import com.versata.tl.vfc.ui.swing.control.VSORBSessionWrapperImpl;
import com.versata.tl.vls.core.VSORBSessionImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

import javax.ejb.EJBHome;
import javax.ejb.EJBObject;
import javax.ejb.Handle;
import javax.ejb.RemoveException;

public class VSKSessionWrapperImpl extends VSORBSessionWrapperImpl 
    implements VSORBSecuritySession 
{
	VSORBSecuritySession session;

    public VSKSessionWrapperImpl()
    {
    	super();
		System.out.println("VSKSessionWrapperImpl()");
    }
    public VSKSessionWrapperImpl(VSORBSession orbSession)
    {
    	super(orbSession);
//        session = (VSORBSecuritySession)orbSession;
//        
//        System.out.println("VSKSessionWrapperImpl(     Session="+session.getClass().getName()+")");
//        System.out.println("VSKSessionWrapperImpl(VSORBSession="+orbSession.getClass().getName()+")");
//        session = (VSORBSecuritySession)orbSession;
    }
    public void initialize(VSORBSession orbSession)
    {
    	super.initialize(orbSession);
//        session = (VSORBSecuritySession)orbSession;
//		System.out.println("VSKSessionWrapperImpl.initialize(     Session="+session.getClass().getName()+")");
//		System.out.println("VSKSessionWrapperImpl.initialize(VSORBSession="+orbSession.getClass().getName()+")");
//		System.out.println("Vsk_tie_VSORBSecuritySession: "+(orbSession instanceof Vsk_tie_VSORBSecuritySession));
//		System.out.println("   _tie_VSORBSecuritySession: "+(orbSession instanceof    _tie_VSORBSecuritySession));
//		System.out.println("     VSORBSessionWrapperImpl: "+(orbSession instanceof      VSORBSessionWrapperImpl));
//		System.out.println("                VSORBSession: "+(orbSession instanceof    			   VSORBSession));
//		System.out.println("            VSORBSessionImpl: "+(orbSession instanceof    		   VSORBSessionImpl));
		
    }


    public Object executeQuery(QueryRequest queryRequest) throws VSORBException, RemoteException
	{
		System.out.println("VSKSessionWrapperImpl.executeQuery(QueryRequest) 1.");
		queryRequest.setIsCompressRows(true);
		Object o = super.executeQuery(queryRequest);	//o=com.versata.tl.common.QueryResponse

//		try	//DEKRYPTERA MED XOR...
//		{
//			byte pattern = (byte) 0xAC;
//			QueryResponse resp = (QueryResponse) o;
//
//			Object[][] qwerty = resp.getRowsAsObjects();
//			if(qwerty == null){ 
//				System.out.println("getRowsAsObjects returnerade null!!!");
//				qwerty = resp.getRows();
//				qwerty[0][0]= "DEKRYPTERAT";
//			}
//			
//			for(int i=0 ; i<qwerty.length ; i++)
//				for(int j=0 ; j<qwerty[i].length ; j++)
//				{
//					String x =  "";
////					String cpy = new String( qwerty[i][j] );
////					if(cpy == null) cpy="<Null>";
//					
//					if(qwerty[i][j] != null)
//					{
//						byte[] b =  (byte[]) qwerty[i][j];	//.getBytes();
////						byte[] c =  b.clone();
//						for(int k=0 ; k<b.length ; k++)
//						{
//							if(k > 0) x += ",";
//							x += Integer.toString( b[k] );
//							
//							b[k] = (byte)(( (int)b[k] ^ pattern ) & 0xFF ); 
//						}
//						qwerty[i][j] = new String ( b ); 
//
//					}
//					System.out.println("RAD["+i+"]["+j+"]" +qwerty[i][j] + " har dekrypterats från "+ x );
//				}
////			
//			resp.setRows((String[][]) qwerty );
////			resp.setRowsAsObjects( qwerty );
//		}
//		catch(atEndException ae){;}
//		catch(Throwable th)
//		{
//			System.out.println(th.toString());
//		}
		
//		try
//		{
//			System.out.println("DEKRYPTERAR PÅ KLIENTEN ");
//			byte[] bs = Converter.serialize( o );
//			System.out.println("SERIALISERAT... ");
//			o = Converter.deserialize_XOR( bs );
//			System.out.println("DEKRYPTERING KLAR ");
//
//		}
//		catch(Throwable th)
//		{
//			System.err.println(th.toString());
//		}
		
		
		
		System.out.println("VSKSessionWrapperImpl.executeQuery(QueryRequest) 2."+o.getClass().getName());
	    return o;
	}
//---------------------------------------------------------------------
//	VSORBSessionWrapperImpl
//---------------------------------------------------------------------
//  Session sätts i konstruktorn (alt i metoden initialize) vid inloggning.
//  public VSORBSessionWrapperImpl(VSORBSession orbSession)
//		session = (VSORBSecuritySession)orbSession;    
//  public void initialize(VSORBSession orbSession)  
//  	session = (VSORBSecuritySession)orbSession;    

//	hamnar på servern i 
//  Vsk_tie_VSORBSecuritySession.executeQuery(QR) 1.
//	EJBFrameworkFactoryVSKImpl.getResultSetDelegate(rs)
//  Vsk_tie_VSORBResultSet._delegate() 
//  SELECT SKJUTS...
//	Vsk_tie_VSORBSecuritySession.executeQuery(QR) 2.  
//  ----  
//  public Object executeQuery(QueryRequest queryRequest) throws VSORBException, RemoteException
//	{
//	    return session.executeQuery(queryRequest);
//	}
//  VSORBSecuritySession session;    << interface som implementeras av 
//  *  VSORBSessionWrapperImpl
//---------------------------------------------------------------------
//  * _tie_VSORBSecuritySession 	 << common..
//---------------------------------------------------------------------
//    public Object executeQuery(QueryRequest queryRequest)
//    throws VSORBException
//{
//    return _delegate.executeQuery(queryRequest);
//}
//    private VSORBSecuritySessionOperations _delegate;
//    implementeras av VLSContextBean, VSORBSessionImpl, VSORBSessionImpl_ejb     
//---------------------------------------------------------------------
    

    
//---------------------------------------------------------------------
//    public Current begin()    throws SubtransactionsUnavailableException, RemoteException
//    {
//		System.out.println("VSKSessionWrapperImpl.begin()");
//    	return super.begin();
//    }

/*************************************************************************
	@Override
	public void addEventListener(int id) throws ServerSecurityException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.addEventListener(id)");
		
	}

	@Override
	public void clearErrorsAtStartup() throws ServerSecurityException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.clearErrorsAtStartup()");
		
	}

	@Override
	public void deleteAppForm(String formName, String applicationName,
			String repositoryName) throws VSORBException,
			ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.deleteAppForm()");
		
	}

	@Override
	public void deleteAppPage(String pageName, String applicationName,
			String repositoryName) throws VSORBException,
			ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.deleteAppPage()");
		
	}

	@Override
	public void deleteApplication(String applicationName, String repositoryName)
			throws VSORBException, ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.deleteApplication()");
		
	}

	@Override
	public void deleteBusinessObject(String businessObjectName,
			String repositoryName) throws VSORBException,
			ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.deleteBusinessObject()");
		
	}

	@Override
	public void deleteMethod(String methodName, String businessObjectName,
			String repositoryName) throws VSORBException,
			ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.deleteMethod()");
		
	}

	@Override
	public void deleteObjectAttribute(String attributeName,
			String businessObjectName, String repositoryName)
			throws VSORBException, ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.deleteObjectAttribute()");
		
	}

	@Override
	public void deleteRole(String roleName) throws VSORBException,
			ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.deleteRole()");
		
	}

	@Override
	public void deleteUser(String appServerlogin) throws VSORBException,
			ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.deleteUser()");
		
	}

	@Override
	public String executeCommand(String command) throws VSORBException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.executeCommand()");
		return null;
	}

	@Override
	public String[] getDataServiceIDs() throws ServerSecurityException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.getDataServiceIDs()");
		return null;
	}

	@Override
	public DataServiceStatistics getDataServiceStatistics(String dsID)
			throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.getDataServiceStatistics()");
		return null;
	}

	@Override
	public ServerEvent[] getNextServerEvents(int id)
			throws ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.getNextServerEvents()");
		return null;
	}

	@Override
	public String[] getRegisteredApplicationList() throws VSORBException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.getRegisteredApplicationList()");
		return null;
	}

	@Override
	public String[] getRegisteredAttributeListForObject(
			String businessObjectName, String repositoryName)
			throws VSORBException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.getRegisteredAttributeListForObject()");
		return null;
	}

	@Override
	public String[] getRegisteredBusinessObjectList() throws VSORBException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.getRegisteredBusinessObjectList()");
		return null;
	}

	@Override
	public String[] getRegisteredFormListForApplication(String applicationName,
			String repositoryName) throws VSORBException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.getRegisteredFormListForApplication()");
		return null;
	}

	@Override
	public String[] getRegisteredMethodListForObject(String businessObjectName,
			String repositoryName) throws VSORBException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.getRegisteredMethodListForObject()");
		return null;
	}

	@Override
	public String[] getRegisteredPageListForApplication(String applicationName,
			String repositoryName) throws VSORBException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.getRegisteredPageListForApplication()");
		return null;
	}

	@Override
	public String[] getRegisteredRoleList() throws VSORBException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.getRegisteredRoleList()");
		return null;
	}

	@Override
	public String[] getRegisteredUserList() throws VSORBException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.getRegisteredUserList()");
		return null;
	}

	@Override
	public String getServerProperty(String property) throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.getServerProperty()");
		return null;
	}

	@Override
	public Property[] getServerPropertyList() throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.getServerPropertyList()");
		return null;
	}

	@Override
	public ServerStatistics getServerStatistics() throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.getServerStatistics()");
		return null;
	}

	@Override
	public VSORBSession[] getSessions() throws ServerSecurityException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.getSessions()");
		return null;
	}

	@Override
	public boolean isAnotherEsmRunning() throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.isAnotherEsmRunning()");
		return false;
	}

	@Override
	public void refresh() throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.refresh()");
		
	}

	@Override
	public void refreshRepoSecurityData() throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.refreshRepoSecurityData");
		
	}

	@Override
	public void registerAppForm(String formName, String applicationName,
			String repositoryName) throws VSORBException,
			ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.registerAppForm");
		
	}

	@Override
	public void registerAppPage(String pageName, String applicationName,
			String repositoryName) throws VSORBException,
			ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.registerAppPage");
		
	}

	@Override
	public void registerApplication(String applicationName,
			String repositoryName) throws VSORBException,
			ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.registerApplication");
		
	}

	@Override
	public void registerMethod(String methodName, String businessObjectName,
			String repositoryName) throws VSORBException,
			ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.registerMethod");
		
	}

	@Override
	public void registerObjectAttribute(String attributeName,
			String businessObjectName, String repositoryName)
			throws VSORBException, ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.registerObjectAttribute");
		
	}

	@Override
	public void registerRole(String roleName, boolean manageUser,
			boolean connect) throws VSORBException, ServerSecurityException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.registerRole");
		
	}

	@Override
	public void registerUser(String appServerlogin, String password,
			String userName) throws VSORBException, ServerSecurityException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.registerUser");
		
	}

	@Override
	public void removeEventListener(int id) throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.removeEventListener");
		
	}

	@Override
	public void replicateTo(String slaveAppHostName, String slaveAppServer,
			String login, String password) throws ServerSecurityException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.replicateTo");
		
	}

	@Override
	public void replicateTo(String slaveAppHostName, String slaveAppServer,
			String login, String password, String JNDIName)
			throws ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.replicateTo");
		
	}

	@Override
	public void setAppFormPrivilege(String appFormName, String applicationName,
			String repositoryName, String roleName, boolean execute)
			throws VSORBException, ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.setAppFormPrivilege");
		
	}

	@Override
	public void setAppPagePrivilege(String appPageName, String applicationName,
			String repositoryName, String roleName, boolean execute)
			throws VSORBException, ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.setAppPagePrivilege");
		
	}

	@Override
	public void setApplicationPrivilege(String applicationName,
			String repositoryName, String role, boolean execute)
			throws VSORBException, ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.setApplicationPrivilege");
		
	}

	@Override
	public void setApplicationPrivilegeProperty(String applicationName,
			String repositoryName, String roleName, String property,
			String value) throws VSORBException, ServerSecurityException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.setApplicationPrivilegeProperty");
		
	}

	@Override
	public void setApplicationProperty(String applicationName,
			String repositoryName, String property, String value)
			throws VSORBException, ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.setApplicationProperty");
		
	}

	@Override
	public void setBusinessObjectPrivilegeProperty(String businessObjectName,
			String repositoryName, String roleName, String property,
			String value) throws VSORBException, ServerSecurityException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.setBusinessObjectPrivilegeProperty");
		
	}

	@Override
	public void setBusinessObjectPrivileges(String businessObjectName,
			String repositoryName, String role, boolean read, boolean create,
			boolean update, boolean delete) throws VSORBException,
			ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.setBusinessObjectPrivileges");
		
	}

	@Override
	public void setBusinessObjectProperty(String businessObjectName,
			String repositoryName, String property, String value)
			throws VSORBException, ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.setBusinessObjectProperty");
		
	}

	@Override
	public void setDataServerProperty(String dataServer, String property,
			String value) throws VSORBException, ServerSecurityException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.setDataServerProperty");
		
	}

	@Override
	public void setMethodPrivilege(String methodName,
			String businessObjectName, String repositoryName, String role,
			boolean execute) throws VSORBException, ServerSecurityException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.setMethodPrivilege");
		
	}

	@Override
	public void setObjectAttributePrivilege(String attributeName,
			String businessObjectName, String repositoryName, String roleName,
			boolean edit, boolean view) throws VSORBException,
			ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.setObjectAttributePrivilege");
		
	}

	@Override
	public void setRoleProperty(String roleName, String property, String value)
			throws VSORBException, ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.setRoleProperty");
		
	}

	@Override
	public void setServerProperty(String property, String value, boolean flush)
			throws ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.setServerProperty");
		
	}

	@Override
	public void setTraceEnable(int id, boolean state) throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.setTraceEnable");
		
	}

	@Override
	public void setUserAssignment(String appServerlogin, String roleName,
			boolean assigned, boolean granting) throws VSORBException,
			ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.setUserAssignment");
		
	}

	@Override
	public void setUserAssignmentProperty(String appLoginID, String roleName,
			String property, String value) throws VSORBException,
			ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.setUserAssignmentProperty");
		
	}

	@Override
	public void setUserDataServerLogin(String appServerlogin,
			String dataServer, String dataServerLogin, String dataServerPassword)
			throws VSORBException, ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.setUserDataServerLogin");
		
	}

	@Override
	public void setUserProperty(String appLoginID, String property, String value)
			throws VSORBException, ServerSecurityException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.setUserProperty");
		
	}

	@Override
	public void shutDownTheServer() throws ServerSecurityException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.shutDownTheServer");
		
	}

	@Override
	public void startLogDump(String fileName, boolean append)
			throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.startLogDump");
		
	}

	@Override
	public void stopLogDump() throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.stopLogDump");
		
	}

	@Override
	public boolean testConnectionProperties(String dataSourceName,
			String userLogin) throws ServerSecurityException, VSORBException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.testConnectionProperties");
		return false;
	}

	@Override
	public void writeLogString(String logString) throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.writeLogString");
		
	}

	@Override
	public Current begin() throws SubtransactionsUnavailableException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.begin");
		return null;
	}

	@Override
	public boolean canUpdatePackage(String id) throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.canUpdatePackage");
		return false;
	}

	@Override
	public void changeMyPassword(String loginID, String oldPassword,
			String newPassword, String confirmPassword) throws VSORBException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.changeMyPassword");
		
	}

	@Override
	public void close() throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.close");
		
	}

	@Override
	public void commit() throws NoTransactionException, VSORBException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.commit");
		
	}

	@Override
	public Object executeQuery(QueryRequest queryRequest)
			throws VSORBException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.executeQuery");
		return null;
	}

	@Override
	public boolean flushAfterSave(boolean value) throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.flushAfterSave");
		return false;
	}

	@Override
	public boolean getCoLocated() throws VSORBException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.getCoLocated");
		return false;
	}

	@Override
	public int getCurrentVersion() throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.getCurrentVersion");
		return 0;
	}

	@Override
	public String getDataServerForObject(String objectName)
			throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.getDataServerForObject");
		return null;
	}

	@Override
	public Property[] getDataServerProperties(String objectName)
			throws VSORBException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.getDataServerProperties");
		return null;
	}

	@Override
	public String getDataServerProperty(String objectName, String property)
			throws RemoteException, ServerSecurityException {
		System.out.println("VSKSessionWrapperImpl.getDataServerProperty");
		return null;
	}

	@Override
	public String getDatabaseTypeName() throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.getDatabaseTypeName");
		return null;
	}

	@Override
	public boolean getErrorsAtStartup() throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.getErrorsAtStartup");
		return false;
	}

	@Override
	public String[] getLocaleStrings() throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.getLocaleStrings");
		return null;
	}

	@Override
	public byte[] getMetaQuery(String packageName, String componentName)
			throws VSORBException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.getMetaQuery");
		return null;
	}

	@Override
	public boolean getMyAccessToRole(String roleName) throws VSORBException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.getMyAccessToRole");
		return false;
	}

	@Override
	public Property[] getMyNonViewableColumnPrivileges(String objectName)
			throws VSORBException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.getMyNonViewableColumnPrivileges");
		return null;
	}

	@Override
	public Property[] getMyObjectPrivileges(String objectName, String objectType)
			throws VSORBException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.getMyObjectPrivileges");
		return null;
	}

	@Override
	public boolean getMyPrivilegeToAppForm(String appName, String formName)
			throws VSORBException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.getMyPrivilegeToAppForm");
		return false;
	}

	@Override
	public boolean getMyPrivilegeToMethod(String privilegeType,
			String objectName, String methodOrColumnName)
			throws VSORBException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.getMyPrivilegeToMethod");
		return false;
	}

	@Override
	public boolean getMyPrivilegeToObjectName(String privilegeType,
			String objectName, String objectType) throws VSORBException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.getMyPrivilegeToObjectName");
		return false;
	}

	@Override
	public VSORBResultSet getMyRolesToGrant() throws ServerSecurityException,
			VSORBException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.getMyRolesToGrant");
		return null;
	}

	@Override
	public Property[] getMyUpdateableColumnPrivileges(String objectName)
			throws VSORBException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.getMyUpdateableColumnPrivileges");
		return null;
	}

	@Override
	public boolean getMyUserPrivilege(String privilegeType)
			throws VSORBException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.getMyUserPrivilege");
		return false;
	}

	@Override
	public Property[] getMyUserPrivileges() throws VSORBException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.getMyUserPrivileges");
		return null;
	}

	@Override
	public String getName() throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.getName");
		return null;
	}

	@Override
	public String getProductVersion() throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.getProductVersion");
		return null;
	}

	@Override
	public String getProperty(String property) throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.getProperty");
		return null;
	}

	@Override
	public Object getPropertyAsObject(String property) throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.getPropertyAsObject");
		return null;
	}

	@Override
	public Property[] getPropertyList() throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.getPropertyList");
		return null;
	}

	@Override
	public VSORBResultSet getResultSetByRequest(String componentName,
			byte[] filter, byte[] sorter, int preFetchRowCount)
			throws VSORBException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.getResultSetByRequest");
		return null;
	}

	@Override
	public VSORBResultSet getResultSetByRequest1(String componentName,
			byte[] filter, byte[] sorter, int preFetchRowCount,
			short columnProjectionLevel, boolean dataPreFetch,
			int randomAccessPos, boolean isAutoCloseResultSet)
			throws VSORBException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.getResultSetByRequest1");
		return null;
	}

	@Override
	public VSORBResultSet getResultSetBySQLRemote(String SQL,
			String dataServerName, int preFetchRowCount, boolean dataPreFetch)
			throws VSORBException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.getResultSetBySQLRemote");
		return null;
	}

	@Override
	public VSORBResultSet getResultSetBySQLRemote1(String SQL,
			String dataServerName, int preFetchRowCount, boolean dataPreFetch,
			int randomAccessPos, boolean isAutoCloseResultSet)
			throws VSORBException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.getResultSetBySQLRemote1");
		return null;
	}

	@Override
	public VSORBResultSet getResultSetFromCache(String componentName,
			int preFetchRowCount) throws VSORBException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.getResultSetFromCache");
		return null;
	}

	@Override
	public String getSecurityMetadataVersion() throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.getSecurityMetadataVersion");
		return null;
	}

	@Override
	public Object getServerSecurityObject() throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.getServerSecurityObject");
		return null;
	}

	@Override
	public int getSessionID() throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.getSessionID");
		return 0;
	}

	@Override
	public int getSessionPingRate() throws VSORBException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.getSessionPingRate");
		return 0;
	}

	@Override
	public String getUserID() throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.getUserID");
		return null;
	}

	@Override
	public String getUserName() throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.getUserName");
		return null;
	}

	@Override
	public boolean isConsoleSession() throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.isConsoleSession");
		return false;
	}

	@Override
	public boolean isSecuritySession() throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.isSecuritySession");
		return false;
	}

	@Override
	public void ping() throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.ping");
		
	}

	@Override
	public void ping2() throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.ping2");
		
	}

	@Override
	public void pushSecurityDataWithLogin(byte[] sd, int masterVersion,
			String login, String password) throws ServerSecurityException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.pushSecurityDataWithLogin");
		
	}

	@Override
	public Object removeProperty(String property) throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.removeProperty");
		return null;
	}

	@Override
	public void rollback() throws NoTransactionException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.rollback");
		
	}

	@Override
	public String[][] save(ORBRows orbRows) throws VSORBException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.save");
		return null;
	}

	@Override
	public void sendMail(String[] to, String[] cc, String from,
			String mailServer, String subject, String msg,
			short transactionalType) throws MailException, RemoteException {
		System.out.println("VSKSessionWrapperImpl.sendMail");
		
	}

	@Override
	public void setCoLocated(boolean bool) throws VSORBException,
			RemoteException {
		System.out.println("VSKSessionWrapperImpl.setCoLocated");
		
	}

	@Override
	public void setProperties(String[][] properties) throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.setProperties");
		
	}

	@Override
	public void setProperty(String property, String value)
			throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.setProperty");
		
	}

	@Override
	public void setPropertyAsObject(String property, Object value)
			throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.setPropertyAsObject");
		
	}

	@Override
	public void setRepositoryName(String repositoryName) throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.setRepositoryName");
		
	}

	@Override
	public void setUpdatePackage(String id) throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.setUpdatePackage");
		
	}

	@Override
	public void setUpdatePackageForApp(String id) throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.setUpdatePackageForApp");
		
	}

	@Override
	public void setUserDefinedEvent(String eventName) throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.setUserDefinedEvent");
		
	}
***/
//	@Override
//	public EJBHome getEJBHome() throws RemoteException {
//		System.out.println("VSKSessionWrapperImpl.getEJBHome()");
//		return super.getEJBHome();
//	}
/***
	@Override
	public Handle getHandle() throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.getHandle");
		return null;
	}

	@Override
	public Object getPrimaryKey() throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.getPrimaryKey");
		return null;
	}

	@Override
	public boolean isIdentical(EJBObject arg0) throws RemoteException {
		System.out.println("VSKSessionWrapperImpl.isIdentical");
		return false;
	}

	@Override
	public void remove() throws RemoteException, RemoveException {
		System.out.println("VSKSessionWrapperImpl.remove");
		
	}
******************************************************************/	
/********************
 * 		com.versata.tl.vls.ejb._VLSContext_Stub.java 
 * samt i _VSORBSecuritySession_Stub 
 * samt i _VSORBSession_Stub 
 * 
 * 
        public java.lang.Object executeQuery(QueryRequest queryrequest)
        throws RemoteException
    {
        ServantObject servantobject;
        do
        {
            while(!Util.isLocal(this)) 
            {
                org.omg.CORBA_2_3.portable.InputStream inputstream = null;
                try
                {
                    try
                    {
                        try
                        {
                            org.omg.CORBA_2_3.portable.OutputStream outputstream = (org.omg.CORBA_2_3.portable.OutputStream)_request("executeQuery", true);
                            outputstream.write_value(queryrequest, com.versata.tl.common.QueryRequest.class);
                            inputstream = (org.omg.CORBA_2_3.portable.InputStream)_invoke(outputstream);
                            java.lang.Object obj = Util.readAny(inputstream);
                            return obj;
                        }
                        catch(ApplicationException applicationexception)
                        {
                            inputstream = (org.omg.CORBA_2_3.portable.InputStream)applicationexception.getInputStream();
                            String s = inputstream.read_string();
                            throw new UnexpectedException(s);
                        }
                        catch(RemarshalException _ex) { }
                    }
                    catch(SystemException systemexception)
                    {
                        throw Util.mapSystemException(systemexception);
                    }
                }
                finally
                {
                    _releaseReply(inputstream);
                }
            }
            servantobject = _servant_preinvoke("executeQuery", com.versata.tl.common.vlsobject.VSORBSession.class);
        } while(servantobject == null);
        try
        {
            Throwable throwable1;
            try
            {
                QueryRequest queryrequest1 = (QueryRequest)Util.copyObject(queryrequest, _orb());
                java.lang.Object obj2 = ((VSORBSession)servantobject.servant).executeQuery(queryrequest1);
                java.lang.Object obj1 = Util.copyObject(obj2, _orb());
                return obj1;
            }
            catch(Throwable throwable)
            {
                throwable1 = (Throwable)Util.copyObject(throwable, _orb());
            }
            throw Util.wrapException(throwable1);
        }
        finally
        {
            _servant_postinvoke(servantobject);
        }
    }
 * 
 * 
 *************************/
    
}