package com.p368pw.inner.p369a.p378d;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.p368pw.inner.base.p384a.C5123d;
import com.p368pw.inner.base.p384a.C5125f;
import com.p368pw.inner.base.p387d.C5191i;
import com.p368pw.inner.base.p387d.C5194l;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5207q;
import com.p368pw.inner.base.p387d.C5208r;
import com.p368pw.inner.base.p387d.p388a.C5153c;
import com.p368pw.inner.base.p387d.p390c.C5169b;
import com.p368pw.inner.base.p387d.p390c.C5169b.C5174c;
import com.p368pw.inner.base.p387d.p391d.C5176a;
import com.p368pw.inner.base.p387d.p391d.C5176a.C5181a;
import com.p368pw.inner.base.p387d.p391d.C5183b;
import com.p368pw.inner.p369a.p376b.C4879b;
import com.p368pw.p392us.Setting;
import com.p368pw.view.NativeAdContainer;
import com.pw.R;
import java.util.Map;

/* renamed from: com.pw.inner.a.d.a */
public class C4898a extends NativeAdContainer {
    /* renamed from: a */
    private Object f15825a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public C5176a f15826b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean f15827c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public C5169b<Object> f15828d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public CountDownTimer f15829e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public TextView f15830f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public C4879b f15831g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public int f15832h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public Setting f15833i;
    /* renamed from: j */
    private int f15834j;
    /* renamed from: k */
    private C4910c f15835k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public C4905a f15836l = new C4905a() {
        /* renamed from: a */
        public void mo26030a() {
            C4898a.this.m20245a(1, "video://install");
        }

        /* renamed from: b */
        public void mo26031b() {
            C4898a.this.m20245a(2, "video://open");
        }

        /* renamed from: c */
        public void mo26032c() {
            if (C4898a.this.f15829e != null) {
                C4898a.this.f15829e.cancel();
            }
            if (C4898a.this.f15833i.getSplashAdListener() != null) {
                C4898a.this.f15833i.getSplashAdListener().onSkip();
            }
        }
    };

    /* renamed from: com.pw.inner.a.d.a$a */
    public interface C4905a {
        /* renamed from: a */
        void mo26030a();

        /* renamed from: b */
        void mo26031b();

        /* renamed from: c */
        void mo26032c();
    }

