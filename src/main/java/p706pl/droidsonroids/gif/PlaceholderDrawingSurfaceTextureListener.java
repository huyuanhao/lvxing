package p706pl.droidsonroids.gif;

import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import p706pl.droidsonroids.gif.GifTextureView.C8586a;

/* renamed from: pl.droidsonroids.gif.i */
class PlaceholderDrawingSurfaceTextureListener implements SurfaceTextureListener {
    /* renamed from: a */
    private final C8586a f29293a;

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    PlaceholderDrawingSurfaceTextureListener(C8586a aVar) {
        this.f29293a = aVar;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Surface surface = new Surface(surfaceTexture);
        Canvas lockCanvas = surface.lockCanvas(null);
        this.f29293a.mo41202a(lockCanvas);
        surface.unlockCanvasAndPost(lockCanvas);
        surface.release();
    }
}
