

/*
 * Copyright (c) Versata, Inc., 2000-2005. All Rights Reserved.
 *
 * THIS CODE IS AUTO-GENERATED FROM YOUR MODEL.
 * PLEASE DO NOT EDIT IT, BECAUSE ANY CHANGES YOU MAKE WILL BE OVERWRITTEN.
 *
 * Generated Fri Feb 10 12:05:57 CET 2017 by $Header: //depot/main/products/brms/eclipse/plugins/com.versata.tl.service/templates/ServiceImpl.javajet#2 $
 */

package CurrencyDemo.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Enumeration;

import com.versata.tl.common.exception.ServerSecurityException;
import com.versata.tl.common.vlsobject.VSORBException;
import com.versata.tl.api.logging.VersataLogger;
import com.versata.tl.vls.core.Session;

import com.versata.tl.common.meta.VSMetaQuery;
import com.versata.tl.vls.service.GenericComponentFactory;
import com.versata.tl.vls.core.DataRow;

import com.versata.tl.metadata.MetaData;
import com.versata.tl.common.util.VSDate;
import com.versata.tl.dataaccess.common.Filter;
import com.versata.tl.dataaccess.common.MetaDataManager;
import com.versata.tl.dataaccess.common.SearchRequest;
import com.versata.tl.dataaccess.common.VersataChangeSummary;
import com.versata.tl.dataaccess.common.WhereClause;
import com.versata.tl.dataaccess.common.impl.FilterImpl;
import com.versata.tl.dataaccess.common.impl.SearchRequestFactory;
import com.versata.tl.dataaccess.common.impl.WhereClauseFactory;

import com.versata.tl.vls.service.ServiceDelegateProxy;
import com.versata.tl.vls.service.ServiceException;
import com.versata.tl.vls.service.ServiceImplBase;

import CurrencyDemo.service.dms.Common_COP_QDMSHandlerImpl;
import CurrencyDemo.service.dms.Common_COP_QMarshaller;
import CurrencyDemo.impl.Common_COP_QImpl;
import CurrencyDemo.Common_COP_Q;	
import CurrencyDemo.service.dto.Common_COP_QDTO;

import CurrencyDemo.RootObject;

import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;

