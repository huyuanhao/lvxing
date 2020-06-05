package com.qiyukf.nimlib.p473h.p478b;

import androidx.core.view.InputDeviceCompat;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p394b.p406b.C5320a;
import com.qiyukf.basesdk.p394b.p406b.p407a.C5321a;
import com.qiyukf.basesdk.p394b.p406b.p407a.C5322b;
import com.qiyukf.basesdk.p394b.p406b.p407a.C5323c;
import com.qiyukf.basesdk.p394b.p406b.p407a.C5328e;
import com.qiyukf.basesdk.p394b.p406b.p407a.C5329f;
import com.qiyukf.basesdk.p394b.p406b.p407a.C5330g;
import com.qiyukf.basesdk.p394b.p406b.p408b.C5344b;
import com.qiyukf.basesdk.p394b.p406b.p409c.C5349c;
import com.qiyukf.basesdk.p394b.p406b.p409c.C5351e;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.p429a.p436c.C5669a;
import com.qiyukf.nimlib.p429a.p436c.C5669a.C5670a;
import com.qiyukf.nimlib.p429a.p442d.C5686a.C5687a;
import com.qiyukf.nimlib.p470f.p471a.C5826a;
import com.qiyukf.nimlib.p473h.C5846a;
import com.qiyukf.nimlib.p473h.p474a.p476b.C5853b;
import com.qiyukf.nimlib.p473h.p478b.C5880d.C5882b;
import com.qiyukf.nimlib.p473h.p478b.p479a.C5865a;
import com.qiyukf.nimlib.p473h.p478b.p479a.C5866b;
import com.qiyukf.nimlib.p473h.p478b.p480b.C5874a;
import com.qiyukf.nimlib.p473h.p478b.p480b.C5877b;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5899g;
import java.net.SocketException;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.qiyukf.nimlib.h.b.b */
public final class C5867b {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public C5873a f18579a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public AtomicInteger f18580b = new AtomicInteger(0);
    /* access modifiers changed from: private */
    /* renamed from: c */
    public C5321a f18581c;
    /* renamed from: d */
    private C5323c f18582d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public C5880d f18583e;
    /* renamed from: f */
    private C5320a f18584f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public C5846a f18585g = new C5846a() {
        /* access modifiers changed from: protected|final */
        /* renamed from: a */
        public final void mo28160a() {
            C5867b.this.mo28190a((C5669a) new C5853b());
        }

        /* access modifiers changed from: protected|final */
        /* renamed from: b */
        public final void mo28162b() {
            C5264a.m21617a("core", "keep alive on timeout");
            C5867b.this.m23506e();
        }
    };
    /* renamed from: h */
    private C5329f f18586h = new C5329f() {
        /* renamed from: a */
        public final void mo27253a(C5323c cVar) {
            C5867b.m23497a(C5867b.this, cVar);
        }
    };

    /* renamed from: com.qiyukf.nimlib.h.b.b$a */
    public interface C5873a {
        /* renamed from: a */
        void mo28196a(int i);

        /* renamed from: a */
        void mo28197a(C5687a aVar);
    }

    public C5867b(C5873a aVar) {
        this.f18579a = aVar;
        m23508f();
    }

