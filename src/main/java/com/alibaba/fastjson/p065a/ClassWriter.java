package com.alibaba.fastjson.p065a;

/* renamed from: com.alibaba.fastjson.a.c */
public class ClassWriter {
    /* renamed from: a */
    int f2531a;
    /* renamed from: b */
    int f2532b;
    /* renamed from: c */
    final ByteVector f2533c;
    /* renamed from: d */
    Item[] f2534d;
    /* renamed from: e */
    int f2535e;
    /* renamed from: f */
    final Item f2536f;
    /* renamed from: g */
    final Item f2537g;
    /* renamed from: h */
    final Item f2538h;
    /* renamed from: i */
    String f2539i;
    /* renamed from: j */
    FieldWriter f2540j;
    /* renamed from: k */
    FieldWriter f2541k;
    /* renamed from: l */
    MethodWriter f2542l;
    /* renamed from: m */
    MethodWriter f2543m;
    /* renamed from: n */
    private int f2544n;
    /* renamed from: o */
    private int f2545o;
    /* renamed from: p */
    private int f2546p;
    /* renamed from: q */
    private int f2547q;
    /* renamed from: r */
    private int[] f2548r;

    public ClassWriter() {
        this(0);
    }

    private ClassWriter(int i) {
        this.f2532b = 1;
        this.f2533c = new ByteVector();
        this.f2534d = new Item[256];
        this.f2535e = (int) (((double) this.f2534d.length) * 0.75d);
        this.f2536f = new Item();
        this.f2537g = new Item();
        this.f2538h = new Item();
    }

    /* renamed from: a */
    public void mo11017a(int i, int i2, String str, String str2, String[] strArr) {
        int i3;
        this.f2531a = i;
        this.f2544n = i2;
        this.f2545o = mo11019b(str).f2553a;
        this.f2539i = str;
        if (str2 == null) {
            i3 = 0;
        } else {
            i3 = mo11019b(str2).f2553a;
        }
        this.f2546p = i3;
        if (strArr != null && strArr.length > 0) {
            this.f2547q = strArr.length;
            this.f2548r = new int[this.f2547q];
            for (int i4 = 0; i4 < this.f2547q; i4++) {
                this.f2548r[i4] = mo11019b(strArr[i4]).f2553a;
            }
        }
    }

