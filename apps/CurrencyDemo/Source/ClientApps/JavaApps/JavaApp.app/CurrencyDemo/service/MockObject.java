package CurrencyDemo.service;

import java.math.BigInteger;
import java.rmi.RemoteException;

import javax.ejb.EJBHome;
import javax.ejb.EJBObject;
import javax.ejb.Handle;
import javax.ejb.RemoveException;

import CurrencyDemo.Common_COP_Q;
import CurrencyDemo.service.dto.Common_COP_QDTO;

import com.versata.tl.common.util.SearchRequest;
import com.versata.tl.vls.service.ServiceException;
import java.rmi.RemoteException;
import javax.ejb.EJBHome;
import javax.ejb.EJBObject;
import javax.ejb.Handle;
import javax.ejb.RemoveException;
import com.versata.tl.common.util.SearchRequest;
import com.versata.tl.vfc.services.VSApplicationContext;
import com.versata.tl.vls.core.Session;
import com.versata.tl.vls.core.VSORBSessionImpl;
import com.versata.tl.vls.service.ServiceException;
import com.versata.tl.vls.service.ServiceUtils;
import commonj.sdo.DataGraph;

import CurrencyDemo.Common_COP_S_Delegate;

public class MockObject implements Common_COP_S {
	private Common_COP_S_Delegate  delegate;
	private VSORBSessionImpl session;
	
	public MockObject() {
		try {
			System.out.println("===> MockObject - New Session for User sa to use in the redirection ,with changed parameters , to the remote methods.");
		delegate = new Common_COP_S_Delegate();
		session = ServiceUtils.getSessionForUser("sa", "CurrencyDemo");
		}
		catch(Throwable th){
		System.out.println(th.toString());
		}
		}

	
	public void createNewDelegate(String uid) throws ServiceException,
			RemoteException {
	
	}


	public String ping(String uid, String input) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public Boolean setRemoteUpdateCUR(String uid, String currencyCode, String remoteParm) throws ServiceException, RemoteException {
		System.out.println("===> MockObject - setRemoteUpdateCUR - redirecting to remoteobject");
		try
		{
			return delegate.setRemoteUpdateCUR(currencyCode, remoteParm, session);
		}
		catch(Exception e)
		{		
			return false;		
		}
	}


	public EJBHome getEJBHome() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public Handle getHandle() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public Object getPrimaryKey() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean isIdentical(EJBObject arg0) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	public void remove() throws RemoteException, RemoveException {
		// TODO Auto-generated method stub
		
	}
}
