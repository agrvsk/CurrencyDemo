package CurrencyDemo.Kryptering.XOR;

import java.io.*;
import java.net.*;
import java.rmi.server.*;

public class XorServerSocketFactory
    implements RMIServerSocketFactory {

    private byte pattern;
    private int  port;

    public XorServerSocketFactory(byte pattern) {
        System.out.println("XorServerSocketFactory(pattern="+pattern+")");
        this.pattern = pattern;
        this.port = -1;
    }
    public XorServerSocketFactory(byte pattern, int port ) {
        System.out.println("XorServerSocketFactory(pattern="+pattern+","+port+")");
        this.pattern = pattern;
        this.port = port;
    }

    
    public ServerSocket createServerSocket(int port)
        throws IOException
    {
    	try
    	{
    		if(this.port != -1) System.out.println("XorServerSocketFactory.createServerSocket(port="+this.port+")");
    		else 				System.out.println("XorServerSocketFactory.createServerSocket(port="+port+")");
    		
//            this.port = port;
            if(this.port != -1)
                return new XorServerSocket(this.port, pattern);
            else
            	return new XorServerSocket(port, pattern);
    	}
//    	catch(java.net.BindException be)
//    	{
//    		System.err.println(be.toString());
//    		XorServerSocket ss = new XorServerSocket(0, pattern);
//    		this.port = ss.getPort();
//            System.out.println("XorServerSocketFactory.createServerSocket(port="+this.port+")");
//    		return ss;
////    		return new XorServerSocket(0, pattern);
//    	}
    	catch(IOException th)
    	{
    		System.err.println(th.toString());
    		throw th;
    	}
    }
    
    public int hashCode() {
        System.out.println("XorServerSocketFactory.hashCode()");
        return (int) pattern;
    }

    public boolean equals(Object obj) {
        System.out.println("XorServerSocketFactory.equals(class)");
        return (getClass() == obj.getClass() &&
                pattern == ((XorServerSocketFactory) obj).pattern);
    }

//    public int getPort()
//    {
//    	System.out.println("XorServerSocketFactory.getPort() = "+this.port);
//    	return this.port;
//    }
}