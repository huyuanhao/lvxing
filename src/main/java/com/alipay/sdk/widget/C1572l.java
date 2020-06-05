package com.alipay.sdk.widget;

import android.view.animation.Animation;

/* renamed from: com.alipay.sdk.widget.l */
class C1572l extends C1570a {
    /* renamed from: b */
    final /* synthetic */ WebViewWindow f4007b;
    /* renamed from: c */
    final /* synthetic */ C1569j f4008c;

    C1572l(C1569j jVar, WebViewWindow webViewWindow) {
        this.f4008c = jVar;
        this.f4007b = webViewWindow;
        super(jVar, null);
    }

    public void onAnimationEnd(Animation animation) {
        this.f4007b.mo12223a();
        this.f4008c.f4001d = false;
    }
}
