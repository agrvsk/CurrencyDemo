/*jadclipse*/// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.

package com.versata.tl.vls.core;

import com.versata.tl.api.logging.VersataLogger;
import com.versata.tl.common.SessionProperty;
import com.versata.tl.common.exception.*;
import com.versata.tl.common.meta.MetaQueryManager;
import com.versata.tl.common.meta.VSQueryDefinition;
import com.versata.tl.common.security.*;
import com.versata.tl.common.text.AdminMsgCode;
import com.versata.tl.common.text.RuntimeMsgCode;
import com.versata.tl.common.util.StringUtils;
import com.versata.tl.common.util.Util;
import com.versata.tl.common.vlsobject.*;
import com.versata.tl.util.*;
import com.versata.tl.vls.admin.*;
import com.versata.tl.vls.admin.security.*;
import com.versata.tl.vls.ejb.EJBUtil;
import com.versata.tl.vls.service.ServerEnvironment;
import com.versata.tl.vls.service.VLSInitializer;
import java.lang.reflect.Method;
import java.security.Principal;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import javax.ejb.EJBContext;

// Referenced classes of package com.versata.tl.vls.core:
//            VSORBAppServerImpl_ejb, VSORBSessionImpl, ComponentLoader, VSEJBSecurityManager, 
//            VLSSingleton, Data, ServerEnvironment_Base, BusinessObjectImpl

public class VSORBAppServerImpl extends VSORBAppServerImpl_ejb {

	protected VSORBAppServerImpl() {
		isAllowRefreshSecurityData = false;
	}

	public VSORBAppServerImpl(String name) {
		super(name);
		isAllowRefreshSecurityData = false;
		appServerName = name;
		createInternalSession();
		loadDeploymentData();
	}

	public VSORBAppServerImpl(String name, boolean isLoadcomponents) {
		super(name);
		isAllowRefreshSecurityData = false;
		appServerName = name;
		createInternalSession();
		if (isLoadcomponents)
			loadDeploymentData();
	}

	private void createInternalSession() {
		if (bundle == null)
			bundle = VLSResourcesProps.getInstance();
		try {
			if (paramList == null)
				loadServerProperties();
			checkSecurity = Boolean.valueOf(
					getProperty("CheckObjectSecurity", "TRUE")).booleanValue();
			try {
				String mode = getProperty("ROUND_MODE");
				if (mode != null)
					Data.round_mode = Integer.parseInt(mode);
				internalSession = new VSORBSessionImpl(this, "Admin", "",
						"VersataInternal", true, "com.versata.tl.vls.admin",
						true);
			} catch (NumberFormatException e) {
				_LOGGER.error(e);
			} catch (ServerSecurityException e) {
				_LOGGER.error(e);
			}
			evalInitScripts();
			runExternalServerInitializers((new StringBuilder()).append(
					System.getProperty("VLS_INIT_CLASSES", "")).append(
					getProperty("VLS_INIT_CLASSES", "")).toString());
			if (_LOGGER.isDebugEnabled())
				logConfiguration();
		} catch (Throwable t) {
			_LOGGER.error(t);
		}
		setProperties(paramList);
	}

	public void loadDeploymentData() {
		try {
			if (SecurityDigesterFactory.getInstance().isXMLPersistence()) {
				String adminPath = ServerEnvironment.getAdminPath();
				loadExistingAdminData(adminPath);
				ComponentLoader loader = new ComponentLoader(this);
				checkForBootStrapOrUpgrade(loader);
				loader.loadComponentFiles(adminPath, ".VJDeploy", true);
				loader.loadDeploymentData();
			}
		} catch (Exception e) {
			AppSrvSecXDAConnector.setErrorsAtStartup(true);
			_LOGGER.warn(RuntimeMsgCode.VSORBAPPSERVERIMPL911);
		}
		isAllowRefreshSecurityData = true;
	}

