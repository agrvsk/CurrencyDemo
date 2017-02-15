package com.versata.tl.vls.dataaccess;

import com.versata.tl.common.exception.ServerException;
import com.versata.tl.common.meta.VSMetaQuery;
import com.versata.tl.common.meta.VSMetaTable;
import com.versata.tl.common.util.SearchRequest;
import com.versata.tl.vls.core.DataRow;
import com.versata.tl.vls.dataaccess.connection.Connection;
import com.versata.tl.vls.dataaccess.connection.VSJdbc;
import com.versata.tl.vls.dataaccess.connection.VSJdbcStatement;
import com.versata.tl.vls.dataaccess.connection.VSJdbcStatement_Factory;
import com.versata.tl.vls.dataaccess.connection.VSJdbcStatement_TestStub;
import com.versata.tl.vls.dataaccess.connection.VSJdbc_Factory;

public class XDASQLConnector_TestStub extends XDASQLConnector{

    /**
     * @param rs Object
     * @param con Connection
     * @return VSJdbcStatement
     * @throws ServerException
     * @internal.tle
     */
	@Override
    protected VSJdbcStatement getStatement(Object rs, Connection con) throws ServerException {
		return VSJdbcStatement_Factory.createVSJdbcStatementVSJdbc_TestStub();
    }
	
	@Override
	public VSJdbcStatement getInsertPreparedStatement(VSJdbc con, DataRow row) {
		return VSJdbcStatement_Factory.createVSJdbcStatementVSJdbc_TestStub();
	}

	@Override
	public VSJdbcStatement getDeletePreparedStatement(VSJdbc con, DataRow row) {
		return VSJdbcStatement_Factory.createVSJdbcStatementVSJdbc_TestStub();
	}

	@Override
	protected void updateDBWithSingleStatement(DataRow row, VSJdbcStatement statement, boolean checkLob) throws ServerException {
		
	}

	@Override
	protected Object getSequenceNumber(VSMetaTable table, Connection con, DataRow row, String columnName) {
		return new String("test getSequenceNumber string");
	}

	@Override
	public Object getCounter(VSMetaTable table, Connection con, DataRow row, String columnName) throws ServerException {
		return new String("test getSequenceNumber string");
	}

	@Override
	public int getRowCount(VSMetaQuery metaQuery, SearchRequest filter, Connection con) throws ServerException {
		return 0;
	}
	
	@Override
	public VSJdbcStatement getUpdatePreparedStatement(VSJdbc con, DataRow row) {
		return new VSJdbcStatement_TestStub(VSJdbc_Factory.createVSJdbc_TestStub());
	}
	
	@Override
	public boolean usePreparedSelect() {
		return true;
	}
}
