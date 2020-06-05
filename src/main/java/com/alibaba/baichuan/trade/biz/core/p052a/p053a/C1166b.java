package com.alibaba.baichuan.trade.biz.core.p052a.p053a;

import android.content.Context;
import android.webkit.WebView;
import com.alibaba.baichuan.trade.common.utils.C1224a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.alibaba.baichuan.trade.biz.core.a.a.b */
public class C1166b {
    /* renamed from: a */
    private static final Map<String, C1167a> f2397a = new ConcurrentHashMap();

    /* renamed from: com.alibaba.baichuan.trade.biz.core.a.a.b$a */
    static class C1167a {
        /* renamed from: a */
        private String f2398a;
        /* renamed from: b */
        private ClassLoader f2399b;

        /* renamed from: a */
        public String mo10733a() {
            return this.f2398a;
        }

        /* renamed from: b */
        public ClassLoader mo10734b() {
            return this.f2399b;
        }
    }

    /* renamed from: a */
    public static C1165a m2282a(String str, Context context, WebView webView) {
        String str2 = "AlibcPluginManager";
        C1167a aVar = (C1167a) f2397a.get(str);
        if (!(aVar == null || aVar.mo10733a() == null)) {
            String a = aVar.mo10733a();
            try {
                ClassLoader b = aVar.mo10734b();
                Class cls = b == null ? Class.forName(a) : b.loadClass(a);
                if (cls != null && C1165a.class.isAssignableFrom(cls)) {
                    C1165a aVar2 = (C1165a) cls.newInstance();
                    if (aVar2.f2395b != null) {
                        aVar2.mo10731a(context, webView, aVar2.f2395b);
                    } else {
                        aVar2.mo10730a(context, webView);
                    }
                    return aVar2;
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("create plugin error: ");
                sb.append(str);
                sb.append(". ");
                sb.append(e.getMessage());
                C1224a.m2406d(str2, sb.toString());
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("create plugin failed: ");
            sb2.append(str);
            C1224a.m2405c(str2, sb2.toString());
        }
        return null;
    }
}
