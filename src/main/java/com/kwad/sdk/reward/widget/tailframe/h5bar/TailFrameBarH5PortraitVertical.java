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

public class TailFrameBarH5PortraitVertical extends LinearLayout {
    /* renamed from: a */
    private TextView f14936a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public TextView f14937b;
    /* renamed from: c */
    private ValueAnimator f14938c;

    public TailFrameBarH5PortraitVertical(Context context) {
        this(context, null);
    }

    public TailFrameBarH5PortraitVertical(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarH5PortraitVertical(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18554a(context);
    }

    /* renamed from: a */
    private void m18554a(Context context) {
        inflate(context, C3809l.m15792b(context, "ksad_video_tf_bar_h5_portrait_vertical"), this);
        this.f14936a = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_tf_h5_ad_desc"));
        this.f14937b = (TextView) findViewById(C3809l.m15789a(getContext(), "ksad_tf_h5_open_btn"));
    }

    /* renamed from: b */
    private void m18555b() {
        if (this.f14938c != null) {
            mo24872a();
            this.f14938c.start();
        }
        this.f14938c = ValueAnimator.ofFloat(new float[]{1.0f, 1.2f, 1.0f});
        this.f14938c.setDuration(1200);
        this.f14938c.setRepeatCount(-1);
        this.f14938c.setRepeatMode(1);
        this.f14938c.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TailFrameBarH5PortraitVertical.this.f14937b.setScaleY(floatValue);
                TailFrameBarH5PortraitVertical.this.f14937b.setScaleX(floatValue);
            }
        });
        this.f14938c.start();
    }

    /* renamed from: a */
    public void mo24872a() {
        ValueAnimator valueAnimator = this.f14938c;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f14938c.cancel();
            this.f14938c.end();
        }
    }

    /* renamed from: a */
    public void mo24873a(AdTemplate adTemplate) {
        AdInfo e = C4324c.m17668e(adTemplate);
        this.f14936a.setText(C4322a.m17643k(e));
        this.f14937b.setText(C4322a.m17650r(e));
        m18555b();
    }
}
