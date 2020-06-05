package com.airbnb.lottie.p012c;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.model.p015a.AnimatablePointValue;
import com.airbnb.lottie.model.p015a.AnimatableValue;
import com.p522qq.p523e.comm.constants.Constants;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.c.e */
class CircleShapeParser {
    /* renamed from: a */
    static CircleShape m1345a(JsonReader jsonReader, LottieComposition dVar, int i) throws IOException {
        String str = null;
        boolean z = i == 3;
        AnimatableValue mVar = null;
        AnimatablePointValue fVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 100) {
                if (hashCode != 112) {
                    if (hashCode != 115) {
                        if (hashCode == 3519 && nextName.equals("nm")) {
                            c = 0;
                        }
                    } else if (nextName.equals("s")) {
                        c = 2;
                    }
                } else if (nextName.equals(Constants.PORTRAIT)) {
                    c = 1;
                }
            } else if (nextName.equals("d")) {
                c = 3;
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
                z = jsonReader.nextInt() == 3;
            }
        }
        return new CircleShape(str, mVar, fVar, z);
    }
}
