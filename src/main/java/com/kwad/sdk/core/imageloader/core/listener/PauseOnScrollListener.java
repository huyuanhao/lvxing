package com.kwad.sdk.core.imageloader.core.listener;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.kwad.sdk.core.imageloader.core.ImageLoader;

public class PauseOnScrollListener implements OnScrollListener {
    private final OnScrollListener externalListener;
    private ImageLoader imageLoader;
    private final boolean pauseOnFling;
    private final boolean pauseOnScroll;

    public PauseOnScrollListener(ImageLoader imageLoader2, boolean z, boolean z2) {
        this(imageLoader2, z, z2, null);
    }

    public PauseOnScrollListener(ImageLoader imageLoader2, boolean z, boolean z2, OnScrollListener onScrollListener) {
        this.imageLoader = imageLoader2;
        this.pauseOnScroll = z;
        this.pauseOnFling = z2;
        this.externalListener = onScrollListener;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        OnScrollListener onScrollListener = this.externalListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.imageLoader.resume();
        } else if (i == 1 ? this.pauseOnScroll : !(i != 2 || !this.pauseOnFling)) {
            this.imageLoader.pause();
        }
        OnScrollListener onScrollListener = this.externalListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
    }
}
