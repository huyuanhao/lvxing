package epco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: epco.k */
class C7978k {
    /* renamed from: a */
    private final List<C7980b> f27103a = new ArrayList();
    /* renamed from: b */
    private final List<C7980b> f27104b = new ArrayList();

    /* renamed from: epco.k$b */
    public static class C7980b {
        /* renamed from: a */
        final String f27105a;
        /* renamed from: b */
        final String f27106b;

        private C7980b(String str, String str2) {
            this.f27105a = str;
            this.f27106b = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C7980b.class != obj.getClass()) {
                return false;
            }
            C7980b bVar = (C7980b) obj;
            if (this.f27105a == null && bVar.f27105a != null) {
                return false;
            }
            if (this.f27106b == null && bVar.f27106b != null) {
                return false;
            }
            String str = this.f27105a;
            if (str != null && !str.equals(bVar.f27105a)) {
                return false;
            }
            String str2 = this.f27106b;
            return str2 == null || str2.equals(bVar.f27106b);
        }

        public int hashCode() {
            return (this.f27105a.hashCode() * 31) + this.f27106b.hashCode();
        }
    }

    C7978k() {
    }

    /* renamed from: a */
    public String mo38369a(String str) {
        if (str == null) {
            return null;
        }
        for (C7980b bVar : this.f27103a) {
            if (bVar.f27106b.equals(str)) {
                return bVar.f27105a;
            }
        }
        return null;
    }

    /* renamed from: a */
    public List<C7980b> mo38370a() {
        if (this.f27104b.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f27104b);
        this.f27104b.clear();
        return arrayList;
    }

    /* renamed from: a */
    public void mo38371a(C7981k0 k0Var) {
        C7980b bVar = new C7980b(k0Var.mo38375a(), k0Var.mo38377b());
        this.f27103a.remove(bVar);
        this.f27104b.remove(bVar);
    }

    /* renamed from: a */
    public void mo38372a(C7983l0 l0Var) {
        C7980b bVar = new C7980b(l0Var.mo38380a(), l0Var.mo38382b());
        this.f27103a.add(bVar);
        this.f27104b.add(bVar);
    }
}
