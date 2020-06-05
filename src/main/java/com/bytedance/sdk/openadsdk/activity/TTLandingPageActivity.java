package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.core.AdInfoFactory;
import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.NetApi;
import com.bytedance.sdk.openadsdk.core.NetApi.C2287b;
import com.bytedance.sdk.openadsdk.core.SingleAppData;
import com.bytedance.sdk.openadsdk.core.TTAndroidObject;
import com.bytedance.sdk.openadsdk.core.WebViewTweaker;
import com.bytedance.sdk.openadsdk.core.p167a.ClickCreativeListener;
import com.bytedance.sdk.openadsdk.core.p170d.AdInfo;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p170d.NetExtParams;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebSettings;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.widget.webview.TTWebChromeClient;
import com.bytedance.sdk.openadsdk.core.widget.webview.TTWebViewClient;
import com.bytedance.sdk.openadsdk.downloadnew.TTDownloadFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.p165c.LandingPageLog;
import com.bytedance.sdk.openadsdk.p180d.TeMaiIdsListener;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.JsBridgeUtils;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.bytedance.sdk.openadsdk.utils.UIUtils;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TTLandingPageActivity extends Activity implements TeMaiIdsListener {
    /* renamed from: b */
    private static final String f6575b = TTLandingPageActivity.class.getSimpleName();
    /* renamed from: a */
    LandingPageLog f6576a;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public SSWebView f6577c;
    /* renamed from: d */
    private ImageView f6578d;
    /* renamed from: e */
    private ImageView f6579e;
    /* renamed from: f */
    private TextView f6580f;
    /* renamed from: g */
    private Context f6581g;
    /* renamed from: h */
    private int f6582h;
    /* renamed from: i */
    private ViewStub f6583i;
    /* renamed from: j */
    private ViewStub f6584j;
    /* renamed from: k */
    private ViewStub f6585k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public Button f6586l;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public ProgressBar f6587m;
    /* renamed from: n */
    private String f6588n;
    /* renamed from: o */
    private String f6589o;
    /* access modifiers changed from: private */
    /* renamed from: p */
    public TTAndroidObject f6590p;
    /* renamed from: q */
    private int f6591q;
    /* renamed from: r */
    private String f6592r;
    /* access modifiers changed from: private */
    /* renamed from: s */
    public MaterialMeta f6593s;
    /* renamed from: t */
    private String f6594t;
    /* access modifiers changed from: private */
    /* renamed from: u */
    public AtomicBoolean f6595u = new AtomicBoolean(true);
    /* renamed from: v */
    private JSONArray f6596v = null;
    /* renamed from: w */
    private ITTDownloadAdapter f6597w;
    /* access modifiers changed from: private|final */
    /* renamed from: x */
    public final Map<String, ITTDownloadAdapter> f6598x = Collections.synchronizedMap(new HashMap());
    /* renamed from: y */
    private String f6599y = "立即下载";
    /* renamed from: z */
    private TTAppDownloadListener f6600z = new TTAppDownloadListener() {
        public void onIdle() {
            TTLandingPageActivity tTLandingPageActivity = TTLandingPageActivity.this;
            tTLandingPageActivity.m8173a(tTLandingPageActivity.m8175b());
        }

        public void onDownloadActive(long j, long j2, String str, String str2) {
            TTLandingPageActivity.this.m8173a("下载中...");
        }

        public void onDownloadPaused(long j, long j2, String str, String str2) {
            TTLandingPageActivity.this.m8173a("暂停");
        }

        public void onDownloadFailed(long j, long j2, String str, String str2) {
            TTLandingPageActivity.this.m8173a("下载失败");
        }

        public void onDownloadFinished(long j, String str, String str2) {
            TTLandingPageActivity.this.m8173a("点击安装");
        }

        public void onInstalled(String str, String str2) {
            TTLandingPageActivity.this.m8173a("点击打开");
        }
    };

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (GlobalInfo.m9616c().mo15682l()) {
            getWindow().addFlags(2621440);
        }
        try {
            InternalContainer.m10061a(this);
        } catch (Throwable unused) {
        }
        setContentView(ResourceHelp.m11936f(this, "tt_activity_ttlandingpage"));
        m8179c();
        this.f6581g = this;
        SSWebSettings.m10854a(this.f6581g).mo16362a(false).mo16364b(false).mo16363a((WebView) this.f6577c);
        Intent intent = getIntent();
        this.f6582h = intent.getIntExtra("sdk_version", 1);
        String str = "adid";
        this.f6588n = intent.getStringExtra(str);
        this.f6589o = intent.getStringExtra("log_extra");
        this.f6591q = intent.getIntExtra(ArgKey.KEY_SOURCE, -1);
        String str2 = "url";
        String stringExtra = intent.getStringExtra(str2);
        this.f6594t = stringExtra;
        m8170a(4);
        String str3 = "web_title";
        String stringExtra2 = intent.getStringExtra(str3);
        intent.getStringExtra("icon_url");
        String str4 = "event_tag";
        this.f6592r = intent.getStringExtra(str4);
        if (MultiGlobalInfo.m11808b()) {
            String stringExtra3 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
            if (stringExtra3 != null) {
                try {
                    this.f6593s = AdInfoFactory.m9163a(new JSONObject(stringExtra3));
                } catch (Exception e) {
                    C2564t.m12223c(f6575b, "TTLandingPageActivity - onCreate MultiGlobalInfo : ", e);
                }
            }
        } else {
            this.f6593s = SingleAppData.m10160a().mo15937c();
            SingleAppData.m10160a().mo15941g();
        }
        this.f6576a = new LandingPageLog(this, this.f6593s, this.f6577c).mo15018a(true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, this.f6588n);
            jSONObject.put(str2, stringExtra);
            jSONObject.put(str3, stringExtra2);
            jSONObject.put("is_multi_process", MultiGlobalInfo.m11808b());
            jSONObject.put(str4, this.f6592r);
        } catch (JSONException unused2) {
        }
        this.f6576a.mo15026a(jSONObject);
        m8181d();
        SSWebView sSWebView = this.f6577c;
        C20421 r7 = new TTWebViewClient(this.f6581g, this.f6590p, this.f6588n, this.f6576a) {
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTLandingPageActivity.this.f6587m != null && !TTLandingPageActivity.this.isFinishing()) {
                        TTLandingPageActivity.this.f6587m.setVisibility(8);
                    }
                } catch (Throwable unused) {
                }
            }
        };
        sSWebView.setWebViewClient(r7);
        this.f6577c.getSettings().setUserAgentString(JsBridgeUtils.m12206a((WebView) this.f6577c, this.f6582h));
        if (VERSION.SDK_INT >= 21) {
            this.f6577c.getSettings().setMixedContentMode(0);
        }
        this.f6577c.loadUrl(stringExtra);
        this.f6577c.setWebChromeClient(new TTWebChromeClient(this.f6590p, this.f6576a) {
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (TTLandingPageActivity.this.f6587m != null && !TTLandingPageActivity.this.isFinishing()) {
                    if (i != 100 || !TTLandingPageActivity.this.f6587m.isShown()) {
                        TTLandingPageActivity.this.f6587m.setProgress(i);
                    } else {
                        TTLandingPageActivity.this.f6587m.setVisibility(8);
                    }
                }
            }
        });
        this.f6577c.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (TTLandingPageActivity.this.f6598x.containsKey(str)) {
                    ITTDownloadAdapter aVar = (ITTDownloadAdapter) TTLandingPageActivity.this.f6598x.get(str);
                    if (aVar != null) {
                        aVar.mo16520f();
                        return;
                    }
                    return;
                }
                String str5 = null;
                if (!(TTLandingPageActivity.this.f6593s == null || TTLandingPageActivity.this.f6593s.mo15415C() == null)) {
                    str5 = TTLandingPageActivity.this.f6593s.mo15415C().mo15406a();
                }
                ITTDownloadAdapter a = TTDownloadFactory.m11072a((Context) TTLandingPageActivity.this, str, str5);
                TTLandingPageActivity.this.f6598x.put(str, a);
                a.mo16520f();
            }
        });
        TextView textView = this.f6580f;
        if (textView != null) {
            if (TextUtils.isEmpty(stringExtra2)) {
                stringExtra2 = ResourceHelp.m11931a(this, "tt_web_title_default");
            }
            textView.setText(stringExtra2);
        }
        m8169a();
    }

    /* renamed from: a */
    private void m8169a() {
        MaterialMeta kVar = this.f6593s;
        if (kVar != null && kVar.mo15414B() == 4) {
            this.f6585k.setVisibility(0);
            this.f6586l = (Button) findViewById(ResourceHelp.m11935e(this, "tt_browser_download_btn"));
            if (this.f6586l != null) {
                m8173a(m8175b());
                if (this.f6597w == null) {
                    this.f6597w = TTDownloadFactory.m11071a((Context) this, this.f6593s, TextUtils.isEmpty(this.f6592r) ? ToolUtils.m11993a(this.f6591q) : this.f6592r);
                    this.f6597w.mo16510a(this.f6600z, false);
                }
                this.f6597w.mo16507a((Activity) this);
                ClickCreativeListener aVar = new ClickCreativeListener(this, this.f6593s, this.f6592r, this.f6591q);
                aVar.mo15271a(false);
                this.f6586l.setOnClickListener(aVar);
                this.f6586l.setOnTouchListener(aVar);
                aVar.mo15283a(this.f6597w);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m8175b() {
        MaterialMeta kVar = this.f6593s;
        if (kVar != null && !TextUtils.isEmpty(kVar.mo15424L())) {
            this.f6599y = this.f6593s.mo15424L();
        }
        return this.f6599y;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8173a(final String str) {
        if (!TextUtils.isEmpty(str)) {
            Button button = this.f6586l;
            if (button != null) {
                button.post(new Runnable() {
                    public void run() {
                        if (TTLandingPageActivity.this.f6586l != null && !TTLandingPageActivity.this.isFinishing()) {
                            TTLandingPageActivity.this.f6586l.setText(str);
                        }
                    }
                });
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m8169a();
    }

    /* renamed from: c */
    private void m8179c() {
        this.f6577c = (SSWebView) findViewById(ResourceHelp.m11935e(this, "tt_browser_webview"));
        this.f6585k = (ViewStub) findViewById(ResourceHelp.m11935e(this, "tt_browser_download_btn_stub"));
        this.f6583i = (ViewStub) findViewById(ResourceHelp.m11935e(this, "tt_browser_titlebar_view_stub"));
        this.f6584j = (ViewStub) findViewById(ResourceHelp.m11935e(this, "tt_browser_titlebar_dark_view_stub"));
        int j = GlobalInfo.m9616c().mo15680j();
        if (j == 0) {
            this.f6583i.setVisibility(0);
        } else if (j == 1) {
            this.f6584j.setVisibility(0);
        }
        this.f6578d = (ImageView) findViewById(ResourceHelp.m11935e(this, "tt_titlebar_back"));
        ImageView imageView = this.f6578d;
        if (imageView != null) {
            imageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (TTLandingPageActivity.this.f6577c == null) {
                        return;
                    }
                    if (TTLandingPageActivity.this.f6577c.canGoBack()) {
                        TTLandingPageActivity.this.f6577c.goBack();
                    } else if (TTLandingPageActivity.this.m8183e()) {
                        TTLandingPageActivity.this.onBackPressed();
                    } else {
                        TTLandingPageActivity.this.finish();
                    }
                }
            });
        }
        this.f6579e = (ImageView) findViewById(ResourceHelp.m11935e(this, "tt_titlebar_close"));
        ImageView imageView2 = this.f6579e;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    TTLandingPageActivity.this.finish();
                }
            });
        }
        this.f6580f = (TextView) findViewById(ResourceHelp.m11935e(this, "tt_titlebar_title"));
        this.f6587m = (ProgressBar) findViewById(ResourceHelp.m11935e(this, "tt_browser_progress"));
    }

    /* renamed from: d */
    private void m8181d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f6593s);
        this.f6590p = new TTAndroidObject(this);
        this.f6590p.mo16398a((WebView) this.f6577c).mo16400a(this.f6593s).mo16408a((List<MaterialMeta>) arrayList).mo16407a(this.f6588n).mo16416b(this.f6589o).mo16397a(this.f6591q).mo16421c(ToolUtils.m12032g(this.f6593s)).mo16403a((TeMaiIdsListener) this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        TTAndroidObject xVar = this.f6590p;
        if (xVar != null) {
            xVar.mo16430g();
        }
        ITTDownloadAdapter aVar = this.f6597w;
        if (aVar != null) {
            aVar.mo16513b();
        }
        Map<String, ITTDownloadAdapter> map = this.f6598x;
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    ((ITTDownloadAdapter) entry.getValue()).mo16513b();
                }
            }
        }
        LandingPageLog jVar = this.f6576a;
        if (jVar != null) {
            jVar.mo15019a();
        }
        m8185f();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        LandingPageLog jVar = this.f6576a;
        if (jVar != null) {
            jVar.mo15027b();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        SingleAppData.m10160a().mo15935b(true);
        TTAndroidObject xVar = this.f6590p;
        if (xVar != null) {
            xVar.mo16433h();
        }
        ITTDownloadAdapter aVar = this.f6597w;
        if (aVar != null) {
            aVar.mo16516c();
        }
        Map<String, ITTDownloadAdapter> map = this.f6598x;
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    ((ITTDownloadAdapter) entry.getValue()).mo16516c();
                }
            }
        }
    }

    public void onBackPressed() {
        if (!m8183e() || this.f6595u.getAndSet(true)) {
            super.onBackPressed();
            return;
        }
        m8174a(true);
        m8170a(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m8183e() {
        return !TextUtils.isEmpty(this.f6594t) && this.f6594t.contains("__luban_sdk");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8170a(int i) {
        if (this.f6579e != null && m8183e()) {
            UIUtils.m12059a((View) this.f6579e, i);
        }
    }

    /* renamed from: a */
    private void m8174a(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isBackIntercept", z);
            this.f6590p.mo16412a("temai_back_event", jSONObject);
        } catch (Exception unused) {
        }
    }

    /* renamed from: f */
    private void m8185f() {
        if (this.f6593s != null) {
            JSONArray b = m8177b(this.f6594t);
            int d = ToolUtils.m12018d(this.f6589o);
            int c = ToolUtils.m12014c(this.f6589o);
            NetApi f = InternalContainer.m10067f();
            if (b != null && f != null && d > 0 && c > 0) {
                NetExtParams lVar = new NetExtParams();
                lVar.f7453d = b;
                AdSlot j = this.f6593s.mo15492j();
                if (j != null) {
                    j.setAdCount(6);
                    f.mo15917a(j, lVar, c, (C2287b) new C2287b() {
                        /* renamed from: a */
                        public void mo14946a(int i, String str) {
                            TTLandingPageActivity.this.m8170a(0);
                        }

                        /* renamed from: a */
                        public void mo14947a(AdInfo aVar) {
                            if (aVar != null) {
                                try {
                                    TTLandingPageActivity.this.f6595u.set(false);
                                    TTLandingPageActivity.this.f6590p.mo16417b(new JSONObject(aVar.mo15338d()));
                                } catch (Exception unused) {
                                    TTLandingPageActivity.this.m8170a(0);
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    /* renamed from: b */
    private JSONArray m8177b(String str) {
        JSONArray jSONArray = this.f6596v;
        if (jSONArray != null && jSONArray.length() > 0) {
            return this.f6596v;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("?id=");
        int indexOf2 = str.indexOf("&");
        if (!(indexOf == -1 || indexOf2 == -1)) {
            int i = indexOf + 4;
            if (i < indexOf2) {
                String substring = str.substring(i, indexOf2);
                if (TextUtils.isEmpty(substring)) {
                    return null;
                }
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(substring);
                return jSONArray2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        try {
            if (getWindow() != null) {
                ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                }
            }
        } catch (Throwable unused) {
        }
        WebViewTweaker.m9083a(this.f6581g, this.f6577c);
        WebViewTweaker.m9084a(this.f6577c);
        this.f6577c = null;
        TTAndroidObject xVar = this.f6590p;
        if (xVar != null) {
            xVar.mo16434i();
        }
        ITTDownloadAdapter aVar = this.f6597w;
        if (aVar != null) {
            aVar.mo16518d();
        }
        Map<String, ITTDownloadAdapter> map = this.f6598x;
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    ((ITTDownloadAdapter) entry.getValue()).mo16518d();
                }
            }
            this.f6598x.clear();
        }
        LandingPageLog jVar = this.f6576a;
        if (jVar != null) {
            jVar.mo15028c();
        }
    }

    /* renamed from: a */
    public void mo14934a(boolean z, JSONArray jSONArray) {
        if (z && jSONArray != null && jSONArray.length() > 0) {
            this.f6596v = jSONArray;
            m8185f();
        }
    }
}
