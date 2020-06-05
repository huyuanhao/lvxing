package com.ksad.lottie.p302c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.ksad.lottie.model.C3742a;
import com.ksad.lottie.model.content.C3767h;
import com.ksad.lottie.p303d.C3708e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.ksad.lottie.c.e */
public class C3680e implements C3686k<C3767h> {
    /* renamed from: a */
    public static final C3680e f12581a = new C3680e();

    private C3680e() {
    }

    /* renamed from: a */
    public C3767h mo22864b(JsonReader jsonReader, float f) {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List list = null;
        List list2 = null;
        List list3 = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 99) {
                if (hashCode != 105) {
                    if (hashCode != 111) {
                        if (hashCode == 118 && nextName.equals("v")) {
                            c = 1;
                        }
                    } else if (nextName.equals("o")) {
                        c = 3;
                    }
                } else if (nextName.equals("i")) {
                    c = 2;
                }
            } else if (nextName.equals("c")) {
                c = 0;
            }
            if (c == 0) {
                z = jsonReader.nextBoolean();
            } else if (c == 1) {
                list = C3701z.m15324a(jsonReader, f);
            } else if (c == 2) {
                list2 = C3701z.m15324a(jsonReader, f);
            } else if (c == 3) {
                list3 = C3701z.m15324a(jsonReader, f);
            }
        }
        jsonReader.endObject();
        if (jsonReader.peek() == JsonToken.END_ARRAY) {
            jsonReader.endArray();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        } else if (list.isEmpty()) {
            return new C3767h(new PointF(), false, Collections.emptyList());
        } else {
            int size = list.size();
            PointF pointF = (PointF) list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i = 1; i < size; i++) {
                PointF pointF2 = (PointF) list.get(i);
                int i2 = i - 1;
                arrayList.add(new C3742a(C3708e.m15382a((PointF) list.get(i2), (PointF) list3.get(i2)), C3708e.m15382a(pointF2, (PointF) list2.get(i)), pointF2));
            }
            if (z) {
                PointF pointF3 = (PointF) list.get(0);
                int i3 = size - 1;
                arrayList.add(new C3742a(C3708e.m15382a((PointF) list.get(i3), (PointF) list3.get(i3)), C3708e.m15382a(pointF3, (PointF) list2.get(0)), pointF3));
            }
            return new C3767h(pointF, z, arrayList);
        }
    }
}
