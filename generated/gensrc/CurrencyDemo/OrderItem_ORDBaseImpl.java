 
//{{COMPONENT_IMPORT_STMTS

package  CurrencyDemo;

import java.lang.reflect.Field;
import java.util.*;

import com.versata.tl.api.logging.*;
import com.versata.tl.common.businessobject.*;
import com.versata.tl.common.exception.ServerException;
import com.versata.tl.common.meta.*;
import com.versata.tl.common.text.*;
import com.versata.tl.common.util.*;
import com.versata.tl.common.vlsobject.*;
import com.versata.tl.common.vstrace.*;
import com.versata.tl.vls.admin.*;
import com.versata.tl.vls.cache.*;
import com.versata.tl.vls.core.*;
import com.versata.tl.vls.dataaccess.*;
import com.versata.tl.vls.dataaccess.connection.*;
import com.versata.tl.vls.process.*;
import com.versata.tl.vls.service.*;
import java.math.*;
import com.versata.tl.util.VLSConfigProps;
import com.versata.tl.vls.core.VSORBSessionImpl; 
import CurrencyDemo.Currency_CURBaseImpl;
import CurrencyDemo.Currency_CURImpl;
					
import CurrencyDemo.OrderBacklogPerMonth_OBTBaseImpl;
import CurrencyDemo.OrderBacklogPerMonth_OBTImpl;
					

//END_COMPONENT_IMPORT_STMTS}}

/**
* Enforces rules, in conjunction with [designated] Super, Event Handling sub, and methods invoked from rules.
* Instances are instantiated by BRMS runtime by decomposing Query Model updates.
* After rule enforcement, instances remain in transaction cache until end transaction,
*   when they are flushed to disk by their XDA.
*  
*/
 public abstract class OrderItem_ORDBaseImpl extends DataObject {
    
    public static VersataLogger logger = VersataLogger.getLogger(OrderItem_ORDImpl.class);
    
    protected OrderItem_ORDBaseImpl() {
			addListeners();
		
	
	}
	
	//{{COMPONENT_META_QRY
	
	// Cache support. 
	
	/**
	 * @deprecated This field will be made private in a subsequent release
	 */
	public static int cacheSize = 0;
	
	/**
	 * @deprecated This field will be made private in a subsequent release
	 */
	public static long expires = -1;
	
	/**
	 * @deprecated This field will be made private in a subsequent release
	 */
	public static boolean initialized = false;

    /**
     * The default cache size for enumerations. Override by setting the 'CacheSize'
     * extended property on the DataModel Deployment tab at design time or by
     * setting a property of the same name in the extended application object 
     * properties via the VLSConsole. The console-maintained properties have precedence
     * over the workbench and the workbench-maintain properties have precedence over 
     * the defaults.  If you do NOT want your enumerations cached, set the CacheSize
     * extended property in the workbench to 0.
     */
    public final static int DEFAULT_ENUMERATION_CACHE_SIZE = 1000;
    
    /**
     * The default cache expiration time for enumerations in milliseconds. -1 means the data
     * never expires. Override by setting the 'ExpirationMillis'
     * extended property on the DataModel Deployment tab at design time or by
     * setting a property of the same name in the extended application object 
     * properties via the VLSConsole. The console-maintained properties have precedence
     * over the workbench and the workbench-maintain properties have precedence over 
     * the defaults.  If you DO want your enumerations to expire, set the ExpirationMillis
     * extended property in the workbench to the required timeout value.
     */
    public final static int DEFAULT_ENUMERATION_CACHE_EXPIRY = -1;

    /**
     * The name of the extended propery which controls the maximim global cache size
     * for this DataModel. Cached objects are evicted on a Least Recently Used basis if
     * the cache becomes full.   
     */
    
    public static final String cacheSizeProp = "CacheSize";
    
    /**
     * The name of the extended propery which controls the global cache expiration
     * time. Object that have been in the cache longer than the period specified are
     * evicted and a cache miss is reported.  
     */
    public static final String cacheExpirationProp = "ExpirationMillis";

	//Important to initialize all the static data before the static block
	
	private static boolean __isEnumeration;
	public static final String pkCheckProp = "DontPerformPrimaryKeyCheck"; 
	public static final String uniqueCheckProp = "DontPerformUniqueKeyCheck"; 	
	private static int inheritanceType = com.versata.tl.vls.core.InheritanceType.NONE;
	private static int storageOption = com.versata.tl.vls.core.StorageOptions.STORE_ALONE;
	private static String modelName = "OrderItem_ORD";
	private static String repositoryName = ServerEnvironment_Base.getVLSConfigProjectName();
	private static VSQueryDefinition  vsQueryDefinition;
	private static VSQueryDefinition  vsSubObjectQueryDefinition;
	
	
		private static boolean useSubObjSQL = false;
				
		private static String superDataModelName = null;
		private static String typeIndicatorValue = null;
		private static String typeIndicatorAttributeName = null;
		private static int typeIndicatorAttributeDataType = 0;
	
	
	private static List myPrimaryKeyAttributes;
	
	static {	
	        if (logger.isDebugEnabled())
			logger.debug("Initializing OrderItem_ORD");
		
		vsQueryDefinition= new VSQueryDefinition( "OrderItem_ORD" );
		vsQueryDefinition.setPackageName("CurrencyDemo");
		vsQueryDefinition.setRepositoryName(repositoryName);
		vsQueryDefinition.setDataObject(true);	
		
		
		
		
		VSMetaColumn c = null;
		VSMetaTable tableForSubObjRetQry = new VSMetaTable("OrderItem_ORD");
		
		//{{META_QUERY_COLUMN_CTOR
		
		
		
			c = new VSMetaColumn("ORD_Client", DataConst.VARCHAR);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setSize(5);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setDefaultValue("'1'");
			c.setCaption("");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("ORD_OrderId", DataConst.BIGINT);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.PK);
			c.setAutoIncrement(true);
			c.setAlterability(false);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setCaption("OrderId");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("ORD_Month", DataConst.CHAR);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setSize(3);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setDefaultValue("'1'");
			c.setCaption("Month");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("ORD_CurrencyCode", DataConst.CHAR);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setSize(3);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setDefaultValue("'SEK'");
			c.setCaption("CurrencyCode");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("ORD_AmountInLocalCurrency", DataConst.DECIMAL);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setSize(10);
			c.setScale(2);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setDefaultValue("100");
			c.setCaption("AmountInLocalCurrency");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("ORD_AmountInUSD", DataConst.DECIMAL);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setSize(10);
			c.setScale(2);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setComputed (true);
			c.setCaption("AmountInUSD");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("ORD_ExchangeRate", DataConst.DECIMAL);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setSize(10);
			c.setScale(4);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setComputed (true);
			c.setCaption("");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("ORD_Approved", DataConst.VARCHAR);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setSize(3);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setCaption("Approved");
			c.setCodeTable("CurrencyDemo.Z_YesNo");
		tableForSubObjRetQry.addColumn( c );
			
    			
		VSMetaTable t = getTableForObjRetQuery(tableForSubObjRetQry);
		t.addUniqueKeyColumn( "OrderItem_ORD Unique Key", "ORD_OrderId" );
		  tableForSubObjRetQry.addUniqueKeyColumn( "OrderItem_ORD Unique Key", "ORD_OrderId" );
	


// begin key generation

		StringBuffer associationAttributePairs = null;
						
			
			// child of Currency_CUR(pCURfORD)-OrderItem_ORD(cORDfCUR) (enforced: true)
			associationAttributePairs = new StringBuffer();    // child association info (fkey columns, standard / system Extended Properties)
				
				associationAttributePairs.append("CUR_Client <- ORD_Client ");
				t.addForeignKeyColumn( "Foreign Key To pCURfORD", "ORD_Client" );
				// todo ParentTableForVar
					
				associationAttributePairs.append("CUR_CurrencyCode <- ORD_CurrencyCode ");
				t.addForeignKeyColumn( "Foreign Key To pCURfORD", "ORD_CurrencyCode" );
				// todo ParentTableForVar
				vsQueryDefinition.addRelationshipProperty("Currency_CUR_pCURfORD_OrderItem_ORD",
			         "AssociationAttributePairs", 
			         associationAttributePairs.toString());  // for parentRole: pCURfORD
							
			
			// child of OrderBacklogPerMonth_OBT(pOBTfORD)-OrderItem_ORD(cORDfOBT) (enforced: true)
			associationAttributePairs = new StringBuffer();    // child association info (fkey columns, standard / system Extended Properties)
				
				associationAttributePairs.append("OBT_Client <- ORD_Client ");
				t.addForeignKeyColumn( "Foreign Key To pOBTfORD", "ORD_Client" );
				// todo ParentTableForVar
					
				associationAttributePairs.append("OBT_Month <- ORD_Month ");
				t.addForeignKeyColumn( "Foreign Key To pOBTfORD", "ORD_Month" );
				// todo ParentTableForVar
				vsQueryDefinition.addRelationshipProperty("OrderBacklogPerMonth_OBT_pOBTfORD_OrderItem_ORD",
			         "AssociationAttributePairs", 
			         associationAttributePairs.toString());  // for parentRole: pOBTfORD
			
	
/*
			<foreach>[[RelationshipExtendedProperties]]
				vsQueryDefinition.addRelationshipProperty("[[ParentTableForVar]]_[[ParentRoleNameInMethod]]_[[ChildTableForVar]]", "[[ExtendedPropertyName]]", "[[ExtendedPropertyValue]]");
				<endforeach>
			<endforeach>
*/

// end  support for key generation
		
		addUniqueConstraintsToMetaTable(t); 
		
		
					t.addForeignKeyColumn( "Foreign Key To Currency_CUR", "ORD_Client" );
					tableForSubObjRetQry.addForeignKeyColumn( "Foreign Key To Currency_CUR", "ORD_Client" );
				
					t.addForeignKeyColumn( "Foreign Key To Currency_CUR", "ORD_CurrencyCode" );
					tableForSubObjRetQry.addForeignKeyColumn( "Foreign Key To Currency_CUR", "ORD_CurrencyCode" );
				
					t.addForeignKeyColumn( "Foreign Key To OrderBacklogPerMonth_OBT", "ORD_Client" );
					tableForSubObjRetQry.addForeignKeyColumn( "Foreign Key To OrderBacklogPerMonth_OBT", "ORD_Client" );
				
					t.addForeignKeyColumn( "Foreign Key To OrderBacklogPerMonth_OBT", "ORD_Month" );
					tableForSubObjRetQry.addForeignKeyColumn( "Foreign Key To OrderBacklogPerMonth_OBT", "ORD_Month" );
				

		
		
			 t.useQuotedIdentifier(false);		
		tableForSubObjRetQry.useQuotedIdentifier(false);		
		t.setOptLock( DataConst.NoOptLocking );
		tableForSubObjRetQry.setOptLock( DataConst.NoOptLocking );
		
		
		
		
		//END_META_QUERY_COLUMN_CTOR}}
	
		vsQueryDefinition.addTable( t );		
		vsQueryDefinition.populateQCArray();
		
		VSQueryDefinition qTemp = null;
		
		if(!"VLSJSFWebConsole".equals("CurrencyDemo"))
			qTemp = (VSQueryDefinition)getMetaQuery( "OrderItem_ORD","CurrencyDemo" );			
							
		if ( qTemp == null ) {			
			vsQueryDefinition.setPartialSQLForDataModel("SELECT OrderItem_ORD.ORD_Client AS ORD_Client, OrderItem_ORD.ORD_OrderId AS ORD_OrderId, OrderItem_ORD.ORD_Month AS ORD_Month, OrderItem_ORD.ORD_CurrencyCode AS ORD_CurrencyCode, OrderItem_ORD.ORD_AmountInLocalCurrency AS ORD_AmountInLocalCurrency, OrderItem_ORD.ORD_AmountInUSD AS ORD_AmountInUSD, OrderItem_ORD.ORD_ExchangeRate AS ORD_ExchangeRate, OrderItem_ORD.ORD_Approved AS ORD_Approved FROM <dbschema>.OrderItem_ORD OrderItem_ORD", storageOption, inheritanceType, repositoryName, modelName);
			addMetaQuery(vsQueryDefinition, "CurrencyDemo");
		}					
		else {
			vsQueryDefinition = qTemp;	// Keep the old query as it has cached object
		}
			
			
			
	  		
	//END_COMPONENT_META_QRY}}

	//{{COMPONENT_RULES
		
	t.setDerivationType("ORD_Client", VSMetaColumn.derivationDefault);
			tableForSubObjRetQry.setDerivationType("ORD_Client", VSMetaColumn.derivationDefault);
		  t.setDerivationType("ORD_Month", VSMetaColumn.derivationDefault);
			tableForSubObjRetQry.setDerivationType("ORD_Month", VSMetaColumn.derivationDefault);
		  t.setDerivationType("ORD_CurrencyCode", VSMetaColumn.derivationDefault);
			tableForSubObjRetQry.setDerivationType("ORD_CurrencyCode", VSMetaColumn.derivationDefault);
		  t.setDerivationType("ORD_AmountInLocalCurrency", VSMetaColumn.derivationDefault);
			tableForSubObjRetQry.setDerivationType("ORD_AmountInLocalCurrency", VSMetaColumn.derivationDefault);
		  t.setDerivationType("ORD_AmountInUSD", VSMetaColumn.derivationFormula);
			tableForSubObjRetQry.setDerivationType("ORD_AmountInUSD", VSMetaColumn.derivationFormula);
		  t.setDerivationType("ORD_ExchangeRate", VSMetaColumn.derivationReplicate);
			tableForSubObjRetQry.setDerivationType("ORD_ExchangeRate", VSMetaColumn.derivationReplicate);
		  
	  		String dpndsOn = "";
		  
	  
	  
	  
	   dpndsOn = "ORD_AmountInUSD";
		     t.addDependency(dpndsOn, "ORD_AmountInLocalCurrency");
		 	tableForSubObjRetQry.addDependency(dpndsOn, "ORD_AmountInLocalCurrency"); 
		      t.addDependency(dpndsOn, "ORD_ExchangeRate");
		 	tableForSubObjRetQry.addDependency(dpndsOn, "ORD_ExchangeRate"); 
		  
	  
	  	
	  
	  
	  
	  
	  
	  
	  CurrencyDemo.Z_YesNoBaseImpl.setIsEnumeration(true);
		  
	  	}
	
	private static VSMetaTable getTableForObjRetQuery(VSMetaTable t) {

		VSMetaTable newMetaTable = new VSMetaTable("OrderItem_ORD");
		
		Enumeration metaColumns = t.getMetaColumns();
		while(metaColumns.hasMoreElements()) {
			VSMetaColumn col = (VSMetaColumn) metaColumns.nextElement();
			if(col.getColumnClassification() != VSMetaColumn.SUB) {
				newMetaTable.addColumn(col);
			}
		}
		
		return newMetaTable;
	}
	
	private static void addUniqueConstraintsToMetaTable(VSMetaTable t) {
		String uniqueConstraints = "";
		StringTokenizer eachUniqueConstraint = new StringTokenizer(uniqueConstraints, ";");
		while(eachUniqueConstraint.hasMoreTokens()) {
			String token = eachUniqueConstraint.nextToken();
			int indexOfHash = token.indexOf('*');
			String keyName = token.substring(0, indexOfHash);
			StringTokenizer tokens = new StringTokenizer(token.substring(indexOfHash + 1), ",");
			while(tokens.hasMoreTokens()) {
				t.addInheritanceUniqueKeyColumn(keyName, tokens.nextToken());
			}
			
		}
	}	
	   
	   
	   //////////////////////// Inheritance related - start
	
	public String getPackageName() {
		return "CurrencyDemo";
	}


	
	   
	   //protected void handlers

		protected void OrderItem_ORD_afterCommit(Session session) {
			
		}

		protected void OrderItem_ORD_afterDelete(DataObject obj) {

		}

		protected void OrderItem_ORD_afterInsert(DataObject obj) {

		}

		protected void OrderItem_ORD_afterRollback(Session session) {

		}

		protected void OrderItem_ORD_afterUpdate(DataObject obj) {

		}

		protected void OrderItem_ORD_beforeCommit(Session session, Response resp) {

		}

		protected void OrderItem_ORD_beforeDelete(DataObject obj, Response resp) {

		}

		protected void OrderItem_ORD_beforeInsert(DataObject obj, Response resp) {

		}

		protected void OrderItem_ORD_beforeRollback(Session session) {

		}

		protected void OrderItem_ORD_beforeUpdate(DataObject obj, Response resp) {

		}

		protected void OrderItem_ORD_beginTrans(Session session) {

		}
		
		
	   public String get_VSTypeIndicatorAttribute() {
			return typeIndicatorAttributeName;
		}

		public int get_VSTypeIndicatorAttributeDataType() {
			return typeIndicatorAttributeDataType;
		}
		
		public String get_VSTypeIndicatorAttrColumnData()
		{
			return null;
		}
		
		public void set_VSTypeIndicatorAttrColumnData(){
			//Dummy Method : No Inheritance used.
		}
		
		public List getPrimaryKeyAttributes() {
			if(myPrimaryKeyAttributes != null) {
				return myPrimaryKeyAttributes;
			}
			
			myPrimaryKeyAttributes = new ArrayList();
			VSMetaTable table = vsQueryDefinition.getChildMostTable();;
			Enumeration metaColumns = table.getMetaColumns();
			while(metaColumns.hasMoreElements()) {
				VSMetaColumn col = (VSMetaColumn) metaColumns.nextElement();
				if(col.getColumnClassification() == VSMetaColumn.PK) {
					myPrimaryKeyAttributes.add(col);
				}
			}			
			return myPrimaryKeyAttributes;
		}
		
	
	
	

	
	
	
	
		public String get_VSModelName() {
			return modelName;
		}

		public String get_VSRepositoryName() {
			return repositoryName;
		}

		public String get_VSParentDO() {
			return superDataModelName;
		}

		public String get_VSTypeIndicatorValue() {
			return typeIndicatorValue;
		}				

		public int get_VSInheritance(){        
			return inheritanceType;
		}		

		public int get_VSStorageOption(){        
			return storageOption;
		}

		public List getSplitDataObjectsForCommit() {
			if(get_VSStorageOption() == StorageOptions.STORE_WITH_SUB){
				throw new ServerException(ErrorMsgCode.VSMSG_UpdateORInsertOnStoreWithSub, modelName);
			}
			List listOfBOs = new ArrayList();
			List childAttributesIhaveToHandle = new ArrayList();
			List attributesThatWillBeHandledByMyChild = new ArrayList();
			splitLogic(listOfBOs, childAttributesIhaveToHandle, attributesThatWillBeHandledByMyChild);
			return listOfBOs;
		}
	   
	   protected void splitLogic(List listOfBOs, List childAttributesIhaveToHandle, List attributesThatWillBeHandledByMyChild) {		    
			if (storageOption == com.versata.tl.vls.core.StorageOptions.STORE_ALONE)        {
			    List attributesIHaveToAdd = new ArrayList();
			    super.splitLogic(listOfBOs, new ArrayList(), attributesIHaveToAdd);
			    attributesIHaveToAdd.addAll(childAttributesIhaveToHandle);
			    attributesIHaveToAdd.addAll(getMyLocalAttributes());

			    //split the data row and get the bo in the list 	            
			    OrderItem_ORDImpl implInstance = new OrderItem_ORDImpl();
			    DataRow newRow = new DataRow(attributesIHaveToAdd, getPrimaryKeyAttributes(), getRow(), vsQueryDefinition, implInstance);
			    if(inheritanceType == InheritanceType.ROOT || inheritanceType == InheritanceType.NONE){
			    	newRow.preInserted(getRow().preInserted());
			    }
			    implInstance.rowData = newRow;
			    listOfBOs.add(implInstance);

			} else if (storageOption == com.versata.tl.vls.core.StorageOptions.STORE_WITH_SUPER) {
			    childAttributesIhaveToHandle.addAll(getMyLocalAttributes());
			    List neverUpdatedList = new ArrayList();
			    super.splitLogic(listOfBOs, childAttributesIhaveToHandle, neverUpdatedList);
			} else if (storageOption == com.versata.tl.vls.core.StorageOptions.STORE_WITH_SUB) {
			    List neverUsedList = new ArrayList();
			    super.splitLogic(listOfBOs, neverUsedList, attributesThatWillBeHandledByMyChild);
			    attributesThatWillBeHandledByMyChild.addAll(childAttributesIhaveToHandle);
			    attributesThatWillBeHandledByMyChild.addAll(getMyLocalAttributes());
			}
		}
		
		private static List myLocalAttributes;
		
		private static List getMyLocalAttributes()
		{
			if(myLocalAttributes != null) {
				return myLocalAttributes;
			}
			
			myLocalAttributes = new ArrayList();			
			
			//populate this list accordingly
			
			Hashtable h = vsQueryDefinition.getTableAliasList();
			Enumeration e = h.keys();
			String tableName = (String)e.nextElement();

			VSMetaTable table = (VSMetaTable) h.get(tableName);
			Enumeration metaColumns = table.getMetaColumns();
			while(metaColumns.hasMoreElements()) {
				VSMetaColumn col = (VSMetaColumn) metaColumns.nextElement();
				if(col.getColumnClassification() == VSMetaColumn.LOCAL) {
					myLocalAttributes.add(col);
				}
			}
			
			return myLocalAttributes;
		}
				
		public void checkUniqueness(boolean isUpdate) {

			if (inheritanceType == com.versata.tl.vls.core.InheritanceType.NONE) {
				return;
			}
	
			super.checkUniqueness(isUpdate);
			
			List listOfMetaKeys = new ArrayList();			
			if(!isUpdate) {
				if (!"true".equals(vsQueryDefinition.getProperty(uniqueCheckProp))) {
					List uniqueKeyList = vsQueryDefinition.getChildMostTable().getInheritanceUniqueKeyList();
					listOfMetaKeys.addAll(uniqueKeyList);
				}
				
				} else {
				if (!"true".equals(vsQueryDefinition.getProperty(uniqueCheckProp))) {
					List uniqueKeyList = vsQueryDefinition.getChildMostTable()
							.getInheritanceUniqueKeyList();
					if(uniqueKeyList != null){
						for (int i = 0; i < uniqueKeyList.size(); i++) {
							VSMetaKey metaKey = (VSMetaKey) uniqueKeyList.get(i);
							if(metaKeyChanged(metaKey)) {
								listOfMetaKeys.add(metaKey);
							}
						}
					}
				}
				
			}
			
			if(listOfMetaKeys.size() > 0) {
				String searchReqString = getStringForSearchRequest(listOfMetaKeys, getMetaQuery(), repositoryName);
				if (searchReqString != null && !"".equals(searchReqString)) {
					SearchRequest key = new SearchRequest();
					key.add(searchReqString);
					VSMetaQuery subQuery = getSubObjectRetrievalMetaQuery();
					if(subQuery == null) {
						subQuery = getMetaQuery();
					}
					synchronized (subQuery) {
					
						subQuery.setValidationQuery(true);
						try {
							if(getObjectByKey(key, getSession()) != null) {
								throw new ServerException(ErrorMsgCode.VSMSG_DuplicateKey, modelName);
							}
						} finally {
								subQuery.setValidationQuery(false);
						}
					}
				}
			}
		}
		
		public List getUnionSqlAttributes() {
			
			if(storageOption == com.versata.tl.vls.core.StorageOptions.STORE_WITH_SUB) {
				List returnList = super.getUnionSqlAttributes();				
				List tempList = getMyLocalAttributes();
				for (int i = 0; i < tempList.size(); i++) {
					returnList.add(((VSMetaColumn)tempList.get(i)).getName());
				}
				return returnList;
			}			
			return new ArrayList();
		}

