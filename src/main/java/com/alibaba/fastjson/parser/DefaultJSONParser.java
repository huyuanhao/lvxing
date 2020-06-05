package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.JSONPathException;
import com.alibaba.fastjson.parser.p066a.ExtraProcessable;
import com.alibaba.fastjson.parser.p066a.ExtraProcessor;
import com.alibaba.fastjson.parser.p066a.ExtraTypeProvider;
import com.alibaba.fastjson.parser.p066a.FieldDeserializer;
import com.alibaba.fastjson.parser.p066a.FieldTypeResolver;
import com.alibaba.fastjson.parser.p066a.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.p066a.ObjectDeserializer;
import com.alibaba.fastjson.parser.p066a.ResolveFieldDeserializer;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* renamed from: com.alibaba.fastjson.parser.a */
public class DefaultJSONParser implements Closeable {
    /* renamed from: h */
    private static final Set<Class<?>> f2685h = new HashSet();
    /* renamed from: a */
    public final Object f2686a;
    /* renamed from: b */
    public final SymbolTable f2687b;
    /* renamed from: c */
    protected ParserConfig f2688c;
    /* renamed from: d */
    public final JSONLexer f2689d;
    /* renamed from: e */
    protected ParseContext f2690e;
    /* renamed from: f */
    public int f2691f;
    /* renamed from: g */
    protected FieldTypeResolver f2692g;
    /* renamed from: i */
    private String f2693i;
    /* renamed from: j */
    private DateFormat f2694j;
    /* renamed from: k */
    private ParseContext[] f2695k;
    /* renamed from: l */
    private int f2696l;
    /* renamed from: m */
    private List<C1261a> f2697m;
    /* renamed from: n */
    private List<ExtraTypeProvider> f2698n;
    /* renamed from: o */
    private List<ExtraProcessor> f2699o;
    /* renamed from: p */
    private String[] f2700p;

    /* compiled from: DefaultJSONParser */
    /* renamed from: com.alibaba.fastjson.parser.a$a */
    public static class C1261a {
        /* renamed from: a */
        public final ParseContext f2701a;
        /* renamed from: b */
        public final String f2702b;
        /* renamed from: c */
        public FieldDeserializer f2703c;
        /* renamed from: d */
        public ParseContext f2704d;

        public C1261a(ParseContext gVar, String str) {
            this.f2701a = gVar;
            this.f2702b = str;
        }
    }

    static {
        for (Class add : new Class[]{Boolean.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, BigInteger.class, BigDecimal.class, String.class}) {
            f2685h.add(add);
        }
    }

    /* renamed from: a */
    public String mo11121a() {
        return this.f2693i;
    }

    /* renamed from: b */
    public DateFormat mo11138b() {
        if (this.f2694j == null) {
            this.f2694j = new SimpleDateFormat(this.f2693i, this.f2689d.mo11244w());
            this.f2694j.setTimeZone(this.f2689d.mo11243v());
        }
        return this.f2694j;
    }

    public DefaultJSONParser(String str, ParserConfig hVar) {
        this((Object) str, (JSONLexer) new JSONScanner(str, JSON.DEFAULT_PARSER_FEATURE), hVar);
    }

    public DefaultJSONParser(String str, ParserConfig hVar, int i) {
        this((Object) str, (JSONLexer) new JSONScanner(str, i), hVar);
    }

    public DefaultJSONParser(char[] cArr, int i, ParserConfig hVar, int i2) {
        this((Object) cArr, (JSONLexer) new JSONScanner(cArr, i, i2), hVar);
    }

    public DefaultJSONParser(Object obj, JSONLexer bVar, ParserConfig hVar) {
        this.f2693i = JSON.DEFFAULT_DATE_FORMAT;
        this.f2696l = 0;
        this.f2691f = 0;
        this.f2698n = null;
        this.f2699o = null;
        this.f2692g = null;
        this.f2700p = null;
        this.f2689d = bVar;
        this.f2686a = obj;
        this.f2688c = hVar;
        this.f2687b = hVar.f2805d;
        char e = bVar.mo11223e();
        if (e == '{') {
            bVar.mo11225f();
            ((JSONLexerBase) bVar).f2773a = 12;
        } else if (e == '[') {
            bVar.mo11225f();
            ((JSONLexerBase) bVar).f2773a = 14;
        } else {
            bVar.mo11222d();
        }
    }

    /* renamed from: c */
    public SymbolTable mo11142c() {
        return this.f2687b;
    }

