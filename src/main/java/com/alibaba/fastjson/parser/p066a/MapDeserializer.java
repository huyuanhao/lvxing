package com.alibaba.fastjson.parser.p066a;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.DefaultJSONParser.C1261a;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParseContext;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.alibaba.fastjson.parser.a.q */
public class MapDeserializer implements ObjectDeserializer {
    /* renamed from: a */
    public static MapDeserializer f2756a = new MapDeserializer();

    /* renamed from: g_ */
    public int mo11162g_() {
        return 12;
    }

    /* renamed from: a */
    public <T> T mo11161a(DefaultJSONParser aVar, Type type, Object obj) {
        if (type == JSONObject.class && aVar.mo11153k() == null) {
            return aVar.mo11148f();
        }
        JSONLexer bVar = aVar.f2689d;
        if (bVar.mo11205a() == 8) {
            bVar.mo11211a(16);
            return null;
        }
        Map a = mo11201a(type);
        ParseContext g = aVar.mo11149g();
        try {
            aVar.mo11113a(g, (Object) a, obj);
            return mo11200a(aVar, type, obj, a);
        } finally {
            aVar.mo11125a(g);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo11200a(DefaultJSONParser aVar, Type type, Object obj, Map map) {
        Type type2;
        if (!(type instanceof ParameterizedType)) {
            return aVar.mo11120a(map, obj);
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type type3 = parameterizedType.getActualTypeArguments()[0];
        if (map.getClass().getName().equals("org.springframework.util.LinkedMultiValueMap")) {
            type2 = List.class;
        } else {
            type2 = parameterizedType.getActualTypeArguments()[1];
        }
        if (String.class == type3) {
            return m2710a(aVar, map, type2, obj);
        }
        return m2709a(aVar, map, type3, type2, obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
            r11 = r4.mo11292a((java.lang.reflect.Type) r3);
            r0.mo11211a(16);
            r10.mo11122a(2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x019e, code lost:
            if (r1 == null) goto L_0x01a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01a2, code lost:
            if ((r13 instanceof java.lang.Integer) != false) goto L_0x01a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01a4, code lost:
            r10.mo11154l();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01a7, code lost:
            r11 = (java.util.Map) r11.mo11161a(r10, r3, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01ad, code lost:
            r10.mo11125a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01b0, code lost:
            return r11;
     */
    /* renamed from: a */
    public static java.util.Map m2710a(com.alibaba.fastjson.parser.DefaultJSONParser r10, java.util.Map<java.lang.String, java.lang.Object> r11, java.lang.reflect.Type r12, java.lang.Object r13) {
        /*
        com.alibaba.fastjson.parser.b r0 = r10.f2689d
        int r1 = r0.mo11205a()
        r2 = 0
        r3 = 12
        if (r1 == r3) goto L_0x008b
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r12 = "syntax error, expect {, actual "
        r11.append(r12)
        java.lang.String r12 = r0.mo11214b()
        r11.append(r12)
        java.lang.String r11 = r11.toString()
        boolean r12 = r13 instanceof java.lang.String
        if (r12 == 0) goto L_0x0044
        java.lang.StringBuilder r12 = new java.lang.StringBuilder
        r12.<init>()
        r12.append(r11)
        java.lang.String r11 = ", fieldName "
        r12.append(r11)
        java.lang.String r11 = r12.toString()
        java.lang.StringBuilder r12 = new java.lang.StringBuilder
        r12.<init>()
        r12.append(r11)
        r12.append(r13)
        java.lang.String r11 = r12.toString()
    L_0x0044:
        java.lang.StringBuilder r12 = new java.lang.StringBuilder
        r12.<init>()
        r12.append(r11)
        java.lang.String r11 = ", "
        r12.append(r11)
        java.lang.String r11 = r12.toString()
        java.lang.StringBuilder r12 = new java.lang.StringBuilder
        r12.<init>()
        r12.append(r11)
        java.lang.String r11 = r0.mo11245x()
        r12.append(r11)
        java.lang.String r11 = r12.toString()
        r12 = 4
        if (r1 == r12) goto L_0x0085
        com.alibaba.fastjson.JSONArray r12 = new com.alibaba.fastjson.JSONArray
        r12.m41522init()
        r10.mo11133a(r12, r13)
        int r10 = r12.size()
        r13 = 1
        if (r10 != r13) goto L_0x0085
        java.lang.Object r10 = r12.get(r2)
        boolean r12 = r10 instanceof com.alibaba.fastjson.JSONObject
        if (r12 == 0) goto L_0x0085
        com.alibaba.fastjson.JSONObject r10 = (com.alibaba.fastjson.JSONObject) r10
        return r10
    L_0x0085:
        com.alibaba.fastjson.JSONException r10 = new com.alibaba.fastjson.JSONException
        r10.m41526init(r11)
        throw r10
    L_0x008b:
        com.alibaba.fastjson.parser.g r1 = r10.mo11149g()
    L_0x008f:
        r0.mo11218c()     // Catch:{ all -> 0x021a }
        char r3 = r0.mo11223e()     // Catch:{ all -> 0x021a }
        com.alibaba.fastjson.parser.Feature r4 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas     // Catch:{ all -> 0x021a }
        boolean r4 = r0.mo11212a(r4)     // Catch:{ all -> 0x021a }
        if (r4 == 0) goto L_0x00ad
    L_0x009e:
        r4 = 44
        if (r3 != r4) goto L_0x00ad
        r0.mo11225f()     // Catch:{ all -> 0x021a }
        r0.mo11218c()     // Catch:{ all -> 0x021a }
        char r3 = r0.mo11223e()     // Catch:{ all -> 0x021a }
        goto L_0x009e
    L_0x00ad:
        java.lang.String r4 = "expect ':' at "
        r5 = 58
        r6 = 34
        r7 = 16
        if (r3 != r6) goto L_0x00e3
        com.alibaba.fastjson.parser.i r3 = r10.mo11142c()     // Catch:{ all -> 0x021a }
        java.lang.String r3 = r0.mo11210a(r3, r6)     // Catch:{ all -> 0x021a }
        r0.mo11218c()     // Catch:{ all -> 0x021a }
        char r8 = r0.mo11223e()     // Catch:{ all -> 0x021a }
        if (r8 != r5) goto L_0x00ca
        goto L_0x014c
    L_0x00ca:
        com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x021a }
        java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x021a }
        r12.<init>()     // Catch:{ all -> 0x021a }
        r12.append(r4)     // Catch:{ all -> 0x021a }
        int r13 = r0.mo11230i()     // Catch:{ all -> 0x021a }
        r12.append(r13)     // Catch:{ all -> 0x021a }
        java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x021a }
        r11.m41526init(r12)     // Catch:{ all -> 0x021a }
        throw r11     // Catch:{ all -> 0x021a }
    L_0x00e3:
        r8 = 125(0x7d, float:1.75E-43)
        if (r3 != r8) goto L_0x00f4
        r0.mo11225f()     // Catch:{ all -> 0x021a }
        r0.mo11228g()     // Catch:{ all -> 0x021a }
        r0.mo11211a(r7)     // Catch:{ all -> 0x021a }
        r10.mo11125a(r1)
        return r11
    L_0x00f4:
        java.lang.String r8 = "syntax error"
        r9 = 39
        if (r3 != r9) goto L_0x0133
        com.alibaba.fastjson.parser.Feature r3 = com.alibaba.fastjson.parser.Feature.AllowSingleQuotes     // Catch:{ all -> 0x021a }
        boolean r3 = r0.mo11212a(r3)     // Catch:{ all -> 0x021a }
        if (r3 == 0) goto L_0x012d
        com.alibaba.fastjson.parser.i r3 = r10.mo11142c()     // Catch:{ all -> 0x021a }
        java.lang.String r3 = r0.mo11210a(r3, r9)     // Catch:{ all -> 0x021a }
        r0.mo11218c()     // Catch:{ all -> 0x021a }
        char r8 = r0.mo11223e()     // Catch:{ all -> 0x021a }
        if (r8 != r5) goto L_0x0114
        goto L_0x014c
    L_0x0114:
        com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x021a }
        java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x021a }
        r12.<init>()     // Catch:{ all -> 0x021a }
        r12.append(r4)     // Catch:{ all -> 0x021a }
        int r13 = r0.mo11230i()     // Catch:{ all -> 0x021a }
        r12.append(r13)     // Catch:{ all -> 0x021a }
        java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x021a }
        r11.m41526init(r12)     // Catch:{ all -> 0x021a }
        throw r11     // Catch:{ all -> 0x021a }
    L_0x012d:
        com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x021a }
        r11.m41526init(r8)     // Catch:{ all -> 0x021a }
        throw r11     // Catch:{ all -> 0x021a }
    L_0x0133:
        com.alibaba.fastjson.parser.Feature r3 = com.alibaba.fastjson.parser.Feature.AllowUnQuotedFieldNames     // Catch:{ all -> 0x021a }
        boolean r3 = r0.mo11212a(r3)     // Catch:{ all -> 0x021a }
        if (r3 == 0) goto L_0x0214
        com.alibaba.fastjson.parser.i r3 = r10.mo11142c()     // Catch:{ all -> 0x021a }
        java.lang.String r3 = r0.mo11215b(r3)     // Catch:{ all -> 0x021a }
        r0.mo11218c()     // Catch:{ all -> 0x021a }
        char r8 = r0.mo11223e()     // Catch:{ all -> 0x021a }
        if (r8 != r5) goto L_0x01f3
    L_0x014c:
        r0.mo11225f()     // Catch:{ all -> 0x021a }
        r0.mo11218c()     // Catch:{ all -> 0x021a }
        r0.mo11223e()     // Catch:{ all -> 0x021a }
        r0.mo11228g()     // Catch:{ all -> 0x021a }
        java.lang.String r4 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x021a }
        r5 = 13
        r8 = 0
        if (r3 != r4) goto L_0x01b1
        com.alibaba.fastjson.parser.Feature r4 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x021a }
        boolean r4 = r0.mo11212a(r4)     // Catch:{ all -> 0x021a }
        if (r4 != 0) goto L_0x01b1
        com.alibaba.fastjson.parser.i r3 = r10.mo11142c()     // Catch:{ all -> 0x021a }
        java.lang.String r3 = r0.mo11210a(r3, r6)     // Catch:{ all -> 0x021a }
        com.alibaba.fastjson.parser.h r4 = r10.mo11146d()     // Catch:{ all -> 0x021a }
        int r6 = r0.mo11246y()     // Catch:{ all -> 0x021a }
        java.lang.Class r3 = r4.mo11294a(r3, r8, r6)     // Catch:{ all -> 0x021a }
        java.lang.Class<java.util.Map> r6 = java.util.Map.class
        boolean r6 = r6.isAssignableFrom(r3)     // Catch:{ all -> 0x021a }
        if (r6 == 0) goto L_0x0193
        r0.mo11211a(r7)     // Catch:{ all -> 0x021a }
        int r3 = r0.mo11205a()     // Catch:{ all -> 0x021a }
        if (r3 != r5) goto L_0x01eb
        r0.mo11211a(r7)     // Catch:{ all -> 0x021a }
        r10.mo11125a(r1)
        return r11
    L_0x0193:
        com.alibaba.fastjson.parser.a.s r11 = r4.mo11292a(r3)     // Catch:{ all -> 0x021a }
        r0.mo11211a(r7)     // Catch:{ all -> 0x021a }
        r12 = 2
        r10.mo11122a(r12)     // Catch:{ all -> 0x021a }
        if (r1 == 0) goto L_0x01a7
        boolean r12 = r13 instanceof java.lang.Integer     // Catch:{ all -> 0x021a }
        if (r12 != 0) goto L_0x01a7
        r10.mo11154l()     // Catch:{ all -> 0x021a }
    L_0x01a7:
        java.lang.Object r11 = r11.mo11161a(r10, r3, r13)     // Catch:{ all -> 0x021a }
        java.util.Map r11 = (java.util.Map) r11     // Catch:{ all -> 0x021a }
        r10.mo11125a(r1)
        return r11
    L_0x01b1:
        r0.mo11222d()     // Catch:{ all -> 0x021a }
        if (r2 == 0) goto L_0x01b9
        r10.mo11125a(r1)     // Catch:{ all -> 0x021a }
    L_0x01b9:
        int r4 = r0.mo11205a()     // Catch:{ all -> 0x021a }
        r6 = 8
        if (r4 != r6) goto L_0x01c5
        r0.mo11222d()     // Catch:{ all -> 0x021a }
        goto L_0x01c9
    L_0x01c5:
        java.lang.Object r8 = r10.mo11118a(r12, r3)     // Catch:{ all -> 0x021a }
    L_0x01c9:
        r11.put(r3, r8)     // Catch:{ all -> 0x021a }
        r10.mo11141b(r11, r3)     // Catch:{ all -> 0x021a }
        r10.mo11113a(r1, r8, r3)     // Catch:{ all -> 0x021a }
        r10.mo11125a(r1)     // Catch:{ all -> 0x021a }
        int r3 = r0.mo11205a()     // Catch:{ all -> 0x021a }
        r4 = 20
        if (r3 == r4) goto L_0x01ef
        r4 = 15
        if (r3 != r4) goto L_0x01e2
        goto L_0x01ef
    L_0x01e2:
        if (r3 != r5) goto L_0x01eb
        r0.mo11222d()     // Catch:{ all -> 0x021a }
        r10.mo11125a(r1)
        return r11
    L_0x01eb:
        int r2 = r2 + 1
        goto L_0x008f
    L_0x01ef:
        r10.mo11125a(r1)
        return r11
    L_0x01f3:
        com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x021a }
        java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x021a }
        r12.<init>()     // Catch:{ all -> 0x021a }
        r12.append(r4)     // Catch:{ all -> 0x021a }
        int r13 = r0.mo11230i()     // Catch:{ all -> 0x021a }
        r12.append(r13)     // Catch:{ all -> 0x021a }
        java.lang.String r13 = ", actual "
        r12.append(r13)     // Catch:{ all -> 0x021a }
        r12.append(r8)     // Catch:{ all -> 0x021a }
        java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x021a }
        r11.m41526init(r12)     // Catch:{ all -> 0x021a }
        throw r11     // Catch:{ all -> 0x021a }
    L_0x0214:
        com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x021a }
        r11.m41526init(r8)     // Catch:{ all -> 0x021a }
        throw r11     // Catch:{ all -> 0x021a }
    L_0x021a:
        r11 = move-exception
        r10.mo11125a(r1)
        throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.p066a.MapDeserializer.m2710a(com.alibaba.fastjson.parser.a, java.util.Map, java.lang.reflect.Type, java.lang.Object):java.util.Map");
    }

    /* renamed from: a */
    public static Object m2709a(DefaultJSONParser aVar, Map<Object, Object> map, Type type, Type type2, Object obj) {
        JSONLexer bVar = aVar.f2689d;
        if (bVar.mo11205a() == 12 || bVar.mo11205a() == 16) {
            ObjectDeserializer a = aVar.mo11146d().mo11292a(type);
            ObjectDeserializer a2 = aVar.mo11146d().mo11292a(type2);
            bVar.mo11211a(a.mo11162g_());
            ParseContext g = aVar.mo11149g();
            while (bVar.mo11205a() != 13) {
                try {
                    Object obj2 = null;
                    if (bVar.mo11205a() != 4 || !bVar.mo11239r() || bVar.mo11212a(Feature.DisableSpecialKeyDetect)) {
                        if (map.size() == 0 && bVar.mo11205a() == 4 && JSON.DEFAULT_TYPE_KEY.equals(bVar.mo11233l()) && !bVar.mo11212a(Feature.DisableSpecialKeyDetect)) {
                            bVar.mo11219c(4);
                            bVar.mo11211a(16);
                            if (bVar.mo11205a() == 13) {
                                bVar.mo11222d();
                                return map;
                            }
                            bVar.mo11211a(a.mo11162g_());
                        }
                        Object a3 = a.mo11161a(aVar, type, null);
                        if (bVar.mo11205a() == 17) {
                            bVar.mo11211a(a2.mo11162g_());
                            Object a4 = a2.mo11161a(aVar, type2, a3);
                            aVar.mo11141b(map, a3);
                            map.put(a3, a4);
                            if (bVar.mo11205a() == 16) {
                                bVar.mo11211a(a.mo11162g_());
                            }
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("syntax error, expect :, actual ");
                            sb.append(bVar.mo11205a());
                            throw new JSONException(sb.toString());
                        }
                    } else {
                        bVar.mo11219c(4);
                        if (bVar.mo11205a() == 4) {
                            String l = bVar.mo11233l();
                            if ("..".equals(l)) {
                                obj2 = g.f2795b.f2794a;
                            } else if ("$".equals(l)) {
                                ParseContext gVar = g;
                                while (gVar.f2795b != null) {
                                    gVar = gVar.f2795b;
                                }
                                obj2 = gVar.f2794a;
                            } else {
                                aVar.mo11123a(new C1261a(g, l));
                                aVar.mo11122a(1);
                            }
                            bVar.mo11211a(13);
                            if (bVar.mo11205a() == 13) {
                                bVar.mo11211a(16);
                                aVar.mo11125a(g);
                                return obj2;
                            }
                            throw new JSONException("illegal ref");
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("illegal ref, ");
                        sb2.append(JSONToken.m2903a(bVar.mo11205a()));
                        throw new JSONException(sb2.toString());
                    }
                } finally {
                    aVar.mo11125a(g);
                }
            }
            bVar.mo11211a(16);
            aVar.mo11125a(g);
            return map;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("syntax error, expect {, actual ");
        sb3.append(bVar.mo11214b());
        throw new JSONException(sb3.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Map<Object, Object> mo11201a(Type type) {
        if (type == Properties.class) {
            return new Properties();
        }
        if (type == Hashtable.class) {
            return new Hashtable();
        }
        if (type == IdentityHashMap.class) {
            return new IdentityHashMap();
        }
        if (type == SortedMap.class || type == TreeMap.class) {
            return new TreeMap();
        }
        if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
            return new ConcurrentHashMap();
        }
        if (type == Map.class || type == HashMap.class) {
            return new HashMap();
        }
        if (type == LinkedHashMap.class) {
            return new LinkedHashMap();
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            if (EnumMap.class.equals(rawType)) {
                return new EnumMap((Class) parameterizedType.getActualTypeArguments()[0]);
            }
            return mo11201a(rawType);
        }
        Class cls = (Class) type;
        String str = "unsupport type ";
        if (!cls.isInterface()) {
            try {
                return (Map) cls.newInstance();
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(type);
                throw new JSONException(sb.toString(), e);
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(type);
            throw new JSONException(sb2.toString());
        }
    }
}
