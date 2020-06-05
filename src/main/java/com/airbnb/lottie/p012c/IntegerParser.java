package com.airbnb.lottie.p012c;

import android.util.JsonReader;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.c.o */
public class IntegerParser implements ValueParser<Integer> {
    /* renamed from: a */
    public static final IntegerParser f1450a = new IntegerParser();

    private IntegerParser() {
    }

    /* renamed from: a */
    public Integer mo9904b(JsonReader jsonReader, float f) throws IOException {
        return Integer.valueOf(Math.round(JsonUtils.m1365b(jsonReader) * f));
    }
}
