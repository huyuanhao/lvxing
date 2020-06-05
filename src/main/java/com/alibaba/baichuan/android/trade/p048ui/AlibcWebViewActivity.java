package com.alibaba.baichuan.android.trade.p048ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.alibaba.baichuan.android.trade.p046a.p047a.C1116b;
import com.alibaba.baichuan.trade.biz.C1150b;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeContext;
import com.alibaba.baichuan.trade.biz.context.C1162a;
import com.alibaba.baichuan.trade.biz.core.config.C1187b;
import com.alibaba.baichuan.trade.biz.core.p054b.p056b.C1182a;
import com.alibaba.baichuan.trade.biz.core.p057c.C1185a;
import com.alibaba.baichuan.trade.biz.p049a.C1131a;
import com.alibaba.baichuan.trade.biz.p049a.C1135b;
import com.alibaba.baichuan.trade.biz.p051b.C1157d;
import com.alibaba.baichuan.trade.biz.utils.AlibcURLCheck;
import com.alibaba.baichuan.trade.common.C1223b;
import com.alibaba.baichuan.trade.common.adapter.p060b.C1207b;
import com.alibaba.baichuan.trade.common.p058a.C1193a;
import com.alibaba.baichuan.trade.common.p058a.C1196b;
import com.alibaba.baichuan.trade.common.utils.C1224a;
import com.alibaba.baichuan.trade.common.utils.C1230d;
import com.alibaba.baichuan.trade.common.utils.C1231e;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.alibaba.baichuan.android.trade.ui.AlibcWebViewActivity */
public class AlibcWebViewActivity extends Activity {
    /* renamed from: a */
    private static String[] f2313a = {"^http(s)?://pre-oauth\\.(.*)\\.taobao.com/authorize?(.*)"};
    /* renamed from: b */
    private static String[] f2314b = {"^http(s)?://oauth\\.(.*)\\.taobao.com/authorize?(.*)", "^http(s)?://oauth\\.taobao.com/authorize?(.*)"};
    /* renamed from: c */
    private static AlibcTradeContext f2315c = null;
    /* renamed from: d */
    private static C1116b f2316d = null;
    /* renamed from: e */
    private WebView f2317e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public TextView f2318f;
    /* renamed from: g */
    private View f2319g;
    /* renamed from: h */
    private View f2320h;
    /* renamed from: i */
    private View f2321i;
    /* renamed from: j */
    private C1126a f2322j;

    /* renamed from: com.alibaba.baichuan.android.trade.ui.AlibcWebViewActivity$a */
    public class C1126a extends C1196b {
        protected C1126a() {
            super(1201, true);
        }

        public void onMessageEvent(int i, Object obj) {
            if (obj != null && (obj instanceof String)) {
                AlibcWebViewActivity.this.f2318f.setText((String) obj);
            }
        }
    }

    /* renamed from: a */
    public static AlibcTradeContext m2180a() {
        return f2315c;
    }

    /* renamed from: a */
    private static boolean m2182a(final WebView webView, final String str) {
        String str2 = "AlibcWebViewActivity";
        if (C1187b.m2322a().mo10755a(false)) {
            C1224a.m2404b(str2, "loginDegrade = false,直接采用H5进行登录");
            return false;
        }
        C1224a.m2404b(str2, "调用login sdk接口");
        C1131a.m2193a().mo10645a((C1135b) new C1135b() {
            /* renamed from: a */
            public void mo10642a(int i, String str) {
                if (webView != null) {
                    C1224a.m2404b("AlibcWebViewActivity", "登录失败,进入到页面后退逻辑");
                    Activity activity = (Activity) webView.getContext();
                    if (!C1231e.m2428a(webView.getTag(C1230d.m2427a(activity, "id", "com_taobao_nb_sdk_webview_click")))) {
                        if (webView.canGoBack()) {
                            webView.goBack();
                        } else if (activity != null) {
                            activity.finish();
                        }
                    }
                }
            }

            /* renamed from: a */
            public void mo10643a(int i, String str, String str2) {
                C1224a.m2404b("AlibcWebViewActivity", "登录成功,重新加载页面");
                webView.setTag(C1230d.m2427a(C1223b.f2466f, "id", "webviewload_monitor_cancel_point"), Boolean.valueOf(true));
                webView.loadUrl(str);
                AlibcWebViewActivity.m2184b(webView);
            }
        });
        return true;
    }

