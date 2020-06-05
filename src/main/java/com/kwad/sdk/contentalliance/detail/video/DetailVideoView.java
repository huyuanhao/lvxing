package com.kwad.sdk.contentalliance.detail.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.kwad.sdk.core.page.widget.SafeTextureView;
import com.kwad.sdk.p306a.C3817t;

public class DetailVideoView extends FrameLayout {
    /* renamed from: a */
    public SafeTextureView f13361a;
    /* renamed from: b */
    public Surface f13362b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public C3971a f13363c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public SurfaceTexture f13364d;
    /* renamed from: e */
    private boolean f13365e = false;

    public DetailVideoView(Context context) {
        super(context);
        m16429a(context);
    }

    public DetailVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16429a(context);
    }

    /* renamed from: a */
    private void m16428a() {
        this.f13361a.setSurfaceTextureListener(new SurfaceTextureListener() {
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (DetailVideoView.this.f13364d == null) {
                    if (DetailVideoView.this.f13362b != null) {
                        DetailVideoView.this.f13362b.release();
                        DetailVideoView.this.f13362b = null;
                    }
                    DetailVideoView.this.f13364d = surfaceTexture;
                    DetailVideoView.this.f13362b = new Surface(surfaceTexture);
                    if (DetailVideoView.this.f13363c != null) {
                        DetailVideoView.this.f13363c.mo23523a(DetailVideoView.this.f13362b);
                        return;
                    }
                    return;
                }
                DetailVideoView.this.f13361a.setSurfaceTexture(surfaceTexture);
            }

            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (DetailVideoView.this.f13362b != null) {
                    DetailVideoView.this.f13362b.release();
                    DetailVideoView.this.f13362b = null;
                }
                if (DetailVideoView.this.f13364d != null) {
                    DetailVideoView.this.f13364d.release();
                    DetailVideoView.this.f13364d = null;
                }
                return false;
            }

            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
    }

    /* renamed from: a */
    private void m16429a(Context context) {
        this.f13361a = new SafeTextureView(context);
        addView(this.f13361a, 0, new LayoutParams(-1, -1, 17));
        m16428a();
    }

    /* renamed from: a */
    public void mo23513a(int i, int i2) {
        if (this.f13365e) {
            C3817t.m15865a((View) this.f13361a, i, i2);
            return;
        }
        View view = (View) this.f13361a.getParent();
        if (view != null) {
            int width = view.getWidth();
            int height = view.getHeight();
            if (!(width == 0 || height == 0)) {
                ViewGroup.LayoutParams layoutParams = this.f13361a.getLayoutParams();
                layoutParams.width = width;
                layoutParams.height = (int) ((((float) i2) / (((float) i) * 1.0f)) * ((float) width));
                this.f13361a.setLayoutParams(layoutParams);
            }
        }
    }

    public void setAd(boolean z) {
        this.f13365e = z;
    }

    public void setMediaPlayer(C3971a aVar) {
        this.f13363c = aVar;
        Surface surface = this.f13362b;
        if (surface != null) {
            C3971a aVar2 = this.f13363c;
            if (aVar2 != null) {
                aVar2.mo23523a(surface);
            }
        }
    }
}
