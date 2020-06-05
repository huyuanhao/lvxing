package com.alibaba.fastjson.parser.p066a;

import com.alibaba.fastjson.p065a.ClassWriter;
import com.alibaba.fastjson.p065a.FieldWriter;
import com.alibaba.fastjson.p065a.Label;
import com.alibaba.fastjson.p065a.MethodVisitor;
import com.alibaba.fastjson.p065a.MethodWriter;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.DefaultJSONParser.C1261a;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.SymbolTable;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.alibaba.fastjson.parser.a.a */
public class ASMDeserializerFactory {
    /* renamed from: c */
    static final String f2705c = ASMUtils.m3171b(DefaultJSONParser.class);
    /* renamed from: d */
    static final String f2706d = ASMUtils.m3171b(JSONLexerBase.class);
    /* renamed from: a */
    public final ASMClassLoader f2707a;
    /* renamed from: b */
    protected final AtomicLong f2708b = new AtomicLong();

    /* compiled from: ASMDeserializerFactory */
    /* renamed from: com.alibaba.fastjson.parser.a.a$a */
    static class C1262a {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public int f2709a = -1;
        /* renamed from: b */
        private final Map<String, Integer> f2710b = new HashMap();
        /* access modifiers changed from: private|final */
        /* renamed from: c */
        public final Class<?> f2711c;
        /* access modifiers changed from: private|final */
        /* renamed from: d */
        public final JavaBeanInfo f2712d;
        /* access modifiers changed from: private|final */
        /* renamed from: e */
        public final String f2713e;
        /* access modifiers changed from: private */
        /* renamed from: f */
        public FieldInfo[] f2714f;

        public C1262a(String str, ParserConfig hVar, JavaBeanInfo fVar, int i) {
            this.f2713e = str;
            this.f2711c = fVar.f3036a;
            this.f2709a = i;
            this.f2712d = fVar;
            this.f2714f = fVar.f3043h;
        }

        /* renamed from: a */
        public Class<?> mo11160a() {
            Class<?> cls = this.f2712d.f3037b;
            return cls == null ? this.f2711c : cls;
        }

        /* renamed from: a */
        public int mo11159a(String str, int i) {
            if (((Integer) this.f2710b.get(str)) == null) {
                this.f2710b.put(str, Integer.valueOf(this.f2709a));
                this.f2709a += i;
            }
            return ((Integer) this.f2710b.get(str)).intValue();
        }

        /* renamed from: a */
        public int mo11158a(String str) {
            if (((Integer) this.f2710b.get(str)) == null) {
                Map<String, Integer> map = this.f2710b;
                int i = this.f2709a;
                this.f2709a = i + 1;
                map.put(str, Integer.valueOf(i));
            }
            return ((Integer) this.f2710b.get(str)).intValue();
        }
    }

    public ASMDeserializerFactory(ClassLoader classLoader) {
        this.f2707a = classLoader instanceof ASMClassLoader ? (ASMClassLoader) classLoader : new ASMClassLoader(classLoader);
    }

    /* renamed from: a */
    public ObjectDeserializer mo11157a(ParserConfig hVar, JavaBeanInfo fVar) throws Exception {
        Class<?> cls = fVar.f3036a;
        if (!cls.isPrimitive()) {
            StringBuilder sb = new StringBuilder();
            sb.append("FastjsonASMDeserializer_");
            sb.append(this.f2708b.incrementAndGet());
            sb.append("_");
            sb.append(cls.getSimpleName());
            String sb2 = sb.toString();
            String name = ASMDeserializerFactory.class.getPackage().getName();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(name.replace('.', '/'));
            sb3.append("/");
            sb3.append(sb2);
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(name);
            sb5.append(".");
            sb5.append(sb2);
            String sb6 = sb5.toString();
            ClassWriter cVar = new ClassWriter();
            cVar.mo11017a(49, 33, sb4, ASMUtils.m3171b(JavaBeanDeserializer.class), null);
            m2632c(cVar, new C1262a(sb4, hVar, fVar, 3));
            m2635d(cVar, new C1262a(sb4, hVar, fVar, 3));
            m2629b(cVar, new C1262a(sb4, hVar, fVar, 5));
            m2616a(cVar, new C1262a(sb4, hVar, fVar, 4));
            byte[] a = cVar.mo11018a();
            return (ObjectDeserializer) this.f2707a.mo11495a(sb6, a, 0, a.length).getConstructor(new Class[]{ParserConfig.class, JavaBeanInfo.class}).newInstance(new Object[]{hVar, fVar});
        }
        StringBuilder sb7 = new StringBuilder();
        sb7.append("not support type :");
        sb7.append(cls.getName());
        throw new IllegalArgumentException(sb7.toString());
    }

    /* renamed from: a */
    private void m2617a(MethodVisitor hVar, C1262a aVar, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("_asm_flag_");
        sb.append(i / 32);
        String sb2 = sb.toString();
        hVar.mo11038b(21, aVar.mo11158a(sb2));
        hVar.mo11037a((Object) Integer.valueOf(1 << i));
        hVar.mo11031a(128);
        hVar.mo11038b(54, aVar.mo11158a(sb2));
    }

