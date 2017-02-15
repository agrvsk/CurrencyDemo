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
 * StartupForm
 */
abstract class StartupFormBase extends VSForm {
	// Declarations for instance variables used in the form
	//{{FORM_VAR_DECL
	protected static final VersataLogger logger = VersataLogger.getLogger(JavaApp.class);
		VSFormNavigation T14fUser_USR_GridNavObj = null; 
	
		VSFormNavigation T16fUser_USRNavObj = null; 
	
		VSFormNavigation T12fOMR_GridNavObj = null; 
	
		VSFormNavigation T7fCommonParms_COPNavObj = null; 
	
		VSFormNavigation T4fNoDataNavObj = null; 
	
		VSFormNavigation T13fOrderItem_ORD15NavObj = null; 
	
		VSFormNavigation T9fCurrency_CURNavObj = null; 
	
		VSFormNavigation T10fEmiR_Z_RFUNavObj = null; 
	
		VSFormNavigation T8fAdapterTestNavObj = null; 
	
		VSFormNavigation T5fNoDataTopNavObj = null; 
	
		VSFormNavigation T1fOrderItem_ORDNavObj = null; 
	
		VSFormNavigation T17fOrderItem_ORD21_GridNavObj = null; 
	
		VSFormNavigation T6fLoginNavObj = null; 
	
		VSFormNavigation T2fCurrency_CUR_GridNavObj = null; 
	
		VSFormNavigation T3fOrderBacklogPerMonth_OBT_GridNavObj = null; 
	
		VSFormNavigation T11fOBJ_GridNavObj = null; 
	
		VSFormNavigation T15fZ_YesNo_GridNavObj = null; 
	
		VSImageButton ibtT1fOrderItem_ORD = new VSImageButton("");
		VSImageButton ibtT2fCurrency_CUR_Grid = new VSImageButton("");
		VSImageButton ibtT3fOrderBacklogPerMonth_OBT_Grid = new VSImageButton("");
		VSImageButton ibtT4fNoData = new VSImageButton("");
		VSButton btnT5fNoDataTop = new VSButton();
		VSButton btnT6fLogin = new VSButton();
		VSButton btnT7fCommonParms_COP = new VSButton();
		VSButton btnT8fAdapterTest = new VSButton();
		VSButton btnT9fCurrency_CUR = new VSButton();
		VSButton btnT10fEmiR_Z_RFU = new VSButton();
		VSButton btnT11fOBJ_Grid = new VSButton();
		VSButton btnT12fOMR_Grid = new VSButton();
		VSButton btnT13fOrderItem_ORD15 = new VSButton();
		VSButton btnT14fUser_USR_Grid = new VSButton();
		VSButton btnT15fZ_YesNo_Grid = new VSButton();
		VSButton btnT16fUser_USR = new VSButton();
		VSButton btnT17fOrderItem_ORD21_Grid = new VSButton();
	
	//END_FORM_VAR_DECL}}

