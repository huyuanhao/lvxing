package com.alibaba.fastjson.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

public class AntiCollisionHashMap<K, V> extends AbstractMap<K, V> implements Serializable, Cloneable, Map<K, V> {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int KEY = 16777619;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int M_MASK = -2023358765;
    static final int SEED = -2128831035;
    private static final long serialVersionUID = 362498820763181265L;
    private transient Set<Entry<K, V>> entrySet;
    volatile transient Set<K> keySet;
    final float loadFactor;
    volatile transient int modCount;
    final int random;
    transient int size;
    transient C1266a<K, V>[] table;
    int threshold;
    volatile transient Collection<V> values;

    /* renamed from: com.alibaba.fastjson.util.AntiCollisionHashMap$a */
    static class C1266a<K, V> implements Entry<K, V> {
        /* renamed from: a */
        final K f2973a;
        /* renamed from: b */
        V f2974b;
        /* renamed from: c */
        C1266a<K, V> f2975c;
        /* renamed from: d */
        final int f2976d;

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo11466a(AntiCollisionHashMap<K, V> antiCollisionHashMap) {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo11467b(AntiCollisionHashMap<K, V> antiCollisionHashMap) {
        }

        C1266a(int i, K k, V v, C1266a<K, V> aVar) {
            this.f2974b = v;
            this.f2975c = aVar;
            this.f2973a = k;
            this.f2976d = i;
        }

        public final K getKey() {
            return this.f2973a;
        }

        public final V getValue() {
            return this.f2974b;
        }

        public final V setValue(V v) {
            V v2 = this.f2974b;
            this.f2974b = v;
            return v2;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            Object key = getKey();
            Object key2 = entry.getKey();
            if (key == key2 || (key != null && key.equals(key2))) {
                Object value = getValue();
                Object value2 = entry.getValue();
                if (value == value2 || (value != null && value.equals(value2))) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            K k = this.f2973a;
            int i = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f2974b;
            if (v != null) {
                i = v.hashCode();
            }
            return hashCode ^ i;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append("=");
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* renamed from: com.alibaba.fastjson.util.AntiCollisionHashMap$b */
    private final class C1267b extends C1269d<Entry<K, V>> {
        private C1267b() {
            super();
        }

        /* renamed from: a */
        public Entry<K, V> next() {
            return mo11481b();
        }
    }

    /* renamed from: com.alibaba.fastjson.util.AntiCollisionHashMap$c */
    private final class C1268c extends AbstractSet<Entry<K, V>> {
        private C1268c() {
        }

        public Iterator<Entry<K, V>> iterator() {
            return AntiCollisionHashMap.this.newEntryIterator();
        }

        public boolean contains(Object obj) {
            boolean z = false;
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            C1266a entry2 = AntiCollisionHashMap.this.getEntry(entry.getKey());
            if (entry2 != null && entry2.equals(entry)) {
                z = true;
            }
            return z;
        }

        public boolean remove(Object obj) {
            return AntiCollisionHashMap.this.removeMapping(obj) != null;
        }

        public int size() {
            return AntiCollisionHashMap.this.size;
        }

        public void clear() {
            AntiCollisionHashMap.this.clear();
        }
    }

    /* renamed from: com.alibaba.fastjson.util.AntiCollisionHashMap$d */
    private abstract class C1269d<E> implements Iterator<E> {
        /* renamed from: b */
        C1266a<K, V> f2979b;
        /* renamed from: c */
        int f2980c;
        /* renamed from: d */
        int f2981d;
        /* renamed from: e */
        C1266a<K, V> f2982e;

        C1269d() {
            this.f2980c = AntiCollisionHashMap.this.modCount;
            if (AntiCollisionHashMap.this.size > 0) {
                C1266a<K, V>[] aVarArr = AntiCollisionHashMap.this.table;
                while (true) {
                    int i = this.f2981d;
                    if (i < aVarArr.length) {
                        this.f2981d = i + 1;
                        C1266a<K, V> aVar = aVarArr[i];
                        this.f2979b = aVar;
                        if (aVar != null) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public final boolean hasNext() {
            return this.f2979b != null;
        }

        /* access modifiers changed from: final */
        /* renamed from: b */
        public final C1266a<K, V> mo11481b() {
            if (AntiCollisionHashMap.this.modCount == this.f2980c) {
                C1266a<K, V> aVar = this.f2979b;
                if (aVar != null) {
                    C1266a<K, V> aVar2 = aVar.f2975c;
                    this.f2979b = aVar2;
                    if (aVar2 == null) {
                        C1266a<K, V>[] aVarArr = AntiCollisionHashMap.this.table;
                        while (true) {
                            int i = this.f2981d;
                            if (i >= aVarArr.length) {
                                break;
                            }
                            this.f2981d = i + 1;
                            C1266a<K, V> aVar3 = aVarArr[i];
                            this.f2979b = aVar3;
                            if (aVar3 != null) {
                                break;
                            }
                        }
                    }
                    this.f2982e = aVar;
                    return aVar;
                }
                throw new NoSuchElementException();
            }
            throw new ConcurrentModificationException();
        }

        public void remove() {
            if (this.f2982e == null) {
                throw new IllegalStateException();
            } else if (AntiCollisionHashMap.this.modCount == this.f2980c) {
                K k = this.f2982e.f2973a;
                this.f2982e = null;
                AntiCollisionHashMap.this.removeEntryForKey(k);
                this.f2980c = AntiCollisionHashMap.this.modCount;
            } else {
                throw new ConcurrentModificationException();
            }
        }
    }

    /* renamed from: com.alibaba.fastjson.util.AntiCollisionHashMap$e */
    private final class C1270e extends C1269d<K> {
        private C1270e() {
            super();
        }

        public K next() {
            return mo11481b().getKey();
        }
    }

    /* renamed from: com.alibaba.fastjson.util.AntiCollisionHashMap$f */
    private final class C1271f extends AbstractSet<K> {
        private C1271f() {
        }

        public Iterator<K> iterator() {
            return AntiCollisionHashMap.this.newKeyIterator();
        }

        public int size() {
            return AntiCollisionHashMap.this.size;
        }

        public boolean contains(Object obj) {
            return AntiCollisionHashMap.this.containsKey(obj);
        }

        public boolean remove(Object obj) {
            return AntiCollisionHashMap.this.removeEntryForKey(obj) != null;
        }

        public void clear() {
            AntiCollisionHashMap.this.clear();
        }
    }

    /* renamed from: com.alibaba.fastjson.util.AntiCollisionHashMap$g */
    private final class C1272g extends C1269d<V> {
        private C1272g() {
            super();
        }

        public V next() {
            return mo11481b().f2974b;
        }
    }

    /* renamed from: com.alibaba.fastjson.util.AntiCollisionHashMap$h */
    private final class C1273h extends AbstractCollection<V> {
        private C1273h() {
        }

        public Iterator<V> iterator() {
            return AntiCollisionHashMap.this.newValueIterator();
        }

        public int size() {
            return AntiCollisionHashMap.this.size;
        }

        public boolean contains(Object obj) {
            return AntiCollisionHashMap.this.containsValue(obj);
        }

        public void clear() {
            AntiCollisionHashMap.this.clear();
        }
    }

    static int hash(int i) {
        int i2 = i * i;
        int i3 = i2 ^ ((i2 >>> 20) ^ (i2 >>> 12));
        return (i3 >>> 4) ^ ((i3 >>> 7) ^ i3);
    }

    static int indexFor(int i, int i2) {
        return i & (i2 - 1);
    }

    /* access modifiers changed from: 0000 */
    public void init() {
    }

    private int hashString(String str) {
        int i = this.random * SEED;
        for (int i2 = 0; i2 < str.length(); i2++) {
            i = (i * KEY) ^ str.charAt(i2);
        }
        return ((i >> 1) ^ i) & M_MASK;
    }

    public AntiCollisionHashMap(int i, float f) {
        this.keySet = null;
        this.values = null;
        this.random = new Random().nextInt(99999);
        this.entrySet = null;
        if (i >= 0) {
            if (i > MAXIMUM_CAPACITY) {
                i = MAXIMUM_CAPACITY;
            }
            if (f <= 0.0f || Float.isNaN(f)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Illegal load factor: ");
                sb.append(f);
                throw new IllegalArgumentException(sb.toString());
            }
            int i2 = 1;
            while (i2 < i) {
                i2 <<= 1;
            }
            this.loadFactor = f;
            this.threshold = (int) (((float) i2) * f);
            this.table = new C1266a[i2];
            init();
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Illegal initial capacity: ");
        sb2.append(i);
        throw new IllegalArgumentException(sb2.toString());
    }

    public AntiCollisionHashMap(int i) {
        this(i, DEFAULT_LOAD_FACTOR);
    }

    public AntiCollisionHashMap() {
        this.keySet = null;
        this.values = null;
        this.random = new Random().nextInt(99999);
        this.entrySet = null;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.threshold = 12;
        this.table = new C1266a[16];
        init();
    }

    public AntiCollisionHashMap(Map<? extends K, ? extends V> map) {
        this(Math.max(((int) (((float) map.size()) / DEFAULT_LOAD_FACTOR)) + 1, 16), DEFAULT_LOAD_FACTOR);
        putAllForCreate(map);
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public V get(Object obj) {
        int i;
        if (obj == null) {
            return getForNullKey();
        }
        if (obj instanceof String) {
            i = hash(hashString((String) obj));
        } else {
            i = hash(obj.hashCode());
        }
        C1266a<K, V>[] aVarArr = this.table;
        for (C1266a<K, V> aVar = aVarArr[indexFor(i, aVarArr.length)]; aVar != null; aVar = aVar.f2975c) {
            if (aVar.f2976d == i) {
                K k = aVar.f2973a;
                if (k == obj || obj.equals(k)) {
                    return aVar.f2974b;
                }
            }
        }
        return null;
    }

    private V getForNullKey() {
        for (C1266a<K, V> aVar = this.table[0]; aVar != null; aVar = aVar.f2975c) {
            if (aVar.f2973a == null) {
                return aVar.f2974b;
            }
        }
        return null;
    }

    public boolean containsKey(Object obj) {
        return getEntry(obj) != null;
    }

    /* access modifiers changed from: final */
    public final C1266a<K, V> getEntry(Object obj) {
        int i;
        if (obj == null) {
            i = 0;
        } else if (obj instanceof String) {
            i = hash(hashString((String) obj));
        } else {
            i = hash(obj.hashCode());
        }
        C1266a<K, V>[] aVarArr = this.table;
        for (C1266a<K, V> aVar = aVarArr[indexFor(i, aVarArr.length)]; aVar != null; aVar = aVar.f2975c) {
            if (aVar.f2976d == i) {
                K k = aVar.f2973a;
                if (k == obj || (obj != null && obj.equals(k))) {
                    return aVar;
                }
            }
        }
        return null;
    }

    public V put(K k, V v) {
        int i;
        if (k == null) {
            return putForNullKey(v);
        }
        if (k instanceof String) {
            i = hash(hashString((String) k));
        } else {
            i = hash(k.hashCode());
        }
        int indexFor = indexFor(i, this.table.length);
        for (C1266a<K, V> aVar = this.table[indexFor]; aVar != null; aVar = aVar.f2975c) {
            if (aVar.f2976d == i) {
                K k2 = aVar.f2973a;
                if (k2 == k || k.equals(k2)) {
                    V v2 = aVar.f2974b;
                    aVar.f2974b = v;
                    aVar.mo11466a(this);
                    return v2;
                }
            }
        }
        this.modCount++;
        addEntry(i, k, v, indexFor);
        return null;
    }

    private V putForNullKey(V v) {
        for (C1266a<K, V> aVar = this.table[0]; aVar != null; aVar = aVar.f2975c) {
            if (aVar.f2973a == null) {
                V v2 = aVar.f2974b;
                aVar.f2974b = v;
                aVar.mo11466a(this);
                return v2;
            }
        }
        this.modCount++;
        addEntry(0, null, v, 0);
        return null;
    }

    private void putForCreate(K k, V v) {
        int i;
        if (k == null) {
            i = 0;
        } else if (k instanceof String) {
            i = hash(hashString((String) k));
        } else {
            i = hash(k.hashCode());
        }
        int indexFor = indexFor(i, this.table.length);
        for (C1266a<K, V> aVar = this.table[indexFor]; aVar != null; aVar = aVar.f2975c) {
            if (aVar.f2976d == i) {
                K k2 = aVar.f2973a;
                if (k2 == k || (k != null && k.equals(k2))) {
                    aVar.f2974b = v;
                    return;
                }
            }
        }
        createEntry(i, k, v, indexFor);
    }

    private void putAllForCreate(Map<? extends K, ? extends V> map) {
        for (Entry entry : map.entrySet()) {
            putForCreate(entry.getKey(), entry.getValue());
        }
    }

    /* access modifiers changed from: 0000 */
    public void resize(int i) {
        if (this.table.length == MAXIMUM_CAPACITY) {
            this.threshold = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            return;
        }
        C1266a<K, V>[] aVarArr = new C1266a[i];
        transfer(aVarArr);
        this.table = aVarArr;
        this.threshold = (int) (((float) i) * this.loadFactor);
    }

    /* access modifiers changed from: 0000 */
    public void transfer(C1266a[] aVarArr) {
        C1266a[] aVarArr2 = this.table;
        int length = aVarArr.length;
        for (int i = 0; i < aVarArr2.length; i++) {
            C1266a aVar = aVarArr2[i];
            if (aVar != null) {
                aVarArr2[i] = null;
                while (true) {
                    C1266a<K, V> aVar2 = aVar.f2975c;
                    int indexFor = indexFor(aVar.f2976d, length);
                    aVar.f2975c = aVarArr[indexFor];
                    aVarArr[indexFor] = aVar;
                    if (aVar2 == null) {
                        break;
                    }
                    aVar = aVar2;
                }
            }
        }
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        int size2 = map.size();
        if (size2 != 0) {
            if (size2 > this.threshold) {
                int i = (int) ((((float) size2) / this.loadFactor) + 1.0f);
                if (i > MAXIMUM_CAPACITY) {
                    i = MAXIMUM_CAPACITY;
                }
                int length = this.table.length;
                while (length < i) {
                    length <<= 1;
                }
                if (length > this.table.length) {
                    resize(length);
                }
            }
            for (Entry entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    public V remove(Object obj) {
        C1266a removeEntryForKey = removeEntryForKey(obj);
        if (removeEntryForKey == null) {
            return null;
        }
        return removeEntryForKey.f2974b;
    }

    /* access modifiers changed from: final */
    public final C1266a<K, V> removeEntryForKey(Object obj) {
        int i;
        if (obj == null) {
            i = 0;
        } else if (obj instanceof String) {
            i = hash(hashString((String) obj));
        } else {
            i = hash(obj.hashCode());
        }
        int indexFor = indexFor(i, this.table.length);
        C1266a<K, V> aVar = this.table[indexFor];
        C1266a<K, V> aVar2 = aVar;
        while (aVar != null) {
            C1266a<K, V> aVar3 = aVar.f2975c;
            if (aVar.f2976d == i) {
                K k = aVar.f2973a;
                if (k == obj || (obj != null && obj.equals(k))) {
                    this.modCount++;
                    this.size--;
                    if (aVar2 == aVar) {
                        this.table[indexFor] = aVar3;
                    } else {
                        aVar2.f2975c = aVar3;
                    }
                    aVar.mo11467b(this);
                    return aVar;
                }
            }
            aVar2 = aVar;
            aVar = aVar3;
        }
        return aVar;
    }

    /* access modifiers changed from: final */
    public final C1266a<K, V> removeMapping(Object obj) {
        int i;
        if (!(obj instanceof Entry)) {
            return null;
        }
        Entry entry = (Entry) obj;
        Object key = entry.getKey();
        if (key == null) {
            i = 0;
        } else if (key instanceof String) {
            i = hash(hashString((String) key));
        } else {
            i = hash(key.hashCode());
        }
        int indexFor = indexFor(i, this.table.length);
        C1266a<K, V> aVar = this.table[indexFor];
        C1266a<K, V> aVar2 = aVar;
        while (aVar != null) {
            C1266a<K, V> aVar3 = aVar.f2975c;
            if (aVar.f2976d != i || !aVar.equals(entry)) {
                aVar2 = aVar;
                aVar = aVar3;
            } else {
                this.modCount++;
                this.size--;
                if (aVar2 == aVar) {
                    this.table[indexFor] = aVar3;
                } else {
                    aVar2.f2975c = aVar3;
                }
                aVar.mo11467b(this);
                return aVar;
            }
        }
        return aVar;
    }

    public void clear() {
        this.modCount++;
        C1266a<K, V>[] aVarArr = this.table;
        for (int i = 0; i < aVarArr.length; i++) {
            aVarArr[i] = null;
        }
        this.size = 0;
    }

    public boolean containsValue(Object obj) {
        if (obj == null) {
            return containsNullValue();
        }
        C1266a<K, V>[] aVarArr = this.table;
        for (C1266a<K, V> aVar : aVarArr) {
            for (aVar = aVarArr[r2]; aVar != null; aVar = aVar.f2975c) {
                if (obj.equals(aVar.f2974b)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean containsNullValue() {
        C1266a<K, V>[] aVarArr = this.table;
        for (C1266a<K, V> aVar : aVarArr) {
            for (aVar = aVarArr[r2]; aVar != null; aVar = aVar.f2975c) {
                if (aVar.f2974b == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public Object clone() {
        AntiCollisionHashMap antiCollisionHashMap;
        try {
            antiCollisionHashMap = (AntiCollisionHashMap) super.clone();
        } catch (CloneNotSupportedException unused) {
            antiCollisionHashMap = null;
        }
        antiCollisionHashMap.table = new C1266a[this.table.length];
        antiCollisionHashMap.entrySet = null;
        antiCollisionHashMap.modCount = 0;
        antiCollisionHashMap.size = 0;
        antiCollisionHashMap.init();
        antiCollisionHashMap.putAllForCreate(this);
        return antiCollisionHashMap;
    }

    /* access modifiers changed from: 0000 */
    public void addEntry(int i, K k, V v, int i2) {
        C1266a<K, V>[] aVarArr = this.table;
        aVarArr[i2] = new C1266a<>(i, k, v, aVarArr[i2]);
        int i3 = this.size;
        this.size = i3 + 1;
        if (i3 >= this.threshold) {
            resize(this.table.length * 2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void createEntry(int i, K k, V v, int i2) {
        C1266a<K, V>[] aVarArr = this.table;
        aVarArr[i2] = new C1266a<>(i, k, v, aVarArr[i2]);
        this.size++;
    }

    /* access modifiers changed from: 0000 */
    public Iterator<K> newKeyIterator() {
        return new C1270e();
    }

    /* access modifiers changed from: 0000 */
    public Iterator<V> newValueIterator() {
        return new C1272g();
    }

    /* access modifiers changed from: 0000 */
    public Iterator<Entry<K, V>> newEntryIterator() {
        return new C1267b();
    }

    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        C1271f fVar = new C1271f();
        this.keySet = fVar;
        return fVar;
    }

    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        C1273h hVar = new C1273h();
        this.values = hVar;
        return hVar;
    }

    public Set<Entry<K, V>> entrySet() {
        return entrySet0();
    }

    private Set<Entry<K, V>> entrySet0() {
        Set<Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        C1268c cVar = new C1268c();
        this.entrySet = cVar;
        return cVar;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Iterator it = this.size > 0 ? entrySet0().iterator() : null;
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.table.length);
        objectOutputStream.writeInt(this.size);
        if (it != null) {
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.table = new C1266a[objectInputStream.readInt()];
        init();
        int readInt = objectInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            putForCreate(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* access modifiers changed from: 0000 */
    public int capacity() {
        return this.table.length;
    }

    /* access modifiers changed from: 0000 */
    public float loadFactor() {
        return this.loadFactor;
    }
}
