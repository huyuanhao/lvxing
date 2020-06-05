package org.p703a;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: org.a.c */
public class C8553c {
    /* renamed from: a */
    public static final Object f29061a = new C8555a();
    /* renamed from: b */
    private final Map<String, Object> f29062b;

    /* renamed from: org.a.c$a */
    private static final class C8555a {
        private C8555a() {
        }

        /* access modifiers changed from: protected|final */
        public final Object clone() {
            return this;
        }

        public boolean equals(Object obj) {
            return obj == null || obj == this;
        }

        public int hashCode() {
            return 0;
        }

        public String toString() {
            return "null";
        }
    }

    public C8553c() {
        this.f29062b = new HashMap();
    }

    public C8553c(Object obj) {
        this();
        m36954d(obj);
    }

    public C8553c(Map<?, ?> map) {
        if (map == null) {
            this.f29062b = new HashMap();
            return;
        }
        this.f29062b = new HashMap(map.size());
        for (Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                this.f29062b.put(String.valueOf(entry.getKey()), m36953c(value));
            }
        }
    }

    /* renamed from: a */
    static final Writer m36946a(Writer writer, Object obj, int i, int i2) {
        String str;
        String str2;
        String str3;
        C8551a aVar;
        if (obj == null || obj.equals(null)) {
            str = "null";
        } else {
            if (obj instanceof C8556d) {
                try {
                    String a = ((C8556d) obj).mo40849a();
                    if (a != null) {
                        str = a.toString();
                    } else {
                        str2 = obj.toString();
                    }
                } catch (Exception e) {
                    throw new C8552b((Throwable) e);
                }
            } else if (obj instanceof Number) {
                str3 = m36948a((Number) obj);
                try {
                    new BigDecimal(str3);
                    writer.write(str3);
                } catch (NumberFormatException unused) {
                }
                return writer;
            } else if (obj instanceof Boolean) {
                str = obj.toString();
            } else if (obj instanceof Enum) {
                str2 = ((Enum) obj).name();
            } else {
                if (obj instanceof C8553c) {
                    ((C8553c) obj).mo40840a(writer, i, i2);
                } else if (obj instanceof C8551a) {
                    ((C8551a) obj).mo40835a(writer, i, i2);
                } else if (obj instanceof Map) {
                    new C8553c((Map) obj).mo40840a(writer, i, i2);
                } else {
                    if (obj instanceof Collection) {
                        aVar = new C8551a((Collection) obj);
                    } else if (obj.getClass().isArray()) {
                        aVar = new C8551a(obj);
                    } else {
                        str3 = obj.toString();
                        m36947a(str3, writer);
                    }
                    aVar.mo40835a(writer, i, i2);
                }
                return writer;
            }
            str = m36949a(str2);
        }
        writer.write(str);
        return writer;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0068, code lost:
            if (r4 == '<') goto L_0x006a;
     */
    /* renamed from: a */
    public static java.io.Writer m36947a(java.lang.String r8, java.io.Writer r9) {
        /*
        if (r8 == 0) goto L_0x007f
        int r0 = r8.length()
        if (r0 != 0) goto L_0x000a
        goto L_0x007f
    L_0x000a:
        int r0 = r8.length()
        r1 = 34
        r9.write(r1)
        r2 = 0
        r3 = 0
        r4 = 0
    L_0x0016:
        if (r3 >= r0) goto L_0x007b
        char r5 = r8.charAt(r3)
        r6 = 12
        if (r5 == r6) goto L_0x0074
        r6 = 13
        if (r5 == r6) goto L_0x0071
        r6 = 92
        if (r5 == r1) goto L_0x006a
        r7 = 47
        if (r5 == r7) goto L_0x0066
        if (r5 == r6) goto L_0x006a
        switch(r5) {
            case 8: goto L_0x0060;
            case 9: goto L_0x005d;
            case 10: goto L_0x005a;
            default: goto L_0x0031;
        }
    L_0x0031:
        r4 = 32
        if (r5 < r4) goto L_0x0045
        r4 = 128(0x80, float:1.794E-43)
        if (r5 < r4) goto L_0x003d
        r4 = 160(0xa0, float:2.24E-43)
        if (r5 < r4) goto L_0x0045
    L_0x003d:
        r4 = 8192(0x2000, float:1.14794E-41)
        if (r5 < r4) goto L_0x006d
        r4 = 8448(0x2100, float:1.1838E-41)
        if (r5 >= r4) goto L_0x006d
    L_0x0045:
        java.lang.String r4 = "\\u"
        r9.write(r4)
        java.lang.String r4 = java.lang.Integer.toHexString(r5)
        int r6 = r4.length()
        int r6 = 4 - r6
        java.lang.String r7 = "0000"
        r9.write(r7, r2, r6)
        goto L_0x0062
    L_0x005a:
        java.lang.String r4 = "\\n"
        goto L_0x0062
    L_0x005d:
        java.lang.String r4 = "\\t"
        goto L_0x0062
    L_0x0060:
        java.lang.String r4 = "\\b"
    L_0x0062:
        r9.write(r4)
        goto L_0x0077
    L_0x0066:
        r7 = 60
        if (r4 != r7) goto L_0x006d
    L_0x006a:
        r9.write(r6)
    L_0x006d:
        r9.write(r5)
        goto L_0x0077
    L_0x0071:
        java.lang.String r4 = "\\r"
        goto L_0x0062
    L_0x0074:
        java.lang.String r4 = "\\f"
        goto L_0x0062
    L_0x0077:
        int r3 = r3 + 1
        r4 = r5
        goto L_0x0016
    L_0x007b:
        r9.write(r1)
        return r9
    L_0x007f:
        java.lang.String r8 = "\"\""
        r9.write(r8)
        return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.p703a.C8553c.m36947a(java.lang.String, java.io.Writer):java.io.Writer");
    }

    /* renamed from: a */
    public static String m36948a(Number number) {
        if (number != null) {
            m36951a((Object) number);
            String obj = number.toString();
            if (obj.indexOf(46) <= 0 || obj.indexOf(101) >= 0 || obj.indexOf(69) >= 0) {
                return obj;
            }
            while (obj.endsWith("0")) {
                obj = obj.substring(0, obj.length() - 1);
            }
            return obj.endsWith(".") ? obj.substring(0, obj.length() - 1) : obj;
        }
        throw new C8552b("Null pointer");
    }

    /* renamed from: a */
    public static String m36949a(String str) {
        String obj;
        StringWriter stringWriter = new StringWriter();
        synchronized (stringWriter.getBuffer()) {
            try {
                obj = m36947a(str, (Writer) stringWriter).toString();
            } catch (IOException unused) {
                return "";
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    /* renamed from: a */
    static final void m36950a(Writer writer, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            writer.write(32);
        }
    }

    /* renamed from: a */
    public static void m36951a(Object obj) {
        if (obj != null) {
            String str = "JSON does not allow non-finite numbers.";
            if (obj instanceof Double) {
                Double d = (Double) obj;
                if (d.isInfinite() || d.isNaN()) {
                    throw new C8552b(str);
                }
            } else if (obj instanceof Float) {
                Float f = (Float) obj;
                if (f.isInfinite() || f.isNaN()) {
                    throw new C8552b(str);
                }
            }
        }
    }

    /* renamed from: b */
    public static String m36952b(Object obj) {
        if (obj == null || obj.equals(null)) {
            return "null";
        }
        if (obj instanceof C8556d) {
            try {
                String a = ((C8556d) obj).mo40849a();
                if (a instanceof String) {
                    return a;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Bad value from toJSONString: ");
                sb.append(a);
                throw new C8552b(sb.toString());
            } catch (Exception e) {
                throw new C8552b((Throwable) e);
            }
        } else if (!(obj instanceof Number)) {
            return ((obj instanceof Boolean) || (obj instanceof C8553c) || (obj instanceof C8551a)) ? obj.toString() : obj instanceof Map ? new C8553c((Map) obj).toString() : obj instanceof Collection ? new C8551a((Collection) obj).toString() : obj.getClass().isArray() ? new C8551a(obj).toString() : obj instanceof Enum ? m36949a(((Enum) obj).name()) : m36949a(obj.toString());
        } else {
            String a2 = m36948a((Number) obj);
            try {
                new BigDecimal(a2);
                return a2;
            } catch (NumberFormatException unused) {
                return m36949a(a2);
            }
        }
    }

    /* renamed from: c */
    public static Object m36953c(Object obj) {
        if (obj == null) {
            try {
                return f29061a;
            } catch (Exception unused) {
                return null;
            }
        } else {
            if (!(obj instanceof C8553c) && !(obj instanceof C8551a) && !f29061a.equals(obj) && !(obj instanceof C8556d) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Short) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Boolean) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof String) && !(obj instanceof BigInteger) && !(obj instanceof BigDecimal)) {
                if (!(obj instanceof Enum)) {
                    if (obj instanceof Collection) {
                        return new C8551a((Collection) obj);
                    }
                    if (obj.getClass().isArray()) {
                        return new C8551a(obj);
                    }
                    if (obj instanceof Map) {
                        return new C8553c((Map) obj);
                    }
                    Package packageR = obj.getClass().getPackage();
                    String name = packageR != null ? packageR.getName() : "";
                    if (!name.startsWith("java.") && !name.startsWith("javax.")) {
                        if (obj.getClass().getClassLoader() != null) {
                            return new C8553c(obj);
                        }
                    }
                    obj = obj.toString();
                }
            }
            return obj;
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[ExcHandler: IllegalAccessException | IllegalArgumentException | InvocationTargetException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:44:0x00ca] */
    /* renamed from: d */
    private void m36954d(java.lang.Object r11) {
        /*
        r10 = this;
        java.lang.Class r0 = r11.getClass()
        java.lang.ClassLoader r1 = r0.getClassLoader()
        r2 = 0
        r3 = 1
        if (r1 == 0) goto L_0x000e
        r1 = 1
        goto L_0x000f
    L_0x000e:
        r1 = 0
    L_0x000f:
        if (r1 == 0) goto L_0x0016
        java.lang.reflect.Method[] r0 = r0.getMethods()
        goto L_0x001a
    L_0x0016:
        java.lang.reflect.Method[] r0 = r0.getDeclaredMethods()
    L_0x001a:
        int r1 = r0.length
        r4 = 0
    L_0x001c:
        if (r4 >= r1) goto L_0x00d3
        r5 = r0[r4]
        int r6 = r5.getModifiers()
        boolean r7 = java.lang.reflect.Modifier.isPublic(r6)
        if (r7 == 0) goto L_0x00cf
        boolean r6 = java.lang.reflect.Modifier.isStatic(r6)
        if (r6 != 0) goto L_0x00cf
        java.lang.Class[] r6 = r5.getParameterTypes()
        int r6 = r6.length
        if (r6 != 0) goto L_0x00cf
        boolean r6 = r5.isBridge()
        if (r6 != 0) goto L_0x00cf
        java.lang.Class r6 = r5.getReturnType()
        java.lang.Class r7 = java.lang.Void.TYPE
        if (r6 == r7) goto L_0x00cf
        java.lang.String r6 = r5.getName()
        java.lang.String r7 = "get"
        boolean r7 = r6.startsWith(r7)
        if (r7 == 0) goto L_0x0064
        java.lang.String r7 = "getClass"
        boolean r7 = r7.equals(r6)
        if (r7 != 0) goto L_0x00cf
        java.lang.String r7 = "getDeclaringClass"
        boolean r7 = r7.equals(r6)
        if (r7 == 0) goto L_0x0062
        goto L_0x00cf
    L_0x0062:
        r7 = 3
        goto L_0x006d
    L_0x0064:
        java.lang.String r7 = "is"
        boolean r7 = r6.startsWith(r7)
        if (r7 == 0) goto L_0x00cf
        r7 = 2
    L_0x006d:
        java.lang.String r6 = r6.substring(r7)
        int r7 = r6.length()
        if (r7 <= 0) goto L_0x00cf
        char r7 = r6.charAt(r2)
        boolean r7 = java.lang.Character.isUpperCase(r7)
        if (r7 == 0) goto L_0x00cf
        int r7 = r6.length()
        if (r7 != r3) goto L_0x008e
        java.util.Locale r7 = java.util.Locale.ROOT
        java.lang.String r6 = r6.toLowerCase(r7)
        goto L_0x00b5
    L_0x008e:
        char r7 = r6.charAt(r3)
        boolean r7 = java.lang.Character.isUpperCase(r7)
        if (r7 != 0) goto L_0x00b5
        java.lang.StringBuilder r7 = new java.lang.StringBuilder
        r7.<init>()
        java.lang.String r8 = r6.substring(r2, r3)
        java.util.Locale r9 = java.util.Locale.ROOT
        java.lang.String r8 = r8.toLowerCase(r9)
        r7.append(r8)
        java.lang.String r6 = r6.substring(r3)
        r7.append(r6)
        java.lang.String r6 = r7.toString()
    L_0x00b5:
        java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{  }
        java.lang.Object r5 = r5.invoke(r11, r7)     // Catch:{  }
        if (r5 == 0) goto L_0x00cf
        java.util.Map<java.lang.String, java.lang.Object> r7 = r10.f29062b     // Catch:{  }
        java.lang.Object r8 = m36953c(r5)     // Catch:{  }
        r7.put(r6, r8)     // Catch:{  }
        boolean r6 = r5 instanceof java.io.Closeable     // Catch:{  }
        if (r6 == 0) goto L_0x00cf
        java.io.Closeable r5 = (java.io.Closeable) r5     // Catch:{ IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x00cf, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x00cf, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x00cf }
        r5.close()     // Catch:{ IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x00cf, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x00cf, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x00cf }
    L_0x00cf:
        int r4 = r4 + 1
        goto L_0x001c
    L_0x00d3:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.p703a.C8553c.m36954d(java.lang.Object):void");
    }

    /* renamed from: a */
    public Writer mo40840a(Writer writer, int i, int i2) {
        String str;
        String str2;
        String str3;
        boolean z = false;
        try {
            int b = mo40843b();
            writer.write(123);
            str = "Unable to write JSONObject value for key: ";
            if (b == 1) {
                Entry entry = (Entry) mo40842a().iterator().next();
                str3 = (String) entry.getKey();
                writer.write(m36949a(str3));
                writer.write(58);
                if (i > 0) {
                    writer.write(32);
                }
                m36946a(writer, entry.getValue(), i, i2);
            } else if (b != 0) {
                int i3 = i2 + i;
                for (Entry entry2 : mo40842a()) {
                    if (z) {
                        writer.write(44);
                    }
                    if (i > 0) {
                        writer.write(10);
                    }
                    m36950a(writer, i3);
                    str2 = (String) entry2.getKey();
                    writer.write(m36949a(str2));
                    writer.write(58);
                    if (i > 0) {
                        writer.write(32);
                    }
                    m36946a(writer, entry2.getValue(), i, i3);
                    z = true;
                }
                if (i > 0) {
                    writer.write(10);
                }
                m36950a(writer, i2);
            }
            writer.write(125);
            return writer;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            throw new C8552b(sb.toString(), e);
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(str3);
            throw new C8552b(sb2.toString(), e2);
        } catch (IOException e3) {
            throw new C8552b((Throwable) e3);
        }
    }

    /* renamed from: a */
    public String mo40841a(int i) {
        String obj;
        StringWriter stringWriter = new StringWriter();
        synchronized (stringWriter.getBuffer()) {
            obj = mo40840a(stringWriter, i, 0).toString();
        }
        return obj;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Set<Entry<String, Object>> mo40842a() {
        return this.f29062b.entrySet();
    }

    /* renamed from: b */
    public int mo40843b() {
        return this.f29062b.size();
    }

    public String toString() {
        try {
            return mo40841a(0);
        } catch (Exception unused) {
            return null;
        }
    }
}
