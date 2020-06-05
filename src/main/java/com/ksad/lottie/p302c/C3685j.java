package com.ksad.lottie.p302c;

import android.util.JsonReader;
import com.ksad.lottie.C3703d;
import com.ksad.lottie.model.content.ShapeTrimPath;
import com.ksad.lottie.model.content.ShapeTrimPath.Type;
import com.ksad.lottie.model.p305a.C3744b;

/* renamed from: com.ksad.lottie.c.j */
class C3685j {
    /* renamed from: a */
    static ShapeTrimPath m15289a(JsonReader jsonReader, C3703d dVar) {
        String str = null;
        Type type = null;
        C3744b bVar = null;
        C3744b bVar2 = null;
        C3744b bVar3 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 101) {
                if (hashCode != 109) {
                    if (hashCode != 111) {
                        if (hashCode != 115) {
                            if (hashCode == 3519 && nextName.equals("nm")) {
                                c = 3;
                            }
                        } else if (nextName.equals("s")) {
                            c = 0;
                        }
                    } else if (nextName.equals("o")) {
                        c = 2;
                    }
                } else if (nextName.equals("m")) {
                    c = 4;
                }
            } else if (nextName.equals("e")) {
                c = 1;
            }
            if (c == 0) {
                bVar = C3689n.m15295a(jsonReader, dVar, false);
            } else if (c == 1) {
                bVar2 = C3689n.m15295a(jsonReader, dVar, false);
            } else if (c == 2) {
                bVar3 = C3689n.m15295a(jsonReader, dVar, false);
            } else if (c == 3) {
                str = jsonReader.nextString();
            } else if (c != 4) {
                jsonReader.skipValue();
            } else {
                type = Type.forId(jsonReader.nextInt());
            }
        }
        ShapeTrimPath shapeTrimPath = new ShapeTrimPath(str, type, bVar, bVar2, bVar3);
        return shapeTrimPath;
    }
}
