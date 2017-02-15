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
 * fCurrency_CUR
 */
abstract class fCurrency_CURBase extends VSForm {
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
		VSLabel lblT1CUR_Client = new VSLabel();
		VSTextField txtT1CUR_Client = new VSTextField();
		VSLabel lblT1CUR_CurrencyCode = new VSLabel();
		VSTextField txtT1CUR_CurrencyCode = new VSTextField();
		VSLabel lblT1CUR_ExchangeRate = new VSLabel();
		VSTextField txtT1CUR_ExchangeRate = new VSTextField();
		VSLabel lblT1CUR_NumberOfOrders = new VSLabel();
		VSTextField txtT1CUR_NumberOfOrders = new VSTextField();
		VSLabel lblT1CUR_OrderValueUSD = new VSLabel();
		VSTextField txtT1CUR_OrderValueUSD = new VSTextField();
		VSLabel lblT1CUR_OrderAmountAverage = new VSLabel();
		VSTextField txtT1CUR_OrderAmountAverage = new VSTextField();
		VSLabel lblT1CUR_Image = new VSLabel();
		VSTextField txtT1CUR_Image = new VSTextField();
		VSPickChoice pckT1CUR_Client_RelatedTo = new VSPickChoice();
		VSLabel lblT1CUR_Client_RelatedTo = new VSLabel();
		VSPickChoice pckT1CUR_CurrencyCode_RelatedTo = new VSPickChoice();
		VSLabel lblT1CUR_CurrencyCode_RelatedTo = new VSLabel();
		VSJavaDataControl datT1Currency_CUR = new VSJavaDataControl("datT1Currency_CUR");    
		VSPick T2Currency_CURPickObj_datT1Currency_CUR = null;
	
	//END_FORM_VAR_DECL}}

