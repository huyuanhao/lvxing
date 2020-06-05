package com.p530ss.android.downloadlib.p541a.p543b;

import android.text.TextUtils;
import com.p530ss.android.downloadad.p538a.p539a.AdDownloadController;
import com.p530ss.android.downloadad.p538a.p540b.NativeDownloadModel;
import com.p530ss.android.downloadlib.DownloadComponentManager;
import com.p530ss.android.p531a.p532a.p534b.C6507c;
import com.p530ss.android.p531a.p532a.p534b.DownloadController;
import com.p530ss.android.p531a.p532a.p534b.DownloadEventConfig;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.ss.android.downloadlib.a.b.c */
public class ModelManager {
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final AtomicBoolean f21313a;
    /* renamed from: b */
    private final ConcurrentHashMap<Long, C6507c> f21314b;
    /* renamed from: c */
    private final ConcurrentHashMap<Long, DownloadEventConfig> f21315c;
    /* renamed from: d */
    private final ConcurrentHashMap<Long, DownloadController> f21316d;
    /* access modifiers changed from: private|final */
    /* renamed from: e */
    public final ConcurrentHashMap<Long, NativeDownloadModel> f21317e;

    /* compiled from: ModelManager */
    /* renamed from: com.ss.android.downloadlib.a.b.c$a */
    public static class C6546a {
        /* renamed from: a */
        public long f21319a;
        /* renamed from: b */
        public C6507c f21320b;
        /* renamed from: c */
        public DownloadEventConfig f21321c;
        /* renamed from: d */
        public DownloadController f21322d;

        public C6546a() {
        }

        public C6546a(long j, C6507c cVar, DownloadEventConfig bVar, DownloadController aVar) {
            this.f21319a = j;
            this.f21320b = cVar;
            this.f21321c = bVar;
            this.f21322d = aVar;
        }

        /* renamed from: a */
        public boolean mo31279a() {
            return this.f21319a <= 0 || this.f21320b == null || this.f21321c == null || this.f21322d == null;
        }
    }

    /* compiled from: ModelManager */
    /* renamed from: com.ss.android.downloadlib.a.b.c$b */
    private static class C6547b {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static ModelManager f21323a = new ModelManager();
    }

    /* renamed from: a */
    public static ModelManager m26169a() {
        return C6547b.f21323a;
    }

    private ModelManager() {
        this.f21313a = new AtomicBoolean(false);
        this.f21314b = new ConcurrentHashMap<>();
        this.f21315c = new ConcurrentHashMap<>();
        this.f21316d = new ConcurrentHashMap<>();
        this.f21317e = new ConcurrentHashMap<>();
    }

    /* renamed from: b */
    public void mo31272b() {
        DownloadComponentManager.m26440a().mo31388b(new Runnable() {
            public void run() {
                if (ModelManager.this.f21313a.compareAndSet(false, true)) {
                    ModelManager.this.f21317e.putAll(SharedPrefsManager.m26192a().mo31283b());
                }
            }
        });
    }

    /* renamed from: a */
    public void mo31267a(C6507c cVar) {
        if (cVar != null) {
            this.f21314b.put(Long.valueOf(cVar.mo31064d()), cVar);
            if (cVar.mo31081u() != null) {
                cVar.mo31081u().mo31101a(cVar.mo31064d());
                cVar.mo31081u().mo31106d(cVar.mo31080t());
            }
        }
    }

    /* renamed from: a */
    public void mo31266a(long j, DownloadEventConfig bVar) {
        if (bVar != null) {
            this.f21315c.put(Long.valueOf(j), bVar);
        }
    }

    /* renamed from: a */
    public void mo31265a(long j, DownloadController aVar) {
        if (aVar != null) {
            this.f21316d.put(Long.valueOf(j), aVar);
        }
    }

    /* renamed from: a */
    public synchronized void mo31268a(NativeDownloadModel aVar) {
        if (aVar != null) {
            this.f21317e.put(Long.valueOf(aVar.mo31194a()), aVar);
            SharedPrefsManager.m26192a().mo31281a(aVar);
        }
    }

    /* renamed from: a */
    public C6507c mo31262a(long j) {
        return (C6507c) this.f21314b.get(Long.valueOf(j));
    }

    /* renamed from: b */
    public DownloadEventConfig mo31271b(long j) {
        return (DownloadEventConfig) this.f21315c.get(Long.valueOf(j));
    }

    /* renamed from: c */
    public DownloadController mo31273c(long j) {
        return (DownloadController) this.f21316d.get(Long.valueOf(j));
    }

    /* renamed from: d */
    public NativeDownloadModel mo31275d(long j) {
        return (NativeDownloadModel) this.f21317e.get(Long.valueOf(j));
    }

    /* renamed from: c */
    public ConcurrentHashMap<Long, NativeDownloadModel> mo31274c() {
        return this.f21317e;
    }

