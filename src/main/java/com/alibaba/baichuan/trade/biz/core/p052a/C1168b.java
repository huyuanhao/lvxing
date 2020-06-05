package com.alibaba.baichuan.trade.biz.core.p052a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.alibaba.baichuan.trade.common.C1223b;
import com.alibaba.baichuan.trade.common.utils.C1224a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.alibaba.baichuan.trade.biz.core.a.b */
public class C1168b {
    /* renamed from: g */
    private static boolean f2400g = (VERSION.SDK_INT >= 19);
    /* renamed from: a */
    WebView f2401a;
    /* renamed from: b */
    String f2402b;
    /* renamed from: c */
    String f2403c;
    /* renamed from: d */
    String f2404d;
    /* renamed from: e */
    boolean f2405e = false;
    /* renamed from: f */
    String f2406f = null;

    public C1168b(WebView webView, String str, String str2, String str3) {
        this.f2401a = webView;
        this.f2402b = str;
        this.f2403c = str2;
        this.f2404d = str3;
    }

    /* renamed from: a */
    private static String m2285a(String str) {
        String str2 = " ";
        if (str.contains(str2)) {
            try {
                str = str.replace(str2, "\\u2028");
            } catch (Exception unused) {
            }
        }
        String str3 = " ";
        if (str.contains(str3)) {
            try {
                str = str.replace(str3, "\\u2029");
            } catch (Exception unused2) {
            }
        }
        return str.replace("\\", "\\\\").replace("'", "\\'");
    }

    /* renamed from: a */
    public static void m2286a(WebView webView, String str) {
        m2287a(webView, str, null);
    }

    /* renamed from: a */
    public static void m2287a(WebView webView, String str, ValueCallback<String> valueCallback) {
        if (webView != null && webView != null) {
            String str2 = "javascript:";
            if (str != null && str.length() > 10 && str2.equals(str.substring(0, 11).toLowerCase())) {
                str = str.substring(11);
            }
            String str3 = "evaluateJavascript";
            String str4 = "Alibc";
            if (f2400g) {
                try {
                    webView.evaluateJavascript(str, valueCallback);
                } catch (IllegalStateException | NoSuchMethodError unused) {
                    f2400g = false;
                    m2287a(webView, str, valueCallback);
                }
            } else if (valueCallback == null) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(str);
                    webView.loadUrl(sb.toString());
                } catch (Throwable th) {
                    C1224a.m2403a(str4, str3, th);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m2288a(final WebView webView, String str, String str2) {
        String str3 = "AlibcJsCallbackContext";
        if (C1223b.m2401e() && !TextUtils.isEmpty(str2)) {
            try {
                new JSONObject(str2);
            } catch (JSONException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("return param is not a valid json!\n");
                sb.append(str);
                sb.append("\n");
                sb.append(str2);
                C1224a.m2406d(str3, sb.toString());
            }
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "{}";
        }
        try {
            final String format = String.format(str, new Object[]{m2285a(str2)});
            webView.post(new Runnable() {
                public void run() {
                    C1168b.m2286a(webView, format);
                }
            });
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("callback error. ");
            sb2.append(e.getMessage());
            C1224a.m2406d(str3, sb2.toString());
        }
    }

    /* renamed from: a */
    public void mo10735a(C1170c cVar) {
        C1224a.m2404b("AlibcJsCallbackContext", "call error ");
        m2288a(this.f2401a, String.format("javascript:window.AliBCBridge&&window.AliBCBridge.onFailure(%s,'%%s');", new Object[]{this.f2402b}), cVar.mo10737a());
    }
}
