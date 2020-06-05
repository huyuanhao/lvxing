package com.alibaba.alibclinkpartner.smartlink.p042b;

import android.content.SharedPreferences;

/* renamed from: com.alibaba.alibclinkpartner.smartlink.b.c */
public class ALSLSPUtil {
    /* renamed from: a */
    private static SharedPreferences f2234a;

    /* renamed from: a */
    public static Object m2125a(String str, Object obj) {
        Object valueOf;
        String simpleName = obj.getClass().getSimpleName();
        char c = 65535;
        try {
            switch (simpleName.hashCode()) {
                case -1808118735:
                    if (simpleName.equals("String")) {
                        c = 3;
                        break;
                    }
                    break;
                case -672261858:
                    if (simpleName.equals("Integer")) {
                        c = 4;
                        break;
                    }
                    break;
                case 2374300:
                    if (simpleName.equals("Long")) {
                        c = 1;
                        break;
                    }
                    break;
                case 67973692:
                    if (simpleName.equals("Float")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1729365000:
                    if (simpleName.equals("Boolean")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                valueOf = Boolean.valueOf(f2234a.getBoolean(str, ((Boolean) obj).booleanValue()));
            } else if (c == 1) {
                valueOf = Long.valueOf(f2234a.getLong(str, ((Long) obj).longValue()));
            } else if (c == 2) {
                valueOf = Float.valueOf(f2234a.getFloat(str, ((Float) obj).floatValue()));
            } else if (c == 3) {
                valueOf = f2234a.getString(str, (String) obj);
            } else if (c != 4) {
                return obj;
            } else {
                valueOf = Integer.valueOf(f2234a.getInt(str, ((Integer) obj).intValue()));
            }
            return valueOf;
        } catch (Exception unused) {
            return obj;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    public static java.lang.Object m2126b(java.lang.String r4, java.lang.Object r5) {
        /*
        android.content.SharedPreferences r0 = f2234a
        java.lang.String r1 = ""
        java.lang.String r4 = r0.getString(r4, r1)
        boolean r0 = android.text.TextUtils.isEmpty(r4)
        if (r0 != 0) goto L_0x0060
        r0 = 0
        java.lang.String r1 = "UTF-8"
        java.lang.String r4 = java.net.URLDecoder.decode(r4, r1)     // Catch:{ Exception -> 0x0042, all -> 0x003f }
        java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0042, all -> 0x003f }
        java.lang.String r2 = "ISO-8859-1"
        byte[] r4 = r4.getBytes(r2)     // Catch:{ Exception -> 0x0042, all -> 0x003f }
        r1.<init>(r4)     // Catch:{ Exception -> 0x0042, all -> 0x003f }
        java.io.ObjectInputStream r4 = new java.io.ObjectInputStream     // Catch:{ Exception -> 0x003d }
        r4.<init>(r1)     // Catch:{ Exception -> 0x003d }
        java.lang.Object r0 = r4.readObject()     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
        r4.close()     // Catch:{ Exception -> 0x0030 }
        r1.close()     // Catch:{ Exception -> 0x0030 }
        goto L_0x0061
    L_0x0030:
        r4 = move-exception
        r4.printStackTrace()
        goto L_0x0061
    L_0x0035:
        r5 = move-exception
        r0 = r4
        goto L_0x0054
    L_0x0038:
        r0 = move-exception
        r3 = r0
        r0 = r4
        r4 = r3
        goto L_0x0044
    L_0x003d:
        r4 = move-exception
        goto L_0x0044
    L_0x003f:
        r5 = move-exception
        r1 = r0
        goto L_0x0054
    L_0x0042:
        r4 = move-exception
        r1 = r0
    L_0x0044:
        r4.printStackTrace()     // Catch:{ all -> 0x0053 }
        r0.close()     // Catch:{ Exception -> 0x004e }
        r1.close()     // Catch:{ Exception -> 0x004e }
        goto L_0x0060
    L_0x004e:
        r4 = move-exception
        r4.printStackTrace()
        goto L_0x0060
    L_0x0053:
        r5 = move-exception
    L_0x0054:
        r0.close()     // Catch:{ Exception -> 0x005b }
        r1.close()     // Catch:{ Exception -> 0x005b }
        goto L_0x005f
    L_0x005b:
        r4 = move-exception
        r4.printStackTrace()
    L_0x005f:
        throw r5
    L_0x0060:
        r0 = r5
    L_0x0061:
        if (r0 != 0) goto L_0x0064
        goto L_0x0065
    L_0x0064:
        r5 = r0
    L_0x0065:
        return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.alibclinkpartner.smartlink.p042b.ALSLSPUtil.m2126b(java.lang.String, java.lang.Object):java.lang.Object");
    }
}
