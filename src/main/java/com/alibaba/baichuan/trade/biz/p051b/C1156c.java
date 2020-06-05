package com.alibaba.baichuan.trade.biz.p051b;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.baichuan.trade.biz.core.p054b.p056b.C1182a;
import com.alibaba.baichuan.trade.common.utils.C1224a;
import java.lang.ref.WeakReference;
import java.util.Stack;

/* renamed from: com.alibaba.baichuan.trade.biz.b.c */
public class C1156c extends WebViewClient {
    /* renamed from: a */
    private WeakReference<WebViewClient> f2375a;
    /* renamed from: b */
    private WeakReference<WebView> f2376b;
    /* renamed from: c */
    private Context f2377c;
    /* renamed from: d */
    private C1182a f2378d;
    /* renamed from: e */
    private final Stack<String> f2379e = new Stack<>();

    public C1156c(WebView webView, WebViewClient webViewClient, Context context, C1182a aVar) {
        this.f2375a = new WeakReference<>(webViewClient);
        this.f2376b = new WeakReference<>(webView);
        this.f2377c = context;
        this.f2378d = aVar;
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        WeakReference<WebViewClient> weakReference = this.f2375a;
        if (weakReference != null && weakReference.get() != null) {
            ((WebViewClient) this.f2375a.get()).doUpdateVisitedHistory(webView, str, z);
        }
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        WeakReference<WebViewClient> weakReference = this.f2375a;
        if (weakReference != null && weakReference.get() != null) {
            ((WebViewClient) this.f2375a.get()).onFormResubmission(webView, message, message2);
        }
    }

    public void onLoadResource(WebView webView, String str) {
        WeakReference<WebViewClient> weakReference = this.f2375a;
        if (weakReference != null && weakReference.get() != null) {
            ((WebViewClient) this.f2375a.get()).onLoadResource(webView, str);
        }
    }

    public void onPageCommitVisible(WebView webView, String str) {
        if (VERSION.SDK_INT >= 23) {
            WeakReference<WebViewClient> weakReference = this.f2375a;
            if (weakReference != null && weakReference.get() != null) {
                ((WebViewClient) this.f2375a.get()).onPageCommitVisible(webView, str);
            }
        }
    }

    public void onPageFinished(WebView webView, String str) {
        WeakReference<WebViewClient> weakReference = this.f2375a;
        if (!(weakReference == null || weakReference.get() == null)) {
            ((WebViewClient) this.f2375a.get()).onPageFinished(webView, str);
        }
        C1159e.m2255a(webView, str);
        super.onPageFinished(webView, str);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        StringBuilder sb = new StringBuilder();
        sb.append("onPageStarted: url=");
        sb.append(str);
        C1224a.m2402a("AlibcWebViewClient", sb.toString());
        WeakReference<WebViewClient> weakReference = this.f2375a;
        if (!(weakReference == null || weakReference.get() == null)) {
            ((WebViewClient) this.f2375a.get()).onPageStarted(webView, str, bitmap);
        }
        C1159e.m2256a(webView, str, bitmap);
        super.onPageStarted(webView, str, bitmap);
    }

    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        if (VERSION.SDK_INT >= 21) {
            WeakReference<WebViewClient> weakReference = this.f2375a;
            if (weakReference != null && weakReference.get() != null) {
                ((WebViewClient) this.f2375a.get()).onReceivedClientCertRequest(webView, clientCertRequest);
            }
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        WeakReference<WebViewClient> weakReference = this.f2375a;
        if (!(weakReference == null || weakReference.get() == null)) {
            ((WebViewClient) this.f2375a.get()).onReceivedError(webView, i, str, str2);
        }
        C1159e.m2253a(webView, i, str, str2);
        super.onReceivedError(webView, i, str, str2);
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        WeakReference<WebViewClient> weakReference = this.f2375a;
        if (weakReference != null && weakReference.get() != null) {
            ((WebViewClient) this.f2375a.get()).onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        if (VERSION.SDK_INT >= 23) {
            WeakReference<WebViewClient> weakReference = this.f2375a;
            if (weakReference != null && weakReference.get() != null) {
                ((WebViewClient) this.f2375a.get()).onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        }
    }

    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        if (VERSION.SDK_INT >= 23) {
            WeakReference<WebViewClient> weakReference = this.f2375a;
            if (weakReference != null && weakReference.get() != null) {
                ((WebViewClient) this.f2375a.get()).onReceivedLoginRequest(webView, str, str2, str3);
            }
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        WeakReference<WebViewClient> weakReference = this.f2375a;
        if (weakReference != null && weakReference.get() != null) {
            ((WebViewClient) this.f2375a.get()).onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    public void onScaleChanged(WebView webView, float f, float f2) {
        WeakReference<WebViewClient> weakReference = this.f2375a;
        if (weakReference != null && weakReference.get() != null) {
            ((WebViewClient) this.f2375a.get()).onScaleChanged(webView, f, f2);
        }
    }

    @Deprecated
    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        WeakReference<WebViewClient> weakReference = this.f2375a;
        if (weakReference != null && weakReference.get() != null) {
            ((WebViewClient) this.f2375a.get()).onTooManyRedirects(webView, message, message2);
        }
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        WeakReference<WebViewClient> weakReference = this.f2375a;
        if (weakReference != null && weakReference.get() != null) {
            ((WebViewClient) this.f2375a.get()).onUnhandledKeyEvent(webView, keyEvent);
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        C1224a.m2402a("AlibcWebViewClient", "shouldInterceptRequest");
        if (VERSION.SDK_INT >= 21) {
            WeakReference<WebViewClient> weakReference = this.f2375a;
            if (!(weakReference == null || weakReference.get() == null)) {
                return ((WebViewClient) this.f2375a.get()).shouldInterceptRequest(webView, webResourceRequest);
            }
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Deprecated
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("shouldInterceptRequest: url=");
        sb.append(str);
        C1224a.m2402a("AlibcWebViewClient", sb.toString());
        if (VERSION.SDK_INT > 23) {
            WeakReference<WebViewClient> weakReference = this.f2375a;
            if (!(weakReference == null || weakReference.get() == null)) {
                return ((WebViewClient) this.f2375a.get()).shouldInterceptRequest(webView, str);
            }
        }
        return super.shouldInterceptRequest(webView, str);
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        WeakReference<WebViewClient> weakReference = this.f2375a;
        return (weakReference == null || weakReference.get() == null) ? super.shouldOverrideKeyEvent(webView, keyEvent) : ((WebViewClient) this.f2375a.get()).shouldOverrideKeyEvent(webView, keyEvent);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("shouldOverrideUrlLoading 回调,参数为 webview =");
        sb.append(webView);
        sb.append("\n url = ");
        sb.append(str);
        String str2 = "AlibcWebViewClient";
        C1224a.m2404b(str2, sb.toString());
        WeakReference<WebViewClient> weakReference = this.f2375a;
        boolean shouldOverrideUrlLoading = (weakReference == null || weakReference.get() == null) ? false : ((WebViewClient) this.f2375a.get()).shouldOverrideUrlLoading(webView, str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("代理webviewClient处理 result =");
        sb2.append(shouldOverrideUrlLoading);
        C1224a.m2404b(str2, sb2.toString());
        boolean a = C1159e.m2259a(webView, str, shouldOverrideUrlLoading, this.f2378d);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("拦截器处理处理 proxyResult =");
        sb3.append(a);
        C1224a.m2404b(str2, sb3.toString());
        if (shouldOverrideUrlLoading || a) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
