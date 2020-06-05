package com.qiyukf.nimlib.p429a.p431b.p432a;

import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.nimlib.p429a.C5668c;
import com.qiyukf.nimlib.p429a.p431b.C5667g;
import com.qiyukf.nimlib.p429a.p436c.p437a.C5672b;
import com.qiyukf.nimlib.p429a.p442d.C5686a;
import com.qiyukf.nimlib.p486j.C5926a;

/* renamed from: com.qiyukf.nimlib.a.b.a.b */
public final class C5651b extends C5667g {
    /* renamed from: a */
    public final void mo27842a(C5686a aVar) {
        if (aVar.mo27893b()) {
            C5672b bVar = (C5672b) C5668c.m22861a().mo27856a(aVar);
            int f = bVar.mo27877f();
            String g = bVar.mo27878g();
            if (f == 1) {
                C5926a.m23780a();
                C5926a.m23783a(g);
            }
            StringBuilder sb = new StringBuilder("report stat success, type=");
            sb.append(f);
            sb.append(", md5=");
            sb.append(g);
            C5264a.m21620b("stat", sb.toString());
        }
    }
}
