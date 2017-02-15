package com.versata.tl.vls.core;

/**
 * The class <code>VSQueryResultsImpl_Factory</code> implements static methods
 * that return instances of the class {@link VSQueryResultsImpl}.
 * <p>
 * Copyright (c) 2006
 * 
 * @author vkulikov
 * @version $Revision: #1 $
 */
public class VSQueryResultsImpl_Factory {

	/**
	 * Prevent creation of instances of this class.
	 * 
	 */
	private VSQueryResultsImpl_Factory() {
	}

	/**
	 * Create an instance of the class {@link VSQueryResultsImpl}.
	 * 
	 * @return VSQueryResultsImpl
	 * @throws com.versata.tl.common.exception.ServerSecurityException
	 */
	public static VSQueryResultsImpl createVSQueryResultsImpl()
			throws com.versata.tl.common.exception.ServerSecurityException {
		return new VSQueryResultsImpl(Session_Factory.createVSORBSessionImpl());
	}
}
