package com.kwai.filedownloader.download;

import android.database.sqlite.SQLiteFullException;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwai.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwai.filedownloader.message.C4698e;
import com.kwai.filedownloader.message.C4701f;
import com.kwai.filedownloader.p354b.C4596a;
import com.kwai.filedownloader.p356d.C4621c;
import com.kwai.filedownloader.p358f.C4660d;
import com.kwai.filedownloader.p358f.C4661e;
import com.kwai.filedownloader.p358f.C4664f;
import com.kwai.filedownloader.services.C4736f;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* renamed from: com.kwai.filedownloader.download.d */
public class C4634d implements Callback {
    /* renamed from: a */
    private final C4621c f15119a;
    /* renamed from: b */
    private final C4596a f15120b;
    /* renamed from: c */
    private final C4635a f15121c;
    /* renamed from: d */
    private final int f15122d;
    /* renamed from: e */
    private final int f15123e;
    /* renamed from: f */
    private final int f15124f;
    /* renamed from: g */
    private long f15125g;
    /* renamed from: h */
    private Handler f15126h;
    /* renamed from: i */
    private HandlerThread f15127i;
    /* renamed from: j */
    private volatile boolean f15128j = false;
    /* renamed from: k */
    private volatile Thread f15129k;
    /* renamed from: l */
    private volatile long f15130l = 0;
    /* renamed from: m */
    private final AtomicLong f15131m = new AtomicLong();
    /* renamed from: n */
    private volatile boolean f15132n;
    /* renamed from: o */
    private boolean f15133o = true;

