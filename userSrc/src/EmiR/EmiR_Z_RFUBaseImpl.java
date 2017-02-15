 
//{{COMPONENT_IMPORT_STMTS

package  EmiR;

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

//END_COMPONENT_IMPORT_STMTS}}

/**
* Enforces rules, in conjunction with [designated] Super, Event Handling sub, and methods invoked from rules.
* Instances are instantiated by BRMS runtime by decomposing Query Model updates.
* After rule enforcement, instances remain in transaction cache until end transaction,
*   when they are flushed to disk by their XDA.
*  
*/
 public abstract class EmiR_Z_RFUBaseImpl extends DataObject {
    
    public static VersataLogger logger = VersataLogger.getLogger(EmiR_Z_RFUImpl.class);
    
    protected EmiR_Z_RFUBaseImpl() {

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
	private static String modelName = "EmiR_Z_RFU";
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
			logger.debug("Initializing EmiR_Z_RFU");
		
		vsQueryDefinition= new VSQueryDefinition( "EmiR_Z_RFU" );
		vsQueryDefinition.setPackageName("EmiR");
		vsQueryDefinition.setRepositoryName(repositoryName);
		vsQueryDefinition.setDataObject(true);	
		
		
		
		
		VSMetaColumn c = null;
		VSMetaTable tableForSubObjRetQry = new VSMetaTable("EmiR_Z_RFU");
		
		//{{META_QUERY_COLUMN_CTOR
		
		
		
			c = new VSMetaColumn("RFU_RFURSN", DataConst.BIGINT);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.PK);
			c.setAutoIncrement(true);
			c.setAlterability(false);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setCaption("RFUrsn");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("RFU_ARTAL_FROM", DataConst.BIGINT);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setCaption("Årtal from");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("RFU_PERIOD_FROM", DataConst.BIGINT);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setCaption("Period from");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("RFU_KT2_FROM", DataConst.VARCHAR);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setSize(8);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setCaption("Konto del 2 from");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("RFU_KT2_TOM", DataConst.VARCHAR);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setSize(8);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setCaption("Konto del 2 tom");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("RFU_NIVA_FROM", DataConst.VARCHAR);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setSize(1);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setCaption("Nivå from");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("RFU_SUMMERA_UNIVA", DataConst.BIT);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNoNulls);
			c.setDefaultValue("False");
			c.setCaption("Summera under");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("RFU_RAPPID", DataConst.VARCHAR);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setSize(8);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setCaption("Rapport id");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("RFU_UTDATA", DataConst.VARCHAR);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setSize(50);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setCaption("Utdata");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("RFU_RGHRSN", DataConst.BIGINT);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setCaption("RGHrsn");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("RFU_BOLNR", DataConst.VARCHAR);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setSize(6);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setCaption("Bolag");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("RFU_BESKRIVNING", DataConst.VARCHAR);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setSize(70);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setCaption("Beskrivning");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("RFU_RAPPORTID", DataConst.VARCHAR);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setSize(50);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setCaption("RapportID");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("RFU_DATETIME", DataConst.TIMESTAMP);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setCaption("Körtid");
			tableForSubObjRetQry.addColumn( c );
			
    			
		VSMetaTable t = getTableForObjRetQuery(tableForSubObjRetQry);
		t.addUniqueKeyColumn( "EmiR_Z_RFU Unique Key", "RFU_RFURSN" );
		  tableForSubObjRetQry.addUniqueKeyColumn( "EmiR_Z_RFU Unique Key", "RFU_RFURSN" );
	


// begin key generation

	
/*
			<foreach>[[RelationshipExtendedProperties]]
				vsQueryDefinition.addRelationshipProperty("[[ParentTableForVar]]_[[ParentRoleNameInMethod]]_[[ChildTableForVar]]", "[[ExtendedPropertyName]]", "[[ExtendedPropertyValue]]");
				<endforeach>
			<endforeach>
*/

