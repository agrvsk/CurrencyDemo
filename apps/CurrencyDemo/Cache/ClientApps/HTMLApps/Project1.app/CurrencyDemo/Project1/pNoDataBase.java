//{{IMPORT_STMTS
package CurrencyDemo.Project1;
import java.io.*;
import java.lang.reflect.Field;
import javax.swing.text.html.*;

import com.versata.tl.vfc.ui.html.*;
import com.versata.tl.vfc.ui.html.model.*;
import com.versata.tl.vfc.ui.html.pdx.*;
import com.versata.tl.vfc.ui.html.support.*;
import com.versata.tl.vfc.pls.*;
import com.versata.tl.vfc.services.*;
import com.versata.tl.vfc.dataaccess.*;
import com.versata.tl.vfc.ui.swing.control.*;
import com.versata.tl.common.*;
import com.versata.tl.common.businessobject.*;
import com.versata.tl.common.exception.*;
import com.versata.tl.common.util.*;
import com.versata.tl.common.meta.*;
import com.versata.tl.common.text.RuntimeMsgCode;
import com.versata.tl.common.vlsobject.*;
import com.versata.tl.common.security.*;
import com.versata.tl.api.logging.*;
import com.versata.tl.util.logging.Logger;
//END_IMPORT_STMTS}}

/**
 * pNoData
 */
abstract class pNoDataBase extends VSPage implements java.io.Serializable {
	// Declarations for instance variables used in the form
	//{{FORM_VAR_DECL
	public static VersataLogger logger = VersataLogger.getLogger(pNoDataBase.class);
	public static HTMLDocumentSpec docSpec = null;
	
	//END_FORM_VAR_DECL}}

	public pNoDataBase(PLSApp parentApp) throws VSException, java.beans.PropertyVetoException {
		setParentApp(parentApp);
		//{{FORM_OBJ_CTOR
		beforePageInitialize();
		
		setName("pNoData");
		
		
		
		addListeners();
		afterPageInitialize();
		
		//END_FORM_OBJ_CTOR}}
	}

    /**
     * For internal use only - do not call.
     * @internal.tle
     */
    protected Object getFieldValue(Field field) throws IllegalArgumentException, IllegalAccessException {
        return field.get(this);
    }

	//{{FORM_GETFILENAME
	    public String getDefaultFileName() {
			return "pNoData.htm";
		}
	    public HTMLDocumentSpec getDefaultDocumentSpecification() {    
			//At one point of time only one thread should
			//read document specification. 
			synchronized(this.getClass()) {
		        	if (docSpec == null) {
	        	    		docSpec = VSPage.createSpecification(getFileLocation()  + getFileName());
	        		}
			}
	        	return docSpec;
	    }
	
	//END_FORM_GETFILENAME}}
}