package com.yanzhenjie.loading;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable.Callback;
import android.view.animation.LinearInterpolator;

public abstract class LoadingRenderer {
    private static final long ANIMATION_DURATION = 1333;
    private final AnimatorUpdateListener mAnimatorUpdateListener = new AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            LoadingRenderer.this.computeRender(((Float) valueAnimator.getAnimatedValue()).floatValue());
            LoadingRenderer.this.invalidateSelf();
        }
    };
    protected final Rect mBounds = new Rect();
    private Callback mCallback;
    protected long mDuration;
    protected float mHeight;
    private ValueAnimator mRenderAnimator;
    protected float mWidth;

    public abstract void computeRender(float f);

    /* access modifiers changed from: protected */
    @Deprecated
    public void draw(Canvas canvas, Rect rect) {
    }

    public abstract void reset();

    public abstract void setAlpha(int i);

    public abstract void setColorFilter(ColorFilter colorFilter);

    public LoadingRenderer(Context context) {
        float dip2px = Utils.dip2px(context, 56.0f);
        this.mHeight = dip2px;
        this.mWidth = dip2px;
        this.mDuration = ANIMATION_DURATION;
        setupAnimators();
    }

    /* access modifiers changed from: protected */
    public void draw(Canvas canvas) {
        draw(canvas, this.mBounds);
    }

    /* access modifiers changed from: protected */
    public void addRenderListener(AnimatorListener animatorListener) {
        this.mRenderAnimator.addListener(animatorListener);
    }

    /* access modifiers changed from: 0000 */
    public void start() {
        reset();
        this.mRenderAnimator.addUpdateListener(this.mAnimatorUpdateListener);
        this.mRenderAnimator.setRepeatCount(-1);
        this.mRenderAnimator.setDuration(this.mDuration);
        this.mRenderAnimator.start();
    }

    /* access modifiers changed from: 0000 */
    public void stop() {
        this.mRenderAnimator.removeUpdateListener(this.mAnimatorUpdateListener);
        this.mRenderAnimator.setRepeatCount(0);
        this.mRenderAnimator.setDuration(0);
        this.mRenderAnimator.end();
    }

    /* access modifiers changed from: 0000 */
    public boolean isRunning() {
        return this.mRenderAnimator.isRunning();
    }

    /* access modifiers changed from: 0000 */
    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    /* access modifiers changed from: 0000 */
    public void setBounds(Rect rect) {
        this.mBounds.set(rect);
    }

    private void setupAnimators() {
        this.mRenderAnimator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.mRenderAnimator.setRepeatCount(-1);
        this.mRenderAnimator.setRepeatMode(1);
        this.mRenderAnimator.setDuration(this.mDuration);
        this.mRenderAnimator.setInterpolator(new LinearInterpolator());
        this.mRenderAnimator.addUpdateListener(this.mAnimatorUpdateListener);
    }

    /* access modifiers changed from: private */
    public void invalidateSelf() {
        this.mCallback.invalidateDrawable(null);
    }
}
