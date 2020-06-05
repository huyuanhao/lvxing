package com.airbnb.lottie.p012c;

/* renamed from: com.airbnb.lottie.c.g */
class ContentModelParser {
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b2, code lost:
            if (r2.equals("gs") != false) goto L_0x00de;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0042 A[SYNTHETIC] */
    /* renamed from: a */
    static com.airbnb.lottie.model.content.ContentModel m1348a(android.util.JsonReader r9, com.airbnb.lottie.LottieComposition r10) throws java.io.IOException {
        /*
        r9.beginObject()
        r0 = 2
        r1 = 2
    L_0x0005:
        boolean r2 = r9.hasNext()
        r3 = 0
        r4 = -1
        r5 = 1
        r6 = 0
        if (r2 == 0) goto L_0x0047
        java.lang.String r2 = r9.nextName()
        int r7 = r2.hashCode()
        r8 = 100
        if (r7 == r8) goto L_0x002a
        r8 = 3717(0xe85, float:5.209E-42)
        if (r7 == r8) goto L_0x0020
        goto L_0x0034
    L_0x0020:
        java.lang.String r7 = "ty"
        boolean r2 = r2.equals(r7)
        if (r2 == 0) goto L_0x0034
        r2 = 0
        goto L_0x0035
    L_0x002a:
        java.lang.String r7 = "d"
        boolean r2 = r2.equals(r7)
        if (r2 == 0) goto L_0x0034
        r2 = 1
        goto L_0x0035
    L_0x0034:
        r2 = -1
    L_0x0035:
        if (r2 == 0) goto L_0x0042
        if (r2 == r5) goto L_0x003d
        r9.skipValue()
        goto L_0x0005
    L_0x003d:
        int r1 = r9.nextInt()
        goto L_0x0005
    L_0x0042:
        java.lang.String r2 = r9.nextString()
        goto L_0x0048
    L_0x0047:
        r2 = r6
    L_0x0048:
        if (r2 != 0) goto L_0x004b
        return r6
    L_0x004b:
        int r7 = r2.hashCode()
        switch(r7) {
            case 3239: goto L_0x00d3;
            case 3270: goto L_0x00c9;
            case 3295: goto L_0x00bf;
            case 3307: goto L_0x00b5;
            case 3308: goto L_0x00ac;
            case 3488: goto L_0x00a1;
            case 3633: goto L_0x0096;
            case 3646: goto L_0x008b;
            case 3669: goto L_0x0081;
            case 3679: goto L_0x0076;
            case 3681: goto L_0x006b;
            case 3705: goto L_0x005f;
            case 3710: goto L_0x0054;
            default: goto L_0x0052;
        }
    L_0x0052:
        goto L_0x00dd
    L_0x0054:
        java.lang.String r0 = "tr"
        boolean r0 = r2.equals(r0)
        if (r0 == 0) goto L_0x00dd
        r0 = 5
        goto L_0x00de
    L_0x005f:
        java.lang.String r0 = "tm"
        boolean r0 = r2.equals(r0)
        if (r0 == 0) goto L_0x00dd
        r0 = 9
        goto L_0x00de
    L_0x006b:
        java.lang.String r0 = "st"
        boolean r0 = r2.equals(r0)
        if (r0 == 0) goto L_0x00dd
        r0 = 1
        goto L_0x00de
    L_0x0076:
        java.lang.String r0 = "sr"
        boolean r0 = r2.equals(r0)
        if (r0 == 0) goto L_0x00dd
        r0 = 10
        goto L_0x00de
    L_0x0081:
        java.lang.String r0 = "sh"
        boolean r0 = r2.equals(r0)
        if (r0 == 0) goto L_0x00dd
        r0 = 6
        goto L_0x00de
    L_0x008b:
        java.lang.String r0 = "rp"
        boolean r0 = r2.equals(r0)
        if (r0 == 0) goto L_0x00dd
        r0 = 12
        goto L_0x00de
    L_0x0096:
        java.lang.String r0 = "rc"
        boolean r0 = r2.equals(r0)
        if (r0 == 0) goto L_0x00dd
        r0 = 8
        goto L_0x00de
    L_0x00a1:
        java.lang.String r0 = "mm"
        boolean r0 = r2.equals(r0)
        if (r0 == 0) goto L_0x00dd
        r0 = 11
        goto L_0x00de
    L_0x00ac:
        java.lang.String r3 = "gs"
        boolean r3 = r2.equals(r3)
        if (r3 == 0) goto L_0x00dd
        goto L_0x00de
    L_0x00b5:
        java.lang.String r0 = "gr"
        boolean r0 = r2.equals(r0)
        if (r0 == 0) goto L_0x00dd
        r0 = 0
        goto L_0x00de
    L_0x00bf:
        java.lang.String r0 = "gf"
        boolean r0 = r2.equals(r0)
        if (r0 == 0) goto L_0x00dd
        r0 = 4
        goto L_0x00de
    L_0x00c9:
        java.lang.String r0 = "fl"
        boolean r0 = r2.equals(r0)
        if (r0 == 0) goto L_0x00dd
        r0 = 3
        goto L_0x00de
    L_0x00d3:
        java.lang.String r0 = "el"
        boolean r0 = r2.equals(r0)
        if (r0 == 0) goto L_0x00dd
        r0 = 7
        goto L_0x00de
    L_0x00dd:
        r0 = -1
    L_0x00de:
        switch(r0) {
            case 0: goto L_0x0139;
            case 1: goto L_0x0134;
            case 2: goto L_0x012f;
            case 3: goto L_0x012a;
            case 4: goto L_0x0125;
            case 5: goto L_0x0120;
            case 6: goto L_0x011b;
            case 7: goto L_0x0116;
            case 8: goto L_0x0111;
            case 9: goto L_0x010c;
            case 10: goto L_0x0107;
            case 11: goto L_0x00fd;
            case 12: goto L_0x00f8;
            default: goto L_0x00e1;
        }
    L_0x00e1:
        java.lang.StringBuilder r10 = new java.lang.StringBuilder
        r10.<init>()
        java.lang.String r0 = "Unknown shape type "
        r10.append(r0)
        r10.append(r2)
        java.lang.String r10 = r10.toString()
        java.lang.String r0 = "LOTTIE"
        android.util.Log.w(r0, r10)
        goto L_0x013d
    L_0x00f8:
        com.airbnb.lottie.model.content.g r6 = com.airbnb.lottie.p012c.RepeaterParser.m1320a(r9, r10)
        goto L_0x013d
    L_0x00fd:
        com.airbnb.lottie.model.content.MergePaths r6 = com.airbnb.lottie.p012c.MergePathsParser.m1386a(r9)
        java.lang.String r0 = "Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove()."
        r10.mo9916a(r0)
        goto L_0x013d
    L_0x0107:
        com.airbnb.lottie.model.content.PolystarShape r6 = com.airbnb.lottie.p012c.PolystarShapeParser.m1392a(r9, r10)
        goto L_0x013d
    L_0x010c:
        com.airbnb.lottie.model.content.ShapeTrimPath r6 = com.airbnb.lottie.p012c.ShapeTrimPathParser.m1329a(r9, r10)
        goto L_0x013d
    L_0x0111:
        com.airbnb.lottie.model.content.f r6 = com.airbnb.lottie.p012c.RectangleShapeParser.m1319a(r9, r10)
        goto L_0x013d
    L_0x0116:
        com.airbnb.lottie.model.content.a r6 = com.airbnb.lottie.p012c.CircleShapeParser.m1345a(r9, r10, r1)
        goto L_0x013d
    L_0x011b:
        com.airbnb.lottie.model.content.k r6 = com.airbnb.lottie.p012c.ShapePathParser.m1327a(r9, r10)
        goto L_0x013d
    L_0x0120:
        com.airbnb.lottie.model.a.l r6 = com.airbnb.lottie.p012c.AnimatableTransformParser.m1333a(r9, r10)
        goto L_0x013d
    L_0x0125:
        com.airbnb.lottie.model.content.d r6 = com.airbnb.lottie.p012c.GradientFillParser.m1359a(r9, r10)
        goto L_0x013d
    L_0x012a:
        com.airbnb.lottie.model.content.i r6 = com.airbnb.lottie.p012c.ShapeFillParser.m1325a(r9, r10)
        goto L_0x013d
    L_0x012f:
        com.airbnb.lottie.model.content.e r6 = com.airbnb.lottie.p012c.GradientStrokeParser.m1360a(r9, r10)
        goto L_0x013d
    L_0x0134:
        com.airbnb.lottie.model.content.ShapeStroke r6 = com.airbnb.lottie.p012c.ShapeStrokeParser.m1328a(r9, r10)
        goto L_0x013d
    L_0x0139:
        com.airbnb.lottie.model.content.j r6 = com.airbnb.lottie.p012c.ShapeGroupParser.m1326a(r9, r10)
    L_0x013d:
        boolean r10 = r9.hasNext()
        if (r10 == 0) goto L_0x0147
        r9.skipValue()
        goto L_0x013d
    L_0x0147:
        r9.endObject()
        return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p012c.ContentModelParser.m1348a(android.util.JsonReader, com.airbnb.lottie.d):com.airbnb.lottie.model.content.b");
    }
}
