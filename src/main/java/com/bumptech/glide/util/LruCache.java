package com.bumptech.glide.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.bumptech.glide.util.f */
public class LruCache<T, Y> {
    /* renamed from: a */
    private final Map<T, Y> f4914a = new LinkedHashMap(100, 0.75f, true);
    /* renamed from: b */
    private final long f4915b;
    /* renamed from: c */
    private long f4916c;
    /* renamed from: d */
    private long f4917d;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo12794a(Y y) {
        return 1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo12799a(T t, Y y) {
    }

    public LruCache(long j) {
        this.f4915b = j;
        this.f4916c = j;
    }

    /* renamed from: b */
    public synchronized long mo13228b() {
        return this.f4916c;
    }

    /* renamed from: b */
    public synchronized Y mo13229b(T t) {
        return this.f4914a.get(t);
    }

    /* renamed from: b */
    public synchronized Y mo13230b(T t, Y y) {
        long a = (long) mo12794a(y);
        if (a >= this.f4916c) {
            mo12799a(t, y);
            return null;
        }
        if (y != null) {
            this.f4917d += a;
        }
        Y put = this.f4914a.put(t, y);
        if (put != null) {
            this.f4917d -= (long) mo12794a(put);
            if (!put.equals(y)) {
                mo12799a(t, put);
            }
        }
        m6126c();
        return put;
    }

    /* renamed from: c */
    public synchronized Y mo13231c(T t) {
        Y remove;
        remove = this.f4914a.remove(t);
        if (remove != null) {
            this.f4917d -= (long) mo12794a(remove);
        }
        return remove;
    }

    /* renamed from: a */
    public void mo13226a() {
        mo13227a(0);
    }

    /* access modifiers changed from: protected|declared_synchronized */
    /* renamed from: a */
    public synchronized void mo13227a(long j) {
        while (this.f4917d > j) {
            Iterator it = this.f4914a.entrySet().iterator();
            Entry entry = (Entry) it.next();
            Object value = entry.getValue();
            this.f4917d -= (long) mo12794a((Y) value);
            Object key = entry.getKey();
            it.remove();
            mo12799a(key, value);
        }
    }

    /* renamed from: c */
    private void m6126c() {
        mo13227a(this.f4916c);
    }
}
