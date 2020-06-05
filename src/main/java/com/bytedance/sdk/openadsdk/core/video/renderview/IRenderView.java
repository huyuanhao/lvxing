package com.bytedance.sdk.openadsdk.core.video.renderview;

import android.view.SurfaceHolder;
import android.view.View;

/* renamed from: com.bytedance.sdk.openadsdk.core.video.renderview.b */
public interface IRenderView {

    /* compiled from: IRenderView */
    /* renamed from: com.bytedance.sdk.openadsdk.core.video.renderview.b$a */
    public interface C2348a {
        /* renamed from: a */
        void mo16234a(int i);
    }

    /* renamed from: a */
    void mo16215a(int i, int i2);

    /* renamed from: a */
    void mo16216a(IRenderCallback aVar);

    SurfaceHolder getHolder();

    View getView();

    void setVisibility(int i);
}
