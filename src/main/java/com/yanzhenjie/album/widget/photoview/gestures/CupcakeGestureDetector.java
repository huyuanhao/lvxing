package com.yanzhenjie.album.widget.photoview.gestures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class CupcakeGestureDetector implements GestureDetector {
    /* renamed from: a */
    protected OnGestureListener f26402a;
    /* renamed from: b */
    float f26403b;
    /* renamed from: c */
    float f26404c;
    /* renamed from: d */
    private final float f26405d;
    /* renamed from: e */
    private final float f26406e;
    /* renamed from: f */
    private VelocityTracker f26407f;
    /* renamed from: g */
    private boolean f26408g;

    /* renamed from: a */
    public boolean mo37764a() {
        return false;
    }

    /* renamed from: a */
    public void mo37763a(OnGestureListener bVar) {
        this.f26402a = bVar;
    }

    public CupcakeGestureDetector(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f26406e = (float) viewConfiguration.getScaledMinimumFlingVelocity();
        this.f26405d = (float) viewConfiguration.getScaledTouchSlop();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public float mo37762a(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public float mo37765b(MotionEvent motionEvent) {
        return motionEvent.getY();
    }

    /* renamed from: b */
    public boolean mo37766b() {
        return this.f26408g;
    }

    /* renamed from: c */
    public boolean mo37767c(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            this.f26407f = VelocityTracker.obtain();
            VelocityTracker velocityTracker = this.f26407f;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            this.f26403b = mo37762a(motionEvent);
            this.f26404c = mo37765b(motionEvent);
            this.f26408g = false;
        } else if (action == 1) {
            if (this.f26408g && this.f26407f != null) {
                this.f26403b = mo37762a(motionEvent);
                this.f26404c = mo37765b(motionEvent);
                this.f26407f.addMovement(motionEvent);
                this.f26407f.computeCurrentVelocity(1000);
                float xVelocity = this.f26407f.getXVelocity();
                float yVelocity = this.f26407f.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f26406e) {
                    this.f26402a.mo37736a(this.f26403b, this.f26404c, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker2 = this.f26407f;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f26407f = null;
            }
        } else if (action == 2) {
            float a = mo37762a(motionEvent);
            float b = mo37765b(motionEvent);
            float f = a - this.f26403b;
            float f2 = b - this.f26404c;
            if (!this.f26408g) {
                if (Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.f26405d)) {
                    z = true;
                }
                this.f26408g = z;
            }
            if (this.f26408g) {
                this.f26402a.mo37734a(f, f2);
                this.f26403b = a;
                this.f26404c = b;
                VelocityTracker velocityTracker3 = this.f26407f;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            VelocityTracker velocityTracker4 = this.f26407f;
            if (velocityTracker4 != null) {
                velocityTracker4.recycle();
                this.f26407f = null;
            }
        }
        return true;
    }
}
