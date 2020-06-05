package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.p066a.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.p066a.ObjectDeserializer;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.SerializeBeanInfo;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tencent.android.tpush.SettingsContentProvider;
import com.tencent.mid.sotrage.StorageInterface;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.alibaba.fastjson.util.i */
public class TypeUtils {
    /* renamed from: A */
    private static volatile boolean f3056A = false;
    /* renamed from: B */
    private static ConcurrentMap<String, Class<?>> f3057B = new ConcurrentHashMap(16, 0.75f, 1);
    /* renamed from: C */
    private static Class<?> f3058C = null;
    /* renamed from: D */
    private static boolean f3059D = false;
    /* renamed from: a */
    public static boolean f3060a = false;
    /* renamed from: b */
    public static boolean f3061b = false;
    /* renamed from: c */
    private static boolean f3062c = true;
    /* renamed from: d */
    private static boolean f3063d = false;
    /* renamed from: e */
    private static Method f3064e = null;
    /* renamed from: f */
    private static boolean f3065f = false;
    /* renamed from: g */
    private static Method f3066g = null;
    /* renamed from: h */
    private static boolean f3067h = false;
    /* renamed from: i */
    private static Class<?> f3068i = null;
    /* renamed from: j */
    private static boolean f3069j = false;
    /* renamed from: k */
    private static Class<? extends Annotation> f3070k = null;
    /* renamed from: l */
    private static Class<? extends Annotation> f3071l = null;
    /* renamed from: m */
    private static boolean f3072m = false;
    /* renamed from: n */
    private static Class<? extends Annotation> f3073n = null;
    /* renamed from: o */
    private static boolean f3074o = false;
    /* renamed from: p */
    private static Method f3075p = null;
    /* renamed from: q */
    private static boolean f3076q = false;
    /* renamed from: r */
    private static volatile Class f3077r;
    /* renamed from: s */
    private static volatile boolean f3078s;
    /* renamed from: t */
    private static volatile boolean f3079t;
    /* renamed from: u */
    private static volatile Constructor f3080u;
    /* renamed from: v */
    private static volatile Method f3081v;
    /* renamed from: w */
    private static volatile Method f3082w;
    /* renamed from: x */
    private static volatile Method f3083x;
    /* renamed from: y */
    private static volatile boolean f3084y;
    /* renamed from: z */
    private static volatile Map<Class, String[]> f3085z;

    static {
        String str = "true";
        try {
            f3060a = str.equals(IOUtils.m3190a("fastjson.compatibleWithJavaBean"));
            f3061b = str.equals(IOUtils.m3190a("fastjson.compatibleWithFieldName"));
        } catch (Throwable unused) {
        }
        m3234a();
    }

    /* renamed from: a */
    public static String m3226a(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    /* renamed from: b */
    public static Byte m3243b(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            return Byte.valueOf(Byte.parseByte(str));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("can not cast to byte, value : ");
        sb.append(obj);
        throw new JSONException(sb.toString());
    }

    /* renamed from: c */
    public static Character m3249c(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        String str = "can not cast to char, value : ";
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.length() == 0) {
                return null;
            }
            if (str2.length() == 1) {
                return Character.valueOf(str2.charAt(0));
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(obj);
            throw new JSONException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(obj);
        throw new JSONException(sb2.toString());
    }

    /* renamed from: d */
    public static Short m3256d(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            return Short.valueOf(Short.parseShort(str));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("can not cast to short, value : ");
        sb.append(obj);
        throw new JSONException(sb.toString());
    }

    /* renamed from: e */
    public static BigDecimal m3260e(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj instanceof BigInteger) {
            return new BigDecimal((BigInteger) obj);
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0) {
            return null;
        }
        if (!(obj instanceof Map) || ((Map) obj).size() != 0) {
            return new BigDecimal(obj2);
        }
        return null;
    }

