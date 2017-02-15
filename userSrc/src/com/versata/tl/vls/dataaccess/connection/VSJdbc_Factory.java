package com.versata.tl.vls.dataaccess.connection;

/**
 * The class <code>VSJdbc_Factory</code> implements static methods that return
 * instances of the class {@link VSJdbc}.
 * <p>
 * Copyright (c) 2006
 * 
 * @author vkulikov
 * @version $Revision: #1 $
 */
public class VSJdbc_Factory {

	/**
	 * Prevent creation of instances of this class.
	 * 
	 */
	private VSJdbc_Factory() {
	}

	/**
	 * Create an instance of the class {@link VSJdbc_TestStub}.
	 * 
	 * @return VSJdbc
	 */
	public static VSJdbc createVSJdbc() {
		return new VSJdbc();
	}

	/**
	 * Create an instance of the class {@link VSJdbc}.
	 * 
	 * @return VSJdbc
	 */
	public static VSJdbc_TestStub createVSJdbc_TestStub() {
		return new VSJdbc_TestStub();
	}
}
