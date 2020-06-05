package com.qiyukf.nimlib.p473h.p474a.p477c;

import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.nimlib.p429a.p442d.C5686a;
import com.qiyukf.nimlib.p429a.p442d.C5692b;
import com.qiyukf.nimlib.p473h.p481c.C5888a;
import com.qiyukf.nimlib.p473h.p481c.p483b.C5891a;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5894b;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5898f;

@C5692b(mo27899a = 4, mo27900b = {"1", "2"})
/* renamed from: com.qiyukf.nimlib.h.a.c.d */
public class C5860d extends C5686a {
    /* renamed from: b */
    private long f18564b;
    /* renamed from: c */
    private C5888a f18565c;

    /* renamed from: a */
    public final C5898f mo27845a(C5898f fVar) {
        short s;
        C5888a aVar;
        this.f18564b = fVar.mo28268g();
        this.f18565c = new C5888a();
        this.f18565c.mo28224a(fVar);
        if (this.f18230a.mo28233h() == 2) {
            aVar = this.f18565c;
            s = 0;
        } else {
            aVar = this.f18565c;
            s = 1;
        }
        aVar.mo28225a(s);
        StringBuilder sb = new StringBuilder("packet in notify: ");
        sb.append(this.f18565c);
        C5264a.m21617a("core", sb.toString());
        C5894b bVar = new C5894b();
        bVar.mo28249a((C5891a) this.f18565c);
        bVar.mo28251a(fVar.mo28263b());
        return new C5898f(bVar.mo28258b());
    }

    /* renamed from: f */
    public final long mo28175f() {
        return this.f18564b;
    }

    /* renamed from: g */
    public final C5888a mo28176g() {
        return this.f18565c;
    }
}
