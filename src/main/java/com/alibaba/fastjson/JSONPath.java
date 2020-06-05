package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.FieldSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import com.tencent.mid.sotrage.StorageInterface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;
import org.slf4j.Marker;

/* renamed from: com.alibaba.fastjson.d */
public class JSONPath implements JSONAware {
    /* renamed from: a */
    private static ConcurrentMap<String, JSONPath> f2602a = new ConcurrentHashMap(128, 0.75f, 1);
    /* renamed from: b */
    private final String f2603b;
    /* renamed from: c */
    private C1254s[] f2604c;
    /* renamed from: d */
    private SerializeConfig f2605d;
    /* renamed from: e */
    private ParserConfig f2606e;

    /* compiled from: JSONPath */
    /* renamed from: com.alibaba.fastjson.d$a */
    static class C1236a implements C1254s {
        /* renamed from: a */
        private final int f2607a;

        public C1236a(int i) {
            this.f2607a = i;
        }

        /* renamed from: a */
        public Object mo11091a(JSONPath dVar, Object obj, Object obj2) {
            return dVar.mo11084a(obj2, this.f2607a);
        }
    }

    /* compiled from: JSONPath */
    /* renamed from: com.alibaba.fastjson.d$b */
    static class C1237b implements C1238c {
        /* renamed from: a */
        private final String f2608a;
        /* renamed from: b */
        private final double f2609b;
        /* renamed from: c */
        private final C1250o f2610c;
        /* renamed from: d */
        private final long f2611d;

        public C1237b(String str, double d, C1250o oVar) {
            this.f2608a = str;
            this.f2609b = d;
            this.f2610c = oVar;
            this.f2611d = TypeUtils.m3265g(str);
        }

