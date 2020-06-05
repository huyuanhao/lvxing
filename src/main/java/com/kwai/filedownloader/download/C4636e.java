package com.kwai.filedownloader.download;

import android.os.SystemClock;
import com.kwai.filedownloader.p353a.C4589b;
import com.kwai.filedownloader.p354b.C4596a;
import com.kwai.filedownloader.p357e.C4641a;
import com.kwai.filedownloader.p358f.C4660d;
import com.kwai.filedownloader.p358f.C4664f;
import java.io.IOException;

/* renamed from: com.kwai.filedownloader.download.e */
public class C4636e {
    /* renamed from: a */
    long f15137a;
    /* renamed from: b */
    private final C4639f f15138b;
    /* renamed from: c */
    private final int f15139c;
    /* renamed from: d */
    private final int f15140d;
    /* renamed from: e */
    private final C4631c f15141e;
    /* renamed from: f */
    private final C4589b f15142f;
    /* renamed from: g */
    private final boolean f15143g;
    /* renamed from: h */
    private final long f15144h;
    /* renamed from: i */
    private final long f15145i;
    /* renamed from: j */
    private final long f15146j;
    /* renamed from: k */
    private final String f15147k;
    /* renamed from: l */
    private C4641a f15148l;
    /* renamed from: m */
    private volatile boolean f15149m;
    /* renamed from: n */
    private final C4596a f15150n;
    /* renamed from: o */
    private volatile long f15151o;
    /* renamed from: p */
    private volatile long f15152p;

    /* renamed from: com.kwai.filedownloader.download.e$a */
    public static class C4638a {
        /* renamed from: a */
        C4631c f15153a;
        /* renamed from: b */
        C4589b f15154b;
        /* renamed from: c */
        C4628a f15155c;
        /* renamed from: d */
        C4639f f15156d;
        /* renamed from: e */
        String f15157e;
        /* renamed from: f */
        Boolean f15158f;
        /* renamed from: g */
        Integer f15159g;
        /* renamed from: h */
        Integer f15160h;

        /* renamed from: a */
        public C4638a mo25181a(int i) {
            this.f15159g = Integer.valueOf(i);
            return this;
        }

        /* renamed from: a */
        public C4638a mo25182a(C4589b bVar) {
            this.f15154b = bVar;
            return this;
        }

        /* renamed from: a */
        public C4638a mo25183a(C4628a aVar) {
            this.f15155c = aVar;
            return this;
        }

        /* renamed from: a */
        public C4638a mo25184a(C4631c cVar) {
            this.f15153a = cVar;
            return this;
        }

        /* renamed from: a */
        public C4638a mo25185a(C4639f fVar) {
            this.f15156d = fVar;
            return this;
        }

        /* renamed from: a */
        public C4638a mo25186a(String str) {
            this.f15157e = str;
            return this;
        }

        /* renamed from: a */
        public C4638a mo25187a(boolean z) {
            this.f15158f = Boolean.valueOf(z);
            return this;
        }

        /* renamed from: a */
        public C4636e mo25188a() {
            if (this.f15158f != null) {
                C4589b bVar = this.f15154b;
                if (bVar != null) {
                    C4628a aVar = this.f15155c;
                    if (!(aVar == null || this.f15156d == null || this.f15157e == null)) {
                        Integer num = this.f15160h;
                        if (!(num == null || this.f15159g == null)) {
                            C4636e eVar = new C4636e(bVar, aVar, this.f15153a, num.intValue(), this.f15159g.intValue(), this.f15158f.booleanValue(), this.f15156d, this.f15157e);
                            return eVar;
                        }
                    }
                }
            }
            throw new IllegalArgumentException();
        }

        /* renamed from: b */
        public C4638a mo25189b(int i) {
            this.f15160h = Integer.valueOf(i);
            return this;
        }
    }

