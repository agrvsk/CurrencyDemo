package com.versata.tl.vfc.dataaccess;

import java.rmi.RemoteException;

import javax.ejb.EJBHome;
import javax.ejb.EJBObject;
import javax.ejb.Handle;
import javax.ejb.RemoveException;

import com.versata.tl.common.MetaColumn;
import com.versata.tl.common.Property;
import com.versata.tl.common.QueryRequest;
import com.versata.tl.common.QueryResponse;
import com.versata.tl.common.VSORBSessionPackage.ORBRows;
import com.versata.tl.common.exception.MailException;
import com.versata.tl.common.exception.ServerSecurityException;
import com.versata.tl.common.transaction.Current;
import com.versata.tl.common.transaction.NoTransactionException;
import com.versata.tl.common.transaction.SubtransactionsUnavailableException;
import com.versata.tl.common.vlsobject.VSORBException;
import com.versata.tl.common.vlsobject.VSORBResultSet;
import com.versata.tl.common.vlsobject.VSORBResultSet_Factory;
import com.versata.tl.common.vlsobject.VSORBSession;

/**
 * @author akushyn
 * @version $Revision: #1 $
 */
public class VSORBSession_TestStub implements VSORBSession {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#setRepositoryName(String)
	 */
	public void setRepositoryName(String repositoryName) throws RemoteException{
		
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#begin()
	 */
	public Current begin() throws SubtransactionsUnavailableException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#canUpdatePackage(java.lang.String)
	 */
	public boolean canUpdatePackage(final String id) throws RemoteException {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#changeMyPassword(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String)
	 */
	public void changeMyPassword(final String loginID,
			final String oldPassword, final String newPassword,
			final String confirmPassword) throws VSORBException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#close()
	 */
	public void close() throws RemoteException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#commit()
	 */
	public void commit() throws NoTransactionException, VSORBException,
			RemoteException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#executeQuery(QueryRequest)
	 */
	public Object executeQuery(final QueryRequest queryRequest)
			throws VSORBException, RemoteException {
		final QueryResponse queryResponse = new QueryResponse();
		queryResponse.setMetaColumn(new MetaColumn[] {});
		final QueryRequest qr = new QueryRequest();
		qr.setPrefetchRowCount(true);
		queryResponse.setQueryRequest(qr);

		VSORBResultSet RS;
		try {
			RS = VSORBResultSet_Factory.createVSORBResultSet();
		} catch (final ServerSecurityException e) {
			RS = null;
		}

		queryResponse.setRS(RS);
		final String[][] theRows = { new String[] { "" } };
		queryResponse.setRows(theRows);
		queryResponse.setRowsAsObjects(theRows);
		return queryResponse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#flushAfterSave(boolean)
	 */
	public boolean flushAfterSave(final boolean value) throws RemoteException {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getCoLocated()
	 */
	public boolean getCoLocated() throws VSORBException, RemoteException {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getCurrentVersion()
	 */
	public int getCurrentVersion() throws RemoteException {

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getDatabaseTypeName()
	 */
	public String getDatabaseTypeName() throws RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getDataServerForObject(java.lang.String)
	 */
	public String getDataServerForObject(final String objectName)
			throws RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getDataServerProperties(java.lang.String)
	 */
	public Property[] getDataServerProperties(final String objectName)
			throws VSORBException, RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getDataServerProperty(java.lang.String,
	 *      java.lang.String)
	 */
	public String getDataServerProperty(final String objectName,
			final String property) throws RemoteException,
			ServerSecurityException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ejb.EJBObject#getEJBHome()
	 */
	public EJBHome getEJBHome() throws RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getErrorsAtStartup()
	 */
	public boolean getErrorsAtStartup() throws RemoteException {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ejb.EJBObject#getHandle()
	 */
	public Handle getHandle() throws RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getLocaleStrings()
	 */
	public String[] getLocaleStrings() throws RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getMetaQuery(java.lang.String,
	 *      java.lang.String)
	 */
	public byte[] getMetaQuery(final String packageName,
			final String componentName) throws VSORBException, RemoteException {
		if (componentName == "componentName") {
			return new byte[] { 1 };
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getMyAccessToRole(java.lang.String)
	 */
	public boolean getMyAccessToRole(final String roleName)
			throws VSORBException, RemoteException {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getMyNonViewableColumnPrivileges(java.lang.String)
	 */
	public Property[] getMyNonViewableColumnPrivileges(final String objectName)
			throws VSORBException, RemoteException {
		final Property[] prop = new Property[] { new Property() };
		prop[0].name = "name";
		prop[0].value = "fasle";
		return prop;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getMyObjectPrivileges(java.lang.String,
	 *      java.lang.String)
	 */
	public Property[] getMyObjectPrivileges(final String objectName,
			final String objectType) throws VSORBException, RemoteException {
		Property[] pr = null;
		if (objectName == "objectName") {
			pr = new Property[] { new Property() };
			pr[0].name = "name";
			pr[0].value = "false";
		}
		return pr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getMyPrivilegeToAppForm(java.lang.String,
	 *      java.lang.String)
	 */
	public boolean getMyPrivilegeToAppForm(final String appName,
			final String formName) throws VSORBException, RemoteException {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getMyPrivilegeToMethod(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	public boolean getMyPrivilegeToMethod(final String privilegeType,
			final String objectName, final String methodOrColumnName)
			throws VSORBException, RemoteException {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getMyPrivilegeToObjectName(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	public boolean getMyPrivilegeToObjectName(final String privilegeType,
			final String objectName, final String objectType)
			throws VSORBException, RemoteException {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getMyRolesToGrant()
	 */
	public VSORBResultSet getMyRolesToGrant() throws ServerSecurityException,
			VSORBException, RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getMyUpdateableColumnPrivileges(java.lang.String)
	 */
	public Property[] getMyUpdateableColumnPrivileges(final String objectName)
			throws VSORBException, RemoteException {
		final Property p1 = new Property();
		p1.name = "AppUser.AppSvrLoginID";
		p1.value = "true";
		final Property p2 = new Property();
		p2.name = "AppUser.AppSvrPassword";
		p2.value = "false";
		final Property p3 = new Property();
		p3.name = "AppUser.UserName";
		p3.value = "false";
		final Property[] p = new Property[] { p1, p2, p3 };
		return p;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getMyUserPrivilege(java.lang.String)
	 */
	public boolean getMyUserPrivilege(final String privilegeType)
			throws VSORBException, RemoteException {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getMyUserPrivileges()
	 */
	public Property[] getMyUserPrivileges() throws VSORBException,
			RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getName()
	 */
	public String getName() throws RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ejb.EJBObject#getPrimaryKey()
	 */
	public Object getPrimaryKey() throws RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getProductVersion()
	 */
	public String getProductVersion() throws RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getProperty(java.lang.String)
	 */
	public String getProperty(final String property) throws RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getPropertyAsObject(java.lang.String)
	 */
	public Object getPropertyAsObject(final String property)
			throws RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getPropertyList()
	 */
	public Property[] getPropertyList() throws RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getResultSetByRequest(java.lang.String,
	 *      byte[], byte[], int)
	 */
	public VSORBResultSet getResultSetByRequest(final String componentName,
			final byte[] filter, final byte[] sorter, final int preFetchRowCount)
			throws VSORBException, RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getResultSetByRequest1(java.lang.String,
	 *      byte[], byte[], int, short, boolean, int, boolean)
	 */
	public VSORBResultSet getResultSetByRequest1(final String componentName,
			final byte[] filter, final byte[] sorter,
			final int preFetchRowCount, final short columnProjectionLevel,
			final boolean dataPreFetch, final int randomAccessPos,
			final boolean isAutoCloseResultSet) throws VSORBException,
			RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getResultSetBySQLRemote(java.lang.String,
	 *      java.lang.String, int, boolean)
	 */
	public VSORBResultSet getResultSetBySQLRemote(final String SQL,
			final String dataServerName, final int preFetchRowCount,
			final boolean dataPreFetch) throws VSORBException, RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getResultSetBySQLRemote1(java.lang.String,
	 *      java.lang.String, int, boolean, int, boolean)
	 */
	public VSORBResultSet getResultSetBySQLRemote1(final String SQL,
			final String dataServerName, final int preFetchRowCount,
			final boolean dataPreFetch, final int randomAccessPos,
			final boolean isAutoCloseResultSet) throws VSORBException,
			RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getResultSetFromCache(java.lang.String,
	 *      int)
	 */
	public VSORBResultSet getResultSetFromCache(final String componentName,
			final int preFetchRowCount) throws VSORBException, RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getSecurityMetadataVersion()
	 */
	public String getSecurityMetadataVersion() throws RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getServerSecurityObject()
	 */
	public Object getServerSecurityObject() throws RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getSessionID()
	 */
	public int getSessionID() throws RemoteException {

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getSessionPingRate()
	 */
	public int getSessionPingRate() throws VSORBException, RemoteException {

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getUserID()
	 */
	public String getUserID() throws RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#getUserName()
	 */
	public String getUserName() throws RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#isConsoleSession()
	 */
	public boolean isConsoleSession() throws RemoteException {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ejb.EJBObject#isIdentical(javax.ejb.EJBObject)
	 */
	public boolean isIdentical(final EJBObject arg0) throws RemoteException {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#isSecuritySession()
	 */
	public boolean isSecuritySession() throws RemoteException {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#ping()
	 */
	public void ping() throws RemoteException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#ping2()
	 */
	public void ping2() throws RemoteException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#pushSecurityDataWithLogin(byte[],
	 *      int, java.lang.String, java.lang.String)
	 */
	public void pushSecurityDataWithLogin(final byte[] sd,
			final int masterVersion, final String login, final String password)
			throws ServerSecurityException, RemoteException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ejb.EJBObject#remove()
	 */
	public void remove() throws RemoteException, RemoveException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#removeProperty(java.lang.String)
	 */
	public Object removeProperty(final String property) throws RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#rollback()
	 */
	public void rollback() throws NoTransactionException, RemoteException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#save(com.versata.tl.common.VSORBSessionPackage.ORBRows)
	 */
	public String[][] save(final ORBRows orbRows) throws VSORBException,
			RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#sendMail(java.lang.String[],
	 *      java.lang.String[], java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String, short)
	 */
	public void sendMail(final String[] to, final String[] cc,
			final String from, final String mailServer, final String subject,
			final String msg, final short transactionalType)
			throws MailException, RemoteException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#setCoLocated(boolean)
	 */
	public void setCoLocated(final boolean bool) throws VSORBException,
			RemoteException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#setPackageName(java.lang.String)
	 */
	public void setPackageName(final String packageName) throws RemoteException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#setProperties(java.lang.String[][])
	 */
	public void setProperties(final String[][] properties)
			throws RemoteException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#setProperty(java.lang.String,
	 *      java.lang.String)
	 */
	public void setProperty(final String property, final String value)
			throws RemoteException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#setPropertyAsObject(java.lang.String,
	 *      java.lang.Object)
	 */
	public void setPropertyAsObject(final String property, final Object value)
			throws RemoteException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#setUpdatePackage(java.lang.String)
	 */
	public void setUpdatePackage(final String id) throws RemoteException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#setUpdatePackageForApp(java.lang.String)
	 */
	public void setUpdatePackageForApp(final String id) throws RemoteException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBSession#setUserDefinedEvent(java.lang.String)
	 */
	public void setUserDefinedEvent(final String eventName)
			throws RemoteException {

	}

}
