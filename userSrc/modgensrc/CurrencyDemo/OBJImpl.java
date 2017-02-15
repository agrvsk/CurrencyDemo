 
//{{COMPONENT_IMPORT_STMTS

package  CurrencyDemo;

import com.versata.tl.vls.core.*;
import com.versata.tl.vls.dataaccess.ResultSet;
import com.versata.tl.vls.process.*;
import com.versata.tl.vls.service.Response;
import com.versata.tl.common.meta.VSMetaQuery;

//END_COMPONENT_IMPORT_STMTS}}

/**
 * OBJ
 */
 public class OBJImpl extends OBJBaseImpl {
    public static DataObject getNewObject(Session session, boolean makeDefaults) {
        OBJImpl  newDO = new OBJImpl(session, makeDefaults);
        newDO.set_VSTypeIndicatorAttrColumnData();
        return newDO;
    }    

    public OBJImpl() {
    }

    public OBJImpl(Session session, boolean makeDefaults) {
        super(session, makeDefaults);
    }

    public OBJImpl(Session session, VSMetaQuery metaQuery, boolean makeDefaults) {
        super(session, metaQuery, makeDefaults);
    }
  
}