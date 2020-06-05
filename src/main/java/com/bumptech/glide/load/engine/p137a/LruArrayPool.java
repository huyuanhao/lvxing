package com.bumptech.glide.load.engine.p137a;

import android.util.Log;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* renamed from: com.bumptech.glide.load.engine.a.j */
public final class LruArrayPool implements ArrayPool {
    /* renamed from: a */
    private final GroupedLinkedMap<C1641a, Object> f4461a;
    /* renamed from: b */
    private final C1642b f4462b;
    /* renamed from: c */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f4463c;
    /* renamed from: d */
    private final Map<Class<?>, ArrayAdapterInterface<?>> f4464d;
    /* renamed from: e */
    private final int f4465e;
    /* renamed from: f */
    private int f4466f;

    /* compiled from: LruArrayPool */
    /* renamed from: com.bumptech.glide.load.engine.a.j$a */
    private static final class C1641a implements Poolable {
        /* renamed from: a */
        int f4467a;
        /* renamed from: b */
        private final C1642b f4468b;
        /* renamed from: c */
        private Class<?> f4469c;

        C1641a(C1642b bVar) {
            this.f4468b = bVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo12742a(int i, Class<?> cls) {
            this.f4467a = i;
            this.f4469c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1641a)) {
                return false;
            }
            C1641a aVar = (C1641a) obj;
            if (this.f4467a == aVar.f4467a && this.f4469c == aVar.f4469c) {
                return true;
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Key{size=");
            sb.append(this.f4467a);
            sb.append("array=");
            sb.append(this.f4469c);
            sb.append('}');
            return sb.toString();
        }

        /* renamed from: a */
        public void mo12714a() {
            this.f4468b.mo12722a(this);
        }

        public int hashCode() {
            int i = this.f4467a * 31;
            Class<?> cls = this.f4469c;
            return i + (cls != null ? cls.hashCode() : 0);
        }
    }

    /* compiled from: LruArrayPool */
    /* renamed from: com.bumptech.glide.load.engine.a.j$b */
    private static final class C1642b extends BaseKeyPool<C1641a> {
        C1642b() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C1641a mo12747a(int i, Class<?> cls) {
            C1641a aVar = (C1641a) mo12723c();
            aVar.mo12742a(i, cls);
            return aVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C1641a mo12721b() {
            return new C1641a(this);
        }
    }

    public LruArrayPool() {
        this.f4461a = new GroupedLinkedMap<>();
        this.f4462b = new C1642b();
        this.f4463c = new HashMap();
        this.f4464d = new HashMap();
        this.f4465e = 4194304;
    }

    public LruArrayPool(int i) {
        this.f4461a = new GroupedLinkedMap<>();
        this.f4462b = new C1642b();
        this.f4463c = new HashMap();
        this.f4464d = new HashMap();
        this.f4465e = i;
    }

    /* renamed from: a */
    public synchronized <T> void mo12705a(T t) {
        Class cls = t.getClass();
        ArrayAdapterInterface b = m5450b(cls);
        int a = b.mo12698a(t);
        int b2 = b.mo12701b() * a;
        if (m5453b(b2)) {
            C1641a a2 = this.f4462b.mo12747a(a, cls);
            this.f4461a.mo12735a(a2, t);
            NavigableMap a3 = m5448a(cls);
            Integer num = (Integer) a3.get(Integer.valueOf(a2.f4467a));
            Integer valueOf = Integer.valueOf(a2.f4467a);
            int i = 1;
            if (num != null) {
                i = 1 + num.intValue();
            }
            a3.put(valueOf, Integer.valueOf(i));
            this.f4466f += b2;
            m5454c();
        }
    }

    /* renamed from: b */
    public synchronized <T> T mo12706b(int i, Class<T> cls) {
        return m5447a(this.f4462b.mo12747a(i, cls), cls);
    }

    /* renamed from: a */
    public synchronized <T> T mo12702a(int i, Class<T> cls) {
        C1641a aVar;
        Integer num = (Integer) m5448a(cls).ceilingKey(Integer.valueOf(i));
        if (m5449a(i, num)) {
            aVar = this.f4462b.mo12747a(num.intValue(), cls);
        } else {
            aVar = this.f4462b.mo12747a(i, cls);
        }
        return m5447a(aVar, cls);
    }

