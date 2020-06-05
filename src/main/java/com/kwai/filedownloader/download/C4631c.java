package com.kwai.filedownloader.download;

import com.kwai.filedownloader.p356d.C4619b;
import com.kwai.filedownloader.p358f.C4664f;

/* renamed from: com.kwai.filedownloader.download.c */
public class C4631c implements Runnable {
    /* renamed from: a */
    final int f15106a;
    /* renamed from: b */
    private final ConnectTask f15107b;
    /* renamed from: c */
    private final C4639f f15108c;
    /* renamed from: d */
    private final String f15109d;
    /* renamed from: e */
    private final boolean f15110e;
    /* renamed from: f */
    private C4636e f15111f;
    /* renamed from: g */
    private volatile boolean f15112g;
    /* renamed from: h */
    private final int f15113h;

    /* renamed from: com.kwai.filedownloader.download.c$a */
    public static class C4633a {
        /* renamed from: a */
        private final C4625a f15114a = new C4625a();
        /* renamed from: b */
        private C4639f f15115b;
        /* renamed from: c */
        private String f15116c;
        /* renamed from: d */
        private Boolean f15117d;
        /* renamed from: e */
        private Integer f15118e;

        /* renamed from: a */
        public C4633a mo25151a(int i) {
            this.f15114a.mo25111a(i);
            return this;
        }

        /* renamed from: a */
        public C4633a mo25152a(C4619b bVar) {
            this.f15114a.mo25112a(bVar);
            return this;
        }

        /* renamed from: a */
        public C4633a mo25153a(C4628a aVar) {
            this.f15114a.mo25113a(aVar);
            return this;
        }

        /* renamed from: a */
        public C4633a mo25154a(C4639f fVar) {
            this.f15115b = fVar;
            return this;
        }

        /* renamed from: a */
        public C4633a mo25155a(Integer num) {
            this.f15118e = num;
            return this;
        }

        /* renamed from: a */
        public C4633a mo25156a(String str) {
            this.f15114a.mo25114a(str);
            return this;
        }

        /* renamed from: a */
        public C4633a mo25157a(boolean z) {
            this.f15117d = Boolean.valueOf(z);
            return this;
        }

        /* renamed from: a */
        public C4631c mo25158a() {
            if (this.f15115b == null || this.f15116c == null || this.f15117d == null || this.f15118e == null) {
                throw new IllegalArgumentException(C4664f.m19135a("%s %s %B", this.f15115b, this.f15116c, this.f15117d));
            }
            ConnectTask a = this.f15114a.mo25115a();
            C4631c cVar = new C4631c(a.f15048a, this.f15118e.intValue(), a, this.f15115b, this.f15117d.booleanValue(), this.f15116c);
            return cVar;
        }

        /* renamed from: b */
        public C4633a mo25159b(String str) {
            this.f15114a.mo25116b(str);
            return this;
        }

        /* renamed from: c */
        public C4633a mo25160c(String str) {
            this.f15116c = str;
            return this;
        }
    }

    private C4631c(int i, int i2, ConnectTask connectTask, C4639f fVar, boolean z, String str) {
        this.f15113h = i;
        this.f15106a = i2;
        this.f15112g = false;
        this.f15108c = fVar;
        this.f15109d = str;
        this.f15107b = connectTask;
        this.f15110e = z;
    }

    /* renamed from: a */
    public void mo25148a() {
        this.f15112g = true;
        C4636e eVar = this.f15111f;
        if (eVar != null) {
            eVar.mo25179a();
        }
    }

