package com.alibaba.baichuan.trade.biz.core.p052a;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import com.alibaba.baichuan.trade.biz.core.p052a.C1163a.C1164a;
import com.alibaba.baichuan.trade.biz.core.p052a.p053a.C1165a;
import com.alibaba.baichuan.trade.biz.core.p052a.p053a.C1166b;
import com.alibaba.baichuan.trade.common.utils.C1224a;

/* renamed from: com.alibaba.baichuan.trade.biz.core.a.d */
public class C1171d implements Callback {
    /* renamed from: a */
    private static C1171d f2418a;
    /* renamed from: b */
    private static Handler f2419b;
    /* renamed from: c */
    private boolean f2420c = true;
    /* renamed from: d */
    private boolean f2421d;
    /* renamed from: e */
    private boolean f2422e = false;

    private C1171d() {
        f2419b = new Handler(Looper.getMainLooper(), this);
    }

    /* renamed from: a */
    public static synchronized C1171d m2292a() {
        C1171d dVar;
        synchronized (C1171d.class) {
            if (f2418a == null) {
                f2418a = new C1171d();
            }
            dVar = f2418a;
        }
        return dVar;
    }

    /* renamed from: a */
    private C1173e m2293a(String str) {
        if (str != null && str.startsWith("bchybrid:///")) {
            try {
                C1173e eVar = new C1173e();
                int indexOf = str.indexOf(58, 12);
                eVar.f2429d = str.substring(12, indexOf);
                int indexOf2 = str.indexOf(47, indexOf);
                eVar.f2432g = str.substring(indexOf + 1, indexOf2);
                int indexOf3 = str.indexOf(63, indexOf2);
                int i = indexOf2 + 1;
                if (indexOf3 > 0) {
                    eVar.f2430e = str.substring(i, indexOf3);
                    eVar.f2431f = str.substring(indexOf3 + 1);
                } else {
                    eVar.f2430e = str.substring(i);
                }
                if (eVar.f2429d.length() <= 0 || eVar.f2432g.length() <= 0 || eVar.f2430e.length() <= 0) {
                    return null;
                }
                return eVar;
            } catch (StringIndexOutOfBoundsException unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    public static void m2294a(int i, C1173e eVar) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.obj = eVar;
        f2419b.sendMessage(obtain);
    }

    /* renamed from: a */
    public static void m2296a(C1173e eVar, String str) {
        int i;
        C1165a a = C1166b.m2282a(eVar.f2429d, eVar.f2427b, eVar.f2426a);
        String str2 = "AlibcJsBridge";
        if (a == null || !(a instanceof C1165a)) {
            StringBuilder sb = new StringBuilder();
            sb.append("callMethod: Plugin ");
            sb.append(eVar.f2429d);
            sb.append(" didn't found, you should call WVPluginManager.registerPlugin first.");
            C1224a.m2405c(str2, sb.toString());
            i = 2;
        } else {
            C1224a.m2402a(str2, "call new method execute.");
            eVar.f2428c = a;
            i = 0;
        }
        m2294a(i, eVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2297b(C1173e eVar, String str) {
        String str2 = "AlibcJsBridge";
        C1224a.m2404b(str2, String.format("callMethod-obj:%s method:%s param:%s sid:%s", new Object[]{eVar.f2429d, eVar.f2430e, eVar.f2431f, eVar.f2432g}));
        if (!this.f2420c || eVar.f2426a == null) {
            C1224a.m2405c(str2, "jsbridge is closed.");
            m2294a(4, eVar);
            return;
        }
        if (!this.f2421d && C1163a.m2277a() != null && !C1163a.m2277a().isEmpty()) {
            for (C1164a a : C1163a.m2277a()) {
                if (!a.mo10729a(str, eVar.f2429d, eVar.f2430e, eVar.f2431f)) {
                    C1224a.m2405c(str2, "preprocessor call fail, callMethod cancel.");
                    m2294a(3, eVar);
                    return;
                }
            }
        }
        m2296a(eVar, str);
    }

    /* renamed from: a */
    public void mo10739a(WebView webView, int i) {
    }

    /* renamed from: a */
    public void mo10740a(WebView webView, String str) {
    }

    /* renamed from: a */
    public void mo10741a(WebView webView, String str, GeolocationPermissions.Callback callback) {
        callback.invoke(str, true, false);
    }

    /* renamed from: a */
    public void mo10742a(WebView webView, String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        if (j2 < 20971520) {
            quotaUpdater.updateQuota(j2);
        } else {
            quotaUpdater.updateQuota(j);
        }
    }

    /* renamed from: a */
    public boolean mo10743a(WebView webView, ConsoleMessage consoleMessage) {
        String message = consoleMessage.message();
        Uri parse = Uri.parse(message);
        if (message == null || !message.startsWith("bcNativeCallback")) {
            if (!"bchybrid".equals(parse.getScheme())) {
                return false;
            }
            m2292a().mo10746b(webView, message);
            return true;
        }
        String str = "/";
        String substring = message.substring(message.indexOf(str) + 1);
        int indexOf = substring.indexOf(str);
        String substring2 = substring.substring(0, indexOf);
        String substring3 = substring.substring(indexOf + 1);
        ValueCallback a = C1174f.m2307a(substring2);
        if (a != null) {
            a.onReceiveValue(substring3);
            C1174f.m2308b(substring2);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("NativeCallback failed: ");
            sb.append(substring3);
            Log.e("alibc", sb.toString());
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo10744a(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (str3 == null || !str3.equals("bc_hybrid:")) {
            return false;
        }
        m2292a().mo10746b(webView, str2);
        jsPromptResult.confirm("");
        return true;
    }

    /* renamed from: a */
    public boolean mo10745a(WebView webView, String str, String str2, String str3, JsResult jsResult) {
        if (!"bchybrid".equals(Uri.parse(str2).getScheme())) {
            return false;
        }
        m2292a().mo10746b(webView, str2);
        jsResult.confirm();
        return true;
    }

    /* renamed from: b */
    public void mo10746b(WebView webView, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("callMethod: url=");
        sb.append(str);
        String str2 = "AlibcJsBridge";
        C1224a.m2404b(str2, sb.toString());
        if (!this.f2422e) {
            C1224a.m2405c(str2, "jsbridge is not init.");
            return;
        }
        final C1173e a = m2293a(str);
        if (a == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("url format error and call canceled. url=");
            sb2.append(str);
            C1224a.m2405c(str2, sb2.toString());
            return;
        }
        a.f2426a = webView;
        final String url = webView.getUrl();
        new AsyncTask<Void, Integer, Void>() {
            /* access modifiers changed from: protected|varargs */
            /* renamed from: a */
            public Void doInBackground(Void... voidArr) {
                C1171d.this.m2297b(a, url);
                return null;
            }
        }.execute(new Void[0]);
    }

    public boolean handleMessage(Message message) {
        C1170c cVar;
        C1173e eVar = (C1173e) message.obj;
        String str = "AlibcJsBridge";
        if (eVar == null) {
            C1224a.m2406d(str, "CallMethodContext is null, and do nothing.");
            return false;
        }
        C1168b bVar = new C1168b(eVar.f2426a, eVar.f2432g, eVar.f2429d, eVar.f2430e);
        int i = message.what;
        if (i != 0) {
            if (i == 2) {
                cVar = C1170c.f2412d;
            } else if (i == 3) {
                cVar = C1170c.f2413e;
            } else if (i != 4) {
                return false;
            } else {
                cVar = C1170c.f2414f;
            }
            bVar.mo10735a(cVar);
            return true;
        }
        if (!((C1165a) eVar.f2428c).mo10732a(eVar.f2430e, TextUtils.isEmpty(eVar.f2431f) ? "{}" : eVar.f2431f, bVar)) {
            StringBuilder sb = new StringBuilder();
            sb.append("AlibcApiPlugin execute failed. method: ");
            sb.append(eVar.f2430e);
            C1224a.m2405c(str, sb.toString());
            m2294a(2, eVar);
        }
        return true;
    }
}
