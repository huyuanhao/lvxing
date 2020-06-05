package com.qiyukf.nimlib.p473h;

import com.qiyukf.nimlib.p429a.C5645a;
import com.qiyukf.nimlib.p470f.C5837d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qiyukf.nimlib.h.g */
public final class C5911g {
    /* renamed from: a */
    private static ArrayList<C5645a> f18680a;

    /* renamed from: a */
    public static synchronized void m23675a() {
        synchronized (C5911g.class) {
            boolean z = f18680a != null && f18680a.size() > 0;
            f18680a = null;
            if (z) {
                C5837d.m23401a();
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m23676a(ArrayList<C5645a> arrayList) {
        synchronized (C5911g.class) {
            f18680a = arrayList;
            C5837d.m23401a();
        }
    }

    /* renamed from: a */
    public static synchronized void m23677a(List<C5645a> list) {
        synchronized (C5911g.class) {
            m23680c(list);
            C5837d.m23401a();
        }
    }

    /* renamed from: b */
    public static ArrayList<C5645a> m23678b() {
        return f18680a;
    }

    /* renamed from: b */
    public static synchronized void m23679b(List<C5645a> list) {
        synchronized (C5911g.class) {
            m23680c(list);
            if (f18680a == null) {
                f18680a = new ArrayList<>();
            }
            for (C5645a add : list) {
                f18680a.add(add);
            }
            C5837d.m23401a();
        }
    }

    /* renamed from: c */
    private static synchronized void m23680c(List<C5645a> list) {
        synchronized (C5911g.class) {
            if (f18680a != null) {
                for (C5645a remove : list) {
                    f18680a.remove(remove);
                }
                if (f18680a.size() == 0) {
                    f18680a = null;
                }
            }
        }
    }
}
