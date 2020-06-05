package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener;
import com.bytedance.sdk.openadsdk.core.C2240g;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.TTAndroidObject;
import com.bytedance.sdk.openadsdk.core.p170d.DynamicClickInfo;
import com.bytedance.sdk.openadsdk.core.p170d.Image;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p170d.RenderInfo;
import com.bytedance.sdk.openadsdk.core.p170d.TmplDiffModel;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebSettings;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.widget.webview.TTWebChromeClient;
import com.bytedance.sdk.openadsdk.core.widget.webview.WebViewPool;
import com.bytedance.sdk.openadsdk.core.widget.webview.p179a.C2373f;
import com.bytedance.sdk.openadsdk.core.widget.webview.p179a.TTDynamic;
import com.bytedance.sdk.openadsdk.downloadnew.TTDownloadFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.p185f.StatsLogManager;
import com.bytedance.sdk.openadsdk.p185f.p186a.LogStatsBase;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.JsBridgeUtils;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.bytedance.sdk.openadsdk.utils.UIUtils;
import com.tencent.bugly.beta.tinker.TinkerUtils;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class NativeExpressView extends FrameLayout implements RenderListener {
    /* renamed from: A */
    private final AtomicBoolean f7774A = new AtomicBoolean(false);
    /* renamed from: B */
    private String f7775B = null;
    /* renamed from: C */
    private float f7776C;
    /* renamed from: D */
    private float f7777D;
    /* renamed from: E */
    private final AtomicBoolean f7778E = new AtomicBoolean(false);
    /* renamed from: F */
    private String f7779F = "{\"id\":0,\"tplId\":0,\"title\":\"\",\"data\":{\"id\":\"root\",\"type\":\"vessel\",\"values\":{\"widthMode\":\"fixed\",\"width\":320,\"height\":320},\"children\":[[{\"type\":\"text\",\"values\":{\"fontSize\":19,\"fontWeight\":500,\"color\":\"#222222\",\"lineHeight\":1.3,\"data\":\"title\"}}],[{\"type\":\"text\",\"values\":{\"fontSize\":15,\"fontWeight\":500,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"subtitle\"}}],[{\"type\":\"image\",\"values\":{},\"children\":[]}],[{\"type\":\"vessel\",\"values\":{\"height\":40,\"paddingTop\":10,\"paddingRight\":15,\"paddingBottom\":10,\"paddingLeft\":15},\"children\":[[{\"type\":\"logo\",\"values\":{}},{\"type\":\"text\",\"values\":{\"widthMode\":\"auto\",\"paddingTop\":3,\"paddingRight\":0,\"paddingBottom\":3,\"paddingLeft\":6,\"fontSize\":12,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"source\"}},{\"type\":\"text\",\"values\":{\"widthMode\":\"auto\",\"paddingTop\":3,\"paddingRight\":0,\"paddingBottom\":3,\"paddingLeft\":10,\"fontSize\":12,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"time\"}},{\"type\":\"empty\",\"values\":{\"height\":18}},{\"type\":\"dislike\",\"values\":{}}]]}]]}}";
    /* renamed from: a */
    private TTAdDislike f7780a;
    /* renamed from: b */
    private TTDislikeDialogAbstract f7781b;
    /* renamed from: c */
    private String f7782c;
    /* renamed from: d */
    private String f7783d;
    /* renamed from: e */
    protected final AtomicBoolean f7784e = new AtomicBoolean(false);
    /* renamed from: f */
    protected final Context f7785f;
    /* renamed from: g */
    protected WeakReference<SSWebView> f7786g;
    /* renamed from: h */
    protected TTAndroidObject f7787h;
    /* renamed from: i */
    protected String f7788i = "embeded_ad";
    /* renamed from: j */
    protected AdSlot f7789j;
    /* access modifiers changed from: protected */
    /* renamed from: k */
    public MaterialMeta f7790k;
    /* renamed from: l */
    protected ExpressVideoAdListener f7791l;
    /* renamed from: m */
    protected FrameLayout f7792m;
    /* renamed from: n */
    protected boolean f7793n;
    /* renamed from: o */
    protected boolean f7794o = false;
    /* renamed from: p */
    protected ScheduledFuture<?> f7795p;
    /* renamed from: q */
    protected ExpressBackupListener f7796q;
    /* renamed from: r */
    protected boolean f7797r = false;
    /* renamed from: s */
    protected BackupView f7798s;
    /* renamed from: t */
    private int f7799t;
    /* renamed from: u */
    private int f7800u;
    /* renamed from: v */
    private ExpressAdInteractionListener f7801v;
    /* renamed from: w */
    private ExpressClickCreativeListener f7802w;
    /* renamed from: x */
    private ExpressClickListener f7803x;
    /* access modifiers changed from: private|final */
    /* renamed from: y */
    public final Map<String, ITTDownloadAdapter> f7804y = Collections.synchronizedMap(new HashMap());
    /* renamed from: z */
    private final AtomicBoolean f7805z = new AtomicBoolean(false);

    /* renamed from: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView$a */
    private class C2271a implements Runnable {
        /* renamed from: b */
        private int f7813b;

        public C2271a(int i) {
            this.f7813b = i;
        }

        public void run() {
            if (this.f7813b == 1) {
                C2564t.m12222c("NativeExpressView", "MSG_RENDER_TIME_OUT-->OnAdRenderRunnable......run....");
                NativeExpressView.this.mo15871a(false, 0.0f, 0.0f, 107);
            }
        }
    }

    public NativeExpressView(Context context, MaterialMeta kVar, AdSlot adSlot, String str) {
        super(context);
        this.f7788i = str;
        this.f7785f = context;
        this.f7790k = kVar;
        m9959a(adSlot);
        mo15183a();
    }

    /* renamed from: a */
    private void m9959a(AdSlot adSlot) {
        this.f7789j = adSlot;
        AdSlot adSlot2 = this.f7789j;
        if (adSlot2 != null) {
            this.f7776C = adSlot2.getExpressViewAcceptedWidth();
            this.f7777D = this.f7789j.getExpressViewAcceptedHeight();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15183a() {
        setBackgroundColor(0);
        if (getWebView().getParent() != null) {
            ((ViewGroup) getWebView().getParent()).removeView(getWebView());
        }
        getWebView().setBackgroundColor(0);
        addView(getWebView(), new LayoutParams(-1, -1));
        mo15047c();
        mo15186b();
        mo15048d();
        getWebView().addJavascriptInterface(this.f7787h, "SDK_INJECT_GLOBAL");
    }

    /* renamed from: c */
    private void mo15047c() {
        this.f7782c = this.f7790k.mo15425M();
        this.f7783d = this.f7790k.mo15428P();
        this.f7800u = 2955;
        this.f7799t = ToolUtils.m11991a(this.f7788i);
        this.f7775B = this.f7789j.getCodeId();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo15186b() {
        this.f7787h = new TTAndroidObject(this.f7785f);
        this.f7787h.mo16398a((WebView) getWebView()).mo16400a(this.f7790k).mo16407a(this.f7782c).mo16416b(this.f7783d).mo16397a(this.f7799t).mo16421c(ToolUtils.m12032g(this.f7790k)).mo16402a((RenderListener) this).mo16410a(getTemplateInfo());
    }

    public SSWebView getWebView() {
        WeakReference<SSWebView> weakReference = this.f7786g;
        if (weakReference != null && weakReference.get() != null) {
            return (SSWebView) this.f7786g.get();
        }
        this.f7786g = WebViewPool.m10920a().mo16394c();
        return (SSWebView) this.f7786g.get();
    }

    /* renamed from: d */
    private void mo15048d() {
        m9961a(getWebView());
        getWebView().setWebViewClient(new ExpressClient(this.f7785f, this.f7787h, this.f7790k));
        getWebView().setWebChromeClient(new TTWebChromeClient(this.f7787h, null));
        getWebView().setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (NativeExpressView.this.f7804y.containsKey(str)) {
                    ITTDownloadAdapter aVar = (ITTDownloadAdapter) NativeExpressView.this.f7804y.get(str);
                    if (aVar != null) {
                        aVar.mo16520f();
                        return;
                    }
                    return;
                }
                String str5 = null;
                if (!(NativeExpressView.this.f7790k == null || NativeExpressView.this.f7790k.mo15415C() == null)) {
                    str5 = NativeExpressView.this.f7790k.mo15415C().mo15406a();
                }
                ITTDownloadAdapter a = TTDownloadFactory.m11072a(NativeExpressView.this.f7785f, str, str5);
                NativeExpressView.this.f7804y.put(str, a);
                a.mo16520f();
            }
        });
    }

    /* renamed from: a */
    private void m9961a(SSWebView sSWebView) {
        if (sSWebView != null) {
            try {
                SSWebSettings.m10854a(this.f7785f).mo16362a(!this.f7788i.equals("embeded_ad")).mo16363a((WebView) sSWebView);
                sSWebView.setVerticalScrollBarEnabled(false);
                sSWebView.setHorizontalScrollBarEnabled(false);
                sSWebView.clearCache(true);
                sSWebView.clearHistory();
                WebSettings settings = sSWebView.getSettings();
                settings.setUserAgentString(JsBridgeUtils.m12206a((WebView) sSWebView, this.f7800u));
                if (VERSION.SDK_INT >= 21) {
                    settings.setMixedContentMode(0);
                }
                settings.setJavaScriptEnabled(true);
                settings.setJavaScriptCanOpenWindowsAutomatically(true);
                settings.setCacheMode(2);
                settings.setDomStorageEnabled(true);
                settings.setDatabaseEnabled(true);
                settings.setAppCacheEnabled(true);
                settings.setAllowFileAccess(true);
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
                settings.setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS);
                settings.setUseWideViewPort(true);
            } catch (Exception e) {
                C2564t.m12226e("NativeExpressView", e.toString());
            }
        }
    }

    public void setVideoAdListener(ExpressVideoAdListener expressVideoAdListener) {
        this.f7791l = expressVideoAdListener;
    }

    public void setOuterDislike(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        BackupView backupView = this.f7798s;
        if (backupView != null) {
            backupView.setDislikeOuter(tTDislikeDialogAbstract);
        }
        this.f7781b = tTDislikeDialogAbstract;
    }

    public void setDislike(TTAdDislike tTAdDislike) {
        BackupView backupView = this.f7798s;
        if (backupView != null) {
            backupView.setDislikeInner(tTAdDislike);
        }
        this.f7780a = tTAdDislike;
    }

    public void setExpressInteractionListener(ExpressAdInteractionListener expressAdInteractionListener) {
        this.f7801v = expressAdInteractionListener;
    }

    public void setClickCreativeListener(ExpressClickCreativeListener dVar) {
        this.f7802w = dVar;
    }

    public ExpressClickCreativeListener getClickCreativeListener() {
        return this.f7802w;
    }

    public ExpressClickListener getClickListener() {
        return this.f7803x;
    }

    public void setClickListener(ExpressClickListener eVar) {
        this.f7803x = eVar;
    }

    public void setBackupListener(ExpressBackupListener cVar) {
        this.f7796q = cVar;
    }

    /* renamed from: g */
    public void mo15872g() {
        String str = "expressShow";
        if (this.f7787h != null && !this.f7778E.get()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, true);
                this.f7787h.mo16412a(str, jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: h */
    public void mo15878h() {
        this.f7774A.set(true);
        this.f7795p = TTExecutor.m11692a().mo16802a((Runnable) new C2271a(1), (long) InternalContainer.m10069h().mo15770R());
        if (!TTDynamic.m10873g()) {
            mo15871a(false, 0.0f, 0.0f, 102);
            return;
        }
        String str = null;
        String c = TTDynamic.m10872f() != null ? TTDynamic.m10872f().mo15555c() : null;
        if (TextUtils.isEmpty(c)) {
            mo15871a(false, 0.0f, 0.0f, 102);
            return;
        }
        TmplDiffModel b = TTDynamic.m10867b(this.f7790k);
        if (b != null || mo15050e()) {
            if (b != null) {
                str = b.mo15578f();
            }
            if (mo15050e() && !TextUtils.isEmpty(this.f7790k.mo15510x().mo15513a())) {
                str = this.f7790k.mo15510x().mo15513a();
            }
            if (!C2373f.m10916b(str) || "https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/latest/index.html".equals(c)) {
                getWebView().loadUrl(c);
            } else {
                mo15871a(false, 0.0f, 0.0f, 102);
            }
        } else {
            mo15871a(false, 0.0f, 0.0f, 103);
        }
    }

    /* renamed from: e */
    private boolean mo15050e() {
        MaterialMeta kVar = this.f7790k;
        if (kVar == null || kVar.mo15510x() == null || TextUtils.isEmpty(this.f7790k.mo15510x().mo15521e())) {
            return false;
        }
        return true;
    }

    private JSONObject getTemplateInfo() {
        Object obj;
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TinkerUtils.PLATFORM, "android");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", (double) this.f7776C);
            jSONObject2.put("height", (double) this.f7777D);
            if (this.f7794o) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObject.put("AdSize", jSONObject2);
            jSONObject.put("creative", getCreativeJson());
            if (this.f7790k.mo15510x() != null) {
                str = this.f7790k.mo15510x().mo15521e();
                obj = this.f7790k.mo15510x().mo15523f();
            } else {
                str = null;
                obj = null;
            }
            if (!TextUtils.isEmpty(str)) {
                this.f7779F = str;
            } else if (TTDynamic.m10867b(this.f7790k) != null) {
                this.f7779F = TTDynamic.m10867b(this.f7790k).mo15576e();
            }
            jSONObject.put("template_Plugin", this.f7779F);
            jSONObject.put("diff_template_Plugin", obj);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject getCreativeJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("button_text", this.f7790k.mo15424L());
            if (this.f7790k.mo15415C() != null) {
                jSONObject.put("icon", this.f7790k.mo15415C().mo15406a());
            }
            JSONArray jSONArray = new JSONArray();
            if (this.f7790k.mo15418F() != null) {
                for (int i = 0; i < this.f7790k.mo15418F().size(); i++) {
                    Image jVar = (Image) this.f7790k.mo15418F().get(i);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("height", jVar.mo15411c());
                    jSONObject2.put("width", jVar.mo15409b());
                    jSONObject2.put("url", jVar.mo15406a());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("image", jSONArray);
            jSONObject.put("image_mode", this.f7790k.mo15429Q());
            jSONObject.put("interaction_type", this.f7790k.mo15414B());
            jSONObject.put("title", this.f7790k.mo15422J());
            jSONObject.put("description", this.f7790k.mo15423K());
            jSONObject.put(ArgKey.KEY_SOURCE, this.f7790k.mo15413A());
            if (this.f7790k.mo15426N() != null) {
                jSONObject.put("comment_num", this.f7790k.mo15426N().mo15351f());
                jSONObject.put("score", this.f7790k.mo15426N().mo15350e());
                jSONObject.put("app_size", this.f7790k.mo15426N().mo15352g());
                jSONObject.put("app", this.f7790k.mo15426N().mo15353h());
            }
            if (this.f7790k.mo15512z() != null) {
                jSONObject.put("video", this.f7790k.mo15512z().mo15607k());
            }
            if (this.f7790k.mo15510x() != null) {
                jSONObject.put("dynamic_creative", this.f7790k.mo15510x().mo15525g());
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public void mo15185a(RenderInfo mVar) {
        int i = 0;
        if (mVar == null) {
            mo15871a(false, 0.0f, 0.0f, 105);
            return;
        }
        boolean a = mVar.mo15532a();
        float b = (float) mVar.mo15533b();
        float c = (float) mVar.mo15535c();
        if (!a) {
            i = mVar.mo15544h();
        }
        mo15871a(a, b, c, i);
    }

    /* renamed from: a */
    private void m9957a(float f, float f2) {
        if (f > 0.0f && f2 > 0.0f) {
            int a = (int) UIUtils.m12048a(this.f7785f, f);
            int a2 = (int) UIUtils.m12048a(this.f7785f, f2);
            StringBuilder sb = new StringBuilder();
            sb.append("width:");
            sb.append(a);
            String str = "ExpressView";
            C2564t.m12226e(str, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("height:");
            sb2.append(a2);
            C2564t.m12226e(str, sb2.toString());
            LayoutParams layoutParams = (LayoutParams) getWebView().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(a, a2);
            }
            layoutParams.width = a;
            layoutParams.height = a2;
            getWebView().setLayoutParams(layoutParams);
        }
    }

    /* renamed from: a */
    public void mo15184a(int i, DynamicClickInfo iVar) {
        int i2 = i;
        DynamicClickInfo iVar2 = iVar;
        if (i2 != -1 && iVar2 != null) {
            int i3 = iVar2.f7378a;
            int i4 = iVar2.f7379b;
            int i5 = iVar2.f7380c;
            int i6 = iVar2.f7381d;
            if (i2 == 1) {
                FrameLayout frameLayout = this.f7792m;
                if (frameLayout != null) {
                    frameLayout.dispatchTouchEvent(MotionEvent.obtain(0, 0, 0, 0.0f, 0.0f, 0));
                }
                ExpressClickListener eVar = this.f7803x;
                if (eVar != null) {
                    eVar.mo15902a(iVar2);
                    this.f7803x.mo14920a(this, i3, i4, i5, i6);
                }
                ExpressAdInteractionListener expressAdInteractionListener = this.f7801v;
                if (expressAdInteractionListener != null) {
                    expressAdInteractionListener.onAdClicked(this, this.f7790k.mo15414B());
                }
            } else if (i2 == 2) {
                ExpressClickCreativeListener dVar = this.f7802w;
                if (dVar != null) {
                    dVar.mo15901a(iVar2);
                    this.f7802w.mo14920a(this, i3, i4, i5, i6);
                }
                ExpressAdInteractionListener expressAdInteractionListener2 = this.f7801v;
                if (expressAdInteractionListener2 != null) {
                    expressAdInteractionListener2.onAdClicked(this, this.f7790k.mo15414B());
                }
            } else if (i2 == 3) {
                TTDislikeDialogAbstract tTDislikeDialogAbstract = this.f7781b;
                if (tTDislikeDialogAbstract != null) {
                    tTDislikeDialogAbstract.show();
                    return;
                }
                TTAdDislike tTAdDislike = this.f7780a;
                if (tTAdDislike != null) {
                    tTAdDislike.showDislikeDialog();
                }
            } else if (i2 == 4) {
                FrameLayout frameLayout2 = this.f7792m;
                if (frameLayout2 != null) {
                    frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0, 0, 0, 0.0f, 0.0f, 0));
                }
                StringBuilder sb = new StringBuilder();
                sb.append("创意....mAdType=");
                sb.append(this.f7788i);
                sb.append(",!mVideoPause=");
                sb.append(true ^ this.f7793n);
                sb.append("，isAutoPlay=");
                sb.append(ToolUtils.m12035h(this.f7790k));
                String str = "ClickCreativeListener";
                C2564t.m12220b(str, sb.toString());
                if (!"embeded_ad".equals(this.f7788i) || !mo15051f() || this.f7793n || !ToolUtils.m12035h(this.f7790k)) {
                    C2564t.m12220b(str, "普通....");
                    ExpressClickListener eVar2 = this.f7803x;
                    if (eVar2 != null) {
                        eVar2.mo15902a(iVar2);
                        this.f7803x.mo14920a(this, i3, i4, i5, i6);
                    }
                } else {
                    C2564t.m12220b(str, "创意....");
                    ExpressClickCreativeListener dVar2 = this.f7802w;
                    if (dVar2 != null) {
                        dVar2.mo15901a(iVar2);
                        this.f7802w.mo14920a(this, i3, i4, i5, i6);
                    }
                }
                ExpressAdInteractionListener expressAdInteractionListener3 = this.f7801v;
                if (expressAdInteractionListener3 != null) {
                    expressAdInteractionListener3.onAdClicked(this, this.f7790k.mo15414B());
                }
            }
        }
    }

    /* renamed from: f */
    private boolean mo15051f() {
        MaterialMeta kVar = this.f7790k;
        if (kVar != null && kVar.mo15475e() == 1 && (this.f7790k.mo15429Q() == 5 || this.f7790k.mo15429Q() == 15)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private void mo15867a(int i) {
        StatsLogManager.m11278a().mo16576h(LogStatsBase.m11308b().mo16590a(getAdSlotType()).mo16595c(this.f7775B).mo16601f(ToolUtils.m12034h(this.f7783d)).mo16592b(i).mo16603g(C2240g.m9576a(i)));
    }

    private int getAdSlotType() {
        /*
        r5 = this;
        java.lang.String r0 = r5.f7788i
        int r1 = r0.hashCode()
        r2 = 3
        r3 = 2
        r4 = 1
        switch(r1) {
            case -1364000502: goto L_0x002b;
            case -764631662: goto L_0x0021;
            case -712491894: goto L_0x0017;
            case 1912999166: goto L_0x000d;
            default: goto L_0x000c;
        }
    L_0x000c:
        goto L_0x0035
    L_0x000d:
        java.lang.String r1 = "draw_ad"
        boolean r0 = r0.equals(r1)
        if (r0 == 0) goto L_0x0035
        r0 = 1
        goto L_0x0036
    L_0x0017:
        java.lang.String r1 = "embeded_ad"
        boolean r0 = r0.equals(r1)
        if (r0 == 0) goto L_0x0035
        r0 = 0
        goto L_0x0036
    L_0x0021:
        java.lang.String r1 = "fullscreen_interstitial_ad"
        boolean r0 = r0.equals(r1)
        if (r0 == 0) goto L_0x0035
        r0 = 3
        goto L_0x0036
    L_0x002b:
        java.lang.String r1 = "rewarded_video"
        boolean r0 = r0.equals(r1)
        if (r0 == 0) goto L_0x0035
        r0 = 2
        goto L_0x0036
    L_0x0035:
        r0 = -1
    L_0x0036:
        r1 = 5
        if (r0 == 0) goto L_0x0048
        if (r0 == r4) goto L_0x0045
        if (r0 == r3) goto L_0x0043
        if (r0 == r2) goto L_0x0040
        return r1
    L_0x0040:
        r0 = 8
        return r0
    L_0x0043:
        r0 = 7
        return r0
    L_0x0045:
        r0 = 9
        return r0
    L_0x0048:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.getAdSlotType():int");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C2564t.m12226e("webviewpool", "onAttachedToWindow+++");
        m9967n();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        C2564t.m12226e("webviewpool", "onFinishTemporaryDetach+++");
        m9967n();
    }

    /* renamed from: n */
    private void m9967n() {
        if (this.f7805z.getAndSet(false) && getWebView().getParent() == null && !this.f7797r) {
            C2564t.m12226e("webviewpool", "attachCallback+++========-----------===========");
            mo15183a();
            mo15878h();
        }
    }

    /* renamed from: o */
    private void m9968o() {
        if (!this.f7805z.getAndSet(true) && !this.f7797r) {
            WebViewPool.m10920a().mo16392a(this, this.f7786g, mo15880j());
        }
    }

    /* renamed from: i */
    public void mo15879i() {
        if (getWebView() != null && !this.f7778E.get()) {
            try {
                if (this.f7788i.equals("embeded_ad")) {
                    SSWebSettings.m10854a(this.f7785f).mo16362a(true).mo16363a((WebView) getWebView());
                }
                getWebView().resumeTimers();
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public boolean mo15880j() {
        if (!"embeded_ad".equals(this.f7788i)) {
            if (!"draw_ad".equals(this.f7788i)) {
                this.f7778E.set(true);
                return true;
            }
        }
        return false;
    }

    /* renamed from: k */
    public void mo15881k() {
        try {
            WebViewPool.m10920a().mo16392a(this, this.f7786g, true);
            this.f7778E.set(true);
            this.f7787h = null;
            this.f7780a = null;
            this.f7781b = null;
            this.f7789j = null;
            this.f7790k = null;
            this.f7801v = null;
            this.f7802w = null;
            this.f7803x = null;
            this.f7804y.clear();
            this.f7791l = null;
            removeAllViews();
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            m9969p();
        } catch (Throwable th) {
            C2564t.m12223c("NativeExpressView", "detach error", th);
        }
    }

    /* renamed from: l */
    public void mo15882l() {
        String str = "NativeExpressView";
        try {
            WebViewPool.m10920a().mo16392a(this, this.f7786g, true);
            this.f7778E.set(true);
        } catch (Throwable th) {
            C2564t.m12216a(str, "backupDestroy remove webview error", th);
        }
        try {
            if (this.f7792m != null && this.f7792m.getParent() != null) {
                removeView(this.f7792m);
            }
        } catch (Throwable th2) {
            C2564t.m12216a(str, "backupDestroy remove video container error", th2);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m9968o();
        C2564t.m12226e("webviewpool", "onDetachedFromWindow===");
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        m9968o();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15871a(boolean z, float f, float f2, int i) {
        m9969p();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            m9962b(z, f, f2, i);
            return;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        final boolean z2 = z;
        final float f3 = f;
        final float f4 = f2;
        final int i2 = i;
        C22702 r2 = new Runnable() {
            public void run() {
                NativeExpressView.this.m9962b(z2, f3, f4, i2);
            }
        };
        handler.post(r2);
    }

    /* renamed from: p */
    private void m9969p() {
        try {
            if (this.f7795p != null && !this.f7795p.isCancelled()) {
                boolean cancel = this.f7795p.cancel(false);
                StringBuilder sb = new StringBuilder();
                sb.append("MSG_RENDER_TIME_OUT-->mRenderTimeOutFuture-->cancel.....success=");
                sb.append(cancel);
                C2564t.m12220b("NativeExpressView", sb.toString());
                this.f7795p = null;
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: m */
    public boolean mo15883m() {
        return this.f7797r;
    }

    public int getExpectExpressWidth() {
        return Float.valueOf(this.f7776C).intValue();
    }

    public int getExpectExpressHeight() {
        return Float.valueOf(this.f7777D).intValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9962b(boolean z, float f, float f2, int i) {
        boolean z2 = true;
        if (!this.f7784e.getAndSet(true)) {
            if (z) {
                m9957a(f, f2);
                ExpressAdInteractionListener expressAdInteractionListener = this.f7801v;
                if (expressAdInteractionListener != null) {
                    expressAdInteractionListener.onRenderSuccess(this, f, f2);
                }
            } else {
                ExpressBackupListener cVar = this.f7796q;
                if (cVar == null || !cVar.mo15189a(this, i)) {
                    z2 = false;
                }
                this.f7797r = z2;
                if (this.f7797r) {
                    AdEventManager.m8416o(InternalContainer.m10059a(), this.f7790k, this.f7788i, "dynamic_backup_render", null);
                    this.f7798s = (BackupView) findViewWithTag("tt_express_backup_fl_tag_26");
                    ExpressAdInteractionListener expressAdInteractionListener2 = this.f7801v;
                    if (expressAdInteractionListener2 != null) {
                        expressAdInteractionListener2.onRenderSuccess(this, this.f7798s.getRealWidth(), this.f7798s.getRealHeight());
                    }
                } else {
                    ExpressAdInteractionListener expressAdInteractionListener3 = this.f7801v;
                    if (expressAdInteractionListener3 != null) {
                        expressAdInteractionListener3.onRenderFail(this, C2240g.m9576a(i), i);
                    }
                }
                mo15867a(i);
            }
        }
    }
}
