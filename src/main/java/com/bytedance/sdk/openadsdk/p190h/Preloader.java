package com.bytedance.sdk.openadsdk.p190h;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.p190h.DownloadTask.C2453b;
import com.bytedance.sdk.openadsdk.p190h.p191a.C2441b;
import com.bytedance.sdk.openadsdk.p190h.p191a.C2443c;
import com.bytedance.sdk.openadsdk.p190h.p192b.VideoHttpHeaderTableContract;
import com.bytedance.sdk.openadsdk.p190h.p192b.VideoProxyDB;
import com.bytedance.sdk.openadsdk.p190h.p197g.C2479d;
import com.bytedance.sdk.openadsdk.p190h.p197g.MD5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.bytedance.sdk.openadsdk.h.d */
public class Preloader {
    /* renamed from: e */
    private static volatile Preloader f8805e;
    /* renamed from: a */
    private volatile int f8806a = 163840;
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final SparseArray<Map<String, DownloadTask>> f8807b = new SparseArray<>(2);
    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final C2463b<Runnable> f8808c = new C2463b<>();
    /* renamed from: d */
    private final ExecutorService f8809d = m11519a(this.f8808c);
    /* renamed from: f */
    private volatile VideoProxyDB f8810f;
    /* renamed from: g */
    private volatile C2443c f8811g;
    /* renamed from: h */
    private volatile C2441b f8812h;
    /* renamed from: i */
    private final HashSet<C2462a> f8813i = new HashSet<>();
    /* renamed from: j */
    private final C2453b f8814j = new C2453b() {
        /* renamed from: a */
        public void mo16709a(DownloadTask bVar) {
            int f = bVar.mo16669f();
            synchronized (Preloader.this.f8807b) {
                Map map = (Map) Preloader.this.f8807b.get(f);
                if (map != null) {
                    map.remove(bVar.f8742h);
                }
            }
            if (Proxy.f8836c) {
                StringBuilder sb = new StringBuilder();
                sb.append("afterExecute, key: ");
                sb.append(bVar.f8742h);
                Log.d("TAG_PROXY_Preloader", sb.toString());
            }
        }
    };
    /* renamed from: k */
    private volatile IncrementalTimeout f8815k;
    /* renamed from: l */
    private volatile IncrementalTimeout f8816l;
    /* renamed from: m */
    private volatile String f8817m;
    /* renamed from: n */
    private volatile boolean f8818n;

    /* compiled from: Preloader */
    /* renamed from: com.bytedance.sdk.openadsdk.h.d$a */
    private static final class C2462a {
        /* renamed from: a */
        final boolean f8827a;
        /* renamed from: b */
        final boolean f8828b;
        /* renamed from: c */
        final int f8829c;
        /* renamed from: d */
        final String f8830d;
        /* renamed from: e */
        final Map<String, String> f8831e;
        /* renamed from: f */
        final String[] f8832f;

