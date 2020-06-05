package com.meituan.android.walle;

/* renamed from: com.meituan.android.walle.d */
final class Pair<A, B> {
    /* renamed from: a */
    private final A f15293a;
    /* renamed from: b */
    private final B f15294b;

    private Pair(A a, B b) {
        this.f15293a = a;
        this.f15294b = b;
    }

    /* renamed from: a */
    public static <A, B> Pair<A, B> m19524a(A a, B b) {
        return new Pair<>(a, b);
    }

    /* renamed from: a */
    public A mo25365a() {
        return this.f15293a;
    }

    public int hashCode() {
        A a = this.f15293a;
        int i = 0;
        int hashCode = ((a == null ? 0 : a.hashCode()) + 31) * 31;
        B b = this.f15294b;
        if (b != null) {
            i = b.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Pair dVar = (Pair) obj;
        A a = this.f15293a;
        if (a == null) {
            if (dVar.f15293a != null) {
                return false;
            }
        } else if (!a.equals(dVar.f15293a)) {
            return false;
        }
        B b = this.f15294b;
        if (b == null) {
            if (dVar.f15294b != null) {
                return false;
            }
        } else if (!b.equals(dVar.f15294b)) {
            return false;
        }
        return true;
    }
}
