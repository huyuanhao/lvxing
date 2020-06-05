package com.ali.auth.third.p034ui.webview;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.ali.auth.third.core.util.C1034a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.ali.auth.third.ui.webview.AuthWebView */
public class AuthWebView extends WebView {
    /* renamed from: a */
    private static final String f2191a = AuthWebView.class.getSimpleName();
    /* renamed from: b */
    private Map<String, Object> f2192b = new HashMap();
    /* renamed from: c */
    private HashMap<String, String> f2193c = new HashMap<>();
    /* renamed from: d */
    private String f2194d;

    public AuthWebView(Context context) {
        super(context);
        m2096a(context, true);
    }

    public AuthWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2096a(context, true);
    }

    public AuthWebView(Context context, boolean z) {
        super(context);
        m2096a(context, z);
    }

    /* renamed from: a */
    private void m2096a(Context context, boolean z) {
        WebSettings settings = getSettings();
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception unused) {
        }
        settings.setSavePassword(false);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setDomStorageEnabled(true);
        this.f2194d = context.getApplicationContext().getDir("cache", 0).getPath();
        settings.setAppCachePath(this.f2194d);
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAppCacheEnabled(true);
        if (C1034a.m1981a(context)) {
            settings.setCacheMode(-1);
        } else {
            settings.setCacheMode(1);
        }
        settings.setBuiltInZoomControls(false);
        try {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (VERSION.SDK_INT >= 21) {
            try {
                CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
                settings.setMixedContentMode(0);
            } catch (Throwable unused2) {
            }
        }
    }

    /* renamed from: a */
    public Object mo10452a(String str) {
        return this.f2192b.get(str);
    }

    /* renamed from: a */
    public final void mo10453a(String str, Object obj) {
        this.f2192b.put(str, obj);
    }

    public final void addJavascriptInterface(Object obj, String str) {
    }

    public HashMap<String, String> getContextParameters() {
        return this.f2193c;
    }
}
