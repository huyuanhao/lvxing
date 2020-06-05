package com.p530ss.android.socialbase.downloader.p568l;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.support.p000v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.downloader.DownloadResponseHandler;
import com.p530ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.p530ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator;
import com.p530ss.android.socialbase.downloader.downloader.IChunkCntCalculator;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.p530ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;
import com.p530ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.p530ss.android.socialbase.downloader.impls.DefaultDownloadEngine;
import com.p530ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.p530ss.android.socialbase.downloader.impls.RetryDelayTimeParamCalculator;
import com.p530ss.android.socialbase.downloader.impls.RetryScheduler;
import com.p530ss.android.socialbase.downloader.p557b.ByteInvalidRetryStatus;
import com.p530ss.android.socialbase.downloader.p557b.RetryDelayStatus;
import com.p530ss.android.socialbase.downloader.p557b.RunStatus;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadDiskSpaceHandler;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadForbiddenHandler;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadInterceptor;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadMonitorDepend;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p560e.DownloadHttpException;
import com.p530ss.android.socialbase.downloader.p560e.DownloadOnlyWifiException;
import com.p530ss.android.socialbase.downloader.p560e.DownloadOutOfSpaceException;
import com.p530ss.android.socialbase.downloader.p560e.DownloadRetryNeedlessException;
import com.p530ss.android.socialbase.downloader.p560e.RetryCheckStatus;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p562g.C6712d;
import com.p530ss.android.socialbase.downloader.p562g.DownloadChunk;
import com.p530ss.android.socialbase.downloader.p562g.DownloadChunk.C6709a;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p562g.HttpHeader;
import com.p530ss.android.socialbase.downloader.p563h.DownloadMonitorHelper;
import com.p530ss.android.socialbase.downloader.p564i.DeviceBandwidthSampler;
import com.p530ss.android.socialbase.downloader.p564i.IDownloadHeadHttpConnection;
import com.p530ss.android.socialbase.downloader.p564i.IDownloadHttpConnection;
import com.p530ss.android.socialbase.downloader.p564i.p565a.DownloadConnectionPool;
import com.p530ss.android.socialbase.downloader.p564i.p565a.FakeDownloadHttpConnection;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import com.p530ss.android.socialbase.downloader.p569m.DownloadExpSwitchCode;
import com.p530ss.android.socialbase.downloader.p569m.DownloadHttpUtils;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import com.tencent.mid.core.Constants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLHandshakeException;

/* renamed from: com.ss.android.socialbase.downloader.l.c */
public class DownloadRunnable implements IDownloadRunnableCallback, Runnable {
    /* renamed from: a */
    private static final String f22318a = DownloadRunnable.class.getSimpleName();
    /* renamed from: A */
    private IDownloadForbiddenHandler f22319A;
    /* renamed from: B */
    private IDownloadDiskSpaceHandler f22320B;
    /* renamed from: C */
    private volatile int f22321C = 5;
    /* renamed from: D */
    private boolean f22322D = false;
    /* renamed from: E */
    private boolean f22323E = false;
    /* renamed from: F */
    private String f22324F;
    /* renamed from: G */
    private long f22325G;
    /* renamed from: b */
    private Future f22326b;
    /* renamed from: c */
    private final C6712d f22327c;
    /* renamed from: d */
    private volatile boolean f22328d = false;
    /* renamed from: e */
    private AtomicInteger f22329e;
    /* renamed from: f */
    private final ArrayList<DownloadChunkRunnable> f22330f = new ArrayList<>();
    /* renamed from: g */
    private volatile DownloadResponseHandler f22331g;
    /* renamed from: h */
    private boolean f22332h;
    /* renamed from: i */
    private boolean f22333i;
    /* renamed from: j */
    private boolean f22334j;
    /* renamed from: k */
    private boolean f22335k;
    /* renamed from: l */
    private boolean f22336l;
    /* renamed from: m */
    private final AtomicBoolean f22337m;
    /* renamed from: n */
    private volatile RunStatus f22338n = RunStatus.RUN_STATUS_NONE;
    /* renamed from: o */
    private final IDownloadCache f22339o;
    /* renamed from: p */
    private DownloadInfo f22340p;
    /* renamed from: q */
    private IChunkCntCalculator f22341q;
    /* renamed from: r */
    private final IChunkCntCalculator f22342r;
    /* renamed from: s */
    private IChunkAdjustCalculator f22343s;
    /* renamed from: t */
    private final IChunkAdjustCalculator f22344t;
    /* renamed from: u */
    private IRetryDelayTimeCalculator f22345u;
    /* renamed from: v */
    private final DownloadStatusHandler f22346v;
    /* renamed from: w */
    private AlarmManager f22347w;
    /* renamed from: x */
    private volatile BaseException f22348x;
    /* renamed from: y */
    private IDownloadHttpConnection f22349y;
    /* renamed from: z */
    private IDownloadHeadHttpConnection f22350z;

    /* compiled from: DownloadRunnable */
    /* renamed from: com.ss.android.socialbase.downloader.l.c$a */
    private class C6748a extends Throwable {
        /* renamed from: b */
        private String f22355b;

        public C6748a(String str) {
            super(str);
            this.f22355b = str;
        }

        /* renamed from: a */
        public String mo32581a() {
            return this.f22355b;
        }
    }

    public DownloadRunnable(C6712d dVar, Handler handler) {
        this.f22327c = dVar;
        if (dVar != null) {
            this.f22340p = dVar.mo32357a();
            this.f22341q = dVar.mo32404f();
            this.f22343s = dVar.mo32428q();
            this.f22319A = dVar.mo32410h();
            this.f22320B = dVar.mo32413i();
            this.f22345u = m28649a(dVar);
        }
        m28666h();
        this.f22339o = C6694b.m27384p();
        this.f22342r = C6694b.m27392x();
        this.f22344t = C6694b.m27394z();
        this.f22346v = new DownloadStatusHandler(dVar, handler);
        this.f22347w = C6694b.m27376h();
        this.f22337m = new AtomicBoolean(true);
    }

    /* renamed from: h */
    private void m28666h() {
        DownloadInfo cVar = this.f22340p;
        if (cVar != null) {
            int D = cVar.mo32158D() - this.f22340p.mo32235al();
            if (D < 0) {
                D = 0;
            }
            AtomicInteger atomicInteger = this.f22329e;
            if (atomicInteger == null) {
                this.f22329e = new AtomicInteger(D);
            } else {
                atomicInteger.set(D);
            }
        }
    }

