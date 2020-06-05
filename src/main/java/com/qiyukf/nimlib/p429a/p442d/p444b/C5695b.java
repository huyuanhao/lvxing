package com.qiyukf.nimlib.p429a.p442d.p444b;

import com.qiyukf.nimlib.p429a.p442d.C5686a;
import com.qiyukf.nimlib.p429a.p442d.C5692b;
import com.qiyukf.nimlib.p473h.p481c.p483b.C5892b;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5896d;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5898f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@C5692b(mo27899a = 4, mo27900b = {"4", "9", "100", "101"})
/* renamed from: com.qiyukf.nimlib.a.d.b.b */
public class C5695b extends C5686a {
    /* renamed from: b */
    private List<C5892b> f18237b;

    /* renamed from: a */
    public final C5898f mo27845a(C5898f fVar) {
        int f = fVar.mo28267f();
        this.f18237b = new ArrayList(f);
        for (int i = 0; i < f; i++) {
            this.f18237b.add(C5896d.m23615a(fVar));
        }
        Collections.sort(this.f18237b, new Comparator<C5892b>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                int i = ((((C5892b) obj).mo28243c(7) - ((C5892b) obj2).mo28243c(7)) > 0 ? 1 : ((((C5892b) obj).mo28243c(7) - ((C5892b) obj2).mo28243c(7)) == 0 ? 0 : -1));
                if (i == 0) {
                    return 0;
                }
                return i > 0 ? 1 : -1;
            }
        });
        return null;
    }

    /* renamed from: f */
    public final List<C5892b> mo27903f() {
        return this.f18237b;
    }
}
