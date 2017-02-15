 
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

//END_COMPONENT_IMPORT_STMTS}}

/**
* Enforces rules, in conjunction with [designated] Super, Event Handling sub, and methods invoked from rules.
* Instances are instantiated by BRMS runtime by decomposing Query Model updates.
* After rule enforcement, instances remain in transaction cache until end transaction,
*   when they are flushed to disk by their XDA.
*  
*/
 public abstract class Z_YesNoBaseImpl extends DataObject {
    
    public static VersataLogger logger = VersataLogger.getLogger(Z_YesNoImpl.class);
    
    protected Z_YesNoBaseImpl() {
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
	private static String modelName = "Z_YesNo";
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
			logger.debug("Initializing Z_YesNo");
		
		vsQueryDefinition= new VSQueryDefinition( "Z_YesNo" );
		vsQueryDefinition.setPackageName("CurrencyDemo");
		vsQueryDefinition.setRepositoryName(repositoryName);
		vsQueryDefinition.setDataObject(true);	
		
		
		
		
		VSMetaColumn c = null;
		VSMetaTable tableForSubObjRetQry = new VSMetaTable("Z_YesNo");
		
		//{{META_QUERY_COLUMN_CTOR
		
		
		
			c = new VSMetaColumn("Stored", DataConst.VARCHAR);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.PK);
			c.setSize(3);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setCaption("");
			tableForSubObjRetQry.addColumn( c );
			
    	
			c = new VSMetaColumn("Displayed", DataConst.VARCHAR);
			c.setColumnClassification(com.versata.tl.common.meta.VSMetaColumn.LOCAL);
			c.setSize(3);
			c.setAlterability(true);
			c.setNullability(VSMetaColumn.columnNullable);
			c.setCaption("");
			tableForSubObjRetQry.addColumn( c );
			
    			
		VSMetaTable t = getTableForObjRetQuery(tableForSubObjRetQry);
		t.addUniqueKeyColumn( "Z_YesNo Unique Key", "Stored" );
		  tableForSubObjRetQry.addUniqueKeyColumn( "Z_YesNo Unique Key", "Stored" );
	


// begin key generation

	
/*
			<foreach>[[RelationshipExtendedProperties]]
				vsQueryDefinition.addRelationshipProperty("[[ParentTableForVar]]_[[ParentRoleNameInMethod]]_[[ChildTableForVar]]", "[[ExtendedPropertyName]]", "[[ExtendedPropertyValue]]");
				<endforeach>
			<endforeach>
*/

// end  support for key generation
		
		addUniqueConstraintsToMetaTable(t); 
		
		

					t.setStoredColumnName("Stored");
			tableForSubObjRetQry.setStoredColumnName("Stored");
			t.setDisplayColumnName("Displayed");
			tableForSubObjRetQry.setDisplayColumnName("Displayed");
			
		
			 t.useQuotedIdentifier(false);		
		tableForSubObjRetQry.useQuotedIdentifier(false);		
		t.setOptLock( DataConst.OptLockingOnApplicable );
		tableForSubObjRetQry.setOptLock( DataConst.OptLockingOnApplicable );
		
		
		
		
		//END_META_QUERY_COLUMN_CTOR}}
	
		vsQueryDefinition.addTable( t );		
		vsQueryDefinition.populateQCArray();
		
		VSQueryDefinition qTemp = null;
		
		if(!"VLSJSFWebConsole".equals("CurrencyDemo"))
			qTemp = (VSQueryDefinition)getMetaQuery( "Z_YesNo","CurrencyDemo" );			
							
		if ( qTemp == null ) {			
			vsQueryDefinition.setPartialSQLForDataModel("SELECT Z_YesNo.Stored AS Stored, Z_YesNo.Displayed AS Displayed FROM <dbschema>.Z_YesNo Z_YesNo", storageOption, inheritanceType, repositoryName, modelName);
			addMetaQuery(vsQueryDefinition, "CurrencyDemo");
		}					
		else {
			vsQueryDefinition = qTemp;	// Keep the old query as it has cached object
		}
			
			
			
	  		
	//END_COMPONENT_META_QRY}}

	//{{COMPONENT_RULES
		
	
	  		String dpndsOn = "";
		  
	  	
	  
	  	}
	
	private static VSMetaTable getTableForObjRetQuery(VSMetaTable t) {

		VSMetaTable newMetaTable = new VSMetaTable("Z_YesNo");
		
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

		protected void Z_YesNo_afterCommit(Session session) {
			
		}

		protected void Z_YesNo_afterDelete(DataObject obj) {

		}

		protected void Z_YesNo_afterInsert(DataObject obj) {

		}

		protected void Z_YesNo_afterRollback(Session session) {

		}

		protected void Z_YesNo_afterUpdate(DataObject obj) {

		}

		protected void Z_YesNo_beforeCommit(Session session, Response resp) {

		}

		protected void Z_YesNo_beforeDelete(DataObject obj, Response resp) {

		}

		protected void Z_YesNo_beforeInsert(DataObject obj, Response resp) {

		}

		protected void Z_YesNo_beforeRollback(Session session) {

		}

		protected void Z_YesNo_beforeUpdate(DataObject obj, Response resp) {

		}

		protected void Z_YesNo_beginTrans(Session session) {

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
			    Z_YesNoImpl implInstance = new Z_YesNoImpl();
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
	return "Z_YesNo";
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
* Constructor for the class Z_YesNoBaseImpl.
* @param session object on which the Business object is created.
* @param makeDefaults boolean if true sets the default values in the data elements
*        as defined in the meta data.
*/
public Z_YesNoBaseImpl(Session session, boolean makeDefaults) {
	super(session, Z_YesNoBaseImpl.getMetaQuery(), makeDefaults);
	
	
	 
		addListeners();
		
}
    
    public Z_YesNoBaseImpl(Session session, VSMetaQuery metaQuery, boolean makeDefaults) {
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
	com.versata.tl.vls.admin.AppObjectImpl appObject = com.versata.tl.vls.admin.AppObjectImpl.getBusinessObject( repositoryName, "Z_YesNo", ServerEnvironment.getServer().getInternalSession());
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
 		logger.debug("Z_YesNo cache size: " + cacheSize + " expiration " + expires);
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
		if (!aSession.getMyPrivilegeToObjectName(DataConst.AppObjectPrivilegeImpl_READ, "Z_YesNo", DataConst.AppObjectTypeCodeImpl_BUSINESS_OBJECT)) {
		throw new ServerException(ErrorMsgCode.VSMSG_SecurityNoReadAccess,  new Object[] {"business", "Z_YesNo"});
		}
		}
		catch( VSORBException e ) { 
			logger.warn(e);
		}
	}
	
	raiseBeforeQueryEvent( searchReq, aSession );	
	
	XDAConnector xdac = createXDAConnector(aSession);
		
	if (aSession.isTransactionInProgress()) {
		Enumeration e = aSession.getTransactionInfo().getObjects(Z_YesNoBaseImpl.getSubObjectRetrievalMetaQuery(), xdac, searchReq);

		Vector dObjs = new Vector();
		while(e.hasMoreElements()) {
			Z_YesNoImpl implObj = (Z_YesNoImpl) e.nextElement();
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
		ResultSet rs = new VSORBResultSetImpl( Z_YesNoBaseImpl.getSubObjectRetrievalMetaQuery(), searchReq, null, -1 ,DataConst.NONE_LOB, xdac, con );
		raiseAfterQueryEvent( rs );
		DataRow row;
		while (  ( row =  rs.fetch() ) != null )
		{	
			Z_YesNoImpl bo = (Z_YesNoImpl) row.getComponent();
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
		if (!aSession.getMyPrivilegeToObjectName(DataConst.AppObjectPrivilegeImpl_READ, "Z_YesNo", DataConst.AppObjectTypeCodeImpl_BUSINESS_OBJECT)) {
		throw new ServerException(ErrorMsgCode.VSMSG_SecurityNoReadAccess,  new Object[] {"business", "Z_YesNo"});
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
		Enumeration e= aSession.getTransactionInfo().getObjects(Z_YesNoBaseImpl.getMetaQuery(), xdac, searchReq);
		Vector boList = new Vector();
		while ( e.hasMoreElements()) {
			Z_YesNoImpl bo = (Z_YesNoImpl) e.nextElement();
			if(bo != null  && (inheritanceType == com.versata.tl.vls.core.InheritanceType.NONE || inheritanceType == com.versata.tl.vls.core.InheritanceType.REPL) || typeIndicatorValue.equals(bo.get_VSTypeIndicatorAttrColumnData())) {
				boList.addElement( bo );
			}
		}

		// update the global cache if we have one
		if (cacheSize!=0)
		{
			CacheAgent.getCacheAgent().setObjects( Z_YesNoBaseImpl.getMetaQuery(), boList, expires );
		}
		return boList.elements();		
	} else {
		Vector boList = new Vector();
		Connection con = aSession.getConnection( xdac, true );
		ResultSet rs = new VSORBResultSetImpl( Z_YesNoBaseImpl.getMetaQuery(), searchReq, null, -1 ,DataConst.NONE_LOB, xdac, con );
		raiseAfterQueryEvent( rs );
		DataRow row;
		while (  ( row =  rs.fetch() ) != null )
		{	
			Z_YesNoImpl bo = (Z_YesNoImpl)row.getComponent();
			if(bo != null && (inheritanceType == com.versata.tl.vls.core.InheritanceType.NONE || inheritanceType == com.versata.tl.vls.core.InheritanceType.REPL) || typeIndicatorValue.equals(bo.get_VSTypeIndicatorAttrColumnData())) {
				boList.addElement( bo );
			}

		}
		rs.close();
		
		// if we have a cache, add the retrieved objects to it
		if ( cacheSize != 0 )
			CacheAgent.getCacheAgent().setObjects( Z_YesNoBaseImpl.getMetaQuery(), boList, expires );
			
		return boList.elements();
	}	
}

public static void raiseBeforeQueryEvent( SearchRequest searchReq, Session aSession )	{
        VSTraceHelper tr = VSTrace.IS_ON ? new VSTraceHelper(logger, "Z_YesNo.BeforeQuery") : null;
        try {
            beforeQuery( "Z_YesNo", searchReq, null , aSession );
        }
	finally {
	    if (  tr != null ) tr.end();
        }
}

public static void raiseAfterQueryEvent( ResultSet rs)	{
        VSTraceHelper tr = VSTrace.IS_ON ? new VSTraceHelper(logger, "Z_YesNo.AfterQuery") : null;
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
		Z_YesNoImpl implObj = (Z_YesNoImpl) getObjectByKeyUsingSubObjQueryInternal(key, aSession);
		if(implObj == null) {
			return null;
		}
		String tiAttrColData = implObj.get_VSTypeIndicatorAttrColumnData();
		if(typeIndicatorValue.equals(tiAttrColData) || implObj.get_VSTypeIndicatorValue().equals(tiAttrColData)) {
			return implObj;
		}
		return getActualObjectByKeyWithoutQueryExec(repositoryName, implObj, tiAttrColData);
	} else {
		Z_YesNoImpl implObj = (Z_YesNoImpl) getObjectByKeyInternal(key, aSession, cacheOnly);
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
		if (!aSession.getMyPrivilegeToObjectName(DataConst.AppObjectPrivilegeImpl_READ, "Z_YesNo", DataConst.AppObjectTypeCodeImpl_BUSINESS_OBJECT)) {
		    throw new ServerException(ErrorMsgCode.VSMSG_SecurityNoReadAccess,  new Object[] {"business", "Z_YesNo"});
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
		anObject = CacheAgent.getCacheAgent().getObject( Z_YesNoBaseImpl.getMetaQuery(),key.parameterList, aSession);
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
		anObject = aSession.getTransactionInfo().getObjectByKey(Z_YesNoBaseImpl.getMetaQuery(),key);
	} else {		
		anObject = aSession.getObjectByKey(Z_YesNoBaseImpl.getMetaQuery(),key);
	}
	
	// if we have a cache and got here, we had a cache miss so add this object to the global cache
	if ( cacheSize != 0 )
		 CacheAgent.getCacheAgent().addObject( Z_YesNoBaseImpl.getMetaQuery(),anObject, expires );
		 
	return anObject;
}
protected static DataObject getObjectByKeyUsingSubObjQueryInternal( SearchRequest key, Session aSession )
	throws ServerException
{
	if (logger.isDebugEnabled()) logger.debug("getObjectByKeyUsingSubObjQueryInternal " + key + " " + aSession);
	if ( aSession.getSecurityCheck() ) {
		try {
		if (!aSession.getMyPrivilegeToObjectName(DataConst.AppObjectPrivilegeImpl_READ, "Z_YesNo", DataConst.AppObjectTypeCodeImpl_BUSINESS_OBJECT)) {
		    throw new ServerException(ErrorMsgCode.VSMSG_SecurityNoReadAccess,  new Object[] {"business", "Z_YesNo"});
		}
		}
		catch( VSORBException e ) { 
			logger.warn(e);
		}
	}

	raiseBeforeQueryEvent( key, aSession );	
	
	DataObject anObject = null;	

	if (aSession.isTransactionInProgress()) {
		anObject = aSession.getTransactionInfo().getObjectByKey(Z_YesNoBaseImpl.getSubObjectRetrievalMetaQuery(),key);
	} else {		
		anObject = aSession.getObjectByKey(Z_YesNoBaseImpl.getSubObjectRetrievalMetaQuery(),key);
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
    if (isChanged("Stored")) {
        pkChangeCount++;
        }       
    if (pkChangeCount > 0) {
        getSession().getTransactionInfo().save(this, "Z_YesNo");
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
	* method to get the Stored attribute for the Z_YesNo
	* @return String : the  value of the attribute Stored as String.
	*/
	public String	getStored() 
	{
		return getData("Stored").getString();
	}
	/**	  
	* <br>
	* method to set the Stored attribute for the Z_YesNo
	* @param value String : value of the attribute Stored as String.
	*/
	public void	setStored(String value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("Stored");
		dataVal.setString(value);
	}

	/**	  
	* <br>
	* method to get the old Stored attribute for the Z_YesNo
	* @return String : the  value of the old attribute Stored as String.
	*/
	public String	getOldStored()
	{
		return getData("Stored").getPreviousString();
	}
		/**	  
	* <br>
	* method to get the Displayed attribute for the Z_YesNo
	* @return String : the  value of the attribute Displayed as String.
	*/
	public String	getDisplayed() 
	{
		return getData("Displayed").getString();
	}
	/**	  
	* <br>
	* method to set the Displayed attribute for the Z_YesNo
	* @param value String : value of the attribute Displayed as String.
	*/
	public void	setDisplayed(String value)
	{
		// The code to do convertion from the primitive data
		// to the one which can be stored goes here.
		Data dataVal = getData("Displayed");
		dataVal.setString(value);
	}

	/**	  
	* <br>
	* method to get the old Displayed attribute for the Z_YesNo
	* @return String : the  value of the old attribute Displayed as String.
	*/
	public String	getOldDisplayed()
	{
		return getData("Displayed").getPreviousString();
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
		count = aSession.getTransactionInfo().getObjectsCount(Z_YesNoBaseImpl.getMetaQuery(), xdac, searchReq);
	else
	{
		con = aSession.getConnection( xdac, true );
  	  	count = xdac.getRowCount( Z_YesNoBaseImpl.getMetaQuery(), searchReq, con );
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
		VSMetaTable table = Z_YesNoBaseImpl.getMetaQuery().getChildMostTable();
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
		VSMetaTable table = Z_YesNoBaseImpl.getMetaQuery().getChildMostTable();
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
	Properties props = ((VSORBSessionImpl)aSession).getMyDataServiceLoginForObject("Z_YesNo");
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


//END_COMPONENT_RULES}}

	//{{ABSTRACT_CUSTOM_METHODS

	// User defined methods used in a rule are defined in the Impl class, and have corresponding abstract methods in the BaseImpl.



//END_ABSTRACT_CUSTOM_METHODS}}
}
