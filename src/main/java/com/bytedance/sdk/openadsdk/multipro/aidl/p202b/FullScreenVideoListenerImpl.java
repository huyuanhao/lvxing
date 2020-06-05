package com.bytedance.sdk.openadsdk.multipro.aidl.p202b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener.Stub;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener;

/* renamed from: com.bytedance.sdk.openadsdk.multipro.aidl.b.c */
public class FullScreenVideoListenerImpl extends Stub {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public FullScreenVideoAdInteractionListener f9034a;
    /* renamed from: b */
    private Handler f9035b = new Handler(Looper.getMainLooper());

    public FullScreenVideoListenerImpl(FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f9034a = fullScreenVideoAdInteractionListener;
    }

    /* renamed from: a */
    private void m11797a() {
        this.f9034a = null;
        this.f9035b = null;
    }

    /* renamed from: b */
    private Handler m11798b() {
        Handler handler = this.f9035b;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.f9035b = handler2;
        return handler2;
    }

    public void onDestroy() throws RemoteException {
        m11797a();
    }

    public void onAdShow() throws RemoteException {
        m11798b().post(new Runnable() {
            public void run() {
                if (FullScreenVideoListenerImpl.this.f9034a != null) {
                    FullScreenVideoListenerImpl.this.f9034a.onAdShow();
                }
            }
        });
    }

    public void onAdVideoBarClick() throws RemoteException {
        m11798b().post(new Runnable() {
            public void run() {
                if (FullScreenVideoListenerImpl.this.f9034a != null) {
                    FullScreenVideoListenerImpl.this.f9034a.onAdVideoBarClick();
                }
            }
        });
    }

    public void onAdClose() throws RemoteException {
        m11798b().post(new Runnable() {
            public void run() {
                if (FullScreenVideoListenerImpl.this.f9034a != null) {
                    FullScreenVideoListenerImpl.this.f9034a.onAdClose();
                }
            }
        });
    }

    public void onVideoComplete() throws RemoteException {
        m11798b().post(new Runnable() {
            public void run() {
                if (FullScreenVideoListenerImpl.this.f9034a != null) {
                    FullScreenVideoListenerImpl.this.f9034a.onVideoComplete();
                }
            }
        });
    }

    public void onSkippedVideo() throws RemoteException {
        m11798b().post(new Runnable() {
            public void run() {
                if (FullScreenVideoListenerImpl.this.f9034a != null) {
                    FullScreenVideoListenerImpl.this.f9034a.onSkippedVideo();
                }
            }
        });
    }
}
