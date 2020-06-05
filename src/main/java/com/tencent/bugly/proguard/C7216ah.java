package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.C7121b;
import com.tencent.bugly.C8712a;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.info.C7174a;
import com.tencent.bugly.crashreport.common.info.C7175b;
import com.tencent.bugly.crashreport.common.strategy.C7177a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ah */
public class C7216ah {
    /* renamed from: a */
    public static C7254bl m31075a(UserInfoBean userInfoBean, C7174a aVar) {
        if (userInfoBean == null) {
            return null;
        }
        C7254bl blVar = new C7254bl();
        blVar.f24538a = userInfoBean.f23913e;
        blVar.f24542e = userInfoBean.f23918j;
        blVar.f24541d = userInfoBean.f23911c;
        blVar.f24540c = userInfoBean.f23912d;
        blVar.f24544g = C7174a.m30754b().mo34596i();
        blVar.f24545h = userInfoBean.f23923o == 1;
        int i = userInfoBean.f23910b;
        if (i == 1) {
            blVar.f24539b = 1;
        } else if (i == 2) {
            blVar.f24539b = 4;
        } else if (i == 3) {
            blVar.f24539b = 2;
        } else if (i == 4) {
            blVar.f24539b = 3;
        } else if (userInfoBean.f23910b < 10 || userInfoBean.f23910b >= 20) {
            C7226an.m31149e("unknown uinfo type %d ", Integer.valueOf(userInfoBean.f23910b));
            return null;
        } else {
            blVar.f24539b = (byte) userInfoBean.f23910b;
        }
        blVar.f24543f = new HashMap();
        String str = "";
        if (userInfoBean.f23924p >= 0) {
            Map<String, String> map = blVar.f24543f;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(userInfoBean.f23924p);
            map.put("C01", sb.toString());
        }
        if (userInfoBean.f23925q >= 0) {
            Map<String, String> map2 = blVar.f24543f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(userInfoBean.f23925q);
            map2.put("C02", sb2.toString());
        }
        if (userInfoBean.f23926r != null && userInfoBean.f23926r.size() > 0) {
            for (Entry entry : userInfoBean.f23926r.entrySet()) {
                Map<String, String> map3 = blVar.f24543f;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("C03_");
                sb3.append((String) entry.getKey());
                map3.put(sb3.toString(), entry.getValue());
            }
        }
        if (userInfoBean.f23927s != null && userInfoBean.f23927s.size() > 0) {
            for (Entry entry2 : userInfoBean.f23927s.entrySet()) {
                Map<String, String> map4 = blVar.f24543f;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("C04_");
                sb4.append((String) entry2.getKey());
                map4.put(sb4.toString(), entry2.getValue());
            }
        }
        Map<String, String> map5 = blVar.f24543f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append(!userInfoBean.f23920l);
        map5.put("A36", sb5.toString());
        Map<String, String> map6 = blVar.f24543f;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(str);
        sb6.append(userInfoBean.f23915g);
        map6.put("F02", sb6.toString());
        Map<String, String> map7 = blVar.f24543f;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(str);
        sb7.append(userInfoBean.f23916h);
        map7.put("F03", sb7.toString());
        Map<String, String> map8 = blVar.f24543f;
        StringBuilder sb8 = new StringBuilder();
        sb8.append(str);
        sb8.append(userInfoBean.f23918j);
        map8.put("F04", sb8.toString());
        Map<String, String> map9 = blVar.f24543f;
        StringBuilder sb9 = new StringBuilder();
        sb9.append(str);
        sb9.append(userInfoBean.f23917i);
        map9.put("F05", sb9.toString());
        Map<String, String> map10 = blVar.f24543f;
        StringBuilder sb10 = new StringBuilder();
        sb10.append(str);
        sb10.append(userInfoBean.f23921m);
        map10.put("F06", sb10.toString());
        Map<String, String> map11 = blVar.f24543f;
        StringBuilder sb11 = new StringBuilder();
        sb11.append(str);
        sb11.append(userInfoBean.f23919k);
        map11.put("F10", sb11.toString());
        C7226an.m31147c("summary type %d vm:%d", Byte.valueOf(blVar.f24539b), Integer.valueOf(blVar.f24543f.size()));
        return blVar;
    }

