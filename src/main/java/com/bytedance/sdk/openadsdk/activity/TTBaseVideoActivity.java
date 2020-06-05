package com.bytedance.sdk.openadsdk.activity;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;
import com.bytedance.sdk.openadsdk.component.reward.top.TopProxyLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialog;
import com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialog.C2167a;
import com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeToast;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.TTAndroidObject;
import com.bytedance.sdk.openadsdk.core.WebViewTweaker;
import com.bytedance.sdk.openadsdk.core.p167a.RewardBarClickListener;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p173g.PlayableCache;
import com.bytedance.sdk.openadsdk.core.p174h.TTSdkSettings;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.INativeVideoController;
import com.bytedance.sdk.openadsdk.core.video.p176b.BaseVideoController;
import com.bytedance.sdk.openadsdk.core.video.p176b.IBaseVideoBusiness;
import com.bytedance.sdk.openadsdk.core.video.p177c.SSMediaPlayerWrapper;
import com.bytedance.sdk.openadsdk.core.widget.CustomCommonDialog;
import com.bytedance.sdk.openadsdk.core.widget.PlayableLoadingView;
import com.bytedance.sdk.openadsdk.core.widget.TTCustomShadowBackground;
import com.bytedance.sdk.openadsdk.core.widget.TTCustomShadowBackground.C2361a;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebSettings;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.widget.webview.TTWebChromeClient;
import com.bytedance.sdk.openadsdk.core.widget.webview.TTWebViewClient;
import com.bytedance.sdk.openadsdk.downloadnew.TTDownloadFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter.C2417a;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.multipro.aidl.BinderPool;
import com.bytedance.sdk.openadsdk.multipro.aidl.p201a.AbstractListenerManager;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.p165c.LandingPageLog;
import com.bytedance.sdk.openadsdk.p184e.ContainerSizeListener;
import com.bytedance.sdk.openadsdk.p184e.PlayableLoadingListener;
import com.bytedance.sdk.openadsdk.p184e.SendRewardListener;
import com.bytedance.sdk.openadsdk.p184e.VolumeChangeListener;
import com.bytedance.sdk.openadsdk.p184e.VolumeChangeObserver;
import com.bytedance.sdk.openadsdk.p185f.StatsLogManager;
import com.bytedance.sdk.openadsdk.p185f.p186a.LogStatsBase;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.bytedance.sdk.openadsdk.utils.C2538ak;
import com.bytedance.sdk.openadsdk.utils.C2538ak.C2539a;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.HomeWatcherReceiver;
import com.bytedance.sdk.openadsdk.utils.HomeWatcherReceiver.C2529a;
import com.bytedance.sdk.openadsdk.utils.JsBridgeUtils;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.bytedance.sdk.openadsdk.utils.UIUtils;
import com.p522qq.p523e.comm.constants.ErrorCode.OtherError;
import com.tencent.p605ep.common.adapt.iservice.profile.ProfileID;
import com.tencent.qqpim.discovery.internal.protocol.C7516p;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public abstract class TTBaseVideoActivity extends Activity implements IBaseVideoBusiness, VolumeChangeListener, C2529a, C2539a {
    /* renamed from: aa */
    protected static RemoteCallbackList<ITTAppDownloadListener> f6427aa;
    /* renamed from: A */
    INativeVideoController f6428A;
    /* renamed from: B */
    ITTDownloadAdapter f6429B;
    /* renamed from: C */
    TTAndroidObject f6430C;
    /* renamed from: D */
    TTAndroidObject f6431D;
    /* renamed from: E */
    HomeWatcherReceiver f6432E;
    /* renamed from: F */
    final C2538ak f6433F = new C2538ak(Looper.getMainLooper(), this);
    /* renamed from: G */
    final Map<String, ITTDownloadAdapter> f6434G = Collections.synchronizedMap(new HashMap());
    /* renamed from: H */
    String f6435H;
    /* renamed from: I */
    String f6436I;
    /* renamed from: J */
    int f6437J;
    /* renamed from: K */
    int f6438K;
    /* renamed from: L */
    protected String f6439L;
    /* renamed from: M */
    boolean f6440M = false;
    /* renamed from: N */
    int f6441N;
    /* renamed from: O */
    int f6442O = 5;
    /* renamed from: P */
    int f6443P = 3;
    /* renamed from: Q */
    int f6444Q;
    /* renamed from: R */
    final AtomicBoolean f6445R = new AtomicBoolean(false);
    /* renamed from: S */
    final AtomicBoolean f6446S = new AtomicBoolean(false);
    /* renamed from: T */
    final AtomicBoolean f6447T = new AtomicBoolean(false);
    /* renamed from: U */
    final AtomicBoolean f6448U = new AtomicBoolean(false);
    /* renamed from: V */
    final AtomicBoolean f6449V = new AtomicBoolean(false);
    /* renamed from: W */
    final AtomicBoolean f6450W = new AtomicBoolean(false);
    /* renamed from: X */
    protected final AtomicBoolean f6451X = new AtomicBoolean(false);
    /* renamed from: Y */
    protected CustomCommonDialog f6452Y;
    /* renamed from: Z */
    protected final String f6453Z = Build.MODEL;
    /* renamed from: a */
    PlayableLoadingView f6454a;
    /* renamed from: aA */
    View f6455aA;
    /* renamed from: aB */
    protected ContainerSizeListener f6456aB;
    /* renamed from: aC */
    protected SendRewardListener f6457aC;
    /* renamed from: aD */
    protected PlayableLoadingListener f6458aD;
    /* renamed from: aE */
    ProgressBar f6459aE;
    /* renamed from: aF */
    private RewardBarClickListener f6460aF;
    /* access modifiers changed from: private */
    /* renamed from: aG */
    public boolean f6461aG;
    /* renamed from: aH */
    private VolumeChangeObserver f6462aH;
    /* access modifiers changed from: private */
    /* renamed from: aI */
    public boolean f6463aI;
    /* renamed from: aJ */
    private AtomicBoolean f6464aJ;
    /* renamed from: aK */
    private OnClickListener f6465aK;
    /* renamed from: aL */
    private boolean f6466aL;
    /* renamed from: aM */
    private int f6467aM;
    /* renamed from: ab */
    protected IListenerManager f6468ab;
    /* renamed from: ac */
    protected String f6469ac;
    /* renamed from: ad */
    protected boolean f6470ad = false;
    /* renamed from: ae */
    protected boolean f6471ae = false;
    /* renamed from: af */
    protected int f6472af = 0;
    /* renamed from: ag */
    LinearLayout f6473ag;
    /* renamed from: ah */
    TTRoundRectImageView f6474ah;
    /* renamed from: ai */
    TextView f6475ai;
    /* renamed from: aj */
    TTRatingBar f6476aj;
    /* renamed from: ak */
    TextView f6477ak;
    /* renamed from: al */
    TextView f6478al;
    /* renamed from: am */
    AtomicBoolean f6479am = new AtomicBoolean(true);
    /* renamed from: an */
    int f6480an = 0;
    /* renamed from: ao */
    String f6481ao = "";
    /* renamed from: ap */
    int f6482ap = 7;
    /* renamed from: aq */
    boolean f6483aq;
    /* renamed from: ar */
    TextView f6484ar;
    /* renamed from: as */
    long f6485as = 0;
    /* renamed from: at */
    int f6486at = 0;
    /* renamed from: au */
    long f6487au = 0;
    /* renamed from: av */
    long f6488av = 0;
    /* renamed from: aw */
    AtomicBoolean f6489aw = new AtomicBoolean(false);
    /* renamed from: ax */
    String f6490ax;
    /* renamed from: ay */
    boolean f6491ay;
    /* renamed from: az */
    protected boolean f6492az;
    /* renamed from: b */
    TopProxyLayout f6493b;
    /* renamed from: c */
    RelativeLayout f6494c;
    /* renamed from: d */
    Context f6495d;
    /* renamed from: e */
    protected SSWebView f6496e;
    /* renamed from: f */
    SSWebView f6497f;
    /* renamed from: g */
    ImageView f6498g;
    /* renamed from: h */
    RelativeLayout f6499h;
    /* renamed from: i */
    TTRoundRectImageView f6500i;
    /* renamed from: j */
    TextView f6501j;
    /* renamed from: k */
    TextView f6502k;
    /* renamed from: l */
    TextView f6503l;
    /* renamed from: m */
    FrameLayout f6504m;
    /* renamed from: n */
    FrameLayout f6505n;
    /* renamed from: o */
    FrameLayout f6506o;
    /* renamed from: p */
    TTRatingBar f6507p;
    /* renamed from: q */
    MaterialMeta f6508q;
    /* renamed from: r */
    LandingPageLog f6509r;
    /* renamed from: s */
    String f6510s;
    /* renamed from: t */
    boolean f6511t = true;
    /* renamed from: u */
    long f6512u;
    /* renamed from: v */
    String f6513v;
    /* renamed from: w */
    int f6514w;
    /* renamed from: x */
    boolean f6515x = false;
    /* renamed from: y */
    RewardDislikeDialog f6516y;
    /* renamed from: z */
    RewardDislikeToast f6517z;

    public void onBackPressed() {
    }

    public TTBaseVideoActivity() {
        this.f6490ax = this instanceof TTRewardVideoActivity ? "rewarded_video" : "fullscreen_interstitial_ad";
        this.f6491ay = false;
        this.f6492az = true;
        this.f6463aI = true;
        this.f6464aJ = new AtomicBoolean(false);
        this.f6455aA = null;
        this.f6465aK = new OnClickListener() {
            public void onClick(View view) {
                TTBaseVideoActivity.this.m8016a(view);
            }
        };
        this.f6466aL = false;
        this.f6456aB = new ContainerSizeListener() {
            /* renamed from: a */
            public int mo14881a() {
                int measuredHeight = TTBaseVideoActivity.this.f6496e != null ? TTBaseVideoActivity.this.f6496e.getMeasuredHeight() : -1;
                StringBuilder sb = new StringBuilder();
                sb.append("mWebView>>>>height=");
                sb.append(measuredHeight);
                C2564t.m12222c("TTAndroidObject", sb.toString());
                return measuredHeight <= 0 ? UIUtils.m12084d(TTBaseVideoActivity.this.f6495d) : measuredHeight;
            }

            /* renamed from: b */
            public int mo14882b() {
                int measuredWidth = TTBaseVideoActivity.this.f6496e != null ? TTBaseVideoActivity.this.f6496e.getMeasuredWidth() : -1;
                StringBuilder sb = new StringBuilder();
                sb.append("mWebView>>>>width=");
                sb.append(measuredWidth);
                C2564t.m12222c("TTAndroidObject", sb.toString());
                return measuredWidth <= 0 ? UIUtils.m12078c(TTBaseVideoActivity.this.f6495d) : measuredWidth;
            }
        };
        this.f6457aC = new SendRewardListener() {
            /* renamed from: a */
            public void mo14883a() {
                TTBaseVideoActivity.this.mo14923Q();
            }
        };
        this.f6458aD = new PlayableLoadingListener() {
            /* renamed from: a */
            public void mo14884a() {
                if (!TTBaseVideoActivity.this.isFinishing()) {
                    if ((TTBaseVideoActivity.this.f6508q == null || TTBaseVideoActivity.this.f6508q.mo15501o()) && TTBaseVideoActivity.this.f6508q != null && TTBaseVideoActivity.this.f6508q.mo15502p()) {
                        TTBaseVideoActivity.this.f6433F.removeMessages(800);
                        TTBaseVideoActivity.this.f6433F.sendMessage(TTBaseVideoActivity.this.mo14909d(1));
                    }
                }
            }
        };
        this.f6467aM = -1;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0036 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    public void onCreate(android.os.Bundle r7) {
        /*
        r6 = this;
        if (r7 == 0) goto L_0x000a
        java.lang.String r0 = "is_bar_click_first"
        boolean r0 = r7.getBoolean(r0)
        r6.f6461aG = r0
    L_0x000a:
        super.onCreate(r7)
        com.bytedance.sdk.openadsdk.core.h r0 = com.bytedance.sdk.openadsdk.core.GlobalInfo.m9616c()
        boolean r0 = r0.mo15682l()
        if (r0 == 0) goto L_0x0020
        android.view.Window r0 = r6.getWindow()
        r1 = 2621440(0x280000, float:3.67342E-39)
        r0.addFlags(r1)
    L_0x0020:
        r0 = 1
        r6.requestWindowFeature(r0)     // Catch:{ all -> 0x0036 }
        android.view.Window r0 = r6.getWindow()     // Catch:{ all -> 0x0036 }
        r1 = 1024(0x400, float:1.435E-42)
        r0.addFlags(r1)     // Catch:{ all -> 0x0036 }
        android.view.Window r0 = r6.getWindow()     // Catch:{ all -> 0x0036 }
        r1 = 16777216(0x1000000, float:2.3509887E-38)
        r0.addFlags(r1)     // Catch:{ all -> 0x0036 }
    L_0x0036:
        com.bytedance.sdk.openadsdk.core.InternalContainer.m10061a(r6)     // Catch:{ all -> 0x003a }
        goto L_0x003b
    L_0x003b:
        if (r7 == 0) goto L_0x004f
        java.lang.String r0 = "video_current"
        long r1 = r7.getLong(r0)
        r3 = 0
        int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
        if (r5 <= 0) goto L_0x004f
        long r0 = r7.getLong(r0, r3)
        r6.f6512u = r0
    L_0x004f:
        r6.f6495d = r6
        com.bytedance.sdk.openadsdk.e.f r7 = new com.bytedance.sdk.openadsdk.e.f
        android.content.Context r0 = r6.getApplicationContext()
        r7.m44004init(r0)
        r6.f6462aH = r7
        com.bytedance.sdk.openadsdk.e.f r7 = r6.f6462aH
        r7.mo16561a(r6)
        com.bytedance.sdk.openadsdk.e.f r7 = r6.f6462aH
        int r7 = r7.mo16563c()
        r6.f6467aM = r7
        java.lang.StringBuilder r7 = new java.lang.StringBuilder
        r7.<init>()
        java.lang.String r0 = "onCreate >>>>>> mVolume = "
        r7.append(r0)
        int r0 = r6.f6467aM
        r7.append(r0)
        java.lang.String r7 = r7.toString()
        java.lang.String r0 = "onVolumeChanged"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r0, r7)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo14810a() {
        if (this.f6442O == 15) {
            TextView textView = this.f6501j;
            if (textView != null) {
                textView.setMaxWidth((int) UIUtils.m12048a((Context) this, 153.0f));
            }
        } else {
            TextView textView2 = this.f6501j;
            if (textView2 != null) {
                textView2.setMaxWidth((int) UIUtils.m12048a((Context) this, 404.0f));
            }
            mo14910e(false);
            mo14821b();
        }
        if (this instanceof TTFullScreenVideoActivity) {
            UIUtils.m12059a((View) this.f6494c, 0);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo14821b() {
        if (this.f6499h != null) {
            MaterialMeta kVar = this.f6508q;
            if (kVar != null && kVar.mo15510x() != null) {
                try {
                    LayoutParams layoutParams = (LayoutParams) this.f6499h.getLayoutParams();
                    layoutParams.rightMargin = UIUtils.m12079c(this, 45.0f);
                    this.f6499h.setLayoutParams(layoutParams);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo14825c() {
        this.f6443P = this.f6508q.mo15500n();
        if (this.f6443P == -200) {
            TTSdkSettings h = InternalContainer.m10069h();
            StringBuilder sb = new StringBuilder();
            sb.append(this.f6444Q);
            sb.append("");
            this.f6443P = h.mo15797k(sb.toString());
        }
        if (this.f6443P == -1 && this.f6511t) {
            UIUtils.m12059a((View) this.f6494c, 0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo14829d() {
        this.f6454a = (PlayableLoadingView) findViewById(ResourceHelp.m11935e(this, "tt_reward_playable_loading"));
        this.f6493b = (TopProxyLayout) findViewById(ResourceHelp.m11935e(this, "tt_top_layout_proxy"));
        TopProxyLayout topProxyLayout = this.f6493b;
        if (topProxyLayout != null) {
            topProxyLayout.mo15179a(this instanceof TTRewardVideoActivity, this.f6508q);
        }
        this.f6497f = (SSWebView) findViewById(ResourceHelp.m11935e(this, "tt_browser_webview_loading"));
        this.f6496e = (SSWebView) findViewById(ResourceHelp.m11935e(this, "tt_reward_browser_webview"));
        this.f6499h = (RelativeLayout) findViewById(ResourceHelp.m11935e(this, "tt_video_ad_close_layout"));
        this.f6498g = (ImageView) findViewById(ResourceHelp.m11935e(this, "tt_video_ad_close"));
        this.f6484ar = (TextView) findViewById(ResourceHelp.m11935e(this, "tt_ad_logo"));
        this.f6504m = (FrameLayout) findViewById(ResourceHelp.m11935e(this, "tt_video_reward_container"));
        this.f6505n = (FrameLayout) findViewById(ResourceHelp.m11935e(this, "tt_click_upper_non_content_layout"));
        this.f6506o = (FrameLayout) findViewById(ResourceHelp.m11935e(this, "tt_click_lower_non_content_layout"));
        this.f6473ag = (LinearLayout) findViewById(ResourceHelp.m11935e(this, "tt_reward_full_endcard_backup"));
        this.f6503l = (TextView) findViewById(ResourceHelp.m11935e(this, "tt_reward_ad_download"));
        this.f6494c = (RelativeLayout) findViewById(ResourceHelp.m11935e(this, "tt_video_reward_bar"));
        this.f6500i = (TTRoundRectImageView) findViewById(ResourceHelp.m11935e(this, "tt_reward_ad_icon"));
        this.f6501j = (TextView) findViewById(ResourceHelp.m11935e(this, "tt_reward_ad_appname"));
        this.f6502k = (TextView) findViewById(ResourceHelp.m11935e(this, "tt_comment_vertical"));
        this.f6507p = (TTRatingBar) findViewById(ResourceHelp.m11935e(this, "tt_rb_score"));
        TTRatingBar tTRatingBar = this.f6507p;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.f6507p.setStarFillNum(4);
            this.f6507p.setStarImageWidth((float) UIUtils.m12079c(this, 15.0f));
            this.f6507p.setStarImageHeight((float) UIUtils.m12079c(this, 14.0f));
            this.f6507p.setStarImagePadding((float) UIUtils.m12079c(this, 4.0f));
            this.f6507p.mo16263a();
        }
        MaterialMeta kVar = this.f6508q;
        if (kVar != null && kVar.mo15503q()) {
            this.f6496e.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            this.f6497f.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            if (this.f6508q.mo15466c() == 1) {
                UIUtils.m12059a((View) this.f6504m, 8);
                UIUtils.m12059a((View) this.f6505n, 8);
                UIUtils.m12059a((View) this.f6506o, 8);
                UIUtils.m12059a((View) this.f6494c, 8);
                UIUtils.m12059a((View) this.f6501j, 8);
                UIUtils.m12059a((View) this.f6500i, 8);
                UIUtils.m12059a((View) this.f6502k, 8);
                UIUtils.m12059a((View) this.f6507p, 8);
                UIUtils.m12059a((View) this.f6498g, 8);
                UIUtils.m12059a((View) this.f6499h, 8);
                UIUtils.m12059a((View) this.f6496e, 4);
                UIUtils.m12059a((View) this.f6497f, 0);
                UIUtils.m12059a((View) this.f6503l, 8);
                UIUtils.m12059a((View) this.f6484ar, 8);
                TopProxyLayout topProxyLayout2 = this.f6493b;
                if (topProxyLayout2 != null) {
                    topProxyLayout2.setShowSound(false);
                }
            }
        }
        SSWebView sSWebView = this.f6496e;
        if (sSWebView != null) {
            sSWebView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (VERSION.SDK_INT >= 16) {
                        TTBaseVideoActivity.this.f6496e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    } else {
                        TTBaseVideoActivity.this.f6496e.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                    int measuredWidth = TTBaseVideoActivity.this.f6496e.getMeasuredWidth();
                    int measuredHeight = TTBaseVideoActivity.this.f6496e.getMeasuredHeight();
                    if (TTBaseVideoActivity.this.f6496e.getVisibility() == 0) {
                        TTBaseVideoActivity.this.mo14811a(measuredWidth, measuredHeight);
                    }
                }
            });
        }
        mo14903K();
        if (!this.f6511t) {
            UIUtils.m12059a((View) this.f6494c, 4);
        }
        try {
            if (this.f6470ad && this.f6508q != null && this.f6508q.mo15429Q() == 5) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f6503l.getLayoutParams();
                layoutParams.height = (int) UIUtils.m12048a((Context) this, 55.0f);
                layoutParams.topMargin = (int) UIUtils.m12048a((Context) this, 20.0f);
                this.f6503l.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f6494c.getLayoutParams();
                layoutParams2.bottomMargin = (int) UIUtils.m12048a((Context) this, 12.0f);
                this.f6494c.setLayoutParams(layoutParams2);
            }
        } catch (Throwable unused) {
        }
        if (this.f6508q != null && this.f6470ad && this.f6504m != null) {
            int c = UIUtils.m12078c((Context) this);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f6504m.getLayoutParams();
            layoutParams3.width = c;
            int i = (c * 9) / 16;
            layoutParams3.height = i;
            this.f6504m.setLayoutParams(layoutParams3);
            this.f6472af = (UIUtils.m12084d((Context) this) - i) / 2;
            StringBuilder sb = new StringBuilder();
            sb.append("NonContentAreaHeight:");
            sb.append(this.f6472af);
            C2564t.m12226e("TTBaseVideoActivity", sb.toString());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8022a(String str, String str2) {
        AdEventManager.m8399b((Context) this, this.f6508q, str, str2, (JSONObject) null);
    }

    /* renamed from: I */
    private String mo14901I() {
        String q = InternalContainer.m10069h().mo15809q();
        StringBuilder sb = new StringBuilder();
        sb.append("getPlayableLoadH5Url->loadH5Url=");
        sb.append(q);
        String str = "Playable";
        C2564t.m12222c(str, sb.toString());
        if (TextUtils.isEmpty(q)) {
            return q;
        }
        MaterialMeta kVar = this.f6508q;
        if (kVar == null || kVar.mo15426N() == null) {
            return q;
        }
        String str2 = this.f6442O == 15 ? "portrait" : "landscape";
        String c = this.f6508q.mo15426N().mo15345c();
        int e = this.f6508q.mo15426N().mo15350e();
        int f = this.f6508q.mo15426N().mo15351f();
        String a = this.f6508q.mo15415C().mo15406a();
        String M = this.f6508q.mo15425M();
        String d = this.f6508q.mo15426N().mo15348d();
        String b = this.f6508q.mo15426N().mo15342b();
        String c2 = this.f6508q.mo15426N().mo15345c();
        String J = this.f6508q.mo15422J();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appname=");
        stringBuffer.append(URLEncoder.encode(c));
        stringBuffer.append("&stars=");
        stringBuffer.append(e);
        stringBuffer.append("&comments=");
        stringBuffer.append(f);
        stringBuffer.append("&icon=");
        stringBuffer.append(URLEncoder.encode(a));
        stringBuffer.append("&downloading=");
        stringBuffer.append(true);
        stringBuffer.append("&id=");
        stringBuffer.append(URLEncoder.encode(M));
        stringBuffer.append("&pkg_name=");
        stringBuffer.append(URLEncoder.encode(d));
        stringBuffer.append("&download_url=");
        stringBuffer.append(URLEncoder.encode(b));
        stringBuffer.append("&name=");
        stringBuffer.append(URLEncoder.encode(c2));
        stringBuffer.append("&orientation=");
        stringBuffer.append(str2);
        stringBuffer.append("&apptitle=");
        stringBuffer.append(URLEncoder.encode(J));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(q);
        sb2.append("?");
        sb2.append(stringBuffer.toString());
        String sb3 = sb2.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Playable-loadH5Url=");
        sb4.append(sb3);
        C2564t.m12222c(str, sb4.toString());
        return sb3;
    }

    /* access modifiers changed from: private */
    /* renamed from: J */
    public void mo14902J() {
        if (!this.f6464aJ.getAndSet(true)) {
            SSWebView sSWebView = this.f6496e;
            if (!(sSWebView == null || this.f6497f == null)) {
                UIUtils.m12059a((View) sSWebView, 0);
                UIUtils.m12059a((View) this.f6497f, 8);
            }
        }
    }

    /* renamed from: a */
    private void m8020a(SSWebView sSWebView) {
        if (sSWebView != null) {
            SSWebSettings.m10854a(this.f6495d).mo16362a(false).mo16364b(false).mo16363a((WebView) sSWebView);
            sSWebView.getSettings().setUserAgentString(JsBridgeUtils.m12206a((WebView) sSWebView, this.f6438K));
            if (VERSION.SDK_INT >= 21) {
                sSWebView.getSettings().setMixedContentMode(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public boolean mo14831e() {
        if (this.f6497f == null) {
            return false;
        }
        String I = mo14901I();
        if (TextUtils.isEmpty(I)) {
            return false;
        }
        SSWebView sSWebView = this.f6497f;
        C20239 r3 = new TTWebViewClient(this.f6495d, this.f6431D, this.f6508q.mo15425M(), null) {
            public void onPageFinished(WebView webView, String str) {
                if (TTBaseVideoActivity.this.f6463aI) {
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    tTBaseVideoActivity.m8022a(tTBaseVideoActivity.f6490ax, "loading_h5_success");
                }
                super.onPageFinished(webView, str);
            }

            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                TTBaseVideoActivity.this.f6463aI = false;
            }

            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                TTBaseVideoActivity.this.f6463aI = false;
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                TTBaseVideoActivity.this.f6463aI = false;
            }
        };
        sSWebView.setWebViewClient(r3);
        this.f6497f.loadUrl(I);
        this.f6497f.getSettings().setDisplayZoomControls(false);
        this.f6497f.setWebChromeClient(new TTWebChromeClient(this.f6431D, this.f6509r));
        this.f6497f.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (TTBaseVideoActivity.this.f6434G.containsKey(str)) {
                    ITTDownloadAdapter aVar = (ITTDownloadAdapter) TTBaseVideoActivity.this.f6434G.get(str);
                    if (aVar != null) {
                        aVar.mo16520f();
                    }
                } else {
                    String str5 = null;
                    if (!(TTBaseVideoActivity.this.f6508q == null || TTBaseVideoActivity.this.f6508q.mo15415C() == null)) {
                        str5 = TTBaseVideoActivity.this.f6508q.mo15415C().mo15406a();
                    }
                    ITTDownloadAdapter a = TTDownloadFactory.m11072a((Context) TTBaseVideoActivity.this, str, str5);
                    TTBaseVideoActivity.this.f6434G.put(str, a);
                    a.mo16520f();
                }
                TTBaseVideoActivity.this.mo14922P();
            }
        });
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo14814a(String str) {
        SSWebView sSWebView = this.f6496e;
        if (sSWebView != null) {
            this.f6509r = new LandingPageLog(this, this.f6508q, sSWebView).mo15018a(true);
            this.f6509r.mo15025a(str);
            SSWebView sSWebView2 = this.f6496e;
            C201011 r2 = new TTWebViewClient(this.f6495d, this.f6430C, this.f6435H, this.f6509r) {
                public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                    if (!TTBaseVideoActivity.this.f6508q.mo15503q()) {
                        return super.shouldInterceptRequest(webView, str);
                    }
                    String h = TTBaseVideoActivity.this.f6508q.mo15512z().mo15604h();
                    return PlayableCache.m9577a().mo15641a(TTBaseVideoActivity.this.f6508q.mo15512z().mo15605i(), h, str);
                }

                /* JADX WARNING: type inference failed for: r4v1, types: [android.webkit.WebView] */
                /* JADX WARNING: type inference failed for: r4v4 */
                /* JADX WARNING: type inference failed for: r4v5 */
                /* JADX WARNING: Multi-variable type inference failed */
                /* JADX WARNING: Unknown variable types count: 1 */
                public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView r4, android.webkit.WebResourceRequest r5) {
                    /*
                    r3 = this;
                    android.net.Uri r0 = r5.getUrl()     // Catch:{ all -> 0x000d }
                    java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x000d }
                    android.webkit.WebResourceResponse r4 = r3.shouldInterceptRequest(r4, r0)     // Catch:{ all -> 0x000d }
                    return r4
                L_0x000d:
                    r0 = move-exception
                    java.lang.String r1 = "TTBaseVideoActivity"
                    java.lang.String r2 = "shouldInterceptRequest error1"
                    com.bytedance.sdk.openadsdk.utils.C2564t.m12223c(r1, r2, r0)
                    android.webkit.WebResourceResponse r4 = super.shouldInterceptRequest(r4, r5)
                    return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.C201011.shouldInterceptRequest(android.webkit.WebView, android.webkit.WebResourceRequest):android.webkit.WebResourceResponse");
                }

                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    TTBaseVideoActivity.this.f6479am.set(false);
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    tTBaseVideoActivity.f6480an = i;
                    tTBaseVideoActivity.f6481ao = str;
                    super.onReceivedError(webView, i, str, str2);
                }

                public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                    TTBaseVideoActivity.this.f6479am.set(false);
                    if (!(webResourceError == null || webResourceError.getDescription() == null)) {
                        TTBaseVideoActivity.this.f6480an = webResourceError.getErrorCode();
                        TTBaseVideoActivity.this.f6481ao = webResourceError.getDescription().toString();
                    }
                    super.onReceivedError(webView, webResourceRequest, webResourceError);
                }

                public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                    if (!(webResourceRequest == null || webResourceRequest.getUrl() == null || !TTBaseVideoActivity.this.f6439L.equals(webResourceRequest.getUrl().toString()))) {
                        TTBaseVideoActivity.this.f6479am.set(false);
                        if (webResourceResponse != null) {
                            TTBaseVideoActivity.this.f6480an = webResourceResponse.getStatusCode();
                            TTBaseVideoActivity.this.f6481ao = "onReceivedHttpError";
                        }
                    }
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                }

                /* JADX WARNING: Can't wrap try/catch for region: R(7:0|1|2|(1:10)|11|12|(1:27)(4:18|(1:20)|21|23)) */
                /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            return;
     */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0039 */
                public void onPageFinished(android.webkit.WebView r3, java.lang.String r4) {
                    /*
                    r2 = this;
                    super.onPageFinished(r3, r4)
                    com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity r3 = com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.this     // Catch:{ all -> 0x0039 }
                    com.bytedance.sdk.openadsdk.core.d.k r3 = r3.f6508q     // Catch:{ all -> 0x0039 }
                    boolean r3 = r3.mo15504r()     // Catch:{ all -> 0x0039 }
                    if (r3 == 0) goto L_0x0039
                    com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity r3 = com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.this     // Catch:{ all -> 0x0039 }
                    boolean r3 = r3.isFinishing()     // Catch:{ all -> 0x0039 }
                    if (r3 != 0) goto L_0x0039
                    com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity r3 = com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.this     // Catch:{ all -> 0x0039 }
                    com.bytedance.sdk.openadsdk.core.d.k r3 = r3.f6508q     // Catch:{ all -> 0x0039 }
                    boolean r3 = r3.mo15501o()     // Catch:{ all -> 0x0039 }
                    if (r3 == 0) goto L_0x0039
                    com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity r3 = com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.this     // Catch:{ all -> 0x0039 }
                    com.bytedance.sdk.openadsdk.core.d.k r3 = r3.f6508q     // Catch:{ all -> 0x0039 }
                    boolean r3 = r3.mo15502p()     // Catch:{ all -> 0x0039 }
                    if (r3 != 0) goto L_0x0039
                    com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity r3 = com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.this     // Catch:{ all -> 0x0039 }
                    com.bytedance.sdk.openadsdk.utils.ak r3 = r3.f6433F     // Catch:{ all -> 0x0039 }
                    com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.this     // Catch:{ all -> 0x0039 }
                    r0 = 0
                    android.os.Message r4 = r4.mo14909d(r0)     // Catch:{ all -> 0x0039 }
                    r0 = 1000(0x3e8, double:4.94E-321)
                    r3.sendMessageDelayed(r4, r0)     // Catch:{ all -> 0x0039 }
                L_0x0039:
                    com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity r3 = com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.this     // Catch:{ all -> 0x0076 }
                    java.util.concurrent.atomic.AtomicBoolean r3 = r3.f6479am     // Catch:{ all -> 0x0076 }
                    boolean r3 = r3.get()     // Catch:{ all -> 0x0076 }
                    if (r3 == 0) goto L_0x0076
                    com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity r3 = com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.this     // Catch:{ all -> 0x0076 }
                    com.bytedance.sdk.openadsdk.core.d.k r3 = r3.f6508q     // Catch:{ all -> 0x0076 }
                    int r3 = r3.mo15466c()     // Catch:{ all -> 0x0076 }
                    r4 = 1
                    if (r3 != r4) goto L_0x0076
                    com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity r3 = com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.this     // Catch:{ all -> 0x0076 }
                    com.bytedance.sdk.openadsdk.core.d.k r3 = r3.f6508q     // Catch:{ all -> 0x0076 }
                    boolean r3 = r3.mo15503q()     // Catch:{ all -> 0x0076 }
                    if (r3 == 0) goto L_0x0076
                    com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity r3 = com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.this     // Catch:{ all -> 0x0076 }
                    r3.mo14902J()     // Catch:{ all -> 0x0076 }
                    com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity r3 = com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.this     // Catch:{ all -> 0x0076 }
                    r3.mo14824b(r4)     // Catch:{ all -> 0x0076 }
                    com.bytedance.sdk.openadsdk.core.x r3 = r2.f8417b     // Catch:{ all -> 0x0076 }
                    if (r3 == 0) goto L_0x006b
                    com.bytedance.sdk.openadsdk.core.x r3 = r2.f8417b     // Catch:{ all -> 0x0076 }
                    r3.mo16418b(r4)     // Catch:{ all -> 0x0076 }
                L_0x006b:
                    com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity r3 = com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.this     // Catch:{ all -> 0x0076 }
                    com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.this     // Catch:{ all -> 0x0076 }
                    java.lang.String r4 = r4.f6490ax     // Catch:{ all -> 0x0076 }
                    java.lang.String r0 = "py_loading_success"
                    r3.m8022a(r4, r0)     // Catch:{ all -> 0x0076 }
                L_0x0076:
                    return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.C201011.onPageFinished(android.webkit.WebView, java.lang.String):void");
                }

                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    super.onPageStarted(webView, str, bitmap);
                    if (TTBaseVideoActivity.this.f6508q != null && TTBaseVideoActivity.this.f6508q.mo15503q() && TTBaseVideoActivity.this.f6508q.mo15466c() == 1) {
                        boolean z = TTBaseVideoActivity.this instanceof TTRewardVideoActivity;
                        int o = InternalContainer.m10069h().mo15806o(String.valueOf(TTBaseVideoActivity.this.f6444Q));
                        int a = InternalContainer.m10069h().mo15773a(String.valueOf(TTBaseVideoActivity.this.f6444Q), z);
                        TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                        long j = (long) a;
                        tTBaseVideoActivity.f6487au = j;
                        tTBaseVideoActivity.f6488av = j;
                        tTBaseVideoActivity.f6433F.sendEmptyMessageDelayed(OtherError.CONTAINER_INVISIBLE_ERROR, (long) (a * 1000));
                        Message obtain = Message.obtain();
                        obtain.what = OtherError.VIDEO_DOWNLOAD_ERROR;
                        obtain.arg1 = o;
                        TTBaseVideoActivity.this.f6433F.sendMessage(obtain);
                        TTBaseVideoActivity.this.f6485as = System.currentTimeMillis();
                        HashMap hashMap = null;
                        if (!TextUtils.isEmpty(TTBaseVideoActivity.this.f6469ac)) {
                            hashMap = new HashMap();
                            hashMap.put("rit_scene", TTBaseVideoActivity.this.f6469ac);
                        }
                        if (z) {
                            AdEventManager.m8389a(this.f8418c, TTBaseVideoActivity.this.f6508q, "rewarded_video", (Map<String, Object>) hashMap);
                        } else {
                            AdEventManager.m8389a(this.f8418c, TTBaseVideoActivity.this.f6508q, "fullscreen_interstitial_ad", (Map<String, Object>) hashMap);
                        }
                        TTBaseVideoActivity.this.mo14906N();
                        TTBaseVideoActivity.this.f6489aw.set(true);
                    }
                }
            };
            sSWebView2.setWebViewClient(r2);
            m8020a(this.f6496e);
            if (this.f6508q.mo15466c() == 1 && this.f6508q.mo15503q()) {
                m8020a(this.f6497f);
                mo14831e();
            }
            if (VERSION.SDK_INT >= 19) {
                SSWebView sSWebView3 = this.f6496e;
                SSWebView.setWebContentsDebuggingEnabled(this.f6483aq);
                if (this.f6483aq) {
                    this.f6496e.getSettings().setDomStorageEnabled(true);
                }
            }
            mo14832f();
            if ("reward_endcard".equals(str) || "fullscreen_endcard".equals(str)) {
                this.f6496e.setLayerType(1, null);
                this.f6496e.setBackgroundColor(-1);
            }
            this.f6496e.getSettings().setDisplayZoomControls(false);
            this.f6496e.setWebChromeClient(new TTWebChromeClient(this.f6430C, this.f6509r) {
                public void onProgressChanged(WebView webView, int i) {
                    super.onProgressChanged(webView, i);
                    try {
                        if (TTBaseVideoActivity.this.f6508q.mo15504r() && TTBaseVideoActivity.this.f6508q.mo15501o() && !TTBaseVideoActivity.this.isFinishing() && TTBaseVideoActivity.this.f6454a != null) {
                            TTBaseVideoActivity.this.f6454a.setProgress(i);
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
            this.f6496e.setDownloadListener(new DownloadListener() {
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    if (TTBaseVideoActivity.this.f6434G.containsKey(str)) {
                        ITTDownloadAdapter aVar = (ITTDownloadAdapter) TTBaseVideoActivity.this.f6434G.get(str);
                        if (aVar != null) {
                            aVar.mo16520f();
                        }
                    } else {
                        String str5 = null;
                        if (!(TTBaseVideoActivity.this.f6508q == null || TTBaseVideoActivity.this.f6508q.mo15415C() == null)) {
                            str5 = TTBaseVideoActivity.this.f6508q.mo15415C().mo15406a();
                        }
                        ITTDownloadAdapter a = TTDownloadFactory.m11072a((Context) TTBaseVideoActivity.this, str, str5);
                        TTBaseVideoActivity.this.f6434G.put(str, a);
                        a.mo16520f();
                    }
                    TTBaseVideoActivity.this.mo14922P();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo14832f() {
        if (this.f6492az) {
            this.f6496e.loadUrl(this.f6439L);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo14823b(String str) {
        if (this.f6508q.mo15466c() != 1 || !this.f6508q.mo15503q()) {
            boolean a = mo14908a(this.f6512u, false);
            this.f6446S.set(true);
            if (!a) {
                mo14850q();
                HashMap hashMap = new HashMap();
                hashMap.put("vbtt_skip_type", Integer.valueOf(1));
                mo14816a(str, (Map<String, Object>) hashMap);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo14833g() {
        TextView textView = this.f6503l;
        if (textView != null) {
            textView.setText(this.f6471ae ? mo14857x() : mo14856w());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo14834h() {
        String str;
        if (this.f6502k != null) {
            int i = 6870;
            if (this.f6508q.mo15426N() != null) {
                i = this.f6508q.mo15426N().mo15351f();
            }
            String a = ResourceHelp.m11931a(this, "tt_comment_num");
            if (i > 10000) {
                StringBuilder sb = new StringBuilder();
                sb.append(i / C7516p.f25219Cf);
                sb.append("万");
                str = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i);
                sb2.append("");
                str = sb2.toString();
            }
            this.f6502k.setText(String.format(a, new Object[]{str}));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public void mo14835i() {
        if (this.f6500i != null) {
            if (this.f6508q.mo15415C() == null || TextUtils.isEmpty(this.f6508q.mo15415C().mo15406a())) {
                this.f6500i.setImageResource(ResourceHelp.m11934d(this, "tt_ad_logo_small"));
            } else {
                TTNetClient.m11428a(this.f6495d).mo16653a(this.f6508q.mo15415C().mo15406a(), (ImageView) this.f6500i);
            }
        }
        if (this.f6501j == null) {
            return;
        }
        if (this.f6442O != 15 || this.f6508q.mo15426N() == null || TextUtils.isEmpty(this.f6508q.mo15426N().mo15345c())) {
            this.f6501j.setText(this.f6508q.mo15422J());
        } else {
            this.f6501j.setText(this.f6508q.mo15426N().mo15345c());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void mo14836j() {
        this.f6439L = this.f6508q.mo15512z() != null ? this.f6508q.mo15512z().mo15604h() : null;
        if (!TextUtils.isEmpty(this.f6439L) && this.f6442O == 15) {
            if (this.f6439L.contains("?")) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f6439L);
                sb.append("&orientation=portrait");
                this.f6439L = sb.toString();
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f6439L);
            sb2.append("?orientation=portrait");
            this.f6439L = sb2.toString();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public void mo14837k() {
        if (this.f6454a != null) {
            MaterialMeta kVar = this.f6508q;
            if (kVar == null || !kVar.mo15501o() || !this.f6508q.mo15504r()) {
                this.f6454a.mo16239a();
                return;
            }
            this.f6454a.mo16240b();
            MaterialMeta kVar2 = this.f6508q;
            if (kVar2 != null && kVar2.mo15504r() && this.f6508q.mo15502p()) {
                this.f6433F.sendMessageDelayed(mo14909d(2), 10000);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public Message mo14909d(int i) {
        Message obtain = Message.obtain();
        obtain.what = 800;
        obtain.arg1 = i;
        return obtain;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo14817a(boolean z) {
        TopProxyLayout topProxyLayout = this.f6493b;
        if (topProxyLayout != null) {
            topProxyLayout.setSoundMute(z);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo14838l() {
        if (!this.f6508q.mo15503q() || this.f6508q.mo15466c() != 1) {
            TextView textView = this.f6484ar;
            if (textView != null) {
                UIUtils.m12059a((View) textView, 0);
            }
            return;
        }
        TextView textView2 = this.f6484ar;
        if (textView2 != null) {
            UIUtils.m12059a((View) textView2, 8);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void mo14839m() {
        TextView textView = this.f6484ar;
        if (textView != null) {
            UIUtils.m12059a((View) textView, 8);
        }
    }

    /* renamed from: K */
    private void mo14903K() {
        this.f6473ag = (LinearLayout) findViewById(ResourceHelp.m11935e(this, "tt_reward_full_endcard_backup"));
        this.f6474ah = (TTRoundRectImageView) findViewById(ResourceHelp.m11935e(this, "tt_reward_ad_icon_backup"));
        this.f6475ai = (TextView) findViewById(ResourceHelp.m11935e(this, "tt_reward_ad_appname_backup"));
        this.f6476aj = (TTRatingBar) findViewById(ResourceHelp.m11935e(this, "tt_rb_score_backup"));
        this.f6477ak = (TextView) findViewById(ResourceHelp.m11935e(this, "tt_comment_backup"));
        this.f6478al = (TextView) findViewById(ResourceHelp.m11935e(this, "tt_reward_ad_download_backup"));
        TTRatingBar tTRatingBar = this.f6476aj;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.f6476aj.setStarFillNum(4);
            this.f6476aj.setStarImageWidth((float) UIUtils.m12079c(this, 16.0f));
            this.f6476aj.setStarImageHeight((float) UIUtils.m12079c(this, 16.0f));
            this.f6476aj.setStarImagePadding((float) UIUtils.m12079c(this, 4.0f));
            this.f6476aj.mo16263a();
        }
    }

    /* renamed from: e */
    private void mo14910e(boolean z) {
        if (!z) {
            TTRoundRectImageView tTRoundRectImageView = this.f6474ah;
            if (tTRoundRectImageView != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tTRoundRectImageView.getLayoutParams();
                layoutParams.setMargins(0, (int) UIUtils.m12048a((Context) this, 50.0f), 0, 0);
                this.f6474ah.setLayoutParams(layoutParams);
            }
            TextView textView = this.f6478al;
            if (textView != null) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView.getLayoutParams();
                layoutParams2.setMargins(0, (int) UIUtils.m12048a((Context) this, 35.0f), 0, 0);
                layoutParams2.width = (int) UIUtils.m12048a((Context) this, 342.0f);
                this.f6478al.setLayoutParams(layoutParams2);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public void mo14840n() {
        String str;
        if (this.f6474ah != null) {
            if (this.f6508q.mo15415C() == null || TextUtils.isEmpty(this.f6508q.mo15415C().mo15406a())) {
                this.f6474ah.setImageResource(ResourceHelp.m11934d(this, "tt_ad_logo_small"));
            } else {
                TTNetClient.m11428a(this.f6495d).mo16653a(this.f6508q.mo15415C().mo15406a(), (ImageView) this.f6474ah);
            }
        }
        if (this.f6475ai != null) {
            if (this.f6508q.mo15426N() == null || TextUtils.isEmpty(this.f6508q.mo15426N().mo15345c())) {
                this.f6475ai.setText(this.f6508q.mo15422J());
            } else {
                this.f6475ai.setText(this.f6508q.mo15426N().mo15345c());
            }
        }
        if (this.f6477ak != null) {
            int i = 6870;
            if (this.f6508q.mo15426N() != null) {
                i = this.f6508q.mo15426N().mo15351f();
            }
            String a = ResourceHelp.m11931a(this, "tt_comment_num_backup");
            if (i > 10000) {
                StringBuilder sb = new StringBuilder();
                sb.append(i / C7516p.f25219Cf);
                sb.append("万");
                str = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i);
                sb2.append("");
                str = sb2.toString();
            }
            this.f6477ak.setText(String.format(a, new Object[]{str}));
        }
        TextView textView = this.f6478al;
        if (textView != null) {
            textView.setText(mo14856w());
        }
    }

    /* renamed from: L */
    private void mo14904L() {
        MaterialMeta kVar = this.f6508q;
        if (kVar != null) {
            int d = ToolUtils.m12018d(kVar.mo15428P());
            LogStatsBase f = LogStatsBase.m11308b().mo16590a(this.f6482ap).mo16595c(String.valueOf(d)).mo16601f(ToolUtils.m12034h(this.f6508q.mo15428P()));
            f.mo16592b(this.f6480an).mo16603g(this.f6481ao);
            f.mo16605h(this.f6508q.mo15428P()).mo16597d(this.f6508q.mo15425M());
            StatsLogManager.m11278a().mo16580l(f);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public void mo14841o() {
        if (this.f6494c != null) {
            Keyframe ofFloat = Keyframe.ofFloat(0.0f, 0.0f);
            Keyframe ofFloat2 = Keyframe.ofFloat(0.65f, 1.0f);
            Keyframe ofFloat3 = Keyframe.ofFloat(0.765f, 0.9f);
            Keyframe ofFloat4 = Keyframe.ofFloat(0.88f, 1.0f);
            Keyframe ofFloat5 = Keyframe.ofFloat(0.95f, 0.95f);
            Keyframe ofFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
            PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe("scaleX", new Keyframe[]{ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6});
            PropertyValuesHolder ofKeyframe2 = PropertyValuesHolder.ofKeyframe("scaleY", new Keyframe[]{ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6});
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f6494c, new PropertyValuesHolder[]{ofKeyframe, ofKeyframe2});
            ofPropertyValuesHolder.setDuration(1000);
            ofPropertyValuesHolder.start();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: p */
    public void mo14849p() {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.f6469ac)) {
            hashMap.put("rit_scene", this.f6469ac);
        }
        this.f6430C = new TTAndroidObject(this.f6495d);
        this.f6430C.mo16398a((WebView) this.f6496e).mo16400a(this.f6508q).mo16407a(this.f6435H).mo16416b(this.f6436I).mo16397a(this.f6437J).mo16411a(this.f6483aq).mo16404a(this.f6456aB).mo16406a(this.f6457aC).mo16405a(this.f6458aD).mo16421c(ToolUtils.m12032g(this.f6508q)).mo16409a((Map<String, Object>) hashMap);
        this.f6431D = new TTAndroidObject(this);
        this.f6431D.mo16398a((WebView) this.f6497f).mo16400a(this.f6508q).mo16407a(this.f6435H).mo16416b(this.f6436I).mo16397a(this.f6437J).mo16421c(ToolUtils.m12032g(this.f6508q));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public void mo14850q() {
        if ((VERSION.SDK_INT < 17 || !isDestroyed()) && !isFinishing()) {
            CustomCommonDialog aVar = this.f6452Y;
            if (aVar != null && aVar.isShowing()) {
                this.f6452Y.dismiss();
            }
            RewardDislikeToast rewardDislikeToast = this.f6517z;
            if (rewardDislikeToast != null) {
                rewardDislikeToast.mo15198a();
            }
            TopProxyLayout topProxyLayout = this.f6493b;
            if (topProxyLayout != null) {
                topProxyLayout.setShowSkip(false);
                this.f6493b.setShowCountDown(false);
                this.f6493b.setShowDislike(false);
            }
            if (!this.f6445R.getAndSet(true)) {
                if (!this.f6479am.get()) {
                    MaterialMeta kVar = this.f6508q;
                    if (kVar != null && !kVar.mo15503q()) {
                        UIUtils.m12059a((View) this.f6496e, 8);
                        UIUtils.m12059a((View) this.f6473ag, 0);
                        UIUtils.m12059a((View) this.f6498g, 0);
                        UIUtils.m12059a((View) this.f6499h, 0);
                        mo14921O();
                        mo14904L();
                        return;
                    }
                }
                UIUtils.m12058a((View) this.f6496e, 0.0f);
                UIUtils.m12058a((View) this.f6498g, 0.0f);
                UIUtils.m12058a((View) this.f6499h, 0.0f);
                UIUtils.m12059a((View) this.f6496e, 0);
                MaterialMeta kVar2 = this.f6508q;
                if (kVar2 == null || !kVar2.mo15503q()) {
                    MaterialMeta kVar3 = this.f6508q;
                    if (kVar3 != null && !kVar3.mo15503q()) {
                        int l = InternalContainer.m10069h().mo15800l(String.valueOf(this.f6444Q));
                        if (l == -1) {
                            UIUtils.m12059a((View) this.f6498g, 0);
                            UIUtils.m12059a((View) this.f6499h, 0);
                        } else if (l >= 0) {
                            this.f6433F.sendEmptyMessageDelayed(OtherError.CONTAINER_INVISIBLE_ERROR, (long) l);
                        }
                    }
                } else {
                    int p = InternalContainer.m10069h().mo15807p(String.valueOf(this.f6444Q));
                    if (p == -1) {
                        UIUtils.m12059a((View) this.f6498g, 0);
                        UIUtils.m12059a((View) this.f6499h, 0);
                    } else if (p >= 0) {
                        this.f6433F.sendEmptyMessageDelayed(OtherError.CONTAINER_INVISIBLE_ERROR, (long) p);
                    }
                }
                this.f6433F.sendEmptyMessageDelayed(500, 20);
                mo14818a(this.f6440M, true);
                mo14824b(true);
                mo14839m();
                TTAndroidObject xVar = this.f6430C;
                if (xVar != null) {
                    xVar.mo16418b(true);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public boolean mo14851r() {
        INativeVideoController cVar = this.f6428A;
        return (cVar == null || cVar.mo15996t() == null || !this.f6428A.mo15996t().mo16067g()) ? false : true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public boolean mo14852s() {
        INativeVideoController cVar = this.f6428A;
        return (cVar == null || cVar.mo15996t() == null || !this.f6428A.mo15996t().mo16069i()) ? false : true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public boolean mo14853t() {
        INativeVideoController cVar = this.f6428A;
        return cVar != null && cVar.mo15999w();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8023a(String str, JSONObject jSONObject) {
        if (this instanceof TTFullScreenVideoActivity) {
            AdEventManager.m8388a(this.f6495d, this.f6508q, "fullscreen_interstitial_ad", str, (JSONObject) null);
        }
        if (this instanceof TTRewardVideoActivity) {
            AdEventManager.m8388a(this.f6495d, this.f6508q, "rewarded_video", str, jSONObject);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: u */
    public void mo14854u() {
        if (this.f6508q != null) {
            final String str = this instanceof TTRewardVideoActivity ? "rewarded_video" : "fullscreen_interstitial_ad";
            C201314 r1 = new RewardBarClickListener(this, this.f6508q, str, this.f6437J) {
                /* renamed from: a_ */
                public void mo14871a_(View view, int i, int i2, int i3, int i4) {
                    TTBaseVideoActivity.this.mo14924a(view, i, i2, i3, i4);
                    TTBaseVideoActivity.this.f6461aG = view.getId() == ResourceHelp.m11935e(TTBaseVideoActivity.this, "tt_video_reward_bar");
                    TTBaseVideoActivity.this.f6455aA = view;
                    if (view.getId() == ResourceHelp.m11935e(TTBaseVideoActivity.this, "tt_playable_play") && TTBaseVideoActivity.this.f6508q.mo15504r()) {
                        HashMap hashMap = new HashMap();
                        if (TTBaseVideoActivity.this.f6508q.mo15512z() != null) {
                            hashMap.put("playable_url", TTBaseVideoActivity.this.f6508q.mo15512z().mo15604h());
                        }
                        TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                        AdEventManager.m8419r(tTBaseVideoActivity, tTBaseVideoActivity.f6508q, str, "click_playable_download_button_loading", hashMap);
                    }
                    if (TTBaseVideoActivity.this.f6429B == null) {
                        TTBaseVideoActivity.this.m8016a(view);
                    } else if (view.getId() == ResourceHelp.m11935e(TTBaseVideoActivity.this, "tt_rb_score")) {
                        TTBaseVideoActivity.this.m8023a("click_play_star_level", (JSONObject) null);
                    } else if (view.getId() == ResourceHelp.m11935e(TTBaseVideoActivity.this, "tt_comment_vertical")) {
                        TTBaseVideoActivity.this.m8023a("click_play_star_nums", (JSONObject) null);
                    } else if (view.getId() == ResourceHelp.m11935e(TTBaseVideoActivity.this, "tt_reward_ad_appname")) {
                        TTBaseVideoActivity.this.m8023a("click_play_source", (JSONObject) null);
                    } else if (view.getId() == ResourceHelp.m11935e(TTBaseVideoActivity.this, "tt_reward_ad_icon")) {
                        TTBaseVideoActivity.this.m8023a("click_play_logo", (JSONObject) null);
                    }
                }
            };
            this.f6460aF = r1;
            this.f6460aF.mo15277a((View) this.f6494c);
            if (!TextUtils.isEmpty(this.f6469ac)) {
                HashMap hashMap = new HashMap();
                hashMap.put("rit_scene", this.f6469ac);
                this.f6460aF.mo15284a((Map) hashMap);
            }
            ITTDownloadAdapter aVar = this.f6429B;
            if (aVar != null) {
                this.f6460aF.mo15283a(aVar);
                this.f6429B.mo16505a(1, (C2417a) new C2417a() {
                    /* renamed from: a */
                    public boolean mo14872a(int i, MaterialMeta kVar, String str, String str2, Object obj) {
                        if (i != 1 || kVar == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                            return true;
                        }
                        String str3 = "rewarded_video";
                        String str4 = "click_start";
                        if (!str.equals(str3) || !str2.equals(str4)) {
                            String str5 = "fullscreen_interstitial_ad";
                            if (!str.equals(str5) || !str2.equals(str4)) {
                                String str6 = "click_play_open";
                                String str7 = "click_open";
                                if (str.equals(str5) || str.equals(str3)) {
                                    char c = 65535;
                                    int hashCode = str2.hashCode();
                                    if (hashCode != -1297985154) {
                                        if (hashCode != -777040223) {
                                            if (hashCode == 1682049151 && str2.equals("click_pause")) {
                                                c = 0;
                                            }
                                        } else if (str2.equals(str7)) {
                                            c = 2;
                                        }
                                    } else if (str2.equals("click_continue")) {
                                        c = 1;
                                    }
                                    if (c == 0) {
                                        TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                                        AdEventManager.m8387a((Context) tTBaseVideoActivity, tTBaseVideoActivity.f6508q, str, "click_play_pause", null);
                                        return false;
                                    } else if (c == 1) {
                                        TTBaseVideoActivity tTBaseVideoActivity2 = TTBaseVideoActivity.this;
                                        AdEventManager.m8387a((Context) tTBaseVideoActivity2, tTBaseVideoActivity2.f6508q, str, "click_play_continue", null);
                                        return false;
                                    } else if (c == 2) {
                                        AdEventManager.m8417p(TTBaseVideoActivity.this.f6495d, TTBaseVideoActivity.this.f6508q, str, str6, null);
                                        return false;
                                    }
                                } else if (str.equals("rewarded_video_landingpage") && str7.equals(str2) && TTBaseVideoActivity.this.f6508q.mo15503q() && TTBaseVideoActivity.this.f6508q.mo15466c() == 1) {
                                    AdEventManager.m8417p(TTBaseVideoActivity.this.f6495d, TTBaseVideoActivity.this.f6508q, str, str6, null);
                                    return false;
                                }
                                return true;
                            }
                            TTBaseVideoActivity tTBaseVideoActivity3 = TTBaseVideoActivity.this;
                            tTBaseVideoActivity3.m8016a(tTBaseVideoActivity3.f6455aA);
                            TTBaseVideoActivity.this.f6455aA = null;
                            return false;
                        }
                        TTBaseVideoActivity tTBaseVideoActivity4 = TTBaseVideoActivity.this;
                        tTBaseVideoActivity4.m8016a(tTBaseVideoActivity4.f6455aA);
                        TTBaseVideoActivity.this.f6455aA = null;
                        return false;
                    }
                });
            }
            PlayableLoadingView playableLoadingView = this.f6454a;
            if (!(playableLoadingView == null || playableLoadingView.getPlayView() == null)) {
                MaterialMeta kVar = this.f6508q;
                if (kVar != null && kVar.mo15504r()) {
                    this.f6454a.getPlayView().setOnClickListener(this.f6460aF);
                    this.f6454a.getPlayView().setOnTouchListener(this.f6460aF);
                }
            }
            MaterialMeta kVar2 = this.f6508q;
            if (!(kVar2 == null || kVar2.mo15489i() == null)) {
                if (this.f6508q.mo15489i().f7335e) {
                    this.f6503l.setOnClickListener(this.f6460aF);
                    this.f6503l.setOnTouchListener(this.f6460aF);
                } else {
                    this.f6503l.setOnClickListener(this.f6465aK);
                }
                String str2 = "TTBaseVideoActivity#mRlDownloadBar";
                if (this.f6470ad) {
                    if (this.f6508q.mo15489i().f7331a) {
                        UIUtils.m12061a((View) this.f6494c, (OnClickListener) this.f6460aF, str2);
                        UIUtils.m12062a((View) this.f6494c, (OnTouchListener) this.f6460aF, str2);
                        this.f6501j.setOnClickListener(this.f6460aF);
                        this.f6501j.setOnTouchListener(this.f6460aF);
                        this.f6502k.setOnClickListener(this.f6460aF);
                        this.f6502k.setOnTouchListener(this.f6460aF);
                        this.f6507p.setOnClickListener(this.f6460aF);
                        this.f6507p.setOnTouchListener(this.f6460aF);
                        this.f6500i.setOnClickListener(this.f6460aF);
                        this.f6500i.setOnTouchListener(this.f6460aF);
                    } else {
                        UIUtils.m12061a((View) this.f6494c, this.f6465aK, str2);
                        this.f6501j.setOnClickListener(this.f6465aK);
                        this.f6502k.setOnClickListener(this.f6465aK);
                        this.f6507p.setOnClickListener(this.f6465aK);
                        this.f6500i.setOnClickListener(this.f6465aK);
                    }
                } else if (this.f6508q.mo15489i().f7333c) {
                    UIUtils.m12061a((View) this.f6494c, (OnClickListener) this.f6460aF, str2);
                    UIUtils.m12062a((View) this.f6494c, (OnTouchListener) this.f6460aF, str2);
                } else {
                    UIUtils.m12061a((View) this.f6494c, this.f6465aK, str2);
                }
            }
            if (this.f6504m != null) {
                MaterialMeta kVar3 = this.f6508q;
                if (!(kVar3 == null || kVar3.mo15489i() == null)) {
                    if (this.f6508q.mo15489i().f7336f) {
                        this.f6504m.setOnClickListener(this.f6460aF);
                    } else {
                        this.f6504m.setOnClickListener(new OnClickListener() {
                            public void onClick(View view) {
                                TTBaseVideoActivity.this.m8016a(view);
                            }
                        });
                    }
                }
            }
            if (this.f6470ad) {
                if (this.f6508q.mo15489i() != null) {
                    FrameLayout frameLayout = this.f6505n;
                    if (frameLayout != null) {
                        UIUtils.m12059a((View) frameLayout, 0);
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f6505n.getLayoutParams();
                        layoutParams.height = this.f6472af;
                        this.f6505n.setLayoutParams(layoutParams);
                        if (this.f6508q.mo15489i().f7332b) {
                            this.f6505n.setOnClickListener(this.f6460aF);
                            this.f6505n.setOnTouchListener(this.f6460aF);
                        } else {
                            this.f6505n.setOnClickListener(this.f6465aK);
                        }
                    }
                }
                if (this.f6508q.mo15489i() != null) {
                    FrameLayout frameLayout2 = this.f6506o;
                    if (frameLayout2 != null) {
                        UIUtils.m12059a((View) frameLayout2, 0);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f6506o.getLayoutParams();
                        layoutParams2.height = this.f6472af;
                        this.f6506o.setLayoutParams(layoutParams2);
                        if (this.f6508q.mo15489i().f7334d) {
                            this.f6506o.setOnClickListener(this.f6460aF);
                            this.f6506o.setOnTouchListener(this.f6460aF);
                        } else {
                            this.f6506o.setOnClickListener(this.f6465aK);
                        }
                    }
                }
            }
            UIUtils.m12061a((View) this.f6473ag, (OnClickListener) new OnClickListener() {
                public void onClick(View view) {
                }
            }, "TTBaseVideoActivity#mLLEndCardBackup");
            this.f6478al.setOnClickListener(this.f6460aF);
            this.f6478al.setOnTouchListener(this.f6460aF);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8016a(View view) {
        if (view != null) {
            if (view.getId() == ResourceHelp.m11935e(this, "tt_rb_score")) {
                m8023a("click_play_star_level", (JSONObject) null);
            } else if (view.getId() == ResourceHelp.m11935e(this, "tt_comment_vertical")) {
                m8023a("click_play_star_nums", (JSONObject) null);
            } else if (view.getId() == ResourceHelp.m11935e(this, "tt_reward_ad_appname")) {
                m8023a("click_play_source", (JSONObject) null);
            } else if (view.getId() == ResourceHelp.m11935e(this, "tt_reward_ad_icon")) {
                m8023a("click_play_logo", (JSONObject) null);
            } else if (view.getId() == ResourceHelp.m11935e(this, "tt_video_reward_bar") || view.getId() == ResourceHelp.m11935e(this, "tt_click_lower_non_content_layout") || view.getId() == ResourceHelp.m11935e(this, "tt_click_upper_non_content_layout")) {
                m8023a("click_start_play_bar", mo14855v());
            } else {
                String str = "click_start_play";
                if (view.getId() == ResourceHelp.m11935e(this, "tt_reward_ad_download")) {
                    m8023a(str, mo14855v());
                } else if (view.getId() == ResourceHelp.m11935e(this, "tt_video_reward_container")) {
                    m8023a("click_video", mo14855v());
                } else if (view.getId() == ResourceHelp.m11935e(this, "tt_reward_ad_download_backup")) {
                    m8023a(str, mo14855v());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public JSONObject mo14855v() {
        int i;
        long j;
        JSONObject jSONObject = null;
        try {
            if (this.f6428A != null) {
                j = this.f6428A.mo15992p();
                i = this.f6428A.mo15993q();
            } else {
                j = 0;
                i = 0;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("duration", j);
                jSONObject2.put("percent", i);
                return jSONObject2;
            } catch (Throwable unused) {
                jSONObject = jSONObject2;
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return jSONObject;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public String mo14856w() {
        MaterialMeta kVar = this.f6508q;
        String str = "立即下载";
        if (kVar == null) {
            return str;
        }
        if (!TextUtils.isEmpty(kVar.mo15424L())) {
            str = this.f6508q.mo15424L();
        } else if (this.f6508q.mo15414B() != 4) {
            str = "查看详情";
        }
        return str;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004d  */
    /* renamed from: x */
    public java.lang.String mo14857x() {
        /*
        r7 = this;
        java.lang.String r0 = com.bytedance.sdk.openadsdk.utils.ToolUtils.m12010b(r7)
        if (r0 != 0) goto L_0x0008
        java.lang.String r0 = ""
    L_0x0008:
        r1 = 0
        r2 = 1
        java.util.Locale r3 = java.util.Locale.CHINESE     // Catch:{ all -> 0x003d }
        java.lang.String r3 = r3.getLanguage()     // Catch:{ all -> 0x003d }
        boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x003d }
        if (r3 != 0) goto L_0x0031
        java.util.Locale r3 = java.util.Locale.CHINA     // Catch:{ all -> 0x003d }
        java.lang.String r3 = r3.getLanguage()     // Catch:{ all -> 0x003d }
        boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x003d }
        if (r3 != 0) goto L_0x0031
        java.util.Locale r3 = java.util.Locale.TRADITIONAL_CHINESE     // Catch:{ all -> 0x003d }
        java.lang.String r3 = r3.getLanguage()     // Catch:{ all -> 0x003d }
        boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x003d }
        if (r3 == 0) goto L_0x002f
        goto L_0x0031
    L_0x002f:
        r3 = 0
        goto L_0x0032
    L_0x0031:
        r3 = 1
    L_0x0032:
        java.util.Locale r4 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x003e }
        java.lang.String r4 = r4.getLanguage()     // Catch:{ all -> 0x003e }
        boolean r0 = r0.equals(r4)     // Catch:{ all -> 0x003e }
        goto L_0x003f
    L_0x003d:
        r3 = 1
    L_0x003e:
        r0 = 0
    L_0x003f:
        java.lang.String r4 = "下载"
        if (r3 == 0) goto L_0x0044
        goto L_0x0048
    L_0x0044:
        if (r0 == 0) goto L_0x0048
        java.lang.String r4 = "Install"
    L_0x0048:
        com.bytedance.sdk.openadsdk.core.d.k r5 = r7.f6508q
        if (r5 != 0) goto L_0x004d
        return r4
    L_0x004d:
        java.lang.String r5 = r5.mo15424L()
        boolean r5 = android.text.TextUtils.isEmpty(r5)
        if (r5 == 0) goto L_0x006a
        com.bytedance.sdk.openadsdk.core.d.k r1 = r7.f6508q
        int r1 = r1.mo15414B()
        r2 = 4
        if (r1 == r2) goto L_0x00a9
        if (r3 == 0) goto L_0x0065
        java.lang.String r4 = "查看"
        goto L_0x00a9
    L_0x0065:
        if (r0 == 0) goto L_0x00a9
        java.lang.String r4 = "View"
        goto L_0x00a9
    L_0x006a:
        com.bytedance.sdk.openadsdk.core.d.k r4 = r7.f6508q
        java.lang.String r4 = r4.mo15424L()
        if (r4 == 0) goto L_0x008d
        boolean r5 = com.bytedance.sdk.openadsdk.utils.ToolUtils.m12039j(r4)
        if (r5 == 0) goto L_0x008d
        int r5 = r4.length()
        r6 = 2
        if (r5 <= r6) goto L_0x008d
        if (r3 == 0) goto L_0x0086
        java.lang.String r4 = r7.m8032f(r2)
        goto L_0x00a9
    L_0x0086:
        if (r0 == 0) goto L_0x00a9
        java.lang.String r4 = r7.m8032f(r1)
        goto L_0x00a9
    L_0x008d:
        if (r4 == 0) goto L_0x00a9
        boolean r5 = com.bytedance.sdk.openadsdk.utils.ToolUtils.m12039j(r4)
        if (r5 != 0) goto L_0x00a9
        int r5 = r4.length()
        r6 = 7
        if (r5 <= r6) goto L_0x00a9
        if (r3 == 0) goto L_0x00a3
        java.lang.String r4 = r7.m8032f(r2)
        goto L_0x00a9
    L_0x00a3:
        if (r0 == 0) goto L_0x00a9
        java.lang.String r4 = r7.m8032f(r1)
    L_0x00a9:
        if (r0 == 0) goto L_0x00c6
        boolean r0 = com.bytedance.sdk.openadsdk.utils.ToolUtils.m12039j(r4)
        if (r0 != 0) goto L_0x00c6
        android.widget.TextView r0 = r7.f6503l
        android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
        android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
        r1 = 1082130432(0x40800000, float:4.0)
        int r1 = com.bytedance.sdk.openadsdk.utils.UIUtils.m12079c(r7, r1)
        r0.bottomMargin = r1
        android.widget.TextView r1 = r7.f6503l
        r1.setLayoutParams(r0)
    L_0x00c6:
        return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.mo14857x():java.lang.String");
    }

    /* renamed from: f */
    private String m8032f(boolean z) {
        MaterialMeta kVar = this.f6508q;
        if (kVar == null) {
            return null;
        }
        return z ? kVar.mo15414B() != 4 ? "查看" : "下载" : kVar.mo15414B() != 4 ? "View" : "Install";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: y */
    public void mo14858y() {
        if (this.f6471ae) {
            int[] iArr = {Color.parseColor("#0070FF")};
            int c = UIUtils.m12079c(this, 17.0f);
            int parseColor = Color.parseColor("#80000000");
            TTCustomShadowBackground.m10793a((LinearLayout) findViewById(ResourceHelp.m11935e(this, "tt_reward_ad_download_layout")), new C2361a().mo16309a(iArr[0]).mo16312b(parseColor).mo16310a(iArr).mo16313c(c).mo16314d(0).mo16315e(UIUtils.m12079c(this, 3.0f)));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: z */
    public void mo14859z() {
        if (this.f6516y == null) {
            this.f6516y = new RewardDislikeDialog((Context) this, this.f6508q);
            this.f6516y.setCallback(new C2167a() {
                /* renamed from: c */
                public void mo14879c(View view) {
                }

                /* renamed from: a */
                public void mo14877a(View view) {
                    TTBaseVideoActivity.this.f6449V.set(true);
                    if (TTBaseVideoActivity.this.mo14851r()) {
                        TTBaseVideoActivity.this.f6428A.mo15984h();
                    }
                }

                /* renamed from: b */
                public void mo14878b(View view) {
                    TTBaseVideoActivity.this.f6449V.set(false);
                    if (TTBaseVideoActivity.this.mo14852s()) {
                        TTBaseVideoActivity.this.f6428A.mo15986j();
                    }
                }

                /* renamed from: a */
                public void mo14876a(int i, FilterWord filterWord) {
                    if (!TTBaseVideoActivity.this.f6450W.get() && filterWord != null && !filterWord.hasSecondOptions()) {
                        TTBaseVideoActivity.this.f6450W.set(true);
                        TTBaseVideoActivity.this.m8014S();
                    }
                }
            });
            ((FrameLayout) findViewById(16908290)).addView(this.f6516y);
        }
        if (this.f6517z == null) {
            this.f6517z = new RewardDislikeToast(this);
            ((FrameLayout) findViewById(16908290)).addView(this.f6517z);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        if (this.f6442O == 15) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(0);
        }
        super.onResume();
        VolumeChangeObserver fVar = this.f6462aH;
        if (fVar != null) {
            fVar.mo16561a(this);
            this.f6462aH.mo16560a();
        }
        if (!this.f6445R.get()) {
            if (VERSION.SDK_INT < 26) {
                if (!"C8817D".equals(this.f6453Z)) {
                    if (!"M5".equals(this.f6453Z)) {
                        if (!"R7t".equals(this.f6453Z)) {
                            if (mo14852s() && !this.f6449V.get()) {
                                this.f6428A.mo15986j();
                            }
                        }
                    }
                }
            }
            mo14800A();
        }
        TTAndroidObject xVar = this.f6430C;
        if (xVar != null) {
            xVar.mo16430g();
            SSWebView sSWebView = this.f6496e;
            if (sSWebView != null) {
                if (sSWebView.getVisibility() == 0) {
                    this.f6430C.mo16418b(true);
                    mo14824b(true);
                    mo14818a(false, true);
                } else {
                    this.f6430C.mo16418b(false);
                    mo14824b(false);
                    mo14818a(true, false);
                }
            }
        }
        ITTDownloadAdapter aVar = this.f6429B;
        if (aVar != null) {
            aVar.mo16507a((Activity) this);
            this.f6429B.mo16513b();
        }
        LandingPageLog jVar = this.f6509r;
        if (jVar != null) {
            jVar.mo15019a();
        }
        if (this.f6489aw.get()) {
            MaterialMeta kVar = this.f6508q;
            if (kVar != null && kVar.mo15466c() == 1 && this.f6508q.mo15503q()) {
                mo14827c("return_foreground");
                this.f6433F.sendEmptyMessageDelayed(OtherError.CONTAINER_INVISIBLE_ERROR, this.f6487au * 1000);
                Message obtain = Message.obtain();
                obtain.what = OtherError.VIDEO_DOWNLOAD_ERROR;
                obtain.arg1 = this.f6486at;
                this.f6433F.sendMessage(obtain);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        LandingPageLog jVar = this.f6509r;
        if (jVar != null) {
            jVar.mo15027b();
        }
        MaterialMeta kVar = this.f6508q;
        if (kVar != null && kVar.mo15466c() == 1 && this.f6508q.mo15503q()) {
            this.f6433F.removeMessages(OtherError.VIDEO_DOWNLOAD_ERROR);
            this.f6433F.removeMessages(OtherError.CONTAINER_INVISIBLE_ERROR);
            mo14827c("go_background");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public void mo14800A() {
        if (!this.f6446S.getAndSet(false)) {
            INativeVideoController cVar = this.f6428A;
            if (cVar != null) {
                if (cVar.mo15996t() != null) {
                    SSMediaPlayerWrapper t = this.f6428A.mo15996t();
                    if (t.mo16069i() || t.mo16070j()) {
                        ((BaseVideoController) this.f6428A).mo16000x();
                        mo14908a(this.f6512u, true);
                    }
                } else if (this.f6466aL) {
                    ((BaseVideoController) this.f6428A).mo16000x();
                    mo14908a(this.f6512u, true);
                    this.f6466aL = false;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    public void onPause() {
        /*
        r3 = this;
        super.onPause()
        int r0 = android.os.Build.VERSION.SDK_INT
        r1 = 26
        if (r0 >= r1) goto L_0x0058
        java.lang.String r0 = r3.f6453Z
        java.lang.String r1 = "C8817D"
        boolean r0 = r1.equals(r0)
        if (r0 != 0) goto L_0x0058
        java.lang.String r0 = r3.f6453Z
        java.lang.String r1 = "M5"
        boolean r0 = r1.equals(r0)
        if (r0 != 0) goto L_0x0058
        java.lang.String r0 = r3.f6453Z
        java.lang.String r1 = "R7t"
        boolean r0 = r1.equals(r0)
        if (r0 == 0) goto L_0x0028
        goto L_0x0058
    L_0x0028:
        boolean r0 = r3.mo14851r()     // Catch:{ all -> 0x003c }
        if (r0 == 0) goto L_0x005b
        java.util.concurrent.atomic.AtomicBoolean r0 = r3.f6449V     // Catch:{ all -> 0x003c }
        boolean r0 = r0.get()     // Catch:{ all -> 0x003c }
        if (r0 != 0) goto L_0x005b
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c r0 = r3.f6428A     // Catch:{ all -> 0x003c }
        r0.mo15984h()     // Catch:{ all -> 0x003c }
        goto L_0x005b
    L_0x003c:
        r0 = move-exception
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r2 = "onPause throw Exception :"
        r1.append(r2)
        java.lang.String r0 = r0.getMessage()
        r1.append(r0)
        java.lang.String r0 = r1.toString()
        java.lang.String r1 = "TTBaseVideoActivity"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r1, r0)
        goto L_0x005b
    L_0x0058:
        r3.mo14905M()
    L_0x005b:
        com.bytedance.sdk.openadsdk.core.x r0 = r3.f6430C
        if (r0 == 0) goto L_0x006f
        r0.mo16433h()
        com.bytedance.sdk.openadsdk.core.x r0 = r3.f6430C
        r1 = 0
        r0.mo16418b(r1)
        r3.mo14824b(r1)
        r0 = 1
        r3.mo14818a(r0, r1)
    L_0x006f:
        com.bytedance.sdk.openadsdk.downloadnew.core.a r0 = r3.f6429B
        if (r0 == 0) goto L_0x0076
        r0.mo16516c()
    L_0x0076:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.onPause():void");
    }

    /* renamed from: M */
    private void mo14905M() {
        INativeVideoController cVar = this.f6428A;
        if (cVar != null && cVar.mo15996t() != null) {
            this.f6512u = this.f6428A.mo15989m();
            if (this.f6428A.mo15996t().mo16068h() || !this.f6428A.mo15996t().mo16072l()) {
                this.f6428A.mo15984h();
                this.f6428A.mo15987k();
                this.f6466aL = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        RewardDislikeToast rewardDislikeToast = this.f6517z;
        if (rewardDislikeToast != null) {
            rewardDislikeToast.mo15200b();
        }
        C2538ak akVar = this.f6433F;
        if (akVar != null) {
            akVar.removeCallbacksAndMessages(null);
        }
        WebViewTweaker.m9083a(this.f6495d, this.f6496e);
        WebViewTweaker.m9084a(this.f6496e);
        INativeVideoController cVar = this.f6428A;
        if (cVar != null) {
            cVar.mo15987k();
            this.f6428A = null;
        }
        this.f6496e = null;
        TTAndroidObject xVar = this.f6430C;
        if (xVar != null) {
            xVar.mo16434i();
        }
        ITTDownloadAdapter aVar = this.f6429B;
        if (aVar != null) {
            aVar.mo16518d();
        }
        LandingPageLog jVar = this.f6509r;
        if (jVar != null) {
            jVar.mo15028c();
        }
        VolumeChangeObserver fVar = this.f6462aH;
        if (fVar != null) {
            fVar.mo16562b();
            this.f6462aH.mo16561a(null);
        }
        mo14822b(getApplicationContext());
        if (MultiGlobalInfo.m11808b()) {
            try {
                m8021a("recycleRes", 0, 0, "", "");
            } catch (Throwable th) {
                C2564t.m12223c("TTBaseVideoActivity", "remove from ITTAppDownloadListener throw Exception : ", th);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putString("material_meta", this.f6508q != null ? this.f6508q.mo15459ae().toString() : null);
            bundle.putString("multi_process_meta_md5", this.f6510s);
            bundle.putLong("video_current", this.f6428A == null ? this.f6512u : this.f6428A.mo15989m());
            bundle.putString("video_cache_url", this.f6513v);
            bundle.putInt("orientation", this.f6514w);
            bundle.putBoolean("is_mute", this.f6440M);
            bundle.putBoolean("is_bar_click_first", this.f6461aG);
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    /* renamed from: O */
    private void mo14921O() {
        TopProxyLayout topProxyLayout = this.f6493b;
        if (topProxyLayout != null) {
            topProxyLayout.setShowSound(false);
        }
    }

    /* renamed from: a */
    public void mo14813a(Message message) {
        if (message.what == 500) {
            mo14921O();
            TopProxyLayout topProxyLayout = this.f6493b;
            if (topProxyLayout != null) {
                topProxyLayout.setShowCountDown(false);
            }
            SSWebView sSWebView = this.f6496e;
            if (sSWebView != null) {
                UIUtils.m12058a((View) sSWebView, 1.0f);
                UIUtils.m12058a((View) this.f6498g, 1.0f);
                UIUtils.m12058a((View) this.f6499h, 1.0f);
            }
            if ((this instanceof TTFullScreenVideoActivity) && this.f6428A != null && mo14851r() && this.f6448U.get()) {
                this.f6428A.mo15985i();
                this.f6428A.mo15988l();
            }
        } else if (message.what == 600) {
            UIUtils.m12059a((View) this.f6498g, 0);
            UIUtils.m12059a((View) this.f6499h, 0);
        } else if (message.what == 700) {
            if (this.f6508q.mo15466c() == 1) {
                int i = message.arg1;
                if (i > 0) {
                    TopProxyLayout topProxyLayout2 = this.f6493b;
                    if (topProxyLayout2 != null) {
                        topProxyLayout2.setShowCountDown(true);
                        this.f6493b.mo15164a((CharSequence) String.valueOf(i), (CharSequence) null);
                    }
                    Message obtain = Message.obtain();
                    obtain.what = OtherError.VIDEO_DOWNLOAD_ERROR;
                    int i2 = i - 1;
                    obtain.arg1 = i2;
                    this.f6487au--;
                    this.f6433F.sendMessageDelayed(obtain, 1000);
                    this.f6486at = i2;
                } else {
                    TopProxyLayout topProxyLayout3 = this.f6493b;
                    if (topProxyLayout3 != null) {
                        topProxyLayout3.setShowCountDown(false);
                    }
                    if (this instanceof TTRewardVideoActivity) {
                        mo14926f(ProfileID.PID_KVProfile_ACCOUNT);
                    } else {
                        mo14926f(10002);
                    }
                }
                if (this instanceof TTRewardVideoActivity) {
                    mo14923Q();
                }
            }
        } else if (message.what == 800) {
            HashMap hashMap = new HashMap();
            hashMap.put("remove_loading_page_type", Integer.valueOf(message.arg1));
            if (this.f6508q.mo15512z() != null) {
                hashMap.put("playable_url", this.f6508q.mo15512z().mo15604h());
            }
            AdEventManager.m8419r(this, this.f6508q, this.f6490ax, "remove_loading_page", hashMap);
            this.f6433F.removeMessages(800);
            PlayableLoadingView playableLoadingView = this.f6454a;
            if (playableLoadingView != null) {
                playableLoadingView.mo16239a();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: B */
    public void mo14801B() {
        C2538ak akVar = this.f6433F;
        if (akVar != null) {
            akVar.removeMessages(OtherError.VIDEO_DOWNLOAD_ERROR);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public void mo14802C() {
        if (this.f6433F != null) {
            Message obtain = Message.obtain();
            obtain.what = OtherError.VIDEO_DOWNLOAD_ERROR;
            obtain.arg1 = this.f6486at;
            this.f6433F.sendMessageDelayed(obtain, 1000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Q */
    public void mo14923Q() {
        if (!InternalContainer.m10069h().mo15802m(String.valueOf(this.f6444Q)) || this.f6430C.mo16423c()) {
            if ((1.0f - (((float) this.f6486at) / ((float) InternalContainer.m10069h().mo15806o(String.valueOf(this.f6444Q))))) * 100.0f >= ((float) InternalContainer.m10069h().mo15812r(String.valueOf(this.f6444Q)).f7591g)) {
                mo14926f(C7516p.f25219Cf);
            }
        }
    }

    /* renamed from: a */
    private void m8021a(String str, long j, long j2, String str2, String str3) {
        TTExecutor a = TTExecutor.m11692a();
        final String str4 = str;
        final long j3 = j;
        final long j4 = j2;
        final String str5 = str2;
        final String str6 = str3;
        C20195 r1 = new Runnable() {
            public void run() {
                try {
                    TTBaseVideoActivity.this.mo14809a(3).executeAppDownloadCallback(TTBaseVideoActivity.this.f6510s, str4, j3, j4, str5, str6);
                } catch (Throwable th) {
                    C2564t.m12223c("TTBaseVideoActivity", "executeAppDownloadCallback execute throw Exception : ", th);
                }
            }
        };
        a.mo16804a((Runnable) r1, 5);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public IListenerManager mo14809a(int i) {
        return AbstractListenerManager.asInterface(BinderPool.m11776a(InternalContainer.m10059a()).mo16858a(i));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public IListenerManager mo14820b(int i) {
        if (this.f6468ab == null) {
            this.f6468ab = AbstractListenerManager.asInterface(BinderPool.m11776a(InternalContainer.m10059a()).mo16858a(i));
        }
        return this.f6468ab;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: D */
    public void mo14803D() {
        TopProxyLayout topProxyLayout = this.f6493b;
        if (topProxyLayout != null) {
            topProxyLayout.setShowSkip(false);
            this.f6493b.setShowCountDown(false);
            this.f6493b.setShowDislike(false);
        }
        RewardDislikeToast rewardDislikeToast = this.f6517z;
        if (rewardDislikeToast != null) {
            rewardDislikeToast.mo15198a();
        }
        if (!this.f6445R.getAndSet(true)) {
            this.f6448U.set(true);
            if (!this.f6479am.get()) {
                MaterialMeta kVar = this.f6508q;
                if (kVar != null && !kVar.mo15503q()) {
                    UIUtils.m12059a((View) this.f6496e, 8);
                    UIUtils.m12059a((View) this.f6473ag, 0);
                    UIUtils.m12059a((View) this.f6498g, 0);
                    UIUtils.m12059a((View) this.f6499h, 0);
                    mo14921O();
                    mo14904L();
                    if ((this instanceof TTFullScreenVideoActivity) && this.f6428A != null && mo14851r() && this.f6448U.get()) {
                        this.f6428A.mo15985i();
                        this.f6428A.mo15988l();
                    }
                    return;
                }
            }
            if (VERSION.SDK_INT >= 11) {
                UIUtils.m12058a((View) this.f6496e, 0.0f);
                UIUtils.m12058a((View) this.f6498g, 0.0f);
                UIUtils.m12058a((View) this.f6499h, 0.0f);
            }
            UIUtils.m12059a((View) this.f6496e, 0);
            MaterialMeta kVar2 = this.f6508q;
            if (kVar2 == null || !kVar2.mo15503q()) {
                MaterialMeta kVar3 = this.f6508q;
                if (kVar3 != null && !kVar3.mo15503q()) {
                    int l = InternalContainer.m10069h().mo15800l(String.valueOf(this.f6444Q));
                    if (l == -1) {
                        UIUtils.m12059a((View) this.f6498g, 0);
                        UIUtils.m12059a((View) this.f6499h, 0);
                    } else if (l >= 0) {
                        this.f6433F.sendEmptyMessageDelayed(OtherError.CONTAINER_INVISIBLE_ERROR, (long) l);
                    }
                }
            } else {
                int p = InternalContainer.m10069h().mo15807p(String.valueOf(this.f6444Q));
                if (p == -1) {
                    UIUtils.m12059a((View) this.f6498g, 0);
                    UIUtils.m12059a((View) this.f6499h, 0);
                } else if (p >= 0) {
                    this.f6433F.sendEmptyMessageDelayed(OtherError.CONTAINER_INVISIBLE_ERROR, (long) p);
                }
            }
            this.f6433F.sendEmptyMessageDelayed(500, 100);
            mo14818a(this.f6440M, true);
            TTAndroidObject xVar = this.f6430C;
            if (xVar != null) {
                xVar.mo16418b(true);
                mo14824b(true);
            }
            mo14839m();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo14818a(boolean z, boolean z2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            jSONObject.put("endcard_show", z2);
            this.f6430C.mo16412a("endcard_control_event", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo14824b(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z ? 1 : 0);
            this.f6430C.mo16412a("viewableChange", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo14828c(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            this.f6430C.mo16412a("volumeChange", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo14811a(int i, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i);
            jSONObject.put("height", i2);
            this.f6430C.mo16412a("resize", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo14815a(String str, String str2, Map<String, Object> map) {
        INativeVideoController cVar = this.f6428A;
        if (cVar != null) {
            Map a = ToolUtils.m11997a(this.f6508q, cVar.mo15990n(), this.f6428A.mo15996t());
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    a.put(entry.getKey(), entry.getValue());
                }
            }
            AdEventManager.m8386a(this.f6495d, this.f6508q, str, str2, this.f6428A.mo15991o(), this.f6428A.mo15993q(), a);
            StringBuilder sb = new StringBuilder();
            sb.append("event tag:");
            sb.append(str);
            sb.append(", TotalPlayDuration=");
            sb.append(this.f6428A.mo15991o());
            sb.append(",mBasevideoController.getPct()=");
            sb.append(this.f6428A.mo15993q());
            C2564t.m12220b("TTBaseVideoActivity", sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo14816a(String str, Map<String, Object> map) {
        INativeVideoController cVar = this.f6428A;
        if (cVar != null) {
            Map a = ToolUtils.m11997a(this.f6508q, cVar.mo15990n(), this.f6428A.mo15996t());
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    a.put(entry.getKey(), entry.getValue());
                }
            }
            a.put("play_type", Integer.valueOf(ToolUtils.m11990a(this.f6428A, this.f6515x)));
            String str2 = str;
            AdEventManager.m8386a(this.f6495d, this.f6508q, str2, "endcard_skip", this.f6428A.mo15991o(), this.f6428A.mo15993q(), a);
        }
    }

    /* renamed from: c */
    public void mo14826c(int i) {
        String str = "onVolumeChanged";
        if (i > 0) {
            if (this.f6467aM > 0) {
                this.f6467aM = i;
                return;
            }
            C2564t.m12220b(str, "onVolumeChanged >>>> 变为非静音状态通知 h5");
            mo14828c(false);
            this.f6467aM = i;
        } else if (this.f6467aM > 0) {
            C2564t.m12220b(str, "onVolumeChanged >>>> 变为静音状态通知 h5");
            mo14828c(true);
            this.f6467aM = i;
        } else {
            this.f6467aM = i;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo14827c(String str) {
        if (this.f6491ay) {
            String str2 = this instanceof TTRewardVideoActivity ? "rewarded_video" : "fullscreen_interstitial_ad";
            HashMap hashMap = new HashMap();
            hashMap.put("duration", Long.valueOf(System.currentTimeMillis() - this.f6485as));
            AdEventManager.m8416o(this, this.f6508q, str2, str, hashMap);
            if ("return_foreground".equals(str)) {
                this.f6491ay = false;
            }
        }
    }

    /* renamed from: E */
    public void mo14804E() {
        this.f6491ay = true;
    }

    /* renamed from: F */
    public void mo14805F() {
        this.f6491ay = true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo14812a(Context context) {
        try {
            this.f6432E = new HomeWatcherReceiver();
            this.f6432E.mo16894a(this);
            context.registerReceiver(this.f6432E, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo14822b(Context context) {
        try {
            this.f6432E.mo16894a(null);
            context.unregisterReceiver(this.f6432E);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: G */
    public double mo14806G() {
        MaterialMeta kVar = this.f6508q;
        if (kVar == null || kVar.mo15512z() == null) {
            return 0.0d;
        }
        return this.f6508q.mo15512z().mo15596d();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public float mo14808a(Activity activity) {
        return (float) UIUtils.m12068b((Context) activity, (float) UIUtils.m12090g(activity));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public float mo14819b(Activity activity) {
        return (float) UIUtils.m12068b((Context) activity, (float) UIUtils.m12091h(activity));
    }

    /* access modifiers changed from: protected */
    /* renamed from: H */
    public void mo14807H() {
        if (!isFinishing()) {
            if (this.f6450W.get()) {
                m8013R();
                return;
            }
            if (this.f6516y == null) {
                mo14859z();
            }
            this.f6516y.mo15191a();
        }
    }

    /* renamed from: R */
    private void m8013R() {
        this.f6517z.mo15199a("您已成功提交反馈，请勿重复提交哦！");
    }

    /* access modifiers changed from: private */
    /* renamed from: S */
    public void m8014S() {
        this.f6517z.mo15199a("感谢您的反馈！\n我们将为您带来更优质的广告体验");
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo14830d(boolean z) {
        if (this.f6459aE == null) {
            this.f6459aE = new ProgressBar(this);
            LayoutParams layoutParams = new LayoutParams(120, 120);
            layoutParams.gravity = 17;
            this.f6459aE.setLayoutParams(layoutParams);
            this.f6459aE.setIndeterminateDrawable(getResources().getDrawable(ResourceHelp.m11934d(this, "tt_video_loading_progress_bar")));
            this.f6504m.addView(this.f6459aE);
        }
        if (z) {
            this.f6459aE.setVisibility(0);
        } else {
            this.f6459aE.setVisibility(8);
        }
    }
}
