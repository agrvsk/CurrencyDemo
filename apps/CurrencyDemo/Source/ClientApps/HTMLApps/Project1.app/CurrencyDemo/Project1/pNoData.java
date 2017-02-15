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
//{{FORM_CLASS_DECL
public class pNoData extends pNoDataBase

//END_FORM_CLASS_DECL}}
{
	//{{FORM_CLASS_CTOR
	public pNoData(PLSApp parentApp) throws VSException, java.beans.PropertyVetoException {
		super(parentApp);
	//END_FORM_CLASS_CTOR}}
	}

	public HTMLDocumentSpec getDocumentSpecification() {    
		return getDefaultDocumentSpecification();
	}

	public String getFileName() {
		return getDefaultFileName();
	}

	public String getFileLocation() {
		return getPageTemplatePath();
	}

	public void afterPageInitialize() {
		super.afterPageInitialize();
		// Write code here for initializing your own control
		// or creating a new control.
	}
}