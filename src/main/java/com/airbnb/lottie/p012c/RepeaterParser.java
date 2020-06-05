package com.airbnb.lottie.p012c;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.model.p015a.AnimatableFloatValue;
import com.airbnb.lottie.model.p015a.AnimatableTransform;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.c.ab */
class RepeaterParser {
    /* renamed from: a */
    static Repeater m1320a(JsonReader jsonReader, LottieComposition dVar) throws IOException {
        String str = null;
        AnimatableFloatValue bVar = null;
        AnimatableFloatValue bVar2 = null;
        AnimatableTransform lVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 99) {
                if (hashCode != 111) {
                    if (hashCode != 3519) {
                        if (hashCode == 3710 && nextName.equals("tr")) {
                            c = 3;
                        }
                    } else if (nextName.equals("nm")) {
                        c = 0;
                    }
                } else if (nextName.equals("o")) {
                    c = 2;
                }
            } else if (nextName.equals("c")) {
                c = 1;
            }
            if (c == 0) {
                str = jsonReader.nextString();
            } else if (c == 1) {
                bVar = AnimatableValueParser.m1335a(jsonReader, dVar, false);
            } else if (c == 2) {
                bVar2 = AnimatableValueParser.m1335a(jsonReader, dVar, false);
            } else if (c != 3) {
                jsonReader.skipValue();
            } else {
                lVar = AnimatableTransformParser.m1333a(jsonReader, dVar);
            }
        }
        return new Repeater(str, bVar, bVar2, lVar);
    }
}
