package com.bytedance.sdk.openadsdk.p190h;

import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.p190h.C2482i.C2484b;
import com.bytedance.sdk.openadsdk.p190h.Urls.C2488a;
import com.bytedance.sdk.openadsdk.p190h.p191a.C2440a;
import com.bytedance.sdk.openadsdk.p190h.p191a.C2441b;
import com.bytedance.sdk.openadsdk.p190h.p192b.VideoProxyDB;
import com.bytedance.sdk.openadsdk.p190h.p193c.CancelException;
import com.bytedance.sdk.openadsdk.p190h.p194d.VideoCacheProgressListener;
import com.bytedance.sdk.openadsdk.p190h.p195e.AbsResponseWrapper;
import com.bytedance.sdk.openadsdk.p190h.p195e.INetworkSource;
import com.bytedance.sdk.openadsdk.p190h.p195e.NetworkSourceManager;
import com.bytedance.sdk.openadsdk.p190h.p195e.VideoRequest;
import com.bytedance.sdk.openadsdk.p190h.p197g.C2479d;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.bytedance.sdk.openadsdk.h.a */
abstract class AbsTask implements C2487k {
    /* renamed from: m */
    private static final AtomicLong f8734m = new AtomicLong();
    /* renamed from: a */
    protected volatile C2440a f8735a;
    /* renamed from: b */
    protected final VideoProxyDB f8736b;
    /* renamed from: c */
    protected final AtomicInteger f8737c = new AtomicInteger();
    /* renamed from: d */
    protected final AtomicLong f8738d = new AtomicLong();
    /* renamed from: e */
    protected VideoCacheProgressListener f8739e;
    /* renamed from: f */
    protected volatile List<C2484b> f8740f;
    /* renamed from: g */
    protected volatile String f8741g;
    /* renamed from: h */
    protected volatile String f8742h;
    /* renamed from: i */
    protected volatile C2482i f8743i;
    /* renamed from: j */
    protected volatile Urls f8744j;
    /* renamed from: k */
    protected volatile boolean f8745k = false;
    /* renamed from: l */
    public final long f8746l = f8734m.incrementAndGet();
    /* renamed from: n */
    private final AtomicInteger f8747n = new AtomicInteger(0);
    /* access modifiers changed from: private */
    /* renamed from: o */
    public int f8748o = -1;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo16664a(Boolean bool, String str, Throwable th) {
    }

    public AbsTask(C2440a aVar, VideoProxyDB cVar) {
        this.f8735a = aVar;
        this.f8736b = cVar;
    }

    /* renamed from: a */
    public void mo16662a() {
        this.f8747n.compareAndSet(0, 1);
    }

    /* renamed from: b */
    public boolean mo16665b() {
        return this.f8747n.get() == 1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo16666c() {
        this.f8747n.compareAndSet(0, 2);
    }

    /* renamed from: d */
    public boolean mo16667d() {
        return this.f8747n.get() == 2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo16668e() throws CancelException {
        if (mo16665b()) {
            throw new CancelException();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public AbsResponseWrapper mo16661a(C2488a aVar, int i, int i2, String str) throws IOException, VAdError {
        INetworkSource b = NetworkSourceManager.m11558a().mo16752b();
        VideoRequest fVar = new VideoRequest();
        HashMap hashMap = new HashMap();
        fVar.f8850b = aVar.f8947a;
        fVar.f8849a = 0;
        if ("HEAD".equalsIgnoreCase(str)) {
            fVar.f8849a = 4;
        }
        List<C2484b> list = this.f8740f;
        String str2 = "Range";
        if (list != null && !list.isEmpty()) {
            for (C2484b bVar : list) {
                if (!str2.equalsIgnoreCase(bVar.f8931a)) {
                    if (!"Connection".equalsIgnoreCase(bVar.f8931a)) {
                        if (!"Proxy-Connection".equalsIgnoreCase(bVar.f8931a)) {
                            if (!"Host".equalsIgnoreCase(bVar.f8931a)) {
                                hashMap.put(bVar.f8931a, bVar.f8932b);
                            }
                        }
                    }
                }
            }
        }
        String a = C2479d.m11655a(i, i2);
        if (a != null) {
            hashMap.put(str2, a);
        }
        if (Proxy.f8839f) {
            hashMap.put("Cache-Control", "no-cache");
        }
        Preloader c = Preloader.m11521c();
        ProxyServer a2 = ProxyServer.m11573a();
        boolean z = this.f8743i == null;
        IncrementalTimeout a3 = z ? c.mo16719a() : a2.mo16757b();
        IncrementalTimeout b2 = z ? c.mo16729b() : a2.mo16758c();
        if (!(a3 == null && b2 == null)) {
            if (a3 != null) {
                fVar.f8851c = a3.mo16718a(aVar.f8948b);
            }
            if (b2 != null) {
                fVar.f8852d = b2.mo16718a(aVar.f8948b);
            }
        }
        fVar.f8853e = hashMap;
        if (!this.f8745k) {
            return b.mo16751a(fVar);
        }
        this.f8745k = false;
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public int mo16669f() {
        if (this.f8743i != null) {
            return this.f8743i.f8923c.f8924a;
        }
        return this.f8735a instanceof C2441b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public boolean mo16670g() {
        return mo16669f() == 1;
    }

    /* JADX INFO: used method not loaded: com.bytedance.sdk.openadsdk.h.g.d.b(java.lang.Runnable):null, types can be incorrect */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
            com.bytedance.sdk.openadsdk.p190h.p197g.C2479d.m11672b((java.lang.Runnable) new com.bytedance.sdk.openadsdk.p190h.AbsTask.C24391(r4));
     */
    /* renamed from: a */
    public void mo16663a(int r5, int r6) {
        /*
        r4 = this;
        if (r5 <= 0) goto L_0x0037
        if (r6 >= 0) goto L_0x0005
        goto L_0x0037
    L_0x0005:
        int r0 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8840g
        int r1 = r4.mo16669f()
        r2 = 1
        if (r0 == r2) goto L_0x0013
        r3 = 2
        if (r0 != r3) goto L_0x0033
        if (r1 != r2) goto L_0x0033
    L_0x0013:
        float r6 = (float) r6
        float r5 = (float) r5
        float r6 = r6 / r5
        r5 = 1120403456(0x42c80000, float:100.0)
        float r6 = r6 * r5
        int r5 = (int) r6
        r6 = 100
        if (r5 <= r6) goto L_0x0021
        r5 = 100
    L_0x0021:
        monitor-enter(r4)
        int r6 = r4.f8748o     // Catch:{ all -> 0x0034 }
        if (r5 > r6) goto L_0x0028
        monitor-exit(r4)     // Catch:{ all -> 0x0034 }
        return
    L_0x0028:
        r4.f8748o = r5     // Catch:{ all -> 0x0034 }
        monitor-exit(r4)     // Catch:{ all -> 0x0034 }
        com.bytedance.sdk.openadsdk.h.a$1 r5 = new com.bytedance.sdk.openadsdk.h.a$1
        r5.m44044init()
        com.bytedance.sdk.openadsdk.p190h.p197g.C2479d.m11672b(r5)
    L_0x0033:
        return
    L_0x0034:
        r5 = move-exception
        monitor-exit(r4)     // Catch:{ all -> 0x0034 }
        throw r5
    L_0x0037:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.p190h.AbsTask.mo16663a(int, int):void");
    }
}
