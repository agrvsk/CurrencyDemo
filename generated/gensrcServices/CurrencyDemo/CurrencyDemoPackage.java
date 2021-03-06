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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see CurrencyDemo.CurrencyDemoFactory
 * @model kind="package"
 * @generated
 */
public interface CurrencyDemoPackage extends EPackage
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
  String eNS_URI = "http://CurrencyDemo.service/CurrencyDemo";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "CurrencyDemo.service";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CurrencyDemoPackage eINSTANCE = CurrencyDemo.impl.CurrencyDemoPackageImpl.init();

  /**
   * The meta object id for the '{@link CurrencyDemo.impl.RootObjectImpl <em>Root Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see CurrencyDemo.impl.RootObjectImpl
   * @see CurrencyDemo.impl.CurrencyDemoPackageImpl#getRootObject()
   * @generated
   */
  int ROOT_OBJECT = 0;

  /**
   * The feature id for the '<em><b>Currency CUR customer</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT_OBJECT__CURRENCY_CUR_CUSTOMER = 0;

  /**
   * The feature id for the '<em><b>Common COP Q</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT_OBJECT__COMMON_COP_Q = 1;

  /**
   * The feature id for the '<em><b>Currency CUR customer1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT_OBJECT__CURRENCY_CUR_CUSTOMER1 = 2;

  /**
   * The number of structural features of the '<em>Root Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT_OBJECT_FEATURE_COUNT = 3;


  /**
   * Returns the meta object for class '{@link CurrencyDemo.RootObject <em>Root Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Root Object</em>'.
   * @see CurrencyDemo.RootObject
   * @generated
   */
  EClass getRootObject();

  /**
   * Returns the meta object for the containment reference list '{@link CurrencyDemo.RootObject#getCurrency_CUR_customer <em>Currency CUR customer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Currency CUR customer</em>'.
   * @see CurrencyDemo.RootObject#getCurrency_CUR_customer()
   * @see #getRootObject()
   * @generated
   */
  EReference getRootObject_Currency_CUR_customer();

  /**
   * Returns the meta object for the containment reference list '{@link CurrencyDemo.RootObject#getCommon_COP_Q <em>Common COP Q</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Common COP Q</em>'.
   * @see CurrencyDemo.RootObject#getCommon_COP_Q()
   * @see #getRootObject()
   * @generated
   */
  EReference getRootObject_Common_COP_Q();

  /**
   * Returns the meta object for the containment reference list '{@link CurrencyDemo.RootObject#getCurrency_CUR_customer1 <em>Currency CUR customer1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Currency CUR customer1</em>'.
   * @see CurrencyDemo.RootObject#getCurrency_CUR_customer1()
   * @see #getRootObject()
   * @generated
   */
  EReference getRootObject_Currency_CUR_customer1();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  CurrencyDemoFactory getCurrencyDemoFactory();

} //CurrencyDemoPackage
