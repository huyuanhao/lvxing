package com.alibaba.baichuan.trade.biz.context;

import android.util.LruCache;
import android.webkit.WebView;
import com.alibaba.baichuan.trade.common.C1223b;
import com.alibaba.baichuan.trade.common.utils.C1230d;

/* renamed from: com.alibaba.baichuan.trade.biz.context.a */
public class C1162a {
    /* renamed from: a */
    private static LruCache<String, AlibcTradeContext> f2392a = new LruCache<>(30);

    /* renamed from: a */
    public static AlibcTradeContext m2274a(WebView webView) {
        AlibcTradeContext alibcTradeContext = null;
        if (webView == null) {
            return null;
        }
        Object tag = webView.getTag(m2275a().intValue());
        if (tag != null) {
            alibcTradeContext = (AlibcTradeContext) f2392a.get(tag.toString());
        }
        return alibcTradeContext;
    }

    /* renamed from: a */
    private static Integer m2275a() {
        if (C1223b.f2466f != null) {
            return Integer.valueOf(C1230d.m2426a(C1223b.f2466f, "com_alibaba_bc_layout"));
        }
        return null;
    }

    /* renamed from: a */
    public static void m2276a(AlibcTradeContext alibcTradeContext) {
        if (alibcTradeContext != null) {
            WebView webView = (WebView) alibcTradeContext.f2387b.get();
            if (webView != null) {
                webView.setTag(m2275a().intValue(), Integer.valueOf(webView.hashCode()));
                f2392a.put(String.valueOf(webView.hashCode()), alibcTradeContext);
            }
        }
    }
}
