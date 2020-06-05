package com.bumptech.glide.load.engine.p137a;

import com.bumptech.glide.load.engine.p137a.Poolable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.engine.a.h */
class GroupedLinkedMap<K extends Poolable, V> {
    /* renamed from: a */
    private final C1640a<K, V> f4455a = new C1640a<>();
    /* renamed from: b */
    private final Map<K, C1640a<K, V>> f4456b = new HashMap();

    /* compiled from: GroupedLinkedMap */
    /* renamed from: com.bumptech.glide.load.engine.a.h$a */
    private static class C1640a<K, V> {
        /* renamed from: a */
        final K f4457a;
        /* renamed from: b */
        C1640a<K, V> f4458b;
        /* renamed from: c */
        C1640a<K, V> f4459c;
        /* renamed from: d */
        private List<V> f4460d;

        C1640a() {
            this(null);
        }

        C1640a(K k) {
            this.f4459c = this;
            this.f4458b = this;
            this.f4457a = k;
        }

        /* renamed from: a */
        public V mo12737a() {
            int b = mo12739b();
            if (b > 0) {
                return this.f4460d.remove(b - 1);
            }
            return null;
        }

        /* renamed from: b */
        public int mo12739b() {
            List<V> list = this.f4460d;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        /* renamed from: a */
        public void mo12738a(V v) {
            if (this.f4460d == null) {
                this.f4460d = new ArrayList();
            }
            this.f4460d.add(v);
        }
    }

    GroupedLinkedMap() {
    }

    /* renamed from: a */
    public void mo12735a(K k, V v) {
        C1640a aVar = (C1640a) this.f4456b.get(k);
        if (aVar == null) {
            aVar = new C1640a(k);
            m5431b(aVar);
            this.f4456b.put(k, aVar);
        } else {
            k.mo12714a();
        }
        aVar.mo12738a(v);
    }

    /* renamed from: a */
    public V mo12734a(K k) {
        C1640a aVar = (C1640a) this.f4456b.get(k);
        if (aVar == null) {
            aVar = new C1640a(k);
            this.f4456b.put(k, aVar);
        } else {
            k.mo12714a();
        }
        m5430a(aVar);
        return aVar.mo12737a();
    }

    /* renamed from: a */
    public V mo12733a() {
        for (C1640a<K, V> aVar = this.f4455a.f4459c; !aVar.equals(this.f4455a); aVar = aVar.f4459c) {
            V a = aVar.mo12737a();
            if (a != null) {
                return a;
            }
            m5433d(aVar);
            this.f4456b.remove(aVar.f4457a);
            ((Poolable) aVar.f4457a).mo12714a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (C1640a<K, V> aVar = this.f4455a.f4458b; !aVar.equals(this.f4455a); aVar = aVar.f4458b) {
            z = true;
            sb.append('{');
            sb.append(aVar.f4457a);
            sb.append(':');
            sb.append(aVar.mo12739b());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }

    /* renamed from: a */
    private void m5430a(C1640a<K, V> aVar) {
        m5433d(aVar);
        C1640a<K, V> aVar2 = this.f4455a;
        aVar.f4459c = aVar2;
        aVar.f4458b = aVar2.f4458b;
        m5432c(aVar);
    }

    /* renamed from: b */
    private void m5431b(C1640a<K, V> aVar) {
        m5433d(aVar);
        aVar.f4459c = this.f4455a.f4459c;
        aVar.f4458b = this.f4455a;
        m5432c(aVar);
    }

    /* renamed from: c */
    private static <K, V> void m5432c(C1640a<K, V> aVar) {
        aVar.f4458b.f4459c = aVar;
        aVar.f4459c.f4458b = aVar;
    }

    /* renamed from: d */
    private static <K, V> void m5433d(C1640a<K, V> aVar) {
        aVar.f4459c.f4458b = aVar.f4458b;
        aVar.f4458b.f4459c = aVar.f4459c;
    }
}
