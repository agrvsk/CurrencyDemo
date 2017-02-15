/*jadclipse*/// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.

package com.versata.tl.vls.service;

import com.versata.tl.api.exception.VersataRuntimeException;
import com.versata.tl.api.logging.VersataLogger;
import com.versata.tl.common.exception.*;
import com.versata.tl.common.util.SearchRequest;
import com.versata.tl.common.vlsobject.VSORBSessionOperations;
import com.versata.tl.common.vstrace.IVSTrace;
import com.versata.tl.common.vstrace.VSTrace;
import com.versata.tl.util.*;
import com.versata.tl.vls.admin.security.VSSecurityManager;
import com.versata.tl.vls.core.*;

import commonj.sdo.DataGraph;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import javax.ejb.EJBContext;
import javax.ejb.EJBException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.sdo.EDataGraph;

// Referenced classes of package com.versata.tl.vls.service:
//            ServiceException, ServerEnvironment, SessionListener

public class ServiceUtils {
	public static class StopTraceOnSessionClose implements SessionListener {

		public void beforeSessionClosed(Session session) {
			if (tr != null) {
				tr.set("Closing session for service. ID:", session);
				tr.end(id);
				tr.endControl();
			}
		}

		private long id;
		IVSTrace tr;

		public StopTraceOnSessionClose(IVSTrace tr, long id) {
			this.id = id;
			this.tr = tr;
		}
	}

	public ServiceUtils() {
	}

	public static void rethrowWrappedRuntimeException(VersataRuntimeException e)
			throws ServiceException {
		LOGGER.warn(e);
		throw new ServiceException(e.getMsgCode(), null, e);
	}

	public static VSORBSessionImpl getSessionForUser(String uid,
			String repositoryName) {
		if (LOGGER.isDebugEnabled())
			LOGGER.debug((new StringBuilder()).append(
					"Attempting to establish a session for user '").append(uid)
					.append('\'').toString());
		VSORBAppServerImpl server = ServerEnvironment.getServer();
		if (server == null)
			throw new EJBException(
					"Cannot locate TLE server - ServuceUtils.getAppServer() returned null");
		VSORBSessionImpl session = (VSORBSessionImpl) VSORBSessionImpl
				.getSessionForCurrentTransaction();
		if (session != null) {
			if (LOGGER.isDebugEnabled())
				LOGGER
						.debug((new StringBuilder())
								.append(
										"Found session that is already registered for this JTS tx ")
								.append(session).toString());
		} else {
			try {
				session = server.getSession(uid);
				session.setRepositoryName(repositoryName);
				if (VSTrace.IS_ON) {
					IVSTrace tr = null;
					long tr_id = 0L;
					tr = VSTrace.get();
					tr.begControl(LOGGER);
					tr.setControl("User", uid);
					tr.set("Created session for service. ID:", session);
					tr_id = tr.beg(LOGGER);
					StopTraceOnSessionClose listener = getStopTraceOnSessionClose(
							tr, tr_id);
					session.addSessionListener(listener);
				}
			} catch (ServerSecurityException e) {
				throw new EJBException(e.getMessage(), e);
			} catch (MaxSessionExceededException e) {
				throw new EJBException(e.getMessage(), e);
			} catch (TierSessionLimitException e) {
				throw new EJBException(e.getMessage(), e);
			}
			VSORBSessionImpl.registerSessionForCurrentTransaction(session);
			if (LOGGER.isDebugEnabled())
				LOGGER.debug((new StringBuilder()).append(
						"Created new session for this JTA tx ").append(session)
						.toString());
		}
		return session;
	}

	public static void closeSession(Session session) {
		if (session != null)
			session.close();
	}

