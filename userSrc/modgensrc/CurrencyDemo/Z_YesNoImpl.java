 
//{{COMPONENT_IMPORT_STMTS

package  CurrencyDemo;

import com.versata.tl.vls.core.*;
import com.versata.tl.vls.dataaccess.ResultSet;
import com.versata.tl.vls.process.*;
import com.versata.tl.vls.service.Response;
import com.versata.tl.common.meta.VSMetaQuery;

//END_COMPONENT_IMPORT_STMTS}}

/**
 * Z_YesNo
 */
 public class Z_YesNoImpl extends Z_YesNoBaseImpl {
    public static DataObject getNewObject(Session session, boolean makeDefaults) {
        Z_YesNoImpl  newDO = new Z_YesNoImpl(session, makeDefaults);
        newDO.set_VSTypeIndicatorAttrColumnData();
        return newDO;
    }    

    public Z_YesNoImpl() {
    }

    public Z_YesNoImpl(Session session, boolean makeDefaults) {
        super(session, makeDefaults);
    }

    public Z_YesNoImpl(Session session, VSMetaQuery metaQuery, boolean makeDefaults) {
        super(session, metaQuery, makeDefaults);
    }
  
}