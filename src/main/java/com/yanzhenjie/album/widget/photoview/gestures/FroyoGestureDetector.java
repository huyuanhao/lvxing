package com.yanzhenjie.album.widget.photoview.gestures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

public class FroyoGestureDetector extends EclairGestureDetector {
    /* renamed from: d */
    protected final ScaleGestureDetector f26411d;

    public FroyoGestureDetector(Context context) {
        super(context);
        this.f26411d = new ScaleGestureDetector(context, new OnScaleGestureListener() {
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            }

            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                    return false;
                }
                FroyoGestureDetector.this.f26402a.mo37735a(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                return true;
            }
        });
    }

    /* renamed from: a */
    public boolean mo37764a() {
        return this.f26411d.isInProgress();
    }

    /* renamed from: c */
    public boolean mo37767c(MotionEvent motionEvent) {
        try {
            this.f26411d.onTouchEvent(motionEvent);
            return super.mo37767c(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }
}
