package com.alipay.sdk.util;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.alipay.sdk.util.c */
public class C1540c {
    /* renamed from: a */
    public static JSONObject m4627a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject[] jSONObjectArr;
        JSONObject jSONObject3 = new JSONObject();
        try {
            for (JSONObject jSONObject4 : new JSONObject[]{jSONObject, jSONObject2}) {
                if (jSONObject4 != null) {
                    Iterator keys = jSONObject4.keys();
                    while (keys.hasNext()) {
                        String str = (String) keys.next();
                        jSONObject3.put(str, jSONObject4.get(str));
                    }
                }
            }
        } catch (JSONException e) {
            C1542e.m4633a(e);
        }
        return jSONObject3;
    }
}
