package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.FieldInfo;

/* renamed from: com.alibaba.fastjson.serializer.j */
public final class BeanContext {
    /* renamed from: a */
    private final Class<?> f2937a;
    /* renamed from: b */
    private final FieldInfo f2938b;
    /* renamed from: c */
    private final String f2939c;

    public BeanContext(Class<?> cls, FieldInfo cVar) {
        this.f2937a = cls;
        this.f2938b = cVar;
        this.f2939c = cVar.mo11507e();
    }

    /* renamed from: a */
    public int mo11422a() {
        return this.f2938b.f2999h;
    }

    /* renamed from: b */
    public boolean mo11423b() {
        return this.f2938b.f3006o;
    }

    /* renamed from: c */
    public String mo11424c() {
        return this.f2939c;
    }
}
