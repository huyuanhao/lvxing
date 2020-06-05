package com.kwad.sdk.contentalliance.refreshview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.contentalliance.refreshview.RefreshLayout.C4042b;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3817t;

public class KsAdHotShootRefreshView extends RelativeLayout implements C4052d {
    /* renamed from: a */
    private static final float f13524a = ((float) C3817t.m15862a(KsAdSDK.getContext(), 10.0f));
    /* renamed from: b */
    private LottieAnimationView f13525b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public C4042b f13526c;

    public KsAdHotShootRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    public void mo23631a() {
    }

    /* renamed from: a */
    public void mo23632a(float f, float f2) {
        if (f < f13524a) {
            setAlpha(0.0f);
            if (this.f13525b.mo22761c()) {
                this.f13525b.mo22762d();
                return;
            }
            return;
        }
        if (!this.f13525b.mo22761c()) {
            this.f13525b.mo22759b();
        }
        float f3 = f13524a;
        setAlpha(Math.min(1.0f, (f - f3) / (f3 * 2.0f)));
    }

    /* renamed from: b */
    public void mo23633b() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{getTop(), 0});
        ofInt.setInterpolator(new AccelerateInterpolator());
        ofInt.setDuration(300);
        ofInt.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                KsAdHotShootRefreshView.this.setTop(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (KsAdHotShootRefreshView.this.f13526c != null) {
                    KsAdHotShootRefreshView.this.f13526c.mo23613a();
                }
            }

            public void onAnimationStart(Animator animator) {
            }
        });
        ofInt.start();
    }

    /* renamed from: c */
    public void mo23634c() {
        setAlpha(0.0f);
    }

    /* renamed from: d */
    public void mo23635d() {
    }

    /* renamed from: e */
    public void mo23636e() {
    }

    /* renamed from: f */
    public int mo23637f() {
        return 200;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f13525b = (LottieAnimationView) findViewById(C3809l.m15789a(getContext(), "ksad_pull_to_refresh_animation_view"));
        int g = C3809l.m15798g(getContext(), "ksad_detail_loading_amin_top");
        this.f13525b.setVisibility(0);
        this.f13525b.setAnimation(g);
        this.f13525b.setRepeatMode(1);
        this.f13525b.setRepeatCount(-1);
        this.f13525b.setAnimation(g);
    }

    public void setOnRefreshListener(C4042b bVar) {
        this.f13526c = bVar;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
    }
}
