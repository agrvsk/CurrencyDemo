 
//{{COMPONENT_IMPORT_STMTS

package  CurrencyDemo;

import com.versata.tl.vls.core.*;
import com.versata.tl.vls.dataaccess.ResultSet;
import com.versata.tl.vls.process.*;
import com.versata.tl.vls.service.Response;
import com.versata.tl.common.exception.ServerException;
import com.versata.tl.common.meta.VSMetaQuery;
import com.versata.tl.common.util.SearchRequest;

//END_COMPONENT_IMPORT_STMTS}}

/**
 * Currency_CUR
 */
 public class Currency_CURImpl extends Currency_CURBaseImpl {
    public static DataObject getNewObject(Session session, boolean makeDefaults) {
        Currency_CURImpl  newDO = new Currency_CURImpl(session, makeDefaults);
        newDO.set_VSTypeIndicatorAttrColumnData();
        return newDO;
    }    

    public Currency_CURImpl() {
    }

    public Currency_CURImpl(Session session, boolean makeDefaults) {
        super(session, makeDefaults);
    }

    public Currency_CURImpl(Session session, VSMetaQuery metaQuery, boolean makeDefaults) {
        super(session, metaQuery, makeDefaults);
    }
    public boolean setRemoteUpdateCUR(String sRemoteParm)
	{
		System.out.println("===> Currency_CURImpl -  setRemoteUpdateCUR In remotely accesed method ....");
		return true;
	}
	
	public static DataObject getObjectByKey(SearchRequest srFilter, Session session) throws ServerException
	{
		System.out.println("===> Currency_CURImpl (overrides) getObjectByKey");
		return Currency_CURBaseImpl.getObjectByKey(srFilter, session);
	}
	
	protected void Currency_CUR_beforeUpdate(DataObject obj, Response resp)
	//@SuppressAbstract
	{
		String ccode = this.getCUR_CurrencyCode_RelatedTo();
		if (ccode==null){
			System.out.println("========================> CUR_CurrencyCode_RelatedTo = NULL");
		}
		else if("".equals(ccode.trim()))
		{
			System.out.println("========================> CUR_CurrencyCode_RelatedTo = Empty string (Used to be null in version 7)");
		}else{
			System.out.println("========================> CUR_CurrencyCode_RelatedTo="+this.getCUR_CurrencyCode_RelatedTo());
		}
	}
	
	public String getImage(){
		try {
			String curcode = this.getCUR_CurrencyCode();
			String x="Fel";
			
			if (curcode!=null){
			      x="/images/"+curcode+".gif";
			}
		   return x;
		}  // END Try
		  catch (Throwable th){
		  raiseException(th.toString());
		  return "fel";
		  }
		}
  
}