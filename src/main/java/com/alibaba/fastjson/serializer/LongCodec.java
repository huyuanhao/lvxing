package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.p066a.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.alibaba.fastjson.serializer.al */
public class LongCodec implements ObjectDeserializer, ObjectSerializer {
    /* renamed from: a */
    public static LongCodec f2861a = new LongCodec();

    /* renamed from: g_ */
    public int mo11162g_() {
        return 2;
    }

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter baVar = agVar.f2846b;
        if (obj == null) {
            baVar.mo11399b(SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        long longValue = ((Long) obj).longValue();
        baVar.mo11381a(longValue);
        if (baVar.mo11391a(SerializerFeature.WriteClassName) && longValue <= 2147483647L && longValue >= -2147483648L && type != Long.class && type != Long.TYPE) {
            baVar.write(76);
        }
    }

    /* renamed from: a */
    public <T> T mo11161a(DefaultJSONParser aVar, Type type, Object obj) {
        T t;
        JSONLexer bVar = aVar.f2689d;
        try {
            int a = bVar.mo11205a();
            if (a == 2) {
                long q = bVar.mo11238q();
                bVar.mo11211a(16);
                t = Long.valueOf(q);
            } else {
                if (a == 12) {
                    JSONObject jSONObject = new JSONObject(true);
                    aVar.mo11119a((Map) jSONObject);
                    t = TypeUtils.m3273l(jSONObject);
                } else {
                    t = TypeUtils.m3273l(aVar.mo11155m());
                }
                if (t == null) {
                    return null;
                }
            }
            if (type == AtomicLong.class) {
                t = new AtomicLong(t.longValue());
            }
            return t;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("parseLong error, field : ");
            sb.append(obj);
            throw new JSONException(sb.toString(), e);
        }
    }
}
