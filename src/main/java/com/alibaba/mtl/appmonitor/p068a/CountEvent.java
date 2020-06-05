package com.alibaba.mtl.appmonitor.p068a;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import org.json.JSONObject;

/* renamed from: com.alibaba.mtl.appmonitor.a.b */
public class CountEvent extends Event {
    /* renamed from: a */
    public int f3143a;
    /* renamed from: b */
    public double f3144b;

    /* renamed from: a */
    public synchronized void mo11547a(double d) {
        this.f3144b += d;
        this.f3143a++;
    }

    /* renamed from: c */
    public synchronized JSONObject mo11545c() {
        JSONObject c;
        c = super.mo11545c();
        try {
            c.put("count", this.f3143a);
            c.put(ArgKey.KEY_VALUE, this.f3144b);
        } catch (Exception unused) {
        }
        return c;
    }

    /* renamed from: a */
    public synchronized void mo11548a(Object... objArr) {
        super.mo11548a(objArr);
        this.f3144b = 0.0d;
        this.f3143a = 0;
    }
}
