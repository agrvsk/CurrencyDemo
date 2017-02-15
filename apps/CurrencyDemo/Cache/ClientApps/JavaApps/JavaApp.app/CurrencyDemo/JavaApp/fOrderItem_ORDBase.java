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
 * fOrderItem_ORD
 */
abstract class fOrderItem_ORDBase extends VSForm {
	// Declarations for instance variables used in the form
	//{{FORM_VAR_DECL
	protected static final VersataLogger logger = VersataLogger.getLogger(JavaApp.class);
		VSLabel VSLabel141 = new VSLabel();
		VSTextField VSTextField111 = new VSTextField();
		VSTextField VSTextField11 = new VSTextField();
		VSLabel VSLabel14 = new VSLabel();
		VSLabel VSLabel131 = new VSLabel();
		VSLabel VSLabel122 = new VSLabel();
		VSLabel VSLabel121 = new VSLabel();
		VSLabel VSLabel13 = new VSLabel();
		VSLabel VSLabel12 = new VSLabel();
		VSLabel VSLabel11 = new VSLabel();
		VSLabel VSLabel1 = new VSLabel();
		VSTextField VSTextField1 = new VSTextField();
		VSTextArea VSTextArea1 = new VSTextArea();
		VSScrollPane scrlVSTextArea1 = new VSScrollPane(VSTextArea1);
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
		VSPickChoice pckT1ORD_Month = new VSPickChoice();
		VSLabel lblT1ORD_Month = new VSLabel();
		VSPickChoice pckT1ORD_CurrencyCode = new VSPickChoice();
		VSLabel lblT1ORD_CurrencyCode = new VSLabel();
		VSLabel lblT1ORD_AmountInLocalCurrency = new VSLabel();
		VSTextField txtT1ORD_AmountInLocalCurrency = new VSTextField();
		VSChoice vscT1ORD_Approved = new VSChoice();
		VSLabel lblT1ORD_Approved = new VSLabel();
		VSJavaDataControl datT1OrderItem_ORD = new VSJavaDataControl("datT1OrderItem_ORD");    
		VSGrid grdT1OrderItem_ORD = new VSGrid();
		VSScrollPane scrlgrdT1OrderItem_ORD = new VSScrollPane(grdT1OrderItem_ORD);
		VSLabel lblT4OBT_Month = new VSLabel();
		VSTextField txtT4OBT_Month = new VSTextField();
		VSJavaDataControl datT4OrderBacklogPerMonth_OBT = new VSJavaDataControl("datT4OrderBacklogPerMonth_OBT");    
		VSPick T3OrderBacklogPerMonth_OBTPickObj_datT1OrderItem_ORD = null;
		VSPick T2Currency_CURPickObj_datT1OrderItem_ORD = null;
	
	//END_FORM_VAR_DECL}}

