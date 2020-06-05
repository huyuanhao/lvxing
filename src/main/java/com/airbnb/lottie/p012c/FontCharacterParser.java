package com.airbnb.lottie.p012c;

/* renamed from: com.airbnb.lottie.c.j */
class FontCharacterParser {
    /* renamed from: a */
    static com.airbnb.lottie.model.FontCharacter m1353a(android.util.JsonReader r16, com.airbnb.lottie.LottieComposition r17) throws java.io.IOException {
        /*
        java.util.ArrayList r1 = new java.util.ArrayList
        r1.<init>()
        r16.beginObject()
        r0 = 0
        r2 = 0
        r4 = 0
        r9 = r0
        r10 = r9
        r5 = r2
        r7 = r5
        r2 = 0
    L_0x0011:
        boolean r0 = r16.hasNext()
        if (r0 == 0) goto L_0x00cc
        java.lang.String r0 = r16.nextName()
        int r11 = r0.hashCode()
        r12 = 5
        r13 = 4
        r14 = 3
        r15 = 2
        r3 = 1
        switch(r11) {
            case -1866931350: goto L_0x005a;
            case 119: goto L_0x0050;
            case 3173: goto L_0x0046;
            case 3076010: goto L_0x003c;
            case 3530753: goto L_0x0032;
            case 109780401: goto L_0x0028;
            default: goto L_0x0027;
        }
    L_0x0027:
        goto L_0x0064
    L_0x0028:
        java.lang.String r11 = "style"
        boolean r0 = r0.equals(r11)
        if (r0 == 0) goto L_0x0064
        r0 = 3
        goto L_0x0065
    L_0x0032:
        java.lang.String r11 = "size"
        boolean r0 = r0.equals(r11)
        if (r0 == 0) goto L_0x0064
        r0 = 1
        goto L_0x0065
    L_0x003c:
        java.lang.String r11 = "data"
        boolean r0 = r0.equals(r11)
        if (r0 == 0) goto L_0x0064
        r0 = 5
        goto L_0x0065
    L_0x0046:
        java.lang.String r11 = "ch"
        boolean r0 = r0.equals(r11)
        if (r0 == 0) goto L_0x0064
        r0 = 0
        goto L_0x0065
    L_0x0050:
        java.lang.String r11 = "w"
        boolean r0 = r0.equals(r11)
        if (r0 == 0) goto L_0x0064
        r0 = 2
        goto L_0x0065
    L_0x005a:
        java.lang.String r11 = "fFamily"
        boolean r0 = r0.equals(r11)
        if (r0 == 0) goto L_0x0064
        r0 = 4
        goto L_0x0065
    L_0x0064:
        r0 = -1
    L_0x0065:
        if (r0 == 0) goto L_0x00c2
        if (r0 == r3) goto L_0x00bc
        if (r0 == r15) goto L_0x00b6
        if (r0 == r14) goto L_0x00b0
        if (r0 == r13) goto L_0x00aa
        if (r0 == r12) goto L_0x0075
        r16.skipValue()
        goto L_0x0011
    L_0x0075:
        r16.beginObject()
    L_0x0078:
        boolean r0 = r16.hasNext()
        if (r0 == 0) goto L_0x00a5
        java.lang.String r0 = r16.nextName()
        java.lang.String r3 = "shapes"
        boolean r0 = r3.equals(r0)
        if (r0 == 0) goto L_0x00a1
        r16.beginArray()
    L_0x008d:
        boolean r0 = r16.hasNext()
        if (r0 == 0) goto L_0x009d
        com.airbnb.lottie.model.content.b r0 = com.airbnb.lottie.p012c.ContentModelParser.m1348a(r16, r17)
        com.airbnb.lottie.model.content.j r0 = (com.airbnb.lottie.model.content.ShapeGroup) r0
        r1.add(r0)
        goto L_0x008d
    L_0x009d:
        r16.endArray()
        goto L_0x0078
    L_0x00a1:
        r16.skipValue()
        goto L_0x0078
    L_0x00a5:
        r16.endObject()
        goto L_0x0011
    L_0x00aa:
        java.lang.String r10 = r16.nextString()
        goto L_0x0011
    L_0x00b0:
        java.lang.String r9 = r16.nextString()
        goto L_0x0011
    L_0x00b6:
        double r7 = r16.nextDouble()
        goto L_0x0011
    L_0x00bc:
        double r5 = r16.nextDouble()
        goto L_0x0011
    L_0x00c2:
        java.lang.String r0 = r16.nextString()
        char r2 = r0.charAt(r4)
        goto L_0x0011
    L_0x00cc:
        r16.endObject()
        com.airbnb.lottie.model.d r11 = new com.airbnb.lottie.model.d
        r0 = r11
        r3 = r5
        r5 = r7
        r7 = r9
        r8 = r10
        r0.m41040init(r1, r2, r3, r5, r7, r8)
        return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p012c.FontCharacterParser.m1353a(android.util.JsonReader, com.airbnb.lottie.d):com.airbnb.lottie.model.d");
    }
}
