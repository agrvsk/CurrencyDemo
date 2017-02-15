package com.versata.tl.vls.core;

/**
 * The class <code>Session_Factory</code> implements static methods that
 * return instances of the class {@link Session}.
 * <p>
 * Copyright (c) 2006
 * 
 * @author vkulikov
 * @version $Revision: #1 $
 */
public class Session_Factory {

	/**
	 * Prevent creation of instances of this class.
	 * 
	 */
	private Session_Factory() {
	}

	/**
	 * Create an instance of the class {@link Session}.
	 * 
	 * @return Session
	 * @throws com.versata.tl.common.exception.ServerSecurityException
	 */
	public static Session createVSORBSessionImpl()
			throws com.versata.tl.common.exception.ServerSecurityException {
		return VSORBSessionImpl_Factory.createVSORBSessionImpl();
	}
}
