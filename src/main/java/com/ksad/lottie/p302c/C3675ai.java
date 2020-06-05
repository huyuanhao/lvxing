package com.ksad.lottie.p302c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;

/* renamed from: com.ksad.lottie.c.ai */
public class C3675ai implements C3686k<PointF> {
    /* renamed from: a */
    public static final C3675ai f12579a = new C3675ai();

    private C3675ai() {
    }

    /* renamed from: a */
    public PointF mo22864b(JsonReader jsonReader, float f) {
        JsonToken peek = jsonReader.peek();
        if (peek == JsonToken.BEGIN_ARRAY) {
            return C3701z.m15326b(jsonReader, f);
        }
        if (peek == JsonToken.BEGIN_OBJECT) {
            return C3701z.m15326b(jsonReader, f);
        }
        if (peek == JsonToken.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.nextDouble()) * f, ((float) jsonReader.nextDouble()) * f);
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            return pointF;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot convert json to point. Next token is ");
        sb.append(peek);
        throw new IllegalArgumentException(sb.toString());
    }
}
