package com.bytedance.sdk.openadsdk.multipro.aidl.p202b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ICommonPermissionListener.Stub;
import com.bytedance.sdk.openadsdk.utils.CommonPermissionUtils.C2554a;

/* renamed from: com.bytedance.sdk.openadsdk.multipro.aidl.b.b */
public class CommonPermissionListenerImpl extends Stub {
    /* renamed from: a */
    private Handler f9029a = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    /* renamed from: b */
    public C2554a f9030b;

    public CommonPermissionListenerImpl(C2554a aVar) {
        this.f9030b = aVar;
    }

    public void onGranted() throws RemoteException {
        m11795a((Runnable) new Runnable() {
            public void run() {
                if (CommonPermissionListenerImpl.this.f9030b != null) {
                    CommonPermissionListenerImpl.this.f9030b.mo16483a();
                }
            }
        });
    }

    public void onDenied(final String str) throws RemoteException {
        m11795a((Runnable) new Runnable() {
            public void run() {
                if (CommonPermissionListenerImpl.this.f9030b != null) {
                    CommonPermissionListenerImpl.this.f9030b.mo16484a(str);
                }
            }
        });
    }

    /* renamed from: a */
    private void m11795a(Runnable runnable) {
        if (this.f9029a == null) {
            this.f9029a = new Handler(Looper.getMainLooper());
        }
        this.f9029a.post(runnable);
    }
}
