package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* renamed from: com.alibaba.fastjson.serializer.af */
public class JSONSerializableSerializer implements ObjectSerializer {
    /* renamed from: a */
    public static JSONSerializableSerializer f2844a = new JSONSerializableSerializer();

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        ((JSONSerializable) obj).mo11080a(agVar, obj2, type, i);
    }
}
