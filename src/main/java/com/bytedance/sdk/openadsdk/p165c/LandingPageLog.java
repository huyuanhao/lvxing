package com.bytedance.sdk.openadsdk.p165c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p170d.BackHtmlModel;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p174h.TTSdkSettings;
import com.bytedance.sdk.openadsdk.core.widget.webview.p179a.UrlUtils;
import com.bytedance.sdk.openadsdk.core.widget.webview.p179a.UrlUtils.C2372a;
import com.bytedance.sdk.openadsdk.p185f.StatsLogManager;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.bytedance.sdk.openadsdk.utils.LoadUrlUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.c.j */
public class LandingPageLog {
    /* renamed from: a */
    private int f6775a = 1;
    /* renamed from: b */
    private boolean f6776b = false;
    /* renamed from: c */
    private boolean f6777c = false;
    /* renamed from: d */
    private boolean f6778d = false;
    /* renamed from: e */
    private int f6779e = -1;
    /* renamed from: f */
    private String f6780f;
    /* renamed from: g */
    private final Context f6781g;
    /* renamed from: h */
    private final MaterialMeta f6782h;
    /* renamed from: i */
    private String f6783i = "landingpage";
    /* renamed from: j */
    private long f6784j = 0;
    /* renamed from: k */
    private long f6785k = 0;
    /* renamed from: l */
    private long f6786l = 0;
    /* renamed from: m */
    private long f6787m = 0;
    /* renamed from: n */
    private boolean f6788n = false;
    /* access modifiers changed from: private */
    /* renamed from: o */
    public AtomicInteger f6789o = new AtomicInteger(0);
    /* access modifiers changed from: private */
    /* renamed from: p */
    public WebView f6790p;
    /* renamed from: q */
    private boolean f6791q = false;
    /* renamed from: r */
    private AtomicInteger f6792r = new AtomicInteger(0);
    /* access modifiers changed from: private */
    /* renamed from: s */
    public List<BackHtmlModel> f6793s;
    /* access modifiers changed from: private */
    /* renamed from: t */
    public ConcurrentHashMap<String, BackHtmlModel> f6794t;
    /* access modifiers changed from: private */
    /* renamed from: u */
    public String f6795u = "";
    /* renamed from: v */
    private JSONObject f6796v;

    /* compiled from: LandingPageLog */
    /* renamed from: com.bytedance.sdk.openadsdk.c.j$a */
    private class C2089a {
        private C2089a() {
        }

        @JavascriptInterface
        public void readPercent(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("measure height: ");
            int i = 0;
            sb.append(LandingPageLog.this.f6790p == null ? 0 : LandingPageLog.this.f6790p.getMeasuredHeight());
            String str2 = "LandingPageLog";
            C2564t.m12220b(str2, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("read percent: ");
            sb2.append(String.valueOf(str));
            C2564t.m12220b(str2, sb2.toString());
            try {
                int intValue = Float.valueOf(str).intValue();
                if (intValue > 100) {
                    i = 100;
                } else if (intValue >= 0) {
                    i = intValue;
                }
            } catch (Throwable unused) {
            }
            LandingPageLog.this.f6789o.set(i);
        }

        @JavascriptInterface
        public String getUrl() {
            return LandingPageLog.this.f6795u;
        }

        @JavascriptInterface
        public void readHtml(String str, String str2) {
            BackHtmlModel cVar;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (LandingPageLog.this.f6794t == null) {
                    LandingPageLog.this.f6794t = new ConcurrentHashMap();
                }
                if (LandingPageLog.this.f6794t.containsKey(str)) {
                    cVar = (BackHtmlModel) LandingPageLog.this.f6794t.get(str);
                } else {
                    BackHtmlModel cVar2 = new BackHtmlModel();
                    LandingPageLog.this.f6794t.put(str, cVar2);
                    cVar2.mo15355a(str);
                    cVar = cVar2;
                }
                cVar.mo15357b(str2);
                if (LandingPageLog.this.f6793s == null) {
                    LandingPageLog.this.f6793s = new ArrayList();
                }
                LandingPageLog.this.f6793s.add(cVar);
            }
        }
    }

    public LandingPageLog(Context context, MaterialMeta kVar, WebView webView) {
        this.f6781g = context;
        this.f6782h = kVar;
        this.f6790p = webView;
        this.f6793s = new ArrayList();
        this.f6794t = new ConcurrentHashMap<>();
        if (VERSION.SDK_INT >= 19) {
            this.f6790p.addJavascriptInterface(new C2089a(), "JS_LANDING_PAGE_LOG_OBJ");
        }
    }

