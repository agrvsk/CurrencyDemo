package CurrencyDemo.Kryptering;

import CurrencyDemo.Kryptering.SSL.SslClientSocketFactory;
import CurrencyDemo.Kryptering.SSL.SslServerSocketFactory;
import CurrencyDemo.Kryptering.XOR.XorClientSocketFactory;
import CurrencyDemo.Kryptering.XOR.XorServerSocketFactory;

import com.versata.tl.common.QueryRequest;
import com.versata.tl.common.QueryResponse;
import com.versata.tl.common.RemoteObjectProperties;
import com.versata.tl.common._tie_VSORBSecuritySession;
import com.versata.tl.common.vlsobject.VSORBException;
import com.versata.tl.common.vlsobject.VSORBSecuritySession;
import com.versata.tl.common.vlsobject.VSORBSecuritySessionOperations;
import com.versata.tl.common.VSORBResultSetPackage.atEndException;
import com.versata.tl.common.ejb.VLSRemoteObject;
import com.versata.tl.common.transaction.Current;
import com.versata.tl.common.transaction.SubtransactionsUnavailableException;
import com.versata.tl.util.SerializationUtil;
import com.versata.tl.vls.core.VSORBAppServerImpl;
import com.versata.tl.vls.core.VSORBSessionImpl;
import com.versata.tl.vls.core.VSORBSessionImpl_ejb;
import com.versata.tl.vls.ejb.VLSContext;
import com.versata.tl.vls.ejb.VLSContextHome;
import com.versata.tl.vls.service.ServerEnvironment;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

import javax.ejb.EJBObject;

