package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.core.TTAndroidObject;
import com.bytedance.sdk.openadsdk.p165c.LandingPageLog;
import com.bytedance.sdk.openadsdk.utils.JsBridgeUtils;

/* renamed from: com.bytedance.sdk.openadsdk.core.widget.webview.b */
public class TTWebChromeClient extends WebChromeClient {
    /* renamed from: a */
    private static final String f8414a = WebChromeClient.class.getSimpleName();
    /* renamed from: b */
    private final TTAndroidObject f8415b;
    /* renamed from: c */
    private LandingPageLog f8416c;

    public TTWebChromeClient(TTAndroidObject xVar, LandingPageLog jVar) {
        this.f8415b = xVar;
        this.f8416c = jVar;
    }

    public void onConsoleMessage(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str)) {
            m10919a(str);
        }
        super.onConsoleMessage(str, i, str2);
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage == null || TextUtils.isEmpty(consoleMessage.message()) || !m10919a(consoleMessage.message())) {
            return super.onConsoleMessage(consoleMessage);
        }
        return true;
    }

    /* renamed from: a */
    private boolean m10919a(String str) {
        try {
            Uri parse = Uri.parse(str);
            if ("bytedance".equals(parse.getScheme().toLowerCase())) {
                JsBridgeUtils.m12207a(parse, this.f8415b);
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        LandingPageLog jVar = this.f8416c;
        if (jVar != null) {
            jVar.mo15020a(webView, i);
        }
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
    }
}
