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
 * fOrderItem_ORD21_Grid
 */
abstract class fOrderItem_ORD21_GridBase extends VSForm {
	// Declarations for instance variables used in the form
	//{{FORM_VAR_DECL
	protected static final VersataLogger logger = VersataLogger.getLogger(JavaApp.class);
		VSButton btnT2fOrderItem_ORD15 = new VSButton();
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
		VSJavaDataControl datT1OrderItem_ORD = new VSJavaDataControl("datT1OrderItem_ORD");    
		VSGrid grdT1OrderItem_ORD = new VSGrid();
		VSScrollPane scrlgrdT1OrderItem_ORD = new VSScrollPane(grdT1OrderItem_ORD);
		VSFormNavigation T2fOrderItem_ORD15NavObj_datT1OrderItem_ORD = null; 
	
	//END_FORM_VAR_DECL}}

	public fOrderItem_ORD21_GridBase() throws VSException, java.beans.PropertyVetoException {
		//{{FORM_OBJ_CTOR
			setLayout (null);
		
		beforeFormInitialize();
		
		setName("fOrderItem_ORD21_Grid");
		
		
			 initVSButtonbtnT2fOrderItem_ORD15();
			
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
			
			initVSJavaDataControldatT1OrderItem_ORD();
			
			initVSGridgrdT1OrderItem_ORD();
			
				
		        btnT2fOrderItem_ORD15.setFormTransition(T2fOrderItem_ORD15NavObj_datT1OrderItem_ORD);
		
			setBounds (0, 0, 579, 500);
		
			setTitle ("OrderItem_ORD(s)");
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

	
	
	 public void initVSButtonbtnT2fOrderItem_ORD15() {
	btnT2fOrderItem_ORD15.setText("OrderItem_ORD");
	btnT2fOrderItem_ORD15.setName ("btnT2fOrderItem_ORD15");
		btnT2fOrderItem_ORD15.setForeground(Color.black);
		btnT2fOrderItem_ORD15.setBackground(Color.white);
	btnT2fOrderItem_ORD15.setBounds (491, 5 , 86, 35);

btnT2fOrderItem_ORD15.setFont (new Font ("Helvetica", 0, 12));

	btnT2fOrderItem_ORD15.setTag ("_$$_");
 	btnT2fOrderItem_ORD15.setBorderPainted (true);
	btnT2fOrderItem_ORD15.setDataSourceName("datT1OrderItem_ORD");
	btnT2fOrderItem_ORD15.setTabOrder(0);
	btnT2fOrderItem_ORD15.setToolTipText ("OrderItem_ORD");
        
      // container is form
add (btnT2fOrderItem_ORD15,null);             
	} // end of initVSButtonbtnT2fOrderItem_ORD15
	
	
	
	
	
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
	btnInsert.setTabOrder(1);
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
	btnDelete.setTabOrder(2);
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
	btnSave.setTabOrder(3);
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
	btnUndo.setTabOrder(4);
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
	btnMoveFirst.setTabOrder(5);
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
	btnMovePrev.setTabOrder(6);
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
	btnMoveNext.setTabOrder(7);
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
	btnMoveLast.setTabOrder(8);
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
	btnRunQuery.setTabOrder(9);
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
	btnQueryMode.setTabOrder(10);
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
	btnQueryMode1.setTabOrder(11);
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
	btnCancelQuery.setTabOrder(12);
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
	btnEditSql.setTabOrder(13);
	btnEditSql.setToolTipText ("Edit SQL");
	btnEditSql.setBorderStyle (VSImageButton.AUTOSHOW_BORDER);
        
      // container is form
add (btnEditSql,null);             
	} // end of initVSImageButtonbtnEditSql()
	
	
	
	
	
