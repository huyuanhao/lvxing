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

public class TailFrameBarH5Landscape extends LinearLayout {
    /* renamed from: a */
    private TextView f14928a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public TextView f14929b;
    /* renamed from: c */
    private ValueAnimator f14930c;

    public TailFrameBarH5Landscape(Context context) {
        this(context, null);
    }

    public TailFrameBarH5Landscape(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarH5Landscape(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18546a(context);
    }

    /* renamed from: a */
    private void m18546a(Context context) {
        inflate(context, C3809l.m15792b(context, "ksad_video_tf_bar_h5_landscape"), this);
        this.f14928a = (TextView) findViewById(C3809l.m15789a(context, "ksad_tf_h5_ad_desc"));
        this.f14929b = (TextView) findViewById(C3809l.m15789a(context, "ksad_tf_h5_open_btn"));
    }

    /* renamed from: b */
    private void m18547b() {
        if (this.f14930c != null) {
            mo24866a();
            this.f14930c.start();
        }
        this.f14930c = ValueAnimator.ofFloat(new float[]{1.0f, 1.2f, 1.0f});
        this.f14930c.setDuration(1200);
        this.f14930c.setRepeatCount(-1);
        this.f14930c.setRepeatMode(1);
        this.f14930c.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TailFrameBarH5Landscape.this.f14929b.setScaleY(floatValue);
                TailFrameBarH5Landscape.this.f14929b.setScaleX(floatValue);
            }
        });
        this.f14930c.start();
    }

    /* renamed from: a */
    public void mo24866a() {
        ValueAnimator valueAnimator = this.f14930c;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f14930c.cancel();
            this.f14930c.end();
        }
    }

    public void setModel(AdTemplate adTemplate) {
        AdInfo e = C4324c.m17668e(adTemplate);
        this.f14928a.setText(C4322a.m17643k(e));
        this.f14929b.setText(C4322a.m17650r(e));
        m18547b();
    }
}
