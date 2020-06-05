package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/* renamed from: com.alibaba.fastjson.serializer.z */
public class FieldSerializer implements Comparable<FieldSerializer> {
    /* renamed from: a */
    public final FieldInfo f2956a;
    /* renamed from: b */
    protected final boolean f2957b;
    /* renamed from: c */
    protected int f2958c;
    /* renamed from: d */
    protected BeanContext f2959d;
    /* renamed from: e */
    protected boolean f2960e = false;
    /* renamed from: f */
    protected boolean f2961f = false;
    /* renamed from: g */
    protected boolean f2962g = false;
    /* renamed from: h */
    protected boolean f2963h = false;
    /* renamed from: i */
    protected boolean f2964i = false;
    /* renamed from: j */
    private final String f2965j;
    /* renamed from: k */
    private String f2966k;
    /* renamed from: l */
    private String f2967l;
    /* renamed from: m */
    private String f2968m;
    /* renamed from: n */
    private C1264a f2969n;

    /* compiled from: FieldSerializer */
    /* renamed from: com.alibaba.fastjson.serializer.z$a */
    static class C1264a {
        /* renamed from: a */
        final ObjectSerializer f2970a;
        /* renamed from: b */
        final Class<?> f2971b;

        public C1264a(ObjectSerializer aqVar, Class<?> cls) {
            this.f2970a = aqVar;
            this.f2971b = cls;
        }
    }

