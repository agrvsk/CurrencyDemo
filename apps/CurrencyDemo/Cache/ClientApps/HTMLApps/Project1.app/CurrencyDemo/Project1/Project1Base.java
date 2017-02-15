//{{APP_IMPORT_STMTS
package CurrencyDemo.Project1;
import com.versata.tl.vfc.ui.html.*;
import com.versata.tl.vfc.ui.html.pdx.*;
import com.versata.tl.vfc.ui.html.model.*;
import com.versata.tl.vfc.ui.html.support.*;
import com.versata.tl.vfc.pls.*;
import com.versata.tl.vfc.pls.common.*;
import com.versata.tl.common.*;
import com.versata.tl.common.businessobject.*;
import com.versata.tl.common.exception.*;
import com.versata.tl.common.util.*;
import com.versata.tl.common.meta.*;
import com.versata.tl.common.vlsobject.*;
import com.versata.tl.common.security.*;
import com.versata.tl.common.vstrace.*;
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
import com.versata.tl.api.logging.*;
import com.versata.tl.util.logging.Logger;
import com.versata.tl.common.text.*;
//END_APP_IMPORT_STMTS}}

public abstract class Project1Base extends PLSApp implements java.io.Serializable {
	public static VersataLogger logger = VersataLogger.getLogger(Project1Base.class);

	public synchronized PLSResponse doAction(PLSRequest preq) {
		PLSResponse response = new PLSResponse();
		VSPage p = null;
		p = getPageFromList(preq.getParameter("page_id"));
		try {
			response.responseValue = p.doAction(preq);
	    		response.metaContentType = p.getContentType();	
		} catch (Exception ex) {
			Util.logWarning(logger, ex);

			response.responseValue = ex.toString();
			response.metaContentType = p.getContentType();	
		}

		return response;
	}

	public PLSResponse start(String sessionID, VSSession session) {   
		VSPage p = null;
		PLSResponse response = super.start(sessionID, session);
		String s = "";

		try {

			PageNavigation StartPageNav = new PageNavigation();
			StartPageNav.setParentApp(this);
			StartPageNav.setTargetPageName(getPackageName() + ".pNoData");
			StartPageNav.setInitialAddMode(false);
			StartPageNav.setInitialQueryMode(false);
        
			String devWhere = "";
		
			if (getQueryStringParams() != null) {
				String params = getQueryStringParams().getProperty("dev_where", "");
				if (devWhere.length() != 0) {
					if (params.length() != 0)
						devWhere = devWhere + " AND " + params;
				} else {
					devWhere = params;
				}
			}

			StartPageNav.setDevWhere(devWhere);
			StartPageNav.setOrderBy("");
			StartPageNav.setTargetPageCaption("");
			StartPageNav.setTargetName("");
			StartPageNav.setName("StartPageNav");
			p = StartPageNav.startPage();
			p.setSessionId(sessionID);
			s = p.generate();
			response.responseValue = s;
			response.metaContentType = p.getContentType();	

		} catch (Exception ex) {
			Util.logWarning(logger, ex);
			
			response.responseValue = "<html> " + ex.toString() + "</html>";
			response.metaContentType = p == null ? "text/html" : p.getContentType();	
			return response;
		}
		if (response.responseValue.length() == 0) {
			response.responseValue = "<html> Unexpected Error </html>";
			response.metaContentType = p.getContentType();	
		}	
		return (response);
	}

	 abstract public String getStartPageName();
  	 abstract public String getPackageName();

	//{{APP_OTHERS
	public String getDefaultStartPageName()
	{
		return "pNoData";
	}
	
	public String getDefaultPackageName()
	{
		return "CurrencyDemo.Project1";
	}
	
	//END_APP_OTHERS}}
}