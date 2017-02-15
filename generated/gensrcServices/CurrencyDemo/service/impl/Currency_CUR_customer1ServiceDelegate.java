

	/*
	 * Copyright (c) Versata, Inc., 2000-2005. All Rights Reserved.
	 *
	 * THIS CODE IS AUTO-GENERATED FROM YOUR MODEL.
	 * PLEASE DO NOT EDIT IT, BECAUSE ANY CHANGES YOU MAKE WILL BE OVERWRITTEN.
	 * 
	 * Generated Fri Feb 10 12:05:57 CET 2017 by $Header: //depot/main/products/brms/eclipse/plugins/com.versata.tl.service/templates/ServiceImplDelegate.javajet#1 $
	 */

	package CurrencyDemo.service.impl;


	import com.versata.tl.vls.core.Session;

	import commonj.sdo.DataGraph;
	import commonj.sdo.DataObject;
	

	/**
	 * The service delegate interface for the Currency_CUR_customer1ServiceImpl
	 * class.
	 * 
	 * A Service may be augmented by defining a class which implements this
	 * interface either fully (via the java 'implements' keyword) or partially
	 * (e.g. only a subset of the methods defined below are present in the
	 * delegate class). The generated Currency_CUR_customer1ServiceImpl code will
	 * check for a delegate at runtime and if the delegate implements any of the
	 * methods described below, the delegate method will be called. These method
	 * lookups are cached between delegate method invocations for runtime
	 * efficiency.
	 * 
	 * Each delegate method begining with 'before' can return false to terminate
	 * the ServiceImpl operation and return to it's caller immediately.
	 * 
	 * The delegate can - in the case where the parameters are mutable - change
	 * the object before the Currency_CUR_customer1ServiceImpl class executes the
	 * calls to lower layers (SDO, and ultimately in most cases, SQL sent to the
	 * database).
	 * 
	 * Each delegate class may also implement a set of 'after' methods which may
	 * perform postprocessing on any mutuable return variables which are passed
	 * back to the ServiceUtil client. The return value of these methods is
	 * currently ignored.
	 * 
	 * @since 6.0
	 * @see Currency_CUR_customer1ServiceImpl
	 * 
	 * BETA NOTE: The method signatures are currently out of synch with the 
	 * actual methods generated in the serviceImpl classes!!!! 
	 */


	 public interface Currency_CUR_customer1ServiceDelegate {	 
		 
		 public boolean beforeGetCurrency_CUR_customer1DataGraphByCurrency_CUR_PK1(Object sender, String CUR_Client, String CUR_CurrencyCode, Session session);
		 public boolean afterGetCurrency_CUR_customer1DataGraphByCurrency_CUR_PK1(Object sender, DataGraph datagraph, Session session);

		 
		 
		 public boolean beforeFindByCurrency_CUR_PK1(Object sender, String CUR_Client, String CUR_CurrencyCode, Session session);
		 public boolean afterFindByCurrency_CUR_PK1(Object sender, DataGraph datagraph, Session session);
		     
		 		 
		 public boolean beforeCrudCurrency_CUR_customer1FromDataGraph(Object sender, DataGraph dataGraph, Session session);
		 public boolean afterCrudCurrency_CUR_customer1FromDataGraph(Object sender, DataGraph dataGraph, Session session);
		    
		 		 		 
		 public boolean beforeDeleteCurrency_CUR_customer1(Object sender,String CUR_Client, String CUR_CurrencyCode, Session session);
		 public boolean afterDeleteCurrency_CUR_customer1(Object sender, String CUR_Client, String CUR_CurrencyCode, Session session);		 
	 }
