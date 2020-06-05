package com.bytedance.sdk.openadsdk.multipro.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IBinderPool.Stub;
import com.bytedance.sdk.openadsdk.multipro.aidl.p201a.AppDownloadListenerManagerImpl;
import com.bytedance.sdk.openadsdk.multipro.aidl.p201a.CommonDialogListenerManagerImpl;
import com.bytedance.sdk.openadsdk.multipro.aidl.p201a.CommonPermissionListenerManagerImpl;
import com.bytedance.sdk.openadsdk.multipro.aidl.p201a.FullScreenVideoListenerManagerImpl;
import com.bytedance.sdk.openadsdk.multipro.aidl.p201a.RewardAdVideoListenerManagerImpl;
import com.bytedance.sdk.openadsdk.utils.C2564t;

public class BinderPoolService extends Service {
    /* renamed from: a */
    private Binder f9003a = new C2497a();

    /* renamed from: com.bytedance.sdk.openadsdk.multipro.aidl.BinderPoolService$a */
    public static class C2497a extends Stub {
        public IBinder queryBinder(int i) throws RemoteException {
            StringBuilder sb = new StringBuilder();
            sb.append("queryBinder...........binderCode=");
            sb.append(i);
            C2564t.m12222c("MultiProcess", sb.toString());
            if (i == 0) {
                return RewardAdVideoListenerManagerImpl.m11790a();
            }
            if (i == 1) {
                return FullScreenVideoListenerManagerImpl.m11788a();
            }
            if (i == 2) {
                return CommonDialogListenerManagerImpl.m11786a();
            }
            if (i == 3) {
                return AppDownloadListenerManagerImpl.m11783a();
            }
            if (i != 4) {
                return null;
            }
            return CommonPermissionListenerManagerImpl.m11787a();
        }
    }

    public void onCreate() {
        super.onCreate();
        C2564t.m12220b("MultiProcess", "BinderPoolService has been created ! ");
    }

    public IBinder onBind(Intent intent) {
        C2564t.m12220b("MultiProcess", "BinderPoolService onBind ! ");
        return this.f9003a;
    }

    public void onDestroy() {
        super.onDestroy();
        C2564t.m12220b("MultiProcess", "BinderPoolService is destroy ! ");
    }
}