    /* renamed from: b */
    private void m2183b() {
        String stringExtra = getIntent().getStringExtra("bc_webview_activity_title");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f2318f.setText(stringExtra);
            return;
        }
        this.f2322j = new C1126a();
        C1193a.m2325a().mo10842a((C1196b) this.f2322j);
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m2184b(WebView webView) {
        HashMap hashMap = new HashMap();
        hashMap.put("appkey", C1223b.m2399c());
        hashMap.put("userId", C1131a.m2193a().mo10647c().f2060d);
        hashMap.put("utdid", C1223b.m2400d());
        hashMap.put("ttid", C1150b.m2192a());
        hashMap.put("ybhpss", m2185c(webView));
        C1207b.m2357a().mo10869a(C1185a.f2440a, "", (Map<String, String>) hashMap);
    }

    /* renamed from: c */
    private static String m2185c(WebView webView) {
        String str = "";
        if (webView == null) {
            return str;
        }
        AlibcTradeContext a = C1162a.m2274a(webView);
        if (!(a == null || a.f2386a == null)) {
            String str2 = "ybhpss";
            if (a.f2386a.get(str2) != null) {
                Object obj = a.f2386a.get(str2);
                if (obj instanceof String) {
                    return (String) obj;
                }
            }
        }
        return str;
    }

    /* renamed from: c */
    private void m2186c() {
        requestWindowFeature(1);
        LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(C1230d.m2426a(this, "com_taobao_nb_sdk_web_view_activity"), null);
        this.f2317e = new WebView(this);
        m2188e();
        linearLayout.addView(this.f2317e, new LayoutParams(-1, -1));
        setContentView(linearLayout);
        String str = "id";
        this.f2318f = (TextView) findViewById(C1230d.m2427a(this, str, "com_taobao_nb_sdk_web_view_title_bar_title"));
        this.f2320h = findViewById(C1230d.m2427a(this, str, "com_taobao_nb_sdk_web_view_title_bar_close_button"));
        this.f2321i = findViewById(C1230d.m2427a(this, str, "com_taobao_nb_sdk_web_view_title_bar_back_button"));
        this.f2319g = findViewById(C1230d.m2427a(this, str, "com_taobao_tae_sdk_web_view_title_bar"));
        m2187d();
    }

    /* renamed from: d */
    private void m2187d() {
        View view = this.f2320h;
        if (view != null) {
            view.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    AlibcWebViewActivity.this.finish();
                }
            });
        }
        View view2 = this.f2321i;
        if (view2 != null) {
            view2.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    AlibcWebViewActivity.this.onBackPressed();
                }
            });
        }
    }

    /* renamed from: e */
    private void m2188e() {
        AlibcTradeContext a = m2180a();
        if (a != null) {
            a.mo10724a((Activity) this);
            a.mo10725a(this.f2317e);
            C1162a.m2276a(a);
        }
        C1157d.m2247a(this, this.f2317e, null, null, true, new C1182a() {
        });
        this.f2317e.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                StringBuilder sb = new StringBuilder();
                sb.append("url=");
                sb.append(str);
                C1224a.m2402a("AlibcWebViewActivity", sb.toString());
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addCategory("android.intent.category.BROWSABLE");
                AlibcWebViewActivity.this.startActivity(intent);
            }
        });
    }

    /* renamed from: f */
    private void m2189f() {
        String stringExtra = getIntent().getStringExtra("url");
        if (!TextUtils.isEmpty(stringExtra)) {
            C1116b bVar = f2316d;
            if (bVar != null) {
                bVar.mo10627a();
            }
            if (!AlibcURLCheck.regular.check(f2314b, stringExtra) || C1131a.m2193a().mo10646b()) {
                this.f2317e.loadUrl(stringExtra);
            } else {
                m2182a(this.f2317e, stringExtra);
            }
        }
    }

    public void onBackPressed() {
        if (this.f2317e.canGoBack()) {
            this.f2317e.goBack();
        } else {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m2186c();
        m2183b();
        m2189f();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        WebView webView = this.f2317e;
        if (webView != null) {
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f2317e);
            }
            this.f2317e.removeAllViews();
            this.f2317e.destroy();
        }
        if (this.f2322j != null) {
            C1193a.m2325a().mo10843b(this.f2322j);
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (intent != null && intent.getExtras() != null) {
            m2189f();
        }
    }
}