    /* renamed from: a */
    static /* synthetic */ void m23497a(C5867b bVar, C5323c cVar) {
        synchronized (bVar) {
            bVar.f18582d = null;
        }
        char c = cVar.mo27240d() ? (char) 2 : 0;
        StringBuilder sb = new StringBuilder("on connect completed, state=");
        sb.append(cVar.mo27240d() ? "CONNECTED" : "DISCONNECTED");
        C5264a.m21617a("core", sb.toString());
        if (bVar.f18580b.get() != 1) {
            if (c == 2) {
                cVar.mo27234a().mo27231e();
            }
        } else if (c == 2) {
            bVar.f18580b.set(2);
            synchronized (bVar) {
                bVar.f18581c = cVar.mo27234a();
            }
            C5873a aVar = bVar.f18579a;
            if (aVar != null) {
                aVar.mo28196a(2);
            }
        } else {
            bVar.m23506e();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m23498a(C5867b bVar, C5687a aVar) {
        C5873a aVar2 = bVar.f18579a;
        if (aVar2 != null) {
            aVar2.mo28197a(aVar);
        }
    }

    /* renamed from: a */
    private void m23499a(Object obj) {
        C5321a aVar = this.f18581c;
        if (aVar != null) {
            aVar.mo27225a(obj);
            return;
        }
        C5264a.m21617a("core", "writeRequest while channel is null");
    }

    /* renamed from: c */
    private boolean m23502c() {
        return this.f18580b.get() == 2 || this.f18580b.get() == 3;
    }

    /* renamed from: d */
    private int m23503d() {
        C5321a aVar = this.f18581c;
        C5323c cVar = this.f18582d;
        synchronized (this) {
            this.f18581c = null;
            this.f18582d = null;
        }
        if (cVar != null) {
            cVar.mo27238b(this.f18586h);
            cVar.mo27241e();
        }
        if (aVar != null) {
            aVar.mo27231e();
        }
        int andSet = this.f18580b.getAndSet(0);
        if (!(andSet == 3 || andSet == 0)) {
            C5264a.m21617a("core", "on channel unreachable");
            C5874a.m23528a().mo28199c();
        }
        this.f18585g.mo28165e();
        StringBuilder sb = new StringBuilder("do disconnect from ");
        sb.append(andSet);
        C5264a.m21624d("core", sb.toString());
        return andSet;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m23506e() {
        int d = m23503d();
        C5873a aVar = this.f18579a;
        if (aVar != null && d != 0) {
            aVar.mo28196a(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m23508f() {
        C5320a aVar = this.f18584f;
        if (aVar != null) {
            aVar.mo27224b();
        }
        this.f18584f = new C5320a();
        this.f18584f.mo27222a(1, Boolean.valueOf(true)).mo27221a().mo27222a((int) InputDeviceCompat.SOURCE_TOUCHSCREEN, Integer.valueOf(65536)).mo27223a(new C5328e() {
            /* renamed from: a */
            public final void mo27252a(C5330g gVar) {
                gVar.mo27257a((C5349c) new C5865a(C5867b.this.f18583e));
                gVar.mo27257a((C5349c) new C5866b(C5867b.this.f18583e));
                gVar.mo27257a((C5349c) new C5351e() {
                    /* renamed from: a */
                    public final void mo27283a(Object obj) {
                        if (C5867b.this.f18581c == this.f17277a.mo27250f() && (obj instanceof C5687a)) {
                            C5867b.m23498a(C5867b.this, (C5687a) obj);
                            C5867b.this.f18585g.mo28161a(false);
                        }
                    }

                    /* renamed from: a */
                    public final void mo27276a(Object obj, C5323c cVar) {
                        super.mo27276a(obj, cVar);
                        C5867b.this.f18585g.mo28161a(true);
                    }

                    /* renamed from: a */
                    public final void mo27277a(Throwable th) {
                        if (this.f17277a.mo27250f() == C5867b.this.f18581c || C5867b.this.f18581c == null) {
                            StringBuilder sb = new StringBuilder("network exception caught: ");
                            sb.append(th);
                            String str = "core";
                            C5264a.m21626e(str, sb.toString());
                            th.printStackTrace();
                            if (th instanceof SocketException) {
                                C5264a.m21617a(str, "on channel throw socket exception, on disconnected");
                                C5867b.this.m23506e();
                                return;
                            }
                            if ((th instanceof C5344b) && (th.getCause() instanceof C5899g)) {
                                C5264a.m21617a(str, "on channel throw unpack exception, on disconnected and setup netty");
                                C5867b.this.m23506e();
                                C5867b.this.m23508f();
                            }
                            return;
                        }
                        StringBuilder sb2 = new StringBuilder("channel exception, but not current one, cause: ");
                        sb2.append(th);
                        C5264a.m21624d("net", sb2.toString());
                    }

                    /* renamed from: h */
                    public final void mo27284h() {
                        if (C5867b.this.f18581c != null && C5867b.this.f18581c == this.f17277a.mo27250f()) {
                            C5264a.m21617a("core", "on channel inactive, on disconnected");
                            C5867b.this.m23506e();
                        }
                    }
                });
            }
        });
    }

    /* renamed from: a */
    public final void mo28189a() {
        if (this.f18580b.get() != 0) {
            m23503d();
        }
    }

    /* renamed from: a */
    public final boolean mo28190a(C5669a aVar) {
        if (!m23502c()) {
            C5264a.m21617a("core", "sendPacket while not connected");
            return false;
        }
        m23499a((Object) aVar);
        return true;
    }

    /* renamed from: a */
    public final boolean mo28191a(C5826a aVar) {
        if (!m23502c()) {
            return false;
        }
        m23499a((Object) aVar);
        return true;
    }

    /* renamed from: a */
    public final boolean mo28192a(C5877b bVar) {
        if (!this.f18580b.compareAndSet(0, 1)) {
            return false;
        }
        if (this.f18583e == null) {
            this.f18583e = new C5880d(C5718b.m23009a(), new C5882b() {
                /* renamed from: a */
                public final void mo28194a() {
                    C5867b.this.m23506e();
                }

                /* renamed from: a */
                public final void mo28195a(C5670a aVar, boolean z) {
                    C5867b.this.f18580b.compareAndSet(2, 3);
                    if (z) {
                        C5687a a = C5687a.m22947a(aVar.f18204a, 201);
                        if (!(a == null || C5867b.this.f18579a == null)) {
                            C5867b.this.f18579a.mo28197a(a);
                        }
                        return;
                    }
                    C5867b.this.f18585g.mo28164d();
                }
            });
        }
        this.f18583e.mo28209a();
        try {
            C5323c a = this.f18584f.mo27220a(bVar.f18606a, bVar.f18607b);
            synchronized (this) {
                this.f18582d = a;
            }
            a.mo27235a(this.f18586h);
        } catch (Exception e) {
            e.printStackTrace();
            StringBuilder sb = new StringBuilder("connect server failed: ");
            sb.append(e);
            C5264a.m21617a("core", sb.toString());
            m23506e();
            if (e instanceof C5322b) {
                StringBuilder sb2 = new StringBuilder("connect server failed, e=ChannelException ");
                sb2.append(e.getMessage());
                C5264a.m21617a("core", sb2.toString());
            }
        }
        return true;
    }

    /* renamed from: b */
    public final void mo28193b() {
        if (m23502c()) {
            this.f18585g.mo28163c();
        }
    }
}
