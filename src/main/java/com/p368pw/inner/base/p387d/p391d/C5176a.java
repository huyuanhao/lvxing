package com.p368pw.inner.base.p387d.p391d;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebView.PictureListener;
import android.webkit.WebViewClient;
import com.p368pw.inner.C5233e;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5207q;
import com.p368pw.inner.base.p387d.C5213t;
import com.tencent.mid.sotrage.StorageInterface;

/* renamed from: com.pw.inner.base.d.d.a */
public class C5176a extends WebView {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public C5183b f16869a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public C5181a f16870b;
    /* access modifiers changed from: private|volatile */
    /* renamed from: c */
    public volatile boolean f16871c;

    /* renamed from: com.pw.inner.base.d.d.a$a */
    public static class C5181a {
        protected String overrideDeepLink;

        public void onPageFinished(WebView webView, String str) {
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!C5207q.m21478b((CharSequence) str) || str.startsWith("https://") || str.startsWith("http://")) {
                return false;
            }
            this.overrideDeepLink = str;
            webView.loadUrl("video://open");
            return true;
        }
    }

    /* renamed from: com.pw.inner.base.d.d.a$b */
    private static class C5182b extends C5181a {
        private C5182b() {
        }

        public void onPageFinished(WebView webView, String str) {
            C5205o.m21462a(str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            C5205o.m21462a(str);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            C5205o.m21462a(str);
            if (!str.startsWith("http://") && !str.startsWith("https://")) {
                try {
                    Intent parseUri = Intent.parseUri(str, 0);
                    parseUri.setFlags(268435456);
                    C5233e.m21559b().startActivity(parseUri);
                    C5205o.m21462a("用deeplink打开第三方app");
                    return true;
                } catch (Throwable th) {
                    C5205o.m21464a(th);
                }
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    public C5176a(Context context, C5181a aVar) {
        super(context);
        if (aVar == null) {
            aVar = new C5182b();
        }
        this.f16870b = aVar;
        m21355a();
    }

    /* renamed from: a */
    private void m21355a() {
        setOnTouchListener(new C5184c(getContext()) {
            /* renamed from: a */
            public void mo26787a(C5183b bVar) {
                C5176a.this.f16869a = bVar;
            }
        });
        setBackgroundColor(0);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setSupportZoom(false);
        settings.setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setBlockNetworkImage(false);
        settings.setCacheMode(1);
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        setScrollBarStyle(33554432);
        setWebChromeClient(new WebChromeClient() {
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                StringBuilder sb = new StringBuilder();
                sb.append("onConsoleMessage:");
                sb.append(consoleMessage.message());
                C5205o.m21462a(sb.toString());
                return super.onConsoleMessage(consoleMessage);
            }

            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                jsResult.confirm();
                return super.onJsAlert(webView, str, str2, jsResult);
            }

            public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
                jsResult.confirm();
                return super.onJsBeforeUnload(webView, str, str2, jsResult);
            }

            public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
                jsResult.confirm();
                return super.onJsConfirm(webView, str, str2, jsResult);
            }

            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                jsPromptResult.confirm();
                return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }

            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (i == 100 && webView != null && !C5176a.this.f16871c) {
                    C5205o.m21462a("通过onProgressChanged，回调onPageFinished");
                    C5176a.this.f16871c = true;
                    C5176a.this.f16870b.onPageFinished(webView, webView.getUrl());
                }
            }
        });
        setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView webView, String str) {
                if (!C5176a.this.f16871c) {
                    C5176a.this.f16871c = true;
                    C5176a.this.f16870b.onPageFinished(webView, str);
                }
                super.onPageFinished(webView, str);
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                C5176a.this.f16871c = false;
                C5176a.this.f16870b.onPageStarted(webView, str, bitmap);
                super.onPageStarted(webView, str, bitmap);
            }

            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (VERSION.SDK_INT >= 23 && webResourceError != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onReceivedError,code:");
                    sb.append(webResourceError.getErrorCode());
                    sb.append(",des:");
                    sb.append(webResourceError.getDescription());
                    C5205o.m21462a(sb.toString());
                }
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }

            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (VERSION.SDK_INT >= 21 && webResourceResponse != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onReceivedHttpError,url:");
                    sb.append(webResourceRequest.getUrl());
                    sb.append(",code:");
                    sb.append(webResourceResponse.getStatusCode());
                    sb.append(StorageInterface.KEY_SPLITER);
                    sb.append(C5213t.m21485a(webResourceResponse.getData()));
                    C5205o.m21462a(sb.toString());
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                try {
                    int primaryError = sslError.getPrimaryError();
                    if (!(primaryError == 0 || primaryError == 1 || primaryError == 2 || primaryError == 3)) {
                        if (primaryError == 4) {
                            sslErrorHandler.proceed();
                            return;
                        } else if (primaryError != 5) {
                            sslErrorHandler.cancel();
                            return;
                        }
                    }
                    sslErrorHandler.cancel();
                } catch (Throwable th) {
                    C5205o.m21464a(th);
                }
            }

            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                if (VERSION.SDK_INT >= 26 && renderProcessGoneDetail != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onRenderProcessGone,didCrash:");
                    sb.append(renderProcessGoneDetail.didCrash());
                    C5205o.m21462a(sb.toString());
                }
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return C5176a.this.f16870b.shouldOverrideUrlLoading(webView, str);
            }
        });
        setPictureListener(new PictureListener() {
            public void onNewPicture(WebView webView, Picture picture) {
                if (!C5176a.this.f16871c) {
                    C5205o.m21462a("通过onNewPicture，回调onPageFinished");
                    C5176a.this.f16871c = true;
                    C5176a.this.f16870b.onPageFinished(webView, webView.getUrl());
                }
            }
        });
    }

    public C5183b getClickLocation() {
        return this.f16869a;
    }
}
