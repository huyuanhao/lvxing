package com.ksad.lottie.p302c;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;

/* renamed from: com.ksad.lottie.c.p */
public class C3691p implements C3686k<Integer> {
    /* renamed from: a */
    public static final C3691p f12582a = new C3691p();

    private C3691p() {
    }

    /* renamed from: a */
    public Integer mo22864b(JsonReader jsonReader, float f) {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        double nextDouble = jsonReader.nextDouble();
        double nextDouble2 = jsonReader.nextDouble();
        double nextDouble3 = jsonReader.nextDouble();
        double nextDouble4 = jsonReader.nextDouble();
        if (z) {
            jsonReader.endArray();
        }
        if (nextDouble <= 1.0d && nextDouble2 <= 1.0d && nextDouble3 <= 1.0d && nextDouble4 <= 1.0d) {
            nextDouble *= 255.0d;
            nextDouble2 *= 255.0d;
            nextDouble3 *= 255.0d;
            nextDouble4 *= 255.0d;
        }
        return Integer.valueOf(Color.argb((int) nextDouble4, (int) nextDouble, (int) nextDouble2, (int) nextDouble3));
    }
}
