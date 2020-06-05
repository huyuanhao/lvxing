package com.ksad.lottie.p303d;

import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.ksad.lottie.d.a */
public abstract class C3704a extends ValueAnimator {
    /* renamed from: a */
    private final Set<AnimatorUpdateListener> f12600a = new CopyOnWriteArraySet();
    /* renamed from: b */
    private final Set<AnimatorListener> f12601b = new CopyOnWriteArraySet();

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22890a() {
        for (AnimatorListener onAnimationRepeat : this.f12601b) {
            onAnimationRepeat.onAnimationRepeat(this);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22891a(boolean z) {
        for (AnimatorListener animatorListener : this.f12601b) {
            if (VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    public void addListener(AnimatorListener animatorListener) {
        this.f12601b.add(animatorListener);
    }

    public void addUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        this.f12600a.add(animatorUpdateListener);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo22894b() {
        for (AnimatorListener onAnimationCancel : this.f12601b) {
            onAnimationCancel.onAnimationCancel(this);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo22895b(boolean z) {
        for (AnimatorListener animatorListener : this.f12601b) {
            if (VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo22896c() {
        for (AnimatorUpdateListener onAnimationUpdate : this.f12600a) {
            onAnimationUpdate.onAnimationUpdate(this);
        }
    }

    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    public void removeAllListeners() {
        this.f12601b.clear();
    }

    public void removeAllUpdateListeners() {
        this.f12600a.clear();
    }

    public void removeListener(AnimatorListener animatorListener) {
        this.f12601b.remove(animatorListener);
    }

    public void removeUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        this.f12600a.remove(animatorUpdateListener);
    }

    public ValueAnimator setDuration(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    public void setStartDelay(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }
}
