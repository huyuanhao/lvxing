package com.airbnb.lottie.p012c;

import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.p014e.ScaleXY;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.c.ac */
public class ScaleXYParser implements ValueParser<ScaleXY> {
    /* renamed from: a */
    public static final ScaleXYParser f1444a = new ScaleXYParser();

    private ScaleXYParser() {
    }

    /* renamed from: a */
    public ScaleXY mo9904b(JsonReader jsonReader, float f) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z) {
            jsonReader.endArray();
        }
        return new ScaleXY((nextDouble / 100.0f) * f, (nextDouble2 / 100.0f) * f);
    }
}
