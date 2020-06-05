package com.alipay.sdk.widget;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* renamed from: com.alipay.sdk.widget.s */
class C1579s extends WebChromeClient {
    /* renamed from: a */
    final /* synthetic */ WebViewWindow f4019a;

    C1579s(WebViewWindow webViewWindow) {
        this.f4019a = webViewWindow;
    }

    public void onProgressChanged(WebView webView, int i) {
        if (i == 100) {
            this.f4019a.f3974d.setVisibility(4);
            return;
        }
        if (4 == this.f4019a.f3974d.getVisibility()) {
            this.f4019a.f3974d.setVisibility(0);
        }
        this.f4019a.f3974d.setProgress(i);
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return this.f4019a.f3976g.mo12237a(this.f4019a, str, str2, str3, jsPromptResult);
    }

    public void onReceivedTitle(WebView webView, String str) {
        this.f4019a.f3976g.mo12236a(this.f4019a, str);
    }
}
