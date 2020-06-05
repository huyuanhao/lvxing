package com.kwad.sdk.core.page.widget.webview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.download.p323a.C4092c;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p333g.C4143b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.p306a.C3805h;
import com.kwad.sdk.p306a.C3812o;

public class KsAdWebView extends C4254b {
    /* renamed from: a */
    protected boolean f14067a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public AdTemplate f14068b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean f14069c = true;

    /* renamed from: com.kwad.sdk.core.page.widget.webview.KsAdWebView$a */
    private class C4252a implements DownloadListener {
        private C4252a() {
        }

        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            AdDownloadProxy proxyForDownload = KsAdSDK.getProxyForDownload();
            if (proxyForDownload == null || !KsAdWebView.this.f14069c) {
                try {
                    KsAdWebView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (Exception e) {
                    C4065b.m16865a(e);
                }
            } else {
                DownloadParams downloadParams = new DownloadParams();
                downloadParams.mDownloadid = C3805h.m15773a(str);
                AdInfo e2 = C4324c.m17668e(KsAdWebView.this.f14068b);
                downloadParams.mAppName = e2.adBaseInfo.appName;
                downloadParams.mPkgname = e2.adBaseInfo.appPackageName;
                downloadParams.mFileUrl = str;
                downloadParams.mAppIcon = e2.adBaseInfo.appIconUrl;
                downloadParams.mShortDesc = e2.adBaseInfo.adDescription;
                proxyForDownload.startDownload(KsAdWebView.this.getContext(), downloadParams.mDownloadid, downloadParams);
                Toast.makeText(KsAdWebView.this.getContext(), "开始下载", 0).show();
            }
        }
    }

    public KsAdWebView(Context context) {
        super(context);
        m17500h();
    }

    public KsAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17500h();
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17500h();
    }

    /* renamed from: h */
    private void m17500h() {
        WebSettings settings = getSettings();
        try {
            settings.setJavaScriptEnabled(true);
            settings.setUseWideViewPort(true);
        } catch (Exception unused) {
            mo24365a();
            settings.setJavaScriptEnabled(true);
        }
        settings.setDomStorageEnabled(true);
        setVerticalScrollBarEnabled(false);
        if (VERSION.SDK_INT >= 21) {
            getSettings().setMixedContentMode(0);
        }
        setWebViewClient(new C4255c() {
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (!KsAdWebView.this.f14067a) {
                    KsAdWebView ksAdWebView = KsAdWebView.this;
                    ksAdWebView.f14067a = true;
                    C4143b.m17148k(ksAdWebView.f14068b);
                }
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                try {
                    if (!str.startsWith("http")) {
                        if (!str.startsWith("https")) {
                            if (!str.startsWith("tel:")) {
                                if (!str.startsWith("sms:")) {
                                    int a = C4092c.m16997a(KsAdWebView.this.getContext(), str);
                                    if (a == 1) {
                                        C4143b.m17140g(KsAdWebView.this.f14068b);
                                        return true;
                                    }
                                    if (a == -1) {
                                        C4143b.m17142h(KsAdWebView.this.f14068b);
                                    }
                                    return true;
                                }
                            }
                            KsAdWebView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            return true;
                        }
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                } catch (Exception e) {
                    C4065b.m16865a(e);
                }
            }
        });
        setWebChromeClient(new C4253a() {
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
            }
        });
        setDownloadListener(new C4252a());
        String userAgentString = settings.getUserAgentString();
        StringBuilder sb = new StringBuilder();
        sb.append(userAgentString);
        sb.append(m17501i());
        settings.setUserAgentString(sb.toString());
    }

    /* renamed from: i */
    private String m17501i() {
        StringBuilder sb = new StringBuilder();
        sb.append("KSADSDK_V2.6.5.2_");
        sb.append(getContext().getPackageName());
        sb.append("_");
        sb.append(C3812o.m15844k(getContext()));
        return sb.toString();
    }

    /* renamed from: e */
    public void mo24353e() {
        C4143b.m17146j(this.f14068b);
    }

    /* renamed from: f */
    public void mo24354f() {
        mo24355g();
        C4143b.m17149l(this.f14068b);
    }

    /* renamed from: g */
    public void mo24355g() {
        if (getParent() != null && (getParent() instanceof ViewGroup)) {
            ((ViewGroup) getParent()).removeAllViews();
        }
        destroy();
    }

    public void setInsideDownloadEnable(boolean z) {
        this.f14069c = z;
    }

    public void setTemplateData(AdTemplate adTemplate) {
        this.f14068b = adTemplate;
    }
}