///////////////////////////// Inheritance related - end

private boolean _cascade_deleted_in_db = false;
	
public boolean isCascadeDeletedInDB() { return _cascade_deleted_in_db; }
	
public void setCascadeDeletedInDB(boolean val) { _cascade_deleted_in_db = val; }

/**
* Returns the component name for this object, excluding the package
* (see getPackageName()).  For example, it returns 'CUSTOMERS' for the
* Sample Database CUSTOMERS Data Object.
*
* @return String : Returns the component name.
*/
public String getComponentName() {
	return "OrderItem_ORD";
}
    
    
    /**	  
* <br>
* MetaQuery on the component. This method returns a class defining
* the meta information of the component.
* @return VSMetaQuery : Meta data info class for the component.
*/
public static VSMetaQuery getMetaQuery() {
	return vsQueryDefinition;
}

/**	  
* <br>
* Sub-object MetaQuery on the component. This method returns a class defining
* the meta information of the sub object retrieval query for the component.
* @return VSMetaQuery : sub-object Meta data info class for the component.
*/
public static VSMetaQuery getSubObjectRetrievalMetaQuery() {
	return vsSubObjectQueryDefinition;
}


/**	  
* <br>
* Constructor for the class OrderItem_ORDBaseImpl.
* @param session object on which the Business object is created.
* @param makeDefaults boolean if true sets the default values in the data elements
*        as defined in the meta data.
*/
public OrderItem_ORDBaseImpl(Session session, boolean makeDefaults) {
	super(session, OrderItem_ORDBaseImpl.getMetaQuery(), makeDefaults);
	
	
	 
		addListeners();
		
}
    
    public OrderItem_ORDBaseImpl(Session session, VSMetaQuery metaQuery, boolean makeDefaults) {
	super(session, metaQuery, makeDefaults);
}

    /**
     * For internal use only - do not call.
     * @internal.tle
     */
    protected Object getFieldValue(Field field) throws IllegalArgumentException, IllegalAccessException {
        return field.get(this);
    }