    /* renamed from: a */
    public void mo32565a() {
        this.f22338n = RunStatus.RUN_STATUS_PAUSE;
        if (this.f22331g != null) {
            this.f22331g.mo31891b();
        } else {
            m28673o();
            this.f22338n = RunStatus.RUN_STATUS_PAUSE;
            m28670l();
        }
        try {
            Iterator it = ((ArrayList) this.f22330f.clone()).iterator();
            while (it.hasNext()) {
                DownloadChunkRunnable bVar = (DownloadChunkRunnable) it.next();
                if (bVar != null) {
                    bVar.mo32558a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public void mo32572b() {
        this.f22338n = RunStatus.RUN_STATUS_CANCELED;
        if (this.f22331g != null) {
            this.f22331g.mo31892c();
        } else {
            m28673o();
            this.f22338n = RunStatus.RUN_STATUS_CANCELED;
            m28670l();
        }
        m28645E();
    }

    /* renamed from: c */
    public C6712d mo32574c() {
        return this.f22327c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005c, code lost:
            if (r9 <= 0) goto L_0x005e;
     */
    /* renamed from: a */
    private int m28648a(long r7, java.util.List<com.p530ss.android.socialbase.downloader.p562g.DownloadChunk> r9) {
        /*
        r6 = this;
        boolean r0 = r6.m28683y()
        r1 = 0
        r2 = 1
        if (r0 == 0) goto L_0x005e
        boolean r0 = r6.f22333i
        if (r0 == 0) goto L_0x001a
        if (r9 == 0) goto L_0x0013
        int r9 = r9.size()
        goto L_0x005c
    L_0x0013:
        com.ss.android.socialbase.downloader.g.c r9 = r6.f22340p
        int r9 = r9.mo32219aV()
        goto L_0x005c
    L_0x001a:
        com.ss.android.socialbase.downloader.downloader.i r9 = r6.f22341q
        if (r9 == 0) goto L_0x0023
        int r9 = r9.mo31302a(r7)
        goto L_0x0029
    L_0x0023:
        com.ss.android.socialbase.downloader.downloader.i r9 = r6.f22342r
        int r9 = r9.mo31302a(r7)
    L_0x0029:
        com.ss.android.socialbase.downloader.i.g r0 = com.p530ss.android.socialbase.downloader.p564i.NetTrafficManager.m28219a()
        com.ss.android.socialbase.downloader.i.h r0 = r0.mo32470b()
        java.lang.String r3 = f22318a
        java.lang.Object[] r4 = new java.lang.Object[r2]
        java.lang.String r5 = r0.name()
        r4[r1] = r5
        java.lang.String r5 = "NetworkQuality is : %s"
        java.lang.String r4 = java.lang.String.format(r5, r4)
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27758b(r3, r4)
        com.ss.android.socialbase.downloader.g.c r3 = r6.f22340p
        java.lang.String r4 = r0.name()
        r3.mo32276e(r4)
        com.ss.android.socialbase.downloader.downloader.h r3 = r6.f22343s
        if (r3 == 0) goto L_0x0056
        int r9 = r3.mo31305a(r9, r0)
        goto L_0x005c
    L_0x0056:
        com.ss.android.socialbase.downloader.downloader.h r3 = r6.f22344t
        int r9 = r3.mo31305a(r9, r0)
    L_0x005c:
        if (r9 > 0) goto L_0x005f
    L_0x005e:
        r9 = 1
    L_0x005f:
        boolean r0 = com.p530ss.android.socialbase.downloader.p561f.C6704a.m27756a()
        if (r0 == 0) goto L_0x0088
        java.lang.String r0 = f22318a
        r3 = 3
        java.lang.Object[] r3 = new java.lang.Object[r3]
        java.lang.String r4 = java.lang.String.valueOf(r9)
        r3[r1] = r4
        com.ss.android.socialbase.downloader.g.c r1 = r6.f22340p
        java.lang.String r1 = r1.mo32287h()
        r3[r2] = r1
        r1 = 2
        java.lang.String r7 = java.lang.String.valueOf(r7)
        r3[r1] = r7
        java.lang.String r7 = "chunk count : %s for %s contentLen:%s"
        java.lang.String r7 = java.lang.String.format(r7, r3)
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27758b(r0, r7)
    L_0x0088:
        return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.p568l.DownloadRunnable.m28648a(long, java.util.List):int");
    }

    /* renamed from: i */
    private boolean m28667i() {
        int q = this.f22340p.mo32308q();
        if (q == 1 || this.f22340p.mo32242as()) {
            return true;
        }
        if (!(q == -2 || q == -4)) {
            StringBuilder sb = new StringBuilder();
            sb.append("The download Task can't start, because its status is not prepare:");
            sb.append(q);
            mo32573b(new BaseException(1000, sb.toString()));
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x007b A[SYNTHETIC, Splitter:B:34:0x007b] */
    /* renamed from: j */
    private void m28668j() throws com.p530ss.android.socialbase.downloader.p560e.DownloadFileExistException {
        /*
        r6 = this;
        com.ss.android.socialbase.downloader.g.c r0 = r6.f22340p     // Catch:{ b -> 0x00b1, all -> 0x008b }
        int r0 = r0.mo32283g()     // Catch:{ b -> 0x00b1, all -> 0x008b }
        com.ss.android.socialbase.downloader.downloader.k r1 = r6.f22339o     // Catch:{ b -> 0x00b1, all -> 0x008b }
        if (r1 == 0) goto L_0x0087
        r1 = 2048(0x800, float:2.87E-42)
        boolean r1 = com.p530ss.android.socialbase.downloader.p569m.DownloadExpSwitchCode.m28744a(r1)     // Catch:{ b -> 0x00b1, all -> 0x008b }
        if (r1 == 0) goto L_0x0017
        com.ss.android.socialbase.downloader.downloader.k r1 = r6.f22339o     // Catch:{ b -> 0x00b1, all -> 0x008b }
        r1.mo31691d()     // Catch:{ b -> 0x00b1, all -> 0x008b }
    L_0x0017:
        com.ss.android.socialbase.downloader.downloader.k r1 = r6.f22339o     // Catch:{ b -> 0x00b1, all -> 0x008b }
        com.ss.android.socialbase.downloader.g.c r1 = r1.mo31677b(r0)     // Catch:{ b -> 0x00b1, all -> 0x008b }
        r2 = 1
        if (r1 == 0) goto L_0x0074
        boolean r3 = r1.mo32218aU()     // Catch:{ b -> 0x00b1, all -> 0x008b }
        if (r3 == 0) goto L_0x0027
        goto L_0x0074
    L_0x0027:
        com.ss.android.socialbase.downloader.g.c r3 = r6.f22340p     // Catch:{ b -> 0x00b1, all -> 0x008b }
        java.lang.String r3 = r3.mo32297k()     // Catch:{ b -> 0x00b1, all -> 0x008b }
        com.ss.android.socialbase.downloader.g.c r4 = r6.f22340p     // Catch:{ b -> 0x00b1, all -> 0x008b }
        java.lang.String r4 = r4.mo32155A()     // Catch:{ b -> 0x00b1, all -> 0x008b }
        com.ss.android.socialbase.downloader.g.c r5 = r6.f22340p     // Catch:{ b -> 0x00b1, all -> 0x008b }
        r5.mo32191a(r1, r2)     // Catch:{ b -> 0x00b1, all -> 0x008b }
        java.lang.String r5 = r1.mo32297k()     // Catch:{ b -> 0x00b1, all -> 0x008b }
        boolean r3 = r3.equals(r5)     // Catch:{ b -> 0x00b1, all -> 0x008b }
        r5 = 0
        if (r3 == 0) goto L_0x0054
        boolean r3 = com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28777a(r1, r5, r4)     // Catch:{ b -> 0x00b1, all -> 0x008b }
        if (r3 != 0) goto L_0x004a
        goto L_0x0054
    L_0x004a:
        com.ss.android.socialbase.downloader.e.b r0 = new com.ss.android.socialbase.downloader.e.b     // Catch:{ b -> 0x00b1, all -> 0x008b }
        java.lang.String r1 = r1.mo32287h()     // Catch:{ b -> 0x00b1, all -> 0x008b }
        r0.m51547init(r1)     // Catch:{ b -> 0x00b1, all -> 0x008b }
        throw r0     // Catch:{ b -> 0x00b1, all -> 0x008b }
    L_0x0054:
        int r3 = com.p530ss.android.socialbase.downloader.downloader.C6694b.m27347a(r1)     // Catch:{ b -> 0x00b1, all -> 0x008b }
        if (r3 == r0) goto L_0x0065
        com.ss.android.socialbase.downloader.downloader.k r3 = r6.f22339o     // Catch:{ SQLiteException -> 0x0060 }
        r3.mo31694f(r0)     // Catch:{ SQLiteException -> 0x0060 }
        goto L_0x0064
    L_0x0060:
        r0 = move-exception
        r0.printStackTrace()     // Catch:{ b -> 0x00b1, all -> 0x008b }
    L_0x0064:
        r5 = 1
    L_0x0065:
        r0 = 4096(0x1000, float:5.74E-42)
        boolean r0 = com.p530ss.android.socialbase.downloader.p569m.DownloadExpSwitchCode.m28744a(r0)     // Catch:{ b -> 0x00b1, all -> 0x008b }
        if (r0 == 0) goto L_0x0072
        com.ss.android.socialbase.downloader.g.c r0 = r6.f22340p     // Catch:{ b -> 0x00b1, all -> 0x008b }
        if (r1 == r0) goto L_0x0072
        goto L_0x0079
    L_0x0072:
        r2 = r5
        goto L_0x0079
    L_0x0074:
        com.ss.android.socialbase.downloader.g.c r0 = r6.f22340p     // Catch:{ b -> 0x00b1, all -> 0x008b }
        r0.mo32210aM()     // Catch:{ b -> 0x00b1, all -> 0x008b }
    L_0x0079:
        if (r2 == 0) goto L_0x0087
        com.ss.android.socialbase.downloader.downloader.k r0 = r6.f22339o     // Catch:{ SQLiteException -> 0x0083 }
        com.ss.android.socialbase.downloader.g.c r1 = r6.f22340p     // Catch:{ SQLiteException -> 0x0083 }
        r0.mo31676a(r1)     // Catch:{ SQLiteException -> 0x0083 }
        goto L_0x0087
    L_0x0083:
        r0 = move-exception
        r0.printStackTrace()     // Catch:{ b -> 0x00b1, all -> 0x008b }
    L_0x0087:
        r6.m28666h()     // Catch:{ b -> 0x00b1, all -> 0x008b }
        goto L_0x00b0
    L_0x008b:
        r0 = move-exception
        com.ss.android.socialbase.downloader.g.d r1 = r6.f22327c
        if (r1 == 0) goto L_0x00b0
        com.ss.android.socialbase.downloader.g.c r2 = r6.f22340p
        if (r2 == 0) goto L_0x00b0
        com.ss.android.socialbase.downloader.d.ae r1 = r1.mo32401e()
        com.ss.android.socialbase.downloader.g.c r2 = r6.f22340p
        com.ss.android.socialbase.downloader.e.a r3 = new com.ss.android.socialbase.downloader.e.a
        r4 = 1003(0x3eb, float:1.406E-42)
        java.lang.String r5 = "checkTaskCache"
        java.lang.String r0 = com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28786b(r0, r5)
        r3.m51543init(r4, r0)
        com.ss.android.socialbase.downloader.g.c r0 = r6.f22340p
        int r0 = r0.mo32308q()
        com.p530ss.android.socialbase.downloader.p563h.DownloadMonitorHelper.m28177a(r1, r2, r3, r0)
    L_0x00b0:
        return
    L_0x00b1:
        r0 = move-exception
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.p568l.DownloadRunnable.m28668j():void");
    }

    public void run() {
        Process.setThreadPriority(10);
        try {
            IDownloadInterceptor c = this.f22327c.mo32391c();
            if (c != null && c.mo31732a()) {
                this.f22346v.mo31906e();
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!m28667i()) {
            IDownloadMonitorDepend e = this.f22327c.mo32401e();
            DownloadInfo cVar = this.f22340p;
            BaseException aVar = new BaseException((int) PointerIconCompat.TYPE_HELP, "task status is invalid");
            DownloadInfo cVar2 = this.f22340p;
            DownloadMonitorHelper.m28177a(e, cVar, aVar, cVar2 != null ? cVar2.mo32308q() : 0);
            return;
        }
        while (true) {
            m28669k();
            if (!this.f22322D) {
                break;
            } else if (this.f22321C > 0) {
                this.f22321C--;
            } else if (this.f22340p.mo32180Z() != this.f22340p.mo32225ab()) {
                C6704a.m27758b(f22318a, this.f22340p.mo32268d());
                DownloadStatusHandler eVar = this.f22346v;
                StringBuilder sb = new StringBuilder();
                sb.append("current bytes is not equals to total bytes, bytes invalid retry status is : ");
                sb.append(this.f22340p.mo32224aa());
                eVar.mo31898a((BaseException) new DownloadRetryNeedlessException(1027, sb.toString()));
                break;
            } else if (this.f22340p.mo32180Z() <= 0) {
                C6704a.m27758b(f22318a, this.f22340p.mo32268d());
                DownloadStatusHandler eVar2 = this.f22346v;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("curBytes is 0, bytes invalid retry status is : ");
                sb2.append(this.f22340p.mo32224aa());
                eVar2.mo31898a((BaseException) new DownloadRetryNeedlessException(1026, sb2.toString()));
                break;
            } else if (this.f22340p.mo32225ab() <= 0) {
                C6704a.m27758b(f22318a, this.f22340p.mo32268d());
                DownloadStatusHandler eVar3 = this.f22346v;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("TotalBytes is 0, bytes invalid retry status is : ");
                sb3.append(this.f22340p.mo32224aa());
                eVar3.mo31898a((BaseException) new DownloadRetryNeedlessException(1044, sb3.toString()));
                break;
            }
        }
        return;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:64|65|66|67) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:66:0x0115 */
    /* renamed from: k */
    private void m28669k() {
        /*
        r12 = this;
        com.ss.android.socialbase.downloader.b.k r0 = com.p530ss.android.socialbase.downloader.p557b.RunStatus.RUN_STATUS_NONE     // Catch:{ all -> 0x02e7 }
        r12.f22338n = r0     // Catch:{ all -> 0x02e7 }
        com.ss.android.socialbase.downloader.g.c r0 = r12.f22340p     // Catch:{ all -> 0x02e7 }
        r0.mo32166L()     // Catch:{ all -> 0x02e7 }
        com.ss.android.socialbase.downloader.g.c r0 = r12.f22340p     // Catch:{ all -> 0x02e7 }
        r0.mo32172R()     // Catch:{ all -> 0x02e7 }
        r0 = 0
        r1 = 1
        r12.m28668j()     // Catch:{ b -> 0x0015 }
        r2 = 0
        goto L_0x0037
    L_0x0015:
        r2 = move-exception
        java.lang.String r3 = f22318a     // Catch:{ all -> 0x02e7 }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x02e7 }
        r4.<init>()     // Catch:{ all -> 0x02e7 }
        java.lang.String r5 = "file exist "
        r4.append(r5)     // Catch:{ all -> 0x02e7 }
        java.lang.String r5 = r2.mo32084c()     // Catch:{ all -> 0x02e7 }
        r4.append(r5)     // Catch:{ all -> 0x02e7 }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x02e7 }
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27758b(r3, r4)     // Catch:{ all -> 0x02e7 }
        java.lang.String r2 = r2.mo32084c()     // Catch:{ all -> 0x02e7 }
        r12.f22324F = r2     // Catch:{ all -> 0x02e7 }
        r2 = 1
    L_0x0037:
        boolean r3 = r12.f22322D     // Catch:{ all -> 0x02e7 }
        if (r3 != 0) goto L_0x0040
        com.ss.android.socialbase.downloader.downloader.e r3 = r12.f22346v     // Catch:{ all -> 0x02e7 }
        r3.mo31903b()     // Catch:{ all -> 0x02e7 }
    L_0x0040:
        r12.f22322D = r0     // Catch:{ all -> 0x02e7 }
        boolean r3 = r12.m28676r()     // Catch:{ all -> 0x02e7 }
        if (r3 == 0) goto L_0x004c
        r12.m28670l()
        return
    L_0x004c:
        java.lang.String r3 = r12.f22324F     // Catch:{ all -> 0x02e7 }
        boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x02e7 }
        if (r3 != 0) goto L_0x0071
        if (r2 == 0) goto L_0x0071
        java.lang.String r0 = r12.f22324F     // Catch:{ all -> 0x02e7 }
        com.ss.android.socialbase.downloader.g.c r1 = r12.f22340p     // Catch:{ all -> 0x02e7 }
        java.lang.String r1 = r1.mo32305n()     // Catch:{ all -> 0x02e7 }
        boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x02e7 }
        if (r0 == 0) goto L_0x0069
        com.ss.android.socialbase.downloader.b.k r0 = com.p530ss.android.socialbase.downloader.p557b.RunStatus.RUN_STATUS_END_RIGHT_NOW     // Catch:{ all -> 0x02e7 }
        r12.f22338n = r0     // Catch:{ all -> 0x02e7 }
        goto L_0x006d
    L_0x0069:
        com.ss.android.socialbase.downloader.b.k r0 = com.p530ss.android.socialbase.downloader.p557b.RunStatus.RUN_STATUS_END_FOR_FILE_EXIST     // Catch:{ all -> 0x02e7 }
        r12.f22338n = r0     // Catch:{ all -> 0x02e7 }
    L_0x006d:
        r12.m28670l()
        return
    L_0x0071:
        com.ss.android.socialbase.downloader.i.a r2 = com.p530ss.android.socialbase.downloader.p564i.DeviceBandwidthSampler.m28179a()     // Catch:{ all -> 0x02e7 }
        r2.mo32446b()     // Catch:{ all -> 0x02e7 }
    L_0x0078:
        boolean r2 = r12.m28676r()     // Catch:{ all -> 0x02e7 }
        if (r2 == 0) goto L_0x0082
        r12.m28670l()
        return
    L_0x0082:
        r2 = 0
        r12.m28642B()     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        r12.m28682x()     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        r12.m28641A()     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        com.ss.android.socialbase.downloader.downloader.k r4 = r12.f22339o     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        com.ss.android.socialbase.downloader.g.c r5 = r12.f22340p     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        int r5 = r5.mo32283g()     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        java.util.List r4 = r4.mo31685c(r5)     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        r12.m28643C()     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        com.ss.android.socialbase.downloader.g.c r5 = r12.f22340p     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        java.lang.String r5 = r5.mo32163I()     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        boolean r6 = r12.m28676r()     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        if (r6 == 0) goto L_0x00af
        r12.m28673o()     // Catch:{ all -> 0x02e7 }
        r12.m28670l()
        return
    L_0x00af:
        boolean r6 = r12.f22333i     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        if (r6 == 0) goto L_0x00ba
        com.ss.android.socialbase.downloader.g.c r6 = r12.f22340p     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        long r6 = com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28805d(r6)     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        goto L_0x00bb
    L_0x00ba:
        r6 = r2
    L_0x00bb:
        com.ss.android.socialbase.downloader.g.b r8 = r12.m28664b(r6)     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        java.util.List r9 = r12.m28651a(r8)     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        com.ss.android.socialbase.downloader.g.c r10 = r12.f22340p     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        r10.mo32301l(r0)     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        com.ss.android.socialbase.downloader.g.c r10 = r12.f22340p     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        int r10 = r10.mo32219aV()     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        if (r10 != r1) goto L_0x00e1
        com.ss.android.socialbase.downloader.i.a.a r10 = com.p530ss.android.socialbase.downloader.p564i.p565a.DownloadConnectionPool.m28187a()     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        com.ss.android.socialbase.downloader.i.a.c r10 = r10.mo32453a(r5, r9)     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        if (r10 == 0) goto L_0x00e1
        r12.f22350z = r10     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        com.ss.android.socialbase.downloader.g.c r10 = r12.f22340p     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        r10.mo32301l(r1)     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
    L_0x00e1:
        com.ss.android.socialbase.downloader.i.c r10 = r12.f22350z     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        if (r10 != 0) goto L_0x0102
        boolean r10 = r12.f22323E     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        if (r10 != 0) goto L_0x0102
        com.ss.android.socialbase.downloader.g.c r10 = r12.f22340p     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        boolean r10 = r10.mo32175U()     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        if (r10 == 0) goto L_0x0102
        com.ss.android.socialbase.downloader.i.c r10 = com.p530ss.android.socialbase.downloader.downloader.C6694b.m27349a(r5, r9)     // Catch:{ all -> 0x00f8 }
        r12.f22350z = r10     // Catch:{ all -> 0x00f8 }
        goto L_0x0102
    L_0x00f8:
        r10 = move-exception
        com.ss.android.socialbase.downloader.g.c r11 = r12.f22340p     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        java.lang.String r10 = com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28820i(r10)     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        r11.mo32192a(r10)     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
    L_0x0102:
        com.ss.android.socialbase.downloader.i.c r10 = r12.f22350z     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        if (r10 != 0) goto L_0x010f
        r12.m28660a(r5, r9)     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        com.ss.android.socialbase.downloader.i.e r10 = r12.f22349y     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        r12.m28656a(r10, r6)     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        goto L_0x011f
    L_0x010f:
        com.ss.android.socialbase.downloader.i.c r10 = r12.f22350z     // Catch:{ all -> 0x0115 }
        r12.m28656a(r10, r6)     // Catch:{ all -> 0x0115 }
        goto L_0x011f
    L_0x0115:
        r12.f22323E = r1     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        r12.m28660a(r5, r9)     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        com.ss.android.socialbase.downloader.i.e r10 = r12.f22349y     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        r12.m28656a(r10, r6)     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
    L_0x011f:
        boolean r6 = r12.m28676r()     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        if (r6 == 0) goto L_0x012c
        r12.m28673o()     // Catch:{ all -> 0x02e7 }
        r12.m28670l()
        return
    L_0x012c:
        com.ss.android.socialbase.downloader.g.c r6 = r12.f22340p     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        long r6 = r6.mo32225ab()     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        com.ss.android.socialbase.downloader.g.c r10 = r12.f22340p     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        java.lang.String r10 = r10.mo32300l()     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        com.ss.android.socialbase.downloader.g.c r11 = r12.f22340p     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        java.lang.String r11 = r11.mo32303m()     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        r12.m28654a(r6, r10, r11)     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        int r10 = r12.m28648a(r6, r4)     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        boolean r11 = r12.m28676r()     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        if (r11 == 0) goto L_0x0152
        r12.m28673o()     // Catch:{ all -> 0x02e7 }
        r12.m28670l()
        return
    L_0x0152:
        if (r10 <= 0) goto L_0x019d
        if (r10 != r1) goto L_0x0158
        r11 = 1
        goto L_0x0159
    L_0x0158:
        r11 = 0
    L_0x0159:
        r12.f22332h = r11     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        boolean r11 = r12.f22332h     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        if (r11 == 0) goto L_0x0175
        r12.m28660a(r5, r9)     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        boolean r4 = r12.m28676r()     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        if (r4 == 0) goto L_0x016f
        r12.m28673o()     // Catch:{ all -> 0x02e7 }
        r12.m28670l()
        return
    L_0x016f:
        com.ss.android.socialbase.downloader.i.e r4 = r12.f22349y     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        r12.m28655a(r8, r4)     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        goto L_0x0198
    L_0x0175:
        com.ss.android.socialbase.downloader.g.c r5 = r12.f22340p     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        boolean r5 = r5.mo32173S()     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        if (r5 != 0) goto L_0x0180
        r12.m28672n()     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
    L_0x0180:
        boolean r5 = r12.m28676r()     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        if (r5 == 0) goto L_0x018d
        r12.m28673o()     // Catch:{ all -> 0x02e7 }
        r12.m28670l()
        return
    L_0x018d:
        boolean r5 = r12.f22333i     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        if (r5 == 0) goto L_0x0195
        r12.m28652a(r10, r4)     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        goto L_0x0198
    L_0x0195:
        r12.m28653a(r6, r10)     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
    L_0x0198:
        r12.m28673o()     // Catch:{ all -> 0x02e7 }
        goto L_0x02de
    L_0x019d:
        com.ss.android.socialbase.downloader.e.a r4 = new com.ss.android.socialbase.downloader.e.a     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        r5 = 1032(0x408, float:1.446E-42)
        java.lang.String r6 = "chunkCount is 0"
        r4.m51543init(r5, r6)     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
        throw r4     // Catch:{ a -> 0x0282, a -> 0x01cf, all -> 0x01a7 }
    L_0x01a7:
        r0 = move-exception
        java.lang.String r1 = f22318a     // Catch:{ all -> 0x02e2 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x02e2 }
        r2.<init>()     // Catch:{ all -> 0x02e2 }
        java.lang.String r3 = "downloadInner: throwable =  "
        r2.append(r3)     // Catch:{ all -> 0x02e2 }
        r2.append(r0)     // Catch:{ all -> 0x02e2 }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x02e2 }
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27761d(r1, r2)     // Catch:{ all -> 0x02e2 }
        com.ss.android.socialbase.downloader.b.k r1 = r12.f22338n     // Catch:{ all -> 0x02e2 }
        com.ss.android.socialbase.downloader.b.k r2 = com.p530ss.android.socialbase.downloader.p557b.RunStatus.RUN_STATUS_PAUSE     // Catch:{ all -> 0x02e2 }
        if (r1 == r2) goto L_0x0198
        com.ss.android.socialbase.downloader.e.a r1 = new com.ss.android.socialbase.downloader.e.a     // Catch:{ all -> 0x02e2 }
        r2 = 1045(0x415, float:1.464E-42)
        r1.m51544init(r2, r0)     // Catch:{ all -> 0x02e2 }
        r12.mo32573b(r1)     // Catch:{ all -> 0x02e2 }
        goto L_0x0198
    L_0x01cf:
        r2 = move-exception
        java.lang.String r3 = f22318a     // Catch:{ all -> 0x02e2 }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x02e2 }
        r4.<init>()     // Catch:{ all -> 0x02e2 }
        java.lang.String r5 = "downloadInner: retry throwable for "
        r4.append(r5)     // Catch:{ all -> 0x02e2 }
        java.lang.String r5 = r2.mo32581a()     // Catch:{ all -> 0x02e2 }
        r4.append(r5)     // Catch:{ all -> 0x02e2 }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x02e2 }
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27761d(r3, r4)     // Catch:{ all -> 0x02e2 }
        com.ss.android.socialbase.downloader.b.k r3 = r12.f22338n     // Catch:{ all -> 0x02e2 }
        com.ss.android.socialbase.downloader.b.k r4 = com.p530ss.android.socialbase.downloader.p557b.RunStatus.RUN_STATUS_PAUSE     // Catch:{ all -> 0x02e2 }
        if (r3 == r4) goto L_0x0198
        java.util.concurrent.atomic.AtomicInteger r3 = r12.f22329e     // Catch:{ all -> 0x02e2 }
        r4 = 5
        if (r3 == 0) goto L_0x0212
        java.util.concurrent.atomic.AtomicInteger r3 = r12.f22329e     // Catch:{ all -> 0x02e2 }
        int r3 = r3.get()     // Catch:{ all -> 0x02e2 }
        if (r3 <= 0) goto L_0x0212
        com.ss.android.socialbase.downloader.g.c r2 = r12.f22340p     // Catch:{ all -> 0x02e2 }
        java.util.concurrent.atomic.AtomicInteger r3 = r12.f22329e     // Catch:{ all -> 0x02e2 }
        int r3 = r3.decrementAndGet()     // Catch:{ all -> 0x02e2 }
        r2.mo32279f(r3)     // Catch:{ all -> 0x02e2 }
        com.ss.android.socialbase.downloader.g.c r2 = r12.f22340p     // Catch:{ all -> 0x02e2 }
        r2.mo32251b(r4)     // Catch:{ all -> 0x02e2 }
    L_0x020d:
        r12.m28673o()     // Catch:{ all -> 0x02e7 }
        goto L_0x0078
    L_0x0212:
        java.util.concurrent.atomic.AtomicInteger r3 = r12.f22329e     // Catch:{ all -> 0x02e2 }
        if (r3 == 0) goto L_0x0261
        com.ss.android.socialbase.downloader.g.c r3 = r12.f22340p     // Catch:{ all -> 0x02e2 }
        boolean r3 = r3.mo32207aJ()     // Catch:{ all -> 0x02e2 }
        if (r3 == 0) goto L_0x023a
        com.ss.android.socialbase.downloader.g.c r2 = r12.f22340p     // Catch:{ all -> 0x02e2 }
        r2.mo32251b(r4)     // Catch:{ all -> 0x02e2 }
        java.util.concurrent.atomic.AtomicInteger r2 = r12.f22329e     // Catch:{ all -> 0x02e2 }
        com.ss.android.socialbase.downloader.g.c r3 = r12.f22340p     // Catch:{ all -> 0x02e2 }
        int r3 = r3.mo32158D()     // Catch:{ all -> 0x02e2 }
        r2.set(r3)     // Catch:{ all -> 0x02e2 }
        com.ss.android.socialbase.downloader.g.c r2 = r12.f22340p     // Catch:{ all -> 0x02e2 }
        java.util.concurrent.atomic.AtomicInteger r3 = r12.f22329e     // Catch:{ all -> 0x02e2 }
        int r3 = r3.get()     // Catch:{ all -> 0x02e2 }
        r2.mo32279f(r3)     // Catch:{ all -> 0x02e2 }
        goto L_0x020d
    L_0x023a:
        com.ss.android.socialbase.downloader.e.a r3 = new com.ss.android.socialbase.downloader.e.a     // Catch:{ all -> 0x02e2 }
        r4 = 1018(0x3fa, float:1.427E-42)
        java.lang.String r5 = "retry for Throwable, but retry Time %s all used, last error is %s"
        r6 = 2
        java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x02e2 }
        com.ss.android.socialbase.downloader.g.c r7 = r12.f22340p     // Catch:{ all -> 0x02e2 }
        int r7 = r7.mo32158D()     // Catch:{ all -> 0x02e2 }
        java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x02e2 }
        r6[r0] = r7     // Catch:{ all -> 0x02e2 }
        java.lang.String r0 = r2.mo32581a()     // Catch:{ all -> 0x02e2 }
        r6[r1] = r0     // Catch:{ all -> 0x02e2 }
        java.lang.String r0 = java.lang.String.format(r5, r6)     // Catch:{ all -> 0x02e2 }
        r3.m51543init(r4, r0)     // Catch:{ all -> 0x02e2 }
        r12.mo32573b(r3)     // Catch:{ all -> 0x02e2 }
        goto L_0x0198
    L_0x0261:
        com.ss.android.socialbase.downloader.e.a r0 = new com.ss.android.socialbase.downloader.e.a     // Catch:{ all -> 0x02e2 }
        r1 = 1043(0x413, float:1.462E-42)
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02e2 }
        r3.<init>()     // Catch:{ all -> 0x02e2 }
        java.lang.String r4 = "retry for Throwable, but retain retry time is NULL, last error is"
        r3.append(r4)     // Catch:{ all -> 0x02e2 }
        java.lang.String r2 = r2.mo32581a()     // Catch:{ all -> 0x02e2 }
        r3.append(r2)     // Catch:{ all -> 0x02e2 }
        java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x02e2 }
        r0.m51543init(r1, r2)     // Catch:{ all -> 0x02e2 }
        r12.mo32573b(r0)     // Catch:{ all -> 0x02e2 }
        goto L_0x0198
    L_0x0282:
        r4 = move-exception
        java.lang.String r5 = f22318a     // Catch:{ all -> 0x02e2 }
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x02e2 }
        r6.<init>()     // Catch:{ all -> 0x02e2 }
        java.lang.String r7 = "downloadInner: baseException = "
        r6.append(r7)     // Catch:{ all -> 0x02e2 }
        r6.append(r4)     // Catch:{ all -> 0x02e2 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x02e2 }
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27761d(r5, r6)     // Catch:{ all -> 0x02e2 }
        com.ss.android.socialbase.downloader.b.k r5 = r12.f22338n     // Catch:{ all -> 0x02e2 }
        com.ss.android.socialbase.downloader.b.k r6 = com.p530ss.android.socialbase.downloader.p557b.RunStatus.RUN_STATUS_PAUSE     // Catch:{ all -> 0x02e2 }
        if (r5 == r6) goto L_0x0198
        int r5 = r4.mo32073a()     // Catch:{ all -> 0x02e2 }
        r6 = 1025(0x401, float:1.436E-42)
        if (r5 == r6) goto L_0x02d3
        int r5 = r4.mo32073a()     // Catch:{ all -> 0x02e2 }
        r6 = 1009(0x3f1, float:1.414E-42)
        if (r5 != r6) goto L_0x02b0
        goto L_0x02d3
    L_0x02b0:
        boolean r5 = r12.mo32571a(r4)     // Catch:{ all -> 0x02e2 }
        if (r5 == 0) goto L_0x02ce
        boolean r5 = com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28775a(r4)     // Catch:{ all -> 0x02e2 }
        if (r5 == 0) goto L_0x02bf
        r12.m28644D()     // Catch:{ all -> 0x02e2 }
    L_0x02bf:
        com.ss.android.socialbase.downloader.e.g r2 = r12.mo32562a(r4, r2)     // Catch:{ all -> 0x02e2 }
        com.ss.android.socialbase.downloader.e.g r3 = com.p530ss.android.socialbase.downloader.p560e.RetryCheckStatus.RETURN     // Catch:{ all -> 0x02e2 }
        if (r2 != r3) goto L_0x020d
        r12.m28673o()     // Catch:{ all -> 0x02e7 }
        r12.m28670l()
        return
    L_0x02ce:
        r12.mo32573b(r4)     // Catch:{ all -> 0x02e2 }
        goto L_0x0198
    L_0x02d3:
        com.ss.android.socialbase.downloader.b.k r0 = com.p530ss.android.socialbase.downloader.p557b.RunStatus.RUN_STATUS_END_RIGHT_NOW     // Catch:{ all -> 0x02e2 }
        r12.f22338n = r0     // Catch:{ all -> 0x02e2 }
        r12.m28673o()     // Catch:{ all -> 0x02e7 }
        r12.m28670l()
        return
    L_0x02de:
        r12.m28670l()
        return
    L_0x02e2:
        r0 = move-exception
        r12.m28673o()     // Catch:{ all -> 0x02e7 }
        throw r0     // Catch:{ all -> 0x02e7 }
    L_0x02e7:
        r0 = move-exception
        r12.m28670l()
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.p568l.DownloadRunnable.m28669k():void");
    }

    /* renamed from: l */
    private void m28670l() {
        boolean z;
        boolean z2;
        int i = 0;
        boolean z3 = (this.f22338n == RunStatus.RUN_STATUS_PAUSE || this.f22338n == RunStatus.RUN_STATUS_CANCELED) ? false : true;
        try {
            z2 = m28677s();
            z = false;
        } catch (Exception e) {
            if (e instanceof BaseException) {
                this.f22346v.mo31898a((BaseException) e);
            } else {
                this.f22346v.mo31898a(new BaseException(1046, (Throwable) e));
            }
            z2 = true;
            z = true;
        }
        if (z2 || z) {
            this.f22337m.set(false);
            if (z3) {
                try {
                    AbsDownloadEngine t = C6694b.m27388t();
                    if (t != null) {
                        t.mo32486a(this);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    IDownloadMonitorDepend e2 = this.f22327c.mo32401e();
                    DownloadInfo cVar = this.f22340p;
                    BaseException aVar = new BaseException((int) PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, DownloadUtils.m28786b(th, "removeDownloadRunnable"));
                    DownloadInfo cVar2 = this.f22340p;
                    if (cVar2 != null) {
                        i = cVar2.mo32308q();
                    }
                    DownloadMonitorHelper.m28177a(e2, cVar, aVar, i);
                }
            }
        } else {
            this.f22322D = true;
            C6704a.m27758b(f22318a, "jump to restart");
        }
    }

    /* renamed from: a */
    private void m28660a(String str, List<HttpHeader> list) throws BaseException, C6748a {
        if (this.f22349y == null) {
            FakeDownloadHttpConnection dVar = null;
            if (this.f22340p.mo32219aV() == 1) {
                dVar = DownloadConnectionPool.m28187a().mo32455b(str, list);
            }
            if (dVar != null) {
                mo32567a((IDownloadHeadHttpConnection) this.f22349y);
                this.f22340p.mo32301l(2);
                this.f22349y = dVar;
            } else {
                try {
                    this.f22349y = C6694b.m27350a(this.f22340p.mo32306o(), this.f22340p.mo32157C(), str, list);
                } catch (BaseException e) {
                    throw e;
                } catch (Throwable th) {
                    mo32567a((IDownloadHeadHttpConnection) this.f22349y);
                    throw th;
                }
                mo32567a((IDownloadHeadHttpConnection) this.f22349y);
            }
            if (this.f22349y == null) {
                throw new BaseException(1022, (Throwable) new IOException("download can't continue, firstConnection is null"));
            }
        }
    }

    /* renamed from: m */
    private void m28671m() {
        IDownloadHeadHttpConnection cVar = this.f22350z;
        if (cVar != null) {
            cVar.mo16502c();
            this.f22350z = null;
        }
    }

    /* renamed from: n */
    private void m28672n() {
        IDownloadHttpConnection eVar = this.f22349y;
        if (eVar != null) {
            eVar.mo16503d();
            this.f22349y = null;
        }
    }

    /* renamed from: o */
    private void m28673o() {
        m28671m();
        m28672n();
    }

    /* renamed from: b */
    private DownloadChunk m28664b(long j) {
        return new C6709a(this.f22340p.mo32283g()).mo32147a(-1).mo32148a(0).mo32154e(j).mo32151b(j).mo32152c(0).mo32153d(this.f22340p.mo32225ab() - j).mo32150a();
    }

    /* renamed from: a */
    private List<HttpHeader> m28651a(DownloadChunk bVar) {
        return DownloadUtils.m28760a(this.f22340p.mo32156B(), this.f22340p.mo32226ac(), bVar);
    }

    /* renamed from: p */
    private void m28674p() throws BaseException {
        if (this.f22331g == null) {
            return;
        }
        if (this.f22338n == RunStatus.RUN_STATUS_CANCELED) {
            this.f22340p.mo32251b(-4);
            this.f22331g.mo31892c();
        } else if (this.f22338n == RunStatus.RUN_STATUS_PAUSE) {
            this.f22340p.mo32251b(-2);
            this.f22331g.mo31891b();
        } else {
            this.f22331g.mo31893d();
        }
    }

    /* renamed from: q */
    private boolean m28675q() {
        return this.f22338n == RunStatus.RUN_STATUS_CANCELED || this.f22338n == RunStatus.RUN_STATUS_PAUSE;
    }

    /* renamed from: r */
    private boolean m28676r() {
        if (!m28675q() && this.f22340p.mo32308q() != -2) {
            return false;
        }
        if (!m28675q()) {
            if (this.f22340p.mo32308q() == -2) {
                this.f22338n = RunStatus.RUN_STATUS_PAUSE;
            } else if (this.f22340p.mo32308q() == -4) {
                this.f22338n = RunStatus.RUN_STATUS_CANCELED;
            }
        }
        return true;
    }

    /* renamed from: s */
    private boolean m28677s() {
        DeviceBandwidthSampler.m28179a().mo32447c();
        boolean z = true;
        if (this.f22338n == RunStatus.RUN_STATUS_ERROR) {
            this.f22346v.mo31898a(this.f22348x);
        } else if (this.f22338n == RunStatus.RUN_STATUS_CANCELED) {
            this.f22346v.mo31904c();
        } else if (this.f22338n == RunStatus.RUN_STATUS_PAUSE) {
            this.f22346v.mo31905d();
        } else if (this.f22338n == RunStatus.RUN_STATUS_END_RIGHT_NOW) {
            this.f22346v.mo31908g();
        } else if (this.f22338n == RunStatus.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.f22346v.mo31901a(this.f22324F);
            } catch (BaseException e) {
                this.f22346v.mo31898a(e);
            }
        } else if (this.f22338n == RunStatus.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
            this.f22346v.mo31899a(this.f22348x, false);
            return false;
        } else if (this.f22338n == RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER) {
            return true;
        } else {
            if (this.f22338n != RunStatus.RUN_STATUS_RETRY_DELAY || m28678t()) {
                try {
                    if (!m28679u()) {
                        return false;
                    }
                    this.f22346v.mo31907f();
                    RetryScheduler.m28554a().mo32529d();
                } catch (Throwable th) {
                    mo32573b(new BaseException((int) PointerIconCompat.TYPE_TEXT, DownloadUtils.m28786b(th, "doTaskStatusHandle onComplete")));
                }
            } else {
                C6704a.m27758b(f22318a, "doTaskStatusHandle retryDelay");
                m28680v();
                if (this.f22338n != RunStatus.RUN_STATUS_RETRY_DELAY) {
                    z = false;
                }
                return z;
            }
        }
        return true;
    }

    /* renamed from: t */
    private boolean m28678t() {
        if (this.f22340p.mo32219aV() <= 1) {
            return this.f22340p.mo32180Z() > 0 && this.f22340p.mo32180Z() == this.f22340p.mo32225ab();
        }
        List<DownloadChunk> c = this.f22339o.mo31685c(this.f22340p.mo32283g());
        if (c == null || c.size() <= 1) {
            return false;
        }
        for (DownloadChunk bVar : c) {
            if (bVar != null) {
                if (!bVar.mo32131i()) {
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: u */
    private boolean m28679u() {
        if (this.f22340p.mo32201aD()) {
            DownloadInfo cVar = this.f22340p;
            cVar.mo32264c(cVar.mo32180Z());
        }
        if (this.f22340p.mo32180Z() > 0 && (this.f22340p.mo32176V() || (this.f22340p.mo32225ab() > 0 && this.f22340p.mo32180Z() == this.f22340p.mo32225ab()))) {
            return true;
        }
        this.f22340p.mo32187a(ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_RESTART);
        this.f22340p.mo32210aM();
        this.f22339o.mo31676a(this.f22340p);
        this.f22339o.mo31690d(this.f22340p.mo32283g());
        DownloadUtils.m28763a(this.f22340p);
        return false;
    }

    /* renamed from: v */
    private void m28680v() {
        boolean z;
        String str = "extra_download_id";
        String str2 = "com.ss.android.downloader.action.DOWNLOAD_WAKEUP";
        long w = m28681w();
        try {
            Intent intent = new Intent(str2);
            intent.putExtra(str, this.f22340p.mo32283g());
            intent.setClass(C6694b.m27342B(), DownloadHandleService.class);
            if (VERSION.SDK_INT >= 19) {
                this.f22347w.setExact(2, SystemClock.elapsedRealtime() + w, PendingIntent.getService(C6694b.m27342B(), this.f22340p.mo32283g(), intent, 1073741824));
            } else {
                this.f22347w.set(2, SystemClock.elapsedRealtime() + w, PendingIntent.getService(C6694b.m27342B(), this.f22340p.mo32283g(), intent, 1073741824));
            }
        } catch (Throwable unused) {
        }
        this.f22338n = RunStatus.RUN_STATUS_RETRY_DELAY;
        this.f22340p.mo32188a(RetryDelayStatus.DELAY_RETRY_WAITING);
        this.f22339o.mo31676a(this.f22340p);
        if (!z) {
            this.f22338n = RunStatus.RUN_STATUS_NONE;
            return;
        }
        this.f22338n = RunStatus.RUN_STATUS_RETRY_DELAY;
        this.f22340p.mo32188a(RetryDelayStatus.DELAY_RETRY_WAITING);
        this.f22339o.mo31676a(this.f22340p);
    }

    /* renamed from: w */
    private long m28681w() {
        return this.f22345u.mo32072a(this.f22340p.mo32161G(), this.f22340p.mo32160F());
    }

    /* renamed from: x */
    private void m28682x() throws C6748a, BaseException {
        int g = this.f22340p.mo32283g();
        int a = C6694b.m27347a(this.f22340p);
        if (!this.f22340p.mo32206aI()) {
            DownloadInfo b = this.f22339o.mo31677b(a);
            if (b != null) {
                AbsDownloadEngine t = C6694b.m27388t();
                if (t != null && b.mo32283g() != g && b.mo32197a(this.f22340p)) {
                    if (!t.mo32488a(b.mo32283g())) {
                        List<DownloadChunk> c = this.f22339o.mo31685c(a);
                        DownloadUtils.m28763a(this.f22340p);
                        this.f22339o.mo31694f(a);
                        if (b != null && b.mo32214aQ()) {
                            this.f22340p.mo32191a(b, false);
                            this.f22339o.mo31676a(this.f22340p);
                            if (c != null) {
                                for (DownloadChunk bVar : c) {
                                    bVar.mo32119b(g);
                                    this.f22339o.mo31674a(bVar);
                                }
                            }
                            throw new C6748a("retry task because id generator changed");
                        }
                        return;
                    }
                    this.f22339o.mo31694f(g);
                    throw new BaseException((int) InputDeviceCompat.SOURCE_GAMEPAD, "another same task is downloading");
                }
                return;
            }
            return;
        }
        throw new BaseException((int) PointerIconCompat.TYPE_VERTICAL_TEXT, "file has downloaded");
    }

    /* renamed from: a */
    private void m28652a(int i, List<DownloadChunk> list) throws BaseException {
        if (list.size() == i) {
            m28662a(list, this.f22340p.mo32225ab());
            return;
        }
        throw new BaseException(1033, (Throwable) new IllegalArgumentException());
    }

    /* renamed from: a */
    private void m28653a(long j, int i) throws BaseException {
        long j2 = j;
        int i2 = i;
        long j3 = j2 / ((long) i2);
        int g = this.f22340p.mo32283g();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        long j4 = 0;
        while (i3 < i2) {
            DownloadChunk a = new C6709a(g).mo32147a(i3).mo32148a(j4).mo32154e(j4).mo32151b(j4).mo32152c(i3 == i2 + -1 ? 0 : (j4 + j3) - 1).mo32150a();
            arrayList.add(a);
            this.f22339o.mo31674a(a);
            j4 += j3;
            i3++;
        }
        this.f22340p.mo32263c(i2);
        this.f22339o.mo31664a(g, i2);
        m28662a((List<DownloadChunk>) arrayList, j2);
    }

    /* renamed from: a */
    private void m28662a(List<DownloadChunk> list, long j) throws BaseException {
        long j2;
        for (DownloadChunk bVar : list) {
            if (bVar != null) {
                if (bVar.mo32138p() == 0) {
                    j2 = j - bVar.mo32136n();
                } else {
                    j2 = (bVar.mo32138p() - bVar.mo32136n()) + 1;
                }
                if (j2 > 0) {
                    bVar.mo32112a(j2);
                    if (!this.f22340p.mo32173S() || this.f22349y == null || (this.f22340p.mo32175U() && !this.f22323E)) {
                        this.f22330f.add(new DownloadChunkRunnable(bVar, this.f22327c, this));
                    } else if (bVar.mo32141s() == 0) {
                        this.f22330f.add(new DownloadChunkRunnable(bVar, this.f22327c, this.f22349y, this));
                    } else if (bVar.mo32141s() > 0) {
                        this.f22330f.add(new DownloadChunkRunnable(bVar, this.f22327c, this));
                    }
                }
            }
        }
        if (DownloadExpSwitchCode.m28744a(64)) {
            ArrayList arrayList = new ArrayList(this.f22330f.size());
            Iterator it = this.f22330f.iterator();
            while (it.hasNext()) {
                DownloadChunkRunnable bVar2 = (DownloadChunkRunnable) it.next();
                if (this.f22338n == RunStatus.RUN_STATUS_CANCELED) {
                    bVar2.mo32560b();
                } else if (this.f22338n == RunStatus.RUN_STATUS_PAUSE) {
                    bVar2.mo32558a();
                } else {
                    arrayList.add(bVar2);
                }
            }
            Runnable runnable = (Runnable) arrayList.remove(0);
            try {
                List<Future> c = DefaultDownloadEngine.m28312c((List<Runnable>) arrayList);
                while (runnable != null) {
                    if (!m28676r()) {
                        runnable.run();
                        runnable = DefaultDownloadEngine.m28313d(c);
                    } else {
                        return;
                    }
                }
                if (c != null && !c.isEmpty()) {
                    for (Future future : c) {
                        if (future != null && !future.isDone()) {
                            try {
                                future.get();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
        } else {
            ArrayList arrayList2 = new ArrayList(this.f22330f.size());
            Iterator it2 = this.f22330f.iterator();
            while (it2.hasNext()) {
                DownloadChunkRunnable bVar3 = (DownloadChunkRunnable) it2.next();
                if (this.f22338n == RunStatus.RUN_STATUS_CANCELED) {
                    bVar3.mo32560b();
                } else if (this.f22338n == RunStatus.RUN_STATUS_PAUSE) {
                    bVar3.mo32558a();
                } else {
                    arrayList2.add(Executors.callable(bVar3));
                }
            }
            if (!m28676r()) {
                try {
                    DefaultDownloadEngine.m28311b((List<Callable<Object>>) arrayList2);
                } catch (InterruptedException e) {
                    throw new BaseException((int) PointerIconCompat.TYPE_GRAB, (Throwable) e);
                }
            }
        }
    }

    /* renamed from: a */
    private void m28655a(DownloadChunk bVar, IDownloadHttpConnection eVar) throws BaseException {
        bVar.mo32112a(this.f22340p.mo32225ab() - bVar.mo32136n());
        this.f22340p.mo32263c(1);
        this.f22339o.mo31664a(this.f22340p.mo32283g(), 1);
        this.f22331g = new DownloadResponseHandler(this.f22340p, eVar, bVar, this);
        m28674p();
    }

    /* renamed from: y */
    private boolean m28683y() {
        DownloadInfo cVar = this.f22340p;
        if (cVar == null) {
            return false;
        }
        if ((!this.f22333i || cVar.mo32219aV() > 1) && !this.f22340p.mo32239ap() && this.f22334j && !this.f22336l) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0107, code lost:
            if (r12 > r2) goto L_0x0109;
     */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01eb A[SYNTHETIC, Splitter:B:82:0x01eb] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x020a A[SYNTHETIC, Splitter:B:97:0x020a] */
    /* renamed from: a */
    private void m28654a(long r25, java.lang.String r27, java.lang.String r28) throws com.p530ss.android.socialbase.downloader.p560e.BaseException {
        /*
        r24 = this;
        r1 = r24
        r2 = r25
        r0 = r27
        r4 = r28
        java.lang.String r5 = "MB"
        java.lang.String r6 = ", mustSetLength = "
        boolean r7 = com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28791b(r25)
        if (r7 == 0) goto L_0x0013
        return
    L_0x0013:
        r7 = -1
        com.ss.android.socialbase.downloader.g.f r7 = com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28752a(r0, r4, r7)
        java.io.File r8 = new java.io.File     // Catch:{ all -> 0x0205 }
        r8.<init>(r0, r4)     // Catch:{ all -> 0x0205 }
        long r8 = r8.length()     // Catch:{ all -> 0x0205 }
        long r10 = r2 - r8
        long r12 = com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28796c(r27)     // Catch:{ all -> 0x0205 }
        com.ss.android.socialbase.downloader.g.c r0 = r1.f22340p     // Catch:{ all -> 0x0205 }
        int r0 = r0.mo32283g()     // Catch:{ all -> 0x0205 }
        com.ss.android.socialbase.downloader.k.a r0 = com.p530ss.android.socialbase.downloader.p567k.DownloadSetting.m28610a(r0)     // Catch:{ all -> 0x0205 }
        java.lang.String r4 = "space_fill_part_download"
        r14 = 0
        int r4 = r0.mo32547a(r4, r14)     // Catch:{ all -> 0x0205 }
        java.lang.String r15 = " 0"
        java.lang.String r16 = "="
        java.lang.String r17 = "<"
        java.lang.String r14 = "availableSpace "
        r18 = r6
        r6 = 1
        r20 = r14
        r19 = r15
        r14 = 0
        if (r4 != r6) goto L_0x014f
        r1.f22325G = r14     // Catch:{ all -> 0x014a }
        int r4 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
        if (r4 > 0) goto L_0x005f
        com.ss.android.socialbase.downloader.g.c r4 = r1.f22340p     // Catch:{ all -> 0x014a }
        long r10 = r4.mo32225ab()     // Catch:{ all -> 0x014a }
        com.ss.android.socialbase.downloader.g.c r4 = r1.f22340p     // Catch:{ all -> 0x014a }
        long r21 = r4.mo32180Z()     // Catch:{ all -> 0x014a }
        long r10 = r10 - r21
    L_0x005f:
        int r4 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
        if (r4 >= 0) goto L_0x0146
        java.lang.String r4 = f22318a     // Catch:{ all -> 0x014a }
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x014a }
        r6.<init>()     // Catch:{ all -> 0x014a }
        java.lang.String r14 = "checkSpaceOverflow: contentLength = "
        r6.append(r14)     // Catch:{ all -> 0x014a }
        double r14 = com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28747a(r25)     // Catch:{ all -> 0x014a }
        r6.append(r14)     // Catch:{ all -> 0x014a }
        java.lang.String r14 = "MB, downloaded = "
        r6.append(r14)     // Catch:{ all -> 0x014a }
        double r14 = com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28747a(r8)     // Catch:{ all -> 0x014a }
        r6.append(r14)     // Catch:{ all -> 0x014a }
        java.lang.String r14 = "MB, required = "
        r6.append(r14)     // Catch:{ all -> 0x014a }
        double r14 = com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28747a(r10)     // Catch:{ all -> 0x014a }
        r6.append(r14)     // Catch:{ all -> 0x014a }
        java.lang.String r14 = "MB, available = "
        r6.append(r14)     // Catch:{ all -> 0x014a }
        double r14 = com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28747a(r12)     // Catch:{ all -> 0x014a }
        r6.append(r14)     // Catch:{ all -> 0x014a }
        r6.append(r5)     // Catch:{ all -> 0x014a }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x014a }
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27761d(r4, r6)     // Catch:{ all -> 0x014a }
        r14 = 0
        int r4 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
        if (r4 <= 0) goto L_0x010f
        java.lang.String r4 = "space_fill_min_keep_mb"
        r6 = 100
        int r0 = r0.mo32547a(r4, r6)     // Catch:{ all -> 0x014a }
        if (r0 <= 0) goto L_0x00fc
        long r14 = (long) r0     // Catch:{ all -> 0x014a }
        r16 = 1048576(0x100000, double:5.180654E-318)
        long r14 = r14 * r16
        long r14 = r12 - r14
        java.lang.String r4 = f22318a     // Catch:{ all -> 0x014a }
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x014a }
        r6.<init>()     // Catch:{ all -> 0x014a }
        r23 = r7
        java.lang.String r7 = "checkSpaceOverflow: minKeep = "
        r6.append(r7)     // Catch:{ all -> 0x017b }
        r6.append(r0)     // Catch:{ all -> 0x017b }
        java.lang.String r0 = "MB, canDownload = "
        r6.append(r0)     // Catch:{ all -> 0x017b }
        double r2 = com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28747a(r14)     // Catch:{ all -> 0x017b }
        r6.append(r2)     // Catch:{ all -> 0x017b }
        r6.append(r5)     // Catch:{ all -> 0x017b }
        java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x017b }
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27761d(r4, r0)     // Catch:{ all -> 0x017b }
        r2 = 0
        int r0 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
        if (r0 <= 0) goto L_0x00f6
        com.ss.android.socialbase.downloader.g.c r0 = r1.f22340p     // Catch:{ all -> 0x017b }
        long r2 = r0.mo32180Z()     // Catch:{ all -> 0x017b }
        long r2 = r2 + r14
        r1.f22325G = r2     // Catch:{ all -> 0x017b }
        r2 = r25
        r12 = r14
        goto L_0x0100
    L_0x00f6:
        com.ss.android.socialbase.downloader.e.e r0 = new com.ss.android.socialbase.downloader.e.e     // Catch:{ all -> 0x017b }
        r0.m51550init(r12, r10)     // Catch:{ all -> 0x017b }
        throw r0     // Catch:{ all -> 0x017b }
    L_0x00fc:
        r23 = r7
        r2 = r25
    L_0x0100:
        int r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
        if (r0 >= 0) goto L_0x0109
        long r12 = r12 + r8
        int r0 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
        if (r0 <= 0) goto L_0x010a
    L_0x0109:
        r12 = r2
    L_0x010a:
        r4 = r23
        r5 = 1
        goto L_0x0188
    L_0x010f:
        r23 = r7
        java.lang.String r5 = "download_when_space_negative"
        r6 = 0
        int r0 = r0.mo32547a(r5, r6)     // Catch:{ all -> 0x017b }
        r5 = 1
        if (r0 != r5) goto L_0x0121
        r12 = r2
        r4 = r23
        r5 = 0
        goto L_0x0188
    L_0x0121:
        com.ss.android.socialbase.downloader.e.a r0 = new com.ss.android.socialbase.downloader.e.a     // Catch:{ all -> 0x017b }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x017b }
        r2.<init>()     // Catch:{ all -> 0x017b }
        r6 = r20
        r2.append(r6)     // Catch:{ all -> 0x017b }
        if (r4 != 0) goto L_0x0132
        r3 = r16
        goto L_0x0134
    L_0x0132:
        r3 = r17
    L_0x0134:
        r2.append(r3)     // Catch:{ all -> 0x017b }
        r4 = r19
        r2.append(r4)     // Catch:{ all -> 0x017b }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x017b }
        r3 = 1052(0x41c, float:1.474E-42)
        r0.m51543init(r3, r2)     // Catch:{ all -> 0x017b }
        throw r0     // Catch:{ all -> 0x017b }
    L_0x0146:
        r23 = r7
        r5 = 1
        goto L_0x0185
    L_0x014a:
        r0 = move-exception
        r2 = r0
        r4 = r7
        goto L_0x0208
    L_0x014f:
        r23 = r7
        r4 = r19
        r6 = r20
        r5 = 1
        int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
        if (r0 > 0) goto L_0x0181
        com.ss.android.socialbase.downloader.e.a r2 = new com.ss.android.socialbase.downloader.e.a     // Catch:{ all -> 0x017b }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x017b }
        r3.<init>()     // Catch:{ all -> 0x017b }
        r3.append(r6)     // Catch:{ all -> 0x017b }
        if (r0 != 0) goto L_0x0169
        r0 = r16
        goto L_0x016b
    L_0x0169:
        r0 = r17
    L_0x016b:
        r3.append(r0)     // Catch:{ all -> 0x017b }
        r3.append(r4)     // Catch:{ all -> 0x017b }
        java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x017b }
        r3 = 1052(0x41c, float:1.474E-42)
        r2.m51543init(r3, r0)     // Catch:{ all -> 0x017b }
        throw r2     // Catch:{ all -> 0x017b }
    L_0x017b:
        r0 = move-exception
        r2 = r0
        r4 = r23
        goto L_0x0208
    L_0x0181:
        int r0 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
        if (r0 < 0) goto L_0x01fb
    L_0x0185:
        r12 = r2
        r4 = r23
    L_0x0188:
        r4.mo32444b(r2)     // Catch:{ all -> 0x018c }
        goto L_0x01e9
    L_0x018c:
        r0 = move-exception
        r6 = r0
        java.lang.String r0 = f22318a     // Catch:{ all -> 0x0203 }
        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0203 }
        r7.<init>()     // Catch:{ all -> 0x0203 }
        java.lang.String r10 = "checkSpaceOverflow: setLength1 e = "
        r7.append(r10)     // Catch:{ all -> 0x0203 }
        r7.append(r6)     // Catch:{ all -> 0x0203 }
        r10 = r18
        r7.append(r10)     // Catch:{ all -> 0x0203 }
        r7.append(r5)     // Catch:{ all -> 0x0203 }
        java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0203 }
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27762e(r0, r7)     // Catch:{ all -> 0x0203 }
        r7 = 1040(0x410, float:1.457E-42)
        int r0 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
        if (r0 >= 0) goto L_0x01e7
        r2 = 0
        int r0 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
        if (r0 <= 0) goto L_0x01e7
        int r0 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
        if (r0 <= 0) goto L_0x01e7
        r4.mo32444b(r12)     // Catch:{ all -> 0x01c0 }
        goto L_0x01e9
    L_0x01c0:
        r0 = move-exception
        r2 = r0
        java.lang.String r0 = f22318a     // Catch:{ all -> 0x0203 }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0203 }
        r3.<init>()     // Catch:{ all -> 0x0203 }
        java.lang.String r6 = "checkSpaceOverflow: setLength2 ex = "
        r3.append(r6)     // Catch:{ all -> 0x0203 }
        r3.append(r2)     // Catch:{ all -> 0x0203 }
        r3.append(r10)     // Catch:{ all -> 0x0203 }
        r3.append(r5)     // Catch:{ all -> 0x0203 }
        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0203 }
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27762e(r0, r3)     // Catch:{ all -> 0x0203 }
        if (r5 != 0) goto L_0x01e1
        goto L_0x01e9
    L_0x01e1:
        com.ss.android.socialbase.downloader.e.a r0 = new com.ss.android.socialbase.downloader.e.a     // Catch:{ all -> 0x0203 }
        r0.m51544init(r7, r2)     // Catch:{ all -> 0x0203 }
        throw r0     // Catch:{ all -> 0x0203 }
    L_0x01e7:
        if (r5 != 0) goto L_0x01f5
    L_0x01e9:
        if (r4 == 0) goto L_0x01f4
        r4.mo32443b()     // Catch:{ Exception -> 0x01ef }
        goto L_0x01f4
    L_0x01ef:
        r0 = move-exception
        r2 = r0
        r2.printStackTrace()
    L_0x01f4:
        return
    L_0x01f5:
        com.ss.android.socialbase.downloader.e.a r0 = new com.ss.android.socialbase.downloader.e.a     // Catch:{ all -> 0x0203 }
        r0.m51544init(r7, r6)     // Catch:{ all -> 0x0203 }
        throw r0     // Catch:{ all -> 0x0203 }
    L_0x01fb:
        r4 = r23
        com.ss.android.socialbase.downloader.e.e r0 = new com.ss.android.socialbase.downloader.e.e     // Catch:{ all -> 0x0203 }
        r0.m51550init(r12, r10)     // Catch:{ all -> 0x0203 }
        throw r0     // Catch:{ all -> 0x0203 }
    L_0x0203:
        r0 = move-exception
        goto L_0x0207
    L_0x0205:
        r0 = move-exception
        r4 = r7
    L_0x0207:
        r2 = r0
    L_0x0208:
        if (r4 == 0) goto L_0x0213
        r4.mo32443b()     // Catch:{ Exception -> 0x020e }
        goto L_0x0213
    L_0x020e:
        r0 = move-exception
        r3 = r0
        r3.printStackTrace()
    L_0x0213:
        throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.p568l.DownloadRunnable.m28654a(long, java.lang.String, java.lang.String):void");
    }

    /* renamed from: z */
    private void m28684z() throws BaseException {
        long j;
        try {
            j = DownloadUtils.m28796c(this.f22340p.mo32300l());
        } catch (BaseException unused) {
            j = 0;
        }
        String str = f22318a;
        StringBuilder sb = new StringBuilder();
        sb.append("checkSpaceOverflowInProgress: available = ");
        sb.append(DownloadUtils.m28747a(j));
        String str2 = "MB";
        sb.append(str2);
        C6704a.m27760c(str, sb.toString());
        if (j > 0) {
            long ab = this.f22340p.mo32225ab() - this.f22340p.mo32180Z();
            if (j < ab) {
                int a = DownloadSetting.m28610a(this.f22340p.mo32283g()).mo32547a("space_fill_min_keep_mb", 100);
                if (a > 0) {
                    long j2 = j - (((long) a) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
                    String str3 = f22318a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("checkSpaceOverflowInProgress: minKeep  = ");
                    sb2.append(a);
                    sb2.append("MB, canDownload = ");
                    sb2.append(DownloadUtils.m28747a(j2));
                    sb2.append(str2);
                    C6704a.m27760c(str3, sb2.toString());
                    if (j2 > 0) {
                        this.f22325G = this.f22340p.mo32180Z() + j2 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                        return;
                    } else {
                        this.f22325G = 0;
                        throw new DownloadOutOfSpaceException(j, ab);
                    }
                }
            }
        }
        this.f22325G = 0;
    }

    /* renamed from: A */
    private void m28641A() throws DownloadRetryNeedlessException {
        if (this.f22340p.mo32317x()) {
            Context B = C6694b.m27342B();
            String str = Constants.PERMISSION_ACCESS_NETWORK_STATE;
            if (!DownloadUtils.m28774a(B, str)) {
                throw new DownloadRetryNeedlessException(PointerIconCompat.TYPE_ZOOM_OUT, String.format("download task need permission:%s", new Object[]{str}));
            }
        }
        if (!this.f22340p.mo32198aA()) {
            throw new DownloadOnlyWifiException();
        }
    }

    /* renamed from: B */
    private void m28642B() throws BaseException {
        if (TextUtils.isEmpty(this.f22340p.mo32297k())) {
            throw new BaseException(1028, "download savePath can not be empty");
        } else if (!TextUtils.isEmpty(this.f22340p.mo32287h())) {
            File file = new File(this.f22340p.mo32297k());
            if (!file.exists()) {
                if (!file.mkdirs()) {
                    throw new BaseException(1030, "download savePath directory can not created");
                }
            } else if (!file.isDirectory()) {
                throw new BaseException(1031, "download savePath is not a directory");
            }
        } else {
            throw new BaseException(1029, "download name can not be empty");
        }
    }

    /* renamed from: a */
    private boolean m28663a(int i, String str, String str2) {
        boolean z = true;
        if (i == 412) {
            return true;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !str.equals(str2) && (this.f22335k || this.f22334j)) {
            return true;
        }
        if (!(i == 201 || i == 416) || this.f22340p.mo32180Z() <= 0) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    private void m28659a(String str, String str2) throws C6748a {
        this.f22339o.mo31690d(this.f22340p.mo32283g());
        DownloadUtils.m28763a(this.f22340p);
        this.f22333i = false;
        this.f22340p.mo32289h(str);
        this.f22339o.mo31676a(this.f22340p);
        throw new C6748a(str2);
    }

    /* renamed from: a */
    private void m28656a(IDownloadHeadHttpConnection cVar, long j) throws BaseException, C6748a {
        long j2;
        if (cVar != null) {
            try {
                int b = cVar.mo16501b();
                String a = cVar.mo16500a("Accept-Ranges");
                String a2 = cVar.mo16500a("Content-Type");
                if (TextUtils.isEmpty(this.f22340p.mo32231ah()) && !TextUtils.isEmpty(a2)) {
                    this.f22340p.mo32285g(a2);
                }
                this.f22334j = DownloadUtils.m28771a(b, a);
                this.f22335k = DownloadUtils.m28770a(b);
                this.f22340p.mo32290h(this.f22334j);
                String ac = this.f22340p.mo32226ac();
                String a3 = cVar.mo16500a("Etag");
                String str = "";
                if (m28663a(b, ac, a3)) {
                    if (cVar instanceof IDownloadHttpConnection) {
                        if (!TextUtils.isEmpty(ac) && ac.equals(a3)) {
                            a3 = str;
                        }
                        m28659a(a3, "eTag of server file changed");
                    } else {
                        throw new DownloadHttpException(PointerIconCompat.TYPE_HAND, b, str);
                    }
                }
                if (!this.f22334j) {
                    if (!this.f22335k) {
                        if (b == 403) {
                            throw new BaseException(1047, "response code error : 403");
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("response code error : ");
                        sb.append(b);
                        throw new DownloadHttpException(1004, b, sb.toString());
                    }
                }
                if (this.f22335k && j > 0) {
                    if (cVar instanceof IDownloadHttpConnection) {
                        m28659a(str, "http head request not support");
                    } else {
                        throw new BaseException(1004, "isResponseFromBegin but firstOffset > 0");
                    }
                }
                long a4 = DownloadUtils.m28748a(cVar);
                String a5 = TextUtils.isEmpty(this.f22340p.mo32287h()) ? DownloadUtils.m28753a(cVar, this.f22340p.mo32295j()) : str;
                if (DownloadExpSwitchCode.m28744a(8)) {
                    this.f22336l = DownloadUtils.m28803c(cVar);
                } else {
                    this.f22336l = DownloadUtils.m28791b(a4);
                }
                if (!this.f22336l && a4 == 0) {
                    if (!(cVar instanceof IDownloadHttpConnection)) {
                        throw new BaseException(1004, str);
                    }
                }
                if (!this.f22336l) {
                    String a6 = cVar.mo16500a("Content-Range");
                    j2 = (TextUtils.isEmpty(a6) || !DownloadExpSwitchCode.m28744a(2)) ? j + a4 : DownloadUtils.m28749a(a6);
                } else {
                    j2 = -1;
                }
                if (!m28676r()) {
                    this.f22346v.mo31897a(j2, a3, a5);
                }
            } catch (BaseException e) {
                throw e;
            } catch (C6748a e2) {
                throw e2;
            } catch (Throwable th) {
                DownloadUtils.m28768a(th, "HandleFirstConnection");
            }
        }
    }

    /* renamed from: d */
    public boolean mo32576d() {
        return this.f22337m.get();
    }

    /* renamed from: e */
    public int mo32577e() {
        DownloadInfo cVar = this.f22340p;
        if (cVar != null) {
            return cVar.mo32283g();
        }
        return 0;
    }

    /* renamed from: f */
    public void mo32578f() {
        this.f22346v.mo31896a();
    }

    /* renamed from: C */
    private void m28643C() {
        long e = DownloadUtils.m28810e(this.f22340p);
        this.f22340p.mo32182a(e);
        this.f22333i = e > 0;
        if (!this.f22333i) {
            this.f22339o.mo31690d(this.f22340p.mo32283g());
            DownloadUtils.m28763a(this.f22340p);
        }
    }

    /* renamed from: a */
    public boolean mo32570a(long j) throws BaseException {
        if (this.f22325G > 0 && this.f22340p.mo32180Z() > this.f22325G) {
            m28684z();
        }
        return this.f22346v.mo31902a(j);
    }

    /* renamed from: a */
    public void mo32568a(DownloadChunkRunnable bVar) {
        if (!this.f22332h) {
            synchronized (this) {
                this.f22330f.remove(bVar);
            }
        }
    }

    /* renamed from: a */
    public boolean mo32571a(BaseException aVar) {
        boolean z = true;
        if (DownloadUtils.m28793b(aVar)) {
            if (this.f22332h && !this.f22328d) {
                DownloadUtils.m28763a(this.f22340p);
                this.f22328d = true;
            }
            return true;
        }
        AtomicInteger atomicInteger = this.f22329e;
        if (((atomicInteger == null || atomicInteger.get() <= 0) && !this.f22340p.mo32208aK() && (aVar == null || ((aVar.mo32073a() != 1011 && (aVar.getCause() == null || !(aVar.getCause() instanceof SSLHandshakeException))) || !this.f22340p.mo32209aL()))) || (aVar instanceof DownloadRetryNeedlessException)) {
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    public void mo32573b(BaseException aVar) {
        String str = f22318a;
        StringBuilder sb = new StringBuilder();
        sb.append("onError:");
        sb.append(aVar.getMessage());
        C6704a.m27758b(str, sb.toString());
        this.f22338n = RunStatus.RUN_STATUS_ERROR;
        this.f22348x = aVar;
        m28645E();
    }

    /* renamed from: D */
    private void m28644D() {
        try {
            this.f22339o.mo31690d(this.f22340p.mo32283g());
            DownloadUtils.m28763a(this.f22340p);
            this.f22333i = false;
            this.f22340p.mo32289h("");
            this.f22339o.mo31676a(this.f22340p);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    public void mo32575c(BaseException aVar) {
        DownloadInfo cVar = this.f22340p;
        if (cVar != null) {
            cVar.mo32302l(true);
        }
        mo32566a(aVar, false);
    }

    /* renamed from: a */
    public void mo32566a(BaseException aVar, boolean z) {
        C6704a.m27758b(f22318a, "onAllChunkRetryWithReset");
        this.f22338n = RunStatus.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.f22348x = aVar;
        m28645E();
        if (!(z ? m28665d(aVar) : false)) {
            m28644D();
        }
    }

    /* renamed from: E */
    private void m28645E() {
        try {
            Iterator it = ((ArrayList) this.f22330f.clone()).iterator();
            while (it.hasNext()) {
                DownloadChunkRunnable bVar = (DownloadChunkRunnable) it.next();
                if (bVar != null) {
                    bVar.mo32560b();
                }
            }
        } catch (Throwable th) {
            String str = f22318a;
            StringBuilder sb = new StringBuilder();
            sb.append("cancelAllChunkRunnable: ");
            sb.append(th.toString());
            C6704a.m27760c(str, sb.toString());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28661a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.f22340p.mo32193a(list, this.f22338n == RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER);
            AbsDownloadEngine t = C6694b.m27388t();
            if (t != null) {
                t.mo32504l(this.f22340p.mo32283g());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: F */
    public void m28646F() {
        if (!m28676r()) {
            AbsDownloadEngine t = C6694b.m27388t();
            if (t != null) {
                t.mo32504l(this.f22340p.mo32283g());
            }
        }
    }

    /* renamed from: a */
    public RetryCheckStatus mo32563a(DownloadChunk bVar, BaseException aVar, long j) {
        if (m28675q()) {
            return RetryCheckStatus.RETURN;
        }
        if (aVar != null && (aVar.mo32073a() == 1047 || DownloadUtils.m28817g((Throwable) aVar))) {
            return mo32562a(aVar, j);
        }
        this.f22348x = aVar;
        this.f22340p.mo32252b(-j);
        this.f22339o.mo31676a(this.f22340p);
        if (m28665d(aVar)) {
            return RetryCheckStatus.RETURN;
        }
        this.f22346v.mo31900a(bVar, aVar, this.f22338n == RunStatus.RUN_STATUS_RETRY_DELAY);
        if (this.f22338n != RunStatus.RUN_STATUS_RETRY_DELAY && this.f22340p.mo32233aj()) {
            long w = m28681w();
            if (w > 0) {
                String str = f22318a;
                StringBuilder sb = new StringBuilder();
                sb.append("onSingleChunkRetry with delay time ");
                sb.append(w);
                C6704a.m27760c(str, sb.toString());
                try {
                    Thread.sleep(w);
                } catch (Throwable th) {
                    String str2 = f22318a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onSingleChunkRetry:");
                    sb2.append(th.getMessage());
                    C6704a.m27761d(str2, sb2.toString());
                }
            }
        }
        return RetryCheckStatus.CONTINUE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d4, code lost:
            if (m28665d(r8) == false) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d8, code lost:
            return com.p530ss.android.socialbase.downloader.p560e.RetryCheckStatus.RETURN;
     */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x011a  */
    /* renamed from: a */
    public com.p530ss.android.socialbase.downloader.p560e.RetryCheckStatus mo32562a(com.p530ss.android.socialbase.downloader.p560e.BaseException r8, long r9) {
        /*
        r7 = this;
        r7.f22348x = r8
        com.ss.android.socialbase.downloader.g.c r0 = r7.f22340p
        long r9 = -r9
        r0.mo32252b(r9)
        com.ss.android.socialbase.downloader.downloader.k r9 = r7.f22339o
        com.ss.android.socialbase.downloader.g.c r10 = r7.f22340p
        r9.mo31676a(r10)
        boolean r9 = r7.m28675q()
        if (r9 == 0) goto L_0x0018
        com.ss.android.socialbase.downloader.e.g r8 = com.p530ss.android.socialbase.downloader.p560e.RetryCheckStatus.RETURN
        return r8
    L_0x0018:
        r9 = 1
        r10 = 0
        if (r8 == 0) goto L_0x0061
        int r0 = r8.mo32073a()
        r1 = 1047(0x417, float:1.467E-42)
        if (r0 != r1) goto L_0x0061
        com.ss.android.socialbase.downloader.d.ab r0 = r7.f22319A
        if (r0 == 0) goto L_0x0058
        com.ss.android.socialbase.downloader.g.c r0 = r7.f22340p
        boolean r0 = r0.mo32236am()
        if (r0 == 0) goto L_0x0031
        goto L_0x0058
    L_0x0031:
        com.ss.android.socialbase.downloader.l.c$1 r0 = new com.ss.android.socialbase.downloader.l.c$1
        r0.m51659init()
        com.ss.android.socialbase.downloader.d.ab r1 = r7.f22319A
        boolean r1 = r1.mo31731a(r0)
        com.ss.android.socialbase.downloader.g.c r2 = r7.f22340p
        r2.mo32237an()
        if (r1 == 0) goto L_0x00f8
        boolean r0 = r0.mo31730a()
        if (r0 != 0) goto L_0x00d9
        r7.m28645E()
        com.ss.android.socialbase.downloader.downloader.e r8 = r7.f22346v
        r8.mo31909h()
        com.ss.android.socialbase.downloader.b.k r8 = com.p530ss.android.socialbase.downloader.p557b.RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER
        r7.f22338n = r8
        com.ss.android.socialbase.downloader.e.g r8 = com.p530ss.android.socialbase.downloader.p560e.RetryCheckStatus.RETURN
        return r8
    L_0x0058:
        boolean r0 = r7.m28665d(r8)
        if (r0 == 0) goto L_0x00f8
        com.ss.android.socialbase.downloader.e.g r8 = com.p530ss.android.socialbase.downloader.p560e.RetryCheckStatus.RETURN
        return r8
    L_0x0061:
        boolean r0 = com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28817g(r8)
        if (r0 == 0) goto L_0x00ef
        com.ss.android.socialbase.downloader.d.w r0 = r7.f22320B
        if (r0 != 0) goto L_0x0071
        r7.mo32573b(r8)
        com.ss.android.socialbase.downloader.e.g r8 = com.p530ss.android.socialbase.downloader.p560e.RetryCheckStatus.RETURN
        return r8
    L_0x0071:
        java.util.concurrent.atomic.AtomicBoolean r0 = new java.util.concurrent.atomic.AtomicBoolean
        r0.<init>(r10)
        com.ss.android.socialbase.downloader.l.c$2 r6 = new com.ss.android.socialbase.downloader.l.c$2
        r6.m51660init(r0)
        boolean r1 = r8 instanceof com.p530ss.android.socialbase.downloader.p560e.DownloadOutOfSpaceException
        if (r1 == 0) goto L_0x008b
        r1 = r8
        com.ss.android.socialbase.downloader.e.e r1 = (com.p530ss.android.socialbase.downloader.p560e.DownloadOutOfSpaceException) r1
        long r2 = r1.mo32086c()
        long r4 = r1.mo32087d()
        goto L_0x0095
    L_0x008b:
        r1 = -1
        com.ss.android.socialbase.downloader.g.c r3 = r7.f22340p
        long r3 = r3.mo32225ab()
        r4 = r3
        r2 = r1
    L_0x0095:
        monitor-enter(r7)
        com.ss.android.socialbase.downloader.d.w r1 = r7.f22320B     // Catch:{ all -> 0x00ec }
        boolean r1 = r1.mo31291a(r2, r4, r6)     // Catch:{ all -> 0x00ec }
        if (r1 == 0) goto L_0x00db
        com.ss.android.socialbase.downloader.g.c r1 = r7.f22340p     // Catch:{ all -> 0x00ec }
        int r1 = r1.mo32283g()     // Catch:{ all -> 0x00ec }
        com.ss.android.socialbase.downloader.k.a r1 = com.p530ss.android.socialbase.downloader.p567k.DownloadSetting.m28610a(r1)     // Catch:{ all -> 0x00ec }
        java.lang.String r2 = "not_delete_when_clean_space"
        boolean r1 = r1.mo32552b(r2, r10)     // Catch:{ all -> 0x00ec }
        if (r1 != 0) goto L_0x00b3
        r7.m28679u()     // Catch:{ all -> 0x00ec }
    L_0x00b3:
        boolean r0 = r0.get()     // Catch:{ all -> 0x00ec }
        if (r0 != 0) goto L_0x00cf
        com.ss.android.socialbase.downloader.b.k r8 = r7.f22338n     // Catch:{ all -> 0x00ec }
        com.ss.android.socialbase.downloader.b.k r9 = com.p530ss.android.socialbase.downloader.p557b.RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER     // Catch:{ all -> 0x00ec }
        if (r8 == r9) goto L_0x00cb
        com.ss.android.socialbase.downloader.b.k r8 = com.p530ss.android.socialbase.downloader.p557b.RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER     // Catch:{ all -> 0x00ec }
        r7.f22338n = r8     // Catch:{ all -> 0x00ec }
        r7.m28645E()     // Catch:{ all -> 0x00ec }
        com.ss.android.socialbase.downloader.downloader.e r8 = r7.f22346v     // Catch:{ all -> 0x00ec }
        r8.mo31909h()     // Catch:{ all -> 0x00ec }
    L_0x00cb:
        com.ss.android.socialbase.downloader.e.g r8 = com.p530ss.android.socialbase.downloader.p560e.RetryCheckStatus.RETURN     // Catch:{ all -> 0x00ec }
        monitor-exit(r7)     // Catch:{ all -> 0x00ec }
        return r8
    L_0x00cf:
        monitor-exit(r7)     // Catch:{ all -> 0x00ec }
        boolean r0 = r7.m28665d(r8)
        if (r0 == 0) goto L_0x00d9
        com.ss.android.socialbase.downloader.e.g r8 = com.p530ss.android.socialbase.downloader.p560e.RetryCheckStatus.RETURN
        return r8
    L_0x00d9:
        r0 = 1
        goto L_0x00f9
    L_0x00db:
        com.ss.android.socialbase.downloader.b.k r9 = r7.f22338n     // Catch:{ all -> 0x00ec }
        com.ss.android.socialbase.downloader.b.k r10 = com.p530ss.android.socialbase.downloader.p557b.RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER     // Catch:{ all -> 0x00ec }
        if (r9 != r10) goto L_0x00e5
        com.ss.android.socialbase.downloader.e.g r8 = com.p530ss.android.socialbase.downloader.p560e.RetryCheckStatus.RETURN     // Catch:{ all -> 0x00ec }
        monitor-exit(r7)     // Catch:{ all -> 0x00ec }
        return r8
    L_0x00e5:
        r7.mo32573b(r8)     // Catch:{ all -> 0x00ec }
        com.ss.android.socialbase.downloader.e.g r8 = com.p530ss.android.socialbase.downloader.p560e.RetryCheckStatus.RETURN     // Catch:{ all -> 0x00ec }
        monitor-exit(r7)     // Catch:{ all -> 0x00ec }
        return r8
    L_0x00ec:
        r8 = move-exception
        monitor-exit(r7)     // Catch:{ all -> 0x00ec }
        throw r8
    L_0x00ef:
        boolean r0 = r7.m28665d(r8)
        if (r0 == 0) goto L_0x00f8
        com.ss.android.socialbase.downloader.e.g r8 = com.p530ss.android.socialbase.downloader.p560e.RetryCheckStatus.RETURN
        return r8
    L_0x00f8:
        r0 = 0
    L_0x00f9:
        if (r0 != 0) goto L_0x0104
        boolean r0 = r7.m28647G()
        if (r0 == 0) goto L_0x0104
        r7.m28645E()
    L_0x0104:
        com.ss.android.socialbase.downloader.downloader.e r0 = r7.f22346v
        com.ss.android.socialbase.downloader.b.k r1 = r7.f22338n
        com.ss.android.socialbase.downloader.b.k r2 = com.p530ss.android.socialbase.downloader.p557b.RunStatus.RUN_STATUS_RETRY_DELAY
        if (r1 != r2) goto L_0x010d
        goto L_0x010e
    L_0x010d:
        r9 = 0
    L_0x010e:
        r0.mo31899a(r8, r9)
        com.ss.android.socialbase.downloader.b.k r8 = r7.f22338n
        com.ss.android.socialbase.downloader.b.k r9 = com.p530ss.android.socialbase.downloader.p557b.RunStatus.RUN_STATUS_RETRY_DELAY
        if (r8 != r9) goto L_0x011a
        com.ss.android.socialbase.downloader.e.g r8 = com.p530ss.android.socialbase.downloader.p560e.RetryCheckStatus.RETURN
        goto L_0x011c
    L_0x011a:
        com.ss.android.socialbase.downloader.e.g r8 = com.p530ss.android.socialbase.downloader.p560e.RetryCheckStatus.CONTINUE
    L_0x011c:
        return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.p568l.DownloadRunnable.mo32562a(com.ss.android.socialbase.downloader.e.a, long):com.ss.android.socialbase.downloader.e.g");
    }

    /* renamed from: d */
    private boolean m28665d(BaseException aVar) {
        AtomicInteger atomicInteger = this.f22329e;
        boolean z = true;
        if (atomicInteger != null) {
            if (atomicInteger.get() <= 0) {
                if (this.f22340p.mo32207aJ()) {
                    this.f22329e.set(this.f22340p.mo32159E());
                    this.f22340p.mo32279f(this.f22329e.get());
                } else if (aVar == null || ((aVar.mo32073a() != 1011 && (aVar.getCause() == null || !(aVar.getCause() instanceof SSLHandshakeException))) || !this.f22340p.mo32209aL())) {
                    mo32573b(new BaseException(aVar.mo32073a(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", new Object[]{String.valueOf(this.f22329e), String.valueOf(this.f22340p.mo32158D()), aVar.mo32076b()})));
                    return true;
                } else {
                    this.f22329e.set(this.f22340p.mo32158D());
                    this.f22340p.mo32279f(this.f22329e.get());
                    this.f22340p.mo32296j(true);
                }
                z = false;
            }
            if (this.f22338n != RunStatus.RUN_STATUS_RETRY_DELAY && z) {
                this.f22340p.mo32279f(this.f22329e.decrementAndGet());
            }
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("retry for exception, but retain retry time is null, last error is :");
        sb.append(aVar.mo32076b());
        mo32573b(new BaseException(1043, sb.toString()));
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0040, code lost:
            return null;
     */
    /* renamed from: a */
    public synchronized com.p530ss.android.socialbase.downloader.p562g.DownloadChunk mo32564a(int r5) {
        /*
        r4 = this;
        monitor-enter(r4)
        com.ss.android.socialbase.downloader.g.c r0 = r4.f22340p     // Catch:{ all -> 0x0041 }
        int r0 = r0.mo32219aV()     // Catch:{ all -> 0x0041 }
        r1 = 2
        r2 = 0
        if (r0 >= r1) goto L_0x000d
        monitor-exit(r4)
        return r2
    L_0x000d:
        com.ss.android.socialbase.downloader.downloader.k r0 = r4.f22339o     // Catch:{ all -> 0x0041 }
        com.ss.android.socialbase.downloader.g.c r1 = r4.f22340p     // Catch:{ all -> 0x0041 }
        int r1 = r1.mo32283g()     // Catch:{ all -> 0x0041 }
        java.util.List r0 = r0.mo31685c(r1)     // Catch:{ all -> 0x0041 }
        if (r0 == 0) goto L_0x003f
        boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x0041 }
        if (r1 == 0) goto L_0x0022
        goto L_0x003f
    L_0x0022:
        r1 = 0
    L_0x0023:
        int r3 = r0.size()     // Catch:{ all -> 0x0041 }
        if (r1 >= r3) goto L_0x003d
        java.lang.Object r3 = r0.get(r1)     // Catch:{ all -> 0x0041 }
        com.ss.android.socialbase.downloader.g.b r3 = (com.p530ss.android.socialbase.downloader.p562g.DownloadChunk) r3     // Catch:{ all -> 0x0041 }
        if (r3 != 0) goto L_0x0032
        goto L_0x003a
    L_0x0032:
        com.ss.android.socialbase.downloader.g.b r3 = r4.m28650a(r3, r5)     // Catch:{ all -> 0x0041 }
        if (r3 == 0) goto L_0x003a
        monitor-exit(r4)
        return r3
    L_0x003a:
        int r1 = r1 + 1
        goto L_0x0023
    L_0x003d:
        monitor-exit(r4)
        return r2
    L_0x003f:
        monitor-exit(r4)
        return r2
    L_0x0041:
        r5 = move-exception
        monitor-exit(r4)
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.p568l.DownloadRunnable.mo32564a(int):com.ss.android.socialbase.downloader.g.b");
    }

    /* renamed from: a */
    public void mo32567a(IDownloadHeadHttpConnection cVar) {
        if (cVar != null) {
            try {
                int b = cVar.mo16501b();
                this.f22340p.mo32274e(b);
                this.f22340p.mo32281f(DownloadHttpUtils.m28745a(b));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006c, code lost:
            if (r9.mo32128f() != false) goto L_0x006e;
     */
    /* renamed from: a */
    private com.p530ss.android.socialbase.downloader.p562g.DownloadChunk m28650a(com.p530ss.android.socialbase.downloader.p562g.DownloadChunk r9, int r10) {
        /*
        r8 = this;
        boolean r0 = r9.mo32125d()
        r1 = 0
        if (r0 != 0) goto L_0x0008
        return r1
    L_0x0008:
        r0 = 1
        long r2 = r9.mo32122c(r0)
        java.lang.String r4 = f22318a
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>()
        java.lang.String r6 = "reuseChunk retainLen:"
        r5.append(r6)
        r5.append(r2)
        java.lang.String r6 = " chunkIndex:"
        r5.append(r6)
        r5.append(r10)
        java.lang.String r5 = r5.toString()
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27758b(r4, r5)
        r4 = 0
        boolean r5 = r9.mo32128f()
        if (r5 != 0) goto L_0x0068
        long r5 = com.p530ss.android.socialbase.downloader.p557b.DownloadConstants.f21693a
        int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
        if (r7 <= 0) goto L_0x0068
        com.ss.android.socialbase.downloader.g.c r2 = r8.f22340p
        boolean r2 = r2.mo32307p()
        if (r2 == 0) goto L_0x0068
        com.ss.android.socialbase.downloader.g.c r2 = r8.f22340p
        int r2 = r2.mo32219aV()
        com.ss.android.socialbase.downloader.g.c r3 = r8.f22340p
        long r3 = r3.mo32225ab()
        java.util.List r2 = r9.mo32110a(r2, r3)
        if (r2 == 0) goto L_0x006e
        java.util.Iterator r2 = r2.iterator()
    L_0x0056:
        boolean r3 = r2.hasNext()
        if (r3 == 0) goto L_0x006e
        java.lang.Object r3 = r2.next()
        com.ss.android.socialbase.downloader.g.b r3 = (com.p530ss.android.socialbase.downloader.p562g.DownloadChunk) r3
        com.ss.android.socialbase.downloader.downloader.k r4 = r8.f22339o
        r4.mo31682b(r3)
        goto L_0x0056
    L_0x0068:
        boolean r2 = r9.mo32128f()
        if (r2 == 0) goto L_0x006f
    L_0x006e:
        r4 = 1
    L_0x006f:
        if (r4 == 0) goto L_0x0136
        boolean r2 = r9.mo32128f()
        if (r2 == 0) goto L_0x0136
        r2 = 1
    L_0x0078:
        java.util.List r3 = r9.mo32129g()
        int r3 = r3.size()
        if (r2 >= r3) goto L_0x00e3
        java.util.List r3 = r9.mo32129g()
        java.lang.Object r3 = r3.get(r2)
        com.ss.android.socialbase.downloader.g.b r3 = (com.p530ss.android.socialbase.downloader.p562g.DownloadChunk) r3
        if (r3 == 0) goto L_0x00e0
        java.lang.String r4 = f22318a
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>()
        java.lang.String r6 = "check can checkUnCompletedChunk -- chunkIndex:"
        r5.append(r6)
        int r6 = r3.mo32141s()
        r5.append(r6)
        java.lang.String r6 = " currentOffset:"
        r5.append(r6)
        long r6 = r3.mo32136n()
        r5.append(r6)
        java.lang.String r6 = "  startOffset:"
        r5.append(r6)
        long r6 = r3.mo32134l()
        r5.append(r6)
        java.lang.String r6 = " contentLen:"
        r5.append(r6)
        long r6 = r3.mo32139q()
        r5.append(r6)
        java.lang.String r5 = r5.toString()
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27758b(r4, r5)
        int r4 = r3.mo32141s()
        if (r4 < 0) goto L_0x00de
        boolean r4 = r3.mo32131i()
        if (r4 != 0) goto L_0x00e0
        boolean r4 = r3.mo32124c()
        if (r4 != 0) goto L_0x00e0
    L_0x00de:
        r1 = r3
        goto L_0x00e3
    L_0x00e0:
        int r2 = r2 + 1
        goto L_0x0078
    L_0x00e3:
        if (r1 == 0) goto L_0x0136
        long r2 = r9.mo32136n()
        java.lang.String r4 = f22318a
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>()
        java.lang.String r6 = "unComplete chunk "
        r5.append(r6)
        int r9 = r9.mo32141s()
        r5.append(r9)
        java.lang.String r9 = " curOffset:"
        r5.append(r9)
        r5.append(r2)
        java.lang.String r9 = " reuseChunk chunkIndex:"
        r5.append(r9)
        r5.append(r10)
        java.lang.String r9 = " for subChunk:"
        r5.append(r9)
        int r9 = r1.mo32141s()
        r5.append(r9)
        java.lang.String r9 = r5.toString()
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27758b(r4, r9)
        com.ss.android.socialbase.downloader.downloader.k r9 = r8.f22339o
        int r2 = r1.mo32133k()
        int r3 = r1.mo32141s()
        int r4 = r1.mo32118b()
        r9.mo31669a(r2, r3, r4, r10)
        r1.mo32123c(r10)
        r1.mo32117a(r0)
    L_0x0136:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.p568l.DownloadRunnable.m28650a(com.ss.android.socialbase.downloader.g.b, int):com.ss.android.socialbase.downloader.g.b");
    }

    /* renamed from: G */
    private boolean m28647G() {
        if (this.f22338n == RunStatus.RUN_STATUS_RETRY_DELAY || this.f22347w == null || !this.f22340p.mo32233aj() || m28681w() <= 0) {
            return false;
        }
        this.f22338n = RunStatus.RUN_STATUS_RETRY_DELAY;
        return true;
    }

    /* renamed from: a */
    private IRetryDelayTimeCalculator m28649a(C6712d dVar) {
        IRetryDelayTimeCalculator g = dVar.mo32407g();
        if (g != null) {
            return g;
        }
        DownloadInfo a = dVar.mo32357a();
        if (a != null) {
            String ak = a.mo32234ak();
            if (!TextUtils.isEmpty(ak)) {
                return new RetryDelayTimeParamCalculator(ak);
            }
        }
        return C6694b.m27341A();
    }

    /* renamed from: g */
    public Future mo32579g() {
        return this.f22326b;
    }

    /* renamed from: a */
    public void mo32569a(Future future) {
        this.f22326b = future;
    }
}
