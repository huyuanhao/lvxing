package org.json.alipay;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: org.json.alipay.b */
public class C8577b {
    /* renamed from: a */
    public static final Object f29203a = new C8578a(0);
    /* renamed from: b */
    private Map f29204b;

    /* renamed from: org.json.alipay.b$a */
    private static final class C8578a {
        private C8578a() {
        }

        /* synthetic */ C8578a(byte b) {
            this();
        }

        /* access modifiers changed from: protected|final */
        public final Object clone() {
            return this;
        }

        public final boolean equals(Object obj) {
            return obj == null || obj == this;
        }

        public final String toString() {
            return "null";
        }
    }

    public C8577b() {
        this.f29204b = new HashMap();
    }

    public C8577b(String str) {
        this(new C8579c(str));
    }

    public C8577b(Map map) {
        if (map == null) {
            map = new HashMap();
        }
        this.f29204b = map;
    }

    public C8577b(C8579c cVar) {
        this();
        if (cVar.mo41018c() == '{') {
            while (true) {
                char c = cVar.mo41018c();
                if (c == 0) {
                    throw cVar.mo41015a("A JSONObject text must end with '}'");
                } else if (c != '}') {
                    cVar.mo41016a();
                    String obj = cVar.mo41019d().toString();
                    char c2 = cVar.mo41018c();
                    if (c2 == '=') {
                        if (cVar.mo41017b() != '>') {
                            cVar.mo41016a();
                        }
                    } else if (c2 != ':') {
                        throw cVar.mo41015a("Expected a ':' after a key");
                    }
                    Object d = cVar.mo41019d();
                    if (obj != null) {
                        if (d != null) {
                            m37302b(d);
                            this.f29204b.put(obj, d);
                        } else {
                            this.f29204b.remove(obj);
                        }
                        char c3 = cVar.mo41018c();
                        if (c3 == ',' || c3 == ';') {
                            if (cVar.mo41018c() != '}') {
                                cVar.mo41016a();
                            } else {
                                return;
                            }
                        } else if (c3 != '}') {
                            throw cVar.mo41015a("Expected a ',' or '}'");
                        } else {
                            return;
                        }
                    } else {
                        throw new JSONException("Null key.");
                    }
                } else {
                    return;
                }
            }
        } else {
            throw cVar.mo41015a("A JSONObject text must begin with '{'");
        }
    }

    /* renamed from: a */
    static String m37301a(Object obj) {
        if (obj == null || obj.equals(null)) {
            return "null";
        }
        if (!(obj instanceof Number)) {
            return ((obj instanceof Boolean) || (obj instanceof C8577b) || (obj instanceof C8576a)) ? obj.toString() : obj instanceof Map ? new C8577b((Map) obj).toString() : obj instanceof Collection ? new C8576a((Collection) obj).toString() : obj.getClass().isArray() ? new C8576a(obj).toString() : m37303c(obj.toString());
        }
        Number number = (Number) obj;
        if (number != null) {
            m37302b((Object) number);
            String obj2 = number.toString();
            if (obj2.indexOf(46) > 0 && obj2.indexOf(101) < 0 && obj2.indexOf(69) < 0) {
                while (obj2.endsWith("0")) {
                    obj2 = obj2.substring(0, obj2.length() - 1);
                }
                if (obj2.endsWith(".")) {
                    obj2 = obj2.substring(0, obj2.length() - 1);
                }
            }
            return obj2;
        }
        throw new JSONException("Null pointer");
    }

