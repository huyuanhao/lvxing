package com.ali.auth.third.p034ui.webview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ali.auth.third.core.model.C1026g;
import com.ali.auth.third.core.p024c.C0989a;
import com.ali.auth.third.core.p025d.C0992a;
import com.ali.auth.third.core.p033j.C1018a;
import com.ali.auth.third.core.util.C1034a;
import com.ali.auth.third.core.util.C1041f;
import com.ali.auth.third.p016a.p020d.C0977a;
import com.ali.auth.third.p034ui.p036b.C1071a;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

/* renamed from: com.ali.auth.third.ui.webview.BaseWebViewActivity */
public class BaseWebViewActivity extends Activity {
    /* renamed from: e */
    public static final String f2195e = BaseWebViewActivity.class.getSimpleName();
    /* access modifiers changed from: protected */
    /* renamed from: f */
    public AuthWebView f2196f;
    /* access modifiers changed from: protected */
    /* renamed from: g */
    public TextView f2197g;
    /* renamed from: h */
    protected RelativeLayout f2198h;
    /* renamed from: i */
    public boolean f2199i;
    /* renamed from: j */
    protected ImageView f2200j;
    /* renamed from: k */
    protected ImageView f2201k;

    /* renamed from: com.ali.auth.third.ui.webview.BaseWebViewActivity$a */
    class C1082a extends AsyncTask<String, Void, Void> {
        /* renamed from: b */
        private String f2206b;

        C1082a() {
        }

        /* access modifiers changed from: protected|varargs */
        /* renamed from: a */
        public Void doInBackground(String... strArr) {
            this.f2206b = strArr[0];
            C0992a.f1924a.mo10314a();
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Void voidR) {
            super.onPostExecute(voidR);
            if (!C1034a.m1982b()) {
                C1034a.m1980a("com_taobao_tae_sdk_network_not_available_message");
                return;
            }
            try {
                BaseWebViewActivity.this.f2196f.resumeTimers();
                if (VERSION.SDK_INT >= 11) {
                    BaseWebViewActivity.this.f2196f.onResume();
                }
            } catch (Exception unused) {
            }
            BaseWebViewActivity.this.f2196f.loadUrl(this.f2206b);
        }
    }

