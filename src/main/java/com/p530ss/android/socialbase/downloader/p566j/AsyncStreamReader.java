package com.p530ss.android.socialbase.downloader.p566j;

import android.os.Process;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import java.io.InputStream;
import java.util.concurrent.Future;

/* renamed from: com.ss.android.socialbase.downloader.j.a */
public class AsyncStreamReader implements IStreamReader {
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final InputStream f22268a;
    /* renamed from: b */
    private final int f22269b;
    /* renamed from: c */
    private final int f22270c;
    /* renamed from: d */
    private final Object f22271d = new Object();
    /* access modifiers changed from: private|final */
    /* renamed from: e */
    public final Object f22272e = new Object();
    /* renamed from: f */
    private C6744b f22273f;
    /* renamed from: g */
    private C6744b f22274g;
    /* renamed from: h */
    private C6744b f22275h;
    /* renamed from: i */
    private C6744b f22276i;
    /* renamed from: j */
    private C6744b f22277j;
    /* renamed from: k */
    private C6744b f22278k;
    /* renamed from: l */
    private volatile boolean f22279l;
    /* access modifiers changed from: private|volatile */
    /* renamed from: m */
    public volatile boolean f22280m;
    /* access modifiers changed from: private|volatile */
    /* renamed from: n */
    public volatile Throwable f22281n;
    /* renamed from: o */
    private volatile Future f22282o;
    /* renamed from: p */
    private int f22283p;
    /* renamed from: q */
    private final Runnable f22284q = new Runnable() {
        public void run() {
            AsyncStreamReader aVar;
            C6744b a;
            Process.setThreadPriority(10);
            do {
                try {
                    a = AsyncStreamReader.this.m28598d();
                    a.f22287b = AsyncStreamReader.this.f22268a.read(a.f22286a);
                    AsyncStreamReader.this.m28597c(a);
                } catch (Throwable unused) {
                    return;
                }
            } while (a.f22287b != -1);
            synchronized (AsyncStreamReader.this.f22272e) {
                AsyncStreamReader.this.f22280m = true;
                AsyncStreamReader.this.f22272e.notify();
            }
            aVar = AsyncStreamReader.this;
            aVar.f22268a.close();
        }
    };

    public AsyncStreamReader(InputStream inputStream, int i, int i2) throws Throwable {
        this.f22268a = inputStream;
        this.f22269b = i;
        int i3 = 64;
        if (i2 < 1) {
            i3 = 1;
        } else if (i2 <= 64) {
            i3 = i2;
        }
        this.f22270c = i3;
        m28596c();
    }

    /* renamed from: a */
    public C6744b mo32542a() throws BaseException, InterruptedException {
        return m28599e();
    }

    /* renamed from: a */
    public void mo32543a(C6744b bVar) {
        m28594b(bVar);
    }

    /* renamed from: b */
    public void mo32544b() {
        synchronized (this.f22271d) {
            this.f22279l = true;
            this.f22271d.notify();
        }
        Future future = this.f22282o;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable unused) {
            }
            this.f22282o = null;
        }
    }

    /* renamed from: c */
    private void m28596c() throws Throwable {
        this.f22282o = C6694b.m27380l().submit(this.f22284q);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public C6744b m28598d() throws StreamClosedException, InterruptedException {
        C6744b bVar = this.f22275h;
        if (bVar == null) {
            synchronized (this.f22271d) {
                if (!this.f22279l) {
                    C6744b bVar2 = this.f22273f;
                    if (bVar2 != null || this.f22283p >= this.f22270c) {
                        while (bVar2 == null) {
                            this.f22271d.wait();
                            if (!this.f22279l) {
                                bVar2 = this.f22273f;
                            } else {
                                throw new StreamClosedException();
                            }
                        }
                        this.f22275h = bVar2.f22288c;
                        this.f22274g = null;
                        this.f22273f = null;
                        bVar2.f22288c = null;
                        return bVar2;
                    }
                    this.f22283p++;
                    C6744b bVar3 = new C6744b(this.f22269b);
                    return bVar3;
                }
                throw new StreamClosedException();
            }
        } else if (!this.f22279l) {
            this.f22275h = bVar.f22288c;
            bVar.f22288c = null;
            return bVar;
        } else {
            throw new StreamClosedException();
        }
    }

    /* renamed from: b */
    private void m28594b(C6744b bVar) {
        synchronized (this.f22271d) {
            C6744b bVar2 = this.f22274g;
            if (bVar2 == null) {
                this.f22274g = bVar;
                this.f22273f = bVar;
                this.f22271d.notify();
            } else {
                bVar2.f22288c = bVar;
                this.f22274g = bVar;
            }
        }
    }

    /* renamed from: e */
    private C6744b m28599e() throws BaseException, InterruptedException {
        C6744b bVar;
        C6744b bVar2 = this.f22278k;
        if (bVar2 != null) {
            this.f22278k = bVar2.f22288c;
            bVar2.f22288c = null;
            return bVar2;
        }
        synchronized (this.f22272e) {
            bVar = this.f22276i;
            if (bVar == null) {
                do {
                    if (this.f22280m) {
                        m28600f();
                    }
                    this.f22272e.wait();
                    bVar = this.f22276i;
                } while (bVar == null);
            }
            this.f22278k = bVar.f22288c;
            this.f22277j = null;
            this.f22276i = null;
            bVar.f22288c = null;
        }
        return bVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m28597c(C6744b bVar) {
        synchronized (this.f22272e) {
            C6744b bVar2 = this.f22277j;
            if (bVar2 == null) {
                this.f22277j = bVar;
                this.f22276i = bVar;
                this.f22272e.notify();
            } else {
                bVar2.f22288c = bVar;
                this.f22277j = bVar;
            }
        }
    }

    /* renamed from: f */
    private void m28600f() throws BaseException {
        Throwable th = this.f22281n;
        if (th != null) {
            if (th instanceof StreamClosedException) {
                throw new BaseException(1068, "async reader closed!");
            }
            DownloadUtils.m28768a(th, "async_read");
        }
        throw new BaseException(1069, "async reader terminated!");
    }
}
