package p655io.reactivex.internal.util;

/* renamed from: io.reactivex.internal.util.f */
public final class OpenHashSet<T> {
    /* renamed from: a */
    final float f27692a;
    /* renamed from: b */
    int f27693b;
    /* renamed from: c */
    int f27694c;
    /* renamed from: d */
    int f27695d;
    /* renamed from: e */
    T[] f27696e;

    /* renamed from: a */
    static int m35188a(int i) {
        int i2 = i * -1640531527;
        return i2 ^ (i2 >>> 16);
    }

    public OpenHashSet() {
        this(16, 0.75f);
    }

    public OpenHashSet(int i, float f) {
        this.f27692a = f;
        int a = Pow2.m35194a(i);
        this.f27693b = a - 1;
        this.f27695d = (int) (f * ((float) a));
        this.f27696e = (Object[]) new Object[a];
    }

    /* renamed from: a */
    public boolean mo39152a(T t) {
        int i;
        T t2;
        T[] tArr = this.f27696e;
        int i2 = this.f27693b;
        int a = m35188a(t.hashCode()) & i2;
        T t3 = tArr[a];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                a = (a + 1) & i2;
                t2 = tArr[a];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[i] = t;
        int i3 = this.f27694c + 1;
        this.f27694c = i3;
        if (i3 >= this.f27695d) {
            mo39150a();
        }
        return true;
    }

    /* renamed from: b */
    public boolean mo39153b(T t) {
        T t2;
        T[] tArr = this.f27696e;
        int i = this.f27693b;
        int a = m35188a(t.hashCode()) & i;
        T t3 = tArr[a];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return mo39151a(a, tArr, i);
        }
        do {
            a = (a + 1) & i;
            t2 = tArr[a];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return mo39151a(a, tArr, i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo39151a(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.f27694c--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t == null) {
                    tArr[i] = null;
                    return true;
                }
                int a = m35188a(t.hashCode()) & i2;
                if (i <= i3) {
                    if (i >= a || a > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else {
                    if (i >= a && a > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo39150a() {
        int i;
        T[] tArr = this.f27696e;
        int length = tArr.length;
        int i2 = length << 1;
        int i3 = i2 - 1;
        T[] tArr2 = (Object[]) new Object[i2];
        int i4 = this.f27694c;
        while (true) {
            int i5 = i4 - 1;
            if (i4 != 0) {
                while (true) {
                    length--;
                    if (tArr[length] != null) {
                        break;
                    }
                }
                int a = m35188a(tArr[length].hashCode()) & i3;
                if (tArr2[a] != null) {
                    do {
                        a = (i + 1) & i3;
                    } while (tArr2[a] != null);
                }
                tArr2[a] = tArr[length];
                i4 = i5;
            } else {
                this.f27693b = i3;
                this.f27695d = (int) (((float) i2) * this.f27692a);
                this.f27696e = tArr2;
                return;
            }
        }
    }

    /* renamed from: b */
    public Object[] mo39154b() {
        return this.f27696e;
    }
}
