package kotlin.jvm.internal;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

/* compiled from: Intrinsics */
/* renamed from: kotlin.jvm.internal.i */
public class C8271i {
    /* renamed from: a */
    public static int m35377a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    private C8271i() {
    }

    /* renamed from: a */
    public static void m35380a() {
        throw ((KotlinNullPointerException) m35378a((T) new KotlinNullPointerException()));
    }

    /* renamed from: a */
    public static void m35383a(String str) {
        throw ((UninitializedPropertyAccessException) m35378a((T) new UninitializedPropertyAccessException(str)));
    }

    /* renamed from: b */
    public static void m35387b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("lateinit property ");
        sb.append(str);
        sb.append(" has not been initialized");
        m35383a(sb.toString());
    }

    /* renamed from: a */
    public static void m35382a(Object obj, String str) {
        if (obj == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" must not be null");
            throw ((IllegalStateException) m35378a((T) new IllegalStateException(sb.toString())));
        }
    }

    /* renamed from: b */
    public static void m35386b(Object obj, String str) {
        if (obj == null) {
            m35389d(str);
        }
    }

    /* renamed from: d */
    private static void m35389d(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        StringBuilder sb = new StringBuilder();
        sb.append("Parameter specified as non-null is null: method ");
        sb.append(className);
        sb.append(".");
        sb.append(methodName);
        sb.append(", parameter ");
        sb.append(str);
        throw ((IllegalArgumentException) m35378a((T) new IllegalArgumentException(sb.toString())));
    }

    /* renamed from: a */
    public static boolean m35384a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* renamed from: b */
    public static void m35385b() {
        m35388c("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    /* renamed from: c */
    public static void m35388c(String str) {
        throw new UnsupportedOperationException(str);
    }

    /* renamed from: a */
    public static void m35381a(int i, String str) {
        m35385b();
    }

    /* renamed from: a */
    private static <T extends Throwable> T m35378a(T t) {
        return m35379a(t, C8271i.class.getName());
    }

    /* renamed from: a */
    static <T extends Throwable> T m35379a(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }
}
