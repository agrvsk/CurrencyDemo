 
//{{COMPONENT_IMPORT_STMTS

package  CurrencyDemo;

import com.versata.tl.vls.core.*;
import com.versata.tl.vls.dataaccess.ResultSet;
import com.versata.tl.vls.process.*;
import com.versata.tl.vls.service.Response;
import com.versata.tl.common.meta.VSMetaQuery;

//END_COMPONENT_IMPORT_STMTS}}

/**
 * User_USR
 */
 public class User_USRImpl extends User_USRBaseImpl {
    public static DataObject getNewObject(Session session, boolean makeDefaults) {
        User_USRImpl  newDO = new User_USRImpl(session, makeDefaults);
        newDO.set_VSTypeIndicatorAttrColumnData();
        return newDO;
    }    

    public User_USRImpl() {
    }

    public User_USRImpl(Session session, boolean makeDefaults) {
        super(session, makeDefaults);
    }

    public User_USRImpl(Session session, VSMetaQuery metaQuery, boolean makeDefaults) {
        super(session, metaQuery, makeDefaults);
    }
  
}