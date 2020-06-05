package com.alibaba.mtl.appmonitor.p070c;

import org.json.JSONArray;

/* renamed from: com.alibaba.mtl.appmonitor.c.d */
public class ReuseJSONArray extends JSONArray implements Reusable {
    /* renamed from: a */
    public void mo11548a(Object... objArr) {
    }

    /* renamed from: d */
    public void mo11546d() {
        for (int i = 0; i < length(); i++) {
            Object opt = opt(i);
            if (opt != null && (opt instanceof Reusable)) {
                BalancedPool.m3491a().mo11628a((Reusable) opt);
            }
        }
    }
}
