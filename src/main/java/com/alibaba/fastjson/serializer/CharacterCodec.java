package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.p066a.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;

/* renamed from: com.alibaba.fastjson.serializer.q */
public class CharacterCodec implements ObjectDeserializer, ObjectSerializer {
    /* renamed from: a */
    public static final CharacterCodec f2948a = new CharacterCodec();

    /* renamed from: g_ */
    public int mo11162g_() {
        return 4;
    }

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter baVar = agVar.f2846b;
        Character ch = (Character) obj;
        if (ch == null) {
            baVar.mo11384a("");
            return;
        }
        if (ch.charValue() == 0) {
            baVar.mo11384a("\u0000");
        } else {
            baVar.mo11384a(ch.toString());
        }
    }

    /* renamed from: a */
    public <T> T mo11161a(DefaultJSONParser aVar, Type type, Object obj) {
        Object m = aVar.mo11155m();
        if (m == null) {
            return null;
        }
        return TypeUtils.m3249c(m);
    }
}
