package com.yanzhenjie.album.widget.photoview;

import android.graphics.RectF;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.widget.ImageView;

/* renamed from: com.yanzhenjie.album.widget.photoview.b */
public class DefaultOnDoubleTapListener implements OnDoubleTapListener {
    /* renamed from: a */
    private PhotoViewAttacher f26358a;

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public DefaultOnDoubleTapListener(PhotoViewAttacher dVar) {
        mo37728a(dVar);
    }

    /* renamed from: a */
    public void mo37728a(PhotoViewAttacher dVar) {
        this.f26358a = dVar;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        PhotoViewAttacher dVar = this.f26358a;
        if (dVar == null) {
            return false;
        }
        ImageView c = dVar.mo37740c();
        if (this.f26358a.mo37745h() != null) {
            RectF b = this.f26358a.mo37739b();
            if (b != null) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (b.contains(x, y)) {
                    this.f26358a.mo37745h().mo37758a(c, (x - b.left) / b.width(), (y - b.top) / b.height());
                    return true;
                }
                this.f26358a.mo37745h().mo37757a();
            }
        }
        if (this.f26358a.mo37746i() != null) {
            this.f26358a.mo37746i().mo37761a(c, motionEvent.getX(), motionEvent.getY());
        }
        return false;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        PhotoViewAttacher dVar = this.f26358a;
        if (dVar == null) {
            return false;
        }
        try {
            float g = dVar.mo37744g();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (g < this.f26358a.mo37742e()) {
                this.f26358a.mo37737a(this.f26358a.mo37742e(), x, y, true);
            } else if (g < this.f26358a.mo37742e() || g >= this.f26358a.mo37743f()) {
                this.f26358a.mo37737a(this.f26358a.mo37741d(), x, y, true);
            } else {
                this.f26358a.mo37737a(this.f26358a.mo37743f(), x, y, true);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
        }
        return true;
    }
}