        C2462a(boolean z, boolean z2, int i, String str, Map<String, String> map, String[] strArr) {
            this.f8827a = z;
            this.f8828b = z2;
            this.f8829c = i;
            this.f8830d = str;
            this.f8831e = map;
            this.f8832f = strArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C2462a aVar = (C2462a) obj;
            if (this.f8827a == aVar.f8827a && this.f8828b == aVar.f8828b && this.f8829c == aVar.f8829c) {
                return this.f8830d.equals(aVar.f8830d);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f8827a * true) + this.f8828b) * 31) + this.f8829c) * 31) + this.f8830d.hashCode();
        }
    }

    /* compiled from: Preloader */
    /* renamed from: com.bytedance.sdk.openadsdk.h.d$b */
    private static final class C2463b<T> extends LinkedBlockingDeque<T> {
        /* renamed from: a */
        private ThreadPoolExecutor f8833a;

        private C2463b() {
        }

        /* renamed from: a */
        public void mo16738a(ThreadPoolExecutor threadPoolExecutor) {
            synchronized (this) {
                if (this.f8833a != null) {
                    throw new IllegalStateException("You can only call setExecutor() once!");
                } else if (threadPoolExecutor != null) {
                    this.f8833a = threadPoolExecutor;
                } else {
                    throw new NullPointerException("executor argument can't be null!");
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
            return offerFirst(r4);
     */
        public boolean offer(T r4) {
            /*
            r3 = this;
            monitor-enter(r3)
            java.util.concurrent.ThreadPoolExecutor r0 = r3.f8833a     // Catch:{ all -> 0x002b }
            int r0 = r0.getPoolSize()     // Catch:{ all -> 0x002b }
            java.util.concurrent.ThreadPoolExecutor r1 = r3.f8833a     // Catch:{ all -> 0x002b }
            int r1 = r1.getActiveCount()     // Catch:{ all -> 0x002b }
            java.util.concurrent.ThreadPoolExecutor r2 = r3.f8833a     // Catch:{ all -> 0x002b }
            int r2 = r2.getMaximumPoolSize()     // Catch:{ all -> 0x002b }
            if (r1 < r0) goto L_0x0025
            if (r0 >= r2) goto L_0x0025
            boolean r4 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c     // Catch:{ all -> 0x002b }
            if (r4 == 0) goto L_0x0022
            java.lang.String r4 = "TAG_PROXY_TT"
            java.lang.String r0 = "create new preloader thread"
            android.util.Log.i(r4, r0)     // Catch:{ all -> 0x002b }
        L_0x0022:
            r4 = 0
            monitor-exit(r3)     // Catch:{ all -> 0x002b }
            return r4
        L_0x0025:
            monitor-exit(r3)     // Catch:{ all -> 0x002b }
            boolean r4 = r3.offerFirst(r4)
            return r4
        L_0x002b:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x002b }
            throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.p190h.Preloader.C2463b.offer(java.lang.Object):boolean");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo16722a(C2443c cVar) {
        this.f8811g = cVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo16723a(VideoProxyDB cVar) {
        this.f8810f = cVar;
    }

    /* renamed from: a */
    public void mo16720a(int i) {
        if (i > 0) {
            this.f8806a = i;
        }
        if (Proxy.f8836c) {
            StringBuilder sb = new StringBuilder();
            sb.append("MaxPreloadSize: ");
            sb.append(i);
            Log.i("TAG_PROXY_Preloader", sb.toString());
        }
    }

    private Preloader() {
        this.f8808c.mo16738a((ThreadPoolExecutor) this.f8809d);
        this.f8807b.put(0, new HashMap());
        this.f8807b.put(1, new HashMap());
    }

    /* renamed from: a */
    public synchronized void mo16721a(long j, long j2, long j3) {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public IncrementalTimeout mo16719a() {
        return this.f8815k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public IncrementalTimeout mo16729b() {
        return this.f8816l;
    }

    /* renamed from: c */
    public static Preloader m11521c() {
        if (f8805e == null) {
            synchronized (Preloader.class) {
                if (f8805e == null) {
                    f8805e = new Preloader();
                }
            }
        }
        return f8805e;
    }

    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.util.HashSet] */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10, types: [java.util.HashSet] */
    /* JADX WARNING: type inference failed for: r0v11, types: [java.util.HashSet] */
    /* JADX WARNING: type inference failed for: r0v12, types: [com.bytedance.sdk.openadsdk.h.b] */
    /* JADX WARNING: type inference failed for: r0v14, types: [com.bytedance.sdk.openadsdk.h.b] */
    /* JADX WARNING: type inference failed for: r0v15, types: [java.util.HashSet] */
    /* JADX WARNING: type inference failed for: r0v20, types: [java.util.HashSet] */
    /* JADX WARNING: type inference failed for: r0v23 */
    /* JADX WARNING: type inference failed for: r0v24 */
    /* JADX WARNING: type inference failed for: r0v25 */
    /* JADX WARNING: type inference failed for: r0v26 */
    /* JADX WARNING: type inference failed for: r0v27 */
    /* JADX WARNING: type inference failed for: r0v28 */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v8
  assigns: []
  uses: []
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* renamed from: a */
    public void mo16725a(boolean r8, java.lang.String r9) {
        /*
        r7 = this;
        r7.f8817m = r9
        r7.f8818n = r8
        boolean r0 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c
        if (r0 == 0) goto L_0x001e
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "setCurrentPlayKey, "
        r0.append(r1)
        r0.append(r9)
        java.lang.String r0 = r0.toString()
        java.lang.String r1 = "TAG_PROXY_Preloader"
        android.util.Log.i(r1, r0)
    L_0x001e:
        r0 = 0
        if (r9 != 0) goto L_0x007b
        java.util.HashSet<com.bytedance.sdk.openadsdk.h.d$a> r1 = r7.f8813i
        monitor-enter(r1)
        java.util.HashSet<com.bytedance.sdk.openadsdk.h.d$a> r8 = r7.f8813i     // Catch:{ all -> 0x0078 }
        boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x0078 }
        if (r8 != 0) goto L_0x0038
        java.util.HashSet r0 = new java.util.HashSet     // Catch:{ all -> 0x0078 }
        java.util.HashSet<com.bytedance.sdk.openadsdk.h.d$a> r8 = r7.f8813i     // Catch:{ all -> 0x0078 }
        r0.<init>(r8)     // Catch:{ all -> 0x0078 }
        java.util.HashSet<com.bytedance.sdk.openadsdk.h.d$a> r8 = r7.f8813i     // Catch:{ all -> 0x0078 }
        r8.clear()     // Catch:{ all -> 0x0078 }
    L_0x0038:
        monitor-exit(r1)     // Catch:{ all -> 0x0078 }
        if (r0 == 0) goto L_0x0141
        java.util.Iterator r8 = r0.iterator()
    L_0x003f:
        boolean r9 = r8.hasNext()
        if (r9 == 0) goto L_0x0141
        java.lang.Object r9 = r8.next()
        com.bytedance.sdk.openadsdk.h.d$a r9 = (com.bytedance.sdk.openadsdk.p190h.Preloader.C2462a) r9
        boolean r1 = r9.f8827a
        boolean r2 = r9.f8828b
        int r3 = r9.f8829c
        java.lang.String r4 = r9.f8830d
        java.util.Map<java.lang.String, java.lang.String> r5 = r9.f8831e
        java.lang.String[] r6 = r9.f8832f
        r0 = r7
        r0.mo16726a(r1, r2, r3, r4, r5, r6)
        boolean r0 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c
        if (r0 == 0) goto L_0x003f
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "setCurrentPlayKey, resume preload: "
        r0.append(r1)
        java.lang.String r9 = r9.f8830d
        r0.append(r9)
        java.lang.String r9 = r0.toString()
        java.lang.String r0 = "TAG_PROXY_Preloader"
        android.util.Log.i(r0, r9)
        goto L_0x003f
    L_0x0078:
        r8 = move-exception
        monitor-exit(r1)     // Catch:{ all -> 0x0078 }
        throw r8
    L_0x007b:
        int r1 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8841h
        r2 = 3
        if (r1 == r2) goto L_0x00aa
        r3 = 2
        if (r1 != r3) goto L_0x0084
        goto L_0x00aa
    L_0x0084:
        r2 = 1
        if (r1 != r2) goto L_0x0141
        android.util.SparseArray<java.util.Map<java.lang.String, com.bytedance.sdk.openadsdk.h.b>> r1 = r7.f8807b
        monitor-enter(r1)
        android.util.SparseArray<java.util.Map<java.lang.String, com.bytedance.sdk.openadsdk.h.b>> r2 = r7.f8807b     // Catch:{ all -> 0x00a7 }
        int r8 = com.bytedance.sdk.openadsdk.p190h.p192b.VideoHttpHeaderTableContract.m11507a(r8)     // Catch:{ all -> 0x00a7 }
        java.lang.Object r8 = r2.get(r8)     // Catch:{ all -> 0x00a7 }
        java.util.Map r8 = (java.util.Map) r8     // Catch:{ all -> 0x00a7 }
        if (r8 == 0) goto L_0x009f
        java.lang.Object r8 = r8.remove(r9)     // Catch:{ all -> 0x00a7 }
        r0 = r8
        com.bytedance.sdk.openadsdk.h.b r0 = (com.bytedance.sdk.openadsdk.p190h.DownloadTask) r0     // Catch:{ all -> 0x00a7 }
    L_0x009f:
        monitor-exit(r1)     // Catch:{ all -> 0x00a7 }
        if (r0 == 0) goto L_0x0141
        r0.mo16662a()
        goto L_0x0141
    L_0x00a7:
        r8 = move-exception
        monitor-exit(r1)     // Catch:{ all -> 0x00a7 }
        throw r8
    L_0x00aa:
        android.util.SparseArray<java.util.Map<java.lang.String, com.bytedance.sdk.openadsdk.h.b>> r8 = r7.f8807b
        monitor-enter(r8)
        r9 = 0
        android.util.SparseArray<java.util.Map<java.lang.String, com.bytedance.sdk.openadsdk.h.b>> r3 = r7.f8807b     // Catch:{ all -> 0x0142 }
        int r3 = r3.size()     // Catch:{ all -> 0x0142 }
    L_0x00b4:
        if (r9 >= r3) goto L_0x00e2
        android.util.SparseArray<java.util.Map<java.lang.String, com.bytedance.sdk.openadsdk.h.b>> r4 = r7.f8807b     // Catch:{ all -> 0x0142 }
        android.util.SparseArray<java.util.Map<java.lang.String, com.bytedance.sdk.openadsdk.h.b>> r5 = r7.f8807b     // Catch:{ all -> 0x0142 }
        int r5 = r5.keyAt(r9)     // Catch:{ all -> 0x0142 }
        java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x0142 }
        java.util.Map r4 = (java.util.Map) r4     // Catch:{ all -> 0x0142 }
        if (r4 == 0) goto L_0x00df
        java.util.Collection r5 = r4.values()     // Catch:{ all -> 0x0142 }
        if (r5 == 0) goto L_0x00dc
        boolean r6 = r5.isEmpty()     // Catch:{ all -> 0x0142 }
        if (r6 != 0) goto L_0x00dc
        if (r0 != 0) goto L_0x00d9
        java.util.HashSet r0 = new java.util.HashSet     // Catch:{ all -> 0x0142 }
        r0.<init>()     // Catch:{ all -> 0x0142 }
    L_0x00d9:
        r0.addAll(r5)     // Catch:{ all -> 0x0142 }
    L_0x00dc:
        r4.clear()     // Catch:{ all -> 0x0142 }
    L_0x00df:
        int r9 = r9 + 1
        goto L_0x00b4
    L_0x00e2:
        monitor-exit(r8)     // Catch:{ all -> 0x0142 }
        if (r0 == 0) goto L_0x0141
        boolean r8 = r0.isEmpty()
        if (r8 != 0) goto L_0x0141
        java.util.Iterator r8 = r0.iterator()
    L_0x00ef:
        boolean r9 = r8.hasNext()
        if (r9 == 0) goto L_0x011b
        java.lang.Object r9 = r8.next()
        com.bytedance.sdk.openadsdk.h.b r9 = (com.bytedance.sdk.openadsdk.p190h.DownloadTask) r9
        r9.mo16662a()
        boolean r3 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c
        if (r3 == 0) goto L_0x00ef
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r4 = "setCurrentPlayKey, cancel preload: "
        r3.append(r4)
        java.lang.String r9 = r9.f8741g
        r3.append(r9)
        java.lang.String r9 = r3.toString()
        java.lang.String r3 = "TAG_PROXY_Preloader"
        android.util.Log.i(r3, r9)
        goto L_0x00ef
    L_0x011b:
        if (r1 != r2) goto L_0x0141
        java.util.HashSet<com.bytedance.sdk.openadsdk.h.d$a> r8 = r7.f8813i
        monitor-enter(r8)
        java.util.Iterator r9 = r0.iterator()     // Catch:{ all -> 0x013e }
    L_0x0124:
        boolean r0 = r9.hasNext()     // Catch:{ all -> 0x013e }
        if (r0 == 0) goto L_0x013c
        java.lang.Object r0 = r9.next()     // Catch:{ all -> 0x013e }
        com.bytedance.sdk.openadsdk.h.b r0 = (com.bytedance.sdk.openadsdk.p190h.DownloadTask) r0     // Catch:{ all -> 0x013e }
        java.lang.Object r0 = r0.f8773n     // Catch:{ all -> 0x013e }
        com.bytedance.sdk.openadsdk.h.d$a r0 = (com.bytedance.sdk.openadsdk.p190h.Preloader.C2462a) r0     // Catch:{ all -> 0x013e }
        if (r0 == 0) goto L_0x0124
        java.util.HashSet<com.bytedance.sdk.openadsdk.h.d$a> r1 = r7.f8813i     // Catch:{ all -> 0x013e }
        r1.add(r0)     // Catch:{ all -> 0x013e }
        goto L_0x0124
    L_0x013c:
        monitor-exit(r8)     // Catch:{ all -> 0x013e }
        goto L_0x0141
    L_0x013e:
        r9 = move-exception
        monitor-exit(r8)     // Catch:{ all -> 0x013e }
        throw r9
    L_0x0141:
        return
    L_0x0142:
        r9 = move-exception
        monitor-exit(r8)     // Catch:{ all -> 0x0142 }
        throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.p190h.Preloader.mo16725a(boolean, java.lang.String):void");
    }

    /* renamed from: a */
    public void mo16727a(boolean z, boolean z2, int i, String str, String... strArr) {
        mo16726a(z, z2, i, str, null, strArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0105, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0127, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0154, code lost:
            return;
     */
    /* renamed from: a */
    public void mo16726a(boolean r19, boolean r20, int r21, java.lang.String r22, java.util.Map<java.lang.String, java.lang.String> r23, java.lang.String... r24) {
        /*
        r18 = this;
        r1 = r18
        r0 = r19
        r9 = r22
        r10 = r24
        boolean r2 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c
        if (r2 == 0) goto L_0x0013
        java.lang.String r2 = "TAG_PROXY_Preloader"
        java.lang.String r3 = "preload start ！！！！"
        android.util.Log.d(r2, r3)
    L_0x0013:
        if (r0 == 0) goto L_0x0018
        com.bytedance.sdk.openadsdk.h.a.b r2 = r1.f8812h
        goto L_0x001a
    L_0x0018:
        com.bytedance.sdk.openadsdk.h.a.c r2 = r1.f8811g
    L_0x001a:
        r11 = r2
        com.bytedance.sdk.openadsdk.h.b.c r12 = r1.f8810f
        if (r11 == 0) goto L_0x01d1
        if (r12 != 0) goto L_0x0023
        goto L_0x01d1
    L_0x0023:
        boolean r2 = android.text.TextUtils.isEmpty(r22)
        if (r2 != 0) goto L_0x01d0
        if (r10 == 0) goto L_0x01d0
        int r2 = r10.length
        if (r2 > 0) goto L_0x0030
        goto L_0x01d0
    L_0x0030:
        if (r21 > 0) goto L_0x0036
        int r2 = r1.f8806a
        r13 = r2
        goto L_0x0038
    L_0x0036:
        r13 = r21
    L_0x0038:
        if (r20 == 0) goto L_0x003c
        r14 = r9
        goto L_0x0041
    L_0x003c:
        java.lang.String r2 = com.bytedance.sdk.openadsdk.p190h.p197g.MD5.m11646a(r22)
        r14 = r2
    L_0x0041:
        java.io.File r2 = r11.mo16675d(r14)
        if (r2 == 0) goto L_0x0077
        long r3 = r2.length()
        long r5 = (long) r13
        int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
        if (r7 < 0) goto L_0x0077
        boolean r0 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c
        if (r0 == 0) goto L_0x0076
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r3 = "no need preload, file size: "
        r0.append(r3)
        long r2 = r2.length()
        r0.append(r2)
        java.lang.String r2 = ", need preload size: "
        r0.append(r2)
        r0.append(r13)
        java.lang.String r0 = r0.toString()
        java.lang.String r2 = "TAG_PROXY_Preloader"
        android.util.Log.i(r2, r0)
    L_0x0076:
        return
    L_0x0077:
        com.bytedance.sdk.openadsdk.h.f r2 = com.bytedance.sdk.openadsdk.p190h.ProxyServer.m11573a()
        int r3 = com.bytedance.sdk.openadsdk.p190h.p192b.VideoHttpHeaderTableContract.m11507a(r19)
        boolean r2 = r2.mo16756a(r3, r14)
        if (r2 == 0) goto L_0x00a0
        boolean r0 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c
        if (r0 == 0) goto L_0x009f
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r2 = "has running proxy task, skip preload for key: "
        r0.append(r2)
        r0.append(r9)
        java.lang.String r0 = r0.toString()
        java.lang.String r2 = "TAG_PROXY_Preloader"
        android.util.Log.w(r2, r0)
    L_0x009f:
        return
    L_0x00a0:
        android.util.SparseArray<java.util.Map<java.lang.String, com.bytedance.sdk.openadsdk.h.b>> r15 = r1.f8807b
        monitor-enter(r15)
        android.util.SparseArray<java.util.Map<java.lang.String, com.bytedance.sdk.openadsdk.h.b>> r2 = r1.f8807b     // Catch:{ all -> 0x01cd }
        r16 = 0
        r8 = 1
        if (r0 == 0) goto L_0x00ac
        r3 = 1
        goto L_0x00ad
    L_0x00ac:
        r3 = 0
    L_0x00ad:
        java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x01cd }
        r7 = r2
        java.util.Map r7 = (java.util.Map) r7     // Catch:{ all -> 0x01cd }
        boolean r2 = r7.containsKey(r14)     // Catch:{ all -> 0x01cd }
        if (r2 == 0) goto L_0x00bc
        monitor-exit(r15)     // Catch:{ all -> 0x01cd }
        return
    L_0x00bc:
        com.bytedance.sdk.openadsdk.h.d$a r6 = new com.bytedance.sdk.openadsdk.h.d$a     // Catch:{ all -> 0x01cd }
        r2 = r6
        r3 = r19
        r4 = r20
        r5 = r13
        r10 = r6
        r6 = r22
        r17 = r7
        r7 = r23
        r21 = r13
        r13 = 1
        r8 = r24
        r2.m44074init(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x01cd }
        java.lang.String r2 = r1.f8817m     // Catch:{ all -> 0x01cd }
        if (r2 == 0) goto L_0x0155
        int r3 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8841h     // Catch:{ all -> 0x01cd }
        r4 = 3
        if (r3 != r4) goto L_0x0109
        java.util.HashSet<com.bytedance.sdk.openadsdk.h.d$a> r2 = r1.f8813i     // Catch:{ all -> 0x01cd }
        monitor-enter(r2)     // Catch:{ all -> 0x01cd }
        java.util.HashSet<com.bytedance.sdk.openadsdk.h.d$a> r0 = r1.f8813i     // Catch:{ all -> 0x0106 }
        r0.add(r10)     // Catch:{ all -> 0x0106 }
        monitor-exit(r2)     // Catch:{ all -> 0x0106 }
        boolean r0 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c     // Catch:{ all -> 0x01cd }
        if (r0 == 0) goto L_0x0104
        java.lang.String r0 = "TAG_PROXY_Preloader"
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01cd }
        r2.<init>()     // Catch:{ all -> 0x01cd }
        java.lang.String r3 = "cancel preload: "
        r2.append(r3)     // Catch:{ all -> 0x01cd }
        r2.append(r9)     // Catch:{ all -> 0x01cd }
        java.lang.String r3 = ", add to pending queue"
        r2.append(r3)     // Catch:{ all -> 0x01cd }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01cd }
        android.util.Log.w(r0, r2)     // Catch:{ all -> 0x01cd }
    L_0x0104:
        monitor-exit(r15)     // Catch:{ all -> 0x01cd }
        return
    L_0x0106:
        r0 = move-exception
        monitor-exit(r2)     // Catch:{ all -> 0x0106 }
        throw r0     // Catch:{ all -> 0x01cd }
    L_0x0109:
        r4 = 2
        if (r3 != r4) goto L_0x0128
        boolean r0 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c     // Catch:{ all -> 0x01cd }
        if (r0 == 0) goto L_0x0126
        java.lang.String r0 = "TAG_PROXY_Preloader"
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01cd }
        r2.<init>()     // Catch:{ all -> 0x01cd }
        java.lang.String r3 = "cancel preload: "
        r2.append(r3)     // Catch:{ all -> 0x01cd }
        r2.append(r9)     // Catch:{ all -> 0x01cd }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01cd }
        android.util.Log.w(r0, r2)     // Catch:{ all -> 0x01cd }
    L_0x0126:
        monitor-exit(r15)     // Catch:{ all -> 0x01cd }
        return
    L_0x0128:
        if (r3 != r13) goto L_0x0155
        boolean r3 = r1.f8818n     // Catch:{ all -> 0x01cd }
        if (r3 != r0) goto L_0x0155
        boolean r0 = r2.equals(r14)     // Catch:{ all -> 0x01cd }
        if (r0 == 0) goto L_0x0155
        boolean r0 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c     // Catch:{ all -> 0x01cd }
        if (r0 == 0) goto L_0x0153
        java.lang.String r0 = "TAG_PROXY_Preloader"
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01cd }
        r2.<init>()     // Catch:{ all -> 0x01cd }
        java.lang.String r3 = "cancel preload: "
        r2.append(r3)     // Catch:{ all -> 0x01cd }
        r2.append(r9)     // Catch:{ all -> 0x01cd }
        java.lang.String r3 = ", it is playing"
        r2.append(r3)     // Catch:{ all -> 0x01cd }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01cd }
        android.util.Log.w(r0, r2)     // Catch:{ all -> 0x01cd }
    L_0x0153:
        monitor-exit(r15)     // Catch:{ all -> 0x01cd }
        return
    L_0x0155:
        r0 = 0
        java.util.List r2 = com.bytedance.sdk.openadsdk.p190h.p197g.C2479d.m11660a(r23)     // Catch:{ all -> 0x01cd }
        java.util.List r2 = com.bytedance.sdk.openadsdk.p190h.p197g.C2479d.m11659a(r2)     // Catch:{ all -> 0x01cd }
        if (r2 == 0) goto L_0x0187
        java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x01cd }
        int r3 = r2.size()     // Catch:{ all -> 0x01cd }
        r0.<init>(r3)     // Catch:{ all -> 0x01cd }
        int r3 = r2.size()     // Catch:{ all -> 0x01cd }
        r4 = 0
    L_0x016e:
        if (r4 >= r3) goto L_0x0187
        java.lang.Object r5 = r2.get(r4)     // Catch:{ all -> 0x01cd }
        com.bytedance.sdk.openadsdk.h.i$b r5 = (com.bytedance.sdk.openadsdk.p190h.C2482i.C2484b) r5     // Catch:{ all -> 0x01cd }
        if (r5 == 0) goto L_0x0184
        com.bytedance.sdk.openadsdk.h.i$b r6 = new com.bytedance.sdk.openadsdk.h.i$b     // Catch:{ all -> 0x01cd }
        java.lang.String r7 = r5.f8931a     // Catch:{ all -> 0x01cd }
        java.lang.String r5 = r5.f8932b     // Catch:{ all -> 0x01cd }
        r6.m44113init(r7, r5)     // Catch:{ all -> 0x01cd }
        r0.add(r6)     // Catch:{ all -> 0x01cd }
    L_0x0184:
        int r4 = r4 + 1
        goto L_0x016e
    L_0x0187:
        com.bytedance.sdk.openadsdk.h.b$a r2 = new com.bytedance.sdk.openadsdk.h.b$a     // Catch:{ all -> 0x01cd }
        r2.m44057init()     // Catch:{ all -> 0x01cd }
        com.bytedance.sdk.openadsdk.h.b$a r2 = r2.mo16699a(r11)     // Catch:{ all -> 0x01cd }
        com.bytedance.sdk.openadsdk.h.b$a r2 = r2.mo16701a(r12)     // Catch:{ all -> 0x01cd }
        com.bytedance.sdk.openadsdk.h.b$a r2 = r2.mo16705a(r9)     // Catch:{ all -> 0x01cd }
        com.bytedance.sdk.openadsdk.h.b$a r2 = r2.mo16708b(r14)     // Catch:{ all -> 0x01cd }
        com.bytedance.sdk.openadsdk.h.l r3 = new com.bytedance.sdk.openadsdk.h.l     // Catch:{ all -> 0x01cd }
        java.util.List r4 = com.bytedance.sdk.openadsdk.p190h.p197g.C2479d.m11661a(r24)     // Catch:{ all -> 0x01cd }
        r3.m44120init(r4)     // Catch:{ all -> 0x01cd }
        com.bytedance.sdk.openadsdk.h.b$a r2 = r2.mo16703a(r3)     // Catch:{ all -> 0x01cd }
        com.bytedance.sdk.openadsdk.h.b$a r0 = r2.mo16706a(r0)     // Catch:{ all -> 0x01cd }
        r2 = r21
        com.bytedance.sdk.openadsdk.h.b$a r0 = r0.mo16698a(r2)     // Catch:{ all -> 0x01cd }
        com.bytedance.sdk.openadsdk.h.b$b r2 = r1.f8814j     // Catch:{ all -> 0x01cd }
        com.bytedance.sdk.openadsdk.h.b$a r0 = r0.mo16700a(r2)     // Catch:{ all -> 0x01cd }
        com.bytedance.sdk.openadsdk.h.b$a r0 = r0.mo16704a(r10)     // Catch:{ all -> 0x01cd }
        com.bytedance.sdk.openadsdk.h.b r0 = r0.mo16707a()     // Catch:{ all -> 0x01cd }
        r2 = r17
        r2.put(r14, r0)     // Catch:{ all -> 0x01cd }
        monitor-exit(r15)     // Catch:{ all -> 0x01cd }
        java.util.concurrent.ExecutorService r2 = r1.f8809d
        r2.execute(r0)
        return
    L_0x01cd:
        r0 = move-exception
        monitor-exit(r15)     // Catch:{ all -> 0x01cd }
        throw r0
    L_0x01d0:
        return
    L_0x01d1:
        boolean r0 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c
        if (r0 == 0) goto L_0x01dc
        java.lang.String r0 = "TAG_PROXY_Preloader"
        java.lang.String r2 = "cache or videoProxyDB null in Preloader!!!"
        android.util.Log.e(r0, r2)
    L_0x01dc:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.p190h.Preloader.mo16726a(boolean, boolean, int, java.lang.String, java.util.Map, java.lang.String[]):void");
    }

    /* renamed from: a */
    public void mo16724a(String str) {
        mo16728a(false, false, str);
    }

    /* renamed from: a */
    public void mo16728a(final boolean z, final boolean z2, final String str) {
        if (!TextUtils.isEmpty(str)) {
            C2479d.m11664a((Runnable) new Runnable() {
                public void run() {
                    DownloadTask bVar;
                    synchronized (Preloader.this.f8807b) {
                        Map map = (Map) Preloader.this.f8807b.get(VideoHttpHeaderTableContract.m11507a(z));
                        if (map != null) {
                            bVar = (DownloadTask) map.remove(z2 ? str : MD5.m11646a(str));
                        } else {
                            bVar = null;
                        }
                    }
                    if (bVar != null) {
                        bVar.mo16662a();
                    }
                }
            });
        }
    }

    /* renamed from: d */
    public void mo16730d() {
        C2479d.m11664a((Runnable) new Runnable() {
            public void run() {
                ArrayList<DownloadTask> arrayList = new ArrayList<>();
                synchronized (Preloader.this.f8807b) {
                    int size = Preloader.this.f8807b.size();
                    for (int i = 0; i < size; i++) {
                        Map map = (Map) Preloader.this.f8807b.get(Preloader.this.f8807b.keyAt(i));
                        if (map != null) {
                            arrayList.addAll(map.values());
                            map.clear();
                        }
                    }
                    Preloader.this.f8808c.clear();
                }
                for (DownloadTask bVar : arrayList) {
                    bVar.mo16662a();
                    if (Proxy.f8836c) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("PreloadTask: ");
                        sb.append(bVar);
                        sb.append(", canceled!!!");
                        Log.w("TAG_PROXY_Preloader", sb.toString());
                    }
                }
            }
        });
    }

    /* renamed from: a */
    private static ExecutorService m11519a(final C2463b<Runnable> bVar) {
        int a = C2479d.m11651a();
        int i = a < 1 ? 1 : a > 4 ? 4 : a;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, i, 60, TimeUnit.SECONDS, bVar, new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                C24601 r0 = new Thread(runnable) {
                    public void run() {
                        try {
                            Process.setThreadPriority(10);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        super.run();
                    }
                };
                StringBuilder sb = new StringBuilder();
                sb.append("video-preload-");
                sb.append(r0.getId());
                r0.setName(sb.toString());
                r0.setDaemon(true);
                if (Proxy.f8836c) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("new preload thead: ");
                    sb2.append(r0.getName());
                    Log.i("TAG_PROXY_Preloader", sb2.toString());
                }
                return r0;
            }
        }, new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                try {
                    bVar.offerFirst(runnable);
                    if (Proxy.f8836c) {
                        Log.i("TAG_PROXY_TT", "task rejected in preloader, put first!!!");
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        return threadPoolExecutor;
    }
}
