package com.versata.tl.vls.dataaccess.connection;

import java.rmi.RemoteException;

import javax.ejb.EJBHome;
import javax.ejb.EJBObject;
import javax.ejb.Handle;
import javax.ejb.RemoveException;

import com.versata.tl.common.RowSeqHolder;
import com.versata.tl.common.VSORBResultSetPackage.atEndException;
import com.versata.tl.common.exception.ServerException;
import com.versata.tl.common.vlsobject.VSORBException;
import com.versata.tl.common.vlsobject.VSORBResultSet;
import com.versata.tl.vls.core.DataRow;

/**
 * @author akushyn
 * @version $Revision: #1 $
 */
public class VSJdbcStatement_TestStub extends VSJdbcStatement implements
		VSORBResultSet {

	/**
	 * @param parentJdbc
	 * @throws ServerException
	 */
	public VSJdbcStatement_TestStub(final VSJdbc parentJdbc)
			throws ServerException {
		super(parentJdbc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBResultSet#close()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBResultSet#fetch(com.versata.tl.common.RowSeqHolder)
	 */
	/**
	 * Method fetch.
	 * 
	 * @param Rows
	 *            RowSeqHolder
	 * @return int
	 * @throws atEndException
	 * @throws VSORBException
	 * @throws RemoteException
	 * @see com.versata.tl.common.vlsobject.VSORBResultSet#fetch(RowSeqHolder)
	 */
	public int fetch(final RowSeqHolder Rows) throws atEndException,
			VSORBException, RemoteException {

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBResultSet#fetchRows()
	 */
	public String[][] fetchRows() throws atEndException, VSORBException,
			RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBResultSet#fetchRowsAsBytes()
	 */
	public byte[] fetchRowsAsBytes() throws atEndException, VSORBException,
			RemoteException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBResultSet#getCount()
	 */
	public int getCount() throws VSORBException, RemoteException {

		return 0;
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
	 * @see javax.ejb.EJBObject#getHandle()
	 */
	public Handle getHandle() throws RemoteException {

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
	 * @see javax.ejb.EJBObject#isIdentical(javax.ejb.EJBObject)
	 */
	public boolean isIdentical(final EJBObject arg0) throws RemoteException {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.XDAConnector#refresh(com.versata.tl.vls.core.DataRow,
	 *      com.versata.tl.vls.dataaccess.connection.Connection)
	 */
	public void refresh(final DataRow row, final Connection con) {

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
	 * @see com.versata.tl.common.vlsobject.VSORBResultSet#setColumnProjectionLevel(int)
	 */
	/**
	 * Method setColumnProjectionLevel.
	 * 
	 * @param level
	 *            int
	 * @throws RemoteException
	 * @see com.versata.tl.common.vlsobject.VSORBResultSet#setColumnProjectionLevel(int)
	 */
	public void setColumnProjectionLevel(final int level)
			throws RemoteException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.common.vlsobject.VSORBResultSet#setCursorPosition(int)
	 */
	public boolean setCursorPosition(final int position) throws VSORBException,
			RemoteException {

		return false;
	}

}