/**
* 
* Global Caching support.  
* <p>
* A <bold>non-transactional, non-distributed</bold> cache for read-mostly data.
* <p>
* DO NOT USE for core transactional application data objects such as Invoice, Customer, OrderItem.
* <p> 
* Currently this feature is supported for reference data only!  Reference data includes 
* any data model used as an enumeration by another data model, for example code table 
* lookups that map stateCode (CA) to stateName (California).
* 
* Enumerations defined in the workbench will be cached automatically with a maximum cache size of 
* 1000 and no expiration time. Override in the data model that defines the enumeration if necessary.
* 
* Non-enumerated data can also be globally cached. See #cacheSizeProp.
* 
* <h1>Do NOT use this cache for transactional application data objects. The cache is NOT
* transactional and NOT distributed across cluster nodes. It is intended for read-only access ONLY.
* </h1>
*
*/
    
    public static synchronized void initCache() {
	if ( initialized ) return ;
	// first, look in the runtime properties set by the VLSConsole for backward compatability
	com.versata.tl.vls.admin.AppObjectImpl appObject = com.versata.tl.vls.admin.AppObjectImpl.getBusinessObject( repositoryName, "OrderItem_ORD", ServerEnvironment.getServer().getInternalSession());
	String cSize = appObject.getProperties().getProperty(cacheSizeProp);	
	String expire = appObject.getProperties().getProperty(cacheExpirationProp);
	
	// if there is no VLSConsole-maintained property defined or it is empty, 
    // look for extended properties defined in the workbench. VLSConsole returns null
    // property values as '@@NULL@@'
	if (cSize == null || cSize.trim().length() == 0 || cSize.equals("@@NULL@@")) {
	    cSize = vsQueryDefinition.getProperty(cacheSizeProp);
	}
    if (expire == null || expire.trim().length() == 0 || expire.equals("@@NULL@@")) {
	    expire = vsQueryDefinition.getProperty(cacheExpirationProp);
	}	
    
	if ( cSize!=null && cSize.trim().length()!=0 ) {
		cacheSize = Integer.parseInt( cSize );		
	}
	if ( expire!=null && expire.trim().length()!=0 )
		expires = Long.parseLong(expire);

	// if we are an enumeration and there are no explicit cache options in the properties, default to 
	// something sensible for enumerations
	if (cSize == null && __isEnumeration) {
	    cacheSize = DEFAULT_ENUMERATION_CACHE_SIZE;
	}
	if (expire == null && __isEnumeration) {
	    expires = DEFAULT_ENUMERATION_CACHE_EXPIRY;
	}
	
	// remove any previously defined cache
	CacheAgent.getCacheAgent().removeCache( vsQueryDefinition );
    
	if ( cacheSize !=0) {
		CacheManager cm = CacheAgent.getCacheAgent().getCache( vsQueryDefinition );
		cm.setMaxSize( cacheSize );
	}

	initialized = true;
 	if (logger.isDebugEnabled())
 		logger.debug("OrderItem_ORD cache size: " + cacheSize + " expiration " + expires);
}

/**
 * Called by 'consumers' of enumerations when the consumer class is initialized. This is a hint to this class 
 * that means it being used as an enumeration. In most cases, enumerations are 'reference' data - 
 * for example a data model representing country codes & names. In the vast majority of cases we 
 * want to automatically cache this data without having to explicitly set the 'CacheSize' extended
 * property. If you do not want your enums cached, set the CacheSize extended property to 0 in the 
 * workbench.
 */
    
    public synchronized static void setIsEnumeration(boolean isEnumeration) {
    // only (re)initialize the cache if the enumeration hint changes
    if (__isEnumeration != isEnumeration) {
        __isEnumeration = isEnumeration;
        initialized = false;
        initCache();
    }
}

/**	  
* <br>
* Factory method to get objects based on the filter (SeachRequest), which returns
* an enumeration of objects matching the filter.
* @param searchReq as SearchRequest : the filter as a SearchRequest object.
* @param aSession as Session : object to be associated with the objects.
* @return Enumeration of objects matching the filter criteria.
*/
    
    
    public static Enumeration getObjects( SearchRequest searchReq, Session aSession )
	throws ServerException
{
	if (logger.isDebugEnabled()) logger.debug("getObjects " + searchReq + " " + aSession);
	if(inheritanceType == com.versata.tl.vls.core.InheritanceType.NONE || inheritanceType == com.versata.tl.vls.core.InheritanceType.REPL) {
		return getObjectsInternal(searchReq, aSession);
	}
	if(useSubObjSQL) {
		return getObjectsUsingSubObjQueryInternal(searchReq, aSession);
	}
	return getActualObjects(repositoryName, modelName, searchReq, aSession);
}

protected static Enumeration getObjectsUsingSubObjQueryInternal( SearchRequest searchReq, Session aSession )
throws ServerException
{
	if (logger.isDebugEnabled()) logger.debug("getObjectsUsingSubObjQueryInternal " + searchReq + " " + aSession);
	if ( aSession.getSecurityCheck() ) {
		try {
		if (!aSession.getMyPrivilegeToObjectName(DataConst.AppObjectPrivilegeImpl_READ, "OrderItem_ORD", DataConst.AppObjectTypeCodeImpl_BUSINESS_OBJECT)) {
		throw new ServerException(ErrorMsgCode.VSMSG_SecurityNoReadAccess,  new Object[] {"business", "OrderItem_ORD"});
		}
		}
		catch( VSORBException e ) { 
			logger.warn(e);
		}
	}
	
	raiseBeforeQueryEvent( searchReq, aSession );	
	
	XDAConnector xdac = createXDAConnector(aSession);
		
	if (aSession.isTransactionInProgress()) {
		Enumeration e = aSession.getTransactionInfo().getObjects(OrderItem_ORDBaseImpl.getSubObjectRetrievalMetaQuery(), xdac, searchReq);

		Vector dObjs = new Vector();
		while(e.hasMoreElements()) {
			OrderItem_ORDImpl implObj = (OrderItem_ORDImpl) e.nextElement();
			if(implObj == null) {
				continue;
			}
			String tiAttrColData = implObj.get_VSTypeIndicatorAttrColumnData();
			if(tiAttrColData.equals(typeIndicatorValue) || implObj.get_VSTypeIndicatorValue().equals(tiAttrColData)) {
				dObjs.addElement(implObj);
			}
			else {
				dObjs.addElement(getActualObjectByKeyWithoutQueryExec(repositoryName, implObj, tiAttrColData));
			}
		}
		return dObjs.elements();
	} else {
		Vector boList = new Vector();
		Connection con = aSession.getConnection( xdac, true );
		ResultSet rs = new VSORBResultSetImpl( OrderItem_ORDBaseImpl.getSubObjectRetrievalMetaQuery(), searchReq, null, -1 ,DataConst.NONE_LOB, xdac, con );
		raiseAfterQueryEvent( rs );
		DataRow row;
		while (  ( row =  rs.fetch() ) != null )
		{	
			OrderItem_ORDImpl bo = (OrderItem_ORDImpl) row.getComponent();
			if(bo == null) {
				continue;
			}
			String tiAttrColData = bo.get_VSTypeIndicatorAttrColumnData();
			if(tiAttrColData.equals(typeIndicatorValue) || bo.get_VSTypeIndicatorValue().equals(tiAttrColData)) {
				boList.addElement( bo );
			}
			else {
				boList.addElement(getActualObjectByKeyWithoutQueryExec(repositoryName, bo, tiAttrColData));
			}
		}
		rs.close();		
			
		return boList.elements();
	}
}

    /*	
* <br>
* Factory method to get objects based on the filter (SeachRequest), which returns
* an enumeration of objects matching the filter.
* @param searchReq as SearchRequest : the filter as a SearchRequest object.
* @param aSession as Session : object to be associated with the objects.
* @return Enumeration of objects matching the filter criteria.
*/
protected static Enumeration getObjectsInternal( SearchRequest searchReq, Session aSession )
	throws ServerException
{
	if (logger.isDebugEnabled()) logger.debug("getObjectsInternal " + searchReq + " " + aSession);
	if ( aSession.getSecurityCheck() ) {
		try {
		if (!aSession.getMyPrivilegeToObjectName(DataConst.AppObjectPrivilegeImpl_READ, "OrderItem_ORD", DataConst.AppObjectTypeCodeImpl_BUSINESS_OBJECT)) {
		throw new ServerException(ErrorMsgCode.VSMSG_SecurityNoReadAccess,  new Object[] {"business", "OrderItem_ORD"});
		}
		}
		catch( VSORBException e ) { 
			logger.warn(e);
		}
	}

	raiseBeforeQueryEvent( searchReq, aSession );
	
	XDAConnector xdac = createXDAConnector(aSession);
	
	if ( !initialized ) 
		initCache();
		
	if (aSession.isTransactionInProgress()) {
		Enumeration e= aSession.getTransactionInfo().getObjects(OrderItem_ORDBaseImpl.getMetaQuery(), xdac, searchReq);
		Vector boList = new Vector();
		while ( e.hasMoreElements()) {
			OrderItem_ORDImpl bo = (OrderItem_ORDImpl) e.nextElement();
			if(bo != null  && (inheritanceType == com.versata.tl.vls.core.InheritanceType.NONE || inheritanceType == com.versata.tl.vls.core.InheritanceType.REPL) || typeIndicatorValue.equals(bo.get_VSTypeIndicatorAttrColumnData())) {
				boList.addElement( bo );
			}
		}

		// update the global cache if we have one
		if (cacheSize!=0)
		{
			CacheAgent.getCacheAgent().setObjects( OrderItem_ORDBaseImpl.getMetaQuery(), boList, expires );
		}
		return boList.elements();		
	} else {
		Vector boList = new Vector();
		Connection con = aSession.getConnection( xdac, true );
		ResultSet rs = new VSORBResultSetImpl( OrderItem_ORDBaseImpl.getMetaQuery(), searchReq, null, -1 ,DataConst.NONE_LOB, xdac, con );
		raiseAfterQueryEvent( rs );
		DataRow row;
		while (  ( row =  rs.fetch() ) != null )
		{	
			OrderItem_ORDImpl bo = (OrderItem_ORDImpl)row.getComponent();
			if(bo != null && (inheritanceType == com.versata.tl.vls.core.InheritanceType.NONE || inheritanceType == com.versata.tl.vls.core.InheritanceType.REPL) || typeIndicatorValue.equals(bo.get_VSTypeIndicatorAttrColumnData())) {
				boList.addElement( bo );
			}

		}
		rs.close();
		
		// if we have a cache, add the retrieved objects to it
		if ( cacheSize != 0 )
			CacheAgent.getCacheAgent().setObjects( OrderItem_ORDBaseImpl.getMetaQuery(), boList, expires );
			
		return boList.elements();
	}	
}

public static void raiseBeforeQueryEvent( SearchRequest searchReq, Session aSession )	{
        VSTraceHelper tr = VSTrace.IS_ON ? new VSTraceHelper(logger, "OrderItem_ORD.BeforeQuery") : null;
        try {
            beforeQuery( "OrderItem_ORD", searchReq, null , aSession );
        }
	finally {
	    if (  tr != null ) tr.end();
        }
}

public static void raiseAfterQueryEvent( ResultSet rs)	{
        VSTraceHelper tr = VSTrace.IS_ON ? new VSTraceHelper(logger, "OrderItem_ORD.AfterQuery") : null;
        try {
	    afterQuery( rs );
        }
	finally {
	    if (  tr != null ) tr.end();
        }
}

/**	  
* <br>
* Factory method to get objects based on the filter (String), which returns
* an enumeration of objects matching the filter.
* @param filter as SearchRequest : the filter as a String. (e.g. State = 'NY').
* @param s as Session : object to be associated with the objects.
* @return Enumeration of objects matching the filter criteria.
*/

public static Enumeration getObjects(String filter, Session s) {
	SearchRequest searchReq = new SearchRequest();
	searchReq.add(filter);
	return getObjects(searchReq, s);
}
	
/**	  
* <br>
* Factory method to create an object based on the unique key value which 
* returns an object matching the key value.
* @param key as SearchRequest : the key value as a SearchRequest object.
* @param aSession as Session : object to be associated with the objects.
* @return the object matching the Unique key.
*/
public static DataObject getObjectByKey( SearchRequest key, Session aSession )
	throws ServerException
{
	return getObjectByKey(key, aSession, false);
}

/**
 * <br>
 * Factory method to create an object based on the unique key value which 
 * returns an object matching the key value.
 * Provides an option to look for the object only in the global 
 * cache without going to the database
 * @param key as SearchRequest : the key value as a SearchRequest object.
 * @param aSession as Session : object to be associated with the objects.
 * @param cacheOnly as boolean : Whether the object should be looked up only in the cache
 * @return the object matching the Unique key.
 * @throws ServerException
 */
