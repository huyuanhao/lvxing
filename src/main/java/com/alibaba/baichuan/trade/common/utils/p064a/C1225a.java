package com.alibaba.baichuan.trade.common.utils.p064a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.C1223b;
import com.alibaba.baichuan.trade.common.adapter.p059a.C1200a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.alibaba.baichuan.trade.common.utils.a.a */
public class C1225a {

    /* renamed from: com.alibaba.baichuan.trade.common.utils.a.a$a */
    public static class C1226a {
        /* renamed from: a */
        public String f2516a;
        /* renamed from: b */
        public String f2517b;

        public C1226a() {
        }

        public C1226a(String str, String str2) {
            this.f2516a = str;
            this.f2517b = str2;
        }
    }

    /* renamed from: a */
    public static synchronized String m2408a(String str) {
        synchronized (C1225a.class) {
            if (TextUtils.isEmpty(str)) {
                String str2 = "";
                return str2;
            }
            SharedPreferences sharedPreferences = C1223b.f2466f.getSharedPreferences("ali_bc_auth_cache", 0);
            String string = sharedPreferences.getString(str, "");
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("SHARE_PREFERENCE_EXPIRE");
            Long.valueOf(sharedPreferences.getLong(sb.toString(), 0));
            return string;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
            return;
     */
    /* renamed from: a */
    public static synchronized void m2409a(java.lang.String r4, java.lang.String r5) {
        /*
        java.lang.Class<com.alibaba.baichuan.trade.common.utils.a.a> r0 = com.alibaba.baichuan.trade.common.utils.p064a.C1225a.class
        monitor-enter(r0)
        boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0028 }
        if (r1 != 0) goto L_0x0026
        if (r5 != 0) goto L_0x000c
        goto L_0x0026
    L_0x000c:
        android.app.Application r1 = com.alibaba.baichuan.trade.common.C1223b.f2466f     // Catch:{ Exception -> 0x0020 }
        java.lang.String r2 = "ali_bc_auth_cache"
        r3 = 0
        android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r3)     // Catch:{ Exception -> 0x0020 }
        android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ Exception -> 0x0020 }
        r1.putString(r4, r5)     // Catch:{ Exception -> 0x0020 }
        r1.apply()     // Catch:{ Exception -> 0x0020 }
        goto L_0x0024
    L_0x0020:
        r4 = move-exception
        r4.printStackTrace()     // Catch:{ all -> 0x0028 }
    L_0x0024:
        monitor-exit(r0)
        return
    L_0x0026:
        monitor-exit(r0)
        return
    L_0x0028:
        r4 = move-exception
        monitor-exit(r0)
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.trade.common.utils.p064a.C1225a.m2409a(java.lang.String, java.lang.String):void");
    }

    /* renamed from: a */
    public static void m2410a(List<C1226a> list) {
        if (list != null) {
            int i = 0;
            while (i < list.size()) {
                if (!(list.get(i) == null || TextUtils.isEmpty(((C1226a) list.get(i)).f2516a) || ((C1226a) list.get(i)).f2517b == null)) {
                    m2409a(((C1226a) list.get(i)).f2516a, ((C1226a) list.get(i)).f2517b);
                }
                i++;
            }
        }
    }

    /* renamed from: b */
    public static String m2411b(String str) {
        String a = m2408a(str);
        if (!TextUtils.isEmpty(a)) {
            return C1200a.m2333a().mo10849b(a);
        }
        return null;
    }

    /* renamed from: b */
    public static void m2412b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str2 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new C1226a(str, str2));
            m2410a((List<C1226a>) arrayList);
        }
    }

    /* renamed from: c */
    public static void m2413c(String str, String str2) {
        m2412b(str, C1200a.m2333a().mo10848a(str2));
    }
}
