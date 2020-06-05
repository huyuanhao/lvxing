package com.ksad.lottie.p302c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.ksad.lottie.C3703d;
import com.ksad.lottie.model.p305a.C3744b;
import com.ksad.lottie.model.p305a.C3747e;
import com.ksad.lottie.model.p305a.C3751i;
import com.ksad.lottie.model.p305a.C3755m;
import com.ksad.lottie.p303d.C3709f;
import com.ksad.lottie.p304e.C3717a;
import java.util.ArrayList;

/* renamed from: com.ksad.lottie.c.a */
public class C3666a {
    /* renamed from: a */
    public static C3747e m15254a(JsonReader jsonReader, C3703d dVar) {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(C3673ag.m15273a(jsonReader, dVar));
            }
            jsonReader.endArray();
            C3668ab.m15263a(arrayList);
        } else {
            arrayList.add(new C3717a(C3701z.m15326b(jsonReader, C3709f.m15387a())));
        }
        return new C3747e(arrayList);
    }

    /* renamed from: b */
    static C3755m<PointF, PointF> m15255b(JsonReader jsonReader, C3703d dVar) {
        jsonReader.beginObject();
        C3755m<PointF, PointF> mVar = null;
        C3744b bVar = null;
        C3744b bVar2 = null;
        boolean z = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 107) {
                if (hashCode != 120) {
                    if (hashCode == 121 && nextName.equals("y")) {
                        c = 2;
                    }
                } else if (nextName.equals("x")) {
                    c = 1;
                }
            } else if (nextName.equals("k")) {
                c = 0;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        jsonReader.skipValue();
                    } else if (jsonReader.peek() != JsonToken.STRING) {
                        bVar2 = C3689n.m15294a(jsonReader, dVar);
                    }
                } else if (jsonReader.peek() != JsonToken.STRING) {
                    bVar = C3689n.m15294a(jsonReader, dVar);
                }
                jsonReader.skipValue();
                z = true;
            } else {
                mVar = m15254a(jsonReader, dVar);
            }
        }
        jsonReader.endObject();
        if (z) {
            dVar.mo22876a("Lottie doesn't support expressions.");
        }
        return mVar != null ? mVar : new C3751i(bVar, bVar2);
    }
}
