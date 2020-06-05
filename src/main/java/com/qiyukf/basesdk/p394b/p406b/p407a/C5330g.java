package com.qiyukf.basesdk.p394b.p406b.p407a;

import android.os.SystemClock;
import android.util.SparseArray;
import com.qiyukf.basesdk.p394b.p406b.p409c.C5349c;
import com.qiyukf.basesdk.p394b.p406b.p409c.C5350d;
import com.qiyukf.basesdk.p394b.p406b.p409c.C5352f;
import com.qiyukf.basesdk.p394b.p406b.p409c.C5354g;
import com.qiyukf.basesdk.p394b.p406b.p411e.C5360a;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;

/* renamed from: com.qiyukf.basesdk.b.b.a.g */
public final class C5330g {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public C5321a f17244a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public C5338j f17245b = new C5338j(this);
    /* access modifiers changed from: private */
    /* renamed from: c */
    public C5342l f17246c = new C5342l(this);
    /* renamed from: d */
    private C5352f f17247d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public C5323c f17248e;
    /* renamed from: f */
    private C5337i f17249f;

    /* renamed from: com.qiyukf.basesdk.b.b.a.g$a */
    private class C5335a implements Runnable {
        /* renamed from: b */
        private C5327d f17262b;
        /* renamed from: c */
        private Object f17263c;
        /* renamed from: d */
        private C5323c f17264d;

        public C5335a(C5327d dVar, Object obj, C5323c cVar) {
            this.f17262b = dVar;
            this.f17263c = obj;
            this.f17264d = cVar;
        }

        public final void run() {
            try {
                C5327d dVar = this.f17262b;
                Object obj = this.f17263c;
                C5323c cVar = this.f17264d;
                if (!C5330g.this.f17244a.mo27228b().mo27310b()) {
                    cVar.mo27236a((Throwable) C5360a.m22011a(C5330g.this.f17244a));
                } else {
                    C5354g e = dVar.mo27249e();
                    if (e != null) {
                        e.mo27276a(obj, cVar);
                    }
                }
            } finally {
                this.f17262b = null;
                this.f17263c = null;
                this.f17264d = null;
            }
        }
    }

    public C5330g(C5321a aVar, C5352f fVar) {
        this.f17244a = aVar;
        this.f17247d = fVar;
        C5338j jVar = this.f17245b;
        C5342l lVar = this.f17246c;
        jVar.f17241c = lVar;
        lVar.f17240b = jVar;
    }

    /* renamed from: a */
    static /* synthetic */ void m21893a(C5330g gVar, SparseArray sparseArray, C5328e eVar) {
        gVar.f17244a.mo27227a(sparseArray);
        eVar.mo27252a(gVar);
    }

