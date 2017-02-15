package CurrencyDemo.Kryptering;

import CurrencyDemo.Kryptering.XOR.XorClientSocketFactory;
import CurrencyDemo.Kryptering.XOR.XorServerSocketFactory;

import CurrencyDemo.Kryptering.Vsk_tie_VSORBSecuritySession;
import CurrencyDemo.Kryptering.Vsk_tie_VSORBResultSet;

import com.google.common.collect.MapMaker;
import com.versata.tl.api.logging.VersataLogger;
import com.versata.tl.common.*;
import com.versata.tl.common.text.RuntimeMsgCode;
import com.versata.tl.common.transaction.Current;
import com.versata.tl.common.transaction.SubtransactionsUnavailableException;
import com.versata.tl.common.util.Parameter;
import com.versata.tl.common.util.SearchRequest;
import com.versata.tl.common.vlsobject.*;
import com.versata.tl.vfc.dataaccess.XDAConnector;
import com.versata.tl.vfc.pls.common.XDAPLSConnectorBase;
import com.versata.tl.vfc.services.ClientUtils;
import com.versata.tl.vls.dataaccess.VSORBResultSetImpl;
import com.versata.tl.vls.ejb.EJBFrameworkFactoryImpl;
import com.versata.tl.vls.service.FrameworkFactory;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.rmi.*;
//import java.rmi.registry.LocateRegistry;
//import java.rmi.registry.Registry;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.Vector;

import javax.net.ssl.SSLContext;
import javax.rmi.PortableRemoteObject;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.rmi.ssl.SslRMIServerSocketFactory;
import CurrencyDemo.Kryptering.SSL.SslClientSocketFactory;
import CurrencyDemo.Kryptering.SSL.SslServerSocketFactory;

/*
 * Har bytt ut alla förekomster av 
 * _tie_VSORBSecuritySession mot Vsk_tie_VSORBSecuritySession	innehåller kod för transaktion som startas på klienten.
 * _tie_VSORBResultSet		 mot Vsk_tie_VSORBResultSet			kan ändras tillbaka - används endast för debug
 * 
 * Se denna metoden .makeVLSResultSet() i denna klass, samt
 * metoden .begin() i  Vsk_tie_VSORBSecuritySession
 */

