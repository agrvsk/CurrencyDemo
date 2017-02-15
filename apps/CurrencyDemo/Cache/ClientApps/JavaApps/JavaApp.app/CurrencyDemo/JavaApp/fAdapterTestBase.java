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
 * fAdapterTest
 */
abstract class fAdapterTestBase extends VSForm {
	// Declarations for instance variables used in the form
	//{{FORM_VAR_DECL
	protected static final VersataLogger logger = VersataLogger.getLogger(JavaApp.class);
		VSButton btn0032231 = new VSButton();
		VSButton btn0031381 = new VSButton();
		VSButton btn0031371 = new VSButton();
		VSButton btn002211 = new VSButton();
		VSButton btn001211 = new VSButton();
		VSButton btn0034201 = new VSButton();
		VSButton btn0033211 = new VSButton();
		VSButton btn0032221 = new VSButton();
		VSButton btn0031361 = new VSButton();
		VSButton btn0031351 = new VSButton();
		VSButton btn002201 = new VSButton();
		VSButton btn001201 = new VSButton();
		VSButton btn00310191 = new VSButton();
		VSButton btn0039191 = new VSButton();
		VSButton btn0038191 = new VSButton();
		VSButton btn0037191 = new VSButton();
		VSButton btn0036191 = new VSButton();
		VSButton btn0035191 = new VSButton();
		VSButton btn0034191 = new VSButton();
		VSButton btn0033201 = new VSButton();
		VSButton btn0032211 = new VSButton();
		VSButton btn0031341 = new VSButton();
		VSButton btn0031331 = new VSButton();
		VSButton btn002191 = new VSButton();
		VSButton btn001191 = new VSButton();
		VSButton btn00311211 = new VSButton();
		VSButton btn00310181 = new VSButton();
		VSButton btn0039181 = new VSButton();
		VSButton btn0038181 = new VSButton();
		VSButton btn0037181 = new VSButton();
		VSButton btn0036181 = new VSButton();
		VSButton btn0035181 = new VSButton();
		VSButton btn0034181 = new VSButton();
		VSButton btn0033191 = new VSButton();
		VSButton btn0032201 = new VSButton();
		VSButton btn0031321 = new VSButton();
		VSButton btn0031311 = new VSButton();
		VSButton btn002181 = new VSButton();
		VSButton btn001181 = new VSButton();
		VSButton btn00311201 = new VSButton();
		VSButton btn00310171 = new VSButton();
		VSButton btn0039171 = new VSButton();
		VSButton btn0038171 = new VSButton();
		VSButton btn0037171 = new VSButton();
		VSButton btn0036171 = new VSButton();
		VSButton btn0035171 = new VSButton();
		VSButton btn0034171 = new VSButton();
		VSButton btn0033181 = new VSButton();
		VSButton btn0032191 = new VSButton();
		VSButton btn0031301 = new VSButton();
		VSButton btn0031291 = new VSButton();
		VSButton btn002171 = new VSButton();
		VSButton btn00311191 = new VSButton();
		VSButton btn00310161 = new VSButton();
		VSButton btn0039161 = new VSButton();
		VSButton btn0038161 = new VSButton();
		VSButton btn0037161 = new VSButton();
		VSButton btn0036161 = new VSButton();
		VSButton btn0035161 = new VSButton();
		VSButton btn0034161 = new VSButton();
		VSButton btn0033171 = new VSButton();
		VSButton btn0032181 = new VSButton();
		VSButton btn0031281 = new VSButton();
		VSButton btn0031001 = new VSButton();
		VSButton btn00311181 = new VSButton();
		VSButton btn00310151 = new VSButton();
		VSButton btn0039151 = new VSButton();
		VSButton btn0038151 = new VSButton();
		VSButton btn0037151 = new VSButton();
		VSButton btn0036151 = new VSButton();
		VSButton btn0035151 = new VSButton();
		VSButton btn0034151 = new VSButton();
		VSButton btn0033161 = new VSButton();
		VSButton btn0032171 = new VSButton();
		VSButton btn0031271 = new VSButton();
		VSButton btn00311171 = new VSButton();
		VSButton btn00310141 = new VSButton();
		VSButton btn0039141 = new VSButton();
		VSButton btn0038141 = new VSButton();
		VSButton btn0037141 = new VSButton();
		VSButton btn0036141 = new VSButton();
		VSButton btn0035141 = new VSButton();
		VSButton btn0034141 = new VSButton();
		VSButton btn0033151 = new VSButton();
		VSButton btn0032161 = new VSButton();
		VSButton btn0031261 = new VSButton();
		VSButton btn00311161 = new VSButton();
		VSButton btn00310131 = new VSButton();
		VSButton btn0039131 = new VSButton();
		VSButton btn0038131 = new VSButton();
		VSButton btn0037131 = new VSButton();
		VSButton btn0036131 = new VSButton();
		VSButton btn0035131 = new VSButton();
		VSButton btn0034131 = new VSButton();
		VSButton btn0033141 = new VSButton();
		VSButton btn0032151 = new VSButton();
		VSButton btn0031251 = new VSButton();
		VSButton btn003701 = new VSButton();
		VSButton btn002131 = new VSButton();
		VSButton btn00311151 = new VSButton();
		VSButton btn00310121 = new VSButton();
		VSButton btn0039121 = new VSButton();
		VSButton btn0038121 = new VSButton();
		VSButton btn0037121 = new VSButton();
		VSButton btn0036121 = new VSButton();
		VSButton btn0035121 = new VSButton();
		VSButton btn0034121 = new VSButton();
		VSButton btn0033131 = new VSButton();
		VSButton btn0032141 = new VSButton();
		VSButton btn0031241 = new VSButton();
		VSButton btn003601 = new VSButton();
		VSButton btn002121 = new VSButton();
		VSButton btn001121 = new VSButton();
		VSButton btn00311141 = new VSButton();
		VSButton btn00310111 = new VSButton();
		VSButton btn0039111 = new VSButton();
		VSButton btn0038111 = new VSButton();
		VSButton btn0037111 = new VSButton();
		VSButton btn0036111 = new VSButton();
		VSButton btn0035111 = new VSButton();
		VSButton btn0034111 = new VSButton();
		VSButton btn0033121 = new VSButton();
		VSButton btn0032131 = new VSButton();
		VSButton btn0031231 = new VSButton();
		VSButton btn003501 = new VSButton();
		VSButton btn002111 = new VSButton();
		VSButton btn00311131 = new VSButton();
		VSButton btn00310101 = new VSButton();
		VSButton btn0039101 = new VSButton();
		VSButton btn0038101 = new VSButton();
		VSButton btn0037101 = new VSButton();
		VSButton btn0036101 = new VSButton();
		VSButton btn0035101 = new VSButton();
		VSButton btn0034101 = new VSButton();
		VSButton btn0033111 = new VSButton();
		VSButton btn0032121 = new VSButton();
		VSButton btn0031221 = new VSButton();
		VSButton btn003401 = new VSButton();
		VSButton btn002101 = new VSButton();
		VSButton btn0031061 = new VSButton();
		VSButton btn003961 = new VSButton();
		VSButton btn003861 = new VSButton();
		VSButton btn003761 = new VSButton();
		VSButton btn003661 = new VSButton();
		VSButton btn003561 = new VSButton();
		VSButton btn003461 = new VSButton();
		VSButton btn003361 = new VSButton();
		VSButton btn003271 = new VSButton();
		VSButton btn0031171 = new VSButton();
		VSButton btn003261 = new VSButton();
		VSButton btn00261 = new VSButton();
		VSButton btn00161 = new VSButton();
		VSButton btn0031161 = new VSButton();
		VSButton btn0031051 = new VSButton();
		VSButton btn003951 = new VSButton();
		VSButton btn003851 = new VSButton();
		VSButton btn003751 = new VSButton();
		VSButton btn003651 = new VSButton();
		VSButton btn003551 = new VSButton();
		VSButton btn003451 = new VSButton();
		VSButton btn003351 = new VSButton();
		VSButton btn003251 = new VSButton();
		VSButton btn0031151 = new VSButton();
		VSButton btn003201 = new VSButton();
		VSButton btn00251 = new VSButton();
		VSButton btn00151 = new VSButton();
		VSButton btn003151 = new VSButton();
		VSButton btn00223 = new VSButton();
		VSButton btn00123 = new VSButton();
		VSButton btn0035110 = new VSButton();
		VSButton btn0034110 = new VSButton();
		VSButton btn0033110 = new VSButton();
		VSButton btn0032110 = new VSButton();
		VSButton btn003141 = new VSButton();
		VSButton btn0031310 = new VSButton();
		VSButton btn002110 = new VSButton();
		VSButton btn001110 = new VSButton();
		VSButton btn0031210 = new VSButton();
		VSButton btn0031125 = new VSButton();
		VSButton btn0031022 = new VSButton();
		VSButton btn003922 = new VSButton();
		VSButton btn003822 = new VSButton();
		VSButton btn003722 = new VSButton();
		VSButton btn003622 = new VSButton();
		VSButton btn003522 = new VSButton();
		VSButton btn003422 = new VSButton();
		VSButton btn003323 = new VSButton();
		VSButton btn003224 = new VSButton();
		VSButton btn003140 = new VSButton();
		VSButton btn003139 = new VSButton();
		VSButton btn00222 = new VSButton();
		VSButton btn00122 = new VSButton();
		VSButton btn0031124 = new VSButton();
		VSButton btn0031021 = new VSButton();
		VSButton btn003921 = new VSButton();
		VSButton btn003821 = new VSButton();
		VSButton btn003721 = new VSButton();
		VSButton btn003621 = new VSButton();
		VSButton btn003521 = new VSButton();
		VSButton btn003421 = new VSButton();
		VSButton btn003322 = new VSButton();
		VSButton btn003223 = new VSButton();
		VSButton btn003138 = new VSButton();
		VSButton btn003137 = new VSButton();
		VSButton btn00221 = new VSButton();
		VSButton btn00121 = new VSButton();
		VSButton btn0031123 = new VSButton();
		VSButton btn0031020 = new VSButton();
		VSButton btn003920 = new VSButton();
		VSButton btn003820 = new VSButton();
		VSButton btn003720 = new VSButton();
		VSButton btn003620 = new VSButton();
		VSButton btn003520 = new VSButton();
		VSButton btn003420 = new VSButton();
		VSButton btn003321 = new VSButton();
		VSButton btn003222 = new VSButton();
		VSButton btn003136 = new VSButton();
		VSButton btn003135 = new VSButton();
		VSButton btn00220 = new VSButton();
		VSButton btn00120 = new VSButton();
		VSButton btn0031122 = new VSButton();
		VSButton btn0031019 = new VSButton();
		VSButton btn003919 = new VSButton();
		VSButton btn003819 = new VSButton();
		VSButton btn003719 = new VSButton();
		VSButton btn003619 = new VSButton();
		VSButton btn003519 = new VSButton();
		VSButton btn003419 = new VSButton();
		VSButton btn003320 = new VSButton();
		VSButton btn003221 = new VSButton();
		VSButton btn003134 = new VSButton();
		VSButton btn003133 = new VSButton();
		VSButton btn00219 = new VSButton();
		VSButton btn00119 = new VSButton();
		VSButton btn0031121 = new VSButton();
		VSButton btn0031018 = new VSButton();
		VSButton btn003918 = new VSButton();
		VSButton btn003818 = new VSButton();
		VSButton btn003718 = new VSButton();
		VSButton btn003618 = new VSButton();
		VSButton btn003518 = new VSButton();
		VSButton btn003418 = new VSButton();
		VSButton btn003319 = new VSButton();
		VSButton btn003220 = new VSButton();
		VSButton btn003132 = new VSButton();
		VSButton btn003131 = new VSButton();
		VSButton btn00218 = new VSButton();
		VSButton btn00118 = new VSButton();
		VSButton btn0031120 = new VSButton();
		VSButton btn0031017 = new VSButton();
		VSButton btn003917 = new VSButton();
		VSButton btn003817 = new VSButton();
		VSButton btn003717 = new VSButton();
		VSButton btn003617 = new VSButton();
		VSButton btn003517 = new VSButton();
		VSButton btn003417 = new VSButton();
		VSButton btn003318 = new VSButton();
		VSButton btn003219 = new VSButton();
		VSButton btn003130 = new VSButton();
		VSButton btn003129 = new VSButton();
		VSButton btn00217 = new VSButton();
		VSButton btn00117 = new VSButton();
		VSButton btn0031119 = new VSButton();
		VSButton btn0031016 = new VSButton();
		VSButton btn003916 = new VSButton();
		VSButton btn003816 = new VSButton();
		VSButton btn003716 = new VSButton();
		VSButton btn003616 = new VSButton();
		VSButton btn003516 = new VSButton();
		VSButton btn003416 = new VSButton();
		VSButton btn003317 = new VSButton();
		VSButton btn003218 = new VSButton();
		VSButton btn003128 = new VSButton();
		VSButton btn003100 = new VSButton();
		VSButton btn00216 = new VSButton();
		VSButton btn00116 = new VSButton();
		VSButton btn0031118 = new VSButton();
		VSButton btn0031015 = new VSButton();
		VSButton btn003915 = new VSButton();
		VSButton btn003815 = new VSButton();
		VSButton btn003715 = new VSButton();
		VSButton btn003615 = new VSButton();
		VSButton btn003515 = new VSButton();
		VSButton btn003415 = new VSButton();
		VSButton btn003316 = new VSButton();
		VSButton btn003217 = new VSButton();
		VSButton btn003127 = new VSButton();
		VSButton btn00390 = new VSButton();
		VSButton btn00215 = new VSButton();
		VSButton btn00115 = new VSButton();
		VSButton btn0031117 = new VSButton();
		VSButton btn0031014 = new VSButton();
		VSButton btn003914 = new VSButton();
		VSButton btn003814 = new VSButton();
		VSButton btn003714 = new VSButton();
		VSButton btn003614 = new VSButton();
		VSButton btn003514 = new VSButton();
		VSButton btn003414 = new VSButton();
		VSButton btn003315 = new VSButton();
		VSButton btn003216 = new VSButton();
		VSButton btn003126 = new VSButton();
		VSButton btn00380 = new VSButton();
		VSButton btn00214 = new VSButton();
		VSButton btn00114 = new VSButton();
		VSButton btn0031116 = new VSButton();
		VSButton btn0031013 = new VSButton();
		VSButton btn003913 = new VSButton();
		VSButton btn003813 = new VSButton();
		VSButton btn003713 = new VSButton();
		VSButton btn003613 = new VSButton();
		VSButton btn003513 = new VSButton();
		VSButton btn003413 = new VSButton();
		VSButton btn003314 = new VSButton();
		VSButton btn003215 = new VSButton();
		VSButton btn003125 = new VSButton();
		VSButton btn00370 = new VSButton();
		VSButton btn00213 = new VSButton();
		VSButton btn00113 = new VSButton();
		VSButton btn0031115 = new VSButton();
		VSButton btn0031012 = new VSButton();
		VSButton btn003912 = new VSButton();
		VSButton btn003812 = new VSButton();
		VSButton btn003712 = new VSButton();
		VSButton btn003612 = new VSButton();
		VSButton btn003512 = new VSButton();
		VSButton btn003412 = new VSButton();
		VSButton btn003313 = new VSButton();
		VSButton btn003214 = new VSButton();
		VSButton btn003124 = new VSButton();
		VSButton btn00360 = new VSButton();
		VSButton btn00212 = new VSButton();
		VSButton btn00112 = new VSButton();
		VSButton btn0031114 = new VSButton();
		VSButton btn0031011 = new VSButton();
		VSButton btn003911 = new VSButton();
		VSButton btn003811 = new VSButton();
		VSButton btn003711 = new VSButton();
		VSButton btn003611 = new VSButton();
		VSButton btn003511 = new VSButton();
		VSButton btn003411 = new VSButton();
		VSButton btn003312 = new VSButton();
		VSButton btn003213 = new VSButton();
		VSButton btn003123 = new VSButton();
		VSButton btn00350 = new VSButton();
		VSButton btn00211 = new VSButton();
		VSButton btn00111 = new VSButton();
		VSButton btn0031113 = new VSButton();
		VSButton btn0031010 = new VSButton();
		VSButton btn003910 = new VSButton();
		VSButton btn003810 = new VSButton();
		VSButton btn003710 = new VSButton();
		VSButton btn003610 = new VSButton();
		VSButton btn003510 = new VSButton();
		VSButton btn003410 = new VSButton();
		VSButton btn003311 = new VSButton();
		VSButton btn003212 = new VSButton();
		VSButton btn003122 = new VSButton();
		VSButton btn00340 = new VSButton();
		VSButton btn00210 = new VSButton();
		VSButton btn00110 = new VSButton();
		VSButton btn0031112 = new VSButton();
		VSButton btn003109 = new VSButton();
		VSButton btn00399 = new VSButton();
		VSButton btn00389 = new VSButton();
		VSButton btn00379 = new VSButton();
		VSButton btn00369 = new VSButton();
		VSButton btn00359 = new VSButton();
		VSButton btn00349 = new VSButton();
		VSButton btn003310 = new VSButton();
		VSButton btn003211 = new VSButton();
		VSButton btn003121 = new VSButton();
		VSButton btn00339 = new VSButton();
		VSButton btn0029 = new VSButton();
		VSButton btn0019 = new VSButton();
		VSButton btn0031111 = new VSButton();
		VSButton btn003108 = new VSButton();
		VSButton btn00398 = new VSButton();
		VSButton btn00388 = new VSButton();
		VSButton btn00378 = new VSButton();
		VSButton btn00368 = new VSButton();
		VSButton btn00358 = new VSButton();
		VSButton btn00348 = new VSButton();
		VSButton btn00338 = new VSButton();
		VSButton btn003210 = new VSButton();
		VSButton btn003120 = new VSButton();
		VSButton btn00330 = new VSButton();
		VSButton btn0028 = new VSButton();
		VSButton btn0018 = new VSButton();
		VSButton btn0031110 = new VSButton();
		VSButton btn003107 = new VSButton();
		VSButton btn00397 = new VSButton();
		VSButton btn00387 = new VSButton();
		VSButton btn00377 = new VSButton();
		VSButton btn00367 = new VSButton();
		VSButton btn00357 = new VSButton();
		VSButton btn00347 = new VSButton();
		VSButton btn00337 = new VSButton();
		VSButton btn00329 = new VSButton();
		VSButton btn003119 = new VSButton();
		VSButton btn00328 = new VSButton();
		VSButton btn0027 = new VSButton();
		VSButton btn0017 = new VSButton();
		VSButton btn003118 = new VSButton();
		VSButton btn003106 = new VSButton();
		VSButton btn00396 = new VSButton();
		VSButton btn00386 = new VSButton();
		VSButton btn00376 = new VSButton();
		VSButton btn00366 = new VSButton();
		VSButton btn00356 = new VSButton();
		VSButton btn00346 = new VSButton();
		VSButton btn00336 = new VSButton();
		VSButton btn00327 = new VSButton();
		VSButton btn003117 = new VSButton();
		VSButton btn00326 = new VSButton();
		VSButton btn0026 = new VSButton();
		VSButton btn0016 = new VSButton();
		VSButton btn003116 = new VSButton();
		VSButton btn003105 = new VSButton();
		VSButton btn00395 = new VSButton();
		VSButton btn00385 = new VSButton();
		VSButton btn00375 = new VSButton();
		VSButton btn00365 = new VSButton();
		VSButton btn00355 = new VSButton();
		VSButton btn00345 = new VSButton();
		VSButton btn00335 = new VSButton();
		VSButton btn00325 = new VSButton();
		VSButton btn003115 = new VSButton();
		VSButton btn00320 = new VSButton();
		VSButton btn0025 = new VSButton();
		VSButton btn0015 = new VSButton();
		VSButton btn003114 = new VSButton();
		VSButton btn003104 = new VSButton();
		VSButton btn00394 = new VSButton();
		VSButton btn00384 = new VSButton();
		VSButton btn00374 = new VSButton();
		VSButton btn00364 = new VSButton();
		VSButton btn00354 = new VSButton();
		VSButton btn00344 = new VSButton();
		VSButton btn00334 = new VSButton();
		VSButton btn00324 = new VSButton();
		VSButton btn003110 = new VSButton();
		VSButton btn00319 = new VSButton();
		VSButton btn0024 = new VSButton();
		VSButton btn0014 = new VSButton();
		VSButton btn003113 = new VSButton();
		VSButton btn003103 = new VSButton();
		VSButton btn00393 = new VSButton();
		VSButton btn00383 = new VSButton();
		VSButton btn00373 = new VSButton();
		VSButton btn00363 = new VSButton();
		VSButton btn00353 = new VSButton();
		VSButton btn00343 = new VSButton();
		VSButton btn00333 = new VSButton();
		VSButton btn00323 = new VSButton();
		VSButton btn00318 = new VSButton();
		VSButton btn00317 = new VSButton();
		VSButton btn0023 = new VSButton();
		VSButton btn0013 = new VSButton();
		VSButton btn003112 = new VSButton();
		VSButton btn003102 = new VSButton();
		VSButton btn00392 = new VSButton();
		VSButton btn00382 = new VSButton();
		VSButton btn00372 = new VSButton();
		VSButton btn00362 = new VSButton();
		VSButton btn00352 = new VSButton();
		VSButton btn00342 = new VSButton();
		VSButton btn00332 = new VSButton();
		VSButton btn00322 = new VSButton();
		VSButton btn00316 = new VSButton();
		VSButton btn00315 = new VSButton();
		VSButton btn0022 = new VSButton();
		VSButton btn0012 = new VSButton();
		VSButton btn003111 = new VSButton();
		VSButton btn003101 = new VSButton();
		VSButton btn00391 = new VSButton();
		VSButton btn00381 = new VSButton();
		VSButton btn00371 = new VSButton();
		VSButton btn00361 = new VSButton();
		VSButton btn00351 = new VSButton();
		VSButton btn00341 = new VSButton();
		VSButton btn00331 = new VSButton();
		VSButton btn00321 = new VSButton();
		VSButton btn00314 = new VSButton();
		VSButton btn00313 = new VSButton();
		VSButton btn0021 = new VSButton();
		VSButton btn0011 = new VSButton();
		VSButton btn00312 = new VSButton();
		VSButton btn00311 = new VSButton();
		VSButton btn00310 = new VSButton();
		VSButton btn0039 = new VSButton();
		VSButton btn0038 = new VSButton();
		VSButton btn0037 = new VSButton();
		VSButton btn0036 = new VSButton();
		VSButton btn0035 = new VSButton();
		VSButton btn0034 = new VSButton();
		VSButton btn0033 = new VSButton();
		VSButton btn0032 = new VSButton();
		VSButton btn0031 = new VSButton();
		VSButton btn003 = new VSButton();
		VSButton btn002 = new VSButton();
		VSButton btn001 = new VSButton();
	
	//END_FORM_VAR_DECL}}

	public fAdapterTestBase() throws VSException, java.beans.PropertyVetoException {
		//{{FORM_OBJ_CTOR
			setLayout (null);
		
		beforeFormInitialize();
		
		setName("fAdapterTest");
		
		
			 initVSButtonbtn0032231();
			
			 initVSButtonbtn0031381();
			
			 initVSButtonbtn0031371();
			
			 initVSButtonbtn002211();
			
			 initVSButtonbtn001211();
			
			 initVSButtonbtn0034201();
			
			 initVSButtonbtn0033211();
			
			 initVSButtonbtn0032221();
			
			 initVSButtonbtn0031361();
			
			 initVSButtonbtn0031351();
			
			 initVSButtonbtn002201();
			
			 initVSButtonbtn001201();
			
			 initVSButtonbtn00310191();
			
			 initVSButtonbtn0039191();
			
			 initVSButtonbtn0038191();
			
			 initVSButtonbtn0037191();
			
			 initVSButtonbtn0036191();
			
			 initVSButtonbtn0035191();
			
			 initVSButtonbtn0034191();
			
			 initVSButtonbtn0033201();
			
			 initVSButtonbtn0032211();
			
			 initVSButtonbtn0031341();
			
			 initVSButtonbtn0031331();
			
			 initVSButtonbtn002191();
			
			 initVSButtonbtn001191();
			
			 initVSButtonbtn00311211();
			
			 initVSButtonbtn00310181();
			
			 initVSButtonbtn0039181();
			
			 initVSButtonbtn0038181();
			
			 initVSButtonbtn0037181();
			
			 initVSButtonbtn0036181();
			
			 initVSButtonbtn0035181();
			
			 initVSButtonbtn0034181();
			
			 initVSButtonbtn0033191();
			
			 initVSButtonbtn0032201();
			
			 initVSButtonbtn0031321();
			
			 initVSButtonbtn0031311();
			
			 initVSButtonbtn002181();
			
			 initVSButtonbtn001181();
			
			 initVSButtonbtn00311201();
			
			 initVSButtonbtn00310171();
			
			 initVSButtonbtn0039171();
			
			 initVSButtonbtn0038171();
			
			 initVSButtonbtn0037171();
			
			 initVSButtonbtn0036171();
			
			 initVSButtonbtn0035171();
			
			 initVSButtonbtn0034171();
			
			 initVSButtonbtn0033181();
			
			 initVSButtonbtn0032191();
			
			 initVSButtonbtn0031301();
			
			 initVSButtonbtn0031291();
			
			 initVSButtonbtn002171();
			
			 initVSButtonbtn00311191();
			
			 initVSButtonbtn00310161();
			
			 initVSButtonbtn0039161();
			
			 initVSButtonbtn0038161();
			
			 initVSButtonbtn0037161();
			
			 initVSButtonbtn0036161();
			
			 initVSButtonbtn0035161();
			
			 initVSButtonbtn0034161();
			
			 initVSButtonbtn0033171();
			
			 initVSButtonbtn0032181();
			
			 initVSButtonbtn0031281();
			
			 initVSButtonbtn0031001();
			
			 initVSButtonbtn00311181();
			
			 initVSButtonbtn00310151();
			
			 initVSButtonbtn0039151();
			
			 initVSButtonbtn0038151();
			
			 initVSButtonbtn0037151();
			
			 initVSButtonbtn0036151();
			
			 initVSButtonbtn0035151();
			
			 initVSButtonbtn0034151();
			
			 initVSButtonbtn0033161();
			
			 initVSButtonbtn0032171();
			
			 initVSButtonbtn0031271();
			
			 initVSButtonbtn00311171();
			
			 initVSButtonbtn00310141();
			
			 initVSButtonbtn0039141();
			
			 initVSButtonbtn0038141();
			
			 initVSButtonbtn0037141();
			
			 initVSButtonbtn0036141();
			
			 initVSButtonbtn0035141();
			
			 initVSButtonbtn0034141();
			
			 initVSButtonbtn0033151();
			
			 initVSButtonbtn0032161();
			
			 initVSButtonbtn0031261();
			
			 initVSButtonbtn00311161();
			
			 initVSButtonbtn00310131();
			
			 initVSButtonbtn0039131();
			
			 initVSButtonbtn0038131();
			
			 initVSButtonbtn0037131();
			
			 initVSButtonbtn0036131();
			
			 initVSButtonbtn0035131();
			
			 initVSButtonbtn0034131();
			
			 initVSButtonbtn0033141();
			
			 initVSButtonbtn0032151();
			
			 initVSButtonbtn0031251();
			
			 initVSButtonbtn003701();
			
			 initVSButtonbtn002131();
			
			 initVSButtonbtn00311151();
			
			 initVSButtonbtn00310121();
			
			 initVSButtonbtn0039121();
			
			 initVSButtonbtn0038121();
			
			 initVSButtonbtn0037121();
			
			 initVSButtonbtn0036121();
			
			 initVSButtonbtn0035121();
			
			 initVSButtonbtn0034121();
			
			 initVSButtonbtn0033131();
			
			 initVSButtonbtn0032141();
			
			 initVSButtonbtn0031241();
			
			 initVSButtonbtn003601();
			
			 initVSButtonbtn002121();
			
			 initVSButtonbtn001121();
			
			 initVSButtonbtn00311141();
			
			 initVSButtonbtn00310111();
			
			 initVSButtonbtn0039111();
			
			 initVSButtonbtn0038111();
			
			 initVSButtonbtn0037111();
			
			 initVSButtonbtn0036111();
			
			 initVSButtonbtn0035111();
			
			 initVSButtonbtn0034111();
			
			 initVSButtonbtn0033121();
			
			 initVSButtonbtn0032131();
			
			 initVSButtonbtn0031231();
			
			 initVSButtonbtn003501();
			
			 initVSButtonbtn002111();
			
			 initVSButtonbtn00311131();
			
			 initVSButtonbtn00310101();
			
			 initVSButtonbtn0039101();
			
			 initVSButtonbtn0038101();
			
			 initVSButtonbtn0037101();
			
			 initVSButtonbtn0036101();
			
			 initVSButtonbtn0035101();
			
			 initVSButtonbtn0034101();
			
			 initVSButtonbtn0033111();
			
			 initVSButtonbtn0032121();
			
			 initVSButtonbtn0031221();
			
			 initVSButtonbtn003401();
			
			 initVSButtonbtn002101();
			
			 initVSButtonbtn0031061();
			
			 initVSButtonbtn003961();
			
			 initVSButtonbtn003861();
			
			 initVSButtonbtn003761();
			
			 initVSButtonbtn003661();
			
			 initVSButtonbtn003561();
			
			 initVSButtonbtn003461();
			
			 initVSButtonbtn003361();
			
			 initVSButtonbtn003271();
			
			 initVSButtonbtn0031171();
			
			 initVSButtonbtn003261();
			
			 initVSButtonbtn00261();
			
			 initVSButtonbtn00161();
			
			 initVSButtonbtn0031161();
			
			 initVSButtonbtn0031051();
			
			 initVSButtonbtn003951();
			
			 initVSButtonbtn003851();
			
			 initVSButtonbtn003751();
			
			 initVSButtonbtn003651();
			
			 initVSButtonbtn003551();
			
			 initVSButtonbtn003451();
			
			 initVSButtonbtn003351();
			
			 initVSButtonbtn003251();
			
			 initVSButtonbtn0031151();
			
			 initVSButtonbtn003201();
			
			 initVSButtonbtn00251();
			
			 initVSButtonbtn00151();
			
			 initVSButtonbtn003151();
			
			 initVSButtonbtn00223();
			
			 initVSButtonbtn00123();
			
			 initVSButtonbtn0035110();
			
			 initVSButtonbtn0034110();
			
			 initVSButtonbtn0033110();
			
			 initVSButtonbtn0032110();
			
			 initVSButtonbtn003141();
			
			 initVSButtonbtn0031310();
			
			 initVSButtonbtn002110();
			
			 initVSButtonbtn001110();
			
			 initVSButtonbtn0031210();
			
			 initVSButtonbtn0031125();
			
			 initVSButtonbtn0031022();
			
			 initVSButtonbtn003922();
			
			 initVSButtonbtn003822();
			
			 initVSButtonbtn003722();
			
			 initVSButtonbtn003622();
			
			 initVSButtonbtn003522();
			
			 initVSButtonbtn003422();
			
			 initVSButtonbtn003323();
			
			 initVSButtonbtn003224();
			
			 initVSButtonbtn003140();
			
			 initVSButtonbtn003139();
			
			 initVSButtonbtn00222();
			
			 initVSButtonbtn00122();
			
			 initVSButtonbtn0031124();
			
			 initVSButtonbtn0031021();
			
			 initVSButtonbtn003921();
			
			 initVSButtonbtn003821();
			
			 initVSButtonbtn003721();
			
			 initVSButtonbtn003621();
			
			 initVSButtonbtn003521();
			
			 initVSButtonbtn003421();
			
			 initVSButtonbtn003322();
			
			 initVSButtonbtn003223();
			
			 initVSButtonbtn003138();
			
			 initVSButtonbtn003137();
			
			 initVSButtonbtn00221();
			
			 initVSButtonbtn00121();
			
			 initVSButtonbtn0031123();
			
			 initVSButtonbtn0031020();
			
			 initVSButtonbtn003920();
			
			 initVSButtonbtn003820();
			
			 initVSButtonbtn003720();
			
			 initVSButtonbtn003620();
			
			 initVSButtonbtn003520();
			
			 initVSButtonbtn003420();
			
			 initVSButtonbtn003321();
			
			 initVSButtonbtn003222();
			
			 initVSButtonbtn003136();
			
			 initVSButtonbtn003135();
			
			 initVSButtonbtn00220();
			
			 initVSButtonbtn00120();
			
			 initVSButtonbtn0031122();
			
			 initVSButtonbtn0031019();
			
			 initVSButtonbtn003919();
			
			 initVSButtonbtn003819();
			
			 initVSButtonbtn003719();
			
			 initVSButtonbtn003619();
			
			 initVSButtonbtn003519();
			
			 initVSButtonbtn003419();
			
			 initVSButtonbtn003320();
			
			 initVSButtonbtn003221();
			
			 initVSButtonbtn003134();
			
			 initVSButtonbtn003133();
			
			 initVSButtonbtn00219();
			
			 initVSButtonbtn00119();
			
			 initVSButtonbtn0031121();
			
			 initVSButtonbtn0031018();
			
			 initVSButtonbtn003918();
			
			 initVSButtonbtn003818();
			
			 initVSButtonbtn003718();
			
			 initVSButtonbtn003618();
			
			 initVSButtonbtn003518();
			
			 initVSButtonbtn003418();
			
			 initVSButtonbtn003319();
			
			 initVSButtonbtn003220();
			
			 initVSButtonbtn003132();
			
			 initVSButtonbtn003131();
			
			 initVSButtonbtn00218();
			
			 initVSButtonbtn00118();
			
			 initVSButtonbtn0031120();
			
			 initVSButtonbtn0031017();
			
			 initVSButtonbtn003917();
			
			 initVSButtonbtn003817();
			
			 initVSButtonbtn003717();
			
			 initVSButtonbtn003617();
			
			 initVSButtonbtn003517();
			
			 initVSButtonbtn003417();
			
			 initVSButtonbtn003318();
			
			 initVSButtonbtn003219();
			
			 initVSButtonbtn003130();
			
			 initVSButtonbtn003129();
			
			 initVSButtonbtn00217();
			
			 initVSButtonbtn00117();
			
			 initVSButtonbtn0031119();
			
			 initVSButtonbtn0031016();
			
			 initVSButtonbtn003916();
			
			 initVSButtonbtn003816();
			
			 initVSButtonbtn003716();
			
			 initVSButtonbtn003616();
			
			 initVSButtonbtn003516();
			
			 initVSButtonbtn003416();
			
			 initVSButtonbtn003317();
			
			 initVSButtonbtn003218();
			
			 initVSButtonbtn003128();
			
			 initVSButtonbtn003100();
			
			 initVSButtonbtn00216();
			
			 initVSButtonbtn00116();
			
			 initVSButtonbtn0031118();
			
			 initVSButtonbtn0031015();
			
			 initVSButtonbtn003915();
			
			 initVSButtonbtn003815();
			
			 initVSButtonbtn003715();
			
			 initVSButtonbtn003615();
			
			 initVSButtonbtn003515();
			
			 initVSButtonbtn003415();
			
			 initVSButtonbtn003316();
			
			 initVSButtonbtn003217();
			
			 initVSButtonbtn003127();
			
			 initVSButtonbtn00390();
			
			 initVSButtonbtn00215();
			
			 initVSButtonbtn00115();
			
			 initVSButtonbtn0031117();
			
			 initVSButtonbtn0031014();
			
			 initVSButtonbtn003914();
			
			 initVSButtonbtn003814();
			
			 initVSButtonbtn003714();
			
			 initVSButtonbtn003614();
			
			 initVSButtonbtn003514();
			
			 initVSButtonbtn003414();
			
			 initVSButtonbtn003315();
			
			 initVSButtonbtn003216();
			
			 initVSButtonbtn003126();
			
			 initVSButtonbtn00380();
			
			 initVSButtonbtn00214();
			
			 initVSButtonbtn00114();
			
			 initVSButtonbtn0031116();
			
			 initVSButtonbtn0031013();
			
			 initVSButtonbtn003913();
			
			 initVSButtonbtn003813();
			
			 initVSButtonbtn003713();
			
			 initVSButtonbtn003613();
			
			 initVSButtonbtn003513();
			
			 initVSButtonbtn003413();
			
			 initVSButtonbtn003314();
			
			 initVSButtonbtn003215();
			
			 initVSButtonbtn003125();
			
			 initVSButtonbtn00370();
			
			 initVSButtonbtn00213();
			
			 initVSButtonbtn00113();
			
			 initVSButtonbtn0031115();
			
			 initVSButtonbtn0031012();
			
			 initVSButtonbtn003912();
			
			 initVSButtonbtn003812();
			
			 initVSButtonbtn003712();
			
			 initVSButtonbtn003612();
			
			 initVSButtonbtn003512();
			
			 initVSButtonbtn003412();
			
			 initVSButtonbtn003313();
			
			 initVSButtonbtn003214();
			
			 initVSButtonbtn003124();
			
			 initVSButtonbtn00360();
			
			 initVSButtonbtn00212();
			
			 initVSButtonbtn00112();
			
			 initVSButtonbtn0031114();
			
			 initVSButtonbtn0031011();
			
			 initVSButtonbtn003911();
			
			 initVSButtonbtn003811();
			
			 initVSButtonbtn003711();
			
			 initVSButtonbtn003611();
			
			 initVSButtonbtn003511();
			
			 initVSButtonbtn003411();
			
			 initVSButtonbtn003312();
			
			 initVSButtonbtn003213();
			
			 initVSButtonbtn003123();
			
			 initVSButtonbtn00350();
			
			 initVSButtonbtn00211();
			
			 initVSButtonbtn00111();
			
			 initVSButtonbtn0031113();
			
			 initVSButtonbtn0031010();
			
			 initVSButtonbtn003910();
			
			 initVSButtonbtn003810();
			
			 initVSButtonbtn003710();
			
			 initVSButtonbtn003610();
			
			 initVSButtonbtn003510();
			
			 initVSButtonbtn003410();
			
			 initVSButtonbtn003311();
			
			 initVSButtonbtn003212();
			
			 initVSButtonbtn003122();
			
			 initVSButtonbtn00340();
			
			 initVSButtonbtn00210();
			
			 initVSButtonbtn00110();
			
			 initVSButtonbtn0031112();
			
			 initVSButtonbtn003109();
			
			 initVSButtonbtn00399();
			
			 initVSButtonbtn00389();
			
			 initVSButtonbtn00379();
			
			 initVSButtonbtn00369();
			
			 initVSButtonbtn00359();
			
			 initVSButtonbtn00349();
			
			 initVSButtonbtn003310();
			
			 initVSButtonbtn003211();
			
			 initVSButtonbtn003121();
			
			 initVSButtonbtn00339();
			
			 initVSButtonbtn0029();
			
			 initVSButtonbtn0019();
			
			 initVSButtonbtn0031111();
			
			 initVSButtonbtn003108();
			
			 initVSButtonbtn00398();
			
			 initVSButtonbtn00388();
			
			 initVSButtonbtn00378();
			
			 initVSButtonbtn00368();
			
			 initVSButtonbtn00358();
			
			 initVSButtonbtn00348();
			
			 initVSButtonbtn00338();
			
			 initVSButtonbtn003210();
			
			 initVSButtonbtn003120();
			
			 initVSButtonbtn00330();
			
			 initVSButtonbtn0028();
			
			 initVSButtonbtn0018();
			
			 initVSButtonbtn0031110();
			
			 initVSButtonbtn003107();
			
			 initVSButtonbtn00397();
			
			 initVSButtonbtn00387();
			
			 initVSButtonbtn00377();
			
			 initVSButtonbtn00367();
			
			 initVSButtonbtn00357();
			
			 initVSButtonbtn00347();
			
			 initVSButtonbtn00337();
			
			 initVSButtonbtn00329();
			
			 initVSButtonbtn003119();
			
			 initVSButtonbtn00328();
			
			 initVSButtonbtn0027();
			
			 initVSButtonbtn0017();
			
			 initVSButtonbtn003118();
			
			 initVSButtonbtn003106();
			
			 initVSButtonbtn00396();
			
			 initVSButtonbtn00386();
			
			 initVSButtonbtn00376();
			
			 initVSButtonbtn00366();
			
			 initVSButtonbtn00356();
			
			 initVSButtonbtn00346();
			
			 initVSButtonbtn00336();
			
			 initVSButtonbtn00327();
			
			 initVSButtonbtn003117();
			
			 initVSButtonbtn00326();
			
			 initVSButtonbtn0026();
			
			 initVSButtonbtn0016();
			
			 initVSButtonbtn003116();
			
			 initVSButtonbtn003105();
			
			 initVSButtonbtn00395();
			
			 initVSButtonbtn00385();
			
			 initVSButtonbtn00375();
			
			 initVSButtonbtn00365();
			
			 initVSButtonbtn00355();
			
			 initVSButtonbtn00345();
			
			 initVSButtonbtn00335();
			
			 initVSButtonbtn00325();
			
			 initVSButtonbtn003115();
			
			 initVSButtonbtn00320();
			
			 initVSButtonbtn0025();
			
			 initVSButtonbtn0015();
			
			 initVSButtonbtn003114();
			
			 initVSButtonbtn003104();
			
			 initVSButtonbtn00394();
			
			 initVSButtonbtn00384();
			
			 initVSButtonbtn00374();
			
			 initVSButtonbtn00364();
			
			 initVSButtonbtn00354();
			
			 initVSButtonbtn00344();
			
			 initVSButtonbtn00334();
			
			 initVSButtonbtn00324();
			
			 initVSButtonbtn003110();
			
			 initVSButtonbtn00319();
			
			 initVSButtonbtn0024();
			
			 initVSButtonbtn0014();
			
			 initVSButtonbtn003113();
			
			 initVSButtonbtn003103();
			
			 initVSButtonbtn00393();
			
			 initVSButtonbtn00383();
			
			 initVSButtonbtn00373();
			
			 initVSButtonbtn00363();
			
			 initVSButtonbtn00353();
			
			 initVSButtonbtn00343();
			
			 initVSButtonbtn00333();
			
			 initVSButtonbtn00323();
			
			 initVSButtonbtn00318();
			
			 initVSButtonbtn00317();
			
			 initVSButtonbtn0023();
			
			 initVSButtonbtn0013();
			
			 initVSButtonbtn003112();
			
			 initVSButtonbtn003102();
			
			 initVSButtonbtn00392();
			
			 initVSButtonbtn00382();
			
			 initVSButtonbtn00372();
			
			 initVSButtonbtn00362();
			
			 initVSButtonbtn00352();
			
			 initVSButtonbtn00342();
			
			 initVSButtonbtn00332();
			
			 initVSButtonbtn00322();
			
			 initVSButtonbtn00316();
			
			 initVSButtonbtn00315();
			
			 initVSButtonbtn0022();
			
			 initVSButtonbtn0012();
			
			 initVSButtonbtn003111();
			
			 initVSButtonbtn003101();
			
			 initVSButtonbtn00391();
			
			 initVSButtonbtn00381();
			
			 initVSButtonbtn00371();
			
			 initVSButtonbtn00361();
			
			 initVSButtonbtn00351();
			
			 initVSButtonbtn00341();
			
			 initVSButtonbtn00331();
			
			 initVSButtonbtn00321();
			
			 initVSButtonbtn00314();
			
			 initVSButtonbtn00313();
			
			 initVSButtonbtn0021();
			
			 initVSButtonbtn0011();
			
			 initVSButtonbtn00312();
			
			 initVSButtonbtn00311();
			
			 initVSButtonbtn00310();
			
			 initVSButtonbtn0039();
			
			 initVSButtonbtn0038();
			
			 initVSButtonbtn0037();
			
			 initVSButtonbtn0036();
			
			 initVSButtonbtn0035();
			
			 initVSButtonbtn0034();
			
			 initVSButtonbtn0033();
			
			 initVSButtonbtn0032();
			
			 initVSButtonbtn0031();
			
			 initVSButtonbtn003();
			
			 initVSButtonbtn002();
			
			 initVSButtonbtn001();
			
				
		
			setBounds (0, 0, 592, 686);
		
			setTitle ("fAdapterTest");
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

	
	
	 public void initVSButtonbtn0032231() {
	btn0032231.setText("003");
	btn0032231.setName ("btn0032231");
		btn0032231.setForeground(Color.black);
		btn0032231.setBackground(new Color(0xc6c6c6));
	btn0032231.setBounds (450, 478 , 50, 18);

btn0032231.setFont (new Font ("Helvetica", 0, 12));

 	btn0032231.setBorderPainted (true);
	btn0032231.setDataSourceName("");
	btn0032231.setTabOrder(500);
        
      // container is form
add (btn0032231,null);             
	} // end of initVSButtonbtn0032231
	
	
	
	
	
	
	 public void initVSButtonbtn0031381() {
	btn0031381.setText("003");
	btn0031381.setName ("btn0031381");
		btn0031381.setForeground(Color.black);
		btn0031381.setBackground(new Color(0xc6c6c6));
	btn0031381.setBounds (440, 468 , 50, 18);

btn0031381.setFont (new Font ("Helvetica", 0, 12));

 	btn0031381.setBorderPainted (true);
	btn0031381.setDataSourceName("");
	btn0031381.setTabOrder(499);
        
      // container is form
add (btn0031381,null);             
	} // end of initVSButtonbtn0031381
	
	
	
	
	
	
	 public void initVSButtonbtn0031371() {
	btn0031371.setText("003");
	btn0031371.setName ("btn0031371");
		btn0031371.setForeground(Color.black);
		btn0031371.setBackground(new Color(0xc6c6c6));
	btn0031371.setBounds (430, 458 , 50, 18);

btn0031371.setFont (new Font ("Helvetica", 0, 12));

 	btn0031371.setBorderPainted (true);
	btn0031371.setDataSourceName("");
	btn0031371.setTabOrder(498);
        
      // container is form
add (btn0031371,null);             
	} // end of initVSButtonbtn0031371
	
	
	
	
	
	
	 public void initVSButtonbtn002211() {
	btn002211.setText("002");
	btn002211.setName ("btn002211");
		btn002211.setForeground(Color.black);
		btn002211.setBackground(new Color(0xc6c6c6));
	btn002211.setBounds (425, 441 , 50, 18);

btn002211.setFont (new Font ("Helvetica", 0, 12));

 	btn002211.setBorderPainted (true);
	btn002211.setDataSourceName("");
	btn002211.setTabOrder(497);
        
      // container is form
add (btn002211,null);             
	} // end of initVSButtonbtn002211
	
	
	
	
	
	
	 public void initVSButtonbtn001211() {
	btn001211.setText("001");
	btn001211.setName ("btn001211");
		btn001211.setForeground(Color.black);
		btn001211.setBackground(new Color(0xc6c6c6));
	btn001211.setBounds (407, 424 , 50, 18);

btn001211.setFont (new Font ("Helvetica", 0, 12));

 	btn001211.setBorderPainted (true);
	btn001211.setDataSourceName("");
	btn001211.setTabOrder(496);
        
      // container is form
add (btn001211,null);             
	} // end of initVSButtonbtn001211
	
	
	
	
	
	
	 public void initVSButtonbtn0034201() {
	btn0034201.setText("003");
	btn0034201.setName ("btn0034201");
		btn0034201.setForeground(Color.black);
		btn0034201.setBackground(new Color(0xc6c6c6));
	btn0034201.setBounds (451, 526 , 50, 18);

btn0034201.setFont (new Font ("Helvetica", 0, 12));

 	btn0034201.setBorderPainted (true);
	btn0034201.setDataSourceName("");
	btn0034201.setTabOrder(495);
        
      // container is form
add (btn0034201,null);             
	} // end of initVSButtonbtn0034201
	
	
	
	
	
	
	 public void initVSButtonbtn0033211() {
	btn0033211.setText("003");
	btn0033211.setName ("btn0033211");
		btn0033211.setForeground(Color.black);
		btn0033211.setBackground(new Color(0xc6c6c6));
	btn0033211.setBounds (441, 516 , 50, 18);

btn0033211.setFont (new Font ("Helvetica", 0, 12));

 	btn0033211.setBorderPainted (true);
	btn0033211.setDataSourceName("");
	btn0033211.setTabOrder(494);
        
      // container is form
add (btn0033211,null);             
	} // end of initVSButtonbtn0033211
	
	
	
	
	
	
	 public void initVSButtonbtn0032221() {
	btn0032221.setText("003");
	btn0032221.setName ("btn0032221");
		btn0032221.setForeground(Color.black);
		btn0032221.setBackground(new Color(0xc6c6c6));
	btn0032221.setBounds (431, 506 , 50, 18);

btn0032221.setFont (new Font ("Helvetica", 0, 12));

 	btn0032221.setBorderPainted (true);
	btn0032221.setDataSourceName("");
	btn0032221.setTabOrder(493);
        
      // container is form
add (btn0032221,null);             
	} // end of initVSButtonbtn0032221
	
	
	
	
	
	
	 public void initVSButtonbtn0031361() {
	btn0031361.setText("003");
	btn0031361.setName ("btn0031361");
		btn0031361.setForeground(Color.black);
		btn0031361.setBackground(new Color(0xc6c6c6));
	btn0031361.setBounds (421, 496 , 50, 18);

btn0031361.setFont (new Font ("Helvetica", 0, 12));

 	btn0031361.setBorderPainted (true);
	btn0031361.setDataSourceName("");
	btn0031361.setTabOrder(492);
        
      // container is form
add (btn0031361,null);             
	} // end of initVSButtonbtn0031361
	
	
	
	
	
	
	 public void initVSButtonbtn0031351() {
	btn0031351.setText("003");
	btn0031351.setName ("btn0031351");
		btn0031351.setForeground(Color.black);
		btn0031351.setBackground(new Color(0xc6c6c6));
	btn0031351.setBounds (411, 486 , 50, 18);

btn0031351.setFont (new Font ("Helvetica", 0, 12));

 	btn0031351.setBorderPainted (true);
	btn0031351.setDataSourceName("");
	btn0031351.setTabOrder(491);
        
      // container is form
add (btn0031351,null);             
	} // end of initVSButtonbtn0031351
	
	
	
	
	
	
	 public void initVSButtonbtn002201() {
	btn002201.setText("002");
	btn002201.setName ("btn002201");
		btn002201.setForeground(Color.black);
		btn002201.setBackground(new Color(0xc6c6c6));
	btn002201.setBounds (406, 469 , 50, 18);

btn002201.setFont (new Font ("Helvetica", 0, 12));

 	btn002201.setBorderPainted (true);
	btn002201.setDataSourceName("");
	btn002201.setTabOrder(490);
        
      // container is form
add (btn002201,null);             
	} // end of initVSButtonbtn002201
	
	
	
	
	
	
	 public void initVSButtonbtn001201() {
	btn001201.setText("001");
	btn001201.setName ("btn001201");
		btn001201.setForeground(Color.black);
		btn001201.setBackground(new Color(0xc6c6c6));
	btn001201.setBounds (388, 452 , 50, 18);

btn001201.setFont (new Font ("Helvetica", 0, 12));

 	btn001201.setBorderPainted (true);
	btn001201.setDataSourceName("");
	btn001201.setTabOrder(489);
        
      // container is form
add (btn001201,null);             
	} // end of initVSButtonbtn001201
	
	
	
	
	
	
	 public void initVSButtonbtn00310191() {
	btn00310191.setText("003");
	btn00310191.setName ("btn00310191");
		btn00310191.setForeground(Color.black);
		btn00310191.setBackground(new Color(0xc6c6c6));
	btn00310191.setBounds (445, 574 , 50, 18);

btn00310191.setFont (new Font ("Helvetica", 0, 12));

 	btn00310191.setBorderPainted (true);
	btn00310191.setDataSourceName("");
	btn00310191.setTabOrder(488);
        
      // container is form
add (btn00310191,null);             
	} // end of initVSButtonbtn00310191
	
	
	
	
	
	
	 public void initVSButtonbtn0039191() {
	btn0039191.setText("003");
	btn0039191.setName ("btn0039191");
		btn0039191.setForeground(Color.black);
		btn0039191.setBackground(new Color(0xc6c6c6));
	btn0039191.setBounds (435, 564 , 50, 18);

btn0039191.setFont (new Font ("Helvetica", 0, 12));

 	btn0039191.setBorderPainted (true);
	btn0039191.setDataSourceName("");
	btn0039191.setTabOrder(487);
        
      // container is form
add (btn0039191,null);             
	} // end of initVSButtonbtn0039191
	
	
	
	
	
	
	 public void initVSButtonbtn0038191() {
	btn0038191.setText("003");
	btn0038191.setName ("btn0038191");
		btn0038191.setForeground(Color.black);
		btn0038191.setBackground(new Color(0xc6c6c6));
	btn0038191.setBounds (425, 554 , 50, 18);

btn0038191.setFont (new Font ("Helvetica", 0, 12));

 	btn0038191.setBorderPainted (true);
	btn0038191.setDataSourceName("");
	btn0038191.setTabOrder(486);
        
      // container is form
add (btn0038191,null);             
	} // end of initVSButtonbtn0038191
	
	
	
	
	
	
	 public void initVSButtonbtn0037191() {
	btn0037191.setText("003");
	btn0037191.setName ("btn0037191");
		btn0037191.setForeground(Color.black);
		btn0037191.setBackground(new Color(0xc6c6c6));
	btn0037191.setBounds (415, 544 , 50, 18);

btn0037191.setFont (new Font ("Helvetica", 0, 12));

 	btn0037191.setBorderPainted (true);
	btn0037191.setDataSourceName("");
	btn0037191.setTabOrder(485);
        
      // container is form
add (btn0037191,null);             
	} // end of initVSButtonbtn0037191
	
	
	
	
	
	
	 public void initVSButtonbtn0036191() {
	btn0036191.setText("003");
	btn0036191.setName ("btn0036191");
		btn0036191.setForeground(Color.black);
		btn0036191.setBackground(new Color(0xc6c6c6));
	btn0036191.setBounds (405, 534 , 50, 18);

btn0036191.setFont (new Font ("Helvetica", 0, 12));

 	btn0036191.setBorderPainted (true);
	btn0036191.setDataSourceName("");
	btn0036191.setTabOrder(484);
        
      // container is form
add (btn0036191,null);             
	} // end of initVSButtonbtn0036191
	
	
	
	
	
	
	 public void initVSButtonbtn0035191() {
	btn0035191.setText("003");
	btn0035191.setName ("btn0035191");
		btn0035191.setForeground(Color.black);
		btn0035191.setBackground(new Color(0xc6c6c6));
	btn0035191.setBounds (395, 524 , 50, 18);

btn0035191.setFont (new Font ("Helvetica", 0, 12));

 	btn0035191.setBorderPainted (true);
	btn0035191.setDataSourceName("");
	btn0035191.setTabOrder(483);
        
      // container is form
add (btn0035191,null);             
	} // end of initVSButtonbtn0035191
	
	
	
	
	
	
	 public void initVSButtonbtn0034191() {
	btn0034191.setText("003");
	btn0034191.setName ("btn0034191");
		btn0034191.setForeground(Color.black);
		btn0034191.setBackground(new Color(0xc6c6c6));
	btn0034191.setBounds (385, 514 , 50, 18);

btn0034191.setFont (new Font ("Helvetica", 0, 12));

 	btn0034191.setBorderPainted (true);
	btn0034191.setDataSourceName("");
	btn0034191.setTabOrder(482);
        
      // container is form
add (btn0034191,null);             
	} // end of initVSButtonbtn0034191
	
	
	
	
	
	
	 public void initVSButtonbtn0033201() {
	btn0033201.setText("003");
	btn0033201.setName ("btn0033201");
		btn0033201.setForeground(Color.black);
		btn0033201.setBackground(new Color(0xc6c6c6));
	btn0033201.setBounds (375, 504 , 50, 18);

btn0033201.setFont (new Font ("Helvetica", 0, 12));

 	btn0033201.setBorderPainted (true);
	btn0033201.setDataSourceName("");
	btn0033201.setTabOrder(481);
        
      // container is form
add (btn0033201,null);             
	} // end of initVSButtonbtn0033201
	
	
	
	
	
	
	 public void initVSButtonbtn0032211() {
	btn0032211.setText("003");
	btn0032211.setName ("btn0032211");
		btn0032211.setForeground(Color.black);
		btn0032211.setBackground(new Color(0xc6c6c6));
	btn0032211.setBounds (365, 494 , 50, 18);

btn0032211.setFont (new Font ("Helvetica", 0, 12));

 	btn0032211.setBorderPainted (true);
	btn0032211.setDataSourceName("");
	btn0032211.setTabOrder(480);
        
      // container is form
add (btn0032211,null);             
	} // end of initVSButtonbtn0032211
	
	
	
	
	
	
	 public void initVSButtonbtn0031341() {
	btn0031341.setText("003");
	btn0031341.setName ("btn0031341");
		btn0031341.setForeground(Color.black);
		btn0031341.setBackground(new Color(0xc6c6c6));
	btn0031341.setBounds (355, 484 , 50, 18);

btn0031341.setFont (new Font ("Helvetica", 0, 12));

 	btn0031341.setBorderPainted (true);
	btn0031341.setDataSourceName("");
	btn0031341.setTabOrder(479);
        
      // container is form
add (btn0031341,null);             
	} // end of initVSButtonbtn0031341
	
	
	
	
	
	
	 public void initVSButtonbtn0031331() {
	btn0031331.setText("003");
	btn0031331.setName ("btn0031331");
		btn0031331.setForeground(Color.black);
		btn0031331.setBackground(new Color(0xc6c6c6));
	btn0031331.setBounds (345, 474 , 50, 18);

btn0031331.setFont (new Font ("Helvetica", 0, 12));

 	btn0031331.setBorderPainted (true);
	btn0031331.setDataSourceName("");
	btn0031331.setTabOrder(478);
        
      // container is form
add (btn0031331,null);             
	} // end of initVSButtonbtn0031331
	
	
	
	
	
	
	 public void initVSButtonbtn002191() {
	btn002191.setText("002");
	btn002191.setName ("btn002191");
		btn002191.setForeground(Color.black);
		btn002191.setBackground(new Color(0xc6c6c6));
	btn002191.setBounds (340, 457 , 50, 18);

btn002191.setFont (new Font ("Helvetica", 0, 12));

 	btn002191.setBorderPainted (true);
	btn002191.setDataSourceName("");
	btn002191.setTabOrder(477);
        
      // container is form
add (btn002191,null);             
	} // end of initVSButtonbtn002191
	
	
	
	
	
	
	 public void initVSButtonbtn001191() {
	btn001191.setText("001");
	btn001191.setName ("btn001191");
		btn001191.setForeground(Color.black);
		btn001191.setBackground(new Color(0xc6c6c6));
	btn001191.setBounds (322, 440 , 50, 18);

btn001191.setFont (new Font ("Helvetica", 0, 12));

 	btn001191.setBorderPainted (true);
	btn001191.setDataSourceName("");
	btn001191.setTabOrder(476);
        
      // container is form
add (btn001191,null);             
	} // end of initVSButtonbtn001191
	
	
	
	
	
	
	 public void initVSButtonbtn00311211() {
	btn00311211.setText("003");
	btn00311211.setName ("btn00311211");
		btn00311211.setForeground(Color.black);
		btn00311211.setBackground(new Color(0xc6c6c6));
	btn00311211.setBounds (437, 609 , 50, 18);

btn00311211.setFont (new Font ("Helvetica", 0, 12));

 	btn00311211.setBorderPainted (true);
	btn00311211.setDataSourceName("");
	btn00311211.setTabOrder(475);
        
      // container is form
add (btn00311211,null);             
	} // end of initVSButtonbtn00311211
	
	
	
	
	
	
	 public void initVSButtonbtn00310181() {
	btn00310181.setText("003");
	btn00310181.setName ("btn00310181");
		btn00310181.setForeground(Color.black);
		btn00310181.setBackground(new Color(0xc6c6c6));
	btn00310181.setBounds (427, 599 , 50, 18);

btn00310181.setFont (new Font ("Helvetica", 0, 12));

 	btn00310181.setBorderPainted (true);
	btn00310181.setDataSourceName("");
	btn00310181.setTabOrder(474);
        
      // container is form
add (btn00310181,null);             
	} // end of initVSButtonbtn00310181
	
	
	
	
	
	
	 public void initVSButtonbtn0039181() {
	btn0039181.setText("003");
	btn0039181.setName ("btn0039181");
		btn0039181.setForeground(Color.black);
		btn0039181.setBackground(new Color(0xc6c6c6));
	btn0039181.setBounds (417, 589 , 50, 18);

btn0039181.setFont (new Font ("Helvetica", 0, 12));

 	btn0039181.setBorderPainted (true);
	btn0039181.setDataSourceName("");
	btn0039181.setTabOrder(473);
        
      // container is form
add (btn0039181,null);             
	} // end of initVSButtonbtn0039181
	
	
	
	
	
	
	 public void initVSButtonbtn0038181() {
	btn0038181.setText("003");
	btn0038181.setName ("btn0038181");
		btn0038181.setForeground(Color.black);
		btn0038181.setBackground(new Color(0xc6c6c6));
	btn0038181.setBounds (407, 579 , 50, 18);

btn0038181.setFont (new Font ("Helvetica", 0, 12));

 	btn0038181.setBorderPainted (true);
	btn0038181.setDataSourceName("");
	btn0038181.setTabOrder(472);
        
      // container is form
add (btn0038181,null);             
	} // end of initVSButtonbtn0038181
	
	
	
	
	
	
	 public void initVSButtonbtn0037181() {
	btn0037181.setText("003");
	btn0037181.setName ("btn0037181");
		btn0037181.setForeground(Color.black);
		btn0037181.setBackground(new Color(0xc6c6c6));
	btn0037181.setBounds (397, 569 , 50, 18);

btn0037181.setFont (new Font ("Helvetica", 0, 12));

 	btn0037181.setBorderPainted (true);
	btn0037181.setDataSourceName("");
	btn0037181.setTabOrder(471);
        
      // container is form
add (btn0037181,null);             
	} // end of initVSButtonbtn0037181
	
	
	
	
	
	
	 public void initVSButtonbtn0036181() {
	btn0036181.setText("003");
	btn0036181.setName ("btn0036181");
		btn0036181.setForeground(Color.black);
		btn0036181.setBackground(new Color(0xc6c6c6));
	btn0036181.setBounds (387, 559 , 50, 18);

btn0036181.setFont (new Font ("Helvetica", 0, 12));

 	btn0036181.setBorderPainted (true);
	btn0036181.setDataSourceName("");
	btn0036181.setTabOrder(470);
        
      // container is form
add (btn0036181,null);             
	} // end of initVSButtonbtn0036181
	
	
	
	
	
	
	 public void initVSButtonbtn0035181() {
	btn0035181.setText("003");
	btn0035181.setName ("btn0035181");
		btn0035181.setForeground(Color.black);
		btn0035181.setBackground(new Color(0xc6c6c6));
	btn0035181.setBounds (377, 549 , 50, 18);

btn0035181.setFont (new Font ("Helvetica", 0, 12));

 	btn0035181.setBorderPainted (true);
	btn0035181.setDataSourceName("");
	btn0035181.setTabOrder(469);
        
      // container is form
add (btn0035181,null);             
	} // end of initVSButtonbtn0035181
	
	
	
	
	
	
	 public void initVSButtonbtn0034181() {
	btn0034181.setText("003");
	btn0034181.setName ("btn0034181");
		btn0034181.setForeground(Color.black);
		btn0034181.setBackground(new Color(0xc6c6c6));
	btn0034181.setBounds (367, 539 , 50, 18);

btn0034181.setFont (new Font ("Helvetica", 0, 12));

 	btn0034181.setBorderPainted (true);
	btn0034181.setDataSourceName("");
	btn0034181.setTabOrder(468);
        
      // container is form
add (btn0034181,null);             
	} // end of initVSButtonbtn0034181
	
	
	
	
	
	
	 public void initVSButtonbtn0033191() {
	btn0033191.setText("003");
	btn0033191.setName ("btn0033191");
		btn0033191.setForeground(Color.black);
		btn0033191.setBackground(new Color(0xc6c6c6));
	btn0033191.setBounds (357, 529 , 50, 18);

btn0033191.setFont (new Font ("Helvetica", 0, 12));

 	btn0033191.setBorderPainted (true);
	btn0033191.setDataSourceName("");
	btn0033191.setTabOrder(467);
        
      // container is form
add (btn0033191,null);             
	} // end of initVSButtonbtn0033191
	
	
	
	
	
	
	 public void initVSButtonbtn0032201() {
	btn0032201.setText("003");
	btn0032201.setName ("btn0032201");
		btn0032201.setForeground(Color.black);
		btn0032201.setBackground(new Color(0xc6c6c6));
	btn0032201.setBounds (347, 519 , 50, 18);

btn0032201.setFont (new Font ("Helvetica", 0, 12));

 	btn0032201.setBorderPainted (true);
	btn0032201.setDataSourceName("");
	btn0032201.setTabOrder(466);
        
      // container is form
add (btn0032201,null);             
	} // end of initVSButtonbtn0032201
	
	
	
	
	
	
	 public void initVSButtonbtn0031321() {
	btn0031321.setText("003");
	btn0031321.setName ("btn0031321");
		btn0031321.setForeground(Color.black);
		btn0031321.setBackground(new Color(0xc6c6c6));
	btn0031321.setBounds (337, 509 , 50, 18);

btn0031321.setFont (new Font ("Helvetica", 0, 12));

 	btn0031321.setBorderPainted (true);
	btn0031321.setDataSourceName("");
	btn0031321.setTabOrder(465);
        
      // container is form
add (btn0031321,null);             
	} // end of initVSButtonbtn0031321
	
	
	
	
	
	
	 public void initVSButtonbtn0031311() {
	btn0031311.setText("003");
	btn0031311.setName ("btn0031311");
		btn0031311.setForeground(Color.black);
		btn0031311.setBackground(new Color(0xc6c6c6));
	btn0031311.setBounds (327, 499 , 50, 18);

btn0031311.setFont (new Font ("Helvetica", 0, 12));

 	btn0031311.setBorderPainted (true);
	btn0031311.setDataSourceName("");
	btn0031311.setTabOrder(464);
        
      // container is form
add (btn0031311,null);             
	} // end of initVSButtonbtn0031311
	
	
	
	
	
	
	 public void initVSButtonbtn002181() {
	btn002181.setText("002");
	btn002181.setName ("btn002181");
		btn002181.setForeground(Color.black);
		btn002181.setBackground(new Color(0xc6c6c6));
	btn002181.setBounds (322, 482 , 50, 18);

btn002181.setFont (new Font ("Helvetica", 0, 12));

 	btn002181.setBorderPainted (true);
	btn002181.setDataSourceName("");
	btn002181.setTabOrder(463);
        
      // container is form
add (btn002181,null);             
	} // end of initVSButtonbtn002181
	
	
	
	
	
	
	 public void initVSButtonbtn001181() {
	btn001181.setText("001");
	btn001181.setName ("btn001181");
		btn001181.setForeground(Color.black);
		btn001181.setBackground(new Color(0xc6c6c6));
	btn001181.setBounds (304, 465 , 50, 18);

btn001181.setFont (new Font ("Helvetica", 0, 12));

 	btn001181.setBorderPainted (true);
	btn001181.setDataSourceName("");
	btn001181.setTabOrder(462);
        
      // container is form
add (btn001181,null);             
	} // end of initVSButtonbtn001181
	
	
	
	
	
	
	 public void initVSButtonbtn00311201() {
	btn00311201.setText("003");
	btn00311201.setName ("btn00311201");
		btn00311201.setForeground(Color.black);
		btn00311201.setBackground(new Color(0xc6c6c6));
	btn00311201.setBounds (391, 618 , 50, 18);

btn00311201.setFont (new Font ("Helvetica", 0, 12));

 	btn00311201.setBorderPainted (true);
	btn00311201.setDataSourceName("");
	btn00311201.setTabOrder(461);
        
      // container is form
add (btn00311201,null);             
	} // end of initVSButtonbtn00311201
	
	
	
	
	
	
	 public void initVSButtonbtn00310171() {
	btn00310171.setText("003");
	btn00310171.setName ("btn00310171");
		btn00310171.setForeground(Color.black);
		btn00310171.setBackground(new Color(0xc6c6c6));
	btn00310171.setBounds (381, 608 , 50, 18);

btn00310171.setFont (new Font ("Helvetica", 0, 12));

 	btn00310171.setBorderPainted (true);
	btn00310171.setDataSourceName("");
	btn00310171.setTabOrder(460);
        
      // container is form
add (btn00310171,null);             
	} // end of initVSButtonbtn00310171
	
	
	
	
	
	
	 public void initVSButtonbtn0039171() {
	btn0039171.setText("003");
	btn0039171.setName ("btn0039171");
		btn0039171.setForeground(Color.black);
		btn0039171.setBackground(new Color(0xc6c6c6));
	btn0039171.setBounds (371, 598 , 50, 18);

btn0039171.setFont (new Font ("Helvetica", 0, 12));

 	btn0039171.setBorderPainted (true);
	btn0039171.setDataSourceName("");
	btn0039171.setTabOrder(459);
        
      // container is form
add (btn0039171,null);             
	} // end of initVSButtonbtn0039171
	
	
	
	
	
	
	 public void initVSButtonbtn0038171() {
	btn0038171.setText("003");
	btn0038171.setName ("btn0038171");
		btn0038171.setForeground(Color.black);
		btn0038171.setBackground(new Color(0xc6c6c6));
	btn0038171.setBounds (361, 588 , 50, 18);

btn0038171.setFont (new Font ("Helvetica", 0, 12));

 	btn0038171.setBorderPainted (true);
	btn0038171.setDataSourceName("");
	btn0038171.setTabOrder(458);
        
      // container is form
add (btn0038171,null);             
	} // end of initVSButtonbtn0038171
	
	
	
	
	
	
	 public void initVSButtonbtn0037171() {
	btn0037171.setText("003");
	btn0037171.setName ("btn0037171");
		btn0037171.setForeground(Color.black);
		btn0037171.setBackground(new Color(0xc6c6c6));
	btn0037171.setBounds (351, 578 , 50, 18);

btn0037171.setFont (new Font ("Helvetica", 0, 12));

 	btn0037171.setBorderPainted (true);
	btn0037171.setDataSourceName("");
	btn0037171.setTabOrder(457);
        
      // container is form
add (btn0037171,null);             
	} // end of initVSButtonbtn0037171
	
	
	
	
	
	
	 public void initVSButtonbtn0036171() {
	btn0036171.setText("003");
	btn0036171.setName ("btn0036171");
		btn0036171.setForeground(Color.black);
		btn0036171.setBackground(new Color(0xc6c6c6));
	btn0036171.setBounds (341, 568 , 50, 18);

btn0036171.setFont (new Font ("Helvetica", 0, 12));

 	btn0036171.setBorderPainted (true);
	btn0036171.setDataSourceName("");
	btn0036171.setTabOrder(456);
        
      // container is form
add (btn0036171,null);             
	} // end of initVSButtonbtn0036171
	
	
	
	
	
	
	 public void initVSButtonbtn0035171() {
	btn0035171.setText("003");
	btn0035171.setName ("btn0035171");
		btn0035171.setForeground(Color.black);
		btn0035171.setBackground(new Color(0xc6c6c6));
	btn0035171.setBounds (331, 558 , 50, 18);

btn0035171.setFont (new Font ("Helvetica", 0, 12));

 	btn0035171.setBorderPainted (true);
	btn0035171.setDataSourceName("");
	btn0035171.setTabOrder(455);
        
      // container is form
add (btn0035171,null);             
	} // end of initVSButtonbtn0035171
	
	
	
	
	
	
	 public void initVSButtonbtn0034171() {
	btn0034171.setText("003");
	btn0034171.setName ("btn0034171");
		btn0034171.setForeground(Color.black);
		btn0034171.setBackground(new Color(0xc6c6c6));
	btn0034171.setBounds (321, 548 , 50, 18);

btn0034171.setFont (new Font ("Helvetica", 0, 12));

 	btn0034171.setBorderPainted (true);
	btn0034171.setDataSourceName("");
	btn0034171.setTabOrder(454);
        
      // container is form
add (btn0034171,null);             
	} // end of initVSButtonbtn0034171
	
	
	
	
	
	
	 public void initVSButtonbtn0033181() {
	btn0033181.setText("003");
	btn0033181.setName ("btn0033181");
		btn0033181.setForeground(Color.black);
		btn0033181.setBackground(new Color(0xc6c6c6));
	btn0033181.setBounds (311, 538 , 50, 18);

btn0033181.setFont (new Font ("Helvetica", 0, 12));

 	btn0033181.setBorderPainted (true);
	btn0033181.setDataSourceName("");
	btn0033181.setTabOrder(453);
        
      // container is form
add (btn0033181,null);             
	} // end of initVSButtonbtn0033181
	
	
	
	
	
	
	 public void initVSButtonbtn0032191() {
	btn0032191.setText("003");
	btn0032191.setName ("btn0032191");
		btn0032191.setForeground(Color.black);
		btn0032191.setBackground(new Color(0xc6c6c6));
	btn0032191.setBounds (301, 528 , 50, 18);

btn0032191.setFont (new Font ("Helvetica", 0, 12));

 	btn0032191.setBorderPainted (true);
	btn0032191.setDataSourceName("");
	btn0032191.setTabOrder(452);
        
      // container is form
add (btn0032191,null);             
	} // end of initVSButtonbtn0032191
	
	
	
	
	
	
	 public void initVSButtonbtn0031301() {
	btn0031301.setText("003");
	btn0031301.setName ("btn0031301");
		btn0031301.setForeground(Color.black);
		btn0031301.setBackground(new Color(0xc6c6c6));
	btn0031301.setBounds (291, 518 , 50, 18);

btn0031301.setFont (new Font ("Helvetica", 0, 12));

 	btn0031301.setBorderPainted (true);
	btn0031301.setDataSourceName("");
	btn0031301.setTabOrder(451);
        
      // container is form
add (btn0031301,null);             
	} // end of initVSButtonbtn0031301
	
	
	
	
	
	
	 public void initVSButtonbtn0031291() {
	btn0031291.setText("003");
	btn0031291.setName ("btn0031291");
		btn0031291.setForeground(Color.black);
		btn0031291.setBackground(new Color(0xc6c6c6));
	btn0031291.setBounds (281, 508 , 50, 18);

btn0031291.setFont (new Font ("Helvetica", 0, 12));

 	btn0031291.setBorderPainted (true);
	btn0031291.setDataSourceName("");
	btn0031291.setTabOrder(450);
        
      // container is form
add (btn0031291,null);             
	} // end of initVSButtonbtn0031291
	
	
	
	
	
	
	 public void initVSButtonbtn002171() {
	btn002171.setText("002");
	btn002171.setName ("btn002171");
		btn002171.setForeground(Color.black);
		btn002171.setBackground(new Color(0xc6c6c6));
	btn002171.setBounds (276, 491 , 50, 18);

btn002171.setFont (new Font ("Helvetica", 0, 12));

 	btn002171.setBorderPainted (true);
	btn002171.setDataSourceName("");
	btn002171.setTabOrder(449);
        
      // container is form
add (btn002171,null);             
	} // end of initVSButtonbtn002171
	
	
	
	
	
	
	 public void initVSButtonbtn00311191() {
	btn00311191.setText("003");
	btn00311191.setName ("btn00311191");
		btn00311191.setForeground(Color.black);
		btn00311191.setBackground(new Color(0xc6c6c6));
	btn00311191.setBounds (375, 577 , 50, 18);

btn00311191.setFont (new Font ("Helvetica", 0, 12));

 	btn00311191.setBorderPainted (true);
	btn00311191.setDataSourceName("");
	btn00311191.setTabOrder(448);
        
      // container is form
add (btn00311191,null);             
	} // end of initVSButtonbtn00311191
	
	
	
	
	
	
	 public void initVSButtonbtn00310161() {
	btn00310161.setText("003");
	btn00310161.setName ("btn00310161");
		btn00310161.setForeground(Color.black);
		btn00310161.setBackground(new Color(0xc6c6c6));
	btn00310161.setBounds (365, 567 , 50, 18);

btn00310161.setFont (new Font ("Helvetica", 0, 12));

 	btn00310161.setBorderPainted (true);
	btn00310161.setDataSourceName("");
	btn00310161.setTabOrder(447);
        
      // container is form
add (btn00310161,null);             
	} // end of initVSButtonbtn00310161
	
	
	
	
	
	
	 public void initVSButtonbtn0039161() {
	btn0039161.setText("003");
	btn0039161.setName ("btn0039161");
		btn0039161.setForeground(Color.black);
		btn0039161.setBackground(new Color(0xc6c6c6));
	btn0039161.setBounds (355, 557 , 50, 18);

btn0039161.setFont (new Font ("Helvetica", 0, 12));

 	btn0039161.setBorderPainted (true);
	btn0039161.setDataSourceName("");
	btn0039161.setTabOrder(446);
        
      // container is form
add (btn0039161,null);             
	} // end of initVSButtonbtn0039161
	
	
	
	
	
	
	 public void initVSButtonbtn0038161() {
	btn0038161.setText("003");
	btn0038161.setName ("btn0038161");
		btn0038161.setForeground(Color.black);
		btn0038161.setBackground(new Color(0xc6c6c6));
	btn0038161.setBounds (345, 547 , 50, 18);

btn0038161.setFont (new Font ("Helvetica", 0, 12));

 	btn0038161.setBorderPainted (true);
	btn0038161.setDataSourceName("");
	btn0038161.setTabOrder(445);
        
      // container is form
add (btn0038161,null);             
	} // end of initVSButtonbtn0038161
	
	
	
	
	
	
	 public void initVSButtonbtn0037161() {
	btn0037161.setText("003");
	btn0037161.setName ("btn0037161");
		btn0037161.setForeground(Color.black);
		btn0037161.setBackground(new Color(0xc6c6c6));
	btn0037161.setBounds (335, 537 , 50, 18);

btn0037161.setFont (new Font ("Helvetica", 0, 12));

 	btn0037161.setBorderPainted (true);
	btn0037161.setDataSourceName("");
	btn0037161.setTabOrder(444);
        
      // container is form
add (btn0037161,null);             
	} // end of initVSButtonbtn0037161
	
	
	
	
	
	
	 public void initVSButtonbtn0036161() {
	btn0036161.setText("003");
	btn0036161.setName ("btn0036161");
		btn0036161.setForeground(Color.black);
		btn0036161.setBackground(new Color(0xc6c6c6));
	btn0036161.setBounds (325, 527 , 50, 18);

btn0036161.setFont (new Font ("Helvetica", 0, 12));

 	btn0036161.setBorderPainted (true);
	btn0036161.setDataSourceName("");
	btn0036161.setTabOrder(443);
        
      // container is form
add (btn0036161,null);             
	} // end of initVSButtonbtn0036161
	
	
	
	
	
	
	 public void initVSButtonbtn0035161() {
	btn0035161.setText("003");
	btn0035161.setName ("btn0035161");
		btn0035161.setForeground(Color.black);
		btn0035161.setBackground(new Color(0xc6c6c6));
	btn0035161.setBounds (315, 517 , 50, 18);

btn0035161.setFont (new Font ("Helvetica", 0, 12));

 	btn0035161.setBorderPainted (true);
	btn0035161.setDataSourceName("");
	btn0035161.setTabOrder(442);
        
      // container is form
add (btn0035161,null);             
	} // end of initVSButtonbtn0035161
	
	
	
	
	
	
	 public void initVSButtonbtn0034161() {
	btn0034161.setText("003");
	btn0034161.setName ("btn0034161");
		btn0034161.setForeground(Color.black);
		btn0034161.setBackground(new Color(0xc6c6c6));
	btn0034161.setBounds (305, 507 , 50, 18);

btn0034161.setFont (new Font ("Helvetica", 0, 12));

 	btn0034161.setBorderPainted (true);
	btn0034161.setDataSourceName("");
	btn0034161.setTabOrder(441);
        
      // container is form
add (btn0034161,null);             
	} // end of initVSButtonbtn0034161
	
	
	
	
	
	
	 public void initVSButtonbtn0033171() {
	btn0033171.setText("003");
	btn0033171.setName ("btn0033171");
		btn0033171.setForeground(Color.black);
		btn0033171.setBackground(new Color(0xc6c6c6));
	btn0033171.setBounds (295, 497 , 50, 18);

btn0033171.setFont (new Font ("Helvetica", 0, 12));

 	btn0033171.setBorderPainted (true);
	btn0033171.setDataSourceName("");
	btn0033171.setTabOrder(440);
        
      // container is form
add (btn0033171,null);             
	} // end of initVSButtonbtn0033171
	
	
	
	
	
	
	 public void initVSButtonbtn0032181() {
	btn0032181.setText("003");
	btn0032181.setName ("btn0032181");
		btn0032181.setForeground(Color.black);
		btn0032181.setBackground(new Color(0xc6c6c6));
	btn0032181.setBounds (285, 487 , 50, 18);

btn0032181.setFont (new Font ("Helvetica", 0, 12));

 	btn0032181.setBorderPainted (true);
	btn0032181.setDataSourceName("");
	btn0032181.setTabOrder(439);
        
      // container is form
add (btn0032181,null);             
	} // end of initVSButtonbtn0032181
	
	
	
	
	
	
	 public void initVSButtonbtn0031281() {
	btn0031281.setText("003");
	btn0031281.setName ("btn0031281");
		btn0031281.setForeground(Color.black);
		btn0031281.setBackground(new Color(0xc6c6c6));
	btn0031281.setBounds (275, 477 , 50, 18);

btn0031281.setFont (new Font ("Helvetica", 0, 12));

 	btn0031281.setBorderPainted (true);
	btn0031281.setDataSourceName("");
	btn0031281.setTabOrder(438);
        
      // container is form
add (btn0031281,null);             
	} // end of initVSButtonbtn0031281
	
	
	
	
	
	
	 public void initVSButtonbtn0031001() {
	btn0031001.setText("003");
	btn0031001.setName ("btn0031001");
		btn0031001.setForeground(Color.black);
		btn0031001.setBackground(new Color(0xc6c6c6));
	btn0031001.setBounds (265, 467 , 50, 18);

btn0031001.setFont (new Font ("Helvetica", 0, 12));

 	btn0031001.setBorderPainted (true);
	btn0031001.setDataSourceName("");
	btn0031001.setTabOrder(437);
        
      // container is form
add (btn0031001,null);             
	} // end of initVSButtonbtn0031001
	
	
	
	
	
	
	 public void initVSButtonbtn00311181() {
	btn00311181.setText("003");
	btn00311181.setName ("btn00311181");
		btn00311181.setForeground(Color.black);
		btn00311181.setBackground(new Color(0xc6c6c6));
	btn00311181.setBounds (365, 520 , 50, 18);

btn00311181.setFont (new Font ("Helvetica", 0, 12));

 	btn00311181.setBorderPainted (true);
	btn00311181.setDataSourceName("");
	btn00311181.setTabOrder(436);
        
      // container is form
add (btn00311181,null);             
	} // end of initVSButtonbtn00311181
	
	
	
	
	
	
	 public void initVSButtonbtn00310151() {
	btn00310151.setText("003");
	btn00310151.setName ("btn00310151");
		btn00310151.setForeground(Color.black);
		btn00310151.setBackground(new Color(0xc6c6c6));
	btn00310151.setBounds (355, 510 , 50, 18);

btn00310151.setFont (new Font ("Helvetica", 0, 12));

 	btn00310151.setBorderPainted (true);
	btn00310151.setDataSourceName("");
	btn00310151.setTabOrder(435);
        
      // container is form
add (btn00310151,null);             
	} // end of initVSButtonbtn00310151
	
	
	
	
	
	
	 public void initVSButtonbtn0039151() {
	btn0039151.setText("003");
	btn0039151.setName ("btn0039151");
		btn0039151.setForeground(Color.black);
		btn0039151.setBackground(new Color(0xc6c6c6));
	btn0039151.setBounds (345, 500 , 50, 18);

btn0039151.setFont (new Font ("Helvetica", 0, 12));

 	btn0039151.setBorderPainted (true);
	btn0039151.setDataSourceName("");
	btn0039151.setTabOrder(434);
        
      // container is form
add (btn0039151,null);             
	} // end of initVSButtonbtn0039151
	
	
	
	
	
	
	 public void initVSButtonbtn0038151() {
	btn0038151.setText("003");
	btn0038151.setName ("btn0038151");
		btn0038151.setForeground(Color.black);
		btn0038151.setBackground(new Color(0xc6c6c6));
	btn0038151.setBounds (335, 490 , 50, 18);

btn0038151.setFont (new Font ("Helvetica", 0, 12));

 	btn0038151.setBorderPainted (true);
	btn0038151.setDataSourceName("");
	btn0038151.setTabOrder(433);
        
      // container is form
add (btn0038151,null);             
	} // end of initVSButtonbtn0038151
	
	
	
	
	
	
	 public void initVSButtonbtn0037151() {
	btn0037151.setText("003");
	btn0037151.setName ("btn0037151");
		btn0037151.setForeground(Color.black);
		btn0037151.setBackground(new Color(0xc6c6c6));
	btn0037151.setBounds (325, 480 , 50, 18);

btn0037151.setFont (new Font ("Helvetica", 0, 12));

 	btn0037151.setBorderPainted (true);
	btn0037151.setDataSourceName("");
	btn0037151.setTabOrder(432);
        
      // container is form
add (btn0037151,null);             
	} // end of initVSButtonbtn0037151
	
	
	
	
	
	
	 public void initVSButtonbtn0036151() {
	btn0036151.setText("003");
	btn0036151.setName ("btn0036151");
		btn0036151.setForeground(Color.black);
		btn0036151.setBackground(new Color(0xc6c6c6));
	btn0036151.setBounds (315, 470 , 50, 18);

btn0036151.setFont (new Font ("Helvetica", 0, 12));

 	btn0036151.setBorderPainted (true);
	btn0036151.setDataSourceName("");
	btn0036151.setTabOrder(431);
        
      // container is form
add (btn0036151,null);             
	} // end of initVSButtonbtn0036151
	
	
	
	
	
	
	 public void initVSButtonbtn0035151() {
	btn0035151.setText("003");
	btn0035151.setName ("btn0035151");
		btn0035151.setForeground(Color.black);
		btn0035151.setBackground(new Color(0xc6c6c6));
	btn0035151.setBounds (305, 460 , 50, 18);

btn0035151.setFont (new Font ("Helvetica", 0, 12));

 	btn0035151.setBorderPainted (true);
	btn0035151.setDataSourceName("");
	btn0035151.setTabOrder(430);
        
      // container is form
add (btn0035151,null);             
	} // end of initVSButtonbtn0035151
	
	
	
	
	
	
	 public void initVSButtonbtn0034151() {
	btn0034151.setText("003");
	btn0034151.setName ("btn0034151");
		btn0034151.setForeground(Color.black);
		btn0034151.setBackground(new Color(0xc6c6c6));
	btn0034151.setBounds (295, 450 , 50, 18);

btn0034151.setFont (new Font ("Helvetica", 0, 12));

 	btn0034151.setBorderPainted (true);
	btn0034151.setDataSourceName("");
	btn0034151.setTabOrder(429);
        
      // container is form
add (btn0034151,null);             
	} // end of initVSButtonbtn0034151
	
	
	
	
	
	
	 public void initVSButtonbtn0033161() {
	btn0033161.setText("003");
	btn0033161.setName ("btn0033161");
		btn0033161.setForeground(Color.black);
		btn0033161.setBackground(new Color(0xc6c6c6));
	btn0033161.setBounds (285, 440 , 50, 18);

btn0033161.setFont (new Font ("Helvetica", 0, 12));

 	btn0033161.setBorderPainted (true);
	btn0033161.setDataSourceName("");
	btn0033161.setTabOrder(428);
        
      // container is form
add (btn0033161,null);             
	} // end of initVSButtonbtn0033161
	
	
	
	
	
	
	 public void initVSButtonbtn0032171() {
	btn0032171.setText("003");
	btn0032171.setName ("btn0032171");
		btn0032171.setForeground(Color.black);
		btn0032171.setBackground(new Color(0xc6c6c6));
	btn0032171.setBounds (275, 430 , 50, 18);

btn0032171.setFont (new Font ("Helvetica", 0, 12));

 	btn0032171.setBorderPainted (true);
	btn0032171.setDataSourceName("");
	btn0032171.setTabOrder(427);
        
      // container is form
add (btn0032171,null);             
	} // end of initVSButtonbtn0032171
	
	
	
	
	
	
	 public void initVSButtonbtn0031271() {
	btn0031271.setText("003");
	btn0031271.setName ("btn0031271");
		btn0031271.setForeground(Color.black);
		btn0031271.setBackground(new Color(0xc6c6c6));
	btn0031271.setBounds (265, 420 , 50, 18);

btn0031271.setFont (new Font ("Helvetica", 0, 12));

 	btn0031271.setBorderPainted (true);
	btn0031271.setDataSourceName("");
	btn0031271.setTabOrder(426);
        
      // container is form
add (btn0031271,null);             
	} // end of initVSButtonbtn0031271
	
	
	
	
	
	
	 public void initVSButtonbtn00311171() {
	btn00311171.setText("003");
	btn00311171.setName ("btn00311171");
		btn00311171.setForeground(Color.black);
		btn00311171.setBackground(new Color(0xc6c6c6));
	btn00311171.setBounds (371, 489 , 50, 18);

btn00311171.setFont (new Font ("Helvetica", 0, 12));

 	btn00311171.setBorderPainted (true);
	btn00311171.setDataSourceName("");
	btn00311171.setTabOrder(425);
        
      // container is form
add (btn00311171,null);             
	} // end of initVSButtonbtn00311171
	
	
	
	
	
	
	 public void initVSButtonbtn00310141() {
	btn00310141.setText("003");
	btn00310141.setName ("btn00310141");
		btn00310141.setForeground(Color.black);
		btn00310141.setBackground(new Color(0xc6c6c6));
	btn00310141.setBounds (361, 479 , 50, 18);

btn00310141.setFont (new Font ("Helvetica", 0, 12));

 	btn00310141.setBorderPainted (true);
	btn00310141.setDataSourceName("");
	btn00310141.setTabOrder(424);
        
      // container is form
add (btn00310141,null);             
	} // end of initVSButtonbtn00310141
	
	
	
	
	
	
	 public void initVSButtonbtn0039141() {
	btn0039141.setText("003");
	btn0039141.setName ("btn0039141");
		btn0039141.setForeground(Color.black);
		btn0039141.setBackground(new Color(0xc6c6c6));
	btn0039141.setBounds (351, 469 , 50, 18);

btn0039141.setFont (new Font ("Helvetica", 0, 12));

 	btn0039141.setBorderPainted (true);
	btn0039141.setDataSourceName("");
	btn0039141.setTabOrder(423);
        
      // container is form
add (btn0039141,null);             
	} // end of initVSButtonbtn0039141
	
	
	
	
	
	
	 public void initVSButtonbtn0038141() {
	btn0038141.setText("003");
	btn0038141.setName ("btn0038141");
		btn0038141.setForeground(Color.black);
		btn0038141.setBackground(new Color(0xc6c6c6));
	btn0038141.setBounds (341, 459 , 50, 18);

btn0038141.setFont (new Font ("Helvetica", 0, 12));

 	btn0038141.setBorderPainted (true);
	btn0038141.setDataSourceName("");
	btn0038141.setTabOrder(422);
        
      // container is form
add (btn0038141,null);             
	} // end of initVSButtonbtn0038141
	
	
	
	
	
	
	 public void initVSButtonbtn0037141() {
	btn0037141.setText("003");
	btn0037141.setName ("btn0037141");
		btn0037141.setForeground(Color.black);
		btn0037141.setBackground(new Color(0xc6c6c6));
	btn0037141.setBounds (331, 449 , 50, 18);

btn0037141.setFont (new Font ("Helvetica", 0, 12));

 	btn0037141.setBorderPainted (true);
	btn0037141.setDataSourceName("");
	btn0037141.setTabOrder(421);
        
      // container is form
add (btn0037141,null);             
	} // end of initVSButtonbtn0037141
	
	
	
	
	
	
	 public void initVSButtonbtn0036141() {
	btn0036141.setText("003");
	btn0036141.setName ("btn0036141");
		btn0036141.setForeground(Color.black);
		btn0036141.setBackground(new Color(0xc6c6c6));
	btn0036141.setBounds (321, 439 , 50, 18);

btn0036141.setFont (new Font ("Helvetica", 0, 12));

 	btn0036141.setBorderPainted (true);
	btn0036141.setDataSourceName("");
	btn0036141.setTabOrder(420);
        
      // container is form
add (btn0036141,null);             
	} // end of initVSButtonbtn0036141
	
	
	
	
	
	
	 public void initVSButtonbtn0035141() {
	btn0035141.setText("003");
	btn0035141.setName ("btn0035141");
		btn0035141.setForeground(Color.black);
		btn0035141.setBackground(new Color(0xc6c6c6));
	btn0035141.setBounds (311, 429 , 50, 18);

btn0035141.setFont (new Font ("Helvetica", 0, 12));

 	btn0035141.setBorderPainted (true);
	btn0035141.setDataSourceName("");
	btn0035141.setTabOrder(419);
        
      // container is form
add (btn0035141,null);             
	} // end of initVSButtonbtn0035141
	
	
	
	
	
	
	 public void initVSButtonbtn0034141() {
	btn0034141.setText("003");
	btn0034141.setName ("btn0034141");
		btn0034141.setForeground(Color.black);
		btn0034141.setBackground(new Color(0xc6c6c6));
	btn0034141.setBounds (301, 419 , 50, 18);

btn0034141.setFont (new Font ("Helvetica", 0, 12));

 	btn0034141.setBorderPainted (true);
	btn0034141.setDataSourceName("");
	btn0034141.setTabOrder(418);
        
      // container is form
add (btn0034141,null);             
	} // end of initVSButtonbtn0034141
	
	
	
	
	
	
	 public void initVSButtonbtn0033151() {
	btn0033151.setText("003");
	btn0033151.setName ("btn0033151");
		btn0033151.setForeground(Color.black);
		btn0033151.setBackground(new Color(0xc6c6c6));
	btn0033151.setBounds (291, 409 , 50, 18);

btn0033151.setFont (new Font ("Helvetica", 0, 12));

 	btn0033151.setBorderPainted (true);
	btn0033151.setDataSourceName("");
	btn0033151.setTabOrder(417);
        
      // container is form
add (btn0033151,null);             
	} // end of initVSButtonbtn0033151
	
	
	
	
	
	
	 public void initVSButtonbtn0032161() {
	btn0032161.setText("003");
	btn0032161.setName ("btn0032161");
		btn0032161.setForeground(Color.black);
		btn0032161.setBackground(new Color(0xc6c6c6));
	btn0032161.setBounds (281, 399 , 50, 18);

btn0032161.setFont (new Font ("Helvetica", 0, 12));

 	btn0032161.setBorderPainted (true);
	btn0032161.setDataSourceName("");
	btn0032161.setTabOrder(416);
        
      // container is form
add (btn0032161,null);             
	} // end of initVSButtonbtn0032161
	
	
	
	
	
	
	 public void initVSButtonbtn0031261() {
	btn0031261.setText("003");
	btn0031261.setName ("btn0031261");
		btn0031261.setForeground(Color.black);
		btn0031261.setBackground(new Color(0xc6c6c6));
	btn0031261.setBounds (271, 389 , 50, 18);

btn0031261.setFont (new Font ("Helvetica", 0, 12));

 	btn0031261.setBorderPainted (true);
	btn0031261.setDataSourceName("");
	btn0031261.setTabOrder(415);
        
      // container is form
add (btn0031261,null);             
	} // end of initVSButtonbtn0031261
	
	
	
	
	
	
	 public void initVSButtonbtn00311161() {
	btn00311161.setText("003");
	btn00311161.setName ("btn00311161");
		btn00311161.setForeground(Color.black);
		btn00311161.setBackground(new Color(0xc6c6c6));
	btn00311161.setBounds (379, 461 , 50, 18);

btn00311161.setFont (new Font ("Helvetica", 0, 12));

 	btn00311161.setBorderPainted (true);
	btn00311161.setDataSourceName("");
	btn00311161.setTabOrder(414);
        
      // container is form
add (btn00311161,null);             
	} // end of initVSButtonbtn00311161
	
	
	
	
	
	
	 public void initVSButtonbtn00310131() {
	btn00310131.setText("003");
	btn00310131.setName ("btn00310131");
		btn00310131.setForeground(Color.black);
		btn00310131.setBackground(new Color(0xc6c6c6));
	btn00310131.setBounds (369, 451 , 50, 18);

btn00310131.setFont (new Font ("Helvetica", 0, 12));

 	btn00310131.setBorderPainted (true);
	btn00310131.setDataSourceName("");
	btn00310131.setTabOrder(413);
        
      // container is form
add (btn00310131,null);             
	} // end of initVSButtonbtn00310131
	
	
	
	
	
	
	 public void initVSButtonbtn0039131() {
	btn0039131.setText("003");
	btn0039131.setName ("btn0039131");
		btn0039131.setForeground(Color.black);
		btn0039131.setBackground(new Color(0xc6c6c6));
	btn0039131.setBounds (359, 441 , 50, 18);

btn0039131.setFont (new Font ("Helvetica", 0, 12));

 	btn0039131.setBorderPainted (true);
	btn0039131.setDataSourceName("");
	btn0039131.setTabOrder(412);
        
      // container is form
add (btn0039131,null);             
	} // end of initVSButtonbtn0039131
	
	
	
	
	
	
	 public void initVSButtonbtn0038131() {
	btn0038131.setText("003");
	btn0038131.setName ("btn0038131");
		btn0038131.setForeground(Color.black);
		btn0038131.setBackground(new Color(0xc6c6c6));
	btn0038131.setBounds (349, 431 , 50, 18);

btn0038131.setFont (new Font ("Helvetica", 0, 12));

 	btn0038131.setBorderPainted (true);
	btn0038131.setDataSourceName("");
	btn0038131.setTabOrder(411);
        
      // container is form
add (btn0038131,null);             
	} // end of initVSButtonbtn0038131
	
	
	
	
	
	
	 public void initVSButtonbtn0037131() {
	btn0037131.setText("003");
	btn0037131.setName ("btn0037131");
		btn0037131.setForeground(Color.black);
		btn0037131.setBackground(new Color(0xc6c6c6));
	btn0037131.setBounds (339, 421 , 50, 18);

btn0037131.setFont (new Font ("Helvetica", 0, 12));

 	btn0037131.setBorderPainted (true);
	btn0037131.setDataSourceName("");
	btn0037131.setTabOrder(410);
        
      // container is form
add (btn0037131,null);             
	} // end of initVSButtonbtn0037131
	
	
	
	
	
	
	 public void initVSButtonbtn0036131() {
	btn0036131.setText("003");
	btn0036131.setName ("btn0036131");
		btn0036131.setForeground(Color.black);
		btn0036131.setBackground(new Color(0xc6c6c6));
	btn0036131.setBounds (329, 411 , 50, 18);

btn0036131.setFont (new Font ("Helvetica", 0, 12));

 	btn0036131.setBorderPainted (true);
	btn0036131.setDataSourceName("");
	btn0036131.setTabOrder(409);
        
      // container is form
add (btn0036131,null);             
	} // end of initVSButtonbtn0036131
	
	
	
	
	
	
	 public void initVSButtonbtn0035131() {
	btn0035131.setText("003");
	btn0035131.setName ("btn0035131");
		btn0035131.setForeground(Color.black);
		btn0035131.setBackground(new Color(0xc6c6c6));
	btn0035131.setBounds (319, 401 , 50, 18);

btn0035131.setFont (new Font ("Helvetica", 0, 12));

 	btn0035131.setBorderPainted (true);
	btn0035131.setDataSourceName("");
	btn0035131.setTabOrder(408);
        
      // container is form
add (btn0035131,null);             
	} // end of initVSButtonbtn0035131
	
	
	
	
	
	
	 public void initVSButtonbtn0034131() {
	btn0034131.setText("003");
	btn0034131.setName ("btn0034131");
		btn0034131.setForeground(Color.black);
		btn0034131.setBackground(new Color(0xc6c6c6));
	btn0034131.setBounds (309, 391 , 50, 18);

btn0034131.setFont (new Font ("Helvetica", 0, 12));

 	btn0034131.setBorderPainted (true);
	btn0034131.setDataSourceName("");
	btn0034131.setTabOrder(407);
        
      // container is form
add (btn0034131,null);             
	} // end of initVSButtonbtn0034131
	
	
	
	
	
	
	 public void initVSButtonbtn0033141() {
	btn0033141.setText("003");
	btn0033141.setName ("btn0033141");
		btn0033141.setForeground(Color.black);
		btn0033141.setBackground(new Color(0xc6c6c6));
	btn0033141.setBounds (299, 381 , 50, 18);

btn0033141.setFont (new Font ("Helvetica", 0, 12));

 	btn0033141.setBorderPainted (true);
	btn0033141.setDataSourceName("");
	btn0033141.setTabOrder(406);
        
      // container is form
add (btn0033141,null);             
	} // end of initVSButtonbtn0033141
	
	
	
	
	
	
	 public void initVSButtonbtn0032151() {
	btn0032151.setText("003");
	btn0032151.setName ("btn0032151");
		btn0032151.setForeground(Color.black);
		btn0032151.setBackground(new Color(0xc6c6c6));
	btn0032151.setBounds (289, 371 , 50, 18);

btn0032151.setFont (new Font ("Helvetica", 0, 12));

 	btn0032151.setBorderPainted (true);
	btn0032151.setDataSourceName("");
	btn0032151.setTabOrder(405);
        
      // container is form
add (btn0032151,null);             
	} // end of initVSButtonbtn0032151
	
	
	
	
	
	
	 public void initVSButtonbtn0031251() {
	btn0031251.setText("003");
	btn0031251.setName ("btn0031251");
		btn0031251.setForeground(Color.black);
		btn0031251.setBackground(new Color(0xc6c6c6));
	btn0031251.setBounds (279, 361 , 50, 18);

btn0031251.setFont (new Font ("Helvetica", 0, 12));

 	btn0031251.setBorderPainted (true);
	btn0031251.setDataSourceName("");
	btn0031251.setTabOrder(404);
        
      // container is form
add (btn0031251,null);             
	} // end of initVSButtonbtn0031251
	
	
	
	
	
	
	 public void initVSButtonbtn003701() {
	btn003701.setText("003");
	btn003701.setName ("btn003701");
		btn003701.setForeground(Color.black);
		btn003701.setBackground(new Color(0xc6c6c6));
	btn003701.setBounds (269, 351 , 50, 18);

btn003701.setFont (new Font ("Helvetica", 0, 12));

 	btn003701.setBorderPainted (true);
	btn003701.setDataSourceName("");
	btn003701.setTabOrder(403);
        
      // container is form
add (btn003701,null);             
	} // end of initVSButtonbtn003701
	
	
	
	
	
	
	 public void initVSButtonbtn002131() {
	btn002131.setText("002");
	btn002131.setName ("btn002131");
		btn002131.setForeground(Color.black);
		btn002131.setBackground(new Color(0xc6c6c6));
	btn002131.setBounds (264, 334 , 50, 18);

btn002131.setFont (new Font ("Helvetica", 0, 12));

 	btn002131.setBorderPainted (true);
	btn002131.setDataSourceName("");
	btn002131.setTabOrder(402);
        
      // container is form
add (btn002131,null);             
	} // end of initVSButtonbtn002131
	
	
	
	
	
	
	 public void initVSButtonbtn00311151() {
	btn00311151.setText("003");
	btn00311151.setName ("btn00311151");
		btn00311151.setForeground(Color.black);
		btn00311151.setBackground(new Color(0xc6c6c6));
	btn00311151.setBounds (397, 456 , 50, 18);

btn00311151.setFont (new Font ("Helvetica", 0, 12));

 	btn00311151.setBorderPainted (true);
	btn00311151.setDataSourceName("");
	btn00311151.setTabOrder(401);
        
      // container is form
add (btn00311151,null);             
	} // end of initVSButtonbtn00311151
	
	
	
	
	
	
	 public void initVSButtonbtn00310121() {
	btn00310121.setText("003");
	btn00310121.setName ("btn00310121");
		btn00310121.setForeground(Color.black);
		btn00310121.setBackground(new Color(0xc6c6c6));
	btn00310121.setBounds (387, 446 , 50, 18);

btn00310121.setFont (new Font ("Helvetica", 0, 12));

 	btn00310121.setBorderPainted (true);
	btn00310121.setDataSourceName("");
	btn00310121.setTabOrder(400);
        
      // container is form
add (btn00310121,null);             
	} // end of initVSButtonbtn00310121
	
	
	
	
	
	
	 public void initVSButtonbtn0039121() {
	btn0039121.setText("003");
	btn0039121.setName ("btn0039121");
		btn0039121.setForeground(Color.black);
		btn0039121.setBackground(new Color(0xc6c6c6));
	btn0039121.setBounds (377, 436 , 50, 18);

btn0039121.setFont (new Font ("Helvetica", 0, 12));

 	btn0039121.setBorderPainted (true);
	btn0039121.setDataSourceName("");
	btn0039121.setTabOrder(399);
        
      // container is form
add (btn0039121,null);             
	} // end of initVSButtonbtn0039121
	
	
	
	
	
	
	 public void initVSButtonbtn0038121() {
	btn0038121.setText("003");
	btn0038121.setName ("btn0038121");
		btn0038121.setForeground(Color.black);
		btn0038121.setBackground(new Color(0xc6c6c6));
	btn0038121.setBounds (367, 426 , 50, 18);

btn0038121.setFont (new Font ("Helvetica", 0, 12));

 	btn0038121.setBorderPainted (true);
	btn0038121.setDataSourceName("");
	btn0038121.setTabOrder(398);
        
      // container is form
add (btn0038121,null);             
	} // end of initVSButtonbtn0038121
	
	
	
	
	
	
	 public void initVSButtonbtn0037121() {
	btn0037121.setText("003");
	btn0037121.setName ("btn0037121");
		btn0037121.setForeground(Color.black);
		btn0037121.setBackground(new Color(0xc6c6c6));
	btn0037121.setBounds (357, 416 , 50, 18);

btn0037121.setFont (new Font ("Helvetica", 0, 12));

 	btn0037121.setBorderPainted (true);
	btn0037121.setDataSourceName("");
	btn0037121.setTabOrder(397);
        
      // container is form
add (btn0037121,null);             
	} // end of initVSButtonbtn0037121
	
	
	
	
	
	
	 public void initVSButtonbtn0036121() {
	btn0036121.setText("003");
	btn0036121.setName ("btn0036121");
		btn0036121.setForeground(Color.black);
		btn0036121.setBackground(new Color(0xc6c6c6));
	btn0036121.setBounds (347, 406 , 50, 18);

btn0036121.setFont (new Font ("Helvetica", 0, 12));

 	btn0036121.setBorderPainted (true);
	btn0036121.setDataSourceName("");
	btn0036121.setTabOrder(396);
        
      // container is form
add (btn0036121,null);             
	} // end of initVSButtonbtn0036121
	
	
	
	
	
	
	 public void initVSButtonbtn0035121() {
	btn0035121.setText("003");
	btn0035121.setName ("btn0035121");
		btn0035121.setForeground(Color.black);
		btn0035121.setBackground(new Color(0xc6c6c6));
	btn0035121.setBounds (337, 396 , 50, 18);

btn0035121.setFont (new Font ("Helvetica", 0, 12));

 	btn0035121.setBorderPainted (true);
	btn0035121.setDataSourceName("");
	btn0035121.setTabOrder(395);
        
      // container is form
add (btn0035121,null);             
	} // end of initVSButtonbtn0035121
	
	
	
	
	
	
	 public void initVSButtonbtn0034121() {
	btn0034121.setText("003");
	btn0034121.setName ("btn0034121");
		btn0034121.setForeground(Color.black);
		btn0034121.setBackground(new Color(0xc6c6c6));
	btn0034121.setBounds (327, 386 , 50, 18);

btn0034121.setFont (new Font ("Helvetica", 0, 12));

 	btn0034121.setBorderPainted (true);
	btn0034121.setDataSourceName("");
	btn0034121.setTabOrder(394);
        
      // container is form
add (btn0034121,null);             
	} // end of initVSButtonbtn0034121
	
	
	
	
	
	
	 public void initVSButtonbtn0033131() {
	btn0033131.setText("003");
	btn0033131.setName ("btn0033131");
		btn0033131.setForeground(Color.black);
		btn0033131.setBackground(new Color(0xc6c6c6));
	btn0033131.setBounds (317, 376 , 50, 18);

btn0033131.setFont (new Font ("Helvetica", 0, 12));

 	btn0033131.setBorderPainted (true);
	btn0033131.setDataSourceName("");
	btn0033131.setTabOrder(393);
        
      // container is form
add (btn0033131,null);             
	} // end of initVSButtonbtn0033131
	
	
	
	
	
	
	 public void initVSButtonbtn0032141() {
	btn0032141.setText("003");
	btn0032141.setName ("btn0032141");
		btn0032141.setForeground(Color.black);
		btn0032141.setBackground(new Color(0xc6c6c6));
	btn0032141.setBounds (307, 366 , 50, 18);

btn0032141.setFont (new Font ("Helvetica", 0, 12));

 	btn0032141.setBorderPainted (true);
	btn0032141.setDataSourceName("");
	btn0032141.setTabOrder(392);
        
      // container is form
add (btn0032141,null);             
	} // end of initVSButtonbtn0032141
	
	
	
	
	
	
	 public void initVSButtonbtn0031241() {
	btn0031241.setText("003");
	btn0031241.setName ("btn0031241");
		btn0031241.setForeground(Color.black);
		btn0031241.setBackground(new Color(0xc6c6c6));
	btn0031241.setBounds (297, 356 , 50, 18);

btn0031241.setFont (new Font ("Helvetica", 0, 12));

 	btn0031241.setBorderPainted (true);
	btn0031241.setDataSourceName("");
	btn0031241.setTabOrder(391);
        
      // container is form
add (btn0031241,null);             
	} // end of initVSButtonbtn0031241
	
	
	
	
	
	
	 public void initVSButtonbtn003601() {
	btn003601.setText("003");
	btn003601.setName ("btn003601");
		btn003601.setForeground(Color.black);
		btn003601.setBackground(new Color(0xc6c6c6));
	btn003601.setBounds (287, 346 , 50, 18);

btn003601.setFont (new Font ("Helvetica", 0, 12));

 	btn003601.setBorderPainted (true);
	btn003601.setDataSourceName("");
	btn003601.setTabOrder(390);
        
      // container is form
add (btn003601,null);             
	} // end of initVSButtonbtn003601
	
	
	
	
	
	
	 public void initVSButtonbtn002121() {
	btn002121.setText("002");
	btn002121.setName ("btn002121");
		btn002121.setForeground(Color.black);
		btn002121.setBackground(new Color(0xc6c6c6));
	btn002121.setBounds (282, 329 , 50, 18);

btn002121.setFont (new Font ("Helvetica", 0, 12));

 	btn002121.setBorderPainted (true);
	btn002121.setDataSourceName("");
	btn002121.setTabOrder(389);
        
      // container is form
add (btn002121,null);             
	} // end of initVSButtonbtn002121
	
	
	
	
	
	
	 public void initVSButtonbtn001121() {
	btn001121.setText("001");
	btn001121.setName ("btn001121");
		btn001121.setForeground(Color.black);
		btn001121.setBackground(new Color(0xc6c6c6));
	btn001121.setBounds (264, 312 , 50, 18);

btn001121.setFont (new Font ("Helvetica", 0, 12));

 	btn001121.setBorderPainted (true);
	btn001121.setDataSourceName("");
	btn001121.setTabOrder(388);
        
      // container is form
add (btn001121,null);             
	} // end of initVSButtonbtn001121
	
	
	
	
	
	
	 public void initVSButtonbtn00311141() {
	btn00311141.setText("003");
	btn00311141.setName ("btn00311141");
		btn00311141.setForeground(Color.black);
		btn00311141.setBackground(new Color(0xc6c6c6));
	btn00311141.setBounds (379, 407 , 50, 18);

btn00311141.setFont (new Font ("Helvetica", 0, 12));

 	btn00311141.setBorderPainted (true);
	btn00311141.setDataSourceName("");
	btn00311141.setTabOrder(387);
        
      // container is form
add (btn00311141,null);             
	} // end of initVSButtonbtn00311141
	
	
	
	
	
	
	 public void initVSButtonbtn00310111() {
	btn00310111.setText("003");
	btn00310111.setName ("btn00310111");
		btn00310111.setForeground(Color.black);
		btn00310111.setBackground(new Color(0xc6c6c6));
	btn00310111.setBounds (369, 397 , 50, 18);

btn00310111.setFont (new Font ("Helvetica", 0, 12));

 	btn00310111.setBorderPainted (true);
	btn00310111.setDataSourceName("");
	btn00310111.setTabOrder(386);
        
      // container is form
add (btn00310111,null);             
	} // end of initVSButtonbtn00310111
	
	
	
	
	
	
	 public void initVSButtonbtn0039111() {
	btn0039111.setText("003");
	btn0039111.setName ("btn0039111");
		btn0039111.setForeground(Color.black);
		btn0039111.setBackground(new Color(0xc6c6c6));
	btn0039111.setBounds (359, 387 , 50, 18);

btn0039111.setFont (new Font ("Helvetica", 0, 12));

 	btn0039111.setBorderPainted (true);
	btn0039111.setDataSourceName("");
	btn0039111.setTabOrder(385);
        
      // container is form
add (btn0039111,null);             
	} // end of initVSButtonbtn0039111
	
	
	
	
	
	
	 public void initVSButtonbtn0038111() {
	btn0038111.setText("003");
	btn0038111.setName ("btn0038111");
		btn0038111.setForeground(Color.black);
		btn0038111.setBackground(new Color(0xc6c6c6));
	btn0038111.setBounds (349, 377 , 50, 18);

btn0038111.setFont (new Font ("Helvetica", 0, 12));

 	btn0038111.setBorderPainted (true);
	btn0038111.setDataSourceName("");
	btn0038111.setTabOrder(384);
        
      // container is form
add (btn0038111,null);             
	} // end of initVSButtonbtn0038111
	
	
	
	
	
	
	 public void initVSButtonbtn0037111() {
	btn0037111.setText("003");
	btn0037111.setName ("btn0037111");
		btn0037111.setForeground(Color.black);
		btn0037111.setBackground(new Color(0xc6c6c6));
	btn0037111.setBounds (339, 367 , 50, 18);

btn0037111.setFont (new Font ("Helvetica", 0, 12));

 	btn0037111.setBorderPainted (true);
	btn0037111.setDataSourceName("");
	btn0037111.setTabOrder(383);
        
      // container is form
add (btn0037111,null);             
	} // end of initVSButtonbtn0037111
	
	
	
	
	
	
	 public void initVSButtonbtn0036111() {
	btn0036111.setText("003");
	btn0036111.setName ("btn0036111");
		btn0036111.setForeground(Color.black);
		btn0036111.setBackground(new Color(0xc6c6c6));
	btn0036111.setBounds (329, 357 , 50, 18);

btn0036111.setFont (new Font ("Helvetica", 0, 12));

 	btn0036111.setBorderPainted (true);
	btn0036111.setDataSourceName("");
	btn0036111.setTabOrder(382);
        
      // container is form
add (btn0036111,null);             
	} // end of initVSButtonbtn0036111
	
	
	
	
	
	
	 public void initVSButtonbtn0035111() {
	btn0035111.setText("003");
	btn0035111.setName ("btn0035111");
		btn0035111.setForeground(Color.black);
		btn0035111.setBackground(new Color(0xc6c6c6));
	btn0035111.setBounds (319, 347 , 50, 18);

btn0035111.setFont (new Font ("Helvetica", 0, 12));

 	btn0035111.setBorderPainted (true);
	btn0035111.setDataSourceName("");
	btn0035111.setTabOrder(381);
        
      // container is form
add (btn0035111,null);             
	} // end of initVSButtonbtn0035111
	
	
	
	
	
	
	 public void initVSButtonbtn0034111() {
	btn0034111.setText("003");
	btn0034111.setName ("btn0034111");
		btn0034111.setForeground(Color.black);
		btn0034111.setBackground(new Color(0xc6c6c6));
	btn0034111.setBounds (309, 337 , 50, 18);

btn0034111.setFont (new Font ("Helvetica", 0, 12));

 	btn0034111.setBorderPainted (true);
	btn0034111.setDataSourceName("");
	btn0034111.setTabOrder(380);
        
      // container is form
add (btn0034111,null);             
	} // end of initVSButtonbtn0034111
	
	
	
	
	
	
	 public void initVSButtonbtn0033121() {
	btn0033121.setText("003");
	btn0033121.setName ("btn0033121");
		btn0033121.setForeground(Color.black);
		btn0033121.setBackground(new Color(0xc6c6c6));
	btn0033121.setBounds (299, 327 , 50, 18);

btn0033121.setFont (new Font ("Helvetica", 0, 12));

 	btn0033121.setBorderPainted (true);
	btn0033121.setDataSourceName("");
	btn0033121.setTabOrder(379);
        
      // container is form
add (btn0033121,null);             
	} // end of initVSButtonbtn0033121
	
	
	
	
	
	
	 public void initVSButtonbtn0032131() {
	btn0032131.setText("003");
	btn0032131.setName ("btn0032131");
		btn0032131.setForeground(Color.black);
		btn0032131.setBackground(new Color(0xc6c6c6));
	btn0032131.setBounds (289, 317 , 50, 18);

btn0032131.setFont (new Font ("Helvetica", 0, 12));

 	btn0032131.setBorderPainted (true);
	btn0032131.setDataSourceName("");
	btn0032131.setTabOrder(378);
        
      // container is form
add (btn0032131,null);             
	} // end of initVSButtonbtn0032131
	
	
	
	
	
	
	 public void initVSButtonbtn0031231() {
	btn0031231.setText("003");
	btn0031231.setName ("btn0031231");
		btn0031231.setForeground(Color.black);
		btn0031231.setBackground(new Color(0xc6c6c6));
	btn0031231.setBounds (279, 307 , 50, 18);

btn0031231.setFont (new Font ("Helvetica", 0, 12));

 	btn0031231.setBorderPainted (true);
	btn0031231.setDataSourceName("");
	btn0031231.setTabOrder(377);
        
      // container is form
add (btn0031231,null);             
	} // end of initVSButtonbtn0031231
	
	
	
	
	
	
	 public void initVSButtonbtn003501() {
	btn003501.setText("003");
	btn003501.setName ("btn003501");
		btn003501.setForeground(Color.black);
		btn003501.setBackground(new Color(0xc6c6c6));
	btn003501.setBounds (269, 297 , 50, 18);

btn003501.setFont (new Font ("Helvetica", 0, 12));

 	btn003501.setBorderPainted (true);
	btn003501.setDataSourceName("");
	btn003501.setTabOrder(376);
        
      // container is form
add (btn003501,null);             
	} // end of initVSButtonbtn003501
	
	
	
	
	
	
	 public void initVSButtonbtn002111() {
	btn002111.setText("002");
	btn002111.setName ("btn002111");
		btn002111.setForeground(Color.black);
		btn002111.setBackground(new Color(0xc6c6c6));
	btn002111.setBounds (264, 280 , 50, 18);

btn002111.setFont (new Font ("Helvetica", 0, 12));

 	btn002111.setBorderPainted (true);
	btn002111.setDataSourceName("");
	btn002111.setTabOrder(375);
        
      // container is form
add (btn002111,null);             
	} // end of initVSButtonbtn002111
	
	
	
	
	
	
	 public void initVSButtonbtn00311131() {
	btn00311131.setText("003");
	btn00311131.setName ("btn00311131");
		btn00311131.setForeground(Color.black);
		btn00311131.setBackground(new Color(0xc6c6c6));
	btn00311131.setBounds (389, 380 , 50, 18);

btn00311131.setFont (new Font ("Helvetica", 0, 12));

 	btn00311131.setBorderPainted (true);
	btn00311131.setDataSourceName("");
	btn00311131.setTabOrder(374);
        
      // container is form
add (btn00311131,null);             
	} // end of initVSButtonbtn00311131
	
	
	
	
	
	
	 public void initVSButtonbtn00310101() {
	btn00310101.setText("003");
	btn00310101.setName ("btn00310101");
		btn00310101.setForeground(Color.black);
		btn00310101.setBackground(new Color(0xc6c6c6));
	btn00310101.setBounds (379, 370 , 50, 18);

btn00310101.setFont (new Font ("Helvetica", 0, 12));

 	btn00310101.setBorderPainted (true);
	btn00310101.setDataSourceName("");
	btn00310101.setTabOrder(373);
        
      // container is form
add (btn00310101,null);             
	} // end of initVSButtonbtn00310101
	
	
	
	
	
	
	 public void initVSButtonbtn0039101() {
	btn0039101.setText("003");
	btn0039101.setName ("btn0039101");
		btn0039101.setForeground(Color.black);
		btn0039101.setBackground(new Color(0xc6c6c6));
	btn0039101.setBounds (369, 360 , 50, 18);

btn0039101.setFont (new Font ("Helvetica", 0, 12));

 	btn0039101.setBorderPainted (true);
	btn0039101.setDataSourceName("");
	btn0039101.setTabOrder(372);
        
      // container is form
add (btn0039101,null);             
	} // end of initVSButtonbtn0039101
	
	
	
	
	
	
	 public void initVSButtonbtn0038101() {
	btn0038101.setText("003");
	btn0038101.setName ("btn0038101");
		btn0038101.setForeground(Color.black);
		btn0038101.setBackground(new Color(0xc6c6c6));
	btn0038101.setBounds (359, 350 , 50, 18);

btn0038101.setFont (new Font ("Helvetica", 0, 12));

 	btn0038101.setBorderPainted (true);
	btn0038101.setDataSourceName("");
	btn0038101.setTabOrder(371);
        
      // container is form
add (btn0038101,null);             
	} // end of initVSButtonbtn0038101
	
	
	
	
	
	
	 public void initVSButtonbtn0037101() {
	btn0037101.setText("003");
	btn0037101.setName ("btn0037101");
		btn0037101.setForeground(Color.black);
		btn0037101.setBackground(new Color(0xc6c6c6));
	btn0037101.setBounds (349, 340 , 50, 18);

btn0037101.setFont (new Font ("Helvetica", 0, 12));

 	btn0037101.setBorderPainted (true);
	btn0037101.setDataSourceName("");
	btn0037101.setTabOrder(370);
        
      // container is form
add (btn0037101,null);             
	} // end of initVSButtonbtn0037101
	
	
	
	
	
	
	 public void initVSButtonbtn0036101() {
	btn0036101.setText("003");
	btn0036101.setName ("btn0036101");
		btn0036101.setForeground(Color.black);
		btn0036101.setBackground(new Color(0xc6c6c6));
	btn0036101.setBounds (339, 330 , 50, 18);

btn0036101.setFont (new Font ("Helvetica", 0, 12));

 	btn0036101.setBorderPainted (true);
	btn0036101.setDataSourceName("");
	btn0036101.setTabOrder(369);
        
      // container is form
add (btn0036101,null);             
	} // end of initVSButtonbtn0036101
	
	
	
	
	
	
	 public void initVSButtonbtn0035101() {
	btn0035101.setText("003");
	btn0035101.setName ("btn0035101");
		btn0035101.setForeground(Color.black);
		btn0035101.setBackground(new Color(0xc6c6c6));
	btn0035101.setBounds (329, 320 , 50, 18);

btn0035101.setFont (new Font ("Helvetica", 0, 12));

 	btn0035101.setBorderPainted (true);
	btn0035101.setDataSourceName("");
	btn0035101.setTabOrder(368);
        
      // container is form
add (btn0035101,null);             
	} // end of initVSButtonbtn0035101
	
	
	
	
	
	
	 public void initVSButtonbtn0034101() {
	btn0034101.setText("003");
	btn0034101.setName ("btn0034101");
		btn0034101.setForeground(Color.black);
		btn0034101.setBackground(new Color(0xc6c6c6));
	btn0034101.setBounds (319, 310 , 50, 18);

btn0034101.setFont (new Font ("Helvetica", 0, 12));

 	btn0034101.setBorderPainted (true);
	btn0034101.setDataSourceName("");
	btn0034101.setTabOrder(367);
        
      // container is form
add (btn0034101,null);             
	} // end of initVSButtonbtn0034101
	
	
	
	
	
	
	 public void initVSButtonbtn0033111() {
	btn0033111.setText("003");
	btn0033111.setName ("btn0033111");
		btn0033111.setForeground(Color.black);
		btn0033111.setBackground(new Color(0xc6c6c6));
	btn0033111.setBounds (309, 300 , 50, 18);

btn0033111.setFont (new Font ("Helvetica", 0, 12));

 	btn0033111.setBorderPainted (true);
	btn0033111.setDataSourceName("");
	btn0033111.setTabOrder(366);
        
      // container is form
add (btn0033111,null);             
	} // end of initVSButtonbtn0033111
	
	
	
	
	
	
	 public void initVSButtonbtn0032121() {
	btn0032121.setText("003");
	btn0032121.setName ("btn0032121");
		btn0032121.setForeground(Color.black);
		btn0032121.setBackground(new Color(0xc6c6c6));
	btn0032121.setBounds (299, 290 , 50, 18);

btn0032121.setFont (new Font ("Helvetica", 0, 12));

 	btn0032121.setBorderPainted (true);
	btn0032121.setDataSourceName("");
	btn0032121.setTabOrder(365);
        
      // container is form
add (btn0032121,null);             
	} // end of initVSButtonbtn0032121
	
	
	
	
	
	
	 public void initVSButtonbtn0031221() {
	btn0031221.setText("003");
	btn0031221.setName ("btn0031221");
		btn0031221.setForeground(Color.black);
		btn0031221.setBackground(new Color(0xc6c6c6));
	btn0031221.setBounds (289, 280 , 50, 18);

btn0031221.setFont (new Font ("Helvetica", 0, 12));

 	btn0031221.setBorderPainted (true);
	btn0031221.setDataSourceName("");
	btn0031221.setTabOrder(364);
        
      // container is form
add (btn0031221,null);             
	} // end of initVSButtonbtn0031221
	
	
	
	
	
	
	 public void initVSButtonbtn003401() {
	btn003401.setText("003");
	btn003401.setName ("btn003401");
		btn003401.setForeground(Color.black);
		btn003401.setBackground(new Color(0xc6c6c6));
	btn003401.setBounds (279, 270 , 50, 18);

btn003401.setFont (new Font ("Helvetica", 0, 12));

 	btn003401.setBorderPainted (true);
	btn003401.setDataSourceName("");
	btn003401.setTabOrder(363);
        
      // container is form
add (btn003401,null);             
	} // end of initVSButtonbtn003401
	
	
	
	
	
	
	 public void initVSButtonbtn002101() {
	btn002101.setText("002");
	btn002101.setName ("btn002101");
		btn002101.setForeground(Color.black);
		btn002101.setBackground(new Color(0xc6c6c6));
	btn002101.setBounds (274, 253 , 50, 18);

btn002101.setFont (new Font ("Helvetica", 0, 12));

 	btn002101.setBorderPainted (true);
	btn002101.setDataSourceName("");
	btn002101.setTabOrder(362);
        
      // container is form
add (btn002101,null);             
	} // end of initVSButtonbtn002101
	
	
	
	
	
	
	 public void initVSButtonbtn0031061() {
	btn0031061.setText("003");
	btn0031061.setName ("btn0031061");
		btn0031061.setForeground(Color.black);
		btn0031061.setBackground(new Color(0xc6c6c6));
	btn0031061.setBounds (450, 317 , 50, 18);

btn0031061.setFont (new Font ("Helvetica", 0, 12));

 	btn0031061.setBorderPainted (true);
	btn0031061.setDataSourceName("");
	btn0031061.setTabOrder(361);
        
      // container is form
add (btn0031061,null);             
	} // end of initVSButtonbtn0031061
	
	
	
	
	
	
	 public void initVSButtonbtn003961() {
	btn003961.setText("003");
	btn003961.setName ("btn003961");
		btn003961.setForeground(Color.black);
		btn003961.setBackground(new Color(0xc6c6c6));
	btn003961.setBounds (440, 307 , 50, 18);

btn003961.setFont (new Font ("Helvetica", 0, 12));

 	btn003961.setBorderPainted (true);
	btn003961.setDataSourceName("");
	btn003961.setTabOrder(360);
        
      // container is form
add (btn003961,null);             
	} // end of initVSButtonbtn003961
	
	
	
	
	
	
	 public void initVSButtonbtn003861() {
	btn003861.setText("003");
	btn003861.setName ("btn003861");
		btn003861.setForeground(Color.black);
		btn003861.setBackground(new Color(0xc6c6c6));
	btn003861.setBounds (430, 297 , 50, 18);

btn003861.setFont (new Font ("Helvetica", 0, 12));

 	btn003861.setBorderPainted (true);
	btn003861.setDataSourceName("");
	btn003861.setTabOrder(359);
        
      // container is form
add (btn003861,null);             
	} // end of initVSButtonbtn003861
	
	
	
	
	
	
	 public void initVSButtonbtn003761() {
	btn003761.setText("003");
	btn003761.setName ("btn003761");
		btn003761.setForeground(Color.black);
		btn003761.setBackground(new Color(0xc6c6c6));
	btn003761.setBounds (420, 287 , 50, 18);

btn003761.setFont (new Font ("Helvetica", 0, 12));

 	btn003761.setBorderPainted (true);
	btn003761.setDataSourceName("");
	btn003761.setTabOrder(358);
        
      // container is form
add (btn003761,null);             
	} // end of initVSButtonbtn003761
	
	
	
	
	
	
	 public void initVSButtonbtn003661() {
	btn003661.setText("003");
	btn003661.setName ("btn003661");
		btn003661.setForeground(Color.black);
		btn003661.setBackground(new Color(0xc6c6c6));
	btn003661.setBounds (410, 277 , 50, 18);

btn003661.setFont (new Font ("Helvetica", 0, 12));

 	btn003661.setBorderPainted (true);
	btn003661.setDataSourceName("");
	btn003661.setTabOrder(357);
        
      // container is form
add (btn003661,null);             
	} // end of initVSButtonbtn003661
	
	
	
	
	
	
	 public void initVSButtonbtn003561() {
	btn003561.setText("003");
	btn003561.setName ("btn003561");
		btn003561.setForeground(Color.black);
		btn003561.setBackground(new Color(0xc6c6c6));
	btn003561.setBounds (400, 267 , 50, 18);

btn003561.setFont (new Font ("Helvetica", 0, 12));

 	btn003561.setBorderPainted (true);
	btn003561.setDataSourceName("");
	btn003561.setTabOrder(356);
        
      // container is form
add (btn003561,null);             
	} // end of initVSButtonbtn003561
	
	
	
	
	
	
	 public void initVSButtonbtn003461() {
	btn003461.setText("003");
	btn003461.setName ("btn003461");
		btn003461.setForeground(Color.black);
		btn003461.setBackground(new Color(0xc6c6c6));
	btn003461.setBounds (390, 257 , 50, 18);

btn003461.setFont (new Font ("Helvetica", 0, 12));

 	btn003461.setBorderPainted (true);
	btn003461.setDataSourceName("");
	btn003461.setTabOrder(355);
        
      // container is form
add (btn003461,null);             
	} // end of initVSButtonbtn003461
	
	
	
	
	
	
	 public void initVSButtonbtn003361() {
	btn003361.setText("003");
	btn003361.setName ("btn003361");
		btn003361.setForeground(Color.black);
		btn003361.setBackground(new Color(0xc6c6c6));
	btn003361.setBounds (380, 247 , 50, 18);

btn003361.setFont (new Font ("Helvetica", 0, 12));

 	btn003361.setBorderPainted (true);
	btn003361.setDataSourceName("");
	btn003361.setTabOrder(354);
        
      // container is form
add (btn003361,null);             
	} // end of initVSButtonbtn003361
	
	
	
	
	
	
	 public void initVSButtonbtn003271() {
	btn003271.setText("003");
	btn003271.setName ("btn003271");
		btn003271.setForeground(Color.black);
		btn003271.setBackground(new Color(0xc6c6c6));
	btn003271.setBounds (370, 237 , 50, 18);

btn003271.setFont (new Font ("Helvetica", 0, 12));

 	btn003271.setBorderPainted (true);
	btn003271.setDataSourceName("");
	btn003271.setTabOrder(353);
        
      // container is form
add (btn003271,null);             
	} // end of initVSButtonbtn003271
	
	
	
	
	
	
	 public void initVSButtonbtn0031171() {
	btn0031171.setText("003");
	btn0031171.setName ("btn0031171");
		btn0031171.setForeground(Color.black);
		btn0031171.setBackground(new Color(0xc6c6c6));
	btn0031171.setBounds (360, 227 , 50, 18);

btn0031171.setFont (new Font ("Helvetica", 0, 12));

 	btn0031171.setBorderPainted (true);
	btn0031171.setDataSourceName("");
	btn0031171.setTabOrder(352);
        
      // container is form
add (btn0031171,null);             
	} // end of initVSButtonbtn0031171
	
	
	
	
	
	
	 public void initVSButtonbtn003261() {
	btn003261.setText("003");
	btn003261.setName ("btn003261");
		btn003261.setForeground(Color.black);
		btn003261.setBackground(new Color(0xc6c6c6));
	btn003261.setBounds (350, 217 , 50, 18);

btn003261.setFont (new Font ("Helvetica", 0, 12));

 	btn003261.setBorderPainted (true);
	btn003261.setDataSourceName("");
	btn003261.setTabOrder(351);
        
      // container is form
add (btn003261,null);             
	} // end of initVSButtonbtn003261
	
	
	
	
	
	
	 public void initVSButtonbtn00261() {
	btn00261.setText("002");
	btn00261.setName ("btn00261");
		btn00261.setForeground(Color.black);
		btn00261.setBackground(new Color(0xc6c6c6));
	btn00261.setBounds (345, 200 , 50, 18);

btn00261.setFont (new Font ("Helvetica", 0, 12));

 	btn00261.setBorderPainted (true);
	btn00261.setDataSourceName("");
	btn00261.setTabOrder(350);
        
      // container is form
add (btn00261,null);             
	} // end of initVSButtonbtn00261
	
	
	
	
	
	
	 public void initVSButtonbtn00161() {
	btn00161.setText("001");
	btn00161.setName ("btn00161");
		btn00161.setForeground(Color.black);
		btn00161.setBackground(new Color(0xc6c6c6));
	btn00161.setBounds (327, 183 , 50, 18);

btn00161.setFont (new Font ("Helvetica", 0, 12));

 	btn00161.setBorderPainted (true);
	btn00161.setDataSourceName("");
	btn00161.setTabOrder(349);
        
      // container is form
add (btn00161,null);             
	} // end of initVSButtonbtn00161
	
	
	
	
	
	
	 public void initVSButtonbtn0031161() {
	btn0031161.setText("003");
	btn0031161.setName ("btn0031161");
		btn0031161.setForeground(Color.black);
		btn0031161.setBackground(new Color(0xc6c6c6));
	btn0031161.setBounds (397, 355 , 50, 18);

btn0031161.setFont (new Font ("Helvetica", 0, 12));

 	btn0031161.setBorderPainted (true);
	btn0031161.setDataSourceName("");
	btn0031161.setTabOrder(348);
        
      // container is form
add (btn0031161,null);             
	} // end of initVSButtonbtn0031161
	
	
	
	
	
	
	 public void initVSButtonbtn0031051() {
	btn0031051.setText("003");
	btn0031051.setName ("btn0031051");
		btn0031051.setForeground(Color.black);
		btn0031051.setBackground(new Color(0xc6c6c6));
	btn0031051.setBounds (387, 345 , 50, 18);

btn0031051.setFont (new Font ("Helvetica", 0, 12));

 	btn0031051.setBorderPainted (true);
	btn0031051.setDataSourceName("");
	btn0031051.setTabOrder(347);
        
      // container is form
add (btn0031051,null);             
	} // end of initVSButtonbtn0031051
	
	
	
	
	
	
	 public void initVSButtonbtn003951() {
	btn003951.setText("003");
	btn003951.setName ("btn003951");
		btn003951.setForeground(Color.black);
		btn003951.setBackground(new Color(0xc6c6c6));
	btn003951.setBounds (377, 335 , 50, 18);

btn003951.setFont (new Font ("Helvetica", 0, 12));

 	btn003951.setBorderPainted (true);
	btn003951.setDataSourceName("");
	btn003951.setTabOrder(346);
        
      // container is form
add (btn003951,null);             
	} // end of initVSButtonbtn003951
	
	
	
	
	
	
	 public void initVSButtonbtn003851() {
	btn003851.setText("003");
	btn003851.setName ("btn003851");
		btn003851.setForeground(Color.black);
		btn003851.setBackground(new Color(0xc6c6c6));
	btn003851.setBounds (367, 325 , 50, 18);

btn003851.setFont (new Font ("Helvetica", 0, 12));

 	btn003851.setBorderPainted (true);
	btn003851.setDataSourceName("");
	btn003851.setTabOrder(345);
        
      // container is form
add (btn003851,null);             
	} // end of initVSButtonbtn003851
	
	
	
	
	
	
	 public void initVSButtonbtn003751() {
	btn003751.setText("003");
	btn003751.setName ("btn003751");
		btn003751.setForeground(Color.black);
		btn003751.setBackground(new Color(0xc6c6c6));
	btn003751.setBounds (357, 315 , 50, 18);

btn003751.setFont (new Font ("Helvetica", 0, 12));

 	btn003751.setBorderPainted (true);
	btn003751.setDataSourceName("");
	btn003751.setTabOrder(344);
        
      // container is form
add (btn003751,null);             
	} // end of initVSButtonbtn003751
	
	
	
	
	
	
	 public void initVSButtonbtn003651() {
	btn003651.setText("003");
	btn003651.setName ("btn003651");
		btn003651.setForeground(Color.black);
		btn003651.setBackground(new Color(0xc6c6c6));
	btn003651.setBounds (347, 305 , 50, 18);

btn003651.setFont (new Font ("Helvetica", 0, 12));

 	btn003651.setBorderPainted (true);
	btn003651.setDataSourceName("");
	btn003651.setTabOrder(343);
        
      // container is form
add (btn003651,null);             
	} // end of initVSButtonbtn003651
	
	
	
	
	
	
	 public void initVSButtonbtn003551() {
	btn003551.setText("003");
	btn003551.setName ("btn003551");
		btn003551.setForeground(Color.black);
		btn003551.setBackground(new Color(0xc6c6c6));
	btn003551.setBounds (337, 295 , 50, 18);

btn003551.setFont (new Font ("Helvetica", 0, 12));

 	btn003551.setBorderPainted (true);
	btn003551.setDataSourceName("");
	btn003551.setTabOrder(342);
        
      // container is form
add (btn003551,null);             
	} // end of initVSButtonbtn003551
	
	
	
	
	
	
	 public void initVSButtonbtn003451() {
	btn003451.setText("003");
	btn003451.setName ("btn003451");
		btn003451.setForeground(Color.black);
		btn003451.setBackground(new Color(0xc6c6c6));
	btn003451.setBounds (327, 285 , 50, 18);

btn003451.setFont (new Font ("Helvetica", 0, 12));

 	btn003451.setBorderPainted (true);
	btn003451.setDataSourceName("");
	btn003451.setTabOrder(341);
        
      // container is form
add (btn003451,null);             
	} // end of initVSButtonbtn003451
	
	
	
	
	
	
	 public void initVSButtonbtn003351() {
	btn003351.setText("003");
	btn003351.setName ("btn003351");
		btn003351.setForeground(Color.black);
		btn003351.setBackground(new Color(0xc6c6c6));
	btn003351.setBounds (317, 275 , 50, 18);

btn003351.setFont (new Font ("Helvetica", 0, 12));

 	btn003351.setBorderPainted (true);
	btn003351.setDataSourceName("");
	btn003351.setTabOrder(340);
        
      // container is form
add (btn003351,null);             
	} // end of initVSButtonbtn003351
	
	
	
	
	
	
	 public void initVSButtonbtn003251() {
	btn003251.setText("003");
	btn003251.setName ("btn003251");
		btn003251.setForeground(Color.black);
		btn003251.setBackground(new Color(0xc6c6c6));
	btn003251.setBounds (307, 265 , 50, 18);

btn003251.setFont (new Font ("Helvetica", 0, 12));

 	btn003251.setBorderPainted (true);
	btn003251.setDataSourceName("");
	btn003251.setTabOrder(339);
        
      // container is form
add (btn003251,null);             
	} // end of initVSButtonbtn003251
	
	
	
	
	
	
	 public void initVSButtonbtn0031151() {
	btn0031151.setText("003");
	btn0031151.setName ("btn0031151");
		btn0031151.setForeground(Color.black);
		btn0031151.setBackground(new Color(0xc6c6c6));
	btn0031151.setBounds (297, 255 , 50, 18);

btn0031151.setFont (new Font ("Helvetica", 0, 12));

 	btn0031151.setBorderPainted (true);
	btn0031151.setDataSourceName("");
	btn0031151.setTabOrder(338);
        
      // container is form
add (btn0031151,null);             
	} // end of initVSButtonbtn0031151
	
	
	
	
	
	
	 public void initVSButtonbtn003201() {
	btn003201.setText("003");
	btn003201.setName ("btn003201");
		btn003201.setForeground(Color.black);
		btn003201.setBackground(new Color(0xc6c6c6));
	btn003201.setBounds (287, 245 , 50, 18);

btn003201.setFont (new Font ("Helvetica", 0, 12));

 	btn003201.setBorderPainted (true);
	btn003201.setDataSourceName("");
	btn003201.setTabOrder(337);
        
      // container is form
add (btn003201,null);             
	} // end of initVSButtonbtn003201
	
	
	
	
	
	
	 public void initVSButtonbtn00251() {
	btn00251.setText("002");
	btn00251.setName ("btn00251");
		btn00251.setForeground(Color.black);
		btn00251.setBackground(new Color(0xc6c6c6));
	btn00251.setBounds (282, 228 , 50, 18);

btn00251.setFont (new Font ("Helvetica", 0, 12));

 	btn00251.setBorderPainted (true);
	btn00251.setDataSourceName("");
	btn00251.setTabOrder(336);
        
      // container is form
add (btn00251,null);             
	} // end of initVSButtonbtn00251
	
	
	
	
	
	
	 public void initVSButtonbtn00151() {
	btn00151.setText("001");
	btn00151.setName ("btn00151");
		btn00151.setForeground(Color.black);
		btn00151.setBackground(new Color(0xc6c6c6));
	btn00151.setBounds (264, 211 , 50, 18);

btn00151.setFont (new Font ("Helvetica", 0, 12));

 	btn00151.setBorderPainted (true);
	btn00151.setDataSourceName("");
	btn00151.setTabOrder(335);
        
      // container is form
add (btn00151,null);             
	} // end of initVSButtonbtn00151
	
	
	
	
	
	
	 public void initVSButtonbtn003151() {
	btn003151.setText("003");
	btn003151.setName ("btn003151");
		btn003151.setForeground(Color.black);
		btn003151.setBackground(new Color(0xc6c6c6));
	btn003151.setBounds (452, 206 , 50, 18);

btn003151.setFont (new Font ("Helvetica", 0, 12));

 	btn003151.setBorderPainted (true);
	btn003151.setDataSourceName("");
	btn003151.setTabOrder(334);
        
      // container is form
add (btn003151,null);             
	} // end of initVSButtonbtn003151
	
	
	
	
	
	
	 public void initVSButtonbtn00223() {
	btn00223.setText("002");
	btn00223.setName ("btn00223");
		btn00223.setForeground(Color.black);
		btn00223.setBackground(new Color(0xc6c6c6));
	btn00223.setBounds (447, 189 , 50, 18);

btn00223.setFont (new Font ("Helvetica", 0, 12));

 	btn00223.setBorderPainted (true);
	btn00223.setDataSourceName("");
	btn00223.setTabOrder(333);
        
      // container is form
add (btn00223,null);             
	} // end of initVSButtonbtn00223
	
	
	
	
	
	
	 public void initVSButtonbtn00123() {
	btn00123.setText("001");
	btn00123.setName ("btn00123");
		btn00123.setForeground(Color.black);
		btn00123.setBackground(new Color(0xc6c6c6));
	btn00123.setBounds (429, 172 , 50, 18);

btn00123.setFont (new Font ("Helvetica", 0, 12));

 	btn00123.setBorderPainted (true);
	btn00123.setDataSourceName("");
	btn00123.setTabOrder(332);
        
      // container is form
add (btn00123,null);             
	} // end of initVSButtonbtn00123
	
	
	
	
	
	
	 public void initVSButtonbtn0035110() {
	btn0035110.setText("003");
	btn0035110.setName ("btn0035110");
		btn0035110.setForeground(Color.black);
		btn0035110.setBackground(new Color(0xc6c6c6));
	btn0035110.setBounds (444, 258 , 50, 18);

btn0035110.setFont (new Font ("Helvetica", 0, 12));

 	btn0035110.setBorderPainted (true);
	btn0035110.setDataSourceName("");
	btn0035110.setTabOrder(331);
        
      // container is form
add (btn0035110,null);             
	} // end of initVSButtonbtn0035110
	
	
	
	
	
	
	 public void initVSButtonbtn0034110() {
	btn0034110.setText("003");
	btn0034110.setName ("btn0034110");
		btn0034110.setForeground(Color.black);
		btn0034110.setBackground(new Color(0xc6c6c6));
	btn0034110.setBounds (434, 248 , 50, 18);

btn0034110.setFont (new Font ("Helvetica", 0, 12));

 	btn0034110.setBorderPainted (true);
	btn0034110.setDataSourceName("");
	btn0034110.setTabOrder(330);
        
      // container is form
add (btn0034110,null);             
	} // end of initVSButtonbtn0034110
	
	
	
	
	
	
	 public void initVSButtonbtn0033110() {
	btn0033110.setText("003");
	btn0033110.setName ("btn0033110");
		btn0033110.setForeground(Color.black);
		btn0033110.setBackground(new Color(0xc6c6c6));
	btn0033110.setBounds (424, 238 , 50, 18);

btn0033110.setFont (new Font ("Helvetica", 0, 12));

 	btn0033110.setBorderPainted (true);
	btn0033110.setDataSourceName("");
	btn0033110.setTabOrder(329);
        
      // container is form
add (btn0033110,null);             
	} // end of initVSButtonbtn0033110
	
	
	
	
	
	
	 public void initVSButtonbtn0032110() {
	btn0032110.setText("003");
	btn0032110.setName ("btn0032110");
		btn0032110.setForeground(Color.black);
		btn0032110.setBackground(new Color(0xc6c6c6));
	btn0032110.setBounds (414, 228 , 50, 18);

btn0032110.setFont (new Font ("Helvetica", 0, 12));

 	btn0032110.setBorderPainted (true);
	btn0032110.setDataSourceName("");
	btn0032110.setTabOrder(328);
        
      // container is form
add (btn0032110,null);             
	} // end of initVSButtonbtn0032110
	
	
	
	
	
	
	 public void initVSButtonbtn003141() {
	btn003141.setText("003");
	btn003141.setName ("btn003141");
		btn003141.setForeground(Color.black);
		btn003141.setBackground(new Color(0xc6c6c6));
	btn003141.setBounds (404, 218 , 50, 18);

btn003141.setFont (new Font ("Helvetica", 0, 12));

 	btn003141.setBorderPainted (true);
	btn003141.setDataSourceName("");
	btn003141.setTabOrder(327);
        
      // container is form
add (btn003141,null);             
	} // end of initVSButtonbtn003141
	
	
	
	
	
	
	 public void initVSButtonbtn0031310() {
	btn0031310.setText("003");
	btn0031310.setName ("btn0031310");
		btn0031310.setForeground(Color.black);
		btn0031310.setBackground(new Color(0xc6c6c6));
	btn0031310.setBounds (394, 208 , 50, 18);

btn0031310.setFont (new Font ("Helvetica", 0, 12));

 	btn0031310.setBorderPainted (true);
	btn0031310.setDataSourceName("");
	btn0031310.setTabOrder(326);
        
      // container is form
add (btn0031310,null);             
	} // end of initVSButtonbtn0031310
	
	
	
	
	
	
	 public void initVSButtonbtn002110() {
	btn002110.setText("002");
	btn002110.setName ("btn002110");
		btn002110.setForeground(Color.black);
		btn002110.setBackground(new Color(0xc6c6c6));
	btn002110.setBounds (389, 191 , 50, 18);

btn002110.setFont (new Font ("Helvetica", 0, 12));

 	btn002110.setBorderPainted (true);
	btn002110.setDataSourceName("");
	btn002110.setTabOrder(325);
        
      // container is form
add (btn002110,null);             
	} // end of initVSButtonbtn002110
	
	
	
	
	
	
	 public void initVSButtonbtn001110() {
	btn001110.setText("001");
	btn001110.setName ("btn001110");
		btn001110.setForeground(Color.black);
		btn001110.setBackground(new Color(0xc6c6c6));
	btn001110.setBounds (371, 174 , 50, 18);

btn001110.setFont (new Font ("Helvetica", 0, 12));

 	btn001110.setBorderPainted (true);
	btn001110.setDataSourceName("");
	btn001110.setTabOrder(324);
        
      // container is form
add (btn001110,null);             
	} // end of initVSButtonbtn001110
	
	
	
	
	
	
	 public void initVSButtonbtn0031210() {
	btn0031210.setText("003");
	btn0031210.setName ("btn0031210");
		btn0031210.setForeground(Color.black);
		btn0031210.setBackground(new Color(0xc6c6c6));
	btn0031210.setBounds (431, 342 , 50, 18);

btn0031210.setFont (new Font ("Helvetica", 0, 12));

 	btn0031210.setBorderPainted (true);
	btn0031210.setDataSourceName("");
	btn0031210.setTabOrder(323);
        
      // container is form
add (btn0031210,null);             
	} // end of initVSButtonbtn0031210
	
	
	
	
	
	
	 public void initVSButtonbtn0031125() {
	btn0031125.setText("003");
	btn0031125.setName ("btn0031125");
		btn0031125.setForeground(Color.black);
		btn0031125.setBackground(new Color(0xc6c6c6));
	btn0031125.setBounds (421, 332 , 50, 18);

btn0031125.setFont (new Font ("Helvetica", 0, 12));

 	btn0031125.setBorderPainted (true);
	btn0031125.setDataSourceName("");
	btn0031125.setTabOrder(322);
        
      // container is form
add (btn0031125,null);             
	} // end of initVSButtonbtn0031125
	
	
	
	
	
	
	 public void initVSButtonbtn0031022() {
	btn0031022.setText("003");
	btn0031022.setName ("btn0031022");
		btn0031022.setForeground(Color.black);
		btn0031022.setBackground(new Color(0xc6c6c6));
	btn0031022.setBounds (411, 322 , 50, 18);

btn0031022.setFont (new Font ("Helvetica", 0, 12));

 	btn0031022.setBorderPainted (true);
	btn0031022.setDataSourceName("");
	btn0031022.setTabOrder(321);
        
      // container is form
add (btn0031022,null);             
	} // end of initVSButtonbtn0031022
	
	
	
	
	
	
	 public void initVSButtonbtn003922() {
	btn003922.setText("003");
	btn003922.setName ("btn003922");
		btn003922.setForeground(Color.black);
		btn003922.setBackground(new Color(0xc6c6c6));
	btn003922.setBounds (401, 312 , 50, 18);

btn003922.setFont (new Font ("Helvetica", 0, 12));

 	btn003922.setBorderPainted (true);
	btn003922.setDataSourceName("");
	btn003922.setTabOrder(320);
        
      // container is form
add (btn003922,null);             
	} // end of initVSButtonbtn003922
	
	
	
	
	
	
	 public void initVSButtonbtn003822() {
	btn003822.setText("003");
	btn003822.setName ("btn003822");
		btn003822.setForeground(Color.black);
		btn003822.setBackground(new Color(0xc6c6c6));
	btn003822.setBounds (391, 302 , 50, 18);

btn003822.setFont (new Font ("Helvetica", 0, 12));

 	btn003822.setBorderPainted (true);
	btn003822.setDataSourceName("");
	btn003822.setTabOrder(319);
        
      // container is form
add (btn003822,null);             
	} // end of initVSButtonbtn003822
	
	
	
	
	
	
	 public void initVSButtonbtn003722() {
	btn003722.setText("003");
	btn003722.setName ("btn003722");
		btn003722.setForeground(Color.black);
		btn003722.setBackground(new Color(0xc6c6c6));
	btn003722.setBounds (381, 292 , 50, 18);

btn003722.setFont (new Font ("Helvetica", 0, 12));

 	btn003722.setBorderPainted (true);
	btn003722.setDataSourceName("");
	btn003722.setTabOrder(318);
        
      // container is form
add (btn003722,null);             
	} // end of initVSButtonbtn003722
	
	
	
	
	
	
	 public void initVSButtonbtn003622() {
	btn003622.setText("003");
	btn003622.setName ("btn003622");
		btn003622.setForeground(Color.black);
		btn003622.setBackground(new Color(0xc6c6c6));
	btn003622.setBounds (371, 282 , 50, 18);

btn003622.setFont (new Font ("Helvetica", 0, 12));

 	btn003622.setBorderPainted (true);
	btn003622.setDataSourceName("");
	btn003622.setTabOrder(317);
        
      // container is form
add (btn003622,null);             
	} // end of initVSButtonbtn003622
	
	
	
	
	
	
	 public void initVSButtonbtn003522() {
	btn003522.setText("003");
	btn003522.setName ("btn003522");
		btn003522.setForeground(Color.black);
		btn003522.setBackground(new Color(0xc6c6c6));
	btn003522.setBounds (361, 272 , 50, 18);

btn003522.setFont (new Font ("Helvetica", 0, 12));

 	btn003522.setBorderPainted (true);
	btn003522.setDataSourceName("");
	btn003522.setTabOrder(316);
        
      // container is form
add (btn003522,null);             
	} // end of initVSButtonbtn003522
	
	
	
	
	
	
	 public void initVSButtonbtn003422() {
	btn003422.setText("003");
	btn003422.setName ("btn003422");
		btn003422.setForeground(Color.black);
		btn003422.setBackground(new Color(0xc6c6c6));
	btn003422.setBounds (351, 262 , 50, 18);

btn003422.setFont (new Font ("Helvetica", 0, 12));

 	btn003422.setBorderPainted (true);
	btn003422.setDataSourceName("");
	btn003422.setTabOrder(315);
        
      // container is form
add (btn003422,null);             
	} // end of initVSButtonbtn003422
	
	
	
	
	
	
	 public void initVSButtonbtn003323() {
	btn003323.setText("003");
	btn003323.setName ("btn003323");
		btn003323.setForeground(Color.black);
		btn003323.setBackground(new Color(0xc6c6c6));
	btn003323.setBounds (341, 252 , 50, 18);

btn003323.setFont (new Font ("Helvetica", 0, 12));

 	btn003323.setBorderPainted (true);
	btn003323.setDataSourceName("");
	btn003323.setTabOrder(314);
        
      // container is form
add (btn003323,null);             
	} // end of initVSButtonbtn003323
	
	
	
	
	
	
	 public void initVSButtonbtn003224() {
	btn003224.setText("003");
	btn003224.setName ("btn003224");
		btn003224.setForeground(Color.black);
		btn003224.setBackground(new Color(0xc6c6c6));
	btn003224.setBounds (331, 242 , 50, 18);

btn003224.setFont (new Font ("Helvetica", 0, 12));

 	btn003224.setBorderPainted (true);
	btn003224.setDataSourceName("");
	btn003224.setTabOrder(313);
        
      // container is form
add (btn003224,null);             
	} // end of initVSButtonbtn003224
	
	
	
	
	
	
	 public void initVSButtonbtn003140() {
	btn003140.setText("003");
	btn003140.setName ("btn003140");
		btn003140.setForeground(Color.black);
		btn003140.setBackground(new Color(0xc6c6c6));
	btn003140.setBounds (321, 232 , 50, 18);

btn003140.setFont (new Font ("Helvetica", 0, 12));

 	btn003140.setBorderPainted (true);
	btn003140.setDataSourceName("");
	btn003140.setTabOrder(312);
        
      // container is form
add (btn003140,null);             
	} // end of initVSButtonbtn003140
	
	
	
	
	
	
	 public void initVSButtonbtn003139() {
	btn003139.setText("003");
	btn003139.setName ("btn003139");
		btn003139.setForeground(Color.black);
		btn003139.setBackground(new Color(0xc6c6c6));
	btn003139.setBounds (311, 222 , 50, 18);

btn003139.setFont (new Font ("Helvetica", 0, 12));

 	btn003139.setBorderPainted (true);
	btn003139.setDataSourceName("");
	btn003139.setTabOrder(311);
        
      // container is form
add (btn003139,null);             
	} // end of initVSButtonbtn003139
	
	
	
	
	
	
	 public void initVSButtonbtn00222() {
	btn00222.setText("002");
	btn00222.setName ("btn00222");
		btn00222.setForeground(Color.black);
		btn00222.setBackground(new Color(0xc6c6c6));
	btn00222.setBounds (306, 205 , 50, 18);

btn00222.setFont (new Font ("Helvetica", 0, 12));

 	btn00222.setBorderPainted (true);
	btn00222.setDataSourceName("");
	btn00222.setTabOrder(310);
        
      // container is form
add (btn00222,null);             
	} // end of initVSButtonbtn00222
	
	
	
	
	
	
	 public void initVSButtonbtn00122() {
	btn00122.setText("001");
	btn00122.setName ("btn00122");
		btn00122.setForeground(Color.black);
		btn00122.setBackground(new Color(0xc6c6c6));
	btn00122.setBounds (288, 188 , 50, 18);

btn00122.setFont (new Font ("Helvetica", 0, 12));

 	btn00122.setBorderPainted (true);
	btn00122.setDataSourceName("");
	btn00122.setTabOrder(309);
        
      // container is form
add (btn00122,null);             
	} // end of initVSButtonbtn00122
	
	
	
	
	
	
	 public void initVSButtonbtn0031124() {
	btn0031124.setText("003");
	btn0031124.setName ("btn0031124");
		btn0031124.setForeground(Color.black);
		btn0031124.setBackground(new Color(0xc6c6c6));
	btn0031124.setBounds (279, 405 , 50, 18);

btn0031124.setFont (new Font ("Helvetica", 0, 12));

 	btn0031124.setBorderPainted (true);
	btn0031124.setDataSourceName("");
	btn0031124.setTabOrder(308);
        
      // container is form
add (btn0031124,null);             
	} // end of initVSButtonbtn0031124
	
	
	
	
	
	
	 public void initVSButtonbtn0031021() {
	btn0031021.setText("003");
	btn0031021.setName ("btn0031021");
		btn0031021.setForeground(Color.black);
		btn0031021.setBackground(new Color(0xc6c6c6));
	btn0031021.setBounds (269, 395 , 50, 18);

btn0031021.setFont (new Font ("Helvetica", 0, 12));

 	btn0031021.setBorderPainted (true);
	btn0031021.setDataSourceName("");
	btn0031021.setTabOrder(307);
        
      // container is form
add (btn0031021,null);             
	} // end of initVSButtonbtn0031021
	
	
	
	
	
	
	 public void initVSButtonbtn003921() {
	btn003921.setText("003");
	btn003921.setName ("btn003921");
		btn003921.setForeground(Color.black);
		btn003921.setBackground(new Color(0xc6c6c6));
	btn003921.setBounds (259, 385 , 50, 18);

btn003921.setFont (new Font ("Helvetica", 0, 12));

 	btn003921.setBorderPainted (true);
	btn003921.setDataSourceName("");
	btn003921.setTabOrder(306);
        
      // container is form
add (btn003921,null);             
	} // end of initVSButtonbtn003921
	
	
	
	
	
	
	 public void initVSButtonbtn003821() {
	btn003821.setText("003");
	btn003821.setName ("btn003821");
		btn003821.setForeground(Color.black);
		btn003821.setBackground(new Color(0xc6c6c6));
	btn003821.setBounds (249, 375 , 50, 18);

btn003821.setFont (new Font ("Helvetica", 0, 12));

 	btn003821.setBorderPainted (true);
	btn003821.setDataSourceName("");
	btn003821.setTabOrder(305);
        
      // container is form
add (btn003821,null);             
	} // end of initVSButtonbtn003821
	
	
	
	
	
	
	 public void initVSButtonbtn003721() {
	btn003721.setText("003");
	btn003721.setName ("btn003721");
		btn003721.setForeground(Color.black);
		btn003721.setBackground(new Color(0xc6c6c6));
	btn003721.setBounds (239, 365 , 50, 18);

btn003721.setFont (new Font ("Helvetica", 0, 12));

 	btn003721.setBorderPainted (true);
	btn003721.setDataSourceName("");
	btn003721.setTabOrder(304);
        
      // container is form
add (btn003721,null);             
	} // end of initVSButtonbtn003721
	
	
	
	
	
	
	 public void initVSButtonbtn003621() {
	btn003621.setText("003");
	btn003621.setName ("btn003621");
		btn003621.setForeground(Color.black);
		btn003621.setBackground(new Color(0xc6c6c6));
	btn003621.setBounds (229, 355 , 50, 18);

btn003621.setFont (new Font ("Helvetica", 0, 12));

 	btn003621.setBorderPainted (true);
	btn003621.setDataSourceName("");
	btn003621.setTabOrder(303);
        
      // container is form
add (btn003621,null);             
	} // end of initVSButtonbtn003621
	
	
	
	
	
	
	 public void initVSButtonbtn003521() {
	btn003521.setText("003");
	btn003521.setName ("btn003521");
		btn003521.setForeground(Color.black);
		btn003521.setBackground(new Color(0xc6c6c6));
	btn003521.setBounds (219, 345 , 50, 18);

btn003521.setFont (new Font ("Helvetica", 0, 12));

 	btn003521.setBorderPainted (true);
	btn003521.setDataSourceName("");
	btn003521.setTabOrder(302);
        
      // container is form
add (btn003521,null);             
	} // end of initVSButtonbtn003521
	
	
	
	
	
	
	 public void initVSButtonbtn003421() {
	btn003421.setText("003");
	btn003421.setName ("btn003421");
		btn003421.setForeground(Color.black);
		btn003421.setBackground(new Color(0xc6c6c6));
	btn003421.setBounds (209, 335 , 50, 18);

btn003421.setFont (new Font ("Helvetica", 0, 12));

 	btn003421.setBorderPainted (true);
	btn003421.setDataSourceName("");
	btn003421.setTabOrder(301);
        
      // container is form
add (btn003421,null);             
	} // end of initVSButtonbtn003421
	
	
	
	
	
	
	 public void initVSButtonbtn003322() {
	btn003322.setText("003");
	btn003322.setName ("btn003322");
		btn003322.setForeground(Color.black);
		btn003322.setBackground(new Color(0xc6c6c6));
	btn003322.setBounds (199, 325 , 50, 18);

btn003322.setFont (new Font ("Helvetica", 0, 12));

 	btn003322.setBorderPainted (true);
	btn003322.setDataSourceName("");
	btn003322.setTabOrder(300);
        
      // container is form
add (btn003322,null);             
	} // end of initVSButtonbtn003322
	
	
	
	
	
	
	 public void initVSButtonbtn003223() {
	btn003223.setText("003");
	btn003223.setName ("btn003223");
		btn003223.setForeground(Color.black);
		btn003223.setBackground(new Color(0xc6c6c6));
	btn003223.setBounds (189, 315 , 50, 18);

btn003223.setFont (new Font ("Helvetica", 0, 12));

 	btn003223.setBorderPainted (true);
	btn003223.setDataSourceName("");
	btn003223.setTabOrder(299);
        
      // container is form
add (btn003223,null);             
	} // end of initVSButtonbtn003223
	
	
	
	
	
	
	 public void initVSButtonbtn003138() {
	btn003138.setText("003");
	btn003138.setName ("btn003138");
		btn003138.setForeground(Color.black);
		btn003138.setBackground(new Color(0xc6c6c6));
	btn003138.setBounds (179, 305 , 50, 18);

btn003138.setFont (new Font ("Helvetica", 0, 12));

 	btn003138.setBorderPainted (true);
	btn003138.setDataSourceName("");
	btn003138.setTabOrder(298);
        
      // container is form
add (btn003138,null);             
	} // end of initVSButtonbtn003138
	
	
	
	
	
	
	 public void initVSButtonbtn003137() {
	btn003137.setText("003");
	btn003137.setName ("btn003137");
		btn003137.setForeground(Color.black);
		btn003137.setBackground(new Color(0xc6c6c6));
	btn003137.setBounds (169, 295 , 50, 18);

btn003137.setFont (new Font ("Helvetica", 0, 12));

 	btn003137.setBorderPainted (true);
	btn003137.setDataSourceName("");
	btn003137.setTabOrder(297);
        
      // container is form
add (btn003137,null);             
	} // end of initVSButtonbtn003137
	
	
	
	
	
	
	 public void initVSButtonbtn00221() {
	btn00221.setText("002");
	btn00221.setName ("btn00221");
		btn00221.setForeground(Color.black);
		btn00221.setBackground(new Color(0xc6c6c6));
	btn00221.setBounds (164, 278 , 50, 18);

btn00221.setFont (new Font ("Helvetica", 0, 12));

 	btn00221.setBorderPainted (true);
	btn00221.setDataSourceName("");
	btn00221.setTabOrder(296);
        
      // container is form
add (btn00221,null);             
	} // end of initVSButtonbtn00221
	
	
	
	
	
	
	 public void initVSButtonbtn00121() {
	btn00121.setText("001");
	btn00121.setName ("btn00121");
		btn00121.setForeground(Color.black);
		btn00121.setBackground(new Color(0xc6c6c6));
	btn00121.setBounds (146, 261 , 50, 18);

btn00121.setFont (new Font ("Helvetica", 0, 12));

 	btn00121.setBorderPainted (true);
	btn00121.setDataSourceName("");
	btn00121.setTabOrder(295);
        
      // container is form
add (btn00121,null);             
	} // end of initVSButtonbtn00121
	
	
	
	
	
	
	 public void initVSButtonbtn0031123() {
	btn0031123.setText("003");
	btn0031123.setName ("btn0031123");
		btn0031123.setForeground(Color.black);
		btn0031123.setBackground(new Color(0xc6c6c6));
	btn0031123.setBounds (260, 433 , 50, 18);

btn0031123.setFont (new Font ("Helvetica", 0, 12));

 	btn0031123.setBorderPainted (true);
	btn0031123.setDataSourceName("");
	btn0031123.setTabOrder(294);
        
      // container is form
add (btn0031123,null);             
	} // end of initVSButtonbtn0031123
	
	
	
	
	
	
	 public void initVSButtonbtn0031020() {
	btn0031020.setText("003");
	btn0031020.setName ("btn0031020");
		btn0031020.setForeground(Color.black);
		btn0031020.setBackground(new Color(0xc6c6c6));
	btn0031020.setBounds (250, 423 , 50, 18);

btn0031020.setFont (new Font ("Helvetica", 0, 12));

 	btn0031020.setBorderPainted (true);
	btn0031020.setDataSourceName("");
	btn0031020.setTabOrder(293);
        
      // container is form
add (btn0031020,null);             
	} // end of initVSButtonbtn0031020
	
	
	
	
	
	
	 public void initVSButtonbtn003920() {
	btn003920.setText("003");
	btn003920.setName ("btn003920");
		btn003920.setForeground(Color.black);
		btn003920.setBackground(new Color(0xc6c6c6));
	btn003920.setBounds (240, 413 , 50, 18);

btn003920.setFont (new Font ("Helvetica", 0, 12));

 	btn003920.setBorderPainted (true);
	btn003920.setDataSourceName("");
	btn003920.setTabOrder(292);
        
      // container is form
add (btn003920,null);             
	} // end of initVSButtonbtn003920
	
	
	
	
	
	
	 public void initVSButtonbtn003820() {
	btn003820.setText("003");
	btn003820.setName ("btn003820");
		btn003820.setForeground(Color.black);
		btn003820.setBackground(new Color(0xc6c6c6));
	btn003820.setBounds (230, 403 , 50, 18);

btn003820.setFont (new Font ("Helvetica", 0, 12));

 	btn003820.setBorderPainted (true);
	btn003820.setDataSourceName("");
	btn003820.setTabOrder(291);
        
      // container is form
add (btn003820,null);             
	} // end of initVSButtonbtn003820
	
	
	
	
	
	
	 public void initVSButtonbtn003720() {
	btn003720.setText("003");
	btn003720.setName ("btn003720");
		btn003720.setForeground(Color.black);
		btn003720.setBackground(new Color(0xc6c6c6));
	btn003720.setBounds (220, 393 , 50, 18);

btn003720.setFont (new Font ("Helvetica", 0, 12));

 	btn003720.setBorderPainted (true);
	btn003720.setDataSourceName("");
	btn003720.setTabOrder(290);
        
      // container is form
add (btn003720,null);             
	} // end of initVSButtonbtn003720
	
	
	
	
	
	
	 public void initVSButtonbtn003620() {
	btn003620.setText("003");
	btn003620.setName ("btn003620");
		btn003620.setForeground(Color.black);
		btn003620.setBackground(new Color(0xc6c6c6));
	btn003620.setBounds (210, 383 , 50, 18);

btn003620.setFont (new Font ("Helvetica", 0, 12));

 	btn003620.setBorderPainted (true);
	btn003620.setDataSourceName("");
	btn003620.setTabOrder(289);
        
      // container is form
add (btn003620,null);             
	} // end of initVSButtonbtn003620
	
	
	
	
	
	
	 public void initVSButtonbtn003520() {
	btn003520.setText("003");
	btn003520.setName ("btn003520");
		btn003520.setForeground(Color.black);
		btn003520.setBackground(new Color(0xc6c6c6));
	btn003520.setBounds (200, 373 , 50, 18);

btn003520.setFont (new Font ("Helvetica", 0, 12));

 	btn003520.setBorderPainted (true);
	btn003520.setDataSourceName("");
	btn003520.setTabOrder(288);
        
      // container is form
add (btn003520,null);             
	} // end of initVSButtonbtn003520
	
	
	
	
	
	
	 public void initVSButtonbtn003420() {
	btn003420.setText("003");
	btn003420.setName ("btn003420");
		btn003420.setForeground(Color.black);
		btn003420.setBackground(new Color(0xc6c6c6));
	btn003420.setBounds (190, 363 , 50, 18);

btn003420.setFont (new Font ("Helvetica", 0, 12));

 	btn003420.setBorderPainted (true);
	btn003420.setDataSourceName("");
	btn003420.setTabOrder(287);
        
      // container is form
add (btn003420,null);             
	} // end of initVSButtonbtn003420
	
	
	
	
	
	
	 public void initVSButtonbtn003321() {
	btn003321.setText("003");
	btn003321.setName ("btn003321");
		btn003321.setForeground(Color.black);
		btn003321.setBackground(new Color(0xc6c6c6));
	btn003321.setBounds (180, 353 , 50, 18);

btn003321.setFont (new Font ("Helvetica", 0, 12));

 	btn003321.setBorderPainted (true);
	btn003321.setDataSourceName("");
	btn003321.setTabOrder(286);
        
      // container is form
add (btn003321,null);             
	} // end of initVSButtonbtn003321
	
	
	
	
	
	
	 public void initVSButtonbtn003222() {
	btn003222.setText("003");
	btn003222.setName ("btn003222");
		btn003222.setForeground(Color.black);
		btn003222.setBackground(new Color(0xc6c6c6));
	btn003222.setBounds (170, 343 , 50, 18);

btn003222.setFont (new Font ("Helvetica", 0, 12));

 	btn003222.setBorderPainted (true);
	btn003222.setDataSourceName("");
	btn003222.setTabOrder(285);
        
      // container is form
add (btn003222,null);             
	} // end of initVSButtonbtn003222
	
	
	
	
	
	
	 public void initVSButtonbtn003136() {
	btn003136.setText("003");
	btn003136.setName ("btn003136");
		btn003136.setForeground(Color.black);
		btn003136.setBackground(new Color(0xc6c6c6));
	btn003136.setBounds (160, 333 , 50, 18);

btn003136.setFont (new Font ("Helvetica", 0, 12));

 	btn003136.setBorderPainted (true);
	btn003136.setDataSourceName("");
	btn003136.setTabOrder(284);
        
      // container is form
add (btn003136,null);             
	} // end of initVSButtonbtn003136
	
	
	
	
	
	
	 public void initVSButtonbtn003135() {
	btn003135.setText("003");
	btn003135.setName ("btn003135");
		btn003135.setForeground(Color.black);
		btn003135.setBackground(new Color(0xc6c6c6));
	btn003135.setBounds (150, 323 , 50, 18);

btn003135.setFont (new Font ("Helvetica", 0, 12));

 	btn003135.setBorderPainted (true);
	btn003135.setDataSourceName("");
	btn003135.setTabOrder(283);
        
      // container is form
add (btn003135,null);             
	} // end of initVSButtonbtn003135
	
	
	
	
	
	
	 public void initVSButtonbtn00220() {
	btn00220.setText("002");
	btn00220.setName ("btn00220");
		btn00220.setForeground(Color.black);
		btn00220.setBackground(new Color(0xc6c6c6));
	btn00220.setBounds (145, 306 , 50, 18);

btn00220.setFont (new Font ("Helvetica", 0, 12));

 	btn00220.setBorderPainted (true);
	btn00220.setDataSourceName("");
	btn00220.setTabOrder(282);
        
      // container is form
add (btn00220,null);             
	} // end of initVSButtonbtn00220
	
	
	
	
	
	
	 public void initVSButtonbtn00120() {
	btn00120.setText("001");
	btn00120.setName ("btn00120");
		btn00120.setForeground(Color.black);
		btn00120.setBackground(new Color(0xc6c6c6));
	btn00120.setBounds (127, 289 , 50, 18);

btn00120.setFont (new Font ("Helvetica", 0, 12));

 	btn00120.setBorderPainted (true);
	btn00120.setDataSourceName("");
	btn00120.setTabOrder(281);
        
      // container is form
add (btn00120,null);             
	} // end of initVSButtonbtn00120
	
	
	
	
	
	
	 public void initVSButtonbtn0031122() {
	btn0031122.setText("003");
	btn0031122.setName ("btn0031122");
		btn0031122.setForeground(Color.black);
		btn0031122.setBackground(new Color(0xc6c6c6));
	btn0031122.setBounds (194, 421 , 50, 18);

btn0031122.setFont (new Font ("Helvetica", 0, 12));

 	btn0031122.setBorderPainted (true);
	btn0031122.setDataSourceName("");
	btn0031122.setTabOrder(280);
        
      // container is form
add (btn0031122,null);             
	} // end of initVSButtonbtn0031122
	
	
	
	
	
	
	 public void initVSButtonbtn0031019() {
	btn0031019.setText("003");
	btn0031019.setName ("btn0031019");
		btn0031019.setForeground(Color.black);
		btn0031019.setBackground(new Color(0xc6c6c6));
	btn0031019.setBounds (184, 411 , 50, 18);

btn0031019.setFont (new Font ("Helvetica", 0, 12));

 	btn0031019.setBorderPainted (true);
	btn0031019.setDataSourceName("");
	btn0031019.setTabOrder(279);
        
      // container is form
add (btn0031019,null);             
	} // end of initVSButtonbtn0031019
	
	
	
	
	
	
	 public void initVSButtonbtn003919() {
	btn003919.setText("003");
	btn003919.setName ("btn003919");
		btn003919.setForeground(Color.black);
		btn003919.setBackground(new Color(0xc6c6c6));
	btn003919.setBounds (174, 401 , 50, 18);

btn003919.setFont (new Font ("Helvetica", 0, 12));

 	btn003919.setBorderPainted (true);
	btn003919.setDataSourceName("");
	btn003919.setTabOrder(278);
        
      // container is form
add (btn003919,null);             
	} // end of initVSButtonbtn003919
	
	
	
	
	
	
	 public void initVSButtonbtn003819() {
	btn003819.setText("003");
	btn003819.setName ("btn003819");
		btn003819.setForeground(Color.black);
		btn003819.setBackground(new Color(0xc6c6c6));
	btn003819.setBounds (164, 391 , 50, 18);

btn003819.setFont (new Font ("Helvetica", 0, 12));

 	btn003819.setBorderPainted (true);
	btn003819.setDataSourceName("");
	btn003819.setTabOrder(277);
        
      // container is form
add (btn003819,null);             
	} // end of initVSButtonbtn003819
	
	
	
	
	
	
	 public void initVSButtonbtn003719() {
	btn003719.setText("003");
	btn003719.setName ("btn003719");
		btn003719.setForeground(Color.black);
		btn003719.setBackground(new Color(0xc6c6c6));
	btn003719.setBounds (154, 381 , 50, 18);

btn003719.setFont (new Font ("Helvetica", 0, 12));

 	btn003719.setBorderPainted (true);
	btn003719.setDataSourceName("");
	btn003719.setTabOrder(276);
        
      // container is form
add (btn003719,null);             
	} // end of initVSButtonbtn003719
	
	
	
	
	
	
	 public void initVSButtonbtn003619() {
	btn003619.setText("003");
	btn003619.setName ("btn003619");
		btn003619.setForeground(Color.black);
		btn003619.setBackground(new Color(0xc6c6c6));
	btn003619.setBounds (144, 371 , 50, 18);

btn003619.setFont (new Font ("Helvetica", 0, 12));

 	btn003619.setBorderPainted (true);
	btn003619.setDataSourceName("");
	btn003619.setTabOrder(275);
        
      // container is form
add (btn003619,null);             
	} // end of initVSButtonbtn003619
	
	
	
	
	
	
	 public void initVSButtonbtn003519() {
	btn003519.setText("003");
	btn003519.setName ("btn003519");
		btn003519.setForeground(Color.black);
		btn003519.setBackground(new Color(0xc6c6c6));
	btn003519.setBounds (134, 361 , 50, 18);

btn003519.setFont (new Font ("Helvetica", 0, 12));

 	btn003519.setBorderPainted (true);
	btn003519.setDataSourceName("");
	btn003519.setTabOrder(274);
        
      // container is form
add (btn003519,null);             
	} // end of initVSButtonbtn003519
	
	
	
	
	
	
	 public void initVSButtonbtn003419() {
	btn003419.setText("003");
	btn003419.setName ("btn003419");
		btn003419.setForeground(Color.black);
		btn003419.setBackground(new Color(0xc6c6c6));
	btn003419.setBounds (124, 351 , 50, 18);

btn003419.setFont (new Font ("Helvetica", 0, 12));

 	btn003419.setBorderPainted (true);
	btn003419.setDataSourceName("");
	btn003419.setTabOrder(273);
        
      // container is form
add (btn003419,null);             
	} // end of initVSButtonbtn003419
	
	
	
	
	
	
	 public void initVSButtonbtn003320() {
	btn003320.setText("003");
	btn003320.setName ("btn003320");
		btn003320.setForeground(Color.black);
		btn003320.setBackground(new Color(0xc6c6c6));
	btn003320.setBounds (114, 341 , 50, 18);

btn003320.setFont (new Font ("Helvetica", 0, 12));

 	btn003320.setBorderPainted (true);
	btn003320.setDataSourceName("");
	btn003320.setTabOrder(272);
        
      // container is form
add (btn003320,null);             
	} // end of initVSButtonbtn003320
	
	
	
	
	
	
	 public void initVSButtonbtn003221() {
	btn003221.setText("003");
	btn003221.setName ("btn003221");
		btn003221.setForeground(Color.black);
		btn003221.setBackground(new Color(0xc6c6c6));
	btn003221.setBounds (104, 331 , 50, 18);

btn003221.setFont (new Font ("Helvetica", 0, 12));

 	btn003221.setBorderPainted (true);
	btn003221.setDataSourceName("");
	btn003221.setTabOrder(271);
        
      // container is form
add (btn003221,null);             
	} // end of initVSButtonbtn003221
	
	
	
	
	
	
	 public void initVSButtonbtn003134() {
	btn003134.setText("003");
	btn003134.setName ("btn003134");
		btn003134.setForeground(Color.black);
		btn003134.setBackground(new Color(0xc6c6c6));
	btn003134.setBounds (94, 321 , 50, 18);

btn003134.setFont (new Font ("Helvetica", 0, 12));

 	btn003134.setBorderPainted (true);
	btn003134.setDataSourceName("");
	btn003134.setTabOrder(270);
        
      // container is form
add (btn003134,null);             
	} // end of initVSButtonbtn003134
	
	
	
	
	
	
	 public void initVSButtonbtn003133() {
	btn003133.setText("003");
	btn003133.setName ("btn003133");
		btn003133.setForeground(Color.black);
		btn003133.setBackground(new Color(0xc6c6c6));
	btn003133.setBounds (84, 311 , 50, 18);

btn003133.setFont (new Font ("Helvetica", 0, 12));

 	btn003133.setBorderPainted (true);
	btn003133.setDataSourceName("");
	btn003133.setTabOrder(269);
        
      // container is form
add (btn003133,null);             
	} // end of initVSButtonbtn003133
	
	
	
	
	
	
	 public void initVSButtonbtn00219() {
	btn00219.setText("002");
	btn00219.setName ("btn00219");
		btn00219.setForeground(Color.black);
		btn00219.setBackground(new Color(0xc6c6c6));
	btn00219.setBounds (79, 294 , 50, 18);

btn00219.setFont (new Font ("Helvetica", 0, 12));

 	btn00219.setBorderPainted (true);
	btn00219.setDataSourceName("");
	btn00219.setTabOrder(268);
        
      // container is form
add (btn00219,null);             
	} // end of initVSButtonbtn00219
	
	
	
	
	
	
	 public void initVSButtonbtn00119() {
	btn00119.setText("001");
	btn00119.setName ("btn00119");
		btn00119.setForeground(Color.black);
		btn00119.setBackground(new Color(0xc6c6c6));
	btn00119.setBounds (61, 277 , 50, 18);

btn00119.setFont (new Font ("Helvetica", 0, 12));

 	btn00119.setBorderPainted (true);
	btn00119.setDataSourceName("");
	btn00119.setTabOrder(267);
        
      // container is form
add (btn00119,null);             
	} // end of initVSButtonbtn00119
	
	
	
	
	
	
	 public void initVSButtonbtn0031121() {
	btn0031121.setText("003");
	btn0031121.setName ("btn0031121");
		btn0031121.setForeground(Color.black);
		btn0031121.setBackground(new Color(0xc6c6c6));
	btn0031121.setBounds (176, 446 , 50, 18);

btn0031121.setFont (new Font ("Helvetica", 0, 12));

 	btn0031121.setBorderPainted (true);
	btn0031121.setDataSourceName("");
	btn0031121.setTabOrder(266);
        
      // container is form
add (btn0031121,null);             
	} // end of initVSButtonbtn0031121
	
	
	
	
	
	
	 public void initVSButtonbtn0031018() {
	btn0031018.setText("003");
	btn0031018.setName ("btn0031018");
		btn0031018.setForeground(Color.black);
		btn0031018.setBackground(new Color(0xc6c6c6));
	btn0031018.setBounds (166, 436 , 50, 18);

btn0031018.setFont (new Font ("Helvetica", 0, 12));

 	btn0031018.setBorderPainted (true);
	btn0031018.setDataSourceName("");
	btn0031018.setTabOrder(265);
        
      // container is form
add (btn0031018,null);             
	} // end of initVSButtonbtn0031018
	
	
	
	
	
	
	 public void initVSButtonbtn003918() {
	btn003918.setText("003");
	btn003918.setName ("btn003918");
		btn003918.setForeground(Color.black);
		btn003918.setBackground(new Color(0xc6c6c6));
	btn003918.setBounds (156, 426 , 50, 18);

btn003918.setFont (new Font ("Helvetica", 0, 12));

 	btn003918.setBorderPainted (true);
	btn003918.setDataSourceName("");
	btn003918.setTabOrder(264);
        
      // container is form
add (btn003918,null);             
	} // end of initVSButtonbtn003918
	
	
	
	
	
	
	 public void initVSButtonbtn003818() {
	btn003818.setText("003");
	btn003818.setName ("btn003818");
		btn003818.setForeground(Color.black);
		btn003818.setBackground(new Color(0xc6c6c6));
	btn003818.setBounds (146, 416 , 50, 18);

btn003818.setFont (new Font ("Helvetica", 0, 12));

 	btn003818.setBorderPainted (true);
	btn003818.setDataSourceName("");
	btn003818.setTabOrder(263);
        
      // container is form
add (btn003818,null);             
	} // end of initVSButtonbtn003818
	
	
	
	
	
	
	 public void initVSButtonbtn003718() {
	btn003718.setText("003");
	btn003718.setName ("btn003718");
		btn003718.setForeground(Color.black);
		btn003718.setBackground(new Color(0xc6c6c6));
	btn003718.setBounds (136, 406 , 50, 18);

btn003718.setFont (new Font ("Helvetica", 0, 12));

 	btn003718.setBorderPainted (true);
	btn003718.setDataSourceName("");
	btn003718.setTabOrder(262);
        
      // container is form
add (btn003718,null);             
	} // end of initVSButtonbtn003718
	
	
	
	
	
	
	 public void initVSButtonbtn003618() {
	btn003618.setText("003");
	btn003618.setName ("btn003618");
		btn003618.setForeground(Color.black);
		btn003618.setBackground(new Color(0xc6c6c6));
	btn003618.setBounds (126, 396 , 50, 18);

btn003618.setFont (new Font ("Helvetica", 0, 12));

 	btn003618.setBorderPainted (true);
	btn003618.setDataSourceName("");
	btn003618.setTabOrder(261);
        
      // container is form
add (btn003618,null);             
	} // end of initVSButtonbtn003618
	
	
	
	
	
	
	 public void initVSButtonbtn003518() {
	btn003518.setText("003");
	btn003518.setName ("btn003518");
		btn003518.setForeground(Color.black);
		btn003518.setBackground(new Color(0xc6c6c6));
	btn003518.setBounds (116, 386 , 50, 18);

btn003518.setFont (new Font ("Helvetica", 0, 12));

 	btn003518.setBorderPainted (true);
	btn003518.setDataSourceName("");
	btn003518.setTabOrder(260);
        
      // container is form
add (btn003518,null);             
	} // end of initVSButtonbtn003518
	
	
	
	
	
	
	 public void initVSButtonbtn003418() {
	btn003418.setText("003");
	btn003418.setName ("btn003418");
		btn003418.setForeground(Color.black);
		btn003418.setBackground(new Color(0xc6c6c6));
	btn003418.setBounds (106, 376 , 50, 18);

btn003418.setFont (new Font ("Helvetica", 0, 12));

 	btn003418.setBorderPainted (true);
	btn003418.setDataSourceName("");
	btn003418.setTabOrder(259);
        
      // container is form
add (btn003418,null);             
	} // end of initVSButtonbtn003418
	
	
	
	
	
	
	 public void initVSButtonbtn003319() {
	btn003319.setText("003");
	btn003319.setName ("btn003319");
		btn003319.setForeground(Color.black);
		btn003319.setBackground(new Color(0xc6c6c6));
	btn003319.setBounds (96, 366 , 50, 18);

btn003319.setFont (new Font ("Helvetica", 0, 12));

 	btn003319.setBorderPainted (true);
	btn003319.setDataSourceName("");
	btn003319.setTabOrder(258);
        
      // container is form
add (btn003319,null);             
	} // end of initVSButtonbtn003319
	
	
	
	
	
	
	 public void initVSButtonbtn003220() {
	btn003220.setText("003");
	btn003220.setName ("btn003220");
		btn003220.setForeground(Color.black);
		btn003220.setBackground(new Color(0xc6c6c6));
	btn003220.setBounds (86, 356 , 50, 18);

btn003220.setFont (new Font ("Helvetica", 0, 12));

 	btn003220.setBorderPainted (true);
	btn003220.setDataSourceName("");
	btn003220.setTabOrder(257);
        
      // container is form
add (btn003220,null);             
	} // end of initVSButtonbtn003220
	
	
	
	
	
	
	 public void initVSButtonbtn003132() {
	btn003132.setText("003");
	btn003132.setName ("btn003132");
		btn003132.setForeground(Color.black);
		btn003132.setBackground(new Color(0xc6c6c6));
	btn003132.setBounds (76, 346 , 50, 18);

btn003132.setFont (new Font ("Helvetica", 0, 12));

 	btn003132.setBorderPainted (true);
	btn003132.setDataSourceName("");
	btn003132.setTabOrder(256);
        
      // container is form
add (btn003132,null);             
	} // end of initVSButtonbtn003132
	
	
	
	
	
	
	 public void initVSButtonbtn003131() {
	btn003131.setText("003");
	btn003131.setName ("btn003131");
		btn003131.setForeground(Color.black);
		btn003131.setBackground(new Color(0xc6c6c6));
	btn003131.setBounds (66, 336 , 50, 18);

btn003131.setFont (new Font ("Helvetica", 0, 12));

 	btn003131.setBorderPainted (true);
	btn003131.setDataSourceName("");
	btn003131.setTabOrder(255);
        
      // container is form
add (btn003131,null);             
	} // end of initVSButtonbtn003131
	
	
	
	
	
	
	 public void initVSButtonbtn00218() {
	btn00218.setText("002");
	btn00218.setName ("btn00218");
		btn00218.setForeground(Color.black);
		btn00218.setBackground(new Color(0xc6c6c6));
	btn00218.setBounds (61, 319 , 50, 18);

btn00218.setFont (new Font ("Helvetica", 0, 12));

 	btn00218.setBorderPainted (true);
	btn00218.setDataSourceName("");
	btn00218.setTabOrder(254);
        
      // container is form
add (btn00218,null);             
	} // end of initVSButtonbtn00218
	
	
	
	
	
	
	 public void initVSButtonbtn00118() {
	btn00118.setText("001");
	btn00118.setName ("btn00118");
		btn00118.setForeground(Color.black);
		btn00118.setBackground(new Color(0xc6c6c6));
	btn00118.setBounds (43, 302 , 50, 18);

btn00118.setFont (new Font ("Helvetica", 0, 12));

 	btn00118.setBorderPainted (true);
	btn00118.setDataSourceName("");
	btn00118.setTabOrder(253);
        
      // container is form
add (btn00118,null);             
	} // end of initVSButtonbtn00118
	
	
	
	
	
	
	 public void initVSButtonbtn0031120() {
	btn0031120.setText("003");
	btn0031120.setName ("btn0031120");
		btn0031120.setForeground(Color.black);
		btn0031120.setBackground(new Color(0xc6c6c6));
	btn0031120.setBounds (130, 455 , 50, 18);

btn0031120.setFont (new Font ("Helvetica", 0, 12));

 	btn0031120.setBorderPainted (true);
	btn0031120.setDataSourceName("");
	btn0031120.setTabOrder(252);
        
      // container is form
add (btn0031120,null);             
	} // end of initVSButtonbtn0031120
	
	
	
	
	
	
	 public void initVSButtonbtn0031017() {
	btn0031017.setText("003");
	btn0031017.setName ("btn0031017");
		btn0031017.setForeground(Color.black);
		btn0031017.setBackground(new Color(0xc6c6c6));
	btn0031017.setBounds (120, 445 , 50, 18);

btn0031017.setFont (new Font ("Helvetica", 0, 12));

 	btn0031017.setBorderPainted (true);
	btn0031017.setDataSourceName("");
	btn0031017.setTabOrder(251);
        
      // container is form
add (btn0031017,null);             
	} // end of initVSButtonbtn0031017
	
	
	
	
	
	
	 public void initVSButtonbtn003917() {
	btn003917.setText("003");
	btn003917.setName ("btn003917");
		btn003917.setForeground(Color.black);
		btn003917.setBackground(new Color(0xc6c6c6));
	btn003917.setBounds (110, 435 , 50, 18);

btn003917.setFont (new Font ("Helvetica", 0, 12));

 	btn003917.setBorderPainted (true);
	btn003917.setDataSourceName("");
	btn003917.setTabOrder(250);
        
      // container is form
add (btn003917,null);             
	} // end of initVSButtonbtn003917
	
	
	
	
	
	
	 public void initVSButtonbtn003817() {
	btn003817.setText("003");
	btn003817.setName ("btn003817");
		btn003817.setForeground(Color.black);
		btn003817.setBackground(new Color(0xc6c6c6));
	btn003817.setBounds (100, 425 , 50, 18);

btn003817.setFont (new Font ("Helvetica", 0, 12));

 	btn003817.setBorderPainted (true);
	btn003817.setDataSourceName("");
	btn003817.setTabOrder(249);
        
      // container is form
add (btn003817,null);             
	} // end of initVSButtonbtn003817
	
	
	
	
	
	
	 public void initVSButtonbtn003717() {
	btn003717.setText("003");
	btn003717.setName ("btn003717");
		btn003717.setForeground(Color.black);
		btn003717.setBackground(new Color(0xc6c6c6));
	btn003717.setBounds (90, 415 , 50, 18);

btn003717.setFont (new Font ("Helvetica", 0, 12));

 	btn003717.setBorderPainted (true);
	btn003717.setDataSourceName("");
	btn003717.setTabOrder(248);
        
      // container is form
add (btn003717,null);             
	} // end of initVSButtonbtn003717
	
	
	
	
	
	
	 public void initVSButtonbtn003617() {
	btn003617.setText("003");
	btn003617.setName ("btn003617");
		btn003617.setForeground(Color.black);
		btn003617.setBackground(new Color(0xc6c6c6));
	btn003617.setBounds (80, 405 , 50, 18);

btn003617.setFont (new Font ("Helvetica", 0, 12));

 	btn003617.setBorderPainted (true);
	btn003617.setDataSourceName("");
	btn003617.setTabOrder(247);
        
      // container is form
add (btn003617,null);             
	} // end of initVSButtonbtn003617
	
	
	
	
	
	
	 public void initVSButtonbtn003517() {
	btn003517.setText("003");
	btn003517.setName ("btn003517");
		btn003517.setForeground(Color.black);
		btn003517.setBackground(new Color(0xc6c6c6));
	btn003517.setBounds (70, 395 , 50, 18);

btn003517.setFont (new Font ("Helvetica", 0, 12));

 	btn003517.setBorderPainted (true);
	btn003517.setDataSourceName("");
	btn003517.setTabOrder(246);
        
      // container is form
add (btn003517,null);             
	} // end of initVSButtonbtn003517
	
	
	
	
	
	
	 public void initVSButtonbtn003417() {
	btn003417.setText("003");
	btn003417.setName ("btn003417");
		btn003417.setForeground(Color.black);
		btn003417.setBackground(new Color(0xc6c6c6));
	btn003417.setBounds (60, 385 , 50, 18);

btn003417.setFont (new Font ("Helvetica", 0, 12));

 	btn003417.setBorderPainted (true);
	btn003417.setDataSourceName("");
	btn003417.setTabOrder(245);
        
      // container is form
add (btn003417,null);             
	} // end of initVSButtonbtn003417
	
	
	
	
	
	
	 public void initVSButtonbtn003318() {
	btn003318.setText("003");
	btn003318.setName ("btn003318");
		btn003318.setForeground(Color.black);
		btn003318.setBackground(new Color(0xc6c6c6));
	btn003318.setBounds (50, 375 , 50, 18);

btn003318.setFont (new Font ("Helvetica", 0, 12));

 	btn003318.setBorderPainted (true);
	btn003318.setDataSourceName("");
	btn003318.setTabOrder(244);
        
      // container is form
add (btn003318,null);             
	} // end of initVSButtonbtn003318
	
	
	
	
	
	
	 public void initVSButtonbtn003219() {
	btn003219.setText("003");
	btn003219.setName ("btn003219");
		btn003219.setForeground(Color.black);
		btn003219.setBackground(new Color(0xc6c6c6));
	btn003219.setBounds (40, 365 , 50, 18);

btn003219.setFont (new Font ("Helvetica", 0, 12));

 	btn003219.setBorderPainted (true);
	btn003219.setDataSourceName("");
	btn003219.setTabOrder(243);
        
      // container is form
add (btn003219,null);             
	} // end of initVSButtonbtn003219
	
	
	
	
	
	
	 public void initVSButtonbtn003130() {
	btn003130.setText("003");
	btn003130.setName ("btn003130");
		btn003130.setForeground(Color.black);
		btn003130.setBackground(new Color(0xc6c6c6));
	btn003130.setBounds (30, 355 , 50, 18);

btn003130.setFont (new Font ("Helvetica", 0, 12));

 	btn003130.setBorderPainted (true);
	btn003130.setDataSourceName("");
	btn003130.setTabOrder(242);
        
      // container is form
add (btn003130,null);             
	} // end of initVSButtonbtn003130
	
	
	
	
	
	
	 public void initVSButtonbtn003129() {
	btn003129.setText("003");
	btn003129.setName ("btn003129");
		btn003129.setForeground(Color.black);
		btn003129.setBackground(new Color(0xc6c6c6));
	btn003129.setBounds (20, 345 , 50, 18);

btn003129.setFont (new Font ("Helvetica", 0, 12));

 	btn003129.setBorderPainted (true);
	btn003129.setDataSourceName("");
	btn003129.setTabOrder(241);
        
      // container is form
add (btn003129,null);             
	} // end of initVSButtonbtn003129
	
	
	
	
	
	
	 public void initVSButtonbtn00217() {
	btn00217.setText("002");
	btn00217.setName ("btn00217");
		btn00217.setForeground(Color.black);
		btn00217.setBackground(new Color(0xc6c6c6));
	btn00217.setBounds (15, 328 , 50, 18);

btn00217.setFont (new Font ("Helvetica", 0, 12));

 	btn00217.setBorderPainted (true);
	btn00217.setDataSourceName("");
	btn00217.setTabOrder(240);
        
      // container is form
add (btn00217,null);             
	} // end of initVSButtonbtn00217
	
	
	
	
	
	
	 public void initVSButtonbtn00117() {
	btn00117.setText("001");
	btn00117.setName ("btn00117");
		btn00117.setForeground(Color.black);
		btn00117.setBackground(new Color(0xc6c6c6));
	btn00117.setBounds (-3, 311 , 50, 18);

btn00117.setFont (new Font ("Helvetica", 0, 12));

 	btn00117.setBorderPainted (true);
	btn00117.setDataSourceName("");
	btn00117.setTabOrder(239);
        
      // container is form
add (btn00117,null);             
	} // end of initVSButtonbtn00117
	
	
	
	
	
	
	 public void initVSButtonbtn0031119() {
	btn0031119.setText("003");
	btn0031119.setName ("btn0031119");
		btn0031119.setForeground(Color.black);
		btn0031119.setBackground(new Color(0xc6c6c6));
	btn0031119.setBounds (114, 414 , 50, 18);

btn0031119.setFont (new Font ("Helvetica", 0, 12));

 	btn0031119.setBorderPainted (true);
	btn0031119.setDataSourceName("");
	btn0031119.setTabOrder(238);
        
      // container is form
add (btn0031119,null);             
	} // end of initVSButtonbtn0031119
	
	
	
	
	
	
	 public void initVSButtonbtn0031016() {
	btn0031016.setText("003");
	btn0031016.setName ("btn0031016");
		btn0031016.setForeground(Color.black);
		btn0031016.setBackground(new Color(0xc6c6c6));
	btn0031016.setBounds (104, 404 , 50, 18);

btn0031016.setFont (new Font ("Helvetica", 0, 12));

 	btn0031016.setBorderPainted (true);
	btn0031016.setDataSourceName("");
	btn0031016.setTabOrder(237);
        
      // container is form
add (btn0031016,null);             
	} // end of initVSButtonbtn0031016
	
	
	
	
	
	
	 public void initVSButtonbtn003916() {
	btn003916.setText("003");
	btn003916.setName ("btn003916");
		btn003916.setForeground(Color.black);
		btn003916.setBackground(new Color(0xc6c6c6));
	btn003916.setBounds (94, 394 , 50, 18);

btn003916.setFont (new Font ("Helvetica", 0, 12));

 	btn003916.setBorderPainted (true);
	btn003916.setDataSourceName("");
	btn003916.setTabOrder(236);
        
      // container is form
add (btn003916,null);             
	} // end of initVSButtonbtn003916
	
	
	
	
	
	
	 public void initVSButtonbtn003816() {
	btn003816.setText("003");
	btn003816.setName ("btn003816");
		btn003816.setForeground(Color.black);
		btn003816.setBackground(new Color(0xc6c6c6));
	btn003816.setBounds (84, 384 , 50, 18);

btn003816.setFont (new Font ("Helvetica", 0, 12));

 	btn003816.setBorderPainted (true);
	btn003816.setDataSourceName("");
	btn003816.setTabOrder(235);
        
      // container is form
add (btn003816,null);             
	} // end of initVSButtonbtn003816
	
	
	
	
	
	
	 public void initVSButtonbtn003716() {
	btn003716.setText("003");
	btn003716.setName ("btn003716");
		btn003716.setForeground(Color.black);
		btn003716.setBackground(new Color(0xc6c6c6));
	btn003716.setBounds (74, 374 , 50, 18);

btn003716.setFont (new Font ("Helvetica", 0, 12));

 	btn003716.setBorderPainted (true);
	btn003716.setDataSourceName("");
	btn003716.setTabOrder(234);
        
      // container is form
add (btn003716,null);             
	} // end of initVSButtonbtn003716
	
	
	
	
	
	
	 public void initVSButtonbtn003616() {
	btn003616.setText("003");
	btn003616.setName ("btn003616");
		btn003616.setForeground(Color.black);
		btn003616.setBackground(new Color(0xc6c6c6));
	btn003616.setBounds (64, 364 , 50, 18);

btn003616.setFont (new Font ("Helvetica", 0, 12));

 	btn003616.setBorderPainted (true);
	btn003616.setDataSourceName("");
	btn003616.setTabOrder(233);
        
      // container is form
add (btn003616,null);             
	} // end of initVSButtonbtn003616
	
	
	
	
	
	
	 public void initVSButtonbtn003516() {
	btn003516.setText("003");
	btn003516.setName ("btn003516");
		btn003516.setForeground(Color.black);
		btn003516.setBackground(new Color(0xc6c6c6));
	btn003516.setBounds (54, 354 , 50, 18);

btn003516.setFont (new Font ("Helvetica", 0, 12));

 	btn003516.setBorderPainted (true);
	btn003516.setDataSourceName("");
	btn003516.setTabOrder(232);
        
      // container is form
add (btn003516,null);             
	} // end of initVSButtonbtn003516
	
	
	
	
	
	
	 public void initVSButtonbtn003416() {
	btn003416.setText("003");
	btn003416.setName ("btn003416");
		btn003416.setForeground(Color.black);
		btn003416.setBackground(new Color(0xc6c6c6));
	btn003416.setBounds (44, 344 , 50, 18);

btn003416.setFont (new Font ("Helvetica", 0, 12));

 	btn003416.setBorderPainted (true);
	btn003416.setDataSourceName("");
	btn003416.setTabOrder(231);
        
      // container is form
add (btn003416,null);             
	} // end of initVSButtonbtn003416
	
	
	
	
	
	
	 public void initVSButtonbtn003317() {
	btn003317.setText("003");
	btn003317.setName ("btn003317");
		btn003317.setForeground(Color.black);
		btn003317.setBackground(new Color(0xc6c6c6));
	btn003317.setBounds (34, 334 , 50, 18);

btn003317.setFont (new Font ("Helvetica", 0, 12));

 	btn003317.setBorderPainted (true);
	btn003317.setDataSourceName("");
	btn003317.setTabOrder(230);
        
      // container is form
add (btn003317,null);             
	} // end of initVSButtonbtn003317
	
	
	
	
	
	
	 public void initVSButtonbtn003218() {
	btn003218.setText("003");
	btn003218.setName ("btn003218");
		btn003218.setForeground(Color.black);
		btn003218.setBackground(new Color(0xc6c6c6));
	btn003218.setBounds (24, 324 , 50, 18);

btn003218.setFont (new Font ("Helvetica", 0, 12));

 	btn003218.setBorderPainted (true);
	btn003218.setDataSourceName("");
	btn003218.setTabOrder(229);
        
      // container is form
add (btn003218,null);             
	} // end of initVSButtonbtn003218
	
	
	
	
	
	
	 public void initVSButtonbtn003128() {
	btn003128.setText("003");
	btn003128.setName ("btn003128");
		btn003128.setForeground(Color.black);
		btn003128.setBackground(new Color(0xc6c6c6));
	btn003128.setBounds (14, 314 , 50, 18);

btn003128.setFont (new Font ("Helvetica", 0, 12));

 	btn003128.setBorderPainted (true);
	btn003128.setDataSourceName("");
	btn003128.setTabOrder(228);
        
      // container is form
add (btn003128,null);             
	} // end of initVSButtonbtn003128
	
	
	
	
	
	
	 public void initVSButtonbtn003100() {
	btn003100.setText("003");
	btn003100.setName ("btn003100");
		btn003100.setForeground(Color.black);
		btn003100.setBackground(new Color(0xc6c6c6));
	btn003100.setBounds (4, 304 , 50, 18);

btn003100.setFont (new Font ("Helvetica", 0, 12));

 	btn003100.setBorderPainted (true);
	btn003100.setDataSourceName("");
	btn003100.setTabOrder(227);
        
      // container is form
add (btn003100,null);             
	} // end of initVSButtonbtn003100
	
	
	
	
	
	
	 public void initVSButtonbtn00216() {
	btn00216.setText("002");
	btn00216.setName ("btn00216");
		btn00216.setForeground(Color.black);
		btn00216.setBackground(new Color(0xc6c6c6));
	btn00216.setBounds (-1, 287 , 50, 18);

btn00216.setFont (new Font ("Helvetica", 0, 12));

 	btn00216.setBorderPainted (true);
	btn00216.setDataSourceName("");
	btn00216.setTabOrder(226);
        
      // container is form
add (btn00216,null);             
	} // end of initVSButtonbtn00216
	
	
	
	
	
	
	 public void initVSButtonbtn00116() {
	btn00116.setText("001");
	btn00116.setName ("btn00116");
		btn00116.setForeground(Color.black);
		btn00116.setBackground(new Color(0xc6c6c6));
	btn00116.setBounds (-19, 270 , 50, 18);

btn00116.setFont (new Font ("Helvetica", 0, 12));

 	btn00116.setBorderPainted (true);
	btn00116.setDataSourceName("");
	btn00116.setTabOrder(225);
        
      // container is form
add (btn00116,null);             
	} // end of initVSButtonbtn00116
	
	
	
	
	
	
	 public void initVSButtonbtn0031118() {
	btn0031118.setText("003");
	btn0031118.setName ("btn0031118");
		btn0031118.setForeground(Color.black);
		btn0031118.setBackground(new Color(0xc6c6c6));
	btn0031118.setBounds (104, 357 , 50, 18);

btn0031118.setFont (new Font ("Helvetica", 0, 12));

 	btn0031118.setBorderPainted (true);
	btn0031118.setDataSourceName("");
	btn0031118.setTabOrder(224);
        
      // container is form
add (btn0031118,null);             
	} // end of initVSButtonbtn0031118
	
	
	
	
	
	
	 public void initVSButtonbtn0031015() {
	btn0031015.setText("003");
	btn0031015.setName ("btn0031015");
		btn0031015.setForeground(Color.black);
		btn0031015.setBackground(new Color(0xc6c6c6));
	btn0031015.setBounds (94, 347 , 50, 18);

btn0031015.setFont (new Font ("Helvetica", 0, 12));

 	btn0031015.setBorderPainted (true);
	btn0031015.setDataSourceName("");
	btn0031015.setTabOrder(223);
        
      // container is form
add (btn0031015,null);             
	} // end of initVSButtonbtn0031015
	
	
	
	
	
	
	 public void initVSButtonbtn003915() {
	btn003915.setText("003");
	btn003915.setName ("btn003915");
		btn003915.setForeground(Color.black);
		btn003915.setBackground(new Color(0xc6c6c6));
	btn003915.setBounds (84, 337 , 50, 18);

btn003915.setFont (new Font ("Helvetica", 0, 12));

 	btn003915.setBorderPainted (true);
	btn003915.setDataSourceName("");
	btn003915.setTabOrder(222);
        
      // container is form
add (btn003915,null);             
	} // end of initVSButtonbtn003915
	
	
	
	
	
	
	 public void initVSButtonbtn003815() {
	btn003815.setText("003");
	btn003815.setName ("btn003815");
		btn003815.setForeground(Color.black);
		btn003815.setBackground(new Color(0xc6c6c6));
	btn003815.setBounds (74, 327 , 50, 18);

btn003815.setFont (new Font ("Helvetica", 0, 12));

 	btn003815.setBorderPainted (true);
	btn003815.setDataSourceName("");
	btn003815.setTabOrder(221);
        
      // container is form
add (btn003815,null);             
	} // end of initVSButtonbtn003815
	
	
	
	
	
	
	 public void initVSButtonbtn003715() {
	btn003715.setText("003");
	btn003715.setName ("btn003715");
		btn003715.setForeground(Color.black);
		btn003715.setBackground(new Color(0xc6c6c6));
	btn003715.setBounds (64, 317 , 50, 18);

btn003715.setFont (new Font ("Helvetica", 0, 12));

 	btn003715.setBorderPainted (true);
	btn003715.setDataSourceName("");
	btn003715.setTabOrder(220);
        
      // container is form
add (btn003715,null);             
	} // end of initVSButtonbtn003715
	
	
	
	
	
	
	 public void initVSButtonbtn003615() {
	btn003615.setText("003");
	btn003615.setName ("btn003615");
		btn003615.setForeground(Color.black);
		btn003615.setBackground(new Color(0xc6c6c6));
	btn003615.setBounds (54, 307 , 50, 18);

btn003615.setFont (new Font ("Helvetica", 0, 12));

 	btn003615.setBorderPainted (true);
	btn003615.setDataSourceName("");
	btn003615.setTabOrder(219);
        
      // container is form
add (btn003615,null);             
	} // end of initVSButtonbtn003615
	
	
	
	
	
	
	 public void initVSButtonbtn003515() {
	btn003515.setText("003");
	btn003515.setName ("btn003515");
		btn003515.setForeground(Color.black);
		btn003515.setBackground(new Color(0xc6c6c6));
	btn003515.setBounds (44, 297 , 50, 18);

btn003515.setFont (new Font ("Helvetica", 0, 12));

 	btn003515.setBorderPainted (true);
	btn003515.setDataSourceName("");
	btn003515.setTabOrder(218);
        
      // container is form
add (btn003515,null);             
	} // end of initVSButtonbtn003515
	
	
	
	
	
	
	 public void initVSButtonbtn003415() {
	btn003415.setText("003");
	btn003415.setName ("btn003415");
		btn003415.setForeground(Color.black);
		btn003415.setBackground(new Color(0xc6c6c6));
	btn003415.setBounds (34, 287 , 50, 18);

btn003415.setFont (new Font ("Helvetica", 0, 12));

 	btn003415.setBorderPainted (true);
	btn003415.setDataSourceName("");
	btn003415.setTabOrder(217);
        
      // container is form
add (btn003415,null);             
	} // end of initVSButtonbtn003415
	
	
	
	
	
	
	 public void initVSButtonbtn003316() {
	btn003316.setText("003");
	btn003316.setName ("btn003316");
		btn003316.setForeground(Color.black);
		btn003316.setBackground(new Color(0xc6c6c6));
	btn003316.setBounds (24, 277 , 50, 18);

btn003316.setFont (new Font ("Helvetica", 0, 12));

 	btn003316.setBorderPainted (true);
	btn003316.setDataSourceName("");
	btn003316.setTabOrder(216);
        
      // container is form
add (btn003316,null);             
	} // end of initVSButtonbtn003316
	
	
	
	
	
	
	 public void initVSButtonbtn003217() {
	btn003217.setText("003");
	btn003217.setName ("btn003217");
		btn003217.setForeground(Color.black);
		btn003217.setBackground(new Color(0xc6c6c6));
	btn003217.setBounds (14, 267 , 50, 18);

btn003217.setFont (new Font ("Helvetica", 0, 12));

 	btn003217.setBorderPainted (true);
	btn003217.setDataSourceName("");
	btn003217.setTabOrder(215);
        
      // container is form
add (btn003217,null);             
	} // end of initVSButtonbtn003217
	
	
	
	
	
	
	 public void initVSButtonbtn003127() {
	btn003127.setText("003");
	btn003127.setName ("btn003127");
		btn003127.setForeground(Color.black);
		btn003127.setBackground(new Color(0xc6c6c6));
	btn003127.setBounds (4, 257 , 50, 18);

btn003127.setFont (new Font ("Helvetica", 0, 12));

 	btn003127.setBorderPainted (true);
	btn003127.setDataSourceName("");
	btn003127.setTabOrder(214);
        
      // container is form
add (btn003127,null);             
	} // end of initVSButtonbtn003127
	
	
	
	
	
	
	 public void initVSButtonbtn00390() {
	btn00390.setText("003");
	btn00390.setName ("btn00390");
		btn00390.setForeground(Color.black);
		btn00390.setBackground(new Color(0xc6c6c6));
	btn00390.setBounds (-6, 247 , 50, 18);

btn00390.setFont (new Font ("Helvetica", 0, 12));

 	btn00390.setBorderPainted (true);
	btn00390.setDataSourceName("");
	btn00390.setTabOrder(213);
        
      // container is form
add (btn00390,null);             
	} // end of initVSButtonbtn00390
	
	
	
	
	
	
	 public void initVSButtonbtn00215() {
	btn00215.setText("002");
	btn00215.setName ("btn00215");
		btn00215.setForeground(Color.black);
		btn00215.setBackground(new Color(0xc6c6c6));
	btn00215.setBounds (-11, 230 , 50, 18);

btn00215.setFont (new Font ("Helvetica", 0, 12));

 	btn00215.setBorderPainted (true);
	btn00215.setDataSourceName("");
	btn00215.setTabOrder(212);
        
      // container is form
add (btn00215,null);             
	} // end of initVSButtonbtn00215
	
	
	
	
	
	
	 public void initVSButtonbtn00115() {
	btn00115.setText("001");
	btn00115.setName ("btn00115");
		btn00115.setForeground(Color.black);
		btn00115.setBackground(new Color(0xc6c6c6));
	btn00115.setBounds (-29, 213 , 50, 18);

btn00115.setFont (new Font ("Helvetica", 0, 12));

 	btn00115.setBorderPainted (true);
	btn00115.setDataSourceName("");
	btn00115.setTabOrder(211);
        
      // container is form
add (btn00115,null);             
	} // end of initVSButtonbtn00115
	
	
	
	
	
	
	 public void initVSButtonbtn0031117() {
	btn0031117.setText("003");
	btn0031117.setName ("btn0031117");
		btn0031117.setForeground(Color.black);
		btn0031117.setBackground(new Color(0xc6c6c6));
	btn0031117.setBounds (110, 326 , 50, 18);

btn0031117.setFont (new Font ("Helvetica", 0, 12));

 	btn0031117.setBorderPainted (true);
	btn0031117.setDataSourceName("");
	btn0031117.setTabOrder(210);
        
      // container is form
add (btn0031117,null);             
	} // end of initVSButtonbtn0031117
	
	
	
	
	
	
	 public void initVSButtonbtn0031014() {
	btn0031014.setText("003");
	btn0031014.setName ("btn0031014");
		btn0031014.setForeground(Color.black);
		btn0031014.setBackground(new Color(0xc6c6c6));
	btn0031014.setBounds (100, 316 , 50, 18);

btn0031014.setFont (new Font ("Helvetica", 0, 12));

 	btn0031014.setBorderPainted (true);
	btn0031014.setDataSourceName("");
	btn0031014.setTabOrder(209);
        
      // container is form
add (btn0031014,null);             
	} // end of initVSButtonbtn0031014
	
	
	
	
	
	
	 public void initVSButtonbtn003914() {
	btn003914.setText("003");
	btn003914.setName ("btn003914");
		btn003914.setForeground(Color.black);
		btn003914.setBackground(new Color(0xc6c6c6));
	btn003914.setBounds (90, 306 , 50, 18);

btn003914.setFont (new Font ("Helvetica", 0, 12));

 	btn003914.setBorderPainted (true);
	btn003914.setDataSourceName("");
	btn003914.setTabOrder(208);
        
      // container is form
add (btn003914,null);             
	} // end of initVSButtonbtn003914
	
	
	
	
	
	
	 public void initVSButtonbtn003814() {
	btn003814.setText("003");
	btn003814.setName ("btn003814");
		btn003814.setForeground(Color.black);
		btn003814.setBackground(new Color(0xc6c6c6));
	btn003814.setBounds (80, 296 , 50, 18);

btn003814.setFont (new Font ("Helvetica", 0, 12));

 	btn003814.setBorderPainted (true);
	btn003814.setDataSourceName("");
	btn003814.setTabOrder(207);
        
      // container is form
add (btn003814,null);             
	} // end of initVSButtonbtn003814
	
	
	
	
	
	
	 public void initVSButtonbtn003714() {
	btn003714.setText("003");
	btn003714.setName ("btn003714");
		btn003714.setForeground(Color.black);
		btn003714.setBackground(new Color(0xc6c6c6));
	btn003714.setBounds (70, 286 , 50, 18);

btn003714.setFont (new Font ("Helvetica", 0, 12));

 	btn003714.setBorderPainted (true);
	btn003714.setDataSourceName("");
	btn003714.setTabOrder(206);
        
      // container is form
add (btn003714,null);             
	} // end of initVSButtonbtn003714
	
	
	
	
	
	
	 public void initVSButtonbtn003614() {
	btn003614.setText("003");
	btn003614.setName ("btn003614");
		btn003614.setForeground(Color.black);
		btn003614.setBackground(new Color(0xc6c6c6));
	btn003614.setBounds (60, 276 , 50, 18);

btn003614.setFont (new Font ("Helvetica", 0, 12));

 	btn003614.setBorderPainted (true);
	btn003614.setDataSourceName("");
	btn003614.setTabOrder(205);
        
      // container is form
add (btn003614,null);             
	} // end of initVSButtonbtn003614
	
	
	
	
	
	
	 public void initVSButtonbtn003514() {
	btn003514.setText("003");
	btn003514.setName ("btn003514");
		btn003514.setForeground(Color.black);
		btn003514.setBackground(new Color(0xc6c6c6));
	btn003514.setBounds (50, 266 , 50, 18);

btn003514.setFont (new Font ("Helvetica", 0, 12));

 	btn003514.setBorderPainted (true);
	btn003514.setDataSourceName("");
	btn003514.setTabOrder(204);
        
      // container is form
add (btn003514,null);             
	} // end of initVSButtonbtn003514
	
	
	
	
	
	
	 public void initVSButtonbtn003414() {
	btn003414.setText("003");
	btn003414.setName ("btn003414");
		btn003414.setForeground(Color.black);
		btn003414.setBackground(new Color(0xc6c6c6));
	btn003414.setBounds (40, 256 , 50, 18);

btn003414.setFont (new Font ("Helvetica", 0, 12));

 	btn003414.setBorderPainted (true);
	btn003414.setDataSourceName("");
	btn003414.setTabOrder(203);
        
      // container is form
add (btn003414,null);             
	} // end of initVSButtonbtn003414
	
	
	
	
	
	
	 public void initVSButtonbtn003315() {
	btn003315.setText("003");
	btn003315.setName ("btn003315");
		btn003315.setForeground(Color.black);
		btn003315.setBackground(new Color(0xc6c6c6));
	btn003315.setBounds (30, 246 , 50, 18);

btn003315.setFont (new Font ("Helvetica", 0, 12));

 	btn003315.setBorderPainted (true);
	btn003315.setDataSourceName("");
	btn003315.setTabOrder(202);
        
      // container is form
add (btn003315,null);             
	} // end of initVSButtonbtn003315
	
	
	
	
	
	
	 public void initVSButtonbtn003216() {
	btn003216.setText("003");
	btn003216.setName ("btn003216");
		btn003216.setForeground(Color.black);
		btn003216.setBackground(new Color(0xc6c6c6));
	btn003216.setBounds (20, 236 , 50, 18);

btn003216.setFont (new Font ("Helvetica", 0, 12));

 	btn003216.setBorderPainted (true);
	btn003216.setDataSourceName("");
	btn003216.setTabOrder(201);
        
      // container is form
add (btn003216,null);             
	} // end of initVSButtonbtn003216
	
	
	
	
	
	
	 public void initVSButtonbtn003126() {
	btn003126.setText("003");
	btn003126.setName ("btn003126");
		btn003126.setForeground(Color.black);
		btn003126.setBackground(new Color(0xc6c6c6));
	btn003126.setBounds (10, 226 , 50, 18);

btn003126.setFont (new Font ("Helvetica", 0, 12));

 	btn003126.setBorderPainted (true);
	btn003126.setDataSourceName("");
	btn003126.setTabOrder(200);
        
      // container is form
add (btn003126,null);             
	} // end of initVSButtonbtn003126
	
	
	
	
	
	
	 public void initVSButtonbtn00380() {
	btn00380.setText("003");
	btn00380.setName ("btn00380");
		btn00380.setForeground(Color.black);
		btn00380.setBackground(new Color(0xc6c6c6));
	btn00380.setBounds (0, 216 , 50, 18);

btn00380.setFont (new Font ("Helvetica", 0, 12));

 	btn00380.setBorderPainted (true);
	btn00380.setDataSourceName("");
	btn00380.setTabOrder(199);
        
      // container is form
add (btn00380,null);             
	} // end of initVSButtonbtn00380
	
	
	
	
	
	
	 public void initVSButtonbtn00214() {
	btn00214.setText("002");
	btn00214.setName ("btn00214");
		btn00214.setForeground(Color.black);
		btn00214.setBackground(new Color(0xc6c6c6));
	btn00214.setBounds (-5, 199 , 50, 18);

btn00214.setFont (new Font ("Helvetica", 0, 12));

 	btn00214.setBorderPainted (true);
	btn00214.setDataSourceName("");
	btn00214.setTabOrder(198);
        
      // container is form
add (btn00214,null);             
	} // end of initVSButtonbtn00214
	
	
	
	
	
	
	 public void initVSButtonbtn00114() {
	btn00114.setText("001");
	btn00114.setName ("btn00114");
		btn00114.setForeground(Color.black);
		btn00114.setBackground(new Color(0xc6c6c6));
	btn00114.setBounds (-23, 182 , 50, 18);

btn00114.setFont (new Font ("Helvetica", 0, 12));

 	btn00114.setBorderPainted (true);
	btn00114.setDataSourceName("");
	btn00114.setTabOrder(197);
        
      // container is form
add (btn00114,null);             
	} // end of initVSButtonbtn00114
	
	
	
	
	
	
	 public void initVSButtonbtn0031116() {
	btn0031116.setText("003");
	btn0031116.setName ("btn0031116");
		btn0031116.setForeground(Color.black);
		btn0031116.setBackground(new Color(0xc6c6c6));
	btn0031116.setBounds (118, 298 , 50, 18);

btn0031116.setFont (new Font ("Helvetica", 0, 12));

 	btn0031116.setBorderPainted (true);
	btn0031116.setDataSourceName("");
	btn0031116.setTabOrder(196);
        
      // container is form
add (btn0031116,null);             
	} // end of initVSButtonbtn0031116
	
	
	
	
	
	
	 public void initVSButtonbtn0031013() {
	btn0031013.setText("003");
	btn0031013.setName ("btn0031013");
		btn0031013.setForeground(Color.black);
		btn0031013.setBackground(new Color(0xc6c6c6));
	btn0031013.setBounds (108, 288 , 50, 18);

btn0031013.setFont (new Font ("Helvetica", 0, 12));

 	btn0031013.setBorderPainted (true);
	btn0031013.setDataSourceName("");
	btn0031013.setTabOrder(195);
        
      // container is form
add (btn0031013,null);             
	} // end of initVSButtonbtn0031013
	
	
	
	
	
	
	 public void initVSButtonbtn003913() {
	btn003913.setText("003");
	btn003913.setName ("btn003913");
		btn003913.setForeground(Color.black);
		btn003913.setBackground(new Color(0xc6c6c6));
	btn003913.setBounds (98, 278 , 50, 18);

btn003913.setFont (new Font ("Helvetica", 0, 12));

 	btn003913.setBorderPainted (true);
	btn003913.setDataSourceName("");
	btn003913.setTabOrder(194);
        
      // container is form
add (btn003913,null);             
	} // end of initVSButtonbtn003913
	
	
	
	
	
	
	 public void initVSButtonbtn003813() {
	btn003813.setText("003");
	btn003813.setName ("btn003813");
		btn003813.setForeground(Color.black);
		btn003813.setBackground(new Color(0xc6c6c6));
	btn003813.setBounds (88, 268 , 50, 18);

btn003813.setFont (new Font ("Helvetica", 0, 12));

 	btn003813.setBorderPainted (true);
	btn003813.setDataSourceName("");
	btn003813.setTabOrder(193);
        
      // container is form
add (btn003813,null);             
	} // end of initVSButtonbtn003813
	
	
	
	
	
	
	 public void initVSButtonbtn003713() {
	btn003713.setText("003");
	btn003713.setName ("btn003713");
		btn003713.setForeground(Color.black);
		btn003713.setBackground(new Color(0xc6c6c6));
	btn003713.setBounds (78, 258 , 50, 18);

btn003713.setFont (new Font ("Helvetica", 0, 12));

 	btn003713.setBorderPainted (true);
	btn003713.setDataSourceName("");
	btn003713.setTabOrder(192);
        
      // container is form
add (btn003713,null);             
	} // end of initVSButtonbtn003713
	
	
	
	
	
	
	 public void initVSButtonbtn003613() {
	btn003613.setText("003");
	btn003613.setName ("btn003613");
		btn003613.setForeground(Color.black);
		btn003613.setBackground(new Color(0xc6c6c6));
	btn003613.setBounds (68, 248 , 50, 18);

btn003613.setFont (new Font ("Helvetica", 0, 12));

 	btn003613.setBorderPainted (true);
	btn003613.setDataSourceName("");
	btn003613.setTabOrder(191);
        
      // container is form
add (btn003613,null);             
	} // end of initVSButtonbtn003613
	
	
	
	
	
	
	 public void initVSButtonbtn003513() {
	btn003513.setText("003");
	btn003513.setName ("btn003513");
		btn003513.setForeground(Color.black);
		btn003513.setBackground(new Color(0xc6c6c6));
	btn003513.setBounds (58, 238 , 50, 18);

btn003513.setFont (new Font ("Helvetica", 0, 12));

 	btn003513.setBorderPainted (true);
	btn003513.setDataSourceName("");
	btn003513.setTabOrder(190);
        
      // container is form
add (btn003513,null);             
	} // end of initVSButtonbtn003513
	
	
	
	
	
	
	 public void initVSButtonbtn003413() {
	btn003413.setText("003");
	btn003413.setName ("btn003413");
		btn003413.setForeground(Color.black);
		btn003413.setBackground(new Color(0xc6c6c6));
	btn003413.setBounds (48, 228 , 50, 18);

btn003413.setFont (new Font ("Helvetica", 0, 12));

 	btn003413.setBorderPainted (true);
	btn003413.setDataSourceName("");
	btn003413.setTabOrder(189);
        
      // container is form
add (btn003413,null);             
	} // end of initVSButtonbtn003413
	
	
	
	
	
	
	 public void initVSButtonbtn003314() {
	btn003314.setText("003");
	btn003314.setName ("btn003314");
		btn003314.setForeground(Color.black);
		btn003314.setBackground(new Color(0xc6c6c6));
	btn003314.setBounds (38, 218 , 50, 18);

btn003314.setFont (new Font ("Helvetica", 0, 12));

 	btn003314.setBorderPainted (true);
	btn003314.setDataSourceName("");
	btn003314.setTabOrder(188);
        
      // container is form
add (btn003314,null);             
	} // end of initVSButtonbtn003314
	
	
	
	
	
	
	 public void initVSButtonbtn003215() {
	btn003215.setText("003");
	btn003215.setName ("btn003215");
		btn003215.setForeground(Color.black);
		btn003215.setBackground(new Color(0xc6c6c6));
	btn003215.setBounds (28, 208 , 50, 18);

btn003215.setFont (new Font ("Helvetica", 0, 12));

 	btn003215.setBorderPainted (true);
	btn003215.setDataSourceName("");
	btn003215.setTabOrder(187);
        
      // container is form
add (btn003215,null);             
	} // end of initVSButtonbtn003215
	
	
	
	
	
	
	 public void initVSButtonbtn003125() {
	btn003125.setText("003");
	btn003125.setName ("btn003125");
		btn003125.setForeground(Color.black);
		btn003125.setBackground(new Color(0xc6c6c6));
	btn003125.setBounds (18, 198 , 50, 18);

btn003125.setFont (new Font ("Helvetica", 0, 12));

 	btn003125.setBorderPainted (true);
	btn003125.setDataSourceName("");
	btn003125.setTabOrder(186);
        
      // container is form
add (btn003125,null);             
	} // end of initVSButtonbtn003125
	
	
	
	
	
	
	 public void initVSButtonbtn00370() {
	btn00370.setText("003");
	btn00370.setName ("btn00370");
		btn00370.setForeground(Color.black);
		btn00370.setBackground(new Color(0xc6c6c6));
	btn00370.setBounds (8, 188 , 50, 18);

btn00370.setFont (new Font ("Helvetica", 0, 12));

 	btn00370.setBorderPainted (true);
	btn00370.setDataSourceName("");
	btn00370.setTabOrder(185);
        
      // container is form
add (btn00370,null);             
	} // end of initVSButtonbtn00370
	
	
	
	
	
	
	 public void initVSButtonbtn00213() {
	btn00213.setText("002");
	btn00213.setName ("btn00213");
		btn00213.setForeground(Color.black);
		btn00213.setBackground(new Color(0xc6c6c6));
	btn00213.setBounds (3, 171 , 50, 18);

btn00213.setFont (new Font ("Helvetica", 0, 12));

 	btn00213.setBorderPainted (true);
	btn00213.setDataSourceName("");
	btn00213.setTabOrder(184);
        
      // container is form
add (btn00213,null);             
	} // end of initVSButtonbtn00213
	
	
	
	
	
	
	 public void initVSButtonbtn00113() {
	btn00113.setText("001");
	btn00113.setName ("btn00113");
		btn00113.setForeground(Color.black);
		btn00113.setBackground(new Color(0xc6c6c6));
	btn00113.setBounds (-15, 154 , 50, 18);

btn00113.setFont (new Font ("Helvetica", 0, 12));

 	btn00113.setBorderPainted (true);
	btn00113.setDataSourceName("");
	btn00113.setTabOrder(183);
        
      // container is form
add (btn00113,null);             
	} // end of initVSButtonbtn00113
	
	
	
	
	
	
	 public void initVSButtonbtn0031115() {
	btn0031115.setText("003");
	btn0031115.setName ("btn0031115");
		btn0031115.setForeground(Color.black);
		btn0031115.setBackground(new Color(0xc6c6c6));
	btn0031115.setBounds (136, 293 , 50, 18);

btn0031115.setFont (new Font ("Helvetica", 0, 12));

 	btn0031115.setBorderPainted (true);
	btn0031115.setDataSourceName("");
	btn0031115.setTabOrder(182);
        
      // container is form
add (btn0031115,null);             
	} // end of initVSButtonbtn0031115
	
	
	
	
	
	
	 public void initVSButtonbtn0031012() {
	btn0031012.setText("003");
	btn0031012.setName ("btn0031012");
		btn0031012.setForeground(Color.black);
		btn0031012.setBackground(new Color(0xc6c6c6));
	btn0031012.setBounds (126, 283 , 50, 18);

btn0031012.setFont (new Font ("Helvetica", 0, 12));

 	btn0031012.setBorderPainted (true);
	btn0031012.setDataSourceName("");
	btn0031012.setTabOrder(181);
        
      // container is form
add (btn0031012,null);             
	} // end of initVSButtonbtn0031012
	
	
	
	
	
	
	 public void initVSButtonbtn003912() {
	btn003912.setText("003");
	btn003912.setName ("btn003912");
		btn003912.setForeground(Color.black);
		btn003912.setBackground(new Color(0xc6c6c6));
	btn003912.setBounds (116, 273 , 50, 18);

btn003912.setFont (new Font ("Helvetica", 0, 12));

 	btn003912.setBorderPainted (true);
	btn003912.setDataSourceName("");
	btn003912.setTabOrder(180);
        
      // container is form
add (btn003912,null);             
	} // end of initVSButtonbtn003912
	
	
	
	
	
	
	 public void initVSButtonbtn003812() {
	btn003812.setText("003");
	btn003812.setName ("btn003812");
		btn003812.setForeground(Color.black);
		btn003812.setBackground(new Color(0xc6c6c6));
	btn003812.setBounds (106, 263 , 50, 18);

btn003812.setFont (new Font ("Helvetica", 0, 12));

 	btn003812.setBorderPainted (true);
	btn003812.setDataSourceName("");
	btn003812.setTabOrder(179);
        
      // container is form
add (btn003812,null);             
	} // end of initVSButtonbtn003812
	
	
	
	
	
	
	 public void initVSButtonbtn003712() {
	btn003712.setText("003");
	btn003712.setName ("btn003712");
		btn003712.setForeground(Color.black);
		btn003712.setBackground(new Color(0xc6c6c6));
	btn003712.setBounds (96, 253 , 50, 18);

btn003712.setFont (new Font ("Helvetica", 0, 12));

 	btn003712.setBorderPainted (true);
	btn003712.setDataSourceName("");
	btn003712.setTabOrder(178);
        
      // container is form
add (btn003712,null);             
	} // end of initVSButtonbtn003712
	
	
	
	
	
	
	 public void initVSButtonbtn003612() {
	btn003612.setText("003");
	btn003612.setName ("btn003612");
		btn003612.setForeground(Color.black);
		btn003612.setBackground(new Color(0xc6c6c6));
	btn003612.setBounds (86, 243 , 50, 18);

btn003612.setFont (new Font ("Helvetica", 0, 12));

 	btn003612.setBorderPainted (true);
	btn003612.setDataSourceName("");
	btn003612.setTabOrder(177);
        
      // container is form
add (btn003612,null);             
	} // end of initVSButtonbtn003612
	
	
	
	
	
	
	 public void initVSButtonbtn003512() {
	btn003512.setText("003");
	btn003512.setName ("btn003512");
		btn003512.setForeground(Color.black);
		btn003512.setBackground(new Color(0xc6c6c6));
	btn003512.setBounds (76, 233 , 50, 18);

btn003512.setFont (new Font ("Helvetica", 0, 12));

 	btn003512.setBorderPainted (true);
	btn003512.setDataSourceName("");
	btn003512.setTabOrder(176);
        
      // container is form
add (btn003512,null);             
	} // end of initVSButtonbtn003512
	
	
	
	
	
	
	 public void initVSButtonbtn003412() {
	btn003412.setText("003");
	btn003412.setName ("btn003412");
		btn003412.setForeground(Color.black);
		btn003412.setBackground(new Color(0xc6c6c6));
	btn003412.setBounds (66, 223 , 50, 18);

btn003412.setFont (new Font ("Helvetica", 0, 12));

 	btn003412.setBorderPainted (true);
	btn003412.setDataSourceName("");
	btn003412.setTabOrder(175);
        
      // container is form
add (btn003412,null);             
	} // end of initVSButtonbtn003412
	
	
	
	
	
	
	 public void initVSButtonbtn003313() {
	btn003313.setText("003");
	btn003313.setName ("btn003313");
		btn003313.setForeground(Color.black);
		btn003313.setBackground(new Color(0xc6c6c6));
	btn003313.setBounds (56, 213 , 50, 18);

btn003313.setFont (new Font ("Helvetica", 0, 12));

 	btn003313.setBorderPainted (true);
	btn003313.setDataSourceName("");
	btn003313.setTabOrder(174);
        
      // container is form
add (btn003313,null);             
	} // end of initVSButtonbtn003313
	
	
	
	
	
	
	 public void initVSButtonbtn003214() {
	btn003214.setText("003");
	btn003214.setName ("btn003214");
		btn003214.setForeground(Color.black);
		btn003214.setBackground(new Color(0xc6c6c6));
	btn003214.setBounds (46, 203 , 50, 18);

btn003214.setFont (new Font ("Helvetica", 0, 12));

 	btn003214.setBorderPainted (true);
	btn003214.setDataSourceName("");
	btn003214.setTabOrder(173);
        
      // container is form
add (btn003214,null);             
	} // end of initVSButtonbtn003214
	
	
	
	
	
	
	 public void initVSButtonbtn003124() {
	btn003124.setText("003");
	btn003124.setName ("btn003124");
		btn003124.setForeground(Color.black);
		btn003124.setBackground(new Color(0xc6c6c6));
	btn003124.setBounds (36, 193 , 50, 18);

btn003124.setFont (new Font ("Helvetica", 0, 12));

 	btn003124.setBorderPainted (true);
	btn003124.setDataSourceName("");
	btn003124.setTabOrder(172);
        
      // container is form
add (btn003124,null);             
	} // end of initVSButtonbtn003124
	
	
	
	
	
	
	 public void initVSButtonbtn00360() {
	btn00360.setText("003");
	btn00360.setName ("btn00360");
		btn00360.setForeground(Color.black);
		btn00360.setBackground(new Color(0xc6c6c6));
	btn00360.setBounds (26, 183 , 50, 18);

btn00360.setFont (new Font ("Helvetica", 0, 12));

 	btn00360.setBorderPainted (true);
	btn00360.setDataSourceName("");
	btn00360.setTabOrder(171);
        
      // container is form
add (btn00360,null);             
	} // end of initVSButtonbtn00360
	
	
	
	
	
	
	 public void initVSButtonbtn00212() {
	btn00212.setText("002");
	btn00212.setName ("btn00212");
		btn00212.setForeground(Color.black);
		btn00212.setBackground(new Color(0xc6c6c6));
	btn00212.setBounds (21, 166 , 50, 18);

btn00212.setFont (new Font ("Helvetica", 0, 12));

 	btn00212.setBorderPainted (true);
	btn00212.setDataSourceName("");
	btn00212.setTabOrder(170);
        
      // container is form
add (btn00212,null);             
	} // end of initVSButtonbtn00212
	
	
	
	
	
	
	 public void initVSButtonbtn00112() {
	btn00112.setText("001");
	btn00112.setName ("btn00112");
		btn00112.setForeground(Color.black);
		btn00112.setBackground(new Color(0xc6c6c6));
	btn00112.setBounds (3, 149 , 50, 18);

btn00112.setFont (new Font ("Helvetica", 0, 12));

 	btn00112.setBorderPainted (true);
	btn00112.setDataSourceName("");
	btn00112.setTabOrder(169);
        
      // container is form
add (btn00112,null);             
	} // end of initVSButtonbtn00112
	
	
	
	
	
	
	 public void initVSButtonbtn0031114() {
	btn0031114.setText("003");
	btn0031114.setName ("btn0031114");
		btn0031114.setForeground(Color.black);
		btn0031114.setBackground(new Color(0xc6c6c6));
	btn0031114.setBounds (118, 244 , 50, 18);

btn0031114.setFont (new Font ("Helvetica", 0, 12));

 	btn0031114.setBorderPainted (true);
	btn0031114.setDataSourceName("");
	btn0031114.setTabOrder(168);
        
      // container is form
add (btn0031114,null);             
	} // end of initVSButtonbtn0031114
	
	
	
	
	
	
	 public void initVSButtonbtn0031011() {
	btn0031011.setText("003");
	btn0031011.setName ("btn0031011");
		btn0031011.setForeground(Color.black);
		btn0031011.setBackground(new Color(0xc6c6c6));
	btn0031011.setBounds (108, 234 , 50, 18);

btn0031011.setFont (new Font ("Helvetica", 0, 12));

 	btn0031011.setBorderPainted (true);
	btn0031011.setDataSourceName("");
	btn0031011.setTabOrder(167);
        
      // container is form
add (btn0031011,null);             
	} // end of initVSButtonbtn0031011
	
	
	
	
	
	
	 public void initVSButtonbtn003911() {
	btn003911.setText("003");
	btn003911.setName ("btn003911");
		btn003911.setForeground(Color.black);
		btn003911.setBackground(new Color(0xc6c6c6));
	btn003911.setBounds (98, 224 , 50, 18);

btn003911.setFont (new Font ("Helvetica", 0, 12));

 	btn003911.setBorderPainted (true);
	btn003911.setDataSourceName("");
	btn003911.setTabOrder(166);
        
      // container is form
add (btn003911,null);             
	} // end of initVSButtonbtn003911
	
	
	
	
	
	
	 public void initVSButtonbtn003811() {
	btn003811.setText("003");
	btn003811.setName ("btn003811");
		btn003811.setForeground(Color.black);
		btn003811.setBackground(new Color(0xc6c6c6));
	btn003811.setBounds (88, 214 , 50, 18);

btn003811.setFont (new Font ("Helvetica", 0, 12));

 	btn003811.setBorderPainted (true);
	btn003811.setDataSourceName("");
	btn003811.setTabOrder(165);
        
      // container is form
add (btn003811,null);             
	} // end of initVSButtonbtn003811
	
	
	
	
	
	
	 public void initVSButtonbtn003711() {
	btn003711.setText("003");
	btn003711.setName ("btn003711");
		btn003711.setForeground(Color.black);
		btn003711.setBackground(new Color(0xc6c6c6));
	btn003711.setBounds (78, 204 , 50, 18);

btn003711.setFont (new Font ("Helvetica", 0, 12));

 	btn003711.setBorderPainted (true);
	btn003711.setDataSourceName("");
	btn003711.setTabOrder(164);
        
      // container is form
add (btn003711,null);             
	} // end of initVSButtonbtn003711
	
	
	
	
	
	
	 public void initVSButtonbtn003611() {
	btn003611.setText("003");
	btn003611.setName ("btn003611");
		btn003611.setForeground(Color.black);
		btn003611.setBackground(new Color(0xc6c6c6));
	btn003611.setBounds (68, 194 , 50, 18);

btn003611.setFont (new Font ("Helvetica", 0, 12));

 	btn003611.setBorderPainted (true);
	btn003611.setDataSourceName("");
	btn003611.setTabOrder(163);
        
      // container is form
add (btn003611,null);             
	} // end of initVSButtonbtn003611
	
	
	
	
	
	
	 public void initVSButtonbtn003511() {
	btn003511.setText("003");
	btn003511.setName ("btn003511");
		btn003511.setForeground(Color.black);
		btn003511.setBackground(new Color(0xc6c6c6));
	btn003511.setBounds (58, 184 , 50, 18);

btn003511.setFont (new Font ("Helvetica", 0, 12));

 	btn003511.setBorderPainted (true);
	btn003511.setDataSourceName("");
	btn003511.setTabOrder(162);
        
      // container is form
add (btn003511,null);             
	} // end of initVSButtonbtn003511
	
	
	
	
	
	
	 public void initVSButtonbtn003411() {
	btn003411.setText("003");
	btn003411.setName ("btn003411");
		btn003411.setForeground(Color.black);
		btn003411.setBackground(new Color(0xc6c6c6));
	btn003411.setBounds (48, 174 , 50, 18);

btn003411.setFont (new Font ("Helvetica", 0, 12));

 	btn003411.setBorderPainted (true);
	btn003411.setDataSourceName("");
	btn003411.setTabOrder(161);
        
      // container is form
add (btn003411,null);             
	} // end of initVSButtonbtn003411
	
	
	
	
	
	
	 public void initVSButtonbtn003312() {
	btn003312.setText("003");
	btn003312.setName ("btn003312");
		btn003312.setForeground(Color.black);
		btn003312.setBackground(new Color(0xc6c6c6));
	btn003312.setBounds (38, 164 , 50, 18);

btn003312.setFont (new Font ("Helvetica", 0, 12));

 	btn003312.setBorderPainted (true);
	btn003312.setDataSourceName("");
	btn003312.setTabOrder(160);
        
      // container is form
add (btn003312,null);             
	} // end of initVSButtonbtn003312
	
	
	
	
	
	
	 public void initVSButtonbtn003213() {
	btn003213.setText("003");
	btn003213.setName ("btn003213");
		btn003213.setForeground(Color.black);
		btn003213.setBackground(new Color(0xc6c6c6));
	btn003213.setBounds (28, 154 , 50, 18);

btn003213.setFont (new Font ("Helvetica", 0, 12));

 	btn003213.setBorderPainted (true);
	btn003213.setDataSourceName("");
	btn003213.setTabOrder(159);
        
      // container is form
add (btn003213,null);             
	} // end of initVSButtonbtn003213
	
	
	
	
	
	
	 public void initVSButtonbtn003123() {
	btn003123.setText("003");
	btn003123.setName ("btn003123");
		btn003123.setForeground(Color.black);
		btn003123.setBackground(new Color(0xc6c6c6));
	btn003123.setBounds (18, 144 , 50, 18);

btn003123.setFont (new Font ("Helvetica", 0, 12));

 	btn003123.setBorderPainted (true);
	btn003123.setDataSourceName("");
	btn003123.setTabOrder(158);
        
      // container is form
add (btn003123,null);             
	} // end of initVSButtonbtn003123
	
	
	
	
	
	
	 public void initVSButtonbtn00350() {
	btn00350.setText("003");
	btn00350.setName ("btn00350");
		btn00350.setForeground(Color.black);
		btn00350.setBackground(new Color(0xc6c6c6));
	btn00350.setBounds (8, 134 , 50, 18);

btn00350.setFont (new Font ("Helvetica", 0, 12));

 	btn00350.setBorderPainted (true);
	btn00350.setDataSourceName("");
	btn00350.setTabOrder(157);
        
      // container is form
add (btn00350,null);             
	} // end of initVSButtonbtn00350
	
	
	
	
	
	
	 public void initVSButtonbtn00211() {
	btn00211.setText("002");
	btn00211.setName ("btn00211");
		btn00211.setForeground(Color.black);
		btn00211.setBackground(new Color(0xc6c6c6));
	btn00211.setBounds (3, 117 , 50, 18);

btn00211.setFont (new Font ("Helvetica", 0, 12));

 	btn00211.setBorderPainted (true);
	btn00211.setDataSourceName("");
	btn00211.setTabOrder(156);
        
      // container is form
add (btn00211,null);             
	} // end of initVSButtonbtn00211
	
	
	
	
	
	
	 public void initVSButtonbtn00111() {
	btn00111.setText("001");
	btn00111.setName ("btn00111");
		btn00111.setForeground(Color.black);
		btn00111.setBackground(new Color(0xc6c6c6));
	btn00111.setBounds (-15, 100 , 50, 18);

btn00111.setFont (new Font ("Helvetica", 0, 12));

 	btn00111.setBorderPainted (true);
	btn00111.setDataSourceName("");
	btn00111.setTabOrder(155);
        
      // container is form
add (btn00111,null);             
	} // end of initVSButtonbtn00111
	
	
	
	
	
	
	 public void initVSButtonbtn0031113() {
	btn0031113.setText("003");
	btn0031113.setName ("btn0031113");
		btn0031113.setForeground(Color.black);
		btn0031113.setBackground(new Color(0xc6c6c6));
	btn0031113.setBounds (128, 217 , 50, 18);

btn0031113.setFont (new Font ("Helvetica", 0, 12));

 	btn0031113.setBorderPainted (true);
	btn0031113.setDataSourceName("");
	btn0031113.setTabOrder(154);
        
      // container is form
add (btn0031113,null);             
	} // end of initVSButtonbtn0031113
	
	
	
	
	
	
	 public void initVSButtonbtn0031010() {
	btn0031010.setText("003");
	btn0031010.setName ("btn0031010");
		btn0031010.setForeground(Color.black);
		btn0031010.setBackground(new Color(0xc6c6c6));
	btn0031010.setBounds (118, 207 , 50, 18);

btn0031010.setFont (new Font ("Helvetica", 0, 12));

 	btn0031010.setBorderPainted (true);
	btn0031010.setDataSourceName("");
	btn0031010.setTabOrder(153);
        
      // container is form
add (btn0031010,null);             
	} // end of initVSButtonbtn0031010
	
	
	
	
	
	
	 public void initVSButtonbtn003910() {
	btn003910.setText("003");
	btn003910.setName ("btn003910");
		btn003910.setForeground(Color.black);
		btn003910.setBackground(new Color(0xc6c6c6));
	btn003910.setBounds (108, 197 , 50, 18);

btn003910.setFont (new Font ("Helvetica", 0, 12));

 	btn003910.setBorderPainted (true);
	btn003910.setDataSourceName("");
	btn003910.setTabOrder(152);
        
      // container is form
add (btn003910,null);             
	} // end of initVSButtonbtn003910
	
	
	
	
	
	
	 public void initVSButtonbtn003810() {
	btn003810.setText("003");
	btn003810.setName ("btn003810");
		btn003810.setForeground(Color.black);
		btn003810.setBackground(new Color(0xc6c6c6));
	btn003810.setBounds (98, 187 , 50, 18);

btn003810.setFont (new Font ("Helvetica", 0, 12));

 	btn003810.setBorderPainted (true);
	btn003810.setDataSourceName("");
	btn003810.setTabOrder(151);
        
      // container is form
add (btn003810,null);             
	} // end of initVSButtonbtn003810
	
	
	
	
	
	
	 public void initVSButtonbtn003710() {
	btn003710.setText("003");
	btn003710.setName ("btn003710");
		btn003710.setForeground(Color.black);
		btn003710.setBackground(new Color(0xc6c6c6));
	btn003710.setBounds (88, 177 , 50, 18);

btn003710.setFont (new Font ("Helvetica", 0, 12));

 	btn003710.setBorderPainted (true);
	btn003710.setDataSourceName("");
	btn003710.setTabOrder(150);
        
      // container is form
add (btn003710,null);             
	} // end of initVSButtonbtn003710
	
	
	
	
	
	
	 public void initVSButtonbtn003610() {
	btn003610.setText("003");
	btn003610.setName ("btn003610");
		btn003610.setForeground(Color.black);
		btn003610.setBackground(new Color(0xc6c6c6));
	btn003610.setBounds (78, 167 , 50, 18);

btn003610.setFont (new Font ("Helvetica", 0, 12));

 	btn003610.setBorderPainted (true);
	btn003610.setDataSourceName("");
	btn003610.setTabOrder(149);
        
      // container is form
add (btn003610,null);             
	} // end of initVSButtonbtn003610
	
	
	
	
	
	
	 public void initVSButtonbtn003510() {
	btn003510.setText("003");
	btn003510.setName ("btn003510");
		btn003510.setForeground(Color.black);
		btn003510.setBackground(new Color(0xc6c6c6));
	btn003510.setBounds (68, 157 , 50, 18);

btn003510.setFont (new Font ("Helvetica", 0, 12));

 	btn003510.setBorderPainted (true);
	btn003510.setDataSourceName("");
	btn003510.setTabOrder(148);
        
      // container is form
add (btn003510,null);             
	} // end of initVSButtonbtn003510
	
	
	
	
	
	
	 public void initVSButtonbtn003410() {
	btn003410.setText("003");
	btn003410.setName ("btn003410");
		btn003410.setForeground(Color.black);
		btn003410.setBackground(new Color(0xc6c6c6));
	btn003410.setBounds (58, 147 , 50, 18);

btn003410.setFont (new Font ("Helvetica", 0, 12));

 	btn003410.setBorderPainted (true);
	btn003410.setDataSourceName("");
	btn003410.setTabOrder(147);
        
      // container is form
add (btn003410,null);             
	} // end of initVSButtonbtn003410
	
	
	
	
	
	
	 public void initVSButtonbtn003311() {
	btn003311.setText("003");
	btn003311.setName ("btn003311");
		btn003311.setForeground(Color.black);
		btn003311.setBackground(new Color(0xc6c6c6));
	btn003311.setBounds (48, 137 , 50, 18);

btn003311.setFont (new Font ("Helvetica", 0, 12));

 	btn003311.setBorderPainted (true);
	btn003311.setDataSourceName("");
	btn003311.setTabOrder(146);
        
      // container is form
add (btn003311,null);             
	} // end of initVSButtonbtn003311
	
	
	
	
	
	
	 public void initVSButtonbtn003212() {
	btn003212.setText("003");
	btn003212.setName ("btn003212");
		btn003212.setForeground(Color.black);
		btn003212.setBackground(new Color(0xc6c6c6));
	btn003212.setBounds (38, 127 , 50, 18);

btn003212.setFont (new Font ("Helvetica", 0, 12));

 	btn003212.setBorderPainted (true);
	btn003212.setDataSourceName("");
	btn003212.setTabOrder(145);
        
      // container is form
add (btn003212,null);             
	} // end of initVSButtonbtn003212
	
	
	
	
	
	
	 public void initVSButtonbtn003122() {
	btn003122.setText("003");
	btn003122.setName ("btn003122");
		btn003122.setForeground(Color.black);
		btn003122.setBackground(new Color(0xc6c6c6));
	btn003122.setBounds (28, 117 , 50, 18);

btn003122.setFont (new Font ("Helvetica", 0, 12));

 	btn003122.setBorderPainted (true);
	btn003122.setDataSourceName("");
	btn003122.setTabOrder(144);
        
      // container is form
add (btn003122,null);             
	} // end of initVSButtonbtn003122
	
	
	
	
	
	
	 public void initVSButtonbtn00340() {
	btn00340.setText("003");
	btn00340.setName ("btn00340");
		btn00340.setForeground(Color.black);
		btn00340.setBackground(new Color(0xc6c6c6));
	btn00340.setBounds (18, 107 , 50, 18);

btn00340.setFont (new Font ("Helvetica", 0, 12));

 	btn00340.setBorderPainted (true);
	btn00340.setDataSourceName("");
	btn00340.setTabOrder(143);
        
      // container is form
add (btn00340,null);             
	} // end of initVSButtonbtn00340
	
	
	
	
	
	
	 public void initVSButtonbtn00210() {
	btn00210.setText("002");
	btn00210.setName ("btn00210");
		btn00210.setForeground(Color.black);
		btn00210.setBackground(new Color(0xc6c6c6));
	btn00210.setBounds (13, 90 , 50, 18);

btn00210.setFont (new Font ("Helvetica", 0, 12));

 	btn00210.setBorderPainted (true);
	btn00210.setDataSourceName("");
	btn00210.setTabOrder(142);
        
      // container is form
add (btn00210,null);             
	} // end of initVSButtonbtn00210
	
	
	
	
	
	
	 public void initVSButtonbtn00110() {
	btn00110.setText("001");
	btn00110.setName ("btn00110");
		btn00110.setForeground(Color.black);
		btn00110.setBackground(new Color(0xc6c6c6));
	btn00110.setBounds (-5, 73 , 50, 18);

btn00110.setFont (new Font ("Helvetica", 0, 12));

 	btn00110.setBorderPainted (true);
	btn00110.setDataSourceName("");
	btn00110.setTabOrder(141);
        
      // container is form
add (btn00110,null);             
	} // end of initVSButtonbtn00110
	
	
	
	
	
	
	 public void initVSButtonbtn0031112() {
	btn0031112.setText("003");
	btn0031112.setName ("btn0031112");
		btn0031112.setForeground(Color.black);
		btn0031112.setBackground(new Color(0xc6c6c6));
	btn0031112.setBounds (521, 150 , 50, 18);

btn0031112.setFont (new Font ("Helvetica", 0, 12));

 	btn0031112.setBorderPainted (true);
	btn0031112.setDataSourceName("");
	btn0031112.setTabOrder(140);
        
      // container is form
add (btn0031112,null);             
	} // end of initVSButtonbtn0031112
	
	
	
	
	
	
	 public void initVSButtonbtn003109() {
	btn003109.setText("003");
	btn003109.setName ("btn003109");
		btn003109.setForeground(Color.black);
		btn003109.setBackground(new Color(0xc6c6c6));
	btn003109.setBounds (511, 140 , 50, 18);

btn003109.setFont (new Font ("Helvetica", 0, 12));

 	btn003109.setBorderPainted (true);
	btn003109.setDataSourceName("");
	btn003109.setTabOrder(139);
        
      // container is form
add (btn003109,null);             
	} // end of initVSButtonbtn003109
	
	
	
	
	
	
	 public void initVSButtonbtn00399() {
	btn00399.setText("003");
	btn00399.setName ("btn00399");
		btn00399.setForeground(Color.black);
		btn00399.setBackground(new Color(0xc6c6c6));
	btn00399.setBounds (501, 130 , 50, 18);

btn00399.setFont (new Font ("Helvetica", 0, 12));

 	btn00399.setBorderPainted (true);
	btn00399.setDataSourceName("");
	btn00399.setTabOrder(138);
        
      // container is form
add (btn00399,null);             
	} // end of initVSButtonbtn00399
	
	
	
	
	
	
	 public void initVSButtonbtn00389() {
	btn00389.setText("003");
	btn00389.setName ("btn00389");
		btn00389.setForeground(Color.black);
		btn00389.setBackground(new Color(0xc6c6c6));
	btn00389.setBounds (491, 120 , 50, 18);

btn00389.setFont (new Font ("Helvetica", 0, 12));

 	btn00389.setBorderPainted (true);
	btn00389.setDataSourceName("");
	btn00389.setTabOrder(137);
        
      // container is form
add (btn00389,null);             
	} // end of initVSButtonbtn00389
	
	
	
	
	
	
	 public void initVSButtonbtn00379() {
	btn00379.setText("003");
	btn00379.setName ("btn00379");
		btn00379.setForeground(Color.black);
		btn00379.setBackground(new Color(0xc6c6c6));
	btn00379.setBounds (481, 110 , 50, 18);

btn00379.setFont (new Font ("Helvetica", 0, 12));

 	btn00379.setBorderPainted (true);
	btn00379.setDataSourceName("");
	btn00379.setTabOrder(136);
        
      // container is form
add (btn00379,null);             
	} // end of initVSButtonbtn00379
	
	
	
	
	
	
	 public void initVSButtonbtn00369() {
	btn00369.setText("003");
	btn00369.setName ("btn00369");
		btn00369.setForeground(Color.black);
		btn00369.setBackground(new Color(0xc6c6c6));
	btn00369.setBounds (471, 100 , 50, 18);

btn00369.setFont (new Font ("Helvetica", 0, 12));

 	btn00369.setBorderPainted (true);
	btn00369.setDataSourceName("");
	btn00369.setTabOrder(135);
        
      // container is form
add (btn00369,null);             
	} // end of initVSButtonbtn00369
	
	
	
	
	
	
	 public void initVSButtonbtn00359() {
	btn00359.setText("003");
	btn00359.setName ("btn00359");
		btn00359.setForeground(Color.black);
		btn00359.setBackground(new Color(0xc6c6c6));
	btn00359.setBounds (461, 90 , 50, 18);

btn00359.setFont (new Font ("Helvetica", 0, 12));

 	btn00359.setBorderPainted (true);
	btn00359.setDataSourceName("");
	btn00359.setTabOrder(134);
        
      // container is form
add (btn00359,null);             
	} // end of initVSButtonbtn00359
	
	
	
	
	
	
	 public void initVSButtonbtn00349() {
	btn00349.setText("003");
	btn00349.setName ("btn00349");
		btn00349.setForeground(Color.black);
		btn00349.setBackground(new Color(0xc6c6c6));
	btn00349.setBounds (451, 80 , 50, 18);

btn00349.setFont (new Font ("Helvetica", 0, 12));

 	btn00349.setBorderPainted (true);
	btn00349.setDataSourceName("");
	btn00349.setTabOrder(133);
        
      // container is form
add (btn00349,null);             
	} // end of initVSButtonbtn00349
	
	
	
	
	
	
	 public void initVSButtonbtn003310() {
	btn003310.setText("003");
	btn003310.setName ("btn003310");
		btn003310.setForeground(Color.black);
		btn003310.setBackground(new Color(0xc6c6c6));
	btn003310.setBounds (441, 70 , 50, 18);

btn003310.setFont (new Font ("Helvetica", 0, 12));

 	btn003310.setBorderPainted (true);
	btn003310.setDataSourceName("");
	btn003310.setTabOrder(132);
        
      // container is form
add (btn003310,null);             
	} // end of initVSButtonbtn003310
	
	
	
	
	
	
	 public void initVSButtonbtn003211() {
	btn003211.setText("003");
	btn003211.setName ("btn003211");
		btn003211.setForeground(Color.black);
		btn003211.setBackground(new Color(0xc6c6c6));
	btn003211.setBounds (431, 60 , 50, 18);

btn003211.setFont (new Font ("Helvetica", 0, 12));

 	btn003211.setBorderPainted (true);
	btn003211.setDataSourceName("");
	btn003211.setTabOrder(131);
        
      // container is form
add (btn003211,null);             
	} // end of initVSButtonbtn003211
	
	
	
	
	
	
	 public void initVSButtonbtn003121() {
	btn003121.setText("003");
	btn003121.setName ("btn003121");
		btn003121.setForeground(Color.black);
		btn003121.setBackground(new Color(0xc6c6c6));
	btn003121.setBounds (421, 50 , 50, 18);

btn003121.setFont (new Font ("Helvetica", 0, 12));

 	btn003121.setBorderPainted (true);
	btn003121.setDataSourceName("");
	btn003121.setTabOrder(130);
        
      // container is form
add (btn003121,null);             
	} // end of initVSButtonbtn003121
	
	
	
	
	
	
	 public void initVSButtonbtn00339() {
	btn00339.setText("003");
	btn00339.setName ("btn00339");
		btn00339.setForeground(Color.black);
		btn00339.setBackground(new Color(0xc6c6c6));
	btn00339.setBounds (411, 40 , 50, 18);

btn00339.setFont (new Font ("Helvetica", 0, 12));

 	btn00339.setBorderPainted (true);
	btn00339.setDataSourceName("");
	btn00339.setTabOrder(129);
        
      // container is form
add (btn00339,null);             
	} // end of initVSButtonbtn00339
	
	
	
	
	
	
	 public void initVSButtonbtn0029() {
	btn0029.setText("002");
	btn0029.setName ("btn0029");
		btn0029.setForeground(Color.black);
		btn0029.setBackground(new Color(0xc6c6c6));
	btn0029.setBounds (406, 23 , 50, 18);

btn0029.setFont (new Font ("Helvetica", 0, 12));

 	btn0029.setBorderPainted (true);
	btn0029.setDataSourceName("");
	btn0029.setTabOrder(128);
        
      // container is form
add (btn0029,null);             
	} // end of initVSButtonbtn0029
	
	
	
	
	
	
	 public void initVSButtonbtn0019() {
	btn0019.setText("001");
	btn0019.setName ("btn0019");
		btn0019.setForeground(Color.black);
		btn0019.setBackground(new Color(0xc6c6c6));
	btn0019.setBounds (388, 6 , 50, 18);

btn0019.setFont (new Font ("Helvetica", 0, 12));

 	btn0019.setBorderPainted (true);
	btn0019.setDataSourceName("");
	btn0019.setTabOrder(127);
        
      // container is form
add (btn0019,null);             
	} // end of initVSButtonbtn0019
	
	
	
	
	
	
	 public void initVSButtonbtn0031111() {
	btn0031111.setText("003");
	btn0031111.setName ("btn0031111");
		btn0031111.setForeground(Color.black);
		btn0031111.setBackground(new Color(0xc6c6c6));
	btn0031111.setBounds (482, 150 , 50, 18);

btn0031111.setFont (new Font ("Helvetica", 0, 12));

 	btn0031111.setBorderPainted (true);
	btn0031111.setDataSourceName("");
	btn0031111.setTabOrder(126);
        
      // container is form
add (btn0031111,null);             
	} // end of initVSButtonbtn0031111
	
	
	
	
	
	
	 public void initVSButtonbtn003108() {
	btn003108.setText("003");
	btn003108.setName ("btn003108");
		btn003108.setForeground(Color.black);
		btn003108.setBackground(new Color(0xc6c6c6));
	btn003108.setBounds (472, 140 , 50, 18);

btn003108.setFont (new Font ("Helvetica", 0, 12));

 	btn003108.setBorderPainted (true);
	btn003108.setDataSourceName("");
	btn003108.setTabOrder(125);
        
      // container is form
add (btn003108,null);             
	} // end of initVSButtonbtn003108
	
	
	
	
	
	
	 public void initVSButtonbtn00398() {
	btn00398.setText("003");
	btn00398.setName ("btn00398");
		btn00398.setForeground(Color.black);
		btn00398.setBackground(new Color(0xc6c6c6));
	btn00398.setBounds (462, 130 , 50, 18);

btn00398.setFont (new Font ("Helvetica", 0, 12));

 	btn00398.setBorderPainted (true);
	btn00398.setDataSourceName("");
	btn00398.setTabOrder(124);
        
      // container is form
add (btn00398,null);             
	} // end of initVSButtonbtn00398
	
	
	
	
	
	
	 public void initVSButtonbtn00388() {
	btn00388.setText("003");
	btn00388.setName ("btn00388");
		btn00388.setForeground(Color.black);
		btn00388.setBackground(new Color(0xc6c6c6));
	btn00388.setBounds (452, 120 , 50, 18);

btn00388.setFont (new Font ("Helvetica", 0, 12));

 	btn00388.setBorderPainted (true);
	btn00388.setDataSourceName("");
	btn00388.setTabOrder(123);
        
      // container is form
add (btn00388,null);             
	} // end of initVSButtonbtn00388
	
	
	
	
	
	
	 public void initVSButtonbtn00378() {
	btn00378.setText("003");
	btn00378.setName ("btn00378");
		btn00378.setForeground(Color.black);
		btn00378.setBackground(new Color(0xc6c6c6));
	btn00378.setBounds (442, 110 , 50, 18);

btn00378.setFont (new Font ("Helvetica", 0, 12));

 	btn00378.setBorderPainted (true);
	btn00378.setDataSourceName("");
	btn00378.setTabOrder(122);
        
      // container is form
add (btn00378,null);             
	} // end of initVSButtonbtn00378
	
	
	
	
	
	
	 public void initVSButtonbtn00368() {
	btn00368.setText("003");
	btn00368.setName ("btn00368");
		btn00368.setForeground(Color.black);
		btn00368.setBackground(new Color(0xc6c6c6));
	btn00368.setBounds (432, 100 , 50, 18);

btn00368.setFont (new Font ("Helvetica", 0, 12));

 	btn00368.setBorderPainted (true);
	btn00368.setDataSourceName("");
	btn00368.setTabOrder(121);
        
      // container is form
add (btn00368,null);             
	} // end of initVSButtonbtn00368
	
	
	
	
	
	
	 public void initVSButtonbtn00358() {
	btn00358.setText("003");
	btn00358.setName ("btn00358");
		btn00358.setForeground(Color.black);
		btn00358.setBackground(new Color(0xc6c6c6));
	btn00358.setBounds (422, 90 , 50, 18);

btn00358.setFont (new Font ("Helvetica", 0, 12));

 	btn00358.setBorderPainted (true);
	btn00358.setDataSourceName("");
	btn00358.setTabOrder(120);
        
      // container is form
add (btn00358,null);             
	} // end of initVSButtonbtn00358
	
	
	
	
	
	
	 public void initVSButtonbtn00348() {
	btn00348.setText("003");
	btn00348.setName ("btn00348");
		btn00348.setForeground(Color.black);
		btn00348.setBackground(new Color(0xc6c6c6));
	btn00348.setBounds (412, 80 , 50, 18);

btn00348.setFont (new Font ("Helvetica", 0, 12));

 	btn00348.setBorderPainted (true);
	btn00348.setDataSourceName("");
	btn00348.setTabOrder(119);
        
      // container is form
add (btn00348,null);             
	} // end of initVSButtonbtn00348
	
	
	
	
	
	
	 public void initVSButtonbtn00338() {
	btn00338.setText("003");
	btn00338.setName ("btn00338");
		btn00338.setForeground(Color.black);
		btn00338.setBackground(new Color(0xc6c6c6));
	btn00338.setBounds (402, 70 , 50, 18);

btn00338.setFont (new Font ("Helvetica", 0, 12));

 	btn00338.setBorderPainted (true);
	btn00338.setDataSourceName("");
	btn00338.setTabOrder(118);
        
      // container is form
add (btn00338,null);             
	} // end of initVSButtonbtn00338
	
	
	
	
	
	
	 public void initVSButtonbtn003210() {
	btn003210.setText("003");
	btn003210.setName ("btn003210");
		btn003210.setForeground(Color.black);
		btn003210.setBackground(new Color(0xc6c6c6));
	btn003210.setBounds (392, 60 , 50, 18);

btn003210.setFont (new Font ("Helvetica", 0, 12));

 	btn003210.setBorderPainted (true);
	btn003210.setDataSourceName("");
	btn003210.setTabOrder(117);
        
      // container is form
add (btn003210,null);             
	} // end of initVSButtonbtn003210
	
	
	
	
	
	
	 public void initVSButtonbtn003120() {
	btn003120.setText("003");
	btn003120.setName ("btn003120");
		btn003120.setForeground(Color.black);
		btn003120.setBackground(new Color(0xc6c6c6));
	btn003120.setBounds (382, 50 , 50, 18);

btn003120.setFont (new Font ("Helvetica", 0, 12));

 	btn003120.setBorderPainted (true);
	btn003120.setDataSourceName("");
	btn003120.setTabOrder(116);
        
      // container is form
add (btn003120,null);             
	} // end of initVSButtonbtn003120
	
	
	
	
	
	
	 public void initVSButtonbtn00330() {
	btn00330.setText("003");
	btn00330.setName ("btn00330");
		btn00330.setForeground(Color.black);
		btn00330.setBackground(new Color(0xc6c6c6));
	btn00330.setBounds (372, 40 , 50, 18);

btn00330.setFont (new Font ("Helvetica", 0, 12));

 	btn00330.setBorderPainted (true);
	btn00330.setDataSourceName("");
	btn00330.setTabOrder(115);
        
      // container is form
add (btn00330,null);             
	} // end of initVSButtonbtn00330
	
	
	
	
	
	
	 public void initVSButtonbtn0028() {
	btn0028.setText("002");
	btn0028.setName ("btn0028");
		btn0028.setForeground(Color.black);
		btn0028.setBackground(new Color(0xc6c6c6));
	btn0028.setBounds (367, 23 , 50, 18);

btn0028.setFont (new Font ("Helvetica", 0, 12));

 	btn0028.setBorderPainted (true);
	btn0028.setDataSourceName("");
	btn0028.setTabOrder(114);
        
      // container is form
add (btn0028,null);             
	} // end of initVSButtonbtn0028
	
	
	
	
	
	
	 public void initVSButtonbtn0018() {
	btn0018.setText("001");
	btn0018.setName ("btn0018");
		btn0018.setForeground(Color.black);
		btn0018.setBackground(new Color(0xc6c6c6));
	btn0018.setBounds (349, 6 , 50, 18);

btn0018.setFont (new Font ("Helvetica", 0, 12));

 	btn0018.setBorderPainted (true);
	btn0018.setDataSourceName("");
	btn0018.setTabOrder(113);
        
      // container is form
add (btn0018,null);             
	} // end of initVSButtonbtn0018
	
	
	
	
	
	
	 public void initVSButtonbtn0031110() {
	btn0031110.setText("003");
	btn0031110.setName ("btn0031110");
		btn0031110.setForeground(Color.black);
		btn0031110.setBackground(new Color(0xc6c6c6));
	btn0031110.setBounds (450, 149 , 50, 18);

btn0031110.setFont (new Font ("Helvetica", 0, 12));

 	btn0031110.setBorderPainted (true);
	btn0031110.setDataSourceName("");
	btn0031110.setTabOrder(112);
        
      // container is form
add (btn0031110,null);             
	} // end of initVSButtonbtn0031110
	
	
	
	
	
	
	 public void initVSButtonbtn003107() {
	btn003107.setText("003");
	btn003107.setName ("btn003107");
		btn003107.setForeground(Color.black);
		btn003107.setBackground(new Color(0xc6c6c6));
	btn003107.setBounds (440, 139 , 50, 18);

btn003107.setFont (new Font ("Helvetica", 0, 12));

 	btn003107.setBorderPainted (true);
	btn003107.setDataSourceName("");
	btn003107.setTabOrder(111);
        
      // container is form
add (btn003107,null);             
	} // end of initVSButtonbtn003107
	
	
	
	
	
	
	 public void initVSButtonbtn00397() {
	btn00397.setText("003");
	btn00397.setName ("btn00397");
		btn00397.setForeground(Color.black);
		btn00397.setBackground(new Color(0xc6c6c6));
	btn00397.setBounds (430, 129 , 50, 18);

btn00397.setFont (new Font ("Helvetica", 0, 12));

 	btn00397.setBorderPainted (true);
	btn00397.setDataSourceName("");
	btn00397.setTabOrder(110);
        
      // container is form
add (btn00397,null);             
	} // end of initVSButtonbtn00397
	
	
	
	
	
	
	 public void initVSButtonbtn00387() {
	btn00387.setText("003");
	btn00387.setName ("btn00387");
		btn00387.setForeground(Color.black);
		btn00387.setBackground(new Color(0xc6c6c6));
	btn00387.setBounds (420, 119 , 50, 18);

btn00387.setFont (new Font ("Helvetica", 0, 12));

 	btn00387.setBorderPainted (true);
	btn00387.setDataSourceName("");
	btn00387.setTabOrder(109);
        
      // container is form
add (btn00387,null);             
	} // end of initVSButtonbtn00387
	
	
	
	
	
	
	 public void initVSButtonbtn00377() {
	btn00377.setText("003");
	btn00377.setName ("btn00377");
		btn00377.setForeground(Color.black);
		btn00377.setBackground(new Color(0xc6c6c6));
	btn00377.setBounds (410, 109 , 50, 18);

btn00377.setFont (new Font ("Helvetica", 0, 12));

 	btn00377.setBorderPainted (true);
	btn00377.setDataSourceName("");
	btn00377.setTabOrder(108);
        
      // container is form
add (btn00377,null);             
	} // end of initVSButtonbtn00377
	
	
	
	
	
	
	 public void initVSButtonbtn00367() {
	btn00367.setText("003");
	btn00367.setName ("btn00367");
		btn00367.setForeground(Color.black);
		btn00367.setBackground(new Color(0xc6c6c6));
	btn00367.setBounds (400, 99 , 50, 18);

btn00367.setFont (new Font ("Helvetica", 0, 12));

 	btn00367.setBorderPainted (true);
	btn00367.setDataSourceName("");
	btn00367.setTabOrder(107);
        
      // container is form
add (btn00367,null);             
	} // end of initVSButtonbtn00367
	
	
	
	
	
	
	 public void initVSButtonbtn00357() {
	btn00357.setText("003");
	btn00357.setName ("btn00357");
		btn00357.setForeground(Color.black);
		btn00357.setBackground(new Color(0xc6c6c6));
	btn00357.setBounds (390, 89 , 50, 18);

btn00357.setFont (new Font ("Helvetica", 0, 12));

 	btn00357.setBorderPainted (true);
	btn00357.setDataSourceName("");
	btn00357.setTabOrder(106);
        
      // container is form
add (btn00357,null);             
	} // end of initVSButtonbtn00357
	
	
	
	
	
	
	 public void initVSButtonbtn00347() {
	btn00347.setText("003");
	btn00347.setName ("btn00347");
		btn00347.setForeground(Color.black);
		btn00347.setBackground(new Color(0xc6c6c6));
	btn00347.setBounds (380, 79 , 50, 18);

btn00347.setFont (new Font ("Helvetica", 0, 12));

 	btn00347.setBorderPainted (true);
	btn00347.setDataSourceName("");
	btn00347.setTabOrder(105);
        
      // container is form
add (btn00347,null);             
	} // end of initVSButtonbtn00347
	
	
	
	
	
	
	 public void initVSButtonbtn00337() {
	btn00337.setText("003");
	btn00337.setName ("btn00337");
		btn00337.setForeground(Color.black);
		btn00337.setBackground(new Color(0xc6c6c6));
	btn00337.setBounds (370, 69 , 50, 18);

btn00337.setFont (new Font ("Helvetica", 0, 12));

 	btn00337.setBorderPainted (true);
	btn00337.setDataSourceName("");
	btn00337.setTabOrder(104);
        
      // container is form
add (btn00337,null);             
	} // end of initVSButtonbtn00337
	
	
	
	
	
	
	 public void initVSButtonbtn00329() {
	btn00329.setText("003");
	btn00329.setName ("btn00329");
		btn00329.setForeground(Color.black);
		btn00329.setBackground(new Color(0xc6c6c6));
	btn00329.setBounds (360, 59 , 50, 18);

btn00329.setFont (new Font ("Helvetica", 0, 12));

 	btn00329.setBorderPainted (true);
	btn00329.setDataSourceName("");
	btn00329.setTabOrder(103);
        
      // container is form
add (btn00329,null);             
	} // end of initVSButtonbtn00329
	
	
	
	
	
	
	 public void initVSButtonbtn003119() {
	btn003119.setText("003");
	btn003119.setName ("btn003119");
		btn003119.setForeground(Color.black);
		btn003119.setBackground(new Color(0xc6c6c6));
	btn003119.setBounds (350, 49 , 50, 18);

btn003119.setFont (new Font ("Helvetica", 0, 12));

 	btn003119.setBorderPainted (true);
	btn003119.setDataSourceName("");
	btn003119.setTabOrder(102);
        
      // container is form
add (btn003119,null);             
	} // end of initVSButtonbtn003119
	
	
	
	
	
	
	 public void initVSButtonbtn00328() {
	btn00328.setText("003");
	btn00328.setName ("btn00328");
		btn00328.setForeground(Color.black);
		btn00328.setBackground(new Color(0xc6c6c6));
	btn00328.setBounds (340, 39 , 50, 18);

btn00328.setFont (new Font ("Helvetica", 0, 12));

 	btn00328.setBorderPainted (true);
	btn00328.setDataSourceName("");
	btn00328.setTabOrder(101);
        
      // container is form
add (btn00328,null);             
	} // end of initVSButtonbtn00328
	
	
	
	
	
	
	 public void initVSButtonbtn0027() {
	btn0027.setText("002");
	btn0027.setName ("btn0027");
		btn0027.setForeground(Color.black);
		btn0027.setBackground(new Color(0xc6c6c6));
	btn0027.setBounds (335, 22 , 50, 18);

btn0027.setFont (new Font ("Helvetica", 0, 12));

 	btn0027.setBorderPainted (true);
	btn0027.setDataSourceName("");
	btn0027.setTabOrder(100);
        
      // container is form
add (btn0027,null);             
	} // end of initVSButtonbtn0027
	
	
	
	
	
	
	 public void initVSButtonbtn0017() {
	btn0017.setText("001");
	btn0017.setName ("btn0017");
		btn0017.setForeground(Color.black);
		btn0017.setBackground(new Color(0xc6c6c6));
	btn0017.setBounds (317, 5 , 50, 18);

btn0017.setFont (new Font ("Helvetica", 0, 12));

 	btn0017.setBorderPainted (true);
	btn0017.setDataSourceName("");
	btn0017.setTabOrder(99);
        
      // container is form
add (btn0017,null);             
	} // end of initVSButtonbtn0017
	
	
	
	
	
	
	 public void initVSButtonbtn003118() {
	btn003118.setText("003");
	btn003118.setName ("btn003118");
		btn003118.setForeground(Color.black);
		btn003118.setBackground(new Color(0xc6c6c6));
	btn003118.setBounds (199, 164 , 50, 18);

btn003118.setFont (new Font ("Helvetica", 0, 12));

 	btn003118.setBorderPainted (true);
	btn003118.setDataSourceName("");
	btn003118.setTabOrder(98);
        
      // container is form
add (btn003118,null);             
	} // end of initVSButtonbtn003118
	
	
	
	
	
	
	 public void initVSButtonbtn003106() {
	btn003106.setText("003");
	btn003106.setName ("btn003106");
		btn003106.setForeground(Color.black);
		btn003106.setBackground(new Color(0xc6c6c6));
	btn003106.setBounds (189, 154 , 50, 18);

btn003106.setFont (new Font ("Helvetica", 0, 12));

 	btn003106.setBorderPainted (true);
	btn003106.setDataSourceName("");
	btn003106.setTabOrder(97);
        
      // container is form
add (btn003106,null);             
	} // end of initVSButtonbtn003106
	
	
	
	
	
	
	 public void initVSButtonbtn00396() {
	btn00396.setText("003");
	btn00396.setName ("btn00396");
		btn00396.setForeground(Color.black);
		btn00396.setBackground(new Color(0xc6c6c6));
	btn00396.setBounds (179, 144 , 50, 18);

btn00396.setFont (new Font ("Helvetica", 0, 12));

 	btn00396.setBorderPainted (true);
	btn00396.setDataSourceName("");
	btn00396.setTabOrder(96);
        
      // container is form
add (btn00396,null);             
	} // end of initVSButtonbtn00396
	
	
	
	
	
	
	 public void initVSButtonbtn00386() {
	btn00386.setText("003");
	btn00386.setName ("btn00386");
		btn00386.setForeground(Color.black);
		btn00386.setBackground(new Color(0xc6c6c6));
	btn00386.setBounds (169, 134 , 50, 18);

btn00386.setFont (new Font ("Helvetica", 0, 12));

 	btn00386.setBorderPainted (true);
	btn00386.setDataSourceName("");
	btn00386.setTabOrder(95);
        
      // container is form
add (btn00386,null);             
	} // end of initVSButtonbtn00386
	
	
	
	
	
	
	 public void initVSButtonbtn00376() {
	btn00376.setText("003");
	btn00376.setName ("btn00376");
		btn00376.setForeground(Color.black);
		btn00376.setBackground(new Color(0xc6c6c6));
	btn00376.setBounds (159, 124 , 50, 18);

btn00376.setFont (new Font ("Helvetica", 0, 12));

 	btn00376.setBorderPainted (true);
	btn00376.setDataSourceName("");
	btn00376.setTabOrder(94);
        
      // container is form
add (btn00376,null);             
	} // end of initVSButtonbtn00376
	
	
	
	
	
	
	 public void initVSButtonbtn00366() {
	btn00366.setText("003");
	btn00366.setName ("btn00366");
		btn00366.setForeground(Color.black);
		btn00366.setBackground(new Color(0xc6c6c6));
	btn00366.setBounds (149, 114 , 50, 18);

btn00366.setFont (new Font ("Helvetica", 0, 12));

 	btn00366.setBorderPainted (true);
	btn00366.setDataSourceName("");
	btn00366.setTabOrder(93);
        
      // container is form
add (btn00366,null);             
	} // end of initVSButtonbtn00366
	
	
	
	
	
	
	 public void initVSButtonbtn00356() {
	btn00356.setText("003");
	btn00356.setName ("btn00356");
		btn00356.setForeground(Color.black);
		btn00356.setBackground(new Color(0xc6c6c6));
	btn00356.setBounds (139, 104 , 50, 18);

btn00356.setFont (new Font ("Helvetica", 0, 12));

 	btn00356.setBorderPainted (true);
	btn00356.setDataSourceName("");
	btn00356.setTabOrder(92);
        
      // container is form
add (btn00356,null);             
	} // end of initVSButtonbtn00356
	
	
	
	
	
	
	 public void initVSButtonbtn00346() {
	btn00346.setText("003");
	btn00346.setName ("btn00346");
		btn00346.setForeground(Color.black);
		btn00346.setBackground(new Color(0xc6c6c6));
	btn00346.setBounds (129, 94 , 50, 18);

btn00346.setFont (new Font ("Helvetica", 0, 12));

 	btn00346.setBorderPainted (true);
	btn00346.setDataSourceName("");
	btn00346.setTabOrder(91);
        
      // container is form
add (btn00346,null);             
	} // end of initVSButtonbtn00346
	
	
	
	
	
	
	 public void initVSButtonbtn00336() {
	btn00336.setText("003");
	btn00336.setName ("btn00336");
		btn00336.setForeground(Color.black);
		btn00336.setBackground(new Color(0xc6c6c6));
	btn00336.setBounds (119, 84 , 50, 18);

btn00336.setFont (new Font ("Helvetica", 0, 12));

 	btn00336.setBorderPainted (true);
	btn00336.setDataSourceName("");
	btn00336.setTabOrder(90);
        
      // container is form
add (btn00336,null);             
	} // end of initVSButtonbtn00336
	
	
	
	
	
	
	 public void initVSButtonbtn00327() {
	btn00327.setText("003");
	btn00327.setName ("btn00327");
		btn00327.setForeground(Color.black);
		btn00327.setBackground(new Color(0xc6c6c6));
	btn00327.setBounds (109, 74 , 50, 18);

btn00327.setFont (new Font ("Helvetica", 0, 12));

 	btn00327.setBorderPainted (true);
	btn00327.setDataSourceName("");
	btn00327.setTabOrder(89);
        
      // container is form
add (btn00327,null);             
	} // end of initVSButtonbtn00327
	
	
	
	
	
	
	 public void initVSButtonbtn003117() {
	btn003117.setText("003");
	btn003117.setName ("btn003117");
		btn003117.setForeground(Color.black);
		btn003117.setBackground(new Color(0xc6c6c6));
	btn003117.setBounds (99, 64 , 50, 18);

btn003117.setFont (new Font ("Helvetica", 0, 12));

 	btn003117.setBorderPainted (true);
	btn003117.setDataSourceName("");
	btn003117.setTabOrder(88);
        
      // container is form
add (btn003117,null);             
	} // end of initVSButtonbtn003117
	
	
	
	
	
	
	 public void initVSButtonbtn00326() {
	btn00326.setText("003");
	btn00326.setName ("btn00326");
		btn00326.setForeground(Color.black);
		btn00326.setBackground(new Color(0xc6c6c6));
	btn00326.setBounds (89, 54 , 50, 18);

btn00326.setFont (new Font ("Helvetica", 0, 12));

 	btn00326.setBorderPainted (true);
	btn00326.setDataSourceName("");
	btn00326.setTabOrder(87);
        
      // container is form
add (btn00326,null);             
	} // end of initVSButtonbtn00326
	
	
	
	
	
	
	 public void initVSButtonbtn0026() {
	btn0026.setText("002");
	btn0026.setName ("btn0026");
		btn0026.setForeground(Color.black);
		btn0026.setBackground(new Color(0xc6c6c6));
	btn0026.setBounds (84, 37 , 50, 18);

btn0026.setFont (new Font ("Helvetica", 0, 12));

 	btn0026.setBorderPainted (true);
	btn0026.setDataSourceName("");
	btn0026.setTabOrder(86);
        
      // container is form
add (btn0026,null);             
	} // end of initVSButtonbtn0026
	
	
	
	
	
	
	 public void initVSButtonbtn0016() {
	btn0016.setText("001");
	btn0016.setName ("btn0016");
		btn0016.setForeground(Color.black);
		btn0016.setBackground(new Color(0xc6c6c6));
	btn0016.setBounds (66, 20 , 50, 18);

btn0016.setFont (new Font ("Helvetica", 0, 12));

 	btn0016.setBorderPainted (true);
	btn0016.setDataSourceName("");
	btn0016.setTabOrder(85);
        
      // container is form
add (btn0016,null);             
	} // end of initVSButtonbtn0016
	
	
	
	
	
	
	 public void initVSButtonbtn003116() {
	btn003116.setText("003");
	btn003116.setName ("btn003116");
		btn003116.setForeground(Color.black);
		btn003116.setBackground(new Color(0xc6c6c6));
	btn003116.setBounds (136, 192 , 50, 18);

btn003116.setFont (new Font ("Helvetica", 0, 12));

 	btn003116.setBorderPainted (true);
	btn003116.setDataSourceName("");
	btn003116.setTabOrder(84);
        
      // container is form
add (btn003116,null);             
	} // end of initVSButtonbtn003116
	
	
	
	
	
	
	 public void initVSButtonbtn003105() {
	btn003105.setText("003");
	btn003105.setName ("btn003105");
		btn003105.setForeground(Color.black);
		btn003105.setBackground(new Color(0xc6c6c6));
	btn003105.setBounds (126, 182 , 50, 18);

btn003105.setFont (new Font ("Helvetica", 0, 12));

 	btn003105.setBorderPainted (true);
	btn003105.setDataSourceName("");
	btn003105.setTabOrder(83);
        
      // container is form
add (btn003105,null);             
	} // end of initVSButtonbtn003105
	
	
	
	
	
	
	 public void initVSButtonbtn00395() {
	btn00395.setText("003");
	btn00395.setName ("btn00395");
		btn00395.setForeground(Color.black);
		btn00395.setBackground(new Color(0xc6c6c6));
	btn00395.setBounds (116, 172 , 50, 18);

btn00395.setFont (new Font ("Helvetica", 0, 12));

 	btn00395.setBorderPainted (true);
	btn00395.setDataSourceName("");
	btn00395.setTabOrder(82);
        
      // container is form
add (btn00395,null);             
	} // end of initVSButtonbtn00395
	
	
	
	
	
	
	 public void initVSButtonbtn00385() {
	btn00385.setText("003");
	btn00385.setName ("btn00385");
		btn00385.setForeground(Color.black);
		btn00385.setBackground(new Color(0xc6c6c6));
	btn00385.setBounds (106, 162 , 50, 18);

btn00385.setFont (new Font ("Helvetica", 0, 12));

 	btn00385.setBorderPainted (true);
	btn00385.setDataSourceName("");
	btn00385.setTabOrder(81);
        
      // container is form
add (btn00385,null);             
	} // end of initVSButtonbtn00385
	
	
	
	
	
	
	 public void initVSButtonbtn00375() {
	btn00375.setText("003");
	btn00375.setName ("btn00375");
		btn00375.setForeground(Color.black);
		btn00375.setBackground(new Color(0xc6c6c6));
	btn00375.setBounds (96, 152 , 50, 18);

btn00375.setFont (new Font ("Helvetica", 0, 12));

 	btn00375.setBorderPainted (true);
	btn00375.setDataSourceName("");
	btn00375.setTabOrder(80);
        
      // container is form
add (btn00375,null);             
	} // end of initVSButtonbtn00375
	
	
	
	
	
	
	 public void initVSButtonbtn00365() {
	btn00365.setText("003");
	btn00365.setName ("btn00365");
		btn00365.setForeground(Color.black);
		btn00365.setBackground(new Color(0xc6c6c6));
	btn00365.setBounds (86, 142 , 50, 18);

btn00365.setFont (new Font ("Helvetica", 0, 12));

 	btn00365.setBorderPainted (true);
	btn00365.setDataSourceName("");
	btn00365.setTabOrder(79);
        
      // container is form
add (btn00365,null);             
	} // end of initVSButtonbtn00365
	
	
	
	
	
	
	 public void initVSButtonbtn00355() {
	btn00355.setText("003");
	btn00355.setName ("btn00355");
		btn00355.setForeground(Color.black);
		btn00355.setBackground(new Color(0xc6c6c6));
	btn00355.setBounds (76, 132 , 50, 18);

btn00355.setFont (new Font ("Helvetica", 0, 12));

 	btn00355.setBorderPainted (true);
	btn00355.setDataSourceName("");
	btn00355.setTabOrder(78);
        
      // container is form
add (btn00355,null);             
	} // end of initVSButtonbtn00355
	
	
	
	
	
	
	 public void initVSButtonbtn00345() {
	btn00345.setText("003");
	btn00345.setName ("btn00345");
		btn00345.setForeground(Color.black);
		btn00345.setBackground(new Color(0xc6c6c6));
	btn00345.setBounds (66, 122 , 50, 18);

btn00345.setFont (new Font ("Helvetica", 0, 12));

 	btn00345.setBorderPainted (true);
	btn00345.setDataSourceName("");
	btn00345.setTabOrder(77);
        
      // container is form
add (btn00345,null);             
	} // end of initVSButtonbtn00345
	
	
	
	
	
	
	 public void initVSButtonbtn00335() {
	btn00335.setText("003");
	btn00335.setName ("btn00335");
		btn00335.setForeground(Color.black);
		btn00335.setBackground(new Color(0xc6c6c6));
	btn00335.setBounds (56, 112 , 50, 18);

btn00335.setFont (new Font ("Helvetica", 0, 12));

 	btn00335.setBorderPainted (true);
	btn00335.setDataSourceName("");
	btn00335.setTabOrder(76);
        
      // container is form
add (btn00335,null);             
	} // end of initVSButtonbtn00335
	
	
	
	
	
	
	 public void initVSButtonbtn00325() {
	btn00325.setText("003");
	btn00325.setName ("btn00325");
		btn00325.setForeground(Color.black);
		btn00325.setBackground(new Color(0xc6c6c6));
	btn00325.setBounds (46, 102 , 50, 18);

btn00325.setFont (new Font ("Helvetica", 0, 12));

 	btn00325.setBorderPainted (true);
	btn00325.setDataSourceName("");
	btn00325.setTabOrder(75);
        
      // container is form
add (btn00325,null);             
	} // end of initVSButtonbtn00325
	
	
	
	
	
	
	 public void initVSButtonbtn003115() {
	btn003115.setText("003");
	btn003115.setName ("btn003115");
		btn003115.setForeground(Color.black);
		btn003115.setBackground(new Color(0xc6c6c6));
	btn003115.setBounds (36, 92 , 50, 18);

btn003115.setFont (new Font ("Helvetica", 0, 12));

 	btn003115.setBorderPainted (true);
	btn003115.setDataSourceName("");
	btn003115.setTabOrder(74);
        
      // container is form
add (btn003115,null);             
	} // end of initVSButtonbtn003115
	
	
	
	
	
	
	 public void initVSButtonbtn00320() {
	btn00320.setText("003");
	btn00320.setName ("btn00320");
		btn00320.setForeground(Color.black);
		btn00320.setBackground(new Color(0xc6c6c6));
	btn00320.setBounds (26, 82 , 50, 18);

btn00320.setFont (new Font ("Helvetica", 0, 12));

 	btn00320.setBorderPainted (true);
	btn00320.setDataSourceName("");
	btn00320.setTabOrder(73);
        
      // container is form
add (btn00320,null);             
	} // end of initVSButtonbtn00320
	
	
	
	
	
	
	 public void initVSButtonbtn0025() {
	btn0025.setText("002");
	btn0025.setName ("btn0025");
		btn0025.setForeground(Color.black);
		btn0025.setBackground(new Color(0xc6c6c6));
	btn0025.setBounds (21, 65 , 50, 18);

btn0025.setFont (new Font ("Helvetica", 0, 12));

 	btn0025.setBorderPainted (true);
	btn0025.setDataSourceName("");
	btn0025.setTabOrder(72);
        
      // container is form
add (btn0025,null);             
	} // end of initVSButtonbtn0025
	
	
	
	
	
	
	 public void initVSButtonbtn0015() {
	btn0015.setText("001");
	btn0015.setName ("btn0015");
		btn0015.setForeground(Color.black);
		btn0015.setBackground(new Color(0xc6c6c6));
	btn0015.setBounds (3, 48 , 50, 18);

btn0015.setFont (new Font ("Helvetica", 0, 12));

 	btn0015.setBorderPainted (true);
	btn0015.setDataSourceName("");
	btn0015.setTabOrder(71);
        
      // container is form
add (btn0015,null);             
	} // end of initVSButtonbtn0015
	
	
	
	
	
	
	 public void initVSButtonbtn003114() {
	btn003114.setText("003");
	btn003114.setName ("btn003114");
		btn003114.setForeground(Color.black);
		btn003114.setBackground(new Color(0xc6c6c6));
	btn003114.setBounds (417, 153 , 50, 18);

btn003114.setFont (new Font ("Helvetica", 0, 12));

 	btn003114.setBorderPainted (true);
	btn003114.setDataSourceName("");
	btn003114.setTabOrder(70);
        
      // container is form
add (btn003114,null);             
	} // end of initVSButtonbtn003114
	
	
	
	
	
	
	 public void initVSButtonbtn003104() {
	btn003104.setText("003");
	btn003104.setName ("btn003104");
		btn003104.setForeground(Color.black);
		btn003104.setBackground(new Color(0xc6c6c6));
	btn003104.setBounds (407, 143 , 50, 18);

btn003104.setFont (new Font ("Helvetica", 0, 12));

 	btn003104.setBorderPainted (true);
	btn003104.setDataSourceName("");
	btn003104.setTabOrder(69);
        
      // container is form
add (btn003104,null);             
	} // end of initVSButtonbtn003104
	
	
	
	
	
	
	 public void initVSButtonbtn00394() {
	btn00394.setText("003");
	btn00394.setName ("btn00394");
		btn00394.setForeground(Color.black);
		btn00394.setBackground(new Color(0xc6c6c6));
	btn00394.setBounds (397, 133 , 50, 18);

btn00394.setFont (new Font ("Helvetica", 0, 12));

 	btn00394.setBorderPainted (true);
	btn00394.setDataSourceName("");
	btn00394.setTabOrder(68);
        
      // container is form
add (btn00394,null);             
	} // end of initVSButtonbtn00394
	
	
	
	
	
	
	 public void initVSButtonbtn00384() {
	btn00384.setText("003");
	btn00384.setName ("btn00384");
		btn00384.setForeground(Color.black);
		btn00384.setBackground(new Color(0xc6c6c6));
	btn00384.setBounds (387, 123 , 50, 18);

btn00384.setFont (new Font ("Helvetica", 0, 12));

 	btn00384.setBorderPainted (true);
	btn00384.setDataSourceName("");
	btn00384.setTabOrder(67);
        
      // container is form
add (btn00384,null);             
	} // end of initVSButtonbtn00384
	
	
	
	
	
	
	 public void initVSButtonbtn00374() {
	btn00374.setText("003");
	btn00374.setName ("btn00374");
		btn00374.setForeground(Color.black);
		btn00374.setBackground(new Color(0xc6c6c6));
	btn00374.setBounds (377, 113 , 50, 18);

btn00374.setFont (new Font ("Helvetica", 0, 12));

 	btn00374.setBorderPainted (true);
	btn00374.setDataSourceName("");
	btn00374.setTabOrder(66);
        
      // container is form
add (btn00374,null);             
	} // end of initVSButtonbtn00374
	
	
	
	
	
	
	 public void initVSButtonbtn00364() {
	btn00364.setText("003");
	btn00364.setName ("btn00364");
		btn00364.setForeground(Color.black);
		btn00364.setBackground(new Color(0xc6c6c6));
	btn00364.setBounds (367, 103 , 50, 18);

btn00364.setFont (new Font ("Helvetica", 0, 12));

 	btn00364.setBorderPainted (true);
	btn00364.setDataSourceName("");
	btn00364.setTabOrder(65);
        
      // container is form
add (btn00364,null);             
	} // end of initVSButtonbtn00364
	
	
	
	
	
	
	 public void initVSButtonbtn00354() {
	btn00354.setText("003");
	btn00354.setName ("btn00354");
		btn00354.setForeground(Color.black);
		btn00354.setBackground(new Color(0xc6c6c6));
	btn00354.setBounds (357, 93 , 50, 18);

btn00354.setFont (new Font ("Helvetica", 0, 12));

 	btn00354.setBorderPainted (true);
	btn00354.setDataSourceName("");
	btn00354.setTabOrder(64);
        
      // container is form
add (btn00354,null);             
	} // end of initVSButtonbtn00354
	
	
	
	
	
	
	 public void initVSButtonbtn00344() {
	btn00344.setText("003");
	btn00344.setName ("btn00344");
		btn00344.setForeground(Color.black);
		btn00344.setBackground(new Color(0xc6c6c6));
	btn00344.setBounds (347, 83 , 50, 18);

btn00344.setFont (new Font ("Helvetica", 0, 12));

 	btn00344.setBorderPainted (true);
	btn00344.setDataSourceName("");
	btn00344.setTabOrder(63);
        
      // container is form
add (btn00344,null);             
	} // end of initVSButtonbtn00344
	
	
	
	
	
	
	 public void initVSButtonbtn00334() {
	btn00334.setText("003");
	btn00334.setName ("btn00334");
		btn00334.setForeground(Color.black);
		btn00334.setBackground(new Color(0xc6c6c6));
	btn00334.setBounds (337, 73 , 50, 18);

btn00334.setFont (new Font ("Helvetica", 0, 12));

 	btn00334.setBorderPainted (true);
	btn00334.setDataSourceName("");
	btn00334.setTabOrder(62);
        
      // container is form
add (btn00334,null);             
	} // end of initVSButtonbtn00334
	
	
	
	
	
	
	 public void initVSButtonbtn00324() {
	btn00324.setText("003");
	btn00324.setName ("btn00324");
		btn00324.setForeground(Color.black);
		btn00324.setBackground(new Color(0xc6c6c6));
	btn00324.setBounds (327, 63 , 50, 18);

btn00324.setFont (new Font ("Helvetica", 0, 12));

 	btn00324.setBorderPainted (true);
	btn00324.setDataSourceName("");
	btn00324.setTabOrder(61);
        
      // container is form
add (btn00324,null);             
	} // end of initVSButtonbtn00324
	
	
	
	
	
	
	 public void initVSButtonbtn003110() {
	btn003110.setText("003");
	btn003110.setName ("btn003110");
		btn003110.setForeground(Color.black);
		btn003110.setBackground(new Color(0xc6c6c6));
	btn003110.setBounds (317, 53 , 50, 18);

btn003110.setFont (new Font ("Helvetica", 0, 12));

 	btn003110.setBorderPainted (true);
	btn003110.setDataSourceName("");
	btn003110.setTabOrder(60);
        
      // container is form
add (btn003110,null);             
	} // end of initVSButtonbtn003110
	
	
	
	
	
	
	 public void initVSButtonbtn00319() {
	btn00319.setText("003");
	btn00319.setName ("btn00319");
		btn00319.setForeground(Color.black);
		btn00319.setBackground(new Color(0xc6c6c6));
	btn00319.setBounds (307, 43 , 50, 18);

btn00319.setFont (new Font ("Helvetica", 0, 12));

 	btn00319.setBorderPainted (true);
	btn00319.setDataSourceName("");
	btn00319.setTabOrder(59);
        
      // container is form
add (btn00319,null);             
	} // end of initVSButtonbtn00319
	
	
	
	
	
	
	 public void initVSButtonbtn0024() {
	btn0024.setText("002");
	btn0024.setName ("btn0024");
		btn0024.setForeground(Color.black);
		btn0024.setBackground(new Color(0xc6c6c6));
	btn0024.setBounds (302, 26 , 50, 18);

btn0024.setFont (new Font ("Helvetica", 0, 12));

 	btn0024.setBorderPainted (true);
	btn0024.setDataSourceName("");
	btn0024.setTabOrder(58);
        
      // container is form
add (btn0024,null);             
	} // end of initVSButtonbtn0024
	
	
	
	
	
	
	 public void initVSButtonbtn0014() {
	btn0014.setText("001");
	btn0014.setName ("btn0014");
		btn0014.setForeground(Color.black);
		btn0014.setBackground(new Color(0xc6c6c6));
	btn0014.setBounds (284, 9 , 50, 18);

btn0014.setFont (new Font ("Helvetica", 0, 12));

 	btn0014.setBorderPainted (true);
	btn0014.setDataSourceName("");
	btn0014.setTabOrder(57);
        
      // container is form
add (btn0014,null);             
	} // end of initVSButtonbtn0014
	
	
	
	
	
	
	 public void initVSButtonbtn003113() {
	btn003113.setText("003");
	btn003113.setName ("btn003113");
		btn003113.setForeground(Color.black);
		btn003113.setBackground(new Color(0xc6c6c6));
	btn003113.setBounds (365, 157 , 50, 18);

btn003113.setFont (new Font ("Helvetica", 0, 12));

 	btn003113.setBorderPainted (true);
	btn003113.setDataSourceName("");
	btn003113.setTabOrder(56);
        
      // container is form
add (btn003113,null);             
	} // end of initVSButtonbtn003113
	
	
	
	
	
	
	 public void initVSButtonbtn003103() {
	btn003103.setText("003");
	btn003103.setName ("btn003103");
		btn003103.setForeground(Color.black);
		btn003103.setBackground(new Color(0xc6c6c6));
	btn003103.setBounds (355, 147 , 50, 18);

btn003103.setFont (new Font ("Helvetica", 0, 12));

 	btn003103.setBorderPainted (true);
	btn003103.setDataSourceName("");
	btn003103.setTabOrder(55);
        
      // container is form
add (btn003103,null);             
	} // end of initVSButtonbtn003103
	
	
	
	
	
	
	 public void initVSButtonbtn00393() {
	btn00393.setText("003");
	btn00393.setName ("btn00393");
		btn00393.setForeground(Color.black);
		btn00393.setBackground(new Color(0xc6c6c6));
	btn00393.setBounds (345, 137 , 50, 18);

btn00393.setFont (new Font ("Helvetica", 0, 12));

 	btn00393.setBorderPainted (true);
	btn00393.setDataSourceName("");
	btn00393.setTabOrder(54);
        
      // container is form
add (btn00393,null);             
	} // end of initVSButtonbtn00393
	
	
	
	
	
	
	 public void initVSButtonbtn00383() {
	btn00383.setText("003");
	btn00383.setName ("btn00383");
		btn00383.setForeground(Color.black);
		btn00383.setBackground(new Color(0xc6c6c6));
	btn00383.setBounds (335, 127 , 50, 18);

btn00383.setFont (new Font ("Helvetica", 0, 12));

 	btn00383.setBorderPainted (true);
	btn00383.setDataSourceName("");
	btn00383.setTabOrder(53);
        
      // container is form
add (btn00383,null);             
	} // end of initVSButtonbtn00383
	
	
	
	
	
	
	 public void initVSButtonbtn00373() {
	btn00373.setText("003");
	btn00373.setName ("btn00373");
		btn00373.setForeground(Color.black);
		btn00373.setBackground(new Color(0xc6c6c6));
	btn00373.setBounds (325, 117 , 50, 18);

btn00373.setFont (new Font ("Helvetica", 0, 12));

 	btn00373.setBorderPainted (true);
	btn00373.setDataSourceName("");
	btn00373.setTabOrder(52);
        
      // container is form
add (btn00373,null);             
	} // end of initVSButtonbtn00373
	
	
	
	
	
	
	 public void initVSButtonbtn00363() {
	btn00363.setText("003");
	btn00363.setName ("btn00363");
		btn00363.setForeground(Color.black);
		btn00363.setBackground(new Color(0xc6c6c6));
	btn00363.setBounds (315, 107 , 50, 18);

btn00363.setFont (new Font ("Helvetica", 0, 12));

 	btn00363.setBorderPainted (true);
	btn00363.setDataSourceName("");
	btn00363.setTabOrder(51);
        
      // container is form
add (btn00363,null);             
	} // end of initVSButtonbtn00363
	
	
	
	
	
	
	 public void initVSButtonbtn00353() {
	btn00353.setText("003");
	btn00353.setName ("btn00353");
		btn00353.setForeground(Color.black);
		btn00353.setBackground(new Color(0xc6c6c6));
	btn00353.setBounds (305, 97 , 50, 18);

btn00353.setFont (new Font ("Helvetica", 0, 12));

 	btn00353.setBorderPainted (true);
	btn00353.setDataSourceName("");
	btn00353.setTabOrder(50);
        
      // container is form
add (btn00353,null);             
	} // end of initVSButtonbtn00353
	
	
	
	
	
	
	 public void initVSButtonbtn00343() {
	btn00343.setText("003");
	btn00343.setName ("btn00343");
		btn00343.setForeground(Color.black);
		btn00343.setBackground(new Color(0xc6c6c6));
	btn00343.setBounds (295, 87 , 50, 18);

btn00343.setFont (new Font ("Helvetica", 0, 12));

 	btn00343.setBorderPainted (true);
	btn00343.setDataSourceName("");
	btn00343.setTabOrder(49);
        
      // container is form
add (btn00343,null);             
	} // end of initVSButtonbtn00343
	
	
	
	
	
	
	 public void initVSButtonbtn00333() {
	btn00333.setText("003");
	btn00333.setName ("btn00333");
		btn00333.setForeground(Color.black);
		btn00333.setBackground(new Color(0xc6c6c6));
	btn00333.setBounds (285, 77 , 50, 18);

btn00333.setFont (new Font ("Helvetica", 0, 12));

 	btn00333.setBorderPainted (true);
	btn00333.setDataSourceName("");
	btn00333.setTabOrder(48);
        
      // container is form
add (btn00333,null);             
	} // end of initVSButtonbtn00333
	
	
	
	
	
	
	 public void initVSButtonbtn00323() {
	btn00323.setText("003");
	btn00323.setName ("btn00323");
		btn00323.setForeground(Color.black);
		btn00323.setBackground(new Color(0xc6c6c6));
	btn00323.setBounds (275, 67 , 50, 18);

btn00323.setFont (new Font ("Helvetica", 0, 12));

 	btn00323.setBorderPainted (true);
	btn00323.setDataSourceName("");
	btn00323.setTabOrder(47);
        
      // container is form
add (btn00323,null);             
	} // end of initVSButtonbtn00323
	
	
	
	
	
	
	 public void initVSButtonbtn00318() {
	btn00318.setText("003");
	btn00318.setName ("btn00318");
		btn00318.setForeground(Color.black);
		btn00318.setBackground(new Color(0xc6c6c6));
	btn00318.setBounds (265, 57 , 50, 18);

btn00318.setFont (new Font ("Helvetica", 0, 12));

 	btn00318.setBorderPainted (true);
	btn00318.setDataSourceName("");
	btn00318.setTabOrder(46);
        
      // container is form
add (btn00318,null);             
	} // end of initVSButtonbtn00318
	
	
	
	
	
	
	 public void initVSButtonbtn00317() {
	btn00317.setText("003");
	btn00317.setName ("btn00317");
		btn00317.setForeground(Color.black);
		btn00317.setBackground(new Color(0xc6c6c6));
	btn00317.setBounds (255, 47 , 50, 18);

btn00317.setFont (new Font ("Helvetica", 0, 12));

 	btn00317.setBorderPainted (true);
	btn00317.setDataSourceName("");
	btn00317.setTabOrder(45);
        
      // container is form
add (btn00317,null);             
	} // end of initVSButtonbtn00317
	
	
	
	
	
	
	 public void initVSButtonbtn0023() {
	btn0023.setText("002");
	btn0023.setName ("btn0023");
		btn0023.setForeground(Color.black);
		btn0023.setBackground(new Color(0xc6c6c6));
	btn0023.setBounds (250, 30 , 50, 18);

btn0023.setFont (new Font ("Helvetica", 0, 12));

 	btn0023.setBorderPainted (true);
	btn0023.setDataSourceName("");
	btn0023.setTabOrder(44);
        
      // container is form
add (btn0023,null);             
	} // end of initVSButtonbtn0023
	
	
	
	
	
	
	 public void initVSButtonbtn0013() {
	btn0013.setText("001");
	btn0013.setName ("btn0013");
		btn0013.setForeground(Color.black);
		btn0013.setBackground(new Color(0xc6c6c6));
	btn0013.setBounds (232, 13 , 50, 18);

btn0013.setFont (new Font ("Helvetica", 0, 12));

 	btn0013.setBorderPainted (true);
	btn0013.setDataSourceName("");
	btn0013.setTabOrder(43);
        
      // container is form
add (btn0013,null);             
	} // end of initVSButtonbtn0013
	
	
	
	
	
	
	 public void initVSButtonbtn003112() {
	btn003112.setText("003");
	btn003112.setName ("btn003112");
		btn003112.setForeground(Color.black);
		btn003112.setBackground(new Color(0xc6c6c6));
	btn003112.setBounds (301, 153 , 50, 18);

btn003112.setFont (new Font ("Helvetica", 0, 12));

 	btn003112.setBorderPainted (true);
	btn003112.setDataSourceName("");
	btn003112.setTabOrder(42);
        
      // container is form
add (btn003112,null);             
	} // end of initVSButtonbtn003112
	
	
	
	
	
	
	 public void initVSButtonbtn003102() {
	btn003102.setText("003");
	btn003102.setName ("btn003102");
		btn003102.setForeground(Color.black);
		btn003102.setBackground(new Color(0xc6c6c6));
	btn003102.setBounds (291, 143 , 50, 18);

btn003102.setFont (new Font ("Helvetica", 0, 12));

 	btn003102.setBorderPainted (true);
	btn003102.setDataSourceName("");
	btn003102.setTabOrder(41);
        
      // container is form
add (btn003102,null);             
	} // end of initVSButtonbtn003102
	
	
	
	
	
	
	 public void initVSButtonbtn00392() {
	btn00392.setText("003");
	btn00392.setName ("btn00392");
		btn00392.setForeground(Color.black);
		btn00392.setBackground(new Color(0xc6c6c6));
	btn00392.setBounds (281, 133 , 50, 18);

btn00392.setFont (new Font ("Helvetica", 0, 12));

 	btn00392.setBorderPainted (true);
	btn00392.setDataSourceName("");
	btn00392.setTabOrder(40);
        
      // container is form
add (btn00392,null);             
	} // end of initVSButtonbtn00392
	
	
	
	
	
	
	 public void initVSButtonbtn00382() {
	btn00382.setText("003");
	btn00382.setName ("btn00382");
		btn00382.setForeground(Color.black);
		btn00382.setBackground(new Color(0xc6c6c6));
	btn00382.setBounds (271, 123 , 50, 18);

btn00382.setFont (new Font ("Helvetica", 0, 12));

 	btn00382.setBorderPainted (true);
	btn00382.setDataSourceName("");
	btn00382.setTabOrder(39);
        
      // container is form
add (btn00382,null);             
	} // end of initVSButtonbtn00382
	
	
	
	
	
	
	 public void initVSButtonbtn00372() {
	btn00372.setText("003");
	btn00372.setName ("btn00372");
		btn00372.setForeground(Color.black);
		btn00372.setBackground(new Color(0xc6c6c6));
	btn00372.setBounds (261, 113 , 50, 18);

btn00372.setFont (new Font ("Helvetica", 0, 12));

 	btn00372.setBorderPainted (true);
	btn00372.setDataSourceName("");
	btn00372.setTabOrder(38);
        
      // container is form
add (btn00372,null);             
	} // end of initVSButtonbtn00372
	
	
	
	
	
	
	 public void initVSButtonbtn00362() {
	btn00362.setText("003");
	btn00362.setName ("btn00362");
		btn00362.setForeground(Color.black);
		btn00362.setBackground(new Color(0xc6c6c6));
	btn00362.setBounds (251, 103 , 50, 18);

btn00362.setFont (new Font ("Helvetica", 0, 12));

 	btn00362.setBorderPainted (true);
	btn00362.setDataSourceName("");
	btn00362.setTabOrder(37);
        
      // container is form
add (btn00362,null);             
	} // end of initVSButtonbtn00362
	
	
	
	
	
	
	 public void initVSButtonbtn00352() {
	btn00352.setText("003");
	btn00352.setName ("btn00352");
		btn00352.setForeground(Color.black);
		btn00352.setBackground(new Color(0xc6c6c6));
	btn00352.setBounds (241, 93 , 50, 18);

btn00352.setFont (new Font ("Helvetica", 0, 12));

 	btn00352.setBorderPainted (true);
	btn00352.setDataSourceName("");
	btn00352.setTabOrder(36);
        
      // container is form
add (btn00352,null);             
	} // end of initVSButtonbtn00352
	
	
	
	
	
	
	 public void initVSButtonbtn00342() {
	btn00342.setText("003");
	btn00342.setName ("btn00342");
		btn00342.setForeground(Color.black);
		btn00342.setBackground(new Color(0xc6c6c6));
	btn00342.setBounds (231, 83 , 50, 18);

btn00342.setFont (new Font ("Helvetica", 0, 12));

 	btn00342.setBorderPainted (true);
	btn00342.setDataSourceName("");
	btn00342.setTabOrder(35);
        
      // container is form
add (btn00342,null);             
	} // end of initVSButtonbtn00342
	
	
	
	
	
	
	 public void initVSButtonbtn00332() {
	btn00332.setText("003");
	btn00332.setName ("btn00332");
		btn00332.setForeground(Color.black);
		btn00332.setBackground(new Color(0xc6c6c6));
	btn00332.setBounds (221, 73 , 50, 18);

btn00332.setFont (new Font ("Helvetica", 0, 12));

 	btn00332.setBorderPainted (true);
	btn00332.setDataSourceName("");
	btn00332.setTabOrder(34);
        
      // container is form
add (btn00332,null);             
	} // end of initVSButtonbtn00332
	
	
	
	
	
	
	 public void initVSButtonbtn00322() {
	btn00322.setText("003");
	btn00322.setName ("btn00322");
		btn00322.setForeground(Color.black);
		btn00322.setBackground(new Color(0xc6c6c6));
	btn00322.setBounds (211, 63 , 50, 18);

btn00322.setFont (new Font ("Helvetica", 0, 12));

 	btn00322.setBorderPainted (true);
	btn00322.setDataSourceName("");
	btn00322.setTabOrder(33);
        
      // container is form
add (btn00322,null);             
	} // end of initVSButtonbtn00322
	
	
	
	
	
	
	 public void initVSButtonbtn00316() {
	btn00316.setText("003");
	btn00316.setName ("btn00316");
		btn00316.setForeground(Color.black);
		btn00316.setBackground(new Color(0xc6c6c6));
	btn00316.setBounds (201, 53 , 50, 18);

btn00316.setFont (new Font ("Helvetica", 0, 12));

 	btn00316.setBorderPainted (true);
	btn00316.setDataSourceName("");
	btn00316.setTabOrder(32);
        
      // container is form
add (btn00316,null);             
	} // end of initVSButtonbtn00316
	
	
	
	
	
	
	 public void initVSButtonbtn00315() {
	btn00315.setText("003");
	btn00315.setName ("btn00315");
		btn00315.setForeground(Color.black);
		btn00315.setBackground(new Color(0xc6c6c6));
	btn00315.setBounds (191, 43 , 50, 18);

btn00315.setFont (new Font ("Helvetica", 0, 12));

 	btn00315.setBorderPainted (true);
	btn00315.setDataSourceName("");
	btn00315.setTabOrder(31);
        
      // container is form
add (btn00315,null);             
	} // end of initVSButtonbtn00315
	
	
	
	
	
	
	 public void initVSButtonbtn0022() {
	btn0022.setText("002");
	btn0022.setName ("btn0022");
		btn0022.setForeground(Color.black);
		btn0022.setBackground(new Color(0xc6c6c6));
	btn0022.setBounds (186, 26 , 50, 18);

btn0022.setFont (new Font ("Helvetica", 0, 12));

 	btn0022.setBorderPainted (true);
	btn0022.setDataSourceName("");
	btn0022.setTabOrder(30);
        
      // container is form
add (btn0022,null);             
	} // end of initVSButtonbtn0022
	
	
	
	
	
	
	 public void initVSButtonbtn0012() {
	btn0012.setText("001");
	btn0012.setName ("btn0012");
		btn0012.setForeground(Color.black);
		btn0012.setBackground(new Color(0xc6c6c6));
	btn0012.setBounds (168, 9 , 50, 18);

btn0012.setFont (new Font ("Helvetica", 0, 12));

 	btn0012.setBorderPainted (true);
	btn0012.setDataSourceName("");
	btn0012.setTabOrder(29);
        
      // container is form
add (btn0012,null);             
	} // end of initVSButtonbtn0012
	
	
	
	
	
	
	 public void initVSButtonbtn003111() {
	btn003111.setText("003");
	btn003111.setName ("btn003111");
		btn003111.setForeground(Color.black);
		btn003111.setBackground(new Color(0xc6c6c6));
	btn003111.setBounds (243, 155 , 50, 18);

btn003111.setFont (new Font ("Helvetica", 0, 12));

 	btn003111.setBorderPainted (true);
	btn003111.setDataSourceName("");
	btn003111.setTabOrder(28);
        
      // container is form
add (btn003111,null);             
	} // end of initVSButtonbtn003111
	
	
	
	
	
	
	 public void initVSButtonbtn003101() {
	btn003101.setText("003");
	btn003101.setName ("btn003101");
		btn003101.setForeground(Color.black);
		btn003101.setBackground(new Color(0xc6c6c6));
	btn003101.setBounds (233, 145 , 50, 18);

btn003101.setFont (new Font ("Helvetica", 0, 12));

 	btn003101.setBorderPainted (true);
	btn003101.setDataSourceName("");
	btn003101.setTabOrder(27);
        
      // container is form
add (btn003101,null);             
	} // end of initVSButtonbtn003101
	
	
	
	
	
	
	 public void initVSButtonbtn00391() {
	btn00391.setText("003");
	btn00391.setName ("btn00391");
		btn00391.setForeground(Color.black);
		btn00391.setBackground(new Color(0xc6c6c6));
	btn00391.setBounds (223, 135 , 50, 18);

btn00391.setFont (new Font ("Helvetica", 0, 12));

 	btn00391.setBorderPainted (true);
	btn00391.setDataSourceName("");
	btn00391.setTabOrder(26);
        
      // container is form
add (btn00391,null);             
	} // end of initVSButtonbtn00391
	
	
	
	
	
	
	 public void initVSButtonbtn00381() {
	btn00381.setText("003");
	btn00381.setName ("btn00381");
		btn00381.setForeground(Color.black);
		btn00381.setBackground(new Color(0xc6c6c6));
	btn00381.setBounds (213, 125 , 50, 18);

btn00381.setFont (new Font ("Helvetica", 0, 12));

 	btn00381.setBorderPainted (true);
	btn00381.setDataSourceName("");
	btn00381.setTabOrder(25);
        
      // container is form
add (btn00381,null);             
	} // end of initVSButtonbtn00381
	
	
	
	
	
	
	 public void initVSButtonbtn00371() {
	btn00371.setText("003");
	btn00371.setName ("btn00371");
		btn00371.setForeground(Color.black);
		btn00371.setBackground(new Color(0xc6c6c6));
	btn00371.setBounds (203, 115 , 50, 18);

btn00371.setFont (new Font ("Helvetica", 0, 12));

 	btn00371.setBorderPainted (true);
	btn00371.setDataSourceName("");
	btn00371.setTabOrder(24);
        
      // container is form
add (btn00371,null);             
	} // end of initVSButtonbtn00371
	
	
	
	
	
	
	 public void initVSButtonbtn00361() {
	btn00361.setText("003");
	btn00361.setName ("btn00361");
		btn00361.setForeground(Color.black);
		btn00361.setBackground(new Color(0xc6c6c6));
	btn00361.setBounds (193, 105 , 50, 18);

btn00361.setFont (new Font ("Helvetica", 0, 12));

 	btn00361.setBorderPainted (true);
	btn00361.setDataSourceName("");
	btn00361.setTabOrder(23);
        
      // container is form
add (btn00361,null);             
	} // end of initVSButtonbtn00361
	
	
	
	
	
	
	 public void initVSButtonbtn00351() {
	btn00351.setText("003");
	btn00351.setName ("btn00351");
		btn00351.setForeground(Color.black);
		btn00351.setBackground(new Color(0xc6c6c6));
	btn00351.setBounds (183, 95 , 50, 18);

btn00351.setFont (new Font ("Helvetica", 0, 12));

 	btn00351.setBorderPainted (true);
	btn00351.setDataSourceName("");
	btn00351.setTabOrder(22);
        
      // container is form
add (btn00351,null);             
	} // end of initVSButtonbtn00351
	
	
	
	
	
	
	 public void initVSButtonbtn00341() {
	btn00341.setText("003");
	btn00341.setName ("btn00341");
		btn00341.setForeground(Color.black);
		btn00341.setBackground(new Color(0xc6c6c6));
	btn00341.setBounds (173, 85 , 50, 18);

btn00341.setFont (new Font ("Helvetica", 0, 12));

 	btn00341.setBorderPainted (true);
	btn00341.setDataSourceName("");
	btn00341.setTabOrder(21);
        
      // container is form
add (btn00341,null);             
	} // end of initVSButtonbtn00341
	
	
	
	
	
	
	 public void initVSButtonbtn00331() {
	btn00331.setText("003");
	btn00331.setName ("btn00331");
		btn00331.setForeground(Color.black);
		btn00331.setBackground(new Color(0xc6c6c6));
	btn00331.setBounds (163, 75 , 50, 18);

btn00331.setFont (new Font ("Helvetica", 0, 12));

 	btn00331.setBorderPainted (true);
	btn00331.setDataSourceName("");
	btn00331.setTabOrder(20);
        
      // container is form
add (btn00331,null);             
	} // end of initVSButtonbtn00331
	
	
	
	
	
	
	 public void initVSButtonbtn00321() {
	btn00321.setText("003");
	btn00321.setName ("btn00321");
		btn00321.setForeground(Color.black);
		btn00321.setBackground(new Color(0xc6c6c6));
	btn00321.setBounds (153, 65 , 50, 18);

btn00321.setFont (new Font ("Helvetica", 0, 12));

 	btn00321.setBorderPainted (true);
	btn00321.setDataSourceName("");
	btn00321.setTabOrder(19);
        
      // container is form
add (btn00321,null);             
	} // end of initVSButtonbtn00321
	
	
	
	
	
	
	 public void initVSButtonbtn00314() {
	btn00314.setText("003");
	btn00314.setName ("btn00314");
		btn00314.setForeground(Color.black);
		btn00314.setBackground(new Color(0xc6c6c6));
	btn00314.setBounds (143, 55 , 50, 18);

btn00314.setFont (new Font ("Helvetica", 0, 12));

 	btn00314.setBorderPainted (true);
	btn00314.setDataSourceName("");
	btn00314.setTabOrder(18);
        
      // container is form
add (btn00314,null);             
	} // end of initVSButtonbtn00314
	
	
	
	
	
	
	 public void initVSButtonbtn00313() {
	btn00313.setText("003");
	btn00313.setName ("btn00313");
		btn00313.setForeground(Color.black);
		btn00313.setBackground(new Color(0xc6c6c6));
	btn00313.setBounds (133, 45 , 50, 18);

btn00313.setFont (new Font ("Helvetica", 0, 12));

 	btn00313.setBorderPainted (true);
	btn00313.setDataSourceName("");
	btn00313.setTabOrder(17);
        
      // container is form
add (btn00313,null);             
	} // end of initVSButtonbtn00313
	
	
	
	
	
	
	 public void initVSButtonbtn0021() {
	btn0021.setText("002");
	btn0021.setName ("btn0021");
		btn0021.setForeground(Color.black);
		btn0021.setBackground(new Color(0xc6c6c6));
	btn0021.setBounds (128, 28 , 50, 18);

btn0021.setFont (new Font ("Helvetica", 0, 12));

 	btn0021.setBorderPainted (true);
	btn0021.setDataSourceName("");
	btn0021.setTabOrder(16);
        
      // container is form
add (btn0021,null);             
	} // end of initVSButtonbtn0021
	
	
	
	
	
	
	 public void initVSButtonbtn0011() {
	btn0011.setText("001");
	btn0011.setName ("btn0011");
		btn0011.setForeground(Color.black);
		btn0011.setBackground(new Color(0xc6c6c6));
	btn0011.setBounds (110, 11 , 50, 18);

btn0011.setFont (new Font ("Helvetica", 0, 12));

 	btn0011.setBorderPainted (true);
	btn0011.setDataSourceName("");
	btn0011.setTabOrder(15);
        
      // container is form
add (btn0011,null);             
	} // end of initVSButtonbtn0011
	
	
	
	
	
	
	 public void initVSButtonbtn00312() {
	btn00312.setText("003");
	btn00312.setName ("btn00312");
		btn00312.setForeground(Color.black);
		btn00312.setBackground(new Color(0xc6c6c6));
	btn00312.setBounds (170, 179 , 50, 18);

btn00312.setFont (new Font ("Helvetica", 0, 12));

 	btn00312.setBorderPainted (true);
	btn00312.setDataSourceName("");
	btn00312.setTabOrder(14);
        
      // container is form
add (btn00312,null);             
	} // end of initVSButtonbtn00312
	
	
	
	
	
	
	 public void initVSButtonbtn00311() {
	btn00311.setText("003");
	btn00311.setName ("btn00311");
		btn00311.setForeground(Color.black);
		btn00311.setBackground(new Color(0xc6c6c6));
	btn00311.setBounds (160, 169 , 50, 18);

btn00311.setFont (new Font ("Helvetica", 0, 12));

 	btn00311.setBorderPainted (true);
	btn00311.setDataSourceName("");
	btn00311.setTabOrder(13);
        
      // container is form
add (btn00311,null);             
	} // end of initVSButtonbtn00311
	
	
	
	
	
	
	 public void initVSButtonbtn00310() {
	btn00310.setText("003");
	btn00310.setName ("btn00310");
		btn00310.setForeground(Color.black);
		btn00310.setBackground(new Color(0xc6c6c6));
	btn00310.setBounds (150, 159 , 50, 18);

btn00310.setFont (new Font ("Helvetica", 0, 12));

 	btn00310.setBorderPainted (true);
	btn00310.setDataSourceName("");
	btn00310.setTabOrder(12);
        
      // container is form
add (btn00310,null);             
	} // end of initVSButtonbtn00310
	
	
	
	
	
	
	 public void initVSButtonbtn0039() {
	btn0039.setText("003");
	btn0039.setName ("btn0039");
		btn0039.setForeground(Color.black);
		btn0039.setBackground(new Color(0xc6c6c6));
	btn0039.setBounds (140, 149 , 50, 18);

btn0039.setFont (new Font ("Helvetica", 0, 12));

 	btn0039.setBorderPainted (true);
	btn0039.setDataSourceName("");
	btn0039.setTabOrder(11);
        
      // container is form
add (btn0039,null);             
	} // end of initVSButtonbtn0039
	
	
	
	
	
	
	 public void initVSButtonbtn0038() {
	btn0038.setText("003");
	btn0038.setName ("btn0038");
		btn0038.setForeground(Color.black);
		btn0038.setBackground(new Color(0xc6c6c6));
	btn0038.setBounds (130, 139 , 50, 18);

btn0038.setFont (new Font ("Helvetica", 0, 12));

 	btn0038.setBorderPainted (true);
	btn0038.setDataSourceName("");
	btn0038.setTabOrder(10);
        
      // container is form
add (btn0038,null);             
	} // end of initVSButtonbtn0038
	
	
	
	
	
	
	 public void initVSButtonbtn0037() {
	btn0037.setText("003");
	btn0037.setName ("btn0037");
		btn0037.setForeground(Color.black);
		btn0037.setBackground(new Color(0xc6c6c6));
	btn0037.setBounds (120, 129 , 50, 18);

btn0037.setFont (new Font ("Helvetica", 0, 12));

 	btn0037.setBorderPainted (true);
	btn0037.setDataSourceName("");
	btn0037.setTabOrder(9);
        
      // container is form
add (btn0037,null);             
	} // end of initVSButtonbtn0037
	
	
	
	
	
	
	 public void initVSButtonbtn0036() {
	btn0036.setText("003");
	btn0036.setName ("btn0036");
		btn0036.setForeground(Color.black);
		btn0036.setBackground(new Color(0xc6c6c6));
	btn0036.setBounds (110, 119 , 50, 18);

btn0036.setFont (new Font ("Helvetica", 0, 12));

 	btn0036.setBorderPainted (true);
	btn0036.setDataSourceName("");
	btn0036.setTabOrder(8);
        
      // container is form
add (btn0036,null);             
	} // end of initVSButtonbtn0036
	
	
	
	
	
	
	 public void initVSButtonbtn0035() {
	btn0035.setText("003");
	btn0035.setName ("btn0035");
		btn0035.setForeground(Color.black);
		btn0035.setBackground(new Color(0xc6c6c6));
	btn0035.setBounds (100, 109 , 50, 18);

btn0035.setFont (new Font ("Helvetica", 0, 12));

 	btn0035.setBorderPainted (true);
	btn0035.setDataSourceName("");
	btn0035.setTabOrder(7);
        
      // container is form
add (btn0035,null);             
	} // end of initVSButtonbtn0035
	
	
	
	
	
	
	 public void initVSButtonbtn0034() {
	btn0034.setText("003");
	btn0034.setName ("btn0034");
		btn0034.setForeground(Color.black);
		btn0034.setBackground(new Color(0xc6c6c6));
	btn0034.setBounds (90, 99 , 50, 18);

btn0034.setFont (new Font ("Helvetica", 0, 12));

 	btn0034.setBorderPainted (true);
	btn0034.setDataSourceName("");
	btn0034.setTabOrder(6);
        
      // container is form
add (btn0034,null);             
	} // end of initVSButtonbtn0034
	
	
	
	
	
	
	 public void initVSButtonbtn0033() {
	btn0033.setText("003");
	btn0033.setName ("btn0033");
		btn0033.setForeground(Color.black);
		btn0033.setBackground(new Color(0xc6c6c6));
	btn0033.setBounds (80, 89 , 50, 18);

btn0033.setFont (new Font ("Helvetica", 0, 12));

 	btn0033.setBorderPainted (true);
	btn0033.setDataSourceName("");
	btn0033.setTabOrder(5);
        
      // container is form
add (btn0033,null);             
	} // end of initVSButtonbtn0033
	
	
	
	
	
	
	 public void initVSButtonbtn0032() {
	btn0032.setText("003");
	btn0032.setName ("btn0032");
		btn0032.setForeground(Color.black);
		btn0032.setBackground(new Color(0xc6c6c6));
	btn0032.setBounds (70, 79 , 50, 18);

btn0032.setFont (new Font ("Helvetica", 0, 12));

 	btn0032.setBorderPainted (true);
	btn0032.setDataSourceName("");
	btn0032.setTabOrder(4);
        
      // container is form
add (btn0032,null);             
	} // end of initVSButtonbtn0032
	
	
	
	
	
	
	 public void initVSButtonbtn0031() {
	btn0031.setText("003");
	btn0031.setName ("btn0031");
		btn0031.setForeground(Color.black);
		btn0031.setBackground(new Color(0xc6c6c6));
	btn0031.setBounds (60, 69 , 50, 18);

btn0031.setFont (new Font ("Helvetica", 0, 12));

 	btn0031.setBorderPainted (true);
	btn0031.setDataSourceName("");
	btn0031.setTabOrder(3);
        
      // container is form
add (btn0031,null);             
	} // end of initVSButtonbtn0031
	
	
	
	
	
	
	 public void initVSButtonbtn003() {
	btn003.setText("003");
	btn003.setName ("btn003");
		btn003.setForeground(Color.black);
		btn003.setBackground(new Color(0xc6c6c6));
	btn003.setBounds (50, 59 , 50, 18);

btn003.setFont (new Font ("Helvetica", 0, 12));

 	btn003.setBorderPainted (true);
	btn003.setDataSourceName("");
	btn003.setTabOrder(2);
        
      // container is form
add (btn003,null);             
	} // end of initVSButtonbtn003
	
	
	
	
	
	
	 public void initVSButtonbtn002() {
	btn002.setText("002");
	btn002.setName ("btn002");
		btn002.setForeground(Color.black);
		btn002.setBackground(new Color(0xc6c6c6));
	btn002.setBounds (45, 42 , 50, 18);

btn002.setFont (new Font ("Helvetica", 0, 12));

 	btn002.setBorderPainted (true);
	btn002.setDataSourceName("");
	btn002.setTabOrder(1);
        
      // container is form
add (btn002,null);             
	} // end of initVSButtonbtn002
	
	
	
	
	
	
	 public void initVSButtonbtn001() {
	btn001.setText("001");
	btn001.setName ("btn001");
		btn001.setForeground(Color.black);
		btn001.setBackground(new Color(0xc6c6c6));
	btn001.setBounds (27, 25 , 50, 18);

btn001.setFont (new Font ("Helvetica", 0, 12));

 	btn001.setBorderPainted (true);
	btn001.setDataSourceName("");
	btn001.setTabOrder(0);
        
      // container is form
add (btn001,null);             
	} // end of initVSButtonbtn001
	
	
	
	
}