package com.bytedance.sdk.openadsdk.multipro.aidl.p202b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener.Stub;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener;

/* renamed from: com.bytedance.sdk.openadsdk.multipro.aidl.b.d */
public class RewardVideoListenerImpl extends Stub {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public RewardAdInteractionListener f9041a;
    /* renamed from: b */
    private Handler f9042b = new Handler(Looper.getMainLooper());

    public RewardVideoListenerImpl(RewardAdInteractionListener rewardAdInteractionListener) {
        this.f9041a = rewardAdInteractionListener;
    }

    /* renamed from: a */
    private void m11800a() {
        this.f9041a = null;
        this.f9042b = null;
    }

    /* renamed from: b */
    private Handler m11801b() {
        Handler handler = this.f9042b;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.f9042b = handler2;
        return handler2;
    }

    public void onDestroy() throws RemoteException {
        m11800a();
    }

    public void onAdShow() throws RemoteException {
        m11801b().post(new Runnable() {
            public void run() {
                if (RewardVideoListenerImpl.this.f9041a != null) {
                    RewardVideoListenerImpl.this.f9041a.onAdShow();
                }
            }
        });
    }

    public void onAdVideoBarClick() throws RemoteException {
        m11801b().post(new Runnable() {
            public void run() {
                if (RewardVideoListenerImpl.this.f9041a != null) {
                    RewardVideoListenerImpl.this.f9041a.onAdVideoBarClick();
                }
            }
        });
    }

    public void onAdClose() throws RemoteException {
        m11801b().post(new Runnable() {
            public void run() {
                if (RewardVideoListenerImpl.this.f9041a != null) {
                    RewardVideoListenerImpl.this.f9041a.onAdClose();
                }
            }
        });
    }

    public void onVideoComplete() throws RemoteException {
        m11801b().post(new Runnable() {
            public void run() {
                if (RewardVideoListenerImpl.this.f9041a != null) {
                    RewardVideoListenerImpl.this.f9041a.onVideoComplete();
                }
            }
        });
    }

    public void onVideoError() throws RemoteException {
        m11801b().post(new Runnable() {
            public void run() {
                if (RewardVideoListenerImpl.this.f9041a != null) {
                    RewardVideoListenerImpl.this.f9041a.onVideoError();
                }
            }
        });
    }

    public void onSkippedVideo() throws RemoteException {
        m11801b().post(new Runnable() {
            public void run() {
                if (RewardVideoListenerImpl.this.f9041a != null) {
                    RewardVideoListenerImpl.this.f9041a.onSkippedVideo();
                }
            }
        });
    }

    public void onRewardVerify(final boolean z, final int i, final String str) throws RemoteException {
        m11801b().post(new Runnable() {
            public void run() {
                if (RewardVideoListenerImpl.this.f9041a != null) {
                    RewardVideoListenerImpl.this.f9041a.onRewardVerify(z, i, str);
                }
            }
        });
    }
}
