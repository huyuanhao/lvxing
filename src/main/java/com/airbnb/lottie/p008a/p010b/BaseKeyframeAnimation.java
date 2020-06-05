package com.airbnb.lottie.p008a.p010b;

import com.airbnb.lottie.p014e.Keyframe;
import com.airbnb.lottie.p014e.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.b.a */
public abstract class BaseKeyframeAnimation<K, A> {
    /* renamed from: a */
    final List<C0925a> f1396a = new ArrayList();
    /* renamed from: b */
    protected LottieValueCallback<A> f1397b;
    /* renamed from: c */
    private boolean f1398c = false;
    /* renamed from: d */
    private final List<? extends Keyframe<K>> f1399d;
    /* renamed from: e */
    private float f1400e = 0.0f;
    /* renamed from: f */
    private Keyframe<K> f1401f;

    /* compiled from: BaseKeyframeAnimation */
    /* renamed from: com.airbnb.lottie.a.b.a$a */
    public interface C0925a {
        /* renamed from: a */
        void mo9846a();
    }

    /* renamed from: a */
    public abstract A mo9862a(Keyframe<K> aVar, float f);

    BaseKeyframeAnimation(List<? extends Keyframe<K>> list) {
        this.f1399d = list;
    }

    /* renamed from: a */
    public void mo9863a() {
        this.f1398c = true;
    }

    /* renamed from: a */
    public void mo9865a(C0925a aVar) {
        this.f1396a.add(aVar);
    }

    /* renamed from: a */
    public void mo9864a(float f) {
        if (f < m1251i()) {
            f = m1251i();
        } else if (f > mo9869d()) {
            f = mo9869d();
        }
        if (f != this.f1400e) {
            this.f1400e = f;
            mo9867b();
        }
    }

    /* renamed from: b */
    public void mo9867b() {
        for (int i = 0; i < this.f1396a.size(); i++) {
            ((C0925a) this.f1396a.get(i)).mo9846a();
        }
    }

    /* renamed from: g */
    private Keyframe<K> mo9885g() {
        Keyframe<K> aVar = this.f1401f;
        if (aVar != null && aVar.mo9979a(this.f1400e)) {
            return this.f1401f;
        }
        List<? extends Keyframe<K>> list = this.f1399d;
        Keyframe<K> aVar2 = (Keyframe) list.get(list.size() - 1);
        if (this.f1400e < aVar2.mo9980b()) {
            for (int size = this.f1399d.size() - 1; size >= 0; size--) {
                aVar2 = (Keyframe) this.f1399d.get(size);
                if (aVar2.mo9979a(this.f1400e)) {
                    break;
                }
            }
        }
        this.f1401f = aVar2;
        return aVar2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public float mo9868c() {
        if (this.f1398c) {
            return 0.0f;
        }
        Keyframe g = mo9885g();
        if (g.mo9982d()) {
            return 0.0f;
        }
        return (this.f1400e - g.mo9980b()) / (g.mo9981c() - g.mo9980b());
    }

    /* renamed from: h */
    private float m1250h() {
        Keyframe g = mo9885g();
        if (g.mo9982d()) {
            return 0.0f;
        }
        return g.f1498c.getInterpolation(mo9868c());
    }

    /* renamed from: i */
    private float m1251i() {
        if (this.f1399d.isEmpty()) {
            return 0.0f;
        }
        return ((Keyframe) this.f1399d.get(0)).mo9980b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public float mo9869d() {
        if (this.f1399d.isEmpty()) {
            return 1.0f;
        }
        List<? extends Keyframe<K>> list = this.f1399d;
        return ((Keyframe) list.get(list.size() - 1)).mo9981c();
    }

    /* renamed from: e */
    public A mo9870e() {
        return mo9862a(mo9885g(), m1250h());
    }

    /* renamed from: f */
    public float mo9871f() {
        return this.f1400e;
    }

    /* renamed from: a */
    public void mo9866a(LottieValueCallback<A> cVar) {
        LottieValueCallback<A> cVar2 = this.f1397b;
        if (cVar2 != null) {
            cVar2.mo9987a(null);
        }
        this.f1397b = cVar;
        if (cVar != null) {
            cVar.mo9987a(this);
        }
    }
}
