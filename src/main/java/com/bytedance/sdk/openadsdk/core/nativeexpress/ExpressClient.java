package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.core.TTAndroidObject;
import com.bytedance.sdk.openadsdk.core.p170d.Image;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.widget.webview.TTWebViewClient;
import com.bytedance.sdk.openadsdk.core.widget.webview.p179a.TTDynamic;
import com.bytedance.sdk.openadsdk.core.widget.webview.p179a.UrlUtils;
import com.bytedance.sdk.openadsdk.core.widget.webview.p179a.UrlUtils.C2372a;
import com.bytedance.sdk.openadsdk.p188g.p189a.GifCache;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

/* renamed from: com.bytedance.sdk.openadsdk.core.nativeexpress.f */
public class ExpressClient extends TTWebViewClient {
    /* renamed from: a */
    private MaterialMeta f7831a;

    public ExpressClient(Context context, TTAndroidObject xVar, MaterialMeta kVar) {
        super(context, xVar, kVar.mo15425M(), null);
        this.f7831a = kVar;
    }

    /* JADX WARNING: type inference failed for: r4v1, types: [android.webkit.WebView] */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView r4, android.webkit.WebResourceRequest r5) {
        /*
        r3 = this;
        android.net.Uri r0 = r5.getUrl()     // Catch:{ all -> 0x000d }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x000d }
        android.webkit.WebResourceResponse r4 = r3.shouldInterceptRequest(r4, r0)     // Catch:{ all -> 0x000d }
        return r4
    L_0x000d:
        r0 = move-exception
        java.lang.String r1 = "ExpressClient"
        java.lang.String r2 = "shouldInterceptRequest error1"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12223c(r1, r2, r0)
        android.webkit.WebResourceResponse r4 = super.shouldInterceptRequest(r4, r5)
        return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.ExpressClient.shouldInterceptRequest(android.webkit.WebView, android.webkit.WebResourceRequest):android.webkit.WebResourceResponse");
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            WebResourceResponse a = m10017a(webView, str);
            if (a != null) {
                return a;
            }
        } catch (Throwable th) {
            C2564t.m12223c("ExpressClient", "shouldInterceptRequest error2", th);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    public void onPageFinished(WebView webView, String str) {
        this.f8421f = false;
        super.onPageFinished(webView, str);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.f8422g = false;
        super.onPageStarted(webView, str, bitmap);
    }

    /* renamed from: a */
    private WebResourceResponse m10017a(WebView webView, String str) {
        Image jVar = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C2372a a = UrlUtils.m10910a(str);
        if (a != C2372a.IMAGE) {
            Iterator it = this.f7831a.mo15418F().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Image jVar2 = (Image) it.next();
                if (!TextUtils.isEmpty(jVar2.mo15406a()) && !TextUtils.isEmpty(str)) {
                    String a2 = jVar2.mo15406a();
                    String str2 = "https";
                    String str3 = "http";
                    if (a2.startsWith(str2)) {
                        a2 = a2.replaceFirst(str2, str3);
                    }
                    if ((str.startsWith(str2) ? str.replaceFirst(str2, str3) : str).equals(a2)) {
                        jVar = jVar2;
                        break;
                    }
                }
            }
        }
        if (a == C2372a.IMAGE || jVar != null) {
            return m10018a(str);
        }
        return TTDynamic.m10861a(str, a);
    }

    /* renamed from: a */
    private WebResourceResponse m10018a(String str) {
        WebResourceResponse webResourceResponse = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            File a = GifCache.m11369a().mo16624a(GifCache.m11369a().mo16625a(str, 0, 0, null));
            if (a != null && a.exists() && a.length() > 0) {
                webResourceResponse = new WebResourceResponse(C2372a.IMAGE.mo16385a(), "utf-8", new FileInputStream(a));
            }
        } catch (Throwable th) {
            C2564t.m12223c("ExpressClient", "get image WebResourceResponse error", th);
        }
        return webResourceResponse;
    }
}
