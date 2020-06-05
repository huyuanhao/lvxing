package iko.dmaz.lloq;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: iko.dmaz.lloq.d */
public class C8064d<T> {
    /* renamed from: a */
    private String f27341a;
    /* renamed from: b */
    private int f27342b;
    /* renamed from: c */
    private String f27343c;
    /* renamed from: d */
    private C8062b f27344d;
    /* renamed from: e */
    private String f27345e;
    /* renamed from: f */
    private List<C8066a> f27346f = new ArrayList();

    /* renamed from: iko.dmaz.lloq.d$a */
    public class C8066a implements Comparable<C8066a> {
        /* access modifiers changed from: private */
        /* renamed from: b */
        public String f27349b;
        /* renamed from: c */
        private int f27350c;
        /* access modifiers changed from: private */
        /* renamed from: d */
        public boolean f27351d;
        /* access modifiers changed from: private */
        /* renamed from: e */
        public int f27352e;
        /* access modifiers changed from: private */
        /* renamed from: f */
        public boolean f27353f;
        /* access modifiers changed from: private */
        /* renamed from: g */
        public C8068f f27354g;

        public C8066a(String str, int i, boolean z, boolean z2, C8068f fVar, int i2) {
            this.f27349b = str;
            this.f27350c = i;
            this.f27354g = fVar;
            this.f27353f = z;
            this.f27351d = z2;
            this.f27352e = i2;
        }

        /* renamed from: a */
        public int compareTo(C8066a aVar) {
            int i = aVar.f27350c;
            int i2 = this.f27350c;
            if (i > i2) {
                return -1;
            }
            return i < i2 ? 1 : 0;
        }
    }

    public C8064d(Class<T> cls, String str, C8062b bVar, boolean z) {
        int i;
        Field[] fieldArr;
        Class<T> cls2 = cls;
        this.f27344d = bVar;
        this.f27345e = str;
        ArrayList arrayList = new ArrayList();
        if (cls2.isAnnotationPresent(Schema.class)) {
            Schema schema = (Schema) cls2.getAnnotation(Schema.class);
            this.f27341a = schema.mo38797a();
            this.f27343c = schema.mo38798b();
            this.f27342b = schema.mo38799c();
            Field[] declaredFields = cls.getDeclaredFields();
            boolean z2 = false;
            int i2 = 0;
            int i3 = 0;
            for (Field isAnnotationPresent : declaredFields) {
                if (isAnnotationPresent.isAnnotationPresent(SyncField.class)) {
                    i2 += i3;
                    i3++;
                }
            }
            int length = declaredFields.length;
            int i4 = 0;
            int i5 = 0;
            while (i4 < length) {
                Field field = declaredFields[i4];
                if (field.isAnnotationPresent(SyncField.class)) {
                    SyncField syncField = (SyncField) field.getAnnotation(SyncField.class);
                    boolean a = syncField.mo38800a();
                    String a2 = m34890a(field.getName());
                    Class type = field.getType();
                    Class type2 = field.getType();
                    int b = syncField.mo38801b();
                    C8068f a3 = m34889a(type.toString(), type2);
                    if (b == -1) {
                        throw new RuntimeException("index can not be -1");
                    } else if (b != 0 || !z2) {
                        boolean z3 = b == 0 ? true : z2;
                        int i6 = i2 - b;
                        fieldArr = declaredFields;
                        C8066a aVar = r0;
                        C8068f fVar = a3;
                        i = length;
                        int i7 = b;
                        C8066a aVar2 = new C8066a(a2, b, type2.isPrimitive(), a, a3, i5);
                        arrayList.add(new C8067e(a2, fVar, !a, i7));
                        this.f27346f.add(aVar);
                        i5++;
                        z2 = z3;
                        i2 = i6;
                    } else {
                        throw new RuntimeException("has more than zero index");
                    }
                } else {
                    fieldArr = declaredFields;
                    i = length;
                }
                i4++;
                declaredFields = fieldArr;
                length = i;
            }
            if (i2 == 0) {
                Collections.sort(this.f27346f);
                Collections.sort(arrayList);
                this.f27344d.mo38803a(this.f27341a, this.f27343c, this.f27342b, this.f27345e);
                if (z) {
                    this.f27344d.mo38804a((List<C8067e>) arrayList);
                    return;
                }
                return;
            }
            throw new RuntimeException("field index must be continue");
        }
        throw new RuntimeException("has no schema annotation");
    }

