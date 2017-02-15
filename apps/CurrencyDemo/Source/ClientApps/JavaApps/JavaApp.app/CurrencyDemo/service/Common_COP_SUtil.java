/*
 * Generated file - Do not edit!
 */
package CurrencyDemo.service;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingEnumeration;

import CurrencyDemo.Kryptering.XOR.XorClientSocketFactory;
import CurrencyDemo.Kryptering.XOR.XorServerSocketFactory;
/**
 * Utility class for Common_COP_S.
 * @wtp generated
 */
public class Common_COP_SUtil
{
   /** Cached remote home (EJBHome). Uses lazy loading to obtain its value (loaded by getHome() methods). */
   private static CurrencyDemo.service.Common_COP_SHome cachedRemoteHome = null;
   /** Cached local home (EJBLocalHome). Uses lazy loading to obtain its value (loaded by getLocalHome() methods). */
   private static CurrencyDemo.service.Common_COP_SLocalHome cachedLocalHome = null;

   private static Object lookupHome(java.util.Hashtable environment, String jndiName, Class narrowTo) throws javax.naming.NamingException {
      // Obtain initial context
      javax.naming.InitialContext initialContext = new javax.naming.InitialContext(environment);
      try {
         Object objRef = initialContext.lookup(jndiName);
         ////////////
//	        try 
//	        {
//	        	System.out.println("..."+ initialContext.getNameInNamespace() );
//	        	NamingEnumeration ne = initialContext.list(jndiName);
//	        	while(ne != null && ne.hasMoreElements())
//	        	{
//	        		System.out.println("...listing:"+ ne.nextElement().getClass().getName()	);	
//	        	}
//	        	NamingEnumeration bi = initialContext.listBindings(jndiName);
//	        	while(bi != null && bi.hasMoreElements())
//	        	{
//	        		System.out.println("...listing:"+  bi.nextElement().getClass().getName());	
//	        		
//	        	}

	        	System.out.println("Common_COP_SUtil.lookUpHome objRef=:"+objRef.getClass().getName());
//		    	byte pattern = (byte) 0xAC;
//		        RMIServerSocketFactory ssf = new XorServerSocketFactory(pattern,10002);
//		        RMIClientSocketFactory csf = new XorClientSocketFactory(pattern,10002);
//				Remote r = UnicastRemoteObject.exportObject((Remote)objRef , 10002 , csf, ssf);
//				System.out.println("...objekt exporterat med UnicastRemoteObject & XorSockets..Remote="+r.getClass().getName());
//			} 
//	        catch (RemoteException e) 
//	        {
//	        	e.printStackTrace();
//	        }
         ////////////
         // only narrow if necessary
         if (java.rmi.Remote.class.isAssignableFrom(narrowTo))
         {
        	 System.out.println("...javax.rmi.PortableRemoteObject.narrow(objRef, narrowTo)");
        	 Object o = javax.rmi.PortableRemoteObject.narrow(objRef, narrowTo);
			 System.out.println("...objekt exporterat med PortableRemoteObject Remote="+o.getClass().getName());
        	 return o;
//        	 return javax.rmi.PortableRemoteObject.narrow(objRef, narrowTo);
         }
         else
         {   
        	 System.out.println("...returns objRef");
        	 return objRef;
         }
      } finally {
         initialContext.close();
      }
   }

   // Home interface lookup methods

   /**
    * Obtain remote home interface from default initial context
    * @return Home interface for Common_COP_S. Lookup using JNDI_NAME
    */
   public static CurrencyDemo.service.Common_COP_SHome getHome() throws javax.naming.NamingException
   {
      if (cachedRemoteHome == null) {
           // cachedRemoteHome = (CurrencyDemo.service.Common_COP_SHome) lookupHome(null, CurrencyDemo.service.Common_COP_SHome.JNDI_NAME, CurrencyDemo.service.Common_COP_SHome.class);
      
    	  ////////////////////
    	  System.out.println("Common_COP_SUtil.getHome()"+Context.URL_PKG_PREFIXES+"=org.jboss.ejb.client.naming");
    	  System.out.println("Common_COP_SUtil.getHome()"+CurrencyDemo.service.Common_COP_SHome.JNDI_NAME);
    	  ////////////////////
    	  Properties p = new Properties();
    	  p.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            cachedRemoteHome = (CurrencyDemo.service.Common_COP_SHome) lookupHome(p, CurrencyDemo.service.Common_COP_SHome.JNDI_NAME, CurrencyDemo.service.Common_COP_SHome.class);
 
      
      }
      return cachedRemoteHome;
   }

