package com.tencent.android.tpush.service.cache;

import java.util.HashMap;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.cache.a */
public class C6999a {
    /* renamed from: a */
    private static volatile HashMap<Object, Object> f23244a = new HashMap<>(10);

    /* renamed from: a */
    public static synchronized void m29931a(Object obj, Object obj2) {
        synchronized (C6999a.class) {
            f23244a.put(obj, obj2);
        }
    }

    /* renamed from: a */
    public static synchronized Object m29930a(Object obj) {
        Object obj2;
        synchronized (C6999a.class) {
            obj2 = f23244a.get(obj);
        }
        return obj2;
    }
}
