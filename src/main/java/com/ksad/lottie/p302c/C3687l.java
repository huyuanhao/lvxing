package com.ksad.lottie.p302c;

import android.util.JsonReader;
import com.ksad.lottie.C3703d;
import com.ksad.lottie.model.p305a.C3743a;
import com.ksad.lottie.model.p305a.C3744b;
import com.ksad.lottie.model.p305a.C3753k;

/* renamed from: com.ksad.lottie.c.l */
public class C3687l {
    /* renamed from: a */
    public static C3753k m15291a(JsonReader jsonReader, C3703d dVar) {
        jsonReader.beginObject();
        C3753k kVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            if (nextName.hashCode() == 97 && nextName.equals("a")) {
                c = 0;
            }
            if (c != 0) {
                jsonReader.skipValue();
            } else {
                kVar = m15292b(jsonReader, dVar);
            }
        }
        jsonReader.endObject();
        return kVar == null ? new C3753k(null, null, null, null) : kVar;
    }

    /* renamed from: b */
    private static C3753k m15292b(JsonReader jsonReader, C3703d dVar) {
        jsonReader.beginObject();
        C3743a aVar = null;
        C3743a aVar2 = null;
        C3744b bVar = null;
        C3744b bVar2 = null;
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
                aVar = C3689n.m15304g(jsonReader, dVar);
            } else if (c == 1) {
                aVar2 = C3689n.m15304g(jsonReader, dVar);
            } else if (c == 2) {
                bVar = C3689n.m15294a(jsonReader, dVar);
            } else if (c != 3) {
                jsonReader.skipValue();
            } else {
                bVar2 = C3689n.m15294a(jsonReader, dVar);
            }
        }
        jsonReader.endObject();
        return new C3753k(aVar, aVar2, bVar, bVar2);
    }
}
