package com.ksad.lottie.p302c;

import android.util.JsonReader;
import com.ksad.lottie.C3703d;
import com.ksad.lottie.model.content.C3761b;
import com.ksad.lottie.model.content.C3769j;
import java.util.ArrayList;

/* renamed from: com.ksad.lottie.c.g */
class C3682g {
    /* renamed from: a */
    static C3769j m15286a(JsonReader jsonReader, C3703d dVar) {
        ArrayList arrayList = new ArrayList();
        String str = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 3371) {
                if (hashCode == 3519 && nextName.equals("nm")) {
                    c = 0;
                }
            } else if (nextName.equals("it")) {
                c = 1;
            }
            if (c == 0) {
                str = jsonReader.nextString();
            } else if (c != 1) {
                jsonReader.skipValue();
            } else {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    C3761b a = C3692q.m15308a(jsonReader, dVar);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                jsonReader.endArray();
            }
        }
        return new C3769j(str, arrayList);
    }
}
