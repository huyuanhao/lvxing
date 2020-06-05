package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.p066a.Jdk8DateCodec;
import com.alibaba.fastjson.parser.p066a.OptionalCodec;
import com.alibaba.fastjson.support.p067a.SwaggerJsonSerializer;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.ServiceLoader;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Clob;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.xml.datatype.XMLGregorianCalendar;

/* renamed from: com.alibaba.fastjson.serializer.ax */
public class SerializeConfig {
    /* renamed from: a */
    public static final SerializeConfig f2882a = new SerializeConfig();
    /* renamed from: d */
    private static boolean f2883d = false;
    /* renamed from: e */
    private static boolean f2884e = false;
    /* renamed from: f */
    private static boolean f2885f = false;
    /* renamed from: g */
    private static boolean f2886g = false;
    /* renamed from: h */
    private static boolean f2887h = false;
    /* renamed from: i */
    private static boolean f2888i = false;
    /* renamed from: b */
    protected String f2889b;
    /* renamed from: c */
    public PropertyNamingStrategy f2890c;
    /* renamed from: j */
    private boolean f2891j;
    /* renamed from: k */
    private ASMSerializerFactory f2892k;
    /* renamed from: l */
    private final IdentityHashMap<Type, ObjectSerializer> f2893l;
    /* renamed from: m */
    private final boolean f2894m;

    /* renamed from: b */
    private final JavaBeanSerializer m3035b(SerializeBeanInfo awVar) throws Exception {
        JavaBeanSerializer a = this.f2892k.mo11305a(awVar);
        for (FieldSerializer zVar : a.f2856b) {
            Class<?> cls = zVar.f2956a.f2995d;
            if (cls.isEnum() && !(mo11355b(cls) instanceof EnumSerializer)) {
                a.f2903o = false;
            }
        }
        return a;
    }

    /* renamed from: a */
    public final ObjectSerializer mo11353a(Class<?> cls) {
        SerializeBeanInfo a = TypeUtils.m3218a(cls, null, this.f2890c, this.f2894m);
        if (a.f2879e.length != 0 || !Iterable.class.isAssignableFrom(cls)) {
            return mo11352a(a);
        }
        return MiscCodec.f2864a;
    }

