package com.tencent.qqpim.discovery.internal.model;

import org.json.JSONObject;

/* renamed from: com.tencent.qqpim.discovery.internal.model.b */
public class C7487b {
    /* renamed from: ue */
    private int f25066ue = 2;

    public C7487b(String str) {
        this.f25066ue = new JSONObject(str).getInt("adOperationType");
    }

    /* renamed from: lb */
    public boolean mo36517lb() {
        return this.f25066ue == 1;
    }
}
