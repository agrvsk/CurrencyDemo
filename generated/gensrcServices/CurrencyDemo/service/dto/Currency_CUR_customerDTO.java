
/*
 * Copyright (c) Versata, Inc., 2000-2005. All Rights Reserved. THIS CODE IS
 * AUTOGENERATED BASED ON THE METAMODEL. DO NOT EDIT
 * 
 * Generated Fri Feb 10 12:04:37 CET 2017 by $Header: //depot/main/products/brms/eclipse/plugins/com.versata.tl.service/templates/SimpleDTO.javajet#1 $
 *
 */
package CurrencyDemo.service.dto;

/**
 * This generated code implements the simplest possible DTO for the Currency_CUR_customer
 * Query Model.
 * 
 * It is a very simple bean which (a) Axis is capable of introspecting at
 * runtime and (b) is easily broken out for use by the java client side as 
 * an alternative to the more powerful SDO data transfer objects and (c) can
 * easily be duplicated by non-java web service clients.
 * 
 */
public class Currency_CUR_customerDTO implements java.io.Serializable {
	/**
	 * Default empty constructor. Needed by Axis if we wish to use its javabean 
	 * serializer rather than a custom serializer.
	 */
	public Currency_CUR_customerDTO() {
	}

	
	
	private java.lang.String cUR_Client;
	
	public java.lang.String getCUR_Client() {
		return cUR_Client; 	
	}
	
	public void setCUR_Client(java.lang.String cUR_Client) {
		this.cUR_Client = cUR_Client;			
	}
	
	private java.lang.String cUR_CurrencyCode;
	
	public java.lang.String getCUR_CurrencyCode() {
		return cUR_CurrencyCode; 	
	}
	
	public void setCUR_CurrencyCode(java.lang.String cUR_CurrencyCode) {
		this.cUR_CurrencyCode = cUR_CurrencyCode;			
	}
	
	private java.math.BigDecimal cUR_ExchangeRate;
	
	public java.math.BigDecimal getCUR_ExchangeRate() {
		return cUR_ExchangeRate; 	
	}
	
	public void setCUR_ExchangeRate(java.math.BigDecimal cUR_ExchangeRate) {
		this.cUR_ExchangeRate = cUR_ExchangeRate;			
	}
	
	private Integer cUR_NumberOfOrders;
	
	public Integer getCUR_NumberOfOrders() {
		return cUR_NumberOfOrders; 	
	}
	
	public void setCUR_NumberOfOrders(Integer cUR_NumberOfOrders) {
		this.cUR_NumberOfOrders = cUR_NumberOfOrders;			
	}
	
	private java.math.BigDecimal cUR_OrderValueUSD;
	
	public java.math.BigDecimal getCUR_OrderValueUSD() {
		return cUR_OrderValueUSD; 	
	}
	
	public void setCUR_OrderValueUSD(java.math.BigDecimal cUR_OrderValueUSD) {
		this.cUR_OrderValueUSD = cUR_OrderValueUSD;			
	}
	
	private java.math.BigDecimal cUR_OrderAmountAverage;
	
	public java.math.BigDecimal getCUR_OrderAmountAverage() {
		return cUR_OrderAmountAverage; 	
	}
	
	public void setCUR_OrderAmountAverage(java.math.BigDecimal cUR_OrderAmountAverage) {
		this.cUR_OrderAmountAverage = cUR_OrderAmountAverage;			
	}
	
	private java.lang.String cUR_Image;
	
	public java.lang.String getCUR_Image() {
		return cUR_Image; 	
	}
	
	public void setCUR_Image(java.lang.String cUR_Image) {
		this.cUR_Image = cUR_Image;			
	}
	
	private java.lang.String cUR_Client_RelatedTo;
	
	public java.lang.String getCUR_Client_RelatedTo() {
		return cUR_Client_RelatedTo; 	
	}
	
	public void setCUR_Client_RelatedTo(java.lang.String cUR_Client_RelatedTo) {
		this.cUR_Client_RelatedTo = cUR_Client_RelatedTo;			
	}
	
	private java.lang.String cUR_CurrencyCode_RelatedTo;
	
	public java.lang.String getCUR_CurrencyCode_RelatedTo() {
		return cUR_CurrencyCode_RelatedTo; 	
	}
	
	public void setCUR_CurrencyCode_RelatedTo(java.lang.String cUR_CurrencyCode_RelatedTo) {
		this.cUR_CurrencyCode_RelatedTo = cUR_CurrencyCode_RelatedTo;			
	}

	public String toString() {
		StringBuffer sb = new StringBuffer("Currency_CUR_customerDTO: ");
		sb.append(" cUR_Client : ");
		sb.append(getCUR_Client());
		sb.append(" cUR_CurrencyCode : ");
		sb.append(getCUR_CurrencyCode());
		sb.append(" cUR_ExchangeRate : ");
		sb.append(getCUR_ExchangeRate());
		sb.append(" cUR_NumberOfOrders : ");
		sb.append(getCUR_NumberOfOrders());
		sb.append(" cUR_OrderValueUSD : ");
		sb.append(getCUR_OrderValueUSD());
		sb.append(" cUR_OrderAmountAverage : ");
		sb.append(getCUR_OrderAmountAverage());
		sb.append(" cUR_Image : ");
		sb.append(getCUR_Image());
		sb.append(" cUR_Client_RelatedTo : ");
		sb.append(getCUR_Client_RelatedTo());
		sb.append(" cUR_CurrencyCode_RelatedTo : ");
		sb.append(getCUR_CurrencyCode_RelatedTo());
		
		return sb.toString();
	}
}
