 
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
 * EmiR_Z_RFU
 */
 public class EmiR_Z_RFUImpl extends EmiR_Z_RFUBaseImpl {
    public static DataObject getNewObject(Session session, boolean makeDefaults) {
        EmiR_Z_RFUImpl  newDO = new EmiR_Z_RFUImpl(session, makeDefaults);
        newDO.set_VSTypeIndicatorAttrColumnData();
        return newDO;
    }    

    public EmiR_Z_RFUImpl() {
    }

    public EmiR_Z_RFUImpl(Session session, boolean makeDefaults) {
        super(session, makeDefaults);
    }

    public EmiR_Z_RFUImpl(Session session, VSMetaQuery metaQuery, boolean makeDefaults) {
        super(session, metaQuery, makeDefaults);
    }
	public void skapaRapport()
	{
	}

	public boolean matchesFilter(SearchRequest urval) 
	{
			String prop= urval.getProperty("className");
			if( "Emir.EmiR_Z_RFUBaseImpl".equals(prop)){
				System.out.println("CurrencyDemo.EmiR_Z_RFUImpl FORTSÄTTER LETA.");
					return false;
			}else{
				System.out.println("CurrencyDemo.EmiR_Z_RFUImpl OK.");
				return super.matchesFilter(urval);
			}
					 
	}  
}