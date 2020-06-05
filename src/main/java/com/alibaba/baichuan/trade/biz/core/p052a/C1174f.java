package com.alibaba.baichuan.trade.biz.core.p052a;

import android.webkit.ValueCallback;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.alibaba.baichuan.trade.biz.core.a.f */
public class C1174f {
    /* renamed from: a */
    private static ConcurrentHashMap<String, ValueCallback<String>> f2433a = new ConcurrentHashMap<>();

    /* renamed from: a */
    public static ValueCallback<String> m2307a(String str) {
        return (ValueCallback) f2433a.get(str);
    }

    /* renamed from: b */
    public static void m2308b(String str) {
        f2433a.remove(str);
    }
}