	private void runExternalServerInitializers(String classNames) {
		List tokens = StringUtils.tokenize(classNames, ';', false);
		for (Iterator it = tokens.iterator(); it.hasNext();) {
			String name = (String) it.next();
			try {
				((VLSInitializer) localClassCache.getClass(name).newInstance())
						.execute(this);
			} catch (Exception e) {
				Util.logError(_LOGGER, (new StringBuilder()).append(
						"Could not run specified VLSInitializer class: ")
						.append(name).append(':').append(e).toString());
			}
		}

	}

	public void snapShotDSP() {
		super.snapShotDSP();
	}

	public static int getDynamicConfigReloadTime() {
		return DYNAMIC_CONFIG_RELOAD_TIME;
	}

	public static void resetOldLogManager() {
		VLSSingleton singleton = VLSSingleton.getSingleton();
		Hashtable earHash = singleton.getHashtableForEar(VLSConfigProps
				.getInstance().getProperty("project.name"));
		Object old = earHash.get("ear_logManager");
		if (old != null)
			try {
				Method method = MethodsCache.getMethod(old.getClass(), "reset",
						new Class[0]);
				method.invoke(old, new Object[0]);
			} catch (Exception e) {
				_LOGGER.error(e);
			}
	}

	public static void setDynamicConfigReloadTime(int time) {
		DYNAMIC_CONFIG_RELOAD_TIME = time;
	}

	public void setProperties(Properties p) {
		EJBUtil.setAppServerName();
		if (p.getProperty("MaxSession") != null)
			maxSession = Integer.parseInt(p.getProperty("MaxSession"));
		localHost = Util.getLocalHostName();
		mainHost = p.getProperty("mainHost", localHost);
		serverName = p.getProperty("AppServerName");
	}

	private void checkForBootStrapOrUpgrade(ComponentLoader cl)
			throws Exception {
		if (AppUserImpl.getObjectCount(null, internalSession) > 0) {
			String securityMetadataVersion = AppSrvSecXDAConnector
					.getDataStoreMetadataVersion();
			int result = securityMetadataVersion
					.compareTo(getSecurityMetadataVersion());
			if (result > 0) {
				if (_LOGGER.isDebugEnabled())
					_LOGGER.debug(RuntimeMsgCode.VSORBAPPSERVERIMPL910,
							new Object[] { securityMetadataVersion,
									getSecurityMetadataVersion() });
				System.exit(-1);
			}
			if (result < 0)
				AppSrvSecUpgradeUtility.upgradeSecurityData(this,
						securityMetadataVersion);
		} else {
			cl.loadComponentFile(ServerEnvironment.getBinPath(),
					"Bootstrap.VJDeploy", false);
		}
	}

	private void loadExistingAdminData(String adminPath) throws Exception {
		if (SecurityDigesterFactory.getInstance().isXMLPersistence()) {
			util = new AdminDataUtility();
			util.setAdminLocation(adminPath);
			util.copySchemas();
			if (util.hasLatestAdminData()) {
				if (_LOGGER.isDebugEnabled())
					_LOGGER.debug((new StringBuilder()).append(
							"Loading the xml admin data from ").append(
							adminPath).toString());
				AppSrvSecXDAConnector.loadAllSecurityData(adminPath);
			} else {
				if (_LOGGER.isDebugEnabled())
					_LOGGER
							.debug("Found a new version of xml admin data in the EAR.");
				if (!loadFromXML()) {
					if (_LOGGER.isDebugEnabled())
						_LOGGER.debug((new StringBuilder()).append(
								"Loading admin data from ").append(adminPath)
								.toString());
					if (AppSrvSecXDAConnector.getDataStores() != null)
						AppSrvSecXDAConnector.getDataStores().clear();
					if (AppSrvSecXDAConnector.indexStores != null)
						AppSrvSecXDAConnector.indexStores.clear();
					if (AppSrvSecXDAConnector.writerIndexStores != null)
						AppSrvSecXDAConnector.writerIndexStores.clear();
					AppSrvSecXDAConnector.loadAllSecurityData(adminPath);
				}
			}
		} else if (!ServerEnvironment_Base.isAdminDataInDB()
				&& !ServerEnvironment_Base.isUseCustomXDAForAdminData()) {
			if (_LOGGER.isDebugEnabled())
				_LOGGER.debug((new StringBuilder()).append(
						"Loading admin data from ").append(adminPath)
						.toString());
			AppSrvSecXDAConnector.loadAllSecurityData(adminPath);
		}
	}