    /* renamed from: f */
    public static BigInteger m3264f(Object obj) {
        BigInteger bigInteger = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return BigInteger.valueOf(((Number) obj).longValue());
        }
        String obj2 = obj.toString();
        if (obj2.length() != 0 && !"null".equals(obj2) && !"NULL".equals(obj2)) {
            bigInteger = new BigInteger(obj2);
        }
        return bigInteger;
    }

    /* renamed from: g */
    public static Float m3266g(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || "null".equals(obj2) || "NULL".equals(obj2)) {
                return null;
            }
            if (obj2.indexOf(44) != 0) {
                obj2 = obj2.replaceAll(StorageInterface.KEY_SPLITER, "");
            }
            return Float.valueOf(Float.parseFloat(obj2));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("can not cast to float, value : ");
        sb.append(obj);
        throw new JSONException(sb.toString());
    }

    /* renamed from: h */
    public static Double m3269h(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || "null".equals(obj2) || "NULL".equals(obj2)) {
                return null;
            }
            if (obj2.indexOf(44) != 0) {
                obj2 = obj2.replaceAll(StorageInterface.KEY_SPLITER, "");
            }
            return Double.valueOf(Double.parseDouble(obj2));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("can not cast to double, value : ");
        sb.append(obj);
        throw new JSONException(sb.toString());
    }

    /* renamed from: i */
    public static Date m3270i(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        long j = -1;
        if (obj instanceof Number) {
            return new Date(((Number) obj).longValue());
        }
        String str = "can not cast to Date, value : ";
        if (obj instanceof String) {
            String str2 = (String) obj;
            JSONScanner eVar = new JSONScanner(str2);
            try {
                if (eVar.mo11288b(false)) {
                    return eVar.mo11251E().getTime();
                }
                eVar.close();
                if (str2.startsWith("/Date(") && str2.endsWith(")/")) {
                    str2 = str2.substring(6, str2.length() - 2);
                }
                if (str2.indexOf(45) != -1) {
                    String str3 = (str2.length() == JSON.DEFFAULT_DATE_FORMAT.length() || (str2.length() == 22 && JSON.DEFFAULT_DATE_FORMAT.equals("yyyyMMddHHmmssSSSZ"))) ? JSON.DEFFAULT_DATE_FORMAT : str2.length() == 10 ? "yyyy-MM-dd" : str2.length() == 19 ? "yyyy-MM-dd HH:mm:ss" : (str2.length() == 29 && str2.charAt(26) == ':' && str2.charAt(28) == '0') ? "yyyy-MM-dd'T'HH:mm:ss.SSSXXX" : "yyyy-MM-dd HH:mm:ss.SSS";
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str3, JSON.defaultLocale);
                    simpleDateFormat.setTimeZone(JSON.defaultTimeZone);
                    try {
                        return simpleDateFormat.parse(str2);
                    } catch (ParseException unused) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(str2);
                        throw new JSONException(sb.toString());
                    }
                } else if (str2.length() == 0) {
                    return null;
                } else {
                    j = Long.parseLong(str2);
                }
            } finally {
                eVar.close();
            }
        }
        if (j >= 0) {
            return new Date(j);
        }
        Class cls = obj.getClass();
        String str4 = "toJdbc";
        if ("oracle.sql.TIMESTAMP".equals(cls.getName())) {
            if (f3064e == null && !f3063d) {
                try {
                    f3064e = cls.getMethod(str4, new Class[0]);
                } catch (NoSuchMethodException unused2) {
                } catch (Throwable th) {
                    f3063d = true;
                    throw th;
                }
                f3063d = true;
            }
            try {
                return (Date) f3064e.invoke(obj, new Object[0]);
            } catch (Exception e) {
                throw new JSONException("can not cast oracle.sql.TIMESTAMP to Date", e);
            }
        } else {
            if ("oracle.sql.DATE".equals(cls.getName())) {
                if (f3066g == null && !f3065f) {
                    try {
                        f3066g = cls.getMethod(str4, new Class[0]);
                    } catch (NoSuchMethodException unused3) {
                    } catch (Throwable th2) {
                        f3065f = true;
                        throw th2;
                    }
                    f3065f = true;
                }
                try {
                    return (Date) f3066g.invoke(obj, new Object[0]);
                } catch (Exception e2) {
                    throw new JSONException("can not cast oracle.sql.DATE to Date", e2);
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(obj);
                throw new JSONException(sb2.toString());
            }
        }
    }

    /* renamed from: j */
    public static java.sql.Date m3271j(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.sql.Date) {
            return (java.sql.Date) obj;
        }
        if (obj instanceof Date) {
            return new java.sql.Date(((Date) obj).getTime());
        }
        if (obj instanceof Calendar) {
            return new java.sql.Date(((Calendar) obj).getTimeInMillis());
        }
        long longValue = obj instanceof Number ? ((Number) obj).longValue() : 0;
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (m3239a(str)) {
                longValue = Long.parseLong(str);
            } else {
                JSONScanner eVar = new JSONScanner(str);
                if (eVar.mo11288b(false)) {
                    longValue = eVar.mo11251E().getTime().getTime();
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("can not cast to Timestamp, value : ");
                    sb.append(str);
                    throw new JSONException(sb.toString());
                }
            }
        }
        if (longValue > 0) {
            return new java.sql.Date(longValue);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("can not cast to Date, value : ");
        sb2.append(obj);
        throw new JSONException(sb2.toString());
    }

    /* renamed from: k */
    public static Timestamp m3272k(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return new Timestamp(((Calendar) obj).getTimeInMillis());
        }
        if (obj instanceof Timestamp) {
            return (Timestamp) obj;
        }
        if (obj instanceof Date) {
            return new Timestamp(((Date) obj).getTime());
        }
        long longValue = obj instanceof Number ? ((Number) obj).longValue() : 0;
        String str = "can not cast to Timestamp, value : ";
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.length() == 0 || "null".equals(str2) || "NULL".equals(str2)) {
                return null;
            }
            if (str2.endsWith(".000000000")) {
                str2 = str2.substring(0, str2.length() - 10);
            } else if (str2.endsWith(".000000")) {
                str2 = str2.substring(0, str2.length() - 7);
            }
            if (m3239a(str2)) {
                longValue = Long.parseLong(str2);
            } else {
                JSONScanner eVar = new JSONScanner(str2);
                if (eVar.mo11288b(false)) {
                    longValue = eVar.mo11251E().getTime().getTime();
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(str2);
                    throw new JSONException(sb.toString());
                }
            }
        }
        if (longValue > 0) {
            return new Timestamp(longValue);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(obj);
        throw new JSONException(sb2.toString());
    }

    /* renamed from: a */
    public static boolean m3239a(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '+' || charAt == '-') {
                if (i != 0) {
                    return false;
                }
            } else if (charAt < '0' || charAt > '9') {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r4v9, types: [java.lang.Long] */
    /* JADX WARNING: type inference failed for: r4v12 */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Object, code=null, for r4v0, types: [java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v7
  assigns: [java.lang.Object, java.lang.Long]
  uses: [?[OBJECT, ARRAY], java.lang.Object, ?[int, boolean, OBJECT, ARRAY, byte, short, char], java.lang.Long]
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
    /* JADX WARNING: Unknown variable types count: 4 */
    /* renamed from: l */
    public static java.lang.Long m3273l(? r4) {
        /*
        r0 = 0
        if (r4 != 0) goto L_0x0004
        return r0
    L_0x0004:
        boolean r1 = r4 instanceof java.lang.Number
        if (r1 == 0) goto L_0x0013
        java.lang.Number r4 = (java.lang.Number) r4
        long r0 = r4.longValue()
        java.lang.Long r4 = java.lang.Long.valueOf(r0)
        return r4
    L_0x0013:
        boolean r1 = r4 instanceof java.lang.String
        if (r1 == 0) goto L_0x006a
        r1 = r4
        java.lang.String r1 = (java.lang.String) r1
        int r2 = r1.length()
        if (r2 == 0) goto L_0x0069
        java.lang.String r2 = "null"
        boolean r2 = r2.equals(r1)
        if (r2 != 0) goto L_0x0069
        java.lang.String r2 = "NULL"
        boolean r2 = r2.equals(r1)
        if (r2 == 0) goto L_0x0031
        goto L_0x0069
    L_0x0031:
        r2 = 44
        int r2 = r1.indexOf(r2)
        if (r2 == 0) goto L_0x0041
        java.lang.String r2 = ","
        java.lang.String r3 = ""
        java.lang.String r1 = r1.replaceAll(r2, r3)
    L_0x0041:
        long r2 = java.lang.Long.parseLong(r1)     // Catch:{ NumberFormatException -> 0x004a }
        java.lang.Long r4 = java.lang.Long.valueOf(r2)     // Catch:{ NumberFormatException -> 0x004a }
        return r4
        com.alibaba.fastjson.parser.e r2 = new com.alibaba.fastjson.parser.e
        r2.m41636init(r1)
        r1 = 0
        boolean r1 = r2.mo11288b(r1)
        if (r1 == 0) goto L_0x005b
        java.util.Calendar r0 = r2.mo11251E()
    L_0x005b:
        r2.close()
        if (r0 == 0) goto L_0x006a
        long r0 = r0.getTimeInMillis()
        java.lang.Long r4 = java.lang.Long.valueOf(r0)
        return r4
    L_0x0069:
        return r0
    L_0x006a:
        boolean r0 = r4 instanceof java.util.Map
        if (r0 == 0) goto L_0x009c
        r0 = r4
        java.util.Map r0 = (java.util.Map) r0
        int r1 = r0.size()
        r2 = 2
        if (r1 != r2) goto L_0x009c
        java.lang.String r1 = "andIncrement"
        boolean r1 = r0.containsKey(r1)
        if (r1 == 0) goto L_0x009c
        java.lang.String r1 = "andDecrement"
        boolean r1 = r0.containsKey(r1)
        if (r1 == 0) goto L_0x009c
        java.util.Collection r4 = r0.values()
        java.util.Iterator r4 = r4.iterator()
        r4.next()
        java.lang.Object r4 = r4.next()
        java.lang.Long r4 = m3273l(r4)
        return r4
    L_0x009c:
        com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r2 = "can not cast to long, value : "
        r1.append(r2)
        r1.append(r4)
        java.lang.String r4 = r1.toString()
        r0.m41526init(r4)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.m3273l(java.lang.Object):java.lang.Long");
    }

    /* renamed from: m */
    public static Integer m3274m(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (str.indexOf(44) != 0) {
                str = str.replaceAll(StorageInterface.KEY_SPLITER, "");
            }
            return Integer.valueOf(Integer.parseInt(str));
        } else if (obj instanceof Boolean) {
            return Integer.valueOf(((Boolean) obj).booleanValue());
        } else {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                    Iterator it = map.values().iterator();
                    it.next();
                    return m3274m(it.next());
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("can not cast to int, value : ");
            sb.append(obj);
            throw new JSONException(sb.toString());
        }
    }

    /* renamed from: n */
    public static byte[] m3275n(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return IOUtils.m3200b((String) obj);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("can not cast to int, value : ");
        sb.append(obj);
        throw new JSONException(sb.toString());
    }

    /* renamed from: o */
    public static Boolean m3276o(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof Number) {
            boolean z = true;
            if (((Number) obj).intValue() != 1) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if ("true".equalsIgnoreCase(str) || "1".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(str) || "0".equals(str)) {
                return Boolean.FALSE;
            }
            if ("Y".equalsIgnoreCase(str) || "T".equals(str)) {
                return Boolean.TRUE;
            }
            if ("F".equalsIgnoreCase(str) || "N".equals(str)) {
                return Boolean.FALSE;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("can not cast to boolean, value : ");
        sb.append(obj);
        throw new JSONException(sb.toString());
    }

    /* renamed from: a */
    public static <T> T m3221a(Object obj, Class<T> cls) {
        return m3222a(obj, cls, ParserConfig.m2904a());
    }

    /* renamed from: a */
    public static <T> T m3222a(Object obj, Class<T> cls, ParserConfig hVar) {
        T t;
        int i = 0;
        if (obj == null) {
            if (cls == Integer.TYPE) {
                return Integer.valueOf(0);
            }
            if (cls == Long.TYPE) {
                return Long.valueOf(0);
            }
            if (cls == Short.TYPE) {
                return Short.valueOf(0);
            }
            if (cls == Byte.TYPE) {
                return Byte.valueOf(0);
            }
            if (cls == Float.TYPE) {
                return Float.valueOf(0.0f);
            }
            if (cls == Double.TYPE) {
                return Double.valueOf(0.0d);
            }
            if (cls == Boolean.TYPE) {
                return Boolean.FALSE;
            }
            return null;
        } else if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        } else if (cls == obj.getClass()) {
            return obj;
        } else {
            if (!(obj instanceof Map)) {
                if (cls.isArray()) {
                    if (obj instanceof Collection) {
                        Collection<Object> collection = (Collection) obj;
                        T newInstance = Array.newInstance(cls.getComponentType(), collection.size());
                        for (Object a : collection) {
                            Array.set(newInstance, i, m3222a(a, cls.getComponentType(), hVar));
                            i++;
                        }
                        return newInstance;
                    } else if (cls == byte[].class) {
                        return m3275n(obj);
                    }
                }
                if (cls.isAssignableFrom(obj.getClass())) {
                    return obj;
                }
                if (cls == Boolean.TYPE || cls == Boolean.class) {
                    return m3276o(obj);
                }
                if (cls == Byte.TYPE || cls == Byte.class) {
                    return m3243b(obj);
                }
                if (cls == Character.TYPE || cls == Character.class) {
                    return m3249c(obj);
                }
                if (cls == Short.TYPE || cls == Short.class) {
                    return m3256d(obj);
                }
                if (cls == Integer.TYPE || cls == Integer.class) {
                    return m3274m(obj);
                }
                if (cls == Long.TYPE || cls == Long.class) {
                    return m3273l(obj);
                }
                if (cls == Float.TYPE || cls == Float.class) {
                    return m3266g(obj);
                }
                if (cls == Double.TYPE || cls == Double.class) {
                    return m3269h(obj);
                }
                if (cls == String.class) {
                    return m3226a(obj);
                }
                if (cls == BigDecimal.class) {
                    return m3260e(obj);
                }
                if (cls == BigInteger.class) {
                    return m3264f(obj);
                }
                if (cls == Date.class) {
                    return m3270i(obj);
                }
                if (cls == java.sql.Date.class) {
                    return m3271j(obj);
                }
                if (cls == Timestamp.class) {
                    return m3272k(obj);
                }
                if (cls.isEnum()) {
                    return m3244b(obj, cls, hVar);
                }
                String str = "can not cast to : ";
                if (Calendar.class.isAssignableFrom(cls)) {
                    Date i2 = m3270i(obj);
                    if (cls == Calendar.class) {
                        t = Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
                    } else {
                        try {
                            t = (Calendar) cls.newInstance();
                        } catch (Exception e) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str);
                            sb.append(cls.getName());
                            throw new JSONException(sb.toString(), e);
                        }
                    }
                    t.setTime(i2);
                    return t;
                } else if (cls.getName().equals("javax.xml.datatype.XMLGregorianCalendar")) {
                    Date i3 = m3270i(obj);
                    Calendar instance = Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
                    instance.setTime(i3);
                    return CalendarCodec.f2946a.mo11427a(instance);
                } else {
                    if (obj instanceof String) {
                        String str2 = (String) obj;
                        if (str2.length() == 0 || "null".equals(str2) || "NULL".equals(str2)) {
                            return null;
                        }
                        if (cls == Currency.class) {
                            return Currency.getInstance(str2);
                        }
                        if (cls == Locale.class) {
                            return m3246b(str2);
                        }
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(cls.getName());
                    throw new JSONException(sb2.toString());
                }
            } else if (cls == Map.class) {
                return obj;
            } else {
                Map map = (Map) obj;
                if (cls != Object.class || map.containsKey(JSON.DEFAULT_TYPE_KEY)) {
                    return m3225a(map, cls, hVar);
                }
                return obj;
            }
        }
    }

    /* renamed from: b */
    public static Locale m3246b(String str) {
        String[] split = str.split("_");
        if (split.length == 1) {
            return new Locale(split[0]);
        }
        if (split.length == 2) {
            return new Locale(split[0], split[1]);
        }
        return new Locale(split[0], split[1], split[2]);
    }

    /* renamed from: b */
    public static <T> T m3244b(Object obj, Class<T> cls, ParserConfig hVar) {
        String str = "can not cast to : ";
        try {
            if (obj instanceof String) {
                String str2 = (String) obj;
                if (str2.length() == 0) {
                    return null;
                }
                return Enum.valueOf(cls, str2);
            }
            if (obj instanceof Number) {
                int intValue = ((Number) obj).intValue();
                T[] enumConstants = cls.getEnumConstants();
                if (intValue < enumConstants.length) {
                    return enumConstants[intValue];
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(cls.getName());
            throw new JSONException(sb.toString());
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(cls.getName());
            throw new JSONException(sb2.toString(), e);
        }
    }

    /* renamed from: a */
    public static <T> T m3224a(Object obj, Type type, ParserConfig hVar) {
        if (obj == null) {
            return null;
        }
        if (type instanceof Class) {
            return m3222a(obj, (Class) type, hVar);
        }
        if (type instanceof ParameterizedType) {
            return m3223a(obj, (ParameterizedType) type, hVar);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
        }
        if (type instanceof TypeVariable) {
            return obj;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("can not cast to : ");
        sb.append(type);
        throw new JSONException(sb.toString());
    }

    /* renamed from: a */
    public static <T> T m3223a(Object obj, ParameterizedType parameterizedType, ParserConfig hVar) {
        T t;
        Type rawType = parameterizedType.getRawType();
        if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == List.class || rawType == ArrayList.class) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                if (rawType == Set.class || rawType == HashSet.class) {
                    t = new HashSet();
                } else if (rawType == TreeSet.class) {
                    t = new TreeSet();
                } else {
                    t = new ArrayList();
                }
                for (Object a : (Iterable) obj) {
                    t.add(m3224a(a, type, hVar));
                }
                return t;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                T hashMap = new HashMap();
                for (Entry entry : ((Map) obj).entrySet()) {
                    hashMap.put(m3224a(entry.getKey(), type2, hVar), m3224a(entry.getValue(), type3, hVar));
                }
                return hashMap;
            }
        }
        if ((obj instanceof String) && ((String) obj).length() == 0) {
            return null;
        }
        if (parameterizedType.getActualTypeArguments().length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return m3224a(obj, rawType, hVar);
        }
        if (rawType == Entry.class && (obj instanceof Map)) {
            Map map = (Map) obj;
            if (map.size() == 1) {
                return (Entry) map.entrySet().iterator().next();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("can not cast to : ");
        sb.append(parameterizedType);
        throw new JSONException(sb.toString());
    }

    /* renamed from: a */
    public static <T> T m3225a(Map<String, Object> map, Class<T> cls, ParserConfig hVar) {
        InvocationHandler invocationHandler;
        int i = 0;
        if (cls == StackTraceElement.class) {
            try {
                String str = (String) map.get("className");
                String str2 = (String) map.get("methodName");
                String str3 = (String) map.get("fileName");
                Number number = (Number) map.get("lineNumber");
                if (number != null) {
                    i = number.intValue();
                }
                return new StackTraceElement(str, str2, str3, i);
            } catch (Exception e) {
                throw new JSONException(e.getMessage(), e);
            }
        } else {
            Object obj = map.get(JSON.DEFAULT_TYPE_KEY);
            JavaBeanDeserializer nVar = null;
            if (obj instanceof String) {
                String str4 = (String) obj;
                if (hVar == null) {
                    hVar = ParserConfig.f2801c;
                }
                Class a = hVar.mo11293a(str4, null);
                if (a == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str4);
                    sb.append(" not found");
                    throw new ClassNotFoundException(sb.toString());
                } else if (!a.equals(cls)) {
                    return m3225a(map, a, hVar);
                }
            }
            if (cls.isInterface()) {
                if (map instanceof JSONObject) {
                    invocationHandler = (JSONObject) map;
                } else {
                    invocationHandler = new JSONObject(map);
                }
                if (r6 == null) {
                    r6 = ParserConfig.m2904a();
                }
                if (((ObjectDeserializer) r6.mo11298b().mo11513a(cls)) != null) {
                    return JSON.parseObject(JSON.toJSONString(invocationHandler), cls);
                }
                return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, invocationHandler);
            }
            if (cls == Locale.class) {
                Object obj2 = map.get("language");
                Object obj3 = map.get("country");
                if (obj2 instanceof String) {
                    String str5 = (String) obj2;
                    if (obj3 instanceof String) {
                        return new Locale(str5, (String) obj3);
                    }
                    if (obj3 == null) {
                        return new Locale(str5);
                    }
                }
            }
            if (cls == String.class && (map instanceof JSONObject)) {
                return map.toString();
            }
            if (cls == LinkedHashMap.class && (map instanceof JSONObject)) {
                T innerMap = ((JSONObject) map).getInnerMap();
                if (innerMap instanceof LinkedHashMap) {
                    return innerMap;
                }
                new LinkedHashMap().putAll(innerMap);
            }
            if (r6 == null) {
                r6 = ParserConfig.m2904a();
            }
            ObjectDeserializer a2 = r6.mo11292a((Type) cls);
            if (a2 instanceof JavaBeanDeserializer) {
                nVar = (JavaBeanDeserializer) a2;
            }
            if (nVar != null) {
                return nVar.mo11190a(map, r6);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("can not get javaBeanDeserializer. ");
            sb2.append(cls.getName());
            throw new JSONException(sb2.toString());
        }
    }

    /* renamed from: a */
    private static void m3234a() {
        Class[] clsArr;
        Class<char[]> cls = char[].class;
        Class<boolean[]> cls2 = boolean[].class;
        Class<double[]> cls3 = double[].class;
        Class<float[]> cls4 = float[].class;
        Class<long[]> cls5 = long[].class;
        Class<int[]> cls6 = int[].class;
        Class<short[]> cls7 = short[].class;
        Class<byte[]> cls8 = byte[].class;
        f3057B.put("byte", Byte.TYPE);
        f3057B.put("short", Short.TYPE);
        f3057B.put("int", Integer.TYPE);
        f3057B.put(SettingsContentProvider.LONG_TYPE, Long.TYPE);
        f3057B.put(SettingsContentProvider.FLOAT_TYPE, Float.TYPE);
        f3057B.put("double", Double.TYPE);
        f3057B.put(SettingsContentProvider.BOOLEAN_TYPE, Boolean.TYPE);
        f3057B.put("char", Character.TYPE);
        f3057B.put("[byte", cls8);
        f3057B.put("[short", cls7);
        f3057B.put("[int", cls6);
        f3057B.put("[long", cls5);
        f3057B.put("[float", cls4);
        f3057B.put("[double", cls3);
        f3057B.put("[boolean", cls2);
        f3057B.put("[char", cls);
        f3057B.put("[B", cls8);
        f3057B.put("[S", cls7);
        f3057B.put("[I", cls6);
        f3057B.put("[J", cls5);
        f3057B.put("[F", cls4);
        f3057B.put("[D", cls3);
        f3057B.put("[C", cls);
        f3057B.put("[Z", cls2);
        int i = 0;
        for (Class cls9 : new Class[]{Object.class, Cloneable.class, m3250c("java.lang.AutoCloseable"), Exception.class, RuntimeException.class, IllegalAccessError.class, IllegalAccessException.class, IllegalArgumentException.class, IllegalMonitorStateException.class, IllegalStateException.class, IllegalThreadStateException.class, IndexOutOfBoundsException.class, InstantiationError.class, InstantiationException.class, InternalError.class, InterruptedException.class, LinkageError.class, NegativeArraySizeException.class, NoClassDefFoundError.class, NoSuchFieldError.class, NoSuchFieldException.class, NoSuchMethodError.class, NoSuchMethodException.class, NullPointerException.class, NumberFormatException.class, OutOfMemoryError.class, SecurityException.class, StackOverflowError.class, StringIndexOutOfBoundsException.class, TypeNotPresentException.class, VerifyError.class, StackTraceElement.class, HashMap.class, Hashtable.class, TreeMap.class, IdentityHashMap.class, WeakHashMap.class, LinkedHashMap.class, HashSet.class, LinkedHashSet.class, TreeSet.class, TimeUnit.class, ConcurrentHashMap.class, m3250c("java.util.concurrent.ConcurrentSkipListMap"), m3250c("java.util.concurrent.ConcurrentSkipListSet"), AtomicInteger.class, AtomicLong.class, Collections.EMPTY_MAP.getClass(), BitSet.class, Calendar.class, Date.class, Locale.class, UUID.class, Time.class, java.sql.Date.class, Timestamp.class, SimpleDateFormat.class, JSONObject.class}) {
            if (cls9 != null) {
                f3057B.put(cls9.getName(), cls9);
            }
        }
        for (String c : new String[]{"java.awt.Rectangle", "java.awt.Point", "java.awt.Font", "java.awt.Color"}) {
            Class c2 = m3250c(c);
            if (c2 == null) {
                break;
            }
            f3057B.put(c2.getName(), c2);
        }
        String[] strArr = {"org.springframework.util.LinkedMultiValueMap", "org.springframework.util.LinkedCaseInsensitiveMap", "org.springframework.remoting.support.RemoteInvocation", "org.springframework.remoting.support.RemoteInvocationResult", "org.springframework.security.web.savedrequest.DefaultSavedRequest", "org.springframework.security.web.savedrequest.SavedCookie", "org.springframework.security.web.csrf.DefaultCsrfToken", "org.springframework.security.web.authentication.WebAuthenticationDetails", "org.springframework.security.core.context.SecurityContextImpl", "org.springframework.security.authentication.UsernamePasswordAuthenticationToken", "org.springframework.security.core.authority.SimpleGrantedAuthority", "org.springframework.security.core.userdetails.User"};
        int length = strArr.length;
        while (i < length) {
            Class c3 = m3250c(strArr[i]);
            if (c3 != null) {
                f3057B.put(c3.getName(), c3);
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: c */
    public static Class<?> m3250c(String str) {
        return m3219a(str, (ClassLoader) null);
    }

    /* renamed from: a */
    public static boolean m3237a(Class<?> cls) {
        if (f3058C == null && !f3059D) {
            try {
                f3058C = Class.forName("java.nio.file.Path");
            } catch (Throwable unused) {
                f3059D = true;
            }
        }
        Class<?> cls2 = f3058C;
        if (cls2 != null) {
            return cls2.isAssignableFrom(cls);
        }
        return false;
    }

    /* renamed from: d */
    public static Class<?> m3254d(String str) {
        return (Class) f3057B.get(str);
    }

    /* renamed from: a */
    public static Class<?> m3219a(String str, ClassLoader classLoader) {
        return m3220a(str, classLoader, true);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:(4:17|18|(1:20)|21)|24|25|(3:28|(2:30|31)|34)|35|36|37) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x007b */
    /* renamed from: a */
    public static java.lang.Class<?> m3220a(java.lang.String r5, java.lang.ClassLoader r6, boolean r7) {
        /*
        if (r5 == 0) goto L_0x0085
        int r0 = r5.length()
        if (r0 != 0) goto L_0x000a
        goto L_0x0085
    L_0x000a:
        java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Class<?>> r0 = f3057B
        java.lang.Object r0 = r0.get(r5)
        java.lang.Class r0 = (java.lang.Class) r0
        if (r0 == 0) goto L_0x0015
        return r0
    L_0x0015:
        r1 = 0
        char r2 = r5.charAt(r1)
        r3 = 91
        r4 = 1
        if (r2 != r3) goto L_0x0030
        java.lang.String r5 = r5.substring(r4)
        java.lang.Class r5 = m3219a(r5, r6)
        java.lang.Object r5 = java.lang.reflect.Array.newInstance(r5, r1)
        java.lang.Class r5 = r5.getClass()
        return r5
    L_0x0030:
        java.lang.String r1 = "L"
        boolean r1 = r5.startsWith(r1)
        if (r1 == 0) goto L_0x004e
        java.lang.String r1 = ";"
        boolean r1 = r5.endsWith(r1)
        if (r1 == 0) goto L_0x004e
        int r7 = r5.length()
        int r7 = r7 - r4
        java.lang.String r5 = r5.substring(r4, r7)
        java.lang.Class r5 = m3219a(r5, r6)
        return r5
    L_0x004e:
        if (r6 == 0) goto L_0x0060
        java.lang.Class r0 = r6.loadClass(r5)     // Catch:{ all -> 0x005c }
        if (r7 == 0) goto L_0x005b
        java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Class<?>> r1 = f3057B     // Catch:{ all -> 0x005c }
        r1.put(r5, r0)     // Catch:{ all -> 0x005c }
    L_0x005b:
        return r0
    L_0x005c:
        r1 = move-exception
        r1.printStackTrace()
    L_0x0060:
        java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x007b }
        java.lang.ClassLoader r1 = r1.getContextClassLoader()     // Catch:{ all -> 0x007b }
        if (r1 == 0) goto L_0x007b
        if (r1 == r6) goto L_0x007b
        java.lang.Class r6 = r1.loadClass(r5)     // Catch:{ all -> 0x007b }
        if (r7 == 0) goto L_0x007a
        java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Class<?>> r7 = f3057B     // Catch:{ all -> 0x0078 }
        r7.put(r5, r6)     // Catch:{ all -> 0x0078 }
        goto L_0x007a
    L_0x0078:
        r0 = r6
        goto L_0x007b
    L_0x007a:
        return r6
    L_0x007b:
        java.lang.Class r0 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x0084 }
        java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Class<?>> r6 = f3057B     // Catch:{ all -> 0x0084 }
        r6.put(r5, r0)     // Catch:{ all -> 0x0084 }
    L_0x0084:
        return r0
    L_0x0085:
        r5 = 0
        return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.m3220a(java.lang.String, java.lang.ClassLoader, boolean):java.lang.Class");
    }

    /* renamed from: a */
    public static SerializeBeanInfo m3217a(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy) {
        return m3218a(cls, map, propertyNamingStrategy, false);
    }

    /* renamed from: a */
    public static SerializeBeanInfo m3218a(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy, boolean z) {
        String str;
        String str2;
        int i;
        String[] strArr;
        PropertyNamingStrategy propertyNamingStrategy2;
        List list;
        List list2;
        Class<?> cls2 = cls;
        Map<String, String> map2 = map;
        JSONType jSONType = (JSONType) m3228a(cls2, JSONType.class);
        if (jSONType != null) {
            String[] orders = jSONType.orders();
            String typeName = jSONType.typeName();
            if (typeName.length() == 0) {
                typeName = null;
            }
            PropertyNamingStrategy naming = jSONType.naming();
            if (naming == null || naming == PropertyNamingStrategy.CamelCase) {
                naming = propertyNamingStrategy;
            }
            int of = SerializerFeature.m2926of(jSONType.serialzeFeatures());
            Class<Object> superclass = cls.getSuperclass();
            String str3 = null;
            while (superclass != null && superclass != Object.class) {
                JSONType jSONType2 = (JSONType) m3228a(superclass, JSONType.class);
                if (jSONType2 == null) {
                    break;
                }
                str3 = jSONType2.typeKey();
                if (str3.length() != 0) {
                    break;
                }
                superclass = superclass.getSuperclass();
            }
            String str4 = str3;
            for (Class a : cls.getInterfaces()) {
                JSONType jSONType3 = (JSONType) m3228a(a, JSONType.class);
                if (jSONType3 != null) {
                    str4 = jSONType3.typeKey();
                    if (str4.length() != 0) {
                        break;
                    }
                }
            }
            if (str4 != null && str4.length() == 0) {
                str4 = null;
            }
            strArr = orders;
            propertyNamingStrategy2 = naming;
            i = of;
            str = str4;
            str2 = typeName;
        } else {
            propertyNamingStrategy2 = propertyNamingStrategy;
            strArr = null;
            str2 = null;
            str = null;
            i = 0;
        }
        HashMap hashMap = new HashMap();
        ParserConfig.m2906a(cls2, (Map<String, Field>) hashMap);
        if (z) {
            list = m3232a(cls2, map2, false, propertyNamingStrategy2);
        } else {
            list = m3231a(cls, jSONType, map, hashMap, false, propertyNamingStrategy2);
        }
        FieldInfo[] cVarArr = new FieldInfo[list.size()];
        list.toArray(cVarArr);
        if (strArr == null || strArr.length == 0) {
            List arrayList = new ArrayList(list);
            Collections.sort(arrayList);
            list2 = arrayList;
        } else if (z) {
            list2 = m3232a(cls2, map2, true, propertyNamingStrategy2);
        } else {
            list2 = m3231a(cls, jSONType, map, hashMap, true, propertyNamingStrategy2);
        }
        FieldInfo[] cVarArr2 = new FieldInfo[list2.size()];
        list2.toArray(cVarArr2);
        SerializeBeanInfo awVar = new SerializeBeanInfo(cls, jSONType, str2, str, i, cVarArr, Arrays.equals(cVarArr2, cVarArr) ? cVarArr : cVarArr2);
        return awVar;
    }

    /* renamed from: a */
    public static List<FieldInfo> m3232a(Class<?> cls, Map<String, String> map, boolean z, PropertyNamingStrategy propertyNamingStrategy) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            m3235a(cls2, map, propertyNamingStrategy, linkedHashMap, cls2.getDeclaredFields());
        }
        return m3233a(cls, z, (Map<String, FieldInfo>) linkedHashMap);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:204:0x046d, code lost:
            if (r0 == null) goto L_0x04a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x04a4, code lost:
            if (r0 == null) goto L_0x04a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x04a6, code lost:
            r15 = r43;
            r13 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01c6, code lost:
            if (r0 == null) goto L_0x0192;
     */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x034b  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0357  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0368  */
    /* renamed from: a */
    public static java.util.List<com.alibaba.fastjson.util.FieldInfo> m3231a(java.lang.Class<?> r38, com.alibaba.fastjson.annotation.JSONType r39, java.util.Map<java.lang.String, java.lang.String> r40, java.util.Map<java.lang.String, java.lang.reflect.Field> r41, boolean r42, com.alibaba.fastjson.PropertyNamingStrategy r43) {
        /*
        r12 = r38
        r13 = r40
        r14 = r41
        r15 = r43
        java.util.LinkedHashMap r11 = new java.util.LinkedHashMap
        r11.<init>()
        boolean r16 = m3257d(r38)
        r17 = 0
        r0 = r17
        java.lang.annotation.Annotation[][] r0 = (java.lang.annotation.Annotation[][]) r0
        java.lang.reflect.Method[] r10 = r38.getMethods()
        int r9 = r10.length
        r3 = r0
        r0 = r17
        r1 = r0
        r2 = r1
        r7 = 0
    L_0x0022:
        if (r7 >= r9) goto L_0x04f6
        r6 = r10[r7]
        java.lang.String r5 = r6.getName()
        r18 = 0
        int r4 = r6.getModifiers()
        boolean r4 = java.lang.reflect.Modifier.isStatic(r4)
        if (r4 == 0) goto L_0x0037
        goto L_0x0087
    L_0x0037:
        java.lang.Class r4 = r6.getReturnType()
        java.lang.Class r8 = java.lang.Void.TYPE
        boolean r4 = r4.equals(r8)
        if (r4 == 0) goto L_0x0044
        goto L_0x0087
    L_0x0044:
        java.lang.Class[] r4 = r6.getParameterTypes()
        int r4 = r4.length
        if (r4 == 0) goto L_0x004c
        goto L_0x0087
    L_0x004c:
        java.lang.Class r4 = r6.getReturnType()
        java.lang.Class<java.lang.ClassLoader> r8 = java.lang.ClassLoader.class
        if (r4 != r8) goto L_0x0055
        goto L_0x0087
    L_0x0055:
        java.lang.String r4 = "getMetaClass"
        boolean r4 = r5.equals(r4)
        if (r4 == 0) goto L_0x006e
        java.lang.Class r4 = r6.getReturnType()
        java.lang.String r4 = r4.getName()
        java.lang.String r8 = "groovy.lang.MetaClass"
        boolean r4 = r4.equals(r8)
        if (r4 == 0) goto L_0x006e
        goto L_0x0087
    L_0x006e:
        java.lang.String r4 = "getSuppressed"
        boolean r4 = r5.equals(r4)
        if (r4 == 0) goto L_0x007f
        java.lang.Class r4 = r6.getDeclaringClass()
        java.lang.Class<java.lang.Throwable> r8 = java.lang.Throwable.class
        if (r4 != r8) goto L_0x007f
        goto L_0x0087
    L_0x007f:
        if (r16 == 0) goto L_0x0094
        boolean r4 = m3247b(r12, r5)
        if (r4 == 0) goto L_0x0094
    L_0x0087:
        r22 = r0
        r24 = r7
        r31 = r9
        r32 = r10
        r0 = r11
        r29 = 0
        goto L_0x04eb
    L_0x0094:
        r4 = 0
        java.lang.Boolean r8 = java.lang.Boolean.valueOf(r4)
        java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r4 = com.alibaba.fastjson.annotation.JSONField.class
        java.lang.annotation.Annotation r4 = r6.getAnnotation(r4)
        com.alibaba.fastjson.annotation.JSONField r4 = (com.alibaba.fastjson.annotation.JSONField) r4
        if (r4 != 0) goto L_0x00a7
        com.alibaba.fastjson.annotation.JSONField r4 = m3216a(r12, r6)
    L_0x00a7:
        r19 = r1
        java.lang.String r1 = "get"
        r20 = r11
        if (r4 != 0) goto L_0x017b
        if (r16 == 0) goto L_0x017b
        if (r0 != 0) goto L_0x00fa
        java.lang.reflect.Constructor[] r0 = r38.getDeclaredConstructors()
        java.lang.reflect.Constructor r21 = m3229a(r0)
        if (r21 == 0) goto L_0x00f8
        java.lang.annotation.Annotation[][] r3 = r21.getParameterAnnotations()
        java.lang.String[] r11 = m3261e(r38)
        if (r11 == 0) goto L_0x00f1
        int r2 = r11.length
        java.lang.String[] r2 = new java.lang.String[r2]
        r22 = r0
        int r0 = r11.length
        r19 = r3
        r3 = 0
        java.lang.System.arraycopy(r11, r3, r2, r3, r0)
        java.util.Arrays.sort(r2)
        int r0 = r11.length
        short[] r0 = new short[r0]
        r23 = r4
    L_0x00db:
        int r4 = r11.length
        if (r3 >= r4) goto L_0x00ea
        r4 = r11[r3]
        int r4 = java.util.Arrays.binarySearch(r2, r4)
        r0[r4] = r3
        int r3 = r3 + 1
        short r3 = (short) r3
        goto L_0x00db
    L_0x00ea:
        r11 = r2
        r3 = r19
        r2 = r0
        r0 = r22
        goto L_0x00fe
    L_0x00f1:
        r22 = r0
        r19 = r3
        r23 = r4
        goto L_0x00fe
    L_0x00f8:
        r22 = r0
    L_0x00fa:
        r23 = r4
        r11 = r19
    L_0x00fe:
        if (r11 == 0) goto L_0x016e
        if (r2 == 0) goto L_0x016e
        boolean r4 = r5.startsWith(r1)
        if (r4 == 0) goto L_0x016e
        r4 = 3
        java.lang.String r19 = r5.substring(r4)
        java.lang.String r4 = m3258e(r19)
        int r19 = java.util.Arrays.binarySearch(r11, r4)
        r22 = r0
        r24 = r7
        if (r19 >= 0) goto L_0x012b
        r0 = 0
    L_0x011c:
        int r7 = r11.length
        if (r0 >= r7) goto L_0x012b
        r7 = r11[r0]
        boolean r7 = r4.equalsIgnoreCase(r7)
        if (r7 == 0) goto L_0x0128
        goto L_0x012d
    L_0x0128:
        int r0 = r0 + 1
        goto L_0x011c
    L_0x012b:
        r0 = r19
    L_0x012d:
        if (r0 < 0) goto L_0x0169
        short r0 = r2[r0]
        r0 = r3[r0]
        if (r0 == 0) goto L_0x0150
        int r7 = r0.length
        r19 = r2
        r2 = 0
    L_0x0139:
        r25 = r3
        if (r2 >= r7) goto L_0x0154
        r3 = r0[r2]
        r26 = r0
        boolean r0 = r3 instanceof com.alibaba.fastjson.annotation.JSONField
        if (r0 == 0) goto L_0x0149
        r0 = r3
        com.alibaba.fastjson.annotation.JSONField r0 = (com.alibaba.fastjson.annotation.JSONField) r0
        goto L_0x0156
    L_0x0149:
        int r2 = r2 + 1
        r3 = r25
        r0 = r26
        goto L_0x0139
    L_0x0150:
        r19 = r2
        r25 = r3
    L_0x0154:
        r0 = r23
    L_0x0156:
        if (r0 != 0) goto L_0x0166
        java.lang.reflect.Field r2 = com.alibaba.fastjson.parser.ParserConfig.m2905a(r4, r14)
        if (r2 == 0) goto L_0x0166
        java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r0 = com.alibaba.fastjson.annotation.JSONField.class
        java.lang.annotation.Annotation r0 = r2.getAnnotation(r0)
        com.alibaba.fastjson.annotation.JSONField r0 = (com.alibaba.fastjson.annotation.JSONField) r0
    L_0x0166:
        r23 = r0
        goto L_0x0176
    L_0x0169:
        r19 = r2
        r25 = r3
        goto L_0x0176
    L_0x016e:
        r22 = r0
        r19 = r2
        r25 = r3
        r24 = r7
    L_0x0176:
        r26 = r19
        r19 = r11
        goto L_0x0185
    L_0x017b:
        r23 = r4
        r24 = r7
        r22 = r0
        r26 = r2
        r25 = r3
    L_0x0185:
        r0 = 1
        if (r23 == 0) goto L_0x020f
        java.lang.Boolean r8 = java.lang.Boolean.valueOf(r0)
        boolean r2 = r23.serialize()
        if (r2 != 0) goto L_0x019c
    L_0x0192:
        r31 = r9
        r32 = r10
        r0 = r20
        r29 = 0
        goto L_0x04e5
    L_0x019c:
        int r7 = r23.ordinal()
        com.alibaba.fastjson.serializer.SerializerFeature[] r2 = r23.serialzeFeatures()
        int r11 = com.alibaba.fastjson.serializer.SerializerFeature.m2926of(r2)
        com.alibaba.fastjson.parser.Feature[] r2 = r23.parseFeatures()
        int r27 = com.alibaba.fastjson.parser.Feature.m2571of(r2)
        java.lang.String r2 = r23.name()
        int r2 = r2.length()
        if (r2 == 0) goto L_0x01f8
        java.lang.String r0 = r23.name()
        if (r13 == 0) goto L_0x01c9
        java.lang.Object r0 = r13.get(r0)
        java.lang.String r0 = (java.lang.String) r0
        if (r0 != 0) goto L_0x01c9
        goto L_0x0192
    L_0x01c9:
        r8 = r0
        com.alibaba.fastjson.util.c r5 = new com.alibaba.fastjson.util.c
        r3 = 0
        r21 = 0
        r28 = 0
        r0 = r5
        r1 = r8
        r2 = r6
        r29 = 0
        r4 = r38
        r6 = r5
        r5 = r21
        r30 = r6
        r6 = r7
        r7 = r11
        r11 = r8
        r8 = r27
        r31 = r9
        r9 = r23
        r32 = r10
        r10 = r28
        r13 = r11
        r15 = r20
        r11 = r18
        r0.m41768init(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
        r0 = r30
        r15.put(r13, r0)
        goto L_0x022c
    L_0x01f8:
        r31 = r9
        r32 = r10
        r15 = r20
        r29 = 0
        java.lang.String r2 = r23.label()
        int r2 = r2.length()
        if (r2 == 0) goto L_0x021b
        java.lang.String r18 = r23.label()
        goto L_0x021b
    L_0x020f:
        r31 = r9
        r32 = r10
        r15 = r20
        r29 = 0
        r7 = 0
        r11 = 0
        r27 = 0
    L_0x021b:
        boolean r1 = r5.startsWith(r1)
        r13 = 102(0x66, float:1.43E-43)
        r10 = 95
        if (r1 == 0) goto L_0x03a4
        int r1 = r5.length()
        r2 = 4
        if (r1 >= r2) goto L_0x0233
    L_0x022c:
        r13 = r40
    L_0x022e:
        r0 = r15
        r15 = r43
        goto L_0x04e5
    L_0x0233:
        java.lang.String r1 = "getClass"
        boolean r1 = r5.equals(r1)
        if (r1 == 0) goto L_0x023c
        goto L_0x022c
    L_0x023c:
        java.lang.String r1 = "getDeclaringClass"
        boolean r1 = r5.equals(r1)
        if (r1 == 0) goto L_0x024b
        boolean r1 = r38.isEnum()
        if (r1 == 0) goto L_0x024b
        goto L_0x022c
    L_0x024b:
        r1 = 3
        char r3 = r5.charAt(r1)
        boolean r4 = java.lang.Character.isUpperCase(r3)
        if (r4 != 0) goto L_0x0283
        r4 = 512(0x200, float:7.175E-43)
        if (r3 <= r4) goto L_0x025b
        goto L_0x0283
    L_0x025b:
        if (r3 != r10) goto L_0x0262
        java.lang.String r2 = r5.substring(r2)
        goto L_0x02af
    L_0x0262:
        if (r3 != r13) goto L_0x0269
        java.lang.String r2 = r5.substring(r1)
        goto L_0x02af
    L_0x0269:
        int r3 = r5.length()
        r4 = 5
        if (r3 < r4) goto L_0x022c
        char r2 = r5.charAt(r2)
        boolean r2 = java.lang.Character.isUpperCase(r2)
        if (r2 == 0) goto L_0x022c
        java.lang.String r2 = r5.substring(r1)
        java.lang.String r2 = m3258e(r2)
        goto L_0x02af
    L_0x0283:
        boolean r3 = f3060a
        if (r3 == 0) goto L_0x0290
        java.lang.String r2 = r5.substring(r1)
        java.lang.String r2 = m3258e(r2)
        goto L_0x02ab
    L_0x0290:
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        char r4 = r5.charAt(r1)
        char r4 = java.lang.Character.toLowerCase(r4)
        r3.append(r4)
        java.lang.String r2 = r5.substring(r2)
        r3.append(r2)
        java.lang.String r2 = r3.toString()
    L_0x02ab:
        java.lang.String r2 = m3227a(r14, r5, r2, r1)
    L_0x02af:
        boolean r1 = m3238a(r12, r2)
        if (r1 == 0) goto L_0x02b7
        goto L_0x022c
    L_0x02b7:
        java.lang.reflect.Field r1 = com.alibaba.fastjson.parser.ParserConfig.m2905a(r2, r14)
        if (r1 != 0) goto L_0x02dd
        int r3 = r2.length()
        if (r3 <= r0) goto L_0x02dd
        char r3 = r2.charAt(r0)
        r4 = 65
        if (r3 < r4) goto L_0x02dd
        r4 = 90
        if (r3 > r4) goto L_0x02dd
        r9 = 3
        java.lang.String r1 = r5.substring(r9)
        java.lang.String r1 = m3258e(r1)
        java.lang.reflect.Field r1 = com.alibaba.fastjson.parser.ParserConfig.m2905a(r1, r14)
        goto L_0x02de
    L_0x02dd:
        r9 = 3
    L_0x02de:
        r3 = r1
        if (r3 == 0) goto L_0x034b
        java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r1 = com.alibaba.fastjson.annotation.JSONField.class
        java.lang.annotation.Annotation r1 = r3.getAnnotation(r1)
        com.alibaba.fastjson.annotation.JSONField r1 = (com.alibaba.fastjson.annotation.JSONField) r1
        if (r1 == 0) goto L_0x0343
        java.lang.Boolean r8 = java.lang.Boolean.valueOf(r0)
        boolean r0 = r1.serialize()
        if (r0 != 0) goto L_0x02f7
        goto L_0x022c
    L_0x02f7:
        int r0 = r1.ordinal()
        com.alibaba.fastjson.serializer.SerializerFeature[] r4 = r1.serialzeFeatures()
        int r4 = com.alibaba.fastjson.serializer.SerializerFeature.m2926of(r4)
        com.alibaba.fastjson.parser.Feature[] r7 = r1.parseFeatures()
        int r7 = com.alibaba.fastjson.parser.Feature.m2571of(r7)
        java.lang.String r11 = r1.name()
        int r11 = r11.length()
        if (r11 == 0) goto L_0x0328
        java.lang.String r2 = r1.name()
        r11 = r40
        if (r11 == 0) goto L_0x032a
        java.lang.Object r2 = r11.get(r2)
        java.lang.String r2 = (java.lang.String) r2
        if (r2 != 0) goto L_0x032a
        r13 = r11
        goto L_0x022e
    L_0x0328:
        r11 = r40
    L_0x032a:
        java.lang.String r20 = r1.label()
        int r20 = r20.length()
        if (r20 == 0) goto L_0x0338
        java.lang.String r18 = r1.label()
    L_0x0338:
        r20 = r4
        r27 = r7
        r4 = r11
        r21 = r18
        r18 = r0
        r11 = r1
        goto L_0x0355
    L_0x0343:
        r4 = r40
        r20 = r11
        r21 = r18
        r11 = r1
        goto L_0x0353
    L_0x034b:
        r4 = r40
        r20 = r11
        r11 = r17
        r21 = r18
    L_0x0353:
        r18 = r7
    L_0x0355:
        if (r4 == 0) goto L_0x0363
        java.lang.Object r0 = r4.get(r2)
        r2 = r0
        java.lang.String r2 = (java.lang.String) r2
        if (r2 != 0) goto L_0x0363
        r13 = r4
        goto L_0x022e
    L_0x0363:
        r7 = r15
        r15 = r43
        if (r15 == 0) goto L_0x0374
        boolean r0 = r8.booleanValue()
        if (r0 != 0) goto L_0x0374
        java.lang.String r0 = r15.translate(r2)
        r8 = r0
        goto L_0x0375
    L_0x0374:
        r8 = r2
    L_0x0375:
        com.alibaba.fastjson.util.c r2 = new com.alibaba.fastjson.util.c
        r28 = 0
        r0 = r2
        r1 = r8
        r13 = r2
        r2 = r6
        r15 = r4
        r4 = r38
        r15 = r5
        r5 = r28
        r28 = r6
        r6 = r18
        r33 = r7
        r7 = r20
        r34 = r8
        r8 = r27
        r30 = 3
        r9 = r23
        r10 = r11
        r12 = 3
        r11 = r21
        r0.m41768init(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
        r10 = r33
        r0 = r34
        r10.put(r0, r13)
        r11 = r20
        goto L_0x03ad
    L_0x03a4:
        r28 = r6
        r10 = r15
        r12 = 3
        r15 = r5
        r21 = r18
        r18 = r7
    L_0x03ad:
        java.lang.String r0 = "is"
        boolean r0 = r15.startsWith(r0)
        if (r0 == 0) goto L_0x04de
        int r0 = r15.length()
        if (r0 >= r12) goto L_0x03bd
        goto L_0x04de
    L_0x03bd:
        java.lang.Class r0 = r28.getReturnType()
        java.lang.Class r1 = java.lang.Boolean.TYPE
        if (r0 == r1) goto L_0x03cf
        java.lang.Class r0 = r28.getReturnType()
        java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
        if (r0 == r1) goto L_0x03cf
        goto L_0x04de
    L_0x03cf:
        r0 = 2
        char r1 = r15.charAt(r0)
        boolean r2 = java.lang.Character.isUpperCase(r1)
        if (r2 == 0) goto L_0x0407
        boolean r1 = f3060a
        if (r1 == 0) goto L_0x03e7
        java.lang.String r1 = r15.substring(r0)
        java.lang.String r1 = m3258e(r1)
        goto L_0x0402
    L_0x03e7:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        char r2 = r15.charAt(r0)
        char r2 = java.lang.Character.toLowerCase(r2)
        r1.append(r2)
        java.lang.String r2 = r15.substring(r12)
        r1.append(r2)
        java.lang.String r1 = r1.toString()
    L_0x0402:
        java.lang.String r0 = m3227a(r14, r15, r1, r0)
        goto L_0x040f
    L_0x0407:
        r2 = 95
        if (r1 != r2) goto L_0x0412
        java.lang.String r0 = r15.substring(r12)
    L_0x040f:
        r12 = r38
        goto L_0x041b
    L_0x0412:
        r2 = 102(0x66, float:1.43E-43)
        if (r1 != r2) goto L_0x04de
        java.lang.String r0 = r15.substring(r0)
        goto L_0x040f
    L_0x041b:
        boolean r1 = m3238a(r12, r0)
        if (r1 == 0) goto L_0x0423
    L_0x0421:
        goto L_0x04e0
    L_0x0423:
        java.lang.reflect.Field r1 = com.alibaba.fastjson.parser.ParserConfig.m2905a(r0, r14)
        if (r1 != 0) goto L_0x042d
        java.lang.reflect.Field r1 = com.alibaba.fastjson.parser.ParserConfig.m2905a(r15, r14)
    L_0x042d:
        r3 = r1
        if (r3 == 0) goto L_0x0495
        java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r1 = com.alibaba.fastjson.annotation.JSONField.class
        java.lang.annotation.Annotation r1 = r3.getAnnotation(r1)
        com.alibaba.fastjson.annotation.JSONField r1 = (com.alibaba.fastjson.annotation.JSONField) r1
        if (r1 == 0) goto L_0x048e
        boolean r2 = r1.serialize()
        if (r2 != 0) goto L_0x0441
        goto L_0x0421
    L_0x0441:
        int r2 = r1.ordinal()
        com.alibaba.fastjson.serializer.SerializerFeature[] r4 = r1.serialzeFeatures()
        int r4 = com.alibaba.fastjson.serializer.SerializerFeature.m2926of(r4)
        com.alibaba.fastjson.parser.Feature[] r5 = r1.parseFeatures()
        int r5 = com.alibaba.fastjson.parser.Feature.m2571of(r5)
        java.lang.String r6 = r1.name()
        int r6 = r6.length()
        if (r6 == 0) goto L_0x0470
        java.lang.String r0 = r1.name()
        r6 = r40
        if (r6 == 0) goto L_0x0472
        java.lang.Object r0 = r6.get(r0)
        java.lang.String r0 = (java.lang.String) r0
        if (r0 != 0) goto L_0x0472
        goto L_0x04a6
    L_0x0470:
        r6 = r40
    L_0x0472:
        java.lang.String r7 = r1.label()
        int r7 = r7.length()
        if (r7 == 0) goto L_0x0488
        java.lang.String r7 = r1.label()
        r11 = r1
        r18 = r2
        r8 = r5
        r21 = r7
        r7 = r4
        goto L_0x049c
    L_0x0488:
        r11 = r1
        r18 = r2
        r7 = r4
        r8 = r5
        goto L_0x049c
    L_0x048e:
        r6 = r40
        r7 = r11
        r8 = r27
        r11 = r1
        goto L_0x049c
    L_0x0495:
        r6 = r40
        r7 = r11
        r11 = r17
        r8 = r27
    L_0x049c:
        if (r6 == 0) goto L_0x04aa
        java.lang.Object r0 = r6.get(r0)
        java.lang.String r0 = (java.lang.String) r0
        if (r0 != 0) goto L_0x04aa
    L_0x04a6:
        r15 = r43
        r13 = r6
        goto L_0x04e4
    L_0x04aa:
        r15 = r43
        r13 = r6
        if (r15 == 0) goto L_0x04b3
        java.lang.String r0 = r15.translate(r0)
    L_0x04b3:
        r9 = r0
        boolean r0 = r10.containsKey(r9)
        if (r0 == 0) goto L_0x04bb
        goto L_0x04e4
    L_0x04bb:
        com.alibaba.fastjson.util.c r6 = new com.alibaba.fastjson.util.c
        r5 = 0
        r0 = r6
        r1 = r9
        r2 = r28
        r4 = r38
        r35 = r6
        r6 = r18
        r36 = r9
        r9 = r23
        r37 = r10
        r10 = r11
        r11 = r21
        r0.m41768init(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
        r2 = r35
        r1 = r36
        r0 = r37
        r0.put(r1, r2)
        goto L_0x04e5
    L_0x04de:
        r12 = r38
    L_0x04e0:
        r13 = r40
        r15 = r43
    L_0x04e4:
        r0 = r10
    L_0x04e5:
        r1 = r19
        r3 = r25
        r2 = r26
    L_0x04eb:
        int r7 = r24 + 1
        r11 = r0
        r0 = r22
        r9 = r31
        r10 = r32
        goto L_0x0022
    L_0x04f6:
        r0 = r11
        java.lang.reflect.Field[] r1 = r38.getFields()
        m3235a(r12, r13, r15, r0, r1)
        r1 = r42
        java.util.List r0 = m3233a(r12, r1, r0)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.m3231a(java.lang.Class, com.alibaba.fastjson.annotation.JSONType, java.util.Map, java.util.Map, boolean, com.alibaba.fastjson.PropertyNamingStrategy):java.util.List");
    }

    /* renamed from: a */
    private static List<FieldInfo> m3233a(Class<?> cls, boolean z, Map<String, FieldInfo> map) {
        ArrayList arrayList = new ArrayList();
        JSONType jSONType = (JSONType) m3228a(cls, JSONType.class);
        String[] orders = jSONType != null ? jSONType.orders() : null;
        if (orders == null || orders.length <= 0) {
            for (FieldInfo add : map.values()) {
                arrayList.add(add);
            }
            if (z) {
                Collections.sort(arrayList);
            }
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap(arrayList.size());
            for (FieldInfo cVar : map.values()) {
                linkedHashMap.put(cVar.f2992a, cVar);
            }
            for (String str : orders) {
                FieldInfo cVar2 = (FieldInfo) linkedHashMap.get(str);
                if (cVar2 != null) {
                    arrayList.add(cVar2);
                    linkedHashMap.remove(str);
                }
            }
            for (FieldInfo add2 : linkedHashMap.values()) {
                arrayList.add(add2);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m3235a(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy, Map<String, FieldInfo> map2, Field[] fieldArr) {
        Field[] fieldArr2;
        String str;
        int i;
        int i2;
        int i3;
        Map<String, String> map3 = map;
        PropertyNamingStrategy propertyNamingStrategy2 = propertyNamingStrategy;
        Map<String, FieldInfo> map4 = map2;
        for (Field field : fieldArr) {
            if (!Modifier.isStatic(field.getModifiers())) {
                JSONField jSONField = (JSONField) field.getAnnotation(JSONField.class);
                String name = field.getName();
                String str2 = null;
                if (jSONField == null) {
                    str = null;
                    i3 = 0;
                    i2 = 0;
                    i = 0;
                } else if (jSONField.serialize()) {
                    int ordinal = jSONField.ordinal();
                    int of = SerializerFeature.m2926of(jSONField.serialzeFeatures());
                    int of2 = Feature.m2571of(jSONField.parseFeatures());
                    if (jSONField.name().length() != 0) {
                        name = jSONField.name();
                    }
                    if (jSONField.label().length() != 0) {
                        str2 = jSONField.label();
                    }
                    str = str2;
                    i3 = ordinal;
                    i2 = of;
                    i = of2;
                }
                if (map3 != null) {
                    name = (String) map3.get(name);
                    if (name == null) {
                    }
                }
                if (propertyNamingStrategy2 != null) {
                    name = propertyNamingStrategy2.translate(name);
                }
                String str3 = name;
                if (!map4.containsKey(str3)) {
                    FieldInfo cVar = r7;
                    String str4 = str3;
                    FieldInfo cVar2 = new FieldInfo(str3, null, field, cls, null, i3, i2, i, null, jSONField, str);
                    map4.put(str4, cVar);
                }
            }
        }
    }

    /* renamed from: a */
    private static String m3227a(Map<String, Field> map, String str, String str2, int i) {
        if (!f3061b || map.containsKey(str2)) {
            return str2;
        }
        String substring = str.substring(i);
        if (!map.containsKey(substring)) {
            substring = str2;
        }
        return substring;
    }

    /* renamed from: a */
    public static JSONField m3216a(Class<?> cls, Method method) {
        boolean z;
        boolean z2;
        Class[] interfaces = cls.getInterfaces();
        if (interfaces.length > 0) {
            Class[] parameterTypes = method.getParameterTypes();
            for (Class methods : interfaces) {
                Method[] methods2 = methods.getMethods();
                int length = methods2.length;
                for (int i = 0; i < length; i++) {
                    Method method2 = methods2[i];
                    Class[] parameterTypes2 = method2.getParameterTypes();
                    if (parameterTypes2.length == parameterTypes.length && method2.getName().equals(method.getName())) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= parameterTypes.length) {
                                z2 = true;
                                break;
                            } else if (!parameterTypes2[i2].equals(parameterTypes[i2])) {
                                z2 = false;
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (!z2) {
                            continue;
                        } else {
                            JSONField jSONField = (JSONField) method2.getAnnotation(JSONField.class);
                            if (jSONField != null) {
                                return jSONField;
                            }
                        }
                    }
                }
            }
        }
        Class superclass = cls.getSuperclass();
        if (superclass != null && Modifier.isAbstract(superclass.getModifiers())) {
            Class[] parameterTypes3 = method.getParameterTypes();
            Method[] methods3 = superclass.getMethods();
            int length2 = methods3.length;
            for (int i3 = 0; i3 < length2; i3++) {
                Method method3 = methods3[i3];
                Class[] parameterTypes4 = method3.getParameterTypes();
                if (parameterTypes4.length == parameterTypes3.length && method3.getName().equals(method.getName())) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= parameterTypes3.length) {
                            z = true;
                            break;
                        } else if (!parameterTypes4[i4].equals(parameterTypes3[i4])) {
                            z = false;
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (!z) {
                        continue;
                    } else {
                        JSONField jSONField2 = (JSONField) method3.getAnnotation(JSONField.class);
                        if (jSONField2 != null) {
                            return jSONField2;
                        }
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m3238a(Class<?> cls, String str) {
        JSONType jSONType = (JSONType) m3228a(cls, JSONType.class);
        if (jSONType != null) {
            String[] includes = jSONType.includes();
            if (includes.length > 0) {
                for (String equals : includes) {
                    if (str.equals(equals)) {
                        return false;
                    }
                }
                return true;
            }
            String[] ignores = jSONType.ignores();
            for (String equals2 : ignores) {
                if (str.equals(equals2)) {
                    return true;
                }
            }
        }
        return (cls.getSuperclass() == Object.class || cls.getSuperclass() == null || !m3238a(cls.getSuperclass(), str)) ? false : true;
    }

    /* renamed from: a */
    public static boolean m3241a(Type type) {
        if (type instanceof ParameterizedType) {
            return true;
        }
        if (!(type instanceof Class)) {
            return false;
        }
        Type genericSuperclass = ((Class) type).getGenericSuperclass();
        if (genericSuperclass == Object.class) {
            return false;
        }
        return m3241a(genericSuperclass);
    }

    /* renamed from: b */
    public static Type m3245b(Type type) {
        if (type instanceof ParameterizedType) {
            return type;
        }
        if (type instanceof Class) {
            type = m3245b(((Class) type).getGenericSuperclass());
        }
        return type;
    }

    /* renamed from: c */
    public static Type m3251c(Type type) {
        if (!f3067h) {
            try {
                f3068i = Class.forName("java.util.Optional");
            } catch (Exception unused) {
            } catch (Throwable th) {
                f3067h = true;
                throw th;
            }
            f3067h = true;
        }
        if (!(type instanceof ParameterizedType)) {
            return type;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        return parameterizedType.getRawType() == f3068i ? parameterizedType.getActualTypeArguments()[0] : type;
    }

    /* renamed from: d */
    public static Class<?> m3255d(Type type) {
        if (type.getClass() == Class.class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return m3255d(((ParameterizedType) type).getRawType());
        }
        if (type instanceof TypeVariable) {
            return (Class) ((TypeVariable) type).getBounds()[0];
        }
        if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            if (upperBounds.length == 1) {
                return m3255d(upperBounds[0]);
            }
        }
        return Object.class;
    }

    /* renamed from: a */
    public static Field m3230a(Class<?> cls, String str, Field[] fieldArr) {
        for (Field field : fieldArr) {
            String name = field.getName();
            if (str.equals(name)) {
                return field;
            }
            if (str.length() > 2) {
                char charAt = str.charAt(0);
                if (charAt >= 'a' && charAt <= 'z') {
                    char charAt2 = str.charAt(1);
                    if (charAt2 >= 'A' && charAt2 <= 'Z' && str.equalsIgnoreCase(name)) {
                        return field;
                    }
                }
            }
        }
        Class<Object> superclass = cls.getSuperclass();
        if (superclass == null || superclass == Object.class) {
            return null;
        }
        return m3230a(superclass, str, superclass.getDeclaredFields());
    }

    /* renamed from: b */
    public static int m3242b(Class<?> cls) {
        JSONType jSONType = (JSONType) m3228a(cls, JSONType.class);
        if (jSONType == null) {
            return 0;
        }
        return Feature.m2571of(jSONType.parseFeatures());
    }

    /* renamed from: e */
    public static String m3258e(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    /* renamed from: a */
    static void m3236a(AccessibleObject accessibleObject) {
        if (f3062c && !accessibleObject.isAccessible()) {
            try {
                accessibleObject.setAccessible(true);
            } catch (AccessControlException unused) {
                f3062c = false;
            }
        }
    }

    /* renamed from: e */
    public static Type m3259e(Type type) {
        Type type2;
        if (type instanceof ParameterizedType) {
            type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof WildcardType) {
                Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
                if (upperBounds.length == 1) {
                    type2 = upperBounds[0];
                }
            }
        } else {
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (!cls.getName().startsWith("java.")) {
                    type2 = m3259e(cls.getGenericSuperclass());
                }
            }
            type2 = null;
        }
        return type2 == null ? Object.class : type2;
    }

    /* renamed from: f */
    public static Class<?> m3263f(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return Object.class;
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
            if (upperBounds.length == 1) {
                type2 = upperBounds[0];
            }
        }
        String str = "can not create ASMParser";
        if (type2 instanceof Class) {
            Class<?> cls = (Class) type2;
            if (Modifier.isPublic(cls.getModifiers())) {
                return cls;
            }
            throw new JSONException(str);
        }
        throw new JSONException(str);
    }

    /* renamed from: g */
    public static Collection m3267g(Type type) {
        Type type2;
        Class<Collection> h = m3268h(type);
        if (h == AbstractCollection.class || h == Collection.class) {
            return new ArrayList();
        }
        if (h.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (h.isAssignableFrom(LinkedHashSet.class)) {
            return new LinkedHashSet();
        }
        if (h.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        if (h.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        if (h.isAssignableFrom(EnumSet.class)) {
            if (type instanceof ParameterizedType) {
                type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                type2 = Object.class;
            }
            return EnumSet.noneOf((Class) type2);
        }
        try {
            return (Collection) h.newInstance();
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("create instance error, class ");
            sb.append(h.getName());
            throw new JSONException(sb.toString());
        }
    }

    /* renamed from: h */
    public static Class<?> m3268h(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return m3268h(((ParameterizedType) type).getRawType());
        }
        throw new JSONException("TODO");
    }

    /* renamed from: c */
    public static boolean m3252c(Class<?> cls) {
        for (Class name : cls.getInterfaces()) {
            String name2 = name.getName();
            if (name2.equals("net.sf.cglib.proxy.Factory") || name2.equals("org.springframework.cglib.proxy.Factory") || name2.equals("javassist.util.proxy.ProxyObject") || name2.equals("org.apache.ibatis.javassist.util.proxy.ProxyObject")) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m3240a(Method method) {
        boolean z = false;
        if (method == null) {
            return false;
        }
        if (!f3069j) {
            try {
                f3070k = Class.forName("java.beans.Transient");
            } catch (Exception unused) {
            } catch (Throwable th) {
                f3069j = true;
                throw th;
            }
            f3069j = true;
        }
        Class<? extends Annotation> cls = f3070k;
        if (!(cls == null || method.getAnnotation(cls) == null)) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    public static boolean m3248b(Method method) {
        if (method == null) {
            return false;
        }
        if (f3071l == null && !f3072m) {
            try {
                f3071l = Class.forName("javax.persistence.OneToMany");
            } catch (Throwable unused) {
                f3072m = true;
            }
        }
        Class<? extends Annotation> cls = f3071l;
        if (cls == null) {
            return false;
        }
        return method.isAnnotationPresent(cls);
    }

    /* renamed from: c */
    public static boolean m3253c(Method method) {
        boolean z = false;
        if (method == null) {
            return false;
        }
        if (f3073n == null && !f3074o) {
            try {
                f3073n = Class.forName("javax.persistence.ManyToMany");
            } catch (Throwable unused) {
                f3074o = true;
            }
        }
        if (f3073n == null) {
            return false;
        }
        if (method.isAnnotationPresent(f3071l) || method.isAnnotationPresent(f3073n)) {
            z = true;
        }
        return z;
    }

    /* renamed from: p */
    public static boolean m3277p(Object obj) {
        if (obj == null) {
            return false;
        }
        if (f3075p == null && !f3076q) {
            try {
                f3075p = Class.forName("org.hibernate.Hibernate").getMethod("isInitialized", new Class[]{Object.class});
            } catch (Throwable unused) {
                f3076q = true;
            }
        }
        Method method = f3075p;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(null, new Object[]{obj})).booleanValue();
            } catch (Throwable unused2) {
            }
        }
        return true;
    }

    /* renamed from: f */
    public static long m3262f(String str) {
        long j = -3750763034362895579L;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!(charAt == '_' || charAt == '-')) {
                if (charAt >= 'A' && charAt <= 'Z') {
                    charAt = (char) (charAt + ' ');
                }
                j = (j ^ ((long) charAt)) * 1099511628211L;
            }
        }
        return j;
    }

    /* renamed from: g */
    public static long m3265g(String str) {
        long j = -3750763034362895579L;
        for (int i = 0; i < str.length(); i++) {
            j = (j ^ ((long) str.charAt(i))) * 1099511628211L;
        }
        return j;
    }

    /* renamed from: d */
    public static boolean m3257d(Class cls) {
        if (f3077r == null && !f3078s) {
            try {
                f3077r = Class.forName("kotlin.Metadata");
            } catch (Throwable unused) {
                f3078s = true;
            }
        }
        if (f3077r == null) {
            return false;
        }
        return cls.isAnnotationPresent(f3077r);
    }

    /* renamed from: a */
    public static Constructor m3229a(Constructor[] constructorArr) {
        Constructor constructor = null;
        for (Constructor constructor2 : constructorArr) {
            Class[] parameterTypes = constructor2.getParameterTypes();
            if ((parameterTypes.length <= 0 || !parameterTypes[parameterTypes.length - 1].getName().equals("kotlin.jvm.internal.DefaultConstructorMarker")) && (constructor == null || constructor.getParameterTypes().length < parameterTypes.length)) {
                constructor = constructor2;
            }
        }
        return constructor;
    }

    /* renamed from: e */
    public static String[] m3261e(Class cls) {
        String str = "kotlin.reflect.jvm.internal.KClassImpl";
        if (f3080u == null && !f3079t) {
            try {
                f3080u = Class.forName(str).getConstructor(new Class[]{Class.class});
            } catch (Throwable unused) {
                f3079t = true;
            }
        }
        if (f3080u == null) {
            return null;
        }
        if (f3081v == null && !f3079t) {
            try {
                f3081v = Class.forName(str).getMethod("getConstructors", new Class[0]);
            } catch (Throwable unused2) {
                f3079t = true;
            }
        }
        if (f3082w == null && !f3079t) {
            try {
                f3082w = Class.forName("kotlin.reflect.e").getMethod("getParameters", new Class[0]);
            } catch (Throwable unused3) {
                f3079t = true;
            }
        }
        if (f3083x == null && !f3079t) {
            try {
                f3083x = Class.forName("kotlin.reflect.KParameter").getMethod("getName", new Class[0]);
            } catch (Throwable unused4) {
                f3079t = true;
            }
        }
        if (f3084y) {
            return null;
        }
        try {
            Iterator it = ((Iterable) f3081v.invoke(f3080u.newInstance(new Object[]{cls}), new Object[0])).iterator();
            Object obj = null;
            while (it.hasNext()) {
                Object next = it.next();
                List list = (List) f3082w.invoke(next, new Object[0]);
                if (obj == null || list.size() != 0) {
                    obj = next;
                }
                it.hasNext();
            }
            List list2 = (List) f3082w.invoke(obj, new Object[0]);
            String[] strArr = new String[list2.size()];
            for (int i = 0; i < list2.size(); i++) {
                strArr[i] = (String) f3083x.invoke(list2.get(i), new Object[0]);
            }
            return strArr;
        } catch (Throwable th) {
            th.printStackTrace();
            f3084y = true;
            return null;
        }
    }

    /* renamed from: b */
    private static boolean m3247b(Class cls, String str) {
        String str2 = "isEmpty";
        String str3 = "getEndInclusive";
        if (f3085z == null && !f3056A) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(Class.forName("kotlin.d.c"), new String[]{str3, str2});
                hashMap.put(Class.forName("kotlin.d.j"), new String[]{str3, str2});
                hashMap.put(Class.forName("kotlin.d.m"), new String[]{str3, str2});
                hashMap.put(Class.forName("kotlin.d.e"), new String[]{str3, str2});
                hashMap.put(Class.forName("kotlin.d.d"), new String[]{str3, str2});
                f3085z = hashMap;
            } catch (Throwable unused) {
                f3056A = true;
            }
        }
        boolean z = false;
        if (f3085z == null) {
            return false;
        }
        String[] strArr = (String[]) f3085z.get(cls);
        if (strArr == null) {
            return false;
        }
        if (Arrays.binarySearch(strArr, str) >= 0) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public static <A extends Annotation> A m3228a(Class<?> cls, Class<A> cls2) {
        A annotation = cls.getAnnotation(cls2);
        if (annotation != null) {
            return annotation;
        }
        if (cls.getAnnotations().length > 0) {
            for (Annotation annotationType : cls.getAnnotations()) {
                A annotation2 = annotationType.annotationType().getAnnotation(cls2);
                if (annotation2 != null) {
                    return annotation2;
                }
            }
        }
        return null;
    }
}
