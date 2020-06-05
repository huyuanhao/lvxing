package com.p368pw.inner.base.p387d.p388a;

import com.p368pw.inner.base.C5114a.C5118b;
import com.p368pw.inner.base.p387d.p388a.C5160d.C5161a;

/* renamed from: com.pw.inner.base.d.a.a */
public class C5149a extends C5118b {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public C5151a f16810a;
    /* renamed from: b */
    private String f16811b;
    /* renamed from: c */
    private String f16812c;

    /* renamed from: com.pw.inner.base.d.a.a$a */
    public interface C5151a {
        /* renamed from: a */
        void mo26758a(int i);
    }

    public C5149a(String str, String str2, C5151a aVar) {
        this.f16811b = str;
        this.f16812c = str2;
        this.f16810a = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo25762a() {
        C5160d dVar = new C5160d();
        dVar.mo26766a(this.f16811b, this.f16812c, new C5161a() {
            /* renamed from: a */
            public void mo26757a(int i) {
                if (C5149a.this.f16810a != null) {
                    C5149a.this.f16810a.mo26758a(i);
                }
            }
        });
        return dVar.mo26768a();
    }
}
