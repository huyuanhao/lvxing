package com.alipay.sdk.app;

import android.app.Activity;
import android.webkit.SslErrorHandler;
import com.alipay.sdk.widget.C1564e;

/* renamed from: com.alipay.sdk.app.c */
class C1496c implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Activity f3825a;
    /* renamed from: b */
    final /* synthetic */ SslErrorHandler f3826b;
    /* renamed from: c */
    final /* synthetic */ C1494b f3827c;

    C1496c(C1494b bVar, Activity activity, SslErrorHandler sslErrorHandler) {
        this.f3827c = bVar;
        this.f3825a = activity;
        this.f3826b = sslErrorHandler;
    }

    public void run() {
        C1564e.m4736a(this.f3825a, "安全警告", "安全连接证书校验无效，将无法保证访问数据的安全性，可能存在风险，请选择是否继续？", "继续", new C1497d(this), "退出", new C1498e(this));
    }
}
