package com.bytedance.sdk.openadsdk.component.splash;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.bytedance.sdk.openadsdk.core.C2240g;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.NetApi;
import com.bytedance.sdk.openadsdk.core.NetApi.C2286a;
import com.bytedance.sdk.openadsdk.core.NetApi.C2287b;
import com.bytedance.sdk.openadsdk.core.p170d.AdInfo;
import com.bytedance.sdk.openadsdk.core.p170d.Image;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p170d.NetExtParams;
import com.bytedance.sdk.openadsdk.core.p170d.SplashAdCache;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.p185f.StatsLogManager;
import com.bytedance.sdk.openadsdk.p185f.p186a.LogStatsBase;
import com.bytedance.sdk.openadsdk.utils.C2538ak;
import com.bytedance.sdk.openadsdk.utils.C2538ak.C2539a;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.ImageBytesHelper;
import com.bytedance.sdk.openadsdk.utils.ImageBytesHelper.C2558a;
import com.tencent.p605ep.common.adapt.iservice.net.ESharkCode;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.component.splash.b */
public class SplashAdLoadManager implements C2539a {
    /* renamed from: j */
    private static Set<SplashAdLoadManager> f7087j = Collections.synchronizedSet(new HashSet());
    /* access modifiers changed from: private */
    /* renamed from: a */
    public AdSlot f7088a;
    /* renamed from: b */
    private NetExtParams f7089b;
    /* renamed from: c */
    private SplashAdListener f7090c = null;
    /* renamed from: d */
    private final NetApi f7091d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public Context f7092e;
    /* renamed from: f */
    private final C2538ak f7093f;
    /* access modifiers changed from: private|final */
    /* renamed from: g */
    public final AtomicBoolean f7094g = new AtomicBoolean(false);
    /* renamed from: h */
    private TTSplashAdImpl f7095h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public TTSplashAdImpl f7096i;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public SplashAdCacheManager f7097k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public AtomicBoolean f7098l = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    /* renamed from: m */
    public AtomicBoolean f7099m = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    /* renamed from: n */
    public AtomicBoolean f7100n = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    /* renamed from: o */
    public boolean f7101o;
    /* access modifiers changed from: private */
    /* renamed from: p */
    public long f7102p;
    /* access modifiers changed from: private */
    /* renamed from: q */
    public long f7103q;
    /* access modifiers changed from: private */
    /* renamed from: r */
    public long f7104r = 0;
    /* renamed from: s */
    private final AtomicBoolean f7105s = new AtomicBoolean(false);
    /* renamed from: t */
    private final AtomicBoolean f7106t = new AtomicBoolean(false);
    /* renamed from: u */
    private AtomicBoolean f7107u = new AtomicBoolean(false);
    /* renamed from: v */
    private AtomicBoolean f7108v = new AtomicBoolean(false);
    /* renamed from: w */
    private C2191a f7109w;

    /* compiled from: SplashAdLoadManager */
    /* renamed from: com.bytedance.sdk.openadsdk.component.splash.b$a */
    private class C2191a {
        /* renamed from: a */
        public int f7140a;
        /* renamed from: b */
        public int f7141b;
        /* renamed from: c */
        public String f7142c;
        /* renamed from: d */
        public TTSplashAd f7143d;
        /* renamed from: e */
        public LogStatsBase f7144e;

        public C2191a(int i, int i2, String str, TTSplashAd tTSplashAd, LogStatsBase dVar) {
            this.f7140a = i;
            this.f7141b = i2;
            this.f7142c = str;
            this.f7143d = tTSplashAd;
            this.f7144e = dVar;
        }
    }

    /* renamed from: a */
    public static SplashAdLoadManager m8915a(Context context) {
        return new SplashAdLoadManager(context);
    }

    private SplashAdLoadManager(Context context) {
        if (context != null) {
            this.f7092e = context.getApplicationContext();
        }
        this.f7091d = InternalContainer.m10067f();
        this.f7093f = new C2538ak(Looper.myLooper(), this);
        Context context2 = this.f7092e;
        if (context2 == null) {
            context2 = InternalContainer.m10059a();
        }
        this.f7097k = SplashAdCacheManager.m8869a(context2);
        this.f7101o = InternalContainer.m10069h().mo15816u();
        f7087j.add(this);
    }

