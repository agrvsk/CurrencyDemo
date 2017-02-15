package com.versata.tl.common;

/**
 * The class <code>QueryRequest_Factory</code> implements static methods that
 * return instances of the class {@link QueryRequest}.
 * <p>
 * Copyright (c) 2006
 * 
 * @author vkulikov
 * @version $Revision: #1 $
 */
public class QueryRequest_Factory {

	/**
	 * Prevent creation of instances of this class.
	 * 
	 */
	private QueryRequest_Factory() {
	}

	/**
	 * Create an instance of the class {@link QueryRequest}.
	 * 
	 * @return QueryRequest
	 */
	public static QueryRequest createQueryRequest() {
		return new QueryRequest();
	}
}