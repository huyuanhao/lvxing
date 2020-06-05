package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.p066a.ObjectDeserializer;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.alibaba.fastjson.serializer.au */
public class ReferenceCodec implements ObjectDeserializer, ObjectSerializer {
    /* renamed from: a */
    public static final ReferenceCodec f2870a = new ReferenceCodec();

    /* renamed from: g_ */
    public int mo11162g_() {
        return 12;
    }

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        Object obj3;
        if (obj instanceof AtomicReference) {
            obj3 = ((AtomicReference) obj).get();
        } else {
            obj3 = ((Reference) obj).get();
        }
        agVar.mo11325c(obj3);
    }

    /* renamed from: a */
    public <T> T mo11161a(DefaultJSONParser aVar, Type type, Object obj) {
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Object a = aVar.mo11117a(parameterizedType.getActualTypeArguments()[0]);
        Type rawType = parameterizedType.getRawType();
        if (rawType == AtomicReference.class) {
            return new AtomicReference(a);
        }
        if (rawType == WeakReference.class) {
            return new WeakReference(a);
        }
        if (rawType == SoftReference.class) {
            return new SoftReference(a);
        }
        throw new UnsupportedOperationException(rawType.toString());
    }
}
