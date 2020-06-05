package com.bytedance.sdk.adnet.p161d;

import android.content.Context;
import com.bytedance.sdk.adnet.AdNetSdk;
import java.util.LinkedHashMap;

/* renamed from: com.bytedance.sdk.adnet.d.e */
public class MultiProcessFileUtils {
    /* renamed from: a */
    public static void m7953a(Context context, int i, String str) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (i == 1) {
                linkedHashMap.put("tnc_config", str);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("saveData = ");
            sb.append(str);
            C1987d.m7948b("MultiProcessFileUtils", sb.toString());
            AdNetSdk.m7640a().mo14231a(context, linkedHashMap);
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    /* renamed from: a */
    public static java.lang.String m7952a(android.content.Context r2, int r3) {
        /*
        java.lang.String r0 = ""
        r1 = 1
        if (r3 == r1) goto L_0x0006
        goto L_0x0011
    L_0x0006:
        com.bytedance.sdk.adnet.c.b r3 = com.bytedance.sdk.adnet.AdNetSdk.m7640a()     // Catch:{ Exception -> 0x0011 }
        java.lang.String r1 = "tnc_config"
        java.lang.String r2 = r3.mo14230a(r2, r1, r0)     // Catch:{ Exception -> 0x0011 }
        goto L_0x0012
    L_0x0011:
        r2 = r0
    L_0x0012:
        boolean r3 = r2 instanceof java.lang.String
        if (r3 == 0) goto L_0x001a
        java.lang.String r0 = java.lang.String.valueOf(r2)
    L_0x001a:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.p161d.MultiProcessFileUtils.m7952a(android.content.Context, int):java.lang.String");
    }
}
