/*
 * $Id$
 * Created: $Date$
 *
 * Copyright (c) Versata, Inc., 2000-2008. All Rights Reserved.
 */
package com.versata.debug;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.versata.tl.vfc.jsf.beans.BeanHelperFactory;
import com.versata.tl.vfc.jsf.beans.IBeanHelper;
import com.versata.tl.vfc.jsf.beans.SessionContextBean;
import com.versata.tl.vfc.jsf.debug.IVersataClientStateViewer;
import com.versata.tl.vfc.jsf.debug.VersataDebugShowData;

/**
 * This class implements the IVersataClientStateViewer interface.
 * To debug and view the Versata JSF client state, ensure that the isDebugEnabled method returns
 * true. If it return true, the methods:
 * beforeInvokeApplicationPhase, afterInvokeApplicationPhase
 * beforeRenderResponsePhase, afterRenderResponsePhase
 * will be called from the versata Invoke Application Listener and the Versata Render Response Listener
 * 
 * The following fields can be used to view the state of the client:
 * 
 * 1. sessionContextBean - shows the session context bean
 * 2. currentBeanInstancesMap - shows the latest instances of the various managed beans existing in the
 * client. The key of the map is the bean name. Value is the latest bean instance.
 * 3. The versata cache can be seen from within the DataControlManager instance present inside any of
 * the bean instances.
 * 4. The versata cache can further be used to view the client data graph
 * 
 * If the client runtime state needs to be viewed in during the invoke application and/or render 
 * response phase, then this class may be started as a thread in the before<event> callback and stopped 
 * in the after<event> callback.
 * IMPORTANT: Note that it is important to ensure that thread is not running when a jsf phase is not 
 * in progress. If that happens, the faces context will be null and exceptions will occur.
 * 
 * @since 7.0
 * @author Versata, Inc.
 */
public class VersataClientStateViewer implements Runnable, IVersataClientStateViewer {
	private static final long SLEEP_TIME = 1000*5; //5 sec
	
	private IBeanHelper beanHelper;
	private SessionContextBean sessionContextBean;
    private boolean debugEnabled = true;
	private Map currentBeanInstancesMap = new HashMap();
	
	public boolean isDebugEnabled() {
        return debugEnabled;
    }
	
	public void run() {
		initialize();
		while(true) {
			
			System.out.println("Inside VersataClientStateViewer::run");
			updateCurrentBeanInstancesMap();
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

    private void initialize() {
		beanHelper = new BeanHelperFactory().getBeanHelper();
	}

    public void beforeInvokeApplicationPhase() {
        updateCurrentBeanInstancesMap();   
        // DEBUG method
        // Use this method for print DataContol string for DEBUG 
        // VersataDebugShowData.dataControlStackMap();
    }
    
    public void afterInvokeApplicationPhase() {
        updateCurrentBeanInstancesMap();  
        // DEBUG method
        //Use this method for print DataContol string for DEBUG 
        VersataDebugShowData.dataControlStackMap();//### BRMS619
    }

    public void beforeRenderResponsePhase() {
        updateCurrentBeanInstancesMap();        
        // DEBUG method
        // Use this method for print DataContol string for DEBUG 
        // VersataDebugShowData.dataControlStackMap();
    }
    
    public void afterRenderResponsePhase() {
        updateCurrentBeanInstancesMap();    
        // DEBUG method
        //Use this method for print DataContol string for DEBUG 
        VersataDebugShowData.dataControlStackMap();//### BRMS619
    }

    private void updateCurrentBeanInstancesMap() {
        if(sessionContextBean == null) {
            return;
        }
        
        Map factoryBeansMap = sessionContextBean.getFactoryBeansCache();
        Set beanNames = factoryBeansMap.keySet();
        Iterator iter = beanNames.iterator();
        while(iter.hasNext()) {
            String beanName = (String)iter.next();
            currentBeanInstancesMap.put(beanName, getBeanHelper().getBeanFor(beanName));
        }
    }
	 public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Id: " + hashCode());
        buffer.append("(").append(getBeanHelper()).append(")");
		Map factoryBeansMap = sessionContextBean.getFactoryBeansCache();
        Set beanNames = factoryBeansMap.keySet();
        Iterator iter = beanNames.iterator();
    	 while(iter.hasNext()) {
            String beanName = (String)iter.next();
            buffer.append(beanName);
        }

        return buffer.toString();
    }

    public IBeanHelper getBeanHelper() {
        if(beanHelper == null) {
            beanHelper = new BeanHelperFactory().getBeanHelper();
        }
        return beanHelper;
    }
    
    protected SessionContextBean getSessionContextBean() {
        return sessionContextBean;
    }

    public void setSessionContextBean(SessionContextBean sessionContextBean) {
        this.sessionContextBean = sessionContextBean;
    }

}
