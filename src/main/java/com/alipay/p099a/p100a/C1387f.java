package com.alipay.p099a.p100a;

import com.alipay.p099a.p101b.C1394a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.json.alipay.C8576a;
import org.json.alipay.C8577b;

/* renamed from: com.alipay.a.a.f */
public final class C1387f {
    /* renamed from: a */
    private static List<C1391j> f3595a;

    static {
        ArrayList arrayList = new ArrayList();
        f3595a = arrayList;
        arrayList.add(new C1393l());
        f3595a.add(new C1385d());
        f3595a.add(new C1384c());
        f3595a.add(new C1389h());
        f3595a.add(new C1383b());
        f3595a.add(new C1382a());
        f3595a.add(new C1388g());
    }

    /* renamed from: a */
    public static String m4046a(Object obj) {
        if (obj == null) {
            return null;
        }
        Object b = m4047b(obj);
        if (C1394a.m4065a(b.getClass())) {
            return C8577b.m37303c(b.toString());
        }
        if (Collection.class.isAssignableFrom(b.getClass())) {
            return new C8576a((Collection) (List) b).toString();
        }
        if (Map.class.isAssignableFrom(b.getClass())) {
            return new C8577b((Map) b).toString();
        }
        StringBuilder sb = new StringBuilder("Unsupported Class : ");
        sb.append(b.getClass());
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: b */
    public static Object m4047b(Object obj) {
        if (obj == null) {
            return null;
        }
        for (C1391j jVar : f3595a) {
            if (jVar.mo11909a(obj.getClass())) {
                Object a = jVar.mo11907a(obj);
                if (a != null) {
                    return a;
                }
            }
        }
        StringBuilder sb = new StringBuilder("Unsupported Class : ");
        sb.append(obj.getClass());
        throw new IllegalArgumentException(sb.toString());
    }
}
