package p655io.reactivex.internal.queue;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p655io.reactivex.internal.p670b.SimplePlainQueue;
import p655io.reactivex.internal.util.Pow2;

/* renamed from: io.reactivex.internal.queue.a */
public final class SpscLinkedArrayQueue<T> implements SimplePlainQueue<T> {
    /* renamed from: a */
    static final int f27607a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    /* renamed from: j */
    private static final Object f27608j = new Object();
    /* renamed from: b */
    final AtomicLong f27609b = new AtomicLong();
    /* renamed from: c */
    int f27610c;
    /* renamed from: d */
    long f27611d;
    /* renamed from: e */
    final int f27612e;
    /* renamed from: f */
    AtomicReferenceArray<Object> f27613f;
    /* renamed from: g */
    final int f27614g;
    /* renamed from: h */
    AtomicReferenceArray<Object> f27615h;
    /* renamed from: i */
    final AtomicLong f27616i = new AtomicLong();

    /* renamed from: b */
    private static int m35114b(int i) {
        return i;
    }

    public SpscLinkedArrayQueue(int i) {
        int a = Pow2.m35194a(Math.max(8, i));
        int i2 = a - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(a + 1);
        this.f27613f = atomicReferenceArray;
        this.f27612e = i2;
        m35108a(a);
        this.f27615h = atomicReferenceArray;
        this.f27614g = i2;
        this.f27611d = (long) (i2 - 1);
        m35109a(0);
    }

    public boolean offer(T t) {
        if (t != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.f27613f;
            long c = m35118c();
            int i = this.f27612e;
            int a = m35104a(c, i);
            if (c < this.f27611d) {
                return m35113a(atomicReferenceArray, t, c, a);
            }
            long j = ((long) this.f27610c) + c;
            if (m35116b(atomicReferenceArray, m35104a(j, i)) == null) {
                this.f27611d = j - 1;
                return m35113a(atomicReferenceArray, t, c, a);
            } else if (m35116b(atomicReferenceArray, m35104a(1 + c, i)) == null) {
                return m35113a(atomicReferenceArray, t, c, a);
            } else {
                m35111a(atomicReferenceArray, c, a, t, (long) i);
                return true;
            }
        } else {
            throw new NullPointerException("Null is not a valid element");
        }
    }

    /* renamed from: a */
    private boolean m35113a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        m35110a(atomicReferenceArray, i, (Object) t);
        m35109a(j + 1);
        return true;
    }

    /* renamed from: a */
    private void m35111a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f27613f = atomicReferenceArray2;
        this.f27611d = (j2 + j) - 1;
        m35110a(atomicReferenceArray2, i, (Object) t);
        m35112a(atomicReferenceArray, atomicReferenceArray2);
        m35110a(atomicReferenceArray, i, f27608j);
        m35109a(j + 1);
    }

    /* renamed from: a */
    private void m35112a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        m35110a(atomicReferenceArray, m35114b(atomicReferenceArray.length() - 1), (Object) atomicReferenceArray2);
    }

    /* renamed from: a */
    private AtomicReferenceArray<Object> m35107a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int b = m35114b(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) m35116b(atomicReferenceArray, b);
        m35110a(atomicReferenceArray, b, (Object) null);
        return atomicReferenceArray2;
    }

    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f27615h;
        long d = m35119d();
        int i = this.f27614g;
        int a = m35104a(d, i);
        T b = m35116b(atomicReferenceArray, a);
        boolean z = b == f27608j;
        if (b != null && !z) {
            m35110a(atomicReferenceArray, a, (Object) null);
            m35117b(d + 1);
            return b;
        } else if (z) {
            return m35106a(m35107a(atomicReferenceArray, i + 1), d, i);
        } else {
            return null;
        }
    }

    /* renamed from: a */
    private T m35106a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.f27615h = atomicReferenceArray;
        int a = m35104a(j, i);
        T b = m35116b(atomicReferenceArray, a);
        if (b != null) {
            m35110a(atomicReferenceArray, a, (Object) null);
            m35117b(j + 1);
        }
        return b;
    }

    public void clear() {
        while (true) {
            if (poll() == null) {
                if (isEmpty()) {
                    return;
                }
            }
        }
    }

    public boolean isEmpty() {
        return m35105a() == m35115b();
    }

    /* renamed from: a */
    private void m35108a(int i) {
        this.f27610c = Math.min(i / 4, f27607a);
    }

    /* renamed from: a */
    private long m35105a() {
        return this.f27609b.get();
    }

    /* renamed from: b */
    private long m35115b() {
        return this.f27616i.get();
    }

    /* renamed from: c */
    private long m35118c() {
        return this.f27609b.get();
    }

    /* renamed from: d */
    private long m35119d() {
        return this.f27616i.get();
    }

    /* renamed from: a */
    private void m35109a(long j) {
        this.f27609b.lazySet(j);
    }

    /* renamed from: b */
    private void m35117b(long j) {
        this.f27616i.lazySet(j);
    }

    /* renamed from: a */
    private static int m35104a(long j, int i) {
        return m35114b(((int) j) & i);
    }

    /* renamed from: a */
    private static void m35110a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    /* renamed from: b */
    private static <E> Object m35116b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }
}
