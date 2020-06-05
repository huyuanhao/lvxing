package com.alipay.sdk.widget;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* renamed from: com.alipay.sdk.widget.t */
class C1580t extends WebViewClient {
    /* renamed from: a */
    final /* synthetic */ WebViewWindow f4020a;

    C1580t(WebViewWindow webViewWindow) {
        this.f4020a = webViewWindow;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!this.f4020a.f3977h.mo12240b(this.f4020a, str)) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return true;
    }

    public void onPageFinished(WebView webView, String str) {
        if (!this.f4020a.f3977h.mo12241c(this.f4020a, str)) {
            super.onPageFinished(webView, str);
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        if (!this.f4020a.f3977h.mo12238a(this.f4020a, i, str, str2)) {
            super.onReceivedError(webView, i, str, str2);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (!this.f4020a.f3977h.mo12239a(this.f4020a, sslErrorHandler, sslError)) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }
}
