package com.ksad.lottie.p302c;

import android.util.JsonReader;
import com.ksad.lottie.model.C3758c;

/* renamed from: com.ksad.lottie.c.u */
class C3696u {
    /* renamed from: a */
    static C3758c m15314a(JsonReader jsonReader) {
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        float f = 0.0f;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1866931350:
                    if (nextName.equals("fFamily")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1408684838:
                    if (nextName.equals("ascent")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1294566165:
                    if (nextName.equals("fStyle")) {
                        c = 2;
                        break;
                    }
                    break;
                case 96619537:
                    if (nextName.equals("fName")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                str = jsonReader.nextString();
            } else if (c == 1) {
                str2 = jsonReader.nextString();
            } else if (c == 2) {
                str3 = jsonReader.nextString();
            } else if (c != 3) {
                jsonReader.skipValue();
            } else {
                f = (float) jsonReader.nextDouble();
            }
        }
        jsonReader.endObject();
        return new C3758c(str, str2, str3, f);
    }
}
