

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

import CurrencyDemo.service.dms.Currency_CUR_customerDMSHandlerImpl;
import CurrencyDemo.service.dms.Currency_CUR_customerMarshaller;
import CurrencyDemo.impl.Currency_CUR_customerImpl;
import CurrencyDemo.Currency_CUR_customer;	
import CurrencyDemo.service.dto.Currency_CUR_customerDTO;

import CurrencyDemo.RootObject;

import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;

import org.eclipse.emf.ecore.sdo.EDataGraph;
import org.eclipse.emf.ecore.sdo.SDOFactory;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;





	/**
	 * The service implementation class for the Currency_CUR_customer query object.<p>
	 *
	 * This class provides many helper methods used to manipulate Currency_CUR_customer
	 * objects. It is used by the generated stateless service bean (and hence any 
	 * generated web service).Custom services are encouraged to use this class.<p>
	 *
	 * The ServiceImpl classes support the notion of a user-defined delegate class, which 
	 * either formally implements the entire Currency_CUR_customerServiceDelegate interface 
	 * or a subset of that interface. At runtime, this class will check for a delegate, 
	 * and invoke the delegate beforeXXX and afterXXX methods. @see Currency_CUR_customerServiceDelegate 
	 *	 	
	*/

	 public class Currency_CUR_customerServiceImpl extends ServiceImplBase {

		 private static final VersataLogger LOGGER = VersataLogger.getLogger(
				Currency_CUR_customerServiceImpl.class);

		private Object delegate;
		private ServiceDelegateProxy delegateProxy;	
			

		
		public Currency_CUR_customerServiceImpl(Object delegate) {
			setDelegate(delegate);
		}

		public Currency_CUR_customerServiceImpl() {
			this(null);
		}
		
		
		
		public void setDelegate(Object delegate) {
			this.delegate = delegate;
			delegateProxy = new ServiceDelegateProxy(delegate, Currency_CUR_customerServiceDelegate.class);
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
			Currency_CUR_customerDMSHandlerImpl  handler = new Currency_CUR_customerDMSHandlerImpl("CurrencyDemo", session);
			
			return handler.getDataGraph();
		}
		
		
		/**
		 * Return a datagraph given the primary key of the childmost dataobject
		 * 
		 * @param 		 
		 * @return 
		 *
		 */		 
		public DataGraph getCurrency_CUR_customerDataGraphByCurrency_CUR_PK1(String CUR_Client, String CUR_CurrencyCode, Session session) throws ServerSecurityException, VSORBException {
			
			String [] beforeArgsType = {this.getClass().getName(), "java.lang.String", "java.lang.String", "com.versata.tl.vls.core.Session"};
			Object[] beforeArgs = { this, CUR_Client, CUR_CurrencyCode, session };
		 	if (LOGGER.isDebugEnabled()) LOGGER.debug("getCurrency_CUR_customerDataGraphByCurrency_CUR_PK1");
		 	
		  boolean keepGoing = delegateProxy.dispatch("beforeGetCurrency_CUR_customerDataGraphByCurrency_CUR_PK1", beforeArgs, beforeArgsType);
		  if (!keepGoing) {
		  	if (LOGGER.isDebugEnabled()) LOGGER.debug("delegate cancellation");
		    return null;
		  }		    		
		    
		  Currency_CUR_customerDMSHandlerImpl  handler = new Currency_CUR_customerDMSHandlerImpl("CurrencyDemo", session);
			
			String[] columnNames = { "CUR_Client", "CUR_CurrencyCode" };
			Object[] columnValues = { CUR_Client, CUR_CurrencyCode };

		  DataGraph retVal = handler.getCurrency_CUR_customer(columnNames, columnValues);
		  String[] afterArgsType = {this.getClass().getName(), "commonj.sdo.DataGraph", "com.versata.tl.vls.core.Session"};
		  Object[] afterArgs = { this, retVal, session };
		  delegateProxy.dispatch("afterGetCurrency_CUR_customerDataGraphByCurrency_CUR_PK1", afterArgs, afterArgsType);
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
			 
			public DataGraph getCurrency_CUR_customerDataGraphAdvanced(Filter filter, List orderByAttributes, int rowLimit, Session session) throws ServerSecurityException, VSORBException {
			 	if (LOGGER.isDebugEnabled()) LOGGER.debug("getCurrency_CUR_customerDataGraphAdvanced");
			 	String[] beforeArgsType = { this.getClass().getName(), "com.versata.tl.common.util.SearchRequest", "com.versata.tl.common.util.SearchRequest", "java.lang.Integer", "com.versata.tl.vls.core.Session" };
			 	Object[] beforeArgs = { this, filter, orderByAttributes, Integer.valueOf(rowLimit), session };
			   boolean keepGoing = delegateProxy.dispatch("beforeGetCurrency_CUR_customerDataGraphAdvanced", beforeArgs, beforeArgsType);
			   if (!keepGoing) {
					if (LOGGER.isDebugEnabled()) LOGGER.debug("delegate cancellation");
					return null;
			  }		    		
			    
			  Currency_CUR_customerDMSHandlerImpl  handler = new Currency_CUR_customerDMSHandlerImpl("CurrencyDemo", session);
				
			  RootObject rootObject = CurrencyDemo.CurrencyDemoFactory.eINSTANCE.createRootObject();
			  Property property = getPropertyFromRootObject(rootObject, "currency_CUR_customer");

			  SearchRequestFactory searchRequestFactory = new SearchRequestFactory();
			  SearchRequest searchRequest = searchRequestFactory.createSearchRequest("Currency_CUR_customer", filter, rowLimit, property, orderByAttributes, null, null, null, null, SearchRequest.FIRST);
			  
			  // Assumption : if a orderby clause is sent as a string, it should be the first element in orderByAttributes list
			  if(orderByAttributes != null){
				  Object firstObject = orderByAttributes.get(0);
				  if(firstObject != null && firstObject.getClass().equals(String.class)){
					  searchRequest.setOrderByClause((String)firstObject);
				  }
			  }
			  
			  DataGraph retVal = handler.getCurrency_CUR_customer(searchRequest);
			    
			  Object[] afterArgs = { this, retVal, session };
			  String[] afterArgsType = { this.getClass().getName(), "commonj.sdo.DataGraph", "com.versata.tl.vls.core.Session" };
			  delegateProxy.dispatch("afterGetCurrency_CUR_customerDataGraphAdvanced", afterArgs, afterArgsType);
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
			 
			public DataGraph getCurrency_CUR_customerDataGraphViaSQL(String whereClause, int rowLimit, Session session) throws ServerSecurityException, VSORBException {
			 	if (LOGGER.isDebugEnabled()) LOGGER.debug("getCurrency_CUR_customerDataGraphViaSQL");
			 	String[] beforeArgsType = { this.getClass().getName(), "com.versata.tl.common.util.SearchRequest", "java.lang.Integer", "com.versata.tl.vls.core.Session"};
			 	Object[] beforeArgs = { this, whereClause, Integer.valueOf(rowLimit), session };

			  	boolean keepGoing = delegateProxy.dispatch("beforeGetCurrency_CUR_customerDataGraphViaSQL", beforeArgs, beforeArgsType);
			  	if (!keepGoing) {
			  		if (LOGGER.isDebugEnabled()) LOGGER.debug("delegate cancellation");
					return null;
				}

				WhereClauseFactory whereClauseFactory = new WhereClauseFactory();
				WhereClause wc = whereClauseFactory.createStringWhereClause(whereClause, "Currency_CUR_customer");
		  		
				Filter filter = new FilterImpl(wc);
				
				DataGraph retVal = this.getCurrency_CUR_customerDataGraphAdvanced(filter, null, rowLimit, session);
			    
		   		String[] afterArgsType = { this.getClass().getName(), "commonj.sdo.DataGraph", "com.versata.tl.vls.core.Session" };
			    Object[] afterArgs = { this, retVal, session };
				delegateProxy.dispatch("afterGetCurrency_CUR_customerDataGraphViaSQL", afterArgs, afterArgsType);
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
			 
			public Currency_CUR_customerDTO[] getCurrency_CUR_customerArrayViaSQL(String whereClause, Integer rowLimit, Session session) throws ServerSecurityException {
			 	if (LOGGER.isDebugEnabled()) LOGGER.debug("getCurrency_CUR_customerArrayViaSQL");
			 	String[] beforeArgsType = { this.getClass().getName(), "com.versata.tl.common.util.SearchRequest", "java.lang.Integer", "com.versata.tl.vls.core.Session"};			
				Object[] beforeArgs = { this, whereClause, rowLimit, session };
				
				boolean keepGoing = delegateProxy.dispatch("beforeGetCurrency_CUR_customerArrayViaSQL", beforeArgs, beforeArgsType);
			    if (!keepGoing) {
			    	LOGGER.debug("delegate cancellation");
		    		return null;
				}		    		

			    DataGraph dg = this.getCurrency_CUR_customerDataGraphViaSQL(whereClause, rowLimit.intValue(), session);
			    
				// convert the SDO graph to a DTO array
				List list = dg.getRootObject().getList("currency_CUR_customer");
		  		Currency_CUR_customerMarshaller marshaller = new Currency_CUR_customerMarshaller();
				Currency_CUR_customerDTO[] retVal = new Currency_CUR_customerDTO[list.size()];
				
				for (int i=0; i<list.size(); i++) {
					Currency_CUR_customerImpl sdo = (Currency_CUR_customerImpl)list.get(i);
					Currency_CUR_customerDTO dto = new Currency_CUR_customerDTO();
					//TODO: commenting the dto marshaller for now.
					//marshaller.marshal(sdo, dto);
					retVal[i] = dto;
				}
				
				String[] afterArgsType = { this.getClass().getName(), "commonj.sdo.DataGraph", "com.versata.tl.vls.core.Session" };
			    Object[] afterArgs = { this, retVal, session };
				delegateProxy.dispatch("afterGetCurrency_CUR_customerArrayViaSQL", afterArgs, afterArgsType);
				return retVal;			
			}
		    
					
			 		
		 
		/**
		 * Retrieves an SDO transfer object given the primary key
		 * 
		 * @param currency_CUR_PK1 the primary key
		 * @return A single SDO Data Transfer Object 
		 * 
		 */
		 
		public Currency_CUR_customer getCurrency_CUR_customerDataObjectByCurrency_CUR_PK1(String CUR_Client, String CUR_CurrencyCode, Session session) throws ServerSecurityException, VSORBException {
			if (LOGGER.isDebugEnabled()) LOGGER.debug("getCurrency_CUR_customerDataObjectByCurrency_CUR_PK1");
			String[] beforeArgsType = { this.getClass().getName(), "java.lang.String", "java.lang.String", "com.versata.tl.vls.core.Session" };				
			Object[] beforeArgs = { this, CUR_Client, CUR_CurrencyCode, session };

			boolean keepGoing = delegateProxy.dispatch("beforeGetCurrency_CUR_customerDataObjectByCurrency_CUR_PK1", beforeArgs, beforeArgsType);
			if (!keepGoing) {
		  		if (LOGGER.isDebugEnabled()) LOGGER.debug("delegate cancellation");
		  		return null;
		  	}		    		
		
			Currency_CUR_customerImpl retVal = null;
			DataGraph dataGraph = this.getCurrency_CUR_customerDataGraphByCurrency_CUR_PK1(CUR_Client, CUR_CurrencyCode, session);						
		  	List list = dataGraph.getRootObject().getList("currency_CUR_customer");
		  	
			if (list.size() == 0) {
		  		LOGGER.debug("No rows returned");		  	
		  	}
		  	else {
				retVal = (Currency_CUR_customerImpl)list.get(0);
		  		if (list.size() > 1) {
		  			LOGGER.debug("Expected 1 row but found " + list.size());
		  		}
		  	}
		  	String[] afterArgsType = { "java.lang.Object", "commonj.sdo.DataGraph", "com.versata.tl.vls.core.Session" };
			Object[] afterArgs = { this, retVal, session };
			delegateProxy.dispatch("afterGetCurrency_CUR_customerDataObjectByCurrency_CUR_PK1", afterArgs, afterArgsType);
			return retVal;
		}

		 
  /**
  * Retrieve a simple Data Transfer Object via the primary key
  * 
  * 
  * @return A single javabean ('POJO') Data Transfer Object 
  * 
  */		 
  public Currency_CUR_customerDTO getCurrency_CUR_customerDTOByCurrency_CUR_PK1(String CUR_Client, String CUR_CurrencyCode, Session session) throws ServerSecurityException, VSORBException {
		 if (LOGGER.isDebugEnabled()) LOGGER.debug("getCurrency_CUR_customerDTOByCurrency_CUR_PK1");	
		  Currency_CUR_customerDTO retVal = null;
	            String[] beforeArgsType = { this.getClass().getName(), "java.lang.String", "java.lang.String", "com.versata.tl.vls.core.Session" };
		 		Object[] beforeArgs = { this, CUR_Client, CUR_CurrencyCode, session };
		  		
		  		boolean keepGoing = delegateProxy.dispatch("beforeGetCurrency_CUR_customerDTOByCurrency_CUR_PK1", beforeArgs, beforeArgsType);
		  		if (!keepGoing) {
		  			if (LOGGER.isDebugEnabled()) LOGGER.debug("delegate cancellation");
		  			return null;
		  		}		    		
		
		  		DataGraph dataGraph = this.getCurrency_CUR_customerDataGraphByCurrency_CUR_PK1(CUR_Client, CUR_CurrencyCode, session);			
		  		List list = dataGraph.getRootObject().getList("currency_CUR_customer");
		  

		  
  		  		if (list.size() == 0) {
		  			LOGGER.debug("No rows returned");		  	
		  		}
		  		else {
					Currency_CUR_customerImpl sdo = (Currency_CUR_customerImpl)list.get(0);
		  			retVal = new Currency_CUR_customerDTO();
		  			Currency_CUR_customerMarshaller marshaller = new Currency_CUR_customerMarshaller();
		  			marshaller.marshal(sdo, retVal);
		  		
		  			if (list.size() > 1) {
		  				LOGGER.debug("Expected 1 row but found " + list.size());
		  			}
		  		}	  		
		  
		  
				String[] afterArgsType = { this.getClass().getName(), "commonj.sdo.DataGraph", "com.versata.tl.vls.core.Session" };
		  		Object[] afterArgs = { this, retVal, session };
		  		delegateProxy.dispatch("afterGetCurrency_CUR_customerDTOByCurrency_CUR_PK1", afterArgs,afterArgsType);


	  		return retVal;		    
		    
		}

			
		/**
		 * A generated finder method based on the Currency_CUR_ALT1 index of Currency_CUR
		 * 
		 * @return 
		 * 
		 * @ejb:interface-method view-type="both"
		 */
		 
		 
		public DataGraph findByCurrency_CUR_Currency_CUR_ALT1(String cUR_Client_RelatedTo, String cUR_CurrencyCode_RelatedTo, Session session) throws ServerSecurityException {
		 	if (LOGGER.isDebugEnabled()) LOGGER.debug("findByCurrency_CUR_Currency_CUR_ALT1");
		 	String[] beforeArgsType = { this.getClass().getName(), "java.lang.String", "java.lang.String", "com.versata.tl.vls.core.Session" };			
			Object[] beforeArgs = { this, cUR_Client_RelatedTo, cUR_CurrencyCode_RelatedTo, session };
			
		     boolean keepGoing = delegateProxy.dispatch("beforeFindByCurrency_CUR_Currency_CUR_ALT1", beforeArgs, beforeArgsType);
		    if (!keepGoing) {
		    	if (LOGGER.isDebugEnabled()) LOGGER.debug("delegate cancellation");
		    		return null;
		    		}		    		
				
			String[] columnNames = { "CUR_Client_RelatedTo", "CUR_CurrencyCode_RelatedTo"};	
			Object[] columnValues = { cUR_Client_RelatedTo, cUR_CurrencyCode_RelatedTo};	
			
						
		    Currency_CUR_customerDMSHandlerImpl  handler = new Currency_CUR_customerDMSHandlerImpl("CurrencyDemo", session);
		    DataGraph retVal = handler.getCurrency_CUR_customer(columnNames, columnValues);
		    
		    String[] afterArgsType = { this.getClass().getName(), "commonj.sdo.DataGraph", "com.versata.tl.vls.core.Session" };
		    Object[] afterArgs = { this, retVal, session };
			delegateProxy.dispatch("afterFindByCurrency_CUR_Currency_CUR_ALT1", afterArgs, afterArgsType);
			return retVal;			
		}

			/**
			 * A generated finder method based on the Currency_CUR_ALT1 index of Currency_CUR
			 * 
			 * @return 
			 * 
			 * @ejb:interface-method view-type="both"
			 */
			 
			 
			 

			public Currency_CUR_customerDTO[] findCurrency_CUR_customerArrayByCurrency_CUR_Currency_CUR_ALT1(String cUR_Client_RelatedTo, String cUR_CurrencyCode_RelatedTo, Session session) throws ServerSecurityException {
			 	if (LOGGER.isDebugEnabled()) LOGGER.debug("findCurrency_CUR_customerArrayByCurrency_CUR_Currency_CUR_ALT1");
			 	String[] beforeArgsType = { this.getClass().getName(), "java.lang.String", "java.lang.String", "com.versata.tl.vls.core.Session" };			
				Object[] beforeArgs = { this, cUR_Client_RelatedTo, cUR_CurrencyCode_RelatedTo, session };
				
			    boolean keepGoing = delegateProxy.dispatch("beforeFindCurrency_CUR_customerArrayByCurrency_CUR_Currency_CUR_ALT1", beforeArgs, beforeArgsType);
			    if (!keepGoing) {
			    	if (LOGGER.isDebugEnabled()) LOGGER.debug("delegate cancellation");
			    		return null;
			    		}		    		
					
			    
			    Currency_CUR_customerMarshaller marshaller = new Currency_CUR_customerMarshaller();
			    
				String[] columnNames = { "CUR_Client_RelatedTo", "CUR_CurrencyCode_RelatedTo"};	
				Object[] columnValues = { cUR_Client_RelatedTo, cUR_CurrencyCode_RelatedTo};	
				
							
			    Currency_CUR_customerDMSHandlerImpl  handler = new Currency_CUR_customerDMSHandlerImpl("CurrencyDemo", session);
			    DataGraph dg = handler.getCurrency_CUR_customer(columnNames, columnValues);
			    
				// convert the SDO graph to a DTO array
				List list = dg.getRootObject().getList("currency_CUR_customer");
				Currency_CUR_customerDTO[] retVal = new Currency_CUR_customerDTO[list.size()];
				for (int i=0; i<list.size(); i++) {
					Currency_CUR_customerImpl sdo = (Currency_CUR_customerImpl)list.get(i);
					Currency_CUR_customerDTO dto = new Currency_CUR_customerDTO();
					marshaller.marshal(sdo, dto);
					retVal[i] = dto;
				}
				
				String[] afterArgsType = { this.getClass().getName(), "commonj.sdo.DataGraph", "com.versata.tl.vls.core.Session" };
			    Object[] afterArgs = { this, retVal, session };
				delegateProxy.dispatch("afterFindCurrency_CUR_customerArrayByCurrency_CUR_Currency_CUR_ALT1", afterArgs, afterArgsType);
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
		public DataGraph crudCurrency_CUR_customerFromDataGraph(DataGraph currency_CUR_customerGraph, Session session) throws ServerSecurityException, VSORBException {
			if (LOGGER.isDebugEnabled()) LOGGER.debug("crudCurrency_CUR_customerFromDataGraph");		   
		   String[] beforeArgsType = { this.getClass().getName(), "commonj.sdo.DataGraph", "com.versata.tl.vls.core.Session" };
		    Object[] beforeArgs = { this, currency_CUR_customerGraph, session };
		    
		    boolean keepGoing = delegateProxy.dispatch("beforeCrudCurrency_CUR_customerFromDataGraph", beforeArgs, beforeArgsType);
		    if (!keepGoing) {
		    	if (LOGGER.isDebugEnabled()) LOGGER.debug("delegate cancellation");
		    		return null;
		    		}		    		
		   
		   Currency_CUR_customerDMSHandlerImpl  handler = new Currency_CUR_customerDMSHandlerImpl("CurrencyDemo", session);
			
			DataGraph retVal = handler.updateCurrency_CUR_customer(constructSaveRequest(currency_CUR_customerGraph));
		  String[] afterArgsType = { this.getClass().getName(), "commonj.sdo.DataGraph", "com.versata.tl.vls.core.Session" };  
		  Object[] afterArgs = { this, retVal, session };
			delegateProxy.dispatch("afterCrudCurrency_CUR_customerFromDataGraph", afterArgs, afterArgsType);
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
		public Currency_CUR_customerDTO createCurrency_CUR_customerFromDTO(Currency_CUR_customerDTO dto, Session session) throws ServerSecurityException, VSORBException {
			if (LOGGER.isDebugEnabled()) LOGGER.debug("createCurrency_CUR_customerFromDTO");		   
		   
		    String[] beforeArgsType = { this.getClass().getName(), "CurrencyDemo.service.dto.Currency_CUR_customerDTO", "com.versata.tl.vls.core.Session" };
		    Object[] beforeArgs = { this, dto, session };
		    
		    boolean keepGoing = delegateProxy.dispatch("beforeCreateCurrency_CUR_customerFromDTO", beforeArgs, beforeArgsType);
		    if (!keepGoing) {
		    	if (LOGGER.isDebugEnabled()) LOGGER.debug("delegate cancellation");
		    	return null;
		    	}	
		    
		    // bypass SDO layer here 
		    
			VSMetaQuery metaQuery = GenericComponentFactory.getMetaQuery(
				"CurrencyDemo", "Currency_CUR_customer");

			DataRow dataRow = new DataRow(session, metaQuery, true);
			dataRow.setInsert();
			
			// we have the new QO with the default values. Only set those
			// attribute which are marked as user-updateable
		    
		    dataRow.setValue("CUR_Client" , dto.getCUR_Client());
			dataRow.setValue("CUR_CurrencyCode" , dto.getCUR_CurrencyCode());
			dataRow.setValue("CUR_ExchangeRate" , dto.getCUR_ExchangeRate());
			dataRow.setValue("CUR_NumberOfOrders" , dto.getCUR_NumberOfOrders());
			dataRow.setValue("CUR_OrderValueUSD" , dto.getCUR_OrderValueUSD());
			dataRow.setValue("CUR_OrderAmountAverage" , dto.getCUR_OrderAmountAverage());
			dataRow.setValue("CUR_Image" , dto.getCUR_Image());
			dataRow.setValue("CUR_Client_RelatedTo" , dto.getCUR_Client_RelatedTo());
			dataRow.setValue("CUR_CurrencyCode_RelatedTo" , dto.getCUR_CurrencyCode_RelatedTo());
		    
			dataRow.getBusinessObject().executeRules();
		    dataRow.getBusinessObject().calculateAllVirtualValues();
		    
		    
			
			CurrencyDemo.impl.Currency_CUR_customerFactoryImpl Currency_CUR_customerVar = new CurrencyDemo.impl.Currency_CUR_customerFactoryImpl();
		    CurrencyDemo.Currency_CUR_customer sdoTransferObject = Currency_CUR_customerVar.createCurrency_CUR_customer();
		    Currency_CUR_customerMarshaller marshaller = new Currency_CUR_customerMarshaller();
		    Currency_CUR_customerDTO retVal = new Currency_CUR_customerDTO();
		    

		    marshaller.marshal(sdoTransferObject, dataRow);
		    marshaller.marshal(sdoTransferObject, retVal);
		    
		    String[] afterArgsType = { this.getClass().getName(), "commonj.sdo.DataGraph", "com.versata.tl.vls.core.Session" };
		    Object[] afterArgs = { this, retVal, session };
			delegateProxy.dispatch("afterCreateCurrency_CUR_customerFromDTO", afterArgs, afterArgsType);
			return retVal;
		    }
		 

		 
		 
	 
	/**
	 * Update the underyling Currency_CUR_customer. Only those attributes marked as editable in the data model will be updated
	 * 
	 * @param 	
	 * @return the updated object rendered as a simple DTO	 
	 *
	 */
	 		 		 
	public Currency_CUR_customerDTO updateCurrency_CUR_customer(Currency_CUR_customerDTO dto, Session session) throws ServerSecurityException, VSORBException {
		if (LOGGER.isDebugEnabled()) LOGGER.debug("updateCurrency_CUR_customer");
		String[] beforeArgsType = { this.getClass().getName(), "CurrencyDemo.service.dto.Currency_CUR_customerDTO", "com.versata.tl.vls.core.Session" };
		Object[] beforeArgs = { this, dto, session };
		
		boolean keepGoing = delegateProxy.dispatch("beforeUpdateCurrency_CUR_customer", beforeArgs, beforeArgsType);
		if (!keepGoing) {
	  		if (LOGGER.isDebugEnabled()) LOGGER.debug("delegate cancellation");
	  		return dto;
		}		    		
			  
		com.versata.tl.common.util.SearchRequest sr = new com.versata.tl.common.util.SearchRequest();
	sr.addParameter("Currency_CUR", "CUR_Client", dto.getCUR_Client().toString());
			sr.addParameter("Currency_CUR", "CUR_CurrencyCode", dto.getCUR_CurrencyCode().toString());
		Enumeration enumeratedType = CurrencyDemo.Currency_CUR_customerImpl.getObjects(sr, session);
		
		if (!enumeratedType.hasMoreElements()) {
			LOGGER.debug("Could not find anything to update");
			return null;
		}
		

		CurrencyDemo.Currency_CUR_customerImpl qo = (CurrencyDemo.Currency_CUR_customerImpl)enumeratedType.nextElement();
		qo.calculateAllVirtualValues();
		DataRow dataRow = qo.getRow();

	    Currency_CUR_customerMarshaller marshaller = new Currency_CUR_customerMarshaller();
	    CurrencyDemo.impl.Currency_CUR_customerFactoryImpl Currency_CUR_customerVar = new CurrencyDemo.impl.Currency_CUR_customerFactoryImpl();
		CurrencyDemo.Currency_CUR_customer sdo = Currency_CUR_customerVar.createCurrency_CUR_customer();
	    
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
	
		Currency_CUR_customerDTO retVal = new Currency_CUR_customerDTO();
	    marshaller.marshal(sdo, dataRow);
	    marshaller.marshal(sdo, retVal);

		String[] afterArgsType = { this.getClass().getName(), "commonj.sdo.DataGraph", "com.versata.tl.vls.core.Session" };
		Object[] afterArgs = { this, retVal, session };
		delegateProxy.dispatch("afterUpdateCurrency_CUR_customer", afterArgs, afterArgsType);
		return retVal;
	}

	 
	 
	/**
	 * Delete the underlying Currency_CUR for Currency_CUR_customer
	 * 
	 * @param 	the primary key of the childmost data model object	 
	 *
	 */	 		 		 
	public void deleteCurrency_CUR(String CUR_Client, String CUR_CurrencyCode, Session session) throws ServerSecurityException, VSORBException {
		if (LOGGER.isDebugEnabled()) LOGGER.debug("deleteCurrency_CUR");
		String[] beforeArgsType = { this.getClass().getName(), "java.lang.String", "java.lang.String", "com.versata.tl.vls.core.Session" };
		Object[] beforeArgs = { this, CUR_Client, CUR_CurrencyCode, session };
		
		boolean keepGoing = delegateProxy.dispatch("beforeDeleteCurrency_CUR", beforeArgs, beforeArgsType);
		if (!keepGoing) {
	  		if (LOGGER.isDebugEnabled()) LOGGER.debug("delegate cancellation");
	  		return ;
		}		    		
		com.versata.tl.common.util.SearchRequest sr = new com.versata.tl.common.util.SearchRequest();
	sr.addParameter("Currency_CUR", "CUR_Client", CUR_Client.toString());
			sr.addParameter("Currency_CUR", "CUR_CurrencyCode", CUR_CurrencyCode.toString());
		Enumeration enumeratedType = CurrencyDemo.Currency_CUR_customerImpl.getObjects(sr, session);
		
		if (!enumeratedType.hasMoreElements()) {
			LOGGER.debug("Could not find anything to delete");
			return;
		}
		
		CurrencyDemo.Currency_CUR_customerImpl qo = (CurrencyDemo.Currency_CUR_customerImpl)enumeratedType.nextElement();
		qo.getRow().setDelete();
		qo.executeRules();
		
		if (enumeratedType.hasMoreElements()) {
			LOGGER.debug("Ignoring extra objects (there should not be any since we search on PK)");
		}
	    
	    String[] afterArgsType = { this.getClass().getName(), "java.lang.String", "java.lang.String", "com.versata.tl.vls.core.Session" };
		Object[] afterArgs = { this, CUR_Client, CUR_CurrencyCode, session };
		delegateProxy.dispatch("afterDeleteCurrency_CUR", afterArgs,afterArgsType);
	}
	 

	 }
