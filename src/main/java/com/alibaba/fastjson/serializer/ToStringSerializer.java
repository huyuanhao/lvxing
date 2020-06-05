package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* renamed from: com.alibaba.fastjson.serializer.bc */
public class ToStringSerializer implements ObjectSerializer {
    /* renamed from: a */
    public static final ToStringSerializer f2927a = new ToStringSerializer();

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter baVar = agVar.f2846b;
        if (obj == null) {
            baVar.mo11396b();
        } else {
            baVar.mo11384a(obj.toString());
        }
    }
}