    /* renamed from: a */
    public NativeDownloadModel mo31264a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (NativeDownloadModel aVar : this.f21317e.values()) {
            if (aVar != null && str.equals(aVar.mo31210d())) {
                return aVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    public NativeDownloadModel mo31263a(DownloadInfo cVar) {
        if (cVar == null) {
            return null;
        }
        for (NativeDownloadModel aVar : this.f21317e.values()) {
            if (aVar != null) {
                if (aVar.mo31221k() == cVar.mo32283g() || TextUtils.equals(aVar.mo31227q(), cVar.mo32295j())) {
                    return aVar;
                }
            }
        }
        return null;
    }

    /* renamed from: e */
    public C6546a mo31276e(long j) {
        C6546a aVar = new C6546a();
        aVar.f21319a = j;
        aVar.f21320b = mo31262a(j);
        aVar.f21321c = mo31271b(j);
        aVar.f21322d = mo31273c(j);
        if (aVar.f21322d == null) {
            aVar.f21322d = new AdDownloadController();
        }
        return aVar;
    }

    /* renamed from: f */
    public void mo31277f(long j) {
        this.f21314b.remove(Long.valueOf(j));
        this.f21315c.remove(Long.valueOf(j));
        this.f21316d.remove(Long.valueOf(j));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006f, code lost:
            return;
     */
    /* renamed from: a */
    public synchronized void mo31269a(com.p530ss.android.downloadad.p538a.p540b.NativeDownloadModel r5, com.p530ss.android.socialbase.downloader.p562g.DownloadInfo r6, java.lang.String r7) {
        /*
        r4 = this;
        monitor-enter(r4)
        if (r5 == 0) goto L_0x006e
        if (r6 != 0) goto L_0x0006
        goto L_0x006e
    L_0x0006:
        org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x006b }
        r0.<init>()     // Catch:{ all -> 0x006b }
        java.lang.String r1 = "download_url"
        java.lang.String r2 = r6.mo32295j()     // Catch:{ Exception -> 0x004b }
        r0.put(r1, r2)     // Catch:{ Exception -> 0x004b }
        java.lang.String r1 = "app_name"
        java.lang.String r2 = r6.mo32291i()     // Catch:{ Exception -> 0x004b }
        r0.put(r1, r2)     // Catch:{ Exception -> 0x004b }
        java.lang.String r1 = "cur_bytes"
        long r2 = r6.mo32180Z()     // Catch:{ Exception -> 0x004b }
        r0.put(r1, r2)     // Catch:{ Exception -> 0x004b }
        java.lang.String r1 = "total_bytes"
        long r2 = r6.mo32225ab()     // Catch:{ Exception -> 0x004b }
        r0.put(r1, r2)     // Catch:{ Exception -> 0x004b }
        java.lang.String r1 = "chunk_count"
        int r2 = r6.mo32219aV()     // Catch:{ Exception -> 0x004b }
        r0.put(r1, r2)     // Catch:{ Exception -> 0x004b }
        java.lang.String r1 = "network_quality"
        java.lang.String r2 = r6.mo32227ad()     // Catch:{ Exception -> 0x004b }
        r0.put(r1, r2)     // Catch:{ Exception -> 0x004b }
        java.lang.String r1 = "download_time"
        long r2 = r6.mo32246aw()     // Catch:{ Exception -> 0x004b }
        r0.put(r1, r2)     // Catch:{ Exception -> 0x004b }
        goto L_0x004f
    L_0x004b:
        r6 = move-exception
        r6.printStackTrace()     // Catch:{ all -> 0x006b }
    L_0x004f:
        org.json.JSONObject r6 = r5.mo31218h()     // Catch:{ all -> 0x006b }
        com.p530ss.android.downloadlib.p549e.C6587g.m26517a(r6, r0)     // Catch:{ all -> 0x006b }
        r5.mo31198a(r0)     // Catch:{ all -> 0x006b }
        boolean r6 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x006b }
        if (r6 != 0) goto L_0x0062
        r5.mo31197a(r7)     // Catch:{ all -> 0x006b }
    L_0x0062:
        com.ss.android.downloadlib.a.b.e r6 = com.p530ss.android.downloadlib.p541a.p543b.SharedPrefsManager.m26192a()     // Catch:{ all -> 0x006b }
        r6.mo31281a(r5)     // Catch:{ all -> 0x006b }
        monitor-exit(r4)
        return
    L_0x006b:
        r5 = move-exception
        monitor-exit(r4)
        throw r5
    L_0x006e:
        monitor-exit(r4)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.downloadlib.p541a.p543b.ModelManager.mo31269a(com.ss.android.downloadad.a.b.a, com.ss.android.socialbase.downloader.g.c, java.lang.String):void");
    }

    /* renamed from: a */
    public synchronized void mo31270a(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        for (Long longValue : list) {
            long longValue2 = longValue.longValue();
            arrayList.add(String.valueOf(longValue2));
            this.f21317e.remove(Long.valueOf(longValue2));
        }
        SharedPrefsManager.m26192a().mo31284b(arrayList);
    }
}
