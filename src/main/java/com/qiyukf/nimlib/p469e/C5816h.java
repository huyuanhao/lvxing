package com.qiyukf.nimlib.p469e;

/* renamed from: com.qiyukf.nimlib.e.h */
public abstract class C5816h {
    /* renamed from: a */
    private static final ThreadLocal<C5817i> f18479a = new ThreadLocal<>();

    /* renamed from: a */
    public static final void m23331a() {
        f18479a.set(null);
    }

    /* renamed from: a */
    public static final void m23332a(C5817i iVar) {
        f18479a.set(iVar);
    }

    /* renamed from: b */
    protected static C5817i m23333b() {
        return (C5817i) f18479a.get();
    }
}
