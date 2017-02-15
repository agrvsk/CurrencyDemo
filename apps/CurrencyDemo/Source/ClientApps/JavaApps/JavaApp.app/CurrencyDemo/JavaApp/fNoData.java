//{{IMPORT_STMTS
package CurrencyDemo.JavaApp;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyVetoException;
import java.lang.reflect.Field;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

import com.versata.tl.api.logging.VersataLogger;
import com.versata.tl.util.logging.Logger;
import com.versata.tl.common.*;
import com.versata.tl.common.businessobject.*;
import com.versata.tl.common.exception.*;
import com.versata.tl.common.meta.*;
import com.versata.tl.common.security.*;
import com.versata.tl.common.text.RuntimeMsgCode;
import com.versata.tl.common.util.*;
import com.versata.tl.common.vlsobject.*;
import com.versata.tl.common.vstrace.*;
import com.versata.tl.vfc.services.*;
import com.versata.tl.vfc.dataaccess.*;
import com.versata.tl.vfc.ui.swing.control.*;
import com.versata.tl.vfc.services.controlsupport.*;
import com.versata.tl.vfc.ui.swing.control.support.*;

//END_IMPORT_STMTS}}
import CurrencyDemo.service.Common_COP_S;
import CurrencyDemo.service.Common_COP_SUtil;

import java.math.BigDecimal;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

import org.jboss.ejb.client.EJBClient;
import org.jboss.ejb.client.EJBClientContext;
import org.jboss.ejb.client.EJBReceiver;
import org.jboss.ejb.client.EJBReceiverContext;
import org.jboss.ejb.client.StatefulEJBLocator;

import sun.awt.geom.AreaOp.XorOp;

import com.versata.tl.vfc.dataaccess.ClientInitialContextFactory;
import com.versata.tl.vls.service.ServiceDelegateProxy;

import CurrencyDemo.Kryptering.EJBFrameworkFactoryVSKImpl;
import CurrencyDemo.Kryptering.VSKConnector;
import CurrencyDemo.Kryptering.XOR.XorClientSocketFactory;
import CurrencyDemo.Kryptering.XOR.XorOutputStream;
import CurrencyDemo.Kryptering.XOR.XorInputStream;
import CurrencyDemo.Kryptering.XOR.XorServerSocketFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * fNoData
 */
