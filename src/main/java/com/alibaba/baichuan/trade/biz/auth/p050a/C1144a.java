package com.alibaba.baichuan.trade.biz.auth.p050a;

import com.alibaba.baichuan.trade.common.adapter.mtop.C1220c;
import com.alibaba.baichuan.trade.common.adapter.mtop.C1221d.C1222a;
import com.alibaba.baichuan.trade.common.utils.C1229c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* renamed from: com.alibaba.baichuan.trade.biz.auth.a.a */
public class C1144a extends C1220c {
    public C1144a() {
        this.f2508a = "mtop.alibaba.baichuan.auth.token.get";
        this.f2510c = true;
        this.f2514g = 90000;
    }

    /* renamed from: a */
    private HashMap<String, Serializable> m2228a(Set<String> set, String str) {
        HashMap<String, Serializable> hashMap = new HashMap<>();
        hashMap.put("hintArray", set == null ? "[]" : C1229c.m2419a((List<? extends Object>) new ArrayList<Object>(set)));
        if (str == null) {
            str = "";
        }
        hashMap.put("oldToken", str);
        return hashMap;
    }

    /* renamed from: a */
    public boolean mo10660a(Set<String> set, String str, C1222a aVar) {
        return mo10880a(m2228a(set, str), aVar);
    }
}
