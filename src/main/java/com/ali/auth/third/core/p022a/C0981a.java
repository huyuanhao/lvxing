package com.ali.auth.third.core.p022a;

import android.os.Build.VERSION;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.ali.auth.third.core.C0982b;
import com.ali.auth.third.core.p024c.C0989a;

/* renamed from: com.ali.auth.third.core.a.a */
public class C0981a implements C0982b {
    /* renamed from: a */
    private static volatile C0981a f1885a;

    private C0981a() {
    }

    /* renamed from: c */
    public static C0981a m1868c() {
        if (f1885a == null) {
            synchronized (C0981a.class) {
                if (f1885a == null) {
                    f1885a = new C0981a();
                }
            }
        }
        return f1885a;
    }

    /* renamed from: a */
    public String mo10301a(String str) {
        CookieManager instance = CookieManager.getInstance();
        instance.setAcceptCookie(true);
        return instance.getCookie(".taobao.com");
    }

    /* renamed from: a */
    public void mo10302a() {
        try {
            if (VERSION.SDK_INT >= 21) {
                CookieManager.getInstance().flush();
            } else {
                CookieSyncManager.createInstance(C0989a.m1887c()).sync();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void mo10303a(String str, String str2) {
        CookieManager.getInstance().setCookie(str, str2);
    }

    /* renamed from: b */
    public void mo10304b() {
        CookieManager.getInstance().removeExpiredCookie();
    }
}
