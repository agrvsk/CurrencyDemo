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

/**
 * fLogin
 */
//{{FORM_CLASS_DECL
public class fLogin extends fLoginBase
//END_FORM_CLASS_DECL}}
{

	//{{FORM_CLASS_CTOR
	public fLogin() throws VSException, PropertyVetoException {
	//END_FORM_CLASS_CTOR}}
	}
	
	protected void btnLogin_actionPerformed(ActionEvent e) 
	{
		System.out.println("===> Customized login");
		try
		{
			VSSession s = VSApplicationContext.getSession();
			AppEnvironment appEnv = new AppEnvironment("CurrencyDemo","JavaApp");
			
			appEnv.setConnectType(AppEnvironment.CONNECT_USING_JNDI); 
			//appEnv.setVLSJNDIName("CurrencyDemo/VLSContextHome"); 
			//appEnv.setVLSJNDIName("ejb:CurrencyDemoEAR/vs-tle-beans-server/VLSContextHome!com.versata.tl.vls.ejb.VLSContextHome");
			appEnv.setVLSJNDIName(txtVLSJNDIName.getText());
			
			s = new VSSession("",txtLoginId.getText(),"",appEnv);
			s.setLogin(txtLoginId.getText() );
			s.setPassword( txtPassword.getText() );
			
			//<=== TEST
			java.util.ResourceBundle rb = java.util.ResourceBundle.getBundle("jboss-ejb-client");
			if(rb==null) System.out.println("Hittar ej jboss-ejb-client.properties");
			String host = rb.getString("remote.connection.default.host");
			if(host == null || host.trim().length()==0){
				System.out.println("Hittar ej host i jboss-ejb-client.properties");
				}
			System.out.println("===> host= " + host);		
			s.setServer( host );
			//<=== TEST
			System.out.println("getXDAAppServerConnector:"+  s.getXDAAppServerConnector().getClass().getName() 	);
			System.out.println("getXDAConnector         :"+  s.getXDAConnector().getClass().getName()			);		
			
			s.connect();
			VSApplicationContext.setSession(s); 
			System.out.println("===> Logged in");


			
			this.close();
		}
		catch(Exception e1)
		{
			System.out.println("===> ERROR Customized login " + e.toString()+",\t"+e1.toString());
			e1.printStackTrace();
		}
	
	}
	
	protected void fLogin_formActivate(VSForm form) {
		// TODO: Complete event handler method body.
		txtLoginId.setText("sa");
		txtVLSJNDIName.setText("ejb:CurrencyDemoEAR/CurrencyDemoEAR-vs-tle-beans-server/VLSContextHome!com.versata.tl.vls.ejb.VLSContextHome");
		
	}
}