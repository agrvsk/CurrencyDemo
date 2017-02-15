package com.versata.tl.vls.dataaccess.connection;

import com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver_TestStub;

/**
 * The class <code>VSJdbcStatement_Factory</code> implements static methods
 * that return instances of the class {@link VSJdbcStatement}.
 * 
 * @author akushyn
 * @version $Revision: #1 $
 */
public class VSJdbcStatement_Factory {

	/**
	 * Create an instance of the class {@link VSJdbcStatement}.
	 * 
	 * @return VSJdbcStatement
	 * @throws com.versata.tl.common.exception.ServerException
	 */
	public static VSJdbcStatement createVSJdbcStatement()
			throws com.versata.tl.common.exception.ServerException {
		final VSJdbc con = new VSJdbc();
		con.jdbcDriver = new VSJdbcDriver_TestStub();
		return new VSJdbcStatement(con);
	}

	/**
	 * Create an instance of the class {@link VSJdbcStatement}.
	 * 
	 * @return VSJdbcStatement
	 * @throws com.versata.tl.common.exception.ServerException
	 */
	public static VSJdbcStatement createVSJdbcStatementVSJdbc_TestStub()
			throws com.versata.tl.common.exception.ServerException {
		final VSJdbc_TestStub con = new VSJdbc_TestStub();
		con.jdbcDriver = new VSJdbcDriver_TestStub();
		return new VSJdbcStatement(con);
	}

	/**
	 * Prevent creation of instances of this class.
	 * 
	 */
	private VSJdbcStatement_Factory() {
	}
}