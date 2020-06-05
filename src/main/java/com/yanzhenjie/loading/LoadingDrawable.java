package com.yanzhenjie.loading;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

public class LoadingDrawable extends Drawable implements Animatable {
    private final Callback mCallback = new Callback() {
        public void invalidateDrawable(Drawable drawable) {
            LoadingDrawable.this.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            LoadingDrawable.this.scheduleSelf(runnable, j);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            LoadingDrawable.this.unscheduleSelf(runnable);
        }
    };
    private final LoadingRenderer mLoadingRender;

    public int getOpacity() {
        return -3;
    }

    public LoadingDrawable(LoadingRenderer loadingRenderer) {
        this.mLoadingRender = loadingRenderer;
        this.mLoadingRender.setCallback(this.mCallback);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mLoadingRender.setBounds(rect);
    }

    public void draw(Canvas canvas) {
        if (!getBounds().isEmpty()) {
            this.mLoadingRender.draw(canvas);
        }
    }

    public void setAlpha(int i) {
        this.mLoadingRender.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mLoadingRender.setColorFilter(colorFilter);
    }

    public void start() {
        this.mLoadingRender.start();
    }

    public void stop() {
        this.mLoadingRender.stop();
    }

    public boolean isRunning() {
        return this.mLoadingRender.isRunning();
    }

    public int getIntrinsicHeight() {
        return (int) this.mLoadingRender.mHeight;
    }

    public int getIntrinsicWidth() {
        return (int) this.mLoadingRender.mWidth;
    }
}
