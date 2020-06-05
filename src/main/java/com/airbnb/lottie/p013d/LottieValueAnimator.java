package com.airbnb.lottie.p013d;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.airbnb.lottie.LottieComposition;

/* renamed from: com.airbnb.lottie.d.c */
public class LottieValueAnimator extends BaseLottieAnimator implements FrameCallback {
    /* renamed from: a */
    protected boolean f1470a = false;
    /* renamed from: b */
    private float f1471b = 1.0f;
    /* renamed from: c */
    private boolean f1472c = false;
    /* renamed from: d */
    private long f1473d = 0;
    /* renamed from: e */
    private float f1474e = 0.0f;
    /* renamed from: f */
    private int f1475f = 0;
    /* renamed from: g */
    private float f1476g = -2.14748365E9f;
    /* renamed from: h */
    private float f1477h = 2.14748365E9f;
    /* renamed from: i */
    private LottieComposition f1478i;

    public Object getAnimatedValue() {
        return Float.valueOf(mo9953d());
    }

    /* renamed from: d */
    public float mo9953d() {
        LottieComposition dVar = this.f1478i;
        if (dVar == null) {
            return 0.0f;
        }
        return (this.f1474e - dVar.mo9921d()) / (this.f1478i.mo9922e() - this.f1478i.mo9921d());
    }

    public float getAnimatedFraction() {
        float k;
        float l;
        float k2;
        if (this.f1478i == null) {
            return 0.0f;
        }
        if (m1418p()) {
            k = mo9966l() - this.f1474e;
            l = mo9966l();
            k2 = mo9965k();
        } else {
            k = this.f1474e - mo9965k();
            l = mo9966l();
            k2 = mo9965k();
        }
        return k / (l - k2);
    }

    public long getDuration() {
        LottieComposition dVar = this.f1478i;
        if (dVar == null) {
            return 0;
        }
        return (long) dVar.mo9920c();
    }

    /* renamed from: e */
    public float mo9955e() {
        return this.f1474e;
    }

    public boolean isRunning() {
        return this.f1470a;
    }

    public void doFrame(long j) {
        mo9967m();
        if (this.f1478i != null && isRunning()) {
            long nanoTime = System.nanoTime();
            float o = ((float) (nanoTime - this.f1473d)) / m1417o();
            float f = this.f1474e;
            if (m1418p()) {
                o = -o;
            }
            this.f1474e = f + o;
            boolean z = !MiscUtils.m1450c(this.f1474e, mo9965k(), mo9966l());
            this.f1474e = MiscUtils.m1448b(this.f1474e, mo9965k(), mo9966l());
            this.f1473d = nanoTime;
            mo9936c();
            if (z) {
                if (getRepeatCount() == -1 || this.f1475f < getRepeatCount()) {
                    mo9930a();
                    this.f1475f++;
                    if (getRepeatMode() == 2) {
                        this.f1472c = !this.f1472c;
                        mo9957g();
                    } else {
                        this.f1474e = m1418p() ? mo9966l() : mo9965k();
                    }
                    this.f1473d = nanoTime;
                } else {
                    this.f1474e = mo9966l();
                    mo9968n();
                    mo9935b(m1418p());
                }
            }
            m1419q();
        }
    }

    /* renamed from: o */
    private float m1417o() {
        LottieComposition dVar = this.f1478i;
        if (dVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / dVar.mo9923f()) / Math.abs(this.f1471b);
    }

    /* renamed from: f */
    public void mo9956f() {
        this.f1478i = null;
        this.f1476g = -2.14748365E9f;
        this.f1477h = 2.14748365E9f;
    }

    /* renamed from: a */
    public void mo9948a(LottieComposition dVar) {
        boolean z = this.f1478i == null;
        this.f1478i = dVar;
        if (z) {
            mo9947a((int) Math.max(this.f1476g, dVar.mo9921d()), (int) Math.min(this.f1477h, dVar.mo9922e()));
        } else {
            mo9947a((int) dVar.mo9921d(), (int) dVar.mo9922e());
        }
        mo9946a((int) this.f1474e);
        this.f1473d = System.nanoTime();
    }

    /* renamed from: a */
    public void mo9946a(int i) {
        float f = (float) i;
        if (this.f1474e != f) {
            this.f1474e = MiscUtils.m1448b(f, mo9965k(), mo9966l());
            this.f1473d = System.nanoTime();
            mo9936c();
        }
    }

    /* renamed from: b */
    public void mo9949b(int i) {
        mo9947a(i, (int) this.f1477h);
    }

    /* renamed from: c */
    public void mo9950c(int i) {
        mo9947a((int) this.f1476g, i);
    }

    /* renamed from: a */
    public void mo9947a(int i, int i2) {
        LottieComposition dVar = this.f1478i;
        float d = dVar == null ? -3.4028235E38f : dVar.mo9921d();
        LottieComposition dVar2 = this.f1478i;
        float e = dVar2 == null ? Float.MAX_VALUE : dVar2.mo9922e();
        float f = (float) i;
        this.f1476g = MiscUtils.m1448b(f, d, e);
        float f2 = (float) i2;
        this.f1477h = MiscUtils.m1448b(f2, d, e);
        mo9946a((int) MiscUtils.m1448b(this.f1474e, f, f2));
    }

    /* renamed from: g */
    public void mo9957g() {
        mo9945a(-mo9961h());
    }

    /* renamed from: a */
    public void mo9945a(float f) {
        this.f1471b = f;
    }

    /* renamed from: h */
    public float mo9961h() {
        return this.f1471b;
    }

    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i != 2 && this.f1472c) {
            this.f1472c = false;
            mo9957g();
        }
    }

    /* renamed from: i */
    public void mo9962i() {
        this.f1470a = true;
        mo9931a(m1418p());
        mo9946a((int) (m1418p() ? mo9966l() : mo9965k()));
        this.f1473d = System.nanoTime();
        this.f1475f = 0;
        mo9967m();
    }

    /* renamed from: j */
    public void mo9964j() {
        mo9968n();
        mo9935b(m1418p());
    }

    public void cancel() {
        mo9934b();
        mo9968n();
    }

    /* renamed from: p */
    private boolean m1418p() {
        return mo9961h() < 0.0f;
    }

    /* renamed from: k */
    public float mo9965k() {
        LottieComposition dVar = this.f1478i;
        if (dVar == null) {
            return 0.0f;
        }
        float f = this.f1476g;
        if (f == -2.14748365E9f) {
            f = dVar.mo9921d();
        }
        return f;
    }

    /* renamed from: l */
    public float mo9966l() {
        LottieComposition dVar = this.f1478i;
        if (dVar == null) {
            return 0.0f;
        }
        float f = this.f1477h;
        if (f == 2.14748365E9f) {
            f = dVar.mo9922e();
        }
        return f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void mo9967m() {
        if (isRunning()) {
            mo9951c(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public void mo9968n() {
        mo9951c(true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo9951c(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.f1470a = false;
        }
    }

    /* renamed from: q */
    private void m1419q() {
        if (this.f1478i != null) {
            float f = this.f1474e;
            if (f < this.f1476g || f > this.f1477h) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", new Object[]{Float.valueOf(this.f1476g), Float.valueOf(this.f1477h), Float.valueOf(this.f1474e)}));
            }
        }
    }
}
