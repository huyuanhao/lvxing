package com.alipay.sdk.widget;

import android.app.Activity;
import android.webkit.WebView;
import com.alipay.sdk.app.C1494b;
import com.alipay.sdk.app.C1503j;
import com.alipay.sdk.app.C1504k;

/* renamed from: com.alipay.sdk.widget.h */
public class C1567h extends C1566g {
    /* renamed from: b */
    private C1494b f3996b;
    /* renamed from: c */
    private WebView f3997c;

    public C1567h(Activity activity) {
        super(activity);
        this.f3997c = new WebView(activity);
        m4741a(this.f3997c, activity);
        addView(this.f3997c);
        this.f3996b = new C1494b(activity);
        this.f3997c.setWebViewClient(this.f3996b);
    }

    /* renamed from: b */
    public boolean mo12255b() {
        if (!this.f3997c.canGoBack()) {
            C1503j.m4439a(C1503j.m4442c());
            this.f3995a.finish();
        } else if (this.f3996b.mo12130b()) {
            C1504k b = C1504k.m4445b(C1504k.NETWORK_ERROR.mo12142a());
            C1503j.m4439a(C1503j.m4438a(b.mo12142a(), b.mo12145b(), ""));
            this.f3995a.finish();
        }
        return true;
    }

    /* renamed from: a */
    public void mo12252a() {
        this.f3996b.mo12129a();
        removeAllViews();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0074 */
    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0084 A[Catch:{ all -> 0x009f }] */
    /* renamed from: a */
    private void m4741a(android.webkit.WebView r7, android.content.Context r8) {
        /*
        r6 = this;
        java.lang.String r7 = "accessibilityTraversal"
        java.lang.String r0 = "accessibility"
        java.lang.String r1 = "searchBoxJavaBridge_"
        android.webkit.WebView r2 = r6.f3997c
        android.webkit.WebSettings r2 = r2.getSettings()
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r4 = r2.getUserAgentString()
        r3.append(r4)
        java.lang.String r8 = com.alipay.sdk.util.C1553o.m4685c(r8)
        r3.append(r8)
        java.lang.String r8 = r3.toString()
        r2.setUserAgentString(r8)
        android.webkit.WebSettings$RenderPriority r8 = android.webkit.WebSettings.RenderPriority.HIGH
        r2.setRenderPriority(r8)
        r8 = 1
        r2.setSupportMultipleWindows(r8)
        r2.setJavaScriptEnabled(r8)
        r3 = 0
        r2.setSavePassword(r3)
        r2.setJavaScriptCanOpenWindowsAutomatically(r8)
        int r4 = r2.getMinimumFontSize()
        int r4 = r4 + 8
        r2.setMinimumFontSize(r4)
        r2.setAllowFileAccess(r3)
        android.webkit.WebSettings$TextSize r4 = android.webkit.WebSettings.TextSize.NORMAL
        r2.setTextSize(r4)
        r2.setDomStorageEnabled(r8)
        r2.setCacheMode(r8)
        android.webkit.WebView r2 = r6.f3997c
        r2.resumeTimers()
        android.webkit.WebView r2 = r6.f3997c
        r2.setVerticalScrollbarOverlay(r8)
        android.webkit.WebView r2 = r6.f3997c
        com.alipay.sdk.widget.i r4 = new com.alipay.sdk.widget.i
        r4.m42192init(r6)
        r2.setDownloadListener(r4)
        android.webkit.WebView r2 = r6.f3997c     // Catch:{ all -> 0x0074 }
        r2.removeJavascriptInterface(r1)     // Catch:{ all -> 0x0074 }
        android.webkit.WebView r2 = r6.f3997c     // Catch:{ all -> 0x0074 }
        r2.removeJavascriptInterface(r0)     // Catch:{ all -> 0x0074 }
        android.webkit.WebView r2 = r6.f3997c     // Catch:{ all -> 0x0074 }
        r2.removeJavascriptInterface(r7)     // Catch:{ all -> 0x0074 }
        goto L_0x009f
    L_0x0074:
        android.webkit.WebView r2 = r6.f3997c     // Catch:{ all -> 0x009f }
        java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x009f }
        java.lang.String r4 = "removeJavascriptInterface"
        java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ all -> 0x009f }
        java.lang.reflect.Method r2 = r2.getMethod(r4, r5)     // Catch:{ all -> 0x009f }
        if (r2 == 0) goto L_0x009f
        android.webkit.WebView r4 = r6.f3997c     // Catch:{ all -> 0x009f }
        java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch:{ all -> 0x009f }
        r5[r3] = r1     // Catch:{ all -> 0x009f }
        r2.invoke(r4, r5)     // Catch:{ all -> 0x009f }
        android.webkit.WebView r1 = r6.f3997c     // Catch:{ all -> 0x009f }
        java.lang.Object[] r4 = new java.lang.Object[r8]     // Catch:{ all -> 0x009f }
        r4[r3] = r0     // Catch:{ all -> 0x009f }
        r2.invoke(r1, r4)     // Catch:{ all -> 0x009f }
        android.webkit.WebView r0 = r6.f3997c     // Catch:{ all -> 0x009f }
        java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x009f }
        r8[r3] = r7     // Catch:{ all -> 0x009f }
        r2.invoke(r0, r8)     // Catch:{ all -> 0x009f }
    L_0x009f:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.widget.C1567h.m4741a(android.webkit.WebView, android.content.Context):void");
    }

    /* renamed from: a */
    public void mo12253a(String str) {
        this.f3997c.loadUrl(str);
    }
}
