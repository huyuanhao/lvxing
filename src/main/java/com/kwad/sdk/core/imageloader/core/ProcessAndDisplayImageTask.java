package com.kwad.sdk.core.imageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.kwad.sdk.core.imageloader.core.assist.LoadedFrom;
import com.kwad.sdk.core.imageloader.utils.C4246L;

final class ProcessAndDisplayImageTask implements Runnable {
    private static final String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
    private final Bitmap bitmap;
    private final ImageLoaderEngine engine;
    private final Handler handler;
    private final ImageLoadingInfo imageLoadingInfo;

    public ProcessAndDisplayImageTask(ImageLoaderEngine imageLoaderEngine, Bitmap bitmap2, ImageLoadingInfo imageLoadingInfo2, Handler handler2) {
        this.engine = imageLoaderEngine;
        this.bitmap = bitmap2;
        this.imageLoadingInfo = imageLoadingInfo2;
        this.handler = handler2;
    }

    public void run() {
        C4246L.m17479d(LOG_POSTPROCESS_IMAGE, this.imageLoadingInfo.memoryCacheKey);
        LoadAndDisplayImageTask.runTask(new DisplayBitmapTask(this.imageLoadingInfo.options.getPostProcessor().process(this.bitmap), this.imageLoadingInfo, this.engine, LoadedFrom.MEMORY_CACHE), this.imageLoadingInfo.options.isSyncLoading(), this.handler, this.engine);
    }
}
