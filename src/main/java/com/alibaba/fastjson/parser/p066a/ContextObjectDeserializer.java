package com.alibaba.fastjson.parser.p066a;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.Type;

/* renamed from: com.alibaba.fastjson.parser.a.e */
public abstract class ContextObjectDeserializer implements ObjectDeserializer {
    /* renamed from: a */
    public abstract <T> T mo11164a(DefaultJSONParser aVar, Type type, Object obj, String str, int i);

    /* renamed from: a */
    public <T> T mo11161a(DefaultJSONParser aVar, Type type, Object obj) {
        return mo11164a(aVar, type, obj, null, 0);
    }
}
