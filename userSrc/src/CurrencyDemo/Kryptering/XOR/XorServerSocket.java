package CurrencyDemo.Kryptering.XOR;

import java.io.*;
import java.net.*;

class XorServerSocket extends ServerSocket {

    /*
     * The pattern used to "encrypt" and "decrypt" each byte sent
     * or received by the socket.
     */
    private final byte pattern;

    /*
     * Constructor for class XorServerSocket.
     */
    public XorServerSocket(int port, byte pattern) throws IOException 
    {
		super(port);
//      super(0);
        this.pattern = pattern;
        port = getLocalPort();
        System.out.println("XorServerSocket("+port+",pattern)");
    }

    /*
     * Creates a socket of type XorSocket and then calls
     * implAccept to wait for a client connection.
     */
    public Socket accept() throws IOException {
        Socket s = new XorClientSocket(pattern);
        System.out.println("XorServerSocket.accept()");
        implAccept(s);
        return s;
    }
    
    public int getPort()
    {
    	return getLocalPort();
    }
}