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
 * fNoData
 */
abstract class fNoDataBase extends VSForm {
	// Declarations for instance variables used in the form
	//{{FORM_VAR_DECL
	protected static final VersataLogger logger = VersataLogger.getLogger(JavaApp.class);
		VSFormNavigation T2fNoData5NavObj = null; 
	
		VSTextArea VSTextArea1 = new VSTextArea();
		VSScrollPane scrlVSTextArea1 = new VSScrollPane(VSTextArea1);
		VSButton btnDekryptera = new VSButton();
		VSButton btnKryptera = new VSButton();
		VSButton btnIssue37 = new VSButton();
		VSButton btnRemoting = new VSButton();
		VSTextArea txtRemoteParm = new VSTextArea();
		VSScrollPane scrltxtRemoteParm = new VSScrollPane(txtRemoteParm);
		VSButton btnRemoteUpdate = new VSButton();
		VSButton btnT2fNoData5 = new VSButton();
	
	//END_FORM_VAR_DECL}}

	public fNoDataBase() throws VSException, java.beans.PropertyVetoException {
		//{{FORM_OBJ_CTOR
			setLayout (null);
		
		beforeFormInitialize();
		
		setName("fNoData");
		
			T2fNoData5NavObj = new VSFormNavigation(this, null, null,"", false, 
									"", "", "fNoData5", " ");
		    T2fNoData5NavObj.setName("T2fNoData5");
		    ;	
		
			initVSTextAreaVSTextArea1();
			
			 initVSButtonbtnDekryptera();
			
			 initVSButtonbtnKryptera();
			
			 initVSButtonbtnIssue37();
			
			 initVSButtonbtnRemoting();
			
			initVSTextAreatxtRemoteParm();
			
			 initVSButtonbtnRemoteUpdate();
			
			 initVSButtonbtnT2fNoData5();
			
				
		                        btnT2fNoData5.setFormTransition(T2fNoData5NavObj);
		
			setBounds (0, 0, 579, 500);
		
			setTitle ("fNoData");
			setDisplayTitleBar(true);
		setFont (new Font ("Helvetica", 0, 12));
		setStyle(VSForm.Child);
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

	
	
	
	
	public void initVSTextAreaVSTextArea1() {
	VSTextArea1.setName ("VSTextArea1");
		VSTextArea1.setForeground(Color.black);
		VSTextArea1.setBackground(Color.white);
	scrlVSTextArea1.setBounds(new Rectangle(204, 318 , 269, 132));

VSTextArea1.setFont (new Font ("Helvetica", 0, 12));

 	VSTextArea1.setDataSourceName("");
	VSTextArea1.setTabOrder(7);
	VSTextArea1.setDisplayMode(VSQueryable.Data_Query);
        
      // container is form
add(scrlVSTextArea1,null);       
	} // end of initVSTextAreaVSTextArea1() 
	
	
	
	
	 public void initVSButtonbtnDekryptera() {
	btnDekryptera.setText("Dekryptera");
	btnDekryptera.setName ("btnDekryptera");
		btnDekryptera.setForeground(Color.black);
		btnDekryptera.setBackground(new Color(0xc6c6c6));
	btnDekryptera.setBounds (15, 398 , 124, 28);

btnDekryptera.setFont (new Font ("Helvetica", 0, 12));

 	btnDekryptera.setBorderPainted (true);
	btnDekryptera.setDataSourceName("");
	btnDekryptera.setTabOrder(6);
        
      // container is form
add (btnDekryptera,null);             
	} // end of initVSButtonbtnDekryptera
	
	
	
	
	
	
	 public void initVSButtonbtnKryptera() {
	btnKryptera.setText("Kryptera");
	btnKryptera.setName ("btnKryptera");
		btnKryptera.setForeground(Color.black);
		btnKryptera.setBackground(new Color(0xc6c6c6));
	btnKryptera.setBounds (18, 361 , 123, 27);

btnKryptera.setFont (new Font ("Helvetica", 0, 12));

 	btnKryptera.setBorderPainted (true);
	btnKryptera.setDataSourceName("");
	btnKryptera.setTabOrder(5);
        
      // container is form
add (btnKryptera,null);             
	} // end of initVSButtonbtnKryptera
	
	
	
	
	
	
	 public void initVSButtonbtnIssue37() {
	btnIssue37.setText("Issue 37. Transaction control from java client does not work.");
	btnIssue37.setName ("btnIssue37");
		btnIssue37.setForeground(Color.black);
		btnIssue37.setBackground(new Color(0xc6c6c6));
	btnIssue37.setBounds (8, 225 , 449, 37);

btnIssue37.setFont (new Font ("Helvetica", 0, 12));

 	btnIssue37.setBorderPainted (true);
	btnIssue37.setDataSourceName("");
	btnIssue37.setTabOrder(4);
        
      // container is form
add (btnIssue37,null);             
	} // end of initVSButtonbtnIssue37
	
	
	
	
	
	
	 public void initVSButtonbtnRemoting() {
	btnRemoting.setText("2 btnRemoting \".setRemoteUpdateCUR\"");
	btnRemoting.setName ("btnRemoting");
		btnRemoting.setForeground(Color.black);
		btnRemoting.setBackground(new Color(0xc6c6c6));
	btnRemoting.setBounds (10, 64 , 277, 26);

btnRemoting.setFont (new Font ("Helvetica", 0, 12));

 	btnRemoting.setBorderPainted (true);
	btnRemoting.setDataSourceName("");
	btnRemoting.setTabOrder(3);
        
      // container is form
add (btnRemoting,null);             
	} // end of initVSButtonbtnRemoting
	
	
	
	
	
	
	
	
	public void initVSTextAreatxtRemoteParm() {
	txtRemoteParm.setName ("txtRemoteParm");
		txtRemoteParm.setForeground(Color.black);
		txtRemoteParm.setBackground(Color.white);
	scrltxtRemoteParm.setBounds(new Rectangle(290, 64 , 190, 27));

txtRemoteParm.setFont (new Font ("Helvetica", 0, 12));

 	txtRemoteParm.setDataSourceName("");
	txtRemoteParm.setTabOrder(2);
	txtRemoteParm.setDisplayMode(VSQueryable.Data_Query);
        
      // container is form
add(scrltxtRemoteParm,null);       
	} // end of initVSTextAreatxtRemoteParm() 
	
	
	
	
	 public void initVSButtonbtnRemoteUpdate() {
	btnRemoteUpdate.setText("1. btnRemoteUpdate \"Get RemoteObject\"");
	btnRemoteUpdate.setName ("btnRemoteUpdate");
		btnRemoteUpdate.setForeground(Color.black);
		btnRemoteUpdate.setBackground(new Color(0xc6c6c6));
	btnRemoteUpdate.setBounds (8, 28 , 287, 26);

btnRemoteUpdate.setFont (new Font ("Helvetica", 0, 12));

 	btnRemoteUpdate.setBorderPainted (true);
	btnRemoteUpdate.setDataSourceName("");
	btnRemoteUpdate.setTabOrder(0);
        
      // container is form
add (btnRemoteUpdate,null);             
	} // end of initVSButtonbtnRemoteUpdate
	
	
	
	
	
	
	 public void initVSButtonbtnT2fNoData5() {
	btnT2fNoData5.setText("Issue 34 - KeyboardFocusManager is not installed");
	btnT2fNoData5.setName ("btnT2fNoData5");
		btnT2fNoData5.setForeground(Color.black);
		btnT2fNoData5.setBackground(Color.white);
	btnT2fNoData5.setBounds (13, 131 , 439, 35);

btnT2fNoData5.setFont (new Font ("Helvetica", 0, 12));

	btnT2fNoData5.setTag ("_$$_");
 	btnT2fNoData5.setBorderPainted (true);
	btnT2fNoData5.setDataSourceName("");
	btnT2fNoData5.setTabOrder(1);
	btnT2fNoData5.setToolTipText ("NoData");
        
      // container is form
add (btnT2fNoData5,null);             
	} // end of initVSButtonbtnT2fNoData5
	
	
	
	
}