package com.kwad.sdk.reward.widget.tailframe.h5bar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.p306a.C3809l;

public class TailFrameBarH5PortraitHorizontal extends LinearLayout {
    /* renamed from: a */
    private TextView f14932a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public TextView f14933b;
    /* renamed from: c */
    private ValueAnimator f14934c;

    public TailFrameBarH5PortraitHorizontal(Context context) {
        this(context, null);
    }

    public TailFrameBarH5PortraitHorizontal(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarH5PortraitHorizontal(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18550a(context);
    }

    /* renamed from: a */
    private void m18550a(Context context) {
        inflate(context, C3809l.m15792b(context, "ksad_video_tf_bar_h5_portrait_horizontal"), this);
        this.f14932a = (TextView) findViewById(C3809l.m15789a(context, "ksad_tf_h5_ad_desc"));
        this.f14933b = (TextView) findViewById(C3809l.m15789a(context, "ksad_tf_h5_open_btn"));
    }

    /* renamed from: b */
    private void m18551b() {
        if (this.f14934c != null) {
            mo24869a();
            this.f14934c.start();
        }
        this.f14934c = ValueAnimator.ofFloat(new float[]{1.0f, 1.2f, 1.0f});
        this.f14934c.setDuration(1200);
        this.f14934c.setRepeatCount(-1);
        this.f14934c.setRepeatMode(1);
        this.f14934c.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TailFrameBarH5PortraitHorizontal.this.f14933b.setScaleY(floatValue);
                TailFrameBarH5PortraitHorizontal.this.f14933b.setScaleX(floatValue);
            }
        });
        this.f14934c.start();
    }

    /* renamed from: a */
    public void mo24869a() {
        ValueAnimator valueAnimator = this.f14934c;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f14934c.cancel();
            this.f14934c.end();
        }
    }

    public void setModel(AdTemplate adTemplate) {
        AdInfo e = C4324c.m17668e(adTemplate);
        this.f14932a.setText(C4322a.m17643k(e));
        this.f14933b.setText(C4322a.m17650r(e));
        m18551b();
    }
}
