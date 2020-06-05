package com.kwad.sdk.p307b;

import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.kwad.sdk.core.download.p323a.C4089b;
import com.kwad.sdk.core.p317a.C4058b;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p337i.C4200a;
import com.kwad.sdk.core.p337i.p338a.C4207g;
import com.kwad.sdk.core.p337i.p339b.C4210a;
import com.kwad.sdk.core.p337i.p339b.C4212b;
import com.kwad.sdk.core.p337i.p339b.C4214c;
import com.kwad.sdk.core.p337i.p339b.C4216d;
import com.kwad.sdk.core.p337i.p339b.C4218e;
import com.kwad.sdk.core.p337i.p339b.C4220f;
import com.kwad.sdk.core.p337i.p339b.C4220f.C4221a;
import com.kwad.sdk.core.p337i.p339b.C4222g;
import com.kwad.sdk.core.p337i.p339b.C4224h;
import com.kwad.sdk.core.p337i.p339b.C4224h.C4226b;
import com.kwad.sdk.core.p337i.p339b.C4227i;
import com.kwad.sdk.core.p337i.p339b.C4229j;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4323b;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.p306a.C3817t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.b.a */
public class C3823a {
    /* renamed from: a */
    private AdBaseFrameLayout f12942a;
    /* renamed from: b */
    private FrameLayout f12943b;
    /* renamed from: c */
    private FrameLayout f12944c;
    /* renamed from: d */
    private WebView f12945d;
    /* renamed from: e */
    private JSONObject f12946e;
    /* renamed from: f */
    private int f12947f;
    /* renamed from: g */
    private AdTemplate f12948g;
    /* renamed from: h */
    private C4089b f12949h;
    /* renamed from: i */
    private C3826a f12950i;
    /* renamed from: j */
    private C4207g f12951j;
    /* renamed from: k */
    private C4200a f12952k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public int f12953l = -1;
    /* renamed from: m */
    private C4227i f12954m;
    /* renamed from: n */
    private C4221a f12955n = new C4221a() {
        /* renamed from: a */
        public void mo23223a() {
            C3823a.this.mo23221c();
        }
    };
    /* renamed from: o */
    private C4226b f12956o = new C4226b() {
        /* renamed from: a */
        public void mo23224a(int i) {
            C3823a.this.f12953l = i;
            StringBuilder sb = new StringBuilder();
            sb.append("updatePageStatus mPageState: ");
            sb.append(i);
            C4065b.m16867b("PlayEndWebCard", sb.toString());
        }
    };

    /* renamed from: com.kwad.sdk.b.a$a */
    public interface C3826a {
        /* renamed from: a */
        void mo23225a();
    }

    public C3823a() {
    }

    public C3823a(JSONObject jSONObject) {
        this.f12946e = jSONObject;
    }

    /* renamed from: a */
    private void m15880a(WebSettings webSettings) {
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        webSettings.setAllowFileAccess(false);
        if (VERSION.SDK_INT >= 21) {
            webSettings.setMixedContentMode(0);
        }
        if (VERSION.SDK_INT < 19) {
            this.f12945d.removeJavascriptInterface("searchBoxJavaBridge_");
            this.f12945d.removeJavascriptInterface("accessibility");
            this.f12945d.removeJavascriptInterface("accessibilityTraversal");
        }
        this.f12945d.setSaveEnabled(false);
    }

    /* renamed from: a */
    private void m15881a(C4207g gVar) {
        gVar.mo23983a(new C4214c());
        gVar.mo23983a(new C4210a(this.f12952k, this.f12949h, this.f12950i));
        gVar.mo23983a(new C4216d(this.f12952k));
        gVar.mo23983a(new C4218e(this.f12952k));
        gVar.mo23983a(new C4212b(this.f12952k));
        gVar.mo23983a(new C4224h(this.f12956o));
        this.f12954m = new C4227i();
        gVar.mo23983a(this.f12954m);
        gVar.mo23983a(new C4229j(this.f12952k, this.f12949h));
        gVar.mo23983a(new C4220f(this.f12955n));
        gVar.mo23983a(new C4222g(this.f12952k));
    }

