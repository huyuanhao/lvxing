package com.tencent.qqpim.discovery.internal.model;

import org.json.JSONObject;

/* renamed from: com.tencent.qqpim.discovery.internal.model.c */
public class C7488c {
    public boolean isApp = false;
    /* renamed from: ve */
    public boolean f25067ve = false;

    public C7488c(String str) {
        JSONObject jSONObject = new JSONObject(str);
        this.isApp = jSONObject.getBoolean("isApp");
        this.f25067ve = jSONObject.getBoolean("openExternal");
    }
}
