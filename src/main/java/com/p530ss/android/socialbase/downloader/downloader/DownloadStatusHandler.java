package com.p530ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.p530ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.p530ss.android.socialbase.downloader.impls.RetryScheduler;
import com.p530ss.android.socialbase.downloader.p557b.AsyncHandleStatus;
import com.p530ss.android.socialbase.downloader.p557b.ListenerType;
import com.p530ss.android.socialbase.downloader.p557b.Md5CheckStatus;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadDepend;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadListener;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadMonitorDepend;
import com.p530ss.android.socialbase.downloader.p559d.ITempFileSaveCompleteCallback;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p560e.DownloadRetryNeedlessException;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p562g.C6712d;
import com.p530ss.android.socialbase.downloader.p562g.DownloadChunk;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import com.p530ss.android.socialbase.downloader.p569m.DownloadExpSwitchCode;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.ss.android.socialbase.downloader.downloader.e */
public class DownloadStatusHandler {
    /* access modifiers changed from: private|static|final */
    /* renamed from: a */
    public static final String f21900a = DownloadStatusHandler.class.getSimpleName();
    /* access modifiers changed from: private */
    /* renamed from: b */
    public DownloadInfo f21901b;
    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final IDownloadCache f21902c;
    /* renamed from: d */
    private final Handler f21903d;
    /* renamed from: e */
    private C6712d f21904e;
    /* renamed from: f */
    private SparseArray<IDownloadListener> f21905f;
    /* renamed from: g */
    private SparseArray<IDownloadListener> f21906g;
    /* renamed from: h */
    private SparseArray<IDownloadListener> f21907h;
    /* renamed from: i */
    private boolean f21908i = false;
    /* renamed from: j */
    private volatile long f21909j = 0;
    /* renamed from: k */
    private final AtomicLong f21910k = new AtomicLong();
    /* renamed from: l */
    private boolean f21911l = false;
    /* renamed from: m */
    private int f21912m;
    /* renamed from: n */
    private long f21913n;
    /* renamed from: o */
    private IDownloadDepend f21914o;
    /* renamed from: p */
    private IDownloadMonitorDepend f21915p;

    public DownloadStatusHandler(C6712d dVar, Handler handler) {
        this.f21904e = dVar;
        m27457j();
        this.f21903d = handler;
        this.f21902c = C6694b.m27384p();
    }

    /* renamed from: j */
    private void m27457j() {
        C6712d dVar = this.f21904e;
        if (dVar != null) {
            this.f21901b = dVar.mo32357a();
            this.f21905f = this.f21904e.mo32355a(ListenerType.MAIN);
            this.f21907h = this.f21904e.mo32355a(ListenerType.NOTIFICATION);
            this.f21906g = this.f21904e.mo32355a(ListenerType.SUB);
            this.f21914o = this.f21904e.mo32397d();
            this.f21915p = this.f21904e.mo32401e();
        }
    }

    /* renamed from: a */
    public void mo31896a() {
        if (!this.f21901b.mo32242as()) {
            this.f21901b.mo32251b(1);
            m27458k();
        }
    }

    /* renamed from: k */
    private void m27458k() {
        ExecutorService k = C6694b.m27379k();
        if (k != null) {
            k.execute(new Runnable() {
                public void run() {
                    DownloadStatusHandler.this.f21902c.mo31697i(DownloadStatusHandler.this.f21901b.mo32283g());
                    DownloadStatusHandler.this.m27446a(1, (BaseException) null);
                }
            });
        }
    }

    /* renamed from: b */
    public void mo31903b() {
        if (this.f21901b.mo32242as()) {
            this.f21901b.mo32243at();
            return;
        }
        this.f21902c.mo31695g(this.f21901b.mo32283g());
        if (this.f21901b.mo32215aR()) {
            m27446a(6, (BaseException) null);
        }
        m27446a(2, (BaseException) null);
    }