	public fCurrency_CURBase() throws VSException, java.beans.PropertyVetoException {
		//{{FORM_OBJ_CTOR
			setLayout (null);
		
		beforeFormInitialize();
		
		setName("fCurrency_CUR");
		
		
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
			
			initVSLabellblT1CUR_Client();
			
			 initVSTextFieldtxtT1CUR_Client();
			
			initVSLabellblT1CUR_CurrencyCode();
			
			 initVSTextFieldtxtT1CUR_CurrencyCode();
			
			initVSLabellblT1CUR_ExchangeRate();
			
			 initVSTextFieldtxtT1CUR_ExchangeRate();
			
			initVSLabellblT1CUR_NumberOfOrders();
			
			 initVSTextFieldtxtT1CUR_NumberOfOrders();
			
			initVSLabellblT1CUR_OrderValueUSD();
			
			 initVSTextFieldtxtT1CUR_OrderValueUSD();
			
			initVSLabellblT1CUR_OrderAmountAverage();
			
			 initVSTextFieldtxtT1CUR_OrderAmountAverage();
			
			initVSLabellblT1CUR_Image();
			
			 initVSTextFieldtxtT1CUR_Image();
			
			initVSPickChoicepckT1CUR_Client_RelatedTo();		
			
			initVSLabellblT1CUR_Client_RelatedTo();
			
			initVSPickChoicepckT1CUR_CurrencyCode_RelatedTo();		
			
			initVSLabellblT1CUR_CurrencyCode_RelatedTo();
			
			initVSJavaDataControldatT1Currency_CUR();
			
				
		
			setBounds (0, 0, 579, 500);
		
			setTitle ("Currency_CUR");
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
	
	
	
	
	
	
	
	
	
	
	public void initVSLabellblT1CUR_Client() {
	lblT1CUR_Client.setText("CUR_Client");
	lblT1CUR_Client.setAlignment(VSLabel.LEFT);
	lblT1CUR_Client.setName ("lblT1CUR_Client");
		lblT1CUR_Client.setForeground(Color.black);
		lblT1CUR_Client.setBackground(Color.lightGray);
	lblT1CUR_Client.setBounds (7, 42 , 102, 18);

lblT1CUR_Client.setFont (new Font ("Helvetica", 0, 12));

	lblT1CUR_Client.setTag ("_$$_");
 	lblT1CUR_Client.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1CUR_Client.setDataSourceName("");
	lblT1CUR_Client.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1CUR_Client.setVerticalAlignment (SwingConstants.CENTER);
	lblT1CUR_Client.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1CUR_Client,null);             
	} // end of initVSLabellblT1CUR_Client()
	
	
	
	
	public void initVSTextFieldtxtT1CUR_Client() { 
	txtT1CUR_Client.setName ("txtT1CUR_Client");
		txtT1CUR_Client.setForeground(Color.black);
		txtT1CUR_Client.setBackground(Color.white);
	txtT1CUR_Client.setBounds (111, 41 , 44, 20);

txtT1CUR_Client.setFont (new Font ("Helvetica", 0, 12));

	txtT1CUR_Client.setTag ("_$$_");
 	txtT1CUR_Client.setDataSourceName("datT1Currency_CUR");
	txtT1CUR_Client.setDataFieldName("CUR_Client");
	txtT1CUR_Client.setTabOrder(13);
	txtT1CUR_Client.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1CUR_Client,null);             
	} // end of initVSTextFieldtxtT1CUR_Client()
	
	
	
	
	
	
	
	
	public void initVSLabellblT1CUR_CurrencyCode() {
	lblT1CUR_CurrencyCode.setText("Currency Code");
	lblT1CUR_CurrencyCode.setAlignment(VSLabel.LEFT);
	lblT1CUR_CurrencyCode.setName ("lblT1CUR_CurrencyCode");
		lblT1CUR_CurrencyCode.setForeground(Color.black);
		lblT1CUR_CurrencyCode.setBackground(Color.lightGray);
	lblT1CUR_CurrencyCode.setBounds (7, 70 , 102, 18);

lblT1CUR_CurrencyCode.setFont (new Font ("Helvetica", 0, 12));

	lblT1CUR_CurrencyCode.setTag ("_$$_");
 	lblT1CUR_CurrencyCode.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1CUR_CurrencyCode.setDataSourceName("");
	lblT1CUR_CurrencyCode.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1CUR_CurrencyCode.setVerticalAlignment (SwingConstants.CENTER);
	lblT1CUR_CurrencyCode.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1CUR_CurrencyCode,null);             
	} // end of initVSLabellblT1CUR_CurrencyCode()
	
	
	
	
	public void initVSTextFieldtxtT1CUR_CurrencyCode() { 
	txtT1CUR_CurrencyCode.setName ("txtT1CUR_CurrencyCode");
		txtT1CUR_CurrencyCode.setForeground(Color.black);
		txtT1CUR_CurrencyCode.setBackground(Color.white);
	txtT1CUR_CurrencyCode.setBounds (111, 69 , 31, 20);

txtT1CUR_CurrencyCode.setFont (new Font ("Helvetica", 0, 12));

	txtT1CUR_CurrencyCode.setTag ("_$$_");
 	txtT1CUR_CurrencyCode.setDataSourceName("datT1Currency_CUR");
	txtT1CUR_CurrencyCode.setDataFieldName("CUR_CurrencyCode");
	txtT1CUR_CurrencyCode.setTabOrder(14);
	txtT1CUR_CurrencyCode.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1CUR_CurrencyCode,null);             
	} // end of initVSTextFieldtxtT1CUR_CurrencyCode()
	
	
	
	
	
	
	
	
	public void initVSLabellblT1CUR_ExchangeRate() {
	lblT1CUR_ExchangeRate.setText("Exchange Rate");
	lblT1CUR_ExchangeRate.setAlignment(VSLabel.LEFT);
	lblT1CUR_ExchangeRate.setName ("lblT1CUR_ExchangeRate");
		lblT1CUR_ExchangeRate.setForeground(Color.black);
		lblT1CUR_ExchangeRate.setBackground(Color.lightGray);
	lblT1CUR_ExchangeRate.setBounds (7, 98 , 102, 18);

lblT1CUR_ExchangeRate.setFont (new Font ("Helvetica", 0, 12));

	lblT1CUR_ExchangeRate.setTag ("_$$_");
 	lblT1CUR_ExchangeRate.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1CUR_ExchangeRate.setDataSourceName("");
	lblT1CUR_ExchangeRate.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1CUR_ExchangeRate.setVerticalAlignment (SwingConstants.CENTER);
	lblT1CUR_ExchangeRate.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1CUR_ExchangeRate,null);             
	} // end of initVSLabellblT1CUR_ExchangeRate()
	
	
	
	
	public void initVSTextFieldtxtT1CUR_ExchangeRate() { 
	txtT1CUR_ExchangeRate.setName ("txtT1CUR_ExchangeRate");
		txtT1CUR_ExchangeRate.setForeground(Color.black);
		txtT1CUR_ExchangeRate.setBackground(Color.white);
	txtT1CUR_ExchangeRate.setBounds (111, 97 , 11, 20);

txtT1CUR_ExchangeRate.setFont (new Font ("Helvetica", 0, 12));

	txtT1CUR_ExchangeRate.setTag ("_$$_");
 	txtT1CUR_ExchangeRate.setDataSourceName("datT1Currency_CUR");
	txtT1CUR_ExchangeRate.setDataFieldName("CUR_ExchangeRate");
	txtT1CUR_ExchangeRate.setTabOrder(15);
	txtT1CUR_ExchangeRate.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1CUR_ExchangeRate,null);             
	} // end of initVSTextFieldtxtT1CUR_ExchangeRate()
	
	
	
	
	
	
	
	
	public void initVSLabellblT1CUR_NumberOfOrders() {
	lblT1CUR_NumberOfOrders.setText("Number Of Orders");
	lblT1CUR_NumberOfOrders.setAlignment(VSLabel.LEFT);
	lblT1CUR_NumberOfOrders.setName ("lblT1CUR_NumberOfOrders");
		lblT1CUR_NumberOfOrders.setForeground(Color.black);
		lblT1CUR_NumberOfOrders.setBackground(Color.lightGray);
	lblT1CUR_NumberOfOrders.setBounds (7, 126 , 102, 18);

lblT1CUR_NumberOfOrders.setFont (new Font ("Helvetica", 0, 12));

	lblT1CUR_NumberOfOrders.setTag ("_$$_");
 	lblT1CUR_NumberOfOrders.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1CUR_NumberOfOrders.setDataSourceName("");
	lblT1CUR_NumberOfOrders.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1CUR_NumberOfOrders.setVerticalAlignment (SwingConstants.CENTER);
	lblT1CUR_NumberOfOrders.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1CUR_NumberOfOrders,null);             
	} // end of initVSLabellblT1CUR_NumberOfOrders()
	
	
	
	
	public void initVSTextFieldtxtT1CUR_NumberOfOrders() { 
	txtT1CUR_NumberOfOrders.setName ("txtT1CUR_NumberOfOrders");
		txtT1CUR_NumberOfOrders.setForeground(Color.black);
		txtT1CUR_NumberOfOrders.setBackground(Color.white);
	txtT1CUR_NumberOfOrders.setBounds (111, 125 , 51, 20);

txtT1CUR_NumberOfOrders.setFont (new Font ("Helvetica", 0, 12));

	txtT1CUR_NumberOfOrders.setTag ("_$$_");
 	txtT1CUR_NumberOfOrders.setDataSourceName("datT1Currency_CUR");
	txtT1CUR_NumberOfOrders.setDataFieldName("CUR_NumberOfOrders");
	txtT1CUR_NumberOfOrders.setTabOrder(16);
	txtT1CUR_NumberOfOrders.setDisplayMode(VSQueryable.Data);
        		
      // container is form
add (txtT1CUR_NumberOfOrders,null);             
	} // end of initVSTextFieldtxtT1CUR_NumberOfOrders()
	
	
	
	
	
	
	
	
	public void initVSLabellblT1CUR_OrderValueUSD() {
	lblT1CUR_OrderValueUSD.setText("Order Value USD22");
	lblT1CUR_OrderValueUSD.setAlignment(VSLabel.LEFT);
	lblT1CUR_OrderValueUSD.setName ("lblT1CUR_OrderValueUSD");
		lblT1CUR_OrderValueUSD.setForeground(Color.black);
		lblT1CUR_OrderValueUSD.setBackground(Color.lightGray);
	lblT1CUR_OrderValueUSD.setBounds (7, 154 , 102, 18);

lblT1CUR_OrderValueUSD.setFont (new Font ("Helvetica", 0, 12));

	lblT1CUR_OrderValueUSD.setTag ("_$$_");
 	lblT1CUR_OrderValueUSD.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1CUR_OrderValueUSD.setDataSourceName("");
	lblT1CUR_OrderValueUSD.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1CUR_OrderValueUSD.setVerticalAlignment (SwingConstants.CENTER);
	lblT1CUR_OrderValueUSD.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1CUR_OrderValueUSD,null);             
	} // end of initVSLabellblT1CUR_OrderValueUSD()
	
	
	
	
	public void initVSTextFieldtxtT1CUR_OrderValueUSD() { 
	txtT1CUR_OrderValueUSD.setName ("txtT1CUR_OrderValueUSD");
		txtT1CUR_OrderValueUSD.setForeground(Color.black);
		txtT1CUR_OrderValueUSD.setBackground(Color.white);
	txtT1CUR_OrderValueUSD.setBounds (111, 153 , 11, 20);

txtT1CUR_OrderValueUSD.setFont (new Font ("Helvetica", 0, 12));

	txtT1CUR_OrderValueUSD.setTag ("_$$_");
 	txtT1CUR_OrderValueUSD.setDataSourceName("datT1Currency_CUR");
	txtT1CUR_OrderValueUSD.setDataFieldName("CUR_OrderValueUSD");
	txtT1CUR_OrderValueUSD.setTabOrder(17);
	txtT1CUR_OrderValueUSD.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1CUR_OrderValueUSD,null);             
	} // end of initVSTextFieldtxtT1CUR_OrderValueUSD()
	
	
	
	
	
	
	
	
	public void initVSLabellblT1CUR_OrderAmountAverage() {
	lblT1CUR_OrderAmountAverage.setText("Order Amount Average USD");
	lblT1CUR_OrderAmountAverage.setAlignment(VSLabel.LEFT);
	lblT1CUR_OrderAmountAverage.setName ("lblT1CUR_OrderAmountAverage");
		lblT1CUR_OrderAmountAverage.setForeground(Color.black);
		lblT1CUR_OrderAmountAverage.setBackground(Color.lightGray);
	lblT1CUR_OrderAmountAverage.setBounds (7, 182 , 102, 18);

lblT1CUR_OrderAmountAverage.setFont (new Font ("Helvetica", 0, 12));

	lblT1CUR_OrderAmountAverage.setTag ("_$$_");
 	lblT1CUR_OrderAmountAverage.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1CUR_OrderAmountAverage.setDataSourceName("");
	lblT1CUR_OrderAmountAverage.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1CUR_OrderAmountAverage.setVerticalAlignment (SwingConstants.CENTER);
	lblT1CUR_OrderAmountAverage.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1CUR_OrderAmountAverage,null);             
	} // end of initVSLabellblT1CUR_OrderAmountAverage()
	
	
	
	
	public void initVSTextFieldtxtT1CUR_OrderAmountAverage() { 
	txtT1CUR_OrderAmountAverage.setName ("txtT1CUR_OrderAmountAverage");
		txtT1CUR_OrderAmountAverage.setForeground(Color.black);
		txtT1CUR_OrderAmountAverage.setBackground(Color.white);
	txtT1CUR_OrderAmountAverage.setBounds (111, 181 , 11, 20);

txtT1CUR_OrderAmountAverage.setFont (new Font ("Helvetica", 0, 12));

	txtT1CUR_OrderAmountAverage.setTag ("_$$_");
 	txtT1CUR_OrderAmountAverage.setDataSourceName("datT1Currency_CUR");
	txtT1CUR_OrderAmountAverage.setDataFieldName("CUR_OrderAmountAverage");
	txtT1CUR_OrderAmountAverage.setTabOrder(18);
	txtT1CUR_OrderAmountAverage.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1CUR_OrderAmountAverage,null);             
	} // end of initVSTextFieldtxtT1CUR_OrderAmountAverage()
	
	
	
	
	
	
	
	
	public void initVSLabellblT1CUR_Image() {
	lblT1CUR_Image.setText("Image");
	lblT1CUR_Image.setAlignment(VSLabel.LEFT);
	lblT1CUR_Image.setName ("lblT1CUR_Image");
		lblT1CUR_Image.setForeground(Color.black);
		lblT1CUR_Image.setBackground(Color.lightGray);
	lblT1CUR_Image.setBounds (7, 210 , 102, 18);

lblT1CUR_Image.setFont (new Font ("Helvetica", 0, 12));

	lblT1CUR_Image.setTag ("_$$_");
 	lblT1CUR_Image.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1CUR_Image.setDataSourceName("");
	lblT1CUR_Image.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1CUR_Image.setVerticalAlignment (SwingConstants.CENTER);
	lblT1CUR_Image.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1CUR_Image,null);             
	} // end of initVSLabellblT1CUR_Image()
	
	
	
	
	public void initVSTextFieldtxtT1CUR_Image() { 
	txtT1CUR_Image.setName ("txtT1CUR_Image");
		txtT1CUR_Image.setForeground(Color.black);
		txtT1CUR_Image.setBackground(Color.white);
	txtT1CUR_Image.setBounds (111, 209 , 114, 20);

txtT1CUR_Image.setFont (new Font ("Helvetica", 0, 12));

	txtT1CUR_Image.setTag ("_$$_");
 	txtT1CUR_Image.setDataSourceName("datT1Currency_CUR");
	txtT1CUR_Image.setDataFieldName("CUR_Image");
	txtT1CUR_Image.setTabOrder(19);
	txtT1CUR_Image.setDisplayMode(VSQueryable.Data);
        		
      // container is form
add (txtT1CUR_Image,null);             
	} // end of initVSTextFieldtxtT1CUR_Image()
	
	
	
	
	
	
	
	
	
	public void initVSPickChoicepckT1CUR_Client_RelatedTo() {		
	
	pckT1CUR_Client_RelatedTo.setName ("pckT1CUR_Client_RelatedTo");
		pckT1CUR_Client_RelatedTo.setForeground(Color.black);
		pckT1CUR_Client_RelatedTo.setBackground(Color.white);
	pckT1CUR_Client_RelatedTo.setBounds (111, 238 , 120, 20);

pckT1CUR_Client_RelatedTo.setFont (new Font ("Helvetica", 0, 12));

	pckT1CUR_Client_RelatedTo.setTag ("_$$_");
 	pckT1CUR_Client_RelatedTo.setDataFieldName("CUR_Client_RelatedTo");
	pckT1CUR_Client_RelatedTo.setPick("T2Currency_CURPickObj_datT1Currency_CUR");
	pckT1CUR_Client_RelatedTo.setDataSourceName("datT1Currency_CUR");
	pckT1CUR_Client_RelatedTo.setTabOrder(20);
	pckT1CUR_Client_RelatedTo.setToolTipText ("CUR_Client_RelatedTo");
	pckT1CUR_Client_RelatedTo.setDisplayMode(VSQueryable.Data_Query);
        
      // container is form
add (pckT1CUR_Client_RelatedTo,null);             
	} // end of initVSPickChoicepckT1CUR_Client_RelatedTo()
	
	
	
	
	
	
	public void initVSLabellblT1CUR_Client_RelatedTo() {
	lblT1CUR_Client_RelatedTo.setText("CUR_Client_RelatedTo");
	lblT1CUR_Client_RelatedTo.setAlignment(VSLabel.LEFT);
	lblT1CUR_Client_RelatedTo.setName ("lblT1CUR_Client_RelatedTo");
		lblT1CUR_Client_RelatedTo.setForeground(Color.black);
		lblT1CUR_Client_RelatedTo.setBackground(Color.lightGray);
	lblT1CUR_Client_RelatedTo.setBounds (7, 238 , 102, 18);

lblT1CUR_Client_RelatedTo.setFont (new Font ("Helvetica", 0, 12));

	lblT1CUR_Client_RelatedTo.setTag ("_$$_");
 	lblT1CUR_Client_RelatedTo.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1CUR_Client_RelatedTo.setDataSourceName("");
	lblT1CUR_Client_RelatedTo.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1CUR_Client_RelatedTo.setVerticalAlignment (SwingConstants.CENTER);
	lblT1CUR_Client_RelatedTo.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1CUR_Client_RelatedTo,null);             
	} // end of initVSLabellblT1CUR_Client_RelatedTo()
	
	
	
	
	
	
	
	public void initVSPickChoicepckT1CUR_CurrencyCode_RelatedTo() {		
	
	pckT1CUR_CurrencyCode_RelatedTo.setName ("pckT1CUR_CurrencyCode_RelatedTo");
		pckT1CUR_CurrencyCode_RelatedTo.setForeground(Color.black);
		pckT1CUR_CurrencyCode_RelatedTo.setBackground(Color.white);
	pckT1CUR_CurrencyCode_RelatedTo.setBounds (111, 263 , 120, 20);

pckT1CUR_CurrencyCode_RelatedTo.setFont (new Font ("Helvetica", 0, 12));

	pckT1CUR_CurrencyCode_RelatedTo.setTag ("_$$_");
 	pckT1CUR_CurrencyCode_RelatedTo.setDataFieldName("CUR_CurrencyCode_RelatedTo");
	pckT1CUR_CurrencyCode_RelatedTo.setPick("T2Currency_CURPickObj_datT1Currency_CUR");
	pckT1CUR_CurrencyCode_RelatedTo.setDataSourceName("datT1Currency_CUR");
	pckT1CUR_CurrencyCode_RelatedTo.setTabOrder(21);
	pckT1CUR_CurrencyCode_RelatedTo.setToolTipText ("CurrencyCode_RelatedTo");
	pckT1CUR_CurrencyCode_RelatedTo.setDisplayMode(VSQueryable.Data_Query);
        
      // container is form
add (pckT1CUR_CurrencyCode_RelatedTo,null);             
	} // end of initVSPickChoicepckT1CUR_CurrencyCode_RelatedTo()
	
	
	
	
	
	
	public void initVSLabellblT1CUR_CurrencyCode_RelatedTo() {
	lblT1CUR_CurrencyCode_RelatedTo.setText("CurrencyCode_RelatedTo");
	lblT1CUR_CurrencyCode_RelatedTo.setAlignment(VSLabel.LEFT);
	lblT1CUR_CurrencyCode_RelatedTo.setName ("lblT1CUR_CurrencyCode_RelatedTo");
		lblT1CUR_CurrencyCode_RelatedTo.setForeground(Color.black);
		lblT1CUR_CurrencyCode_RelatedTo.setBackground(Color.lightGray);
	lblT1CUR_CurrencyCode_RelatedTo.setBounds (7, 263 , 102, 18);

lblT1CUR_CurrencyCode_RelatedTo.setFont (new Font ("Helvetica", 0, 12));

	lblT1CUR_CurrencyCode_RelatedTo.setTag ("_$$_");
 	lblT1CUR_CurrencyCode_RelatedTo.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1CUR_CurrencyCode_RelatedTo.setDataSourceName("");
	lblT1CUR_CurrencyCode_RelatedTo.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1CUR_CurrencyCode_RelatedTo.setVerticalAlignment (SwingConstants.CENTER);
	lblT1CUR_CurrencyCode_RelatedTo.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1CUR_CurrencyCode_RelatedTo,null);             
	} // end of initVSLabellblT1CUR_CurrencyCode_RelatedTo()
	
	public void initVSJavaDataControldatT1Currency_CUR() { 
	datT1Currency_CUR.setLabel ("Currency_CUR");
	datT1Currency_CUR.setQueryInfo(new VSQueryInfo("Currency_CUR", "", "", "", false));
	datT1Currency_CUR.setName ("datT1Currency_CUR");
		datT1Currency_CUR.setForeground(Color.black);
		datT1Currency_CUR.setBackground(Color.white);
	datT1Currency_CUR.setBounds (140, 420 , 201, 25);

datT1Currency_CUR.setFont (new Font ("Helvetica", 0, 12));
	datT1Currency_CUR.setVisible(false);

	datT1Currency_CUR.setTag ("_$$_");
 	datT1Currency_CUR.setTabOrder(22);
	datT1Currency_CUR.setTabStop (false);
	setRootDataControl(datT1Currency_CUR);
	datT1Currency_CUR.setMaxRowsPerFetch(1);
	datT1Currency_CUR.setSaveMode (VSJavaDataControl.SAVE_IMMEDIATE);
	datT1Currency_CUR.setDataDependency (false, false);
        


      // container is form
add (datT1Currency_CUR,null);             
	
	
	T2Currency_CURPickObj_datT1Currency_CUR = new VSPick ("T2Currency_CURPickObj_datT1Currency_CUR", "datT1Currency_CUR",
					"Currency_CUR", "", "", "[CUR_Client] = [?CUR_Client_RelatedTo] and [CUR_CurrencyCode] = [?CUR_CurrencyCode_RelatedTo]", "", "CUR_Client, CUR_CurrencyCode, CUR_ExchangeRate, CUR_NumberOfOrders, CUR_OrderValueUSD, CUR_OrderAmountAverage, CUR_Image, CUR_Client_RelatedTo, CUR_CurrencyCode_RelatedTo", "genericPick");
	T2Currency_CURPickObj_datT1Currency_CUR.setParentTableAlias("");


	addPick(T2Currency_CURPickObj_datT1Currency_CUR);
                    T2Currency_CURPickObj_datT1Currency_CUR.setStyle(VSPick.STYLE_DROPDOWN);

	} // end of initVSJavaDataControldatT1Currency_CUR()
	
	
	
	
	
	
}