package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd.DrawVideoListener;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.SingleAppData;
import com.bytedance.sdk.openadsdk.core.VisibilityChecker;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.IMediaLayout.C2323a;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.INativeVideoController.C2324a;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.INativeVideoController.C2326c;
import com.bytedance.sdk.openadsdk.core.video.p175a.VideoAdModel;
import com.bytedance.sdk.openadsdk.core.video.p177c.SSMediaPlayerWrapper;
import com.bytedance.sdk.openadsdk.core.video.p178d.MediaHelper;
import com.bytedance.sdk.openadsdk.core.video.renderview.IRenderView;
import com.bytedance.sdk.openadsdk.core.widget.VideoTrafficTipLayout.C2365a;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.multipro.p205d.SPMultiHelper;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.utils.C2538ak;
import com.bytedance.sdk.openadsdk.utils.C2538ak.C2539a;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.mid.sotrage.StorageInterface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.core.video.nativevideo.f */
public class NativeVideoController implements INativeVideoController, INewMediaCallback, C2539a {
    /* renamed from: A */
    private boolean f8068A;
    /* renamed from: B */
    private boolean f8069B;
    /* renamed from: C */
    private WeakReference<C2326c> f8070C;
    /* renamed from: D */
    private WeakReference<C2334a> f8071D;
    /* renamed from: E */
    private int f8072E;
    /* renamed from: F */
    private int f8073F;
    /* renamed from: G */
    private int f8074G;
    /* renamed from: H */
    private boolean f8075H;
    /* renamed from: I */
    private boolean f8076I;
    /* access modifiers changed from: private|final */
    /* renamed from: J */
    public final Runnable f8077J;
    /* renamed from: K */
    private final Runnable f8078K;
    /* renamed from: L */
    private final Runnable f8079L;
    /* renamed from: M */
    private int f8080M;
    /* renamed from: N */
    private long f8081N;
    /* renamed from: O */
    private long f8082O;
    /* renamed from: P */
    private long f8083P;
    /* renamed from: Q */
    private boolean f8084Q;
    /* renamed from: R */
    private long f8085R;
    /* renamed from: S */
    private final BroadcastReceiver f8086S;
    /* renamed from: T */
    private int f8087T;
    /* renamed from: U */
    private boolean f8088U;
    /* renamed from: a */
    Runnable f8089a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public NativeVideoLayout f8090b;
    /* renamed from: c */
    private final WeakReference<ViewGroup> f8091c;
    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final C2538ak f8092d = new C2538ak(this);
    /* access modifiers changed from: private */
    /* renamed from: e */
    public long f8093e = 0;
    /* renamed from: f */
    private long f8094f = 0;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public SSMediaPlayerWrapper f8095g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public C2324a f8096h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public long f8097i = 0;
    /* renamed from: j */
    private long f8098j = 0;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public long f8099k;
    /* renamed from: l */
    private List<Runnable> f8100l;
    /* renamed from: m */
    private boolean f8101m;
    /* access modifiers changed from: private|final */
    /* renamed from: n */
    public final WeakReference<Context> f8102n;
    /* renamed from: o */
    private final boolean f8103o;
    /* renamed from: p */
    private boolean f8104p;
    /* renamed from: q */
    private boolean f8105q;
    /* access modifiers changed from: private|final */
    /* renamed from: r */
    public final MaterialMeta f8106r;
    /* renamed from: s */
    private boolean f8107s;
    /* access modifiers changed from: private */
    /* renamed from: t */
    public boolean f8108t;
    /* renamed from: u */
    private String f8109u;
    /* renamed from: v */
    private WeakReference<IVideoFullscreen> f8110v;
    /* renamed from: w */
    private long f8111w;
    /* renamed from: x */
    private boolean f8112x;
    /* renamed from: y */
    private boolean f8113y;
    /* renamed from: z */
    private boolean f8114z;

    /* compiled from: NativeVideoController */
    /* renamed from: com.bytedance.sdk.openadsdk.core.video.nativevideo.f$7 */
    static /* synthetic */ class C23337 {
        /* renamed from: a */
        static final /* synthetic */ int[] f8121a = new int[C2365a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
            com.bytedance.sdk.openadsdk.core.widget.e$a[] r0 = com.bytedance.sdk.openadsdk.core.widget.VideoTrafficTipLayout.C2365a.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f8121a = r0
            int[] r0 = f8121a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.bytedance.sdk.openadsdk.core.widget.e$a r1 = com.bytedance.sdk.openadsdk.core.widget.VideoTrafficTipLayout.C2365a.PAUSE_VIDEO     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f8121a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.bytedance.sdk.openadsdk.core.widget.e$a r1 = com.bytedance.sdk.openadsdk.core.widget.VideoTrafficTipLayout.C2365a.RELEASE_VIDEO     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f8121a     // Catch:{ NoSuchFieldError -> 0x002a }
            com.bytedance.sdk.openadsdk.core.widget.e$a r1 = com.bytedance.sdk.openadsdk.core.widget.VideoTrafficTipLayout.C2365a.START_VIDEO     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoController.C23337.m43850clinit():void");
        }
    }

    /* compiled from: NativeVideoController */
    /* renamed from: com.bytedance.sdk.openadsdk.core.video.nativevideo.f$a */
    public interface C2334a {
        /* renamed from: a */
        void mo16093a(int i);

        /* renamed from: e */
        void mo16096e();
    }

