package com.bytedance.sdk.openadsdk.core.video.renderview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.bytedance.sdk.openadsdk.core.video.renderview.IRenderView.C2348a;

public class SSRenderTextureView extends TextureView implements SurfaceTextureListener, IRenderView {
    /* renamed from: a */
    private IRenderCallback f8225a;
    /* renamed from: b */
    private C2348a f8226b;

    public SurfaceHolder getHolder() {
        return null;
    }

    public View getView() {
        return this;
    }

    public SSRenderTextureView(Context context) {
        this(context, null);
    }

    public SSRenderTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    public void mo16216a(IRenderCallback aVar) {
        this.f8225a = aVar;
        setSurfaceTextureListener(this);
    }

    /* renamed from: a */
    public void mo16215a(int i, int i2) {
        LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        IRenderCallback aVar = this.f8225a;
        if (aVar != null) {
            aVar.mo16178a(surfaceTexture, i, i2);
        }
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        IRenderCallback aVar = this.f8225a;
        if (aVar != null) {
            aVar.mo16188b(surfaceTexture, i, i2);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        IRenderCallback aVar = this.f8225a;
        return aVar != null && aVar.mo16185a(surfaceTexture);
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        IRenderCallback aVar = this.f8225a;
        if (aVar != null) {
            aVar.mo16187b(surfaceTexture);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        C2348a aVar = this.f8226b;
        if (aVar != null) {
            aVar.mo16234a(i);
        }
    }

    public void setWindowVisibilityChangedListener(C2348a aVar) {
        this.f8226b = aVar;
    }
}