public static DataObject getObjectByKey( SearchRequest key, Session aSession, boolean cacheOnly )
	throws ServerException
{
	if(inheritanceType == com.versata.tl.vls.core.InheritanceType.NONE || inheritanceType == com.versata.tl.vls.core.InheritanceType.REPL) {
		return getObjectByKeyInternal(key, aSession, cacheOnly);
	}
	

	if(useSubObjSQL){
		OrderItem_ORDImpl implObj = (OrderItem_ORDImpl) getObjectByKeyUsingSubObjQueryInternal(key, aSession);
		if(implObj == null) {
			return null;
		}
		String tiAttrColData = implObj.get_VSTypeIndicatorAttrColumnData();
		if(typeIndicatorValue.equals(tiAttrColData) || implObj.get_VSTypeIndicatorValue().equals(tiAttrColData)) {
			return implObj;
		}
		return getActualObjectByKeyWithoutQueryExec(repositoryName, implObj, tiAttrColData);
	} else {
		OrderItem_ORDImpl implObj = (OrderItem_ORDImpl) getObjectByKeyInternal(key, aSession, cacheOnly);
		if(implObj == null) {
			return null;
		}
		
		if(getMetaQuery().isValidationQuery()) {
			//implies that this getObjectByKey has been called by checkUniqueness. No need to get the actual object as the 
			//checkUniquess just needs to check for the existence of the object. Simply return the object found.
			return implObj;
		}
				
		String tiAttrColData = implObj.get_VSTypeIndicatorAttrColumnData();
		if(typeIndicatorValue.equals(tiAttrColData) || implObj.get_VSTypeIndicatorValue().equals(tiAttrColData)) {
			return implObj;
		}
		//Need to call getObjectByKeyInternal method on the class which has the indicator value contained in the row
		return getActualObjectByKey(repositoryName, modelName, tiAttrColData, key, aSession);
	}
}


 /*	  
* <br>
* Factory method to create an object based on the unique key value which 
* returns an object matching the key value.
* @param key as SearchRequest : the key value as a SearchRequest object.
* @param aSession as Session : object to be associated with the objects.
* @return the object matching the Unique key.
*/
protected static DataObject getObjectByKeyInternal( SearchRequest key, Session aSession, boolean cacheOnly )
	throws ServerException
{
	if (logger.isDebugEnabled()) logger.debug("getObjectByKeyInternal " + key + " " + aSession);
	if ( aSession.getSecurityCheck() ) {
		try {
		if (!aSession.getMyPrivilegeToObjectName(DataConst.AppObjectPrivilegeImpl_READ, "OrderItem_ORD", DataConst.AppObjectTypeCodeImpl_BUSINESS_OBJECT)) {
		    throw new ServerException(ErrorMsgCode.VSMSG_SecurityNoReadAccess,  new Object[] {"business", "OrderItem_ORD"});
		}
		}
		catch( VSORBException e ) { 
			logger.warn(e);
		}
	}

	raiseBeforeQueryEvent( key, aSession );
	
	if ( !initialized ) 
		initCache(); 
	
	DataObject anObject = null;
	
	// Check the global cache if we have one.  Note the default implementation of the 
	// cache (HashedCacheManager) ignores the session parameter for lookups.
	if ( cacheSize != 0 )    {
		anObject = CacheAgent.getCacheAgent().getObject( OrderItem_ORDBaseImpl.getMetaQuery(),key.parameterList, aSession);
		if ( logger.isDebugEnabled() ) {
		    logger.debug("Cache " + anObject == null ? "miss" : "hit" + " for key :" + key);
		}
	
		if (anObject!=null)  {			
			anObject.setSession( aSession ); //set current session to this cached object, ensure that object has a active session
			return anObject;
		}
	}

	if (cacheOnly){
	       return null;
	}

	if (aSession.isTransactionInProgress()) {
		anObject = aSession.getTransactionInfo().getObjectByKey(OrderItem_ORDBaseImpl.getMetaQuery(),key);
	} else {		
		anObject = aSession.getObjectByKey(OrderItem_ORDBaseImpl.getMetaQuery(),key);
	}
	
	// if we have a cache and got here, we had a cache miss so add this object to the global cache
	if ( cacheSize != 0 )
		 CacheAgent.getCacheAgent().addObject( OrderItem_ORDBaseImpl.getMetaQuery(),anObject, expires );
		 
	return anObject;
}
protected static DataObject getObjectByKeyUsingSubObjQueryInternal( SearchRequest key, Session aSession )
	throws ServerException
{
	if (logger.isDebugEnabled()) logger.debug("getObjectByKeyUsingSubObjQueryInternal " + key + " " + aSession);
	if ( aSession.getSecurityCheck() ) {
		try {
		if (!aSession.getMyPrivilegeToObjectName(DataConst.AppObjectPrivilegeImpl_READ, "OrderItem_ORD", DataConst.AppObjectTypeCodeImpl_BUSINESS_OBJECT)) {
		    throw new ServerException(ErrorMsgCode.VSMSG_SecurityNoReadAccess,  new Object[] {"business", "OrderItem_ORD"});
		}
		}
		catch( VSORBException e ) { 
			logger.warn(e);
		}
	}

	raiseBeforeQueryEvent( key, aSession );	
	
	DataObject anObject = null;	

	if (aSession.isTransactionInProgress()) {
		anObject = aSession.getTransactionInfo().getObjectByKey(OrderItem_ORDBaseImpl.getSubObjectRetrievalMetaQuery(),key);
	} else {		
		anObject = aSession.getObjectByKey(OrderItem_ORDBaseImpl.getSubObjectRetrievalMetaQuery(),key);
	}
		
	return anObject;
}

 

	  
	  
	  

	  
	  

public void tableConditionActions() {
	
}
	
	
	
	
protected void insert() throws ServerException
{
	// Post Rule Event
	if (logger.isDebugEnabled()) logger.debug("BEFORE_INSERT : " + this);
	postRuleEvent(VLSEvent.BEFORE_INSERT, response.reset());
	
	if (response.rejected()) return;

	this.insert_setAggregateAttrs();
	
	this.insert_setAttrDefaults();
	
	this.insert_setCounterAttrs();
	
	//do the Uniqueness check
	checkUniqueness(false);
	
	saveChildObjs_();
	
	this.insert_checkPrimaryKeyChanges();
    
	this.doParentChecks();

	this.insert_setAttrFormulae();

	this.doCodeTableChecks();

	// Do Column Validation Checks
	this.columnValidationCheck();

	// Do TableConstraintChecks
	this.tableConstraintCheck();
	
	// Now verify that not nullable columns are not null.
	this.doComputedAttrNullCheck();
	
	// At this point all the computations for the object attributes have been made,
	// therefore save the object.	
	this.updateRowImmediate();
	
	this.tableConditionActions();

	this.doChildCascades();

	this.doParentAdjustments();

	// Post Rule Event
	if (logger.isDebugEnabled()) logger.debug("AFTER_INSERT : " + this);
	postRuleEvent(VLSEvent.AFTER_INSERT, null);
	// This concludes the insert procedure.	
}



protected List<String> getServerApps() {
	String serverApps = VLSConfigProps.getInstance().getProperty("server.apps");
	return serverApps != null ? Arrays.asList(serverApps.split(",")) : (List<String>) Collections.EMPTY_LIST;
}

protected boolean isServerApp() {
	VSORBSessionImpl orbSession = (VSORBSessionImpl) this.session;
	return getServerApps().contains(orbSession.getAppName());
}

protected void update() throws ServerException
{
	// Post Rule Event
	if (logger.isDebugEnabled()) logger.debug("BEFORE_UPDATE : " + this);
	postRuleEvent(VLSEvent.BEFORE_UPDATE, response.reset());

	if (response.rejected()) return;

	this.update_doNonAlterabilityCheck();

	//do the Uniqueness check
	checkUniqueness(true);

	saveChildObjs_();

	// Do the parent checks.
	this.doParentChecks();
	
	// Set the formulae values at this point
	this.setFormulaValues();

	this.doCodeTableChecks();

	// Do Column Validation Checks
	this.columnValidationCheck();

	// Do TableConstraintChecks
	this.tableConstraintCheck();
	
	// verify that not nullable columns are not null.
	this.doComputedAttrNullCheck();

	// Compute stored values if not already done
	this.update_computeStoredValues();

	if ( this.isCurrentEvent("RECOMPUTE_DERIVATIONS") && (getGlobalNestLevel() == 1) ) 
	{
		this.RecomputeDerivations();
		this.setFormulaValues();
	}

	// At this point all the computations for the object attributes have been made
	// therefore save the object.
	this.updateRowImmediate();
	
	this.tableConditionActions();

	this.doChildCascades();

	this.doParentAdjustments();
	
	// invalidate the global cache if applicable.
	if(!initialized){
		initCache();
	}
	if ( cacheSize != 0 ) {
		 invalidateCache(vsQueryDefinition.getName(),vsQueryDefinition.getPackageName(), this.getRow().getOldPkeyParams());
	}
	
	// Post Rule Event
	if (logger.isDebugEnabled()) logger.debug("AFTER_UPDATE : " + this);
	postRuleEvent(VLSEvent.AFTER_UPDATE, null);
	// This concludes the update procedure.
}

protected void delete() throws ServerException
{
	// Post Rule Event
	if (logger.isDebugEnabled()) logger.debug("BEFORE_DELETE : " + this);
	postRuleEvent(VLSEvent.BEFORE_DELETE, response.reset());

	if (response.rejected()) return;

	// Remove myself from the parent cache.
		removeMeFrompCURfORDCache();
			removeMeFrompOBTfORDCache();
			
		

	saveChildObjs_();

	// Do Column Validation Checks
	this.columnValidationCheck();

	// Do TableConstraintChecks
	this.tableConstraintCheck();

	if ( !isCascadeDeletedInDB() )
	this.updateRowImmediate();
	
	this.tableConditionActions();

	// Do Child Cascades.
	this.doChildCascades();

	// Do the Parent Adjustment.
	this.doParentAdjustments();

	// invalidate the global cache if applicable.
	if(!initialized){
		initCache();
	}
	if ( cacheSize != 0 ) {
		invalidateCache(vsQueryDefinition.getName(),vsQueryDefinition.getPackageName(), this.getRow().getOldPkeyParams());
	}

	// Post Rule Event
	if (logger.isDebugEnabled()) logger.debug("AFTER_DELETE : " + this);
	postRuleEvent(VLSEvent.AFTER_DELETE, null);
	// This concludes the delete procedure.
}


protected void insert_setAggregateAttrs() throws ServerException
{
	 // Set the default values for the aggregates
		
		
		
		
		
		// Set the default values for the aggregates
		
		
		
		
		
			
}

protected void insert_setAttrDefaults() throws ServerException
{	
		 if ( isNull("ORD_Client") ) 
						
						setORD_Client((String)("1"));
			
			
			
		if ( isNull("ORD_Month") ) 
						
						setORD_Month((String)("1"));
			
			
			
		if ( isNull("ORD_CurrencyCode") ) 
						
						setORD_CurrencyCode((String)("SEK"));
			
			
			
		if ( isNull("ORD_AmountInLocalCurrency") ) 
						
						setORD_AmountInLocalCurrency((new BigDecimal("100")));
			
			
			
		
			
		
	


}

protected void insert_setCounterAttrs_replCase() throws ServerException
{

	
				XDAConnector xdac = getXDAConnector();
				if ( xdac instanceof XDASQLConnector ) {
						VSJdbc jdbc = ( VSJdbc)session.getTransactionInfo().getConnection( xdac);
						if ( XDASQLConnector.requiresPreInsert( jdbc ) )
							this.setFormulaValuesWithoutException();
					}
						// For the counter field set and get the counter value
				Object counter = null;
				
				//Create a new DataRow for PreInsert 	            
				OrderItem_ORDImpl implInstance = new OrderItem_ORDImpl();
				DataRow newRow = new DataRow(getMyLocalAttributes(), getPrimaryKeyAttributes(), getRow(), vsQueryDefinition, implInstance);
	
				if ( xdac instanceof XDASQLConnector ) {
					if ( ( counter = ((XDASQLConnector)xdac).getCounter(OrderItem_ORDBaseImpl.getMetaQuery().getBaseTable("OrderItem_ORD"), 
					   session.getTransactionInfo().getConnection( xdac), newRow,"ORD_OrderId" ) )!= null )	
					   this.setORD_OrderId( ((Long)counter).longValue());
					else {
							Data newData = newRow.getData("ORD_OrderId");
							if(newData == null || newData.getValue() == null){
								throw new ServerException(ErrorMsgCode.VSMSG_IdentityColumnValueNotSet, "ORD_OrderId");
							}							
							
							//since this is an auto-increment column, we need to ensure that the modified flag is not set(for DBs not using sequence)
							getData("ORD_OrderId").setObject(newData.getValue());
							
					}
				}
				else {
					if ( ( counter = xdac.getCounter(OrderItem_ORDBaseImpl.getMetaQuery().getBaseTable("OrderItem_ORD"), 
					   session.getTransactionInfo().getConnection( xdac), newRow ) )!= null )	
					   this.setORD_OrderId( ((Long)counter).longValue());
					else {
							Data newData = newRow.getData("ORD_OrderId");
							if(newData == null || newData.getValue() == null){
								throw new ServerException(ErrorMsgCode.VSMSG_IdentityColumnValueNotSet, "ORD_OrderId");
							}
							//since this is an auto-increment column, we need to ensure that the modified flag is not set(for DBs not using sequence)
							getData("ORD_OrderId").setObject(newData.getValue());
					}
				}
				if(!getRow().preInserted())
					getRow().preInserted(newRow.preInserted());
			
		
		
		
		
		
		
			
	
		
}

protected void insert_setCounterAttrs() throws ServerException
{
	 	
	
	
				XDAConnector xdac = getXDAConnector();
				if ( xdac instanceof XDASQLConnector ) {
						VSJdbc jdbc = ( VSJdbc)session.getTransactionInfo().getConnection( xdac);
						if ( XDASQLConnector.requiresPreInsert( jdbc ) )
							this.setFormulaValuesWithoutException();
					}
				
				// For the counter field set and get the counter value
				Object counter = null;
				

				if ( xdac instanceof XDASQLConnector ) {
					if ( ( counter = ((XDASQLConnector)xdac).getCounter(OrderItem_ORDBaseImpl.getMetaQuery().getBaseTable("OrderItem_ORD"), 
					   session.getTransactionInfo().getConnection( xdac), getRow(),"ORD_OrderId" ) )!= null )	
					   this.setORD_OrderId( ((Long)counter).longValue());

				}
				else {
					if ( ( counter = xdac.getCounter(OrderItem_ORDBaseImpl.getMetaQuery().getBaseTable("OrderItem_ORD"), 
					   session.getTransactionInfo().getConnection( xdac), getRow() ) )!= null )	
					   this.setORD_OrderId( ((Long)counter).longValue());
				}
			
		
		
		
		
		
		
			
		
}



protected void insert_checkPrimaryKeyChanges() throws ServerException
{
	 

    // If the counter changed the pk, we need to update the cache (BUG14568)
    // Typically this is the case with Oracle and DB2 where the counters are
    // backed with database sequences, as opposed to autonumbers 
    int pkChangeCount = 0;
    if (isChanged("ORD_OrderId")) {
        pkChangeCount++;
        }       
    if (pkChangeCount > 0) {
        getSession().getTransactionInfo().save(this, "OrderItem_ORD");
    }
}

