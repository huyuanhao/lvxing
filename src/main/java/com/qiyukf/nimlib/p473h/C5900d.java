package com.qiyukf.nimlib.p473h;

import android.content.Context;
import android.os.SystemClock;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.p417d.C5411c;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.C5743d;
import com.qiyukf.nimlib.p473h.C5885c.C5887a;
import com.qiyukf.nimlib.p473h.p478b.C5878c.C5879a;
import com.qiyukf.nimlib.p473h.p478b.p480b.C5874a;
import com.qiyukf.nimlib.sdk.StatusCode;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.qiyukf.nimlib.h.d */
final class C5900d {
    /* renamed from: a */
    private final int f18655a = 0;
    /* renamed from: b */
    private final int f18656b = 1;
    /* renamed from: c */
    private Timer f18657c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public AtomicInteger f18658d = new AtomicInteger();
    /* renamed from: e */
    private C5885c f18659e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public C5904a f18660f;
    /* renamed from: g */
    private boolean f18661g = false;
    /* renamed from: h */
    private AtomicInteger f18662h = new AtomicInteger(0);
    /* renamed from: i */
    private long f18663i = SystemClock.elapsedRealtime();

    /* renamed from: com.qiyukf.nimlib.h.d$3 */
    static /* synthetic */ class C59033 {
        /* renamed from: a */
        static final /* synthetic */ int[] f18666a = new int[C5879a.m23544a().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0011 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
            int[] r0 = com.qiyukf.nimlib.p473h.p478b.C5878c.C5879a.m23544a()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f18666a = r0
            r0 = 1
            int[] r1 = f18666a     // Catch:{ NoSuchFieldError -> 0x0011 }
            int r2 = com.qiyukf.nimlib.p473h.p478b.C5878c.C5879a.f18612e     // Catch:{ NoSuchFieldError -> 0x0011 }
            int r2 = r2 - r0
            r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0011 }
        L_0x0011:
            int[] r1 = f18666a     // Catch:{ NoSuchFieldError -> 0x0019 }
            int r2 = com.qiyukf.nimlib.p473h.p478b.C5878c.C5879a.f18613f     // Catch:{ NoSuchFieldError -> 0x0019 }
            int r2 = r2 - r0
            r3 = 2
            r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0019 }
        L_0x0019:
            int[] r1 = f18666a     // Catch:{ NoSuchFieldError -> 0x0021 }
            int r2 = com.qiyukf.nimlib.p473h.p478b.C5878c.C5879a.f18611d     // Catch:{ NoSuchFieldError -> 0x0021 }
            int r2 = r2 - r0
            r0 = 3
            r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0021 }
        L_0x0021:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p473h.C5900d.C59033.m50080clinit():void");
        }
    }

    /* renamed from: com.qiyukf.nimlib.h.d$a */
    public interface C5904a {
        /* renamed from: b */
        void mo28184b();

        /* renamed from: c */
        void mo28186c();
    }

    public C5900d(C5904a aVar) {
        this.f18660f = aVar;
    }

    /* renamed from: a */
    static /* synthetic */ void m23631a(C5900d dVar) {
        boolean z = SystemClock.elapsedRealtime() - dVar.f18663i > 900;
        boolean z2 = dVar.f18661g;
        dVar.f18661g = C5411c.m22139f(C5718b.m23009a());
        boolean z3 = dVar.f18661g;
        if (z3 || z2 != z3) {
            C5874a.m23528a().mo28200d();
        }
        String str = "core";
        if (dVar.f18657c == null || C5743d.m23116b() || z) {
            C5264a.m21617a(str, "network available, login");
            dVar.m23637e();
            return;
        }
        C5264a.m21617a(str, "background mode, wait for timer");
    }

    /* renamed from: c */
    private void m23634c() {
        if (this.f18662h.get() != 0 && this.f18657c == null) {
            int abs = Math.abs(new Random().nextInt() % 10);
            int i = (abs + 10) * 1000;
            this.f18658d.set(0);
            this.f18657c = new Timer();
            this.f18657c.schedule(new TimerTask() {
                /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
            if ((r1 & (r1 - 1)) == 0) goto L_0x0024;
     */
                public final void run() {
                    /*
                    r6 = this;
                    java.lang.String r0 = "core"
                    com.qiyukf.nimlib.h.d r1 = com.qiyukf.nimlib.p473h.C5900d.this     // Catch:{ all -> 0x003b }
                    java.util.concurrent.atomic.AtomicInteger r1 = r1.f18658d     // Catch:{ all -> 0x003b }
                    int r1 = r1.incrementAndGet()     // Catch:{ all -> 0x003b }
                    boolean r2 = com.qiyukf.nimlib.C5743d.m23116b()     // Catch:{ all -> 0x003b }
                    if (r2 == 0) goto L_0x0015
                    r2 = 16
                    goto L_0x0017
                L_0x0015:
                    r2 = 64
                L_0x0017:
                    r3 = 0
                    r4 = 1
                    if (r1 <= 0) goto L_0x002b
                    int r5 = r2 << 1
                    if (r1 >= r5) goto L_0x0026
                    int r2 = r1 + -1
                    r1 = r1 & r2
                    if (r1 != 0) goto L_0x002b
                L_0x0024:
                    r3 = 1
                    goto L_0x002b
                L_0x0026:
                    int r1 = r1 % r2
                    int r2 = r2 - r4
                    if (r1 != r2) goto L_0x002b
                    goto L_0x0024
                L_0x002b:
                    if (r3 == 0) goto L_0x003a
                    com.qiyukf.nimlib.h.d r1 = com.qiyukf.nimlib.p473h.C5900d.this     // Catch:{ all -> 0x003b }
                    boolean r1 = r1.m23637e()     // Catch:{ all -> 0x003b }
                    if (r1 == 0) goto L_0x003a
                    java.lang.String r1 = "relogin because of reconnect timer"
                    com.qiyukf.basesdk.p393a.C5264a.m21624d(r0, r1)     // Catch:{ all -> 0x003b }
                L_0x003a:
                    return
                L_0x003b:
                    r1 = move-exception
                    java.lang.String r2 = "reconnect error"
                    com.qiyukf.basesdk.p393a.C5264a.m21621b(r0, r2, r1)
                    return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p473h.C5900d.C59022.run():void");
                }
            }, (long) (((abs / 2) + 5) * 1000), (long) i);
        }
    }

    /* renamed from: d */
    private void m23635d() {
        Timer timer = this.f18657c;
        if (timer != null) {
            timer.cancel();
            this.f18657c = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m23637e() {
        C5885c cVar = this.f18659e;
        boolean z = cVar != null && cVar.mo28216a();
        if (!z) {
            C5264a.m21620b("core", "network is not available");
            return false;
        }
        this.f18660f.mo28184b();
        this.f18663i = SystemClock.elapsedRealtime();
        return true;
    }

    /* renamed from: a */
    public final void mo28271a() {
        C5264a.m21620b("test", "networkKeeper shutdown");
        if (this.f18662h.compareAndSet(1, 0)) {
            C5885c cVar = this.f18659e;
            if (cVar != null) {
                cVar.mo28218c();
                this.f18659e = null;
            }
            m23635d();
        }
    }

    /* renamed from: a */
    public final void mo28272a(Context context) {
        if (this.f18662h.compareAndSet(0, 1)) {
            C5264a.m21620b("test", "networkKeeper startup");
            if (this.f18659e == null) {
                this.f18659e = new C5885c(context, new C5887a() {
                    /* renamed from: a */
                    public final void mo28220a(int i) {
                        int i2 = C59033.f18666a[i - 1];
                        if (i2 != 1) {
                            if (i2 != 2) {
                                if (i2 == 3) {
                                    C5900d.this.f18660f.mo28186c();
                                }
                                return;
                            }
                            C5900d.this.f18660f.mo28186c();
                        }
                        C5900d.m23631a(C5900d.this);
                    }
                });
                this.f18659e.mo28217b();
            }
        }
    }

    /* renamed from: a */
    public final void mo28273a(StatusCode statusCode) {
        if (this.f18662h.get() == 1) {
            if (statusCode == StatusCode.LOGINED) {
                m23635d();
                return;
            }
            if (statusCode.shouldReLogin()) {
                m23634c();
            }
        }
    }

    /* renamed from: b */
    public final void mo28274b() {
        if (C5743d.m23120e().shouldReLogin()) {
            m23635d();
            m23634c();
        }
    }
}
