package com.alipay.apmobilesecuritysdk.p106d;

import android.content.Context;
import com.alipay.p109b.p110a.p111a.p112a.p113a.C1462b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.alipay.apmobilesecuritysdk.d.e */
public final class C1445e {
    /* renamed from: a */
    private static Map<String, String> f3697a;
    /* renamed from: b */
    private static final String[] f3698b = {"AD1", "AD2", "AD3", "AD8", "AD9", "AD10", "AD11", "AD12", "AD14", "AD15", "AD16", "AD18", "AD20", "AD21", "AD23", "AD24", "AD26", "AD27", "AD28", "AD29", "AD30", "AD31", "AD34", "AA1", "AA2", "AA3", "AA4", "AC4", "AC10", "AE1", "AE2", "AE3", "AE4", "AE5", "AE6", "AE7", "AE8", "AE9", "AE10", "AE11", "AE12", "AE13", "AE14", "AE15"};

    /* renamed from: a */
    private static String m4178a(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            String str = (String) arrayList.get(i);
            String str2 = (String) map.get(str);
            String str3 = "";
            if (str2 == null) {
                str2 = str3;
            }
            StringBuilder sb = new StringBuilder();
            if (i != 0) {
                str3 = "&";
            }
            sb.append(str3);
            sb.append(str);
            sb.append("=");
            sb.append(str2);
            stringBuffer.append(sb.toString());
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static synchronized Map<String, String> m4179a(Context context, Map<String, String> map) {
        Map<String, String> map2;
        synchronized (C1445e.class) {
            if (f3697a == null) {
                m4182c(context, map);
            }
            f3697a.putAll(C1444d.m4176a());
            map2 = f3697a;
        }
        return map2;
    }

    /* renamed from: a */
    public static synchronized void m4180a() {
        synchronized (C1445e.class) {
            f3697a = null;
        }
    }

    /* renamed from: b */
    public static synchronized String m4181b(Context context, Map<String, String> map) {
        String[] strArr;
        String a;
        synchronized (C1445e.class) {
            m4179a(context, map);
            TreeMap treeMap = new TreeMap();
            for (String str : f3698b) {
                if (f3697a.containsKey(str)) {
                    treeMap.put(str, f3697a.get(str));
                }
            }
            a = C1462b.m4270a(m4178a(treeMap));
        }
        return a;
    }

    /* renamed from: c */
    private static synchronized void m4182c(Context context, Map<String, String> map) {
        synchronized (C1445e.class) {
            TreeMap treeMap = new TreeMap();
            f3697a = treeMap;
            treeMap.putAll(C1442b.m4174a(context, map));
            f3697a.putAll(C1444d.m4177a(context));
            f3697a.putAll(C1443c.m4175a(context));
            f3697a.putAll(C1441a.m4173a(context, map));
        }
    }
}
