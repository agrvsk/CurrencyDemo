package com.versata.tl.vls.core;

import java.util.Enumeration;

import com.test.util.TestDataConst;
import com.versata.tl.common.exception.ServerSecurityException;
import com.versata.tl.common.meta.VSMetaColumn;
import com.versata.tl.common.meta.VSMetaTable;
import com.versata.tl.common.meta.VSQueryDefinition;
import com.versata.tl.common.meta.VSQueryDefinition_Factory;
import com.versata.tl.common.util.DataConst;

/**
 * The class <code>DataRow_Factory</code> implements static methods that
 * return instances of the class {@link DataRow}.
 * <p>
 * Copyright (c) 2006
 * 
 * @author vkulikov
 * @version $Revision: #1 $
 */
public class DataRow_Factory {

	/**
	 * Create an instance of the class {@link DataRow}.
	 * 
	 * @return DataRow
	 * @throws com.versata.tl.common.exception.ServerSecurityException
	 */
	public static DataRow createDataRow()
			throws com.versata.tl.common.exception.ServerSecurityException {

		final VSQueryDefinition mq = new VSQueryDefinition("AppUser");
		mq.setPackageName("com.versata.tl.vls.admin");

		final VSMetaTable t = new VSMetaTable("AppUserAll");

		VSMetaColumn c = new VSMetaColumn("AppSvrLoginID", DataConst.VARCHAR);
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNoNulls);
		c.setDefaultValue(TestDataConst.POSITIVE);
		t.addColumn(c);

		c = new VSMetaColumn("AppSvrPassword", DataConst.VARCHAR);
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		c.setDefaultValue(TestDataConst.POSITIVE);
		t.addColumn(c);

		c = new VSMetaColumn("UserName", DataConst.VARCHAR);
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		c.setDefaultValue(TestDataConst.POSITIVE);
		t.addColumn(c);

		c = new VSMetaColumn("DATE", DataConst.DATE); // 4
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		c.setDefaultValue("2000-10-10");
		t.addColumn(c);

		c = new VSMetaColumn("BOOLEAN", DataConst.JAVA_BOOLEAN); // 5
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		c.setDefaultValue("TRUE");
		t.addColumn(c);

		c = new VSMetaColumn("DECIMAL", DataConst.DECIMAL); // 6
		c.setSize(50);
		c.setScale(6);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		c.setDefaultValue(TestDataConst.POSITIVE);
		t.addColumn(c);

		c = new VSMetaColumn("BINARY", DataConst.CHAR); // 7
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		c.setDefaultValue(TestDataConst.POSITIVE);
		t.addColumn(c);

		t.addUniqueKeyColumn("AppUser Unique Key", "AppSvrLoginID");
		t.setStoredColumnName("AppSvrLoginID");
		t.setDisplayColumnName("UserName");
		t.setSchema("BARRY");
		t.setDatabaseName("OnPremise");
		t.useQuotedIdentifier(false);
		t.setOptLock(DataConst.OptLockingOnApplicable);
		t
				.setXDAConnectorClassName("com.versata.tl.vls.admin.AppSrvSecXDAConnector");

		mq.addTable(t);
		mq.populateQCArray();

		final DataRow dr = new DataRow(VSORBSessionImpl_Factory
				.createVSORBSessionImpl(), mq);
		dr.setBusinessObject(DataObject_Factory.createDataObject());

		dr.setInsert();

