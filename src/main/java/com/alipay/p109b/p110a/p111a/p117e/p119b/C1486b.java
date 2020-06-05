package com.alipay.p109b.p110a.p111a.p117e.p119b;

import android.content.Context;
import com.alipay.p109b.p110a.p111a.p117e.C1479a;
import com.alipay.p109b.p110a.p111a.p117e.C1488d;
import com.alipay.p109b.p110a.p111a.p117e.p118a.C1481b;
import com.alipay.p109b.p110a.p111a.p117e.p118a.C1482c;
import com.alipay.p109b.p110a.p111a.p117e.p118a.C1483d;

/* renamed from: com.alipay.b.a.a.e.b.b */
public class C1486b implements C1485a {
    /* renamed from: a */
    private static C1485a f3782a;
    /* renamed from: b */
    private static C1479a f3783b;

    /* renamed from: a */
    public static C1485a m4380a(Context context, String str) {
        if (context == null) {
            return null;
        }
        if (f3782a == null) {
            f3783b = C1488d.m4383a(context, str);
            f3782a = new C1486b();
        }
        return f3782a;
    }

    /* renamed from: a */
    public C1482c mo12094a(C1483d dVar) {
        return C1481b.m4367a(f3783b.mo12089a(C1481b.m4368a(dVar)));
    }

    /* renamed from: a */
    public boolean mo12095a(String str) {
        return f3783b.mo12090a(str);
    }
}
