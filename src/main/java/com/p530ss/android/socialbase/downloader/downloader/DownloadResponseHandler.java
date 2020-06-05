package com.p530ss.android.socialbase.downloader.downloader;

import android.os.SystemClock;
import android.support.p000v4.media.session.PlaybackStateCompat;
import com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader;
import com.p530ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.p530ss.android.socialbase.downloader.impls.DownloadCache;
import com.p530ss.android.socialbase.downloader.impls.DownloadProxy;
import com.p530ss.android.socialbase.downloader.p556a.AppStatusManager;
import com.p530ss.android.socialbase.downloader.p558c.SqlDownloadCache;
import com.p530ss.android.socialbase.downloader.p562g.DownloadChunk;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p562g.RandomAccessOutputStream;
import com.p530ss.android.socialbase.downloader.p564i.IDownloadHttpConnection;
import com.p530ss.android.socialbase.downloader.p566j.AsyncStreamReader;
import com.p530ss.android.socialbase.downloader.p566j.IStreamReader;
import com.p530ss.android.socialbase.downloader.p566j.SyncStreamReader;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import com.p530ss.android.socialbase.downloader.p568l.IDownloadRunnableCallback;
import com.p530ss.android.socialbase.downloader.p569m.DownloadExpSwitchCode;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* renamed from: com.ss.android.socialbase.downloader.downloader.d */
public class DownloadResponseHandler {
    /* renamed from: a */
    private static String f21875a = "ResponseHandler";
    /* renamed from: b */
    private final DownloadInfo f21876b;
    /* renamed from: c */
    private final DownloadChunk f21877c;
    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final IDownloadHttpConnection f21878d;
    /* renamed from: e */
    private IDownloadCache f21879e;
    /* renamed from: f */
    private DownloadCache f21880f;
    /* renamed from: g */
    private ISqlDownloadCache f21881g;
    /* renamed from: h */
    private RandomAccessOutputStream f21882h;
    /* renamed from: i */
    private volatile boolean f21883i;
    /* renamed from: j */
    private volatile boolean f21884j;
    /* renamed from: k */
    private final IDownloadRunnableCallback f21885k;
    /* renamed from: l */
    private long f21886l;
    /* renamed from: m */
    private long f21887m;
    /* renamed from: n */
    private volatile long f21888n;
    /* renamed from: o */
    private volatile long f21889o;
    /* renamed from: p */
    private final boolean f21890p;
    /* renamed from: q */
    private final DownloadSetting f21891q;
    /* renamed from: r */
    private final AppStatusManager f21892r;
    /* renamed from: s */
    private final boolean f21893s;
    /* renamed from: t */
    private final long f21894t;
    /* renamed from: u */
    private final long f21895u;
    /* renamed from: v */
    private boolean f21896v;
    /* renamed from: w */
    private volatile long f21897w = 0;
    /* renamed from: x */
    private volatile long f21898x = 0;

    /* renamed from: b */
    private boolean m27434b(long j, long j2) {
        return j > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH && j2 > 500;
    }

