package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.TTAndroidObject;
import com.bytedance.sdk.openadsdk.downloadnew.p181a.LibHolder;
import com.bytedance.sdk.openadsdk.downloadnew.p181a.p183b.LibModelFactory;
import com.bytedance.sdk.openadsdk.p165c.LandingPageLog;
import com.bytedance.sdk.openadsdk.utils.ActivityUtil;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.bytedance.sdk.openadsdk.utils.JsBridgeUtils;
import com.bytedance.sdk.openadsdk.utils.LoadUrlUtils;
import com.tencent.p605ep.commonbase.api.ConfigManager.OEM;

/* renamed from: com.bytedance.sdk.openadsdk.core.widget.webview.c */
public class TTWebViewClient extends WebViewClient {
    /* renamed from: b */
    protected final TTAndroidObject f8417b;
    /* renamed from: c */
    protected final Context f8418c;
    /* renamed from: d */
    protected final String f8419d;
    /* renamed from: e */
    protected LandingPageLog f8420e;
    /* renamed from: f */
    protected boolean f8421f = true;
    /* renamed from: g */
    protected boolean f8422g = true;

    public TTWebViewClient(Context context, TTAndroidObject xVar, String str, LandingPageLog jVar) {
        this.f8418c = context;
        this.f8417b = xVar;
        this.f8419d = str;
        this.f8420e = jVar;
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        LandingPageLog jVar = this.f8420e;
        if (jVar != null) {
            jVar.mo15022a(webView, webResourceRequest);
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return super.shouldInterceptRequest(webView, str);
    }

    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("shouldOverrideUrlLoading ");
        sb.append(str);
        String str2 = "WebChromeClient";
        C2564t.m12220b(str2, sb.toString());
        try {
            Uri parse = Uri.parse(str);
            String lowerCase = parse.getScheme().toLowerCase();
            if ("bytedance".equals(lowerCase)) {
                JsBridgeUtils.m12207a(parse, this.f8417b);
                return true;
            }
            if (!(!OEM.MARKET.equals(lowerCase) || this.f8417b == null || this.f8417b.mo16396a() == null)) {
                if (LibHolder.m11234d().mo31439e().mo31193a(this.f8418c, parse, LibModelFactory.m11200a(this.f8417b.mo16429f(), this.f8417b.mo16396a(), null).mo31182a())) {
                    return true;
                }
            }
            if (!C2566w.m12242a(str)) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                intent.addFlags(268435456);
                ActivityUtil.m12108a(this.f8418c, intent, null);
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        } catch (Exception e) {
            C2564t.m12221b(str2, "shouldOverrideUrlLoading", e);
            TTAndroidObject xVar = this.f8417b;
            if (xVar != null && xVar.mo16420b()) {
                return true;
            }
        }
    }

    public void onPageFinished(WebView webView, String str) {
        if (C2564t.m12217a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("onPageFinished ");
            sb.append(str);
            C2564t.m12215a("WebChromeClient", sb.toString());
        }
        LandingPageLog jVar = this.f8420e;
        if (jVar != null) {
            jVar.mo15023a(webView, str);
        }
        if (webView != null && this.f8421f) {
            try {
                String a = SSWebSettings.m10855a(InternalContainer.m10069h().mo15796j(), this.f8419d);
                if (!TextUtils.isEmpty(a)) {
                    LoadUrlUtils.m12210a(webView, a);
                }
            } catch (Throwable unused) {
            }
        }
        super.onPageFinished(webView, str);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        LandingPageLog jVar = this.f8420e;
        if (jVar != null) {
            jVar.mo15024a(webView, str, bitmap);
        }
        if (this.f8422g) {
            SSWebSettings.m10854a(this.f8418c).mo16362a(VERSION.SDK_INT >= 19).mo16363a(webView);
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        LandingPageLog jVar = this.f8420e;
        if (jVar != null) {
            jVar.mo15021a(webView, i, str, str2);
        }
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        LandingPageLog jVar = this.f8420e;
        if (jVar != null && webResourceError != null) {
            jVar.mo15021a(webView, webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), null);
        }
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        LandingPageLog jVar = this.f8420e;
        if (jVar != null && webResourceResponse != null) {
            jVar.mo15021a(webView, webResourceResponse.getStatusCode(), String.valueOf(webResourceResponse.getReasonPhrase()), null);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        if (this.f8420e != null) {
            int i = 0;
            String str = "SslError: unknown";
            if (sslError != null) {
                try {
                    i = sslError.getPrimaryError();
                    StringBuilder sb = new StringBuilder();
                    sb.append("SslError: ");
                    sb.append(String.valueOf(sslError));
                    str = sb.toString();
                } catch (Throwable unused) {
                }
            }
            this.f8420e.mo15021a(webView, i, str, null);
        }
    }
}
