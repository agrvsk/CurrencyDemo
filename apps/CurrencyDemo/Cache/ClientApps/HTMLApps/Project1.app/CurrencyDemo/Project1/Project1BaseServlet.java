//{{SERVLET_IMPORT_STMTS
package CurrencyDemo.Project1;
import com.versata.tl.vfc.ui.html.*;
import com.versata.tl.vfc.ui.html.model.*;
import com.versata.tl.vfc.ui.html.pdx.*;
import com.versata.tl.vfc.ui.html.support.*;
import com.versata.tl.vfc.pls.*;
import com.versata.tl.vfc.servlet.*;
import com.versata.tl.vfc.pls.common.*;
import com.versata.tl.common.*;
import com.versata.tl.common.businessobject.*;
import com.versata.tl.common.exception.*;
import com.versata.tl.common.util.*;
import com.versata.tl.common.meta.*;
import com.versata.tl.common.vlsobject.*;
import com.versata.tl.common.security.*;
import com.versata.tl.vls.core.*;
import com.versata.tl.vls.dataaccess.*;
import com.versata.tl.vls.dataaccess.connection.*;
import com.versata.tl.vls.service.*;
import com.versata.tl.vls.dataaccess.jdbcdriver.*;
import java.util.*;
import java.math.BigDecimal;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.rmi.RemoteException;
import com.versata.tl.api.logging.*;
import com.versata.tl.common.text.*;
//END_SERVLET_IMPORT_STMTS}}
public abstract class Project1BaseServlet extends PLSServlet implements javax.servlet.Servlet
{
	
	public static VersataLogger logger = VersataLogger.getLogger(Project1BaseServlet.class);
	
	public void loadLoginPage(boolean failed, HttpServletResponse res, HttpServletRequest req, String msg)
		throws IOException 
	{
		// Load login page. If previous attempt failed, load page with failed message.
		// This method will be generated in gen'd servlet and user can
		// add code for custom login there, or it can be gen'd to supress login

		res.setContentType("text/html");
		PrintWriter toClient = res.getWriter();
		String params = req.getQueryString();
		if (params == null) params = "";

		// Always rebuild the login page. Override the methods getBaseURL() and getServletURL()
		// to handle Firewall deployment scenario
		//if (login == null || login.fileChanged() || params.equals(login.getQueryStringParams()) == false) {
			com.versata.tl.vfc.servlet.Login login = null;
			login = new com.versata.tl.vfc.servlet.Login(); 
			login.setBaseURL(getBaseURL(req, pkgName, applicationName));
			login.setFileLocation(getFileLocation());
			login.setAction(getServletURL(req));
			if (defaultLogonUserID == null)
				login.setDefaultLogonUserID("sa");
			else
				login.setDefaultLogonUserID(defaultLogonUserID);
			if (appServerDSN == null || (appServerDSN != null && appServerDSN.equals("<localVlsServer>")))
				login.setVLS("");
			else
				login.setVLS(appServerDSN);
			login.setQueryStringParams(params);
			login.makePage();
		//}
		if (failed) {	//handle login failed error
			String pageString = login.getOutput();
			String errorString = "<h3><center><font color=#990000>" + msg + "</font></center></h3>";
			pageString = login.putErrorOnTop(pageString, errorString);
			toClient.println(pageString);
		}
		else
			toClient.println(login.getOutput());
	}

	//{{SERVLET_OTHERS
	public String getLoginFileName()
	{
		return "Login.html";
	}
	
	public String getLoginFailedFileName()
	{
		return "Loginfailed.html";
	}
	
	public String getRelativePath()
	{
		return "/CurrencyDemo/Project1/";
	}
	
	public boolean isSuppressLogin() {
		return false;
	
	}
	
	public static String pkgName = "CurrencyDemo";
	public static String applicationName = "Project1";
	public static String defaultLogonUserID = "sa";
	public static String appServerDSN = "<localVLSServer>";
	
	
	public String getAppName() {
		return applicationName;
	}
	
	public String getDefaultFileLocation()
	{
		if (m_strAppDir != null && m_strAppDir.length() > 0)
		    return m_strAppDir + "Source/ClientApps/HTMLApps/" + "Project1.app/";
		String path = super.getDefaultFileLocation();
		if (path != null)
			return path + getRelativePath();
	
		path = getServletConfig().getServletContext().getRealPath(getRelativePath());
		if (path.endsWith(File.separator) == false)
			path = path + File.separator;
		return path;
	
	}
	
	public PLSORBSession doDefaultLogin(HttpServletRequest req)
		throws TierSessionLimitException, RemoteException
	{
		// This code should be over-written to supress login
		
		PLSORBSession _session = null;
		String user = req.getParameter("login");
		String password = req.getParameter("password");
		String clientAppName = applicationName;
		String packageName = pkgName;
		String server = req.getParameter("serverName");
		String hostName = null;
		int pos = 0;
		
		if (server != null  && (pos = server.indexOf(':')) != -1) 
		{
			hostName = server.substring(0, pos);
			server = server.substring(pos +1);
		}
		
		_session = this.getNewSession(user, password, clientAppName, packageName, server, hostName);
	
		//Set app specific properties
		HttpParam params[];
		params = setApplicationProperties(req, packageName, clientAppName);
	
		_session.setAppProperties(params);
	
		return (_session);
	}
	
	//END_SERVLET_OTHERS}}

}