    public FieldSerializer(Class<?> cls, FieldInfo cVar) {
        boolean z;
        SerializerFeature[] serialzeFeatures;
        SerializerFeature[] serialzeFeatures2;
        boolean z2 = false;
        this.f2956a = cVar;
        this.f2959d = new BeanContext(cls, cVar);
        if (cls != null && cVar.f3005n) {
            JSONType jSONType = (JSONType) TypeUtils.m3228a(cls, JSONType.class);
            if (jSONType != null) {
                for (SerializerFeature serializerFeature : jSONType.serialzeFeatures()) {
                    if (serializerFeature == SerializerFeature.WriteEnumUsingToString) {
                        this.f2960e = true;
                    } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                        this.f2961f = true;
                    } else if (serializerFeature == SerializerFeature.DisableCircularReferenceDetect) {
                        this.f2962g = true;
                    }
                }
            }
        }
        cVar.mo11508f();
        StringBuilder sb = new StringBuilder();
        sb.append('\"');
        sb.append(cVar.f2992a);
        sb.append("\":");
        this.f2965j = sb.toString();
        JSONField d = cVar.mo11506d();
        if (d != null) {
            SerializerFeature[] serialzeFeatures3 = d.serialzeFeatures();
            int length = serialzeFeatures3.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else if ((serialzeFeatures3[i].getMask() & SerializerFeature.WRITE_MAP_NULL_FEATURES) != 0) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            this.f2968m = d.format();
            if (this.f2968m.trim().length() == 0) {
                this.f2968m = null;
            }
            for (SerializerFeature serializerFeature2 : d.serialzeFeatures()) {
                if (serializerFeature2 == SerializerFeature.WriteEnumUsingToString) {
                    this.f2960e = true;
                } else if (serializerFeature2 == SerializerFeature.WriteEnumUsingName) {
                    this.f2961f = true;
                } else if (serializerFeature2 == SerializerFeature.DisableCircularReferenceDetect) {
                    this.f2962g = true;
                }
            }
            this.f2958c = SerializerFeature.m2926of(d.serialzeFeatures());
        } else {
            z = false;
        }
        this.f2957b = z;
        if (TypeUtils.m3248b(cVar.f2993b) || TypeUtils.m3253c(cVar.f2993b)) {
            z2 = true;
        }
        this.f2964i = z2;
    }

    /* renamed from: a */
    public void mo11431a(JSONSerializer agVar) throws IOException {
        SerializeWriter baVar = agVar.f2846b;
        if (!baVar.f2912e) {
            if (this.f2967l == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f2956a.f2992a);
                sb.append(":");
                this.f2967l = sb.toString();
            }
            baVar.write(this.f2967l);
        } else if (baVar.f2911d) {
            if (this.f2966k == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append('\'');
                sb2.append(this.f2956a.f2992a);
                sb2.append("':");
                this.f2966k = sb2.toString();
            }
            baVar.write(this.f2966k);
        } else {
            baVar.write(this.f2965j);
        }
    }

    /* renamed from: a */
    public Object mo11430a(Object obj) throws InvocationTargetException, IllegalAccessException {
        Object a = this.f2956a.mo11500a(obj);
        if (!this.f2964i || TypeUtils.m3277p(a)) {
            return a;
        }
        return null;
    }

    /* renamed from: b */
    public Object mo11433b(Object obj) throws InvocationTargetException, IllegalAccessException {
        Object a = this.f2956a.mo11500a(obj);
        if (this.f2968m == null || a == null || this.f2956a.f2995d != Date.class) {
            return a;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.f2968m);
        simpleDateFormat.setTimeZone(JSON.defaultTimeZone);
        return simpleDateFormat.format(a);
    }

    /* renamed from: a */
    public int compareTo(FieldSerializer zVar) {
        return this.f2956a.compareTo(zVar.f2956a);
    }

    /* renamed from: a */
    public void mo11432a(JSONSerializer agVar, Object obj) throws Exception {
        ObjectSerializer aqVar;
        Class<?> cls;
        if (this.f2969n == null) {
            if (obj == null) {
                cls = this.f2956a.f2995d;
            } else {
                cls = obj.getClass();
            }
            ObjectSerializer aqVar2 = null;
            JSONField d = this.f2956a.mo11506d();
            if (d == null || d.serializeUsing() == Void.class) {
                if (this.f2968m != null) {
                    if (cls == Double.TYPE || cls == Double.class) {
                        aqVar2 = new DoubleSerializer(this.f2968m);
                    } else if (cls == Float.TYPE || cls == Float.class) {
                        aqVar2 = new FloatCodec(this.f2968m);
                    }
                }
                if (aqVar2 == null) {
                    aqVar2 = agVar.mo11309a(cls);
                }
            } else {
                aqVar2 = (ObjectSerializer) d.serializeUsing().newInstance();
                this.f2963h = true;
            }
            this.f2969n = new C1264a(aqVar2, cls);
        }
        C1264a aVar = this.f2969n;
        int mask = this.f2962g ? this.f2956a.f2999h | SerializerFeature.DisableCircularReferenceDetect.getMask() : this.f2956a.f2999h;
        if (obj == null) {
            SerializeWriter baVar = agVar.f2846b;
            if (this.f2956a.f2995d != Object.class || !baVar.mo11390a(SerializerFeature.WRITE_MAP_NULL_FEATURES)) {
                Class<?> cls2 = aVar.f2971b;
                if (Number.class.isAssignableFrom(cls2)) {
                    baVar.mo11380a(this.f2958c, SerializerFeature.WriteNullNumberAsZero.mask);
                } else if (String.class == cls2) {
                    baVar.mo11380a(this.f2958c, SerializerFeature.WriteNullStringAsEmpty.mask);
                } else if (Boolean.class == cls2) {
                    baVar.mo11380a(this.f2958c, SerializerFeature.WriteNullBooleanAsFalse.mask);
                } else if (Collection.class.isAssignableFrom(cls2)) {
                    baVar.mo11380a(this.f2958c, SerializerFeature.WriteNullListAsEmpty.mask);
                } else {
                    ObjectSerializer aqVar3 = aVar.f2970a;
                    if (!baVar.mo11390a(SerializerFeature.WRITE_MAP_NULL_FEATURES) || !(aqVar3 instanceof JavaBeanSerializer)) {
                        aqVar3.mo11198a(agVar, null, this.f2956a.f2992a, this.f2956a.f2996e, mask);
                    } else {
                        baVar.mo11396b();
                    }
                }
            } else {
                baVar.mo11396b();
            }
        } else {
            if (this.f2956a.f3005n) {
                if (this.f2961f) {
                    agVar.f2846b.mo11384a(((Enum) obj).name());
                    return;
                } else if (this.f2960e) {
                    agVar.f2846b.mo11384a(((Enum) obj).toString());
                    return;
                }
            }
            Class<?> cls3 = obj.getClass();
            if (cls3 == aVar.f2971b || this.f2963h) {
                aqVar = aVar.f2970a;
            } else {
                aqVar = agVar.mo11309a(cls3);
            }
            ObjectSerializer aqVar4 = aqVar;
            String str = this.f2968m;
            if (str == null || (aqVar4 instanceof DoubleSerializer) || (aqVar4 instanceof FloatCodec)) {
                if (this.f2956a.f3007p) {
                    if (aqVar4 instanceof JavaBeanSerializer) {
                        ((JavaBeanSerializer) aqVar4).mo11336a(agVar, obj, this.f2956a.f2992a, this.f2956a.f2996e, mask, true);
                        return;
                    } else if (aqVar4 instanceof MapSerializer) {
                        ((MapSerializer) aqVar4).mo11346a(agVar, obj, this.f2956a.f2992a, this.f2956a.f2996e, mask, true);
                        return;
                    }
                }
                if ((this.f2958c & SerializerFeature.WriteClassName.mask) == 0 || cls3 == this.f2956a.f2995d || !JavaBeanSerializer.class.isInstance(aqVar4)) {
                    aqVar4.mo11198a(agVar, obj, this.f2956a.f2992a, this.f2956a.f2996e, mask);
                } else {
                    ((JavaBeanSerializer) aqVar4).mo11336a(agVar, obj, this.f2956a.f2992a, this.f2956a.f2996e, mask, false);
                }
            } else {
                if (aqVar4 instanceof ContextObjectSerializer) {
                    ((ContextObjectSerializer) aqVar4).mo11197a(agVar, obj, this.f2959d);
                } else {
                    agVar.mo11316a(obj, str);
                }
            }
        }
    }
}
