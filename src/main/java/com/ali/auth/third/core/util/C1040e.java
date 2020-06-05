package com.ali.auth.third.core.util;

import com.ali.auth.third.core.p033j.C1018a;
import com.tencent.android.tpush.SettingsContentProvider;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.ali.auth.third.core.util.e */
public class C1040e {
    /* renamed from: a */
    private static final Map<String, Class<?>> f2085a = new HashMap();
    /* renamed from: b */
    private static final String f2086b = C1040e.class.getSimpleName();

    static {
        f2085a.put("short", Short.TYPE);
        f2085a.put("int", Integer.TYPE);
        f2085a.put(SettingsContentProvider.LONG_TYPE, Long.TYPE);
        f2085a.put("double", Double.TYPE);
        f2085a.put(SettingsContentProvider.FLOAT_TYPE, Float.TYPE);
        f2085a.put("char", Character.TYPE);
        f2085a.put(SettingsContentProvider.BOOLEAN_TYPE, Boolean.TYPE);
    }

    /* renamed from: a */
    public static <T> T m2000a(Class<T> cls, Class<?>[] clsArr, Object[] objArr) {
        if (clsArr != null) {
            try {
                if (clsArr.length != 0) {
                    return cls.getConstructor(clsArr).newInstance(objArr);
                }
            } catch (Exception e) {
                String str = f2086b;
                StringBuilder sb = new StringBuilder();
                sb.append("Fail to create the instance of type ");
                sb.append(cls.getName());
                sb.append(", the error is ");
                sb.append(e.getMessage());
                C1018a.m1967d(str, sb.toString());
                throw new RuntimeException(e);
            }
        }
        return cls.newInstance();
    }

    /* renamed from: a */
    public static Object m2001a(String str, String[] strArr, Object[] objArr) {
        try {
            r2 = str;
            r2 = m2000a(Class.forName(str), (Class<?>[]) m2002a(strArr), objArr);
            r2 = r2;
            return r2;
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            String str2 = f2086b;
            StringBuilder sb = new StringBuilder();
            sb.append("Fail to create the instance of type ");
            sb.append(r2);
            sb.append(", the error is ");
            sb.append(e2.getMessage());
            C1018a.m1967d(str2, sb.toString());
            throw new RuntimeException(e2);
        }
    }

    /* renamed from: a */
    public static Class<?>[] m2002a(String[] strArr) throws Exception {
        if (strArr == null) {
            return null;
        }
        Class<?>[] clsArr = new Class[strArr.length];
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            if (str.length() < 8) {
                clsArr[i] = (Class) f2085a.get(str);
            }
            if (clsArr[i] == null) {
                clsArr[i] = Class.forName(str);
            }
        }
        return clsArr;
    }
}
