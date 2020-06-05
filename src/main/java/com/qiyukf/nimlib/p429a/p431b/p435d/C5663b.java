package com.qiyukf.nimlib.p429a.p431b.p435d;

import com.qiyukf.nimlib.p429a.p431b.C5667g;
import com.qiyukf.nimlib.p429a.p442d.C5686a;
import com.qiyukf.nimlib.p429a.p442d.p446d.C5700b;
import com.qiyukf.nimlib.p469e.C5808b;
import com.qiyukf.nimlib.p473h.p481c.p483b.C5892b;
import com.qiyukf.nimlib.p485i.C5912a;
import com.qiyukf.nimlib.p485i.C5914c;
import com.qiyukf.nimlib.sdk.msg.model.RecentContact;
import java.util.ArrayList;

/* renamed from: com.qiyukf.nimlib.a.b.d.b */
public final class C5663b extends C5667g {
    /* renamed from: a */
    public final void mo27842a(C5686a aVar) {
        C5700b bVar = (C5700b) aVar;
        if (aVar.mo27891a().mo28232g() == 101) {
            bVar.mo27908f().mo28240a(0, 2);
        }
        C5892b f = bVar.mo27908f();
        C5912a a = C5914c.m23704a(f, true);
        if (a != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(a);
            C5808b.m23321a((RecentContact) C5914c.m23705a(arrayList, f.mo28239a(6)));
        }
    }
}
