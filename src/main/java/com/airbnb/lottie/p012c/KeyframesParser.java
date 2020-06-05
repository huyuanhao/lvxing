package com.airbnb.lottie.p012c;

import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.p014e.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.airbnb.lottie.c.r */
class KeyframesParser {
    /* renamed from: a */
    static <T> List<Keyframe<T>> m1376a(JsonReader jsonReader, LottieComposition dVar, float f, ValueParser<T> ajVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            dVar.mo9916a("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            if (nextName.hashCode() == 107 && nextName.equals("k")) {
                c = 0;
            }
            if (c != 0) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonToken.NUMBER) {
                    arrayList.add(KeyframeParser.m1372a(jsonReader, dVar, f, ajVar, false));
                } else {
                    while (jsonReader.hasNext()) {
                        arrayList.add(KeyframeParser.m1372a(jsonReader, dVar, f, ajVar, true));
                    }
                }
                jsonReader.endArray();
            } else {
                arrayList.add(KeyframeParser.m1372a(jsonReader, dVar, f, ajVar, false));
            }
        }
        jsonReader.endObject();
        m1377a(arrayList);
        return arrayList;
    }

    /* renamed from: a */
    public static void m1377a(List<? extends Keyframe<?>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            Keyframe aVar = (Keyframe) list.get(i2);
            i2++;
            aVar.f1500e = Float.valueOf(((Keyframe) list.get(i2)).f1499d);
        }
        Keyframe aVar2 = (Keyframe) list.get(i);
        if (aVar2.f1496a == null) {
            list.remove(aVar2);
        }
    }
}
