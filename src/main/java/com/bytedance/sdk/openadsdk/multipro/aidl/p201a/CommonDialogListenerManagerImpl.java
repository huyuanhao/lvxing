package com.bytedance.sdk.openadsdk.multipro.aidl.p201a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ICommonDialogListener;
import java.util.HashMap;

/* renamed from: com.bytedance.sdk.openadsdk.multipro.aidl.a.c */
public class CommonDialogListenerManagerImpl extends AbstractListenerManager {
    /* renamed from: a */
    public static HashMap<String, RemoteCallbackList<ICommonDialogListener>> f9016a = new HashMap<>();
    /* renamed from: b */
    private static volatile CommonDialogListenerManagerImpl f9017b;

    /* renamed from: a */
    public static CommonDialogListenerManagerImpl m11786a() {
        if (f9017b == null) {
            synchronized (CommonDialogListenerManagerImpl.class) {
                if (f9017b == null) {
                    f9017b = new CommonDialogListenerManagerImpl();
                }
            }
        }
        return f9017b;
    }

    public void registerDialogListener(String str, ICommonDialogListener iCommonDialogListener) throws RemoteException {
        if (iCommonDialogListener != null) {
            RemoteCallbackList remoteCallbackList = new RemoteCallbackList();
            remoteCallbackList.register(iCommonDialogListener);
            f9016a.put(str, remoteCallbackList);
        }
    }

    public void broadcastDialogListener(String str, int i) throws RemoteException {
        RemoteCallbackList remoteCallbackList = (RemoteCallbackList) f9016a.remove(str);
        if (remoteCallbackList != null) {
            int beginBroadcast = remoteCallbackList.beginBroadcast();
            for (int i2 = 0; i2 < beginBroadcast; i2++) {
                ICommonDialogListener iCommonDialogListener = (ICommonDialogListener) remoteCallbackList.getBroadcastItem(i2);
                if (iCommonDialogListener != null) {
                    if (i == 1) {
                        iCommonDialogListener.onDialogBtnYes();
                    } else if (i == 2) {
                        iCommonDialogListener.onDialogBtnNo();
                    } else if (i != 3) {
                        iCommonDialogListener.onDialogCancel();
                    } else {
                        iCommonDialogListener.onDialogCancel();
                    }
                }
            }
            remoteCallbackList.finishBroadcast();
            remoteCallbackList.kill();
        }
    }
}