protected void doParentChecks() throws ServerException
{
			if (OrderItem_ORDImpl.getMetaQuery() != null && !"pCURfORD".equalsIgnoreCase((OrderItem_ORDImpl.getMetaQuery().getProperty("dontCheckForParent")))) {
					this.parentCheckFor_pCURfORD();
				}
				else {
					if (logger.isDebugEnabled()) logger.debug("Parent check was not performed on: " + this);
				}
			
			 
	    		if (OrderItem_ORDImpl.getMetaQuery() != null && !"pOBTfORD".equalsIgnoreCase((OrderItem_ORDImpl.getMetaQuery().getProperty("dontCheckForParent")))) {
					this.parentCheckFor_pOBTfORD();
				}
				else {
					if (logger.isDebugEnabled()) logger.debug("Parent check was not performed on: " + this);
				}
			
			 
	    
	

}
protected void insert_setAttrFormulae() throws ServerException
{
	
	
	
	
	  // Set the formulae values at this point
				this.setFormulaValues();
}

protected void doCodeTableChecks() throws ServerException
{
	
	  
	  
	  
	  
	  
	  
	  if (!( isNull("ORD_Approved") ))
			{
				if(this.getValue("ORD_Approved").toString().trim().length()>0)
				{
					this.codeTableCheck("ORD_Approved");
				}
			}
		  
	  	
	
}
protected void doComputedAttrNullCheck() throws ServerException
{
	
	
	
	
	
	
	
	
	
	
	
}

protected void doChildCascades() throws ServerException
{
	
}

protected void doParentAdjustments() throws ServerException
{
	// Do the Parent Adjustment.
		// Parent Adjustment for Role pCURfORD(Currency_CUR)-cORDfCUR(OrderItem_ORD) : OrderItem_ORD->> Currency_CUR
			if (OrderItem_ORDImpl.getMetaQuery() != null && !"pCURfORD".equalsIgnoreCase((OrderItem_ORDImpl.getMetaQuery().getProperty("dontCheckForParent")))) {
			   this.parentAdjustmentFor_pCURfORD();
			}
			else {
			   if (logger.isDebugEnabled()) logger.debug("Parent check was not performed on: " + this);
			}
			
		// Parent Adjustment for Role pOBTfORD(OrderBacklogPerMonth_OBT)-cORDfOBT(OrderItem_ORD) : OrderItem_ORD->> OrderBacklogPerMonth_OBT
			if (OrderItem_ORDImpl.getMetaQuery() != null && !"pOBTfORD".equalsIgnoreCase((OrderItem_ORDImpl.getMetaQuery().getProperty("dontCheckForParent")))) {
			   this.parentAdjustmentFor_pOBTfORD();
			}
			else {
			   if (logger.isDebugEnabled()) logger.debug("Parent check was not performed on: " + this);
			}
			
		
	
	

}


protected void update_doNonAlterabilityCheck() throws ServerException
{
	
	// Column Non Alterability check
	
		if ( getGlobalNestLevel() == 1 && isAltered("ORD_OrderId") && !isUpdatedAfterInsert() )
				{		
					raiseException("Attribute 'ORD_OrderId' in Object OrderItem_ORD is not Alterable.");
				}
		
		
		
		
		
		
		
				
}

protected void update_computeStoredValues() throws ServerException
{
	if ( isChanged("ORD_AmountInUSD") )
				getORD_AmountInUSD();

	if ( isChanged("ORD_ExchangeRate") )
				getORD_ExchangeRate();

	
	}

	 
		/**
		 *  Formula based derivation rule for ORD_AmountInUSD
		 *  
		 *  ORD_AmountInLocalCurrency * ORD_ExchangeRate
		 */ 
		protected void setFormulaValues_ORD_AmountInUSD ()
		  {
		  	Data dataVal = null;
			VSTraceHelper tr = null;       	
		  
							try {
			
				tr = VSTrace.IS_ON ? new VSTraceHelper(logger, "VST_RULE_DERIVATION", this.getClass().getName() + "_" + "ORD_AmountInUSD" ) : null;
				if (logger.isDebugEnabled()) logger.debug("Deriving ORD_AmountInUSD");
				
					getORD_AmountInLocalCurrency();
								getORD_ExchangeRate();
								
					setORD_AmountInUSD(this.getORD_AmountInLocalCurrency().multiply(this.getORD_ExchangeRate()));
				
			} 
			catch (Exception ex) {
				handleAttributeFormulaException(ex, "ORD_AmountInUSD");
			} 
			finally {	
				boolean isChanged = isChanged("ORD_AmountInUSD");
				if (isChanged && isServerEventTracingEnabled()) addServerEvent("VST_RULE_FIRE.FORMULA_" + this.getClass().getName() + "." + "ORD_AmountInUSD = " + getData("ORD_AmountInUSD").getString() + " IsChanged = " + isChanged + " Object = " + this.toString(), (String)null, Session.RULE_EVENT);
				if ( tr != null) {
					if (isChanged )  {                 
						tr.set( "VST_RULE_FIRE.FORMULA_" + this.getClass().getName() + "." + "ORD_AmountInUSD = ", getData("ORD_AmountInUSD").getString() );
					}
					tr.end();
				}
			}
		}
			
			
			
	
protected void setFormulaValues()
	{	
	
		
			this.setFormulaValues_ORD_AmountInUSD ();
		  
	}		  
protected void setFormulaValuesWithoutException()
{
	
	VSTraceHelper tr = null;  
	Data dataVal = null;

	tr = VSTrace.IS_ON ? new VSTraceHelper(logger, "VST_RULE_FORMULA", this.getClass().getName() + "_" + "ORD_AmountInUSD") : null;
			try {
				
						getORD_AmountInLocalCurrency();
								getORD_ExchangeRate();
								
					setORD_AmountInUSD(this.getORD_AmountInLocalCurrency().multiply(this.getORD_ExchangeRate()));
				
			} catch (ServerException serverException){
				handleException(serverException);
			} catch (Exception ex) {
				// handleAttributeFormulaException(ex, "ORD_AmountInUSD");
			} finally {
				if ( tr != null ) tr.end();
			}
		
}

public void tableConstraintCheck()
	{
	
	}
			

