package com.qiyukf.basesdk.p394b.p406b.p407a;

import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p394b.p406b.p409c.C5349c;
import com.qiyukf.basesdk.p394b.p406b.p409c.C5350d;

/* renamed from: com.qiyukf.basesdk.b.b.a.l */
final class C5342l extends C5327d implements C5350d {
    C5342l(C5330g gVar) {
        super(gVar, true, false);
    }

    /* renamed from: a */
    public final void mo27275a(C5327d dVar) {
    }

    /* renamed from: a */
    public final void mo27283a(Object obj) {
        StringBuilder sb = new StringBuilder("Discarded inbound message ");
        sb.append(obj);
        sb.append("  that reached at the tail of the pipeline. Please check your pipeline configuration.");
        C5264a.m21624d("DefaultChannelPipeline", sb.toString());
    }

    /* renamed from: a */
    public final void mo27277a(Throwable th) {
        C5264a.m21625d("DefaultChannelPipeline", "An exceptionCaught() event was fired, and it reached at the tail of the pipeline. It usually means the last handler in the pipeline did not handle the exception.", th);
    }

    /* renamed from: g */
    public final C5349c mo27251g() {
        return this;
    }

    /* renamed from: h */
    public final void mo27284h() {
    }

    /* renamed from: i */
    public final void mo27285i() {
    }
}