	public void refreshSecurityData() {
		try {
			if (_LOGGER.isDebugEnabled())
				_LOGGER.debug((new StringBuilder()).append(
						"VSORBAppServerImpl.refreshSecurityData with ").append(
						ServerEnvironment.getAdminPath()).append(".VJDeploy")
						.toString());
			if (isAllowRefreshSecurityData) {
				ComponentLoader cl = new ComponentLoader(this);
				cl.loadComponentFiles(ServerEnvironment.getAdminPath(),
						".VJDeploy", true);
				cl.loadDeploymentData();
			}
		} catch (Exception e) {
			_LOGGER.warn(RuntimeMsgCode.VSORBAPPSERVERIMPL911, null, e);
		}
	}

	public void refreshRepoSecurityData() {
		try {
			ComponentLoader cl = new ComponentLoader(this);
			cl.loadDeploymentDataIntoDatabase();
		} catch (Exception e) {
			_LOGGER.warn(RuntimeMsgCode.VSORBAPPSERVERIMPL911, null, e);
		}
	}

	private boolean loadFromXML() {
		boolean success;
		try {
			if (_LOGGER.isDebugEnabled())
				_LOGGER.debug("Creating backup files for the old admin data.");
			util.deleteBackupFiles();
			util.createBackupFiles();
			util.deleteAdminFiles();
			AppSrvSecXDAConnector adminXDA = new AppSrvSecXDAConnector();
			adminXDA.initializeAdminFiles();
			if (_LOGGER.isDebugEnabled())
				_LOGGER.debug("Loading new version of admin data from EAR.");
			ComponentLoader compLoader = new ComponentLoader(this);
			compLoader.loadAdminData();
			success = true;
		} catch (Exception e) {
			if (_LOGGER.isDebugEnabled())
				_LOGGER.debug("Restoring backup files.");
			util.restoreBackupFiles();
			_LOGGER.warn(e);
			success = false;
		}
		util.deleteBackupFiles();
		return success;
	}

	public VSORBSessionOperations getSessionWithPropsInternal(
			SessionProperty propArray[]) throws ServerSecurityException,
			MaxSessionExceededException, TierSessionLimitException {
		return getSessionWithPropsInternal(Util.convertToJavaProps(propArray));
	}

