package com.yanzhenjie.album.widget.photoview.gestures;

import android.content.Context;
import android.view.MotionEvent;
import com.yanzhenjie.album.widget.photoview.Compat;

public class EclairGestureDetector extends CupcakeGestureDetector {
    /* renamed from: d */
    private int f26409d = -1;
    /* renamed from: e */
    private int f26410e = 0;

    public EclairGestureDetector(Context context) {
        super(context);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public float mo37762a(MotionEvent motionEvent) {
        try {
            r2 = motionEvent;
            r2 = motionEvent.getX(this.f26410e);
            r2 = r2;
            return r2;
        } catch (Exception unused) {
            return r2.getX();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public float mo37765b(MotionEvent motionEvent) {
        try {
            r2 = motionEvent;
            r2 = motionEvent.getY(this.f26410e);
            r2 = r2;
            return r2;
        } catch (Exception unused) {
            return r2.getY();
        }
    }

    /* renamed from: c */
    public boolean mo37767c(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f26409d = motionEvent.getPointerId(0);
        } else if (action == 1 || action == 3) {
            this.f26409d = -1;
        } else if (action == 6) {
            int a = Compat.m33659a(motionEvent.getAction());
            if (motionEvent.getPointerId(a) == this.f26409d) {
                int i = a == 0 ? 1 : 0;
                this.f26409d = motionEvent.getPointerId(i);
                this.f26403b = motionEvent.getX(i);
                this.f26404c = motionEvent.getY(i);
            }
        }
        int i2 = this.f26409d;
        if (i2 == -1) {
            i2 = 0;
        }
        this.f26410e = motionEvent.findPointerIndex(i2);
        try {
            return super.mo37767c(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }
}
