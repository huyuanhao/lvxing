package com.airbnb.lottie.p012c;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.model.p015a.AnimatableShapeValue;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.c.ag */
class ShapePathParser {
    /* renamed from: a */
    static ShapePath m1327a(JsonReader jsonReader, LottieComposition dVar) throws IOException {
        String str = null;
        AnimatableShapeValue hVar = null;
        int i = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 3432) {
                if (hashCode != 3519) {
                    if (hashCode == 104415 && nextName.equals("ind")) {
                        c = 1;
                    }
                } else if (nextName.equals("nm")) {
                    c = 0;
                }
            } else if (nextName.equals("ks")) {
                c = 2;
            }
            if (c == 0) {
                str = jsonReader.nextString();
            } else if (c == 1) {
                i = jsonReader.nextInt();
            } else if (c != 2) {
                jsonReader.skipValue();
            } else {
                hVar = AnimatableValueParser.m1342e(jsonReader, dVar);
            }
        }
        return new ShapePath(str, i, hVar);
    }
}
