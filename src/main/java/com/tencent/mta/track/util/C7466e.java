package com.tencent.mta.track.util;

import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.util.e */
public class C7466e {
    /* renamed from: a */
    public static String m32334a(JSONObject jSONObject, String str) {
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.getString(str);
    }
}
