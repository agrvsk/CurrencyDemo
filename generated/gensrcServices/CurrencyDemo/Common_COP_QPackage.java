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
 * @see CurrencyDemo.Common_COP_QFactory
 * @model kind="package"
 * @generated
 */
public interface Common_COP_QPackage extends EPackage
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
  String eNS_URI = "http://CurrencyDemo.service/Common_COP_Q.ecore";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "CurrencyDemo.service.Common_COP_Q";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Common_COP_QPackage eINSTANCE = CurrencyDemo.impl.Common_COP_QPackageImpl.init();

  /**
   * The meta object id for the '{@link CurrencyDemo.impl.Common_COP_QImpl <em>Common COP Q</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see CurrencyDemo.impl.Common_COP_QImpl
   * @see CurrencyDemo.impl.Common_COP_QPackageImpl#getCommon_COP_Q()
   * @generated
   */
  int COMMON_COP_Q = 0;

  /**
   * The feature id for the '<em><b>COP Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMON_COP_Q__COP_ID = 0;

  /**
   * The feature id for the '<em><b>COP Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMON_COP_Q__COP_DESCRIPTION = 1;

  /**
   * The number of structural features of the '<em>Common COP Q</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMON_COP_Q_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link CurrencyDemo.Common_COP_Q <em>Common COP Q</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Common COP Q</em>'.
   * @see CurrencyDemo.Common_COP_Q
   * @generated
   */
  EClass getCommon_COP_Q();

  /**
   * Returns the meta object for the attribute '{@link CurrencyDemo.Common_COP_Q#getCOP_Id <em>COP Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>COP Id</em>'.
   * @see CurrencyDemo.Common_COP_Q#getCOP_Id()
   * @see #getCommon_COP_Q()
   * @generated
   */
  EAttribute getCommon_COP_Q_COP_Id();

  /**
   * Returns the meta object for the attribute '{@link CurrencyDemo.Common_COP_Q#getCOP_Description <em>COP Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>COP Description</em>'.
   * @see CurrencyDemo.Common_COP_Q#getCOP_Description()
   * @see #getCommon_COP_Q()
   * @generated
   */
  EAttribute getCommon_COP_Q_COP_Description();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Common_COP_QFactory getCommon_COP_QFactory();

} //Common_COP_QPackage
