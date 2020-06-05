package com.p368pw.inner.p369a.p370a.p371a;

import android.text.TextUtils;
import com.p368pw.inner.base.p384a.C5123d;
import com.p368pw.inner.base.p384a.C5125f;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.p369a.p379e.C4958h;
import com.p368pw.p392us.Setting;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.pw.inner.a.a.a.b */
public class C4822b {
    /* renamed from: a */
    public static int m19709a() {
        C5123d d = C5125f.m21216a().mo26727d();
        return d.mo26721y() == 0 ? m19710a(110, 116) : d.mo26721y();
    }

    /* renamed from: a */
    public static int m19710a(int i, int i2) {
        return (int) (((double) i) + (Math.random() * ((double) (i2 - i))));
    }

    /* renamed from: a */
    public static C4958h m19711a(C4830h hVar, Setting setting) {
        C4958h hVar2 = null;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("offer vd sz = ");
            sb.append(hVar.mo25837b().size());
            C5205o.m21462a(sb.toString());
            if (hVar.mo25837b().size() > 0) {
                List g = m19719g(hVar);
                if (g.size() > 0) {
                    hVar2 = ((C4829g) g.get(0)).mo25833a();
                }
            }
            if (!(setting == null || hVar2 == null)) {
                hVar2.mo26240m(setting.getUuid());
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
        return hVar2;
    }

    /* renamed from: a */
    public static String m19712a(C4830h hVar) {
        try {
            List b = hVar.mo25837b();
            if (b != null && b.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < b.size(); i++) {
                    sb.append(((C4829g) b.get(i)).mo25833a().mo26248t());
                    sb.append(StorageInterface.KEY_SPLITER);
                }
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
        return null;
    }

    /* renamed from: b */
    public static int m19713b() {
        C5123d d = C5125f.m21216a().mo26727d();
        return d.mo26722z() == 0 ? m19710a(120, 122) : d.mo26722z();
    }

    /* renamed from: b */
    public static String m19714b(C4830h hVar) {
        try {
            List b = hVar.mo25837b();
            if (b != null && b.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < b.size(); i++) {
                    sb.append(((C4829g) b.get(i)).mo25834b().mo25832y());
                    sb.append(StorageInterface.KEY_SPLITER);
                }
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* renamed from: c */
    public static String m19715c(C4830h hVar) {
        try {
            List b = hVar.mo25837b();
            if (b != null && b.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < b.size(); i++) {
                    sb.append(((C4829g) b.get(i)).mo25835c().mo25786r());
                    sb.append(StorageInterface.KEY_SPLITER);
                }
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* renamed from: d */
    public static C4828f m19716d(C4830h hVar) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("z nv offer sz = ");
            sb.append(hVar.mo25837b().size());
            C5205o.m21462a(sb.toString());
            if (hVar.mo25837b().size() <= 0) {
                return null;
            }
            List h = m19720h(hVar);
            if (h.size() > 0) {
                return ((C4829g) h.get(0)).mo25834b();
            }
            return null;
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return null;
        }
    }

    /* renamed from: e */
    public static List<C4828f> m19717e(C4830h hVar) {
        ArrayList arrayList = new ArrayList();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("z nv offer sz = ");
            sb.append(hVar.mo25837b().size());
            C5205o.m21462a(sb.toString());
            if (hVar.mo25837b().size() > 0) {
                List h = m19720h(hVar);
                for (int i = 0; i < h.size(); i++) {
                    arrayList.add(((C4829g) h.get(i)).mo25834b());
                }
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
        return arrayList;
    }

    /* renamed from: f */
    public static C4826d m19718f(C4830h hVar) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("z ins offer sz = ");
            sb.append(hVar.mo25837b().size());
            C5205o.m21462a(sb.toString());
            if (hVar.mo25837b().size() <= 0) {
                return null;
            }
            List i = m19721i(hVar);
            if (i.size() <= 0) {
                return null;
            }
            i.size();
            return ((C4829g) i.get(0)).mo25835c();
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return null;
        }
    }

    /* renamed from: g */
    private static List<C4829g> m19719g(C4830h hVar) {
        ArrayList arrayList = new ArrayList();
        List b = hVar.mo25837b();
        for (int i = 0; i < b.size(); i++) {
            C4829g gVar = (C4829g) b.get(i);
            if (gVar.mo25833a() != null && !TextUtils.isEmpty(gVar.mo25833a().mo26214a())) {
                arrayList.add(gVar);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("filter vd creative list size = ");
        sb.append(arrayList.size());
        C5205o.m21462a(sb.toString());
        return arrayList;
    }

    /* renamed from: h */
    private static List<C4829g> m19720h(C4830h hVar) {
        ArrayList arrayList = new ArrayList();
        List b = hVar.mo25837b();
        for (int i = 0; i < b.size(); i++) {
            C4829g gVar = (C4829g) b.get(i);
            if (gVar.mo25834b() != null && !TextUtils.isEmpty(gVar.mo25834b().mo25808a())) {
                arrayList.add(gVar);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("z nv filter creative list size = ");
        sb.append(arrayList.size());
        C5205o.m21462a(sb.toString());
        return arrayList;
    }

    /* renamed from: i */
    private static List<C4829g> m19721i(C4830h hVar) {
        ArrayList arrayList = new ArrayList();
        List b = hVar.mo25837b();
        for (int i = 0; i < b.size(); i++) {
            C4829g gVar = (C4829g) b.get(i);
            if (gVar.mo25835c() != null && (!TextUtils.isEmpty(gVar.mo25835c().mo25769a()) || !TextUtils.isEmpty(gVar.mo25835c().mo25770b()))) {
                arrayList.add(gVar);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("z ins filter creative list size = ");
        sb.append(arrayList.size());
        C5205o.m21462a(sb.toString());
        return arrayList;
    }
}
