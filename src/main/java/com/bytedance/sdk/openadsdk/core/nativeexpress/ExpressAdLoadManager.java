package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.C2240g;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.NetApi;
import com.bytedance.sdk.openadsdk.core.NetApi.C2287b;
import com.bytedance.sdk.openadsdk.core.bannerexpress.TTBannerExpressAdImpl;
import com.bytedance.sdk.openadsdk.core.p169c.TTInteractionExpressAdImpl;
import com.bytedance.sdk.openadsdk.core.p170d.AdInfo;
import com.bytedance.sdk.openadsdk.core.p170d.Image;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p170d.NetExtParams;
import com.bytedance.sdk.openadsdk.p185f.StatsLogManager;
import com.bytedance.sdk.openadsdk.p185f.p186a.LogStatsBase;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.bytedance.sdk.openadsdk.p188g.p189a.GifLoader;
import com.bytedance.sdk.openadsdk.p188g.p189a.GifLoader.C2432b;
import com.bytedance.sdk.openadsdk.p190h.p196f.VideoCachePreloader;
import com.bytedance.sdk.openadsdk.p190h.p196f.VideoUrlModel;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.bytedance.sdk.openadsdk.core.nativeexpress.b */
public class ExpressAdLoadManager {
    /* renamed from: j */
    private static Set<ExpressAdLoadManager> f7814j = Collections.synchronizedSet(new HashSet());
    /* renamed from: a */
    private AdSlot f7815a;
    /* renamed from: b */
    private final NetApi f7816b = InternalContainer.m10067f();
    /* renamed from: c */
    private Context f7817c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public NativeExpressAdListener f7818d;
    /* renamed from: e */
    private final AtomicBoolean f7819e = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    /* renamed from: f */
    public List<MaterialMeta> f7820f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public List<MaterialMeta> f7821g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public C2274a f7822h;
    /* renamed from: i */
    private int f7823i = 5;
    /* renamed from: k */
    private ScheduledFuture<?> f7824k = null;
    /* renamed from: l */
    private ScheduledFuture<?> f7825l = null;
    /* renamed from: m */
    private ScheduledFuture<?> f7826m = null;

    /* compiled from: ExpressAdLoadManager */
    /* renamed from: com.bytedance.sdk.openadsdk.core.nativeexpress.b$a */
    public interface C2274a {
        /* renamed from: a */
        void mo15313a();

        /* renamed from: a */
        void mo15314a(List<MaterialMeta> list);
    }

    private ExpressAdLoadManager(Context context) {
        if (context != null) {
            this.f7817c = context.getApplicationContext();
        } else {
            this.f7817c = InternalContainer.m10059a();
        }
        f7814j.add(this);
    }

    /* renamed from: a */
    public static ExpressAdLoadManager m9985a(Context context) {
        return new ExpressAdLoadManager(context);
    }

    /* renamed from: a */
    public void mo15898a(AdSlot adSlot, int i, NativeExpressAdListener nativeExpressAdListener, int i2) {
        mo15899a(adSlot, i, nativeExpressAdListener, null, i2);
    }

    /* renamed from: a */
    public void mo15899a(AdSlot adSlot, int i, NativeExpressAdListener nativeExpressAdListener, C2274a aVar, int i2) {
        if (this.f7819e.get()) {
            C2564t.m12226e("ExpressAdLoadManager", "express ad is loading...");
            return;
        }
        this.f7823i = i;
        this.f7819e.set(true);
        this.f7815a = adSlot;
        this.f7818d = nativeExpressAdListener;
        this.f7822h = aVar;
        m9990a(this.f7815a, this.f7818d);
    }

