package CurrencyDemo.Kryptering;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import CurrencyDemo.Kryptering.XOR.XorInputStream;
import CurrencyDemo.Kryptering.XOR.XorOutputStream;


public class Converter 
{
	
	
	public static byte[] serialize(Object obj) throws IOException {
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    ObjectOutputStream os = new ObjectOutputStream(out);
	    os.writeObject(obj);
	    return out.toByteArray();
	}
	public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
	    ByteArrayInputStream in = new ByteArrayInputStream(data);
	    ObjectInputStream is = new ObjectInputStream(in);
	    return is.readObject();
	}
	

	
	public static byte[] serialize_XOR(Object obj) throws IOException {
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    XorOutputStream xo = new XorOutputStream(out, (byte) 0xAC);
	    ObjectOutputStream os = new ObjectOutputStream(xo);
	    os.writeObject(obj);
	    return out.toByteArray();
	}
	
	public static Object deserialize_XOR(byte[] data) throws IOException, ClassNotFoundException {
	    ByteArrayInputStream in = new ByteArrayInputStream(data);
	    XorInputStream xi = new XorInputStream(in,(byte) 0xAC);
	    ObjectInputStream is = new ObjectInputStream(xi);
	    return is.readObject();
	}
	

	
	
	
}