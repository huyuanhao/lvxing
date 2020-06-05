package com.p530ss.android.socialbase.downloader.p568l;

import android.os.Process;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.downloader.DownloadResponseHandler;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.p530ss.android.socialbase.downloader.p562g.C6712d;
import com.p530ss.android.socialbase.downloader.p562g.DownloadChunk;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p564i.IDownloadHttpConnection;

/* renamed from: com.ss.android.socialbase.downloader.l.b */
public class DownloadChunkRunnable implements Runnable {
    /* renamed from: a */
    private static final String f22306a = DownloadChunkRunnable.class.getSimpleName();
    /* renamed from: b */
    private DownloadChunk f22307b;
    /* renamed from: c */
    private DownloadChunk f22308c;
    /* renamed from: d */
    private DownloadResponseHandler f22309d;
    /* renamed from: e */
    private final C6712d f22310e;
    /* renamed from: f */
    private DownloadInfo f22311f;
    /* renamed from: g */
    private final IDownloadRunnableCallback f22312g;
    /* renamed from: h */
    private IDownloadHttpConnection f22313h;
    /* renamed from: i */
    private IDownloadCache f22314i;
    /* renamed from: j */
    private volatile boolean f22315j;
    /* renamed from: k */
    private volatile boolean f22316k;
    /* renamed from: l */
    private boolean f22317l;

    public DownloadChunkRunnable(DownloadChunk bVar, C6712d dVar, IDownloadRunnableCallback eVar) {
        this.f22317l = false;
        this.f22308c = bVar;
        this.f22310e = dVar;
        if (dVar != null) {
            this.f22311f = dVar.mo32357a();
        }
        this.f22312g = eVar;
        this.f22314i = C6694b.m27384p();
        this.f22308c.mo32115a(this);
    }

    public DownloadChunkRunnable(DownloadChunk bVar, C6712d dVar, IDownloadHttpConnection eVar, IDownloadRunnableCallback eVar2) {
        this(bVar, dVar, eVar2);
        this.f22313h = eVar;
    }

    /* renamed from: c */
    private String m28635c() {
        return this.f22311f.mo32163I();
    }

    public void run() {
        Process.setThreadPriority(10);
        this.f22307b = this.f22308c;
        while (true) {
            try {
                this.f22307b.mo32115a(this);
                if (m28634a(this.f22307b)) {
                    this.f22307b.mo32117a(false);
                    if (!m28637e()) {
                        this.f22307b = this.f22312g.mo32564a(this.f22307b.mo32141s());
                        if (m28637e() || this.f22307b == null) {
                            break;
                        }
                        Thread.sleep(50);
                    } else {
                        break;
                    }
                } else {
                    this.f22307b.mo32117a(false);
                    break;
                }
            } catch (Throwable th) {
                DownloadChunk bVar = this.f22307b;
                if (bVar != null) {
                    bVar.mo32117a(false);
                }
                m28636d();
                this.f22312g.mo32568a(this);
                throw th;
            }
        }
        DownloadChunk bVar2 = this.f22307b;
        if (bVar2 != null) {
            bVar2.mo32117a(false);
        }
        m28636d();
        this.f22312g.mo32568a(this);
    }

