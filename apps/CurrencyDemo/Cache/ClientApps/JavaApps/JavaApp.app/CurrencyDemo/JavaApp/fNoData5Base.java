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
 * fNoData5
 */
abstract class fNoData5Base extends VSForm {
	// Declarations for instance variables used in the form
	//{{FORM_VAR_DECL
	protected static final VersataLogger logger = VersataLogger.getLogger(JavaApp.class);
		VSFormNavigation T2fNoData8NavObj = null; 
	
		VSLabel VSLabel1 = new VSLabel();
		VSButton btnT2fNoData8 = new VSButton();
	
	//END_FORM_VAR_DECL}}

	public fNoData5Base() throws VSException, java.beans.PropertyVetoException {
		//{{FORM_OBJ_CTOR
			setLayout (null);
		
		beforeFormInitialize();
		
		setName("fNoData5");
		
			T2fNoData8NavObj = new VSFormNavigation(this, null, null,"", false, 
									"", "", "fNoData8", " ");
		    T2fNoData8NavObj.setName("T2fNoData8");
		    ;	
		
			initVSLabelVSLabel1();
			
			 initVSButtonbtnT2fNoData8();
			
				
		                        btnT2fNoData8.setFormTransition(T2fNoData8NavObj);
		
			setBounds (0, 0, 435, 271 + 20);
		
			setTitle ("fNoData5");
			setDisplayTitleBar(true);
		setFont (new Font ("Helvetica", 0, 12));
		setStyle(VSForm.ModalPopup);
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

	
	
	
	
	
	public void initVSLabelVSLabel1() {
	VSLabel1.setText("fNoData5 ModulPopup style");
	VSLabel1.setAlignment(VSLabel.LEFT);
	VSLabel1.setName ("VSLabel1");
		VSLabel1.setForeground(Color.black);
		VSLabel1.setBackground(Color.lightGray);
	VSLabel1.setBounds (44, 63 , 203, 28);

VSLabel1.setFont (new Font ("Helvetica", 0, 15));

 	VSLabel1.setBorderStyle(VSLabel.NO_BORDER);	 
	VSLabel1.setDataSourceName("");
	VSLabel1.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	VSLabel1.setVerticalAlignment (SwingConstants.CENTER);
	VSLabel1.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (VSLabel1,null);             
	} // end of initVSLabelVSLabel1()
	
	
	
	 public void initVSButtonbtnT2fNoData8() {
	btnT2fNoData8.setText("Transition to fNoData8 ");
	btnT2fNoData8.setName ("btnT2fNoData8");
		btnT2fNoData8.setForeground(Color.black);
		btnT2fNoData8.setBackground(Color.white);
	btnT2fNoData8.setBounds (41, 108 , 279, 42);

btnT2fNoData8.setFont (new Font ("Helvetica", 0, 12));

	btnT2fNoData8.setTag ("_$$_");
 	btnT2fNoData8.setBorderPainted (true);
	btnT2fNoData8.setDataSourceName("");
	btnT2fNoData8.setTabOrder(0);
	btnT2fNoData8.setToolTipText ("NoData");
        
      // container is form
add (btnT2fNoData8,null);             
	} // end of initVSButtonbtnT2fNoData8
	
	
	
	
}