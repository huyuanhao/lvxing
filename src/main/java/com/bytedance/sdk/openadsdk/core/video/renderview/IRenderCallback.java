package com.bytedance.sdk.openadsdk.core.video.renderview;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;

/* renamed from: com.bytedance.sdk.openadsdk.core.video.renderview.a */
public interface IRenderCallback {
    /* renamed from: a */
    void mo16178a(SurfaceTexture surfaceTexture, int i, int i2);

    /* renamed from: a */
    void mo16179a(SurfaceHolder surfaceHolder);

    /* renamed from: a */
    void mo16180a(SurfaceHolder surfaceHolder, int i, int i2, int i3);

    /* renamed from: a */
    boolean mo16185a(SurfaceTexture surfaceTexture);

    /* renamed from: b */
    void mo16187b(SurfaceTexture surfaceTexture);

    /* renamed from: b */
    void mo16188b(SurfaceTexture surfaceTexture, int i, int i2);

    /* renamed from: b */
    void mo16189b(SurfaceHolder surfaceHolder);
}
