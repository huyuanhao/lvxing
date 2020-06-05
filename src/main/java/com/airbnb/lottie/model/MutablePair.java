package com.airbnb.lottie.model;

import androidx.core.util.Pair;

/* renamed from: com.airbnb.lottie.model.h */
public class MutablePair<T> {
    /* renamed from: a */
    T f1688a;
    /* renamed from: b */
    T f1689b;

    /* renamed from: a */
    public void mo10132a(T t, T t2) {
        this.f1688a = t;
        this.f1689b = t2;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (m1659b(pair.first, this.f1688a) && m1659b(pair.second, this.f1689b)) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    private static boolean m1659b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        T t = this.f1688a;
        int i = 0;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.f1689b;
        if (t2 != null) {
            i = t2.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pair{");
        sb.append(String.valueOf(this.f1688a));
        sb.append(" ");
        sb.append(String.valueOf(this.f1689b));
        sb.append("}");
        return sb.toString();
    }
}
