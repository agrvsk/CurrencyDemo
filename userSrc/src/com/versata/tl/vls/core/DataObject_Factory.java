package com.versata.tl.vls.core;

import com.versata.tl.common.exception.ServerSecurityException;

/**
 * The class <code>DataObject_Factory</code> implements static methods that
 * return instances of the class {@link DataObject}.
 * <p>
 * Copyright (c) 2006
 * 
 * @author vkulikov
 * @version $Revision: #1 $
 */
public class DataObject_Factory {

	/**
	 * Prevent creation of instances of this class.
	 * 
	 */
	private DataObject_Factory() {
	}

	/**
	 * Create an instance of the class {@link DataObject}.
	 * 
	 * @return DataObject
	 * @throws ServerSecurityException
	 */
	public static DataObject createdummy() throws ServerSecurityException {

		final DataObject bo = DataObject_Factory.createDataObject();

		final DataRow d = DataRow_Factory.createDataRow();
		final Session s = d.getSession();

		bo.initBusinessObject(s, d);

		return bo;
	}

	/**
	 * Create an instance of the class {@link DataObject}.
	 * 
	 * @return DataObject
	 * @throws ServerSecurityException
	 */
	public static DataObject createDataObject() {

		return new DataObject();
	}
}
