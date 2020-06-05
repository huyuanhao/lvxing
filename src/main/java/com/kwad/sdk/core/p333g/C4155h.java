package com.kwad.sdk.core.p333g;

import com.kwad.sdk.core.p319c.C4065b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.sdk.core.g.h */
class C4155h implements C4154g {
    /* renamed from: a */
    private List<C4156i> f13841a = new ArrayList();

    C4155h() {
    }

    /* renamed from: a */
    public synchronized long mo23853a() {
        int size;
        size = this.f13841a.size();
        StringBuilder sb = new StringBuilder();
        sb.append("count() = ");
        sb.append(size);
        C4065b.m16863a("MemReportCache", sb.toString());
        return (long) size;
    }

    /* renamed from: a */
    public synchronized void mo23854a(C4156i iVar) {
        this.f13841a.add(iVar);
    }

    /* renamed from: a */
    public synchronized void mo23855a(List<C4156i> list) {
        if (list != null) {
            this.f13841a.addAll(list);
        }
    }

    /* renamed from: b */
    public synchronized List<C4156i> mo23856b() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.f13841a);
        this.f13841a.clear();
        return arrayList;
    }
}
