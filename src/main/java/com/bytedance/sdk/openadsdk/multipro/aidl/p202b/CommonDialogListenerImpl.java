package com.bytedance.sdk.openadsdk.multipro.aidl.p202b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ICommonDialogListener.Stub;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.CommonDialogHelper.C2550a;

/* renamed from: com.bytedance.sdk.openadsdk.multipro.aidl.b.a */
public class CommonDialogListenerImpl extends Stub {
    /* renamed from: a */
    private Handler f9024a = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    /* renamed from: b */
    public C2550a f9025b;

    public CommonDialogListenerImpl(C2550a aVar) {
        this.f9025b = aVar;
    }

    public void onDialogBtnYes() throws RemoteException {
        C2564t.m12220b("CommonDialogListenerImpl", "CommonDialogListenerImpl: onDialogBtnYes");
        m11793a((Runnable) new Runnable() {
            public void run() {
                if (CommonDialogListenerImpl.this.f9025b != null) {
                    CommonDialogListenerImpl.this.f9025b.mo16493a();
                }
            }
        });
    }

    public void onDialogBtnNo() throws RemoteException {
        C2564t.m12220b("CommonDialogListenerImpl", "CommonDialogListenerImpl: onDialogBtnNo");
        m11793a((Runnable) new Runnable() {
            public void run() {
                if (CommonDialogListenerImpl.this.f9025b != null) {
                    CommonDialogListenerImpl.this.f9025b.mo16494b();
                }
            }
        });
    }

    public void onDialogCancel() throws RemoteException {
        C2564t.m12220b("CommonDialogListenerImpl", "CommonDialogListenerImpl: onDialogCancel");
        m11793a((Runnable) new Runnable() {
            public void run() {
                if (CommonDialogListenerImpl.this.f9025b != null) {
                    CommonDialogListenerImpl.this.f9025b.mo16495c();
                }
            }
        });
    }

    /* renamed from: a */
    private void m11793a(Runnable runnable) {
        this.f9024a.post(runnable);
    }
}
