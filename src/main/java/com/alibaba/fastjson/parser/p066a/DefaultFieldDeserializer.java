package com.alibaba.fastjson.parser.p066a;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;

/* renamed from: com.alibaba.fastjson.parser.a.f */
public class DefaultFieldDeserializer extends FieldDeserializer {
    /* renamed from: a */
    protected ObjectDeserializer f2719a;

    public DefaultFieldDeserializer(ParserConfig hVar, Class<?> cls, FieldInfo cVar) {
        super(cls, cVar);
    }

    /* renamed from: a */
    public ObjectDeserializer mo11169a(ParserConfig hVar) {
        if (this.f2719a == null) {
            JSONField d = this.f2724b.mo11506d();
            if (d == null || d.deserializeUsing() == Void.class) {
                this.f2719a = hVar.mo11291a(this.f2724b.f2995d, this.f2724b.f2996e);
            } else {
                try {
                    this.f2719a = (ObjectDeserializer) d.deserializeUsing().newInstance();
                } catch (Exception e) {
                    throw new JSONException("create deserializeUsing ObjectDeserializer error", e);
                }
            }
        }
        return this.f2719a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0089, code lost:
            if ("gzip,base64".equals(r7.f2724b.f3008q) != false) goto L_0x008b;
     */
    /* renamed from: a */
    public void mo11166a(com.alibaba.fastjson.parser.DefaultJSONParser r8, java.lang.Object r9, java.lang.reflect.Type r10, java.util.Map<java.lang.String, java.lang.Object> r11) {
        /*
        r7 = this;
        com.alibaba.fastjson.parser.a.s r0 = r7.f2719a
        if (r0 != 0) goto L_0x000b
        com.alibaba.fastjson.parser.h r0 = r8.mo11146d()
        r7.mo11169a(r0)
    L_0x000b:
        com.alibaba.fastjson.parser.a.s r0 = r7.f2719a
        com.alibaba.fastjson.util.c r1 = r7.f2724b
        java.lang.reflect.Type r1 = r1.f2996e
        boolean r2 = r10 instanceof java.lang.reflect.ParameterizedType
        if (r2 == 0) goto L_0x002d
        com.alibaba.fastjson.parser.g r2 = r8.mo11149g()
        if (r2 == 0) goto L_0x001d
        r2.f2797d = r10
    L_0x001d:
        if (r1 == r10) goto L_0x002d
        java.lang.Class r0 = r7.f2725c
        java.lang.reflect.Type r1 = com.alibaba.fastjson.util.FieldInfo.m3174a(r0, r10, r1)
        com.alibaba.fastjson.parser.h r10 = r8.mo11146d()
        com.alibaba.fastjson.parser.a.s r0 = r10.mo11292a(r1)
    L_0x002d:
        r3 = r1
        boolean r10 = r0 instanceof com.alibaba.fastjson.parser.p066a.JavaBeanDeserializer
        if (r10 == 0) goto L_0x0047
        com.alibaba.fastjson.util.c r10 = r7.f2724b
        int r10 = r10.f3000i
        if (r10 == 0) goto L_0x0047
        com.alibaba.fastjson.parser.a.n r0 = (com.alibaba.fastjson.parser.p066a.JavaBeanDeserializer) r0
        com.alibaba.fastjson.util.c r10 = r7.f2724b
        java.lang.String r10 = r10.f2992a
        com.alibaba.fastjson.util.c r1 = r7.f2724b
        int r1 = r1.f3000i
        java.lang.Object r10 = r0.mo11187a(r8, r3, r10, r1)
        goto L_0x006e
    L_0x0047:
        com.alibaba.fastjson.util.c r10 = r7.f2724b
        java.lang.String r10 = r10.f3008q
        if (r10 == 0) goto L_0x0066
        boolean r10 = r0 instanceof com.alibaba.fastjson.parser.p066a.ContextObjectDeserializer
        if (r10 == 0) goto L_0x0066
        r1 = r0
        com.alibaba.fastjson.parser.a.e r1 = (com.alibaba.fastjson.parser.p066a.ContextObjectDeserializer) r1
        com.alibaba.fastjson.util.c r10 = r7.f2724b
        java.lang.String r4 = r10.f2992a
        com.alibaba.fastjson.util.c r10 = r7.f2724b
        java.lang.String r5 = r10.f3008q
        com.alibaba.fastjson.util.c r10 = r7.f2724b
        int r6 = r10.f3000i
        r2 = r8
        java.lang.Object r10 = r1.mo11164a(r2, r3, r4, r5, r6)
        goto L_0x006e
    L_0x0066:
        com.alibaba.fastjson.util.c r10 = r7.f2724b
        java.lang.String r10 = r10.f2992a
        java.lang.Object r10 = r0.mo11161a(r8, r3, r10)
    L_0x006e:
        boolean r0 = r10 instanceof byte[]
        r1 = 0
        if (r0 == 0) goto L_0x00bd
        com.alibaba.fastjson.util.c r0 = r7.f2724b
        java.lang.String r0 = r0.f3008q
        java.lang.String r2 = "gzip"
        boolean r0 = r2.equals(r0)
        if (r0 != 0) goto L_0x008b
        com.alibaba.fastjson.util.c r0 = r7.f2724b
        java.lang.String r0 = r0.f3008q
        java.lang.String r2 = "gzip,base64"
        boolean r0 = r2.equals(r0)
        if (r0 == 0) goto L_0x00bd
    L_0x008b:
        byte[] r10 = (byte[]) r10
        byte[] r10 = (byte[]) r10
        java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x00b4 }
        java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x00b4 }
        r2.<init>(r10)     // Catch:{ IOException -> 0x00b4 }
        r0.<init>(r2)     // Catch:{ IOException -> 0x00b4 }
        java.io.ByteArrayOutputStream r10 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x00b4 }
        r10.<init>()     // Catch:{ IOException -> 0x00b4 }
    L_0x009e:
        r2 = 1024(0x400, float:1.435E-42)
        byte[] r2 = new byte[r2]     // Catch:{ IOException -> 0x00b4 }
        int r3 = r0.read(r2)     // Catch:{ IOException -> 0x00b4 }
        r4 = -1
        if (r3 != r4) goto L_0x00ae
        byte[] r10 = r10.toByteArray()     // Catch:{ IOException -> 0x00b4 }
        goto L_0x00bd
    L_0x00ae:
        if (r3 <= 0) goto L_0x009e
        r10.write(r2, r1, r3)     // Catch:{ IOException -> 0x00b4 }
        goto L_0x009e
    L_0x00b4:
        r8 = move-exception
        com.alibaba.fastjson.JSONException r9 = new com.alibaba.fastjson.JSONException
        java.lang.String r10 = "unzip bytes error."
        r9.m41527init(r10, r8)
        throw r9
    L_0x00bd:
        int r0 = r8.mo11147e()
        r2 = 1
        if (r0 != r2) goto L_0x00d4
        com.alibaba.fastjson.parser.a$a r9 = r8.mo11150h()
        r9.f2703c = r7
        com.alibaba.fastjson.parser.g r10 = r8.mo11149g()
        r9.f2704d = r10
        r8.mo11122a(r1)
        goto L_0x00e1
    L_0x00d4:
        if (r9 != 0) goto L_0x00de
        com.alibaba.fastjson.util.c r8 = r7.f2724b
        java.lang.String r8 = r8.f2992a
        r11.put(r8, r10)
        goto L_0x00e1
    L_0x00de:
        r7.mo11177a(r9, r10)
    L_0x00e1:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.p066a.DefaultFieldDeserializer.mo11166a(com.alibaba.fastjson.parser.a, java.lang.Object, java.lang.reflect.Type, java.util.Map):void");
    }

    /* renamed from: a */
    public int mo11165a() {
        ObjectDeserializer sVar = this.f2719a;
        if (sVar != null) {
            return sVar.mo11162g_();
        }
        return 2;
    }
}
