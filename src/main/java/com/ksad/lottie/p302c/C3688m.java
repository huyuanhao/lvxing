package com.ksad.lottie.p302c;

/* renamed from: com.ksad.lottie.c.m */
public class C3688m {
    /* JADX WARNING: Removed duplicated region for block: B:51:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00cf  */
    /* renamed from: a */
    public static com.ksad.lottie.model.p305a.C3754l m15293a(android.util.JsonReader r14, com.ksad.lottie.C3703d r15) {
        /*
        android.util.JsonToken r0 = r14.peek()
        android.util.JsonToken r1 = android.util.JsonToken.BEGIN_OBJECT
        r2 = 1
        r3 = 0
        if (r0 != r1) goto L_0x000c
        r0 = 1
        goto L_0x000d
    L_0x000c:
        r0 = 0
    L_0x000d:
        if (r0 == 0) goto L_0x0012
        r14.beginObject()
    L_0x0012:
        r1 = 0
        r4 = r1
        r5 = r4
        r8 = r5
        r10 = r8
        r12 = r10
        r13 = r12
    L_0x0019:
        boolean r6 = r14.hasNext()
        if (r6 == 0) goto L_0x00f2
        java.lang.String r6 = r14.nextName()
        r7 = -1
        int r9 = r6.hashCode()
        r11 = 97
        if (r9 == r11) goto L_0x008f
        r11 = 3242(0xcaa, float:4.543E-42)
        if (r9 == r11) goto L_0x0085
        r11 = 3656(0xe48, float:5.123E-42)
        if (r9 == r11) goto L_0x007b
        r11 = 3676(0xe5c, float:5.151E-42)
        if (r9 == r11) goto L_0x0071
        r11 = 111(0x6f, float:1.56E-43)
        if (r9 == r11) goto L_0x0067
        r11 = 112(0x70, float:1.57E-43)
        if (r9 == r11) goto L_0x005d
        r11 = 114(0x72, float:1.6E-43)
        if (r9 == r11) goto L_0x0053
        r11 = 115(0x73, float:1.61E-43)
        if (r9 == r11) goto L_0x0049
        goto L_0x0099
    L_0x0049:
        java.lang.String r9 = "s"
        boolean r6 = r6.equals(r9)
        if (r6 == 0) goto L_0x0099
        r6 = 2
        goto L_0x009a
    L_0x0053:
        java.lang.String r9 = "r"
        boolean r6 = r6.equals(r9)
        if (r6 == 0) goto L_0x0099
        r6 = 4
        goto L_0x009a
    L_0x005d:
        java.lang.String r9 = "p"
        boolean r6 = r6.equals(r9)
        if (r6 == 0) goto L_0x0099
        r6 = 1
        goto L_0x009a
    L_0x0067:
        java.lang.String r9 = "o"
        boolean r6 = r6.equals(r9)
        if (r6 == 0) goto L_0x0099
        r6 = 5
        goto L_0x009a
    L_0x0071:
        java.lang.String r9 = "so"
        boolean r6 = r6.equals(r9)
        if (r6 == 0) goto L_0x0099
        r6 = 6
        goto L_0x009a
    L_0x007b:
        java.lang.String r9 = "rz"
        boolean r6 = r6.equals(r9)
        if (r6 == 0) goto L_0x0099
        r6 = 3
        goto L_0x009a
    L_0x0085:
        java.lang.String r9 = "eo"
        boolean r6 = r6.equals(r9)
        if (r6 == 0) goto L_0x0099
        r6 = 7
        goto L_0x009a
    L_0x008f:
        java.lang.String r9 = "a"
        boolean r6 = r6.equals(r9)
        if (r6 == 0) goto L_0x0099
        r6 = 0
        goto L_0x009a
    L_0x0099:
        r6 = -1
    L_0x009a:
        switch(r6) {
            case 0: goto L_0x00cf;
            case 1: goto L_0x00c8;
            case 2: goto L_0x00c2;
            case 3: goto L_0x00b6;
            case 4: goto L_0x00bb;
            case 5: goto L_0x00b0;
            case 6: goto L_0x00a9;
            case 7: goto L_0x00a2;
            default: goto L_0x009d;
        }
    L_0x009d:
        r14.skipValue()
        goto L_0x0019
    L_0x00a2:
        com.ksad.lottie.model.a.b r6 = com.ksad.lottie.p302c.C3689n.m15295a(r14, r15, r3)
        r13 = r6
        goto L_0x0019
    L_0x00a9:
        com.ksad.lottie.model.a.b r6 = com.ksad.lottie.p302c.C3689n.m15295a(r14, r15, r3)
        r12 = r6
        goto L_0x0019
    L_0x00b0:
        com.ksad.lottie.model.a.d r5 = com.ksad.lottie.p302c.C3689n.m15299b(r14, r15)
        goto L_0x0019
    L_0x00b6:
        java.lang.String r6 = "Lottie doesn't support 3D layers."
        r15.mo22876a(r6)
    L_0x00bb:
        com.ksad.lottie.model.a.b r6 = com.ksad.lottie.p302c.C3689n.m15295a(r14, r15, r3)
        r10 = r6
        goto L_0x0019
    L_0x00c2:
        com.ksad.lottie.model.a.g r4 = com.ksad.lottie.p302c.C3689n.m15301d(r14, r15)
        goto L_0x0019
    L_0x00c8:
        com.ksad.lottie.model.a.m r6 = com.ksad.lottie.p302c.C3666a.m15255b(r14, r15)
        r8 = r6
        goto L_0x0019
    L_0x00cf:
        r14.beginObject()
    L_0x00d2:
        boolean r6 = r14.hasNext()
        if (r6 == 0) goto L_0x00ed
        java.lang.String r6 = r14.nextName()
        java.lang.String r7 = "k"
        boolean r6 = r6.equals(r7)
        if (r6 == 0) goto L_0x00e9
        com.ksad.lottie.model.a.e r1 = com.ksad.lottie.p302c.C3666a.m15254a(r14, r15)
        goto L_0x00d2
    L_0x00e9:
        r14.skipValue()
        goto L_0x00d2
    L_0x00ed:
        r14.endObject()
        goto L_0x0019
    L_0x00f2:
        if (r0 == 0) goto L_0x00f7
        r14.endObject()
    L_0x00f7:
        if (r1 != 0) goto L_0x0105
        java.lang.String r14 = "LOTTIE"
        java.lang.String r15 = "Layer has no transform property. You may be using an unsupported layer type such as a camera."
        android.util.Log.w(r14, r15)
        com.ksad.lottie.model.a.e r1 = new com.ksad.lottie.model.a.e
        r1.m47497init()
    L_0x0105:
        r7 = r1
        if (r4 != 0) goto L_0x0114
        com.ksad.lottie.model.a.g r4 = new com.ksad.lottie.model.a.g
        com.ksad.lottie.e.d r14 = new com.ksad.lottie.e.d
        r15 = 1065353216(0x3f800000, float:1.0)
        r14.m47468init(r15, r15)
        r4.m47501init(r14)
    L_0x0114:
        r9 = r4
        if (r5 != 0) goto L_0x011c
        com.ksad.lottie.model.a.d r5 = new com.ksad.lottie.model.a.d
        r5.m47495init()
    L_0x011c:
        r11 = r5
        com.ksad.lottie.model.a.l r14 = new com.ksad.lottie.model.a.l
        r6 = r14
        r6.m47508init(r7, r8, r9, r10, r11, r12, r13)
        return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ksad.lottie.p302c.C3688m.m15293a(android.util.JsonReader, com.ksad.lottie.d):com.ksad.lottie.model.a.l");
    }
}
