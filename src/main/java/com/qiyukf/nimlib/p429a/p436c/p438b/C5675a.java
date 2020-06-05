package com.qiyukf.nimlib.p429a.p436c.p438b;

import com.qiyukf.nimlib.p429a.p436c.C5669a;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5894b;
import java.util.List;

/* renamed from: com.qiyukf.nimlib.a.c.b.a */
public final class C5675a extends C5669a {
    /* renamed from: a */
    private byte f18212a;
    /* renamed from: b */
    private byte f18213b;
    /* renamed from: c */
    private List<Long> f18214c;

    /* renamed from: a */
    public final void mo27880a(byte b) {
        this.f18212a = b;
    }

    /* renamed from: a */
    public final void mo27881a(List<Long> list) {
        this.f18214c = list;
    }

    /* renamed from: b */
    public final C5894b mo27872b() {
        C5894b bVar = new C5894b();
        bVar.mo28246a(this.f18212a);
        bVar.mo28246a(this.f18213b);
        bVar.mo28255b(this.f18214c.size());
        for (Long longValue : this.f18214c) {
            bVar.mo28248a(longValue.longValue());
        }
        return bVar;
    }

    /* renamed from: b */
    public final void mo27882b(byte b) {
        this.f18213b = b;
    }

    /* renamed from: c */
    public final byte mo27873c() {
        return 4;
    }

    /* renamed from: d */
    public final byte mo27874d() {
        return 5;
    }
}
