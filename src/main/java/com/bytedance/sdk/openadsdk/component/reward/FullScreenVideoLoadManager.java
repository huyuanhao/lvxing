package com.bytedance.sdk.openadsdk.component.reward;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.p159b.ImageLoader.C1964d;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener;
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

/* renamed from: com.bytedance.sdk.openadsdk.component.reward.c */
public class FullScreenVideoLoadManager {
    /* renamed from: a */
    private static volatile FullScreenVideoLoadManager f6916a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public Context f6917b;
    /* renamed from: c */
    private final NetApi f6918c = InternalContainer.m10067f();
    /* renamed from: d */
    private AtomicBoolean f6919d = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    /* renamed from: e */
    public List<C2139a> f6920e = Collections.synchronizedList(new ArrayList());
    /* renamed from: f */
    private final BroadcastReceiver f6921f = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && C2566w.m12244c(FullScreenVideoLoadManager.this.f6917b) != 0) {
                Iterator it = FullScreenVideoLoadManager.this.f6920e.iterator();
                while (it.hasNext()) {
                    TTExecutor.m11692a().mo16808c((Runnable) it.next(), 1);
                    it.remove();
                }
            }
        }
    };

    /* compiled from: FullScreenVideoLoadManager */
    /* renamed from: com.bytedance.sdk.openadsdk.component.reward.c$a */
    private class C2139a implements Runnable {
        /* renamed from: a */
        MaterialMeta f6935a;
        /* renamed from: b */
        AdSlot f6936b;

        C2139a(MaterialMeta kVar, AdSlot adSlot) {
            this.f6935a = kVar;
            this.f6936b = adSlot;
        }

        public void run() {
            FullScreenVideoCache.m8664a(FullScreenVideoLoadManager.this.f6917b).mo15097a(this.f6935a, (C2133a<Object>) new C2133a<Object>() {
                /* renamed from: a */
                public void mo15105a(boolean z, Object obj) {
                    if (z) {
                        FullScreenVideoCache.m8664a(FullScreenVideoLoadManager.this.f6917b).mo15096a(C2139a.this.f6936b, C2139a.this.f6935a);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static FullScreenVideoLoadManager m8697a(Context context) {
        if (f6916a == null) {
            synchronized (FullScreenVideoLoadManager.class) {
                if (f6916a == null) {
                    f6916a = new FullScreenVideoLoadManager(context);
                }
            }
        }
        return f6916a;
    }

    private FullScreenVideoLoadManager(Context context) {
        this.f6917b = context == null ? InternalContainer.m10059a() : context.getApplicationContext();
        m8703c();
    }

    /* renamed from: a */
    public void mo15113a() {
        try {
            FullScreenVideoCache.m8664a(this.f6917b).mo15094a();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public void mo15118b() {
        AdSlot b = FullScreenVideoCache.m8664a(this.f6917b).mo15099b();
        if (b != null && !TextUtils.isEmpty(b.getCodeId()) && FullScreenVideoCache.m8664a(this.f6917b).mo15102c(b.getCodeId()) == null) {
            mo15119b(b);
        }
    }

    /* renamed from: a */
    public void mo15114a(AdSlot adSlot) {
        FullScreenVideoCache.m8664a(this.f6917b).mo15101b(adSlot);
    }

    /* renamed from: a */
    public void mo15115a(AdSlot adSlot, FullScreenVideoAdListener fullScreenVideoAdListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("load full screen video: ");
        sb.append(String.valueOf(adSlot));
        C2564t.m12220b("FullScreenVideoLoadManager", sb.toString());
        FullScreenVideoCache.m8664a(this.f6917b).mo15095a(adSlot);
        m8698a(adSlot, false, fullScreenVideoAdListener);
    }

    /* renamed from: b */
    public void mo15119b(AdSlot adSlot) {
        StringBuilder sb = new StringBuilder();
        sb.append("preload full screen video: ");
        sb.append(String.valueOf(adSlot));
        C2564t.m12220b("FullScreenVideoLoadManager", sb.toString());
        m8698a(adSlot, true, null);
    }

    /* renamed from: a */
    private void m8698a(AdSlot adSlot, boolean z, final FullScreenVideoAdListener fullScreenVideoAdListener) {
        if (z) {
            m8702b(adSlot, true, fullScreenVideoAdListener);
        } else {
            final MaterialMeta c = FullScreenVideoCache.m8664a(this.f6917b).mo15102c(adSlot.getCodeId());
            if (c != null) {
                TTFullScreenVideoAdImpl iVar = new TTFullScreenVideoAdImpl(this.f6917b, c, adSlot);
                if (!c.mo15504r()) {
                    iVar.mo15157a(FullScreenVideoCache.m8664a(this.f6917b).mo15092a(c));
                }
                AdEventManager.m8392a(c);
                if (fullScreenVideoAdListener != null) {
                    fullScreenVideoAdListener.onFullScreenVideoAdLoad(iVar);
                    if (!c.mo15504r()) {
                        fullScreenVideoAdListener.onFullScreenVideoCached();
                    }
                }
                PlayableCache.m9577a().mo15642a(c, (C2245a) new C2245a() {
                    /* renamed from: a */
                    public void mo15121a(boolean z) {
                        if (fullScreenVideoAdListener != null && c.mo15504r()) {
                            fullScreenVideoAdListener.onFullScreenVideoCached();
                        }
                    }
                });
                C2564t.m12220b("FullScreenVideoLoadManager", "get cache data success");
                return;
            }
            m8702b(adSlot, false, fullScreenVideoAdListener);
        }
    }

    /* renamed from: b */
    private void m8702b(final AdSlot adSlot, final boolean z, final FullScreenVideoAdListener fullScreenVideoAdListener) {
        NetExtParams lVar = new NetExtParams();
        lVar.f7452c = z ? 2 : 1;
        if (InternalContainer.m10069h().mo15794i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f) {
            lVar.f7454e = 2;
        }
        this.f6918c.mo15917a(adSlot, lVar, 8, (C2287b) new C2287b() {
            /* renamed from: a */
            public void mo14946a(int i, String str) {
                if (!z) {
                    FullScreenVideoAdListener fullScreenVideoAdListener = fullScreenVideoAdListener;
                    if (fullScreenVideoAdListener != null) {
                        fullScreenVideoAdListener.onError(i, str);
                    }
                }
            }

            /* renamed from: a */
            public void mo14947a(AdInfo aVar) {
                if (aVar.mo15336c() != null && !aVar.mo15336c().isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("get material data success: ");
                    sb.append(z);
                    C2564t.m12220b("FullScreenVideoLoadManager", sb.toString());
                    final MaterialMeta kVar = (MaterialMeta) aVar.mo15336c().get(0);
                    try {
                        if (kVar.mo15415C() != null && !TextUtils.isEmpty(kVar.mo15415C().mo15406a())) {
                            String a = kVar.mo15415C().mo15406a();
                            StatsImageListener bVar = new StatsImageListener(true);
                            bVar.mo16647a(adSlot.getCodeId());
                            bVar.mo16646a(8);
                            bVar.mo16649c(kVar.mo15425M());
                            bVar.mo16650d(kVar.mo15428P());
                            bVar.mo16648b(ToolUtils.m12034h(kVar.mo15428P()));
                            TTNetClient.m11428a(FullScreenVideoLoadManager.this.f6917b).mo16660g().mo14198a(a, (C1964d) bVar);
                        }
                    } catch (Throwable unused) {
                    }
                    final TTFullScreenVideoAdImpl iVar = new TTFullScreenVideoAdImpl(FullScreenVideoLoadManager.this.f6917b, kVar, adSlot);
                    if (!z) {
                        FullScreenVideoAdListener fullScreenVideoAdListener = fullScreenVideoAdListener;
                        if (fullScreenVideoAdListener != null) {
                            fullScreenVideoAdListener.onFullScreenVideoAdLoad(iVar);
                        }
                    }
                    PlayableCache.m9577a().mo15642a(kVar, (C2245a) new C2245a() {
                        /* renamed from: a */
                        public void mo15121a(boolean z) {
                            if (!z && fullScreenVideoAdListener != null) {
                                MaterialMeta kVar = kVar;
                                if (kVar != null && kVar.mo15504r()) {
                                    fullScreenVideoAdListener.onFullScreenVideoCached();
                                }
                            }
                        }
                    });
                    if (kVar.mo15455aa()) {
                        if (z && !kVar.mo15504r() && InternalContainer.m10069h().mo15812r(adSlot.getCodeId()).f7588d == 1) {
                            if (!C2566w.m12245d(FullScreenVideoLoadManager.this.f6917b)) {
                                FullScreenVideoLoadManager cVar = FullScreenVideoLoadManager.this;
                                cVar.m8699a(new C2139a(kVar, adSlot));
                            }
                        } else if (!kVar.mo15504r()) {
                            FullScreenVideoCache.m8664a(FullScreenVideoLoadManager.this.f6917b).mo15097a(kVar, (C2133a<Object>) new C2133a<Object>() {
                                /* renamed from: a */
                                public void mo15105a(boolean z, Object obj) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("download video file: ");
                                    sb.append(z);
                                    sb.append(", preload: ");
                                    sb.append(z);
                                    C2564t.m12220b("FullScreenVideoLoadManager", sb.toString());
                                    if (z) {
                                        iVar.mo15157a(FullScreenVideoCache.m8664a(FullScreenVideoLoadManager.this.f6917b).mo15092a(kVar));
                                    }
                                    if (!z) {
                                        AdEventManager.m8392a(kVar);
                                        if (z && fullScreenVideoAdListener != null) {
                                            fullScreenVideoAdListener.onFullScreenVideoCached();
                                        }
                                    } else if (z) {
                                        FullScreenVideoCache.m8664a(FullScreenVideoLoadManager.this.f6917b).mo15096a(adSlot, kVar);
                                    }
                                }
                            });
                        }
                    } else if (!z) {
                        FullScreenVideoAdListener fullScreenVideoAdListener2 = fullScreenVideoAdListener;
                        if (fullScreenVideoAdListener2 != null) {
                            fullScreenVideoAdListener2.onError(-4, C2240g.m9576a(-4));
                        }
                    }
                } else if (!z) {
                    FullScreenVideoAdListener fullScreenVideoAdListener3 = fullScreenVideoAdListener;
                    if (fullScreenVideoAdListener3 != null) {
                        fullScreenVideoAdListener3.onError(-3, C2240g.m9576a(-3));
                    }
                }
            }
        });
    }

    /* renamed from: a */
    public void mo15116a(String str) {
        FullScreenVideoCache.m8664a(this.f6917b).mo15098a(str);
    }

    /* renamed from: b */
    public AdSlot mo15117b(String str) {
        return FullScreenVideoCache.m8664a(this.f6917b).mo15100b(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8699a(C2139a aVar) {
        if (aVar != null) {
            if (this.f6920e.size() >= 1) {
                this.f6920e.remove(0);
            }
            this.f6920e.add(aVar);
        }
    }

    /* renamed from: c */
    private void m8703c() {
        if (!this.f6919d.get()) {
            this.f6919d.set(true);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            try {
                this.f6917b.registerReceiver(this.f6921f, intentFilter);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: d */
    private void m8704d() {
        if (this.f6919d.get()) {
            this.f6919d.set(false);
            try {
                this.f6917b.unregisterReceiver(this.f6921f);
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        m8704d();
    }
}
