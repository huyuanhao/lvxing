package com.kwad.sdk.core.page.widget.webview;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.kwad.sdk.core.p319c.C4065b;

/* renamed from: com.kwad.sdk.core.page.widget.webview.a */
public class C4253a extends WebChromeClient {
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        try {
            if ((webView instanceof C4254b) && ((C4254b) webView).mo24367a(webView, str, str2, str3, jsPromptResult)) {
                return true;
            }
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    public void onProgressChanged(WebView webView, int i) {
        try {
            if (webView instanceof C4254b) {
                ((C4254b) webView).mo24366a(webView);
            }
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
        super.onProgressChanged(webView, i);
    }

    public void onReceivedTitle(WebView webView, String str) {
        try {
            if (webView instanceof C4254b) {
                ((C4254b) webView).mo24366a(webView);
            }
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
    }
}
