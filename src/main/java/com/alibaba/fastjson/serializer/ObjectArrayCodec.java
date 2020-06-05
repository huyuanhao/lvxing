package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.p066a.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;

/* renamed from: com.alibaba.fastjson.serializer.ap */
public class ObjectArrayCodec implements ObjectDeserializer, ObjectSerializer {
    /* renamed from: a */
    public static final ObjectArrayCodec f2868a = new ObjectArrayCodec();

    /* renamed from: g_ */
    public int mo11162g_() {
        return 14;
    }

    /* renamed from: a */
    public final void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        JSONSerializer agVar2 = agVar;
        Object obj3 = obj;
        SerializeWriter baVar = agVar2.f2846b;
        Object[] objArr = (Object[]) obj3;
        if (obj3 == null) {
            baVar.mo11399b(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        int length = objArr.length;
        int i2 = length - 1;
        if (i2 == -1) {
            baVar.append((CharSequence) "[]");
            return;
        }
        SerialContext avVar = agVar2.f2848d;
        agVar2.mo11312a(avVar, obj3, obj2, 0);
        try {
            baVar.append('[');
            if (baVar.mo11391a(SerializerFeature.PrettyFormat)) {
                agVar.mo11324c();
                agVar.mo11327e();
                for (int i3 = 0; i3 < length; i3++) {
                    if (i3 != 0) {
                        baVar.write(44);
                        agVar.mo11327e();
                    }
                    agVar2.mo11325c(objArr[i3]);
                }
                agVar.mo11326d();
                agVar.mo11327e();
                baVar.write(93);
                return;
            }
            Class cls = null;
            ObjectSerializer aqVar = null;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj4 = objArr[i4];
                if (obj4 == null) {
                    baVar.append((CharSequence) "null,");
                } else {
                    if (agVar2.mo11319a(obj4)) {
                        agVar2.mo11322b(obj4);
                    } else {
                        Class cls2 = obj4.getClass();
                        if (cls2 == cls) {
                            aqVar.mo11198a(agVar, obj4, null, null, 0);
                        } else {
                            ObjectSerializer a = agVar2.mo11309a(cls2);
                            Class cls3 = cls2;
                            a.mo11198a(agVar, obj4, null, null, 0);
                            aqVar = a;
                            cls = cls3;
                        }
                    }
                    baVar.append(',');
                }
            }
            Object obj5 = objArr[i2];
            if (obj5 == null) {
                baVar.append((CharSequence) "null]");
            } else {
                if (agVar2.mo11319a(obj5)) {
                    agVar2.mo11322b(obj5);
                } else {
                    agVar2.mo11314a(obj5, (Object) Integer.valueOf(i2));
                }
                baVar.append(']');
            }
            agVar2.f2848d = avVar;
        } finally {
            agVar2.f2848d = avVar;
        }
    }

