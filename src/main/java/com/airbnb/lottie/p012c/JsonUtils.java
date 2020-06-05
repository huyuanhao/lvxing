package com.airbnb.lottie.p012c;

import android.graphics.Color;
import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.airbnb.lottie.c.p */
class JsonUtils {

    /* compiled from: JsonUtils */
    /* renamed from: com.airbnb.lottie.c.p$1 */
    static /* synthetic */ class C09261 {
        /* renamed from: a */
        static final /* synthetic */ int[] f1451a = new int[JsonToken.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
            android.util.JsonToken[] r0 = android.util.JsonToken.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f1451a = r0
            int[] r0 = f1451a     // Catch:{ NoSuchFieldError -> 0x0014 }
            android.util.JsonToken r1 = android.util.JsonToken.NUMBER     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f1451a     // Catch:{ NoSuchFieldError -> 0x001f }
            android.util.JsonToken r1 = android.util.JsonToken.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f1451a     // Catch:{ NoSuchFieldError -> 0x002a }
            android.util.JsonToken r1 = android.util.JsonToken.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p012c.JsonUtils.C09261.m40949clinit():void");
        }
    }

    /* renamed from: a */
    static int m1363a(JsonReader jsonReader) throws IOException {
        jsonReader.beginArray();
        int nextDouble = (int) (jsonReader.nextDouble() * 255.0d);
        int nextDouble2 = (int) (jsonReader.nextDouble() * 255.0d);
        int nextDouble3 = (int) (jsonReader.nextDouble() * 255.0d);
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return Color.argb(255, nextDouble, nextDouble2, nextDouble3);
    }

    /* renamed from: a */
    static List<PointF> m1364a(JsonReader jsonReader, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            arrayList.add(m1366b(jsonReader, f));
            jsonReader.endArray();
        }
        jsonReader.endArray();
        return arrayList;
    }

    /* renamed from: b */
    static PointF m1366b(JsonReader jsonReader, float f) throws IOException {
        int i = C09261.f1451a[jsonReader.peek().ordinal()];
        if (i == 1) {
            return m1367c(jsonReader, f);
        }
        if (i == 2) {
            return m1368d(jsonReader, f);
        }
        if (i == 3) {
            return m1369e(jsonReader, f);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown point starts with ");
        sb.append(jsonReader.peek());
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: c */
    private static PointF m1367c(JsonReader jsonReader, float f) throws IOException {
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        return new PointF(nextDouble * f, nextDouble2 * f);
    }

    /* renamed from: d */
    private static PointF m1368d(JsonReader jsonReader, float f) throws IOException {
        jsonReader.beginArray();
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.peek() != JsonToken.END_ARRAY) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return new PointF(nextDouble * f, nextDouble2 * f);
    }

    /* renamed from: e */
    private static PointF m1369e(JsonReader jsonReader, float f) throws IOException {
        jsonReader.beginObject();
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 120) {
                if (hashCode == 121 && nextName.equals("y")) {
                    c = 1;
                }
            } else if (nextName.equals("x")) {
                c = 0;
            }
            if (c == 0) {
                f2 = m1365b(jsonReader);
            } else if (c != 1) {
                jsonReader.skipValue();
            } else {
                f3 = m1365b(jsonReader);
            }
        }
        jsonReader.endObject();
        return new PointF(f2 * f, f3 * f);
    }

    /* renamed from: b */
    static float m1365b(JsonReader jsonReader) throws IOException {
        JsonToken peek = jsonReader.peek();
        int i = C09261.f1451a[peek.ordinal()];
        if (i == 1) {
            return (float) jsonReader.nextDouble();
        }
        if (i == 2) {
            jsonReader.beginArray();
            float nextDouble = (float) jsonReader.nextDouble();
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            jsonReader.endArray();
            return nextDouble;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown value for token of type ");
        sb.append(peek);
        throw new IllegalArgumentException(sb.toString());
    }
}
