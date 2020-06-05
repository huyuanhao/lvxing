package com.p368pw.inner.appwall;

import com.p368pw.inner.appwall.C5041p.C5042a;

/* renamed from: com.pw.inner.appwall.g */
public class C5004g {
    /* renamed from: a */
    private static volatile C5004g f16287a;

    private C5004g() {
    }

    /* renamed from: a */
    public static C5004g m20946a() {
        if (f16287a == null) {
            synchronized (C5004g.class) {
                if (f16287a == null) {
                    f16287a = new C5004g();
                }
            }
        }
        return f16287a;
    }

    /* renamed from: a */
    public void mo26395a(C5034m mVar, int i) {
        C5042a d = mVar.mo26469d();
        if (d == null || d.mo26480a() != 1) {
            C5003f.m20937a().mo26392a(mVar, i);
        } else {
            C5031l.m21010a().mo26459a(mVar, i);
        }
    }

    /* renamed from: b */
    public void mo26396b() {
        C5003f.m20937a().mo26394c();
    }

    /* renamed from: b */
    public void mo26397b(C5034m mVar, int i) {
        C5042a d = mVar.mo26469d();
        if (d != null && d.mo26480a() == 1) {
            C5031l.m21010a().mo26459a(mVar, i);
        }
    }

    /* renamed from: c */
    public void mo26398c() {
        C5003f.m20937a().mo26393b();
    }
}
