package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Enumeration;

/* renamed from: com.alibaba.fastjson.serializer.y */
public class EnumerationSerializer implements ObjectSerializer {
    /* renamed from: a */
    public static EnumerationSerializer f2955a = new EnumerationSerializer();

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter baVar = agVar.f2846b;
        if (obj == null) {
            baVar.mo11399b(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        Type type2 = null;
        int i2 = 0;
        if (baVar.mo11391a(SerializerFeature.WriteClassName) && (type instanceof ParameterizedType)) {
            type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        }
        Enumeration enumeration = (Enumeration) obj;
        SerialContext avVar = agVar.f2848d;
        agVar.mo11312a(avVar, obj, obj2, 0);
        try {
            baVar.append('[');
            while (enumeration.hasMoreElements()) {
                Object nextElement = enumeration.nextElement();
                int i3 = i2 + 1;
                if (i2 != 0) {
                    baVar.append(',');
                }
                if (nextElement == null) {
                    baVar.mo11396b();
                } else {
                    agVar.mo11309a(nextElement.getClass()).mo11198a(agVar, nextElement, Integer.valueOf(i3 - 1), type2, 0);
                }
                i2 = i3;
            }
            baVar.append(']');
        } finally {
            agVar.f2848d = avVar;
        }
    }
}
