package com.kwai.filedownloader.download;

import com.kwai.filedownloader.p353a.C4589b;
import com.kwai.filedownloader.p354b.C4596a;
import com.kwai.filedownloader.p357e.C4641a;
import com.kwai.filedownloader.p358f.C4654c.C4655a;
import com.kwai.filedownloader.p358f.C4654c.C4656b;
import com.kwai.filedownloader.p358f.C4654c.C4658d;
import com.kwai.filedownloader.p358f.C4654c.C4659e;
import com.kwai.filedownloader.services.C4731c;
import com.kwai.filedownloader.services.C4731c.C4732a;
import java.io.File;

/* renamed from: com.kwai.filedownloader.download.b */
public class C4629b {
    /* renamed from: a */
    private C4731c f15099a;
    /* renamed from: b */
    private C4655a f15100b;
    /* renamed from: c */
    private C4656b f15101c;
    /* renamed from: d */
    private C4659e f15102d;
    /* renamed from: e */
    private C4596a f15103e;
    /* renamed from: f */
    private C4658d f15104f;

    /* renamed from: com.kwai.filedownloader.download.b$a */
    private static final class C4630a {
        /* access modifiers changed from: private|static|final */
        /* renamed from: a */
        public static final C4629b f15105a = new C4629b();
    }

    /* renamed from: a */
    public static C4629b m18995a() {
        return C4630a.f15105a;
    }

