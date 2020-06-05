package com.airbnb.lottie.p012c;

/* renamed from: com.airbnb.lottie.c.n */
class GradientStrokeParser {
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01d1, code lost:
            r8 = r21;
            r12 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01df, code lost:
            r8 = r21;
            r12 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0241, code lost:
            r9 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0253, code lost:
            r12 = r17;
            r8 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00d4, code lost:
            r10 = r18;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x017c  */
    /* renamed from: a */
    static com.airbnb.lottie.model.content.GradientStroke m1360a(android.util.JsonReader r21, com.airbnb.lottie.LottieComposition r22) throws java.io.IOException {
        /*
        java.util.ArrayList r11 = new java.util.ArrayList
        r11.<init>()
        r1 = 0
        r1 = 0
        r2 = 0
        r3 = 0
        r4 = 0
        r5 = 0
        r6 = 0
        r7 = 0
        r8 = 0
        r9 = 0
        r10 = 0
        r12 = 0
    L_0x0011:
        boolean r13 = r21.hasNext()
        if (r13 == 0) goto L_0x0259
        java.lang.String r13 = r21.nextName()
        int r14 = r13.hashCode()
        java.lang.String r0 = "o"
        java.lang.String r15 = "g"
        r17 = r12
        java.lang.String r12 = "d"
        r18 = r10
        r19 = -1
        r10 = 100
        if (r14 == r10) goto L_0x00bc
        r10 = 101(0x65, float:1.42E-43)
        if (r14 == r10) goto L_0x00b2
        r10 = 103(0x67, float:1.44E-43)
        if (r14 == r10) goto L_0x00aa
        r10 = 111(0x6f, float:1.56E-43)
        if (r14 == r10) goto L_0x00a2
        r10 = 119(0x77, float:1.67E-43)
        if (r14 == r10) goto L_0x0098
        r10 = 3447(0xd77, float:4.83E-42)
        if (r14 == r10) goto L_0x008e
        r10 = 3454(0xd7e, float:4.84E-42)
        if (r14 == r10) goto L_0x0083
        r10 = 3487(0xd9f, float:4.886E-42)
        if (r14 == r10) goto L_0x0078
        r10 = 3519(0xdbf, float:4.931E-42)
        if (r14 == r10) goto L_0x006e
        r10 = 115(0x73, float:1.61E-43)
        if (r14 == r10) goto L_0x0064
        r10 = 116(0x74, float:1.63E-43)
        if (r14 == r10) goto L_0x0059
        goto L_0x00c5
    L_0x0059:
        java.lang.String r10 = "t"
        boolean r10 = r13.equals(r10)
        if (r10 == 0) goto L_0x00c5
        r10 = 3
        goto L_0x00c6
    L_0x0064:
        java.lang.String r10 = "s"
        boolean r10 = r13.equals(r10)
        if (r10 == 0) goto L_0x00c5
        r10 = 4
        goto L_0x00c6
    L_0x006e:
        java.lang.String r10 = "nm"
        boolean r10 = r13.equals(r10)
        if (r10 == 0) goto L_0x00c5
        r10 = 0
        goto L_0x00c6
    L_0x0078:
        java.lang.String r10 = "ml"
        boolean r10 = r13.equals(r10)
        if (r10 == 0) goto L_0x00c5
        r10 = 9
        goto L_0x00c6
    L_0x0083:
        java.lang.String r10 = "lj"
        boolean r10 = r13.equals(r10)
        if (r10 == 0) goto L_0x00c5
        r10 = 8
        goto L_0x00c6
    L_0x008e:
        java.lang.String r10 = "lc"
        boolean r10 = r13.equals(r10)
        if (r10 == 0) goto L_0x00c5
        r10 = 7
        goto L_0x00c6
    L_0x0098:
        java.lang.String r10 = "w"
        boolean r10 = r13.equals(r10)
        if (r10 == 0) goto L_0x00c5
        r10 = 6
        goto L_0x00c6
    L_0x00a2:
        boolean r10 = r13.equals(r0)
        if (r10 == 0) goto L_0x00c5
        r10 = 2
        goto L_0x00c6
    L_0x00aa:
        boolean r10 = r13.equals(r15)
        if (r10 == 0) goto L_0x00c5
        r10 = 1
        goto L_0x00c6
    L_0x00b2:
        java.lang.String r10 = "e"
        boolean r10 = r13.equals(r10)
        if (r10 == 0) goto L_0x00c5
        r10 = 5
        goto L_0x00c6
    L_0x00bc:
        boolean r10 = r13.equals(r12)
        if (r10 == 0) goto L_0x00c5
        r10 = 10
        goto L_0x00c6
    L_0x00c5:
        r10 = -1
    L_0x00c6:
        switch(r10) {
            case 0: goto L_0x0245;
            case 1: goto L_0x01e5;
            case 2: goto L_0x01d7;
            case 3: goto L_0x01c0;
            case 4: goto L_0x01b7;
            case 5: goto L_0x01ae;
            case 6: goto L_0x01a5;
            case 7: goto L_0x018b;
            case 8: goto L_0x017c;
            case 9: goto L_0x016b;
            case 10: goto L_0x00d8;
            default: goto L_0x00c9;
        }
    L_0x00c9:
        r12 = r22
        r20 = r8
        r16 = r9
        r8 = r21
        r21.skipValue()
    L_0x00d4:
        r10 = r18
        goto L_0x0253
    L_0x00d8:
        r21.beginArray()
    L_0x00db:
        boolean r10 = r21.hasNext()
        if (r10 == 0) goto L_0x0153
        r21.beginObject()
        r10 = 0
        r13 = 0
    L_0x00e6:
        boolean r14 = r21.hasNext()
        if (r14 == 0) goto L_0x012f
        java.lang.String r14 = r21.nextName()
        r16 = r9
        int r9 = r14.hashCode()
        r20 = r8
        r8 = 110(0x6e, float:1.54E-43)
        if (r9 == r8) goto L_0x010b
        r8 = 118(0x76, float:1.65E-43)
        if (r9 == r8) goto L_0x0101
        goto L_0x0115
    L_0x0101:
        java.lang.String r8 = "v"
        boolean r8 = r14.equals(r8)
        if (r8 == 0) goto L_0x0115
        r8 = 1
        goto L_0x0116
    L_0x010b:
        java.lang.String r8 = "n"
        boolean r8 = r14.equals(r8)
        if (r8 == 0) goto L_0x0115
        r8 = 0
        goto L_0x0116
    L_0x0115:
        r8 = -1
    L_0x0116:
        if (r8 == 0) goto L_0x0125
        r9 = 1
        if (r8 == r9) goto L_0x011f
        r21.skipValue()
        goto L_0x012a
    L_0x011f:
        com.airbnb.lottie.model.a.b r8 = com.airbnb.lottie.p012c.AnimatableValueParser.m1334a(r21, r22)
        r13 = r8
        goto L_0x012a
    L_0x0125:
        java.lang.String r8 = r21.nextString()
        r10 = r8
    L_0x012a:
        r9 = r16
        r8 = r20
        goto L_0x00e6
    L_0x012f:
        r20 = r8
        r16 = r9
        r21.endObject()
        boolean r8 = r10.equals(r0)
        if (r8 == 0) goto L_0x013f
        r17 = r13
        goto L_0x014e
    L_0x013f:
        boolean r8 = r10.equals(r12)
        if (r8 != 0) goto L_0x014b
        boolean r8 = r10.equals(r15)
        if (r8 == 0) goto L_0x014e
    L_0x014b:
        r11.add(r13)
    L_0x014e:
        r9 = r16
        r8 = r20
        goto L_0x00db
    L_0x0153:
        r20 = r8
        r16 = r9
        r21.endArray()
        int r0 = r11.size()
        r8 = 1
        if (r0 != r8) goto L_0x01d1
        r10 = 0
        java.lang.Object r0 = r11.get(r10)
        r11.add(r0)
        goto L_0x01d1
    L_0x016b:
        r20 = r8
        r16 = r9
        double r8 = r21.nextDouble()
        float r10 = (float) r8
        r8 = r21
        r12 = r22
        r9 = r16
        goto L_0x0253
    L_0x017c:
        r20 = r8
        r8 = 1
        com.airbnb.lottie.model.content.ShapeStroke$LineJoinType[] r0 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.values()
        int r9 = r21.nextInt()
        int r9 = r9 - r8
        r9 = r0[r9]
        goto L_0x01df
    L_0x018b:
        r16 = r9
        r8 = 1
        com.airbnb.lottie.model.content.ShapeStroke$LineCapType[] r0 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.values()
        int r9 = r21.nextInt()
        int r9 = r9 - r8
        r8 = r0[r9]
        r12 = r22
        r20 = r8
        r9 = r16
        r10 = r18
        r8 = r21
        goto L_0x0253
    L_0x01a5:
        r20 = r8
        r16 = r9
        com.airbnb.lottie.model.a.b r7 = com.airbnb.lottie.p012c.AnimatableValueParser.m1334a(r21, r22)
        goto L_0x01df
    L_0x01ae:
        r20 = r8
        r16 = r9
        com.airbnb.lottie.model.a.f r6 = com.airbnb.lottie.p012c.AnimatableValueParser.m1340c(r21, r22)
        goto L_0x01df
    L_0x01b7:
        r20 = r8
        r16 = r9
        com.airbnb.lottie.model.a.f r5 = com.airbnb.lottie.p012c.AnimatableValueParser.m1340c(r21, r22)
        goto L_0x01df
    L_0x01c0:
        r20 = r8
        r16 = r9
        r8 = 1
        int r0 = r21.nextInt()
        if (r0 != r8) goto L_0x01ce
        com.airbnb.lottie.model.content.GradientType r0 = com.airbnb.lottie.model.content.GradientType.Linear
        goto L_0x01d0
    L_0x01ce:
        com.airbnb.lottie.model.content.GradientType r0 = com.airbnb.lottie.model.content.GradientType.Radial
    L_0x01d0:
        r2 = r0
    L_0x01d1:
        r8 = r21
        r12 = r22
        goto L_0x0241
    L_0x01d7:
        r20 = r8
        r16 = r9
        com.airbnb.lottie.model.a.d r4 = com.airbnb.lottie.p012c.AnimatableValueParser.m1339b(r21, r22)
    L_0x01df:
        r8 = r21
        r12 = r22
        goto L_0x00d4
    L_0x01e5:
        r20 = r8
        r16 = r9
        r10 = 0
        r21.beginObject()
        r0 = -1
    L_0x01ee:
        boolean r8 = r21.hasNext()
        if (r8 == 0) goto L_0x023a
        java.lang.String r8 = r21.nextName()
        int r9 = r8.hashCode()
        r12 = 107(0x6b, float:1.5E-43)
        if (r9 == r12) goto L_0x020f
        r12 = 112(0x70, float:1.57E-43)
        if (r9 == r12) goto L_0x0205
        goto L_0x0219
    L_0x0205:
        java.lang.String r9 = "p"
        boolean r8 = r8.equals(r9)
        if (r8 == 0) goto L_0x0219
        r8 = 0
        goto L_0x021a
    L_0x020f:
        java.lang.String r9 = "k"
        boolean r8 = r8.equals(r9)
        if (r8 == 0) goto L_0x0219
        r8 = 1
        goto L_0x021a
    L_0x0219:
        r8 = -1
    L_0x021a:
        if (r8 == 0) goto L_0x0230
        r9 = 1
        if (r8 == r9) goto L_0x0227
        r21.skipValue()
        r8 = r21
        r12 = r22
        goto L_0x01ee
    L_0x0227:
        r8 = r21
        r12 = r22
        com.airbnb.lottie.model.a.c r3 = com.airbnb.lottie.p012c.AnimatableValueParser.m1336a(r8, r12, r0)
        goto L_0x01ee
    L_0x0230:
        r9 = 1
        r8 = r21
        r12 = r22
        int r0 = r21.nextInt()
        goto L_0x01ee
    L_0x023a:
        r8 = r21
        r12 = r22
        r21.endObject()
    L_0x0241:
        r9 = r16
        goto L_0x00d4
    L_0x0245:
        r12 = r22
        r20 = r8
        r16 = r9
        r8 = r21
        java.lang.String r1 = r21.nextString()
        goto L_0x00d4
    L_0x0253:
        r12 = r17
        r8 = r20
        goto L_0x0011
    L_0x0259:
        r20 = r8
        r16 = r9
        r18 = r10
        r17 = r12
        com.airbnb.lottie.model.content.e r13 = new com.airbnb.lottie.model.content.e
        r0 = r13
        r0.m41032init(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
        return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p012c.GradientStrokeParser.m1360a(android.util.JsonReader, com.airbnb.lottie.d):com.airbnb.lottie.model.content.e");
    }
}
