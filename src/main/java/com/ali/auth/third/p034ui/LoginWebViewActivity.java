package com.ali.auth.third.p034ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ali.auth.third.core.C0980a;
import com.ali.auth.third.core.model.C1026g;
import com.ali.auth.third.core.p023b.C0985c;
import com.ali.auth.third.core.p024c.C0989a;
import com.ali.auth.third.core.p033j.C1018a;
import com.ali.auth.third.p016a.C0958b;
import com.ali.auth.third.p016a.p018b.C0959a;
import com.ali.auth.third.p016a.p018b.C0960b;
import com.ali.auth.third.p016a.p019c.C0968c;
import com.ali.auth.third.p016a.p019c.C0975f;
import com.ali.auth.third.p016a.p020d.C0977a;
import com.ali.auth.third.p034ui.webview.AuthWebView;
import com.ali.auth.third.p034ui.webview.BaseWebViewActivity;
import com.ali.auth.third.p034ui.webview.C1083a;
import com.ali.auth.third.p034ui.webview.C1086b;

/* renamed from: com.ali.auth.third.ui.LoginWebViewActivity */
public class LoginWebViewActivity extends BaseWebViewActivity {
    /* renamed from: a */
    public static final String f2089a = BaseWebViewActivity.class.getSimpleName();
    /* renamed from: b */
    public static String f2090b;
    /* renamed from: c */
    public static String f2091c;
    /* renamed from: d */
    public static C0985c f2092d;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public C0958b f2093l;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m2013a(Uri uri) {
        Bundle b = m2015b(uri.getQuery());
        if (b == null) {
            b = new Bundle();
        }
        b.getString("havana_mobile_reg_otherWebView");
        String string = b.getString("action");
        b.getString("loginId");
        if (TextUtils.isEmpty(string) || "quit".equals(string)) {
            setResult(C1026g.f2037a.f2046j, getIntent().putExtra("iv_token", b.getString("havana_iv_token")));
            finish();
            return true;
        } else if ("relogin".equals(string)) {
            finish();
            return true;
        } else if ("mobile_confirm_login".equals(string) || "trustLogin".equals(string)) {
            return true;
        } else {
            if ("continueLogin".equals(string)) {
                return mo10386a(uri, b);
            }
            if (!"loginAfterRegister".equals(string)) {
                return false;
            }
            String string2 = b.getString("token");
            new C0968c(this, f2092d, true).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{string2, "1012", ""});
            return true;
        }
    }

    /* renamed from: b */
    public static Bundle m2015b(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String[] split = str.split("&");
        Bundle bundle = new Bundle();
        int length = split.length;
        for (int i = 0; i < length; i++) {
            String str2 = split[i];
            int indexOf = str2.indexOf("=");
            if (indexOf > 0 && indexOf < str2.length() - 1) {
                bundle.putString(str2.substring(0, indexOf), str2.substring(indexOf + 1));
            }
        }
        return bundle;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public WebViewClient mo10385a() {
        return new C1083a(this) {
            public void onLoadResource(WebView webView, String str) {
                super.onLoadResource(webView, str);
                String str2 = LoginWebViewActivity.f2089a;
                StringBuilder sb = new StringBuilder();
                sb.append("onLoadResource url=");
                sb.append(str);
                C1018a.m1964b(str2, sb.toString());
            }

            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                String str2 = LoginWebViewActivity.f2089a;
                StringBuilder sb = new StringBuilder();
                sb.append("onPageFinished url=");
                sb.append(str);
                C1018a.m1964b(str2, sb.toString());
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                String str2 = LoginWebViewActivity.f2089a;
                StringBuilder sb = new StringBuilder();
                sb.append("onPageStarted url=");
                sb.append(str);
                C1018a.m1964b(str2, sb.toString());
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                String str2 = LoginWebViewActivity.f2089a;
                StringBuilder sb = new StringBuilder();
                sb.append("shouldOverrideUrlLoading url=");
                sb.append(str);
                C1018a.m1964b(str2, sb.toString());
                Uri parse = Uri.parse(str);
                if (LoginWebViewActivity.this.f2093l.mo10272a(str)) {
                    new C0975f(LoginWebViewActivity.this.f2196f).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                    return true;
                } else if (LoginWebViewActivity.this.mo10387a(str)) {
                    return LoginWebViewActivity.this.m2013a(parse);
                } else {
                    if (webView instanceof AuthWebView) {
                        ((AuthWebView) webView).loadUrl(str);
                    } else {
                        webView.loadUrl(str);
                    }
                    return true;
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo10386a(Uri uri, Bundle bundle) {
        bundle.putString("aliusersdk_h5querystring", uri.getQuery());
        bundle.putString("token", f2090b);
        bundle.putString("scene", f2091c);
        setResult(C1026g.f2042f.f2046j, getIntent().putExtras(bundle));
        finish();
        return true;
    }

    /* renamed from: a */
    public boolean mo10387a(String str) {
        Uri parse = Uri.parse(str);
        StringBuilder sb = new StringBuilder();
        sb.append(parse.getAuthority());
        sb.append(parse.getPath());
        return "https://www.alipay.com/webviewbridge".contains(sb.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public WebChromeClient mo10388b() {
        return new C1086b() {
            public void onReceivedTitle(WebView webView, String str) {
                if (!LoginWebViewActivity.this.f2199i) {
                    return;
                }
                if ((str == null || !str.contains("我喜欢")) && str != null) {
                    LoginWebViewActivity.this.f2197g.setText(str);
                }
            }
        };
    }

    /* renamed from: c */
    public void mo10389c() {
        if (!this.f2196f.canGoBack() || (!this.f2196f.getUrl().contains("authorization-notice") && !this.f2196f.getUrl().contains("agreement"))) {
            setResult(C1026g.f2044h.f2046j, new Intent());
            C0977a.m1852a();
            finish();
            return;
        }
        this.f2196f.goBack();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f2196f == null) {
            finish();
            return;
        }
        this.f2196f.mo10453a("accountBridge", (Object) new C0959a());
        this.f2196f.mo10453a("loginBridge", (Object) new C0959a());
        this.f2196f.mo10453a("ivBridge", (Object) new C0960b());
        this.f2093l = (C0958b) C0980a.m1867a(C0958b.class);
        if (C0989a.f1891f == null) {
            C0989a.f1891f = getApplicationContext();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        C0977a.m1852a();
    }
}
