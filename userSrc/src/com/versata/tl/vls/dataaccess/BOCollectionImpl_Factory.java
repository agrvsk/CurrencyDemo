package com.versata.tl.vls.dataaccess;

import java.util.Vector;

import com.test.util.TestDataConst;
import com.versata.tl.common.meta.VSQueryDefinition;

/**
 * The class <code>BOCollectionImpl_Factory</code> implements static methods
 * that return instances of the class {@link BOCollectionImpl}.
 * 
 * @author akushyn
 * @version $Revision: #1 $
 */
public class BOCollectionImpl_Factory {

	/**
	 * Create an instance of the class {@link BOCollectionImpl}.
	 * 
	 * @return BOCollectionImpl
	 * @throws com.versata.tl.common.exception.ServerException
	 */
	public static BOCollectionImpl createBOCollectionImpl()
			throws com.versata.tl.common.exception.ServerException {
		return new BOCollectionImpl(new Vector().elements(),
				new VSQueryDefinition(TestDataConst.EMPTY));
	}

	/**
	 * Prevent creation of instances of this class.
	 * 
	 */
	private BOCollectionImpl_Factory() {
	}
}