		return dr;
	}
	
	public static DataRow createDataRowForProcess()
			throws com.versata.tl.common.exception.ServerSecurityException {

		final VSQueryDefinition mq = new VSQueryDefinition("AppUser");
		mq.setPackageName("com.versata.tl.vls.admin");

		final VSMetaTable t = new VSMetaTable("AppUserAll");

		VSMetaColumn c = new VSMetaColumn("AppSvrLoginID", DataConst.VARCHAR);
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNoNulls);
		c.setDefaultValue(TestDataConst.POSITIVE);
		t.addColumn(c);

		c = new VSMetaColumn("AppSvrPassword", DataConst.VARCHAR);
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		c.setDefaultValue(TestDataConst.POSITIVE);
		t.addColumn(c);

		c = new VSMetaColumn("UserName", DataConst.VARCHAR);
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		c.setDefaultValue(TestDataConst.POSITIVE);
		t.addColumn(c);

        c = new VSMetaColumn("State", DataConst.JAVA_BYTE);
        c.setSize(50);
        c.setAlterability(true);
        c.setNullability(VSMetaColumn.columnNullable);
        c.setDefaultValue(TestDataConst.POSITIVE);
        t.addColumn(c);		

		c = new VSMetaColumn("DATE", DataConst.DATE); // 4
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		c.setDefaultValue("2000-10-10");
		t.addColumn(c);

		c = new VSMetaColumn("BOOLEAN", DataConst.JAVA_BOOLEAN); // 5
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		c.setDefaultValue("1");
		t.addColumn(c);

		c = new VSMetaColumn("DECIMAL", DataConst.DECIMAL); // 6
		c.setSize(50);
		c.setScale(6);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		c.setDefaultValue(TestDataConst.POSITIVE);
		t.addColumn(c);

		c = new VSMetaColumn("BINARY", DataConst.CHAR); // 7
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		c.setDefaultValue(TestDataConst.POSITIVE);
		t.addColumn(c);

		t.addUniqueKeyColumn("AppUser Unique Key", "AppSvrLoginID");
		t.setStoredColumnName("AppSvrLoginID");
		t.setDisplayColumnName("UserName");
		t.setSchema("BARRY");
		t.setDatabaseName("OnPremise");
		t.useQuotedIdentifier(false);
		t.setOptLock(DataConst.OptLockingOnApplicable);
		t
				.setXDAConnectorClassName("com.versata.tl.vls.admin.AppSrvSecXDAConnector");

		mq.addTable(t);
		mq.populateQCArray();

		final DataRow dr = new DataRow(VSORBSessionImpl_Factory
				.createVSORBSessionImpl(), mq);
		dr.setBusinessObject(DataObject_Factory.createDataObject());

		dr.setInsert();

		return dr;
	}

	/**
	 * Create an instance of the class {@link DataRow}.
	 * 
	 * @return DataRow
	 * @throws com.versata.tl.common.exception.ServerSecurityException
	 */
	public static DataRow createDataRow3()
			throws com.versata.tl.common.exception.ServerSecurityException {

		final VSQueryDefinition mq = new VSQueryDefinition("AppUser");
		mq.setPackageName("com.versata.tl.vls.admin");

		final VSMetaTable t = new VSMetaTable("AppUserAll");

		//VSMetaColumn c = new VSMetaColumn("AppSvrLoginID", DataConst.VARCHAR);
		VSMetaColumn c = new VSMetaColumn("AppSvrLoginID", DataConst.VARCHAR);
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNoNulls);
		c.setDefaultValue(TestDataConst.POSITIVE);
		c.setAutoIncrement(true);
		c.addProperty("INCREMENT", "3");
		t.addColumn(c);

		c = new VSMetaColumn("AppSvrPassword", DataConst.VARCHAR);
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		c.setDefaultValue(TestDataConst.POSITIVE);
		t.addColumn(c);

		c = new VSMetaColumn("UserName", DataConst.VARCHAR);
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		c.setDefaultValue(TestDataConst.POSITIVE);
		t.addColumn(c);

		c = new VSMetaColumn("DATE", DataConst.DATE); // 4
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		c.setDefaultValue("2000-10-10");
		t.addColumn(c);

		c = new VSMetaColumn("BOOLEAN", DataConst.JAVA_BOOLEAN); // 5
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		c.setDefaultValue("TRUE");
		t.addColumn(c);

		c = new VSMetaColumn("DECIMAL", DataConst.DECIMAL); // 6
		c.setSize(50);
		c.setScale(6);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		c.setDefaultValue(TestDataConst.POSITIVE);
		t.addColumn(c);

		c = new VSMetaColumn("BINARY", DataConst.CHAR); // 7
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		c.setDefaultValue(TestDataConst.POSITIVE);
		t.addColumn(c);

		c = new VSMetaColumn("TIMESTAMP", DataConst.TIMESTAMP); // 8
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		c.setDefaultValue(TestDataConst.POSITIVE);
		t.addColumn(c);

		c = new VSMetaColumn("TIME", DataConst.TIME); // 9
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		c.setDefaultValue(TestDataConst.POSITIVE);
		t.addColumn(c);

		t.addUniqueKeyColumn("AppUser Unique Key", "AppSvrLoginID");
		t.setStoredColumnName("AppSvrLoginID");
		t.setDisplayColumnName("UserName");
		t.setSchema("BARRY");
		t.setDatabaseName("OnPremise");
		t.useQuotedIdentifier(false);
		t.setOptLock(DataConst.OptLockingOnApplicable);
		t.setXDAConnectorClassName("com.versata.tl.vls.admin.AppSrvSecXDAConnector");

		mq.addTable(t);
		mq.populateQCArray();

		final DataRow dr = new DataRow(VSORBSessionImpl_Factory
				.createVSORBSessionImpl(), mq);
		dr.setBusinessObject(DataObject_Factory.createDataObject());

		dr.setInsert();

		return dr;
	}

	/**
	 * Prevent creation of instances of this class.
	 * 
	 */
	private DataRow_Factory() {
	}

	/**
	 * Create an instance of the class {@link DataRow}.
	 * 
	 * @return DataRow
	 * @throws com.versata.tl.common.exception.ServerSecurityException
	 */
	public static DataRow createDataRow2()
			throws com.versata.tl.common.exception.ServerSecurityException {

		final DataRow dr = new DataRow(VSORBSessionImpl_Factory
				.createVSORBSessionImpl(), VSQueryDefinition_Factory
				.createVSQueryDefinition());
		dr.setBusinessObject(DataObject_Factory.createDataObject());

		dr.setInsert();

		return dr;
	}
	
	/**
	 * Create an instance of the class {@link DataRow} for the AppUser DataObject.
	 * 
	 * @return DataRow of type AppUser
	 * @throws com.versata.tl.common.exception.ServerSecurityException
	 */
	public static DataRow createAppUserDataRow()
			throws com.versata.tl.common.exception.ServerSecurityException {
		final VSQueryDefinition mq = new VSQueryDefinition("AppUser");
		mq.setPackageName("com.versata.tl.vls.admin");

		final VSMetaTable t = new VSMetaTable("AppUser");

		VSMetaColumn c = new VSMetaColumn("AppSvrLoginID", DataConst.VARCHAR);
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNoNulls);
		t.addColumn(c);

		c = new VSMetaColumn("AppSvrPassword", DataConst.VARCHAR);
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		t.addColumn(c);

		c = new VSMetaColumn("UserName", DataConst.VARCHAR);
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		t.addColumn(c);
		
		t.addUniqueKeyColumn("AppUser Unique Key", "AppSvrLoginID");
		t.setStoredColumnName("AppSvrLoginID");
		t.setDisplayColumnName("UserName");
		
		t.useQuotedIdentifier(false);
		t.setOptLock(DataConst.OptLockingOnApplicable);
		t
				.setXDAConnectorClassName("com.versata.tl.vls.admin.AppSrvSecDBXDAConnector");

		mq.addTable(t);
		mq.populateQCArray();

		final DataRow dr = new DataRow(VSORBSessionImpl_Factory
				.createVSORBSessionImpl(), mq);
		dr.setBusinessObject(DataObject_Factory.createDataObject());

		dr.setInsert();

		return dr;
		
	}
	/**
	 * Create an instance of the class {@link DataRow} for the AppDataSourceLocation DataObject.
	 * 
	 * @return DataRow of type AppDataSourceLocation
	 * @throws com.versata.tl.common.exception.ServerSecurityException
	 */
	public static DataRow createAppDataSourceLocationDataRow() throws ServerSecurityException	{
		VSQueryDefinition q = new VSQueryDefinition("AppDataSourceLocation");
		q.setPackageName("com.versata.tl.vls.admin");
        VSMetaTable t = new VSMetaTable("AppDataSourceLocation");
        VSMetaColumn c = new VSMetaColumn("DSLocationID", DataConst.INTEGER);
        c.setAutoIncrement(true);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNoNulls);
		t.addColumn(c);
		c = new VSMetaColumn("DSLocationName", DataConst.VARCHAR);
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNoNulls);
		t.addColumn(c);
		c = new VSMetaColumn("DSLogin", DataConst.VARCHAR);
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		t.addColumn(c);
		c = new VSMetaColumn("DSPassword", DataConst.VARCHAR);
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		t.addColumn(c);
		c = new VSMetaColumn("DSTypeID", DataConst.INTEGER);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		t.addColumn(c);

		t.addUniqueKeyColumn("AppDataSourceLocation Unique Key", "DSLocationID");

		t.setStoredColumnName("DSLocationID");
		t.setDisplayColumnName("DSLocationName");

		t.setSchema("BARRY");
		t.setDatabaseName("OnPremise");

		t.useQuotedIdentifier(false);
		t.setOptLock(DataConst.OptLockingOnApplicable);

		t.setXDAConnectorClassName("com.versata.tl.vls.admin.AppSrvSecDBXDAConnector");

		q.addTable(t);
		q.populateQCArray();
		final DataRow dr = new DataRow(VSORBSessionImpl_Factory
				.createVSORBSessionImpl(), q);
		dr.setBusinessObject(DataObject_Factory.createDataObject());

		dr.setInsert();

		return dr;
	}
	
	/**
	 * Create an instance of the class {@link DataRow} for the AppRole DataObject.
	 * 
	 * @return DataRow of type AppRole
	 * @throws com.versata.tl.common.exception.ServerSecurityException
	 */
	public static DataRow createAppRoleDataRow() throws ServerSecurityException	{
		 VSQueryDefinition q = new VSQueryDefinition("AppRole");
	        q.setPackageName("com.versata.tl.vls.admin");
	        VSMetaTable t = new VSMetaTable("AppRole");
	        //{{META_QUERY_COLUMN_CTOR
	        VSMetaColumn c = new VSMetaColumn("RoleID", DataConst.INTEGER);
	        c.setAutoIncrement(true);
	        c.setAlterability(true);
	        c.setNullability(VSMetaColumn.columnNoNulls);
	        t.addColumn(c);
	        c = new VSMetaColumn("RoleName", DataConst.VARCHAR);
	        c.setSize(50);
	        c.setAlterability(true);
	        c.setNullability(VSMetaColumn.columnNoNulls);
	        t.addColumn(c);
	        c = new VSMetaColumn("Connecter", DataConst.BIT);
	        c.setAlterability(true);
	        c.setNullability(VSMetaColumn.columnNoNulls);
	        c.setDefaultValue(" True");
	        t.addColumn(c);
	        c = new VSMetaColumn("SecAdmin", DataConst.BIT);
	        c.setAlterability(true);
	        c.setNullability(VSMetaColumn.columnNoNulls);
	        c.setDefaultValue(" False ");
	        t.addColumn(c);
	        c = new VSMetaColumn("SysAdmin", DataConst.BIT);
	        c.setAlterability(true);
	        c.setNullability(VSMetaColumn.columnNoNulls);
	        c.setDefaultValue(" False ");
	        t.addColumn(c);

	        t.addUniqueKeyColumn("AppRole Unique Key", "RoleID");

	        t.setSchema("BARRY");
	        t.setDatabaseName("OnPremise");

	        t.useQuotedIdentifier(false);
	        t.setOptLock(DataConst.OptLockingOnApplicable);

	        t.setXDAConnectorClassName("com.versata.tl.vls.admin.AppSrvSecXDAConnector");
	        q.addTable(t);
	        q.populateQCArray();
	        
	        final DataRow dr = new DataRow(VSORBSessionImpl_Factory
					.createVSORBSessionImpl(), q);
			dr.setBusinessObject(DataObject_Factory.createDataObject());

			dr.setInsert();

			return dr;
	}

	/**
	 * Create an instance of the class {@link DataRow} for the AppUser DataObject.
	 * 
	 * @return DataRow of type AppUser
	 * @throws com.versata.tl.common.exception.ServerSecurityException
	 */
	public static DataRow createVirtualDataRow()
	throws com.versata.tl.common.exception.ServerSecurityException {

		final VSQueryDefinition mq = new VirtualVSMetaQuery("AppUser");
		mq.setPackageName("com.versata.tl.vls.admin");
		mq.hasVirtualField();

		final VSMetaTable t = new VSMetaTable("AppUser");

		VSMetaColumn c = new VSMetaColumn("AppSvrLoginID", DataConst.VARCHAR);
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNoNulls);
		c.setDefaultValue(TestDataConst.POSITIVE);
		t.addColumn(c);

		c = new VSMetaColumn("AppSvrPassword", DataConst.VARCHAR);
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		c.setDefaultValue(TestDataConst.POSITIVE);
		t.addColumn(c);

		c = new VSMetaColumn("UserName", DataConst.VARCHAR);
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		c.setDefaultValue(TestDataConst.POSITIVE);
		t.addColumn(c);

		c = new VSMetaColumn("DATE", DataConst.DATE); // 4
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		c.setDefaultValue("2000-10-10");
		t.addColumn(c);

		c = new VSMetaColumn("BOOLEAN", DataConst.JAVA_BOOLEAN); // 5
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		c.setDefaultValue("TRUE");
		t.addColumn(c);

		c = new VSMetaColumn("DECIMAL", DataConst.DECIMAL); // 6
		c.setSize(50);
		c.setScale(6);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		c.setDefaultValue(TestDataConst.POSITIVE);
		t.addColumn(c);

		c = new VSMetaColumn("BINARY", DataConst.CHAR); // 7
		c.setSize(50);
		c.setAlterability(true);
		c.setNullability(VSMetaColumn.columnNullable);
		c.setDefaultValue(TestDataConst.POSITIVE);
		t.addColumn(c);

		t.addUniqueKeyColumn("AppUser Unique Key", "AppSvrLoginID");
		t.setStoredColumnName("AppSvrLoginID");
		t.setDisplayColumnName("UserName");
		t.setSchema("BARRY");
		t.setDatabaseName("OnPremise");
		t.useQuotedIdentifier(false);
		t.setOptLock(DataConst.OptLockingOnApplicable);
		t
				.setXDAConnectorClassName("com.versata.tl.vls.admin.AppSrvSecXDAConnector");

		mq.addTable(t);
		mq.populateQCArray();

		final DataRow dr = new DataRow(VSORBSessionImpl_Factory
				.createVSORBSessionImpl(), mq);
		dr.setBusinessObject(DataObject_Factory.createDataObject());

		dr.setInsert();

		return dr;
	}	

	
}

/**
 * VirtualVSMetaQuery
 * @author Think.Li
 *
 */
class VirtualVSMetaQuery extends VSQueryDefinition{
	private static final long serialVersionUID = 5259959268893040985L;

	public VirtualVSMetaQuery(String newQueryName) {
		super(newQueryName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Get virtual field tableAliases
	 */
    public Enumeration getVirtualFieldTableAliases() {
        return getTableAliases();
    }
    
    /**
     * Check if has Virtual field
     */
    public boolean hasVirtualField() {
        return true;
    }
	
}