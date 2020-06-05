package com.p530ss.android.p531a.p532a.p537d;

import org.json.JSONObject;

/* compiled from: ToolUtils */
/* renamed from: com.ss.android.a.a.d.a */
public class C6519a {
    /* renamed from: a */
    public static long m25904a(JSONObject jSONObject, String str) {
        long j = 0;
        if (jSONObject == null) {
            return 0;
        }
        try {
            j = Long.valueOf(jSONObject.optString(str)).longValue();
        } catch (NumberFormatException unused) {
        }
        return j;
    }
}