    /* renamed from: com.kwai.filedownloader.download.d$a */
    public static class C4635a {
        /* renamed from: a */
        private boolean f15134a;
        /* renamed from: b */
        private Exception f15135b;
        /* renamed from: c */
        private int f15136c;

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo25173a(int i) {
            this.f15136c = i;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo25174a(Exception exc) {
            this.f15135b = exc;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo25175a(boolean z) {
            this.f15134a = z;
        }

        /* renamed from: a */
        public boolean mo25176a() {
            return this.f15134a;
        }

        /* renamed from: b */
        public Exception mo25177b() {
            return this.f15135b;
        }

        /* renamed from: c */
        public int mo25178c() {
            return this.f15136c;
        }
    }

    C4634d(C4621c cVar, int i, int i2, int i3) {
        this.f15119a = cVar;
        this.f15120b = C4629b.m18995a().mo25145c();
        int i4 = 5;
        if (i2 >= 5) {
            i4 = i2;
        }
        this.f15123e = i4;
        this.f15124f = i3;
        this.f15121c = new C4635a();
        this.f15122d = i;
    }

    /* renamed from: a */
    private static long m19023a(long j, long j2) {
        if (j2 <= 0) {
            return -1;
        }
        if (j == -1) {
            return 1;
        }
        long j3 = j / (j2 + 1);
        if (j3 <= 0) {
            j3 = 1;
        }
        return j3;
    }

    /* renamed from: a */
    private void m19024a(byte b) {
        if (b == -2) {
            if (C4660d.f15179a) {
                C4660d.m19123c(this, "High concurrent cause, Already paused and we don't need to call-back to Task in here, %d", Integer.valueOf(this.f15119a.mo25071a()));
            }
            return;
        }
        C4698e.m19280a().mo25288a(C4701f.m19285a(b, this.f15119a, this.f15121c));
    }

    /* renamed from: a */
    private void m19025a(long j, boolean z) {
        if (this.f15119a.mo25089g() == this.f15119a.mo25090h()) {
            this.f15120b.mo24964a(this.f15119a.mo25071a(), this.f15119a.mo25089g());
            return;
        }
        if (this.f15132n) {
            this.f15132n = false;
            this.f15119a.mo25072a(3);
        }
        if (z) {
            this.f15130l = j;
            m19024a(3);
            this.f15131m.set(0);
        }
    }

    /* renamed from: a */
    private void m19026a(SQLiteFullException sQLiteFullException) {
        int a = this.f15119a.mo25071a();
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(a), sQLiteFullException.toString());
        }
        this.f15119a.mo25083c(sQLiteFullException.toString());
        this.f15119a.mo25072a(-1);
        this.f15120b.mo24977e(a);
        this.f15120b.mo24976d(a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
            return;
     */
    /* renamed from: a */
    private synchronized void m19027a(android.os.Message r5) {
        /*
        r4 = this;
        monitor-enter(r4)
        android.os.HandlerThread r0 = r4.f15127i     // Catch:{ all -> 0x0045 }
        boolean r0 = r0.isAlive()     // Catch:{ all -> 0x0045 }
        r1 = 0
        r2 = 1
        if (r0 != 0) goto L_0x0020
        boolean r0 = com.kwai.filedownloader.p358f.C4660d.f15179a     // Catch:{ all -> 0x0045 }
        if (r0 == 0) goto L_0x001e
        java.lang.String r0 = "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread."
        java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0045 }
        int r5 = r5.what     // Catch:{ all -> 0x0045 }
        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0045 }
        r2[r1] = r5     // Catch:{ all -> 0x0045 }
        com.kwai.filedownloader.p358f.C4660d.m19123c(r4, r0, r2)     // Catch:{ all -> 0x0045 }
    L_0x001e:
        monitor-exit(r4)
        return
    L_0x0020:
        android.os.Handler r0 = r4.f15126h     // Catch:{ IllegalStateException -> 0x0026 }
        r0.sendMessage(r5)     // Catch:{ IllegalStateException -> 0x0026 }
        goto L_0x0042
    L_0x0026:
        r0 = move-exception
        android.os.HandlerThread r3 = r4.f15127i     // Catch:{ all -> 0x0045 }
        boolean r3 = r3.isAlive()     // Catch:{ all -> 0x0045 }
        if (r3 != 0) goto L_0x0044
        boolean r0 = com.kwai.filedownloader.p358f.C4660d.f15179a     // Catch:{ all -> 0x0045 }
        if (r0 == 0) goto L_0x0042
        java.lang.String r0 = "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread."
        java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0045 }
        int r5 = r5.what     // Catch:{ all -> 0x0045 }
        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0045 }
        r2[r1] = r5     // Catch:{ all -> 0x0045 }
        com.kwai.filedownloader.p358f.C4660d.m19123c(r4, r0, r2)     // Catch:{ all -> 0x0045 }
    L_0x0042:
        monitor-exit(r4)
        return
    L_0x0044:
        throw r0     // Catch:{ all -> 0x0045 }
    L_0x0045:
        r5 = move-exception
        monitor-exit(r4)
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.download.C4634d.m19027a(android.os.Message):void");
    }

    /* renamed from: a */
    private void m19028a(Exception exc, int i) {
        Exception b = m19029b(exc);
        this.f15121c.mo25174a(b);
        this.f15121c.mo25173a(this.f15122d - i);
        this.f15119a.mo25072a(5);
        this.f15119a.mo25083c(b.toString());
        this.f15120b.mo24967a(this.f15119a.mo25071a(), (Throwable) b);
        m19024a(5);
    }

    /* renamed from: b */
    private Exception m19029b(Exception exc) {
        long j;
        String e = this.f15119a.mo25087e();
        if ((!this.f15119a.mo25091i() && !C4661e.m19127a().f15185f) || !(exc instanceof IOException) || !new File(e).exists()) {
            return exc;
        }
        long f = C4664f.m19157f(e);
        if (f > 4096) {
            return exc;
        }
        File file = new File(e);
        if (!file.exists()) {
            C4660d.m19121a((Object) this, (Throwable) exc, "Exception with: free space isn't enough, and the target file not exist.", new Object[0]);
            j = 0;
        } else {
            j = file.length();
        }
        if (VERSION.SDK_INT >= 9) {
            FileDownloadOutOfSpaceException fileDownloadOutOfSpaceException = new FileDownloadOutOfSpaceException(f, 4096, j, exc);
            return fileDownloadOutOfSpaceException;
        }
        FileDownloadOutOfSpaceException fileDownloadOutOfSpaceException2 = new FileDownloadOutOfSpaceException(f, 4096, j);
        return fileDownloadOutOfSpaceException2;
    }

    /* renamed from: b */
    private boolean m19030b(long j) {
        boolean z = true;
        if (this.f15133o) {
            this.f15133o = false;
            return true;
        }
        long j2 = j - this.f15130l;
        if (this.f15125g == -1 || this.f15131m.get() < this.f15125g || j2 < ((long) this.f15123e)) {
            z = false;
        }
        return z;
    }

    /* renamed from: c */
    private void m19031c(Exception exc) {
        Exception b = m19029b(exc);
        if (!(b instanceof SQLiteFullException)) {
            try {
                this.f15119a.mo25072a(-1);
                this.f15119a.mo25083c(exc.toString());
                this.f15120b.mo24968a(this.f15119a.mo25071a(), (Throwable) b, this.f15119a.mo25089g());
            } catch (SQLiteFullException e) {
                b = e;
            }
            this.f15121c.mo25174a(b);
            m19024a(-1);
        }
        m19026a((SQLiteFullException) b);
        this.f15121c.mo25174a(b);
        m19024a(-1);
    }

    /* renamed from: h */
    private void m19032h() {
        String str = "delete the temp file(%s) failed, on completed downloading.";
        String e = this.f15119a.mo25087e();
        String d = this.f15119a.mo25084d();
        File file = new File(e);
        try {
            File file2 = new File(d);
            if (file2.exists()) {
                long length = file2.length();
                if (file2.delete()) {
                    C4660d.m19124d(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", d, Long.valueOf(length), Long.valueOf(file.length()));
                } else {
                    throw new IOException(C4664f.m19135a("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", d, Long.valueOf(length)));
                }
            }
            if (!file.renameTo(file2)) {
                throw new IOException(C4664f.m19135a("Can't rename the  temp downloaded file(%s) to the target file(%s)", e, d));
            } else if (file.exists() && !file.delete()) {
                C4660d.m19124d(this, str, e);
            }
        } catch (Throwable th) {
            if (file.exists() && !file.delete()) {
                C4660d.m19124d(this, str, e);
            }
            throw th;
        }
    }

    /* renamed from: i */
    private void m19033i() {
        m19032h();
        this.f15119a.mo25072a(-3);
        this.f15120b.mo24973b(this.f15119a.mo25071a(), this.f15119a.mo25090h());
        this.f15120b.mo24976d(this.f15119a.mo25071a());
        m19024a(-3);
        if (C4661e.m19127a().f15186g) {
            C4736f.m19445a(this.f15119a);
        }
    }

    /* renamed from: j */
    private boolean m19034j() {
        if (this.f15119a.mo25091i()) {
            C4621c cVar = this.f15119a;
            cVar.mo25082c(cVar.mo25089g());
        } else if (this.f15119a.mo25089g() != this.f15119a.mo25090h()) {
            mo25162a((Exception) new FileDownloadGiveUpRetryException(C4664f.m19135a("sofar[%d] not equal total[%d]", Long.valueOf(this.f15119a.mo25089g()), Long.valueOf(this.f15119a.mo25090h()))));
            return true;
        }
        return false;
    }

    /* renamed from: k */
    private void m19035k() {
        this.f15119a.mo25072a(-2);
        this.f15120b.mo24975c(this.f15119a.mo25071a(), this.f15119a.mo25089g());
        m19024a(-2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo25161a(long j) {
        this.f15131m.addAndGet(j);
        this.f15119a.mo25079b(j);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean b = m19030b(elapsedRealtime);
        Handler handler = this.f15126h;
        if (handler == null) {
            m19025a(elapsedRealtime, b);
        } else if (b) {
            m19027a(handler.obtainMessage(3));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo25162a(Exception exc) {
        m19031c(exc);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo25163a(Exception exc, int i, long j) {
        this.f15131m.set(0);
        this.f15119a.mo25079b(-j);
        Handler handler = this.f15126h;
        if (handler == null) {
            m19028a(exc, i);
        } else {
            m19027a(handler.obtainMessage(5, i, 0, exc));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo25164a(boolean z, long j, String str, String str2) {
        String j2 = this.f15119a.mo25092j();
        if (j2 == null || j2.equals(str)) {
            this.f15121c.mo25175a(z);
            this.f15119a.mo25072a(2);
            this.f15119a.mo25082c(j);
            this.f15119a.mo25080b(str);
            this.f15119a.mo25085d(str2);
            this.f15120b.mo24965a(this.f15119a.mo25071a(), j, str, str2);
            m19024a(2);
            this.f15125g = m19023a(j, (long) this.f15124f);
            this.f15132n = true;
            return;
        }
        throw new IllegalArgumentException(C4664f.m19135a("callback onConnected must with precondition succeed, but the etag is changes(%s != %s)", str, j2));
    }

    /* renamed from: a */
    public boolean mo25165a() {
        HandlerThread handlerThread = this.f15127i;
        return handlerThread != null && handlerThread.isAlive();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo25166b() {
        Handler handler = this.f15126h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f15127i.quit();
            this.f15129k = Thread.currentThread();
            while (this.f15128j) {
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100));
            }
            this.f15129k = null;
        }
    }

    /* renamed from: c */
    public void mo25167c() {
        this.f15119a.mo25072a(1);
        this.f15120b.mo24978f(this.f15119a.mo25071a());
        m19024a(1);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo25168d() {
        this.f15119a.mo25072a(6);
        m19024a(6);
        this.f15120b.mo24961a(this.f15119a.mo25071a());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo25169e() {
        this.f15127i = new HandlerThread("source-status-callback", 10);
        this.f15127i.start();
        this.f15126h = new Handler(this.f15127i.getLooper(), this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo25170f() {
        m19035k();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo25171g() {
        if (!m19034j()) {
            m19033i();
        }
    }

    public boolean handleMessage(Message message) {
        this.f15128j = true;
        int i = message.what;
        if (i == 3) {
            m19025a(SystemClock.elapsedRealtime(), true);
        } else if (i == 5) {
            try {
                m19028a((Exception) message.obj, message.arg1);
            } catch (Throwable th) {
                this.f15128j = false;
                if (this.f15129k != null) {
                    LockSupport.unpark(this.f15129k);
                }
                throw th;
            }
        }
        this.f15128j = false;
        if (this.f15129k != null) {
            LockSupport.unpark(this.f15129k);
        }
        return true;
    }
}
