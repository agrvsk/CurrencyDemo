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
 * fUser_USR
 */
abstract class fUser_USRBase extends VSForm {
	// Declarations for instance variables used in the form
	//{{FORM_VAR_DECL
	protected static final VersataLogger logger = VersataLogger.getLogger(JavaApp.class);
		VSImageButton btnInsert = new VSImageButton("");
		VSImageButton btnDelete = new VSImageButton("");
		VSImageButton btnSave = new VSImageButton("");
		VSImageButton btnUndo = new VSImageButton("");
		VSImageButton btnMoveFirst = new VSImageButton("");
		VSImageButton btnMovePrev = new VSImageButton("");
		VSImageButton btnMoveNext = new VSImageButton("");
		VSImageButton btnMoveLast = new VSImageButton("");
		VSImageButton btnRunQuery = new VSImageButton("");
		VSImageButton btnQueryMode = new VSImageButton("");
		VSImageButton btnQueryMode1 = new VSImageButton("");
		VSImageButton btnCancelQuery = new VSImageButton("");
		VSImageButton btnEditSql = new VSImageButton("");
		VSLabel lblT1USR_Rsn = new VSLabel();
		VSTextField txtT1USR_Rsn = new VSTextField();
		VSLabel lblT1USR_Login = new VSLabel();
		VSTextField txtT1USR_Login = new VSTextField();
		VSLabel lblT1USR_Password = new VSLabel();
		VSTextField txtT1USR_Password = new VSTextField();
		VSLabel lblT1USR_Role = new VSLabel();
		VSTextField txtT1USR_Role = new VSTextField();
		VSJavaDataControl datT1User_USR = new VSJavaDataControl("datT1User_USR");    
	
	//END_FORM_VAR_DECL}}

