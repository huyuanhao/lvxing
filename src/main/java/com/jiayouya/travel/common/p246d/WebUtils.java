package com.jiayouya.travel.common.p246d;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import com.jiayouya.travel.module.common.widget.LollipopFixedWebView;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007\u001a\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001\u001a\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0001H\u0007¨\u0006\r"}, mo39189d2 = {"addWebView", "Landroid/webkit/WebView;", "viewGroup", "Landroid/view/ViewGroup;", "index", "", "jsInterface", "", "destroyWeb", "", "webView", "initWebSettings", "web", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.d.q */
public final class WebUtils {
    /* renamed from: a */
    public static final void m12978a(WebView webView) {
        C8271i.m35386b(webView, "web");
        WebSettings settings = webView.getSettings();
        settings.setAppCacheEnabled(true);
        Context context = webView.getContext();
        String str = "web.context";
        C8271i.m35382a((Object) context, str);
        File cacheDir = context.getCacheDir();
        C8271i.m35382a((Object) cacheDir, "web.context.cacheDir");
        settings.setAppCachePath(cacheDir.getAbsolutePath());
        C8271i.m35382a((Object) settings, "settings");
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setSaveFormData(true);
        settings.setJavaScriptEnabled(true);
        settings.setTextZoom(100);
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setBlockNetworkImage(false);
        settings.setBlockNetworkLoads(false);
        settings.setRenderPriority(RenderPriority.HIGH);
        File dir = webView.getContext().getDir("database", 0);
        C8271i.m35382a((Object) dir, "web.context.getDir(\"data…e\", Context.MODE_PRIVATE)");
        settings.setDatabasePath(dir.getPath());
        Context context2 = webView.getContext();
        C8271i.m35382a((Object) context2, str);
        File filesDir = context2.getFilesDir();
        C8271i.m35382a((Object) filesDir, "web.context.filesDir");
        settings.setGeolocationDatabasePath(filesDir.getPath());
    }

    /* renamed from: b */
    public static final void m12979b(WebView webView) {
        if (webView != null) {
            ViewParent parent = webView.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(webView);
            }
            webView.stopLoading();
            WebSettings settings = webView.getSettings();
            C8271i.m35382a((Object) settings, "webView.settings");
            settings.setJavaScriptEnabled(false);
            webView.clearHistory();
            webView.clearView();
            webView.removeAllViews();
            webView.destroy();
        }
    }

    /* renamed from: a */
    public static /* synthetic */ WebView m12977a(ViewGroup viewGroup, int i, Object obj, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            i = viewGroup.getChildCount();
        }
        if ((i2 & 4) != 0) {
            obj = null;
        }
        return m12976a(viewGroup, i, obj);
    }

    /* renamed from: a */
    public static final WebView m12976a(ViewGroup viewGroup, int i, Object obj) {
        C8271i.m35386b(viewGroup, "viewGroup");
        LollipopFixedWebView lollipopFixedWebView = new LollipopFixedWebView(viewGroup.getContext());
        WebView webView = lollipopFixedWebView;
        m12978a(webView);
        viewGroup.addView(lollipopFixedWebView, i);
        LayoutParams layoutParams = lollipopFixedWebView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        lollipopFixedWebView.setLayoutParams(layoutParams);
        WebSettings settings = lollipopFixedWebView.getSettings();
        C8271i.m35382a((Object) settings, "webView.settings");
        if (settings.getJavaScriptEnabled() && obj != null) {
            lollipopFixedWebView.addJavascriptInterface(obj, "Travel");
        }
        return webView;
    }
}