    /* renamed from: a */
    public void mo32559a(long j, long j2) {
        DownloadResponseHandler dVar = this.f22309d;
        if (dVar != null) {
            dVar.mo31889a(j, j2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0171, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0172, code lost:
            r20 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x01af, code lost:
            r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:?, code lost:
            com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28768a(r0, "downloadChunkInner");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
            if (r3.mo32141s() == r27.mo32141s()) goto L_0x0023;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01af A[ExcHandler: all (th java.lang.Throwable), PHI: r11 
  PHI: (r11v9 boolean) = (r11v10 boolean), (r11v10 boolean), (r11v13 boolean), (r11v13 boolean), (r11v13 boolean), (r11v13 boolean), (r11v13 boolean), (r11v13 boolean) binds: {(r11v10 boolean)=B:121:0x018e, (r11v10 boolean)=B:133:0x01ab, (r11v13 boolean)=B:78:0x0101, (r11v13 boolean)=B:109:0x0175, (r11v13 boolean)=B:103:0x0167, (r11v13 boolean)=B:104:?, (r11v13 boolean)=B:83:0x0109, (r11v13 boolean)=B:91:0x0130} A[DONT_GENERATE, DONT_INLINE], Splitter:B:78:0x0101] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x024d A[Catch:{ a -> 0x01c6, all -> 0x02a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0254 A[Catch:{ a -> 0x01c6, all -> 0x02a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0262 A[SYNTHETIC, Splitter:B:199:0x0262] */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x025e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x00fb A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0100  */
    /* renamed from: a */
    private boolean m28634a(com.p530ss.android.socialbase.downloader.p562g.DownloadChunk r27) {
        /*
        r26 = this;
        r1 = r26
        r2 = r27
    L_0x0004:
        r0 = 0
        boolean r3 = r27.mo32125d()
        if (r3 == 0) goto L_0x0022
        boolean r3 = r27.mo32128f()
        if (r3 == 0) goto L_0x0022
        com.ss.android.socialbase.downloader.g.b r3 = r27.mo32127e()
        if (r3 == 0) goto L_0x0022
        int r4 = r3.mo32141s()
        int r5 = r27.mo32141s()
        if (r4 != r5) goto L_0x0022
        goto L_0x0023
    L_0x0022:
        r3 = r0
    L_0x0023:
        r4 = 1
        if (r3 == 0) goto L_0x002d
        boolean r0 = r3.mo32131i()
        if (r0 == 0) goto L_0x002d
        return r4
    L_0x002d:
        long r5 = r27.mo32136n()
        long r7 = r27.mo32138p()
        long r9 = r27.mo32136n()
        if (r3 == 0) goto L_0x0047
        long r9 = r3.mo32136n()
        long r5 = r3.mo32136n()
        long r7 = r3.mo32138p()
    L_0x0047:
        r17 = 0
        r15 = 0
        boolean r0 = r26.m28637e()     // Catch:{ a -> 0x01d0, all -> 0x01b3 }
        if (r0 == 0) goto L_0x0054
        r26.m28636d()
        return r15
    L_0x0054:
        java.lang.String r0 = r26.m28635c()     // Catch:{ a -> 0x01d0, all -> 0x01b3 }
        com.ss.android.socialbase.downloader.i.e r11 = r1.f22313h     // Catch:{ a -> 0x01d0, all -> 0x01b3 }
        if (r11 == 0) goto L_0x005e
        r11 = 1
        goto L_0x005f
    L_0x005e:
        r11 = 0
    L_0x005f:
        r1.f22317l = r11     // Catch:{ a -> 0x01d0, all -> 0x01b3 }
        boolean r11 = r1.f22317l     // Catch:{ a -> 0x01d0, all -> 0x01b3 }
        r2.mo32121b(r11)     // Catch:{ a -> 0x01d0, all -> 0x01b3 }
        r13 = 300(0x12c, float:4.2E-43)
        r14 = 200(0xc8, float:2.8E-43)
        boolean r11 = r1.f22317l     // Catch:{ a -> 0x0187, all -> 0x00cf }
        if (r11 != 0) goto L_0x00ac
        com.ss.android.socialbase.downloader.g.c r11 = r1.f22311f     // Catch:{ a -> 0x0187, all -> 0x00cf }
        java.util.List r11 = r11.mo32156B()     // Catch:{ a -> 0x0187, all -> 0x00cf }
        com.ss.android.socialbase.downloader.g.c r12 = r1.f22311f     // Catch:{ a -> 0x0187, all -> 0x00cf }
        java.lang.String r12 = r12.mo32226ac()     // Catch:{ a -> 0x0187, all -> 0x00cf }
        r4 = 200(0xc8, float:2.8E-43)
        r13 = r5
        r15 = r7
        java.util.List r11 = com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28759a(r11, r12, r13, r15)     // Catch:{ a -> 0x00a9, all -> 0x00a7 }
        com.ss.android.socialbase.downloader.g.e r12 = new com.ss.android.socialbase.downloader.g.e     // Catch:{ a -> 0x00a9, all -> 0x00a7 }
        java.lang.String r13 = "Chunk-Index"
        int r14 = r27.mo32141s()     // Catch:{ a -> 0x00a9, all -> 0x00a7 }
        java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ a -> 0x00a9, all -> 0x00a7 }
        r12.m51577init(r13, r14)     // Catch:{ a -> 0x00a9, all -> 0x00a7 }
        r11.add(r12)     // Catch:{ a -> 0x00a9, all -> 0x00a7 }
        com.ss.android.socialbase.downloader.g.c r12 = r1.f22311f     // Catch:{ a -> 0x00a9, all -> 0x00a7 }
        boolean r12 = r12.mo32306o()     // Catch:{ a -> 0x00a9, all -> 0x00a7 }
        com.ss.android.socialbase.downloader.g.c r13 = r1.f22311f     // Catch:{ a -> 0x00a9, all -> 0x00a7 }
        int r13 = r13.mo32157C()     // Catch:{ a -> 0x00a9, all -> 0x00a7 }
        com.ss.android.socialbase.downloader.i.e r0 = com.p530ss.android.socialbase.downloader.downloader.C6694b.m27350a(r12, r13, r0, r11)     // Catch:{ a -> 0x00a9, all -> 0x00a7 }
        r1.f22313h = r0     // Catch:{ a -> 0x00a9, all -> 0x00a7 }
        goto L_0x00ae
    L_0x00a7:
        r0 = move-exception
        goto L_0x00d2
    L_0x00a9:
        r0 = move-exception
        goto L_0x018a
    L_0x00ac:
        r4 = 200(0xc8, float:2.8E-43)
    L_0x00ae:
        com.ss.android.socialbase.downloader.i.e r0 = r1.f22313h     // Catch:{ a -> 0x01d0, all -> 0x01b3 }
        if (r0 == 0) goto L_0x00f5
        com.ss.android.socialbase.downloader.l.e r0 = r1.f22312g     // Catch:{ a -> 0x01d0, all -> 0x01b3 }
        if (r0 == 0) goto L_0x00f5
        com.ss.android.socialbase.downloader.i.e r0 = r1.f22313h     // Catch:{ all -> 0x00ca }
        int r0 = r0.mo16501b()     // Catch:{ all -> 0x00ca }
        if (r0 < r4) goto L_0x00c2
        r4 = 300(0x12c, float:4.2E-43)
        if (r0 < r4) goto L_0x00f5
    L_0x00c2:
        com.ss.android.socialbase.downloader.l.e r0 = r1.f22312g     // Catch:{ all -> 0x00ca }
        com.ss.android.socialbase.downloader.i.e r4 = r1.f22313h     // Catch:{ all -> 0x00ca }
        r0.mo32567a(r4)     // Catch:{ all -> 0x00ca }
        goto L_0x00f5
    L_0x00ca:
        r0 = move-exception
    L_0x00cb:
        r0.printStackTrace()     // Catch:{ a -> 0x01d0, all -> 0x01b3 }
        goto L_0x00f5
    L_0x00cf:
        r0 = move-exception
        r4 = 200(0xc8, float:2.8E-43)
    L_0x00d2:
        java.lang.String r11 = "ChunkRunnableConnection"
        com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28768a(r0, r11)     // Catch:{ all -> 0x0184 }
        com.ss.android.socialbase.downloader.i.e r0 = r1.f22313h     // Catch:{ a -> 0x01d0, all -> 0x01b3 }
        if (r0 == 0) goto L_0x00f5
        com.ss.android.socialbase.downloader.l.e r0 = r1.f22312g     // Catch:{ a -> 0x01d0, all -> 0x01b3 }
        if (r0 == 0) goto L_0x00f5
        com.ss.android.socialbase.downloader.i.e r0 = r1.f22313h     // Catch:{ all -> 0x00f3 }
        int r0 = r0.mo16501b()     // Catch:{ all -> 0x00f3 }
        if (r0 < r4) goto L_0x00eb
        r4 = 300(0x12c, float:4.2E-43)
        if (r0 < r4) goto L_0x00f5
    L_0x00eb:
        com.ss.android.socialbase.downloader.l.e r0 = r1.f22312g     // Catch:{ all -> 0x00f3 }
        com.ss.android.socialbase.downloader.i.e r4 = r1.f22313h     // Catch:{ all -> 0x00f3 }
        r0.mo32567a(r4)     // Catch:{ all -> 0x00f3 }
        goto L_0x00f5
    L_0x00f3:
        r0 = move-exception
        goto L_0x00cb
    L_0x00f5:
        boolean r0 = r26.m28637e()     // Catch:{ a -> 0x01d0, all -> 0x01b3 }
        if (r0 == 0) goto L_0x0100
        r26.m28636d()
        r11 = 0
        return r11
    L_0x0100:
        r11 = 0
        com.ss.android.socialbase.downloader.i.e r0 = r1.f22313h     // Catch:{ a -> 0x01b1, all -> 0x01af }
        if (r0 == 0) goto L_0x0175
        boolean r0 = r1.f22317l     // Catch:{ a -> 0x01b1, all -> 0x01af }
        if (r0 != 0) goto L_0x0136
        com.ss.android.socialbase.downloader.i.e r0 = r1.f22313h     // Catch:{ a -> 0x0134, all -> 0x012d }
        int r0 = r0.mo16501b()     // Catch:{ a -> 0x0134, all -> 0x012d }
        boolean r4 = com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28790b(r0)     // Catch:{ a -> 0x0134, all -> 0x012d }
        if (r4 == 0) goto L_0x0116
        goto L_0x0136
    L_0x0116:
        com.ss.android.socialbase.downloader.e.a r4 = new com.ss.android.socialbase.downloader.e.a     // Catch:{ a -> 0x0134, all -> 0x012d }
        r12 = 1002(0x3ea, float:1.404E-42)
        java.lang.String r13 = "Http response error , code is : %s "
        r14 = 1
        java.lang.Object[] r15 = new java.lang.Object[r14]     // Catch:{ a -> 0x0134, all -> 0x012d }
        java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ a -> 0x0134, all -> 0x012d }
        r15[r11] = r0     // Catch:{ a -> 0x0134, all -> 0x012d }
        java.lang.String r0 = java.lang.String.format(r13, r15)     // Catch:{ a -> 0x0134, all -> 0x012d }
        r4.m51543init(r12, r0)     // Catch:{ a -> 0x0134, all -> 0x012d }
        throw r4     // Catch:{ a -> 0x0134, all -> 0x012d }
    L_0x012d:
        r0 = move-exception
        java.lang.String r4 = "ChunkRunnableGetResponseCode"
        com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28768a(r0, r4)     // Catch:{ a -> 0x01b1, all -> 0x01af }
        goto L_0x0136
    L_0x0134:
        r0 = move-exception
        throw r0     // Catch:{ a -> 0x01b1, all -> 0x01af }
    L_0x0136:
        com.ss.android.socialbase.downloader.downloader.d r0 = new com.ss.android.socialbase.downloader.downloader.d     // Catch:{ a -> 0x01b1, all -> 0x01af }
        com.ss.android.socialbase.downloader.g.c r4 = r1.f22311f     // Catch:{ a -> 0x01b1, all -> 0x01af }
        com.ss.android.socialbase.downloader.i.e r12 = r1.f22313h     // Catch:{ a -> 0x01b1, all -> 0x01af }
        com.ss.android.socialbase.downloader.l.e r13 = r1.f22312g     // Catch:{ a -> 0x01b1, all -> 0x01af }
        r0.m51528init(r4, r12, r2, r13)     // Catch:{ a -> 0x01b1, all -> 0x01af }
        r1.f22309d = r0     // Catch:{ a -> 0x01b1, all -> 0x01af }
        if (r3 == 0) goto L_0x0167
        long r12 = r3.mo32122c(r11)     // Catch:{ a -> 0x01b1, all -> 0x01af }
        int r0 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
        if (r0 == 0) goto L_0x0156
        int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
        if (r0 < 0) goto L_0x0156
        long r7 = r7 - r5
        r4 = 1
        long r12 = r7 + r4
    L_0x0156:
        r24 = r12
        com.ss.android.socialbase.downloader.downloader.d r0 = r1.f22309d     // Catch:{ a -> 0x01b1, all -> 0x01af }
        long r20 = r3.mo32136n()     // Catch:{ a -> 0x01b1, all -> 0x01af }
        long r22 = r3.mo32138p()     // Catch:{ a -> 0x01b1, all -> 0x01af }
        r19 = r0
        r19.mo31890a(r20, r22, r24)     // Catch:{ a -> 0x01b1, all -> 0x01af }
    L_0x0167:
        com.ss.android.socialbase.downloader.downloader.d r0 = r1.f22309d     // Catch:{ a -> 0x0171, all -> 0x01af }
        r0.mo31893d()     // Catch:{ a -> 0x0171, all -> 0x01af }
        r26.m28636d()
        r2 = 1
        return r2
    L_0x0171:
        r0 = move-exception
        r20 = 1
        goto L_0x01d4
    L_0x0175:
        com.ss.android.socialbase.downloader.e.a r0 = new com.ss.android.socialbase.downloader.e.a     // Catch:{ a -> 0x01b1, all -> 0x01af }
        r3 = 1022(0x3fe, float:1.432E-42)
        java.io.IOException r4 = new java.io.IOException     // Catch:{ a -> 0x01b1, all -> 0x01af }
        java.lang.String r5 = "download can't continue, chunk connection is null"
        r4.<init>(r5)     // Catch:{ a -> 0x01b1, all -> 0x01af }
        r0.m51544init(r3, r4)     // Catch:{ a -> 0x01b1, all -> 0x01af }
        throw r0     // Catch:{ a -> 0x01b1, all -> 0x01af }
    L_0x0184:
        r0 = move-exception
        r11 = 0
        goto L_0x018d
    L_0x0187:
        r0 = move-exception
        r4 = 200(0xc8, float:2.8E-43)
    L_0x018a:
        r11 = 0
        throw r0     // Catch:{ all -> 0x018c }
    L_0x018c:
        r0 = move-exception
    L_0x018d:
        r3 = r0
        com.ss.android.socialbase.downloader.i.e r0 = r1.f22313h     // Catch:{ a -> 0x01b1, all -> 0x01af }
        if (r0 == 0) goto L_0x01ae
        com.ss.android.socialbase.downloader.l.e r0 = r1.f22312g     // Catch:{ a -> 0x01b1, all -> 0x01af }
        if (r0 == 0) goto L_0x01ae
        com.ss.android.socialbase.downloader.i.e r0 = r1.f22313h     // Catch:{ all -> 0x01aa }
        int r0 = r0.mo16501b()     // Catch:{ all -> 0x01aa }
        if (r0 < r4) goto L_0x01a2
        r4 = 300(0x12c, float:4.2E-43)
        if (r0 < r4) goto L_0x01ae
    L_0x01a2:
        com.ss.android.socialbase.downloader.l.e r0 = r1.f22312g     // Catch:{ all -> 0x01aa }
        com.ss.android.socialbase.downloader.i.e r4 = r1.f22313h     // Catch:{ all -> 0x01aa }
        r0.mo32567a(r4)     // Catch:{ all -> 0x01aa }
        goto L_0x01ae
    L_0x01aa:
        r0 = move-exception
        r0.printStackTrace()     // Catch:{ a -> 0x01b1, all -> 0x01af }
    L_0x01ae:
        throw r3     // Catch:{ a -> 0x01b1, all -> 0x01af }
    L_0x01af:
        r0 = move-exception
        goto L_0x01b5
    L_0x01b1:
        r0 = move-exception
        goto L_0x01d2
    L_0x01b3:
        r0 = move-exception
        r11 = 0
    L_0x01b5:
        boolean r2 = r26.m28637e()     // Catch:{ all -> 0x02a0 }
        if (r2 == 0) goto L_0x01c0
    L_0x01bb:
        r26.m28636d()
        r2 = 1
        return r2
    L_0x01c0:
        java.lang.String r2 = "downloadChunkInner"
        com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28768a(r0, r2)     // Catch:{ a -> 0x01c6 }
        goto L_0x01cc
    L_0x01c6:
        r0 = move-exception
        com.ss.android.socialbase.downloader.l.e r2 = r1.f22312g     // Catch:{ all -> 0x02a0 }
        r2.mo32573b(r0)     // Catch:{ all -> 0x02a0 }
    L_0x01cc:
        r26.m28636d()
        return r11
    L_0x01d0:
        r0 = move-exception
        r11 = 0
    L_0x01d2:
        r20 = 0
    L_0x01d4:
        boolean r3 = r26.m28637e()     // Catch:{ all -> 0x02a0 }
        if (r3 == 0) goto L_0x01db
        goto L_0x01bb
    L_0x01db:
        boolean r3 = com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28793b(r0)     // Catch:{ all -> 0x02a0 }
        if (r3 == 0) goto L_0x01ea
        com.ss.android.socialbase.downloader.l.e r2 = r1.f22312g     // Catch:{ all -> 0x02a0 }
        r2.mo32566a(r0, r11)     // Catch:{ all -> 0x02a0 }
        r26.m28636d()
        return r11
    L_0x01ea:
        com.ss.android.socialbase.downloader.l.e r3 = r1.f22312g     // Catch:{ all -> 0x02a0 }
        boolean r3 = r3.mo32571a(r0)     // Catch:{ all -> 0x02a0 }
        if (r3 == 0) goto L_0x026d
        boolean r3 = com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28775a(r0)     // Catch:{ all -> 0x02a0 }
        if (r3 == 0) goto L_0x0202
        com.ss.android.socialbase.downloader.l.e r2 = r1.f22312g     // Catch:{ all -> 0x02a0 }
        r3 = 1
        r2.mo32566a(r0, r3)     // Catch:{ all -> 0x02a0 }
        r26.m28636d()
        return r11
    L_0x0202:
        if (r20 == 0) goto L_0x0243
        com.ss.android.socialbase.downloader.downloader.d r3 = r1.f22309d     // Catch:{ all -> 0x02a0 }
        if (r3 == 0) goto L_0x023a
        r3 = 32
        boolean r3 = com.p530ss.android.socialbase.downloader.p569m.DownloadExpSwitchCode.m28744a(r3)     // Catch:{ all -> 0x02a0 }
        if (r3 == 0) goto L_0x022e
        com.ss.android.socialbase.downloader.downloader.d r3 = r1.f22309d     // Catch:{ all -> 0x02a0 }
        long r3 = r3.mo31888a()     // Catch:{ all -> 0x02a0 }
        com.ss.android.socialbase.downloader.downloader.d r5 = r1.f22309d     // Catch:{ all -> 0x02a0 }
        long r5 = r5.mo31894e()     // Catch:{ all -> 0x02a0 }
        long r3 = r3 - r5
        int r5 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
        if (r5 <= 0) goto L_0x022b
        com.ss.android.socialbase.downloader.downloader.d r5 = r1.f22309d     // Catch:{ all -> 0x02a0 }
        long r5 = r5.mo31894e()     // Catch:{ all -> 0x02a0 }
        r1.m28633a(r2, r5)     // Catch:{ all -> 0x02a0 }
        goto L_0x0245
    L_0x022b:
        if (r5 >= 0) goto L_0x0245
        goto L_0x0243
    L_0x022e:
        com.ss.android.socialbase.downloader.downloader.d r3 = r1.f22309d     // Catch:{ all -> 0x02a0 }
        long r3 = r3.mo31888a()     // Catch:{ all -> 0x02a0 }
        long r17 = r3 - r9
        r1.m28633a(r2, r9)     // Catch:{ all -> 0x02a0 }
        goto L_0x0243
    L_0x023a:
        com.ss.android.socialbase.downloader.l.e r2 = r1.f22312g     // Catch:{ all -> 0x02a0 }
        r2.mo32573b(r0)     // Catch:{ all -> 0x02a0 }
        r26.m28636d()
        return r11
    L_0x0243:
        r3 = r17
    L_0x0245:
        r5 = 16
        boolean r5 = com.p530ss.android.socialbase.downloader.p569m.DownloadExpSwitchCode.m28744a(r5)     // Catch:{ all -> 0x02a0 }
        if (r5 == 0) goto L_0x0254
        com.ss.android.socialbase.downloader.l.e r5 = r1.f22312g     // Catch:{ all -> 0x02a0 }
        com.ss.android.socialbase.downloader.e.g r0 = r5.mo32563a(r2, r0, r3)     // Catch:{ all -> 0x02a0 }
        goto L_0x025a
    L_0x0254:
        com.ss.android.socialbase.downloader.l.e r5 = r1.f22312g     // Catch:{ all -> 0x02a0 }
        com.ss.android.socialbase.downloader.e.g r0 = r5.mo32562a(r0, r3)     // Catch:{ all -> 0x02a0 }
    L_0x025a:
        com.ss.android.socialbase.downloader.e.g r3 = com.p530ss.android.socialbase.downloader.p560e.RetryCheckStatus.RETURN     // Catch:{ all -> 0x02a0 }
        if (r0 != r3) goto L_0x0262
        r26.m28636d()
        return r11
    L_0x0262:
        r2.mo32121b(r11)     // Catch:{ all -> 0x02a0 }
        r26.m28636d()     // Catch:{ all -> 0x02a0 }
        r26.m28636d()
        goto L_0x0004
    L_0x026d:
        com.ss.android.socialbase.downloader.g.c r2 = r1.f22311f     // Catch:{ all -> 0x02a0 }
        boolean r2 = r2.mo32238ao()     // Catch:{ all -> 0x02a0 }
        if (r2 == 0) goto L_0x0297
        com.ss.android.socialbase.downloader.g.c r2 = r1.f22311f     // Catch:{ all -> 0x02a0 }
        boolean r2 = r2.mo32239ap()     // Catch:{ all -> 0x02a0 }
        if (r2 != 0) goto L_0x0297
        com.ss.android.socialbase.downloader.g.c r2 = r1.f22311f     // Catch:{ all -> 0x02a0 }
        int r2 = r2.mo32219aV()     // Catch:{ all -> 0x02a0 }
        r3 = 1
        if (r2 <= r3) goto L_0x0297
        com.ss.android.socialbase.downloader.g.c r2 = r1.f22311f     // Catch:{ all -> 0x02a0 }
        boolean r2 = com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28776a(r0, r2)     // Catch:{ all -> 0x02a0 }
        if (r2 == 0) goto L_0x0297
        com.ss.android.socialbase.downloader.l.e r2 = r1.f22312g     // Catch:{ all -> 0x02a0 }
        r2.mo32575c(r0)     // Catch:{ all -> 0x02a0 }
        r26.m28636d()
        return r11
    L_0x0297:
        com.ss.android.socialbase.downloader.l.e r2 = r1.f22312g     // Catch:{ all -> 0x02a0 }
        r2.mo32573b(r0)     // Catch:{ all -> 0x02a0 }
        r26.m28636d()
        return r11
    L_0x02a0:
        r0 = move-exception
        r26.m28636d()
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.p568l.DownloadChunkRunnable.m28634a(com.ss.android.socialbase.downloader.g.b):boolean");
    }

    /* renamed from: a */
    private void m28633a(DownloadChunk bVar, long j) {
        DownloadChunk e = bVar.mo32125d() ? bVar.mo32127e() : bVar;
        if (e != null) {
            if (e.mo32130h()) {
                this.f22314i.mo31671a(e.mo32133k(), e.mo32118b(), j);
            }
            e.mo32120b(j);
            this.f22314i.mo31670a(e.mo32133k(), e.mo32141s(), e.mo32118b(), j);
        } else if (bVar.mo32125d()) {
            this.f22314i.mo31671a(bVar.mo32133k(), bVar.mo32141s(), j);
        }
    }

    /* renamed from: d */
    private void m28636d() {
        IDownloadHttpConnection eVar = this.f22313h;
        if (eVar != null) {
            eVar.mo16503d();
            this.f22313h = null;
        }
    }

    /* renamed from: e */
    private boolean m28637e() {
        return this.f22315j || this.f22316k;
    }

    /* renamed from: a */
    public void mo32558a() {
        this.f22315j = true;
        DownloadResponseHandler dVar = this.f22309d;
        if (dVar != null) {
            dVar.mo31891b();
        }
    }

    /* renamed from: b */
    public void mo32560b() {
        this.f22316k = true;
        DownloadResponseHandler dVar = this.f22309d;
        if (dVar != null) {
            dVar.mo31892c();
        }
    }
}
