package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.p065a.ClassWriter;
import com.alibaba.fastjson.p065a.FieldWriter;
import com.alibaba.fastjson.p065a.Label;
import com.alibaba.fastjson.p065a.MethodVisitor;
import com.alibaba.fastjson.p065a.MethodWriter;
import com.alibaba.fastjson.p065a.Type;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.tencent.android.tpush.SettingsContentProvider;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.alibaba.fastjson.serializer.a */
public class ASMSerializerFactory {
    /* renamed from: b */
    static final String f2818b = ASMUtils.m3171b(JSONSerializer.class);
    /* renamed from: c */
    static final String f2819c = ASMUtils.m3171b(ObjectSerializer.class);
    /* renamed from: d */
    static final String f2820d;
    /* renamed from: e */
    static final String f2821e = ASMUtils.m3171b(SerializeWriter.class);
    /* renamed from: f */
    static final String f2822f;
    /* renamed from: g */
    static final String f2823g = ASMUtils.m3171b(JavaBeanSerializer.class);
    /* renamed from: h */
    static final String f2824h;
    /* renamed from: i */
    static final String f2825i = ASMUtils.m3167a(SerialContext.class);
    /* renamed from: j */
    static final String f2826j = ASMUtils.m3167a(SerializeFilterable.class);
    /* renamed from: a */
    protected final ASMClassLoader f2827a = new ASMClassLoader();
    /* renamed from: k */
    private final AtomicLong f2828k = new AtomicLong();

    /* compiled from: ASMSerializerFactory */
    /* renamed from: com.alibaba.fastjson.serializer.a$a */
    static class C1263a {
        /* renamed from: a */
        static int f2829a = 6;
        /* renamed from: b */
        static int f2830b = 7;
        /* renamed from: c */
        static int f2831c = 8;
        /* renamed from: d */
        private final FieldInfo[] f2832d;
        /* access modifiers changed from: private|final */
        /* renamed from: e */
        public final String f2833e;
        /* access modifiers changed from: private|final */
        /* renamed from: f */
        public final SerializeBeanInfo f2834f;
        /* access modifiers changed from: private|final */
        /* renamed from: g */
        public final boolean f2835g;
        /* renamed from: h */
        private Map<String, Integer> f2836h = new HashMap();
        /* access modifiers changed from: private */
        /* renamed from: i */
        public int f2837i = 9;
        /* access modifiers changed from: private|final */
        /* renamed from: j */
        public final boolean f2838j;

        public C1263a(FieldInfo[] cVarArr, SerializeBeanInfo awVar, String str, boolean z, boolean z2) {
            this.f2832d = cVarArr;
            this.f2833e = str;
            this.f2834f = awVar;
            this.f2835g = z;
            boolean z3 = z2 || awVar.f2875a.isEnum();
            this.f2838j = z3;
        }

        /* renamed from: a */
        public int mo11306a(String str) {
            if (((Integer) this.f2836h.get(str)) == null) {
                Map<String, Integer> map = this.f2836h;
                int i = this.f2837i;
                this.f2837i = i + 1;
                map.put(str, Integer.valueOf(i));
            }
            return ((Integer) this.f2836h.get(str)).intValue();
        }

        /* renamed from: a */
        public int mo11307a(String str, int i) {
            if (((Integer) this.f2836h.get(str)) == null) {
                this.f2836h.put(str, Integer.valueOf(this.f2837i));
                this.f2837i += i;
            }
            return ((Integer) this.f2836h.get(str)).intValue();
        }

        /* renamed from: b */
        public int mo11308b(String str) {
            int length = this.f2832d.length;
            for (int i = 0; i < length; i++) {
                if (this.f2832d[i].f2992a.equals(str)) {
                    return i;
                }
            }
            return -1;
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        String str = "L";
        sb.append(str);
        sb.append(f2819c);
        String str2 = ";";
        sb.append(str2);
        f2820d = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(f2821e);
        sb2.append(str2);
        f2822f = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(ASMUtils.m3171b(JavaBeanSerializer.class));
        sb3.append(str2);
        f2824h = sb3.toString();
    }

