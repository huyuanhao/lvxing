package com.airbnb.lottie.p012c;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.p015a.AnimatableColorValue;
import com.airbnb.lottie.model.p015a.AnimatableFloatValue;
import com.airbnb.lottie.model.p015a.AnimatableGradientColorValue;
import com.airbnb.lottie.model.p015a.AnimatableIntegerValue;
import com.airbnb.lottie.model.p015a.AnimatablePointValue;
import com.airbnb.lottie.model.p015a.AnimatableScaleValue;
import com.airbnb.lottie.model.p015a.AnimatableShapeValue;
import com.airbnb.lottie.model.p015a.AnimatableTextFrame;
import com.airbnb.lottie.p013d.Utils;
import com.airbnb.lottie.p014e.Keyframe;
import java.io.IOException;
import java.util.List;

/* renamed from: com.airbnb.lottie.c.d */
public class AnimatableValueParser {
    /* renamed from: a */
    public static AnimatableFloatValue m1334a(JsonReader jsonReader, LottieComposition dVar) throws IOException {
        return m1335a(jsonReader, dVar, true);
    }

    /* renamed from: a */
    public static AnimatableFloatValue m1335a(JsonReader jsonReader, LottieComposition dVar, boolean z) throws IOException {
        return new AnimatableFloatValue(m1337a(jsonReader, z ? Utils.m1451a() : 1.0f, dVar, FloatParser.f1448a));
    }

    /* renamed from: b */
    static AnimatableIntegerValue m1339b(JsonReader jsonReader, LottieComposition dVar) throws IOException {
        return new AnimatableIntegerValue(m1338a(jsonReader, dVar, (ValueParser<T>) IntegerParser.f1450a));
    }

    /* renamed from: c */
    static AnimatablePointValue m1340c(JsonReader jsonReader, LottieComposition dVar) throws IOException {
        return new AnimatablePointValue(m1337a(jsonReader, Utils.m1451a(), dVar, PointFParser.f1455a));
    }

    /* renamed from: d */
    static AnimatableScaleValue m1341d(JsonReader jsonReader, LottieComposition dVar) throws IOException {
        return new AnimatableScaleValue(m1338a(jsonReader, dVar, (ValueParser<T>) ScaleXYParser.f1444a));
    }

    /* renamed from: e */
    static AnimatableShapeValue m1342e(JsonReader jsonReader, LottieComposition dVar) throws IOException {
        return new AnimatableShapeValue(m1337a(jsonReader, Utils.m1451a(), dVar, ShapeDataParser.f1445a));
    }

    /* renamed from: f */
    static AnimatableTextFrame m1343f(JsonReader jsonReader, LottieComposition dVar) throws IOException {
        return new AnimatableTextFrame(m1338a(jsonReader, dVar, (ValueParser<T>) DocumentDataParser.f1447a));
    }

    /* renamed from: g */
    static AnimatableColorValue m1344g(JsonReader jsonReader, LottieComposition dVar) throws IOException {
        return new AnimatableColorValue(m1338a(jsonReader, dVar, (ValueParser<T>) ColorParser.f1446a));
    }

    /* renamed from: a */
    static AnimatableGradientColorValue m1336a(JsonReader jsonReader, LottieComposition dVar, int i) throws IOException {
        return new AnimatableGradientColorValue(m1338a(jsonReader, dVar, (ValueParser<T>) new GradientColorParser<T>(i)));
    }

    /* renamed from: a */
    private static <T> List<Keyframe<T>> m1338a(JsonReader jsonReader, LottieComposition dVar, ValueParser<T> ajVar) throws IOException {
        return KeyframesParser.m1376a(jsonReader, dVar, 1.0f, ajVar);
    }

    /* renamed from: a */
    private static <T> List<Keyframe<T>> m1337a(JsonReader jsonReader, float f, LottieComposition dVar, ValueParser<T> ajVar) throws IOException {
        return KeyframesParser.m1376a(jsonReader, dVar, f, ajVar);
    }
}