   /**
    * Obtain remote home interface from parameterised initial context
    * @param environment Parameters to use for creating initial context
    * @return Home interface for Common_COP_S. Lookup using JNDI_NAME
    */
   public static CurrencyDemo.service.Common_COP_SHome getHome( java.util.Hashtable environment ) throws javax.naming.NamingException
   {
       return (CurrencyDemo.service.Common_COP_SHome) lookupHome(environment, CurrencyDemo.service.Common_COP_SHome.JNDI_NAME, CurrencyDemo.service.Common_COP_SHome.class);
   }

   /**
    * Obtain local home interface from default initial context
    * @return Local home interface for Common_COP_S. Lookup using JNDI_NAME
    */
   public static CurrencyDemo.service.Common_COP_SLocalHome getLocalHome() throws javax.naming.NamingException
   {
      if (cachedLocalHome == null) {
            cachedLocalHome = (CurrencyDemo.service.Common_COP_SLocalHome) lookupHome(null, CurrencyDemo.service.Common_COP_SLocalHome.JNDI_NAME, CurrencyDemo.service.Common_COP_SLocalHome.class);
      }
      return cachedLocalHome;
   }

   /** Cached per JVM server IP. */
   private static String hexServerIP = null;

   // initialise the secure random instance
   private static final java.security.SecureRandom seeder = new java.security.SecureRandom();

   /**
    * A 32 byte GUID generator (Globally Unique ID). These artificial keys SHOULD <strong>NOT </strong> be seen by the user,
    * not even touched by the DBA but with very rare exceptions, just manipulated by the database and the programs.
    *
    * Usage: Add an id field (type java.lang.String) to your EJB, and add setId(XXXUtil.generateGUID(this)); to the ejbCreate method.
    */
   public static final String generateGUID(Object o) {
       StringBuffer tmpBuffer = new StringBuffer(16);
       if (hexServerIP == null) {
           java.net.InetAddress localInetAddress = null;
           try {
               // get the inet address

               localInetAddress = java.net.InetAddress.getLocalHost();
           }
           catch (java.net.UnknownHostException uhe) {
               System.err.println("Common_COP_SUtil: Could not get the local IP address using InetAddress.getLocalHost()!");
               // todo: find better way to get around this...
               uhe.printStackTrace();
               return null;
           }
           byte serverIP[] = localInetAddress.getAddress();
           hexServerIP = hexFormat(getInt(serverIP), 8);
       }

       String hashcode = hexFormat(System.identityHashCode(o), 8);
       tmpBuffer.append(hexServerIP);
       tmpBuffer.append(hashcode);

       long timeNow      = System.currentTimeMillis();
       int timeLow       = (int)timeNow & 0xFFFFFFFF;
       int node          = seeder.nextInt();

       StringBuffer guid = new StringBuffer(32);
       guid.append(hexFormat(timeLow, 8));
       guid.append(tmpBuffer.toString());
       guid.append(hexFormat(node, 8));
       return guid.toString();
   }

   private static int getInt(byte bytes[]) {
       int i = 0;
       int j = 24;
       for (int k = 0; j >= 0; k++) {
           int l = bytes[k] & 0xff;
           i += l << j;
           j -= 8;
       }
       return i;
   }

   private static String hexFormat(int i, int j) {
       String s = Integer.toHexString(i);
       return padHex(s, j) + s;
   }

   private static String padHex(String s, int i) {
       StringBuffer tmpBuffer = new StringBuffer();
       if (s.length() < i) {
           for (int j = 0; j < i - s.length(); j++) {
               tmpBuffer.append('0');
           }
       }
       return tmpBuffer.toString();
   }

}

