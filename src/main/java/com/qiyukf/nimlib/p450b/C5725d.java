package com.qiyukf.nimlib.p450b;

import com.p522qq.p523e.comm.constants.Constants;
import com.qiyukf.basesdk.C5263a;

/* renamed from: com.qiyukf.nimlib.b.d */
public final class C5725d {

    /* renamed from: com.qiyukf.nimlib.b.d$a */
    public enum C5726a {
        TEST("t", "223.252.220.222:2000", "http://223.252.220.223/lbs/conf"),
        PRE_REL(Constants.PORTRAIT, "106.2.34.102:8080", "http://223.252.220.223/lbsrc/conf.jsp"),
        REL("r", "link.netease.im:8080", "https://lbs.netease.im/lbs/conf.jsp");
        
        /* renamed from: d */
        String f18290d;
        /* renamed from: e */
        String f18291e;
        /* renamed from: f */
        String f18292f;

        private C5726a(String str, String str2, String str3) {
            this.f18290d = str;
            this.f18291e = str2;
            this.f18292f = str3;
        }
    }

    /* renamed from: a */
    public static int m23052a() {
        return C5727e.m23058b();
    }

    /* renamed from: b */
    public static boolean m23053b() {
        return C5727e.m23057a();
    }

    /* renamed from: c */
    public static void m23054c() {
        C5727e.m23059c();
    }

    /* renamed from: d */
    public static boolean m23055d() {
        return C5727e.f18293a == C5726a.PRE_REL;
    }

    /* renamed from: e */
    public static boolean m23056e() {
        return C5263a.m21611d() != null;
    }
}
