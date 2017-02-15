 
//{{COMPONENT_IMPORT_STMTS

package  CurrencyDemo;

import com.versata.tl.vls.core.*;
import com.versata.tl.vls.dataaccess.ResultSet;
import com.versata.tl.vls.process.*;
import com.versata.tl.vls.service.Response;
import com.versata.tl.common.meta.VSMetaQuery;
import com.versata.tl.common.util.SearchRequest;

//END_COMPONENT_IMPORT_STMTS}}

/**
 * CommonParms_COP
 */
 public class CommonParms_COPImpl extends CommonParms_COPBaseImpl {
    public static DataObject getNewObject(Session session, boolean makeDefaults) {
        CommonParms_COPImpl  newDO = new CommonParms_COPImpl(session, makeDefaults);
        newDO.set_VSTypeIndicatorAttrColumnData();
        return newDO;
    }    

    public CommonParms_COPImpl() {
    }

    public CommonParms_COPImpl(Session session, boolean makeDefaults) {
        super(session, makeDefaults);
    }

    public CommonParms_COPImpl(Session session, VSMetaQuery metaQuery, boolean makeDefaults) {
        super(session, metaQuery, makeDefaults);
    }
    protected void CommonParms_COP_beforeUpdate(DataObject obj, Response resp)
	{
    		System.out.println("========== UNICODE Characters? ==>"+this.getCOP_Description().toString());
			System.out.println("LÄSNING 1 (EmiR).");
			try
				{
					EmiR.EmiR_Z_RFUImpl akl1 = null;
					
					SearchRequest Urval=new SearchRequest();
					Urval.addProperty("className", "Emir.EmiR_Z_RFUBaseImpl");
					
					DataObject datO = EmiR.EmiR_Z_RFUImpl.getObjectByKey(Urval,session);
					if(datO != null)
					System.out.println(datO.getClass().getName()+" should be EmiR.EmiR_Z_RFUImpl");

					System.out.println("LÄSNING 2 (EmiR).");
					akl1 = (EmiR.EmiR_Z_RFUImpl) EmiR.EmiR_Z_RFUImpl.getObjectByKey(Urval,session);
//					akl1.executeRules();
				}
				catch(Throwable se)
				{
					System.out.println(se.toString());
				}
				
				
				try
				{
					System.out.println("LÄSNING 3 (CurrencyDemo).");
					SearchRequest Urval=new SearchRequest();

					DataObject datO = EmiR_Z_RFUImpl.getObjectByKey(Urval,session);
					if(datO != null)
					System.out.println(datO.getClass().getName()+" should be CurrencyDemo.EmiR_Z_RFUImpl");
					
					EmiR_Z_RFUImpl akl = (EmiR_Z_RFUImpl)EmiR_Z_RFUImpl.getObjectByKey(Urval, session);
					System.out.println("LÄSNING 3 (CurrencyDemo OK).");

				}
				catch(Throwable se)
				{
					System.out.println(se.toString());
				}
		
	}

    public void CommonParms_COP_beforeInsert(DataObject obj, Response response)
    {
/****** 
    	    try
    		{
    			methodReadingObjects();
    		}
    		catch(Throwable th)
    		{
    			raiseException(th.getMessage());
    		}
***********/    		
    		

		try
			{
			System.out.println("INSERT (EmiR).");
			
				EmiR.EmiR_Z_RFUImpl akl1 = (EmiR.EmiR_Z_RFUImpl)EmiR.EmiR_Z_RFUImpl.getNewObject(session, true);
				System.out.println(akl1.getClass().getName());
				akl1.executeRules();
				
				System.out.println("LÄSNING 1 (EmiR).");

				SearchRequest Urval=new SearchRequest();
				Urval.addProperty("className", "Emir.EmiR_Z_RFUBaseImpl");
				
				DataObject datO = EmiR.EmiR_Z_RFUImpl.getObjectByKey(Urval,session);
				if(datO != null)
				System.out.println(datO.getClass().getName()+" should be EmiR.EmiR_Z_RFUImpl");

				System.out.println("LÄSNING 2 (EmiR).");
				akl1 = (EmiR.EmiR_Z_RFUImpl) EmiR.EmiR_Z_RFUImpl.getObjectByKey(Urval,session);
//				akl1.executeRules();
			}
			catch(Throwable se)
			{
				System.out.println(se.toString());
			}
			
/****************************************************************			
			try
			{
				SearchRequest key=new SearchRequest();
				VSTransactionInfo ti = session.getTransactionInfo();
				VSMetaQuery mq = EmiR_Z_RFUBaseImpl.getMetaQuery();
				DataObject anObject = ti.getObjectByKey(mq,  null , key);
				System.out.println(anObject.getClass().getName());
			}
			catch(Throwable th)
			{
				System.out.println(th.toString());
			}
********************************************************************/			
			
			try
			{
				System.out.println("LÄSNING 3 (CurrencyDemo).");
				SearchRequest Urval=new SearchRequest();
				
//							 EmiR_Z_RFUImpl akl1 = (			 EmiR_Z_RFUImpl) 			  EmiR_Z_RFUImpl.getObjectByKey(Urval,session);
//				CurrencyDemo.EmiR_Z_RFUImpl akl2 = (CurrencyDemo.EmiR_Z_RFUImpl) CurrencyDemo.EmiR_Z_RFUImpl.getObjectByKey(Urval,session);
//				The code above sometime generates a ClassCastException...
				
				
				DataObject datO = EmiR_Z_RFUImpl.getObjectByKey(Urval,session);
				if(datO != null)
				System.out.println(datO.getClass().getName()+" should be CurrencyDemo.EmiR_Z_RFUImpl");
				
				CurrencyDemo.EmiR_Z_RFUImpl akl = (CurrencyDemo.EmiR_Z_RFUImpl)EmiR_Z_RFUImpl.getObjectByKey(Urval, session);
				System.out.println("LÄSNING 3 (CurrencyDemo OK).");

			}
			catch(Throwable se)
			{
				System.out.println(se.toString());
			}
			
//INSERTING//
//			try
//			{
//				EmiR_Z_RFUImpl ri = (EmiR_Z_RFUImpl)EmiR_Z_RFUImpl.getNewObject(session, true);
//				System.out.println("new EmiR_Z_RFUImpl instansiated.");
//				ri.executeRules();
//				System.out.println("EmiR_Z_RFUImpl saved.");
//			}
//			catch(Throwable th) 
//			{
//				System.out.println(th.toString());
//			}
//
//			try
//			{
//				EmiR.EmiR_Z_RFUImpl ri = (EmiR.EmiR_Z_RFUImpl)EmiR.EmiR_Z_RFUImpl.getNewObject(session, true);
//				System.out.println("new EmiR.EmiR_Z_RFUImpl instansiated.");
//				ri.executeRules();
//				System.out.println("EmiR_Z_RFUImpl saved.");
//			}
//			catch(Throwable th) 
//			{
//				System.out.println(th.toString());
//			}
			
    }
	public void methodReadingObjects() throws Throwable
	{
//		SearchRequest Req = new SearchRequest();
////		Req.addParameter("OrderBacklogPerMonth_OBT","OBT_Client"     ,"SomeValue" );
//		Req.addProperty("limitMaxRowNumber",String.valueOf(-1));
//		//----------------------------------------------------------------------------
//		// The following generates sql with added 'TOP 51'
////		Enumeration Kto = OrderBacklogPerMonth_OBTImpl.getObjects(Req ,getSession());
//		Enumeration Smt = EmiR_CUR_MAIL_SMTImpl.getObjects(Req ,getSession());
//		//----------------------------------------------------------------------------
//		
////		while(Kto != null && Kto.hasMoreElements())
//		{
////			OrderBacklogPerMonth_OBTImpl dKto = (OrderBacklogPerMonth_OBTImpl)Kto.nextElement();
////			if(dKto != null)
////			{
////				doSomething
////			}
//		}
//		long sAntal=0;
//		while(Smt != null && Smt.hasMoreElements())
//		{
//			EmiR_CUR_MAIL_SMTImpl dSmt = (EmiR_CUR_MAIL_SMTImpl)Smt.nextElement();
//			if(dSmt != null) sAntal++;
//			
//		}
//		System.out.println("ANTAL = "+sAntal);
	}
    
	
 
	
	
  
}