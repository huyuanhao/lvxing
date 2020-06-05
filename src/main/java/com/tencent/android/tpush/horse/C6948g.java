package com.tencent.android.tpush.horse;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.horse.g */
public class C6948g extends C6932a {
    /* renamed from: a */
    private static C6948g f23073a;

    private C6948g() {
    }

    /* renamed from: i */
    public static synchronized C6948g m29673i() {
        C6948g gVar;
        synchronized (C6948g.class) {
            if (f23073a == null) {
                f23073a = new C6948g();
            }
            gVar = f23073a;
        }
        return gVar;
    }

    /* renamed from: e */
    public void mo33169e() {
        C6937c.m29631i().mo33168d().clear();
    }

    /* renamed from: f */
    public void mo33170f() {
        C6937c.m29631i().mo33163a(-1);
        C6937c.m29631i().mo33162a();
    }
}