    private C4636e(C4589b bVar, C4628a aVar, C4631c cVar, int i, int i2, boolean z, C4639f fVar, String str) {
        this.f15151o = 0;
        this.f15152p = 0;
        this.f15138b = fVar;
        this.f15147k = str;
        this.f15142f = bVar;
        this.f15143g = z;
        this.f15141e = cVar;
        this.f15140d = i2;
        this.f15139c = i;
        this.f15150n = C4629b.m18995a().mo25145c();
        this.f15144h = aVar.f15095a;
        this.f15145i = aVar.f15097c;
        this.f15137a = aVar.f15096b;
        this.f15146j = aVar.f15098d;
    }

    /* renamed from: c */
    private void m19053c() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (C4664f.m19141a(this.f15137a - this.f15151o, elapsedRealtime - this.f15152p)) {
            m19054d();
            this.f15151o = this.f15137a;
            this.f15152p = elapsedRealtime;
        }
    }

    /* renamed from: d */
    private void m19054d() {
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            this.f15148l.mo25194a();
            z = true;
        } catch (IOException e) {
            if (C4660d.f15179a) {
                C4660d.m19123c(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e);
            }
            z = false;
        }
        if (z) {
            if (this.f15141e != null) {
                this.f15150n.mo24963a(this.f15139c, this.f15140d, this.f15137a);
            } else {
                this.f15138b.mo25124c();
            }
            if (C4660d.f15179a) {
                C4660d.m19123c(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.f15139c), Integer.valueOf(this.f15140d), Long.valueOf(this.f15137a), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            }
        }
    }

    /* renamed from: a */
    public void mo25179a() {
        this.f15149m = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:128:0x01f3 A[SYNTHETIC, Splitter:B:128:0x01f3] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01fe A[SYNTHETIC, Splitter:B:133:0x01fe] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0212 A[SYNTHETIC, Splitter:B:144:0x0212] */
    /* renamed from: b */
    public void mo25180b() {
        /*
        r16 = this;
        r1 = r16
        boolean r0 = r1.f15149m
        if (r0 == 0) goto L_0x0007
        return
    L_0x0007:
        int r0 = r1.f15140d
        com.kwai.filedownloader.a.b r2 = r1.f15142f
        long r2 = com.kwai.filedownloader.p358f.C4664f.m19146b(r0, r2)
        r4 = 0
        r6 = 2
        r7 = 1
        r8 = 0
        int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
        if (r0 == 0) goto L_0x021c
        long r9 = r1.f15146j
        r11 = 5
        r12 = 4
        r13 = 3
        int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
        if (r0 <= 0) goto L_0x0082
        int r0 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
        if (r0 == 0) goto L_0x0082
        long r9 = r1.f15145i
        int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
        if (r0 != 0) goto L_0x003c
        java.lang.Object[] r0 = new java.lang.Object[r7]
        long r4 = r1.f15137a
        java.lang.Long r4 = java.lang.Long.valueOf(r4)
        r0[r8] = r4
        java.lang.String r4 = "range[%d-)"
        java.lang.String r0 = com.kwai.filedownloader.p358f.C4664f.m19135a(r4, r0)
        goto L_0x0054
    L_0x003c:
        java.lang.Object[] r0 = new java.lang.Object[r6]
        long r4 = r1.f15137a
        java.lang.Long r4 = java.lang.Long.valueOf(r4)
        r0[r8] = r4
        long r4 = r1.f15145i
        java.lang.Long r4 = java.lang.Long.valueOf(r4)
        r0[r7] = r4
        java.lang.String r4 = "range[%d-%d)"
        java.lang.String r0 = com.kwai.filedownloader.p358f.C4664f.m19135a(r4, r0)
    L_0x0054:
        com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException r4 = new com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException
        java.lang.Object[] r5 = new java.lang.Object[r11]
        r5[r8] = r0
        long r8 = r1.f15146j
        java.lang.Long r0 = java.lang.Long.valueOf(r8)
        r5[r7] = r0
        java.lang.Long r0 = java.lang.Long.valueOf(r2)
        r5[r6] = r0
        int r0 = r1.f15139c
        java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        r5[r13] = r0
        int r0 = r1.f15140d
        java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        r5[r12] = r0
        java.lang.String r0 = "require %s with contentLength(%d), but the backend response contentLength is %d on downloadId[%d]-connectionIndex[%d], please ask your backend dev to fix such problem."
        java.lang.String r0 = com.kwai.filedownloader.p358f.C4664f.m19135a(r0, r5)
        r4.m48683init(r0)
        throw r4
    L_0x0082:
        long r4 = r1.f15137a
        r9 = 0
        com.kwai.filedownloader.download.b r0 = com.kwai.filedownloader.download.C4629b.m18995a()     // Catch:{ all -> 0x01ee }
        boolean r0 = r0.mo25147e()     // Catch:{ all -> 0x01ee }
        com.kwai.filedownloader.download.c r10 = r1.f15141e     // Catch:{ all -> 0x01ee }
        if (r10 == 0) goto L_0x009c
        if (r0 == 0) goto L_0x0094
        goto L_0x009c
    L_0x0094:
        java.lang.IllegalAccessException r0 = new java.lang.IllegalAccessException     // Catch:{ all -> 0x01ee }
        java.lang.String r2 = "can't using multi-download when the output stream can't support seek"
        r0.<init>(r2)     // Catch:{ all -> 0x01ee }
        throw r0     // Catch:{ all -> 0x01ee }
    L_0x009c:
        java.lang.String r10 = r1.f15147k     // Catch:{ all -> 0x01ee }
        com.kwai.filedownloader.e.a r10 = com.kwai.filedownloader.p358f.C4664f.m19163l(r10)     // Catch:{ all -> 0x01ee }
        r1.f15148l = r10     // Catch:{ all -> 0x01eb }
        if (r0 == 0) goto L_0x00ab
        long r14 = r1.f15137a     // Catch:{ all -> 0x01eb }
        r10.mo25195a(r14)     // Catch:{ all -> 0x01eb }
    L_0x00ab:
        boolean r0 = com.kwai.filedownloader.p358f.C4660d.f15179a     // Catch:{ all -> 0x01eb }
        if (r0 == 0) goto L_0x00d6
        java.lang.String r0 = "start fetch(%d): range [%d, %d), seek to[%d]"
        java.lang.Object[] r14 = new java.lang.Object[r12]     // Catch:{ all -> 0x01eb }
        int r15 = r1.f15140d     // Catch:{ all -> 0x01eb }
        java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x01eb }
        r14[r8] = r15     // Catch:{ all -> 0x01eb }
        long r11 = r1.f15144h     // Catch:{ all -> 0x01eb }
        java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x01eb }
        r14[r7] = r11     // Catch:{ all -> 0x01eb }
        long r11 = r1.f15145i     // Catch:{ all -> 0x01eb }
        java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x01eb }
        r14[r6] = r11     // Catch:{ all -> 0x01eb }
        long r11 = r1.f15137a     // Catch:{ all -> 0x01eb }
        java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x01eb }
        r14[r13] = r11     // Catch:{ all -> 0x01eb }
        com.kwai.filedownloader.p358f.C4660d.m19123c(r1, r0, r14)     // Catch:{ all -> 0x01eb }
    L_0x00d6:
        com.kwai.filedownloader.a.b r0 = r1.f15142f     // Catch:{ all -> 0x01eb }
        java.io.InputStream r9 = r0.mo22739a()     // Catch:{ all -> 0x01eb }
        r0 = 4096(0x1000, float:5.74E-42)
        byte[] r0 = new byte[r0]     // Catch:{ all -> 0x01eb }
        boolean r11 = r1.f15149m     // Catch:{ all -> 0x01eb }
        if (r11 == 0) goto L_0x010f
        if (r9 == 0) goto L_0x00ef
        r9.close()     // Catch:{ IOException -> 0x00ea }
        goto L_0x00ef
    L_0x00ea:
        r0 = move-exception
        r2 = r0
        r2.printStackTrace()
    L_0x00ef:
        if (r10 == 0) goto L_0x0103
        r16.m19054d()     // Catch:{ all -> 0x00f5 }
        goto L_0x0103
    L_0x00f5:
        r0 = move-exception
        r2 = r0
        if (r10 == 0) goto L_0x0102
        r10.mo25197b()     // Catch:{ IOException -> 0x00fd }
        goto L_0x0102
    L_0x00fd:
        r0 = move-exception
        r3 = r0
        r3.printStackTrace()
    L_0x0102:
        throw r2
    L_0x0103:
        if (r10 == 0) goto L_0x010e
        r10.mo25197b()     // Catch:{ IOException -> 0x0109 }
        goto L_0x010e
    L_0x0109:
        r0 = move-exception
        r2 = r0
        r2.printStackTrace()
    L_0x010e:
        return
    L_0x010f:
        int r11 = r9.read(r0)     // Catch:{ all -> 0x01eb }
        r12 = -1
        if (r11 != r12) goto L_0x0195
        if (r9 == 0) goto L_0x0121
        r9.close()     // Catch:{ IOException -> 0x011c }
        goto L_0x0121
    L_0x011c:
        r0 = move-exception
        r9 = r0
        r9.printStackTrace()
    L_0x0121:
        if (r10 == 0) goto L_0x0135
        r16.m19054d()     // Catch:{ all -> 0x0127 }
        goto L_0x0135
    L_0x0127:
        r0 = move-exception
        r2 = r0
        if (r10 == 0) goto L_0x0134
        r10.mo25197b()     // Catch:{ IOException -> 0x012f }
        goto L_0x0134
    L_0x012f:
        r0 = move-exception
        r3 = r0
        r3.printStackTrace()
    L_0x0134:
        throw r2
    L_0x0135:
        if (r10 == 0) goto L_0x0140
        r10.mo25197b()     // Catch:{ IOException -> 0x013b }
        goto L_0x0140
    L_0x013b:
        r0 = move-exception
        r9 = r0
        r9.printStackTrace()
    L_0x0140:
        long r9 = r1.f15137a
        long r9 = r9 - r4
        r11 = -1
        int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
        if (r0 == 0) goto L_0x0189
        int r0 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
        if (r0 != 0) goto L_0x014e
        goto L_0x0189
    L_0x014e:
        com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException r0 = new com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException
        r11 = 6
        java.lang.Object[] r11 = new java.lang.Object[r11]
        java.lang.Long r9 = java.lang.Long.valueOf(r9)
        r11[r8] = r9
        java.lang.Long r2 = java.lang.Long.valueOf(r2)
        r11[r7] = r2
        long r2 = r1.f15144h
        java.lang.Long r2 = java.lang.Long.valueOf(r2)
        r11[r6] = r2
        long r2 = r1.f15145i
        java.lang.Long r2 = java.lang.Long.valueOf(r2)
        r11[r13] = r2
        long r2 = r1.f15137a
        java.lang.Long r2 = java.lang.Long.valueOf(r2)
        r12 = 4
        r11[r12] = r2
        java.lang.Long r2 = java.lang.Long.valueOf(r4)
        r14 = 5
        r11[r14] = r2
        java.lang.String r2 = "fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset"
        java.lang.String r2 = com.kwai.filedownloader.p358f.C4664f.m19135a(r2, r11)
        r0.m48683init(r2)
        throw r0
    L_0x0189:
        com.kwai.filedownloader.download.f r3 = r1.f15138b
        com.kwai.filedownloader.download.c r4 = r1.f15141e
        long r5 = r1.f15144h
        long r7 = r1.f15145i
        r3.mo25119a(r4, r5, r7)
        return
    L_0x0195:
        r12 = 4
        r14 = 5
        r10.mo25196a(r0, r8, r11)     // Catch:{ all -> 0x01eb }
        long r12 = r1.f15137a     // Catch:{ all -> 0x01eb }
        long r14 = (long) r11     // Catch:{ all -> 0x01eb }
        long r12 = r12 + r14
        r1.f15137a = r12     // Catch:{ all -> 0x01eb }
        com.kwai.filedownloader.download.f r11 = r1.f15138b     // Catch:{ all -> 0x01eb }
        r11.mo25118a(r14)     // Catch:{ all -> 0x01eb }
        r16.m19053c()     // Catch:{ all -> 0x01eb }
        boolean r11 = r1.f15149m     // Catch:{ all -> 0x01eb }
        if (r11 == 0) goto L_0x01d7
        if (r9 == 0) goto L_0x01b7
        r9.close()     // Catch:{ IOException -> 0x01b2 }
        goto L_0x01b7
    L_0x01b2:
        r0 = move-exception
        r2 = r0
        r2.printStackTrace()
    L_0x01b7:
        if (r10 == 0) goto L_0x01cb
        r16.m19054d()     // Catch:{ all -> 0x01bd }
        goto L_0x01cb
    L_0x01bd:
        r0 = move-exception
        r2 = r0
        if (r10 == 0) goto L_0x01ca
        r10.mo25197b()     // Catch:{ IOException -> 0x01c5 }
        goto L_0x01ca
    L_0x01c5:
        r0 = move-exception
        r3 = r0
        r3.printStackTrace()
    L_0x01ca:
        throw r2
    L_0x01cb:
        if (r10 == 0) goto L_0x01d6
        r10.mo25197b()     // Catch:{ IOException -> 0x01d1 }
        goto L_0x01d6
    L_0x01d1:
        r0 = move-exception
        r2 = r0
        r2.printStackTrace()
    L_0x01d6:
        return
    L_0x01d7:
        boolean r11 = r1.f15143g     // Catch:{ all -> 0x01eb }
        if (r11 == 0) goto L_0x01e8
        boolean r11 = com.kwai.filedownloader.p358f.C4664f.m19154d()     // Catch:{ all -> 0x01eb }
        if (r11 != 0) goto L_0x01e2
        goto L_0x01e8
    L_0x01e2:
        com.kwai.filedownloader.exception.FileDownloadNetworkPolicyException r0 = new com.kwai.filedownloader.exception.FileDownloadNetworkPolicyException     // Catch:{ all -> 0x01eb }
        r0.m48685init()     // Catch:{ all -> 0x01eb }
        throw r0     // Catch:{ all -> 0x01eb }
    L_0x01e8:
        r13 = 3
        goto L_0x010f
    L_0x01eb:
        r0 = move-exception
        r2 = r0
        goto L_0x01f1
    L_0x01ee:
        r0 = move-exception
        r2 = r0
        r10 = r9
    L_0x01f1:
        if (r9 == 0) goto L_0x01fc
        r9.close()     // Catch:{ IOException -> 0x01f7 }
        goto L_0x01fc
    L_0x01f7:
        r0 = move-exception
        r3 = r0
        r3.printStackTrace()
    L_0x01fc:
        if (r10 == 0) goto L_0x0210
        r16.m19054d()     // Catch:{ all -> 0x0202 }
        goto L_0x0210
    L_0x0202:
        r0 = move-exception
        r2 = r0
        if (r10 == 0) goto L_0x020f
        r10.mo25197b()     // Catch:{ IOException -> 0x020a }
        goto L_0x020f
    L_0x020a:
        r0 = move-exception
        r3 = r0
        r3.printStackTrace()
    L_0x020f:
        throw r2
    L_0x0210:
        if (r10 == 0) goto L_0x021b
        r10.mo25197b()     // Catch:{ IOException -> 0x0216 }
        goto L_0x021b
    L_0x0216:
        r0 = move-exception
        r3 = r0
        r3.printStackTrace()
    L_0x021b:
        throw r2
    L_0x021c:
        com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException r0 = new com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException
        java.lang.Object[] r2 = new java.lang.Object[r6]
        int r3 = r1.f15139c
        java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        r2[r8] = r3
        int r3 = r1.f15140d
        java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        r2[r7] = r3
        java.lang.String r3 = "there isn't any content need to download on %d-%d with the content-length is 0"
        java.lang.String r2 = com.kwai.filedownloader.p358f.C4664f.m19135a(r3, r2)
        r0.m48683init(r2)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.download.C4636e.mo25180b():void");
    }
}