	public fOrderItem_ORDBase() throws VSException, java.beans.PropertyVetoException {
		//{{FORM_OBJ_CTOR
			setLayout (null);
		
		beforeFormInitialize();
		
		setName("fOrderItem_ORD");
		
		
			initVSLabelVSLabel141();
			
			 initVSTextFieldVSTextField111();
			
			 initVSTextFieldVSTextField11();
			
			initVSLabelVSLabel14();
			
			initVSLabelVSLabel131();
			
			initVSLabelVSLabel122();
			
			initVSLabelVSLabel121();
			
			initVSLabelVSLabel13();
			
			initVSLabelVSLabel12();
			
			initVSLabelVSLabel11();
			
			initVSLabelVSLabel1();
			
			 initVSTextFieldVSTextField1();
			
			initVSTextAreaVSTextArea1();
			
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
			
			initVSPickChoicepckT1ORD_Month();		
			
			initVSLabellblT1ORD_Month();
			
			initVSPickChoicepckT1ORD_CurrencyCode();		
			
			initVSLabellblT1ORD_CurrencyCode();
			
			initVSLabellblT1ORD_AmountInLocalCurrency();
			
			 initVSTextFieldtxtT1ORD_AmountInLocalCurrency();
			
			 initVSChoicevscT1ORD_Approved();
			
			initVSLabellblT1ORD_Approved();
			
			initVSJavaDataControldatT1OrderItem_ORD();
			
			initVSGridgrdT1OrderItem_ORD();
			
			initVSLabellblT4OBT_Month();
			
			 initVSTextFieldtxtT4OBT_Month();
			
			initVSJavaDataControldatT4OrderBacklogPerMonth_OBT();
			
				
			datT4OrderBacklogPerMonth_OBT.setDataSourceName("datT1OrderItem_ORD");
		
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

	
	
	
	
	
	public void initVSLabelVSLabel141() {
	VSLabel141.setText("VSTextfield Tab is working");
	VSLabel141.setAlignment(VSLabel.LEFT);
	VSLabel141.setName ("VSLabel141");
		VSLabel141.setForeground(new Color(0x008080));
		VSLabel141.setBackground(Color.lightGray);
	VSLabel141.setBounds (198, 316 , 182, 15);

VSLabel141.setFont (new Font ("Helvetica", 0, 12));

 	VSLabel141.setBorderStyle(VSLabel.NO_BORDER);	 
	VSLabel141.setDataSourceName("");
	VSLabel141.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	VSLabel141.setVerticalAlignment (SwingConstants.CENTER);
	VSLabel141.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (VSLabel141,null);             
	} // end of initVSLabelVSLabel141()
	
	
	
	
	public void initVSTextFieldVSTextField111() { 
	VSTextField111.setName ("VSTextField111");
		VSTextField111.setForeground(Color.black);
		VSTextField111.setBackground(Color.white);
	VSTextField111.setBounds (90, 315 , 106, 18);

VSTextField111.setFont (new Font ("Helvetica", 0, 12));

 	VSTextField111.setDataSourceName("");
	VSTextField111.setTabOrder(5);
	VSTextField111.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (VSTextField111,null);             
	} // end of initVSTextFieldVSTextField111()
	
	
	
	
	
	
	public void initVSTextFieldVSTextField11() { 
	VSTextField11.setName ("VSTextField11");
		VSTextField11.setForeground(Color.black);
		VSTextField11.setBackground(Color.white);
	VSTextField11.setBounds (92, 255 , 106, 18);

VSTextField11.setFont (new Font ("Helvetica", 0, 12));

 	VSTextField11.setDataSourceName("");
	VSTextField11.setTabOrder(3);
	VSTextField11.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (VSTextField11,null);             
	} // end of initVSTextFieldVSTextField11()
	
	
	
	
	
	
	
	
	public void initVSLabelVSLabel14() {
	VSLabel14.setText("VSTextfield Tab is working");
	VSLabel14.setAlignment(VSLabel.LEFT);
	VSLabel14.setName ("VSLabel14");
		VSLabel14.setForeground(new Color(0x008080));
		VSLabel14.setBackground(Color.lightGray);
	VSLabel14.setBounds (199, 257 , 182, 15);

VSLabel14.setFont (new Font ("Helvetica", 0, 12));

 	VSLabel14.setBorderStyle(VSLabel.NO_BORDER);	 
	VSLabel14.setDataSourceName("");
	VSLabel14.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	VSLabel14.setVerticalAlignment (SwingConstants.CENTER);
	VSLabel14.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (VSLabel14,null);             
	} // end of initVSLabelVSLabel14()
	
	
	
	
	
	
	public void initVSLabelVSLabel131() {
	VSLabel131.setText("VSTextfield Tab is working");
	VSLabel131.setAlignment(VSLabel.LEFT);
	VSLabel131.setName ("VSLabel131");
		VSLabel131.setForeground(new Color(0x008080));
		VSLabel131.setBackground(Color.lightGray);
	VSLabel131.setBounds (129, 450 , 182, 15);

VSLabel131.setFont (new Font ("Helvetica", 0, 12));

 	VSLabel131.setBorderStyle(VSLabel.NO_BORDER);	 
	VSLabel131.setDataSourceName("");
	VSLabel131.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	VSLabel131.setVerticalAlignment (SwingConstants.CENTER);
	VSLabel131.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (VSLabel131,null);             
	} // end of initVSLabelVSLabel131()
	
	
	
	
	
	
	public void initVSLabelVSLabel122() {
	VSLabel122.setText("VSChoice Tab use ctrl+tab in query mode");
	VSLabel122.setAlignment(VSLabel.LEFT);
	VSLabel122.setName ("VSLabel122");
		VSLabel122.setForeground(new Color(0x408080));
		VSLabel122.setBackground(Color.lightGray);
	VSLabel122.setBounds (209, 408 , 177, 35);

VSLabel122.setFont (new Font ("Helvetica", 0, 12));

 	VSLabel122.setBorderStyle(VSLabel.NO_BORDER);	 
	VSLabel122.setDataSourceName("");
	VSLabel122.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	VSLabel122.setVerticalAlignment (SwingConstants.CENTER);
	VSLabel122.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (VSLabel122,null);             
	} // end of initVSLabelVSLabel122()
	
	
	
	
	
	
	public void initVSLabelVSLabel121() {
	VSLabel121.setText("VSPickChoice Tab back use ctrl+tab");
	VSLabel121.setAlignment(VSLabel.LEFT);
	VSLabel121.setName ("VSLabel121");
		VSLabel121.setForeground(new Color(0x408080));
		VSLabel121.setBackground(Color.lightGray);
	VSLabel121.setBounds (214, 345 , 175, 33);

VSLabel121.setFont (new Font ("Helvetica", 0, 12));

 	VSLabel121.setBorderStyle(VSLabel.NO_BORDER);	 
	VSLabel121.setDataSourceName("");
	VSLabel121.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	VSLabel121.setVerticalAlignment (SwingConstants.CENTER);
	VSLabel121.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (VSLabel121,null);             
	} // end of initVSLabelVSLabel121()
	
	
	
	
	
	
	public void initVSLabelVSLabel13() {
	VSLabel13.setText("VSTextfield Tab is working");
	VSLabel13.setAlignment(VSLabel.LEFT);
	VSLabel13.setName ("VSLabel13");
		VSLabel13.setForeground(new Color(0x008080));
		VSLabel13.setBackground(Color.lightGray);
	VSLabel13.setBounds (162, 385 , 182, 15);

VSLabel13.setFont (new Font ("Helvetica", 0, 12));

 	VSLabel13.setBorderStyle(VSLabel.NO_BORDER);	 
	VSLabel13.setDataSourceName("");
	VSLabel13.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	VSLabel13.setVerticalAlignment (SwingConstants.CENTER);
	VSLabel13.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (VSLabel13,null);             
	} // end of initVSLabelVSLabel13()
	
	
	
	
	
	
	public void initVSLabelVSLabel12() {
	VSLabel12.setText("VSPickChoice Tab out use ctrl+tab");
	VSLabel12.setAlignment(VSLabel.LEFT);
	VSLabel12.setName ("VSLabel12");
		VSLabel12.setForeground(new Color(0x408080));
		VSLabel12.setBackground(Color.lightGray);
	VSLabel12.setBounds (213, 283 , 216, 27);

VSLabel12.setFont (new Font ("Helvetica", 0, 12));

 	VSLabel12.setBorderStyle(VSLabel.NO_BORDER);	 
	VSLabel12.setDataSourceName("");
	VSLabel12.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	VSLabel12.setVerticalAlignment (SwingConstants.CENTER);
	VSLabel12.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (VSLabel12,null);             
	} // end of initVSLabelVSLabel12()
	
	
	
	
	
	
	public void initVSLabelVSLabel11() {
	VSLabel11.setText("VSTextarea Tab out from use ctrl+tab");
	VSLabel11.setAlignment(VSLabel.LEFT);
	VSLabel11.setName ("VSLabel11");
		VSLabel11.setForeground(new Color(0x408080));
		VSLabel11.setBackground(Color.lightGray);
	VSLabel11.setBounds (259, 222 , 224, 20);

VSLabel11.setFont (new Font ("Helvetica", 0, 12));

 	VSLabel11.setBorderStyle(VSLabel.NO_BORDER);	 
	VSLabel11.setDataSourceName("");
	VSLabel11.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	VSLabel11.setVerticalAlignment (SwingConstants.CENTER);
	VSLabel11.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (VSLabel11,null);             
	} // end of initVSLabelVSLabel11()
	
	
	
	
	
	
	public void initVSLabelVSLabel1() {
	VSLabel1.setText("VSTextfield Tab is working");
	VSLabel1.setAlignment(VSLabel.LEFT);
	VSLabel1.setName ("VSLabel1");
		VSLabel1.setForeground(new Color(0x008080));
		VSLabel1.setBackground(Color.lightGray);
	VSLabel1.setBounds (228, 200 , 182, 15);

VSLabel1.setFont (new Font ("Helvetica", 0, 12));

 	VSLabel1.setBorderStyle(VSLabel.NO_BORDER);	 
	VSLabel1.setDataSourceName("");
	VSLabel1.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	VSLabel1.setVerticalAlignment (SwingConstants.CENTER);
	VSLabel1.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (VSLabel1,null);             
	} // end of initVSLabelVSLabel1()
	
	
	
	
	public void initVSTextFieldVSTextField1() { 
	VSTextField1.setName ("VSTextField1");
		VSTextField1.setForeground(Color.black);
		VSTextField1.setBackground(Color.white);
	VSTextField1.setBounds (114, 198 , 106, 18);

VSTextField1.setFont (new Font ("Helvetica", 0, 12));

 	VSTextField1.setDataSourceName("");
	VSTextField1.setTabOrder(1);
	VSTextField1.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (VSTextField1,null);             
	} // end of initVSTextFieldVSTextField1()
	
	
	
	
	
	
	
	public void initVSTextAreaVSTextArea1() {
	VSTextArea1.setName ("VSTextArea1");
		VSTextArea1.setForeground(Color.black);
		VSTextArea1.setBackground(Color.white);
	scrlVSTextArea1.setBounds(new Rectangle(92, 219 , 161, 30));

VSTextArea1.setFont (new Font ("Helvetica", 0, 12));

 	VSTextArea1.setDataSourceName("");
	VSTextArea1.setTabOrder(2);
	VSTextArea1.setDisplayMode(VSQueryable.Data_Query);
        
      // container is form
add(scrlVSTextArea1,null);       
	} // end of initVSTextAreaVSTextArea1() 
	
	
	
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
	btnDelete.setTabOrder(11);
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
	btnSave.setTabOrder(12);
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
	btnUndo.setTabOrder(13);
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
	btnMoveFirst.setTabOrder(14);
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
	btnMovePrev.setTabOrder(15);
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
	btnMoveNext.setTabOrder(16);
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
	btnMoveLast.setTabOrder(17);
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
	btnRunQuery.setTabOrder(18);
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
	btnQueryMode.setTabOrder(19);
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
	btnQueryMode1.setTabOrder(20);
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
	btnCancelQuery.setTabOrder(21);
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
	btnEditSql.setTabOrder(22);
	btnEditSql.setToolTipText ("Edit SQL");
	btnEditSql.setBorderStyle (VSImageButton.AUTOSHOW_BORDER);
        
      // container is form
add (btnEditSql,null);             
	} // end of initVSImageButtonbtnEditSql()
	
	
	
	
	
	
	
	
	
	
	
