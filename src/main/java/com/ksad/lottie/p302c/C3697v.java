package com.ksad.lottie.p302c;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import com.ksad.lottie.model.content.C3762c;
import com.ksad.lottie.p303d.C3708e;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.ksad.lottie.c.v */
public class C3697v implements C3686k<C3762c> {
    /* renamed from: a */
    private int f12585a;

    public C3697v(int i) {
        this.f12585a = i;
    }

    /* renamed from: a */
    private int m15315a(double d, double[] dArr, double[] dArr2) {
        double d2;
        double[] dArr3 = dArr;
        double[] dArr4 = dArr2;
        int i = 1;
        while (true) {
            if (i >= dArr3.length) {
                d2 = dArr4[dArr4.length - 1];
                break;
            }
            int i2 = i - 1;
            double d3 = dArr3[i2];
            double d4 = dArr3[i];
            if (dArr3[i] >= d) {
                d2 = C3708e.m15376a(dArr4[i2], dArr4[i], (d - d3) / (d4 - d3));
                break;
            }
            i++;
        }
        return (int) (d2 * 255.0d);
    }

    /* renamed from: a */
    private void m15316a(C3762c cVar, List<Float> list) {
        int i = this.f12585a * 4;
        if (list.size() > i) {
            int size = (list.size() - i) / 2;
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            int i2 = 0;
            while (i < list.size()) {
                if (i % 2 == 0) {
                    dArr[i2] = (double) ((Float) list.get(i)).floatValue();
                } else {
                    dArr2[i2] = (double) ((Float) list.get(i)).floatValue();
                    i2++;
                }
                i++;
            }
            for (int i3 = 0; i3 < cVar.mo23091c(); i3++) {
                int i4 = cVar.mo23090b()[i3];
                cVar.mo23090b()[i3] = Color.argb(m15315a((double) cVar.mo23089a()[i3], dArr, dArr2), Color.red(i4), Color.green(i4), Color.blue(i4));
            }
        }
    }

    /* renamed from: a */
    public C3762c mo22864b(JsonReader jsonReader, float f) {
        ArrayList arrayList = new ArrayList();
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (z) {
            jsonReader.endArray();
        }
        if (this.f12585a == -1) {
            this.f12585a = arrayList.size() / 4;
        }
        int i = this.f12585a;
        float[] fArr = new float[i];
        int[] iArr = new int[i];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f12585a * 4; i4++) {
            int i5 = i4 / 4;
            double floatValue = (double) ((Float) arrayList.get(i4)).floatValue();
            int i6 = i4 % 4;
            if (i6 == 0) {
                fArr[i5] = (float) floatValue;
            } else if (i6 == 1) {
                i2 = (int) (floatValue * 255.0d);
            } else if (i6 == 2) {
                i3 = (int) (floatValue * 255.0d);
            } else if (i6 == 3) {
                iArr[i5] = Color.argb(255, i2, i3, (int) (floatValue * 255.0d));
            }
        }
        C3762c cVar = new C3762c(fArr, iArr);
        m15316a(cVar, (List<Float>) arrayList);
        return cVar;
    }
}
