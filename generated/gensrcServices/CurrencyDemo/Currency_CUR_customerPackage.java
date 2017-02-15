/**
 *  Copyright (c) Versata, Inc., 2000-2004. All Rights Reserved.
 * 
 *  THIS CODE IS AUTOGENERATED BASED ON THE METAMODEL.  PLEASE DO NOT EDIT AS THE
 *  CHANGES WILL BE OVERWRITTEN
 * 
 * 
 *
 * $Id$
 */
package CurrencyDemo;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see CurrencyDemo.Currency_CUR_customerFactory
 * @model kind="package"
 * @generated
 */
public interface Currency_CUR_customerPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "CurrencyDemo";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://CurrencyDemo.service/Currency_CUR_customer.ecore";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "CurrencyDemo.service.Currency_CUR_customer";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Currency_CUR_customerPackage eINSTANCE = CurrencyDemo.impl.Currency_CUR_customerPackageImpl.init();

  /**
   * The meta object id for the '{@link CurrencyDemo.impl.Currency_CUR_customerImpl <em>Currency CUR customer</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see CurrencyDemo.impl.Currency_CUR_customerImpl
   * @see CurrencyDemo.impl.Currency_CUR_customerPackageImpl#getCurrency_CUR_customer()
   * @generated
   */
  int CURRENCY_CUR_CUSTOMER = 0;

  /**
   * The feature id for the '<em><b>CUR Client</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CURRENCY_CUR_CUSTOMER__CUR_CLIENT = 0;

  /**
   * The feature id for the '<em><b>CUR Currency Code</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CURRENCY_CUR_CUSTOMER__CUR_CURRENCY_CODE = 1;

  /**
   * The feature id for the '<em><b>CUR Exchange Rate</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CURRENCY_CUR_CUSTOMER__CUR_EXCHANGE_RATE = 2;

  /**
   * The feature id for the '<em><b>CUR Number Of Orders</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CURRENCY_CUR_CUSTOMER__CUR_NUMBER_OF_ORDERS = 3;

  /**
   * The feature id for the '<em><b>CUR Order Value USD</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CURRENCY_CUR_CUSTOMER__CUR_ORDER_VALUE_USD = 4;

  /**
   * The feature id for the '<em><b>CUR Order Amount Average</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CURRENCY_CUR_CUSTOMER__CUR_ORDER_AMOUNT_AVERAGE = 5;

  /**
   * The feature id for the '<em><b>CUR Image</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CURRENCY_CUR_CUSTOMER__CUR_IMAGE = 6;

  /**
   * The feature id for the '<em><b>CUR Client Related To</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CURRENCY_CUR_CUSTOMER__CUR_CLIENT_RELATED_TO = 7;

  /**
   * The feature id for the '<em><b>CUR Currency Code Related To</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CURRENCY_CUR_CUSTOMER__CUR_CURRENCY_CODE_RELATED_TO = 8;

  /**
   * The number of structural features of the '<em>Currency CUR customer</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CURRENCY_CUR_CUSTOMER_FEATURE_COUNT = 9;


  /**
   * Returns the meta object for class '{@link CurrencyDemo.Currency_CUR_customer <em>Currency CUR customer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Currency CUR customer</em>'.
   * @see CurrencyDemo.Currency_CUR_customer
   * @generated
   */
  EClass getCurrency_CUR_customer();

  /**
   * Returns the meta object for the attribute '{@link CurrencyDemo.Currency_CUR_customer#getCUR_Client <em>CUR Client</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>CUR Client</em>'.
   * @see CurrencyDemo.Currency_CUR_customer#getCUR_Client()
   * @see #getCurrency_CUR_customer()
   * @generated
   */
  EAttribute getCurrency_CUR_customer_CUR_Client();

  /**
   * Returns the meta object for the attribute '{@link CurrencyDemo.Currency_CUR_customer#getCUR_CurrencyCode <em>CUR Currency Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>CUR Currency Code</em>'.
   * @see CurrencyDemo.Currency_CUR_customer#getCUR_CurrencyCode()
   * @see #getCurrency_CUR_customer()
   * @generated
   */
  EAttribute getCurrency_CUR_customer_CUR_CurrencyCode();

  /**
   * Returns the meta object for the attribute '{@link CurrencyDemo.Currency_CUR_customer#getCUR_ExchangeRate <em>CUR Exchange Rate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>CUR Exchange Rate</em>'.
   * @see CurrencyDemo.Currency_CUR_customer#getCUR_ExchangeRate()
   * @see #getCurrency_CUR_customer()
   * @generated
   */
  EAttribute getCurrency_CUR_customer_CUR_ExchangeRate();

  /**
   * Returns the meta object for the attribute '{@link CurrencyDemo.Currency_CUR_customer#getCUR_NumberOfOrders <em>CUR Number Of Orders</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>CUR Number Of Orders</em>'.
   * @see CurrencyDemo.Currency_CUR_customer#getCUR_NumberOfOrders()
   * @see #getCurrency_CUR_customer()
   * @generated
   */
  EAttribute getCurrency_CUR_customer_CUR_NumberOfOrders();

  /**
   * Returns the meta object for the attribute '{@link CurrencyDemo.Currency_CUR_customer#getCUR_OrderValueUSD <em>CUR Order Value USD</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>CUR Order Value USD</em>'.
   * @see CurrencyDemo.Currency_CUR_customer#getCUR_OrderValueUSD()
   * @see #getCurrency_CUR_customer()
   * @generated
   */
  EAttribute getCurrency_CUR_customer_CUR_OrderValueUSD();

  /**
   * Returns the meta object for the attribute '{@link CurrencyDemo.Currency_CUR_customer#getCUR_OrderAmountAverage <em>CUR Order Amount Average</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>CUR Order Amount Average</em>'.
   * @see CurrencyDemo.Currency_CUR_customer#getCUR_OrderAmountAverage()
   * @see #getCurrency_CUR_customer()
   * @generated
   */
  EAttribute getCurrency_CUR_customer_CUR_OrderAmountAverage();

  /**
   * Returns the meta object for the attribute '{@link CurrencyDemo.Currency_CUR_customer#getCUR_Image <em>CUR Image</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>CUR Image</em>'.
   * @see CurrencyDemo.Currency_CUR_customer#getCUR_Image()
   * @see #getCurrency_CUR_customer()
   * @generated
   */
  EAttribute getCurrency_CUR_customer_CUR_Image();

  /**
   * Returns the meta object for the attribute '{@link CurrencyDemo.Currency_CUR_customer#getCUR_Client_RelatedTo <em>CUR Client Related To</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>CUR Client Related To</em>'.
   * @see CurrencyDemo.Currency_CUR_customer#getCUR_Client_RelatedTo()
   * @see #getCurrency_CUR_customer()
   * @generated
   */
  EAttribute getCurrency_CUR_customer_CUR_Client_RelatedTo();

  /**
   * Returns the meta object for the attribute '{@link CurrencyDemo.Currency_CUR_customer#getCUR_CurrencyCode_RelatedTo <em>CUR Currency Code Related To</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>CUR Currency Code Related To</em>'.
   * @see CurrencyDemo.Currency_CUR_customer#getCUR_CurrencyCode_RelatedTo()
   * @see #getCurrency_CUR_customer()
   * @generated
   */
  EAttribute getCurrency_CUR_customer_CUR_CurrencyCode_RelatedTo();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Currency_CUR_customerFactory getCurrency_CUR_customerFactory();

} //Currency_CUR_customerPackage
