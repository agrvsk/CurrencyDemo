package com.versata.tl.vls.core;

import com.versata.tl.api.itext.MessageLocalizer;
import com.versata.tl.api.logging.VersataLogger;
import com.versata.tl.common.exception.ServerSecurityException;
import com.versata.tl.common.exception.ServerException;
import com.versata.tl.common.text.RuntimeMsgCode;
import com.versata.tl.common.transaction.NoTransactionException;
import com.versata.tl.common.util.Parameter;
import com.versata.tl.common.util.SearchRequest;
import com.versata.tl.common.vlsobject.VSORBSecuritySession;
import com.versata.tl.common.vlsobject.VSORBSession;
import com.versata.tl.vls.admin.AppRoleImpl;
import com.versata.tl.vls.admin.AppUserImpl;
import com.versata.tl.vls.admin.AppUserRoleImpl;
import com.versata.tl.vls.service.ServerEnvironment;
import com.versata.tl.vls.service.SessionListener;
import com.versata.tl.common.text.AdminMsgCode;
import com.versata.tl.vls.transaction.CurrentTransaction;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

import javax.transaction.Transaction;

/**
 * @internal.tle This class represents a session with the Versata Logic Server for each client login.
 * @see com.versata.tl.common.vlsobject.VSORBSession
 * @see Session
 *      <p/>
 *      Whenever possible, please use an interface to access methods in this class.
 */
public class VSORBSessionImpl extends VSORBSessionImpl_Common {
	static public final String _RCS_HEADER = "$Header: //depot/main/products/brms/runtime/src/core/com/versata/tl/vls/core/VSORBSessionImpl.java#2 $";
	private static final VersataLogger _DIAGNOSTICLOGGER=ServerEnvironment.getServer().getConnectionSnapshotLogger();
	static {
		VersataLogger.getRCSTraceLogger().trace(_RCS_HEADER);
	}

	/**
	 * Constructor for VSORBSessionImpl.
     *
	 * @param p_AppServer VSORBAppServerImpl
	 * @param p_userName String
	 * @param p_securitySession boolean
	 * @param internalSession boolean
	 * @throws ServerSecurityException
	 */
	public VSORBSessionImpl(VSORBAppServerImpl p_AppServer, String p_userName, boolean p_securitySession, boolean internalSession)
	    throws ServerSecurityException {
		super(p_AppServer, p_userName, p_securitySession, internalSession);
		if ( _DIAGNOSTICLOGGER.isDebugEnabled() ) {
			_DIAGNOSTICLOGGER.debug(RuntimeMsgCode.EMPTY_MSG, " Creating session for user : " + p_userName == null ? "null user" : p_userName);
		}
	}

	/**
	 * Constructor for VSORBSessionImpl.
     *
	 * @param p_AppServer VSORBAppServerImpl
	 * @param roleList Vector
	 * @param p_userName String
	 * @param p_securitySession boolean
	 * @param internalSession boolean
	 * @throws ServerSecurityException
	 */
	public VSORBSessionImpl(VSORBAppServerImpl p_AppServer, Vector roleList, String p_userName, boolean p_securitySession, boolean internalSession)
	    throws ServerSecurityException {
		super(p_AppServer, roleList, p_userName, p_securitySession, internalSession);
		if ( _DIAGNOSTICLOGGER.isDebugEnabled() ) {
			_DIAGNOSTICLOGGER.debug(RuntimeMsgCode.EMPTY_MSG, " Creating session for user : " + p_userName == null ? "null user" : p_userName);
		}
	}

	/**
	 * Constructor for VSORBSessionImpl.
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
	public VSORBSessionImpl(VSORBAppServerImpl p_AppServer, String p_userName, String p_password, String p_clientAppName, boolean internalSession, String repositoryName, boolean p_securitySession)
	    throws ServerSecurityException {
        super(p_AppServer, p_userName, p_password, p_clientAppName, internalSession, repositoryName, p_securitySession);
        if ( _DIAGNOSTICLOGGER.isDebugEnabled() ) {
			_DIAGNOSTICLOGGER.debug(RuntimeMsgCode.EMPTY_MSG, " Creating session for user : " + p_userName == null ? "null user" : p_userName);
		}
	}

	/**
	 * Constructor for VSORBSessionImpl.
     *
	 * @param p_AppServer VSORBAppServerImpl
	 * @param roleList Vector
	 * @param p_userName String
	 * @param p_password String
	 * @param p_clientAppName String
	 * @param internalSession boolean
	 * @param repositoryName String
	 * @param p_securitySession boolean
	 * @throws ServerSecurityException
	 */
	public VSORBSessionImpl(VSORBAppServerImpl p_AppServer, Vector roleList, String p_userName, String p_password, String p_clientAppName, boolean internalSession, String repositoryName, boolean p_securitySession)
	    throws ServerSecurityException {
        super(p_AppServer, roleList, p_userName, p_password, p_clientAppName, internalSession, repositoryName, p_securitySession);
        if ( _DIAGNOSTICLOGGER.isDebugEnabled() ) {
			_DIAGNOSTICLOGGER.debug(RuntimeMsgCode.EMPTY_MSG, " Creating session for user : " + p_userName == null ? "null user" : p_userName);
		}
	}

/*
	public boolean isTransactionInProgress() {
		Current current = get_current();
		if (current == null)
			return false;
		try {
			return (current.get_status().value() != versata.common.Transaction.Status._StatusNoTransaction);
		}
		catch(Exception e) { //TODO-EBAS
			printTransactionInfo();
			throw new ServerException(e.toString());
		}
	}
*/

