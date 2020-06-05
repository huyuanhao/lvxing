package com.bytedance.sdk.openadsdk.multipro.aidl.p201a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.multipro.aidl.a.f */
public class RewardAdVideoListenerManagerImpl extends AbstractListenerManager {
    /* renamed from: a */
    private static Map<String, RemoteCallbackList<IRewardAdInteractionListener>> f9022a = Collections.synchronizedMap(new HashMap());
    /* renamed from: b */
    private static volatile RewardAdVideoListenerManagerImpl f9023b;

    /* renamed from: a */
    public static RewardAdVideoListenerManagerImpl m11790a() {
        if (f9023b == null) {
            synchronized (RewardAdVideoListenerManagerImpl.class) {
                if (f9023b == null) {
                    f9023b = new RewardAdVideoListenerManagerImpl();
                }
            }
        }
        return f9023b;
    }

    public synchronized void registerRewardVideoListener(String str, IRewardAdInteractionListener iRewardAdInteractionListener) throws RemoteException {
        RemoteCallbackList remoteCallbackList = new RemoteCallbackList();
        remoteCallbackList.register(iRewardAdInteractionListener);
        f9022a.put(str, remoteCallbackList);
    }

    public void executeRewardVideoCallback(String str, String str2, boolean z, int i, String str3) throws RemoteException {
        m11791a(str, str2, z, i, str3);
    }

    /* renamed from: a */
    private synchronized void m11791a(String str, String str2, boolean z, int i, String str3) {
        RemoteCallbackList remoteCallbackList;
        try {
            if (f9022a != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackList = (RemoteCallbackList) f9022a.remove(str);
                } else {
                    remoteCallbackList = (RemoteCallbackList) f9022a.get(str);
                }
                if (remoteCallbackList != null) {
                    int beginBroadcast = remoteCallbackList.beginBroadcast();
                    for (int i2 = 0; i2 < beginBroadcast; i2++) {
                        IRewardAdInteractionListener iRewardAdInteractionListener = (IRewardAdInteractionListener) remoteCallbackList.getBroadcastItem(i2);
                        if (iRewardAdInteractionListener != null) {
                            if ("onAdShow".equals(str2)) {
                                iRewardAdInteractionListener.onAdShow();
                            } else if ("onAdClose".equals(str2)) {
                                iRewardAdInteractionListener.onAdClose();
                            } else if ("onVideoComplete".equals(str2)) {
                                iRewardAdInteractionListener.onVideoComplete();
                            } else if ("onVideoError".equals(str2)) {
                                iRewardAdInteractionListener.onVideoError();
                            } else if ("onAdVideoBarClick".equals(str2)) {
                                iRewardAdInteractionListener.onAdVideoBarClick();
                            } else if ("onRewardVerify".equals(str2)) {
                                iRewardAdInteractionListener.onRewardVerify(z, i, str3);
                            } else if ("onSkippedVideo".equals(str2)) {
                                iRewardAdInteractionListener.onSkippedVideo();
                            } else if ("recycleRes".equals(str2)) {
                                iRewardAdInteractionListener.onDestroy();
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
            String str4 = "MultiProcess";
            StringBuilder sb = new StringBuilder();
            sb.append("reward2 '");
            sb.append(str2);
            sb.append("'  throws Exception :");
            C2564t.m12223c(str4, sb.toString(), th);
        }
        return;
    }
}
