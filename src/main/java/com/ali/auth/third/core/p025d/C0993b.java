package com.ali.auth.third.core.p025d;

import android.text.TextUtils;
import org.json.JSONObject;

/* renamed from: com.ali.auth.third.core.d.b */
public class C0993b {
    /* renamed from: a */
    private static final int f1927a = 6;
    /* renamed from: b */
    private static final int f1928b = 8;

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005a, code lost:
            if (r0 == -1) goto L_0x01ea;
     */
    /* renamed from: a */
    public static com.ali.auth.third.core.p025d.C0997e m1897a(java.lang.String r19) {
        /*
        r1 = r19
        int r2 = r19.length()
        r3 = 0
        r0 = 0
    L_0x0008:
        r4 = 0
        if (r0 < 0) goto L_0x01ea
        if (r0 < r2) goto L_0x000f
        goto L_0x01ea
    L_0x000f:
        char r5 = r1.charAt(r0)
        r6 = 32
        if (r5 != r6) goto L_0x001a
        int r0 = r0 + 1
        goto L_0x0008
    L_0x001a:
        r5 = 59
        int r7 = r1.indexOf(r5, r0)
        r8 = 61
        int r9 = r1.indexOf(r8, r0)
        com.ali.auth.third.core.d.e r10 = new com.ali.auth.third.core.d.e
        r10.m41146init()
        r11 = 34
        r12 = -1
        r13 = 1
        if (r7 == r12) goto L_0x0033
        if (r7 < r9) goto L_0x0035
    L_0x0033:
        if (r9 != r12) goto L_0x0042
    L_0x0035:
        if (r7 != r12) goto L_0x0038
        r7 = r2
    L_0x0038:
        java.lang.String r0 = r1.substring(r0, r7)
        r10.f1936c = r0
        r10.f1937d = r4
        r0 = r7
        goto L_0x0084
    L_0x0042:
        java.lang.String r7 = r1.substring(r0, r9)
        r10.f1936c = r7
        int r7 = r2 + -1
        if (r9 >= r7) goto L_0x005e
        int r7 = r9 + 1
        char r7 = r1.charAt(r7)
        if (r7 != r11) goto L_0x005e
        int r0 = r9 + 2
        int r0 = r1.indexOf(r11, r0)
        if (r0 != r12) goto L_0x005e
        goto L_0x01ea
    L_0x005e:
        int r0 = r1.indexOf(r5, r0)
        if (r0 != r12) goto L_0x0065
        r0 = r2
    L_0x0065:
        int r7 = r0 - r9
        r14 = 4096(0x1000, float:5.74E-42)
        if (r7 <= r14) goto L_0x0075
        int r9 = r9 + r13
        int r7 = r9 + 4096
        java.lang.String r7 = r1.substring(r9, r7)
    L_0x0072:
        r10.f1937d = r7
        goto L_0x0084
    L_0x0075:
        int r7 = r9 + 1
        if (r7 == r0) goto L_0x0081
        if (r0 >= r9) goto L_0x007c
        goto L_0x0081
    L_0x007c:
        java.lang.String r7 = r1.substring(r7, r0)
        goto L_0x0072
    L_0x0081:
        java.lang.String r7 = ""
        goto L_0x0072
    L_0x0084:
        if (r0 < 0) goto L_0x01e9
        if (r0 < r2) goto L_0x008a
        goto L_0x01e9
    L_0x008a:
        char r7 = r1.charAt(r0)
        if (r7 == r6) goto L_0x01e0
        char r7 = r1.charAt(r0)
        if (r7 != r5) goto L_0x0098
        goto L_0x01e0
    L_0x0098:
        char r7 = r1.charAt(r0)
        r9 = 44
        if (r7 != r9) goto L_0x00a2
        goto L_0x01e9
    L_0x00a2:
        int r7 = r2 - r0
        int r14 = f1927a
        if (r7 < r14) goto L_0x00c7
        int r14 = r14 + r0
        java.lang.String r14 = r1.substring(r0, r14)
        java.lang.String r15 = "secure"
        boolean r14 = r14.equalsIgnoreCase(r15)
        if (r14 == 0) goto L_0x00c7
        int r7 = f1927a
        int r0 = r0 + r7
        r10.f1939f = r13
        if (r0 != r2) goto L_0x00be
        goto L_0x01e9
    L_0x00be:
        char r7 = r1.charAt(r0)
        if (r7 != r8) goto L_0x0084
    L_0x00c4:
        int r0 = r0 + 1
        goto L_0x0084
    L_0x00c7:
        int r14 = f1928b
        if (r7 < r14) goto L_0x00e8
        int r14 = r14 + r0
        java.lang.String r7 = r1.substring(r0, r14)
        java.lang.String r14 = "httponly"
        boolean r7 = r7.equalsIgnoreCase(r14)
        if (r7 == 0) goto L_0x00e8
        int r7 = f1928b
        int r0 = r0 + r7
        r10.f1940g = r13
        if (r0 != r2) goto L_0x00e1
        goto L_0x01e9
    L_0x00e1:
        char r7 = r1.charAt(r0)
        if (r7 != r8) goto L_0x0084
        goto L_0x00c4
    L_0x00e8:
        int r7 = r1.indexOf(r8, r0)
        if (r7 <= 0) goto L_0x01dd
        java.lang.String r14 = r1.substring(r0, r7)
        java.lang.String r14 = r14.toLowerCase()
        java.lang.String r15 = "expires"
        boolean r16 = r14.equals(r15)
        if (r16 == 0) goto L_0x010c
        int r6 = r1.indexOf(r9, r7)
        if (r6 == r12) goto L_0x010c
        int r8 = r6 - r7
        r4 = 10
        if (r8 > r4) goto L_0x010c
        int r0 = r6 + 1
    L_0x010c:
        int r4 = r1.indexOf(r5, r0)
        int r0 = r1.indexOf(r9, r0)
        if (r4 != r12) goto L_0x011a
        if (r0 != r12) goto L_0x011a
        r4 = r2
        goto L_0x0126
    L_0x011a:
        if (r4 != r12) goto L_0x011e
    L_0x011c:
        r4 = r0
        goto L_0x0126
    L_0x011e:
        if (r0 != r12) goto L_0x0121
        goto L_0x0126
    L_0x0121:
        int r0 = java.lang.Math.min(r4, r0)
        goto L_0x011c
    L_0x0126:
        int r7 = r7 + 1
        java.lang.String r0 = r1.substring(r7, r4)
        int r6 = r0.length()
        r7 = 2
        if (r6 <= r7) goto L_0x0143
        char r6 = r0.charAt(r3)
        if (r6 != r11) goto L_0x0143
        int r6 = r0.indexOf(r11, r13)
        if (r6 <= 0) goto L_0x0143
        java.lang.String r0 = r0.substring(r13, r6)
    L_0x0143:
        r6 = r0
        boolean r0 = r14.equals(r15)
        java.lang.String r7 = "login.LoginCookieUtils"
        if (r0 == 0) goto L_0x016b
        long r8 = com.ali.auth.third.core.p025d.C0995d.m1903a(r6)     // Catch:{ IllegalArgumentException -> 0x0154 }
        r10.f1938e = r8     // Catch:{ IllegalArgumentException -> 0x0154 }
        goto L_0x01db
    L_0x0154:
        r0 = move-exception
        java.lang.StringBuilder r8 = new java.lang.StringBuilder
        r8.<init>()
        java.lang.String r9 = "illegal format for expires: "
    L_0x015c:
        r8.append(r9)
        r8.append(r6)
        java.lang.String r6 = r8.toString()
        com.ali.auth.third.core.p033j.C1018a.m1960a(r7, r6, r0)
        goto L_0x01db
    L_0x016b:
        java.lang.String r0 = "max-age"
        boolean r0 = r14.equals(r0)
        if (r0 == 0) goto L_0x0190
        long r8 = java.lang.System.currentTimeMillis()     // Catch:{ NumberFormatException -> 0x0187 }
        r14 = 1000(0x3e8, double:4.94E-321)
        long r17 = java.lang.Long.parseLong(r6)     // Catch:{ NumberFormatException -> 0x0187 }
        java.lang.Long.signum(r17)
        long r17 = r17 * r14
        long r8 = r8 + r17
        r10.f1938e = r8     // Catch:{ NumberFormatException -> 0x0187 }
        goto L_0x01db
    L_0x0187:
        r0 = move-exception
        java.lang.StringBuilder r8 = new java.lang.StringBuilder
        r8.<init>()
        java.lang.String r9 = "illegal format for max-age: "
        goto L_0x015c
    L_0x0190:
        java.lang.String r0 = "path"
        boolean r0 = r14.equals(r0)
        if (r0 == 0) goto L_0x01a1
        int r0 = r6.length()
        if (r0 <= 0) goto L_0x01db
        r10.f1935b = r6
        goto L_0x01db
    L_0x01a1:
        java.lang.String r0 = "domain"
        boolean r0 = r14.equals(r0)
        if (r0 == 0) goto L_0x01db
        r0 = 46
        int r7 = r6.lastIndexOf(r0)
        if (r7 != 0) goto L_0x01b5
        r8 = 0
        r10.f1934a = r8
        goto L_0x01db
    L_0x01b5:
        int r7 = r7 + 1
        java.lang.String r7 = r6.substring(r7)     // Catch:{ NumberFormatException -> 0x01bf }
        java.lang.Integer.parseInt(r7)     // Catch:{ NumberFormatException -> 0x01bf }
        goto L_0x01db
        java.lang.String r6 = r6.toLowerCase()
        char r7 = r6.charAt(r3)
        if (r7 == r0) goto L_0x01d9
        java.lang.StringBuilder r7 = new java.lang.StringBuilder
        r7.<init>()
        r7.append(r0)
        r7.append(r6)
        java.lang.String r6 = r7.toString()
    L_0x01d9:
        r10.f1934a = r6
    L_0x01db:
        r0 = r4
        goto L_0x01e2
    L_0x01dd:
        r0 = r2
        goto L_0x0084
    L_0x01e0:
        int r0 = r0 + 1
    L_0x01e2:
        r4 = 0
        r6 = 32
        r8 = 61
        goto L_0x0084
    L_0x01e9:
        return r10
    L_0x01ea:
        r1 = r4
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.auth.third.core.p025d.C0993b.m1897a(java.lang.String):com.ali.auth.third.core.d.e");
    }

    /* renamed from: a */
    public static void m1898a(C0997e eVar) {
        eVar.f1938e = Long.valueOf(1000).longValue();
    }

    /* renamed from: b */
    public static String m1899b(C0997e eVar) {
        String str = eVar.f1934a;
        if (!TextUtils.isEmpty(str) && str.startsWith(".")) {
            str = str.substring(1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("http://");
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: b */
    public static String m1900b(String str) {
        String[] split;
        String str2 = "=";
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String a = C0994c.m1902a().mo10301a(".taobao.com");
            if (!TextUtils.isEmpty(a)) {
                for (String str3 : a.split(";")) {
                    String[] split2 = str3.split(str2);
                    if (split2.length >= 2) {
                        if (str.equals(split2[0].trim())) {
                            return split2.length == 2 ? split2[1].trim() : str3.substring(str3.indexOf(str2) + 1);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: c */
    public static JSONObject m1901c(String str) {
        String[] split;
        String str2 = "=";
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            String a = C0994c.m1902a().mo10301a(".taobao.com");
            if (!TextUtils.isEmpty(a)) {
                for (String str3 : a.split(";")) {
                    String[] split2 = str3.split(str2);
                    if (split2.length >= 2) {
                        if (split2[0].contains(str)) {
                            if (split2.length == 2) {
                                jSONObject.put(split2[0].trim(), split2[1].trim());
                            } else {
                                jSONObject.put(split2[0].trim(), str3.substring(str3.indexOf(str2) + 1));
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
