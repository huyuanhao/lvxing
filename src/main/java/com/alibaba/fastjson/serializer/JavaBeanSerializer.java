package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.alibaba.fastjson.serializer.ah */
public class JavaBeanSerializer extends SerializeFilterable implements ObjectSerializer {
    /* renamed from: a */
    protected final FieldSerializer[] f2855a;
    /* renamed from: b */
    protected final FieldSerializer[] f2856b;
    /* renamed from: c */
    protected SerializeBeanInfo f2857c;
    /* renamed from: d */
    private volatile transient long[] f2858d;
    /* renamed from: e */
    private volatile transient short[] f2859e;

    public JavaBeanSerializer(SerializeBeanInfo awVar) {
        this.f2857c = awVar;
        this.f2856b = new FieldSerializer[awVar.f2880f.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            FieldSerializer[] zVarArr = this.f2856b;
            if (i2 >= zVarArr.length) {
                break;
            }
            zVarArr[i2] = new FieldSerializer(awVar.f2875a, awVar.f2880f[i2]);
            i2++;
        }
        if (awVar.f2879e == awVar.f2880f) {
            this.f2855a = this.f2856b;
            return;
        }
        this.f2855a = new FieldSerializer[awVar.f2879e.length];
        while (true) {
            FieldSerializer[] zVarArr2 = this.f2855a;
            if (i < zVarArr2.length) {
                zVarArr2[i] = mo11333a(awVar.f2879e[i].f2992a);
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        mo11336a(agVar, obj, obj2, type, i, false);
    }

    /* renamed from: b */
    public void mo11343b(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        mo11336a(agVar, obj, obj2, type, i, false);
    }

    /* JADX INFO: used method not loaded: com.alibaba.fastjson.serializer.ba.a(com.alibaba.fastjson.serializer.SerializerFeature):null, types can be incorrect */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x037e, code lost:
            throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x039a, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:282:0x039b, code lost:
            r1 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x03d3, code lost:
            r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x03d4, code lost:
            r2 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x03db, code lost:
            r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x03dc, code lost:
            r2 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:304:0x03de, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x03df, code lost:
            r1 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00e8, code lost:
            if (r10.f3003l != false) goto L_0x037f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x011a, code lost:
            if (r8.mo11320a(r11, r9) != false) goto L_0x037f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0123, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0124, code lost:
            r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x012b, code lost:
            if (r12.mo11391a(com.alibaba.fastjson.serializer.SerializerFeature.IgnoreErrorGetter) != false) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x012d, code lost:
            r0 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x0356 A[Catch:{ InvocationTargetException -> 0x0123, Exception -> 0x039a, all -> 0x03d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x037b A[Catch:{ InvocationTargetException -> 0x0123, Exception -> 0x039a, all -> 0x03d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x03b0  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x03c9 A[Catch:{ Exception -> 0x03d7, all -> 0x03d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x03d3 A[ExcHandler: all (th java.lang.Throwable), PHI: r20 
  PHI: (r20v2 com.alibaba.fastjson.serializer.av) = (r20v0 com.alibaba.fastjson.serializer.av), (r20v3 com.alibaba.fastjson.serializer.av), (r20v3 com.alibaba.fastjson.serializer.av), (r20v3 com.alibaba.fastjson.serializer.av), (r20v3 com.alibaba.fastjson.serializer.av), (r20v3 com.alibaba.fastjson.serializer.av), (r20v3 com.alibaba.fastjson.serializer.av), (r20v3 com.alibaba.fastjson.serializer.av), (r20v3 com.alibaba.fastjson.serializer.av), (r20v3 com.alibaba.fastjson.serializer.av) binds: {(r20v0 com.alibaba.fastjson.serializer.av)=B:288:0x03b1, (r20v3 com.alibaba.fastjson.serializer.av)=B:64:0x00dc, (r20v3 com.alibaba.fastjson.serializer.av)=B:65:?, (r20v3 com.alibaba.fastjson.serializer.av)=B:75:0x00f6, (r20v3 com.alibaba.fastjson.serializer.av)=B:107:0x014c, (r20v3 com.alibaba.fastjson.serializer.av)=B:102:0x013c, (r20v3 com.alibaba.fastjson.serializer.av)=B:92:0x0125, (r20v3 com.alibaba.fastjson.serializer.av)=B:83:0x010c, (r20v3 com.alibaba.fastjson.serializer.av)=B:68:0x00e6, (r20v3 com.alibaba.fastjson.serializer.av)=B:69:?} A[DONT_GENERATE, DONT_INLINE], Splitter:B:75:0x00f6] */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x03db A[ExcHandler: all (th java.lang.Throwable), PHI: r14 
  PHI: (r14v2 com.alibaba.fastjson.serializer.av) = (r14v3 com.alibaba.fastjson.serializer.av), (r14v3 com.alibaba.fastjson.serializer.av), (r14v0 com.alibaba.fastjson.serializer.av) binds: {(r14v3 com.alibaba.fastjson.serializer.av)=B:61:0x00d2, (r14v3 com.alibaba.fastjson.serializer.av)=B:62:?, (r14v0 com.alibaba.fastjson.serializer.av)=B:22:0x0059} A[DONT_GENERATE, DONT_INLINE], Splitter:B:22:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x03e5 A[SYNTHETIC, Splitter:B:309:0x03e5] */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x0405 A[Catch:{ all -> 0x043d }] */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x041f A[Catch:{ all -> 0x043d }] */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x0387 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a6 A[Catch:{ Exception -> 0x03de, all -> 0x03db }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a9 A[Catch:{ Exception -> 0x03de, all -> 0x03db }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bd A[Catch:{ Exception -> 0x03de, all -> 0x03db }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00bf A[Catch:{ Exception -> 0x03de, all -> 0x03db }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00d2 A[SYNTHETIC, Splitter:B:61:0x00d2] */
    /* renamed from: a */
    public void mo11336a(com.alibaba.fastjson.serializer.JSONSerializer r27, java.lang.Object r28, java.lang.Object r29, java.lang.reflect.Type r30, int r31, boolean r32) throws java.io.IOException {
        /*
        r26 = this;
        r7 = r26
        r8 = r27
        r9 = r28
        r10 = r29
        r11 = r30
        r0 = r31
        com.alibaba.fastjson.serializer.ba r12 = r8.f2846b
        if (r9 != 0) goto L_0x0014
        r12.mo11396b()
        return
    L_0x0014:
        boolean r1 = r7.mo11339a(r8, r9, r0)
        if (r1 == 0) goto L_0x001b
        return
    L_0x001b:
        boolean r1 = r12.f2913f
        if (r1 == 0) goto L_0x0022
        com.alibaba.fastjson.serializer.z[] r1 = r7.f2856b
        goto L_0x0024
    L_0x0022:
        com.alibaba.fastjson.serializer.z[] r1 = r7.f2855a
    L_0x0024:
        r13 = r1
        com.alibaba.fastjson.serializer.av r14 = r8.f2848d
        com.alibaba.fastjson.serializer.aw r1 = r7.f2857c
        java.lang.Class<?> r1 = r1.f2875a
        boolean r1 = r1.isEnum()
        if (r1 != 0) goto L_0x0041
        com.alibaba.fastjson.serializer.aw r1 = r7.f2857c
        int r5 = r1.f2881g
        r1 = r27
        r2 = r14
        r3 = r28
        r4 = r29
        r6 = r31
        r1.mo11313a(r2, r3, r4, r5, r6)
    L_0x0041:
        boolean r15 = r7.mo11338a(r8, r0)
        if (r15 == 0) goto L_0x004a
        r1 = 91
        goto L_0x004c
    L_0x004a:
        r1 = 123(0x7b, float:1.72E-43)
    L_0x004c:
        if (r15 == 0) goto L_0x0053
        r2 = 93
        r6 = 93
        goto L_0x0057
    L_0x0053:
        r2 = 125(0x7d, float:1.75E-43)
        r6 = 125(0x7d, float:1.75E-43)
    L_0x0057:
        if (r32 != 0) goto L_0x005c
        r12.append(r1)     // Catch:{ Exception -> 0x03de, all -> 0x03db }
    L_0x005c:
        int r1 = r13.length     // Catch:{ Exception -> 0x03de, all -> 0x03db }
        if (r1 <= 0) goto L_0x006d
        com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ Exception -> 0x03de, all -> 0x03db }
        boolean r1 = r12.mo11391a(r1)     // Catch:{ Exception -> 0x03de, all -> 0x03db }
        if (r1 == 0) goto L_0x006d
        r27.mo11324c()     // Catch:{ Exception -> 0x03de, all -> 0x03db }
        r27.mo11327e()     // Catch:{ Exception -> 0x03de, all -> 0x03db }
    L_0x006d:
        com.alibaba.fastjson.serializer.aw r1 = r7.f2857c     // Catch:{ Exception -> 0x03de, all -> 0x03db }
        int r1 = r1.f2881g     // Catch:{ Exception -> 0x03de, all -> 0x03db }
        com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch:{ Exception -> 0x03de, all -> 0x03db }
        int r2 = r2.mask     // Catch:{ Exception -> 0x03de, all -> 0x03db }
        r1 = r1 & r2
        r5 = 1
        if (r1 != 0) goto L_0x0086
        com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch:{ Exception -> 0x03de, all -> 0x03db }
        int r1 = r1.mask     // Catch:{ Exception -> 0x03de, all -> 0x03db }
        r0 = r0 & r1
        if (r0 != 0) goto L_0x0086
        boolean r0 = r8.mo11320a(r11, r9)     // Catch:{ Exception -> 0x03de, all -> 0x03db }
        if (r0 == 0) goto L_0x00a1
    L_0x0086:
        java.lang.Class r0 = r28.getClass()     // Catch:{ Exception -> 0x03de, all -> 0x03db }
        if (r0 == r11) goto L_0x0095
        boolean r1 = r11 instanceof java.lang.reflect.WildcardType     // Catch:{ Exception -> 0x03de, all -> 0x03db }
        if (r1 == 0) goto L_0x0095
        java.lang.Class r1 = com.alibaba.fastjson.util.TypeUtils.m3255d(r30)     // Catch:{ Exception -> 0x03de, all -> 0x03db }
        goto L_0x0096
    L_0x0095:
        r1 = r11
    L_0x0096:
        if (r0 == r1) goto L_0x00a1
        com.alibaba.fastjson.serializer.aw r0 = r7.f2857c     // Catch:{ Exception -> 0x03de, all -> 0x03db }
        java.lang.String r0 = r0.f2877c     // Catch:{ Exception -> 0x03de, all -> 0x03db }
        r7.mo11337a(r8, r0, r9)     // Catch:{ Exception -> 0x03de, all -> 0x03db }
        r0 = 1
        goto L_0x00a2
    L_0x00a1:
        r0 = 0
    L_0x00a2:
        r3 = 44
        if (r0 == 0) goto L_0x00a9
        r0 = 44
        goto L_0x00aa
    L_0x00a9:
        r0 = 0
    L_0x00aa:
        boolean r1 = r12.f2912e     // Catch:{ Exception -> 0x03de, all -> 0x03db }
        if (r1 == 0) goto L_0x00b5
        boolean r1 = r12.f2911d     // Catch:{ Exception -> 0x03de, all -> 0x03db }
        if (r1 != 0) goto L_0x00b5
        r16 = 1
        goto L_0x00b7
    L_0x00b5:
        r16 = 0
    L_0x00b7:
        char r0 = r7.mo11331a(r8, r9, r0)     // Catch:{ Exception -> 0x03de, all -> 0x03db }
        if (r0 != r3) goto L_0x00bf
        r0 = 1
        goto L_0x00c0
    L_0x00bf:
        r0 = 0
    L_0x00c0:
        com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.SkipTransientField     // Catch:{ Exception -> 0x03de, all -> 0x03db }
        boolean r17 = r12.mo11391a(r1)     // Catch:{ Exception -> 0x03de, all -> 0x03db }
        com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.IgnoreNonFieldGetter     // Catch:{ Exception -> 0x03de, all -> 0x03db }
        boolean r18 = r12.mo11391a(r1)     // Catch:{ Exception -> 0x03de, all -> 0x03db }
        r19 = r0
        r2 = 0
    L_0x00cf:
        int r0 = r13.length     // Catch:{ Exception -> 0x03de, all -> 0x03db }
        if (r2 >= r0) goto L_0x03a2
        r1 = r13[r2]     // Catch:{ Exception -> 0x039e, all -> 0x03db }
        com.alibaba.fastjson.util.c r0 = r1.f2956a     // Catch:{ Exception -> 0x039e, all -> 0x03db }
        java.lang.reflect.Field r0 = r0.f2994c     // Catch:{ Exception -> 0x039e, all -> 0x03db }
        com.alibaba.fastjson.util.c r10 = r1.f2956a     // Catch:{ Exception -> 0x039e, all -> 0x03db }
        r20 = r14
        java.lang.String r14 = r10.f2992a     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        r21 = r13
        java.lang.Class<?> r13 = r10.f2995d     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r17 == 0) goto L_0x00f0
        if (r0 == 0) goto L_0x00f0
        boolean r3 = r10.f3003l     // Catch:{ Exception -> 0x00ec, all -> 0x03d3 }
        if (r3 == 0) goto L_0x00f0
        goto L_0x037f
    L_0x00ec:
        r0 = move-exception
        r1 = r9
        goto L_0x03d8
    L_0x00f0:
        if (r18 == 0) goto L_0x00f6
        if (r0 != 0) goto L_0x00f6
        goto L_0x037f
    L_0x00f6:
        boolean r0 = r7.mo11358a(r8, r9, r14)     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r0 == 0) goto L_0x037f
        java.lang.String r0 = r10.f3001j     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        boolean r0 = r7.mo11340a(r8, r0)     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r0 != 0) goto L_0x0106
        goto L_0x037f
    L_0x0106:
        com.alibaba.fastjson.serializer.aw r0 = r7.f2857c     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        java.lang.String r0 = r0.f2877c     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r0 == 0) goto L_0x011e
        com.alibaba.fastjson.serializer.aw r0 = r7.f2857c     // Catch:{ Exception -> 0x00ec, all -> 0x03d3 }
        java.lang.String r0 = r0.f2877c     // Catch:{ Exception -> 0x00ec, all -> 0x03d3 }
        boolean r0 = r14.equals(r0)     // Catch:{ Exception -> 0x00ec, all -> 0x03d3 }
        if (r0 == 0) goto L_0x011e
        boolean r0 = r8.mo11320a(r11, r9)     // Catch:{ Exception -> 0x00ec, all -> 0x03d3 }
        if (r0 == 0) goto L_0x011e
        goto L_0x037f
    L_0x011e:
        java.lang.Object r0 = r1.mo11430a(r9)     // Catch:{ InvocationTargetException -> 0x0123 }
        goto L_0x012e
    L_0x0123:
        r0 = move-exception
        r3 = r0
        com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.IgnoreErrorGetter     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        boolean r0 = r12.mo11391a(r0)     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r0 == 0) goto L_0x037e
        r0 = 0
    L_0x012e:
        boolean r3 = r7.mo11359a(r8, r9, r14, r0)     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r3 != 0) goto L_0x0136
        goto L_0x037f
    L_0x0136:
        java.lang.Class<java.lang.String> r3 = java.lang.String.class
        if (r13 != r3) goto L_0x014c
        java.lang.String r3 = "trim"
        java.lang.String r4 = r10.f3008q     // Catch:{ Exception -> 0x00ec, all -> 0x03d3 }
        boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x00ec, all -> 0x03d3 }
        if (r3 == 0) goto L_0x014c
        if (r0 == 0) goto L_0x014c
        java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x00ec, all -> 0x03d3 }
        java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x00ec, all -> 0x03d3 }
    L_0x014c:
        java.lang.String r4 = r7.mo11360b(r8, r9, r14, r0)     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        com.alibaba.fastjson.serializer.j r3 = r1.f2959d     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        r11 = r1
        r1 = r26
        r23 = r2
        r2 = r27
        r9 = 44
        r24 = r4
        r4 = r28
        r5 = r14
        r25 = r6
        r6 = r0
        java.lang.Object r1 = r1.mo11356a(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r1 != 0) goto L_0x01e4
        if (r15 != 0) goto L_0x01e4
        java.lang.Class<java.lang.Boolean> r2 = java.lang.Boolean.class
        if (r13 != r2) goto L_0x0184
        com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullBooleanAsFalse     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        int r2 = r2.mask     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        com.alibaba.fastjson.serializer.SerializerFeature r3 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        int r3 = r3.mask     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        r2 = r2 | r3
        int r3 = r10.f2999h     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        r3 = r3 & r2
        if (r3 != 0) goto L_0x01e4
        int r3 = r12.f2910c     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        r2 = r2 & r3
        if (r2 != 0) goto L_0x01e4
        goto L_0x0211
    L_0x0184:
        java.lang.Class<java.lang.String> r2 = java.lang.String.class
        if (r13 != r2) goto L_0x019d
        com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        int r2 = r2.mask     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        com.alibaba.fastjson.serializer.SerializerFeature r3 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        int r3 = r3.mask     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        r2 = r2 | r3
        int r3 = r10.f2999h     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        r3 = r3 & r2
        if (r3 != 0) goto L_0x01e4
        int r3 = r12.f2910c     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        r2 = r2 & r3
        if (r2 != 0) goto L_0x01e4
        goto L_0x0211
    L_0x019d:
        java.lang.Class<java.lang.Number> r2 = java.lang.Number.class
        boolean r2 = r2.isAssignableFrom(r13)     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r2 == 0) goto L_0x01b9
        com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullNumberAsZero     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        int r2 = r2.mask     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        com.alibaba.fastjson.serializer.SerializerFeature r3 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        int r3 = r3.mask     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        r2 = r2 | r3
        int r3 = r10.f2999h     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        r3 = r3 & r2
        if (r3 != 0) goto L_0x01e4
        int r3 = r12.f2910c     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        r2 = r2 & r3
        if (r2 != 0) goto L_0x01e4
        goto L_0x0211
    L_0x01b9:
        java.lang.Class<java.util.Collection> r2 = java.util.Collection.class
        boolean r2 = r2.isAssignableFrom(r13)     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r2 == 0) goto L_0x01d5
        com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        int r2 = r2.mask     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        com.alibaba.fastjson.serializer.SerializerFeature r3 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        int r3 = r3.mask     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        r2 = r2 | r3
        int r3 = r10.f2999h     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        r3 = r3 & r2
        if (r3 != 0) goto L_0x01e4
        int r3 = r12.f2910c     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        r2 = r2 & r3
        if (r2 != 0) goto L_0x01e4
        goto L_0x0211
    L_0x01d5:
        boolean r2 = r11.f2957b     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r2 != 0) goto L_0x01e4
        com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        int r2 = r2.mask     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        boolean r2 = r12.mo11390a(r2)     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r2 != 0) goto L_0x01e4
        goto L_0x0211
    L_0x01e4:
        if (r1 == 0) goto L_0x028c
        boolean r2 = r12.f2917j     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r2 != 0) goto L_0x01fe
        int r2 = r10.f2999h     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        com.alibaba.fastjson.serializer.SerializerFeature r3 = com.alibaba.fastjson.serializer.SerializerFeature.NotWriteDefaultValue     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        int r3 = r3.mask     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        r2 = r2 & r3
        if (r2 != 0) goto L_0x01fe
        com.alibaba.fastjson.serializer.aw r2 = r7.f2857c     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        int r2 = r2.f2881g     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        com.alibaba.fastjson.serializer.SerializerFeature r3 = com.alibaba.fastjson.serializer.SerializerFeature.NotWriteDefaultValue     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        int r3 = r3.mask     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        r2 = r2 & r3
        if (r2 == 0) goto L_0x028c
    L_0x01fe:
        java.lang.Class<?> r2 = r10.f2995d     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        java.lang.Class r3 = java.lang.Byte.TYPE     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r2 != r3) goto L_0x0213
        boolean r3 = r1 instanceof java.lang.Byte     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r3 == 0) goto L_0x0213
        r3 = r1
        java.lang.Byte r3 = (java.lang.Byte) r3     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        byte r3 = r3.byteValue()     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r3 != 0) goto L_0x0213
    L_0x0211:
        goto L_0x029f
    L_0x0213:
        java.lang.Class r3 = java.lang.Short.TYPE     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r2 != r3) goto L_0x0226
        boolean r3 = r1 instanceof java.lang.Short     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r3 == 0) goto L_0x0226
        r3 = r1
        java.lang.Short r3 = (java.lang.Short) r3     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        short r3 = r3.shortValue()     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r3 != 0) goto L_0x0226
    L_0x0224:
        goto L_0x029f
    L_0x0226:
        java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r2 != r3) goto L_0x0239
        boolean r3 = r1 instanceof java.lang.Integer     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r3 == 0) goto L_0x0239
        r3 = r1
        java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        int r3 = r3.intValue()     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r3 != 0) goto L_0x0239
        goto L_0x029f
    L_0x0239:
        java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r2 != r3) goto L_0x024f
        boolean r3 = r1 instanceof java.lang.Long     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r3 == 0) goto L_0x024f
        r3 = r1
        java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        long r3 = r3.longValue()     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        r5 = 0
        int r22 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
        if (r22 != 0) goto L_0x024f
        goto L_0x0224
    L_0x024f:
        java.lang.Class r3 = java.lang.Float.TYPE     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r2 != r3) goto L_0x0264
        boolean r3 = r1 instanceof java.lang.Float     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r3 == 0) goto L_0x0264
        r3 = r1
        java.lang.Float r3 = (java.lang.Float) r3     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        float r3 = r3.floatValue()     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        r4 = 0
        int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
        if (r3 != 0) goto L_0x0264
        goto L_0x029f
    L_0x0264:
        java.lang.Class r3 = java.lang.Double.TYPE     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r2 != r3) goto L_0x027a
        boolean r3 = r1 instanceof java.lang.Double     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r3 == 0) goto L_0x027a
        r3 = r1
        java.lang.Double r3 = (java.lang.Double) r3     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        double r3 = r3.doubleValue()     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        r5 = 0
        int r22 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
        if (r22 != 0) goto L_0x027a
        goto L_0x029f
    L_0x027a:
        java.lang.Class r3 = java.lang.Boolean.TYPE     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r2 != r3) goto L_0x028c
        boolean r2 = r1 instanceof java.lang.Boolean     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r2 == 0) goto L_0x028c
        r2 = r1
        java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r2 != 0) goto L_0x028c
        goto L_0x0211
    L_0x028c:
        if (r19 == 0) goto L_0x02b1
        boolean r2 = r10.f3007p     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r2 == 0) goto L_0x02a3
        boolean r2 = r1 instanceof java.util.Map     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r2 == 0) goto L_0x02a3
        r2 = r1
        java.util.Map r2 = (java.util.Map) r2     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        int r2 = r2.size()     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r2 != 0) goto L_0x02a3
    L_0x029f:
        r3 = 1
        r4 = 0
        goto L_0x0387
    L_0x02a3:
        r12.write(r9)     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        boolean r2 = r12.mo11391a(r2)     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r2 == 0) goto L_0x02b1
        r27.mo11327e()     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
    L_0x02b1:
        r2 = r24
        if (r2 == r14) goto L_0x02c3
        if (r15 != 0) goto L_0x02bc
        r3 = 1
        r12.mo11386a(r2, r3)     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        goto L_0x02bd
    L_0x02bc:
        r3 = 1
    L_0x02bd:
        r8.mo11325c(r1)     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
    L_0x02c0:
        r4 = 0
        goto L_0x0344
    L_0x02c3:
        r3 = 1
        if (r0 == r1) goto L_0x02cf
        if (r15 != 0) goto L_0x02cb
        r11.mo11431a(r8)     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
    L_0x02cb:
        r8.mo11325c(r1)     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        goto L_0x02c0
    L_0x02cf:
        if (r15 != 0) goto L_0x02e6
        boolean r0 = r10.f3007p     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r0 != 0) goto L_0x02e6
        if (r16 == 0) goto L_0x02e1
        char[] r0 = r10.f3004m     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        char[] r2 = r10.f3004m     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        int r2 = r2.length     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        r4 = 0
        r12.write(r0, r4, r2)     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        goto L_0x02e7
    L_0x02e1:
        r4 = 0
        r11.mo11431a(r8)     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        goto L_0x02e7
    L_0x02e6:
        r4 = 0
    L_0x02e7:
        if (r15 != 0) goto L_0x0341
        com.alibaba.fastjson.annotation.JSONField r0 = r10.mo11506d()     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        java.lang.Class<java.lang.String> r2 = java.lang.String.class
        if (r13 != r2) goto L_0x0329
        if (r0 == 0) goto L_0x02fb
        java.lang.Class r0 = r0.serializeUsing()     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        java.lang.Class<java.lang.Void> r2 = java.lang.Void.class
        if (r0 != r2) goto L_0x0329
    L_0x02fb:
        if (r1 != 0) goto L_0x031a
        int r0 = r12.f2910c     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        int r2 = r2.mask     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        r0 = r0 & r2
        if (r0 != 0) goto L_0x0314
        int r0 = r11.f2958c     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        int r2 = r2.mask     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        r0 = r0 & r2
        if (r0 == 0) goto L_0x0310
        goto L_0x0314
    L_0x0310:
        r12.mo11396b()     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        goto L_0x0344
    L_0x0314:
        java.lang.String r0 = ""
        r12.mo11384a(r0)     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        goto L_0x0344
    L_0x031a:
        r0 = r1
        java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        boolean r2 = r12.f2911d     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r2 == 0) goto L_0x0325
        r12.mo11400b(r0)     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        goto L_0x0344
    L_0x0325:
        r12.mo11385a(r0, r4)     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        goto L_0x0344
    L_0x0329:
        boolean r0 = r10.f3007p     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r0 == 0) goto L_0x033d
        boolean r0 = r1 instanceof java.util.Map     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r0 == 0) goto L_0x033d
        r0 = r1
        java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        int r0 = r0.size()     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r0 != 0) goto L_0x033d
        r19 = 0
        goto L_0x0387
    L_0x033d:
        r11.mo11432a(r8, r1)     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        goto L_0x0344
    L_0x0341:
        r11.mo11432a(r8, r1)     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
    L_0x0344:
        boolean r0 = r10.f3007p     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r0 == 0) goto L_0x0378
        boolean r0 = r1 instanceof java.util.Map     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r0 == 0) goto L_0x0378
        java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        int r0 = r1.size()     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r0 != 0) goto L_0x0356
    L_0x0354:
        r0 = 1
        goto L_0x0379
    L_0x0356:
        com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        boolean r0 = r8.mo11318a(r0)     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r0 != 0) goto L_0x0378
        java.util.Collection r0 = r1.values()     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
    L_0x0366:
        boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r1 == 0) goto L_0x0374
        java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
        if (r1 == 0) goto L_0x0366
        r0 = 1
        goto L_0x0375
    L_0x0374:
        r0 = 0
    L_0x0375:
        if (r0 != 0) goto L_0x0378
        goto L_0x0354
    L_0x0378:
        r0 = 0
    L_0x0379:
        if (r0 != 0) goto L_0x0387
        r19 = 1
        goto L_0x0387
    L_0x037e:
        throw r3     // Catch:{ Exception -> 0x039a, all -> 0x03d3 }
    L_0x037f:
        r23 = r2
        r25 = r6
        r3 = 1
        r4 = 0
        r9 = 44
    L_0x0387:
        int r2 = r23 + 1
        r9 = r28
        r10 = r29
        r11 = r30
        r14 = r20
        r13 = r21
        r6 = r25
        r3 = 44
        r5 = 1
        goto L_0x00cf
    L_0x039a:
        r0 = move-exception
        r1 = r28
        goto L_0x03d8
    L_0x039e:
        r0 = move-exception
        r1 = r28
        goto L_0x03e0
    L_0x03a2:
        r25 = r6
        r21 = r13
        r20 = r14
        r4 = 0
        r9 = 44
        r1 = r28
        if (r19 == 0) goto L_0x03b0
        goto L_0x03b1
    L_0x03b0:
        r9 = 0
    L_0x03b1:
        r7.mo11341b(r8, r1, r9)     // Catch:{ Exception -> 0x03d7, all -> 0x03d3 }
        r2 = r21
        int r0 = r2.length     // Catch:{ Exception -> 0x03d7, all -> 0x03d3 }
        if (r0 <= 0) goto L_0x03c7
        com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ Exception -> 0x03d7, all -> 0x03d3 }
        boolean r0 = r12.mo11391a(r0)     // Catch:{ Exception -> 0x03d7, all -> 0x03d3 }
        if (r0 == 0) goto L_0x03c7
        r27.mo11326d()     // Catch:{ Exception -> 0x03d7, all -> 0x03d3 }
        r27.mo11327e()     // Catch:{ Exception -> 0x03d7, all -> 0x03d3 }
    L_0x03c7:
        if (r32 != 0) goto L_0x03ce
        r2 = r25
        r12.append(r2)     // Catch:{ Exception -> 0x03d7, all -> 0x03d3 }
    L_0x03ce:
        r2 = r20
        r8.f2848d = r2
        return
    L_0x03d3:
        r0 = move-exception
        r2 = r20
        goto L_0x043e
    L_0x03d7:
        r0 = move-exception
    L_0x03d8:
        r2 = r20
        goto L_0x03e1
    L_0x03db:
        r0 = move-exception
        r2 = r14
        goto L_0x043e
    L_0x03de:
        r0 = move-exception
        r1 = r9
    L_0x03e0:
        r2 = r14
    L_0x03e1:
        java.lang.String r3 = "write javaBean error, fastjson version 1.2.41"
        if (r1 == 0) goto L_0x0401
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x043d }
        r4.<init>()     // Catch:{ all -> 0x043d }
        r4.append(r3)     // Catch:{ all -> 0x043d }
        java.lang.String r3 = ", class "
        r4.append(r3)     // Catch:{ all -> 0x043d }
        java.lang.Class r1 = r28.getClass()     // Catch:{ all -> 0x043d }
        java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x043d }
        r4.append(r1)     // Catch:{ all -> 0x043d }
        java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x043d }
    L_0x0401:
        r1 = r29
        if (r1 == 0) goto L_0x0419
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x043d }
        r4.<init>()     // Catch:{ all -> 0x043d }
        r4.append(r3)     // Catch:{ all -> 0x043d }
        java.lang.String r3 = ", fieldName : "
        r4.append(r3)     // Catch:{ all -> 0x043d }
        r4.append(r1)     // Catch:{ all -> 0x043d }
        java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x043d }
    L_0x0419:
        java.lang.String r1 = r0.getMessage()     // Catch:{ all -> 0x043d }
        if (r1 == 0) goto L_0x0437
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x043d }
        r1.<init>()     // Catch:{ all -> 0x043d }
        r1.append(r3)     // Catch:{ all -> 0x043d }
        java.lang.String r3 = ", "
        r1.append(r3)     // Catch:{ all -> 0x043d }
        java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x043d }
        r1.append(r3)     // Catch:{ all -> 0x043d }
        java.lang.String r3 = r1.toString()     // Catch:{ all -> 0x043d }
    L_0x0437:
        com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x043d }
        r1.m41527init(r3, r0)     // Catch:{ all -> 0x043d }
        throw r1     // Catch:{ all -> 0x043d }
    L_0x043d:
        r0 = move-exception
    L_0x043e:
        r8.f2848d = r2
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JavaBeanSerializer.mo11336a(com.alibaba.fastjson.serializer.ag, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo11337a(JSONSerializer agVar, String str, Object obj) {
        if (str == null) {
            str = agVar.f2845a.f2889b;
        }
        agVar.f2846b.mo11386a(str, false);
        String str2 = this.f2857c.f2876b;
        if (str2 == null) {
            Class cls = obj.getClass();
            if (TypeUtils.m3252c(cls)) {
                cls = cls.getSuperclass();
            }
            str2 = cls.getName();
        }
        agVar.mo11323b(str2);
    }

    /* renamed from: a */
    public boolean mo11339a(JSONSerializer agVar, Object obj, int i) {
        SerialContext avVar = agVar.f2848d;
        int i2 = SerializerFeature.DisableCircularReferenceDetect.mask;
        if (avVar == null || (avVar.f2874d & i2) != 0 || (i & i2) != 0 || agVar.f2847c == null || !agVar.f2847c.containsKey(obj)) {
            return false;
        }
        agVar.mo11322b(obj);
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo11338a(JSONSerializer agVar, int i) {
        int i2 = SerializerFeature.BeanToArray.mask;
        return ((this.f2857c.f2881g & i2) == 0 && !agVar.f2846b.f2915h && (i & i2) == 0) ? false : true;
    }

    /* renamed from: a */
    public Object mo11334a(Object obj, String str, long j, boolean z) {
        String str2 = "getFieldValue error.";
        FieldSerializer a = mo11332a(j);
        if (a != null) {
            try {
                return a.mo11433b(obj);
            } catch (InvocationTargetException e) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(str);
                throw new JSONException(sb.toString(), e);
            } catch (IllegalAccessException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append(str);
                throw new JSONException(sb2.toString(), e2);
            }
        } else if (!z) {
            return null;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("field not found. ");
            sb3.append(str);
            throw new JSONException(sb3.toString());
        }
    }

    /* renamed from: a */
    public FieldSerializer mo11333a(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        int length = this.f2856b.length - 1;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int compareTo = this.f2856b[i2].f2956a.f2992a.compareTo(str);
            if (compareTo < 0) {
                i = i2 + 1;
            } else if (compareTo <= 0) {
                return this.f2856b[i2];
            } else {
                length = i2 - 1;
            }
        }
        return null;
    }

    /* renamed from: a */
    public FieldSerializer mo11332a(long j) {
        PropertyNamingStrategy[] propertyNamingStrategyArr;
        if (this.f2858d == null) {
            propertyNamingStrategyArr = PropertyNamingStrategy.values();
            long[] jArr = new long[(this.f2856b.length * propertyNamingStrategyArr.length)];
            int i = 0;
            int i2 = 0;
            while (true) {
                FieldSerializer[] zVarArr = this.f2856b;
                if (i >= zVarArr.length) {
                    break;
                }
                String str = zVarArr[i].f2956a.f2992a;
                int i3 = i2 + 1;
                jArr[i2] = TypeUtils.m3265g(str);
                for (PropertyNamingStrategy translate : propertyNamingStrategyArr) {
                    String translate2 = translate.translate(str);
                    if (!str.equals(translate2)) {
                        int i4 = i3 + 1;
                        jArr[i3] = TypeUtils.m3265g(translate2);
                        i3 = i4;
                    }
                }
                i++;
                i2 = i3;
            }
            Arrays.sort(jArr, 0, i2);
            this.f2858d = new long[i2];
            System.arraycopy(jArr, 0, this.f2858d, 0, i2);
        } else {
            propertyNamingStrategyArr = null;
        }
        int binarySearch = Arrays.binarySearch(this.f2858d, j);
        if (binarySearch < 0) {
            return null;
        }
        if (this.f2859e == null) {
            if (propertyNamingStrategyArr == null) {
                propertyNamingStrategyArr = PropertyNamingStrategy.values();
            }
            short[] sArr = new short[this.f2858d.length];
            Arrays.fill(sArr, -1);
            int i5 = 0;
            while (true) {
                FieldSerializer[] zVarArr2 = this.f2856b;
                if (i5 >= zVarArr2.length) {
                    break;
                }
                String str2 = zVarArr2[i5].f2956a.f2992a;
                int binarySearch2 = Arrays.binarySearch(this.f2858d, TypeUtils.m3265g(str2));
                if (binarySearch2 >= 0) {
                    sArr[binarySearch2] = (short) i5;
                }
                for (PropertyNamingStrategy translate3 : propertyNamingStrategyArr) {
                    String translate4 = translate3.translate(str2);
                    if (!str2.equals(translate4)) {
                        int binarySearch3 = Arrays.binarySearch(this.f2858d, TypeUtils.m3265g(translate4));
                        if (binarySearch3 >= 0) {
                            sArr[binarySearch3] = (short) i5;
                        }
                    }
                }
                i5++;
            }
            this.f2859e = sArr;
        }
        short s = this.f2859e[binarySearch];
        if (s != -1) {
            return this.f2856b[s];
        }
        return null;
    }

    /* renamed from: a */
    public List<Object> mo11335a(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.f2856b.length);
        for (FieldSerializer b : this.f2856b) {
            arrayList.add(b.mo11433b(obj));
        }
        return arrayList;
    }

    /* renamed from: b */
    public int mo11342b(Object obj) throws Exception {
        int i = 0;
        for (FieldSerializer a : this.f2856b) {
            if (a.mo11430a(obj) != null) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: c */
    public Map<String, Object> mo11344c(Object obj) throws Exception {
        FieldSerializer[] zVarArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.f2856b.length);
        for (FieldSerializer zVar : this.f2856b) {
            linkedHashMap.put(zVar.f2956a.f2992a, zVar.mo11433b(obj));
        }
        return linkedHashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public char mo11331a(JSONSerializer agVar, Object obj, char c) {
        if (agVar.f2895g != null) {
            for (BeforeFilter a : agVar.f2895g) {
                c = a.mo11425a(agVar, obj, c);
            }
        }
        if (this.f2895g != null) {
            for (BeforeFilter a2 : this.f2895g) {
                c = a2.mo11425a(agVar, obj, c);
            }
        }
        return c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public char mo11341b(JSONSerializer agVar, Object obj, char c) {
        if (agVar.f2896h != null) {
            for (AfterFilter a : agVar.f2896h) {
                c = a.mo11414a(agVar, obj, c);
            }
        }
        if (this.f2896h != null) {
            for (AfterFilter a2 : this.f2896h) {
                c = a2.mo11414a(agVar, obj, c);
            }
        }
        return c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo11340a(JSONSerializer agVar, String str) {
        if (agVar.f2901m != null) {
            for (LabelFilter a : agVar.f2901m) {
                if (!a.mo11345a(str)) {
                    return false;
                }
            }
        }
        if (this.f2901m != null) {
            for (LabelFilter a2 : this.f2901m) {
                if (!a2.mo11345a(str)) {
                    return false;
                }
            }
        }
        return true;
    }
}
