package com.alibaba.baichuan.trade.biz.core.p054b.p055a;

import com.alibaba.baichuan.trade.biz.core.config.model.ActionDO;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.alibaba.baichuan.trade.biz.core.b.a.d */
public class C1179d {
    /* renamed from: a */
    private String f2436a;
    /* renamed from: b */
    private List<ActionDO> f2437b;
    /* renamed from: c */
    private final HashMap<String, Object> f2438c;

    public C1179d(String str) {
        this(str, new HashMap());
    }

    public C1179d(String str, HashMap<String, Object> hashMap) {
        this.f2436a = str;
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        this.f2438c = hashMap;
    }

    /* renamed from: a */
    public String mo10752a() {
        return this.f2436a;
    }

    /* renamed from: a */
    public void mo10753a(List<ActionDO> list) {
        this.f2437b = list;
    }

    /* renamed from: b */
    public HashMap<String, Object> mo10754b() {
        return this.f2438c;
    }
}
