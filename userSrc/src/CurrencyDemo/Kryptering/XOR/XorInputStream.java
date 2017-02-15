package CurrencyDemo.Kryptering.XOR;

import java.io.*;

public class XorInputStream extends FilterInputStream {

   /*
    * The byte being used to "decrypt" each byte of data.
    */
    private final byte pattern;

    /*
     * Constructs an input stream that uses the specified pattern
     * to "decrypt" each byte of data.
     */
    public XorInputStream(InputStream in, byte pattern) 
    {
            super(in);
            this.pattern = pattern;
            System.out.println("XorInputStream(InputStream,pattern)");
    }

    /*
     * Reads in a byte and xor's the byte with the pattern.
     * Returns the byte.
     */
    public int read() throws IOException 
    {
        System.out.println("XorInputStream.read()");
        int b = -1;
    	try
    	{
            b = in.read();
            if (b != -1)
              b = ((b ^ pattern) & 0xFF);
            
    	}
    	catch(Throwable th)
    	{
    		System.err.println("XorInputStream.read():"+th.toString());
    	}
//    	finally
//    	{
//            if(b == -1) System.out.println("XorInputStream.read(EOF)");
//            else        System.out.println("XorInputStream.read("+b+","+(char)b+")");
//    	}
        return b;
    }

    /*
     * Reads in a bytearray and xor's each byte with the pattern.
     * Returns number of bytes.
     */
    /********************************************
    public int read(byte b[]) throws IOException 
    {
        System.out.println("XorOutputStream.write(byte[]) !!! ");
        int numBytes=-1;
        try
        {
        	numBytes =  in.read( b );
            if (numBytes <= 0)
            {
                return numBytes;
            }

            for(int i = 0; i < numBytes; i++) 
            {
                b[ i ] = (byte)(( b[i] ^ pattern) & 0xFF);
            }
        }
        catch(Throwable th)
        {
        	System.err.println("XorOutputStream.write(byte[]) ok  !!! "+th.toString());
        }
        finally
        {
            System.out.println("XorOutputStream.write(byte[]) ok !!! "+numBytes+" "+b);
        }
        return numBytes;
    }
    ***********************************************/
    /*
     * Reads up to len bytes
     */

    public int read(byte b[], int off, int len) throws IOException {
        System.out.println("XorInputStream.read(byte[],off,len");
        
        int numBytes = 0;
        String svar="";
        try
    	{
            numBytes = in.read(b, off, len);
//            System.out.println(numBytes+"=XorInputStream.read(byte[b]="+b.length+","+off+","+len+")");
            
            if(numBytes > 0)
            for(int i = 0; i < numBytes; i++) 
            {
                b[off + i] = (byte)((b[off + i] ^ pattern) & 0xFF);
                
                if(b[off + i]>31)
                svar += (char)b[off + i];
            }
            else
            if(b != null) svar = b.toString();
    	}
    	catch(Throwable th)
    	{
    		System.err.println("XorInputStream.read(byte[c],int,int):"+th.toString());
    	}
//    	finally
//    	{
//    		if (numBytes <= 0) System.out.println("XorInputStream.read("+svar+","+off+","+len+") EOF "+numBytes+", ");
//    		else               System.out.println("XorInputStream.read("+svar+","+off+","+len+")  OK "+numBytes+", ");
//    	}
       return numBytes;
    }


    
    
}