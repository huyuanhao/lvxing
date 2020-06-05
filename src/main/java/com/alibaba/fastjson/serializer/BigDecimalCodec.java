package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.p066a.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/* renamed from: com.alibaba.fastjson.serializer.l */
public class BigDecimalCodec implements ObjectDeserializer, ObjectSerializer {
    /* renamed from: a */
    public static final BigDecimalCodec f2943a = new BigDecimalCodec();

    /* renamed from: g_ */
    public int mo11162g_() {
        return 2;
    }

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        String str;
        SerializeWriter baVar = agVar.f2846b;
        if (obj == null) {
            baVar.mo11399b(SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        BigDecimal bigDecimal = (BigDecimal) obj;
        if (baVar.mo11391a(SerializerFeature.WriteBigDecimalAsPlain)) {
            str = bigDecimal.toPlainString();
        } else {
            str = bigDecimal.toString();
        }
        baVar.write(str);
        if (baVar.mo11391a(SerializerFeature.WriteClassName) && type != BigDecimal.class && bigDecimal.scale() == 0) {
            baVar.write(46);
        }
    }

    /* renamed from: a */
    public <T> T mo11161a(DefaultJSONParser aVar, Type type, Object obj) {
        try {
            return m3121a(aVar);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("parseDecimal error, field : ");
            sb.append(obj);
            throw new JSONException(sb.toString(), e);
        }
    }

    /* renamed from: a */
    public static <T> T m3121a(DefaultJSONParser aVar) {
        T t;
        JSONLexer bVar = aVar.f2689d;
        if (bVar.mo11205a() == 2) {
            T k = bVar.mo11232k();
            bVar.mo11211a(16);
            return k;
        } else if (bVar.mo11205a() == 3) {
            T k2 = bVar.mo11232k();
            bVar.mo11211a(16);
            return k2;
        } else {
            Object m = aVar.mo11155m();
            if (m == null) {
                t = null;
            } else {
                t = TypeUtils.m3260e(m);
            }
            return t;
        }
    }
}
