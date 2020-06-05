package com.tencent.bugly.proguard;

import com.tencent.android.tpush.SettingsContentProvider;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.a */
public class C7205a {
    /* renamed from: a */
    public static String m31016a(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.set(i, m31015a((String) arrayList.get(i)));
        }
        Collections.reverse(arrayList);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            String str = (String) arrayList.get(i2);
            String str2 = ">";
            String str3 = "<";
            if (str.equals("list")) {
                int i3 = i2 - 1;
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append((String) arrayList.get(i3));
                arrayList.set(i3, sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append((String) arrayList.get(0));
                sb2.append(str2);
                arrayList.set(0, sb2.toString());
            } else if (str.equals("map")) {
                int i4 = i2 - 1;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str3);
                sb3.append((String) arrayList.get(i4));
                sb3.append(StorageInterface.KEY_SPLITER);
                arrayList.set(i4, sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append((String) arrayList.get(0));
                sb4.append(str2);
                arrayList.set(0, sb4.toString());
            } else if (str.equals("Array")) {
                int i5 = i2 - 1;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str3);
                sb5.append((String) arrayList.get(i5));
                arrayList.set(i5, sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append((String) arrayList.get(0));
                sb6.append(str2);
                arrayList.set(0, sb6.toString());
            }
        }
        Collections.reverse(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((String) it.next());
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static String m31015a(String str) {
        if (str.equals("java.lang.Integer") || str.equals("int")) {
            return "int32";
        }
        if (str.equals("java.lang.Boolean") || str.equals(SettingsContentProvider.BOOLEAN_TYPE)) {
            return "bool";
        }
        if (str.equals("java.lang.Byte") || str.equals("byte")) {
            return "char";
        }
        String str2 = "double";
        if (!str.equals("java.lang.Double") && !str.equals(str2)) {
            boolean equals = str.equals("java.lang.Float");
            str2 = SettingsContentProvider.FLOAT_TYPE;
            if (!equals && !str.equals(str2)) {
                if (str.equals("java.lang.Long") || str.equals(SettingsContentProvider.LONG_TYPE)) {
                    return "int64";
                }
                String str3 = "short";
                if (str.equals("java.lang.Short") || str.equals(str3)) {
                    return str3;
                }
                if (str.equals("java.lang.Character")) {
                    throw new IllegalArgumentException("can not support java.lang.Character");
                } else if (str.equals("java.lang.String")) {
                    return SettingsContentProvider.STRING_TYPE;
                } else {
                    if (str.equals("java.util.List")) {
                        return "list";
                    }
                    if (str.equals("java.util.Map")) {
                        str = "map";
                    }
                    return str;
                }
            }
        }
        return str2;
    }
}
