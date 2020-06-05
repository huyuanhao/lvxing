package com.airbnb.lottie.p012c;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.model.p015a.AnimatableFloatValue;
import com.airbnb.lottie.model.p015a.AnimatablePointValue;
import com.airbnb.lottie.model.p015a.AnimatableValue;
import com.p522qq.p523e.comm.constants.Constants;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.c.aa */
class RectangleShapeParser {
    /* renamed from: a */
    static RectangleShape m1319a(JsonReader jsonReader, LottieComposition dVar) throws IOException {
        String str = null;
        AnimatableValue mVar = null;
        AnimatablePointValue fVar = null;
        AnimatableFloatValue bVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 112) {
                if (hashCode != 3519) {
                    if (hashCode != 114) {
                        if (hashCode == 115 && nextName.equals("s")) {
                            c = 2;
                        }
                    } else if (nextName.equals("r")) {
                        c = 3;
                    }
                } else if (nextName.equals("nm")) {
                    c = 0;
                }
            } else if (nextName.equals(Constants.PORTRAIT)) {
                c = 1;
            }
            if (c == 0) {
                str = jsonReader.nextString();
            } else if (c == 1) {
                mVar = AnimatablePathValueParser.m1318b(jsonReader, dVar);
            } else if (c == 2) {
                fVar = AnimatableValueParser.m1340c(jsonReader, dVar);
            } else if (c != 3) {
                jsonReader.skipValue();
            } else {
                bVar = AnimatableValueParser.m1334a(jsonReader, dVar);
            }
        }
        return new RectangleShape(str, mVar, fVar, bVar);
    }
}