    /* renamed from: a */
    public JavaBeanSerializer mo11305a(SerializeBeanInfo awVar) throws Exception {
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        FieldInfo[] cVarArr;
        String str5;
        String str6;
        boolean z2;
        boolean z3;
        boolean z4;
        String str7;
        boolean z5;
        String str8;
        boolean z6;
        JSONType jSONType;
        ClassWriter cVar;
        int i;
        SerializeBeanInfo awVar2 = awVar;
        Class<?> cls = awVar2.f2875a;
        if (!cls.isPrimitive()) {
            JSONType jSONType2 = (JSONType) TypeUtils.m3228a(cls, JSONType.class);
            FieldInfo[] cVarArr2 = awVar2.f2879e;
            int length = cVarArr2.length;
            for (int i2 = 0; i2 < length; i2++) {
                FieldInfo cVar2 = cVarArr2[i2];
                if (cVar2.f2994c == null && cVar2.f2993b != null && cVar2.f2993b.getDeclaringClass().isInterface()) {
                    return new JavaBeanSerializer(awVar2);
                }
            }
            FieldInfo[] cVarArr3 = awVar2.f2880f;
            boolean z7 = awVar2.f2880f == awVar2.f2879e;
            if (cVarArr3.length > 256) {
                return new JavaBeanSerializer(awVar2);
            }
            for (FieldInfo b : cVarArr3) {
                if (!ASMUtils.m3172b(b.mo11503b().getName())) {
                    return new JavaBeanSerializer(awVar2);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ASMSerializer_");
            sb.append(this.f2828k.incrementAndGet());
            sb.append("_");
            sb.append(cls.getSimpleName());
            String sb2 = sb.toString();
            String name = ASMSerializerFactory.class.getPackage().getName();
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
            ClassWriter cVar3 = new ClassWriter();
            cVar3.mo11017a(49, 33, sb4, f2823g, new String[]{f2819c});
            int length2 = cVarArr3.length;
            int i3 = 0;
            while (i3 < length2) {
                FieldInfo cVar4 = cVarArr3[i3];
                if (cVar4.f2995d.isPrimitive() || cVar4.f2995d == String.class) {
                    i = length2;
                } else {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(cVar4.f2992a);
                    sb7.append("_asm_fieldType");
                    i = length2;
                    new FieldWriter(cVar3, 1, sb7.toString(), "Ljava/lang/reflect/Type;").mo11020a();
                    if (List.class.isAssignableFrom(cVar4.f2995d)) {
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append(cVar4.f2992a);
                        sb8.append("_asm_list_item_ser_");
                        new FieldWriter(cVar3, 1, sb8.toString(), f2820d).mo11020a();
                    }
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append(cVar4.f2992a);
                    sb9.append("_asm_ser_");
                    new FieldWriter(cVar3, 1, sb9.toString(), f2820d).mo11020a();
                }
                i3++;
                length2 = i;
            }
            StringBuilder sb10 = new StringBuilder();
            sb10.append("(");
            sb10.append(ASMUtils.m3167a(SerializeBeanInfo.class));
            sb10.append(")V");
            MethodWriter iVar = new MethodWriter(cVar3, 1, "<init>", sb10.toString(), null, null);
            int i4 = 25;
            iVar.mo11038b(25, 0);
            iVar.mo11038b(25, 1);
            String str9 = f2823g;
            StringBuilder sb11 = new StringBuilder();
            sb11.append("(");
            sb11.append(ASMUtils.m3167a(SerializeBeanInfo.class));
            sb11.append(")V");
            iVar.mo11039b(TinkerReport.KEY_APPLIED_LIB_EXTRACT, str9, "<init>", sb11.toString());
            int i5 = 0;
            while (i5 < cVarArr3.length) {
                FieldInfo cVar5 = cVarArr3[i5];
                if (cVar5.f2995d.isPrimitive() || cVar5.f2995d == String.class) {
                    cVar = cVar3;
                } else {
                    iVar.mo11038b(i4, 0);
                    if (cVar5.f2993b != null) {
                        iVar.mo11037a((Object) Type.m2508a(ASMUtils.m3167a(cVar5.f2997f)));
                        iVar.mo11037a((Object) cVar5.f2993b.getName());
                        cVar = cVar3;
                        iVar.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, ASMUtils.m3171b(ASMUtils.class), "getMethodType", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Type;");
                    } else {
                        cVar = cVar3;
                        iVar.mo11038b(i4, 0);
                        iVar.mo11037a((Object) Integer.valueOf(i5));
                        iVar.mo11039b(TinkerReport.KEY_APPLIED_LIB_EXTRACT, f2823g, "getFieldType", "(I)Ljava/lang/reflect/Type;");
                    }
                    StringBuilder sb12 = new StringBuilder();
                    sb12.append(cVar5.f2992a);
                    sb12.append("_asm_fieldType");
                    iVar.mo11035a(TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, sb4, sb12.toString(), "Ljava/lang/reflect/Type;");
                }
                i5++;
                cVar3 = cVar;
                i4 = 25;
            }
            ClassWriter cVar6 = cVar3;
            iVar.mo11031a(177);
            iVar.mo11041d(4, 4);
            iVar.mo11030a();
            if (jSONType2 != null) {
                SerializerFeature[] serialzeFeatures = jSONType2.serialzeFeatures();
                int length3 = serialzeFeatures.length;
                int i6 = 0;
                while (true) {
                    if (i6 >= length3) {
                        break;
                    } else if (serialzeFeatures[i6] == SerializerFeature.DisableCircularReferenceDetect) {
                        z = true;
                        break;
                    } else {
                        i6++;
                    }
                }
            }
            z = false;
            int i7 = 0;
            while (true) {
                str = "java/io/IOException";
                str2 = ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V";
                str3 = "(L";
                str4 = "out";
                cVarArr = cVarArr2;
                if (i7 >= 3) {
                    break;
                }
                if (i7 == 0) {
                    str7 = "write";
                    z4 = z;
                    z5 = true;
                } else if (i7 == 1) {
                    str7 = "writeNormal";
                    z4 = z;
                    z5 = false;
                } else {
                    str7 = "writeDirectNonContext";
                    z5 = true;
                    z4 = true;
                }
                C1263a aVar = r1;
                ClassWriter cVar7 = cVar6;
                String str10 = sb6;
                String str11 = sb4;
                C1263a aVar2 = new C1263a(cVarArr3, awVar, sb4, z5, z4);
                StringBuilder sb13 = new StringBuilder();
                sb13.append(str3);
                sb13.append(f2818b);
                sb13.append(str2);
                int i8 = i7;
                MethodWriter iVar2 = new MethodWriter(cVar6, 1, str7, sb13.toString(), null, new String[]{str});
                Label fVar = new Label();
                iVar2.mo11038b(25, 2);
                iVar2.mo11033a(199, fVar);
                iVar2.mo11038b(25, 1);
                iVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2818b, "writeNull", "()V");
                iVar2.mo11031a(177);
                iVar2.mo11036a(fVar);
                iVar2.mo11038b(25, 1);
                iVar2.mo11035a(TinkerReport.KEY_APPLIED_VERSION_CHECK, f2818b, str4, f2822f);
                C1263a aVar3 = aVar;
                iVar2.mo11038b(58, aVar3.mo11306a(str4));
                if (z7 || aVar3.f2835g || (jSONType2 != null && !jSONType2.alphabetic())) {
                    str8 = str11;
                } else {
                    Label fVar2 = new Label();
                    iVar2.mo11038b(25, aVar3.mo11306a(str4));
                    iVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, "isSortField", "()Z");
                    iVar2.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND, fVar2);
                    iVar2.mo11038b(25, 0);
                    iVar2.mo11038b(25, 1);
                    iVar2.mo11038b(25, 2);
                    iVar2.mo11038b(25, 3);
                    iVar2.mo11038b(25, 4);
                    iVar2.mo11038b(21, 5);
                    StringBuilder sb14 = new StringBuilder();
                    sb14.append(str3);
                    sb14.append(f2818b);
                    sb14.append(str2);
                    str8 = str11;
                    iVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str8, "writeUnsorted", sb14.toString());
                    iVar2.mo11031a(177);
                    iVar2.mo11036a(fVar2);
                }
                if (!aVar3.f2835g || z4) {
                    jSONType = jSONType2;
                    z6 = z7;
                } else {
                    Label fVar3 = new Label();
                    Label fVar4 = new Label();
                    iVar2.mo11038b(25, 0);
                    iVar2.mo11038b(25, 1);
                    String str12 = f2823g;
                    StringBuilder sb15 = new StringBuilder();
                    sb15.append(str3);
                    jSONType = jSONType2;
                    sb15.append(f2818b);
                    sb15.append(";)Z");
                    z6 = z7;
                    iVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str12, "writeDirect", sb15.toString());
                    iVar2.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND, fVar4);
                    iVar2.mo11038b(25, 0);
                    iVar2.mo11038b(25, 1);
                    iVar2.mo11038b(25, 2);
                    iVar2.mo11038b(25, 3);
                    iVar2.mo11038b(25, 4);
                    iVar2.mo11038b(21, 5);
                    StringBuilder sb16 = new StringBuilder();
                    sb16.append(str3);
                    sb16.append(f2818b);
                    sb16.append(str2);
                    iVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str8, "writeNormal", sb16.toString());
                    iVar2.mo11031a(177);
                    iVar2.mo11036a(fVar4);
                    iVar2.mo11038b(25, aVar3.mo11306a(str4));
                    iVar2.mo11037a((Object) Integer.valueOf(SerializerFeature.DisableCircularReferenceDetect.mask));
                    iVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, "isEnabled", "(I)Z");
                    iVar2.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, fVar3);
                    iVar2.mo11038b(25, 0);
                    iVar2.mo11038b(25, 1);
                    iVar2.mo11038b(25, 2);
                    iVar2.mo11038b(25, 3);
                    iVar2.mo11038b(25, 4);
                    iVar2.mo11038b(21, 5);
                    StringBuilder sb17 = new StringBuilder();
                    sb17.append(str3);
                    sb17.append(f2818b);
                    sb17.append(str2);
                    iVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str8, "writeDirectNonContext", sb17.toString());
                    iVar2.mo11031a(177);
                    iVar2.mo11036a(fVar3);
                }
                iVar2.mo11038b(25, 2);
                iVar2.mo11034a(192, ASMUtils.m3171b(cls));
                iVar2.mo11038b(58, aVar3.mo11306a("entity"));
                m2940b(cls, (MethodVisitor) iVar2, cVarArr3, aVar3);
                iVar2.mo11031a(177);
                iVar2.mo11041d(7, aVar3.f2837i + 2);
                iVar2.mo11030a();
                i7 = i8 + 1;
                SerializeBeanInfo awVar3 = awVar;
                sb4 = str8;
                jSONType2 = jSONType;
                z7 = z6;
                cVarArr2 = cVarArr;
                cVar6 = cVar7;
                sb6 = str10;
            }
            String str13 = sb6;
            String str14 = sb4;
            ClassWriter cVar8 = cVar6;
            int i9 = 3;
            if (!z7) {
                str5 = str14;
                C1263a aVar4 = new C1263a(cVarArr3, awVar, str14, false, z);
                StringBuilder sb18 = new StringBuilder();
                sb18.append(str3);
                sb18.append(f2818b);
                sb18.append(str2);
                i9 = 3;
                MethodWriter iVar3 = new MethodWriter(cVar8, 1, "writeUnsorted", sb18.toString(), null, new String[]{str});
                iVar3.mo11038b(25, 1);
                iVar3.mo11035a(TinkerReport.KEY_APPLIED_VERSION_CHECK, f2818b, str4, f2822f);
                iVar3.mo11038b(58, aVar4.mo11306a(str4));
                iVar3.mo11038b(25, 2);
                iVar3.mo11034a(192, ASMUtils.m3171b(cls));
                iVar3.mo11038b(58, aVar4.mo11306a("entity"));
                m2940b(cls, (MethodVisitor) iVar3, cVarArr, aVar4);
                iVar3.mo11031a(177);
                iVar3.mo11041d(7, aVar4.f2837i + 2);
                iVar3.mo11030a();
            } else {
                str5 = str14;
            }
            int i10 = 0;
            for (i9 = 
/*
Method generation error in method: com.alibaba.fastjson.serializer.a.a(com.alibaba.fastjson.serializer.aw):com.alibaba.fastjson.serializer.ah, dex: classes.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r6v3 'i9' int) = (r6v2 'i9' int), (r6v9 'i9' int) binds: {(r6v2 'i9' int)=B:90:0x0541, (r6v9 'i9' int)=B:89:0x04c4} in method: com.alibaba.fastjson.serializer.a.a(com.alibaba.fastjson.serializer.aw):com.alibaba.fastjson.serializer.ah, dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:238)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:192)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:127)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:193)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:324)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:261)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:224)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.generate(CodeGen.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:36)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:536)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:508)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:232)
	... 25 more

*/

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01a3, code lost:
            if (r14 == java.lang.Object.class) goto L_0x01a5;
     */
    /* renamed from: a */
    private void m2935a(java.lang.Class<?> r26, com.alibaba.fastjson.p065a.MethodVisitor r27, com.alibaba.fastjson.util.FieldInfo[] r28, com.alibaba.fastjson.serializer.ASMSerializerFactory.C1263a r29) throws java.lang.Exception {
        /*
        r25 = this;
        r0 = r25
        r1 = r27
        r2 = r28
        r3 = r29
        java.lang.String r4 = "out"
        int r5 = r3.mo11306a(r4)
        r6 = 25
        r1.mo11038b(r6, r5)
        r5 = 16
        r7 = 91
        r1.mo11038b(r5, r7)
        java.lang.String r7 = f2821e
        java.lang.String r8 = "(I)V"
        java.lang.String r9 = "write"
        r10 = 182(0xb6, float:2.55E-43)
        r1.mo11039b(r10, r7, r9, r8)
        int r7 = r2.length
        if (r7 != 0) goto L_0x003a
        int r2 = r3.mo11306a(r4)
        r1.mo11038b(r6, r2)
        r2 = 93
        r1.mo11038b(r5, r2)
        java.lang.String r2 = f2821e
        r1.mo11039b(r10, r2, r9, r8)
        return
    L_0x003a:
        r11 = 0
    L_0x003b:
        if (r11 >= r7) goto L_0x07f4
        int r12 = r7 + -1
        if (r11 != r12) goto L_0x0044
        r12 = 93
        goto L_0x0046
    L_0x0044:
        r12 = 44
    L_0x0046:
        r13 = r2[r11]
        java.lang.Class<?> r14 = r13.f2995d
        java.lang.String r15 = r13.f2992a
        r1.mo11037a(r15)
        int r15 = com.alibaba.fastjson.serializer.ASMSerializerFactory.C1263a.f2829a
        r5 = 58
        r1.mo11038b(r5, r15)
        java.lang.Class r15 = java.lang.Byte.TYPE
        r5 = 89
        if (r14 == r15) goto L_0x07b7
        java.lang.Class r15 = java.lang.Short.TYPE
        if (r14 == r15) goto L_0x07b7
        java.lang.Class r15 = java.lang.Integer.TYPE
        if (r14 != r15) goto L_0x0066
        goto L_0x07b7
    L_0x0066:
        java.lang.Class r15 = java.lang.Long.TYPE
        if (r14 != r15) goto L_0x0099
        int r14 = r3.mo11306a(r4)
        r1.mo11038b(r6, r14)
        r1.mo11031a(r5)
        r0.m2928a(r1, r3, r13)
        java.lang.String r5 = f2821e
        java.lang.String r13 = "writeLong"
        java.lang.String r14 = "(J)V"
        r1.mo11039b(r10, r5, r13, r14)
        r5 = 16
        r1.mo11038b(r5, r12)
        java.lang.String r5 = f2821e
        r1.mo11039b(r10, r5, r9, r8)
    L_0x008a:
        r2 = r0
        r0 = r4
        r18 = r7
        r5 = r8
        r19 = r11
        r4 = 25
        r6 = 16
        r8 = 182(0xb6, float:2.55E-43)
        goto L_0x07e3
    L_0x0099:
        java.lang.Class r15 = java.lang.Float.TYPE
        if (r14 != r15) goto L_0x00c2
        int r14 = r3.mo11306a(r4)
        r1.mo11038b(r6, r14)
        r1.mo11031a(r5)
        r0.m2928a(r1, r3, r13)
        r5 = 4
        r1.mo11031a(r5)
        java.lang.String r5 = f2821e
        java.lang.String r13 = "writeFloat"
        java.lang.String r14 = "(FZ)V"
        r1.mo11039b(r10, r5, r13, r14)
        r5 = 16
        r1.mo11038b(r5, r12)
        java.lang.String r5 = f2821e
        r1.mo11039b(r10, r5, r9, r8)
        goto L_0x008a
    L_0x00c2:
        java.lang.Class r15 = java.lang.Double.TYPE
        if (r14 != r15) goto L_0x00eb
        int r14 = r3.mo11306a(r4)
        r1.mo11038b(r6, r14)
        r1.mo11031a(r5)
        r0.m2928a(r1, r3, r13)
        r5 = 4
        r1.mo11031a(r5)
        java.lang.String r5 = f2821e
        java.lang.String r13 = "writeDouble"
        java.lang.String r14 = "(DZ)V"
        r1.mo11039b(r10, r5, r13, r14)
        r5 = 16
        r1.mo11038b(r5, r12)
        java.lang.String r5 = f2821e
        r1.mo11039b(r10, r5, r9, r8)
        goto L_0x008a
    L_0x00eb:
        java.lang.Class r15 = java.lang.Boolean.TYPE
        if (r14 != r15) goto L_0x010f
        int r14 = r3.mo11306a(r4)
        r1.mo11038b(r6, r14)
        r1.mo11031a(r5)
        r0.m2928a(r1, r3, r13)
        java.lang.String r5 = f2821e
        java.lang.String r13 = "(Z)V"
        r1.mo11039b(r10, r5, r9, r13)
        r5 = 16
        r1.mo11038b(r5, r12)
        java.lang.String r5 = f2821e
        r1.mo11039b(r10, r5, r9, r8)
        goto L_0x008a
    L_0x010f:
        java.lang.Class r15 = java.lang.Character.TYPE
        if (r14 != r15) goto L_0x0138
        int r5 = r3.mo11306a(r4)
        r1.mo11038b(r6, r5)
        r0.m2928a(r1, r3, r13)
        r5 = 184(0xb8, float:2.58E-43)
        java.lang.String r13 = "java/lang/Character"
        java.lang.String r14 = "toString"
        java.lang.String r15 = "(C)Ljava/lang/String;"
        r1.mo11039b(r5, r13, r14, r15)
        r15 = 16
        r1.mo11038b(r15, r12)
        java.lang.String r5 = f2821e
        java.lang.String r12 = "writeString"
        java.lang.String r13 = "(Ljava/lang/String;C)V"
        r1.mo11039b(r10, r5, r12, r13)
        goto L_0x008a
    L_0x0138:
        r15 = 16
        java.lang.Class<java.lang.String> r5 = java.lang.String.class
        if (r14 != r5) goto L_0x0156
        int r5 = r3.mo11306a(r4)
        r1.mo11038b(r6, r5)
        r0.m2928a(r1, r3, r13)
        r1.mo11038b(r15, r12)
        java.lang.String r5 = f2821e
        java.lang.String r12 = "writeString"
        java.lang.String r13 = "(Ljava/lang/String;C)V"
        r1.mo11039b(r10, r5, r12, r13)
        goto L_0x008a
    L_0x0156:
        boolean r5 = r14.isEnum()
        if (r5 == 0) goto L_0x0180
        int r5 = r3.mo11306a(r4)
        r1.mo11038b(r6, r5)
        r5 = 89
        r1.mo11031a(r5)
        r0.m2928a(r1, r3, r13)
        java.lang.String r5 = f2821e
        java.lang.String r13 = "writeEnum"
        java.lang.String r14 = "(Ljava/lang/Enum;)V"
        r1.mo11039b(r10, r5, r13, r14)
        r5 = 16
        r1.mo11038b(r5, r12)
        java.lang.String r5 = f2821e
        r1.mo11039b(r10, r5, r9, r8)
        goto L_0x008a
    L_0x0180:
        java.lang.Class<java.util.List> r5 = java.util.List.class
        boolean r5 = r5.isAssignableFrom(r14)
        if (r5 == 0) goto L_0x053d
        java.lang.reflect.Type r5 = r13.f2996e
        boolean r14 = r5 instanceof java.lang.Class
        if (r14 == 0) goto L_0x0191
        java.lang.Class<java.lang.Object> r5 = java.lang.Object.class
        goto L_0x019a
    L_0x0191:
        java.lang.reflect.ParameterizedType r5 = (java.lang.reflect.ParameterizedType) r5
        java.lang.reflect.Type[] r5 = r5.getActualTypeArguments()
        r14 = 0
        r5 = r5[r14]
    L_0x019a:
        boolean r14 = r5 instanceof java.lang.Class
        if (r14 == 0) goto L_0x01a5
        r14 = r5
        java.lang.Class r14 = (java.lang.Class) r14
        java.lang.Class<java.lang.Object> r15 = java.lang.Object.class
        if (r14 != r15) goto L_0x01a6
    L_0x01a5:
        r14 = 0
    L_0x01a6:
        r0.m2928a(r1, r3, r13)
        r15 = 192(0xc0, float:2.69E-43)
        java.lang.String r10 = "java/util/List"
        r1.mo11034a(r15, r10)
        java.lang.String r10 = "list"
        int r15 = r3.mo11306a(r10)
        r6 = 58
        r1.mo11038b(r6, r15)
        java.lang.Class<java.lang.String> r6 = java.lang.String.class
        if (r14 != r6) goto L_0x01ee
        boolean r6 = r29.f2835g
        if (r6 == 0) goto L_0x01ee
        int r5 = r3.mo11306a(r4)
        r6 = 25
        r1.mo11038b(r6, r5)
        int r5 = r3.mo11306a(r10)
        r1.mo11038b(r6, r5)
        java.lang.String r5 = f2821e
        java.lang.String r6 = "(Ljava/util/List;)V"
        r10 = 182(0xb6, float:2.55E-43)
        r1.mo11039b(r10, r5, r9, r6)
        r0 = r4
        r18 = r7
        r6 = r8
        r19 = r11
        r20 = r12
        r4 = 25
        r5 = 16
        r7 = 182(0xb6, float:2.55E-43)
        goto L_0x0521
    L_0x01ee:
        com.alibaba.fastjson.a.f r6 = new com.alibaba.fastjson.a.f
        r6.m41548init()
        com.alibaba.fastjson.a.f r15 = new com.alibaba.fastjson.a.f
        r15.m41548init()
        int r2 = r3.mo11306a(r10)
        r18 = r7
        r7 = 25
        r1.mo11038b(r7, r2)
        r2 = 199(0xc7, float:2.79E-43)
        r1.mo11033a(r2, r15)
        int r2 = r3.mo11306a(r4)
        r1.mo11038b(r7, r2)
        java.lang.String r2 = f2821e
        java.lang.String r7 = "writeNull"
        r19 = r11
        java.lang.String r11 = "()V"
        r20 = r12
        r12 = 182(0xb6, float:2.55E-43)
        r1.mo11039b(r12, r2, r7, r11)
        r2 = 167(0xa7, float:2.34E-43)
        r1.mo11033a(r2, r6)
        r1.mo11036a(r15)
        int r2 = r3.mo11306a(r10)
        r7 = 25
        r1.mo11038b(r7, r2)
        r2 = 185(0xb9, float:2.59E-43)
        java.lang.String r11 = "java/util/List"
        java.lang.String r12 = "size"
        java.lang.String r15 = "()I"
        r1.mo11039b(r2, r11, r12, r15)
        r2 = 54
        java.lang.String r11 = "size"
        int r11 = r3.mo11306a(r11)
        r1.mo11038b(r2, r11)
        int r2 = r3.mo11306a(r4)
        r1.mo11038b(r7, r2)
        r2 = 91
        r7 = 16
        r1.mo11038b(r7, r2)
        java.lang.String r2 = f2821e
        r7 = 182(0xb6, float:2.55E-43)
        r1.mo11039b(r7, r2, r9, r8)
        com.alibaba.fastjson.a.f r2 = new com.alibaba.fastjson.a.f
        r2.m41548init()
        com.alibaba.fastjson.a.f r7 = new com.alibaba.fastjson.a.f
        r7.m41548init()
        com.alibaba.fastjson.a.f r11 = new com.alibaba.fastjson.a.f
        r11.m41548init()
        r12 = 3
        r1.mo11031a(r12)
        r12 = 54
        java.lang.String r15 = "i"
        r17 = r6
        int r6 = r3.mo11306a(r15)
        r1.mo11038b(r12, r6)
        r1.mo11036a(r2)
        int r6 = r3.mo11306a(r15)
        r12 = 21
        r1.mo11038b(r12, r6)
        java.lang.String r6 = "size"
        int r6 = r3.mo11306a(r6)
        r1.mo11038b(r12, r6)
        r6 = 162(0xa2, float:2.27E-43)
        r1.mo11033a(r6, r11)
        int r6 = r3.mo11306a(r15)
        r1.mo11038b(r12, r6)
        r6 = 153(0x99, float:2.14E-43)
        r1.mo11033a(r6, r7)
        int r6 = r3.mo11306a(r4)
        r12 = 25
        r1.mo11038b(r12, r6)
        r6 = 44
        r12 = 16
        r1.mo11038b(r12, r6)
        java.lang.String r6 = f2821e
        r12 = 182(0xb6, float:2.55E-43)
        r1.mo11039b(r12, r6, r9, r8)
        r1.mo11036a(r7)
        int r6 = r3.mo11306a(r10)
        r7 = 25
        r1.mo11038b(r7, r6)
        int r6 = r3.mo11306a(r15)
        r7 = 21
        r1.mo11038b(r7, r6)
        r6 = 185(0xb9, float:2.59E-43)
        java.lang.String r7 = "java/util/List"
        java.lang.String r10 = "get"
        java.lang.String r12 = "(I)Ljava/lang/Object;"
        r1.mo11039b(r6, r7, r10, r12)
        java.lang.String r6 = "list_item"
        int r7 = r3.mo11306a(r6)
        r10 = 58
        r1.mo11038b(r10, r7)
        com.alibaba.fastjson.a.f r7 = new com.alibaba.fastjson.a.f
        r7.m41548init()
        com.alibaba.fastjson.a.f r10 = new com.alibaba.fastjson.a.f
        r10.m41548init()
        int r12 = r3.mo11306a(r6)
        r21 = r8
        r8 = 25
        r1.mo11038b(r8, r12)
        r12 = 199(0xc7, float:2.79E-43)
        r1.mo11033a(r12, r10)
        int r12 = r3.mo11306a(r4)
        r1.mo11038b(r8, r12)
        java.lang.String r8 = f2821e
        java.lang.String r12 = "writeNull"
        r22 = r4
        java.lang.String r4 = "()V"
        r23 = r11
        r11 = 182(0xb6, float:2.55E-43)
        r1.mo11039b(r11, r8, r12, r4)
        r4 = 167(0xa7, float:2.34E-43)
        r1.mo11033a(r4, r7)
        r1.mo11036a(r10)
        com.alibaba.fastjson.a.f r4 = new com.alibaba.fastjson.a.f
        r4.m41548init()
        com.alibaba.fastjson.a.f r8 = new com.alibaba.fastjson.a.f
        r8.m41548init()
        if (r14 == 0) goto L_0x047a
        int r10 = r14.getModifiers()
        boolean r10 = java.lang.reflect.Modifier.isPublic(r10)
        if (r10 == 0) goto L_0x047a
        int r10 = r3.mo11306a(r6)
        r11 = 25
        r1.mo11038b(r11, r10)
        java.lang.String r10 = "java/lang/Object"
        java.lang.String r11 = "getClass"
        java.lang.String r12 = "()Ljava/lang/Class;"
        r24 = r2
        r2 = 182(0xb6, float:2.55E-43)
        r1.mo11039b(r2, r10, r11, r12)
        java.lang.String r2 = com.alibaba.fastjson.util.ASMUtils.m3167a(r14)
        com.alibaba.fastjson.a.j r2 = com.alibaba.fastjson.p065a.Type.m2508a(r2)
        r1.mo11037a(r2)
        r2 = 166(0xa6, float:2.33E-43)
        r1.mo11033a(r2, r8)
        r0.m2932a(r3, r1, r13, r14)
        java.lang.String r2 = "list_item_desc"
        int r2 = r3.mo11306a(r2)
        r10 = 58
        r1.mo11038b(r10, r2)
        com.alibaba.fastjson.a.f r2 = new com.alibaba.fastjson.a.f
        r2.m41548init()
        com.alibaba.fastjson.a.f r10 = new com.alibaba.fastjson.a.f
        r10.m41548init()
        boolean r11 = r29.f2835g
        if (r11 == 0) goto L_0x0408
        java.lang.String r11 = "list_item_desc"
        int r11 = r3.mo11306a(r11)
        r12 = 25
        r1.mo11038b(r12, r11)
        r11 = 193(0xc1, float:2.7E-43)
        java.lang.String r12 = f2823g
        r1.mo11034a(r11, r12)
        r11 = 153(0x99, float:2.14E-43)
        r1.mo11033a(r11, r2)
        java.lang.String r11 = "list_item_desc"
        int r11 = r3.mo11306a(r11)
        r12 = 25
        r1.mo11038b(r12, r11)
        r11 = 192(0xc0, float:2.69E-43)
        java.lang.String r0 = f2823g
        r1.mo11034a(r11, r0)
        r0 = 1
        r1.mo11038b(r12, r0)
        int r11 = r3.mo11306a(r6)
        r1.mo11038b(r12, r11)
        boolean r11 = r29.f2838j
        if (r11 == 0) goto L_0x03b4
        r1.mo11031a(r0)
        r16 = r7
        goto L_0x03ca
    L_0x03b4:
        int r0 = r3.mo11306a(r15)
        r11 = 21
        r1.mo11038b(r11, r0)
        r0 = 184(0xb8, float:2.58E-43)
        java.lang.String r11 = "java/lang/Integer"
        java.lang.String r12 = "valueOf"
        r16 = r7
        java.lang.String r7 = "(I)Ljava/lang/Integer;"
        r1.mo11039b(r0, r11, r12, r7)
    L_0x03ca:
        java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.m3167a(r14)
        com.alibaba.fastjson.a.j r0 = com.alibaba.fastjson.p065a.Type.m2508a(r0)
        r1.mo11037a(r0)
        int r0 = r13.f2999h
        java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        r1.mo11037a(r0)
        java.lang.String r0 = f2823g
        java.lang.StringBuilder r7 = new java.lang.StringBuilder
        r7.<init>()
        java.lang.String r11 = "(L"
        r7.append(r11)
        java.lang.String r11 = f2818b
        r7.append(r11)
        java.lang.String r11 = ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"
        r7.append(r11)
        java.lang.String r7 = r7.toString()
        java.lang.String r11 = "writeAsArrayNonContext"
        r12 = 182(0xb6, float:2.55E-43)
        r1.mo11039b(r12, r0, r11, r7)
        r0 = 167(0xa7, float:2.34E-43)
        r1.mo11033a(r0, r10)
        r1.mo11036a(r2)
        goto L_0x040a
    L_0x0408:
        r16 = r7
    L_0x040a:
        java.lang.String r0 = "list_item_desc"
        int r0 = r3.mo11306a(r0)
        r2 = 25
        r1.mo11038b(r2, r0)
        r0 = 1
        r1.mo11038b(r2, r0)
        int r7 = r3.mo11306a(r6)
        r1.mo11038b(r2, r7)
        boolean r2 = r29.f2838j
        if (r2 == 0) goto L_0x042a
        r1.mo11031a(r0)
        goto L_0x043e
    L_0x042a:
        int r0 = r3.mo11306a(r15)
        r2 = 21
        r1.mo11038b(r2, r0)
        r0 = 184(0xb8, float:2.58E-43)
        java.lang.String r2 = "java/lang/Integer"
        java.lang.String r7 = "valueOf"
        java.lang.String r11 = "(I)Ljava/lang/Integer;"
        r1.mo11039b(r0, r2, r7, r11)
    L_0x043e:
        java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.m3167a(r14)
        com.alibaba.fastjson.a.j r0 = com.alibaba.fastjson.p065a.Type.m2508a(r0)
        r1.mo11037a(r0)
        int r0 = r13.f2999h
        java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        r1.mo11037a(r0)
        r0 = 185(0xb9, float:2.59E-43)
        java.lang.String r2 = f2819c
        java.lang.StringBuilder r7 = new java.lang.StringBuilder
        r7.<init>()
        java.lang.String r11 = "(L"
        r7.append(r11)
        java.lang.String r11 = f2818b
        r7.append(r11)
        java.lang.String r11 = ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"
        r7.append(r11)
        java.lang.String r7 = r7.toString()
        r1.mo11039b(r0, r2, r9, r7)
        r1.mo11036a(r10)
        r0 = 167(0xa7, float:2.34E-43)
        r1.mo11033a(r0, r4)
        goto L_0x047e
    L_0x047a:
        r24 = r2
        r16 = r7
    L_0x047e:
        r1.mo11036a(r8)
        r0 = 1
        r2 = 25
        r1.mo11038b(r2, r0)
        int r6 = r3.mo11306a(r6)
        r1.mo11038b(r2, r6)
        boolean r2 = r29.f2838j
        if (r2 == 0) goto L_0x0498
        r1.mo11031a(r0)
        goto L_0x04ac
    L_0x0498:
        int r0 = r3.mo11306a(r15)
        r2 = 21
        r1.mo11038b(r2, r0)
        r0 = 184(0xb8, float:2.58E-43)
        java.lang.String r2 = "java/lang/Integer"
        java.lang.String r6 = "valueOf"
        java.lang.String r7 = "(I)Ljava/lang/Integer;"
        r1.mo11039b(r0, r2, r6, r7)
    L_0x04ac:
        if (r14 == 0) goto L_0x04da
        int r0 = r14.getModifiers()
        boolean r0 = java.lang.reflect.Modifier.isPublic(r0)
        if (r0 == 0) goto L_0x04da
        java.lang.Class r5 = (java.lang.Class) r5
        java.lang.String r0 = com.alibaba.fastjson.util.ASMUtils.m3167a(r5)
        com.alibaba.fastjson.a.j r0 = com.alibaba.fastjson.p065a.Type.m2508a(r0)
        r1.mo11037a(r0)
        int r0 = r13.f2999h
        java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        r1.mo11037a(r0)
        java.lang.String r0 = f2818b
        java.lang.String r2 = "writeWithFieldName"
        java.lang.String r5 = "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"
        r6 = 182(0xb6, float:2.55E-43)
        r1.mo11039b(r6, r0, r2, r5)
        goto L_0x04e5
    L_0x04da:
        r6 = 182(0xb6, float:2.55E-43)
        java.lang.String r0 = f2818b
        java.lang.String r2 = "writeWithFieldName"
        java.lang.String r5 = "(Ljava/lang/Object;Ljava/lang/Object;)V"
        r1.mo11039b(r6, r0, r2, r5)
    L_0x04e5:
        r1.mo11036a(r4)
        r0 = r16
        r1.mo11036a(r0)
        int r0 = r3.mo11306a(r15)
        r2 = 1
        r1.mo11040c(r0, r2)
        r0 = r24
        r2 = 167(0xa7, float:2.34E-43)
        r1.mo11033a(r2, r0)
        r0 = r23
        r1.mo11036a(r0)
        r0 = r22
        int r2 = r3.mo11306a(r0)
        r4 = 25
        r1.mo11038b(r4, r2)
        r2 = 93
        r5 = 16
        r1.mo11038b(r5, r2)
        java.lang.String r2 = f2821e
        r6 = r21
        r7 = 182(0xb6, float:2.55E-43)
        r1.mo11039b(r7, r2, r9, r6)
        r2 = r17
        r1.mo11036a(r2)
    L_0x0521:
        int r2 = r3.mo11306a(r0)
        r1.mo11038b(r4, r2)
        r12 = r20
        r1.mo11038b(r5, r12)
        java.lang.String r2 = f2821e
        r1.mo11039b(r7, r2, r9, r6)
        r4 = 25
        r8 = 182(0xb6, float:2.55E-43)
        r2 = r25
        r5 = r6
        r6 = 16
        goto L_0x07e3
    L_0x053d:
        r0 = r4
        r18 = r7
        r6 = r8
        r19 = r11
        com.alibaba.fastjson.a.f r2 = new com.alibaba.fastjson.a.f
        r2.m41548init()
        com.alibaba.fastjson.a.f r4 = new com.alibaba.fastjson.a.f
        r4.m41548init()
        r5 = r25
        r5.m2928a(r1, r3, r13)
        r7 = 89
        r1.mo11031a(r7)
        java.lang.StringBuilder r7 = new java.lang.StringBuilder
        r7.<init>()
        java.lang.String r8 = "field_"
        r7.append(r8)
        java.lang.Class<?> r10 = r13.f2995d
        java.lang.String r10 = r10.getName()
        r7.append(r10)
        java.lang.String r7 = r7.toString()
        int r7 = r3.mo11306a(r7)
        r10 = 58
        r1.mo11038b(r10, r7)
        r7 = 199(0xc7, float:2.79E-43)
        r1.mo11033a(r7, r4)
        int r7 = r3.mo11306a(r0)
        r10 = 25
        r1.mo11038b(r10, r7)
        java.lang.String r7 = f2821e
        java.lang.String r10 = "writeNull"
        java.lang.String r11 = "()V"
        r15 = 182(0xb6, float:2.55E-43)
        r1.mo11039b(r15, r7, r10, r11)
        r7 = 167(0xa7, float:2.34E-43)
        r1.mo11033a(r7, r2)
        r1.mo11036a(r4)
        com.alibaba.fastjson.a.f r4 = new com.alibaba.fastjson.a.f
        r4.m41548init()
        com.alibaba.fastjson.a.f r7 = new com.alibaba.fastjson.a.f
        r7.m41548init()
        java.lang.StringBuilder r10 = new java.lang.StringBuilder
        r10.<init>()
        r10.append(r8)
        java.lang.Class<?> r11 = r13.f2995d
        java.lang.String r11 = r11.getName()
        r10.append(r11)
        java.lang.String r10 = r10.toString()
        int r10 = r3.mo11306a(r10)
        r11 = 25
        r1.mo11038b(r11, r10)
        java.lang.String r10 = "java/lang/Object"
        java.lang.String r11 = "getClass"
        java.lang.String r15 = "()Ljava/lang/Class;"
        r21 = r6
        r6 = 182(0xb6, float:2.55E-43)
        r1.mo11039b(r6, r10, r11, r15)
        java.lang.String r6 = com.alibaba.fastjson.util.ASMUtils.m3167a(r14)
        com.alibaba.fastjson.a.j r6 = com.alibaba.fastjson.p065a.Type.m2508a(r6)
        r1.mo11037a(r6)
        r6 = 166(0xa6, float:2.33E-43)
        r1.mo11033a(r6, r7)
        r5.m2931a(r3, r1, r13)
        java.lang.String r6 = "fied_ser"
        int r6 = r3.mo11306a(r6)
        r10 = 58
        r1.mo11038b(r10, r6)
        com.alibaba.fastjson.a.f r6 = new com.alibaba.fastjson.a.f
        r6.m41548init()
        com.alibaba.fastjson.a.f r10 = new com.alibaba.fastjson.a.f
        r10.m41548init()
        boolean r11 = r29.f2835g
        if (r11 == 0) goto L_0x0693
        int r11 = r14.getModifiers()
        boolean r11 = java.lang.reflect.Modifier.isPublic(r11)
        if (r11 == 0) goto L_0x0693
        java.lang.String r11 = "fied_ser"
        int r11 = r3.mo11306a(r11)
        r15 = 25
        r1.mo11038b(r15, r11)
        r11 = 193(0xc1, float:2.7E-43)
        java.lang.String r15 = f2823g
        r1.mo11034a(r11, r15)
        r11 = 153(0x99, float:2.14E-43)
        r1.mo11033a(r11, r6)
        java.lang.String r11 = "fied_ser"
        int r11 = r3.mo11306a(r11)
        r15 = 25
        r1.mo11038b(r15, r11)
        r11 = 192(0xc0, float:2.69E-43)
        java.lang.String r5 = f2823g
        r1.mo11034a(r11, r5)
        r5 = 1
        r1.mo11038b(r15, r5)
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>()
        r5.append(r8)
        java.lang.Class<?> r11 = r13.f2995d
        java.lang.String r11 = r11.getName()
        r5.append(r11)
        java.lang.String r5 = r5.toString()
        int r5 = r3.mo11306a(r5)
        r1.mo11038b(r15, r5)
        int r5 = com.alibaba.fastjson.serializer.ASMSerializerFactory.C1263a.f2829a
        r1.mo11038b(r15, r5)
        java.lang.String r5 = com.alibaba.fastjson.util.ASMUtils.m3167a(r14)
        com.alibaba.fastjson.a.j r5 = com.alibaba.fastjson.p065a.Type.m2508a(r5)
        r1.mo11037a(r5)
        int r5 = r13.f2999h
        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
        r1.mo11037a(r5)
        java.lang.String r5 = f2823g
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r15 = "(L"
        r11.append(r15)
        java.lang.String r15 = f2818b
        r11.append(r15)
        java.lang.String r15 = ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"
        r11.append(r15)
        java.lang.String r11 = r11.toString()
        java.lang.String r15 = "writeAsArrayNonContext"
        r20 = r12
        r12 = 182(0xb6, float:2.55E-43)
        r1.mo11039b(r12, r5, r15, r11)
        r5 = 167(0xa7, float:2.34E-43)
        r1.mo11033a(r5, r10)
        r1.mo11036a(r6)
        goto L_0x0695
    L_0x0693:
        r20 = r12
    L_0x0695:
        java.lang.String r5 = "fied_ser"
        int r5 = r3.mo11306a(r5)
        r6 = 25
        r1.mo11038b(r6, r5)
        r5 = 1
        r1.mo11038b(r6, r5)
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>()
        r5.append(r8)
        java.lang.Class<?> r11 = r13.f2995d
        java.lang.String r11 = r11.getName()
        r5.append(r11)
        java.lang.String r5 = r5.toString()
        int r5 = r3.mo11306a(r5)
        r1.mo11038b(r6, r5)
        int r5 = com.alibaba.fastjson.serializer.ASMSerializerFactory.C1263a.f2829a
        r1.mo11038b(r6, r5)
        java.lang.String r5 = com.alibaba.fastjson.util.ASMUtils.m3167a(r14)
        com.alibaba.fastjson.a.j r5 = com.alibaba.fastjson.p065a.Type.m2508a(r5)
        r1.mo11037a(r5)
        int r5 = r13.f2999h
        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
        r1.mo11037a(r5)
        r5 = 185(0xb9, float:2.59E-43)
        java.lang.String r6 = f2819c
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r12 = "(L"
        r11.append(r12)
        java.lang.String r12 = f2818b
        r11.append(r12)
        java.lang.String r12 = ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"
        r11.append(r12)
        java.lang.String r11 = r11.toString()
        r1.mo11039b(r5, r6, r9, r11)
        r1.mo11036a(r10)
        r5 = 167(0xa7, float:2.34E-43)
        r1.mo11033a(r5, r4)
        r1.mo11036a(r7)
        java.lang.String r5 = r13.mo11507e()
        r6 = 1
        r7 = 25
        r1.mo11038b(r7, r6)
        java.lang.StringBuilder r6 = new java.lang.StringBuilder
        r6.<init>()
        r6.append(r8)
        java.lang.Class<?> r8 = r13.f2995d
        java.lang.String r8 = r8.getName()
        r6.append(r8)
        java.lang.String r6 = r6.toString()
        int r6 = r3.mo11306a(r6)
        r1.mo11038b(r7, r6)
        if (r5 == 0) goto L_0x073c
        r1.mo11037a(r5)
        java.lang.String r5 = f2818b
        java.lang.String r6 = "writeWithFormat"
        java.lang.String r8 = "(Ljava/lang/Object;Ljava/lang/String;)V"
        r10 = 182(0xb6, float:2.55E-43)
        r1.mo11039b(r10, r5, r6, r8)
        r8 = 182(0xb6, float:2.55E-43)
        goto L_0x0795
    L_0x073c:
        int r5 = com.alibaba.fastjson.serializer.ASMSerializerFactory.C1263a.f2829a
        r1.mo11038b(r7, r5)
        java.lang.reflect.Type r5 = r13.f2996e
        boolean r5 = r5 instanceof java.lang.Class
        if (r5 == 0) goto L_0x075d
        java.lang.reflect.Type r5 = r13.f2996e
        java.lang.Class r5 = (java.lang.Class) r5
        boolean r5 = r5.isPrimitive()
        if (r5 == 0) goto L_0x075d
        java.lang.String r5 = f2818b
        java.lang.String r6 = "writeWithFieldName"
        java.lang.String r7 = "(Ljava/lang/Object;Ljava/lang/Object;)V"
        r8 = 182(0xb6, float:2.55E-43)
        r1.mo11039b(r8, r5, r6, r7)
        goto L_0x0795
    L_0x075d:
        r5 = 0
        r6 = 25
        r1.mo11038b(r6, r5)
        r5 = 180(0xb4, float:2.52E-43)
        java.lang.String r6 = r29.f2833e
        java.lang.StringBuilder r7 = new java.lang.StringBuilder
        r7.<init>()
        java.lang.String r8 = r13.f2992a
        r7.append(r8)
        java.lang.String r8 = "_asm_fieldType"
        r7.append(r8)
        java.lang.String r7 = r7.toString()
        java.lang.String r8 = "Ljava/lang/reflect/Type;"
        r1.mo11035a(r5, r6, r7, r8)
        int r5 = r13.f2999h
        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
        r1.mo11037a(r5)
        java.lang.String r5 = f2818b
        java.lang.String r6 = "writeWithFieldName"
        java.lang.String r7 = "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"
        r8 = 182(0xb6, float:2.55E-43)
        r1.mo11039b(r8, r5, r6, r7)
    L_0x0795:
        r1.mo11036a(r4)
        r1.mo11036a(r2)
        int r2 = r3.mo11306a(r0)
        r4 = 25
        r1.mo11038b(r4, r2)
        r12 = r20
        r2 = 16
        r1.mo11038b(r2, r12)
        java.lang.String r2 = f2821e
        r5 = r21
        r1.mo11039b(r8, r2, r9, r5)
        r6 = 16
        r2 = r25
        goto L_0x07e3
    L_0x07b7:
        r0 = r4
        r18 = r7
        r5 = r8
        r19 = r11
        r4 = 25
        r8 = 182(0xb6, float:2.55E-43)
        int r2 = r3.mo11306a(r0)
        r1.mo11038b(r4, r2)
        r2 = 89
        r1.mo11031a(r2)
        r2 = r25
        r2.m2928a(r1, r3, r13)
        java.lang.String r6 = f2821e
        java.lang.String r7 = "writeInt"
        r1.mo11039b(r8, r6, r7, r5)
        r6 = 16
        r1.mo11038b(r6, r12)
        java.lang.String r7 = f2821e
        r1.mo11039b(r8, r7, r9, r5)
    L_0x07e3:
        int r11 = r19 + 1
        r4 = r0
        r0 = r2
        r8 = r5
        r7 = r18
        r5 = 16
        r6 = 25
        r10 = 182(0xb6, float:2.55E-43)
        r2 = r28
        goto L_0x003b
    L_0x07f4:
        r2 = r0
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.ASMSerializerFactory.m2935a(java.lang.Class, com.alibaba.fastjson.a.h, com.alibaba.fastjson.util.c[], com.alibaba.fastjson.serializer.a$a):void");
    }

    /* renamed from: b */
    private void m2940b(Class<?> cls, MethodVisitor hVar, FieldInfo[] cVarArr, C1263a aVar) throws Exception {
        int i;
        Class<?> cls2 = cls;
        MethodVisitor hVar2 = hVar;
        FieldInfo[] cVarArr2 = cVarArr;
        C1263a aVar2 = aVar;
        Label fVar = new Label();
        int length = cVarArr2.length;
        String str = "(L";
        String str2 = "out";
        if (!aVar.f2835g) {
            Label fVar2 = new Label();
            Label fVar3 = new Label();
            hVar2.mo11038b(25, aVar2.mo11306a(str2));
            hVar2.mo11037a((Object) Integer.valueOf(SerializerFeature.PrettyFormat.mask));
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, "isEnabled", "(I)Z");
            hVar2.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND, fVar3);
            boolean z = false;
            for (FieldInfo cVar : cVarArr2) {
                if (cVar.f2993b != null) {
                    z = true;
                }
            }
            if (z) {
                hVar2.mo11038b(25, aVar2.mo11306a(str2));
                hVar2.mo11037a((Object) Integer.valueOf(SerializerFeature.IgnoreErrorGetter.mask));
                hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, "isEnabled", "(I)Z");
                hVar2.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, fVar2);
            } else {
                hVar2.mo11033a(167, fVar2);
            }
            hVar2.mo11036a(fVar3);
            hVar2.mo11038b(25, 0);
            hVar2.mo11038b(25, 1);
            hVar2.mo11038b(25, 2);
            hVar2.mo11038b(25, 3);
            hVar2.mo11038b(25, 4);
            hVar2.mo11038b(21, 5);
            String str3 = f2823g;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(f2818b);
            sb.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_LIB_EXTRACT, str3, "write", sb.toString());
            hVar2.mo11031a(177);
            hVar2.mo11036a(fVar2);
        }
        if (!aVar.f2838j) {
            Label fVar4 = new Label();
            hVar2.mo11038b(25, 0);
            hVar2.mo11038b(25, 1);
            hVar2.mo11038b(25, 2);
            hVar2.mo11038b(21, 5);
            String str4 = f2823g;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(f2818b);
            sb2.append(";Ljava/lang/Object;I)Z");
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str4, "writeReference", sb2.toString());
            hVar2.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, fVar4);
            hVar2.mo11031a(177);
            hVar2.mo11036a(fVar4);
        }
        String str5 = aVar.f2835g ? aVar.f2838j ? "writeAsArrayNonContext" : "writeAsArray" : "writeAsArrayNormal";
        if ((aVar.f2834f.f2881g & SerializerFeature.BeanToArray.mask) == 0) {
            Label fVar5 = new Label();
            hVar2.mo11038b(25, aVar2.mo11306a(str2));
            hVar2.mo11037a((Object) Integer.valueOf(SerializerFeature.BeanToArray.mask));
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, "isEnabled", "(I)Z");
            hVar2.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, fVar5);
            hVar2.mo11038b(25, 0);
            hVar2.mo11038b(25, 1);
            hVar2.mo11038b(25, 2);
            hVar2.mo11038b(25, 3);
            hVar2.mo11038b(25, 4);
            hVar2.mo11038b(21, 5);
            String d = aVar.f2833e;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(f2818b);
            sb3.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, d, str5, sb3.toString());
            hVar2.mo11031a(177);
            hVar2.mo11036a(fVar5);
        } else {
            hVar2.mo11038b(25, 0);
            hVar2.mo11038b(25, 1);
            hVar2.mo11038b(25, 2);
            hVar2.mo11038b(25, 3);
            hVar2.mo11038b(25, 4);
            hVar2.mo11038b(21, 5);
            String d2 = aVar.f2833e;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append(f2818b);
            sb4.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, d2, str5, sb4.toString());
            hVar2.mo11031a(177);
        }
        if (!aVar.f2838j) {
            hVar2.mo11038b(25, 1);
            String str6 = f2818b;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("()");
            sb5.append(f2825i);
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str6, "getContext", sb5.toString());
            hVar2.mo11038b(58, aVar2.mo11306a("parent"));
            hVar2.mo11038b(25, 1);
            hVar2.mo11038b(25, aVar2.mo11306a("parent"));
            hVar2.mo11038b(25, 2);
            hVar2.mo11038b(25, 3);
            hVar2.mo11037a((Object) Integer.valueOf(aVar.f2834f.f2881g));
            String str7 = f2818b;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("(");
            sb6.append(f2825i);
            sb6.append("Ljava/lang/Object;Ljava/lang/Object;I)V");
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str7, "setContext", sb6.toString());
        }
        boolean z2 = (aVar.f2834f.f2881g & SerializerFeature.WriteClassName.mask) != 0;
        if (z2 || !aVar.f2835g) {
            Label fVar6 = new Label();
            Label fVar7 = new Label();
            Label fVar8 = new Label();
            if (!z2) {
                hVar2.mo11038b(25, 1);
                hVar2.mo11038b(25, 4);
                hVar2.mo11038b(25, 2);
                i = TinkerReport.KEY_APPLIED_DEX_EXTRACT;
                hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2818b, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
                hVar2.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, fVar7);
            } else {
                i = TinkerReport.KEY_APPLIED_DEX_EXTRACT;
            }
            hVar2.mo11038b(25, 4);
            hVar2.mo11038b(25, 2);
            hVar2.mo11039b(i, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            hVar2.mo11033a(165, fVar7);
            hVar2.mo11036a(fVar8);
            hVar2.mo11038b(25, aVar2.mo11306a(str2));
            hVar2.mo11038b(16, 123);
            hVar2.mo11039b(i, f2821e, "write", "(I)V");
            hVar2.mo11038b(25, 0);
            hVar2.mo11038b(25, 1);
            if (aVar.f2834f.f2877c != null) {
                hVar2.mo11037a((Object) aVar.f2834f.f2877c);
            } else {
                hVar2.mo11031a(1);
            }
            hVar2.mo11038b(25, 2);
            String str8 = f2823g;
            StringBuilder sb7 = new StringBuilder();
            sb7.append(str);
            sb7.append(f2818b);
            sb7.append(";Ljava/lang/String;Ljava/lang/Object;)V");
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str8, "writeClassName", sb7.toString());
            hVar2.mo11038b(16, 44);
            hVar2.mo11033a(167, fVar6);
            hVar2.mo11036a(fVar7);
            hVar2.mo11038b(16, 123);
            hVar2.mo11036a(fVar6);
        } else {
            hVar2.mo11038b(16, 123);
        }
        hVar2.mo11038b(54, aVar2.mo11306a("seperator"));
        if (!aVar.f2835g) {
            m2927a(hVar2, aVar2);
        }
        if (!aVar.f2835g) {
            hVar2.mo11038b(25, aVar2.mo11306a(str2));
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, "isNotWriteDefaultValue", "()Z");
            hVar2.mo11038b(54, aVar2.mo11306a("notWriteDefaultValue"));
            hVar2.mo11038b(25, 1);
            hVar2.mo11038b(25, 0);
            String str9 = f2818b;
            StringBuilder sb8 = new StringBuilder();
            sb8.append("(");
            sb8.append(f2826j);
            sb8.append(")Z");
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str9, "checkValue", sb8.toString());
            hVar2.mo11038b(54, aVar2.mo11306a("checkValue"));
            hVar2.mo11038b(25, 1);
            hVar2.mo11038b(25, 0);
            String str10 = f2818b;
            StringBuilder sb9 = new StringBuilder();
            sb9.append("(");
            sb9.append(f2826j);
            sb9.append(")Z");
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str10, "hasNameFilters", sb9.toString());
            hVar2.mo11038b(54, aVar2.mo11306a("hasNameFilters"));
        }
        int i2 = 0;
        while (i2 < length) {
            FieldInfo cVar2 = cVarArr2[i2];
            Class<?> cls3 = cVar2.f2995d;
            hVar2.mo11037a((Object) cVar2.f2992a);
            hVar2.mo11038b(58, C1263a.f2829a);
            if (cls3 == Byte.TYPE || cls3 == Short.TYPE || cls3 == Integer.TYPE) {
                m2934a(cls, hVar, cVar2, aVar, aVar2.mo11306a(cls3.getName()), 'I');
            } else if (cls3 == Long.TYPE) {
                m2944c(cls2, hVar2, cVar2, aVar2);
            } else if (cls3 == Float.TYPE) {
                m2947d(cls2, hVar2, cVar2, aVar2);
            } else if (cls3 == Double.TYPE) {
                m2949e(cls2, hVar2, cVar2, aVar2);
            } else if (cls3 == Boolean.TYPE) {
                m2934a(cls, hVar, cVar2, aVar, aVar2.mo11306a(SettingsContentProvider.BOOLEAN_TYPE), 'Z');
            } else if (cls3 == Character.TYPE) {
                m2934a(cls, hVar, cVar2, aVar, aVar2.mo11306a("char"), 'C');
            } else if (cls3 == String.class) {
                m2952g(cls2, hVar2, cVar2, aVar2);
            } else if (cls3 == BigDecimal.class) {
                m2951f(cls2, hVar2, cVar2, aVar2);
            } else if (List.class.isAssignableFrom(cls3)) {
                m2953h(cls2, hVar2, cVar2, aVar2);
            } else if (cls3.isEnum()) {
                m2939b(cls2, hVar2, cVar2, aVar2);
            } else {
                m2933a(cls2, hVar2, cVar2, aVar2);
            }
            i2++;
            cVarArr2 = cVarArr;
        }
        if (!aVar.f2835g) {
            m2936b(hVar2, aVar2);
        }
        Label fVar9 = new Label();
        Label fVar10 = new Label();
        hVar2.mo11038b(21, aVar2.mo11306a("seperator"));
        hVar2.mo11032a(16, 123);
        hVar2.mo11033a(160, fVar9);
        hVar2.mo11038b(25, aVar2.mo11306a(str2));
        hVar2.mo11038b(16, 123);
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, "write", "(I)V");
        hVar2.mo11036a(fVar9);
        hVar2.mo11038b(25, aVar2.mo11306a(str2));
        hVar2.mo11038b(16, 125);
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, "write", "(I)V");
        hVar2.mo11036a(fVar10);
        hVar2.mo11036a(fVar);
        if (!aVar.f2838j) {
            hVar2.mo11038b(25, 1);
            hVar2.mo11038b(25, aVar2.mo11306a("parent"));
            String str11 = f2818b;
            StringBuilder sb10 = new StringBuilder();
            sb10.append("(");
            sb10.append(f2825i);
            sb10.append(")V");
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str11, "setContext", sb10.toString());
        }
    }

    /* renamed from: a */
    private void m2933a(Class<?> cls, MethodVisitor hVar, FieldInfo cVar, C1263a aVar) {
        Label fVar = new Label();
        m2938b(hVar, cVar, aVar, fVar);
        m2928a(hVar, aVar, cVar);
        hVar.mo11038b(58, aVar.mo11306a("object"));
        m2930a(hVar, cVar, aVar, fVar);
        m2946d(hVar, cVar, aVar, fVar);
        hVar.mo11036a(fVar);
    }

    /* renamed from: b */
    private void m2939b(Class<?> cls, MethodVisitor hVar, FieldInfo cVar, C1263a aVar) {
        Label fVar = new Label();
        Label fVar2 = new Label();
        Label fVar3 = new Label();
        m2938b(hVar, cVar, aVar, fVar3);
        m2928a(hVar, aVar, cVar);
        String str = "java/lang/Enum";
        hVar.mo11034a(192, str);
        String str2 = "enum";
        hVar.mo11038b(58, aVar.mo11306a(str2));
        m2930a(hVar, cVar, aVar, fVar3);
        hVar.mo11038b(25, aVar.mo11306a(str2));
        hVar.mo11033a(199, fVar);
        m2942c(hVar, cVar, aVar);
        hVar.mo11033a(167, fVar2);
        hVar.mo11036a(fVar);
        String str3 = "seperator";
        String str4 = "out";
        if (aVar.f2835g) {
            hVar.mo11038b(25, aVar.mo11306a(str4));
            hVar.mo11038b(21, aVar.mo11306a(str3));
            hVar.mo11038b(25, C1263a.f2829a);
            hVar.mo11038b(25, aVar.mo11306a(str2));
            hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str, ArgKey.KEY_NAME, "()Ljava/lang/String;");
            hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, "writeFieldValueStringWithDoubleQuote", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            hVar.mo11038b(25, aVar.mo11306a(str4));
            hVar.mo11038b(21, aVar.mo11306a(str3));
            hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, "write", "(I)V");
            hVar.mo11038b(25, aVar.mo11306a(str4));
            hVar.mo11038b(25, C1263a.f2829a);
            hVar.mo11031a(3);
            hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, "writeFieldName", "(Ljava/lang/String;Z)V");
            hVar.mo11038b(25, 1);
            hVar.mo11038b(25, aVar.mo11306a(str2));
            hVar.mo11038b(25, C1263a.f2829a);
            hVar.mo11037a((Object) Type.m2508a(ASMUtils.m3167a(cVar.f2995d)));
            hVar.mo11037a((Object) Integer.valueOf(cVar.f2999h));
            hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2818b, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        }
        m2945d(hVar, aVar);
        hVar.mo11036a(fVar2);
        hVar.mo11036a(fVar3);
    }

    /* renamed from: a */
    private void m2934a(Class<?> cls, MethodVisitor hVar, FieldInfo cVar, C1263a aVar, int i, char c) {
        Label fVar = new Label();
        m2938b(hVar, cVar, aVar, fVar);
        m2928a(hVar, aVar, cVar);
        hVar.mo11038b(54, i);
        m2930a(hVar, cVar, aVar, fVar);
        hVar.mo11038b(25, aVar.mo11306a("out"));
        hVar.mo11038b(21, aVar.mo11306a("seperator"));
        hVar.mo11038b(25, C1263a.f2829a);
        hVar.mo11038b(21, i);
        String str = f2821e;
        StringBuilder sb = new StringBuilder();
        sb.append("(CLjava/lang/String;");
        sb.append(c);
        sb.append(")V");
        hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str, "writeFieldValue", sb.toString());
        m2945d(hVar, aVar);
        hVar.mo11036a(fVar);
    }

    /* renamed from: c */
    private void m2944c(Class<?> cls, MethodVisitor hVar, FieldInfo cVar, C1263a aVar) {
        Label fVar = new Label();
        m2938b(hVar, cVar, aVar, fVar);
        m2928a(hVar, aVar, cVar);
        String str = SettingsContentProvider.LONG_TYPE;
        hVar.mo11038b(55, aVar.mo11307a(str, 2));
        m2930a(hVar, cVar, aVar, fVar);
        hVar.mo11038b(25, aVar.mo11306a("out"));
        hVar.mo11038b(21, aVar.mo11306a("seperator"));
        hVar.mo11038b(25, C1263a.f2829a);
        hVar.mo11038b(22, aVar.mo11307a(str, 2));
        hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, "writeFieldValue", "(CLjava/lang/String;J)V");
        m2945d(hVar, aVar);
        hVar.mo11036a(fVar);
    }

    /* renamed from: d */
    private void m2947d(Class<?> cls, MethodVisitor hVar, FieldInfo cVar, C1263a aVar) {
        Label fVar = new Label();
        m2938b(hVar, cVar, aVar, fVar);
        m2928a(hVar, aVar, cVar);
        String str = SettingsContentProvider.FLOAT_TYPE;
        hVar.mo11038b(56, aVar.mo11306a(str));
        m2930a(hVar, cVar, aVar, fVar);
        hVar.mo11038b(25, aVar.mo11306a("out"));
        hVar.mo11038b(21, aVar.mo11306a("seperator"));
        hVar.mo11038b(25, C1263a.f2829a);
        hVar.mo11038b(23, aVar.mo11306a(str));
        hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, "writeFieldValue", "(CLjava/lang/String;F)V");
        m2945d(hVar, aVar);
        hVar.mo11036a(fVar);
    }

    /* renamed from: e */
    private void m2949e(Class<?> cls, MethodVisitor hVar, FieldInfo cVar, C1263a aVar) {
        Label fVar = new Label();
        m2938b(hVar, cVar, aVar, fVar);
        m2928a(hVar, aVar, cVar);
        String str = "double";
        hVar.mo11038b(57, aVar.mo11307a(str, 2));
        m2930a(hVar, cVar, aVar, fVar);
        hVar.mo11038b(25, aVar.mo11306a("out"));
        hVar.mo11038b(21, aVar.mo11306a("seperator"));
        hVar.mo11038b(25, C1263a.f2829a);
        hVar.mo11038b(24, aVar.mo11307a(str, 2));
        hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, "writeFieldValue", "(CLjava/lang/String;D)V");
        m2945d(hVar, aVar);
        hVar.mo11036a(fVar);
    }

    /* renamed from: a */
    private void m2928a(MethodVisitor hVar, C1263a aVar, FieldInfo cVar) {
        Method method = cVar.f2993b;
        String str = "entity";
        if (method != null) {
            hVar.mo11038b(25, aVar.mo11306a(str));
            Class declaringClass = method.getDeclaringClass();
            hVar.mo11039b(declaringClass.isInterface() ? 185 : TinkerReport.KEY_APPLIED_DEX_EXTRACT, ASMUtils.m3171b(declaringClass), method.getName(), ASMUtils.m3168a(method));
            if (!method.getReturnType().equals(cVar.f2995d)) {
                hVar.mo11034a(192, ASMUtils.m3171b(cVar.f2995d));
                return;
            }
            return;
        }
        hVar.mo11038b(25, aVar.mo11306a(str));
        Field field = cVar.f2994c;
        hVar.mo11035a(TinkerReport.KEY_APPLIED_VERSION_CHECK, ASMUtils.m3171b(cVar.f2997f), field.getName(), ASMUtils.m3167a(field.getType()));
        if (!field.getType().equals(cVar.f2995d)) {
            hVar.mo11034a(192, ASMUtils.m3171b(cVar.f2995d));
        }
    }

    /* renamed from: f */
    private void m2951f(Class<?> cls, MethodVisitor hVar, FieldInfo cVar, C1263a aVar) {
        Label fVar = new Label();
        m2938b(hVar, cVar, aVar, fVar);
        m2928a(hVar, aVar, cVar);
        String str = "decimal";
        hVar.mo11038b(58, aVar.mo11306a(str));
        m2930a(hVar, cVar, aVar, fVar);
        Label fVar2 = new Label();
        Label fVar3 = new Label();
        Label fVar4 = new Label();
        hVar.mo11036a(fVar2);
        hVar.mo11038b(25, aVar.mo11306a(str));
        hVar.mo11033a(199, fVar3);
        m2942c(hVar, cVar, aVar);
        hVar.mo11033a(167, fVar4);
        hVar.mo11036a(fVar3);
        hVar.mo11038b(25, aVar.mo11306a("out"));
        hVar.mo11038b(21, aVar.mo11306a("seperator"));
        hVar.mo11038b(25, C1263a.f2829a);
        hVar.mo11038b(25, aVar.mo11306a(str));
        hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, "writeFieldValue", "(CLjava/lang/String;Ljava/math/BigDecimal;)V");
        m2945d(hVar, aVar);
        hVar.mo11033a(167, fVar4);
        hVar.mo11036a(fVar4);
        hVar.mo11036a(fVar);
    }

    /* renamed from: g */
    private void m2952g(Class<?> cls, MethodVisitor hVar, FieldInfo cVar, C1263a aVar) {
        Label fVar = new Label();
        if (cVar.f2992a.equals(aVar.f2834f.f2877c)) {
            hVar.mo11038b(25, 1);
            hVar.mo11038b(25, 4);
            hVar.mo11038b(25, 2);
            hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2818b, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
            hVar.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND, fVar);
        }
        m2938b(hVar, cVar, aVar, fVar);
        m2928a(hVar, aVar, cVar);
        String str = SettingsContentProvider.STRING_TYPE;
        hVar.mo11038b(58, aVar.mo11306a(str));
        m2930a(hVar, cVar, aVar, fVar);
        Label fVar2 = new Label();
        Label fVar3 = new Label();
        hVar.mo11038b(25, aVar.mo11306a(str));
        hVar.mo11033a(199, fVar2);
        m2942c(hVar, cVar, aVar);
        hVar.mo11033a(167, fVar3);
        hVar.mo11036a(fVar2);
        String str2 = "trim";
        if (str2.equals(cVar.f3008q)) {
            hVar.mo11038b(25, aVar.mo11306a(str));
            hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, "java/lang/String", str2, "()Ljava/lang/String;");
            hVar.mo11038b(58, aVar.mo11306a(str));
        }
        String str3 = "(CLjava/lang/String;Ljava/lang/String;)V";
        String str4 = "seperator";
        String str5 = "out";
        if (aVar.f2835g) {
            hVar.mo11038b(25, aVar.mo11306a(str5));
            hVar.mo11038b(21, aVar.mo11306a(str4));
            hVar.mo11038b(25, C1263a.f2829a);
            hVar.mo11038b(25, aVar.mo11306a(str));
            hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, "writeFieldValueStringWithDoubleQuoteCheck", str3);
        } else {
            hVar.mo11038b(25, aVar.mo11306a(str5));
            hVar.mo11038b(21, aVar.mo11306a(str4));
            hVar.mo11038b(25, C1263a.f2829a);
            hVar.mo11038b(25, aVar.mo11306a(str));
            hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, "writeFieldValue", str3);
        }
        m2945d(hVar, aVar);
        hVar.mo11036a(fVar3);
        hVar.mo11036a(fVar);
    }

    /* renamed from: h */
    private void m2953h(Class<?> cls, MethodVisitor hVar, FieldInfo cVar, C1263a aVar) {
        Label fVar;
        int i;
        int i2;
        int i3;
        Label fVar2;
        Label fVar3;
        Label fVar4;
        String str;
        Label fVar5;
        Label fVar6;
        String str2;
        MethodVisitor hVar2 = hVar;
        FieldInfo cVar2 = cVar;
        C1263a aVar2 = aVar;
        java.lang.reflect.Type e = TypeUtils.m3259e(cVar2.f2996e);
        Class<Serializable> cls2 = e instanceof Class ? (Class) e : null;
        if (cls2 == Object.class || cls2 == Serializable.class) {
            cls2 = null;
        }
        Label fVar7 = new Label();
        Label fVar8 = new Label();
        Label fVar9 = new Label();
        m2938b(hVar2, cVar2, aVar2, fVar7);
        m2928a(hVar2, aVar2, cVar2);
        String str3 = "java/util/List";
        hVar2.mo11034a(192, str3);
        String str4 = "list";
        hVar2.mo11038b(58, aVar2.mo11306a(str4));
        m2930a(hVar2, cVar2, aVar2, fVar7);
        hVar2.mo11038b(25, aVar2.mo11306a(str4));
        hVar2.mo11033a(199, fVar8);
        m2942c(hVar2, cVar2, aVar2);
        hVar2.mo11033a(167, fVar9);
        hVar2.mo11036a(fVar8);
        String str5 = "out";
        hVar2.mo11038b(25, aVar2.mo11306a(str5));
        hVar2.mo11038b(21, aVar2.mo11306a("seperator"));
        String str6 = "(I)V";
        String str7 = "write";
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, str7, str6);
        m2941c(hVar2, aVar2);
        hVar2.mo11038b(25, aVar2.mo11306a(str4));
        String str8 = AppEntity.KEY_SIZE_LONG;
        hVar2.mo11039b(185, str3, str8, "()I");
        hVar2.mo11038b(54, aVar2.mo11306a(str8));
        Label fVar10 = new Label();
        Label fVar11 = new Label();
        Label fVar12 = fVar7;
        Label fVar13 = fVar9;
        hVar2.mo11038b(21, aVar2.mo11306a(str8));
        hVar2.mo11031a(3);
        hVar2.mo11033a(160, fVar10);
        hVar2.mo11038b(25, aVar2.mo11306a(str5));
        hVar2.mo11037a((Object) "[]");
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, str7, "(Ljava/lang/String;)V");
        hVar2.mo11033a(167, fVar11);
        hVar2.mo11036a(fVar10);
        if (!aVar.f2838j) {
            hVar2.mo11038b(25, 1);
            hVar2.mo11038b(25, aVar2.mo11306a(str4));
            hVar2.mo11038b(25, C1263a.f2829a);
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2818b, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)V");
        }
        if (e != String.class || !aVar.f2835g) {
            hVar2.mo11038b(25, aVar2.mo11306a(str5));
            hVar2.mo11038b(16, 91);
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, str7, str6);
            Label fVar14 = new Label();
            Label fVar15 = new Label();
            Label fVar16 = new Label();
            hVar2.mo11031a(3);
            fVar = fVar11;
            String str9 = "i";
            java.lang.reflect.Type type = e;
            hVar2.mo11038b(54, aVar2.mo11306a(str9));
            hVar2.mo11036a(fVar14);
            hVar2.mo11038b(21, aVar2.mo11306a(str9));
            hVar2.mo11038b(21, aVar2.mo11306a(str8));
            hVar2.mo11033a(162, fVar16);
            hVar2.mo11038b(21, aVar2.mo11306a(str9));
            hVar2.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, fVar15);
            hVar2.mo11038b(25, aVar2.mo11306a(str5));
            hVar2.mo11038b(16, 44);
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, str7, str6);
            hVar2.mo11036a(fVar15);
            hVar2.mo11038b(25, aVar2.mo11306a(str4));
            hVar2.mo11038b(21, aVar2.mo11306a(str9));
            hVar2.mo11039b(185, str3, "get", "(I)Ljava/lang/Object;");
            String str10 = "list_item";
            hVar2.mo11038b(58, aVar2.mo11306a(str10));
            Label fVar17 = new Label();
            Label fVar18 = new Label();
            hVar2.mo11038b(25, aVar2.mo11306a(str10));
            hVar2.mo11033a(199, fVar18);
            hVar2.mo11038b(25, aVar2.mo11306a(str5));
            String str11 = str6;
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, "writeNull", "()V");
            hVar2.mo11033a(167, fVar17);
            hVar2.mo11036a(fVar18);
            Label fVar19 = new Label();
            Label fVar20 = new Label();
            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                fVar4 = fVar14;
                fVar3 = fVar17;
                str = str5;
                fVar2 = fVar16;
                fVar5 = fVar20;
            } else {
                hVar2.mo11038b(25, aVar2.mo11306a(str10));
                str = str5;
                hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                hVar2.mo11037a((Object) Type.m2508a(ASMUtils.m3167a(cls2)));
                hVar2.mo11033a(166, fVar20);
                m2932a(aVar2, hVar2, cVar2, cls2);
                String str12 = "list_item_desc";
                hVar2.mo11038b(58, aVar2.mo11306a(str12));
                Label fVar21 = new Label();
                Label fVar22 = new Label();
                if (aVar.f2835g) {
                    if (!aVar.f2838j || !aVar.f2835g) {
                        fVar2 = fVar16;
                        str2 = str7;
                    } else {
                        fVar2 = fVar16;
                        str2 = "writeDirectNonContext";
                    }
                    fVar4 = fVar14;
                    hVar2.mo11038b(25, aVar2.mo11306a(str12));
                    hVar2.mo11034a(193, f2823g);
                    hVar2.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, fVar21);
                    hVar2.mo11038b(25, aVar2.mo11306a(str12));
                    fVar3 = fVar17;
                    hVar2.mo11034a(192, f2823g);
                    hVar2.mo11038b(25, 1);
                    hVar2.mo11038b(25, aVar2.mo11306a(str10));
                    if (aVar.f2838j) {
                        hVar2.mo11031a(1);
                        fVar6 = fVar20;
                    } else {
                        hVar2.mo11038b(21, aVar2.mo11306a(str9));
                        fVar6 = fVar20;
                        hVar2.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                    }
                    hVar2.mo11037a((Object) Type.m2508a(ASMUtils.m3167a(cls2)));
                    hVar2.mo11037a((Object) Integer.valueOf(cVar2.f2999h));
                    String str13 = f2823g;
                    StringBuilder sb = new StringBuilder();
                    sb.append("(L");
                    sb.append(f2818b);
                    sb.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                    hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str13, str2, sb.toString());
                    hVar2.mo11033a(167, fVar22);
                    hVar2.mo11036a(fVar21);
                } else {
                    fVar4 = fVar14;
                    fVar3 = fVar17;
                    fVar2 = fVar16;
                    fVar6 = fVar20;
                }
                hVar2.mo11038b(25, aVar2.mo11306a(str12));
                hVar2.mo11038b(25, 1);
                hVar2.mo11038b(25, aVar2.mo11306a(str10));
                if (aVar.f2838j) {
                    hVar2.mo11031a(1);
                } else {
                    hVar2.mo11038b(21, aVar2.mo11306a(str9));
                    hVar2.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                }
                hVar2.mo11037a((Object) Type.m2508a(ASMUtils.m3167a(cls2)));
                hVar2.mo11037a((Object) Integer.valueOf(cVar2.f2999h));
                String str14 = f2819c;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("(L");
                sb2.append(f2818b);
                sb2.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                hVar2.mo11039b(185, str14, str7, sb2.toString());
                hVar2.mo11036a(fVar22);
                hVar2.mo11033a(167, fVar19);
                fVar5 = fVar6;
            }
            hVar2.mo11036a(fVar5);
            hVar2.mo11038b(25, 1);
            hVar2.mo11038b(25, aVar2.mo11306a(str10));
            if (aVar.f2838j) {
                hVar2.mo11031a(1);
            } else {
                hVar2.mo11038b(21, aVar2.mo11306a(str9));
                hVar2.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            }
            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2818b, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            } else {
                hVar2.mo11037a((Object) Type.m2508a(ASMUtils.m3167a((Class) type)));
                hVar2.mo11037a((Object) Integer.valueOf(cVar2.f2999h));
                hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2818b, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            }
            hVar2.mo11036a(fVar19);
            hVar2.mo11036a(fVar3);
            i3 = 1;
            hVar2.mo11040c(aVar2.mo11306a(str9), 1);
            hVar2.mo11033a(167, fVar4);
            hVar2.mo11036a(fVar2);
            i2 = 25;
            hVar2.mo11038b(25, aVar2.mo11306a(str));
            hVar2.mo11038b(16, 93);
            String str15 = f2821e;
            String str16 = str11;
            i = TinkerReport.KEY_APPLIED_DEX_EXTRACT;
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str15, str7, str16);
        } else {
            hVar2.mo11038b(25, aVar2.mo11306a(str5));
            hVar2.mo11038b(25, aVar2.mo11306a(str4));
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, str7, "(Ljava/util/List;)V");
            fVar = fVar11;
            i3 = 1;
            i2 = 25;
            i = TinkerReport.KEY_APPLIED_DEX_EXTRACT;
        }
        hVar2.mo11038b(i2, i3);
        hVar2.mo11039b(i, f2818b, "popContext", "()V");
        hVar2.mo11036a(fVar);
        m2945d(hVar2, aVar2);
        hVar2.mo11036a(fVar13);
        hVar2.mo11036a(fVar12);
    }

    /* renamed from: a */
    private void m2930a(MethodVisitor hVar, FieldInfo cVar, C1263a aVar, Label fVar) {
        if (cVar.f3003l) {
            hVar.mo11038b(25, aVar.mo11306a("out"));
            hVar.mo11037a((Object) Integer.valueOf(SerializerFeature.SkipTransientField.mask));
            hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, "isEnabled", "(I)Z");
            hVar.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND, fVar);
        }
        m2948e(hVar, cVar, aVar, fVar);
        if (!aVar.f2835g) {
            m2929a(hVar, cVar, aVar);
            hVar.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, fVar);
            m2937b(hVar, cVar, aVar);
            m2950f(hVar, cVar, aVar, fVar);
        }
    }

    /* renamed from: b */
    private void m2938b(MethodVisitor hVar, FieldInfo cVar, C1263a aVar, Label fVar) {
        if (!aVar.f2835g) {
            hVar.mo11038b(25, 0);
            hVar.mo11038b(25, 1);
            hVar.mo11038b(25, 2);
            hVar.mo11038b(25, C1263a.f2829a);
            String str = f2823g;
            StringBuilder sb = new StringBuilder();
            sb.append("(L");
            sb.append(f2818b);
            sb.append(";Ljava/lang/Object;Ljava/lang/String;)Z");
            hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str, "applyName", sb.toString());
            hVar.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, fVar);
            m2943c(hVar, cVar, aVar, fVar);
        }
        if (cVar.f2994c == null) {
            hVar.mo11038b(25, aVar.mo11306a("out"));
            hVar.mo11037a((Object) Integer.valueOf(SerializerFeature.IgnoreNonFieldGetter.mask));
            hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, "isEnabled", "(I)Z");
            hVar.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND, fVar);
        }
    }

    /* renamed from: c */
    private void m2943c(MethodVisitor hVar, FieldInfo cVar, C1263a aVar, Label fVar) {
        hVar.mo11038b(25, 0);
        hVar.mo11038b(25, 1);
        hVar.mo11037a((Object) cVar.f3001j);
        String str = f2823g;
        StringBuilder sb = new StringBuilder();
        sb.append("(L");
        sb.append(f2818b);
        sb.append(";Ljava/lang/String;)Z");
        hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str, "applyLabel", sb.toString());
        hVar.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, fVar);
    }

    /* renamed from: d */
    private void m2946d(MethodVisitor hVar, FieldInfo cVar, C1263a aVar, Label fVar) {
        String str;
        Label fVar2;
        Label fVar3;
        MethodVisitor hVar2 = hVar;
        FieldInfo cVar2 = cVar;
        C1263a aVar2 = aVar;
        String e = cVar.mo11507e();
        Class<?> cls = cVar2.f2995d;
        Label fVar4 = new Label();
        String str2 = "object";
        if (aVar.f2835g) {
            hVar2.mo11038b(25, aVar2.mo11306a(str2));
        } else {
            hVar2.mo11038b(25, C1263a.f2831c);
        }
        hVar2.mo11031a(89);
        hVar2.mo11038b(58, aVar2.mo11306a(str2));
        hVar2.mo11033a(199, fVar4);
        m2942c(hVar, cVar, aVar);
        hVar2.mo11033a(167, fVar);
        hVar2.mo11036a(fVar4);
        hVar2.mo11038b(25, aVar2.mo11306a("out"));
        hVar2.mo11038b(21, aVar2.mo11306a("seperator"));
        String str3 = "write";
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, str3, "(I)V");
        m2941c(hVar2, aVar2);
        Label fVar5 = new Label();
        Label fVar6 = new Label();
        String str4 = "Ljava/lang/reflect/Type;";
        String str5 = "_asm_fieldType";
        if (!Modifier.isPublic(cls.getModifiers()) || ParserConfig.m2908a(cls)) {
            str = e;
            fVar3 = fVar5;
            fVar2 = fVar6;
        } else {
            hVar2.mo11038b(25, aVar2.mo11306a(str2));
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            hVar2.mo11037a((Object) Type.m2508a(ASMUtils.m3167a(cls)));
            hVar2.mo11033a(166, fVar6);
            m2931a(aVar2, hVar2, cVar2);
            String str6 = "fied_ser";
            hVar2.mo11038b(58, aVar2.mo11306a(str6));
            Label fVar7 = new Label();
            Label fVar8 = new Label();
            hVar2.mo11038b(25, aVar2.mo11306a(str6));
            hVar2.mo11034a(193, f2823g);
            hVar2.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, fVar7);
            boolean z = (cVar2.f2999h & SerializerFeature.DisableCircularReferenceDetect.mask) != 0;
            boolean z2 = (SerializerFeature.BeanToArray.mask & cVar2.f2999h) != 0;
            String str7 = (z || (aVar.f2838j && aVar.f2835g)) ? z2 ? "writeAsArrayNonContext" : "writeDirectNonContext" : z2 ? "writeAsArray" : str3;
            hVar2.mo11038b(25, aVar2.mo11306a(str6));
            str = e;
            hVar2.mo11034a(192, f2823g);
            hVar2.mo11038b(25, 1);
            hVar2.mo11038b(25, aVar2.mo11306a(str2));
            hVar2.mo11038b(25, C1263a.f2829a);
            hVar2.mo11038b(25, 0);
            String d = aVar.f2833e;
            StringBuilder sb = new StringBuilder();
            sb.append(cVar2.f2992a);
            sb.append(str5);
            hVar2.mo11035a(TinkerReport.KEY_APPLIED_VERSION_CHECK, d, sb.toString(), str4);
            hVar2.mo11037a((Object) Integer.valueOf(cVar2.f2999h));
            String str8 = f2823g;
            StringBuilder sb2 = new StringBuilder();
            String str9 = "(L";
            sb2.append(str9);
            Label fVar9 = fVar6;
            sb2.append(f2818b);
            String str10 = ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V";
            sb2.append(str10);
            Label fVar10 = fVar5;
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str8, str7, sb2.toString());
            hVar2.mo11033a(167, fVar8);
            hVar2.mo11036a(fVar7);
            hVar2.mo11038b(25, aVar2.mo11306a(str6));
            hVar2.mo11038b(25, 1);
            hVar2.mo11038b(25, aVar2.mo11306a(str2));
            hVar2.mo11038b(25, C1263a.f2829a);
            hVar2.mo11038b(25, 0);
            String d2 = aVar.f2833e;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(cVar2.f2992a);
            sb3.append(str5);
            hVar2.mo11035a(TinkerReport.KEY_APPLIED_VERSION_CHECK, d2, sb3.toString(), str4);
            hVar2.mo11037a((Object) Integer.valueOf(cVar2.f2999h));
            String str11 = f2819c;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str9);
            sb4.append(f2818b);
            sb4.append(str10);
            hVar2.mo11039b(185, str11, str3, sb4.toString());
            hVar2.mo11036a(fVar8);
            fVar3 = fVar10;
            hVar2.mo11033a(167, fVar3);
            fVar2 = fVar9;
        }
        hVar2.mo11036a(fVar2);
        hVar2.mo11038b(25, 1);
        if (aVar.f2835g) {
            hVar2.mo11038b(25, aVar2.mo11306a(str2));
        } else {
            hVar2.mo11038b(25, C1263a.f2831c);
        }
        if (str != null) {
            hVar2.mo11037a((Object) str);
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2818b, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
        } else {
            hVar2.mo11038b(25, C1263a.f2829a);
            String str12 = "writeWithFieldName";
            if (!(cVar2.f2996e instanceof Class) || !((Class) cVar2.f2996e).isPrimitive()) {
                if (cVar2.f2995d == String.class) {
                    hVar2.mo11037a((Object) Type.m2508a(ASMUtils.m3167a(String.class)));
                } else {
                    hVar2.mo11038b(25, 0);
                    String d3 = aVar.f2833e;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(cVar2.f2992a);
                    sb5.append(str5);
                    hVar2.mo11035a(TinkerReport.KEY_APPLIED_VERSION_CHECK, d3, sb5.toString(), str4);
                }
                hVar2.mo11037a((Object) Integer.valueOf(cVar2.f2999h));
                hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2818b, str12, "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            } else {
                hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2818b, str12, "(Ljava/lang/Object;Ljava/lang/Object;)V");
            }
        }
        hVar2.mo11036a(fVar3);
        m2945d(hVar2, aVar2);
    }

    /* renamed from: a */
    private void m2927a(MethodVisitor hVar, C1263a aVar) {
        hVar.mo11038b(25, 0);
        hVar.mo11038b(25, 1);
        hVar.mo11038b(25, 2);
        String str = "seperator";
        hVar.mo11038b(21, aVar.mo11306a(str));
        String str2 = f2823g;
        StringBuilder sb = new StringBuilder();
        sb.append("(L");
        sb.append(f2818b);
        sb.append(";Ljava/lang/Object;C)C");
        hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str2, "writeBefore", sb.toString());
        hVar.mo11038b(54, aVar.mo11306a(str));
    }

    /* renamed from: b */
    private void m2936b(MethodVisitor hVar, C1263a aVar) {
        hVar.mo11038b(25, 0);
        hVar.mo11038b(25, 1);
        hVar.mo11038b(25, 2);
        String str = "seperator";
        hVar.mo11038b(21, aVar.mo11306a(str));
        String str2 = f2823g;
        StringBuilder sb = new StringBuilder();
        sb.append("(L");
        sb.append(f2818b);
        sb.append(";Ljava/lang/Object;C)C");
        hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str2, "writeAfter", sb.toString());
        hVar.mo11038b(54, aVar.mo11306a(str));
    }

    /* renamed from: e */
    private void m2948e(MethodVisitor hVar, FieldInfo cVar, C1263a aVar, Label fVar) {
        if (!aVar.f2835g) {
            Label fVar2 = new Label();
            hVar.mo11038b(21, aVar.mo11306a("notWriteDefaultValue"));
            hVar.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, fVar2);
            Class<?> cls = cVar.f2995d;
            if (cls == Boolean.TYPE) {
                hVar.mo11038b(21, aVar.mo11306a(SettingsContentProvider.BOOLEAN_TYPE));
                hVar.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, fVar);
            } else if (cls == Byte.TYPE) {
                hVar.mo11038b(21, aVar.mo11306a("byte"));
                hVar.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, fVar);
            } else if (cls == Short.TYPE) {
                hVar.mo11038b(21, aVar.mo11306a("short"));
                hVar.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, fVar);
            } else if (cls == Integer.TYPE) {
                hVar.mo11038b(21, aVar.mo11306a("int"));
                hVar.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, fVar);
            } else if (cls == Long.TYPE) {
                hVar.mo11038b(22, aVar.mo11306a(SettingsContentProvider.LONG_TYPE));
                hVar.mo11031a(9);
                hVar.mo11031a(148);
                hVar.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, fVar);
            } else if (cls == Float.TYPE) {
                hVar.mo11038b(23, aVar.mo11306a(SettingsContentProvider.FLOAT_TYPE));
                hVar.mo11031a(11);
                hVar.mo11031a(149);
                hVar.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, fVar);
            } else if (cls == Double.TYPE) {
                hVar.mo11038b(24, aVar.mo11306a("double"));
                hVar.mo11031a(14);
                hVar.mo11031a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_DEX_META);
                hVar.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, fVar);
            }
            hVar.mo11036a(fVar2);
        }
    }

    /* renamed from: a */
    private void m2929a(MethodVisitor hVar, FieldInfo cVar, C1263a aVar) {
        Class<?> cls = cVar.f2995d;
        hVar.mo11038b(25, 0);
        hVar.mo11038b(25, 1);
        hVar.mo11038b(25, 2);
        hVar.mo11038b(25, C1263a.f2829a);
        String str = "valueOf";
        if (cls == Byte.TYPE) {
            hVar.mo11038b(21, aVar.mo11306a("byte"));
            hVar.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Byte", str, "(B)Ljava/lang/Byte;");
        } else if (cls == Short.TYPE) {
            hVar.mo11038b(21, aVar.mo11306a("short"));
            hVar.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Short", str, "(S)Ljava/lang/Short;");
        } else if (cls == Integer.TYPE) {
            hVar.mo11038b(21, aVar.mo11306a("int"));
            hVar.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Integer", str, "(I)Ljava/lang/Integer;");
        } else if (cls == Character.TYPE) {
            hVar.mo11038b(21, aVar.mo11306a("char"));
            hVar.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Character", str, "(C)Ljava/lang/Character;");
        } else if (cls == Long.TYPE) {
            hVar.mo11038b(22, aVar.mo11307a(SettingsContentProvider.LONG_TYPE, 2));
            hVar.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Long", str, "(J)Ljava/lang/Long;");
        } else if (cls == Float.TYPE) {
            hVar.mo11038b(23, aVar.mo11306a(SettingsContentProvider.FLOAT_TYPE));
            hVar.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Float", str, "(F)Ljava/lang/Float;");
        } else if (cls == Double.TYPE) {
            hVar.mo11038b(24, aVar.mo11307a("double", 2));
            hVar.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Double", str, "(D)Ljava/lang/Double;");
        } else if (cls == Boolean.TYPE) {
            hVar.mo11038b(21, aVar.mo11306a(SettingsContentProvider.BOOLEAN_TYPE));
            hVar.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Boolean", str, "(Z)Ljava/lang/Boolean;");
        } else if (cls == BigDecimal.class) {
            hVar.mo11038b(25, aVar.mo11306a("decimal"));
        } else if (cls == String.class) {
            hVar.mo11038b(25, aVar.mo11306a(SettingsContentProvider.STRING_TYPE));
        } else if (cls.isEnum()) {
            hVar.mo11038b(25, aVar.mo11306a("enum"));
        } else if (List.class.isAssignableFrom(cls)) {
            hVar.mo11038b(25, aVar.mo11306a("list"));
        } else {
            hVar.mo11038b(25, aVar.mo11306a("object"));
        }
        String str2 = f2823g;
        StringBuilder sb = new StringBuilder();
        sb.append("(L");
        sb.append(f2818b);
        sb.append(";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z");
        hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str2, "apply", sb.toString());
    }

    /* renamed from: f */
    private void m2950f(MethodVisitor hVar, FieldInfo cVar, C1263a aVar, Label fVar) {
        MethodVisitor hVar2 = hVar;
        FieldInfo cVar2 = cVar;
        C1263a aVar2 = aVar;
        Label fVar2 = new Label();
        Class<?> cls = cVar2.f2995d;
        if (cls.isPrimitive()) {
            Label fVar3 = new Label();
            hVar2.mo11038b(21, aVar2.mo11306a("checkValue"));
            hVar2.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND, fVar3);
            hVar2.mo11031a(1);
            hVar2.mo11031a(89);
            hVar2.mo11038b(58, C1263a.f2830b);
            hVar2.mo11038b(58, C1263a.f2831c);
            hVar2.mo11033a(167, fVar2);
            hVar2.mo11036a(fVar3);
        }
        hVar2.mo11038b(25, 0);
        hVar2.mo11038b(25, 1);
        hVar2.mo11038b(25, 0);
        hVar2.mo11037a((Object) Integer.valueOf(aVar2.mo11308b(cVar2.f2992a)));
        String str = f2823g;
        StringBuilder sb = new StringBuilder();
        sb.append("(I)");
        sb.append(ASMUtils.m3167a(BeanContext.class));
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str, "getBeanContext", sb.toString());
        hVar2.mo11038b(25, 2);
        hVar2.mo11038b(25, C1263a.f2829a);
        String str2 = "valueOf";
        if (cls == Byte.TYPE) {
            hVar2.mo11038b(21, aVar2.mo11306a("byte"));
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Byte", str2, "(B)Ljava/lang/Byte;");
            hVar2.mo11031a(89);
            hVar2.mo11038b(58, C1263a.f2830b);
        } else if (cls == Short.TYPE) {
            hVar2.mo11038b(21, aVar2.mo11306a("short"));
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Short", str2, "(S)Ljava/lang/Short;");
            hVar2.mo11031a(89);
            hVar2.mo11038b(58, C1263a.f2830b);
        } else if (cls == Integer.TYPE) {
            hVar2.mo11038b(21, aVar2.mo11306a("int"));
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Integer", str2, "(I)Ljava/lang/Integer;");
            hVar2.mo11031a(89);
            hVar2.mo11038b(58, C1263a.f2830b);
        } else if (cls == Character.TYPE) {
            hVar2.mo11038b(21, aVar2.mo11306a("char"));
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Character", str2, "(C)Ljava/lang/Character;");
            hVar2.mo11031a(89);
            hVar2.mo11038b(58, C1263a.f2830b);
        } else if (cls == Long.TYPE) {
            hVar2.mo11038b(22, aVar2.mo11307a(SettingsContentProvider.LONG_TYPE, 2));
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Long", str2, "(J)Ljava/lang/Long;");
            hVar2.mo11031a(89);
            hVar2.mo11038b(58, C1263a.f2830b);
        } else if (cls == Float.TYPE) {
            hVar2.mo11038b(23, aVar2.mo11306a(SettingsContentProvider.FLOAT_TYPE));
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Float", str2, "(F)Ljava/lang/Float;");
            hVar2.mo11031a(89);
            hVar2.mo11038b(58, C1263a.f2830b);
        } else if (cls == Double.TYPE) {
            hVar2.mo11038b(24, aVar2.mo11307a("double", 2));
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Double", str2, "(D)Ljava/lang/Double;");
            hVar2.mo11031a(89);
            hVar2.mo11038b(58, C1263a.f2830b);
        } else if (cls == Boolean.TYPE) {
            hVar2.mo11038b(21, aVar2.mo11306a(SettingsContentProvider.BOOLEAN_TYPE));
            hVar2.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Boolean", str2, "(Z)Ljava/lang/Boolean;");
            hVar2.mo11031a(89);
            hVar2.mo11038b(58, C1263a.f2830b);
        } else if (cls == BigDecimal.class) {
            hVar2.mo11038b(25, aVar2.mo11306a("decimal"));
            hVar2.mo11038b(58, C1263a.f2830b);
            hVar2.mo11038b(25, C1263a.f2830b);
        } else if (cls == String.class) {
            hVar2.mo11038b(25, aVar2.mo11306a(SettingsContentProvider.STRING_TYPE));
            hVar2.mo11038b(58, C1263a.f2830b);
            hVar2.mo11038b(25, C1263a.f2830b);
        } else if (cls.isEnum()) {
            hVar2.mo11038b(25, aVar2.mo11306a("enum"));
            hVar2.mo11038b(58, C1263a.f2830b);
            hVar2.mo11038b(25, C1263a.f2830b);
        } else if (List.class.isAssignableFrom(cls)) {
            hVar2.mo11038b(25, aVar2.mo11306a("list"));
            hVar2.mo11038b(58, C1263a.f2830b);
            hVar2.mo11038b(25, C1263a.f2830b);
        } else {
            hVar2.mo11038b(25, aVar2.mo11306a("object"));
            hVar2.mo11038b(58, C1263a.f2830b);
            hVar2.mo11038b(25, C1263a.f2830b);
        }
        String str3 = f2823g;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(L");
        sb2.append(f2818b);
        sb2.append(";");
        sb2.append(ASMUtils.m3167a(BeanContext.class));
        sb2.append("Ljava/lang/Object;Ljava/lang/String;");
        sb2.append("Ljava/lang/Object;");
        sb2.append(")Ljava/lang/Object;");
        hVar2.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str3, "processValue", sb2.toString());
        hVar2.mo11038b(58, C1263a.f2831c);
        hVar2.mo11038b(25, C1263a.f2830b);
        hVar2.mo11038b(25, C1263a.f2831c);
        hVar2.mo11033a(165, fVar2);
        m2946d(hVar, cVar, aVar, fVar);
        hVar2.mo11033a(167, fVar);
        hVar2.mo11036a(fVar2);
    }

    /* renamed from: b */
    private void m2937b(MethodVisitor hVar, FieldInfo cVar, C1263a aVar) {
        Label fVar = new Label();
        hVar.mo11038b(21, aVar.mo11306a("hasNameFilters"));
        hVar.mo11033a((int) TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, fVar);
        Class<?> cls = cVar.f2995d;
        hVar.mo11038b(25, 0);
        hVar.mo11038b(25, 1);
        hVar.mo11038b(25, 2);
        hVar.mo11038b(25, C1263a.f2829a);
        String str = "valueOf";
        if (cls == Byte.TYPE) {
            hVar.mo11038b(21, aVar.mo11306a("byte"));
            hVar.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Byte", str, "(B)Ljava/lang/Byte;");
        } else if (cls == Short.TYPE) {
            hVar.mo11038b(21, aVar.mo11306a("short"));
            hVar.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Short", str, "(S)Ljava/lang/Short;");
        } else if (cls == Integer.TYPE) {
            hVar.mo11038b(21, aVar.mo11306a("int"));
            hVar.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Integer", str, "(I)Ljava/lang/Integer;");
        } else if (cls == Character.TYPE) {
            hVar.mo11038b(21, aVar.mo11306a("char"));
            hVar.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Character", str, "(C)Ljava/lang/Character;");
        } else if (cls == Long.TYPE) {
            hVar.mo11038b(22, aVar.mo11307a(SettingsContentProvider.LONG_TYPE, 2));
            hVar.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Long", str, "(J)Ljava/lang/Long;");
        } else if (cls == Float.TYPE) {
            hVar.mo11038b(23, aVar.mo11306a(SettingsContentProvider.FLOAT_TYPE));
            hVar.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Float", str, "(F)Ljava/lang/Float;");
        } else if (cls == Double.TYPE) {
            hVar.mo11038b(24, aVar.mo11307a("double", 2));
            hVar.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Double", str, "(D)Ljava/lang/Double;");
        } else if (cls == Boolean.TYPE) {
            hVar.mo11038b(21, aVar.mo11306a(SettingsContentProvider.BOOLEAN_TYPE));
            hVar.mo11039b(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, "java/lang/Boolean", str, "(Z)Ljava/lang/Boolean;");
        } else if (cls == BigDecimal.class) {
            hVar.mo11038b(25, aVar.mo11306a("decimal"));
        } else if (cls == String.class) {
            hVar.mo11038b(25, aVar.mo11306a(SettingsContentProvider.STRING_TYPE));
        } else if (cls.isEnum()) {
            hVar.mo11038b(25, aVar.mo11306a("enum"));
        } else if (List.class.isAssignableFrom(cls)) {
            hVar.mo11038b(25, aVar.mo11306a("list"));
        } else {
            hVar.mo11038b(25, aVar.mo11306a("object"));
        }
        String str2 = f2823g;
        StringBuilder sb = new StringBuilder();
        sb.append("(L");
        sb.append(f2818b);
        sb.append(";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;");
        hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str2, "processKey", sb.toString());
        hVar.mo11038b(58, C1263a.f2829a);
        hVar.mo11036a(fVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0083  */
    /* renamed from: c */
    private void m2942c(com.alibaba.fastjson.p065a.MethodVisitor r12, com.alibaba.fastjson.util.FieldInfo r13, com.alibaba.fastjson.serializer.ASMSerializerFactory.C1263a r14) {
        /*
        r11 = this;
        java.lang.Class<?> r0 = r13.f2995d
        com.alibaba.fastjson.a.f r1 = new com.alibaba.fastjson.a.f
        r1.m41548init()
        com.alibaba.fastjson.a.f r2 = new com.alibaba.fastjson.a.f
        r2.m41548init()
        com.alibaba.fastjson.a.f r3 = new com.alibaba.fastjson.a.f
        r3.m41548init()
        com.alibaba.fastjson.a.f r4 = new com.alibaba.fastjson.a.f
        r4.m41548init()
        r12.mo11036a(r1)
        com.alibaba.fastjson.annotation.JSONField r13 = r13.mo11506d()
        r1 = 0
        if (r13 == 0) goto L_0x0029
        com.alibaba.fastjson.serializer.SerializerFeature[] r13 = r13.serialzeFeatures()
        int r13 = com.alibaba.fastjson.serializer.SerializerFeature.m2926of(r13)
        goto L_0x002a
    L_0x0029:
        r13 = 0
    L_0x002a:
        java.lang.Class<java.lang.String> r5 = java.lang.String.class
        if (r0 != r5) goto L_0x003c
        com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue
        int r5 = r5.getMask()
        com.alibaba.fastjson.serializer.SerializerFeature r6 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty
        int r6 = r6.getMask()
    L_0x003a:
        r5 = r5 | r6
        goto L_0x0079
    L_0x003c:
        java.lang.Class<java.lang.Number> r5 = java.lang.Number.class
        boolean r5 = r5.isAssignableFrom(r0)
        if (r5 == 0) goto L_0x0051
        com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue
        int r5 = r5.getMask()
        com.alibaba.fastjson.serializer.SerializerFeature r6 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullNumberAsZero
        int r6 = r6.getMask()
        goto L_0x003a
    L_0x0051:
        java.lang.Class<java.util.Collection> r5 = java.util.Collection.class
        boolean r5 = r5.isAssignableFrom(r0)
        if (r5 == 0) goto L_0x0066
        com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue
        int r5 = r5.getMask()
        com.alibaba.fastjson.serializer.SerializerFeature r6 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty
        int r6 = r6.getMask()
        goto L_0x003a
    L_0x0066:
        java.lang.Class<java.lang.Boolean> r5 = java.lang.Boolean.class
        if (r5 != r0) goto L_0x0077
        com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue
        int r5 = r5.getMask()
        com.alibaba.fastjson.serializer.SerializerFeature r6 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullBooleanAsFalse
        int r6 = r6.getMask()
        goto L_0x003a
    L_0x0077:
        int r5 = com.alibaba.fastjson.serializer.SerializerFeature.WRITE_MAP_NULL_FEATURES
    L_0x0079:
        r6 = r13 & r5
        r7 = 182(0xb6, float:2.55E-43)
        java.lang.String r8 = "out"
        r9 = 25
        if (r6 != 0) goto L_0x009f
        int r6 = r14.mo11306a(r8)
        r12.mo11038b(r9, r6)
        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
        r12.mo11037a(r5)
        java.lang.String r5 = f2821e
        java.lang.String r6 = "isEnabled"
        java.lang.String r10 = "(I)Z"
        r12.mo11039b(r7, r5, r6, r10)
        r5 = 153(0x99, float:2.14E-43)
        r12.mo11033a(r5, r2)
    L_0x009f:
        r12.mo11036a(r3)
        int r3 = r14.mo11306a(r8)
        r12.mo11038b(r9, r3)
        r3 = 21
        java.lang.String r5 = "seperator"
        int r5 = r14.mo11306a(r5)
        r12.mo11038b(r3, r5)
        java.lang.String r3 = f2821e
        java.lang.String r5 = "write"
        java.lang.String r6 = "(I)V"
        r12.mo11039b(r7, r3, r5, r6)
        r11.m2941c(r12, r14)
        int r3 = r14.mo11306a(r8)
        r12.mo11038b(r9, r3)
        java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
        r12.mo11037a(r13)
        java.lang.Class<java.lang.String> r13 = java.lang.String.class
        if (r0 == r13) goto L_0x011e
        java.lang.Class<java.lang.Character> r13 = java.lang.Character.class
        if (r0 != r13) goto L_0x00d7
        goto L_0x011e
    L_0x00d7:
        java.lang.Class<java.lang.Number> r13 = java.lang.Number.class
        boolean r13 = r13.isAssignableFrom(r0)
        if (r13 == 0) goto L_0x00eb
        com.alibaba.fastjson.serializer.SerializerFeature r13 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullNumberAsZero
        int r13 = r13.mask
        java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
        r12.mo11037a(r13)
        goto L_0x0129
    L_0x00eb:
        java.lang.Class<java.lang.Boolean> r13 = java.lang.Boolean.class
        if (r0 != r13) goto L_0x00fb
        com.alibaba.fastjson.serializer.SerializerFeature r13 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullBooleanAsFalse
        int r13 = r13.mask
        java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
        r12.mo11037a(r13)
        goto L_0x0129
    L_0x00fb:
        java.lang.Class<java.util.Collection> r13 = java.util.Collection.class
        boolean r13 = r13.isAssignableFrom(r0)
        if (r13 != 0) goto L_0x0112
        boolean r13 = r0.isArray()
        if (r13 == 0) goto L_0x010a
        goto L_0x0112
    L_0x010a:
        java.lang.Integer r13 = java.lang.Integer.valueOf(r1)
        r12.mo11037a(r13)
        goto L_0x0129
    L_0x0112:
        com.alibaba.fastjson.serializer.SerializerFeature r13 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty
        int r13 = r13.mask
        java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
        r12.mo11037a(r13)
        goto L_0x0129
    L_0x011e:
        com.alibaba.fastjson.serializer.SerializerFeature r13 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty
        int r13 = r13.mask
        java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
        r12.mo11037a(r13)
    L_0x0129:
        java.lang.String r13 = f2821e
        java.lang.String r0 = "writeNull"
        java.lang.String r1 = "(II)V"
        r12.mo11039b(r7, r13, r0, r1)
        r11.m2945d(r12, r14)
        r13 = 167(0xa7, float:2.34E-43)
        r12.mo11033a(r13, r4)
        r12.mo11036a(r2)
        r12.mo11036a(r4)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.ASMSerializerFactory.m2942c(com.alibaba.fastjson.a.h, com.alibaba.fastjson.util.c, com.alibaba.fastjson.serializer.a$a):void");
    }

    /* renamed from: c */
    private void m2941c(MethodVisitor hVar, C1263a aVar) {
        String str = "out";
        if (aVar.f2835g) {
            hVar.mo11038b(25, aVar.mo11306a(str));
            hVar.mo11038b(25, C1263a.f2829a);
            hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, "writeFieldNameDirect", "(Ljava/lang/String;)V");
            return;
        }
        hVar.mo11038b(25, aVar.mo11306a(str));
        hVar.mo11038b(25, C1263a.f2829a);
        hVar.mo11031a(3);
        hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, f2821e, "writeFieldName", "(Ljava/lang/String;Z)V");
    }

    /* renamed from: d */
    private void m2945d(MethodVisitor hVar, C1263a aVar) {
        hVar.mo11038b(16, 44);
        hVar.mo11038b(54, aVar.mo11306a("seperator"));
    }

    /* renamed from: a */
    private void m2932a(C1263a aVar, MethodVisitor hVar, FieldInfo cVar, Class<?> cls) {
        Label fVar = new Label();
        hVar.mo11038b(25, 0);
        String d = aVar.f2833e;
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.f2992a);
        String str = "_asm_list_item_ser_";
        sb.append(str);
        hVar.mo11035a(TinkerReport.KEY_APPLIED_VERSION_CHECK, d, sb.toString(), f2820d);
        hVar.mo11033a(199, fVar);
        hVar.mo11038b(25, 0);
        hVar.mo11038b(25, 1);
        hVar.mo11037a((Object) Type.m2508a(ASMUtils.m3167a(cls)));
        String str2 = f2818b;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(Ljava/lang/Class;)");
        sb2.append(f2820d);
        hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str2, "getObjectWriter", sb2.toString());
        String d2 = aVar.f2833e;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(cVar.f2992a);
        sb3.append(str);
        hVar.mo11035a(TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, d2, sb3.toString(), f2820d);
        hVar.mo11036a(fVar);
        hVar.mo11038b(25, 0);
        String d3 = aVar.f2833e;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(cVar.f2992a);
        sb4.append(str);
        hVar.mo11035a(TinkerReport.KEY_APPLIED_VERSION_CHECK, d3, sb4.toString(), f2820d);
    }

    /* renamed from: a */
    private void m2931a(C1263a aVar, MethodVisitor hVar, FieldInfo cVar) {
        Label fVar = new Label();
        hVar.mo11038b(25, 0);
        String d = aVar.f2833e;
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.f2992a);
        String str = "_asm_ser_";
        sb.append(str);
        hVar.mo11035a(TinkerReport.KEY_APPLIED_VERSION_CHECK, d, sb.toString(), f2820d);
        hVar.mo11033a(199, fVar);
        hVar.mo11038b(25, 0);
        hVar.mo11038b(25, 1);
        hVar.mo11037a((Object) Type.m2508a(ASMUtils.m3167a(cVar.f2995d)));
        String str2 = f2818b;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(Ljava/lang/Class;)");
        sb2.append(f2820d);
        hVar.mo11039b(TinkerReport.KEY_APPLIED_DEX_EXTRACT, str2, "getObjectWriter", sb2.toString());
        String d2 = aVar.f2833e;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(cVar.f2992a);
        sb3.append(str);
        hVar.mo11035a(TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, d2, sb3.toString(), f2820d);
        hVar.mo11036a(fVar);
        hVar.mo11038b(25, 0);
        String d3 = aVar.f2833e;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(cVar.f2992a);
        sb4.append(str);
        hVar.mo11035a(TinkerReport.KEY_APPLIED_VERSION_CHECK, d3, sb4.toString(), f2820d);
    }
}