    /* renamed from: a */
    static /* synthetic */ void m21895a(C5330g gVar, SocketAddress socketAddress, C5323c cVar, long j) {
        C5327d c = gVar.f17246c.mo27247c();
        if (c != null) {
            try {
                if (((C5354g) c.mo27251g()).mo27278a(socketAddress)) {
                    gVar.m21900g();
                    cVar.mo27237b();
                    return;
                }
                gVar.f17248e = cVar;
                if (gVar.f17249f != null) {
                    gVar.f17249f.mo27271b();
                }
                gVar.f17249f = new C5337i(SystemClock.elapsedRealtime() + j) {
                    public final void run() {
                        if (!mo27272c()) {
                            C5330g.this.m21897b((Throwable) new ConnectException("connect timeout"));
                        }
                    }
                };
                gVar.f17247d.mo27294a(gVar.f17249f);
            } catch (Exception e) {
                cVar.mo27236a((Throwable) e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m21897b(Throwable th) {
        C5323c cVar = this.f17248e;
        this.f17248e = null;
        if (cVar != null) {
            if (th != null) {
                cVar.mo27236a(th);
                return;
            }
            cVar.mo27237b();
        }
    }

    /* renamed from: g */
    private void m21900g() {
        try {
            SelectionKey f = this.f17244a.mo27232f();
            if (f.isValid()) {
                int interestOps = f.interestOps();
                if ((interestOps & 1) == 0) {
                    f.interestOps(interestOps | 1);
                }
            }
        } catch (Exception e) {
            this.f17247d.execute(new Runnable() {
                public final void run() {
                    C5330g.this.f17245b.mo27277a((Throwable) e);
                }
            });
            this.f17244a.mo27231e();
        }
    }

    /* renamed from: a */
    public final C5321a mo27254a() {
        return this.f17244a;
    }

    /* renamed from: a */
    public final C5323c mo27255a(Object obj) {
        C5323c cVar = new C5323c(this.f17244a);
        C5360a.m22012a(this.f17247d, new C5335a(this.f17246c, obj, cVar));
        return cVar;
    }

    /* renamed from: a */
    public final C5323c mo27256a(String str, int i, SparseArray<Object> sparseArray, C5328e eVar, long j) {
        C5323c cVar = new C5323c(this.f17244a);
        C5352f fVar = this.f17247d;
        final C5323c cVar2 = cVar;
        final SparseArray<Object> sparseArray2 = sparseArray;
        final C5328e eVar2 = eVar;
        final String str2 = str;
        final int i2 = i;
        final long j2 = j;
        C53311 r0 = new Runnable() {
            public final void run() {
                if (C5330g.this.f17248e != null) {
                    cVar2.mo27236a((Throwable) new C5322b("Already in connection progress"));
                }
                try {
                    C5330g.m21893a(C5330g.this, sparseArray2, eVar2);
                } catch (Throwable th) {
                    C5330g.this.f17244a.mo27231e();
                    cVar2.mo27236a(th);
                }
                C5330g.m21895a(C5330g.this, new InetSocketAddress(str2, i2), cVar2, j2);
            }
        };
        fVar.execute(r0);
        return cVar;
    }

    /* renamed from: a */
    public final void mo27257a(C5349c cVar) {
        C5336h hVar = new C5336h(this, cVar);
        cVar.mo27275a((C5327d) hVar);
        C5342l lVar = this.f17246c;
        hVar.f17241c = lVar;
        hVar.f17240b = lVar.f17240b;
        this.f17246c.f17240b.f17241c = hVar;
        this.f17246c.f17240b = hVar;
    }

    /* renamed from: a */
    public final void mo27258a(Throwable th) {
        this.f17245b.mo27277a(th);
    }

    /* access modifiers changed from: final */
    /* renamed from: a */
    public final void mo27259a(ByteBuffer byteBuffer) {
        C5327d b = this.f17245b.mo27246b();
        if (b != null) {
            ((C5350d) b.mo27251g()).mo27283a(byteBuffer);
        }
    }

    /* renamed from: b */
    public final void mo27260b() {
        try {
            this.f17244a.mo27228b().mo27314f();
            m21897b((Throwable) null);
            if (this.f17244a.mo27228b().mo27310b()) {
                m21900g();
            }
            C5337i iVar = this.f17249f;
            if (iVar != null) {
                iVar.mo27271b();
                this.f17249f = null;
            }
            this.f17248e = null;
        } catch (Throwable th) {
            C5337i iVar2 = this.f17249f;
            if (iVar2 != null) {
                iVar2.mo27271b();
                this.f17249f = null;
            }
            this.f17248e = null;
            throw th;
        }
    }

    /* renamed from: c */
    public final void mo27261c() {
        if (this.f17247d.mo27299h()) {
            this.f17246c.mo27249e().mo27274a(new C5323c(this.f17244a));
        } else {
            C5360a.m22012a(this.f17247d, new Runnable() {
                public final void run() {
                    C5330g.this.f17246c.mo27249e().mo27274a(new C5323c(C5330g.this.f17244a));
                }
            });
        }
    }

    /* renamed from: d */
    public final C5352f mo27262d() {
        return this.f17247d;
    }

    /* access modifiers changed from: final */
    /* renamed from: e */
    public final void mo27263e() {
        C5327d b = this.f17245b.mo27246b();
        if (b != null) {
            ((C5350d) b.mo27251g()).mo27285i();
        }
    }

    /* access modifiers changed from: final */
    /* renamed from: f */
    public final void mo27264f() {
        C5327d b = this.f17245b.mo27246b();
        if (b != null) {
            ((C5350d) b.mo27251g()).mo27284h();
        }
        C5337i iVar = this.f17249f;
        if (iVar != null) {
            iVar.mo27271b();
            this.f17249f = null;
        }
    }
}
