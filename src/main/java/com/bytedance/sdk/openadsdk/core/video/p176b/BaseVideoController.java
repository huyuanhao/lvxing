package com.bytedance.sdk.openadsdk.core.video.p176b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Build.VERSION;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.IMediaCallback;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.IMediaLayout;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.IMediaLayout.C2323a;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.INativeVideoController;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.INativeVideoController.C2324a;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.INativeVideoController.C2326c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.INewMediaCallback;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.IVideoFullscreen;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoLayout;
import com.bytedance.sdk.openadsdk.core.video.p175a.VideoAdModel;
import com.bytedance.sdk.openadsdk.core.video.p177c.SSMediaPlayerWrapper;
import com.bytedance.sdk.openadsdk.core.video.p178d.MediaHelper;
import com.bytedance.sdk.openadsdk.core.video.renderview.IRenderView;
import com.bytedance.sdk.openadsdk.core.widget.VideoTrafficTipLayout.C2365a;
import com.bytedance.sdk.openadsdk.utils.C2538ak;
import com.bytedance.sdk.openadsdk.utils.C2538ak.C2539a;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.bytedance.sdk.openadsdk.utils.UIUtils;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.bytedance.sdk.openadsdk.core.video.b.a */
public abstract class BaseVideoController implements INativeVideoController, INewMediaCallback, C2539a {
    /* renamed from: A */
    private boolean f7932A;
    /* renamed from: B */
    private boolean f7933B;
    /* renamed from: C */
    private WeakReference<IVideoFullscreen> f7934C;
    /* renamed from: D */
    private int f7935D;
    /* renamed from: E */
    private boolean f7936E;
    /* renamed from: F */
    private boolean f7937F;
    /* access modifiers changed from: private|final */
    /* renamed from: G */
    public final Runnable f7938G;
    /* renamed from: H */
    private final Runnable f7939H;
    /* renamed from: I */
    private final Runnable f7940I;
    /* renamed from: J */
    private boolean f7941J;
    /* renamed from: K */
    private long f7942K;
    /* renamed from: L */
    private final BroadcastReceiver f7943L;
    /* renamed from: M */
    private int f7944M;
    /* renamed from: N */
    private boolean f7945N;
    /* renamed from: a */
    public final WeakReference<Context> f7946a;
    /* renamed from: b */
    public final MaterialMeta f7947b;
    /* renamed from: c */
    public long f7948c;
    /* renamed from: d */
    protected Map<String, Object> f7949d;
    /* renamed from: e */
    protected long f7950e;
    /* renamed from: f */
    protected long f7951f;
    /* renamed from: g */
    protected boolean f7952g;
    /* renamed from: h */
    public long f7953h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public NativeVideoLayout f7954i;
    /* renamed from: j */
    private final ViewGroup f7955j;
    /* access modifiers changed from: private|final */
    /* renamed from: k */
    public final C2538ak f7956k = new C2538ak(this);
    /* access modifiers changed from: private */
    /* renamed from: l */
    public long f7957l = 0;
    /* renamed from: m */
    private long f7958m = 0;
    /* access modifiers changed from: private */
    /* renamed from: n */
    public SSMediaPlayerWrapper f7959n;
    /* access modifiers changed from: private */
    /* renamed from: o */
    public C2324a f7960o;
    /* access modifiers changed from: private */
    /* renamed from: p */
    public long f7961p = 0;
    /* renamed from: q */
    private long f7962q = 0;
    /* renamed from: r */
    private ArrayList<Runnable> f7963r;
    /* renamed from: s */
    private boolean f7964s;
    /* renamed from: t */
    private final boolean f7965t;
    /* renamed from: u */
    private boolean f7966u;
    /* renamed from: v */
    private boolean f7967v;
    /* renamed from: w */
    private boolean f7968w;
    /* access modifiers changed from: private */
    /* renamed from: x */
    public boolean f7969x;
    /* renamed from: y */
    private long f7970y;
    /* renamed from: z */
    private boolean f7971z;

    /* compiled from: BaseVideoController */
    /* renamed from: com.bytedance.sdk.openadsdk.core.video.b.a$6 */
    static /* synthetic */ class C23026 {
        /* renamed from: a */
        static final /* synthetic */ int[] f7977a = new int[C2365a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
            com.bytedance.sdk.openadsdk.core.widget.e$a[] r0 = com.bytedance.sdk.openadsdk.core.widget.VideoTrafficTipLayout.C2365a.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f7977a = r0
            int[] r0 = f7977a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.bytedance.sdk.openadsdk.core.widget.e$a r1 = com.bytedance.sdk.openadsdk.core.widget.VideoTrafficTipLayout.C2365a.PAUSE_VIDEO     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f7977a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.bytedance.sdk.openadsdk.core.widget.e$a r1 = com.bytedance.sdk.openadsdk.core.widget.VideoTrafficTipLayout.C2365a.RELEASE_VIDEO     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f7977a     // Catch:{ NoSuchFieldError -> 0x002a }
            com.bytedance.sdk.openadsdk.core.widget.e$a r1 = com.bytedance.sdk.openadsdk.core.widget.VideoTrafficTipLayout.C2365a.START_VIDEO     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.p176b.BaseVideoController.C23026.m43818clinit():void");
        }
    }

    /* renamed from: a */
    public abstract int mo15106a();

    /* renamed from: a */
    public abstract void mo15107a(int i, int i2);

