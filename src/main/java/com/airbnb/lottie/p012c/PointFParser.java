package com.airbnb.lottie.p012c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.c.y */
public class PointFParser implements ValueParser<PointF> {
    /* renamed from: a */
    public static final PointFParser f1455a = new PointFParser();

    private PointFParser() {
    }

    /* renamed from: a */
    public PointF mo9904b(JsonReader jsonReader, float f) throws IOException {
        JsonToken peek = jsonReader.peek();
        if (peek == JsonToken.BEGIN_ARRAY) {
            return JsonUtils.m1366b(jsonReader, f);
        }
        if (peek == JsonToken.BEGIN_OBJECT) {
            return JsonUtils.m1366b(jsonReader, f);
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
