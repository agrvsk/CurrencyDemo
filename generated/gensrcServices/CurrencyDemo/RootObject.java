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

import commonj.sdo.DataObject;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link CurrencyDemo.RootObject#getCurrency_CUR_customer <em>Currency CUR customer</em>}</li>
 *   <li>{@link CurrencyDemo.RootObject#getCommon_COP_Q <em>Common COP Q</em>}</li>
 *   <li>{@link CurrencyDemo.RootObject#getCurrency_CUR_customer1 <em>Currency CUR customer1</em>}</li>
 * </ul>
 * </p>
 *
 * @see CurrencyDemo.CurrencyDemoPackage#getRootObject()
 * @model
 * @extends DataObject
 * @generated
 */
public interface RootObject extends DataObject
{
  /**
   * Returns the value of the '<em><b>Currency CUR customer</b></em>' containment reference list.
   * The list contents are of type {@link CurrencyDemo.Currency_CUR_customer}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Currency CUR customer</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Currency CUR customer</em>' containment reference list.
   * @see CurrencyDemo.CurrencyDemoPackage#getRootObject_Currency_CUR_customer()
   * @model type="CurrencyDemo.Currency_CUR_customer" containment="true"
   * @generated
   */
  List getCurrency_CUR_customer();

  /**
   * Returns the value of the '<em><b>Common COP Q</b></em>' containment reference list.
   * The list contents are of type {@link CurrencyDemo.Common_COP_Q}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Common COP Q</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Common COP Q</em>' containment reference list.
   * @see CurrencyDemo.CurrencyDemoPackage#getRootObject_Common_COP_Q()
   * @model type="CurrencyDemo.Common_COP_Q" containment="true"
   * @generated
   */
  List getCommon_COP_Q();

  /**
   * Returns the value of the '<em><b>Currency CUR customer1</b></em>' containment reference list.
   * The list contents are of type {@link CurrencyDemo.Currency_CUR_customer1}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Currency CUR customer1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Currency CUR customer1</em>' containment reference list.
   * @see CurrencyDemo.CurrencyDemoPackage#getRootObject_Currency_CUR_customer1()
   * @model type="CurrencyDemo.Currency_CUR_customer1" containment="true"
   * @generated
   */
  List getCurrency_CUR_customer1();

} // RootObject
