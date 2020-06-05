package com.bytedance.sdk.openadsdk.component.p166a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd.DrawVideoListener;
import com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.C2322a;
import com.bytedance.sdk.openadsdk.multipro.p203b.VideoControllerDataModel;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;

/* renamed from: com.bytedance.sdk.openadsdk.component.a.b */
public class TTDrawFeedAdImpl extends TTFeedAdImpl implements TTDrawFeedAd {
    /* renamed from: m */
    private boolean f6825m;
    /* renamed from: n */
    private Bitmap f6826n;
    /* renamed from: o */
    private int f6827o;
    /* renamed from: p */
    private DrawVideoListener f6828p;

    /* renamed from: a */
    public /* bridge */ /* synthetic */ VideoControllerDataModel mo15044a() {
        return super.mo15044a();
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo15045a(int i, int i2) {
        super.mo15045a(i, i2);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo15046a(long j, long j2) {
        super.mo15046a(j, j2);
    }

    /* renamed from: c */
    public /* bridge */ /* synthetic */ void mo15047c() {
        super.mo15047c();
    }

    /* renamed from: d */
    public /* bridge */ /* synthetic */ void mo15048d() {
        super.mo15048d();
    }

    /* renamed from: d_ */
    public /* bridge */ /* synthetic */ void mo15049d_() {
        super.mo15049d_();
    }

    /* renamed from: e */
    public /* bridge */ /* synthetic */ void mo15050e() {
        super.mo15050e();
    }

    /* renamed from: f */
    public /* bridge */ /* synthetic */ void mo15051f() {
        super.mo15051f();
    }

    public /* bridge */ /* synthetic */ double getVideoDuration() {
        return super.getVideoDuration();
    }

    public /* bridge */ /* synthetic */ void setVideoAdListener(VideoAdListener videoAdListener) {
        super.setVideoAdListener(videoAdListener);
    }

    public TTDrawFeedAdImpl(Context context, MaterialMeta kVar, int i) {
        super(context, kVar, i);
    }

    public View getAdView() {
        NativeVideoTsView nativeVideoTsView;
        if (!(this.f7501h == null || this.f7502i == null)) {
            if (mo15053g()) {
                try {
                    nativeVideoTsView = new NativeDrawVideoTsView(this.f7502i, this.f7501h);
                    nativeVideoTsView.setControllerStatusCallBack(new C2322a() {
                        /* renamed from: a */
                        public void mo15052a(boolean z, long j, long j2, long j3, boolean z2) {
                            TTDrawFeedAdImpl.this.f6830a.f9080a = z;
                            TTDrawFeedAdImpl.this.f6830a.f9084e = j;
                            TTDrawFeedAdImpl.this.f6830a.f9085f = j2;
                            TTDrawFeedAdImpl.this.f6830a.f9086g = j3;
                            TTDrawFeedAdImpl.this.f6830a.f9083d = z2;
                        }
                    });
                    nativeVideoTsView.setVideoAdLoadListener(this);
                    nativeVideoTsView.setVideoAdInteractionListener(this);
                    int d = ToolUtils.m12018d(this.f7501h.mo15428P());
                    nativeVideoTsView.setIsAutoPlay(m8538a(d));
                    nativeVideoTsView.setIsQuiet(InternalContainer.m10069h().mo15774a(d));
                    ((NativeDrawVideoTsView) nativeVideoTsView).setCanInterruptVideoPlay(this.f6825m);
                    if (this.f6826n != null) {
                        ((NativeDrawVideoTsView) nativeVideoTsView).mo16090a(this.f6826n, this.f6827o);
                    }
                    nativeVideoTsView.setDrawVideoListener(this.f6828p);
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

    public void setCanInterruptVideoPlay(boolean z) {
        this.f6825m = z;
    }

    public void setPauseIcon(Bitmap bitmap, int i) {
        this.f6826n = bitmap;
        this.f6827o = i;
        m8539h();
    }

    /* renamed from: a */
    private boolean m8538a(int i) {
        int c = InternalContainer.m10069h().mo15779c(i);
        if (3 == c) {
            return false;
        }
        if (1 != c || !C2566w.m12245d(this.f7502i)) {
            if (2 != c) {
                return false;
            }
            if (!C2566w.m12246e(this.f7502i) && !C2566w.m12245d(this.f7502i)) {
                return false;
            }
        }
        return true;
    }

    public void setDrawVideoListener(DrawVideoListener drawVideoListener) {
        this.f6828p = drawVideoListener;
    }

    /* renamed from: h */
    private void m8539h() {
        int i = this.f6827o;
        if (i >= 200) {
            this.f6827o = 200;
        } else if (i <= 20) {
            this.f6827o = 20;
        }
    }
}
