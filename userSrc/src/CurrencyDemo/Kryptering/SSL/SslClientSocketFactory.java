package CurrencyDemo.Kryptering.SSL;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.rmi.ssl.SslRMIServerSocketFactory;

import java.io.*;
import java.net.*;
import java.rmi.server.*;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.SecureRandom;

public class SslClientSocketFactory 
	extends SslRMIClientSocketFactory
    implements RMIClientSocketFactory 
{
//	static
//	{
//		SSLContext.setDefault(loadKeystores());
//	}
	
	private static final long serialVersionUID = 1L;
	public SslClientSocketFactory() 
    {
        super();
        System.out.println("SslClientSocketFactory()");
    }
    public Socket createSocket(String host, int port) throws IOException 
    {
        System.out.println("SslClientSocketFactory.createSocket("+host+","+port+")");
    	return super.createSocket(host, port);
	}

//    static SSLContext loadKeystores()
//    {
//        SSLContext SSLC = null;
//    	try
//    	{
//    		SecureRandom sr = new SecureRandom();
//    		sr.nextInt();
//    		
//            KeyStore serverKeyStore = KeyStore.getInstance("JKS");
//            FileInputStream server = new FileInputStream("C:/Versata/BRMS-2016/workbench/workspace_VSK_CurrencyDemo/CurrencyDemo/userSrc/src/CurrencyDemo/Kryptering/SSL/server.keystore");
//            String passphrase = "123456";
//            serverKeyStore.load(server, passphrase.toCharArray());
//            server.close();
//            System.out.println("Server keystore loaded.");
//            
//            KeyStore clientKeyStore = KeyStore.getInstance("JKS");
//            FileInputStream client = new FileInputStream("C:/Versata/BRMS-2016/workbench/workspace_VSK_CurrencyDemo/CurrencyDemo/userSrc/src/CurrencyDemo/Kryptering/SSL/client.keystore");
//            String password = "123456";
//            clientKeyStore.load(client, password.toCharArray());
//            client.close();
//            System.out.println("Client keystore loaded.");
//            
//            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
//            tmf.init(serverKeyStore);
//            System.out.println("TrustManagerFactory OK.");
//
//            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
//            kmf.init(clientKeyStore, password.toCharArray());
//            System.out.println("KeyManagerFactory OK.");
//
//            SSLC = SSLContext.getInstance("TLS");
//            SSLC.init(kmf.getKeyManagers(), tmf.getTrustManagers(), sr);
//            System.out.println("SSLContext OK");
//
//    	}
//    	catch(Throwable th)
//    	{
//    		System.err.println(th.toString());
//    	}
//    	return SSLC;
//    }

}