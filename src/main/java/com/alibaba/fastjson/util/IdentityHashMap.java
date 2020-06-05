package com.alibaba.fastjson.util;

/* renamed from: com.alibaba.fastjson.util.e */
public class IdentityHashMap<K, V> {
    /* renamed from: a */
    private final C1276a<K, V>[] f3030a;
    /* renamed from: b */
    private final int f3031b;

    /* compiled from: IdentityHashMap */
    /* renamed from: com.alibaba.fastjson.util.e$a */
    protected static final class C1276a<K, V> {
        /* renamed from: a */
        public final int f3032a;
        /* renamed from: b */
        public final K f3033b;
        /* renamed from: c */
        public V f3034c;
        /* renamed from: d */
        public final C1276a<K, V> f3035d;

        public C1276a(K k, V v, int i, C1276a<K, V> aVar) {
            this.f3033b = k;
            this.f3034c = v;
            this.f3035d = aVar;
            this.f3032a = i;
        }
    }

    public IdentityHashMap() {
        this(8192);
    }

    public IdentityHashMap(int i) {
        this.f3031b = i - 1;
        this.f3030a = new C1276a[i];
    }

    /* renamed from: a */
    public final V mo11513a(K k) {
        for (C1276a<K, V> aVar = this.f3030a[System.identityHashCode(k) & this.f3031b]; aVar != null; aVar = aVar.f3035d) {
            if (k == aVar.f3033b) {
                return aVar.f3034c;
            }
        }
        return null;
    }

    /* renamed from: a */
    public Class mo11512a(String str) {
        int i = 0;
        while (true) {
            C1276a<K, V>[] aVarArr = this.f3030a;
            if (i >= aVarArr.length) {
                return null;
            }
            C1276a<K, V> aVar = aVarArr[i];
            if (aVar != null) {
                for (C1276a<K, V> aVar2 = aVar; aVar2 != null; aVar2 = aVar2.f3035d) {
                    K k = aVar.f3033b;
                    if (k instanceof Class) {
                        Class cls = (Class) k;
                        if (cls.getName().equals(str)) {
                            return cls;
                        }
                    }
                }
                continue;
            }
            i++;
        }
    }

    /* renamed from: a */
    public boolean mo11514a(K k, V v) {
        int identityHashCode = System.identityHashCode(k);
        int i = this.f3031b & identityHashCode;
        for (C1276a<K, V> aVar = this.f3030a[i]; aVar != null; aVar = aVar.f3035d) {
            if (k == aVar.f3033b) {
                aVar.f3034c = v;
                return true;
            }
        }
        this.f3030a[i] = new C1276a<>(k, v, identityHashCode, this.f3030a[i]);
        return false;
    }
}
