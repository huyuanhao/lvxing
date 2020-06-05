package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.p066a.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;

/* renamed from: com.alibaba.fastjson.serializer.bb */
public class StringCodec implements ObjectDeserializer, ObjectSerializer {
    /* renamed from: a */
    public static StringCodec f2926a = new StringCodec();

    /* renamed from: g_ */
    public int mo11162g_() {
        return 4;
    }

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        mo11412a(agVar, (String) obj);
    }

    /* renamed from: a */
    public void mo11412a(JSONSerializer agVar, String str) {
        SerializeWriter baVar = agVar.f2846b;
        if (str == null) {
            baVar.mo11399b(SerializerFeature.WriteNullStringAsEmpty);
        } else {
            baVar.mo11384a(str);
        }
    }

    /* renamed from: a */
    public <T> T mo11161a(DefaultJSONParser aVar, Type type, Object obj) {
        if (type == StringBuffer.class) {
            JSONLexer bVar = aVar.f2689d;
            if (bVar.mo11205a() == 4) {
                String l = bVar.mo11233l();
                bVar.mo11211a(16);
                return new StringBuffer(l);
            }
            Object m = aVar.mo11155m();
            if (m == null) {
                return null;
            }
            return new StringBuffer(m.toString());
        } else if (type != StringBuilder.class) {
            return m3090a(aVar);
        } else {
            JSONLexer bVar2 = aVar.f2689d;
            if (bVar2.mo11205a() == 4) {
                String l2 = bVar2.mo11233l();
                bVar2.mo11211a(16);
                return new StringBuilder(l2);
            }
            Object m2 = aVar.mo11155m();
            if (m2 == null) {
                return null;
            }
            return new StringBuilder(m2.toString());
        }
    }

    /* renamed from: a */
    public static <T> T m3090a(DefaultJSONParser aVar) {
        JSONLexer n = aVar.mo11156n();
        if (n.mo11205a() == 4) {
            T l = n.mo11233l();
            n.mo11211a(16);
            return l;
        } else if (n.mo11205a() == 2) {
            T s = n.mo11240s();
            n.mo11211a(16);
            return s;
        } else {
            Object m = aVar.mo11155m();
            if (m == null) {
                return null;
            }
            return m.toString();
        }
    }
}