        /* renamed from: a */
        public boolean mo11092a(JSONPath dVar, Object obj, Object obj2, Object obj3) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            Object a = dVar.mo11085a(obj3, this.f2608a, this.f2611d);
            boolean z5 = false;
            if (a == null || !(a instanceof Number)) {
                return false;
            }
            double doubleValue = ((Number) a).doubleValue();
            if (this.f2610c == C1250o.EQ) {
                if (doubleValue == this.f2609b) {
                    z5 = true;
                }
                return z5;
            } else if (this.f2610c == C1250o.NE) {
                if (doubleValue != this.f2609b) {
                    z5 = true;
                }
                return z5;
            } else if (this.f2610c == C1250o.GE) {
                if (doubleValue >= this.f2609b) {
                    z4 = true;
                }
                return z4;
            } else if (this.f2610c == C1250o.GT) {
                if (doubleValue > this.f2609b) {
                    z3 = true;
                }
                return z3;
            } else if (this.f2610c == C1250o.LE) {
                if (doubleValue <= this.f2609b) {
                    z2 = true;
                }
                return z2;
            } else {
                if (this.f2610c == C1250o.LT && doubleValue < this.f2609b) {
                    z = true;
                }
                return z;
            }
        }
    }

    /* compiled from: JSONPath */
    /* renamed from: com.alibaba.fastjson.d$c */
    interface C1238c {
        /* renamed from: a */
        boolean mo11092a(JSONPath dVar, Object obj, Object obj2, Object obj3);
    }

    /* compiled from: JSONPath */
    /* renamed from: com.alibaba.fastjson.d$d */
    public static class C1239d implements C1254s {
        /* renamed from: a */
        private final C1238c f2612a;

        public C1239d(C1238c cVar) {
            this.f2612a = cVar;
        }

        /* renamed from: a */
        public Object mo11091a(JSONPath dVar, Object obj, Object obj2) {
            if (obj2 == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            if (obj2 instanceof Iterable) {
                for (Object next : (Iterable) obj2) {
                    if (this.f2612a.mo11092a(dVar, obj, obj2, next)) {
                        jSONArray.add(next);
                    }
                }
                return jSONArray;
            } else if (this.f2612a.mo11092a(dVar, obj, obj2, obj2)) {
                return obj2;
            } else {
                return null;
            }
        }
    }

    /* compiled from: JSONPath */
    /* renamed from: com.alibaba.fastjson.d$e */
    static class C1240e implements C1238c {
        /* renamed from: a */
        private final String f2613a;
        /* renamed from: b */
        private final long f2614b;
        /* renamed from: c */
        private final long f2615c;
        /* renamed from: d */
        private final long f2616d;
        /* renamed from: e */
        private final boolean f2617e;

        public C1240e(String str, long j, long j2, boolean z) {
            this.f2613a = str;
            this.f2614b = TypeUtils.m3265g(str);
            this.f2615c = j;
            this.f2616d = j2;
            this.f2617e = z;
        }

        /* renamed from: a */
        public boolean mo11092a(JSONPath dVar, Object obj, Object obj2, Object obj3) {
            Object a = dVar.mo11085a(obj3, this.f2613a, this.f2614b);
            if (a == null) {
                return false;
            }
            if (a instanceof Number) {
                long longValue = ((Number) a).longValue();
                if (longValue >= this.f2615c && longValue <= this.f2616d) {
                    return !this.f2617e;
                }
            }
            return this.f2617e;
        }
    }

    /* compiled from: JSONPath */
    /* renamed from: com.alibaba.fastjson.d$f */
    static class C1241f implements C1238c {
        /* renamed from: a */
        private final String f2618a;
        /* renamed from: b */
        private final long f2619b;
        /* renamed from: c */
        private final long[] f2620c;
        /* renamed from: d */
        private final boolean f2621d;

        public C1241f(String str, long[] jArr, boolean z) {
            this.f2618a = str;
            this.f2619b = TypeUtils.m3265g(str);
            this.f2620c = jArr;
            this.f2621d = z;
        }

        /* renamed from: a */
        public boolean mo11092a(JSONPath dVar, Object obj, Object obj2, Object obj3) {
            Object a = dVar.mo11085a(obj3, this.f2618a, this.f2619b);
            if (a == null) {
                return false;
            }
            if (a instanceof Number) {
                long longValue = ((Number) a).longValue();
                long[] jArr = this.f2620c;
                int length = jArr.length;
                for (int i = 0; i < length; i++) {
                    if (jArr[i] == longValue) {
                        return !this.f2621d;
                    }
                }
            }
            return this.f2621d;
        }
    }

    /* compiled from: JSONPath */
    /* renamed from: com.alibaba.fastjson.d$g */
    static class C1242g implements C1238c {
        /* renamed from: a */
        private final String f2622a;
        /* renamed from: b */
        private final long f2623b;
        /* renamed from: c */
        private final Long[] f2624c;
        /* renamed from: d */
        private final boolean f2625d;

        public C1242g(String str, Long[] lArr, boolean z) {
            this.f2622a = str;
            this.f2623b = TypeUtils.m3265g(str);
            this.f2624c = lArr;
            this.f2625d = z;
        }

        /* renamed from: a */
        public boolean mo11092a(JSONPath dVar, Object obj, Object obj2, Object obj3) {
            Object a = dVar.mo11085a(obj3, this.f2622a, this.f2623b);
            int i = 0;
            if (a == null) {
                Long[] lArr = this.f2624c;
                int length = lArr.length;
                while (i < length) {
                    if (lArr[i] == null) {
                        return !this.f2625d;
                    }
                    i++;
                }
                return this.f2625d;
            }
            if (a instanceof Number) {
                long longValue = ((Number) a).longValue();
                Long[] lArr2 = this.f2624c;
                int length2 = lArr2.length;
                while (i < length2) {
                    Long l = lArr2[i];
                    if (l != null && l.longValue() == longValue) {
                        return !this.f2625d;
                    }
                    i++;
                }
            }
            return this.f2625d;
        }
    }

    /* compiled from: JSONPath */
    /* renamed from: com.alibaba.fastjson.d$h */
    static class C1243h implements C1238c {
        /* renamed from: a */
        private final String f2626a;
        /* renamed from: b */
        private final long f2627b;
        /* renamed from: c */
        private final long f2628c;
        /* renamed from: d */
        private final C1250o f2629d;

        public C1243h(String str, long j, C1250o oVar) {
            this.f2626a = str;
            this.f2627b = TypeUtils.m3265g(str);
            this.f2628c = j;
            this.f2629d = oVar;
        }

        /* renamed from: a */
        public boolean mo11092a(JSONPath dVar, Object obj, Object obj2, Object obj3) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            Object a = dVar.mo11085a(obj3, this.f2626a, this.f2627b);
            boolean z5 = false;
            if (a == null || !(a instanceof Number)) {
                return false;
            }
            long longValue = ((Number) a).longValue();
            if (this.f2629d == C1250o.EQ) {
                if (longValue == this.f2628c) {
                    z5 = true;
                }
                return z5;
            } else if (this.f2629d == C1250o.NE) {
                if (longValue != this.f2628c) {
                    z5 = true;
                }
                return z5;
            } else if (this.f2629d == C1250o.GE) {
                if (longValue >= this.f2628c) {
                    z4 = true;
                }
                return z4;
            } else if (this.f2629d == C1250o.GT) {
                if (longValue > this.f2628c) {
                    z3 = true;
                }
                return z3;
            } else if (this.f2629d == C1250o.LE) {
                if (longValue <= this.f2628c) {
                    z2 = true;
                }
                return z2;
            } else {
                if (this.f2629d == C1250o.LT && longValue < this.f2628c) {
                    z = true;
                }
                return z;
            }
        }
    }

    /* compiled from: JSONPath */
    /* renamed from: com.alibaba.fastjson.d$i */
    static class C1244i {
        /* renamed from: a */
        private final String f2630a;
        /* renamed from: b */
        private int f2631b;
        /* renamed from: c */
        private char f2632c;
        /* renamed from: d */
        private int f2633d;

        /* renamed from: a */
        static boolean m2540a(char c) {
            return c == '-' || c == '+' || (c >= '0' && c <= '9');
        }

        public C1244i(String str) {
            this.f2630a = str;
            mo11096a();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo11096a() {
            String str = this.f2630a;
            int i = this.f2631b;
            this.f2631b = i + 1;
            this.f2632c = str.charAt(i);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public boolean mo11098b() {
            return this.f2631b >= this.f2630a.length();
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
            if (r0 <= 'Z') goto L_0x0034;
     */
        /* renamed from: c */
        public com.alibaba.fastjson.JSONPath.C1254s mo11099c() {
            /*
            r9 = this;
            int r0 = r9.f2633d
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0040
            java.lang.String r0 = r9.f2630a
            int r0 = r0.length()
            if (r0 != r2) goto L_0x0040
            char r0 = r9.f2632c
            boolean r0 = m2540a(r0)
            if (r0 == 0) goto L_0x0020
            char r0 = r9.f2632c
            int r0 = r0 + -48
            com.alibaba.fastjson.d$a r1 = new com.alibaba.fastjson.d$a
            r1.m41562init(r0)
            return r1
        L_0x0020:
            char r0 = r9.f2632c
            r3 = 97
            if (r0 < r3) goto L_0x002a
            r3 = 122(0x7a, float:1.71E-43)
            if (r0 <= r3) goto L_0x0034
        L_0x002a:
            char r0 = r9.f2632c
            r3 = 65
            if (r0 < r3) goto L_0x0040
            r3 = 90
            if (r0 > r3) goto L_0x0040
        L_0x0034:
            com.alibaba.fastjson.d$p r0 = new com.alibaba.fastjson.d$p
            char r2 = r9.f2632c
            java.lang.String r2 = java.lang.Character.toString(r2)
            r0.m41577init(r2, r1)
            return r0
        L_0x0040:
            boolean r0 = r9.mo11098b()
            if (r0 != 0) goto L_0x0151
            r9.mo11100d()
            char r0 = r9.f2632c
            r3 = 36
            if (r0 != r3) goto L_0x0053
            r9.mo11096a()
            goto L_0x0040
        L_0x0053:
            r3 = 91
            java.lang.String r4 = "not support jsonpath : "
            r5 = 46
            if (r0 == r5) goto L_0x008c
            r6 = 47
            if (r0 != r6) goto L_0x0060
            goto L_0x008c
        L_0x0060:
            if (r0 != r3) goto L_0x0067
            com.alibaba.fastjson.d$s r0 = r9.mo11095a(r2)
            return r0
        L_0x0067:
            int r0 = r9.f2633d
            if (r0 != 0) goto L_0x0075
            java.lang.String r0 = r9.mo11104h()
            com.alibaba.fastjson.d$p r2 = new com.alibaba.fastjson.d$p
            r2.m41577init(r0, r1)
            return r2
        L_0x0075:
            com.alibaba.fastjson.JSONPathException r0 = new com.alibaba.fastjson.JSONPathException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r2 = r9.f2630a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.m41533init(r1)
            throw r0
        L_0x008c:
            char r0 = r9.f2632c
            r9.mo11096a()
            r6 = 42
            if (r0 != r5) goto L_0x00da
            char r0 = r9.f2632c
            if (r0 != r5) goto L_0x00da
            r9.mo11096a()
            java.lang.String r0 = r9.f2630a
            int r0 = r0.length()
            int r7 = r9.f2631b
            int r8 = r7 + 3
            if (r0 <= r8) goto L_0x00db
            char r0 = r9.f2632c
            if (r0 != r3) goto L_0x00db
            java.lang.String r0 = r9.f2630a
            char r0 = r0.charAt(r7)
            if (r0 != r6) goto L_0x00db
            java.lang.String r0 = r9.f2630a
            int r3 = r9.f2631b
            int r3 = r3 + r2
            char r0 = r0.charAt(r3)
            r3 = 93
            if (r0 != r3) goto L_0x00db
            java.lang.String r0 = r9.f2630a
            int r3 = r9.f2631b
            int r3 = r3 + 2
            char r0 = r0.charAt(r3)
            if (r0 != r5) goto L_0x00db
            r9.mo11096a()
            r9.mo11096a()
            r9.mo11096a()
            r9.mo11096a()
            goto L_0x00db
        L_0x00da:
            r2 = 0
        L_0x00db:
            char r0 = r9.f2632c
            if (r0 != r6) goto L_0x00eb
            boolean r0 = r9.mo11098b()
            if (r0 != 0) goto L_0x00e8
            r9.mo11096a()
        L_0x00e8:
            com.alibaba.fastjson.d$x r0 = com.alibaba.fastjson.JSONPath.C1259x.f2679a
            return r0
        L_0x00eb:
            boolean r0 = m2540a(r0)
            if (r0 == 0) goto L_0x00f6
            com.alibaba.fastjson.d$s r0 = r9.mo11095a(r1)
            return r0
        L_0x00f6:
            java.lang.String r0 = r9.mo11104h()
            char r1 = r9.f2632c
            r3 = 40
            if (r1 != r3) goto L_0x014b
            r9.mo11096a()
            char r1 = r9.f2632c
            r2 = 41
            if (r1 != r2) goto L_0x0134
            boolean r1 = r9.mo11098b()
            if (r1 != 0) goto L_0x0112
            r9.mo11096a()
        L_0x0112:
            java.lang.String r1 = "size"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x011d
            com.alibaba.fastjson.d$t r0 = com.alibaba.fastjson.JSONPath.C1255t.f2666a
            return r0
        L_0x011d:
            com.alibaba.fastjson.JSONPathException r0 = new com.alibaba.fastjson.JSONPathException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r2 = r9.f2630a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.m41533init(r1)
            throw r0
        L_0x0134:
            com.alibaba.fastjson.JSONPathException r0 = new com.alibaba.fastjson.JSONPathException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r2 = r9.f2630a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.m41533init(r1)
            throw r0
        L_0x014b:
            com.alibaba.fastjson.d$p r1 = new com.alibaba.fastjson.d$p
            r1.m41577init(r0, r2)
            return r1
        L_0x0151:
            r0 = 0
            return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONPath.C1244i.mo11099c():com.alibaba.fastjson.d$s");
        }

        /* renamed from: d */
        public final void mo11100d() {
            while (true) {
                char c = this.f2632c;
                if (c > ' ') {
                    return;
                }
                if (c == ' ' || c == 13 || c == 10 || c == 9 || c == 12 || c == 8) {
                    mo11096a();
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0064  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x007f  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x008b  */
        /* renamed from: a */
        public com.alibaba.fastjson.JSONPath.C1254s mo11095a(boolean r15) {
            /*
            r14 = this;
            if (r15 == 0) goto L_0x0007
            r0 = 91
            r14.mo11097b(r0)
        L_0x0007:
            char r0 = r14.f2632c
            r1 = 63
            r2 = 40
            r3 = 46
            r4 = 0
            r5 = 1
            if (r0 != r1) goto L_0x0027
            r14.mo11096a()
            r14.mo11097b(r2)
            char r0 = r14.f2632c
            r1 = 64
            if (r0 != r1) goto L_0x0025
            r14.mo11096a()
            r14.mo11097b(r3)
        L_0x0025:
            r0 = 1
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            r1 = -1
            r6 = 93
            if (r0 != 0) goto L_0x009b
            char r7 = r14.f2632c
            boolean r7 = com.alibaba.fastjson.util.IOUtils.m3196a(r7)
            if (r7 == 0) goto L_0x0037
            goto L_0x009b
        L_0x0037:
            int r2 = r14.f2631b
            int r2 = r2 - r5
        L_0x003a:
            char r7 = r14.f2632c
            r8 = 47
            if (r7 == r6) goto L_0x005e
            if (r7 == r8) goto L_0x005e
            boolean r7 = r14.mo11098b()
            if (r7 != 0) goto L_0x005e
            char r7 = r14.f2632c
            if (r7 != r3) goto L_0x0051
            if (r0 != 0) goto L_0x0051
            if (r0 != 0) goto L_0x0051
            goto L_0x005e
        L_0x0051:
            char r7 = r14.f2632c
            r8 = 92
            if (r7 != r8) goto L_0x005a
            r14.mo11096a()
        L_0x005a:
            r14.mo11096a()
            goto L_0x003a
        L_0x005e:
            if (r15 == 0) goto L_0x0064
            int r0 = r14.f2631b
        L_0x0062:
            int r0 = r0 - r5
            goto L_0x0071
        L_0x0064:
            char r0 = r14.f2632c
            if (r0 == r8) goto L_0x006e
            if (r0 != r3) goto L_0x006b
            goto L_0x006e
        L_0x006b:
            int r0 = r14.f2631b
            goto L_0x0071
        L_0x006e:
            int r0 = r14.f2631b
            goto L_0x0062
        L_0x0071:
            java.lang.String r3 = r14.f2630a
            java.lang.String r0 = r3.substring(r2, r0)
            java.lang.String r2 = "\\."
            int r3 = r0.indexOf(r2)
            if (r3 == r1) goto L_0x008b
            java.lang.String r15 = "\\\\\\."
            java.lang.String r15 = r0.replaceAll(r15, r2)
            com.alibaba.fastjson.d$p r0 = new com.alibaba.fastjson.d$p
            r0.m41577init(r15, r4)
            return r0
        L_0x008b:
            com.alibaba.fastjson.d$s r0 = r14.mo11094a(r0)
            if (r15 == 0) goto L_0x009a
            boolean r15 = r14.mo11098b()
            if (r15 != 0) goto L_0x009a
            r14.mo11097b(r6)
        L_0x009a:
            return r0
        L_0x009b:
            java.lang.String r8 = r14.mo11104h()
            r14.mo11100d()
            r7 = 41
            if (r0 == 0) goto L_0x00bd
            char r9 = r14.f2632c
            if (r9 != r7) goto L_0x00bd
            r14.mo11096a()
            if (r15 == 0) goto L_0x00b2
            r14.mo11097b(r6)
        L_0x00b2:
            com.alibaba.fastjson.d$d r15 = new com.alibaba.fastjson.d$d
            com.alibaba.fastjson.d$m r0 = new com.alibaba.fastjson.d$m
            r0.m41573init(r8)
            r15.m41564init(r0)
            return r15
        L_0x00bd:
            if (r15 == 0) goto L_0x00d1
            char r9 = r14.f2632c
            if (r9 != r6) goto L_0x00d1
            r14.mo11096a()
            com.alibaba.fastjson.d$d r15 = new com.alibaba.fastjson.d$d
            com.alibaba.fastjson.d$m r0 = new com.alibaba.fastjson.d$m
            r0.m41573init(r8)
            r15.m41564init(r0)
            return r15
        L_0x00d1:
            com.alibaba.fastjson.d$o r9 = r14.mo11103g()
            r14.mo11100d()
            com.alibaba.fastjson.d$o r10 = com.alibaba.fastjson.JSONPath.C1250o.BETWEEN
            if (r9 == r10) goto L_0x040f
            com.alibaba.fastjson.d$o r10 = com.alibaba.fastjson.JSONPath.C1250o.NOT_BETWEEN
            if (r9 != r10) goto L_0x00e2
            goto L_0x040f
        L_0x00e2:
            com.alibaba.fastjson.d$o r10 = com.alibaba.fastjson.JSONPath.C1250o.IN
            if (r9 == r10) goto L_0x02d0
            com.alibaba.fastjson.d$o r10 = com.alibaba.fastjson.JSONPath.C1250o.NOT_IN
            if (r9 != r10) goto L_0x00ec
            goto L_0x02d0
        L_0x00ec:
            char r2 = r14.f2632c
            r10 = 39
            if (r2 == r10) goto L_0x01f6
            r10 = 34
            if (r2 != r10) goto L_0x00f8
            goto L_0x01f6
        L_0x00f8:
            boolean r1 = m2540a(r2)
            if (r1 == 0) goto L_0x0132
            long r1 = r14.mo11101e()
            char r4 = r14.f2632c
            r10 = 0
            if (r4 != r3) goto L_0x010d
            double r3 = r14.mo11093a(r1)
            goto L_0x010e
        L_0x010d:
            r3 = r10
        L_0x010e:
            if (r0 == 0) goto L_0x0113
            r14.mo11097b(r7)
        L_0x0113:
            if (r15 == 0) goto L_0x0118
            r14.mo11097b(r6)
        L_0x0118:
            int r15 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r15 != 0) goto L_0x0127
            com.alibaba.fastjson.d$d r15 = new com.alibaba.fastjson.d$d
            com.alibaba.fastjson.d$h r0 = new com.alibaba.fastjson.d$h
            r0.m41568init(r8, r1, r9)
            r15.m41564init(r0)
            return r15
        L_0x0127:
            com.alibaba.fastjson.d$d r15 = new com.alibaba.fastjson.d$d
            com.alibaba.fastjson.d$b r0 = new com.alibaba.fastjson.d$b
            r0.m41563init(r8, r3, r9)
            r15.m41564init(r0)
            return r15
        L_0x0132:
            char r15 = r14.f2632c
            r1 = 110(0x6e, float:1.54E-43)
            if (r15 != r1) goto L_0x0170
            java.lang.String r15 = r14.mo11104h()
            java.lang.String r1 = "null"
            boolean r15 = r1.equals(r15)
            if (r15 == 0) goto L_0x01f0
            if (r0 == 0) goto L_0x0149
            r14.mo11097b(r7)
        L_0x0149:
            r14.mo11097b(r6)
            com.alibaba.fastjson.d$o r15 = com.alibaba.fastjson.JSONPath.C1250o.EQ
            if (r9 != r15) goto L_0x015b
            com.alibaba.fastjson.d$d r15 = new com.alibaba.fastjson.d$d
            com.alibaba.fastjson.d$n r0 = new com.alibaba.fastjson.d$n
            r0.m41574init(r8)
            r15.m41564init(r0)
            return r15
        L_0x015b:
            com.alibaba.fastjson.d$o r15 = com.alibaba.fastjson.JSONPath.C1250o.NE
            if (r9 != r15) goto L_0x016a
            com.alibaba.fastjson.d$d r15 = new com.alibaba.fastjson.d$d
            com.alibaba.fastjson.d$m r0 = new com.alibaba.fastjson.d$m
            r0.m41573init(r8)
            r15.m41564init(r0)
            return r15
        L_0x016a:
            java.lang.UnsupportedOperationException r15 = new java.lang.UnsupportedOperationException
            r15.<init>()
            throw r15
        L_0x0170:
            r1 = 116(0x74, float:1.63E-43)
            if (r15 != r1) goto L_0x01b0
            java.lang.String r15 = r14.mo11104h()
            java.lang.String r1 = "true"
            boolean r15 = r1.equals(r15)
            if (r15 == 0) goto L_0x01f0
            if (r0 == 0) goto L_0x0185
            r14.mo11097b(r7)
        L_0x0185:
            r14.mo11097b(r6)
            com.alibaba.fastjson.d$o r15 = com.alibaba.fastjson.JSONPath.C1250o.EQ
            if (r9 != r15) goto L_0x0199
            com.alibaba.fastjson.d$d r15 = new com.alibaba.fastjson.d$d
            com.alibaba.fastjson.d$w r0 = new com.alibaba.fastjson.d$w
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r0.m41584init(r8, r1, r5)
            r15.m41564init(r0)
            return r15
        L_0x0199:
            com.alibaba.fastjson.d$o r15 = com.alibaba.fastjson.JSONPath.C1250o.NE
            if (r9 != r15) goto L_0x01aa
            com.alibaba.fastjson.d$d r15 = new com.alibaba.fastjson.d$d
            com.alibaba.fastjson.d$w r0 = new com.alibaba.fastjson.d$w
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r0.m41584init(r8, r1, r4)
            r15.m41564init(r0)
            return r15
        L_0x01aa:
            java.lang.UnsupportedOperationException r15 = new java.lang.UnsupportedOperationException
            r15.<init>()
            throw r15
        L_0x01b0:
            r1 = 102(0x66, float:1.43E-43)
            if (r15 != r1) goto L_0x01f0
            java.lang.String r15 = r14.mo11104h()
            java.lang.String r1 = "false"
            boolean r15 = r1.equals(r15)
            if (r15 == 0) goto L_0x01f0
            if (r0 == 0) goto L_0x01c5
            r14.mo11097b(r7)
        L_0x01c5:
            r14.mo11097b(r6)
            com.alibaba.fastjson.d$o r15 = com.alibaba.fastjson.JSONPath.C1250o.EQ
            if (r9 != r15) goto L_0x01d9
            com.alibaba.fastjson.d$d r15 = new com.alibaba.fastjson.d$d
            com.alibaba.fastjson.d$w r0 = new com.alibaba.fastjson.d$w
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r0.m41584init(r8, r1, r5)
            r15.m41564init(r0)
            return r15
        L_0x01d9:
            com.alibaba.fastjson.d$o r15 = com.alibaba.fastjson.JSONPath.C1250o.NE
            if (r9 != r15) goto L_0x01ea
            com.alibaba.fastjson.d$d r15 = new com.alibaba.fastjson.d$d
            com.alibaba.fastjson.d$w r0 = new com.alibaba.fastjson.d$w
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r0.m41584init(r8, r1, r4)
            r15.m41564init(r0)
            return r15
        L_0x01ea:
            java.lang.UnsupportedOperationException r15 = new java.lang.UnsupportedOperationException
            r15.<init>()
            throw r15
        L_0x01f0:
            java.lang.UnsupportedOperationException r15 = new java.lang.UnsupportedOperationException
            r15.<init>()
            throw r15
        L_0x01f6:
            java.lang.String r2 = r14.mo11105i()
            if (r0 == 0) goto L_0x01ff
            r14.mo11097b(r7)
        L_0x01ff:
            if (r15 == 0) goto L_0x0204
            r14.mo11097b(r6)
        L_0x0204:
            com.alibaba.fastjson.d$o r15 = com.alibaba.fastjson.JSONPath.C1250o.RLIKE
            if (r9 != r15) goto L_0x0213
            com.alibaba.fastjson.d$d r15 = new com.alibaba.fastjson.d$d
            com.alibaba.fastjson.d$r r0 = new com.alibaba.fastjson.d$r
            r0.m41579init(r8, r2, r4)
            r15.m41564init(r0)
            return r15
        L_0x0213:
            com.alibaba.fastjson.d$o r15 = com.alibaba.fastjson.JSONPath.C1250o.NOT_RLIKE
            if (r9 != r15) goto L_0x0222
            com.alibaba.fastjson.d$d r15 = new com.alibaba.fastjson.d$d
            com.alibaba.fastjson.d$r r0 = new com.alibaba.fastjson.d$r
            r0.m41579init(r8, r2, r5)
            r15.m41564init(r0)
            return r15
        L_0x0222:
            com.alibaba.fastjson.d$o r15 = com.alibaba.fastjson.JSONPath.C1250o.LIKE
            if (r9 == r15) goto L_0x022a
            com.alibaba.fastjson.d$o r15 = com.alibaba.fastjson.JSONPath.C1250o.NOT_LIKE
            if (r9 != r15) goto L_0x0251
        L_0x022a:
            java.lang.String r15 = "%%"
            int r0 = r2.indexOf(r15)
            java.lang.String r3 = "%"
            if (r0 == r1) goto L_0x0239
            java.lang.String r2 = r2.replaceAll(r15, r3)
            goto L_0x022a
        L_0x0239:
            com.alibaba.fastjson.d$o r15 = com.alibaba.fastjson.JSONPath.C1250o.NOT_LIKE
            if (r9 != r15) goto L_0x023f
            r12 = 1
            goto L_0x0240
        L_0x023f:
            r12 = 0
        L_0x0240:
            r15 = 37
            int r0 = r2.indexOf(r15)
            if (r0 != r1) goto L_0x025c
            com.alibaba.fastjson.d$o r15 = com.alibaba.fastjson.JSONPath.C1250o.LIKE
            if (r9 != r15) goto L_0x024f
            com.alibaba.fastjson.d$o r9 = com.alibaba.fastjson.JSONPath.C1250o.EQ
            goto L_0x0251
        L_0x024f:
            com.alibaba.fastjson.d$o r9 = com.alibaba.fastjson.JSONPath.C1250o.NE
        L_0x0251:
            com.alibaba.fastjson.d$d r15 = new com.alibaba.fastjson.d$d
            com.alibaba.fastjson.d$v r0 = new com.alibaba.fastjson.d$v
            r0.m41583init(r8, r2, r9)
            r15.m41564init(r0)
            return r15
        L_0x025c:
            java.lang.String[] r1 = r2.split(r3)
            r3 = 0
            r6 = 2
            if (r0 != 0) goto L_0x0290
            int r0 = r2.length()
            int r0 = r0 - r5
            char r0 = r2.charAt(r0)
            if (r0 != r15) goto L_0x0279
            int r15 = r1.length
            int r15 = r15 - r5
            java.lang.String[] r15 = new java.lang.String[r15]
            int r0 = r15.length
            java.lang.System.arraycopy(r1, r5, r15, r4, r0)
            r11 = r15
            goto L_0x029c
        L_0x0279:
            int r15 = r1.length
            int r15 = r15 - r5
            r15 = r1[r15]
            int r0 = r1.length
            if (r0 <= r6) goto L_0x028c
            int r0 = r1.length
            int r0 = r0 - r6
            java.lang.String[] r0 = new java.lang.String[r0]
            int r2 = r0.length
            java.lang.System.arraycopy(r1, r5, r0, r4, r2)
            r10 = r15
            r11 = r0
            r9 = r3
            goto L_0x02c4
        L_0x028c:
            r10 = r15
            r9 = r3
            r11 = r9
            goto L_0x02c4
        L_0x0290:
            int r0 = r2.length()
            int r0 = r0 - r5
            char r0 = r2.charAt(r0)
            if (r0 != r15) goto L_0x029f
            r11 = r1
        L_0x029c:
            r9 = r3
            r10 = r9
            goto L_0x02c4
        L_0x029f:
            int r15 = r1.length
            if (r15 != r5) goto L_0x02a8
            r15 = r1[r4]
            r9 = r15
            r10 = r3
            r11 = r10
            goto L_0x02c4
        L_0x02a8:
            int r15 = r1.length
            if (r15 != r6) goto L_0x02b3
            r15 = r1[r4]
            r0 = r1[r5]
            r9 = r15
            r10 = r0
            r11 = r3
            goto L_0x02c4
        L_0x02b3:
            r15 = r1[r4]
            int r0 = r1.length
            int r0 = r0 - r5
            r0 = r1[r0]
            int r2 = r1.length
            int r2 = r2 - r6
            java.lang.String[] r2 = new java.lang.String[r2]
            int r3 = r2.length
            java.lang.System.arraycopy(r1, r5, r2, r4, r3)
            r9 = r15
            r10 = r0
            r11 = r2
        L_0x02c4:
            com.alibaba.fastjson.d$d r15 = new com.alibaba.fastjson.d$d
            com.alibaba.fastjson.d$j r0 = new com.alibaba.fastjson.d$j
            r7 = r0
            r7.m41570init(r8, r9, r10, r11, r12)
            r15.m41564init(r0)
            return r15
        L_0x02d0:
            com.alibaba.fastjson.d$o r1 = com.alibaba.fastjson.JSONPath.C1250o.NOT_IN
            if (r9 != r1) goto L_0x02d6
            r1 = 1
            goto L_0x02d7
        L_0x02d6:
            r1 = 0
        L_0x02d7:
            r14.mo11097b(r2)
            com.alibaba.fastjson.JSONArray r2 = new com.alibaba.fastjson.JSONArray
            r2.m41522init()
            java.lang.Object r3 = r14.mo11102f()
            r2.add(r3)
        L_0x02e6:
            r14.mo11100d()
            char r3 = r14.f2632c
            r9 = 44
            if (r3 == r9) goto L_0x0403
            r14.mo11097b(r7)
            if (r0 == 0) goto L_0x02f7
            r14.mo11097b(r7)
        L_0x02f7:
            if (r15 == 0) goto L_0x02fc
            r14.mo11097b(r6)
        L_0x02fc:
            java.util.Iterator r15 = r2.iterator()
            r0 = 1
            r3 = 1
            r6 = 1
        L_0x0303:
            boolean r7 = r15.hasNext()
            if (r7 == 0) goto L_0x0333
            java.lang.Object r7 = r15.next()
            if (r7 != 0) goto L_0x0313
            if (r0 == 0) goto L_0x0303
            r0 = 0
            goto L_0x0303
        L_0x0313:
            java.lang.Class r7 = r7.getClass()
            if (r0 == 0) goto L_0x032b
            java.lang.Class<java.lang.Byte> r9 = java.lang.Byte.class
            if (r7 == r9) goto L_0x032b
            java.lang.Class<java.lang.Short> r9 = java.lang.Short.class
            if (r7 == r9) goto L_0x032b
            java.lang.Class<java.lang.Integer> r9 = java.lang.Integer.class
            if (r7 == r9) goto L_0x032b
            java.lang.Class<java.lang.Long> r9 = java.lang.Long.class
            if (r7 == r9) goto L_0x032b
            r0 = 0
            r6 = 0
        L_0x032b:
            if (r3 == 0) goto L_0x0303
            java.lang.Class<java.lang.String> r9 = java.lang.String.class
            if (r7 == r9) goto L_0x0303
            r3 = 0
            goto L_0x0303
        L_0x0333:
            int r15 = r2.size()
            if (r15 != r5) goto L_0x0357
            java.lang.Object r15 = r2.get(r4)
            if (r15 != 0) goto L_0x0357
            if (r1 == 0) goto L_0x034c
            com.alibaba.fastjson.d$d r15 = new com.alibaba.fastjson.d$d
            com.alibaba.fastjson.d$m r0 = new com.alibaba.fastjson.d$m
            r0.m41573init(r8)
            r15.m41564init(r0)
            return r15
        L_0x034c:
            com.alibaba.fastjson.d$d r15 = new com.alibaba.fastjson.d$d
            com.alibaba.fastjson.d$n r0 = new com.alibaba.fastjson.d$n
            r0.m41574init(r8)
            r15.m41564init(r0)
            return r15
        L_0x0357:
            if (r0 == 0) goto L_0x039e
            int r15 = r2.size()
            if (r15 != r5) goto L_0x037b
            java.lang.Object r15 = r2.get(r4)
            java.lang.Number r15 = (java.lang.Number) r15
            long r2 = r15.longValue()
            if (r1 == 0) goto L_0x036e
            com.alibaba.fastjson.d$o r15 = com.alibaba.fastjson.JSONPath.C1250o.NE
            goto L_0x0370
        L_0x036e:
            com.alibaba.fastjson.d$o r15 = com.alibaba.fastjson.JSONPath.C1250o.EQ
        L_0x0370:
            com.alibaba.fastjson.d$d r0 = new com.alibaba.fastjson.d$d
            com.alibaba.fastjson.d$h r1 = new com.alibaba.fastjson.d$h
            r1.m41568init(r8, r2, r15)
            r0.m41564init(r1)
            return r0
        L_0x037b:
            int r15 = r2.size()
            long[] r15 = new long[r15]
        L_0x0381:
            int r0 = r15.length
            if (r4 >= r0) goto L_0x0393
            java.lang.Object r0 = r2.get(r4)
            java.lang.Number r0 = (java.lang.Number) r0
            long r5 = r0.longValue()
            r15[r4] = r5
            int r4 = r4 + 1
            goto L_0x0381
        L_0x0393:
            com.alibaba.fastjson.d$d r0 = new com.alibaba.fastjson.d$d
            com.alibaba.fastjson.d$f r2 = new com.alibaba.fastjson.d$f
            r2.m41566init(r8, r15, r1)
            r0.m41564init(r2)
            return r0
        L_0x039e:
            if (r3 == 0) goto L_0x03d2
            int r15 = r2.size()
            if (r15 != r5) goto L_0x03be
            java.lang.Object r15 = r2.get(r4)
            java.lang.String r15 = (java.lang.String) r15
            if (r1 == 0) goto L_0x03b1
            com.alibaba.fastjson.d$o r0 = com.alibaba.fastjson.JSONPath.C1250o.NE
            goto L_0x03b3
        L_0x03b1:
            com.alibaba.fastjson.d$o r0 = com.alibaba.fastjson.JSONPath.C1250o.EQ
        L_0x03b3:
            com.alibaba.fastjson.d$d r1 = new com.alibaba.fastjson.d$d
            com.alibaba.fastjson.d$v r2 = new com.alibaba.fastjson.d$v
            r2.m41583init(r8, r15, r0)
            r1.m41564init(r2)
            return r1
        L_0x03be:
            int r15 = r2.size()
            java.lang.String[] r15 = new java.lang.String[r15]
            r2.toArray(r15)
            com.alibaba.fastjson.d$d r0 = new com.alibaba.fastjson.d$d
            com.alibaba.fastjson.d$u r2 = new com.alibaba.fastjson.d$u
            r2.m41582init(r8, r15, r1)
            r0.m41564init(r2)
            return r0
        L_0x03d2:
            if (r6 == 0) goto L_0x03fd
            int r15 = r2.size()
            java.lang.Long[] r15 = new java.lang.Long[r15]
        L_0x03da:
            int r0 = r15.length
            if (r4 >= r0) goto L_0x03f2
            java.lang.Object r0 = r2.get(r4)
            java.lang.Number r0 = (java.lang.Number) r0
            if (r0 == 0) goto L_0x03ef
            long r5 = r0.longValue()
            java.lang.Long r0 = java.lang.Long.valueOf(r5)
            r15[r4] = r0
        L_0x03ef:
            int r4 = r4 + 1
            goto L_0x03da
        L_0x03f2:
            com.alibaba.fastjson.d$d r0 = new com.alibaba.fastjson.d$d
            com.alibaba.fastjson.d$g r2 = new com.alibaba.fastjson.d$g
            r2.m41567init(r8, r15, r1)
            r0.m41564init(r2)
            return r0
        L_0x03fd:
            java.lang.UnsupportedOperationException r15 = new java.lang.UnsupportedOperationException
            r15.<init>()
            throw r15
        L_0x0403:
            r14.mo11096a()
            java.lang.Object r3 = r14.mo11102f()
            r2.add(r3)
            goto L_0x02e6
        L_0x040f:
            com.alibaba.fastjson.d$o r15 = com.alibaba.fastjson.JSONPath.C1250o.NOT_BETWEEN
            if (r9 != r15) goto L_0x0415
            r13 = 1
            goto L_0x0416
        L_0x0415:
            r13 = 0
        L_0x0416:
            java.lang.Object r15 = r14.mo11102f()
            java.lang.String r0 = r14.mo11104h()
            java.lang.String r1 = "and"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x046a
            java.lang.Object r0 = r14.mo11102f()
            if (r15 == 0) goto L_0x0462
            if (r0 == 0) goto L_0x0462
            java.lang.Class r1 = r15.getClass()
            boolean r1 = com.alibaba.fastjson.JSONPath.m2523a(r1)
            if (r1 == 0) goto L_0x045a
            java.lang.Class r1 = r0.getClass()
            boolean r1 = com.alibaba.fastjson.JSONPath.m2523a(r1)
            if (r1 == 0) goto L_0x045a
            com.alibaba.fastjson.d$e r1 = new com.alibaba.fastjson.d$e
            java.lang.Number r15 = (java.lang.Number) r15
            long r9 = r15.longValue()
            java.lang.Number r0 = (java.lang.Number) r0
            long r11 = r0.longValue()
            r7 = r1
            r7.m41565init(r8, r9, r11, r13)
            com.alibaba.fastjson.d$d r15 = new com.alibaba.fastjson.d$d
            r15.m41564init(r1)
            return r15
        L_0x045a:
            com.alibaba.fastjson.JSONPathException r15 = new com.alibaba.fastjson.JSONPathException
            java.lang.String r0 = r14.f2630a
            r15.m41533init(r0)
            throw r15
        L_0x0462:
            com.alibaba.fastjson.JSONPathException r15 = new com.alibaba.fastjson.JSONPathException
            java.lang.String r0 = r14.f2630a
            r15.m41533init(r0)
            throw r15
        L_0x046a:
            com.alibaba.fastjson.JSONPathException r15 = new com.alibaba.fastjson.JSONPathException
            java.lang.String r0 = r14.f2630a
            r15.m41533init(r0)
            throw r15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONPath.C1244i.mo11095a(boolean):com.alibaba.fastjson.d$s");
        }

        /* access modifiers changed from: protected */
        /* renamed from: e */
        public long mo11101e() {
            int i = this.f2631b - 1;
            char c = this.f2632c;
            if (c == '+' || c == '-') {
                mo11096a();
            }
            while (true) {
                char c2 = this.f2632c;
                if (c2 < '0' || c2 > '9') {
                } else {
                    mo11096a();
                }
            }
            return Long.parseLong(this.f2630a.substring(i, this.f2631b - 1));
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public double mo11093a(long j) {
            int i = this.f2631b - 1;
            mo11096a();
            while (true) {
                char c = this.f2632c;
                if (c < '0' || c > '9') {
                } else {
                    mo11096a();
                }
            }
            return Double.parseDouble(this.f2630a.substring(i, this.f2631b - 1)) + ((double) j);
        }

        /* access modifiers changed from: protected */
        /* renamed from: f */
        public Object mo11102f() {
            mo11100d();
            if (m2540a(this.f2632c)) {
                return Long.valueOf(mo11101e());
            }
            char c = this.f2632c;
            if (c == '\"' || c == '\'') {
                return mo11105i();
            }
            if (c == 'n') {
                if ("null".equals(mo11104h())) {
                    return null;
                }
                throw new JSONPathException(this.f2630a);
            }
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        /* renamed from: g */
        public C1250o mo11103g() {
            C1250o oVar;
            char c = this.f2632c;
            if (c == '=') {
                mo11096a();
                oVar = C1250o.EQ;
            } else if (c == '!') {
                mo11096a();
                mo11097b('=');
                oVar = C1250o.NE;
            } else if (c == '<') {
                mo11096a();
                if (this.f2632c == '=') {
                    mo11096a();
                    oVar = C1250o.LE;
                } else {
                    oVar = C1250o.LT;
                }
            } else if (c == '>') {
                mo11096a();
                if (this.f2632c == '=') {
                    mo11096a();
                    oVar = C1250o.GE;
                } else {
                    oVar = C1250o.GT;
                }
            } else {
                oVar = null;
            }
            if (oVar != null) {
                return oVar;
            }
            String h = mo11104h();
            String str = "between";
            String str2 = "in";
            String str3 = "rlike";
            String str4 = "like";
            if ("not".equalsIgnoreCase(h)) {
                mo11100d();
                String h2 = mo11104h();
                if (str4.equalsIgnoreCase(h2)) {
                    return C1250o.NOT_LIKE;
                }
                if (str3.equalsIgnoreCase(h2)) {
                    return C1250o.NOT_RLIKE;
                }
                if (str2.equalsIgnoreCase(h2)) {
                    return C1250o.NOT_IN;
                }
                if (str.equalsIgnoreCase(h2)) {
                    return C1250o.NOT_BETWEEN;
                }
                throw new UnsupportedOperationException();
            } else if (str4.equalsIgnoreCase(h)) {
                return C1250o.LIKE;
            } else {
                if (str3.equalsIgnoreCase(h)) {
                    return C1250o.RLIKE;
                }
                if (str2.equalsIgnoreCase(h)) {
                    return C1250o.IN;
                }
                if (str.equalsIgnoreCase(h)) {
                    return C1250o.BETWEEN;
                }
                throw new UnsupportedOperationException();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: h */
        public String mo11104h() {
            mo11100d();
            char c = this.f2632c;
            if (c == '\\' || IOUtils.m3196a(c)) {
                StringBuilder sb = new StringBuilder();
                while (!mo11098b()) {
                    char c2 = this.f2632c;
                    if (c2 == '\\') {
                        mo11096a();
                        sb.append(this.f2632c);
                        if (mo11098b()) {
                            break;
                        }
                        mo11096a();
                    } else if (!IOUtils.m3199b(c2)) {
                        break;
                    } else {
                        sb.append(this.f2632c);
                        mo11096a();
                    }
                }
                if (mo11098b() && IOUtils.m3199b(this.f2632c)) {
                    sb.append(this.f2632c);
                }
                return sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("illeal jsonpath syntax. ");
            sb2.append(this.f2630a);
            throw new JSONPathException(sb2.toString());
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: i */
        public String mo11105i() {
            char c = this.f2632c;
            mo11096a();
            int i = this.f2631b - 1;
            while (this.f2632c != c && !mo11098b()) {
                mo11096a();
            }
            String substring = this.f2630a.substring(i, mo11098b() ? this.f2631b : this.f2631b - 1);
            mo11097b(c);
            return substring;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo11097b(char c) {
            if (this.f2632c != c) {
                StringBuilder sb = new StringBuilder();
                sb.append("expect '");
                sb.append(c);
                sb.append(", but '");
                sb.append(this.f2632c);
                sb.append("'");
                throw new JSONPathException(sb.toString());
            } else if (!mo11098b()) {
                mo11096a();
            }
        }

        /* renamed from: j */
        public C1254s[] mo11106j() {
            String str = this.f2630a;
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException();
            }
            C1254s[] sVarArr = new C1254s[8];
            while (true) {
                C1254s c = mo11099c();
                if (c == null) {
                    break;
                }
                int i = this.f2633d;
                if (i == sVarArr.length) {
                    C1254s[] sVarArr2 = new C1254s[((i * 3) / 2)];
                    System.arraycopy(sVarArr, 0, sVarArr2, 0, i);
                    sVarArr = sVarArr2;
                }
                int i2 = this.f2633d;
                this.f2633d = i2 + 1;
                sVarArr[i2] = c;
            }
            int i3 = this.f2633d;
            if (i3 == sVarArr.length) {
                return sVarArr;
            }
            C1254s[] sVarArr3 = new C1254s[i3];
            System.arraycopy(sVarArr, 0, sVarArr3, 0, i3);
            return sVarArr3;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C1254s mo11094a(String str) {
            int length = str.length();
            int i = 0;
            char charAt = str.charAt(0);
            int i2 = 1;
            int i3 = length - 1;
            char charAt2 = str.charAt(i3);
            int indexOf = str.indexOf(44);
            int length2 = str.length();
            String str2 = StorageInterface.KEY_SPLITER;
            int i4 = -1;
            if (length2 <= 2 || charAt != '\'' || charAt2 != '\'') {
                int indexOf2 = str.indexOf(58);
                if (indexOf == -1 && indexOf2 == -1) {
                    if (!TypeUtils.m3239a(str)) {
                        return new C1251p(str, false);
                    }
                    try {
                        return new C1236a(Integer.parseInt(str));
                    } catch (NumberFormatException unused) {
                        return new C1251p(str, false);
                    }
                } else if (indexOf != -1) {
                    String[] split = str.split(str2);
                    int[] iArr = new int[split.length];
                    while (i < split.length) {
                        iArr[i] = Integer.parseInt(split[i]);
                        i++;
                    }
                    return new C1246k(iArr);
                } else if (indexOf2 != -1) {
                    String[] split2 = str.split(":");
                    int[] iArr2 = new int[split2.length];
                    for (int i5 = 0; i5 < split2.length; i5++) {
                        String str3 = split2[i5];
                        if (str3.length() != 0) {
                            iArr2[i5] = Integer.parseInt(str3);
                        } else if (i5 == 0) {
                            iArr2[i5] = 0;
                        } else {
                            throw new UnsupportedOperationException();
                        }
                    }
                    int i6 = iArr2[0];
                    if (iArr2.length > 1) {
                        i4 = iArr2[1];
                    }
                    if (iArr2.length == 3) {
                        i2 = iArr2[2];
                    }
                    if (i4 >= 0 && i4 < i6) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("end must greater than or equals start. start ");
                        sb.append(i6);
                        sb.append(",  end ");
                        sb.append(i4);
                        throw new UnsupportedOperationException(sb.toString());
                    } else if (i2 > 0) {
                        return new C1252q(i6, i4, i2);
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("step must greater than zero : ");
                        sb2.append(i2);
                        throw new UnsupportedOperationException(sb2.toString());
                    }
                } else {
                    throw new UnsupportedOperationException();
                }
            } else if (indexOf == -1) {
                return new C1251p(str.substring(1, i3), false);
            } else {
                String[] split3 = str.split(str2);
                String[] strArr = new String[split3.length];
                while (i < split3.length) {
                    String str4 = split3[i];
                    strArr[i] = str4.substring(1, str4.length() - 1);
                    i++;
                }
                return new C1247l(strArr);
            }
        }
    }

    /* compiled from: JSONPath */
    /* renamed from: com.alibaba.fastjson.d$j */
    static class C1245j implements C1238c {
        /* renamed from: a */
        private final String f2634a;
        /* renamed from: b */
        private final long f2635b;
        /* renamed from: c */
        private final String f2636c;
        /* renamed from: d */
        private final String f2637d;
        /* renamed from: e */
        private final String[] f2638e;
        /* renamed from: f */
        private final int f2639f;
        /* renamed from: g */
        private final boolean f2640g;

        public C1245j(String str, String str2, String str3, String[] strArr, boolean z) {
            this.f2634a = str;
            this.f2635b = TypeUtils.m3265g(str);
            this.f2636c = str2;
            this.f2637d = str3;
            this.f2638e = strArr;
            this.f2640g = z;
            int length = str2 != null ? str2.length() + 0 : 0;
            if (str3 != null) {
                length += str3.length();
            }
            if (strArr != null) {
                for (String length2 : strArr) {
                    length += length2.length();
                }
            }
            this.f2639f = length;
        }

        /* renamed from: a */
        public boolean mo11092a(JSONPath dVar, Object obj, Object obj2, Object obj3) {
            int i;
            Object a = dVar.mo11085a(obj3, this.f2634a, this.f2635b);
            if (a == null) {
                return false;
            }
            String obj4 = a.toString();
            if (obj4.length() < this.f2639f) {
                return this.f2640g;
            }
            String str = this.f2636c;
            if (str == null) {
                i = 0;
            } else if (!obj4.startsWith(str)) {
                return this.f2640g;
            } else {
                i = this.f2636c.length() + 0;
            }
            String[] strArr = this.f2638e;
            if (strArr != null) {
                for (String str2 : strArr) {
                    int indexOf = obj4.indexOf(str2, i);
                    if (indexOf == -1) {
                        return this.f2640g;
                    }
                    i = indexOf + str2.length();
                }
            }
            String str3 = this.f2637d;
            if (str3 == null || obj4.endsWith(str3)) {
                return !this.f2640g;
            }
            return this.f2640g;
        }
    }

    /* compiled from: JSONPath */
    /* renamed from: com.alibaba.fastjson.d$k */
    static class C1246k implements C1254s {
        /* renamed from: a */
        private final int[] f2641a;

        public C1246k(int[] iArr) {
            this.f2641a = iArr;
        }

        /* renamed from: a */
        public Object mo11091a(JSONPath dVar, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.f2641a.length);
            int i = 0;
            while (true) {
                int[] iArr = this.f2641a;
                if (i >= iArr.length) {
                    return arrayList;
                }
                arrayList.add(dVar.mo11084a(obj2, iArr[i]));
                i++;
            }
        }
    }

    /* compiled from: JSONPath */
    /* renamed from: com.alibaba.fastjson.d$l */
    static class C1247l implements C1254s {
        /* renamed from: a */
        private final String[] f2642a;
        /* renamed from: b */
        private final long[] f2643b;

        public C1247l(String[] strArr) {
            this.f2642a = strArr;
            this.f2643b = new long[strArr.length];
            int i = 0;
            while (true) {
                long[] jArr = this.f2643b;
                if (i < jArr.length) {
                    jArr[i] = TypeUtils.m3265g(strArr[i]);
                    i++;
                } else {
                    return;
                }
            }
        }

        /* renamed from: a */
        public Object mo11091a(JSONPath dVar, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.f2642a.length);
            int i = 0;
            while (true) {
                String[] strArr = this.f2642a;
                if (i >= strArr.length) {
                    return arrayList;
                }
                arrayList.add(dVar.mo11085a(obj2, strArr[i], this.f2643b[i]));
                i++;
            }
        }
    }

    /* compiled from: JSONPath */
    /* renamed from: com.alibaba.fastjson.d$m */
    static class C1248m implements C1238c {
        /* renamed from: a */
        private final String f2644a;
        /* renamed from: b */
        private final long f2645b;

        public C1248m(String str) {
            this.f2644a = str;
            this.f2645b = TypeUtils.m3265g(str);
        }

        /* renamed from: a */
        public boolean mo11092a(JSONPath dVar, Object obj, Object obj2, Object obj3) {
            return dVar.mo11085a(obj3, this.f2644a, this.f2645b) != null;
        }
    }

    /* compiled from: JSONPath */
    /* renamed from: com.alibaba.fastjson.d$n */
    static class C1249n implements C1238c {
        /* renamed from: a */
        private final String f2646a;
        /* renamed from: b */
        private final long f2647b;

        public C1249n(String str) {
            this.f2646a = str;
            this.f2647b = TypeUtils.m3265g(str);
        }

        /* renamed from: a */
        public boolean mo11092a(JSONPath dVar, Object obj, Object obj2, Object obj3) {
            return dVar.mo11085a(obj3, this.f2646a, this.f2647b) == null;
        }
    }

    /* compiled from: JSONPath */
    /* renamed from: com.alibaba.fastjson.d$o */
    enum C1250o {
        EQ,
        NE,
        GT,
        GE,
        LT,
        LE,
        LIKE,
        NOT_LIKE,
        RLIKE,
        NOT_RLIKE,
        IN,
        NOT_IN,
        BETWEEN,
        NOT_BETWEEN
    }

    /* compiled from: JSONPath */
    /* renamed from: com.alibaba.fastjson.d$p */
    static class C1251p implements C1254s {
        /* renamed from: a */
        private final String f2656a;
        /* renamed from: b */
        private final long f2657b;
        /* renamed from: c */
        private final boolean f2658c;

        public C1251p(String str, boolean z) {
            this.f2656a = str;
            this.f2657b = TypeUtils.m3265g(str);
            this.f2658c = z;
        }

        /* renamed from: a */
        public Object mo11091a(JSONPath dVar, Object obj, Object obj2) {
            if (!this.f2658c) {
                return dVar.mo11085a(obj2, this.f2656a, this.f2657b);
            }
            ArrayList arrayList = new ArrayList();
            dVar.mo11087a(obj2, this.f2656a, (List<Object>) arrayList);
            return arrayList;
        }
    }

    /* compiled from: JSONPath */
    /* renamed from: com.alibaba.fastjson.d$q */
    static class C1252q implements C1254s {
        /* renamed from: a */
        private final int f2659a;
        /* renamed from: b */
        private final int f2660b;
        /* renamed from: c */
        private final int f2661c;

        public C1252q(int i, int i2, int i3) {
            this.f2659a = i;
            this.f2660b = i2;
            this.f2661c = i3;
        }

        /* renamed from: a */
        public Object mo11091a(JSONPath dVar, Object obj, Object obj2) {
            int intValue = C1255t.f2666a.mo11091a(dVar, obj, obj2).intValue();
            int i = this.f2659a;
            if (i < 0) {
                i += intValue;
            }
            int i2 = this.f2660b;
            if (i2 < 0) {
                i2 += intValue;
            }
            int i3 = ((i2 - i) / this.f2661c) + 1;
            if (i3 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i3);
            while (i <= i2 && i < intValue) {
                arrayList.add(dVar.mo11084a(obj2, i));
                i += this.f2661c;
            }
            return arrayList;
        }
    }

    /* compiled from: JSONPath */
    /* renamed from: com.alibaba.fastjson.d$r */
    static class C1253r implements C1238c {
        /* renamed from: a */
        private final String f2662a;
        /* renamed from: b */
        private final long f2663b;
        /* renamed from: c */
        private final Pattern f2664c;
        /* renamed from: d */
        private final boolean f2665d;

        public C1253r(String str, String str2, boolean z) {
            this.f2662a = str;
            this.f2663b = TypeUtils.m3265g(str);
            this.f2664c = Pattern.compile(str2);
            this.f2665d = z;
        }

        /* renamed from: a */
        public boolean mo11092a(JSONPath dVar, Object obj, Object obj2, Object obj3) {
            Object a = dVar.mo11085a(obj3, this.f2662a, this.f2663b);
            if (a == null) {
                return false;
            }
            boolean matches = this.f2664c.matcher(a.toString()).matches();
            if (this.f2665d) {
                matches = !matches;
            }
            return matches;
        }
    }

    /* compiled from: JSONPath */
    /* renamed from: com.alibaba.fastjson.d$s */
    interface C1254s {
        /* renamed from: a */
        Object mo11091a(JSONPath dVar, Object obj, Object obj2);
    }

    /* compiled from: JSONPath */
    /* renamed from: com.alibaba.fastjson.d$t */
    static class C1255t implements C1254s {
        /* renamed from: a */
        public static final C1255t f2666a = new C1255t();

        C1255t() {
        }

        /* renamed from: b */
        public Integer mo11091a(JSONPath dVar, Object obj, Object obj2) {
            return Integer.valueOf(dVar.mo11090c(obj2));
        }
    }

    /* compiled from: JSONPath */
    /* renamed from: com.alibaba.fastjson.d$u */
    static class C1256u implements C1238c {
        /* renamed from: a */
        private final String f2667a;
        /* renamed from: b */
        private final long f2668b;
        /* renamed from: c */
        private final String[] f2669c;
        /* renamed from: d */
        private final boolean f2670d;

        public C1256u(String str, String[] strArr, boolean z) {
            this.f2667a = str;
            this.f2668b = TypeUtils.m3265g(str);
            this.f2669c = strArr;
            this.f2670d = z;
        }

        /* renamed from: a */
        public boolean mo11092a(JSONPath dVar, Object obj, Object obj2, Object obj3) {
            Object a = dVar.mo11085a(obj3, this.f2667a, this.f2668b);
            String[] strArr = this.f2669c;
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String str = strArr[i];
                if (str == a) {
                    return !this.f2670d;
                }
                if (str != null && str.equals(a)) {
                    return !this.f2670d;
                }
            }
            return this.f2670d;
        }
    }

    /* compiled from: JSONPath */
    /* renamed from: com.alibaba.fastjson.d$v */
    static class C1257v implements C1238c {
        /* renamed from: a */
        private final String f2671a;
        /* renamed from: b */
        private final long f2672b;
        /* renamed from: c */
        private final String f2673c;
        /* renamed from: d */
        private final C1250o f2674d;

        public C1257v(String str, String str2, C1250o oVar) {
            this.f2671a = str;
            this.f2672b = TypeUtils.m3265g(str);
            this.f2673c = str2;
            this.f2674d = oVar;
        }

        /* renamed from: a */
        public boolean mo11092a(JSONPath dVar, Object obj, Object obj2, Object obj3) {
            boolean z;
            boolean z2;
            Object a = dVar.mo11085a(obj3, this.f2671a, this.f2672b);
            if (this.f2674d == C1250o.EQ) {
                return this.f2673c.equals(a);
            }
            if (this.f2674d == C1250o.NE) {
                return !this.f2673c.equals(a);
            }
            boolean z3 = false;
            if (a == null) {
                return false;
            }
            int compareTo = this.f2673c.compareTo(a.toString());
            if (this.f2674d == C1250o.GE) {
                if (compareTo <= 0) {
                    z3 = true;
                }
                return z3;
            } else if (this.f2674d == C1250o.GT) {
                if (compareTo < 0) {
                    z3 = true;
                }
                return z3;
            } else if (this.f2674d == C1250o.LE) {
                if (compareTo >= 0) {
                    z2 = true;
                }
                return z2;
            } else {
                if (this.f2674d == C1250o.LT && compareTo > 0) {
                    z = true;
                }
                return z;
            }
        }
    }

    /* compiled from: JSONPath */
    /* renamed from: com.alibaba.fastjson.d$w */
    static class C1258w implements C1238c {
        /* renamed from: a */
        private final String f2675a;
        /* renamed from: b */
        private final long f2676b;
        /* renamed from: c */
        private final Object f2677c;
        /* renamed from: d */
        private boolean f2678d = true;

        public C1258w(String str, Object obj, boolean z) {
            if (obj != null) {
                this.f2675a = str;
                this.f2676b = TypeUtils.m3265g(str);
                this.f2677c = obj;
                this.f2678d = z;
                return;
            }
            throw new IllegalArgumentException("value is null");
        }

        /* renamed from: a */
        public boolean mo11092a(JSONPath dVar, Object obj, Object obj2, Object obj3) {
            boolean equals = this.f2677c.equals(dVar.mo11085a(obj3, this.f2675a, this.f2676b));
            return !this.f2678d ? !equals : equals;
        }
    }

    /* compiled from: JSONPath */
    /* renamed from: com.alibaba.fastjson.d$x */
    static class C1259x implements C1254s {
        /* renamed from: a */
        public static C1259x f2679a = new C1259x();

        C1259x() {
        }

        /* renamed from: a */
        public Object mo11091a(JSONPath dVar, Object obj, Object obj2) {
            return dVar.mo11089b(obj2);
        }
    }

    public JSONPath(String str) {
        this(str, SerializeConfig.m3034a(), ParserConfig.m2904a());
    }

    public JSONPath(String str, SerializeConfig axVar, ParserConfig hVar) {
        if (str == null || str.length() == 0) {
            throw new JSONPathException("json-path can not be null or empty");
        }
        this.f2603b = str;
        this.f2605d = axVar;
        this.f2606e = hVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo11086a() {
        if (this.f2604c == null) {
            if (Marker.ANY_MARKER.equals(this.f2603b)) {
                this.f2604c = new C1254s[]{C1259x.f2679a};
            } else {
                this.f2604c = new C1244i(this.f2603b).mo11106j();
            }
        }
    }

    /* renamed from: a */
    public Object mo11083a(Object obj) {
        if (obj == null) {
            return null;
        }
        mo11086a();
        int i = 0;
        Object obj2 = obj;
        while (true) {
            C1254s[] sVarArr = this.f2604c;
            if (i >= sVarArr.length) {
                return obj2;
            }
            obj2 = sVarArr[i].mo11091a(this, obj, obj2);
            i++;
        }
    }

    /* renamed from: a */
    public static Object m2522a(Object obj, String str) {
        return m2521a(str).mo11083a(obj);
    }

    /* renamed from: a */
    public static JSONPath m2521a(String str) {
        if (str != null) {
            JSONPath dVar = (JSONPath) f2602a.get(str);
            if (dVar != null) {
                return dVar;
            }
            JSONPath dVar2 = new JSONPath(str);
            if (f2602a.size() >= 1024) {
                return dVar2;
            }
            f2602a.putIfAbsent(str, dVar2);
            return (JSONPath) f2602a.get(str);
        }
        throw new JSONPathException("jsonpath can not be null");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo11084a(Object obj, int i) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (i >= 0) {
                if (i < list.size()) {
                    return list.get(i);
                }
                return null;
            } else if (Math.abs(i) <= list.size()) {
                return list.get(list.size() + i);
            } else {
                return null;
            }
        } else if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            if (i >= 0) {
                if (i < length) {
                    return Array.get(obj, i);
                }
                return null;
            } else if (Math.abs(i) <= length) {
                return Array.get(obj, length + i);
            } else {
                return null;
            }
        } else if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj2 = map.get(Integer.valueOf(i));
            if (obj2 == null) {
                obj2 = map.get(Integer.toString(i));
            }
            return obj2;
        } else if (obj instanceof Collection) {
            int i2 = 0;
            for (Object next : (Collection) obj) {
                if (i2 == i) {
                    return next;
                }
                i2++;
            }
            return null;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Collection<Object> mo11089b(Object obj) {
        JavaBeanSerializer b = mo11088b(obj.getClass());
        if (b != null) {
            try {
                return b.mo11335a(obj);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("jsonpath error, path ");
                sb.append(this.f2603b);
                throw new JSONPathException(sb.toString(), e);
            }
        } else if (obj instanceof Map) {
            return ((Map) obj).values();
        } else {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: a */
    protected static boolean m2523a(Class<?> cls) {
        return cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo11085a(Object obj, String str, long j) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj2 = map.get(str);
            if (obj2 == null && 5614464919154503228L == j) {
                obj2 = Integer.valueOf(map.size());
            }
            return obj2;
        }
        JavaBeanSerializer b = mo11088b(obj.getClass());
        if (b != null) {
            try {
                return b.mo11334a(obj, str, j, false);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("jsonpath error, path ");
                sb.append(this.f2603b);
                sb.append(", segement ");
                sb.append(str);
                throw new JSONPathException(sb.toString(), e);
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            if (5614464919154503228L == j) {
                return Integer.valueOf(list.size());
            }
            JSONArray jSONArray = new JSONArray(list.size());
            for (int i = 0; i < list.size(); i++) {
                Object a = mo11085a(list.get(i), str, j);
                if (a instanceof Collection) {
                    jSONArray.addAll((Collection) a);
                } else if (a != null) {
                    jSONArray.add(a);
                }
            }
            return jSONArray;
        } else {
            if (obj instanceof Enum) {
                Enum enumR = (Enum) obj;
                if (-4270347329889690746L == j) {
                    return enumR.name();
                }
                if (-1014497654951707614L == j) {
                    return Integer.valueOf(enumR.ordinal());
                }
            }
            if (obj instanceof Calendar) {
                Calendar calendar = (Calendar) obj;
                if (8963398325558730460L == j) {
                    return Integer.valueOf(calendar.get(1));
                }
                if (-811277319855450459L == j) {
                    return Integer.valueOf(calendar.get(2));
                }
                if (-3851359326990528739L == j) {
                    return Integer.valueOf(calendar.get(5));
                }
                if (4647432019745535567L == j) {
                    return Integer.valueOf(calendar.get(11));
                }
                if (6607618197526598121L == j) {
                    return Integer.valueOf(calendar.get(12));
                }
                if (-6586085717218287427L == j) {
                    return Integer.valueOf(calendar.get(13));
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo11087a(Object obj, String str, List<Object> list) {
        String str2 = "getFieldValue error.";
        if (obj != null) {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (map.containsKey(str)) {
                    list.add(map.get(str));
                    return;
                }
                for (Object a : map.values()) {
                    mo11087a(a, str, list);
                }
                return;
            }
            JavaBeanSerializer b = mo11088b(obj.getClass());
            if (b != null) {
                try {
                    FieldSerializer a2 = b.mo11333a(str);
                    if (a2 != null) {
                        list.add(a2.mo11430a(obj));
                        return;
                    }
                    for (Object a3 : b.mo11335a(obj)) {
                        mo11087a(a3, str, list);
                    }
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
                } catch (Exception e3) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("jsonpath error, path ");
                    sb3.append(this.f2603b);
                    sb3.append(", segement ");
                    sb3.append(str);
                    throw new JSONPathException(sb3.toString(), e3);
                }
            } else {
                if (obj instanceof List) {
                    List list2 = (List) obj;
                    for (int i = 0; i < list2.size(); i++) {
                        mo11087a(list2.get(i), str, list);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public JavaBeanSerializer mo11088b(Class<?> cls) {
        ObjectSerializer b = this.f2605d.mo11355b(cls);
        if (b instanceof JavaBeanSerializer) {
            return (JavaBeanSerializer) b;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo11090c(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).size();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj);
        }
        if (obj instanceof Map) {
            int i = 0;
            for (Object obj2 : ((Map) obj).values()) {
                if (obj2 != null) {
                    i++;
                }
            }
            return i;
        }
        JavaBeanSerializer b = mo11088b(obj.getClass());
        if (b == null) {
            return -1;
        }
        try {
            return b.mo11342b(obj);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("evalSize error : ");
            sb.append(this.f2603b);
            throw new JSONPathException(sb.toString(), e);
        }
    }

    public String toJSONString() {
        return JSON.toJSONString(this.f2603b);
    }
}
