package com.airbnb.lottie.p012c;

/* renamed from: com.airbnb.lottie.c.m */
class GradientFillParser {
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00f3  */
    /* renamed from: a */
    static com.airbnb.lottie.model.content.GradientFill m1359a(android.util.JsonReader r14, com.airbnb.lottie.LottieComposition r15) throws java.io.IOException {
        /*
        r0 = 0
        r2 = r0
        r3 = r2
        r4 = r3
        r5 = r4
        r6 = r5
        r7 = r6
        r8 = r7
    L_0x0008:
        boolean r0 = r14.hasNext()
        if (r0 == 0) goto L_0x00fa
        java.lang.String r0 = r14.nextName()
        int r1 = r0.hashCode()
        r9 = 101(0x65, float:1.42E-43)
        r10 = 0
        r11 = -1
        r12 = 1
        if (r1 == r9) goto L_0x0069
        r9 = 103(0x67, float:1.44E-43)
        if (r1 == r9) goto L_0x005f
        r9 = 111(0x6f, float:1.56E-43)
        if (r1 == r9) goto L_0x0055
        r9 = 3519(0xdbf, float:4.931E-42)
        if (r1 == r9) goto L_0x004b
        switch(r1) {
            case 114: goto L_0x0041;
            case 115: goto L_0x0037;
            case 116: goto L_0x002d;
            default: goto L_0x002c;
        }
    L_0x002c:
        goto L_0x0073
    L_0x002d:
        java.lang.String r1 = "t"
        boolean r0 = r0.equals(r1)
        if (r0 == 0) goto L_0x0073
        r0 = 3
        goto L_0x0074
    L_0x0037:
        java.lang.String r1 = "s"
        boolean r0 = r0.equals(r1)
        if (r0 == 0) goto L_0x0073
        r0 = 4
        goto L_0x0074
    L_0x0041:
        java.lang.String r1 = "r"
        boolean r0 = r0.equals(r1)
        if (r0 == 0) goto L_0x0073
        r0 = 6
        goto L_0x0074
    L_0x004b:
        java.lang.String r1 = "nm"
        boolean r0 = r0.equals(r1)
        if (r0 == 0) goto L_0x0073
        r0 = 0
        goto L_0x0074
    L_0x0055:
        java.lang.String r1 = "o"
        boolean r0 = r0.equals(r1)
        if (r0 == 0) goto L_0x0073
        r0 = 2
        goto L_0x0074
    L_0x005f:
        java.lang.String r1 = "g"
        boolean r0 = r0.equals(r1)
        if (r0 == 0) goto L_0x0073
        r0 = 1
        goto L_0x0074
    L_0x0069:
        java.lang.String r1 = "e"
        boolean r0 = r0.equals(r1)
        if (r0 == 0) goto L_0x0073
        r0 = 5
        goto L_0x0074
    L_0x0073:
        r0 = -1
    L_0x0074:
        switch(r0) {
            case 0: goto L_0x00f3;
            case 1: goto L_0x00ab;
            case 2: goto L_0x00a4;
            case 3: goto L_0x0096;
            case 4: goto L_0x008f;
            case 5: goto L_0x0088;
            case 6: goto L_0x007b;
            default: goto L_0x0077;
        }
    L_0x0077:
        r14.skipValue()
        goto L_0x0008
    L_0x007b:
        int r0 = r14.nextInt()
        if (r0 != r12) goto L_0x0084
        android.graphics.Path$FillType r0 = android.graphics.Path.FillType.WINDING
        goto L_0x0086
    L_0x0084:
        android.graphics.Path$FillType r0 = android.graphics.Path.FillType.EVEN_ODD
    L_0x0086:
        r4 = r0
        goto L_0x0008
    L_0x0088:
        com.airbnb.lottie.model.a.f r0 = com.airbnb.lottie.p012c.AnimatableValueParser.m1340c(r14, r15)
        r8 = r0
        goto L_0x0008
    L_0x008f:
        com.airbnb.lottie.model.a.f r0 = com.airbnb.lottie.p012c.AnimatableValueParser.m1340c(r14, r15)
        r7 = r0
        goto L_0x0008
    L_0x0096:
        int r0 = r14.nextInt()
        if (r0 != r12) goto L_0x009f
        com.airbnb.lottie.model.content.GradientType r0 = com.airbnb.lottie.model.content.GradientType.Linear
        goto L_0x00a1
    L_0x009f:
        com.airbnb.lottie.model.content.GradientType r0 = com.airbnb.lottie.model.content.GradientType.Radial
    L_0x00a1:
        r3 = r0
        goto L_0x0008
    L_0x00a4:
        com.airbnb.lottie.model.a.d r0 = com.airbnb.lottie.p012c.AnimatableValueParser.m1339b(r14, r15)
        r6 = r0
        goto L_0x0008
    L_0x00ab:
        r14.beginObject()
        r0 = -1
    L_0x00af:
        boolean r1 = r14.hasNext()
        if (r1 == 0) goto L_0x00ee
        java.lang.String r1 = r14.nextName()
        int r9 = r1.hashCode()
        r13 = 107(0x6b, float:1.5E-43)
        if (r9 == r13) goto L_0x00d0
        r13 = 112(0x70, float:1.57E-43)
        if (r9 == r13) goto L_0x00c6
        goto L_0x00da
    L_0x00c6:
        java.lang.String r9 = "p"
        boolean r1 = r1.equals(r9)
        if (r1 == 0) goto L_0x00da
        r1 = 0
        goto L_0x00db
    L_0x00d0:
        java.lang.String r9 = "k"
        boolean r1 = r1.equals(r9)
        if (r1 == 0) goto L_0x00da
        r1 = 1
        goto L_0x00db
    L_0x00da:
        r1 = -1
    L_0x00db:
        if (r1 == 0) goto L_0x00e9
        if (r1 == r12) goto L_0x00e3
        r14.skipValue()
        goto L_0x00af
    L_0x00e3:
        com.airbnb.lottie.model.a.c r1 = com.airbnb.lottie.p012c.AnimatableValueParser.m1336a(r14, r15, r0)
        r5 = r1
        goto L_0x00af
    L_0x00e9:
        int r0 = r14.nextInt()
        goto L_0x00af
    L_0x00ee:
        r14.endObject()
        goto L_0x0008
    L_0x00f3:
        java.lang.String r0 = r14.nextString()
        r2 = r0
        goto L_0x0008
    L_0x00fa:
        com.airbnb.lottie.model.content.d r14 = new com.airbnb.lottie.model.content.d
        r9 = 0
        r10 = 0
        r1 = r14
        r1.m41031init(r2, r3, r4, r5, r6, r7, r8, r9, r10)
        return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p012c.GradientFillParser.m1359a(android.util.JsonReader, com.airbnb.lottie.d):com.airbnb.lottie.model.content.d");
    }
}
