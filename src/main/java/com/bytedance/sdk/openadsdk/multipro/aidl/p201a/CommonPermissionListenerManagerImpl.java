package com.bytedance.sdk.openadsdk.multipro.aidl.p201a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ICommonPermissionListener;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import java.util.HashMap;

/* renamed from: com.bytedance.sdk.openadsdk.multipro.aidl.a.d */
public class CommonPermissionListenerManagerImpl extends AbstractListenerManager {
    /* renamed from: a */
    private static HashMap<String, RemoteCallbackList<ICommonPermissionListener>> f9018a = new HashMap<>();
    /* renamed from: b */
    private static volatile CommonPermissionListenerManagerImpl f9019b;

    /* renamed from: a */
    public static CommonPermissionListenerManagerImpl m11787a() {
        if (f9019b == null) {
            synchronized (CommonPermissionListenerManagerImpl.class) {
                if (f9019b == null) {
                    f9019b = new CommonPermissionListenerManagerImpl();
                }
            }
        }
        return f9019b;
    }

    public void registerPermissionListener(String str, ICommonPermissionListener iCommonPermissionListener) throws RemoteException {
        if (iCommonPermissionListener != null) {
            C2564t.m12220b("MultiProcess", "CommonPermissionListenerManagerImpl registerPermissionListener");
            RemoteCallbackList remoteCallbackList = new RemoteCallbackList();
            remoteCallbackList.register(iCommonPermissionListener);
            f9018a.put(str, remoteCallbackList);
        }
    }

    public void broadcastPermissionListener(String str, String str2) throws RemoteException {
        StringBuilder sb = new StringBuilder();
        sb.append("00000 CommonPermissionListenerManagerImpl broadcastDialogListener: 00000");
        sb.append(String.valueOf(str));
        String str3 = ", ";
        sb.append(str3);
        sb.append(str2);
        String str4 = "MultiProcess";
        C2564t.m12220b(str4, sb.toString());
        RemoteCallbackList remoteCallbackList = (RemoteCallbackList) f9018a.remove(str);
        if (remoteCallbackList != null) {
            int beginBroadcast = remoteCallbackList.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                ICommonPermissionListener iCommonPermissionListener = (ICommonPermissionListener) remoteCallbackList.getBroadcastItem(i);
                if (iCommonPermissionListener != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("CommonPermissionListenerManagerImpl broadcastDialogListener: ");
                    sb2.append(String.valueOf(str));
                    sb2.append(str3);
                    sb2.append(str2);
                    C2564t.m12220b(str4, sb2.toString());
                    if (str2 == null) {
                        iCommonPermissionListener.onGranted();
                    } else {
                        iCommonPermissionListener.onDenied(str2);
                    }
                }
            }
            remoteCallbackList.finishBroadcast();
            remoteCallbackList.kill();
        }
    }
}
