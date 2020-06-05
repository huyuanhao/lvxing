package com.ksad.lottie.p302c;

import android.util.JsonReader;
import com.ksad.lottie.C3703d;
import com.ksad.lottie.model.content.C3765f;
import com.ksad.lottie.model.p305a.C3744b;
import com.ksad.lottie.model.p305a.C3748f;
import com.ksad.lottie.model.p305a.C3755m;
import com.p522qq.p523e.comm.constants.Constants;

/* renamed from: com.ksad.lottie.c.b */
class C3677b {
    /* renamed from: a */
    static C3765f m15279a(JsonReader jsonReader, C3703d dVar) {
        String str = null;
        C3755m mVar = null;
        C3748f fVar = null;
        C3744b bVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 112) {
                if (hashCode != 3519) {
                    if (hashCode != 114) {
                        if (hashCode == 115 && nextName.equals("s")) {
                            c = 2;
                        }
                    } else if (nextName.equals("r")) {
                        c = 3;
                    }
                } else if (nextName.equals("nm")) {
                    c = 0;
                }
            } else if (nextName.equals(Constants.PORTRAIT)) {
                c = 1;
            }
            if (c == 0) {
                str = jsonReader.nextString();
            } else if (c == 1) {
                mVar = C3666a.m15255b(jsonReader, dVar);
            } else if (c == 2) {
                fVar = C3689n.m15300c(jsonReader, dVar);
            } else if (c != 3) {
                jsonReader.skipValue();
            } else {
                bVar = C3689n.m15294a(jsonReader, dVar);
            }
        }
        return new C3765f(str, mVar, fVar, bVar);
    }
}