	public StartupFormBase() throws VSException, java.beans.PropertyVetoException {
		//{{FORM_OBJ_CTOR
			setLayout (null);
		
		beforeFormInitialize();
		
		setName("StartupForm");
		
			T14fUser_USR_GridNavObj = new VSFormNavigation(this, null, "User_USR","", true,
								"", "", "fUser_USR_Grid", " ");
			T14fUser_USR_GridNavObj.setDataDependency(false, false);
		    T14fUser_USR_GridNavObj.setName("T14fUser_USR_Grid");
		    ;	
			T16fUser_USRNavObj = new VSFormNavigation(this, null, "User_USR","", true,
								"", "", "fUser_USR", " ");
			T16fUser_USRNavObj.setDataDependency(false, false);
		    T16fUser_USRNavObj.setName("T16fUser_USR");
		    ;	
			T12fOMR_GridNavObj = new VSFormNavigation(this, null, "OMR","", true,
								"", "", "fOMR_Grid", " ");
			T12fOMR_GridNavObj.setDataDependency(false, false);
		    T12fOMR_GridNavObj.setName("T12fOMR_Grid");
		    ;	
			T7fCommonParms_COPNavObj = new VSFormNavigation(this, null, "CommonParms_COP","", true,
								"", "", "fCommonParms_COP", " ");
			T7fCommonParms_COPNavObj.setDataDependency(false, false);
		    T7fCommonParms_COPNavObj.setName("T7fCommonParms_COP");
		    ;	
			T4fNoDataNavObj = new VSFormNavigation(this, null, null,"", false, 
									"", "", "fNoData", "");
		    T4fNoDataNavObj.setName("T4fNoData");
		    ;	
			T13fOrderItem_ORD15NavObj = new VSFormNavigation(this, null, "OrderItem_ORD","", true,
								"", "", "fOrderItem_ORD15", " ");
			T13fOrderItem_ORD15NavObj.setDataDependency(false, false);
		    T13fOrderItem_ORD15NavObj.setName("T13fOrderItem_ORD15");
		    ;	
			T9fCurrency_CURNavObj = new VSFormNavigation(this, null, "Currency_CUR","", true,
								"", "", "fCurrency_CUR", " ");
			T9fCurrency_CURNavObj.setDataDependency(false, false);
		    T9fCurrency_CURNavObj.setName("T9fCurrency_CUR");
		    ;	
			T10fEmiR_Z_RFUNavObj = new VSFormNavigation(this, null, "EmiR_Z_RFU","", true,
								"", "", "fEmiR_Z_RFU", " ");
			T10fEmiR_Z_RFUNavObj.setDataDependency(false, false);
		    T10fEmiR_Z_RFUNavObj.setName("T10fEmiR_Z_RFU");
		    ;	
			T8fAdapterTestNavObj = new VSFormNavigation(this, null, null,"", false, 
									"", "", "fAdapterTest", "Adaptertest");
		    T8fAdapterTestNavObj.setName("T8fAdapterTest");
		    ;	
			T5fNoDataTopNavObj = new VSFormNavigation(this, null, null,"", false, 
									"", "", "fNoDataTop", " ");
		    T5fNoDataTopNavObj.setName("T5fNoDataTop");
		    ;	
			T1fOrderItem_ORDNavObj = new VSFormNavigation(this, null, "OrderItem_ORD","", true,
								"", "", "fOrderItem_ORD", "");
			T1fOrderItem_ORDNavObj.setDataDependency(false, false);
		    T1fOrderItem_ORDNavObj.setName("T1fOrderItem_ORD");
		    ;	
			T17fOrderItem_ORD21_GridNavObj = new VSFormNavigation(this, null, "OrderItem_ORD","", true,
								"", "", "fOrderItem_ORD21_Grid", " ");
			T17fOrderItem_ORD21_GridNavObj.setDataDependency(false, false);
		    T17fOrderItem_ORD21_GridNavObj.setName("T17fOrderItem_ORD21_Grid");
		    ;	
			T6fLoginNavObj = new VSFormNavigation(this, null, null,"", false, 
									"", "", "fLogin", "Login");
		    T6fLoginNavObj.setName("T6fLogin");
		    ;	
			T2fCurrency_CUR_GridNavObj = new VSFormNavigation(this, null, "Currency_CUR","", true,
								"", "", "fCurrency_CUR_Grid", "");
			T2fCurrency_CUR_GridNavObj.setDataDependency(false, false);
		    T2fCurrency_CUR_GridNavObj.setName("T2fCurrency_CUR_Grid");
		    ;	
			T3fOrderBacklogPerMonth_OBT_GridNavObj = new VSFormNavigation(this, null, "OrderBacklogPerMonth_OBT","", true,
								"", "", "fOrderBacklogPerMonth_OBT_Grid", "");
			T3fOrderBacklogPerMonth_OBT_GridNavObj.setDataDependency(false, false);
		    T3fOrderBacklogPerMonth_OBT_GridNavObj.setName("T3fOrderBacklogPerMonth_OBT_Grid");
		    ;	
			T11fOBJ_GridNavObj = new VSFormNavigation(this, null, "OBJ","", true,
								"", "", "fOBJ_Grid", " ");
			T11fOBJ_GridNavObj.setDataDependency(false, false);
		    T11fOBJ_GridNavObj.setName("T11fOBJ_Grid");
		    ;	
			T15fZ_YesNo_GridNavObj = new VSFormNavigation(this, null, "Z_YesNo","", true,
								"", "", "fZ_YesNo_Grid", " ");
			T15fZ_YesNo_GridNavObj.setDataDependency(false, false);
		    T15fZ_YesNo_GridNavObj.setName("T15fZ_YesNo_Grid");
		    ;	
		
			initVSImageButtonibtT1fOrderItem_ORD();
			
			initVSImageButtonibtT2fCurrency_CUR_Grid();
			
			initVSImageButtonibtT3fOrderBacklogPerMonth_OBT_Grid();
			
			initVSImageButtonibtT4fNoData();
			
			 initVSButtonbtnT5fNoDataTop();
			
			 initVSButtonbtnT6fLogin();
			
			 initVSButtonbtnT7fCommonParms_COP();
			
			 initVSButtonbtnT8fAdapterTest();
			
			 initVSButtonbtnT9fCurrency_CUR();
			
			 initVSButtonbtnT10fEmiR_Z_RFU();
			
			 initVSButtonbtnT11fOBJ_Grid();
			
			 initVSButtonbtnT12fOMR_Grid();
			
			 initVSButtonbtnT13fOrderItem_ORD15();
			
			 initVSButtonbtnT14fUser_USR_Grid();
			
			 initVSButtonbtnT15fZ_YesNo_Grid();
			
			 initVSButtonbtnT16fUser_USR();
			
			 initVSButtonbtnT17fOrderItem_ORD21_Grid();
			
				
		                        ibtT1fOrderItem_ORD.setFormTransition(T1fOrderItem_ORDNavObj);
		                        ibtT2fCurrency_CUR_Grid.setFormTransition(T2fCurrency_CUR_GridNavObj);
		                        ibtT3fOrderBacklogPerMonth_OBT_Grid.setFormTransition(T3fOrderBacklogPerMonth_OBT_GridNavObj);
		                        ibtT4fNoData.setFormTransition(T4fNoDataNavObj);
		                        btnT5fNoDataTop.setFormTransition(T5fNoDataTopNavObj);
		                        btnT6fLogin.setFormTransition(T6fLoginNavObj);
		                        btnT7fCommonParms_COP.setFormTransition(T7fCommonParms_COPNavObj);
		                        btnT8fAdapterTest.setFormTransition(T8fAdapterTestNavObj);
		                        btnT9fCurrency_CUR.setFormTransition(T9fCurrency_CURNavObj);
		                        btnT10fEmiR_Z_RFU.setFormTransition(T10fEmiR_Z_RFUNavObj);
		                        btnT11fOBJ_Grid.setFormTransition(T11fOBJ_GridNavObj);
		                        btnT12fOMR_Grid.setFormTransition(T12fOMR_GridNavObj);
		                        btnT13fOrderItem_ORD15.setFormTransition(T13fOrderItem_ORD15NavObj);
		                        btnT14fUser_USR_Grid.setFormTransition(T14fUser_USR_GridNavObj);
		                        btnT15fZ_YesNo_Grid.setFormTransition(T15fZ_YesNo_GridNavObj);
		                        btnT16fUser_USR.setFormTransition(T16fUser_USRNavObj);
		                        btnT17fOrderItem_ORD21_Grid.setFormTransition(T17fOrderItem_ORD21_GridNavObj);
		
			setBounds (0, 0, 129, 742);
		
			setDisplayTitleBar(false);
		setFont (new Font ("Helvetica", 0, 12));
		setStyle(VSForm.Child);
		setAnchorForm(VSDisplay.ANCHOR_FORM_LEFT);
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

	
	public void initVSImageButtonibtT1fOrderItem_ORD() { 
	ibtT1fOrderItem_ORD.setImageURL("Images\\order.jpg");
	ibtT1fOrderItem_ORD.setName ("ibtT1fOrderItem_ORD");
		ibtT1fOrderItem_ORD.setForeground(Color.black);
		ibtT1fOrderItem_ORD.setBackground(Color.lightGray);
	ibtT1fOrderItem_ORD.setBounds (10, 134 , 114, 85);

ibtT1fOrderItem_ORD.setFont (new Font ("Helvetica", 0, 12));

	ibtT1fOrderItem_ORD.setTag ("_$$_");
 	ibtT1fOrderItem_ORD.setBorderPainted (true);
	ibtT1fOrderItem_ORD.setDisplayStyle(VSImageButton.STYLE_STRETCHED);
	ibtT1fOrderItem_ORD.setAutoLabel (false);
	ibtT1fOrderItem_ORD.setDataSourceName("");
	ibtT1fOrderItem_ORD.setLabel ("OrderItem_ORD");
	ibtT1fOrderItem_ORD.setHorizontalTextPosition (SwingConstants.CENTER);
	ibtT1fOrderItem_ORD.setVerticalTextPosition (SwingConstants.CENTER);
	ibtT1fOrderItem_ORD.setTabOrder(0);
	ibtT1fOrderItem_ORD.setToolTipText ("OrderItem_ORD");
	ibtT1fOrderItem_ORD.setBorderStyle (VSImageButton.RAISED_BORDER);
        
      // container is form
add (ibtT1fOrderItem_ORD,null);             
	} // end of initVSImageButtonibtT1fOrderItem_ORD()
	
	
	
	
	
	
	public void initVSImageButtonibtT2fCurrency_CUR_Grid() { 
	ibtT2fCurrency_CUR_Grid.setImageURL("Images\\currency.jpg");
	ibtT2fCurrency_CUR_Grid.setName ("ibtT2fCurrency_CUR_Grid");
		ibtT2fCurrency_CUR_Grid.setForeground(Color.black);
		ibtT2fCurrency_CUR_Grid.setBackground(Color.lightGray);
	ibtT2fCurrency_CUR_Grid.setBounds (10, 45 , 114, 85);

ibtT2fCurrency_CUR_Grid.setFont (new Font ("Helvetica", 0, 12));

	ibtT2fCurrency_CUR_Grid.setTag ("_$$_");
 	ibtT2fCurrency_CUR_Grid.setBorderPainted (true);
	ibtT2fCurrency_CUR_Grid.setDisplayStyle(VSImageButton.STYLE_STRETCHED);
	ibtT2fCurrency_CUR_Grid.setAutoLabel (false);
	ibtT2fCurrency_CUR_Grid.setDataSourceName("");
	ibtT2fCurrency_CUR_Grid.setLabel ("Currency_CUR(s)");
	ibtT2fCurrency_CUR_Grid.setHorizontalTextPosition (SwingConstants.CENTER);
	ibtT2fCurrency_CUR_Grid.setVerticalTextPosition (SwingConstants.CENTER);
	ibtT2fCurrency_CUR_Grid.setTabOrder(14);
	ibtT2fCurrency_CUR_Grid.setToolTipText ("Currency_CUR(s)");
	ibtT2fCurrency_CUR_Grid.setBorderStyle (VSImageButton.RAISED_BORDER);
        
      // container is form
add (ibtT2fCurrency_CUR_Grid,null);             
	} // end of initVSImageButtonibtT2fCurrency_CUR_Grid()
	
	
	
	
	
	
	public void initVSImageButtonibtT3fOrderBacklogPerMonth_OBT_Grid() { 
	ibtT3fOrderBacklogPerMonth_OBT_Grid.setImageURL("Images\\orderstock.jpg");
	ibtT3fOrderBacklogPerMonth_OBT_Grid.setName ("ibtT3fOrderBacklogPerMonth_OBT_Grid");
		ibtT3fOrderBacklogPerMonth_OBT_Grid.setForeground(Color.black);
		ibtT3fOrderBacklogPerMonth_OBT_Grid.setBackground(Color.lightGray);
	ibtT3fOrderBacklogPerMonth_OBT_Grid.setBounds (9, 224 , 114, 85);

ibtT3fOrderBacklogPerMonth_OBT_Grid.setFont (new Font ("Helvetica", 0, 12));

	ibtT3fOrderBacklogPerMonth_OBT_Grid.setTag ("_$$_");
 	ibtT3fOrderBacklogPerMonth_OBT_Grid.setBorderPainted (true);
	ibtT3fOrderBacklogPerMonth_OBT_Grid.setDisplayStyle(VSImageButton.STYLE_STRETCHED);
	ibtT3fOrderBacklogPerMonth_OBT_Grid.setAutoLabel (false);
	ibtT3fOrderBacklogPerMonth_OBT_Grid.setDataSourceName("");
	ibtT3fOrderBacklogPerMonth_OBT_Grid.setLabel ("OrderBacklogPerMonth_OBT(s)");
	ibtT3fOrderBacklogPerMonth_OBT_Grid.setHorizontalTextPosition (SwingConstants.CENTER);
	ibtT3fOrderBacklogPerMonth_OBT_Grid.setVerticalTextPosition (SwingConstants.CENTER);
	ibtT3fOrderBacklogPerMonth_OBT_Grid.setTabOrder(15);
	ibtT3fOrderBacklogPerMonth_OBT_Grid.setToolTipText ("OrderBacklogPerMonth_OBT(s)");
	ibtT3fOrderBacklogPerMonth_OBT_Grid.setBorderStyle (VSImageButton.RAISED_BORDER);
        
      // container is form
add (ibtT3fOrderBacklogPerMonth_OBT_Grid,null);             
	} // end of initVSImageButtonibtT3fOrderBacklogPerMonth_OBT_Grid()
	
	
	
	
	
	
	public void initVSImageButtonibtT4fNoData() { 
	ibtT4fNoData.setImageURL("");
	ibtT4fNoData.setName ("ibtT4fNoData");
		ibtT4fNoData.setForeground(Color.black);
		ibtT4fNoData.setBackground(Color.lightGray);
	ibtT4fNoData.setBounds (9, 313 , 114, 30);

ibtT4fNoData.setFont (new Font ("Helvetica", 0, 12));

	ibtT4fNoData.setTag ("_$$_");
 	ibtT4fNoData.setBorderPainted (true);
	ibtT4fNoData.setDisplayStyle(VSImageButton.STYLE_STRETCHED);
	ibtT4fNoData.setAutoLabel (false);
	ibtT4fNoData.setDataSourceName("");
	ibtT4fNoData.setLabel ("RemoteCall");
	ibtT4fNoData.setHorizontalTextPosition (SwingConstants.CENTER);
	ibtT4fNoData.setVerticalTextPosition (SwingConstants.CENTER);
	ibtT4fNoData.setTabOrder(16);
	ibtT4fNoData.setToolTipText ("NoData");
	ibtT4fNoData.setBorderStyle (VSImageButton.RAISED_BORDER);
        
      // container is form
add (ibtT4fNoData,null);             
	} // end of initVSImageButtonibtT4fNoData()
	
	
	
	
	
	
	
	 public void initVSButtonbtnT5fNoDataTop() {
	btnT5fNoDataTop.setText("Anchor form Top");
	btnT5fNoDataTop.setName ("btnT5fNoDataTop");
		btnT5fNoDataTop.setForeground(Color.black);
		btnT5fNoDataTop.setBackground(Color.white);
	btnT5fNoDataTop.setBounds (9, 345 , 114, 30);

btnT5fNoDataTop.setFont (new Font ("Helvetica", 0, 12));

	btnT5fNoDataTop.setTag ("_$$_");
 	btnT5fNoDataTop.setBorderPainted (true);
	btnT5fNoDataTop.setDataSourceName("");
	btnT5fNoDataTop.setTabOrder(13);
	btnT5fNoDataTop.setToolTipText ("Top");
        
      // container is form
add (btnT5fNoDataTop,null);             
	} // end of initVSButtonbtnT5fNoDataTop
	
	
	
	
	
	
	 public void initVSButtonbtnT6fLogin() {
	btnT6fLogin.setText("Login XX");
	btnT6fLogin.setName ("btnT6fLogin");
		btnT6fLogin.setForeground(Color.black);
		btnT6fLogin.setBackground(Color.white);
	btnT6fLogin.setBounds (11, 7 , 114, 30);

btnT6fLogin.setFont (new Font ("Helvetica", 0, 12));

	btnT6fLogin.setTag ("_$$_");
 	btnT6fLogin.setBorderPainted (true);
	btnT6fLogin.setDataSourceName("");
	btnT6fLogin.setTabOrder(12);
	btnT6fLogin.setToolTipText ("Login");
        
      // container is form
add (btnT6fLogin,null);             
	} // end of initVSButtonbtnT6fLogin
	
	
	
	
	
	
	 public void initVSButtonbtnT7fCommonParms_COP() {
	btnT7fCommonParms_COP.setText("CommonParms_COP");
	btnT7fCommonParms_COP.setName ("btnT7fCommonParms_COP");
		btnT7fCommonParms_COP.setForeground(Color.black);
		btnT7fCommonParms_COP.setBackground(Color.white);
	btnT7fCommonParms_COP.setBounds (8, 379 , 114, 30);

btnT7fCommonParms_COP.setFont (new Font ("Helvetica", 0, 12));

	btnT7fCommonParms_COP.setTag ("_$$_");
 	btnT7fCommonParms_COP.setBorderPainted (true);
	btnT7fCommonParms_COP.setDataSourceName("");
	btnT7fCommonParms_COP.setTabOrder(11);
	btnT7fCommonParms_COP.setToolTipText ("CommonParms_COP");
        
      // container is form
add (btnT7fCommonParms_COP,null);             
	} // end of initVSButtonbtnT7fCommonParms_COP
	
	
	
	
	
	
	 public void initVSButtonbtnT8fAdapterTest() {
	btnT8fAdapterTest.setText("Adaptertest");
	btnT8fAdapterTest.setName ("btnT8fAdapterTest");
		btnT8fAdapterTest.setForeground(Color.black);
		btnT8fAdapterTest.setBackground(Color.white);
	btnT8fAdapterTest.setBounds (10, 410 , 84, 25);

btnT8fAdapterTest.setFont (new Font ("Helvetica", 0, 12));

	btnT8fAdapterTest.setTag ("_$$_");
 	btnT8fAdapterTest.setBorderPainted (true);
	btnT8fAdapterTest.setDataSourceName("");
	btnT8fAdapterTest.setTabOrder(10);
	btnT8fAdapterTest.setToolTipText ("Adaptertest");
        
      // container is form
add (btnT8fAdapterTest,null);             
	} // end of initVSButtonbtnT8fAdapterTest
	
	
	
	
	
	
	 public void initVSButtonbtnT9fCurrency_CUR() {
	btnT9fCurrency_CUR.setText("Currency_CUR");
	btnT9fCurrency_CUR.setName ("btnT9fCurrency_CUR");
		btnT9fCurrency_CUR.setForeground(Color.black);
		btnT9fCurrency_CUR.setBackground(Color.white);
	btnT9fCurrency_CUR.setBounds (6, 436 , 86, 25);

btnT9fCurrency_CUR.setFont (new Font ("Helvetica", 0, 12));

	btnT9fCurrency_CUR.setTag ("_$$_");
 	btnT9fCurrency_CUR.setBorderPainted (true);
	btnT9fCurrency_CUR.setDataSourceName("");
	btnT9fCurrency_CUR.setTabOrder(7);
	btnT9fCurrency_CUR.setToolTipText ("Currency_CUR");
        
      // container is form
add (btnT9fCurrency_CUR,null);             
	} // end of initVSButtonbtnT9fCurrency_CUR
	
	
	
	
	
	
	 public void initVSButtonbtnT10fEmiR_Z_RFU() {
	btnT10fEmiR_Z_RFU.setText("fEmiR_Z_RFU");
	btnT10fEmiR_Z_RFU.setName ("btnT10fEmiR_Z_RFU");
		btnT10fEmiR_Z_RFU.setForeground(Color.black);
		btnT10fEmiR_Z_RFU.setBackground(Color.white);
	btnT10fEmiR_Z_RFU.setBounds (5, 461 , 86, 25);

btnT10fEmiR_Z_RFU.setFont (new Font ("Helvetica", 0, 12));

	btnT10fEmiR_Z_RFU.setTag ("_$$_");
 	btnT10fEmiR_Z_RFU.setBorderPainted (true);
	btnT10fEmiR_Z_RFU.setDataSourceName("");
	btnT10fEmiR_Z_RFU.setTabOrder(6);
	btnT10fEmiR_Z_RFU.setToolTipText ("fEmiR_Z_RFU");
        
      // container is form
add (btnT10fEmiR_Z_RFU,null);             
	} // end of initVSButtonbtnT10fEmiR_Z_RFU
	
	
	
	
	
	
	 public void initVSButtonbtnT11fOBJ_Grid() {
	btnT11fOBJ_Grid.setText("OBJ(s)");
	btnT11fOBJ_Grid.setName ("btnT11fOBJ_Grid");
		btnT11fOBJ_Grid.setForeground(Color.black);
		btnT11fOBJ_Grid.setBackground(Color.white);
	btnT11fOBJ_Grid.setBounds (4, 512 , 86, 25);

btnT11fOBJ_Grid.setFont (new Font ("Helvetica", 0, 12));

	btnT11fOBJ_Grid.setTag ("_$$_");
 	btnT11fOBJ_Grid.setBorderPainted (true);
	btnT11fOBJ_Grid.setDataSourceName("");
	btnT11fOBJ_Grid.setTabOrder(5);
	btnT11fOBJ_Grid.setToolTipText ("OBJ(s)");
        
      // container is form
add (btnT11fOBJ_Grid,null);             
	} // end of initVSButtonbtnT11fOBJ_Grid
	
	
	
	
	
	
	 public void initVSButtonbtnT12fOMR_Grid() {
	btnT12fOMR_Grid.setText("OMR(s)");
	btnT12fOMR_Grid.setName ("btnT12fOMR_Grid");
		btnT12fOMR_Grid.setForeground(Color.black);
		btnT12fOMR_Grid.setBackground(Color.white);
	btnT12fOMR_Grid.setBounds (4, 538 , 86, 25);

btnT12fOMR_Grid.setFont (new Font ("Helvetica", 0, 12));

	btnT12fOMR_Grid.setTag ("_$$_");
 	btnT12fOMR_Grid.setBorderPainted (true);
	btnT12fOMR_Grid.setDataSourceName("");
	btnT12fOMR_Grid.setTabOrder(4);
	btnT12fOMR_Grid.setToolTipText ("OMR(s)");
        
      // container is form
add (btnT12fOMR_Grid,null);             
	} // end of initVSButtonbtnT12fOMR_Grid
	
	
	
	
	
	
	 public void initVSButtonbtnT13fOrderItem_ORD15() {
	btnT13fOrderItem_ORD15.setText("T13OrderItem_ORD");
	btnT13fOrderItem_ORD15.setName ("btnT13fOrderItem_ORD15");
		btnT13fOrderItem_ORD15.setForeground(Color.black);
		btnT13fOrderItem_ORD15.setBackground(Color.white);
	btnT13fOrderItem_ORD15.setBounds (6, 573 , 86, 25);

btnT13fOrderItem_ORD15.setFont (new Font ("Helvetica", 0, 12));

	btnT13fOrderItem_ORD15.setTag ("_$$_");
 	btnT13fOrderItem_ORD15.setBorderPainted (true);
	btnT13fOrderItem_ORD15.setDataSourceName("");
	btnT13fOrderItem_ORD15.setTabOrder(3);
	btnT13fOrderItem_ORD15.setToolTipText ("T13OrderItem_ORD");
        
      // container is form
add (btnT13fOrderItem_ORD15,null);             
	} // end of initVSButtonbtnT13fOrderItem_ORD15
	
	
	
	
	
	
	 public void initVSButtonbtnT14fUser_USR_Grid() {
	btnT14fUser_USR_Grid.setText("User_USR(s)");
	btnT14fUser_USR_Grid.setName ("btnT14fUser_USR_Grid");
		btnT14fUser_USR_Grid.setForeground(Color.black);
		btnT14fUser_USR_Grid.setBackground(Color.white);
	btnT14fUser_USR_Grid.setBounds (2, 631 , 86, 25);

btnT14fUser_USR_Grid.setFont (new Font ("Helvetica", 0, 12));

	btnT14fUser_USR_Grid.setTag ("_$$_");
 	btnT14fUser_USR_Grid.setBorderPainted (true);
	btnT14fUser_USR_Grid.setDataSourceName("");
	btnT14fUser_USR_Grid.setTabOrder(9);
	btnT14fUser_USR_Grid.setToolTipText ("User_USR(s)");
        
      // container is form
add (btnT14fUser_USR_Grid,null);             
	} // end of initVSButtonbtnT14fUser_USR_Grid
	
	
	
	
	
	
	 public void initVSButtonbtnT15fZ_YesNo_Grid() {
	btnT15fZ_YesNo_Grid.setText("Z_YesNo(s)");
	btnT15fZ_YesNo_Grid.setName ("btnT15fZ_YesNo_Grid");
		btnT15fZ_YesNo_Grid.setForeground(Color.black);
		btnT15fZ_YesNo_Grid.setBackground(Color.white);
	btnT15fZ_YesNo_Grid.setBounds (4, 703 , 86, 25);

btnT15fZ_YesNo_Grid.setFont (new Font ("Helvetica", 0, 12));

	btnT15fZ_YesNo_Grid.setTag ("_$$_");
 	btnT15fZ_YesNo_Grid.setBorderPainted (true);
	btnT15fZ_YesNo_Grid.setDataSourceName("");
	btnT15fZ_YesNo_Grid.setTabOrder(8);
	btnT15fZ_YesNo_Grid.setToolTipText ("Z_YesNo(s)");
        
      // container is form
add (btnT15fZ_YesNo_Grid,null);             
	} // end of initVSButtonbtnT15fZ_YesNo_Grid
	
	
	
	
	
	
	 public void initVSButtonbtnT16fUser_USR() {
	btnT16fUser_USR.setText("User_USR");
	btnT16fUser_USR.setName ("btnT16fUser_USR");
		btnT16fUser_USR.setForeground(Color.black);
		btnT16fUser_USR.setBackground(Color.white);
	btnT16fUser_USR.setBounds (3, 667 , 86, 25);

btnT16fUser_USR.setFont (new Font ("Helvetica", 0, 12));

	btnT16fUser_USR.setTag ("_$$_");
 	btnT16fUser_USR.setBorderPainted (true);
	btnT16fUser_USR.setDataSourceName("");
	btnT16fUser_USR.setTabOrder(2);
	btnT16fUser_USR.setToolTipText ("User_USR");
        
      // container is form
add (btnT16fUser_USR,null);             
	} // end of initVSButtonbtnT16fUser_USR
	
	
	
	
	
	
	 public void initVSButtonbtnT17fOrderItem_ORD21_Grid() {
	btnT17fOrderItem_ORD21_Grid.setText("OrderItem_ORD(s)");
	btnT17fOrderItem_ORD21_Grid.setName ("btnT17fOrderItem_ORD21_Grid");
		btnT17fOrderItem_ORD21_Grid.setForeground(Color.black);
		btnT17fOrderItem_ORD21_Grid.setBackground(Color.white);
	btnT17fOrderItem_ORD21_Grid.setBounds (4, 486 , 86, 25);

btnT17fOrderItem_ORD21_Grid.setFont (new Font ("Helvetica", 0, 12));

	btnT17fOrderItem_ORD21_Grid.setTag ("_$$_");
 	btnT17fOrderItem_ORD21_Grid.setBorderPainted (true);
	btnT17fOrderItem_ORD21_Grid.setDataSourceName("");
	btnT17fOrderItem_ORD21_Grid.setTabOrder(1);
	btnT17fOrderItem_ORD21_Grid.setToolTipText ("OrderItem_ORD(s)");
        
      // container is form
add (btnT17fOrderItem_ORD21_Grid,null);             
	} // end of initVSButtonbtnT17fOrderItem_ORD21_Grid
	
	
	
	
}