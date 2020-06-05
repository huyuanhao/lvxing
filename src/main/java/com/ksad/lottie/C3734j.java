package com.ksad.lottie;

import java.util.Arrays;

/* renamed from: com.ksad.lottie.j */
public final class C3734j<V> {
    /* renamed from: a */
    private final V f12687a;
    /* renamed from: b */
    private final Throwable f12688b;

    public C3734j(V v) {
        this.f12687a = v;
        this.f12688b = null;
    }

    public C3734j(Throwable th) {
        this.f12688b = th;
        this.f12687a = null;
    }

    /* renamed from: a */
    public V mo23014a() {
        return this.f12687a;
    }

    /* renamed from: b */
    public Throwable mo23015b() {
        return this.f12688b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3734j)) {
            return false;
        }
        C3734j jVar = (C3734j) obj;
        if (mo23014a() != null && mo23014a().equals(jVar.mo23014a())) {
            return true;
        }
        if (mo23015b() == null || jVar.mo23015b() == null) {
            return false;
        }
        return mo23015b().toString().equals(mo23015b().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{mo23014a(), mo23015b()});
    }
}
