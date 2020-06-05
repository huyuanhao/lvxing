package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.p066a.ASMDeserializerFactory;
import com.alibaba.fastjson.parser.p066a.ArrayListTypeFieldDeserializer;
import com.alibaba.fastjson.parser.p066a.AutowiredObjectDeserializer;
import com.alibaba.fastjson.parser.p066a.DefaultFieldDeserializer;
import com.alibaba.fastjson.parser.p066a.EnumDeserializer;
import com.alibaba.fastjson.parser.p066a.FieldDeserializer;
import com.alibaba.fastjson.parser.p066a.JSONPDeserializer;
import com.alibaba.fastjson.parser.p066a.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.p066a.JavaObjectDeserializer;
import com.alibaba.fastjson.parser.p066a.Jdk8DateCodec;
import com.alibaba.fastjson.parser.p066a.MapDeserializer;
import com.alibaba.fastjson.parser.p066a.NumberDeserializer;
import com.alibaba.fastjson.parser.p066a.ObjectDeserializer;
import com.alibaba.fastjson.parser.p066a.OptionalCodec;
import com.alibaba.fastjson.parser.p066a.PropertyProcessable;
import com.alibaba.fastjson.parser.p066a.PropertyProcessableDeserializer;
import com.alibaba.fastjson.parser.p066a.SqlDateDeserializer;
import com.alibaba.fastjson.parser.p066a.StackTraceElementDeserializer;
import com.alibaba.fastjson.parser.p066a.ThrowableDeserializer;
import com.alibaba.fastjson.parser.p066a.TimeDeserializer;
import com.alibaba.fastjson.serializer.AtomicCodec;
import com.alibaba.fastjson.serializer.AwtCodec;
import com.alibaba.fastjson.serializer.BigDecimalCodec;
import com.alibaba.fastjson.serializer.BigIntegerCodec;
import com.alibaba.fastjson.serializer.BooleanCodec;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.CharArrayCodec;
import com.alibaba.fastjson.serializer.CharacterCodec;
import com.alibaba.fastjson.serializer.CollectionCodec;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.FloatCodec;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.MiscCodec;
import com.alibaba.fastjson.serializer.ObjectArrayCodec;
import com.alibaba.fastjson.serializer.ReferenceCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.ServiceLoader;
import com.alibaba.fastjson.util.TypeUtils;
import com.tencent.mid.sotrage.StorageInterface;
import java.io.Closeable;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.AccessControlException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.sql.DataSource;
import javax.xml.datatype.XMLGregorianCalendar;

/* renamed from: com.alibaba.fastjson.parser.h */
public class ParserConfig {
    /* renamed from: a */
    public static final String[] f2799a = m2910c(IOUtils.m3190a("fastjson.parser.deny"));
    /* renamed from: b */
    public static final boolean f2800b = "true".equals(IOUtils.m3190a("fastjson.parser.autoTypeSupport"));
    /* renamed from: c */
    public static ParserConfig f2801c = new ParserConfig();
    /* renamed from: j */
    private static final String[] f2802j;
    /* renamed from: m */
    private static boolean f2803m = false;
    /* renamed from: n */
    private static boolean f2804n = false;
    /* renamed from: d */
    public final SymbolTable f2805d;
    /* renamed from: e */
    public PropertyNamingStrategy f2806e;
    /* renamed from: f */
    protected ClassLoader f2807f;
    /* renamed from: g */
    protected ASMDeserializerFactory f2808g;
    /* renamed from: h */
    public final boolean f2809h;
    /* renamed from: i */
    public boolean f2810i;
    /* renamed from: k */
    private final IdentityHashMap<Type, ObjectDeserializer> f2811k;
    /* renamed from: l */
    private boolean f2812l;
    /* renamed from: o */
    private boolean f2813o;
    /* renamed from: p */
    private String[] f2814p;
    /* renamed from: q */
    private String[] f2815q;

