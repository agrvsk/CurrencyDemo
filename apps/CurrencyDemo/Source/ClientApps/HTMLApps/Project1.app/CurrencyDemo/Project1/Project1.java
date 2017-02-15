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

//{{APP_CLASS_DECL
public class Project1 extends Project1Base
//END_APP_CLASS_DECL}}
{
    // Project1 Class Constructor
	//{{APP_CLASS_CTOR
	public Project1 ()
	//END_APP_CLASS_CTOR}}
    {
	    super();
    }
	
    public synchronized PLSResponse doAction(PLSRequest preq)
    {
		//{{APP_DOACTION
		   IVSTrace tr = null;  long begTime = 0;
		   if ( VSTrace.IS_ON ){
		   	tr = VSTrace.get();	
		     	begTime = tr.beg(logger);
		     	tr.set(VST_SESSION_ID, getSessionIDForTracing()).set(VST_CATEGORY, VST_PLS_ACTION).set(VST_ACTION_NAME,"Project1.doAction");
		}
		    PLSResponse response = new PLSResponse();
			VSPage p = null;
			try
			{
				p = getPageFromList(preq.getParameter("page_id"));
				m_currentReq = preq;
				p.doAction(preq, response);
			}
			catch (Throwable ex)
			{
				m_currentReq = null;
				
				Util.logWarning(logger, ex);
				
				response.responseValue = ex.toString();
				
				// Indicate that an error occured
				response.isErrorPresent = true;
				
				if (p != null)
				   response.metaContentType = p.getContentType();
				else
				   response.metaContentType = "text/html";
			}
			
		    if ( tr != null ) tr.end( begTime );
		
		    return response;
		
		//END_APP_DOACTION}}
    }

	public PLSResponse start(String sessionID, VSSession session)
	{
		//{{APP_START
		PLSResponse response = super.start( sessionID, session );
		return response;
		
		//END_APP_START}}
    }

    public String getStartPageName()
    {
	    return getDefaultStartPageName();
    }

    public String getPackageName()
    {
	    return getDefaultPackageName();
    }
}