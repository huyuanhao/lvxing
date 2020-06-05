package com.airbnb.lottie;

import java.util.Arrays;

/* renamed from: com.airbnb.lottie.i */
public final class LottieResult<V> {
    /* renamed from: a */
    private final V f1548a;
    /* renamed from: b */
    private final Throwable f1549b;

    public LottieResult(V v) {
        this.f1548a = v;
        this.f1549b = null;
    }

    public LottieResult(Throwable th) {
        this.f1549b = th;
        this.f1548a = null;
    }

    /* renamed from: a */
    public V mo9995a() {
        return this.f1548a;
    }

    /* renamed from: b */
    public Throwable mo9996b() {
        return this.f1549b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LottieResult)) {
            return false;
        }
        LottieResult iVar = (LottieResult) obj;
        if (mo9995a() != null && mo9995a().equals(iVar.mo9995a())) {
            return true;
        }
        if (mo9996b() == null || iVar.mo9996b() == null) {
            return false;
        }
        return mo9996b().toString().equals(mo9996b().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{mo9995a(), mo9996b()});
    }
}
