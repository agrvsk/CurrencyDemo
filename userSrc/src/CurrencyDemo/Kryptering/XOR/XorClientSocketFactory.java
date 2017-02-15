package CurrencyDemo.Kryptering.XOR;

import java.io.*;
import java.net.*;
import java.rmi.server.*;

public class XorClientSocketFactory
    implements RMIClientSocketFactory, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private byte pattern;
	private int port;

    public XorClientSocketFactory(byte pattern) {
        this.pattern = pattern;
        System.out.println("XorClientSocketFactory(pattern="+pattern+")");
    }
    public XorClientSocketFactory(byte pattern, int port) {
        this.pattern = pattern;
        this.port    = port;
        System.out.println("XorClientSocketFactory(pattern="+pattern+","+port+")");
    }
    
    public Socket createSocket(String host, int port)
        throws IOException
    {
        System.out.println("XorClientSocketFactory.createSocket(host="+host+",port="+port+")");
        return new XorClientSocket(host, this.port, pattern);
//        return new XorSocket(host, port, pattern);
    }
    
    public int hashCode() {
        System.out.println("XorClientSocketFactory.hashCode()");
        return (int) pattern;
    }

    public boolean equals(Object obj) 
    {
        System.out.println("XorClientSocketFactory.equals(class)");
        return (getClass() == obj.getClass() &&
                pattern == ((XorClientSocketFactory) obj).pattern);
    }
}