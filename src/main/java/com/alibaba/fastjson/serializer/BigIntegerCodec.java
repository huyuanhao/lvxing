package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.p066a.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigInteger;

/* renamed from: com.alibaba.fastjson.serializer.m */
public class BigIntegerCodec implements ObjectDeserializer, ObjectSerializer {
    /* renamed from: a */
    public static final BigIntegerCodec f2944a = new BigIntegerCodec();

    /* renamed from: g_ */
    public int mo11162g_() {
        return 2;
    }

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter baVar = agVar.f2846b;
        if (obj == null) {
            baVar.mo11399b(SerializerFeature.WriteNullNumberAsZero);
        } else {
            baVar.write(((BigInteger) obj).toString());
        }
    }

    /* renamed from: a */
    public <T> T mo11161a(DefaultJSONParser aVar, Type type, Object obj) {
        return m3125a(aVar);
    }

    /* renamed from: a */
    public static <T> T m3125a(DefaultJSONParser aVar) {
        T t;
        JSONLexer bVar = aVar.f2689d;
        if (bVar.mo11205a() == 2) {
            String s = bVar.mo11240s();
            bVar.mo11211a(16);
            return new BigInteger(s);
        }
        Object m = aVar.mo11155m();
        if (m == null) {
            t = null;
        } else {
            t = TypeUtils.m3264f(m);
        }
        return t;
    }
}
