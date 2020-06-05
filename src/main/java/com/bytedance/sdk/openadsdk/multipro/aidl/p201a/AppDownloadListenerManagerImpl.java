package com.bytedance.sdk.openadsdk.multipro.aidl.p201a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;
import com.bytedance.sdk.openadsdk.multipro.aidl.p202b.TTAppDownloadListenerImpl;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.multipro.aidl.a.b */
public class AppDownloadListenerManagerImpl extends AbstractListenerManager {
    /* renamed from: a */
    private static Map<String, RemoteCallbackList<ITTAppDownloadListener>> f9014a = Collections.synchronizedMap(new HashMap());
    /* renamed from: b */
    private static volatile AppDownloadListenerManagerImpl f9015b;

    /* renamed from: a */
    public static AppDownloadListenerManagerImpl m11783a() {
        if (f9015b == null) {
            synchronized (AppDownloadListenerManagerImpl.class) {
                if (f9015b == null) {
                    f9015b = new AppDownloadListenerManagerImpl();
                }
            }
        }
        return f9015b;
    }

    public void registerTTAppDownloadListener(String str, ITTAppDownloadListener iTTAppDownloadListener) throws RemoteException {
        RemoteCallbackList remoteCallbackList = new RemoteCallbackList();
        remoteCallbackList.register(iTTAppDownloadListener);
        f9014a.put(str, remoteCallbackList);
        StringBuilder sb = new StringBuilder();
        sb.append("aidl registerTTAppDownloadListener, materialMd5:");
        sb.append(str);
        String sb2 = sb.toString();
        String str2 = "DMLibManager";
        C2564t.m12226e(str2, sb2);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("aidl registerTTAppDownloadListener, mListenerMap size:");
        sb3.append(f9014a.size());
        C2564t.m12226e(str2, sb3.toString());
    }

    public void unregisterTTAppDownloadListener(String str, ITTAppDownloadListener iTTAppDownloadListener) throws RemoteException {
        Map<String, RemoteCallbackList<ITTAppDownloadListener>> map = f9014a;
        String str2 = "DMLibManager";
        if (map == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("aidl unregisterTTAppDownloadListener mListenerMap = null, materialMd5:");
            sb.append(str);
            C2564t.m12226e(str2, sb.toString());
            return;
        }
        RemoteCallbackList remoteCallbackList = (RemoteCallbackList) map.remove(str);
        if (remoteCallbackList == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("aidl unregisterTTAppDownloadListener cbs = null, materialMd5:");
            sb2.append(str);
            C2564t.m12226e(str2, sb2.toString());
            return;
        }
        m11784a(remoteCallbackList);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("aidl unregisterTTAppDownloadListener, materialMd5:");
        sb3.append(str);
        C2564t.m12226e(str2, sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("aidl unregisterTTAppDownloadListener, mListenerMap size:");
        sb4.append(f9014a.size());
        C2564t.m12226e(str2, sb4.toString());
    }

    public void executeAppDownloadCallback(String str, String str2, long j, long j2, String str3, String str4) throws RemoteException {
        m11785a(str, str2, j, j2, str3, str4);
    }

    /* renamed from: a */
    private synchronized void m11785a(String str, String str2, long j, long j2, String str3, String str4) {
        String str5 = str;
        String str6 = str2;
        String str7 = str3;
        String str8 = str4;
        synchronized (this) {
            try {
                if (f9014a != null) {
                    if ("recycleRes".equals(str6)) {
                        m11784a((RemoteCallbackList) f9014a.remove(str5));
                        StringBuilder sb = new StringBuilder();
                        sb.append("aidl executeMultiProcessAppDownloadCallBack recycle res, materialMd5:");
                        sb.append(str5);
                        C2564t.m12226e("DMLibManager", sb.toString());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("aidl executeMultiProcessAppDownloadCallBack recycle res, mListenerMap sizee:");
                        sb2.append(f9014a.size());
                        C2564t.m12226e("DMLibManager", sb2.toString());
                        return;
                    }
                    RemoteCallbackList remoteCallbackList = (RemoteCallbackList) f9014a.get(str5);
                    if (remoteCallbackList != null) {
                        int beginBroadcast = remoteCallbackList.beginBroadcast();
                        for (int i = 0; i < beginBroadcast; i++) {
                            try {
                                ITTAppDownloadListener iTTAppDownloadListener = (ITTAppDownloadListener) remoteCallbackList.getBroadcastItem(i);
                                if (iTTAppDownloadListener != null) {
                                    if ("onIdle".equals(str6)) {
                                        iTTAppDownloadListener.onIdle();
                                    } else if ("onDownloadActive".equals(str6)) {
                                        iTTAppDownloadListener.onDownloadActive(j, j2, str3, str4);
                                    } else if ("onDownloadPaused".equals(str6)) {
                                        iTTAppDownloadListener.onDownloadPaused(j, j2, str3, str4);
                                    } else if ("onDownloadFailed".equals(str6)) {
                                        iTTAppDownloadListener.onDownloadFailed(j, j2, str3, str4);
                                    } else {
                                        if ("onDownloadFinished".equals(str6)) {
                                            try {
                                                iTTAppDownloadListener.onDownloadFinished(j, str7, str8);
                                            } catch (Throwable th) {
                                                th = th;
                                                String str9 = "MultiProcess";
                                                StringBuilder sb3 = new StringBuilder();
                                                sb3.append("AppDownloadListenerManagerImpl MultiProcess1: ");
                                                sb3.append(str6);
                                                sb3.append(" throws Exception :");
                                                C2564t.m12223c(str9, sb3.toString(), th);
                                            }
                                        } else {
                                            long j3 = j;
                                            if ("onInstalled".equals(str6)) {
                                                iTTAppDownloadListener.onInstalled(str7, str8);
                                            }
                                        }
                                    }
                                }
                                long j4 = j;
                            } catch (Throwable th2) {
                                th = th2;
                                long j5 = j;
                                String str92 = "MultiProcess";
                                StringBuilder sb32 = new StringBuilder();
                                sb32.append("AppDownloadListenerManagerImpl MultiProcess1: ");
                                sb32.append(str6);
                                sb32.append(" throws Exception :");
                                C2564t.m12223c(str92, sb32.toString(), th);
                            }
                        }
                        remoteCallbackList.finishBroadcast();
                    }
                } else {
                    return;
                }
            } catch (Throwable th3) {
                String str10 = "MultiProcess";
                StringBuilder sb4 = new StringBuilder();
                sb4.append("AppDownloadListenerManagerImpl MultiProcess2: ");
                sb4.append(str6);
                sb4.append(" throws Exception :");
                C2564t.m12223c(str10, sb4.toString(), th3);
            }
        }
    }

    /* renamed from: a */
    private void m11784a(RemoteCallbackList<ITTAppDownloadListener> remoteCallbackList) {
        String str = "MultiProcess";
        if (remoteCallbackList != null) {
            try {
                int beginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    ITTAppDownloadListener iTTAppDownloadListener = (ITTAppDownloadListener) remoteCallbackList.getBroadcastItem(i);
                    if (iTTAppDownloadListener != null) {
                        ((TTAppDownloadListenerImpl) iTTAppDownloadListener).mo16879a();
                    }
                }
                remoteCallbackList.finishBroadcast();
                remoteCallbackList.kill();
            } catch (Throwable th) {
                C2564t.m12223c(str, "recycleRes2 throw Exception : ", th);
            }
        }
    }
}