    /* renamed from: a */
    public void mo15025a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f6783i = str;
        }
    }

    /* renamed from: a */
    public void mo15026a(JSONObject jSONObject) {
        this.f6796v = jSONObject;
    }

    /* renamed from: a */
    public LandingPageLog mo15018a(boolean z) {
        this.f6791q = z;
        return this;
    }

    /* renamed from: a */
    public void mo15020a(WebView webView, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("onWebProgress: ");
        sb.append(i);
        C2564t.m12220b("LandingPageLog", sb.toString());
        if (this.f6786l == 0 && i > 0) {
            this.f6786l = System.currentTimeMillis();
        } else if (this.f6787m == 0 && i == 100) {
            this.f6787m = System.currentTimeMillis();
        }
    }

    /* renamed from: a */
    public void mo15024a(WebView webView, String str, Bitmap bitmap) {
        StringBuilder sb = new StringBuilder();
        sb.append("onWebStarted: ");
        sb.append(String.valueOf(str));
        C2564t.m12220b("LandingPageLog", sb.toString());
        if (!this.f6776b) {
            this.f6776b = true;
            m8475a("load_start", new JSONObject());
        }
    }

    /* renamed from: a */
    public void mo15023a(WebView webView, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("onWebFinished: ");
        sb.append(String.valueOf(str));
        C2564t.m12220b("LandingPageLog", sb.toString());
        if (webView != null && !this.f6788n) {
            this.f6788n = true;
            LoadUrlUtils.m12210a(webView, "javascript:\nfunction sendScroll(){\n   var totalH = document.body.scrollHeight || document.documentElement.scrollHeight;\n   var clientH = window.innerHeight || document.documentElement.clientHeight;\n   var scrollH = document.body.scrollTop || document.documentElement.scrollTop;\n   var validH = scrollH + clientH;\n   var result = (validH/totalH*100).toFixed(2);\n   console.log('LandingPageLogscroll status: (' + scrollH + '+' + clientH + ')/' + totalH + '=' + result);\n   window.JS_LANDING_PAGE_LOG_OBJ.readPercent(result);\n}\nsendScroll();\nwindow.addEventListener('scroll', function(e){\n    sendScroll();\n});");
            if (m8477b(str)) {
                this.f6795u = str;
                LoadUrlUtils.m12210a(webView, "javascript:var url = window.JS_LANDING_PAGE_LOG_OBJ.getUrl();window.JS_LANDING_PAGE_LOG_OBJ.readHtml(url,document.documentElement.outerHTML);");
                this.f6792r.incrementAndGet();
            }
        }
        if (this.f6775a != 3) {
            this.f6775a = 2;
        }
        if (this.f6775a == 2) {
            long j = this.f6787m - this.f6786l;
            if (!this.f6777c) {
                this.f6777c = true;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("load_duration", j);
                } catch (Exception unused) {
                }
                m8475a("load_finish", jSONObject);
            }
        } else if (!this.f6778d) {
            this.f6778d = true;
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("error_code", this.f6779e);
                jSONObject2.put("error_msg", this.f6780f);
            } catch (Exception unused2) {
            }
            m8475a("load_fail", jSONObject2);
        }
    }

    /* renamed from: a */
    public void mo15021a(WebView webView, int i, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("onWebError: ");
        sb.append(i);
        String str3 = ", ";
        sb.append(str3);
        sb.append(String.valueOf(str));
        sb.append(str3);
        sb.append(String.valueOf(str2));
        C2564t.m12220b("LandingPageLog", sb.toString());
        this.f6775a = 3;
        this.f6779e = i;
        this.f6780f = str;
    }

    /* renamed from: a */
    public void mo15019a() {
        C2564t.m12220b("LandingPageLog", "onResume");
        this.f6784j = System.currentTimeMillis();
    }

    /* renamed from: b */
    public void mo15027b() {
        C2564t.m12220b("LandingPageLog", "onStop");
        int i = 0;
        boolean z = this.f6775a == 2;
        this.f6785k = System.currentTimeMillis();
        long j = this.f6785k - this.f6784j;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_status", this.f6775a);
            jSONObject.put("stay_page_duration", j);
            String str = "max_scroll_percent";
            if (z) {
                i = this.f6789o.get();
            }
            jSONObject.put(str, i);
        } catch (JSONException unused) {
        }
        m8475a("landing_close", jSONObject);
    }

    /* renamed from: c */
    public void mo15028c() {
        C2564t.m12220b("LandingPageLog", "onDestroy");
        m8480d();
        this.f6790p = null;
    }

    /* renamed from: a */
    public void mo15022a(WebView webView, WebResourceRequest webResourceRequest) {
        BackHtmlModel cVar;
        if (webResourceRequest != null && !TextUtils.isEmpty(webResourceRequest.getUrl().toString())) {
            String uri = webResourceRequest.getUrl().toString();
            if (m8477b(uri)) {
                if (this.f6794t == null) {
                    this.f6794t = new ConcurrentHashMap<>();
                }
                if (this.f6794t.containsKey(uri)) {
                    cVar = (BackHtmlModel) this.f6794t.get(uri);
                } else {
                    BackHtmlModel cVar2 = new BackHtmlModel();
                    this.f6794t.put(uri, cVar2);
                    cVar2.mo15355a(uri);
                    cVar = cVar2;
                }
                cVar.mo15356a(webResourceRequest.getRequestHeaders());
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:9|10|11|(1:13)(1:14)|15|(1:17)(1:18)|19|20|21|22|(2:23|24)|25) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0039 */
    /* renamed from: a */
    private void m8475a(java.lang.String r7, org.json.JSONObject r8) {
        /*
        r6 = this;
        boolean r0 = r6.f6791q
        if (r0 != 0) goto L_0x0005
        return
    L_0x0005:
        com.bytedance.sdk.openadsdk.core.d.k r0 = r6.f6782h
        if (r0 == 0) goto L_0x0085
        boolean r0 = android.text.TextUtils.isEmpty(r7)
        if (r0 == 0) goto L_0x0011
        goto L_0x0085
    L_0x0011:
        r0 = 0
        if (r8 == 0) goto L_0x0048
        java.lang.String r1 = "is_playable"
        com.bytedance.sdk.openadsdk.core.d.k r2 = r6.f6782h     // Catch:{ JSONException -> 0x0039 }
        boolean r2 = r2.mo15503q()     // Catch:{ JSONException -> 0x0039 }
        r3 = 1
        r4 = 0
        if (r2 == 0) goto L_0x0022
        r2 = 1
        goto L_0x0023
    L_0x0022:
        r2 = 0
    L_0x0023:
        r8.put(r1, r2)     // Catch:{ JSONException -> 0x0039 }
        java.lang.String r1 = "usecache"
        com.bytedance.sdk.openadsdk.core.g.a r2 = com.bytedance.sdk.openadsdk.core.p173g.PlayableCache.m9577a()     // Catch:{ JSONException -> 0x0039 }
        com.bytedance.sdk.openadsdk.core.d.k r5 = r6.f6782h     // Catch:{ JSONException -> 0x0039 }
        boolean r2 = r2.mo15643a(r5)     // Catch:{ JSONException -> 0x0039 }
        if (r2 == 0) goto L_0x0035
        goto L_0x0036
    L_0x0035:
        r3 = 0
    L_0x0036:
        r8.put(r1, r3)     // Catch:{ JSONException -> 0x0039 }
    L_0x0039:
        org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0048 }
        r1.<init>()     // Catch:{ JSONException -> 0x0048 }
        java.lang.String r0 = "ad_extra_data"
        java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x0047 }
        r1.put(r0, r8)     // Catch:{ JSONException -> 0x0047 }
    L_0x0047:
        r0 = r1
    L_0x0048:
        java.lang.StringBuilder r8 = new java.lang.StringBuilder
        r8.<init>()
        java.lang.String r1 = "sendEvent: "
        r8.append(r1)
        java.lang.String r1 = r6.f6783i
        java.lang.String r1 = java.lang.String.valueOf(r1)
        r8.append(r1)
        java.lang.String r1 = ", "
        r8.append(r1)
        java.lang.String r1 = java.lang.String.valueOf(r7)
        r8.append(r1)
        java.lang.String r1 = ", ext="
        r8.append(r1)
        java.lang.String r1 = java.lang.String.valueOf(r0)
        r8.append(r1)
        java.lang.String r8 = r8.toString()
        java.lang.String r1 = "LandingPageLog"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r1, r8)
        android.content.Context r8 = r6.f6781g
        com.bytedance.sdk.openadsdk.core.d.k r1 = r6.f6782h
        java.lang.String r2 = r6.f6783i
        com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8399b(r8, r1, r2, r7, r0)
    L_0x0085:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.p165c.LandingPageLog.m8475a(java.lang.String, org.json.JSONObject):void");
    }

    /* renamed from: b */
    private boolean m8477b(String str) {
        if (!TextUtils.isEmpty(str)) {
            MaterialMeta kVar = this.f6782h;
            if (kVar == null || kVar.mo15499m() == 0 || UrlUtils.m10910a(str) != C2372a.HTML) {
                return false;
            }
            TTSdkSettings h = InternalContainer.m10069h();
            if (h != null && h.mo15805o() > this.f6792r.get()) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* renamed from: d */
    private void m8480d() {
        List<BackHtmlModel> list = this.f6793s;
        if (list != null && list.size() != 0 && (!InternalContainer.m10069h().mo15817v() || C2566w.m12244c(InternalContainer.m10059a()) == 4)) {
            StatsLogManager.m11278a().mo16567a(this.f6793s, this.f6782h, this.f6796v);
        }
    }
}
