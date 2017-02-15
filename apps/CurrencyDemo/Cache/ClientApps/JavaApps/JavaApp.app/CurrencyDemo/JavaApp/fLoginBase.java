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
 * fLogin
 */
abstract class fLoginBase extends VSForm {
	// Declarations for instance variables used in the form
	//{{FORM_VAR_DECL
	protected static final VersataLogger logger = VersataLogger.getLogger(JavaApp.class);
		VSButton btnLogin = new VSButton();
		VSLabel VSLabel4 = new VSLabel();
		VSTextField txtServer = new VSTextField();
		VSLabel VSLabel3 = new VSLabel();
		VSTextField txtVLSJNDIName = new VSTextField();
		VSLabel VSLabel2 = new VSLabel();
		VSTextField txtPassword = new VSTextField();
		VSLabel VSLabel1 = new VSLabel();
		VSTextField txtLoginId = new VSTextField();
	
	//END_FORM_VAR_DECL}}

	public fLoginBase() throws VSException, java.beans.PropertyVetoException {
		//{{FORM_OBJ_CTOR
			setLayout (null);
		
		beforeFormInitialize();
		
		setName("fLogin");
		
		
			 initVSButtonbtnLogin();
			
			initVSLabelVSLabel4();
			
			 initVSTextFieldtxtServer();
			
			initVSLabelVSLabel3();
			
			 initVSTextFieldtxtVLSJNDIName();
			
			initVSLabelVSLabel2();
			
			 initVSTextFieldtxtPassword();
			
			initVSLabelVSLabel1();
			
			 initVSTextFieldtxtLoginId();
			
				
		
			setBounds (0, 0, 413, 171 + 20);
		
			setTitle ("fLogin");
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

	
	
	 public void initVSButtonbtnLogin() {
	btnLogin.setText("Login XXX");
	btnLogin.setName ("btnLogin");
		btnLogin.setForeground(Color.black);
		btnLogin.setBackground(new Color(0xc6c6c6));
	btnLogin.setBounds (97, 118 , 108, 25);

btnLogin.setFont (new Font ("Helvetica", 0, 12));

 	btnLogin.setBorderPainted (true);
	btnLogin.setDataSourceName("");
	btnLogin.setTabOrder(4);
        
      // container is form
add (btnLogin,null);             
	} // end of initVSButtonbtnLogin
	
	
	
	
	
	
	
	
	
	public void initVSLabelVSLabel4() {
	VSLabel4.setText("Server");
	VSLabel4.setAlignment(VSLabel.LEFT);
	VSLabel4.setName ("VSLabel4");
		VSLabel4.setForeground(Color.black);
		VSLabel4.setBackground(Color.lightGray);
	VSLabel4.setBounds (9, 91 , 96, 19);

VSLabel4.setFont (new Font ("Helvetica", 0, 12));

 	VSLabel4.setBorderStyle(VSLabel.NO_BORDER);	 
	VSLabel4.setDataSourceName("");
	VSLabel4.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	VSLabel4.setVerticalAlignment (SwingConstants.CENTER);
	VSLabel4.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (VSLabel4,null);             
	} // end of initVSLabelVSLabel4()
	
	
	
	
	public void initVSTextFieldtxtServer() { 
	txtServer.setName ("txtServer");
		txtServer.setForeground(Color.black);
		txtServer.setBackground(Color.white);
	txtServer.setBounds (98, 90 , 298, 20);

txtServer.setFont (new Font ("Helvetica", 0, 12));

 	txtServer.setDataSourceName("");
	txtServer.setTabOrder(3);
	txtServer.setDisplayMode(VSQueryable.Data);
        		
      // container is form
add (txtServer,null);             
	} // end of initVSTextFieldtxtServer()
	
	
	
	
	
	
	
	
	public void initVSLabelVSLabel3() {
	VSLabel3.setText("VLSJNDIName");
	VSLabel3.setAlignment(VSLabel.LEFT);
	VSLabel3.setName ("VSLabel3");
		VSLabel3.setForeground(Color.black);
		VSLabel3.setBackground(Color.lightGray);
	VSLabel3.setBounds (9, 64 , 105, 19);

VSLabel3.setFont (new Font ("Helvetica", 0, 12));

 	VSLabel3.setBorderStyle(VSLabel.NO_BORDER);	 
	VSLabel3.setDataSourceName("");
	VSLabel3.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	VSLabel3.setVerticalAlignment (SwingConstants.CENTER);
	VSLabel3.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (VSLabel3,null);             
	} // end of initVSLabelVSLabel3()
	
	
	
	
	public void initVSTextFieldtxtVLSJNDIName() { 
	txtVLSJNDIName.setName ("txtVLSJNDIName");
		txtVLSJNDIName.setForeground(Color.black);
		txtVLSJNDIName.setBackground(Color.white);
	txtVLSJNDIName.setBounds (98, 63 , 298, 20);

txtVLSJNDIName.setFont (new Font ("Helvetica", 0, 12));

 	txtVLSJNDIName.setDataSourceName("");
	txtVLSJNDIName.setTabOrder(2);
	txtVLSJNDIName.setDisplayMode(VSQueryable.Data);
        		
      // container is form
add (txtVLSJNDIName,null);             
	} // end of initVSTextFieldtxtVLSJNDIName()
	
	
	
	
	
	
	
	
	public void initVSLabelVSLabel2() {
	VSLabel2.setText("Password");
	VSLabel2.setAlignment(VSLabel.LEFT);
	VSLabel2.setName ("VSLabel2");
		VSLabel2.setForeground(Color.black);
		VSLabel2.setBackground(Color.lightGray);
	VSLabel2.setBounds (9, 37 , 70, 19);

VSLabel2.setFont (new Font ("Helvetica", 0, 12));

 	VSLabel2.setBorderStyle(VSLabel.NO_BORDER);	 
	VSLabel2.setDataSourceName("");
	VSLabel2.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	VSLabel2.setVerticalAlignment (SwingConstants.CENTER);
	VSLabel2.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (VSLabel2,null);             
	} // end of initVSLabelVSLabel2()
	
	
	
	
	public void initVSTextFieldtxtPassword() { 
	txtPassword.setName ("txtPassword");
		txtPassword.setForeground(Color.black);
		txtPassword.setBackground(Color.white);
	txtPassword.setBounds (98, 36 , 99, 20);

txtPassword.setFont (new Font ("Helvetica", 0, 12));

 	txtPassword.setDataSourceName("");
	txtPassword.setTabOrder(1);
	txtPassword.setDisplayMode(VSQueryable.Data);
	txtPassword.setEchoChar ('*');
        		
      // container is form
add (txtPassword,null);             
	} // end of initVSTextFieldtxtPassword()
	
	
	
	
	
	
	
	
	public void initVSLabelVSLabel1() {
	VSLabel1.setText("LoginId");
	VSLabel1.setAlignment(VSLabel.LEFT);
	VSLabel1.setName ("VSLabel1");
		VSLabel1.setForeground(Color.black);
		VSLabel1.setBackground(Color.lightGray);
	VSLabel1.setBounds (9, 12 , 49, 19);

VSLabel1.setFont (new Font ("Helvetica", 0, 12));

 	VSLabel1.setBorderStyle(VSLabel.NO_BORDER);	 
	VSLabel1.setDataSourceName("");
	VSLabel1.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	VSLabel1.setVerticalAlignment (SwingConstants.CENTER);
	VSLabel1.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (VSLabel1,null);             
	} // end of initVSLabelVSLabel1()
	
	
	
	
	public void initVSTextFieldtxtLoginId() { 
	txtLoginId.setName ("txtLoginId");
		txtLoginId.setForeground(Color.black);
		txtLoginId.setBackground(Color.white);
	txtLoginId.setBounds (98, 11 , 99, 20);

txtLoginId.setFont (new Font ("Helvetica", 0, 12));

 	txtLoginId.setDataSourceName("");
	txtLoginId.setTabOrder(0);
	txtLoginId.setDisplayMode(VSQueryable.Data);
        		
      // container is form
add (txtLoginId,null);             
	} // end of initVSTextFieldtxtLoginId()
	
	
	
}