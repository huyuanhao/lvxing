package com.bytedance.sdk.openadsdk.utils;

import java.lang.reflect.Method;

/* renamed from: com.bytedance.sdk.openadsdk.utils.aa */
public class Reflection {
    /* renamed from: a */
    private static Object f9107a;
    /* renamed from: b */
    private static Method f9108b;

    static {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", new Class[]{String.class});
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class});
            Class cls = (Class) declaredMethod.invoke(null, new Object[]{"dalvik.system.VMRuntime"});
            Method method = (Method) declaredMethod2.invoke(cls, new Object[]{"getRuntime", null});
            f9108b = (Method) declaredMethod2.invoke(cls, new Object[]{"setHiddenApiExemptions", new Class[]{String[].class}});
            f9107a = method.invoke(null, new Object[0]);
        } catch (Throwable th) {
            C2564t.m12221b("Reflection", "reflect bootstrap failed:", th);
        }
    }

    /* renamed from: a */
    public static boolean m11928a(String... strArr) {
        Object obj = f9107a;
        if (obj != null) {
            Method method = f9108b;
            if (method != null) {
                try {
                    method.invoke(obj, new Object[]{strArr});
                    return true;
                } catch (Throwable unused) {
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m11927a() {
        return m11928a("L");
    }
}
