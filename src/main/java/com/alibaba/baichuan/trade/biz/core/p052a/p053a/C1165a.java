package com.alibaba.baichuan.trade.biz.core.p052a.p053a;

import android.content.Context;
import android.webkit.WebView;
import com.alibaba.baichuan.trade.biz.core.p052a.C1168b;

/* renamed from: com.alibaba.baichuan.trade.biz.core.a.a.a */
public abstract class C1165a {
    /* renamed from: a */
    protected WebView f2394a;
    /* renamed from: b */
    public Object f2395b;
    /* renamed from: c */
    protected boolean f2396c = true;

    /* renamed from: a */
    public void mo10730a(Context context, WebView webView) {
        mo10731a(context, webView, (Object) null);
    }

    /* renamed from: a */
    public void mo10731a(Context context, WebView webView, Object obj) {
        this.f2394a = webView;
        this.f2395b = obj;
    }

    /* renamed from: a */
    public abstract boolean mo10732a(String str, String str2, C1168b bVar);
}
