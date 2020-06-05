package com.kwad.sdk.draw;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* renamed from: com.kwad.sdk.draw.b */
public class C4375b {
    /* renamed from: a */
    public static ValueAnimator m17853a(final View view, int i, final int i2) {
        m17855b(view, i);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                C4375b.m17855b(view, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                C4375b.m17855b(view, i2);
            }

            public void onAnimationEnd(Animator animator) {
                C4375b.m17855b(view, i2);
            }
        });
        return ofInt;
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m17855b(View view, int i) {
        LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }
}
