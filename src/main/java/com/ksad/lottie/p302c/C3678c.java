package com.ksad.lottie.p302c;

import android.util.JsonReader;
import com.ksad.lottie.C3703d;
import com.ksad.lottie.model.content.C3766g;
import com.ksad.lottie.model.p305a.C3744b;
import com.ksad.lottie.model.p305a.C3754l;

/* renamed from: com.ksad.lottie.c.c */
class C3678c {
    /* renamed from: a */
    static C3766g m15280a(JsonReader jsonReader, C3703d dVar) {
        String str = null;
        C3744b bVar = null;
        C3744b bVar2 = null;
        C3754l lVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 99) {
                if (hashCode != 111) {
                    if (hashCode != 3519) {
                        if (hashCode == 3710 && nextName.equals("tr")) {
                            c = 3;
                        }
                    } else if (nextName.equals("nm")) {
                        c = 0;
                    }
                } else if (nextName.equals("o")) {
                    c = 2;
                }
            } else if (nextName.equals("c")) {
                c = 1;
            }
            if (c == 0) {
                str = jsonReader.nextString();
            } else if (c == 1) {
                bVar = C3689n.m15295a(jsonReader, dVar, false);
            } else if (c == 2) {
                bVar2 = C3689n.m15295a(jsonReader, dVar, false);
            } else if (c != 3) {
                jsonReader.skipValue();
            } else {
                lVar = C3688m.m15293a(jsonReader, dVar);
            }
        }
        return new C3766g(str, bVar, bVar2, lVar);
    }
}
