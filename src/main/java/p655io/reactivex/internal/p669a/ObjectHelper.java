package p655io.reactivex.internal.p669a;

import p655io.reactivex.p664d.BiPredicate;

/* renamed from: io.reactivex.internal.a.b */
public final class ObjectHelper {
    /* renamed from: a */
    static final BiPredicate<Object, Object> f27483a = new C8116a();

    /* compiled from: ObjectHelper */
    /* renamed from: io.reactivex.internal.a.b$a */
    static final class C8116a implements BiPredicate<Object, Object> {
        C8116a() {
        }
    }

    /* renamed from: a */
    public static int m35045a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    /* renamed from: a */
    public static int m35047a(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    /* renamed from: a */
    public static <T> T m35048a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: a */
    public static boolean m35049a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static int m35046a(int i, String str) {
        if (i > 0) {
            return i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" > 0 required but it was ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }
}