	public void initVSJavaDataControldatT1OrderItem_ORD() { 
	datT1OrderItem_ORD.setLabel ("OrderItem_ORD");
	datT1OrderItem_ORD.setQueryInfo(new VSQueryInfo("OrderItem_ORD", "", "", "", false));
	datT1OrderItem_ORD.setName ("datT1OrderItem_ORD");
		datT1OrderItem_ORD.setForeground(Color.black);
		datT1OrderItem_ORD.setBackground(Color.white);
	datT1OrderItem_ORD.setBounds (119, 405 , 252, 27);

datT1OrderItem_ORD.setFont (new Font ("Helvetica", 0, 12));
	datT1OrderItem_ORD.setVisible(false);

	datT1OrderItem_ORD.setTag ("_$$_");
 	datT1OrderItem_ORD.setTabOrder(14);
	datT1OrderItem_ORD.setTabStop (false);
	setRootDataControl(datT1OrderItem_ORD);
	datT1OrderItem_ORD.setMaxRowsPerFetch(16);
	datT1OrderItem_ORD.setSaveMode (VSJavaDataControl.SAVE_BUFFERED);
	datT1OrderItem_ORD.setDataDependency (false, false);
        


      // container is form
add (datT1OrderItem_ORD,null);             
	
	T2fOrderItem_ORD15NavObj_datT1OrderItem_ORD = new VSFormNavigation(this, "datT1OrderItem_ORD", "OrderItem_ORD", "", false, "",
																"", "fOrderItem_ORD15", " ");					
	T2fOrderItem_ORD15NavObj_datT1OrderItem_ORD.setDataDependency(false, false);
            T2fOrderItem_ORD15NavObj_datT1OrderItem_ORD.setName("T2fOrderItem_ORD15");
    		
	
	} // end of initVSJavaDataControldatT1OrderItem_ORD()
	
	
	
	
	
	
	
	
	
	
	
	
	public void initVSGridgrdT1OrderItem_ORD() {
	grdT1OrderItem_ORD.setName ("grdT1OrderItem_ORD");
		grdT1OrderItem_ORD.setForeground(Color.black);
		grdT1OrderItem_ORD.setBackground(Color.white);
	scrlgrdT1OrderItem_ORD.setBounds(new Rectangle(4, 37 , 474, 372));

grdT1OrderItem_ORD.setFont (new Font ("Helvetica", 0, 12));

	grdT1OrderItem_ORD.setTag ("_$$_");
 	grdT1OrderItem_ORD.setAutoResizeMode (JTable.AUTO_RESIZE_OFF);
	grdT1OrderItem_ORD.setColumnHeaderHeight(17);
	grdT1OrderItem_ORD.setRowSelectionAllowed(false);
	grdT1OrderItem_ORD.setTabOrder(15);
	grdT1OrderItem_ORD.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
	grdT1OrderItem_ORD.setShowStarRow(true);
	grdT1OrderItem_ORD.setShowHorizontalLines(true);
	grdT1OrderItem_ORD.setShowVerticalLines(true);
	grdT1OrderItem_ORD.setRowHeaderWidth (25);
	grdT1OrderItem_ORD.setRowHeight (20);
	grdT1OrderItem_ORD.setSelectionBackground(new Color(0x000080));
	grdT1OrderItem_ORD.setDisableBackground(new Color(0xffffff));
	grdT1OrderItem_ORD.setDataSourceName("datT1OrderItem_ORD");
        grdT1OrderItem_ORD.setColumnHeaderFont(new Font ("Helvetica", 0, 12));
        scrlgrdT1OrderItem_ORD.setRowHeaderView(grdT1OrderItem_ORD.addRowHeaderRenderer());
	
      // container is form
add(scrlgrdT1OrderItem_ORD,null);         
	try
	{
			//{{GRIDCOLUMN_CTOR
			VSGridColumn gridCol = null;
				gridCol = grdT1OrderItem_ORD.addColumn ();
				gridCol.setDataFieldName ("ORD_Client");
				gridCol.setLabel ("ORD_Client");
				gridCol.setPreferredWidth (75);
				gridCol.setSortAllowed(true);
				
				gridCol = grdT1OrderItem_ORD.addColumn ();
				gridCol.setDataFieldName ("ORD_OrderId");
				gridCol.setLabel ("OrderId");
				gridCol.setPreferredWidth (75);
				gridCol.setSortAllowed(true);
				
				gridCol = grdT1OrderItem_ORD.addColumn ();
				gridCol.setDataFieldName ("ORD_Month");
				gridCol.setLabel ("Month");
				gridCol.setPreferredWidth (75);
				gridCol.setSortAllowed(true);
				
				gridCol = grdT1OrderItem_ORD.addColumn ();
				gridCol.setDataFieldName ("ORD_CurrencyCode");
				gridCol.setLabel ("CurrencyCode");
				gridCol.setPreferredWidth (75);
				gridCol.setSortAllowed(true);
				
				gridCol = grdT1OrderItem_ORD.addColumn ();
				gridCol.setDataFieldName ("ORD_AmountInLocalCurrency");
				gridCol.setLabel ("AmountInLocalCurrency");
				gridCol.setPreferredWidth (75);
				gridCol.setSortAllowed(true);
				
				gridCol = grdT1OrderItem_ORD.addColumn ();
				gridCol.setDataFieldName ("ORD_AmountInUSD");
				gridCol.setLabel ("AmountInUSD");
				gridCol.setPreferredWidth (75);
				gridCol.setSortAllowed(true);
				
				gridCol = grdT1OrderItem_ORD.addColumn ();
				gridCol.setDataFieldName ("ORD_ExchangeRate");
				gridCol.setLabel ("ORD_ExchangeRate");
				gridCol.setPreferredWidth (75);
				gridCol.setSortAllowed(true);
				
				gridCol = grdT1OrderItem_ORD.addColumn ();
				gridCol.setDataFieldName ("ORD_Approved");
				gridCol.setLabel ("Approved");
				gridCol.setPreferredWidth (75);
				gridCol.setEditType(VSGrid.EDIT_VSCHOICE);
				VSApplicationContext.loadCodeTableAsync("Z_YesNo", gridCol);
				gridCol.setSortAllowed(true);
				
			
			//END_GRIDCOLUMN_CTOR}}
	
	}
	catch ( VSException ex ) {
		VSApplicationContext.handleException( "can't set up display columns for the customers grid", ex );
	}
	} //end of initVSGridgrdT1OrderItem_ORD()
	
}