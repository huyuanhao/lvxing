package com.qiyukf.basesdk.p394b.p406b.p409c;

import com.qiyukf.basesdk.p394b.p406b.p407a.C5323c;
import com.qiyukf.basesdk.p394b.p406b.p407a.C5327d;
import java.net.SocketAddress;

/* renamed from: com.qiyukf.basesdk.b.b.c.b */
public class C5348b implements C5354g {
    /* renamed from: a */
    protected C5327d f17277a;

    /* renamed from: a */
    public final void mo27274a(C5323c cVar) {
        C5354g e = this.f17277a.mo27249e();
        if (e != null) {
            try {
                e.mo27274a(cVar);
            } catch (Throwable th) {
                this.f17277a.mo27251g().mo27277a(th);
            }
        }
    }

    /* renamed from: a */
    public final void mo27275a(C5327d dVar) {
        this.f17277a = dVar;
    }

    /* renamed from: a */
    public void mo27276a(Object obj, C5323c cVar) {
        C5354g e = this.f17277a.mo27249e();
        if (e != null) {
            try {
                e.mo27276a(obj, cVar);
            } catch (Throwable th) {
                this.f17277a.mo27251g().mo27277a(th);
            }
        }
    }

    /* renamed from: a */
    public void mo27277a(Throwable th) {
        if (this.f17277a.mo27245a() != null && this.f17277a.mo27245a().mo27251g() != null) {
            this.f17277a.mo27245a().mo27251g().mo27277a(th);
        }
    }

    /* renamed from: a */
    public final boolean mo27278a(SocketAddress socketAddress) {
        C5354g e = this.f17277a.mo27249e();
        if (e != null) {
            try {
                return e.mo27278a(socketAddress);
            } catch (Throwable th) {
                e.mo27277a(th);
            }
        }
        return false;
    }
}
