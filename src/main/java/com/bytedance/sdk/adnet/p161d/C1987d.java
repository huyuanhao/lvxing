package com.bytedance.sdk.adnet.p161d;

/* compiled from: Logger */
/* renamed from: com.bytedance.sdk.adnet.d.d */
public class C1987d {
    /* renamed from: a */
    private C1989a f6309a;
    /* renamed from: b */
    private C1990b f6310b;

    /* compiled from: Logger */
    /* renamed from: com.bytedance.sdk.adnet.d.d$a */
    public enum C1989a {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    /* compiled from: Logger */
    /* renamed from: com.bytedance.sdk.adnet.d.d$b */
    public interface C1990b {
        /* renamed from: a */
        void mo14379a(String str, String str2);

        /* renamed from: b */
        void mo14380b(String str, String str2);
    }

    /* compiled from: Logger */
    /* renamed from: com.bytedance.sdk.adnet.d.d$c */
    private static class C1991c {
        /* access modifiers changed from: private|static|final */
        /* renamed from: a */
        public static final C1987d f6316a = new C1987d();
    }

    private C1987d() {
        this.f6309a = C1989a.OFF;
        this.f6310b = new DefaultLoggerDelegate();
    }

    /* renamed from: a */
    public static void m7946a(C1989a aVar) {
        synchronized (C1987d.class) {
            C1991c.f6316a.f6309a = aVar;
        }
    }

    /* renamed from: a */
    public static void m7947a(String str, String str2) {
        if (C1991c.f6316a.f6309a.compareTo(C1989a.ERROR) <= 0) {
            C1991c.f6316a.f6310b.mo14379a(str, str2);
        }
    }

    /* renamed from: b */
    public static void m7948b(String str, String str2) {
        if (C1991c.f6316a.f6309a.compareTo(C1989a.DEBUG) <= 0) {
            C1991c.f6316a.f6310b.mo14380b(str, str2);
        }
    }
}