public void columnValidationCheck() 
{	
		
}




		protected void parentCheckFor_pCURfORD()
	{
		if (logger.isDebugEnabled()) logger.debug("parentCheckFor_pCURfORD " + this.toString());
		VSTraceHelper tr = VSTrace.IS_ON ? new VSTraceHelper(logger, VST_RULE, "parentCheckFor_pCURfORD", "OrderItem_ORD") : null;
	
		try {
		Currency_CURImpl	parent = null;
		boolean		ParentKeyChanged = false;
		boolean		OrphanChildParenting;
		if (( isInserted() || isUpdated() ) && (
			(isChanged("ORD_Client")) || 	(isChanged("ORD_CurrencyCode")) )&&
		 	( !isNull("ORD_Client") && 	!isNull("ORD_CurrencyCode")))
		 	{  if ( isOldNull("ORD_Client") && 	isOldNull("ORD_CurrencyCode"))
		 	OrphanChildParenting = true;
		 	else
					OrphanChildParenting = false;
			if ( isUpdated() && !OrphanChildParenting )
				{
					parent = this.getOldpCURfORD();
					if (( parent != null ) && ( clientInitiatedUpdate() ))
					{
						this.forceOldValue("ORD_ExchangeRate", parent.getData("CUR_ExchangeRate"));
						
						
						
										
					}
					// See if the parent is null.

					if ( parent == null) // No parent found
						ParentKeyChanged = true;
					else
						ParentKeyChanged = false;
				}
			
			// if old parent is not null and this is an update then remove the current 
				// child from the old parents cache of children.
				if ( isUpdated() && ParentKeyChanged == true && parent != null )
					parent.updateCacheForcORDfCUR(this, true); 

				parent = this.getpCURfORD();
				if ( !ParentKeyChanged )
				{
					if ( parent != null )
					{
						
						
							if (parent.isNull("CUR_ExchangeRate"))
								this.setValue("ORD_ExchangeRate", null);
							else
								this.setORD_ExchangeRate(parent.getCUR_ExchangeRate());
							
																		
						// Also at this point add the child to the new parent's cache.
						// This should be done both for update and delete.
						parent.updateCacheForcORDfCUR(this, false);
					}
					else 
					{
						
							this.setValue("ORD_ExchangeRate", null);
							
					}
				}else
				{
					// Which means cascade
					if ( parent != null )
					{
						if ( clientInitiatedUpdate() )
							parent.updateCacheForcORDfCUR(this, false);
						
						
							if (parent.isNull("CUR_ExchangeRate"))
									this.setValue("ORD_ExchangeRate", null);
								else
									this.setORD_ExchangeRate(parent.getCUR_ExchangeRate());
							
							
																		
					}
					else
					{
						if (!OrphanChildParenting)
						{
							
						
							this.setValue("ORD_ExchangeRate", null);
							
							
							this.setValue("ORD_Client", null);	
		 					this.setValue("ORD_CurrencyCode", null);	
		 					
						}
					}
				}
					if ( parent == null )
				{
					raiseException("Currency Code Missing!");
						
				}
				}else{
						if ( isUpdated()  && ( 
						
						(isChanged("ORD_Client")) || 	(isChanged("ORD_CurrencyCode")) )&&
		 	( isNull("ORD_Client") && 	isNull("ORD_CurrencyCode")))
					
						
					{
						parent = this.getOldpCURfORD();

						if ( parent != null )
							parent.updateCacheForcORDfCUR(this, true);

						if (( parent != null ) && ( clientInitiatedUpdate() ))
						{
							this.forceOldValue("ORD_ExchangeRate", parent.getData("CUR_ExchangeRate"));
						
							
						}
						
							this.setValue("ORD_ExchangeRate", null);
							
												
					}
					
				}		
	
			
				
		}
		finally {
		if (tr != null) tr.end(); 
		}
	
	
	}	
	
		protected void parentCheckFor_pOBTfORD()
	{
		if (logger.isDebugEnabled()) logger.debug("parentCheckFor_pOBTfORD " + this.toString());
		VSTraceHelper tr = VSTrace.IS_ON ? new VSTraceHelper(logger, VST_RULE, "parentCheckFor_pOBTfORD", "OrderItem_ORD") : null;
	
		try {
		OrderBacklogPerMonth_OBTImpl	parent = null;
		boolean		ParentKeyChanged = false;
		boolean		OrphanChildParenting;
		if (( isInserted() || isUpdated() ) && ( 
			(isChanged("ORD_Client")) || 	(isChanged("ORD_Month")) )&&
		 	( (!isNull("ORD_Client")) && 	(!isNull("ORD_Month"))
			 ))
			{
				// This would cause the row to be dropped from the old parent if it exist.
				removeMeFrompOBTfORDCache();
				parent = this.getpOBTfORD();
					
				if ( parent == null )
				{
					
						this.autoInsertParentFor_pOBTfORD();
						
				}
				else
				{
					// Add myself to the new parent cache.
					parent.updateCacheForcORDfOBT(this, false);
				}
				
			}
		
		
		
				
		
			
				
		}
		finally {
		if (tr != null) tr.end(); 
		}
	
	
	}	
	



	protected void parentAdjustmentFor_pCURfORD()
	{
		if (logger.isDebugEnabled()) logger.debug("parentAdjustmentFor_pCURfORD OrderItem_ORD");
		VSTraceHelper tr = VSTrace.IS_ON ? new VSTraceHelper(logger, VST_RULE, "parentAdjustmentFor_pCURfORD", "OrderItem_ORD") : null;  
	
		try {
		
		DataObjectWrapper	oldParent = new DataObjectWrapper();
		DataObjectWrapper	newParent = new DataObjectWrapper();

		boolean	childCascadeUpdate = false;
		boolean	childCascadeDelete = false;
		boolean	orphanChildParenting = false;
		boolean 	childReparented	= false;
		
		if ( isUpdated() && ( isChanged("ORD_Client") || 	isChanged("ORD_CurrencyCode")) &&
		 	( (!(isOldNull("ORD_Client"))) && 	(!(isOldNull("ORD_CurrencyCode"))) ))
		{
			if ( !oldParent.isInitialized() )
				oldParent.setDataObject(this.getOldpCURfORD());
			if ( ! oldParent.isObjNull() ) {
				childCascadeUpdate = false;
				childReparented = true;
			}
			else {
				childCascadeUpdate = true;
				childReparented = false;
			}
		}


		if ( isUpdated() && ( isChanged("ORD_Client") || 	isChanged("ORD_CurrencyCode") ) && ( ! ( (!(isOldNull("ORD_Client"))) && 	(!(isOldNull("ORD_CurrencyCode"))) ) ))
		{
			if ( !newParent.isInitialized() )
				newParent.setDataObject(this.getpCURfORD());
			if ( ! newParent.isObjNull() ) orphanChildParenting = true;
			else orphanChildParenting = false;
		}



		if ( isDeleted() && ( (!(isOldNull("ORD_Client"))) && 	(!(isOldNull("ORD_CurrencyCode"))) ))
		{
			if ( !oldParent.isInitialized() )
				oldParent.setDataObject(this.getOldpCURfORD());
			if ( ! oldParent.isObjNull() ) childCascadeDelete = false;
			else childCascadeDelete = true;
		}
	 
		
			
			parentAdjustmentFor_pCURfORDCUR_OrderValueUSD(oldParent, newParent, childCascadeUpdate, childCascadeDelete, orphanChildParenting, childReparented);
		
		
		
			parentAdjustmentFor_pCURfORDCUR_NumberOfOrders(oldParent, newParent, childCascadeUpdate, childCascadeDelete, orphanChildParenting, childReparented);
		
		
		if ( ! oldParent.isObjNull() )
		{
			if ( oldParent.getDataObject().getDirty() )
			{
				oldParent.getDataObject().setUpdate();
				oldParent.getDataObject().executeRules();
			}
		}
		if ( ! newParent.isObjNull() )
		{
			if ( newParent.getDataObject().getDirty() )
			{
				newParent.getDataObject().setUpdate();
				newParent.getDataObject().executeRules();
			}
		}
		
		}
			finally { if ( tr != null ) tr.end(); }
	}


	protected void parentAdjustmentFor_pOBTfORD()
	{
		if (logger.isDebugEnabled()) logger.debug("parentAdjustmentFor_pOBTfORD OrderItem_ORD");
		VSTraceHelper tr = VSTrace.IS_ON ? new VSTraceHelper(logger, VST_RULE, "parentAdjustmentFor_pOBTfORD", "OrderItem_ORD") : null;  
	
		try {
		
		DataObjectWrapper	oldParent = new DataObjectWrapper();
		DataObjectWrapper	newParent = new DataObjectWrapper();

		boolean	childCascadeUpdate = false;
		boolean	childCascadeDelete = false;
		boolean	orphanChildParenting = false;
		boolean 	childReparented	= false;
		
		if ( isUpdated() && ( isChanged("ORD_Client") || 	isChanged("ORD_Month")) &&
		 	( (!(isOldNull("ORD_Client"))) && 	(!(isOldNull("ORD_Month"))) ))
		{
			if ( !oldParent.isInitialized() )
				oldParent.setDataObject(this.getOldpOBTfORD());
			if ( ! oldParent.isObjNull() ) {
				childCascadeUpdate = false;
				childReparented = true;
			}
			else {
				childCascadeUpdate = true;
				childReparented = false;
			}
		}


		if ( isUpdated() && ( isChanged("ORD_Client") || 	isChanged("ORD_Month") ) && ( ! ( (!(isOldNull("ORD_Client"))) && 	(!(isOldNull("ORD_Month"))) ) ))
		{
			if ( !newParent.isInitialized() )
				newParent.setDataObject(this.getpOBTfORD());
			if ( ! newParent.isObjNull() ) orphanChildParenting = true;
			else orphanChildParenting = false;
		}



		if ( isDeleted() && ( (!(isOldNull("ORD_Client"))) && 	(!(isOldNull("ORD_Month"))) ))
		{
			if ( !oldParent.isInitialized() )
				oldParent.setDataObject(this.getOldpOBTfORD());
			if ( ! oldParent.isObjNull() ) childCascadeDelete = false;
			else childCascadeDelete = true;
		}
	 
			
			parentAdjustmentFor_pOBTfORDOBT_OrderValueUSD(oldParent, newParent, childCascadeUpdate, childCascadeDelete, orphanChildParenting, childReparented);
		
		
		
		
		
		if ( ! oldParent.isObjNull() )
		{
			if ( oldParent.getDataObject().getDirty() )
			{
				oldParent.getDataObject().setUpdate();
				oldParent.getDataObject().executeRules();
			}
		}
		if ( ! newParent.isObjNull() )
		{
			if ( newParent.getDataObject().getDirty() )
			{
				newParent.getDataObject().setUpdate();
				newParent.getDataObject().executeRules();
			}
		}
		
		}
			finally { if ( tr != null ) tr.end(); }
	}




	
	protected void parentAdjustmentFor_pOBTfORDOBT_OrderValueUSD( DataObjectWrapper oldParent, DataObjectWrapper newParent, boolean childCascadeUpdate, boolean childCascadeDelete, boolean orphanChildParenting, boolean childReparented)	{
	
		try{
		
					// check the dependent child columns for changes; this will be empty if there is no
			// qualification expression on the parent sum rule.
			final boolean attrsInParentQualifactionChanged = false ;
			 
			 
			final boolean childColToBeSummedChanged = getData("ORD_AmountInUSD").isChanged() || isChanged("ORD_AmountInUSD");
			
			// prevent parent adjustment if we have had executeRules() or save() called 
			// recursively and the child column hasn't changed			
			final boolean changedInThisNestLevel = attrsInParentQualifactionChanged || childColToBeSummedChanged || childReparented || orphanChildParenting;
			    
		if ( isInserted() && changedInThisNestLevel)
			{
				// For the case of insertion it does not matter If the columns involved
				// for both the where clause and the from column in child are virtual.
				// simply set the deltas to new values and mark them as usable
				
		 
					
					if ( !newParent.isInitialized() )
						newParent.setDataObject(this.getpOBTfORD());
					if ( ! newParent.isObjNull() )
						newParent.getDataObject().setAdjust("OBT_OrderValueUSD",getORD_AmountInUSD(), true );
					else
					{
						// Raise an error here
					}
				
				return;
			}
		
			
			
			if ( isDeleted() && ( ! childCascadeDelete ) )
				{
						
						 
							if ( !oldParent.isInitialized() )
									oldParent.setDataObject(this.getOldpOBTfORD());
							if ( ! oldParent.isObjNull() )
									oldParent.getDataObject().setAdjust("OBT_OrderValueUSD",getOldORD_AmountInUSD().multiply(new BigDecimal("-1")),true);
								
							else
							{
								// Raise an error here
							}
						
					
					return;
				}
			
			if ( childCascadeUpdate ) 
			{
				
							BigDecimal	addValue = new BigDecimal("0");
							BigDecimal	subValue = new BigDecimal("0");
							BigDecimal	delta = new BigDecimal("0");
						
						
						 
							 delta = getORD_AmountInUSD().subtract(getOldORD_AmountInUSD());
								if ( delta.compareTo(new BigDecimal("0")) != 0 )
						
							{
								if ( !newParent.isInitialized() )
									newParent.setDataObject(this.getpOBTfORD());
								if ( ! newParent.isObjNull() )
									newParent.getDataObject().setAdjust("OBT_OrderValueUSD",delta, true);
								else
								{
									// Raise an error here
								}
							}
						
					
					return;
				 
			}
			
			else if ( orphanChildParenting )
			{
				
				 
					if ( !newParent.isInitialized() )
						newParent.setDataObject(this.getpOBTfORD());
					if ( ! newParent.isObjNull() )
						newParent.getDataObject().setAdjust("OBT_OrderValueUSD",getORD_AmountInUSD(),true);
					else
					{
						// Raise an error here
					}
				
				return;
			}
			
			else if ( childReparented )
			{
				 
						
						
						 
							if ( !newParent.isInitialized() )
								newParent.setDataObject(this.getpOBTfORD());
							if ( ! newParent.isObjNull() )
								newParent.getDataObject().setAdjust("OBT_OrderValueUSD",getORD_AmountInUSD(),true);
							else
							{
								// Raise an error here
							}

							if ( !oldParent.isInitialized() )
								oldParent.setDataObject(this.getOldpOBTfORD());
							if ( ! oldParent.isObjNull() )
											oldParent.getDataObject().setAdjust("OBT_OrderValueUSD",getOldORD_AmountInUSD().multiply(new BigDecimal("-1")),true);
								
							else
							{
								// Raise an error here
							}
						
					
					return;
				
			}	
			else
			{
				// The regular update with no change in FKey.
				if ( isUpdated() && changedInThisNestLevel)
				{
					
					
								BigDecimal	addValue	= new BigDecimal("0");
								BigDecimal	subValue	= new BigDecimal("0");
								BigDecimal	delta 	= new BigDecimal("0");
							
							
							
									delta = getORD_AmountInUSD().subtract(getOldORD_AmountInUSD());
									if ( delta.compareTo(new BigDecimal("0")) != 0 )
								
								{
									if ( !oldParent.isInitialized() )
										oldParent.setDataObject(this.getOldpOBTfORD());
									if ( ! oldParent.isObjNull() )
										oldParent.getDataObject().setAdjust("OBT_OrderValueUSD",delta, true);
									else
									{
										// Raise an error here
									}
								}
							
						
						return;
					
				}
			}
			
			} catch (Exception ex) {
			 	String dependents[] = {  };
				
				handleAggregateQualificationException(ex, "OBT_OrderValueUSD", "OrderBacklogPerMonth_OBT", dependents);
			}	
		
		} 
	
	protected void parentAdjustmentFor_pCURfORDCUR_OrderValueUSD( DataObjectWrapper oldParent, DataObjectWrapper newParent, boolean childCascadeUpdate, boolean childCascadeDelete, boolean orphanChildParenting, boolean childReparented)	{
	
		try{
		
					// check the dependent child columns for changes; this will be empty if there is no
			// qualification expression on the parent sum rule.
			final boolean attrsInParentQualifactionChanged = false ;
			 
			 
			final boolean childColToBeSummedChanged = getData("ORD_AmountInUSD").isChanged() || isChanged("ORD_AmountInUSD");
			
			// prevent parent adjustment if we have had executeRules() or save() called 
			// recursively and the child column hasn't changed			
			final boolean changedInThisNestLevel = attrsInParentQualifactionChanged || childColToBeSummedChanged || childReparented || orphanChildParenting;
			    
		if ( isInserted() && changedInThisNestLevel)
			{
				// For the case of insertion it does not matter If the columns involved
				// for both the where clause and the from column in child are virtual.
				// simply set the deltas to new values and mark them as usable
				
		 
					
					if ( !newParent.isInitialized() )
						newParent.setDataObject(this.getpCURfORD());
					if ( ! newParent.isObjNull() )
						newParent.getDataObject().setAdjust("CUR_OrderValueUSD",getORD_AmountInUSD(), true );
					else
					{
						// Raise an error here
					}
				
				return;
			}
		
			
			
			if ( isDeleted() && ( ! childCascadeDelete ) )
				{
						
						 
							if ( !oldParent.isInitialized() )
									oldParent.setDataObject(this.getOldpCURfORD());
							if ( ! oldParent.isObjNull() )
									oldParent.getDataObject().setAdjust("CUR_OrderValueUSD",getOldORD_AmountInUSD().multiply(new BigDecimal("-1")),true);
								
							else
							{
								// Raise an error here
							}
						
					
					return;
				}
			
			if ( childCascadeUpdate ) 
			{
				
							BigDecimal	addValue = new BigDecimal("0");
							BigDecimal	subValue = new BigDecimal("0");
							BigDecimal	delta = new BigDecimal("0");
						
						
						 
							 delta = getORD_AmountInUSD().subtract(getOldORD_AmountInUSD());
								if ( delta.compareTo(new BigDecimal("0")) != 0 )
						
							{
								if ( !newParent.isInitialized() )
									newParent.setDataObject(this.getpCURfORD());
								if ( ! newParent.isObjNull() )
									newParent.getDataObject().setAdjust("CUR_OrderValueUSD",delta, true);
								else
								{
									// Raise an error here
								}
							}
						
					
					return;
				 
			}
			
			else if ( orphanChildParenting )
			{
				
				 
					if ( !newParent.isInitialized() )
						newParent.setDataObject(this.getpCURfORD());
					if ( ! newParent.isObjNull() )
						newParent.getDataObject().setAdjust("CUR_OrderValueUSD",getORD_AmountInUSD(),true);
					else
					{
						// Raise an error here
					}
				
				return;
			}
			
			else if ( childReparented )
			{
				 
						
						
						 
							if ( !newParent.isInitialized() )
								newParent.setDataObject(this.getpCURfORD());
							if ( ! newParent.isObjNull() )
								newParent.getDataObject().setAdjust("CUR_OrderValueUSD",getORD_AmountInUSD(),true);
							else
							{
								// Raise an error here
							}

							if ( !oldParent.isInitialized() )
								oldParent.setDataObject(this.getOldpCURfORD());
							if ( ! oldParent.isObjNull() )
											oldParent.getDataObject().setAdjust("CUR_OrderValueUSD",getOldORD_AmountInUSD().multiply(new BigDecimal("-1")),true);
								
							else
							{
								// Raise an error here
							}
						
					
					return;
				
			}	
			else
			{
				// The regular update with no change in FKey.
				if ( isUpdated() && changedInThisNestLevel)
				{
					
					
								BigDecimal	addValue	= new BigDecimal("0");
								BigDecimal	subValue	= new BigDecimal("0");
								BigDecimal	delta 	= new BigDecimal("0");
							
							
							
									delta = getORD_AmountInUSD().subtract(getOldORD_AmountInUSD());
									if ( delta.compareTo(new BigDecimal("0")) != 0 )
								
								{
									if ( !oldParent.isInitialized() )
										oldParent.setDataObject(this.getOldpCURfORD());
									if ( ! oldParent.isObjNull() )
										oldParent.getDataObject().setAdjust("CUR_OrderValueUSD",delta, true);
									else
									{
										// Raise an error here
									}
								}
							
						
						return;
					
				}
			}
			
			} catch (Exception ex) {
			 	String dependents[] = {  };
				
				handleAggregateQualificationException(ex, "CUR_OrderValueUSD", "Currency_CUR", dependents);
			}	
		
		} 



		  protected void parentAdjustmentFor_pCURfORDCUR_NumberOfOrders( DataObjectWrapper oldParent, DataObjectWrapper newParent, boolean childCascadeUpdate, boolean childCascadeDelete, boolean orphanChildParenting, boolean childReparented)		{
			try { 
			// check the dependent child columns for changes; this will be empty if there is no
			// qualification expression on the parent count rule.
		  	final boolean attrsInParentQualifactionChanged = false  ;
			final boolean fkeyToParentChanged = getData("ORD_Client").isChanged();

			// prevent parent adjustment if we have had executeRules() or save() called 
			// recursively and the child column hasn't changed			
		  
		  final boolean changedInThisNestLevel = attrsInParentQualifactionChanged || fkeyToParentChanged;
		  
		  
		  if ( isInserted() && changedInThisNestLevel )
			{
				// For the case of insertion it does not matter If the columns involved
				// for both the where clause and the from column in child are virtual.
				// simply set the deltas to new values and mark them as usable
				
				
					if ( !newParent.isInitialized() )
						newParent.setDataObject(this.getpCURfORD());
					if ( ! newParent.isObjNull() )
						newParent.getDataObject().setAdjust("CUR_NumberOfOrders", 1, true);
					else
					{
						// Raise an error here
					}
				
				return;
			}
		  
		  
				if ( isDeleted() && ( ! childCascadeDelete ) )
				{
					
						
						
							if ( !oldParent.isInitialized() )
								oldParent.setDataObject(this.getOldpCURfORD());
							if ( ! oldParent.isObjNull() )
								oldParent.getDataObject().setAdjust("CUR_NumberOfOrders",-1,true);
							else
							{
								// Raise an error here
							}
						
					
					return;
				}
			
		  if ( childCascadeUpdate ) 
			{
				
					
						int	addValue = 0;
						int	subValue = 0;
						
						
					
					return;
				
			}
		  
		  else if ( orphanChildParenting )
			{
			
			
					if ( !newParent.isInitialized() )
						newParent.setDataObject(this.getpCURfORD());
					if ( ! newParent.isObjNull() )
						newParent.getDataObject().setAdjust("CUR_NumberOfOrders",1,true);
					else
					{
						// Raise an error here
					}
				
				return;
			}
		  else if ( childReparented )
			{
				
					
						
						
							if ( !newParent.isInitialized() )
								newParent.setDataObject(this.getpCURfORD());
							if ( ! newParent.isObjNull() )
								newParent.getDataObject().setAdjust("CUR_NumberOfOrders",1,true);
							else
							{
								// Raise an error here
							}

							if ( !oldParent.isInitialized() )
								oldParent.setDataObject(this.getOldpCURfORD());
							if ( ! oldParent.isObjNull() )
								oldParent.getDataObject().setAdjust("CUR_NumberOfOrders",-1,true);
							else
							{
								// Raise an error here
							}
							
						
					return;
					
			}
		  else
			{
				// The regular update with no change in FKey.
				if ( isUpdated() && changedInThisNestLevel)
				{
					 
						int	addValue	= 0;
						int	subValue	= 0;
						
							
						return;
						
				}
			}
		  
		  
		  
		  
		  } catch (Exception ex) {
			 	String dependents[] = {  };
				handleAggregateQualificationException(ex, "CUR_NumberOfOrders", "Currency_CUR", dependents);
			}	
		
		}
		  
		  
		  
		  


	
	protected void autoInsertParentFor_pOBTfORD()
		{
			// get an empty parent created on the current transaction context.
			OrderBacklogPerMonth_OBTBaseImpl parent = (OrderBacklogPerMonth_OBTBaseImpl)OrderBacklogPerMonth_OBTImpl.getNewObject(getSession(), true);
	
			if ( parent != null )
			{
				parent.setOBT_Client(this.getORD_Client());
		 	parent.setOBT_Month(this.getORD_Month());
		 	
				
				
				
					
				
				parent.executeRules();				
			}
		}
	 


