package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.p066a.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

/* renamed from: com.alibaba.fastjson.serializer.s */
public class CollectionCodec implements ObjectDeserializer, ObjectSerializer {
    /* renamed from: a */
    public static final CollectionCodec f2950a = new CollectionCodec();

    /* renamed from: g_ */
    public int mo11162g_() {
        return 14;
    }

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter baVar = agVar.f2846b;
        if (obj == null) {
            baVar.mo11399b(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        Type type2 = null;
        if (baVar.mo11391a(SerializerFeature.WriteClassName) || SerializerFeature.isEnabled(i, SerializerFeature.WriteClassName)) {
            type2 = TypeUtils.m3259e(type);
        }
        Collection collection = (Collection) obj;
        SerialContext avVar = agVar.f2848d;
        int i2 = 0;
        agVar.mo11312a(avVar, obj, obj2, 0);
        if (baVar.mo11391a(SerializerFeature.WriteClassName)) {
            if (HashSet.class == collection.getClass()) {
                baVar.append((CharSequence) "Set");
            } else if (TreeSet.class == collection.getClass()) {
                baVar.append((CharSequence) "TreeSet");
            }
        }
        try {
            baVar.append('[');
            for (Object next : collection) {
                int i3 = i2 + 1;
                if (i2 != 0) {
                    baVar.append(',');
                }
                if (next == null) {
                    baVar.mo11396b();
                } else {
                    Class<Long> cls = next.getClass();
                    if (cls == Integer.class) {
                        baVar.mo11403c(((Integer) next).intValue());
                    } else if (cls == Long.class) {
                        baVar.mo11381a(((Long) next).longValue());
                        if (baVar.mo11391a(SerializerFeature.WriteClassName)) {
                            baVar.write(76);
                        }
                    } else {
                        ObjectSerializer a = agVar.mo11309a(cls);
                        if (!SerializerFeature.isEnabled(i, SerializerFeature.WriteClassName) || !(a instanceof JavaBeanSerializer)) {
                            a.mo11198a(agVar, next, Integer.valueOf(i3 - 1), type2, i);
                        } else {
                            ((JavaBeanSerializer) a).mo11343b(agVar, next, Integer.valueOf(i3 - 1), type2, i);
                        }
                    }
                }
                i2 = i3;
            }
            baVar.append(']');
        } finally {
            agVar.f2848d = avVar;
        }
    }

    /* renamed from: a */
    public <T> T mo11161a(DefaultJSONParser aVar, Type type, Object obj) {
        if (aVar.f2689d.mo11205a() == 8) {
            aVar.f2689d.mo11211a(16);
            return null;
        } else if (type == JSONArray.class) {
            T jSONArray = new JSONArray();
            aVar.mo11140b((Collection) jSONArray);
            return jSONArray;
        } else {
            T g = TypeUtils.m3267g(type);
            aVar.mo11131a(TypeUtils.m3259e(type), (Collection) g, obj);
            return g;
        }
    }
}
