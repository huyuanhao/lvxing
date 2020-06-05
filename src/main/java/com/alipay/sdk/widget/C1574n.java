package com.alipay.sdk.widget;

import android.webkit.SslErrorHandler;

/* renamed from: com.alipay.sdk.widget.n */
class C1574n implements Runnable {
    /* renamed from: a */
    final /* synthetic */ SslErrorHandler f4012a;
    /* renamed from: b */
    final /* synthetic */ C1569j f4013b;

    C1574n(C1569j jVar, SslErrorHandler sslErrorHandler) {
        this.f4013b = jVar;
        this.f4012a = sslErrorHandler;
    }

    public void run() {
        C1564e.m4736a(this.f4013b.f3995a, "安全警告", "安全連接證書校驗無效，將無法保證訪問資料的安全性，可能存在風險，請選擇是否繼續？", "繼續", new C1575o(this), "退出", new C1576p(this));
    }
}
