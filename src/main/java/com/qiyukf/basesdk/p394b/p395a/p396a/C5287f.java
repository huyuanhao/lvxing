package com.qiyukf.basesdk.p394b.p395a.p396a;

import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.C5420e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.qiyukf.basesdk.b.a.a.f */
public class C5287f {
    /* renamed from: e */
    private static C5287f f17117e;
    /* renamed from: a */
    private final Object f17118a = new Object();
    /* renamed from: b */
    private Map<String, List<C5285d>> f17119b = new HashMap();
    /* renamed from: c */
    private Map<String, C5289g> f17120c = new HashMap();
    /* renamed from: d */
    private C5420e f17121d = new C5420e("HttpDownloadManager", C5420e.f17394b, true);

    /* renamed from: com.qiyukf.basesdk.b.a.a.f$a */
    private class C5288a implements Runnable {
        /* renamed from: b */
        private String f17123b;
        /* renamed from: c */
        private String f17124c;
        /* renamed from: d */
        private long f17125d;
        /* renamed from: e */
        private C5273a f17126e;

        public C5288a(String str, String str2, long j, C5273a aVar) {
            this.f17123b = str;
            this.f17124c = str2;
            this.f17125d = j;
            this.f17126e = aVar;
        }

        public final void run() {
            try {
                C5287f.m21711a(C5287f.this, this.f17123b, this.f17124c, this.f17125d, this.f17126e);
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder("Download exception: ");
                sb.append(th);
                C5264a.m21617a("RES", sb.toString());
            }
        }
    }

    private C5287f() {
    }

    /* renamed from: a */
    public static C5287f m21710a() {
        if (f17117e == null) {
            synchronized (C5287f.class) {
                if (f17117e == null) {
                    f17117e = new C5287f();
                }
            }
        }
        return f17117e;
    }

