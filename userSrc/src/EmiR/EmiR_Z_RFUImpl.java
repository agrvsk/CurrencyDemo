//{{COMPONENT_IMPORT_STMTS
package EmiR;
import com.versata.tl.common.util.SearchRequest;
import com.versata.tl.vls.core.DataObject;
import com.versata.tl.vls.core.Session;

//END_COMPONENT_IMPORT_STMTS}}
	
/*
**  EmiR_Z_RFU*/

//{{COMPONENT_RULES_CLASS_DECL
public class EmiR_Z_RFUImpl extends  EmiR_Z_RFUBaseImpl


//END_COMPONENT_RULES_CLASS_DECL}}
{
	//{{COMP_CLASS_CTOR
	public EmiR_Z_RFUImpl (){
		super();
	}
	
	public EmiR_Z_RFUImpl(Session session, boolean makeDefaults)
	{
		super(session, makeDefaults);
	
	
	
	
	//END_COMP_CLASS_CTOR}}

	}


	public void skapaRapport()
	{
	}

	//{{COMPONENT_RULES
	public static DataObject getNewObject(Session session, boolean makeDefaults){
				return new EmiR_Z_RFUImpl(session, makeDefaults);
	}

	
	public boolean matchesFilter(SearchRequest urval)
	{
			String prop= urval.getProperty("className");
			if( "Emir.EmiR_Z_RFUBaseImpl".equals(prop)){
					System.out.println("EmiR.EmiR_Z_RFUImpl OK");
					return super.matchesFilter(urval);
			}else{
				System.out.println("EmiR.EmiR_Z_RFUImpl FORTSÄTTER LETA.");
				return false;
			}
	}
}