	/**
	 * Remove current session from server environment
     *
	 * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#close()
 */
	public void close() {
		
		if(_DIAGNOSTICLOGGER.isDebugEnabled()) {
			_DIAGNOSTICLOGGER.debug(RuntimeMsgCode.EMPTY_MSG, " closing session for user : " + getUserID() == null ? "null user" : getUserID());
		}

        if (_LOGGER.isDebugEnabled()) {
            _LOGGER.debug("close session called: session details are" + this + "Thread ID is" +Thread.currentThread().getId());
        }
        
		if (container == null)       // Session is closed already.
		{
			return;
		}
		Enumeration e = container.elements();

        if(sessionTxMapReverse.get(this)!=null) {
            sessionTxMap.remove(sessionTxMapReverse.get(this));
            sessionTxMapReverse.remove(this);
            if (_LOGGER.isDebugEnabled()) {
                _LOGGER.debug("close session : removed sessionid from MAP (sessionTxMap)");
            }
        }

		while (e.hasMoreElements()) {
			SessionListener l = (SessionListener)e.nextElement();
			try {
				l.beforeSessionClosed(this);
			} catch (Exception ex) { _LOGGER.warn(ex); }
		}

		container.removeAllElements();
		container = null;

		// If session is still in transaction, abort it.
		//Do it only  if it is not JTS transaction because in case of JTS transaction
		//starter must rollback it.
		CurrentTransaction currentTx = (CurrentTransaction)get_current();
		if(_LOGGER.isDebugEnabled()) {
		    _LOGGER.debug("Current Transaction : " + currentTx);
		    
		    if(currentTx != null) {
		        _LOGGER.debug("Is Current Transaction External JTS? - " 
		            + currentTx.isExternalJTS());
		    }
		}
		if (currentTx != null && !currentTx.isExternalJTS()) {
			try {
				rollback();
			} catch (NoTransactionException ex) { _LOGGER.warn(ex); }
		}

		// release connections
		unregisterAllConnections();

		// If this is an ESM session, make sure all the event logs are cleaned up
		// indu - VSORBSessionImpl?
		if (isConsoleSession() && !isAnotherEsmRunning()) {
			VSORBSession[] sessions = theAppServer.getSessions();
			if (sessions != null) {
				for (int i = 0; i < sessions.length; i++) {
                    ServerEnvironment.getFactoryImpl().getVLSSecuritySessionDelegate((VSORBSecuritySession)sessions[i])
                        .removeEventListener(ID);
				}
			}
		}

        if (!ServerEnvironment.isConfigAdminDataPerEAR() && isUpdateModeConsoleSession) {
			VLSSingleton.getSingleton().unLockConsole();
		}

		// Remove references
		if( serverEventListeners != null ) {
			serverEventListeners.removeAllElements();
			serverEventListeners = null;
        }

		currentTransaction = null;
		lastPing = null;
		transactionInfo = null;

		// Remove this session from the list
		if( theAppServer != null ) { 
			theAppServer.removeSession(this);
            theAppServer = null;
        }

		disableReadOnlyCacheForSession();

		if( readOnlyCaches != null ) {
			readOnlyCaches.clear();
			readOnlyCaches = null;
        }

		closeRemoteResultSets();

		// Deactivate this object
		releaseRemoteReferenceForSecuritySession();
		releaseRemoteReference();

		if (vlsContextBean != null) {     // For internal session this variable will be null.
			try {
				vlsContextBean.remove();
				vlsContextBean = null;
			} catch (NoSuchObjectException noe) {
				_LOGGER.error(noe);
				// it's already been removed
			} catch (Exception ex) {
				_LOGGER.error(ex);
			}
		}

		if (sessionAttributes != null) {
			sessionAttributes.clear();
			sessionAttributes = null;
		}
		//TODO: Apply change for all Editions
		theAppServer = null; // FINIS merge: No VIT
		if (_LOGGER.isDebugEnabled()) {
			_LOGGER.debug(RuntimeMsgCode.VSORBSESSIONIMPL668, userName);
		}
	}

