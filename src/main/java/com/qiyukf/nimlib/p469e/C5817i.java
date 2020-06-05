package com.qiyukf.nimlib.p469e;

import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.qiyukf.nimlib.e.i */
public final class C5817i {
    /* renamed from: a */
    transient C5819b f18480a = new C5819b();
    /* renamed from: b */
    transient C5820c f18481b = new C5820c();
    /* renamed from: c */
    private int f18482c = C5818a.m23344a();
    /* renamed from: d */
    private boolean f18483d;
    /* renamed from: e */
    private transient boolean f18484e;

    /* renamed from: com.qiyukf.nimlib.e.i$a */
    private static final class C5818a {
        /* renamed from: a */
        private static AtomicInteger f18485a = new AtomicInteger(0);

        /* renamed from: a */
        public static int m23344a() {
            return f18485a.incrementAndGet();
        }
    }

    /* renamed from: com.qiyukf.nimlib.e.i$b */
    static final class C5819b {
        /* renamed from: a */
        String f18486a;
        /* renamed from: b */
        Object[] f18487b;

        C5819b() {
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(" uri: ");
            sb.append(this.f18486a);
            return sb.toString();
        }
    }

    /* renamed from: com.qiyukf.nimlib.e.i$c */
    static final class C5820c {
        /* renamed from: a */
        int f18488a;
        /* renamed from: b */
        Object f18489b;

        C5820c() {
        }

        public final String toString() {
            if (this.f18488a == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder(", result: ");
            sb.append(this.f18488a);
            return sb.toString();
        }
    }

    /* renamed from: a */
    public final C5817i mo28111a(int i) {
        this.f18481b.f18488a = i;
        return this;
    }

    /* renamed from: a */
    public final C5817i mo28112a(Object obj) {
        this.f18481b.f18489b = obj;
        return this;
    }

    /* renamed from: a */
    public final C5817i mo28113a(boolean z) {
        this.f18483d = z;
        return this;
    }

    /* renamed from: a */
    public final C5817i mo28114a(Object[] objArr) {
        this.f18480a.f18487b = objArr;
        return this;
    }

    /* renamed from: a */
    public final String mo28115a() {
        return this.f18480a.f18486a.substring(this.f18480a.f18486a.indexOf(47) + 1);
    }

    /* renamed from: b */
    public final C5817i mo28116b(Object obj) {
        C5820c cVar = this.f18481b;
        cVar.f18488a = 200;
        cVar.f18489b = obj;
        return this;
    }

    /* renamed from: b */
    public final C5817i mo28117b(boolean z) {
        this.f18484e = z;
        return this;
    }

    /* renamed from: b */
    public final Object[] mo28118b() {
        return this.f18480a.f18487b;
    }

    /* renamed from: c */
    public final int mo28119c() {
        return this.f18482c;
    }

    /* renamed from: d */
    public final boolean mo28120d() {
        return this.f18483d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Transaction: [id: ");
        sb.append(this.f18482c);
        sb.append(", ");
        sb.append(this.f18480a);
        sb.append(this.f18481b);
        sb.append("]");
        return sb.toString();
    }
}
