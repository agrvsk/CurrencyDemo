package CurrencyDemo.Kryptering.XOR;

import java.io.*;

public class XorOutputStream extends FilterOutputStream {

    /*
     * The byte used to "encrypt" each byte of data.
     */
    private final byte pattern;

    /*
     * Constructs an output stream that uses the specified pattern
     * to "encrypt" each byte of data.
     */
    public XorOutputStream(OutputStream out, byte pattern) {
        super(out);
        this.pattern = pattern;
        System.out.println("XorOutputStream(OutputStream,pattern)");

    }

    /*
     * XOR's the byte being written with the pattern
     * and writes the result.
     */
    public void write(int b) throws IOException {
      System.out.println("XorOutputStream.write(int)");
        out.write((b ^ pattern) & 0xFF);
//        System.out.println("XorOutputStream.write(int="+b+","+((b>31) ? (char)b : " " )+") ok");

    }
/******************************************************    
    public void write(byte b[]) throws IOException 
    {
        System.out.println("XorOutputStream.write(byte[]) !!! "+b.toString());
    	for(int i=0 ; i<b.length ; i++)
    	{
            out.write((b[i] ^ pattern) & 0xFF);
    	}
        System.out.println("XorOutputStream.write(byte[]) ok  !!! ");
    }
    
    public void write(byte b[], int off, int len) throws IOException 
    {
        System.out.println("XorOutputStream.write(byte[],int,int) !!! "+b.toString());
        String s=null;
    	if ((off | len | (b.length - (len + off)) | (off + len)) < 0)
    	    throw new IndexOutOfBoundsException();

    	for (int i=0 ; i < len ; i++) 
    	{
    		s+=(char)(b[off + i]);
    	    out.write(  ((b[off + i]) ^ pattern ) & 0xFF );
    	}
        
    	System.out.println("XorOutputStream.write(byte[],int,int) ok !!! "+s);

    }
    **********************************************/
}