    /* renamed from: a */
    public void mo15955a(IMediaLayout bVar, SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    /* renamed from: a */
    public void mo15957a(IMediaLayout bVar, View view, boolean z) {
    }

    /* renamed from: a */
    public void mo15960a(C2326c cVar) {
    }

    /* renamed from: b */
    public abstract void mo15108b();

    /* renamed from: c */
    public abstract void mo15109c();

    /* renamed from: d */
    public abstract void mo15110d();

    /* renamed from: e */
    public abstract void mo15111e();

    /* renamed from: e */
    public void mo15980e(boolean z) {
    }

    /* renamed from: f */
    public abstract void mo15112f();

    /* renamed from: f */
    public void mo15981f(IMediaLayout bVar, View view) {
    }

    /* renamed from: a */
    private void m10193a(Context context) {
        EnumSet noneOf = EnumSet.noneOf(C2323a.class);
        noneOf.add(C2323a.hideCloseBtn);
        noneOf.add(C2323a.hideBackBtn);
        NativeVideoLayout hVar = new NativeVideoLayout(context.getApplicationContext(), LayoutInflater.from(context.getApplicationContext()).inflate(ResourceHelp.m11936f(context, "tt_video_play_layout_for_live"), null, false), true, noneOf, this.f7947b, this);
        this.f7954i = hVar;
        this.f7954i.mo16183a((IMediaCallback) this);
    }

    protected BaseVideoController(Context context, ViewGroup viewGroup, MaterialMeta kVar) {
        boolean z = false;
        this.f7966u = false;
        this.f7967v = false;
        this.f7968w = true;
        this.f7969x = false;
        this.f7970y = 0;
        this.f7971z = false;
        this.f7932A = false;
        this.f7933B = false;
        this.f7949d = null;
        this.f7950e = 0;
        this.f7951f = 0;
        this.f7952g = false;
        this.f7936E = false;
        this.f7937F = true;
        this.f7938G = new Runnable() {
            public void run() {
                if (BaseVideoController.this.f7959n != null) {
                    BaseVideoController.this.f7959n.mo16065e();
                }
            }
        };
        this.f7939H = new Runnable() {
            public void run() {
                if (BaseVideoController.this.f7960o != null) {
                    BaseVideoController.this.f7960o.mo14911a();
                }
            }
        };
        this.f7940I = new Runnable() {
            public void run() {
                if (BaseVideoController.this.f7959n != null) {
                    if (BaseVideoController.this.f7948c <= 0) {
                        BaseVideoController.this.f7959n.mo16065e();
                    }
                    BaseVideoController.this.f7959n.mo16066f();
                }
                BaseVideoController.this.f7956k.postDelayed(this, 200);
            }
        };
        this.f7941J = false;
        this.f7943L = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    BaseVideoController.this.mo15984h();
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    BaseVideoController.this.m10199b(context);
                }
            }
        };
        this.f7944M = 1;
        this.f7945N = false;
        this.f7944M = C2566w.m12244c(context);
        this.f7955j = viewGroup;
        this.f7946a = new WeakReference<>(context);
        this.f7947b = kVar;
        m10193a(context);
        this.f7935D = ToolUtils.m12018d(this.f7947b.mo15428P());
        if (VERSION.SDK_INT >= 17) {
            z = true;
        }
        this.f7965t = z;
    }

    /* renamed from: a */
    public boolean mo15965a(String str, String str2, int i, int i2, List<String> list, String str3, long j, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("video local url ");
        sb.append(str);
        String str4 = "BaseVideoController";
        C2564t.m12220b(str4, sb.toString());
        if (TextUtils.isEmpty(str)) {
            C2564t.m12226e(str4, "No video info");
            return false;
        }
        this.f7952g = !str.startsWith("http");
        this.f7969x = z;
        if (j > 0) {
            this.f7961p = j;
            long j2 = this.f7962q;
            long j3 = this.f7961p;
            if (j2 <= j3) {
                j2 = j3;
            }
            this.f7962q = j2;
        }
        NativeVideoLayout hVar = this.f7954i;
        if (hVar != null) {
            hVar.mo16159e();
            this.f7954i.mo16158d();
            this.f7954i.mo16191c(i, i2);
            this.f7954i.mo16192c(this.f7955j);
        }
        if (this.f7959n == null) {
            this.f7959n = new SSMediaPlayerWrapper(this.f7956k);
        }
        this.f7958m = 0;
        try {
            m10196a(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: t */
    public SSMediaPlayerWrapper mo15996t() {
        return this.f7959n;
    }

    /* renamed from: u */
    public NativeVideoLayout mo15997u() {
        return this.f7954i;
    }

    /* renamed from: m */
    public long mo15989m() {
        return this.f7961p;
    }

    /* renamed from: a */
    public void mo15950a(long j) {
        this.f7961p = j;
        long j2 = this.f7962q;
        long j3 = this.f7961p;
        if (j2 <= j3) {
            j2 = j3;
        }
        this.f7962q = j2;
    }

    /* renamed from: b */
    public void mo15972b(boolean z) {
        this.f7968w = z;
        this.f7954i.mo16193c(z);
    }

    /* renamed from: s */
    public boolean mo15995s() {
        return this.f7971z;
    }

    /* renamed from: b */
    public void mo15966b(long j) {
        this.f7970y = j;
    }

    /* renamed from: r */
    public long mo15994r() {
        return this.f7948c;
    }

    /* renamed from: c */
    public void mo15973c(long j) {
        this.f7948c = j;
    }

    /* renamed from: n */
    public long mo15990n() {
        if (mo15996t() == null) {
            return 0;
        }
        return mo15996t().mo16074n();
    }

    /* renamed from: o */
    public long mo15991o() {
        SSMediaPlayerWrapper dVar = this.f7959n;
        if (dVar == null) {
            return 0;
        }
        return dVar.mo16075o() + this.f7970y;
    }

    /* renamed from: c */
    public void mo15975c(boolean z) {
        this.f7969x = z;
        SSMediaPlayerWrapper dVar = this.f7959n;
        if (dVar != null) {
            dVar.mo16060a(z);
        }
    }

    /* renamed from: p */
    public long mo15992p() {
        SSMediaPlayerWrapper dVar = this.f7959n;
        if (dVar == null) {
            return 0;
        }
        return dVar.mo16076p() + this.f7970y;
    }

    /* renamed from: v */
    public boolean mo15998v() {
        return this.f7933B;
    }

    /* renamed from: d */
    public void mo15978d(boolean z) {
        this.f7933B = z;
    }

    /* renamed from: w */
    public boolean mo15999w() {
        return this.f7936E;
    }

    /* renamed from: f */
    public void mo15982f(boolean z) {
        this.f7937F = z;
    }

    /* renamed from: q */
    public int mo15993q() {
        return MediaHelper.m10402a(this.f7962q, this.f7948c);
    }

    /* renamed from: a */
    public void mo15963a(Map<String, Object> map) {
        this.f7949d = map;
    }

    /* renamed from: a */
    private void m10196a(String str) throws Exception {
        if (this.f7959n != null) {
            VideoAdModel aVar = new VideoAdModel();
            aVar.f7928a = str;
            MaterialMeta kVar = this.f7947b;
            if (kVar != null) {
                if (kVar.mo15512z() != null) {
                    aVar.f7931d = this.f7947b.mo15512z().mo15606j();
                }
                aVar.f7929b = String.valueOf(ToolUtils.m12018d(this.f7947b.mo15428P()));
            }
            aVar.f7930c = 1;
            this.f7959n.mo16059a(aVar);
        }
        this.f7957l = System.currentTimeMillis();
        if (!TextUtils.isEmpty(str)) {
            this.f7954i.mo16194d(8);
            this.f7954i.mo16194d(0);
            m10195a((Runnable) new Runnable() {
                public void run() {
                    BaseVideoController.this.f7957l = System.currentTimeMillis();
                    BaseVideoController.this.f7954i.mo16157c(0);
                    if (BaseVideoController.this.f7959n != null && BaseVideoController.this.f7961p == 0) {
                        BaseVideoController.this.f7959n.mo16061a(true, 0, !BaseVideoController.this.f7969x);
                    } else if (BaseVideoController.this.f7959n != null) {
                        BaseVideoController.this.f7959n.mo16061a(true, BaseVideoController.this.f7961p, !BaseVideoController.this.f7969x);
                    }
                    if (BaseVideoController.this.f7956k != null) {
                        BaseVideoController.this.f7956k.postDelayed(BaseVideoController.this.f7938G, 100);
                    }
                    BaseVideoController.this.m10179D();
                }
            });
        }
    }

    /* renamed from: C */
    private void m10178C() {
        int a = mo15106a();
        int i = (a == 2 || a == 1) ? InternalContainer.m10069h().mo15771S() * 1000 : a == 3 ? InternalContainer.m10069h().mo15788f(String.valueOf(this.f7935D)) : 5;
        this.f7956k.removeCallbacks(this.f7939H);
        this.f7956k.postDelayed(this.f7939H, (long) i);
    }

    /* access modifiers changed from: private */
    /* renamed from: D */
    public void m10179D() {
        m10180E();
        this.f7956k.postDelayed(this.f7940I, 800);
    }

    /* renamed from: E */
    private void m10180E() {
        this.f7956k.removeCallbacks(this.f7940I);
    }

    /* renamed from: a */
    public void mo15961a(IVideoFullscreen eVar) {
        this.f7934C = new WeakReference<>(eVar);
    }

    /* renamed from: b */
    private void m10198b(int i) {
        if (m10181F() && this.f7954i != null) {
            this.f7956k.removeCallbacks(this.f7939H);
            this.f7954i.mo16205w();
            this.f7958m = System.currentTimeMillis() - this.f7957l;
            C2324a aVar = this.f7960o;
            if (aVar != null) {
                aVar.mo14912a(this.f7958m, MediaHelper.m10402a(this.f7961p, this.f7948c));
            }
            if (ToolUtils.m12013b(this.f7947b)) {
                this.f7954i.mo16147a(this.f7947b, this.f7946a, true);
            }
            if (!this.f7967v) {
                mo15108b();
                this.f7967v = true;
                long j = this.f7948c;
                m10191a(j, j);
                long j2 = this.f7948c;
                this.f7961p = j2;
                this.f7962q = j2;
            }
            this.f7933B = true;
        }
    }

    /* renamed from: F */
    private boolean m10181F() {
        WeakReference<Context> weakReference = this.f7946a;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    /* renamed from: a */
    private void m10195a(Runnable runnable) {
        if (runnable != null) {
            if (!this.f7954i.mo16165k() || !this.f7964s) {
                m10200b(runnable);
            } else {
                runnable.run();
            }
        }
    }

    /* renamed from: b */
    private void m10200b(Runnable runnable) {
        if (this.f7963r == null) {
            this.f7963r = new ArrayList<>();
        }
        this.f7963r.add(runnable);
    }

    /* renamed from: G */
    private void m10182G() {
        ArrayList<Runnable> arrayList = this.f7963r;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator it = new ArrayList(this.f7963r).iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            this.f7963r.clear();
        }
    }

    /* renamed from: a */
    public void mo15959a(C2324a aVar) {
        this.f7960o = aVar;
    }

    /* renamed from: h */
    public void mo15984h() {
        this.f7953h = mo15991o();
        SSMediaPlayerWrapper dVar = this.f7959n;
        if (dVar != null) {
            dVar.mo16062b();
        }
        if (!this.f7967v && this.f7966u) {
            mo15109c();
        }
    }

    /* renamed from: j */
    public void mo15986j() {
        NativeVideoLayout hVar = this.f7954i;
        if (hVar != null) {
            hVar.mo16159e();
            this.f7954i.mo16199q();
            this.f7954i.mo16203u();
        }
        SSMediaPlayerWrapper dVar = this.f7959n;
        if (dVar != null) {
            dVar.mo16061a(false, this.f7961p, !this.f7969x);
            m10179D();
        }
        if (!this.f7967v && this.f7966u) {
            mo15110d();
        }
    }

    /* renamed from: x */
    public void mo16000x() {
        if (!this.f7967v && this.f7966u) {
            mo15110d();
        }
    }

    /* renamed from: d */
    public void mo15976d(long j) {
        this.f7961p = j;
        long j2 = this.f7962q;
        long j3 = this.f7961p;
        if (j2 <= j3) {
            j2 = j3;
        }
        this.f7962q = j2;
        NativeVideoLayout hVar = this.f7954i;
        if (hVar != null) {
            hVar.mo16159e();
        }
        SSMediaPlayerWrapper dVar = this.f7959n;
        if (dVar != null) {
            dVar.mo16061a(true, this.f7961p, !this.f7969x);
            m10179D();
        }
    }

    /* renamed from: k */
    public void mo15987k() {
        SSMediaPlayerWrapper dVar = this.f7959n;
        if (dVar != null) {
            dVar.mo16063c();
            this.f7959n = null;
        }
        NativeVideoLayout hVar = this.f7954i;
        if (hVar != null) {
            hVar.mo16161g();
        }
        C2538ak akVar = this.f7956k;
        if (akVar != null) {
            akVar.removeCallbacks(this.f7939H);
            this.f7956k.removeCallbacks(this.f7938G);
            this.f7956k.removeCallbacksAndMessages(null);
            m10180E();
        }
        this.f7960o = null;
    }

    /* renamed from: a */
    public void mo15964a(boolean z) {
        mo15987k();
    }

    /* renamed from: l */
    public void mo15988l() {
        mo15987k();
    }

    /* renamed from: a */
    public void mo14813a(Message message) {
        if (this.f7954i != null && message != null) {
            WeakReference<Context> weakReference = this.f7946a;
            if (weakReference != null && weakReference.get() != null) {
                int i = message.what;
                if (i != 108) {
                    if (i != 109) {
                        if (i == 308) {
                            mo15107a((int) TinkerReport.KEY_LOADED_MISSING_RES, 0);
                        } else if (i == 311) {
                            MaterialMeta kVar = this.f7947b;
                            if (kVar == null || kVar.mo15479f() != 0) {
                                m10184I();
                            } else {
                                m10185J();
                            }
                        } else if (i != 314) {
                            switch (i) {
                                case 302:
                                    m10198b(message.what);
                                    return;
                                case 303:
                                    mo15107a(message.arg1, message.arg2);
                                    this.f7956k.removeCallbacks(this.f7939H);
                                    NativeVideoLayout hVar = this.f7954i;
                                    if (hVar != null) {
                                        hVar.mo16205w();
                                    }
                                    C2324a aVar = this.f7960o;
                                    if (aVar != null) {
                                        aVar.mo14914b(this.f7958m, MediaHelper.m10402a(this.f7961p, this.f7948c));
                                        return;
                                    }
                                    return;
                                case 304:
                                    int i2 = message.arg1;
                                    NativeVideoLayout hVar2 = this.f7954i;
                                    if (hVar2 != null) {
                                        if (i2 == 3 || i2 == 702) {
                                            this.f7954i.mo16205w();
                                            this.f7956k.removeCallbacks(this.f7939H);
                                            this.f7936E = false;
                                        } else if (i2 == 701) {
                                            hVar2.mo16202t();
                                            m10178C();
                                            this.f7936E = true;
                                        }
                                    }
                                    if (this.f7965t && i2 == 3 && !this.f7966u) {
                                        this.f7951f = SystemClock.elapsedRealtime() - this.f7950e;
                                        mo15111e();
                                        this.f7966u = true;
                                        return;
                                    }
                                    return;
                                case 305:
                                    C2538ak akVar = this.f7956k;
                                    if (akVar != null) {
                                        akVar.removeCallbacks(this.f7939H);
                                    }
                                    if (!this.f7965t && !this.f7966u) {
                                        this.f7951f = SystemClock.elapsedRealtime() - this.f7950e;
                                        mo15112f();
                                        this.f7966u = true;
                                    }
                                    NativeVideoLayout hVar3 = this.f7954i;
                                    if (hVar3 != null) {
                                        hVar3.mo16205w();
                                        return;
                                    }
                                    return;
                                case TinkerReport.KEY_LOADED_MISSING_PATCH_INFO /*306*/:
                                    this.f7956k.removeCallbacks(this.f7939H);
                                    NativeVideoLayout hVar4 = this.f7954i;
                                    if (hVar4 != null) {
                                        hVar4.mo16205w();
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                        } else {
                            try {
                                ((Boolean) message.obj).booleanValue();
                            } catch (Throwable unused) {
                            }
                            this.f7950e = SystemClock.elapsedRealtime();
                        }
                    } else if (message.obj instanceof Long) {
                        this.f7961p = ((Long) message.obj).longValue();
                        long j = this.f7962q;
                        long j2 = this.f7961p;
                        if (j <= j2) {
                            j = j2;
                        }
                        this.f7962q = j;
                        m10191a(this.f7961p, this.f7948c);
                    }
                } else if ((message.obj instanceof Long) && ((Long) message.obj).longValue() > 0) {
                    this.f7948c = ((Long) message.obj).longValue();
                }
            }
        }
    }

    /* renamed from: H */
    private boolean m10183H() throws Throwable {
        WeakReference<Context> weakReference = this.f7946a;
        if (weakReference == null || weakReference.get() == null || m10186K() == null) {
            return true;
        }
        SSMediaPlayerWrapper dVar = this.f7959n;
        if (dVar == null || dVar.mo16055a() == null) {
            return true;
        }
        MaterialMeta kVar = this.f7947b;
        if (kVar == null || kVar.mo15510x() != null || this.f7947b.mo15485h() == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0123 A[Catch:{ all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0141 A[Catch:{ all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0154 A[Catch:{ all -> 0x018e }] */
    /* renamed from: I */
    private void m10184I() {
        /*
        r15 = this;
        java.lang.String r0 = ",videoWidth="
        java.lang.String r1 = "changeVideoSize"
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x018e }
        r2.<init>()     // Catch:{ all -> 0x018e }
        java.lang.String r3 = "changeVideoSize start.......mMaterialMeta.getAdSlot()="
        r2.append(r3)     // Catch:{ all -> 0x018e }
        com.bytedance.sdk.openadsdk.core.d.k r3 = r15.f7947b     // Catch:{ all -> 0x018e }
        com.bytedance.sdk.openadsdk.AdSlot r3 = r3.mo15492j()     // Catch:{ all -> 0x018e }
        r2.append(r3)     // Catch:{ all -> 0x018e }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x018e }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12222c(r1, r2)     // Catch:{ all -> 0x018e }
        boolean r2 = r15.m10183H()     // Catch:{ all -> 0x018e }
        if (r2 == 0) goto L_0x0025
        return
    L_0x0025:
        java.lang.String r2 = "changeVideoSize start check condition complete ... go .."
        com.bytedance.sdk.openadsdk.utils.C2564t.m12222c(r1, r2)     // Catch:{ all -> 0x018e }
        android.content.Context r2 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10059a()     // Catch:{ all -> 0x018e }
        int[] r2 = com.bytedance.sdk.openadsdk.utils.UIUtils.m12076b(r2)     // Catch:{ all -> 0x018e }
        com.bytedance.sdk.openadsdk.core.video.c.d r3 = r15.f7959n     // Catch:{ all -> 0x018e }
        android.media.MediaPlayer r3 = r3.mo16055a()     // Catch:{ all -> 0x018e }
        com.bytedance.sdk.openadsdk.core.d.k r4 = r15.f7947b     // Catch:{ all -> 0x018e }
        int r4 = r4.mo15429Q()     // Catch:{ all -> 0x018e }
        r5 = 15
        r6 = 0
        r7 = 1
        if (r4 != r5) goto L_0x0046
        r4 = 1
        goto L_0x0047
    L_0x0046:
        r4 = 0
    L_0x0047:
        r5 = r2[r6]     // Catch:{ all -> 0x018e }
        float r9 = (float) r5     // Catch:{ all -> 0x018e }
        r2 = r2[r7]     // Catch:{ all -> 0x018e }
        float r10 = (float) r2     // Catch:{ all -> 0x018e }
        int r2 = r3.getVideoWidth()     // Catch:{ all -> 0x018e }
        float r11 = (float) r2     // Catch:{ all -> 0x018e }
        int r2 = r3.getVideoHeight()     // Catch:{ all -> 0x018e }
        float r12 = (float) r2     // Catch:{ all -> 0x018e }
        if (r4 == 0) goto L_0x0068
        int r2 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
        if (r2 <= 0) goto L_0x0077
        java.lang.String r0 = "横转竖屏单独适配....."
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r1, r0)     // Catch:{ all -> 0x018e }
        r13 = 1
        r8 = r15
        r8.m10190a(r9, r10, r11, r12, r13)     // Catch:{ all -> 0x018e }
        return
    L_0x0068:
        int r2 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
        if (r2 >= 0) goto L_0x0077
        java.lang.String r0 = "竖屏转横单独适配....."
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r1, r0)     // Catch:{ all -> 0x018e }
        r13 = 0
        r8 = r15
        r8.m10190a(r9, r10, r11, r12, r13)     // Catch:{ all -> 0x018e }
        return
    L_0x0077:
        float r2 = r11 / r12
        float r3 = r9 / r10
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x018e }
        r5.<init>()     // Catch:{ all -> 0x018e }
        java.lang.String r8 = "screenHeight="
        r5.append(r8)     // Catch:{ all -> 0x018e }
        r5.append(r10)     // Catch:{ all -> 0x018e }
        java.lang.String r8 = ",screenWidth="
        r5.append(r8)     // Catch:{ all -> 0x018e }
        r5.append(r9)     // Catch:{ all -> 0x018e }
        java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x018e }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r1, r5)     // Catch:{ all -> 0x018e }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x018e }
        r5.<init>()     // Catch:{ all -> 0x018e }
        java.lang.String r8 = "videoHeight="
        r5.append(r8)     // Catch:{ all -> 0x018e }
        r5.append(r12)     // Catch:{ all -> 0x018e }
        r5.append(r0)     // Catch:{ all -> 0x018e }
        r5.append(r11)     // Catch:{ all -> 0x018e }
        java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x018e }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r1, r5)     // Catch:{ all -> 0x018e }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x018e }
        r5.<init>()     // Catch:{ all -> 0x018e }
        java.lang.String r8 = "视频宽高比,videoScale="
        r5.append(r8)     // Catch:{ all -> 0x018e }
        r5.append(r2)     // Catch:{ all -> 0x018e }
        java.lang.String r8 = ",屏幕宽高比.screenScale="
        r5.append(r8)     // Catch:{ all -> 0x018e }
        r5.append(r3)     // Catch:{ all -> 0x018e }
        java.lang.String r8 = ",VERTICAL_SCALE(9:16)="
        r5.append(r8)     // Catch:{ all -> 0x018e }
        r8 = 1058013184(0x3f100000, float:0.5625)
        r5.append(r8)     // Catch:{ all -> 0x018e }
        java.lang.String r13 = ",HORIZONTAL_SCALE(16:9) ="
        r5.append(r13)     // Catch:{ all -> 0x018e }
        r13 = 1071877689(0x3fe38e39, float:1.7777778)
        r5.append(r13)     // Catch:{ all -> 0x018e }
        java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x018e }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r1, r5)     // Catch:{ all -> 0x018e }
        r5 = 1098907648(0x41800000, float:16.0)
        r14 = 1091567616(0x41100000, float:9.0)
        if (r4 == 0) goto L_0x00f7
        int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
        if (r3 >= 0) goto L_0x0105
        int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
        if (r2 != 0) goto L_0x0105
        float r14 = r14 * r10
        float r2 = r14 / r5
        r11 = r2
        r2 = r10
        goto L_0x0107
    L_0x00f7:
        int r3 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
        if (r3 <= 0) goto L_0x0105
        int r2 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
        if (r2 != 0) goto L_0x0105
        float r14 = r14 * r9
        float r2 = r14 / r5
        r11 = r9
        goto L_0x0107
    L_0x0105:
        r2 = r12
        r7 = 0
    L_0x0107:
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x018e }
        r3.<init>()     // Catch:{ all -> 0x018e }
        java.lang.String r4 = "适配后宽高：videoHeight="
        r3.append(r4)     // Catch:{ all -> 0x018e }
        r3.append(r2)     // Catch:{ all -> 0x018e }
        r3.append(r0)     // Catch:{ all -> 0x018e }
        r3.append(r11)     // Catch:{ all -> 0x018e }
        java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x018e }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12222c(r1, r0)     // Catch:{ all -> 0x018e }
        if (r7 != 0) goto L_0x0141
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x018e }
        r0.<init>()     // Catch:{ all -> 0x018e }
        java.lang.String r2 = " 屏幕比例和视频比例相同，以及其他情况都按照屏幕宽高播放，videoHeight="
        r0.append(r2)     // Catch:{ all -> 0x018e }
        r0.append(r10)     // Catch:{ all -> 0x018e }
        java.lang.String r2 = "，videoWidth="
        r0.append(r2)     // Catch:{ all -> 0x018e }
        r0.append(r9)     // Catch:{ all -> 0x018e }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x018e }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12222c(r1, r0)     // Catch:{ all -> 0x018e }
        r2 = r10
        goto L_0x0142
    L_0x0141:
        r9 = r11
    L_0x0142:
        android.widget.RelativeLayout$LayoutParams r0 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x018e }
        int r3 = (int) r9     // Catch:{ all -> 0x018e }
        int r2 = (int) r2     // Catch:{ all -> 0x018e }
        r0.<init>(r3, r2)     // Catch:{ all -> 0x018e }
        r4 = 13
        r0.addRule(r4)     // Catch:{ all -> 0x018e }
        com.bytedance.sdk.openadsdk.core.video.renderview.b r4 = r15.m10186K()     // Catch:{ all -> 0x018e }
        if (r4 == 0) goto L_0x0188
        com.bytedance.sdk.openadsdk.core.video.renderview.b r4 = r15.m10186K()     // Catch:{ all -> 0x018e }
        boolean r4 = r4 instanceof android.view.TextureView     // Catch:{ all -> 0x018e }
        if (r4 == 0) goto L_0x0166
        com.bytedance.sdk.openadsdk.core.video.renderview.b r4 = r15.m10186K()     // Catch:{ all -> 0x018e }
        android.view.TextureView r4 = (android.view.TextureView) r4     // Catch:{ all -> 0x018e }
        r4.setLayoutParams(r0)     // Catch:{ all -> 0x018e }
        goto L_0x0177
    L_0x0166:
        com.bytedance.sdk.openadsdk.core.video.renderview.b r4 = r15.m10186K()     // Catch:{ all -> 0x018e }
        boolean r4 = r4 instanceof android.view.SurfaceView     // Catch:{ all -> 0x018e }
        if (r4 == 0) goto L_0x0177
        com.bytedance.sdk.openadsdk.core.video.renderview.b r4 = r15.m10186K()     // Catch:{ all -> 0x018e }
        android.view.SurfaceView r4 = (android.view.SurfaceView) r4     // Catch:{ all -> 0x018e }
        r4.setLayoutParams(r0)     // Catch:{ all -> 0x018e }
    L_0x0177:
        android.view.ViewGroup r0 = r15.f7955j     // Catch:{ all -> 0x018e }
        android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()     // Catch:{ all -> 0x018e }
        if (r0 == 0) goto L_0x0188
        r0.height = r2     // Catch:{ all -> 0x018e }
        r0.width = r3     // Catch:{ all -> 0x018e }
        android.view.ViewGroup r2 = r15.f7955j     // Catch:{ all -> 0x018e }
        r2.setLayoutParams(r0)     // Catch:{ all -> 0x018e }
    L_0x0188:
        java.lang.String r0 = "changeVideoSize .... complete ... end !!!"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r1, r0)     // Catch:{ all -> 0x018e }
        goto L_0x0194
    L_0x018e:
        r0 = move-exception
        java.lang.String r2 = "changeSize error"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12223c(r1, r2, r0)
    L_0x0194:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.p176b.BaseVideoController.m10184I():void");
    }

    /* renamed from: J */
    private void m10185J() {
        String str = "changeVideoSize";
        try {
            if (!(this.f7946a == null || this.f7946a.get() == null || m10186K() == null || this.f7959n == null || this.f7959n.mo16055a() == null)) {
                if (this.f7947b != null) {
                    boolean z = this.f7947b.mo15429Q() == 15;
                    int[] b = UIUtils.m12076b(InternalContainer.m10059a());
                    float f = (float) b[0];
                    float f2 = (float) b[1];
                    MediaPlayer a = this.f7959n.mo16055a();
                    m10190a(f, f2, (float) a.getVideoWidth(), (float) a.getVideoHeight(), z);
                    C2564t.m12220b(str, "changeSize=end");
                }
            }
        } catch (Throwable th) {
            C2564t.m12216a(str, "changeSize error", th);
        }
    }

    /* renamed from: a */
    private void m10190a(float f, float f2, float f3, float f4, boolean z) {
        LayoutParams layoutParams;
        String str = "changeVideoSize";
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("screenWidth=");
            sb.append(f);
            sb.append(",screenHeight=");
            sb.append(f2);
            C2564t.m12220b(str, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("videoHeight=");
            sb2.append(f4);
            sb2.append(",videoWidth=");
            sb2.append(f3);
            C2564t.m12220b(str, sb2.toString());
            if (f3 <= 0.0f || f4 <= 0.0f) {
                f3 = (float) this.f7947b.mo15512z().mo15590b();
                f4 = (float) this.f7947b.mo15512z().mo15585a();
            }
            if (f4 > 0.0f) {
                if (f3 > 0.0f) {
                    if (z) {
                        if (f3 >= f4) {
                            C2564t.m12220b(str, "竖屏模式下按视频宽度计算放大倍数值");
                            LayoutParams layoutParams2 = new LayoutParams((int) f, (int) ((f4 * f) / f3));
                            layoutParams2.addRule(13);
                            layoutParams = layoutParams2;
                        } else {
                            return;
                        }
                    } else if (f3 <= f4) {
                        C2564t.m12220b(str, "横屏模式下按视频高度计算放大倍数值");
                        layoutParams = new LayoutParams((int) ((f3 * f2) / f4), (int) f2);
                        layoutParams.addRule(13);
                    } else {
                        return;
                    }
                    if (m10186K() != null) {
                        if (m10186K() instanceof TextureView) {
                            ((TextureView) m10186K()).setLayoutParams(layoutParams);
                        } else if (m10186K() instanceof SurfaceView) {
                            ((SurfaceView) m10186K()).setLayoutParams(layoutParams);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            C2564t.m12216a(str, "changeSize error", th);
        }
    }

    /* renamed from: a */
    public void mo15956a(IMediaLayout bVar, View view) {
        if (this.f7959n != null && m10181F()) {
            if (this.f7959n.mo16067g()) {
                mo15984h();
                this.f7954i.mo16190b(true, false);
                this.f7954i.mo16156c();
            } else if (!this.f7959n.mo16069i()) {
                NativeVideoLayout hVar = this.f7954i;
                if (hVar != null) {
                    hVar.mo16192c(this.f7955j);
                }
                mo15976d(this.f7961p);
                NativeVideoLayout hVar2 = this.f7954i;
                if (hVar2 != null) {
                    hVar2.mo16190b(false, false);
                }
            } else {
                mo15986j();
                NativeVideoLayout hVar3 = this.f7954i;
                if (hVar3 != null) {
                    hVar3.mo16190b(false, false);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo15951a(IMediaLayout bVar, int i) {
        if (this.f7959n != null) {
            m10179D();
            m10192a(this.f7942K, m10202c(i));
        }
    }

    /* renamed from: b */
    public void mo15967b(IMediaLayout bVar, int i) {
        if (this.f7959n != null) {
            m10180E();
        }
        NativeVideoLayout hVar = this.f7954i;
        if (hVar != null) {
            hVar.mo16156c();
        }
    }

    /* renamed from: a */
    public void mo15952a(IMediaLayout bVar, int i, boolean z) {
        if (m10181F()) {
            long l = (long) ((((float) (((long) i) * this.f7948c)) * 1.0f) / ((float) ResourceHelp.m11942l((Context) this.f7946a.get(), "tt_video_progress_max")));
            if (this.f7948c > 0) {
                this.f7942K = (long) ((int) l);
            } else {
                this.f7942K = 0;
            }
            NativeVideoLayout hVar = this.f7954i;
            if (hVar != null) {
                hVar.mo16142a(this.f7942K);
            }
        }
    }

    /* renamed from: a */
    private void m10191a(long j, long j2) {
        this.f7961p = j;
        this.f7948c = j2;
        this.f7954i.mo16143a(j, j2);
        this.f7954i.mo16141a(MediaHelper.m10402a(j, j2));
        try {
            if (this.f7960o != null) {
                this.f7960o.mo14913a(j, j2);
            }
        } catch (Throwable th) {
            C2564t.m12223c("BaseVideoController", "onProgressUpdate error: ", th);
        }
    }

    /* renamed from: b */
    public void mo15970b(IMediaLayout bVar, View view) {
        mo15971b(bVar, view, false, false);
    }

    /* renamed from: b */
    public void mo15971b(IMediaLayout bVar, View view, boolean z, boolean z2) {
        if (m10181F()) {
            m10208g(!this.f7941J);
            if (!(this.f7946a.get() instanceof Activity)) {
                C2564t.m12220b("BaseVideoController", "context is not activity, not support this function.");
                return;
            }
            if (this.f7941J) {
                mo15949a(z ? 8 : 0);
                NativeVideoLayout hVar = this.f7954i;
                if (hVar != null) {
                    hVar.mo16146a(this.f7955j);
                    this.f7954i.mo16154b(false);
                }
            } else {
                mo15949a(1);
                NativeVideoLayout hVar2 = this.f7954i;
                if (hVar2 != null) {
                    hVar2.mo16153b(this.f7955j);
                    this.f7954i.mo16154b(false);
                }
            }
            WeakReference<IVideoFullscreen> weakReference = this.f7934C;
            IVideoFullscreen eVar = weakReference != null ? (IVideoFullscreen) weakReference.get() : null;
            if (eVar != null) {
                eVar.mo14985a(this.f7941J);
            }
        }
    }

    /* renamed from: a */
    public void mo15949a(int i) {
        if (m10181F()) {
            boolean z = i == 0 || i == 8;
            Context context = (Context) this.f7946a.get();
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
        NativeVideoLayout hVar = this.f7954i;
        if (hVar != null) {
            hVar.mo16161g();
        }
        mo15964a(true);
    }

    /* renamed from: a */
    public void mo15958a(IMediaLayout bVar, View view, boolean z, boolean z2) {
        if (this.f7968w) {
            mo15984h();
        }
        if (z && !this.f7968w && !mo16001y()) {
            this.f7954i.mo16190b(!mo16002z(), false);
            this.f7954i.mo16151a(z2, true, false);
        }
        SSMediaPlayerWrapper dVar = this.f7959n;
        if (dVar == null || !dVar.mo16067g()) {
            this.f7954i.mo16156c();
            return;
        }
        this.f7954i.mo16156c();
        this.f7954i.mo16152b();
    }

    /* renamed from: d */
    public void mo15977d(IMediaLayout bVar, View view) {
        if (this.f7941J) {
            m10208g(false);
            NativeVideoLayout hVar = this.f7954i;
            if (hVar != null) {
                hVar.mo16153b(this.f7955j);
            }
            mo15949a(1);
            return;
        }
        mo15964a(true);
    }

    /* renamed from: e */
    public void mo15979e(IMediaLayout bVar, View view) {
        mo15957a(bVar, view, false);
    }

    /* renamed from: g */
    private void m10208g(boolean z) {
        this.f7941J = z;
    }

    /* renamed from: a */
    public void mo15954a(IMediaLayout bVar, SurfaceHolder surfaceHolder) {
        this.f7964s = true;
        SSMediaPlayerWrapper dVar = this.f7959n;
        if (dVar != null) {
            dVar.mo16058a(surfaceHolder);
            m10182G();
        }
    }

    /* renamed from: K */
    private IRenderView m10186K() {
        WeakReference<Context> weakReference = this.f7946a;
        if (!(weakReference == null || weakReference.get() == null)) {
            NativeVideoLayout hVar = this.f7954i;
            if (hVar != null) {
                return hVar.mo16197o();
            }
        }
        return null;
    }

    /* renamed from: b */
    public void mo15969b(IMediaLayout bVar, SurfaceHolder surfaceHolder) {
        this.f7964s = false;
    }

    /* renamed from: a */
    public void mo15953a(IMediaLayout bVar, SurfaceTexture surfaceTexture) {
        this.f7964s = true;
        SSMediaPlayerWrapper dVar = this.f7959n;
        if (dVar != null) {
            dVar.mo16057a(surfaceTexture);
            m10182G();
        }
    }

    /* renamed from: b */
    public void mo15968b(IMediaLayout bVar, SurfaceTexture surfaceTexture) {
        this.f7964s = false;
    }

    /* renamed from: y */
    public boolean mo16001y() {
        return this.f7959n.mo16072l();
    }

    /* renamed from: g */
    public void mo15983g() {
        NativeVideoLayout hVar = this.f7954i;
        if (hVar != null) {
            hVar.mo16152b();
            this.f7954i.mo16159e();
        }
        NativeVideoLayout hVar2 = this.f7954i;
        if (hVar2 != null) {
            hVar2.mo16203u();
        }
        mo15976d(-1);
        SSMediaPlayerWrapper dVar = this.f7959n;
        if (dVar != null) {
            dVar.mo16073m();
        }
    }

    /* renamed from: z */
    public boolean mo16002z() {
        SSMediaPlayerWrapper dVar = this.f7959n;
        return dVar != null && dVar.mo16067g();
    }

    /* renamed from: a */
    private void m10192a(long j, boolean z) {
        if (this.f7959n != null) {
            if (z) {
                m10187L();
            }
            this.f7959n.mo16056a(j);
        }
    }

    /* renamed from: c */
    private boolean m10202c(int i) {
        return this.f7954i.mo16155b(i);
    }

    /* renamed from: L */
    private void m10187L() {
        NativeVideoLayout hVar = this.f7954i;
        if (hVar != null) {
            hVar.mo16157c(0);
            this.f7954i.mo16150a(false, false);
            this.f7954i.mo16154b(false);
            this.f7954i.mo16152b();
            this.f7954i.mo16158d();
        }
    }

    /* renamed from: a */
    public void mo15962a(C2365a aVar, String str) {
        int i = C23026.f7977a[aVar.ordinal()];
        if (i == 1) {
            mo15984h();
        } else if (i == 2) {
            mo15964a(true);
        } else if (i == 3) {
            mo15986j();
            this.f7971z = false;
            this.f7932A = true;
        }
    }

    /* renamed from: d */
    private boolean m10203d(int i) {
        int c = C2566w.m12244c(InternalContainer.m10059a());
        if (c != 4 && c != 0) {
            mo15984h();
            this.f7971z = true;
            this.f7932A = false;
            NativeVideoLayout hVar = this.f7954i;
            if (hVar != null) {
                MaterialMeta kVar = this.f7947b;
                if (kVar != null) {
                    return hVar.mo16184a(i, kVar.mo15512z());
                }
            }
        } else if (c == 4) {
            this.f7971z = false;
            NativeVideoLayout hVar2 = this.f7954i;
            if (hVar2 != null) {
                hVar2.mo16199q();
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10199b(Context context) {
        if (m10181F()) {
            int c = C2566w.m12244c(context);
            if (this.f7944M != c) {
                if (!this.f7932A) {
                    m10203d(2);
                }
                this.f7944M = c;
            }
        }
    }

    /* renamed from: i */
    public void mo15985i() {
        SSMediaPlayerWrapper dVar = this.f7959n;
        if (dVar != null) {
            dVar.mo16064d();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public Map<String, Object> mo15947A() {
        HashMap hashMap = new HashMap();
        Map<String, Object> map = this.f7949d;
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Map a = ToolUtils.m11995a(this.f7951f, this.f7947b, mo15996t());
        if (a != null) {
            for (Entry entry2 : a.entrySet()) {
                hashMap.put(entry2.getKey(), entry2.getValue());
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: B */
    public Map<String, Object> mo15948B() {
        HashMap hashMap = new HashMap();
        Map a = ToolUtils.m11997a(this.f7947b, mo15990n(), mo15996t());
        if (a != null) {
            for (Entry entry : a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Map<String, Object> map = this.f7949d;
        if (map != null) {
            for (Entry entry2 : map.entrySet()) {
                hashMap.put(entry2.getKey(), entry2.getValue());
            }
        }
        return hashMap;
    }
}
