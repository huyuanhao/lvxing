package com.ksad.lottie.p302c;

import android.util.JsonReader;
import android.util.JsonToken;
import com.ksad.lottie.p304e.C3720d;

/* renamed from: com.ksad.lottie.c.d */
public class C3679d implements C3686k<C3720d> {
    /* renamed from: a */
    public static final C3679d f12580a = new C3679d();

    private C3679d() {
    }

    /* renamed from: a */
    public C3720d mo22864b(JsonReader jsonReader, float f) {
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
        return new C3720d((nextDouble / 100.0f) * f, (nextDouble2 / 100.0f) * f);
    }
}
