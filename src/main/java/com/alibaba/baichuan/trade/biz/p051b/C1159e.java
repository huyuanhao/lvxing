package com.alibaba.baichuan.trade.biz.p051b;

import android.graphics.Bitmap;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import com.alibaba.baichuan.trade.biz.core.p052a.C1171d;
import com.alibaba.baichuan.trade.biz.core.p054b.p056b.C1182a;
import com.alibaba.baichuan.trade.common.utils.C1224a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.alibaba.baichuan.trade.biz.b.e */
public class C1159e {
    /* renamed from: a */
    private static List<C1160a> f2384a = new ArrayList();
    /* renamed from: b */
    private static List<C1161b> f2385b = new ArrayList();

    /* renamed from: com.alibaba.baichuan.trade.biz.b.e$a */
    public interface C1160a {
        /* renamed from: a */
        void mo10713a(WebView webView, int i);

        /* renamed from: a */
        void mo10714a(WebView webView, String str);

        /* renamed from: a */
        void mo10715a(WebView webView, String str, Callback callback);

        /* renamed from: a */
        void mo10716a(WebView webView, String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater);

        /* renamed from: a */
        boolean mo10717a(WebView webView, ConsoleMessage consoleMessage, boolean z);

        /* renamed from: a */
        boolean mo10718a(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult, boolean z);

        /* renamed from: a */
        boolean mo10719a(WebView webView, String str, String str2, String str3, JsResult jsResult, boolean z);
    }

    /* renamed from: com.alibaba.baichuan.trade.biz.b.e$b */
    public interface C1161b {
        /* renamed from: a */
        void mo10720a(WebView webView, int i, String str, String str2);

        /* renamed from: a */
        void mo10721a(WebView webView, String str);

        /* renamed from: a */
        void mo10722a(WebView webView, String str, Bitmap bitmap);

        /* renamed from: a */
        boolean mo10723a(WebView webView, String str, boolean z);
    }

    /* renamed from: a */
    public static void m2250a(WebView webView, int i) {
        C1171d.m2292a().mo10739a(webView, i);
        for (C1160a a : f2384a) {
            a.mo10713a(webView, i);
        }
    }

    /* renamed from: a */
    public static void m2251a(WebView webView, String str, Callback callback) {
        C1171d.m2292a().mo10741a(webView, str, callback);
        for (C1160a a : f2384a) {
            a.mo10715a(webView, str, callback);
        }
    }

    /* renamed from: a */
    public static void m2252a(WebView webView, String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        C1171d.m2292a().mo10742a(webView, str, str2, j, j2, j3, quotaUpdater);
        for (C1160a a : f2384a) {
            a.mo10716a(webView, str, str2, j, j2, j3, quotaUpdater);
        }
    }

    /* renamed from: a */
    public static boolean m2253a(WebView webView, int i, String str, String str2) {
        for (C1161b a : f2385b) {
            a.mo10720a(webView, i, str, str2);
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m2254a(WebView webView, ConsoleMessage consoleMessage, boolean z) {
        boolean a = !z ? C1171d.m2292a().mo10743a(webView, consoleMessage) : false;
        for (C1160a aVar : f2384a) {
            boolean z2 = a || z;
            aVar.mo10717a(webView, consoleMessage, z2);
        }
        return a;
    }

    /* renamed from: a */
    public static boolean m2255a(WebView webView, String str) {
        for (C1161b a : f2385b) {
            a.mo10721a(webView, str);
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m2256a(WebView webView, String str, Bitmap bitmap) {
        for (C1161b a : f2385b) {
            a.mo10722a(webView, str, bitmap);
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m2257a(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult, boolean z) {
        boolean a = !z ? C1171d.m2292a().mo10744a(webView, str, str2, str3, jsPromptResult) : false;
        for (C1160a aVar : f2384a) {
            boolean z2 = a || z;
            aVar.mo10718a(webView, str, str2, str3, jsPromptResult, z2);
        }
        return a;
    }

    /* renamed from: a */
    public static boolean m2258a(WebView webView, String str, String str2, String str3, JsResult jsResult, boolean z) {
        boolean a = !z ? C1171d.m2292a().mo10745a(webView, str, str2, str3, jsResult) : false;
        for (C1160a aVar : f2384a) {
            boolean z2 = a || z;
            aVar.mo10719a(webView, str, str2, str3, jsResult, z2);
        }
        return a;
    }

    /* renamed from: a */
    public static boolean m2259a(WebView webView, String str, boolean z, C1182a aVar) {
        C1224a.m2402a("AlibcWebViewService", "shouldOverrideUrlLoading");
        boolean a = !z ? C1151a.m2244a(webView, str, aVar) : false;
        for (C1161b bVar : f2385b) {
            boolean z2 = a || z;
            bVar.mo10723a(webView, str, z2);
        }
        return a;
    }

    /* renamed from: b */
    public static void m2260b(WebView webView, String str) {
        C1171d.m2292a().mo10740a(webView, str);
        for (C1160a a : f2384a) {
            a.mo10714a(webView, str);
        }
    }
}
