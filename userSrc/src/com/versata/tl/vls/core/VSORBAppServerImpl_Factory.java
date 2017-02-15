package com.versata.tl.vls.core;

import com.test.util.Thread_Stub;

/**
 * The class <code>VSORBAppServerImpl_Factory</code> implements static methods
 * that return instances of the class {@link VSORBAppServerImpl}.
 * <p>
 * Copyright (c) 2006
 * 
 * @author vkulikov
 * @version $Revision: #1 $
 */
public class VSORBAppServerImpl_Factory {

	/**
	 * Prevent creation of instances of this class.
	 * 
	 */
	private VSORBAppServerImpl_Factory() {
	}

	/**
	 * Create an instance of the class {@link VSORBAppServerImpl}.
	 * 
	 * @return VSORBAppServerImpl
	 */
	public static VSORBAppServerImpl createVSORBAppServerImpl() {

		final VSORBAppServerImpl s = new VSORBAppServerImpl("name");
		Thread_Stub.sessionsMonitorKiller();
		return s;
	}
	/**
	 * Create an instance of the class {@link VSORBAppServerImpl}.
	 * use constuctor VSORBAppServerImpl(String,boolean)
	 * @return VSORBAppServerImpl
	 */
	public static VSORBAppServerImpl createVSORBAppServerImpl1() {

		final VSORBAppServerImpl s = new VSORBAppServerImpl("name",false);
		Thread_Stub.sessionsMonitorKiller();
		return s;
	}
}
