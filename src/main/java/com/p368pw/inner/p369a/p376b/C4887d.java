package com.p368pw.inner.p369a.p376b;

import android.text.TextUtils;
import android.webkit.WebView;
import com.p368pw.inner.base.p384a.C5123d;
import com.p368pw.inner.base.p384a.C5125f;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5207q;
import java.io.Serializable;

/* renamed from: com.pw.inner.a.b.d */
public class C4887d implements Serializable {
    /* renamed from: a */
    private String f15799a;
    /* renamed from: b */
    private String f15800b;
    /* renamed from: c */
    private boolean f15801c;
    /* renamed from: d */
    private boolean f15802d;
    /* renamed from: e */
    private boolean f15803e;
    /* renamed from: f */
    private int f15804f;
    /* renamed from: g */
    private boolean f15805g;
    /* renamed from: h */
    private int f15806h;

    public C4887d(String str, String str2, boolean z, boolean z2, boolean z3, int i, boolean z4, int i2) {
        this.f15799a = str;
        this.f15800b = str2;
        this.f15801c = z;
        this.f15802d = z2;
        this.f15803e = z3;
        this.f15804f = i;
        this.f15805g = z4;
        this.f15806h = i2;
    }

    /* renamed from: a */
    public String mo25960a() {
        C5123d d = C5125f.m21216a().mo26727d();
        if (C5207q.m21478b((CharSequence) d.mo26704h())) {
            this.f15800b = d.mo26704h();
        }
        return this.f15800b;
    }

    /* renamed from: a */
    public void mo25961a(WebView webView) {
        String b = mo25962b();
        if (!TextUtils.isEmpty(b)) {
            StringBuilder sb = new StringBuilder();
            sb.append("loadDataWithBaseURL,html:");
            sb.append(b);
            C5205o.m21462a(sb.toString());
            webView.loadDataWithBaseURL(null, b, "text/html", "UTF-8", null);
            return;
        }
        String a = mo25960a();
        if (!TextUtils.isEmpty(a)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("loadUrl,url:");
            sb2.append(a);
            C5205o.m21462a(sb2.toString());
            webView.loadUrl(a);
            return;
        }
        C5205o.m21462a("render失败");
    }

    /* renamed from: b */
    public String mo25962b() {
        return this.f15799a;
    }

    /* renamed from: c */
    public boolean mo25963c() {
        return this.f15801c;
    }

    /* renamed from: d */
    public int mo25964d() {
        return this.f15804f;
    }

    /* renamed from: e */
    public boolean mo25965e() {
        return this.f15805g;
    }

    /* renamed from: f */
    public int mo25966f() {
        return this.f15806h;
    }
}
