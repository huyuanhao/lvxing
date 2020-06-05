package com.qiyukf.nimlib.p429a.p431b.p434c;

import com.qiyukf.nimlib.p429a.C5645a;
import com.qiyukf.nimlib.p429a.p431b.C5667g;
import com.qiyukf.nimlib.p429a.p442d.C5686a;
import com.qiyukf.nimlib.p429a.p442d.p445c.C5698b;
import com.qiyukf.nimlib.p473h.C5911g;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qiyukf.nimlib.a.b.c.a */
public final class C5660a extends C5667g {
    /* renamed from: a */
    public final void mo27842a(C5686a aVar) {
        C5698b bVar = (C5698b) aVar;
        if (bVar.mo27893b() && bVar.mo27907f().size() > 0) {
            ArrayList arrayList = new ArrayList(bVar.mo27907f().size());
            for (String str : bVar.mo27907f()) {
                C5645a aVar2 = new C5645a();
                aVar2.mo27835a(str);
                arrayList.add(aVar2);
            }
            C5911g.m23677a((List<C5645a>) arrayList);
        }
        m22860a(aVar, null);
    }
}
