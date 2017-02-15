package CurrencyDemo.Kryptering.XOR;


import com.versata.tl.util.SerializationUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.io.IOException;


public class XorCompressionAlg extends com.versata.tl.common.util.ZipCompressionAlg
{

    public XorCompressionAlg()
    {
    }

    public byte[] compressStrings(String uncompressedData[][])
    {
        return compress(SerializationUtil.serializeToByteArray(uncompressedData));
    }

    public String[][] decompressStrings(byte compressedData[])
    {
        return (String[][])(String[][])SerializationUtil.deserializeFromByteArray(decompress(compressedData), java.lang.String.class);
    }


    public byte[] compress(byte uncompressedData[])
    {
    	ByteArrayOutputStream out = null;
    	try
    	{
        	out = new ByteArrayOutputStream();
    	    XorOutputStream xo = new XorOutputStream(out, (byte) 0xAC);
            for(int i=0 ; i<uncompressedData.length ; i++)
            {
            	xo.write( uncompressedData[i] );
            }
            return out.toByteArray();
    	}
    	catch(Throwable th)
    	{
    		System.err.println(th.toString());
    	}
    	finally
    	{
    		try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
	    
        return uncompressedData;
    }

    public byte[] decompress(byte compressedData[])
    {

    	ByteArrayInputStream bis = new ByteArrayInputStream(compressedData);
		XorInputStream xi = new XorInputStream(bis,(byte) 0xAC);
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
    	try
    	{
    		byte[] s=new byte[compressedData.length];
    		int i=0;
    		while((i=xi.read()) != -1)
    		{
    			bao.write( i );
    		}
    		return bao.toByteArray();
    	}
       	catch(Throwable th)
    	{
    		System.err.println(th.toString());
    	}
    	finally
    	{
    		try {
				bis.close();
				xi.close();
				bao.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
        return compressedData;
    }



}