	public VSORBSessionOperations getSessionWithPropsInternal(Properties props)
			throws ServerSecurityException, MaxSessionExceededException,
			TierSessionLimitException {
		String clientAppName = (String) props.get("clientAppName");
		String deployedProjectName = (String) props.get("packageName");
		Boolean c = (Boolean) props.get("coLocated");
		boolean coLocated = c != null && c.booleanValue();
		Boolean sec = (Boolean) props.get("isSecurity");
		boolean securitySession = sec != null && sec.booleanValue();
		byte secHolder[] = (byte[]) (byte[]) props.get("securityHolder");
		VSORBSessionImpl aSession;
		try {
			if (secHolder == null) {
				String user = (String) props.get("user");
				String password = (String) props.get("password");
				aSession = getSessionInternal(user, password, clientAppName,
						deployedProjectName, coLocated, false, securitySession);
			} else {
				String secMgrClass = getProperty("VLS_SecurityManager",
						"com.versata.tl.vls.admin.security.VSDefaultSecurityManager");
				VSSecurityManager secmgr = getSecurityObject(secHolder,
						secMgrClass);
				if (secmgr instanceof VSEJBSecurityManager) {
					EJBContext ejbContext = (EJBContext) props
							.get("EJBContext");
					if (ejbContext != null)
						((VSEJBSecurityManager) secmgr)
								.setEJBContext(ejbContext);
				}
				if (secmgr.externalAuthentication())
					aSession = getSessionInternal(secmgr.getRoles(), secmgr
							.getLogin(), secmgr.getPassword(), clientAppName,
							deployedProjectName, secmgr, false, securitySession);
				else
					aSession = getSessionInternal(secmgr.getLogin(), secmgr
							.getPassword(), clientAppName, deployedProjectName,
							secmgr, coLocated, false, securitySession);
				if (aSession != null)
					aSession.setSecurityManager(secmgr);
			}
		} catch (ServerSecurityException sex) {
			throw sex;
		} catch (MaxSessionExceededException mse) {
			throw mse;
		} catch (TierSessionLimitException tle) {
			throw tle;
		} catch (Exception e) {
			throw new ServerSecurityException(
					RuntimeMsgCode.VSORBAPPSERVERIMPL904, null, e);
		}
		return aSession;
	}

	public VSORBSessionImpl getSession1Internal(byte secHolder[],
			String clientAppName, String boPackageName)
			throws ServerSecurityException, MaxSessionExceededException,
			TierSessionLimitException {
		return getSession1InternalEJB(secHolder, clientAppName, boPackageName,
				null);
	}

	public VSORBSessionImpl getSession1InternalEJB(byte secHolder[],
			String clientAppName, String boPackageName, EJBContext ejbContext)
			throws ServerSecurityException, MaxSessionExceededException,
			TierSessionLimitException {
		try {
			String secMgrClass = getProperty("VLS_SecurityManager",
					"com.versata.tl.vls.admin.security.VSDefaultSecurityManager");
			VSSecurityManager secmgr = getSecurityObject(secHolder, secMgrClass);
			if (secmgr instanceof VSEJBSecurityManager)
				((VSEJBSecurityManager) secmgr).setEJBContext(ejbContext);
			VSORBSessionImpl aSession;
			if (secmgr.externalAuthentication())
				aSession = getSessionInternal(secmgr.getRoles(), secmgr
						.getLogin(), secmgr.getPassword(), clientAppName,
						boPackageName, secmgr);
			else
				aSession = getSessionInternal(secmgr.getLogin(), secmgr
						.getPassword(), clientAppName, boPackageName);
			if (aSession != null)
				aSession.setSecurityManager(secmgr);
			return aSession;
		} catch (ServerSecurityException sex) {
			throw sex;
		} catch (MaxSessionExceededException mse) {
			throw mse;
		} catch (TierSessionLimitException tle) {
			throw tle;
		} catch (Exception e) {
			throw new ServerSecurityException(
					RuntimeMsgCode.VSORBAPPSERVERIMPL904, e.getMessage());
		}
	}

