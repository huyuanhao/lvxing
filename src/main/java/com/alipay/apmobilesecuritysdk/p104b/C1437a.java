package com.alipay.apmobilesecuritysdk.p104b;

import com.alipay.p109b.p110a.p111a.p112a.C1460a;
import com.alipay.p109b.p110a.p111a.p117e.C1488d;

/* renamed from: com.alipay.apmobilesecuritysdk.b.a */
public final class C1437a {
    /* renamed from: b */
    private static C1437a f3695b = new C1437a();
    /* renamed from: a */
    private int f3696a = 0;

    /* renamed from: a */
    public static C1437a m4163a() {
        return f3695b;
    }

    /* renamed from: a */
    public final void mo12004a(int i) {
        this.f3696a = i;
    }

    /* renamed from: b */
    public final int mo12005b() {
        return this.f3696a;
    }

    /* renamed from: c */
    public final String mo12006c() {
        String a = C1488d.m4384a();
        if (C1460a.m4263b(a)) {
            return a;
        }
        int i = this.f3696a;
        if (i == 1) {
            return "http://mobilegw.stable.alipay.net/mgw.htm";
        }
        String str = "https://mobilegw.alipay.com/mgw.htm";
        return i != 2 ? i != 3 ? i != 4 ? str : "http://mobilegw.aaa.alipay.net/mgw.htm" : "http://mobilegw-1-64.test.alipay.net/mgw.htm" : str;
    }
}
