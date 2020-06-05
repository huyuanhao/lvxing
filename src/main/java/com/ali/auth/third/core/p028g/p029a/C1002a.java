package com.ali.auth.third.core.p028g.p029a;

import com.ali.auth.third.core.p028g.C1001a;
import com.ali.auth.third.core.p028g.C1005b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: com.ali.auth.third.core.g.a.a */
public class C1002a implements C1005b {
    /* renamed from: a */
    private Map<Class<?>, List<C1004b>> f1953a = new HashMap();
    /* renamed from: b */
    private Map<C1001a, C1004b> f1954b = new HashMap();
    /* renamed from: c */
    private ReadWriteLock f1955c = new ReentrantReadWriteLock();

    /* renamed from: com.ali.auth.third.core.g.a.a$a */
    static class C1003a implements C1001a {
        /* renamed from: a */
        private final String f1956a = UUID.randomUUID().toString();
        /* renamed from: b */
        private C1005b f1957b;
        /* renamed from: c */
        private Map<String, String> f1958c;

        public C1003a(C1005b bVar, Map<String, String> map) {
            this.f1957b = bVar;
            this.f1958c = map;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f1956a.equals(((C1003a) obj).f1956a);
        }

        public int hashCode() {
            String str = this.f1956a;
            return 31 + (str == null ? 0 : str.hashCode());
        }
    }

    /* renamed from: com.ali.auth.third.core.g.a.a$b */
    static class C1004b {
        /* renamed from: a */
        public Class<?>[] f1959a;
        /* renamed from: b */
        public Object f1960b;
        /* renamed from: c */
        public Map<String, String> f1961c;

        C1004b() {
        }
    }

