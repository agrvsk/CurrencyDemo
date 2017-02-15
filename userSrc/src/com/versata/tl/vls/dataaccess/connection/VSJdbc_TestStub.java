package com.versata.tl.vls.dataaccess.connection;

import java.util.Locale;

import com.versata.tl.common.exception.ServerException;
import com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver;
import com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver_TestStub;

/**
 * 
 * @author mlytvyn
 * @version $Revision: #1 $
 */
public class VSJdbc_TestStub extends VSJdbc{

	/*
	 * (non-Javadoc)
	 * @see com.versata.tl.vls.dataaccess.connection.VSJdbc#dbType
	 */
	protected short dbType = 1;

	/*
	 * (non-Javadoc)
	 * @see com.versata.tl.vls.dataaccess.connection.VSJdbc#isMySQL()
	 */
    /**
	 * (non-Javadoc)
	 * 
     * Indicate whether the current database is MySQL based on data server DbType property
     *
     * @return true if data server DbType property  is "MySQL"
     */
	@Override
    public boolean isMySQL() {
        return true;
    }

    /**
     * Open a new predefined for test Jdbc statement
     *
     * @return VSJdbcStatement  newly created VSJdbcStatement
     * @throws ServerException
     */
	@Override
    public VSJdbcStatement createJdbcStatement() throws ServerException {
        return VSJdbcStatement_Factory.createVSJdbcStatementVSJdbc_TestStub();
    }
	
	/*
	 * (non-Javadoc)
	 * @see com.versata.tl.vls.dataaccess.connection.VSJdbc#releaseStatement(com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
    /**
     * Method releaseStatement.
     *
     * @param stmt VSJdbcStatement
     * @throws ServerException
     */
	@Override
    public void releaseStatement(VSJdbcStatement stmt) throws ServerException {	
		
    }
	
	/*
	 * (non-Javadoc)
	 * @see com.versata.tl.vls.dataaccess.connection.VSJdbc#closeStatement(com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	/**
     * Call this method to close an existing statement in this JDBC connection
     *
     * @param stmt a wrapper on top of physical JDBC statement
     * @throws ServerException
     */
	@Override
	public void closeStatement(VSJdbcStatement stmt) throws ServerException {
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.versata.tl.vls.dataaccess.connection.VSJdbc#getJdbcDriver()
	 */
    /**
     * get a VSJdbcDriver object used by this session
     *
     * @return a VSJdbcDriver
     */
	@Override
	public VSJdbcDriver getJdbcDriver() {
		return new VSJdbcDriver_TestStub();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.versata.tl.vls.dataaccess.connection.VSJdbc#getLocale()
	 */
    /**
     * return the current database's locale specified in Data server properties
     *
     * @return The locale value
     */
	@Override
	public Locale getLocale() {
        return new Locale("en", "us", "");
    }
	

}
