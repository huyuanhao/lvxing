package com.airbnb.lottie.p012c;

import com.airbnb.lottie.model.DocumentData;

/* renamed from: com.airbnb.lottie.c.h */
public class DocumentDataParser implements ValueParser<DocumentData> {
    /* renamed from: a */
    public static final DocumentDataParser f1447a = new DocumentDataParser();

    private DocumentDataParser() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0119  */
    /* renamed from: a */
    public com.airbnb.lottie.model.DocumentData mo9904b(android.util.JsonReader r21, float r22) throws java.io.IOException {
        /*
        r20 = this;
        r21.beginObject()
        r0 = 1
        r1 = 0
        r2 = 0
        r4 = 0
        r6 = r1
        r7 = r6
        r8 = r2
        r12 = r8
        r14 = r12
        r10 = 0
        r11 = 0
        r16 = 0
        r17 = 0
        r18 = 0
        r19 = 1
    L_0x0017:
        boolean r1 = r21.hasNext()
        if (r1 == 0) goto L_0x0120
        java.lang.String r1 = r21.nextName()
        r2 = -1
        int r3 = r1.hashCode()
        r5 = 102(0x66, float:1.43E-43)
        if (r3 == r5) goto L_0x00bc
        r5 = 106(0x6a, float:1.49E-43)
        if (r3 == r5) goto L_0x00b2
        r5 = 3261(0xcbd, float:4.57E-42)
        if (r3 == r5) goto L_0x00a8
        r5 = 3452(0xd7c, float:4.837E-42)
        if (r3 == r5) goto L_0x009e
        r5 = 3463(0xd87, float:4.853E-42)
        if (r3 == r5) goto L_0x0094
        r5 = 3543(0xdd7, float:4.965E-42)
        if (r3 == r5) goto L_0x0089
        r5 = 3664(0xe50, float:5.134E-42)
        if (r3 == r5) goto L_0x007e
        r5 = 3684(0xe64, float:5.162E-42)
        if (r3 == r5) goto L_0x0073
        r5 = 3710(0xe7e, float:5.199E-42)
        if (r3 == r5) goto L_0x0069
        r5 = 115(0x73, float:1.61E-43)
        if (r3 == r5) goto L_0x005f
        r5 = 116(0x74, float:1.63E-43)
        if (r3 == r5) goto L_0x0054
        goto L_0x00c6
    L_0x0054:
        java.lang.String r3 = "t"
        boolean r1 = r1.equals(r3)
        if (r1 == 0) goto L_0x00c6
        r1 = 0
        goto L_0x00c7
    L_0x005f:
        java.lang.String r3 = "s"
        boolean r1 = r1.equals(r3)
        if (r1 == 0) goto L_0x00c6
        r1 = 2
        goto L_0x00c7
    L_0x0069:
        java.lang.String r3 = "tr"
        boolean r1 = r1.equals(r3)
        if (r1 == 0) goto L_0x00c6
        r1 = 4
        goto L_0x00c7
    L_0x0073:
        java.lang.String r3 = "sw"
        boolean r1 = r1.equals(r3)
        if (r1 == 0) goto L_0x00c6
        r1 = 9
        goto L_0x00c7
    L_0x007e:
        java.lang.String r3 = "sc"
        boolean r1 = r1.equals(r3)
        if (r1 == 0) goto L_0x00c6
        r1 = 8
        goto L_0x00c7
    L_0x0089:
        java.lang.String r3 = "of"
        boolean r1 = r1.equals(r3)
        if (r1 == 0) goto L_0x00c6
        r1 = 10
        goto L_0x00c7
    L_0x0094:
        java.lang.String r3 = "ls"
        boolean r1 = r1.equals(r3)
        if (r1 == 0) goto L_0x00c6
        r1 = 6
        goto L_0x00c7
    L_0x009e:
        java.lang.String r3 = "lh"
        boolean r1 = r1.equals(r3)
        if (r1 == 0) goto L_0x00c6
        r1 = 5
        goto L_0x00c7
    L_0x00a8:
        java.lang.String r3 = "fc"
        boolean r1 = r1.equals(r3)
        if (r1 == 0) goto L_0x00c6
        r1 = 7
        goto L_0x00c7
    L_0x00b2:
        java.lang.String r3 = "j"
        boolean r1 = r1.equals(r3)
        if (r1 == 0) goto L_0x00c6
        r1 = 3
        goto L_0x00c7
    L_0x00bc:
        java.lang.String r3 = "f"
        boolean r1 = r1.equals(r3)
        if (r1 == 0) goto L_0x00c6
        r1 = 1
        goto L_0x00c7
    L_0x00c6:
        r1 = -1
    L_0x00c7:
        switch(r1) {
            case 0: goto L_0x0119;
            case 1: goto L_0x0112;
            case 2: goto L_0x010b;
            case 3: goto L_0x0104;
            case 4: goto L_0x00fd;
            case 5: goto L_0x00f6;
            case 6: goto L_0x00ef;
            case 7: goto L_0x00e7;
            case 8: goto L_0x00df;
            case 9: goto L_0x00d7;
            case 10: goto L_0x00cf;
            default: goto L_0x00ca;
        }
    L_0x00ca:
        r21.skipValue()
        goto L_0x0017
    L_0x00cf:
        boolean r1 = r21.nextBoolean()
        r19 = r1
        goto L_0x0017
    L_0x00d7:
        int r1 = r21.nextInt()
        r18 = r1
        goto L_0x0017
    L_0x00df:
        int r1 = com.airbnb.lottie.p012c.JsonUtils.m1363a(r21)
        r17 = r1
        goto L_0x0017
    L_0x00e7:
        int r1 = com.airbnb.lottie.p012c.JsonUtils.m1363a(r21)
        r16 = r1
        goto L_0x0017
    L_0x00ef:
        double r1 = r21.nextDouble()
        r14 = r1
        goto L_0x0017
    L_0x00f6:
        double r1 = r21.nextDouble()
        r12 = r1
        goto L_0x0017
    L_0x00fd:
        int r1 = r21.nextInt()
        r11 = r1
        goto L_0x0017
    L_0x0104:
        int r1 = r21.nextInt()
        r10 = r1
        goto L_0x0017
    L_0x010b:
        double r1 = r21.nextDouble()
        r8 = r1
        goto L_0x0017
    L_0x0112:
        java.lang.String r1 = r21.nextString()
        r7 = r1
        goto L_0x0017
    L_0x0119:
        java.lang.String r1 = r21.nextString()
        r6 = r1
        goto L_0x0017
    L_0x0120:
        r21.endObject()
        com.airbnb.lottie.model.b r0 = new com.airbnb.lottie.model.b
        r5 = r0
        r5.m41007init(r6, r7, r8, r10, r11, r12, r14, r16, r17, r18, r19)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p012c.DocumentDataParser.mo9904b(android.util.JsonReader, float):com.airbnb.lottie.model.b");
    }
}
