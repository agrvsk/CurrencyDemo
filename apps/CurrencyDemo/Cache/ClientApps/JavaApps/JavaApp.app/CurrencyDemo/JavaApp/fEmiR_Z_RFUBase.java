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
 * fEmiR_Z_RFU
 */
abstract class fEmiR_Z_RFUBase extends VSForm {
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
		VSLabel lblT1RFU_RFURSN = new VSLabel();
		VSTextField txtT1RFU_RFURSN = new VSTextField();
		VSLabel lblT1RFU_ARTAL_FROM = new VSLabel();
		VSTextField txtT1RFU_ARTAL_FROM = new VSTextField();
		VSLabel lblT1RFU_PERIOD_FROM = new VSLabel();
		VSTextField txtT1RFU_PERIOD_FROM = new VSTextField();
		VSLabel lblT1RFU_KT2_FROM = new VSLabel();
		VSTextField txtT1RFU_KT2_FROM = new VSTextField();
		VSLabel lblT1RFU_KT2_TOM = new VSLabel();
		VSTextField txtT1RFU_KT2_TOM = new VSTextField();
		VSLabel lblT1RFU_NIVA_FROM = new VSLabel();
		VSTextField txtT1RFU_NIVA_FROM = new VSTextField();
		VSCheckbox chkT1RFU_SUMMERA_UNIVA = new VSCheckbox();
		VSLabel lblT1RFU_SUMMERA_UNIVA = new VSLabel();
		VSLabel lblT1RFU_RAPPID = new VSLabel();
		VSTextField txtT1RFU_RAPPID = new VSTextField();
		VSLabel lblT1RFU_UTDATA = new VSLabel();
		VSTextField txtT1RFU_UTDATA = new VSTextField();
		VSLabel lblT1RFU_RGHRSN = new VSLabel();
		VSTextField txtT1RFU_RGHRSN = new VSTextField();
		VSLabel lblT1RFU_BOLNR = new VSLabel();
		VSTextField txtT1RFU_BOLNR = new VSTextField();
		VSLabel lblT1RFU_BESKRIVNING = new VSLabel();
		VSTextField txtT1RFU_BESKRIVNING = new VSTextField();
		VSLabel lblT1RFU_RAPPORTID = new VSLabel();
		VSTextField txtT1RFU_RAPPORTID = new VSTextField();
		VSDateChoice vsdT1RFU_DATETIME = new VSDateChoice();
		VSLabel lblT1RFU_DATETIME = new VSLabel();
		VSJavaDataControl datT1EmiR_Z_RFU = new VSJavaDataControl("datT1EmiR_Z_RFU");    
	
	//END_FORM_VAR_DECL}}

