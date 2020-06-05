package com.airbnb.lottie.p013d;

import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.airbnb.lottie.d.a */
public abstract class BaseLottieAnimator extends ValueAnimator {
    /* renamed from: a */
    private final Set<AnimatorUpdateListener> f1468a = new CopyOnWriteArraySet();
    /* renamed from: b */
    private final Set<AnimatorListener> f1469b = new CopyOnWriteArraySet();

    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    public void setStartDelay(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    public ValueAnimator setDuration(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    public void addUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        this.f1468a.add(animatorUpdateListener);
    }

    public void removeUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        this.f1468a.remove(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.f1468a.clear();
    }

    public void addListener(AnimatorListener animatorListener) {
        this.f1469b.add(animatorListener);
    }

    public void removeListener(AnimatorListener animatorListener) {
        this.f1469b.remove(animatorListener);
    }

    public void removeAllListeners() {
        this.f1469b.clear();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo9931a(boolean z) {
        for (AnimatorListener animatorListener : this.f1469b) {
            if (VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo9930a() {
        for (AnimatorListener onAnimationRepeat : this.f1469b) {
            onAnimationRepeat.onAnimationRepeat(this);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo9935b(boolean z) {
        for (AnimatorListener animatorListener : this.f1469b) {
            if (VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo9934b() {
        for (AnimatorListener onAnimationCancel : this.f1469b) {
            onAnimationCancel.onAnimationCancel(this);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo9936c() {
        for (AnimatorUpdateListener onAnimationUpdate : this.f1468a) {
            onAnimationUpdate.onAnimationUpdate(this);
        }
    }
}
