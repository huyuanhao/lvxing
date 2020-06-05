package com.kwad.sdk.core.page.widget.webview;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.kwad.sdk.core.p319c.C4065b;

/* renamed from: com.kwad.sdk.core.page.widget.webview.c */
public class C4255c extends WebViewClient {
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        try {
            if (webView instanceof C4254b) {
                ((C4254b) webView).mo24366a(webView);
            }
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
        super.doUpdateVisitedHistory(webView, str, z);
    }

    public void onLoadResource(WebView webView, String str) {
        try {
            if (webView instanceof C4254b) {
                ((C4254b) webView).mo24366a(webView);
            }
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
        super.onLoadResource(webView, str);
    }

    public void onPageFinished(WebView webView, String str) {
        try {
            if (webView instanceof C4254b) {
                ((C4254b) webView).mo24366a(webView);
            }
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
        super.onPageFinished(webView, str);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        try {
            if (webView instanceof C4254b) {
                ((C4254b) webView).mo24366a(webView);
            }
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        try {
            if (webView instanceof C4254b) {
                ((C4254b) webView).mo24366a(webView);
            }
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
        super.onReceivedError(webView, i, str, str2);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            if (webView instanceof C4254b) {
                ((C4254b) webView).mo24366a(webView);
            }
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
