package com.ksad.lottie.p302c;

import android.graphics.Path.FillType;
import android.util.JsonReader;
import com.ksad.lottie.C3703d;
import com.ksad.lottie.model.content.C3768i;
import com.ksad.lottie.model.p305a.C3743a;
import com.ksad.lottie.model.p305a.C3746d;

/* renamed from: com.ksad.lottie.c.f */
class C3681f {
    /* renamed from: a */
    static C3768i m15285a(JsonReader jsonReader, C3703d dVar) {
        String str = null;
        C3743a aVar = null;
        C3746d dVar2 = null;
        int i = 1;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -396065730) {
                if (hashCode != 99) {
                    if (hashCode != 111) {
                        if (hashCode != 114) {
                            if (hashCode == 3519 && nextName.equals("nm")) {
                                c = 0;
                            }
                        } else if (nextName.equals("r")) {
                            c = 4;
                        }
                    } else if (nextName.equals("o")) {
                        c = 2;
                    }
                } else if (nextName.equals("c")) {
                    c = 1;
                }
            } else if (nextName.equals("fillEnabled")) {
                c = 3;
            }
            if (c == 0) {
                str = jsonReader.nextString();
            } else if (c == 1) {
                aVar = C3689n.m15304g(jsonReader, dVar);
            } else if (c == 2) {
                dVar2 = C3689n.m15299b(jsonReader, dVar);
            } else if (c == 3) {
                z = jsonReader.nextBoolean();
            } else if (c != 4) {
                jsonReader.skipValue();
            } else {
                i = jsonReader.nextInt();
            }
        }
        C3768i iVar = new C3768i(str, z, i == 1 ? FillType.WINDING : FillType.EVEN_ODD, aVar, dVar2);
        return iVar;
    }
}
