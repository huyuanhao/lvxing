package com.qiyukf.nimlib.p429a.p431b.p432a;

import com.qiyukf.basesdk.p394b.p395a.p397b.C5290a;
import com.qiyukf.basesdk.p394b.p395a.p397b.p400c.C5302d;
import com.qiyukf.nimlib.p429a.p431b.C5667g;
import com.qiyukf.nimlib.p429a.p442d.C5686a;
import com.qiyukf.nimlib.p429a.p442d.p443a.C5688a;
import com.qiyukf.nimlib.p473h.p481c.p483b.C5892b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qiyukf.nimlib.a.b.a.a */
public final class C5650a extends C5667g {
    /* renamed from: a */
    public final void mo27842a(C5686a aVar) {
        ArrayList arrayList = new ArrayList();
        if (aVar.mo27893b()) {
            for (C5892b bVar : ((C5688a) aVar).mo27897f()) {
                C5302d dVar = new C5302d();
                dVar.mo27181b(bVar.mo28239a(3));
                dVar.mo27179a(bVar.mo28239a(2));
                dVar.mo27183c(bVar.mo28239a(1));
                dVar.mo27178a(bVar.mo28242b(4));
                arrayList.add(dVar);
            }
        }
        C5290a.m21719a().mo27156a((List<C5302d>) arrayList);
    }
}
