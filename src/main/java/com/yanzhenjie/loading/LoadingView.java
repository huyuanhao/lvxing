package com.yanzhenjie.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class LoadingView extends ImageView {
    private LoadingDrawable mLoadingDrawable;

    public LoadingView(Context context) {
        super(context);
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLoadingDrawable = new LoadingDrawable(new LevelLoadingRenderer(context));
        setImageDrawable(this.mLoadingDrawable);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnimation();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimation();
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            startAnimation();
        } else {
            stopAnimation();
        }
    }

    private void startAnimation() {
        LoadingDrawable loadingDrawable = this.mLoadingDrawable;
        if (loadingDrawable != null) {
            loadingDrawable.start();
        }
    }

    private void stopAnimation() {
        LoadingDrawable loadingDrawable = this.mLoadingDrawable;
        if (loadingDrawable != null) {
            loadingDrawable.stop();
        }
    }
}