	/**
     * Client alerting server it is still running.  Used for session timeout processing.
     *
	 * @see com.versata.tl.common.vlsobject.VSORBSessionOperations#ping()
	 */
	public void ping() {
		if (theAppServer == null) {
            throw new RuntimeException(MessageLocalizer.getLocalizedMessageWithCodePrefix(RuntimeMsgCode.VSORBSESSIONIMPL683));
		}
		lastPing = new Date();

        if (!ServerEnvironment.isConfigAdminDataPerEAR() && isUpdateModeConsoleSession) {
			VLSSingleton.getSingleton().updateConsoleLock();
		}

		// Commented - Rahul
		// addServerEvent("Ping message received", "", 2);

	}

    private boolean isUpdateModeConsoleSession;

	/**
     * @return boolean
	 * @internal.tle
	 * @see com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations#isAnotherEsmRunning()
	 */
	public boolean isAnotherEsmRunning() {

		if (!ServerEnvironment.isConfigAdminDataPerEAR()) {
			try {
				if (!VLSSingleton.getSingleton().isConsoleLocked()) {
					if (isConsoleSession()) {
                        if (VLSSingleton.getSingleton().lockConsole(getRepositoryName(), getSessionPingRate())) {
							isUpdateModeConsoleSession = true;
							return false;
						} else {
							return true;
						}
					} else {
						return false;
					}

				} else {
					return true;
				}
			} catch (Exception e) {
                throw new ServerException(AdminMsgCode.SYSTEM_ERROR, e);

			}
		} else {
			VSORBSession[] sess = theAppServer.getSessions();
			try {
				for (int x = 0; x < sess.length; x++) {
					VSORBSessionImpl session = (VSORBSessionImpl)ServerEnvironment.getFactoryImpl()
					    .getVLSSecuritySessionDelegate((VSORBSecuritySession)sess[x]);
					if (session != this && sess[x].isConsoleSession()) {
						return true;
					}
				}

            } catch (RemoteException e) {
                throw new ServerException(AdminMsgCode.SYSTEM_ERROR, e);
			}
			return false;
		}
	}

	/**
     * This method returns a Java Properties structure which contains all the User Role properties defined for this installation, and
     * all the values assigned to those properties for this particular user/role assignment.  The property name is the key of the
     * Properties object, and the value of the property is the object of each Property's instance value.
	 *
     * @param loginID the login ID of the user for which user role properties should be retrieved
     * @param roleID the internal ID of the role for which user role properties should be retrieved
     * @return Properties    Java Properties Object containing all defined properties for this user role
     * @see Session#getUserRoleProperties(String, long)
	 */
	public Properties getUserRoleProperties(String loginID, long roleID) {
		Session ses = getServer().getInternalSession();
		SearchRequest filter = new SearchRequest();
		filter.add(new Parameter("AppUserRole", "AppUserLoginID", loginID));
		filter.add(new Parameter("AppUserRole", "RoleID", Long.toString(roleID)));
        AppUserRoleImpl userRole = (AppUserRoleImpl)AppUserRoleImpl.getObjectByKey(filter, ses);
		if (userRole == null) {
			filter = new SearchRequest();
			filter.add(new Parameter("AppRole", "RoleID", Long.toString(roleID)));
			AppRoleImpl role = (AppRoleImpl)AppRoleImpl.getObjectByKey(filter, ses);
			if (role == null) {
				return null;
			}

			AppUserImpl user = AppUserImpl.getUserObject(loginID, ses);
			if (user == null) {
				return null;
			}

			userRole = AppUserRoleImpl.getNewObject(ses, true);
			userRole.setAppUserLoginID(loginID);
			userRole.setRoleID(roleID);
		}
		return userRole.getProperties();
	}

	/**
	 *   @internal.tle
	 */
	/*public  void validateDataServerConfiguration(boolean isAutoCloseResultSet, boolean isUsingXADriver,boolean useNativePoolForVersataReadTx) throws VSORBException {
		 if(!isAutoCloseResultSet) {
		   if(!useNativePoolForVersataReadTx ){
			   VSORBException ex = Util.createORBException("While using the external connection pool, user must either enable the virtual result set or configure the native pool for Versata Read Transaction. Please see Administrator Guide for more details.");
			   Util.logWarning (logger, ex);
			   throw ex;

		   }
		 }

	}*/
}
