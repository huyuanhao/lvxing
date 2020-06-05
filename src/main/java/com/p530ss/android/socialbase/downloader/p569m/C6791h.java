package com.p530ss.android.socialbase.downloader.p569m;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* compiled from: LruCache */
/* renamed from: com.ss.android.socialbase.downloader.m.h */
public class C6791h<K, T> extends LinkedHashMap<K, T> {
    /* renamed from: a */
    private int f22433a;

    public C6791h() {
        this(4, 4);
    }

    public C6791h(int i, int i2) {
        super(i, 0.75f, true);
        mo32615a(i2);
    }

    /* renamed from: a */
    public void mo32615a(int i) {
        this.f22433a = i;
    }

    /* access modifiers changed from: protected */
    public boolean removeEldestEntry(Entry<K, T> entry) {
        return size() > this.f22433a;
    }
}
