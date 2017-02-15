 
//{{COMPONENT_IMPORT_STMTS

package  CurrencyDemo;

import com.versata.tl.vls.core.*;
import com.versata.tl.vls.dataaccess.ResultSet;
import com.versata.tl.vls.process.*;
import com.versata.tl.vls.service.Response;
import com.versata.tl.common.meta.VSMetaQuery;

//END_COMPONENT_IMPORT_STMTS}}

/**
 * OMR
 */
 public class OMRImpl extends OMRBaseImpl {
    public static DataObject getNewObject(Session session, boolean makeDefaults) {
        OMRImpl  newDO = new OMRImpl(session, makeDefaults);
        newDO.set_VSTypeIndicatorAttrColumnData();
        return newDO;
    }    

    public OMRImpl() {
    }

    public OMRImpl(Session session, boolean makeDefaults) {
        super(session, makeDefaults);
    }

    public OMRImpl(Session session, VSMetaQuery metaQuery, boolean makeDefaults) {
        super(session, metaQuery, makeDefaults);
    }
  
}