	private VSSecurityManager getSecurityObject(byte secHolder[],
			String secMgrClass) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		VSSecurityObjectHolder secH = (VSSecurityObjectHolder) SerializationUtil
				.deserializeFromByteArray(secHolder, com.versata.tl.common.security.VSSecurityObjectHolder.class);
		VSSecurityManager secmgr = (VSSecurityManager) localClassCache
				.getClass(secMgrClass).newInstance();
		secmgr.setSecurityObject(secH.getSecurityObject());
		return secmgr;
	}

	public VSORBSessionImpl getAuthenticatedSessionInternal(
			String boPackageName, EJBContext ejbContext)
			throws ServerSecurityException, MaxSessionExceededException,
			TierSessionLimitException {
		String secMgrClass = getProperty("VLS_SecurityManager",
				"com.versata.tl.vls.admin.security.VSDefaultSecurityManager");
		VSSecurityManager secmgr;
		VSORBSessionImpl aSession;
		try {
			secmgr = (VSSecurityManager) localClassCache.getClass(secMgrClass)
					.newInstance();
			if (!secmgr.externalAuthentication())
				return getSessionInternal("sa", "", null, boPackageName, true,
						true, false);
		} catch (ServerSecurityException sex) {
			throw sex;
		} catch (MaxSessionExceededException mse) {
			throw mse;
		} catch (TierSessionLimitException tle) {
			throw tle;
		} catch (Exception e) {
			throw new ServerSecurityException(
					RuntimeMsgCode.VSORBAPPSERVERIMPL904, null, e);
		}
		secmgr.setSecurityObject(null);
		if ((secmgr instanceof VSEJBSecurityManager) && ejbContext != null) {
			secmgr.setSecurityObject(new VSSecurityObjectImpl(ejbContext
					.getCallerPrincipal().getName(), ""));
			((VSEJBSecurityManager) secmgr).setEJBContext(ejbContext);
		}
		aSession = getSessionInternal(secmgr.getRoles(), secmgr.getLogin(),
				secmgr.getPassword(), null, boPackageName);
		aSession.setSecurityManager(secmgr);
		return aSession;
	}

	public void setUpdatePackage(String id) {
		MetaQueryManager.metaQueryCache.clear();
		BusinessObjectImpl.refreshMetaQueryList();
		VSQueryDefinition.refreshMetaQueryColumns();
	}

	public final VSORBSessionImpl createSession(String user, String password,
			String clientAppName, String projectName)
			throws ServerSecurityException {
		beforeSessionCreate(user, password, clientAppName, projectName);
		validateConnection();
		return new VSORBSessionImpl(this, user, password, clientAppName, false,
				projectName, false);
	}

	protected final VSORBSession getSession(String user, String password,
			String clientAppName, String projectName, boolean coLocated,
			VSSecurityManager secmgr) throws ServerSecurityException,
			MaxSessionExceededException, TierSessionLimitException {
		VSORBSessionImpl aSession = createSession(user, password,
				clientAppName, projectName);
		if (secmgr != null)
			aSession.setSecurityManager(secmgr);
		aSession.setCoLocated(coLocated);
		VSORBSession remoteSession;
		if (coLocated)
			remoteSession = aSession.getLocalReferenceForSecuritySession();
		else
			remoteSession = aSession.getRemoteReferenceForSecuritySession();
		initializeTrace(aSession);
		sessions.put(aSession, remoteSession);
		afterSessionCreate(aSession);
		if (_LOGGER.isDebugEnabled())
			_LOGGER.debug(RuntimeMsgCode.VSORBAPPSERVERIMPL906, user);
		return remoteSession;
	}

	public VSORBSessionImpl getSessionInternal(String user, String password, String clientAppName, String projectName, VSSecurityManager secMgr, boolean coLocated, boolean internalSession, boolean securitySession)
			throws ServerSecurityException, TierSessionLimitException {
		beforeSessionCreate(user, password, clientAppName, projectName);
		validateConnection();
		VSORBSessionImpl aSession = new VSORBSessionImpl(this, user, password,
				clientAppName, internalSession, projectName, securitySession);
		aSession.setCoLocated(coLocated);
		aSession.setSecurityManager(secMgr);
		initializeTrace(aSession);
		afterSessionCreate(aSession);
		if (_LOGGER.isDebugEnabled())
			_LOGGER.debug(RuntimeMsgCode.VSORBAPPSERVERIMPL906);
		return aSession;
	}

	public VSORBSessionImpl getSession(String user)
			throws ServerSecurityException, MaxSessionExceededException {
		VSORBSessionImpl aSession;
		try {
			beforeSessionCreate(user, null, null, null);
			validateConnection();
			if (secMgrClass == null) {
				String secMgrClassName = getProperty("VLS_SecurityManager",
						"com.versata.tl.vls.admin.security.VSDefaultSecurityManager");
				secMgrClass = localClassCache.getClass(secMgrClassName);
			}
			VSSecurityManager secmgr = (VSSecurityManager) secMgrClass
					.newInstance();
 			VSMapSecurityInfo securityObject = new VSSecurityObjectImpl(user,
					"");
			if (secmgr.externalAuthentication()) {
				if (secmgr instanceof VSSecurityManagerWithoutAuth)
					((VSSecurityManagerWithoutAuth) secmgr)
							.setSecurityObjectWithOutAuth(securityObject);
				else
					throw new ServerSecurityException(
							AdminMsgCode.REMOTE_METHOD_SECURITYMANAGER_EXCEPTION);
				aSession = new VSORBSessionImpl(this, secmgr.getRoles(), user,
						false, false);
			} else {
				secmgr.setSecurityObject(securityObject);
				aSession = new VSORBSessionImpl(this, user, false, false);
			}
			aSession.setSecurityManager(secmgr);
			aSession.setCoLocated(true);
			afterSessionCreate(aSession);
			initializeTrace(aSession);
			if (_LOGGER.isDebugEnabled())
				_LOGGER.debug(RuntimeMsgCode.VSORBAPPSERVERIMPL906, user);
		} catch (ServerSecurityException e) {
			throw e;
		} catch (MaxSessionExceededException e) {
			throw e;
		} catch (Exception e) {
			throw new ServerSecurityException(AdminMsgCode.SECURITY_EXCEPTION,
					e);
		}
		return aSession;
	}

	public VSORBSessionImpl getSessionInternal(String user, String password, String clientAppName, String projectName, boolean coLocated, boolean internalSession, boolean securitySession)
			throws ServerSecurityException, MaxSessionExceededException,
			TierSessionLimitException {
		beforeSessionCreate(user, password, clientAppName, projectName);
		validateConnection();
		VSORBSessionImpl aSession = new VSORBSessionImpl(this, user, password,
				clientAppName, internalSession, projectName, securitySession);
		aSession.setCoLocated(coLocated);
		initializeTrace(aSession);
		afterSessionCreate(aSession);
		if (_LOGGER.isDebugEnabled())
			_LOGGER.debug(RuntimeMsgCode.VSORBAPPSERVERIMPL906, user);
		return aSession;
	}

	protected final VSORBSession getSession(Vector roleList, String user,
			String password, String clientAppName, String projectName,
			VSSecurityManager secmgr) throws ServerSecurityException,
			MaxSessionExceededException, TierSessionLimitException {
		beforeSessionCreate(user, password, clientAppName, projectName);
		validateConnection();
		VSORBSessionImpl aSession = new VSORBSessionImpl(this, roleList, user,
				password, clientAppName, false, projectName, false);
		aSession.setSecurityManager(secmgr);
		VSORBSession remoteSession = aSession
				.getRemoteReferenceForSecuritySession();
		initializeTrace(aSession);
		sessions.put(aSession, remoteSession);
		afterSessionCreate(aSession);
		if (_LOGGER.isDebugEnabled())
			_LOGGER.debug(RuntimeMsgCode.VSORBAPPSERVERIMPL906, user);
		return remoteSession;
	}

	protected VSORBSessionImpl getSessionInternal(Vector roleList, String user,
			String password, String clientAppName, String boPackageName,
			boolean internalSession, boolean securitySession)
			throws ServerSecurityException, MaxSessionExceededException,
			TierSessionLimitException {
		beforeSessionCreate(user, password, clientAppName, boPackageName);
		validateConnection();
		VSORBSessionImpl aSession = new VSORBSessionImpl(this, roleList, user,
				password, clientAppName, internalSession, boPackageName,
				securitySession);
		initializeTrace(aSession);
		afterSessionCreate(aSession);
		if (_LOGGER.isDebugEnabled())
			_LOGGER.debug(RuntimeMsgCode.VSORBAPPSERVERIMPL906, user);
		return aSession;
	}

	public VSORBSecuritySession getSecuritySession(String user,
			String password, String clientAppName)
			throws ServerSecurityException, MaxSessionExceededException,
			TierSessionLimitForSecurityException {
		VSORBSessionImpl aSession = new VSORBSessionImpl(this, user, password,
				clientAppName, false, "com.versata.tl.vls.admin", true);
		VSORBSecuritySession remoteSession = aSession
				.getRemoteReferenceForSecuritySession();
		initializeTrace(aSession);
		sessions.put(aSession, remoteSession);
		if (_LOGGER.isDebugEnabled())
			_LOGGER.debug(RuntimeMsgCode.VSORBAPPSERVERIMPL909, user);
		return remoteSession;
	}

	VSORBSessionImpl getSessionInternal(Vector roleList, String user,
			String password, String clientAppName, String projectName,
			VSSecurityManager secMgr, boolean internalSession,
			boolean securitySession) throws ServerSecurityException,
			TierSessionLimitException {
		beforeSessionCreate(user, password, clientAppName, projectName);
		validateConnection();
		VSORBSessionImpl aSession = new VSORBSessionImpl(this, roleList, user,
				password, clientAppName, internalSession, projectName,
				securitySession);
		aSession.setSecurityManager(secMgr);
		initializeTrace(aSession);
		afterSessionCreate(aSession);
		if (_LOGGER.isDebugEnabled())
			_LOGGER.debug(RuntimeMsgCode.VSORBAPPSERVERIMPL906, user);
		return aSession;
	}

	public VSORBSessionImpl getSessionInternal(String user, String password,
			String clientAppName, String boPackageName, VSSecurityManager secmgr)
			throws ServerSecurityException, TierSessionLimitException {
		beforeSessionCreate(user, password, clientAppName, boPackageName);
		validateConnection();
		VSORBSessionImpl aSession = new VSORBSessionImpl(this, user, password,
				clientAppName, false, boPackageName, false);
		aSession.setSecurityManager(secmgr);
		initializeTrace(aSession);
		afterSessionCreate(aSession);
		return aSession;
	}

	public VSORBSessionImpl getSecuritySessionInternal(String user,
			String password, String clientAppName)
			throws ServerSecurityException, MaxSessionExceededException,
			TierSessionLimitForSecurityException {
		VSORBSessionImpl aSession = new VSORBSessionImpl(this, user, password,
				clientAppName, false, "com.versata.tl.vls.admin", true);
		initializeTrace(aSession);
		if (_LOGGER.isDebugEnabled())
			_LOGGER.debug(RuntimeMsgCode.VSORBAPPSERVERIMPL909, user);
		return aSession;
	}

	private static final VersataLogger _LOGGER = VersataLogger.getLogger(com.versata.tl.vls.core.VSORBAppServerImpl.class);
	private static final String _RCS_HEADER = "$Header: //depot/main/products/brms/runtime/src/core/com/versata/tl/vls/core/VSORBAppServerImpl.java#2 $";
	private static final ClassCache localClassCache = new ClassCache();
	private AdminDataUtility util;
	private static final String ADMIN_PACKAGE = "com.versata.tl.vls.admin";
	private static final String DEFAULT_SECURITY_MANAGER = "com.versata.tl.vls.admin.security.VSDefaultSecurityManager";
	private boolean isAllowRefreshSecurityData;
	private static Class secMgrClass;

	static {
		VersataLogger
				.getRCSTraceLogger()
				.trace(
						"$Header: //depot/main/products/brms/runtime/src/core/com/versata/tl/vls/core/VSORBAppServerImpl.java#2 $");
	}
}


/*
	DECOMPILATION REPORT

	Decompiled from: C:\Versata\BRMS-2016\jboss71\VLS\lib\vs-tle-server.jar
	Total time: 32 ms
	Jad reported messages/errors:
Couldn't resolve all exception handlers in method getAuthenticatedSessionInternal
	Exit status: 0
	Caught exceptions:
*/