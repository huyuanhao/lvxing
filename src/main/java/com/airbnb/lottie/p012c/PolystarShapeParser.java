package com.airbnb.lottie.p012c;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.PolystarShape.Type;
import com.airbnb.lottie.model.p015a.AnimatableFloatValue;
import com.airbnb.lottie.model.p015a.AnimatableValue;
import com.p522qq.p523e.comm.constants.Constants;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.c.z */
class PolystarShapeParser {
    /* renamed from: a */
    static PolystarShape m1392a(JsonReader jsonReader, LottieComposition dVar) throws IOException {
        String str = null;
        Type type = null;
        AnimatableFloatValue bVar = null;
        AnimatableValue mVar = null;
        AnimatableFloatValue bVar2 = null;
        AnimatableFloatValue bVar3 = null;
        AnimatableFloatValue bVar4 = null;
        AnimatableFloatValue bVar5 = null;
        AnimatableFloatValue bVar6 = null;
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
                    bVar = AnimatableValueParser.m1335a(jsonReader, dVar, false);
                    break;
                case 3:
                    mVar = AnimatablePathValueParser.m1318b(jsonReader, dVar);
                    break;
                case 4:
                    bVar2 = AnimatableValueParser.m1335a(jsonReader, dVar, false);
                    break;
                case 5:
                    bVar4 = AnimatableValueParser.m1334a(jsonReader, dVar);
                    break;
                case 6:
                    bVar6 = AnimatableValueParser.m1335a(jsonReader, dVar, false);
                    break;
                case 7:
                    bVar3 = AnimatableValueParser.m1334a(jsonReader, dVar);
                    break;
                case 8:
                    bVar5 = AnimatableValueParser.m1335a(jsonReader, dVar, false);
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