import org.eclipse.emf.ecore.sdo.EDataGraph;
import org.eclipse.emf.ecore.sdo.SDOFactory;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;





	/**
	 * The service implementation class for the Common_COP_Q query object.<p>
	 *
	 * This class provides many helper methods used to manipulate Common_COP_Q
	 * objects. It is used by the generated stateless service bean (and hence any 
	 * generated web service).Custom services are encouraged to use this class.<p>
	 *
	 * The ServiceImpl classes support the notion of a user-defined delegate class, which 
	 * either formally implements the entire Common_COP_QServiceDelegate interface 
	 * or a subset of that interface. At runtime, this class will check for a delegate, 
	 * and invoke the delegate beforeXXX and afterXXX methods. @see Common_COP_QServiceDelegate 
	 *	 	
	*/

	 public class Common_COP_QServiceImpl extends ServiceImplBase {

		 private static final VersataLogger LOGGER = VersataLogger.getLogger(
				Common_COP_QServiceImpl.class);

		private Object delegate;
		private ServiceDelegateProxy delegateProxy;	
			

		
		public Common_COP_QServiceImpl(Object delegate) {
			setDelegate(delegate);
		}

		public Common_COP_QServiceImpl() {
			this(null);
		}
		
		
		
		public void setDelegate(Object delegate) {
			this.delegate = delegate;
			delegateProxy = new ServiceDelegateProxy(delegate, Common_COP_QServiceDelegate.class);
		}
		
		public Object getDelegate() {
			return delegate;
			
		}		
		/**
		 * Retrieves an SDO graph which may be updated
		 * 
		 * @param session		 
		 * @return dataGraph
		 *
		 */

		public DataGraph getDataGraph(Session session) {
			Common_COP_QDMSHandlerImpl  handler = new Common_COP_QDMSHandlerImpl("CurrencyDemo", session);
			
			return handler.getDataGraph();
		}
		
		
		/**
		 * Return a datagraph given the primary key of the childmost dataobject
		 * 
		 * @param 		 
		 * @return 
		 *
		 */		 
		public DataGraph getCommon_COP_QDataGraphByPK1_COP_Id(Long COP_Id, Session session) throws ServerSecurityException, VSORBException {
			
			String [] beforeArgsType = {this.getClass().getName(), "java.lang.Long", "com.versata.tl.vls.core.Session"};
			Object[] beforeArgs = { this, COP_Id, session };
		 	if (LOGGER.isDebugEnabled()) LOGGER.debug("getCommon_COP_QDataGraphByPK1_COP_Id");
		 	
		  boolean keepGoing = delegateProxy.dispatch("beforeGetCommon_COP_QDataGraphByPK1_COP_Id", beforeArgs, beforeArgsType);
		  if (!keepGoing) {
		  	if (LOGGER.isDebugEnabled()) LOGGER.debug("delegate cancellation");
		    return null;
		  }		    		
		    
		  Common_COP_QDMSHandlerImpl  handler = new Common_COP_QDMSHandlerImpl("CurrencyDemo", session);
			
			String[] columnNames = { "COP_Id" };
			Object[] columnValues = { COP_Id };

		  DataGraph retVal = handler.getCommon_COP_Q(columnNames, columnValues);
		  String[] afterArgsType = {this.getClass().getName(), "commonj.sdo.DataGraph", "com.versata.tl.vls.core.Session"};
		  Object[] afterArgs = { this, retVal, session };
		  delegateProxy.dispatch("afterGetCommon_COP_QDataGraphByPK1_COP_Id", afterArgs, afterArgsType);
		  return retVal;
	    }
					
			
			/**
			 * Retrieves an SDO graph via an advanced query
			 * 
			 * @param filter An arbitrary	SearchRequest corresponding to the WHERE clause
			 * @param sorter A SearchRequest corresponding to the ORDER BY clause. May be null.
			 * @param rowLimit The maximum number of rows to return in the datagraph. If this 
			 * value is null then all rows will be returned.
			 * @return 
			 *
			 */
			 
			public DataGraph getCommon_COP_QDataGraphAdvanced(Filter filter, List orderByAttributes, int rowLimit, Session session) throws ServerSecurityException, VSORBException {
			 	if (LOGGER.isDebugEnabled()) LOGGER.debug("getCommon_COP_QDataGraphAdvanced");
			 	String[] beforeArgsType = { this.getClass().getName(), "com.versata.tl.common.util.SearchRequest", "com.versata.tl.common.util.SearchRequest", "java.lang.Integer", "com.versata.tl.vls.core.Session" };
			 	Object[] beforeArgs = { this, filter, orderByAttributes, Integer.valueOf(rowLimit), session };
			   boolean keepGoing = delegateProxy.dispatch("beforeGetCommon_COP_QDataGraphAdvanced", beforeArgs, beforeArgsType);
			   if (!keepGoing) {
					if (LOGGER.isDebugEnabled()) LOGGER.debug("delegate cancellation");
					return null;
			  }		    		
			    
			  Common_COP_QDMSHandlerImpl  handler = new Common_COP_QDMSHandlerImpl("CurrencyDemo", session);
				
			  RootObject rootObject = CurrencyDemo.CurrencyDemoFactory.eINSTANCE.createRootObject();
			  Property property = getPropertyFromRootObject(rootObject, "common_COP_Q");

			  SearchRequestFactory searchRequestFactory = new SearchRequestFactory();
			  SearchRequest searchRequest = searchRequestFactory.createSearchRequest("Common_COP_Q", filter, rowLimit, property, orderByAttributes, null, null, null, null, SearchRequest.FIRST);
			  
			  // Assumption : if a orderby clause is sent as a string, it should be the first element in orderByAttributes list
			  if(orderByAttributes != null){
				  Object firstObject = orderByAttributes.get(0);
				  if(firstObject != null && firstObject.getClass().equals(String.class)){
					  searchRequest.setOrderByClause((String)firstObject);
				  }
			  }
			  
			  DataGraph retVal = handler.getCommon_COP_Q(searchRequest);
			    
			  Object[] afterArgs = { this, retVal, session };
			  String[] afterArgsType = { this.getClass().getName(), "commonj.sdo.DataGraph", "com.versata.tl.vls.core.Session" };
			  delegateProxy.dispatch("afterGetCommon_COP_QDataGraphAdvanced", afterArgs, afterArgsType);
			  return retVal;
		    }
	
		
			/**
			 * Retrieves an SDO graph via arbitrary SQL
			 * 
			 * @param whereClause  An arbitrary	 WHERE clause, e.g. "attr1 like 'v%' or 
			 * attrName2 = 'foo' order by attr3 DESC". If this value is null or empty, 
			 * all rows will be returned
			 * @param rowLimit The maximum number of rows to return in the datagraph. If this 
			 * value is null then all rows will be returned.
			 * @return SDO DataGraph
			 *
			 */
			 
			public DataGraph getCommon_COP_QDataGraphViaSQL(String whereClause, int rowLimit, Session session) throws ServerSecurityException, VSORBException {
			 	if (LOGGER.isDebugEnabled()) LOGGER.debug("getCommon_COP_QDataGraphViaSQL");
			 	String[] beforeArgsType = { this.getClass().getName(), "com.versata.tl.common.util.SearchRequest", "java.lang.Integer", "com.versata.tl.vls.core.Session"};
			 	Object[] beforeArgs = { this, whereClause, Integer.valueOf(rowLimit), session };

			  	boolean keepGoing = delegateProxy.dispatch("beforeGetCommon_COP_QDataGraphViaSQL", beforeArgs, beforeArgsType);
			  	if (!keepGoing) {
			  		if (LOGGER.isDebugEnabled()) LOGGER.debug("delegate cancellation");
					return null;
				}

				WhereClauseFactory whereClauseFactory = new WhereClauseFactory();
				WhereClause wc = whereClauseFactory.createStringWhereClause(whereClause, "Common_COP_Q");
		  		
				Filter filter = new FilterImpl(wc);
				
				DataGraph retVal = this.getCommon_COP_QDataGraphAdvanced(filter, null, rowLimit, session);
			    
		   		String[] afterArgsType = { this.getClass().getName(), "commonj.sdo.DataGraph", "com.versata.tl.vls.core.Session" };
			    Object[] afterArgs = { this, retVal, session };
				delegateProxy.dispatch("afterGetCommon_COP_QDataGraphViaSQL", afterArgs, afterArgsType);
				return retVal;
		    }

			 
			 
			/**
			 * Retrieve simple DTO objects via an arbitrary sql 'where' clause
			 * 
			 * @param whereClause  An arbitrary	 WHERE clause, e.g. "attr1 like 'v%' or 
			 * attrName2 = 'foo' order by attr3 DESC". If this value is null or empty, 
			 * all rows will be returned
			 * @param rowLimit The maximum number of rows to return. If this 
			 * value is null then all rows will be returned.
			 * @return an array of simple DTOs
			 
			 */
			 
			public Common_COP_QDTO[] getCommon_COP_QArrayViaSQL(String whereClause, Integer rowLimit, Session session) throws ServerSecurityException {
			 	if (LOGGER.isDebugEnabled()) LOGGER.debug("getCommon_COP_QArrayViaSQL");
			 	String[] beforeArgsType = { this.getClass().getName(), "com.versata.tl.common.util.SearchRequest", "java.lang.Integer", "com.versata.tl.vls.core.Session"};			
				Object[] beforeArgs = { this, whereClause, rowLimit, session };
				
				boolean keepGoing = delegateProxy.dispatch("beforeGetCommon_COP_QArrayViaSQL", beforeArgs, beforeArgsType);
			    if (!keepGoing) {
			    	LOGGER.debug("delegate cancellation");
		    		return null;
				}		    		

			    DataGraph dg = this.getCommon_COP_QDataGraphViaSQL(whereClause, rowLimit.intValue(), session);
			    
				// convert the SDO graph to a DTO array
				List list = dg.getRootObject().getList("common_COP_Q");
		  		Common_COP_QMarshaller marshaller = new Common_COP_QMarshaller();
				Common_COP_QDTO[] retVal = new Common_COP_QDTO[list.size()];
				
				for (int i=0; i<list.size(); i++) {
					Common_COP_QImpl sdo = (Common_COP_QImpl)list.get(i);
					Common_COP_QDTO dto = new Common_COP_QDTO();
					//TODO: commenting the dto marshaller for now.
					//marshaller.marshal(sdo, dto);
					retVal[i] = dto;
				}
				
				String[] afterArgsType = { this.getClass().getName(), "commonj.sdo.DataGraph", "com.versata.tl.vls.core.Session" };
			    Object[] afterArgs = { this, retVal, session };
				delegateProxy.dispatch("afterGetCommon_COP_QArrayViaSQL", afterArgs, afterArgsType);
				return retVal;			
			}
		    
					
			 		
		 
		/**
		 * Retrieves an SDO transfer object given the primary key
		 * 
		 * @param pK1_COP_Id the primary key
		 * @return A single SDO Data Transfer Object 
		 * 
		 */
		 
		public Common_COP_Q getCommon_COP_QDataObjectByPK1_COP_Id(Long COP_Id, Session session) throws ServerSecurityException, VSORBException {
			if (LOGGER.isDebugEnabled()) LOGGER.debug("getCommon_COP_QDataObjectByPK1_COP_Id");
			String[] beforeArgsType = { this.getClass().getName(), "java.lang.Long", "com.versata.tl.vls.core.Session" };				
			Object[] beforeArgs = { this, COP_Id, session };

			boolean keepGoing = delegateProxy.dispatch("beforeGetCommon_COP_QDataObjectByPK1_COP_Id", beforeArgs, beforeArgsType);
			if (!keepGoing) {
		  		if (LOGGER.isDebugEnabled()) LOGGER.debug("delegate cancellation");
		  		return null;
		  	}		    		
		
			Common_COP_QImpl retVal = null;
			DataGraph dataGraph = this.getCommon_COP_QDataGraphByPK1_COP_Id(COP_Id, session);						
		  	List list = dataGraph.getRootObject().getList("common_COP_Q");
		  	
			if (list.size() == 0) {
		  		LOGGER.debug("No rows returned");		  	
		  	}
		  	else {
				retVal = (Common_COP_QImpl)list.get(0);
		  		if (list.size() > 1) {
		  			LOGGER.debug("Expected 1 row but found " + list.size());
		  		}
		  	}
		  	String[] afterArgsType = { "java.lang.Object", "commonj.sdo.DataGraph", "com.versata.tl.vls.core.Session" };
			Object[] afterArgs = { this, retVal, session };
			delegateProxy.dispatch("afterGetCommon_COP_QDataObjectByPK1_COP_Id", afterArgs, afterArgsType);
			return retVal;
		}

		 
  /**
  * Retrieve a simple Data Transfer Object via the primary key
  * 
  * 
  * @return A single javabean ('POJO') Data Transfer Object 
  * 
  */		 
  public Common_COP_QDTO getCommon_COP_QDTOByPK1_COP_Id(Long COP_Id, Session session) throws ServerSecurityException, VSORBException {
		 if (LOGGER.isDebugEnabled()) LOGGER.debug("getCommon_COP_QDTOByPK1_COP_Id");	
		  Common_COP_QDTO retVal = null;
	            String[] beforeArgsType = { this.getClass().getName(), "java.lang.Long", "com.versata.tl.vls.core.Session" };
		 		Object[] beforeArgs = { this, COP_Id, session };
		  		
		  		boolean keepGoing = delegateProxy.dispatch("beforeGetCommon_COP_QDTOByPK1_COP_Id", beforeArgs, beforeArgsType);
		  		if (!keepGoing) {
		  			if (LOGGER.isDebugEnabled()) LOGGER.debug("delegate cancellation");
		  			return null;
		  		}		    		
		
		  		DataGraph dataGraph = this.getCommon_COP_QDataGraphByPK1_COP_Id(COP_Id, session);			
		  		List list = dataGraph.getRootObject().getList("common_COP_Q");
		  

		  
  		  		if (list.size() == 0) {
		  			LOGGER.debug("No rows returned");		  	
		  		}
		  		else {
					Common_COP_QImpl sdo = (Common_COP_QImpl)list.get(0);
		  			retVal = new Common_COP_QDTO();
		  			Common_COP_QMarshaller marshaller = new Common_COP_QMarshaller();
		  			marshaller.marshal(sdo, retVal);
		  		
		  			if (list.size() > 1) {
		  				LOGGER.debug("Expected 1 row but found " + list.size());
		  			}
		  		}	  		
		  
		  
				String[] afterArgsType = { this.getClass().getName(), "commonj.sdo.DataGraph", "com.versata.tl.vls.core.Session" };
		  		Object[] afterArgs = { this, retVal, session };
		  		delegateProxy.dispatch("afterGetCommon_COP_QDTOByPK1_COP_Id", afterArgs,afterArgsType);


	  		return retVal;		    
		    
		}

				
	
			 
		/**
		 * CRUD operations (including Create, Update and Delete) 
in the DataGraph are pushed down to the underlying Data Objects
		 * 
		 * @param 		 
		 * @return 
		 *
		 */		 
		public DataGraph crudCommon_COP_QFromDataGraph(DataGraph common_COP_QGraph, Session session) throws ServerSecurityException, VSORBException {
			if (LOGGER.isDebugEnabled()) LOGGER.debug("crudCommon_COP_QFromDataGraph");		   
		   String[] beforeArgsType = { this.getClass().getName(), "commonj.sdo.DataGraph", "com.versata.tl.vls.core.Session" };
		    Object[] beforeArgs = { this, common_COP_QGraph, session };
		    
		    boolean keepGoing = delegateProxy.dispatch("beforeCrudCommon_COP_QFromDataGraph", beforeArgs, beforeArgsType);
		    if (!keepGoing) {
		    	if (LOGGER.isDebugEnabled()) LOGGER.debug("delegate cancellation");
		    		return null;
		    		}		    		
		   
		   Common_COP_QDMSHandlerImpl  handler = new Common_COP_QDMSHandlerImpl("CurrencyDemo", session);
			
			DataGraph retVal = handler.updateCommon_COP_Q(constructSaveRequest(common_COP_QGraph));
		  String[] afterArgsType = { this.getClass().getName(), "commonj.sdo.DataGraph", "com.versata.tl.vls.core.Session" };  
		  Object[] afterArgs = { this, retVal, session };
			delegateProxy.dispatch("afterCrudCommon_COP_QFromDataGraph", afterArgs, afterArgsType);
			return retVal;
		    }
		
		 
		 
		/**
		 * Create a new childmost data object. Only the attributes marked as editable in the data model will be copied from the incoming DTO
		 * 
		 * @param A simple javabean. Only those attributes marked as
		 * user updateable will be copied to the underlying Query Object 
		 * instance. 
		 * 
		 * @return The newly created object with any derivation rules applied.
		 *
		 */		 		 
		public Common_COP_QDTO createCommon_COP_QFromDTO(Common_COP_QDTO dto, Session session) throws ServerSecurityException, VSORBException {
			if (LOGGER.isDebugEnabled()) LOGGER.debug("createCommon_COP_QFromDTO");		   
		   
		    String[] beforeArgsType = { this.getClass().getName(), "CurrencyDemo.service.dto.Common_COP_QDTO", "com.versata.tl.vls.core.Session" };
		    Object[] beforeArgs = { this, dto, session };
		    
		    boolean keepGoing = delegateProxy.dispatch("beforeCreateCommon_COP_QFromDTO", beforeArgs, beforeArgsType);
		    if (!keepGoing) {
		    	if (LOGGER.isDebugEnabled()) LOGGER.debug("delegate cancellation");
		    	return null;
		    	}	
		    
		    // bypass SDO layer here 
		    
			VSMetaQuery metaQuery = GenericComponentFactory.getMetaQuery(
				"CurrencyDemo", "Common_COP_Q");

			DataRow dataRow = new DataRow(session, metaQuery, true);
			dataRow.setInsert();
			
			// we have the new QO with the default values. Only set those
			// attribute which are marked as user-updateable
		    
		    dataRow.setValue("COP_Id" , dto.getCOP_Id());
			dataRow.setValue("COP_Description" , dto.getCOP_Description());
		    
			dataRow.getBusinessObject().executeRules();
		    dataRow.getBusinessObject().calculateAllVirtualValues();
		    
		    
			
			CurrencyDemo.impl.Common_COP_QFactoryImpl Common_COP_QVar = new CurrencyDemo.impl.Common_COP_QFactoryImpl();
		    CurrencyDemo.Common_COP_Q sdoTransferObject = Common_COP_QVar.createCommon_COP_Q();
		    Common_COP_QMarshaller marshaller = new Common_COP_QMarshaller();
		    Common_COP_QDTO retVal = new Common_COP_QDTO();
		    

		    marshaller.marshal(sdoTransferObject, dataRow);
		    marshaller.marshal(sdoTransferObject, retVal);
		    
		    String[] afterArgsType = { this.getClass().getName(), "commonj.sdo.DataGraph", "com.versata.tl.vls.core.Session" };
		    Object[] afterArgs = { this, retVal, session };
			delegateProxy.dispatch("afterCreateCommon_COP_QFromDTO", afterArgs, afterArgsType);
			return retVal;
		    }
		 

		 
		 
	 
	/**
	 * Update the underyling Common_COP_Q. Only those attributes marked as editable in the data model will be updated
	 * 
	 * @param 	
	 * @return the updated object rendered as a simple DTO	 
	 *
	 */
	 		 		 
	public Common_COP_QDTO updateCommon_COP_Q(Common_COP_QDTO dto, Session session) throws ServerSecurityException, VSORBException {
		if (LOGGER.isDebugEnabled()) LOGGER.debug("updateCommon_COP_Q");
		String[] beforeArgsType = { this.getClass().getName(), "CurrencyDemo.service.dto.Common_COP_QDTO", "com.versata.tl.vls.core.Session" };
		Object[] beforeArgs = { this, dto, session };
		
		boolean keepGoing = delegateProxy.dispatch("beforeUpdateCommon_COP_Q", beforeArgs, beforeArgsType);
		if (!keepGoing) {
	  		if (LOGGER.isDebugEnabled()) LOGGER.debug("delegate cancellation");
	  		return dto;
		}		    		
			  
		com.versata.tl.common.util.SearchRequest sr = new com.versata.tl.common.util.SearchRequest();
	sr.addParameter("CommonParms_COP", "COP_Id", dto.getCOP_Id().toString());
		Enumeration enumeratedType = CurrencyDemo.Common_COP_QImpl.getObjects(sr, session);
		
		if (!enumeratedType.hasMoreElements()) {
			LOGGER.debug("Could not find anything to update");
			return null;
		}
		

		CurrencyDemo.Common_COP_QImpl qo = (CurrencyDemo.Common_COP_QImpl)enumeratedType.nextElement();
		qo.calculateAllVirtualValues();
		DataRow dataRow = qo.getRow();

	    Common_COP_QMarshaller marshaller = new Common_COP_QMarshaller();
	    CurrencyDemo.impl.Common_COP_QFactoryImpl Common_COP_QVar = new CurrencyDemo.impl.Common_COP_QFactoryImpl();
		CurrencyDemo.Common_COP_Q sdo = Common_COP_QVar.createCommon_COP_Q();
	    
	    // convert the simple dto to an SDO DTO
	    marshaller.unmarshal(sdo, dto);
	    
	    // now update the actual row
	    marshaller.unmarshal(sdo, dataRow);
	    qo.getRow().setUpdate();
		qo.executeRules();
		qo.calculateAllVirtualValues();
		
		if (enumeratedType.hasMoreElements()) {
			LOGGER.debug("Ignoring extra objects (there should not be any since we search on PK)");
		}
	
		Common_COP_QDTO retVal = new Common_COP_QDTO();
	    marshaller.marshal(sdo, dataRow);
	    marshaller.marshal(sdo, retVal);

		String[] afterArgsType = { this.getClass().getName(), "commonj.sdo.DataGraph", "com.versata.tl.vls.core.Session" };
		Object[] afterArgs = { this, retVal, session };
		delegateProxy.dispatch("afterUpdateCommon_COP_Q", afterArgs, afterArgsType);
		return retVal;
	}

	 
	 
	/**
	 * Delete the underlying CommonParms_COP for Common_COP_Q
	 * 
	 * @param 	the primary key of the childmost data model object	 
	 *
	 */	 		 		 
	public void deleteCommonParms_COP(Long COP_Id, Session session) throws ServerSecurityException, VSORBException {
		if (LOGGER.isDebugEnabled()) LOGGER.debug("deleteCommonParms_COP");
		String[] beforeArgsType = { this.getClass().getName(), "java.lang.Long", "com.versata.tl.vls.core.Session" };
		Object[] beforeArgs = { this, COP_Id, session };
		
		boolean keepGoing = delegateProxy.dispatch("beforeDeleteCommonParms_COP", beforeArgs, beforeArgsType);
		if (!keepGoing) {
	  		if (LOGGER.isDebugEnabled()) LOGGER.debug("delegate cancellation");
	  		return ;
		}		    		
		com.versata.tl.common.util.SearchRequest sr = new com.versata.tl.common.util.SearchRequest();
	sr.addParameter("CommonParms_COP", "COP_Id", COP_Id.toString());
		Enumeration enumeratedType = CurrencyDemo.Common_COP_QImpl.getObjects(sr, session);
		
		if (!enumeratedType.hasMoreElements()) {
			LOGGER.debug("Could not find anything to delete");
			return;
		}
		
		CurrencyDemo.Common_COP_QImpl qo = (CurrencyDemo.Common_COP_QImpl)enumeratedType.nextElement();
		qo.getRow().setDelete();
		qo.executeRules();
		
		if (enumeratedType.hasMoreElements()) {
			LOGGER.debug("Ignoring extra objects (there should not be any since we search on PK)");
		}
	    
	    String[] afterArgsType = { this.getClass().getName(), "java.lang.Long", "com.versata.tl.vls.core.Session" };
		Object[] afterArgs = { this, COP_Id, session };
		delegateProxy.dispatch("afterDeleteCommonParms_COP", afterArgs,afterArgsType);
	}
	 

	 }
