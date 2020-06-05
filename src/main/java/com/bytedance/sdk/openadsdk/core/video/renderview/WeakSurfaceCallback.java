package com.bytedance.sdk.openadsdk.core.video.renderview;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import java.lang.ref.WeakReference;

/* renamed from: com.bytedance.sdk.openadsdk.core.video.renderview.c */
public class WeakSurfaceCallback implements Callback {
    /* renamed from: a */
    private final WeakReference<Callback> f8227a;

    public WeakSurfaceCallback(Callback callback) {
        this.f8227a = new WeakReference<>(callback);
    }

    /* renamed from: a */
    public Callback mo16235a() {
        return (Callback) this.f8227a.get();
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Callback callback = (Callback) this.f8227a.get();
        if (callback != null) {
            callback.surfaceCreated(surfaceHolder);
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Callback callback = (Callback) this.f8227a.get();
        if (callback != null) {
            callback.surfaceChanged(surfaceHolder, i, i2, i3);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Callback callback = (Callback) this.f8227a.get();
        if (callback != null) {
            callback.surfaceDestroyed(surfaceHolder);
        }
    }
}
