package com.alibaba.fastjson.serializer;

/* renamed from: com.alibaba.fastjson.serializer.k */
public abstract class BeforeFilter implements SerializeFilter {
    /* renamed from: a */
    private static final ThreadLocal<JSONSerializer> f2940a = new ThreadLocal<>();
    /* renamed from: b */
    private static final ThreadLocal<Character> f2941b = new ThreadLocal<>();
    /* renamed from: c */
    private static final Character f2942c = Character.valueOf(',');

    /* renamed from: a */
    public abstract void mo11426a(Object obj);

    /* access modifiers changed from: final */
    /* renamed from: a */
    public final char mo11425a(JSONSerializer agVar, Object obj, char c) {
        f2940a.set(agVar);
        f2941b.set(Character.valueOf(c));
        mo11426a(obj);
        f2940a.set(null);
        return ((Character) f2941b.get()).charValue();
    }
}
