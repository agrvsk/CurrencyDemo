package com.versata.tl.vls.dataaccess;

import java.util.HashMap;
import java.util.Properties;

import junitx.util.PrivateAccessor;

import com.test.util.TestDataConst;
import com.versata.tl.common.MetaColumn;
import com.versata.tl.common.exception.ServerSecurityException;
import com.versata.tl.common.meta.VSMetaColumn;
import com.versata.tl.vls.core.DataRow;
import com.versata.tl.vls.core.DataRow_Factory;
import com.versata.tl.vls.core.VSORBSessionImpl_Factory;
import com.versata.tl.vls.dataaccess.connection.VSJdbc;
import com.versata.tl.vls.dataaccess.connection.VSJdbcStatement;
import com.versata.tl.vls.dataaccess.connection.VSJdbcStatement_Factory;
import com.versata.tl.vls.dataaccess.connection.VSJdbcStatement_TestStub;

/**
 * The class <code>XDASQLConnector_Factory</code> implements static methods
 * that return instances of the class {@link XDASQLConnector}.
 * 
 * @author akushyn
 * @version $Revision: #2 $
 */
public class XDASQLConnector_Factory {

	public static void init(XDASQLConnector xda) throws ServerSecurityException, NoSuchFieldException {
		final VSJdbcStatement st = VSJdbcStatement_Factory
				.createVSJdbcStatement();
		final VSJdbc con = st.getConnection();
		con.setSession(VSORBSessionImpl_Factory.createVSORBSessionImpl());
		con.inTransition = true;
		con.setIsExternalConnection(true);
		xda.conProperties = new Properties();
		xda.conProperties.put("Use Prepared Update", TestDataConst.POSITIVE);
		xda.aSession = VSORBSessionImpl_Factory.createVSORBSessionImpl();
		final VSJdbcStatement_TestStub obj = new VSJdbcStatement_TestStub(con);
		xda.stmtList.put(obj, obj);
		final int initialCapacity = 1;
		final HashMap modifiedData = new HashMap(
				initialCapacity);
		final MetaColumn col = new MetaColumn("name",
				TestDataConst.POSITIVE_NUMBER, TestDataConst.POSITIVE_NUMBER,
				true);
		final VSMetaColumn mc = new VSMetaColumn(col);
		modifiedData.put(mc, mc);
		final DataRow row = DataRow_Factory.createDataRow2();
		PrivateAccessor.setField(row, "modifiedData", modifiedData);
		con.preparedStatements.put(xda, "AppUserUPDATEname");
	}

    public static void initAsTestStub(XDASQLConnector xda) throws ServerSecurityException, NoSuchFieldException {
        final VSJdbcStatement st = VSJdbcStatement_Factory
        .createVSJdbcStatementVSJdbc_TestStub();
        final VSJdbc con = st.getConnection();
        con.setSession(VSORBSessionImpl_Factory.createVSORBSessionImpl());
        con.inTransition = true;
        con.setIsExternalConnection(true);
        xda.conProperties = new Properties();
        xda.conProperties.put("Use Prepared Update", TestDataConst.POSITIVE);
        xda.aSession = VSORBSessionImpl_Factory.createVSORBSessionImpl();
        final VSJdbcStatement_TestStub obj = new VSJdbcStatement_TestStub(con);
        xda.stmtList.put(obj, obj);
        final int initialCapacity = 1;
        final HashMap modifiedData = new HashMap(
                initialCapacity);
        final MetaColumn col = new MetaColumn("name",
                TestDataConst.POSITIVE_NUMBER, TestDataConst.POSITIVE_NUMBER,
                true);
        final VSMetaColumn mc = new VSMetaColumn(col);
        modifiedData.put(mc, mc);
        final DataRow row = DataRow_Factory.createDataRow3();
        PrivateAccessor.setField(row, "modifiedData", modifiedData);
        con.preparedStatements.put(xda, "AppUserUPDATEname");
    }
	/**
	 * Method createXDASQLConnector2.
	 * 
	 * @return XDASQLConnector
	 * @throws ServerSecurityException
	 * @throws NoSuchFieldException
	 */
	public static XDASQLConnector createXDASQLConnector()
			throws ServerSecurityException, NoSuchFieldException {
        final XDASQLConnector xda = new XDASQLConnector();
		init(xda);
		return xda;
	}

	/**
	 * Method createXDASQLConnector2.
	 * 
	 * @return XDASQLConnector
	 * @throws ServerSecurityException
	 * @throws NoSuchFieldException
	 */
	public static XDASQLConnector_TestStub createXDASQLConnectorTestStub()
			throws ServerSecurityException, NoSuchFieldException {
        final XDASQLConnector_TestStub xda = new XDASQLConnector_TestStub();
		initAsTestStub(xda);
		return xda;
	}

	/**
	 * Prevent creation of instances of this class.
	 * 
	 */
	private XDASQLConnector_Factory() {
	}
}