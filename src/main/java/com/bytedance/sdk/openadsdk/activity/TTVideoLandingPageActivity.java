package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.NetApi;
import com.bytedance.sdk.openadsdk.core.NetApi.C2287b;
import com.bytedance.sdk.openadsdk.core.TTAndroidObject;
import com.bytedance.sdk.openadsdk.core.WebViewTweaker;
import com.bytedance.sdk.openadsdk.core.p167a.ClickCreativeListener;
import com.bytedance.sdk.openadsdk.core.p170d.AdInfo;
import com.bytedance.sdk.openadsdk.core.p170d.DownloadModel;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p170d.NetExtParams;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.IMediaCallback;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.INativeVideoController;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.IVideoFullscreen;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoController;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.p177c.SSMediaPlayerWrapper;
import com.bytedance.sdk.openadsdk.core.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.downloadnew.TTDownloadFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.multipro.p203b.VideoControllerDataModel;
import com.bytedance.sdk.openadsdk.multipro.p205d.SPMultiHelper;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.p165c.LandingPageLog;
import com.bytedance.sdk.openadsdk.p180d.TeMaiIdsListener;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.bytedance.sdk.openadsdk.utils.UIUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class TTVideoLandingPageActivity extends Activity implements TeMaiIdsListener {
    /* access modifiers changed from: private */
    /* renamed from: A */
    public Button f6677A;
    /* access modifiers changed from: private */
    /* renamed from: B */
    public ProgressBar f6678B;
    /* renamed from: C */
    private ITTDownloadAdapter f6679C;
    /* access modifiers changed from: private|final */
    /* renamed from: D */
    public final Map<String, ITTDownloadAdapter> f6680D = Collections.synchronizedMap(new HashMap());
    /* access modifiers changed from: private */
    /* renamed from: E */
    public boolean f6681E = false;
    /* renamed from: F */
    private DownloadModel f6682F;
    /* renamed from: G */
    private String f6683G;
    /* access modifiers changed from: private */
    /* renamed from: H */
    public boolean f6684H = false;
    /* renamed from: I */
    private boolean f6685I = true;
    /* renamed from: J */
    private boolean f6686J = false;
    /* access modifiers changed from: private */
    /* renamed from: K */
    public String f6687K = null;
    /* access modifiers changed from: private */
    /* renamed from: L */
    public int f6688L;
    /* renamed from: M */
    private VideoControllerDataModel f6689M;
    /* renamed from: N */
    private LandingPageLog f6690N;
    /* access modifiers changed from: private */
    /* renamed from: O */
    public AtomicBoolean f6691O = new AtomicBoolean(true);
    /* renamed from: P */
    private JSONArray f6692P = null;
    /* renamed from: Q */
    private String f6693Q = "立即下载";
    /* renamed from: R */
    private TTAppDownloadListener f6694R = new TTAppDownloadListener() {
        public void onIdle() {
            TTVideoLandingPageActivity tTVideoLandingPageActivity = TTVideoLandingPageActivity.this;
            tTVideoLandingPageActivity.m8287a(tTVideoLandingPageActivity.m8297d());
        }

        public void onDownloadActive(long j, long j2, String str, String str2) {
            TTVideoLandingPageActivity.this.m8287a("下载中...");
        }

        public void onDownloadPaused(long j, long j2, String str, String str2) {
            TTVideoLandingPageActivity.this.m8287a("暂停");
        }

        public void onDownloadFailed(long j, long j2, String str, String str2) {
            TTVideoLandingPageActivity.this.m8287a("下载失败");
        }

        public void onDownloadFinished(long j, String str, String str2) {
            TTVideoLandingPageActivity.this.m8287a("点击安装");
        }

        public void onInstalled(String str, String str2) {
            TTVideoLandingPageActivity.this.m8287a("点击打开");
        }
    };
    /* renamed from: S */
    private ClickCreativeListener f6695S = null;
    /* renamed from: T */
    private final IVideoFullscreen f6696T = new IVideoFullscreen() {
        /* renamed from: a */
        public void mo14985a(boolean z) {
            TTVideoLandingPageActivity.this.f6681E = z;
            if (TTVideoLandingPageActivity.this.isFinishing()) {
                return;
            }
            if (z) {
                UIUtils.m12059a((View) TTVideoLandingPageActivity.this.f6699a, 8);
                UIUtils.m12059a((View) TTVideoLandingPageActivity.this.f6709k, 8);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) TTVideoLandingPageActivity.this.f6710l.getLayoutParams();
                TTVideoLandingPageActivity.this.f6716r = marginLayoutParams.leftMargin;
                TTVideoLandingPageActivity.this.f6715q = marginLayoutParams.topMargin;
                TTVideoLandingPageActivity.this.f6717s = marginLayoutParams.width;
                TTVideoLandingPageActivity.this.f6718t = marginLayoutParams.height;
                marginLayoutParams.width = -1;
                marginLayoutParams.height = -1;
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.leftMargin = 0;
                TTVideoLandingPageActivity.this.f6710l.setLayoutParams(marginLayoutParams);
                return;
            }
            UIUtils.m12059a((View) TTVideoLandingPageActivity.this.f6699a, 0);
            UIUtils.m12059a((View) TTVideoLandingPageActivity.this.f6709k, 0);
            MarginLayoutParams marginLayoutParams2 = (MarginLayoutParams) TTVideoLandingPageActivity.this.f6710l.getLayoutParams();
            marginLayoutParams2.width = TTVideoLandingPageActivity.this.f6717s;
            marginLayoutParams2.height = TTVideoLandingPageActivity.this.f6718t;
            marginLayoutParams2.leftMargin = TTVideoLandingPageActivity.this.f6716r;
            marginLayoutParams2.topMargin = TTVideoLandingPageActivity.this.f6715q;
            TTVideoLandingPageActivity.this.f6710l.setLayoutParams(marginLayoutParams2);
        }
    };
    /* renamed from: U */
    private boolean f6697U = false;
    /* renamed from: V */
    private final BroadcastReceiver f6698V = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                int c = C2566w.m12244c(TTVideoLandingPageActivity.this.getApplicationContext());
                if (!(TTVideoLandingPageActivity.this.f6688L != 0 || c == 0 || TTVideoLandingPageActivity.this.f6699a == null || TTVideoLandingPageActivity.this.f6687K == null)) {
                    TTVideoLandingPageActivity.this.f6699a.loadUrl(TTVideoLandingPageActivity.this.f6687K);
                }
                if (!(TTVideoLandingPageActivity.this.f6712n == null || TTVideoLandingPageActivity.this.f6712n.getNativeVideoController() == null || TTVideoLandingPageActivity.this.f6684H || TTVideoLandingPageActivity.this.f6688L == c)) {
                    ((NativeVideoController) TTVideoLandingPageActivity.this.f6712n.getNativeVideoController()).mo16118a(context);
                }
                TTVideoLandingPageActivity.this.f6688L = c;
            }
        }
    };
    /* access modifiers changed from: private */
    /* renamed from: a */
    public SSWebView f6699a;
    /* renamed from: b */
    private ImageView f6700b;
    /* renamed from: c */
    private ImageView f6701c;
    /* renamed from: d */
    private TextView f6702d;
    /* renamed from: e */
    private Context f6703e;
    /* renamed from: f */
    private int f6704f;
    /* renamed from: g */
    private String f6705g;
    /* renamed from: h */
    private String f6706h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public TTAndroidObject f6707i;
    /* renamed from: j */
    private int f6708j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public RelativeLayout f6709k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public FrameLayout f6710l;
    /* renamed from: m */
    private int f6711m = -1;
    /* access modifiers changed from: private */
    /* renamed from: n */
    public NativeVideoTsView f6712n;
    /* renamed from: o */
    private long f6713o;
    /* access modifiers changed from: private */
    /* renamed from: p */
    public MaterialMeta f6714p;
    /* access modifiers changed from: private */
    /* renamed from: q */
    public int f6715q = 0;
    /* access modifiers changed from: private */
    /* renamed from: r */
    public int f6716r = 0;
    /* access modifiers changed from: private */
    /* renamed from: s */
    public int f6717s = 0;
    /* access modifiers changed from: private */
    /* renamed from: t */
    public int f6718t = 0;
    /* renamed from: u */
    private RelativeLayout f6719u;
    /* renamed from: v */
    private TextView f6720v;
    /* renamed from: w */
    private RoundImageView f6721w;
    /* renamed from: x */
    private TextView f6722x;
    /* renamed from: y */
    private TextView f6723y;
    /* renamed from: z */
    private ViewStub f6724z;

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(22:0|(1:2)|3|4|5|6|8|(1:12)|13|(4:15|(2:17|18)|20|(1:22))(3:23|(1:25)|26)|(4:28|29|31|(1:33))|(5:35|(2:37|38)|40|(1:42)|(1:44))|45|(1:47)(1:48)|49|(2:50|51)|53|(1:55)|56|(3:58|(1:60)|61)|62|63) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00da A[SYNTHETIC, Splitter:B:28:0x00da] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01e4  */
    public void onCreate(android.os.Bundle r15) {
        /*
        r14 = this;
        super.onCreate(r15)
        com.bytedance.sdk.openadsdk.core.h r0 = com.bytedance.sdk.openadsdk.core.GlobalInfo.m9616c()
        boolean r0 = r0.mo15682l()
        if (r0 == 0) goto L_0x0016
        android.view.Window r0 = r14.getWindow()
        r1 = 2621440(0x280000, float:3.67342E-39)
        r0.addFlags(r1)
    L_0x0016:
        android.view.Window r0 = r14.getWindow()     // Catch:{ all -> 0x001f }
        r1 = 16777216(0x1000000, float:2.3509887E-38)
        r0.addFlags(r1)     // Catch:{ all -> 0x001f }
    L_0x001f:
        com.bytedance.sdk.openadsdk.core.InternalContainer.m10061a(r14)     // Catch:{ all -> 0x0023 }
        goto L_0x0024
    L_0x0024:
        android.content.Context r0 = r14.getApplicationContext()
        int r0 = com.bytedance.sdk.openadsdk.utils.C2566w.m12244c(r0)
        r14.f6688L = r0
        java.lang.String r0 = "tt_activity_videolandingpage"
        int r0 = com.bytedance.sdk.openadsdk.utils.ResourceHelp.m11936f(r14, r0)
        r14.setContentView(r0)
        r14.f6703e = r14
        android.content.Intent r0 = r14.getIntent()
        r1 = 1
        java.lang.String r2 = "sdk_version"
        int r2 = r0.getIntExtra(r2, r1)
        r14.f6704f = r2
        java.lang.String r2 = "adid"
        java.lang.String r3 = r0.getStringExtra(r2)
        r14.f6705g = r3
        java.lang.String r3 = "log_extra"
        java.lang.String r3 = r0.getStringExtra(r3)
        r14.f6706h = r3
        r3 = -1
        java.lang.String r4 = "source"
        int r3 = r0.getIntExtra(r4, r3)
        r14.f6708j = r3
        java.lang.String r3 = "url"
        java.lang.String r4 = r0.getStringExtra(r3)
        r14.f6687K = r4
        java.lang.String r4 = "web_title"
        java.lang.String r5 = r0.getStringExtra(r4)
        java.lang.String r6 = "event_tag"
        java.lang.String r7 = r0.getStringExtra(r6)
        r14.f6683G = r7
        java.lang.String r7 = "video_is_auto_play"
        boolean r7 = r0.getBooleanExtra(r7, r1)
        r14.f6686J = r7
        r7 = 0
        java.lang.String r9 = "video_play_position"
        if (r15 == 0) goto L_0x0091
        long r10 = r15.getLong(r9)
        int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
        if (r12 <= 0) goto L_0x0091
        long r10 = r15.getLong(r9, r7)
        r14.f6713o = r10
    L_0x0091:
        java.lang.String r10 = "multi_process_data"
        java.lang.String r10 = r0.getStringExtra(r10)
        boolean r11 = com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo.m11808b()
        if (r11 == 0) goto L_0x00bd
        java.lang.String r11 = "multi_process_materialmeta"
        java.lang.String r0 = r0.getStringExtra(r11)
        if (r0 == 0) goto L_0x00b2
        org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x00b1 }
        r11.<init>(r0)     // Catch:{ Exception -> 0x00b1 }
        com.bytedance.sdk.openadsdk.core.d.k r0 = com.bytedance.sdk.openadsdk.core.AdInfoFactory.m9163a(r11)     // Catch:{ Exception -> 0x00b1 }
        r14.f6714p = r0     // Catch:{ Exception -> 0x00b1 }
        goto L_0x00b2
    L_0x00b2:
        com.bytedance.sdk.openadsdk.core.d.k r0 = r14.f6714p
        if (r0 == 0) goto L_0x00d8
        int r0 = r0.mo15429Q()
        r14.f6711m = r0
        goto L_0x00d8
    L_0x00bd:
        com.bytedance.sdk.openadsdk.core.u r0 = com.bytedance.sdk.openadsdk.core.SingleAppData.m10160a()
        com.bytedance.sdk.openadsdk.core.d.k r0 = r0.mo15937c()
        r14.f6714p = r0
        com.bytedance.sdk.openadsdk.core.d.k r0 = r14.f6714p
        if (r0 == 0) goto L_0x00d1
        int r0 = r0.mo15429Q()
        r14.f6711m = r0
    L_0x00d1:
        com.bytedance.sdk.openadsdk.core.u r0 = com.bytedance.sdk.openadsdk.core.SingleAppData.m10160a()
        r0.mo15941g()
    L_0x00d8:
        if (r10 == 0) goto L_0x00f5
        org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00e6 }
        r0.<init>(r10)     // Catch:{ Exception -> 0x00e6 }
        com.bytedance.sdk.openadsdk.multipro.b.a r0 = com.bytedance.sdk.openadsdk.multipro.p203b.VideoControllerDataModel.m11809a(r0)     // Catch:{ Exception -> 0x00e6 }
        r14.f6689M = r0     // Catch:{ Exception -> 0x00e6 }
        goto L_0x00e7
    L_0x00e7:
        com.bytedance.sdk.openadsdk.multipro.b.a r0 = r14.f6689M
        if (r0 == 0) goto L_0x00f5
        long r10 = r0.f9086g
        r14.f6713o = r10
        com.bytedance.sdk.openadsdk.multipro.b.a r0 = r14.f6689M
        boolean r0 = r0.f9080a
        r14.f6684H = r0
    L_0x00f5:
        if (r15 == 0) goto L_0x0122
        java.lang.String r0 = "material_meta"
        java.lang.String r0 = r15.getString(r0)
        com.bytedance.sdk.openadsdk.core.d.k r10 = r14.f6714p
        if (r10 != 0) goto L_0x010e
        org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ all -> 0x010d }
        r10.<init>(r0)     // Catch:{ all -> 0x010d }
        com.bytedance.sdk.openadsdk.core.d.k r0 = com.bytedance.sdk.openadsdk.core.AdInfoFactory.m9163a(r10)     // Catch:{ all -> 0x010d }
        r14.f6714p = r0     // Catch:{ all -> 0x010d }
        goto L_0x010e
    L_0x010e:
        long r9 = r15.getLong(r9)
        java.lang.String r0 = "is_complete"
        boolean r15 = r15.getBoolean(r0)
        int r0 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
        if (r0 <= 0) goto L_0x011e
        r14.f6713o = r9
    L_0x011e:
        if (r15 == 0) goto L_0x0122
        r14.f6684H = r15
    L_0x0122:
        com.bytedance.sdk.openadsdk.core.d.h r15 = new com.bytedance.sdk.openadsdk.core.d.h
        com.bytedance.sdk.openadsdk.core.d.k r0 = r14.f6714p
        java.lang.String r7 = r14.f6683G
        r15.m43672init(r0, r7)
        r14.f6682F = r15
        r14.m8301e()
        r14.m8312j()
        r14.m8314k()
        r15 = 4
        r14.m8284a(r15)
        int r15 = android.os.Build.VERSION.SDK_INT
        r0 = 16
        r7 = 0
        if (r15 < r0) goto L_0x0143
        r15 = 1
        goto L_0x0144
    L_0x0143:
        r15 = 0
    L_0x0144:
        android.content.Context r0 = r14.f6703e
        com.bytedance.sdk.openadsdk.core.widget.webview.a r0 = com.bytedance.sdk.openadsdk.core.widget.webview.SSWebSettings.m10854a(r0)
        com.bytedance.sdk.openadsdk.core.widget.webview.a r15 = r0.mo16362a(r15)
        com.bytedance.sdk.openadsdk.core.widget.webview.a r15 = r15.mo16364b(r7)
        com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView r0 = r14.f6699a
        r15.mo16363a(r0)
        com.bytedance.sdk.openadsdk.c.j r15 = new com.bytedance.sdk.openadsdk.c.j
        com.bytedance.sdk.openadsdk.core.d.k r0 = r14.f6714p
        com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView r8 = r14.f6699a
        r15.m43390init(r14, r0, r8)
        com.bytedance.sdk.openadsdk.c.j r15 = r15.mo15018a(r1)
        r14.f6690N = r15
        org.json.JSONObject r15 = new org.json.JSONObject
        r15.<init>()
        java.lang.String r0 = r14.f6705g     // Catch:{ JSONException -> 0x0187 }
        r15.put(r2, r0)     // Catch:{ JSONException -> 0x0187 }
        java.lang.String r0 = r14.f6687K     // Catch:{ JSONException -> 0x0187 }
        r15.put(r3, r0)     // Catch:{ JSONException -> 0x0187 }
        r15.put(r4, r5)     // Catch:{ JSONException -> 0x0187 }
        java.lang.String r0 = "is_multi_process"
        boolean r1 = com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo.m11808b()     // Catch:{ JSONException -> 0x0187 }
        r15.put(r0, r1)     // Catch:{ JSONException -> 0x0187 }
        java.lang.String r0 = r14.f6683G     // Catch:{ JSONException -> 0x0187 }
        r15.put(r6, r0)     // Catch:{ JSONException -> 0x0187 }
        goto L_0x0188
    L_0x0188:
        com.bytedance.sdk.openadsdk.c.j r0 = r14.f6690N
        r0.mo15026a(r15)
        com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView r15 = r14.f6699a
        com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity$1 r0 = new com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity$1
        android.content.Context r10 = r14.f6703e
        com.bytedance.sdk.openadsdk.core.x r11 = r14.f6707i
        java.lang.String r12 = r14.f6705g
        com.bytedance.sdk.openadsdk.c.j r13 = r14.f6690N
        r8 = r0
        r9 = r14
        r8.m43350init(r10, r11, r12, r13)
        r15.setWebViewClient(r0)
        com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView r15 = r14.f6699a
        android.webkit.WebSettings r15 = r15.getSettings()
        com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView r0 = r14.f6699a
        int r1 = r14.f6704f
        java.lang.String r0 = com.bytedance.sdk.openadsdk.utils.JsBridgeUtils.m12206a(r0, r1)
        r15.setUserAgentString(r0)
        int r15 = android.os.Build.VERSION.SDK_INT
        r0 = 21
        if (r15 < r0) goto L_0x01c1
        com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView r15 = r14.f6699a
        android.webkit.WebSettings r15 = r15.getSettings()
        r15.setMixedContentMode(r7)
    L_0x01c1:
        com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView r15 = r14.f6699a
        java.lang.String r0 = r14.f6687K
        r15.loadUrl(r0)
        com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView r15 = r14.f6699a
        com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity$3 r0 = new com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity$3
        com.bytedance.sdk.openadsdk.core.x r1 = r14.f6707i
        com.bytedance.sdk.openadsdk.c.j r2 = r14.f6690N
        r0.m43353init(r1, r2)
        r15.setWebChromeClient(r0)
        com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView r15 = r14.f6699a
        com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity$4 r0 = new com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity$4
        r0.m43354init()
        r15.setDownloadListener(r0)
        android.widget.TextView r15 = r14.f6702d
        if (r15 == 0) goto L_0x01f3
        boolean r0 = android.text.TextUtils.isEmpty(r5)
        if (r0 == 0) goto L_0x01f0
        java.lang.String r0 = "tt_web_title_default"
        java.lang.String r5 = com.bytedance.sdk.openadsdk.utils.ResourceHelp.m11931a(r14, r0)
    L_0x01f0:
        r15.setText(r5)
    L_0x01f3:
        r14.mo14970a()
        r14.m8303f()
        r14.m8295c()
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.onCreate(android.os.Bundle):void");
    }

    /* renamed from: c */
    private void m8295c() {
        MaterialMeta kVar = this.f6714p;
        if (kVar != null && kVar.mo15414B() == 4) {
            this.f6724z.setVisibility(0);
            this.f6677A = (Button) findViewById(ResourceHelp.m11935e(this, "tt_browser_download_btn"));
            if (this.f6677A != null) {
                m8287a(m8297d());
                if (this.f6679C != null) {
                    if (TextUtils.isEmpty(this.f6683G)) {
                        ToolUtils.m11993a(this.f6708j);
                    } else {
                        String str = this.f6683G;
                    }
                    this.f6679C.mo16510a(this.f6694R, false);
                }
                this.f6677A.setOnClickListener(this.f6695S);
                this.f6677A.setOnTouchListener(this.f6695S);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public String m8297d() {
        MaterialMeta kVar = this.f6714p;
        if (kVar != null && !TextUtils.isEmpty(kVar.mo15424L())) {
            this.f6693Q = this.f6714p.mo15424L();
        }
        return this.f6693Q;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8287a(final String str) {
        if (!TextUtils.isEmpty(str)) {
            Button button = this.f6677A;
            if (button != null) {
                button.post(new Runnable() {
                    public void run() {
                        if (TTVideoLandingPageActivity.this.f6677A != null && !TTVideoLandingPageActivity.this.isFinishing()) {
                            TTVideoLandingPageActivity.this.f6677A.setText(str);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: e */
    private void m8301e() {
        this.f6678B = (ProgressBar) findViewById(ResourceHelp.m11935e(this, "tt_browser_progress"));
        this.f6724z = (ViewStub) findViewById(ResourceHelp.m11935e(this, "tt_browser_download_btn_stub"));
        this.f6699a = (SSWebView) findViewById(ResourceHelp.m11935e(this, "tt_browser_webview"));
        this.f6700b = (ImageView) findViewById(ResourceHelp.m11935e(this, "tt_titlebar_back"));
        ImageView imageView = this.f6700b;
        if (imageView != null) {
            imageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (TTVideoLandingPageActivity.this.f6699a == null) {
                        return;
                    }
                    if (TTVideoLandingPageActivity.this.f6699a.canGoBack()) {
                        TTVideoLandingPageActivity.this.f6699a.goBack();
                    } else if (TTVideoLandingPageActivity.this.m8320n()) {
                        TTVideoLandingPageActivity.this.onBackPressed();
                    } else {
                        Map map = null;
                        if (!(TTVideoLandingPageActivity.this.f6712n == null || TTVideoLandingPageActivity.this.f6712n.getNativeVideoController() == null)) {
                            map = ToolUtils.m11997a(TTVideoLandingPageActivity.this.f6714p, TTVideoLandingPageActivity.this.f6712n.getNativeVideoController().mo15990n(), TTVideoLandingPageActivity.this.f6712n.getNativeVideoController().mo15996t());
                        }
                        Map map2 = map;
                        TTVideoLandingPageActivity tTVideoLandingPageActivity = TTVideoLandingPageActivity.this;
                        AdEventManager.m8386a((Context) tTVideoLandingPageActivity, tTVideoLandingPageActivity.f6714p, "embeded_ad", "detail_back", TTVideoLandingPageActivity.this.m8305g(), TTVideoLandingPageActivity.this.m8307h(), map2);
                        TTVideoLandingPageActivity.this.finish();
                    }
                }
            });
        }
        this.f6701c = (ImageView) findViewById(ResourceHelp.m11935e(this, "tt_titlebar_close"));
        ImageView imageView2 = this.f6701c;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (TTVideoLandingPageActivity.this.f6712n != null) {
                        Map map = null;
                        if (TTVideoLandingPageActivity.this.f6712n.getNativeVideoController() != null) {
                            map = ToolUtils.m11997a(TTVideoLandingPageActivity.this.f6714p, TTVideoLandingPageActivity.this.f6712n.getNativeVideoController().mo15990n(), TTVideoLandingPageActivity.this.f6712n.getNativeVideoController().mo15996t());
                        }
                        Map map2 = map;
                        TTVideoLandingPageActivity tTVideoLandingPageActivity = TTVideoLandingPageActivity.this;
                        AdEventManager.m8386a((Context) tTVideoLandingPageActivity, tTVideoLandingPageActivity.f6714p, "embeded_ad", "detail_skip", TTVideoLandingPageActivity.this.m8305g(), TTVideoLandingPageActivity.this.m8307h(), map2);
                    }
                    TTVideoLandingPageActivity.this.finish();
                }
            });
        }
        this.f6702d = (TextView) findViewById(ResourceHelp.m11935e(this, "tt_titlebar_title"));
        this.f6710l = (FrameLayout) findViewById(ResourceHelp.m11935e(this, "tt_native_video_container"));
        this.f6709k = (RelativeLayout) findViewById(ResourceHelp.m11935e(this, "tt_native_video_titlebar"));
        this.f6719u = (RelativeLayout) findViewById(ResourceHelp.m11935e(this, "tt_rl_download"));
        this.f6720v = (TextView) findViewById(ResourceHelp.m11935e(this, "tt_video_btn_ad_image_tv"));
        this.f6722x = (TextView) findViewById(ResourceHelp.m11935e(this, "tt_video_ad_name"));
        this.f6723y = (TextView) findViewById(ResourceHelp.m11935e(this, "tt_video_ad_button"));
        this.f6721w = (RoundImageView) findViewById(ResourceHelp.m11935e(this, "tt_video_ad_logo_image"));
        m8310i();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m8295c();
    }

    /* renamed from: f */
    private void m8303f() {
        if (this.f6711m == 5) {
            try {
                this.f6712n = new NativeVideoTsView(this.f6703e, this.f6714p, true);
                if (this.f6712n.getNativeVideoController() != null) {
                    this.f6712n.getNativeVideoController().mo15972b(false);
                }
                if (this.f6684H) {
                    this.f6710l.setVisibility(0);
                    this.f6710l.removeAllViews();
                    this.f6710l.addView(this.f6712n);
                    this.f6712n.mo16095b(true);
                } else {
                    if (!this.f6686J) {
                        this.f6713o = 0;
                    }
                    if (!(this.f6689M == null || this.f6712n.getNativeVideoController() == null)) {
                        this.f6712n.getNativeVideoController().mo15966b(this.f6689M.f9086g);
                        this.f6712n.getNativeVideoController().mo15973c(this.f6689M.f9084e);
                    }
                    if (this.f6712n.mo16094a(this.f6713o, this.f6685I, this.f6684H)) {
                        this.f6710l.setVisibility(0);
                        this.f6710l.removeAllViews();
                        this.f6710l.addView(this.f6712n);
                    }
                    if (this.f6712n.getNativeVideoController() != null) {
                        this.f6712n.getNativeVideoController().mo15972b(false);
                        this.f6712n.getNativeVideoController().mo15961a(this.f6696T);
                        this.f6712n.setIsQuiet(false);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (C2566w.m12244c(this) == 0) {
                Toast.makeText(this, ResourceHelp.m11932b(this, "tt_no_network"), 0).show();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public long m8305g() {
        NativeVideoTsView nativeVideoTsView = this.f6712n;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0;
        }
        return this.f6712n.getNativeVideoController().mo15991o();
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public int m8307h() {
        NativeVideoTsView nativeVideoTsView = this.f6712n;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0;
        }
        return this.f6712n.getNativeVideoController().mo15993q();
    }

    /* renamed from: i */
    private void m8310i() {
        MaterialMeta kVar = this.f6714p;
        if (kVar != null && kVar.mo15414B() == 4) {
            UIUtils.m12059a((View) this.f6719u, 0);
            String str = !TextUtils.isEmpty(this.f6714p.mo15422J()) ? this.f6714p.mo15422J() : !TextUtils.isEmpty(this.f6714p.mo15423K()) ? this.f6714p.mo15423K() : !TextUtils.isEmpty(this.f6714p.mo15413A()) ? this.f6714p.mo15413A() : "";
            if (this.f6714p.mo15415C() != null && this.f6714p.mo15415C().mo15406a() != null) {
                UIUtils.m12059a((View) this.f6721w, 0);
                UIUtils.m12059a((View) this.f6720v, 4);
                TTNetClient.m11428a(this.f6703e).mo16653a(this.f6714p.mo15415C().mo15406a(), (ImageView) this.f6721w);
            } else if (!TextUtils.isEmpty(str)) {
                UIUtils.m12059a((View) this.f6721w, 4);
                UIUtils.m12059a((View) this.f6720v, 0);
                this.f6720v.setText(str.substring(0, 1));
            }
            if (!TextUtils.isEmpty(str)) {
                this.f6722x.setText(str);
            }
            UIUtils.m12059a((View) this.f6722x, 0);
            UIUtils.m12059a((View) this.f6723y, 0);
        }
    }

    /* renamed from: j */
    private void m8312j() {
        MaterialMeta kVar = this.f6714p;
        if (kVar != null && kVar.mo15414B() == 4) {
            this.f6679C = TTDownloadFactory.m11071a((Context) this, this.f6714p, this.f6683G);
            this.f6679C.mo16507a((Activity) this);
            this.f6695S = new ClickCreativeListener(this, this.f6714p, this.f6683G, this.f6708j);
            this.f6695S.mo15271a(false);
            this.f6723y.setOnClickListener(this.f6695S);
            this.f6723y.setOnTouchListener(this.f6695S);
            this.f6695S.mo15283a(this.f6679C);
        }
    }

    /* renamed from: k */
    private void m8314k() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f6714p);
        this.f6707i = new TTAndroidObject(this);
        this.f6707i.mo16398a((WebView) this.f6699a).mo16400a(this.f6714p).mo16408a((List<MaterialMeta>) arrayList).mo16407a(this.f6705g).mo16416b(this.f6706h).mo16397a(this.f6708j).mo16421c(ToolUtils.m12032g(this.f6714p));
    }

    public void onBackPressed() {
        if (this.f6681E) {
            NativeVideoTsView nativeVideoTsView = this.f6712n;
            if (!(nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null)) {
                ((IMediaCallback) this.f6712n.getNativeVideoController()).mo15979e(null, null);
                this.f6681E = false;
                return;
            }
        }
        if (!m8320n() || this.f6691O.getAndSet(true)) {
            super.onBackPressed();
            return;
        }
        m8288a(true);
        m8284a(0);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        MaterialMeta kVar = this.f6714p;
        bundle.putString("material_meta", kVar != null ? kVar.mo15459ae().toString() : null);
        String str = "video_play_position";
        bundle.putLong(str, this.f6713o);
        bundle.putBoolean("is_complete", this.f6684H);
        long j = this.f6713o;
        NativeVideoTsView nativeVideoTsView = this.f6712n;
        if (!(nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null)) {
            j = this.f6712n.getNativeVideoController().mo15989m();
        }
        bundle.putLong(str, j);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f6685I = false;
        TTAndroidObject xVar = this.f6707i;
        if (xVar != null) {
            xVar.mo16430g();
        }
        m8316l();
        ITTDownloadAdapter aVar = this.f6679C;
        if (aVar != null) {
            aVar.mo16513b();
        }
        Map<String, ITTDownloadAdapter> map = this.f6680D;
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    ((ITTDownloadAdapter) entry.getValue()).mo16513b();
                }
            }
        }
        LandingPageLog jVar = this.f6690N;
        if (jVar != null) {
            jVar.mo15019a();
        }
        m8322o();
    }

    /* renamed from: l */
    private void m8316l() {
        NativeVideoTsView nativeVideoTsView = this.f6712n;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            this.f6712n.setIsQuiet(false);
            SSMediaPlayerWrapper t = this.f6712n.getNativeVideoController().mo15996t();
            if (t != null && t.mo16069i()) {
                this.f6712n.mo16094a(this.f6713o, this.f6685I, this.f6684H);
            } else if ((t == null && this.f6697U) || (t != null && t.mo16070j())) {
                this.f6697U = false;
                this.f6712n.mo16094a(this.f6713o, this.f6685I, this.f6684H);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0054, code lost:
            if (r4.f6712n.getNativeVideoController().mo15998v() != false) goto L_0x0056;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    public void onPause() {
        /*
        r4 = this;
        super.onPause()
        com.bytedance.sdk.openadsdk.core.x r0 = r4.f6707i
        if (r0 == 0) goto L_0x000a
        r0.mo16433h()
    L_0x000a:
        r4.m8318m()
        com.bytedance.sdk.openadsdk.downloadnew.core.a r0 = r4.f6679C
        if (r0 == 0) goto L_0x0014
        r0.mo16516c()
    L_0x0014:
        java.util.Map<java.lang.String, com.bytedance.sdk.openadsdk.downloadnew.core.a> r0 = r4.f6680D
        if (r0 == 0) goto L_0x003c
        java.util.Set r0 = r0.entrySet()
        java.util.Iterator r0 = r0.iterator()
    L_0x0020:
        boolean r1 = r0.hasNext()
        if (r1 == 0) goto L_0x003c
        java.lang.Object r1 = r0.next()
        java.util.Map$Entry r1 = (java.util.Map.Entry) r1
        java.lang.Object r2 = r1.getValue()
        if (r2 == 0) goto L_0x0020
        java.lang.Object r1 = r1.getValue()
        com.bytedance.sdk.openadsdk.downloadnew.core.a r1 = (com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter) r1
        r1.mo16516c()
        goto L_0x0020
    L_0x003c:
        boolean r0 = r4.f6684H
        if (r0 != 0) goto L_0x0056
        com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView r0 = r4.f6712n
        if (r0 == 0) goto L_0x0076
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c r0 = r0.getNativeVideoController()
        if (r0 == 0) goto L_0x0076
        com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView r0 = r4.f6712n
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c r0 = r0.getNativeVideoController()
        boolean r0 = r0.mo15998v()
        if (r0 == 0) goto L_0x0076
    L_0x0056:
        r0 = 1
        r4.f6684H = r0
        java.lang.Boolean r1 = java.lang.Boolean.valueOf(r0)
        java.lang.String r2 = "sp_multi_native_video_data"
        java.lang.String r3 = "key_video_is_update_flag"
        com.bytedance.sdk.openadsdk.multipro.p205d.SPMultiHelper.m11870a(r2, r3, r1)
        java.lang.Boolean r1 = java.lang.Boolean.valueOf(r0)
        java.lang.String r3 = "key_native_video_complete"
        com.bytedance.sdk.openadsdk.multipro.p205d.SPMultiHelper.m11870a(r2, r3, r1)
        java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
        java.lang.String r1 = "key_video_isfromvideodetailpage"
        com.bytedance.sdk.openadsdk.multipro.p205d.SPMultiHelper.m11870a(r2, r1, r0)
    L_0x0076:
        boolean r0 = r4.f6684H
        if (r0 != 0) goto L_0x008d
        com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView r0 = r4.f6712n
        if (r0 == 0) goto L_0x008d
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c r0 = r0.getNativeVideoController()
        if (r0 == 0) goto L_0x008d
        com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView r0 = r4.f6712n
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c r0 = r0.getNativeVideoController()
        r4.m8286a(r0)
    L_0x008d:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.onPause():void");
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        LandingPageLog jVar = this.f6690N;
        if (jVar != null) {
            jVar.mo15027b();
        }
    }

    /* renamed from: a */
    private void m8286a(INativeVideoController cVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("initFeedNaitiveControllerData-isComplete=");
        sb.append(cVar.mo15998v());
        sb.append(",position=");
        sb.append(cVar.mo15989m());
        sb.append(",totalPlayDuration=");
        sb.append(cVar.mo15991o());
        sb.append(",duration=");
        sb.append(cVar.mo15994r());
        C2564t.m12226e("mutilproces", sb.toString());
        Boolean valueOf = Boolean.valueOf(true);
        String str = "sp_multi_native_video_data";
        SPMultiHelper.m11870a(str, "key_video_is_update_flag", valueOf);
        SPMultiHelper.m11870a(str, "key_video_isfromvideodetailpage", valueOf);
        SPMultiHelper.m11870a(str, "key_native_video_complete", Boolean.valueOf(cVar.mo15998v()));
        SPMultiHelper.m11873a(str, "key_video_current_play_position", Long.valueOf(cVar.mo15989m()));
        SPMultiHelper.m11873a(str, "key_video_total_play_duration", Long.valueOf(cVar.mo15991o()));
        SPMultiHelper.m11873a(str, "key_video_duration", Long.valueOf(cVar.mo15994r()));
    }

    /* renamed from: m */
    private void m8318m() {
        NativeVideoTsView nativeVideoTsView = this.f6712n;
        if (nativeVideoTsView != null) {
            SSMediaPlayerWrapper t = nativeVideoTsView.getNativeVideoController().mo15996t();
            if (t != null && t.mo16068h()) {
                this.f6697U = true;
                ((NativeVideoController) this.f6712n.getNativeVideoController()).mo16128e(this.f6712n.getNativeVideoController().mo15991o());
                this.f6712n.getNativeVideoController().mo15964a(false);
            } else if (t != null && !t.mo16072l()) {
                ((NativeVideoController) this.f6712n.getNativeVideoController()).mo16128e(this.f6712n.getNativeVideoController().mo15991o());
                this.f6712n.getNativeVideoController().mo15964a(false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        mo14971b();
        try {
            if (getWindow() != null) {
                ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                }
            }
        } catch (Throwable unused) {
        }
        WebViewTweaker.m9083a(this.f6703e, this.f6699a);
        WebViewTweaker.m9084a(this.f6699a);
        this.f6699a = null;
        ITTDownloadAdapter aVar = this.f6679C;
        if (aVar != null) {
            aVar.mo16518d();
        }
        Map<String, ITTDownloadAdapter> map = this.f6680D;
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    ((ITTDownloadAdapter) entry.getValue()).mo16518d();
                }
            }
            this.f6680D.clear();
        }
        TTAndroidObject xVar = this.f6707i;
        if (xVar != null) {
            xVar.mo16434i();
        }
        NativeVideoTsView nativeVideoTsView = this.f6712n;
        if (!(nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null)) {
            this.f6712n.getNativeVideoController().mo15988l();
        }
        this.f6712n = null;
        this.f6714p = null;
        LandingPageLog jVar = this.f6690N;
        if (jVar != null) {
            jVar.mo15028c();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo14970a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            this.f6703e.registerReceiver(this.f6698V, intentFilter);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo14971b() {
        try {
            this.f6703e.unregisterReceiver(this.f6698V);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public boolean m8320n() {
        return !TextUtils.isEmpty(this.f6687K) && this.f6687K.contains("__luban_sdk");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8284a(int i) {
        if (this.f6701c != null && m8320n()) {
            UIUtils.m12059a((View) this.f6701c, i);
        }
    }

    /* renamed from: a */
    private void m8288a(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isBackIntercept", z);
            this.f6707i.mo16412a("temai_back_event", jSONObject);
        } catch (Exception unused) {
        }
    }

    /* renamed from: o */
    private void m8322o() {
        if (this.f6714p != null) {
            JSONArray b = m8292b(this.f6687K);
            int d = ToolUtils.m12018d(this.f6706h);
            int c = ToolUtils.m12014c(this.f6706h);
            NetApi f = InternalContainer.m10067f();
            if (b != null && f != null && d > 0 && c > 0) {
                NetExtParams lVar = new NetExtParams();
                lVar.f7453d = b;
                AdSlot j = this.f6714p.mo15492j();
                if (j != null) {
                    j.setAdCount(6);
                    f.mo15917a(j, lVar, c, (C2287b) new C2287b() {
                        /* renamed from: a */
                        public void mo14946a(int i, String str) {
                            TTVideoLandingPageActivity.this.m8284a(0);
                        }

                        /* renamed from: a */
                        public void mo14947a(AdInfo aVar) {
                            if (aVar != null) {
                                try {
                                    TTVideoLandingPageActivity.this.f6691O.set(false);
                                    TTVideoLandingPageActivity.this.f6707i.mo16417b(new JSONObject(aVar.mo15338d()));
                                } catch (Exception unused) {
                                    TTVideoLandingPageActivity.this.m8284a(0);
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    /* renamed from: b */
    private JSONArray m8292b(String str) {
        JSONArray jSONArray = this.f6692P;
        if (jSONArray != null && jSONArray.length() > 0) {
            return this.f6692P;
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

    /* renamed from: a */
    public void mo14934a(boolean z, JSONArray jSONArray) {
        if (z && jSONArray != null && jSONArray.length() > 0) {
            this.f6692P = jSONArray;
            m8322o();
        }
    }
}
