package com.bumptech.glide.util;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

public final class CachedHashCodeArrayMap<K, V> extends ArrayMap<K, V> {
    /* renamed from: a */
    private int f4893a;

    public void clear() {
        this.f4893a = 0;
        super.clear();
    }

    public V setValueAt(int i, V v) {
        this.f4893a = 0;
        return super.setValueAt(i, v);
    }

    public V put(K k, V v) {
        this.f4893a = 0;
        return super.put(k, v);
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.f4893a = 0;
        super.putAll(simpleArrayMap);
    }

    public V removeAt(int i) {
        this.f4893a = 0;
        return super.removeAt(i);
    }

    public int hashCode() {
        if (this.f4893a == 0) {
            this.f4893a = super.hashCode();
        }
        return this.f4893a;
    }
}
