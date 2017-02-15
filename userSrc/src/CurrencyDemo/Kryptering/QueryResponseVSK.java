package CurrencyDemo.Kryptering;
import java.io.Serializable;

import CurrencyDemo.Kryptering.XOR.XorCompressionAlg;

import com.versata.tl.common.MetaColumn;
import com.versata.tl.common.QueryRequest;
import com.versata.tl.common.QueryResponse;
import com.versata.tl.common.VSORBResultSetPackage.atEndException;
import com.versata.tl.common.util.ZipCompressionAlg;
import com.versata.tl.common.vlsobject.VSORBResultSet;

public class QueryResponseVSK extends QueryResponse
    implements Serializable
{
	private int count;
	private VSORBResultSet rs;
	private String rows[][];
	private byte rowsAsBytes[];
	private MetaColumn metaColumn[];
	private QueryRequest qr;
	private Object objectRows[][];

	public QueryResponseVSK()
    {
		super();
    }
    public void setRows(String theRows[][])
    {
    	System.out.println("QueryResponseVSK.setRows");
        super.setRows(theRows);
    }

    public String[][] getRows()
        throws atEndException
    {
    	System.out.println("QueryResponseVSK.getRows");
    	return super.getRows();
    }
    
	
    public ZipCompressionAlg getCompressionAlg()
    {
        System.out.println("QueryResponseVSK.getCompressionAlg()");
        return new XorCompressionAlg();
    }
    
}