    public DownloadResponseHandler(DownloadInfo cVar, IDownloadHttpConnection eVar, DownloadChunk bVar, IDownloadRunnableCallback eVar2) {
        this.f21876b = cVar;
        this.f21879e = C6694b.m27384p();
        IDownloadCache kVar = this.f21879e;
        if (kVar instanceof DefaultDownloadCache) {
            DefaultDownloadCache dVar = (DefaultDownloadCache) kVar;
            this.f21880f = dVar.mo32511a();
            this.f21881g = dVar.mo32512e();
        }
        this.f21878d = eVar;
        this.f21877c = bVar;
        this.f21885k = eVar2;
        this.f21886l = bVar.mo32136n();
        this.f21887m = this.f21886l;
        if (bVar.mo32125d()) {
            this.f21889o = bVar.mo32139q();
        } else {
            this.f21889o = bVar.mo32122c(false);
        }
        this.f21888n = bVar.mo32138p();
        this.f21892r = AppStatusManager.m26964a();
        this.f21891q = DownloadSetting.m28610a(cVar.mo32283g());
        boolean z = true;
        if (this.f21891q.mo32547a("sync_strategy", 0) != 1) {
            z = false;
        }
        this.f21893s = z;
        if (this.f21893s) {
            long a = (long) this.f21891q.mo32547a("sync_interval_ms_fg", (int) BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
            long a2 = (long) this.f21891q.mo32547a("sync_interval_ms_bg", 1000);
            if (a < 500) {
                a = 500;
            }
            this.f21894t = a;
            if (a2 < 500) {
                a2 = 500;
            }
            this.f21895u = a2;
        } else {
            this.f21894t = 0;
            this.f21895u = 0;
        }
        this.f21890p = DownloadExpSwitchCode.m28744a(65536);
    }

    /* renamed from: a */
    public long mo31888a() {
        return this.f21886l;
    }

    /* renamed from: f */
    private boolean m27435f() {
        return this.f21883i || this.f21884j;
    }

    /* renamed from: b */
    public void mo31891b() {
        if (!this.f21883i) {
            this.f21883i = true;
            m27436g();
        }
    }

    /* renamed from: c */
    public void mo31892c() {
        if (!this.f21884j) {
            synchronized (this.f21885k) {
                this.f21884j = true;
            }
            m27436g();
        }
    }

    /* renamed from: g */
    private void m27436g() {
        if (this.f21878d != null) {
            ExecutorService k = C6694b.m27379k();
            if (k != null) {
                k.execute(new Runnable() {
                    public void run() {
                        try {
                            DownloadResponseHandler.this.f21878d.mo16503d();
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        }
    }

    /* renamed from: a */
    public void mo31890a(long j, long j2, long j3) {
        this.f21886l = j;
        this.f21887m = j;
        this.f21888n = j2;
        this.f21889o = j3;
    }

    /* renamed from: a */
    public void mo31889a(long j, long j2) {
        this.f21888n = j;
        this.f21889o = j2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0206, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0207, code lost:
            r2 = r0;
            r0 = r1.f21882h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x020a, code lost:
            if (r0 != null) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:?, code lost:
            r0.mo32443b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0210, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0211, code lost:
            r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0215, code lost:
            throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x02c3, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x02c4, code lost:
            r2 = r0;
            r0 = r1.f21882h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x02c7, code lost:
            if (r0 != null) goto L_0x02c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:?, code lost:
            r0.mo32443b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x02cd, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x02ce, code lost:
            r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x02d2, code lost:
            throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x0335, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x0336, code lost:
            r2 = r0;
            r0 = r1.f21882h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x0339, code lost:
            if (r0 != null) goto L_0x033b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:?, code lost:
            r0.mo32443b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x033f, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x0340, code lost:
            r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x0344, code lost:
            throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x034f, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x0350, code lost:
            r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x0351, code lost:
            if (r8 != null) goto L_0x0353;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x0353, code lost:
            r8.mo32544b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x0358, code lost:
            if (r1.f21890p != false) goto L_0x035a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x035c, code lost:
            monitor-enter(r1.f21885k);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x035f, code lost:
            if (r1.f21884j == false) goto L_0x0361;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x0361, code lost:
            m27432a((com.p530ss.android.socialbase.downloader.downloader.IDownloadCache) r1.f21880f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x0368, code lost:
            if (r1.f21882h != null) goto L_0x036a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x036a, code lost:
            m27437h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x0372, code lost:
            m27432a((com.p530ss.android.socialbase.downloader.downloader.IDownloadCache) r1.f21880f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x0379, code lost:
            if (r1.f21882h != null) goto L_0x037b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x037b, code lost:
            m27437h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x037e, code lost:
            r0 = r1.f21882h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x0380, code lost:
            if (r0 != null) goto L_0x0382;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:?, code lost:
            r0.mo32443b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x0386, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:304:0x0387, code lost:
            r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x038b, code lost:
            throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x038c, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x038d, code lost:
            r2 = r0;
            r0 = r1.f21882h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x0390, code lost:
            if (r0 != null) goto L_0x0392;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:?, code lost:
            r0.mo32443b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:311:0x0396, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:0x0397, code lost:
            r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x039b, code lost:
            throw r2;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:136:0x01af, B:141:0x01d0, B:183:0x0229, B:235:0x02ff] */
    /* renamed from: d */
    public void mo31893d() throws com.p530ss.android.socialbase.downloader.p560e.BaseException {
        /*
        r16 = this;
        r1 = r16
        boolean r0 = r16.m27435f()
        if (r0 != 0) goto L_0x03a6
        com.ss.android.socialbase.downloader.g.b r0 = r1.f21877c
        if (r0 != 0) goto L_0x000e
        goto L_0x03a6
    L_0x000e:
        com.ss.android.socialbase.downloader.i.e r0 = r1.f21878d
        long r2 = com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28748a(r0)
        r4 = 0
        int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
        if (r0 == 0) goto L_0x039c
        com.ss.android.socialbase.downloader.g.b r0 = r1.f21877c
        long r6 = r0.mo32134l()
        r8 = 0
        r9 = 0
        com.ss.android.socialbase.downloader.g.c r0 = r1.f21876b     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        java.lang.String r0 = r0.mo32300l()     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        com.ss.android.socialbase.downloader.g.c r10 = r1.f21876b     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        java.lang.String r10 = r10.mo32303m()     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        com.ss.android.socialbase.downloader.k.a r11 = r1.f21891q     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        java.lang.String r12 = "flush_buffer_size_byte"
        r13 = -1
        int r11 = r11.mo32547a(r12, r13)     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        com.ss.android.socialbase.downloader.g.f r0 = com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28752a(r0, r10, r11)     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        r1.f21882h = r0     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        com.ss.android.socialbase.downloader.g.f r0 = r1.f21882h     // Catch:{ IOException -> 0x01a5 }
        long r10 = r1.f21886l     // Catch:{ IOException -> 0x01a5 }
        r0.mo32441a(r10)     // Catch:{ IOException -> 0x01a5 }
        com.ss.android.socialbase.downloader.i.e r0 = r1.f21878d     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        java.io.InputStream r0 = r0.mo16499a()     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        if (r0 == 0) goto L_0x0196
        com.ss.android.socialbase.downloader.g.c r10 = r1.f21876b     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        r10.mo32171Q()     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        com.ss.android.socialbase.downloader.j.c r8 = r1.m27431a(r0)     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        com.ss.android.socialbase.downloader.g.c r0 = r1.f21876b     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        boolean r10 = r1.f21896v     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        r0.mo32271d(r10)     // Catch:{ a -> 0x02d3, all -> 0x01ae }
    L_0x005c:
        boolean r0 = r16.m27435f()     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        if (r0 == 0) goto L_0x00ad
        if (r8 == 0) goto L_0x0067
        r8.mo32544b()
    L_0x0067:
        boolean r0 = r1.f21890p     // Catch:{ all -> 0x009d }
        if (r0 == 0) goto L_0x0083
        com.ss.android.socialbase.downloader.l.e r2 = r1.f21885k     // Catch:{ all -> 0x009d }
        monitor-enter(r2)     // Catch:{ all -> 0x009d }
        boolean r0 = r1.f21884j     // Catch:{ all -> 0x0080 }
        if (r0 != 0) goto L_0x007e
        com.ss.android.socialbase.downloader.impls.k r0 = r1.f21880f     // Catch:{ all -> 0x0080 }
        r1.m27432a(r0)     // Catch:{ all -> 0x0080 }
        com.ss.android.socialbase.downloader.g.f r0 = r1.f21882h     // Catch:{ all -> 0x0080 }
        if (r0 == 0) goto L_0x007e
        r16.m27437h()     // Catch:{ all -> 0x0080 }
    L_0x007e:
        monitor-exit(r2)     // Catch:{ all -> 0x0080 }
        goto L_0x008f
    L_0x0080:
        r0 = move-exception
        monitor-exit(r2)     // Catch:{ all -> 0x0080 }
        throw r0     // Catch:{ all -> 0x009d }
    L_0x0083:
        com.ss.android.socialbase.downloader.impls.k r0 = r1.f21880f     // Catch:{ all -> 0x009d }
        r1.m27432a(r0)     // Catch:{ all -> 0x009d }
        com.ss.android.socialbase.downloader.g.f r0 = r1.f21882h     // Catch:{ all -> 0x009d }
        if (r0 == 0) goto L_0x008f
        r16.m27437h()     // Catch:{ all -> 0x009d }
    L_0x008f:
        com.ss.android.socialbase.downloader.g.f r0 = r1.f21882h
        if (r0 == 0) goto L_0x009c
        r0.mo32443b()     // Catch:{ IOException -> 0x0097 }
        goto L_0x009c
    L_0x0097:
        r0 = move-exception
        r2 = r0
        r2.printStackTrace()
    L_0x009c:
        return
    L_0x009d:
        r0 = move-exception
        r2 = r0
        com.ss.android.socialbase.downloader.g.f r0 = r1.f21882h
        if (r0 == 0) goto L_0x00ac
        r0.mo32443b()     // Catch:{ IOException -> 0x00a7 }
        goto L_0x00ac
    L_0x00a7:
        r0 = move-exception
        r3 = r0
        r3.printStackTrace()
    L_0x00ac:
        throw r2
    L_0x00ad:
        com.ss.android.socialbase.downloader.j.b r0 = r8.mo32542a()     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        int r10 = r0.f22287b     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        if (r10 != r13) goto L_0x00b7
        goto L_0x013c
    L_0x00b7:
        com.ss.android.socialbase.downloader.g.c r11 = r1.f21876b     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        boolean r11 = r11.mo32176V()     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        if (r11 != 0) goto L_0x00e0
        long r11 = r1.f21889o     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        long r14 = r1.f21886l     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        long r4 = r1.f21887m     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        long r14 = r14 - r4
        int r4 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
        if (r4 <= 0) goto L_0x00e0
        long r4 = r1.f21889o     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        long r11 = r1.f21886l     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        long r14 = r1.f21887m     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        long r11 = r11 - r14
        long r14 = (long) r10     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        long r11 = r11 + r14
        int r14 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
        if (r14 >= 0) goto L_0x00e0
        long r4 = r1.f21889o     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        long r10 = r1.f21886l     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        long r14 = r1.f21887m     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        long r10 = r10 - r14
        long r4 = r4 - r10
        int r10 = (int) r4     // Catch:{ a -> 0x02d3, all -> 0x01ae }
    L_0x00e0:
        com.ss.android.socialbase.downloader.g.f r4 = r1.f21882h     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        byte[] r5 = r0.f22286a     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        r4.mo32442a(r5, r9, r10)     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        r8.mo32543a(r0)     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        long r4 = r1.f21886l     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        long r10 = (long) r10     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        long r4 = r4 + r10
        r1.f21886l = r4     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        com.ss.android.socialbase.downloader.l.e r4 = r1.f21885k     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        monitor-enter(r4)     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        boolean r0 = r1.f21890p     // Catch:{ all -> 0x0193 }
        if (r0 == 0) goto L_0x010a
        boolean r0 = r1.f21884j     // Catch:{ all -> 0x0193 }
        if (r0 != 0) goto L_0x0118
        com.ss.android.socialbase.downloader.l.e r0 = r1.f21885k     // Catch:{ all -> 0x0193 }
        boolean r0 = r0.mo32570a(r10)     // Catch:{ all -> 0x0193 }
        com.ss.android.socialbase.downloader.impls.k r5 = r1.f21880f     // Catch:{ all -> 0x0193 }
        r1.m27432a(r5)     // Catch:{ all -> 0x0193 }
        r1.m27433a(r0)     // Catch:{ all -> 0x0193 }
        goto L_0x0118
    L_0x010a:
        com.ss.android.socialbase.downloader.l.e r0 = r1.f21885k     // Catch:{ all -> 0x0193 }
        boolean r0 = r0.mo32570a(r10)     // Catch:{ all -> 0x0193 }
        com.ss.android.socialbase.downloader.impls.k r5 = r1.f21880f     // Catch:{ all -> 0x0193 }
        r1.m27432a(r5)     // Catch:{ all -> 0x0193 }
        r1.m27433a(r0)     // Catch:{ all -> 0x0193 }
    L_0x0118:
        monitor-exit(r4)     // Catch:{ all -> 0x0193 }
        com.ss.android.socialbase.downloader.g.c r0 = r1.f21876b     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        boolean r0 = r0.mo32198aA()     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        if (r0 == 0) goto L_0x018d
        com.ss.android.socialbase.downloader.g.c r0 = r1.f21876b     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        boolean r0 = r0.mo32176V()     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        if (r0 != 0) goto L_0x0189
        long r4 = r1.f21889o     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        r10 = 0
        int r0 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
        if (r0 < 0) goto L_0x0189
        long r4 = r1.f21889o     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        long r10 = r1.f21886l     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        long r14 = r1.f21887m     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        long r10 = r10 - r14
        int r0 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
        if (r0 > 0) goto L_0x0189
    L_0x013c:
        if (r8 == 0) goto L_0x0141
        r8.mo32544b()
    L_0x0141:
        boolean r0 = r1.f21890p     // Catch:{ all -> 0x0179 }
        if (r0 == 0) goto L_0x015d
        com.ss.android.socialbase.downloader.l.e r4 = r1.f21885k     // Catch:{ all -> 0x0179 }
        monitor-enter(r4)     // Catch:{ all -> 0x0179 }
        boolean r0 = r1.f21884j     // Catch:{ all -> 0x015a }
        if (r0 != 0) goto L_0x0158
        com.ss.android.socialbase.downloader.impls.k r0 = r1.f21880f     // Catch:{ all -> 0x015a }
        r1.m27432a(r0)     // Catch:{ all -> 0x015a }
        com.ss.android.socialbase.downloader.g.f r0 = r1.f21882h     // Catch:{ all -> 0x015a }
        if (r0 == 0) goto L_0x0158
        r16.m27437h()     // Catch:{ all -> 0x015a }
    L_0x0158:
        monitor-exit(r4)     // Catch:{ all -> 0x015a }
        goto L_0x0169
    L_0x015a:
        r0 = move-exception
        monitor-exit(r4)     // Catch:{ all -> 0x015a }
        throw r0     // Catch:{ all -> 0x0179 }
    L_0x015d:
        com.ss.android.socialbase.downloader.impls.k r0 = r1.f21880f     // Catch:{ all -> 0x0179 }
        r1.m27432a(r0)     // Catch:{ all -> 0x0179 }
        com.ss.android.socialbase.downloader.g.f r0 = r1.f21882h     // Catch:{ all -> 0x0179 }
        if (r0 == 0) goto L_0x0169
        r16.m27437h()     // Catch:{ all -> 0x0179 }
    L_0x0169:
        com.ss.android.socialbase.downloader.g.f r0 = r1.f21882h
        if (r0 == 0) goto L_0x0258
        r0.mo32443b()     // Catch:{ IOException -> 0x0172 }
        goto L_0x0258
    L_0x0172:
        r0 = move-exception
        r4 = r0
        r4.printStackTrace()
        goto L_0x0258
    L_0x0179:
        r0 = move-exception
        r2 = r0
        com.ss.android.socialbase.downloader.g.f r0 = r1.f21882h
        if (r0 == 0) goto L_0x0188
        r0.mo32443b()     // Catch:{ IOException -> 0x0183 }
        goto L_0x0188
    L_0x0183:
        r0 = move-exception
        r3 = r0
        r3.printStackTrace()
    L_0x0188:
        throw r2
    L_0x0189:
        r4 = 0
        goto L_0x005c
    L_0x018d:
        com.ss.android.socialbase.downloader.e.d r0 = new com.ss.android.socialbase.downloader.e.d     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        r0.m51549init()     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        throw r0     // Catch:{ a -> 0x02d3, all -> 0x01ae }
    L_0x0193:
        r0 = move-exception
        monitor-exit(r4)     // Catch:{ all -> 0x0193 }
        throw r0     // Catch:{ a -> 0x02d3, all -> 0x01ae }
    L_0x0196:
        com.ss.android.socialbase.downloader.e.a r0 = new com.ss.android.socialbase.downloader.e.a     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        r4 = 1042(0x412, float:1.46E-42)
        java.io.IOException r5 = new java.io.IOException     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        java.lang.String r10 = "inputStream is null"
        r5.<init>(r10)     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        r0.m51544init(r4, r5)     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        throw r0     // Catch:{ a -> 0x02d3, all -> 0x01ae }
    L_0x01a5:
        r0 = move-exception
        com.ss.android.socialbase.downloader.e.a r4 = new com.ss.android.socialbase.downloader.e.a     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        r5 = 1054(0x41e, float:1.477E-42)
        r4.m51544init(r5, r0)     // Catch:{ a -> 0x02d3, all -> 0x01ae }
        throw r4     // Catch:{ a -> 0x02d3, all -> 0x01ae }
    L_0x01ae:
        r0 = move-exception
        java.lang.String r4 = f21875a     // Catch:{ all -> 0x034f }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x034f }
        r5.<init>()     // Catch:{ all -> 0x034f }
        java.lang.String r10 = "handleResponse: e = "
        r5.append(r10)     // Catch:{ all -> 0x034f }
        r5.append(r0)     // Catch:{ all -> 0x034f }
        java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x034f }
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27761d(r4, r5)     // Catch:{ all -> 0x034f }
        boolean r4 = r16.m27435f()     // Catch:{ all -> 0x034f }
        if (r4 == 0) goto L_0x0216
        if (r8 == 0) goto L_0x01d0
        r8.mo32544b()
    L_0x01d0:
        boolean r0 = r1.f21890p     // Catch:{ all -> 0x0206 }
        if (r0 == 0) goto L_0x01ec
        com.ss.android.socialbase.downloader.l.e r2 = r1.f21885k     // Catch:{ all -> 0x0206 }
        monitor-enter(r2)     // Catch:{ all -> 0x0206 }
        boolean r0 = r1.f21884j     // Catch:{ all -> 0x01e9 }
        if (r0 != 0) goto L_0x01e7
        com.ss.android.socialbase.downloader.impls.k r0 = r1.f21880f     // Catch:{ all -> 0x01e9 }
        r1.m27432a(r0)     // Catch:{ all -> 0x01e9 }
        com.ss.android.socialbase.downloader.g.f r0 = r1.f21882h     // Catch:{ all -> 0x01e9 }
        if (r0 == 0) goto L_0x01e7
        r16.m27437h()     // Catch:{ all -> 0x01e9 }
    L_0x01e7:
        monitor-exit(r2)     // Catch:{ all -> 0x01e9 }
        goto L_0x01f8
    L_0x01e9:
        r0 = move-exception
        monitor-exit(r2)     // Catch:{ all -> 0x01e9 }
        throw r0     // Catch:{ all -> 0x0206 }
    L_0x01ec:
        com.ss.android.socialbase.downloader.impls.k r0 = r1.f21880f     // Catch:{ all -> 0x0206 }
        r1.m27432a(r0)     // Catch:{ all -> 0x0206 }
        com.ss.android.socialbase.downloader.g.f r0 = r1.f21882h     // Catch:{ all -> 0x0206 }
        if (r0 == 0) goto L_0x01f8
        r16.m27437h()     // Catch:{ all -> 0x0206 }
    L_0x01f8:
        com.ss.android.socialbase.downloader.g.f r0 = r1.f21882h
        if (r0 == 0) goto L_0x0205
        r0.mo32443b()     // Catch:{ IOException -> 0x0200 }
        goto L_0x0205
    L_0x0200:
        r0 = move-exception
        r2 = r0
        r2.printStackTrace()
    L_0x0205:
        return
    L_0x0206:
        r0 = move-exception
        r2 = r0
        com.ss.android.socialbase.downloader.g.f r0 = r1.f21882h
        if (r0 == 0) goto L_0x0215
        r0.mo32443b()     // Catch:{ IOException -> 0x0210 }
        goto L_0x0215
    L_0x0210:
        r0 = move-exception
        r3 = r0
        r3.printStackTrace()
    L_0x0215:
        throw r2
    L_0x0216:
        boolean r4 = com.p530ss.android.socialbase.downloader.p561f.C6704a.m27756a()     // Catch:{ all -> 0x034f }
        if (r4 == 0) goto L_0x021f
        r0.printStackTrace()     // Catch:{ all -> 0x034f }
    L_0x021f:
        java.lang.String r4 = "DownloadResponseHandler"
        com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28768a(r0, r4)     // Catch:{ all -> 0x034f }
        if (r8 == 0) goto L_0x0229
        r8.mo32544b()
    L_0x0229:
        boolean r0 = r1.f21890p     // Catch:{ all -> 0x02c3 }
        if (r0 == 0) goto L_0x0245
        com.ss.android.socialbase.downloader.l.e r4 = r1.f21885k     // Catch:{ all -> 0x02c3 }
        monitor-enter(r4)     // Catch:{ all -> 0x02c3 }
        boolean r0 = r1.f21884j     // Catch:{ all -> 0x0242 }
        if (r0 != 0) goto L_0x0240
        com.ss.android.socialbase.downloader.impls.k r0 = r1.f21880f     // Catch:{ all -> 0x0242 }
        r1.m27432a(r0)     // Catch:{ all -> 0x0242 }
        com.ss.android.socialbase.downloader.g.f r0 = r1.f21882h     // Catch:{ all -> 0x0242 }
        if (r0 == 0) goto L_0x0240
        r16.m27437h()     // Catch:{ all -> 0x0242 }
    L_0x0240:
        monitor-exit(r4)     // Catch:{ all -> 0x0242 }
        goto L_0x0251
    L_0x0242:
        r0 = move-exception
        monitor-exit(r4)     // Catch:{ all -> 0x0242 }
        throw r0     // Catch:{ all -> 0x02c3 }
    L_0x0245:
        com.ss.android.socialbase.downloader.impls.k r0 = r1.f21880f     // Catch:{ all -> 0x02c3 }
        r1.m27432a(r0)     // Catch:{ all -> 0x02c3 }
        com.ss.android.socialbase.downloader.g.f r0 = r1.f21882h     // Catch:{ all -> 0x02c3 }
        if (r0 == 0) goto L_0x0251
        r16.m27437h()     // Catch:{ all -> 0x02c3 }
    L_0x0251:
        com.ss.android.socialbase.downloader.g.f r0 = r1.f21882h
        if (r0 == 0) goto L_0x0258
        r0.mo32443b()     // Catch:{ IOException -> 0x0172 }
    L_0x0258:
        com.ss.android.socialbase.downloader.g.c r0 = r1.f21876b
        boolean r0 = r0.mo32176V()
        if (r0 == 0) goto L_0x0261
        return
    L_0x0261:
        long r4 = r1.f21886l
        long r10 = r1.f21887m
        long r4 = r4 - r10
        r10 = 0
        int r0 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
        if (r0 < 0) goto L_0x02c2
        long r12 = r1.f21889o
        int r0 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
        if (r0 < 0) goto L_0x02c2
        long r10 = r1.f21889o
        int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
        if (r0 != 0) goto L_0x0279
        goto L_0x02c2
    L_0x0279:
        com.ss.android.socialbase.downloader.e.a r0 = new com.ss.android.socialbase.downloader.e.a
        r8 = 1051(0x41b, float:1.473E-42)
        r10 = 7
        java.lang.Object[] r10 = new java.lang.Object[r10]
        java.lang.Long r4 = java.lang.Long.valueOf(r4)
        r10[r9] = r4
        r4 = 1
        java.lang.Long r2 = java.lang.Long.valueOf(r2)
        r10[r4] = r2
        r2 = 2
        long r3 = r1.f21889o
        java.lang.Long r3 = java.lang.Long.valueOf(r3)
        r10[r2] = r3
        r2 = 3
        java.lang.Long r3 = java.lang.Long.valueOf(r6)
        r10[r2] = r3
        r2 = 4
        long r3 = r1.f21888n
        java.lang.Long r3 = java.lang.Long.valueOf(r3)
        r10[r2] = r3
        r2 = 5
        long r3 = r1.f21886l
        java.lang.Long r3 = java.lang.Long.valueOf(r3)
        r10[r2] = r3
        r2 = 6
        long r3 = r1.f21887m
        java.lang.Long r3 = java.lang.Long.valueOf(r3)
        r10[r2] = r3
        java.lang.String r2 = "handle data length[%d] != content length[%d] downloadChunkContentLen[%d], range[%d, %d) , current offset[%d] , handle start from %d"
        java.lang.String r2 = java.lang.String.format(r2, r10)
        r0.m51543init(r8, r2)
        throw r0
    L_0x02c2:
        return
    L_0x02c3:
        r0 = move-exception
        r2 = r0
        com.ss.android.socialbase.downloader.g.f r0 = r1.f21882h
        if (r0 == 0) goto L_0x02d2
        r0.mo32443b()     // Catch:{ IOException -> 0x02cd }
        goto L_0x02d2
    L_0x02cd:
        r0 = move-exception
        r3 = r0
        r3.printStackTrace()
    L_0x02d2:
        throw r2
    L_0x02d3:
        r0 = move-exception
        java.lang.String r2 = f21875a     // Catch:{ all -> 0x034f }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x034f }
        r3.<init>()     // Catch:{ all -> 0x034f }
        java.lang.String r4 = "handleResponse: BaseException e = "
        r3.append(r4)     // Catch:{ all -> 0x034f }
        r3.append(r0)     // Catch:{ all -> 0x034f }
        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x034f }
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27761d(r2, r3)     // Catch:{ all -> 0x034f }
        com.ss.android.socialbase.downloader.k.a r2 = r1.f21891q     // Catch:{ all -> 0x034f }
        java.lang.String r3 = "ignore_base_ex_on_stop_status"
        boolean r2 = r2.mo32550a(r3)     // Catch:{ all -> 0x034f }
        if (r2 == 0) goto L_0x0345
        boolean r2 = r16.m27435f()     // Catch:{ all -> 0x034f }
        if (r2 == 0) goto L_0x0345
        if (r8 == 0) goto L_0x02ff
        r8.mo32544b()
    L_0x02ff:
        boolean r0 = r1.f21890p     // Catch:{ all -> 0x0335 }
        if (r0 == 0) goto L_0x031b
        com.ss.android.socialbase.downloader.l.e r2 = r1.f21885k     // Catch:{ all -> 0x0335 }
        monitor-enter(r2)     // Catch:{ all -> 0x0335 }
        boolean r0 = r1.f21884j     // Catch:{ all -> 0x0318 }
        if (r0 != 0) goto L_0x0316
        com.ss.android.socialbase.downloader.impls.k r0 = r1.f21880f     // Catch:{ all -> 0x0318 }
        r1.m27432a(r0)     // Catch:{ all -> 0x0318 }
        com.ss.android.socialbase.downloader.g.f r0 = r1.f21882h     // Catch:{ all -> 0x0318 }
        if (r0 == 0) goto L_0x0316
        r16.m27437h()     // Catch:{ all -> 0x0318 }
    L_0x0316:
        monitor-exit(r2)     // Catch:{ all -> 0x0318 }
        goto L_0x0327
    L_0x0318:
        r0 = move-exception
        monitor-exit(r2)     // Catch:{ all -> 0x0318 }
        throw r0     // Catch:{ all -> 0x0335 }
    L_0x031b:
        com.ss.android.socialbase.downloader.impls.k r0 = r1.f21880f     // Catch:{ all -> 0x0335 }
        r1.m27432a(r0)     // Catch:{ all -> 0x0335 }
        com.ss.android.socialbase.downloader.g.f r0 = r1.f21882h     // Catch:{ all -> 0x0335 }
        if (r0 == 0) goto L_0x0327
        r16.m27437h()     // Catch:{ all -> 0x0335 }
    L_0x0327:
        com.ss.android.socialbase.downloader.g.f r0 = r1.f21882h
        if (r0 == 0) goto L_0x0334
        r0.mo32443b()     // Catch:{ IOException -> 0x032f }
        goto L_0x0334
    L_0x032f:
        r0 = move-exception
        r2 = r0
        r2.printStackTrace()
    L_0x0334:
        return
    L_0x0335:
        r0 = move-exception
        r2 = r0
        com.ss.android.socialbase.downloader.g.f r0 = r1.f21882h
        if (r0 == 0) goto L_0x0344
        r0.mo32443b()     // Catch:{ IOException -> 0x033f }
        goto L_0x0344
    L_0x033f:
        r0 = move-exception
        r3 = r0
        r3.printStackTrace()
    L_0x0344:
        throw r2
    L_0x0345:
        boolean r2 = com.p530ss.android.socialbase.downloader.p561f.C6704a.m27756a()     // Catch:{ all -> 0x034f }
        if (r2 == 0) goto L_0x034e
        r0.printStackTrace()     // Catch:{ all -> 0x034f }
    L_0x034e:
        throw r0     // Catch:{ all -> 0x034f }
    L_0x034f:
        r0 = move-exception
        r2 = r0
        if (r8 == 0) goto L_0x0356
        r8.mo32544b()
    L_0x0356:
        boolean r0 = r1.f21890p     // Catch:{ all -> 0x038c }
        if (r0 == 0) goto L_0x0372
        com.ss.android.socialbase.downloader.l.e r3 = r1.f21885k     // Catch:{ all -> 0x038c }
        monitor-enter(r3)     // Catch:{ all -> 0x038c }
        boolean r0 = r1.f21884j     // Catch:{ all -> 0x036f }
        if (r0 != 0) goto L_0x036d
        com.ss.android.socialbase.downloader.impls.k r0 = r1.f21880f     // Catch:{ all -> 0x036f }
        r1.m27432a(r0)     // Catch:{ all -> 0x036f }
        com.ss.android.socialbase.downloader.g.f r0 = r1.f21882h     // Catch:{ all -> 0x036f }
        if (r0 == 0) goto L_0x036d
        r16.m27437h()     // Catch:{ all -> 0x036f }
    L_0x036d:
        monitor-exit(r3)     // Catch:{ all -> 0x036f }
        goto L_0x037e
    L_0x036f:
        r0 = move-exception
        monitor-exit(r3)     // Catch:{ all -> 0x036f }
        throw r0     // Catch:{ all -> 0x038c }
    L_0x0372:
        com.ss.android.socialbase.downloader.impls.k r0 = r1.f21880f     // Catch:{ all -> 0x038c }
        r1.m27432a(r0)     // Catch:{ all -> 0x038c }
        com.ss.android.socialbase.downloader.g.f r0 = r1.f21882h     // Catch:{ all -> 0x038c }
        if (r0 == 0) goto L_0x037e
        r16.m27437h()     // Catch:{ all -> 0x038c }
    L_0x037e:
        com.ss.android.socialbase.downloader.g.f r0 = r1.f21882h
        if (r0 == 0) goto L_0x038b
        r0.mo32443b()     // Catch:{ IOException -> 0x0386 }
        goto L_0x038b
    L_0x0386:
        r0 = move-exception
        r3 = r0
        r3.printStackTrace()
    L_0x038b:
        throw r2
    L_0x038c:
        r0 = move-exception
        r2 = r0
        com.ss.android.socialbase.downloader.g.f r0 = r1.f21882h
        if (r0 == 0) goto L_0x039b
        r0.mo32443b()     // Catch:{ IOException -> 0x0396 }
        goto L_0x039b
    L_0x0396:
        r0 = move-exception
        r3 = r0
        r3.printStackTrace()
    L_0x039b:
        throw r2
    L_0x039c:
        com.ss.android.socialbase.downloader.e.f r0 = new com.ss.android.socialbase.downloader.e.f
        r2 = 1004(0x3ec, float:1.407E-42)
        java.lang.String r3 = "the content-length is 0"
        r0.m51551init(r2, r3)
        throw r0
    L_0x03a6:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.downloader.DownloadResponseHandler.mo31893d():void");
    }

    /* renamed from: a */
    private IStreamReader m27431a(InputStream inputStream) {
        int w = C6694b.m27391w();
        if (this.f21891q.mo32547a("rw_concurrent", 0) == 1 && this.f21876b.mo32219aV() == 1 && this.f21876b.mo32225ab() > 20971520) {
            try {
                AsyncStreamReader aVar = new AsyncStreamReader(inputStream, w, this.f21891q.mo32547a("rw_concurrent_max_buffer_count", 4));
                this.f21896v = true;
                return aVar;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        SyncStreamReader eVar = new SyncStreamReader(inputStream, w);
        this.f21896v = false;
        return eVar;
    }

    /* renamed from: a */
    private void m27433a(boolean z) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = uptimeMillis - this.f21898x;
        if (this.f21893s) {
            if (j > (this.f21892r.mo31648c() ? this.f21894t : this.f21895u)) {
                m27437h();
                this.f21898x = uptimeMillis;
                return;
            }
            return;
        }
        long j2 = this.f21886l - this.f21897w;
        if (z || m27434b(j2, j)) {
            m27437h();
            this.f21898x = uptimeMillis;
        }
    }

    /* renamed from: e */
    public long mo31894e() {
        return this.f21897w;
    }

    /* renamed from: h */
    private void m27437h() {
        boolean z;
        boolean z2 = false;
        try {
            this.f21882h.mo32440a();
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            this.f21876b.mo32277e(true);
            if (this.f21876b.mo32219aV() > 1) {
                z2 = true;
            }
            IDownloadProxy a = DownloadProxy.m28368a(DownloadUtils.m28789b());
            if (z2) {
                m27432a((IDownloadCache) this.f21881g);
                if (a != null) {
                    a.mo32044c(this.f21876b);
                } else {
                    this.f21881g.mo31665a(this.f21876b.mo32283g(), this.f21876b.mo32180Z());
                }
            } else if (a != null) {
                a.mo32044c(this.f21876b);
            } else {
                this.f21881g.mo31665a(this.f21877c.mo32133k(), this.f21886l);
            }
            this.f21897w = this.f21886l;
        }
    }

    /* renamed from: a */
    private void m27432a(IDownloadCache kVar) {
        DownloadChunk bVar;
        DownloadChunk bVar2;
        IDownloadCache kVar2 = kVar;
        if (kVar2 != null) {
            IDownloadProxy nVar = null;
            boolean z = kVar2 instanceof SqlDownloadCache;
            if (z) {
                nVar = DownloadProxy.m28368a(DownloadUtils.m28789b());
                if (nVar == null) {
                    return;
                }
            }
            IDownloadProxy nVar2 = nVar;
            if (this.f21877c.mo32125d()) {
                bVar = this.f21877c.mo32127e();
            } else {
                bVar = this.f21877c;
            }
            DownloadChunk bVar3 = bVar;
            if (bVar3 != null) {
                bVar3.mo32120b(this.f21886l);
                if (!z || nVar2 == null) {
                    bVar2 = bVar3;
                    kVar.mo31670a(bVar3.mo32133k(), bVar3.mo32141s(), bVar3.mo32118b(), this.f21886l);
                } else {
                    nVar2.mo32018a(bVar3.mo32133k(), bVar3.mo32141s(), bVar3.mo32118b(), this.f21886l);
                    bVar2 = bVar3;
                }
                if (bVar2.mo32130h()) {
                    boolean z2 = false;
                    if (bVar2.mo32131i()) {
                        long j = bVar2.mo32132j();
                        if (j > this.f21886l) {
                            if (!z || nVar2 == null) {
                                kVar2.mo31671a(bVar2.mo32133k(), bVar2.mo32118b(), j);
                            } else {
                                nVar2.mo32019a(bVar2.mo32133k(), bVar2.mo32118b(), j);
                            }
                            z2 = true;
                        }
                    }
                    if (!z2) {
                        if (!z || nVar2 == null) {
                            kVar2.mo31671a(bVar2.mo32133k(), bVar2.mo32118b(), this.f21886l);
                        } else {
                            nVar2.mo32019a(bVar2.mo32133k(), bVar2.mo32118b(), this.f21886l);
                        }
                    }
                }
            } else if (this.f21877c.mo32125d()) {
                if (!z || nVar2 == null) {
                    kVar2.mo31671a(this.f21877c.mo32133k(), this.f21877c.mo32141s(), this.f21886l);
                } else {
                    nVar2.mo32019a(this.f21877c.mo32133k(), this.f21877c.mo32141s(), this.f21886l);
                }
            }
        }
    }
}
