package com.alipay.sdk.app;

/* renamed from: com.alipay.sdk.app.j */
public class C1503j {
    /* renamed from: a */
    private static boolean f3840a = false;
    /* renamed from: b */
    private static String f3841b;

    /* renamed from: a */
    public static void m4439a(String str) {
        f3841b = str;
    }

    /* renamed from: a */
    public static String m4437a() {
        return f3841b;
    }

    /* renamed from: b */
    public static boolean m4441b() {
        return f3840a;
    }

    /* renamed from: a */
    public static void m4440a(boolean z) {
        f3840a = z;
    }

    /* renamed from: c */
    public static String m4442c() {
        C1504k b = C1504k.m4445b(C1504k.CANCELED.mo12142a());
        return m4438a(b.mo12142a(), b.mo12145b(), "");
    }

    /* renamed from: d */
    public static String m4443d() {
        C1504k b = C1504k.m4445b(C1504k.DOUBLE_REQUEST.mo12142a());
        return m4438a(b.mo12142a(), b.mo12145b(), "");
    }

    /* renamed from: e */
    public static String m4444e() {
        C1504k b = C1504k.m4445b(C1504k.PARAMS_ERROR.mo12142a());
        return m4438a(b.mo12142a(), b.mo12145b(), "");
    }

    /* renamed from: a */
    public static String m4438a(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("resultStatus={");
        sb.append(i);
        sb.append("};memo={");
        sb.append(str);
        sb.append("};result={");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }
}
