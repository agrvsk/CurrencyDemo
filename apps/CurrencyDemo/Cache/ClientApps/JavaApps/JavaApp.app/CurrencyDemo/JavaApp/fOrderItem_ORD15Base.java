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
 * fOrderItem_ORD15
 */
abstract class fOrderItem_ORD15Base extends VSForm {
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
		VSPickChoice pckT1ORD_Client = new VSPickChoice();
		VSLabel lblT1ORD_Client = new VSLabel();
		VSLabel lblT1ORD_OrderId = new VSLabel();
		VSTextField txtT1ORD_OrderId = new VSTextField();
		VSPickChoice pckT1ORD_Month = new VSPickChoice();
		VSLabel lblT1ORD_Month = new VSLabel();
		VSPickChoice pckT1ORD_CurrencyCode = new VSPickChoice();
		VSLabel lblT1ORD_CurrencyCode = new VSLabel();
		VSLabel lblT1ORD_AmountInLocalCurrency = new VSLabel();
		VSTextField txtT1ORD_AmountInLocalCurrency = new VSTextField();
		VSLabel lblT1ORD_AmountInUSD = new VSLabel();
		VSTextField txtT1ORD_AmountInUSD = new VSTextField();
		VSLabel lblT1ORD_ExchangeRate = new VSLabel();
		VSTextField txtT1ORD_ExchangeRate = new VSTextField();
		VSChoice vscT1ORD_Approved = new VSChoice();
		VSLabel lblT1ORD_Approved = new VSLabel();
		VSJavaDataControl datT1OrderItem_ORD = new VSJavaDataControl("datT1OrderItem_ORD");    
		VSPick T3Currency_CURPickObj_datT1OrderItem_ORD = null;
		VSPick T2OrderBacklogPerMonth_OBTPickObj_datT1OrderItem_ORD = null;
	
	//END_FORM_VAR_DECL}}

