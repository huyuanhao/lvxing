package com.bytedance.sdk.openadsdk.utils;

import android.os.Build.VERSION;
import android.webkit.WebView;

/* renamed from: com.bytedance.sdk.openadsdk.utils.s */
public class LoadUrlUtils {
    /* renamed from: a */
    private static final C2562a f9186a;

    /* compiled from: LoadUrlUtils */
    /* renamed from: com.bytedance.sdk.openadsdk.utils.s$a */
    private static class C2562a {
        private C2562a() {
        }

        /* renamed from: a */
        public void mo16949a(WebView webView, String str) {
            if (webView != null) {
                try {
                    webView.loadUrl(str);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* compiled from: LoadUrlUtils */
    /* renamed from: com.bytedance.sdk.openadsdk.utils.s$b */
    private static class C2563b extends C2562a {
        private C2563b() {
            super();
        }

        /* renamed from: a */
        public void mo16949a(WebView webView, String str) {
            if (webView != null) {
                boolean z = false;
                if (str != null && str.startsWith("javascript:")) {
                    try {
                        webView.evaluateJavascript(str, null);
                        z = true;
                    } catch (Throwable th) {
                        boolean z2 = th instanceof IllegalStateException;
                    }
                }
                if (!z) {
                    try {
                        webView.loadUrl(str);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f9186a = new C2563b();
        } else {
            f9186a = new C2562a();
        }
    }

    /* renamed from: a */
    public static void m12210a(WebView webView, String str) {
        f9186a.mo16949a(webView, str);
    }
}
