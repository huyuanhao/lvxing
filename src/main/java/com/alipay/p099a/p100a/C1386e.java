package com.alipay.p099a.p100a;

import com.alipay.p099a.p101b.C1394a;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.alipay.C8576a;
import org.json.alipay.C8577b;

/* renamed from: com.alipay.a.a.e */
public final class C1386e {
    /* renamed from: a */
    static List<C1390i> f3594a;

    static {
        ArrayList arrayList = new ArrayList();
        f3594a = arrayList;
        arrayList.add(new C1393l());
        f3594a.add(new C1385d());
        f3594a.add(new C1384c());
        f3594a.add(new C1389h());
        f3594a.add(new C1392k());
        f3594a.add(new C1383b());
        f3594a.add(new C1382a());
        f3594a.add(new C1388g());
    }

    /* renamed from: a */
    public static final <T> T m4044a(Object obj, Type type) {
        for (C1390i iVar : f3594a) {
            if (iVar.mo11909a(C1394a.m4064a(type))) {
                T a = iVar.mo11908a(obj, type);
                if (a != null) {
                    return a;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static final Object m4045a(String str, Type type) {
        Object bVar;
        if (str == null || str.length() == 0) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("[") && trim.endsWith("]")) {
            bVar = new C8576a(trim);
        } else if (!trim.startsWith("{") || !trim.endsWith("}")) {
            return m4044a((Object) trim, type);
        } else {
            bVar = new C8577b(trim);
        }
        return m4044a(bVar, type);
    }
}