public class Vsk_tie_VSORBSecuritySession extends _tie_VSORBSecuritySession 
    implements VSORBSecuritySession 
{
	private static final long serialVersionUID = 1L;
	int port;
	
    /**
     * @deprecated Method Vsk_tie_VSORBSecuritySession is deprecated
     */

    public Vsk_tie_VSORBSecuritySession(VSORBSecuritySessionOperations delegate, String name)
    {
        super(delegate);
    	System.out.println("Vsk_tie_VSORBSecuritySession(d,s)"+delegate.getClass().getName());
    	this.port=-1;
    }

    public Vsk_tie_VSORBSecuritySession(VSORBSecuritySessionOperations delegate)
    {
    	super(delegate);
    	System.out.println("Vsk_tie_VSORBSecuritySession(d)"+delegate.getClass().getName()+delegate.getClass().getName());
    	this.port=-1;
    }
    public Vsk_tie_VSORBSecuritySession(VSORBSecuritySessionOperations delegate, int port )
    {
    	super(delegate);
    	this.port=port;
    	System.out.println("Vsk_tie_VSORBSecuritySession(VSORBSecuritySessionOperations,port)"+delegate.getClass().getName());
    }
    
    
    public VSORBSecuritySessionOperations _delegate()
    {
        //System.out.println(super._delegate().getClass().getName());
    	return super._delegate();
    }

    public Current begin()
    throws SubtransactionsUnavailableException, RemoteException
    {
    	System.out.println("Vsk_tie_VSORBSecuritySession.begin()");

    	byte pattern = (byte) 0xAC;
    	if(this.port == -1) this.port = RemoteObjectProperties.getInstance().getUnicastExportPort()+1;	
    	
    	System.out.println("..._delegate().begin() - "+_delegate().getClass().getName());
        Current curr =	_delegate().begin();
    	System.out.println("...UnicastRemoteObject.exportObject...");

//    	1. Factoryklasser i javax.rmi.ssl.* (det funkar att använda dem)
//      RMIServerSocketFactory ssf = new SslRMIServerSocketFactory();
//      RMIClientSocketFactory csf = new SslRMIClientSocketFactory();
        
//    	2. Subklass av ovanstående med Output som visar att SSL kanaler används
//        RMIServerSocketFactory ssf = new SslServerSocketFactory();	
//        RMIClientSocketFactory csf = new SslClientSocketFactory();	

//		3. Factoryklasser för att kryptera strömmarna med Xor.            
      RMIServerSocketFactory ssf = new XorServerSocketFactory(pattern, this.port);
      RMIClientSocketFactory csf = new XorClientSocketFactory(pattern, this.port);

    	
    	Current stub = (Current)UnicastRemoteObject.exportObject(curr, this.port, csf, ssf);
//    	Current stub = (Current)UnicastRemoteObject.exportObject(curr, RemoteObjectProperties.getInstance().getUnicastExportPort(), csf, ssf);
    	System.out.println("...stub skapad med SSL eller Xor -Sockets..");
    	
    	return stub;
    }


    public void close()
    {
    	System.out.println("Vsk_tie_VSORBSecuritySession.close");
    	super.close();
    } 
    public void exportObject(VLSRemoteObject obj)
    {        
    	System.out.println("Vsk_tie_VSORBSecuritySession.exportObject(obj)");
    	super.exportObject(obj);

    } 
    
	public javax.ejb.EJBHome getEJBHome() 
	{
    	System.out.println("Vsk_tie_VSORBSecuritySession.getEJBHome");
		return super.getEJBHome();
	} 
	public javax.ejb.Handle getHandle() 
	{
    	System.out.println("Vsk_tie_VSORBSecuritySession.getHandle");
		return super.getHandle();
	} 
	public java.lang.Object getPrimaryKey() 
	{
    	System.out.println("Vsk_tie_VSORBSecuritySession.getPrimaryKey");
		return super.getPrimaryKey();
	} 
	public boolean isIdentical(javax.ejb.EJBObject o) 
	{
    	System.out.println("Vsk_tie_VSORBSecuritySession.isIdentical");
		return super.isIdentical(o);
	} 
/*	
	public void remove() 
	{
		super.remove();
	}
	 */
	public void unexportObject(VLSRemoteObject obj) 
	{
    	System.out.println("Vsk_tie_VSORBSecuritySession.unexportObject");
		super.unexportObject(obj);
	} 


//    protected QueryResponse getNewQueryResponse()
//    {
////    	VSORBSessionImpl_Base a; //här ligger metoden!
//    	VSORBSessionImpl_ejb b; //ärver ovanst.
//    	VSORBSessionImpl c;	//ärver ovanst.
//    	
//    	if( super._delegate() instanceof VSORBSessionImpl)
//    	{
//    		VSORBSessionImpl i = (VSORBSessionImpl) super._delegate();
//    		i.getNewQueryResponse();
//    	}
//        return new QueryResponse();
//    }
    
	public Object executeQuery(QueryRequest qr)
	{
		QueryRequest qreq = qr;
		System.out.println("Vsk_tie_VSORBSecuritySession.executeQuery(QR) 1.");
//		System.out.println("\tCacheF:"+qreq.getUseCache());
		System.out.println("\tAdhocT:"+qreq.isAdhocQuery());
//		System.out.println("\tStLesF:"+qreq.getUseStatelessRS());
//		System.out.println("\tCountF:"+qreq.getPrefetchRowCount());
//		System.out.println("\tCoLocF:"+getCoLocated());
		System.out.println("\tFactry:"+ServerEnvironment.getFactoryImpl().getClass().getName());
		System.out.println("\tDelegate:"+_delegate().getClass().getName());	
		System.out.println("\tCompress:"+qreq.isCompressRows());
		
		qr.setIsCompressRows(true);
		qreq.setIsCompressRows(true);
		Object o = super.executeQuery(qr);
//		try
//		{
//			QueryResponse qresp = (QueryResponse)o;
//			QueryResponseVSK q = new QueryResponseVSK();
//			q.setQueryRequest(qr);
//			q.setMetaColumn(qresp.getMetaColumn());
//			q.setRS(qresp.getRS());
//			q.setRowsAsObjects(qresp.getRowsAsObjects());
//			q.setRows(qresp.getRows());
//			q.setRowCount(qresp.getRowCount());
//			o = q;
//		}
//		catch(atEndException ae){;}
//		catch(Throwable th){System.out.println(th.toString());}
		
		
		System.out.println( "QueryResponse? :"+(o instanceof QueryResponse)  );
		System.out.println("Vsk_tie_VSORBSecuritySession.executeQuery(QR) 2."+o.getClass().getName());
		
		
//		try	//KRYPTERA SVARET MED XOR INNAN DET SKICKAS TILL KLIENTEN 
//		{
//			byte pattern = (byte) 0xAC;
//			QueryResponse resp = (QueryResponse) o;
//
//			Object[][] qwerty = resp.getRows();
//			for(int i=0 ; i<qwerty.length ; i++)
//				for(int j=0 ; j<qwerty[i].length ; j++)
//				{	
//					String cpy = new String((String)qwerty[i][j]);
//					if(cpy == null) cpy="<Null>";
//					String x = "";
//					
//					if(qwerty[i][j] != null)
//					{
//						byte[] b = SerializationUtil.serializeToByteArray((String) qwerty[i][j] );
//						
//						for(int k=0 ; k<b.length ; k++)
//						{
//							b[k] = (byte)(( (int)b[k] ^ pattern ) & 0xFF ); 
//							if(k > 0 ) x += ",";
//							x += Integer.toString( b[k] );
//						}
//						qwerty[i][j] = b;  
////						qwerty[i][j] = new String(b);
//					}
//					else
//					{
//						qwerty[i][j] = -1;
//					}
//					
//					System.out.println("RAD["+i+"]["+j+"] "+cpy+" krypteras till "+x );
//					
//				}
//			resp.setRows((String[][])qwerty);
//			resp.setRowsAsObjects(qwerty);
//			
//		}
//		catch(atEndException ae){;}
//		catch(Throwable th)
//		{
//			System.out.println(th.toString());
//		}
		
//		try
//		{
//			System.out.println("KRYPTERAR PÅ SERVERN ");
//			byte[] bs = Converter.serialize_XOR( o );
//			System.out.println("TILLBAKA TILL OBJEKT");
//			o = Converter.deserialize(bs);
//			System.out.println("SERVEROBJEKTET ÄR KRYPTERAT! ");
//		}
//		catch(Throwable th)
//		{
//			System.err.println(th.toString());
//		}
		
		
		return o;
	}
	

	
//------------------------------------------
//    _tie_VSORBSecuritySession	
//    public Object executeQuery(QueryRequest queryRequest)
//    throws VSORBException
//    {
//        return _delegate.executeQuery(queryRequest);
//    }	
//    VSORBSecuritySessionOperations _delegate;
//    detta interface implementeras av 
//------------------------------------------
//*	   VLSContextBean, 
//------------------------------------------
//    		private transient VSORBSecuritySessionOperations _flddelegate;
//		    public Object executeQuery(QueryRequest queryRequest)
//		    throws VSORBException
//			{
//		    System.out.println("VLSContextBean().executeQuery(queryRequest)");
//		    return _flddelegate.executeQuery(queryRequest);
//			}
//------------------------------------------
//*	   VSORBSessionImpl, 
//------------------------------------------
//*>>> VSORBSessionImpl_ejb 
//------------------------------------------
//	public byte[] executeQuery(byte qr[])
//	throws VSORBException
//	{  
//	    QueryResponse qres = (QueryResponse)executeQuery((QueryRequest)SerializationUtil.deserializeFromByteArray(qr, Class.forName("com.versata.tl.common.QueryResponse")));
//	    return SerializationUtil.serializeToByteArray(qres);
//	}
//------------------------------------------
//		public Object executeQuery(QueryRequest qr)
//		throws VSORBException
//		{
//		    QueryRequest qreq = qr;
//		    QueryResponse qres = getNewQueryResponse();
//		    qres.setQueryRequest(qreq);
//		    try
//		    {
//		        if(_LOGGER.isDebugEnabled())
//		            _LOGGER.debug((new StringBuilder()).append("VSORBSessionImpl_ejb.executeQuery qreq -> ").append(qreq).toString());
//		        ResultSet resultSet;
//		        if(qreq.getUseCache())
//		        {
//		            if(_LOGGER.isDebugEnabled())
//		                _LOGGER.debug("VSORBSessionImpl_ejb.executeQuery Using Cache");
//		            resultSet = getResultSetFromCache(qreq);
//		        } else
//		        if(qreq.isAdhocQuery())
//		        {
//		            if(_LOGGER.isDebugEnabled())
//		                _LOGGER.debug("VSORBSessionImpl_ejb.executeQuery is AdhocQuery");
//		            resultSet = getResultSetBySQLRemote1(qreq);
//		        } else
//		        {
//		            if(_LOGGER.isDebugEnabled())
//		                _LOGGER.debug("VSORBSessionImpl_ejb.executeQuery going directly to the source");
//		            resultSet = getResultSetByRequest1(qreq);
//		        }
//				- - - - - - - - -	
//		        if(qreq.getUseStatelessRS())
//		        {
//		            if(getCoLocated())
//		                qres.setRowsAsObjects(((VSQueryResultsImpl)resultSet).localFetch());
//		            else
//		                qres.setRows(resultSet.fetchRows());
//		            if(qreq.getPrefetchRowCount())
//		                qres.setRowCount(((VSQueryResultsImpl)resultSet).getPreFetchCount());
//		            qres.setMetaColumn(resultSet.registerMetaData());
//		        } else
//		        {
//		            VSQueryResultsImpl queryResults = new VSQueryResultsImpl(this);
//		            queryResults.setQueryRequest(qreq);
//		            queryResults.fetchAllRows(resultSet);
//		            if(qreq.getUseCache())
//		            {
//		                if(getCoLocated())
//		                {
//		                    qres.setRowsAsObjects(queryResults.localFetch());
//		                    if(queryResults.hasMoreRows())
//		                    {
//		                        VSORBResultSet remoteResultSet = ((BOCollectionImpl)resultSet).getWrapper();
//		                        qres.setRS(remoteResultSet);
//		                    }
//		                } else
//		                {
//		                    qres.setRows(queryResults.fetchRows());
//		                    if(queryResults.hasMoreRows())
//		                    {
//		                        VSORBResultSet remoteResultSet = ((BOCollectionImpl)resultSet).getRemoteReference();
//		                        qres.setRS(remoteResultSet);
//		                    }
//		                }
//		            } else
//		            if(getCoLocated())
//		            {
//		                qres.setRowsAsObjects(queryResults.localFetch());
//		                if(queryResults.hasMoreRows())
//		                {
//		                    VSORBResultSet remoteResultSet = ((VSORBResultSetImpl)resultSet).getWrapper();
//		                    qres.setRS(remoteResultSet);
//		                }
//		            } else
//		            {
//>>>	                qres.setRows(queryResults.fetchRows());
//		                if(queryResults.hasMoreRows())
//		                {
//>>>	                    VSORBResultSet remoteResultSet = ((VSORBResultSetImpl)resultSet).getRemoteReference();
//>>>	                    qres.setRS(remoteResultSet);
//		                }
//		            }
//		            if(qreq.getPrefetchRowCount())
//		                qres.setRowCount(queryResults.getPreFetchCount());
//		            qres.setMetaColumn(queryResults.registerMetaData());
//		        }
//		    }
//		    catch(VSORBException e)
//		    {
//		        throw e;
//		    }
//		    catch(ServerException se)
//		    {
//		        throw Util.createORBException(se);
//		    }
//		    catch(Throwable e)
//		    {
//		        handleThrowableException(e);
//		    }
//>>>	    return qres;
//}
//------------------------------------------	
//    public volatile ResultSet getResultSetFromCache(QueryRequest x0)
//    throws VSORBException, ServerSecurityException
//{
//    return super.getResultSetFromCache(x0);
//}	
//------------------------------------------
//    private ResultSet getResultSetBySQLRemote1(QueryRequest qreq)
//    throws VSORBException
//{
//    String SQL = qreq.getSQL();
//    String dataServerName = qreq.getDataServerName();
//    int maxRowsPerFetch = qreq.getMaxRowsPerFetch();
//    boolean prefetch = qreq.getServerPreFetch();
//    int randomAccessPos = qreq.getRequestRandomAccessPos();
//    boolean isAutoCloseResultSet = qreq.getUseStatelessRS();
//    String componentName = qreq.getComponentName();
//    String packageName = VSRepositoryMetaCache.get(getRepositoryName()).getPackageName(componentName);
//    boolean useJTS = Boolean.valueOf(getServerProperty("usejts")).booleanValue();
//    Properties props = getMyDataServiceLogin(dataServerName);
//    String dataSourceType;
//    if(Boolean.valueOf(props.getProperty("Use External Connection Pooling")).booleanValue())
//        dataSourceType = props.getProperty("DriverTypeForExternalPool");
//    else
//        dataSourceType = props.getProperty("DriverType");
//    boolean useNativePoolForVersataReadTx = Boolean.valueOf(props.getProperty("Use Native Pool for Versata Read Tx", "true")).booleanValue();
//    boolean isUsingXADriver = Boolean.valueOf(props.getProperty("Is Using XA Driver", "false")).booleanValue();
//    if(_LOGGER.isDebugEnabled())
//        _LOGGER.debug((new StringBuilder()).append("VSORBSessionImpl_ejb.getResultSetBySQLRemote1 ->  isAutoCloseResultSet :").append(isAutoCloseResultSet).append("getPackageName() :").append(packageName).append("dataServerName :").append(dataServerName).append("Use Native Pool for Versata Read Tx :").append(useNativePoolForVersataReadTx).append("isUsingXADriver :").append(isUsingXADriver).append("useJTS :").append(useJTS).append("isTransactionInProgress :").append(isTransactionInProgress()).append("dataSourceType :").append(dataSourceType).toString());
//    validateDriverType(dataSourceType, dataServerName);
//    validateDataServerConfiguration(isAutoCloseResultSet, isUsingXADriver, useNativePoolForVersataReadTx);
//    if(isAutoCloseResultSet && useJTS && !useNativePoolForVersataReadTx && !isSecuritySession() && !isConsoleSession())
//        return getResultSetBySQLRemote1Tx(qreq);
//    ResultSet resultset = null;
//    try
//    {
//        resultset = getResultSetBySQL1(SQL, dataServerName, maxRowsPerFetch, prefetch, randomAccessPos);
//        resultset = setQueryRequest(isAutoCloseResultSet, qreq, resultset);
//    }
//    catch(Exception ex)
//    {
//        _LOGGER.error(ex);
//    }
//    return resultset;
//}
//------------------------------------------
//    public volatile ResultSet getResultSetBySQL1(String x0, String x1, int x2, boolean x3, int x4)
//    throws VSORBException
//{
//    return super.getResultSetBySQL1(x0, x1, x2, x3, x4);
//}
//------------------------------------------
//    protected ResultSet getResultSetByRequest1(QueryRequest qreq)
//    throws VSORBException
//{
//    VSTraceHelper trh;
//    ResultSet resultset;
//    String componentName;
//    int maxRowsPerFetch;
//    short columnProjectionLevel;
//    boolean prefetch;
//    int randomAccessPos;
//    boolean isAutoCloseResultSet;
//    String packageName;
//    trh = null;
//    if(VSTrace.IS_ON)
//    {
//        trh = new VSTraceHelper(_LOGGER, "VSORBSessionImpl.getResultSetByRequest1");
//        trh.set("User", getUserID());
//        trh.set("SessionID", sessionIDForTracing);
//    }
//    resultset = null;
//    componentName = qreq.getComponentName();
//    maxRowsPerFetch = qreq.getMaxRowsPerFetch();
//    columnProjectionLevel = qreq.getColumnProjectionLevel();
//    prefetch = qreq.getServerPreFetch();
//    randomAccessPos = qreq.getRequestRandomAccessPos();
//    isAutoCloseResultSet = qreq.getUseStatelessRS();
//    packageName = VSRepositoryMetaCache.get(getRepositoryName()).getPackageName(componentName);
//    SearchRequest filter;
//    SearchRequest sorter;
//    ResultSet resultset1;
//    filter = (SearchRequest)SerializationUtil.deserializeFromByteArray(qreq.getFilter(), com/versata/tl/common/util/SearchRequest);
//    sorter = (SearchRequest)SerializationUtil.deserializeFromByteArray(qreq.getSorter(), com/versata/tl/common/util/SearchRequest);
//    qreq.setSorterAsSR(sorter);
//    qreq.setFilterAsSR(filter);
//    String dataServerName = null;
//    boolean useJTS = Boolean.valueOf(getServerProperty("usejts")).booleanValue();
//    boolean useNativePoolForVersataReadTx = true;
//    boolean isUsingXADriver = false;
//    String dataSourceType = null;
//    if(!"com.versata.tl.vls.admin".equals(packageName) && !"VLSWebConsole".equals(packageName))
//    {
//        if(Boolean.valueOf(getDataServerProperty(componentName, "Use External Connection Pooling")).booleanValue())
//            dataSourceType = getDataServerProperty(componentName, "DriverTypeForExternalPool");
//        else
//            dataSourceType = getDataServerProperty(componentName, "DriverType");
//        dataServerName = getDataServerForObject(componentName);
//        useNativePoolForVersataReadTx = Boolean.valueOf(getDataServerProperty(componentName, "Use Native Pool for Versata Read Tx")).booleanValue();
//        isUsingXADriver = Boolean.valueOf(getDataServerProperty(componentName, "Is Using XA Driver")).booleanValue();
//    }
//    if(_LOGGER.isDebugEnabled())
//        _LOGGER.debug((new StringBuilder()).append("VSORBSessionImpl_ejb.getResultSetByRequest1 -> isAutoCloseResultSet : ").append(isAutoCloseResultSet).append(" componentName : ").append(componentName).append(" getPackageName() :").append(packageName).append(" dataServerName : ").append(dataServerName).append(" Use Native Pool for Versata Read Tx : ").append(useNativePoolForVersataReadTx).append(" useJTS : ").append(useJTS).append(" isUsingXADriver : ").append(isUsingXADriver).append(" isTransactionInProgress : ").append(isTransactionInProgress()).append(" dataSourceType : ").append(dataSourceType).toString());
//    validateDriverType(dataSourceType, dataServerName);
//    validateDataServerConfiguration(isAutoCloseResultSet, isUsingXADriver, useNativePoolForVersataReadTx);
//    if(!isAutoCloseResultSet || !useJTS || useNativePoolForVersataReadTx || isSecuritySession() || isConsoleSession())
//        break MISSING_BLOCK_LABEL_440;
//    resultset1 = getResultSetByRequest1Tx(qreq);
//    return resultset1;
//    try
//    {
//        VSORBResultSetImpl aResultSet = (VSORBResultSetImpl)GenericComponentFactory.getResultSet(packageName, componentName, filter, sorter, maxRowsPerFetch, columnProjectionLevel, randomAccessPos, (VSORBSessionImpl)this);
//        if(prefetch)
//            aResultSet.enablePreFetch();
//        if(isAutoCloseResultSet)
//        {
//            VSQueryResultsImpl queryResults = new VSQueryResultsImpl(this);
//            queryResults.setQueryRequest(qreq);
//            queryResults.fetchAllRows(aResultSet);
//            resultset = queryResults;
//        } else
//        {
//            resultset = aResultSet;
//        }
//        resultset.setQueryRequest(qreq);
//    }
//    catch(ServerException se)
//    {
//        throw ServerEnvironment.createORBException(se);
//    }
//    catch(VSORBException e)
//    {
//        throw e;
//    }
//    catch(Throwable e)
//    {
//        handleThrowableException(e);
//    }
//    break MISSING_BLOCK_LABEL_574;
//    local;
//    if(trh != null)
//        trh.end();
//    JVM INSTR ret 21;
//    return resultset;
//}

//------------------------------------------
//    public void fetchAllRows(ResultSet resultset)
//    throws ServerException
//{
//    if(qr.getUseCache())
//    {
//        if(sessionReference.getCoLocated())
//        {
//            rowsAsObjects = ((BOCollectionImpl)resultset).localFetch();
//            if(rowsAsObjects != null)
//                rowCount = rowsAsObjects.length;
//        } else
//        {
//            rowsAsStrings = resultset.fetchRows();
//            if(rowsAsStrings != null)
//                rowCount = rowsAsStrings.length;
//        }
//        if(qr.getPrefetchRowCount())
//            prefetchCount = getCount();
//        return;
//    }
//    try
//    {
//        metaQuery = ((VSORBResultSetImpl)resultset).metaQuery;
//        xdac = ((VSORBResultSetImpl)resultset).xdac;
//        sr = ((VSORBResultSetImpl)resultset).sr;
//        if(!sessionReference.isSecuritySession() && !sessionReference.isConsoleSession())
//            mcols = resultset.registerMetaData();
//        if(sessionReference.getCoLocated())
//        {
//            rowsAsObjects = ((VSORBResultSetImpl)resultset).localFetch();
//            if(rowsAsObjects != null)
//                rowCount = rowsAsObjects.length;
//        } else
//        {
//            rowsAsStrings = resultset.fetchRows();
//            if(rowsAsStrings != null)
//                rowCount = rowsAsStrings.length;
//        }
//        if(qr.getPrefetchRowCount())
//            prefetchCount = getCount();
//    }
//    catch(atEndException endExException)
//    {
//        resultset.close();
//        resultset = null;
//        blnHasMoreRows = false;
//    }
//    catch(VSORBException e)
//    {
//        throw e;
//    }
//    catch(ServerException e)
//    {
//        throw e;
//    }
//    catch(Exception ex)
//    {
//        throw new ServerException(AdminMsgCode.SYSTEM_ERROR, ex);
//    }
//    break MISSING_BLOCK_LABEL_396;
//    local;
//    if(qr.getUseStatelessRS() || rowCount < qr.getMaxRowsPerFetch())
//    {
//        if(resultset != null)
//            resultset.close();
//        blnHasMoreRows = false;
//    } else
//    {
//        blnHasMoreRows = true;
//    }
//    if(_LOGGER.isDebugEnabled())
//        _LOGGER.debug((new StringBuilder()).append("rowCount : ").append(rowCount).append(" hasMoreRows() : ").append(blnHasMoreRows).toString());
//    JVM INSTR ret 4;
//}
//------------------------------------------

    
    
	
	

	/*
	 * resultSet F = getResultSetFromCache		//cache
	 * resultSet T = getResultSetBySQLRemote1	//AdHoc
	 * resultSet F = getResultSetByRequest1		//Std
	 * --------------------------------------------
	 * Stateless F = qres.setRows(resultSet.fetchRows());
	 * ---------------------------------------------
	 * Stateful  T   
	 * queryResults.fetchAllRows(resultSet);
	 * Cache	 F
	 *  qres.setRows(queryResults.fetchRows());
//		if(queryResults.hasMoreRows())
//		{
//			VSORBResultSet remoteResultSet = ((BOCollectionImpl)resultSet).getRemoteReference();
//		    qres.setRS(remoteResultSet);
//		}
	 * 	IckeCache
//		qres.setRows(queryResults.fetchRows());
//		if(queryResults.hasMoreRows())
//		{
//			VSORBResultSet remoteResultSet = ((VSORBResultSetImpl)resultSet).getRemoteReference();
//		    qres.setRS(remoteResultSet);
//		}
	 * ---------------------------------------------
	 * 
	 * 	
	 * */
	/*	VSORBResultSetImpl
	 *  public VSORBResultSet getRemoteReference()
    {
        if(remoteReference == null)
            remoteReference = ServerEnvironment.getFactoryImpl().makeVLSResultSet(this);
        if(session != null && (session instanceof VSORBSessionImpl))
            ((VSORBSessionImpl)session).addRemoteResultSet(this);
        return remoteReference;
    }
        private VSORBResultSet remoteReference;

	 * 
	 * 
	 * 
	 * 
	 * getRemoteReference i VSORBSessionImpl_ejb;
	 * public VSORBResultSet getResultSetBySQLRemote1(String SQL, String dataServerName, int maxRowsPerFetch, boolean prefetch, int randomAccessPos, boolean isAutoCloseResultSet) throws VSORBException
	 *                       remoteResultSet = ((VSORBResultSetImpl)resultSet).getRemoteReference();
	 * public Object executeQuery(QueryRequest qr) throws VSORBException X2
	 *        VSORBResultSet remoteResultSet = ((BOCollectionImpl  )resultSet).getRemoteReference();
	 *        VSORBResultSet remoteResultSet = ((VSORBResultSetImpl)resultSet).getRemoteReference();
	 * public VSORBResultSet getResultSetByRequest1(String componentName, byte filterInByteArray[], byte sorterInByteArray[], int maxRowsPerFetch, short columnProjectionLevel, boolean prefetch, int randomAccessPos, boolean isAutoCloseResultSet)
	 *                       remoteResultSet = ((VSORBResultSetImpl)resultSet).getRemoteReference();
	 * public volatile VSORBSession getRemoteReference()
    	{
        return super.getRemoteReference();
    	}
        public volatile VSORBSecuritySession getRemoteReferenceForSecuritySession()
    	{
        return super.getRemoteReferenceForSecuritySession();
    	}
	 * */
    /****
     *     VSORBResultSetImpl
     *     public VSORBResultSet getRemoteReference()
    		{
        	if(remoteReference == null)
            	remoteReference = ServerEnvironment.getFactoryImpl().makeVLSResultSet(this);
        	if(session != null && (session instanceof VSORBSessionImpl))
            	((VSORBSessionImpl)session).addRemoteResultSet(this);
        	return remoteReference;
    		}

     * 
     * 
     *****/

}
