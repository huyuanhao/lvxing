package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import java.lang.ref.WeakReference;

/* renamed from: com.bytedance.sdk.openadsdk.core.widget.webview.a */
public class SSWebSettings {
    /* renamed from: a */
    private WeakReference<Context> f8375a;
    /* renamed from: b */
    private boolean f8376b = true;
    /* renamed from: c */
    private boolean f8377c = true;
    /* renamed from: d */
    private boolean f8378d = true;
    /* renamed from: e */
    private boolean f8379e = true;
    /* renamed from: f */
    private boolean f8380f = true;
    /* renamed from: g */
    private boolean f8381g = true;
    /* renamed from: h */
    private boolean f8382h = true;

    /* renamed from: a */
    public static SSWebSettings m10854a(Context context) {
        return new SSWebSettings(context);
    }

    private SSWebSettings(Context context) {
        this.f8375a = new WeakReference<>(context);
    }

    /* renamed from: a */
    public SSWebSettings mo16362a(boolean z) {
        this.f8382h = z;
        return this;
    }

    /* renamed from: b */
    public SSWebSettings mo16364b(boolean z) {
        this.f8377c = z;
        return this;
    }

    /* renamed from: a */
    public void mo16363a(WebView webView) {
        if (!(webView == null || this.f8375a.get() == null)) {
            m10857b(webView);
            WebSettings settings = webView.getSettings();
            m10856a(settings);
            if (settings != null) {
                try {
                    settings.setJavaScriptEnabled(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    if (this.f8377c) {
                        settings.setSupportZoom(true);
                        settings.setBuiltInZoomControls(true);
                    } else {
                        settings.setSupportZoom(false);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                settings.setLoadWithOverviewMode(true);
                settings.setUseWideViewPort(this.f8378d);
                settings.setDomStorageEnabled(this.f8379e);
                settings.setAllowFileAccess(this.f8380f);
                settings.setBlockNetworkImage(true ^ this.f8381g);
                try {
                    if (VERSION.SDK_INT >= 11 && !this.f8382h) {
                        webView.setLayerType(0, null);
                    } else if (VERSION.SDK_INT >= 16 && this.f8382h) {
                        webView.setLayerType(2, null);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
    }

    /* renamed from: b */
    private void m10857b(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            C2564t.m12219b(th.toString());
        }
    }

    /* renamed from: a */
    private void m10856a(WebSettings webSettings) {
        try {
            if (VERSION.SDK_INT >= 17) {
                webSettings.setMediaPlaybackRequiresUserGesture(false);
            }
        } catch (Throwable th) {
            C2564t.m12219b(th.toString());
        }
    }

    /* renamed from: a */
    public static String m10855a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !"0".equals(str2)) {
            String str3 = "{{ad_id}}";
            if (str.contains(str3)) {
                String replace = str.replace(str3, str2);
                StringBuilder sb = new StringBuilder();
                sb.append("javascript:(function () {    var JS_ACTLOG_URL = '");
                sb.append(replace);
                sb.append("';    var head = document.getElementsByTagName('head')[0];    var script = document.createElement('script');    script.type = 'text/javascript';    script.src = JS_ACTLOG_URL;    head.appendChild(script);})();");
                return sb.toString();
            }
        }
        return null;
    }
}
