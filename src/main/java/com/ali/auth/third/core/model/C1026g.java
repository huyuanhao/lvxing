package com.ali.auth.third.core.model;

import com.ali.auth.third.core.p027f.C1000b;

/* renamed from: com.ali.auth.third.core.model.g */
public class C1026g {
    /* renamed from: a */
    public static final C1026g f2037a = new C1026g(100, "SUCCESS");
    /* renamed from: b */
    public static final C1026g f2038b = new C1026g(-100, "IGNORE");
    /* renamed from: c */
    public static final C1026g f2039c = new C1026g(103, "CAPTCHA_RELOGIN");
    /* renamed from: d */
    public static final C1026g f2040d = new C1026g(104, "TRUST_LOGIN");
    /* renamed from: e */
    public static final C1026g f2041e = new C1026g(105, "continueLogin");
    /* renamed from: f */
    public static final C1026g f2042f = new C1026g(108, "CHECK");
    /* renamed from: g */
    public static final C1026g f2043g = new C1026g(111, "busy control");
    /* renamed from: h */
    public static final C1026g f2044h = new C1026g(10003, "USER_CANCEL");
    /* renamed from: i */
    public static final C1026g f2045i = new C1026g(10010, "SYSTEM_EXCEPTION");
    /* renamed from: j */
    public int f2046j;
    /* renamed from: k */
    public String f2047k;

    public C1026g(int i, String str) {
        this.f2046j = i;
        this.f2047k = str;
    }

    /* renamed from: a */
    public static C1026g m1970a(int i, Object... objArr) {
        return new C1026g(i, C1000b.m1917b(i, objArr));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f2046j == ((C1026g) obj).f2046j;
    }

    public int hashCode() {
        return 31 + this.f2046j;
    }
}
