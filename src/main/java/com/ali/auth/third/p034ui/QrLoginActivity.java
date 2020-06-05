package com.ali.auth.third.p034ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ali.auth.third.core.C0980a;
import com.ali.auth.third.core.model.C1026g;
import com.ali.auth.third.core.model.C1030k;
import com.ali.auth.third.core.p023b.C0985c;
import com.ali.auth.third.core.util.C1041f;
import com.ali.auth.third.p016a.C0958b;
import com.ali.auth.third.p016a.p018b.C0959a;
import com.ali.auth.third.p016a.p020d.C0977a;
import com.ali.auth.third.p034ui.webview.AuthWebView;
import com.ali.auth.third.p034ui.webview.C1086b;

/* renamed from: com.ali.auth.third.ui.QrLoginActivity */
public class QrLoginActivity extends Activity {
    /* renamed from: a */
    protected TextView f2135a;
    /* renamed from: b */
    protected RelativeLayout f2136b;
    /* renamed from: c */
    protected ImageView f2137c;
    /* renamed from: d */
    protected ImageView f2138d;
    /* renamed from: e */
    private AuthWebView f2139e;
    /* renamed from: f */
    private String f2140f;

    /* renamed from: b */
    private void m2067b() {
        LinearLayout linearLayout = new LinearLayout(this);
        String str = "ali_auth_space_300";
        linearLayout.setLayoutParams(new LayoutParams((int) C1041f.m2006b(getApplicationContext(), str), (int) C1041f.m2006b(getApplicationContext(), str)));
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) C1041f.m2006b(getApplicationContext(), "ali_auth_titlebar_height"));
        this.f2136b = new RelativeLayout(this);
        this.f2136b.setBackgroundColor(Color.parseColor("#F8F8F8"));
        this.f2138d = new ImageView(this);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.addRule(9);
        layoutParams2.addRule(15);
        String str2 = "ali_auth_space_10";
        layoutParams2.leftMargin = (int) C1041f.m2006b(getApplicationContext(), str2);
        this.f2138d.setScaleType(ScaleType.CENTER);
        String str3 = "drawable";
        this.f2138d.setImageResource(C1041f.m2003a(getApplicationContext(), str3, "com_taobao_tae_sdk_web_view_title_bar_back"));
        String str4 = "ali_auth_space_20";
        this.f2138d.setPadding(0, 0, (int) C1041f.m2006b(getApplicationContext(), str4), 0);
        this.f2135a = new TextView(this);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        this.f2135a.setMaxWidth((int) C1041f.m2006b(getApplicationContext(), "ali_auth_space_160"));
        this.f2135a.setMaxLines(1);
        this.f2135a.setTextColor(Color.parseColor("#3d4245"));
        this.f2135a.setTextSize(2, 18.0f);
        this.f2137c = new ImageView(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams4.addRule(11);
        layoutParams4.addRule(15);
        layoutParams4.rightMargin = (int) C1041f.m2006b(getApplicationContext(), str2);
        this.f2137c.setScaleType(ScaleType.CENTER);
        this.f2137c.setImageResource(C1041f.m2003a(getApplicationContext(), str3, "com_taobao_tae_sdk_web_view_title_bar_close"));
        this.f2137c.setPadding((int) C1041f.m2006b(getApplicationContext(), str4), 0, 0, 0);
        this.f2136b.addView(this.f2135a, layoutParams3);
        this.f2136b.addView(this.f2137c, layoutParams4);
        linearLayout.addView(this.f2136b, layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) C1041f.m2006b(getApplicationContext(), str)));
        linearLayout2.setOrientation(0);
        this.f2139e = mo10415a();
        AuthWebView authWebView = this.f2139e;
        if (authWebView == null) {
            C0977a.m1852a();
            finish();
            return;
        }
        authWebView.mo10453a("loginBridge", (Object) new C0959a());
        this.f2139e.mo10453a("accountBridge", (Object) new C0959a());
        this.f2139e.setWebChromeClient(new C1086b());
        this.f2139e.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(final WebView webView, String str) {
                if (!((C0958b) C0980a.m1867a(C0958b.class)).mo10272a(str)) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                ((C0958b) C0980a.m1867a(C0958b.class)).mo10271a((C0985c) new C0985c() {
                    /* renamed from: a */
                    public void mo10305a(int i, String str) {
                    }

                    /* renamed from: a */
                    public void mo10306a(C1030k kVar) {
                        webView.reload();
                    }
                });
                return true;
            }
        });
        this.f2139e.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout2.addView(this.f2139e);
        linearLayout.addView(linearLayout2);
        setContentView(linearLayout);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public AuthWebView mo10415a() {
        try {
            return new AuthWebView(this);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setTheme(R.style.ali_auth_qr_activity_style);
        super.onCreate(bundle);
        m2067b();
        if (getIntent() == null || getIntent().getExtras() == null) {
            finish();
            return;
        }
        this.f2140f = getIntent().getExtras().getString("qrCodeLoginUrl");
        this.f2139e.loadUrl(this.f2140f);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        AuthWebView authWebView = this.f2139e;
        if (authWebView != null) {
            ViewGroup viewGroup = (ViewGroup) authWebView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f2139e);
            }
            this.f2139e.removeAllViews();
            this.f2139e.destroy();
        }
        C0977a.m1852a();
        super.onDestroy();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        setResult(C1026g.f2044h.f2046j, new Intent());
        C0977a.m1852a();
        finish();
        return true;
    }
}