    /* JADX INFO: used method not loaded: com.qiyukf.basesdk.b.a.a.c.a.a.a(com.qiyukf.basesdk.b.a.a.a):null, types can be incorrect */
    /* JADX INFO: used method not loaded: com.qiyukf.basesdk.b.a.a.c.a.a.a(long):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
            r1.f17127a.mo27131a(new com.qiyukf.basesdk.p394b.p395a.p396a.C5281c.C5282a.C5283a(r4, r5).mo27134a(r8).mo27133a(r6).mo27135a());
            r5 = r3.f17118a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003b, code lost:
            monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
            if (r3.f17120c.get(r4) != r1) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
            r3.f17120c.remove(r4);
            r3.f17119b.remove(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004e, code lost:
            monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004f, code lost:
            m21712a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0052, code lost:
            return;
     */
    /* renamed from: a */
    static /* synthetic */ void m21711a(com.qiyukf.basesdk.p394b.p395a.p396a.C5287f r3, java.lang.String r4, java.lang.String r5, long r6, com.qiyukf.basesdk.p394b.p395a.p396a.C5273a r8) {
        /*
        java.lang.Object r0 = r3.f17118a
        monitor-enter(r0)
        java.util.Map<java.lang.String, java.util.List<com.qiyukf.basesdk.b.a.a.d>> r1 = r3.f17119b     // Catch:{ all -> 0x0058 }
        boolean r1 = r1.containsKey(r4)     // Catch:{ all -> 0x0058 }
        if (r1 == 0) goto L_0x0056
        java.util.Map<java.lang.String, com.qiyukf.basesdk.b.a.a.g> r1 = r3.f17120c     // Catch:{ all -> 0x0058 }
        boolean r1 = r1.containsKey(r4)     // Catch:{ all -> 0x0058 }
        if (r1 == 0) goto L_0x0014
        goto L_0x0056
    L_0x0014:
        com.qiyukf.basesdk.b.a.a.g r1 = new com.qiyukf.basesdk.b.a.a.g     // Catch:{ all -> 0x0058 }
        com.qiyukf.basesdk.b.a.a.c r2 = com.qiyukf.basesdk.p394b.p395a.p396a.C5281c.m21686a()     // Catch:{ all -> 0x0058 }
        r1.m49405init(r2)     // Catch:{ all -> 0x0058 }
        java.util.Map<java.lang.String, com.qiyukf.basesdk.b.a.a.g> r2 = r3.f17120c     // Catch:{ all -> 0x0058 }
        r2.put(r4, r1)     // Catch:{ all -> 0x0058 }
        monitor-exit(r0)     // Catch:{ all -> 0x0058 }
        com.qiyukf.basesdk.b.a.a.c$a$a r0 = new com.qiyukf.basesdk.b.a.a.c$a$a
        r0.m49399init(r4, r5)
        com.qiyukf.basesdk.b.a.a.c$a$a r5 = r0.mo27134a(r8)
        com.qiyukf.basesdk.b.a.a.c$a$a r5 = r5.mo27133a(r6)
        com.qiyukf.basesdk.b.a.a.c$a r5 = r5.mo27135a()
        com.qiyukf.basesdk.b.a.a.c r6 = r1.f17127a
        r6.mo27131a(r5)
        java.lang.Object r5 = r3.f17118a
        monitor-enter(r5)
        java.util.Map<java.lang.String, com.qiyukf.basesdk.b.a.a.g> r6 = r3.f17120c     // Catch:{ all -> 0x0053 }
        java.lang.Object r6 = r6.get(r4)     // Catch:{ all -> 0x0053 }
        if (r6 != r1) goto L_0x004e
        java.util.Map<java.lang.String, com.qiyukf.basesdk.b.a.a.g> r6 = r3.f17120c     // Catch:{ all -> 0x0053 }
        r6.remove(r4)     // Catch:{ all -> 0x0053 }
        java.util.Map<java.lang.String, java.util.List<com.qiyukf.basesdk.b.a.a.d>> r3 = r3.f17119b     // Catch:{ all -> 0x0053 }
        r3.remove(r4)     // Catch:{ all -> 0x0053 }
    L_0x004e:
        monitor-exit(r5)     // Catch:{ all -> 0x0053 }
        m21712a(r1)
        return
    L_0x0053:
        r3 = move-exception
        monitor-exit(r5)     // Catch:{ all -> 0x0053 }
        throw r3
    L_0x0056:
        monitor-exit(r0)     // Catch:{ all -> 0x0058 }
        return
    L_0x0058:
        r3 = move-exception
        monitor-exit(r0)     // Catch:{ all -> 0x0058 }
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.p394b.p395a.p396a.C5287f.m21711a(com.qiyukf.basesdk.b.a.a.f, java.lang.String, java.lang.String, long, com.qiyukf.basesdk.b.a.a.a):void");
    }

    /* renamed from: a */
    private static void m21712a(C5289g gVar) {
        synchronized (gVar) {
            gVar.notifyAll();
        }
    }

    /* renamed from: c */
    private void m21713c(String str) {
        this.f17119b.remove(str);
        C5289g gVar = (C5289g) this.f17120c.get(str);
        if (gVar != null) {
            gVar.f17127a.mo27132b();
            this.f17120c.remove(str);
            m21712a(gVar);
        }
    }

    /* access modifiers changed from: final */
    /* renamed from: a */
    public final List<C5285d> mo27148a(String str) {
        List<C5285d> list;
        synchronized (this.f17118a) {
            list = (List) this.f17119b.get(str);
        }
        return list;
    }

    /* renamed from: a */
    public final void mo27149a(C5285d dVar) {
        C5289g gVar;
        String a = dVar.mo27136a();
        synchronized (this.f17118a) {
            List list = (List) this.f17119b.get(a);
            if (list == null) {
                list = new LinkedList();
                this.f17119b.put(a, list);
            }
            if (!list.contains(dVar)) {
                list.add(dVar);
            }
            gVar = (C5289g) this.f17120c.get(a);
        }
        if (gVar == null) {
            String c = dVar.mo27138c();
            C5288a aVar = new C5288a(a, c, dVar.mo27139d(), new C5274b(a, c));
            this.f17121d.execute(aVar);
        }
    }

    /* access modifiers changed from: final */
    /* renamed from: b */
    public final C5289g mo27150b(String str) {
        C5289g gVar;
        synchronized (this.f17118a) {
            gVar = (C5289g) this.f17120c.get(str);
        }
        return gVar;
    }

    /* renamed from: b */
    public final void mo27151b() {
        Object[] array;
        synchronized (this.f17118a) {
            for (Object obj : this.f17119b.keySet().toArray()) {
                List<C5285d> list = (List) this.f17119b.get(obj);
                if (list != null) {
                    for (C5285d e : list) {
                        e.mo27140e();
                    }
                }
                m21713c((String) obj);
            }
        }
    }

    /* renamed from: b */
    public final void mo27152b(C5285d dVar) {
        synchronized (this.f17118a) {
            String a = dVar.mo27136a();
            List list = (List) this.f17119b.get(a);
            if (list != null) {
                dVar.mo27140e();
                list.remove(dVar);
                if (list.size() == 0) {
                    m21713c(a);
                }
            }
        }
    }
}