    /* renamed from: a */
    public C1001a mo10324a(Class<?>[] clsArr, Object obj, Map<String, String> map) {
        if (clsArr == null || clsArr.length == 0 || obj == null) {
            throw new IllegalArgumentException("service types and instance must not be null");
        }
        C1004b bVar = new C1004b();
        bVar.f1960b = obj;
        bVar.f1959a = clsArr;
        bVar.f1961c = Collections.synchronizedMap(new HashMap());
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                if (entry.getKey() != null) {
                    if (entry.getValue() != null) {
                        bVar.f1961c.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        this.f1955c.writeLock().lock();
        try {
            for (Class<?> cls : clsArr) {
                List list = (List) this.f1953a.get(cls);
                if (list == null) {
                    list = new ArrayList(2);
                    this.f1953a.put(cls, list);
                }
                list.add(bVar);
            }
            C1003a aVar = new C1003a(this, bVar.f1961c);
            this.f1954b.put(aVar, bVar);
            return aVar;
        } finally {
            this.f1955c.writeLock().unlock();
        }
    }

    /* renamed from: a */
    public <T> T mo10325a(Class<T> cls, Map<String, String> map) {
        Object obj;
        this.f1955c.readLock().lock();
        try {
            List<C1004b> list = (List) this.f1953a.get(cls);
            if (list != null) {
                if (list.size() != 0) {
                    if (map != null) {
                        if (map.size() != 0) {
                            for (C1004b bVar : list) {
                                boolean z = true;
                                Iterator it = map.entrySet().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    Entry entry = (Entry) it.next();
                                    String str = (String) bVar.f1961c.get(entry.getKey());
                                    if (str != null) {
                                        if (!str.equals(entry.getValue())) {
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                                z = false;
                                continue;
                                if (z) {
                                    obj = bVar.f1960b;
                                    T cast = cls.cast(obj);
                                    this.f1955c.readLock().unlock();
                                    return cast;
                                }
                            }
                        }
                    }
                    obj = ((C1004b) list.get(0)).f1960b;
                    T cast2 = cls.cast(obj);
                    this.f1955c.readLock().unlock();
                    return cast2;
                }
            }
            return null;
        } finally {
            this.f1955c.readLock().unlock();
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:35:0x00c0=Splitter:B:35:0x00c0, B:28:0x0093=Splitter:B:28:0x0093} */
    /* renamed from: b */
    public <T> T[] mo10326b(java.lang.Class<T> r9, java.util.Map<java.lang.String, java.lang.String> r10) {
        /*
        r8 = this;
        java.util.concurrent.locks.ReadWriteLock r0 = r8.f1955c
        java.util.concurrent.locks.Lock r0 = r0.readLock()
        r0.lock()
        java.util.Map<java.lang.Class<?>, java.util.List<com.ali.auth.third.core.g.a.a$b>> r0 = r8.f1953a     // Catch:{ all -> 0x00c9 }
        java.lang.Object r0 = r0.get(r9)     // Catch:{ all -> 0x00c9 }
        java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x00c9 }
        r1 = 0
        if (r0 == 0) goto L_0x00c0
        int r2 = r0.size()     // Catch:{ all -> 0x00c9 }
        if (r2 != 0) goto L_0x001c
        goto L_0x00c0
    L_0x001c:
        if (r10 == 0) goto L_0x0093
        int r2 = r10.size()     // Catch:{ all -> 0x00c9 }
        if (r2 != 0) goto L_0x0025
        goto L_0x0093
    L_0x0025:
        java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x00c9 }
        int r3 = r0.size()     // Catch:{ all -> 0x00c9 }
        r2.<init>(r3)     // Catch:{ all -> 0x00c9 }
        java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00c9 }
    L_0x0032:
        boolean r3 = r0.hasNext()     // Catch:{ all -> 0x00c9 }
        if (r3 == 0) goto L_0x0079
        java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x00c9 }
        com.ali.auth.third.core.g.a.a$b r3 = (com.ali.auth.third.core.p028g.p029a.C1002a.C1004b) r3     // Catch:{ all -> 0x00c9 }
        java.util.Set r4 = r10.entrySet()     // Catch:{ all -> 0x00c9 }
        java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x00c9 }
    L_0x0046:
        boolean r5 = r4.hasNext()     // Catch:{ all -> 0x00c9 }
        if (r5 == 0) goto L_0x006c
        java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x00c9 }
        java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ all -> 0x00c9 }
        java.util.Map<java.lang.String, java.lang.String> r6 = r3.f1961c     // Catch:{ all -> 0x00c9 }
        java.lang.Object r7 = r5.getKey()     // Catch:{ all -> 0x00c9 }
        java.lang.Object r6 = r6.get(r7)     // Catch:{ all -> 0x00c9 }
        java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x00c9 }
        if (r6 == 0) goto L_0x006a
        java.lang.Object r5 = r5.getValue()     // Catch:{ all -> 0x00c9 }
        boolean r5 = r6.equals(r5)     // Catch:{ all -> 0x00c9 }
        if (r5 != 0) goto L_0x0046
    L_0x006a:
        r4 = 0
        goto L_0x006d
    L_0x006c:
        r4 = 1
    L_0x006d:
        if (r4 == 0) goto L_0x0032
        java.lang.Object r3 = r3.f1960b     // Catch:{ all -> 0x00c9 }
        java.lang.Object r3 = r9.cast(r3)     // Catch:{ all -> 0x00c9 }
        r2.add(r3)     // Catch:{ all -> 0x00c9 }
        goto L_0x0032
    L_0x0079:
        int r10 = r2.size()     // Catch:{ all -> 0x00c9 }
        java.lang.Object r9 = java.lang.reflect.Array.newInstance(r9, r10)     // Catch:{ all -> 0x00c9 }
        java.lang.Object[] r9 = (java.lang.Object[]) r9     // Catch:{ all -> 0x00c9 }
        java.lang.Object[] r9 = (java.lang.Object[]) r9     // Catch:{ all -> 0x00c9 }
        java.lang.Object[] r9 = r2.toArray(r9)     // Catch:{ all -> 0x00c9 }
    L_0x0089:
        java.util.concurrent.locks.ReadWriteLock r10 = r8.f1955c
        java.util.concurrent.locks.Lock r10 = r10.readLock()
        r10.unlock()
        return r9
    L_0x0093:
        int r10 = r0.size()     // Catch:{ all -> 0x00c9 }
        java.lang.Object r10 = java.lang.reflect.Array.newInstance(r9, r10)     // Catch:{ all -> 0x00c9 }
        java.lang.Object[] r10 = (java.lang.Object[]) r10     // Catch:{ all -> 0x00c9 }
        java.lang.Object[] r10 = (java.lang.Object[]) r10     // Catch:{ all -> 0x00c9 }
        int r2 = r0.size()     // Catch:{ all -> 0x00c9 }
    L_0x00a3:
        if (r1 >= r2) goto L_0x00b6
        java.lang.Object r3 = r0.get(r1)     // Catch:{ all -> 0x00c9 }
        com.ali.auth.third.core.g.a.a$b r3 = (com.ali.auth.third.core.p028g.p029a.C1002a.C1004b) r3     // Catch:{ all -> 0x00c9 }
        java.lang.Object r3 = r3.f1960b     // Catch:{ all -> 0x00c9 }
        java.lang.Object r3 = r9.cast(r3)     // Catch:{ all -> 0x00c9 }
        r10[r1] = r3     // Catch:{ all -> 0x00c9 }
        int r1 = r1 + 1
        goto L_0x00a3
    L_0x00b6:
        java.util.concurrent.locks.ReadWriteLock r9 = r8.f1955c
        java.util.concurrent.locks.Lock r9 = r9.readLock()
        r9.unlock()
        return r10
    L_0x00c0:
        java.lang.Object r9 = java.lang.reflect.Array.newInstance(r9, r1)     // Catch:{ all -> 0x00c9 }
        java.lang.Object[] r9 = (java.lang.Object[]) r9     // Catch:{ all -> 0x00c9 }
        java.lang.Object[] r9 = (java.lang.Object[]) r9     // Catch:{ all -> 0x00c9 }
        goto L_0x0089
    L_0x00c9:
        r9 = move-exception
        java.util.concurrent.locks.ReadWriteLock r10 = r8.f1955c
        java.util.concurrent.locks.Lock r10 = r10.readLock()
        r10.unlock()
        throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.auth.third.core.p028g.p029a.C1002a.mo10326b(java.lang.Class, java.util.Map):java.lang.Object[]");
    }
}
