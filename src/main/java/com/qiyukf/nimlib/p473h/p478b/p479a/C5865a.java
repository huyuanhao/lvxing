package com.qiyukf.nimlib.p473h.p478b.p479a;

import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p394b.p406b.p408b.C5343a;
import com.qiyukf.nimlib.p429a.p442d.C5686a.C5687a;
import com.qiyukf.nimlib.p473h.p478b.C5880d;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5899g;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

/* renamed from: com.qiyukf.nimlib.h.b.a.a */
public final class C5865a extends C5343a {
    /* renamed from: b */
    private C5880d f18577b;

    public C5865a(C5880d dVar) {
        this.f18577b = dVar;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo27286a(ByteBuffer byteBuffer, List<Object> list) {
        ByteBuffer order = byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        while (order.remaining() > 0) {
            try {
                C5687a a = this.f18577b.mo28207a(order);
                if (a != null) {
                    list.add(a);
                } else {
                    return;
                }
            } catch (C5899g e) {
                e.printStackTrace();
                C5264a.m21617a("netty", "on decode exception");
                order.clear();
                this.f17276a.mo27250f().mo27231e();
            }
        }
    }

    /* renamed from: h */
    public final void mo27284h() {
        super.mo27284h();
        this.f18577b.mo28210b();
    }
}
