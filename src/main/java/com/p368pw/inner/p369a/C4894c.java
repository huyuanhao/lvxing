package com.p368pw.inner.p369a;

import android.content.Context;
import com.p368pw.inner.base.p387d.C5205o;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.pw.inner.a.c */
public class C4894c {

    /* renamed from: com.pw.inner.a.c$a */
    private static class C4895a {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static C4894c f15818a = new C4894c();
    }

    /* renamed from: a */
    public static C4894c m20178a() {
        return C4895a.f15818a;
    }

    /* renamed from: a */
    public static List<C4967g> m20179a(List<C4967g> list) {
        if (!(list == null || list.size() == 0)) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                for (int i3 = i2; i3 < size; i3++) {
                    if (((C4967g) list.get(i)).mo26303d() < ((C4967g) list.get(i3)).mo26303d()) {
                        C4967g gVar = (C4967g) list.get(i3);
                        list.set(i3, list.get(i));
                        list.set(i, gVar);
                    }
                }
                i = i2;
            }
        }
        return list;
    }

    /* renamed from: b */
    private C4967g m20180b(List<C4967g> list) {
        C4967g gVar;
        C4967g gVar2;
        C4967g gVar3 = null;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (gVar3 == null) {
                            gVar2 = (C4967g) list.get(i);
                        } else {
                            gVar2 = (C4967g) list.get(i);
                            if (gVar2.mo26303d() <= gVar3.mo26303d()) {
                            }
                        }
                        gVar3 = gVar2;
                    }
                }
            } catch (Throwable th) {
                C5205o.m21464a(th);
            }
        }
        return gVar;
    }

    /* renamed from: c */
    private C4967g m20181c(List<C4967g> list) {
        C4967g gVar;
        C4967g gVar2;
        C4967g gVar3 = null;
        try {
            int size = list.size();
            if (size < 2) {
                return (C4967g) list.get(0);
            }
            if (((C4967g) list.get(0)).mo26303d() > ((C4967g) list.get(1)).mo26303d()) {
                gVar = (C4967g) list.get(0);
                gVar2 = (C4967g) list.get(1);
            } else {
                gVar = (C4967g) list.get(1);
                gVar2 = (C4967g) list.get(0);
            }
            if (size >= 3) {
                gVar3 = gVar2;
                for (int i = 2; i < size; i++) {
                    if (gVar.mo26303d() < ((C4967g) list.get(i)).mo26303d()) {
                        try {
                            C4967g gVar4 = gVar;
                            gVar = (C4967g) list.get(i);
                            gVar3 = gVar4;
                        } catch (Throwable unused) {
                            gVar3 = gVar;
                        }
                    } else if (gVar3.mo26303d() < ((C4967g) list.get(i)).mo26303d()) {
                        gVar3 = (C4967g) list.get(i);
                    }
                }
            } else {
                gVar3 = gVar2;
            }
            return gVar3;
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: a */
    public C4967g mo25972a(Context context, C4875b bVar, int i, String str, int i2) {
        C4967g gVar = new C4967g(i, str);
        try {
            ArrayList a = bVar.mo25894a();
            if (a == null || a.size() <= 0) {
                return gVar;
            }
            int size = a.size();
            for (int i3 = 0; i3 < size; i3++) {
                C4966f fVar = (C4966f) a.get(i3);
                if (str.equals(fVar.mo26292a())) {
                    if (i2 == 1) {
                        gVar = m20180b(fVar.mo26293b());
                    }
                    if (i2 == 2) {
                        gVar = m20181c(fVar.mo26293b());
                    }
                    if (i2 < 3) {
                        return gVar;
                    }
                    List a2 = m20179a(fVar.mo26293b());
                    return i2 <= a2.size() ? (C4967g) a2.get(i2 - 1) : gVar;
                }
            }
            return gVar;
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return gVar;
        }
    }

    /* renamed from: a */
    public boolean mo25973a(Context context, C4875b bVar, String str, int i) {
        try {
            ArrayList a = bVar.mo25894a();
            if (a == null || a.size() <= 0) {
                return false;
            }
            int size = a.size();
            for (int i2 = 0; i2 < size; i2++) {
                C4966f fVar = (C4966f) a.get(i2);
                if (str.equals(fVar.mo26292a())) {
                    ArrayList b = fVar.mo26293b();
                    if (b != null && b.size() > 0 && b.size() >= i) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return false;
        }
    }

    /* renamed from: b */
    public C4967g mo25974b() {
        C4967g gVar = new C4967g(null);
        gVar.mo26297a("x");
        gVar.mo26300b("1");
        gVar.mo26295a(9000);
        gVar.mo26299b(6);
        gVar.mo26302c(3);
        gVar.mo26304d(1);
        gVar.mo26306e(1);
        return gVar;
    }
}
