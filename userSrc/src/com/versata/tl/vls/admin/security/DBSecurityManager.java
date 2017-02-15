package com.versata.tl.vls.admin.security;

// Versata imports
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.Vector;

import javax.ejb.EJBContext;

import com.versata.tl.common.exception.VSException;
import com.versata.tl.common.security.VSMapSecurityInfo;
import com.versata.tl.common.text.RuntimeMsgCode;
import com.versata.tl.common.util.DataConst;
import com.versata.tl.vls.admin.security.VSSecurityManager;
//import com.versata.tl.vls.admin.security.VSSecurityManagerWithoutAuth;
import com.versata.tl.vls.core.Session;
import com.versata.tl.vls.core.VSEJBSecurityManager;
import com.versata.tl.vls.dataaccess.connection.VSJdbc;
import com.versata.tl.vls.dataaccess.connection.VSJdbcStatement;
import com.versata.tl.vls.service.ServerEnvironment;

/**
 * This class implements a security manager which authenticates the user and
 * assigns access control permissions via a Database connection
 * com.versata.server.DBSecurityManager
 */

//import com.versata.tl.vfc.jsf.beans.security.IClientSecurityProvider;

public class DBSecurityManager 
   implements VSSecurityManagerWithoutAuth
   ,VSEJBSecurityManager
