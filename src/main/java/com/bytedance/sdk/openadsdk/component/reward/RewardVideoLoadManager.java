package com.bytedance.sdk.openadsdk.component.reward;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.p159b.ImageLoader.C1964d;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener;
import com.bytedance.sdk.openadsdk.core.C2240g;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.NetApi;
import com.bytedance.sdk.openadsdk.core.NetApi.C2287b;
import com.bytedance.sdk.openadsdk.core.p170d.AdInfo;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p170d.NetExtParams;
import com.bytedance.sdk.openadsdk.core.p173g.PlayableCache;
import com.bytedance.sdk.openadsdk.core.p173g.PlayableCache.C2245a;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.p188g.StatsImageListener;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.bytedance.sdk.openadsdk.component.reward.g */
public class RewardVideoLoadManager {
    /* renamed from: a */
    private static volatile RewardVideoLoadManager f6951a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public Context f6952b;
    /* renamed from: c */
    private final NetApi f6953c = InternalContainer.m10067f();
    /* renamed from: d */
    private AtomicBoolean f6954d = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    /* renamed from: e */
    public List<C2150a> f6955e = Collections.synchronizedList(new ArrayList());
    /* renamed from: f */
    private final BroadcastReceiver f6956f = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && C2566w.m12244c(RewardVideoLoadManager.this.f6952b) != 0) {
                Iterator it = RewardVideoLoadManager.this.f6955e.iterator();
                while (it.hasNext()) {
                    TTExecutor.m11692a().mo16808c((Runnable) it.next(), 1);
                    it.remove();
                }
            }
        }
    };

    /* compiled from: RewardVideoLoadManager */
    /* renamed from: com.bytedance.sdk.openadsdk.component.reward.g$a */
    private class C2150a implements Runnable {
        /* renamed from: a */
        MaterialMeta f6970a;
        /* renamed from: b */
        AdSlot f6971b;

        C2150a(MaterialMeta kVar, AdSlot adSlot) {
            this.f6970a = kVar;
            this.f6971b = adSlot;
        }

        public void run() {
            RewardVideoCache.m8719a(RewardVideoLoadManager.this.f6952b).mo15129a(this.f6970a, (C2144a<Object>) new C2144a<Object>() {
                /* renamed from: a */
                public void mo15137a(boolean z, Object obj) {
                    if (z) {
                        RewardVideoCache.m8719a(RewardVideoLoadManager.this.f6952b).mo15128a(C2150a.this.f6971b, C2150a.this.f6970a);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static RewardVideoLoadManager m8752a(Context context) {
        if (f6951a == null) {
            synchronized (RewardVideoLoadManager.class) {
                if (f6951a == null) {
                    f6951a = new RewardVideoLoadManager(context);
                }
            }
        }
        return f6951a;
    }

    private RewardVideoLoadManager(Context context) {
        this.f6952b = context == null ? InternalContainer.m10059a() : context.getApplicationContext();
        m8758c();
    }

    /* renamed from: a */
    public void mo15138a() {
        AdSlot b = RewardVideoCache.m8719a(this.f6952b).mo15131b();
        if (b != null && !TextUtils.isEmpty(b.getCodeId()) && RewardVideoCache.m8719a(this.f6952b).mo15134c(b.getCodeId()) == null) {
            mo15144b(b);
        }
    }

    /* renamed from: a */
    public void mo15139a(AdSlot adSlot) {
        RewardVideoCache.m8719a(this.f6952b).mo15133b(adSlot);
    }

    /* renamed from: b */
    public void mo15143b() {
        try {
            RewardVideoCache.m8719a(this.f6952b).mo15126a();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void mo15140a(AdSlot adSlot, RewardVideoAdListener rewardVideoAdListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("load reward vide: ");
        sb.append(String.valueOf(adSlot));
        C2564t.m12220b("RewardVideoLoadManager", sb.toString());
        RewardVideoCache.m8719a(this.f6952b).mo15127a(adSlot);
        m8753a(adSlot, false, rewardVideoAdListener);
    }

    /* renamed from: b */
    public void mo15144b(AdSlot adSlot) {
        StringBuilder sb = new StringBuilder();
        sb.append("preload reward video: ");
        sb.append(String.valueOf(adSlot));
        C2564t.m12220b("RewardVideoLoadManager", sb.toString());
        m8753a(adSlot, true, null);
    }

    /* renamed from: a */
    private void m8753a(AdSlot adSlot, boolean z, final RewardVideoAdListener rewardVideoAdListener) {
        if (z) {
            m8757b(adSlot, true, rewardVideoAdListener);
        } else {
            final MaterialMeta c = RewardVideoCache.m8719a(this.f6952b).mo15134c(adSlot.getCodeId());
            if (c != null) {
                TTRewardVideoAdImpl jVar = new TTRewardVideoAdImpl(this.f6952b, c, adSlot);
                if (!c.mo15504r()) {
                    jVar.mo15160a(RewardVideoCache.m8719a(this.f6952b).mo15124a(c));
                }
                AdEventManager.m8392a(c);
                if (rewardVideoAdListener != null) {
                    rewardVideoAdListener.onRewardVideoAdLoad(jVar);
                    if (!c.mo15504r()) {
                        rewardVideoAdListener.onRewardVideoCached();
                    }
                }
                PlayableCache.m9577a().mo15642a(c, (C2245a) new C2245a() {
                    /* renamed from: a */
                    public void mo15121a(boolean z) {
                        if (rewardVideoAdListener != null && c.mo15504r()) {
                            rewardVideoAdListener.onRewardVideoCached();
                        }
                    }
                });
                C2564t.m12220b("RewardVideoLoadManager", "get cache data success");
                return;
            }
            m8757b(adSlot, false, rewardVideoAdListener);
        }
    }

    /* renamed from: b */
    private void m8757b(final AdSlot adSlot, final boolean z, final RewardVideoAdListener rewardVideoAdListener) {
        NetExtParams lVar = new NetExtParams();
        lVar.f7451b = z ? 2 : 1;
        if (InternalContainer.m10069h().mo15794i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f) {
            lVar.f7454e = 2;
        }
        this.f6953c.mo15917a(adSlot, lVar, 7, (C2287b) new C2287b() {
            /* renamed from: a */
            public void mo14946a(int i, String str) {
                if (!z) {
                    RewardVideoAdListener rewardVideoAdListener = rewardVideoAdListener;
                    if (rewardVideoAdListener != null) {
                        rewardVideoAdListener.onError(i, str);
                    }
                }
            }

            /* renamed from: a */
            public void mo14947a(AdInfo aVar) {
                if (aVar.mo15336c() != null && !aVar.mo15336c().isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("get material data success: ");
                    sb.append(z);
                    C2564t.m12220b("RewardVideoLoadManager", sb.toString());
                    final MaterialMeta kVar = (MaterialMeta) aVar.mo15336c().get(0);
                    try {
                        if (kVar.mo15415C() != null && !TextUtils.isEmpty(kVar.mo15415C().mo15406a())) {
                            String a = kVar.mo15415C().mo15406a();
                            StatsImageListener bVar = new StatsImageListener(true);
                            bVar.mo16647a(adSlot.getCodeId());
                            bVar.mo16646a(7);
                            bVar.mo16649c(kVar.mo15425M());
                            bVar.mo16650d(kVar.mo15428P());
                            bVar.mo16648b(ToolUtils.m12034h(kVar.mo15428P()));
                            TTNetClient.m11428a(RewardVideoLoadManager.this.f6952b).mo16660g().mo14198a(a, (C1964d) bVar);
                        }
                    } catch (Throwable unused) {
                    }
                    final TTRewardVideoAdImpl jVar = new TTRewardVideoAdImpl(RewardVideoLoadManager.this.f6952b, kVar, adSlot);
                    if (!z) {
                        RewardVideoAdListener rewardVideoAdListener = rewardVideoAdListener;
                        if (rewardVideoAdListener != null) {
                            rewardVideoAdListener.onRewardVideoAdLoad(jVar);
                        }
                    }
                    PlayableCache.m9577a().mo15642a(kVar, (C2245a) new C2245a() {
                        /* renamed from: a */
                        public void mo15121a(boolean z) {
                            if (!z && rewardVideoAdListener != null) {
                                MaterialMeta kVar = kVar;
                                if (kVar != null && kVar.mo15504r()) {
                                    rewardVideoAdListener.onRewardVideoCached();
                                }
                            }
                        }
                    });
                    if (kVar.mo15455aa()) {
                        if (z && !kVar.mo15504r() && InternalContainer.m10069h().mo15812r(adSlot.getCodeId()).f7588d == 1) {
                            if (!C2566w.m12245d(RewardVideoLoadManager.this.f6952b)) {
                                RewardVideoLoadManager gVar = RewardVideoLoadManager.this;
                                gVar.m8754a(new C2150a(kVar, adSlot));
                            }
                        } else if (!kVar.mo15504r()) {
                            RewardVideoCache.m8719a(RewardVideoLoadManager.this.f6952b).mo15129a(kVar, (C2144a<Object>) new C2144a<Object>() {
                                /* renamed from: a */
                                public void mo15137a(boolean z, Object obj) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("download video file: ");
                                    sb.append(z);
                                    sb.append(", preload: ");
                                    sb.append(z);
                                    C2564t.m12220b("RewardVideoLoadManager", sb.toString());
                                    if (z) {
                                        jVar.mo15160a(RewardVideoCache.m8719a(RewardVideoLoadManager.this.f6952b).mo15124a(kVar));
                                    }
                                    if (!z) {
                                        AdEventManager.m8392a(kVar);
                                        if (z && rewardVideoAdListener != null) {
                                            rewardVideoAdListener.onRewardVideoCached();
                                        }
                                    } else if (z) {
                                        RewardVideoCache.m8719a(RewardVideoLoadManager.this.f6952b).mo15128a(adSlot, kVar);
                                    }
                                }
                            });
                        }
                    } else if (!z) {
                        RewardVideoAdListener rewardVideoAdListener2 = rewardVideoAdListener;
                        if (rewardVideoAdListener2 != null) {
                            rewardVideoAdListener2.onError(-4, C2240g.m9576a(-4));
                        }
                    }
                } else if (!z) {
                    RewardVideoAdListener rewardVideoAdListener3 = rewardVideoAdListener;
                    if (rewardVideoAdListener3 != null) {
                        rewardVideoAdListener3.onError(-3, C2240g.m9576a(-3));
                    }
                }
            }
        });
    }

    /* renamed from: a */
    public void mo15141a(String str) {
        RewardVideoCache.m8719a(this.f6952b).mo15130a(str);
    }

    /* renamed from: b */
    public AdSlot mo15142b(String str) {
        return RewardVideoCache.m8719a(this.f6952b).mo15132b(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8754a(C2150a aVar) {
        if (aVar != null) {
            if (this.f6955e.size() >= 1) {
                this.f6955e.remove(0);
            }
            this.f6955e.add(aVar);
        }
    }

    /* renamed from: c */
    private void m8758c() {
        if (!this.f6954d.get()) {
            this.f6954d.set(true);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            try {
                this.f6952b.registerReceiver(this.f6956f, intentFilter);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: d */
    private void m8759d() {
        if (this.f6954d.get()) {
            this.f6954d.set(false);
            try {
                this.f6952b.unregisterReceiver(this.f6956f);
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        m8759d();
    }
}
