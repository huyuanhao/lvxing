package com.kwad.sdk.p306a;

import android.os.Build.VERSION;
import android.webkit.WebView;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.a.v */
public class C3820v {
    /* renamed from: a */
    private static void m15876a(final WebView webView, final String str) {
        if (VERSION.SDK_INT >= 19) {
            C3815r.m15859a(new Runnable() {
                public void run() {
                    webView.evaluateJavascript(str, null);
                }
            });
        } else {
            webView.loadUrl(str);
        }
    }

    /* renamed from: a */
    public static void m15877a(WebView webView, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:");
        sb.append(str);
        sb.append("(");
        sb.append(JSONObject.quote(str2));
        sb.append(")");
        m15876a(webView, sb.toString());
    }
}
