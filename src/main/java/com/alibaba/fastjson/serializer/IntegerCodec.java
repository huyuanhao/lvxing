package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.p066a.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.alibaba.fastjson.serializer.ac */
public class IntegerCodec implements ObjectDeserializer, ObjectSerializer {
    /* renamed from: a */
    public static IntegerCodec f2842a = new IntegerCodec();

    /* renamed from: g_ */
    public int mo11162g_() {
        return 2;
    }

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter baVar = agVar.f2846b;
        Number number = (Number) obj;
        if (number == null) {
            baVar.mo11399b(SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        if (obj instanceof Long) {
            baVar.mo11381a(number.longValue());
        } else {
            baVar.mo11403c(number.intValue());
        }
        if (baVar.mo11391a(SerializerFeature.WriteClassName)) {
            Class<Short> cls = number.getClass();
            if (cls == Byte.class) {
                baVar.write(66);
            } else if (cls == Short.class) {
                baVar.write(83);
            }
        }
    }

    /* renamed from: a */
    public <T> T mo11161a(DefaultJSONParser aVar, Type type, Object obj) {
        T t;
        JSONLexer bVar = aVar.f2689d;
        int a = bVar.mo11205a();
        if (a == 8) {
            bVar.mo11211a(16);
            return null;
        }
        if (a == 2) {
            try {
                int n = bVar.mo11235n();
                bVar.mo11211a(16);
                t = Integer.valueOf(n);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("parseInt error, field : ");
                sb.append(obj);
                throw new JSONException(sb.toString(), e);
            }
        } else if (a == 3) {
            BigDecimal k = bVar.mo11232k();
            bVar.mo11211a(16);
            t = Integer.valueOf(k.intValue());
        } else if (a == 12) {
            JSONObject jSONObject = new JSONObject(true);
            aVar.mo11119a((Map) jSONObject);
            t = TypeUtils.m3274m(jSONObject);
        } else {
            t = TypeUtils.m3274m(aVar.mo11155m());
        }
        return type == AtomicInteger.class ? new AtomicInteger(t.intValue()) : t;
    }
}
