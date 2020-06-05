package com.qiyukf.basesdk.p394b.p395a.p397b.p403f;

import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p394b.p395a.p397b.p398a.C5294a;
import com.qiyukf.basesdk.p394b.p395a.p397b.p400c.C5300b;
import com.qiyukf.basesdk.p394b.p395a.p397b.p402e.C5309c;

/* renamed from: com.qiyukf.basesdk.b.a.b.f.b */
public class C5311b implements Runnable {
    /* renamed from: a */
    private static final String f17213a = C5309c.m21831a(C5311b.class);
    /* renamed from: b */
    private C5294a f17214b;

    public C5311b(C5294a aVar, C5300b bVar) {
        this.f17214b = aVar;
        this.f17214b.mo27167a(bVar);
    }

    /* renamed from: a */
    public final void mo27213a() {
        C5264a.m21624d(f17213a, "uploading is canceling");
        this.f17214b.mo27166a();
    }

    public void run() {
        this.f17214b.mo27168b();
    }
}