	public fEmiR_Z_RFUBase() throws VSException, java.beans.PropertyVetoException {
		//{{FORM_OBJ_CTOR
			setLayout (null);
		
		beforeFormInitialize();
		
		setName("fEmiR_Z_RFU");
		
		
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
			
			initVSLabellblT1RFU_RFURSN();
			
			 initVSTextFieldtxtT1RFU_RFURSN();
			
			initVSLabellblT1RFU_ARTAL_FROM();
			
			 initVSTextFieldtxtT1RFU_ARTAL_FROM();
			
			initVSLabellblT1RFU_PERIOD_FROM();
			
			 initVSTextFieldtxtT1RFU_PERIOD_FROM();
			
			initVSLabellblT1RFU_KT2_FROM();
			
			 initVSTextFieldtxtT1RFU_KT2_FROM();
			
			initVSLabellblT1RFU_KT2_TOM();
			
			 initVSTextFieldtxtT1RFU_KT2_TOM();
			
			initVSLabellblT1RFU_NIVA_FROM();
			
			 initVSTextFieldtxtT1RFU_NIVA_FROM();
			
			initVSCheckboxchkT1RFU_SUMMERA_UNIVA();
			
			initVSLabellblT1RFU_SUMMERA_UNIVA();
			
			initVSLabellblT1RFU_RAPPID();
			
			 initVSTextFieldtxtT1RFU_RAPPID();
			
			initVSLabellblT1RFU_UTDATA();
			
			 initVSTextFieldtxtT1RFU_UTDATA();
			
			initVSLabellblT1RFU_RGHRSN();
			
			 initVSTextFieldtxtT1RFU_RGHRSN();
			
			initVSLabellblT1RFU_BOLNR();
			
			 initVSTextFieldtxtT1RFU_BOLNR();
			
			initVSLabellblT1RFU_BESKRIVNING();
			
			 initVSTextFieldtxtT1RFU_BESKRIVNING();
			
			initVSLabellblT1RFU_RAPPORTID();
			
			 initVSTextFieldtxtT1RFU_RAPPORTID();
			
			initVSDateChoicevsdT1RFU_DATETIME();
			
			initVSLabellblT1RFU_DATETIME();
			
			initVSJavaDataControldatT1EmiR_Z_RFU();
			
				
		
			setBounds (0, 0, 579, 500);
		
			setTitle ("fEmiR_Z_RFU");
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
	
	
	
	
	
	
	
	
	
	
	public void initVSLabellblT1RFU_RFURSN() {
	lblT1RFU_RFURSN.setText("RFUrsn");
	lblT1RFU_RFURSN.setAlignment(VSLabel.LEFT);
	lblT1RFU_RFURSN.setName ("lblT1RFU_RFURSN");
		lblT1RFU_RFURSN.setForeground(Color.black);
		lblT1RFU_RFURSN.setBackground(Color.lightGray);
	lblT1RFU_RFURSN.setBounds (7, 42 , 102, 18);

lblT1RFU_RFURSN.setFont (new Font ("Helvetica", 0, 12));

	lblT1RFU_RFURSN.setTag ("_$$_");
 	lblT1RFU_RFURSN.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1RFU_RFURSN.setDataSourceName("");
	lblT1RFU_RFURSN.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1RFU_RFURSN.setVerticalAlignment (SwingConstants.CENTER);
	lblT1RFU_RFURSN.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1RFU_RFURSN,null);             
	} // end of initVSLabellblT1RFU_RFURSN()
	
	
	
	
	public void initVSTextFieldtxtT1RFU_RFURSN() { 
	txtT1RFU_RFURSN.setName ("txtT1RFU_RFURSN");
		txtT1RFU_RFURSN.setForeground(Color.black);
		txtT1RFU_RFURSN.setBackground(Color.white);
	txtT1RFU_RFURSN.setBounds (111, 41 , 78, 20);

txtT1RFU_RFURSN.setFont (new Font ("Helvetica", 0, 12));

	txtT1RFU_RFURSN.setTag ("_$$_");
 	txtT1RFU_RFURSN.setDataSourceName("datT1EmiR_Z_RFU");
	txtT1RFU_RFURSN.setDataFieldName("RFU_RFURSN");
	txtT1RFU_RFURSN.setTabOrder(13);
	txtT1RFU_RFURSN.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1RFU_RFURSN,null);             
	} // end of initVSTextFieldtxtT1RFU_RFURSN()
	
	
	
	
	
	
	
	
	public void initVSLabellblT1RFU_ARTAL_FROM() {
	lblT1RFU_ARTAL_FROM.setText("Årtal from");
	lblT1RFU_ARTAL_FROM.setAlignment(VSLabel.LEFT);
	lblT1RFU_ARTAL_FROM.setName ("lblT1RFU_ARTAL_FROM");
		lblT1RFU_ARTAL_FROM.setForeground(Color.black);
		lblT1RFU_ARTAL_FROM.setBackground(Color.lightGray);
	lblT1RFU_ARTAL_FROM.setBounds (7, 70 , 102, 18);

lblT1RFU_ARTAL_FROM.setFont (new Font ("Helvetica", 0, 12));

	lblT1RFU_ARTAL_FROM.setTag ("_$$_");
 	lblT1RFU_ARTAL_FROM.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1RFU_ARTAL_FROM.setDataSourceName("");
	lblT1RFU_ARTAL_FROM.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1RFU_ARTAL_FROM.setVerticalAlignment (SwingConstants.CENTER);
	lblT1RFU_ARTAL_FROM.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1RFU_ARTAL_FROM,null);             
	} // end of initVSLabellblT1RFU_ARTAL_FROM()
	
	
	
	
	public void initVSTextFieldtxtT1RFU_ARTAL_FROM() { 
	txtT1RFU_ARTAL_FROM.setName ("txtT1RFU_ARTAL_FROM");
		txtT1RFU_ARTAL_FROM.setForeground(Color.black);
		txtT1RFU_ARTAL_FROM.setBackground(Color.white);
	txtT1RFU_ARTAL_FROM.setBounds (111, 69 , 78, 20);

txtT1RFU_ARTAL_FROM.setFont (new Font ("Helvetica", 0, 12));

	txtT1RFU_ARTAL_FROM.setTag ("_$$_");
 	txtT1RFU_ARTAL_FROM.setDataSourceName("datT1EmiR_Z_RFU");
	txtT1RFU_ARTAL_FROM.setDataFieldName("RFU_ARTAL_FROM");
	txtT1RFU_ARTAL_FROM.setTabOrder(14);
	txtT1RFU_ARTAL_FROM.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1RFU_ARTAL_FROM,null);             
	} // end of initVSTextFieldtxtT1RFU_ARTAL_FROM()
	
	
	
	
	
	
	
	
	public void initVSLabellblT1RFU_PERIOD_FROM() {
	lblT1RFU_PERIOD_FROM.setText("Period from");
	lblT1RFU_PERIOD_FROM.setAlignment(VSLabel.LEFT);
	lblT1RFU_PERIOD_FROM.setName ("lblT1RFU_PERIOD_FROM");
		lblT1RFU_PERIOD_FROM.setForeground(Color.black);
		lblT1RFU_PERIOD_FROM.setBackground(Color.lightGray);
	lblT1RFU_PERIOD_FROM.setBounds (7, 98 , 102, 18);

lblT1RFU_PERIOD_FROM.setFont (new Font ("Helvetica", 0, 12));

	lblT1RFU_PERIOD_FROM.setTag ("_$$_");
 	lblT1RFU_PERIOD_FROM.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1RFU_PERIOD_FROM.setDataSourceName("");
	lblT1RFU_PERIOD_FROM.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1RFU_PERIOD_FROM.setVerticalAlignment (SwingConstants.CENTER);
	lblT1RFU_PERIOD_FROM.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1RFU_PERIOD_FROM,null);             
	} // end of initVSLabellblT1RFU_PERIOD_FROM()
	
	
	
	
	public void initVSTextFieldtxtT1RFU_PERIOD_FROM() { 
	txtT1RFU_PERIOD_FROM.setName ("txtT1RFU_PERIOD_FROM");
		txtT1RFU_PERIOD_FROM.setForeground(Color.black);
		txtT1RFU_PERIOD_FROM.setBackground(Color.white);
	txtT1RFU_PERIOD_FROM.setBounds (111, 97 , 78, 20);

txtT1RFU_PERIOD_FROM.setFont (new Font ("Helvetica", 0, 12));

	txtT1RFU_PERIOD_FROM.setTag ("_$$_");
 	txtT1RFU_PERIOD_FROM.setDataSourceName("datT1EmiR_Z_RFU");
	txtT1RFU_PERIOD_FROM.setDataFieldName("RFU_PERIOD_FROM");
	txtT1RFU_PERIOD_FROM.setTabOrder(15);
	txtT1RFU_PERIOD_FROM.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1RFU_PERIOD_FROM,null);             
	} // end of initVSTextFieldtxtT1RFU_PERIOD_FROM()
	
	
	
	
	
	
	
	
	public void initVSLabellblT1RFU_KT2_FROM() {
	lblT1RFU_KT2_FROM.setText("Konto del 2 from");
	lblT1RFU_KT2_FROM.setAlignment(VSLabel.LEFT);
	lblT1RFU_KT2_FROM.setName ("lblT1RFU_KT2_FROM");
		lblT1RFU_KT2_FROM.setForeground(Color.black);
		lblT1RFU_KT2_FROM.setBackground(Color.lightGray);
	lblT1RFU_KT2_FROM.setBounds (7, 126 , 102, 18);

lblT1RFU_KT2_FROM.setFont (new Font ("Helvetica", 0, 12));

	lblT1RFU_KT2_FROM.setTag ("_$$_");
 	lblT1RFU_KT2_FROM.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1RFU_KT2_FROM.setDataSourceName("");
	lblT1RFU_KT2_FROM.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1RFU_KT2_FROM.setVerticalAlignment (SwingConstants.CENTER);
	lblT1RFU_KT2_FROM.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1RFU_KT2_FROM,null);             
	} // end of initVSLabellblT1RFU_KT2_FROM()
	
	
	
	
	public void initVSTextFieldtxtT1RFU_KT2_FROM() { 
	txtT1RFU_KT2_FROM.setName ("txtT1RFU_KT2_FROM");
		txtT1RFU_KT2_FROM.setForeground(Color.black);
		txtT1RFU_KT2_FROM.setBackground(Color.white);
	txtT1RFU_KT2_FROM.setBounds (111, 125 , 64, 20);

txtT1RFU_KT2_FROM.setFont (new Font ("Helvetica", 0, 12));

	txtT1RFU_KT2_FROM.setTag ("_$$_");
 	txtT1RFU_KT2_FROM.setDataSourceName("datT1EmiR_Z_RFU");
	txtT1RFU_KT2_FROM.setDataFieldName("RFU_KT2_FROM");
	txtT1RFU_KT2_FROM.setTabOrder(16);
	txtT1RFU_KT2_FROM.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1RFU_KT2_FROM,null);             
	} // end of initVSTextFieldtxtT1RFU_KT2_FROM()
	
	
	
	
	
	
	
	
	public void initVSLabellblT1RFU_KT2_TOM() {
	lblT1RFU_KT2_TOM.setText("Konto del 2 tom");
	lblT1RFU_KT2_TOM.setAlignment(VSLabel.LEFT);
	lblT1RFU_KT2_TOM.setName ("lblT1RFU_KT2_TOM");
		lblT1RFU_KT2_TOM.setForeground(Color.black);
		lblT1RFU_KT2_TOM.setBackground(Color.lightGray);
	lblT1RFU_KT2_TOM.setBounds (7, 154 , 102, 18);

lblT1RFU_KT2_TOM.setFont (new Font ("Helvetica", 0, 12));

	lblT1RFU_KT2_TOM.setTag ("_$$_");
 	lblT1RFU_KT2_TOM.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1RFU_KT2_TOM.setDataSourceName("");
	lblT1RFU_KT2_TOM.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1RFU_KT2_TOM.setVerticalAlignment (SwingConstants.CENTER);
	lblT1RFU_KT2_TOM.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1RFU_KT2_TOM,null);             
	} // end of initVSLabellblT1RFU_KT2_TOM()
	
	
	
	
	public void initVSTextFieldtxtT1RFU_KT2_TOM() { 
	txtT1RFU_KT2_TOM.setName ("txtT1RFU_KT2_TOM");
		txtT1RFU_KT2_TOM.setForeground(Color.black);
		txtT1RFU_KT2_TOM.setBackground(Color.white);
	txtT1RFU_KT2_TOM.setBounds (111, 153 , 64, 20);

txtT1RFU_KT2_TOM.setFont (new Font ("Helvetica", 0, 12));

	txtT1RFU_KT2_TOM.setTag ("_$$_");
 	txtT1RFU_KT2_TOM.setDataSourceName("datT1EmiR_Z_RFU");
	txtT1RFU_KT2_TOM.setDataFieldName("RFU_KT2_TOM");
	txtT1RFU_KT2_TOM.setTabOrder(17);
	txtT1RFU_KT2_TOM.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1RFU_KT2_TOM,null);             
	} // end of initVSTextFieldtxtT1RFU_KT2_TOM()
	
	
	
	
	
	
	
	
	public void initVSLabellblT1RFU_NIVA_FROM() {
	lblT1RFU_NIVA_FROM.setText("Nivå from");
	lblT1RFU_NIVA_FROM.setAlignment(VSLabel.LEFT);
	lblT1RFU_NIVA_FROM.setName ("lblT1RFU_NIVA_FROM");
		lblT1RFU_NIVA_FROM.setForeground(Color.black);
		lblT1RFU_NIVA_FROM.setBackground(Color.lightGray);
	lblT1RFU_NIVA_FROM.setBounds (7, 182 , 102, 18);

lblT1RFU_NIVA_FROM.setFont (new Font ("Helvetica", 0, 12));

	lblT1RFU_NIVA_FROM.setTag ("_$$_");
 	lblT1RFU_NIVA_FROM.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1RFU_NIVA_FROM.setDataSourceName("");
	lblT1RFU_NIVA_FROM.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1RFU_NIVA_FROM.setVerticalAlignment (SwingConstants.CENTER);
	lblT1RFU_NIVA_FROM.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1RFU_NIVA_FROM,null);             
	} // end of initVSLabellblT1RFU_NIVA_FROM()
	
	
	
	
	public void initVSTextFieldtxtT1RFU_NIVA_FROM() { 
	txtT1RFU_NIVA_FROM.setName ("txtT1RFU_NIVA_FROM");
		txtT1RFU_NIVA_FROM.setForeground(Color.black);
		txtT1RFU_NIVA_FROM.setBackground(Color.white);
	txtT1RFU_NIVA_FROM.setBounds (111, 181 , 18, 20);

txtT1RFU_NIVA_FROM.setFont (new Font ("Helvetica", 0, 12));

	txtT1RFU_NIVA_FROM.setTag ("_$$_");
 	txtT1RFU_NIVA_FROM.setDataSourceName("datT1EmiR_Z_RFU");
	txtT1RFU_NIVA_FROM.setDataFieldName("RFU_NIVA_FROM");
	txtT1RFU_NIVA_FROM.setTabOrder(18);
	txtT1RFU_NIVA_FROM.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1RFU_NIVA_FROM,null);             
	} // end of initVSTextFieldtxtT1RFU_NIVA_FROM()
	
	
	
	
	
	
	
	
	
	public void initVSCheckboxchkT1RFU_SUMMERA_UNIVA() {
	chkT1RFU_SUMMERA_UNIVA.setText("");
	chkT1RFU_SUMMERA_UNIVA.setName ("chkT1RFU_SUMMERA_UNIVA");
		chkT1RFU_SUMMERA_UNIVA.setForeground(Color.black);
		chkT1RFU_SUMMERA_UNIVA.setBackground(Color.lightGray);
	chkT1RFU_SUMMERA_UNIVA.setBounds (111, 209 , 20, 20);

chkT1RFU_SUMMERA_UNIVA.setFont (new Font ("Helvetica", 0, 12));

	chkT1RFU_SUMMERA_UNIVA.setTag ("_$$_");
 	chkT1RFU_SUMMERA_UNIVA.setBorderPainted (false);
	chkT1RFU_SUMMERA_UNIVA.setDataSourceName("datT1EmiR_Z_RFU");
	chkT1RFU_SUMMERA_UNIVA.setDataFieldName ("RFU_SUMMERA_UNIVA");
	chkT1RFU_SUMMERA_UNIVA.setTabOrder(19);
	chkT1RFU_SUMMERA_UNIVA.setDisplayMode(VSQueryable.Data_Query);
        
      // container is form
add (chkT1RFU_SUMMERA_UNIVA,null);             
	} // end of initVSCheckBoxchkT1RFU_SUMMERA_UNIVA()
	
	
	
	
	
	
	public void initVSLabellblT1RFU_SUMMERA_UNIVA() {
	lblT1RFU_SUMMERA_UNIVA.setText("Summera under");
	lblT1RFU_SUMMERA_UNIVA.setAlignment(VSLabel.LEFT);
	lblT1RFU_SUMMERA_UNIVA.setName ("lblT1RFU_SUMMERA_UNIVA");
		lblT1RFU_SUMMERA_UNIVA.setForeground(Color.black);
		lblT1RFU_SUMMERA_UNIVA.setBackground(Color.lightGray);
	lblT1RFU_SUMMERA_UNIVA.setBounds (7, 210 , 102, 18);

lblT1RFU_SUMMERA_UNIVA.setFont (new Font ("Helvetica", 0, 12));

	lblT1RFU_SUMMERA_UNIVA.setTag ("_$$_");
 	lblT1RFU_SUMMERA_UNIVA.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1RFU_SUMMERA_UNIVA.setDataSourceName("");
	lblT1RFU_SUMMERA_UNIVA.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1RFU_SUMMERA_UNIVA.setVerticalAlignment (SwingConstants.CENTER);
	lblT1RFU_SUMMERA_UNIVA.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1RFU_SUMMERA_UNIVA,null);             
	} // end of initVSLabellblT1RFU_SUMMERA_UNIVA()
	
	
	
	
	
	
	public void initVSLabellblT1RFU_RAPPID() {
	lblT1RFU_RAPPID.setText("Rapport id");
	lblT1RFU_RAPPID.setAlignment(VSLabel.LEFT);
	lblT1RFU_RAPPID.setName ("lblT1RFU_RAPPID");
		lblT1RFU_RAPPID.setForeground(Color.black);
		lblT1RFU_RAPPID.setBackground(Color.lightGray);
	lblT1RFU_RAPPID.setBounds (7, 238 , 102, 18);

lblT1RFU_RAPPID.setFont (new Font ("Helvetica", 0, 12));

	lblT1RFU_RAPPID.setTag ("_$$_");
 	lblT1RFU_RAPPID.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1RFU_RAPPID.setDataSourceName("");
	lblT1RFU_RAPPID.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1RFU_RAPPID.setVerticalAlignment (SwingConstants.CENTER);
	lblT1RFU_RAPPID.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1RFU_RAPPID,null);             
	} // end of initVSLabellblT1RFU_RAPPID()
	
	
	
	
	public void initVSTextFieldtxtT1RFU_RAPPID() { 
	txtT1RFU_RAPPID.setName ("txtT1RFU_RAPPID");
		txtT1RFU_RAPPID.setForeground(Color.black);
		txtT1RFU_RAPPID.setBackground(Color.white);
	txtT1RFU_RAPPID.setBounds (111, 237 , 64, 20);

txtT1RFU_RAPPID.setFont (new Font ("Helvetica", 0, 12));

	txtT1RFU_RAPPID.setTag ("_$$_");
 	txtT1RFU_RAPPID.setDataSourceName("datT1EmiR_Z_RFU");
	txtT1RFU_RAPPID.setDataFieldName("RFU_RAPPID");
	txtT1RFU_RAPPID.setTabOrder(20);
	txtT1RFU_RAPPID.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1RFU_RAPPID,null);             
	} // end of initVSTextFieldtxtT1RFU_RAPPID()
	
	
	
	
	
	
	
	
	public void initVSLabellblT1RFU_UTDATA() {
	lblT1RFU_UTDATA.setText("Utdata");
	lblT1RFU_UTDATA.setAlignment(VSLabel.LEFT);
	lblT1RFU_UTDATA.setName ("lblT1RFU_UTDATA");
		lblT1RFU_UTDATA.setForeground(Color.black);
		lblT1RFU_UTDATA.setBackground(Color.lightGray);
	lblT1RFU_UTDATA.setBounds (7, 266 , 102, 18);

lblT1RFU_UTDATA.setFont (new Font ("Helvetica", 0, 12));

	lblT1RFU_UTDATA.setTag ("_$$_");
 	lblT1RFU_UTDATA.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1RFU_UTDATA.setDataSourceName("");
	lblT1RFU_UTDATA.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1RFU_UTDATA.setVerticalAlignment (SwingConstants.CENTER);
	lblT1RFU_UTDATA.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1RFU_UTDATA,null);             
	} // end of initVSLabellblT1RFU_UTDATA()
	
	
	
	
	public void initVSTextFieldtxtT1RFU_UTDATA() { 
	txtT1RFU_UTDATA.setName ("txtT1RFU_UTDATA");
		txtT1RFU_UTDATA.setForeground(Color.black);
		txtT1RFU_UTDATA.setBackground(Color.white);
	txtT1RFU_UTDATA.setBounds (111, 265 , 114, 20);

txtT1RFU_UTDATA.setFont (new Font ("Helvetica", 0, 12));

	txtT1RFU_UTDATA.setTag ("_$$_");
 	txtT1RFU_UTDATA.setDataSourceName("datT1EmiR_Z_RFU");
	txtT1RFU_UTDATA.setDataFieldName("RFU_UTDATA");
	txtT1RFU_UTDATA.setTabOrder(21);
	txtT1RFU_UTDATA.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1RFU_UTDATA,null);             
	} // end of initVSTextFieldtxtT1RFU_UTDATA()
	
	
	
	
	
	
	
	
	public void initVSLabellblT1RFU_RGHRSN() {
	lblT1RFU_RGHRSN.setText("RGHrsn");
	lblT1RFU_RGHRSN.setAlignment(VSLabel.LEFT);
	lblT1RFU_RGHRSN.setName ("lblT1RFU_RGHRSN");
		lblT1RFU_RGHRSN.setForeground(Color.black);
		lblT1RFU_RGHRSN.setBackground(Color.lightGray);
	lblT1RFU_RGHRSN.setBounds (7, 294 , 102, 18);

lblT1RFU_RGHRSN.setFont (new Font ("Helvetica", 0, 12));

	lblT1RFU_RGHRSN.setTag ("_$$_");
 	lblT1RFU_RGHRSN.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1RFU_RGHRSN.setDataSourceName("");
	lblT1RFU_RGHRSN.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1RFU_RGHRSN.setVerticalAlignment (SwingConstants.CENTER);
	lblT1RFU_RGHRSN.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1RFU_RGHRSN,null);             
	} // end of initVSLabellblT1RFU_RGHRSN()
	
	
	
	
	public void initVSTextFieldtxtT1RFU_RGHRSN() { 
	txtT1RFU_RGHRSN.setName ("txtT1RFU_RGHRSN");
		txtT1RFU_RGHRSN.setForeground(Color.black);
		txtT1RFU_RGHRSN.setBackground(Color.white);
	txtT1RFU_RGHRSN.setBounds (111, 293 , 78, 20);

txtT1RFU_RGHRSN.setFont (new Font ("Helvetica", 0, 12));

	txtT1RFU_RGHRSN.setTag ("_$$_");
 	txtT1RFU_RGHRSN.setDataSourceName("datT1EmiR_Z_RFU");
	txtT1RFU_RGHRSN.setDataFieldName("RFU_RGHRSN");
	txtT1RFU_RGHRSN.setTabOrder(22);
	txtT1RFU_RGHRSN.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1RFU_RGHRSN,null);             
	} // end of initVSTextFieldtxtT1RFU_RGHRSN()
	
	
	
	
	
	
	
	
	public void initVSLabellblT1RFU_BOLNR() {
	lblT1RFU_BOLNR.setText("Bolag");
	lblT1RFU_BOLNR.setAlignment(VSLabel.LEFT);
	lblT1RFU_BOLNR.setName ("lblT1RFU_BOLNR");
		lblT1RFU_BOLNR.setForeground(Color.black);
		lblT1RFU_BOLNR.setBackground(Color.lightGray);
	lblT1RFU_BOLNR.setBounds (7, 322 , 102, 18);

lblT1RFU_BOLNR.setFont (new Font ("Helvetica", 0, 12));

	lblT1RFU_BOLNR.setTag ("_$$_");
 	lblT1RFU_BOLNR.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1RFU_BOLNR.setDataSourceName("");
	lblT1RFU_BOLNR.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1RFU_BOLNR.setVerticalAlignment (SwingConstants.CENTER);
	lblT1RFU_BOLNR.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1RFU_BOLNR,null);             
	} // end of initVSLabellblT1RFU_BOLNR()
	
	
	
	
	public void initVSTextFieldtxtT1RFU_BOLNR() { 
	txtT1RFU_BOLNR.setName ("txtT1RFU_BOLNR");
		txtT1RFU_BOLNR.setForeground(Color.black);
		txtT1RFU_BOLNR.setBackground(Color.white);
	txtT1RFU_BOLNR.setBounds (111, 321 , 51, 20);

txtT1RFU_BOLNR.setFont (new Font ("Helvetica", 0, 12));

	txtT1RFU_BOLNR.setTag ("_$$_");
 	txtT1RFU_BOLNR.setDataSourceName("datT1EmiR_Z_RFU");
	txtT1RFU_BOLNR.setDataFieldName("RFU_BOLNR");
	txtT1RFU_BOLNR.setTabOrder(23);
	txtT1RFU_BOLNR.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1RFU_BOLNR,null);             
	} // end of initVSTextFieldtxtT1RFU_BOLNR()
	
	
	
	
	
	
	
	
	public void initVSLabellblT1RFU_BESKRIVNING() {
	lblT1RFU_BESKRIVNING.setText("Beskrivning.");
	lblT1RFU_BESKRIVNING.setAlignment(VSLabel.LEFT);
	lblT1RFU_BESKRIVNING.setName ("lblT1RFU_BESKRIVNING");
		lblT1RFU_BESKRIVNING.setForeground(Color.black);
		lblT1RFU_BESKRIVNING.setBackground(Color.lightGray);
	lblT1RFU_BESKRIVNING.setBounds (7, 350 , 102, 18);

lblT1RFU_BESKRIVNING.setFont (new Font ("Helvetica", 0, 12));

	lblT1RFU_BESKRIVNING.setTag ("_$$_");
 	lblT1RFU_BESKRIVNING.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1RFU_BESKRIVNING.setDataSourceName("");
	lblT1RFU_BESKRIVNING.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1RFU_BESKRIVNING.setVerticalAlignment (SwingConstants.CENTER);
	lblT1RFU_BESKRIVNING.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1RFU_BESKRIVNING,null);             
	} // end of initVSLabellblT1RFU_BESKRIVNING()
	
	
	
	
	public void initVSTextFieldtxtT1RFU_BESKRIVNING() { 
	txtT1RFU_BESKRIVNING.setName ("txtT1RFU_BESKRIVNING");
		txtT1RFU_BESKRIVNING.setForeground(Color.black);
		txtT1RFU_BESKRIVNING.setBackground(Color.white);
	txtT1RFU_BESKRIVNING.setBounds (111, 349 , 114, 20);

txtT1RFU_BESKRIVNING.setFont (new Font ("Helvetica", 0, 12));

	txtT1RFU_BESKRIVNING.setTag ("_$$_");
 	txtT1RFU_BESKRIVNING.setDataSourceName("datT1EmiR_Z_RFU");
	txtT1RFU_BESKRIVNING.setDataFieldName("RFU_BESKRIVNING");
	txtT1RFU_BESKRIVNING.setTabOrder(24);
	txtT1RFU_BESKRIVNING.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1RFU_BESKRIVNING,null);             
	} // end of initVSTextFieldtxtT1RFU_BESKRIVNING()
	
	
	
	
	
	
	
	
	public void initVSLabellblT1RFU_RAPPORTID() {
	lblT1RFU_RAPPORTID.setText("RapportID");
	lblT1RFU_RAPPORTID.setAlignment(VSLabel.LEFT);
	lblT1RFU_RAPPORTID.setName ("lblT1RFU_RAPPORTID");
		lblT1RFU_RAPPORTID.setForeground(Color.black);
		lblT1RFU_RAPPORTID.setBackground(Color.lightGray);
	lblT1RFU_RAPPORTID.setBounds (7, 378 , 102, 18);

lblT1RFU_RAPPORTID.setFont (new Font ("Helvetica", 0, 12));

	lblT1RFU_RAPPORTID.setTag ("_$$_");
 	lblT1RFU_RAPPORTID.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1RFU_RAPPORTID.setDataSourceName("");
	lblT1RFU_RAPPORTID.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1RFU_RAPPORTID.setVerticalAlignment (SwingConstants.CENTER);
	lblT1RFU_RAPPORTID.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1RFU_RAPPORTID,null);             
	} // end of initVSLabellblT1RFU_RAPPORTID()
	
	
	
	
	public void initVSTextFieldtxtT1RFU_RAPPORTID() { 
	txtT1RFU_RAPPORTID.setName ("txtT1RFU_RAPPORTID");
		txtT1RFU_RAPPORTID.setForeground(Color.black);
		txtT1RFU_RAPPORTID.setBackground(Color.white);
	txtT1RFU_RAPPORTID.setBounds (111, 377 , 114, 20);

txtT1RFU_RAPPORTID.setFont (new Font ("Helvetica", 0, 12));

	txtT1RFU_RAPPORTID.setTag ("_$$_");
 	txtT1RFU_RAPPORTID.setDataSourceName("datT1EmiR_Z_RFU");
	txtT1RFU_RAPPORTID.setDataFieldName("RFU_RAPPORTID");
	txtT1RFU_RAPPORTID.setTabOrder(25);
	txtT1RFU_RAPPORTID.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1RFU_RAPPORTID,null);             
	} // end of initVSTextFieldtxtT1RFU_RAPPORTID()
	
	
	
	
	
	
	
	
	 public void initVSDateChoicevsdT1RFU_DATETIME() {
	vsdT1RFU_DATETIME.setName ("vsdT1RFU_DATETIME");
		vsdT1RFU_DATETIME.setForeground(Color.black);
		vsdT1RFU_DATETIME.setBackground(Color.white);
	vsdT1RFU_DATETIME.setBounds (341, 42 , 120, 20);

vsdT1RFU_DATETIME.setFont (new Font ("Helvetica", 0, 12));

	vsdT1RFU_DATETIME.setTag ("_$$_");
 	vsdT1RFU_DATETIME.setDataFieldName("RFU_DATETIME");
	vsdT1RFU_DATETIME.setDataSourceName("datT1EmiR_Z_RFU");
	vsdT1RFU_DATETIME.setTabOrder(26);
	vsdT1RFU_DATETIME.setToolTipText ("Körtid");
	vsdT1RFU_DATETIME.setDisplayMode(VSQueryable.Data_Query);
        
      // container is form
add (vsdT1RFU_DATETIME,null);             
	} // end of initVSDateChoicevsdT1RFU_DATETIME()
	
	
	
	
	
	
	
	public void initVSLabellblT1RFU_DATETIME() {
	lblT1RFU_DATETIME.setText("Körtid");
	lblT1RFU_DATETIME.setAlignment(VSLabel.LEFT);
	lblT1RFU_DATETIME.setName ("lblT1RFU_DATETIME");
		lblT1RFU_DATETIME.setForeground(Color.black);
		lblT1RFU_DATETIME.setBackground(Color.lightGray);
	lblT1RFU_DATETIME.setBounds (237, 42 , 102, 18);

lblT1RFU_DATETIME.setFont (new Font ("Helvetica", 0, 12));

	lblT1RFU_DATETIME.setTag ("_$$_");
 	lblT1RFU_DATETIME.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1RFU_DATETIME.setDataSourceName("");
	lblT1RFU_DATETIME.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1RFU_DATETIME.setVerticalAlignment (SwingConstants.CENTER);
	lblT1RFU_DATETIME.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1RFU_DATETIME,null);             
	} // end of initVSLabellblT1RFU_DATETIME()
	
	public void initVSJavaDataControldatT1EmiR_Z_RFU() { 
	datT1EmiR_Z_RFU.setLabel ("");
	datT1EmiR_Z_RFU.setQueryInfo(new VSQueryInfo("EmiR_Z_RFU", "", "", "", false));
	datT1EmiR_Z_RFU.setName ("datT1EmiR_Z_RFU");
		datT1EmiR_Z_RFU.setForeground(Color.black);
		datT1EmiR_Z_RFU.setBackground(Color.white);
	datT1EmiR_Z_RFU.setBounds (140, 420 , 201, 25);

datT1EmiR_Z_RFU.setFont (new Font ("Helvetica", 0, 12));
	datT1EmiR_Z_RFU.setVisible(false);

	datT1EmiR_Z_RFU.setTag ("_$$_");
 	datT1EmiR_Z_RFU.setTabOrder(27);
	datT1EmiR_Z_RFU.setTabStop (false);
	setRootDataControl(datT1EmiR_Z_RFU);
	datT1EmiR_Z_RFU.setMaxRowsPerFetch(1);
	datT1EmiR_Z_RFU.setSaveMode (VSJavaDataControl.SAVE_IMMEDIATE);
	datT1EmiR_Z_RFU.setDataDependency (false, false);
        


      // container is form
add (datT1EmiR_Z_RFU,null);             
	
	
	} // end of initVSJavaDataControldatT1EmiR_Z_RFU()
	
	
	
	
	
	
}