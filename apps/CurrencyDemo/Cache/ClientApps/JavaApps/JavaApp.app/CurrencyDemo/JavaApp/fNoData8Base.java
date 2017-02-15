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
 * fNoData8
 */
abstract class fNoData8Base extends VSForm {
	// Declarations for instance variables used in the form
	//{{FORM_VAR_DECL
	protected static final VersataLogger logger = VersataLogger.getLogger(JavaApp.class);
		VSLabel VSLabel11 = new VSLabel();
		VSLabel VSLabel1 = new VSLabel();
	
	//END_FORM_VAR_DECL}}

	public fNoData8Base() throws VSException, java.beans.PropertyVetoException {
		//{{FORM_OBJ_CTOR
			setLayout (null);
		
		beforeFormInitialize();
		
		setName("fNoData8");
		
		
			initVSLabelVSLabel11();
			
			initVSLabelVSLabel1();
			
				
		
			setBounds (0, 0, 271, 160 + 20);
		
			setTitle ("fNoData8");
			setDisplayTitleBar(true);
		setFont (new Font ("Helvetica", 0, 12));
		setStyle(VSForm.ModelessPopup);
		setAnchorForm(VSDisplay.ANCHOR_FORM_NONE);
			setBackgroundDisplayStyle (VSImagePanel.STYLE_STRETCHED);
		
		addListeners();
		afterFormInitialize();
		
		//END_FORM_OBJ_CTOR}}
	}
		
    /**
     * For internal use only - do not call.
     * @internal.tle
     */
    protected Object getFieldValue(Field field) throws IllegalArgumentException, IllegalAccessException {
        return field.get(this);
    }

	public void paintComponent(Graphics g) {
       	super.paintComponent(g); //paint background
    
		//{{PAINT_EVENT
		
		
		
		
		//END_PAINT_EVENT}}
	}

	
	
	
	
	
	public void initVSLabelVSLabel11() {
	VSLabel11.setText("Closing this panel raise error");
	VSLabel11.setAlignment(VSLabel.LEFT);
	VSLabel11.setName ("VSLabel11");
		VSLabel11.setForeground(Color.red);
		VSLabel11.setBackground(Color.lightGray);
	VSLabel11.setBounds (11, 82 , 203, 43);

VSLabel11.setFont (new Font ("Helvetica", 0, 15));

 	VSLabel11.setBorderStyle(VSLabel.NO_BORDER);	 
	VSLabel11.setDataSourceName("");
	VSLabel11.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	VSLabel11.setVerticalAlignment (SwingConstants.CENTER);
	VSLabel11.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (VSLabel11,null);             
	} // end of initVSLabelVSLabel11()
	
	
	
	
	
	
	public void initVSLabelVSLabel1() {
	VSLabel1.setText("fNoData8 ModulPopup style");
	VSLabel1.setAlignment(VSLabel.LEFT);
	VSLabel1.setName ("VSLabel1");
		VSLabel1.setForeground(Color.black);
		VSLabel1.setBackground(Color.lightGray);
	VSLabel1.setBounds (6, 22 , 203, 43);

VSLabel1.setFont (new Font ("Helvetica", 0, 15));

 	VSLabel1.setBorderStyle(VSLabel.NO_BORDER);	 
	VSLabel1.setDataSourceName("");
	VSLabel1.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	VSLabel1.setVerticalAlignment (SwingConstants.CENTER);
	VSLabel1.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (VSLabel1,null);             
	} // end of initVSLabelVSLabel1()
	
}