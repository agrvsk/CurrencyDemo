 
//{{COMPONENT_IMPORT_STMTS

package  CurrencyDemo;

import com.versata.tl.vls.core.*;
import com.versata.tl.vls.dataaccess.ResultSet;
import com.versata.tl.vls.process.*;
import com.versata.tl.vls.service.Response;
import com.versata.tl.common.meta.VSMetaQuery;

//END_COMPONENT_IMPORT_STMTS}}

/**
 * OrderBacklogPerMonth_OBT
 */
 public class OrderBacklogPerMonth_OBTImpl extends OrderBacklogPerMonth_OBTBaseImpl {
    public static DataObject getNewObject(Session session, boolean makeDefaults) {
        OrderBacklogPerMonth_OBTImpl  newDO = new OrderBacklogPerMonth_OBTImpl(session, makeDefaults);
        newDO.set_VSTypeIndicatorAttrColumnData();
        return newDO;
    }    

    public OrderBacklogPerMonth_OBTImpl() {
    }

    public OrderBacklogPerMonth_OBTImpl(Session session, boolean makeDefaults) {
        super(session, makeDefaults);
    }

    public OrderBacklogPerMonth_OBTImpl(Session session, VSMetaQuery metaQuery, boolean makeDefaults) {
        super(session, metaQuery, makeDefaults);
    }
  
    public void bigOrder() {
    	String month = this.getOldOBT_Month();
    		addTrace("BigOrder!","OrderUSD>100000",0 );
			System.out.println("===> OrderBacklogPerMonthImpl - OrderUSD>100000 Month="+month);
    }
}