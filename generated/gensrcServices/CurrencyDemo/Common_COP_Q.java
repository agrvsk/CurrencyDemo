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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Common COP Q</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link CurrencyDemo.Common_COP_Q#getCOP_Id <em>COP Id</em>}</li>
 *   <li>{@link CurrencyDemo.Common_COP_Q#getCOP_Description <em>COP Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see CurrencyDemo.Common_COP_QPackage#getCommon_COP_Q()
 * @model
 * @extends DataObject
 * @generated
 */
public interface Common_COP_Q extends DataObject
{
  /**
   * Returns the value of the '<em><b>COP Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>COP Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>COP Id</em>' attribute.
   * @see #setCOP_Id(Long)
   * @see CurrencyDemo.Common_COP_QPackage#getCommon_COP_Q_COP_Id()
   * @model
   * @generated
   */
  Long getCOP_Id();

  /**
   * Sets the value of the '{@link CurrencyDemo.Common_COP_Q#getCOP_Id <em>COP Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>COP Id</em>' attribute.
   * @see #getCOP_Id()
   * @generated
   */
  void setCOP_Id(Long value);

  /**
   * Returns the value of the '<em><b>COP Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>COP Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>COP Description</em>' attribute.
   * @see #setCOP_Description(String)
   * @see CurrencyDemo.Common_COP_QPackage#getCommon_COP_Q_COP_Description()
   * @model
   * @generated
   */
  String getCOP_Description();

  /**
   * Sets the value of the '{@link CurrencyDemo.Common_COP_Q#getCOP_Description <em>COP Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>COP Description</em>' attribute.
   * @see #getCOP_Description()
   * @generated
   */
  void setCOP_Description(String value);

} // Common_COP_Q
