package com.airbnb.lottie.p012c;

import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.p008a.p010b.PathKeyframe;
import com.airbnb.lottie.p013d.Utils;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.c.w */
class PathKeyframeParser {
    /* renamed from: a */
    static PathKeyframe m1387a(JsonReader jsonReader, LottieComposition dVar) throws IOException {
        return new PathKeyframe(dVar, KeyframeParser.m1372a(jsonReader, dVar, Utils.m1451a(), PathParser.f1454a, jsonReader.peek() == JsonToken.BEGIN_OBJECT));
    }
}
