package CurrencyDemo.Kryptering.XOR;

import java.io.*;
import java.net.*;

class XorClientSocket extends Socket {

    /*
     * The pattern used to "encrypt" and "decrypt" each byte sent
     * or received by the socket.
     */
    private final byte pattern;

    /* The InputStream used by the socket. */
    private InputStream in = null;

    /* The OutputStream used by the socket */
    private OutputStream out = null;

    /*
     * Constructor for class XorClientSocket.
     */
    public XorClientSocket(byte pattern)
        throws IOException
    {
        super();
        this.pattern = pattern;
        System.out.println("XorClientSocket()");
    }

    /*
     * Constructor for class XorClientSocket.
     */
    public XorClientSocket(String host, int port, byte pattern)
        throws IOException
    {
        super(host, port);
        System.out.println("XorClientSocket("+host+","+port+","+pattern+")");
        this.pattern = pattern;
    }

    /*
     * Returns a stream of type XorInputStream.
     */
    public synchronized InputStream getInputStream() throws IOException {
        if (in == null) {
            in = new XorInputStream(super.getInputStream(), pattern);
        }
        System.out.println("XorClientSocket.getInputStream()");

        return in;
    }

    /*
     *Returns a stream of type XorOutputStream.
     */
    public synchronized OutputStream getOutputStream() throws IOException {
        if (out == null) {
            out = new XorOutputStream(super.getOutputStream(), pattern);
        }
        System.out.println("XorClientSocket.getOutputStream()");
        
        return out;
    }
}