    /* renamed from: e */
    private void m15882e() {
        this.f12943b.removeAllViews();
        this.f12943b.setVisibility(4);
        C3817t.m15864a((ViewGroup) this.f12943b, "ksad_ad_web_card_layout", true);
        this.f12945d = (WebView) C3817t.m15863a((View) this.f12943b, "ksad_web_card_webView");
        this.f12945d.setBackgroundColor(0);
        this.f12945d.getBackground().setAlpha(0);
        this.f12944c = (FrameLayout) C3817t.m15863a((View) this.f12943b, "ksad_web_card_frame");
    }

    /* renamed from: f */
    private void m15883f() {
        this.f12952k = new C4200a();
        C4200a aVar = this.f12952k;
        aVar.f13972b = this.f12948g;
        aVar.f13971a = this.f12947f;
        aVar.f13973c = this.f12942a;
        aVar.f13975e = this.f12943b;
        aVar.f13976f = this.f12944c;
        aVar.f13974d = this.f12946e;
    }

    /* renamed from: g */
    private void m15884g() {
        m15885h();
        WebSettings settings = this.f12945d.getSettings();
        settings.setJavaScriptEnabled(true);
        m15880a(settings);
        this.f12951j = new C4207g(this.f12945d);
        m15881a(this.f12951j);
        this.f12945d.addJavascriptInterface(this.f12951j, "KwaiAd");
    }

    /* renamed from: h */
    private void m15885h() {
        C4207g gVar = this.f12951j;
        if (gVar != null) {
            gVar.mo23982a();
            this.f12951j = null;
        }
    }

    /* renamed from: i */
    private boolean m15886i() {
        int[] a = C3817t.m15869a((View) this.f12945d);
        return a[0] >= 0 && a[1] > 0;
    }

    /* renamed from: j */
    private void m15887j() {
        int i = this.f12953l;
        String str = i == -1 ? "timeout" : i != 1 ? "h5error" : "others";
        StringBuilder sb = new StringBuilder();
        sb.append("show webCard fail, reason: ");
        sb.append(str);
        Log.w("PlayEndWebCard", sb.toString());
    }

    /* renamed from: a */
    public void mo23216a() {
        this.f12943b.setVisibility(4);
        this.f12953l = -1;
        String str = C4323b.m17663e(this.f12948g).playEndInfo.adWebCardInfo.cardUrl;
        if (!TextUtils.isEmpty(str)) {
            if (!C4058b.m16837a(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("url host is invalid: ");
                sb.append(str);
                C4065b.m16869d("PlayEndWebCard", sb.toString());
                return;
            }
            m15884g();
            this.f12945d.loadUrl(str);
        }
    }

    /* renamed from: a */
    public void mo23217a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, C4089b bVar) {
        mo23218a(frameLayout, adBaseFrameLayout, adTemplate, bVar, 0);
    }

    /* renamed from: a */
    public void mo23218a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, C4089b bVar, int i) {
        this.f12949h = bVar;
        this.f12942a = adBaseFrameLayout;
        this.f12943b = frameLayout;
        this.f12947f = i;
        this.f12948g = adTemplate;
        m15882e();
        m15883f();
    }

    /* renamed from: a */
    public void mo23219a(C3826a aVar) {
        this.f12950i = aVar;
    }

    /* renamed from: b */
    public boolean mo23220b() {
        if (this.f12953l == 1) {
            C4227i iVar = this.f12954m;
            if (iVar != null) {
                iVar.mo23987c();
            }
            this.f12943b.setVisibility(0);
            C4227i iVar2 = this.f12954m;
            if (iVar2 != null) {
                iVar2.mo23988d();
            }
            return true;
        }
        m15887j();
        return false;
    }

    /* renamed from: c */
    public void mo23221c() {
        if (m15886i()) {
            C4227i iVar = this.f12954m;
            if (iVar != null) {
                iVar.mo23989e();
            }
            this.f12943b.setVisibility(4);
            C4227i iVar2 = this.f12954m;
            if (iVar2 != null) {
                iVar2.mo23990f();
            }
        }
    }

    /* renamed from: d */
    public void mo23222d() {
        m15885h();
    }
}
