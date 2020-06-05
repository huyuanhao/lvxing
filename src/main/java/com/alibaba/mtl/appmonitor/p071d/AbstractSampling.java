package com.alibaba.mtl.appmonitor.p071d;

import org.json.JSONObject;

/* renamed from: com.alibaba.mtl.appmonitor.d.a */
public abstract class AbstractSampling<T extends JSONObject> {
    /* renamed from: a */
    protected int f3202a;

    public AbstractSampling(int i) {
        this.f3202a = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo11631a(T t) {
        try {
            Integer valueOf = Integer.valueOf(t.getInt("sampling"));
            if (valueOf != null) {
                this.f3202a = valueOf.intValue();
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo11632a(int i) {
        return i < this.f3202a;
    }
}
