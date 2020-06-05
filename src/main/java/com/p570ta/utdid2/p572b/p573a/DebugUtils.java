package com.p570ta.utdid2.p572b.p573a;

import java.lang.reflect.Method;

/* renamed from: com.ta.utdid2.b.a.d */
public class DebugUtils {
    /* renamed from: a */
    private static Class<?> f22501a = null;
    /* renamed from: a */
    private static Method f22502a = null;
    /* renamed from: b */
    private static Method f22503b = null;
    /* renamed from: e */
    public static boolean f22504e;

    public static int getInt(String str, int i) {
        m29025a();
        try {
            i = ((Integer) f22503b.invoke(f22501a, new Object[]{str, Integer.valueOf(i)})).intValue();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    static {
        boolean z = false;
        if (getInt("alidebug", 0) == 1) {
            z = true;
        }
        f22504e = z;
    }

    /* renamed from: a */
    private static void m29025a() {
        try {
            if (f22501a == null) {
                f22501a = Class.forName("android.os.SystemProperties");
                f22502a = f22501a.getDeclaredMethod("get", new Class[]{String.class});
                f22503b = f22501a.getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
