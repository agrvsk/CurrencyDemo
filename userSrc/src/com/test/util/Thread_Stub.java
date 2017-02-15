package com.test.util;

import java.util.ArrayList;

/**
 * @author vkulikov
 * 
 * @version $Revision: #1 $
 */
public class Thread_Stub {

	/**
	 * Prevent creation of instances of this class.
	 * 
	 */
	private Thread_Stub() {
	}

	/**
	 * Method sessionsMonitorKiller.
	 */
	public static final void sessionsMonitorKiller() {

		final java.util.ArrayList threadsToInterrrupt = new java.util.ArrayList();
		threadsToInterrrupt.add("com.versata.tl.vls.core.SessionsMonitor");

		Thread_Stub.threadsdKiller(threadsToInterrrupt);
	}

	/**
	 * Method threadsdKiller.
	 * 
	 * @param threadsToInterrrupt
	 *            ArrayList
	 */
	public static final void threadsdKiller(final ArrayList threadsToInterrrupt) {

		final Thread[] list = new Thread[Thread.currentThread()
				.getThreadGroup().activeCount()];
		Thread.currentThread().getThreadGroup().enumerate(list);

		for (int i = 0; i < list.length; i++) {
			if (list[i] == null) {
				continue;
			}
			if (threadsToInterrrupt.contains(list[i].getName())) {
				list[i].interrupt();
			}
		}
	}

}
