package com.airbnb.lottie.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Marker;

/* renamed from: com.airbnb.lottie.model.e */
public class KeyPath {
    /* renamed from: a */
    private final List<String> f1684a;
    /* renamed from: b */
    private KeyPathElement f1685b;

    public KeyPath(String... strArr) {
        this.f1684a = Arrays.asList(strArr);
    }

    private KeyPath(KeyPath eVar) {
        this.f1684a = new ArrayList(eVar.f1684a);
        this.f1685b = eVar.f1685b;
    }

    /* renamed from: a */
    public KeyPath mo10121a(String str) {
        KeyPath eVar = new KeyPath(this);
        eVar.f1684a.add(str);
        return eVar;
    }

    /* renamed from: a */
    public KeyPath mo10120a(KeyPathElement fVar) {
        KeyPath eVar = new KeyPath(this);
        eVar.f1685b = fVar;
        return eVar;
    }

    /* renamed from: a */
    public KeyPathElement mo10122a() {
        return this.f1685b;
    }

    /* renamed from: a */
    public boolean mo10123a(String str, int i) {
        if (m1644b(str)) {
            return true;
        }
        if (i >= this.f1684a.size()) {
            return false;
        }
        if (((String) this.f1684a.get(i)).equals(str) || ((String) this.f1684a.get(i)).equals("**") || ((String) this.f1684a.get(i)).equals(Marker.ANY_MARKER)) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public int mo10124b(String str, int i) {
        if (m1644b(str)) {
            return 0;
        }
        if (!((String) this.f1684a.get(i)).equals("**")) {
            return 1;
        }
        if (i != this.f1684a.size() - 1 && ((String) this.f1684a.get(i + 1)).equals(str)) {
            return 2;
        }
        return 0;
    }

    /* renamed from: c */
    public boolean mo10125c(String str, int i) {
        boolean z = false;
        if (i >= this.f1684a.size()) {
            return false;
        }
        boolean z2 = i == this.f1684a.size() - 1;
        String str2 = (String) this.f1684a.get(i);
        if (!str2.equals("**")) {
            boolean z3 = str2.equals(str) || str2.equals(Marker.ANY_MARKER);
            if ((z2 || (i == this.f1684a.size() - 2 && m1643b())) && z3) {
                z = true;
            }
            return z;
        }
        boolean z4 = !z2 && ((String) this.f1684a.get(i + 1)).equals(str);
        if (z4) {
            if (i == this.f1684a.size() - 2 || (i == this.f1684a.size() - 3 && m1643b())) {
                z = true;
            }
            return z;
        } else if (z2) {
            return true;
        } else {
            int i2 = i + 1;
            if (i2 < this.f1684a.size() - 1) {
                return false;
            }
            return ((String) this.f1684a.get(i2)).equals(str);
        }
    }

    /* renamed from: d */
    public boolean mo10126d(String str, int i) {
        boolean z = true;
        if (str.equals("__container")) {
            return true;
        }
        if (i >= this.f1684a.size() - 1 && !((String) this.f1684a.get(i)).equals("**")) {
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    private boolean m1644b(String str) {
        return str.equals("__container");
    }

    /* renamed from: b */
    private boolean m1643b() {
        List<String> list = this.f1684a;
        return ((String) list.get(list.size() - 1)).equals("**");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f1684a);
        sb.append(",resolved=");
        sb.append(this.f1685b != null);
        sb.append('}');
        return sb.toString();
    }
}
