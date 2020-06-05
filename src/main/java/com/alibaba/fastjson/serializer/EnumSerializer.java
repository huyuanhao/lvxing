package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* renamed from: com.alibaba.fastjson.serializer.x */
public class EnumSerializer implements ObjectSerializer {
    /* renamed from: a */
    public static final EnumSerializer f2954a = new EnumSerializer();

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        agVar.f2846b.mo11383a((Enum) obj);
    }
}
