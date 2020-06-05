package com.airbnb.lottie.p014e;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.LottieComposition;

/* renamed from: com.airbnb.lottie.e.a */
public class Keyframe<T> {
    /* renamed from: a */
    public final T f1496a;
    /* renamed from: b */
    public final T f1497b;
    /* renamed from: c */
    public final Interpolator f1498c;
    /* renamed from: d */
    public final float f1499d;
    /* renamed from: e */
    public Float f1500e;
    /* renamed from: f */
    public PointF f1501f;
    /* renamed from: g */
    public PointF f1502g;
    /* renamed from: h */
    private final LottieComposition f1503h;
    /* renamed from: i */
    private float f1504i;
    /* renamed from: j */
    private float f1505j;

    public Keyframe(LottieComposition dVar, T t, T t2, Interpolator interpolator, float f, Float f2) {
        this.f1504i = Float.MIN_VALUE;
        this.f1505j = Float.MIN_VALUE;
        this.f1501f = null;
        this.f1502g = null;
        this.f1503h = dVar;
        this.f1496a = t;
        this.f1497b = t2;
        this.f1498c = interpolator;
        this.f1499d = f;
        this.f1500e = f2;
    }

    public Keyframe(T t) {
        this.f1504i = Float.MIN_VALUE;
        this.f1505j = Float.MIN_VALUE;
        this.f1501f = null;
        this.f1502g = null;
        this.f1503h = null;
        this.f1496a = t;
        this.f1497b = t;
        this.f1498c = null;
        this.f1499d = Float.MIN_VALUE;
        this.f1500e = Float.valueOf(Float.MAX_VALUE);
    }

    /* renamed from: b */
    public float mo9980b() {
        LottieComposition dVar = this.f1503h;
        if (dVar == null) {
            return 0.0f;
        }
        if (this.f1504i == Float.MIN_VALUE) {
            this.f1504i = (this.f1499d - dVar.mo9921d()) / this.f1503h.mo9928k();
        }
        return this.f1504i;
    }

    /* renamed from: c */
    public float mo9981c() {
        if (this.f1503h == null) {
            return 1.0f;
        }
        if (this.f1505j == Float.MIN_VALUE) {
            if (this.f1500e == null) {
                this.f1505j = 1.0f;
            } else {
                this.f1505j = mo9980b() + ((this.f1500e.floatValue() - this.f1499d) / this.f1503h.mo9928k());
            }
        }
        return this.f1505j;
    }

    /* renamed from: d */
    public boolean mo9982d() {
        return this.f1498c == null;
    }

    /* renamed from: a */
    public boolean mo9979a(float f) {
        return f >= mo9980b() && f < mo9981c();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Keyframe{startValue=");
        sb.append(this.f1496a);
        sb.append(", endValue=");
        sb.append(this.f1497b);
        sb.append(", startFrame=");
        sb.append(this.f1499d);
        sb.append(", endFrame=");
        sb.append(this.f1500e);
        sb.append(", interpolator=");
        sb.append(this.f1498c);
        sb.append('}');
        return sb.toString();
    }
}
