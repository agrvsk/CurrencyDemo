/*
 * Generated by XDoclet - Do not edit!
 */
package CurrencyDemo.service;

import com.versata.tl.common.ejb.VLSRemoteObject;

/**
 * Home interface for Common_COP_S.
 * @wtp generated
 */
public interface Common_COP_SHome
   extends javax.ejb.EJBHome
{
	   public static final String COMP_NAME="java:comp/env/ejb/Common_COP_S";
	   //public static final String JNDI_NAME="CurrencyDemo/service/Common_COP_S";
	   public static final String JNDI_NAME="ejb:CurrencyDemoEAR/CurrencyDemoEJB/Common_COP_S!CurrencyDemo.service.Common_COP_SHome";
	  
   public CurrencyDemo.service.Common_COP_S create()
      throws javax.ejb.CreateException,java.rmi.RemoteException;

}