    /* renamed from: a */
    public void mo15247a(AdSlot adSlot, SplashAdListener splashAdListener, int i) {
        this.f7088a = adSlot;
        this.f7090c = splashAdListener;
        this.f7094g.set(false);
        this.f7095h = null;
        this.f7096i = null;
        long j = (long) i;
        int c = InternalContainer.m10069h().mo15780c(adSlot.getCodeId());
        if (c == -1) {
            c = i;
        }
        if (c <= 0) {
            c = PathInterpolatorCompat.MAX_NUM_POINTS;
        }
        this.f7093f.sendEmptyMessageDelayed(2, (long) c);
        int i2 = c + ESharkCode.ERR_SHARK_DECODE;
        if (i2 > 0) {
            c = i2;
        }
        this.f7093f.sendEmptyMessageDelayed(3, (long) c);
        this.f7089b = new NetExtParams();
        this.f7089b.f7455f = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("publisher_timeout_control", j);
        } catch (Throwable unused) {
        }
        StatsLogManager.m11278a().mo16570b(LogStatsBase.m11308b().mo16590a(3).mo16595c(this.f7088a.getCodeId()).mo16601f(this.f7089b.f7450a).mo16593b(jSONObject.toString()));
        m8921a();
    }

    /* renamed from: a */
    private void m8921a() {
        if (this.f7090c != null) {
            int r = InternalContainer.m10069h().mo15811r();
            String str = "splashLoadAd";
            if (r == 0) {
                this.f7105s.set(false);
                this.f7106t.set(false);
                C2564t.m12220b(str, "splash_type_real_time=====只走实时");
                m8923a(this.f7088a);
            } else if (r == 1) {
                this.f7105s.set(false);
                this.f7106t.set(false);
                C2564t.m12220b(str, "splash_type_priorrity_cache_defualt=====优先缓存");
                if (!m8937b()) {
                    C2564t.m12222c(str, "splash_type_priorrity_cache_defualt=====优先缓存--->执行缓存失败，进行网络请求");
                    m8923a(this.f7088a);
                } else {
                    C2564t.m12222c(str, "splash_type_priorrity_cache_defualt=====优先缓存--->执行缓存成功！！");
                }
            } else if (r != 2) {
                if (r == 3) {
                    this.f7105s.set(false);
                    this.f7106t.set(true);
                    C2564t.m12220b(str, "splash_type_concurrent_first_come_first_use=====并发请求广告和check缓存，谁先到用谁");
                    m8923a(this.f7088a);
                    m8937b();
                }
            } else {
                C2564t.m12220b(str, "splash_type_concurrent_priority_real_time=====并发请求广告和check缓存，优先使用实时");
                this.f7105s.set(true);
                this.f7106t.set(false);
                m8923a(this.f7088a);
                m8937b();
            }
        }
    }

    /* renamed from: b */
    private boolean m8937b() {
        String str = "splashLoadAd";
        C2564t.m12226e(str, "try checkSpashAdCacheIsValidAndTryShowAd......");
        LogStatsBase a = m8919a(15001, (SplashAdCache) null);
        if (!this.f7097k.mo15234b(this.f7088a.getCodeId()) && !this.f7097k.mo15231a(this.f7088a.getCodeId())) {
            C2564t.m12226e(str, "没有缓存数据..........");
            if (this.f7105s.get() || this.f7106t.get()) {
                C2191a aVar = new C2191a(2, -12, C2240g.m9576a(-12), null, a);
                m8922a(15001, aVar, (SplashAdCache) null, (TTSplashAdImpl) null, (String) null);
            }
            return false;
        } else if (this.f7097k.mo15230a(this.f7088a, true)) {
            SplashUtils.m8966a(this.f7092e, this.f7088a);
            C2564t.m12220b(str, "======== 缓存过期 ========");
            if (this.f7105s.get() || this.f7106t.get()) {
                C2191a aVar2 = new C2191a(2, -11, C2240g.m9576a(-11), null, a);
                m8922a(15001, aVar2, (SplashAdCache) null, (TTSplashAdImpl) null, (String) null);
            }
            return false;
        } else {
            m8940d();
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m8939c() {
        int r = InternalContainer.m10069h().mo15811r();
        return (2 == r || 3 == r) ? false : true;
    }

    /* renamed from: d */
    private void m8940d() {
        if (this.f7097k.mo15234b(this.f7088a.getCodeId())) {
            this.f7097k.mo15229a(this.f7088a.getCodeId(), (C2179b) new C2179b() {
                /* renamed from: a */
                public void mo15242a(SplashAdCache nVar) {
                    if (nVar.mo15545a() == null || nVar.mo15545a().mo15512z() == null || nVar.mo15545a().mo15512z().mo15603g() == null) {
                        SplashAdLoadManager.this.m8943e();
                    } else {
                        String a = SplashAdLoadManager.this.f7097k.mo15222a(nVar.mo15545a());
                        if (a == null) {
                            SplashAdLoadManager.this.m8943e();
                            return;
                        }
                        LogStatsBase a2 = SplashAdLoadManager.this.m8919a(4, nVar);
                        TTSplashAdImpl a3 = SplashAdLoadManager.this.m8918a(nVar, a);
                        SplashAdLoadManager.this.f7100n.set(nVar.mo15545a().mo15510x() == null);
                        if (SplashAdLoadManager.this.f7101o) {
                            SplashAdLoadManager.this.m8931a(nVar, a3, a);
                        } else {
                            SplashAdLoadManager.this.f7098l.set(true);
                            StringBuilder sb = new StringBuilder();
                            sb.append("不检测直接返回缓存....splashAd=");
                            sb.append(a3);
                            C2564t.m12222c("splashLoadAd", sb.toString());
                            SplashAdLoadManager bVar = SplashAdLoadManager.this;
                            C2191a aVar = new C2191a(1, 0, null, a3, a2);
                            bVar.m8922a(15001, aVar, nVar, a3, a);
                        }
                        if (nVar.mo15545a().mo15510x() != null) {
                            SplashAdLoadManager.this.m8932a(nVar, a3, a, a2);
                        }
                    }
                }

                /* renamed from: a */
                public void mo15241a() {
                    SplashAdLoadManager.this.m8943e();
                }
            });
        } else {
            m8943e();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public LogStatsBase m8919a(int i, SplashAdCache nVar) {
        String str;
        String str2;
        String str3 = null;
        if (nVar == null || nVar.mo15545a() == null) {
            str = null;
            str2 = null;
        } else {
            str2 = nVar.mo15545a().mo15425M();
            str = nVar.mo15545a().mo15428P();
            if (!TextUtils.isEmpty(str)) {
                try {
                    str3 = new JSONObject(str).getString("req_id");
                } catch (Throwable unused) {
                }
            }
        }
        if (str3 == null) {
            str3 = this.f7089b.f7450a;
        }
        LogStatsBase c = LogStatsBase.m11308b().mo16601f(str3).mo16590a(i).mo16595c(this.f7088a.getCodeId());
        if (str2 != null) {
            c.mo16597d(str2);
        }
        if (str != null) {
            c.mo16605h(str);
        }
        return c;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m8943e() {
        this.f7097k.mo15233b(this.f7088a.getCodeId(), (C2179b) new C2179b() {
            /* renamed from: a */
            public void mo15242a(SplashAdCache nVar) {
                LogStatsBase a = SplashAdLoadManager.this.m8919a(4, nVar);
                if (SplashUtils.m8975b(nVar)) {
                    nVar.mo15545a().mo15470c(true);
                    boolean z = false;
                    nVar.mo15545a().mo15474d(false);
                    AtomicBoolean c = SplashAdLoadManager.this.f7100n;
                    if (nVar.mo15545a().mo15510x() == null) {
                        z = true;
                    }
                    c.set(z);
                    TTSplashAdImpl a2 = SplashAdLoadManager.this.m8918a(nVar, (String) null);
                    if (SplashAdLoadManager.this.f7101o) {
                        SplashAdLoadManager.this.m8931a(nVar, a2, (String) null);
                    } else {
                        C2564t.m12222c("splashLoadAd", ".....不检测直接返回缓存....");
                        SplashAdLoadManager.this.f7098l.set(true);
                        SplashAdLoadManager bVar = SplashAdLoadManager.this;
                        TTSplashAdImpl eVar = a2;
                        C2191a aVar = new C2191a(1, 0, null, eVar, a);
                        bVar.m8922a(15001, aVar, nVar, eVar, (String) null);
                    }
                    if (nVar.mo15545a().mo15510x() != null) {
                        SplashAdLoadManager.this.m8932a(nVar, a2, (String) null, a);
                    }
                } else if (SplashAdLoadManager.this.m8939c()) {
                    C2564t.m12220b("SplashAdLoadManager", "缓存广告素材解析出错");
                    SplashAdLoadManager bVar2 = SplashAdLoadManager.this;
                    bVar2.m8923a(bVar2.f7088a);
                } else {
                    SplashAdLoadManager bVar3 = SplashAdLoadManager.this;
                    C2191a aVar2 = new C2191a(2, 0, null, null, a);
                    bVar3.m8922a(15001, aVar2, nVar, (TTSplashAdImpl) null, (String) null);
                }
            }

            /* renamed from: a */
            public void mo15241a() {
                C2564t.m12220b("splashLoadAd", "缓存广告对象解析出错");
                if (SplashAdLoadManager.this.m8939c()) {
                    SplashAdLoadManager bVar = SplashAdLoadManager.this;
                    bVar.m8923a(bVar.f7088a);
                    return;
                }
                LogStatsBase a = SplashAdLoadManager.this.m8919a(4, (SplashAdCache) null);
                SplashAdLoadManager bVar2 = SplashAdLoadManager.this;
                C2191a aVar = new C2191a(2, 0, null, null, a);
                bVar2.m8922a(15001, aVar, (SplashAdCache) null, (TTSplashAdImpl) null, (String) null);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8923a(AdSlot adSlot) {
        C2564t.m12226e("splashLoadAd", "try LoadSplashAdFromNetwork......");
        final LogStatsBase a = m8919a(3, (SplashAdCache) null);
        if (InternalContainer.m10069h().mo15794i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f) {
            this.f7089b.f7454e = 2;
        }
        this.f7091d.mo15917a(adSlot, this.f7089b, 3, (C2287b) new C2287b() {
            /* renamed from: a */
            public void mo14946a(int i, String str) {
                a.mo16592b(i).mo16603g(str);
                SplashAdLoadManager bVar = SplashAdLoadManager.this;
                C2191a aVar = new C2191a(2, i, str, null, a);
                bVar.m8922a(15000, aVar, (SplashAdCache) null, (TTSplashAdImpl) null, (String) null);
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(i);
                C2564t.m12220b("splashLoadAd", sb.toString());
            }

            /* renamed from: a */
            public void mo14947a(AdInfo aVar) {
                if (aVar != null) {
                    a.mo16601f(aVar.mo15329a());
                }
                String str = "网络请求的广告解析失败";
                String str2 = "SplashAdLoadManager";
                if (SplashUtils.m8974b(aVar)) {
                    MaterialMeta kVar = (MaterialMeta) aVar.mo15336c().get(0);
                    String P = kVar.mo15428P();
                    String M = kVar.mo15425M();
                    if (!TextUtils.isEmpty(P)) {
                        a.mo16605h(P).mo16597d(M);
                        try {
                            a.mo16601f(new JSONObject(P).getString("req_id"));
                        } catch (Throwable unused) {
                        }
                    }
                    if (kVar.mo15455aa()) {
                        SplashAdLoadManager.this.f7102p = 0;
                        SplashAdLoadManager bVar = SplashAdLoadManager.this;
                        bVar.m8930a(aVar, bVar.f7092e, a);
                        return;
                    }
                    a.mo16592b(-3).mo16603g(C2240g.m9576a(-3));
                    C2191a aVar2 = new C2191a(2, -3, C2240g.m9576a(-3), null, a);
                    SplashAdLoadManager.this.m8922a(15000, aVar2, (SplashAdCache) null, (TTSplashAdImpl) null, (String) null);
                    C2564t.m12220b(str2, str);
                    return;
                }
                a.mo16592b(-3).mo16603g(C2240g.m9576a(-3));
                C2191a aVar3 = new C2191a(2, -3, C2240g.m9576a(-3), null, a);
                SplashAdLoadManager.this.m8922a(15000, aVar3, (SplashAdCache) null, (TTSplashAdImpl) null, (String) null);
                C2564t.m12220b(str2, str);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8930a(AdInfo aVar, Context context, LogStatsBase dVar) {
        if (SplashUtils.m8974b(aVar) && context != null) {
            int i = 0;
            final MaterialMeta kVar = (MaterialMeta) aVar.mo15336c().get(0);
            Image D = kVar.mo15416D();
            if (D == null) {
                D = (Image) kVar.mo15418F().get(0);
            }
            String a = D.mo15406a();
            int b = D.mo15409b();
            final boolean z = kVar.mo15512z() != null;
            this.f7103q = System.currentTimeMillis();
            this.f7104r = SystemClock.elapsedRealtime();
            if (z) {
                i = 2;
            }
            SplashUtils.m8970a(kVar, i);
            final AdInfo aVar2 = aVar;
            final LogStatsBase dVar2 = dVar;
            final String str = a;
            C21854 r2 = new C2558a() {
                /* renamed from: a */
                public void mo15240a(byte[] bArr) {
                    SplashUtils.m8968a(aVar2);
                    SplashUtils.m8969a(kVar);
                    String str = "splash_ad";
                    if (!z) {
                        AdEventManager.m8393a(kVar, str, "download_creative_duration", System.currentTimeMillis() - SplashAdLoadManager.this.f7103q);
                    }
                    if (bArr != null) {
                        boolean z = false;
                        kVar.mo15474d(false);
                        TTSplashAdImpl eVar = new TTSplashAdImpl(SplashAdLoadManager.this.f7092e, kVar, SplashAdLoadManager.this.f7088a, str);
                        SplashAdLoadManager.this.f7096i = eVar;
                        eVar.mo15251a(bArr);
                        AtomicBoolean j = SplashAdLoadManager.this.f7099m;
                        if (kVar.mo15510x() == null) {
                            z = true;
                        }
                        j.set(z);
                        C2191a aVar = new C2191a(1, 0, null, eVar, dVar2);
                        SplashAdLoadManager.this.m8922a(15000, aVar, (SplashAdCache) null, eVar, (String) null);
                        SplashAdLoadManager.this.m8936b(null, eVar, null, dVar2);
                        if (z) {
                            SplashUtils.m8964a(SplashAdLoadManager.this.f7104r, false, true, kVar, 0, null);
                            return;
                        }
                        return;
                    }
                    SplashUtils.m8971a(dVar2, str);
                    dVar2.mo16592b(-7).mo16603g(C2240g.m9576a(-7));
                    C2191a aVar2 = new C2191a(2, -7, C2240g.m9576a(-7), null, dVar2);
                    SplashAdLoadManager.this.m8922a(15000, aVar2, (SplashAdCache) null, (TTSplashAdImpl) null, (String) null);
                    if (z) {
                        SplashUtils.m8964a(SplashAdLoadManager.this.f7104r, false, false, kVar, (long) -7, null);
                    }
                    C2564t.m12220b("SplashAdLoadManager", "图片加载失败");
                }

                /* renamed from: a */
                public void mo15239a() {
                    SplashUtils.m8968a(aVar2);
                    SplashUtils.m8971a(dVar2, str);
                    dVar2.mo16592b(-7).mo16603g(C2240g.m9576a(-7));
                    StringBuilder sb = new StringBuilder();
                    sb.append("splashLoad----5-LoadImageBytes-onFailed-code=");
                    sb.append(-7);
                    sb.append(",msg=");
                    sb.append(C2240g.m9576a(-7));
                    C2564t.m12220b("splashLoadAd", sb.toString());
                    SplashAdLoadManager bVar = SplashAdLoadManager.this;
                    C2191a aVar = new C2191a(2, -7, C2240g.m9576a(-7), null, dVar2);
                    bVar.m8922a(15000, aVar, (SplashAdCache) null, (TTSplashAdImpl) null, (String) null);
                    if (z) {
                        SplashUtils.m8964a(SplashAdLoadManager.this.f7104r, false, false, kVar, -7, null);
                    }
                    C2564t.m12220b("SplashAdLoadManager", "图片加载失败");
                }
            };
            ImageBytesHelper.m12184a(context, a, b, r2);
        }
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* renamed from: a */
    public synchronized void m8932a(SplashAdCache nVar, TTSplashAdImpl eVar, String str, LogStatsBase dVar) {
        if (eVar != null) {
            final TTSplashAdImpl eVar2 = eVar;
            final SplashAdCache nVar2 = nVar;
            final LogStatsBase dVar2 = dVar;
            final String str2 = str;
            C21865 r0 = new ExpressAdInteractionListener() {
                public void onAdClicked(View view, int i) {
                }

                public void onAdShow(View view, int i) {
                }

                public void onRenderFail(View view, String str, int i) {
                    SplashAdLoadManager.this.f7100n.set(true);
                    StringBuilder sb = new StringBuilder();
                    sb.append("缓存模版渲染--》onRenderFail start....splashAd=");
                    sb.append(eVar2);
                    C2564t.m12220b("splashLoadAd", sb.toString());
                    int i2 = nVar2 == null ? 15000 : 15001;
                    SplashAdLoadManager bVar = SplashAdLoadManager.this;
                    C2191a aVar = new C2191a(1, 0, null, eVar2, dVar2);
                    bVar.m8922a(i2, aVar, nVar2, eVar2, str2);
                }

                public void onRenderSuccess(View view, float f, float f2) {
                    SplashAdLoadManager.this.f7100n.set(true);
                    int i = nVar2 == null ? 15000 : 15001;
                    StringBuilder sb = new StringBuilder();
                    sb.append("缓存模版渲染--》onRenderSuccess start....=");
                    sb.append(i == 15000 ? "实时" : "缓存");
                    C2564t.m12220b("splashLoadAd", sb.toString());
                    SplashAdLoadManager bVar = SplashAdLoadManager.this;
                    C2191a aVar = new C2191a(1, 0, null, eVar2, dVar2);
                    bVar.m8922a(i, aVar, nVar2, eVar2, str2);
                }
            };
            eVar.renderExpressAd(r0);
        }
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* renamed from: b */
    public synchronized void m8936b(SplashAdCache nVar, TTSplashAdImpl eVar, String str, LogStatsBase dVar) {
        if (eVar != null) {
            final TTSplashAdImpl eVar2 = eVar;
            final SplashAdCache nVar2 = nVar;
            final LogStatsBase dVar2 = dVar;
            final String str2 = str;
            C21876 r0 = new ExpressAdInteractionListener() {
                public void onAdClicked(View view, int i) {
                }

                public void onAdShow(View view, int i) {
                }

                public void onRenderFail(View view, String str, int i) {
                    SplashAdLoadManager.this.f7099m.set(true);
                    StringBuilder sb = new StringBuilder();
                    sb.append("实时模版渲染--》onRenderFail start....splashAd=");
                    sb.append(eVar2);
                    C2564t.m12220b("splashLoadAd", sb.toString());
                    int i2 = nVar2 == null ? 15000 : 15001;
                    SplashAdLoadManager bVar = SplashAdLoadManager.this;
                    C2191a aVar = new C2191a(1, 0, null, eVar2, dVar2);
                    bVar.m8922a(i2, aVar, nVar2, eVar2, str2);
                }

                public void onRenderSuccess(View view, float f, float f2) {
                    SplashAdLoadManager.this.f7099m.set(true);
                    int i = nVar2 == null ? 15000 : 15001;
                    StringBuilder sb = new StringBuilder();
                    sb.append("实时模版渲染--》onRenderSuccess start....=");
                    sb.append(i == 15000 ? "实时" : "缓存");
                    C2564t.m12220b("splashLoadAd", sb.toString());
                    SplashAdLoadManager bVar = SplashAdLoadManager.this;
                    C2191a aVar = new C2191a(1, 0, null, eVar2, dVar2);
                    bVar.m8922a(i, aVar, nVar2, eVar2, str2);
                }
            };
            eVar.renderExpressAd(r0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8931a(SplashAdCache nVar, TTSplashAdImpl eVar, String str) {
        String str2 = "splashLoadAd";
        C2564t.m12222c(str2, "执行 checkAdFromServer 检测缓存....");
        if (SplashUtils.m8972a(nVar)) {
            MaterialMeta a = nVar.mo15545a();
            final LogStatsBase a2 = m8919a(4, nVar);
            NetApi f = InternalContainer.m10067f();
            String M = a.mo15425M();
            String P = a.mo15428P();
            final TTSplashAdImpl eVar2 = eVar;
            final SplashAdCache nVar2 = nVar;
            final String str3 = str;
            C21887 r3 = new C2286a() {
                /* renamed from: a */
                public void mo15248a(boolean z, long j, long j2) {
                    SplashUtils.m8967a(SplashAdLoadManager.this.f7088a, z, j, j2);
                    String str = "splashLoadAd";
                    if (z && !SplashAdLoadManager.this.f7094g.get()) {
                        C2564t.m12220b(str, "check 成功回调.......");
                        SplashAdLoadManager.this.f7098l.set(true);
                        SplashAdLoadManager bVar = SplashAdLoadManager.this;
                        C2191a aVar = new C2191a(1, 0, null, eVar2, a2);
                        bVar.m8922a(15001, aVar, nVar2, eVar2, str3);
                    } else if (SplashAdLoadManager.this.m8939c()) {
                        C2564t.m12220b("SplashAdLoadManager", "开屏视频缓存广告不在投放期或本次调用已回调出去");
                        SplashAdLoadManager bVar2 = SplashAdLoadManager.this;
                        bVar2.m8923a(bVar2.f7088a);
                    } else {
                        C2564t.m12220b(str, "并发请求开屏视频check 失败 无需再网络请求");
                        int i = (int) j;
                        a2.mo16592b(i).mo16603g(C2240g.m9576a(i));
                        SplashAdLoadManager bVar3 = SplashAdLoadManager.this;
                        C2191a aVar2 = new C2191a(2, 0, null, null, a2);
                        bVar3.m8922a(15001, aVar2, nVar2, (TTSplashAdImpl) null, (String) null);
                    }
                }
            };
            f.mo15919a(M, P, r3);
            return;
        }
        C2564t.m12220b(str2, "checkAdFromServer check fail !!!!");
        if (m8939c()) {
            C2564t.m12220b(str2, "checkAdFromServer check fail !!!! ---> tryLoadSplashAdFromNetwork !!!");
            m8923a(this.f7088a);
            return;
        }
        LogStatsBase a3 = m8919a(4, (SplashAdCache) null);
        C2564t.m12220b(str2, "checkAdFromServer check fail !!!! ---> return callback !!!");
        C2191a aVar = new C2191a(2, 0, null, null, a3);
        m8922a(15001, aVar, nVar, (TTSplashAdImpl) null, (String) null);
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x025f, code lost:
            return;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:106:0x01c3=Splitter:B:106:0x01c3, B:46:0x00eb=Splitter:B:46:0x00eb} */
    /* renamed from: a */
    public synchronized void m8922a(int r9, com.bytedance.sdk.openadsdk.component.splash.SplashAdLoadManager.C2191a r10, com.bytedance.sdk.openadsdk.core.p170d.SplashAdCache r11, com.bytedance.sdk.openadsdk.component.splash.TTSplashAdImpl r12, java.lang.String r13) {
        /*
        r8 = this;
        monitor-enter(r8)
        r0 = 15004(0x3a9c, float:2.1025E-41)
        r1 = 15003(0x3a9b, float:2.1024E-41)
        r2 = 15001(0x3a99, float:2.1021E-41)
        r3 = 1
        r4 = 15000(0x3a98, float:2.102E-41)
        if (r9 != r4) goto L_0x002b
        java.lang.String r5 = "splashLoadAd"
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0028 }
        r6.<init>()     // Catch:{ all -> 0x0028 }
        java.lang.String r7 = "splashAdTryCallback start....实时请求来了！="
        r6.append(r7)     // Catch:{ all -> 0x0028 }
        r6.append(r12)     // Catch:{ all -> 0x0028 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0028 }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r5, r6)     // Catch:{ all -> 0x0028 }
        java.util.concurrent.atomic.AtomicBoolean r5 = r8.f7107u     // Catch:{ all -> 0x0028 }
        r5.set(r3)     // Catch:{ all -> 0x0028 }
        goto L_0x007a
    L_0x0028:
        r9 = move-exception
        goto L_0x0260
    L_0x002b:
        if (r9 != r2) goto L_0x0049
        java.lang.String r5 = "splashLoadAd"
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0028 }
        r6.<init>()     // Catch:{ all -> 0x0028 }
        java.lang.String r7 = "splashAdTryCallback start....缓存请求来了！="
        r6.append(r7)     // Catch:{ all -> 0x0028 }
        r6.append(r12)     // Catch:{ all -> 0x0028 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0028 }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r5, r6)     // Catch:{ all -> 0x0028 }
        java.util.concurrent.atomic.AtomicBoolean r5 = r8.f7108v     // Catch:{ all -> 0x0028 }
        r5.set(r3)     // Catch:{ all -> 0x0028 }
        goto L_0x007a
    L_0x0049:
        if (r9 != r0) goto L_0x0062
        java.lang.String r5 = "splashLoadAd"
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0028 }
        r6.<init>()     // Catch:{ all -> 0x0028 }
        java.lang.String r7 = "splashAdTryCallback start....超时请求来了！="
        r6.append(r7)     // Catch:{ all -> 0x0028 }
        r6.append(r12)     // Catch:{ all -> 0x0028 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0028 }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r5, r6)     // Catch:{ all -> 0x0028 }
        goto L_0x007a
    L_0x0062:
        if (r9 != r1) goto L_0x007a
        java.lang.String r5 = "splashLoadAd"
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0028 }
        r6.<init>()     // Catch:{ all -> 0x0028 }
        java.lang.String r7 = "splashAdTryCallback start....渲染超时请求来了！="
        r6.append(r7)     // Catch:{ all -> 0x0028 }
        r6.append(r12)     // Catch:{ all -> 0x0028 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0028 }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r5, r6)     // Catch:{ all -> 0x0028 }
    L_0x007a:
        java.util.concurrent.atomic.AtomicBoolean r5 = r8.f7094g     // Catch:{ all -> 0x0028 }
        boolean r5 = r5.get()     // Catch:{ all -> 0x0028 }
        if (r5 == 0) goto L_0x008b
        java.lang.String r9 = "splashLoadAd"
        java.lang.String r10 = "splashAdTryCallback mSplashAdHasLoad==true 已成功回调，不再执行回调操作！！！"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r9, r10)     // Catch:{ all -> 0x0028 }
        monitor-exit(r8)
        return
    L_0x008b:
        if (r12 != 0) goto L_0x017a
        java.util.concurrent.atomic.AtomicBoolean r11 = r8.f7105s     // Catch:{ all -> 0x0028 }
        boolean r11 = r11.get()     // Catch:{ all -> 0x0028 }
        if (r11 != 0) goto L_0x00a7
        java.util.concurrent.atomic.AtomicBoolean r11 = r8.f7106t     // Catch:{ all -> 0x0028 }
        boolean r11 = r11.get()     // Catch:{ all -> 0x0028 }
        if (r11 == 0) goto L_0x009e
        goto L_0x00a7
    L_0x009e:
        java.lang.String r9 = "splashLoadAd"
        java.lang.String r11 = "普通类型走这，直接失败回调"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12225d(r9, r11)     // Catch:{ all -> 0x0028 }
        goto L_0x0175
    L_0x00a7:
        if (r9 != r4) goto L_0x0104
        java.util.concurrent.atomic.AtomicBoolean r9 = r8.f7108v     // Catch:{ all -> 0x0028 }
        boolean r9 = r9.get()     // Catch:{ all -> 0x0028 }
        if (r9 != 0) goto L_0x00ba
        java.lang.String r9 = "splashLoadAd"
        java.lang.String r10 = "splashAdTryCallback 实时请求失败（实时先回，缓存还没回）...等待缓存"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12225d(r9, r10)     // Catch:{ all -> 0x0028 }
        monitor-exit(r8)
        return
    L_0x00ba:
        java.lang.String r9 = "splashLoadAd"
        java.lang.String r11 = "splashAdTryCallback 实时请求失败（缓存先回，实时后回）...."
        com.bytedance.sdk.openadsdk.utils.C2564t.m12225d(r9, r11)     // Catch:{ all -> 0x0028 }
        java.util.concurrent.atomic.AtomicBoolean r9 = r8.f7098l     // Catch:{ all -> 0x0028 }
        boolean r9 = r9.get()     // Catch:{ all -> 0x0028 }
        if (r9 == 0) goto L_0x00eb
        java.util.concurrent.atomic.AtomicBoolean r9 = r8.f7099m     // Catch:{ all -> 0x0028 }
        boolean r9 = r9.get()     // Catch:{ all -> 0x0028 }
        if (r9 != 0) goto L_0x00d9
        java.util.concurrent.atomic.AtomicBoolean r9 = r8.f7100n     // Catch:{ all -> 0x0028 }
        boolean r9 = r9.get()     // Catch:{ all -> 0x0028 }
        if (r9 == 0) goto L_0x00eb
    L_0x00d9:
        com.bytedance.sdk.openadsdk.component.splash.b$a r9 = r8.f7109w     // Catch:{ all -> 0x0028 }
        if (r9 == 0) goto L_0x00eb
        java.lang.String r9 = "splashLoadAd"
        java.lang.String r10 = "splashAdTryCallback 实时请求失败（缓存先回，实时后回）....尝试回调缓存成功！"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12225d(r9, r10)     // Catch:{ all -> 0x0028 }
        com.bytedance.sdk.openadsdk.component.splash.b$a r9 = r8.f7109w     // Catch:{ all -> 0x0028 }
        r8.m8924a(r9)     // Catch:{ all -> 0x0028 }
        monitor-exit(r8)
        return
    L_0x00eb:
        java.util.concurrent.atomic.AtomicBoolean r9 = r8.f7098l     // Catch:{ all -> 0x0028 }
        boolean r9 = r9.get()     // Catch:{ all -> 0x0028 }
        if (r9 == 0) goto L_0x0175
        java.util.concurrent.atomic.AtomicBoolean r9 = r8.f7100n     // Catch:{ all -> 0x0028 }
        boolean r9 = r9.get()     // Catch:{ all -> 0x0028 }
        if (r9 != 0) goto L_0x0175
        java.lang.String r9 = "splashLoadAd"
        java.lang.String r10 = "splashAdTryCallback 当为模版广告，存在缓存的情况下，模版渲染还没有回来时等待模版广告渲染回来！"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12225d(r9, r10)     // Catch:{ all -> 0x0028 }
        monitor-exit(r8)
        return
    L_0x0104:
        if (r9 != r2) goto L_0x011f
        java.util.concurrent.atomic.AtomicBoolean r9 = r8.f7107u     // Catch:{ all -> 0x0028 }
        boolean r9 = r9.get()     // Catch:{ all -> 0x0028 }
        if (r9 != 0) goto L_0x0117
        java.lang.String r9 = "splashLoadAd"
        java.lang.String r10 = "splashAdTryCallback 缓存请求失败(缓存先回来)，实时还没有回调....等待...！"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12225d(r9, r10)     // Catch:{ all -> 0x0028 }
        monitor-exit(r8)
        return
    L_0x0117:
        java.lang.String r9 = "splashLoadAd"
        java.lang.String r11 = "splashAdTryCallback 缓存请求失败(缓存先回来)，实时也失败....直接回调出去！"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12225d(r9, r11)     // Catch:{ all -> 0x0028 }
        goto L_0x0175
    L_0x011f:
        java.util.concurrent.atomic.AtomicBoolean r11 = r8.f7105s     // Catch:{ all -> 0x0028 }
        boolean r11 = r11.get()     // Catch:{ all -> 0x0028 }
        if (r11 == 0) goto L_0x0175
        if (r9 != r0) goto L_0x0175
        java.lang.String r9 = "splashLoadAd"
        java.lang.String r11 = "如果实时已超时，REQUEST_TYPE_TIMEOUT--->>>>"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12225d(r9, r11)     // Catch:{ all -> 0x0028 }
        java.util.concurrent.atomic.AtomicBoolean r9 = r8.f7108v     // Catch:{ all -> 0x0028 }
        boolean r9 = r9.get()     // Catch:{ all -> 0x0028 }
        if (r9 == 0) goto L_0x016e
        java.util.concurrent.atomic.AtomicBoolean r9 = r8.f7107u     // Catch:{ all -> 0x0028 }
        boolean r9 = r9.get()     // Catch:{ all -> 0x0028 }
        if (r9 != 0) goto L_0x0175
        java.util.concurrent.atomic.AtomicBoolean r9 = r8.f7098l     // Catch:{ all -> 0x0028 }
        boolean r9 = r9.get()     // Catch:{ all -> 0x0028 }
        if (r9 == 0) goto L_0x0166
        java.util.concurrent.atomic.AtomicBoolean r9 = r8.f7099m     // Catch:{ all -> 0x0028 }
        boolean r9 = r9.get()     // Catch:{ all -> 0x0028 }
        if (r9 != 0) goto L_0x0158
        java.util.concurrent.atomic.AtomicBoolean r9 = r8.f7100n     // Catch:{ all -> 0x0028 }
        boolean r9 = r9.get()     // Catch:{ all -> 0x0028 }
        if (r9 == 0) goto L_0x0166
    L_0x0158:
        java.lang.String r9 = "splashLoadAd"
        java.lang.String r10 = "如果实时已超时，缓存成功直接回调"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12225d(r9, r10)     // Catch:{ all -> 0x0028 }
        com.bytedance.sdk.openadsdk.component.splash.b$a r9 = r8.f7109w     // Catch:{ all -> 0x0028 }
        r8.m8924a(r9)     // Catch:{ all -> 0x0028 }
        monitor-exit(r8)
        return
    L_0x0166:
        java.lang.String r9 = "splashLoadAd"
        java.lang.String r11 = "如果实时已超时，直接失败回调"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12225d(r9, r11)     // Catch:{ all -> 0x0028 }
        goto L_0x0175
    L_0x016e:
        java.lang.String r9 = "splashLoadAd"
        java.lang.String r11 = "如果实时已超时，缓存也失败直接回调，直接失败回调"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12225d(r9, r11)     // Catch:{ all -> 0x0028 }
    L_0x0175:
        r8.m8924a(r10)     // Catch:{ all -> 0x0028 }
        monitor-exit(r8)
        return
    L_0x017a:
        if (r13 != 0) goto L_0x0187
        if (r11 == 0) goto L_0x0187
        if (r12 == 0) goto L_0x0187
        byte[] r11 = r11.mo15548b()     // Catch:{ all -> 0x0028 }
        r12.mo15251a(r11)     // Catch:{ all -> 0x0028 }
    L_0x0187:
        java.util.concurrent.atomic.AtomicBoolean r11 = r8.f7105s     // Catch:{ all -> 0x0028 }
        boolean r11 = r11.get()     // Catch:{ all -> 0x0028 }
        if (r11 == 0) goto L_0x01e0
        if (r9 != r2) goto L_0x01e0
        java.util.concurrent.atomic.AtomicBoolean r11 = r8.f7108v     // Catch:{ all -> 0x0028 }
        boolean r11 = r11.get()     // Catch:{ all -> 0x0028 }
        if (r11 == 0) goto L_0x01c3
        java.util.concurrent.atomic.AtomicBoolean r11 = r8.f7107u     // Catch:{ all -> 0x0028 }
        boolean r11 = r11.get()     // Catch:{ all -> 0x0028 }
        if (r11 != 0) goto L_0x01c3
        java.util.concurrent.atomic.AtomicBoolean r11 = r8.f7098l     // Catch:{ all -> 0x0028 }
        boolean r11 = r11.get()     // Catch:{ all -> 0x0028 }
        if (r11 == 0) goto L_0x01c3
        java.util.concurrent.atomic.AtomicBoolean r11 = r8.f7100n     // Catch:{ all -> 0x0028 }
        boolean r11 = r11.get()     // Catch:{ all -> 0x0028 }
        if (r11 == 0) goto L_0x01c3
        java.lang.String r9 = "splashLoadAd"
        java.lang.String r11 = "缓存赋值给resultTemp"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12225d(r9, r11)     // Catch:{ all -> 0x0028 }
        r8.f7109w = r10     // Catch:{ all -> 0x0028 }
        java.lang.String r9 = "splashLoadAd"
        java.lang.String r10 = "如果缓存先回来,实时还没有回来，等待实时回来"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12225d(r9, r10)     // Catch:{ all -> 0x0028 }
        monitor-exit(r8)
        return
    L_0x01c3:
        java.util.concurrent.atomic.AtomicBoolean r11 = r8.f7107u     // Catch:{ all -> 0x0028 }
        boolean r11 = r11.get()     // Catch:{ all -> 0x0028 }
        if (r11 == 0) goto L_0x01e0
        com.bytedance.sdk.openadsdk.component.splash.e r11 = r8.f7096i     // Catch:{ all -> 0x0028 }
        if (r11 == 0) goto L_0x01e0
        com.bytedance.sdk.openadsdk.component.splash.e r11 = r8.f7096i     // Catch:{ all -> 0x0028 }
        boolean r11 = r11.mo15252a()     // Catch:{ all -> 0x0028 }
        if (r11 == 0) goto L_0x01e0
        java.lang.String r9 = "splashLoadAd"
        java.lang.String r10 = "此时实时可能在渲染，避免缓存的渲染成功后直接被回调"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12225d(r9, r10)     // Catch:{ all -> 0x0028 }
        monitor-exit(r8)
        return
    L_0x01e0:
        if (r9 != r4) goto L_0x01e9
        java.lang.String r11 = "splashLoadAd"
        java.lang.String r12 = "splashAdTryCallback 实时或渲染成功回调......！"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12225d(r11, r12)     // Catch:{ all -> 0x0028 }
    L_0x01e9:
        java.lang.String r11 = "splashLoadAd"
        java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0028 }
        r12.<init>()     // Catch:{ all -> 0x0028 }
        java.lang.String r13 = "splashAdTryCallback..（ 是否缓存已check成功："
        r12.append(r13)     // Catch:{ all -> 0x0028 }
        java.util.concurrent.atomic.AtomicBoolean r13 = r8.f7098l     // Catch:{ all -> 0x0028 }
        boolean r13 = r13.get()     // Catch:{ all -> 0x0028 }
        r12.append(r13)     // Catch:{ all -> 0x0028 }
        java.lang.String r13 = " || 是否渲染超时："
        r12.append(r13)     // Catch:{ all -> 0x0028 }
        r13 = 0
        if (r9 != r1) goto L_0x0208
        r0 = 1
        goto L_0x0209
    L_0x0208:
        r0 = 0
    L_0x0209:
        r12.append(r0)     // Catch:{ all -> 0x0028 }
        java.lang.String r0 = " || 是否为实时请求"
        r12.append(r0)     // Catch:{ all -> 0x0028 }
        if (r9 != r4) goto L_0x0214
        r13 = 1
    L_0x0214:
        r12.append(r13)     // Catch:{ all -> 0x0028 }
        java.lang.String r13 = "） && （是否实时模版渲染成功："
        r12.append(r13)     // Catch:{ all -> 0x0028 }
        java.util.concurrent.atomic.AtomicBoolean r13 = r8.f7099m     // Catch:{ all -> 0x0028 }
        boolean r13 = r13.get()     // Catch:{ all -> 0x0028 }
        r12.append(r13)     // Catch:{ all -> 0x0028 }
        java.lang.String r13 = " || 是否缓存模版渲染成功："
        r12.append(r13)     // Catch:{ all -> 0x0028 }
        java.util.concurrent.atomic.AtomicBoolean r13 = r8.f7100n     // Catch:{ all -> 0x0028 }
        boolean r13 = r13.get()     // Catch:{ all -> 0x0028 }
        r12.append(r13)     // Catch:{ all -> 0x0028 }
        java.lang.String r13 = "）"
        r12.append(r13)     // Catch:{ all -> 0x0028 }
        java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0028 }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r11, r12)     // Catch:{ all -> 0x0028 }
        java.util.concurrent.atomic.AtomicBoolean r11 = r8.f7098l     // Catch:{ all -> 0x0028 }
        boolean r11 = r11.get()     // Catch:{ all -> 0x0028 }
        if (r11 != 0) goto L_0x024b
        if (r9 == r4) goto L_0x024b
        if (r9 != r1) goto L_0x025e
    L_0x024b:
        java.util.concurrent.atomic.AtomicBoolean r9 = r8.f7099m     // Catch:{ all -> 0x0028 }
        boolean r9 = r9.get()     // Catch:{ all -> 0x0028 }
        if (r9 != 0) goto L_0x025b
        java.util.concurrent.atomic.AtomicBoolean r9 = r8.f7100n     // Catch:{ all -> 0x0028 }
        boolean r9 = r9.get()     // Catch:{ all -> 0x0028 }
        if (r9 == 0) goto L_0x025e
    L_0x025b:
        r8.m8924a(r10)     // Catch:{ all -> 0x0028 }
    L_0x025e:
        monitor-exit(r8)
        return
    L_0x0260:
        monitor-exit(r8)
        throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.splash.SplashAdLoadManager.m8922a(int, com.bytedance.sdk.openadsdk.component.splash.b$a, com.bytedance.sdk.openadsdk.core.d.n, com.bytedance.sdk.openadsdk.component.splash.e, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public TTSplashAdImpl m8918a(SplashAdCache nVar, String str) {
        if (!SplashUtils.m8972a(nVar)) {
            return null;
        }
        if (str != null) {
            nVar.mo15545a().mo15474d(true);
        }
        TTSplashAdImpl eVar = new TTSplashAdImpl(this.f7092e, nVar.mo15545a(), str, this.f7088a, "splash_ad");
        this.f7095h = eVar;
        return eVar;
    }

    /* renamed from: f */
    private void m8944f() {
        SplashAdCacheManager aVar = this.f7097k;
        if (aVar != null) {
            aVar.mo15226a(this.f7088a, this.f7089b);
        }
    }

    /* renamed from: a */
    private synchronized void m8924a(C2191a aVar) {
        C2564t.m12226e("splashLoadAd", "onCallback ......");
        m8944f();
        if (aVar == null) {
            C2564t.m12214a("splashAdListener is null, then return");
            f7087j.remove(this);
        } else if (this.f7090c == null) {
            C2564t.m12214a("splashAdListener is null, then return");
            if (aVar.f7140a == 3) {
                m8933a(aVar.f7144e);
            }
            f7087j.remove(this);
        } else if (!this.f7094g.get()) {
            this.f7094g.set(true);
            int i = aVar.f7140a;
            if (i == 1) {
                StatsLogManager.m11278a().mo16571c(aVar.f7144e);
                this.f7090c.onSplashAdLoad(aVar.f7143d);
            } else if (i == 2) {
                StatsLogManager.m11278a().mo16572d(aVar.f7144e);
                this.f7090c.onError(aVar.f7141b, aVar.f7142c);
            } else if (i != 3) {
                this.f7090c.onError(-2, C2240g.m9576a(-2));
            } else {
                m8933a(aVar.f7144e);
                this.f7090c.onTimeout();
            }
            if (this.f7093f != null) {
                this.f7093f.removeMessages(2);
                this.f7093f.removeMessages(3);
            }
            this.f7090c = null;
            f7087j.remove(this);
        } else {
            this.f7090c = null;
            if (aVar.f7140a == 3) {
                m8933a(aVar.f7144e);
            }
            f7087j.remove(this);
        }
    }

    /* renamed from: a */
    private void m8933a(LogStatsBase dVar) {
        StatsLogManager.m11278a().mo16572d(dVar);
        StatsLogManager.m11278a().mo16575g(dVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00dc, code lost:
            if (r8 != null) goto L_0x00e3;
     */
    /* renamed from: a */
    public void mo14813a(android.os.Message r8) {
        /*
        r7 = this;
        int r0 = r8.what
        r1 = 0
        r2 = 1
        if (r0 != r2) goto L_0x002b
        java.util.concurrent.atomic.AtomicBoolean r0 = r7.f7094g
        boolean r0 = r0.get()
        java.lang.String r3 = "SplashAdLoadManager"
        if (r0 != 0) goto L_0x001e
        java.util.concurrent.atomic.AtomicBoolean r0 = r7.f7094g
        r0.set(r2)
        r7.m8921a()
        java.lang.String r0 = "尝试从缓存中取"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r3, r0)
        goto L_0x0026
    L_0x001e:
        r7.m8944f()
        java.lang.String r0 = "开始预加载"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r3, r0)
    L_0x0026:
        com.bytedance.sdk.openadsdk.utils.ak r0 = r7.f7093f
        r0.removeCallbacksAndMessages(r1)
    L_0x002b:
        int r0 = r8.what
        r3 = 2
        java.lang.String r4 = "splashLoadAd"
        if (r0 != r3) goto L_0x005b
        com.bytedance.sdk.openadsdk.utils.ak r0 = r7.f7093f
        r0.removeCallbacksAndMessages(r1)
        java.util.concurrent.atomic.AtomicBoolean r0 = r7.f7094g
        boolean r0 = r0.get()
        if (r0 == 0) goto L_0x0040
        return
    L_0x0040:
        java.lang.String r0 = "MSG_USER_TIME_OUT----7-"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r4, r0)
        r0 = 0
        com.bytedance.sdk.openadsdk.f.a.d r0 = r7.m8919a(r0, r1)
        android.os.Handler r5 = new android.os.Handler
        android.os.Looper r6 = android.os.Looper.getMainLooper()
        r5.<init>(r6)
        com.bytedance.sdk.openadsdk.component.splash.b$8 r6 = new com.bytedance.sdk.openadsdk.component.splash.b$8
        r6.m43611init(r0)
        r5.post(r6)
    L_0x005b:
        int r8 = r8.what
        r0 = 3
        if (r8 != r0) goto L_0x0100
        com.bytedance.sdk.openadsdk.utils.ak r8 = r7.f7093f
        r8.removeMessages(r0)
        java.util.concurrent.atomic.AtomicBoolean r8 = r7.f7094g
        boolean r8 = r8.get()
        if (r8 == 0) goto L_0x006e
        return
    L_0x006e:
        java.util.concurrent.atomic.AtomicBoolean r8 = r7.f7099m
        r8.set(r2)
        java.util.concurrent.atomic.AtomicBoolean r8 = r7.f7100n
        r8.set(r2)
        com.bytedance.sdk.openadsdk.core.h.l r8 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10069h()
        int r8 = r8.mo15811r()
        r5 = 4
        if (r8 == 0) goto L_0x00e1
        if (r8 == r2) goto L_0x00ca
        if (r8 == r3) goto L_0x00ac
        if (r8 == r0) goto L_0x008a
        goto L_0x00df
    L_0x008a:
        com.bytedance.sdk.openadsdk.component.splash.e r8 = r7.f7095h
        if (r8 == 0) goto L_0x009f
        java.util.concurrent.atomic.AtomicBoolean r8 = r7.f7098l
        boolean r8 = r8.get()
        if (r8 == 0) goto L_0x009f
        java.lang.String r8 = "谁回来用谁//--mCacheTTSplashAd"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r4, r8)
        com.bytedance.sdk.openadsdk.component.splash.e r8 = r7.f7095h
        r0 = 4
        goto L_0x00a0
    L_0x009f:
        r8 = r1
    L_0x00a0:
        com.bytedance.sdk.openadsdk.component.splash.e r2 = r7.f7096i
        if (r2 == 0) goto L_0x00e3
        java.lang.String r8 = "谁回来用谁//--mRealNetWorkTTSplashAd"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r4, r8)
        com.bytedance.sdk.openadsdk.component.splash.e r8 = r7.f7096i
        goto L_0x00e3
    L_0x00ac:
        com.bytedance.sdk.openadsdk.component.splash.e r8 = r7.f7096i
        if (r8 == 0) goto L_0x00b6
        java.lang.String r2 = "超时使用实时--mRealNetWorkTTSplashAd"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r4, r2)
        goto L_0x00e3
    L_0x00b6:
        com.bytedance.sdk.openadsdk.component.splash.e r8 = r7.f7095h
        if (r8 == 0) goto L_0x00df
        java.util.concurrent.atomic.AtomicBoolean r8 = r7.f7098l
        boolean r8 = r8.get()
        if (r8 == 0) goto L_0x00df
        java.lang.String r8 = "超时使用实时//--mCacheTTSplashAd"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r4, r8)
        com.bytedance.sdk.openadsdk.component.splash.e r8 = r7.f7095h
        goto L_0x00d8
    L_0x00ca:
        com.bytedance.sdk.openadsdk.component.splash.e r8 = r7.f7095h
        if (r8 == 0) goto L_0x00da
        java.util.concurrent.atomic.AtomicBoolean r8 = r7.f7098l
        boolean r8 = r8.get()
        if (r8 == 0) goto L_0x00da
        com.bytedance.sdk.openadsdk.component.splash.e r8 = r7.f7095h
    L_0x00d8:
        r0 = 4
        goto L_0x00e3
    L_0x00da:
        com.bytedance.sdk.openadsdk.component.splash.e r8 = r7.f7096i
        if (r8 == 0) goto L_0x00df
        goto L_0x00e3
    L_0x00df:
        r8 = r1
        goto L_0x00e3
    L_0x00e1:
        com.bytedance.sdk.openadsdk.component.splash.e r8 = r7.f7096i
    L_0x00e3:
        if (r8 == 0) goto L_0x0100
        boolean r2 = r8.mo15252a()
        if (r2 == 0) goto L_0x0100
        com.bytedance.sdk.openadsdk.f.a.d r0 = r7.m8919a(r0, r1)
        android.os.Handler r1 = new android.os.Handler
        android.os.Looper r2 = android.os.Looper.getMainLooper()
        r1.<init>(r2)
        com.bytedance.sdk.openadsdk.component.splash.b$9 r2 = new com.bytedance.sdk.openadsdk.component.splash.b$9
        r2.m43612init(r8, r0)
        r1.post(r2)
    L_0x0100:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.splash.SplashAdLoadManager.mo14813a(android.os.Message):void");
    }
}
