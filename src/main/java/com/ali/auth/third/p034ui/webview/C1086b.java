package com.ali.auth.third.p034ui.webview;

import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.ali.auth.third.core.p027f.C0999a;
import com.ali.auth.third.core.p027f.C1000b;
import com.ali.auth.third.core.p033j.C1018a;
import com.ali.auth.third.p034ui.p035a.C1068b;
import com.tencent.mid.sotrage.StorageInterface;
import com.tencent.qqpim.discovery.internal.protocol.C7516p;
import com.tencent.stat.common.DeviceInfo;
import java.lang.reflect.Method;

/* renamed from: com.ali.auth.third.ui.webview.b */
public class C1086b extends WebChromeClient {
    /* renamed from: a */
    private static final String f2214a = C1086b.class.getSimpleName();
    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static boolean f2215b = (VERSION.SDK_INT >= 19);

    /* renamed from: com.ali.auth.third.ui.webview.b$a */
    private static class C1087a implements Runnable {
        /* renamed from: a */
        public WebView f2216a;
        /* renamed from: b */
        public String f2217b;

        public C1087a(WebView webView, String str) {
            this.f2216a = webView;
            this.f2217b = str;
        }

        public void run() {
            try {
                if (C1086b.f2215b) {
                    try {
                        this.f2216a.evaluateJavascript(this.f2217b, null);
                        return;
                    } catch (Exception e) {
                        String str = DeviceInfo.TAG_IMEI;
                        StringBuilder sb = new StringBuilder();
                        sb.append("fail to evaluate the script ");
                        sb.append(e.getMessage());
                        C1018a.m1960a(str, sb.toString(), (Throwable) e);
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("javascript:");
                sb2.append(this.f2217b);
                String sb3 = sb2.toString();
                if (this.f2216a instanceof AuthWebView) {
                    ((AuthWebView) this.f2216a).loadUrl(sb3);
                } else {
                    this.f2216a.loadUrl(sb3);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    private C1088c m2106a(String str) {
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        int port = parse.getPort();
        String lastPathSegment = parse.getLastPathSegment();
        parse.getQuery();
        int indexOf = str.indexOf("?");
        String substring = indexOf == -1 ? null : str.substring(indexOf + 1);
        C1088c cVar = new C1088c();
        cVar.f2219b = lastPathSegment;
        cVar.f2218a = host;
        cVar.f2220c = substring;
        cVar.f2221d = port;
        return cVar;
    }

    /* renamed from: a */
    private void m2107a(WebView webView, String str) {
        try {
            int indexOf = str.indexOf(58, 9);
            webView.post(new C1087a(webView, String.format("window.WindVane&&window.WindVane.onFailure(%s,'{\"ret\":\"HY_NO_HANDLER\"');", new Object[]{str.substring(indexOf + 1, str.indexOf(47, indexOf))})));
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("fail to handler windvane request, the error message is ");
            sb.append(e.getMessage());
            C1018a.m1960a(DeviceInfo.TAG_IMEI, sb.toString(), (Throwable) e);
        }
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        String str4 = StorageInterface.KEY_SPLITER;
        if (str3 == null) {
            return false;
        }
        String str5 = "";
        if (str3.equals("wv_hybrid:")) {
            m2107a(webView, str2);
        } else if (!TextUtils.equals(str3, "hv_hybrid:") || !(webView instanceof AuthWebView)) {
            return false;
        } else {
            AuthWebView authWebView = (AuthWebView) webView;
            C1088c a = m2106a(str2);
            C1068b bVar = new C1068b();
            bVar.f2152e = a.f2221d;
            bVar.f2151d = authWebView;
            Object a2 = authWebView.mo10452a(a.f2218a);
            if (a2 == null) {
                C0999a a3 = C1000b.m1914a(C7516p.f25219Cf, a.f2218a);
                C1018a.m1967d(f2214a, a3.toString());
                bVar.mo10407a(a3.f1942a, a3.f1944c);
            } else {
                try {
                    Method method = a2.getClass().getMethod(a.f2219b, new Class[]{C1068b.class, String.class});
                    if (method.isAnnotationPresent(BridgeMethod.class)) {
                        try {
                            Object[] objArr = new Object[2];
                            objArr[0] = bVar;
                            objArr[1] = TextUtils.isEmpty(a.f2220c) ? "{}" : a.f2220c;
                            method.invoke(a2, objArr);
                        } catch (Exception e) {
                            C0999a a4 = C1000b.m1914a(10010, e.getMessage());
                            String str6 = f2214a;
                            StringBuilder sb = new StringBuilder();
                            sb.append(a4.toString());
                            sb.append(str4);
                            sb.append(e.toString());
                            C1018a.m1967d(str6, sb.toString());
                            bVar.mo10407a(a4.f1942a, a4.f1944c);
                        }
                    } else {
                        C0999a a5 = C1000b.m1914a(952, a.f2218a, a.f2219b);
                        C1018a.m1967d(f2214a, a5.toString());
                        bVar.mo10407a(a5.f1942a, a5.f1944c);
                    }
                    jsPromptResult.confirm(str5);
                    return true;
                } catch (NoSuchMethodException e2) {
                    C0999a a6 = C1000b.m1914a(951, a.f2218a, a.f2219b);
                    String str7 = f2214a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(a6);
                    sb2.append(str4);
                    sb2.append(e2.toString());
                    C1018a.m1967d(str7, sb2.toString());
                    bVar.mo10407a(a6.f1942a, a6.f1944c);
                }
            }
        }
        jsPromptResult.confirm(str5);
        return true;
    }
}