//{{FORM_CLASS_DECL
public class fNoData extends fNoDataBase
//END_FORM_CLASS_DECL}}
{
	private Common_COP_S oRemoteObj = null;
	
	//{{FORM_CLASS_CTOR
	public fNoData() throws VSException, PropertyVetoException {
	//END_FORM_CLASS_CTOR}}
	//	oRemoteObj = null;
		bTimerActive = false;
	}

//----------------------------------------------------------------------------------------------
	protected Common_COP_S getRemoteObject() throws Exception
	{
		if(oRemoteObj==null)
		{
			//	Are we running on mockserver?
			java.util.ResourceBundle rb = java.util.ResourceBundle.getBundle("VLSResource");
			String srb = (rb != null) ? rb.getString("nameService") : null ;
			boolean bMOCK = ("org.mockejb.jndi.MockContextFactory".equals(srb)) ? true : false;
			try
			{
				if(bMOCK){
					System.out.println("===> fNoData - Simulating service when running on mockserver!");
					oRemoteObj = new CurrencyDemo.service.MockObject();
				}
				else
				{
					System.out.println("===> fNoData - Creating remote object!");

			    	for(int i=10001 ; i<=10009 ;i++)
			    		System.out.println("...Port "+i+" = " +VSKConnector.available(i) );

					oRemoteObj = Common_COP_SUtil.getHome().create();

			    	for(int i=10001 ; i<=10009 ;i++)
			    		System.out.println("...Port "+i+" = " +VSKConnector.available(i) );

//			        try 
//			        {
//				    	byte pattern = (byte) 0xAC;
//				        RMIServerSocketFactory ssf = new XorServerSocketFactory(pattern,10002);
//				        RMIClientSocketFactory csf = new XorClientSocketFactory(pattern,10002);
//						UnicastRemoteObject.exportObject(oRemoteObj , 10002 , csf, ssf);
//						System.out.println("...resultset exporterat med UnicastRemoteObject & XorSockets..");
//					} 
//			        catch (RemoteException e) 
//			        {
//			        	e.printStackTrace();
//			        }



				}

			}catch(Throwable th)
			{
				System.out.println("===> RemoteCall FAILED! "+th.toString());
			}
		}
		return oRemoteObj;
	}
	
	
	protected void btnRemoteUpdate_actionPerformed(ActionEvent e) 
	{
		System.out.println("===> fNoData - btnRemoteUpdate button pressed");
		try
		{
	    	for(int i=10001 ; i<=10009 ;i++)
	    		System.out.println("...Port "+i+" = " +VSKConnector.available(i) );
			oRemoteObj = getRemoteObject(); 
			
	    	for(int i=10001 ; i<=10009 ;i++)
	    		System.out.println("...Port "+i+" = " +VSKConnector.available(i) );

		}
		catch(Exception e1)
		{
			System.out.println("===> btnRemoteUpdate " + e.toString());

		}
	}
	protected void btnRemoting_actionPerformed(ActionEvent e) 
	{
		System.out.println("===> fNoData - btnRemoteUpdate button pressed");
		try
		{
			oRemoteObj.setRemoteUpdateCUR("per", "SEK",txtRemoteParm.getText());
		}
		catch(Exception e1)
		{
			System.out.println("===> btnRemoteUpdate " + e.toString());

		}
	}	
	//----------------------------------------------------------------------------------------------

	protected void btnKryptera_actionPerformed(ActionEvent e) 
	{
		System.out.println("===> fNoData - btnKryptera button pressed");
		try
		{
			qryExec();
//			Kryptera();
		}
		catch(Exception e1)
		{
			System.out.println("===> btnbtnKryptera " + e.toString());
		}
	}
	protected void btnDekryptera_actionPerformed(ActionEvent e) 
	{
		System.out.println("===> fNoData - btnDekryptera button pressed");
		try
		{
			Dekryptera();
		}
		catch(Exception e1)
		{
			System.out.println("===> btnDekryptera " + e.toString());
		}
	}

	private void Kryptera()
	{
		try
		{
			String source = VSTextArea1.getText();
            System.out.println("Krypterar:"+source);

            byte pattern = (byte) 0xAC;
            byte[] b = source.getBytes();
			
			File file = new File("C:/Temp/Krypterad.txt");
			FileOutputStream fos = new FileOutputStream(file);
			XorOutputStream xorout = new XorOutputStream(fos,pattern);

	        for(int i=0 ; i<b.length ; i++)
	        {
	        	xorout.write( b[i] );
	        }
	        fos.close();
	        System.out.println("Done");
	        VSTextArea1.setText("Innehållet i denna ruta \när nu krypterat och finns i filen \nC:/Temp/Krypterad.txt");

		}
		catch(Throwable th)
		{
			System.err.println(th.toString());
		}
	}
	
	private void Dekryptera()
	{
		try
		{
            System.out.println("Dekrypterar: C:/Krypterad.txt");

            byte pattern = (byte) 0xAC;
			
			File file = new File("C:/Temp/Krypterad.txt");
			FileInputStream  fis = new FileInputStream(file); 
//			FilterInputStream filterIs = new BufferedInputStream(fis);
			XorInputStream xorin = new XorInputStream(fis,pattern);

			String s="";
			int i=0;
			while((i=xorin.read()) != -1)
			{
				s+=(char)i;
//				System.out.print((char)i);
			}
	        fis.close();
	        xorin.close();

	        VSTextArea1.setText( s );
			System.out.println( s );

	        System.out.println("Done");
//            byte[] b = source.getBytes();

		}
		catch(Throwable th)
		{
			System.err.println(th.toString());
		}		
	}


	

	protected void btnIssue37_actionPerformed(ActionEvent e) {
		
		
//		timerLoop();
		
		System.out.println("===> fNoData - btnIssue37_actionPerformed pressed");
		try
		{
			VSSession sess = VSApplicationContext.getSession();
			if(! sess.isTransactionInProgress() )	{
				sess.beginTrans();
				System.out.println("===> fNoData - btnIssue37_actionPerformed beginTrans()");

			}
			
			try
			{
				SearchRequest	sr=new SearchRequest();
				SearchRequest	or=new SearchRequest();
				
//				sr.addParameter("Currency_CUR", "CUR_Client", "" );
				
				VSQuery q = new VSQuery(sess, "Currency_CUR", sr,or) ;
				if(q == null) throw new Throwable("q == null");
				
				VSResultSet rs = q.execute();
				if(rs == null) throw new Throwable("rs == null");
				
				VSRow r = rs.first();
				if(r == null) throw new Throwable("r == null");

				BigDecimal bd = r.getData("CUR_ExchangeRate").getBigDecimal();
				if(bd == null) throw new Throwable("bd == null");
				
				System.out.println("===> fNoData - btnIssue37_actionPerformed bd="+bd.toString());
				bd = bd.add(BigDecimal.ONE);
				r.getData("CUR_ExchangeRate").setBigDecimal(bd);
				System.out.println("===> fNoData - btnIssue37_actionPerformed bd="+bd.toString());
				
				r.save();
				System.out.println("===> fNoData - btnIssue37_actionPerformed raden sparad");
			}
			catch(Throwable th)
			{System.out.println(th.toString());}
			
			
			if(  sess.isTransactionInProgress() )	{
				sess.commit();
				System.out.println("===> fNoData - btnIssue37_actionPerformed commit()");
			}
		}
		catch(Exception e1)
		{
			System.out.println("===> btnIssue37 Exception " + e1.toString());
			e1.printStackTrace();
		}
		
	}
	
	boolean bTimerActive;
	//I detta formulärs konstruktor (	fNoData()	) sätt:
	//bTimerActive = false;
	private void timerLoop()
	{
		try 
		{
			if(bTimerActive)
			{
				bTimerActive = false;
				List l = VSApplicationContext.getSessions();
				System.out.println( "Antal sessioner :" + l.size() );

				btnIssue37.setText("Timer stopped.");
				System.out.println("===> fNoData - btnIssue37_actionPerformed (timerloop) ended...");
			}
			else
			{
				List l = VSApplicationContext.getSessions();
				System.out.println( "Antal sessioner :" + l.size() );
				myThread thread1 = new myThread();
				btnIssue37.setText("Timer started.");
				System.out.println("===> fNoData - btnIssue37_actionPerformed (timerloop) started...");
				btnIssue37.addActionListener((ActionListener)thread1);
				bTimerActive = true;
				thread1.start();
			}
		} 
		catch( Throwable th ) 
		{
			VSMessageBox.show("ERROR Start",th.toString(),VSMessageBox.MB_OK);
		} 
	}
	
	
	//=====================================================================================
	//	PRIVAT KLASS - TIMER SOM GÖR JOBBET.
	//=====================================================================================
	private class myThread 	
	extends Thread 
	implements ActionListener
	{
		boolean stopFlag;
		//---------------//
		// STOP TIMER //
		//---------------//
		public void actionPerformed(java.awt.event.ActionEvent ev) 
		{
			stopFlag=true;
			VSButton source = (VSButton)(ev.getSource());
			source.removeActionListener((ActionListener)this);
		}
		//---------------//
		// START TIMER //
		//---------------//
		public void run() 
		{
			int iCnt = 0;
			stopFlag = false;
			try 
			{
				while(!stopFlag ) 
				{
					doSomething();
					iCnt++;
					
					btnIssue37.setText(String.valueOf(iCnt));
					if(stopFlag) break;

					//1 Sec SLEEP
					Thread.sleep(1000);
					
					if(stopFlag) break;
				}
				btnIssue37.setText("Done.");
			} 
			catch(Throwable th)    
			{
				th.printStackTrace();
				VSMessageBox.show("ERROR",th.toString(),VSMessageBox.MB_OK);
			}
		}
	} 
	private void qryExec()
	{
		VSResultSet rs = null;
		VSRow rw=null;
		VSQuery query = new VSQuery();
//		String sSql = "SELECT COP_Description FROM CommonParms_COP WHERE COP_Id=1 ";
		String sSql = "SELECT * FROM Z_YesNo where stored < '18' ";
		query.setMaxRowsPerFetch(1);
//		query.setPreFetchRowCount(true);
//		query.setAutoCloseRemoteRS(true);
//		query.setUseExclusionRS(useExclusion);
//		query.setUseRandomAccessRS(true);
		
		rs = query.execute(sSql, "MySQL55" );
		
		if(rs != null) rw = rs.first();
		while(rw != null)
		{
//			if(rw != null) System.out.println(rw.getData("COP_Description").getString() );
			if(rw != null) System.out.println("STORED="+rw.getData("stored").getString() );
			
			rw = rs.next();
		}

	
	}
	private void doSomething()
	{
	    VSSession original = VSApplicationContext.getSession();
		VSSession s = null;
		
//		VSApplicationContext.getSession();
		try
	    {
			String server = original.getServer();
//			Object secobj = original.getSecurityObject();
			String login  = original.getLogin();
			String passw  = original.getPassword();
			
			AppEnvironment appEnv = new AppEnvironment("CurrencyDemo","JavaApp");
			appEnv.setConnectType(AppEnvironment.CONNECT_USING_JNDI); 
			appEnv.setVLSJNDIName("ejb:CurrencyDemoEAR/CurrencyDemoEAR-vs-tle-beans-server/VLSContextHome!com.versata.tl.vls.ejb.VLSContextHome");
			
//			s = VSApplicationContext.getSession();
			s = new VSSession(server,login,passw,appEnv);
			
			boolean bLoggedIn = s.connect();
			if(bLoggedIn)
			{
				VSApplicationContext.setSession(s); 
				System.out.println("===> Logged in "  + s.getORBSession().getSessionID());

				SearchRequest	sr=new SearchRequest();
				SearchRequest	or=new SearchRequest();
				
//				sr.addParameter("Currency_CUR", "CUR_Client", "" );
				
				VSQuery q = new VSQuery(s, "Currency_CUR", sr,or) ;
				if(q == null) return;
				
				VSResultSet rs = q.execute();
				if(rs == null) return;
				
				VSRow r = rs.first();
				if(r == null) return;

			}
	    }
	    catch(Throwable th)
	    {
	    	System.out.println("ERROR:"+th.toString() );
	    } 
	    finally
	    {
	    	//resume original session//
	    	VSApplicationContext.setSession(original);

	    	//close the used one//
	    	try 
	    	{
//				if(s != null 
//				&& s.getORBSession().getSessionID() != 
//				original.getORBSession().getSessionID())
//				s.close();
			} 
	    	catch (VSException e) 
	    	{
				e.printStackTrace();
			} 
//	    	catch (RemoteException e) 
//			{
//				e.printStackTrace();
//			}
	    	
	    }
	}
	
	
}