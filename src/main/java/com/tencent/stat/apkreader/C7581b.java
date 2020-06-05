package com.tencent.stat.apkreader;

/* renamed from: com.tencent.stat.apkreader.b */
final class C7581b<A, B> {
    /* renamed from: a */
    private final A f25595a;
    /* renamed from: b */
    private final B f25596b;

    private C7581b(A a, B b) {
        this.f25595a = a;
        this.f25596b = b;
    }

    /* renamed from: a */
    public static <A, B> C7581b<A, B> m32700a(A a, B b) {
        return new C7581b<>(a, b);
    }

    /* renamed from: a */
    public A mo37082a() {
        return this.f25595a;
    }

    public int hashCode() {
        A a = this.f25595a;
        int i = 0;
        int hashCode = ((a == null ? 0 : a.hashCode()) + 31) * 31;
        B b = this.f25596b;
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
        C7581b bVar = (C7581b) obj;
        A a = this.f25595a;
        if (a == null) {
            if (bVar.f25595a != null) {
                return false;
            }
        } else if (!a.equals(bVar.f25595a)) {
            return false;
        }
        B b = this.f25596b;
        if (b == null) {
            if (bVar.f25596b != null) {
                return false;
            }
        } else if (!b.equals(bVar.f25596b)) {
            return false;
        }
        return true;
    }
}
