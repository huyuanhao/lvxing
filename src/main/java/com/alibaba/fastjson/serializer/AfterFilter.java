package com.alibaba.fastjson.serializer;

/* renamed from: com.alibaba.fastjson.serializer.c */
public abstract class AfterFilter implements SerializeFilter {
    /* renamed from: a */
    private static final ThreadLocal<JSONSerializer> f2928a = new ThreadLocal<>();
    /* renamed from: b */
    private static final ThreadLocal<Character> f2929b = new ThreadLocal<>();
    /* renamed from: c */
    private static final Character f2930c = Character.valueOf(',');

    /* renamed from: a */
    public abstract void mo11415a(Object obj);

    /* access modifiers changed from: final */
    /* renamed from: a */
    public final char mo11414a(JSONSerializer agVar, Object obj, char c) {
        f2928a.set(agVar);
        f2929b.set(Character.valueOf(c));
        mo11415a(obj);
        f2928a.set(null);
        return ((Character) f2929b.get()).charValue();
    }
}
