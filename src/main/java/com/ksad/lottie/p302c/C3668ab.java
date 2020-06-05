package com.ksad.lottie.p302c;

import android.util.JsonReader;
import android.util.JsonToken;
import com.ksad.lottie.C3703d;
import com.ksad.lottie.p304e.C3717a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.ksad.lottie.c.ab */
class C3668ab {
    /* renamed from: a */
    static <T> List<C3717a<T>> m15262a(JsonReader jsonReader, C3703d dVar, float f, C3686k<T> kVar) {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            dVar.mo22876a("Lottie doesn't support expressions.");
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
                    arrayList.add(C3667aa.m15258a(jsonReader, dVar, f, kVar, false));
                } else {
                    while (jsonReader.hasNext()) {
                        arrayList.add(C3667aa.m15258a(jsonReader, dVar, f, kVar, true));
                    }
                }
                jsonReader.endArray();
            } else {
                arrayList.add(C3667aa.m15258a(jsonReader, dVar, f, kVar, false));
            }
        }
        jsonReader.endObject();
        m15263a(arrayList);
        return arrayList;
    }

    /* renamed from: a */
    public static void m15263a(List<? extends C3717a<?>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            C3717a aVar = (C3717a) list.get(i2);
            i2++;
            aVar.f12633e = Float.valueOf(((C3717a) list.get(i2)).f12632d);
        }
        C3717a aVar2 = (C3717a) list.get(i);
        if (aVar2.f12629a == null) {
            list.remove(aVar2);
        }
    }
}
