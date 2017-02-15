// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VLSContextBean.java
//vs-tle-beans-client.jar
package com.versata.tl.vls.ejb;

import com.versata.tl.api.itext.MessageLocalizer;
import com.versata.tl.api.logging.VersataLogger;
import com.versata.tl.common.*;
import com.versata.tl.common.VSORBSessionPackage.ORBRows;
import com.versata.tl.common.exception.*;
import com.versata.tl.common.security.VSSecurityObjectHolder;
import com.versata.tl.common.security.VSSecurityObjectImpl;
import com.versata.tl.common.statistics.DataServiceStatistics;
import com.versata.tl.common.statistics.ServerStatistics;
import com.versata.tl.common.text.RuntimeMsgCode;
import com.versata.tl.common.transaction.*;
import com.versata.tl.common.util.CommonEnvironment;
import com.versata.tl.common.vlsobject.*;
import com.versata.tl.util.SerializationUtil;
import com.versata.tl.vls.core.*;
import com.versata.tl.vls.service.ServerEnvironment;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

// Referenced classes of package com.versata.tl.vls.ejb:
//            EJBFrameworkFactoryImpl

public class VLSContextBean
    implements SessionBean, VSORBSecuritySessionOperations
{

    public VLSContextBean()
    {
    	System.out.println("VLSContextBean()");
    }

    public void ejbActivate()
        throws RemoteException
    {
    	System.out.println("VLSContextBean().ejbActivate()");
        if(_LOGGER.isDebugEnabled())
            _LOGGER.debug((new StringBuilder()).append("ejbActivate in :").append(this).append(" at ").append(new Date()).toString());
    }

    public void ejbCreate()
        throws RemoteException
    {
        System.out.println("VLSContextBean().ejbCreate()");
    }

    public void ejbCreate(int i)
        throws RemoteException
    {
            System.out.println("VLSContextBean().ejbCreate(i)");
    }

    public void ejbCreate(String user, String password, String appName, String packageName)
        throws RemoteException
    {
        System.out.println("VLSContextBean().ejbCreate(user,pw,appnamn,packagenamn)");
        ejbCreate(createSecurityHolder(user, password), appName, packageName);
    }

    public void ejbCreate(String user, String password, String appName)
        throws RemoteException
    {
        System.out.println("VLSContextBean().ejbCreate(user,pw,appnamn)");
        usr = user;
        pwd = password;
        applicationName = appName;
    }

    public void ejbCreate(byte secHolder[], String clientAppName, String boPackageName)
        throws RemoteException
    {
        System.out.println("VLSContextBean().ejbCreate(byte[],clientAppnamn,packagenamn)");
        securityHolder = secHolder;
        applicationName = clientAppName;
        packageName = boPackageName;
    }

    private void initializeDelegate()
        throws ServerSecurityException
    {
        System.out.println("VLSContextBean().initializeDelegate()");
        if(securityHolder == null && usr == null)
        {
            initializeDelegateWithKey();
        } else
        {
            appServer.refreshSecurityData();
            VSORBSessionImpl session;
            if(securityHolder != null)
                session = appServer.getSession1InternalEJB(securityHolder, applicationName, packageName, sessionContext);
            else
                session = appServer.getSecuritySessionInternal(usr, pwd, applicationName);
            _flddelegate = session;
            ((VSORBSessionImpl)_flddelegate).setVLSContextBean(sessionContext.getEJBObject());
        }
    }

    private void initializeDelegateWithKey()
    {
        System.out.println("VLSContextBean().initializeDelegateWithKey()");
        if(_LOGGER.isDebugEnabled())
            _LOGGER.debug(RuntimeMsgCode.VLSCONTEXTBEAN563, MessageLocalizer.getLocalizedMessage(RuntimeMsgCode.VLSCONTEXTBEAN561, String.valueOf(key)));
        _flddelegate = (VSORBSecuritySessionOperations)EJBFrameworkFactoryImpl.getSessionDelegate(key);
        ((VSORBSessionImpl)_flddelegate).setVLSContextBean(sessionContext.getEJBObject());
        if(_LOGGER.isDebugEnabled())
            _LOGGER.debug(RuntimeMsgCode.VLSCONTEXTBEAN563, MessageLocalizer.getLocalizedMessage(RuntimeMsgCode.VLSCONTEXTBEAN563));
    }

    public void ejbPassivate()
        throws RemoteException
    {
        System.out.println("VLSContextBean().ejbPassivate()");
        if(_LOGGER.isDebugEnabled())
            _LOGGER.debug((new StringBuilder()).append("ejbPassivate in :").append(this).append(" at ").append(new Date()).toString());
        cleanupSession();
    }

    private void cleanupSession()
    {
        System.out.println("VLSContextBean().cleanupSession()");
        EJBFrameworkFactoryImpl.removeSessionDelegate(key);
        if(_flddelegate != null)
        {
            ((VSORBSessionImpl)_flddelegate).setVLSContextBean(null);
            _flddelegate.close();
            _flddelegate = null;
        }
        key = 0;
    }

    public void ejbRemove()
        throws RemoteException
    {
        System.out.println("VLSContextBean().ejbRemove()");
        if(_LOGGER.isDebugEnabled())
            _LOGGER.debug((new StringBuilder()).append("ejbRemove in :").append(this).append(" at ").append(new Date()).toString());
        cleanupSession();
    }

    public synchronized void setSessionContext(SessionContext ctxt)
    {
        System.out.println("VLSContextBean().setSessionContext(ctxt)");
        sessionContext = ctxt;
//        synchronized(com.versata.tl.common.util.CommonEnvironment)
        {
            CommonEnvironment.vlsBeanClassLoader = getClass().getClassLoader();
        }
    }

    private byte[] createSecurityHolder(String user, String password)
    {
        System.out.println("VLSContextBean().createSecurityHolder(user,pw)");
        VSSecurityObjectImpl securityObject = new VSSecurityObjectImpl(user, password);
        VSSecurityObjectHolder securityHolder = new VSSecurityObjectHolder();
        securityHolder.setSecurityObject(securityObject);
        return SerializationUtil.serializeToByteArray(securityObject);
    }

    private static void createVSORBAppServer()
    {
        System.out.println("VLSContextBean().createVSORBAppServer()");
        appServer = ServerEnvironment.getServer();
    }

    public void init()
        throws RemoteException
    {
        System.out.println("VLSContextBean().init()");
        if(_flddelegate == null)
            try
            {
                initializeDelegate();
            }
            catch(ServerSecurityException e)
            {
                throw new RemoteException(e.getLocalizedMessage());
            }
        try
        {
            appServer.addToSessionsList(getRemoteDelegate2());
        }
        catch(RemoteException ex)
        {
            _LOGGER.warn(ex);
        }
    }

    public VSORBSecuritySessionOperations getDelegate()
        throws RemoteException
    {
        System.out.println("VLSContextBean().getDelegate()");
        if(_flddelegate == null)
            try
            {
                initializeDelegate();
            }
            catch(ServerSecurityException e)
            {
                throw new RemoteException(e.getLocalizedMessage());
            }
        return _flddelegate;
    }

    public VSORBSecuritySession getRemoteDelegate2()
        throws RemoteException
    {
        System.out.println("VLSContextBean().getRemoteDelegate2()");
        if(_flddelegate == null)
            try
            {
                initializeDelegate();
            }
            catch(ServerSecurityException e)
            {
                throw new RemoteException(e.getLocalizedMessage());
            }
        VSORBSecuritySession obj = ((VSORBSessionImpl)_flddelegate).getRemoteReferenceForSecuritySession();
        return obj;
    }

    public VSORBSecuritySession getRemoteDelegate()
        throws RemoteException
    {
        System.out.println("VLSContextBean.getRemoteDelegate() 1");
        if(_flddelegate == null)
            try
            {
                initializeDelegate();
            }
            catch(ServerSecurityException e)
            {
                throw new RemoteException(e.getLocalizedMessage());
            }
        VSORBSecuritySession obj = ((VSORBSessionImpl)_flddelegate).getRemoteReferenceForSecuritySession();
        VSORBSecuritySession tmp = (VSORBSecuritySession)UnicastRemoteObject.exportObject(obj, RemoteObjectProperties.getInstance().getUnicastExportPort(),null,null);

        System.out.println("VLSContextBean.getRemoteDelegate() 2");
        
        return tmp;
    }

    public VSORBResultSet getResultSetBySQLRemote(String SQL, String dataServerName, int preFetchRowCount, boolean dataPreFetch)
        throws VSORBException
    {
        System.out.println("VLSContextBean().getResultSetBySQLRemote(sql,dataservenamn,prefetchRowCnt,prefetchData)");
        return _flddelegate.getResultSetBySQLRemote(SQL, dataServerName, preFetchRowCount, dataPreFetch);
    }

    public Object getServerSecurityObject()
    {
        System.out.println("VLSContextBean().getServerSecurityObject()");
        return _flddelegate.getServerSecurityObject();
    }

    public VSORBResultSet getResultSetBySQLRemote1(String SQL, String dataServerName, int preFetchRowCount, boolean dataPreFetch, int randomAccessPos, boolean isAutoCloseResultSet)
        throws VSORBException
    {
        System.out.println("VLSContextBean().getResultSetBySQLRemote1(sql,dataservenamn,prefetchRowCnt,prefetchData,randomAccessPos,isAutoCloseResultSet)");
        return _flddelegate.getResultSetBySQLRemote1(SQL, dataServerName, preFetchRowCount, dataPreFetch, randomAccessPos, isAutoCloseResultSet);
    }

    public VSORBResultSet getResultSetFromCache(String componentName, int preFetchRowCount)
        throws VSORBException
    {
        System.out.println("VLSContextBean().getResultSetFromCache(componentName,preFetchRowCount)");
        return _flddelegate.getResultSetFromCache(componentName, preFetchRowCount);
    }

    public VSORBResultSet getResultSetByRequest(String componentName, byte filter[], byte sorter[], int preFetchRowCount)
        throws VSORBException
    {
        System.out.println("VLSContextBean().getResultSetByRequest(componentName,filter, sorter, preFetchRowCount)");
        return _flddelegate.getResultSetByRequest(componentName, filter, sorter, preFetchRowCount);
    }

    public VSORBResultSet getResultSetByRequest1(String componentName, byte filter[], byte sorter[], int preFetchRowCount, short columnProjectionLevel, boolean dataPreFetch, int requestRandomPos, 
            boolean isAutoCloseResultSet)
        throws VSORBException
    {
        System.out.println("VLSContextBean().getResultSetByRequest1(componentName,filter, sorter, preFetchRowCount, columnProjectionLevel, dataPreFetch, requestRandomPos, isAutoCloseResultSet)");
        return _flddelegate.getResultSetByRequest1(componentName, filter, sorter, preFetchRowCount, columnProjectionLevel, dataPreFetch, requestRandomPos, isAutoCloseResultSet);
    }

    public Object executeQuery(QueryRequest queryRequest)
        throws VSORBException
    {
        System.out.println("VLSContextBean().executeQuery(queryRequest)");
        return _flddelegate.executeQuery(queryRequest);
    }

    public void close()
    {
        System.out.println("VLSContextBean().close()");
        _flddelegate.close();
    }

    public Current begin()
        throws SubtransactionsUnavailableException
    {
        System.out.println("VLSContextBean().begin()");
        return null;
    }

    public void commit()
        throws NoTransactionException, VSORBException
    {
            System.out.println("VLSContextBean().commit()");
    }

    public void rollback()
        throws NoTransactionException
    {
            System.out.println("VLSContextBean().rollback()");
    }

    public boolean flushAfterSave(boolean value)
    {
        System.out.println("VLSContextBean().flushAfterSave(b)");
        return _flddelegate.flushAfterSave(value);
    }

    public String[][] save(ORBRows orbRows)
        throws VSORBException
    {
        System.out.println("VLSContextBean().save(ORBRows)");
        return _flddelegate.save(orbRows);
    }

    public void setUserDefinedEvent(String s)
    {
        System.out.println("VLSContextBean().setUserDefinedEvent(s)");
    }

    public void sendMail(String as[], String as1[], String s, String s1, String s2, String s3, short word0)
        throws MailException
    {
            System.out.println("VLSContextBean().sendMail(s1[],s2[],s,s1,s2,s3,w0)");
    }

    public Property[] getMyUserPrivileges()
        throws VSORBException
    {
        System.out.println("VLSContextBean().getMyUserPrivileges()");
        return _flddelegate.getMyUserPrivileges();
    }

    
    
    
    
    
    public Property[] getMyUpdateableColumnPrivileges(String objectName)
        throws VSORBException
    {
        return _flddelegate.getMyUpdateableColumnPrivileges(objectName);
    }

    public Property[] getMyObjectPrivileges(String objectName, String objectType)
        throws VSORBException
    {
        return _flddelegate.getMyObjectPrivileges(objectName, objectType);
    }

    public boolean getMyUserPrivilege(String privilegeType)
        throws VSORBException
    {
        return _flddelegate.getMyUserPrivilege(privilegeType);
    }

    public boolean getMyPrivilegeToObjectName(String privilegeType, String objectName, String objectType)
        throws VSORBException
    {
        return _flddelegate.getMyPrivilegeToObjectName(privilegeType, objectName, objectType);
    }

    public boolean getMyPrivilegeToMethod(String privilegeType, String objectName, String methodOrColumnName)
        throws VSORBException
    {
        return _flddelegate.getMyPrivilegeToMethod(privilegeType, objectName, methodOrColumnName);
    }

    public boolean getMyAccessToRole(String roleName)
        throws VSORBException
    {
        return true;
    }

    public void changeMyPassword(String s, String s1, String s2, String s3)
        throws VSORBException
    {
    }

    public VSORBResultSet getMyRolesToGrant()
        throws ServerSecurityException, VSORBException
    {
        return null;
    }

    public void ping()
    {
        _flddelegate.ping();
    }

    public String getDatabaseTypeName()
    {
        return _flddelegate.getDatabaseTypeName();
    }

    public String[] getLocaleStrings()
    {
        return _flddelegate.getLocaleStrings();
    }

    public int getCurrentVersion()
    {
        return _flddelegate.getCurrentVersion();
    }

    public boolean isSecuritySession()
    {
        return _flddelegate.isSecuritySession();
    }

    public boolean isConsoleSession()
    {
        return _flddelegate.isConsoleSession();
    }

    public void ping2()
    {
        _flddelegate.ping2();
    }

    public String getUserName()
    {
        return _flddelegate.getUserName();
    }

    public String getUserID()
    {
        return _flddelegate.getUserID();
    }

    public void setPackageName(String packageName)
    {
        throw new UnsupportedOperationException();
    }

    public void setRepositoryName(String repositoryName)
    {
        _flddelegate.setRepositoryName(repositoryName);
    }

    public int getSessionID()
    {
        return _flddelegate.getSessionID();
    }

    public boolean getErrorsAtStartup()
    {
        return false;
    }

    public int getSessionPingRate()
        throws VSORBException
    {
        return 10;
    }

    public String getDataServerForObject(String objectName)
    {
        return _flddelegate.getDataServerForObject(objectName);
    }

    public String getProperty(String property)
    {
        return _flddelegate.getProperty(property);
    }

    public Object getPropertyAsObject(String property)
    {
        return _flddelegate.getPropertyAsObject(property);
    }

    public void setProperty(String property, String value)
    {
        _flddelegate.setProperty(property, value);
    }

    public void setPropertyAsObject(String property, Object value)
    {
        _flddelegate.setPropertyAsObject(property, value);
    }

    public void setProperties(String properties[][])
    {
        _flddelegate.setProperties(properties);
    }

    public Property[] getPropertyList()
    {
        return _flddelegate.getPropertyList();
    }

    public Object removeProperty(String property)
    {
        return _flddelegate.removeProperty(property);
    }

    public boolean getMyPrivilegeToAppForm(String appName, String formName)
        throws VSORBException
    {
        return true;
    }

    public void setTraceEnable(int id, boolean state)
    {
        _flddelegate.setTraceEnable(id, state);
    }

    public void addEventListener(int id)
        throws ServerSecurityException
    {
        _flddelegate.addEventListener(id);
    }

    public void removeEventListener(int id)
    {
        _flddelegate.removeEventListener(id);
    }

    public ServerEvent[] getNextServerEvents(int id)
        throws ServerSecurityException
    {
        return _flddelegate.getNextServerEvents(id);
    }

    public boolean isAnotherEsmRunning()
    {
        return _flddelegate.isAnotherEsmRunning();
    }

    public void clearErrorsAtStartup()
        throws ServerSecurityException
    {
        _flddelegate.clearErrorsAtStartup();
    }

    public boolean testConnectionProperties(String dataSourceName, String userLogin)
        throws ServerSecurityException, VSORBException
    {
        return _flddelegate.testConnectionProperties(dataSourceName, userLogin);
    }

    public String getServerProperty(String property)
    {
        return _flddelegate.getServerProperty(property);
    }

    public void setServerProperty(String property, String value, boolean flush)
        throws ServerSecurityException
    {
        _flddelegate.setServerProperty(property, value, flush);
    }

    public Property[] getServerPropertyList()
    {
        return _flddelegate.getServerPropertyList();
    }

    public VSORBSession[] getSessions()
        throws ServerSecurityException
    {
        return _flddelegate.getSessions();
    }

    public ServerStatistics getServerStatistics()
    {
        return _flddelegate.getServerStatistics();
    }

    public String[] getDataServiceIDs()
        throws ServerSecurityException
    {
        return _flddelegate.getDataServiceIDs();
    }

    public DataServiceStatistics getDataServiceStatistics(String dsID)
    {
        return _flddelegate.getDataServiceStatistics(dsID);
    }

    public void startLogDump(String fileName, boolean append)
    {
        _flddelegate.startLogDump(fileName, append);
    }

    public void writeLogString(String logString)
    {
        _flddelegate.writeLogString(logString);
    }

    public void stopLogDump()
    {
        _flddelegate.stopLogDump();
    }

    public void shutDownTheServer()
        throws ServerSecurityException
    {
        _flddelegate.shutDownTheServer();
    }

    public void replicateTo(String slaveAppHostName, String slaveAppServer, String login, String password)
        throws ServerSecurityException
    {
        _flddelegate.replicateTo(slaveAppHostName, slaveAppServer, login, password);
    }

    public void replicateTo(String slaveAppHostName, String slaveAppServer, String login, String password, String JNDIName)
        throws ServerSecurityException
    {
        _flddelegate.replicateTo(slaveAppHostName, slaveAppServer, login, password, JNDIName);
    }

    public void registerUser(String appServerlogin, String password, String userName)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.registerUser(appServerlogin, password, userName);
    }

    public void registerRole(String roleName, boolean manageUser, boolean connect)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.registerRole(roleName, manageUser, connect);
    }

    public void registerApplication(String applicationName, String repositoryName)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.registerApplication(applicationName, repositoryName);
    }

    public void registerMethod(String methodName, String businessObjectName, String repositoryName)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.registerMethod(methodName, businessObjectName, repositoryName);
    }

    public void setApplicationPrivilege(String applicationName, String repositoryName, String role, boolean execute)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.setApplicationPrivilege(applicationName, repositoryName, role, execute);
    }

    public void setMethodPrivilege(String methodName, String businessObjectName, String repositoryName, String role, boolean execute)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.setMethodPrivilege(methodName, businessObjectName, repositoryName, role, execute);
    }

    public void setBusinessObjectPrivileges(String businessObjectName, String repositoryName, String role, boolean read, boolean create, boolean update, boolean delete)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.setBusinessObjectPrivileges(businessObjectName, repositoryName, role, read, create, update, delete);
    }

    public void setUserAssignment(String appServerlogin, String roleName, boolean assigned, boolean granting)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.setUserAssignment(appServerlogin, roleName, assigned, granting);
    }

    public void setUserDataServerLogin(String appServerlogin, String dataServer, String dataServerLogin, String dataServerPassword)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.setUserDataServerLogin(appServerlogin, dataServer, dataServerLogin, dataServerPassword);
    }

    public void setDataServerProperty(String dataServer, String property, String value)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.setDataServerProperty(dataServer, property, value);
    }

    public void setUserProperty(String appLoginID, String property, String value)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.setUserProperty(appLoginID, property, value);
    }

    public void setUserAssignmentProperty(String appLoginID, String roleName, String property, String value)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.setUserAssignmentProperty(appLoginID, roleName, property, value);
    }

    public void setRoleProperty(String roleName, String property, String value)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.setRoleProperty(roleName, property, value);
    }

    public void setApplicationPrivilegeProperty(String applicationName, String repositoryName, String roleName, String property, String value)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.setApplicationPrivilegeProperty(applicationName, repositoryName, roleName, property, value);
    }

    public void setBusinessObjectPrivilegeProperty(String businessObjectName, String repositoryName, String roleName, String property, String value)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.setBusinessObjectPrivilegeProperty(businessObjectName, repositoryName, roleName, property, value);
    }

    public void setBusinessObjectProperty(String businessObjectName, String repositoryName, String property, String value)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.setBusinessObjectProperty(businessObjectName, repositoryName, property, value);
    }

    public void setApplicationProperty(String applicationName, String repositoryName, String property, String value)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.setApplicationProperty(applicationName, repositoryName, property, value);
    }

    public void deleteUser(String appServerlogin)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.deleteUser(appServerlogin);
    }

    public void deleteRole(String roleName)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.deleteRole(roleName);
    }

    public void deleteApplication(String applicationName, String repositoryName)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.deleteApplication(applicationName, repositoryName);
    }

    public void deleteBusinessObject(String businessObjectName, String repositoryName)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.deleteBusinessObject(businessObjectName, repositoryName);
    }

    public void deleteMethod(String methodName, String businessObjectName, String repositoryName)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.deleteMethod(methodName, businessObjectName, repositoryName);
    }

    public String[] getRegisteredUserList()
        throws VSORBException
    {
        return _flddelegate.getRegisteredUserList();
    }

    public String[] getRegisteredRoleList()
        throws VSORBException
    {
        return _flddelegate.getRegisteredRoleList();
    }

    public String[] getRegisteredApplicationList()
        throws VSORBException
    {
        return _flddelegate.getRegisteredApplicationList();
    }

    public String[] getRegisteredBusinessObjectList()
        throws VSORBException
    {
        return _flddelegate.getRegisteredBusinessObjectList();
    }

    public String[] getRegisteredMethodListForObject(String businessObjectName, String repositoryName)
        throws VSORBException
    {
        return _flddelegate.getRegisteredMethodListForObject(businessObjectName, repositoryName);
    }

    public String[] getRegisteredAttributeListForObject(String businessObjectName, String repositoryName)
        throws VSORBException
    {
        return _flddelegate.getRegisteredAttributeListForObject(businessObjectName, repositoryName);
    }

    public String[] getRegisteredFormListForApplication(String applicationName, String repositoryName)
        throws VSORBException
    {
        return _flddelegate.getRegisteredFormListForApplication(applicationName, repositoryName);
    }

    public String[] getRegisteredPageListForApplication(String applicationName, String repositoryName)
        throws VSORBException
    {
        return _flddelegate.getRegisteredPageListForApplication(applicationName, repositoryName);
    }

    public void deleteObjectAttribute(String attributeName, String businessObjectName, String repositoryName)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.deleteObjectAttribute(attributeName, businessObjectName, repositoryName);
    }

    public void deleteAppForm(String formName, String applicationName, String repositoryName)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.deleteAppForm(formName, applicationName, repositoryName);
    }

    public void deleteAppPage(String pageName, String applicationName, String repositoryName)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.deleteAppPage(pageName, applicationName, repositoryName);
    }

    public void setAppFormPrivilege(String appFormName, String applicationName, String repositoryName, String roleName, boolean execute)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.setAppFormPrivilege(appFormName, applicationName, repositoryName, roleName, execute);
    }

    public void setAppPagePrivilege(String appPageName, String applicationName, String repositoryName, String roleName, boolean execute)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.setAppPagePrivilege(appPageName, applicationName, repositoryName, roleName, execute);
    }

    public void setObjectAttributePrivilege(String attributeName, String businessObjectName, String repositoryName, String roleName, boolean edit, boolean view)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.setObjectAttributePrivilege(attributeName, businessObjectName, repositoryName, roleName, edit, view);
    }

    public void registerObjectAttribute(String attributeName, String businessObjectName, String repositoryName)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.registerObjectAttribute(attributeName, businessObjectName, repositoryName);
    }

    public void registerAppForm(String formName, String applicationName, String repositoryName)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.registerAppForm(formName, applicationName, repositoryName);
    }

    public void registerAppPage(String pageName, String applicationName, String repositoryName)
        throws VSORBException, ServerSecurityException
    {
        _flddelegate.registerAppPage(pageName, applicationName, repositoryName);
    }

    public VSORBSession getSession(String user, String password, String applicationName, String boPackageName)
        throws ServerSecurityException, MaxSessionExceededException, TierSessionLimitException
    {
        return appServer.getSession(user, password, applicationName, boPackageName);
    }

    public VSORBSession getSessionWithProps(SessionProperty props[])
        throws ServerSecurityException, MaxSessionExceededException, TierSessionLimitException
    {
        return appServer.getSessionWithProps(props);
    }

    public VSORBSession getSession1(byte sec[], String applicationName, String boPackageName)
        throws ServerSecurityException, MaxSessionExceededException, TierSessionLimitException
    {
        return appServer.getSession1(sec, applicationName, boPackageName);
    }

    public VSORBSecuritySession getSecuritySession(String user, String password, String applicationName)
        throws ServerSecurityException, MaxSessionExceededException, TierSessionLimitForSecurityException
    {
        return appServer.getSecuritySession(user, password, applicationName);
    }

    public byte[] getMetaQuery(String packageName, String componentName)
        throws VSORBException
    {
        return _flddelegate.getMetaQuery(packageName, componentName);
    }

    public boolean canUpdatePackage(String id)
    {
        return _flddelegate.canUpdatePackage(id);
    }

    public void setUpdatePackage(String id)
    {
        _flddelegate.setUpdatePackage(id);
    }

    public void setUpdatePackageForApp(String id)
    {
        _flddelegate.setUpdatePackageForApp(id);
    }

    public String getName()
    {
        return _flddelegate.getName();
    }

    public String getProductVersion()
    {
        return _flddelegate.getProductVersion();
    }

    public void refresh()
    {
        _flddelegate.refresh();
    }

    public void refreshRepoSecurityData()
    {
        _flddelegate.refreshRepoSecurityData();
    }

    public String getSecurityMetadataVersion()
    {
        return _flddelegate.getSecurityMetadataVersion();
    }

    public void pushSecurityDataWithLogin(byte sd[], int masterVersion, String login, String password)
        throws ServerSecurityException
    {
        _flddelegate.pushSecurityDataWithLogin(sd, masterVersion, login, password);
    }

    public String getDataServerProperty(String objectName, String property)
        throws ServerSecurityException
    {
        return _flddelegate.getDataServerProperty(objectName, property);
    }

    public Property[] getMyNonViewableColumnPrivileges(String objectName)
        throws VSORBException
    {
        return _flddelegate.getMyNonViewableColumnPrivileges(objectName);
    }

    public boolean getCoLocated()
    {
        return _flddelegate.getCoLocated();
    }

    public void setCoLocated(boolean c)
    {
        _flddelegate.setCoLocated(c);
    }

    public Property[] getDataServerProperties(String objectName)
    {
        return _flddelegate.getDataServerProperties(objectName);
    }

    public String executeCommand(String command)
        throws VSORBException
    {
        return _flddelegate.executeCommand(command);
    }

    private byte securityHolder[];
    private String packageName;
    private String applicationName;
    private String usr;
    private String pwd;
    private static final VersataLogger _LOGGER = VersataLogger.getLogger("com.versata.tl.vls.ejb.VLSContextBean");
    private static final String _RCS_HEADER = "$Header: //depot/main/products/brms/runtime/src/core/com/versata/tl/vls/ejb/VLSContextBean.java#2 $";
    private transient VSORBSecuritySessionOperations _flddelegate;
    private static transient VSORBAppServerImpl appServer;
    private transient int key;
    private SessionContext sessionContext;

    static 
    {
        VersataLogger.getRCSTraceLogger().trace("$Header: //depot/main/products/brms/runtime/src/core/com/versata/tl/vls/ejb/VLSContextBean.java#2 $");
        VLSSingleton.createSingleton();
        createVSORBAppServer();
    }
}