    public C4898a(Context context, C4879b bVar, int i, Setting setting, Object obj, int i2, boolean z) {
        super(context);
        this.f15831g = bVar;
        this.f15832h = i;
        this.f15833i = setting;
        this.f15825a = obj;
        this.f15834j = i2;
        m20253b();
        this.f15835k = new C4910c(context, z);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView((View) this.f15835k, (ViewGroup.LayoutParams) layoutParams);
        m20248a(context, z);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20245a(int i, String str) {
        try {
            StringBuilder sb = new StringBuilder();
            this.f15834j = this.f15834j == 0 ? 1 : this.f15834j;
            C5123d d = C5125f.m21216a().mo26727d();
            int j = d.mo26706j();
            sb.append("javascript:getTmpInfo({icon:'");
            sb.append(C5194l.m21431b(C5207q.m21476a((CharSequence) this.f15831g.mo25948w()) ? this.f15831g.mo25920g() : this.f15831g.mo25948w()));
            sb.append("',position:'");
            sb.append(d.mo26710n());
            sb.append("',background:'");
            sb.append(C5194l.m21431b(this.f15831g.mo25928k()));
            sb.append("',title:'");
            sb.append(C5207q.m21476a((CharSequence) this.f15831g.mo25946u()) ? this.f15831g.mo25913d() : this.f15831g.mo25946u());
            sb.append("',desc:'");
            sb.append(C5207q.m21476a((CharSequence) this.f15831g.mo25947v()) ? this.f15831g.mo25916e() : this.f15831g.mo25947v());
            sb.append("',clickType:");
            sb.append(this.f15834j);
            sb.append(",type:");
            sb.append(i);
            sb.append(",link:'");
            sb.append(str);
            sb.append("',pkgName:'");
            sb.append(this.f15831g.mo25904a());
            sb.append("',imgUrl:'");
            sb.append(C5194l.m21431b(this.f15831g.mo25928k()));
            sb.append("'})");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("os act type: ");
            sb2.append(i);
            C5205o.m21462a(sb2.toString());
            String sb3 = sb.toString();
            if (j == 500 || j == 501) {
                TextUtils.isEmpty(this.f15831g.mo25904a());
            }
            if (this.f15826b != null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("开屏js：");
                sb4.append(sb3);
                C5205o.m21462a(sb4.toString());
                this.f15826b.loadUrl(sb3);
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    private void m20246a(final Context context, final C4879b bVar, final Setting setting) {
        this.f15826b = new C5176a(context, new C5181a() {
            public void onPageFinished(WebView webView, String str) {
                C4898a aVar;
                int i;
                String str2;
                super.onPageFinished(webView, str);
                if (C5191i.m21390a(context, C4898a.this.f15831g.mo25904a())) {
                    aVar = C4898a.this;
                    i = 2;
                    str2 = "video://open";
                } else if (C5153c.m21275a().mo26759a(context, C4898a.this.f15831g.mo25904a()) == 1) {
                    C4898a.this.m20245a(1, "video://install");
                    return;
                } else if (!str.equals("about:blank")) {
                    aVar = C4898a.this;
                    i = 0;
                    str2 = "video://download";
                } else {
                    return;
                }
                aVar.m20245a(i, str2);
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                StringBuilder sb = new StringBuilder();
                sb.append("os act url loading = ");
                sb.append(str);
                C5205o.m21462a(sb.toString());
                try {
                    if (str.startsWith("video://close")) {
                        if (setting.getSplashAdListener() != null) {
                            setting.getSplashAdListener().onSkip();
                        }
                        if (C4898a.this.f15829e != null) {
                            C4898a.this.f15829e.cancel();
                        }
                        C4906b.m20273a().mo26039a(context, bVar, setting);
                        return true;
                    }
                    if (str.startsWith("video://download") || str.startsWith("video://install") || str.startsWith("video://open")) {
                        if (C5207q.m21478b((CharSequence) this.overrideDeepLink)) {
                            C4898a.this.f15831g.mo25936o(this.overrideDeepLink);
                            C5205o.m21462a("webview重定向后存在deeplink，替换广告对象的deeplink");
                        }
                        C4906b.m20273a().mo26041a(context, setting, C4898a.this, bVar, C4898a.this.f15832h, C4898a.this.f15826b.getClickLocation(), C4898a.this.f15836l);
                        return true;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                } catch (Throwable th) {
                    C5205o.m21464a(th);
                }
            }
        });
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.f15835k.addView(this.f15826b, layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20247a(Context context, C4879b bVar, Setting setting, boolean z) {
        m20246a(context, bVar, setting);
        m20254b(context, bVar, setting);
        if (!z) {
            m20256c(context, bVar, setting);
        }
    }

    /* renamed from: a */
    private void m20248a(final Context context, final boolean z) {
        try {
            C4906b.m20273a().mo26038a(context);
            if (TextUtils.isEmpty(this.f15831g.mo25944s())) {
                if (TextUtils.isEmpty(this.f15831g.mo25926j())) {
                    if (!TextUtils.isEmpty(this.f15831g.mo25924i())) {
                        this.f15831g.mo25914e(2);
                    }
                    C5208r.m21479a(new Runnable() {
                        public void run() {
                            C4898a aVar = C4898a.this;
                            aVar.m20247a(context, aVar.f15831g, C4898a.this.f15833i, z);
                        }
                    });
                }
            }
            this.f15831g.mo25914e(1);
            C5208r.m21479a(new Runnable() {
                public void run() {
                    C4898a aVar = C4898a.this;
                    aVar.m20247a(context, aVar.f15831g, C4898a.this.f15833i, z);
                }
            });
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: b */
    private void m20253b() {
        if (this.f15831g != null) {
            C5123d d = C5125f.m21216a().mo26727d();
            if (d.mo26707k() != null && C5207q.m21478b((CharSequence) d.mo26707k().trim())) {
                C5205o.m21462a("策略开屏模板url不为空");
                if (C5207q.m21478b((CharSequence) d.mo26708l())) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("根据策略替换开屏的icon：");
                    sb.append(d.mo26708l());
                    C5205o.m21462a(sb.toString());
                    this.f15831g.mo25943s(d.mo26708l());
                }
                if (C5207q.m21478b((CharSequence) d.mo26709m())) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("根据策略替换开屏的title：");
                    sb2.append(d.mo26709m());
                    C5205o.m21462a(sb2.toString());
                    this.f15831g.mo25940q(d.mo26709m());
                }
                if (C5207q.m21478b((CharSequence) d.mo26695W())) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("根据策略替换开屏的desc：");
                    sb3.append(d.mo26695W());
                    C5205o.m21462a(sb3.toString());
                    this.f15831g.mo25942r(d.mo26695W());
                }
            }
        }
    }

    /* renamed from: b */
    private void m20254b(final Context context, final C4879b bVar, final Setting setting) {
        this.f15830f = new TextView(context);
        this.f15830f.setVisibility(8);
        this.f15830f.setBackgroundResource(R.drawable.win_sdk_count_down_bg);
        this.f15830f.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C4898a.this.f15829e != null) {
                    C4898a.this.f15829e.cancel();
                }
                if (setting.getSplashAdListener() != null) {
                    setting.getSplashAdListener().onSkip();
                }
                C4906b.m20273a().mo26039a(context, bVar, setting);
            }
        });
        this.f15830f.setGravity(17);
        this.f15830f.setTextColor(-1);
        this.f15830f.setTextSize(10.0f);
        this.f15830f.setPadding(0, C5191i.m21391b(context, 5), 0, C5191i.m21391b(context, 5));
        LayoutParams layoutParams = new LayoutParams(C5191i.m21391b(context, 54), -2);
        layoutParams.gravity = 53;
        layoutParams.topMargin = C5191i.m21391b(context, 14);
        layoutParams.rightMargin = C5191i.m21391b(context, 14);
        addView((View) this.f15830f, (ViewGroup.LayoutParams) layoutParams);
    }

    /* renamed from: c */
    private void m20256c(final Context context, final C4879b bVar, final Setting setting) {
        this.f15828d = new C5169b<>(context);
        this.f15828d.mo26780a((C5174c<T>) new C5174c<Object>() {
            /* renamed from: a */
            public void mo26035a(Map<View, Object> map, Map<View, Object> map2) {
                if (!C4898a.this.f15827c && map != null && !map.isEmpty()) {
                    C4898a.this.f15827c = true;
                    C4898a.this.f15828d.mo26781b();
                    C4906b.m20273a().mo26040a(context, bVar, setting, C4898a.this);
                }
            }
        });
        this.f15828d.mo26779a((View) this, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo26024a() {
        String str;
        String t = this.f15831g.mo25945t();
        if (!TextUtils.isEmpty(t)) {
            this.f15826b.loadDataWithBaseURL(null, t, "text/html", "UTF-8", null);
            return;
        }
        C5123d d = C5125f.m21216a().mo26727d();
        if (C5207q.m21478b((CharSequence) d.mo26707k())) {
            StringBuilder sb = new StringBuilder();
            sb.append("替换开屏模板url为策略的:");
            sb.append(d.mo26707k());
            C5205o.m21462a(sb.toString());
            str = d.mo26707k();
        } else {
            int j = d.mo26706j();
            String str2 = TextUtils.isEmpty(this.f15831g.mo25904a()) ? "https://adx-api.zzpolarb.com/static/adtemp/openScreen_img_0.html" : "https://adx-api.zzpolarb.com/static/adtemp/openScreen_icon_img_0.html";
            if (j == 502 && !TextUtils.isEmpty(this.f15831g.mo25928k())) {
                str2 = "https://adx-api.zzpolarb.com/static/adtemp/openScreen_img_1.html";
            }
            if (j == 503 && !TextUtils.isEmpty(this.f15831g.mo25928k())) {
                str2 = "https://adx-api.zzpolarb.com/static/adtemp/openScreen_img_2.html";
            }
            if (j == 504 && !TextUtils.isEmpty(this.f15831g.mo25928k())) {
                str2 = "https://adx-api.zzpolarb.com/static/adtemp/openScreen_img_3.html";
            }
            str = (j != 505 || TextUtils.isEmpty(this.f15831g.mo25928k())) ? str2 : "https://adx-api.zzpolarb.com/static/adtemp/openScreen_img_4.html";
        }
        this.f15826b.loadUrl(C5194l.m21428a(str));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo26025a(Context context, Setting setting) {
        C5123d d = C5125f.m21216a().mo26727d();
        long w = d != null ? ((long) d.mo26719w()) * 1000 : 0;
        CountDownTimer countDownTimer = this.f15829e;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (w <= 0) {
            if (setting.getSplashAdListener() != null) {
                setting.getSplashAdListener().onTimeOver();
            }
            return;
        }
        this.f15830f.setVisibility(0);
        final Setting setting2 = setting;
        C49046 r4 = new CountDownTimer(w, 1000) {
            public void onFinish() {
                if (C4898a.this.f15830f != null) {
                    C4898a.this.f15830f.setText("跳出");
                }
                if (setting2.getSplashAdListener() != null) {
                    setting2.getSplashAdListener().onTimeOver();
                }
            }

            public void onTick(long j) {
                if (C4898a.this.f15830f != null) {
                    C4898a.this.f15830f.setText(String.format("跳出  %s", new Object[]{Long.valueOf(j / 1000)}));
                }
            }
        };
        this.f15829e = r4;
        this.f15829e.start();
    }

    public C5183b getClickLocation() {
        return this.f15826b.getClickLocation();
    }

    public Object getOriginBean() {
        return this.f15825a;
    }

    public C4905a getSpMngListener() {
        return this.f15836l;
    }

    public ViewGroup getViewGroup() {
        return this.f15835k;
    }
}
