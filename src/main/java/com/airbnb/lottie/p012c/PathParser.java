package com.airbnb.lottie.p012c;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.c.x */
public class PathParser implements ValueParser<PointF> {
    /* renamed from: a */
    public static final PathParser f1454a = new PathParser();

    private PathParser() {
    }

    /* renamed from: a */
    public PointF mo9904b(JsonReader jsonReader, float f) throws IOException {
        return JsonUtils.m1366b(jsonReader, f);
    }
}
