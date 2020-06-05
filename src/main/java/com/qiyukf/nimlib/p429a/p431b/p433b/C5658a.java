package com.qiyukf.nimlib.p429a.p431b.p433b;

import com.qiyukf.nimlib.p429a.C5668c;
import com.qiyukf.nimlib.p429a.p431b.C5667g;
import com.qiyukf.nimlib.p429a.p436c.C5669a;
import com.qiyukf.nimlib.p429a.p436c.p438b.C5675a;
import com.qiyukf.nimlib.p429a.p442d.C5686a;
import com.qiyukf.nimlib.p429a.p442d.p444b.C5695b;
import com.qiyukf.nimlib.p429a.p449f.C5713a;
import com.qiyukf.nimlib.p469e.C5808b;
import com.qiyukf.nimlib.p473h.p481c.p483b.C5892b;
import com.qiyukf.nimlib.p485i.C5912a;
import com.qiyukf.nimlib.p485i.C5914c;
import com.qiyukf.nimlib.p485i.C5922f;
import com.qiyukf.nimlib.p485i.C5923g;
import com.qiyukf.nimlib.p485i.C5925h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.qiyukf.nimlib.a.b.b.a */
public final class C5658a extends C5667g {
    /* renamed from: a */
    private static void m22835a(C5695b bVar) {
        List<C5892b> f = bVar.mo27903f();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        for (C5892b bVar2 : f) {
            long c = bVar2.mo28243c(12);
            int b = bVar2.mo28242b(0);
            if (b == 2) {
                arrayList2.add(Long.valueOf(c));
            } else if (b == 0) {
                arrayList.add(Long.valueOf(c));
            } else if (b == 1) {
                String a = bVar2.mo28239a(1);
                Long l = (Long) hashMap.get(a);
                if (l == null || l.longValue() < c) {
                    hashMap.put(a, Long.valueOf(c));
                }
            }
        }
        if (!arrayList.isEmpty()) {
            C5675a aVar = new C5675a();
            aVar.mo27880a(7);
            aVar.mo27882b(2);
            aVar.mo27881a((List<Long>) arrayList);
            C5668c.m22861a().mo27865a((C5669a) aVar, C5713a.f18257d);
        }
        if (!hashMap.isEmpty()) {
            ArrayList arrayList3 = new ArrayList(hashMap.values());
            C5675a aVar2 = new C5675a();
            aVar2.mo27880a(8);
            aVar2.mo27882b(3);
            aVar2.mo27881a((List<Long>) arrayList3);
            C5668c.m22861a().mo27865a((C5669a) aVar2, C5713a.f18257d);
        }
        if (!arrayList2.isEmpty()) {
            C5675a aVar3 = new C5675a();
            aVar3.mo27880a(101);
            aVar3.mo27882b(2);
            aVar3.mo27881a((List<Long>) arrayList2);
            C5668c.m22861a().mo27865a((C5669a) aVar3, C5713a.f18257d);
        }
    }

    /* renamed from: a */
    public final void mo27842a(C5686a aVar) {
        C5925h hVar;
        if (aVar.mo27893b()) {
            boolean z = aVar.mo27895d() == 4 || aVar.mo27895d() == 100;
            C5695b bVar = (C5695b) aVar;
            List<C5892b> f = bVar.mo27903f();
            boolean z2 = aVar.mo27891a().mo28233h() == 100;
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet(f.size());
            for (C5892b bVar2 : f) {
                if (!hashSet.contains(bVar2.mo28239a(11))) {
                    bVar2.mo28240a(13, 1);
                    if (z2) {
                        bVar2.mo28240a(0, 2);
                    }
                    C5912a a = C5914c.m23704a(bVar2, false);
                    if (a != null) {
                        String a2 = C5914c.m23706a(bVar2);
                        ArrayList arrayList2 = (ArrayList) hashMap.get(a2);
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                            hashMap.put(a2, arrayList2);
                        }
                        arrayList2.add(a);
                        hashSet.add(a.getUuid());
                        hashMap2.put(a2, bVar2.mo28239a(6));
                        arrayList.add(a);
                    }
                }
            }
            C5922f.m23753a((List<C5912a>) arrayList);
            ArrayList arrayList3 = new ArrayList();
            for (String str : hashMap.keySet()) {
                ArrayList arrayList4 = (ArrayList) hashMap.get(str);
                if (z) {
                    hVar = C5914c.m23705a(arrayList4, (String) hashMap2.get(str));
                } else {
                    C5914c.m23710a(arrayList4);
                    hVar = C5923g.m23759a((C5912a) arrayList4.get(arrayList4.size() - 1));
                }
                if (hVar != null) {
                    arrayList3.add(hVar);
                }
            }
            C5808b.m23325b((List<C5925h>) arrayList3);
            if (z) {
                m22835a(bVar);
            }
        }
    }
}