    /* JADX WARNING: type inference failed for: r5v5, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r5v7, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r5v10, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r5v11, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r5v19, types: [com.alibaba.fastjson.JSONArray, java.util.Collection] */
    /* JADX WARNING: type inference failed for: r5v20, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r5v23, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r5v24, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r5v25, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r5v26 */
    /* JADX WARNING: type inference failed for: r5v28, types: [java.util.Date] */
    /* JADX WARNING: type inference failed for: r5v58 */
    /* JADX WARNING: type inference failed for: r5v59 */
    /* JADX WARNING: type inference failed for: r5v60 */
    /* JADX WARNING: type inference failed for: r5v61 */
    /* JADX WARNING: type inference failed for: r5v62 */
    /* JADX WARNING: type inference failed for: r5v63 */
    /* JADX WARNING: type inference failed for: r5v64 */
    /* JADX INFO: used method not loaded: com.alibaba.fastjson.parser.b.a(int):null, types can be incorrect */
    /* JADX INFO: used method not loaded: com.alibaba.fastjson.parser.a.n.a(com.alibaba.fastjson.parser.a, java.lang.reflect.Type):null, types can be incorrect */
    /* JADX INFO: used method not loaded: com.alibaba.fastjson.parser.a.k.a(java.lang.Object, java.lang.Object):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0242, code lost:
            r3.mo11211a(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x024d, code lost:
            if (r3.mo11205a() != 13) goto L_0x02b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x024f, code lost:
            r3.mo11211a(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:?, code lost:
            r0 = r1.f2688c.mo11292a((java.lang.reflect.Type) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x025a, code lost:
            if ((r0 instanceof com.alibaba.fastjson.parser.p066a.JavaBeanDeserializer) == false) goto L_0x028e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x025c, code lost:
            r0 = (com.alibaba.fastjson.parser.p066a.JavaBeanDeserializer) r0;
            r2 = r0.mo11186a(r1, (java.lang.reflect.Type) r6);
            r3 = r7.entrySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x026e, code lost:
            if (r3.hasNext() == false) goto L_0x028f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0270, code lost:
            r4 = (java.util.Map.Entry) r3.next();
            r7 = r4.getKey();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x027c, code lost:
            if ((r7 instanceof java.lang.String) == false) goto L_0x026a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x027e, code lost:
            r7 = r0.mo11181a((java.lang.String) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0284, code lost:
            if (r7 == null) goto L_0x026a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0286, code lost:
            r7.mo11177a(r2, r4.getValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x028e, code lost:
            r2 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x028f, code lost:
            if (r2 != null) goto L_0x02ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0293, code lost:
            if (r6 != java.lang.Cloneable.class) goto L_0x029b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0295, code lost:
            r2 = new java.util.HashMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x02a1, code lost:
            if ("java.util.Collections$EmptyMap".equals(r5) == false) goto L_0x02a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x02a3, code lost:
            r2 = java.util.Collections.emptyMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x02a8, code lost:
            r2 = r6.newInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x02ac, code lost:
            mo11125a(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x02af, code lost:
            return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x02b9, code lost:
            mo11122a(2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x02bf, code lost:
            if (r1.f2690e == null) goto L_0x02d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x02c1, code lost:
            if (r2 == null) goto L_0x02d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x02c5, code lost:
            if ((r2 instanceof java.lang.Integer) != false) goto L_0x02d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x02cd, code lost:
            if ((r1.f2690e.f2796c instanceof java.lang.Integer) != false) goto L_0x02d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x02cf, code lost:
            mo11154l();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x02d6, code lost:
            if (r17.size() <= 0) goto L_0x02e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x02d8, code lost:
            r0 = com.alibaba.fastjson.util.TypeUtils.m3222a((java.lang.Object) r0, r6, r1.f2688c);
            mo11127a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x02e1, code lost:
            mo11125a(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x02e4, code lost:
            return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:?, code lost:
            r0 = r1.f2688c.mo11292a((java.lang.reflect.Type) r6).mo11161a(r1, r6, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x02ef, code lost:
            mo11125a(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x02f2, code lost:
            return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0302, code lost:
            r3.mo11211a(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x030b, code lost:
            if (r3.mo11205a() != 4) goto L_0x039a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x030d, code lost:
            r0 = r3.mo11233l();
            r3.mo11211a(13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x031c, code lost:
            if ("@".equals(r0) == false) goto L_0x0338;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0320, code lost:
            if (r1.f2690e == null) goto L_0x0382;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0322, code lost:
            r0 = r1.f2690e;
            r5 = r0.f2794a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0328, code lost:
            if ((r5 instanceof java.lang.Object[]) != false) goto L_0x0383;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x032c, code lost:
            if ((r5 instanceof java.util.Collection) == false) goto L_0x032f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0331, code lost:
            if (r0.f2795b == null) goto L_0x0382;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0333, code lost:
            r5 = r0.f2795b.f2794a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x033e, code lost:
            if ("..".equals(r0) == false) goto L_0x0353;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0342, code lost:
            if (r10.f2794a == null) goto L_0x0347;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0344, code lost:
            r5 = r10.f2794a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0347, code lost:
            mo11123a(new com.alibaba.fastjson.parser.DefaultJSONParser.C1261a(r10, r0));
            mo11122a(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0359, code lost:
            if ("$".equals(r0) == false) goto L_0x0377;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x035b, code lost:
            r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x035e, code lost:
            if (r2.f2795b == null) goto L_0x0363;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0360, code lost:
            r2 = r2.f2795b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0365, code lost:
            if (r2.f2794a == null) goto L_0x036b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0367, code lost:
            r5 = r2.f2794a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x036b, code lost:
            mo11123a(new com.alibaba.fastjson.parser.DefaultJSONParser.C1261a(r2, r0));
            mo11122a(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0377, code lost:
            mo11123a(new com.alibaba.fastjson.parser.DefaultJSONParser.C1261a(r10, r0));
            mo11122a(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0382, code lost:
            r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0389, code lost:
            if (r3.mo11205a() != 13) goto L_0x0394;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x038b, code lost:
            r3.mo11211a(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x0390, code lost:
            mo11125a(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x0393, code lost:
            return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0399, code lost:
            throw new com.alibaba.fastjson.JSONException(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x039a, code lost:
            r2 = new java.lang.StringBuilder();
            r2.append("illegal ref, ");
            r2.append(com.alibaba.fastjson.parser.JSONToken.m2903a(r3.mo11205a()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x03b8, code lost:
            throw new com.alibaba.fastjson.JSONException(r2.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x044c, code lost:
            if (r6 != '}') goto L_0x045e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x044e, code lost:
            r3.mo11225f();
            r3.mo11228g();
            r3.mo11222d();
            mo11114a((java.lang.Object) r5, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x045a, code lost:
            mo11125a(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x045d, code lost:
            return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:?, code lost:
            r2 = new java.lang.StringBuilder();
            r2.append("syntax error, position at ");
            r2.append(r3.mo11230i());
            r2.append(r15);
            r2.append(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x047e, code lost:
            throw new com.alibaba.fastjson.JSONException(r2.toString());
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v26
  assigns: []
  uses: []
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
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01e8 A[Catch:{ Exception -> 0x02b0, NumberFormatException -> 0x017a, all -> 0x05bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x03bb A[Catch:{ Exception -> 0x02b0, NumberFormatException -> 0x017a, all -> 0x05bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x03e9 A[Catch:{ Exception -> 0x02b0, NumberFormatException -> 0x017a, all -> 0x05bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0412 A[Catch:{ Exception -> 0x02b0, NumberFormatException -> 0x017a, all -> 0x05bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0443 A[Catch:{ Exception -> 0x02b0, NumberFormatException -> 0x017a, all -> 0x05bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x0512 A[Catch:{ Exception -> 0x02b0, NumberFormatException -> 0x017a, all -> 0x05bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x051e A[Catch:{ Exception -> 0x02b0, NumberFormatException -> 0x017a, all -> 0x05bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x052a A[Catch:{ Exception -> 0x02b0, NumberFormatException -> 0x017a, all -> 0x05bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x053f A[SYNTHETIC, Splitter:B:318:0x053f] */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x0302 A[EDGE_INSN: B:347:0x0302->B:171:0x0302 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x0535 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:353:0x044c A[EDGE_INSN: B:353:0x044c->B:254:0x044c ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 8 */
    /* renamed from: a */
    public final java.lang.Object mo11120a(java.util.Map r17, java.lang.Object r18) {
        /*
        r16 = this;
        r1 = r16
        r0 = r17
        r2 = r18
        com.alibaba.fastjson.parser.b r3 = r1.f2689d
        int r4 = r3.mo11205a()
        r5 = 0
        r6 = 8
        if (r4 != r6) goto L_0x0015
        r3.mo11222d()
        return r5
    L_0x0015:
        int r4 = r3.mo11205a()
        r6 = 13
        if (r4 != r6) goto L_0x0021
        r3.mo11222d()
        return r0
    L_0x0021:
        int r4 = r3.mo11205a()
        r7 = 12
        r8 = 16
        if (r4 == r7) goto L_0x0059
        int r4 = r3.mo11205a()
        if (r4 != r8) goto L_0x0032
        goto L_0x0059
    L_0x0032:
        com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r4 = "syntax error, expect {, actual "
        r2.append(r4)
        java.lang.String r4 = r3.mo11214b()
        r2.append(r4)
        java.lang.String r4 = ", "
        r2.append(r4)
        java.lang.String r3 = r3.mo11245x()
        r2.append(r3)
        java.lang.String r2 = r2.toString()
        r0.m41526init(r2)
        throw r0
    L_0x0059:
        com.alibaba.fastjson.parser.g r4 = r1.f2690e
        boolean r7 = r0 instanceof com.alibaba.fastjson.JSONObject     // Catch:{ all -> 0x05c1 }
        if (r7 == 0) goto L_0x0067
        r7 = r0
        com.alibaba.fastjson.JSONObject r7 = (com.alibaba.fastjson.JSONObject) r7     // Catch:{ all -> 0x05c1 }
        java.util.Map r7 = r7.getInnerMap()     // Catch:{ all -> 0x05c1 }
        goto L_0x0068
    L_0x0067:
        r7 = r0
    L_0x0068:
        r10 = r4
        r4 = 0
    L_0x006a:
        r3.mo11218c()     // Catch:{ all -> 0x05bf }
        char r11 = r3.mo11223e()     // Catch:{ all -> 0x05bf }
        com.alibaba.fastjson.parser.Feature r12 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas     // Catch:{ all -> 0x05bf }
        boolean r12 = r3.mo11212a(r12)     // Catch:{ all -> 0x05bf }
        r13 = 44
        if (r12 == 0) goto L_0x0088
    L_0x007b:
        if (r11 != r13) goto L_0x0088
        r3.mo11225f()     // Catch:{ all -> 0x05bf }
        r3.mo11218c()     // Catch:{ all -> 0x05bf }
        char r11 = r3.mo11223e()     // Catch:{ all -> 0x05bf }
        goto L_0x007b
    L_0x0088:
        r14 = 125(0x7d, float:1.75E-43)
        java.lang.String r15 = ", name "
        java.lang.String r6 = "expect ':' at "
        r8 = 58
        r5 = 34
        java.lang.String r9 = "syntax error"
        r12 = 1
        if (r11 != r5) goto L_0x00c8
        com.alibaba.fastjson.parser.i r11 = r1.f2687b     // Catch:{ all -> 0x05bf }
        java.lang.String r11 = r3.mo11210a(r11, r5)     // Catch:{ all -> 0x05bf }
        r3.mo11218c()     // Catch:{ all -> 0x05bf }
        char r5 = r3.mo11223e()     // Catch:{ all -> 0x05bf }
        if (r5 != r8) goto L_0x00a9
    L_0x00a6:
        r5 = 0
        goto L_0x01e6
    L_0x00a9:
        com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x05bf }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x05bf }
        r2.<init>()     // Catch:{ all -> 0x05bf }
        r2.append(r6)     // Catch:{ all -> 0x05bf }
        int r3 = r3.mo11230i()     // Catch:{ all -> 0x05bf }
        r2.append(r3)     // Catch:{ all -> 0x05bf }
        r2.append(r15)     // Catch:{ all -> 0x05bf }
        r2.append(r11)     // Catch:{ all -> 0x05bf }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x05bf }
        r0.m41526init(r2)     // Catch:{ all -> 0x05bf }
        throw r0     // Catch:{ all -> 0x05bf }
    L_0x00c8:
        if (r11 != r14) goto L_0x00f3
        r3.mo11225f()     // Catch:{ all -> 0x05bf }
        r3.mo11228g()     // Catch:{ all -> 0x05bf }
        r3.mo11222d()     // Catch:{ all -> 0x05bf }
        if (r4 != 0) goto L_0x00ef
        com.alibaba.fastjson.parser.g r3 = r1.f2690e     // Catch:{ all -> 0x05bf }
        if (r3 == 0) goto L_0x00e8
        com.alibaba.fastjson.parser.g r3 = r1.f2690e     // Catch:{ all -> 0x05bf }
        java.lang.Object r3 = r3.f2796c     // Catch:{ all -> 0x05bf }
        if (r2 != r3) goto L_0x00e8
        com.alibaba.fastjson.parser.g r3 = r1.f2690e     // Catch:{ all -> 0x05bf }
        java.lang.Object r3 = r3.f2794a     // Catch:{ all -> 0x05bf }
        if (r0 != r3) goto L_0x00e8
        com.alibaba.fastjson.parser.g r10 = r1.f2690e     // Catch:{ all -> 0x05bf }
        goto L_0x00ef
    L_0x00e8:
        com.alibaba.fastjson.parser.g r2 = r16.mo11114a(r17, r18)     // Catch:{ all -> 0x05bf }
        if (r10 != 0) goto L_0x00ef
        r10 = r2
    L_0x00ef:
        r1.mo11125a(r10)
        return r0
    L_0x00f3:
        r5 = 39
        if (r11 != r5) goto L_0x012e
        com.alibaba.fastjson.parser.Feature r11 = com.alibaba.fastjson.parser.Feature.AllowSingleQuotes     // Catch:{ all -> 0x05bf }
        boolean r11 = r3.mo11212a(r11)     // Catch:{ all -> 0x05bf }
        if (r11 == 0) goto L_0x0128
        com.alibaba.fastjson.parser.i r11 = r1.f2687b     // Catch:{ all -> 0x05bf }
        java.lang.String r11 = r3.mo11210a(r11, r5)     // Catch:{ all -> 0x05bf }
        r3.mo11218c()     // Catch:{ all -> 0x05bf }
        char r5 = r3.mo11223e()     // Catch:{ all -> 0x05bf }
        if (r5 != r8) goto L_0x010f
        goto L_0x00a6
    L_0x010f:
        com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x05bf }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x05bf }
        r2.<init>()     // Catch:{ all -> 0x05bf }
        r2.append(r6)     // Catch:{ all -> 0x05bf }
        int r3 = r3.mo11230i()     // Catch:{ all -> 0x05bf }
        r2.append(r3)     // Catch:{ all -> 0x05bf }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x05bf }
        r0.m41526init(r2)     // Catch:{ all -> 0x05bf }
        throw r0     // Catch:{ all -> 0x05bf }
    L_0x0128:
        com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x05bf }
        r0.m41526init(r9)     // Catch:{ all -> 0x05bf }
        throw r0     // Catch:{ all -> 0x05bf }
    L_0x012e:
        r5 = 26
        if (r11 == r5) goto L_0x05b9
        if (r11 == r13) goto L_0x05b3
        r5 = 48
        if (r11 < r5) goto L_0x013c
        r5 = 57
        if (r11 <= r5) goto L_0x0140
    L_0x013c:
        r5 = 45
        if (r11 != r5) goto L_0x0195
    L_0x0140:
        r3.mo11228g()     // Catch:{ all -> 0x05bf }
        r3.mo11229h()     // Catch:{ all -> 0x05bf }
        int r5 = r3.mo11205a()     // Catch:{ NumberFormatException -> 0x017a }
        r6 = 2
        if (r5 != r6) goto L_0x0152
        java.lang.Number r5 = r3.mo11231j()     // Catch:{ NumberFormatException -> 0x017a }
        goto L_0x0156
    L_0x0152:
        java.lang.Number r5 = r3.mo11208a(r12)     // Catch:{ NumberFormatException -> 0x017a }
    L_0x0156:
        r11 = r5
        char r5 = r3.mo11223e()     // Catch:{ all -> 0x05bf }
        if (r5 != r8) goto L_0x015f
        goto L_0x00a6
    L_0x015f:
        com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x05bf }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x05bf }
        r2.<init>()     // Catch:{ all -> 0x05bf }
        java.lang.String r4 = "parse number key error"
        r2.append(r4)     // Catch:{ all -> 0x05bf }
        java.lang.String r3 = r3.mo11245x()     // Catch:{ all -> 0x05bf }
        r2.append(r3)     // Catch:{ all -> 0x05bf }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x05bf }
        r0.m41526init(r2)     // Catch:{ all -> 0x05bf }
        throw r0     // Catch:{ all -> 0x05bf }
    L_0x017a:
        com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x05bf }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x05bf }
        r2.<init>()     // Catch:{ all -> 0x05bf }
        java.lang.String r4 = "parse number key error"
        r2.append(r4)     // Catch:{ all -> 0x05bf }
        java.lang.String r3 = r3.mo11245x()     // Catch:{ all -> 0x05bf }
        r2.append(r3)     // Catch:{ all -> 0x05bf }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x05bf }
        r0.m41526init(r2)     // Catch:{ all -> 0x05bf }
        throw r0     // Catch:{ all -> 0x05bf }
    L_0x0195:
        r5 = 123(0x7b, float:1.72E-43)
        if (r11 == r5) goto L_0x01de
        r5 = 91
        if (r11 != r5) goto L_0x019e
        goto L_0x01de
    L_0x019e:
        com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.AllowUnQuotedFieldNames     // Catch:{ all -> 0x05bf }
        boolean r5 = r3.mo11212a(r5)     // Catch:{ all -> 0x05bf }
        if (r5 == 0) goto L_0x01d8
        com.alibaba.fastjson.parser.i r5 = r1.f2687b     // Catch:{ all -> 0x05bf }
        java.lang.String r11 = r3.mo11215b(r5)     // Catch:{ all -> 0x05bf }
        r3.mo11218c()     // Catch:{ all -> 0x05bf }
        char r5 = r3.mo11223e()     // Catch:{ all -> 0x05bf }
        if (r5 != r8) goto L_0x01b7
        goto L_0x00a6
    L_0x01b7:
        com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x05bf }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x05bf }
        r2.<init>()     // Catch:{ all -> 0x05bf }
        r2.append(r6)     // Catch:{ all -> 0x05bf }
        int r3 = r3.mo11230i()     // Catch:{ all -> 0x05bf }
        r2.append(r3)     // Catch:{ all -> 0x05bf }
        java.lang.String r3 = ", actual "
        r2.append(r3)     // Catch:{ all -> 0x05bf }
        r2.append(r5)     // Catch:{ all -> 0x05bf }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x05bf }
        r0.m41526init(r2)     // Catch:{ all -> 0x05bf }
        throw r0     // Catch:{ all -> 0x05bf }
    L_0x01d8:
        com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x05bf }
        r0.m41526init(r9)     // Catch:{ all -> 0x05bf }
        throw r0     // Catch:{ all -> 0x05bf }
    L_0x01de:
        r3.mo11222d()     // Catch:{ all -> 0x05bf }
        java.lang.Object r11 = r16.mo11155m()     // Catch:{ all -> 0x05bf }
        r5 = 1
    L_0x01e6:
        if (r5 != 0) goto L_0x01ee
        r3.mo11225f()     // Catch:{ all -> 0x05bf }
        r3.mo11218c()     // Catch:{ all -> 0x05bf }
    L_0x01ee:
        char r5 = r3.mo11223e()     // Catch:{ all -> 0x05bf }
        r3.mo11228g()     // Catch:{ all -> 0x05bf }
        java.lang.String r6 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x05bf }
        if (r11 != r6) goto L_0x02f3
        com.alibaba.fastjson.parser.Feature r6 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x05bf }
        boolean r6 = r3.mo11212a(r6)     // Catch:{ all -> 0x05bf }
        if (r6 != 0) goto L_0x02f3
        com.alibaba.fastjson.parser.i r5 = r1.f2687b     // Catch:{ all -> 0x05bf }
        r6 = 34
        java.lang.String r5 = r3.mo11210a(r5, r6)     // Catch:{ all -> 0x05bf }
        com.alibaba.fastjson.parser.Feature r6 = com.alibaba.fastjson.parser.Feature.IgnoreAutoType     // Catch:{ all -> 0x05bf }
        boolean r6 = r3.mo11212a(r6)     // Catch:{ all -> 0x05bf }
        if (r6 == 0) goto L_0x0213
        r9 = 0
        goto L_0x023b
    L_0x0213:
        if (r0 == 0) goto L_0x0229
        java.lang.Class r6 = r17.getClass()     // Catch:{ all -> 0x05bf }
        java.lang.String r6 = r6.getName()     // Catch:{ all -> 0x05bf }
        boolean r6 = r6.equals(r5)     // Catch:{ all -> 0x05bf }
        if (r6 == 0) goto L_0x0229
        java.lang.Class r6 = r17.getClass()     // Catch:{ all -> 0x05bf }
        r9 = 0
        goto L_0x0234
    L_0x0229:
        com.alibaba.fastjson.parser.h r6 = r1.f2688c     // Catch:{ all -> 0x05bf }
        int r8 = r3.mo11246y()     // Catch:{ all -> 0x05bf }
        r9 = 0
        java.lang.Class r6 = r6.mo11294a(r5, r9, r8)     // Catch:{ all -> 0x05bf }
    L_0x0234:
        if (r6 != 0) goto L_0x0242
        java.lang.String r6 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x05bf }
        r7.put(r6, r5)     // Catch:{ all -> 0x05bf }
    L_0x023b:
        r5 = r9
        r6 = 13
        r8 = 16
        goto L_0x006a
    L_0x0242:
        r4 = 16
        r3.mo11211a(r4)     // Catch:{ all -> 0x05bf }
        int r8 = r3.mo11205a()     // Catch:{ all -> 0x05bf }
        r11 = 13
        if (r8 != r11) goto L_0x02b9
        r3.mo11211a(r4)     // Catch:{ all -> 0x05bf }
        com.alibaba.fastjson.parser.h r0 = r1.f2688c     // Catch:{ Exception -> 0x02b0 }
        com.alibaba.fastjson.parser.a.s r0 = r0.mo11292a(r6)     // Catch:{ Exception -> 0x02b0 }
        boolean r2 = r0 instanceof com.alibaba.fastjson.parser.p066a.JavaBeanDeserializer     // Catch:{ Exception -> 0x02b0 }
        if (r2 == 0) goto L_0x028e
        com.alibaba.fastjson.parser.a.n r0 = (com.alibaba.fastjson.parser.p066a.JavaBeanDeserializer) r0     // Catch:{ Exception -> 0x02b0 }
        java.lang.Object r2 = r0.mo11186a(r1, r6)     // Catch:{ Exception -> 0x02b0 }
        java.util.Set r3 = r7.entrySet()     // Catch:{ Exception -> 0x02b0 }
        java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x02b0 }
    L_0x026a:
        boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x02b0 }
        if (r4 == 0) goto L_0x028f
        java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x02b0 }
        java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ Exception -> 0x02b0 }
        java.lang.Object r7 = r4.getKey()     // Catch:{ Exception -> 0x02b0 }
        boolean r8 = r7 instanceof java.lang.String     // Catch:{ Exception -> 0x02b0 }
        if (r8 == 0) goto L_0x026a
        java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x02b0 }
        com.alibaba.fastjson.parser.a.k r7 = r0.mo11181a(r7)     // Catch:{ Exception -> 0x02b0 }
        if (r7 == 0) goto L_0x026a
        java.lang.Object r4 = r4.getValue()     // Catch:{ Exception -> 0x02b0 }
        r7.mo11177a(r2, r4)     // Catch:{ Exception -> 0x02b0 }
        goto L_0x026a
    L_0x028e:
        r2 = r9
    L_0x028f:
        if (r2 != 0) goto L_0x02ac
        java.lang.Class<java.lang.Cloneable> r0 = java.lang.Cloneable.class
        if (r6 != r0) goto L_0x029b
        java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x02b0 }
        r2.<init>()     // Catch:{ Exception -> 0x02b0 }
        goto L_0x02ac
    L_0x029b:
        java.lang.String r0 = "java.util.Collections$EmptyMap"
        boolean r0 = r0.equals(r5)     // Catch:{ Exception -> 0x02b0 }
        if (r0 == 0) goto L_0x02a8
        java.util.Map r2 = java.util.Collections.emptyMap()     // Catch:{ Exception -> 0x02b0 }
        goto L_0x02ac
    L_0x02a8:
        java.lang.Object r2 = r6.newInstance()     // Catch:{ Exception -> 0x02b0 }
    L_0x02ac:
        r1.mo11125a(r10)
        return r2
    L_0x02b0:
        r0 = move-exception
        com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x05bf }
        java.lang.String r3 = "create instance error"
        r2.m41527init(r3, r0)     // Catch:{ all -> 0x05bf }
        throw r2     // Catch:{ all -> 0x05bf }
    L_0x02b9:
        r3 = 2
        r1.mo11122a(r3)     // Catch:{ all -> 0x05bf }
        com.alibaba.fastjson.parser.g r3 = r1.f2690e     // Catch:{ all -> 0x05bf }
        if (r3 == 0) goto L_0x02d2
        if (r2 == 0) goto L_0x02d2
        boolean r3 = r2 instanceof java.lang.Integer     // Catch:{ all -> 0x05bf }
        if (r3 != 0) goto L_0x02d2
        com.alibaba.fastjson.parser.g r3 = r1.f2690e     // Catch:{ all -> 0x05bf }
        java.lang.Object r3 = r3.f2796c     // Catch:{ all -> 0x05bf }
        boolean r3 = r3 instanceof java.lang.Integer     // Catch:{ all -> 0x05bf }
        if (r3 != 0) goto L_0x02d2
        r16.mo11154l()     // Catch:{ all -> 0x05bf }
    L_0x02d2:
        int r3 = r17.size()     // Catch:{ all -> 0x05bf }
        if (r3 <= 0) goto L_0x02e5
        com.alibaba.fastjson.parser.h r2 = r1.f2688c     // Catch:{ all -> 0x05bf }
        java.lang.Object r0 = com.alibaba.fastjson.util.TypeUtils.m3222a(r0, r6, r2)     // Catch:{ all -> 0x05bf }
        r1.mo11127a(r0)     // Catch:{ all -> 0x05bf }
        r1.mo11125a(r10)
        return r0
    L_0x02e5:
        com.alibaba.fastjson.parser.h r0 = r1.f2688c     // Catch:{ all -> 0x05bf }
        com.alibaba.fastjson.parser.a.s r0 = r0.mo11292a(r6)     // Catch:{ all -> 0x05bf }
        java.lang.Object r0 = r0.mo11161a(r1, r6, r2)     // Catch:{ all -> 0x05bf }
        r1.mo11125a(r10)
        return r0
    L_0x02f3:
        r6 = 0
        java.lang.String r8 = "$ref"
        if (r11 != r8) goto L_0x03b9
        if (r10 == 0) goto L_0x03b9
        com.alibaba.fastjson.parser.Feature r8 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x05bf }
        boolean r8 = r3.mo11212a(r8)     // Catch:{ all -> 0x05bf }
        if (r8 != 0) goto L_0x03b9
        r0 = 4
        r3.mo11211a(r0)     // Catch:{ all -> 0x05bf }
        int r0 = r3.mo11205a()     // Catch:{ all -> 0x05bf }
        r2 = 4
        if (r0 != r2) goto L_0x039a
        java.lang.String r0 = r3.mo11233l()     // Catch:{ all -> 0x05bf }
        r2 = 13
        r3.mo11211a(r2)     // Catch:{ all -> 0x05bf }
        java.lang.String r2 = "@"
        boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x05bf }
        if (r2 == 0) goto L_0x0338
        com.alibaba.fastjson.parser.g r0 = r1.f2690e     // Catch:{ all -> 0x05bf }
        if (r0 == 0) goto L_0x0382
        com.alibaba.fastjson.parser.g r0 = r1.f2690e     // Catch:{ all -> 0x05bf }
        java.lang.Object r5 = r0.f2794a     // Catch:{ all -> 0x05bf }
        boolean r2 = r5 instanceof java.lang.Object[]     // Catch:{ all -> 0x05bf }
        if (r2 != 0) goto L_0x0383
        boolean r2 = r5 instanceof java.util.Collection     // Catch:{ all -> 0x05bf }
        if (r2 == 0) goto L_0x032f
        goto L_0x0383
    L_0x032f:
        com.alibaba.fastjson.parser.g r2 = r0.f2795b     // Catch:{ all -> 0x05bf }
        if (r2 == 0) goto L_0x0382
        com.alibaba.fastjson.parser.g r0 = r0.f2795b     // Catch:{ all -> 0x05bf }
        java.lang.Object r5 = r0.f2794a     // Catch:{ all -> 0x05bf }
        goto L_0x0383
    L_0x0338:
        java.lang.String r2 = ".."
        boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x05bf }
        if (r2 == 0) goto L_0x0353
        java.lang.Object r2 = r10.f2794a     // Catch:{ all -> 0x05bf }
        if (r2 == 0) goto L_0x0347
        java.lang.Object r5 = r10.f2794a     // Catch:{ all -> 0x05bf }
        goto L_0x0383
    L_0x0347:
        com.alibaba.fastjson.parser.a$a r2 = new com.alibaba.fastjson.parser.a$a     // Catch:{ all -> 0x05bf }
        r2.m41597init(r10, r0)     // Catch:{ all -> 0x05bf }
        r1.mo11123a(r2)     // Catch:{ all -> 0x05bf }
        r1.mo11122a(r12)     // Catch:{ all -> 0x05bf }
        goto L_0x0382
    L_0x0353:
        java.lang.String r2 = "$"
        boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x05bf }
        if (r2 == 0) goto L_0x0377
        r2 = r10
    L_0x035c:
        com.alibaba.fastjson.parser.g r4 = r2.f2795b     // Catch:{ all -> 0x05bf }
        if (r4 == 0) goto L_0x0363
        com.alibaba.fastjson.parser.g r2 = r2.f2795b     // Catch:{ all -> 0x05bf }
        goto L_0x035c
    L_0x0363:
        java.lang.Object r4 = r2.f2794a     // Catch:{ all -> 0x05bf }
        if (r4 == 0) goto L_0x036b
        java.lang.Object r0 = r2.f2794a     // Catch:{ all -> 0x05bf }
        r5 = r0
        goto L_0x0383
    L_0x036b:
        com.alibaba.fastjson.parser.a$a r4 = new com.alibaba.fastjson.parser.a$a     // Catch:{ all -> 0x05bf }
        r4.m41597init(r2, r0)     // Catch:{ all -> 0x05bf }
        r1.mo11123a(r4)     // Catch:{ all -> 0x05bf }
        r1.mo11122a(r12)     // Catch:{ all -> 0x05bf }
        goto L_0x0382
    L_0x0377:
        com.alibaba.fastjson.parser.a$a r2 = new com.alibaba.fastjson.parser.a$a     // Catch:{ all -> 0x05bf }
        r2.m41597init(r10, r0)     // Catch:{ all -> 0x05bf }
        r1.mo11123a(r2)     // Catch:{ all -> 0x05bf }
        r1.mo11122a(r12)     // Catch:{ all -> 0x05bf }
    L_0x0382:
        r5 = r6
    L_0x0383:
        int r0 = r3.mo11205a()     // Catch:{ all -> 0x05bf }
        r2 = 13
        if (r0 != r2) goto L_0x0394
        r0 = 16
        r3.mo11211a(r0)     // Catch:{ all -> 0x05bf }
        r1.mo11125a(r10)
        return r5
    L_0x0394:
        com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x05bf }
        r0.m41526init(r9)     // Catch:{ all -> 0x05bf }
        throw r0     // Catch:{ all -> 0x05bf }
    L_0x039a:
        com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x05bf }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x05bf }
        r2.<init>()     // Catch:{ all -> 0x05bf }
        java.lang.String r4 = "illegal ref, "
        r2.append(r4)     // Catch:{ all -> 0x05bf }
        int r3 = r3.mo11205a()     // Catch:{ all -> 0x05bf }
        java.lang.String r3 = com.alibaba.fastjson.parser.JSONToken.m2903a(r3)     // Catch:{ all -> 0x05bf }
        r2.append(r3)     // Catch:{ all -> 0x05bf }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x05bf }
        r0.m41526init(r2)     // Catch:{ all -> 0x05bf }
        throw r0     // Catch:{ all -> 0x05bf }
    L_0x03b9:
        if (r4 != 0) goto L_0x03d9
        com.alibaba.fastjson.parser.g r8 = r1.f2690e     // Catch:{ all -> 0x05bf }
        if (r8 == 0) goto L_0x03cf
        com.alibaba.fastjson.parser.g r8 = r1.f2690e     // Catch:{ all -> 0x05bf }
        java.lang.Object r8 = r8.f2796c     // Catch:{ all -> 0x05bf }
        if (r2 != r8) goto L_0x03cf
        com.alibaba.fastjson.parser.g r8 = r1.f2690e     // Catch:{ all -> 0x05bf }
        java.lang.Object r8 = r8.f2794a     // Catch:{ all -> 0x05bf }
        if (r0 != r8) goto L_0x03cf
        com.alibaba.fastjson.parser.g r8 = r1.f2690e     // Catch:{ all -> 0x05bf }
        r10 = r8
        goto L_0x03d9
    L_0x03cf:
        com.alibaba.fastjson.parser.g r4 = r16.mo11114a(r17, r18)     // Catch:{ all -> 0x05bf }
        if (r10 != 0) goto L_0x03d6
        goto L_0x03d7
    L_0x03d6:
        r4 = r10
    L_0x03d7:
        r10 = r4
        r4 = 1
    L_0x03d9:
        java.lang.Class r8 = r17.getClass()     // Catch:{ all -> 0x05bf }
        java.lang.Class<com.alibaba.fastjson.JSONObject> r6 = com.alibaba.fastjson.JSONObject.class
        if (r8 != r6) goto L_0x03e5
        if (r11 != 0) goto L_0x03e5
        java.lang.String r11 = "null"
    L_0x03e5:
        r6 = 34
        if (r5 != r6) goto L_0x0412
        r3.mo11234m()     // Catch:{ all -> 0x05bf }
        java.lang.String r5 = r3.mo11233l()     // Catch:{ all -> 0x05bf }
        com.alibaba.fastjson.parser.Feature r6 = com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat     // Catch:{ all -> 0x05bf }
        boolean r6 = r3.mo11212a(r6)     // Catch:{ all -> 0x05bf }
        if (r6 == 0) goto L_0x040e
        com.alibaba.fastjson.parser.e r6 = new com.alibaba.fastjson.parser.e     // Catch:{ all -> 0x05bf }
        r6.m41636init(r5)     // Catch:{ all -> 0x05bf }
        boolean r8 = r6.mo11284K()     // Catch:{ all -> 0x05bf }
        if (r8 == 0) goto L_0x040b
        java.util.Calendar r5 = r6.mo11251E()     // Catch:{ all -> 0x05bf }
        java.util.Date r5 = r5.getTime()     // Catch:{ all -> 0x05bf }
    L_0x040b:
        r6.close()     // Catch:{ all -> 0x05bf }
    L_0x040e:
        r7.put(r11, r5)     // Catch:{ all -> 0x05bf }
        goto L_0x043a
    L_0x0412:
        r6 = 48
        if (r5 < r6) goto L_0x041a
        r6 = 57
        if (r5 <= r6) goto L_0x041e
    L_0x041a:
        r6 = 45
        if (r5 != r6) goto L_0x047f
    L_0x041e:
        r3.mo11229h()     // Catch:{ all -> 0x05bf }
        int r5 = r3.mo11205a()     // Catch:{ all -> 0x05bf }
        r6 = 2
        if (r5 != r6) goto L_0x042d
        java.lang.Number r5 = r3.mo11231j()     // Catch:{ all -> 0x05bf }
        goto L_0x0437
    L_0x042d:
        com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.UseBigDecimal     // Catch:{ all -> 0x05bf }
        boolean r5 = r3.mo11212a(r5)     // Catch:{ all -> 0x05bf }
        java.lang.Number r5 = r3.mo11208a(r5)     // Catch:{ all -> 0x05bf }
    L_0x0437:
        r7.put(r11, r5)     // Catch:{ all -> 0x05bf }
    L_0x043a:
        r3.mo11218c()     // Catch:{ all -> 0x05bf }
        char r6 = r3.mo11223e()     // Catch:{ all -> 0x05bf }
        if (r6 != r13) goto L_0x044c
        r3.mo11225f()     // Catch:{ all -> 0x05bf }
    L_0x0446:
        r6 = 13
        r8 = 16
        goto L_0x058f
    L_0x044c:
        if (r6 != r14) goto L_0x045e
        r3.mo11225f()     // Catch:{ all -> 0x05bf }
        r3.mo11228g()     // Catch:{ all -> 0x05bf }
        r3.mo11222d()     // Catch:{ all -> 0x05bf }
        r1.mo11114a(r5, r11)     // Catch:{ all -> 0x05bf }
        r1.mo11125a(r10)
        return r0
    L_0x045e:
        com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x05bf }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x05bf }
        r2.<init>()     // Catch:{ all -> 0x05bf }
        java.lang.String r4 = "syntax error, position at "
        r2.append(r4)     // Catch:{ all -> 0x05bf }
        int r3 = r3.mo11230i()     // Catch:{ all -> 0x05bf }
        r2.append(r3)     // Catch:{ all -> 0x05bf }
        r2.append(r15)     // Catch:{ all -> 0x05bf }
        r2.append(r11)     // Catch:{ all -> 0x05bf }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x05bf }
        r0.m41526init(r2)     // Catch:{ all -> 0x05bf }
        throw r0     // Catch:{ all -> 0x05bf }
    L_0x047f:
        r6 = 91
        if (r5 != r6) goto L_0x04c8
        r3.mo11222d()     // Catch:{ all -> 0x05bf }
        com.alibaba.fastjson.JSONArray r5 = new com.alibaba.fastjson.JSONArray     // Catch:{ all -> 0x05bf }
        r5.m41522init()     // Catch:{ all -> 0x05bf }
        if (r2 == 0) goto L_0x0493
        java.lang.Class r6 = r18.getClass()     // Catch:{ all -> 0x05bf }
        java.lang.Class<java.lang.Integer> r8 = java.lang.Integer.class
    L_0x0493:
        if (r2 != 0) goto L_0x0498
        r1.mo11125a(r10)     // Catch:{ all -> 0x05bf }
    L_0x0498:
        r1.mo11133a(r5, r11)     // Catch:{ all -> 0x05bf }
        com.alibaba.fastjson.parser.Feature r6 = com.alibaba.fastjson.parser.Feature.UseObjectArray     // Catch:{ all -> 0x05bf }
        boolean r6 = r3.mo11212a(r6)     // Catch:{ all -> 0x05bf }
        if (r6 == 0) goto L_0x04a7
        java.lang.Object[] r5 = r5.toArray()     // Catch:{ all -> 0x05bf }
    L_0x04a7:
        r7.put(r11, r5)     // Catch:{ all -> 0x05bf }
        int r5 = r3.mo11205a()     // Catch:{ all -> 0x05bf }
        r6 = 13
        if (r5 != r6) goto L_0x04b9
        r3.mo11222d()     // Catch:{ all -> 0x05bf }
        r1.mo11125a(r10)
        return r0
    L_0x04b9:
        int r5 = r3.mo11205a()     // Catch:{ all -> 0x05bf }
        r6 = 16
        if (r5 != r6) goto L_0x04c2
        goto L_0x0446
    L_0x04c2:
        com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x05bf }
        r0.m41526init(r9)     // Catch:{ all -> 0x05bf }
        throw r0     // Catch:{ all -> 0x05bf }
    L_0x04c8:
        r6 = 123(0x7b, float:1.72E-43)
        if (r5 != r6) goto L_0x056e
        r3.mo11222d()     // Catch:{ all -> 0x05bf }
        if (r2 == 0) goto L_0x04db
        java.lang.Class r5 = r18.getClass()     // Catch:{ all -> 0x05bf }
        java.lang.Class<java.lang.Integer> r6 = java.lang.Integer.class
        if (r5 != r6) goto L_0x04db
        r5 = 1
        goto L_0x04dc
    L_0x04db:
        r5 = 0
    L_0x04dc:
        com.alibaba.fastjson.JSONObject r6 = new com.alibaba.fastjson.JSONObject     // Catch:{ all -> 0x05bf }
        com.alibaba.fastjson.parser.Feature r8 = com.alibaba.fastjson.parser.Feature.OrderedField     // Catch:{ all -> 0x05bf }
        boolean r8 = r3.mo11212a(r8)     // Catch:{ all -> 0x05bf }
        r6.m41532init(r8)     // Catch:{ all -> 0x05bf }
        if (r5 != 0) goto L_0x04ee
        com.alibaba.fastjson.parser.g r8 = r1.mo11113a(r10, r6, r11)     // Catch:{ all -> 0x05bf }
        goto L_0x04ef
    L_0x04ee:
        r8 = 0
    L_0x04ef:
        com.alibaba.fastjson.parser.a.l r9 = r1.f2692g     // Catch:{ all -> 0x05bf }
        if (r9 == 0) goto L_0x050e
        if (r11 == 0) goto L_0x04fa
        java.lang.String r9 = r11.toString()     // Catch:{ all -> 0x05bf }
        goto L_0x04fb
    L_0x04fa:
        r9 = 0
    L_0x04fb:
        com.alibaba.fastjson.parser.a.l r13 = r1.f2692g     // Catch:{ all -> 0x05bf }
        java.lang.reflect.Type r9 = r13.mo11180a(r0, r9)     // Catch:{ all -> 0x05bf }
        if (r9 == 0) goto L_0x050e
        com.alibaba.fastjson.parser.h r13 = r1.f2688c     // Catch:{ all -> 0x05bf }
        com.alibaba.fastjson.parser.a.s r13 = r13.mo11292a(r9)     // Catch:{ all -> 0x05bf }
        java.lang.Object r9 = r13.mo11161a(r1, r9, r11)     // Catch:{ all -> 0x05bf }
        goto L_0x0510
    L_0x050e:
        r9 = 0
        r12 = 0
    L_0x0510:
        if (r12 != 0) goto L_0x0516
        java.lang.Object r9 = r1.mo11120a(r6, r11)     // Catch:{ all -> 0x05bf }
    L_0x0516:
        if (r8 == 0) goto L_0x051c
        if (r6 == r9) goto L_0x051c
        r8.f2794a = r0     // Catch:{ all -> 0x05bf }
    L_0x051c:
        if (r11 == 0) goto L_0x0525
        java.lang.String r6 = r11.toString()     // Catch:{ all -> 0x05bf }
        r1.mo11141b(r0, r6)     // Catch:{ all -> 0x05bf }
    L_0x0525:
        r7.put(r11, r9)     // Catch:{ all -> 0x05bf }
        if (r5 == 0) goto L_0x052d
        r1.mo11114a(r9, r11)     // Catch:{ all -> 0x05bf }
    L_0x052d:
        int r6 = r3.mo11205a()     // Catch:{ all -> 0x05bf }
        r8 = 13
        if (r6 != r8) goto L_0x053f
        r3.mo11222d()     // Catch:{ all -> 0x05bf }
        r1.mo11125a(r10)     // Catch:{ all -> 0x05bf }
        r1.mo11125a(r10)
        return r0
    L_0x053f:
        int r6 = r3.mo11205a()     // Catch:{ all -> 0x05bf }
        r8 = 16
        if (r6 != r8) goto L_0x0553
        if (r5 == 0) goto L_0x054e
        r16.mo11154l()     // Catch:{ all -> 0x05bf }
        goto L_0x0446
    L_0x054e:
        r1.mo11125a(r10)     // Catch:{ all -> 0x05bf }
        goto L_0x0446
    L_0x0553:
        com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x05bf }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x05bf }
        r2.<init>()     // Catch:{ all -> 0x05bf }
        java.lang.String r4 = "syntax error, "
        r2.append(r4)     // Catch:{ all -> 0x05bf }
        java.lang.String r3 = r3.mo11214b()     // Catch:{ all -> 0x05bf }
        r2.append(r3)     // Catch:{ all -> 0x05bf }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x05bf }
        r0.m41526init(r2)     // Catch:{ all -> 0x05bf }
        throw r0     // Catch:{ all -> 0x05bf }
    L_0x056e:
        r3.mo11222d()     // Catch:{ all -> 0x05bf }
        java.lang.Object r5 = r16.mo11155m()     // Catch:{ all -> 0x05bf }
        r7.put(r11, r5)     // Catch:{ all -> 0x05bf }
        int r5 = r3.mo11205a()     // Catch:{ all -> 0x05bf }
        r6 = 13
        if (r5 != r6) goto L_0x0587
        r3.mo11222d()     // Catch:{ all -> 0x05bf }
        r1.mo11125a(r10)
        return r0
    L_0x0587:
        int r5 = r3.mo11205a()     // Catch:{ all -> 0x05bf }
        r8 = 16
        if (r5 != r8) goto L_0x0592
    L_0x058f:
        r5 = 0
        goto L_0x006a
    L_0x0592:
        com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x05bf }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x05bf }
        r2.<init>()     // Catch:{ all -> 0x05bf }
        java.lang.String r4 = "syntax error, position at "
        r2.append(r4)     // Catch:{ all -> 0x05bf }
        int r3 = r3.mo11230i()     // Catch:{ all -> 0x05bf }
        r2.append(r3)     // Catch:{ all -> 0x05bf }
        r2.append(r15)     // Catch:{ all -> 0x05bf }
        r2.append(r11)     // Catch:{ all -> 0x05bf }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x05bf }
        r0.m41526init(r2)     // Catch:{ all -> 0x05bf }
        throw r0     // Catch:{ all -> 0x05bf }
    L_0x05b3:
        com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x05bf }
        r0.m41526init(r9)     // Catch:{ all -> 0x05bf }
        throw r0     // Catch:{ all -> 0x05bf }
    L_0x05b9:
        com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x05bf }
        r0.m41526init(r9)     // Catch:{ all -> 0x05bf }
        throw r0     // Catch:{ all -> 0x05bf }
    L_0x05bf:
        r0 = move-exception
        goto L_0x05c3
    L_0x05c1:
        r0 = move-exception
        r10 = r4
    L_0x05c3:
        r1.mo11125a(r10)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.mo11120a(java.util.Map, java.lang.Object):java.lang.Object");
    }

    /* renamed from: d */
    public ParserConfig mo11146d() {
        return this.f2688c;
    }

    /* renamed from: a */
    public <T> T mo11116a(Class<T> cls) {
        return mo11118a((Type) cls, (Object) null);
    }

    /* renamed from: a */
    public <T> T mo11117a(Type type) {
        return mo11118a(type, (Object) null);
    }

    /* renamed from: a */
    public <T> T mo11118a(Type type, Object obj) {
        int a = this.f2689d.mo11205a();
        if (a == 8) {
            this.f2689d.mo11222d();
            return null;
        }
        if (a == 4) {
            if (type == byte[].class) {
                Object t = this.f2689d.mo11241t();
                this.f2689d.mo11222d();
                return t;
            } else if (type == char[].class) {
                String l = this.f2689d.mo11233l();
                this.f2689d.mo11222d();
                return l.toCharArray();
            }
        }
        try {
            return this.f2688c.mo11292a(type).mo11161a(this, type, obj);
        } catch (JSONException e) {
            throw e;
        } catch (Throwable th) {
            throw new JSONException(th.getMessage(), th);
        }
    }

    /* renamed from: a */
    public void mo11126a(Class<?> cls, Collection collection) {
        mo11130a((Type) cls, collection);
    }

    /* renamed from: a */
    public void mo11130a(Type type, Collection collection) {
        mo11131a(type, collection, (Object) null);
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public void mo11131a(Type type, Collection collection, Object obj) {
        ObjectDeserializer sVar;
        int a = this.f2689d.mo11205a();
        if (a == 21 || a == 22) {
            this.f2689d.mo11222d();
            a = this.f2689d.mo11205a();
        }
        if (a == 14) {
            if (Integer.TYPE == type) {
                sVar = IntegerCodec.f2842a;
                this.f2689d.mo11211a(2);
            } else if (String.class == type) {
                sVar = StringCodec.f2926a;
                this.f2689d.mo11211a(4);
            } else {
                sVar = this.f2688c.mo11292a(type);
                this.f2689d.mo11211a(sVar.mo11162g_());
            }
            ParseContext gVar = this.f2690e;
            mo11114a((Object) collection, obj);
            int i = 0;
            while (true) {
                try {
                    if (this.f2689d.mo11212a(Feature.AllowArbitraryCommas)) {
                        while (this.f2689d.mo11205a() == 16) {
                            this.f2689d.mo11222d();
                        }
                    }
                    if (this.f2689d.mo11205a() == 15) {
                        mo11125a(gVar);
                        this.f2689d.mo11211a(16);
                        return;
                    }
                    Object obj2 = null;
                    if (Integer.TYPE == type) {
                        collection.add(IntegerCodec.f2842a.mo11161a(this, null, null));
                    } else if (String.class == type) {
                        if (this.f2689d.mo11205a() == 4) {
                            obj2 = this.f2689d.mo11233l();
                            this.f2689d.mo11211a(16);
                        } else {
                            Object m = mo11155m();
                            if (m != null) {
                                obj2 = m.toString();
                            }
                        }
                        collection.add(obj2);
                    } else {
                        if (this.f2689d.mo11205a() == 8) {
                            this.f2689d.mo11222d();
                        } else {
                            obj2 = sVar.mo11161a(this, type, Integer.valueOf(i));
                        }
                        collection.add(obj2);
                        mo11132a(collection);
                    }
                    if (this.f2689d.mo11205a() == 16) {
                        this.f2689d.mo11211a(sVar.mo11162g_());
                    }
                    i++;
                } catch (Throwable th) {
                    mo11125a(gVar);
                    throw th;
                }
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("exepct '[', but ");
            sb.append(JSONToken.m2903a(a));
            sb.append(", ");
            sb.append(this.f2689d.mo11245x());
            throw new JSONException(sb.toString());
        }
    }

    /* renamed from: a */
    public Object[] mo11135a(Type[] typeArr) {
        Object obj;
        boolean z;
        Type type;
        Object obj2;
        Type[] typeArr2 = typeArr;
        int i = 8;
        if (this.f2689d.mo11205a() == 8) {
            this.f2689d.mo11211a(16);
            return null;
        }
        int i2 = 14;
        if (this.f2689d.mo11205a() == 14) {
            Object[] objArr = new Object[typeArr2.length];
            String str = "syntax error";
            if (typeArr2.length == 0) {
                this.f2689d.mo11211a(15);
                if (this.f2689d.mo11205a() == 15) {
                    this.f2689d.mo11211a(16);
                    return new Object[0];
                }
                throw new JSONException(str);
            }
            this.f2689d.mo11211a(2);
            int i3 = 0;
            while (i3 < typeArr2.length) {
                String str2 = "syntax error :";
                if (this.f2689d.mo11205a() == i) {
                    this.f2689d.mo11211a(16);
                    obj = null;
                } else {
                    Type type2 = typeArr2[i3];
                    if (type2 == Integer.TYPE || type2 == Integer.class) {
                        if (this.f2689d.mo11205a() == 2) {
                            obj = Integer.valueOf(this.f2689d.mo11235n());
                            this.f2689d.mo11211a(16);
                        } else {
                            obj = TypeUtils.m3224a(mo11155m(), type2, this.f2688c);
                        }
                    } else if (type2 == String.class) {
                        if (this.f2689d.mo11205a() == 4) {
                            obj2 = this.f2689d.mo11233l();
                            this.f2689d.mo11211a(16);
                        } else {
                            obj2 = TypeUtils.m3224a(mo11155m(), type2, this.f2688c);
                        }
                        obj = obj2;
                    } else {
                        if (i3 != typeArr2.length - 1 || !(type2 instanceof Class)) {
                            type = null;
                            z = false;
                        } else {
                            Class cls = (Class) type2;
                            z = cls.isArray();
                            type = cls.getComponentType();
                        }
                        if (!z || this.f2689d.mo11205a() == i2) {
                            obj = this.f2688c.mo11292a(type2).mo11161a(this, type2, Integer.valueOf(i3));
                        } else {
                            ArrayList arrayList = new ArrayList();
                            ObjectDeserializer a = this.f2688c.mo11292a(type);
                            int g_ = a.mo11162g_();
                            if (this.f2689d.mo11205a() != 15) {
                                while (true) {
                                    arrayList.add(a.mo11161a(this, type2, null));
                                    if (this.f2689d.mo11205a() != 16) {
                                        break;
                                    }
                                    this.f2689d.mo11211a(g_);
                                }
                                if (this.f2689d.mo11205a() != 15) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(str2);
                                    sb.append(JSONToken.m2903a(this.f2689d.mo11205a()));
                                    throw new JSONException(sb.toString());
                                }
                            }
                            obj = TypeUtils.m3224a((Object) arrayList, type2, this.f2688c);
                        }
                    }
                }
                objArr[i3] = obj;
                if (this.f2689d.mo11205a() == 15) {
                    break;
                } else if (this.f2689d.mo11205a() == 16) {
                    if (i3 == typeArr2.length - 1) {
                        this.f2689d.mo11211a(15);
                    } else {
                        this.f2689d.mo11211a(2);
                    }
                    i3++;
                    i = 8;
                    i2 = 14;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(JSONToken.m2903a(this.f2689d.mo11205a()));
                    throw new JSONException(sb2.toString());
                }
            }
            if (this.f2689d.mo11205a() == 15) {
                this.f2689d.mo11211a(16);
                return objArr;
            }
            throw new JSONException(str);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("syntax error : ");
        sb3.append(this.f2689d.mo11214b());
        throw new JSONException(sb3.toString());
    }

    /* renamed from: a */
    public void mo11127a(Object obj) {
        Object obj2;
        Class cls = obj.getClass();
        ObjectDeserializer a = this.f2688c.mo11292a((Type) cls);
        JavaBeanDeserializer nVar = a instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) a : null;
        if (this.f2689d.mo11205a() == 12 || this.f2689d.mo11205a() == 16) {
            while (true) {
                String a2 = this.f2689d.mo11209a(this.f2687b);
                if (a2 == null) {
                    if (this.f2689d.mo11205a() == 13) {
                        this.f2689d.mo11211a(16);
                        return;
                    } else if (this.f2689d.mo11205a() == 16 && this.f2689d.mo11212a(Feature.AllowArbitraryCommas)) {
                    }
                }
                FieldDeserializer a3 = nVar != null ? nVar.mo11181a(a2) : null;
                if (a3 != null) {
                    Class<?> cls2 = a3.f2724b.f2995d;
                    Type type = a3.f2724b.f2996e;
                    if (cls2 == Integer.TYPE) {
                        this.f2689d.mo11219c(2);
                        obj2 = IntegerCodec.f2842a.mo11161a(this, type, null);
                    } else if (cls2 == String.class) {
                        this.f2689d.mo11219c(4);
                        obj2 = StringCodec.m3090a(this);
                    } else if (cls2 == Long.TYPE) {
                        this.f2689d.mo11219c(2);
                        obj2 = LongCodec.f2861a.mo11161a(this, type, null);
                    } else {
                        ObjectDeserializer a4 = this.f2688c.mo11291a(cls2, type);
                        this.f2689d.mo11219c(a4.mo11162g_());
                        obj2 = a4.mo11161a(this, type, null);
                    }
                    a3.mo11177a(obj, obj2);
                    if (this.f2689d.mo11205a() != 16) {
                        if (this.f2689d.mo11205a() == 13) {
                            this.f2689d.mo11211a(16);
                            return;
                        }
                    }
                } else if (this.f2689d.mo11212a(Feature.IgnoreNotMatch)) {
                    this.f2689d.mo11236o();
                    mo11155m();
                    if (this.f2689d.mo11205a() == 13) {
                        this.f2689d.mo11222d();
                        return;
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("setter not found, class ");
                    sb.append(cls.getName());
                    sb.append(", property ");
                    sb.append(a2);
                    throw new JSONException(sb.toString());
                }
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("syntax error, expect {, actual ");
            sb2.append(this.f2689d.mo11214b());
            throw new JSONException(sb2.toString());
        }
    }

    /* renamed from: a */
    public void mo11129a(String str) {
        JSONLexer bVar = this.f2689d;
        bVar.mo11236o();
        String str2 = "type not match error";
        if (bVar.mo11205a() != 4) {
            throw new JSONException(str2);
        } else if (str.equals(bVar.mo11233l())) {
            bVar.mo11222d();
            if (bVar.mo11205a() == 16) {
                bVar.mo11222d();
            }
        } else {
            throw new JSONException(str2);
        }
    }

    /* renamed from: e */
    public int mo11147e() {
        return this.f2691f;
    }

    /* renamed from: a */
    public void mo11122a(int i) {
        this.f2691f = i;
    }

    /* renamed from: b */
    public Object mo11137b(String str) {
        for (int i = 0; i < this.f2696l; i++) {
            if (str.equals(this.f2695k[i].toString())) {
                return this.f2695k[i].f2794a;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo11132a(Collection collection) {
        if (this.f2691f != 1) {
            return;
        }
        if (collection instanceof List) {
            int size = collection.size() - 1;
            List list = (List) collection;
            C1261a h = mo11150h();
            h.f2703c = new ResolveFieldDeserializer(this, list, size);
            h.f2704d = this.f2690e;
            mo11122a(0);
            return;
        }
        C1261a h2 = mo11150h();
        h2.f2703c = new ResolveFieldDeserializer(collection);
        h2.f2704d = this.f2690e;
        mo11122a(0);
    }

    /* renamed from: b */
    public void mo11141b(Map map, Object obj) {
        if (this.f2691f == 1) {
            ResolveFieldDeserializer xVar = new ResolveFieldDeserializer(map, obj);
            C1261a h = mo11150h();
            h.f2703c = xVar;
            h.f2704d = this.f2690e;
            mo11122a(0);
        }
    }

    /* renamed from: a */
    public Object mo11119a(Map map) {
        return mo11120a(map, (Object) null);
    }

    /* renamed from: f */
    public JSONObject mo11148f() {
        return (JSONObject) mo11119a((Map) new JSONObject(this.f2689d.mo11212a(Feature.OrderedField)));
    }

    /* renamed from: b */
    public final void mo11140b(Collection collection) {
        mo11133a(collection, (Object) null);
    }

    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v1, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r8v2, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r8v3 */
    /* JADX WARNING: type inference failed for: r5v7, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r5v9, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r8v4, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: type inference failed for: r7v4, types: [java.util.Date] */
    /* JADX WARNING: type inference failed for: r8v6 */
    /* JADX WARNING: type inference failed for: r8v7, types: [java.lang.Boolean] */
    /* JADX WARNING: type inference failed for: r8v8, types: [java.lang.Boolean] */
    /* JADX WARNING: type inference failed for: r8v9, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r8v10, types: [com.alibaba.fastjson.JSONArray, java.util.Collection] */
    /* JADX WARNING: type inference failed for: r8v11, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r8v12, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r8v13 */
    /* JADX WARNING: type inference failed for: r8v14 */
    /* JADX WARNING: type inference failed for: r5v18 */
    /* JADX WARNING: type inference failed for: r5v19 */
    /* JADX WARNING: type inference failed for: r8v15 */
    /* JADX WARNING: type inference failed for: r8v16 */
    /* JADX WARNING: type inference failed for: r8v17 */
    /* JADX WARNING: type inference failed for: r8v18 */
    /* JADX WARNING: type inference failed for: r8v19 */
    /* JADX WARNING: type inference failed for: r8v20 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r8v0
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], ?[OBJECT, ARRAY], java.lang.String, com.alibaba.fastjson.JSONArray, java.lang.Number, java.lang.Boolean, java.lang.Object, java.lang.Object[]]
  uses: [java.lang.Object, java.lang.String, java.util.Collection]
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
    /* JADX WARNING: Unknown variable types count: 11 */
    /* renamed from: a */
    public final void mo11133a(java.util.Collection r10, java.lang.Object r11) {
        /*
        r9 = this;
        com.alibaba.fastjson.parser.b r0 = r9.f2689d
        int r1 = r0.mo11205a()
        r2 = 21
        if (r1 == r2) goto L_0x0012
        int r1 = r0.mo11205a()
        r2 = 22
        if (r1 != r2) goto L_0x0015
    L_0x0012:
        r0.mo11222d()
    L_0x0015:
        int r1 = r0.mo11205a()
        r2 = 14
        if (r1 != r2) goto L_0x011a
        r1 = 4
        r0.mo11211a(r1)
        com.alibaba.fastjson.parser.g r3 = r9.f2690e
        r9.mo11114a(r10, r11)
        r11 = 0
        r4 = 0
    L_0x0028:
        com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas     // Catch:{ all -> 0x0115 }
        boolean r5 = r0.mo11212a(r5)     // Catch:{ all -> 0x0115 }
        r6 = 16
        if (r5 == 0) goto L_0x003c
    L_0x0032:
        int r5 = r0.mo11205a()     // Catch:{ all -> 0x0115 }
        if (r5 != r6) goto L_0x003c
        r0.mo11222d()     // Catch:{ all -> 0x0115 }
        goto L_0x0032
    L_0x003c:
        int r5 = r0.mo11205a()     // Catch:{ all -> 0x0115 }
        r7 = 2
        r8 = 0
        if (r5 == r7) goto L_0x00fb
        r7 = 3
        if (r5 == r7) goto L_0x00e4
        if (r5 == r1) goto L_0x00bd
        r7 = 6
        if (r5 == r7) goto L_0x00b7
        r7 = 7
        if (r5 == r7) goto L_0x00b1
        r7 = 8
        if (r5 == r7) goto L_0x00ad
        r7 = 12
        if (r5 == r7) goto L_0x0099
        r7 = 20
        if (r5 == r7) goto L_0x0091
        r7 = 23
        if (r5 == r7) goto L_0x008c
        if (r5 == r2) goto L_0x0072
        r7 = 15
        if (r5 == r7) goto L_0x006b
        java.lang.Object r8 = r9.mo11155m()     // Catch:{ all -> 0x0115 }
        goto L_0x0102
    L_0x006b:
        r0.mo11211a(r6)     // Catch:{ all -> 0x0115 }
        r9.mo11125a(r3)
        return
    L_0x0072:
        com.alibaba.fastjson.JSONArray r8 = new com.alibaba.fastjson.JSONArray     // Catch:{ all -> 0x0115 }
        r8.m41522init()     // Catch:{ all -> 0x0115 }
        java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0115 }
        r9.mo11133a(r8, r5)     // Catch:{ all -> 0x0115 }
        com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.UseObjectArray     // Catch:{ all -> 0x0115 }
        boolean r5 = r0.mo11212a(r5)     // Catch:{ all -> 0x0115 }
        if (r5 == 0) goto L_0x0102
        java.lang.Object[] r8 = r8.toArray()     // Catch:{ all -> 0x0115 }
        goto L_0x0102
    L_0x008c:
        r0.mo11211a(r1)     // Catch:{ all -> 0x0115 }
        goto L_0x0102
    L_0x0091:
        com.alibaba.fastjson.JSONException r10 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0115 }
        java.lang.String r11 = "unclosed jsonArray"
        r10.m41526init(r11)     // Catch:{ all -> 0x0115 }
        throw r10     // Catch:{ all -> 0x0115 }
    L_0x0099:
        com.alibaba.fastjson.JSONObject r5 = new com.alibaba.fastjson.JSONObject     // Catch:{ all -> 0x0115 }
        com.alibaba.fastjson.parser.Feature r7 = com.alibaba.fastjson.parser.Feature.OrderedField     // Catch:{ all -> 0x0115 }
        boolean r7 = r0.mo11212a(r7)     // Catch:{ all -> 0x0115 }
        r5.m41532init(r7)     // Catch:{ all -> 0x0115 }
        java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0115 }
        java.lang.Object r8 = r9.mo11120a(r5, r7)     // Catch:{ all -> 0x0115 }
        goto L_0x0102
    L_0x00ad:
        r0.mo11211a(r1)     // Catch:{ all -> 0x0115 }
        goto L_0x0102
    L_0x00b1:
        java.lang.Boolean r8 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0115 }
        r0.mo11211a(r6)     // Catch:{ all -> 0x0115 }
        goto L_0x0102
    L_0x00b7:
        java.lang.Boolean r8 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0115 }
        r0.mo11211a(r6)     // Catch:{ all -> 0x0115 }
        goto L_0x0102
    L_0x00bd:
        java.lang.String r8 = r0.mo11233l()     // Catch:{ all -> 0x0115 }
        r0.mo11211a(r6)     // Catch:{ all -> 0x0115 }
        com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat     // Catch:{ all -> 0x0115 }
        boolean r5 = r0.mo11212a(r5)     // Catch:{ all -> 0x0115 }
        if (r5 == 0) goto L_0x0102
        com.alibaba.fastjson.parser.e r5 = new com.alibaba.fastjson.parser.e     // Catch:{ all -> 0x0115 }
        r5.m41636init(r8)     // Catch:{ all -> 0x0115 }
        boolean r7 = r5.mo11284K()     // Catch:{ all -> 0x0115 }
        if (r7 == 0) goto L_0x00e0
        java.util.Calendar r7 = r5.mo11251E()     // Catch:{ all -> 0x0115 }
        java.util.Date r7 = r7.getTime()     // Catch:{ all -> 0x0115 }
        r8 = r7
    L_0x00e0:
        r5.close()     // Catch:{ all -> 0x0115 }
        goto L_0x0102
    L_0x00e4:
        com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.UseBigDecimal     // Catch:{ all -> 0x0115 }
        boolean r5 = r0.mo11212a(r5)     // Catch:{ all -> 0x0115 }
        if (r5 == 0) goto L_0x00f2
        r5 = 1
        java.lang.Number r5 = r0.mo11208a(r5)     // Catch:{ all -> 0x0115 }
        goto L_0x00f6
    L_0x00f2:
        java.lang.Number r5 = r0.mo11208a(r11)     // Catch:{ all -> 0x0115 }
    L_0x00f6:
        r8 = r5
        r0.mo11211a(r6)     // Catch:{ all -> 0x0115 }
        goto L_0x0102
    L_0x00fb:
        java.lang.Number r8 = r0.mo11231j()     // Catch:{ all -> 0x0115 }
        r0.mo11211a(r6)     // Catch:{ all -> 0x0115 }
    L_0x0102:
        r10.add(r8)     // Catch:{ all -> 0x0115 }
        r9.mo11132a(r10)     // Catch:{ all -> 0x0115 }
        int r5 = r0.mo11205a()     // Catch:{ all -> 0x0115 }
        if (r5 != r6) goto L_0x0111
        r0.mo11211a(r1)     // Catch:{ all -> 0x0115 }
    L_0x0111:
        int r4 = r4 + 1
        goto L_0x0028
    L_0x0115:
        r10 = move-exception
        r9.mo11125a(r3)
        throw r10
    L_0x011a:
        com.alibaba.fastjson.JSONException r10 = new com.alibaba.fastjson.JSONException
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r2 = "syntax error, expect [, actual "
        r1.append(r2)
        int r2 = r0.mo11205a()
        java.lang.String r2 = com.alibaba.fastjson.parser.JSONToken.m2903a(r2)
        r1.append(r2)
        java.lang.String r2 = ", pos "
        r1.append(r2)
        int r0 = r0.mo11230i()
        r1.append(r0)
        java.lang.String r0 = ", fieldName "
        r1.append(r0)
        r1.append(r11)
        java.lang.String r11 = r1.toString()
        r10.m41526init(r11)
        throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.mo11133a(java.util.Collection, java.lang.Object):void");
    }

    /* renamed from: g */
    public ParseContext mo11149g() {
        return this.f2690e;
    }

    /* renamed from: a */
    public void mo11123a(C1261a aVar) {
        if (this.f2697m == null) {
            this.f2697m = new ArrayList(2);
        }
        this.f2697m.add(aVar);
    }

    /* renamed from: h */
    public C1261a mo11150h() {
        List<C1261a> list = this.f2697m;
        return (C1261a) list.get(list.size() - 1);
    }

    /* renamed from: i */
    public List<ExtraProcessor> mo11151i() {
        if (this.f2699o == null) {
            this.f2699o = new ArrayList(2);
        }
        return this.f2699o;
    }

    /* renamed from: j */
    public List<ExtraTypeProvider> mo11152j() {
        if (this.f2698n == null) {
            this.f2698n = new ArrayList(2);
        }
        return this.f2698n;
    }

    /* renamed from: k */
    public FieldTypeResolver mo11153k() {
        return this.f2692g;
    }

    /* renamed from: a */
    public void mo11124a(FieldTypeResolver lVar) {
        this.f2692g = lVar;
    }

    /* renamed from: a */
    public void mo11125a(ParseContext gVar) {
        if (!this.f2689d.mo11212a(Feature.DisableCircularReferenceDetect)) {
            this.f2690e = gVar;
        }
    }

    /* renamed from: l */
    public void mo11154l() {
        if (!this.f2689d.mo11212a(Feature.DisableCircularReferenceDetect)) {
            this.f2690e = this.f2690e.f2795b;
            int i = this.f2696l;
            if (i > 0) {
                this.f2696l = i - 1;
                this.f2695k[this.f2696l] = null;
            }
        }
    }

    /* renamed from: a */
    public ParseContext mo11114a(Object obj, Object obj2) {
        if (this.f2689d.mo11212a(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        return mo11113a(this.f2690e, obj, obj2);
    }

    /* renamed from: a */
    public ParseContext mo11113a(ParseContext gVar, Object obj, Object obj2) {
        if (this.f2689d.mo11212a(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        this.f2690e = new ParseContext(gVar, obj, obj2);
        m2572b(this.f2690e);
        return this.f2690e;
    }

    /* renamed from: b */
    private void m2572b(ParseContext gVar) {
        int i = this.f2696l;
        this.f2696l = i + 1;
        ParseContext[] gVarArr = this.f2695k;
        if (gVarArr == null) {
            this.f2695k = new ParseContext[8];
        } else if (i >= gVarArr.length) {
            ParseContext[] gVarArr2 = new ParseContext[((gVarArr.length * 3) / 2)];
            System.arraycopy(gVarArr, 0, gVarArr2, 0, gVarArr.length);
            this.f2695k = gVarArr2;
        }
        this.f2695k[i] = gVar;
    }

    /* renamed from: m */
    public Object mo11155m() {
        return mo11136b((Object) null);
    }

    /* renamed from: b */
    public Object mo11136b(Object obj) {
        JSONLexer bVar = this.f2689d;
        int a = bVar.mo11205a();
        if (a == 2) {
            Number j = bVar.mo11231j();
            bVar.mo11222d();
            return j;
        } else if (a == 3) {
            Number a2 = bVar.mo11208a(bVar.mo11212a(Feature.UseBigDecimal));
            bVar.mo11222d();
            return a2;
        } else if (a == 4) {
            String l = bVar.mo11233l();
            bVar.mo11211a(16);
            if (bVar.mo11212a(Feature.AllowISO8601DateFormat)) {
                JSONScanner eVar = new JSONScanner(l);
                try {
                    if (eVar.mo11284K()) {
                        return eVar.mo11251E().getTime();
                    }
                    eVar.close();
                } finally {
                    eVar.close();
                }
            }
            return l;
        } else if (a == 12) {
            return mo11120a((Map) new JSONObject(bVar.mo11212a(Feature.OrderedField)), obj);
        } else {
            if (a != 14) {
                String str = "syntax error, ";
                if (a == 18) {
                    if ("NaN".equals(bVar.mo11233l())) {
                        bVar.mo11222d();
                        return null;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(bVar.mo11245x());
                    throw new JSONException(sb.toString());
                } else if (a != 26) {
                    switch (a) {
                        case 6:
                            bVar.mo11222d();
                            return Boolean.TRUE;
                        case 7:
                            bVar.mo11222d();
                            return Boolean.FALSE;
                        case 8:
                            bVar.mo11222d();
                            return null;
                        case 9:
                            bVar.mo11211a(18);
                            if (bVar.mo11205a() == 18) {
                                bVar.mo11211a(10);
                                mo11139b(10);
                                long longValue = bVar.mo11231j().longValue();
                                mo11139b(2);
                                mo11139b(11);
                                return new Date(longValue);
                            }
                            throw new JSONException("syntax error");
                        default:
                            switch (a) {
                                case 20:
                                    if (bVar.mo11237p()) {
                                        return null;
                                    }
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("unterminated json string, ");
                                    sb2.append(bVar.mo11245x());
                                    throw new JSONException(sb2.toString());
                                case 21:
                                    bVar.mo11222d();
                                    HashSet hashSet = new HashSet();
                                    mo11133a((Collection) hashSet, obj);
                                    return hashSet;
                                case 22:
                                    bVar.mo11222d();
                                    TreeSet treeSet = new TreeSet();
                                    mo11133a((Collection) treeSet, obj);
                                    return treeSet;
                                case 23:
                                    bVar.mo11222d();
                                    return null;
                                default:
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append(str);
                                    sb3.append(bVar.mo11245x());
                                    throw new JSONException(sb3.toString());
                            }
                    }
                } else {
                    byte[] t = bVar.mo11241t();
                    bVar.mo11222d();
                    return t;
                }
            } else {
                JSONArray jSONArray = new JSONArray();
                mo11133a((Collection) jSONArray, obj);
                return bVar.mo11212a(Feature.UseObjectArray) ? jSONArray.toArray() : jSONArray;
            }
        }
    }

    /* renamed from: a */
    public boolean mo11134a(Feature feature) {
        return this.f2689d.mo11212a(feature);
    }

    /* renamed from: n */
    public JSONLexer mo11156n() {
        return this.f2689d;
    }

    /* renamed from: b */
    public final void mo11139b(int i) {
        JSONLexer bVar = this.f2689d;
        if (bVar.mo11205a() == i) {
            bVar.mo11222d();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("syntax error, expect ");
        sb.append(JSONToken.m2903a(i));
        sb.append(", actual ");
        sb.append(JSONToken.m2903a(bVar.mo11205a()));
        throw new JSONException(sb.toString());
    }

    public void close() {
        JSONLexer bVar = this.f2689d;
        try {
            if (bVar.mo11212a(Feature.AutoCloseSource)) {
                if (bVar.mo11205a() != 20) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("not close json text, token : ");
                    sb.append(JSONToken.m2903a(bVar.mo11205a()));
                    throw new JSONException(sb.toString());
                }
            }
        } finally {
            bVar.close();
        }
    }

    /* renamed from: c */
    public Object mo11143c(String str) {
        if (this.f2695k == null) {
            return null;
        }
        int i = 0;
        while (true) {
            ParseContext[] gVarArr = this.f2695k;
            if (i >= gVarArr.length || i >= this.f2696l) {
                return null;
            }
            ParseContext gVar = gVarArr[i];
            if (gVar.toString().equals(str)) {
                return gVar.f2794a;
            }
            i++;
        }
        return null;
    }

    /* renamed from: c */
    public void mo11144c(Object obj) {
        Object obj2;
        List<C1261a> list = this.f2697m;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                C1261a aVar = (C1261a) this.f2697m.get(i);
                String str = aVar.f2702b;
                Object obj3 = null;
                if (aVar.f2704d != null) {
                    obj3 = aVar.f2704d.f2794a;
                }
                if (str.startsWith("$")) {
                    obj2 = mo11137b(str);
                    if (obj2 == null) {
                        try {
                            obj2 = JSONPath.m2522a(obj, str);
                        } catch (JSONPathException unused) {
                        }
                    }
                } else {
                    obj2 = aVar.f2701a.f2794a;
                }
                FieldDeserializer kVar = aVar.f2703c;
                if (kVar != null) {
                    if (obj2 != null && obj2.getClass() == JSONObject.class && kVar.f2724b != null && !Map.class.isAssignableFrom(kVar.f2724b.f2995d)) {
                        obj2 = JSONPath.m2522a(this.f2695k[0].f2794a, str);
                    }
                    kVar.mo11177a(obj3, obj2);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo11128a(Object obj, String str) {
        Object obj2;
        this.f2689d.mo11236o();
        List<ExtraTypeProvider> list = this.f2698n;
        Type type = null;
        if (list != null) {
            for (ExtraTypeProvider a : list) {
                type = a.mo11174a(obj, str);
            }
        }
        if (type == null) {
            obj2 = mo11155m();
        } else {
            obj2 = mo11117a(type);
        }
        if (obj instanceof ExtraProcessable) {
            ((ExtraProcessable) obj).mo11172a(str, obj2);
            return;
        }
        List<ExtraProcessor> list2 = this.f2699o;
        if (list2 != null) {
            for (ExtraProcessor a2 : list2) {
                a2.mo11173a(obj, str, obj2);
            }
        }
        if (this.f2691f == 1) {
            this.f2691f = 0;
        }
    }

    /* JADX INFO: used method not loaded: com.alibaba.fastjson.parser.b.a(int):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
            r11 = r10.f2688c.mo11292a((java.lang.reflect.Type) r2);
            r10.f2689d.mo11211a(16);
            mo11122a(2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01d7, code lost:
            if (r0 == null) goto L_0x01e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01db, code lost:
            if ((r12 instanceof java.lang.Integer) != false) goto L_0x01e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01dd, code lost:
            mo11154l();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01e0, code lost:
            r11 = (java.util.Map) r11.mo11161a(r10, r2, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01e6, code lost:
            mo11125a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01e9, code lost:
            return r11;
     */
    /* renamed from: a */
    public java.lang.Object mo11115a(com.alibaba.fastjson.parser.p066a.PropertyProcessable r11, java.lang.Object r12) {
        /*
        r10 = this;
        com.alibaba.fastjson.parser.b r0 = r10.f2689d
        int r0 = r0.mo11205a()
        r1 = 0
        r2 = 12
        if (r0 == r2) goto L_0x008c
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r0 = "syntax error, expect {, actual "
        r11.append(r0)
        com.alibaba.fastjson.parser.b r0 = r10.f2689d
        java.lang.String r0 = r0.mo11214b()
        r11.append(r0)
        java.lang.String r11 = r11.toString()
        boolean r0 = r12 instanceof java.lang.String
        if (r0 == 0) goto L_0x0046
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        r0.append(r11)
        java.lang.String r11 = ", fieldName "
        r0.append(r11)
        java.lang.String r11 = r0.toString()
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        r0.append(r11)
        r0.append(r12)
        java.lang.String r11 = r0.toString()
    L_0x0046:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        r0.append(r11)
        java.lang.String r11 = ", "
        r0.append(r11)
        java.lang.String r11 = r0.toString()
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        r0.append(r11)
        com.alibaba.fastjson.parser.b r11 = r10.f2689d
        java.lang.String r11 = r11.mo11245x()
        r0.append(r11)
        java.lang.String r11 = r0.toString()
        com.alibaba.fastjson.JSONArray r0 = new com.alibaba.fastjson.JSONArray
        r0.m41522init()
        r10.mo11133a(r0, r12)
        int r12 = r0.size()
        r2 = 1
        if (r12 != r2) goto L_0x0086
        java.lang.Object r12 = r0.get(r1)
        boolean r0 = r12 instanceof com.alibaba.fastjson.JSONObject
        if (r0 == 0) goto L_0x0086
        com.alibaba.fastjson.JSONObject r12 = (com.alibaba.fastjson.JSONObject) r12
        return r12
    L_0x0086:
        com.alibaba.fastjson.JSONException r12 = new com.alibaba.fastjson.JSONException
        r12.m41526init(r11)
        throw r12
    L_0x008c:
        com.alibaba.fastjson.parser.g r0 = r10.f2690e
    L_0x008e:
        com.alibaba.fastjson.parser.b r2 = r10.f2689d     // Catch:{ all -> 0x0260 }
        r2.mo11218c()     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.b r2 = r10.f2689d     // Catch:{ all -> 0x0260 }
        char r2 = r2.mo11223e()     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.b r3 = r10.f2689d     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.Feature r4 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas     // Catch:{ all -> 0x0260 }
        boolean r3 = r3.mo11212a(r4)     // Catch:{ all -> 0x0260 }
        if (r3 == 0) goto L_0x00b8
    L_0x00a3:
        r3 = 44
        if (r2 != r3) goto L_0x00b8
        com.alibaba.fastjson.parser.b r2 = r10.f2689d     // Catch:{ all -> 0x0260 }
        r2.mo11225f()     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.b r2 = r10.f2689d     // Catch:{ all -> 0x0260 }
        r2.mo11218c()     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.b r2 = r10.f2689d     // Catch:{ all -> 0x0260 }
        char r2 = r2.mo11223e()     // Catch:{ all -> 0x0260 }
        goto L_0x00a3
    L_0x00b8:
        java.lang.String r3 = "expect ':' at "
        r4 = 58
        r5 = 34
        r6 = 16
        if (r2 != r5) goto L_0x00f4
        com.alibaba.fastjson.parser.b r2 = r10.f2689d     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.i r7 = r10.f2687b     // Catch:{ all -> 0x0260 }
        java.lang.String r2 = r2.mo11210a(r7, r5)     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.b r7 = r10.f2689d     // Catch:{ all -> 0x0260 }
        r7.mo11218c()     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.b r7 = r10.f2689d     // Catch:{ all -> 0x0260 }
        char r7 = r7.mo11223e()     // Catch:{ all -> 0x0260 }
        if (r7 != r4) goto L_0x00d9
        goto L_0x0171
    L_0x00d9:
        com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0260 }
        java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0260 }
        r12.<init>()     // Catch:{ all -> 0x0260 }
        r12.append(r3)     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.b r1 = r10.f2689d     // Catch:{ all -> 0x0260 }
        int r1 = r1.mo11230i()     // Catch:{ all -> 0x0260 }
        r12.append(r1)     // Catch:{ all -> 0x0260 }
        java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0260 }
        r11.m41526init(r12)     // Catch:{ all -> 0x0260 }
        throw r11     // Catch:{ all -> 0x0260 }
    L_0x00f4:
        r7 = 125(0x7d, float:1.75E-43)
        if (r2 != r7) goto L_0x010b
        com.alibaba.fastjson.parser.b r12 = r10.f2689d     // Catch:{ all -> 0x0260 }
        r12.mo11225f()     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.b r12 = r10.f2689d     // Catch:{ all -> 0x0260 }
        r12.mo11228g()     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.b r12 = r10.f2689d     // Catch:{ all -> 0x0260 }
        r12.mo11211a(r6)     // Catch:{ all -> 0x0260 }
        r10.mo11125a(r0)
        return r11
    L_0x010b:
        java.lang.String r7 = "syntax error"
        r8 = 39
        if (r2 != r8) goto L_0x0152
        com.alibaba.fastjson.parser.b r2 = r10.f2689d     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.Feature r9 = com.alibaba.fastjson.parser.Feature.AllowSingleQuotes     // Catch:{ all -> 0x0260 }
        boolean r2 = r2.mo11212a(r9)     // Catch:{ all -> 0x0260 }
        if (r2 == 0) goto L_0x014c
        com.alibaba.fastjson.parser.b r2 = r10.f2689d     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.i r7 = r10.f2687b     // Catch:{ all -> 0x0260 }
        java.lang.String r2 = r2.mo11210a(r7, r8)     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.b r7 = r10.f2689d     // Catch:{ all -> 0x0260 }
        r7.mo11218c()     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.b r7 = r10.f2689d     // Catch:{ all -> 0x0260 }
        char r7 = r7.mo11223e()     // Catch:{ all -> 0x0260 }
        if (r7 != r4) goto L_0x0131
        goto L_0x0171
    L_0x0131:
        com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0260 }
        java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0260 }
        r12.<init>()     // Catch:{ all -> 0x0260 }
        r12.append(r3)     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.b r1 = r10.f2689d     // Catch:{ all -> 0x0260 }
        int r1 = r1.mo11230i()     // Catch:{ all -> 0x0260 }
        r12.append(r1)     // Catch:{ all -> 0x0260 }
        java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0260 }
        r11.m41526init(r12)     // Catch:{ all -> 0x0260 }
        throw r11     // Catch:{ all -> 0x0260 }
    L_0x014c:
        com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0260 }
        r11.m41526init(r7)     // Catch:{ all -> 0x0260 }
        throw r11     // Catch:{ all -> 0x0260 }
    L_0x0152:
        com.alibaba.fastjson.parser.b r2 = r10.f2689d     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.Feature r8 = com.alibaba.fastjson.parser.Feature.AllowUnQuotedFieldNames     // Catch:{ all -> 0x0260 }
        boolean r2 = r2.mo11212a(r8)     // Catch:{ all -> 0x0260 }
        if (r2 == 0) goto L_0x025a
        com.alibaba.fastjson.parser.b r2 = r10.f2689d     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.i r7 = r10.f2687b     // Catch:{ all -> 0x0260 }
        java.lang.String r2 = r2.mo11215b(r7)     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.b r7 = r10.f2689d     // Catch:{ all -> 0x0260 }
        r7.mo11218c()     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.b r7 = r10.f2689d     // Catch:{ all -> 0x0260 }
        char r7 = r7.mo11223e()     // Catch:{ all -> 0x0260 }
        if (r7 != r4) goto L_0x0237
    L_0x0171:
        com.alibaba.fastjson.parser.b r3 = r10.f2689d     // Catch:{ all -> 0x0260 }
        r3.mo11225f()     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.b r3 = r10.f2689d     // Catch:{ all -> 0x0260 }
        r3.mo11218c()     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.b r3 = r10.f2689d     // Catch:{ all -> 0x0260 }
        r3.mo11223e()     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.b r3 = r10.f2689d     // Catch:{ all -> 0x0260 }
        r3.mo11228g()     // Catch:{ all -> 0x0260 }
        java.lang.String r3 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x0260 }
        r4 = 13
        r7 = 0
        if (r2 != r3) goto L_0x01ea
        com.alibaba.fastjson.parser.b r3 = r10.f2689d     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.Feature r8 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x0260 }
        boolean r3 = r3.mo11212a(r8)     // Catch:{ all -> 0x0260 }
        if (r3 != 0) goto L_0x01ea
        com.alibaba.fastjson.parser.b r2 = r10.f2689d     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.i r3 = r10.f2687b     // Catch:{ all -> 0x0260 }
        java.lang.String r2 = r2.mo11210a(r3, r5)     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.h r3 = r10.f2688c     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.b r5 = r10.f2689d     // Catch:{ all -> 0x0260 }
        int r5 = r5.mo11246y()     // Catch:{ all -> 0x0260 }
        java.lang.Class r2 = r3.mo11294a(r2, r7, r5)     // Catch:{ all -> 0x0260 }
        java.lang.Class<java.util.Map> r3 = java.util.Map.class
        boolean r3 = r3.isAssignableFrom(r2)     // Catch:{ all -> 0x0260 }
        if (r3 == 0) goto L_0x01c8
        com.alibaba.fastjson.parser.b r2 = r10.f2689d     // Catch:{ all -> 0x0260 }
        r2.mo11211a(r6)     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.b r2 = r10.f2689d     // Catch:{ all -> 0x0260 }
        int r2 = r2.mo11205a()     // Catch:{ all -> 0x0260 }
        if (r2 != r4) goto L_0x022f
        com.alibaba.fastjson.parser.b r12 = r10.f2689d     // Catch:{ all -> 0x0260 }
        r12.mo11211a(r6)     // Catch:{ all -> 0x0260 }
        r10.mo11125a(r0)
        return r11
    L_0x01c8:
        com.alibaba.fastjson.parser.h r11 = r10.f2688c     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.a.s r11 = r11.mo11292a(r2)     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.b r1 = r10.f2689d     // Catch:{ all -> 0x0260 }
        r1.mo11211a(r6)     // Catch:{ all -> 0x0260 }
        r1 = 2
        r10.mo11122a(r1)     // Catch:{ all -> 0x0260 }
        if (r0 == 0) goto L_0x01e0
        boolean r1 = r12 instanceof java.lang.Integer     // Catch:{ all -> 0x0260 }
        if (r1 != 0) goto L_0x01e0
        r10.mo11154l()     // Catch:{ all -> 0x0260 }
    L_0x01e0:
        java.lang.Object r11 = r11.mo11161a(r10, r2, r12)     // Catch:{ all -> 0x0260 }
        java.util.Map r11 = (java.util.Map) r11     // Catch:{ all -> 0x0260 }
        r10.mo11125a(r0)
        return r11
    L_0x01ea:
        com.alibaba.fastjson.parser.b r3 = r10.f2689d     // Catch:{ all -> 0x0260 }
        r3.mo11222d()     // Catch:{ all -> 0x0260 }
        if (r1 == 0) goto L_0x01f4
        r10.mo11125a(r0)     // Catch:{ all -> 0x0260 }
    L_0x01f4:
        java.lang.reflect.Type r3 = r11.mo11202a(r2)     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.b r5 = r10.f2689d     // Catch:{ all -> 0x0260 }
        int r5 = r5.mo11205a()     // Catch:{ all -> 0x0260 }
        r6 = 8
        if (r5 != r6) goto L_0x0208
        com.alibaba.fastjson.parser.b r3 = r10.f2689d     // Catch:{ all -> 0x0260 }
        r3.mo11222d()     // Catch:{ all -> 0x0260 }
        goto L_0x020c
    L_0x0208:
        java.lang.Object r7 = r10.mo11118a(r3, r2)     // Catch:{ all -> 0x0260 }
    L_0x020c:
        r11.mo11203a(r2, r7)     // Catch:{ all -> 0x0260 }
        r10.mo11113a(r0, r7, r2)     // Catch:{ all -> 0x0260 }
        r10.mo11125a(r0)     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.b r2 = r10.f2689d     // Catch:{ all -> 0x0260 }
        int r2 = r2.mo11205a()     // Catch:{ all -> 0x0260 }
        r3 = 20
        if (r2 == r3) goto L_0x0233
        r3 = 15
        if (r2 != r3) goto L_0x0224
        goto L_0x0233
    L_0x0224:
        if (r2 != r4) goto L_0x022f
        com.alibaba.fastjson.parser.b r12 = r10.f2689d     // Catch:{ all -> 0x0260 }
        r12.mo11222d()     // Catch:{ all -> 0x0260 }
        r10.mo11125a(r0)
        return r11
    L_0x022f:
        int r1 = r1 + 1
        goto L_0x008e
    L_0x0233:
        r10.mo11125a(r0)
        return r11
    L_0x0237:
        com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0260 }
        java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0260 }
        r12.<init>()     // Catch:{ all -> 0x0260 }
        r12.append(r3)     // Catch:{ all -> 0x0260 }
        com.alibaba.fastjson.parser.b r1 = r10.f2689d     // Catch:{ all -> 0x0260 }
        int r1 = r1.mo11230i()     // Catch:{ all -> 0x0260 }
        r12.append(r1)     // Catch:{ all -> 0x0260 }
        java.lang.String r1 = ", actual "
        r12.append(r1)     // Catch:{ all -> 0x0260 }
        r12.append(r7)     // Catch:{ all -> 0x0260 }
        java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0260 }
        r11.m41526init(r12)     // Catch:{ all -> 0x0260 }
        throw r11     // Catch:{ all -> 0x0260 }
    L_0x025a:
        com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0260 }
        r11.m41526init(r7)     // Catch:{ all -> 0x0260 }
        throw r11     // Catch:{ all -> 0x0260 }
    L_0x0260:
        r11 = move-exception
        r10.mo11125a(r0)
        throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.mo11115a(com.alibaba.fastjson.parser.a.v, java.lang.Object):java.lang.Object");
    }
}
