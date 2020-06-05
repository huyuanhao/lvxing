package com.ksad.lottie.model;

import androidx.core.util.Pair;

/* renamed from: com.ksad.lottie.model.f */
public class C3773f<T> {
    /* renamed from: a */
    T f12825a;
    /* renamed from: b */
    T f12826b;

    /* renamed from: b */
    private static boolean m15640b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public void mo23141a(T t, T t2) {
        this.f12825a = t;
        this.f12826b = t2;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (m15640b(pair.first, this.f12825a) && m15640b(pair.second, this.f12826b)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        T t = this.f12825a;
        int i = 0;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.f12826b;
        if (t2 != null) {
            i = t2.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pair{");
        sb.append(String.valueOf(this.f12825a));
        sb.append(" ");
        sb.append(String.valueOf(this.f12826b));
        sb.append("}");
        return sb.toString();
    }
}
