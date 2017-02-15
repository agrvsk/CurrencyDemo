package com.versata.tl.common.vlsobject;

import com.versata.tl.common._tie_VSORBResultSet;
import com.versata.tl.common.meta.VSQueryDefinition;
import com.versata.tl.common.meta.VSQueryDefinition_Factory;
import com.versata.tl.common.util.SearchRequest;
import com.versata.tl.vls.core.VSORBSessionImpl_Factory;
import com.versata.tl.vls.core.VSQueryResultsImpl_Factory;
import com.versata.tl.vls.dataaccess.BOCollectionImpl_Factory;
import com.versata.tl.vls.dataaccess.VSORBResultSetImpl;
import com.versata.tl.vls.dataaccess.XDASQLConnector;
import com.versata.tl.vls.dataaccess.XDASQLConnector_Factory;
import com.versata.tl.vls.dataaccess.connection.VSJdbc;
import com.versata.tl.vls.dataaccess.connection.VSJdbcStatement;
import com.versata.tl.vls.dataaccess.connection.VSJdbcStatement_Factory;

/**
 * The class <code>VSORBResultSet_Factory</code> implements static methods
 * that return instances of the class {@link VSORBResultSet}.
 * <p>
 * Copyright (c) 2006
 * 
 * @author vkulikov
 * @version $Revision: #2 $
 */
public class VSORBResultSet_Factory {

	/**
	 * Prevent creation of instances of this class.
	 * 
	 */
	private VSORBResultSet_Factory() {
	}

	/**
	 * Create an instance of the class {@link VSORBResultSet}.
	 * 
	 * @return VSORBResultSet
	 * @throws com.versata.tl.common.exception.ServerException
	 */
	public static VSORBResultSet createcreateBOCollectionImpl()
			throws com.versata.tl.common.exception.ServerException {
		return BOCollectionImpl_Factory.createBOCollectionImpl();
	}

	/**
	 * Create an instance of the class {@link VSORBResultSet}.
	 * 
	 * @return VSORBResultSet
	 * @throws com.versata.tl.common.exception.ServerSecurityException
	 */
	public static VSORBResultSet createVSORBResultSet()
			throws com.versata.tl.common.exception.ServerSecurityException {
		return new _tie_VSORBResultSet(VSQueryResultsImpl_Factory
				.createVSQueryResultsImpl());
	}

	/**
	 * Create an instance of the class {@link VSORBResultSet}.
	 * 
	 * @return VSORBResultSet
	 * @throws com.versata.tl.common.exception.ServerSecurityException
	 * @throws NoSuchFieldException 
	 */
	public static VSORBResultSet createVSORBResultSetImpl()
			throws com.versata.tl.common.exception.ServerSecurityException, NoSuchFieldException {
		final VSJdbcStatement st = VSJdbcStatement_Factory
				.createVSJdbcStatementVSJdbc_TestStub();
		final VSJdbc con = st.getConnection();
		con.setSession(VSORBSessionImpl_Factory.createVSORBSessionImpl());
		final XDASQLConnector xdac = XDASQLConnector_Factory.createXDASQLConnectorTestStub();
		final VSQueryDefinition metaQuery = VSQueryDefinition_Factory.createVSQueryDefinition();
		final SearchRequest filter = new SearchRequest();
		filter.add("Select * from test");
		final SearchRequest sorter = new SearchRequest();
		final int perFetchRowCount = 0;
		final short columnProjectionLevel = 2;
        return new _tie_VSORBResultSet(new VSORBResultSetImpl(metaQuery,
				filter, sorter, perFetchRowCount, columnProjectionLevel, xdac,
				con));
	}
}