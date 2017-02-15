package CurrencyDemo.Kryptering;

import com.versata.tl.api.logging.VersataLogger;
import com.versata.tl.common.CoLocatedResultSet;
import com.versata.tl.common.MetaColumn;
import com.versata.tl.common.RowSeqHolder;
import com.versata.tl.common._tie_VSORBResultSet;
import com.versata.tl.common.VSORBResultSetPackage.atEndException;
import com.versata.tl.common.businessobject.BusinessObjectCollection;
import com.versata.tl.common.ejb.VLSRemoteObject;
import com.versata.tl.common.vlsobject.VSORBException;
import com.versata.tl.common.vlsobject.VSORBResultSetOperations;

// Referenced classes of package com.versata.tl.common:
//            CoLocatedResultSet, RowSeqHolder, MetaColumn

public class Vsk_tie_VSORBResultSet extends _tie_VSORBResultSet		//VLSRemoteObject
    implements BusinessObjectCollection
{


    @SuppressWarnings("deprecation")
	public Vsk_tie_VSORBResultSet(VSORBResultSetOperations delegate, String name)
    {
        super(delegate,name);
		System.out.println( "Vsk_tie_VSORBResultSet(d,n) " );

    }

    public Vsk_tie_VSORBResultSet(VSORBResultSetOperations delegate)
    {
    	super(delegate);
		System.out.println( "Vsk_tie_VSORBResultSet(d) " );
    }

    public VSORBResultSetOperations _delegate()
    {
		System.out.println( "Vsk_tie_VSORBResultSet._delegate() " );
        return super._delegate();
    }
    /*
    _tie_VSORBResultSet
    public VSORBResultSetOperations _delegate()
    {
        return _delegate;
    }
    private VSORBResultSetOperations _delegate;
    implementeras av
    BOCollectionImpl
    VSORBResultSetImpl
    VSQueryResultsImpl
    public _tie_VSORBResultSet(VSORBResultSetOperations delegate)
    {
        _delegate = delegate;
    }
    

        
         * */
/************************************************************/
    public String[][] fetchRows()
        throws atEndException, VSORBException
    {
		System.out.println( "Vsk_tie_VSORBResultSet.fetchRows() " );
        return _delegate().fetchRows();
    }

    public byte[] fetchRowsAsBytes()
        throws atEndException, VSORBException
    {
    	System.out.println( "Vsk_tie_VSORBResultSet.fetchRowsAsBytes() " );
        return _delegate().fetchRowsAsBytes();
    }

    public Object[][] localFetch()
        throws atEndException, VSORBException
    {
		System.out.println( "Vsk_tie_VSORBResultSet.localFetch() " );
        return ((CoLocatedResultSet)_delegate()).localFetch();
    }

    public int fetch(RowSeqHolder Rows)
        throws atEndException, VSORBException
    {
		System.out.println( "Vsk_tie_VSORBResultSet.fetch() " );
        return _delegate().fetch(Rows);
    }

    public int getCount()
        throws VSORBException
    {
		System.out.println( "Vsk_tie_VSORBResultSet.getCount() " );
        return _delegate().getCount();
    }
/*****************/
    public MetaColumn[] registerMetaData()
        throws VSORBException
    {
		System.out.println( "Vsk_tie_VSORBResultSet.registerMetaData() " );
		MetaColumn[] m = _delegate().registerMetaData();
//    	if(m != null) 
//    		System.out.println( "Vsk_tie_VSORBResultSet.registerMetaData() "+ m[0] );
    	
    	return m;
//        return _delegate().registerMetaData();
    }
/*******************/
    public void setColumnProjectionLevel(int level)
    {
    	System.out.println( "Vsk_tie_VSORBResultSet.setColumnProjectionLevel(i) " );
        _delegate.setColumnProjectionLevel(level);
    }

    public void close()
    {
    	System.out.println( "Vsk_tie_VSORBResultSet.close(i) " );
        _delegate.close();
        _delegate = null;
        super.close();
    }

    public boolean setCursorPosition(int position)
        throws VSORBException
    {
    	System.out.println( "Vsk_tie_VSORBResultSet.setCursorPosition(i) " );
        return _delegate.setCursorPosition(position);
    }

    private static final String _RCS_HEADER = "$Header: //depot/main/products/brms/runtime/src/core/com/versata/tl/common/_tie_VSORBResultSet.java#1 $";
    private VSORBResultSetOperations _delegate;

    static 
    {
        VersataLogger.getRCSTraceLogger().trace("$Header: //depot/main/products/brms/runtime/src/core/com/versata/tl/common/_tie_VSORBResultSet.java#1 $");
    }
/***********************************/
    public void exportObject(VLSRemoteObject obj)
    {
    	System.out.println("Vsk_tie_VSORBResultSet.exportObject");
    	super.exportObject(obj);
    }

    public void unexportObject(VLSRemoteObject obj)
    {
    	System.out.println("Vsk_tie_VSORBResultSet.unexportObject");
    	super.unexportObject(obj);
    }
}