protected void codeTableCheck(String colName)
	{
		DataObject	codeTablObj = null;
		Parameter param = null;
		SearchRequest searchReq = new SearchRequest();
					if ( colName.equals("ORD_Approved") && isChanged("ORD_Approved") ) 
			{
				// Ensure the value exists in the code table
				param = new Parameter("CurrencyDemo.Z_YesNo", "Stored", getData("ORD_Approved").getString(), repositoryName);
				searchReq.add(param);
				codeTablObj = CurrencyDemo.Z_YesNoBaseImpl.getObjectByKey(searchReq ,getSession());
				if ( codeTablObj == null ) // Code table not found
				{
					raiseException("Invalid value '" + param.value + "' in 'ORD_Approved'.");
				}
				return;
			}
				

		
		
		}










/**	
* Invalidates the relationship cache. Called by the system on transaction begin.
*/
public void invalidateNonTransactionCaches() 
{
}

	
		// Do the parent checks.
		public void removeMeFrompCURfORDCache()
		{
			SearchRequest searchReq = new SearchRequest();
			Parameter param;
			param = new Parameter("Currency_CUR", "CUR_Client", getData("ORD_Client").getPreviousString(), repositoryName);
					  searchReq.add(param);
			param = new Parameter("Currency_CUR", "CUR_CurrencyCode", getData("ORD_CurrencyCode").getPreviousString(), repositoryName);
					  searchReq.add(param);
			
			if (getSession().getTransactionInfo().isInCache( Currency_CURImpl.getMetaQuery(), searchReq))
			{
				 Currency_CURBaseImpl	parent = this.getOldpCURfORD();
				parent.updateCacheForcORDfCUR(this, true);
			}
		}
		public void removeMeFrompOBTfORDCache()
		{
			SearchRequest searchReq = new SearchRequest();
			Parameter param;
			param = new Parameter("OrderBacklogPerMonth_OBT", "OBT_Client", getData("ORD_Client").getPreviousString(), repositoryName);
					  searchReq.add(param);
			param = new Parameter("OrderBacklogPerMonth_OBT", "OBT_Month", getData("ORD_Month").getPreviousString(), repositoryName);
					  searchReq.add(param);
			
			if (getSession().getTransactionInfo().isInCache( OrderBacklogPerMonth_OBTImpl.getMetaQuery(), searchReq))
			{
				 OrderBacklogPerMonth_OBTBaseImpl	parent = this.getOldpOBTfORD();
				parent.updateCacheForcORDfOBT(this, true);
			}
		}

/**	  
		* <br>
		* method to get the  Currency_CUR object for this OrderItem_ORD
		* this method currently does not support additional conditional params.
		* @return Object : the  parent object  Currency_CUR for this OrderItem_ORD.
		*/
		public	 Currency_CURImpl	getpCURfORD()
		{
			 Currency_CURImpl parent = null;
			SearchRequest searchReq = new SearchRequest();
			Parameter param;
			param = new Parameter("Currency_CUR", "CUR_Client", getData("ORD_Client").getString(), repositoryName);
					  searchReq.add(param);
			param = new Parameter("Currency_CUR", "CUR_CurrencyCode", getData("ORD_CurrencyCode").getString(), repositoryName);
					  searchReq.add(param);
			
			parent = ( Currency_CURImpl)( Currency_CURBaseImpl.getObjectByKey(searchReq ,getSession()));
			return parent;
		}		/**	  
		* <br>
		* method to set the  Currency_CUR object for this OrderItem_ORD.
		* @param Object : the  parent object  Currency_CUR for this OrderItem_ORD.
		*/
		public	void	setpCURfORD( Currency_CURImpl parentObj)
		{
			this.setORD_Client(parentObj.getCUR_Client());
			this.setORD_CurrencyCode(parentObj.getCUR_CurrencyCode());
			
		
		}/**	  
		* <br>
		* method to get the  OrderBacklogPerMonth_OBT object for this OrderItem_ORD
		* this method currently does not support additional conditional params.
		* @return Object : the  parent object  OrderBacklogPerMonth_OBT for this OrderItem_ORD.
		*/
		public	 OrderBacklogPerMonth_OBTImpl	getpOBTfORD()
		{
			 OrderBacklogPerMonth_OBTImpl parent = null;
			SearchRequest searchReq = new SearchRequest();
			Parameter param;
			param = new Parameter("OrderBacklogPerMonth_OBT", "OBT_Client", getData("ORD_Client").getString(), repositoryName);
					  searchReq.add(param);
			param = new Parameter("OrderBacklogPerMonth_OBT", "OBT_Month", getData("ORD_Month").getString(), repositoryName);
					  searchReq.add(param);
			
			parent = ( OrderBacklogPerMonth_OBTImpl)( OrderBacklogPerMonth_OBTBaseImpl.getObjectByKey(searchReq ,getSession()));
			return parent;
		}		/**	  
		* <br>
		* method to set the  OrderBacklogPerMonth_OBT object for this OrderItem_ORD.
		* @param Object : the  parent object  OrderBacklogPerMonth_OBT for this OrderItem_ORD.
		*/
		public	void	setpOBTfORD( OrderBacklogPerMonth_OBTImpl parentObj)
		{
			this.setORD_Client(parentObj.getOBT_Client());
			this.setORD_Month(parentObj.getOBT_Month());
			
		
		}
