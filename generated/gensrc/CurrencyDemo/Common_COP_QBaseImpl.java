 
 
//{{COMPONENT_BASE_IMPORT_STMTS
package CurrencyDemo;

import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

import com.versata.tl.api.logging.*;
import com.versata.tl.common.exception.ServerException;
import com.versata.tl.common.meta.*;
import com.versata.tl.common.util.*;
import com.versata.tl.vls.core.*;
import com.versata.tl.vls.dataaccess.*;
import com.versata.tl.vls.dataaccess.connection.*;

//END_COMPONENT_BASE_IMPORT_STMTS}}

public abstract class Common_COP_QBaseImpl extends QueryObject {
    public static VersataLogger logger = VersataLogger.getLogger(Common_COP_QImpl.class);
    
    private static String modelName = "Common_COP_Q";
	private static String repositoryName = ServerEnvironment_Base.getVLSConfigProjectName();
    private static VSQueryDefinition q;
	
    //{{BASE_COMPOSITE_COMPONENT_METHODS
    static {
        q = new VSQueryDefinition("Common_COP_Q");
        q.setPackageName("CurrencyDemo");
        q.setRepositoryName(repositoryName);

        // Construct a query column definition.
        // Syntax is: 
        //     new VSQueryColumnDefinition("<tableName>", "<tableAlias>", "<columnName>", "<columnAlias>");
        // Alternate syntax is:
        //     add("<tableName>", "<tableAlias>", "<columnName>", "<columnAlias>");

        //{{QRYDEF_COLUMN_CTOR
            q.add("CommonParms_COP", "CommonParms_COP", "COP_Id", "COP_Id", "", get_VSDataModelPackageName(repositoryName, "CommonParms_COP"));
            q.add("CommonParms_COP", "CommonParms_COP", "COP_Description", "COP_Description", "", get_VSDataModelPackageName(repositoryName, "CommonParms_COP"));
        //END_QRYDEF_COLUMN_CTOR}}
        
        q.setChildMostTableName("CommonParms_COP");

        // Workaround for now.
        q.refreshAfterUpdate(true);
        q.populateQCArray();

			
	
        VSQueryDefinition qTemp = (VSQueryDefinition)getMetaQuery("Common_COP_Q", "CurrencyDemo");
        if (qTemp == null) {
        	q.setPartialSQLForQueryModel("SELECT CommonParms_COP.COP_Id AS COP_Id, CommonParms_COP.COP_Description AS COP_Description FROM  <dbschema>.CommonParms_COP CommonParms_COP", repositoryName, modelName);
            addMetaQuery(q, "CurrencyDemo");
        }
        else {
            q = qTemp;    // Keep the old query as it has cached object
        }

      
 		}
	protected Common_COP_QBaseImpl(){
		addListeners();
	}
	
    public String getComponentName() {
        return "Common_COP_Q";
    }

    public String getPackageName() {
        return "CurrencyDemo";
    }
    
    public String get_VSModelName() {
		return modelName;
	}

	public String get_VSRepositoryName() {
		return repositoryName;
	}    

    public static VSMetaQuery getMetaQuery() {
        return q;
    }

    public static XDAConnector createXDAConnector() { 
        XDAConnector xda = null;
        try {
            VSMetaTable table = Common_COP_QBaseImpl.getMetaQuery().getChildMostTable();
            if (table != null)
                xda = (XDAConnector)Class.forName(table.getXDAConnectorClassName()).newInstance();
            else
                xda = new XDASQLConnector();
        } catch (Exception e) {
            Util.logWarning(logger, e);
        }

        return xda;
    }

    /**      
     * A factory method to create the XDA connector object for this class for a particular session.
     * @param aSession Session object with which to associate the XDA connector.
     * @return If succcessful, an instance of the XDA connector.
     */
    public static XDAConnector createXDAConnector(Session aSession) throws ServerException { 
        XDAConnector xda = null;
        try {
            VSMetaTable table = Common_COP_QBaseImpl.getMetaQuery().getChildMostTable();
            if (table != null)
                xda = ( XDAConnector)Class.forName( table.getXDAConnectorClassName() ).newInstance();
            else
                xda = new XDASQLConnector();
        } catch (Exception e) {
            Util.logWarning(logger, e);
        }
        xda.setSession(aSession);
        Properties props = ((VSORBSessionImpl)aSession).getMyDataServiceLoginForObject("Common_COP_Q");
        xda.setProperties(props);

        return xda;
    }  

    public XDAConnector getXDAConnector() {
        if (xdac == null)
            xdac = Common_COP_QBaseImpl.createXDAConnector(session);
        return xdac;
    }

    /**
     * A factory method to create objects based on the key value which returns
     * an enumeration of objects matching the key value.
     * @param searchReq The key value as a SearchRequest object.
     * @param aSession Object to be associated with the objects.
     * @return Enumeration of objects matching the key.
     */
    public static Enumeration getObjects(SearchRequest searchReq, Session aSession) throws ServerException {
        XDAConnector xdac = Common_COP_QBaseImpl.createXDAConnector(aSession);
        Connection con = null;
        if (aSession.isTransactionInProgress())
            con =  aSession.getTransactionInfo().getConnection(xdac);
        else
            con = aSession.getConnection(xdac, true);
        Vector boList = new Vector();    
        ResultSet rs = new VSORBResultSetImpl(Common_COP_QBaseImpl.getMetaQuery(), searchReq, null, -1, xdac, con);
        DataRow row = null;
        while ((row = rs.fetch()) != null) {    
            BusinessObjectImpl bo = row.getBusinessObject();
            boList.addElement( bo );
        }
        rs.close();
        return boList.elements();
    }
    //END_BASE_COMPOSITE_COMPONENT_METHODS}}
}
 