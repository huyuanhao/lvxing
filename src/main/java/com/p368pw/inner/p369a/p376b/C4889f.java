package com.p368pw.inner.p369a.p376b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.p368pw.inner.C5069b;
import com.p368pw.inner.base.p384a.C5123d;
import com.p368pw.inner.base.p384a.C5125f;
import com.p368pw.inner.base.p387d.C5191i;
import com.p368pw.inner.base.p387d.C5194l;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5207q;
import com.p368pw.inner.base.p387d.p388a.C5153c;
import com.p368pw.inner.base.p387d.p391d.C5176a;
import com.p368pw.inner.base.p387d.p391d.C5176a.C5181a;
import com.p368pw.inner.p369a.C4897d;
import com.p368pw.inner.p369a.p376b.C4880c.C4885a;
import com.p368pw.inner.p369a.p379e.p380a.p382b.C4925a;
import com.p368pw.inner.p369a.p379e.p380a.p382b.C4926b;
import com.p368pw.view.FullInterstitialActivity;

/* renamed from: com.pw.inner.a.b.f */
public class C4889f extends C4897d {
    /* access modifiers changed from: private */
    /* renamed from: b */
    public Context f15807b;
    /* renamed from: c */
    private RelativeLayout f15808c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public C5176a f15809d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public C4879b f15810e;
    /* renamed from: f */
    private C4887d f15811f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public int f15812g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public C4885a f15813h = new C4885a() {
        public void onDownloadFinished() {
            C4889f.this.m20155a(1, "video://install", false);
        }

        public void onInstalled() {
            C4889f.this.m20155a(2, "video://open", false);
        }

        public void onLandPageClose() {
        }
    };

