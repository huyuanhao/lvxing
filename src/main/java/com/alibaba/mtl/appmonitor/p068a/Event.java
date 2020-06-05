package com.alibaba.mtl.appmonitor.p068a;

import com.alibaba.mtl.appmonitor.p070c.BalancedPool;
import com.alibaba.mtl.appmonitor.p070c.Reusable;
import com.alibaba.mtl.appmonitor.p070c.ReuseJSONObject;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.alibaba.mtl.appmonitor.a.d */
public abstract class Event implements Reusable {
    /* renamed from: e */
    public String f3151e;
    /* renamed from: f */
    public String f3152f;
    /* renamed from: g */
    public String f3153g;
    /* renamed from: h */
    public int f3154h;

    /* renamed from: c */
    public JSONObject mo11545c() {
        JSONObject jSONObject = (JSONObject) BalancedPool.m3491a().mo11627a(ReuseJSONObject.class, new Object[0]);
        try {
            jSONObject.put("page", this.f3151e);
            jSONObject.put("monitorPoint", this.f3152f);
            if (this.f3153g != null) {
                jSONObject.put("arg", this.f3153g);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* renamed from: d */
    public void mo11546d() {
        this.f3154h = 0;
        this.f3151e = null;
        this.f3152f = null;
        this.f3153g = null;
    }

    /* renamed from: a */
    public void mo11548a(Object... objArr) {
        this.f3154h = objArr[0].intValue();
        this.f3151e = objArr[1];
        this.f3152f = objArr[2];
        if (objArr.length > 3 && objArr[3] != null) {
            this.f3153g = objArr[3];
        }
    }
}
