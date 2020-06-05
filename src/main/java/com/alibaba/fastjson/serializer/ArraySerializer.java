package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* renamed from: com.alibaba.fastjson.serializer.f */
public class ArraySerializer implements ObjectSerializer {
    /* renamed from: a */
    private final Class<?> f2933a;
    /* renamed from: b */
    private final ObjectSerializer f2934b;

    public ArraySerializer(Class<?> cls, ObjectSerializer aqVar) {
        this.f2933a = cls;
        this.f2934b = aqVar;
    }

    /* renamed from: a */
    public final void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter baVar = agVar.f2846b;
        if (obj == null) {
            baVar.mo11399b(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        Object[] objArr = (Object[]) obj;
        int length = objArr.length;
        SerialContext avVar = agVar.f2848d;
        agVar.mo11312a(avVar, obj, obj2, 0);
        try {
            baVar.append('[');
            for (int i2 = 0; i2 < length; i2++) {
                if (i2 != 0) {
                    baVar.append(',');
                }
                Object obj3 = objArr[i2];
                if (obj3 == null) {
                    if (!baVar.mo11391a(SerializerFeature.WriteNullStringAsEmpty) || !(obj instanceof String[])) {
                        baVar.append((CharSequence) "null");
                    } else {
                        baVar.mo11384a("");
                    }
                } else if (obj3.getClass() == this.f2933a) {
                    this.f2934b.mo11198a(agVar, obj3, Integer.valueOf(i2), null, 0);
                } else {
                    agVar.mo11309a(obj3.getClass()).mo11198a(agVar, obj3, Integer.valueOf(i2), null, 0);
                }
            }
            baVar.append(']');
        } finally {
            agVar.f2848d = avVar;
        }
    }
}
