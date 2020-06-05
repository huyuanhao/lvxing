package com.qiyukf.nimlib.p473h.p478b.p479a;

import com.qiyukf.basesdk.p394b.p406b.p408b.C5345c;
import com.qiyukf.basesdk.p394b.p406b.p408b.C5346d;
import com.qiyukf.nimlib.p429a.p436c.C5669a;
import com.qiyukf.nimlib.p429a.p436c.C5669a.C5670a;
import com.qiyukf.nimlib.p470f.p471a.C5826a;
import com.qiyukf.nimlib.p473h.p478b.C5880d;
import java.nio.ByteBuffer;

/* renamed from: com.qiyukf.nimlib.h.b.a.b */
public final class C5866b extends C5346d<Object> {
    /* renamed from: b */
    C5880d f18578b;

    public C5866b(C5880d dVar) {
        super(Object.class);
        this.f18578b = dVar;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final ByteBuffer mo27287a(Object obj) {
        C5880d dVar;
        C5670a aVar;
        if (obj instanceof C5669a) {
            C5669a aVar2 = (C5669a) obj;
            dVar = this.f18578b;
            aVar = new C5670a(aVar2.mo27870a(), aVar2.mo27872b().mo28258b());
        } else if (obj instanceof C5826a) {
            C5826a aVar3 = (C5826a) obj;
            dVar = this.f18578b;
            aVar = new C5670a(aVar3.mo28133b(), aVar3.mo28134c());
        } else {
            StringBuilder sb = new StringBuilder("unsupport request type: ");
            sb.append(obj.getClass().getName());
            throw new C5345c(sb.toString());
        }
        return dVar.mo28208a(aVar).mo28258b();
    }
}
