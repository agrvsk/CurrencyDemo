package com.versata.tl.common;

import com.versata.tl.common.exception.ServerSecurityException;
import com.versata.tl.common.vlsobject.VSORBResultSet_Factory;

/**
 * The class <code>QueryResponse_Factory</code> implements static methods that
 * return instances of the class {@link QueryResponse}.
 * <p>
 * Copyright (c) 2006
 * 
 * @author vkulikov
 * @version $Revision: #1 $
 */
public class QueryResponse_Factory {

	/**
	 * Prevent creation of instances of this class.
	 * 
	 */
	private QueryResponse_Factory() {
	}

	/**
	 * Create an instance of the class {@link QueryResponse}.
	 * 
	 * @return QueryResponse
	 * @throws ServerSecurityException
	 * 
	 */
	public static QueryResponse createQueryResponse()
			throws ServerSecurityException {
		final QueryResponse fixture = new QueryResponse();

		fixture.setRS(VSORBResultSet_Factory.createVSORBResultSet());
		fixture.setQueryRequest(QueryRequest_Factory.createQueryRequest());

		return fixture;
	}
}