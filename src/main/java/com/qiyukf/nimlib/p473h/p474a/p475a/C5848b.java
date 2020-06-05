package com.qiyukf.nimlib.p473h.p474a.p475a;

import com.qiyukf.nimlib.C5743d;
import com.qiyukf.nimlib.p429a.C5668c;
import com.qiyukf.nimlib.p429a.C5685d;
import com.qiyukf.nimlib.p429a.p430a.C5646a.C5647a;
import com.qiyukf.nimlib.p429a.p431b.C5649a;
import com.qiyukf.nimlib.p429a.p436c.C5669a;
import com.qiyukf.nimlib.p429a.p442d.C5686a;
import com.qiyukf.nimlib.p473h.C5906f;
import com.qiyukf.nimlib.p473h.C5911g;
import com.qiyukf.nimlib.p473h.p474a.p476b.C5856e;
import com.qiyukf.nimlib.p473h.p474a.p477c.C5858b;
import com.qiyukf.nimlib.p473h.p481c.p483b.C5892b;
import com.qiyukf.nimlib.sdk.StatusCode;
import java.util.ArrayList;

/* renamed from: com.qiyukf.nimlib.h.a.a.b */
public class C5848b extends C5649a {
    /* renamed from: a */
    private static final String f18550a = C5848b.class.getSimpleName();
    /* renamed from: b */
    private final boolean f18551b;

    public C5848b(boolean z) {
        this.f18551b = z;
    }

    /* renamed from: a */
    public final void mo27842a(C5686a aVar) {
        if (this.f18551b) {
            C5858b bVar = (C5858b) aVar;
            if (C5743d.m23120e() == StatusCode.LOGINING) {
                C5906f.m23656a().mo28276a((int) bVar.mo27896e());
                if (bVar.mo27893b()) {
                    C5685d.m22937a(bVar.mo28171f().mo28239a(103));
                    C5892b bVar2 = new C5892b();
                    bVar2.mo28240a(C5647a.UNREAD_MESSAGE.mo27841a(), 0);
                    bVar2.mo28240a(C5647a.YSF_UNREAD_MSG.mo27841a(), 0);
                    C5856e eVar = new C5856e();
                    eVar.mo28167a(bVar2);
                    C5906f.m23656a().mo28279a((C5669a) eVar);
                }
                ArrayList g = bVar.mo28172g();
                if (g == null || g.size() <= 0) {
                    C5911g.m23675a();
                } else {
                    C5911g.m23676a(g);
                    return;
                }
            }
            return;
        }
        C5668c.m22861a().mo27863a(aVar.mo27896e());
    }
}
