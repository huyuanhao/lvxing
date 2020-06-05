package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.WebSettings.LayoutAlgorithm;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.WebViewTweaker;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.bytedance.sdk.openadsdk.core.widget.webview.d */
public class WebViewPool {
    /* renamed from: c */
    private static final byte[] f8423c = new byte[0];
    /* renamed from: d */
    private static int f8424d = 10;
    /* renamed from: e */
    private static int f8425e = 3;
    /* renamed from: g */
    private static volatile WebViewPool f8426g;
    /* renamed from: a */
    private List<WeakReference<SSWebView>> f8427a;
    /* renamed from: b */
    private List<WeakReference<SSWebView>> f8428b;
    /* renamed from: f */
    private final AtomicBoolean f8429f;

    private WebViewPool() {
        this.f8427a = new ArrayList();
        this.f8428b = new ArrayList();
        this.f8429f = new AtomicBoolean(false);
        this.f8427a = new ArrayList();
        this.f8428b = new ArrayList();
    }

    /* renamed from: a */
    public static WebViewPool m10920a() {
        if (f8426g == null) {
            synchronized (WebViewPool.class) {
                if (f8426g == null) {
                    f8426g = new WebViewPool();
                }
            }
        }
        return f8426g;
    }

    /* renamed from: b */
    public void mo16393b() {
        if (!this.f8429f.getAndSet(true)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                m10922d();
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        WebViewPool.this.m10922d();
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m10922d() {
        for (int i = 0; i < f8425e; i++) {
            SSWebView sSWebView = new SSWebView(InternalContainer.m10059a());
            sSWebView.loadUrl("about:blank");
            this.f8427a.add(new WeakReference(sSWebView));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            r2 = new java.lang.ref.WeakReference<>(new com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView(com.bytedance.sdk.openadsdk.core.InternalContainer.m10059a()));
            r5.f8428b.add(r2);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x00bc */
    /* renamed from: c */
    public java.lang.ref.WeakReference<com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView> mo16394c() {
        /*
        r5 = this;
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "===start getWebView available:"
        r0.append(r1)
        java.util.List<java.lang.ref.WeakReference<com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView>> r1 = r5.f8427a
        int r1 = r1.size()
        r0.append(r1)
        java.lang.String r1 = " ,inuse:"
        r0.append(r1)
        java.util.List<java.lang.ref.WeakReference<com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView>> r1 = r5.f8428b
        int r1 = r1.size()
        r0.append(r1)
        java.lang.String r0 = r0.toString()
        java.lang.String r1 = "webviewpool"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r1, r0)
        byte[] r0 = f8423c
        monitor-enter(r0)
        java.util.List<java.lang.ref.WeakReference<com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView>> r1 = r5.f8427a     // Catch:{ Exception -> 0x00bc }
        int r1 = r1.size()     // Catch:{ Exception -> 0x00bc }
        if (r1 <= 0) goto L_0x0071
        java.util.List<java.lang.ref.WeakReference<com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView>> r1 = r5.f8427a     // Catch:{ Exception -> 0x00bc }
        r2 = 0
        java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x00bc }
        if (r1 == 0) goto L_0x0071
        java.util.List<java.lang.ref.WeakReference<com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView>> r1 = r5.f8427a     // Catch:{ Exception -> 0x00bc }
        java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x00bc }
        java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1     // Catch:{ Exception -> 0x00bc }
        java.lang.Object r3 = r1.get()     // Catch:{ Exception -> 0x00bc }
        if (r3 == 0) goto L_0x0058
        java.util.List<java.lang.ref.WeakReference<com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView>> r3 = r5.f8427a     // Catch:{ Exception -> 0x00bc }
        r3.remove(r2)     // Catch:{ Exception -> 0x00bc }
        java.util.List<java.lang.ref.WeakReference<com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView>> r2 = r5.f8428b     // Catch:{ Exception -> 0x00bc }
        r2.add(r1)     // Catch:{ Exception -> 0x00bc }
        r2 = r1
        goto L_0x0084
    L_0x0058:
        java.util.List<java.lang.ref.WeakReference<com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView>> r1 = r5.f8427a     // Catch:{ Exception -> 0x00bc }
        r1.remove(r2)     // Catch:{ Exception -> 0x00bc }
        com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView r1 = new com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView     // Catch:{ Exception -> 0x00bc }
        android.content.Context r2 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10059a()     // Catch:{ Exception -> 0x00bc }
        r1.m43916init(r2)     // Catch:{ Exception -> 0x00bc }
        java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x00bc }
        r2.<init>(r1)     // Catch:{ Exception -> 0x00bc }
        java.util.List<java.lang.ref.WeakReference<com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView>> r1 = r5.f8428b     // Catch:{ Exception -> 0x00bc }
        r1.add(r2)     // Catch:{ Exception -> 0x00bc }
        goto L_0x0084
    L_0x0071:
        com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView r1 = new com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView     // Catch:{ Exception -> 0x00bc }
        android.content.Context r2 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10059a()     // Catch:{ Exception -> 0x00bc }
        r1.m43916init(r2)     // Catch:{ Exception -> 0x00bc }
        java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x00bc }
        r2.<init>(r1)     // Catch:{ Exception -> 0x00bc }
        java.util.List<java.lang.ref.WeakReference<com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView>> r1 = r5.f8428b     // Catch:{ Exception -> 0x00bc }
        r1.add(r2)     // Catch:{ Exception -> 0x00bc }
    L_0x0084:
        java.lang.String r1 = "webviewpool"
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bc }
        r3.<init>()     // Catch:{ Exception -> 0x00bc }
        java.lang.String r4 = "===end getWebView available:"
        r3.append(r4)     // Catch:{ Exception -> 0x00bc }
        java.util.List<java.lang.ref.WeakReference<com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView>> r4 = r5.f8427a     // Catch:{ Exception -> 0x00bc }
        int r4 = r4.size()     // Catch:{ Exception -> 0x00bc }
        r3.append(r4)     // Catch:{ Exception -> 0x00bc }
        java.lang.String r4 = " ,inuse:"
        r3.append(r4)     // Catch:{ Exception -> 0x00bc }
        java.util.List<java.lang.ref.WeakReference<com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView>> r4 = r5.f8428b     // Catch:{ Exception -> 0x00bc }
        int r4 = r4.size()     // Catch:{ Exception -> 0x00bc }
        r3.append(r4)     // Catch:{ Exception -> 0x00bc }
        java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00bc }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r1, r3)     // Catch:{ Exception -> 0x00bc }
        java.lang.Object r1 = r2.get()     // Catch:{ Exception -> 0x00bc }
        com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView r1 = (com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView) r1     // Catch:{ Exception -> 0x00bc }
        java.lang.String r3 = "about:blank"
        r1.loadUrl(r3)     // Catch:{ Exception -> 0x00bc }
        goto L_0x00cf
    L_0x00ba:
        r1 = move-exception
        goto L_0x00d1
    L_0x00bc:
        com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView r1 = new com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView     // Catch:{ all -> 0x00ba }
        android.content.Context r2 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10059a()     // Catch:{ all -> 0x00ba }
        r1.m43916init(r2)     // Catch:{ all -> 0x00ba }
        java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x00ba }
        r2.<init>(r1)     // Catch:{ all -> 0x00ba }
        java.util.List<java.lang.ref.WeakReference<com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView>> r1 = r5.f8428b     // Catch:{ all -> 0x00ba }
        r1.add(r2)     // Catch:{ all -> 0x00ba }
    L_0x00cf:
        monitor-exit(r0)     // Catch:{ all -> 0x00ba }
        return r2
    L_0x00d1:
        monitor-exit(r0)     // Catch:{ all -> 0x00ba }
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.widget.webview.WebViewPool.mo16394c():java.lang.ref.WeakReference");
    }

    /* renamed from: a */
    public void mo16392a(ViewGroup viewGroup, WeakReference<SSWebView> weakReference, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("===start removeWebView available:");
        sb.append(this.f8427a.size());
        sb.append(" ,inuse:");
        sb.append(this.f8428b.size());
        C2564t.m12226e("webviewpool", sb.toString());
        if (z && weakReference != null && weakReference.get() != null) {
            try {
                SSWebView sSWebView = (SSWebView) weakReference.get();
                viewGroup.removeView(sSWebView);
                sSWebView.loadUrl("");
                sSWebView.stopLoading();
                sSWebView.setWebChromeClient(null);
                sSWebView.setWebViewClient(null);
                sSWebView.clearCache(true);
                sSWebView.clearHistory();
                sSWebView.getSettings().setJavaScriptEnabled(true);
                sSWebView.getSettings().setCacheMode(2);
                sSWebView.getSettings().setAppCacheEnabled(false);
                sSWebView.getSettings().setSupportZoom(false);
                sSWebView.getSettings().setUseWideViewPort(true);
                sSWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                sSWebView.getSettings().setDomStorageEnabled(true);
                sSWebView.getSettings().setBuiltInZoomControls(false);
                sSWebView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.NORMAL);
                sSWebView.getSettings().setLoadWithOverviewMode(false);
                sSWebView.getSettings().setUserAgentString("android_client");
                sSWebView.getSettings().setDefaultTextEncodingName("UTF-8");
                sSWebView.getSettings().setDefaultFontSize(16);
                WebViewTweaker.m9083a(InternalContainer.m10059a(), sSWebView);
                WebViewTweaker.m9084a(sSWebView);
                synchronized (f8423c) {
                    this.f8428b.remove(weakReference);
                    if (this.f8427a.size() < f8425e) {
                        SSWebView sSWebView2 = new SSWebView(InternalContainer.m10059a());
                        sSWebView2.loadUrl("about:blank");
                        this.f8427a.add(new WeakReference(sSWebView2));
                    }
                }
            } catch (Exception unused) {
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("===end removeWebView available:");
            sb2.append(this.f8427a.size());
            sb2.append(" ,inuse:");
            sb2.append(this.f8428b.size());
            C2564t.m12226e("webviewpool", sb2.toString());
        }
    }
}
