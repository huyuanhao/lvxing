package com.alibaba.fastjson.parser.p066a;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.Type;

/* renamed from: com.alibaba.fastjson.parser.a.b */
public abstract class AbstractDateDeserializer extends ContextObjectDeserializer implements ObjectDeserializer {
    /* renamed from: a */
    public abstract <T> T mo11163a(DefaultJSONParser aVar, Type type, Object obj, Object obj2);

    /* renamed from: a */
    public <T> T mo11161a(DefaultJSONParser aVar, Type type, Object obj) {
        return mo11164a(aVar, type, obj, null, 0);
    }

    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v1, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r5v2, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r5v3, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r5v4, types: [java.lang.Long] */
    /* JADX WARNING: type inference failed for: r2v4, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v7, types: [java.util.Date] */
    /* JADX WARNING: type inference failed for: r13v22, types: [java.util.Date] */
    /* JADX WARNING: type inference failed for: r13v23 */
    /* JADX WARNING: type inference failed for: r5v7 */
    /* JADX WARNING: type inference failed for: r13v24, types: [java.util.Date] */
    /* JADX WARNING: type inference failed for: r5v8, types: [java.lang.Long] */
    /* JADX WARNING: type inference failed for: r5v9 */
    /* JADX WARNING: type inference failed for: r5v10 */
    /* JADX WARNING: type inference failed for: r5v11 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r13v30 */
    /* JADX WARNING: type inference failed for: r13v31 */
    /* JADX WARNING: type inference failed for: r5v12 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v6
  assigns: []
  uses: []
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Unknown variable types count: 10 */
    /* renamed from: a */
    public <T> T mo11164a(com.alibaba.fastjson.parser.DefaultJSONParser r10, java.lang.reflect.Type r11, java.lang.Object r12, java.lang.String r13, int r14) {
        /*
        r9 = this;
        java.lang.String r14 = "yyyy-MM-dd'T'HH:mm:ss"
        java.lang.String r0 = "yyyy-MM-dd'T'HH:mm:ss.SSS"
        com.alibaba.fastjson.parser.b r1 = r10.f2689d
        int r2 = r1.mo11205a()
        r3 = 16
        r4 = 2
        r5 = 0
        if (r2 != r4) goto L_0x001d
        long r13 = r1.mo11238q()
        java.lang.Long r5 = java.lang.Long.valueOf(r13)
        r1.mo11211a(r3)
        goto L_0x0160
    L_0x001d:
        int r2 = r1.mo11205a()
        r6 = 4
        if (r2 != r6) goto L_0x009b
        java.lang.String r2 = r1.mo11233l()
        if (r13 == 0) goto L_0x0075
        java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat     // Catch:{ IllegalArgumentException -> 0x0035 }
        java.util.Locale r6 = com.alibaba.fastjson.JSON.defaultLocale     // Catch:{ IllegalArgumentException -> 0x0035 }
        r4.<init>(r13, r6)     // Catch:{ IllegalArgumentException -> 0x0035 }
        r8 = r4
        r4 = r13
        r13 = r8
        goto L_0x0056
        java.lang.String r4 = "yyyy-MM-ddTHH:mm:ss.SSS"
        boolean r4 = r13.equals(r4)
        if (r4 == 0) goto L_0x0045
        java.text.SimpleDateFormat r13 = new java.text.SimpleDateFormat
        r13.<init>(r0)
        r4 = r0
        goto L_0x0056
    L_0x0045:
        java.lang.String r4 = "yyyy-MM-ddTHH:mm:ss"
        boolean r4 = r13.equals(r4)
        if (r4 == 0) goto L_0x0054
        java.text.SimpleDateFormat r13 = new java.text.SimpleDateFormat
        r13.<init>(r14)
        r4 = r14
        goto L_0x0056
    L_0x0054:
        r4 = r13
        r13 = r5
    L_0x0056:
        java.util.Date r13 = r13.parse(r2)     // Catch:{ ParseException -> 0x005c }
    L_0x005a:
        r5 = r13
        goto L_0x0075
    L_0x005c:
        boolean r13 = r4.equals(r0)
        if (r13 == 0) goto L_0x0075
        int r13 = r2.length()
        r0 = 19
        if (r13 != r0) goto L_0x0075
        java.text.SimpleDateFormat r13 = new java.text.SimpleDateFormat     // Catch:{ ParseException -> 0x0074 }
        r13.<init>(r14)     // Catch:{ ParseException -> 0x0074 }
        java.util.Date r13 = r13.parse(r2)     // Catch:{ ParseException -> 0x0074 }
        goto L_0x005a
    L_0x0075:
        if (r5 != 0) goto L_0x0160
        r1.mo11211a(r3)
        com.alibaba.fastjson.parser.Feature r13 = com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat
        boolean r13 = r1.mo11212a(r13)
        if (r13 == 0) goto L_0x0098
        com.alibaba.fastjson.parser.e r13 = new com.alibaba.fastjson.parser.e
        r13.m41636init(r2)
        boolean r14 = r13.mo11284K()
        if (r14 == 0) goto L_0x0095
        java.util.Calendar r14 = r13.mo11251E()
        java.util.Date r2 = r14.getTime()
    L_0x0095:
        r13.close()
    L_0x0098:
        r5 = r2
        goto L_0x0160
    L_0x009b:
        int r13 = r1.mo11205a()
        r14 = 8
        if (r13 != r14) goto L_0x00a8
        r1.mo11222d()
        goto L_0x0160
    L_0x00a8:
        int r13 = r1.mo11205a()
        r14 = 12
        r0 = 13
        r2 = 17
        java.lang.String r7 = "syntax error"
        if (r13 != r14) goto L_0x0123
        r1.mo11222d()
        int r13 = r1.mo11205a()
        if (r13 != r6) goto L_0x011d
        java.lang.String r13 = r1.mo11233l()
        java.lang.String r14 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY
        boolean r13 = r14.equals(r13)
        if (r13 == 0) goto L_0x00ea
        r1.mo11222d()
        r10.mo11139b(r2)
        java.lang.String r13 = r1.mo11233l()
        com.alibaba.fastjson.parser.h r14 = r10.mo11146d()
        int r2 = r1.mo11246y()
        java.lang.Class r13 = r14.mo11294a(r13, r5, r2)
        if (r13 == 0) goto L_0x00e4
        r11 = r13
    L_0x00e4:
        r10.mo11139b(r6)
        r10.mo11139b(r3)
    L_0x00ea:
        r1.mo11219c(r4)
        int r13 = r1.mo11205a()
        if (r13 != r4) goto L_0x0102
        long r13 = r1.mo11238q()
        r1.mo11222d()
        java.lang.Long r5 = java.lang.Long.valueOf(r13)
        r10.mo11139b(r0)
        goto L_0x0160
    L_0x0102:
        com.alibaba.fastjson.JSONException r10 = new com.alibaba.fastjson.JSONException
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r12 = "syntax error : "
        r11.append(r12)
        java.lang.String r12 = r1.mo11214b()
        r11.append(r12)
        java.lang.String r11 = r11.toString()
        r10.m41526init(r11)
        throw r10
    L_0x011d:
        com.alibaba.fastjson.JSONException r10 = new com.alibaba.fastjson.JSONException
        r10.m41526init(r7)
        throw r10
    L_0x0123:
        int r13 = r10.mo11147e()
        if (r13 != r4) goto L_0x015c
        r13 = 0
        r10.mo11122a(r13)
        r10.mo11139b(r3)
        int r13 = r1.mo11205a()
        if (r13 != r6) goto L_0x0156
        java.lang.String r13 = r1.mo11233l()
        java.lang.String r14 = "val"
        boolean r13 = r14.equals(r13)
        if (r13 == 0) goto L_0x0150
        r1.mo11222d()
        r10.mo11139b(r2)
        java.lang.Object r5 = r10.mo11155m()
        r10.mo11139b(r0)
        goto L_0x0160
    L_0x0150:
        com.alibaba.fastjson.JSONException r10 = new com.alibaba.fastjson.JSONException
        r10.m41526init(r7)
        throw r10
    L_0x0156:
        com.alibaba.fastjson.JSONException r10 = new com.alibaba.fastjson.JSONException
        r10.m41526init(r7)
        throw r10
    L_0x015c:
        java.lang.Object r5 = r10.mo11155m()
    L_0x0160:
        java.lang.Object r10 = r9.mo11163a(r10, r11, r12, r5)
        return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.p066a.AbstractDateDeserializer.mo11164a(com.alibaba.fastjson.parser.a, java.lang.reflect.Type, java.lang.Object, java.lang.String, int):java.lang.Object");
    }
}