    /* JADX WARNING: type inference failed for: r8v1, types: [T, byte[]] */
    /* JADX WARNING: type inference failed for: r9v1, types: [java.lang.reflect.Type] */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.lang.Class] */
    /* JADX WARNING: type inference failed for: r9v3, types: [java.lang.Class] */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r9v5, types: [java.lang.reflect.Type] */
    /* JADX WARNING: type inference failed for: r3v3, types: [java.lang.Class] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r3v4, types: [java.lang.Class] */
    /* JADX WARNING: type inference failed for: r3v6, types: [java.lang.Class<java.lang.Object>] */
    /* JADX WARNING: type inference failed for: r3v7, types: [java.lang.Class] */
    /* JADX WARNING: type inference failed for: r9v6 */
    /* JADX WARNING: type inference failed for: r9v7 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r8v1, types: [T, byte[]]
  assigns: [byte[]]
  uses: [?[], T]
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
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Unknown variable types count: 9 */
    /* renamed from: a */
    public <T> T mo11161a(com.alibaba.fastjson.parser.DefaultJSONParser r8, java.lang.reflect.Type r9, java.lang.Object r10) {
        /*
        r7 = this;
        com.alibaba.fastjson.parser.b r0 = r8.f2689d
        int r1 = r0.mo11205a()
        r2 = 16
        r3 = 0
        r4 = 8
        if (r1 != r4) goto L_0x0011
        r0.mo11211a(r2)
        return r3
    L_0x0011:
        r4 = 4
        if (r1 == r4) goto L_0x0090
        r4 = 26
        if (r1 != r4) goto L_0x001a
        goto L_0x0090
    L_0x001a:
        boolean r0 = r9 instanceof java.lang.reflect.GenericArrayType
        if (r0 == 0) goto L_0x007c
        java.lang.reflect.GenericArrayType r9 = (java.lang.reflect.GenericArrayType) r9
        java.lang.reflect.Type r9 = r9.getGenericComponentType()
        boolean r0 = r9 instanceof java.lang.reflect.TypeVariable
        if (r0 == 0) goto L_0x0077
        r0 = r9
        java.lang.reflect.TypeVariable r0 = (java.lang.reflect.TypeVariable) r0
        com.alibaba.fastjson.parser.g r1 = r8.mo11149g()
        java.lang.reflect.Type r1 = r1.f2797d
        boolean r2 = r1 instanceof java.lang.reflect.ParameterizedType
        r4 = 0
        if (r2 == 0) goto L_0x006c
        java.lang.reflect.ParameterizedType r1 = (java.lang.reflect.ParameterizedType) r1
        java.lang.reflect.Type r2 = r1.getRawType()
        boolean r5 = r2 instanceof java.lang.Class
        if (r5 == 0) goto L_0x0062
        java.lang.Class r2 = (java.lang.Class) r2
        java.lang.reflect.TypeVariable[] r2 = r2.getTypeParameters()
    L_0x0046:
        int r5 = r2.length
        if (r4 >= r5) goto L_0x0062
        r5 = r2[r4]
        java.lang.String r5 = r5.getName()
        java.lang.String r6 = r0.getName()
        boolean r5 = r5.equals(r6)
        if (r5 == 0) goto L_0x005f
        java.lang.reflect.Type[] r3 = r1.getActualTypeArguments()
        r3 = r3[r4]
    L_0x005f:
        int r4 = r4 + 1
        goto L_0x0046
    L_0x0062:
        boolean r0 = r3 instanceof java.lang.Class
        if (r0 == 0) goto L_0x0069
        java.lang.Class r3 = (java.lang.Class) r3
        goto L_0x0083
    L_0x0069:
        java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
        goto L_0x0083
    L_0x006c:
        java.lang.reflect.Type[] r0 = r0.getBounds()
        r0 = r0[r4]
        java.lang.Class r3 = com.alibaba.fastjson.util.TypeUtils.m3255d(r0)
        goto L_0x0083
    L_0x0077:
        java.lang.Class r3 = com.alibaba.fastjson.util.TypeUtils.m3255d(r9)
        goto L_0x0083
    L_0x007c:
        java.lang.Class r9 = (java.lang.Class) r9
        java.lang.Class r9 = r9.getComponentType()
        r3 = r9
    L_0x0083:
        com.alibaba.fastjson.JSONArray r0 = new com.alibaba.fastjson.JSONArray
        r0.m41522init()
        r8.mo11131a(r9, r0, r10)
        java.lang.Object r8 = r7.m3022a(r8, r3, r0)
        return r8
    L_0x0090:
        byte[] r8 = r0.mo11241t()
        r0.mo11211a(r2)
        int r10 = r8.length
        if (r10 != 0) goto L_0x009f
        java.lang.Class<byte[]> r10 = byte[].class
        if (r9 == r10) goto L_0x009f
        return r3
    L_0x009f:
        return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.ObjectArrayCodec.mo11161a(com.alibaba.fastjson.parser.a, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0057  */
    /* renamed from: a */
    private <T> T m3022a(com.alibaba.fastjson.parser.DefaultJSONParser r12, java.lang.Class<?> r13, com.alibaba.fastjson.JSONArray r14) {
        /*
        r11 = this;
        r0 = 0
        if (r14 != 0) goto L_0x0004
        return r0
    L_0x0004:
        int r1 = r14.size()
        java.lang.Object r2 = java.lang.reflect.Array.newInstance(r13, r1)
        r3 = 0
        r4 = 0
    L_0x000e:
        if (r4 >= r1) goto L_0x0065
        java.lang.Object r5 = r14.get(r4)
        if (r5 != r14) goto L_0x001a
        java.lang.reflect.Array.set(r2, r4, r2)
        goto L_0x0062
    L_0x001a:
        boolean r6 = r13.isArray()
        if (r6 == 0) goto L_0x0031
        boolean r6 = r13.isInstance(r5)
        if (r6 == 0) goto L_0x0027
        goto L_0x002d
    L_0x0027:
        com.alibaba.fastjson.JSONArray r5 = (com.alibaba.fastjson.JSONArray) r5
        java.lang.Object r5 = r11.m3022a(r12, r13, r5)
    L_0x002d:
        java.lang.reflect.Array.set(r2, r4, r5)
        goto L_0x0062
    L_0x0031:
        boolean r6 = r5 instanceof com.alibaba.fastjson.JSONArray
        if (r6 == 0) goto L_0x0054
        r6 = r5
        com.alibaba.fastjson.JSONArray r6 = (com.alibaba.fastjson.JSONArray) r6
        int r7 = r6.size()
        r8 = 0
        r9 = 0
    L_0x003e:
        if (r8 >= r7) goto L_0x004d
        java.lang.Object r10 = r6.get(r8)
        if (r10 != r14) goto L_0x004a
        r6.set(r4, r2)
        r9 = 1
    L_0x004a:
        int r8 = r8 + 1
        goto L_0x003e
    L_0x004d:
        if (r9 == 0) goto L_0x0054
        java.lang.Object[] r6 = r6.toArray()
        goto L_0x0055
    L_0x0054:
        r6 = r0
    L_0x0055:
        if (r6 != 0) goto L_0x005f
        com.alibaba.fastjson.parser.h r6 = r12.mo11146d()
        java.lang.Object r6 = com.alibaba.fastjson.util.TypeUtils.m3222a(r5, r13, r6)
    L_0x005f:
        java.lang.reflect.Array.set(r2, r4, r6)
    L_0x0062:
        int r4 = r4 + 1
        goto L_0x000e
    L_0x0065:
        r14.setRelatedArray(r2)
        r14.setComponentType(r13)
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.ObjectArrayCodec.m3022a(com.alibaba.fastjson.parser.a, java.lang.Class, com.alibaba.fastjson.JSONArray):java.lang.Object");
    }
}
