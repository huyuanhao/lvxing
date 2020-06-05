package com.qiyukf.basesdk.p394b.p395a.p397b.p403f;

import android.content.Context;
import com.qiyukf.basesdk.p394b.p395a.p397b.p398a.C5294a;
import com.qiyukf.basesdk.p394b.p395a.p397b.p400c.C5300b;
import com.qiyukf.basesdk.p394b.p395a.p397b.p400c.C5304f;
import com.qiyukf.basesdk.p394b.p395a.p397b.p402e.C5309c;
import com.qiyukf.basesdk.p412c.C5420e;
import java.io.File;

/* renamed from: com.qiyukf.basesdk.b.a.b.f.a */
public final class C5310a {
    /* renamed from: a */
    private static C5420e f17212a;

    /* renamed from: a */
    public static C5311b m21833a(Context context, File file, Object obj, String str, C5304f fVar, C5300b bVar) {
        C5309c.m21832a(context, file, obj, fVar, bVar);
        C5294a aVar = new C5294a(context, fVar.mo27205d(), fVar.mo27206e(), fVar.mo27207f(), file, obj, str, fVar);
        C5311b bVar2 = new C5311b(aVar, bVar);
        if (f17212a == null) {
            f17212a = new C5420e("NosUploadManager", C5420e.f17394b, true);
        }
        f17212a.execute(bVar2);
        return bVar2;
    }

    /* renamed from: a */
    public static void m21834a() {
        C5420e eVar = f17212a;
        if (eVar != null) {
            eVar.mo27366b();
            f17212a = null;
        }
    }
}
