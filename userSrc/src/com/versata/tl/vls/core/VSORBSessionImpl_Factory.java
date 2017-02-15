package com.versata.tl.vls.core;

import com.versata.tl.vls.transaction.CurrentTransaction;

/**
 * The class <code>VSORBSessionImpl_Factory</code> implements static methods
 * that return instances of the class {@link VSORBSessionImpl}.
 * 
 * @author vkulikov
 * @version $Revision: #1 $
 */
public class VSORBSessionImpl_Factory {

	/**
	 * Prevent creation of instances of this class.
	 * 
	 */
	private VSORBSessionImpl_Factory() {
	}

	/**
	 * Create an instance of the class {@link VSORBSessionImpl}.
	 * 
	 * @return VSORBSessionImpl
	 * @throws com.versata.tl.common.exception.ServerSecurityException
	 */
	public static VSORBSessionImpl createVSORBSessionImpl()
			throws com.versata.tl.common.exception.ServerSecurityException {

		final VSORBSessionImpl s = new VSORBSessionImpl(
				VSORBAppServerImpl_Factory.createVSORBAppServerImpl(), "sa",
				false, true);
		
		s.transactionInfo = new VSTransactionInfo(new CurrentTransaction(true),s,true);
		//This method has been removed
		//s.setPackageName("com.versata.tl.vls.admin");

		return s;
	}
}
