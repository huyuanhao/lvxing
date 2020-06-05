package com.tencent.stat;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.tencent.mid.core.Constants.ERROR;
import com.tencent.mid.util.Util;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatConstants;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.StatPreferences;
import java.io.InputStream;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.c */
public class C7587c {
    /* renamed from: a */
    private static volatile boolean f25606a = false;
    /* renamed from: b */
    private static StatLogger f25607b = StatCommonHelper.getLogger();

    /* renamed from: a */
    public static void m32716a(Context context) {
        String str = "1";
        boolean c = m32720c(context);
        String str2 = "SSS";
        String str3 = StatConstants.LOG_TAG;
        if (c) {
            Log.w(str3, "MtaSmartStat is self kill!");
            StatConfig.addCustomReportKeyValue(str2, ERROR.CMD_FORMAT_ERROR);
            return;
        }
        StatPreferences.putLong(context, "mta.smart.start.ts", System.currentTimeMillis());
        try {
            String customProperty = StatConfig.getCustomProperty(context, "MtaSmartStat", str);
            if (!Util.isEmpty(customProperty) && !"0".equals(customProperty)) {
                m32722d(context);
                StatConfig.addCustomReportKeyValue(str2, str);
                Log.i(str3, "Smart Provider is in use.");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        StatPreferences.putLong(context, "mta.smart.end.ts", System.currentTimeMillis());
    }

    /* renamed from: b */
    public static Application m32717b(Context context) {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]);
            declaredMethod.setAccessible(true);
            return (Application) declaredMethod.invoke(null, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static void m32713a(Application application) {
        if (application != null) {
            m32718b(application);
            m32721d(application);
        }
    }

    /* renamed from: d */
    private static void m32721d(Application application) {
        StatService.registerActivityLifecycleCallbacks(application);
    }

    /* renamed from: b */
    public static void m32718b(Application application) {
        m32714a(application, m32723e(application));
        m32714a(application, m32719c(application));
    }

    /* renamed from: a */
    private static void m32714a(Application application, JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    StatLogger statLogger = f25607b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("try to invoke module:");
                    sb.append(jSONObject);
                    statLogger.mo37101d(sb.toString());
                    m32715a(application, jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: c */
    public static JSONArray m32719c(Application application) {
        try {
            return new JSONArray(StatConfig.getCustomProperty(application, "SmartStartModules", ""));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: c */
    public static boolean m32720c(Context context) {
        return StatPreferences.contains(context, "mta.smart.start.ts") && !StatPreferences.contains(context, "mta.smart.end.ts");
    }

    /* renamed from: e */
    private static JSONArray m32723e(Application application) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = new JSONArray();
        try {
            InputStream open = application.getAssets().open("MTA_SMART_MODULE");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            String str = new String(bArr);
            jSONArray = new JSONArray(str);
            try {
                StatLogger statLogger = f25607b;
                StringBuilder sb = new StringBuilder();
                sb.append("readModuleConfigFile:");
                sb.append(str);
                statLogger.mo37101d(sb.toString());
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            jSONArray = jSONArray2;
            e.printStackTrace();
            return jSONArray;
        }
        return jSONArray;
    }

    /* renamed from: a */
    private static void m32715a(android.app.Application r13, org.json.JSONObject r14) {
        /*
        java.lang.String r0 = "class"
        java.lang.String r0 = r14.getString(r0)     // Catch:{ all -> 0x0155 }
        java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ all -> 0x0155 }
        java.lang.String r1 = "method"
        java.lang.String r1 = r14.getString(r1)     // Catch:{ all -> 0x0155 }
        org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ all -> 0x0155 }
        java.lang.String r3 = "args"
        java.lang.String r3 = r14.getString(r3)     // Catch:{ all -> 0x0155 }
        r2.<init>(r3)     // Catch:{ all -> 0x0155 }
        int r3 = r2.length()     // Catch:{ all -> 0x0155 }
        java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x0155 }
        r5 = 1
        r6 = 0
        if (r3 <= 0) goto L_0x0111
        java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ all -> 0x0155 }
        r8 = 0
    L_0x0028:
        if (r8 >= r3) goto L_0x010c
        org.json.JSONObject r9 = r2.getJSONObject(r8)     // Catch:{ all -> 0x0155 }
        java.lang.String r10 = "cname"
        java.lang.String r10 = r9.getString(r10)     // Catch:{ all -> 0x0155 }
        java.lang.String r11 = "cvalue"
        java.lang.String r9 = r9.getString(r11)     // Catch:{ all -> 0x0155 }
        r11 = -1
        int r12 = r10.hashCode()     // Catch:{ all -> 0x0155 }
        switch(r12) {
            case -1808118735: goto L_0x00ab;
            case -1678783089: goto L_0x00a0;
            case -1072845520: goto L_0x0095;
            case -672261858: goto L_0x008b;
            case 104431: goto L_0x0081;
            case 2374300: goto L_0x0077;
            case 3327612: goto L_0x006d;
            case 64711720: goto L_0x0063;
            case 67973692: goto L_0x0059;
            case 97526364: goto L_0x004f;
            case 1729365000: goto L_0x0044;
            default: goto L_0x0042;
        }     // Catch:{ all -> 0x0155 }
    L_0x0042:
        goto L_0x00b6
    L_0x0044:
        java.lang.String r12 = "Boolean"
        boolean r10 = r10.equals(r12)     // Catch:{ all -> 0x0155 }
        if (r10 == 0) goto L_0x00b6
        r10 = 0
        goto L_0x00b7
    L_0x004f:
        java.lang.String r12 = "float"
        boolean r10 = r10.equals(r12)     // Catch:{ all -> 0x0155 }
        if (r10 == 0) goto L_0x00b6
        r10 = 4
        goto L_0x00b7
    L_0x0059:
        java.lang.String r12 = "Float"
        boolean r10 = r10.equals(r12)     // Catch:{ all -> 0x0155 }
        if (r10 == 0) goto L_0x00b6
        r10 = 5
        goto L_0x00b7
    L_0x0063:
        java.lang.String r12 = "boolean"
        boolean r10 = r10.equals(r12)     // Catch:{ all -> 0x0155 }
        if (r10 == 0) goto L_0x00b6
        r10 = 1
        goto L_0x00b7
    L_0x006d:
        java.lang.String r12 = "long"
        boolean r10 = r10.equals(r12)     // Catch:{ all -> 0x0155 }
        if (r10 == 0) goto L_0x00b6
        r10 = 6
        goto L_0x00b7
    L_0x0077:
        java.lang.String r12 = "Long"
        boolean r10 = r10.equals(r12)     // Catch:{ all -> 0x0155 }
        if (r10 == 0) goto L_0x00b6
        r10 = 7
        goto L_0x00b7
    L_0x0081:
        java.lang.String r12 = "int"
        boolean r10 = r10.equals(r12)     // Catch:{ all -> 0x0155 }
        if (r10 == 0) goto L_0x00b6
        r10 = 2
        goto L_0x00b7
    L_0x008b:
        java.lang.String r12 = "Integer"
        boolean r10 = r10.equals(r12)     // Catch:{ all -> 0x0155 }
        if (r10 == 0) goto L_0x00b6
        r10 = 3
        goto L_0x00b7
    L_0x0095:
        java.lang.String r12 = "Application"
        boolean r10 = r10.equals(r12)     // Catch:{ all -> 0x0155 }
        if (r10 == 0) goto L_0x00b6
        r10 = 10
        goto L_0x00b7
    L_0x00a0:
        java.lang.String r12 = "Context"
        boolean r10 = r10.equals(r12)     // Catch:{ all -> 0x0155 }
        if (r10 == 0) goto L_0x00b6
        r10 = 9
        goto L_0x00b7
    L_0x00ab:
        java.lang.String r12 = "String"
        boolean r10 = r10.equals(r12)     // Catch:{ all -> 0x0155 }
        if (r10 == 0) goto L_0x00b6
        r10 = 8
        goto L_0x00b7
    L_0x00b6:
        r10 = -1
    L_0x00b7:
        switch(r10) {
            case 0: goto L_0x00fe;
            case 1: goto L_0x00fe;
            case 2: goto L_0x00f3;
            case 3: goto L_0x00f3;
            case 4: goto L_0x00e8;
            case 5: goto L_0x00e8;
            case 6: goto L_0x00dd;
            case 7: goto L_0x00dd;
            case 8: goto L_0x00d6;
            case 9: goto L_0x00c2;
            case 10: goto L_0x00bb;
            default: goto L_0x00ba;
        }     // Catch:{ all -> 0x0155 }
    L_0x00ba:
        goto L_0x0108
    L_0x00bb:
        java.lang.Class<android.app.Application> r9 = android.app.Application.class
        r7[r8] = r9     // Catch:{ all -> 0x0155 }
        r4[r8] = r13     // Catch:{ all -> 0x0155 }
        goto L_0x0108
    L_0x00c2:
        java.lang.Class<android.content.Context> r9 = android.content.Context.class
        r7[r8] = r9     // Catch:{ all -> 0x0155 }
        android.content.Context r9 = r13.getApplicationContext()     // Catch:{ all -> 0x0155 }
        if (r9 == 0) goto L_0x00d3
        android.content.Context r9 = r13.getApplicationContext()     // Catch:{ all -> 0x0155 }
        r4[r8] = r9     // Catch:{ all -> 0x0155 }
        goto L_0x0108
    L_0x00d3:
        r4[r8] = r13     // Catch:{ all -> 0x0155 }
        goto L_0x0108
    L_0x00d6:
        java.lang.Class<java.lang.String> r10 = java.lang.String.class
        r7[r8] = r10     // Catch:{ all -> 0x0155 }
        r4[r8] = r9     // Catch:{ all -> 0x0155 }
        goto L_0x0108
    L_0x00dd:
        java.lang.Class<java.lang.Long> r10 = java.lang.Long.class
        r7[r8] = r10     // Catch:{ all -> 0x0155 }
        java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x0155 }
        r4[r8] = r9     // Catch:{ all -> 0x0155 }
        goto L_0x0108
    L_0x00e8:
        java.lang.Class<java.lang.Float> r10 = java.lang.Float.class
        r7[r8] = r10     // Catch:{ all -> 0x0155 }
        java.lang.Float r9 = java.lang.Float.valueOf(r9)     // Catch:{ all -> 0x0155 }
        r4[r8] = r9     // Catch:{ all -> 0x0155 }
        goto L_0x0108
    L_0x00f3:
        java.lang.Class<java.lang.Integer> r10 = java.lang.Integer.class
        r7[r8] = r10     // Catch:{ all -> 0x0155 }
        java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0155 }
        r4[r8] = r9     // Catch:{ all -> 0x0155 }
        goto L_0x0108
    L_0x00fe:
        java.lang.Class r10 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0155 }
        r7[r8] = r10     // Catch:{ all -> 0x0155 }
        java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch:{ all -> 0x0155 }
        r4[r8] = r9     // Catch:{ all -> 0x0155 }
    L_0x0108:
        int r8 = r8 + 1
        goto L_0x0028
    L_0x010c:
        java.lang.reflect.Method r13 = r0.getDeclaredMethod(r1, r7)     // Catch:{ all -> 0x0155 }
        goto L_0x0117
    L_0x0111:
        java.lang.Class[] r13 = new java.lang.Class[r6]     // Catch:{ all -> 0x0155 }
        java.lang.reflect.Method r13 = r0.getDeclaredMethod(r1, r13)     // Catch:{ all -> 0x0155 }
    L_0x0117:
        r13.setAccessible(r5)     // Catch:{ all -> 0x0155 }
        java.lang.String r1 = "static"
        int r1 = r14.getInt(r1)     // Catch:{ all -> 0x0155 }
        if (r1 != r5) goto L_0x012f
        r0 = 0
        if (r3 <= 0) goto L_0x0129
        r13.invoke(r0, r4)     // Catch:{ all -> 0x0155 }
        goto L_0x013e
    L_0x0129:
        java.lang.Object[] r1 = new java.lang.Object[r6]     // Catch:{ all -> 0x0155 }
        r13.invoke(r0, r1)     // Catch:{ all -> 0x0155 }
        goto L_0x013e
    L_0x012f:
        java.lang.Object r0 = r0.newInstance()     // Catch:{ all -> 0x0155 }
        if (r3 <= 0) goto L_0x0139
        r13.invoke(r0, r4)     // Catch:{ all -> 0x0155 }
        goto L_0x013e
    L_0x0139:
        java.lang.Object[] r1 = new java.lang.Object[r6]     // Catch:{ all -> 0x0155 }
        r13.invoke(r0, r1)     // Catch:{ all -> 0x0155 }
    L_0x013e:
        com.tencent.stat.common.StatLogger r13 = f25607b     // Catch:{ all -> 0x0155 }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0155 }
        r0.<init>()     // Catch:{ all -> 0x0155 }
        java.lang.String r1 = "invokeSingleModule:"
        r0.append(r1)     // Catch:{ all -> 0x0155 }
        r0.append(r14)     // Catch:{ all -> 0x0155 }
        java.lang.String r14 = r0.toString()     // Catch:{ all -> 0x0155 }
        r13.mo37101d(r14)     // Catch:{ all -> 0x0155 }
        goto L_0x0159
    L_0x0155:
        r13 = move-exception
        r13.printStackTrace()
    L_0x0159:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.C7587c.m32715a(android.app.Application, org.json.JSONObject):void");
    }

    /* renamed from: d */
    public static void m32722d(Context context) {
        if (!f25606a && StatCommonHelper.isMainProcess(context)) {
            m32713a(m32717b(context));
            f25606a = true;
        }
    }
}
