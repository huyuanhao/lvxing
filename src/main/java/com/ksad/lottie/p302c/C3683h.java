package com.ksad.lottie.p302c;

import android.util.JsonReader;
import com.ksad.lottie.C3703d;
import com.ksad.lottie.model.content.C3770k;
import com.ksad.lottie.model.p305a.C3750h;

/* renamed from: com.ksad.lottie.c.h */
class C3683h {
    /* renamed from: a */
    static C3770k m15287a(JsonReader jsonReader, C3703d dVar) {
        String str = null;
        C3750h hVar = null;
        int i = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 3432) {
                if (hashCode != 3519) {
                    if (hashCode == 104415 && nextName.equals("ind")) {
                        c = 1;
                    }
                } else if (nextName.equals("nm")) {
                    c = 0;
                }
            } else if (nextName.equals("ks")) {
                c = 2;
            }
            if (c == 0) {
                str = jsonReader.nextString();
            } else if (c == 1) {
                i = jsonReader.nextInt();
            } else if (c != 2) {
                jsonReader.skipValue();
            } else {
                hVar = C3689n.m15302e(jsonReader, dVar);
            }
        }
        return new C3770k(str, i, hVar);
    }
}