	public static VSORBSessionImpl getNewSession(String uid, String password,			String repositoryName, String clientAppName)
			throws ServerSecurityException, MaxSessionExceededException,			TierSessionLimitException 
			{
		if (LOGGER.isDebugEnabled())
			LOGGER.debug((new StringBuilder()).append(
					"Attempting to establish a session for user '").append(uid)
					.append('\'').toString());
		VSORBAppServerImpl server = ServerEnvironment.getServer();
		if (server == null)
			throw new EJBException(
					"Cannot locate TLE server - ServiceUtils.getAppServer() returned null");
		VSORBSessionImpl session = null;
		try {
			// VSORBSessionOperations getSessionWithPropsInternal(Properties props)
			// VSORBSessionImpl getSession1InternalEJB(byte secHolder[], String clientAppName, String boPackageName, EJBContext ejbContext)
			// VSORBSessionImpl getAuthenticatedSessionInternal(String boPackageName, EJBContext ejbContext)
			// VSORBSessionImpl getSession(String user) 
			// VSORBSessionImpl getSessionInternal(String user, String password, String clientAppName, String projectName, VSSecurityManager secMgr, boolean coLocated, boolean internalSession, boolean securitySession)
			// VSORBSessionImpl getSessionInternal(String user, String password, String clientAppName, String boPackageName, VSSecurityManager secmgr)
			//
			session = server.getSessionInternal(uid, password, clientAppName, repositoryName, true, false, false);
			session.setRepositoryName(repositoryName);
			if (VSTrace.IS_ON) {
				IVSTrace tr = null;
				long tr_id = 0L;
				tr = VSTrace.get();
				tr.begControl(LOGGER);
				tr.setControl("User", uid);
				tr.set("Created session. ID:", session);
				tr_id = tr.beg(LOGGER);
				StopTraceOnSessionClose listener = getStopTraceOnSessionClose(
						tr, tr_id);
				session.addSessionListener(listener);
			}
		} catch (ServerSecurityException e) {
			throw new EJBException(e.getMessage(), e);
		} catch (MaxSessionExceededException e) {
			throw new EJBException(e.getMessage(), e);
		} catch (TierSessionLimitException e) {
			throw new EJBException(e.getMessage(), e);
		}
		VSORBSessionImpl.registerSessionForCurrentTransaction(session);
		if (LOGGER.isDebugEnabled())
			LOGGER.debug((new StringBuilder()).append(
					"Created new session for this JTA tx ").append(session)
					.toString());
		return session;
	}

	public static String dataGraphAsXML(DataGraph sdoDataGraph)
    {
        EDataGraph eDataGraph;
        HashMap options;
        ByteArrayOutputStream bos;
        if(!(sdoDataGraph instanceof EDataGraph))
            throw new IllegalArgumentException((new StringBuilder()).append("Can't convert a ").append(sdoDataGraph.getClass().getName()).append(" to xml. The concrete class of the DataGraph need to be EDataGraph or a subclass").toString());
        eDataGraph = (EDataGraph)sdoDataGraph;
        options = new HashMap();
        options.put("DECLARE_XML", Boolean.FALSE);
        bos = null;
        try
        {
            bos = new ByteArrayOutputStream();
            eDataGraph.getDataGraphResource().save(bos, options);
        }
        catch(IOException e)
        {
            throw new RuntimeException(e);
        }
//
//        StreamUtils.closeStream(bos);
//        break MISSING_BLOCK_LABEL_119;
//        Exception exception;
//        exception;
//        StreamUtils.closeStream(bos);
//        throw exception;
        String theXML = bos.toString();
        return theXML;
    }

	public static StopTraceOnSessionClose getStopTraceOnSessionClose(
			IVSTrace tr, long id) {
		return new StopTraceOnSessionClose(tr, id);
	}