    /* renamed from: a */
    public static C7255bm m31076a(List<UserInfoBean> list, int i) {
        if (list == null || list.size() == 0) {
            return null;
        }
        C7174a b = C7174a.m30754b();
        if (b == null) {
            return null;
        }
        b.mo34607t();
        C7255bm bmVar = new C7255bm();
        bmVar.f24549b = b.f24024e;
        bmVar.f24550c = b.mo34595h();
        ArrayList<C7254bl> arrayList = new ArrayList<>();
        for (UserInfoBean a : list) {
            C7254bl a2 = m31075a(a, b);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        bmVar.f24551d = arrayList;
        bmVar.f24552e = new HashMap();
        Map<String, String> map = bmVar.f24552e;
        StringBuilder sb = new StringBuilder();
        String str = "";
        sb.append(str);
        sb.append(b.f24031l);
        map.put("A7", sb.toString());
        Map<String, String> map2 = bmVar.f24552e;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(b.mo34606s());
        map2.put("A6", sb2.toString());
        Map<String, String> map3 = bmVar.f24552e;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(b.mo34605r());
        map3.put("A5", sb3.toString());
        Map<String, String> map4 = bmVar.f24552e;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str);
        sb4.append(b.mo34603p());
        map4.put("A2", sb4.toString());
        Map<String, String> map5 = bmVar.f24552e;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append(b.mo34603p());
        map5.put("A1", sb5.toString());
        Map<String, String> map6 = bmVar.f24552e;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(str);
        sb6.append(b.f24033n);
        map6.put("A24", sb6.toString());
        Map<String, String> map7 = bmVar.f24552e;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(str);
        sb7.append(b.mo34604q());
        map7.put("A17", sb7.toString());
        Map<String, String> map8 = bmVar.f24552e;
        StringBuilder sb8 = new StringBuilder();
        sb8.append(str);
        sb8.append(b.mo34610w());
        map8.put("A15", sb8.toString());
        Map<String, String> map9 = bmVar.f24552e;
        StringBuilder sb9 = new StringBuilder();
        sb9.append(str);
        sb9.append(b.mo34611x());
        map9.put("A13", sb9.toString());
        Map<String, String> map10 = bmVar.f24552e;
        StringBuilder sb10 = new StringBuilder();
        sb10.append(str);
        sb10.append(b.f23964B);
        map10.put("F08", sb10.toString());
        Map<String, String> map11 = bmVar.f24552e;
        StringBuilder sb11 = new StringBuilder();
        sb11.append(str);
        sb11.append(b.f23965C);
        map11.put("F09", sb11.toString());
        Map G = b.mo34561G();
        if (G != null && G.size() > 0) {
            for (Entry entry : G.entrySet()) {
                Map<String, String> map12 = bmVar.f24552e;
                StringBuilder sb12 = new StringBuilder();
                sb12.append("C04_");
                sb12.append((String) entry.getKey());
                map12.put(sb12.toString(), entry.getValue());
            }
        }
        if (i == 1) {
            bmVar.f24548a = 1;
        } else if (i != 2) {
            C7226an.m31149e("unknown up type %d ", Integer.valueOf(i));
            return null;
        } else {
            bmVar.f24548a = 2;
        }
        return bmVar;
    }