    /* renamed from: e */
    private void m2099e() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) C1041f.m2006b(getApplicationContext(), "ali_auth_titlebar_height"));
        this.f2198h = new RelativeLayout(this);
        this.f2198h.setBackgroundColor(Color.parseColor("#F8F8F8"));
        linearLayout.addView(this.f2198h, layoutParams);
        this.f2201k = new ImageView(this);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.addRule(9);
        layoutParams2.addRule(15);
        String str = "ali_auth_space_10";
        layoutParams2.leftMargin = (int) C1041f.m2006b(getApplicationContext(), str);
        this.f2201k.setScaleType(ScaleType.CENTER);
        String str2 = "drawable";
        this.f2201k.setImageResource(C1041f.m2003a(getApplicationContext(), str2, "com_taobao_tae_sdk_web_view_title_bar_back"));
        String str3 = "ali_auth_space_20";
        this.f2201k.setPadding(0, 0, (int) C1041f.m2006b(getApplicationContext(), str3), 0);
        this.f2197g = new TextView(this);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        this.f2197g.setMaxWidth((int) C1041f.m2006b(getApplicationContext(), "ali_auth_space_160"));
        this.f2197g.setMaxLines(1);
        this.f2197g.setTextColor(Color.parseColor("#3d4245"));
        this.f2197g.setTextSize(2, 18.0f);
        this.f2200j = new ImageView(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams4.addRule(11);
        layoutParams4.addRule(15);
        layoutParams4.rightMargin = (int) C1041f.m2006b(getApplicationContext(), str);
        this.f2200j.setScaleType(ScaleType.CENTER);
        this.f2200j.setImageResource(C1041f.m2003a(getApplicationContext(), str2, "com_taobao_tae_sdk_web_view_title_bar_close"));
        this.f2200j.setPadding((int) C1041f.m2006b(getApplicationContext(), str3), 0, 0, 0);
        this.f2198h.addView(this.f2201k, layoutParams2);
        this.f2198h.addView(this.f2197g, layoutParams3);
        this.f2198h.addView(this.f2200j, layoutParams4);
        this.f2196f = mo10456d();
        AuthWebView authWebView = this.f2196f;
        if (authWebView == null) {
            C0977a.m1852a();
            finish();
            return;
        }
        authWebView.setWebViewClient(mo10385a());
        this.f2196f.setWebChromeClient(mo10388b());
        if (VERSION.SDK_INT >= 19) {
            AuthWebView authWebView2 = this.f2196f;
            AuthWebView.setWebContentsDebuggingEnabled(C1018a.m1961a());
        }
        linearLayout.addView(this.f2196f, new LinearLayout.LayoutParams(-1, -1));
        setContentView(linearLayout);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public WebViewClient mo10385a() {
        return new C1083a(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public WebChromeClient mo10388b() {
        return new C1086b() {
            public void onReceivedTitle(WebView webView, String str) {
                if (BaseWebViewActivity.this.f2199i) {
                    BaseWebViewActivity.this.f2197g.setText(str);
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo10389c() {
        setResult(C1026g.f2044h.f2046j, new Intent());
        C0977a.m1852a();
        finish();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public AuthWebView mo10456d() {
        try {
            return new AuthWebView(this);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C1071a aVar = (C1071a) C0989a.m1883a(C1071a.class, Collections.singletonMap("requestCodeKey", String.valueOf(i)));
        if (aVar != null) {
            aVar.mo10423a(2, i, i2, intent, this, null, this.f2196f);
        }
    }

    public void onBackPressed() {
        mo10389c();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        m2099e();
        ImageView imageView = this.f2201k;
        if (imageView != null) {
            imageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    BaseWebViewActivity.this.mo10389c();
                }
            });
        }
        ImageView imageView2 = this.f2200j;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    BaseWebViewActivity.this.finish();
                }
            });
            this.f2200j.setVisibility(8);
        }
        String str2 = "ui_contextParams";
        String str3 = null;
        Serializable serializable = getIntent() != null ? getIntent().getSerializableExtra(str2) : bundle != null ? bundle.getSerializable(str2) : null;
        if (serializable instanceof Map) {
            this.f2196f.getContextParameters().putAll((Map) serializable);
        }
        String str4 = "url";
        String str5 = "title";
        if (bundle != null) {
            str3 = bundle.getString(str5);
            str = bundle.getString(str4);
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = getIntent().getStringExtra(str5);
        }
        if (TextUtils.isEmpty(str3)) {
            this.f2199i = true;
        } else {
            this.f2199i = false;
            this.f2197g.setText(str3);
        }
        if (TextUtils.isEmpty(str)) {
            str = getIntent().getStringExtra(str4);
        }
        String str6 = f2195e;
        StringBuilder sb = new StringBuilder();
        sb.append("onCreate url=");
        sb.append(str);
        C1018a.m1964b(str6, sb.toString());
        if (C0989a.m1888d()) {
            new C1082a().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{str});
            return;
        }
        C0977a.m1852a();
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        AuthWebView authWebView = this.f2196f;
        if (authWebView != null) {
            ViewGroup viewGroup = (ViewGroup) authWebView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f2196f);
            }
            this.f2196f.removeAllViews();
            this.f2196f.destroy();
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        AuthWebView authWebView = this.f2196f;
        if (authWebView != null) {
            try {
                authWebView.resumeTimers();
                if (VERSION.SDK_INT >= 11) {
                    this.f2196f.onResume();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("url", this.f2196f.getUrl());
        bundle.putString("title", this.f2197g.getText().toString());
        bundle.putSerializable("ui_contextParams", this.f2196f.getContextParameters());
    }
}
