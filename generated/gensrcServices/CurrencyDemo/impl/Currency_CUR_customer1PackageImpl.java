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
package CurrencyDemo.impl;

import CurrencyDemo.Currency_CUR_customer1;
import CurrencyDemo.Currency_CUR_customer1Factory;
import CurrencyDemo.Currency_CUR_customer1Package;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Currency_CUR_customer1PackageImpl extends EPackageImpl implements Currency_CUR_customer1Package
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass currency_CUR_customer1EClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see CurrencyDemo.Currency_CUR_customer1Package#eNS_URI
   * @see #init()
   * @generated
   */
  private Currency_CUR_customer1PackageImpl()
  {
    super(eNS_URI, Currency_CUR_customer1Factory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this
   * model, and for any others upon which it depends.  Simple
   * dependencies are satisfied by calling this method on all
   * dependent packages before doing anything else.  This method drives
   * initialization for interdependent packages directly, in parallel
   * with this package, itself.
   * <p>Of this package and its interdependencies, all packages which
   * have not yet been registered by their URI values are first created
   * and registered.  The packages are then initialized in two steps:
   * meta-model objects for all of the packages are created before any
   * are initialized, since one package's meta-model objects may refer to
   * those of another.
   * <p>Invocation of this method will not affect any packages that have
   * already been initialized.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static Currency_CUR_customer1Package init()
  {
    if (isInited) return (Currency_CUR_customer1Package)EPackage.Registry.INSTANCE.getEPackage(Currency_CUR_customer1Package.eNS_URI);

    // Obtain or create and register package
    Currency_CUR_customer1PackageImpl theCurrency_CUR_customer1Package = (Currency_CUR_customer1PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof Currency_CUR_customer1PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new Currency_CUR_customer1PackageImpl());
    
  
    // Create package meta-data objects
    
    theCurrency_CUR_customer1Package.createPackageContents();
    
    
    

    isInited = true;

  // Initialize created meta-data
    theCurrency_CUR_customer1Package.initializePackageContents();
    // Mark meta-data to indicate it can't be changed
    theCurrency_CUR_customer1Package.freeze();

    return theCurrency_CUR_customer1Package;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCurrency_CUR_customer1()
  {
    return currency_CUR_customer1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCurrency_CUR_customer1_CUR_Client()
  {
    return (EAttribute)currency_CUR_customer1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCurrency_CUR_customer1_CUR_CurrencyCode()
  {
    return (EAttribute)currency_CUR_customer1EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCurrency_CUR_customer1_CUR_ExchangeRate()
  {
    return (EAttribute)currency_CUR_customer1EClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCurrency_CUR_customer1_CUR_NumberOfOrders()
  {
    return (EAttribute)currency_CUR_customer1EClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCurrency_CUR_customer1_CUR_OrderValueUSD()
  {
    return (EAttribute)currency_CUR_customer1EClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCurrency_CUR_customer1_CUR_OrderAmountAverage()
  {
    return (EAttribute)currency_CUR_customer1EClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCurrency_CUR_customer1_CUR_Image()
  {
    return (EAttribute)currency_CUR_customer1EClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCurrency_CUR_customer1_CUR_Client_RelatedTo()
  {
    return (EAttribute)currency_CUR_customer1EClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCurrency_CUR_customer1_CUR_CurrencyCode_RelatedTo()
  {
    return (EAttribute)currency_CUR_customer1EClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Currency_CUR_customer1Factory getCurrency_CUR_customer1Factory()
  {
    return (Currency_CUR_customer1Factory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    currency_CUR_customer1EClass = createEClass(CURRENCY_CUR_CUSTOMER1);
    createEAttribute(currency_CUR_customer1EClass, CURRENCY_CUR_CUSTOMER1__CUR_CLIENT);
    createEAttribute(currency_CUR_customer1EClass, CURRENCY_CUR_CUSTOMER1__CUR_CURRENCY_CODE);
    createEAttribute(currency_CUR_customer1EClass, CURRENCY_CUR_CUSTOMER1__CUR_EXCHANGE_RATE);
    createEAttribute(currency_CUR_customer1EClass, CURRENCY_CUR_CUSTOMER1__CUR_NUMBER_OF_ORDERS);
    createEAttribute(currency_CUR_customer1EClass, CURRENCY_CUR_CUSTOMER1__CUR_ORDER_VALUE_USD);
    createEAttribute(currency_CUR_customer1EClass, CURRENCY_CUR_CUSTOMER1__CUR_ORDER_AMOUNT_AVERAGE);
    createEAttribute(currency_CUR_customer1EClass, CURRENCY_CUR_CUSTOMER1__CUR_IMAGE);
    createEAttribute(currency_CUR_customer1EClass, CURRENCY_CUR_CUSTOMER1__CUR_CLIENT_RELATED_TO);
    createEAttribute(currency_CUR_customer1EClass, CURRENCY_CUR_CUSTOMER1__CUR_CURRENCY_CODE_RELATED_TO);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(currency_CUR_customer1EClass, Currency_CUR_customer1.class, "Currency_CUR_customer1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCurrency_CUR_customer1_CUR_Client(), ecorePackage.getEString(), "CUR_Client", null, 0, 1, Currency_CUR_customer1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCurrency_CUR_customer1_CUR_CurrencyCode(), ecorePackage.getEString(), "CUR_CurrencyCode", null, 0, 1, Currency_CUR_customer1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCurrency_CUR_customer1_CUR_ExchangeRate(), ecorePackage.getEBigDecimal(), "CUR_ExchangeRate", null, 0, 1, Currency_CUR_customer1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCurrency_CUR_customer1_CUR_NumberOfOrders(), ecorePackage.getEIntegerObject(), "CUR_NumberOfOrders", null, 0, 1, Currency_CUR_customer1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCurrency_CUR_customer1_CUR_OrderValueUSD(), ecorePackage.getEBigDecimal(), "CUR_OrderValueUSD", null, 0, 1, Currency_CUR_customer1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCurrency_CUR_customer1_CUR_OrderAmountAverage(), ecorePackage.getEBigDecimal(), "CUR_OrderAmountAverage", null, 0, 1, Currency_CUR_customer1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCurrency_CUR_customer1_CUR_Image(), ecorePackage.getEString(), "CUR_Image", null, 0, 1, Currency_CUR_customer1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCurrency_CUR_customer1_CUR_Client_RelatedTo(), ecorePackage.getEString(), "CUR_Client_RelatedTo", null, 0, 1, Currency_CUR_customer1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCurrency_CUR_customer1_CUR_CurrencyCode_RelatedTo(), ecorePackage.getEString(), "CUR_CurrencyCode_RelatedTo", null, 0, 1, Currency_CUR_customer1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //Currency_CUR_customer1PackageImpl