    /* renamed from: a */
    public static <T extends C7267m> T m31077a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T t = (C7267m) cls.newInstance();
                C7264k kVar = new C7264k(bArr);
                kVar.mo34903a("utf-8");
                t.mo34760a(kVar);
                return t;
            } catch (Throwable th) {
                if (!C7226an.m31145b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C7250bh m31073a(Context context, int i, byte[] bArr) {
        C7174a b = C7174a.m30754b();
        StrategyBean c = C7177a.m30857a().mo34624c();
        if (b == null || c == null) {
            C7226an.m31149e("Can not create request pkg for parameters is invalid.", new Object[0]);
            return null;
        }
        try {
            C7250bh bhVar = new C7250bh();
            synchronized (b) {
                bhVar.f24486a = b.f24022c;
                bhVar.f24487b = b.mo34591f();
                bhVar.f24488c = b.f24023d;
                bhVar.f24489d = b.f24035p;
                bhVar.f24490e = b.f24037r;
                b.getClass();
                bhVar.f24491f = "3.1.0";
                bhVar.f24492g = i;
                bhVar.f24493h = bArr == null ? "".getBytes() : bArr;
                bhVar.f24494i = b.f24032m;
                bhVar.f24495j = b.f24033n;
                bhVar.f24496k = new HashMap();
                bhVar.f24497l = b.mo34589e();
                bhVar.f24498m = c.f24066p;
                bhVar.f24500o = b.mo34595h();
                bhVar.f24501p = C7175b.m30828f(context);
                bhVar.f24502q = System.currentTimeMillis();
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(b.mo34598k());
                bhVar.f24503r = sb.toString();
                bhVar.f24504s = b.mo34597j();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(b.mo34600m());
                bhVar.f24505t = sb2.toString();
                bhVar.f24506u = b.mo34599l();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("");
                sb3.append(b.mo34601n());
                bhVar.f24507v = sb3.toString();
                bhVar.f24508w = bhVar.f24501p;
                b.getClass();
                bhVar.f24499n = "com.tencent.bugly";
                StringBuilder sb4 = new StringBuilder();
                sb4.append("");
                sb4.append(b.mo34612y());
                bhVar.f24496k.put("A26", sb4.toString());
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                sb5.append(b.mo34613z());
                bhVar.f24496k.put("A60", sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append("");
                sb6.append(b.mo34555A());
                bhVar.f24496k.put("A61", sb6.toString());
                StringBuilder sb7 = new StringBuilder();
                sb7.append("");
                sb7.append(b.mo34572R());
                bhVar.f24496k.put("A62", sb7.toString());
                StringBuilder sb8 = new StringBuilder();
                sb8.append("");
                sb8.append(b.mo34573S());
                bhVar.f24496k.put("A63", sb8.toString());
                StringBuilder sb9 = new StringBuilder();
                sb9.append("");
                sb9.append(b.f23968F);
                bhVar.f24496k.put("F11", sb9.toString());
                StringBuilder sb10 = new StringBuilder();
                sb10.append("");
                sb10.append(b.f23967E);
                bhVar.f24496k.put("F12", sb10.toString());
                StringBuilder sb11 = new StringBuilder();
                sb11.append("");
                sb11.append(b.mo34608u());
                bhVar.f24496k.put("G1", sb11.toString());
                StringBuilder sb12 = new StringBuilder();
                sb12.append("");
                sb12.append(b.mo34574T());
                bhVar.f24496k.put("A64", sb12.toString());
                if (b.f23972J) {
                    StringBuilder sb13 = new StringBuilder();
                    sb13.append("");
                    sb13.append(b.mo34566L());
                    bhVar.f24496k.put("G2", sb13.toString());
                    StringBuilder sb14 = new StringBuilder();
                    sb14.append("");
                    sb14.append(b.mo34567M());
                    bhVar.f24496k.put("G3", sb14.toString());
                    StringBuilder sb15 = new StringBuilder();
                    sb15.append("");
                    sb15.append(b.mo34568N());
                    bhVar.f24496k.put("G4", sb15.toString());
                    StringBuilder sb16 = new StringBuilder();
                    sb16.append("");
                    sb16.append(b.mo34569O());
                    bhVar.f24496k.put("G5", sb16.toString());
                    StringBuilder sb17 = new StringBuilder();
                    sb17.append("");
                    sb17.append(b.mo34570P());
                    bhVar.f24496k.put("G6", sb17.toString());
                    StringBuilder sb18 = new StringBuilder();
                    sb18.append("");
                    sb18.append(Long.toString(b.mo34571Q()));
                    bhVar.f24496k.put("G7", sb18.toString());
                }
                StringBuilder sb19 = new StringBuilder();
                sb19.append("");
                sb19.append(b.f24036q);
                bhVar.f24496k.put("D3", sb19.toString());
                if (C7121b.f23664b != null) {
                    for (C8712a aVar : C7121b.f23664b) {
                        if (!(aVar.versionKey == null || aVar.version == null)) {
                            bhVar.f24496k.put(aVar.versionKey, aVar.version);
                        }
                    }
                }
                bhVar.f24496k.put("G15", C7232aq.m31219c("G15", ""));
                bhVar.f24496k.put("D4", C7232aq.m31219c("D4", "0"));
            }
            C7219ak a = C7219ak.m31089a();
            if (!(a == null || a.f24342b || bArr == null)) {
                bhVar.f24493h = C7232aq.m31202a(bhVar.f24493h, 2, 1, c.f24071u);
                if (bhVar.f24493h == null) {
                    C7226an.m31149e("reqPkg sbuffer error!", new Object[0]);
                    return null;
                }
            }
            Map F = b.mo34560F();
            if (F != null) {
                for (Entry entry : F.entrySet()) {
                    bhVar.f24496k.put(entry.getKey(), entry.getValue());
                }
            }
            return bhVar;
        } catch (Throwable th) {
            if (!C7226an.m31145b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m31079a(Object obj) {
        try {
            C7258e eVar = new C7258e();
            eVar.mo34871b();
            eVar.mo34866a("utf-8");
            eVar.mo34872a(1);
            eVar.mo34875b("RqdServer");
            eVar.mo34876c("sync");
            eVar.mo34867a("detail", obj);
            return eVar.mo34869a();
        } catch (Throwable th) {
            if (!C7226an.m31145b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public static C7251bi m31074a(byte[] bArr, StrategyBean strategyBean, boolean z) {
        if (bArr != null) {
            try {
                C7258e eVar = new C7258e();
                eVar.mo34871b();
                eVar.mo34866a("utf-8");
                eVar.mo34868a(bArr);
                Object b = eVar.mo34870b("detail", new C7251bi());
                C7251bi biVar = C7251bi.class.isInstance(b) ? (C7251bi) C7251bi.class.cast(b) : null;
                if (!z && biVar != null && biVar.f24514c != null && biVar.f24514c.length > 0) {
                    C7226an.m31147c("resp buf %d", Integer.valueOf(biVar.f24514c.length));
                    biVar.f24514c = C7232aq.m31216b(biVar.f24514c, 2, 1, StrategyBean.f24054d);
                    if (biVar.f24514c == null) {
                        C7226an.m31149e("resp sbuffer error!", new Object[0]);
                        return null;
                    }
                }
                return biVar;
            } catch (Throwable th) {
                if (!C7226an.m31145b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static byte[] m31078a(C7267m mVar) {
        try {
            C7266l lVar = new C7266l();
            lVar.mo34924a("utf-8");
            mVar.mo34761a(lVar);
            return lVar.mo34947b();
        } catch (Throwable th) {
            if (!C7226an.m31145b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }
}