// end  support for key generation
		
		addUniqueConstraintsToMetaTable(t); 
		
		

		
		
			 t.useQuotedIdentifier(false);		
		tableForSubObjRetQry.useQuotedIdentifier(false);		
		t.setOptLock( DataConst.OptLockingOnApplicable );
		tableForSubObjRetQry.setOptLock( DataConst.OptLockingOnApplicable );
		
		
		
		
		//END_META_QUERY_COLUMN_CTOR}}
	
		vsQueryDefinition.addTable( t );		
		vsQueryDefinition.populateQCArray();
		
		VSQueryDefinition qTemp = null;
		
		if(!"VLSJSFWebConsole".equals("EmiR"))
			qTemp = (VSQueryDefinition)getMetaQuery( "EmiR_Z_RFU","EmiR" );			
							
		if ( qTemp == null ) {			
			vsQueryDefinition.setPartialSQLForDataModel("SELECT EmiR_Z_RFU.RFU_RFURSN AS RFU_RFURSN, EmiR_Z_RFU.RFU_ARTAL_FROM AS RFU_ARTAL_FROM, EmiR_Z_RFU.RFU_PERIOD_FROM AS RFU_PERIOD_FROM, EmiR_Z_RFU.RFU_KT2_FROM AS RFU_KT2_FROM, EmiR_Z_RFU.RFU_KT2_TOM AS RFU_KT2_TOM, EmiR_Z_RFU.RFU_NIVA_FROM AS RFU_NIVA_FROM, EmiR_Z_RFU.RFU_SUMMERA_UNIVA AS RFU_SUMMERA_UNIVA, EmiR_Z_RFU.RFU_RAPPID AS RFU_RAPPID, EmiR_Z_RFU.RFU_UTDATA AS RFU_UTDATA, EmiR_Z_RFU.RFU_RGHRSN AS RFU_RGHRSN, EmiR_Z_RFU.RFU_BOLNR AS RFU_BOLNR, EmiR_Z_RFU.RFU_BESKRIVNING AS RFU_BESKRIVNING, EmiR_Z_RFU.RFU_RAPPORTID AS RFU_RAPPORTID, EmiR_Z_RFU.RFU_DATETIME AS RFU_DATETIME FROM <dbschema>.EmiR_Z_RFU EmiR_Z_RFU", storageOption, inheritanceType, repositoryName, modelName);
			addMetaQuery(vsQueryDefinition, "EmiR");
		}					
		else {
			vsQueryDefinition = qTemp;	// Keep the old query as it has cached object
		}
			
			
			
	  		
	//END_COMPONENT_META_QRY}}

	//{{COMPONENT_RULES
		
	t.setDerivationType("RFU_SUMMERA_UNIVA", VSMetaColumn.derivationDefault);
			tableForSubObjRetQry.setDerivationType("RFU_SUMMERA_UNIVA", VSMetaColumn.derivationDefault);
		  
	  		String dpndsOn = "";
		  
	  
	  	
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  	}
	
	private static VSMetaTable getTableForObjRetQuery(VSMetaTable t) {

		VSMetaTable newMetaTable = new VSMetaTable("EmiR_Z_RFU");
		
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
		return "EmiR";
	}


	
	   
	   //protected void handlers

		protected void EmiR_Z_RFU_afterCommit(Session session) {
			
		}

		protected void EmiR_Z_RFU_afterDelete(DataObject obj) {

		}

		protected void EmiR_Z_RFU_afterInsert(DataObject obj) {

		}

		protected void EmiR_Z_RFU_afterRollback(Session session) {

		}

		protected void EmiR_Z_RFU_afterUpdate(DataObject obj) {

		}

		protected void EmiR_Z_RFU_beforeCommit(Session session, Response resp) {

		}

		protected void EmiR_Z_RFU_beforeDelete(DataObject obj, Response resp) {

		}

		protected void EmiR_Z_RFU_beforeInsert(DataObject obj, Response resp) {

		}

		protected void EmiR_Z_RFU_beforeRollback(Session session) {

		}

		protected void EmiR_Z_RFU_beforeUpdate(DataObject obj, Response resp) {

		}

		protected void EmiR_Z_RFU_beginTrans(Session session) {

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
			    EmiR_Z_RFUImpl implInstance = new EmiR_Z_RFUImpl();
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
	return "EmiR_Z_RFU";
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
* Constructor for the class EmiR_Z_RFUBaseImpl.
* @param session object on which the Business object is created.
* @param makeDefaults boolean if true sets the default values in the data elements
*        as defined in the meta data.
*/
public EmiR_Z_RFUBaseImpl(Session session, boolean makeDefaults) {
	super(session, EmiR_Z_RFUBaseImpl.getMetaQuery(), makeDefaults);
	
	
	 
		addListeners();
		
}
    
    public EmiR_Z_RFUBaseImpl(Session session, VSMetaQuery metaQuery, boolean makeDefaults) {
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
	com.versata.tl.vls.admin.AppObjectImpl appObject = com.versata.tl.vls.admin.AppObjectImpl.getBusinessObject( repositoryName, "EmiR_Z_RFU", ServerEnvironment.getServer().getInternalSession());
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
 		logger.debug("EmiR_Z_RFU cache size: " + cacheSize + " expiration " + expires);
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
		if (!aSession.getMyPrivilegeToObjectName(DataConst.AppObjectPrivilegeImpl_READ, "EmiR_Z_RFU", DataConst.AppObjectTypeCodeImpl_BUSINESS_OBJECT)) {
		throw new ServerException(ErrorMsgCode.VSMSG_SecurityNoReadAccess,  new Object[] {"business", "EmiR_Z_RFU"});
		}
		}
		catch( VSORBException e ) { 
			logger.warn(e);
		}
	}
	
	raiseBeforeQueryEvent( searchReq, aSession );	
	
	XDAConnector xdac = createXDAConnector(aSession);
		
	if (aSession.isTransactionInProgress()) {
		Enumeration e = aSession.getTransactionInfo().getObjects(EmiR_Z_RFUBaseImpl.getSubObjectRetrievalMetaQuery(), xdac, searchReq);

		Vector dObjs = new Vector();
		while(e.hasMoreElements()) {
			EmiR_Z_RFUImpl implObj = (EmiR_Z_RFUImpl) e.nextElement();
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
		ResultSet rs = new VSORBResultSetImpl( EmiR_Z_RFUBaseImpl.getSubObjectRetrievalMetaQuery(), searchReq, null, -1 ,DataConst.NONE_LOB, xdac, con );
		raiseAfterQueryEvent( rs );
		DataRow row;
		while (  ( row =  rs.fetch() ) != null )
		{	
			EmiR_Z_RFUImpl bo = (EmiR_Z_RFUImpl) row.getComponent();
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
		if (!aSession.getMyPrivilegeToObjectName(DataConst.AppObjectPrivilegeImpl_READ, "EmiR_Z_RFU", DataConst.AppObjectTypeCodeImpl_BUSINESS_OBJECT)) {
		throw new ServerException(ErrorMsgCode.VSMSG_SecurityNoReadAccess,  new Object[] {"business", "EmiR_Z_RFU"});
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
		Enumeration e= aSession.getTransactionInfo().getObjects(EmiR_Z_RFUBaseImpl.getMetaQuery(), xdac, searchReq);
		Vector boList = new Vector();
		while ( e.hasMoreElements()) {
			EmiR_Z_RFUImpl bo = (EmiR_Z_RFUImpl) e.nextElement();
			if(bo != null  && (inheritanceType == com.versata.tl.vls.core.InheritanceType.NONE || inheritanceType == com.versata.tl.vls.core.InheritanceType.REPL) || typeIndicatorValue.equals(bo.get_VSTypeIndicatorAttrColumnData())) {
				boList.addElement( bo );
			}
		}

		// update the global cache if we have one
		if (cacheSize!=0)
		{
			CacheAgent.getCacheAgent().setObjects( EmiR_Z_RFUBaseImpl.getMetaQuery(), boList, expires );
		}
		return boList.elements();		
	} else {
		Vector boList = new Vector();
		Connection con = aSession.getConnection( xdac, true );
		ResultSet rs = new VSORBResultSetImpl( EmiR_Z_RFUBaseImpl.getMetaQuery(), searchReq, null, -1 ,DataConst.NONE_LOB, xdac, con );
		raiseAfterQueryEvent( rs );
		DataRow row;
		while (  ( row =  rs.fetch() ) != null )
		{	
			EmiR_Z_RFUImpl bo = (EmiR_Z_RFUImpl)row.getComponent();
			if(bo != null && (inheritanceType == com.versata.tl.vls.core.InheritanceType.NONE || inheritanceType == com.versata.tl.vls.core.InheritanceType.REPL) || typeIndicatorValue.equals(bo.get_VSTypeIndicatorAttrColumnData())) {
				boList.addElement( bo );
			}

		}
		rs.close();
		
		// if we have a cache, add the retrieved objects to it
		if ( cacheSize != 0 )
			CacheAgent.getCacheAgent().setObjects( EmiR_Z_RFUBaseImpl.getMetaQuery(), boList, expires );
			
		return boList.elements();
	}	
}

public static void raiseBeforeQueryEvent( SearchRequest searchReq, Session aSession )	{
        VSTraceHelper tr = VSTrace.IS_ON ? new VSTraceHelper(logger, "EmiR_Z_RFU.BeforeQuery") : null;
        try {
            beforeQuery( "EmiR_Z_RFU", searchReq, null , aSession );
        }
	finally {
	    if (  tr != null ) tr.end();
        }
}

public static void raiseAfterQueryEvent( ResultSet rs)	{
        VSTraceHelper tr = VSTrace.IS_ON ? new VSTraceHelper(logger, "EmiR_Z_RFU.AfterQuery") : null;
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
		EmiR_Z_RFUImpl implObj = (EmiR_Z_RFUImpl) getObjectByKeyUsingSubObjQueryInternal(key, aSession);
		if(implObj == null) {
			return null;
		}
		String tiAttrColData = implObj.get_VSTypeIndicatorAttrColumnData();
		if(typeIndicatorValue.equals(tiAttrColData) || implObj.get_VSTypeIndicatorValue().equals(tiAttrColData)) {
			return implObj;
		}
		return getActualObjectByKeyWithoutQueryExec(repositoryName, implObj, tiAttrColData);
	} else {
		EmiR_Z_RFUImpl implObj = (EmiR_Z_RFUImpl) getObjectByKeyInternal(key, aSession, cacheOnly);
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
		if (!aSession.getMyPrivilegeToObjectName(DataConst.AppObjectPrivilegeImpl_READ, "EmiR_Z_RFU", DataConst.AppObjectTypeCodeImpl_BUSINESS_OBJECT)) {
		    throw new ServerException(ErrorMsgCode.VSMSG_SecurityNoReadAccess,  new Object[] {"business", "EmiR_Z_RFU"});
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
		anObject = CacheAgent.getCacheAgent().getObject( EmiR_Z_RFUBaseImpl.getMetaQuery(),key.parameterList, aSession);
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
		anObject = aSession.getTransactionInfo().getObjectByKey(EmiR_Z_RFUBaseImpl.getMetaQuery(),key);
	} else {		
		anObject = aSession.getObjectByKey(EmiR_Z_RFUBaseImpl.getMetaQuery(),key);
	}
	
	// if we have a cache and got here, we had a cache miss so add this object to the global cache
	if ( cacheSize != 0 )
		 CacheAgent.getCacheAgent().addObject( EmiR_Z_RFUBaseImpl.getMetaQuery(),anObject, expires );
		 
	return anObject;
}
protected static DataObject getObjectByKeyUsingSubObjQueryInternal( SearchRequest key, Session aSession )
	throws ServerException
{
	if (logger.isDebugEnabled()) logger.debug("getObjectByKeyUsingSubObjQueryInternal " + key + " " + aSession);
	if ( aSession.getSecurityCheck() ) {
		try {
		if (!aSession.getMyPrivilegeToObjectName(DataConst.AppObjectPrivilegeImpl_READ, "EmiR_Z_RFU", DataConst.AppObjectTypeCodeImpl_BUSINESS_OBJECT)) {
		    throw new ServerException(ErrorMsgCode.VSMSG_SecurityNoReadAccess,  new Object[] {"business", "EmiR_Z_RFU"});
		}
		}
		catch( VSORBException e ) { 
			logger.warn(e);
		}
	}

	raiseBeforeQueryEvent( key, aSession );	
	
	DataObject anObject = null;	

	if (aSession.isTransactionInProgress()) {
		anObject = aSession.getTransactionInfo().getObjectByKey(EmiR_Z_RFUBaseImpl.getSubObjectRetrievalMetaQuery(),key);
	} else {		
		anObject = aSession.getObjectByKey(EmiR_Z_RFUBaseImpl.getSubObjectRetrievalMetaQuery(),key);
	}
		
	return anObject;
}

 

	  

	  

public void tableConditionActions() {
	// Generate code for conditional action events.
		//calling action SkapaRapport
		  tableConditionAction_SkapaRapport();
	
	
}
	
	
	
	
		/**
		 * <br>
		 * Condition rule method
		 * @ConditionName SkapaRapport
		 * @description  
		 * @return
		 */
		public void tableConditionAction_SkapaRapport()
		{
				
			VSTraceHelper tr = VSTrace.IS_ON ? new VSTraceHelper(logger, "VST_RULE_CONDITIONACTION",this.getClass().getName() + "_SkapaRapport") : null;  
			try {
				// Condition rule processing for SkapaRapport
        boolean condition = isCurrentEvent("skapaRapport") ==  true  && (  ( isUpdated() == true )  ) ;
        if (logger.isDebugEnabled()) logger.debug("Evaluating condition SkapaRapport");
        if ( condition )
				{
					if (tr != null) {
						tr.set("VST_RULE_FIRE.CONDITIONACTION_" + this.getClass().getName() + ".SkapaRapport", "true");
	
					}
					if (isServerEventTracingEnabled()) addServerEvent("VST_RULE_FIRE.CONDITIONACTION_" + this.getClass().getName() + ".SkapaRapport" + " : " + condition, this.toString(), Session.RULE_EVENT);
					logBamEcaRule("BAM.EmiR.EmiR_Z_RFU.RuleExecutionEvent.SkapaRapport", "SkapaRapport");
					skapaRapport( );
				}
			} catch (Exception e) {
				handleActionException(e, "_SkapaRapport");				
			} finally {
				if ( tr != null ) tr.end();
			}
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
	 
		
		
		
		
			
}

protected void insert_setAttrDefaults() throws ServerException
{	
		 if ( isNull("RFU_SUMMERA_UNIVA") ) 
						
						setRFU_SUMMERA_UNIVA((boolean)( false ));
			
			
			
		
	


}

protected void insert_setCounterAttrs_replCase() throws ServerException
{

			XDAConnector xdac = getXDAConnector();
					// For the counter field set and get the counter value
				Object counter = null;
				
				//Create a new DataRow for PreInsert 	            
				EmiR_Z_RFUImpl implInstance = new EmiR_Z_RFUImpl();
				DataRow newRow = new DataRow(getMyLocalAttributes(), getPrimaryKeyAttributes(), getRow(), vsQueryDefinition, implInstance);
	
				if ( xdac instanceof XDASQLConnector ) {
					if ( ( counter = ((XDASQLConnector)xdac).getCounter(EmiR_Z_RFUBaseImpl.getMetaQuery().getBaseTable("EmiR_Z_RFU"), 
					   session.getTransactionInfo().getConnection( xdac), newRow,"RFU_RFURSN" ) )!= null )	
					   this.setRFU_RFURSN( ((Long)counter).longValue());
					else {
							Data newData = newRow.getData("RFU_RFURSN");
							if(newData == null || newData.getValue() == null){
								throw new ServerException(ErrorMsgCode.VSMSG_IdentityColumnValueNotSet, "RFU_RFURSN");
							}							
							
							//since this is an auto-increment column, we need to ensure that the modified flag is not set(for DBs not using sequence)
							getData("RFU_RFURSN").setObject(newData.getValue());
							
					}
				}
				else {
					if ( ( counter = xdac.getCounter(EmiR_Z_RFUBaseImpl.getMetaQuery().getBaseTable("EmiR_Z_RFU"), 
					   session.getTransactionInfo().getConnection( xdac), newRow ) )!= null )	
					   this.setRFU_RFURSN( ((Long)counter).longValue());
					else {
							Data newData = newRow.getData("RFU_RFURSN");
							if(newData == null || newData.getValue() == null){
								throw new ServerException(ErrorMsgCode.VSMSG_IdentityColumnValueNotSet, "RFU_RFURSN");
							}
							//since this is an auto-increment column, we need to ensure that the modified flag is not set(for DBs not using sequence)
							getData("RFU_RFURSN").setObject(newData.getValue());
					}
				}
				if(!getRow().preInserted())
					getRow().preInserted(newRow.preInserted());
			
		
		
		
		
		
		
		
		
		
		
		
		
		
			
	
		
}

protected void insert_setCounterAttrs() throws ServerException
{
	 	
	
			XDAConnector xdac = getXDAConnector();
			
				// For the counter field set and get the counter value
				Object counter = null;
				

				if ( xdac instanceof XDASQLConnector ) {
					if ( ( counter = ((XDASQLConnector)xdac).getCounter(EmiR_Z_RFUBaseImpl.getMetaQuery().getBaseTable("EmiR_Z_RFU"), 
					   session.getTransactionInfo().getConnection( xdac), getRow(),"RFU_RFURSN" ) )!= null )	
					   this.setRFU_RFURSN( ((Long)counter).longValue());

				}
				else {
					if ( ( counter = xdac.getCounter(EmiR_Z_RFUBaseImpl.getMetaQuery().getBaseTable("EmiR_Z_RFU"), 
					   session.getTransactionInfo().getConnection( xdac), getRow() ) )!= null )	
					   this.setRFU_RFURSN( ((Long)counter).longValue());
				}
			
		
		
		
		
		
		
		
		
		
		
		
		
		
			
		
}



protected void insert_checkPrimaryKeyChanges() throws ServerException
{
	 

    // If the counter changed the pk, we need to update the cache (BUG14568)
    // Typically this is the case with Oracle and DB2 where the counters are
    // backed with database sequences, as opposed to autonumbers 
    int pkChangeCount = 0;
    if (isChanged("RFU_RFURSN")) {
        pkChangeCount++;
        }       
    if (pkChangeCount > 0) {
        getSession().getTransactionInfo().save(this, "EmiR_Z_RFU");
    }
}

protected void doParentChecks() throws ServerException
{
	

}
protected void insert_setAttrFormulae() throws ServerException
{
	
	
}

protected void doCodeTableChecks() throws ServerException
{
	
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  	
	
}
protected void doComputedAttrNullCheck() throws ServerException
{
	
	
	
	if ( isNull("RFU_SUMMERA_UNIVA") )
			{
				// Raise the exception here.
				raiseException("Attribute 'EmiR_Z_RFU.RFU_SUMMERA_UNIVA' does not allow Null Values.");

			}
		
	
	
}

protected void doChildCascades() throws ServerException
{
	
}

protected void doParentAdjustments() throws ServerException
{
	
	
	

}


protected void update_doNonAlterabilityCheck() throws ServerException
{
	
	// Column Non Alterability check
	if ( getGlobalNestLevel() == 1 && isAltered("RFU_RFURSN") && !isUpdatedAfterInsert() )
				{		
					raiseException("Attribute 'RFU_RFURSN' in Object EmiR_Z_RFU is not Alterable.");
				}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
				
}

protected void update_computeStoredValues() throws ServerException
{
	
	}

	
	
protected void setFormulaValues()
	{	
	
		
	}		  
protected void setFormulaValuesWithoutException()
{
	
	VSTraceHelper tr = null;  
	Data dataVal = null;

	
}

public void tableConstraintCheck()
	{
	
	}
			

public void columnValidationCheck() 
{	
		
}












		  











/**	
* Invalidates the relationship cache. Called by the system on transaction begin.
*/
public void invalidateNonTransactionCaches() 
{
}

	



	/**	  
	* <br>
	* method to get the RFU_ARTAL_FROM attribute for the EmiR_Z_RFU
	* @return long : the  value of the attribute RFU_ARTAL_FROM as long.
	*/
	public long	getRFU_ARTAL_FROM() 
	{
		return getData("RFU_ARTAL_FROM").getlong();
	}
	/**	  
	* <br>
	* method to set the RFU_ARTAL_FROM attribute for the EmiR_Z_RFU
	* @param value long : value of the attribute RFU_ARTAL_FROM as long.
	*/
	public void	setRFU_ARTAL_FROM(long value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("RFU_ARTAL_FROM");
		dataVal.setlong(value);
	}

	/**	  
	* <br>
	* method to get the old RFU_ARTAL_FROM attribute for the EmiR_Z_RFU
	* @return long : the  value of the old attribute RFU_ARTAL_FROM as long.
	*/
	public long	getOldRFU_ARTAL_FROM()
	{
		return getData("RFU_ARTAL_FROM").getPreviouslong();
	}
		/**	  
	* <br>
	* method to get the RFU_PERIOD_FROM attribute for the EmiR_Z_RFU
	* @return long : the  value of the attribute RFU_PERIOD_FROM as long.
	*/
	public long	getRFU_PERIOD_FROM() 
	{
		return getData("RFU_PERIOD_FROM").getlong();
	}
	/**	  
	* <br>
	* method to set the RFU_PERIOD_FROM attribute for the EmiR_Z_RFU
	* @param value long : value of the attribute RFU_PERIOD_FROM as long.
	*/
	public void	setRFU_PERIOD_FROM(long value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("RFU_PERIOD_FROM");
		dataVal.setlong(value);
	}

	/**	  
	* <br>
	* method to get the old RFU_PERIOD_FROM attribute for the EmiR_Z_RFU
	* @return long : the  value of the old attribute RFU_PERIOD_FROM as long.
	*/
	public long	getOldRFU_PERIOD_FROM()
	{
		return getData("RFU_PERIOD_FROM").getPreviouslong();
	}
		/**	  
	* <br>
	* method to get the RFU_KT2_FROM attribute for the EmiR_Z_RFU
	* @return String : the  value of the attribute RFU_KT2_FROM as String.
	*/
	public String	getRFU_KT2_FROM() 
	{
		return getData("RFU_KT2_FROM").getString();
	}
	/**	  
	* <br>
	* method to set the RFU_KT2_FROM attribute for the EmiR_Z_RFU
	* @param value String : value of the attribute RFU_KT2_FROM as String.
	*/
	public void	setRFU_KT2_FROM(String value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("RFU_KT2_FROM");
		dataVal.setString(value);
	}

	/**	  
	* <br>
	* method to get the old RFU_KT2_FROM attribute for the EmiR_Z_RFU
	* @return String : the  value of the old attribute RFU_KT2_FROM as String.
	*/
	public String	getOldRFU_KT2_FROM()
	{
		return getData("RFU_KT2_FROM").getPreviousString();
	}
		/**	  
	* <br>
	* method to get the RFU_KT2_TOM attribute for the EmiR_Z_RFU
	* @return String : the  value of the attribute RFU_KT2_TOM as String.
	*/
	public String	getRFU_KT2_TOM() 
	{
		return getData("RFU_KT2_TOM").getString();
	}
	/**	  
	* <br>
	* method to set the RFU_KT2_TOM attribute for the EmiR_Z_RFU
	* @param value String : value of the attribute RFU_KT2_TOM as String.
	*/
	public void	setRFU_KT2_TOM(String value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("RFU_KT2_TOM");
		dataVal.setString(value);
	}

	/**	  
	* <br>
	* method to get the old RFU_KT2_TOM attribute for the EmiR_Z_RFU
	* @return String : the  value of the old attribute RFU_KT2_TOM as String.
	*/
	public String	getOldRFU_KT2_TOM()
	{
		return getData("RFU_KT2_TOM").getPreviousString();
	}
		/**	  
	* <br>
	* method to get the RFU_NIVA_FROM attribute for the EmiR_Z_RFU
	* @return String : the  value of the attribute RFU_NIVA_FROM as String.
	*/
	public String	getRFU_NIVA_FROM() 
	{
		return getData("RFU_NIVA_FROM").getString();
	}
	/**	  
	* <br>
	* method to set the RFU_NIVA_FROM attribute for the EmiR_Z_RFU
	* @param value String : value of the attribute RFU_NIVA_FROM as String.
	*/
	public void	setRFU_NIVA_FROM(String value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("RFU_NIVA_FROM");
		dataVal.setString(value);
	}

	/**	  
	* <br>
	* method to get the old RFU_NIVA_FROM attribute for the EmiR_Z_RFU
	* @return String : the  value of the old attribute RFU_NIVA_FROM as String.
	*/
	public String	getOldRFU_NIVA_FROM()
	{
		return getData("RFU_NIVA_FROM").getPreviousString();
	}
		/**	  
	* <br>
	* method to get the RFU_RAPPID attribute for the EmiR_Z_RFU
	* @return String : the  value of the attribute RFU_RAPPID as String.
	*/
	public String	getRFU_RAPPID() 
	{
		return getData("RFU_RAPPID").getString();
	}
	/**	  
	* <br>
	* method to set the RFU_RAPPID attribute for the EmiR_Z_RFU
	* @param value String : value of the attribute RFU_RAPPID as String.
	*/
	public void	setRFU_RAPPID(String value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("RFU_RAPPID");
		dataVal.setString(value);
	}

	/**	  
	* <br>
	* method to get the old RFU_RAPPID attribute for the EmiR_Z_RFU
	* @return String : the  value of the old attribute RFU_RAPPID as String.
	*/
	public String	getOldRFU_RAPPID()
	{
		return getData("RFU_RAPPID").getPreviousString();
	}
		/**	  
	* <br>
	* method to get the RFU_UTDATA attribute for the EmiR_Z_RFU
	* @return String : the  value of the attribute RFU_UTDATA as String.
	*/
	public String	getRFU_UTDATA() 
	{
		return getData("RFU_UTDATA").getString();
	}
	/**	  
	* <br>
	* method to set the RFU_UTDATA attribute for the EmiR_Z_RFU
	* @param value String : value of the attribute RFU_UTDATA as String.
	*/
	public void	setRFU_UTDATA(String value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("RFU_UTDATA");
		dataVal.setString(value);
	}

	/**	  
	* <br>
	* method to get the old RFU_UTDATA attribute for the EmiR_Z_RFU
	* @return String : the  value of the old attribute RFU_UTDATA as String.
	*/
	public String	getOldRFU_UTDATA()
	{
		return getData("RFU_UTDATA").getPreviousString();
	}
		/**	  
	* <br>
	* method to get the RFU_RGHRSN attribute for the EmiR_Z_RFU
	* @return long : the  value of the attribute RFU_RGHRSN as long.
	*/
	public long	getRFU_RGHRSN() 
	{
		return getData("RFU_RGHRSN").getlong();
	}
	/**	  
	* <br>
	* method to set the RFU_RGHRSN attribute for the EmiR_Z_RFU
	* @param value long : value of the attribute RFU_RGHRSN as long.
	*/
	public void	setRFU_RGHRSN(long value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("RFU_RGHRSN");
		dataVal.setlong(value);
	}

	/**	  
	* <br>
	* method to get the old RFU_RGHRSN attribute for the EmiR_Z_RFU
	* @return long : the  value of the old attribute RFU_RGHRSN as long.
	*/
	public long	getOldRFU_RGHRSN()
	{
		return getData("RFU_RGHRSN").getPreviouslong();
	}
		/**	  
	* <br>
	* method to get the RFU_BOLNR attribute for the EmiR_Z_RFU
	* @return String : the  value of the attribute RFU_BOLNR as String.
	*/
	public String	getRFU_BOLNR() 
	{
		return getData("RFU_BOLNR").getString();
	}
	/**	  
	* <br>
	* method to set the RFU_BOLNR attribute for the EmiR_Z_RFU
	* @param value String : value of the attribute RFU_BOLNR as String.
	*/
	public void	setRFU_BOLNR(String value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("RFU_BOLNR");
		dataVal.setString(value);
	}

	/**	  
	* <br>
	* method to get the old RFU_BOLNR attribute for the EmiR_Z_RFU
	* @return String : the  value of the old attribute RFU_BOLNR as String.
	*/
	public String	getOldRFU_BOLNR()
	{
		return getData("RFU_BOLNR").getPreviousString();
	}
		/**	  
	* <br>
	* method to get the RFU_BESKRIVNING attribute for the EmiR_Z_RFU
	* @return String : the  value of the attribute RFU_BESKRIVNING as String.
	*/
	public String	getRFU_BESKRIVNING() 
	{
		return getData("RFU_BESKRIVNING").getString();
	}
	/**	  
	* <br>
	* method to set the RFU_BESKRIVNING attribute for the EmiR_Z_RFU
	* @param value String : value of the attribute RFU_BESKRIVNING as String.
	*/
	public void	setRFU_BESKRIVNING(String value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("RFU_BESKRIVNING");
		dataVal.setString(value);
	}

	/**	  
	* <br>
	* method to get the old RFU_BESKRIVNING attribute for the EmiR_Z_RFU
	* @return String : the  value of the old attribute RFU_BESKRIVNING as String.
	*/
	public String	getOldRFU_BESKRIVNING()
	{
		return getData("RFU_BESKRIVNING").getPreviousString();
	}
		/**	  
	* <br>
	* method to get the RFU_RAPPORTID attribute for the EmiR_Z_RFU
	* @return String : the  value of the attribute RFU_RAPPORTID as String.
	*/
	public String	getRFU_RAPPORTID() 
	{
		return getData("RFU_RAPPORTID").getString();
	}
	/**	  
	* <br>
	* method to set the RFU_RAPPORTID attribute for the EmiR_Z_RFU
	* @param value String : value of the attribute RFU_RAPPORTID as String.
	*/
	public void	setRFU_RAPPORTID(String value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("RFU_RAPPORTID");
		dataVal.setString(value);
	}

	/**	  
	* <br>
	* method to get the old RFU_RAPPORTID attribute for the EmiR_Z_RFU
	* @return String : the  value of the old attribute RFU_RAPPORTID as String.
	*/
	public String	getOldRFU_RAPPORTID()
	{
		return getData("RFU_RAPPORTID").getPreviousString();
	}
		/**	  
	* <br>
	* method to get the RFU_DATETIME attribute for the EmiR_Z_RFU
	* @return VSDate : the  value of the attribute RFU_DATETIME as VSDate.
	*/
	public VSDate	getRFU_DATETIME() 
	{
		return getData("RFU_DATETIME").getVSDate();
	}
	/**	  
	* <br>
	* method to set the RFU_DATETIME attribute for the EmiR_Z_RFU
	* @param value VSDate : value of the attribute RFU_DATETIME as VSDate.
	*/
	public void	setRFU_DATETIME(VSDate value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("RFU_DATETIME");
		dataVal.setVSDate(value);
	}

	/**	  
	* <br>
	* method to get the old RFU_DATETIME attribute for the EmiR_Z_RFU
	* @return VSDate : the  value of the old attribute RFU_DATETIME as VSDate.
	*/
	public VSDate	getOldRFU_DATETIME()
	{
		return getData("RFU_DATETIME").getPreviousVSDate();
	}
		/**	  
	* <br>
	* method to get the RFU_SUMMERA_UNIVA attribute for the EmiR_Z_RFU
	* @return boolean : the  value of the attribute RFU_SUMMERA_UNIVA as boolean.
	*/
	public boolean	getRFU_SUMMERA_UNIVA() 
	{
		return getData("RFU_SUMMERA_UNIVA").getboolean();
	}
	/**	  
	* <br>
	* method to set the RFU_SUMMERA_UNIVA attribute for the EmiR_Z_RFU
	* @param value boolean : value of the attribute RFU_SUMMERA_UNIVA as boolean.
	*/
	public void	setRFU_SUMMERA_UNIVA(boolean value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("RFU_SUMMERA_UNIVA");
		dataVal.setboolean(value);
	}

	/**	  
	* <br>
	* method to get the old RFU_SUMMERA_UNIVA attribute for the EmiR_Z_RFU
	* @return boolean : the  value of the old attribute RFU_SUMMERA_UNIVA as boolean.
	*/
	public boolean	getOldRFU_SUMMERA_UNIVA()
	{
		return getData("RFU_SUMMERA_UNIVA").getPreviousboolean();
	}
		/**	  
		* <br>
		* method to get the RFU_RFURSN attribute for the EmiR_Z_RFU
		* Description: 
		* @return long : the  value of the attribute RFU_RFURSN as long.
		*/
		public long	getRFU_RFURSN() 
		{
			return getData("RFU_RFURSN").getlong();
		}

		/**	  
		* <br>
		* method to set the RFU_RFURSN attribute for the EmiR_Z_RFU
		* @param value long : value of the attribute RFU_RFURSN as long.
		*/
		public void	setRFU_RFURSN(long value)
		{
			// The code to do convertion from the primitive data
			// to the one which can be stored goes here.
			Data dataVal = getData("RFU_RFURSN");
			dataVal.setlong(value);
		}

		/**	  
		* <br>
		* method to get the old RFU_RFURSN attribute for the EmiR_Z_RFU
		* @return long : the  value of the old attribute RFU_RFURSN as long.
		*/
		public long	getOldRFU_RFURSN()
		{
			return getData("RFU_RFURSN").getPreviouslong();
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
		count = aSession.getTransactionInfo().getObjectsCount(EmiR_Z_RFUBaseImpl.getMetaQuery(), xdac, searchReq);
	else
	{
		con = aSession.getConnection( xdac, true );
  	  	count = xdac.getRowCount( EmiR_Z_RFUBaseImpl.getMetaQuery(), searchReq, con );
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
		VSMetaTable table = EmiR_Z_RFUBaseImpl.getMetaQuery().getChildMostTable();
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
		VSMetaTable table = EmiR_Z_RFUBaseImpl.getMetaQuery().getChildMostTable();
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
	Properties props = ((VSORBSessionImpl)aSession).getMyDataServiceLoginForObject("EmiR_Z_RFU");
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

	public abstract void skapaRapport();


//END_COMPONENT_RULES}}

	//{{ABSTRACT_CUSTOM_METHODS

	// User defined methods used in a rule are defined in the Impl class, and have corresponding abstract methods in the BaseImpl.



//END_ABSTRACT_CUSTOM_METHODS}}
}
