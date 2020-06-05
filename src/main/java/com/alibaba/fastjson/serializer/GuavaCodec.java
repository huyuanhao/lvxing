package com.alibaba.fastjson.serializer;

import com.google.common.collect.Multimap;
import java.io.IOException;
import java.lang.reflect.Type;

/* renamed from: com.alibaba.fastjson.serializer.ab */
public class GuavaCodec implements ObjectSerializer {
    /* renamed from: a */
    public static GuavaCodec f2841a = new GuavaCodec();

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter baVar = agVar.f2846b;
        if (obj instanceof Multimap) {
            agVar.mo11325c(((Multimap) obj).asMap());
        }
    }
}
