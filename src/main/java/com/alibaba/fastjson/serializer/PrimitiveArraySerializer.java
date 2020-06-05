package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* renamed from: com.alibaba.fastjson.serializer.ar */
public class PrimitiveArraySerializer implements ObjectSerializer {
    /* renamed from: a */
    public static PrimitiveArraySerializer f2869a = new PrimitiveArraySerializer();

    /* renamed from: a */
    public final void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        int i2;
        int i3;
        int i4;
        int i5;
        SerializeWriter baVar = agVar.f2846b;
        if (obj == null) {
            baVar.mo11399b(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        int i6 = 0;
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            baVar.write(91);
            while (i6 < iArr.length) {
                if (i6 != 0) {
                    baVar.write(44);
                }
                baVar.mo11403c(iArr[i6]);
                i6++;
            }
            baVar.write(93);
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            baVar.write(91);
            while (i6 < sArr.length) {
                if (i6 != 0) {
                    baVar.write(44);
                }
                baVar.mo11403c((int) sArr[i6]);
                i6++;
            }
            baVar.write(93);
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            baVar.write(91);
            while (i5 < jArr.length) {
                if (i5 != 0) {
                    baVar.write(44);
                }
                baVar.mo11381a(jArr[i5]);
                i5++;
            }
            baVar.write(93);
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            baVar.write(91);
            while (i4 < zArr.length) {
                if (i4 != 0) {
                    baVar.write(44);
                }
                baVar.mo11387a(zArr[i4]);
                i4++;
            }
            baVar.write(93);
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            baVar.write(91);
            while (i3 < fArr.length) {
                if (i3 != 0) {
                    baVar.write(44);
                }
                float f = fArr[i3];
                if (Float.isNaN(f)) {
                    baVar.mo11396b();
                } else {
                    baVar.append((CharSequence) Float.toString(f));
                }
                i3++;
            }
            baVar.write(93);
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            baVar.write(91);
            while (i2 < dArr.length) {
                if (i2 != 0) {
                    baVar.write(44);
                }
                double d = dArr[i2];
                if (Double.isNaN(d)) {
                    baVar.mo11396b();
                } else {
                    baVar.append((CharSequence) Double.toString(d));
                }
                i2++;
            }
            baVar.write(93);
        } else if (obj instanceof byte[]) {
            baVar.mo11388a((byte[]) obj);
        } else {
            baVar.mo11389a((char[]) obj);
        }
    }
}
