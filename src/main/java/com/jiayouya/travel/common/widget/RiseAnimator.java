package com.jiayouya.travel.common.widget;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import java.text.DecimalFormat;

/* renamed from: com.jiayouya.travel.common.widget.b */
public class RiseAnimator extends ValueAnimator {
    /* renamed from: a */
    static TypeEvaluator<Double> f9672a = new TypeEvaluator<Double>() {
        /* renamed from: a */
        public Double evaluate(float f, Double d, Double d2) {
            return Double.valueOf(d.doubleValue() + ((d2.doubleValue() - d.doubleValue()) * ((double) f)));
        }
    };
    /* renamed from: b */
    private double f9673b = 0.0d;
    /* renamed from: c */
    private AnimatorUpdateListener f9674c;
    /* renamed from: d */
    private final DecimalFormat f9675d;

    public RiseAnimator() {
        setInterpolator(new LinearInterpolator());
        setDuration(1000);
        this.f9675d = new DecimalFormat();
    }

    public RiseAnimator(String str) {
        setInterpolator(new LinearInterpolator());
        setDuration(1000);
        this.f9675d = new DecimalFormat(str);
    }

    /* renamed from: a */
    public RiseAnimator mo20026a(TextView textView, String str) {
        textView.setText(str);
        return mo20025a(new AnimatorUpdateListener(textView) {
            private final /* synthetic */ TextView f$1;

            {
                this.f$1 = r2;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RiseAnimator.this.m13108a(this.f$1, valueAnimator);
            }
        });
    }

    /* access modifiers changed from: private|synthetic */
    /* renamed from: a */
    public /* synthetic */ void m13108a(TextView textView, ValueAnimator valueAnimator) {
        textView.setText(this.f9675d.format(((Double) valueAnimator.getAnimatedValue()).doubleValue()));
    }

    /* renamed from: a */
    public RiseAnimator mo20025a(AnimatorUpdateListener animatorUpdateListener) {
        AnimatorUpdateListener animatorUpdateListener2 = this.f9674c;
        if (animatorUpdateListener2 != null) {
            removeUpdateListener(animatorUpdateListener2);
        }
        this.f9674c = animatorUpdateListener;
        addUpdateListener(animatorUpdateListener);
        return this;
    }

    /* renamed from: a */
    public void mo20027a(double d, double d2) {
        if (!Double.isNaN(d) && !Double.isNaN(d2)) {
            this.f9673b = d2;
            setObjectValues(new Object[]{Double.valueOf(d), Double.valueOf(d2)});
            setEvaluator(f9672a);
            start();
        }
    }
}
