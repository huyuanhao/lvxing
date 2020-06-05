package com.ksad.lottie.p303d;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.ksad.lottie.C3703d;

/* renamed from: com.ksad.lottie.d.c */
public class C3706c extends C3704a implements FrameCallback {
    /* renamed from: a */
    protected boolean f12602a = false;
    /* renamed from: b */
    private float f12603b = 1.0f;
    /* renamed from: c */
    private boolean f12604c = false;
    /* renamed from: d */
    private long f12605d = 0;
    /* renamed from: e */
    private float f12606e = 0.0f;
    /* renamed from: f */
    private int f12607f = 0;
    /* renamed from: g */
    private float f12608g = -2.14748365E9f;
    /* renamed from: h */
    private float f12609h = 2.14748365E9f;
    /* renamed from: i */
    private C3703d f12610i;

    /* renamed from: o */
    private float m15354o() {
        C3703d dVar = this.f12610i;
        if (dVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / dVar.mo22883f()) / Math.abs(this.f12603b);
    }

    /* renamed from: p */
    private boolean m15355p() {
        return mo22921h() < 0.0f;
    }

    /* renamed from: q */
    private void m15356q() {
        if (this.f12610i != null) {
            float f = this.f12606e;
            if (f < this.f12608g || f > this.f12609h) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", new Object[]{Float.valueOf(this.f12608g), Float.valueOf(this.f12609h), Float.valueOf(this.f12606e)}));
            }
        }
    }

    /* renamed from: a */
    public void mo22905a(float f) {
        this.f12603b = f;
    }

    /* renamed from: a */
    public void mo22906a(int i) {
        float f = (float) i;
        if (this.f12606e != f) {
            this.f12606e = C3708e.m15384b(f, mo22925k(), mo22926l());
            this.f12605d = System.nanoTime();
            mo22896c();
        }
    }

    /* renamed from: a */
    public void mo22907a(int i, int i2) {
        C3703d dVar = this.f12610i;
        float d = dVar == null ? -3.4028235E38f : dVar.mo22881d();
        C3703d dVar2 = this.f12610i;
        float e = dVar2 == null ? Float.MAX_VALUE : dVar2.mo22882e();
        float f = (float) i;
        this.f12608g = C3708e.m15384b(f, d, e);
        float f2 = (float) i2;
        this.f12609h = C3708e.m15384b(f2, d, e);
        mo22906a((int) C3708e.m15384b(this.f12606e, f, f2));
    }

    /* renamed from: a */
    public void mo22908a(C3703d dVar) {
        float f;
        int i;
        boolean z = this.f12610i == null;
        this.f12610i = dVar;
        if (z) {
            i = (int) Math.max(this.f12608g, dVar.mo22881d());
            f = Math.min(this.f12609h, dVar.mo22882e());
        } else {
            i = (int) dVar.mo22881d();
            f = dVar.mo22882e();
        }
        mo22907a(i, (int) f);
        mo22906a((int) this.f12606e);
        this.f12605d = System.nanoTime();
    }

    /* renamed from: b */
    public void mo22909b(int i) {
        mo22907a(i, (int) this.f12609h);
    }

    /* renamed from: c */
    public void mo22910c(int i) {
        mo22907a((int) this.f12608g, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo22911c(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.f12602a = false;
        }
    }

    public void cancel() {
        mo22894b();
        mo22928n();
    }

    /* renamed from: d */
    public float mo22913d() {
        C3703d dVar = this.f12610i;
        if (dVar == null) {
            return 0.0f;
        }
        return (this.f12606e - dVar.mo22881d()) / (this.f12610i.mo22882e() - this.f12610i.mo22881d());
    }

    public void doFrame(long j) {
        mo22927m();
        if (this.f12610i != null && isRunning()) {
            long nanoTime = System.nanoTime();
            float o = ((float) (nanoTime - this.f12605d)) / m15354o();
            float f = this.f12606e;
            if (m15355p()) {
                o = -o;
            }
            this.f12606e = f + o;
            boolean z = !C3708e.m15386c(this.f12606e, mo22925k(), mo22926l());
            this.f12606e = C3708e.m15384b(this.f12606e, mo22925k(), mo22926l());
            this.f12605d = nanoTime;
            mo22896c();
            if (z) {
                if (getRepeatCount() == -1 || this.f12607f < getRepeatCount()) {
                    mo22890a();
                    this.f12607f++;
                    if (getRepeatMode() == 2) {
                        this.f12604c = !this.f12604c;
                        mo22917g();
                    } else {
                        this.f12606e = m15355p() ? mo22926l() : mo22925k();
                    }
                    this.f12605d = nanoTime;
                } else {
                    this.f12606e = mo22926l();
                    mo22928n();
                    mo22895b(m15355p());
                }
            }
            m15356q();
        }
    }

    /* renamed from: e */
    public float mo22915e() {
        return this.f12606e;
    }

    /* renamed from: f */
    public void mo22916f() {
        this.f12610i = null;
        this.f12608g = -2.14748365E9f;
        this.f12609h = 2.14748365E9f;
    }

    /* renamed from: g */
    public void mo22917g() {
        mo22905a(-mo22921h());
    }

    public float getAnimatedFraction() {
        float f;
        float k;
        if (this.f12610i == null) {
            return 0.0f;
        }
        if (m15355p()) {
            f = mo22926l();
            k = this.f12606e;
        } else {
            f = this.f12606e;
            k = mo22925k();
        }
        return (f - k) / (mo22926l() - mo22925k());
    }

    public Object getAnimatedValue() {
        return Float.valueOf(mo22913d());
    }

    public long getDuration() {
        C3703d dVar = this.f12610i;
        if (dVar == null) {
            return 0;
        }
        return (long) dVar.mo22880c();
    }

    /* renamed from: h */
    public float mo22921h() {
        return this.f12603b;
    }

    /* renamed from: i */
    public void mo22922i() {
        this.f12602a = true;
        mo22891a(m15355p());
        mo22906a((int) (m15355p() ? mo22926l() : mo22925k()));
        this.f12605d = System.nanoTime();
        this.f12607f = 0;
        mo22927m();
    }

    public boolean isRunning() {
        return this.f12602a;
    }

    /* renamed from: j */
    public void mo22924j() {
        mo22928n();
        mo22895b(m15355p());
    }

    /* renamed from: k */
    public float mo22925k() {
        C3703d dVar = this.f12610i;
        if (dVar == null) {
            return 0.0f;
        }
        float f = this.f12608g;
        if (f == -2.14748365E9f) {
            f = dVar.mo22881d();
        }
        return f;
    }

    /* renamed from: l */
    public float mo22926l() {
        C3703d dVar = this.f12610i;
        if (dVar == null) {
            return 0.0f;
        }
        float f = this.f12609h;
        if (f == 2.14748365E9f) {
            f = dVar.mo22882e();
        }
        return f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void mo22927m() {
        if (isRunning()) {
            mo22911c(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public void mo22928n() {
        mo22911c(true);
    }

    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i != 2 && this.f12604c) {
            this.f12604c = false;
            mo22917g();
        }
    }
}
