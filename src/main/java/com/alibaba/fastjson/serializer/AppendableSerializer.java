package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* renamed from: com.alibaba.fastjson.serializer.e */
public class AppendableSerializer implements ObjectSerializer {
    /* renamed from: a */
    public static final AppendableSerializer f2932a = new AppendableSerializer();

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        if (obj == null) {
            agVar.f2846b.mo11399b(SerializerFeature.WriteNullStringAsEmpty);
        } else {
            agVar.mo11323b(obj.toString());
        }
    }
}
