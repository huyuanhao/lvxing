package com.alibaba.fastjson.parser.p066a;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

/* renamed from: com.alibaba.fastjson.parser.a.t */
public class OptionalCodec implements ObjectDeserializer, ObjectSerializer {
    /* renamed from: a */
    public static OptionalCodec f2758a = new OptionalCodec();

    /* renamed from: g_ */
    public int mo11162g_() {
        return 12;
    }

    /* renamed from: a */
    public <T> T mo11161a(DefaultJSONParser aVar, Type type, Object obj) {
        if (type == OptionalInt.class) {
            Integer m = TypeUtils.m3274m(aVar.mo11116a(Integer.class));
            if (m == null) {
                return OptionalInt.empty();
            }
            return OptionalInt.of(m.intValue());
        } else if (type == OptionalLong.class) {
            Long l = TypeUtils.m3273l(aVar.mo11116a(Long.class));
            if (l == null) {
                return OptionalLong.empty();
            }
            return OptionalLong.of(l.longValue());
        } else if (type == OptionalDouble.class) {
            Double h = TypeUtils.m3269h(aVar.mo11116a(Double.class));
            if (h == null) {
                return OptionalDouble.empty();
            }
            return OptionalDouble.of(h.doubleValue());
        } else {
            Object a = aVar.mo11117a(TypeUtils.m3251c(type));
            if (a == null) {
                return Optional.empty();
            }
            return Optional.of(a);
        }
    }

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        if (obj == null) {
            agVar.mo11329g();
        } else if (obj instanceof Optional) {
            Optional optional = (Optional) obj;
            agVar.mo11325c(optional.isPresent() ? optional.get() : null);
        } else if (obj instanceof OptionalDouble) {
            OptionalDouble optionalDouble = (OptionalDouble) obj;
            if (optionalDouble.isPresent()) {
                agVar.mo11325c(Double.valueOf(optionalDouble.getAsDouble()));
            } else {
                agVar.mo11329g();
            }
        } else if (obj instanceof OptionalInt) {
            OptionalInt optionalInt = (OptionalInt) obj;
            if (optionalInt.isPresent()) {
                agVar.f2846b.mo11403c(optionalInt.getAsInt());
            } else {
                agVar.mo11329g();
            }
        } else if (obj instanceof OptionalLong) {
            OptionalLong optionalLong = (OptionalLong) obj;
            if (optionalLong.isPresent()) {
                agVar.f2846b.mo11381a(optionalLong.getAsLong());
            } else {
                agVar.mo11329g();
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("not support optional : ");
            sb.append(obj.getClass());
            throw new JSONException(sb.toString());
        }
    }
}