    static {
        String[] c = m2910c(IOUtils.m3190a("fastjson.parser.autoTypeAccept"));
        if (c == null) {
            c = new String[0];
        }
        f2802j = c;
    }

    /* renamed from: a */
    public static ParserConfig m2904a() {
        return f2801c;
    }

    public ParserConfig() {
        this(false);
    }

    public ParserConfig(boolean z) {
        this(null, null, z);
    }

    private ParserConfig(ASMDeserializerFactory aVar, ClassLoader classLoader, boolean z) {
        this.f2811k = new IdentityHashMap<>();
        this.f2812l = !ASMUtils.f2991b;
        this.f2805d = new SymbolTable(4096);
        this.f2813o = f2800b;
        this.f2814p = "bsh,com.mchange,com.sun.,java.lang.Thread,java.net.Socket,java.rmi,javax.xml,org.apache.bcel,org.apache.commons.beanutils,org.apache.commons.collections.Transformer,org.apache.commons.collections.functors,org.apache.commons.collections4.comparators,org.apache.commons.fileupload,org.apache.myfaces.context.servlet,org.apache.tomcat,org.apache.wicket.util,org.apache.xalan,org.codehaus.groovy.runtime,org.hibernate,org.jboss,org.mozilla.javascript,org.python.core,org.springframework".split(StorageInterface.KEY_SPLITER);
        this.f2815q = f2802j;
        this.f2810i = TypeUtils.f3060a;
        this.f2809h = z;
        if (aVar == null && !ASMUtils.f2991b) {
            if (classLoader == null) {
                try {
                    aVar = new ASMDeserializerFactory(new ASMClassLoader());
                } catch (ExceptionInInitializerError | NoClassDefFoundError | AccessControlException unused) {
                }
            } else {
                aVar = new ASMDeserializerFactory(classLoader);
            }
        }
        this.f2808g = aVar;
        if (aVar == null) {
            this.f2812l = false;
        }
        this.f2811k.mo11514a(SimpleDateFormat.class, MiscCodec.f2864a);
        this.f2811k.mo11514a(Timestamp.class, SqlDateDeserializer.f2767b);
        this.f2811k.mo11514a(Date.class, SqlDateDeserializer.f2766a);
        this.f2811k.mo11514a(Time.class, TimeDeserializer.f2715a);
        this.f2811k.mo11514a(java.util.Date.class, DateCodec.f2951a);
        this.f2811k.mo11514a(Calendar.class, CalendarCodec.f2946a);
        this.f2811k.mo11514a(XMLGregorianCalendar.class, CalendarCodec.f2946a);
        this.f2811k.mo11514a(JSONObject.class, MapDeserializer.f2756a);
        this.f2811k.mo11514a(JSONArray.class, CollectionCodec.f2950a);
        this.f2811k.mo11514a(Map.class, MapDeserializer.f2756a);
        this.f2811k.mo11514a(HashMap.class, MapDeserializer.f2756a);
        this.f2811k.mo11514a(LinkedHashMap.class, MapDeserializer.f2756a);
        this.f2811k.mo11514a(TreeMap.class, MapDeserializer.f2756a);
        this.f2811k.mo11514a(ConcurrentMap.class, MapDeserializer.f2756a);
        this.f2811k.mo11514a(ConcurrentHashMap.class, MapDeserializer.f2756a);
        this.f2811k.mo11514a(Collection.class, CollectionCodec.f2950a);
        this.f2811k.mo11514a(List.class, CollectionCodec.f2950a);
        this.f2811k.mo11514a(ArrayList.class, CollectionCodec.f2950a);
        this.f2811k.mo11514a(Object.class, JavaObjectDeserializer.f2735a);
        this.f2811k.mo11514a(String.class, StringCodec.f2926a);
        this.f2811k.mo11514a(StringBuffer.class, StringCodec.f2926a);
        this.f2811k.mo11514a(StringBuilder.class, StringCodec.f2926a);
        this.f2811k.mo11514a(Character.TYPE, CharacterCodec.f2948a);
        this.f2811k.mo11514a(Character.class, CharacterCodec.f2948a);
        this.f2811k.mo11514a(Byte.TYPE, NumberDeserializer.f2757a);
        this.f2811k.mo11514a(Byte.class, NumberDeserializer.f2757a);
        this.f2811k.mo11514a(Short.TYPE, NumberDeserializer.f2757a);
        this.f2811k.mo11514a(Short.class, NumberDeserializer.f2757a);
        this.f2811k.mo11514a(Integer.TYPE, IntegerCodec.f2842a);
        this.f2811k.mo11514a(Integer.class, IntegerCodec.f2842a);
        this.f2811k.mo11514a(Long.TYPE, LongCodec.f2861a);
        this.f2811k.mo11514a(Long.class, LongCodec.f2861a);
        this.f2811k.mo11514a(BigInteger.class, BigIntegerCodec.f2944a);
        this.f2811k.mo11514a(BigDecimal.class, BigDecimalCodec.f2943a);
        this.f2811k.mo11514a(Float.TYPE, FloatCodec.f2839a);
        this.f2811k.mo11514a(Float.class, FloatCodec.f2839a);
        this.f2811k.mo11514a(Double.TYPE, NumberDeserializer.f2757a);
        this.f2811k.mo11514a(Double.class, NumberDeserializer.f2757a);
        this.f2811k.mo11514a(Boolean.TYPE, BooleanCodec.f2945a);
        this.f2811k.mo11514a(Boolean.class, BooleanCodec.f2945a);
        this.f2811k.mo11514a(Class.class, MiscCodec.f2864a);
        this.f2811k.mo11514a(char[].class, new CharArrayCodec());
        this.f2811k.mo11514a(AtomicBoolean.class, BooleanCodec.f2945a);
        this.f2811k.mo11514a(AtomicInteger.class, IntegerCodec.f2842a);
        this.f2811k.mo11514a(AtomicLong.class, LongCodec.f2861a);
        this.f2811k.mo11514a(AtomicReference.class, ReferenceCodec.f2870a);
        this.f2811k.mo11514a(WeakReference.class, ReferenceCodec.f2870a);
        this.f2811k.mo11514a(SoftReference.class, ReferenceCodec.f2870a);
        this.f2811k.mo11514a(UUID.class, MiscCodec.f2864a);
        this.f2811k.mo11514a(TimeZone.class, MiscCodec.f2864a);
        this.f2811k.mo11514a(Locale.class, MiscCodec.f2864a);
        this.f2811k.mo11514a(Currency.class, MiscCodec.f2864a);
        this.f2811k.mo11514a(InetAddress.class, MiscCodec.f2864a);
        this.f2811k.mo11514a(Inet4Address.class, MiscCodec.f2864a);
        this.f2811k.mo11514a(Inet6Address.class, MiscCodec.f2864a);
        this.f2811k.mo11514a(InetSocketAddress.class, MiscCodec.f2864a);
        this.f2811k.mo11514a(File.class, MiscCodec.f2864a);
        this.f2811k.mo11514a(URI.class, MiscCodec.f2864a);
        this.f2811k.mo11514a(URL.class, MiscCodec.f2864a);
        this.f2811k.mo11514a(Pattern.class, MiscCodec.f2864a);
        this.f2811k.mo11514a(Charset.class, MiscCodec.f2864a);
        this.f2811k.mo11514a(JSONPath.class, MiscCodec.f2864a);
        this.f2811k.mo11514a(Number.class, NumberDeserializer.f2757a);
        this.f2811k.mo11514a(AtomicIntegerArray.class, AtomicCodec.f2935a);
        this.f2811k.mo11514a(AtomicLongArray.class, AtomicCodec.f2935a);
        this.f2811k.mo11514a(StackTraceElement.class, StackTraceElementDeserializer.f2769a);
        this.f2811k.mo11514a(Serializable.class, JavaObjectDeserializer.f2735a);
        this.f2811k.mo11514a(Cloneable.class, JavaObjectDeserializer.f2735a);
        this.f2811k.mo11514a(Comparable.class, JavaObjectDeserializer.f2735a);
        this.f2811k.mo11514a(Closeable.class, JavaObjectDeserializer.f2735a);
        this.f2811k.mo11514a(JSONPObject.class, new JSONPDeserializer());
        m2907a(f2799a);
        m2909b(f2802j);
    }