    /* renamed from: a */
    private void m2618a(MethodVisitor hVar, C1262a aVar, int i, Label fVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("_asm_flag_");
        sb.append(i / 32);
        hVar.mo11038b(21, aVar.mo11158a(sb.toString()));
        hVar.mo11037a((Object) Integer.valueOf(1 << i));
        hVar.mo11031a(126);
        hVar.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, fVar);
    }

    /* renamed from: a */
    private void m2616a(ClassWriter cVar, C1262a aVar) {
        int i;
        FieldInfo[] cVarArr;
        int i2;
        int i3;
        C1262a aVar2 = aVar;
        StringBuilder sb = new StringBuilder();
        sb.append("(L");
        sb.append(f2705c);
        sb.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
        MethodWriter iVar = new MethodWriter(cVar, 1, "deserialzeArrayMapping", sb.toString(), null, null);
        m2620a(aVar2, (MethodVisitor) iVar);
        m2630b(aVar2, (MethodVisitor) iVar);
        FieldInfo[] cVarArr2 = aVar.f2712d.f3044i;
        int length = cVarArr2.length;
        int i4 = 0;
        while (true) {
            String str = "ch";
            String str2 = "(I)V";
            String str3 = "()C";
            String str4 = "lexer";
            if (i4 < length) {
                boolean z = i4 == length + -1;
                int i5 = z ? 93 : 44;
                FieldInfo cVar2 = cVarArr2[i4];
                Class<?> cls = cVar2.f2995d;
                Type type = cVar2.f2996e;
                String str5 = "_asm";
                if (cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE) {
                    cVarArr = cVarArr2;
                    i = length;
                    String str6 = str5;
                    i2 = i4;
                    iVar.mo11038b(25, aVar2.mo11158a(str4));
                    iVar.mo11038b(16, i5);
                    iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "scanInt", "(C)I");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(cVar2.f2992a);
                    sb2.append(str6);
                    iVar.mo11038b(54, aVar2.mo11158a(sb2.toString()));
                } else {
                    cVarArr = cVarArr2;
                    if (cls == Byte.class) {
                        iVar.mo11038b(25, aVar2.mo11158a(str4));
                        iVar.mo11038b(16, i5);
                        iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "scanInt", "(C)I");
                        iVar.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(cVar2.f2992a);
                        sb3.append(str5);
                        iVar.mo11038b(58, aVar2.mo11158a(sb3.toString()));
                        Label fVar = new Label();
                        iVar.mo11038b(25, aVar2.mo11158a(str4));
                        iVar.mo11035a(TinkerReport.KEY_APPLIED_VERSION_CHECK, f2706d, "matchStat", "I");
                        iVar.mo11037a((Object) Integer.valueOf(5));
                        iVar.mo11033a(160, fVar);
                        iVar.mo11031a(1);
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(cVar2.f2992a);
                        sb4.append(str5);
                        iVar.mo11038b(58, aVar2.mo11158a(sb4.toString()));
                        iVar.mo11036a(fVar);
                    } else if (cls == Short.class) {
                        iVar.mo11038b(25, aVar2.mo11158a(str4));
                        iVar.mo11038b(16, i5);
                        iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "scanInt", "(C)I");
                        iVar.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(cVar2.f2992a);
                        sb5.append(str5);
                        iVar.mo11038b(58, aVar2.mo11158a(sb5.toString()));
                        Label fVar2 = new Label();
                        iVar.mo11038b(25, aVar2.mo11158a(str4));
                        iVar.mo11035a(TinkerReport.KEY_APPLIED_VERSION_CHECK, f2706d, "matchStat", "I");
                        iVar.mo11037a((Object) Integer.valueOf(5));
                        iVar.mo11033a(160, fVar2);
                        iVar.mo11031a(1);
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(cVar2.f2992a);
                        sb6.append(str5);
                        iVar.mo11038b(58, aVar2.mo11158a(sb6.toString()));
                        iVar.mo11036a(fVar2);
                    } else if (cls == Integer.class) {
                        iVar.mo11038b(25, aVar2.mo11158a(str4));
                        iVar.mo11038b(16, i5);
                        iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "scanInt", "(C)I");
                        iVar.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(cVar2.f2992a);
                        sb7.append(str5);
                        iVar.mo11038b(58, aVar2.mo11158a(sb7.toString()));
                        Label fVar3 = new Label();
                        iVar.mo11038b(25, aVar2.mo11158a(str4));
                        iVar.mo11035a(TinkerReport.KEY_APPLIED_VERSION_CHECK, f2706d, "matchStat", "I");
                        iVar.mo11037a((Object) Integer.valueOf(5));
                        iVar.mo11033a(160, fVar3);
                        iVar.mo11031a(1);
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append(cVar2.f2992a);
                        sb8.append(str5);
                        iVar.mo11038b(58, aVar2.mo11158a(sb8.toString()));
                        iVar.mo11036a(fVar3);
                    } else if (cls == Long.TYPE) {
                        iVar.mo11038b(25, aVar2.mo11158a(str4));
                        iVar.mo11038b(16, i5);
                        iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "scanLong", "(C)J");
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append(cVar2.f2992a);
                        sb9.append(str5);
                        iVar.mo11038b(55, aVar2.mo11159a(sb9.toString(), 2));
                    } else if (cls == Long.class) {
                        iVar.mo11038b(25, aVar2.mo11158a(str4));
                        iVar.mo11038b(16, i5);
                        iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "scanLong", "(C)J");
                        iVar.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                        StringBuilder sb10 = new StringBuilder();
                        sb10.append(cVar2.f2992a);
                        sb10.append(str5);
                        iVar.mo11038b(58, aVar2.mo11158a(sb10.toString()));
                        Label fVar4 = new Label();
                        iVar.mo11038b(25, aVar2.mo11158a(str4));
                        iVar.mo11035a(TinkerReport.KEY_APPLIED_VERSION_CHECK, f2706d, "matchStat", "I");
                        iVar.mo11037a((Object) Integer.valueOf(5));
                        iVar.mo11033a(160, fVar4);
                        iVar.mo11031a(1);
                        StringBuilder sb11 = new StringBuilder();
                        sb11.append(cVar2.f2992a);
                        sb11.append(str5);
                        iVar.mo11038b(58, aVar2.mo11158a(sb11.toString()));
                        iVar.mo11036a(fVar4);
                    } else if (cls == Boolean.TYPE) {
                        iVar.mo11038b(25, aVar2.mo11158a(str4));
                        iVar.mo11038b(16, i5);
                        iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "scanBoolean", "(C)Z");
                        StringBuilder sb12 = new StringBuilder();
                        sb12.append(cVar2.f2992a);
                        sb12.append(str5);
                        iVar.mo11038b(54, aVar2.mo11158a(sb12.toString()));
                    } else if (cls == Float.TYPE) {
                        iVar.mo11038b(25, aVar2.mo11158a(str4));
                        iVar.mo11038b(16, i5);
                        iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "scanFloat", "(C)F");
                        StringBuilder sb13 = new StringBuilder();
                        sb13.append(cVar2.f2992a);
                        sb13.append(str5);
                        iVar.mo11038b(56, aVar2.mo11158a(sb13.toString()));
                    } else if (cls == Float.class) {
                        iVar.mo11038b(25, aVar2.mo11158a(str4));
                        iVar.mo11038b(16, i5);
                        iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "scanFloat", "(C)F");
                        iVar.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                        StringBuilder sb14 = new StringBuilder();
                        sb14.append(cVar2.f2992a);
                        sb14.append(str5);
                        iVar.mo11038b(58, aVar2.mo11158a(sb14.toString()));
                        Label fVar5 = new Label();
                        iVar.mo11038b(25, aVar2.mo11158a(str4));
                        iVar.mo11035a(TinkerReport.KEY_APPLIED_VERSION_CHECK, f2706d, "matchStat", "I");
                        iVar.mo11037a((Object) Integer.valueOf(5));
                        iVar.mo11033a(160, fVar5);
                        iVar.mo11031a(1);
                        StringBuilder sb15 = new StringBuilder();
                        sb15.append(cVar2.f2992a);
                        sb15.append(str5);
                        iVar.mo11038b(58, aVar2.mo11158a(sb15.toString()));
                        iVar.mo11036a(fVar5);
                    } else if (cls == Double.TYPE) {
                        iVar.mo11038b(25, aVar2.mo11158a(str4));
                        iVar.mo11038b(16, i5);
                        iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "scanDouble", "(C)D");
                        StringBuilder sb16 = new StringBuilder();
                        sb16.append(cVar2.f2992a);
                        sb16.append(str5);
                        iVar.mo11038b(57, aVar2.mo11159a(sb16.toString(), 2));
                    } else if (cls == Double.class) {
                        iVar.mo11038b(25, aVar2.mo11158a(str4));
                        iVar.mo11038b(16, i5);
                        iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "scanDouble", "(C)D");
                        iVar.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                        StringBuilder sb17 = new StringBuilder();
                        sb17.append(cVar2.f2992a);
                        sb17.append(str5);
                        iVar.mo11038b(58, aVar2.mo11158a(sb17.toString()));
                        Label fVar6 = new Label();
                        iVar.mo11038b(25, aVar2.mo11158a(str4));
                        iVar.mo11035a(TinkerReport.KEY_APPLIED_VERSION_CHECK, f2706d, "matchStat", "I");
                        iVar.mo11037a((Object) Integer.valueOf(5));
                        iVar.mo11033a(160, fVar6);
                        iVar.mo11031a(1);
                        StringBuilder sb18 = new StringBuilder();
                        sb18.append(cVar2.f2992a);
                        sb18.append(str5);
                        iVar.mo11038b(58, aVar2.mo11158a(sb18.toString()));
                        iVar.mo11036a(fVar6);
                    } else if (cls == Character.TYPE) {
                        iVar.mo11038b(25, aVar2.mo11158a(str4));
                        iVar.mo11038b(16, i5);
                        iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "scanString", "(C)Ljava/lang/String;");
                        iVar.mo11031a(3);
                        iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, "java/lang/String", "charAt", "(I)C");
                        StringBuilder sb19 = new StringBuilder();
                        sb19.append(cVar2.f2992a);
                        sb19.append(str5);
                        iVar.mo11038b(54, aVar2.mo11158a(sb19.toString()));
                    } else if (cls == String.class) {
                        iVar.mo11038b(25, aVar2.mo11158a(str4));
                        iVar.mo11038b(16, i5);
                        iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "scanString", "(C)Ljava/lang/String;");
                        StringBuilder sb20 = new StringBuilder();
                        sb20.append(cVar2.f2992a);
                        sb20.append(str5);
                        iVar.mo11038b(58, aVar2.mo11158a(sb20.toString()));
                    } else if (cls == BigDecimal.class) {
                        iVar.mo11038b(25, aVar2.mo11158a(str4));
                        iVar.mo11038b(16, i5);
                        iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "scanDecimal", "(C)Ljava/math/BigDecimal;");
                        StringBuilder sb21 = new StringBuilder();
                        sb21.append(cVar2.f2992a);
                        sb21.append(str5);
                        iVar.mo11038b(58, aVar2.mo11158a(sb21.toString()));
                    } else if (cls == Date.class) {
                        iVar.mo11038b(25, aVar2.mo11158a(str4));
                        iVar.mo11038b(16, i5);
                        iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "scanDate", "(C)Ljava/util/Date;");
                        StringBuilder sb22 = new StringBuilder();
                        sb22.append(cVar2.f2992a);
                        sb22.append(str5);
                        iVar.mo11038b(58, aVar2.mo11158a(sb22.toString()));
                    } else if (cls == UUID.class) {
                        iVar.mo11038b(25, aVar2.mo11158a(str4));
                        iVar.mo11038b(16, i5);
                        iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "scanUUID", "(C)Ljava/util/UUID;");
                        StringBuilder sb23 = new StringBuilder();
                        sb23.append(cVar2.f2992a);
                        sb23.append(str5);
                        iVar.mo11038b(58, aVar2.mo11158a(sb23.toString()));
                    } else {
                        if (cls.isEnum()) {
                            Label fVar7 = new Label();
                            Label fVar8 = new Label();
                            Label fVar9 = new Label();
                            Label fVar10 = new Label();
                            i = length;
                            i3 = i4;
                            iVar.mo11038b(25, aVar2.mo11158a(str4));
                            String str7 = str5;
                            iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "getCurrent", str3);
                            iVar.mo11031a(89);
                            iVar.mo11038b(54, aVar2.mo11158a(str));
                            iVar.mo11037a((Object) Integer.valueOf(110));
                            iVar.mo11033a(159, fVar10);
                            iVar.mo11038b(21, aVar2.mo11158a(str));
                            iVar.mo11037a((Object) Integer.valueOf(34));
                            iVar.mo11033a(160, fVar7);
                            iVar.mo11036a(fVar10);
                            iVar.mo11038b(25, aVar2.mo11158a(str4));
                            iVar.mo11037a((Object) com.alibaba.fastjson.p065a.Type.m2508a(ASMUtils.m3167a(cls)));
                            iVar.mo11038b(25, 1);
                            String str8 = f2705c;
                            StringBuilder sb24 = new StringBuilder();
                            sb24.append("()");
                            sb24.append(ASMUtils.m3167a(SymbolTable.class));
                            iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str8, "getSymbolTable", sb24.toString());
                            iVar.mo11038b(16, i5);
                            String str9 = f2706d;
                            StringBuilder sb25 = new StringBuilder();
                            sb25.append("(Ljava/lang/Class;");
                            sb25.append(ASMUtils.m3167a(SymbolTable.class));
                            sb25.append("C)Ljava/lang/Enum;");
                            iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str9, "scanEnum", sb25.toString());
                            iVar.mo11033a(167, fVar9);
                            iVar.mo11036a(fVar7);
                            iVar.mo11038b(21, aVar2.mo11158a(str));
                            iVar.mo11037a((Object) Integer.valueOf(48));
                            iVar.mo11033a(161, fVar8);
                            iVar.mo11038b(21, aVar2.mo11158a(str));
                            iVar.mo11037a((Object) Integer.valueOf(57));
                            iVar.mo11033a(163, fVar8);
                            m2634c(aVar2, iVar, cVar2);
                            iVar.mo11034a(192, ASMUtils.m3171b(EnumDeserializer.class));
                            iVar.mo11038b(25, aVar2.mo11158a(str4));
                            iVar.mo11038b(16, i5);
                            iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "scanInt", "(C)I");
                            iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, ASMUtils.m3171b(EnumDeserializer.class), "valueOf", "(I)Ljava/lang/Enum;");
                            iVar.mo11033a(167, fVar9);
                            iVar.mo11036a(fVar8);
                            iVar.mo11038b(25, 0);
                            iVar.mo11038b(25, aVar2.mo11158a(str4));
                            iVar.mo11038b(16, i5);
                            String b = ASMUtils.m3171b(JavaBeanDeserializer.class);
                            StringBuilder sb26 = new StringBuilder();
                            sb26.append("(L");
                            sb26.append(f2706d);
                            sb26.append(";C)Ljava/lang/Enum;");
                            iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, b, "scanEnum", sb26.toString());
                            iVar.mo11036a(fVar9);
                            iVar.mo11034a(192, ASMUtils.m3171b(cls));
                            StringBuilder sb27 = new StringBuilder();
                            sb27.append(cVar2.f2992a);
                            sb27.append(str7);
                            iVar.mo11038b(58, aVar2.mo11158a(sb27.toString()));
                        } else {
                            i = length;
                            String str10 = str5;
                            i3 = i4;
                            if (Collection.class.isAssignableFrom(cls)) {
                                Class<String> f = TypeUtils.m3263f(type);
                                if (f == String.class) {
                                    if (cls == List.class || cls == Collections.class || cls == ArrayList.class) {
                                        iVar.mo11034a(187, ASMUtils.m3171b(ArrayList.class));
                                        iVar.mo11031a(89);
                                        iVar.mo11039b(TinkerReport.KEY_APPLIED_LIB_EXTRACT, ASMUtils.m3171b(ArrayList.class), "<init>", "()V");
                                    } else {
                                        iVar.mo11037a((Object) com.alibaba.fastjson.p065a.Type.m2508a(ASMUtils.m3167a(cls)));
                                        iVar.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, ASMUtils.m3171b(TypeUtils.class), "createCollection", "(Ljava/lang/Class;)Ljava/util/Collection;");
                                    }
                                    StringBuilder sb28 = new StringBuilder();
                                    sb28.append(cVar2.f2992a);
                                    sb28.append(str10);
                                    iVar.mo11038b(58, aVar2.mo11158a(sb28.toString()));
                                    iVar.mo11038b(25, aVar2.mo11158a(str4));
                                    StringBuilder sb29 = new StringBuilder();
                                    sb29.append(cVar2.f2992a);
                                    sb29.append(str10);
                                    iVar.mo11038b(25, aVar2.mo11158a(sb29.toString()));
                                    iVar.mo11038b(16, i5);
                                    iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "scanStringArray", "(Ljava/util/Collection;C)V");
                                    Label fVar11 = new Label();
                                    iVar.mo11038b(25, aVar2.mo11158a(str4));
                                    iVar.mo11035a(TinkerReport.KEY_APPLIED_VERSION_CHECK, f2706d, "matchStat", "I");
                                    iVar.mo11037a((Object) Integer.valueOf(5));
                                    iVar.mo11033a(160, fVar11);
                                    iVar.mo11031a(1);
                                    StringBuilder sb30 = new StringBuilder();
                                    sb30.append(cVar2.f2992a);
                                    sb30.append(str10);
                                    iVar.mo11038b(58, aVar2.mo11158a(sb30.toString()));
                                    iVar.mo11036a(fVar11);
                                } else {
                                    Label fVar12 = new Label();
                                    iVar.mo11038b(25, aVar2.mo11158a(str4));
                                    iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "token", "()I");
                                    iVar.mo11038b(54, aVar2.mo11158a("token"));
                                    iVar.mo11038b(21, aVar2.mo11158a("token"));
                                    iVar.mo11037a((Object) Integer.valueOf(i3 == 0 ? 14 : 16));
                                    iVar.mo11033a(159, fVar12);
                                    iVar.mo11038b(25, 1);
                                    iVar.mo11038b(21, aVar2.mo11158a("token"));
                                    iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2705c, "throwException", str2);
                                    iVar.mo11036a(fVar12);
                                    Label fVar13 = new Label();
                                    Label fVar14 = new Label();
                                    iVar.mo11038b(25, aVar2.mo11158a(str4));
                                    iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "getCurrent", str3);
                                    iVar.mo11038b(16, 91);
                                    iVar.mo11033a(160, fVar13);
                                    iVar.mo11038b(25, aVar2.mo11158a(str4));
                                    iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "next", str3);
                                    iVar.mo11031a(87);
                                    iVar.mo11038b(25, aVar2.mo11158a(str4));
                                    iVar.mo11037a((Object) Integer.valueOf(14));
                                    iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "setToken", str2);
                                    iVar.mo11033a(167, fVar14);
                                    iVar.mo11036a(fVar13);
                                    iVar.mo11038b(25, aVar2.mo11158a(str4));
                                    iVar.mo11037a((Object) Integer.valueOf(14));
                                    iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "nextToken", str2);
                                    iVar.mo11036a(fVar14);
                                    i2 = i3;
                                    m2619a((MethodVisitor) iVar, cls, i2, false);
                                    iVar.mo11031a(89);
                                    StringBuilder sb31 = new StringBuilder();
                                    sb31.append(cVar2.f2992a);
                                    sb31.append(str10);
                                    iVar.mo11038b(58, aVar2.mo11158a(sb31.toString()));
                                    m2626a(aVar2, (MethodVisitor) iVar, cVar2, f);
                                    iVar.mo11038b(25, 1);
                                    iVar.mo11037a((Object) com.alibaba.fastjson.p065a.Type.m2508a(ASMUtils.m3167a(f)));
                                    iVar.mo11038b(25, 3);
                                    String b2 = ASMUtils.m3171b(JavaBeanDeserializer.class);
                                    StringBuilder sb32 = new StringBuilder();
                                    sb32.append("(Ljava/util/Collection;");
                                    sb32.append(ASMUtils.m3167a(ObjectDeserializer.class));
                                    sb32.append("L");
                                    sb32.append(f2705c);
                                    sb32.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)V");
                                    iVar.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, b2, "parseArray", sb32.toString());
                                }
                            } else {
                                i2 = i3;
                                if (cls.isArray()) {
                                    iVar.mo11038b(25, aVar2.mo11158a(str4));
                                    iVar.mo11037a((Object) Integer.valueOf(14));
                                    iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "nextToken", str2);
                                    iVar.mo11038b(25, 1);
                                    iVar.mo11038b(25, 0);
                                    iVar.mo11037a((Object) Integer.valueOf(i2));
                                    iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, ASMUtils.m3171b(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
                                    iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2705c, "parseObject", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;");
                                    iVar.mo11034a(192, ASMUtils.m3171b(cls));
                                    StringBuilder sb33 = new StringBuilder();
                                    sb33.append(cVar2.f2992a);
                                    sb33.append(str10);
                                    iVar.mo11038b(58, aVar2.mo11158a(sb33.toString()));
                                } else {
                                    Label fVar15 = new Label();
                                    Label fVar16 = new Label();
                                    if (cls == Date.class) {
                                        iVar.mo11038b(25, aVar2.mo11158a(str4));
                                        iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "getCurrent", str3);
                                        iVar.mo11037a((Object) Integer.valueOf(49));
                                        iVar.mo11033a(160, fVar15);
                                        iVar.mo11034a(187, ASMUtils.m3171b(Date.class));
                                        iVar.mo11031a(89);
                                        iVar.mo11038b(25, aVar2.mo11158a(str4));
                                        iVar.mo11038b(16, i5);
                                        iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "scanLong", "(C)J");
                                        iVar.mo11039b(TinkerReport.KEY_APPLIED_LIB_EXTRACT, ASMUtils.m3171b(Date.class), "<init>", "(J)V");
                                        StringBuilder sb34 = new StringBuilder();
                                        sb34.append(cVar2.f2992a);
                                        sb34.append(str10);
                                        iVar.mo11038b(58, aVar2.mo11158a(sb34.toString()));
                                        iVar.mo11033a(167, fVar16);
                                    }
                                    iVar.mo11036a(fVar15);
                                    m2621a(aVar2, (MethodVisitor) iVar, 14);
                                    m2627a(aVar, iVar, cVar2, cls, i2);
                                    iVar.mo11038b(25, aVar2.mo11158a(str4));
                                    iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "token", "()I");
                                    iVar.mo11037a((Object) Integer.valueOf(15));
                                    iVar.mo11033a(159, fVar16);
                                    iVar.mo11038b(25, 0);
                                    iVar.mo11038b(25, aVar2.mo11158a(str4));
                                    if (!z) {
                                        iVar.mo11037a((Object) Integer.valueOf(16));
                                    } else {
                                        iVar.mo11037a((Object) Integer.valueOf(15));
                                    }
                                    String b3 = ASMUtils.m3171b(JavaBeanDeserializer.class);
                                    StringBuilder sb35 = new StringBuilder();
                                    sb35.append("(");
                                    sb35.append(ASMUtils.m3167a(JSONLexer.class));
                                    sb35.append("I)V");
                                    iVar.mo11039b(TinkerReport.KEY_APPLIED_LIB_EXTRACT, b3, "check", sb35.toString());
                                    iVar.mo11036a(fVar16);
                                }
                            }
                        }
                        i2 = i3;
                    }
                    i = length;
                    i2 = i4;
                }
                i4 = i2 + 1;
                cVarArr2 = cVarArr;
                length = i;
            } else {
                m2628a(aVar2, (MethodVisitor) iVar, false);
                Label fVar17 = new Label();
                Label fVar18 = new Label();
                Label fVar19 = new Label();
                Label fVar20 = new Label();
                iVar.mo11038b(25, aVar2.mo11158a(str4));
                iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "getCurrent", str3);
                iVar.mo11031a(89);
                iVar.mo11038b(54, aVar2.mo11158a(str));
                iVar.mo11038b(16, 44);
                iVar.mo11033a(160, fVar18);
                iVar.mo11038b(25, aVar2.mo11158a(str4));
                iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "next", str3);
                iVar.mo11031a(87);
                iVar.mo11038b(25, aVar2.mo11158a(str4));
                iVar.mo11037a((Object) Integer.valueOf(16));
                iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "setToken", str2);
                iVar.mo11033a(167, fVar20);
                iVar.mo11036a(fVar18);
                iVar.mo11038b(21, aVar2.mo11158a(str));
                iVar.mo11038b(16, 93);
                iVar.mo11033a(160, fVar19);
                iVar.mo11038b(25, aVar2.mo11158a(str4));
                iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "next", str3);
                iVar.mo11031a(87);
                iVar.mo11038b(25, aVar2.mo11158a(str4));
                iVar.mo11037a((Object) Integer.valueOf(15));
                iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "setToken", str2);
                iVar.mo11033a(167, fVar20);
                iVar.mo11036a(fVar19);
                iVar.mo11038b(21, aVar2.mo11158a(str));
                iVar.mo11038b(16, 26);
                iVar.mo11033a(160, fVar17);
                iVar.mo11038b(25, aVar2.mo11158a(str4));
                iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "next", str3);
                iVar.mo11031a(87);
                iVar.mo11038b(25, aVar2.mo11158a(str4));
                iVar.mo11037a((Object) Integer.valueOf(20));
                iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "setToken", str2);
                iVar.mo11033a(167, fVar20);
                iVar.mo11036a(fVar17);
                iVar.mo11038b(25, aVar2.mo11158a(str4));
                iVar.mo11037a((Object) Integer.valueOf(16));
                iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "nextToken", str2);
                iVar.mo11036a(fVar20);
                iVar.mo11038b(25, aVar2.mo11158a("instance"));
                iVar.mo11031a(176);
                iVar.mo11041d(5, aVar.f2709a);
                iVar.mo11030a();
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:127:0x0e51  */
    /* renamed from: b */
    private void m2629b(com.alibaba.fastjson.p065a.ClassWriter r30, com.alibaba.fastjson.parser.p066a.ASMDeserializerFactory.C1262a r31) {
        /*
        r29 = this;
        r8 = r29
        r9 = r31
        com.alibaba.fastjson.util.c[] r0 = r31.f2714f
        int r0 = r0.length
        if (r0 != 0) goto L_0x000c
        return
    L_0x000c:
        com.alibaba.fastjson.util.c[] r0 = r31.f2714f
        int r1 = r0.length
        r10 = 0
        r2 = 0
    L_0x0013:
        if (r2 >= r1) goto L_0x003d
        r3 = r0[r2]
        java.lang.Class<?> r4 = r3.f2995d
        java.lang.reflect.Type r3 = r3.f2996e
        java.lang.Class r5 = java.lang.Character.TYPE
        if (r4 != r5) goto L_0x0020
        return
    L_0x0020:
        java.lang.Class<java.util.Collection> r5 = java.util.Collection.class
        boolean r4 = r5.isAssignableFrom(r4)
        if (r4 == 0) goto L_0x003a
        boolean r4 = r3 instanceof java.lang.reflect.ParameterizedType
        if (r4 == 0) goto L_0x0039
        java.lang.reflect.ParameterizedType r3 = (java.lang.reflect.ParameterizedType) r3
        java.lang.reflect.Type[] r3 = r3.getActualTypeArguments()
        r3 = r3[r10]
        boolean r3 = r3 instanceof java.lang.Class
        if (r3 == 0) goto L_0x0039
        goto L_0x003a
    L_0x0039:
        return
    L_0x003a:
        int r2 = r2 + 1
        goto L_0x0013
    L_0x003d:
        com.alibaba.fastjson.util.f r0 = r31.f2712d
        com.alibaba.fastjson.util.c[] r1 = r0.f3044i
        r9.f2714f = r1
        com.alibaba.fastjson.a.i r7 = new com.alibaba.fastjson.a.i
        r13 = 1
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r2 = "(L"
        r1.append(r2)
        java.lang.String r2 = f2705c
        r1.append(r2)
        java.lang.String r2 = ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;"
        r1.append(r2)
        java.lang.String r15 = r1.toString()
        r16 = 0
        r17 = 0
        java.lang.String r14 = "deserialze"
        r11 = r7
        r12 = r30
        r11.m41550init(r12, r13, r14, r15, r16, r17)
        com.alibaba.fastjson.a.f r11 = new com.alibaba.fastjson.a.f
        r11.m41548init()
        com.alibaba.fastjson.a.f r12 = new com.alibaba.fastjson.a.f
        r12.m41548init()
        com.alibaba.fastjson.a.f r13 = new com.alibaba.fastjson.a.f
        r13.m41548init()
        com.alibaba.fastjson.a.f r14 = new com.alibaba.fastjson.a.f
        r14.m41548init()
        r8.m2620a(r9, r7)
        com.alibaba.fastjson.a.f r1 = new com.alibaba.fastjson.a.f
        r1.m41548init()
        java.lang.String r15 = "lexer"
        int r2 = r9.mo11158a(r15)
        r6 = 25
        r7.mo11038b(r6, r2)
        java.lang.String r2 = f2706d
        r5 = 182(0xb6, float:2.55E-43)
        java.lang.String r3 = "token"
        java.lang.String r4 = "()I"
        r7.mo11039b(r5, r2, r3, r4)
        r2 = 14
        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        r7.mo11037a(r2)
        r2 = 160(0xa0, float:2.24E-43)
        r7.mo11033a(r2, r1)
        int r0 = r0.f3045j
        com.alibaba.fastjson.parser.Feature r2 = com.alibaba.fastjson.parser.Feature.SupportArrayToBean
        int r2 = r2.mask
        r0 = r0 & r2
        r4 = 4
        if (r0 != 0) goto L_0x00dc
        int r0 = r9.mo11158a(r15)
        r7.mo11038b(r6, r0)
        r0 = 21
        r7.mo11038b(r0, r4)
        com.alibaba.fastjson.parser.Feature r0 = com.alibaba.fastjson.parser.Feature.SupportArrayToBean
        int r0 = r0.mask
        java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        r7.mo11037a(r0)
        java.lang.String r0 = f2706d
        java.lang.String r2 = "isEnabled"
        java.lang.String r3 = "(II)Z"
        r7.mo11039b(r5, r0, r2, r3)
        r0 = 153(0x99, float:2.14E-43)
        r7.mo11033a(r0, r1)
    L_0x00dc:
        r7.mo11038b(r6, r10)
        r3 = 1
        r7.mo11038b(r6, r3)
        r0 = 2
        r7.mo11038b(r6, r0)
        r2 = 3
        r7.mo11038b(r6, r2)
        r7.mo11031a(r3)
        r0 = 183(0xb7, float:2.56E-43)
        java.lang.String r10 = r31.f2713e
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        r4.<init>()
        java.lang.String r2 = "(L"
        r4.append(r2)
        java.lang.String r2 = f2705c
        r4.append(r2)
        java.lang.String r2 = ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"
        r4.append(r2)
        java.lang.String r2 = r4.toString()
        java.lang.String r4 = "deserialzeArrayMapping"
        r7.mo11039b(r0, r10, r4, r2)
        r0 = 176(0xb0, float:2.47E-43)
        r7.mo11031a(r0)
        r7.mo11036a(r1)
        int r0 = r9.mo11158a(r15)
        r7.mo11038b(r6, r0)
        com.alibaba.fastjson.parser.Feature r0 = com.alibaba.fastjson.parser.Feature.SortFeidFastMatch
        int r0 = r0.mask
        java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        r7.mo11037a(r0)
        java.lang.String r0 = f2706d
        java.lang.String r1 = "isEnabled"
        java.lang.String r2 = "(I)Z"
        r7.mo11039b(r5, r0, r1, r2)
        r0 = 153(0x99, float:2.14E-43)
        r7.mo11033a(r0, r12)
        int r0 = r9.mo11158a(r15)
        r7.mo11038b(r6, r0)
        java.lang.Class r0 = r31.f2711c
        java.lang.String r0 = r0.getName()
        r7.mo11037a(r0)
        java.lang.String r0 = f2706d
        java.lang.String r1 = "scanType"
        java.lang.String r2 = "(Ljava/lang/String;)I"
        r7.mo11039b(r5, r0, r1, r2)
        r0 = -1
        java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        r7.mo11037a(r0)
        r0 = 159(0x9f, float:2.23E-43)
        r7.mo11033a(r0, r12)
        r7.mo11038b(r6, r3)
        java.lang.String r0 = f2705c
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r2 = "()"
        r1.append(r2)
        java.lang.Class<com.alibaba.fastjson.parser.g> r2 = com.alibaba.fastjson.parser.ParseContext.class
        java.lang.String r2 = com.alibaba.fastjson.util.ASMUtils.m3167a(r2)
        r1.append(r2)
        java.lang.String r1 = r1.toString()
        java.lang.String r2 = "getContext"
        r7.mo11039b(r5, r0, r2, r1)
        java.lang.String r0 = "mark_context"
        int r0 = r9.mo11158a(r0)
        r10 = 58
        r7.mo11038b(r10, r0)
        r0 = 3
        r7.mo11031a(r0)
        java.lang.String r0 = "matchedCount"
        int r0 = r9.mo11158a(r0)
        r4 = 54
        r7.mo11038b(r4, r0)
        r8.m2630b(r9, r7)
        r7.mo11038b(r6, r3)
        java.lang.String r0 = f2705c
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r2 = "()"
        r1.append(r2)
        java.lang.Class<com.alibaba.fastjson.parser.g> r2 = com.alibaba.fastjson.parser.ParseContext.class
        java.lang.String r2 = com.alibaba.fastjson.util.ASMUtils.m3167a(r2)
        r1.append(r2)
        java.lang.String r1 = r1.toString()
        java.lang.String r2 = "getContext"
        r7.mo11039b(r5, r0, r2, r1)
        java.lang.String r0 = "context"
        int r0 = r9.mo11158a(r0)
        r7.mo11038b(r10, r0)
        r7.mo11038b(r6, r3)
        java.lang.String r0 = "context"
        int r0 = r9.mo11158a(r0)
        r7.mo11038b(r6, r0)
        java.lang.String r0 = "instance"
        int r0 = r9.mo11158a(r0)
        r7.mo11038b(r6, r0)
        r0 = 3
        r7.mo11038b(r6, r0)
        java.lang.String r0 = f2705c
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r2 = "("
        r1.append(r2)
        java.lang.Class<com.alibaba.fastjson.parser.g> r2 = com.alibaba.fastjson.parser.ParseContext.class
        java.lang.String r2 = com.alibaba.fastjson.util.ASMUtils.m3167a(r2)
        r1.append(r2)
        java.lang.String r2 = "Ljava/lang/Object;Ljava/lang/Object;)"
        r1.append(r2)
        java.lang.Class<com.alibaba.fastjson.parser.g> r2 = com.alibaba.fastjson.parser.ParseContext.class
        java.lang.String r2 = com.alibaba.fastjson.util.ASMUtils.m3167a(r2)
        r1.append(r2)
        java.lang.String r1 = r1.toString()
        java.lang.String r2 = "setContext"
        r7.mo11039b(r5, r0, r2, r1)
        java.lang.String r0 = "childContext"
        int r0 = r9.mo11158a(r0)
        r7.mo11038b(r10, r0)
        int r0 = r9.mo11158a(r15)
        r7.mo11038b(r6, r0)
        java.lang.String r0 = f2706d
        java.lang.String r2 = "I"
        java.lang.String r1 = "matchStat"
        r10 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r10, r0, r1, r2)
        r0 = 4
        java.lang.Integer r10 = java.lang.Integer.valueOf(r0)
        r7.mo11037a(r10)
        r0 = 159(0x9f, float:2.23E-43)
        r7.mo11033a(r0, r13)
        r0 = 3
        r7.mo11031a(r0)
        int r10 = r9.mo11158a(r1)
        r7.mo11032a(r4, r10)
        com.alibaba.fastjson.util.c[] r10 = r31.f2714f
        int r10 = r10.length
        r3 = 0
    L_0x0247:
        if (r3 >= r10) goto L_0x026c
        r7.mo11031a(r0)
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r5 = "_asm_flag_"
        r0.append(r5)
        int r5 = r3 / 32
        r0.append(r5)
        java.lang.String r0 = r0.toString()
        int r0 = r9.mo11158a(r0)
        r7.mo11038b(r4, r0)
        int r3 = r3 + 32
        r0 = 3
        r5 = 182(0xb6, float:2.55E-43)
        goto L_0x0247
    L_0x026c:
        int r0 = r9.mo11158a(r15)
        r7.mo11038b(r6, r0)
        com.alibaba.fastjson.parser.Feature r0 = com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty
        int r0 = r0.mask
        java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        r7.mo11037a(r0)
        java.lang.String r0 = f2706d
        java.lang.String r3 = "isEnabled"
        java.lang.String r5 = "(I)Z"
        r6 = 182(0xb6, float:2.55E-43)
        r7.mo11039b(r6, r0, r3, r5)
        java.lang.String r0 = "initStringFieldAsEmpty"
        int r0 = r9.mo11158a(r0)
        r7.mo11032a(r4, r0)
        r0 = 0
    L_0x0293:
        java.lang.String r6 = "_asm"
        if (r0 >= r10) goto L_0x03dd
        com.alibaba.fastjson.util.c[] r3 = r31.f2714f
        r3 = r3[r0]
        java.lang.Class<?> r5 = r3.f2995d
        java.lang.Class r4 = java.lang.Boolean.TYPE
        if (r5 == r4) goto L_0x03a7
        java.lang.Class r4 = java.lang.Byte.TYPE
        if (r5 == r4) goto L_0x03a7
        java.lang.Class r4 = java.lang.Short.TYPE
        if (r5 == r4) goto L_0x03a7
        java.lang.Class r4 = java.lang.Integer.TYPE
        if (r5 != r4) goto L_0x02b1
        goto L_0x03a7
    L_0x02b1:
        java.lang.Class r4 = java.lang.Long.TYPE
        if (r5 != r4) goto L_0x02e0
        r4 = 9
        r7.mo11031a(r4)
        r4 = 55
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>()
        java.lang.String r3 = r3.f2992a
        r5.append(r3)
        r5.append(r6)
        java.lang.String r3 = r5.toString()
        r5 = 2
        int r3 = r9.mo11159a(r3, r5)
        r7.mo11038b(r4, r3)
    L_0x02d5:
        r26 = r11
        r23 = r12
        r24 = r13
        r25 = r14
    L_0x02dd:
        r4 = 3
        goto L_0x03cd
    L_0x02e0:
        java.lang.Class r4 = java.lang.Float.TYPE
        if (r5 != r4) goto L_0x0304
        r4 = 11
        r7.mo11031a(r4)
        r4 = 56
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>()
        java.lang.String r3 = r3.f2992a
        r5.append(r3)
        r5.append(r6)
        java.lang.String r3 = r5.toString()
        int r3 = r9.mo11158a(r3)
        r7.mo11038b(r4, r3)
        goto L_0x02d5
    L_0x0304:
        java.lang.Class r4 = java.lang.Double.TYPE
        if (r5 != r4) goto L_0x0329
        r4 = 14
        r7.mo11031a(r4)
        r4 = 57
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>()
        java.lang.String r3 = r3.f2992a
        r5.append(r3)
        r5.append(r6)
        java.lang.String r3 = r5.toString()
        r5 = 2
        int r3 = r9.mo11159a(r3, r5)
        r7.mo11038b(r4, r3)
        goto L_0x02d5
    L_0x0329:
        java.lang.Class<java.lang.String> r4 = java.lang.String.class
        if (r5 != r4) goto L_0x0376
        com.alibaba.fastjson.a.f r4 = new com.alibaba.fastjson.a.f
        r4.m41548init()
        r23 = r12
        com.alibaba.fastjson.a.f r12 = new com.alibaba.fastjson.a.f
        r12.m41548init()
        r24 = r13
        r13 = 21
        r25 = r14
        java.lang.String r14 = "initStringFieldAsEmpty"
        int r14 = r9.mo11158a(r14)
        r7.mo11038b(r13, r14)
        r13 = 153(0x99, float:2.14E-43)
        r7.mo11033a(r13, r12)
        r8.m2617a(r7, r9, r0)
        int r13 = r9.mo11158a(r15)
        r14 = 25
        r7.mo11038b(r14, r13)
        java.lang.String r13 = f2706d
        java.lang.String r14 = "stringDefaultValue"
        r26 = r11
        java.lang.String r11 = "()Ljava/lang/String;"
        r8 = 182(0xb6, float:2.55E-43)
        r7.mo11039b(r8, r13, r14, r11)
        r8 = 167(0xa7, float:2.34E-43)
        r7.mo11033a(r8, r4)
        r7.mo11036a(r12)
        r8 = 1
        r7.mo11031a(r8)
        r7.mo11036a(r4)
        goto L_0x0382
    L_0x0376:
        r26 = r11
        r23 = r12
        r24 = r13
        r25 = r14
        r8 = 1
        r7.mo11031a(r8)
    L_0x0382:
        r4 = 192(0xc0, float:2.69E-43)
        java.lang.String r5 = com.alibaba.fastjson.util.ASMUtils.m3171b(r5)
        r7.mo11034a(r4, r5)
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        r4.<init>()
        java.lang.String r3 = r3.f2992a
        r4.append(r3)
        r4.append(r6)
        java.lang.String r3 = r4.toString()
        int r3 = r9.mo11158a(r3)
        r4 = 58
        r7.mo11038b(r4, r3)
        goto L_0x02dd
    L_0x03a7:
        r26 = r11
        r23 = r12
        r24 = r13
        r25 = r14
        r4 = 3
        r7.mo11031a(r4)
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>()
        java.lang.String r3 = r3.f2992a
        r5.append(r3)
        r5.append(r6)
        java.lang.String r3 = r5.toString()
        int r3 = r9.mo11158a(r3)
        r5 = 54
        r7.mo11038b(r5, r3)
    L_0x03cd:
        int r0 = r0 + 1
        r4 = 54
        r8 = r29
        r12 = r23
        r13 = r24
        r14 = r25
        r11 = r26
        goto L_0x0293
    L_0x03dd:
        r26 = r11
        r23 = r12
        r24 = r13
        r25 = r14
        r4 = 3
        r8 = 0
    L_0x03e7:
        if (r8 >= r10) goto L_0x0efc
        com.alibaba.fastjson.util.c[] r0 = r31.f2714f
        r5 = r0[r8]
        java.lang.Class<?> r11 = r5.f2995d
        java.lang.reflect.Type r0 = r5.f2996e
        com.alibaba.fastjson.a.f r3 = new com.alibaba.fastjson.a.f
        r3.m41548init()
        java.lang.Class r12 = java.lang.Boolean.TYPE
        java.lang.String r13 = "[C"
        java.lang.String r14 = "_asm_prefix__"
        if (r11 != r12) goto L_0x0458
        int r0 = r9.mo11158a(r15)
        r11 = 25
        r7.mo11038b(r11, r0)
        r0 = 0
        r7.mo11038b(r11, r0)
        java.lang.String r0 = r31.f2713e
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r12 = r5.f2992a
        r11.append(r12)
        r11.append(r14)
        java.lang.String r11 = r11.toString()
        r12 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r12, r0, r11, r13)
        java.lang.String r0 = f2706d
        java.lang.String r11 = "scanFieldBoolean"
        java.lang.String r12 = "([C)Z"
        r13 = 182(0xb6, float:2.55E-43)
        r7.mo11039b(r13, r0, r11, r12)
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r5 = r5.f2992a
        r0.append(r5)
        r0.append(r6)
        java.lang.String r0 = r0.toString()
        int r0 = r9.mo11158a(r0)
        r5 = 54
        r7.mo11038b(r5, r0)
    L_0x044c:
        r13 = 182(0xb6, float:2.55E-43)
        r14 = 58
        r12 = r29
        r28 = r3
        r27 = r10
        goto L_0x0dad
    L_0x0458:
        java.lang.Class r12 = java.lang.Byte.TYPE
        if (r11 != r12) goto L_0x04a9
        int r0 = r9.mo11158a(r15)
        r11 = 25
        r7.mo11038b(r11, r0)
        r0 = 0
        r7.mo11038b(r11, r0)
        java.lang.String r0 = r31.f2713e
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r12 = r5.f2992a
        r11.append(r12)
        r11.append(r14)
        java.lang.String r11 = r11.toString()
        r12 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r12, r0, r11, r13)
        java.lang.String r0 = f2706d
        java.lang.String r11 = "scanFieldInt"
        java.lang.String r12 = "([C)I"
        r13 = 182(0xb6, float:2.55E-43)
        r7.mo11039b(r13, r0, r11, r12)
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r5 = r5.f2992a
        r0.append(r5)
        r0.append(r6)
        java.lang.String r0 = r0.toString()
        int r0 = r9.mo11158a(r0)
        r5 = 54
        r7.mo11038b(r5, r0)
        goto L_0x044c
    L_0x04a9:
        java.lang.Class<java.lang.Byte> r12 = java.lang.Byte.class
        if (r11 != r12) goto L_0x0549
        int r0 = r9.mo11158a(r15)
        r11 = 25
        r7.mo11038b(r11, r0)
        r0 = 0
        r7.mo11038b(r11, r0)
        java.lang.String r0 = r31.f2713e
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r12 = r5.f2992a
        r11.append(r12)
        r11.append(r14)
        java.lang.String r11 = r11.toString()
        r12 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r12, r0, r11, r13)
        java.lang.String r0 = f2706d
        java.lang.String r11 = "scanFieldInt"
        java.lang.String r12 = "([C)I"
        r13 = 182(0xb6, float:2.55E-43)
        r7.mo11039b(r13, r0, r11, r12)
        r0 = 184(0xb8, float:2.58E-43)
        java.lang.String r11 = "java/lang/Byte"
        java.lang.String r12 = "valueOf"
        java.lang.String r13 = "(B)Ljava/lang/Byte;"
        r7.mo11039b(r0, r11, r12, r13)
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r11 = r5.f2992a
        r0.append(r11)
        r0.append(r6)
        java.lang.String r0 = r0.toString()
        int r0 = r9.mo11158a(r0)
        r11 = 58
        r7.mo11038b(r11, r0)
        com.alibaba.fastjson.a.f r0 = new com.alibaba.fastjson.a.f
        r0.m41548init()
        int r11 = r9.mo11158a(r15)
        r12 = 25
        r7.mo11038b(r12, r11)
        java.lang.String r11 = f2706d
        r12 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r12, r11, r1, r2)
        r11 = 5
        java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
        r7.mo11037a(r11)
        r11 = 160(0xa0, float:2.24E-43)
        r7.mo11033a(r11, r0)
        r11 = 1
        r7.mo11031a(r11)
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r5 = r5.f2992a
        r11.append(r5)
        r11.append(r6)
        java.lang.String r5 = r11.toString()
        int r5 = r9.mo11158a(r5)
        r11 = 58
        r7.mo11038b(r11, r5)
        r7.mo11036a(r0)
        goto L_0x044c
    L_0x0549:
        java.lang.Class r12 = java.lang.Short.TYPE
        if (r11 != r12) goto L_0x059b
        int r0 = r9.mo11158a(r15)
        r11 = 25
        r7.mo11038b(r11, r0)
        r0 = 0
        r7.mo11038b(r11, r0)
        java.lang.String r0 = r31.f2713e
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r12 = r5.f2992a
        r11.append(r12)
        r11.append(r14)
        java.lang.String r11 = r11.toString()
        r12 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r12, r0, r11, r13)
        java.lang.String r0 = f2706d
        java.lang.String r11 = "scanFieldInt"
        java.lang.String r12 = "([C)I"
        r13 = 182(0xb6, float:2.55E-43)
        r7.mo11039b(r13, r0, r11, r12)
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r5 = r5.f2992a
        r0.append(r5)
        r0.append(r6)
        java.lang.String r0 = r0.toString()
        int r0 = r9.mo11158a(r0)
        r5 = 54
        r7.mo11038b(r5, r0)
        goto L_0x044c
    L_0x059b:
        java.lang.Class<java.lang.Short> r12 = java.lang.Short.class
        if (r11 != r12) goto L_0x063b
        int r0 = r9.mo11158a(r15)
        r11 = 25
        r7.mo11038b(r11, r0)
        r0 = 0
        r7.mo11038b(r11, r0)
        java.lang.String r0 = r31.f2713e
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r12 = r5.f2992a
        r11.append(r12)
        r11.append(r14)
        java.lang.String r11 = r11.toString()
        r12 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r12, r0, r11, r13)
        java.lang.String r0 = f2706d
        java.lang.String r11 = "scanFieldInt"
        java.lang.String r12 = "([C)I"
        r13 = 182(0xb6, float:2.55E-43)
        r7.mo11039b(r13, r0, r11, r12)
        r0 = 184(0xb8, float:2.58E-43)
        java.lang.String r11 = "java/lang/Short"
        java.lang.String r12 = "valueOf"
        java.lang.String r13 = "(S)Ljava/lang/Short;"
        r7.mo11039b(r0, r11, r12, r13)
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r11 = r5.f2992a
        r0.append(r11)
        r0.append(r6)
        java.lang.String r0 = r0.toString()
        int r0 = r9.mo11158a(r0)
        r11 = 58
        r7.mo11038b(r11, r0)
        com.alibaba.fastjson.a.f r0 = new com.alibaba.fastjson.a.f
        r0.m41548init()
        int r11 = r9.mo11158a(r15)
        r12 = 25
        r7.mo11038b(r12, r11)
        java.lang.String r11 = f2706d
        r12 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r12, r11, r1, r2)
        r11 = 5
        java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
        r7.mo11037a(r11)
        r11 = 160(0xa0, float:2.24E-43)
        r7.mo11033a(r11, r0)
        r11 = 1
        r7.mo11031a(r11)
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r5 = r5.f2992a
        r11.append(r5)
        r11.append(r6)
        java.lang.String r5 = r11.toString()
        int r5 = r9.mo11158a(r5)
        r11 = 58
        r7.mo11038b(r11, r5)
        r7.mo11036a(r0)
        goto L_0x044c
    L_0x063b:
        java.lang.Class r12 = java.lang.Integer.TYPE
        if (r11 != r12) goto L_0x068d
        int r0 = r9.mo11158a(r15)
        r11 = 25
        r7.mo11038b(r11, r0)
        r0 = 0
        r7.mo11038b(r11, r0)
        java.lang.String r0 = r31.f2713e
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r12 = r5.f2992a
        r11.append(r12)
        r11.append(r14)
        java.lang.String r11 = r11.toString()
        r12 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r12, r0, r11, r13)
        java.lang.String r0 = f2706d
        java.lang.String r11 = "scanFieldInt"
        java.lang.String r12 = "([C)I"
        r13 = 182(0xb6, float:2.55E-43)
        r7.mo11039b(r13, r0, r11, r12)
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r5 = r5.f2992a
        r0.append(r5)
        r0.append(r6)
        java.lang.String r0 = r0.toString()
        int r0 = r9.mo11158a(r0)
        r5 = 54
        r7.mo11038b(r5, r0)
        goto L_0x044c
    L_0x068d:
        java.lang.Class<java.lang.Integer> r12 = java.lang.Integer.class
        if (r11 != r12) goto L_0x072d
        int r0 = r9.mo11158a(r15)
        r11 = 25
        r7.mo11038b(r11, r0)
        r0 = 0
        r7.mo11038b(r11, r0)
        java.lang.String r0 = r31.f2713e
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r12 = r5.f2992a
        r11.append(r12)
        r11.append(r14)
        java.lang.String r11 = r11.toString()
        r12 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r12, r0, r11, r13)
        java.lang.String r0 = f2706d
        java.lang.String r11 = "scanFieldInt"
        java.lang.String r12 = "([C)I"
        r13 = 182(0xb6, float:2.55E-43)
        r7.mo11039b(r13, r0, r11, r12)
        r0 = 184(0xb8, float:2.58E-43)
        java.lang.String r11 = "java/lang/Integer"
        java.lang.String r12 = "valueOf"
        java.lang.String r13 = "(I)Ljava/lang/Integer;"
        r7.mo11039b(r0, r11, r12, r13)
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r11 = r5.f2992a
        r0.append(r11)
        r0.append(r6)
        java.lang.String r0 = r0.toString()
        int r0 = r9.mo11158a(r0)
        r11 = 58
        r7.mo11038b(r11, r0)
        com.alibaba.fastjson.a.f r0 = new com.alibaba.fastjson.a.f
        r0.m41548init()
        int r11 = r9.mo11158a(r15)
        r12 = 25
        r7.mo11038b(r12, r11)
        java.lang.String r11 = f2706d
        r12 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r12, r11, r1, r2)
        r11 = 5
        java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
        r7.mo11037a(r11)
        r11 = 160(0xa0, float:2.24E-43)
        r7.mo11033a(r11, r0)
        r11 = 1
        r7.mo11031a(r11)
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r5 = r5.f2992a
        r11.append(r5)
        r11.append(r6)
        java.lang.String r5 = r11.toString()
        int r5 = r9.mo11158a(r5)
        r11 = 58
        r7.mo11038b(r11, r5)
        r7.mo11036a(r0)
        goto L_0x044c
    L_0x072d:
        java.lang.Class r12 = java.lang.Long.TYPE
        if (r11 != r12) goto L_0x0780
        int r0 = r9.mo11158a(r15)
        r11 = 25
        r7.mo11038b(r11, r0)
        r0 = 0
        r7.mo11038b(r11, r0)
        java.lang.String r0 = r31.f2713e
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r12 = r5.f2992a
        r11.append(r12)
        r11.append(r14)
        java.lang.String r11 = r11.toString()
        r12 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r12, r0, r11, r13)
        java.lang.String r0 = f2706d
        java.lang.String r11 = "scanFieldLong"
        java.lang.String r12 = "([C)J"
        r13 = 182(0xb6, float:2.55E-43)
        r7.mo11039b(r13, r0, r11, r12)
        r0 = 55
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r5 = r5.f2992a
        r11.append(r5)
        r11.append(r6)
        java.lang.String r5 = r11.toString()
        r11 = 2
        int r5 = r9.mo11159a(r5, r11)
        r7.mo11038b(r0, r5)
        goto L_0x044c
    L_0x0780:
        java.lang.Class<java.lang.Long> r12 = java.lang.Long.class
        if (r11 != r12) goto L_0x0820
        int r0 = r9.mo11158a(r15)
        r11 = 25
        r7.mo11038b(r11, r0)
        r0 = 0
        r7.mo11038b(r11, r0)
        java.lang.String r0 = r31.f2713e
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r12 = r5.f2992a
        r11.append(r12)
        r11.append(r14)
        java.lang.String r11 = r11.toString()
        r12 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r12, r0, r11, r13)
        java.lang.String r0 = f2706d
        java.lang.String r11 = "scanFieldLong"
        java.lang.String r12 = "([C)J"
        r13 = 182(0xb6, float:2.55E-43)
        r7.mo11039b(r13, r0, r11, r12)
        r0 = 184(0xb8, float:2.58E-43)
        java.lang.String r11 = "java/lang/Long"
        java.lang.String r12 = "valueOf"
        java.lang.String r13 = "(J)Ljava/lang/Long;"
        r7.mo11039b(r0, r11, r12, r13)
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r11 = r5.f2992a
        r0.append(r11)
        r0.append(r6)
        java.lang.String r0 = r0.toString()
        int r0 = r9.mo11158a(r0)
        r11 = 58
        r7.mo11038b(r11, r0)
        com.alibaba.fastjson.a.f r0 = new com.alibaba.fastjson.a.f
        r0.m41548init()
        int r11 = r9.mo11158a(r15)
        r12 = 25
        r7.mo11038b(r12, r11)
        java.lang.String r11 = f2706d
        r12 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r12, r11, r1, r2)
        r11 = 5
        java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
        r7.mo11037a(r11)
        r11 = 160(0xa0, float:2.24E-43)
        r7.mo11033a(r11, r0)
        r11 = 1
        r7.mo11031a(r11)
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r5 = r5.f2992a
        r11.append(r5)
        r11.append(r6)
        java.lang.String r5 = r11.toString()
        int r5 = r9.mo11158a(r5)
        r11 = 58
        r7.mo11038b(r11, r5)
        r7.mo11036a(r0)
        goto L_0x044c
    L_0x0820:
        java.lang.Class r12 = java.lang.Float.TYPE
        if (r11 != r12) goto L_0x0872
        int r0 = r9.mo11158a(r15)
        r11 = 25
        r7.mo11038b(r11, r0)
        r0 = 0
        r7.mo11038b(r11, r0)
        java.lang.String r0 = r31.f2713e
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r12 = r5.f2992a
        r11.append(r12)
        r11.append(r14)
        java.lang.String r11 = r11.toString()
        r12 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r12, r0, r11, r13)
        java.lang.String r0 = f2706d
        java.lang.String r11 = "scanFieldFloat"
        java.lang.String r12 = "([C)F"
        r13 = 182(0xb6, float:2.55E-43)
        r7.mo11039b(r13, r0, r11, r12)
        r0 = 56
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r5 = r5.f2992a
        r11.append(r5)
        r11.append(r6)
        java.lang.String r5 = r11.toString()
        int r5 = r9.mo11158a(r5)
        r7.mo11038b(r0, r5)
        goto L_0x044c
    L_0x0872:
        java.lang.Class<java.lang.Float> r12 = java.lang.Float.class
        if (r11 != r12) goto L_0x0912
        int r0 = r9.mo11158a(r15)
        r11 = 25
        r7.mo11038b(r11, r0)
        r0 = 0
        r7.mo11038b(r11, r0)
        java.lang.String r0 = r31.f2713e
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r12 = r5.f2992a
        r11.append(r12)
        r11.append(r14)
        java.lang.String r11 = r11.toString()
        r12 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r12, r0, r11, r13)
        java.lang.String r0 = f2706d
        java.lang.String r11 = "scanFieldFloat"
        java.lang.String r12 = "([C)F"
        r13 = 182(0xb6, float:2.55E-43)
        r7.mo11039b(r13, r0, r11, r12)
        r0 = 184(0xb8, float:2.58E-43)
        java.lang.String r11 = "java/lang/Float"
        java.lang.String r12 = "valueOf"
        java.lang.String r13 = "(F)Ljava/lang/Float;"
        r7.mo11039b(r0, r11, r12, r13)
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r11 = r5.f2992a
        r0.append(r11)
        r0.append(r6)
        java.lang.String r0 = r0.toString()
        int r0 = r9.mo11158a(r0)
        r11 = 58
        r7.mo11038b(r11, r0)
        com.alibaba.fastjson.a.f r0 = new com.alibaba.fastjson.a.f
        r0.m41548init()
        int r11 = r9.mo11158a(r15)
        r12 = 25
        r7.mo11038b(r12, r11)
        java.lang.String r11 = f2706d
        r12 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r12, r11, r1, r2)
        r11 = 5
        java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
        r7.mo11037a(r11)
        r11 = 160(0xa0, float:2.24E-43)
        r7.mo11033a(r11, r0)
        r11 = 1
        r7.mo11031a(r11)
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r5 = r5.f2992a
        r11.append(r5)
        r11.append(r6)
        java.lang.String r5 = r11.toString()
        int r5 = r9.mo11158a(r5)
        r11 = 58
        r7.mo11038b(r11, r5)
        r7.mo11036a(r0)
        goto L_0x044c
    L_0x0912:
        java.lang.Class r12 = java.lang.Double.TYPE
        if (r11 != r12) goto L_0x0965
        int r0 = r9.mo11158a(r15)
        r11 = 25
        r7.mo11038b(r11, r0)
        r0 = 0
        r7.mo11038b(r11, r0)
        java.lang.String r0 = r31.f2713e
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r12 = r5.f2992a
        r11.append(r12)
        r11.append(r14)
        java.lang.String r11 = r11.toString()
        r12 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r12, r0, r11, r13)
        java.lang.String r0 = f2706d
        java.lang.String r11 = "scanFieldDouble"
        java.lang.String r12 = "([C)D"
        r13 = 182(0xb6, float:2.55E-43)
        r7.mo11039b(r13, r0, r11, r12)
        r0 = 57
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r5 = r5.f2992a
        r11.append(r5)
        r11.append(r6)
        java.lang.String r5 = r11.toString()
        r11 = 2
        int r5 = r9.mo11159a(r5, r11)
        r7.mo11038b(r0, r5)
        goto L_0x044c
    L_0x0965:
        java.lang.Class<java.lang.Double> r12 = java.lang.Double.class
        if (r11 != r12) goto L_0x0a05
        int r0 = r9.mo11158a(r15)
        r11 = 25
        r7.mo11038b(r11, r0)
        r0 = 0
        r7.mo11038b(r11, r0)
        java.lang.String r0 = r31.f2713e
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r12 = r5.f2992a
        r11.append(r12)
        r11.append(r14)
        java.lang.String r11 = r11.toString()
        r12 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r12, r0, r11, r13)
        java.lang.String r0 = f2706d
        java.lang.String r11 = "scanFieldDouble"
        java.lang.String r12 = "([C)D"
        r13 = 182(0xb6, float:2.55E-43)
        r7.mo11039b(r13, r0, r11, r12)
        r0 = 184(0xb8, float:2.58E-43)
        java.lang.String r11 = "java/lang/Double"
        java.lang.String r12 = "valueOf"
        java.lang.String r13 = "(D)Ljava/lang/Double;"
        r7.mo11039b(r0, r11, r12, r13)
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r11 = r5.f2992a
        r0.append(r11)
        r0.append(r6)
        java.lang.String r0 = r0.toString()
        int r0 = r9.mo11158a(r0)
        r11 = 58
        r7.mo11038b(r11, r0)
        com.alibaba.fastjson.a.f r0 = new com.alibaba.fastjson.a.f
        r0.m41548init()
        int r11 = r9.mo11158a(r15)
        r12 = 25
        r7.mo11038b(r12, r11)
        java.lang.String r11 = f2706d
        r12 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r12, r11, r1, r2)
        r11 = 5
        java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
        r7.mo11037a(r11)
        r11 = 160(0xa0, float:2.24E-43)
        r7.mo11033a(r11, r0)
        r12 = 1
        r7.mo11031a(r12)
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r5 = r5.f2992a
        r11.append(r5)
        r11.append(r6)
        java.lang.String r5 = r11.toString()
        int r5 = r9.mo11158a(r5)
        r11 = 58
        r7.mo11038b(r11, r5)
        r7.mo11036a(r0)
        goto L_0x044c
    L_0x0a05:
        r12 = 1
        java.lang.Class<java.lang.String> r4 = java.lang.String.class
        if (r11 != r4) goto L_0x0a58
        int r0 = r9.mo11158a(r15)
        r4 = 25
        r7.mo11038b(r4, r0)
        r0 = 0
        r7.mo11038b(r4, r0)
        java.lang.String r0 = r31.f2713e
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        r4.<init>()
        java.lang.String r11 = r5.f2992a
        r4.append(r11)
        r4.append(r14)
        java.lang.String r4 = r4.toString()
        r11 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r11, r0, r4, r13)
        java.lang.String r0 = f2706d
        java.lang.String r4 = "scanFieldString"
        java.lang.String r11 = "([C)Ljava/lang/String;"
        r13 = 182(0xb6, float:2.55E-43)
        r7.mo11039b(r13, r0, r4, r11)
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r4 = r5.f2992a
        r0.append(r4)
        r0.append(r6)
        java.lang.String r0 = r0.toString()
        int r0 = r9.mo11158a(r0)
        r4 = 58
        r7.mo11038b(r4, r0)
        goto L_0x044c
    L_0x0a58:
        java.lang.Class<java.util.Date> r4 = java.util.Date.class
        if (r11 != r4) goto L_0x0aaa
        int r0 = r9.mo11158a(r15)
        r4 = 25
        r7.mo11038b(r4, r0)
        r0 = 0
        r7.mo11038b(r4, r0)
        java.lang.String r0 = r31.f2713e
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        r4.<init>()
        java.lang.String r11 = r5.f2992a
        r4.append(r11)
        r4.append(r14)
        java.lang.String r4 = r4.toString()
        r11 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r11, r0, r4, r13)
        java.lang.String r0 = f2706d
        java.lang.String r4 = "scanFieldDate"
        java.lang.String r11 = "([C)Ljava/util/Date;"
        r13 = 182(0xb6, float:2.55E-43)
        r7.mo11039b(r13, r0, r4, r11)
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r4 = r5.f2992a
        r0.append(r4)
        r0.append(r6)
        java.lang.String r0 = r0.toString()
        int r0 = r9.mo11158a(r0)
        r4 = 58
        r7.mo11038b(r4, r0)
        goto L_0x044c
    L_0x0aaa:
        java.lang.Class<java.util.UUID> r4 = java.util.UUID.class
        if (r11 != r4) goto L_0x0afc
        int r0 = r9.mo11158a(r15)
        r4 = 25
        r7.mo11038b(r4, r0)
        r0 = 0
        r7.mo11038b(r4, r0)
        java.lang.String r0 = r31.f2713e
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        r4.<init>()
        java.lang.String r11 = r5.f2992a
        r4.append(r11)
        r4.append(r14)
        java.lang.String r4 = r4.toString()
        r11 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r11, r0, r4, r13)
        java.lang.String r0 = f2706d
        java.lang.String r4 = "scanFieldUUID"
        java.lang.String r11 = "([C)Ljava/util/UUID;"
        r13 = 182(0xb6, float:2.55E-43)
        r7.mo11039b(r13, r0, r4, r11)
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r4 = r5.f2992a
        r0.append(r4)
        r0.append(r6)
        java.lang.String r0 = r0.toString()
        int r0 = r9.mo11158a(r0)
        r4 = 58
        r7.mo11038b(r4, r0)
        goto L_0x044c
    L_0x0afc:
        java.lang.Class<java.math.BigDecimal> r4 = java.math.BigDecimal.class
        if (r11 != r4) goto L_0x0b4e
        int r0 = r9.mo11158a(r15)
        r4 = 25
        r7.mo11038b(r4, r0)
        r0 = 0
        r7.mo11038b(r4, r0)
        java.lang.String r0 = r31.f2713e
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        r4.<init>()
        java.lang.String r11 = r5.f2992a
        r4.append(r11)
        r4.append(r14)
        java.lang.String r4 = r4.toString()
        r11 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r11, r0, r4, r13)
        java.lang.String r0 = f2706d
        java.lang.String r4 = "scanFieldDecimal"
        java.lang.String r11 = "([C)Ljava/math/BigDecimal;"
        r13 = 182(0xb6, float:2.55E-43)
        r7.mo11039b(r13, r0, r4, r11)
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r4 = r5.f2992a
        r0.append(r4)
        r0.append(r6)
        java.lang.String r0 = r0.toString()
        int r0 = r9.mo11158a(r0)
        r4 = 58
        r7.mo11038b(r4, r0)
        goto L_0x044c
    L_0x0b4e:
        java.lang.Class<java.math.BigInteger> r4 = java.math.BigInteger.class
        if (r11 != r4) goto L_0x0ba0
        int r0 = r9.mo11158a(r15)
        r4 = 25
        r7.mo11038b(r4, r0)
        r0 = 0
        r7.mo11038b(r4, r0)
        java.lang.String r0 = r31.f2713e
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        r4.<init>()
        java.lang.String r11 = r5.f2992a
        r4.append(r11)
        r4.append(r14)
        java.lang.String r4 = r4.toString()
        r11 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r11, r0, r4, r13)
        java.lang.String r0 = f2706d
        java.lang.String r4 = "scanFieldBigInteger"
        java.lang.String r11 = "([C)Ljava/math/BigInteger;"
        r13 = 182(0xb6, float:2.55E-43)
        r7.mo11039b(r13, r0, r4, r11)
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r4 = r5.f2992a
        r0.append(r4)
        r0.append(r6)
        java.lang.String r0 = r0.toString()
        int r0 = r9.mo11158a(r0)
        r4 = 58
        r7.mo11038b(r4, r0)
        goto L_0x044c
    L_0x0ba0:
        java.lang.Class<int[]> r4 = int[].class
        if (r11 != r4) goto L_0x0bf2
        int r0 = r9.mo11158a(r15)
        r4 = 25
        r7.mo11038b(r4, r0)
        r0 = 0
        r7.mo11038b(r4, r0)
        java.lang.String r0 = r31.f2713e
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        r4.<init>()
        java.lang.String r11 = r5.f2992a
        r4.append(r11)
        r4.append(r14)
        java.lang.String r4 = r4.toString()
        r11 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r11, r0, r4, r13)
        java.lang.String r0 = f2706d
        java.lang.String r4 = "scanFieldIntArray"
        java.lang.String r11 = "([C)[I"
        r13 = 182(0xb6, float:2.55E-43)
        r7.mo11039b(r13, r0, r4, r11)
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r4 = r5.f2992a
        r0.append(r4)
        r0.append(r6)
        java.lang.String r0 = r0.toString()
        int r0 = r9.mo11158a(r0)
        r4 = 58
        r7.mo11038b(r4, r0)
        goto L_0x044c
    L_0x0bf2:
        java.lang.Class<float[]> r4 = float[].class
        if (r11 != r4) goto L_0x0c44
        int r0 = r9.mo11158a(r15)
        r4 = 25
        r7.mo11038b(r4, r0)
        r0 = 0
        r7.mo11038b(r4, r0)
        java.lang.String r0 = r31.f2713e
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        r4.<init>()
        java.lang.String r11 = r5.f2992a
        r4.append(r11)
        r4.append(r14)
        java.lang.String r4 = r4.toString()
        r11 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r11, r0, r4, r13)
        java.lang.String r0 = f2706d
        java.lang.String r4 = "scanFieldFloatArray"
        java.lang.String r11 = "([C)[F"
        r13 = 182(0xb6, float:2.55E-43)
        r7.mo11039b(r13, r0, r4, r11)
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r4 = r5.f2992a
        r0.append(r4)
        r0.append(r6)
        java.lang.String r0 = r0.toString()
        int r0 = r9.mo11158a(r0)
        r4 = 58
        r7.mo11038b(r4, r0)
        goto L_0x044c
    L_0x0c44:
        java.lang.Class<float[][]> r4 = float[][].class
        if (r11 != r4) goto L_0x0c96
        int r0 = r9.mo11158a(r15)
        r4 = 25
        r7.mo11038b(r4, r0)
        r0 = 0
        r7.mo11038b(r4, r0)
        java.lang.String r0 = r31.f2713e
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        r4.<init>()
        java.lang.String r11 = r5.f2992a
        r4.append(r11)
        r4.append(r14)
        java.lang.String r4 = r4.toString()
        r11 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r11, r0, r4, r13)
        java.lang.String r0 = f2706d
        java.lang.String r4 = "scanFieldFloatArray2"
        java.lang.String r11 = "([C)[[F"
        r13 = 182(0xb6, float:2.55E-43)
        r7.mo11039b(r13, r0, r4, r11)
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r4 = r5.f2992a
        r0.append(r4)
        r0.append(r6)
        java.lang.String r0 = r0.toString()
        int r0 = r9.mo11158a(r0)
        r4 = 58
        r7.mo11038b(r4, r0)
        goto L_0x044c
    L_0x0c96:
        boolean r4 = r11.isEnum()
        if (r4 == 0) goto L_0x0d2b
        r4 = 0
        r12 = 25
        r7.mo11038b(r12, r4)
        int r0 = r9.mo11158a(r15)
        r7.mo11038b(r12, r0)
        r7.mo11038b(r12, r4)
        java.lang.String r0 = r31.f2713e
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        r4.<init>()
        java.lang.String r12 = r5.f2992a
        r4.append(r12)
        r4.append(r14)
        java.lang.String r4 = r4.toString()
        r12 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r12, r0, r4, r13)
        r12 = r29
        r12.m2634c(r9, r7, r5)
        java.lang.Class<com.alibaba.fastjson.parser.a.n> r0 = com.alibaba.fastjson.parser.p066a.JavaBeanDeserializer.class
        java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.m3171b(r0)
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        r4.<init>()
        java.lang.String r13 = "(L"
        r4.append(r13)
        java.lang.String r13 = f2706d
        r4.append(r13)
        java.lang.String r13 = ";[C"
        r4.append(r13)
        java.lang.Class<com.alibaba.fastjson.parser.a.s> r13 = com.alibaba.fastjson.parser.p066a.ObjectDeserializer.class
        java.lang.String r13 = com.alibaba.fastjson.util.ASMUtils.m3167a(r13)
        r4.append(r13)
        java.lang.String r13 = ")Ljava/lang/Enum;"
        r4.append(r13)
        java.lang.String r4 = r4.toString()
        java.lang.String r13 = "scanEnum"
        r14 = 182(0xb6, float:2.55E-43)
        r7.mo11039b(r14, r0, r13, r4)
        r0 = 192(0xc0, float:2.69E-43)
        java.lang.String r4 = com.alibaba.fastjson.util.ASMUtils.m3171b(r11)
        r7.mo11034a(r0, r4)
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r4 = r5.f2992a
        r0.append(r4)
        r0.append(r6)
        java.lang.String r0 = r0.toString()
        int r0 = r9.mo11158a(r0)
        r4 = 58
        r7.mo11038b(r4, r0)
        r28 = r3
        r27 = r10
        r13 = 182(0xb6, float:2.55E-43)
        r14 = 58
        goto L_0x0dad
    L_0x0d2b:
        r12 = r29
        java.lang.Class<java.util.Collection> r4 = java.util.Collection.class
        boolean r4 = r4.isAssignableFrom(r11)
        if (r4 == 0) goto L_0x0ebe
        int r4 = r9.mo11158a(r15)
        r27 = r10
        r10 = 25
        r7.mo11038b(r10, r4)
        r4 = 0
        r7.mo11038b(r10, r4)
        java.lang.String r4 = r31.f2713e
        java.lang.StringBuilder r10 = new java.lang.StringBuilder
        r10.<init>()
        r28 = r3
        java.lang.String r3 = r5.f2992a
        r10.append(r3)
        r10.append(r14)
        java.lang.String r3 = r10.toString()
        r10 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r10, r4, r3, r13)
        java.lang.Class r10 = com.alibaba.fastjson.util.TypeUtils.m3263f(r0)
        java.lang.Class<java.lang.String> r0 = java.lang.String.class
        if (r10 != r0) goto L_0x0e84
        java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.m3167a(r11)
        com.alibaba.fastjson.a.j r0 = com.alibaba.fastjson.p065a.Type.m2508a(r0)
        r7.mo11037a(r0)
        java.lang.String r0 = f2706d
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r4 = "([CLjava/lang/Class;)"
        r3.append(r4)
        java.lang.Class<java.util.Collection> r4 = java.util.Collection.class
        java.lang.String r4 = com.alibaba.fastjson.util.ASMUtils.m3167a(r4)
        r3.append(r4)
        java.lang.String r3 = r3.toString()
        java.lang.String r4 = "scanFieldStringArray"
        r13 = 182(0xb6, float:2.55E-43)
        r7.mo11039b(r13, r0, r4, r3)
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r3 = r5.f2992a
        r0.append(r3)
        r0.append(r6)
        java.lang.String r0 = r0.toString()
        int r0 = r9.mo11158a(r0)
        r14 = 58
        r7.mo11038b(r14, r0)
    L_0x0dad:
        int r0 = r9.mo11158a(r15)
        r3 = 25
        r7.mo11038b(r3, r0)
        java.lang.String r0 = f2706d
        r4 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r4, r0, r1, r2)
        com.alibaba.fastjson.a.f r0 = new com.alibaba.fastjson.a.f
        r0.m41548init()
        r5 = 158(0x9e, float:2.21E-43)
        r7.mo11033a(r5, r0)
        r12.m2617a(r7, r9, r8)
        r7.mo11036a(r0)
        int r0 = r9.mo11158a(r15)
        r7.mo11038b(r3, r0)
        java.lang.String r0 = f2706d
        r7.mo11035a(r4, r0, r1, r2)
        r0 = 89
        r7.mo11031a(r0)
        int r0 = r9.mo11158a(r1)
        r3 = 54
        r7.mo11038b(r3, r0)
        r0 = -1
        java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        r7.mo11037a(r0)
        r0 = 159(0x9f, float:2.23E-43)
        r4 = r26
        r7.mo11033a(r0, r4)
        int r0 = r9.mo11158a(r15)
        r3 = 25
        r7.mo11038b(r3, r0)
        java.lang.String r0 = f2706d
        r3 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r3, r0, r1, r2)
        r0 = 158(0x9e, float:2.21E-43)
        r3 = r28
        r7.mo11033a(r0, r3)
        r0 = 21
        java.lang.String r5 = "matchedCount"
        int r5 = r9.mo11158a(r5)
        r7.mo11038b(r0, r5)
        r0 = 4
        r7.mo11031a(r0)
        r5 = 96
        r7.mo11031a(r5)
        java.lang.String r5 = "matchedCount"
        int r5 = r9.mo11158a(r5)
        r10 = 54
        r7.mo11038b(r10, r5)
        int r5 = r9.mo11158a(r15)
        r11 = 25
        r7.mo11038b(r11, r5)
        java.lang.String r5 = f2706d
        r11 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r11, r5, r1, r2)
        java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
        r7.mo11037a(r5)
        r0 = 159(0x9f, float:2.23E-43)
        r5 = r25
        r7.mo11033a(r0, r5)
        r7.mo11036a(r3)
        int r0 = r27 + -1
        if (r8 != r0) goto L_0x0e6f
        int r0 = r9.mo11158a(r15)
        r3 = 25
        r7.mo11038b(r3, r0)
        java.lang.String r0 = f2706d
        r11 = 180(0xb4, float:2.52E-43)
        r7.mo11035a(r11, r0, r1, r2)
        r18 = 4
        java.lang.Integer r0 = java.lang.Integer.valueOf(r18)
        r7.mo11037a(r0)
        r0 = 160(0xa0, float:2.24E-43)
        r7.mo11033a(r0, r4)
    L_0x0e6f:
        r22 = r1
        r17 = r2
        r14 = r4
        r13 = r5
        r20 = r6
        r10 = r7
        r30 = r15
        r7 = 25
        r15 = 182(0xb6, float:2.55E-43)
        r18 = 54
        r21 = 180(0xb4, float:2.52E-43)
        goto L_0x0ee8
    L_0x0e84:
        r13 = r25
        r4 = r26
        r3 = 25
        r14 = 58
        r18 = 4
        r19 = 54
        r21 = 180(0xb4, float:2.52E-43)
        r0 = r29
        r22 = r1
        r1 = r31
        r17 = r2
        r14 = 3
        r2 = r7
        r14 = 1
        r20 = 25
        r3 = r4
        r14 = r4
        r30 = r15
        r15 = 4
        r18 = 54
        r4 = r5
        r15 = 182(0xb6, float:2.55E-43)
        r5 = r11
        r20 = r6
        r11 = 25
        r6 = r10
        r10 = r7
        r7 = r8
        r0.m2624a(r1, r2, r3, r4, r5, r6, r7)
        int r0 = r27 + -1
        if (r8 != r0) goto L_0x0ebb
        r12.m2622a(r9, r10, r14)
    L_0x0ebb:
        r7 = 25
        goto L_0x0ee8
    L_0x0ebe:
        r22 = r1
        r17 = r2
        r20 = r6
        r27 = r10
        r30 = r15
        r13 = r25
        r14 = r26
        r15 = 182(0xb6, float:2.55E-43)
        r18 = 54
        r21 = 180(0xb4, float:2.52E-43)
        r10 = r7
        r7 = 25
        r0 = r29
        r1 = r31
        r2 = r10
        r3 = r14
        r4 = r5
        r5 = r11
        r6 = r8
        r0.m2623a(r1, r2, r3, r4, r5, r6)
        int r0 = r27 + -1
        if (r8 != r0) goto L_0x0ee8
        r12.m2622a(r9, r10, r14)
    L_0x0ee8:
        int r8 = r8 + 1
        r15 = r30
        r7 = r10
        r25 = r13
        r26 = r14
        r2 = r17
        r6 = r20
        r1 = r22
        r10 = r27
        r4 = 3
        goto L_0x03e7
    L_0x0efc:
        r12 = r29
        r27 = r10
        r13 = r25
        r14 = r26
        r15 = 182(0xb6, float:2.55E-43)
        r10 = r7
        r7 = 25
        r10.mo11036a(r13)
        java.lang.Class r0 = r31.f2711c
        boolean r0 = r0.isInterface()
        if (r0 != 0) goto L_0x0f27
        java.lang.Class r0 = r31.f2711c
        int r0 = r0.getModifiers()
        boolean r0 = java.lang.reflect.Modifier.isAbstract(r0)
        if (r0 != 0) goto L_0x0f27
        r12.m2633c(r9, r10)
    L_0x0f27:
        r0 = r24
        r10.mo11036a(r0)
        r12.m2636d(r9, r10)
        java.lang.String r0 = "instance"
        int r0 = r9.mo11158a(r0)
        r10.mo11038b(r7, r0)
        com.alibaba.fastjson.util.f r0 = r31.f2712d
        java.lang.reflect.Method r0 = r0.f3041f
        if (r0 == 0) goto L_0x0f68
        java.lang.Class r1 = r31.mo11160a()
        java.lang.String r1 = com.alibaba.fastjson.util.ASMUtils.m3171b(r1)
        java.lang.String r2 = r0.getName()
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r4 = "()"
        r3.append(r4)
        java.lang.Class r0 = r0.getReturnType()
        java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.m3167a(r0)
        r3.append(r0)
        java.lang.String r0 = r3.toString()
        r10.mo11039b(r15, r1, r2, r0)
    L_0x0f68:
        r0 = 176(0xb0, float:2.47E-43)
        r10.mo11031a(r0)
        r10.mo11036a(r14)
        r12.m2633c(r9, r10)
        r0 = 0
        r10.mo11038b(r7, r0)
        r0 = 1
        r10.mo11038b(r7, r0)
        r0 = 2
        r10.mo11038b(r7, r0)
        r0 = 3
        r10.mo11038b(r7, r0)
        java.lang.String r0 = "instance"
        int r0 = r9.mo11158a(r0)
        r10.mo11038b(r7, r0)
        r0 = 21
        r1 = 4
        r10.mo11038b(r0, r1)
        int r0 = r27 / 32
        if (r27 == 0) goto L_0x0f9c
        int r1 = r27 % 32
        if (r1 == 0) goto L_0x0f9c
        int r0 = r0 + 1
    L_0x0f9c:
        r1 = 1
        if (r0 != r1) goto L_0x0fa4
        r1 = 4
        r10.mo11031a(r1)
        goto L_0x0fa9
    L_0x0fa4:
        r1 = 16
        r10.mo11032a(r1, r0)
    L_0x0fa9:
        r1 = 188(0xbc, float:2.63E-43)
        r2 = 10
        r10.mo11032a(r1, r2)
        r1 = 0
    L_0x0fb1:
        if (r1 >= r0) goto L_0x0fee
        r2 = 89
        r10.mo11031a(r2)
        if (r1 != 0) goto L_0x0fbf
        r2 = 3
        r10.mo11031a(r2)
        goto L_0x0fcc
    L_0x0fbf:
        r2 = 1
        if (r1 != r2) goto L_0x0fc7
        r2 = 4
        r10.mo11031a(r2)
        goto L_0x0fcc
    L_0x0fc7:
        r2 = 16
        r10.mo11032a(r2, r1)
    L_0x0fcc:
        r2 = 21
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r4 = "_asm_flag_"
        r3.append(r4)
        r3.append(r1)
        java.lang.String r3 = r3.toString()
        int r3 = r9.mo11158a(r3)
        r10.mo11038b(r2, r3)
        r2 = 79
        r10.mo11031a(r2)
        int r1 = r1 + 1
        goto L_0x0fb1
    L_0x0fee:
        java.lang.Class<com.alibaba.fastjson.parser.a.n> r0 = com.alibaba.fastjson.parser.p066a.JavaBeanDeserializer.class
        java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.m3171b(r0)
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r2 = "(L"
        r1.append(r2)
        java.lang.String r2 = f2705c
        r1.append(r2)
        java.lang.String r2 = ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;I[I)Ljava/lang/Object;"
        r1.append(r2)
        java.lang.String r1 = r1.toString()
        java.lang.String r2 = "parseRest"
        r10.mo11039b(r15, r0, r2, r1)
        r0 = 192(0xc0, float:2.69E-43)
        java.lang.Class r1 = r31.f2711c
        java.lang.String r1 = com.alibaba.fastjson.util.ASMUtils.m3171b(r1)
        r10.mo11034a(r0, r1)
        r0 = 176(0xb0, float:2.47E-43)
        r10.mo11031a(r0)
        r0 = r23
        r10.mo11036a(r0)
        r0 = 0
        r10.mo11038b(r7, r0)
        r0 = 1
        r10.mo11038b(r7, r0)
        r0 = 2
        r10.mo11038b(r7, r0)
        r0 = 3
        r10.mo11038b(r7, r0)
        r0 = 21
        r1 = 4
        r10.mo11038b(r0, r1)
        r0 = 183(0xb7, float:2.56E-43)
        java.lang.Class<com.alibaba.fastjson.parser.a.n> r1 = com.alibaba.fastjson.parser.p066a.JavaBeanDeserializer.class
        java.lang.String r1 = com.alibaba.fastjson.util.ASMUtils.m3171b(r1)
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r3 = "(L"
        r2.append(r3)
        java.lang.String r3 = f2705c
        r2.append(r3)
        java.lang.String r3 = ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;"
        r2.append(r3)
        java.lang.String r2 = r2.toString()
        java.lang.String r3 = "deserialze"
        r10.mo11039b(r0, r1, r3, r2)
        r0 = 176(0xb0, float:2.47E-43)
        r10.mo11031a(r0)
        r0 = 10
        int r1 = r31.f2709a
        r10.mo11041d(r0, r1)
        r10.mo11030a()
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.p066a.ASMDeserializerFactory.m2629b(com.alibaba.fastjson.a.c, com.alibaba.fastjson.parser.a.a$a):void");
    }

    /* renamed from: a */
    private void m2620a(C1262a aVar, MethodVisitor hVar) {
        hVar.mo11038b(25, 1);
        String str = "lexer";
        hVar.mo11035a(TinkerReport.KEY_APPLIED_VERSION_CHECK, f2705c, str, ASMUtils.m3167a(JSONLexer.class));
        hVar.mo11034a(192, f2706d);
        hVar.mo11038b(58, aVar.mo11158a(str));
    }

    /* renamed from: b */
    private void m2630b(C1262a aVar, MethodVisitor hVar) {
        Constructor<?> constructor = aVar.f2712d.f3038c;
        String str = "instance";
        if (Modifier.isPublic(constructor.getModifiers())) {
            hVar.mo11034a(187, ASMUtils.m3171b(aVar.mo11160a()));
            hVar.mo11031a(89);
            hVar.mo11039b(TinkerReport.KEY_APPLIED_LIB_EXTRACT, ASMUtils.m3171b(constructor.getDeclaringClass()), "<init>", "()V");
            hVar.mo11038b(58, aVar.mo11158a(str));
            return;
        }
        hVar.mo11038b(25, 0);
        hVar.mo11038b(25, 1);
        hVar.mo11038b(25, 0);
        hVar.mo11035a(TinkerReport.KEY_APPLIED_VERSION_CHECK, ASMUtils.m3171b(JavaBeanDeserializer.class), "clazz", "Ljava/lang/Class;");
        String b = ASMUtils.m3171b(JavaBeanDeserializer.class);
        StringBuilder sb = new StringBuilder();
        sb.append("(L");
        sb.append(f2705c);
        sb.append(";Ljava/lang/reflect/Type;)Ljava/lang/Object;");
        hVar.mo11039b(TinkerReport.KEY_APPLIED_LIB_EXTRACT, b, "createInstance", sb.toString());
        hVar.mo11034a(192, ASMUtils.m3171b(aVar.mo11160a()));
        hVar.mo11038b(58, aVar.mo11158a(str));
    }

    /* renamed from: c */
    private void m2633c(C1262a aVar, MethodVisitor hVar) {
        m2628a(aVar, hVar, true);
    }

    /* renamed from: a */
    private void m2628a(C1262a aVar, MethodVisitor hVar, boolean z) {
        int length = aVar.f2714f.length;
        for (int i = 0; i < length; i++) {
            Label fVar = new Label();
            if (z) {
                m2618a(hVar, aVar, i, fVar);
            }
            m2625a(aVar, hVar, aVar.f2714f[i]);
            if (z) {
                hVar.mo11036a(fVar);
            }
        }
    }

    /* renamed from: a */
    private void m2625a(C1262a aVar, MethodVisitor hVar, FieldInfo cVar) {
        Class<?> cls = cVar.f2995d;
        Type type = cVar.f2996e;
        String str = "instance";
        String str2 = "_asm";
        if (cls == Boolean.TYPE) {
            hVar.mo11038b(25, aVar.mo11158a(str));
            StringBuilder sb = new StringBuilder();
            sb.append(cVar.f2992a);
            sb.append(str2);
            hVar.mo11038b(21, aVar.mo11158a(sb.toString()));
            m2631b(aVar, hVar, cVar);
        } else if (cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE || cls == Character.TYPE) {
            hVar.mo11038b(25, aVar.mo11158a(str));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cVar.f2992a);
            sb2.append(str2);
            hVar.mo11038b(21, aVar.mo11158a(sb2.toString()));
            m2631b(aVar, hVar, cVar);
        } else if (cls == Long.TYPE) {
            hVar.mo11038b(25, aVar.mo11158a(str));
            StringBuilder sb3 = new StringBuilder();
            sb3.append(cVar.f2992a);
            sb3.append(str2);
            hVar.mo11038b(22, aVar.mo11159a(sb3.toString(), 2));
            if (cVar.f2993b != null) {
                hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, ASMUtils.m3171b(aVar.mo11160a()), cVar.f2993b.getName(), ASMUtils.m3168a(cVar.f2993b));
                if (!cVar.f2993b.getReturnType().equals(Void.TYPE)) {
                    hVar.mo11031a(87);
                    return;
                }
                return;
            }
            hVar.mo11035a(TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, ASMUtils.m3171b(cVar.f2997f), cVar.f2994c.getName(), ASMUtils.m3167a(cVar.f2995d));
        } else if (cls == Float.TYPE) {
            hVar.mo11038b(25, aVar.mo11158a(str));
            StringBuilder sb4 = new StringBuilder();
            sb4.append(cVar.f2992a);
            sb4.append(str2);
            hVar.mo11038b(23, aVar.mo11158a(sb4.toString()));
            m2631b(aVar, hVar, cVar);
        } else if (cls == Double.TYPE) {
            hVar.mo11038b(25, aVar.mo11158a(str));
            StringBuilder sb5 = new StringBuilder();
            sb5.append(cVar.f2992a);
            sb5.append(str2);
            hVar.mo11038b(24, aVar.mo11159a(sb5.toString(), 2));
            m2631b(aVar, hVar, cVar);
        } else if (cls == String.class) {
            hVar.mo11038b(25, aVar.mo11158a(str));
            StringBuilder sb6 = new StringBuilder();
            sb6.append(cVar.f2992a);
            sb6.append(str2);
            hVar.mo11038b(25, aVar.mo11158a(sb6.toString()));
            m2631b(aVar, hVar, cVar);
        } else if (cls.isEnum()) {
            hVar.mo11038b(25, aVar.mo11158a(str));
            StringBuilder sb7 = new StringBuilder();
            sb7.append(cVar.f2992a);
            sb7.append(str2);
            hVar.mo11038b(25, aVar.mo11158a(sb7.toString()));
            m2631b(aVar, hVar, cVar);
        } else if (Collection.class.isAssignableFrom(cls)) {
            hVar.mo11038b(25, aVar.mo11158a(str));
            if (TypeUtils.m3263f(type) == String.class) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append(cVar.f2992a);
                sb8.append(str2);
                hVar.mo11038b(25, aVar.mo11158a(sb8.toString()));
                hVar.mo11034a(192, ASMUtils.m3171b(cls));
            } else {
                StringBuilder sb9 = new StringBuilder();
                sb9.append(cVar.f2992a);
                sb9.append(str2);
                hVar.mo11038b(25, aVar.mo11158a(sb9.toString()));
            }
            m2631b(aVar, hVar, cVar);
        } else {
            hVar.mo11038b(25, aVar.mo11158a(str));
            StringBuilder sb10 = new StringBuilder();
            sb10.append(cVar.f2992a);
            sb10.append(str2);
            hVar.mo11038b(25, aVar.mo11158a(sb10.toString()));
            m2631b(aVar, hVar, cVar);
        }
    }

    /* renamed from: b */
    private void m2631b(C1262a aVar, MethodVisitor hVar, FieldInfo cVar) {
        Method method = cVar.f2993b;
        if (method != null) {
            hVar.mo11039b(method.getDeclaringClass().isInterface() ? 185 : TinkerReport.KEY_APPLIED_DEX_EXTRACT, ASMUtils.m3171b(cVar.f2997f), method.getName(), ASMUtils.m3168a(method));
            if (!cVar.f2993b.getReturnType().equals(Void.TYPE)) {
                hVar.mo11031a(87);
                return;
            }
            return;
        }
        hVar.mo11035a(TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, ASMUtils.m3171b(cVar.f2997f), cVar.f2994c.getName(), ASMUtils.m3167a(cVar.f2995d));
    }

    /* renamed from: d */
    private void m2636d(C1262a aVar, MethodVisitor hVar) {
        hVar.mo11038b(25, 1);
        hVar.mo11038b(25, aVar.mo11158a("context"));
        String str = f2705c;
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(ASMUtils.m3167a(ParseContext.class));
        sb.append(")V");
        hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str, "setContext", sb.toString());
        Label fVar = new Label();
        String str2 = "childContext";
        hVar.mo11038b(25, aVar.mo11158a(str2));
        hVar.mo11033a(198, fVar);
        hVar.mo11038b(25, aVar.mo11158a(str2));
        hVar.mo11038b(25, aVar.mo11158a("instance"));
        hVar.mo11035a(TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, ASMUtils.m3171b(ParseContext.class), "object", "Ljava/lang/Object;");
        hVar.mo11036a(fVar);
    }

    /* renamed from: a */
    private void m2622a(C1262a aVar, MethodVisitor hVar, Label fVar) {
        hVar.mo11032a(21, aVar.mo11158a("matchedCount"));
        hVar.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, fVar);
        hVar.mo11038b(25, aVar.mo11158a("lexer"));
        hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "token", "()I");
        hVar.mo11037a((Object) Integer.valueOf(13));
        hVar.mo11033a(160, fVar);
        m2637e(aVar, hVar);
    }

    /* renamed from: a */
    private void m2624a(C1262a aVar, MethodVisitor hVar, Label fVar, FieldInfo cVar, Class<?> cls, Class<?> cls2, int i) {
        String str;
        String str2;
        C1262a aVar2 = aVar;
        MethodVisitor hVar2 = hVar;
        Label fVar2 = fVar;
        FieldInfo cVar2 = cVar;
        Class<?> cls3 = cls;
        Class<?> cls4 = cls2;
        int i2 = i;
        Label fVar3 = new Label();
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "matchField", "([C)Z");
        hVar2.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, fVar3);
        m2617a(hVar2, aVar2, i2);
        Label fVar4 = new Label();
        String str3 = "lexer";
        hVar2.mo11038b(25, aVar2.mo11158a(str3));
        String str4 = "token";
        String str5 = "()I";
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, str4, str5);
        hVar2.mo11037a((Object) Integer.valueOf(8));
        hVar2.mo11033a(160, fVar4);
        hVar2.mo11038b(25, aVar2.mo11158a(str3));
        hVar2.mo11037a((Object) Integer.valueOf(16));
        String str6 = "(I)V";
        String str7 = "nextToken";
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, str7, str6);
        hVar2.mo11033a(167, fVar3);
        hVar2.mo11036a(fVar4);
        Label fVar5 = new Label();
        Label fVar6 = new Label();
        Label fVar7 = new Label();
        Label fVar8 = fVar3;
        hVar2.mo11038b(25, aVar2.mo11158a(str3));
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, str4, str5);
        hVar2.mo11037a((Object) Integer.valueOf(21));
        hVar2.mo11033a(160, fVar6);
        hVar2.mo11038b(25, aVar2.mo11158a(str3));
        hVar2.mo11037a((Object) Integer.valueOf(14));
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, str7, str6);
        m2619a(hVar2, cls3, i2, true);
        hVar2.mo11033a(167, fVar5);
        hVar2.mo11036a(fVar6);
        hVar2.mo11038b(25, aVar2.mo11158a(str3));
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, str4, str5);
        hVar2.mo11037a((Object) Integer.valueOf(14));
        hVar2.mo11033a(159, fVar7);
        hVar2.mo11038b(25, aVar2.mo11158a(str3));
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, str4, str5);
        Integer valueOf = Integer.valueOf(12);
        hVar2.mo11037a((Object) valueOf);
        hVar2.mo11033a(160, fVar2);
        m2619a(hVar2, cls3, i2, false);
        StringBuilder sb = new StringBuilder();
        FieldInfo cVar3 = cVar;
        String str8 = str7;
        sb.append(cVar3.f2992a);
        String str9 = "_asm";
        sb.append(str9);
        hVar2.mo11038b(58, aVar2.mo11158a(sb.toString()));
        Class<?> cls5 = cls2;
        String str10 = str8;
        m2626a(aVar2, hVar2, cVar3, cls5);
        String str11 = str4;
        hVar2.mo11038b(25, 1);
        hVar2.mo11037a((Object) com.alibaba.fastjson.p065a.Type.m2508a(ASMUtils.m3167a(cls2)));
        hVar2.mo11031a(3);
        Integer num = valueOf;
        String str12 = str6;
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        String b = ASMUtils.m3171b(ObjectDeserializer.class);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(L");
        sb2.append(f2705c);
        sb2.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        hVar2.mo11039b(185, b, "deserialze", sb2.toString());
        hVar2.mo11038b(58, aVar2.mo11158a("list_item_value"));
        StringBuilder sb3 = new StringBuilder();
        sb3.append(cVar3.f2992a);
        sb3.append(str9);
        hVar2.mo11038b(25, aVar2.mo11158a(sb3.toString()));
        hVar2.mo11038b(25, aVar2.mo11158a("list_item_value"));
        if (cls.isInterface()) {
            hVar2.mo11039b(185, ASMUtils.m3171b(cls), "add", "(Ljava/lang/Object;)Z");
        } else {
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, ASMUtils.m3171b(cls), "add", "(Ljava/lang/Object;)Z");
        }
        hVar2.mo11031a(87);
        Label fVar9 = fVar8;
        hVar2.mo11033a(167, fVar9);
        hVar2.mo11036a(fVar7);
        m2619a(hVar2, cls3, i2, false);
        hVar2.mo11036a(fVar5);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(cVar3.f2992a);
        sb4.append(str9);
        hVar2.mo11038b(58, aVar2.mo11158a(sb4.toString()));
        boolean a = ParserConfig.m2908a(cVar3.f2995d);
        m2626a(aVar2, hVar2, cVar3, cls5);
        if (a) {
            hVar2.mo11039b(185, ASMUtils.m3171b(ObjectDeserializer.class), "getFastMatchToken", str5);
            hVar2.mo11038b(54, aVar2.mo11158a("fastMatchToken"));
            hVar2.mo11038b(25, aVar2.mo11158a(str3));
            hVar2.mo11038b(21, aVar2.mo11158a("fastMatchToken"));
            str = str10;
            str2 = str12;
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, str, str2);
        } else {
            str = str10;
            str2 = str12;
            hVar2.mo11031a(87);
            hVar2.mo11037a((Object) num);
            hVar2.mo11038b(54, aVar2.mo11158a("fastMatchToken"));
            m2621a(aVar2, hVar2, 12);
        }
        hVar2.mo11038b(25, 1);
        String str13 = f2705c;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("()");
        sb5.append(ASMUtils.m3167a(ParseContext.class));
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str13, "getContext", sb5.toString());
        hVar2.mo11038b(58, aVar2.mo11158a("listContext"));
        hVar2.mo11038b(25, 1);
        StringBuilder sb6 = new StringBuilder();
        sb6.append(cVar3.f2992a);
        sb6.append(str9);
        hVar2.mo11038b(25, aVar2.mo11158a(sb6.toString()));
        hVar2.mo11037a((Object) cVar3.f2992a);
        String str14 = f2705c;
        StringBuilder sb7 = new StringBuilder();
        sb7.append("(Ljava/lang/Object;Ljava/lang/Object;)");
        sb7.append(ASMUtils.m3167a(ParseContext.class));
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str14, "setContext", sb7.toString());
        hVar2.mo11031a(87);
        Label fVar10 = new Label();
        Label fVar11 = new Label();
        hVar2.mo11031a(3);
        hVar2.mo11038b(54, aVar2.mo11158a("i"));
        hVar2.mo11036a(fVar10);
        hVar2.mo11038b(25, aVar2.mo11158a(str3));
        String str15 = str11;
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, str15, str5);
        hVar2.mo11037a((Object) Integer.valueOf(15));
        hVar2.mo11033a(159, fVar11);
        hVar2.mo11038b(25, 0);
        String d = aVar.f2713e;
        StringBuilder sb8 = new StringBuilder();
        Label fVar12 = fVar9;
        sb8.append(cVar3.f2992a);
        sb8.append("_asm_list_item_deser__");
        Label fVar13 = fVar11;
        hVar2.mo11035a(TinkerReport.KEY_APPLIED_VERSION_CHECK, d, sb8.toString(), ASMUtils.m3167a(ObjectDeserializer.class));
        hVar2.mo11038b(25, 1);
        hVar2.mo11037a((Object) com.alibaba.fastjson.p065a.Type.m2508a(ASMUtils.m3167a(cls2)));
        hVar2.mo11038b(21, aVar2.mo11158a("i"));
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        String b2 = ASMUtils.m3171b(ObjectDeserializer.class);
        StringBuilder sb9 = new StringBuilder();
        sb9.append("(L");
        sb9.append(f2705c);
        sb9.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        hVar2.mo11039b(185, b2, "deserialze", sb9.toString());
        hVar2.mo11038b(58, aVar2.mo11158a("list_item_value"));
        hVar2.mo11040c(aVar2.mo11158a("i"), 1);
        StringBuilder sb10 = new StringBuilder();
        sb10.append(cVar3.f2992a);
        sb10.append(str9);
        hVar2.mo11038b(25, aVar2.mo11158a(sb10.toString()));
        hVar2.mo11038b(25, aVar2.mo11158a("list_item_value"));
        if (cls.isInterface()) {
            hVar2.mo11039b(185, ASMUtils.m3171b(cls), "add", "(Ljava/lang/Object;)Z");
        } else {
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, ASMUtils.m3171b(cls), "add", "(Ljava/lang/Object;)Z");
        }
        hVar2.mo11031a(87);
        hVar2.mo11038b(25, 1);
        StringBuilder sb11 = new StringBuilder();
        sb11.append(cVar3.f2992a);
        sb11.append(str9);
        hVar2.mo11038b(25, aVar2.mo11158a(sb11.toString()));
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2705c, "checkListResolve", "(Ljava/util/Collection;)V");
        hVar2.mo11038b(25, aVar2.mo11158a(str3));
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, str15, str5);
        hVar2.mo11037a((Object) Integer.valueOf(16));
        hVar2.mo11033a(160, fVar10);
        if (a) {
            hVar2.mo11038b(25, aVar2.mo11158a(str3));
            hVar2.mo11038b(21, aVar2.mo11158a("fastMatchToken"));
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, str, str2);
        } else {
            m2621a(aVar2, hVar2, 12);
        }
        hVar2.mo11033a(167, fVar10);
        hVar2.mo11036a(fVar13);
        hVar2.mo11038b(25, 1);
        hVar2.mo11038b(25, aVar2.mo11158a("listContext"));
        String str16 = f2705c;
        StringBuilder sb12 = new StringBuilder();
        sb12.append("(");
        sb12.append(ASMUtils.m3167a(ParseContext.class));
        sb12.append(")V");
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str16, "setContext", sb12.toString());
        hVar2.mo11038b(25, aVar2.mo11158a(str3));
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, str15, str5);
        hVar2.mo11037a((Object) Integer.valueOf(15));
        hVar2.mo11033a(160, fVar);
        m2637e(aVar, hVar);
        hVar2.mo11036a(fVar12);
    }

    /* renamed from: a */
    private void m2621a(C1262a aVar, MethodVisitor hVar, int i) {
        Label fVar = new Label();
        Label fVar2 = new Label();
        String str = "lexer";
        hVar.mo11038b(25, aVar.mo11158a(str));
        String str2 = "()C";
        hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "getCurrent", str2);
        if (i == 12) {
            hVar.mo11038b(16, 123);
        } else if (i == 14) {
            hVar.mo11038b(16, 91);
        } else {
            throw new IllegalStateException();
        }
        hVar.mo11033a(160, fVar);
        hVar.mo11038b(25, aVar.mo11158a(str));
        hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "next", str2);
        hVar.mo11031a(87);
        hVar.mo11038b(25, aVar.mo11158a(str));
        hVar.mo11037a((Object) Integer.valueOf(i));
        String str3 = "(I)V";
        hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "setToken", str3);
        hVar.mo11033a(167, fVar2);
        hVar.mo11036a(fVar);
        hVar.mo11038b(25, aVar.mo11158a(str));
        hVar.mo11037a((Object) Integer.valueOf(i));
        hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "nextToken", str3);
        hVar.mo11036a(fVar2);
    }

    /* renamed from: e */
    private void m2637e(C1262a aVar, MethodVisitor hVar) {
        C1262a aVar2 = aVar;
        MethodVisitor hVar2 = hVar;
        Label fVar = new Label();
        Label fVar2 = new Label();
        Label fVar3 = new Label();
        Label fVar4 = new Label();
        Label fVar5 = new Label();
        String str = "lexer";
        hVar2.mo11038b(25, aVar2.mo11158a(str));
        String str2 = "()C";
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "getCurrent", str2);
        hVar2.mo11031a(89);
        String str3 = "ch";
        hVar2.mo11038b(54, aVar2.mo11158a(str3));
        hVar2.mo11038b(16, 44);
        hVar2.mo11033a(160, fVar2);
        hVar2.mo11038b(25, aVar2.mo11158a(str));
        String str4 = "next";
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, str4, str2);
        hVar2.mo11031a(87);
        hVar2.mo11038b(25, aVar2.mo11158a(str));
        hVar2.mo11037a((Object) Integer.valueOf(16));
        String str5 = "(I)V";
        String str6 = "setToken";
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, str6, str5);
        hVar2.mo11033a(167, fVar5);
        hVar2.mo11036a(fVar2);
        hVar2.mo11038b(21, aVar2.mo11158a(str3));
        hVar2.mo11038b(16, 125);
        hVar2.mo11033a(160, fVar3);
        hVar2.mo11038b(25, aVar2.mo11158a(str));
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, str4, str2);
        hVar2.mo11031a(87);
        hVar2.mo11038b(25, aVar2.mo11158a(str));
        hVar2.mo11037a((Object) Integer.valueOf(13));
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, str6, str5);
        hVar2.mo11033a(167, fVar5);
        hVar2.mo11036a(fVar3);
        hVar2.mo11038b(21, aVar2.mo11158a(str3));
        hVar2.mo11038b(16, 93);
        hVar2.mo11033a(160, fVar4);
        hVar2.mo11038b(25, aVar2.mo11158a(str));
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, str4, str2);
        hVar2.mo11031a(87);
        hVar2.mo11038b(25, aVar2.mo11158a(str));
        hVar2.mo11037a((Object) Integer.valueOf(15));
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, str6, str5);
        hVar2.mo11033a(167, fVar5);
        hVar2.mo11036a(fVar4);
        hVar2.mo11038b(21, aVar2.mo11158a(str3));
        hVar2.mo11038b(16, 26);
        hVar2.mo11033a(160, fVar);
        hVar2.mo11038b(25, aVar2.mo11158a(str));
        hVar2.mo11037a((Object) Integer.valueOf(20));
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, str6, str5);
        hVar2.mo11033a(167, fVar5);
        hVar2.mo11036a(fVar);
        hVar2.mo11038b(25, aVar2.mo11158a(str));
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "nextToken", "()V");
        hVar2.mo11036a(fVar5);
    }

    /* renamed from: a */
    private void m2626a(C1262a aVar, MethodVisitor hVar, FieldInfo cVar, Class<?> cls) {
        Label fVar = new Label();
        hVar.mo11038b(25, 0);
        String d = aVar.f2713e;
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.f2992a);
        String str = "_asm_list_item_deser__";
        sb.append(str);
        hVar.mo11035a(TinkerReport.KEY_APPLIED_VERSION_CHECK, d, sb.toString(), ASMUtils.m3167a(ObjectDeserializer.class));
        hVar.mo11033a(199, fVar);
        hVar.mo11038b(25, 0);
        hVar.mo11038b(25, 1);
        String str2 = f2705c;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("()");
        sb2.append(ASMUtils.m3167a(ParserConfig.class));
        hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str2, "getConfig", sb2.toString());
        hVar.mo11037a((Object) com.alibaba.fastjson.p065a.Type.m2508a(ASMUtils.m3167a(cls)));
        String b = ASMUtils.m3171b(ParserConfig.class);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("(Ljava/lang/reflect/Type;)");
        sb3.append(ASMUtils.m3167a(ObjectDeserializer.class));
        hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, b, "getDeserializer", sb3.toString());
        String d2 = aVar.f2713e;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(cVar.f2992a);
        sb4.append(str);
        hVar.mo11035a(TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, d2, sb4.toString(), ASMUtils.m3167a(ObjectDeserializer.class));
        hVar.mo11036a(fVar);
        hVar.mo11038b(25, 0);
        String d3 = aVar.f2713e;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(cVar.f2992a);
        sb5.append(str);
        hVar.mo11035a(TinkerReport.KEY_APPLIED_VERSION_CHECK, d3, sb5.toString(), ASMUtils.m3167a(ObjectDeserializer.class));
    }

    /* renamed from: a */
    private void m2619a(MethodVisitor hVar, Class<?> cls, int i, boolean z) {
        String str = "()V";
        String str2 = "<init>";
        if (cls.isAssignableFrom(ArrayList.class) && !z) {
            String str3 = "java/util/ArrayList";
            hVar.mo11034a(187, str3);
            hVar.mo11031a(89);
            hVar.mo11039b(TinkerReport.KEY_APPLIED_LIB_EXTRACT, str3, str2, str);
        } else if (cls.isAssignableFrom(LinkedList.class) && !z) {
            hVar.mo11034a(187, ASMUtils.m3171b(LinkedList.class));
            hVar.mo11031a(89);
            hVar.mo11039b(TinkerReport.KEY_APPLIED_LIB_EXTRACT, ASMUtils.m3171b(LinkedList.class), str2, str);
        } else if (cls.isAssignableFrom(HashSet.class)) {
            hVar.mo11034a(187, ASMUtils.m3171b(HashSet.class));
            hVar.mo11031a(89);
            hVar.mo11039b(TinkerReport.KEY_APPLIED_LIB_EXTRACT, ASMUtils.m3171b(HashSet.class), str2, str);
        } else if (cls.isAssignableFrom(TreeSet.class)) {
            hVar.mo11034a(187, ASMUtils.m3171b(TreeSet.class));
            hVar.mo11031a(89);
            hVar.mo11039b(TinkerReport.KEY_APPLIED_LIB_EXTRACT, ASMUtils.m3171b(TreeSet.class), str2, str);
        } else if (cls.isAssignableFrom(LinkedHashSet.class)) {
            hVar.mo11034a(187, ASMUtils.m3171b(LinkedHashSet.class));
            hVar.mo11031a(89);
            hVar.mo11039b(TinkerReport.KEY_APPLIED_LIB_EXTRACT, ASMUtils.m3171b(LinkedHashSet.class), str2, str);
        } else if (z) {
            hVar.mo11034a(187, ASMUtils.m3171b(HashSet.class));
            hVar.mo11031a(89);
            hVar.mo11039b(TinkerReport.KEY_APPLIED_LIB_EXTRACT, ASMUtils.m3171b(HashSet.class), str2, str);
        } else {
            hVar.mo11038b(25, 0);
            hVar.mo11037a((Object) Integer.valueOf(i));
            hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, ASMUtils.m3171b(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            hVar.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, ASMUtils.m3171b(TypeUtils.class), "createCollection", "(Ljava/lang/reflect/Type;)Ljava/util/Collection;");
        }
        hVar.mo11034a(192, ASMUtils.m3171b(cls));
    }

    /* renamed from: a */
    private void m2623a(C1262a aVar, MethodVisitor hVar, Label fVar, FieldInfo cVar, Class<?> cls, int i) {
        C1262a aVar2 = aVar;
        MethodVisitor hVar2 = hVar;
        FieldInfo cVar2 = cVar;
        Label fVar2 = new Label();
        Label fVar3 = new Label();
        hVar2.mo11038b(25, aVar2.mo11158a("lexer"));
        hVar2.mo11038b(25, 0);
        String d = aVar.f2713e;
        StringBuilder sb = new StringBuilder();
        sb.append(cVar2.f2992a);
        sb.append("_asm_prefix__");
        hVar2.mo11035a(TinkerReport.KEY_APPLIED_VERSION_CHECK, d, sb.toString(), "[C");
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2706d, "matchField", "([C)Z");
        hVar2.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND, fVar2);
        hVar2.mo11031a(1);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cVar2.f2992a);
        sb2.append("_asm");
        hVar2.mo11038b(58, aVar2.mo11158a(sb2.toString()));
        hVar2.mo11033a(167, fVar3);
        hVar2.mo11036a(fVar2);
        int i2 = i;
        m2617a(hVar2, aVar2, i2);
        String str = "matchedCount";
        hVar2.mo11038b(21, aVar2.mo11158a(str));
        hVar2.mo11031a(4);
        hVar2.mo11031a(96);
        hVar2.mo11038b(54, aVar2.mo11158a(str));
        m2627a(aVar, hVar, cVar, cls, i2);
        hVar2.mo11038b(25, 1);
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2705c, "getResolveStatus", "()I");
        hVar2.mo11037a((Object) Integer.valueOf(1));
        hVar2.mo11033a(160, fVar3);
        hVar2.mo11038b(25, 1);
        String str2 = f2705c;
        StringBuilder sb3 = new StringBuilder();
        String str3 = "()";
        sb3.append(str3);
        sb3.append(ASMUtils.m3167a(C1261a.class));
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str2, "getLastResolveTask", sb3.toString());
        String str4 = "resolveTask";
        hVar2.mo11038b(58, aVar2.mo11158a(str4));
        hVar2.mo11038b(25, aVar2.mo11158a(str4));
        hVar2.mo11038b(25, 1);
        String str5 = f2705c;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str3);
        sb4.append(ASMUtils.m3167a(ParseContext.class));
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str5, "getContext", sb4.toString());
        hVar2.mo11035a(TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, ASMUtils.m3171b(C1261a.class), "ownerContext", ASMUtils.m3167a(ParseContext.class));
        hVar2.mo11038b(25, aVar2.mo11158a(str4));
        hVar2.mo11038b(25, 0);
        hVar2.mo11037a((Object) cVar2.f2992a);
        String b = ASMUtils.m3171b(JavaBeanDeserializer.class);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("(Ljava/lang/String;)");
        sb5.append(ASMUtils.m3167a(FieldDeserializer.class));
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, b, "getFieldDeserializer", sb5.toString());
        hVar2.mo11035a(TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, ASMUtils.m3171b(C1261a.class), "fieldDeserializer", ASMUtils.m3167a(FieldDeserializer.class));
        hVar2.mo11038b(25, 1);
        hVar2.mo11037a((Object) Integer.valueOf(0));
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2705c, "setResolveStatus", "(I)V");
        hVar2.mo11036a(fVar3);
    }

    /* renamed from: a */
    private void m2627a(C1262a aVar, MethodVisitor hVar, FieldInfo cVar, Class<?> cls, int i) {
        C1262a aVar2 = aVar;
        MethodVisitor hVar2 = hVar;
        FieldInfo cVar2 = cVar;
        m2634c(aVar, hVar, cVar);
        Label fVar = new Label();
        Label fVar2 = new Label();
        String str = "_asm";
        String str2 = "(L";
        String str3 = "deserialze";
        String str4 = "(I)Ljava/lang/reflect/Type;";
        String str5 = "getFieldType";
        if ((cVar2.f3000i & Feature.SupportArrayToBean.mask) != 0) {
            hVar2.mo11031a(89);
            hVar2.mo11034a(193, ASMUtils.m3171b(JavaBeanDeserializer.class));
            hVar2.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, fVar);
            hVar2.mo11034a(192, ASMUtils.m3171b(JavaBeanDeserializer.class));
            hVar2.mo11038b(25, 1);
            if (cVar2.f2996e instanceof Class) {
                hVar2.mo11037a((Object) com.alibaba.fastjson.p065a.Type.m2508a(ASMUtils.m3167a(cVar2.f2995d)));
            } else {
                hVar2.mo11038b(25, 0);
                hVar2.mo11037a((Object) Integer.valueOf(i));
                hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, ASMUtils.m3171b(JavaBeanDeserializer.class), str5, str4);
            }
            hVar2.mo11037a((Object) cVar2.f2992a);
            hVar2.mo11037a((Object) Integer.valueOf(cVar2.f3000i));
            String b = ASMUtils.m3171b(JavaBeanDeserializer.class);
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(f2705c);
            sb.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;");
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, b, str3, sb.toString());
            hVar2.mo11034a(192, ASMUtils.m3171b(cls));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cVar2.f2992a);
            sb2.append(str);
            hVar2.mo11038b(58, aVar2.mo11158a(sb2.toString()));
            hVar2.mo11033a(167, fVar2);
            hVar2.mo11036a(fVar);
        }
        hVar2.mo11038b(25, 1);
        if (cVar2.f2996e instanceof Class) {
            hVar2.mo11037a((Object) com.alibaba.fastjson.p065a.Type.m2508a(ASMUtils.m3167a(cVar2.f2995d)));
        } else {
            hVar2.mo11038b(25, 0);
            hVar2.mo11037a((Object) Integer.valueOf(i));
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, ASMUtils.m3171b(JavaBeanDeserializer.class), str5, str4);
        }
        hVar2.mo11037a((Object) cVar2.f2992a);
        String b2 = ASMUtils.m3171b(ObjectDeserializer.class);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str2);
        sb3.append(f2705c);
        sb3.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        hVar2.mo11039b(185, b2, str3, sb3.toString());
        hVar2.mo11034a(192, ASMUtils.m3171b(cls));
        StringBuilder sb4 = new StringBuilder();
        sb4.append(cVar2.f2992a);
        sb4.append(str);
        hVar2.mo11038b(58, aVar2.mo11158a(sb4.toString()));
        hVar2.mo11036a(fVar2);
    }

    /* renamed from: c */
    private void m2634c(C1262a aVar, MethodVisitor hVar, FieldInfo cVar) {
        Label fVar = new Label();
        hVar.mo11038b(25, 0);
        String d = aVar.f2713e;
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.f2992a);
        String str = "_asm_deser__";
        sb.append(str);
        hVar.mo11035a(TinkerReport.KEY_APPLIED_VERSION_CHECK, d, sb.toString(), ASMUtils.m3167a(ObjectDeserializer.class));
        hVar.mo11033a(199, fVar);
        hVar.mo11038b(25, 0);
        hVar.mo11038b(25, 1);
        String str2 = f2705c;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("()");
        sb2.append(ASMUtils.m3167a(ParserConfig.class));
        hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str2, "getConfig", sb2.toString());
        hVar.mo11037a((Object) com.alibaba.fastjson.p065a.Type.m2508a(ASMUtils.m3167a(cVar.f2995d)));
        String b = ASMUtils.m3171b(ParserConfig.class);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("(Ljava/lang/reflect/Type;)");
        sb3.append(ASMUtils.m3167a(ObjectDeserializer.class));
        hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, b, "getDeserializer", sb3.toString());
        String d2 = aVar.f2713e;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(cVar.f2992a);
        sb4.append(str);
        hVar.mo11035a(TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, d2, sb4.toString(), ASMUtils.m3167a(ObjectDeserializer.class));
        hVar.mo11036a(fVar);
        hVar.mo11038b(25, 0);
        String d3 = aVar.f2713e;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(cVar.f2992a);
        sb5.append(str);
        hVar.mo11035a(TinkerReport.KEY_APPLIED_VERSION_CHECK, d3, sb5.toString(), ASMUtils.m3167a(ObjectDeserializer.class));
    }

    /* renamed from: c */
    private void m2632c(ClassWriter cVar, C1262a aVar) {
        String str;
        String str2;
        ClassWriter cVar2 = cVar;
        int length = aVar.f2714f.length;
        int i = 0;
        while (true) {
            str = "[C";
            str2 = "_asm_prefix__";
            if (i >= length) {
                break;
            }
            FieldInfo cVar3 = aVar.f2714f[i];
            StringBuilder sb = new StringBuilder();
            sb.append(cVar3.f2992a);
            sb.append(str2);
            new FieldWriter(cVar, 1, sb.toString(), str).mo11020a();
            i++;
        }
        for (FieldInfo cVar4 : aVar.f2714f) {
            Class<?> cls = cVar4.f2995d;
            if (!cls.isPrimitive()) {
                if (Collection.class.isAssignableFrom(cls)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(cVar4.f2992a);
                    sb2.append("_asm_list_item_deser__");
                    new FieldWriter(cVar, 1, sb2.toString(), ASMUtils.m3167a(ObjectDeserializer.class)).mo11020a();
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(cVar4.f2992a);
                    sb3.append("_asm_deser__");
                    new FieldWriter(cVar, 1, sb3.toString(), ASMUtils.m3167a(ObjectDeserializer.class)).mo11020a();
                }
            }
        }
        StringBuilder sb4 = new StringBuilder();
        String str3 = "(";
        sb4.append(str3);
        sb4.append(ASMUtils.m3167a(ParserConfig.class));
        sb4.append(ASMUtils.m3167a(JavaBeanInfo.class));
        String str4 = ")V";
        sb4.append(str4);
        MethodWriter iVar = new MethodWriter(cVar, 1, "<init>", sb4.toString(), null, null);
        iVar.mo11038b(25, 0);
        iVar.mo11038b(25, 1);
        iVar.mo11038b(25, 2);
        String b = ASMUtils.m3171b(JavaBeanDeserializer.class);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str3);
        sb5.append(ASMUtils.m3167a(ParserConfig.class));
        sb5.append(ASMUtils.m3167a(JavaBeanInfo.class));
        sb5.append(str4);
        iVar.mo11039b(TinkerReport.KEY_APPLIED_LIB_EXTRACT, b, "<init>", sb5.toString());
        for (FieldInfo cVar5 : aVar.f2714f) {
            iVar.mo11038b(25, 0);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("\"");
            sb6.append(cVar5.f2992a);
            sb6.append("\":");
            iVar.mo11037a((Object) sb6.toString());
            iVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, "java/lang/String", "toCharArray", "()[C");
            String d = aVar.f2713e;
            StringBuilder sb7 = new StringBuilder();
            sb7.append(cVar5.f2992a);
            sb7.append(str2);
            iVar.mo11035a(TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, d, sb7.toString(), str);
        }
        iVar.mo11031a(177);
        iVar.mo11041d(4, 4);
        iVar.mo11030a();
    }

    /* renamed from: d */
    private void m2635d(ClassWriter cVar, C1262a aVar) {
        if (Modifier.isPublic(aVar.f2712d.f3038c.getModifiers())) {
            StringBuilder sb = new StringBuilder();
            sb.append("(L");
            sb.append(f2705c);
            sb.append(";Ljava/lang/reflect/Type;)Ljava/lang/Object;");
            ClassWriter cVar2 = cVar;
            MethodWriter iVar = new MethodWriter(cVar2, 1, "createInstance", sb.toString(), null, null);
            iVar.mo11034a(187, ASMUtils.m3171b(aVar.mo11160a()));
            iVar.mo11031a(89);
            iVar.mo11039b(TinkerReport.KEY_APPLIED_LIB_EXTRACT, ASMUtils.m3171b(aVar.mo11160a()), "<init>", "()V");
            iVar.mo11031a(176);
            iVar.mo11041d(3, 3);
            iVar.mo11030a();
        }
    }
}