    /* renamed from: a */
    public void mo31897a(long j, String str, String str2) {
        this.f21901b.mo32264c(j);
        this.f21901b.mo32253b(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.f21901b.mo32287h())) {
            this.f21901b.mo32265c(str2);
        }
        try {
            this.f21902c.mo31666a(this.f21901b.mo32283g(), j, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        m27446a(3, (BaseException) null);
        this.f21913n = this.f21901b.mo32267d(j);
        this.f21912m = this.f21901b.mo32204aG();
        this.f21908i = true;
        RetryScheduler.m28554a().mo32530e();
    }

    /* renamed from: a */
    public boolean mo31902a(long j) {
        this.f21910k.addAndGet(j);
        this.f21901b.mo32252b(j);
        long uptimeMillis = SystemClock.uptimeMillis();
        return m27449a(uptimeMillis, m27453b(uptimeMillis));
    }

    /* renamed from: c */
    public void mo31904c() {
        m27446a(-4, (BaseException) null);
    }

    /* renamed from: d */
    public void mo31905d() {
        this.f21901b.mo32251b(-2);
        try {
            this.f21902c.mo31688d(this.f21901b.mo32283g(), this.f21901b.mo32180Z());
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        m27446a(-2, (BaseException) null);
    }

    /* renamed from: e */
    public void mo31906e() {
        this.f21901b.mo32251b(-7);
        try {
            this.f21902c.mo31698j(this.f21901b.mo32283g());
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        m27446a(-7, (BaseException) null);
    }

    /* renamed from: a */
    public void mo31899a(BaseException aVar, boolean z) {
        this.f21901b.mo32282f(false);
        this.f21910k.set(0);
        m27452b(aVar, z);
    }

    /* renamed from: a */
    public void mo31900a(DownloadChunk bVar, BaseException aVar, boolean z) {
        this.f21901b.mo32282f(false);
        this.f21910k.set(0);
        this.f21902c.mo31696h(this.f21901b.mo32283g());
        m27447a(z ? 10 : 9, aVar, true);
    }

    /* renamed from: a */
    public void mo31898a(BaseException aVar) {
        this.f21901b.mo32282f(false);
        m27451b(aVar);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0033 */
    /* renamed from: b */
    private void m27451b(com.p530ss.android.socialbase.downloader.p560e.BaseException r5) {
        /*
        r4 = this;
        if (r5 == 0) goto L_0x0021
        java.lang.Throwable r0 = r5.getCause()
        if (r0 == 0) goto L_0x0021
        java.lang.Throwable r0 = r5.getCause()
        boolean r0 = r0 instanceof android.database.sqlite.SQLiteFullException
        if (r0 == 0) goto L_0x0021
        com.ss.android.socialbase.downloader.downloader.k r0 = r4.f21902c     // Catch:{ SQLiteException -> 0x001c }
        com.ss.android.socialbase.downloader.g.c r1 = r4.f21901b     // Catch:{ SQLiteException -> 0x001c }
        int r1 = r1.mo32283g()     // Catch:{ SQLiteException -> 0x001c }
        r0.mo31694f(r1)     // Catch:{ SQLiteException -> 0x001c }
        goto L_0x0043
    L_0x001c:
        r0 = move-exception
        r0.printStackTrace()
        goto L_0x0043
    L_0x0021:
        com.ss.android.socialbase.downloader.downloader.k r0 = r4.f21902c     // Catch:{ SQLiteException -> 0x0033 }
        com.ss.android.socialbase.downloader.g.c r1 = r4.f21901b     // Catch:{ SQLiteException -> 0x0033 }
        int r1 = r1.mo32283g()     // Catch:{ SQLiteException -> 0x0033 }
        com.ss.android.socialbase.downloader.g.c r2 = r4.f21901b     // Catch:{ SQLiteException -> 0x0033 }
        long r2 = r2.mo32180Z()     // Catch:{ SQLiteException -> 0x0033 }
        r0.mo31678b(r1, r2)     // Catch:{ SQLiteException -> 0x0033 }
        goto L_0x0043
    L_0x0033:
        com.ss.android.socialbase.downloader.downloader.k r0 = r4.f21902c     // Catch:{ SQLiteException -> 0x003f }
        com.ss.android.socialbase.downloader.g.c r1 = r4.f21901b     // Catch:{ SQLiteException -> 0x003f }
        int r1 = r1.mo32283g()     // Catch:{ SQLiteException -> 0x003f }
        r0.mo31694f(r1)     // Catch:{ SQLiteException -> 0x003f }
        goto L_0x0043
    L_0x003f:
        r0 = move-exception
        r0.printStackTrace()
    L_0x0043:
        com.ss.android.socialbase.downloader.e.a r5 = r4.m27454c(r5)
        com.ss.android.socialbase.downloader.g.c r0 = r4.f21901b
        r0.mo32190a(r5)
        r0 = -1
        r4.m27446a(r0, r5)
        com.ss.android.socialbase.downloader.g.c r5 = r4.f21901b
        int r5 = r5.mo32283g()
        com.ss.android.socialbase.downloader.k.a r5 = com.p530ss.android.socialbase.downloader.p567k.DownloadSetting.m28610a(r5)
        r0 = 0
        java.lang.String r1 = "retry_schedule"
        int r5 = r5.mo32547a(r1, r0)
        if (r5 <= 0) goto L_0x006c
        com.ss.android.socialbase.downloader.impls.r r5 = com.p530ss.android.socialbase.downloader.impls.RetryScheduler.m28554a()
        com.ss.android.socialbase.downloader.g.c r0 = r4.f21901b
        r5.mo32528a(r0)
    L_0x006c:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.downloader.DownloadStatusHandler.m27451b(com.ss.android.socialbase.downloader.e.a):void");
    }

    /* renamed from: c */
    private BaseException m27454c(BaseException aVar) {
        if (DownloadSetting.m28610a(this.f21901b.mo32283g()).mo32547a("download_failed_check_net", 0) == 1 && DownloadUtils.m28819h((Throwable) aVar)) {
            Context B = C6694b.m27342B();
            if (B != null && !DownloadUtils.m28792b(B)) {
                return new BaseException(this.f21901b.mo32317x() ? PointerIconCompat.TYPE_ALL_SCROLL : 1049, aVar.mo32076b());
            }
        }
        return aVar;
    }

    /* renamed from: f */
    public void mo31907f() {
        this.f21901b.mo32282f(false);
        if (!this.f21901b.mo32176V() && this.f21901b.mo32180Z() != this.f21901b.mo32225ab()) {
            C6704a.m27758b(f21900a, this.f21901b.mo32268d());
            StringBuilder sb = new StringBuilder();
            sb.append("current bytes is not equals to total bytes, bytes changed with process : ");
            sb.append(this.f21901b.mo32224aa());
            mo31898a((BaseException) new DownloadRetryNeedlessException(1027, sb.toString()));
        } else if (this.f21901b.mo32180Z() <= 0) {
            C6704a.m27758b(f21900a, this.f21901b.mo32268d());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("curBytes is 0, bytes changed with process : ");
            sb2.append(this.f21901b.mo32224aa());
            mo31898a((BaseException) new DownloadRetryNeedlessException(1026, sb2.toString()));
        } else if (this.f21901b.mo32176V() || this.f21901b.mo32225ab() > 0) {
            String str = f21900a;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("");
            sb3.append(this.f21901b.mo32287h());
            sb3.append(" onCompleted start save file as target name");
            C6704a.m27758b(str, sb3.toString());
            IDownloadMonitorDepend aeVar = this.f21915p;
            C6712d dVar = this.f21904e;
            if (dVar != null) {
                aeVar = dVar.mo32401e();
            }
            if (this.f21901b.mo32177W()) {
                DownloadUtils.m28764a(this.f21901b, aeVar, (ITempFileSaveCompleteCallback) new ITempFileSaveCompleteCallback() {
                    /* renamed from: a */
                    public void mo31757a() {
                        DownloadStatusHandler.this.m27459l();
                    }

                    /* renamed from: a */
                    public void mo31758a(BaseException aVar) {
                        String i = DownloadStatusHandler.f21900a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("saveFileAsTargetName onFailed : ");
                        sb.append(aVar != null ? aVar.mo32076b() : "");
                        C6704a.m27758b(i, sb.toString());
                        DownloadStatusHandler.this.mo31898a(aVar);
                    }
                });
            } else {
                DownloadUtils.m28765a(this.f21901b, (ITempFileSaveCompleteCallback) new ITempFileSaveCompleteCallback() {
                    /* renamed from: a */
                    public void mo31757a() {
                        DownloadStatusHandler.this.m27459l();
                    }

                    /* renamed from: a */
                    public void mo31758a(BaseException aVar) {
                        String i = DownloadStatusHandler.f21900a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("saveFileAsTargetName onFailed : ");
                        sb.append(aVar != null ? aVar.mo32076b() : "");
                        C6704a.m27758b(i, sb.toString());
                        DownloadStatusHandler.this.mo31898a(aVar);
                    }
                });
            }
        } else {
            C6704a.m27758b(f21900a, this.f21901b.mo32268d());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("TotalBytes is 0, bytes changed with process : ");
            sb4.append(this.f21901b.mo32224aa());
            mo31898a((BaseException) new DownloadRetryNeedlessException(1044, sb4.toString()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m27459l() {
        try {
            C6704a.m27758b(f21900a, "saveFileAsTargetName onSuccess");
            Md5CheckStatus aS = this.f21901b.mo32216aS();
            if (aS != Md5CheckStatus.VALID) {
                String str = "";
                if (aS == Md5CheckStatus.INVALID_FILE_NO_EXIST) {
                    str = "md5 invalid because of file not exist";
                } else if (aS == Md5CheckStatus.INVALID_FILE_MD5_EMPTY) {
                    str = "md5 invalid because of file md5 is empty";
                } else if (aS == Md5CheckStatus.INVALID_MD5_NOT_EQUALS) {
                    str = "md5 invalid because of file md5 is not equals to task md5";
                }
                mo31898a(new BaseException(1034, str));
                DownloadUtils.m28763a(this.f21901b);
                return;
            }
            this.f21901b.mo32286g(false);
            m27446a(-3, (BaseException) null);
            this.f21902c.mo31684c(this.f21901b.mo32283g(), this.f21901b.mo32225ab());
            this.f21902c.mo31690d(this.f21901b.mo32283g());
        } catch (Throwable th) {
            mo31898a(new BaseException((int) PointerIconCompat.TYPE_TEXT, DownloadUtils.m28786b(th, "onCompleted")));
        }
    }

    /* renamed from: g */
    public void mo31908g() {
        C6704a.m27758b(f21900a, "onCompleteForFileExist");
        m27446a(-3, (BaseException) null);
        this.f21902c.mo31684c(this.f21901b.mo32283g(), this.f21901b.mo32225ab());
        this.f21902c.mo31690d(this.f21901b.mo32283g());
    }

    /* renamed from: a */
    public void mo31901a(String str) throws BaseException {
        String str2 = f21900a;
        StringBuilder sb = new StringBuilder();
        sb.append("onCompleteForFileExist existTargetFileName is ");
        sb.append(str);
        sb.append(" but curName is ");
        sb.append(this.f21901b.mo32287h());
        C6704a.m27758b(str2, sb.toString());
        if (DownloadExpSwitchCode.m28744a(16384)) {
            m27446a(-3, (BaseException) null);
            this.f21902c.mo31676a(this.f21901b);
            DownloadUtils.m28766a(this.f21901b, str);
            return;
        }
        this.f21902c.mo31676a(this.f21901b);
        DownloadUtils.m28766a(this.f21901b, str);
        m27446a(-3, (BaseException) null);
    }

    /* renamed from: a */
    private boolean m27449a(long j, boolean z) {
        boolean z2 = false;
        if (this.f21901b.mo32180Z() == this.f21901b.mo32225ab()) {
            try {
                this.f21902c.mo31665a(this.f21901b.mo32283g(), this.f21901b.mo32180Z());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
        if (this.f21908i) {
            this.f21908i = false;
            this.f21901b.mo32251b(4);
        }
        if (this.f21901b.mo32202aE() && z) {
            z2 = true;
        }
        m27447a(4, (BaseException) null, z2);
        return z;
    }

    /* renamed from: b */
    private boolean m27453b(long j) {
        boolean z = true;
        if (!this.f21911l) {
            this.f21911l = true;
            return true;
        }
        long j2 = j - this.f21909j;
        if (this.f21910k.get() < this.f21913n && j2 < ((long) this.f21912m)) {
            z = false;
        }
        if (z) {
            this.f21909j = j;
            this.f21910k.set(0);
        }
        return z;
    }

    /* renamed from: b */
    private void m27452b(BaseException aVar, boolean z) {
        this.f21902c.mo31696h(this.f21901b.mo32283g());
        m27446a(z ? 7 : 5, aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27446a(int i, BaseException aVar) {
        m27447a(i, aVar, true);
    }

    /* renamed from: h */
    public void mo31909h() {
        this.f21901b.mo32251b(8);
        this.f21901b.mo32186a(AsyncHandleStatus.ASYNC_HANDLE_WAITING);
        AbsDownloadEngine t = C6694b.m27388t();
        if (t != null) {
            t.mo32481a(this.f21901b.mo32283g(), 8);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00dc, code lost:
            if (r7.f21901b.mo32229af() != false) goto L_0x00de;
     */
    /* renamed from: a */
    private void m27447a(int r8, com.p530ss.android.socialbase.downloader.p560e.BaseException r9, boolean r10) {
        /*
        r7 = this;
        com.ss.android.socialbase.downloader.g.c r0 = r7.f21901b
        int r0 = r0.mo32308q()
        r1 = 4
        r2 = -3
        if (r0 != r2) goto L_0x000d
        if (r8 != r1) goto L_0x000d
        return
    L_0x000d:
        r7.m27457j()
        r3 = 0
        if (r8 == r1) goto L_0x0029
        boolean r1 = com.p530ss.android.socialbase.downloader.p557b.DownloadStatus.m26985e(r8)
        if (r1 == 0) goto L_0x0029
        com.ss.android.socialbase.downloader.g.c r1 = r7.f21901b
        r1.mo32277e(r3)
        boolean r1 = com.p530ss.android.socialbase.downloader.p557b.DownloadStatus.m26984d(r8)
        if (r1 == 0) goto L_0x0029
        com.ss.android.socialbase.downloader.g.c r1 = r7.f21901b
        r1.mo32170P()
    L_0x0029:
        com.ss.android.socialbase.downloader.d.ae r1 = r7.f21915p
        r4 = 1
        if (r1 == 0) goto L_0x004a
        boolean r5 = r1 instanceof com.p530ss.android.socialbase.downloader.p559d.AbsDownloadMonitorDepend
        if (r5 == 0) goto L_0x004a
        com.ss.android.socialbase.downloader.d.j r1 = (com.p530ss.android.socialbase.downloader.p559d.AbsDownloadMonitorDepend) r1
        int[] r1 = r1.mo31765a()
        if (r1 == 0) goto L_0x004a
        int r5 = r1.length
        if (r5 <= 0) goto L_0x004a
        r5 = 0
    L_0x003e:
        int r6 = r1.length
        if (r5 >= r6) goto L_0x004a
        r6 = r1[r5]
        if (r8 != r6) goto L_0x0047
        r1 = 1
        goto L_0x004b
    L_0x0047:
        int r5 = r5 + 1
        goto L_0x003e
    L_0x004a:
        r1 = 0
    L_0x004b:
        boolean r5 = com.p530ss.android.socialbase.downloader.p557b.DownloadStatus.m26983c(r8)
        if (r5 != 0) goto L_0x0053
        if (r1 == 0) goto L_0x0065
    L_0x0053:
        com.ss.android.socialbase.downloader.d.s r1 = r7.f21914o     // Catch:{ all -> 0x005e }
        if (r1 == 0) goto L_0x005e
        com.ss.android.socialbase.downloader.d.s r1 = r7.f21914o     // Catch:{ all -> 0x005e }
        com.ss.android.socialbase.downloader.g.c r5 = r7.f21901b     // Catch:{ all -> 0x005e }
        r1.mo31498a(r5, r9, r8)     // Catch:{ all -> 0x005e }
    L_0x005e:
        com.ss.android.socialbase.downloader.d.ae r1 = r7.f21915p
        com.ss.android.socialbase.downloader.g.c r5 = r7.f21901b
        com.p530ss.android.socialbase.downloader.p563h.DownloadMonitorHelper.m28177a(r1, r5, r9, r8)
    L_0x0065:
        r1 = 6
        if (r8 != r1) goto L_0x006f
        com.ss.android.socialbase.downloader.g.c r1 = r7.f21901b
        r5 = 2
        r1.mo32251b(r5)
        goto L_0x007d
    L_0x006f:
        r1 = -6
        if (r8 != r1) goto L_0x0078
        com.ss.android.socialbase.downloader.g.c r1 = r7.f21901b
        r1.mo32251b(r2)
        goto L_0x007d
    L_0x0078:
        com.ss.android.socialbase.downloader.g.c r1 = r7.f21901b
        r1.mo32251b(r8)
    L_0x007d:
        if (r0 == r2) goto L_0x0082
        r1 = -1
        if (r0 != r1) goto L_0x00b5
    L_0x0082:
        com.ss.android.socialbase.downloader.g.c r0 = r7.f21901b
        com.ss.android.socialbase.downloader.b.j r0 = r0.mo32240aq()
        com.ss.android.socialbase.downloader.b.j r1 = com.p530ss.android.socialbase.downloader.p557b.RetryDelayStatus.DELAY_RETRY_DOWNLOADING
        if (r0 != r1) goto L_0x0093
        com.ss.android.socialbase.downloader.g.c r0 = r7.f21901b
        com.ss.android.socialbase.downloader.b.j r1 = com.p530ss.android.socialbase.downloader.p557b.RetryDelayStatus.DELAY_RETRY_DOWNLOADED
        r0.mo32188a(r1)
    L_0x0093:
        com.ss.android.socialbase.downloader.g.c r0 = r7.f21901b
        com.ss.android.socialbase.downloader.b.a r0 = r0.mo32241ar()
        com.ss.android.socialbase.downloader.b.a r1 = com.p530ss.android.socialbase.downloader.p557b.AsyncHandleStatus.ASYNC_HANDLE_DOWNLOADING
        if (r0 != r1) goto L_0x00a4
        com.ss.android.socialbase.downloader.g.c r0 = r7.f21901b
        com.ss.android.socialbase.downloader.b.a r1 = com.p530ss.android.socialbase.downloader.p557b.AsyncHandleStatus.ASYNC_HANDLE_DOWNLOADED
        r0.mo32186a(r1)
    L_0x00a4:
        com.ss.android.socialbase.downloader.g.c r0 = r7.f21901b
        com.ss.android.socialbase.downloader.b.b r0 = r0.mo32224aa()
        com.ss.android.socialbase.downloader.b.b r1 = com.p530ss.android.socialbase.downloader.p557b.ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_DOWNLOADING
        if (r0 != r1) goto L_0x00b5
        com.ss.android.socialbase.downloader.g.c r0 = r7.f21901b
        com.ss.android.socialbase.downloader.b.b r1 = com.p530ss.android.socialbase.downloader.p557b.ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_DOWNLOADED
        r0.mo32187a(r1)
    L_0x00b5:
        android.util.SparseArray<com.ss.android.socialbase.downloader.d.ad> r0 = r7.f21906g
        com.ss.android.socialbase.downloader.g.c r1 = r7.f21901b
        com.p530ss.android.socialbase.downloader.p569m.DownloadListenerUtils.m28746a(r8, r0, r4, r1, r9)
        r0 = -4
        if (r8 != r0) goto L_0x00c0
        return
    L_0x00c0:
        if (r10 == 0) goto L_0x00f0
        android.util.SparseArray<com.ss.android.socialbase.downloader.d.ad> r10 = r7.f21905f
        if (r10 == 0) goto L_0x00cc
        int r10 = r10.size()
        if (r10 > 0) goto L_0x00de
    L_0x00cc:
        android.util.SparseArray<com.ss.android.socialbase.downloader.d.ad> r10 = r7.f21907h
        if (r10 == 0) goto L_0x00f0
        int r10 = r10.size()
        if (r10 <= 0) goto L_0x00f0
        com.ss.android.socialbase.downloader.g.c r10 = r7.f21901b
        boolean r10 = r10.mo32229af()
        if (r10 == 0) goto L_0x00f0
    L_0x00de:
        android.os.Handler r10 = r7.f21903d
        if (r10 == 0) goto L_0x00f0
        com.ss.android.socialbase.downloader.g.c r0 = r7.f21901b
        int r0 = r0.mo32283g()
        android.os.Message r8 = r10.obtainMessage(r8, r0, r3, r9)
        r8.sendToTarget()
        goto L_0x00ff
    L_0x00f0:
        com.ss.android.socialbase.downloader.impls.a r9 = com.p530ss.android.socialbase.downloader.downloader.C6694b.m27388t()
        if (r9 == 0) goto L_0x00ff
        com.ss.android.socialbase.downloader.g.c r10 = r7.f21901b
        int r10 = r10.mo32283g()
        r9.mo32481a(r10, r8)
    L_0x00ff:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.downloader.DownloadStatusHandler.m27447a(int, com.ss.android.socialbase.downloader.e.a, boolean):void");
    }
}
