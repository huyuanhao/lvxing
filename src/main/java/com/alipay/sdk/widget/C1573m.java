package com.alipay.sdk.widget;

import android.view.animation.Animation;

/* renamed from: com.alipay.sdk.widget.m */
class C1573m extends C1570a {
    /* renamed from: b */
    final /* synthetic */ WebViewWindow f4009b;
    /* renamed from: c */
    final /* synthetic */ String f4010c;
    /* renamed from: d */
    final /* synthetic */ C1569j f4011d;

    C1573m(C1569j jVar, WebViewWindow webViewWindow, String str) {
        this.f4011d = jVar;
        this.f4009b = webViewWindow;
        this.f4010c = str;
        super(jVar, null);
    }

    public void onAnimationEnd(Animation animation) {
        this.f4011d.removeView(this.f4009b);
        this.f4011d.f4003f.mo12225a(this.f4010c);
        this.f4011d.f4001d = false;
    }
}
