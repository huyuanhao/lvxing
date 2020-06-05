package com.p530ss.android.socialbase.appdownloader.p550a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.appdownloader.a.c */
public class CustomJumpDevicePlan extends AbsDevicePlan {
    /* renamed from: c */
    private final JSONObject f21484c;

    public CustomJumpDevicePlan(Context context, String str, JSONObject jSONObject) {
        super(context, str);
        this.f21484c = jSONObject;
    }

    /* renamed from: b */
    public Intent mo31456b() {
        String optString = this.f21484c.optString("action");
        String optString2 = this.f21484c.optString("category");
        int optInt = this.f21484c.optInt("flags", 1342210048);
        String optString3 = this.f21484c.optString("path_extra_key");
        String optString4 = this.f21484c.optString("path_data_key");
        JSONObject optJSONObject = this.f21484c.optJSONObject("extra");
        JSONObject optJSONObject2 = this.f21484c.optJSONObject("extra_type");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        Intent intent = new Intent(optString);
        if (!TextUtils.isEmpty(optString2)) {
            intent.addCategory(optString2);
        }
        if (!TextUtils.isEmpty(optString4)) {
            try {
                intent.setData(Uri.parse(String.format(optString4, new Object[]{this.f21483b})));
            } catch (Throwable unused) {
            }
        }
        intent.setFlags(optInt);
        if (!TextUtils.isEmpty(optString3)) {
            intent.putExtra(optString3, this.f21483b);
        }
        m26594a(intent, optJSONObject, optJSONObject2);
        return intent;
    }

    /* renamed from: a */
    private static void m26594a(Intent intent, JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null && jSONObject.length() == jSONObject2.length() && intent != null) {
            Iterator keys = jSONObject.keys();
            if (keys != null) {
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    String optString = jSONObject2.optString(str);
                    if (optString != null) {
                        m26595a(jSONObject, str, optString, intent);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static void m26595a(org.json.JSONObject r5, java.lang.String r6, java.lang.String r7, android.content.Intent r8) {
        /*
        int r0 = r7.hashCode()
        r1 = 4
        r2 = 3
        r3 = 2
        r4 = 1
        switch(r0) {
            case -1325958191: goto L_0x0034;
            case -891985903: goto L_0x002a;
            case 104431: goto L_0x0020;
            case 3327612: goto L_0x0016;
            case 64711720: goto L_0x000c;
            default: goto L_0x000b;
        }
    L_0x000b:
        goto L_0x003e
    L_0x000c:
        java.lang.String r0 = "boolean"
        boolean r7 = r7.equals(r0)
        if (r7 == 0) goto L_0x003e
        r7 = 1
        goto L_0x003f
    L_0x0016:
        java.lang.String r0 = "long"
        boolean r7 = r7.equals(r0)
        if (r7 == 0) goto L_0x003e
        r7 = 2
        goto L_0x003f
    L_0x0020:
        java.lang.String r0 = "int"
        boolean r7 = r7.equals(r0)
        if (r7 == 0) goto L_0x003e
        r7 = 0
        goto L_0x003f
    L_0x002a:
        java.lang.String r0 = "string"
        boolean r7 = r7.equals(r0)
        if (r7 == 0) goto L_0x003e
        r7 = 4
        goto L_0x003f
    L_0x0034:
        java.lang.String r0 = "double"
        boolean r7 = r7.equals(r0)
        if (r7 == 0) goto L_0x003e
        r7 = 3
        goto L_0x003f
    L_0x003e:
        r7 = -1
    L_0x003f:
        if (r7 == 0) goto L_0x006a
        if (r7 == r4) goto L_0x0062
        if (r7 == r3) goto L_0x005a
        if (r7 == r2) goto L_0x0052
        if (r7 == r1) goto L_0x004a
        goto L_0x0071
    L_0x004a:
        java.lang.String r5 = r5.optString(r6)
        r8.putExtra(r6, r5)
        goto L_0x0071
    L_0x0052:
        double r0 = r5.optDouble(r6)
        r8.putExtra(r6, r0)
        goto L_0x0071
    L_0x005a:
        long r0 = r5.optLong(r6)
        r8.putExtra(r6, r0)
        goto L_0x0071
    L_0x0062:
        boolean r5 = r5.optBoolean(r6)
        r8.putExtra(r6, r5)
        goto L_0x0071
    L_0x006a:
        int r5 = r5.optInt(r6)
        r8.putExtra(r6, r5)
    L_0x0071:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.appdownloader.p550a.CustomJumpDevicePlan.m26595a(org.json.JSONObject, java.lang.String, java.lang.String, android.content.Intent):void");
    }
}
