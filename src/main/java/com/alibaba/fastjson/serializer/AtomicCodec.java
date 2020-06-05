package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.p066a.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* renamed from: com.alibaba.fastjson.serializer.g */
public class AtomicCodec implements ObjectDeserializer, ObjectSerializer {
    /* renamed from: a */
    public static final AtomicCodec f2935a = new AtomicCodec();

    /* renamed from: g_ */
    public int mo11162g_() {
        return 14;
    }

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter baVar = agVar.f2846b;
        if (obj instanceof AtomicInteger) {
            baVar.mo11403c(((AtomicInteger) obj).get());
        } else if (obj instanceof AtomicLong) {
            baVar.mo11381a(((AtomicLong) obj).get());
        } else if (obj instanceof AtomicBoolean) {
            baVar.append((CharSequence) ((AtomicBoolean) obj).get() ? "true" : "false");
        } else if (obj == null) {
            baVar.mo11399b(SerializerFeature.WriteNullListAsEmpty);
        } else {
            int i2 = 0;
            if (obj instanceof AtomicIntegerArray) {
                AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
                int length = atomicIntegerArray.length();
                baVar.write(91);
                while (i2 < length) {
                    int i3 = atomicIntegerArray.get(i2);
                    if (i2 != 0) {
                        baVar.write(44);
                    }
                    baVar.mo11403c(i3);
                    i2++;
                }
                baVar.write(93);
                return;
            }
            AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
            int length2 = atomicLongArray.length();
            baVar.write(91);
            while (i2 < length2) {
                long j = atomicLongArray.get(i2);
                if (i2 != 0) {
                    baVar.write(44);
                }
                baVar.mo11381a(j);
                i2++;
            }
            baVar.write(93);
        }
    }

    /* renamed from: a */
    public <T> T mo11161a(DefaultJSONParser aVar, Type type, Object obj) {
        if (aVar.f2689d.mo11205a() == 8) {
            aVar.f2689d.mo11211a(16);
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        aVar.mo11140b((Collection) jSONArray);
        int i = 0;
        if (type == AtomicIntegerArray.class) {
            T atomicIntegerArray = new AtomicIntegerArray(jSONArray.size());
            while (i < jSONArray.size()) {
                atomicIntegerArray.set(i, jSONArray.getInteger(i).intValue());
                i++;
            }
            return atomicIntegerArray;
        }
        T atomicLongArray = new AtomicLongArray(jSONArray.size());
        while (i < jSONArray.size()) {
            atomicLongArray.set(i, jSONArray.getLong(i).longValue());
            i++;
        }
        return atomicLongArray;
    }
}
