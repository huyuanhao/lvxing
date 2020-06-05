package com.airbnb.lottie.p012c;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.p015a.AnimatableColorValue;
import com.airbnb.lottie.model.p015a.AnimatableFloatValue;
import com.airbnb.lottie.model.p015a.AnimatableTextProperties;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.c.b */
public class AnimatableTextPropertiesParser {
    /* renamed from: a */
    public static AnimatableTextProperties m1331a(JsonReader jsonReader, LottieComposition dVar) throws IOException {
        jsonReader.beginObject();
        AnimatableTextProperties kVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            if (nextName.hashCode() == 97 && nextName.equals("a")) {
                c = 0;
            }
            if (c != 0) {
                jsonReader.skipValue();
            } else {
                kVar = m1332b(jsonReader, dVar);
            }
        }
        jsonReader.endObject();
        return kVar == null ? new AnimatableTextProperties(null, null, null, null) : kVar;
    }

    /* renamed from: b */
    private static AnimatableTextProperties m1332b(JsonReader jsonReader, LottieComposition dVar) throws IOException {
        jsonReader.beginObject();
        AnimatableColorValue aVar = null;
        AnimatableColorValue aVar2 = null;
        AnimatableFloatValue bVar = null;
        AnimatableFloatValue bVar2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 116) {
                if (hashCode != 3261) {
                    if (hashCode != 3664) {
                        if (hashCode == 3684 && nextName.equals("sw")) {
                            c = 2;
                        }
                    } else if (nextName.equals("sc")) {
                        c = 1;
                    }
                } else if (nextName.equals("fc")) {
                    c = 0;
                }
            } else if (nextName.equals("t")) {
                c = 3;
            }
            if (c == 0) {
                aVar = AnimatableValueParser.m1344g(jsonReader, dVar);
            } else if (c == 1) {
                aVar2 = AnimatableValueParser.m1344g(jsonReader, dVar);
            } else if (c == 2) {
                bVar = AnimatableValueParser.m1334a(jsonReader, dVar);
            } else if (c != 3) {
                jsonReader.skipValue();
            } else {
                bVar2 = AnimatableValueParser.m1334a(jsonReader, dVar);
            }
        }
        jsonReader.endObject();
        return new AnimatableTextProperties(aVar, aVar2, bVar, bVar2);
    }
}
