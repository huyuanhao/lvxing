package com.alibaba.baichuan.trade.biz.p051b;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.baichuan.trade.biz.core.p054b.p056b.C1182a;
import com.alibaba.baichuan.trade.common.C1223b;
import com.alibaba.baichuan.trade.common.utils.C1230d;
import com.alibaba.baichuan.trade.common.utils.network.C1233a;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.alibaba.baichuan.trade.biz.b.d */
public class C1157d {
    /* renamed from: a */
    private static final String f2380a;
    /* renamed from: b */
    private static final String f2381b;
    /* renamed from: c */
    private static ArrayList<String> f2382c = new ArrayList<>();

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(" AliApp(BC/");
        sb.append(C1223b.f2467g);
        sb.append(")");
        f2380a = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" tae_sdk_");
        sb2.append(C1223b.f2467g);
        f2381b = sb2.toString();
    }

    /* renamed from: a */
    public static void m2247a(Context context, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, boolean z, C1182a aVar) {
        m2248a(webView);
        if (z) {
            webView.setWebViewClient(new C1156c(webView, webViewClient, context, aVar));
            webView.setWebChromeClient(new C1155b(webView, webChromeClient));
        }
    }

    /* renamed from: a */
    private static void m2248a(final WebView webView) {
        m2249a(webView, true);
        webView.setTag(C1230d.m2427a(C1223b.f2466f, "id", "com_taobao_nb_sdk_webview_click"), Boolean.valueOf(false));
        webView.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                webView.setTag(C1230d.m2427a(C1223b.f2466f, "id", "com_taobao_nb_sdk_webview_click"), Boolean.valueOf(true));
                return false;
            }
        });
    }

    /* renamed from: a */
    private static void m2249a(WebView webView, boolean z) {
        WebSettings settings = webView.getSettings();
        if (settings != null) {
            try {
                settings.setJavaScriptEnabled(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            settings.setSavePassword(false);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(false);
            settings.setDomStorageEnabled(true);
            settings.setAppCachePath(webView.getContext().getApplicationContext().getDir("cache", 0).getPath());
            settings.setAllowFileAccess(false);
            settings.setAppCacheEnabled(true);
            settings.setDefaultTextEncodingName("UTF-8");
            if (C1233a.m2445a(webView.getContext())) {
                settings.setCacheMode(-1);
            } else {
                settings.setCacheMode(1);
            }
            settings.setBuiltInZoomControls(false);
            if (z) {
                StringBuilder sb = new StringBuilder();
                String userAgentString = settings.getUserAgentString();
                if (userAgentString != null) {
                    sb.append(userAgentString);
                }
                sb.append(f2381b);
                sb.append(f2380a);
                sb.append(String.format(" AliBaichuan(%s/%s)", new Object[]{C1223b.f2468h, C1223b.f2469i}));
                Iterator it = f2382c.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(" ");
                    sb2.append(str);
                    sb.append(sb2.toString());
                }
                settings.setUserAgentString(sb.toString());
            }
            if (VERSION.SDK_INT >= 21) {
                CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
            }
        }
    }
}
