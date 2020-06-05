package com.alibaba.wireless.security.framework;

import android.content.pm.PackageInfo;
import com.alibaba.wireless.security.framework.utils.C1349c;
import java.io.File;
import org.json.JSONObject;

/* renamed from: com.alibaba.wireless.security.framework.e */
public class C1340e {
    /* renamed from: a */
    public PackageInfo f3473a = null;
    /* renamed from: b */
    private JSONObject f3474b = null;
    /* renamed from: c */
    private String f3475c;

    public C1340e(String str) {
        this.f3475c = str;
    }

    /* renamed from: a */
    public String mo11847a(String str) {
        try {
            return mo11850b().getString(str);
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a */
    public boolean mo11848a() {
        try {
            return new File(this.f3475c).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0089 A[SYNTHETIC, Splitter:B:18:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    public boolean mo11849a(android.content.pm.PackageInfo r11, java.lang.String r12) {
        /*
        r10 = this;
        java.lang.String r0 = "thirdpartyso"
        java.lang.String r1 = "reversedependencies"
        java.lang.String r2 = "weakdependencies"
        java.lang.String r3 = "dependencies"
        java.lang.String r4 = "pluginclass"
        java.lang.String r5 = "pluginname"
        java.lang.String r6 = "hasso"
        r7 = 0
        if (r11 == 0) goto L_0x009a
        if (r12 != 0) goto L_0x0015
        goto L_0x009a
    L_0x0015:
        org.json.JSONObject r12 = new org.json.JSONObject
        r12.<init>()
        java.lang.String r8 = "version"
        java.lang.String r9 = r11.versionName     // Catch:{ Exception -> 0x0099 }
        r12.put(r8, r9)     // Catch:{ Exception -> 0x0099 }
        android.content.pm.ApplicationInfo r8 = r11.applicationInfo     // Catch:{ Exception -> 0x0099 }
        android.os.Bundle r8 = r8.metaData     // Catch:{ Exception -> 0x0099 }
        boolean r8 = r8.getBoolean(r6, r7)     // Catch:{ Exception -> 0x0099 }
        r12.put(r6, r8)     // Catch:{ Exception -> 0x0099 }
        android.content.pm.ApplicationInfo r6 = r11.applicationInfo     // Catch:{ Exception -> 0x0099 }
        android.os.Bundle r6 = r6.metaData     // Catch:{ Exception -> 0x0099 }
        java.lang.String r6 = r6.getString(r5)     // Catch:{ Exception -> 0x0099 }
        r12.put(r5, r6)     // Catch:{ Exception -> 0x0099 }
        android.content.pm.ApplicationInfo r5 = r11.applicationInfo     // Catch:{ Exception -> 0x0099 }
        android.os.Bundle r5 = r5.metaData     // Catch:{ Exception -> 0x0099 }
        java.lang.String r5 = r5.getString(r4)     // Catch:{ Exception -> 0x0099 }
        r12.put(r4, r5)     // Catch:{ Exception -> 0x0099 }
        android.content.pm.ApplicationInfo r4 = r11.applicationInfo     // Catch:{ Exception -> 0x0099 }
        android.os.Bundle r4 = r4.metaData     // Catch:{ Exception -> 0x0099 }
        java.lang.String r4 = r4.getString(r3)     // Catch:{ Exception -> 0x0099 }
        r12.put(r3, r4)     // Catch:{ Exception -> 0x0099 }
        android.content.pm.ApplicationInfo r3 = r11.applicationInfo     // Catch:{ Exception -> 0x0099 }
        android.os.Bundle r3 = r3.metaData     // Catch:{ Exception -> 0x0099 }
        java.lang.String r3 = r3.getString(r2)     // Catch:{ Exception -> 0x0099 }
        r12.put(r2, r3)     // Catch:{ Exception -> 0x0099 }
        android.content.pm.ApplicationInfo r2 = r11.applicationInfo     // Catch:{ Exception -> 0x0099 }
        android.os.Bundle r2 = r2.metaData     // Catch:{ Exception -> 0x0099 }
        java.lang.String r2 = r2.getString(r1)     // Catch:{ Exception -> 0x0099 }
        r12.put(r1, r2)     // Catch:{ Exception -> 0x0099 }
        android.content.pm.ApplicationInfo r11 = r11.applicationInfo     // Catch:{ Exception -> 0x0099 }
        android.os.Bundle r11 = r11.metaData     // Catch:{ Exception -> 0x0099 }
        boolean r11 = r11.getBoolean(r0)     // Catch:{ Exception -> 0x0099 }
        r12.put(r0, r11)     // Catch:{ Exception -> 0x0099 }
        r11 = 0
        java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0082 }
        java.lang.String r1 = r10.f3475c     // Catch:{ Exception -> 0x0082 }
        r0.<init>(r1)     // Catch:{ Exception -> 0x0082 }
        boolean r11 = r0.exists()     // Catch:{ Exception -> 0x0080 }
        if (r11 != 0) goto L_0x008e
        r0.createNewFile()     // Catch:{ Exception -> 0x0080 }
        goto L_0x008e
        goto L_0x0083
    L_0x0082:
        r0 = r11
    L_0x0083:
        boolean r11 = r0.exists()
        if (r11 != 0) goto L_0x008e
        r0.createNewFile()     // Catch:{ Exception -> 0x008d }
        goto L_0x008e
    L_0x008e:
        java.lang.String r11 = r12.toString()
        boolean r11 = com.alibaba.wireless.security.framework.utils.C1349c.m3982a(r0, r11)
        if (r11 != 0) goto L_0x0099
        goto L_0x009a
    L_0x0099:
        r7 = 1
    L_0x009a:
        return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C1340e.mo11849a(android.content.pm.PackageInfo, java.lang.String):boolean");
    }

    /* renamed from: b */
    public JSONObject mo11850b() {
        JSONObject jSONObject = this.f3474b;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = null;
        try {
            String a = C1349c.m3981a(new File(this.f3475c));
            if (a != null && a.length() > 0) {
                jSONObject2 = new JSONObject(a);
            }
        } catch (Exception unused) {
        }
        this.f3474b = jSONObject2;
        return jSONObject2;
    }
}
