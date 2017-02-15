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
 * fCurrency_CUR_Grid
 */
abstract class fCurrency_CUR_GridBase extends VSForm {
	// Declarations for instance variables used in the form
	//{{FORM_VAR_DECL
	protected static final VersataLogger logger = VersataLogger.getLogger(JavaApp.class);
		VSImagePanel imgPanel = new VSImagePanel();
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
		VSJavaDataControl datT2OrderItem_ORD = new VSJavaDataControl("datT2OrderItem_ORD");    
		VSGrid grdT2OrderItem_ORD = new VSGrid();
		VSScrollPane scrlgrdT2OrderItem_ORD = new VSScrollPane(grdT2OrderItem_ORD);
		VSJavaDataControl datT1Currency_CUR = new VSJavaDataControl("datT1Currency_CUR");    
		VSGrid grdT1Currency_CUR = new VSGrid();
		VSScrollPane scrlgrdT1Currency_CUR = new VSScrollPane(grdT1Currency_CUR);
		VSLabel lblT1CUR_Image = new VSLabel();
		VSTextField txtT1CUR_Image = new VSTextField();
		VSJavaDataControl datT3Currency_CUR = new VSJavaDataControl("datT3Currency_CUR");    
		VSPickChoice pckT1CUR_CurrencyCode_RelatedTo = new VSPickChoice();
		VSLabel lblT1CUR_CurrencyCode_RelatedTo = new VSLabel();
		VSLabel lblT1CUR_Client = new VSLabel();
		VSTextField txtT1CUR_Client = new VSTextField();
		VSPickChoice pckT1CUR_Client_RelatedTo = new VSPickChoice();
		VSLabel lblT1CUR_Client_RelatedTo = new VSLabel();
		VSPick T4Currency_CURPickObj_datT1Currency_CUR = null;
	
	//END_FORM_VAR_DECL}}

	public fCurrency_CUR_GridBase() throws VSException, java.beans.PropertyVetoException {
		//{{FORM_OBJ_CTOR
			setLayout (null);
		
		beforeFormInitialize();
		
		setName("fCurrency_CUR_Grid");
		
		
			
			initVSImagePanelimgPanel();
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
			
			initVSJavaDataControldatT2OrderItem_ORD();
			
			initVSGridgrdT2OrderItem_ORD();
			
			initVSJavaDataControldatT1Currency_CUR();
			
			initVSGridgrdT1Currency_CUR();
			
			initVSLabellblT1CUR_Image();
			
			 initVSTextFieldtxtT1CUR_Image();
			
			initVSJavaDataControldatT3Currency_CUR();
			
			initVSPickChoicepckT1CUR_CurrencyCode_RelatedTo();		
			
			initVSLabellblT1CUR_CurrencyCode_RelatedTo();
			
			initVSLabellblT1CUR_Client();
			
			 initVSTextFieldtxtT1CUR_Client();
			
			initVSPickChoicepckT1CUR_Client_RelatedTo();		
			
			initVSLabellblT1CUR_Client_RelatedTo();
			
				
			datT2OrderItem_ORD.setDataSourceName("datT1Currency_CUR");
			datT3Currency_CUR.setDataSourceName("datT1Currency_CUR");
		
			setBounds (0, 0, 716, 500);
		
			setTitle ("Currency_CUR(s)");
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

	
	
	
	
	
	
	public void initVSImagePanelimgPanel() {
	imgPanel.setImageFile ("");
	imgPanel.setName ("imgPanel");
		imgPanel.setForeground(Color.black);
		imgPanel.setBackground(Color.lightGray);
	imgPanel.setBounds (451, 4 , 64, 33);

imgPanel.setFont (new Font ("Helvetica", 0, 12));
	imgPanel.setEnabled(false);

 	imgPanel.setDataSourceName("datT1Currency_CUR");
	imgPanel.setDataFieldName("CUR_Image");
	imgPanel.setBorderStyle (VSPanel.PLAIN_BORDER);
	imgPanel.setDisplayStyle(VSImagePanel.STYLE_CENTERED);
	imgPanel.setBorderStyle (VSPanel.PLAIN_BORDER);
	imgPanel.setTabOrder(22);
	imgPanel.setTabStop (false);
        
      // container is form
add (imgPanel,null);             
	} // end of initVSImagePanelimgPanel()
	
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
	btnInsert.setTabOrder(3);
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
	btnDelete.setTabOrder(6);
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
	btnSave.setTabOrder(7);
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
	btnUndo.setTabOrder(8);
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
	btnMoveFirst.setTabOrder(9);
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
	btnMovePrev.setTabOrder(10);
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
	btnMoveNext.setTabOrder(11);
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
	btnMoveLast.setTabOrder(12);
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
	btnRunQuery.setTabOrder(13);
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
	btnQueryMode.setTabOrder(14);
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
	btnQueryMode1.setTabOrder(15);
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
	btnCancelQuery.setTabOrder(16);
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
	btnEditSql.setTabOrder(17);
	btnEditSql.setToolTipText ("Edit SQL");
	btnEditSql.setBorderStyle (VSImageButton.AUTOSHOW_BORDER);
        
      // container is form
add (btnEditSql,null);             
	} // end of initVSImageButtonbtnEditSql()
	
	
	
	
	
