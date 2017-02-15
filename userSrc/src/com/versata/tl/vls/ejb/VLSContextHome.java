// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VLSContextHome.java

package com.versata.tl.vls.ejb;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

// Referenced classes of package com.versata.tl.vls.ejb:
//            VLSContext

public interface VLSContextHome
    extends EJBHome
{

    /**
     * @deprecated Method create is deprecated
     */

    public abstract VLSContext create()
        throws CreateException, RemoteException;

    /**
     * @deprecated Method create is deprecated
     */

    public abstract VLSContext create(int i)
        throws CreateException, RemoteException;

    public abstract VLSContext create(String s, String s1, String s2, String s3)
        throws CreateException, RemoteException;

    public abstract VLSContext create(String s, String s1, String s2)
        throws CreateException, RemoteException;

    public abstract VLSContext create(byte abyte0[], String s, String s1)
        throws CreateException, RemoteException;

    public static final String _RCS_HEADER = "$Header: //depot/main/products/brms/runtime/src/core/com/versata/tl/vls/ejb/VLSContextHome.java#1 $";
}