    /* renamed from: a */
    public void mo15955a(IMediaLayout bVar, SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    /* renamed from: a */
    public void mo15963a(Map<String, Object> map) {
    }

    /* renamed from: f */
    public void mo15981f(IMediaLayout bVar, View view) {
    }

    /* renamed from: p */
    public long mo15992p() {
        return 0;
    }

    /* renamed from: a */
    public void mo16119a(DrawVideoListener drawVideoListener) {
        NativeVideoLayout hVar = this.f8090b;
        if (hVar != null) {
            hVar.mo16182a(drawVideoListener);
        }
    }

    /* renamed from: a */
    public void mo16117a(int i, int i2) {
        if (i != 0 && i2 != 0) {
            this.f8072E = i;
            this.f8073F = i2;
            StringBuilder sb = new StringBuilder();
            sb.append("width=");
            sb.append(i);
            sb.append("height=");
            sb.append(i2);
            C2564t.m12220b("NativeVideoController", sb.toString());
        }
    }

    /* renamed from: z */
    private boolean m10548z() {
        StringBuilder sb = new StringBuilder();
        sb.append("retryCount=");
        sb.append(this.f8074G);
        String str = "NativeVideoController";
        C2564t.m12220b(str, sb.toString());
        int i = this.f8074G;
        boolean z = true;
        if (1 <= i) {
            NativeVideoLayout hVar = this.f8090b;
            if (hVar != null) {
                hVar.mo16205w();
                this.f8090b.mo16147a(this.f8106r, this.f8102n, false);
            }
            return false;
        } else if (this.f8095g == null) {
            return false;
        } else {
            this.f8074G = i + 1;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("isPlaying=");
            sb2.append(this.f8095g.mo16067g());
            sb2.append(",isPaused=");
            sb2.append(this.f8095g.mo16069i());
            sb2.append(",isPrepared=");
            sb2.append(this.f8095g.mo16071k());
            sb2.append(",isStarted=");
            sb2.append(this.f8095g.mo16068h());
            C2564t.m12220b(str, sb2.toString());
            if (this.f8095g.mo16067g() && this.f8095g.mo16069i() && this.f8095g.mo16071k() && this.f8095g.mo16068h()) {
                z = false;
            }
            return z;
        }
    }

    /* renamed from: b */
    private void m10531b(Context context) {
        View view;
        EnumSet noneOf = EnumSet.noneOf(C2323a.class);
        noneOf.add(C2323a.hideCloseBtn);
        noneOf.add(C2323a.hideBackBtn);
        if (this.f8107s) {
            view = m10534c(context);
        } else {
            view = LayoutInflater.from(context.getApplicationContext()).inflate(ResourceHelp.m11936f(context, "tt_video_detail_layout"), null, false);
        }
        View view2 = view;
        if (view2 != null) {
            if (this.f8107s) {
                NativeVideoLayout hVar = new NativeVideoLayout(context, view2, true, noneOf, this.f8106r, this, mo16122a());
                this.f8090b = hVar;
            } else {
                NativeVideoDetailLayout gVar = new NativeVideoDetailLayout(context, view2, true, noneOf, this.f8106r, this, false);
                this.f8090b = gVar;
            }
            this.f8090b.mo16183a((IMediaCallback) this);
        }
    }

    /* renamed from: c */
    private View m10534c(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(ResourceHelp.m11935e(context, "tt_root_view"));
        relativeLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        relativeLayout2.setId(ResourceHelp.m11935e(context, "tt_video_loading_retry_layout"));
        relativeLayout2.setBackgroundColor(0);
        relativeLayout2.setGravity(17);
        relativeLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(relativeLayout2);
        ImageView imageView = new ImageView(context);
        LayoutParams layoutParams2 = new LayoutParams(-1, -1);
        imageView.setId(ResourceHelp.m11935e(context, "tt_video_loading_cover_image"));
        imageView.setScaleType(ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams2);
        relativeLayout2.addView(imageView);
        ProgressBar progressBar = new ProgressBar(context);
        LayoutParams layoutParams3 = new LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        progressBar.setId(ResourceHelp.m11935e(context, "tt_video_loading_progress"));
        layoutParams3.addRule(13, -1);
        progressBar.setLayoutParams(layoutParams3);
        progressBar.setIndeterminateDrawable(ResourceHelp.m11933c(context, "tt_video_loading_progress_bar"));
        relativeLayout2.addView(progressBar);
        ImageView imageView2 = new ImageView(context);
        LayoutParams layoutParams4 = new LayoutParams(-2, -2);
        imageView2.setId(ResourceHelp.m11935e(context, "tt_video_play"));
        layoutParams4.addRule(13, -1);
        imageView2.setScaleType(ScaleType.CENTER);
        imageView2.setImageResource(ResourceHelp.m11934d(context, "tt_play_movebar_textpage"));
        imageView2.setVisibility(8);
        imageView2.setLayoutParams(layoutParams4);
        relativeLayout.addView(imageView2);
        ProgressBar progressBar2 = new ProgressBar(context, null, ResourceHelp.m11937g(context, "tt_Widget_ProgressBar_Horizontal"));
        LayoutParams layoutParams5 = new LayoutParams(-1, (int) TypedValue.applyDimension(1, 1.5f, resources.getDisplayMetrics()));
        progressBar2.setMax(100);
        progressBar2.setId(ResourceHelp.m11935e(context, "tt_video_progress"));
        progressBar2.setBackgroundColor(0);
        progressBar2.setIndeterminateDrawable(null);
        progressBar2.setProgressDrawable(ResourceHelp.m11933c(context, "tt_video_progress_drawable"));
        progressBar2.setVisibility(8);
        layoutParams5.addRule(12, -1);
        progressBar2.setLayoutParams(layoutParams5);
        relativeLayout.addView(progressBar2);
        ViewStub viewStub = new ViewStub(context);
        LayoutParams layoutParams6 = new LayoutParams(-1, -1);
        viewStub.setId(ResourceHelp.m11935e(context, "tt_video_ad_cover"));
        viewStub.setLayoutParams(layoutParams6);
        viewStub.setLayoutResource(ResourceHelp.m11936f(context, "tt_video_ad_cover_layout"));
        relativeLayout.addView(viewStub);
        ViewStub viewStub2 = new ViewStub(context);
        LayoutParams layoutParams7 = new LayoutParams(-2, -2);
        layoutParams7.addRule(13, -1);
        viewStub2.setId(ResourceHelp.m11935e(context, "tt_video_draw_layout_viewStub"));
        viewStub2.setLayoutParams(layoutParams7);
        viewStub2.setLayoutResource(ResourceHelp.m11936f(context, "tt_video_draw_btn_layout"));
        relativeLayout.addView(viewStub2);
        return relativeLayout;
    }

    public NativeVideoController(Context context, ViewGroup viewGroup, MaterialMeta kVar, String str, boolean z) {
        boolean z2 = false;
        this.f8104p = false;
        this.f8105q = false;
        this.f8107s = true;
        this.f8108t = false;
        this.f8109u = "embeded_ad";
        this.f8111w = 0;
        this.f8112x = false;
        this.f8113y = false;
        this.f8114z = false;
        this.f8068A = false;
        this.f8069B = true;
        this.f8072E = 0;
        this.f8073F = 0;
        this.f8074G = 0;
        this.f8075H = false;
        this.f8076I = true;
        this.f8077J = new Runnable() {
            public void run() {
                if (NativeVideoController.this.f8095g != null) {
                    NativeVideoController.this.f8095g.mo16065e();
                }
            }
        };
        this.f8078K = new Runnable() {
            public void run() {
                if (NativeVideoController.this.f8096h != null) {
                    NativeVideoController.this.f8096h.mo14911a();
                }
            }
        };
        this.f8079L = new Runnable() {
            public void run() {
                if (NativeVideoController.this.f8095g != null) {
                    if (NativeVideoController.this.f8099k <= 0) {
                        NativeVideoController.this.f8095g.mo16065e();
                    }
                    NativeVideoController.this.f8095g.mo16066f();
                }
                NativeVideoController.this.f8092d.postDelayed(this, 200);
            }
        };
        this.f8080M = 0;
        this.f8081N = 0;
        this.f8089a = new Runnable() {
            public void run() {
                if (NativeVideoController.this.f8090b != null) {
                    NativeVideoController.this.f8090b.mo16147a(NativeVideoController.this.f8106r, NativeVideoController.this.f8102n, false);
                    NativeVideoController.this.f8090b.mo16205w();
                    NativeVideoController.this.mo15978d(true);
                    C2564t.m12226e("NativeVideoController", "出错后展示结果页、、、、、、、showAdCard");
                }
            }
        };
        this.f8082O = 0;
        this.f8083P = 0;
        this.f8084Q = false;
        this.f8086S = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    NativeVideoController.this.mo15984h();
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    NativeVideoController.this.m10537d(context);
                }
            }
        };
        this.f8087T = 1;
        this.f8088U = false;
        this.f8087T = C2566w.m12244c(context);
        mo15972b(z);
        this.f8109u = str;
        try {
            this.f8072E = viewGroup.getWidth();
            this.f8073F = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.f8091c = new WeakReference<>(viewGroup);
        this.f8102n = new WeakReference<>(context);
        this.f8106r = kVar;
        m10531b(context);
        if (VERSION.SDK_INT >= 17) {
            z2 = true;
        }
        this.f8103o = z2;
    }

    public NativeVideoController(Context context, ViewGroup viewGroup, MaterialMeta kVar, String str) {
        boolean z = false;
        this.f8104p = false;
        this.f8105q = false;
        this.f8107s = true;
        this.f8108t = false;
        this.f8109u = "embeded_ad";
        this.f8111w = 0;
        this.f8112x = false;
        this.f8113y = false;
        this.f8114z = false;
        this.f8068A = false;
        this.f8069B = true;
        this.f8072E = 0;
        this.f8073F = 0;
        this.f8074G = 0;
        this.f8075H = false;
        this.f8076I = true;
        this.f8077J = new Runnable() {
            public void run() {
                if (NativeVideoController.this.f8095g != null) {
                    NativeVideoController.this.f8095g.mo16065e();
                }
            }
        };
        this.f8078K = new Runnable() {
            public void run() {
                if (NativeVideoController.this.f8096h != null) {
                    NativeVideoController.this.f8096h.mo14911a();
                }
            }
        };
        this.f8079L = new Runnable() {
            public void run() {
                if (NativeVideoController.this.f8095g != null) {
                    if (NativeVideoController.this.f8099k <= 0) {
                        NativeVideoController.this.f8095g.mo16065e();
                    }
                    NativeVideoController.this.f8095g.mo16066f();
                }
                NativeVideoController.this.f8092d.postDelayed(this, 200);
            }
        };
        this.f8080M = 0;
        this.f8081N = 0;
        this.f8089a = new Runnable() {
            public void run() {
                if (NativeVideoController.this.f8090b != null) {
                    NativeVideoController.this.f8090b.mo16147a(NativeVideoController.this.f8106r, NativeVideoController.this.f8102n, false);
                    NativeVideoController.this.f8090b.mo16205w();
                    NativeVideoController.this.mo15978d(true);
                    C2564t.m12226e("NativeVideoController", "出错后展示结果页、、、、、、、showAdCard");
                }
            }
        };
        this.f8082O = 0;
        this.f8083P = 0;
        this.f8084Q = false;
        this.f8086S = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    NativeVideoController.this.mo15984h();
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    NativeVideoController.this.m10537d(context);
                }
            }
        };
        this.f8087T = 1;
        this.f8088U = false;
        this.f8087T = C2566w.m12244c(context);
        try {
            this.f8072E = viewGroup.getWidth();
            this.f8073F = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.f8091c = new WeakReference<>(viewGroup);
        this.f8109u = str;
        this.f8102n = new WeakReference<>(context);
        this.f8106r = kVar;
        m10531b(context);
        if (VERSION.SDK_INT >= 17) {
            z = true;
        }
        this.f8103o = z;
    }

    /* renamed from: u */
    public NativeVideoLayout mo15997u() {
        return this.f8090b;
    }

    /* renamed from: a */
    public void mo15960a(C2326c cVar) {
        this.f8070C = new WeakReference<>(cVar);
    }

    /* renamed from: a */
    public boolean mo15965a(String str, String str2, int i, int i2, List<String> list, String str3, long j, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("[video] start NativeVideoController#playVideoUrl and video url is :\r\n");
        sb.append(str);
        String str4 = "tag_video_play";
        C2564t.m12220b(str4, sb.toString());
        if (TextUtils.isEmpty(str)) {
            C2564t.m12226e(str4, "[video] play video stop , because no video info");
            return false;
        }
        this.f8108t = z;
        this.f8097i = j;
        int i3 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i3 <= 0) {
            this.f8105q = false;
            this.f8104p = false;
        }
        if (i3 > 0) {
            this.f8097i = j;
            long j2 = this.f8098j;
            long j3 = this.f8097i;
            if (j2 <= j3) {
                j2 = j3;
            }
            this.f8098j = j2;
        }
        NativeVideoLayout hVar = this.f8090b;
        if (hVar != null) {
            hVar.mo16159e();
            if (this.f8080M == 0) {
                this.f8090b.mo16158d();
            }
            this.f8090b.mo16191c(i, i2);
            this.f8090b.mo16192c((ViewGroup) this.f8091c.get());
            this.f8090b.mo16177a(i, i2);
        }
        if (this.f8095g == null) {
            this.f8095g = new SSMediaPlayerWrapper(this.f8092d);
        }
        C2564t.m12220b(str4, "[video] new MediaPlayer");
        this.f8094f = 0;
        try {
            m10527a(str);
            return true;
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[video] invoke NativeVideoController#playVideo cause exception :");
            sb2.append(e.toString());
            C2564t.m12226e(str4, sb2.toString());
            return false;
        }
    }

    /* renamed from: t */
    public SSMediaPlayerWrapper mo15996t() {
        return this.f8095g;
    }

    /* renamed from: m */
    public long mo15989m() {
        return this.f8097i;
    }

    /* renamed from: a */
    public void mo15950a(long j) {
        this.f8097i = j;
        long j2 = this.f8098j;
        long j3 = this.f8097i;
        if (j2 <= j3) {
            j2 = j3;
        }
        this.f8098j = j2;
    }

    /* renamed from: b */
    public void mo15972b(boolean z) {
        this.f8107s = z;
        NativeVideoLayout hVar = this.f8090b;
        if (hVar != null) {
            hVar.mo16193c(z);
        }
    }

    /* renamed from: a */
    public boolean mo16122a() {
        return this.f8107s;
    }

    /* renamed from: s */
    public boolean mo15995s() {
        return this.f8112x;
    }

    /* renamed from: b */
    public void mo15966b(long j) {
        this.f8111w = j;
    }

    /* renamed from: r */
    public long mo15994r() {
        return this.f8099k;
    }

    /* renamed from: c */
    public void mo15973c(long j) {
        this.f8099k = j;
    }

    /* renamed from: o */
    public long mo15991o() {
        SSMediaPlayerWrapper dVar = this.f8095g;
        if (dVar == null) {
            return 0;
        }
        return dVar.mo16075o() + this.f8111w;
    }

    /* renamed from: b */
    public boolean mo16124b() {
        return this.f8108t;
    }

    /* renamed from: c */
    public void mo15975c(boolean z) {
        this.f8108t = z;
        SSMediaPlayerWrapper dVar = this.f8095g;
        if (dVar != null) {
            dVar.mo16060a(z);
        }
    }

    /* renamed from: v */
    public boolean mo15998v() {
        return this.f8114z;
    }

    /* renamed from: q */
    public int mo15993q() {
        return MediaHelper.m10402a(this.f8098j, this.f8099k);
    }

    /* renamed from: a */
    private void m10527a(String str) {
        String str2 = "tag_video_play";
        C2564t.m12220b(str2, "[video] NativeVideoController#playVideo has invoke !");
        if (this.f8095g != null) {
            VideoAdModel aVar = new VideoAdModel();
            aVar.f7928a = str;
            MaterialMeta kVar = this.f8106r;
            if (kVar != null) {
                if (kVar.mo15512z() != null) {
                    aVar.f7931d = this.f8106r.mo15512z().mo15606j();
                }
                aVar.f7929b = String.valueOf(ToolUtils.m12018d(this.f8106r.mo15428P()));
            }
            aVar.f7930c = 0;
            this.f8095g.mo16059a(aVar);
            C2564t.m12220b(str2, "[video] MediaPlayerProxy has setDataSource !");
        }
        this.f8093e = System.currentTimeMillis();
        if (!TextUtils.isEmpty(str)) {
            this.f8090b.mo16194d(8);
            this.f8090b.mo16194d(0);
            m10526a((Runnable) new Runnable() {
                public void run() {
                    NativeVideoController.this.f8093e = System.currentTimeMillis();
                    NativeVideoController.this.f8090b.mo16157c(0);
                    if (NativeVideoController.this.f8095g != null && NativeVideoController.this.f8097i == 0) {
                        NativeVideoController.this.f8095g.mo16061a(true, 0, !NativeVideoController.this.f8108t);
                    } else if (NativeVideoController.this.f8095g != null) {
                        NativeVideoController.this.f8095g.mo16061a(true, NativeVideoController.this.f8097i, !NativeVideoController.this.f8108t);
                    }
                    if (NativeVideoController.this.f8092d != null) {
                        NativeVideoController.this.f8092d.postDelayed(NativeVideoController.this.f8077J, 100);
                    }
                    NativeVideoController.this.m10508A();
                }
            });
        }
        if (this.f8107s) {
            mo16132x();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: A */
    public void m10508A() {
        m10509B();
        this.f8092d.postDelayed(this.f8079L, 800);
    }

    /* renamed from: B */
    private void m10509B() {
        this.f8092d.removeCallbacks(this.f8079L);
    }

    /* renamed from: a */
    public void mo15961a(IVideoFullscreen eVar) {
        this.f8110v = new WeakReference<>(eVar);
    }

    /* renamed from: n */
    public long mo15990n() {
        if (mo15996t() == null) {
            return 0;
        }
        return mo15996t().mo16074n();
    }

    /* renamed from: b */
    private void m10529b(int i) {
        this.f8080M++;
        if (m10510C()) {
            NativeVideoLayout hVar = this.f8090b;
            if (hVar != null) {
                hVar.mo16205w();
                C2324a aVar = this.f8096h;
                if (aVar != null) {
                    aVar.mo14912a(this.f8094f, MediaHelper.m10402a(this.f8097i, this.f8099k));
                }
                this.f8094f = System.currentTimeMillis() - this.f8093e;
                if (!ToolUtils.m12006a(this.f8106r) || this.f8080M >= 2) {
                    this.f8090b.mo16147a(this.f8106r, this.f8102n, true);
                }
                if (!this.f8105q) {
                    AdEventManager.m8386a((Context) this.f8102n.get(), this.f8106r, this.f8109u, "feed_over", mo15991o(), 100, mo16125c());
                    this.f8105q = true;
                    long j = this.f8099k;
                    m10522a(j, j);
                    long j2 = this.f8099k;
                    this.f8097i = j2;
                    this.f8098j = j2;
                }
                if (!this.f8107s && this.f8084Q) {
                    mo15979e(this.f8090b, null);
                }
                this.f8114z = true;
                if (ToolUtils.m12006a(this.f8106r) && this.f8080M < 2) {
                    mo15983g();
                }
            }
        }
    }

    /* renamed from: C */
    private boolean m10510C() {
        WeakReference<Context> weakReference = this.f8102n;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    /* renamed from: a */
    private void m10526a(Runnable runnable) {
        if (runnable != null) {
            if (!this.f8090b.mo16165k() || !this.f8101m) {
                m10532b(runnable);
            } else {
                runnable.run();
            }
        }
    }

    /* renamed from: b */
    private void m10532b(Runnable runnable) {
        if (this.f8100l == null) {
            this.f8100l = Collections.synchronizedList(new ArrayList());
        }
        this.f8100l.add(runnable);
    }

    /* renamed from: D */
    private void m10511D() {
        List<Runnable> list = this.f8100l;
        if (list != null && !list.isEmpty()) {
            Iterator it = new ArrayList(this.f8100l).iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            this.f8100l.clear();
        }
    }

    /* renamed from: a */
    public void mo15959a(C2324a aVar) {
        this.f8096h = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public Map<String, Object> mo16125c() {
        return ToolUtils.m11997a(this.f8106r, mo15990n(), mo15996t());
    }

    /* renamed from: h */
    public void mo15984h() {
        SSMediaPlayerWrapper dVar = this.f8095g;
        if (dVar != null) {
            dVar.mo16062b();
        }
        if (!this.f8105q && this.f8104p) {
            if (MultiGlobalInfo.m11808b()) {
                String str = "IsCanLoadPauseLog";
                String str2 = "sp_multi_single_app_data_class";
                if (SPMultiHelper.m11877a(str2, str, true)) {
                    AdEventManager.m8386a((Context) this.f8102n.get(), this.f8106r, this.f8109u, "feed_pause", mo15991o(), mo15993q(), mo16125c());
                }
                SPMultiHelper.m11870a(str2, str, Boolean.valueOf(true));
                return;
            }
            if (SingleAppData.m10160a().mo15936b()) {
                AdEventManager.m8386a((Context) this.f8102n.get(), this.f8106r, this.f8109u, "feed_pause", mo15991o(), mo15993q(), mo16125c());
            }
            SingleAppData.m10160a().mo15934a(true);
        }
    }

    /* renamed from: d */
    public void mo16126d() {
        SSMediaPlayerWrapper dVar = this.f8095g;
        if (dVar != null) {
            dVar.mo16062b();
        }
    }

    /* renamed from: i */
    public void mo15985i() {
        SSMediaPlayerWrapper dVar = this.f8095g;
        if (dVar != null) {
            dVar.mo16064d();
        }
    }

    /* renamed from: j */
    public void mo15986j() {
        NativeVideoLayout hVar = this.f8090b;
        if (hVar != null) {
            hVar.mo16159e();
        }
        NativeVideoLayout hVar2 = this.f8090b;
        if (hVar2 != null) {
            hVar2.mo16203u();
        }
        m10512E();
    }

    /* renamed from: g */
    public void mo16131g(boolean z) {
        NativeVideoLayout hVar = this.f8090b;
        if (hVar != null) {
            hVar.mo16159e();
        }
        NativeVideoLayout hVar2 = this.f8090b;
        if (hVar2 != null && z) {
            hVar2.mo16203u();
        }
        m10512E();
    }

    /* renamed from: E */
    private void m10512E() {
        SSMediaPlayerWrapper dVar = this.f8095g;
        if (dVar != null) {
            dVar.mo16061a(false, this.f8097i, !this.f8108t);
            m10508A();
        }
        if (this.f8104p) {
            AdEventManager.m8386a((Context) this.f8102n.get(), this.f8106r, this.f8109u, "feed_continue", mo15991o(), mo15993q(), mo16125c());
        }
    }

    /* renamed from: d */
    public void mo16127d(long j) {
        this.f8097i = j;
        long j2 = this.f8098j;
        long j3 = this.f8097i;
        if (j2 <= j3) {
            j2 = j3;
        }
        this.f8098j = j2;
        NativeVideoLayout hVar = this.f8090b;
        if (hVar != null) {
            hVar.mo16159e();
        }
        SSMediaPlayerWrapper dVar = this.f8095g;
        if (dVar != null) {
            dVar.mo16061a(true, this.f8097i, !this.f8108t);
            m10508A();
        }
    }

    /* renamed from: k */
    public void mo15987k() {
        mo15964a(true);
    }

    /* renamed from: e */
    public void mo16128e(long j) {
        this.f8081N = j;
    }

    /* renamed from: a */
    public void mo15964a(boolean z) {
        if (this.f8107s) {
            this.f8081N = mo15991o();
        }
        if (!this.f8105q && this.f8104p) {
            if (z) {
                AdEventManager.m8386a((Context) this.f8102n.get(), this.f8106r, this.f8109u, "feed_break", this.f8081N, mo15993q(), mo16125c());
                this.f8105q = false;
            } else {
                AdEventManager.m8386a((Context) this.f8102n.get(), this.f8106r, this.f8109u, "feed_pause", this.f8081N, mo15993q(), mo16125c());
            }
        }
        mo15988l();
    }

    /* renamed from: l */
    public void mo15988l() {
        SSMediaPlayerWrapper dVar = this.f8095g;
        if (dVar != null) {
            dVar.mo16063c();
            this.f8095g = null;
        }
        if (!ToolUtils.m12006a(this.f8106r) || this.f8080M == 2) {
            this.f8090b.mo16147a(this.f8106r, this.f8102n, true);
        }
        C2538ak akVar = this.f8092d;
        if (akVar != null) {
            akVar.removeCallbacks(this.f8079L);
            this.f8092d.removeCallbacks(this.f8078K);
            this.f8092d.removeCallbacks(this.f8077J);
            this.f8092d.removeCallbacksAndMessages(null);
        }
        m10509B();
        List<Runnable> list = this.f8100l;
        if (list != null) {
            list.clear();
        }
        if (this.f8107s) {
            mo16133y();
        }
    }

    /* renamed from: F */
    private void m10513F() {
        this.f8083P = SystemClock.elapsedRealtime() - this.f8082O;
        if (!this.f8104p) {
            Map a = ToolUtils.m11995a(this.f8083P, this.f8106r, mo15996t());
            if (this.f8069B) {
                AdEventManager.m8411j((Context) this.f8102n.get(), this.f8106r, this.f8109u, "feed_auto_play", a);
            } else if (this.f8097i <= 0) {
                AdEventManager.m8411j((Context) this.f8102n.get(), this.f8106r, this.f8109u, "feed_play", a);
            }
            this.f8104p = true;
        }
    }

    /* renamed from: a */
    public void mo14813a(Message message) {
        if (!(this.f8090b == null || message == null)) {
            WeakReference<Context> weakReference = this.f8102n;
            if (!(weakReference == null || weakReference.get() == null)) {
                int i = message.what;
                if (i != 108) {
                    if (i != 109) {
                        String str = "NativeVideoController";
                        if (i == 308) {
                            C2564t.m12226e(str, "播放器状态出错 STAT_ERROR 200 、、、、、、、");
                            m10514G();
                            m10530b((int) TinkerReport.KEY_LOADED_MISSING_RES, 0);
                        } else if (i != 309) {
                            switch (i) {
                                case 302:
                                    m10529b(message.what);
                                    break;
                                case 303:
                                    int i2 = message.arg1;
                                    int i3 = message.arg2;
                                    m10530b(i2, i3);
                                    C2564t.m12226e(str, "CALLBACK_ON_ERROR、、before isVideoPlaying、、、、、");
                                    if (!mo16130f() || i3 == -1004) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("出错后 errorcode,extra、、、、、、、");
                                        sb.append(i2);
                                        sb.append(StorageInterface.KEY_SPLITER);
                                        sb.append(i3);
                                        C2564t.m12226e(str, sb.toString());
                                        if (m10536c(i2, i3)) {
                                            C2564t.m12226e(str, "出错后展示结果页、、、、、、、");
                                            this.f8090b.mo16147a(this.f8106r, this.f8102n, false);
                                            mo15978d(true);
                                            mo15988l();
                                        }
                                        NativeVideoLayout hVar = this.f8090b;
                                        if (hVar != null) {
                                            hVar.mo16205w();
                                        }
                                        C2324a aVar = this.f8096h;
                                        if (aVar != null) {
                                            aVar.mo14914b(this.f8094f, MediaHelper.m10402a(this.f8097i, this.f8099k));
                                        }
                                        WeakReference<C2326c> weakReference2 = this.f8070C;
                                        if (!(weakReference2 == null || weakReference2.get() == null || mo16130f())) {
                                            ((C2326c) this.f8070C.get()).mo15045a(i2, i3);
                                            break;
                                        }
                                    } else {
                                        return;
                                    }
                                    break;
                                case 304:
                                    int i4 = message.arg1;
                                    NativeVideoLayout hVar2 = this.f8090b;
                                    if (hVar2 != null) {
                                        if (i4 == 3 || i4 == 702) {
                                            this.f8090b.mo16205w();
                                            this.f8092d.removeCallbacks(this.f8089a);
                                            this.f8075H = false;
                                        } else if (i4 == 701) {
                                            hVar2.mo16202t();
                                            this.f8092d.postDelayed(this.f8089a, 8000);
                                            this.f8075H = true;
                                        }
                                    }
                                    if (this.f8103o && i4 == 3) {
                                        if (this.f8107s) {
                                            WeakReference<C2334a> weakReference3 = this.f8071D;
                                            if (!(weakReference3 == null || weakReference3.get() == null)) {
                                                ((C2334a) this.f8071D.get()).mo16096e();
                                            }
                                        }
                                        this.f8092d.removeCallbacks(this.f8089a);
                                    }
                                    if (this.f8103o && i4 == 3) {
                                        m10513F();
                                        break;
                                    }
                                    break;
                                case 305:
                                    WeakReference<C2326c> weakReference4 = this.f8070C;
                                    if (!(weakReference4 == null || weakReference4.get() == null)) {
                                        ((C2326c) this.f8070C.get()).mo15051f();
                                    }
                                    C2538ak akVar = this.f8092d;
                                    if (akVar != null) {
                                        akVar.removeCallbacks(this.f8078K);
                                    }
                                    if (!this.f8103o) {
                                        m10513F();
                                    }
                                    NativeVideoLayout hVar3 = this.f8090b;
                                    if (hVar3 != null) {
                                        hVar3.mo16205w();
                                    }
                                    this.f8092d.removeCallbacks(this.f8089a);
                                    break;
                                case TinkerReport.KEY_LOADED_MISSING_PATCH_INFO /*306*/:
                                    NativeVideoLayout hVar4 = this.f8090b;
                                    if (hVar4 != null) {
                                        hVar4.mo16205w();
                                        break;
                                    }
                                    break;
                                default:
                                    switch (i) {
                                        case 311:
                                            m10516I();
                                            break;
                                        case 312:
                                            if (!m10548z()) {
                                                C2564t.m12222c(str, "不满足条件，无法重试");
                                                break;
                                            } else {
                                                C2564t.m12226e(str, "CALLBACK_ON_RETRY_VIDEO_TIME-....重试....");
                                                mo15988l();
                                                this.f8095g = null;
                                                mo15965a(this.f8106r.mo15512z().mo15603g(), this.f8106r.mo15425M(), this.f8072E, this.f8073F, null, this.f8106r.mo15428P(), 0, mo16124b());
                                                break;
                                            }
                                        case 313:
                                            m10515H();
                                            break;
                                        case 314:
                                            try {
                                                ((Boolean) message.obj).booleanValue();
                                            } catch (Throwable unused) {
                                            }
                                            this.f8082O = SystemClock.elapsedRealtime();
                                            break;
                                    }
                            }
                        } else {
                            C2564t.m12222c(str, "SSMediaPlayerWrapper 释放了。。。。。");
                        }
                    } else if (message.obj instanceof Long) {
                        this.f8097i = ((Long) message.obj).longValue();
                        long j = this.f8098j;
                        long j2 = this.f8097i;
                        if (j <= j2) {
                            j = j2;
                        }
                        this.f8098j = j;
                        m10522a(this.f8097i, this.f8099k);
                    }
                } else if ((message.obj instanceof Long) && ((Long) message.obj).longValue() > 0) {
                    this.f8099k = ((Long) message.obj).longValue();
                }
            }
        }
    }

    /* renamed from: b */
    private void m10530b(int i, int i2) {
        if (this.f8106r != null) {
            boolean f = mo16130f();
            String str = f ? "play_error" : "play_start_error";
            Map a = ToolUtils.m11996a(this.f8106r, i, i2, mo15996t());
            if (f) {
                a.put("duration", Long.valueOf(mo15991o()));
                a.put("percent", Integer.valueOf(mo15993q()));
                a.put("buffers_time", Long.valueOf(mo15990n()));
            }
            AdEventManager.m8412k((Context) this.f8102n.get(), this.f8106r, this.f8109u, str, a);
        }
    }

    /* renamed from: G */
    private void m10514G() {
        if (this.f8091c.get() != null && !VisibilityChecker.m11004a((View) this.f8091c.get(), 20, 0)) {
            C2564t.m12226e("NativeVideoController", "onStateError 出错后展示结果页、、、、、、、");
            this.f8090b.mo16147a(this.f8106r, this.f8102n, false);
            mo15978d(true);
            mo15988l();
        }
    }

    /* renamed from: H */
    private void m10515H() {
        String str = "NativeVideoController";
        C2564t.m12220b(str, "before auseWhenInvisible、、、、、、、");
        if (this.f8091c.get() != null && !VisibilityChecker.m11004a((View) this.f8091c.get(), 20, 0)) {
            C2564t.m12220b(str, "in pauseWhenInvisible、、、、、、、");
            mo16126d();
        }
    }

    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r2v16, types: [android.content.Context] */
    /* JADX WARNING: type inference failed for: r2v18, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: type inference failed for: r2v21 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* renamed from: I */
    private void m10516I() {
        /*
        r13 = this;
        java.lang.String r0 = "ChangeVideoSize"
        java.lang.String r1 = "[step-0]  TAG is 'ChangeVideoSize' ....... start  changeVideoSize >>>>>>>>>>>>>>>>>>>>>>>"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r0, r1)
        java.lang.ref.WeakReference<android.content.Context> r1 = r13.f8102n     // Catch:{ all -> 0x01ef }
        r2 = 0
        r3 = 0
        r4 = 1
        if (r1 == 0) goto L_0x0188
        java.lang.ref.WeakReference<android.content.Context> r1 = r13.f8102n     // Catch:{ all -> 0x01ef }
        java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x01ef }
        if (r1 == 0) goto L_0x0188
        com.bytedance.sdk.openadsdk.core.video.renderview.b r1 = r13.m10517J()     // Catch:{ all -> 0x01ef }
        if (r1 == 0) goto L_0x0188
        com.bytedance.sdk.openadsdk.core.video.c.d r1 = r13.f8095g     // Catch:{ all -> 0x01ef }
        if (r1 == 0) goto L_0x0188
        com.bytedance.sdk.openadsdk.core.video.c.d r1 = r13.f8095g     // Catch:{ all -> 0x01ef }
        android.media.MediaPlayer r1 = r1.mo16055a()     // Catch:{ all -> 0x01ef }
        if (r1 != 0) goto L_0x002a
        goto L_0x0188
    L_0x002a:
        java.lang.ref.WeakReference<android.content.Context> r1 = r13.f8102n     // Catch:{ all -> 0x01ef }
        java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x01ef }
        android.content.Context r1 = (android.content.Context) r1     // Catch:{ all -> 0x01ef }
        android.content.res.Resources r1 = r1.getResources()     // Catch:{ all -> 0x01ef }
        android.content.res.Configuration r1 = r1.getConfiguration()     // Catch:{ all -> 0x01ef }
        int r1 = r1.orientation     // Catch:{ all -> 0x01ef }
        if (r1 != r4) goto L_0x0040
        r1 = 1
        goto L_0x0041
    L_0x0040:
        r1 = 0
    L_0x0041:
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ef }
        r5.<init>()     // Catch:{ all -> 0x01ef }
        java.lang.String r6 = "[step-2] >>>>> isVectical="
        r5.append(r6)     // Catch:{ all -> 0x01ef }
        r5.append(r1)     // Catch:{ all -> 0x01ef }
        java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01ef }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r0, r5)     // Catch:{ all -> 0x01ef }
        java.lang.ref.WeakReference<android.content.Context> r5 = r13.f8102n     // Catch:{ all -> 0x01ef }
        java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x01ef }
        android.content.Context r5 = (android.content.Context) r5     // Catch:{ all -> 0x01ef }
        int r5 = com.bytedance.sdk.openadsdk.utils.UIUtils.m12078c(r5)     // Catch:{ all -> 0x01ef }
        float r5 = (float) r5     // Catch:{ all -> 0x01ef }
        java.lang.ref.WeakReference<android.content.Context> r6 = r13.f8102n     // Catch:{ all -> 0x01ef }
        java.lang.Object r6 = r6.get()     // Catch:{ all -> 0x01ef }
        android.content.Context r6 = (android.content.Context) r6     // Catch:{ all -> 0x01ef }
        int r6 = com.bytedance.sdk.openadsdk.utils.UIUtils.m12084d(r6)     // Catch:{ all -> 0x01ef }
        float r6 = (float) r6     // Catch:{ all -> 0x01ef }
        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ef }
        r7.<init>()     // Catch:{ all -> 0x01ef }
        java.lang.String r8 = "[step-3] >>>>> screenWidth="
        r7.append(r8)     // Catch:{ all -> 0x01ef }
        r7.append(r5)     // Catch:{ all -> 0x01ef }
        java.lang.String r8 = ",screenHeight="
        r7.append(r8)     // Catch:{ all -> 0x01ef }
        r7.append(r6)     // Catch:{ all -> 0x01ef }
        java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x01ef }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r0, r6)     // Catch:{ all -> 0x01ef }
        com.bytedance.sdk.openadsdk.core.video.c.d r6 = r13.f8095g     // Catch:{ all -> 0x01ef }
        android.media.MediaPlayer r6 = r6.mo16055a()     // Catch:{ all -> 0x01ef }
        int r7 = r6.getVideoWidth()     // Catch:{ all -> 0x01ef }
        float r7 = (float) r7     // Catch:{ all -> 0x01ef }
        int r6 = r6.getVideoHeight()     // Catch:{ all -> 0x01ef }
        float r6 = (float) r6     // Catch:{ all -> 0x01ef }
        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ef }
        r8.<init>()     // Catch:{ all -> 0x01ef }
        java.lang.String r9 = "[step-4] Get the videoWidth and videoHeight from mediaPlayer , videoHeight="
        r8.append(r9)     // Catch:{ all -> 0x01ef }
        r8.append(r6)     // Catch:{ all -> 0x01ef }
        java.lang.String r9 = ",videoWidth="
        r8.append(r9)     // Catch:{ all -> 0x01ef }
        r8.append(r7)     // Catch:{ all -> 0x01ef }
        java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x01ef }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r0, r8)     // Catch:{ all -> 0x01ef }
        java.lang.String r8 = ">>, if value is false: continue to perform ...."
        int r9 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
        if (r9 < 0) goto L_0x016d
        r10 = 0
        int r11 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
        if (r11 <= 0) goto L_0x016d
        int r11 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
        if (r11 > 0) goto L_0x00c8
        goto L_0x016d
    L_0x00c8:
        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ef }
        r11.<init>()     // Catch:{ all -> 0x01ef }
        java.lang.String r12 = "[step-5] >>  videoWidth < videoHeight ->value:>>"
        r11.append(r12)     // Catch:{ all -> 0x01ef }
        if (r9 >= 0) goto L_0x00d5
        r3 = 1
    L_0x00d5:
        r11.append(r3)     // Catch:{ all -> 0x01ef }
        r11.append(r8)     // Catch:{ all -> 0x01ef }
        java.lang.String r3 = r11.toString()     // Catch:{ all -> 0x01ef }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r0, r3)     // Catch:{ all -> 0x01ef }
        if (r1 == 0) goto L_0x00e8
        float r6 = r6 * r5
        float r10 = r6 / r7
    L_0x00e8:
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ef }
        r3.<init>()     // Catch:{ all -> 0x01ef }
        java.lang.String r4 = "[step-6] >>>>> vHeight = (videoHeight * screenWidth) / videoWidth --> calculate the adaptive height , vHeight="
        r3.append(r4)     // Catch:{ all -> 0x01ef }
        r3.append(r10)     // Catch:{ all -> 0x01ef }
        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01ef }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r0, r3)     // Catch:{ all -> 0x01ef }
        java.lang.Float r3 = java.lang.Float.valueOf(r10)     // Catch:{ all -> 0x01ef }
        boolean r3 = r3.isNaN()     // Catch:{ all -> 0x01ef }
        if (r3 == 0) goto L_0x0107
        return
    L_0x0107:
        java.lang.String r3 = "[step-7]  >>>>> vHeight check pass !"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r0, r3)     // Catch:{ all -> 0x01ef }
        if (r1 == 0) goto L_0x011a
        android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x01ef }
        int r1 = (int) r5     // Catch:{ all -> 0x01ef }
        int r3 = (int) r10     // Catch:{ all -> 0x01ef }
        r2.<init>(r1, r3)     // Catch:{ all -> 0x01ef }
        r1 = 13
        r2.addRule(r1)     // Catch:{ all -> 0x01ef }
    L_0x011a:
        if (r2 != 0) goto L_0x011d
        return
    L_0x011d:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ef }
        r1.<init>()     // Catch:{ all -> 0x01ef }
        java.lang.String r3 = "[step-8] >>>>> create LayoutParams finish ! >> screenWidth = "
        r1.append(r3)     // Catch:{ all -> 0x01ef }
        r1.append(r5)     // Catch:{ all -> 0x01ef }
        java.lang.String r3 = "，vHeight ="
        r1.append(r3)     // Catch:{ all -> 0x01ef }
        r1.append(r10)     // Catch:{ all -> 0x01ef }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01ef }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r0, r1)     // Catch:{ all -> 0x01ef }
        com.bytedance.sdk.openadsdk.core.video.renderview.b r1 = r13.m10517J()     // Catch:{ all -> 0x01ef }
        boolean r1 = r1 instanceof android.view.TextureView     // Catch:{ all -> 0x01ef }
        if (r1 == 0) goto L_0x0150
        com.bytedance.sdk.openadsdk.core.video.renderview.b r1 = r13.m10517J()     // Catch:{ all -> 0x01ef }
        android.view.TextureView r1 = (android.view.TextureView) r1     // Catch:{ all -> 0x01ef }
        r1.setLayoutParams(r2)     // Catch:{ all -> 0x01ef }
        java.lang.String r1 = "[step-9] >>>>> setLayoutParams to TextureView complete ! >>>>>>>"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r0, r1)     // Catch:{ all -> 0x01ef }
        goto L_0x0166
    L_0x0150:
        com.bytedance.sdk.openadsdk.core.video.renderview.b r1 = r13.m10517J()     // Catch:{ all -> 0x01ef }
        boolean r1 = r1 instanceof android.view.SurfaceView     // Catch:{ all -> 0x01ef }
        if (r1 == 0) goto L_0x0166
        com.bytedance.sdk.openadsdk.core.video.renderview.b r1 = r13.m10517J()     // Catch:{ all -> 0x01ef }
        android.view.SurfaceView r1 = (android.view.SurfaceView) r1     // Catch:{ all -> 0x01ef }
        r1.setLayoutParams(r2)     // Catch:{ all -> 0x01ef }
        java.lang.String r1 = "[step-9] >>>>> setLayoutParams to SurfaceView complete !>>>>>>>"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r0, r1)     // Catch:{ all -> 0x01ef }
    L_0x0166:
        java.lang.String r1 = "[step-10] end : changeVideoSize has complete ! >>>>>>>>>>>>>>>>>>>>>>>>>>>>> "
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r0, r1)     // Catch:{ all -> 0x01ef }
        goto L_0x0208
    L_0x016d:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ef }
        r1.<init>()     // Catch:{ all -> 0x01ef }
        java.lang.String r2 = "[step-5] >> (videoWidth < videoHeight || videoHeight <= 0 || videoWidth <= 0) ->value:>>"
        r1.append(r2)     // Catch:{ all -> 0x01ef }
        if (r9 >= 0) goto L_0x017a
        r3 = 1
    L_0x017a:
        r1.append(r3)     // Catch:{ all -> 0x01ef }
        r1.append(r8)     // Catch:{ all -> 0x01ef }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01ef }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r0, r1)     // Catch:{ all -> 0x01ef }
        return
    L_0x0188:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ef }
        r1.<init>()     // Catch:{ all -> 0x01ef }
        java.lang.String r5 = "[step-1] >>>>> mContextRef="
        r1.append(r5)     // Catch:{ all -> 0x01ef }
        java.lang.ref.WeakReference<android.content.Context> r5 = r13.f8102n     // Catch:{ all -> 0x01ef }
        r1.append(r5)     // Catch:{ all -> 0x01ef }
        java.lang.String r5 = ",mContextRef.get()="
        r1.append(r5)     // Catch:{ all -> 0x01ef }
        java.lang.ref.WeakReference<android.content.Context> r5 = r13.f8102n     // Catch:{ all -> 0x01ef }
        if (r5 == 0) goto L_0x01a8
        java.lang.ref.WeakReference<android.content.Context> r2 = r13.f8102n     // Catch:{ all -> 0x01ef }
        java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x01ef }
        android.content.Context r2 = (android.content.Context) r2     // Catch:{ all -> 0x01ef }
    L_0x01a8:
        r1.append(r2)     // Catch:{ all -> 0x01ef }
        java.lang.String r2 = ",getIRenderView() ="
        r1.append(r2)     // Catch:{ all -> 0x01ef }
        com.bytedance.sdk.openadsdk.core.video.renderview.b r2 = r13.m10517J()     // Catch:{ all -> 0x01ef }
        r1.append(r2)     // Catch:{ all -> 0x01ef }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01ef }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r0, r1)     // Catch:{ all -> 0x01ef }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ef }
        r1.<init>()     // Catch:{ all -> 0x01ef }
        java.lang.String r2 = "[step-1] >>>>> mMediaPlayerProxy == null:"
        r1.append(r2)     // Catch:{ all -> 0x01ef }
        com.bytedance.sdk.openadsdk.core.video.c.d r2 = r13.f8095g     // Catch:{ all -> 0x01ef }
        if (r2 != 0) goto L_0x01ce
        r2 = 1
        goto L_0x01cf
    L_0x01ce:
        r2 = 0
    L_0x01cf:
        r1.append(r2)     // Catch:{ all -> 0x01ef }
        java.lang.String r2 = ",mMediaPlayerProxy.getMediaPlayer() == null:"
        r1.append(r2)     // Catch:{ all -> 0x01ef }
        com.bytedance.sdk.openadsdk.core.video.c.d r2 = r13.f8095g     // Catch:{ all -> 0x01ef }
        if (r2 == 0) goto L_0x01e4
        com.bytedance.sdk.openadsdk.core.video.c.d r2 = r13.f8095g     // Catch:{ all -> 0x01ef }
        android.media.MediaPlayer r2 = r2.mo16055a()     // Catch:{ all -> 0x01ef }
        if (r2 != 0) goto L_0x01e4
        r3 = 1
    L_0x01e4:
        r1.append(r3)     // Catch:{ all -> 0x01ef }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01ef }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r0, r1)     // Catch:{ all -> 0x01ef }
        return
    L_0x01ef:
        r1 = move-exception
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r3 = "[step-11] >>>>> changeVideoSize error !!!!! ："
        r2.append(r3)
        java.lang.String r1 = r1.toString()
        r2.append(r1)
        java.lang.String r1 = r2.toString()
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r0, r1)
    L_0x0208:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoController.m10516I():void");
    }

    /* renamed from: J */
    private IRenderView m10517J() {
        WeakReference<Context> weakReference = this.f8102n;
        if (!(weakReference == null || weakReference.get() == null || ((Context) this.f8102n.get()).getResources().getConfiguration().orientation != 1)) {
            NativeVideoLayout hVar = this.f8090b;
            if (hVar != null) {
                return hVar.mo16197o();
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo15956a(IMediaLayout bVar, View view) {
        if (this.f8095g != null && m10510C()) {
            if (this.f8095g.mo16067g()) {
                mo15984h();
                this.f8090b.mo16190b(true, false);
                this.f8090b.mo16156c();
            } else if (!this.f8095g.mo16069i()) {
                NativeVideoLayout hVar = this.f8090b;
                if (hVar != null) {
                    hVar.mo16192c((ViewGroup) this.f8091c.get());
                }
                mo16127d(this.f8097i);
                NativeVideoLayout hVar2 = this.f8090b;
                if (hVar2 != null) {
                    hVar2.mo16190b(false, false);
                }
            } else {
                mo16131g(false);
                NativeVideoLayout hVar3 = this.f8090b;
                if (hVar3 != null) {
                    hVar3.mo16190b(false, false);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo15951a(IMediaLayout bVar, int i) {
        if (this.f8095g != null) {
            m10508A();
            m10523a(this.f8085R, m10535c(i));
        }
    }

    /* renamed from: b */
    public void mo15967b(IMediaLayout bVar, int i) {
        if (this.f8095g != null) {
            m10509B();
        }
        NativeVideoLayout hVar = this.f8090b;
        if (hVar != null) {
            hVar.mo16156c();
        }
    }

    /* renamed from: a */
    public void mo15952a(IMediaLayout bVar, int i, boolean z) {
        if (m10510C()) {
            long l = (long) ((((float) (((long) i) * this.f8099k)) * 1.0f) / ((float) ResourceHelp.m11942l((Context) this.f8102n.get(), "tt_video_progress_max")));
            if (this.f8099k > 0) {
                this.f8085R = (long) ((int) l);
            } else {
                this.f8085R = 0;
            }
            NativeVideoLayout hVar = this.f8090b;
            if (hVar != null) {
                hVar.mo16142a(this.f8085R);
            }
        }
    }

    /* renamed from: a */
    private void m10522a(long j, long j2) {
        this.f8097i = j;
        this.f8099k = j2;
        this.f8090b.mo16143a(j, j2);
        this.f8090b.mo16141a(MediaHelper.m10402a(j, j2));
        try {
            if (this.f8096h != null) {
                this.f8096h.mo14913a(j, j2);
            }
        } catch (Throwable th) {
            C2564t.m12223c("NativeVideoController", "onProgressUpdate error: ", th);
        }
    }

    /* renamed from: b */
    public void mo15970b(IMediaLayout bVar, View view) {
        mo16123b(bVar, view, false, false);
    }

    /* renamed from: b */
    public void mo16123b(IMediaLayout bVar, View view, boolean z, boolean z2) {
        if (m10510C()) {
            m10544h(!this.f8084Q);
            if (!(this.f8102n.get() instanceof Activity)) {
                C2564t.m12220b("NativeVideoController", "context is not activity, not support this function.");
                return;
            }
            if (this.f8084Q) {
                mo16116a(z ? 8 : 0);
                NativeVideoLayout hVar = this.f8090b;
                if (hVar != null) {
                    hVar.mo16146a((ViewGroup) this.f8091c.get());
                    this.f8090b.mo16154b(false);
                }
            } else {
                mo16116a(1);
                NativeVideoLayout hVar2 = this.f8090b;
                if (hVar2 != null) {
                    hVar2.mo16153b((ViewGroup) this.f8091c.get());
                    this.f8090b.mo16154b(false);
                }
            }
            WeakReference<IVideoFullscreen> weakReference = this.f8110v;
            IVideoFullscreen eVar = weakReference != null ? (IVideoFullscreen) weakReference.get() : null;
            if (eVar != null) {
                eVar.mo14985a(this.f8084Q);
            }
        }
    }

    /* renamed from: a */
    public void mo16116a(int i) {
        if (m10510C()) {
            boolean z = i == 0 || i == 8;
            Context context = (Context) this.f8102n.get();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                try {
                    activity.setRequestedOrientation(i);
                } catch (Throwable unused) {
                }
                if (!z) {
                    activity.getWindow().setFlags(1024, 1024);
                } else {
                    activity.getWindow().clearFlags(1024);
                }
            }
        }
    }

    /* renamed from: c */
    public void mo15974c(IMediaLayout bVar, View view) {
        NativeVideoLayout hVar = this.f8090b;
        if (hVar != null) {
            hVar.mo16161g();
        }
        mo15964a(true);
    }

    /* renamed from: a */
    public void mo15958a(IMediaLayout bVar, View view, boolean z, boolean z2) {
        if (this.f8107s) {
            mo15984h();
        }
        if (z && !this.f8107s && !mo16129e()) {
            this.f8090b.mo16190b(!mo16130f(), false);
            this.f8090b.mo16151a(z2, true, false);
        }
        SSMediaPlayerWrapper dVar = this.f8095g;
        if (dVar == null || !dVar.mo16067g()) {
            this.f8090b.mo16156c();
            return;
        }
        this.f8090b.mo16156c();
        this.f8090b.mo16152b();
    }

    /* renamed from: d */
    public void mo15977d(IMediaLayout bVar, View view) {
        if (this.f8084Q) {
            m10544h(false);
            NativeVideoLayout hVar = this.f8090b;
            if (hVar != null) {
                hVar.mo16153b((ViewGroup) this.f8091c.get());
            }
            mo16116a(1);
            return;
        }
        mo15964a(true);
    }

    /* renamed from: e */
    public void mo15979e(IMediaLayout bVar, View view) {
        mo16120a(bVar, view, false);
    }

    /* renamed from: a */
    public void mo16120a(IMediaLayout bVar, View view, boolean z) {
        m10518K();
    }

    /* renamed from: K */
    private void m10518K() {
        if (m10510C()) {
            m10544h(!this.f8084Q);
            if (!(this.f8102n.get() instanceof Activity)) {
                C2564t.m12220b("NativeVideoController", "context is not activity, not support this function.");
                return;
            }
            NativeVideoLayout hVar = this.f8090b;
            if (hVar != null) {
                hVar.mo16153b((ViewGroup) this.f8091c.get());
                this.f8090b.mo16154b(false);
            }
            mo16116a(1);
            WeakReference<IVideoFullscreen> weakReference = this.f8110v;
            IVideoFullscreen eVar = weakReference != null ? (IVideoFullscreen) weakReference.get() : null;
            if (eVar != null) {
                eVar.mo14985a(this.f8084Q);
            }
        }
    }

    /* renamed from: h */
    private void m10544h(boolean z) {
        this.f8084Q = z;
    }

    /* renamed from: a */
    public void mo15954a(IMediaLayout bVar, SurfaceHolder surfaceHolder) {
        this.f8101m = true;
        SSMediaPlayerWrapper dVar = this.f8095g;
        if (dVar != null) {
            dVar.mo16058a(surfaceHolder);
            m10511D();
        }
    }

    /* renamed from: b */
    public void mo15969b(IMediaLayout bVar, SurfaceHolder surfaceHolder) {
        this.f8101m = false;
    }

    /* renamed from: a */
    public void mo15953a(IMediaLayout bVar, SurfaceTexture surfaceTexture) {
        this.f8101m = true;
        SSMediaPlayerWrapper dVar = this.f8095g;
        if (dVar != null) {
            dVar.mo16057a(surfaceTexture);
            m10511D();
        }
    }

    /* renamed from: b */
    public void mo15968b(IMediaLayout bVar, SurfaceTexture surfaceTexture) {
        this.f8101m = false;
    }

    /* renamed from: e */
    public boolean mo16129e() {
        SSMediaPlayerWrapper dVar = this.f8095g;
        return dVar == null || dVar.mo16072l();
    }

    /* renamed from: g */
    public void mo15983g() {
        if (C2566w.m12244c(InternalContainer.m10059a()) != 0) {
            mo15988l();
            mo15965a(this.f8106r.mo15512z().mo15603g(), this.f8106r.mo15425M(), this.f8072E, this.f8073F, null, this.f8106r.mo15428P(), 0, mo16124b());
            mo15978d(false);
        }
    }

    /* renamed from: f */
    public boolean mo16130f() {
        SSMediaPlayerWrapper dVar = this.f8095g;
        return dVar != null && dVar.mo16067g();
    }

    /* renamed from: a */
    private void m10523a(long j, boolean z) {
        if (this.f8095g != null) {
            if (z) {
                m10519L();
            }
            this.f8095g.mo16056a(j);
        }
    }

    /* renamed from: c */
    private boolean m10535c(int i) {
        return this.f8090b.mo16155b(i);
    }

    /* renamed from: L */
    private void m10519L() {
        NativeVideoLayout hVar = this.f8090b;
        if (hVar != null) {
            hVar.mo16157c(0);
            this.f8090b.mo16150a(false, false);
            this.f8090b.mo16154b(false);
            this.f8090b.mo16152b();
            this.f8090b.mo16158d();
        }
    }

    /* renamed from: a */
    public void mo15962a(C2365a aVar, String str) {
        int i = C23337.f8121a[aVar.ordinal()];
        if (i == 1) {
            mo15984h();
        } else if (i == 2) {
            mo15964a(true);
        } else if (i == 3) {
            mo15986j();
            this.f8112x = false;
            this.f8113y = true;
        }
    }

    /* renamed from: d */
    private boolean m10538d(int i) {
        int c = C2566w.m12244c(InternalContainer.m10059a());
        if (c == 0) {
            mo15984h();
            this.f8112x = true;
            NativeVideoLayout hVar = this.f8090b;
            if (hVar != null) {
                hVar.mo16147a(this.f8106r, this.f8102n, false);
            }
        }
        if (c != 4 && c != 0) {
            NativeVideoLayout hVar2 = this.f8090b;
            if (hVar2 != null) {
                hVar2.mo16159e();
            }
            mo15984h();
            this.f8112x = true;
            this.f8113y = false;
            NativeVideoLayout hVar3 = this.f8090b;
            if (hVar3 != null) {
                MaterialMeta kVar = this.f8106r;
                if (kVar != null) {
                    return hVar3.mo16184a(i, kVar.mo15512z());
                }
            }
        } else if (c == 4) {
            this.f8112x = false;
            NativeVideoLayout hVar4 = this.f8090b;
            if (hVar4 != null) {
                hVar4.mo16199q();
            }
        }
        return true;
    }

    /* renamed from: a */
    private void m10524a(Context context, int i) {
        if (m10510C() && context != null && this.f8087T != i) {
            this.f8087T = i;
            if (!(i == 4 || i == 0)) {
                this.f8113y = false;
            }
            if (!this.f8113y && !mo15998v()) {
                m10538d(2);
            }
            WeakReference<C2334a> weakReference = this.f8071D;
            if (!(weakReference == null || weakReference.get() == null)) {
                ((C2334a) this.f8071D.get()).mo16093a(this.f8087T);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m10537d(Context context) {
        int c = C2566w.m12244c(context);
        m10524a(context, c);
        if (c == 4) {
            this.f8112x = false;
        }
    }

    /* renamed from: a */
    public void mo16118a(Context context) {
        int c = C2566w.m12244c(context);
        m10524a(context, c);
        if (c == 4) {
            this.f8112x = false;
            mo15986j();
        }
    }

    /* renamed from: x */
    public void mo16132x() {
        if (!this.f8088U && this.f8076I) {
            Context applicationContext = InternalContainer.m10059a().getApplicationContext();
            this.f8088U = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            try {
                applicationContext.registerReceiver(this.f8086S, intentFilter);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: y */
    public void mo16133y() {
        if (this.f8088U && this.f8076I) {
            Context applicationContext = InternalContainer.m10059a().getApplicationContext();
            this.f8088U = false;
            try {
                applicationContext.unregisterReceiver(this.f8086S);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public void mo16121a(C2334a aVar) {
        this.f8071D = new WeakReference<>(aVar);
    }

    /* renamed from: d */
    public void mo15978d(boolean z) {
        this.f8114z = z;
    }

    /* renamed from: e */
    public void mo15980e(boolean z) {
        this.f8069B = z;
    }

    /* renamed from: w */
    public boolean mo15999w() {
        return this.f8075H;
    }

    /* renamed from: f */
    public void mo15982f(boolean z) {
        this.f8076I = z;
    }

    /* renamed from: c */
    private boolean m10536c(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("OnError - Error code: ");
        sb.append(i);
        sb.append(" Extra code: ");
        sb.append(i2);
        C2564t.m12220b("TTVideoLandingPageActivity", sb.toString());
        boolean z = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
            return true;
        }
        return z;
    }
}
