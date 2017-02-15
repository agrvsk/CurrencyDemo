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

//{{SERVLET_CLASS_DECL
/**
 * 
 * Servlet class
 *
 * @web.servlet
 *      name="Project1" 
 *      display-name="Project1 Servlet"
 *      load-on-startup="10"
 * 
 * @web.servlet-mapping
 *      url-pattern="/Project1"
 * 
 * @web.servlet-mapping
 *      url-pattern="/CurrencyDemo/Project1/Login.html"
 *
 * @web.ejb-ref
 *      name="ejb/PLSContextHome"
 *      jndi-name="ejb/PLSContextHome"
 *      type="Session"
 *      home="com.versata.tl.vfc.pls.ejb.PLSContextHome"
 *      remote="com.versata.tl.vfc.pls.ejb.PLSContext"
 *      link="PLSContextHome"
 *
 */
public class Project1Servlet extends Project1BaseServlet
//END_SERVLET_CLASS_DECL}}
{
    // Project1Servlet Class Constructor
	//{{SERVLET_CLASS_CTOR
	public Project1Servlet ()
	//END_SERVLET_CLASS_CTOR}}
    {
	super();
    }
	
    public void loadLoginPage(boolean failed, HttpServletResponse res, HttpServletRequest req, String msg)
		throws IOException 
    {
		//{{SERVLET_LOADLOGINPAGE
		// Load login page. If previous attempt failed, load page with failed message.
		// This method will be generated in gen'd servlet and user can
		// add code for custom login there, or it can be gen'd to supress login
		super.loadLoginPage(failed, res, req,msg);
		PrintWriter toClient = res.getWriter();
		String params = req.getQueryString();
		
		//END_SERVLET_LOADLOGINPAGE}}
    }

    public String getFileLocation()
    {
	    return getDefaultFileLocation();
	
    }

    public String getBaseURL(HttpServletRequest req, String packageName, String clientAppName)
    {
          return super.getBaseURL(req, packageName, clientAppName);
    }
    public String getServletURL(HttpServletRequest req)
    {
        return super.getServletURL(req);			
    }

	public PLSORBSession doLogin(HttpServletRequest req)
		throws TierSessionLimitException, RemoteException
	{
		return doDefaultLogin(req);
	}

	public void loadStartPage()
	{
		// Right now, this is done by calling session.start, which calls app.start.
		// We may want this here for the case when developer wants to customize.
	}

}