    /* JADX INFO: unreachable blocks removed: 1, instructions: 1 */
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:40:0x00c4 in {} preds:[B:39:0x00c2, B:37:0x00c0]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.calcImmediateDominators(BlockProcessor.java:303)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:255)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:55)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:45)
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
    /* renamed from: a */
    private static void m18996a(com.kwai.filedownloader.p354b.C4596a.C4597a r25) {
        /*
        r1 = r25
        java.lang.String r2 = "refreshed data count: %d , delete data count: %d, reset id count: %d. consume %d"
        java.util.Iterator r0 = r25.iterator()
        com.kwai.filedownloader.download.b r3 = m18995a()
        com.kwai.filedownloader.f.c$d r3 = r3.mo25143b()
        long r4 = java.lang.System.currentTimeMillis()
        r8 = 0
        r10 = 0
        r12 = 0
    L_0x001a:
        r15 = 3
        r16 = 0
        boolean r7 = r0.hasNext()     // Catch:{ all -> 0x018c }
        if (r7 == 0) goto L_0x014c     // Catch:{ all -> 0x018c }
        java.lang.Object r7 = r0.next()     // Catch:{ all -> 0x018c }
        com.kwai.filedownloader.d.c r7 = (com.kwai.filedownloader.p356d.C4621c) r7     // Catch:{ all -> 0x018c }
        byte r6 = r7.mo25088f()     // Catch:{ all -> 0x018c }
        r14 = -2     // Catch:{ all -> 0x018c }
        if (r6 == r15) goto L_0x004f     // Catch:{ all -> 0x018c }
        byte r6 = r7.mo25088f()     // Catch:{ all -> 0x018c }
        r15 = 2     // Catch:{ all -> 0x018c }
        if (r6 == r15) goto L_0x004f     // Catch:{ all -> 0x018c }
        byte r6 = r7.mo25088f()     // Catch:{ all -> 0x018c }
        r15 = -1     // Catch:{ all -> 0x018c }
        if (r6 == r15) goto L_0x004f     // Catch:{ all -> 0x018c }
        byte r6 = r7.mo25088f()     // Catch:{ all -> 0x018c }
        r15 = 1     // Catch:{ all -> 0x018c }
        if (r6 != r15) goto L_0x0052     // Catch:{ all -> 0x018c }
        long r20 = r7.mo25089g()     // Catch:{ all -> 0x018c }
        r17 = 0     // Catch:{ all -> 0x018c }
        int r6 = (r20 > r17 ? 1 : (r20 == r17 ? 0 : -1))     // Catch:{ all -> 0x018c }
        if (r6 <= 0) goto L_0x0052     // Catch:{ all -> 0x018c }
    L_0x004f:
        r7.mo25072a(r14)     // Catch:{ all -> 0x018c }
    L_0x0052:
        java.lang.String r6 = r7.mo25084d()     // Catch:{ all -> 0x018c }
        if (r6 != 0) goto L_0x0063     // Catch:{ all -> 0x018c }
        r20 = r2     // Catch:{ all -> 0x018c }
        r21 = r4     // Catch:{ all -> 0x018c }
        r23 = r8     // Catch:{ all -> 0x018c }
        r2 = 1     // Catch:{ all -> 0x018c }
        r8 = 0     // Catch:{ all -> 0x018c }
        goto L_0x00f6     // Catch:{ all -> 0x018c }
    L_0x0063:
        java.io.File r15 = new java.io.File     // Catch:{ all -> 0x018c }
        r15.<init>(r6)     // Catch:{ all -> 0x018c }
        byte r6 = r7.mo25088f()     // Catch:{ all -> 0x018c }
        if (r6 != r14) goto L_0x00c8     // Catch:{ all -> 0x018c }
        int r6 = r7.mo25071a()     // Catch:{ all -> 0x018c }
        java.lang.String r14 = r7.mo25081c()     // Catch:{ all -> 0x018c }
        r20 = r2
        r2 = 0
        boolean r2 = com.kwai.filedownloader.p358f.C4664f.m19140a(r6, r7, r14, r2)     // Catch:{ all -> 0x00c1 }
        if (r2 == 0) goto L_0x00ca     // Catch:{ all -> 0x00c1 }
        java.io.File r2 = new java.io.File     // Catch:{ all -> 0x00c1 }
        java.lang.String r6 = r7.mo25087e()     // Catch:{ all -> 0x00c1 }
        r2.<init>(r6)     // Catch:{ all -> 0x00c1 }
        boolean r6 = r2.exists()     // Catch:{ all -> 0x00c1 }
        if (r6 != 0) goto L_0x00ca     // Catch:{ all -> 0x00c1 }
        boolean r6 = r15.exists()     // Catch:{ all -> 0x00c1 }
        if (r6 == 0) goto L_0x00ca     // Catch:{ all -> 0x00c1 }
        boolean r6 = r15.renameTo(r2)     // Catch:{ all -> 0x00c1 }
        boolean r14 = com.kwai.filedownloader.p358f.C4660d.f15179a     // Catch:{ all -> 0x00c1 }
        if (r14 == 0) goto L_0x00ca     // Catch:{ all -> 0x00c1 }
        java.lang.Class<com.kwai.filedownloader.b.a> r14 = com.kwai.filedownloader.p354b.C4596a.class     // Catch:{ all -> 0x00c1 }
        r21 = r4
        java.lang.String r4 = "resume from the old no-temp-file architecture [%B], [%s]->[%s]"
        r23 = r8
        r5 = 3
        java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ all -> 0x0148 }
        java.lang.Boolean r5 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x0148 }
        r8[r16] = r5     // Catch:{ all -> 0x0148 }
        java.lang.String r5 = r15.getPath()     // Catch:{ all -> 0x0148 }
        r6 = 1     // Catch:{ all -> 0x0148 }
        r8[r6] = r5     // Catch:{ all -> 0x0148 }
        java.lang.String r2 = r2.getPath()     // Catch:{ all -> 0x0148 }
        r5 = 2     // Catch:{ all -> 0x0148 }
        r8[r5] = r2     // Catch:{ all -> 0x0148 }
        com.kwai.filedownloader.p358f.C4660d.m19123c(r14, r4, r8)     // Catch:{ all -> 0x0148 }
        goto L_0x00ce     // Catch:{ all -> 0x0148 }
    L_0x00bf:
        r0 = move-exception     // Catch:{ all -> 0x0148 }
        goto L_0x00c4     // Catch:{ all -> 0x0148 }
    L_0x00c1:
        r0 = move-exception     // Catch:{ all -> 0x0148 }
        r21 = r4     // Catch:{ all -> 0x0148 }
    L_0x00c4:
        r23 = r8     // Catch:{ all -> 0x0148 }
        goto L_0x0149     // Catch:{ all -> 0x0148 }
    L_0x00c8:
        r20 = r2     // Catch:{ all -> 0x0148 }
    L_0x00ca:
        r21 = r4     // Catch:{ all -> 0x0148 }
        r23 = r8     // Catch:{ all -> 0x0148 }
    L_0x00ce:
        byte r2 = r7.mo25088f()     // Catch:{ all -> 0x0148 }
        r4 = 1     // Catch:{ all -> 0x0148 }
        if (r2 != r4) goto L_0x00e1     // Catch:{ all -> 0x0148 }
        long r4 = r7.mo25089g()     // Catch:{ all -> 0x0148 }
        r8 = 0     // Catch:{ all -> 0x0148 }
        int r2 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))     // Catch:{ all -> 0x0148 }
        if (r2 > 0) goto L_0x00e3     // Catch:{ all -> 0x0148 }
    L_0x00df:
        r2 = 1     // Catch:{ all -> 0x0148 }
        goto L_0x00f6     // Catch:{ all -> 0x0148 }
    L_0x00e1:
        r8 = 0     // Catch:{ all -> 0x0148 }
    L_0x00e3:
        int r2 = r7.mo25071a()     // Catch:{ all -> 0x0148 }
        boolean r2 = com.kwai.filedownloader.p358f.C4664f.m19138a(r2, r7)     // Catch:{ all -> 0x0148 }
        if (r2 != 0) goto L_0x00ee     // Catch:{ all -> 0x0148 }
        goto L_0x00df     // Catch:{ all -> 0x0148 }
    L_0x00ee:
        boolean r2 = r15.exists()     // Catch:{ all -> 0x0148 }
        if (r2 == 0) goto L_0x00f5     // Catch:{ all -> 0x0148 }
        goto L_0x00df     // Catch:{ all -> 0x0148 }
    L_0x00f5:
        r2 = 0     // Catch:{ all -> 0x0148 }
    L_0x00f6:
        r4 = 1     // Catch:{ all -> 0x0148 }
        if (r2 == 0) goto L_0x0104     // Catch:{ all -> 0x0148 }
        r0.remove()     // Catch:{ all -> 0x0148 }
        r1.mo24981a(r7)     // Catch:{ all -> 0x0148 }
        long r10 = r10 + r4     // Catch:{ all -> 0x0148 }
        r8 = r23     // Catch:{ all -> 0x0148 }
        goto L_0x0142     // Catch:{ all -> 0x0148 }
    L_0x0104:
        int r2 = r7.mo25071a()     // Catch:{ all -> 0x0148 }
        java.lang.String r6 = r7.mo25077b()     // Catch:{ all -> 0x0148 }
        java.lang.String r14 = r7.mo25081c()     // Catch:{ all -> 0x0148 }
        boolean r15 = r7.mo25094l()     // Catch:{ all -> 0x0148 }
        int r6 = r3.mo25218a(r2, r6, r14, r15)     // Catch:{ all -> 0x0148 }
        if (r6 == r2) goto L_0x013d     // Catch:{ all -> 0x0148 }
        boolean r14 = com.kwai.filedownloader.p358f.C4660d.f15179a     // Catch:{ all -> 0x0148 }
        if (r14 == 0) goto L_0x0136     // Catch:{ all -> 0x0148 }
        java.lang.Class<com.kwai.filedownloader.b.a> r14 = com.kwai.filedownloader.p354b.C4596a.class     // Catch:{ all -> 0x0148 }
        java.lang.String r15 = "the id is changed on restoring from db: old[%d] -> new[%d]"     // Catch:{ all -> 0x0148 }
        r8 = 2     // Catch:{ all -> 0x0148 }
        java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x0148 }
        java.lang.Integer r8 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0148 }
        r9[r16] = r8     // Catch:{ all -> 0x0148 }
        java.lang.Integer r8 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0148 }
        r19 = 1     // Catch:{ all -> 0x0148 }
        r9[r19] = r8     // Catch:{ all -> 0x0148 }
        com.kwai.filedownloader.p358f.C4660d.m19123c(r14, r15, r9)     // Catch:{ all -> 0x0148 }
    L_0x0136:
        r7.mo25073a(r6)     // Catch:{ all -> 0x0148 }
        r1.mo24980a(r2, r7)     // Catch:{ all -> 0x0148 }
        long r12 = r12 + r4     // Catch:{ all -> 0x0148 }
    L_0x013d:
        r1.mo24982b(r7)     // Catch:{ all -> 0x0148 }
        long r8 = r23 + r4
    L_0x0142:
        r2 = r20
        r4 = r21
        goto L_0x001a
    L_0x0148:
        r0 = move-exception
    L_0x0149:
        r2 = r20
        goto L_0x0191
    L_0x014c:
        r20 = r2
        r21 = r4
        r23 = r8
        android.content.Context r0 = com.kwai.filedownloader.p358f.C4654c.m19105a()
        com.kwai.filedownloader.p358f.C4664f.m19148b(r0)
        r25.mo24979a()
        boolean r0 = com.kwai.filedownloader.p358f.C4660d.f15179a
        if (r0 == 0) goto L_0x018b
        java.lang.Class<com.kwai.filedownloader.b.a> r0 = com.kwai.filedownloader.p354b.C4596a.class
        r1 = 4
        java.lang.Object[] r1 = new java.lang.Object[r1]
        java.lang.Long r2 = java.lang.Long.valueOf(r23)
        r1[r16] = r2
        java.lang.Long r2 = java.lang.Long.valueOf(r10)
        r3 = 1
        r1[r3] = r2
        java.lang.Long r2 = java.lang.Long.valueOf(r12)
        r3 = 2
        r1[r3] = r2
        long r2 = java.lang.System.currentTimeMillis()
        long r2 = r2 - r21
        java.lang.Long r2 = java.lang.Long.valueOf(r2)
        r3 = 3
        r1[r3] = r2
        r2 = r20
        com.kwai.filedownloader.p358f.C4660d.m19123c(r0, r2, r1)
    L_0x018b:
        return
    L_0x018c:
        r0 = move-exception
        r21 = r4
        r23 = r8
    L_0x0191:
        android.content.Context r3 = com.kwai.filedownloader.p358f.C4654c.m19105a()
        com.kwai.filedownloader.p358f.C4664f.m19148b(r3)
        r25.mo24979a()
        boolean r1 = com.kwai.filedownloader.p358f.C4660d.f15179a
        if (r1 == 0) goto L_0x01c8
        java.lang.Class<com.kwai.filedownloader.b.a> r1 = com.kwai.filedownloader.p354b.C4596a.class
        r3 = 4
        java.lang.Object[] r3 = new java.lang.Object[r3]
        java.lang.Long r4 = java.lang.Long.valueOf(r23)
        r3[r16] = r4
        java.lang.Long r4 = java.lang.Long.valueOf(r10)
        r5 = 1
        r3[r5] = r4
        java.lang.Long r4 = java.lang.Long.valueOf(r12)
        r5 = 2
        r3[r5] = r4
        long r4 = java.lang.System.currentTimeMillis()
        long r4 = r4 - r21
        java.lang.Long r4 = java.lang.Long.valueOf(r4)
        r5 = 3
        r3[r5] = r4
        com.kwai.filedownloader.p358f.C4660d.m19123c(r1, r2, r3)
    L_0x01c8:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.download.C4629b.m18996a(com.kwai.filedownloader.b.a$a):void");
    }

    /* renamed from: f */
    private C4655a m18997f() {
        C4655a aVar = this.f15100b;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            if (this.f15100b == null) {
                this.f15100b = m19000i().mo25332e();
            }
        }
        return this.f15100b;
    }

    /* renamed from: g */
    private C4656b m18998g() {
        C4656b bVar = this.f15101c;
        if (bVar != null) {
            return bVar;
        }
        synchronized (this) {
            if (this.f15101c == null) {
                this.f15101c = m19000i().mo25331d();
            }
        }
        return this.f15101c;
    }

    /* renamed from: h */
    private C4659e m18999h() {
        C4659e eVar = this.f15102d;
        if (eVar != null) {
            return eVar;
        }
        synchronized (this) {
            if (this.f15102d == null) {
                this.f15102d = m19000i().mo25330c();
            }
        }
        return this.f15102d;
    }

    /* renamed from: i */
    private C4731c m19000i() {
        C4731c cVar = this.f15099a;
        if (cVar != null) {
            return cVar;
        }
        synchronized (this) {
            if (this.f15099a == null) {
                this.f15099a = new C4731c();
            }
        }
        return this.f15099a;
    }

    /* renamed from: a */
    public int mo25139a(int i, String str, String str2, long j) {
        return m18997f().mo24950a(i, str, str2, j);
    }

    /* renamed from: a */
    public C4589b mo25140a(String str) {
        return m18998g().mo22748a(str);
    }

    /* renamed from: a */
    public C4641a mo25141a(File file) {
        return m18999h().mo25199a(file);
    }

    /* renamed from: a */
    public void mo25142a(C4732a aVar) {
        synchronized (this) {
            this.f15099a = new C4731c(aVar);
            this.f15101c = null;
            this.f15102d = null;
            this.f15103e = null;
            this.f15104f = null;
        }
    }

    /* renamed from: b */
    public C4658d mo25143b() {
        C4658d dVar = this.f15104f;
        if (dVar != null) {
            return dVar;
        }
        synchronized (this) {
            if (this.f15104f == null) {
                this.f15104f = m19000i().mo25333f();
            }
        }
        return this.f15104f;
    }

    /* renamed from: b */
    public void mo25144b(C4732a aVar) {
        synchronized (this) {
            this.f15099a = new C4731c(aVar);
        }
    }

    /* renamed from: c */
    public C4596a mo25145c() {
        C4596a aVar = this.f15103e;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            if (this.f15103e == null) {
                this.f15103e = m19000i().mo25329b();
                m18996a(this.f15103e.mo24971b());
            }
        }
        return this.f15103e;
    }

    /* renamed from: d */
    public int mo25146d() {
        return m19000i().mo25328a();
    }

    /* renamed from: e */
    public boolean mo25147e() {
        return m18999h().mo25200a();
    }
}