	public static Enumeration createSearchRequestAndGetResult(Session session,
			String dataObjectName, String codeAttributeName,
			String valueAttributeName) {
		SearchRequest searchReq = new SearchRequest();
		String pkgName = VSRepositoryMetaCache.get(session.getRepositoryName())
				.getPackageName(dataObjectName);
		String fullClassName = getFullImplClassName(pkgName, dataObjectName);
		try {
			Class boImpl = localClassCache.getClass(fullClassName);
			Class paramterTypes[] = {
					com.versata.tl.common.util.SearchRequest.class,
					com.versata.tl.vls.core.Session.class };
			Object paramters[] = { searchReq, session };
			Method boImplMethod = MethodsCache.getMethod(boImpl, "getObjects",
					paramterTypes);
			boImplMethod.setAccessible(true);
			Enumeration objs = (Enumeration) boImplMethod.invoke(null,
					paramters);
			return objs;
		} catch (ClassNotFoundException e) {
			LOGGER.error(e);
			throw new ServerException(
					"Exception while trying to retrieve objects for enumeration");
		} catch (SecurityException e) {
			LOGGER.error(e);
			throw new ServerException(
					"Exception while trying to retrieve objects for enumeration");
		} catch (NoSuchMethodException e) {
			LOGGER.error(e);
			throw new ServerException(
					"Exception while trying to retrieve objects for enumeration");
		} catch (IllegalArgumentException e) {
			LOGGER.error(e);
			throw new ServerException(
					"Exception while trying to retrieve objects for enumeration");
		} catch (IllegalAccessException e) {
			LOGGER.error(e);
			throw new ServerException(
					"Exception while trying to retrieve objects for enumeration");
		} catch (InvocationTargetException e) {
			LOGGER.error(e);
		}
		throw new ServerException(
				"Exception while trying to retrieve objects for enumeration");
	}

	private static String getFullImplClassName(String pkgName, String boName) {
		return (new StringBuilder()).append(pkgName).append(".").append(boName)
				.append("BaseImpl").toString();
	}

	public static String convertFirstCharToUpperCase(String inputString) {
		if (inputString == null) {
			return inputString;
		} else {
			char firstVal = inputString.charAt(0);
			char firstCharOutput = Character.toUpperCase(firstVal);
			return (new StringBuilder()).append(firstCharOutput).append(
					inputString.substring(1)).toString();
		}
	}

	public static Object getColumnValueFromDataObject(Object singleDORow,
			String codeAttributeName) {
		try {
			Method getterMethod = MethodsCache
					.getMethod(singleDORow.getClass(),
							(new StringBuilder()).append("get").append(
									codeAttributeName).toString(), new Class[0]);
			Object resultCode = getterMethod.invoke(singleDORow, new Object[0]);
			return resultCode;
		} catch (SecurityException e) {
			LOGGER.error(e);
			throw new ServerException(
					"Exception while trying to retrieve value of getter from DataObjectRow");
		} catch (NoSuchMethodException e) {
			LOGGER.error(e);
			throw new ServerException(
					"Exception while trying to retrieve value of getter from DataObjectRow");
		} catch (IllegalArgumentException e) {
			LOGGER.error(e);
			throw new ServerException(
					"Exception while trying to retrieve value of getter from DataObjectRow");
		} catch (IllegalAccessException e) {
			LOGGER.error(e);
			throw new ServerException(
					"Exception while trying to retrieve value of getter from DataObjectRow");
		} catch (InvocationTargetException e) {
			LOGGER.error(e);
		}
		throw new ServerException(
				"Exception while trying to retrieve value of getter from DataObjectRow");
	}

	public static String convertFirstCharToLowerCase(String inputString) {
		if (inputString == null || inputString.equals("")) {
			return inputString;
		} else {
			char firstVal = inputString.charAt(0);
			char firstCharOutput = Character.toLowerCase(firstVal);
			return (new StringBuilder()).append(firstCharOutput).append(
					inputString.substring(1)).toString();
		}
	}

	private static final VersataLogger LOGGER = VersataLogger.getLogger(com.versata.tl.vls.service.ServiceUtils.class);
	private static final ServiceUtils INSTANCE = new ServiceUtils();
	private static final ClassCache localClassCache = new ClassCache();

}


/*
	DECOMPILATION REPORT

	Decompiled from: C:\Versata\BRMS-2016\jboss71\VLS\lib\vs-tle-server.jar
	Total time: 31 ms
	Jad reported messages/errors:
Overlapped try statements detected. Not all exception handlers will be resolved in the method dataGraphAsXML
Couldn't fully decompile method dataGraphAsXML
Couldn't resolve all exception handlers in method dataGraphAsXML
	Exit status: 0
	Caught exceptions:
*/