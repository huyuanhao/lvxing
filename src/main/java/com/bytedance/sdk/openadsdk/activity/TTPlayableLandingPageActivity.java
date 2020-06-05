package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.AdInfoFactory;
import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.SingleAppData;
import com.bytedance.sdk.openadsdk.core.TTAndroidObject;
import com.bytedance.sdk.openadsdk.core.WebViewTweaker;
import com.bytedance.sdk.openadsdk.core.p167a.ClickCreativeListener;
import com.bytedance.sdk.openadsdk.core.p167a.PendingDownloadListener;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.widget.PlayableLoadingView;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebSettings;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.widget.webview.TTWebChromeClient;
import com.bytedance.sdk.openadsdk.core.widget.webview.TTWebViewClient;
import com.bytedance.sdk.openadsdk.downloadnew.TTDownloadFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.p184e.PlayableLoadingListener;
import com.bytedance.sdk.openadsdk.utils.C2538ak;
import com.bytedance.sdk.openadsdk.utils.C2538ak.C2539a;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.JsBridgeUtils;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.bytedance.sdk.openadsdk.utils.UIUtils;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class TTPlayableLandingPageActivity extends Activity implements PendingDownloadListener, C2539a {
    /* renamed from: a */
    protected PlayableLoadingListener f6610a = new PlayableLoadingListener() {
        /* renamed from: a */
        public void mo14884a() {
            if (!TTPlayableLandingPageActivity.this.isFinishing()) {
                if ((TTPlayableLandingPageActivity.this.f6628s == null || TTPlayableLandingPageActivity.this.f6628s.mo15501o()) && TTPlayableLandingPageActivity.this.f6628s != null && TTPlayableLandingPageActivity.this.f6628s.mo15502p()) {
                    TTPlayableLandingPageActivity.this.f6629t.removeMessages(2);
                    TTPlayableLandingPageActivity.this.f6629t.sendMessage(TTPlayableLandingPageActivity.this.m8192a(1));
                }
            }
        }
    };
    /* renamed from: b */
    private SSWebView f6611b;
    /* renamed from: c */
    private SSWebView f6612c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean f6613d = true;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean f6614e = true;
    /* renamed from: f */
    private RelativeLayout f6615f;
    /* renamed from: g */
    private Context f6616g;
    /* renamed from: h */
    private int f6617h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public ProgressBar f6618i;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public PlayableLoadingView f6619j;
    /* renamed from: k */
    private String f6620k;
    /* renamed from: l */
    private String f6621l;
    /* renamed from: m */
    private TTAndroidObject f6622m;
    /* renamed from: n */
    private TTAndroidObject f6623n;
    /* renamed from: o */
    private int f6624o;
    /* access modifiers changed from: private */
    /* renamed from: p */
    public String f6625p;
    /* renamed from: q */
    private String f6626q;
    /* renamed from: r */
    private String f6627r;
    /* access modifiers changed from: private */
    /* renamed from: s */
    public MaterialMeta f6628s;
    /* access modifiers changed from: private */
    /* renamed from: t */
    public C2538ak f6629t = new C2538ak(Looper.getMainLooper(), this);
    /* renamed from: u */
    private boolean f6630u;
    /* renamed from: v */
    private boolean f6631v;
    /* renamed from: w */
    private ITTDownloadAdapter f6632w;
    /* renamed from: x */
    private AtomicBoolean f6633x = new AtomicBoolean(false);
    /* renamed from: y */
    private int f6634y;
    /* access modifiers changed from: private */
    /* renamed from: z */
    public boolean f6635z = false;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Message m8192a(int i) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.arg1 = i;
        return obtain;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (GlobalInfo.m9616c().mo15682l()) {
            getWindow().addFlags(2621440);
        }
        try {
            requestWindowFeature(1);
            getWindow().addFlags(1024);
            getWindow().addFlags(16777216);
            InternalContainer.m10061a(this);
        } catch (Throwable unused) {
        }
        m8195a(bundle);
        MaterialMeta kVar = this.f6628s;
        if (kVar != null) {
            this.f6616g = this;
            this.f6634y = kVar.mo15429Q();
            setContentView(ResourceHelp.m11936f(this, "tt_activity_ttlandingpage_playable"));
            m8201b();
            mo14948a();
            m8212g();
            SSWebView sSWebView = this.f6611b;
            if (sSWebView != null) {
                C20512 r0 = new TTWebViewClient(this.f6616g, this.f6622m, this.f6620k, null) {
                    /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|(1:12)|13|14|(1:18)|19|(2:21|23)(1:25)) */
                    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            return;
     */
                    /* JADX WARNING: Failed to process nested try/catch */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
                    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c A[Catch:{ all -> 0x0078 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
                    public void onPageFinished(android.webkit.WebView r3, java.lang.String r4) {
                        /*
                        r2 = this;
                        super.onPageFinished(r3, r4)
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r3 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this     // Catch:{ all -> 0x0049 }
                        boolean r3 = r3.f6635z     // Catch:{ all -> 0x0049 }
                        if (r3 == 0) goto L_0x0049
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r3 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this     // Catch:{ all -> 0x0049 }
                        com.bytedance.sdk.openadsdk.core.d.k r3 = r3.f6628s     // Catch:{ all -> 0x0049 }
                        boolean r3 = r3.mo15504r()     // Catch:{ all -> 0x0049 }
                        if (r3 == 0) goto L_0x0049
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r3 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this     // Catch:{ all -> 0x0049 }
                        boolean r3 = r3.isFinishing()     // Catch:{ all -> 0x0049 }
                        if (r3 != 0) goto L_0x0049
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r3 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this     // Catch:{ all -> 0x0049 }
                        com.bytedance.sdk.openadsdk.core.d.k r3 = r3.f6628s     // Catch:{ all -> 0x0049 }
                        boolean r3 = r3.mo15501o()     // Catch:{ all -> 0x0049 }
                        if (r3 == 0) goto L_0x0049
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r3 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this     // Catch:{ all -> 0x0049 }
                        com.bytedance.sdk.openadsdk.core.d.k r3 = r3.f6628s     // Catch:{ all -> 0x0049 }
                        boolean r3 = r3.mo15502p()     // Catch:{ all -> 0x0049 }
                        if (r3 != 0) goto L_0x0049
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r3 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this     // Catch:{ all -> 0x0049 }
                        com.bytedance.sdk.openadsdk.utils.ak r3 = r3.f6629t     // Catch:{ all -> 0x0049 }
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r4 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this     // Catch:{ all -> 0x0049 }
                        r0 = 0
                        android.os.Message r4 = r4.m8192a(r0)     // Catch:{ all -> 0x0049 }
                        r0 = 1000(0x3e8, double:4.94E-321)
                        r3.sendMessageDelayed(r4, r0)     // Catch:{ all -> 0x0049 }
                    L_0x0049:
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r3 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this     // Catch:{ all -> 0x0078 }
                        android.widget.ProgressBar r3 = r3.f6618i     // Catch:{ all -> 0x0078 }
                        if (r3 == 0) goto L_0x0064
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r3 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this     // Catch:{ all -> 0x0078 }
                        boolean r3 = r3.isFinishing()     // Catch:{ all -> 0x0078 }
                        if (r3 != 0) goto L_0x0064
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r3 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this     // Catch:{ all -> 0x0078 }
                        android.widget.ProgressBar r3 = r3.f6618i     // Catch:{ all -> 0x0078 }
                        r4 = 8
                        r3.setVisibility(r4)     // Catch:{ all -> 0x0078 }
                    L_0x0064:
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r3 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this     // Catch:{ all -> 0x0078 }
                        boolean r3 = r3.f6613d     // Catch:{ all -> 0x0078 }
                        if (r3 == 0) goto L_0x0078
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r3 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this     // Catch:{ all -> 0x0078 }
                        r3.m8203c()     // Catch:{ all -> 0x0078 }
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r3 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this     // Catch:{ all -> 0x0078 }
                        java.lang.String r4 = "py_loading_success"
                        r3.m8198a(r4)     // Catch:{ all -> 0x0078 }
                    L_0x0078:
                        return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.C20512.onPageFinished(android.webkit.WebView, java.lang.String):void");
                    }

                    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                        if (!(TTPlayableLandingPageActivity.this.f6625p == null || webResourceRequest == null || webResourceRequest.getUrl() == null || !TTPlayableLandingPageActivity.this.f6625p.equals(webResourceRequest.getUrl().toString()))) {
                            TTPlayableLandingPageActivity.this.f6613d = false;
                        }
                        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                    }

                    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                        super.onReceivedError(webView, webResourceRequest, webResourceError);
                        TTPlayableLandingPageActivity.this.f6613d = false;
                    }

                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        TTPlayableLandingPageActivity.this.f6613d = false;
                    }
                };
                sSWebView.setWebViewClient(r0);
                m8197a(this.f6611b);
                m8197a(this.f6612c);
                m8206d();
                this.f6611b.loadUrl(this.f6625p);
                this.f6611b.setWebChromeClient(new TTWebChromeClient(this.f6622m, null) {
                    public void onProgressChanged(WebView webView, int i) {
                        super.onProgressChanged(webView, i);
                        try {
                            if (TTPlayableLandingPageActivity.this.f6635z && TTPlayableLandingPageActivity.this.f6628s.mo15504r() && TTPlayableLandingPageActivity.this.f6628s.mo15501o() && !TTPlayableLandingPageActivity.this.isFinishing() && TTPlayableLandingPageActivity.this.f6619j != null) {
                                TTPlayableLandingPageActivity.this.f6619j.setProgress(i);
                            }
                        } catch (Throwable unused) {
                        }
                        if (TTPlayableLandingPageActivity.this.f6618i != null && !TTPlayableLandingPageActivity.this.isFinishing()) {
                            if (i != 100 || !TTPlayableLandingPageActivity.this.f6618i.isShown()) {
                                TTPlayableLandingPageActivity.this.f6618i.setProgress(i);
                                return;
                            }
                            TTPlayableLandingPageActivity.this.f6618i.setVisibility(8);
                            TTPlayableLandingPageActivity.this.m8203c();
                        }
                    }
                });
            }
            if (this.f6628s.mo15414B() == 4) {
                this.f6632w = TTDownloadFactory.m11071a(this.f6616g, this.f6628s, this.f6627r);
            }
        }
    }

    /* renamed from: a */
    private void m8195a(Bundle bundle) {
        Intent intent = getIntent();
        String str = "event_tag";
        String str2 = "web_title";
        String str3 = "url";
        String str4 = "ad_pending_download";
        String str5 = ArgKey.KEY_SOURCE;
        String str6 = "log_extra";
        String str7 = "adid";
        String str8 = "sdk_version";
        if (intent != null) {
            this.f6617h = intent.getIntExtra(str8, 1);
            this.f6620k = intent.getStringExtra(str7);
            this.f6621l = intent.getStringExtra(str6);
            this.f6624o = intent.getIntExtra(str5, -1);
            this.f6630u = intent.getBooleanExtra(str4, false);
            this.f6625p = intent.getStringExtra(str3);
            this.f6626q = intent.getStringExtra(str2);
            this.f6627r = intent.getStringExtra(str);
        }
        String str9 = "TTPlayableLandingPageActivity";
        if (MultiGlobalInfo.m11808b()) {
            String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
            if (stringExtra != null) {
                try {
                    this.f6628s = AdInfoFactory.m9163a(new JSONObject(stringExtra));
                } catch (Exception e) {
                    C2564t.m12223c(str9, "TTPlayableLandingPageActivity - onCreate MultiGlobalInfo : ", e);
                }
            }
        } else {
            this.f6628s = SingleAppData.m10160a().mo15937c();
            SingleAppData.m10160a().mo15941g();
        }
        if (bundle != null) {
            try {
                this.f6617h = bundle.getInt(str8, 1);
                this.f6620k = bundle.getString(str7);
                this.f6621l = bundle.getString(str6);
                this.f6624o = bundle.getInt(str5, -1);
                this.f6630u = bundle.getBoolean(str4, false);
                this.f6625p = bundle.getString(str3);
                this.f6626q = bundle.getString(str2);
                this.f6627r = bundle.getString(str);
                String string = bundle.getString("material_meta", null);
                if (!TextUtils.isEmpty(string)) {
                    this.f6628s = AdInfoFactory.m9163a(new JSONObject(string));
                }
            } catch (Throwable unused) {
            }
        }
        if (this.f6628s == null) {
            C2564t.m12226e(str9, "material is null, no data to display");
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putString("material_meta", this.f6628s != null ? this.f6628s.mo15459ae().toString() : null);
            bundle.putInt("sdk_version", this.f6617h);
            bundle.putString("adid", this.f6620k);
            bundle.putString("log_extra", this.f6621l);
            bundle.putInt(ArgKey.KEY_SOURCE, this.f6624o);
            bundle.putBoolean("ad_pending_download", this.f6630u);
            bundle.putString("url", this.f6625p);
            bundle.putString("web_title", this.f6626q);
            bundle.putString("event_tag", this.f6627r);
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* renamed from: b */
    private void m8201b() {
        this.f6619j = (PlayableLoadingView) findViewById(ResourceHelp.m11935e(this, "tt_playable_loading"));
        this.f6611b = (SSWebView) findViewById(ResourceHelp.m11935e(this, "tt_browser_webview"));
        this.f6612c = (SSWebView) findViewById(ResourceHelp.m11935e(this, "tt_browser_webview_loading"));
        this.f6615f = (RelativeLayout) findViewById(ResourceHelp.m11935e(this, "tt_playable_ad_close_layout"));
        RelativeLayout relativeLayout = this.f6615f;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    TTPlayableLandingPageActivity.this.m8198a("playable_close");
                    TTPlayableLandingPageActivity.this.m8214h();
                    TTPlayableLandingPageActivity.this.finish();
                }
            });
        }
        this.f6618i = (ProgressBar) findViewById(ResourceHelp.m11935e(this, "tt_browser_progress"));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo14948a() {
        PlayableLoadingView playableLoadingView = this.f6619j;
        if (playableLoadingView != null) {
            if (!this.f6635z) {
                playableLoadingView.mo16239a();
                return;
            }
            MaterialMeta kVar = this.f6628s;
            if (kVar == null || !kVar.mo15501o() || !this.f6628s.mo15504r()) {
                this.f6619j.mo16239a();
                return;
            }
            this.f6619j.mo16240b();
            if (this.f6619j.getPlayView() != null) {
                C20545 r1 = new ClickCreativeListener(this, this.f6628s, this.f6627r, this.f6624o) {
                    /* renamed from: a */
                    public void mo14920a(View view, int i, int i2, int i3, int i4) {
                        super.mo14920a(view, i, i2, i3, i4);
                        if (TTPlayableLandingPageActivity.this.f6628s.mo15504r()) {
                            HashMap hashMap = new HashMap();
                            if (TTPlayableLandingPageActivity.this.f6628s.mo15512z() != null) {
                                hashMap.put("playable_url", TTPlayableLandingPageActivity.this.f6628s.mo15512z().mo15604h());
                            }
                            TTPlayableLandingPageActivity tTPlayableLandingPageActivity = TTPlayableLandingPageActivity.this;
                            AdEventManager.m8419r(tTPlayableLandingPageActivity, tTPlayableLandingPageActivity.f6628s, this.f7199e, "click_playable_download_button_loading", hashMap);
                        }
                    }
                };
                this.f6619j.getPlayView().setOnClickListener(r1);
                this.f6619j.getPlayView().setOnTouchListener(r1);
            }
            MaterialMeta kVar2 = this.f6628s;
            if (kVar2 != null && kVar2.mo15504r() && this.f6628s.mo15502p()) {
                this.f6629t.sendMessageDelayed(m8192a(2), 10000);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m8203c() {
        if (!this.f6633x.getAndSet(true)) {
            SSWebView sSWebView = this.f6611b;
            if (!(sSWebView == null || this.f6612c == null)) {
                UIUtils.m12059a((View) sSWebView, 0);
                UIUtils.m12059a((View) this.f6612c, 8);
                int i = InternalContainer.m10069h().mo15812r(String.valueOf(ToolUtils.m12018d(this.f6628s.mo15428P()))).f7603s;
                if (i >= 0) {
                    this.f6629t.sendEmptyMessageDelayed(1, (long) (i * 1000));
                } else {
                    UIUtils.m12059a((View) this.f6615f, 0);
                }
            }
        }
    }

    /* renamed from: a */
    private void m8197a(SSWebView sSWebView) {
        if (sSWebView != null) {
            SSWebSettings.m10854a(this.f6616g).mo16362a(false).mo16364b(false).mo16363a((WebView) sSWebView);
            sSWebView.getSettings().setUserAgentString(JsBridgeUtils.m12206a((WebView) sSWebView, this.f6617h));
            if (VERSION.SDK_INT >= 21) {
                sSWebView.getSettings().setMixedContentMode(0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8198a(String str) {
        AdEventManager.m8399b((Context) this, this.f6628s, this.f6627r, str, (JSONObject) null);
    }

    /* renamed from: d */
    private boolean m8206d() {
        if (this.f6612c == null) {
            return false;
        }
        String e = m8207e();
        if (TextUtils.isEmpty(e)) {
            return false;
        }
        SSWebView sSWebView = this.f6612c;
        C20556 r2 = new TTWebViewClient(this.f6616g, this.f6623n, this.f6620k, null) {
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (TTPlayableLandingPageActivity.this.f6614e) {
                    TTPlayableLandingPageActivity.this.m8198a("loading_h5_success");
                }
            }

            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                TTPlayableLandingPageActivity.this.f6614e = false;
            }

            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                TTPlayableLandingPageActivity.this.f6614e = false;
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                TTPlayableLandingPageActivity.this.f6614e = false;
            }
        };
        sSWebView.setWebViewClient(r2);
        this.f6612c.loadUrl(e);
        return true;
    }

    /* renamed from: e */
    private String m8207e() {
        String p = InternalContainer.m10069h().mo15808p();
        if (TextUtils.isEmpty(p)) {
            return p;
        }
        MaterialMeta kVar = this.f6628s;
        if (kVar == null || kVar.mo15426N() == null) {
            return p;
        }
        String c = this.f6628s.mo15426N().mo15345c();
        int e = this.f6628s.mo15426N().mo15350e();
        int f = this.f6628s.mo15426N().mo15351f();
        String a = this.f6628s.mo15415C().mo15406a();
        String M = this.f6628s.mo15425M();
        String d = this.f6628s.mo15426N().mo15348d();
        String b = this.f6628s.mo15426N().mo15342b();
        String c2 = this.f6628s.mo15426N().mo15345c();
        StringBuffer stringBuffer = new StringBuffer(p);
        stringBuffer.append("?appname=");
        stringBuffer.append(c);
        stringBuffer.append("&stars=");
        stringBuffer.append(e);
        stringBuffer.append("&comments=");
        stringBuffer.append(f);
        stringBuffer.append("&icon=");
        stringBuffer.append(a);
        stringBuffer.append("&downloading=");
        stringBuffer.append(false);
        stringBuffer.append("&id=");
        stringBuffer.append(M);
        stringBuffer.append("&pkg_name=");
        stringBuffer.append(d);
        stringBuffer.append("&download_url=");
        stringBuffer.append(b);
        stringBuffer.append("&name=");
        stringBuffer.append(c2);
        return stringBuffer.toString();
    }

    /* renamed from: f */
    private void m8209f() {
        if (!this.f6631v && this.f6630u) {
            ITTDownloadAdapter aVar = this.f6632w;
            if (aVar != null) {
                aVar.mo16522h();
            }
        }
    }

    /* renamed from: g */
    private void m8212g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f6628s);
        this.f6622m = new TTAndroidObject(this);
        this.f6622m.mo16398a((WebView) this.f6611b).mo16400a(this.f6628s).mo16408a((List<MaterialMeta>) arrayList).mo16407a(this.f6620k).mo16416b(this.f6621l).mo16397a(this.f6624o).mo16399a((PendingDownloadListener) this).mo16405a(this.f6610a).mo16421c(ToolUtils.m12032g(this.f6628s));
        this.f6623n = new TTAndroidObject(this);
        this.f6623n.mo16398a((WebView) this.f6612c).mo16400a(this.f6628s).mo16407a(this.f6620k).mo16416b(this.f6621l).mo16399a((PendingDownloadListener) this).mo16397a(this.f6624o).mo16422c(false).mo16421c(ToolUtils.m12032g(this.f6628s));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        TTAndroidObject xVar = this.f6622m;
        if (xVar != null) {
            xVar.mo16430g();
        }
        TTAndroidObject xVar2 = this.f6623n;
        if (xVar2 != null) {
            xVar2.mo16430g();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        SingleAppData.m10160a().mo15935b(true);
        TTAndroidObject xVar = this.f6622m;
        if (xVar != null) {
            xVar.mo16433h();
        }
        TTAndroidObject xVar2 = this.f6623n;
        if (xVar2 != null) {
            xVar2.mo16433h();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        C2538ak akVar = this.f6629t;
        if (akVar != null) {
            akVar.removeCallbacksAndMessages(null);
        }
        try {
            if (getWindow() != null) {
                ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                }
            }
        } catch (Throwable unused) {
        }
        WebViewTweaker.m9083a(this.f6616g, this.f6611b);
        WebViewTweaker.m9084a(this.f6611b);
        this.f6611b = null;
        TTAndroidObject xVar = this.f6622m;
        if (xVar != null) {
            xVar.mo16434i();
        }
        TTAndroidObject xVar2 = this.f6623n;
        if (xVar2 != null) {
            xVar2.mo16434i();
        }
        m8209f();
    }

    /* renamed from: a */
    public void mo14813a(Message message) {
        if (message.what == 1) {
            UIUtils.m12059a((View) this.f6615f, 0);
        } else if (message.what == 2 && this.f6635z) {
            HashMap hashMap = new HashMap();
            hashMap.put("remove_loading_page_type", Integer.valueOf(message.arg1));
            if (this.f6628s.mo15512z() != null) {
                hashMap.put("playable_url", this.f6628s.mo15512z().mo15604h());
            }
            AdEventManager.m8419r(this, this.f6628s, this.f6627r, "remove_loading_page", hashMap);
            this.f6629t.removeMessages(2);
            PlayableLoadingView playableLoadingView = this.f6619j;
            if (playableLoadingView != null) {
                playableLoadingView.mo16239a();
            }
        }
    }

    /* renamed from: a */
    public void mo14949a(boolean z) {
        this.f6630u = true;
        this.f6631v = z;
        if (!z) {
            Toast.makeText(this.f6616g, "稍后开始下载", 0).show();
        }
        if (this.f6631v) {
            ITTDownloadAdapter aVar = this.f6632w;
            if (aVar != null) {
                aVar.mo16522h();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m8214h() {
        MaterialMeta kVar = this.f6628s;
        if (kVar != null && this.f6611b != null && kVar.mo15503q()) {
            Bitmap a = UIUtils.m12052a((WebView) this.f6611b);
            if (a != null) {
                UIUtils.m12057a(InternalContainer.m10059a(), this.f6628s, this.f6627r, "playable_show_status", a);
            }
        }
    }
}
