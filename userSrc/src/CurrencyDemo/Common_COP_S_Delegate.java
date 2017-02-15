/*
 * Created on 2006-feb-23
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */ 
package CurrencyDemo;


import java.math.BigInteger;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import CurrencyDemo.Kryptering.XOR.XorClientSocketFactory;
import CurrencyDemo.Kryptering.XOR.XorServerSocketFactory;

import com.versata.tl.common.util.Parameter;
import com.versata.tl.common.util.SearchRequest;
import com.versata.tl.common.vlsobject.VSORBResultSet;
import com.versata.tl.vls.core.Session;

//import com.

/**
 * @author tsd
 *
 * Detta är en remote session bean som hanterar alla remota metoder
 * för en användare.
 * 
 * Remoteanrop kan ej längre ske direkt mot dataobjektet utan måste gå via denna
 * "statelessböna".
 * 
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */



public class Common_COP_S_Delegate {
	
	public Boolean setRemoteUpdateCUR(String sCurrencyCode, String sRemoteParm, Session session) throws Exception{
		try{
			System.out.println("===> Common_COP_S_Delegate - setRemoteUpdateCUR (serverside)"+sRemoteParm);
			Parameter param = new Parameter("Currency_CUR", "CUR_CurrencyCode", sCurrencyCode);
			SearchRequest srFilter = new SearchRequest();
			srFilter.add(param);

			Currency_CURImpl oCUR = (Currency_CURImpl) Currency_CURImpl.getObjectByKey( srFilter, session);
			if(oCUR == null) throw new Exception("CUR not found!");
			boolean bRet=oCUR.setRemoteUpdateCUR(sRemoteParm);
				
			return  new Boolean(bRet);
		 }
		 catch(Exception e)
		 {
			System.out.println("===> Common_COP_S_Delegate -  setRemoteUpdateCUR on serverside Exception="+e);
		 	return  new Boolean(false);
		 }
	}
}