    /* renamed from: c */
    private static String[] m2910c(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str.split(StorageInterface.KEY_SPLITER);
    }

    /* renamed from: a */
    private void m2907a(String[] strArr) {
        if (strArr != null) {
            for (String a : strArr) {
                mo11295a(a);
            }
        }
    }

    /* renamed from: b */
    private void m2909b(String[] strArr) {
        if (strArr != null) {
            for (String b : strArr) {
                mo11299b(b);
            }
        }
    }

    /* renamed from: b */
    public IdentityHashMap<Type, ObjectDeserializer> mo11298b() {
        return this.f2811k;
    }

    /* renamed from: a */
    public ObjectDeserializer mo11292a(Type type) {
        ObjectDeserializer sVar = (ObjectDeserializer) this.f2811k.mo11513a(type);
        if (sVar != null) {
            return sVar;
        }
        if (type instanceof Class) {
            return mo11291a((Class) type, type);
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return mo11291a((Class) rawType, type);
            }
            return mo11292a(rawType);
        }
        if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            if (upperBounds.length == 1) {
                return mo11292a(upperBounds[0]);
            }
        }
        return JavaObjectDeserializer.f2735a;
    }

    /* renamed from: a */
    public ObjectDeserializer mo11291a(Class<?> cls, Type type) {
        ObjectDeserializer sVar;
        String[] strArr;
        Class cls2 = cls;
        Type type2 = type;
        String str = "java.util.Optional";
        ObjectDeserializer sVar2 = (ObjectDeserializer) this.f2811k.mo11513a(type2);
        if (sVar2 != null) {
            return sVar2;
        }
        if (type2 == 0) {
            type2 = cls2;
        }
        ObjectDeserializer sVar3 = (ObjectDeserializer) this.f2811k.mo11513a(type2);
        if (sVar3 != null) {
            return sVar3;
        }
        JSONType jSONType = (JSONType) TypeUtils.m3228a(cls2, JSONType.class);
        if (jSONType != null) {
            Class<Void> mappingTo = jSONType.mappingTo();
            if (mappingTo != Void.class) {
                return mo11291a(mappingTo, (Type) mappingTo);
            }
        }
        if ((type2 instanceof WildcardType) || (type2 instanceof TypeVariable) || (type2 instanceof ParameterizedType)) {
            sVar3 = (ObjectDeserializer) this.f2811k.mo11513a(cls2);
        }
        if (sVar3 != null) {
            return sVar3;
        }
        String replace = cls.getName().replace('$', '.');
        int i = 0;
        if (replace.startsWith("java.awt.") && AwtCodec.m3106a(cls) && !f2803m) {
            try {
                for (String str2 : new String[]{"java.awt.Point", "java.awt.Font", "java.awt.Rectangle", "java.awt.Color"}) {
                    if (str2.equals(replace)) {
                        IdentityHashMap<Type, ObjectDeserializer> eVar = this.f2811k;
                        Class cls3 = Class.forName(str2);
                        AwtCodec iVar = AwtCodec.f2936a;
                        eVar.mo11514a(cls3, iVar);
                        return iVar;
                    }
                }
            } catch (Throwable unused) {
                f2803m = true;
            }
            sVar3 = AwtCodec.f2936a;
        }
        if (!f2804n) {
            try {
                if (replace.startsWith("java.time.")) {
                    String[] strArr2 = {"java.time.LocalDateTime", "java.time.LocalDate", "java.time.LocalTime", "java.time.ZonedDateTime", "java.time.OffsetDateTime", "java.time.OffsetTime", "java.time.ZoneOffset", "java.time.ZoneRegion", "java.time.ZoneId", "java.time.Period", "java.time.Duration", "java.time.Instant"};
                    int length = strArr2.length;
                    while (i < length) {
                        String str3 = strArr2[i];
                        if (str3.equals(replace)) {
                            IdentityHashMap<Type, ObjectDeserializer> eVar2 = this.f2811k;
                            Class cls4 = Class.forName(str3);
                            Jdk8DateCodec pVar = Jdk8DateCodec.f2736a;
                            eVar2.mo11514a(cls4, pVar);
                            return pVar;
                        }
                        i++;
                    }
                } else if (replace.startsWith(str)) {
                    String[] strArr3 = {str, "java.util.OptionalDouble", "java.util.OptionalInt", "java.util.OptionalLong"};
                    int length2 = strArr3.length;
                    while (i < length2) {
                        String str4 = strArr3[i];
                        if (str4.equals(replace)) {
                            IdentityHashMap<Type, ObjectDeserializer> eVar3 = this.f2811k;
                            Class cls5 = Class.forName(str4);
                            OptionalCodec tVar = OptionalCodec.f2758a;
                            eVar3.mo11514a(cls5, tVar);
                            return tVar;
                        }
                        i++;
                    }
                }
            } catch (Throwable unused2) {
                f2804n = true;
            }
        }
        if (replace.equals("java.nio.file.Path")) {
            IdentityHashMap<Type, ObjectDeserializer> eVar4 = this.f2811k;
            sVar3 = MiscCodec.f2864a;
            eVar4.mo11514a(cls2, sVar3);
        }
        if (cls2 == Entry.class) {
            IdentityHashMap<Type, ObjectDeserializer> eVar5 = this.f2811k;
            sVar3 = MiscCodec.f2864a;
            eVar5.mo11514a(cls2, sVar3);
        }
        try {
            for (AutowiredObjectDeserializer dVar : ServiceLoader.m3214a(AutowiredObjectDeserializer.class, Thread.currentThread().getContextClassLoader())) {
                for (Type a : dVar.mo11168a()) {
                    this.f2811k.mo11514a(a, dVar);
                }
            }
        } catch (Exception unused3) {
        }
        if (sVar3 == null) {
            sVar3 = (ObjectDeserializer) this.f2811k.mo11513a(type2);
        }
        if (sVar3 != null) {
            return sVar3;
        }
        if (cls.isEnum()) {
            JSONType jSONType2 = (JSONType) cls2.getAnnotation(JSONType.class);
            if (jSONType2 != null) {
                try {
                    ObjectDeserializer sVar4 = (ObjectDeserializer) jSONType2.deserializer().newInstance();
                    this.f2811k.mo11514a(cls2, sVar4);
                    return sVar4;
                } catch (Throwable unused4) {
                }
            }
            sVar = new EnumDeserializer(cls2);
        } else if (cls.isArray()) {
            sVar = ObjectArrayCodec.f2868a;
        } else if (cls2 == Set.class || cls2 == HashSet.class || cls2 == Collection.class || cls2 == List.class || cls2 == ArrayList.class) {
            sVar = CollectionCodec.f2950a;
        } else if (Collection.class.isAssignableFrom(cls2)) {
            sVar = CollectionCodec.f2950a;
        } else if (Map.class.isAssignableFrom(cls2)) {
            sVar = MapDeserializer.f2756a;
        } else if (Throwable.class.isAssignableFrom(cls2)) {
            sVar = new ThrowableDeserializer(this, cls2);
        } else if (PropertyProcessable.class.isAssignableFrom(cls2)) {
            sVar = new PropertyProcessableDeserializer(cls2);
        } else {
            sVar = mo11297b(cls2, type2);
        }
        mo11296a(type2, sVar);
        return sVar;
    }

    /* renamed from: b */
    public ObjectDeserializer mo11297b(Class<?> cls, Type type) {
        Class cls2;
        boolean z = this.f2812l & (!this.f2809h);
        if (z) {
            JSONType jSONType = (JSONType) TypeUtils.m3228a(cls, JSONType.class);
            if (jSONType != null) {
                Class<Void> deserializer = jSONType.deserializer();
                if (deserializer != Void.class) {
                    try {
                        Object newInstance = deserializer.newInstance();
                        if (newInstance instanceof ObjectDeserializer) {
                            return (ObjectDeserializer) newInstance;
                        }
                    } catch (Throwable unused) {
                    }
                }
                z = jSONType.asm();
            }
            if (z) {
                Class a = JavaBeanInfo.m3208a(cls, jSONType);
                if (a == null) {
                    a = cls;
                }
                while (true) {
                    if (Modifier.isPublic(a.getModifiers())) {
                        a = a.getSuperclass();
                        if (a != Object.class) {
                            if (a == null) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
            }
        }
        if (cls.getTypeParameters().length != 0) {
            z = false;
        }
        if (z) {
            ASMDeserializerFactory aVar = this.f2808g;
            if (aVar != null && aVar.f2707a.mo11496a(cls)) {
                z = false;
            }
        }
        if (z) {
            z = ASMUtils.m3172b(cls.getSimpleName());
        }
        if (z) {
            if (cls.isInterface()) {
                z = false;
            }
            JavaBeanInfo a2 = JavaBeanInfo.m3206a(cls, type, this.f2806e);
            if (z && a2.f3043h.length > 200) {
                z = false;
            }
            Constructor<?> constructor = a2.f3038c;
            if (z && constructor == null && !cls.isInterface()) {
                z = false;
            }
            FieldInfo[] cVarArr = a2.f3043h;
            int length = cVarArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                FieldInfo cVar = cVarArr[i];
                if (!cVar.f2998g) {
                    Class<?> cls3 = cVar.f2995d;
                    if (!Modifier.isPublic(cls3.getModifiers()) || ((cls3.isMemberClass() && !Modifier.isStatic(cls3.getModifiers())) || (cVar.mo11503b() != null && !ASMUtils.m3172b(cVar.mo11503b().getName())))) {
                        break;
                    }
                    JSONField d = cVar.mo11506d();
                    if ((d != null && (!ASMUtils.m3172b(d.name()) || d.format().length() != 0 || d.deserializeUsing() != Void.class || d.unwrapped())) || ((cVar.f2993b != null && cVar.f2993b.getParameterTypes().length > 1) || (cls3.isEnum() && !(mo11292a((Type) cls3) instanceof EnumDeserializer)))) {
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
            z = false;
        }
        if (z && cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) {
            z = false;
        }
        if (!z) {
            return new JavaBeanDeserializer(this, cls, type);
        }
        JavaBeanInfo a3 = JavaBeanInfo.m3206a(cls, type, this.f2806e);
        try {
            r12 = cls;
            r12 = this.f2808g.mo11157a(this, a3);
            r12 = r12;
            return r12;
        } catch (NoSuchMethodException unused2) {
            return new JavaBeanDeserializer(this, cls2, type);
        } catch (JSONException unused3) {
            return new JavaBeanDeserializer(this, a3);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("create asm deserializer error, ");
            sb.append(r12.getName());
            throw new JSONException(sb.toString(), e);
        }
    }

    /* renamed from: a */
    public FieldDeserializer mo11290a(ParserConfig hVar, JavaBeanInfo fVar, FieldInfo cVar) {
        Class<?> cls = fVar.f3036a;
        Class<?> cls2 = cVar.f2995d;
        JSONField d = cVar.mo11506d();
        Class cls3 = null;
        if (d != null) {
            Class<Void> deserializeUsing = d.deserializeUsing();
            if (deserializeUsing != Void.class) {
                cls3 = deserializeUsing;
            }
        }
        if (cls3 == null && (cls2 == List.class || cls2 == ArrayList.class)) {
            return new ArrayListTypeFieldDeserializer(hVar, cls, cVar);
        }
        return new DefaultFieldDeserializer(hVar, cls, cVar);
    }

    /* renamed from: a */
    public void mo11296a(Type type, ObjectDeserializer sVar) {
        this.f2811k.mo11514a(type, sVar);
    }

    /* renamed from: a */
    public static boolean m2908a(Class<?> cls) {
        return cls.isPrimitive() || cls == Boolean.class || cls == Character.class || cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == String.class || cls == java.util.Date.class || cls == Date.class || cls == Time.class || cls == Timestamp.class || cls.isEnum();
    }

    /* renamed from: a */
    public static void m2906a(Class<?> cls, Map<String, Field> map) {
        Field[] declaredFields;
        for (Field field : cls.getDeclaredFields()) {
            String name = field.getName();
            if (!map.containsKey(name)) {
                map.put(name, field);
            }
        }
        if (cls.getSuperclass() != null && cls.getSuperclass() != Object.class) {
            m2906a(cls.getSuperclass(), map);
        }
    }

    /* renamed from: a */
    public static Field m2905a(String str, Map<String, Field> map) {
        Field field = (Field) map.get(str);
        if (field == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("_");
            sb.append(str);
            field = (Field) map.get(sb.toString());
        }
        if (field == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("m_");
            sb2.append(str);
            field = (Field) map.get(sb2.toString());
        }
        if (field != null) {
            return field;
        }
        char charAt = str.charAt(0);
        if (charAt >= 'a' && charAt <= 'z') {
            char[] charArray = str.toCharArray();
            charArray[0] = (char) (charArray[0] - ' ');
            field = (Field) map.get(new String(charArray));
        }
        if (str.length() <= 2) {
            return field;
        }
        char charAt2 = str.charAt(1);
        if (str.length() <= 2 || charAt < 'a' || charAt > 'z' || charAt2 < 'A' || charAt2 > 'Z') {
            return field;
        }
        for (Entry entry : map.entrySet()) {
            if (str.equalsIgnoreCase((String) entry.getKey())) {
                return (Field) entry.getValue();
            }
        }
        return field;
    }

    /* renamed from: c */
    public ClassLoader mo11300c() {
        return this.f2807f;
    }

    /* renamed from: a */
    public void mo11295a(String str) {
        if (!(str == null || str.length() == 0)) {
            String[] strArr = this.f2814p;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                if (!str.equals(strArr[i])) {
                    i++;
                } else {
                    return;
                }
            }
            String[] strArr2 = this.f2814p;
            String[] strArr3 = new String[(strArr2.length + 1)];
            System.arraycopy(strArr2, 0, strArr3, 0, strArr2.length);
            strArr3[strArr3.length - 1] = str;
            this.f2814p = strArr3;
        }
    }

    /* renamed from: b */
    public void mo11299b(String str) {
        if (!(str == null || str.length() == 0)) {
            String[] strArr = this.f2815q;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                if (!str.equals(strArr[i])) {
                    i++;
                } else {
                    return;
                }
            }
            String[] strArr2 = this.f2815q;
            String[] strArr3 = new String[(strArr2.length + 1)];
            System.arraycopy(strArr2, 0, strArr3, 0, strArr2.length);
            strArr3[strArr3.length - 1] = str;
            this.f2815q = strArr3;
        }
    }

    /* renamed from: a */
    public Class<?> mo11293a(String str, Class<?> cls) {
        return mo11294a(str, cls, JSON.DEFAULT_PARSER_FEATURE);
    }

    /* renamed from: a */
    public Class<?> mo11294a(String str, Class<?> cls, int i) {
        Class cls2;
        Class cls3 = null;
        if (str == null) {
            return null;
        }
        String str2 = "autoType is not support. ";
        if (str.length() < 128) {
            String replace = str.replace('$', '.');
            boolean z = false;
            if (this.f2813o || cls != null) {
                Class cls4 = null;
                int i2 = 0;
                while (true) {
                    String[] strArr = this.f2815q;
                    if (i2 >= strArr.length) {
                        int i3 = 0;
                        while (true) {
                            String[] strArr2 = this.f2814p;
                            if (i3 >= strArr2.length) {
                                cls3 = cls4;
                                break;
                            } else if (!replace.startsWith(strArr2[i3]) || TypeUtils.m3254d(str) != null) {
                                i3++;
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append(str2);
                                sb.append(str);
                                throw new JSONException(sb.toString());
                            }
                        }
                    } else {
                        if (replace.startsWith(strArr[i2])) {
                            cls4 = TypeUtils.m3220a(str, this.f2807f, false);
                            if (cls4 != null) {
                                return cls4;
                            }
                        }
                        i2++;
                    }
                }
            }
            if (cls3 == null) {
                cls3 = TypeUtils.m3254d(str);
            }
            if (cls3 == null) {
                cls3 = this.f2811k.mo11512a(str);
            }
            String str3 = " -> ";
            String str4 = "type not match. ";
            if (cls2 == null) {
                if (!this.f2813o) {
                    int i4 = 0;
                    while (true) {
                        String[] strArr3 = this.f2814p;
                        if (i4 >= strArr3.length) {
                            int i5 = 0;
                            while (true) {
                                String[] strArr4 = this.f2815q;
                                if (i5 >= strArr4.length) {
                                    break;
                                } else if (replace.startsWith(strArr4[i5])) {
                                    if (cls2 == null) {
                                        cls2 = TypeUtils.m3220a(str, this.f2807f, false);
                                    }
                                    if (cls == null || !cls.isAssignableFrom(cls2)) {
                                        return cls2;
                                    }
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(str4);
                                    sb2.append(str);
                                    sb2.append(str3);
                                    sb2.append(cls.getName());
                                    throw new JSONException(sb2.toString());
                                } else {
                                    i5++;
                                }
                            }
                        } else if (!replace.startsWith(strArr3[i4])) {
                            i4++;
                        } else {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(str2);
                            sb3.append(str);
                            throw new JSONException(sb3.toString());
                        }
                    }
                }
                if (cls2 == null) {
                    cls2 = TypeUtils.m3220a(str, this.f2807f, false);
                }
                if (cls2 != null) {
                    if (TypeUtils.m3228a(cls2, JSONType.class) != null) {
                        return cls2;
                    }
                    if (ClassLoader.class.isAssignableFrom(cls2) || DataSource.class.isAssignableFrom(cls2)) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(str2);
                        sb4.append(str);
                        throw new JSONException(sb4.toString());
                    } else if (cls != null) {
                        if (cls.isAssignableFrom(cls2)) {
                            return cls2;
                        }
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str4);
                        sb5.append(str);
                        sb5.append(str3);
                        sb5.append(cls.getName());
                        throw new JSONException(sb5.toString());
                    } else if (JavaBeanInfo.m3206a(cls2, cls2, this.f2806e).f3039d != null && this.f2813o) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(str2);
                        sb6.append(str);
                        throw new JSONException(sb6.toString());
                    }
                }
                int i6 = Feature.SupportAutoType.mask;
                if (!(!this.f2813o && (i & i6) == 0 && (i6 & JSON.DEFAULT_PARSER_FEATURE) == 0)) {
                    z = true;
                }
                if (z) {
                    return cls2;
                }
                StringBuilder sb7 = new StringBuilder();
                sb7.append(str2);
                sb7.append(str);
                throw new JSONException(sb7.toString());
            } else if (cls == null || cls2 == HashMap.class || cls.isAssignableFrom(cls2)) {
                return cls2;
            } else {
                StringBuilder sb8 = new StringBuilder();
                sb8.append(str4);
                sb8.append(str);
                sb8.append(str3);
                sb8.append(cls.getName());
                throw new JSONException(sb8.toString());
            }
        } else {
            StringBuilder sb9 = new StringBuilder();
            sb9.append(str2);
            sb9.append(str);
            throw new JSONException(sb9.toString());
        }
    }
}