    /* renamed from: b */
    public void mo25149b() {
        mo25148a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00f1, code lost:
            r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00f8, code lost:
            r6 = r3;
            r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00fb, code lost:
            r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00fd, code lost:
            r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0104, code lost:
            r13 = r6;
            r6 = r3;
            r3 = r4;
            r4 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0110, code lost:
            if (r3 == false) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0112, code lost:
            r14.f15108c.mo25120a(r4, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x011c, code lost:
            if (r14.f15111f != null) goto L_0x011e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x011e, code lost:
            r14.f15108c.mo25120a(r4, r14.f15111f.f15137a - r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0128, code lost:
            if (r6 != null) goto L_0x012a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x012a, code lost:
            r6.mo22747f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x012d, code lost:
            r4 = r3;
            r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
            com.kwai.filedownloader.p358f.C4660d.m19124d(r14, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", r4);
            r14.f15108c.mo25123b(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x013f, code lost:
            if (r6 != null) goto L_0x0141;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0142, code lost:
            r14.f15108c.mo25123b(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0147, code lost:
            if (r6 != null) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0151, code lost:
            r3.mo22747f();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00fb A[ExcHandler: all (th java.lang.Throwable), PHI: r3 
  PHI: (r3v7 com.kwai.filedownloader.a.b) = (r3v1 com.kwai.filedownloader.a.b), (r3v1 com.kwai.filedownloader.a.b), (r3v1 com.kwai.filedownloader.a.b), (r3v9 com.kwai.filedownloader.a.b), (r3v9 com.kwai.filedownloader.a.b), (r3v9 com.kwai.filedownloader.a.b) binds: {(r3v1 com.kwai.filedownloader.a.b)=B:2:0x0011, (r3v1 com.kwai.filedownloader.a.b)=B:3:?, (r3v1 com.kwai.filedownloader.a.b)=B:8:0x001b, (r3v9 com.kwai.filedownloader.a.b)=B:19:0x008d, (r3v9 com.kwai.filedownloader.a.b)=B:20:?, (r3v9 com.kwai.filedownloader.a.b)=B:25:0x009c} A[DONT_GENERATE, DONT_INLINE], Splitter:B:2:0x0011] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0110 A[Catch:{ all -> 0x014d }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0142 A[SYNTHETIC] */
    public void run() {
        /*
        r14 = this;
        r0 = 10
        android.os.Process.setThreadPriority(r0)
        com.kwai.filedownloader.download.ConnectTask r0 = r14.f15107b
        com.kwai.filedownloader.download.a r0 = r0.mo25110e()
        long r0 = r0.f15096b
        r2 = 0
        r3 = 0
        r4 = 0
    L_0x0010:
        r5 = 1
        boolean r4 = r14.f15112g     // Catch:{ IllegalAccessException -> 0x0103, IOException -> 0x0101, FileDownloadGiveUpRetryException -> 0x00ff, IllegalArgumentException -> 0x00fd, all -> 0x00fb }
        if (r4 == 0) goto L_0x001b
        if (r3 == 0) goto L_0x001a
        r3.mo22747f()
    L_0x001a:
        return
    L_0x001b:
        com.kwai.filedownloader.download.ConnectTask r4 = r14.f15107b     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        com.kwai.filedownloader.a.b r3 = r4.mo25106a()     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        int r4 = r3.mo22746e()     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        boolean r6 = com.kwai.filedownloader.p358f.C4660d.f15179a     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        r7 = 3
        r8 = 2
        r9 = 4
        if (r6 == 0) goto L_0x0051
        java.lang.String r6 = "the connection[%d] for %d, is connected %s with requestHttpCode[%d]"
        java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        int r11 = r14.f15106a     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        r10[r2] = r11     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        int r11 = r14.f15113h     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        r10[r5] = r11     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        com.kwai.filedownloader.download.ConnectTask r11 = r14.f15107b     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        com.kwai.filedownloader.download.a r11 = r11.mo25110e()     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        r10[r8] = r11     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        java.lang.Integer r11 = java.lang.Integer.valueOf(r4)     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        r10[r7] = r11     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        com.kwai.filedownloader.p358f.C4660d.m19123c(r14, r6, r10)     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
    L_0x0051:
        r6 = 206(0xce, float:2.89E-43)
        if (r4 == r6) goto L_0x008d
        r6 = 200(0xc8, float:2.8E-43)
        if (r4 != r6) goto L_0x005a
        goto L_0x008d
    L_0x005a:
        java.net.SocketException r6 = new java.net.SocketException     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        java.lang.String r10 = "Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again."
        r11 = 5
        java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        com.kwai.filedownloader.download.ConnectTask r12 = r14.f15107b     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        java.util.Map r12 = r12.mo25109d()     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        r11[r2] = r12     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        java.util.Map r12 = r3.mo22744c()     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        r11[r5] = r12     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        r11[r8] = r4     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        int r4 = r14.f15113h     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        r11[r7] = r4     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        int r4 = r14.f15106a     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        r11[r9] = r4     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        java.lang.String r4 = com.kwai.filedownloader.p358f.C4664f.m19135a(r10, r11)     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        r6.<init>(r4)     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
        throw r6     // Catch:{ IllegalAccessException -> 0x00f7, IOException -> 0x00f5, FileDownloadGiveUpRetryException -> 0x00f3, IllegalArgumentException -> 0x00f1, all -> 0x00fb }
    L_0x008d:
        com.kwai.filedownloader.download.e$a r4 = new com.kwai.filedownloader.download.e$a     // Catch:{ IllegalAccessException -> 0x00ed, IOException -> 0x00eb, FileDownloadGiveUpRetryException -> 0x00e9, IllegalArgumentException -> 0x00e7, all -> 0x00fb }
        r4.m48672init()     // Catch:{ IllegalAccessException -> 0x00ed, IOException -> 0x00eb, FileDownloadGiveUpRetryException -> 0x00e9, IllegalArgumentException -> 0x00e7, all -> 0x00fb }
        boolean r6 = r14.f15112g     // Catch:{ IllegalAccessException -> 0x00ed, IOException -> 0x00eb, FileDownloadGiveUpRetryException -> 0x00e9, IllegalArgumentException -> 0x00e7, all -> 0x00fb }
        if (r6 == 0) goto L_0x009c
        if (r3 == 0) goto L_0x009b
        r3.mo22747f()
    L_0x009b:
        return
    L_0x009c:
        int r6 = r14.f15113h     // Catch:{ IllegalAccessException -> 0x00ed, IOException -> 0x00eb, FileDownloadGiveUpRetryException -> 0x00e9, IllegalArgumentException -> 0x00e7, all -> 0x00fb }
        com.kwai.filedownloader.download.e$a r4 = r4.mo25189b(r6)     // Catch:{ IllegalAccessException -> 0x00ed, IOException -> 0x00eb, FileDownloadGiveUpRetryException -> 0x00e9, IllegalArgumentException -> 0x00e7, all -> 0x00fb }
        int r6 = r14.f15106a     // Catch:{ IllegalAccessException -> 0x00ed, IOException -> 0x00eb, FileDownloadGiveUpRetryException -> 0x00e9, IllegalArgumentException -> 0x00e7, all -> 0x00fb }
        com.kwai.filedownloader.download.e$a r4 = r4.mo25181a(r6)     // Catch:{ IllegalAccessException -> 0x00ed, IOException -> 0x00eb, FileDownloadGiveUpRetryException -> 0x00e9, IllegalArgumentException -> 0x00e7, all -> 0x00fb }
        com.kwai.filedownloader.download.f r6 = r14.f15108c     // Catch:{ IllegalAccessException -> 0x00ed, IOException -> 0x00eb, FileDownloadGiveUpRetryException -> 0x00e9, IllegalArgumentException -> 0x00e7, all -> 0x00fb }
        com.kwai.filedownloader.download.e$a r4 = r4.mo25185a(r6)     // Catch:{ IllegalAccessException -> 0x00ed, IOException -> 0x00eb, FileDownloadGiveUpRetryException -> 0x00e9, IllegalArgumentException -> 0x00e7, all -> 0x00fb }
        com.kwai.filedownloader.download.e$a r4 = r4.mo25184a(r14)     // Catch:{ IllegalAccessException -> 0x00ed, IOException -> 0x00eb, FileDownloadGiveUpRetryException -> 0x00e9, IllegalArgumentException -> 0x00e7, all -> 0x00fb }
        boolean r6 = r14.f15110e     // Catch:{ IllegalAccessException -> 0x00ed, IOException -> 0x00eb, FileDownloadGiveUpRetryException -> 0x00e9, IllegalArgumentException -> 0x00e7, all -> 0x00fb }
        com.kwai.filedownloader.download.e$a r4 = r4.mo25187a(r6)     // Catch:{ IllegalAccessException -> 0x00ed, IOException -> 0x00eb, FileDownloadGiveUpRetryException -> 0x00e9, IllegalArgumentException -> 0x00e7, all -> 0x00fb }
        com.kwai.filedownloader.download.e$a r4 = r4.mo25182a(r3)     // Catch:{ IllegalAccessException -> 0x00ed, IOException -> 0x00eb, FileDownloadGiveUpRetryException -> 0x00e9, IllegalArgumentException -> 0x00e7, all -> 0x00fb }
        com.kwai.filedownloader.download.ConnectTask r6 = r14.f15107b     // Catch:{ IllegalAccessException -> 0x00ed, IOException -> 0x00eb, FileDownloadGiveUpRetryException -> 0x00e9, IllegalArgumentException -> 0x00e7, all -> 0x00fb }
        com.kwai.filedownloader.download.a r6 = r6.mo25110e()     // Catch:{ IllegalAccessException -> 0x00ed, IOException -> 0x00eb, FileDownloadGiveUpRetryException -> 0x00e9, IllegalArgumentException -> 0x00e7, all -> 0x00fb }
        com.kwai.filedownloader.download.e$a r4 = r4.mo25183a(r6)     // Catch:{ IllegalAccessException -> 0x00ed, IOException -> 0x00eb, FileDownloadGiveUpRetryException -> 0x00e9, IllegalArgumentException -> 0x00e7, all -> 0x00fb }
        java.lang.String r6 = r14.f15109d     // Catch:{ IllegalAccessException -> 0x00ed, IOException -> 0x00eb, FileDownloadGiveUpRetryException -> 0x00e9, IllegalArgumentException -> 0x00e7, all -> 0x00fb }
        com.kwai.filedownloader.download.e$a r4 = r4.mo25186a(r6)     // Catch:{ IllegalAccessException -> 0x00ed, IOException -> 0x00eb, FileDownloadGiveUpRetryException -> 0x00e9, IllegalArgumentException -> 0x00e7, all -> 0x00fb }
        com.kwai.filedownloader.download.e r4 = r4.mo25188a()     // Catch:{ IllegalAccessException -> 0x00ed, IOException -> 0x00eb, FileDownloadGiveUpRetryException -> 0x00e9, IllegalArgumentException -> 0x00e7, all -> 0x00fb }
        r14.f15111f = r4     // Catch:{ IllegalAccessException -> 0x00ed, IOException -> 0x00eb, FileDownloadGiveUpRetryException -> 0x00e9, IllegalArgumentException -> 0x00e7, all -> 0x00fb }
        com.kwai.filedownloader.download.e r4 = r14.f15111f     // Catch:{ IllegalAccessException -> 0x00ed, IOException -> 0x00eb, FileDownloadGiveUpRetryException -> 0x00e9, IllegalArgumentException -> 0x00e7, all -> 0x00fb }
        r4.mo25180b()     // Catch:{ IllegalAccessException -> 0x00ed, IOException -> 0x00eb, FileDownloadGiveUpRetryException -> 0x00e9, IllegalArgumentException -> 0x00e7, all -> 0x00fb }
        boolean r4 = r14.f15112g     // Catch:{ IllegalAccessException -> 0x00ed, IOException -> 0x00eb, FileDownloadGiveUpRetryException -> 0x00e9, IllegalArgumentException -> 0x00e7, all -> 0x00fb }
        if (r4 == 0) goto L_0x00e0
        com.kwai.filedownloader.download.e r4 = r14.f15111f     // Catch:{ IllegalAccessException -> 0x00ed, IOException -> 0x00eb, FileDownloadGiveUpRetryException -> 0x00e9, IllegalArgumentException -> 0x00e7, all -> 0x00fb }
        r4.mo25179a()     // Catch:{ IllegalAccessException -> 0x00ed, IOException -> 0x00eb, FileDownloadGiveUpRetryException -> 0x00e9, IllegalArgumentException -> 0x00e7, all -> 0x00fb }
    L_0x00e0:
        if (r3 == 0) goto L_0x014c
        r3.mo22747f()
        goto L_0x014c
    L_0x00e7:
        r4 = move-exception
        goto L_0x00ee
    L_0x00e9:
        r4 = move-exception
        goto L_0x00ee
    L_0x00eb:
        r4 = move-exception
        goto L_0x00ee
    L_0x00ed:
        r4 = move-exception
    L_0x00ee:
        r6 = r3
        r3 = 1
        goto L_0x0108
    L_0x00f1:
        r4 = move-exception
        goto L_0x00f8
    L_0x00f3:
        r4 = move-exception
        goto L_0x00f8
    L_0x00f5:
        r4 = move-exception
        goto L_0x00f8
    L_0x00f7:
        r4 = move-exception
    L_0x00f8:
        r6 = r3
        r3 = 0
        goto L_0x0108
    L_0x00fb:
        r0 = move-exception
        goto L_0x014f
    L_0x00fd:
        r6 = move-exception
        goto L_0x0104
    L_0x00ff:
        r6 = move-exception
        goto L_0x0104
    L_0x0101:
        r6 = move-exception
        goto L_0x0104
    L_0x0103:
        r6 = move-exception
    L_0x0104:
        r13 = r6
        r6 = r3
        r3 = r4
        r4 = r13
    L_0x0108:
        com.kwai.filedownloader.download.f r7 = r14.f15108c     // Catch:{ all -> 0x014d }
        boolean r7 = r7.mo25121a(r4)     // Catch:{ all -> 0x014d }
        if (r7 == 0) goto L_0x0142
        if (r3 != 0) goto L_0x011a
        com.kwai.filedownloader.download.f r5 = r14.f15108c     // Catch:{ all -> 0x014d }
        r7 = 0
        r5.mo25120a(r4, r7)     // Catch:{ all -> 0x014d }
        goto L_0x0128
    L_0x011a:
        com.kwai.filedownloader.download.e r7 = r14.f15111f     // Catch:{ all -> 0x014d }
        if (r7 == 0) goto L_0x0131
        com.kwai.filedownloader.download.e r5 = r14.f15111f     // Catch:{ all -> 0x014d }
        long r7 = r5.f15137a     // Catch:{ all -> 0x014d }
        long r7 = r7 - r0
        com.kwai.filedownloader.download.f r5 = r14.f15108c     // Catch:{ all -> 0x014d }
        r5.mo25120a(r4, r7)     // Catch:{ all -> 0x014d }
    L_0x0128:
        if (r6 == 0) goto L_0x012d
        r6.mo22747f()
    L_0x012d:
        r4 = r3
        r3 = r6
        goto L_0x0010
    L_0x0131:
        java.lang.String r0 = "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s"
        java.lang.Object[] r1 = new java.lang.Object[r5]     // Catch:{ all -> 0x014d }
        r1[r2] = r4     // Catch:{ all -> 0x014d }
        com.kwai.filedownloader.p358f.C4660d.m19124d(r14, r0, r1)     // Catch:{ all -> 0x014d }
        com.kwai.filedownloader.download.f r0 = r14.f15108c     // Catch:{ all -> 0x014d }
        r0.mo25123b(r4)     // Catch:{ all -> 0x014d }
        if (r6 == 0) goto L_0x014c
        goto L_0x0149
    L_0x0142:
        com.kwai.filedownloader.download.f r0 = r14.f15108c     // Catch:{ all -> 0x014d }
        r0.mo25123b(r4)     // Catch:{ all -> 0x014d }
        if (r6 == 0) goto L_0x014c
    L_0x0149:
        r6.mo22747f()
    L_0x014c:
        return
    L_0x014d:
        r0 = move-exception
        r3 = r6
    L_0x014f:
        if (r3 == 0) goto L_0x0154
        r3.mo22747f()
    L_0x0154:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.download.C4631c.run():void");
    }
}
