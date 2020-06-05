package com.alibaba.mtl.log.p077d;

/* renamed from: com.alibaba.mtl.log.d.q */
public class SystemProperties {
    /* renamed from: a */
    public static String m3865a(String str) {
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a */
    public static String m3866a(String str, String str2) {
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(cls, new Object[]{str, str2});
        } catch (Exception unused) {
            return str2;
        }
    }
}
