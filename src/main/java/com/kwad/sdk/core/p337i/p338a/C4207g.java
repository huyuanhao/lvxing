package com.kwad.sdk.core.p337i.p338a;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.p306a.C3820v;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.i.a.g */
public class C4207g {
    /* renamed from: a */
    private final Map<String, C4201a> f13984a = new ConcurrentHashMap();
    /* renamed from: b */
    private WebView f13985b;
    /* renamed from: c */
    private C4201a f13986c = new C4204d();
    /* renamed from: d */
    private boolean f13987d;

    public C4207g(WebView webView) {
        this.f13985b = webView;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17419a(String str, String str2) {
        String str3;
        String str4 = "KSAdJSBridge";
        if (this.f13987d) {
            StringBuilder sb = new StringBuilder();
            sb.append("callJS after destroy jsInterface, ");
            sb.append(str2);
            str3 = sb.toString();
        } else if (TextUtils.isEmpty(str)) {
            str3 = "callJS callback is empty";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("callJS callback:+ ");
            sb2.append(str);
            sb2.append("--params: ");
            sb2.append(str2);
            C4065b.m16867b(str4, sb2.toString());
            WebView webView = this.f13985b;
            if (webView != null) {
                C3820v.m15877a(webView, str, str2);
                return;
            }
            return;
        }
        C4065b.m16867b(str4, str3);
    }

    /* renamed from: a */
    public void mo23982a() {
        C4065b.m16867b("KSAdJSBridge", "destroy jsInterface");
        for (Entry value : this.f13984a.entrySet()) {
            C4201a aVar = (C4201a) value.getValue();
            if (aVar != null) {
                aVar.mo23978b();
            }
        }
        this.f13987d = true;
    }

    /* renamed from: a */
    public void mo23983a(C4201a aVar) {
        String str = "KSAdJSBridge";
        if (aVar == null || TextUtils.isEmpty(aVar.mo23976a())) {
            C4065b.m16869d(str, "handler and handler'key cannot be null");
            return;
        }
        if (this.f13984a.containsKey(aVar.mo23976a())) {
            StringBuilder sb = new StringBuilder();
            sb.append("cannot register handler again, handler: ");
            sb.append(aVar.mo23976a());
            C4065b.m16869d(str, sb.toString());
        }
        this.f13984a.put(aVar.mo23976a(), aVar);
    }

    @JavascriptInterface
    public void callAdBridge(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("callAdBridge ==");
        sb.append(str);
        String str2 = "KSAdJSBridge";
        C4065b.m16867b(str2, sb.toString());
        try {
            final C4202b bVar = new C4202b();
            bVar.mo23979a(new JSONObject(str));
            C4201a aVar = (C4201a) this.f13984a.get(bVar.f13977a);
            if (aVar == null) {
                aVar = this.f13986c;
            }
            if (aVar != null) {
                aVar.mo23977a(bVar.f13978b, !TextUtils.isEmpty(bVar.f13979c) ? new C4203c() {
                    /* renamed from: a */
                    public void mo23980a(int i, String str) {
                        C4207g.this.m17419a(bVar.f13979c, new C4205e(i, str).toJson().toString());
                    }

                    /* renamed from: a */
                    public void mo23981a(C4321b bVar) {
                        C4207g.this.m17419a(bVar.f13979c, new C4206f(bVar).toJson().toString());
                    }
                } : new C4203c() {
                    /* renamed from: a */
                    public void mo23980a(int i, String str) {
                    }

                    /* renamed from: a */
                    public void mo23981a(C4321b bVar) {
                    }
                });
            } else {
                C4065b.m16869d(str2, "bridgeHandler is null");
            }
        } catch (JSONException e) {
            C4065b.m16865a(e);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("callAdBridge JSONException:");
            sb2.append(e);
            C4065b.m16869d(str2, sb2.toString());
        }
    }
}