	public fOrderItem_ORD15Base() throws VSException, java.beans.PropertyVetoException {
		//{{FORM_OBJ_CTOR
			setLayout (null);
		
		beforeFormInitialize();
		
		setName("fOrderItem_ORD15");
		
		
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
			
			initVSPickChoicepckT1ORD_Client();		
			
			initVSLabellblT1ORD_Client();
			
			initVSLabellblT1ORD_OrderId();
			
			 initVSTextFieldtxtT1ORD_OrderId();
			
			initVSPickChoicepckT1ORD_Month();		
			
			initVSLabellblT1ORD_Month();
			
			initVSPickChoicepckT1ORD_CurrencyCode();		
			
			initVSLabellblT1ORD_CurrencyCode();
			
			initVSLabellblT1ORD_AmountInLocalCurrency();
			
			 initVSTextFieldtxtT1ORD_AmountInLocalCurrency();
			
			initVSLabellblT1ORD_AmountInUSD();
			
			 initVSTextFieldtxtT1ORD_AmountInUSD();
			
			initVSLabellblT1ORD_ExchangeRate();
			
			 initVSTextFieldtxtT1ORD_ExchangeRate();
			
			 initVSChoicevscT1ORD_Approved();
			
			initVSLabellblT1ORD_Approved();
			
			initVSJavaDataControldatT1OrderItem_ORD();
			
				
		
			setBounds (0, 0, 579, 500);
		
			setTitle ("OrderItem_ORD");
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
	
	
	
	
	
	
	
	
	
	
	
	public void initVSPickChoicepckT1ORD_Client() {		
	
	pckT1ORD_Client.setName ("pckT1ORD_Client");
		pckT1ORD_Client.setForeground(Color.black);
		pckT1ORD_Client.setBackground(Color.white);
	pckT1ORD_Client.setBounds (111, 42 , 120, 20);

pckT1ORD_Client.setFont (new Font ("Helvetica", 0, 12));

	pckT1ORD_Client.setTag ("_$$_");
 	pckT1ORD_Client.setDataFieldName("ORD_Client");
	pckT1ORD_Client.setPick("T2OrderBacklogPerMonth_OBTPickObj_datT1OrderItem_ORD");
	pckT1ORD_Client.setDataSourceName("datT1OrderItem_ORD");
	pckT1ORD_Client.setTabOrder(13);
	pckT1ORD_Client.setToolTipText ("ORD_Client");
	pckT1ORD_Client.setDisplayMode(VSQueryable.Data_Query);
        
      // container is form
add (pckT1ORD_Client,null);             
	} // end of initVSPickChoicepckT1ORD_Client()
	
	
	
	
	
	
	public void initVSLabellblT1ORD_Client() {
	lblT1ORD_Client.setText("ORD_Client");
	lblT1ORD_Client.setAlignment(VSLabel.LEFT);
	lblT1ORD_Client.setName ("lblT1ORD_Client");
		lblT1ORD_Client.setForeground(Color.black);
		lblT1ORD_Client.setBackground(Color.lightGray);
	lblT1ORD_Client.setBounds (7, 42 , 102, 18);

lblT1ORD_Client.setFont (new Font ("Helvetica", 0, 12));

	lblT1ORD_Client.setTag ("_$$_");
 	lblT1ORD_Client.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1ORD_Client.setDataSourceName("");
	lblT1ORD_Client.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1ORD_Client.setVerticalAlignment (SwingConstants.CENTER);
	lblT1ORD_Client.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1ORD_Client,null);             
	} // end of initVSLabellblT1ORD_Client()
	
	
	
	
	
	
	public void initVSLabellblT1ORD_OrderId() {
	lblT1ORD_OrderId.setText("OrderId");
	lblT1ORD_OrderId.setAlignment(VSLabel.LEFT);
	lblT1ORD_OrderId.setName ("lblT1ORD_OrderId");
		lblT1ORD_OrderId.setForeground(Color.black);
		lblT1ORD_OrderId.setBackground(Color.lightGray);
	lblT1ORD_OrderId.setBounds (7, 67 , 102, 18);

lblT1ORD_OrderId.setFont (new Font ("Helvetica", 0, 12));

	lblT1ORD_OrderId.setTag ("_$$_");
 	lblT1ORD_OrderId.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1ORD_OrderId.setDataSourceName("");
	lblT1ORD_OrderId.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1ORD_OrderId.setVerticalAlignment (SwingConstants.CENTER);
	lblT1ORD_OrderId.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1ORD_OrderId,null);             
	} // end of initVSLabellblT1ORD_OrderId()
	
	
	
	
	public void initVSTextFieldtxtT1ORD_OrderId() { 
	txtT1ORD_OrderId.setName ("txtT1ORD_OrderId");
		txtT1ORD_OrderId.setForeground(Color.black);
		txtT1ORD_OrderId.setBackground(Color.white);
	txtT1ORD_OrderId.setBounds (111, 66 , 78, 20);

txtT1ORD_OrderId.setFont (new Font ("Helvetica", 0, 12));

	txtT1ORD_OrderId.setTag ("_$$_");
 	txtT1ORD_OrderId.setDataSourceName("datT1OrderItem_ORD");
	txtT1ORD_OrderId.setDataFieldName("ORD_OrderId");
	txtT1ORD_OrderId.setTabOrder(14);
	txtT1ORD_OrderId.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1ORD_OrderId,null);             
	} // end of initVSTextFieldtxtT1ORD_OrderId()
	
	
	
	
	
	
	
	
	
	public void initVSPickChoicepckT1ORD_Month() {		
	
	pckT1ORD_Month.setName ("pckT1ORD_Month");
		pckT1ORD_Month.setForeground(Color.black);
		pckT1ORD_Month.setBackground(Color.white);
	pckT1ORD_Month.setBounds (111, 95 , 120, 20);

pckT1ORD_Month.setFont (new Font ("Helvetica", 0, 12));

	pckT1ORD_Month.setTag ("_$$_");
 	pckT1ORD_Month.setDataFieldName("ORD_Month");
	pckT1ORD_Month.setPick("T2OrderBacklogPerMonth_OBTPickObj_datT1OrderItem_ORD");
	pckT1ORD_Month.setDataSourceName("datT1OrderItem_ORD");
	pckT1ORD_Month.setTabOrder(15);
	pckT1ORD_Month.setToolTipText ("Month");
	pckT1ORD_Month.setDisplayMode(VSQueryable.Data_Query);
        
      // container is form
add (pckT1ORD_Month,null);             
	} // end of initVSPickChoicepckT1ORD_Month()
	
	
	
	
	
	
	public void initVSLabellblT1ORD_Month() {
	lblT1ORD_Month.setText("Month");
	lblT1ORD_Month.setAlignment(VSLabel.LEFT);
	lblT1ORD_Month.setName ("lblT1ORD_Month");
		lblT1ORD_Month.setForeground(Color.black);
		lblT1ORD_Month.setBackground(Color.lightGray);
	lblT1ORD_Month.setBounds (7, 95 , 102, 18);

lblT1ORD_Month.setFont (new Font ("Helvetica", 0, 12));

	lblT1ORD_Month.setTag ("_$$_");
 	lblT1ORD_Month.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1ORD_Month.setDataSourceName("");
	lblT1ORD_Month.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1ORD_Month.setVerticalAlignment (SwingConstants.CENTER);
	lblT1ORD_Month.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1ORD_Month,null);             
	} // end of initVSLabellblT1ORD_Month()
	
	
	
	
	
	
	
	public void initVSPickChoicepckT1ORD_CurrencyCode() {		
	
	pckT1ORD_CurrencyCode.setName ("pckT1ORD_CurrencyCode");
		pckT1ORD_CurrencyCode.setForeground(Color.black);
		pckT1ORD_CurrencyCode.setBackground(Color.white);
	pckT1ORD_CurrencyCode.setBounds (111, 120 , 120, 20);

pckT1ORD_CurrencyCode.setFont (new Font ("Helvetica", 0, 12));

	pckT1ORD_CurrencyCode.setTag ("_$$_");
 	pckT1ORD_CurrencyCode.setDataFieldName("ORD_CurrencyCode");
	pckT1ORD_CurrencyCode.setPick("T3Currency_CURPickObj_datT1OrderItem_ORD");
	pckT1ORD_CurrencyCode.setDataSourceName("datT1OrderItem_ORD");
	pckT1ORD_CurrencyCode.setTabOrder(16);
	pckT1ORD_CurrencyCode.setToolTipText ("CurrencyCode");
	pckT1ORD_CurrencyCode.setDisplayMode(VSQueryable.Data_Query);
        
      // container is form
add (pckT1ORD_CurrencyCode,null);             
	} // end of initVSPickChoicepckT1ORD_CurrencyCode()
	
	
	
	
	
	
	public void initVSLabellblT1ORD_CurrencyCode() {
	lblT1ORD_CurrencyCode.setText("CurrencyCode");
	lblT1ORD_CurrencyCode.setAlignment(VSLabel.LEFT);
	lblT1ORD_CurrencyCode.setName ("lblT1ORD_CurrencyCode");
		lblT1ORD_CurrencyCode.setForeground(Color.black);
		lblT1ORD_CurrencyCode.setBackground(Color.lightGray);
	lblT1ORD_CurrencyCode.setBounds (7, 120 , 102, 18);

lblT1ORD_CurrencyCode.setFont (new Font ("Helvetica", 0, 12));

	lblT1ORD_CurrencyCode.setTag ("_$$_");
 	lblT1ORD_CurrencyCode.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1ORD_CurrencyCode.setDataSourceName("");
	lblT1ORD_CurrencyCode.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1ORD_CurrencyCode.setVerticalAlignment (SwingConstants.CENTER);
	lblT1ORD_CurrencyCode.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1ORD_CurrencyCode,null);             
	} // end of initVSLabellblT1ORD_CurrencyCode()
	
	
	
	
	
	
	public void initVSLabellblT1ORD_AmountInLocalCurrency() {
	lblT1ORD_AmountInLocalCurrency.setText("AmountInLocalCurrency");
	lblT1ORD_AmountInLocalCurrency.setAlignment(VSLabel.LEFT);
	lblT1ORD_AmountInLocalCurrency.setName ("lblT1ORD_AmountInLocalCurrency");
		lblT1ORD_AmountInLocalCurrency.setForeground(Color.black);
		lblT1ORD_AmountInLocalCurrency.setBackground(Color.lightGray);
	lblT1ORD_AmountInLocalCurrency.setBounds (7, 145 , 102, 18);

lblT1ORD_AmountInLocalCurrency.setFont (new Font ("Helvetica", 0, 12));

	lblT1ORD_AmountInLocalCurrency.setTag ("_$$_");
 	lblT1ORD_AmountInLocalCurrency.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1ORD_AmountInLocalCurrency.setDataSourceName("");
	lblT1ORD_AmountInLocalCurrency.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1ORD_AmountInLocalCurrency.setVerticalAlignment (SwingConstants.CENTER);
	lblT1ORD_AmountInLocalCurrency.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1ORD_AmountInLocalCurrency,null);             
	} // end of initVSLabellblT1ORD_AmountInLocalCurrency()
	
	
	
	
	public void initVSTextFieldtxtT1ORD_AmountInLocalCurrency() { 
	txtT1ORD_AmountInLocalCurrency.setName ("txtT1ORD_AmountInLocalCurrency");
		txtT1ORD_AmountInLocalCurrency.setForeground(Color.black);
		txtT1ORD_AmountInLocalCurrency.setBackground(Color.white);
	txtT1ORD_AmountInLocalCurrency.setBounds (111, 144 , 11, 20);

txtT1ORD_AmountInLocalCurrency.setFont (new Font ("Helvetica", 0, 12));

	txtT1ORD_AmountInLocalCurrency.setTag ("_$$_");
 	txtT1ORD_AmountInLocalCurrency.setDataSourceName("datT1OrderItem_ORD");
	txtT1ORD_AmountInLocalCurrency.setDataFieldName("ORD_AmountInLocalCurrency");
	txtT1ORD_AmountInLocalCurrency.setTabOrder(17);
	txtT1ORD_AmountInLocalCurrency.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1ORD_AmountInLocalCurrency,null);             
	} // end of initVSTextFieldtxtT1ORD_AmountInLocalCurrency()
	
	
	
	
	
	
	
	
	public void initVSLabellblT1ORD_AmountInUSD() {
	lblT1ORD_AmountInUSD.setText("AmountInUSD");
	lblT1ORD_AmountInUSD.setAlignment(VSLabel.LEFT);
	lblT1ORD_AmountInUSD.setName ("lblT1ORD_AmountInUSD");
		lblT1ORD_AmountInUSD.setForeground(Color.black);
		lblT1ORD_AmountInUSD.setBackground(Color.lightGray);
	lblT1ORD_AmountInUSD.setBounds (7, 173 , 102, 18);

lblT1ORD_AmountInUSD.setFont (new Font ("Helvetica", 0, 12));

	lblT1ORD_AmountInUSD.setTag ("_$$_");
 	lblT1ORD_AmountInUSD.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1ORD_AmountInUSD.setDataSourceName("");
	lblT1ORD_AmountInUSD.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1ORD_AmountInUSD.setVerticalAlignment (SwingConstants.CENTER);
	lblT1ORD_AmountInUSD.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1ORD_AmountInUSD,null);             
	} // end of initVSLabellblT1ORD_AmountInUSD()
	
	
	
	
	public void initVSTextFieldtxtT1ORD_AmountInUSD() { 
	txtT1ORD_AmountInUSD.setName ("txtT1ORD_AmountInUSD");
		txtT1ORD_AmountInUSD.setForeground(Color.black);
		txtT1ORD_AmountInUSD.setBackground(Color.white);
	txtT1ORD_AmountInUSD.setBounds (111, 172 , 11, 20);

txtT1ORD_AmountInUSD.setFont (new Font ("Helvetica", 0, 12));

	txtT1ORD_AmountInUSD.setTag ("_$$_");
 	txtT1ORD_AmountInUSD.setDataSourceName("datT1OrderItem_ORD");
	txtT1ORD_AmountInUSD.setDataFieldName("ORD_AmountInUSD");
	txtT1ORD_AmountInUSD.setTabOrder(18);
	txtT1ORD_AmountInUSD.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1ORD_AmountInUSD,null);             
	} // end of initVSTextFieldtxtT1ORD_AmountInUSD()
	
	
	
	
	
	
	
	
	public void initVSLabellblT1ORD_ExchangeRate() {
	lblT1ORD_ExchangeRate.setText("ORD_ExchangeRate");
	lblT1ORD_ExchangeRate.setAlignment(VSLabel.LEFT);
	lblT1ORD_ExchangeRate.setName ("lblT1ORD_ExchangeRate");
		lblT1ORD_ExchangeRate.setForeground(Color.black);
		lblT1ORD_ExchangeRate.setBackground(Color.lightGray);
	lblT1ORD_ExchangeRate.setBounds (7, 201 , 102, 18);

lblT1ORD_ExchangeRate.setFont (new Font ("Helvetica", 0, 12));

	lblT1ORD_ExchangeRate.setTag ("_$$_");
 	lblT1ORD_ExchangeRate.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1ORD_ExchangeRate.setDataSourceName("");
	lblT1ORD_ExchangeRate.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1ORD_ExchangeRate.setVerticalAlignment (SwingConstants.CENTER);
	lblT1ORD_ExchangeRate.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1ORD_ExchangeRate,null);             
	} // end of initVSLabellblT1ORD_ExchangeRate()
	
	
	
	
	public void initVSTextFieldtxtT1ORD_ExchangeRate() { 
	txtT1ORD_ExchangeRate.setName ("txtT1ORD_ExchangeRate");
		txtT1ORD_ExchangeRate.setForeground(Color.black);
		txtT1ORD_ExchangeRate.setBackground(Color.white);
	txtT1ORD_ExchangeRate.setBounds (111, 200 , 11, 20);

txtT1ORD_ExchangeRate.setFont (new Font ("Helvetica", 0, 12));

	txtT1ORD_ExchangeRate.setTag ("_$$_");
 	txtT1ORD_ExchangeRate.setDataSourceName("datT1OrderItem_ORD");
	txtT1ORD_ExchangeRate.setDataFieldName("ORD_ExchangeRate");
	txtT1ORD_ExchangeRate.setTabOrder(19);
	txtT1ORD_ExchangeRate.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1ORD_ExchangeRate,null);             
	} // end of initVSTextFieldtxtT1ORD_ExchangeRate()
	
	
	
	
	
	
	
	
	public void initVSChoicevscT1ORD_Approved() { 
	vscT1ORD_Approved.setName ("vscT1ORD_Approved");
		vscT1ORD_Approved.setForeground(Color.black);
		vscT1ORD_Approved.setBackground(Color.white);
	vscT1ORD_Approved.setBounds (111, 227 , 114, 20);

vscT1ORD_Approved.setFont (new Font ("Helvetica", 0, 12));

	vscT1ORD_Approved.setTag ("_$$_");
 	vscT1ORD_Approved.setEditable (false);
	vscT1ORD_Approved.setLoadCodeTableAsync(true);			
	VSApplicationContext.loadCodeTableAsync ("Z_YesNo", vscT1ORD_Approved);
	vscT1ORD_Approved.setDataSourceName("datT1OrderItem_ORD");
	vscT1ORD_Approved.setDataFieldName ("ORD_Approved");
	vscT1ORD_Approved.setTabOrder(20);
	vscT1ORD_Approved.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (vscT1ORD_Approved,null);             
	} //end of initVSChoicevscT1ORD_Approved()
	
	
	
	
	
	
	public void initVSLabellblT1ORD_Approved() {
	lblT1ORD_Approved.setText("Approved");
	lblT1ORD_Approved.setAlignment(VSLabel.LEFT);
	lblT1ORD_Approved.setName ("lblT1ORD_Approved");
		lblT1ORD_Approved.setForeground(Color.black);
		lblT1ORD_Approved.setBackground(Color.lightGray);
	lblT1ORD_Approved.setBounds (7, 229 , 102, 18);

lblT1ORD_Approved.setFont (new Font ("Helvetica", 0, 12));

	lblT1ORD_Approved.setTag ("_$$_");
 	lblT1ORD_Approved.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT1ORD_Approved.setDataSourceName("");
	lblT1ORD_Approved.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT1ORD_Approved.setVerticalAlignment (SwingConstants.CENTER);
	lblT1ORD_Approved.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT1ORD_Approved,null);             
	} // end of initVSLabellblT1ORD_Approved()
	
	public void initVSJavaDataControldatT1OrderItem_ORD() { 
	datT1OrderItem_ORD.setLabel ("OrderItem_ORD");
	datT1OrderItem_ORD.setQueryInfo(new VSQueryInfo("OrderItem_ORD", "", "", "", false));
	datT1OrderItem_ORD.setName ("datT1OrderItem_ORD");
		datT1OrderItem_ORD.setForeground(Color.black);
		datT1OrderItem_ORD.setBackground(Color.white);
	datT1OrderItem_ORD.setBounds (140, 420 , 201, 25);

datT1OrderItem_ORD.setFont (new Font ("Helvetica", 0, 12));
	datT1OrderItem_ORD.setVisible(false);

	datT1OrderItem_ORD.setTag ("_$$_");
 	datT1OrderItem_ORD.setTabOrder(21);
	datT1OrderItem_ORD.setTabStop (false);
	setRootDataControl(datT1OrderItem_ORD);
	datT1OrderItem_ORD.setMaxRowsPerFetch(1);
	datT1OrderItem_ORD.setSaveMode (VSJavaDataControl.SAVE_IMMEDIATE);
	datT1OrderItem_ORD.setDataDependency (false, false);
        


      // container is form
add (datT1OrderItem_ORD,null);             
	
	
	T3Currency_CURPickObj_datT1OrderItem_ORD = new VSPick ("T3Currency_CURPickObj_datT1OrderItem_ORD", "datT1OrderItem_ORD",
					"Currency_CUR", "", "", "[CUR_Client] = [?ORD_Client] and [CUR_CurrencyCode] = [?ORD_CurrencyCode]", "[CUR_ExchangeRate]=[?ORD_ExchangeRate]", "CUR_Client, CUR_CurrencyCode, CUR_ExchangeRate, CUR_NumberOfOrders, CUR_OrderValueUSD, CUR_OrderAmountAverage, CUR_Image, CUR_Client_RelatedTo, CUR_CurrencyCode_RelatedTo", "genericPick");
	T3Currency_CURPickObj_datT1OrderItem_ORD.setParentTableAlias("");


	addPick(T3Currency_CURPickObj_datT1OrderItem_ORD);
                    T3Currency_CURPickObj_datT1OrderItem_ORD.setStyle(VSPick.STYLE_DROPDOWN);

	T2OrderBacklogPerMonth_OBTPickObj_datT1OrderItem_ORD = new VSPick ("T2OrderBacklogPerMonth_OBTPickObj_datT1OrderItem_ORD", "datT1OrderItem_ORD",
					"OrderBacklogPerMonth_OBT", "", "", "[OBT_Client] = [?ORD_Client] and [OBT_Month] = [?ORD_Month]", "", "OBT_Client, OBT_Month, OBT_OrderValueUSD", "genericPick");
	T2OrderBacklogPerMonth_OBTPickObj_datT1OrderItem_ORD.setParentTableAlias("");


	addPick(T2OrderBacklogPerMonth_OBTPickObj_datT1OrderItem_ORD);
                    T2OrderBacklogPerMonth_OBTPickObj_datT1OrderItem_ORD.setStyle(VSPick.STYLE_DROPDOWN);

	} // end of initVSJavaDataControldatT1OrderItem_ORD()
	
	
	
	
	
	
}