    /* renamed from: a */
    private void m9990a(AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener) {
        if (adSlot != null) {
            NetExtParams lVar = new NetExtParams();
            lVar.f7454e = 2;
            this.f7816b.mo15917a(adSlot, lVar, this.f7823i, (C2287b) new C2287b() {
                /* renamed from: a */
                public void mo14946a(int i, String str) {
                    ExpressAdLoadManager.this.m9989a(i, str);
                }

                /* renamed from: a */
                public void mo14947a(AdInfo aVar) {
                    if (aVar.mo15336c() == null || aVar.mo15336c().isEmpty()) {
                        ExpressAdLoadManager.this.m9989a(-3, C2240g.m9576a(-3));
                        return;
                    }
                    ExpressAdLoadManager.this.f7820f = aVar.mo15336c();
                    ExpressAdLoadManager.this.f7821g = aVar.mo15336c();
                    ExpressAdLoadManager.this.m9987a();
                    ExpressAdLoadManager.this.m9996b();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9987a() {
        List<MaterialMeta> list = this.f7820f;
        if (list != null) {
            for (MaterialMeta kVar : list) {
                if (kVar.mo15455aa() && kVar.mo15418F() != null && !kVar.mo15418F().isEmpty()) {
                    for (Image jVar : kVar.mo15418F()) {
                        if (!TextUtils.isEmpty(jVar.mo15406a())) {
                            TTNetClient.m11428a(this.f7817c).mo16659f().mo16632a(jVar.mo15406a(), (C2432b) GifLoader.m11378a(), jVar.mo15409b(), jVar.mo15411c());
                        }
                    }
                }
                if (!((kVar.mo15429Q() != 5 && kVar.mo15429Q() != 15) || kVar.mo15512z() == null || kVar.mo15512z().mo15603g() == null)) {
                    int d = ToolUtils.m12018d(kVar.mo15428P());
                    if (InternalContainer.m10069h().mo15775a(String.valueOf(d)) && InternalContainer.m10069h().mo15810q(String.valueOf(d))) {
                        VideoCachePreloader.m11598a().mo16766a(new VideoUrlModel().mo16772a(kVar.mo15512z().mo15603g()).mo16771a(204800).mo16773b(kVar.mo15512z().mo15606j()));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9996b() {
        if (this.f7819e.getAndSet(false)) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    if (ExpressAdLoadManager.this.f7821g == null || ExpressAdLoadManager.this.f7821g.size() <= 0) {
                        if (ExpressAdLoadManager.this.f7818d != null) {
                            ExpressAdLoadManager.this.f7818d.onError(108, C2240g.m9576a(108));
                            ExpressAdLoadManager.this.m9988a(108);
                        }
                        if (ExpressAdLoadManager.this.f7822h != null) {
                            ExpressAdLoadManager.this.f7822h.mo15313a();
                        }
                    } else {
                        if (ExpressAdLoadManager.this.f7818d != null) {
                            ArrayList arrayList = new ArrayList(ExpressAdLoadManager.this.f7821g.size());
                            for (MaterialMeta a : ExpressAdLoadManager.this.f7821g) {
                                arrayList.add(ExpressAdLoadManager.this.m9983a(a));
                            }
                            if (!arrayList.isEmpty()) {
                                ExpressAdLoadManager.this.f7818d.onNativeExpressAdLoad(arrayList);
                            } else {
                                ExpressAdLoadManager.this.f7818d.onError(103, C2240g.m9576a(103));
                                ExpressAdLoadManager.this.m9988a(103);
                            }
                        }
                        if (ExpressAdLoadManager.this.f7822h != null) {
                            ExpressAdLoadManager.this.f7822h.mo15314a(ExpressAdLoadManager.this.f7821g);
                        }
                    }
                    ExpressAdLoadManager.this.m10000c();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9988a(int i) {
        List<MaterialMeta> list = this.f7820f;
        String h = (list == null || list.size() <= 0) ? "" : ToolUtils.m12034h(((MaterialMeta) this.f7820f.get(0)).mo15428P());
        LogStatsBase f = LogStatsBase.m11308b().mo16590a(this.f7823i).mo16595c(this.f7815a.getCodeId()).mo16601f(h);
        f.mo16592b(i).mo16603g(C2240g.m9576a(i));
        StatsLogManager.m11278a().mo16576h(f);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9989a(int i, String str) {
        if (this.f7819e.getAndSet(false)) {
            NativeExpressAdListener nativeExpressAdListener = this.f7818d;
            if (nativeExpressAdListener != null) {
                nativeExpressAdListener.onError(i, str);
            }
            C2274a aVar = this.f7822h;
            if (aVar != null) {
                aVar.mo15313a();
            }
            m10000c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public TTNativeExpressAd m9983a(MaterialMeta kVar) {
        int i = this.f7823i;
        if (i == 1) {
            return new TTBannerExpressAdImpl(this.f7817c, kVar, this.f7815a);
        }
        if (i == 2) {
            return new TTInteractionExpressAdImpl(this.f7817c, kVar, this.f7815a);
        }
        if (i != 5) {
            if (i != 9) {
                return null;
            }
            return new TTNativeExpressDrawVideoAdImpl(this.f7817c, kVar, this.f7815a);
        } else if (kVar.mo15512z() != null) {
            return new TTNativeExpressVideoAdImpl(this.f7817c, kVar, this.f7815a);
        } else {
            return new TTNativeExpressAdImpl(this.f7817c, kVar, this.f7815a);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10000c() {
        List<MaterialMeta> list = this.f7820f;
        if (list != null) {
            list.clear();
        }
        List<MaterialMeta> list2 = this.f7821g;
        if (list2 != null) {
            list2.clear();
        }
        m9994a(true);
        m9998b(true);
        m10001c(true);
        m10003d();
    }

    /* renamed from: a */
    private void m9994a(boolean z) {
        try {
            if (this.f7825l != null && !this.f7825l.isCancelled()) {
                boolean cancel = this.f7825l.cancel(z);
                StringBuilder sb = new StringBuilder();
                sb.append("CheckValidFutureTask-->cancel......success=");
                sb.append(cancel);
                C2564t.m12226e("ExpressAdLoadManager", sb.toString());
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    private void m9998b(boolean z) {
        try {
            if (this.f7826m != null && !this.f7826m.isCancelled()) {
                boolean cancel = this.f7826m.cancel(z);
                StringBuilder sb = new StringBuilder();
                sb.append("CheckValidDoneFutureTask-->cancel.....success=");
                sb.append(cancel);
                C2564t.m12220b("ExpressAdLoadManager", sb.toString());
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    private void m10001c(boolean z) {
        try {
            if (this.f7824k != null && !this.f7824k.isCancelled()) {
                boolean cancel = this.f7824k.cancel(z);
                StringBuilder sb = new StringBuilder();
                sb.append("TimeOutFutureTask-->cancel......success=");
                sb.append(cancel);
                C2564t.m12226e("ExpressAdLoadManager", sb.toString());
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    private void m10003d() {
        f7814j.remove(this);
    }
}
