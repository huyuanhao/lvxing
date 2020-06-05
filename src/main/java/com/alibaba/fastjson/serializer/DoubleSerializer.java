package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

/* renamed from: com.alibaba.fastjson.serializer.w */
public class DoubleSerializer implements ObjectSerializer {
    /* renamed from: a */
    public static final DoubleSerializer f2952a = new DoubleSerializer();
    /* renamed from: b */
    private DecimalFormat f2953b;

    public DoubleSerializer() {
        this.f2953b = null;
    }

    public DoubleSerializer(DecimalFormat decimalFormat) {
        this.f2953b = null;
        this.f2953b = decimalFormat;
    }

    public DoubleSerializer(String str) {
        this(new DecimalFormat(str));
    }

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter baVar = agVar.f2846b;
        if (obj == null) {
            baVar.mo11399b(SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        double doubleValue = ((Double) obj).doubleValue();
        if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
            baVar.mo11396b();
        } else {
            DecimalFormat decimalFormat = this.f2953b;
            if (decimalFormat == null) {
                baVar.mo11378a(doubleValue, true);
            } else {
                baVar.write(decimalFormat.format(doubleValue));
            }
        }
    }
}
