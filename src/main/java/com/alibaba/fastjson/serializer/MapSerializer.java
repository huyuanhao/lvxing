package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* renamed from: com.alibaba.fastjson.serializer.am */
public class MapSerializer extends SerializeFilterable implements ObjectSerializer {
    /* renamed from: a */
    public static MapSerializer f2862a = new MapSerializer();
    /* renamed from: b */
    private static final int f2863b = SerializerFeature.m2926of(new SerializerFeature[]{SerializerFeature.BrowserCompatible, SerializerFeature.WriteNonStringKeyAsString, SerializerFeature.BrowserSecure});

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        mo11346a(agVar, obj, obj2, type, i, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00e6, code lost:
            if (mo11358a(r8, r0, (java.lang.String) r1) == false) goto L_0x00e8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01fc A[Catch:{ all -> 0x02fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0215 A[Catch:{ all -> 0x02fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0248 A[Catch:{ all -> 0x02fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x025f A[Catch:{ all -> 0x02fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0282 A[Catch:{ all -> 0x02fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x028c A[Catch:{ all -> 0x02fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x02f7  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a7 A[Catch:{ all -> 0x02fd }] */
    /* renamed from: a */
    public void mo11346a(com.alibaba.fastjson.serializer.JSONSerializer r24, java.lang.Object r25, java.lang.Object r26, java.lang.reflect.Type r27, int r28, boolean r29) throws java.io.IOException {
        /*
        r23 = this;
        r7 = r23
        r8 = r24
        r0 = r25
        r9 = r27
        r10 = r28
        com.alibaba.fastjson.serializer.ba r11 = r8.f2846b
        if (r0 != 0) goto L_0x0012
        r11.mo11396b()
        return
    L_0x0012:
        r1 = r0
        java.util.Map r1 = (java.util.Map) r1
        com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.MapSortField
        int r2 = r2.mask
        int r3 = r11.f2910c
        r3 = r3 & r2
        if (r3 != 0) goto L_0x0024
        r2 = r2 & r10
        if (r2 == 0) goto L_0x0022
        goto L_0x0024
    L_0x0022:
        r12 = r1
        goto L_0x003c
    L_0x0024:
        boolean r2 = r1 instanceof com.alibaba.fastjson.JSONObject
        if (r2 == 0) goto L_0x002e
        com.alibaba.fastjson.JSONObject r1 = (com.alibaba.fastjson.JSONObject) r1
        java.util.Map r1 = r1.getInnerMap()
    L_0x002e:
        boolean r2 = r1 instanceof java.util.SortedMap
        if (r2 != 0) goto L_0x0022
        boolean r2 = r1 instanceof java.util.LinkedHashMap
        if (r2 != 0) goto L_0x0022
        java.util.TreeMap r2 = new java.util.TreeMap     // Catch:{ Exception -> 0x0022 }
        r2.<init>(r1)     // Catch:{ Exception -> 0x0022 }
        r12 = r2
    L_0x003c:
        boolean r1 = r24.mo11319a(r25)
        if (r1 == 0) goto L_0x0046
        r24.mo11322b(r25)
        return
    L_0x0046:
        com.alibaba.fastjson.serializer.av r13 = r8.f2848d
        r14 = 0
        r1 = r26
        r8.mo11312a(r13, r0, r1, r14)
        if (r29 != 0) goto L_0x0055
        r1 = 123(0x7b, float:1.72E-43)
        r11.write(r1)     // Catch:{ all -> 0x02fd }
    L_0x0055:
        r24.mo11324c()     // Catch:{ all -> 0x02fd }
        com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch:{ all -> 0x02fd }
        boolean r1 = r11.mo11391a(r1)     // Catch:{ all -> 0x02fd }
        r15 = 1
        if (r1 == 0) goto L_0x0090
        com.alibaba.fastjson.serializer.ax r1 = r8.f2845a     // Catch:{ all -> 0x02fd }
        java.lang.String r1 = r1.f2889b     // Catch:{ all -> 0x02fd }
        java.lang.Class r2 = r12.getClass()     // Catch:{ all -> 0x02fd }
        java.lang.Class<com.alibaba.fastjson.JSONObject> r3 = com.alibaba.fastjson.JSONObject.class
        if (r2 == r3) goto L_0x0075
        java.lang.Class<java.util.HashMap> r3 = java.util.HashMap.class
        if (r2 == r3) goto L_0x0075
        java.lang.Class<java.util.LinkedHashMap> r3 = java.util.LinkedHashMap.class
        if (r2 != r3) goto L_0x007d
    L_0x0075:
        boolean r2 = r12.containsKey(r1)     // Catch:{ all -> 0x02fd }
        if (r2 == 0) goto L_0x007d
        r2 = 1
        goto L_0x007e
    L_0x007d:
        r2 = 0
    L_0x007e:
        if (r2 != 0) goto L_0x0090
        r11.mo11404c(r1)     // Catch:{ all -> 0x02fd }
        java.lang.Class r1 = r25.getClass()     // Catch:{ all -> 0x02fd }
        java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x02fd }
        r11.mo11384a(r1)     // Catch:{ all -> 0x02fd }
        r1 = 0
        goto L_0x0091
    L_0x0090:
        r1 = 1
    L_0x0091:
        java.util.Set r2 = r12.entrySet()     // Catch:{ all -> 0x02fd }
        java.util.Iterator r16 = r2.iterator()     // Catch:{ all -> 0x02fd }
        r17 = 0
        r18 = r1
        r6 = r17
        r19 = r6
    L_0x00a1:
        boolean r1 = r16.hasNext()     // Catch:{ all -> 0x02fd }
        if (r1 == 0) goto L_0x02df
        java.lang.Object r1 = r16.next()     // Catch:{ all -> 0x02fd }
        java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x02fd }
        java.lang.Object r5 = r1.getValue()     // Catch:{ all -> 0x02fd }
        java.lang.Object r1 = r1.getKey()     // Catch:{ all -> 0x02fd }
        java.util.List r2 = r8.f2900l     // Catch:{ all -> 0x02fd }
        if (r2 == 0) goto L_0x00ec
        int r2 = r2.size()     // Catch:{ all -> 0x02fd }
        if (r2 <= 0) goto L_0x00ec
        if (r1 == 0) goto L_0x00df
        boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x02fd }
        if (r2 == 0) goto L_0x00c6
        goto L_0x00df
    L_0x00c6:
        java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x02fd }
        boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x02fd }
        if (r2 != 0) goto L_0x00d4
        boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x02fd }
        if (r2 == 0) goto L_0x00ec
    L_0x00d4:
        java.lang.String r2 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x02fd }
        boolean r2 = r7.mo11358a(r8, r0, r2)     // Catch:{ all -> 0x02fd }
        if (r2 != 0) goto L_0x00ec
        goto L_0x00e8
    L_0x00df:
        r2 = r1
        java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x02fd }
        boolean r2 = r7.mo11358a(r8, r0, r2)     // Catch:{ all -> 0x02fd }
        if (r2 != 0) goto L_0x00ec
    L_0x00e8:
        r22 = r6
        goto L_0x023d
    L_0x00ec:
        java.util.List r2 = r7.f2900l     // Catch:{ all -> 0x02fd }
        if (r2 == 0) goto L_0x0120
        int r2 = r2.size()     // Catch:{ all -> 0x02fd }
        if (r2 <= 0) goto L_0x0120
        if (r1 == 0) goto L_0x0116
        boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x02fd }
        if (r2 == 0) goto L_0x00fd
        goto L_0x0116
    L_0x00fd:
        java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x02fd }
        boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x02fd }
        if (r2 != 0) goto L_0x010b
        boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x02fd }
        if (r2 == 0) goto L_0x0120
    L_0x010b:
        java.lang.String r2 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x02fd }
        boolean r2 = r7.mo11358a(r8, r0, r2)     // Catch:{ all -> 0x02fd }
        if (r2 != 0) goto L_0x0120
        goto L_0x00e8
    L_0x0116:
        r2 = r1
        java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x02fd }
        boolean r2 = r7.mo11358a(r8, r0, r2)     // Catch:{ all -> 0x02fd }
        if (r2 != 0) goto L_0x0120
        goto L_0x00e8
    L_0x0120:
        java.util.List r2 = r8.f2897i     // Catch:{ all -> 0x02fd }
        if (r2 == 0) goto L_0x0154
        int r2 = r2.size()     // Catch:{ all -> 0x02fd }
        if (r2 <= 0) goto L_0x0154
        if (r1 == 0) goto L_0x014a
        boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x02fd }
        if (r2 == 0) goto L_0x0131
        goto L_0x014a
    L_0x0131:
        java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x02fd }
        boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x02fd }
        if (r2 != 0) goto L_0x013f
        boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x02fd }
        if (r2 == 0) goto L_0x0154
    L_0x013f:
        java.lang.String r2 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x02fd }
        boolean r2 = r7.mo11359a(r8, r0, r2, r5)     // Catch:{ all -> 0x02fd }
        if (r2 != 0) goto L_0x0154
        goto L_0x00e8
    L_0x014a:
        r2 = r1
        java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x02fd }
        boolean r2 = r7.mo11359a(r8, r0, r2, r5)     // Catch:{ all -> 0x02fd }
        if (r2 != 0) goto L_0x0154
        goto L_0x00e8
    L_0x0154:
        java.util.List r2 = r7.f2897i     // Catch:{ all -> 0x02fd }
        if (r2 == 0) goto L_0x018a
        int r2 = r2.size()     // Catch:{ all -> 0x02fd }
        if (r2 <= 0) goto L_0x018a
        if (r1 == 0) goto L_0x017f
        boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x02fd }
        if (r2 == 0) goto L_0x0165
        goto L_0x017f
    L_0x0165:
        java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x02fd }
        boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x02fd }
        if (r2 != 0) goto L_0x0173
        boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x02fd }
        if (r2 == 0) goto L_0x018a
    L_0x0173:
        java.lang.String r2 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x02fd }
        boolean r2 = r7.mo11359a(r8, r0, r2, r5)     // Catch:{ all -> 0x02fd }
        if (r2 != 0) goto L_0x018a
        goto L_0x00e8
    L_0x017f:
        r2 = r1
        java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x02fd }
        boolean r2 = r7.mo11359a(r8, r0, r2, r5)     // Catch:{ all -> 0x02fd }
        if (r2 != 0) goto L_0x018a
        goto L_0x00e8
    L_0x018a:
        java.util.List r2 = r8.f2899k     // Catch:{ all -> 0x02fd }
        if (r2 == 0) goto L_0x01b8
        int r2 = r2.size()     // Catch:{ all -> 0x02fd }
        if (r2 <= 0) goto L_0x01b8
        if (r1 == 0) goto L_0x01b2
        boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x02fd }
        if (r2 == 0) goto L_0x019b
        goto L_0x01b2
    L_0x019b:
        java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x02fd }
        boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x02fd }
        if (r2 != 0) goto L_0x01a9
        boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x02fd }
        if (r2 == 0) goto L_0x01b8
    L_0x01a9:
        java.lang.String r1 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x02fd }
        java.lang.String r1 = r7.mo11360b(r8, r0, r1, r5)     // Catch:{ all -> 0x02fd }
        goto L_0x01b8
    L_0x01b2:
        java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x02fd }
        java.lang.String r1 = r7.mo11360b(r8, r0, r1, r5)     // Catch:{ all -> 0x02fd }
    L_0x01b8:
        java.util.List r2 = r7.f2899k     // Catch:{ all -> 0x02fd }
        if (r2 == 0) goto L_0x01e6
        int r2 = r2.size()     // Catch:{ all -> 0x02fd }
        if (r2 <= 0) goto L_0x01e6
        if (r1 == 0) goto L_0x01e0
        boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x02fd }
        if (r2 == 0) goto L_0x01c9
        goto L_0x01e0
    L_0x01c9:
        java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x02fd }
        boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x02fd }
        if (r2 != 0) goto L_0x01d7
        boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x02fd }
        if (r2 == 0) goto L_0x01e6
    L_0x01d7:
        java.lang.String r1 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x02fd }
        java.lang.String r1 = r7.mo11360b(r8, r0, r1, r5)     // Catch:{ all -> 0x02fd }
        goto L_0x01e6
    L_0x01e0:
        java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x02fd }
        java.lang.String r1 = r7.mo11360b(r8, r0, r1, r5)     // Catch:{ all -> 0x02fd }
    L_0x01e6:
        r4 = r1
        if (r4 == 0) goto L_0x021d
        boolean r1 = r4 instanceof java.lang.String     // Catch:{ all -> 0x02fd }
        if (r1 == 0) goto L_0x01ee
        goto L_0x021d
    L_0x01ee:
        boolean r1 = r4 instanceof java.util.Map     // Catch:{ all -> 0x02fd }
        if (r1 != 0) goto L_0x01f9
        boolean r1 = r4 instanceof java.util.Collection     // Catch:{ all -> 0x02fd }
        if (r1 == 0) goto L_0x01f7
        goto L_0x01f9
    L_0x01f7:
        r1 = 0
        goto L_0x01fa
    L_0x01f9:
        r1 = 1
    L_0x01fa:
        if (r1 != 0) goto L_0x0215
        java.lang.String r20 = com.alibaba.fastjson.JSON.toJSONString(r4)     // Catch:{ all -> 0x02fd }
        r3 = 0
        r1 = r23
        r2 = r24
        r14 = r4
        r4 = r25
        r21 = r5
        r5 = r20
        r22 = r6
        r6 = r21
        java.lang.Object r1 = r1.mo11356a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x02fd }
        goto L_0x0232
    L_0x0215:
        r14 = r4
        r21 = r5
        r22 = r6
        r3 = r21
        goto L_0x0233
    L_0x021d:
        r14 = r4
        r21 = r5
        r22 = r6
        r3 = 0
        r5 = r14
        java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x02fd }
        r1 = r23
        r2 = r24
        r4 = r25
        r6 = r21
        java.lang.Object r1 = r1.mo11356a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x02fd }
    L_0x0232:
        r3 = r1
    L_0x0233:
        if (r3 != 0) goto L_0x0242
        int r1 = com.alibaba.fastjson.serializer.SerializerFeature.WRITE_MAP_NULL_FEATURES     // Catch:{ all -> 0x02fd }
        boolean r1 = r11.mo11390a(r1)     // Catch:{ all -> 0x02fd }
        if (r1 != 0) goto L_0x0242
    L_0x023d:
        r6 = r22
        r14 = 0
        goto L_0x00a1
    L_0x0242:
        boolean r1 = r14 instanceof java.lang.String     // Catch:{ all -> 0x02fd }
        r2 = 44
        if (r1 == 0) goto L_0x025f
        r4 = r14
        java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x02fd }
        if (r18 != 0) goto L_0x0250
        r11.write(r2)     // Catch:{ all -> 0x02fd }
    L_0x0250:
        com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ all -> 0x02fd }
        boolean r1 = r11.mo11391a(r1)     // Catch:{ all -> 0x02fd }
        if (r1 == 0) goto L_0x025b
        r24.mo11327e()     // Catch:{ all -> 0x02fd }
    L_0x025b:
        r11.mo11386a(r4, r15)     // Catch:{ all -> 0x02fd }
        goto L_0x0280
    L_0x025f:
        if (r18 != 0) goto L_0x0264
        r11.write(r2)     // Catch:{ all -> 0x02fd }
    L_0x0264:
        int r1 = f2863b     // Catch:{ all -> 0x02fd }
        boolean r1 = r11.mo11390a(r1)     // Catch:{ all -> 0x02fd }
        if (r1 == 0) goto L_0x0278
        boolean r1 = r14 instanceof java.lang.Enum     // Catch:{ all -> 0x02fd }
        if (r1 != 0) goto L_0x0278
        java.lang.String r1 = com.alibaba.fastjson.JSON.toJSONString(r14)     // Catch:{ all -> 0x02fd }
        r8.mo11323b(r1)     // Catch:{ all -> 0x02fd }
        goto L_0x027b
    L_0x0278:
        r8.mo11325c(r14)     // Catch:{ all -> 0x02fd }
    L_0x027b:
        r1 = 58
        r11.write(r1)     // Catch:{ all -> 0x02fd }
    L_0x0280:
        if (r3 != 0) goto L_0x028c
        r11.mo11396b()     // Catch:{ all -> 0x02fd }
        r6 = r22
    L_0x0287:
        r14 = 0
        r18 = 0
        goto L_0x00a1
    L_0x028c:
        java.lang.Class r1 = r3.getClass()     // Catch:{ all -> 0x02fd }
        r2 = r22
        if (r1 == r2) goto L_0x029c
        com.alibaba.fastjson.serializer.aq r2 = r8.mo11309a(r1)     // Catch:{ all -> 0x02fd }
        r18 = r1
        r6 = r2
        goto L_0x02a0
    L_0x029c:
        r18 = r2
        r6 = r19
    L_0x02a0:
        com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch:{ all -> 0x02fd }
        boolean r1 = com.alibaba.fastjson.serializer.SerializerFeature.isEnabled(r10, r1)     // Catch:{ all -> 0x02fd }
        if (r1 == 0) goto L_0x02cf
        boolean r1 = r6 instanceof com.alibaba.fastjson.serializer.JavaBeanSerializer     // Catch:{ all -> 0x02fd }
        if (r1 == 0) goto L_0x02cf
        boolean r1 = r9 instanceof java.lang.reflect.ParameterizedType     // Catch:{ all -> 0x02fd }
        if (r1 == 0) goto L_0x02bf
        r1 = r9
        java.lang.reflect.ParameterizedType r1 = (java.lang.reflect.ParameterizedType) r1     // Catch:{ all -> 0x02fd }
        java.lang.reflect.Type[] r1 = r1.getActualTypeArguments()     // Catch:{ all -> 0x02fd }
        int r2 = r1.length     // Catch:{ all -> 0x02fd }
        r4 = 2
        if (r2 != r4) goto L_0x02bf
        r1 = r1[r15]     // Catch:{ all -> 0x02fd }
        r5 = r1
        goto L_0x02c1
    L_0x02bf:
        r5 = r17
    L_0x02c1:
        r1 = r6
        com.alibaba.fastjson.serializer.ah r1 = (com.alibaba.fastjson.serializer.JavaBeanSerializer) r1     // Catch:{ all -> 0x02fd }
        r2 = r24
        r4 = r14
        r19 = r6
        r6 = r28
        r1.mo11343b(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x02fd }
        goto L_0x02dc
    L_0x02cf:
        r19 = r6
        r5 = 0
        r1 = r19
        r2 = r24
        r4 = r14
        r6 = r28
        r1.mo11198a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x02fd }
    L_0x02dc:
        r6 = r18
        goto L_0x0287
    L_0x02df:
        r8.f2848d = r13
        r24.mo11326d()
        com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat
        boolean r0 = r11.mo11391a(r0)
        if (r0 == 0) goto L_0x02f5
        int r0 = r12.size()
        if (r0 <= 0) goto L_0x02f5
        r24.mo11327e()
    L_0x02f5:
        if (r29 != 0) goto L_0x02fc
        r0 = 125(0x7d, float:1.75E-43)
        r11.write(r0)
    L_0x02fc:
        return
    L_0x02fd:
        r0 = move-exception
        r8.f2848d = r13
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.MapSerializer.mo11346a(com.alibaba.fastjson.serializer.ag, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }
}
