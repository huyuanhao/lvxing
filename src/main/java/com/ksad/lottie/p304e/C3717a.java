package com.ksad.lottie.p304e;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.ksad.lottie.C3703d;

/* renamed from: com.ksad.lottie.e.a */
public class C3717a<T> {
    /* renamed from: a */
    public final T f12629a;
    /* renamed from: b */
    public final T f12630b;
    /* renamed from: c */
    public final Interpolator f12631c;
    /* renamed from: d */
    public final float f12632d;
    /* renamed from: e */
    public Float f12633e;
    /* renamed from: f */
    public PointF f12634f;
    /* renamed from: g */
    public PointF f12635g;
    /* renamed from: h */
    private final C3703d f12636h;
    /* renamed from: i */
    private float f12637i;
    /* renamed from: j */
    private float f12638j;

    public C3717a(C3703d dVar, T t, T t2, Interpolator interpolator, float f, Float f2) {
        this.f12637i = Float.MIN_VALUE;
        this.f12638j = Float.MIN_VALUE;
        this.f12634f = null;
        this.f12635g = null;
        this.f12636h = dVar;
        this.f12629a = t;
        this.f12630b = t2;
        this.f12631c = interpolator;
        this.f12632d = f;
        this.f12633e = f2;
    }

    public C3717a(T t) {
        this.f12637i = Float.MIN_VALUE;
        this.f12638j = Float.MIN_VALUE;
        this.f12634f = null;
        this.f12635g = null;
        this.f12636h = null;
        this.f12629a = t;
        this.f12630b = t;
        this.f12631c = null;
        this.f12632d = Float.MIN_VALUE;
        this.f12633e = Float.valueOf(Float.MAX_VALUE);
    }

    /* renamed from: a */
    public boolean mo22941a(float f) {
        return f >= mo22942b() && f < mo22943c();
    }

    /* renamed from: b */
    public float mo22942b() {
        C3703d dVar = this.f12636h;
        if (dVar == null) {
            return 0.0f;
        }
        if (this.f12637i == Float.MIN_VALUE) {
            this.f12637i = (this.f12632d - dVar.mo22881d()) / this.f12636h.mo22888k();
        }
        return this.f12637i;
    }

    /* renamed from: c */
    public float mo22943c() {
        if (this.f12636h == null) {
            return 1.0f;
        }
        if (this.f12638j == Float.MIN_VALUE) {
            if (this.f12633e == null) {
                this.f12638j = 1.0f;
            } else {
                this.f12638j = mo22942b() + ((this.f12633e.floatValue() - this.f12632d) / this.f12636h.mo22888k());
            }
        }
        return this.f12638j;
    }

    /* renamed from: d */
    public boolean mo22944d() {
        return this.f12631c == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Keyframe{startValue=");
        sb.append(this.f12629a);
        sb.append(", endValue=");
        sb.append(this.f12630b);
        sb.append(", startFrame=");
        sb.append(this.f12632d);
        sb.append(", endFrame=");
        sb.append(this.f12633e);
        sb.append(", interpolator=");
        sb.append(this.f12631c);
        sb.append('}');
        return sb.toString();
    }
}
