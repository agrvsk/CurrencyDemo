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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see CurrencyDemo.CurrencyDemoPackage
 * @generated
 */
public interface CurrencyDemoFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CurrencyDemoFactory eINSTANCE = CurrencyDemo.impl.CurrencyDemoFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Root Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Root Object</em>'.
   * @generated
   */
  RootObject createRootObject();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  CurrencyDemoPackage getCurrencyDemoPackage();

} //CurrencyDemoFactory
