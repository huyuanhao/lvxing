package com.yanzhenjie.durban.p632c;

import android.view.MotionEvent;

/* renamed from: com.yanzhenjie.durban.c.i */
public class RotationGestureDetector {
    /* renamed from: a */
    private float f26486a;
    /* renamed from: b */
    private float f26487b;
    /* renamed from: c */
    private float f26488c;
    /* renamed from: d */
    private float f26489d;
    /* renamed from: e */
    private int f26490e = -1;
    /* renamed from: f */
    private int f26491f = -1;
    /* renamed from: g */
    private float f26492g;
    /* renamed from: h */
    private boolean f26493h;
    /* renamed from: i */
    private C7796a f26494i;

    /* compiled from: RotationGestureDetector */
    /* renamed from: com.yanzhenjie.durban.c.i$a */
    public interface C7796a {
        /* renamed from: a */
        boolean mo37847a(RotationGestureDetector iVar);
    }

    /* compiled from: RotationGestureDetector */
    /* renamed from: com.yanzhenjie.durban.c.i$b */
    public static class C7797b implements C7796a {
        /* renamed from: a */
        public boolean mo37847a(RotationGestureDetector iVar) {
            return false;
        }
    }

    public RotationGestureDetector(C7796a aVar) {
        this.f26494i = aVar;
    }

    /* renamed from: a */
    public float mo37845a() {
        return this.f26492g;
    }

    /* renamed from: a */
    public boolean mo37846a(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f26488c = motionEvent.getX();
            this.f26489d = motionEvent.getY();
            this.f26490e = motionEvent2.findPointerIndex(motionEvent2.getPointerId(0));
            this.f26492g = 0.0f;
            this.f26493h = true;
        } else if (actionMasked == 1) {
            this.f26490e = -1;
        } else if (actionMasked != 2) {
            if (actionMasked == 5) {
                this.f26486a = motionEvent.getX();
                this.f26487b = motionEvent.getY();
                this.f26491f = motionEvent2.findPointerIndex(motionEvent2.getPointerId(motionEvent.getActionIndex()));
                this.f26492g = 0.0f;
                this.f26493h = true;
            } else if (actionMasked == 6) {
                this.f26491f = -1;
            }
        } else if (!(this.f26490e == -1 || this.f26491f == -1 || motionEvent.getPointerCount() <= this.f26491f)) {
            float x = motionEvent2.getX(this.f26490e);
            float y = motionEvent2.getY(this.f26490e);
            float x2 = motionEvent2.getX(this.f26491f);
            float y2 = motionEvent2.getY(this.f26491f);
            if (this.f26493h) {
                this.f26492g = 0.0f;
                this.f26493h = false;
            } else {
                m33856a(this.f26486a, this.f26487b, this.f26488c, this.f26489d, x2, y2, x, y);
            }
            C7796a aVar = this.f26494i;
            if (aVar != null) {
                aVar.mo37847a(this);
            }
            this.f26486a = x2;
            this.f26487b = y2;
            this.f26488c = x;
            this.f26489d = y;
        }
        return true;
    }

    /* renamed from: a */
    private float m33856a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        return m33855a((float) Math.toDegrees((double) ((float) Math.atan2((double) (f2 - f4), (double) (f - f3)))), (float) Math.toDegrees((double) ((float) Math.atan2((double) (f6 - f8), (double) (f5 - f7)))));
    }

    /* renamed from: a */
    private float m33855a(float f, float f2) {
        this.f26492g = (f2 % 360.0f) - (f % 360.0f);
        float f3 = this.f26492g;
        if (f3 < -180.0f) {
            this.f26492g = f3 + 360.0f;
        } else if (f3 > 180.0f) {
            this.f26492g = f3 - 360.0f;
        }
        return this.f26492g;
    }
}
