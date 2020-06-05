package com.alibaba.fastjson.p065a;

import com.tencent.android.tpush.SettingsContentProvider;
import com.tencent.mid.sotrage.StorageInterface;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.alibaba.fastjson.a.k */
public class TypeCollector {
    /* renamed from: b */
    private static final Map<String, String> f2594b = new HashMap<String, String>() {
        {
            put("int", "I");
            put(SettingsContentProvider.BOOLEAN_TYPE, "Z");
            put("byte", "B");
            put("char", "C");
            put("short", "S");
            put(SettingsContentProvider.FLOAT_TYPE, "F");
            put(SettingsContentProvider.LONG_TYPE, "J");
            put("double", "D");
        }
    };
    /* renamed from: a */
    protected MethodCollector f2595a = null;
    /* renamed from: c */
    private final String f2596c;
    /* renamed from: d */
    private final Class<?>[] f2597d;

    public TypeCollector(String str, Class<?>[] clsArr) {
        this.f2596c = str;
        this.f2597d = clsArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public MethodCollector mo11047a(int i, String str, String str2) {
        if (this.f2595a != null || !str.equals(this.f2596c)) {
            return null;
        }
        Type[] c = Type.m2511c(str2);
        int i2 = 0;
        for (Type c2 : c) {
            String c3 = c2.mo11046c();
            if (c3.equals(SettingsContentProvider.LONG_TYPE) || c3.equals("double")) {
                i2++;
            }
        }
        if (c.length != this.f2597d.length) {
            return null;
        }
        for (int i3 = 0; i3 < c.length; i3++) {
            if (!m2516a(c[i3], this.f2597d[i3].getName())) {
                return null;
            }
        }
        MethodCollector gVar = new MethodCollector(!Modifier.isStatic(i), c.length + i2);
        this.f2595a = gVar;
        return gVar;
    }

    /* renamed from: a */
    private boolean m2516a(Type jVar, String str) {
        String c = jVar.mo11046c();
        String str2 = "";
        String str3 = str2;
        while (c.endsWith("[]")) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append("[");
            str3 = sb.toString();
            c = c.substring(0, c.length() - 2);
        }
        if (!str3.equals(str2)) {
            if (f2594b.containsKey(c)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str3);
                sb2.append((String) f2594b.get(c));
                c = sb2.toString();
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str3);
                sb3.append("L");
                sb3.append(c);
                sb3.append(";");
                c = sb3.toString();
            }
        }
        return c.equals(str);
    }

    /* renamed from: a */
    public String[] mo11048a() {
        MethodCollector gVar = this.f2595a;
        return (gVar == null || !gVar.f2566a) ? new String[0] : this.f2595a.mo11028a().split(StorageInterface.KEY_SPLITER);
    }
}