    /* renamed from: a */
    private <T> T m5447a(C1641a aVar, Class<T> cls) {
        ArrayAdapterInterface b = m5450b(cls);
        T a = m5446a(aVar);
        if (a != null) {
            this.f4466f -= b.mo12698a(a) * b.mo12701b();
            m5456c(b.mo12698a(a), cls);
        }
        if (a != null) {
            return a;
        }
        if (Log.isLoggable(b.mo12700a(), 2)) {
            String a2 = b.mo12700a();
            StringBuilder sb = new StringBuilder();
            sb.append("Allocated ");
            sb.append(aVar.f4467a);
            sb.append(" bytes");
            Log.v(a2, sb.toString());
        }
        return b.mo12699a(aVar.f4467a);
    }

    /* renamed from: a */
    private <T> T m5446a(C1641a aVar) {
        return this.f4461a.mo12734a(aVar);
    }

    /* renamed from: b */
    private boolean m5453b(int i) {
        return i <= this.f4465e / 2;
    }

    /* renamed from: a */
    private boolean m5449a(int i, Integer num) {
        return num != null && (m5452b() || num.intValue() <= i * 8);
    }

    /* renamed from: b */
    private boolean m5452b() {
        int i = this.f4466f;
        return i == 0 || this.f4465e / i >= 2;
    }

    /* renamed from: a */
    public synchronized void mo12703a() {
        m5455c(0);
    }

    /* renamed from: a */
    public synchronized void mo12704a(int i) {
        if (i >= 40) {
            try {
                mo12703a();
            } catch (Throwable th) {
                throw th;
            }
        } else if (i >= 20 || i == 15) {
            m5455c(this.f4465e / 2);
        }
    }

    /* renamed from: c */
    private void m5454c() {
        m5455c(this.f4465e);
    }

    /* renamed from: c */
    private void m5455c(int i) {
        while (this.f4466f > i) {
            Object a = this.f4461a.mo12733a();
            Preconditions.m6138a(a);
            ArrayAdapterInterface b = m5451b((T) a);
            this.f4466f -= b.mo12698a(a) * b.mo12701b();
            m5456c(b.mo12698a(a), a.getClass());
            if (Log.isLoggable(b.mo12700a(), 2)) {
                String a2 = b.mo12700a();
                StringBuilder sb = new StringBuilder();
                sb.append("evicted: ");
                sb.append(b.mo12698a(a));
                Log.v(a2, sb.toString());
            }
        }
    }

    /* renamed from: c */
    private void m5456c(int i, Class<?> cls) {
        NavigableMap a = m5448a(cls);
        Integer num = (Integer) a.get(Integer.valueOf(i));
        if (num == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Tried to decrement empty size, size: ");
            sb.append(i);
            sb.append(", this: ");
            sb.append(this);
            throw new NullPointerException(sb.toString());
        } else if (num.intValue() == 1) {
            a.remove(Integer.valueOf(i));
        } else {
            a.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
        }
    }

    /* renamed from: a */
    private NavigableMap<Integer, Integer> m5448a(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = (NavigableMap) this.f4463c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f4463c.put(cls, treeMap);
        return treeMap;
    }

    /* renamed from: b */
    private <T> ArrayAdapterInterface<T> m5451b(T t) {
        return m5450b(t.getClass());
    }

    /* renamed from: b */
    private <T> ArrayAdapterInterface<T> m5450b(Class<T> cls) {
        ArrayAdapterInterface<T> aVar = (ArrayAdapterInterface) this.f4464d.get(cls);
        if (aVar == null) {
            if (cls.equals(int[].class)) {
                aVar = new IntegerArrayAdapter<>();
            } else if (cls.equals(byte[].class)) {
                aVar = new ByteArrayAdapter<>();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("No array pool found for: ");
                sb.append(cls.getSimpleName());
                throw new IllegalArgumentException(sb.toString());
            }
            this.f4464d.put(cls, aVar);
        }
        return aVar;
    }
}
