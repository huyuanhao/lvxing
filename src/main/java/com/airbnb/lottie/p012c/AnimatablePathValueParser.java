package com.airbnb.lottie.p012c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.p015a.AnimatableFloatValue;
import com.airbnb.lottie.model.p015a.AnimatablePathValue;
import com.airbnb.lottie.model.p015a.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.p015a.AnimatableValue;
import com.airbnb.lottie.p013d.Utils;
import com.airbnb.lottie.p014e.Keyframe;
import java.io.IOException;
import java.util.ArrayList;

/* renamed from: com.airbnb.lottie.c.a */
public class AnimatablePathValueParser {
    /* renamed from: a */
    public static AnimatablePathValue m1317a(JsonReader jsonReader, LottieComposition dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(PathKeyframeParser.m1387a(jsonReader, dVar));
            }
            jsonReader.endArray();
            KeyframesParser.m1377a(arrayList);
        } else {
            arrayList.add(new Keyframe(JsonUtils.m1366b(jsonReader, Utils.m1451a())));
        }
        return new AnimatablePathValue(arrayList);
    }

    /* renamed from: b */
    static AnimatableValue<PointF, PointF> m1318b(JsonReader jsonReader, LottieComposition dVar) throws IOException {
        jsonReader.beginObject();
        AnimatableValue<PointF, PointF> mVar = null;
        AnimatableFloatValue bVar = null;
        AnimatableFloatValue bVar2 = null;
        boolean z = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 107) {
                if (hashCode != 120) {
                    if (hashCode == 121 && nextName.equals("y")) {
                        c = 2;
                    }
                } else if (nextName.equals("x")) {
                    c = 1;
                }
            } else if (nextName.equals("k")) {
                c = 0;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        jsonReader.skipValue();
                    } else if (jsonReader.peek() == JsonToken.STRING) {
                        jsonReader.skipValue();
                    } else {
                        bVar2 = AnimatableValueParser.m1334a(jsonReader, dVar);
                    }
                } else if (jsonReader.peek() == JsonToken.STRING) {
                    jsonReader.skipValue();
                } else {
                    bVar = AnimatableValueParser.m1334a(jsonReader, dVar);
                }
                z = true;
            } else {
                mVar = m1317a(jsonReader, dVar);
            }
        }
        jsonReader.endObject();
        if (z) {
            dVar.mo9916a("Lottie doesn't support expressions.");
        }
        if (mVar != null) {
            return mVar;
        }
        return new AnimatableSplitDimensionPathValue(bVar, bVar2);
    }
}