    /* renamed from: a */
    private iko.dmaz.lloq.C8068f m34889a(java.lang.String r3, java.lang.Class<?> r4) {
        /*
        r2 = this;
        int r4 = r3.hashCode()
        switch(r4) {
            case -1325958191: goto L_0x00a0;
            case -1228850172: goto L_0x0096;
            case -1228562056: goto L_0x008b;
            case -1066470206: goto L_0x0081;
            case 104431: goto L_0x0077;
            case 3039496: goto L_0x006d;
            case 3327612: goto L_0x0062;
            case 64711720: goto L_0x0058;
            case 97526364: goto L_0x004d;
            case 109413500: goto L_0x0043;
            case 239044557: goto L_0x0037;
            case 563652320: goto L_0x002b;
            case 575539456: goto L_0x0020;
            case 673016845: goto L_0x0014;
            case 1335156652: goto L_0x0009;
            default: goto L_0x0007;
        }
    L_0x0007:
        goto L_0x00ab
    L_0x0009:
        java.lang.String r4 = "class java.lang.Boolean"
        boolean r4 = r3.equals(r4)
        if (r4 == 0) goto L_0x00ab
        r4 = 3
        goto L_0x00ac
    L_0x0014:
        java.lang.String r4 = "class java.lang.String"
        boolean r4 = r3.equals(r4)
        if (r4 == 0) goto L_0x00ab
        r4 = 14
        goto L_0x00ac
    L_0x0020:
        java.lang.String r4 = "class java.lang.Short"
        boolean r4 = r3.equals(r4)
        if (r4 == 0) goto L_0x00ab
        r4 = 5
        goto L_0x00ac
    L_0x002b:
        java.lang.String r4 = "class java.lang.Float"
        boolean r4 = r3.equals(r4)
        if (r4 == 0) goto L_0x00ab
        r4 = 11
        goto L_0x00ac
    L_0x0037:
        java.lang.String r4 = "class java.lang.Double"
        boolean r4 = r3.equals(r4)
        if (r4 == 0) goto L_0x00ab
        r4 = 13
        goto L_0x00ac
    L_0x0043:
        java.lang.String r4 = "short"
        boolean r4 = r3.equals(r4)
        if (r4 == 0) goto L_0x00ab
        r4 = 4
        goto L_0x00ac
    L_0x004d:
        java.lang.String r4 = "float"
        boolean r4 = r3.equals(r4)
        if (r4 == 0) goto L_0x00ab
        r4 = 10
        goto L_0x00ac
    L_0x0058:
        java.lang.String r4 = "boolean"
        boolean r4 = r3.equals(r4)
        if (r4 == 0) goto L_0x00ab
        r4 = 2
        goto L_0x00ac
    L_0x0062:
        java.lang.String r4 = "long"
        boolean r4 = r3.equals(r4)
        if (r4 == 0) goto L_0x00ab
        r4 = 8
        goto L_0x00ac
    L_0x006d:
        java.lang.String r4 = "byte"
        boolean r4 = r3.equals(r4)
        if (r4 == 0) goto L_0x00ab
        r4 = 6
        goto L_0x00ac
    L_0x0077:
        java.lang.String r4 = "int"
        boolean r4 = r3.equals(r4)
        if (r4 == 0) goto L_0x00ab
        r4 = 0
        goto L_0x00ac
    L_0x0081:
        java.lang.String r4 = "class java.lang.Integer"
        boolean r4 = r3.equals(r4)
        if (r4 == 0) goto L_0x00ab
        r4 = 1
        goto L_0x00ac
    L_0x008b:
        java.lang.String r4 = "class java.lang.Long"
        boolean r4 = r3.equals(r4)
        if (r4 == 0) goto L_0x00ab
        r4 = 9
        goto L_0x00ac
    L_0x0096:
        java.lang.String r4 = "class java.lang.Byte"
        boolean r4 = r3.equals(r4)
        if (r4 == 0) goto L_0x00ab
        r4 = 7
        goto L_0x00ac
    L_0x00a0:
        java.lang.String r4 = "double"
        boolean r4 = r3.equals(r4)
        if (r4 == 0) goto L_0x00ab
        r4 = 12
        goto L_0x00ac
    L_0x00ab:
        r4 = -1
    L_0x00ac:
        switch(r4) {
            case 0: goto L_0x00db;
            case 1: goto L_0x00db;
            case 2: goto L_0x00d8;
            case 3: goto L_0x00d8;
            case 4: goto L_0x00d5;
            case 5: goto L_0x00d5;
            case 6: goto L_0x00d2;
            case 7: goto L_0x00d2;
            case 8: goto L_0x00cf;
            case 9: goto L_0x00cf;
            case 10: goto L_0x00cc;
            case 11: goto L_0x00cc;
            case 12: goto L_0x00c9;
            case 13: goto L_0x00c9;
            case 14: goto L_0x00c6;
            default: goto L_0x00af;
        }
    L_0x00af:
        java.lang.RuntimeException r4 = new java.lang.RuntimeException
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "cat not support data type:"
        r0.append(r1)
        r0.append(r3)
        java.lang.String r3 = r0.toString()
        r4.<init>(r3)
        throw r4
    L_0x00c6:
        iko.dmaz.lloq.f r3 = iko.dmaz.lloq.C8068f.STRING
        return r3
    L_0x00c9:
        iko.dmaz.lloq.f r3 = iko.dmaz.lloq.C8068f.FLOAT64
        return r3
    L_0x00cc:
        iko.dmaz.lloq.f r3 = iko.dmaz.lloq.C8068f.FLOAT32
        return r3
    L_0x00cf:
        iko.dmaz.lloq.f r3 = iko.dmaz.lloq.C8068f.INT64
        return r3
    L_0x00d2:
        iko.dmaz.lloq.f r3 = iko.dmaz.lloq.C8068f.BYTES
        return r3
    L_0x00d5:
        iko.dmaz.lloq.f r3 = iko.dmaz.lloq.C8068f.INT16
        return r3
    L_0x00d8:
        iko.dmaz.lloq.f r3 = iko.dmaz.lloq.C8068f.BOOLEAN
        return r3
    L_0x00db:
        iko.dmaz.lloq.f r3 = iko.dmaz.lloq.C8068f.INT32
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: iko.dmaz.lloq.C8064d.m34889a(java.lang.String, java.lang.Class):iko.dmaz.lloq.f");
    }

    /* renamed from: a */
    private String m34890a(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                stringBuffer.append("_");
            }
            stringBuffer.append(Character.toLowerCase(str.charAt(i)));
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public String mo38806a(T t) {
        StringBuffer stringBuffer = new StringBuffer();
        Field[] declaredFields = t.getClass().getDeclaredFields();
        int i = 1;
        for (C8066a aVar : this.f27346f) {
            Field field = declaredFields[aVar.f27352e];
            field.setAccessible(true);
            String str = "\u0001";
            if (!aVar.f27353f) {
                if (field.get(t) == null && !aVar.f27351d) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("field:");
                    sb.append(field.getName());
                    sb.append(" can not be null");
                    throw new RuntimeException(sb.toString());
                } else if ((aVar.f27351d && field.get(t) == null) || (field.get(t) != null && field.get(t).toString().isEmpty())) {
                    stringBuffer.append("null");
                    stringBuffer.append(str);
                    i++;
                }
            }
            mo38808a(stringBuffer, t, field, aVar.f27354g, aVar.f27349b);
            if (i >= this.f27346f.size()) {
                i++;
            }
            stringBuffer.append(str);
            i++;
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public String mo38807a(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        if (list.get(0).getClass().isAnnotationPresent(Schema.class)) {
            StringBuffer stringBuffer = new StringBuffer();
            for (T a : list) {
                stringBuffer.append(mo38806a(a));
                stringBuffer.append("\u0002");
            }
            this.f27344d.mo38802a(stringBuffer.toString());
            return stringBuffer.toString();
        }
        throw new RuntimeException("has no schema annotation");
    }

    /* renamed from: a */
    public void mo38808a(StringBuffer stringBuffer, T t, Field field, C8068f fVar, String str) {
        switch (fVar) {
            case INT32:
            case INT16:
            case INT64:
            case FLOAT32:
            case FLOAT64:
            case BOOLEAN:
            case MAP:
                stringBuffer.append(field.get(t));
                return;
            case ARRAY:
                stringBuffer.append((Object[]) field.get(t));
                break;
        }
        stringBuffer.append(field.get(t).toString());
    }
}
