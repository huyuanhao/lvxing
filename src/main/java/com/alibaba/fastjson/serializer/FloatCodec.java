package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.p066a.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/* renamed from: com.alibaba.fastjson.serializer.aa */
public class FloatCodec implements ObjectDeserializer, ObjectSerializer {
    /* renamed from: a */
    public static FloatCodec f2839a = new FloatCodec();
    /* renamed from: b */
    private NumberFormat f2840b;

    /* renamed from: g_ */
    public int mo11162g_() {
        return 2;
    }

    public FloatCodec() {
    }

    public FloatCodec(DecimalFormat decimalFormat) {
        this.f2840b = decimalFormat;
    }

    public FloatCodec(String str) {
        this(new DecimalFormat(str));
    }

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter baVar = agVar.f2846b;
        if (obj == null) {
            baVar.mo11399b(SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        float floatValue = ((Float) obj).floatValue();
        NumberFormat numberFormat = this.f2840b;
        if (numberFormat != null) {
            baVar.write(numberFormat.format((double) floatValue));
        } else {
            baVar.mo11379a(floatValue, true);
        }
    }

    /* renamed from: a */
    public <T> T mo11161a(DefaultJSONParser aVar, Type type, Object obj) {
        try {
            return m2963a(aVar);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("parseLong error, field : ");
            sb.append(obj);
            throw new JSONException(sb.toString(), e);
        }
    }

    /* renamed from: a */
    public static <T> T m2963a(DefaultJSONParser aVar) {
        JSONLexer bVar = aVar.f2689d;
        if (bVar.mo11205a() == 2) {
            String s = bVar.mo11240s();
            bVar.mo11211a(16);
            return Float.valueOf(Float.parseFloat(s));
        } else if (bVar.mo11205a() == 3) {
            float u = bVar.mo11242u();
            bVar.mo11211a(16);
            return Float.valueOf(u);
        } else {
            Object m = aVar.mo11155m();
            if (m == null) {
                return null;
            }
            return TypeUtils.m3266g(m);
        }
    }
}
