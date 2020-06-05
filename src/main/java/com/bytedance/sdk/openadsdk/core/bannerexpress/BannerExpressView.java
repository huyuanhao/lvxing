package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.utils.UIUtils;

/* renamed from: com.bytedance.sdk.openadsdk.core.bannerexpress.a */
class BannerExpressView extends FrameLayout {
    /* renamed from: a */
    private final Context f7257a;
    /* renamed from: b */
    private NativeExpressView f7258b;
    /* renamed from: c */
    private NativeExpressView f7259c;
    /* renamed from: d */
    private MaterialMeta f7260d;
    /* renamed from: e */
    private AdSlot f7261e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public ExpressAdInteractionListener f7262f;
    /* renamed from: g */
    private int f7263g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public boolean f7264h;
    /* renamed from: i */
    private String f7265i = "banner_ad";

    public BannerExpressView(Context context, MaterialMeta kVar, AdSlot adSlot) {
        super(context);
        this.f7257a = context;
        this.f7260d = kVar;
        this.f7261e = adSlot;
        m9122g();
    }

    /* renamed from: g */
    private void m9122g() {
        this.f7258b = new NativeExpressView(this.f7257a, this.f7260d, this.f7261e, this.f7265i);
        addView(this.f7258b, new LayoutParams(-1, -1));
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* renamed from: a */
    public void mo15302a(MaterialMeta kVar, AdSlot adSlot) {
        this.f7259c = new NativeExpressView(this.f7257a, kVar, adSlot, this.f7265i);
        this.f7259c.setExpressInteractionListener(new ExpressAdInteractionListener() {
            public void onAdShow(View view, int i) {
            }

            public void onRenderFail(View view, String str, int i) {
            }

            public void onAdClicked(View view, int i) {
                if (BannerExpressView.this.f7262f != null) {
                    BannerExpressView.this.f7262f.onAdClicked(BannerExpressView.this, i);
                }
            }

            public void onRenderSuccess(View view, float f, float f2) {
                BannerExpressView.this.m9116a(f, f2);
                BannerExpressView.this.m9123h();
            }
        });
        UIUtils.m12059a((View) this.f7259c, 8);
        addView(this.f7259c, new LayoutParams(-1, -1));
    }

    /* renamed from: a */
    public void mo15301a(ExpressAdInteractionListener expressAdInteractionListener) {
        this.f7262f = expressAdInteractionListener;
        this.f7258b.setExpressInteractionListener(new ExpressAdInteractionListener() {
            public void onAdShow(View view, int i) {
            }

            public void onAdClicked(View view, int i) {
                if (BannerExpressView.this.f7262f != null) {
                    BannerExpressView.this.f7262f.onAdClicked(BannerExpressView.this, i);
                }
            }

            public void onRenderFail(View view, String str, int i) {
                if (BannerExpressView.this.f7262f != null) {
                    BannerExpressView.this.f7262f.onRenderFail(BannerExpressView.this, str, i);
                }
            }

            public void onRenderSuccess(View view, float f, float f2) {
                if (!(view instanceof NativeExpressView) || !((NativeExpressView) view).mo15883m()) {
                    BannerExpressView.this.m9116a(f, f2);
                }
                if (BannerExpressView.this.f7262f != null) {
                    BannerExpressView.this.f7262f.onRenderSuccess(BannerExpressView.this, f, f2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9116a(float f, float f2) {
        int a = (int) UIUtils.m12048a(this.f7257a, f);
        int a2 = (int) UIUtils.m12048a(this.f7257a, f2);
        LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(a, a2);
        }
        layoutParams.width = a;
        layoutParams.height = a2;
        setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    public void mo15299a() {
        NativeExpressView nativeExpressView = this.f7258b;
        if (nativeExpressView != null) {
            nativeExpressView.mo15878h();
        }
    }

    /* renamed from: b */
    public void mo15303b() {
        NativeExpressView nativeExpressView = this.f7258b;
        if (nativeExpressView != null) {
            removeView(nativeExpressView);
            this.f7258b.mo15881k();
            this.f7258b = null;
        }
        NativeExpressView nativeExpressView2 = this.f7259c;
        if (nativeExpressView2 != null) {
            removeView(nativeExpressView2);
            this.f7259c.mo15881k();
            this.f7259c = null;
        }
    }

    /* renamed from: c */
    public NativeExpressView mo15304c() {
        return this.f7258b;
    }

    /* renamed from: d */
    public NativeExpressView mo15305d() {
        return this.f7259c;
    }

    /* renamed from: a */
    public void mo15300a(int i) {
        this.f7263g = i;
    }

    /* renamed from: a */
    private ObjectAnimator m9114a(NativeExpressView nativeExpressView) {
        return ObjectAnimator.ofFloat(nativeExpressView, "translationX", new float[]{0.0f, (float) (-getWidth())});
    }

    /* renamed from: b */
    private ObjectAnimator m9119b(NativeExpressView nativeExpressView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(nativeExpressView, "translationX", new float[]{(float) getWidth(), 0.0f});
        ofFloat.addListener(new AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                BannerExpressView.this.f7264h = false;
                BannerExpressView.this.m9124i();
            }
        });
        return ofFloat;
    }

    /* renamed from: e */
    public void mo15306e() {
        NativeExpressView nativeExpressView = this.f7259c;
        if (nativeExpressView != null) {
            nativeExpressView.mo15878h();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m9123h() {
        if (!this.f7264h) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(m9114a(this.f7258b)).with(m9119b(this.f7259c));
            animatorSet.setDuration((long) this.f7263g).start();
            UIUtils.m12059a((View) this.f7259c, 0);
            this.f7264h = true;
        }
    }

    /* renamed from: f */
    public boolean mo15307f() {
        return this.f7259c != null;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m9124i() {
        NativeExpressView nativeExpressView = this.f7258b;
        this.f7258b = this.f7259c;
        this.f7259c = nativeExpressView;
        NativeExpressView nativeExpressView2 = this.f7259c;
        if (nativeExpressView2 != null) {
            removeView(nativeExpressView2);
            this.f7259c.mo15881k();
            this.f7259c = null;
        }
    }
}
