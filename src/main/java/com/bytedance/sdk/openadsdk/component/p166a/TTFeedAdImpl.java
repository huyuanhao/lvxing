package com.bytedance.sdk.openadsdk.component.p166a;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p171e.TTNativeAdImpl;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.INativeVideoController.C2325b;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.INativeVideoController.C2326c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.C2322a;
import com.bytedance.sdk.openadsdk.multipro.p203b.VideoControllerDataModel;
import com.bytedance.sdk.openadsdk.multipro.p203b.VideoControllerDataModel.C2523a;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;

/* renamed from: com.bytedance.sdk.openadsdk.component.a.c */
class TTFeedAdImpl extends TTNativeAdImpl implements TTFeedAd, C2325b, C2326c, C2523a {
    /* renamed from: a */
    VideoControllerDataModel f6830a;
    /* renamed from: b */
    boolean f6831b = false;
    /* renamed from: c */
    boolean f6832c = true;
    /* renamed from: d */
    int f6833d;
    /* renamed from: e */
    AdSlot f6834e;
    /* renamed from: f */
    int f6835f;
    /* renamed from: m */
    private VideoAdListener f6836m;

    TTFeedAdImpl(Context context, MaterialMeta kVar, int i) {
        super(context, kVar, i);
        this.f6835f = i;
        this.f6830a = new VideoControllerDataModel();
        this.f6833d = ToolUtils.m12018d(this.f7501h.mo15428P());
        m8549a(this.f6833d);
    }

    TTFeedAdImpl(Context context, MaterialMeta kVar, int i, AdSlot adSlot) {
        super(context, kVar, i);
        this.f6835f = i;
        this.f6834e = adSlot;
        this.f6830a = new VideoControllerDataModel();
        this.f6833d = ToolUtils.m12018d(this.f7501h.mo15428P());
        m8549a(this.f6833d);
    }

    public View getAdView() {
        NativeVideoTsView nativeVideoTsView;
        if (!(this.f7501h == null || this.f7502i == null)) {
            if (mo15053g()) {
                try {
                    nativeVideoTsView = new NativeVideoTsView(this.f7502i, this.f7501h);
                    nativeVideoTsView.setControllerStatusCallBack(new C2322a() {
                        /* renamed from: a */
                        public void mo15052a(boolean z, long j, long j2, long j3, boolean z2) {
                            TTFeedAdImpl.this.f6830a.f9080a = z;
                            TTFeedAdImpl.this.f6830a.f9084e = j;
                            TTFeedAdImpl.this.f6830a.f9085f = j2;
                            TTFeedAdImpl.this.f6830a.f9086g = j3;
                            TTFeedAdImpl.this.f6830a.f9083d = z2;
                        }
                    });
                    nativeVideoTsView.setVideoAdLoadListener(this);
                    nativeVideoTsView.setVideoAdInteractionListener(this);
                    if (5 == this.f6835f) {
                        nativeVideoTsView.setIsAutoPlay(this.f6831b ? this.f6834e.isAutoPlay() : this.f6832c);
                    } else {
                        nativeVideoTsView.setIsAutoPlay(this.f6832c);
                    }
                    nativeVideoTsView.setIsQuiet(InternalContainer.m10069h().mo15774a(this.f6833d));
                } catch (Exception unused) {
                }
                if (mo15053g() || nativeVideoTsView == null || !nativeVideoTsView.mo16094a(0, true, false)) {
                    return null;
                }
                return nativeVideoTsView;
            }
            nativeVideoTsView = null;
            if (mo15053g()) {
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public boolean mo15053g() {
        return getImageMode() == 5 || getImageMode() == 15;
    }

    /* renamed from: a */
    private void m8549a(int i) {
        int c = InternalContainer.m10069h().mo15779c(i);
        if (3 == c) {
            this.f6831b = false;
            this.f6832c = false;
        } else if (1 == c && C2566w.m12245d(this.f7502i)) {
            this.f6831b = false;
            this.f6832c = true;
        } else if (2 == c) {
            if (C2566w.m12246e(this.f7502i) || C2566w.m12245d(this.f7502i)) {
                this.f6831b = false;
                this.f6832c = true;
            }
        } else if (4 == c) {
            this.f6831b = true;
        }
    }

    public void setVideoAdListener(VideoAdListener videoAdListener) {
        this.f6836m = videoAdListener;
    }

    public double getVideoDuration() {
        if (this.f7501h == null || this.f7501h.mo15512z() == null) {
            return 0.0d;
        }
        return this.f7501h.mo15512z().mo15596d();
    }

    /* renamed from: f */
    public void mo15051f() {
        VideoAdListener videoAdListener = this.f6836m;
        if (videoAdListener != null) {
            videoAdListener.onVideoLoad(this);
        }
    }

    /* renamed from: a */
    public void mo15045a(int i, int i2) {
        VideoAdListener videoAdListener = this.f6836m;
        if (videoAdListener != null) {
            videoAdListener.onVideoError(i, i2);
        }
    }

    /* renamed from: e */
    public void mo15050e() {
        VideoAdListener videoAdListener = this.f6836m;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdStartPlay(this);
        }
    }

    /* renamed from: d */
    public void mo15048d() {
        VideoAdListener videoAdListener = this.f6836m;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdPaused(this);
        }
    }

    /* renamed from: c */
    public void mo15047c() {
        VideoAdListener videoAdListener = this.f6836m;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdContinuePlay(this);
        }
    }

    /* renamed from: a */
    public void mo15046a(long j, long j2) {
        VideoAdListener videoAdListener = this.f6836m;
        if (videoAdListener != null) {
            videoAdListener.onProgressUpdate(j, j2);
        }
    }

    /* renamed from: d_ */
    public void mo15049d_() {
        VideoAdListener videoAdListener = this.f6836m;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdComplete(this);
        }
    }

    /* renamed from: a */
    public VideoControllerDataModel mo15044a() {
        return this.f6830a;
    }
}