//    ,IClientSecurityProvider
// implements VSSecurityManager
{
    
	//
	// Constants for configuaration of the DBSecurityManager
	//
	
	// to generate debug information set the following to true
	private final static boolean debug = true;
	
	// Packagename of the Business Objects (to use for Database Connection) 
	private final static String PACKAGENAME = "CurrencyDemo";
	// Appliaction Name (could be emty)
	private final static String APPLICATIONNAME = "";
	// Use password encryption true/false
	private final static boolean USEENCRYPTION = true;
	
	// Do you have a "Active"-Flag in the User table, 
	// which should be used?
	private final static boolean USE_USER_ACTIVFLAG = true;
	// Do you have a "Active"-Flag in the Role table,
	// which should be used?
	private final static boolean USE_ROLE_ACTIVFLAG = true;
	// Do you have a "Active"-Flag in the UserRole table,
	// which should be used?
	private final static boolean USE_USER_ASSIGN_ROLE_ACTIVEFLAG = true;
	
	// If you use the "Active"-Flag in the User table, 
	// which String value repesents the "ACTIVE" value 
	// for boolen values use "1"
	private final static String  USER_ACTIVFLAG = "J";
	// If you use the "Active"-Flag in the Role table, 
	// which String value repesents the "ACTIVE" value 
	// for boolen values use "1"
	private final static String  ROLE_ACTIVFLAG = "J";
	// If you use the "Active"-Flag in the UserRole table, 
	// which String value repesents the "ACTIVE" value 
	// for boolen values use "1"
	private final static String USER_ASSIGN_ROLE_ACTIVEFLAG = "J";
	
	// Set the needed Table and Field names for the
	// User Table
	private final static String USER_TABLE = "RESURS";
	private final static String USER_ID_FIELD = "RS_ID";
	private final static String USER_LOGIN_FIELD = "RS_ID";
	private final static String USER_PWD_FIELD = "RS_PINKOD";
	private final static String USER_ACTIVATED_FIELD = "RS_AKTIV";
	
	// Set the needed Table and Field names for the
	// Role Table
	private final static String ROLE_TABLE = "ROLLTYP";
	private final static String ROLE_ID_FIELD = "RT_ID";
	private final static String ROLE_ACTIVATED_FIELD = "RT_AKTIV";
	private final static String ROLE_NAME_FIELD = "RT_BESK";
	
	// Set the needed Table and Field names for the
	// UserRole Table, which assignes user to roles
	private final static String USERROLE_TABLE = "RESROLL";
	private final static String USERROLE_USER_ID_FIELD = "RR_RESURS";
	private final static String USERROLE_ROLE_ID_FIELD = "RR_ROLLTYP";
	private final static String USERROLE_ACTIVATED_FIELD = "RR_AKTIV";
	
	// Error Messages
	private final static String ERROR_AUTHENTICATIONFAILED = "Felaktig inloggning.";
	private final static String ERROR_PASSWORDFAILED = "Id eller lÃ¶sen Ã¶r felaktigt.";
	private final static String ERROR_USERDEACTIV = "Ditt id Ã¶r inaktivt..";
	private final static String ERROR_USERDUPLICATED ="Id finns redan !";
	
	// Variables for internal usage
	private Object _sec;
    private Vector m_roleList = new Vector();
	private	String sLoginRsn = null;
	private Session session = null;
	private boolean validatePassword = true;

	private String traceseperator = "";
	
    /**
    * Constructor for the DBSecurityManager
    */
    public DBSecurityManager() {
    }

    /**
    * Getter method for the SecurityObject
    */
    public java.lang.Object getSecurityObject(){
	return this;
    }
    /**
    * Getter method for the password
    */
    public String getPassword() {
        return null;
    }
    
    /**
    * Getter method for the login
    */
    public String getLogin() {
      return sLoginRsn;
    	//  return ((VSMapSecurityInfo)_sec).getLogin();
    }
    
    
    /**
    * method which will be called to activate the login
    */
    public void setSecurityObject(Object o1) {
    	
    	validatePassword = true;
        System.out.println("===> DBSecurityManager Method: setSecurityObject("+o1.getClass().getName()+") -> return (void)");
    	_sec = o1;
        initializeContext();
    }
    
	public void setSecurityObjectWithOutAuth(Object o1) {
		try
		{
			validatePassword = false;
//			validatePassword = true;
	        _sec = o1;
	        initializeContext();
	        System.out.println("===> DBSecurityManager Method: setSecurityObjectWithoutAuth() -> return (void)");
	        
//	        throw new Throwable();
		}
		catch(Throwable th)
		{ 
			th.printStackTrace();
		}
	}
    
    /**
    * Getter method for the all rolenames
    */
    public Vector getRoles() {
    	return m_roleList;
    	
    	

    }
    
    /**
    * Getter method for the external authentication mode
    */
    public boolean externalAuthentication() {
        return false;
    }
	
    /**
    * method which is calling the authentication method
    */
    private synchronized void initializeContext()
    {
        //addTrace("IN Method: initializeContext()");
    	/****************************************/
    	// Leta efter deployment-tråden och vänta tills den kört klart.  //
		try
		{
    		System.out.println("DBSecurityManager.initializeContext    Sök upp tråden 'loadDeploymentData'...");
        	long l1 = System.currentTimeMillis();

			java.util.Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
			Thread[] threadArray = threadSet.toArray(new Thread[threadSet.size()]);
			
			for(int i=0 ; i<threadArray.length; i++)
			{
				if("loadDeploymentData".equalsIgnoreCase(threadArray[i].getName()))
				{
					System.out.println("DBSecurityManager.initializeContext    "+threadArray[i].getName()+" har hittats, vänta till den är klar.");
					threadArray[i].join();
					
				}
    		}
			
        	long l2 = System.currentTimeMillis();
        	System.out.println("DBSecurityManager.initializeContext    Fortsätter...(efter "+(l2-l1)+" ms.)");

		}
    	catch(Throwable th)
    	{
    		System.out.println("DBSecurityManager.initializeContext: "+th.toString());
    	}
    	/********************************************/    	

        try	{
		boolean bRet=authenticateUser();
        if ( !bRet )
              	throw new VSException(RuntimeMsgCode.EMPTY_MSG,ERROR_AUTHENTICATIONFAILED);
		
                    
        } catch(Exception ex)	{
              throw new VSException(RuntimeMsgCode.EMPTY_MSG,ex.toString());
        }
        //addTrace("OUT Method: initializeContext() -> return (void)");
    }
	
    /**
    * the authentication method
    */
    public synchronized boolean authenticateUser() {
		System.out.println("IN Method: authenticateUser()");
        if (!validatePassword) {
        	System.out.println("======================= authenticateUser password"+((VSMapSecurityInfo) _sec).getPassword());
            return true;
        }
        
		boolean ret=false;; 	
		//SearchRequest searchReq = new SearchRequest();
		String sLogin = ((VSMapSecurityInfo)_sec).getLogin();
		String sPwd = ((VSMapSecurityInfo)_sec).getPassword();
		
        System.out.println("===> DBSecurityManager authenticateUser() login:"+sLogin+" passw:"+sPwd);
		
		String md5code = null;
//		try 
//		{	//Krypterar angivet PS innan det jämförs med DB
//			md5code = getMD5code(sPwd);
//			md5code = cryptPassword(sPwd);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("=============================================>MD5="+md5code);

		
        
        
   		//sLogin=sLogin.toUpperCase();
   		String sRole = null;

	
      	// create SQL Statement name
      	StringBuffer theSQLQuery = new StringBuffer("SELECT");
      	theSQLQuery.append(" USR_Password,USR_Role");
      	theSQLQuery.append(" FROM User_USR");
      	theSQLQuery.append(" WHERE USR_Login = '" + sLogin + "'");
      	
      	Enumeration eb = getDBValues(getSession() , "User_USR" , theSQLQuery.toString());
      	
    	Vector userData = null;      	
	    if (eb != null) {
	      	if( eb.hasMoreElements() ) {
	      		userData = (Vector) eb.nextElement();
	      		if ( !eb.hasMoreElements() ) 
	      		{
	      			String dbPwd = ((String) userData.get(0));
					if(dbPwd==null)
						dbPwd="";
					else
					{	//Kryptera läst databasPW för att jämföra med redan krypterat PW från klienten!
						dbPwd=dbPwd.trim().toUpperCase();
						md5code = getMD5code( dbPwd );
//						md5code = cryptPassword(sPwd);
						System.out.println("DBSecurityManager.autenticateUser() DB-Passord"+dbPwd+" krypteras till "+md5code+" före test!");
//						dbPwd = new String( md5code );
					}
	      			if ( !dbPwd.equalsIgnoreCase(sPwd) ){
		      			// check - if necessary - if the user is active
		      			throw new VSException(RuntimeMsgCode.EMPTY_MSG,ERROR_PASSWORDFAILED);
	      			  } else {
	      			  	sRole = ((String) userData.get(1));
	      		        System.out.println("===> DBSecurityManager authenticateUser() login:"+sLogin+" passw:"+sPwd+" role:"+sRole);
	      		        m_roleList.addElement(sRole);
	      		        //sLoginRsn = ((String) userData.get(2));
	      		        if ("sa".equalsIgnoreCase(sLogin)){
	      		        	//Om webconsolen skall funka!
	      		        	sLoginRsn="System Administrator";
	      		        }
	      		       
	      		      
	      			  	ret = true;}
		      		}
	      		} else throw new VSException(RuntimeMsgCode.EMPTY_MSG,ERROR_USERDUPLICATED);
	      	}
     	
 
        return ret;
    } // public synchronized boolean authenticateUser() {
      

    /**
    * getSession - 
    * get internal Session to do the database calls
    * @return Session
    */
    public Session getSession() {
        if ( session == null ) session = (Session)ServerEnvironment.createAdminSession(getPackageName());
        return session;								
    }

    /**
    * Getter method for the application name
    */
    private String getAppName() {
        return APPLICATIONNAME;
    }

    /**
    * Getter method for the package name
    */
    private String getPackageName() {
        return PACKAGENAME;
    }

    /**
    * help method for debuging
    */
    public void addTrace(String msg) {
        if (debug) {
        	if ( msg.startsWith("IN") ) {
        		//System.out.println("");
        		traceseperator = traceseperator +"   ";
        	}
        	System.out.println( "[" + getPackageName()+".DBSecurityManager] "+ traceseperator + msg);
        	if ( msg.startsWith("OUT") ) {
        		traceseperator = traceseperator.substring(3);
        	}
    	}
    }
    
    
    public Enumeration getDBValues(Session session, String dataObjectName, String sSQL) {
		addTrace("IN Method: getDBValues()");
		
		Vector returnVector = new Vector();
		// Get DataServername to use
		String dataServer = session.getDataServerForObject(dataObjectName);
		// Get Statement Object which enables to call the SQL

		VSJdbcStatement jdbcStmt = ((VSJdbc) session.getConnection(dataServer)).createJdbcStatement( );
		try {
			// Call Statement
			addTrace("execute SQL: "+sSQL);
			if (jdbcStmt.executeSQL(sSQL) ){
			  	// Try to get the data
			  	int columns = jdbcStmt.getColumnCount();
				addTrace("Columncount of the Statement: "+columns);
			
				while (jdbcStmt.next()) {
					
					addTrace("Try to Get a ROW");
					// Get the data og the first column 
					Object obj = null;
					Vector allfields = new Vector();
					for (int i=1; i<=columns;i++){
						obj = jdbcStmt.getObject( i, DataConst.VARCHAR );
						// if vaild convert to String
						String value = "";
						if (obj != null) {
							//returnvalue = obj.toString();
							value = obj.toString();
						}
						allfields.add(value);
					}
					addTrace("ROW Data:"+allfields.toString());
					returnVector.add( allfields );
				}
			}
		}
		catch (Exception ex)
		{	
		  // return always null if something goes wrong
		  	addTrace("FATAL ERROR in Methos getDBValues(): " + ex.getMessage() );
			ex.printStackTrace();
			return returnVector.elements();
		}
		
		finally
		{
			// Release the statement used for the command
			if ( jdbcStmt != null )
				jdbcStmt.close();
			jdbcStmt = null;
		}
		
		addTrace("OUT Method: getDBValues() return "+ returnVector.toString());
		return returnVector.elements();
	}
	  
	/**
    * help method for password encryption
    */
    public static String cryptPassword( String pwd ) {
		 
		 if( pwd == null || pwd.length() == 0 ) {
		 	return null;
		 }
		 byte[] buf= new byte[pwd.length()];
		 //pwd.getBytes(0, pwd.length(), buf, 0);
		 java.security.MessageDigest algorithm=null;
		 try {
		     buf = pwd.getBytes("UTF-8"); 
		     algorithm = java.security.MessageDigest.getInstance("SHA-1");
		 }catch (Exception e) {
		     if (debug) System.out.println( "["+PACKAGENAME+"DBSecurityManager] "+
								"ERROR PASSWORD ENCRYPTION: " + e);
		     e.printStackTrace();
		     return null;
		 }
		 algorithm.reset();
		 algorithm.update(buf);
		 byte[] encrypt = algorithm.digest();
		 try {
		     return new String( encrypt ,"UTF-8" );
		 }catch (Exception e) {
		     if (debug) System.out.println( "["+PACKAGENAME+"DBSecurityManager] "+
								"USE SYSTEM ENCODING BECAUSE: " + e);
		     return new String( encrypt );
		 }
	 }
    
	private String getMD5code(String original) //throws Exception 
	{
		StringBuffer sb = new StringBuffer();
		try 
		{
			MessageDigest md = MessageDigest.getInstance("MD5");
			original="qwdd"+original+"salt";
			md.update(original.getBytes());

			byte[] digest = md.digest();
			for (int i = 0; i < digest.length; ++i) 
			{
		       sb.append(Integer.toHexString((digest[i] & 0xFF) | 0x100).substring(1,3));
		    }
		} 
		catch (NoSuchAlgorithmException e) 
		{
			e.printStackTrace();
		}
		return sb.toString() ;
	}

	

	 /**
     * Method to replace a string by another one
	 * @param src the source string 
	 * @param from the substring to replace
	 * @param to the substring replaced
     * @return the src string after the replacement
	 */
	public static String replace(String src,String from,String to) {
		StringBuffer sb=new StringBuffer();
		
		int index = src.indexOf(from);
		if(index>=0) {
			sb.append(src.substring(0,index)).append(to).append(src.substring(index+from.length()));
		} else {
			return src;
		}
		return sb.toString();
	}
	
	/**
     * Method to replace all apprearances of a string by another one
	 * @param src the source string 
	 * @param from the substring to replace
	 * @param to the substring replaced
   	 * @return the src string after the replacement
	 */
	public static String replaceAll(String src,String from,String to) {
		
		int index = src.indexOf(from);
		while(index>=0) {
			src = replace( src, from, to);
			index = src.indexOf(from);
		} 
		return src;
	}

	protected EJBContext ejbContext;
	@Override
	public void setEJBContext(Object ctx) {
		// TODO Auto-generated method stub
//		com.versata.tl.vls.core.EJBSecurityManager x;
		ejbContext = (EJBContext) ctx;
	}
}