    /* renamed from: b */
    private static void m37302b(Object obj) {
        if (obj != null) {
            String str = "JSON does not allow non-finite numbers.";
            if (obj instanceof Double) {
                Double d = (Double) obj;
                if (d.isInfinite() || d.isNaN()) {
                    throw new JSONException(str);
                }
            } else if (obj instanceof Float) {
                Float f = (Float) obj;
                if (f.isInfinite() || f.isNaN()) {
                    throw new JSONException(str);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0084, code lost:
            if (r4 == '<') goto L_0x0086;
     */
    /* renamed from: c */
    public static java.lang.String m37303c(java.lang.String r8) {
        /*
        if (r8 == 0) goto L_0x009f
        int r0 = r8.length()
        if (r0 != 0) goto L_0x000a
        goto L_0x009f
    L_0x000a:
        int r0 = r8.length()
        java.lang.StringBuffer r1 = new java.lang.StringBuffer
        int r2 = r0 + 4
        r1.<init>(r2)
        r2 = 34
        r1.append(r2)
        r3 = 0
        r4 = 0
    L_0x001c:
        if (r3 >= r0) goto L_0x0097
        char r5 = r8.charAt(r3)
        r6 = 12
        if (r5 == r6) goto L_0x0090
        r6 = 13
        if (r5 == r6) goto L_0x008d
        r6 = 92
        if (r5 == r2) goto L_0x0086
        r7 = 47
        if (r5 == r7) goto L_0x0082
        if (r5 == r6) goto L_0x0086
        switch(r5) {
            case 8: goto L_0x007c;
            case 9: goto L_0x0079;
            case 10: goto L_0x0076;
            default: goto L_0x0037;
        }
    L_0x0037:
        r4 = 32
        if (r5 < r4) goto L_0x004b
        r4 = 128(0x80, float:1.794E-43)
        if (r5 < r4) goto L_0x0043
        r4 = 160(0xa0, float:2.24E-43)
        if (r5 < r4) goto L_0x004b
    L_0x0043:
        r4 = 8192(0x2000, float:1.14794E-41)
        if (r5 < r4) goto L_0x0089
        r4 = 8448(0x2100, float:1.1838E-41)
        if (r5 >= r4) goto L_0x0089
    L_0x004b:
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        java.lang.String r6 = "000"
        r4.<init>(r6)
        java.lang.String r6 = java.lang.Integer.toHexString(r5)
        r4.append(r6)
        java.lang.String r4 = r4.toString()
        java.lang.StringBuilder r6 = new java.lang.StringBuilder
        java.lang.String r7 = "\\u"
        r6.<init>(r7)
        int r7 = r4.length()
        int r7 = r7 + -4
        java.lang.String r4 = r4.substring(r7)
        r6.append(r4)
        java.lang.String r4 = r6.toString()
        goto L_0x007e
    L_0x0076:
        java.lang.String r4 = "\\n"
        goto L_0x007e
    L_0x0079:
        java.lang.String r4 = "\\t"
        goto L_0x007e
    L_0x007c:
        java.lang.String r4 = "\\b"
    L_0x007e:
        r1.append(r4)
        goto L_0x0093
    L_0x0082:
        r7 = 60
        if (r4 != r7) goto L_0x0089
    L_0x0086:
        r1.append(r6)
    L_0x0089:
        r1.append(r5)
        goto L_0x0093
    L_0x008d:
        java.lang.String r4 = "\\r"
        goto L_0x007e
    L_0x0090:
        java.lang.String r4 = "\\f"
        goto L_0x007e
    L_0x0093:
        int r3 = r3 + 1
        r4 = r5
        goto L_0x001c
    L_0x0097:
        r1.append(r2)
        java.lang.String r8 = r1.toString()
        return r8
    L_0x009f:
        java.lang.String r8 = "\"\""
        return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.alipay.C8577b.m37303c(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public final Object mo41008a(String str) {
        Object obj = str == null ? null : this.f29204b.get(str);
        if (obj != null) {
            return obj;
        }
        StringBuilder sb = new StringBuilder("JSONObject[");
        sb.append(m37303c(str));
        sb.append("] not found.");
        throw new JSONException(sb.toString());
    }

    /* renamed from: a */
    public final Iterator mo41009a() {
        return this.f29204b.keySet().iterator();
    }

    /* renamed from: b */
    public final boolean mo41010b(String str) {
        return this.f29204b.containsKey(str);
    }

    public String toString() {
        try {
            Iterator a = mo41009a();
            StringBuffer stringBuffer = new StringBuffer("{");
            while (a.hasNext()) {
                if (stringBuffer.length() > 1) {
                    stringBuffer.append(',');
                }
                Object next = a.next();
                stringBuffer.append(m37303c(next.toString()));
                stringBuffer.append(':');
                stringBuffer.append(m37301a(this.f29204b.get(next)));
            }
            stringBuffer.append('}');
            return stringBuffer.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