	public void initVSJavaDataControldatT2OrderItem_ORD() { 
	datT2OrderItem_ORD.setLabel ("OrderItem_ORD(s)");
	datT2OrderItem_ORD.setQueryInfo(new VSQueryInfo("OrderItem_ORD", "", "", "[ORD_Client] = [?CUR_Client] and [ORD_CurrencyCode] = [?CUR_CurrencyCode]", true));
	datT2OrderItem_ORD.setName ("datT2OrderItem_ORD");
		datT2OrderItem_ORD.setForeground(Color.black);
		datT2OrderItem_ORD.setBackground(Color.white);
	datT2OrderItem_ORD.setBounds (112, 465 , 252, 27);

datT2OrderItem_ORD.setFont (new Font ("Helvetica", 0, 12));
	datT2OrderItem_ORD.setVisible(false);

	datT2OrderItem_ORD.setTag ("_$$_");
 	datT2OrderItem_ORD.setTabOrder(18);
	datT2OrderItem_ORD.setTabStop (false);
	datT2OrderItem_ORD.setMaxRowsPerFetch(16);
	datT2OrderItem_ORD.setSaveMode (VSJavaDataControl.SAVE_BUFFERED);
	datT2OrderItem_ORD.setDataDependency (true, false);
        


      // container is form
add (datT2OrderItem_ORD,null);             
	
	
	} // end of initVSJavaDataControldatT2OrderItem_ORD()
	
	
	
	
	
	
	
	
	
	
	
	
	public void initVSGridgrdT2OrderItem_ORD() {
	grdT2OrderItem_ORD.setName ("grdT2OrderItem_ORD");
		grdT2OrderItem_ORD.setForeground(Color.black);
		grdT2OrderItem_ORD.setBackground(Color.white);
	scrlgrdT2OrderItem_ORD.setBounds(new Rectangle(10, 273 , 681, 195));

grdT2OrderItem_ORD.setFont (new Font ("Helvetica", 0, 12));

	grdT2OrderItem_ORD.setTag ("_$$_");
 	grdT2OrderItem_ORD.setAutoResizeMode (JTable.AUTO_RESIZE_OFF);
	grdT2OrderItem_ORD.setColumnHeaderHeight(17);
	grdT2OrderItem_ORD.setRowSelectionAllowed(false);
	grdT2OrderItem_ORD.setTabOrder(19);
	grdT2OrderItem_ORD.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
	grdT2OrderItem_ORD.setShowStarRow(true);
	grdT2OrderItem_ORD.setShowHorizontalLines(true);
	grdT2OrderItem_ORD.setShowVerticalLines(true);
	grdT2OrderItem_ORD.setRowHeaderWidth (25);
	grdT2OrderItem_ORD.setRowHeight (20);
	grdT2OrderItem_ORD.setSelectionBackground(new Color(0x000080));
	grdT2OrderItem_ORD.setDisableBackground(new Color(0xffffff));
	grdT2OrderItem_ORD.setDataSourceName("datT2OrderItem_ORD");
        grdT2OrderItem_ORD.setColumnHeaderFont(new Font ("Helvetica", 0, 12));
        scrlgrdT2OrderItem_ORD.setRowHeaderView(grdT2OrderItem_ORD.addRowHeaderRenderer());
	
      // container is form
add(scrlgrdT2OrderItem_ORD,null);         
	try
	{
			//{{GRIDCOLUMN_CTOR
			VSGridColumn gridCol = null;
				gridCol = grdT2OrderItem_ORD.addColumn ();
				gridCol.setDataFieldName ("ORD_Client");
				gridCol.setLabel ("ORD_Client");
				gridCol.setPreferredWidth (26);
				gridCol.setSortAllowed(true);
				
				gridCol = grdT2OrderItem_ORD.addColumn ();
				gridCol.setDataFieldName ("ORD_OrderId");
				gridCol.setLabel ("OrderId");
				gridCol.setPreferredWidth (75);
				gridCol.setSortAllowed(true);
				
				gridCol = grdT2OrderItem_ORD.addColumn ();
				gridCol.setDataFieldName ("ORD_Month");
				gridCol.setLabel ("Month");
				gridCol.setPreferredWidth (75);
				gridCol.setSortAllowed(true);
				
				gridCol = grdT2OrderItem_ORD.addColumn ();
				gridCol.setDataFieldName ("ORD_CurrencyCode");
				gridCol.setLabel ("CurrencyCode");
				gridCol.setPreferredWidth (75);
				gridCol.setSortAllowed(true);
				
				gridCol = grdT2OrderItem_ORD.addColumn ();
				gridCol.setDataFieldName ("ORD_AmountInLocalCurrency");
				gridCol.setLabel ("AmountInLocalCurrency");
				gridCol.setPreferredWidth (75);
				gridCol.setSortAllowed(true);
				
				gridCol = grdT2OrderItem_ORD.addColumn ();
				gridCol.setDataFieldName ("ORD_AmountInUSD");
				gridCol.setLabel ("AmountInUSD");
				gridCol.setPreferredWidth (75);
				gridCol.setSortAllowed(true);
				
				gridCol = grdT2OrderItem_ORD.addColumn ();
				gridCol.setDataFieldName ("ORD_ExchangeRate");
				gridCol.setLabel ("ORD_ExchangeRate");
				gridCol.setPreferredWidth (75);
				gridCol.setSortAllowed(true);
				
				gridCol = grdT2OrderItem_ORD.addColumn ();
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
	} //end of initVSGridgrdT2OrderItem_ORD()
	
	public void initVSJavaDataControldatT1Currency_CUR() { 
	datT1Currency_CUR.setLabel ("Currency_CUR");
	datT1Currency_CUR.setQueryInfo(new VSQueryInfo("Currency_CUR", "", "", "", false));
	datT1Currency_CUR.setName ("datT1Currency_CUR");
		datT1Currency_CUR.setForeground(Color.black);
		datT1Currency_CUR.setBackground(Color.white);
	datT1Currency_CUR.setBounds (110, 256 , 252, 27);

datT1Currency_CUR.setFont (new Font ("Helvetica", 0, 12));
	datT1Currency_CUR.setVisible(false);

	datT1Currency_CUR.setTag ("_$$_");
 	datT1Currency_CUR.setTabOrder(20);
	datT1Currency_CUR.setTabStop (false);
	setRootDataControl(datT1Currency_CUR);
	datT1Currency_CUR.setMaxRowsPerFetch(16);
	datT1Currency_CUR.setSaveMode (VSJavaDataControl.SAVE_IMMEDIATE);
	datT1Currency_CUR.setDataDependency (false, false);
        


      // container is form
add (datT1Currency_CUR,null);             
	
	
	T4Currency_CURPickObj_datT1Currency_CUR = new VSPick ("T4Currency_CURPickObj_datT1Currency_CUR", "datT1Currency_CUR",
					"Currency_CUR", "", "", "[CUR_Client] = [?CUR_Client_RelatedTo] and [CUR_CurrencyCode] = [?CUR_CurrencyCode_RelatedTo]", "", "CUR_CurrencyCode, CUR_ExchangeRate, CUR_OrderValueUSD, CUR_NumberOfOrders, CUR_OrderAmountAverage, CUR_Image, CUR_CurrencyCode_RelatedTo, CUR_Client, CUR_Client_RelatedTo", "genericPick");
	T4Currency_CURPickObj_datT1Currency_CUR.setParentTableAlias("");


	addPick(T4Currency_CURPickObj_datT1Currency_CUR);
                    T4Currency_CURPickObj_datT1Currency_CUR.setStyle(VSPick.STYLE_FORM);

	} // end of initVSJavaDataControldatT1Currency_CUR()
	
	
	
	
	
	
	
	
	
	
	
	
	public void initVSGridgrdT1Currency_CUR() {
	grdT1Currency_CUR.setName ("grdT1Currency_CUR");
		grdT1Currency_CUR.setForeground(Color.black);
		grdT1Currency_CUR.setBackground(Color.white);
	scrlgrdT1Currency_CUR.setBounds(new Rectangle(6, 66 , 450, 148));

grdT1Currency_CUR.setFont (new Font ("Helvetica", 0, 12));

	grdT1Currency_CUR.setTag ("_$$_");
 	grdT1Currency_CUR.setAutoResizeMode (JTable.AUTO_RESIZE_OFF);
	grdT1Currency_CUR.setColumnHeaderHeight(17);
	grdT1Currency_CUR.setRowSelectionAllowed(false);
	grdT1Currency_CUR.setTabOrder(21);
	grdT1Currency_CUR.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
	grdT1Currency_CUR.setShowStarRow(true);
	grdT1Currency_CUR.setShowHorizontalLines(true);
	grdT1Currency_CUR.setShowVerticalLines(true);
	grdT1Currency_CUR.setRowHeaderWidth (25);
	grdT1Currency_CUR.setRowHeight (20);
	grdT1Currency_CUR.setSelectionBackground(new Color(0x000080));
	grdT1Currency_CUR.setDisableBackground(new Color(0xffffff));
	grdT1Currency_CUR.setDataSourceName("datT1Currency_CUR");
        grdT1Currency_CUR.setColumnHeaderFont(new Font ("Helvetica", 0, 12));
        scrlgrdT1Currency_CUR.setRowHeaderView(grdT1Currency_CUR.addRowHeaderRenderer());
	
      // container is form
add(scrlgrdT1Currency_CUR,null);         
	try
	{
			//{{GRIDCOLUMN_CTOR
			VSGridColumn gridCol = null;
				gridCol = grdT1Currency_CUR.addColumn ();
				gridCol.setDataFieldName ("CUR_Image");
				gridCol.setLabel ("CUR_Image");
				gridCol.setPreferredWidth (75);
				gridCol.setEditType(VSGrid.EDIT_VSIMAGE);
				gridCol.setSortAllowed(true);
				
				gridCol = grdT1Currency_CUR.addColumn ();
				gridCol.setDataFieldName ("CUR_Client");
				gridCol.setLabel ("CUR_Client");
				gridCol.setPreferredWidth (26);
				gridCol.setSortAllowed(true);
				
				gridCol = grdT1Currency_CUR.addColumn ();
				gridCol.setDataFieldName ("CUR_CurrencyCode");
				gridCol.setLabel ("Currency Code");
				gridCol.setPreferredWidth (51);
				gridCol.setSortAllowed(true);
				
				gridCol = grdT1Currency_CUR.addColumn ();
				gridCol.setDataFieldName ("CUR_Client_RelatedTo");
				gridCol.setLabel ("CUR_Client_RelatedTo");
				gridCol.setPreferredWidth (24);
				gridCol.setEditType(VSGrid.EDIT_VSPICKCHOICE);
				gridCol.setPickName ("T4Currency_CURPickObj_datT1Currency_CUR");
				gridCol.setSortAllowed(true);
				
				gridCol = grdT1Currency_CUR.addColumn ();
				gridCol.setDataFieldName ("CUR_CurrencyCode_RelatedTo");
				gridCol.setLabel ("CurrencyCode_RelatedTo");
				gridCol.setPreferredWidth (54);
				gridCol.setEditType(VSGrid.EDIT_VSPICKCHOICE);
				gridCol.setPickName ("T4Currency_CURPickObj_datT1Currency_CUR");
				gridCol.setSortAllowed(true);
				
				gridCol = grdT1Currency_CUR.addColumn ();
				gridCol.setDataFieldName ("CUR_ExchangeRate");
				gridCol.setLabel ("Exchange Rate");
				gridCol.setPreferredWidth (75);
				gridCol.setSortAllowed(true);
				
				gridCol = grdT1Currency_CUR.addColumn ();
				gridCol.setDataFieldName ("CUR_OrderValueUSD");
				gridCol.setLabel ("Order Value USD22");
				gridCol.setPreferredWidth (75);
				gridCol.setSortAllowed(true);
				
				gridCol = grdT1Currency_CUR.addColumn ();
				gridCol.setDataFieldName ("CUR_NumberOfOrders");
				gridCol.setLabel ("Number Of Orders");
				gridCol.setPreferredWidth (75);
				gridCol.setSortAllowed(true);
				
				gridCol = grdT1Currency_CUR.addColumn ();
				gridCol.setDataFieldName ("CUR_OrderAmountAverage");
				gridCol.setLabel ("Order Amount Average USD");
				gridCol.setPreferredWidth (75);
				gridCol.setSortAllowed(true);
				
			
			//END_GRIDCOLUMN_CTOR}}
	
	}
	catch ( VSException ex ) {
		VSApplicationContext.handleException( "can't set up display columns for the customers grid", ex );
	}
	} //end of initVSGridgrdT1Currency_CUR()
	
	
	
	
	
	
	public void initVSLabellblT1CUR_Image() {
	lblT1CUR_Image.setText("CUR_Image");
	lblT1CUR_Image.setAlignment(VSLabel.LEFT);
	lblT1CUR_Image.setName ("lblT1CUR_Image");
		lblT1CUR_Image.setForeground(Color.black);
		lblT1CUR_Image.setBackground(Color.lightGray);
	lblT1CUR_Image.setBounds (139, 39 , 102, 18);

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
	txtT1CUR_Image.setBounds (215, 38 , 350, 18);

txtT1CUR_Image.setFont (new Font ("Helvetica", 0, 12));

	txtT1CUR_Image.setTag ("_$$_");
 	txtT1CUR_Image.setDataSourceName("datT1Currency_CUR");
	txtT1CUR_Image.setDataFieldName("CUR_Image");
	txtT1CUR_Image.setTabOrder(4);
	txtT1CUR_Image.setDisplayMode(VSQueryable.Data);
        		
      // container is form
add (txtT1CUR_Image,null);             
	} // end of initVSTextFieldtxtT1CUR_Image()
	
	
	
	public void initVSJavaDataControldatT3Currency_CUR() { 
	datT3Currency_CUR.setLabel ("c");
	datT3Currency_CUR.setQueryInfo(new VSQueryInfo("Currency_CUR", "", "", "[CUR_Client] = [?CUR_Client_RelatedTo] and [CUR_CurrencyCode] = [?CUR_CurrencyCode_RelatedTo]", false));
	datT3Currency_CUR.setName ("datT3Currency_CUR");
		datT3Currency_CUR.setForeground(Color.black);
		datT3Currency_CUR.setBackground(Color.white);
	datT3Currency_CUR.setBounds (457, 240 , 101, 13);

datT3Currency_CUR.setFont (new Font ("Helvetica", 0, 12));
	datT3Currency_CUR.setVisible(false);

	datT3Currency_CUR.setTag ("_$$_");
 	datT3Currency_CUR.setTabOrder(5);
	datT3Currency_CUR.setTabStop (false);
	datT3Currency_CUR.setMaxRowsPerFetch(1);
	datT3Currency_CUR.setSaveMode (VSJavaDataControl.SAVE_IMMEDIATE);
	datT3Currency_CUR.setDataDependency (false, false);
        


      // container is form
add (datT3Currency_CUR,null);             
	
	
	} // end of initVSJavaDataControldatT3Currency_CUR()
	
	
	
	
	
	
	
	
	
	
	
	
	public void initVSPickChoicepckT1CUR_CurrencyCode_RelatedTo() {		
	
	pckT1CUR_CurrencyCode_RelatedTo.setName ("pckT1CUR_CurrencyCode_RelatedTo");
		pckT1CUR_CurrencyCode_RelatedTo.setForeground(Color.black);
		pckT1CUR_CurrencyCode_RelatedTo.setBackground(Color.white);
	pckT1CUR_CurrencyCode_RelatedTo.setBounds (136, 225 , 120, 20);

pckT1CUR_CurrencyCode_RelatedTo.setFont (new Font ("Helvetica", 0, 12));

	pckT1CUR_CurrencyCode_RelatedTo.setTag ("_$$_");
 	pckT1CUR_CurrencyCode_RelatedTo.setDataFieldName("CUR_CurrencyCode_RelatedTo");
	pckT1CUR_CurrencyCode_RelatedTo.setPick("T4Currency_CURPickObj_datT1Currency_CUR");
	pckT1CUR_CurrencyCode_RelatedTo.setDataSourceName("datT1Currency_CUR");
	pckT1CUR_CurrencyCode_RelatedTo.setTabOrder(1);
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
	lblT1CUR_CurrencyCode_RelatedTo.setBounds (32, 225 , 102, 18);

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
	
	
	
	
	
	
	public void initVSLabellblT1CUR_Client() {
	lblT1CUR_Client.setText("CUR_Client");
	lblT1CUR_Client.setAlignment(VSLabel.LEFT);
	lblT1CUR_Client.setName ("lblT1CUR_Client");
		lblT1CUR_Client.setForeground(Color.black);
		lblT1CUR_Client.setBackground(Color.lightGray);
	lblT1CUR_Client.setBounds (456, 73 , 102, 18);

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
	txtT1CUR_Client.setBounds (558, 72 , 44, 20);

txtT1CUR_Client.setFont (new Font ("Helvetica", 0, 12));

	txtT1CUR_Client.setTag ("_$$_");
 	txtT1CUR_Client.setDataSourceName("datT1Currency_CUR");
	txtT1CUR_Client.setDataFieldName("CUR_Client");
	txtT1CUR_Client.setTabOrder(0);
	txtT1CUR_Client.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1CUR_Client,null);             
	} // end of initVSTextFieldtxtT1CUR_Client()
	
	
	
	
	
	
	
	
	
	public void initVSPickChoicepckT1CUR_Client_RelatedTo() {		
	
	pckT1CUR_Client_RelatedTo.setName ("pckT1CUR_Client_RelatedTo");
		pckT1CUR_Client_RelatedTo.setForeground(Color.black);
		pckT1CUR_Client_RelatedTo.setBackground(Color.white);
	pckT1CUR_Client_RelatedTo.setBounds (558, 101 , 120, 20);

pckT1CUR_Client_RelatedTo.setFont (new Font ("Helvetica", 0, 12));

	pckT1CUR_Client_RelatedTo.setTag ("_$$_");
 	pckT1CUR_Client_RelatedTo.setDataFieldName("CUR_Client_RelatedTo");
	pckT1CUR_Client_RelatedTo.setPick("T4Currency_CURPickObj_datT1Currency_CUR");
	pckT1CUR_Client_RelatedTo.setDataSourceName("datT1Currency_CUR");
	pckT1CUR_Client_RelatedTo.setTabOrder(2);
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
	lblT1CUR_Client_RelatedTo.setBounds (454, 101 , 102, 18);

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
	
}