    protected C4889f(Activity activity) {
        super(activity);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20155a(int i, String str, boolean z) {
        try {
            String k = this.f15810e.mo25928k();
            if (TextUtils.isEmpty(k)) {
                k = "https://adx-api.zzpolarb.com/static/adtemp/img/interstitial_bg.png";
            }
            C5123d d = C5125f.m21216a().mo26727d();
            String str2 = C5191i.m21408k(this.f15824a) ? "landscape" : "portrait";
            int f = this.f15811f.mo25966f() == 0 ? 1 : this.f15811f.mo25966f();
            StringBuilder sb = new StringBuilder();
            sb.append("javascript:getTmpInfo({icon:'");
            sb.append(C5194l.m21431b(this.f15810e.mo25920g()));
            sb.append("',imgUrl:'");
            sb.append(C5194l.m21431b(k));
            sb.append("',device:'");
            sb.append(str2);
            sb.append("',appName:'");
            sb.append(this.f15810e.mo25913d());
            sb.append("',title:'");
            sb.append(this.f15810e.mo25913d());
            sb.append("',desc:'");
            sb.append(this.f15810e.mo25916e());
            sb.append("',clickType:");
            sb.append(f);
            sb.append(",type:");
            sb.append(i);
            sb.append(",timeout:");
            sb.append(d.mo26718v());
            sb.append(",link:'");
            sb.append(str);
            sb.append("',pkgName:'");
            sb.append(this.f15810e.mo25904a());
            sb.append("'})");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("sp act type: ");
            sb2.append(i);
            C5205o.m21462a(sb2.toString());
            String sb3 = sb.toString();
            if (!z) {
                sb3 = sb3.replace("timeout", "timeouts");
            }
            if (this.f15809d != null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("处理页面事件交互逻辑 webview loadUrl:");
                sb4.append(sb3);
                C5205o.m21462a(sb4.toString());
                this.f15809d.loadUrl(sb3);
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: s */
    private void m20163s() {
        this.f15824a.requestWindowFeature(1);
    }

    /* renamed from: t */
    private void m20164t() {
        if (this.f15811f.mo25965e()) {
            this.f15824a.getWindow().addFlags(1024);
        }
    }

    /* renamed from: u */
    private void m20165u() {
        int i;
        Activity activity;
        if (VERSION.SDK_INT != 26) {
            int d = this.f15811f.mo25964d();
            if (d == 0) {
                activity = this.f15824a;
                i = 0;
            } else {
                i = 1;
                if (d == 1) {
                    activity = this.f15824a;
                }
            }
            activity.setRequestedOrientation(i);
        }
    }

    /* renamed from: v */
    private void m20166v() {
        try {
            if (this.f15811f.mo25963c()) {
                ImageView imageView = new ImageView(this.f15807b);
                imageView.setImageDrawable(C4926b.video_close.mo26118a(this.f15807b));
                LayoutParams layoutParams = new LayoutParams(C4925a.m20443a(this.f15807b, 30.0f), C4925a.m20443a(this.f15807b, 30.0f));
                layoutParams.addRule(11, -1);
                layoutParams.setMargins(0, C4925a.m20443a(this.f15807b, 8.0f), C4925a.m20443a(this.f15807b, 8.0f), 0);
                this.f15808c.addView(imageView, layoutParams);
                imageView.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        C4889f.this.m20167w();
                    }
                });
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public void m20167w() {
        C4880c.m20089a().mo25952b(this.f15807b, this.f15810e);
        this.f15824a.finish();
    }

    /* renamed from: x */
    private void m20168x() {
        this.f15811f.mo25961a(this.f15809d);
    }

    /* renamed from: a */
    public void mo25967a(Context context) {
        try {
            this.f15810e = (C4879b) this.f15824a.getIntent().getSerializableExtra("ins_data");
            this.f15809d = new C5176a(context, new C5181a() {
                public void onPageFinished(WebView webView, String str) {
                    C4889f fVar;
                    int i;
                    super.onPageFinished(webView, str);
                    C5205o.m21462a(str);
                    String str2 = "video://open";
                    String str3 = "video://download";
                    if (C5191i.m21390a(C4889f.this.f15807b, C4889f.this.f15810e.mo25904a())) {
                        if (!C5069b.m21115a().mo26583b(C4889f.this.f15810e.mo25904a())) {
                            fVar = C4889f.this;
                            i = 3;
                            fVar.m20155a(i, str3, true);
                            return;
                        }
                    } else if (C5153c.m21275a().mo26759a(C4889f.this.f15807b, C4889f.this.f15810e.mo25904a()) == 1) {
                        C4889f.this.m20155a(1, "video://install", true);
                        return;
                    } else if (!TextUtils.isEmpty(C4889f.this.f15810e.mo25904a())) {
                        if (!str.equals("about:blank")) {
                            fVar = C4889f.this;
                            i = 0;
                            fVar.m20155a(i, str3, true);
                            return;
                        }
                        return;
                    }
                    C4889f.this.m20155a(2, str2, true);
                }

                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ins act url loading = ");
                    sb.append(str);
                    C5205o.m21462a(sb.toString());
                    try {
                        if (str.startsWith("video://close")) {
                            C4889f.this.m20167w();
                            return true;
                        }
                        if (str.startsWith("video://download") || str.startsWith("video://install") || str.startsWith("video://open")) {
                            if (C5207q.m21478b((CharSequence) this.overrideDeepLink)) {
                                C4889f.this.f15810e.mo25936o(this.overrideDeepLink);
                                C5205o.m21462a("webview重定向后存在deeplink，替换广告对象的deeplink");
                            }
                            C4880c.m20089a().mo25950a(C4889f.this.f15807b, C4889f.this.f15810e, C4889f.this.f15812g, C4889f.this.f15809d.getClickLocation(), C4889f.this.f15813h);
                            return true;
                        }
                        return super.shouldOverrideUrlLoading(webView, str);
                    } catch (Throwable th) {
                        C5205o.m21464a(th);
                    }
                }
            });
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.f15808c.addView(this.f15809d, layoutParams);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public void mo25896a(Configuration configuration) {
        int i;
        super.mo25896a(configuration);
        String str = "video://download";
        if (C5191i.m21390a(this.f15807b, this.f15810e.mo25904a())) {
            if (C5069b.m21115a().mo26583b(this.f15810e.mo25904a())) {
                i = 2;
                str = "video://open";
            } else {
                i = 3;
            }
            m20155a(i, str, false);
        } else if (C5153c.m21275a().mo26759a(this.f15807b, this.f15810e.mo25904a()) == 1) {
            m20155a(1, "video://install", false);
        } else {
            m20155a(0, str, false);
        }
    }

    /* renamed from: a */
    public void mo25897a(Bundle bundle) {
        this.f15811f = (C4887d) this.f15824a.getIntent().getSerializableExtra("ins_temp");
        this.f15812g = this.f15824a.getIntent().getIntExtra(FullInterstitialActivity.SOURCE, 0);
        m20163s();
        m20164t();
        m20165u();
    }

    /* renamed from: b */
    public void mo25898b() {
        super.mo25898b();
        mo25968d();
    }

    /* renamed from: b */
    public void mo25899b(Bundle bundle) {
        this.f15807b = this.f15824a.getApplicationContext();
        this.f15808c = new RelativeLayout(this.f15807b, null);
        this.f15808c.setBackgroundColor(Color.parseColor("#99000000"));
        this.f15824a.setContentView(this.f15808c);
        mo25967a(this.f15807b);
        m20168x();
        m20166v();
    }

    /* renamed from: c */
    public boolean mo25900c() {
        C4880c.m20089a().mo25953c(this.f15807b, this.f15810e);
        return false;
    }

    /* renamed from: d */
    public void mo25968d() {
        try {
            if (this.f15809d != null) {
                this.f15808c.removeView(this.f15809d);
                this.f15809d.clearHistory();
                this.f15809d.clearCache(true);
                this.f15809d.loadUrl("about:blank");
                this.f15809d.clearView();
                this.f15809d = null;
                C5205o.m21462a("wb cls");
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }
}
