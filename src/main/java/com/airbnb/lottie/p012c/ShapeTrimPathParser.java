package com.airbnb.lottie.p012c;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.model.p015a.AnimatableFloatValue;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.c.ai */
class ShapeTrimPathParser {
    /* renamed from: a */
    static ShapeTrimPath m1329a(JsonReader jsonReader, LottieComposition dVar) throws IOException {
        String str = null;
        Type type = null;
        AnimatableFloatValue bVar = null;
        AnimatableFloatValue bVar2 = null;
        AnimatableFloatValue bVar3 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 101) {
                if (hashCode != 109) {
                    if (hashCode != 111) {
                        if (hashCode != 115) {
                            if (hashCode == 3519 && nextName.equals("nm")) {
                                c = 3;
                            }
                        } else if (nextName.equals("s")) {
                            c = 0;
                        }
                    } else if (nextName.equals("o")) {
                        c = 2;
                    }
                } else if (nextName.equals("m")) {
                    c = 4;
                }
            } else if (nextName.equals("e")) {
                c = 1;
            }
            if (c == 0) {
                bVar = AnimatableValueParser.m1335a(jsonReader, dVar, false);
            } else if (c == 1) {
                bVar2 = AnimatableValueParser.m1335a(jsonReader, dVar, false);
            } else if (c == 2) {
                bVar3 = AnimatableValueParser.m1335a(jsonReader, dVar, false);
            } else if (c == 3) {
                str = jsonReader.nextString();
            } else if (c != 4) {
                jsonReader.skipValue();
            } else {
                type = Type.forId(jsonReader.nextInt());
            }
        }
        ShapeTrimPath shapeTrimPath = new ShapeTrimPath(str, type, bVar, bVar2, bVar3);
        return shapeTrimPath;
    }
}
