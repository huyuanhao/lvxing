package com.bytedance.sdk.openadsdk.multipro.aidl.p201a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.multipro.aidl.a.e */
public class FullScreenVideoListenerManagerImpl extends AbstractListenerManager {
    /* renamed from: a */
    private static Map<String, RemoteCallbackList<IFullScreenVideoAdInteractionListener>> f9020a = Collections.synchronizedMap(new HashMap());
    /* renamed from: b */
    private static volatile FullScreenVideoListenerManagerImpl f9021b;

    /* renamed from: a */
    public static FullScreenVideoListenerManagerImpl m11788a() {
        if (f9021b == null) {
            synchronized (FullScreenVideoListenerManagerImpl.class) {
                if (f9021b == null) {
                    f9021b = new FullScreenVideoListenerManagerImpl();
                }
            }
        }
        return f9021b;
    }

    public synchronized void registerFullVideoListener(String str, IFullScreenVideoAdInteractionListener iFullScreenVideoAdInteractionListener) throws RemoteException {
        RemoteCallbackList remoteCallbackList = new RemoteCallbackList();
        remoteCallbackList.register(iFullScreenVideoAdInteractionListener);
        f9020a.put(str, remoteCallbackList);
    }

    public void executeFullVideoCallback(String str, String str2) throws RemoteException {
        m11789a(str, str2);
    }

    /* renamed from: a */
    private synchronized void m11789a(String str, String str2) {
        RemoteCallbackList remoteCallbackList;
        try {
            if (f9020a != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackList = (RemoteCallbackList) f9020a.remove(str);
                } else {
                    remoteCallbackList = (RemoteCallbackList) f9020a.get(str);
                }
                if (remoteCallbackList != null) {
                    int beginBroadcast = remoteCallbackList.beginBroadcast();
                    for (int i = 0; i < beginBroadcast; i++) {
                        IFullScreenVideoAdInteractionListener iFullScreenVideoAdInteractionListener = (IFullScreenVideoAdInteractionListener) remoteCallbackList.getBroadcastItem(i);
                        if (iFullScreenVideoAdInteractionListener != null) {
                            if ("onAdShow".equals(str2)) {
                                iFullScreenVideoAdInteractionListener.onAdShow();
                            } else if ("onAdClose".equals(str2)) {
                                iFullScreenVideoAdInteractionListener.onAdClose();
                            } else if ("onVideoComplete".equals(str2)) {
                                iFullScreenVideoAdInteractionListener.onVideoComplete();
                            } else if ("onSkippedVideo".equals(str2)) {
                                iFullScreenVideoAdInteractionListener.onSkippedVideo();
                            } else if ("onAdVideoBarClick".equals(str2)) {
                                iFullScreenVideoAdInteractionListener.onAdVideoBarClick();
                            } else if ("recycleRes".equals(str2)) {
                                iFullScreenVideoAdInteractionListener.onDestroy();
                            }
                        }
                    }
                    remoteCallbackList.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackList.kill();
                    }
                }
            }
        } catch (Throwable th) {
            String str3 = "MultiProcess";
            StringBuilder sb = new StringBuilder();
            sb.append("fullScreen1 method ");
            sb.append(str2);
            sb.append(" throws Exception :");
            C2564t.m12223c(str3, sb.toString(), th);
        }
        return;
    }
}