public class EJBFrameworkFactoryVSKImpl extends EJBFrameworkFactoryImpl    
    implements FrameworkFactory 
    
    /*QWERTY*/
{
	int port;

	public EJBFrameworkFactoryVSKImpl()
    {
		super();
		
    	System.out.println("EJBFrameworkFactoryVSKImpl()");
    	this.port = 10002;		//bör parameterstyras från ReomoteObject.properties?
    	
    	// Port 10001 dvs unicastExportPort angiven i ReomoteObject.properties ( properties-mappen )
    	// Låses vid inloggning från klienten. Försöker vi använda den får vi portkonflikt.
    	// (Tips:  Portkonflikt kan ge märkliga fel - bla. klagas det på icke serialiseringsbara objekt... )
    	
    	//För SSL så måste vi komma åt serverns truststore/keystore på något sätt...
    	System.setProperty("javax.net.ssl.trustStore","C:/Versata/BRMS-2016/workbench/workspace_VSK_CurrencyDemo/CurrencyDemo/userSrc/src/CurrencyDemo/Kryptering/SSL/server.keystore");
    	System.setProperty("javax.net.ssl.trustStorePassword","123456");
    	System.setProperty("javax.net.ssl.keyStore","C:/Versata/BRMS-2016/workbench/workspace_VSK_CurrencyDemo/CurrencyDemo/userSrc/src/CurrencyDemo/Kryptering/SSL/server.keystore");
    	System.setProperty("javax.net.ssl.keyStorePassword","123456");

    }
    
	
    public VSORBAppServer makeVLSServer(String name, VSORBAppServerOperations appServer)
    {
    	System.out.println("EJBFrameworkFactoryVSKImpl.makeVLSServer("+name+",VSORBAppServerOperations="+appServer.getName()+")");
        return super.makeVLSServer(name, appServer);
    }

    public static VSORBSessionOperations getSessionDelegate(int key)
    {
    	System.out.println("EJBFrameworkFactoryVSKImpl.getSessionDelegate("+key+")");
    	return EJBFrameworkFactoryImpl.getSessionDelegate(key);
    }

    public static void removeSessionDelegate(int key)
    {
    	System.out.println("EJBFrameworkFactoryVSKImpl.removeSessionDelegate("+key+")");
    	EJBFrameworkFactoryImpl.removeSessionDelegate(key);
    }

    @SuppressWarnings("deprecation")
    public static VSORBResultSetOperations getResultSetDelegate(int key)
    {
    	System.out.println("EJBFrameworkFactoryVSKImpl.getResultSetDelegate("+key+")");
    	return EJBFrameworkFactoryImpl.getResultSetDelegate(key);
    }

    public static void removeResultSetDelegate(int key)
    {
    	System.out.println("EJBFrameworkFactoryVSKImpl.removeResultSetDelegate("+key+")");
    	EJBFrameworkFactoryImpl.removeResultSetDelegate(key);
    }

    public VSORBSession makeVLSSession(VSORBSessionOperations blsSession)
    {
    	System.out.println("EJBFrameworkFactoryVSKImpl.makeVLSSession(VSORBSessionOperations)");
    	return super.makeVLSSession(blsSession);
    }

    public VSORBSession makeVLSSessionWrapper(VSORBSessionOperations blsSession)
    {
    	System.out.println("EJBFrameworkFactoryVSKImpl.makeVLSSessionWrapper(VSORBSessionOperations)");
        return new Vsk_tie_VSORBSecuritySession((VSORBSecuritySessionOperations)blsSession, this.port);

// XXX VI ÖVERRIDER DENNA METOD FÖR ATT RETURNERA VÅR SUBKLASS.       
//    	return super.makeVLSSessionWrapper(blsSession);
//    	innehåller: new _tie_VSORBSecuritySession((VSORBSecuritySessionOperations)blsSession);
    }

    public VSORBSecuritySession makeVLSSecuritySessionWrapper(VSORBSecuritySessionOperations blsSecuritySession)
    {
    	System.out.println("EJBFrameworkFactoryVSKImpl.makeVLSSecuritySessionWrapper(VSORBSecuritySessionOperations)");
    	return super.makeVLSSecuritySessionWrapper(blsSecuritySession);
    }

    /**
     * Inloggning : Java klient 
     * **/
    public VSORBSecuritySession makeVLSSecuritySession(VSORBSecuritySessionOperations blsSecuritySession)
    {
    	System.out.println("EJBFrameworkFactoryVSKImpl.makeVLSSecuritySession(VSORBSecuritySessionOperations) - INLOGGNING FRÅN JAVA! ");

// XXX VI ÖVERRIDER DENNA METOD FÖR ATT RETURNERA VÅR SUBKLASS.       
    	VSORBSecuritySession remoteReference = new Vsk_tie_VSORBSecuritySession(blsSecuritySession, this.port);
//    	System.out.println("...remoteReference=new Vsk_tie_VSORBSecuritySession(VSORBSecuritySessionOperations)... ");
    	
        try
        {
//DETTA FINNS I VLSContextBean.getRemoteDelegate        	
//          VSORBSecuritySession obj = ((VSORBSessionImpl)_flddelegate).getRemoteReferenceForSecuritySession();
//          VSORBSecuritySession tmp = (VSORBSecuritySession)UnicastRemoteObject.exportObject(obj, RemoteObjectProperties.getInstance().getUnicastExportPort());

//        	UnicastRemoteObject.unexportObject(remoteReference, true);
        	
//			Inloggning anropar ett RemoteObjekt. Se mitt dokument om SSL och Remota objekt.        	
//         	byte pattern = (byte) 0xAC;
//          RMIServerSocketFactory ssf = new XorServerSocketFactory(pattern,this.port);
//          RMIClientSocketFactory csf = new XorClientSocketFactory(pattern,this.port);
//          UnicastRemoteObject.exportObject(remoteReference, RemoteObjectProperties.getInstance().getUnicastExportPort(), csf, ssf);	
//      	System.out.println("...Session exporterad med  UnicastRemoteObject & XorSocket...");
////    	GER ALREADY EXPORTED det är VSSession.connect som åstadkommer detta i VLSContextBean!!!
       	
        	PortableRemoteObject.exportObject(remoteReference);
        	System.out.println("...Session exporterad med  PortableRemoteObject..");
        }
        catch(RemoteException e)
        {
        	System.out.println(e.toString());
        }
        return remoteReference;
    }

    public VSORBResultSet makeResultSetWrapper(VSORBResultSetOperations blsResultSet)
    {
// XXX VI ÖVERRIDER DENNA METOD FÖR ATT RETURNERA VÅR SUBKLASS.       
// Denna motod anropas ofta!!!  
    	
    	System.out.print("EJBFrameworkFactoryVSKImpl.makeResultSetWrapper(blsResultSet)"+blsResultSet.getClass().getName());
    	if(blsResultSet instanceof VSORBResultSetImpl)
    	{
    		String s= null;
    		if(((VSORBResultSetImpl)blsResultSet). sr != null)
    		{
        		Parameter p = null;
        		Vector v =null;
    			SearchRequest sr1 = ((VSORBResultSetImpl)blsResultSet). sr;
    			if(sr1 != null) v = sr1.getParamList();     			
    			if(v != null 
    			&& v.size()>0) 	p = (Parameter)v.get(0);
    			if(p != null)	System.out.print(" ( "+p.objName +" = "+ p.value+" ) ");
    		}
//    		if(((VSORBResultSetImpl)blsResultSet). metaQuery != null)
//    		{
//    		System.out.println(   ((VSORBResultSetImpl)blsResultSet). metaQuery.getChildMostTableName() ) ;
//    		System.out.println(   ((VSORBResultSetImpl)blsResultSet). metaQuery.getName() ) ;
//    		System.out.println(   ((VSORBResultSetImpl)blsResultSet). sr.parameterList.toString() ) ;
//    		}
    	}
		System.out.print("\n");
		
//    	return new    _tie_VSORBResultSet(blsResultSet);
    	
    	
    	VSORBResultSet stub = null;
    	VSORBResultSet resultSet = new Vsk_tie_VSORBResultSet(blsResultSet);
//        try
//        {
////        	1. Factoryklasser i javax.rmi.ssl.* (det funkar att använda dem)
////          RMIServerSocketFactory ssf = new SslRMIServerSocketFactory();
////          RMIClientSocketFactory csf = new SslRMIClientSocketFactory();
//            
////        	2. Subklass av ovanstående med Output som visar att SSL kanaler används
////            RMIServerSocketFactory ssf = new SslServerSocketFactory();	
////            RMIClientSocketFactory csf = new SslClientSocketFactory();	
//
////			3. Factoryklasser för att kryptera strömmarna med Xor.            
//        	byte pattern = (byte) 0xAC;
//            RMIServerSocketFactory ssf = new XorServerSocketFactory(pattern, this.port);
//            RMIClientSocketFactory csf = new XorClientSocketFactory(pattern, this.port);
//            
//            stub = (VSORBResultSet)
//            UnicastRemoteObject.exportObject(resultSet, this.port, csf, ssf);  //eftersom Unicastporten binds vid inloggningen...
////          UnicastRemoteObject.exportObject(resultSet, RemoteObjectProperties.getInstance().getUnicastExportPort(), csf, ssf);	
//        	System.out.println("...resultset exporterat med UnicastRemoteObject & SSL eller Xor - Sockets..");
//       	
//        	PortableRemoteObject.exportObject(resultSet);
//        	System.out.println("...resultset exporterat med PortableRemoteObject..");
//        	
//        }
//        catch(RemoteException e)
//        {
//        	System.err.println(e.toString());
//        }

//    	return (stub != null) ? stub : resultSet;
    	return resultSet;

//    	return super.makeResultSetWrapper(blsResultSet);
    }
    
    /**
     * krypterar datatrafik till från Dataobjekten
     * **/
    public VSORBResultSet makeVLSResultSet(VSORBResultSetOperations blsResultSet)
    {
    	System.out.println("EJBFrameworkFactoryVSKImpl.makeVLSResultSet(VSORBResultSetOperations)***");
// XXX VI ÖVERRIDER DENNA METOD FÖR SÄKRA Input/Output strömmarna mellan Klient och Server.
    	
    	VSORBResultSet stub = null;
    	VSORBResultSet resultSet = new Vsk_tie_VSORBResultSet(blsResultSet);
//    	VSORBResultSet resultSet = new    _tie_VSORBResultSet(blsResultSet); << I SUPERKLASSEN
    	System.out.println("...remote resultSet = new Vsk_tie_VSORBResultSet(VSORBResultSetOperations)");
        
        try
        {
//        	1. Factoryklasser i javax.rmi.ssl.* (det funkar att använda dem)
//          RMIServerSocketFactory ssf = new SslRMIServerSocketFactory();
//          RMIClientSocketFactory csf = new SslRMIClientSocketFactory();
            
//        	2. Subklass av ovanstående med Output som visar att SSL kanaler används
            RMIServerSocketFactory ssf = new SslServerSocketFactory();	
            RMIClientSocketFactory csf = new SslClientSocketFactory();	

//			3. Factoryklasser för att kryptera strömmarna med Xor.            
//        	byte pattern = (byte) 0xAC;
//          RMIServerSocketFactory ssf = new XorServerSocketFactory(pattern, this.port);
//          RMIClientSocketFactory csf = new XorClientSocketFactory(pattern, this.port);
            
            stub = (VSORBResultSet)
            UnicastRemoteObject.exportObject(resultSet, this.port, csf, ssf);  //eftersom Unicastporten binds vid inloggningen...
//          UnicastRemoteObject.exportObject(resultSet, RemoteObjectProperties.getInstance().getUnicastExportPort(), csf, ssf);	
        	System.out.println("...resultset exporterat med UnicastRemoteObject & SSL eller Xor - Sockets..");
       	
        	PortableRemoteObject.exportObject(resultSet);
        	System.out.println("...resultset exporterat med PortableRemoteObject..");
        	
        }
        catch(RemoteException e)
        {
        	System.err.println(e.toString());
        }

        return (stub != null) ? stub : resultSet;
    }

    public java.lang.Object makeRemoteReference(java.lang.Object obj)
        throws Exception
    {
    	System.out.println("EJBFrameworkFactoryVSKImpl.makeRemoteReference(java.lang.Object)");
    	obj=super.makeRemoteReference(obj);	
        return obj;
    }

    public void releaseResultSetWrapper(java.lang.Object obj1)
    {
//Anropas ofta!!!    	
//    	System.out.println("EJBFrameworkFactoryVSKImpl.releaseResultSetWrapper(obj)");
    	super.releaseResultSetWrapper(obj1);
   }

    public void releaseRemoteReference(java.lang.Object obj)
    {
       	System.out.println("EJBFrameworkFactoryVSKImpl.releaseRemoteReference(obj)");
       	super.releaseRemoteReference(obj);
    }

    public void registerRemoteReference(java.lang.Object obj)
    {
    	System.out.println("EJBFrameworkFactoryVSKImpl.registerRemoteReference(java.lang.Object)");
      	super.registerRemoteReference(obj);
    }


    @SuppressWarnings("deprecation")
    public void validateConnection(VSORBAppServerOperations vsorbappserveroperations)
    {
      	System.out.println("EJBFrameworkFactoryVSKImpl.validateConnection(vsorbappserveroperations)");
      	super.validateConnection(vsorbappserveroperations);
    }

    public VSORBResultSetOperations getResultSetDelegate(VSORBResultSet rs)
    {
    	if(rs == null)	return null; 
      	//Anropas ofta!!!
    	System.out.println("EJBFrameworkFactoryVSKImpl.getResultSetDelegate(rs="+rs.getClass().getName()+")");

// XXX VI ÖVERRIDER DENNA METOD FÖR ATT RETURNERA VÅR SUBKLASS
//      return ((   _tie_VSORBResultSet)rs)._delegate();
    	return ((Vsk_tie_VSORBResultSet)rs)._delegate();
//      return super.getResultSetDelegate(rs);
    }

    public VSORBSecuritySessionOperations getVLSSecuritySessionDelegate(VSORBSecuritySession session)
    {
      	System.out.println("EJBFrameworkFactoryVSKImpl.getVLSSecuritySessionDelegate(VSORBSecuritySession)");
        Vsk_tie_VSORBSecuritySession sessionOp = (Vsk_tie_VSORBSecuritySession)session;
        return sessionOp == null ? null : sessionOp._delegate();
// XXX VI ÖVERRIDER DENNA METOD FÖR ATT RETURNERA VÅR SUBKLASS
    }



    @SuppressWarnings("deprecation")
	public VSORBSessionOperations getVLSSessionDelegate(VSORBSession session)
    {
      	System.out.println("EJBFrameworkFactoryVSKImpl.getVLSSessionDelegate(VSORBSession)");
        return super.getVLSSessionDelegate(session);
    }

    
    
    
//    private void Registrykod()
//    {	Används ej då vi inte vill använda dynamiska portar pga. brandväggarna!
//    	try
//    	{
//        	System.out.println("LocateRegistry.createRegistry(2002)");
//    		LocateRegistry.createRegistry(2002);	//PORT
//    		System.out.println("LocateRegistry.getRegistry(2002)");
//    		Registry registry = LocateRegistry.getRegistry(2002);
//    		if(registry != null)
//    		{
//    			String[] regs = registry.list();
//    			for(int i=0; i<regs.length ; i++)
//    			{
//    				System.out.println("\t"+regs[i]);
//    			}
//		//		registry.rebind("Current", stub);
//  	//		System.out.println("Current bound in registry");
//    		}
//    	}
//    	catch(Throwable th)
//    	{
//    		System.out.println();
//    	}
//    }

    /**
     * Checks to see if a specific port is available.
     * @param port the port to check for availability
     */
//	public static final int MIN_PORT_NUMBER = 1;
//	public static final int MAX_PORT_NUMBER = 49151;
//	public static boolean available(int port) 
//    {
//    	
//        if (port < MIN_PORT_NUMBER || port > MAX_PORT_NUMBER) {
//            throw new IllegalArgumentException("Invalid start port: " + port);
//        }
//
//        ServerSocket ss = null;
//        DatagramSocket ds = null;
//        try {
//            ss = new ServerSocket(port);
//            ss.setReuseAddress(true);
//            ds = new DatagramSocket(port);
//            ds.setReuseAddress(true);
//            return true;
//        } catch (IOException e) {
//        } finally {
//            if (ds != null) {
//                ds.close();
//            }
//
//            if (ss != null) {
//                try {
//                    ss.close();
//                } catch (IOException e) {
//                    /* should not be thrown */
//                }
//            }
//        }
//
//        return false;
//    }


    
}