package com.ksad.lottie.p298a.p300b;

import com.ksad.lottie.p304e.C3717a;
import com.ksad.lottie.p304e.C3719c;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.ksad.lottie.a.b.a */
public abstract class C3646a<K, A> {
    /* renamed from: a */
    final List<C3647a> f12529a = new ArrayList();
    /* renamed from: b */
    protected C3719c<A> f12530b;
    /* renamed from: c */
    private boolean f12531c = false;
    /* renamed from: d */
    private final List<? extends C3717a<K>> f12532d;
    /* renamed from: e */
    private float f12533e = 0.0f;
    /* renamed from: f */
    private C3717a<K> f12534f;

    /* renamed from: com.ksad.lottie.a.b.a$a */
    public interface C3647a {
        /* renamed from: a */
        void mo22811a();
    }

    C3646a(List<? extends C3717a<K>> list) {
        this.f12532d = list;
    }

    /* renamed from: g */
    private C3717a<K> mo22846g() {
        C3717a<K> aVar = this.f12534f;
        if (aVar != null && aVar.mo22941a(this.f12533e)) {
            return this.f12534f;
        }
        List<? extends C3717a<K>> list = this.f12532d;
        C3717a<K> aVar2 = (C3717a) list.get(list.size() - 1);
        if (this.f12533e < aVar2.mo22942b()) {
            for (int size = this.f12532d.size() - 1; size >= 0; size--) {
                aVar2 = (C3717a) this.f12532d.get(size);
                if (aVar2.mo22941a(this.f12533e)) {
                    break;
                }
            }
        }
        this.f12534f = aVar2;
        return aVar2;
    }

    /* renamed from: h */
    private float m15193h() {
        C3717a g = mo22846g();
        if (g.mo22944d()) {
            return 0.0f;
        }
        return g.f12631c.getInterpolation(mo22829c());
    }

    /* renamed from: i */
    private float m15194i() {
        if (this.f12532d.isEmpty()) {
            return 0.0f;
        }
        return ((C3717a) this.f12532d.get(0)).mo22942b();
    }

    /* renamed from: a */
    public abstract A mo22824a(C3717a<K> aVar, float f);

    /* renamed from: a */
    public void mo22825a() {
        this.f12531c = true;
    }

    /* renamed from: a */
    public void mo22826a(float f) {
        if (f < m15194i()) {
            f = m15194i();
        } else if (f > mo22830d()) {
            f = mo22830d();
        }
        if (f != this.f12533e) {
            this.f12533e = f;
            mo22828b();
        }
    }

    /* renamed from: a */
    public void mo22827a(C3647a aVar) {
        this.f12529a.add(aVar);
    }

    /* renamed from: b */
    public void mo22828b() {
        for (int i = 0; i < this.f12529a.size(); i++) {
            ((C3647a) this.f12529a.get(i)).mo22811a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public float mo22829c() {
        if (this.f12531c) {
            return 0.0f;
        }
        C3717a g = mo22846g();
        if (g.mo22944d()) {
            return 0.0f;
        }
        return (this.f12533e - g.mo22942b()) / (g.mo22943c() - g.mo22942b());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public float mo22830d() {
        if (this.f12532d.isEmpty()) {
            return 1.0f;
        }
        List<? extends C3717a<K>> list = this.f12532d;
        return ((C3717a) list.get(list.size() - 1)).mo22943c();
    }

    /* renamed from: e */
    public A mo22831e() {
        return mo22824a(mo22846g(), m15193h());
    }

    /* renamed from: f */
    public float mo22832f() {
        return this.f12533e;
    }
}
