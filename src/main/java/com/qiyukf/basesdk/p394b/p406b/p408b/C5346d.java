package com.qiyukf.basesdk.p394b.p406b.p408b;

import com.qiyukf.basesdk.p394b.p406b.p407a.C5323c;
import com.qiyukf.basesdk.p394b.p406b.p409c.C5348b;
import java.nio.ByteBuffer;

/* renamed from: com.qiyukf.basesdk.b.b.b.d */
public abstract class C5346d<I> extends C5348b {
    /* renamed from: b */
    private final Class<? extends I> f17275b;

    protected C5346d(Class<? extends I> cls) {
        this.f17275b = cls;
    }

    /* renamed from: a */
    public abstract ByteBuffer mo27287a(I i);

    /* renamed from: a */
    public final void mo27276a(Object obj, C5323c cVar) {
        try {
            boolean z = this.f17275b != null && this.f17275b.isInstance(obj);
            if (z) {
                super.mo27276a(mo27287a(obj), cVar);
            } else {
                super.mo27276a(obj, cVar);
            }
        } catch (C5345c e) {
            throw e;
        } catch (Throwable th) {
            throw new C5345c(th);
        }
    }
}
