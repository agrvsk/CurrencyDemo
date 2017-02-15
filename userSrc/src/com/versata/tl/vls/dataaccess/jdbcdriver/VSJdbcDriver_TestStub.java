package com.versata.tl.vls.dataaccess.jdbcdriver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

import com.versata.tl.common.MetaColumn;
import com.versata.tl.common.exception.ServerException;
import com.versata.tl.common.meta.VSMetaQuery;
import com.versata.tl.vls.core.DataRow;
import com.versata.tl.vls.dataaccess.connection.VSJdbc;
import com.versata.tl.vls.dataaccess.connection.VSJdbcStatement;

/**
 * @author akushyn
 * 
 * @version $Revision: #1 $
 */
public class VSJdbcDriver_TestStub implements VSJdbcDriver {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#beginTransaction()
	 */
	public void beginTransaction() throws ServerException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#cancelStatement(com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public void cancelStatement(final VSJdbcStatement jdbcstmt)
			throws ServerException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#close()
	 */
	public void close() throws ServerException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#closeResultSet(com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public void closeResultSet(final VSJdbcStatement stmt)
			throws ServerException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#closeStatement(com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public void closeStatement(final VSJdbcStatement jdbcstmt)
			throws ServerException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#commit()
	 */
	public void commit() throws ServerException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#connect()
	 */
	public boolean connect() throws ServerException {

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#createCallableStatement(java.lang.String,
	 *      com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public void createCallableStatement(final String sql,
			final VSJdbcStatement jdbcstmt) throws ServerException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#createStatement(java.lang.String,
	 *      com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public void createStatement(final String sql, final VSJdbcStatement jdbcstmt)
			throws ServerException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#createStatement(com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public void createStatement(final VSJdbcStatement jdbcstmt)
			throws ServerException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#disableBatch()
	 */
	public void disableBatch() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#enableBatch()
	 */
	public void enableBatch() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#execute(java.lang.String,
	 *      com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public boolean execute(final String newSqlText,
			final VSJdbcStatement jdbcstmt) throws ServerException {

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#execute(java.lang.String,
	 *      com.versata.tl.vls.dataaccess.connection.VSJdbcStatement, int[],
	 *      int[], com.versata.tl.common.meta.VSMetaQuery)
	 */
	public boolean execute(final String newSqlText,
			final VSJdbcStatement jdbcstmt, final int[] columnTypes,
			final int[] columnIndexes, final VSMetaQuery metaQuery)
			throws ServerException {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#execute(com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public boolean execute(final VSJdbcStatement jdbcstmt)
			throws ServerException {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#execute(com.versata.tl.vls.dataaccess.connection.VSJdbcStatement,
	 *      int[], int[], com.versata.tl.common.meta.VSMetaQuery)
	 */
	public boolean execute(final VSJdbcStatement jdbcstmt,
			final int[] columnTypes, final int[] columnIndexes,
			final VSMetaQuery metaQuery) throws ServerException {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#executeUpdate(com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public int executeUpdate(final VSJdbcStatement jdbcstmt)
			throws ServerException {

		return 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#executeUpdate(com.versata.tl.vls.dataaccess.connection.VSJdbcStatement,
	 *      java.lang.String)
	 */
	public int executeUpdate(final VSJdbcStatement jdbcstmt, final String sql)
			throws ServerException {

		return 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#getColumnCount(com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public int getColumnCount(final VSJdbcStatement jdbcstmt)
			throws ServerException {

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#getDataArray(java.lang.String[][],
	 *      com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public int getDataArray(final String[][] rowBuffer,
			final VSJdbcStatement jdbcstmt) throws ServerException {

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#getDatabaseProductName()
	 */
	public String getDatabaseProductName() throws ServerException {

		return "string";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#getDataRow(com.versata.tl.vls.core.DataRow,
	 *      com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public int getDataRow(final DataRow row, final VSJdbcStatement jdbcstmt)
			throws ServerException {

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#getDataRowValueFromCurrentDisk(com.versata.tl.vls.core.DataRow,
	 *      com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public int getDataRowValueFromCurrentDisk(final DataRow row,
			final VSJdbcStatement jdbcstmt) throws ServerException {

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#getJdbcNativeConnection()
	 */
	public Connection getJdbcNativeConnection() {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#getLockingHint()
	 */
	public String getLockingHint() {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#getMoreResults(com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public boolean getMoreResults(final VSJdbcStatement jdbcstmt)
			throws ServerException {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#getNativeStatement(com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public Statement getNativeStatement(final VSJdbcStatement stmt) {
		class stat implements Statement {

			public void addBatch(String arg0) throws SQLException {
				// TODO Auto-generated method stub
				
			}

			public void cancel() throws SQLException {
				// TODO Auto-generated method stub
				
			}

			public void clearBatch() throws SQLException {
				// TODO Auto-generated method stub
				
			}

			public void clearWarnings() throws SQLException {
				// TODO Auto-generated method stub
				
			}

			public void close() throws SQLException {
				// TODO Auto-generated method stub
				
			}

			public boolean execute(String arg0) throws SQLException {
				// TODO Auto-generated method stub
				return false;
			}

			public boolean execute(String arg0, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				return false;
			}

			public boolean execute(String arg0, int[] arg1) throws SQLException {
				// TODO Auto-generated method stub
				return false;
			}

			public boolean execute(String arg0, String[] arg1)
					throws SQLException {
				// TODO Auto-generated method stub
				return false;
			}

			public int[] executeBatch() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}

			public ResultSet executeQuery(String arg0) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}

			public int executeUpdate(String arg0) throws SQLException {
				// TODO Auto-generated method stub
				return 0;
			}

			public int executeUpdate(String arg0, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				return 0;
			}

			public int executeUpdate(String arg0, int[] arg1)
					throws SQLException {
				// TODO Auto-generated method stub
				return 0;
			}

			public int executeUpdate(String arg0, String[] arg1)
					throws SQLException {
				// TODO Auto-generated method stub
				return 0;
			}

			public Connection getConnection() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}

			public int getFetchDirection() throws SQLException {
				// TODO Auto-generated method stub
				return 0;
			}

			public int getFetchSize() throws SQLException {
				// TODO Auto-generated method stub
				return 0;
			}

			public ResultSet getGeneratedKeys() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}

			public int getMaxFieldSize() throws SQLException {
				// TODO Auto-generated method stub
				return 0;
			}

			public int getMaxRows() throws SQLException {
				// TODO Auto-generated method stub
				return 0;
			}

			public boolean getMoreResults() throws SQLException {
				// TODO Auto-generated method stub
				return false;
			}

			public boolean getMoreResults(int arg0) throws SQLException {
				// TODO Auto-generated method stub
				return false;
			}

			public int getQueryTimeout() throws SQLException {
				// TODO Auto-generated method stub
				return 0;
			}

			public ResultSet getResultSet() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}

			public int getResultSetConcurrency() throws SQLException {
				// TODO Auto-generated method stub
				return 0;
			}

			public int getResultSetHoldability() throws SQLException {
				// TODO Auto-generated method stub
				return 0;
			}

			public int getResultSetType() throws SQLException {
				// TODO Auto-generated method stub
				return 0;
			}

			public int getUpdateCount() throws SQLException {
				// TODO Auto-generated method stub
				return 0;
			}

			public SQLWarning getWarnings() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}

			public void setCursorName(String arg0) throws SQLException {
				// TODO Auto-generated method stub
				
			}

			public void setEscapeProcessing(boolean arg0) throws SQLException {
				// TODO Auto-generated method stub
				
			}

			public void setFetchDirection(int arg0) throws SQLException {
				// TODO Auto-generated method stub
				
			}

			public void setFetchSize(int arg0) throws SQLException {
				// TODO Auto-generated method stub
				
			}

			public void setMaxFieldSize(int arg0) throws SQLException {
				// TODO Auto-generated method stub
				
			}

			public void setMaxRows(int arg0) throws SQLException {
				// TODO Auto-generated method stub
				
			}

			public void setQueryTimeout(int arg0) throws SQLException {
				// TODO Auto-generated method stub
				
			}

			public boolean isClosed() throws SQLException {
				// TODO Auto-generated method stub
				return false;
			}

			public boolean isPoolable() throws SQLException {
				// TODO Auto-generated method stub
				return false;
			}

			public void setPoolable(boolean arg0) throws SQLException {
				// TODO Auto-generated method stub
				
			}

			public boolean isWrapperFor(Class<?> iface) throws SQLException {
				// TODO Auto-generated method stub
				return false;
			}

			public <T> T unwrap(Class<T> iface) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			
		}
		return new stat();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#getNumberOfStatements()
	 */
	public int getNumberOfStatements() throws ServerException {

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#getObject(int,
	 *      int, com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public Object getObject(final int index, final int sqlType,
			final VSJdbcStatement jdbcstmt) throws ServerException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#getObjectArray(java.lang.Object[][],
	 *      com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public int getObjectArray(final Object[][] rowBuffer,
			final VSJdbcStatement jdbcstmt) throws ServerException {

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#getOutParameter(int,
	 *      int, com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public Object getOutParameter(final int index, final int scale,
			final VSJdbcStatement jdbcstmt) throws ServerException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#getOutParameter(int,
	 *      com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public Object getOutParameter(final int index,
			final VSJdbcStatement jdbcstmt) throws ServerException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#getResultSet(com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public boolean getResultSet(final VSJdbcStatement jdbcstmt)
			throws ServerException {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#getUpdateCount(com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public int getUpdateCount(final VSJdbcStatement jdbcstmt)
			throws ServerException {

		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#loadJdbcDriver(com.versata.tl.vls.dataaccess.connection.VSJdbc)
	 */
	public boolean loadJdbcDriver(final VSJdbc jdbc) throws ServerException {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#next(com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public boolean next(final VSJdbcStatement jdbcstmt) throws ServerException {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#ping()
	 */
	public boolean ping() {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#registerMetaData(com.versata.tl.common.MetaColumn[],
	 *      com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public void registerMetaData(final MetaColumn[] metaColumns,
			final VSJdbcStatement jdbcstmt) throws ServerException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#registerOutParameter(int,
	 *      int, int, com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public void registerOutParameter(final int index, final int sqltype,
			final int scale, final VSJdbcStatement jdbcstmt)
			throws ServerException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#registerOutParameter(int,
	 *      int, com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public void registerOutParameter(final int index, final int sqltype,
			final VSJdbcStatement jdbcstmt) throws ServerException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#reloadColumnTypeList(com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public void reloadColumnTypeList(final VSJdbcStatement jdbcstmt)
			throws ServerException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#rollback()
	 */
	public void rollback() throws ServerException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#sendBatch()
	 */
	public int sendBatch() {

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#setConnectionWrapper(com.versata.tl.vls.dataaccess.connection.VSJdbc)
	 */
	public void setConnectionWrapper(final VSJdbc con) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#setCursorPosition(int,
	 *      com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public boolean setCursorPosition(final int position,
			final VSJdbcStatement jdbcstmt) throws ServerException {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#setLockingHint(java.lang.String)
	 */
	public void setLockingHint(final String hint) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#setObject(int,
	 *      java.lang.Object, int,
	 *      com.versata.tl.vls.dataaccess.connection.VSJdbcStatement)
	 */
	public void setObject(final int index, final Object value,
			final int sqlType, final VSJdbcStatement jdbcstmt)
			throws ServerException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.versata.tl.vls.dataaccess.jdbcdriver.VSJdbcDriver#setTransactionIsolationLevel(int)
	 */
	public void setTransactionIsolationLevel(final int level) {

	}

}