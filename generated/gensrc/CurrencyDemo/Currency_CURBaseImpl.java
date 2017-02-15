 
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
import CurrencyDemo.OrderItem_ORDBaseImpl;
import CurrencyDemo.OrderItem_ORDImpl;
import CurrencyDemo.Currency_CURBaseImpl;
import CurrencyDemo.Currency_CURImpl;
					
import CurrencyDemo.Currency_CURBaseImpl;
import CurrencyDemo.Currency_CURImpl;

//END_COMPONENT_IMPORT_STMTS}}

/**
* Enforces rules, in conjunction with [designated] Super, Event Handling sub, and methods invoked from rules.
* Instances are instantiated by BRMS runtime by decomposing Query Model updates.
* After rule enforcement, instances remain in transaction cache until end transaction,
*   when they are flushed to disk by their XDA.
*  
*/
 public abstract class Currency_CURBaseImpl extends DataObject {
    
    public static VersataLogger logger = VersataLogger.getLogger(Currency_CURImpl.class);
    
    protected Currency_CURBaseImpl() {
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
	private static String modelName = "Currency_CUR";
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
			logger.debug("Initializing Currency_CUR");
		
		vsQueryDefinition= new VSQueryDefinition( "Currency_CUR" );
		vsQueryDefinition.setPackageName("CurrencyDemo");
		vsQueryDefinition.setRepositoryName(repositoryName);
		vsQueryDefinition.setDataObject(true);	
		
		
		
		
		VSMetaColumn c = null;
		VSMetaTable tableForSubObjRetQry = new VSMetaTable("Currency_CUR");
		
		//{{META_QUERY_COLUMN_CTOR
		
		
		
			c = new VSMetaColumn("CUR_Client", DataConst.VARCHAR);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.PK);
			c.setSize(5);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setDefaultValue("'1'");
			c.setCaption("");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("CUR_CurrencyCode", DataConst.CHAR);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.PK);
			c.setSize(3);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setCaption("Currency Code");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("CUR_ExchangeRate", DataConst.DECIMAL);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setSize(10);
			c.setScale(4);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setCaption("Exchange Rate");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("CUR_NumberOfOrders", DataConst.INTEGER);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setComputed (true);
			c.setCaption("Number Of Orders");
			c.setIsVirtual(true);
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("CUR_OrderValueUSD", DataConst.DECIMAL);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setSize(10);
			c.setScale(2);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setComputed (true);
			c.setCaption("Order Value USD22");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("CUR_OrderAmountAverage", DataConst.DECIMAL);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setSize(10);
			c.setScale(2);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setComputed (true);
			c.setCaption("Order Amount Average USD");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("CUR_Image", DataConst.VARCHAR);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setSize(255);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setComputed (true);
			c.setCaption("Image");
			c.setIsVirtual(true);
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("CUR_Client_RelatedTo", DataConst.VARCHAR);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setSize(5);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setCaption("");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("CUR_CurrencyCode_RelatedTo", DataConst.CHAR);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setSize(3);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setCaption("CurrencyCode_RelatedTo");
			tableForSubObjRetQry.addColumn( c );
			
    			
		VSMetaTable t = getTableForObjRetQuery(tableForSubObjRetQry);
		t.addUniqueKeyColumn( "Currency_CUR Unique Key", "CUR_Client" );
		  tableForSubObjRetQry.addUniqueKeyColumn( "Currency_CUR Unique Key", "CUR_Client" );
			t.addUniqueKeyColumn( "Currency_CUR Unique Key", "CUR_CurrencyCode" );
		  tableForSubObjRetQry.addUniqueKeyColumn( "Currency_CUR Unique Key", "CUR_CurrencyCode" );
	


// begin key generation
	
				/// got assoc: Currency_CUR(pCURfORD)-OrderItem_ORD(cORDfCUR) (enforced: true) 
				t.addUniqueKeyColumn("Parent Key: Currency_CUR(pCURfORD)-OrderItem_ORD(cORDfCUR)", "CUR_Client"); // <- ORD_Client
				// got keyPair: com.versata.tl.models.bl.dataobject.impl.AttributePairImpl@fe0c3 
					
				/// got assoc: Currency_CUR(pCURfORD)-OrderItem_ORD(cORDfCUR) (enforced: true) 
				t.addUniqueKeyColumn("Parent Key: Currency_CUR(pCURfORD)-OrderItem_ORD(cORDfCUR)", "CUR_CurrencyCode"); // <- ORD_CurrencyCode
				// got keyPair: com.versata.tl.models.bl.dataobject.impl.AttributePairImpl@6d5273 
					
				/// got assoc: Currency_CURParent(Currency_CURParent)-Currency_CURChild(Currency_CURChild) (enforced: true) 
				t.addUniqueKeyColumn("Parent Key: Currency_CURParent(Currency_CURParent)-Currency_CURChild(Currency_CURChild)", "CUR_Client"); // <- CUR_Client_RelatedTo
				// got keyPair: com.versata.tl.models.bl.dataobject.impl.AttributePairImpl@1402f87 
					
				/// got assoc: Currency_CURParent(Currency_CURParent)-Currency_CURChild(Currency_CURChild) (enforced: true) 
				t.addUniqueKeyColumn("Parent Key: Currency_CURParent(Currency_CURParent)-Currency_CURChild(Currency_CURChild)", "CUR_CurrencyCode"); // <- CUR_CurrencyCode_RelatedTo
				// got keyPair: com.versata.tl.models.bl.dataobject.impl.AttributePairImpl@f06b95 
				
		StringBuffer associationAttributePairs = null;
						
			
			// child of Currency_CURParent(Currency_CURParent)-Currency_CURChild(Currency_CURChild) (enforced: true)
			associationAttributePairs = new StringBuffer();    // child association info (fkey columns, standard / system Extended Properties)
				
				associationAttributePairs.append("CUR_Client <- CUR_Client_RelatedTo ");
				t.addForeignKeyColumn( "Foreign Key To Currency_CURParent", "CUR_Client_RelatedTo" );
				// todo ParentTableForVar
					
				associationAttributePairs.append("CUR_CurrencyCode <- CUR_CurrencyCode_RelatedTo ");
				t.addForeignKeyColumn( "Foreign Key To Currency_CURParent", "CUR_CurrencyCode_RelatedTo" );
				// todo ParentTableForVar
				vsQueryDefinition.addRelationshipProperty("Currency_CUR_Currency_CURParent_Currency_CUR",
			         "AssociationAttributePairs", 
			         associationAttributePairs.toString());  // for parentRole: Currency_CURParent
			
	
/*
			<foreach>[[RelationshipExtendedProperties]]
				vsQueryDefinition.addRelationshipProperty("[[ParentTableForVar]]_[[ParentRoleNameInMethod]]_[[ChildTableForVar]]", "[[ExtendedPropertyName]]", "[[ExtendedPropertyValue]]");
				<endforeach>
			<endforeach>
*/

