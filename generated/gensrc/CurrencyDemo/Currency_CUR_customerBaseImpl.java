 
 
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

public abstract class Currency_CUR_customerBaseImpl extends QueryObject {
    public static VersataLogger logger = VersataLogger.getLogger(Currency_CUR_customerImpl.class);
    
    private static String modelName = "Currency_CUR_customer";
	private static String repositoryName = ServerEnvironment_Base.getVLSConfigProjectName();
    private static VSQueryDefinition q;
	
    //{{BASE_COMPOSITE_COMPONENT_METHODS
    static {
        q = new VSQueryDefinition("Currency_CUR_customer");
        q.setPackageName("CurrencyDemo");
        q.setRepositoryName(repositoryName);

        // Construct a query column definition.
        // Syntax is: 
        //     new VSQueryColumnDefinition("<tableName>", "<tableAlias>", "<columnName>", "<columnAlias>");
        // Alternate syntax is:
        //     add("<tableName>", "<tableAlias>", "<columnName>", "<columnAlias>");

        //{{QRYDEF_COLUMN_CTOR
            q.add("Currency_CUR", "Currency_CUR", "CUR_Client", "CUR_Client", "", get_VSDataModelPackageName(repositoryName, "Currency_CUR"));
            q.add("Currency_CUR", "Currency_CUR", "CUR_CurrencyCode", "CUR_CurrencyCode", "", get_VSDataModelPackageName(repositoryName, "Currency_CUR"));
            q.add("Currency_CUR", "Currency_CUR", "CUR_ExchangeRate", "CUR_ExchangeRate", "", get_VSDataModelPackageName(repositoryName, "Currency_CUR"));
            q.add("Currency_CUR", "Currency_CUR", "CUR_NumberOfOrders", "CUR_NumberOfOrders", "", get_VSDataModelPackageName(repositoryName, "Currency_CUR"));
            q.add("Currency_CUR", "Currency_CUR", "CUR_OrderValueUSD", "CUR_OrderValueUSD", "", get_VSDataModelPackageName(repositoryName, "Currency_CUR"));
            q.add("Currency_CUR", "Currency_CUR", "CUR_OrderAmountAverage", "CUR_OrderAmountAverage", "", get_VSDataModelPackageName(repositoryName, "Currency_CUR"));
            q.add("Currency_CUR", "Currency_CUR", "CUR_Image", "CUR_Image", "", get_VSDataModelPackageName(repositoryName, "Currency_CUR"));
            q.add("Currency_CUR", "Currency_CUR", "CUR_Client_RelatedTo", "CUR_Client_RelatedTo", "", get_VSDataModelPackageName(repositoryName, "Currency_CUR"));
            q.add("Currency_CUR", "Currency_CUR", "CUR_CurrencyCode_RelatedTo", "CUR_CurrencyCode_RelatedTo", "", get_VSDataModelPackageName(repositoryName, "Currency_CUR"));
        //END_QRYDEF_COLUMN_CTOR}}
        
        q.setChildMostTableName("Currency_CUR");

        // Workaround for now.
        q.refreshAfterUpdate(true);
        q.populateQCArray();

			
	
        VSQueryDefinition qTemp = (VSQueryDefinition)getMetaQuery("Currency_CUR_customer", "CurrencyDemo");
        if (qTemp == null) {
        	q.setPartialSQLForQueryModel("SELECT Currency_CUR.CUR_Client AS CUR_Client, Currency_CUR.CUR_CurrencyCode AS CUR_CurrencyCode, Currency_CUR.CUR_ExchangeRate AS CUR_ExchangeRate, Currency_CUR.CUR_OrderValueUSD AS CUR_OrderValueUSD," +
" Currency_CUR.CUR_OrderAmountAverage AS CUR_OrderAmountAverage, Currency_CUR.CUR_Client_RelatedTo AS CUR_Client_RelatedTo, Currency_CUR.CUR_CurrencyCode_RelatedTo AS CUR_CurrencyCode_RelatedTo FROM  <" +
"dbschema>.Currency_CUR Currency_CUR", repositoryName, modelName);
            addMetaQuery(q, "CurrencyDemo");
        }
        else {
            q = qTemp;    // Keep the old query as it has cached object
        }

      
 		}
	protected Currency_CUR_customerBaseImpl(){
		addListeners();
	}
	
    public String getComponentName() {
        return "Currency_CUR_customer";
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
            VSMetaTable table = Currency_CUR_customerBaseImpl.getMetaQuery().getChildMostTable();
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
            VSMetaTable table = Currency_CUR_customerBaseImpl.getMetaQuery().getChildMostTable();
            if (table != null)
                xda = ( XDAConnector)Class.forName( table.getXDAConnectorClassName() ).newInstance();
            else
                xda = new XDASQLConnector();
        } catch (Exception e) {
            Util.logWarning(logger, e);
        }
        xda.setSession(aSession);
        Properties props = ((VSORBSessionImpl)aSession).getMyDataServiceLoginForObject("Currency_CUR_customer");
        xda.setProperties(props);

        return xda;
    }  

    public XDAConnector getXDAConnector() {
        if (xdac == null)
            xdac = Currency_CUR_customerBaseImpl.createXDAConnector(session);
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
        XDAConnector xdac = Currency_CUR_customerBaseImpl.createXDAConnector(aSession);
        Connection con = null;
        if (aSession.isTransactionInProgress())
            con =  aSession.getTransactionInfo().getConnection(xdac);
        else
            con = aSession.getConnection(xdac, true);
        Vector boList = new Vector();    
        ResultSet rs = new VSORBResultSetImpl(Currency_CUR_customerBaseImpl.getMetaQuery(), searchReq, null, -1, xdac, con);
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
 