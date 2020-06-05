package com.kwai.filedownloader.services;

import com.kwai.filedownloader.C4746x;
import com.kwai.filedownloader.download.C4629b;
import com.kwai.filedownloader.p354b.C4596a;
import com.kwai.filedownloader.p356d.C4618a;
import com.kwai.filedownloader.p356d.C4621c;
import com.kwai.filedownloader.p358f.C4660d;
import com.kwai.filedownloader.p358f.C4664f;
import java.util.List;

/* renamed from: com.kwai.filedownloader.services.g */
class C4737g implements C4746x {
    /* renamed from: a */
    private final C4596a f15283a;
    /* renamed from: b */
    private final C4738h f15284b;

    C4737g() {
        C4629b a = C4629b.m18995a();
        this.f15283a = a.mo25145c();
        this.f15284b = new C4738h(a.mo25146d());
    }

    /* renamed from: a */
    public int mo25340a(String str, int i) {
        return this.f15284b.mo25355a(str, i);
    }

    /* renamed from: a */
    public void mo25341a() {
        List<Integer> b = this.f15284b.mo25358b();
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "pause all tasks %d", Integer.valueOf(b.size()));
        }
        for (Integer intValue : b) {
            mo25347b(intValue.intValue());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0087, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ae, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f3, code lost:
            return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0180  */
    /* renamed from: a */
    public synchronized void mo25342a(java.lang.String r19, java.lang.String r20, boolean r21, int r22, int r23, int r24, boolean r25, com.kwai.filedownloader.p356d.C4619b r26, boolean r27) {
        /*
        r18 = this;
        r7 = r18
        r0 = r19
        r8 = r20
        r9 = r21
        monitor-enter(r18)
        boolean r1 = com.kwai.filedownloader.p358f.C4660d.f15179a     // Catch:{ all -> 0x01cb }
        r10 = 2
        r11 = 0
        r12 = 1
        if (r1 == 0) goto L_0x0022
        java.lang.String r1 = "request start the task with url(%s) path(%s) isDirectory(%B)"
        r2 = 3
        java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x01cb }
        r2[r11] = r0     // Catch:{ all -> 0x01cb }
        r2[r12] = r8     // Catch:{ all -> 0x01cb }
        java.lang.Boolean r3 = java.lang.Boolean.valueOf(r21)     // Catch:{ all -> 0x01cb }
        r2[r10] = r3     // Catch:{ all -> 0x01cb }
        com.kwai.filedownloader.p358f.C4660d.m19123c(r7, r1, r2)     // Catch:{ all -> 0x01cb }
    L_0x0022:
        int r13 = com.kwai.filedownloader.p358f.C4664f.m19130a(r19, r20, r21)     // Catch:{ all -> 0x01cb }
        com.kwai.filedownloader.b.a r1 = r7.f15283a     // Catch:{ all -> 0x01cb }
        com.kwai.filedownloader.d.c r1 = r1.mo24972b(r13)     // Catch:{ all -> 0x01cb }
        r2 = 0
        if (r9 != 0) goto L_0x006d
        if (r1 != 0) goto L_0x006d
        java.lang.String r1 = com.kwai.filedownloader.p358f.C4664f.m19159h(r20)     // Catch:{ all -> 0x01cb }
        int r1 = com.kwai.filedownloader.p358f.C4664f.m19130a(r0, r1, r12)     // Catch:{ all -> 0x01cb }
        com.kwai.filedownloader.b.a r3 = r7.f15283a     // Catch:{ all -> 0x01cb }
        com.kwai.filedownloader.d.c r3 = r3.mo24972b(r1)     // Catch:{ all -> 0x01cb }
        if (r3 == 0) goto L_0x006a
        java.lang.String r4 = r3.mo25084d()     // Catch:{ all -> 0x01cb }
        boolean r4 = r8.equals(r4)     // Catch:{ all -> 0x01cb }
        if (r4 == 0) goto L_0x006a
        boolean r4 = com.kwai.filedownloader.p358f.C4660d.f15179a     // Catch:{ all -> 0x01cb }
        if (r4 == 0) goto L_0x0062
        java.lang.String r4 = "task[%d] find model by dirCaseId[%d]"
        java.lang.Object[] r5 = new java.lang.Object[r10]     // Catch:{ all -> 0x01cb }
        java.lang.Integer r6 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x01cb }
        r5[r11] = r6     // Catch:{ all -> 0x01cb }
        java.lang.Integer r6 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x01cb }
        r5[r12] = r6     // Catch:{ all -> 0x01cb }
        com.kwai.filedownloader.p358f.C4660d.m19123c(r7, r4, r5)     // Catch:{ all -> 0x01cb }
    L_0x0062:
        com.kwai.filedownloader.b.a r4 = r7.f15283a     // Catch:{ all -> 0x01cb }
        java.util.List r1 = r4.mo24974c(r1)     // Catch:{ all -> 0x01cb }
        r15 = r1
        goto L_0x006b
    L_0x006a:
        r15 = r2
    L_0x006b:
        r14 = r3
        goto L_0x006f
    L_0x006d:
        r14 = r1
        r15 = r2
    L_0x006f:
        boolean r1 = com.kwai.filedownloader.p358f.C4654c.m19108a(r13, r14, r7, r12)     // Catch:{ all -> 0x01cb }
        if (r1 == 0) goto L_0x0088
        boolean r0 = com.kwai.filedownloader.p358f.C4660d.f15179a     // Catch:{ all -> 0x01cb }
        if (r0 == 0) goto L_0x0086
        java.lang.String r0 = "has already started download %d"
        java.lang.Object[] r1 = new java.lang.Object[r12]     // Catch:{ all -> 0x01cb }
        java.lang.Integer r2 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x01cb }
        r1[r11] = r2     // Catch:{ all -> 0x01cb }
        com.kwai.filedownloader.p358f.C4660d.m19123c(r7, r0, r1)     // Catch:{ all -> 0x01cb }
    L_0x0086:
        monitor-exit(r18)
        return
    L_0x0088:
        if (r14 == 0) goto L_0x008f
        java.lang.String r1 = r14.mo25084d()     // Catch:{ all -> 0x01cb }
        goto L_0x0093
    L_0x008f:
        java.lang.String r1 = com.kwai.filedownloader.p358f.C4664f.m19134a(r8, r9, r2)     // Catch:{ all -> 0x01cb }
    L_0x0093:
        r6 = r25
        r5 = r1
        boolean r1 = com.kwai.filedownloader.p358f.C4654c.m19109a(r13, r5, r6, r12)     // Catch:{ all -> 0x01cb }
        if (r1 == 0) goto L_0x00af
        boolean r0 = com.kwai.filedownloader.p358f.C4660d.f15179a     // Catch:{ all -> 0x01cb }
        if (r0 == 0) goto L_0x00ad
        java.lang.String r0 = "has already completed downloading %d"
        java.lang.Object[] r1 = new java.lang.Object[r12]     // Catch:{ all -> 0x01cb }
        java.lang.Integer r2 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x01cb }
        r1[r11] = r2     // Catch:{ all -> 0x01cb }
        com.kwai.filedownloader.p358f.C4660d.m19123c(r7, r0, r1)     // Catch:{ all -> 0x01cb }
    L_0x00ad:
        monitor-exit(r18)
        return
    L_0x00af:
        r2 = 0
        if (r14 == 0) goto L_0x00b8
        long r16 = r14.mo25089g()     // Catch:{ all -> 0x01cb }
        goto L_0x00ba
    L_0x00b8:
        r16 = r2
    L_0x00ba:
        if (r14 == 0) goto L_0x00c1
        java.lang.String r1 = r14.mo25087e()     // Catch:{ all -> 0x01cb }
        goto L_0x00c5
    L_0x00c1:
        java.lang.String r1 = com.kwai.filedownloader.p358f.C4664f.m19153d(r5)     // Catch:{ all -> 0x01cb }
    L_0x00c5:
        r4 = r1
        r1 = r13
        r2 = r16
        r16 = r5
        r6 = r18
        boolean r1 = com.kwai.filedownloader.p358f.C4654c.m19107a(r1, r2, r4, r5, r6)     // Catch:{ all -> 0x01cb }
        if (r1 == 0) goto L_0x00f4
        boolean r0 = com.kwai.filedownloader.p358f.C4660d.f15179a     // Catch:{ all -> 0x01cb }
        if (r0 == 0) goto L_0x00f2
        java.lang.String r0 = "there is an another task with the same target-file-path %d %s"
        java.lang.Object[] r1 = new java.lang.Object[r10]     // Catch:{ all -> 0x01cb }
        java.lang.Integer r2 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x01cb }
        r1[r11] = r2     // Catch:{ all -> 0x01cb }
        r1[r12] = r16     // Catch:{ all -> 0x01cb }
        com.kwai.filedownloader.p358f.C4660d.m19123c(r7, r0, r1)     // Catch:{ all -> 0x01cb }
        if (r14 == 0) goto L_0x00f2
        com.kwai.filedownloader.b.a r0 = r7.f15283a     // Catch:{ all -> 0x01cb }
        r0.mo24977e(r13)     // Catch:{ all -> 0x01cb }
        com.kwai.filedownloader.b.a r0 = r7.f15283a     // Catch:{ all -> 0x01cb }
        r0.mo24976d(r13)     // Catch:{ all -> 0x01cb }
    L_0x00f2:
        monitor-exit(r18)
        return
    L_0x00f4:
        if (r14 == 0) goto L_0x0160
        byte r1 = r14.mo25088f()     // Catch:{ all -> 0x01cb }
        r2 = -2
        if (r1 == r2) goto L_0x0117
        byte r1 = r14.mo25088f()     // Catch:{ all -> 0x01cb }
        r2 = -1
        if (r1 == r2) goto L_0x0117
        byte r1 = r14.mo25088f()     // Catch:{ all -> 0x01cb }
        if (r1 == r12) goto L_0x0117
        byte r1 = r14.mo25088f()     // Catch:{ all -> 0x01cb }
        r2 = 6
        if (r1 == r2) goto L_0x0117
        byte r1 = r14.mo25088f()     // Catch:{ all -> 0x01cb }
        if (r1 != r10) goto L_0x0160
    L_0x0117:
        int r1 = r14.mo25071a()     // Catch:{ all -> 0x01cb }
        if (r1 == r13) goto L_0x0150
        com.kwai.filedownloader.b.a r0 = r7.f15283a     // Catch:{ all -> 0x01cb }
        int r1 = r14.mo25071a()     // Catch:{ all -> 0x01cb }
        r0.mo24977e(r1)     // Catch:{ all -> 0x01cb }
        com.kwai.filedownloader.b.a r0 = r7.f15283a     // Catch:{ all -> 0x01cb }
        int r1 = r14.mo25071a()     // Catch:{ all -> 0x01cb }
        r0.mo24976d(r1)     // Catch:{ all -> 0x01cb }
        r14.mo25073a(r13)     // Catch:{ all -> 0x01cb }
        r14.mo25076a(r8, r9)     // Catch:{ all -> 0x01cb }
        if (r15 == 0) goto L_0x017e
        java.util.Iterator r0 = r15.iterator()     // Catch:{ all -> 0x01cb }
    L_0x013b:
        boolean r1 = r0.hasNext()     // Catch:{ all -> 0x01cb }
        if (r1 == 0) goto L_0x017e
        java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x01cb }
        com.kwai.filedownloader.d.a r1 = (com.kwai.filedownloader.p356d.C4618a) r1     // Catch:{ all -> 0x01cb }
        r1.mo25050a(r13)     // Catch:{ all -> 0x01cb }
        com.kwai.filedownloader.b.a r2 = r7.f15283a     // Catch:{ all -> 0x01cb }
        r2.mo24969a(r1)     // Catch:{ all -> 0x01cb }
        goto L_0x013b
    L_0x0150:
        java.lang.String r1 = r14.mo25077b()     // Catch:{ all -> 0x01cb }
        boolean r1 = android.text.TextUtils.equals(r0, r1)     // Catch:{ all -> 0x01cb }
        if (r1 != 0) goto L_0x015e
        r14.mo25075a(r0)     // Catch:{ all -> 0x01cb }
        goto L_0x017e
    L_0x015e:
        r12 = 0
        goto L_0x017e
    L_0x0160:
        if (r14 != 0) goto L_0x0167
        com.kwai.filedownloader.d.c r14 = new com.kwai.filedownloader.d.c     // Catch:{ all -> 0x01cb }
        r14.m48649init()     // Catch:{ all -> 0x01cb }
    L_0x0167:
        r14.mo25075a(r0)     // Catch:{ all -> 0x01cb }
        r14.mo25076a(r8, r9)     // Catch:{ all -> 0x01cb }
        r14.mo25073a(r13)     // Catch:{ all -> 0x01cb }
        r0 = 0
        r14.mo25074a(r0)     // Catch:{ all -> 0x01cb }
        r14.mo25082c(r0)     // Catch:{ all -> 0x01cb }
        r14.mo25072a(r12)     // Catch:{ all -> 0x01cb }
        r14.mo25078b(r12)     // Catch:{ all -> 0x01cb }
    L_0x017e:
        if (r12 == 0) goto L_0x0185
        com.kwai.filedownloader.b.a r0 = r7.f15283a     // Catch:{ all -> 0x01cb }
        r0.mo24970a(r14)     // Catch:{ all -> 0x01cb }
    L_0x0185:
        com.kwai.filedownloader.download.DownloadLaunchRunnable$a r0 = new com.kwai.filedownloader.download.DownloadLaunchRunnable$a     // Catch:{ all -> 0x01cb }
        r0.m48661init()     // Catch:{ all -> 0x01cb }
        com.kwai.filedownloader.download.DownloadLaunchRunnable$a r0 = r0.mo25130a(r14)     // Catch:{ all -> 0x01cb }
        r1 = r26
        com.kwai.filedownloader.download.DownloadLaunchRunnable$a r0 = r0.mo25129a(r1)     // Catch:{ all -> 0x01cb }
        com.kwai.filedownloader.download.DownloadLaunchRunnable$a r0 = r0.mo25131a(r7)     // Catch:{ all -> 0x01cb }
        java.lang.Integer r1 = java.lang.Integer.valueOf(r23)     // Catch:{ all -> 0x01cb }
        com.kwai.filedownloader.download.DownloadLaunchRunnable$a r0 = r0.mo25133a(r1)     // Catch:{ all -> 0x01cb }
        java.lang.Integer r1 = java.lang.Integer.valueOf(r22)     // Catch:{ all -> 0x01cb }
        com.kwai.filedownloader.download.DownloadLaunchRunnable$a r0 = r0.mo25136b(r1)     // Catch:{ all -> 0x01cb }
        java.lang.Boolean r1 = java.lang.Boolean.valueOf(r25)     // Catch:{ all -> 0x01cb }
        com.kwai.filedownloader.download.DownloadLaunchRunnable$a r0 = r0.mo25132a(r1)     // Catch:{ all -> 0x01cb }
        java.lang.Boolean r1 = java.lang.Boolean.valueOf(r27)     // Catch:{ all -> 0x01cb }
        com.kwai.filedownloader.download.DownloadLaunchRunnable$a r0 = r0.mo25135b(r1)     // Catch:{ all -> 0x01cb }
        java.lang.Integer r1 = java.lang.Integer.valueOf(r24)     // Catch:{ all -> 0x01cb }
        com.kwai.filedownloader.download.DownloadLaunchRunnable$a r0 = r0.mo25137c(r1)     // Catch:{ all -> 0x01cb }
        com.kwai.filedownloader.download.DownloadLaunchRunnable r0 = r0.mo25134a()     // Catch:{ all -> 0x01cb }
        com.kwai.filedownloader.services.h r1 = r7.f15284b     // Catch:{ all -> 0x01cb }
        r1.mo25356a(r0)     // Catch:{ all -> 0x01cb }
        monitor-exit(r18)
        return
    L_0x01cb:
        r0 = move-exception
        monitor-exit(r18)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.services.C4737g.mo25342a(java.lang.String, java.lang.String, boolean, int, int, int, boolean, com.kwai.filedownloader.d.b, boolean):void");
    }

    /* renamed from: a */
    public boolean mo25343a(int i) {
        return mo25344a(this.f15283a.mo24972b(i));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
            if (r1 != false) goto L_0x001e;
     */
    /* renamed from: a */
    public boolean mo25344a(com.kwai.filedownloader.p356d.C4621c r5) {
        /*
        r4 = this;
        r0 = 0
        if (r5 != 0) goto L_0x0004
        return r0
    L_0x0004:
        com.kwai.filedownloader.services.h r1 = r4.f15284b
        int r2 = r5.mo25071a()
        boolean r1 = r1.mo25360c(r2)
        byte r2 = r5.mo25088f()
        boolean r2 = com.kwai.filedownloader.p356d.C4623d.m18946a(r2)
        r3 = 1
        if (r2 == 0) goto L_0x001c
        if (r1 == 0) goto L_0x003c
        goto L_0x001e
    L_0x001c:
        if (r1 == 0) goto L_0x0020
    L_0x001e:
        r0 = 1
        goto L_0x003c
    L_0x0020:
        r1 = 2
        java.lang.Object[] r1 = new java.lang.Object[r1]
        int r2 = r5.mo25071a()
        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        r1[r0] = r2
        byte r5 = r5.mo25088f()
        java.lang.Byte r5 = java.lang.Byte.valueOf(r5)
        r1[r3] = r5
        java.lang.String r5 = "%d status is[%s](not finish) & but not in the pool"
        com.kwai.filedownloader.p358f.C4660d.m19120a(r4, r5, r1)
    L_0x003c:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.services.C4737g.mo25344a(com.kwai.filedownloader.d.c):boolean");
    }

    /* renamed from: a */
    public boolean mo25345a(String str, String str2) {
        return mo25343a(C4664f.m19144b(str, str2));
    }

    /* renamed from: b */
    public boolean mo25346b() {
        return this.f15284b.mo25354a() <= 0;
    }

    /* renamed from: b */
    public boolean mo25347b(int i) {
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "request pause the task %d", Integer.valueOf(i));
        }
        C4621c b = this.f15283a.mo24972b(i);
        if (b == null) {
            return false;
        }
        b.mo25072a(-2);
        this.f15284b.mo25359b(i);
        return true;
    }

    /* renamed from: c */
    public long mo25348c(int i) {
        C4621c b = this.f15283a.mo24972b(i);
        if (b == null) {
            return 0;
        }
        int n = b.mo25096n();
        if (n <= 1) {
            return b.mo25089g();
        }
        List c = this.f15283a.mo24974c(i);
        if (c == null || c.size() != n) {
            return 0;
        }
        return C4618a.m18899a(c);
    }

    /* renamed from: c */
    public void mo25349c() {
        this.f15283a.mo24960a();
    }

    /* renamed from: d */
    public long mo25350d(int i) {
        C4621c b = this.f15283a.mo24972b(i);
        if (b == null) {
            return 0;
        }
        return b.mo25090h();
    }

    /* renamed from: e */
    public byte mo25351e(int i) {
        C4621c b = this.f15283a.mo24972b(i);
        if (b == null) {
            return 0;
        }
        return b.mo25088f();
    }

    /* renamed from: f */
    public synchronized boolean mo25352f(int i) {
        return this.f15284b.mo25357a(i);
    }

    /* renamed from: g */
    public boolean mo25353g(int i) {
        if (i == 0) {
            C4660d.m19124d(this, "The task[%d] id is invalid, can't clear it.", Integer.valueOf(i));
            return false;
        } else if (mo25343a(i)) {
            C4660d.m19124d(this, "The task[%d] is downloading, can't clear it.", Integer.valueOf(i));
            return false;
        } else {
            this.f15283a.mo24977e(i);
            this.f15283a.mo24976d(i);
            return true;
        }
    }
}
