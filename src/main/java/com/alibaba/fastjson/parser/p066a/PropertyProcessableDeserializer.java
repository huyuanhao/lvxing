package com.alibaba.fastjson.parser.p066a;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.Type;

/* renamed from: com.alibaba.fastjson.parser.a.w */
public class PropertyProcessableDeserializer implements ObjectDeserializer {
    /* renamed from: a */
    public final Class<PropertyProcessable> f2759a;

    /* renamed from: g_ */
    public int mo11162g_() {
        return 12;
    }

    public PropertyProcessableDeserializer(Class<PropertyProcessable> cls) {
        this.f2759a = cls;
    }

    /* renamed from: a */
    public <T> T mo11161a(DefaultJSONParser aVar, Type type, Object obj) {
        try {
            return aVar.mo11115a((PropertyProcessable) this.f2759a.newInstance(), obj);
        } catch (Exception unused) {
            throw new JSONException("craete instance error");
        }
    }
}
