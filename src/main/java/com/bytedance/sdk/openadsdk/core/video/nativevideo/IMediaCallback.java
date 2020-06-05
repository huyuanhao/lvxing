package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.View;

/* renamed from: com.bytedance.sdk.openadsdk.core.video.nativevideo.a */
public interface IMediaCallback {
    /* renamed from: a */
    void mo15951a(IMediaLayout bVar, int i);

    /* renamed from: a */
    void mo15952a(IMediaLayout bVar, int i, boolean z);

    /* renamed from: a */
    void mo15953a(IMediaLayout bVar, SurfaceTexture surfaceTexture);

    /* renamed from: a */
    void mo15954a(IMediaLayout bVar, SurfaceHolder surfaceHolder);

    /* renamed from: a */
    void mo15955a(IMediaLayout bVar, SurfaceHolder surfaceHolder, int i, int i2, int i3);

    /* renamed from: a */
    void mo15956a(IMediaLayout bVar, View view);

    /* renamed from: a */
    void mo15958a(IMediaLayout bVar, View view, boolean z, boolean z2);

    /* renamed from: b */
    void mo15967b(IMediaLayout bVar, int i);

    /* renamed from: b */
    void mo15968b(IMediaLayout bVar, SurfaceTexture surfaceTexture);

    /* renamed from: b */
    void mo15969b(IMediaLayout bVar, SurfaceHolder surfaceHolder);

    /* renamed from: b */
    void mo15970b(IMediaLayout bVar, View view);

    /* renamed from: c */
    void mo15974c(IMediaLayout bVar, View view);

    /* renamed from: d */
    void mo15977d(IMediaLayout bVar, View view);

    /* renamed from: e */
    void mo15979e(IMediaLayout bVar, View view);

    /* renamed from: f */
    void mo15981f(IMediaLayout bVar, View view);

    /* renamed from: g */
    void mo15983g();
}
