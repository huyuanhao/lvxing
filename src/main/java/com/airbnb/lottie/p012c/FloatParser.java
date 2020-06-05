package com.airbnb.lottie.p012c;

import android.util.JsonReader;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.c.i */
public class FloatParser implements ValueParser<Float> {
    /* renamed from: a */
    public static final FloatParser f1448a = new FloatParser();

    private FloatParser() {
    }

    /* renamed from: a */
    public Float mo9904b(JsonReader jsonReader, float f) throws IOException {
        return Float.valueOf(JsonUtils.m1365b(jsonReader) * f);
    }
}
