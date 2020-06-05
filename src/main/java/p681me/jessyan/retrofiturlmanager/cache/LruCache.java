package p681me.jessyan.retrofiturlmanager.cache;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: me.jessyan.retrofiturlmanager.cache.LruCache */
public class LruCache<K, V> implements Cache<K, V> {
    private final LinkedHashMap<K, V> cache = new LinkedHashMap<>(100, 0.75f, true);
    private int currentSize = 0;
    private final int initialMaxSize;
    private int maxSize;

    /* access modifiers changed from: protected */
    public int getItemSize(V v) {
        return 1;
    }

    /* access modifiers changed from: protected */
    public void onItemEvicted(K k, V v) {
    }

    public LruCache(int i) {
        this.initialMaxSize = i;
        this.maxSize = i;
    }

    public synchronized void setSizeMultiplier(float f) {
        if (f >= 0.0f) {
            this.maxSize = Math.round(((float) this.initialMaxSize) * f);
            evict();
        } else {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
    }

    public synchronized int getMaxSize() {
        return this.maxSize;
    }

    public synchronized int size() {
        return this.currentSize;
    }

    public synchronized boolean containsKey(K k) {
        return this.cache.containsKey(k);
    }

    public synchronized Set<K> keySet() {
        return this.cache.keySet();
    }

    public synchronized V get(K k) {
        return this.cache.get(k);
    }

    public synchronized V put(K k, V v) {
        if (getItemSize(v) >= this.maxSize) {
            onItemEvicted(k, v);
            return null;
        }
        V put = this.cache.put(k, v);
        if (v != null) {
            this.currentSize += getItemSize(v);
        }
        if (put != null) {
            this.currentSize -= getItemSize(put);
        }
        evict();
        return put;
    }

    public synchronized V remove(K k) {
        V remove;
        remove = this.cache.remove(k);
        if (remove != null) {
            this.currentSize -= getItemSize(remove);
        }
        return remove;
    }

    public void clear() {
        trimToSize(0);
    }

    /* access modifiers changed from: protected|declared_synchronized */
    public synchronized void trimToSize(int i) {
        while (this.currentSize > i) {
            Entry entry = (Entry) this.cache.entrySet().iterator().next();
            Object value = entry.getValue();
            this.currentSize -= getItemSize(value);
            Object key = entry.getKey();
            this.cache.remove(key);
            onItemEvicted(key, value);
        }
    }

    private void evict() {
        trimToSize(this.maxSize);
    }
}
