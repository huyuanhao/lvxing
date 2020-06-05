package com.alibaba.baichuan.trade.biz.auth;

import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.C1223b;
import com.alibaba.baichuan.trade.common.Environment;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.alibaba.baichuan.trade.biz.auth.d */
public class C1149d {
    /* renamed from: a */
    public static final C1149d f2365a = new C1149d("1", "24", "添加商品到您的淘宝购物车");
    /* renamed from: c */
    private static Map<String, C1149d> f2366c;
    /* renamed from: d */
    private static Map<String, String> f2367d;
    /* renamed from: e */
    private static Map<String, Set<String>> f2368e;
    /* renamed from: b */
    public String f2369b;
    /* renamed from: f */
    private String f2370f;
    /* renamed from: g */
    private String f2371g;

    private C1149d() {
    }

    private C1149d(String str, String str2, String str3) {
        this.f2370f = str;
        this.f2369b = str3;
        this.f2371g = str2;
        synchronized (this) {
            if (f2366c == null) {
                f2366c = new ConcurrentHashMap();
            }
        }
        f2366c.put(mo10663a(), this);
    }

    /* renamed from: a */
    public static String m2239a(String str) {
        String str2 = ")";
        String str3 = "访问您淘宝账号信息的权限(";
        if (TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(str);
            sb.append(str2);
            return sb.toString();
        }
        String str4 = "";
        String str5 = f2366c.get(str) == null ? str4 : ((C1149d) f2366c.get(str)).f2369b;
        if (TextUtils.isEmpty(str5)) {
            Map<String, String> map = f2367d;
            if (map != null) {
                str4 = (String) map.get(str);
            }
            str5 = str4;
        }
        if (TextUtils.isEmpty(str5)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(str);
            sb2.append(str2);
            str5 = sb2.toString();
        }
        return str5;
    }

    /* renamed from: a */
    public static synchronized void m2240a(String str, String str2) {
        synchronized (C1149d.class) {
            if (f2367d == null) {
                f2367d = new HashMap();
            }
            f2367d.put(str, str2);
        }
    }

    /* renamed from: a */
    public static synchronized void m2241a(String str, Set<String> set) {
        synchronized (C1149d.class) {
            if (f2368e == null) {
                f2368e = new HashMap();
            }
            f2368e.put(str, set);
        }
    }

    /* renamed from: b */
    public static synchronized Set<String> m2242b(String str) {
        synchronized (C1149d.class) {
            if (f2367d == null) {
                return null;
            }
            Set<String> set = (Set) f2368e.get(str);
            return set;
        }
    }

    /* renamed from: a */
    public String mo10663a() {
        return C1223b.m2398b() == Environment.TEST ? this.f2371g : this.f2370f;
    }
}
