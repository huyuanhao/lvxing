package com.tencent.android.tpush.horse;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.horse.c */
public class C6937c extends C6932a {
    /* renamed from: a */
    private static C6937c f23046a;

    private C6937c() {
    }

    /* renamed from: i */
    public static synchronized C6937c m29631i() {
        C6937c cVar;
        synchronized (C6937c.class) {
            if (f23046a == null) {
                f23046a = new C6937c();
            }
            cVar = f23046a;
        }
        return cVar;
    }

    /* renamed from: e */
    public void mo33169e() {
        m29631i().mo33168d().clear();
    }

    /* renamed from: f */
    public void mo33170f() {
        m29631i().mo33163a(-1);
    }
}
