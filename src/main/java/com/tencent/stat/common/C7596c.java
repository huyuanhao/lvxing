package com.tencent.stat.common;

import java.lang.reflect.Method;

/* renamed from: com.tencent.stat.common.c */
public class C7596c {
    /* renamed from: a */
    private static volatile int f25680a = -1;

    /* renamed from: a */
    public static String m32756a(String str) {
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            Method declaredMethod = cls.getDeclaredMethod("get", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(cls, new Object[]{str});
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m32757a() {
        boolean z = false;
        if (f25680a != -1) {
            if (f25680a == 1) {
                z = true;
            }
            return z;
        }
        try {
            if (!StatCommonHelper.isStringValid(m32756a("ro.miui.ui.version.code")) && !StatCommonHelper.isStringValid(m32756a(m32756a("ro.miui.ui.version.name")))) {
                if (!StatCommonHelper.isStringValid(m32756a(m32756a("ro.miui.internal.storage")))) {
                    f25680a = 0;
                    return false;
                }
            }
            f25680a = 1;
        } catch (Throwable unused) {
        }
        return false;
    }
}