    /* renamed from: a */
    public byte[] mo11018a() {
        int i = (this.f2547q * 2) + 24;
        int i2 = i;
        int i3 = 0;
        for (FieldWriter dVar = this.f2540j; dVar != null; dVar = dVar.f2549a) {
            i3++;
            i2 += dVar.mo11022b();
        }
        int i4 = 0;
        for (MethodWriter iVar = this.f2542l; iVar != null; iVar = iVar.f2571a) {
            i4++;
            i2 += iVar.mo11043b();
        }
        ByteVector aVar = new ByteVector(i2 + this.f2533c.f2525b);
        aVar.mo11010c(-889275714).mo11010c(this.f2531a);
        aVar.mo11008b(this.f2532b).mo11007a(this.f2533c.f2524a, 0, this.f2533c.f2525b);
        aVar.mo11008b(this.f2544n & -393217).mo11008b(this.f2545o).mo11008b(this.f2546p);
        aVar.mo11008b(this.f2547q);
        for (int i5 = 0; i5 < this.f2547q; i5++) {
            aVar.mo11008b(this.f2548r[i5]);
        }
        aVar.mo11008b(i3);
        for (FieldWriter dVar2 = this.f2540j; dVar2 != null; dVar2 = dVar2.f2549a) {
            dVar2.mo11021a(aVar);
        }
        aVar.mo11008b(i4);
        for (MethodWriter iVar2 = this.f2542l; iVar2 != null; iVar2 = iVar2.f2571a) {
            iVar2.mo11042a(aVar);
        }
        aVar.mo11008b(0);
        return aVar.f2524a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Item mo11013a(Object obj) {
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            this.f2536f.mo11023a(intValue);
            Item a = m2460a(this.f2536f);
            if (a == null) {
                this.f2533c.mo11004a(3).mo11010c(intValue);
                int i = this.f2532b;
                this.f2532b = i + 1;
                a = new Item(i, this.f2536f);
                m2461b(a);
            }
            return a;
        } else if (obj instanceof String) {
            return m2462c((String) obj);
        } else {
            if (obj instanceof Type) {
                Type jVar = (Type) obj;
                return mo11019b(jVar.f2590j == 10 ? jVar.mo11044a() : jVar.mo11045b());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("value ");
            sb.append(obj);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: a */
    public int mo11012a(String str) {
        this.f2536f.mo11024a(1, str, null, null);
        Item a = m2460a(this.f2536f);
        if (a == null) {
            this.f2533c.mo11004a(1).mo11006a(str);
            int i = this.f2532b;
            this.f2532b = i + 1;
            a = new Item(i, this.f2536f);
            m2461b(a);
        }
        return a.f2553a;
    }

    /* renamed from: b */
    public Item mo11019b(String str) {
        this.f2537g.mo11024a(7, str, null, null);
        Item a = m2460a(this.f2537g);
        if (a != null) {
            return a;
        }
        this.f2533c.mo11009b(7, mo11012a(str));
        int i = this.f2532b;
        this.f2532b = i + 1;
        Item eVar = new Item(i, this.f2537g);
        m2461b(eVar);
        return eVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Item mo11015a(String str, String str2, String str3) {
        this.f2538h.mo11024a(9, str, str2, str3);
        Item a = m2460a(this.f2538h);
        if (a != null) {
            return a;
        }
        int i = mo11019b(str).f2553a;
        this.f2533c.mo11009b(9, i).mo11008b(mo11014a(str2, str3).f2553a);
        int i2 = this.f2532b;
        this.f2532b = i2 + 1;
        Item eVar = new Item(i2, this.f2538h);
        m2461b(eVar);
        return eVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Item mo11016a(String str, String str2, String str3, boolean z) {
        int i = z ? 11 : 10;
        this.f2538h.mo11024a(i, str, str2, str3);
        Item a = m2460a(this.f2538h);
        if (a != null) {
            return a;
        }
        this.f2533c.mo11009b(i, mo11019b(str).f2553a).mo11008b(mo11014a(str2, str3).f2553a);
        int i2 = this.f2532b;
        this.f2532b = i2 + 1;
        Item eVar = new Item(i2, this.f2538h);
        m2461b(eVar);
        return eVar;
    }

    /* renamed from: c */
    private Item m2462c(String str) {
        this.f2537g.mo11024a(8, str, null, null);
        Item a = m2460a(this.f2537g);
        if (a != null) {
            return a;
        }
        this.f2533c.mo11009b(8, mo11012a(str));
        int i = this.f2532b;
        this.f2532b = i + 1;
        Item eVar = new Item(i, this.f2537g);
        m2461b(eVar);
        return eVar;
    }

    /* renamed from: a */
    public Item mo11014a(String str, String str2) {
        this.f2537g.mo11024a(12, str, str2, null);
        Item a = m2460a(this.f2537g);
        if (a != null) {
            return a;
        }
        int a2 = mo11012a(str);
        this.f2533c.mo11009b(12, a2).mo11008b(mo11012a(str2));
        int i = this.f2532b;
        this.f2532b = i + 1;
        Item eVar = new Item(i, this.f2537g);
        m2461b(eVar);
        return eVar;
    }

    /* renamed from: a */
    private Item m2460a(Item eVar) {
        Item eVar2 = this.f2534d[eVar.f2560h % this.f2534d.length];
        while (eVar2 != null && (eVar2.f2554b != eVar.f2554b || !eVar.mo11025a(eVar2))) {
            eVar2 = eVar2.f2561i;
        }
        return eVar2;
    }

    /* renamed from: b */
    private void m2461b(Item eVar) {
        if (this.f2532b > this.f2535e) {
            int length = this.f2534d.length;
            int i = (length * 2) + 1;
            Item[] eVarArr = new Item[i];
            for (int i2 = length - 1; i2 >= 0; i2--) {
                Item eVar2 = this.f2534d[i2];
                while (eVar2 != null) {
                    int length2 = eVar2.f2560h % eVarArr.length;
                    Item eVar3 = eVar2.f2561i;
                    eVar2.f2561i = eVarArr[length2];
                    eVarArr[length2] = eVar2;
                    eVar2 = eVar3;
                }
            }
            this.f2534d = eVarArr;
            this.f2535e = (int) (((double) i) * 0.75d);
        }
        int i3 = eVar.f2560h;
        Item[] eVarArr2 = this.f2534d;
        int length3 = i3 % eVarArr2.length;
        eVar.f2561i = eVarArr2[length3];
        eVarArr2[length3] = eVar;
    }
}
