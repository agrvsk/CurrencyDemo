 
//{{COMPONENT_IMPORT_STMTS

package  CurrencyDemo;

import com.versata.tl.vls.core.*;
import com.versata.tl.vls.dataaccess.ResultSet;
import com.versata.tl.vls.process.*;
import com.versata.tl.vls.service.Response;
import com.versata.tl.common.meta.VSMetaQuery;

//END_COMPONENT_IMPORT_STMTS}}

/**
 * OMR1
 */
 public class OMR1Impl extends OMR1BaseImpl {
    public static DataObject getNewObject(Session session, boolean makeDefaults) {
        OMR1Impl  newDO = new OMR1Impl(session, makeDefaults);
        newDO.set_VSTypeIndicatorAttrColumnData();
        return newDO;
    }    

    public OMR1Impl() {
    }

    public OMR1Impl(Session session, boolean makeDefaults) {
        super(session, makeDefaults);
    }

    public OMR1Impl(Session session, VSMetaQuery metaQuery, boolean makeDefaults) {
        super(session, metaQuery, makeDefaults);
    }
  
}