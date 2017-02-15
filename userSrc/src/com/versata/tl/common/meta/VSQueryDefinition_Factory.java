package com.versata.tl.common.meta;

import com.test.util.TestDataConst;
import com.versata.tl.common.util.DataConst;
import com.versata.tl.vls.core.DataRow;

/**
 * The class <code>VSQueryDefinition_Factory</code> implements static methods
 * that return instances of the class {@link VSQueryDefinition}.
 * <p>
 * Copyright (c) 2006
 * 
 * @author vkulikov
 * @version $Revision: #1 $
 */
public class VSQueryDefinition_Factory {

	/**
	 * Prevent creation of instances of this class.
	 * 
	 */
	private VSQueryDefinition_Factory() {
	}

	/**
	 * Create an instance of the class {@link DataRow}.
	 * 
	 * @return DataRow
	 * @throws com.versata.tl.common.exception.ServerSecurityException
	 */
	public static VSQueryDefinition createVSQueryDefinition() {
		final VSQueryDefinition mq = new VSQueryDefinition("AppUser");
		mq.setPackageName("com.versata.tl.vls.admin");

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

		return mq;
	}

    /**
     * Create an instance of the class {@link DataRow}.
     * 
     * @return DataRow
     * @throws com.versata.tl.common.exception.ServerSecurityException
     */
    public static VSQueryDefinition createVSQueryDefinitionForProcess() {
        final VSQueryDefinition mq = new VSQueryDefinition("AppUser");
        mq.setPackageName("com.versata.tl.vls.admin");

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

        c = new VSMetaColumn("RequestID", DataConst.VARCHAR);
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

        return mq;
    }
}