	public void initVSPickChoicepckT1ORD_Month() {		
	
	pckT1ORD_Month.setName ("pckT1ORD_Month");
		pckT1ORD_Month.setForeground(Color.black);
		pckT1ORD_Month.setBackground(Color.white);
	pckT1ORD_Month.setBounds (89, 283 , 120, 20);

pckT1ORD_Month.setFont (new Font ("Helvetica", 0, 12));

	pckT1ORD_Month.setTag ("_$$_");
 	pckT1ORD_Month.setDataFieldName("ORD_Month");
	pckT1ORD_Month.setPick("T3OrderBacklogPerMonth_OBTPickObj_datT1OrderItem_ORD");
	pckT1ORD_Month.setDataSourceName("datT1OrderItem_ORD");
	pckT1ORD_Month.setTabOrder(4);
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
	lblT1ORD_Month.setBounds (9, 292 , 102, 18);

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
	pckT1ORD_CurrencyCode.setBounds (90, 349 , 120, 20);

pckT1ORD_CurrencyCode.setFont (new Font ("Helvetica", 0, 12));

	pckT1ORD_CurrencyCode.setTag ("_$$_");
 	pckT1ORD_CurrencyCode.setDataFieldName("ORD_CurrencyCode");
	pckT1ORD_CurrencyCode.setPick("T2Currency_CURPickObj_datT1OrderItem_ORD");
	pckT1ORD_CurrencyCode.setDataSourceName("datT1OrderItem_ORD");
	pckT1ORD_CurrencyCode.setTabOrder(6);
	pckT1ORD_CurrencyCode.setToolTipText ("CurrencyCode");
	pckT1ORD_CurrencyCode.setDisplayMode(VSQueryable.Data);
        
      // container is form
add (pckT1ORD_CurrencyCode,null);             
	} // end of initVSPickChoicepckT1ORD_CurrencyCode()
	
	
	
	
	
	
	public void initVSLabellblT1ORD_CurrencyCode() {
	lblT1ORD_CurrencyCode.setText("CurrencyCode");
	lblT1ORD_CurrencyCode.setAlignment(VSLabel.LEFT);
	lblT1ORD_CurrencyCode.setName ("lblT1ORD_CurrencyCode");
		lblT1ORD_CurrencyCode.setForeground(Color.black);
		lblT1ORD_CurrencyCode.setBackground(Color.lightGray);
	lblT1ORD_CurrencyCode.setBounds (10, 350 , 102, 18);

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
	lblT1ORD_AmountInLocalCurrency.setBounds (9, 384 , 77, 17);

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
	txtT1ORD_AmountInLocalCurrency.setBounds (89, 382 , 64, 21);

txtT1ORD_AmountInLocalCurrency.setFont (new Font ("Helvetica", 0, 12));

	txtT1ORD_AmountInLocalCurrency.setTag ("_$$_");
 	txtT1ORD_AmountInLocalCurrency.setDataSourceName("datT1OrderItem_ORD");
	txtT1ORD_AmountInLocalCurrency.setDataFieldName("ORD_AmountInLocalCurrency");
	txtT1ORD_AmountInLocalCurrency.setTabOrder(7);
	txtT1ORD_AmountInLocalCurrency.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT1ORD_AmountInLocalCurrency,null);             
	} // end of initVSTextFieldtxtT1ORD_AmountInLocalCurrency()
	
	
	
	
	
	
	
	
	public void initVSChoicevscT1ORD_Approved() { 
	vscT1ORD_Approved.setName ("vscT1ORD_Approved");
		vscT1ORD_Approved.setForeground(Color.black);
		vscT1ORD_Approved.setBackground(Color.white);
	vscT1ORD_Approved.setBounds (89, 414 , 114, 23);

vscT1ORD_Approved.setFont (new Font ("Helvetica", 0, 12));

	vscT1ORD_Approved.setTag ("_$$_");
 	vscT1ORD_Approved.setEditable (false);
	vscT1ORD_Approved.setLoadCodeTableAsync(true);			
	VSApplicationContext.loadCodeTableAsync ("Z_YesNo", vscT1ORD_Approved);
	vscT1ORD_Approved.setDataSourceName("datT1OrderItem_ORD");
	vscT1ORD_Approved.setDataFieldName ("ORD_Approved");
	vscT1ORD_Approved.setTabOrder(8);
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
	lblT1ORD_Approved.setBounds (9, 417 , 102, 18);

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
	datT1OrderItem_ORD.setBounds (308, 370 , 252, 27);

datT1OrderItem_ORD.setFont (new Font ("Helvetica", 0, 12));
	datT1OrderItem_ORD.setVisible(false);

	datT1OrderItem_ORD.setTag ("_$$_");
 	datT1OrderItem_ORD.setTabOrder(23);
	datT1OrderItem_ORD.setTabStop (false);
	setRootDataControl(datT1OrderItem_ORD);
	datT1OrderItem_ORD.setMaxRowsPerFetch(16);
	datT1OrderItem_ORD.setSaveMode (VSJavaDataControl.SAVE_BUFFERED);
	datT1OrderItem_ORD.setDataDependency (false, false);
        


      // container is form
add (datT1OrderItem_ORD,null);             
	
	
	T3OrderBacklogPerMonth_OBTPickObj_datT1OrderItem_ORD = new VSPick ("T3OrderBacklogPerMonth_OBTPickObj_datT1OrderItem_ORD", "datT1OrderItem_ORD",
					"OrderBacklogPerMonth_OBT", "", "", "[OBT_Client] = [?ORD_Client] and [OBT_Month] = [?ORD_Month]", "", "OBT_Month, OBT_OrderValueUSD, OBT_Client", "genericPick");
	T3OrderBacklogPerMonth_OBTPickObj_datT1OrderItem_ORD.setParentTableAlias("");


	addPick(T3OrderBacklogPerMonth_OBTPickObj_datT1OrderItem_ORD);
                    T3OrderBacklogPerMonth_OBTPickObj_datT1OrderItem_ORD.setStyle(VSPick.STYLE_DROPDOWN);

	T2Currency_CURPickObj_datT1OrderItem_ORD = new VSPick ("T2Currency_CURPickObj_datT1OrderItem_ORD", "datT1OrderItem_ORD",
					"Currency_CUR", "", "", "[CUR_Client] = [?ORD_Client] and [CUR_CurrencyCode] = [?ORD_CurrencyCode]", "[CUR_ExchangeRate]=[?ORD_ExchangeRate]", "CUR_CurrencyCode, CUR_ExchangeRate, CUR_OrderValueUSD, CUR_NumberOfOrders, CUR_OrderAmountAverage, CUR_Image, CUR_CurrencyCode_RelatedTo, CUR_Client, CUR_Client_RelatedTo", "genericPick");
	T2Currency_CURPickObj_datT1OrderItem_ORD.setParentTableAlias("");


	addPick(T2Currency_CURPickObj_datT1OrderItem_ORD);
                    T2Currency_CURPickObj_datT1OrderItem_ORD.setStyle(VSPick.STYLE_DROPDOWN);

	} // end of initVSJavaDataControldatT1OrderItem_ORD()
	
	
	
	
	
	
	
	
	
	
	
	
	public void initVSGridgrdT1OrderItem_ORD() {
	grdT1OrderItem_ORD.setName ("grdT1OrderItem_ORD");
		grdT1OrderItem_ORD.setForeground(Color.black);
		grdT1OrderItem_ORD.setBackground(Color.white);
	scrlgrdT1OrderItem_ORD.setBounds(new Rectangle(6, 34 , 562, 158));

grdT1OrderItem_ORD.setFont (new Font ("Helvetica", 0, 12));

	grdT1OrderItem_ORD.setTag ("_$$_");
 	grdT1OrderItem_ORD.setAutoResizeMode (JTable.AUTO_RESIZE_OFF);
	grdT1OrderItem_ORD.setColumnHeaderHeight(17);
	grdT1OrderItem_ORD.setRowSelectionAllowed(false);
	grdT1OrderItem_ORD.setTabOrder(24);
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
				gridCol.setEditType(VSGrid.EDIT_VSPICKCHOICE);
				gridCol.setPickName ("T2Currency_CURPickObj_datT1OrderItem_ORD");
				gridCol.setSortAllowed(true);
				
				gridCol = grdT1OrderItem_ORD.addColumn ();
				gridCol.setDataFieldName ("ORD_OrderId");
				gridCol.setLabel ("OrderId");
				gridCol.setPreferredWidth (55);
				gridCol.setSortAllowed(true);
				
				gridCol = grdT1OrderItem_ORD.addColumn ();
				gridCol.setDataFieldName ("ORD_Month");
				gridCol.setLabel ("Month");
				gridCol.setPreferredWidth (47);
				gridCol.setEditType(VSGrid.EDIT_VSPICKCHOICE);
				gridCol.setPickName ("T3OrderBacklogPerMonth_OBTPickObj_datT1OrderItem_ORD");
				gridCol.setSortAllowed(true);
				
				gridCol = grdT1OrderItem_ORD.addColumn ();
				gridCol.setDataFieldName ("ORD_CurrencyCode");
				gridCol.setLabel ("CurrencyCode");
				gridCol.setPreferredWidth (92);
				gridCol.setEditType(VSGrid.EDIT_VSPICKCHOICE);
				gridCol.setPickName ("T2Currency_CURPickObj_datT1OrderItem_ORD");
				gridCol.setSortAllowed(true);
				
				gridCol = grdT1OrderItem_ORD.addColumn ();
				gridCol.setDataFieldName ("ORD_AmountInLocalCurrency");
				gridCol.setLabel ("AmountInLocalCurrency");
				gridCol.setPreferredWidth (109);
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
	
	
	
	
	
	
	public void initVSLabellblT4OBT_Month() {
	lblT4OBT_Month.setText("Month");
	lblT4OBT_Month.setAlignment(VSLabel.LEFT);
	lblT4OBT_Month.setName ("lblT4OBT_Month");
		lblT4OBT_Month.setForeground(Color.black);
		lblT4OBT_Month.setBackground(Color.lightGray);
	lblT4OBT_Month.setBounds (11, 449 , 75, 18);

lblT4OBT_Month.setFont (new Font ("Helvetica", 0, 12));

	lblT4OBT_Month.setTag ("_$$_");
 	lblT4OBT_Month.setBorderStyle(VSLabel.NO_BORDER);	 
	lblT4OBT_Month.setDataSourceName("");
	lblT4OBT_Month.setHorizontalTextPosition (SwingConstants.RIGHT);		 
	lblT4OBT_Month.setVerticalAlignment (SwingConstants.CENTER);
	lblT4OBT_Month.setVerticalTextPosition (SwingConstants.BOTTOM);	 
	 	   	 
        
      // container is form
add (lblT4OBT_Month,null);             
	} // end of initVSLabellblT4OBT_Month()
	
	
	
	
	public void initVSTextFieldtxtT4OBT_Month() { 
	txtT4OBT_Month.setName ("txtT4OBT_Month");
		txtT4OBT_Month.setForeground(Color.black);
		txtT4OBT_Month.setBackground(Color.white);
	txtT4OBT_Month.setBounds (91, 447 , 31, 20);

txtT4OBT_Month.setFont (new Font ("Helvetica", 0, 12));

	txtT4OBT_Month.setTag ("_$$_");
 	txtT4OBT_Month.setDataSourceName("datT4OrderBacklogPerMonth_OBT");
	txtT4OBT_Month.setDataFieldName("OBT_Month");
	txtT4OBT_Month.setTabOrder(9);
	txtT4OBT_Month.setDisplayMode(VSQueryable.Data_Query);
        		
      // container is form
add (txtT4OBT_Month,null);             
	} // end of initVSTextFieldtxtT4OBT_Month()
	
	
	
	public void initVSJavaDataControldatT4OrderBacklogPerMonth_OBT() { 
	datT4OrderBacklogPerMonth_OBT.setLabel ("OrderBacklogPerMonth_OBT");
	datT4OrderBacklogPerMonth_OBT.setQueryInfo(new VSQueryInfo("OrderBacklogPerMonth_OBT", "", "", "[OBT_Client] = [?ORD_Client] and [OBT_Month] = [?ORD_Month]", false));
	datT4OrderBacklogPerMonth_OBT.setName ("datT4OrderBacklogPerMonth_OBT");
		datT4OrderBacklogPerMonth_OBT.setForeground(Color.black);
		datT4OrderBacklogPerMonth_OBT.setBackground(Color.white);
	datT4OrderBacklogPerMonth_OBT.setBounds (352, 293 , 201, 25);

datT4OrderBacklogPerMonth_OBT.setFont (new Font ("Helvetica", 0, 12));
	datT4OrderBacklogPerMonth_OBT.setVisible(false);

	datT4OrderBacklogPerMonth_OBT.setTag ("_$$_");
 	datT4OrderBacklogPerMonth_OBT.setTabOrder(10);
	datT4OrderBacklogPerMonth_OBT.setTabStop (false);
	datT4OrderBacklogPerMonth_OBT.setMaxRowsPerFetch(1);
	datT4OrderBacklogPerMonth_OBT.setSaveMode (VSJavaDataControl.SAVE_IMMEDIATE);
	datT4OrderBacklogPerMonth_OBT.setDataDependency (false, true);
        


      // container is form
add (datT4OrderBacklogPerMonth_OBT,null);             
	
	
	} // end of initVSJavaDataControldatT4OrderBacklogPerMonth_OBT()
	
	
	
	
	
	
}