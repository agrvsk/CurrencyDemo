package com.versata.tl.vls.admin.security;

import com.versata.tl.common.exception.ServerException;
import com.versata.tl.common.meta.VSQueryDefinition;
import com.versata.tl.common.util.SearchRequest;
import com.versata.tl.common.util.UnSynchronizedVector;
import com.versata.tl.common.vstrace.IVSTraceVocab;
import com.versata.tl.vls.dataaccess.XDAConnector;
import com.versata.tl.vls.dataaccess.XDASQLConnector;
import com.versata.tl.vls.dataaccess.connection.Connection;
import com.versata.tl.vls.dataaccess.connection.VSJdbc;



public class F2KConnector extends XDASQLConnector implements IVSTraceVocab, XDAConnector 
{
    public F2KConnector() 
    {
    	super();
    	System.out.println("F2KConnector()");
    }
  
    
    
    
    protected String buildSQL(VSQueryDefinition vsquerydefinition, SearchRequest searchrequest,
    		SearchRequest searchrequest1, VSJdbc vsjdbc, int i, UnSynchronizedVector unsynchronizedvector,
    		UnSynchronizedVector unsynchronizedvector1, UnSynchronizedVector unsynchronizedvector2)
    {
    	System.out.println("F2KConnector.buildSQL(.....)");
    	
    	String sSQLIn = "";
    	String sSQLUt = "";
    	System.out.println("====================>"+searchrequest+" "+searchrequest.toString());
    	int iDBT = vsjdbc.getDatabaseType(); //2=MSSQL 11MySQL
    	if(iDBT==11)
    	{
    		sSQLIn=vsquerydefinition.getSQL();
    		sSQLUt=sSQLIn.replaceAll("DATEDIFF \\(day, Dat1, Dat2\\)", "DATEDIFF \\(Dat2, Dat1\\)");
    		vsquerydefinition.setSQL(sSQLUt);
    		
    	}
    	
    	if(iDBT==2)
    	{
    		//PFU2012-12-07 Workaround för 
    		//Issue 31. SQL is build incorrectly when accessing null parent on MS SQL Server
    		System.out.println("====================>Workaround");
    		if (searchrequest.toString().contains("  is NULL")){
    			System.out.println("====================++++++++++++++++++++++++++++++++++++++>");
/*    			sSQLIn=searchrequest.stringList.toString();
    			sSQLUt=sSQLIn.replace("  is NULL","");
    			sSQLIn=sSQLUt.replace("[","");
    			sSQLUt=sSQLIn.replace("]","");
    			searchrequest.reset();
    			searchrequest.add(sSQLUt);*/
    		}
    	}  	  
    	  
    	
    	return super.buildSQL(vsquerydefinition, searchrequest, searchrequest1, vsjdbc, i, unsynchronizedvector, unsynchronizedvector1, unsynchronizedvector2);

    }

}




