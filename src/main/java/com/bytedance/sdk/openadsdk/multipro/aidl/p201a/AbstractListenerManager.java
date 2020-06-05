package com.bytedance.sdk.openadsdk.multipro.aidl.p201a;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ICommonDialogListener;
import com.bytedance.sdk.openadsdk.ICommonPermissionListener;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.IListenerManager.Stub;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;

/* renamed from: com.bytedance.sdk.openadsdk.multipro.aidl.a.a */
public abstract class AbstractListenerManager extends Stub {
    public void broadcastDialogListener(String str, int i) throws RemoteException {
    }

    public void broadcastPermissionListener(String str, String str2) throws RemoteException {
    }

    public void executeAppDownloadCallback(String str, String str2, long j, long j2, String str3, String str4) throws RemoteException {
    }

    public void executeFullVideoCallback(String str, String str2) throws RemoteException {
    }

    public void executeRewardVideoCallback(String str, String str2, boolean z, int i, String str3) throws RemoteException {
    }

    public void registerDialogListener(String str, ICommonDialogListener iCommonDialogListener) throws RemoteException {
    }

    public void registerFullVideoListener(String str, IFullScreenVideoAdInteractionListener iFullScreenVideoAdInteractionListener) throws RemoteException {
    }

    public void registerPermissionListener(String str, ICommonPermissionListener iCommonPermissionListener) throws RemoteException {
    }

    public void registerRewardVideoListener(String str, IRewardAdInteractionListener iRewardAdInteractionListener) throws RemoteException {
    }

    public void registerTTAppDownloadListener(String str, ITTAppDownloadListener iTTAppDownloadListener) throws RemoteException {
    }

    public void unregisterTTAppDownloadListener(String str, ITTAppDownloadListener iTTAppDownloadListener) throws RemoteException {
    }
}
