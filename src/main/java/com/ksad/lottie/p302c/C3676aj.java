package com.ksad.lottie.p302c;

import android.util.JsonReader;
import com.ksad.lottie.C3703d;
import com.ksad.lottie.model.content.PolystarShape;
import com.ksad.lottie.model.content.PolystarShape.Type;
import com.ksad.lottie.model.p305a.C3744b;
import com.ksad.lottie.model.p305a.C3755m;
import com.p522qq.p523e.comm.constants.Constants;

/* renamed from: com.ksad.lottie.c.aj */
class C3676aj {
    /* renamed from: a */
    static PolystarShape m15278a(JsonReader jsonReader, C3703d dVar) {
        String str = null;
        Type type = null;
        C3744b bVar = null;
        C3755m mVar = null;
        C3744b bVar2 = null;
        C3744b bVar3 = null;
        C3744b bVar4 = null;
        C3744b bVar5 = null;
        C3744b bVar6 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 112) {
                if (hashCode != 114) {
                    if (hashCode != 3519) {
                        if (hashCode != 3588) {
                            if (hashCode != 3686) {
                                if (hashCode != 3369) {
                                    if (hashCode != 3370) {
                                        if (hashCode != 3555) {
                                            if (hashCode == 3556 && nextName.equals("os")) {
                                                c = 6;
                                            }
                                        } else if (nextName.equals("or")) {
                                            c = 5;
                                        }
                                    } else if (nextName.equals("is")) {
                                        c = 8;
                                    }
                                } else if (nextName.equals("ir")) {
                                    c = 7;
                                }
                            } else if (nextName.equals("sy")) {
                                c = 1;
                            }
                        } else if (nextName.equals("pt")) {
                            c = 2;
                        }
                    } else if (nextName.equals("nm")) {
                        c = 0;
                    }
                } else if (nextName.equals("r")) {
                    c = 4;
                }
            } else if (nextName.equals(Constants.PORTRAIT)) {
                c = 3;
            }
            switch (c) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    type = Type.forValue(jsonReader.nextInt());
                    break;
                case 2:
                    bVar = C3689n.m15295a(jsonReader, dVar, false);
                    break;
                case 3:
                    mVar = C3666a.m15255b(jsonReader, dVar);
                    break;
                case 4:
                    bVar2 = C3689n.m15295a(jsonReader, dVar, false);
                    break;
                case 5:
                    bVar4 = C3689n.m15294a(jsonReader, dVar);
                    break;
                case 6:
                    bVar6 = C3689n.m15295a(jsonReader, dVar, false);
                    break;
                case 7:
                    bVar3 = C3689n.m15294a(jsonReader, dVar);
                    break;
                case 8:
                    bVar5 = C3689n.m15295a(jsonReader, dVar, false);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        PolystarShape polystarShape = new PolystarShape(str, type, bVar, mVar, bVar2, bVar3, bVar4, bVar5, bVar6);
        return polystarShape;
    }
}
