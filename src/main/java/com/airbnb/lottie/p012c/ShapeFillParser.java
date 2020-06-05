package com.airbnb.lottie.p012c;

import android.graphics.Path.FillType;
import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.model.p015a.AnimatableColorValue;
import com.airbnb.lottie.model.p015a.AnimatableIntegerValue;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.c.ae */
class ShapeFillParser {
    /* renamed from: a */
    static ShapeFill m1325a(JsonReader jsonReader, LottieComposition dVar) throws IOException {
        String str = null;
        AnimatableColorValue aVar = null;
        AnimatableIntegerValue dVar2 = null;
        int i = 1;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -396065730) {
                if (hashCode != 99) {
                    if (hashCode != 111) {
                        if (hashCode != 114) {
                            if (hashCode == 3519 && nextName.equals("nm")) {
                                c = 0;
                            }
                        } else if (nextName.equals("r")) {
                            c = 4;
                        }
                    } else if (nextName.equals("o")) {
                        c = 2;
                    }
                } else if (nextName.equals("c")) {
                    c = 1;
                }
            } else if (nextName.equals("fillEnabled")) {
                c = 3;
            }
            if (c == 0) {
                str = jsonReader.nextString();
            } else if (c == 1) {
                aVar = AnimatableValueParser.m1344g(jsonReader, dVar);
            } else if (c == 2) {
                dVar2 = AnimatableValueParser.m1339b(jsonReader, dVar);
            } else if (c == 3) {
                z = jsonReader.nextBoolean();
            } else if (c != 4) {
                jsonReader.skipValue();
            } else {
                i = jsonReader.nextInt();
            }
        }
        ShapeFill iVar = new ShapeFill(str, z, i == 1 ? FillType.WINDING : FillType.EVEN_ODD, aVar, dVar2);
        return iVar;
    }
}