    /* renamed from: a */
    public ObjectSerializer mo11352a(SerializeBeanInfo awVar) {
        Object obj;
        JSONType jSONType = awVar.f2878d;
        boolean z = false;
        boolean z2 = this.f2891j && !this.f2894m;
        if (jSONType != null) {
            Class<Void> serializer = jSONType.serializer();
            if (serializer != Void.class) {
                try {
                    Object newInstance = serializer.newInstance();
                    if (newInstance instanceof ObjectSerializer) {
                        return (ObjectSerializer) newInstance;
                    }
                } catch (Throwable unused) {
                }
            }
            if (!jSONType.asm()) {
                z2 = false;
            }
            SerializerFeature[] serialzeFeatures = jSONType.serialzeFeatures();
            int length = serialzeFeatures.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                SerializerFeature serializerFeature = serialzeFeatures[i];
                if (SerializerFeature.WriteNonStringValueAsString == serializerFeature || SerializerFeature.WriteEnumUsingToString == serializerFeature || SerializerFeature.NotWriteDefaultValue == serializerFeature) {
                    z2 = false;
                } else {
                    i++;
                }
            }
            z2 = false;
        }
        Class cls = awVar.f2875a;
        if (!Modifier.isPublic(awVar.f2875a.getModifiers())) {
            return new JavaBeanSerializer(awVar);
        }
        if ((z2 && this.f2892k.f2827a.mo11496a(cls)) || cls == Serializable.class || cls == Object.class) {
            z2 = false;
        }
        if (z2 && !ASMUtils.m3172b(cls.getSimpleName())) {
            z2 = false;
        }
        if (z2 && awVar.f2875a.isInterface()) {
            z2 = false;
        }
        if (z2) {
            FieldInfo[] cVarArr = awVar.f2879e;
            int length2 = cVarArr.length;
            boolean z3 = z2;
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    z = z3;
                    break;
                }
                FieldInfo cVar = cVarArr[i2];
                Field field = cVar.f2994c;
                if (field != null && !field.getType().equals(cVar.f2995d)) {
                    break;
                }
                Method method = cVar.f2993b;
                if (method != null && !method.getReturnType().equals(cVar.f2995d)) {
                    break;
                }
                JSONField d = cVar.mo11506d();
                if (d != null) {
                    String format = d.format();
                    if ((format.length() != 0 && (cVar.f2995d != String.class || !"trim".equals(format))) || !ASMUtils.m3172b(d.name()) || d.jsonDirect() || d.serializeUsing() != Void.class || d.unwrapped()) {
                        break;
                    }
                    SerializerFeature[] serialzeFeatures2 = d.serialzeFeatures();
                    int length3 = serialzeFeatures2.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length3) {
                            break;
                        }
                        SerializerFeature serializerFeature2 = serialzeFeatures2[i3];
                        if (SerializerFeature.WriteNonStringValueAsString == serializerFeature2 || SerializerFeature.WriteEnumUsingToString == serializerFeature2 || SerializerFeature.NotWriteDefaultValue == serializerFeature2 || SerializerFeature.WriteClassName == serializerFeature2) {
                            z3 = false;
                        } else {
                            i3++;
                        }
                    }
                    z3 = false;
                    if (TypeUtils.m3248b(method) || TypeUtils.m3253c(method)) {
                        z = true;
                    }
                }
                i2++;
            }
        } else {
            z = z2;
        }
        if (z) {
            try {
                obj = cls;
                ObjectSerializer b = m3035b(awVar);
                obj = b;
                if (b != 0) {
                    return b;
                }
            } catch (ClassCastException | ClassFormatError | ClassNotFoundException unused2) {
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("create asm serializer error, class ");
                sb.append(obj);
                throw new JSONException(sb.toString(), th);
            }
        }
        return new JavaBeanSerializer(awVar);
    }

    /* renamed from: a */
    public static SerializeConfig m3034a() {
        return f2882a;
    }

    public SerializeConfig() {
        this(8192);
    }

    public SerializeConfig(int i) {
        this(i, false);
    }

    public SerializeConfig(int i, boolean z) {
        this.f2891j = !ASMUtils.f2991b;
        this.f2889b = JSON.DEFAULT_TYPE_KEY;
        this.f2894m = z;
        this.f2893l = new IdentityHashMap<>(i);
        try {
            if (this.f2891j) {
                this.f2892k = new ASMSerializerFactory();
            }
        } catch (Throwable unused) {
            this.f2891j = false;
        }
        mo11354a((Type) Boolean.class, (ObjectSerializer) BooleanCodec.f2945a);
        mo11354a((Type) Character.class, (ObjectSerializer) CharacterCodec.f2948a);
        mo11354a((Type) Byte.class, (ObjectSerializer) IntegerCodec.f2842a);
        mo11354a((Type) Short.class, (ObjectSerializer) IntegerCodec.f2842a);
        mo11354a((Type) Integer.class, (ObjectSerializer) IntegerCodec.f2842a);
        mo11354a((Type) Long.class, (ObjectSerializer) LongCodec.f2861a);
        mo11354a((Type) Float.class, (ObjectSerializer) FloatCodec.f2839a);
        mo11354a((Type) Double.class, (ObjectSerializer) DoubleSerializer.f2952a);
        mo11354a((Type) BigDecimal.class, (ObjectSerializer) BigDecimalCodec.f2943a);
        mo11354a((Type) BigInteger.class, (ObjectSerializer) BigIntegerCodec.f2944a);
        mo11354a((Type) String.class, (ObjectSerializer) StringCodec.f2926a);
        mo11354a((Type) byte[].class, (ObjectSerializer) PrimitiveArraySerializer.f2869a);
        mo11354a((Type) short[].class, (ObjectSerializer) PrimitiveArraySerializer.f2869a);
        mo11354a((Type) int[].class, (ObjectSerializer) PrimitiveArraySerializer.f2869a);
        mo11354a((Type) long[].class, (ObjectSerializer) PrimitiveArraySerializer.f2869a);
        mo11354a((Type) float[].class, (ObjectSerializer) PrimitiveArraySerializer.f2869a);
        mo11354a((Type) double[].class, (ObjectSerializer) PrimitiveArraySerializer.f2869a);
        mo11354a((Type) boolean[].class, (ObjectSerializer) PrimitiveArraySerializer.f2869a);
        mo11354a((Type) char[].class, (ObjectSerializer) PrimitiveArraySerializer.f2869a);
        mo11354a((Type) Object[].class, (ObjectSerializer) ObjectArrayCodec.f2868a);
        mo11354a((Type) Class.class, (ObjectSerializer) MiscCodec.f2864a);
        mo11354a((Type) SimpleDateFormat.class, (ObjectSerializer) MiscCodec.f2864a);
        mo11354a((Type) Currency.class, (ObjectSerializer) new MiscCodec());
        mo11354a((Type) TimeZone.class, (ObjectSerializer) MiscCodec.f2864a);
        mo11354a((Type) InetAddress.class, (ObjectSerializer) MiscCodec.f2864a);
        mo11354a((Type) Inet4Address.class, (ObjectSerializer) MiscCodec.f2864a);
        mo11354a((Type) Inet6Address.class, (ObjectSerializer) MiscCodec.f2864a);
        mo11354a((Type) InetSocketAddress.class, (ObjectSerializer) MiscCodec.f2864a);
        mo11354a((Type) File.class, (ObjectSerializer) MiscCodec.f2864a);
        mo11354a((Type) Appendable.class, (ObjectSerializer) AppendableSerializer.f2932a);
        mo11354a((Type) StringBuffer.class, (ObjectSerializer) AppendableSerializer.f2932a);
        mo11354a((Type) StringBuilder.class, (ObjectSerializer) AppendableSerializer.f2932a);
        mo11354a((Type) Charset.class, (ObjectSerializer) ToStringSerializer.f2927a);
        mo11354a((Type) Pattern.class, (ObjectSerializer) ToStringSerializer.f2927a);
        mo11354a((Type) Locale.class, (ObjectSerializer) ToStringSerializer.f2927a);
        mo11354a((Type) URI.class, (ObjectSerializer) ToStringSerializer.f2927a);
        mo11354a((Type) URL.class, (ObjectSerializer) ToStringSerializer.f2927a);
        mo11354a((Type) UUID.class, (ObjectSerializer) ToStringSerializer.f2927a);
        mo11354a((Type) AtomicBoolean.class, (ObjectSerializer) AtomicCodec.f2935a);
        mo11354a((Type) AtomicInteger.class, (ObjectSerializer) AtomicCodec.f2935a);
        mo11354a((Type) AtomicLong.class, (ObjectSerializer) AtomicCodec.f2935a);
        mo11354a((Type) AtomicReference.class, (ObjectSerializer) ReferenceCodec.f2870a);
        mo11354a((Type) AtomicIntegerArray.class, (ObjectSerializer) AtomicCodec.f2935a);
        mo11354a((Type) AtomicLongArray.class, (ObjectSerializer) AtomicCodec.f2935a);
        mo11354a((Type) WeakReference.class, (ObjectSerializer) ReferenceCodec.f2870a);
        mo11354a((Type) SoftReference.class, (ObjectSerializer) ReferenceCodec.f2870a);
        mo11354a((Type) LinkedList.class, (ObjectSerializer) CollectionCodec.f2950a);
    }

    /* renamed from: b */
    public ObjectSerializer mo11355b(Class<?> cls) {
        return m3033a(cls, true);
    }

    /* renamed from: a */
    private ObjectSerializer m3033a(Class<?> cls, boolean z) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String[] strArr4;
        String[] strArr5;
        String[] strArr6;
        Class<?> cls2 = cls;
        ObjectSerializer aqVar = (ObjectSerializer) this.f2893l.mo11513a(cls2);
        if (aqVar == null) {
            try {
                for (Object next : ServiceLoader.m3214a(AutowiredObjectSerializer.class, Thread.currentThread().getContextClassLoader())) {
                    if (next instanceof AutowiredObjectSerializer) {
                        AutowiredObjectSerializer hVar = (AutowiredObjectSerializer) next;
                        for (Type a : hVar.mo11416a()) {
                            mo11354a(a, (ObjectSerializer) hVar);
                        }
                    }
                }
            } catch (ClassCastException unused) {
            }
            aqVar = (ObjectSerializer) this.f2893l.mo11513a(cls2);
        }
        if (aqVar == null) {
            ClassLoader classLoader = JSON.class.getClassLoader();
            if (classLoader != Thread.currentThread().getContextClassLoader()) {
                try {
                    for (Object next2 : ServiceLoader.m3214a(AutowiredObjectSerializer.class, classLoader)) {
                        if (next2 instanceof AutowiredObjectSerializer) {
                            AutowiredObjectSerializer hVar2 = (AutowiredObjectSerializer) next2;
                            for (Type a2 : hVar2.mo11416a()) {
                                mo11354a(a2, (ObjectSerializer) hVar2);
                            }
                        }
                    }
                } catch (ClassCastException unused2) {
                }
                aqVar = (ObjectSerializer) this.f2893l.mo11513a(cls2);
            }
        }
        if (aqVar == null) {
            String name = cls.getName();
            if (Map.class.isAssignableFrom(cls2)) {
                aqVar = MapSerializer.f2862a;
                mo11354a((Type) cls2, aqVar);
            } else if (List.class.isAssignableFrom(cls2)) {
                aqVar = ListSerializer.f2860a;
                mo11354a((Type) cls2, aqVar);
            } else if (Collection.class.isAssignableFrom(cls2)) {
                aqVar = CollectionCodec.f2950a;
                mo11354a((Type) cls2, aqVar);
            } else if (Date.class.isAssignableFrom(cls2)) {
                aqVar = DateCodec.f2951a;
                mo11354a((Type) cls2, aqVar);
            } else if (JSONAware.class.isAssignableFrom(cls2)) {
                aqVar = JSONAwareSerializer.f2843a;
                mo11354a((Type) cls2, aqVar);
            } else if (JSONSerializable.class.isAssignableFrom(cls2)) {
                aqVar = JSONSerializableSerializer.f2844a;
                mo11354a((Type) cls2, aqVar);
            } else if (JSONStreamAware.class.isAssignableFrom(cls2)) {
                aqVar = MiscCodec.f2864a;
                mo11354a((Type) cls2, aqVar);
            } else if (cls.isEnum()) {
                JSONType jSONType = (JSONType) TypeUtils.m3228a(cls2, JSONType.class);
                if (jSONType == null || !jSONType.serializeEnumAsJavaBean()) {
                    aqVar = EnumSerializer.f2954a;
                    mo11354a((Type) cls2, aqVar);
                } else {
                    aqVar = mo11353a(cls);
                    mo11354a((Type) cls2, aqVar);
                }
            } else {
                Class superclass = cls.getSuperclass();
                if (superclass != null && superclass.isEnum()) {
                    JSONType jSONType2 = (JSONType) TypeUtils.m3228a(superclass, JSONType.class);
                    if (jSONType2 == null || !jSONType2.serializeEnumAsJavaBean()) {
                        aqVar = EnumSerializer.f2954a;
                        mo11354a((Type) cls2, aqVar);
                    } else {
                        aqVar = mo11353a(cls);
                        mo11354a((Type) cls2, aqVar);
                    }
                } else if (cls.isArray()) {
                    Class componentType = cls.getComponentType();
                    ObjectSerializer fVar = new ArraySerializer(componentType, mo11355b(componentType));
                    mo11354a((Type) cls2, fVar);
                    aqVar = fVar;
                } else {
                    Class cls3 = null;
                    if (Throwable.class.isAssignableFrom(cls2)) {
                        SerializeBeanInfo a3 = TypeUtils.m3217a(cls2, null, this.f2890c);
                        a3.f2881g |= SerializerFeature.WriteClassName.mask;
                        ObjectSerializer ahVar = new JavaBeanSerializer(a3);
                        mo11354a((Type) cls2, ahVar);
                        aqVar = ahVar;
                    } else if (TimeZone.class.isAssignableFrom(cls2) || Entry.class.isAssignableFrom(cls2)) {
                        aqVar = MiscCodec.f2864a;
                        mo11354a((Type) cls2, aqVar);
                    } else if (Appendable.class.isAssignableFrom(cls2)) {
                        aqVar = AppendableSerializer.f2932a;
                        mo11354a((Type) cls2, aqVar);
                    } else if (Charset.class.isAssignableFrom(cls2)) {
                        aqVar = ToStringSerializer.f2927a;
                        mo11354a((Type) cls2, aqVar);
                    } else if (Enumeration.class.isAssignableFrom(cls2)) {
                        aqVar = EnumerationSerializer.f2955a;
                        mo11354a((Type) cls2, aqVar);
                    } else if (Calendar.class.isAssignableFrom(cls2) || XMLGregorianCalendar.class.isAssignableFrom(cls2)) {
                        aqVar = CalendarCodec.f2946a;
                        mo11354a((Type) cls2, aqVar);
                    } else if (Clob.class.isAssignableFrom(cls2)) {
                        aqVar = ClobSeriliazer.f2949a;
                        mo11354a((Type) cls2, aqVar);
                    } else if (TypeUtils.m3237a(cls)) {
                        aqVar = ToStringSerializer.f2927a;
                        mo11354a((Type) cls2, aqVar);
                    } else if (Iterator.class.isAssignableFrom(cls2)) {
                        aqVar = MiscCodec.f2864a;
                        mo11354a((Type) cls2, aqVar);
                    } else {
                        int i = 0;
                        if (name.startsWith("java.awt.") && AwtCodec.m3106a(cls) && !f2883d) {
                            try {
                                for (String str : new String[]{"java.awt.Color", "java.awt.Font", "java.awt.Point", "java.awt.Rectangle"}) {
                                    if (str.equals(name)) {
                                        Class cls4 = Class.forName(str);
                                        AwtCodec iVar = AwtCodec.f2936a;
                                        mo11354a((Type) cls4, (ObjectSerializer) iVar);
                                        return iVar;
                                    }
                                }
                            } catch (Throwable unused3) {
                                f2883d = true;
                            }
                        }
                        if (!f2884e) {
                            String str2 = "java.util.concurrent.atomic.DoubleAdder";
                            String str3 = "java.util.concurrent.atomic.LongAdder";
                            String str4 = "java.util.Optional";
                            if (name.startsWith("java.time.") || name.startsWith(str4) || name.equals(str3) || name.equals(str2)) {
                                try {
                                    for (String str5 : new String[]{"java.time.LocalDateTime", "java.time.LocalDate", "java.time.LocalTime", "java.time.ZonedDateTime", "java.time.OffsetDateTime", "java.time.OffsetTime", "java.time.ZoneOffset", "java.time.ZoneRegion", "java.time.Period", "java.time.Duration", "java.time.Instant"}) {
                                        if (str5.equals(name)) {
                                            Class cls5 = Class.forName(str5);
                                            Jdk8DateCodec pVar = Jdk8DateCodec.f2736a;
                                            mo11354a((Type) cls5, (ObjectSerializer) pVar);
                                            return pVar;
                                        }
                                    }
                                    for (String str6 : new String[]{str4, "java.util.OptionalDouble", "java.util.OptionalInt", "java.util.OptionalLong"}) {
                                        if (str6.equals(name)) {
                                            Class cls6 = Class.forName(str6);
                                            OptionalCodec tVar = OptionalCodec.f2758a;
                                            mo11354a((Type) cls6, (ObjectSerializer) tVar);
                                            return tVar;
                                        }
                                    }
                                    for (String str7 : new String[]{str3, str2}) {
                                        if (str7.equals(name)) {
                                            Class cls7 = Class.forName(str7);
                                            AdderSerializer bVar = AdderSerializer.f2904a;
                                            mo11354a((Type) cls7, (ObjectSerializer) bVar);
                                            return bVar;
                                        }
                                    }
                                } catch (Throwable unused4) {
                                    f2884e = true;
                                }
                            }
                        }
                        if (!f2885f && name.startsWith("oracle.sql.")) {
                            try {
                                for (String str8 : new String[]{"oracle.sql.DATE", "oracle.sql.TIMESTAMP"}) {
                                    if (str8.equals(name)) {
                                        Class cls8 = Class.forName(str8);
                                        DateCodec vVar = DateCodec.f2951a;
                                        mo11354a((Type) cls8, (ObjectSerializer) vVar);
                                        return vVar;
                                    }
                                }
                            } catch (Throwable unused5) {
                                f2885f = true;
                            }
                        }
                        if (!f2886g) {
                            String str9 = "springfox.documentation.spring.web.json.Json";
                            if (name.equals(str9)) {
                                try {
                                    Class cls9 = Class.forName(str9);
                                    aqVar = SwaggerJsonSerializer.f2972a;
                                    mo11354a((Type) cls9, aqVar);
                                    return aqVar;
                                } catch (ClassNotFoundException unused6) {
                                    f2886g = true;
                                }
                            }
                        }
                        if (!f2887h && name.startsWith("com.google.common.collect.")) {
                            try {
                                for (String str10 : new String[]{"com.google.common.collect.HashMultimap", "com.google.common.collect.LinkedListMultimap", "com.google.common.collect.ArrayListMultimap", "com.google.common.collect.TreeMultimap"}) {
                                    if (str10.equals(name)) {
                                        Class cls10 = Class.forName(str10);
                                        GuavaCodec abVar = GuavaCodec.f2841a;
                                        mo11354a((Type) cls10, (ObjectSerializer) abVar);
                                        return abVar;
                                    }
                                }
                            } catch (ClassNotFoundException unused7) {
                                f2887h = true;
                            }
                        }
                        if (!f2888i) {
                            String str11 = "net.sf.json.JSONNull";
                            if (name.equals(str11)) {
                                try {
                                    Class cls11 = Class.forName(str11);
                                    aqVar = MiscCodec.f2864a;
                                    mo11354a((Type) cls11, aqVar);
                                    return aqVar;
                                } catch (ClassNotFoundException unused8) {
                                    f2888i = true;
                                }
                            }
                        }
                        Class[] interfaces = cls.getInterfaces();
                        if (interfaces.length == 1 && interfaces[0].isAnnotation()) {
                            return AnnotationSerializer.f2931a;
                        }
                        if (TypeUtils.m3252c(cls)) {
                            ObjectSerializer b = mo11355b(cls.getSuperclass());
                            mo11354a((Type) cls2, b);
                            return b;
                        }
                        if (Proxy.isProxyClass(cls)) {
                            if (interfaces.length != 2) {
                                int length = interfaces.length;
                                Class cls12 = null;
                                while (true) {
                                    if (i >= length) {
                                        cls3 = cls12;
                                        break;
                                    }
                                    Class cls13 = interfaces[i];
                                    if (!cls13.getName().startsWith("org.springframework.aop.")) {
                                        if (cls12 != null) {
                                            break;
                                        }
                                        cls12 = cls13;
                                    }
                                    i++;
                                }
                            } else {
                                cls3 = interfaces[1];
                            }
                            if (cls3 != null) {
                                ObjectSerializer b2 = mo11355b(cls3);
                                mo11354a((Type) cls2, b2);
                                return b2;
                            }
                        }
                        if (z) {
                            aqVar = mo11353a(cls);
                            mo11354a((Type) cls2, aqVar);
                        }
                    }
                }
            }
            if (aqVar == null) {
                aqVar = (ObjectSerializer) this.f2893l.mo11513a(cls2);
            }
        }
        return aqVar;
    }

    /* renamed from: a */
    public boolean mo11354a(Type type, ObjectSerializer aqVar) {
        return this.f2893l.mo11514a(type, aqVar);
    }
}