	public fUser_USRBase() throws VSException, java.beans.PropertyVetoException {
		//{{FORM_OBJ_CTOR
			setLayout (null);
		
		beforeFormInitialize();
		
		setName("fUser_USR");
		
		
			initVSImageButtonbtnInsert();
			
			initVSImageButtonbtnDelete();
			
			initVSImageButtonbtnSave();
			
			initVSImageButtonbtnUndo();
			
			initVSImageButtonbtnMoveFirst();
			
			initVSImageButtonbtnMovePrev();
			
			initVSImageButtonbtnMoveNext();
			
			initVSImageButtonbtnMoveLast();
			
			initVSImageButtonbtnRunQuery();
			
			initVSImageButtonbtnQueryMode();
			
			initVSImageButtonbtnQueryMode1();
			
			initVSImageButtonbtnCancelQuery();
			
			initVSImageButtonbtnEditSql();
			
			initVSLabellblT1USR_Rsn();
			
			 initVSTextFieldtxtT1USR_Rsn();
			
			initVSLabellblT1USR_Login();
			
			 initVSTextFieldtxtT1USR_Login();
			
			initVSLabellblT1USR_Password();
			
			 initVSTextFieldtxtT1USR_Password();
			
			initVSLabellblT1USR_Role();
			
			 initVSTextFieldtxtT1USR_Role();
			
			initVSJavaDataControldatT1User_USR();
			
				
		
			setBounds (0, 0, 579, 500);
		
			setTitle ("User_USR");
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

	
	public void initVSImageButtonbtnInsert() { 
	btnInsert.setImageURL("Images\\New.GIF");
	btnInsert.setName ("btnInsert");
		btnInsert.setForeground(Color.black);
		btnInsert.setBackground(Color.lightGray);
	btnInsert.setBounds (8, 7 , 26, 26);

btnInsert.setFont (new Font ("Helvetica", 0, 12));

	btnInsert.setTag ("_$$_");
 	btnInsert.setActionType(VSAction.db_insert);
	btnInsert.setBorderPainted (true);
	btnInsert.setDisplayStyle(VSImageButton.STYLE_CENTERED);
	btnInsert.setAutoLabel (false);
	btnInsert.setDataSourceName("(Current)");
	btnInsert.setHorizontalTextPosition (SwingConstants.CENTER);
	btnInsert.setVerticalTextPosition (SwingConstants.CENTER);
	btnInsert.setTabOrder(0);
	btnInsert.setToolTipText ("Insert");
	btnInsert.setBorderStyle (VSImageButton.AUTOSHOW_BORDER);
        
      // container is form
add (btnInsert,null);             
	} // end of initVSImageButtonbtnInsert()
	
	
	
	
	
	
	public void initVSImageButtonbtnDelete() { 
	btnDelete.setImageURL("Images\\delete.GIF");
	btnDelete.setName ("btnDelete");
		btnDelete.setForeground(Color.black);
		btnDelete.setBackground(Color.lightGray);
	btnDelete.setBounds (35, 7 , 26, 26);

btnDelete.setFont (new Font ("Helvetica", 0, 12));

	btnDelete.setTag ("_$$_");
 	btnDelete.setActionType(VSAction.db_delete);
	btnDelete.setBorderPainted (true);
	btnDelete.setDisplayStyle(VSImageButton.STYLE_CENTERED);
	btnDelete.setAutoLabel (false);
	btnDelete.setDataSourceName("(Current)");
	btnDelete.setHorizontalTextPosition (SwingConstants.CENTER);
	btnDelete.setVerticalTextPosition (SwingConstants.CENTER);
	btnDelete.setTabOrder(1);
	btnDelete.setToolTipText ("Delete");
	btnDelete.setBorderStyle (VSImageButton.AUTOSHOW_BORDER);
        
      // container is form
add (btnDelete,null);             
	} // end of initVSImageButtonbtnDelete()
	
	
	
	
	
	
	public void initVSImageButtonbtnSave() { 
	btnSave.setImageURL("Images\\Save.GIF");
	btnSave.setName ("btnSave");
		btnSave.setForeground(Color.black);
		btnSave.setBackground(Color.lightGray);
	btnSave.setBounds (70, 7 , 26, 26);

btnSave.setFont (new Font ("Helvetica", 0, 12));

	btnSave.setTag ("_$$_");
 	btnSave.setActionType(VSAction.db_saveAll);
	btnSave.setBorderPainted (true);
	btnSave.setDisplayStyle(VSImageButton.STYLE_CENTERED);
	btnSave.setAutoLabel (false);
	btnSave.setDataSourceName("(Current)");
	btnSave.setHorizontalTextPosition (SwingConstants.CENTER);
	btnSave.setVerticalTextPosition (SwingConstants.CENTER);
	btnSave.setTabOrder(2);
	btnSave.setToolTipText ("Save");
	btnSave.setBorderStyle (VSImageButton.AUTOSHOW_BORDER);
        
      // container is form
add (btnSave,null);             
	} // end of initVSImageButtonbtnSave()
	
	
	
	
	
	
	public void initVSImageButtonbtnUndo() { 
	btnUndo.setImageURL("Images\\Undo.GIF");
	btnUndo.setName ("btnUndo");
		btnUndo.setForeground(Color.black);
		btnUndo.setBackground(Color.lightGray);
	btnUndo.setBounds (97, 7 , 26, 26);

btnUndo.setFont (new Font ("Helvetica", 0, 12));

	btnUndo.setTag ("_$$_");
 	btnUndo.setActionType(VSAction.db_undoRecord);
	btnUndo.setBorderPainted (true);
	btnUndo.setDisplayStyle(VSImageButton.STYLE_CENTERED);
	btnUndo.setAutoLabel (false);
	btnUndo.setDataSourceName("(Current)");
	btnUndo.setHorizontalTextPosition (SwingConstants.CENTER);
	btnUndo.setVerticalTextPosition (SwingConstants.CENTER);
	btnUndo.setTabOrder(3);
	btnUndo.setToolTipText ("Undo");
	btnUndo.setBorderStyle (VSImageButton.AUTOSHOW_BORDER);
        
      // container is form
add (btnUndo,null);             
	} // end of initVSImageButtonbtnUndo()
	
	
	
	
	
	
	public void initVSImageButtonbtnMoveFirst() { 
	btnMoveFirst.setImageURL("Images\\First.GIF");
	btnMoveFirst.setName ("btnMoveFirst");
		btnMoveFirst.setForeground(Color.black);
		btnMoveFirst.setBackground(Color.lightGray);
	btnMoveFirst.setBounds (137, 7 , 26, 26);

btnMoveFirst.setFont (new Font ("Helvetica", 0, 12));

	btnMoveFirst.setTag ("_$$_");
 	btnMoveFirst.setActionType(VSAction.db_first);
	btnMoveFirst.setBorderPainted (true);
	btnMoveFirst.setDisplayStyle(VSImageButton.STYLE_CENTERED);
	btnMoveFirst.setAutoLabel (false);
	btnMoveFirst.setDataSourceName("(Current)");
	btnMoveFirst.setHorizontalTextPosition (SwingConstants.CENTER);
	btnMoveFirst.setVerticalTextPosition (SwingConstants.CENTER);
	btnMoveFirst.setTabOrder(4);
	btnMoveFirst.setToolTipText ("MoveFirst");
	btnMoveFirst.setBorderStyle (VSImageButton.AUTOSHOW_BORDER);
        
      // container is form
add (btnMoveFirst,null);             
	} // end of initVSImageButtonbtnMoveFirst()
	
	
	
	
	
	
	public void initVSImageButtonbtnMovePrev() { 
	btnMovePrev.setImageURL("Images\\previous.GIF");
	btnMovePrev.setName ("btnMovePrev");
		btnMovePrev.setForeground(Color.black);
		btnMovePrev.setBackground(Color.lightGray);
	btnMovePrev.setBounds (164, 7 , 26, 26);

btnMovePrev.setFont (new Font ("Helvetica", 0, 12));

	btnMovePrev.setTag ("_$$_");
 	btnMovePrev.setActionType(VSAction.db_previous);
	btnMovePrev.setBorderPainted (true);
	btnMovePrev.setDisplayStyle(VSImageButton.STYLE_CENTERED);
	btnMovePrev.setAutoLabel (false);
	btnMovePrev.setDataSourceName("(Current)");
	btnMovePrev.setHorizontalTextPosition (SwingConstants.CENTER);
	btnMovePrev.setVerticalTextPosition (SwingConstants.CENTER);
	btnMovePrev.setTabOrder(5);
	btnMovePrev.setToolTipText ("Move Previous");
	btnMovePrev.setBorderStyle (VSImageButton.AUTOSHOW_BORDER);
        
      // container is form
add (btnMovePrev,null);             
	} // end of initVSImageButtonbtnMovePrev()
	
	
	
	
	
	
	public void initVSImageButtonbtnMoveNext() { 
	btnMoveNext.setImageURL("Images\\Next.GIF");
	btnMoveNext.setName ("btnMoveNext");
		btnMoveNext.setForeground(Color.black);
		btnMoveNext.setBackground(Color.lightGray);
	btnMoveNext.setBounds (191, 7 , 26, 26);

btnMoveNext.setFont (new Font ("Helvetica", 0, 12));

	btnMoveNext.setTag ("_$$_");
 	btnMoveNext.setActionType(VSAction.db_next);
	btnMoveNext.setBorderPainted (true);
	btnMoveNext.setDisplayStyle(VSImageButton.STYLE_CENTERED);
	btnMoveNext.setAutoLabel (false);
	btnMoveNext.setDataSourceName("(Current)");
	btnMoveNext.setHorizontalTextPosition (SwingConstants.CENTER);
	btnMoveNext.setVerticalTextPosition (SwingConstants.CENTER);
	btnMoveNext.setTabOrder(6);
	btnMoveNext.setToolTipText ("Move Next");
	btnMoveNext.setBorderStyle (VSImageButton.AUTOSHOW_BORDER);
        
      // container is form
add (btnMoveNext,null);             
	} // end of initVSImageButtonbtnMoveNext()
	
	
	
	
	
	
	public void initVSImageButtonbtnMoveLast() { 
	btnMoveLast.setImageURL("Images\\Last.GIF");
	btnMoveLast.setName ("btnMoveLast");
		btnMoveLast.setForeground(Color.black);
		btnMoveLast.setBackground(Color.lightGray);
	btnMoveLast.setBounds (218, 7 , 26, 26);

btnMoveLast.setFont (new Font ("Helvetica", 0, 12));

	btnMoveLast.setTag ("_$$_");
 	btnMoveLast.setActionType(VSAction.db_last);
	btnMoveLast.setBorderPainted (true);
	btnMoveLast.setDisplayStyle(VSImageButton.STYLE_CENTERED);
	btnMoveLast.setAutoLabel (false);
	btnMoveLast.setDataSourceName("(Current)");
	btnMoveLast.setHorizontalTextPosition (SwingConstants.CENTER);
	btnMoveLast.setVerticalTextPosition (SwingConstants.CENTER);
	btnMoveLast.setTabOrder(7);
	btnMoveLast.setToolTipText ("Move Last");
	btnMoveLast.setBorderStyle (VSImageButton.AUTOSHOW_BORDER);
        
      // container is form
add (btnMoveLast,null);             
	} // end of initVSImageButtonbtnMoveLast()
	
	
	
	
	
	
	public void initVSImageButtonbtnRunQuery() { 
	btnRunQuery.setImageURL("Images\\runQuery.gif");
	btnRunQuery.setName ("btnRunQuery");
		btnRunQuery.setForeground(Color.black);
		btnRunQuery.setBackground(Color.lightGray);
	btnRunQuery.setBounds (258, 7 , 26, 26);

btnRunQuery.setFont (new Font ("Helvetica", 0, 12));

	btnRunQuery.setTag ("_$$_");
 	btnRunQuery.setActionType(VSAction.db_runQuery);
	btnRunQuery.setBorderPainted (true);
	btnRunQuery.setDisplayStyle(VSImageButton.STYLE_CENTERED);
	btnRunQuery.setAutoLabel (false);
	btnRunQuery.setDataSourceName("(Current)");
	btnRunQuery.setHorizontalTextPosition (SwingConstants.CENTER);
	btnRunQuery.setVerticalTextPosition (SwingConstants.CENTER);
	btnRunQuery.setTabOrder(8);
	btnRunQuery.setToolTipText ("Get Data");
	btnRunQuery.setBorderStyle (VSImageButton.AUTOSHOW_BORDER);
        
      // container is form
add (btnRunQuery,null);             
	} // end of initVSImageButtonbtnRunQuery()
	
	
	
	
	
	
	public void initVSImageButtonbtnQueryMode() { 
	btnQueryMode.setImageURL("Images\\QueryMode.GIF");
	btnQueryMode.setName ("btnQueryMode");
		btnQueryMode.setForeground(Color.black);
		btnQueryMode.setBackground(Color.lightGray);
	btnQueryMode.setBounds (293, 7 , 26, 26);

btnQueryMode.setFont (new Font ("Helvetica", 0, 12));

	btnQueryMode.setTag ("_$$_");
 	btnQueryMode.setActionType(VSAction.db_queryMode);
	btnQueryMode.setBorderPainted (true);
	btnQueryMode.setDisplayStyle(VSImageButton.STYLE_CENTERED);
	btnQueryMode.setAutoLabel (false);
	btnQueryMode.setDataSourceName("(Current)");
	btnQueryMode.setHorizontalTextPosition (SwingConstants.CENTER);
	btnQueryMode.setVerticalTextPosition (SwingConstants.CENTER);
	btnQueryMode.setTabOrder(9);
	btnQueryMode.setToolTipText ("Search Mode");
	btnQueryMode.setBorderStyle (VSImageButton.AUTOSHOW_BORDER);
        
      // container is form
add (btnQueryMode,null);             
	} // end of initVSImageButtonbtnQueryMode()
	
	
	
	
	
	
	public void initVSImageButtonbtnQueryMode1() { 
	btnQueryMode1.setImageURL("Images\\clearQuery.gif");
	btnQueryMode1.setName ("btnQueryMode1");
		btnQueryMode1.setForeground(Color.black);
		btnQueryMode1.setBackground(Color.lightGray);
	btnQueryMode1.setBounds (320, 7 , 26, 26);

btnQueryMode1.setFont (new Font ("Helvetica", 0, 12));

	btnQueryMode1.setTag ("_$$_");
 	btnQueryMode1.setActionType(VSAction.db_clearQuery);
	btnQueryMode1.setBorderPainted (true);
	btnQueryMode1.setDisplayStyle(VSImageButton.STYLE_CENTERED);
	btnQueryMode1.setAutoLabel (false);
	btnQueryMode1.setDataSourceName("(Current)");
	btnQueryMode1.setHorizontalTextPosition (SwingConstants.CENTER);
	btnQueryMode1.setVerticalTextPosition (SwingConstants.CENTER);
	btnQueryMode1.setTabOrder(10);
	btnQueryMode1.setToolTipText ("Clear Search");
	btnQueryMode1.setBorderStyle (VSImageButton.AUTOSHOW_BORDER);
        
      // container is form
add (btnQueryMode1,null);             
	} // end of initVSImageButtonbtnQueryMode1()
	
	
	
	
	
	
	public void initVSImageButtonbtnCancelQuery() { 
	btnCancelQuery.setImageURL("Images\\UndoQuery.GIF");
	btnCancelQuery.setName ("btnCancelQuery");
		btnCancelQuery.setForeground(Color.black);
		btnCancelQuery.setBackground(Color.lightGray);
	btnCancelQuery.setBounds (346, 7 , 26, 26);

btnCancelQuery.setFont (new Font ("Helvetica", 0, 12));
	btnCancelQuery.setEnabled(false);

	btnCancelQuery.setTag ("_$$_");
 	btnCancelQuery.setActionType(VSAction.db_cancelQuery);
	btnCancelQuery.setBorderPainted (true);
	btnCancelQuery.setDisplayStyle(VSImageButton.STYLE_CENTERED);
	btnCancelQuery.setAutoLabel (false);
	btnCancelQuery.setDataSourceName("(Current)");
	btnCancelQuery.setHorizontalTextPosition (SwingConstants.CENTER);
	btnCancelQuery.setVerticalTextPosition (SwingConstants.CENTER);
	btnCancelQuery.setTabOrder(11);
	btnCancelQuery.setToolTipText ("Cancel Search");
	btnCancelQuery.setBorderStyle (VSImageButton.AUTOSHOW_BORDER);
        
      // container is form
add (btnCancelQuery,null);             
	} // end of initVSImageButtonbtnCancelQuery()
	
	
	
	
	
	
	public void initVSImageButtonbtnEditSql() { 
	btnEditSql.setImageURL("Images\\EditQuery2.GIF");
	btnEditSql.setName ("btnEditSql");
		btnEditSql.setForeground(Color.black);
		btnEditSql.setBackground(Color.lightGray);
	btnEditSql.setBounds (380, 7 , 26, 26);

btnEditSql.setFont (new Font ("Helvetica", 0, 12));
	btnEditSql.setEnabled(false);

	btnEditSql.setTag ("_$$_");
 	btnEditSql.setActionType(VSAction.db_editSQL);
	btnEditSql.setBorderPainted (true);
	btnEditSql.setDisplayStyle(VSImageButton.STYLE_CENTERED);
	btnEditSql.setAutoLabel (false);
	btnEditSql.setDataSourceName("(Current)");
	btnEditSql.setHorizontalTextPosition (SwingConstants.CENTER);
	btnEditSql.setVerticalTextPosition (SwingConstants.CENTER);
	btnEditSql.setTabOrder(12);
	btnEditSql.setToolTipText ("Edit SQL");
	btnEditSql.setBorderStyle (VSImageButton.AUTOSHOW_BORDER);
        
      // container is form
add (btnEditSql,null);             
	} // end of initVSImageButtonbtnEditSql()
	
	
	
	
	
	
	
	
	
	
	public void initVSLabellblT1USR_Rsn() {
	lblT1USR_Rsn.setText("User_SeqNumber");
	lblT1USR_Rsn.setAlignment(VSLabel.LEFT);
	lblT1USR_Rsn.setName ("lblT1USR_Rsn");
		lblT1USR_Rsn.setForeground(Color.black);
		lblT1USR_Rsn.setBackground(Color.lightGray);
	lblT1USR_Rsn.setBounds (7, 42 , 102, 18);

lblT1USR_Rsn.setFont (new Font ("Helvetica", 0, 12));

	lblT1USR_Rsn.setTag ("_$$_");
 	lblT1USR_Rsn.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1USR_Rsn.setDataSourceName("");
	lblT1USR_Rsn.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1USR_Rsn.setVerticalAlignment (SwingConstants.CENTER);
	lblT1USR_Rsn.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1USR_Rsn,null);             
	} // end of initVSLabellblT1USR_Rsn()
	
	
	
	
	public void initVSTextFieldtxtT1USR_Rsn() { 
	txtT1USR_Rsn.setName ("txtT1USR_Rsn");
		txtT1USR_Rsn.setForeground(Color.black);
		txtT1USR_Rsn.setBackground(Color.white);
	txtT1USR_Rsn.setBounds (111, 41 , 78, 20);

txtT1USR_Rsn.setFont (new Font ("Helvetica", 0, 12));

	txtT1USR_Rsn.setTag ("_$$_");
 	txtT1USR_Rsn.setDataSourceName("datT1User_USR");
	txtT1USR_Rsn.setDataFieldName("USR_Rsn");
	txtT1USR_Rsn.setTabOrder(13);
	txtT1USR_Rsn.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1USR_Rsn,null);             
	} // end of initVSTextFieldtxtT1USR_Rsn()
	
	
	
	
	
	
	
	
	public void initVSLabellblT1USR_Login() {
	lblT1USR_Login.setText("Login");
	lblT1USR_Login.setAlignment(VSLabel.LEFT);
	lblT1USR_Login.setName ("lblT1USR_Login");
		lblT1USR_Login.setForeground(Color.black);
		lblT1USR_Login.setBackground(Color.lightGray);
	lblT1USR_Login.setBounds (7, 70 , 102, 18);

lblT1USR_Login.setFont (new Font ("Helvetica", 0, 12));

	lblT1USR_Login.setTag ("_$$_");
 	lblT1USR_Login.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1USR_Login.setDataSourceName("");
	lblT1USR_Login.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1USR_Login.setVerticalAlignment (SwingConstants.CENTER);
	lblT1USR_Login.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1USR_Login,null);             
	} // end of initVSLabellblT1USR_Login()
	
	
	
	
	public void initVSTextFieldtxtT1USR_Login() { 
	txtT1USR_Login.setName ("txtT1USR_Login");
		txtT1USR_Login.setForeground(Color.black);
		txtT1USR_Login.setBackground(Color.white);
	txtT1USR_Login.setBounds (111, 69 , 114, 20);

txtT1USR_Login.setFont (new Font ("Helvetica", 0, 12));

	txtT1USR_Login.setTag ("_$$_");
 	txtT1USR_Login.setDataSourceName("datT1User_USR");
	txtT1USR_Login.setDataFieldName("USR_Login");
	txtT1USR_Login.setTabOrder(14);
	txtT1USR_Login.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1USR_Login,null);             
	} // end of initVSTextFieldtxtT1USR_Login()
	
	
	
	
	
	
	
	
	public void initVSLabellblT1USR_Password() {
	lblT1USR_Password.setText("Password");
	lblT1USR_Password.setAlignment(VSLabel.LEFT);
	lblT1USR_Password.setName ("lblT1USR_Password");
		lblT1USR_Password.setForeground(Color.black);
		lblT1USR_Password.setBackground(Color.lightGray);
	lblT1USR_Password.setBounds (7, 98 , 102, 18);

lblT1USR_Password.setFont (new Font ("Helvetica", 0, 12));

	lblT1USR_Password.setTag ("_$$_");
 	lblT1USR_Password.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1USR_Password.setDataSourceName("");
	lblT1USR_Password.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1USR_Password.setVerticalAlignment (SwingConstants.CENTER);
	lblT1USR_Password.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1USR_Password,null);             
	} // end of initVSLabellblT1USR_Password()
	
	
	
	
	public void initVSTextFieldtxtT1USR_Password() { 
	txtT1USR_Password.setName ("txtT1USR_Password");
		txtT1USR_Password.setForeground(Color.black);
		txtT1USR_Password.setBackground(Color.white);
	txtT1USR_Password.setBounds (111, 97 , 114, 20);

txtT1USR_Password.setFont (new Font ("Helvetica", 0, 12));

	txtT1USR_Password.setTag ("_$$_");
 	txtT1USR_Password.setDataSourceName("datT1User_USR");
	txtT1USR_Password.setDataFieldName("USR_Password");
	txtT1USR_Password.setTabOrder(15);
	txtT1USR_Password.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1USR_Password,null);             
	} // end of initVSTextFieldtxtT1USR_Password()
	
	
	
	
	
	
	
	
	public void initVSLabellblT1USR_Role() {
	lblT1USR_Role.setText("Role");
	lblT1USR_Role.setAlignment(VSLabel.LEFT);
	lblT1USR_Role.setName ("lblT1USR_Role");
		lblT1USR_Role.setForeground(Color.black);
		lblT1USR_Role.setBackground(Color.lightGray);
	lblT1USR_Role.setBounds (7, 126 , 102, 18);

lblT1USR_Role.setFont (new Font ("Helvetica", 0, 12));

	lblT1USR_Role.setTag ("_$$_");
 	lblT1USR_Role.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1USR_Role.setDataSourceName("");
	lblT1USR_Role.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1USR_Role.setVerticalAlignment (SwingConstants.CENTER);
	lblT1USR_Role.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1USR_Role,null);             
	} // end of initVSLabellblT1USR_Role()
	
	
	
	
	public void initVSTextFieldtxtT1USR_Role() { 
	txtT1USR_Role.setName ("txtT1USR_Role");
		txtT1USR_Role.setForeground(Color.black);
		txtT1USR_Role.setBackground(Color.white);
	txtT1USR_Role.setBounds (111, 125 , 114, 20);

txtT1USR_Role.setFont (new Font ("Helvetica", 0, 12));

	txtT1USR_Role.setTag ("_$$_");
 	txtT1USR_Role.setDataSourceName("datT1User_USR");
	txtT1USR_Role.setDataFieldName("USR_Role");
	txtT1USR_Role.setTabOrder(16);
	txtT1USR_Role.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1USR_Role,null);             
	} // end of initVSTextFieldtxtT1USR_Role()
	
	
	
	public void initVSJavaDataControldatT1User_USR() { 
	datT1User_USR.setLabel ("User_USR");
	datT1User_USR.setQueryInfo(new VSQueryInfo("User_USR", "", "", "", false));
	datT1User_USR.setName ("datT1User_USR");
		datT1User_USR.setForeground(Color.black);
		datT1User_USR.setBackground(Color.white);
	datT1User_USR.setBounds (140, 420 , 201, 25);

datT1User_USR.setFont (new Font ("Helvetica", 0, 12));
	datT1User_USR.setVisible(false);

	datT1User_USR.setTag ("_$$_");
 	datT1User_USR.setTabOrder(17);
	datT1User_USR.setTabStop (false);
	setRootDataControl(datT1User_USR);
	datT1User_USR.setMaxRowsPerFetch(1);
	datT1User_USR.setSaveMode (VSJavaDataControl.SAVE_IMMEDIATE);
	datT1User_USR.setDataDependency (false, false);
        


      // container is form
add (datT1User_USR,null);             
	
	
	} // end of initVSJavaDataControldatT1User_USR()
	
	
	
	
	
	
}