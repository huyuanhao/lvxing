package com.qiyukf.basesdk.p394b.p406b.p407a;

import com.qiyukf.basesdk.p394b.p406b.p409c.C5349c;
import com.qiyukf.basesdk.p394b.p406b.p409c.C5354g;
import com.qiyukf.basesdk.p394b.p406b.p410d.C5357a;
import java.net.SocketAddress;
import java.nio.ByteBuffer;

/* renamed from: com.qiyukf.basesdk.b.b.a.j */
final class C5338j extends C5327d implements C5354g {
    C5338j(C5330g gVar) {
        super(gVar, false, true);
    }

    /* renamed from: h */
    private C5357a m21916h() {
        return this.f17239a.mo27254a().mo27228b();
    }

    /* renamed from: a */
    public final void mo27274a(C5323c cVar) {
        this.f17239a.mo27254a().mo27233g();
    }

    /* renamed from: a */
    public final void mo27275a(C5327d dVar) {
    }

    /* renamed from: a */
    public final void mo27276a(Object obj, C5323c cVar) {
        if (obj instanceof ByteBuffer) {
            m21916h().mo27307a((ByteBuffer) obj, cVar);
        } else {
            cVar.mo27236a((Throwable) new UnsupportedOperationException("Only ByteBuffer is supported"));
        }
    }

    /* renamed from: a */
    public final void mo27277a(Throwable th) {
        if (this.f17241c != null && this.f17241c.mo27251g() != null) {
            this.f17241c.mo27251g().mo27277a(th);
        }
    }

    /* renamed from: a */
    public final boolean mo27278a(SocketAddress socketAddress) {
        return m21916h().mo27309a(socketAddress);
    }

    /* renamed from: g */
    public final C5349c mo27251g() {
        return this;
    }
}
