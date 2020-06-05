package com.kwad.sdk.contentalliance.refreshview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation.AnimationListener;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.contentalliance.refreshview.RefreshLayout.C4042b;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3817t;

public class KsAdHotRefreshView extends C4053e {
    /* access modifiers changed from: private|static|final */
    /* renamed from: g */
    public static final float f13517g = ((float) C3817t.m15862a(KsAdSDK.getContext(), 37.5f));
    /* access modifiers changed from: private */
    /* renamed from: h */
    public C4042b f13518h;
    /* renamed from: i */
    private LottieAnimationView f13519i;

    public KsAdHotRefreshView(Context context) {
        this(context, null);
    }

    public KsAdHotRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setRefreshTargetOffset(f13517g - 1.0f);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C4050b mo23624a() {
        return new C4050b() {
            /* renamed from: a */
            public float mo23630a(float f, float f2) {
                return Math.min(KsAdHotRefreshView.f13517g, 200.0f - (80000.0f / (f + 400.0f)));
            }
        };
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23625a(int i, AnimationListener animationListener) {
        if (this.f13558d.getTop() == 0 || ((float) this.f13558d.getTop()) == getRefreshTargetOffset()) {
            this.f13558d.setTop(0);
            clearAnimation();
            this.f13519i.mo22762d();
            animationListener.onAnimationStart(null);
            animationListener.onAnimationEnd(null);
            return;
        }
        super.mo23625a(i, animationListener);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23626a(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(C3809l.m15792b(getContext(), "ksad_content_alliance_hot_shoot_refresh_view"), this, true);
        this.f13558d = findViewById(C3809l.m15789a(getContext(), "ksad_shoot_refresh_view"));
        this.f13558d.setVisibility(8);
        this.f13519i = (LottieAnimationView) findViewById(C3809l.m15789a(getContext(), "ksad_pull_to_refresh_animation_view"));
        this.f13519i.setAnimation(C3809l.m15798g(getContext(), "ksad_detail_loading_amin_top"));
        if (this.f13558d instanceof C4052d) {
            this.f13559e = (C4052d) this.f13558d;
            return;
        }
        throw new ClassCastException("the refreshView must implement the interface IRefreshStatus");
    }

    public void setOnRefreshListener(C4042b bVar) {
        this.f13518h = bVar;
        super.setOnRefreshListener(new C4042b() {
            /* renamed from: a */
            public void mo23613a() {
                if (KsAdHotRefreshView.this.f13558d instanceof KsAdHotShootRefreshView) {
                    ((KsAdHotShootRefreshView) KsAdHotRefreshView.this.f13558d).setOnRefreshListener(KsAdHotRefreshView.this.f13518h);
                }
            }
        });
    }

    public void setRefreshing(final boolean z) {
        if (!z) {
            postDelayed(new Runnable() {
                public void run() {
                    if (!KsAdHotRefreshView.this.mo23650d() && KsAdHotRefreshView.this.f13559e != null) {
                        KsAdHotRefreshView.this.f13559e.mo23634c();
                    }
                    KsAdHotRefreshView.super.setRefreshing(z);
                }
            }, 600);
        } else {
            super.setRefreshing(z);
        }
    }
}
