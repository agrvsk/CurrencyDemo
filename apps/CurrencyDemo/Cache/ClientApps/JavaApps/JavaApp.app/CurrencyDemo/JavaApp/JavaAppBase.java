//{{PROJECT_IMPORT_STMTS
package CurrencyDemo.JavaApp;
import java.applet.*;
import java.awt.*;
import com.versata.tl.vfc.services.*;
import com.versata.tl.vfc.dataaccess.*;
import com.versata.tl.vfc.ui.swing.control.*;
import com.versata.tl.common.*;
import com.versata.tl.common.businessobject.*;
import com.versata.tl.common.exception.*;
import com.versata.tl.common.util.*;
import com.versata.tl.common.meta.*;
import com.versata.tl.common.vlsobject.*;
import com.versata.tl.common.security.*;
import com.versata.tl.common.vstrace.*;
import javax.swing.*;
import java.awt.event.*;
import com.versata.tl.api.logging.VersataLogger;
import com.versata.tl.util.logging.Logger;

//END_PROJECT_IMPORT_STMTS}}

abstract class JavaAppBase extends VSApplet implements Runnable
{
	//{{PROJECT_VAR_DECL
	Thread	 m_JavaApp = null;
	public static VersataLogger logger = VersataLogger.getLogger(JavaApp.class);
	
	
	//END_PROJECT_VAR_DECL}}



	public JavaAppBase ( int x , int y) {
		super(x,y);
	}

	public String getAppletInfoCode() {
		String s;
		s = "Name: JavaApp\r\n" +
	    		"Author: \r\n";
		return s;
	}

	public void init() {
		VSApplicationContext.setMDI(false);
		super.init();
	}


	public VSSession setSessionCtor()
	{
		// Set up the login dialog box defaults
		VSSession s = null;
		//Set the package name of the business objects the app will use
		VSApplicationContext.setProjectName("CurrencyDemo");
		VSApplicationContext.setAppName("JavaApp");
		VSApplicationContext.showSql(false);
		try
		{
			s = new VSSession( "a", "b", "c", "d", "e" );

			VSLoginDialog loginDlg = new VSLoginDialog (s);

				loginDlg.setServer( "<localVLSServer>" );

			loginDlg.setLogin( "sa" );
			loginDlg.setPassword( "" );
			s.setMonitor( false );	// display/don't display the connection monitor UI

		}
		catch ( VSException ex )
		{
			VSApplicationContext.handleException( "can't login to the server", ex );
		}

		//initialize application context
		VSApplicationContext.setDisplayPanel(displayPanel);
		m_JavaApp = new Thread(this);
		m_JavaApp.start();
		if (logger.isDebugEnabled()) {
			logger.debug("Server: "+s.getServer());
			logger.debug("Login: "+s.getLogin());
		}

		return s;
}


	public void run()
	{
		try {

				// show the startupform
				VSForm.startForm("StartupForm");
			customRun();
		}
		catch(VSException ex) {
			VSApplicationContext.handleException("",ex);
		}
	}

	abstract void customRun();

}
