package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.alibaba.fastjson.serializer.ag */
public class JSONSerializer extends SerializeFilterable {
    /* renamed from: a */
    protected final SerializeConfig f2845a;
    /* renamed from: b */
    public final SerializeWriter f2846b;
    /* renamed from: c */
    protected IdentityHashMap<Object, SerialContext> f2847c;
    /* renamed from: d */
    protected SerialContext f2848d;
    /* renamed from: e */
    protected TimeZone f2849e;
    /* renamed from: f */
    protected Locale f2850f;
    /* renamed from: p */
    private int f2851p;
    /* renamed from: q */
    private String f2852q;
    /* renamed from: r */
    private String f2853r;
    /* renamed from: s */
    private DateFormat f2854s;

    public JSONSerializer() {
        this(new SerializeWriter(), SerializeConfig.m3034a());
    }

    public JSONSerializer(SerializeWriter baVar) {
        this(baVar, SerializeConfig.m3034a());
    }

    public JSONSerializer(SerializeWriter baVar, SerializeConfig axVar) {
        this.f2851p = 0;
        this.f2852q = "\t";
        this.f2847c = null;
        this.f2849e = JSON.defaultTimeZone;
        this.f2850f = JSON.defaultLocale;
        this.f2846b = baVar;
        this.f2845a = axVar;
    }

    /* renamed from: a */
    public String mo11310a() {
        DateFormat dateFormat = this.f2854s;
        if (dateFormat instanceof SimpleDateFormat) {
            return ((SimpleDateFormat) dateFormat).toPattern();
        }
        return this.f2853r;
    }

    /* renamed from: b */
    public DateFormat mo11321b() {
        if (this.f2854s == null) {
            String str = this.f2853r;
            if (str != null) {
                this.f2854s = new SimpleDateFormat(str, this.f2850f);
                this.f2854s.setTimeZone(this.f2849e);
            }
        }
        return this.f2854s;
    }

    /* renamed from: a */
    public void mo11317a(String str) {
        this.f2853r = str;
        if (this.f2854s != null) {
            this.f2854s = null;
        }
    }

    /* renamed from: a */
    public void mo11312a(SerialContext avVar, Object obj, Object obj2, int i) {
        mo11313a(avVar, obj, obj2, i, 0);
    }

