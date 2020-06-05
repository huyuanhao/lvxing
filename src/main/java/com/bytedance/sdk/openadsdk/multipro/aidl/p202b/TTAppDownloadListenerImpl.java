package com.bytedance.sdk.openadsdk.multipro.aidl.p202b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener.Stub;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;

/* renamed from: com.bytedance.sdk.openadsdk.multipro.aidl.b.e */
public class TTAppDownloadListenerImpl extends Stub {
    /* access modifiers changed from: private|volatile */
    /* renamed from: a */
    public volatile TTAppDownloadListener f9053a;
    /* renamed from: b */
    private Handler f9054b = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private Handler m11803b() {
        Handler handler = this.f9054b;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.f9054b = handler2;
        return handler2;
    }

    public TTAppDownloadListenerImpl(TTAppDownloadListener tTAppDownloadListener) {
        this.f9053a = tTAppDownloadListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m11805c() {
        return this.f9053a != null;
    }

    public void onIdle() throws RemoteException {
        if (this.f9053a != null) {
            m11803b().post(new Runnable() {
                public void run() {
                    if (TTAppDownloadListenerImpl.this.m11805c()) {
                        TTAppDownloadListenerImpl.this.f9053a.onIdle();
                    }
                }
            });
        }
    }

    public void onDownloadActive(long j, long j2, String str, String str2) throws RemoteException {
        if (this.f9053a != null) {
            Handler b = m11803b();
            final long j3 = j;
            final long j4 = j2;
            final String str3 = str;
            final String str4 = str2;
            C25182 r0 = new Runnable() {
                public void run() {
                    if (TTAppDownloadListenerImpl.this.m11805c()) {
                        TTAppDownloadListenerImpl.this.f9053a.onDownloadActive(j3, j4, str3, str4);
                    }
                }
            };
            b.post(r0);
        }
    }

    public void onDownloadPaused(long j, long j2, String str, String str2) throws RemoteException {
        if (this.f9053a != null) {
            Handler b = m11803b();
            final long j3 = j;
            final long j4 = j2;
            final String str3 = str;
            final String str4 = str2;
            C25193 r0 = new Runnable() {
                public void run() {
                    if (TTAppDownloadListenerImpl.this.m11805c()) {
                        TTAppDownloadListenerImpl.this.f9053a.onDownloadPaused(j3, j4, str3, str4);
                    }
                }
            };
            b.post(r0);
        }
    }

    public void onDownloadFailed(long j, long j2, String str, String str2) throws RemoteException {
        if (this.f9053a != null) {
            Handler b = m11803b();
            final long j3 = j;
            final long j4 = j2;
            final String str3 = str;
            final String str4 = str2;
            C25204 r0 = new Runnable() {
                public void run() {
                    if (TTAppDownloadListenerImpl.this.m11805c()) {
                        TTAppDownloadListenerImpl.this.f9053a.onDownloadFailed(j3, j4, str3, str4);
                    }
                }
            };
            b.post(r0);
        }
    }

    public void onDownloadFinished(long j, String str, String str2) throws RemoteException {
        if (this.f9053a != null) {
            Handler b = m11803b();
            final long j2 = j;
            final String str3 = str;
            final String str4 = str2;
            C25215 r1 = new Runnable() {
                public void run() {
                    if (TTAppDownloadListenerImpl.this.m11805c()) {
                        TTAppDownloadListenerImpl.this.f9053a.onDownloadFinished(j2, str3, str4);
                    }
                }
            };
            b.post(r1);
        }
    }

    public void onInstalled(final String str, final String str2) throws RemoteException {
        if (this.f9053a != null) {
            m11803b().post(new Runnable() {
                public void run() {
                    if (TTAppDownloadListenerImpl.this.m11805c()) {
                        TTAppDownloadListenerImpl.this.f9053a.onInstalled(str, str2);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void mo16879a() {
        this.f9053a = null;
        this.f9054b = null;
    }
}
