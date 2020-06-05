package com.bytedance.sdk.openadsdk.component.banner;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.dislike.TTAdDislikeImpl;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.UIUtils;

/* renamed from: com.bytedance.sdk.openadsdk.component.banner.d */
class BannerView extends FrameLayout {
    /* renamed from: a */
    private final Context f6855a;
    /* renamed from: b */
    private BannerCellView f6856b;
    /* renamed from: c */
    private BannerCellView f6857c;
    /* renamed from: d */
    private ImageView f6858d;
    /* renamed from: e */
    private ImageView f6859e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public TTAdDislikeImpl f6860f;
    /* renamed from: g */
    private int f6861g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public boolean f6862h;
    /* renamed from: i */
    private boolean f6863i = false;
    /* renamed from: j */
    private boolean f6864j = false;

    public BannerView(Context context) {
        super(context);
        this.f6855a = context;
        m8595g();
    }

    /* renamed from: g */
    private void m8595g() {
        this.f6856b = new BannerCellView(this.f6855a);
        addView((View) this.f6856b, (LayoutParams) new FrameLayout.LayoutParams(-1, -1));
        m8597i();
        m8596h();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f6863i = false;
        this.f6864j = false;
    }

    /* renamed from: h */
    private void m8596h() {
        if (!this.f6864j) {
            this.f6864j = true;
            this.f6858d = new ImageView(this.f6855a);
            this.f6858d.setImageResource(ResourceHelp.m11934d(InternalContainer.m10059a(), "tt_dislike_icon"));
            this.f6858d.setScaleType(ScaleType.FIT_XY);
            this.f6858d.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (BannerView.this.f6860f != null) {
                        BannerView.this.f6860f.showDislikeDialog();
                    }
                }
            });
            int a = (int) UIUtils.m12048a(this.f6855a, 15.0f);
            int a2 = (int) UIUtils.m12048a(this.f6855a, 10.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a, a);
            layoutParams.gravity = 8388661;
            layoutParams.topMargin = a2;
            layoutParams.rightMargin = a2;
            addView((View) this.f6858d, (LayoutParams) layoutParams);
            UIUtils.m12060a((View) this.f6858d, a, a, a, a);
        }
    }

    /* renamed from: i */
    private void m8597i() {
        if (!this.f6863i) {
            this.f6863i = true;
            this.f6859e = new ImageView(this.f6855a);
            this.f6859e.setImageResource(ResourceHelp.m11934d(InternalContainer.m10059a(), "tt_ad_logo_small"));
            this.f6859e.setScaleType(ScaleType.FIT_XY);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(20, 20);
            layoutParams.gravity = 8388693;
            addView((View) this.f6859e, (LayoutParams) layoutParams);
        }
    }

    /* renamed from: a */
    public void mo15064a() {
        this.f6857c = new BannerCellView(this.f6855a);
        this.f6857c.setVisibility(8);
        addView((View) this.f6857c, (LayoutParams) new FrameLayout.LayoutParams(-1, -1));
    }

    /* renamed from: j */
    private void m8598j() {
        ImageView imageView = this.f6859e;
        if (imageView != null) {
            bringChildToFront(imageView);
        }
        ImageView imageView2 = this.f6858d;
        if (imageView2 != null) {
            bringChildToFront(imageView2);
        }
    }

    public void addView(View view, LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        m8598j();
    }

    public void addView(View view) {
        super.addView(view);
        m8598j();
    }

    public void addView(View view, int i) {
        super.addView(view, i);
        m8598j();
    }

    public void addView(View view, int i, int i2) {
        super.addView(view, i, i2);
        m8598j();
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        m8598j();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo15066a(TTAdDislikeImpl bVar) {
        this.f6860f = bVar;
    }

    /* renamed from: b */
    public BannerCellView mo15072b() {
        return this.f6856b;
    }

    /* renamed from: c */
    public BannerCellView mo15073c() {
        return this.f6857c;
    }

    /* renamed from: d */
    public View mo15074d() {
        return this.f6858d;
    }

    /* renamed from: a */
    public void mo15065a(int i) {
        this.f6861g = i;
    }

    /* renamed from: a */
    private ObjectAnimator m8588a(BannerCellView cVar) {
        return ObjectAnimator.ofFloat(cVar, "translationX", new float[]{0.0f, (float) (-getWidth())});
    }

    /* renamed from: b */
    private ObjectAnimator m8593b(final BannerCellView cVar) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cVar, "translationX", new float[]{(float) getWidth(), 0.0f});
        ofFloat.addListener(new AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                C2564t.m12220b("TTBannerAd", "SLIDE START");
            }

            public void onAnimationEnd(Animator animator) {
                BannerView.this.f6862h = false;
                BannerView.this.m8599k();
                BannerCellView cVar = cVar;
                if (cVar != null) {
                    BannerView.this.m8591a(cVar.mo15060a());
                }
                C2564t.m12220b("TTBannerAd", "SLIDE END");
            }
        });
        return ofFloat;
    }

    /* renamed from: e */
    public void mo15075e() {
        if (!this.f6862h) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(m8588a(this.f6856b)).with(m8593b(this.f6857c));
            animatorSet.setDuration((long) this.f6861g).start();
            this.f6857c.setVisibility(0);
            this.f6862h = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8591a(MaterialMeta kVar) {
        TTAdDislikeImpl bVar = this.f6860f;
        if (bVar != null && kVar != null) {
            bVar.mo16453a(kVar);
        }
    }

    /* renamed from: f */
    public boolean mo15076f() {
        BannerCellView cVar = this.f6857c;
        return (cVar == null || cVar.mo15060a() == null) ? false : true;
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m8599k() {
        BannerCellView cVar = this.f6856b;
        this.f6856b = this.f6857c;
        this.f6857c = cVar;
        this.f6857c.mo15063b();
    }
}