/**	  
		* <br>
		* method to get the old  Currency_CUR object for this OrderItem_ORD
		* this method currently does not support additional conditional params.
		* @return Object : the  old parent object  Currency_CUR for this OrderItem_ORD.
		*/
		public	 Currency_CURImpl	getOldpCURfORD()
		{
			 Currency_CURImpl parent = null;
			SearchRequest searchReq = new SearchRequest();
			Parameter param;
		param = new Parameter("Currency_CUR", "CUR_Client", getData("ORD_Client").getPreviousString(), repositoryName);
					  searchReq.add(param);
			param = new Parameter("Currency_CUR", "CUR_CurrencyCode", getData("ORD_CurrencyCode").getPreviousString(), repositoryName);
					  searchReq.add(param);
			
			parent = ( Currency_CURImpl)( Currency_CURBaseImpl.getObjectByKey(searchReq ,getSession()));
			return parent;
		}/**	  
		* <br>
		* method to get the old  OrderBacklogPerMonth_OBT object for this OrderItem_ORD
		* this method currently does not support additional conditional params.
		* @return Object : the  old parent object  OrderBacklogPerMonth_OBT for this OrderItem_ORD.
		*/
		public	 OrderBacklogPerMonth_OBTImpl	getOldpOBTfORD()
		{
			 OrderBacklogPerMonth_OBTImpl parent = null;
			SearchRequest searchReq = new SearchRequest();
			Parameter param;
		param = new Parameter("OrderBacklogPerMonth_OBT", "OBT_Client", getData("ORD_Client").getPreviousString(), repositoryName);
					  searchReq.add(param);
			param = new Parameter("OrderBacklogPerMonth_OBT", "OBT_Month", getData("ORD_Month").getPreviousString(), repositoryName);
					  searchReq.add(param);
			
			parent = ( OrderBacklogPerMonth_OBTImpl)( OrderBacklogPerMonth_OBTBaseImpl.getObjectByKey(searchReq ,getSession()));
			return parent;
		}
	/**	  
	* <br>
	* method to get the ORD_Approved attribute for the OrderItem_ORD
	* @return String : the  value of the attribute ORD_Approved as String.
	*/
	public String	getORD_Approved() 
	{
		return getData("ORD_Approved").getString();
	}
	/**	  
	* <br>
	* method to set the ORD_Approved attribute for the OrderItem_ORD
	* @param value String : value of the attribute ORD_Approved as String.
	*/
	public void	setORD_Approved(String value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("ORD_Approved");
		dataVal.setString(value);
	}

	/**	  
	* <br>
	* method to get the old ORD_Approved attribute for the OrderItem_ORD
	* @return String : the  value of the old attribute ORD_Approved as String.
	*/
	public String	getOldORD_Approved()
	{
		return getData("ORD_Approved").getPreviousString();
	}
		/**	  
	* <br>
	* method to get the ORD_Client attribute for the OrderItem_ORD
	* @return String : the  value of the attribute ORD_Client as String.
	*/
	public String	getORD_Client() 
	{
		return getData("ORD_Client").getString();
	}
	/**	  
	* <br>
	* method to set the ORD_Client attribute for the OrderItem_ORD
	* @param value String : value of the attribute ORD_Client as String.
	*/
	public void	setORD_Client(String value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("ORD_Client");
		dataVal.setString(value);
	}

	/**	  
	* <br>
	* method to get the old ORD_Client attribute for the OrderItem_ORD
	* @return String : the  value of the old attribute ORD_Client as String.
	*/
	public String	getOldORD_Client()
	{
		return getData("ORD_Client").getPreviousString();
	}
		/**	  
	* <br>
	* method to get the ORD_Month attribute for the OrderItem_ORD
	* @return String : the  value of the attribute ORD_Month as String.
	*/
	public String	getORD_Month() 
	{
		return getData("ORD_Month").getString();
	}
	/**	  
	* <br>
	* method to set the ORD_Month attribute for the OrderItem_ORD
	* @param value String : value of the attribute ORD_Month as String.
	*/
	public void	setORD_Month(String value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("ORD_Month");
		dataVal.setString(value);
	}

	/**	  
	* <br>
	* method to get the old ORD_Month attribute for the OrderItem_ORD
	* @return String : the  value of the old attribute ORD_Month as String.
	*/
	public String	getOldORD_Month()
	{
		return getData("ORD_Month").getPreviousString();
	}
		/**	  
	* <br>
	* method to get the ORD_CurrencyCode attribute for the OrderItem_ORD
	* @return String : the  value of the attribute ORD_CurrencyCode as String.
	*/
	public String	getORD_CurrencyCode() 
	{
		return getData("ORD_CurrencyCode").getString();
	}
	/**	  
	* <br>
	* method to set the ORD_CurrencyCode attribute for the OrderItem_ORD
	* @param value String : value of the attribute ORD_CurrencyCode as String.
	*/
	public void	setORD_CurrencyCode(String value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("ORD_CurrencyCode");
		dataVal.setString(value);
	}

	/**	  
	* <br>
	* method to get the old ORD_CurrencyCode attribute for the OrderItem_ORD
	* @return String : the  value of the old attribute ORD_CurrencyCode as String.
	*/
	public String	getOldORD_CurrencyCode()
	{
		return getData("ORD_CurrencyCode").getPreviousString();
	}
		/**	  
	* <br>
	* method to get the ORD_AmountInLocalCurrency attribute for the OrderItem_ORD
	* @return BigDecimal : the  value of the attribute ORD_AmountInLocalCurrency as BigDecimal.
	*/
	public BigDecimal	getORD_AmountInLocalCurrency() 
	{
		return getData("ORD_AmountInLocalCurrency").getBigDecimal();
	}
	/**	  
	* <br>
	* method to set the ORD_AmountInLocalCurrency attribute for the OrderItem_ORD
	* @param value BigDecimal : value of the attribute ORD_AmountInLocalCurrency as BigDecimal.
	*/
	public void	setORD_AmountInLocalCurrency(BigDecimal value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("ORD_AmountInLocalCurrency");
		dataVal.setBigDecimal(value);
	}

	/**	  
	* <br>
	* method to get the old ORD_AmountInLocalCurrency attribute for the OrderItem_ORD
	* @return BigDecimal : the  value of the old attribute ORD_AmountInLocalCurrency as BigDecimal.
	*/
	public BigDecimal	getOldORD_AmountInLocalCurrency()
	{
		return getData("ORD_AmountInLocalCurrency").getPreviousBigDecimal();
	}
		/**	  
		* <br>
		* method to get the ORD_OrderId attribute for the OrderItem_ORD
		* Description: 
		* @return long : the  value of the attribute ORD_OrderId as long.
		*/
		public long	getORD_OrderId() 
		{
			return getData("ORD_OrderId").getlong();
		}

		/**	  
		* <br>
		* method to set the ORD_OrderId attribute for the OrderItem_ORD
		* @param value long : value of the attribute ORD_OrderId as long.
		*/
		public void	setORD_OrderId(long value)
		{
			// The code to do convertion from the primitive data
			// to the one which can be stored goes here.
			Data dataVal = getData("ORD_OrderId");
			dataVal.setlong(value);
		}

		/**	  
		* <br>
		* method to get the old ORD_OrderId attribute for the OrderItem_ORD
		* @return long : the  value of the old attribute ORD_OrderId as long.
		*/
		public long	getOldORD_OrderId()
		{
			return getData("ORD_OrderId").getPreviouslong();
		}






	/**	  
	* <br>
	* method to get the ORD_AmountInUSD attribute for the OrderItem_ORD
	* Description: 
	* @return BigDecimal : the  value of the attribute ORD_AmountInUSD as BigDecimal.
	*/
	public BigDecimal	getORD_AmountInUSD() 
	{
			Data dataVal = null;
			
				dataVal = getData("ORD_AmountInUSD");
			
			return dataVal.getBigDecimal();
	}


	/**	  
	* <br>
	* method to get the ORD_AmountInUSD attribute for the OrderItem_ORD
	* Description: 
	* @return BigDecimal : the  value of the attribute ORD_AmountInUSD as BigDecimal.
	*/
	public BigDecimal	getisNullORD_AmountInUSD() 
	{
			Data dataVal = null;
			
				dataVal = getData("ORD_AmountInUSD");
			
			return dataVal.getBigDecimal();
	}



	/**	  
		* <br>
		* method to get the old ORD_AmountInUSD attribute for the OrderItem_ORD
		* @return BigDecimal : the  value of the old attribute ORD_AmountInUSD as BigDecimal.
		*/
		public BigDecimal	getOldORD_AmountInUSD()
		{
			return getData("ORD_AmountInUSD").getPreviousBigDecimal();
		}
	

	/**	  
	* <br>
	* method to set the ORD_AmountInUSD attribute for the OrderItem_ORD
	* @param value BigDecimal : value of the attribute ORD_AmountInUSD as BigDecimal.
	*/
	public void setORD_AmountInUSD(BigDecimal value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("ORD_AmountInUSD");
		dataVal.setBigDecimal(value);
	}


/**	  
		* <br>
		* method to get the replicated attribute ORD_ExchangeRate for the OrderItem_ORD
		* Description: 
		* @return BigDecimal : the  value of the replicated attribute ORD_ExchangeRate as BigDecimal.
		*/
		public BigDecimal	getORD_ExchangeRate() 
		{		
			
				return getData("ORD_ExchangeRate").getBigDecimal();				
			
		}

			
			/**	  
			* <br>
			* method to get the value before data change for the replicated attribute ORD_ExchangeRate
			* in the data object OrderItem_ORD
			* @return BigDecimal : the  value of the attribute ORD_ExchangeRate as BigDecimal before change.
			*/
			public BigDecimal	getOldORD_ExchangeRate()
			{
				return getData("ORD_ExchangeRate").getPreviousBigDecimal();
			}

		

		/**	  
		* <br>
		* method to set the value of the replicated attribute ORD_ExchangeRate in the data object OrderItem_ORD
		* @param value BigDecimal : value of the attribute ORD_ExchangeRate as BigDecimal.
		*/
		public void	setORD_ExchangeRate(BigDecimal value)
		{
			// The code to do convertion from the primitive data
			// to the one which can be stored goes here.
			Data dataVal = getData("ORD_ExchangeRate");
			dataVal.setBigDecimal(value);
			dataVal.setInitialized(true);
		}






		public static BigDecimal getOrderBacklogPerMonth_OBTOBT_OrderValueUSD(SearchRequest searchReq, String childColumnName, Session aSession)
		{

			Enumeration dbrows = null;
			OrderItem_ORDBaseImpl row = null;
					BigDecimal OBT_OrderValueUSDvalue = new BigDecimal("0");
			
			
					// This is case where column being summed is stored and where clause is stored
					// In this case, we must put the where clause into the SearchRequest object.
					
					
					XDAConnector xdac = createXDAConnector(aSession);
					Connection con = null;
					if ( aSession.isTransactionInProgress())
							OBT_OrderValueUSDvalue = new BigDecimal(aSession.getTransactionInfo().getRowSum(OrderItem_ORDBaseImpl.getMetaQuery(), xdac, searchReq, childColumnName));
						
					else
					{
						con = aSession.getConnection( xdac, true );
							OBT_OrderValueUSDvalue = new BigDecimal(xdac.getRowSum(OrderItem_ORDBaseImpl.getMetaQuery(), searchReq, con, childColumnName));
						
					}

				
			
			return (OBT_OrderValueUSDvalue);
		}

		public static BigDecimal getCurrency_CURCUR_OrderValueUSD(SearchRequest searchReq, String childColumnName, Session aSession)
		{

			Enumeration dbrows = null;
			OrderItem_ORDBaseImpl row = null;
					BigDecimal CUR_OrderValueUSDvalue = new BigDecimal("0");
			
			
					// This is case where column being summed is stored and where clause is stored
					// In this case, we must put the where clause into the SearchRequest object.
					
					
					XDAConnector xdac = createXDAConnector(aSession);
					Connection con = null;
					if ( aSession.isTransactionInProgress())
							CUR_OrderValueUSDvalue = new BigDecimal(aSession.getTransactionInfo().getRowSum(OrderItem_ORDBaseImpl.getMetaQuery(), xdac, searchReq, childColumnName));
						
					else
					{
						con = aSession.getConnection( xdac, true );
							CUR_OrderValueUSDvalue = new BigDecimal(xdac.getRowSum(OrderItem_ORDBaseImpl.getMetaQuery(), searchReq, con, childColumnName));
						
					}

				
			
			return (CUR_OrderValueUSDvalue);
		}




		public static int getCurrency_CURCUR_NumberOfOrders(SearchRequest searchReq, Session aSession)
		{
			Enumeration dbrows = null;
			OrderItem_ORDBaseImpl row = null;
			int count;
			count = 0;
			
					count = getObjectCount(searchReq, aSession);
			
			return (count);
		}	


/**	  
* <br>
* a factory method to get the rowcount on the objects satisfying the criterion.
* @param searchReq : the criterion for the selection
* @param aSession : Session object on which the operation is performed.
* @return int : the count of objects satistying the condition.
*/
public static int getObjectCount( SearchRequest searchReq , Session aSession )
throws ServerException
    {
	XDAConnector xdac = createXDAConnector(aSession);
	Connection con = null;
	int count = 0;

	if ( aSession.isTransactionInProgress())
		count = aSession.getTransactionInfo().getObjectsCount(OrderItem_ORDBaseImpl.getMetaQuery(), xdac, searchReq);
	else
	{
		con = aSession.getConnection( xdac, true );
  	  	count = xdac.getRowCount( OrderItem_ORDBaseImpl.getMetaQuery(), searchReq, con );
	}

  	return count;
  
}

/**	  
	* <br>
	* Method returning true if the column in question has a where clause used in parent table.
	* during the computation of the column.
	*/
	public boolean passesWhere(String parentColumn)
	{/**@ Generate the cases for virtual first since they are used most often (for performance). @**/
				
				/**@ Generate the cases for virtual first since they are used most often (for performance). @**/
				/**@ Generate the cases for virtual first since they are used most often (for performance). @**/
				

				
					if (parentColumn.equals("Currency_CUR.CUR_OrderValueUSD"))
					{
						 
							return( true );
						
					}
				
			
				
					if (parentColumn.equals("Currency_CUR.CUR_NumberOfOrders"))
					{
						 
							return( true );
						
					}
					
			
	
				
					if (parentColumn.equals("OrderBacklogPerMonth_OBT.OBT_OrderValueUSD"))
					{
						 
							return( true );
						
					}
				
			




return (false) ;

	}

/**	  
* <br>
* a factory method to create the XDAConnector object for this class.
* @return XDAConnector : if succcessful returns an instance of the XDA Connector.
*/
public static XDAConnector createXDAConnector()
{ 
	XDAConnector xda = null;
	try {
		VSMetaTable table = OrderItem_ORDBaseImpl.getMetaQuery().getChildMostTable();
		if ( table != null )
			xda = ( XDAConnector)Class.forName( table.getXDAConnectorClassName() ).newInstance();
		else
			xda = ( XDAConnector)Class.forName( "com.versata.tl.vls.dataaccess.XDASQLConnector").newInstance();

	}
	catch ( Exception ex )
	{
		logger.warn(ex);
	}

	return xda;
}


/**	  
* <br>
* a factory method to create the XDAConnector object for this class for a perticular session.
* @param aSession : Session object with which to associate the XDA Connector.
* @return XDAConnector : if succcessful returns an instance of the XDA Connector.
*/
public static XDAConnector createXDAConnector( Session aSession )
	throws ServerException
{ 
	XDAConnector xda = null;
	try {
		VSMetaTable table = OrderItem_ORDBaseImpl.getMetaQuery().getChildMostTable();
		if ( table != null )
			xda = ( XDAConnector)Class.forName( table.getXDAConnectorClassName() ).newInstance();
		else
			xda = ( XDAConnector)Class.forName( "com.versata.tl.vls.dataaccess.XDASQLConnector").newInstance();

	}
	catch ( Exception ex )
	{
		logger.warn(ex);
	}
	
	xda.setSession( aSession );
	Properties props = ((VSORBSessionImpl)aSession).getMyDataServiceLoginForObject("OrderItem_ORD");
	xda.setProperties(props);

	return xda;
}  

/**	  
* <br>
* returns the current XDA Connector for this object if one is already created, otherwise
* an instance of the XDA Connector is created and returned.
* @return XDAConnector : if succcessful returns an instance of the XDA Connector.
*/
public XDAConnector getXDAConnector()
{
	if ( xdac == null )
		xdac = createXDAConnector(session);
	return xdac;
}

public void RecomputeDerivations()
{
	
	
			Currency_CURBaseImpl pCURfORD = (Currency_CURBaseImpl) this.getpCURfORD();
			
						if (logger.isDebugEnabled()) logger.debug("recomputing ORD_ExchangeRate");
					if ( pCURfORD != null ) {                  
						this.setORD_ExchangeRate( pCURfORD.getCUR_ExchangeRate());
					}
	
	
}

	List listOfChildObjects_ = null;
	
	private void addToChildObjsList_(DataObject childObj) {
		if(listOfChildObjects_ == null) {
			listOfChildObjects_ = new ArrayList(3);
		}
		listOfChildObjects_.add(childObj);
	}
	
	private void saveChildObjs_() {
		if(listOfChildObjects_ != null) {
			for (int i = 0; i < listOfChildObjects_.size(); i++) {
				DataObject childObj = (DataObject) listOfChildObjects_.get(i);
				childObj.executeRules();
			}
			listOfChildObjects_ = null;
		}
	}


//END_COMPONENT_RULES}}

	//{{ABSTRACT_CUSTOM_METHODS

	// User defined methods used in a rule are defined in the Impl class, and have corresponding abstract methods in the BaseImpl.



//END_ABSTRACT_CUSTOM_METHODS}}
}
