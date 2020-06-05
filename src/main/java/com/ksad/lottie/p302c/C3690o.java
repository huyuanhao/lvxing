package com.ksad.lottie.p302c;

import android.util.JsonReader;
import com.ksad.lottie.C3703d;
import com.ksad.lottie.model.content.C3760a;
import com.ksad.lottie.model.p305a.C3748f;
import com.ksad.lottie.model.p305a.C3755m;
import com.p522qq.p523e.comm.constants.Constants;

/* renamed from: com.ksad.lottie.c.o */
class C3690o {
    /* renamed from: a */
    static C3760a m15305a(JsonReader jsonReader, C3703d dVar, int i) {
        String str = null;
        boolean z = i == 3;
        C3755m mVar = null;
        C3748f fVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 100) {
                if (hashCode != 112) {
                    if (hashCode != 115) {
                        if (hashCode == 3519 && nextName.equals("nm")) {
                            c = 0;
                        }
                    } else if (nextName.equals("s")) {
                        c = 2;
                    }
                } else if (nextName.equals(Constants.PORTRAIT)) {
                    c = 1;
                }
            } else if (nextName.equals("d")) {
                c = 3;
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
                z = jsonReader.nextInt() == 3;
            }
        }
        return new C3760a(str, mVar, fVar, z);
    }
}
