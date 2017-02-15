 
//{{COMPONENT_IMPORT_STMTS

package  CurrencyDemo;

import com.versata.tl.vls.core.*;
import com.versata.tl.vls.dataaccess.ResultSet;
import com.versata.tl.vls.process.*;
import com.versata.tl.vls.service.Response;
import com.versata.tl.common.exception.ServerException;
import com.versata.tl.common.meta.VSMetaQuery;

//END_COMPONENT_IMPORT_STMTS}}

/**
 * OrderItem_ORD
 */
 public class OrderItem_ORDImpl extends OrderItem_ORDBaseImpl {
    public static DataObject getNewObject(Session session, boolean makeDefaults) {
        OrderItem_ORDImpl  newDO = new OrderItem_ORDImpl(session, makeDefaults);
        newDO.set_VSTypeIndicatorAttrColumnData();
        return newDO;
    }    

    public OrderItem_ORDImpl() {
    }

    public OrderItem_ORDImpl(Session session, boolean makeDefaults) {
        super(session, makeDefaults);
    }

    public OrderItem_ORDImpl(Session session, VSMetaQuery metaQuery, boolean makeDefaults) {
        super(session, metaQuery, makeDefaults);
    }
    protected void doCodeTableChecks() throws ServerException
    {
    	if (!( isNull("ORD_Approved") ))
    			{
    		  		if(this.getValue("ORD_Approved").toString().trim().length()>0)
    		  		{
    		  			this.codeTableCheck("ORD_Approved");
    		  		}
    			}
    }
  
    protected void OrderItem_ORD_afterInsert(DataObject obj)
	{
		System.out.println("+++++++++++++++++++++++++++++++++==>OrderItem_ORD_afterInsert "+obj.getData("ORD_OrderId").getString() );
		
	}
    protected void OrderItem_ORD_afterUpdate(DataObject obj)
	{
		System.out.println("+++++++++++++++++++++++++++++++++++++====>OrderItem_ORD_afterUpdate "+obj.getData("ORD_OrderId").getString() );
    	OrderItem_ORDImpl ORDNy;
    	ORDNy=(OrderItem_ORDImpl)OrderItem_ORDImpl.getNewObject(session,true);
    	ORDNy.insert();
    	ORDNy.executeRules();
    	System.out.println("+++++++++++++++++++ NY ORD nr"+ORDNy.getData("ORD_OrderId").getString() );
	}  
}