    /* renamed from: a */
    public void mo11313a(SerialContext avVar, Object obj, Object obj2, int i, int i2) {
        if (!this.f2846b.f2914g) {
            SerialContext avVar2 = new SerialContext(avVar, obj, obj2, i, i2);
            this.f2848d = avVar2;
            if (this.f2847c == null) {
                this.f2847c = new IdentityHashMap<>();
            }
            this.f2847c.put(obj, this.f2848d);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
            if (r2.f2871a != null) goto L_0x001e;
     */
    /* renamed from: a */
    public final boolean mo11320a(java.lang.reflect.Type r2, java.lang.Object r3) {
        /*
        r1 = this;
        com.alibaba.fastjson.serializer.ba r3 = r1.f2846b
        com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName
        boolean r3 = r3.mo11391a(r0)
        if (r3 == 0) goto L_0x0020
        if (r2 != 0) goto L_0x001e
        com.alibaba.fastjson.serializer.ba r2 = r1.f2846b
        com.alibaba.fastjson.serializer.SerializerFeature r3 = com.alibaba.fastjson.serializer.SerializerFeature.NotWriteRootClassName
        boolean r2 = r2.mo11391a(r3)
        if (r2 == 0) goto L_0x001e
        com.alibaba.fastjson.serializer.av r2 = r1.f2848d
        if (r2 == 0) goto L_0x0020
        com.alibaba.fastjson.serializer.av r2 = r2.f2871a
        if (r2 == 0) goto L_0x0020
    L_0x001e:
        r2 = 1
        goto L_0x0021
    L_0x0020:
        r2 = 0
    L_0x0021:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JSONSerializer.mo11320a(java.lang.reflect.Type, java.lang.Object):boolean");
    }

    /* renamed from: a */
    public boolean mo11319a(Object obj) {
        IdentityHashMap<Object, SerialContext> identityHashMap = this.f2847c;
        boolean z = false;
        if (identityHashMap == null) {
            return false;
        }
        SerialContext avVar = (SerialContext) identityHashMap.get(obj);
        if (avVar == null) {
            return false;
        }
        Object obj2 = avVar.f2873c;
        if (obj2 == null || (obj2 instanceof Integer) || (obj2 instanceof String)) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    public void mo11322b(Object obj) {
        SerialContext avVar = this.f2848d;
        if (obj == avVar.f2872b) {
            this.f2846b.write("{\"$ref\":\"@\"}");
            return;
        }
        SerialContext avVar2 = avVar.f2871a;
        if (avVar2 == null || obj != avVar2.f2872b) {
            while (avVar.f2871a != null) {
                avVar = avVar.f2871a;
            }
            if (obj == avVar.f2872b) {
                this.f2846b.write("{\"$ref\":\"$\"}");
            } else {
                this.f2846b.write("{\"$ref\":\"");
                this.f2846b.write(((SerialContext) this.f2847c.get(obj)).toString());
                this.f2846b.write("\"}");
            }
            return;
        }
        this.f2846b.write("{\"$ref\":\"..\"}");
    }

    /* renamed from: c */
    public void mo11324c() {
        this.f2851p++;
    }

    /* renamed from: d */
    public void mo11326d() {
        this.f2851p--;
    }

    /* renamed from: e */
    public void mo11327e() {
        this.f2846b.write(10);
        for (int i = 0; i < this.f2851p; i++) {
            this.f2846b.write(this.f2852q);
        }
    }

    /* renamed from: f */
    public SerializeWriter mo11328f() {
        return this.f2846b;
    }

    public String toString() {
        return this.f2846b.toString();
    }

    /* renamed from: a */
    public void mo11311a(SerializerFeature serializerFeature, boolean z) {
        this.f2846b.mo11382a(serializerFeature, z);
    }

    /* renamed from: a */
    public boolean mo11318a(SerializerFeature serializerFeature) {
        return this.f2846b.mo11391a(serializerFeature);
    }

    /* renamed from: g */
    public void mo11329g() {
        this.f2846b.mo11396b();
    }

    /* renamed from: c */
    public final void mo11325c(Object obj) {
        if (obj == null) {
            this.f2846b.mo11396b();
            return;
        }
        try {
            mo11309a(obj.getClass()).mo11198a(this, obj, null, null, 0);
        } catch (IOException e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    /* renamed from: a */
    public final void mo11314a(Object obj, Object obj2) {
        mo11315a(obj, obj2, (Type) null, 0);
    }

    /* renamed from: a */
    public final void mo11315a(Object obj, Object obj2, Type type, int i) {
        if (obj == null) {
            try {
                this.f2846b.mo11396b();
            } catch (IOException e) {
                throw new JSONException(e.getMessage(), e);
            }
        } else {
            mo11309a(obj.getClass()).mo11198a(this, obj, obj2, type, i);
        }
    }

    /* renamed from: a */
    public final void mo11316a(Object obj, String str) {
        GZIPOutputStream gZIPOutputStream;
        if (obj instanceof Date) {
            DateFormat b = mo11321b();
            if (b == null) {
                b = new SimpleDateFormat(str, this.f2850f);
                b.setTimeZone(this.f2849e);
            }
            this.f2846b.mo11384a(b.format((Date) obj));
        } else if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if ("gzip".equals(str) || "gzip,base64".equals(str)) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    if (bArr.length < 512) {
                        gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream, bArr.length);
                    } else {
                        gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    }
                    GZIPOutputStream gZIPOutputStream2 = gZIPOutputStream;
                    gZIPOutputStream2.write(bArr);
                    gZIPOutputStream2.finish();
                    this.f2846b.mo11388a(byteArrayOutputStream.toByteArray());
                    IOUtils.m3194a((Closeable) gZIPOutputStream2);
                } catch (IOException e) {
                    throw new JSONException("write gzipBytes error", e);
                } catch (Throwable th) {
                    IOUtils.m3194a((Closeable) null);
                    throw th;
                }
            } else if ("hex".equals(str)) {
                this.f2846b.mo11401b(bArr);
            } else {
                this.f2846b.mo11388a(bArr);
            }
        } else {
            mo11325c(obj);
        }
    }

    /* renamed from: b */
    public final void mo11323b(String str) {
        StringCodec.f2926a.mo11412a(this, str);
    }

    /* renamed from: a */
    public ObjectSerializer mo11309a(Class<?> cls) {
        return this.f2845a.mo11355b(cls);
    }
}
