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
 * fOMR
 */
abstract class fOMRBase extends VSForm {
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
		VSLabel lblT1OMR_OMR = new VSLabel();
		VSTextField txtT1OMR_OMR = new VSTextField();
		VSLabel lblT1OMR_BESK = new VSLabel();
		VSTextField txtT1OMR_BESK = new VSTextField();
		VSLabel lblT1OMR_INGIOMR = new VSLabel();
		VSTextField txtT1OMR_INGIOMR = new VSTextField();
		VSJavaDataControl datT1OMR = new VSJavaDataControl("datT1OMR");    
	
	//END_FORM_VAR_DECL}}

	public fOMRBase() throws VSException, java.beans.PropertyVetoException {
		//{{FORM_OBJ_CTOR
			setLayout (null);
		
		beforeFormInitialize();
		
		setName("fOMR");
		
		
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
			
			initVSLabellblT1OMR_OMR();
			
			 initVSTextFieldtxtT1OMR_OMR();
			
			initVSLabellblT1OMR_BESK();
			
			 initVSTextFieldtxtT1OMR_BESK();
			
			initVSLabellblT1OMR_INGIOMR();
			
			 initVSTextFieldtxtT1OMR_INGIOMR();
			
			initVSJavaDataControldatT1OMR();
			
				
		
			setBounds (0, 0, 579, 500);
		
			setTitle ("OMR");
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
	
	
	
	
	
	
	
	
	
	
	public void initVSLabellblT1OMR_OMR() {
	lblT1OMR_OMR.setText("Id");
	lblT1OMR_OMR.setAlignment(VSLabel.LEFT);
	lblT1OMR_OMR.setName ("lblT1OMR_OMR");
		lblT1OMR_OMR.setForeground(Color.black);
		lblT1OMR_OMR.setBackground(Color.lightGray);
	lblT1OMR_OMR.setBounds (7, 42 , 102, 18);

lblT1OMR_OMR.setFont (new Font ("Helvetica", 0, 12));

	lblT1OMR_OMR.setTag ("_$$_");
 	lblT1OMR_OMR.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1OMR_OMR.setDataSourceName("");
	lblT1OMR_OMR.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1OMR_OMR.setVerticalAlignment (SwingConstants.CENTER);
	lblT1OMR_OMR.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1OMR_OMR,null);             
	} // end of initVSLabellblT1OMR_OMR()
	
	
	
	
	public void initVSTextFieldtxtT1OMR_OMR() { 
	txtT1OMR_OMR.setName ("txtT1OMR_OMR");
		txtT1OMR_OMR.setForeground(Color.black);
		txtT1OMR_OMR.setBackground(Color.white);
	txtT1OMR_OMR.setBounds (111, 41 , 51, 20);

txtT1OMR_OMR.setFont (new Font ("Helvetica", 0, 12));

	txtT1OMR_OMR.setTag ("_$$_");
 	txtT1OMR_OMR.setDataSourceName("datT1OMR");
	txtT1OMR_OMR.setDataFieldName("OMR_OMR");
	txtT1OMR_OMR.setTabOrder(13);
	txtT1OMR_OMR.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1OMR_OMR,null);             
	} // end of initVSTextFieldtxtT1OMR_OMR()
	
	
	
	
	
	
	
	
	public void initVSLabellblT1OMR_BESK() {
	lblT1OMR_BESK.setText("Beskrivning");
	lblT1OMR_BESK.setAlignment(VSLabel.LEFT);
	lblT1OMR_BESK.setName ("lblT1OMR_BESK");
		lblT1OMR_BESK.setForeground(Color.black);
		lblT1OMR_BESK.setBackground(Color.lightGray);
	lblT1OMR_BESK.setBounds (7, 70 , 102, 18);

lblT1OMR_BESK.setFont (new Font ("Helvetica", 0, 12));

	lblT1OMR_BESK.setTag ("_$$_");
 	lblT1OMR_BESK.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1OMR_BESK.setDataSourceName("");
	lblT1OMR_BESK.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1OMR_BESK.setVerticalAlignment (SwingConstants.CENTER);
	lblT1OMR_BESK.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1OMR_BESK,null);             
	} // end of initVSLabellblT1OMR_BESK()
	
	
	
	
	public void initVSTextFieldtxtT1OMR_BESK() { 
	txtT1OMR_BESK.setName ("txtT1OMR_BESK");
		txtT1OMR_BESK.setForeground(Color.black);
		txtT1OMR_BESK.setBackground(Color.white);
	txtT1OMR_BESK.setBounds (111, 69 , 114, 20);

txtT1OMR_BESK.setFont (new Font ("Helvetica", 0, 12));

	txtT1OMR_BESK.setTag ("_$$_");
 	txtT1OMR_BESK.setDataSourceName("datT1OMR");
	txtT1OMR_BESK.setDataFieldName("OMR_BESK");
	txtT1OMR_BESK.setTabOrder(14);
	txtT1OMR_BESK.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1OMR_BESK,null);             
	} // end of initVSTextFieldtxtT1OMR_BESK()
	
	
	
	
	
	
	
	
	public void initVSLabellblT1OMR_INGIOMR() {
	lblT1OMR_INGIOMR.setText("OMR_INGIOMR");
	lblT1OMR_INGIOMR.setAlignment(VSLabel.LEFT);
	lblT1OMR_INGIOMR.setName ("lblT1OMR_INGIOMR");
		lblT1OMR_INGIOMR.setForeground(Color.black);
		lblT1OMR_INGIOMR.setBackground(Color.lightGray);
	lblT1OMR_INGIOMR.setBounds (7, 98 , 102, 18);

lblT1OMR_INGIOMR.setFont (new Font ("Helvetica", 0, 12));

	lblT1OMR_INGIOMR.setTag ("_$$_");
 	lblT1OMR_INGIOMR.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1OMR_INGIOMR.setDataSourceName("");
	lblT1OMR_INGIOMR.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1OMR_INGIOMR.setVerticalAlignment (SwingConstants.CENTER);
	lblT1OMR_INGIOMR.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1OMR_INGIOMR,null);             
	} // end of initVSLabellblT1OMR_INGIOMR()
	
	
	
	
	public void initVSTextFieldtxtT1OMR_INGIOMR() { 
	txtT1OMR_INGIOMR.setName ("txtT1OMR_INGIOMR");
		txtT1OMR_INGIOMR.setForeground(Color.black);
		txtT1OMR_INGIOMR.setBackground(Color.white);
	txtT1OMR_INGIOMR.setBounds (111, 97 , 51, 20);

txtT1OMR_INGIOMR.setFont (new Font ("Helvetica", 0, 12));

	txtT1OMR_INGIOMR.setTag ("_$$_");
 	txtT1OMR_INGIOMR.setDataSourceName("datT1OMR");
	txtT1OMR_INGIOMR.setDataFieldName("OMR_INGIOMR");
	txtT1OMR_INGIOMR.setTabOrder(15);
	txtT1OMR_INGIOMR.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1OMR_INGIOMR,null);             
	} // end of initVSTextFieldtxtT1OMR_INGIOMR()
	
	
	
	public void initVSJavaDataControldatT1OMR() { 
	datT1OMR.setLabel ("OMR");
	datT1OMR.setQueryInfo(new VSQueryInfo("OMR", "", "", "", false));
	datT1OMR.setName ("datT1OMR");
		datT1OMR.setForeground(Color.black);
		datT1OMR.setBackground(Color.white);
	datT1OMR.setBounds (140, 420 , 201, 25);

datT1OMR.setFont (new Font ("Helvetica", 0, 12));
	datT1OMR.setVisible(false);

	datT1OMR.setTag ("_$$_");
 	datT1OMR.setTabOrder(16);
	datT1OMR.setTabStop (false);
	setRootDataControl(datT1OMR);
	datT1OMR.setMaxRowsPerFetch(1);
	datT1OMR.setSaveMode (VSJavaDataControl.SAVE_IMMEDIATE);
	datT1OMR.setDataDependency (false, false);
        


      // container is form
add (datT1OMR,null);             
	
	
	} // end of initVSJavaDataControldatT1OMR()
	
	
	
	
	
	
}