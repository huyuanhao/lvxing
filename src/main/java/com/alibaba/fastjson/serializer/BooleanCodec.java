package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.p066a.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.alibaba.fastjson.serializer.n */
public class BooleanCodec implements ObjectDeserializer, ObjectSerializer {
    /* renamed from: a */
    public static final BooleanCodec f2945a = new BooleanCodec();

    /* renamed from: g_ */
    public int mo11162g_() {
        return 6;
    }

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter baVar = agVar.f2846b;
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            baVar.mo11399b(SerializerFeature.WriteNullBooleanAsFalse);
            return;
        }
        if (bool.booleanValue()) {
            baVar.write("true");
        } else {
            baVar.write("false");
        }
    }

    /* renamed from: a */
    public <T> T mo11161a(DefaultJSONParser aVar, Type type, Object obj) {
        T t;
        JSONLexer bVar = aVar.f2689d;
        try {
            if (bVar.mo11205a() == 6) {
                bVar.mo11211a(16);
                t = Boolean.TRUE;
            } else if (bVar.mo11205a() == 7) {
                bVar.mo11211a(16);
                t = Boolean.FALSE;
            } else if (bVar.mo11205a() == 2) {
                int n = bVar.mo11235n();
                bVar.mo11211a(16);
                if (n == 1) {
                    t = Boolean.TRUE;
                } else {
                    t = Boolean.FALSE;
                }
            } else {
                Object m = aVar.mo11155m();
                if (m == null) {
                    return null;
                }
                t = TypeUtils.m3276o(m);
            }
            return type == AtomicBoolean.class ? new AtomicBoolean(t.booleanValue()) : t;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("parseBoolean error, field : ");
            sb.append(obj);
            throw new JSONException(sb.toString(), e);
        }
    }
}