// end  support for key generation
		
		addUniqueConstraintsToMetaTable(t); 
		
		
					t.addForeignKeyColumn( "Foreign Key To Currency_CUR", "CUR_Client_RelatedTo" );
					tableForSubObjRetQry.addForeignKeyColumn( "Foreign Key To Currency_CUR", "CUR_Client_RelatedTo" );
				
					t.addForeignKeyColumn( "Foreign Key To Currency_CUR", "CUR_CurrencyCode_RelatedTo" );
					tableForSubObjRetQry.addForeignKeyColumn( "Foreign Key To Currency_CUR", "CUR_CurrencyCode_RelatedTo" );
				

		
		
			 t.useQuotedIdentifier(false);		
		tableForSubObjRetQry.useQuotedIdentifier(false);		
		t.setOptLock( DataConst.OptLockingOnApplicable );
		tableForSubObjRetQry.setOptLock( DataConst.OptLockingOnApplicable );
		
		
		
		
		//END_META_QUERY_COLUMN_CTOR}}
	
		vsQueryDefinition.addTable( t );		
		vsQueryDefinition.populateQCArray();
		
		VSQueryDefinition qTemp = null;
		
		if(!"VLSJSFWebConsole".equals("CurrencyDemo"))
			qTemp = (VSQueryDefinition)getMetaQuery( "Currency_CUR","CurrencyDemo" );			
							
		if ( qTemp == null ) {			
			vsQueryDefinition.setPartialSQLForDataModel("SELECT Currency_CUR.CUR_Client AS CUR_Client, Currency_CUR.CUR_CurrencyCode AS CUR_CurrencyCode, Currency_CUR.CUR_ExchangeRate AS CUR_ExchangeRate, Currency_CUR.CUR_OrderValueUSD AS CUR_OrderValueUSD, Currency_CUR.CUR_OrderAmountAverage AS CUR_OrderAmountAverage, Currency_CUR.CUR_Client_RelatedTo AS CUR_Client_RelatedTo, Currency_CUR.CUR_CurrencyCode_RelatedTo AS CUR_CurrencyCode_RelatedTo FROM <dbschema>.Currency_CUR Currency_CUR", storageOption, inheritanceType, repositoryName, modelName);
			addMetaQuery(vsQueryDefinition, "CurrencyDemo");
		}					
		else {
			vsQueryDefinition = qTemp;	// Keep the old query as it has cached object
		}
			
			
			
	  		
	//END_COMPONENT_META_QRY}}

	//{{COMPONENT_RULES
		
	t.setDerivationType("CUR_Client", VSMetaColumn.derivationDefault);
			tableForSubObjRetQry.setDerivationType("CUR_Client", VSMetaColumn.derivationDefault);
		  t.setDerivationType("CUR_NumberOfOrders", VSMetaColumn.derivationCount);
			tableForSubObjRetQry.setDerivationType("CUR_NumberOfOrders", VSMetaColumn.derivationCount);
		  t.setIsVirtual("CUR_NumberOfOrders", true);
				tableForSubObjRetQry.setIsVirtual("CUR_NumberOfOrders", true);
			t.setDerivationType("CUR_OrderValueUSD", VSMetaColumn.derivationSum);
			tableForSubObjRetQry.setDerivationType("CUR_OrderValueUSD", VSMetaColumn.derivationSum);
		  t.setDerivationType("CUR_OrderAmountAverage", VSMetaColumn.derivationFormula);
			tableForSubObjRetQry.setDerivationType("CUR_OrderAmountAverage", VSMetaColumn.derivationFormula);
		  t.setDerivationType("CUR_Image", VSMetaColumn.derivationFormula);
			tableForSubObjRetQry.setDerivationType("CUR_Image", VSMetaColumn.derivationFormula);
		  t.setIsVirtual("CUR_Image", true);
				tableForSubObjRetQry.setIsVirtual("CUR_Image", true);
			
	  		String dpndsOn = "";
		  
	   dpndsOn = "CUR_OrderAmountAverage";
		     t.addDependency(dpndsOn, "CUR_NumberOfOrders");
		 	tableForSubObjRetQry.addDependency(dpndsOn, "CUR_NumberOfOrders"); 
		      t.addDependency(dpndsOn, "CUR_OrderValueUSD");
		 	tableForSubObjRetQry.addDependency(dpndsOn, "CUR_OrderValueUSD"); 
		  
	  
	  
	  	
	  
	  
	  
	  
	  
	  
	  
	  
	  	}
	
	private static VSMetaTable getTableForObjRetQuery(VSMetaTable t) {

		VSMetaTable newMetaTable = new VSMetaTable("Currency_CUR");
		
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
		String uniqueConstraints = ";";
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

		protected void Currency_CUR_afterCommit(Session session) {
			
		}

		protected void Currency_CUR_afterDelete(DataObject obj) {

		}

		protected void Currency_CUR_afterInsert(DataObject obj) {

		}

		protected void Currency_CUR_afterRollback(Session session) {

		}

		protected void Currency_CUR_afterUpdate(DataObject obj) {

		}

		protected void Currency_CUR_beforeCommit(Session session, Response resp) {

		}

		protected void Currency_CUR_beforeDelete(DataObject obj, Response resp) {

		}

		protected void Currency_CUR_beforeInsert(DataObject obj, Response resp) {

		}

		protected void Currency_CUR_beforeRollback(Session session) {

		}

		protected void Currency_CUR_beforeUpdate(DataObject obj, Response resp) {

		}

		protected void Currency_CUR_beginTrans(Session session) {

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
			    Currency_CURImpl implInstance = new Currency_CURImpl();
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
	return "Currency_CUR";
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
* Constructor for the class Currency_CURBaseImpl.
* @param session object on which the Business object is created.
* @param makeDefaults boolean if true sets the default values in the data elements
*        as defined in the meta data.
*/
public Currency_CURBaseImpl(Session session, boolean makeDefaults) {
	super(session, Currency_CURBaseImpl.getMetaQuery(), makeDefaults);
	
	
	 
		addListeners();
		
}
    
    public Currency_CURBaseImpl(Session session, VSMetaQuery metaQuery, boolean makeDefaults) {
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
	com.versata.tl.vls.admin.AppObjectImpl appObject = com.versata.tl.vls.admin.AppObjectImpl.getBusinessObject( repositoryName, "Currency_CUR", ServerEnvironment.getServer().getInternalSession());
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
 		logger.debug("Currency_CUR cache size: " + cacheSize + " expiration " + expires);
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
		if (!aSession.getMyPrivilegeToObjectName(DataConst.AppObjectPrivilegeImpl_READ, "Currency_CUR", DataConst.AppObjectTypeCodeImpl_BUSINESS_OBJECT)) {
		throw new ServerException(ErrorMsgCode.VSMSG_SecurityNoReadAccess,  new Object[] {"business", "Currency_CUR"});
		}
		}
		catch( VSORBException e ) { 
			logger.warn(e);
		}
	}
	
	raiseBeforeQueryEvent( searchReq, aSession );	
	
	XDAConnector xdac = createXDAConnector(aSession);
		
	if (aSession.isTransactionInProgress()) {
		Enumeration e = aSession.getTransactionInfo().getObjects(Currency_CURBaseImpl.getSubObjectRetrievalMetaQuery(), xdac, searchReq);

		Vector dObjs = new Vector();
		while(e.hasMoreElements()) {
			Currency_CURImpl implObj = (Currency_CURImpl) e.nextElement();
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
		ResultSet rs = new VSORBResultSetImpl( Currency_CURBaseImpl.getSubObjectRetrievalMetaQuery(), searchReq, null, -1 ,DataConst.NONE_LOB, xdac, con );
		raiseAfterQueryEvent( rs );
		DataRow row;
		while (  ( row =  rs.fetch() ) != null )
		{	
			Currency_CURImpl bo = (Currency_CURImpl) row.getComponent();
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
		if (!aSession.getMyPrivilegeToObjectName(DataConst.AppObjectPrivilegeImpl_READ, "Currency_CUR", DataConst.AppObjectTypeCodeImpl_BUSINESS_OBJECT)) {
		throw new ServerException(ErrorMsgCode.VSMSG_SecurityNoReadAccess,  new Object[] {"business", "Currency_CUR"});
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
		Enumeration e= aSession.getTransactionInfo().getObjects(Currency_CURBaseImpl.getMetaQuery(), xdac, searchReq);
		Vector boList = new Vector();
		while ( e.hasMoreElements()) {
			Currency_CURImpl bo = (Currency_CURImpl) e.nextElement();
			if(bo != null  && (inheritanceType == com.versata.tl.vls.core.InheritanceType.NONE || inheritanceType == com.versata.tl.vls.core.InheritanceType.REPL) || typeIndicatorValue.equals(bo.get_VSTypeIndicatorAttrColumnData())) {
				boList.addElement( bo );
			}
		}

		// update the global cache if we have one
		if (cacheSize!=0)
		{
			CacheAgent.getCacheAgent().setObjects( Currency_CURBaseImpl.getMetaQuery(), boList, expires );
		}
		return boList.elements();		
	} else {
		Vector boList = new Vector();
		Connection con = aSession.getConnection( xdac, true );
		ResultSet rs = new VSORBResultSetImpl( Currency_CURBaseImpl.getMetaQuery(), searchReq, null, -1 ,DataConst.NONE_LOB, xdac, con );
		raiseAfterQueryEvent( rs );
		DataRow row;
		while (  ( row =  rs.fetch() ) != null )
		{	
			Currency_CURImpl bo = (Currency_CURImpl)row.getComponent();
			if(bo != null && (inheritanceType == com.versata.tl.vls.core.InheritanceType.NONE || inheritanceType == com.versata.tl.vls.core.InheritanceType.REPL) || typeIndicatorValue.equals(bo.get_VSTypeIndicatorAttrColumnData())) {
				boList.addElement( bo );
			}

		}
		rs.close();
		
		// if we have a cache, add the retrieved objects to it
		if ( cacheSize != 0 )
			CacheAgent.getCacheAgent().setObjects( Currency_CURBaseImpl.getMetaQuery(), boList, expires );
			
		return boList.elements();
	}	
}

public static void raiseBeforeQueryEvent( SearchRequest searchReq, Session aSession )	{
        VSTraceHelper tr = VSTrace.IS_ON ? new VSTraceHelper(logger, "Currency_CUR.BeforeQuery") : null;
        try {
            beforeQuery( "Currency_CUR", searchReq, null , aSession );
        }
	finally {
	    if (  tr != null ) tr.end();
        }
}

public static void raiseAfterQueryEvent( ResultSet rs)	{
        VSTraceHelper tr = VSTrace.IS_ON ? new VSTraceHelper(logger, "Currency_CUR.AfterQuery") : null;
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
		Currency_CURImpl implObj = (Currency_CURImpl) getObjectByKeyUsingSubObjQueryInternal(key, aSession);
		if(implObj == null) {
			return null;
		}
		String tiAttrColData = implObj.get_VSTypeIndicatorAttrColumnData();
		if(typeIndicatorValue.equals(tiAttrColData) || implObj.get_VSTypeIndicatorValue().equals(tiAttrColData)) {
			return implObj;
		}
		return getActualObjectByKeyWithoutQueryExec(repositoryName, implObj, tiAttrColData);
	} else {
		Currency_CURImpl implObj = (Currency_CURImpl) getObjectByKeyInternal(key, aSession, cacheOnly);
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
		if (!aSession.getMyPrivilegeToObjectName(DataConst.AppObjectPrivilegeImpl_READ, "Currency_CUR", DataConst.AppObjectTypeCodeImpl_BUSINESS_OBJECT)) {
		    throw new ServerException(ErrorMsgCode.VSMSG_SecurityNoReadAccess,  new Object[] {"business", "Currency_CUR"});
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
		anObject = CacheAgent.getCacheAgent().getObject( Currency_CURBaseImpl.getMetaQuery(),key.parameterList, aSession);
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
		anObject = aSession.getTransactionInfo().getObjectByKey(Currency_CURBaseImpl.getMetaQuery(),key);
	} else {		
		anObject = aSession.getObjectByKey(Currency_CURBaseImpl.getMetaQuery(),key);
	}
	
	// if we have a cache and got here, we had a cache miss so add this object to the global cache
	if ( cacheSize != 0 )
		 CacheAgent.getCacheAgent().addObject( Currency_CURBaseImpl.getMetaQuery(),anObject, expires );
		 
	return anObject;
}
protected static DataObject getObjectByKeyUsingSubObjQueryInternal( SearchRequest key, Session aSession )
	throws ServerException
{
	if (logger.isDebugEnabled()) logger.debug("getObjectByKeyUsingSubObjQueryInternal " + key + " " + aSession);
	if ( aSession.getSecurityCheck() ) {
		try {
		if (!aSession.getMyPrivilegeToObjectName(DataConst.AppObjectPrivilegeImpl_READ, "Currency_CUR", DataConst.AppObjectTypeCodeImpl_BUSINESS_OBJECT)) {
		    throw new ServerException(ErrorMsgCode.VSMSG_SecurityNoReadAccess,  new Object[] {"business", "Currency_CUR"});
		}
		}
		catch( VSORBException e ) { 
			logger.warn(e);
		}
	}

	raiseBeforeQueryEvent( key, aSession );	
	
	DataObject anObject = null;	

	if (aSession.isTransactionInProgress()) {
		anObject = aSession.getTransactionInfo().getObjectByKey(Currency_CURBaseImpl.getSubObjectRetrievalMetaQuery(),key);
	} else {		
		anObject = aSession.getObjectByKey(Currency_CURBaseImpl.getSubObjectRetrievalMetaQuery(),key);
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
		removeMeFromCurrency_CURParentCache();
			
		

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
		setCUR_OrderValueUSD(new BigDecimal("0"));
		
		
		
		
		
		
		// Set the default values for the aggregates
		
		
		
		
		
		
			
}

protected void insert_setAttrDefaults() throws ServerException
{	
		 if ( isNull("CUR_Client") ) 
						
						setCUR_Client((String)("1"));
			
			
			
		
			
		
			
		
	


}

protected void insert_setCounterAttrs_replCase() throws ServerException
{

	
		
		
		
		
		
		
		
		
			
	
		
}

protected void insert_setCounterAttrs() throws ServerException
{
	 	
	
	
		
		
		
		
		
		
		
		
			
		
}



protected void insert_checkPrimaryKeyChanges() throws ServerException
{
	 

    // If the counter changed the pk, we need to update the cache (BUG14568)
    // Typically this is the case with Oracle and DB2 where the counters are
    // backed with database sequences, as opposed to autonumbers 
    int pkChangeCount = 0;
    if (isChanged("CUR_Client")) {
        pkChangeCount++;
        }
    if (isChanged("CUR_CurrencyCode")) {
        pkChangeCount++;
        }       
    if (pkChangeCount > 0) {
        getSession().getTransactionInfo().save(this, "Currency_CUR");
    }
}

protected void doParentChecks() throws ServerException
{
			if (Currency_CURImpl.getMetaQuery() != null && !"Currency_CURParent".equalsIgnoreCase((Currency_CURImpl.getMetaQuery().getProperty("dontCheckForParent")))) {
					this.parentCheckFor_Currency_CURParent();
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
	
	  
	  
	  
	  
	  
	  
	  
	  
	  	
	
}
protected void doComputedAttrNullCheck() throws ServerException
{
	
	
	
	
	
	
	
	
	
	
}

protected void doChildCascades() throws ServerException
{
	// Child Cascade for Role Currency_CUR(pCURfORD)-OrderItem_ORD(cORDfCUR): pCURfORD->>cORDfCUR
			this.childCascadeFor_cORDfCUR();
						
		// Child Cascade for Role Currency_CURParent(Currency_CURParent)-Currency_CURChild(Currency_CURChild): Currency_CURParent->>Currency_CURChild
			this.childCascadeFor_Currency_CURChild();
						
		
}

protected void doParentAdjustments() throws ServerException
{
	
	
	

}


protected void update_doNonAlterabilityCheck() throws ServerException
{
	
	// Column Non Alterability check
	
		
		
		
		
		
		
		
		
				
}

protected void update_computeStoredValues() throws ServerException
{
	if ( isChanged("CUR_OrderValueUSD") )
				getCUR_OrderValueUSD();

	if ( isChanged("CUR_OrderAmountAverage") )
				getCUR_OrderAmountAverage();

	
	}

	 
		/**
		 *  Formula based derivation rule for CUR_OrderAmountAverage
		 *  
		 *  If ( CUR_NumberOfOrders>0) Then 
		 *      			$value= CUR_OrderValueUSD / CUR_NumberOfOrders
		 *      		Else
		 *      			$value= 0
		 *      		End if
		 */ 
		protected void setFormulaValues_CUR_OrderAmountAverage ()
		  {
		  	Data dataVal = null;
			VSTraceHelper tr = null;       	
		  
							try {
			
				tr = VSTrace.IS_ON ? new VSTraceHelper(logger, "VST_RULE_DERIVATION", this.getClass().getName() + "_" + "CUR_OrderAmountAverage" ) : null;
				if (logger.isDebugEnabled()) logger.debug("Deriving CUR_OrderAmountAverage");
				dataVal = getData("CUR_OrderAmountAverage");
					if ( isChanged("CUR_NumberOfOrders") || isChanged("CUR_OrderValueUSD") ) {
								getCUR_NumberOfOrders();
								getCUR_OrderValueUSD();
								
								
	if (( this.getCUR_NumberOfOrders() > 0 )) { 	
setCUR_OrderAmountAverage(this.getCUR_OrderValueUSD().divide(getData("CUR_NumberOfOrders").getBigDecimal(), getScaleConst(), Data.getRoundMode(getSession())));
} else {	
setCUR_OrderAmountAverage((new BigDecimal("0")));
	}
							}
					dataVal.setInitialized(true);
				
			} 
			catch (Exception ex) {
				handleAttributeFormulaException(ex, "CUR_OrderAmountAverage");
			} 
			finally {	
				boolean isChanged = isChanged("CUR_OrderAmountAverage");
				if (isChanged && isServerEventTracingEnabled()) addServerEvent("VST_RULE_FIRE.FORMULA_" + this.getClass().getName() + "." + "CUR_OrderAmountAverage = " + getData("CUR_OrderAmountAverage").getString() + " IsChanged = " + isChanged + " Object = " + this.toString(), (String)null, Session.RULE_EVENT);
				if ( tr != null) {
					if (isChanged )  {                 
						tr.set( "VST_RULE_FIRE.FORMULA_" + this.getClass().getName() + "." + "CUR_OrderAmountAverage = ", getData("CUR_OrderAmountAverage").getString() );
					}
					tr.end();
				}
			}
		}
			
			
			// non-persistent attribute CUR_Image is not set in setFormulaValues_XXX methods by design. 
		  
	
protected void setFormulaValues()
	{	
	
		
			this.setFormulaValues_CUR_OrderAmountAverage ();
		  
	}		  
protected void setFormulaValuesWithoutException()
{
	
	VSTraceHelper tr = null;  
	Data dataVal = null;

	tr = VSTrace.IS_ON ? new VSTraceHelper(logger, "VST_RULE_FORMULA", this.getClass().getName() + "_" + "CUR_OrderAmountAverage") : null;
			try {
				dataVal = getData("CUR_OrderAmountAverage");
					
						if ( isChanged("CUR_NumberOfOrders") || isChanged("CUR_OrderValueUSD") ) {
									getCUR_NumberOfOrders();
								getCUR_OrderValueUSD();
								
								
	if (( this.getCUR_NumberOfOrders() > 0 )) { 	
setCUR_OrderAmountAverage(this.getCUR_OrderValueUSD().divide(getData("CUR_NumberOfOrders").getBigDecimal(), getScaleConst(), Data.getRoundMode(getSession())));
} else {	
setCUR_OrderAmountAverage((new BigDecimal("0")));
	}
							}
						
					
					dataVal.setInitialized(true);
				
			} catch (ServerException serverException){
				handleException(serverException);
			} catch (Exception ex) {
				// handleAttributeFormulaException(ex, "CUR_OrderAmountAverage");
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




		protected void parentCheckFor_Currency_CURParent()
	{
		if (logger.isDebugEnabled()) logger.debug("parentCheckFor_Currency_CURParent " + this.toString());
		VSTraceHelper tr = VSTrace.IS_ON ? new VSTraceHelper(logger, VST_RULE, "parentCheckFor_Currency_CURParent", "Currency_CUR") : null;
	
		try {
		Currency_CURImpl	parent = null;
		boolean		ParentKeyChanged = false;
		boolean		OrphanChildParenting;
		if (( isInserted() || isUpdated() ) && ( 
			(isChanged("CUR_Client_RelatedTo")) || 	(isChanged("CUR_CurrencyCode_RelatedTo")) )&&
		 	( (!isNull("CUR_Client_RelatedTo")) && 	(!isNull("CUR_CurrencyCode_RelatedTo"))
			 ))
			{
				// This would cause the row to be dropped from the old parent if it exist.
				removeMeFromCurrency_CURParentCache();
				parent = this.getCurrency_CURParent();
					
				if ( parent == null )
				{
					raiseException("Currency_CUR not found for Currency_CUR.");
						
				}
				else
				{
					// Add myself to the new parent cache.
					parent.updateCacheForCurrency_CURChild(this, false);
				}
				
			}
		
		
		
				
		
			
				
		}
		finally {
		if (tr != null) tr.end(); 
		}
	
	
	}	
	



protected void childCascadeFor_cORDfCUR()
{
	 if (logger.isDebugEnabled()) logger.debug("childCascadeFor_cORDfCUR " + this.toString());
		VSTraceHelper tr = VSTrace.IS_ON ? new VSTraceHelper(logger, VST_RULE, "childCascadeFor_cORDfCUR", "Currency_CUR") : null;  
		try {	
		
				boolean pkeyChanged = false;
			boolean replicatedAttrChanged = false;
			Enumeration	children;
			// First find out if the Primary key has changed.
			if (( isUpdated() == true ) &&( 
						(isChanged("CUR_Client")) || 	(isChanged("CUR_CurrencyCode")) )) {    
					pkeyChanged = true;
				}
		 	// See if the maintained replicate needs to be cascaded i.e. if it has changed.
		
		if (( isUpdated() )&& ( 1 == 0
			
							|| (isChanged("CUR_ExchangeRate"))
							 ))
				replicatedAttrChanged = true;
			else
				replicatedAttrChanged = false;
				
				 // Now do the Cascade.
    		if (isDeleted())
    		{
    				// no need to load all children into cache for a delete
      			children = getOldcORDfCUR(false);
      			if ( children.hasMoreElements() ) // There are children found
      			{
      					raiseException("Delete Rejected because there are OrderItem_ORD found for Currency_CUR");
						
					   }
					     }
	else if ( pkeyChanged || replicatedAttrChanged )
		{
      boolean saveCurrentCacheStatus = cacheChildrenForcORDfCUR;
      cacheChildrenForcORDfCUR = false;  // force a cache bypass
			children = pkeyChanged ? getOldcORDfCUR() : getcORDfCUR();
      cacheChildrenForcORDfCUR = saveCurrentCacheStatus;
	
		if ( children.hasMoreElements() ) // There are children found
			{
					// This is the case for an Update.
				while (children.hasMoreElements())
							{
								OrderItem_ORDBaseImpl	child = null;
								// The getChildren function returns the child objects on the right context.
								child = (OrderItem_ORDBaseImpl)children.nextElement();
								child.setORD_Client(this.getCUR_Client());
								child.setORD_CurrencyCode(this.getCUR_CurrencyCode());
									if (isNull("CUR_ExchangeRate")) {
											child.getData("ORD_ExchangeRate").setValue(null);
                      child.getData("ORD_ExchangeRate").setPushPending(true);
										} else {
                        if(!isChanged("CUR_ExchangeRate") && !child.getData("ORD_ExchangeRate").getMetaColumn().isVirtual())
                            child.getData("ORD_ExchangeRate").setPushPending(false); //MD!!!
                        else {
                            child.setORD_ExchangeRate(this.getCUR_ExchangeRate());
                            child.getData("ORD_ExchangeRate").setPushPending(true);
                        }
                     }	
			 				child.setUpdate();
								child.executeRules();
							}
							
						}
	
				}
		
		}finally{   if (  tr != null ) tr.end( );
		
		}	
}
protected void childCascadeFor_Currency_CURChild()
{
	 if (logger.isDebugEnabled()) logger.debug("childCascadeFor_Currency_CURChild " + this.toString());
		VSTraceHelper tr = VSTrace.IS_ON ? new VSTraceHelper(logger, VST_RULE, "childCascadeFor_Currency_CURChild", "Currency_CUR") : null;  
		try {	
		
				boolean pkeyChanged = false;
			boolean replicatedAttrChanged = false;
			Enumeration	children;
			// First find out if the Primary key has changed.
			if (( isUpdated() == true ) &&( 
						(isChanged("CUR_Client")) || 	(isChanged("CUR_CurrencyCode")) )) {    
					pkeyChanged = true;
				}
		 	
				 // Now do the Cascade.
    		if (isDeleted())
    		{
    				// no need to load all children into cache for a delete
      			children = getOldCurrency_CURChild(false);
      			if ( children.hasMoreElements() ) // There are children found
      			{
      					raiseException("Delete Rejected because there are Currency_CUR found for Currency_CUR");
						
					   }
					     }
	else if ( pkeyChanged || replicatedAttrChanged )
		{
      boolean saveCurrentCacheStatus = cacheChildrenForCurrency_CURChild;
      cacheChildrenForCurrency_CURChild = false;  // force a cache bypass
			children = pkeyChanged ? getOldCurrency_CURChild() : getCurrency_CURChild();
      cacheChildrenForCurrency_CURChild = saveCurrentCacheStatus;
	
		if ( children.hasMoreElements() ) // There are children found
			{
					// This is the case for an Update.
			if ( pkeyChanged )
						{	
							
							raiseException("Update Rejected because there are Currency_CUR found for Currency_CUR");
						 }
			 				
						}
	
				}
		
		}finally{   if (  tr != null ) tr.end( );
		
		}	
}





		  


	





	    // variable to track if the cache is valid - it is valid if it is initially populated with a search request
		// which would have taken into account the values from DB as well.
		private boolean cacheChildrenForcORDfCURConsistent = false;
		private boolean cacheChildrenForcORDfCUR = true;
		private boolean cacheForcORDfCURPopulatedInTxn = false;
		private ObjectHashtable objectCacheForcORDfCUR = null;
		
		/**	  
		* <br>
		* method to retrieve the OrderItem_ORD objects for this Currency_CUR
		* this method currently does not support additional conditional params.
		* @return Enumeration : the Enumeration of OrderItem_ORD objects.
		*/
		public Enumeration getcORDfCUR()
		{
			if (cacheChildrenForcORDfCUR && cacheChildrenForcORDfCURConsistent)
			{
				if ( objectCacheForcORDfCUR != null ) return objectCacheForcORDfCUR.elements();
			}
			// if we're not caching OR the cache is null 
			SearchRequest searchReq = new SearchRequest();
			Parameter param;
 			param = new Parameter("OrderItem_ORD", "ORD_Client", getData("CUR_Client").getString(), repositoryName);
					  searchReq.add(param);
			param = new Parameter("OrderItem_ORD", "ORD_CurrencyCode", getData("CUR_CurrencyCode").getString(), repositoryName);
					  searchReq.add(param);
			
 			if (cacheChildrenForcORDfCUR)
			{
				objectCacheForcORDfCUR = new ObjectHashtable();
				cacheForcORDfCURPopulatedInTxn = getSession().isTransactionInProgress();
				for (Enumeration e = (OrderItem_ORDBaseImpl.getObjects(searchReq ,getSession())); e.hasMoreElements();)
				{
					DataObject cacheBO = (DataObject)e.nextElement();
					DataRow row = cacheBO.getRow();
					Vector pkey = row.getPkeyParams();
					objectCacheForcORDfCUR.put(pkey,cacheBO);								
				}
				// cacheChildrenForcORDfCURConsistent set to true as the value is got from search request.
				cacheChildrenForcORDfCURConsistent = true;
				return (objectCacheForcORDfCUR.elements());
			}
			else
			{
				return (OrderItem_ORDBaseImpl.getObjects(searchReq ,getSession()));
			}
		}

		/**	  
		* <br>
		* Method to create a new instance of the OrderItem_ORD object for this Currency_CUR
		* @return OrderItem_ORD object with the foreign key set into it.
		*/
		public OrderItem_ORDImpl newInstanceForcORDfCUR()
		{
		
			OrderItem_ORDImpl childObj = (OrderItem_ORDImpl) OrderItem_ORDImpl.getNewObject(getSession(), true); 
 			
			childObj.setORD_Client(getData("CUR_Client").getString());
			
			childObj.setORD_CurrencyCode(getData("CUR_CurrencyCode").getString());
			
			addToChildObjsList_(childObj);
			return childObj;
		}
		
	    // variable to track if the cache is valid - it is valid if it is initially populated with a search request
		// which would have taken into account the values from DB as well.
		private boolean cacheChildrenForCurrency_CURChildConsistent = false;
		private boolean cacheChildrenForCurrency_CURChild = true;
		private boolean cacheForCurrency_CURChildPopulatedInTxn = false;
		private ObjectHashtable objectCacheForCurrency_CURChild = null;
		
		/**	  
		* <br>
		* method to retrieve the Currency_CUR objects for this Currency_CUR
		* this method currently does not support additional conditional params.
		* @return Enumeration : the Enumeration of Currency_CUR objects.
		*/
		public Enumeration getCurrency_CURChild()
		{
			if (cacheChildrenForCurrency_CURChild && cacheChildrenForCurrency_CURChildConsistent)
			{
				if ( objectCacheForCurrency_CURChild != null ) return objectCacheForCurrency_CURChild.elements();
			}
			// if we're not caching OR the cache is null 
			SearchRequest searchReq = new SearchRequest();
			Parameter param;
 			param = new Parameter("Currency_CUR", "CUR_Client_RelatedTo", getData("CUR_Client").getString(), repositoryName);
					  searchReq.add(param);
			param = new Parameter("Currency_CUR", "CUR_CurrencyCode_RelatedTo", getData("CUR_CurrencyCode").getString(), repositoryName);
					  searchReq.add(param);
			
 			if (cacheChildrenForCurrency_CURChild)
			{
				objectCacheForCurrency_CURChild = new ObjectHashtable();
				cacheForCurrency_CURChildPopulatedInTxn = getSession().isTransactionInProgress();
				for (Enumeration e = (Currency_CURBaseImpl.getObjects(searchReq ,getSession())); e.hasMoreElements();)
				{
					DataObject cacheBO = (DataObject)e.nextElement();
					DataRow row = cacheBO.getRow();
					Vector pkey = row.getPkeyParams();
					objectCacheForCurrency_CURChild.put(pkey,cacheBO);								
				}
				// cacheChildrenForCurrency_CURChildConsistent set to true as the value is got from search request.
				cacheChildrenForCurrency_CURChildConsistent = true;
				return (objectCacheForCurrency_CURChild.elements());
			}
			else
			{
				return (Currency_CURBaseImpl.getObjects(searchReq ,getSession()));
			}
		}

		/**	  
		* <br>
		* Method to create a new instance of the Currency_CUR object for this Currency_CUR
		* @return Currency_CUR object with the foreign key set into it.
		*/
		public Currency_CURImpl newInstanceForCurrency_CURChild()
		{
		
			Currency_CURImpl childObj = (Currency_CURImpl) Currency_CURImpl.getNewObject(getSession(), true); 
 			
			childObj.setCUR_Client_RelatedTo(getData("CUR_Client").getString());
			
			childObj.setCUR_CurrencyCode_RelatedTo(getData("CUR_CurrencyCode").getString());
			
			addToChildObjsList_(childObj);
			return childObj;
		}
		

/**	  
		* <br>
		* method to retrieve the old OrderItem_ORD objects for this  Currency_CUR
		* Old OrderItem_ORD objects would be different from the new ones if
		* the  Currency_CUR has a primary key change.
		* @param useCache whether the relationship cache is to be used. Will result in all objects being fetched into
        * memory if they have not been cached yet.
		* @return Enumeration : the Enumeration of old OrderItem_ORD objects.
		*/
  public Enumeration getOldcORDfCUR(boolean useCache)
  {
    boolean oldCacheValue = cacheChildrenForcORDfCUR;
    cacheChildrenForcORDfCUR = useCache;
    try {
      return getOldcORDfCUR();
    } 
    finally {                     
      cacheChildrenForcORDfCUR = oldCacheValue;
    }			
  }
		
    /**	  
		* <br>
		* method to retrieve the old OrderItem_ORD objects for this  Currency_CUR
		* old OrderItem_ORD objects would be different from the new ones if
		* the  Currency_CUR has a primary key change.  This method will use the relationship
		* cache if applicable.
		* This method currently does not support additional conditional params.
		* @return Enumeration : the Enumeration of old OrderItem_ORD objects.
		*/
		public Enumeration	getOldcORDfCUR()
		{
			if (cacheChildrenForcORDfCUR && cacheChildrenForcORDfCURConsistent)
			{
				if ( objectCacheForcORDfCUR != null ) return objectCacheForcORDfCUR.elements();
			}

			SearchRequest searchReq = new SearchRequest();
			Parameter param;
			param = new Parameter("OrderItem_ORD", "ORD_Client", getData("CUR_Client").getPreviousString(), repositoryName);
					  searchReq.add(param);
			param = new Parameter("OrderItem_ORD", "ORD_CurrencyCode", getData("CUR_CurrencyCode").getPreviousString(), repositoryName);
					  searchReq.add(param);
			
			if (cacheChildrenForcORDfCUR)
			{
				objectCacheForcORDfCUR = new ObjectHashtable();
				cacheForcORDfCURPopulatedInTxn = getSession().isTransactionInProgress();

				for (Enumeration e = (OrderItem_ORDBaseImpl.getObjects(searchReq ,getSession())); e.hasMoreElements();)
				{
					DataObject cacheBO = (DataObject)e.nextElement();
					DataRow row = cacheBO.getRow();
					Vector pkey = row.getPkeyParams();
					objectCacheForcORDfCUR.put(pkey,cacheBO);								
				}
				// consistent set to false because, it is populated with old primary key's values.
				cacheChildrenForcORDfCURConsistent = false;
				return (objectCacheForcORDfCUR.elements());
			}
			else
			{
				return (OrderItem_ORDBaseImpl.getObjects(searchReq ,getSession()));
			}
		}
		/**	  
		* <br>
		* method to retrieve the old Currency_CUR objects for this  Currency_CUR
		* Old Currency_CUR objects would be different from the new ones if
		* the  Currency_CUR has a primary key change.
		* @param useCache whether the relationship cache is to be used. Will result in all objects being fetched into
        * memory if they have not been cached yet.
		* @return Enumeration : the Enumeration of old Currency_CUR objects.
		*/
  public Enumeration getOldCurrency_CURChild(boolean useCache)
  {
    boolean oldCacheValue = cacheChildrenForCurrency_CURChild;
    cacheChildrenForCurrency_CURChild = useCache;
    try {
      return getOldCurrency_CURChild();
    } 
    finally {                     
      cacheChildrenForCurrency_CURChild = oldCacheValue;
    }			
  }
		
    /**	  
		* <br>
		* method to retrieve the old Currency_CUR objects for this  Currency_CUR
		* old Currency_CUR objects would be different from the new ones if
		* the  Currency_CUR has a primary key change.  This method will use the relationship
		* cache if applicable.
		* This method currently does not support additional conditional params.
		* @return Enumeration : the Enumeration of old Currency_CUR objects.
		*/
		public Enumeration	getOldCurrency_CURChild()
		{
			if (cacheChildrenForCurrency_CURChild && cacheChildrenForCurrency_CURChildConsistent)
			{
				if ( objectCacheForCurrency_CURChild != null ) return objectCacheForCurrency_CURChild.elements();
			}

			SearchRequest searchReq = new SearchRequest();
			Parameter param;
			param = new Parameter("Currency_CUR", "CUR_Client_RelatedTo", getData("CUR_Client").getPreviousString(), repositoryName);
					  searchReq.add(param);
			param = new Parameter("Currency_CUR", "CUR_CurrencyCode_RelatedTo", getData("CUR_CurrencyCode").getPreviousString(), repositoryName);
					  searchReq.add(param);
			
			if (cacheChildrenForCurrency_CURChild)
			{
				objectCacheForCurrency_CURChild = new ObjectHashtable();
				cacheForCurrency_CURChildPopulatedInTxn = getSession().isTransactionInProgress();

				for (Enumeration e = (Currency_CURBaseImpl.getObjects(searchReq ,getSession())); e.hasMoreElements();)
				{
					DataObject cacheBO = (DataObject)e.nextElement();
					DataRow row = cacheBO.getRow();
					Vector pkey = row.getPkeyParams();
					objectCacheForCurrency_CURChild.put(pkey,cacheBO);								
				}
				// consistent set to false because, it is populated with old primary key's values.
				cacheChildrenForCurrency_CURChildConsistent = false;
				return (objectCacheForCurrency_CURChild.elements());
			}
			else
			{
				return (Currency_CURBaseImpl.getObjects(searchReq ,getSession()));
			}
		}
		

		public void updateCacheForcORDfCUR(OrderItem_ORDBaseImpl child, boolean remove)
		{
			
			if ( objectCacheForcORDfCUR == null ) {
			    objectCacheForcORDfCUR = new ObjectHashtable();
			    // cacheChildrenForcORDfCURConsistent set to false, as the values in db are not retreived here.
			    cacheChildrenForcORDfCURConsistent = false;
				cacheForcORDfCURPopulatedInTxn = getSession().isTransactionInProgress();
			}
			if ( child != null ) {
				if ( remove ) {
					if ( objectCacheForcORDfCUR.containsKey(child.getRow().getPkeyParams()) )
						objectCacheForcORDfCUR.remove(child.getRow().getPkeyParams());
				}
				else {
					// Add only if it is not in the cache.
					if ( ! objectCacheForcORDfCUR.containsKey(child.getRow().getPkeyParams()) )
						objectCacheForcORDfCUR.put(child.getRow().getPkeyParams(), child);
				}
			}
		}
		public void updateCacheForCurrency_CURChild(Currency_CURBaseImpl child, boolean remove)
		{
			
			if ( objectCacheForCurrency_CURChild == null ) {
			    objectCacheForCurrency_CURChild = new ObjectHashtable();
			    // cacheChildrenForCurrency_CURChildConsistent set to false, as the values in db are not retreived here.
			    cacheChildrenForCurrency_CURChildConsistent = false;
				cacheForCurrency_CURChildPopulatedInTxn = getSession().isTransactionInProgress();
			}
			if ( child != null ) {
				if ( remove ) {
					if ( objectCacheForCurrency_CURChild.containsKey(child.getRow().getPkeyParams()) )
						objectCacheForCurrency_CURChild.remove(child.getRow().getPkeyParams());
				}
				else {
					// Add only if it is not in the cache.
					if ( ! objectCacheForCurrency_CURChild.containsKey(child.getRow().getPkeyParams()) )
						objectCacheForCurrency_CURChild.put(child.getRow().getPkeyParams(), child);
				}
			}
		}

/**	
* Invalidates the relationship cache. Called by the system on transaction begin.
*/
public void invalidateNonTransactionCaches() 
{
	  if( !cacheForcORDfCURPopulatedInTxn )
                objectCacheForcORDfCUR = null;
	  if( !cacheForCurrency_CURChildPopulatedInTxn )
                objectCacheForCurrency_CURChild = null;
}

	
		public void removeMeFromCurrency_CURParentCache()
		{
			SearchRequest searchReq = new SearchRequest();
			Parameter param;
			param = new Parameter("Currency_CUR", "CUR_Client", getData("CUR_Client_RelatedTo").getPreviousString(), repositoryName);
					  searchReq.add(param);
			param = new Parameter("Currency_CUR", "CUR_CurrencyCode", getData("CUR_CurrencyCode_RelatedTo").getPreviousString(), repositoryName);
					  searchReq.add(param);
			
			if (getSession().getTransactionInfo().isInCache( Currency_CURImpl.getMetaQuery(), searchReq))
			{
				 Currency_CURBaseImpl	parent = this.getOldCurrency_CURParent();
				parent.updateCacheForCurrency_CURChild(this, true);
			}
		}

/**	  
		* <br>
		* method to get the  Currency_CUR object for this Currency_CUR
		* this method currently does not support additional conditional params.
		* @return Object : the  parent object  Currency_CUR for this Currency_CUR.
		*/
		public	 Currency_CURImpl	getCurrency_CURParent()
		{
			 Currency_CURImpl parent = null;
			SearchRequest searchReq = new SearchRequest();
			Parameter param;
			param = new Parameter("Currency_CUR", "CUR_Client", getData("CUR_Client_RelatedTo").getString(), repositoryName);
					  searchReq.add(param);
			param = new Parameter("Currency_CUR", "CUR_CurrencyCode", getData("CUR_CurrencyCode_RelatedTo").getString(), repositoryName);
					  searchReq.add(param);
			
			parent = ( Currency_CURImpl)( Currency_CURBaseImpl.getObjectByKey(searchReq ,getSession()));
			return parent;
		}		/**	  
		* <br>
		* method to set the  Currency_CUR object for this Currency_CUR.
		* @param Object : the  parent object  Currency_CUR for this Currency_CUR.
		*/
		public	void	setCurrency_CURParent( Currency_CURImpl parentObj)
		{
			this.setCUR_Client_RelatedTo(parentObj.getCUR_Client());
			this.setCUR_CurrencyCode_RelatedTo(parentObj.getCUR_CurrencyCode());
			
		
		}
/**	  
		* <br>
		* method to get the old  Currency_CUR object for this Currency_CUR
		* this method currently does not support additional conditional params.
		* @return Object : the  old parent object  Currency_CUR for this Currency_CUR.
		*/
		public	 Currency_CURImpl	getOldCurrency_CURParent()
		{
			 Currency_CURImpl parent = null;
			SearchRequest searchReq = new SearchRequest();
			Parameter param;
		param = new Parameter("Currency_CUR", "CUR_Client", getData("CUR_Client_RelatedTo").getPreviousString(), repositoryName);
					  searchReq.add(param);
			param = new Parameter("Currency_CUR", "CUR_CurrencyCode", getData("CUR_CurrencyCode_RelatedTo").getPreviousString(), repositoryName);
					  searchReq.add(param);
			
			parent = ( Currency_CURImpl)( Currency_CURBaseImpl.getObjectByKey(searchReq ,getSession()));
			return parent;
		}
	/**	  
	* <br>
	* method to get the CUR_CurrencyCode attribute for the Currency_CUR
	* @return String : the  value of the attribute CUR_CurrencyCode as String.
	*/
	public String	getCUR_CurrencyCode() 
	{
		return getData("CUR_CurrencyCode").getString();
	}
	/**	  
	* <br>
	* method to set the CUR_CurrencyCode attribute for the Currency_CUR
	* @param value String : value of the attribute CUR_CurrencyCode as String.
	*/
	public void	setCUR_CurrencyCode(String value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("CUR_CurrencyCode");
		dataVal.setString(value);
	}

	/**	  
	* <br>
	* method to get the old CUR_CurrencyCode attribute for the Currency_CUR
	* @return String : the  value of the old attribute CUR_CurrencyCode as String.
	*/
	public String	getOldCUR_CurrencyCode()
	{
		return getData("CUR_CurrencyCode").getPreviousString();
	}
		/**	  
	* <br>
	* method to get the CUR_ExchangeRate attribute for the Currency_CUR
	* @return BigDecimal : the  value of the attribute CUR_ExchangeRate as BigDecimal.
	*/
	public BigDecimal	getCUR_ExchangeRate() 
	{
		return getData("CUR_ExchangeRate").getBigDecimal();
	}
	/**	  
	* <br>
	* method to set the CUR_ExchangeRate attribute for the Currency_CUR
	* @param value BigDecimal : value of the attribute CUR_ExchangeRate as BigDecimal.
	*/
	public void	setCUR_ExchangeRate(BigDecimal value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("CUR_ExchangeRate");
		dataVal.setBigDecimal(value);
	}

	/**	  
	* <br>
	* method to get the old CUR_ExchangeRate attribute for the Currency_CUR
	* @return BigDecimal : the  value of the old attribute CUR_ExchangeRate as BigDecimal.
	*/
	public BigDecimal	getOldCUR_ExchangeRate()
	{
		return getData("CUR_ExchangeRate").getPreviousBigDecimal();
	}
		/**	  
	* <br>
	* method to get the CUR_Client_RelatedTo attribute for the Currency_CUR
	* @return String : the  value of the attribute CUR_Client_RelatedTo as String.
	*/
	public String	getCUR_Client_RelatedTo() 
	{
		return getData("CUR_Client_RelatedTo").getString();
	}
	/**	  
	* <br>
	* method to set the CUR_Client_RelatedTo attribute for the Currency_CUR
	* @param value String : value of the attribute CUR_Client_RelatedTo as String.
	*/
	public void	setCUR_Client_RelatedTo(String value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("CUR_Client_RelatedTo");
		dataVal.setString(value);
	}

	/**	  
	* <br>
	* method to get the old CUR_Client_RelatedTo attribute for the Currency_CUR
	* @return String : the  value of the old attribute CUR_Client_RelatedTo as String.
	*/
	public String	getOldCUR_Client_RelatedTo()
	{
		return getData("CUR_Client_RelatedTo").getPreviousString();
	}
		/**	  
	* <br>
	* method to get the CUR_CurrencyCode_RelatedTo attribute for the Currency_CUR
	* @return String : the  value of the attribute CUR_CurrencyCode_RelatedTo as String.
	*/
	public String	getCUR_CurrencyCode_RelatedTo() 
	{
		return getData("CUR_CurrencyCode_RelatedTo").getString();
	}
	/**	  
	* <br>
	* method to set the CUR_CurrencyCode_RelatedTo attribute for the Currency_CUR
	* @param value String : value of the attribute CUR_CurrencyCode_RelatedTo as String.
	*/
	public void	setCUR_CurrencyCode_RelatedTo(String value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("CUR_CurrencyCode_RelatedTo");
		dataVal.setString(value);
	}

	/**	  
	* <br>
	* method to get the old CUR_CurrencyCode_RelatedTo attribute for the Currency_CUR
	* @return String : the  value of the old attribute CUR_CurrencyCode_RelatedTo as String.
	*/
	public String	getOldCUR_CurrencyCode_RelatedTo()
	{
		return getData("CUR_CurrencyCode_RelatedTo").getPreviousString();
	}
		/**	  
	* <br>
	* method to get the CUR_Client attribute for the Currency_CUR
	* @return String : the  value of the attribute CUR_Client as String.
	*/
	public String	getCUR_Client() 
	{
		return getData("CUR_Client").getString();
	}
	/**	  
	* <br>
	* method to set the CUR_Client attribute for the Currency_CUR
	* @param value String : value of the attribute CUR_Client as String.
	*/
	public void	setCUR_Client(String value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("CUR_Client");
		dataVal.setString(value);
	}

	/**	  
	* <br>
	* method to get the old CUR_Client attribute for the Currency_CUR
	* @return String : the  value of the old attribute CUR_Client as String.
	*/
	public String	getOldCUR_Client()
	{
		return getData("CUR_Client").getPreviousString();
	}
	
/**	  
	* <br>
	* method to get the summed attribute CUR_OrderValueUSD for the Currency_CUR
	* Description: 
	* @return BigDecimal : the  value of the attribute CUR_OrderValueUSD as BigDecimal.
	*/
	public BigDecimal	getCUR_OrderValueUSD()
	{
		 /**@ Not a virtual @**/
			Data dataVal = getData("CUR_OrderValueUSD");
			if (dataVal.isComputationPending() ||  ( this.isCurrentEvent("RECOMPUTE_DERIVATIONS") && (getGlobalNestLevel() == 1) ))
			{
				if (dataVal.isDeltaValid() && !( this.isCurrentEvent("RECOMPUTE_DERIVATIONS") && (getGlobalNestLevel() == 1) ))
				{
					
							if ( dataVal.getBigDecimal() == null ) 
							dataVal.setBigDecimal(dataVal.getDeltaBigDecimal());
						else
							dataVal.setBigDecimal(dataVal.getBigDecimal().add(dataVal.getDeltaBigDecimal()));
					
					dataVal.setDeltaValid(false);
				}
				else
				{
					SearchRequest searchReq = new SearchRequest();
					Parameter param = null;
					
						param = new Parameter();
						param.objName = "OrderItem_ORD";
						param.fieldName = "ORD_Client";
						if (getSession().isTransactionInProgress())
						{
							if ((getGlobalNestLevel() == 1) && (isChanged("CUR_Client")))
								param.value = getData("CUR_Client").getOldString();
							else
								param.value = getData("CUR_Client").getString();
						}
						else
						{
							param.value = getData("CUR_Client").getString();
						}
						param.repositoryName = repositoryName;
						searchReq.add(param);
					
						param = new Parameter();
						param.objName = "OrderItem_ORD";
						param.fieldName = "ORD_CurrencyCode";
						if (getSession().isTransactionInProgress())
						{
							if ((getGlobalNestLevel() == 1) && (isChanged("CUR_CurrencyCode")))
								param.value = getData("CUR_CurrencyCode").getOldString();
							else
								param.value = getData("CUR_CurrencyCode").getString();
						}
						else
						{
							param.value = getData("CUR_CurrencyCode").getString();
						}
						param.repositoryName = repositoryName;
						searchReq.add(param);
					
					dataVal.setBigDecimal((OrderItem_ORDBaseImpl.getCurrency_CURCUR_OrderValueUSD(searchReq, "ORD_AmountInUSD", getSession())));
				}
				dataVal.setInitialized(true);
				dataVal.setPushPending(false);
			}
			return dataVal.getBigDecimal();
		
	}

			/**	  
		* <br>
		* method to get the value before data change for the summed attribute CUR_OrderValueUSD
		* in the data object Currency_CUR
		* @return BigDecimal : the  value of the attribute CUR_OrderValueUSD as BigDecimal before change.
		*/
		public BigDecimal	getOldCUR_OrderValueUSD()
		{
				return getData("CUR_OrderValueUSD").getPreviousBigDecimal();
		}

		/**	  
		* <br>
		* method to set the value of the summed attribute CUR_OrderValueUSD in the data object Currency_CUR
		* @param value BigDecimal : value of the attribute CUR_OrderValueUSD as BigDecimal.
		*/
		public void setCUR_OrderValueUSD(BigDecimal value)
		{
			// The code to do convertion from the primitive data
			// to the one which can be stored goes here.
			Data dataVal = getData("CUR_OrderValueUSD");
			dataVal.setBigDecimal(value);
		}
	


/**	  
	* <br>
	* method to get the count attribute CUR_NumberOfOrders for the Currency_CUR
	* Description: 
	* @return int : the  value of the attribute CUR_NumberOfOrders as int.
	*/
	public int	getCUR_NumberOfOrders() 
	{
		Data dataVal = null;
		 boolean security = ((VSORBSessionImpl)session).getSecurityCheck();
		try
		{
			((VSORBSessionImpl)session).setSecurityCheck(false);
		
		SearchRequest searchReq = new SearchRequest();
		Parameter param = null;
			param = new Parameter();
			param.objName = "OrderItem_ORD";
			param.fieldName = "ORD_Client";
			if (getSession().isTransactionInProgress())
			{
				if ( isUpdated() && (getGlobalNestLevel() == 1) && (isChanged("CUR_Client")))
					param.value = getData("CUR_Client").getOldString();
				else
					param.value = getData("CUR_Client").getString();
			}
			else
			{
				param.value = getData("CUR_Client").getString();
			}
			param.repositoryName = repositoryName;
			searchReq.add(param);
			param = new Parameter();
			param.objName = "OrderItem_ORD";
			param.fieldName = "ORD_CurrencyCode";
			if (getSession().isTransactionInProgress())
			{
				if ( isUpdated() && (getGlobalNestLevel() == 1) && (isChanged("CUR_CurrencyCode")))
					param.value = getData("CUR_CurrencyCode").getOldString();
				else
					param.value = getData("CUR_CurrencyCode").getString();
			}
			else
			{
				param.value = getData("CUR_CurrencyCode").getString();
			}
			param.repositoryName = repositoryName;
			searchReq.add(param);
		

			dataVal = getData("CUR_NumberOfOrders");											
	
			
			if (((dataVal.isComputationPending()) || (!(dataVal.isInitialized()) )) && (!isNull("CUR_Client") && 	!isNull("CUR_CurrencyCode") ))
			{	
				if(dataVal.isComputationPending()){

				    // calling set alterns the isModified flag, so we only want to do it if computationPending.
				    dataVal.setint((OrderItem_ORDBaseImpl.getCurrency_CURCUR_NumberOfOrders(searchReq, getSession())));
				    dataVal.setInitialized(true);

				}else if(!(dataVal.isInitialized())){

				    // in this case we want the value set, but not alter the isModified flag.
				    dataVal.initint((OrderItem_ORDBaseImpl.getCurrency_CURCUR_NumberOfOrders(searchReq, getSession())));	
				    dataVal.setInitialized(true);

				}           

				dataVal.setPushPending(false);
			}

			
			} /**@ this is the closing brace for try statement @**/
			finally
			{
				((VSORBSessionImpl)session).setSecurityCheck(security);
			}

			return dataVal.getint();
		
	}

	


	/**	  
	* <br>
	* method to get the CUR_OrderAmountAverage attribute for the Currency_CUR
	* Description: 
	* @return BigDecimal : the  value of the attribute CUR_OrderAmountAverage as BigDecimal.
	*/
	public BigDecimal	getCUR_OrderAmountAverage() 
	{
			Data dataVal = null;
			
				dataVal = getData("CUR_OrderAmountAverage");
			
			return dataVal.getBigDecimal();
	}


	/**	  
	* <br>
	* method to get the CUR_OrderAmountAverage attribute for the Currency_CUR
	* Description: 
	* @return BigDecimal : the  value of the attribute CUR_OrderAmountAverage as BigDecimal.
	*/
	public BigDecimal	getisNullCUR_OrderAmountAverage() 
	{
			Data dataVal = null;
			
				dataVal = getData("CUR_OrderAmountAverage");
			
			return dataVal.getBigDecimal();
	}



	/**	  
		* <br>
		* method to get the old CUR_OrderAmountAverage attribute for the Currency_CUR
		* @return BigDecimal : the  value of the old attribute CUR_OrderAmountAverage as BigDecimal.
		*/
		public BigDecimal	getOldCUR_OrderAmountAverage()
		{
			return getData("CUR_OrderAmountAverage").getPreviousBigDecimal();
		}
	

	/**	  
	* <br>
	* method to set the CUR_OrderAmountAverage attribute for the Currency_CUR
	* @param value BigDecimal : value of the attribute CUR_OrderAmountAverage as BigDecimal.
	*/
	public void setCUR_OrderAmountAverage(BigDecimal value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("CUR_OrderAmountAverage");
		dataVal.setBigDecimal(value);
	}

	/**	  
	* <br>
	* method to get the CUR_Image attribute for the Currency_CUR
	* Description: 
	* @return String : the  value of the attribute CUR_Image as String.
	*/
	public String	getCUR_Image() 
	{
			Data dataVal = null;
			boolean security = ((VSORBSessionImpl)session).getSecurityCheck();
				try
				{
					((VSORBSessionImpl)session).setSecurityCheck(false);
			
				dataVal = getData("CUR_Image");
						dataVal.initString((String)(getImage( )));
					dataVal.setInitialized(true);
				
				}
				catch (Exception ex)
				{
					handleAttributeFormulaException(ex, "CUR_Image");
				}
				finally
				{
					((VSORBSessionImpl)session).setSecurityCheck(security);
				}
			
			return dataVal.getString();
	}


	/**	  
	* <br>
	* method to get the CUR_Image attribute for the Currency_CUR
	* Description: 
	* @return String : the  value of the attribute CUR_Image as String.
	*/
	public String	getisNullCUR_Image() 
	{
			Data dataVal = null;
			boolean security = ((VSORBSessionImpl)session).getSecurityCheck();
				try
				{
					((VSORBSessionImpl)session).setSecurityCheck(false);
			
				dataVal = getData("CUR_Image");
						
					dataVal.setInitialized(true);
				
				}
				catch (Exception ex)
				{
					handleAttributeFormulaException(ex, "CUR_Image");
				}
				finally
				{
					((VSORBSessionImpl)session).setSecurityCheck(security);
				}
			
			return dataVal.getString();
	}



	

	/**	  
	* <br>
	* method to set the CUR_Image attribute for the Currency_CUR
	* @param value String : value of the attribute CUR_Image as String.
	*/
	public void setCUR_Image(String value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("CUR_Image");
		dataVal.setString(value);
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
		count = aSession.getTransactionInfo().getObjectsCount(Currency_CURBaseImpl.getMetaQuery(), xdac, searchReq);
	else
	{
		con = aSession.getConnection( xdac, true );
  	  	count = xdac.getRowCount( Currency_CURBaseImpl.getMetaQuery(), searchReq, con );
	}

  	return count;
  
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
		VSMetaTable table = Currency_CURBaseImpl.getMetaQuery().getChildMostTable();
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
		VSMetaTable table = Currency_CURBaseImpl.getMetaQuery().getChildMostTable();
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
	Properties props = ((VSORBSessionImpl)aSession).getMyDataServiceLoginForObject("Currency_CUR");
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
	
	
	
			if (logger.isDebugEnabled()) logger.debug("recomputing CUR_OrderValueUSD");
			this.setCUR_OrderValueUSD(getCUR_OrderValueUSD());
		
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

	public abstract boolean setRemoteUpdateCUR(String p0);

	public abstract String getImage();


//END_COMPONENT_RULES}}

	//{{ABSTRACT_CUSTOM_METHODS

	// User defined methods used in a rule are defined in the Impl class, and have corresponding abstract methods in the BaseImpl.



//END_ABSTRACT_CUSTOM_METHODS}}
}
