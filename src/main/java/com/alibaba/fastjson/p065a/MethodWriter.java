package com.alibaba.fastjson.p065a;

/* renamed from: com.alibaba.fastjson.a.i */
public class MethodWriter implements MethodVisitor {
    /* renamed from: a */
    MethodWriter f2571a;
    /* renamed from: b */
    final ClassWriter f2572b;
    /* renamed from: c */
    int f2573c;
    /* renamed from: d */
    int[] f2574d;
    /* renamed from: e */
    private int f2575e;
    /* renamed from: f */
    private final int f2576f;
    /* renamed from: g */
    private final int f2577g;
    /* renamed from: h */
    private ByteVector f2578h = new ByteVector();
    /* renamed from: i */
    private int f2579i;
    /* renamed from: j */
    private int f2580j;

    /* renamed from: a */
    public void mo11030a() {
    }

    public MethodWriter(ClassWriter cVar, int i, String str, String str2, String str3, String[] strArr) {
        if (cVar.f2542l == null) {
            cVar.f2542l = this;
        } else {
            cVar.f2543m.f2571a = this;
        }
        cVar.f2543m = this;
        this.f2572b = cVar;
        this.f2575e = i;
        this.f2576f = cVar.mo11012a(str);
        this.f2577g = cVar.mo11012a(str2);
        if (strArr != null && strArr.length > 0) {
            this.f2573c = strArr.length;
            this.f2574d = new int[this.f2573c];
            for (int i2 = 0; i2 < this.f2573c; i2++) {
                this.f2574d[i2] = cVar.mo11019b(strArr[i2]).f2553a;
            }
        }
    }

    /* renamed from: a */
    public void mo11031a(int i) {
        this.f2578h.mo11004a(i);
    }

    /* renamed from: a */
    public void mo11032a(int i, int i2) {
        this.f2578h.mo11005a(i, i2);
    }

    /* renamed from: b */
    public void mo11038b(int i, int i2) {
        if (i2 < 4 && i != 169) {
            this.f2578h.mo11004a((i < 54 ? ((i - 21) << 2) + 26 : ((i - 54) << 2) + 59) + i2);
        } else if (i2 >= 256) {
            this.f2578h.mo11004a(196).mo11009b(i, i2);
        } else {
            this.f2578h.mo11005a(i, i2);
        }
    }

    /* renamed from: a */
    public void mo11034a(int i, String str) {
        this.f2578h.mo11009b(i, this.f2572b.mo11019b(str).f2553a);
    }

    /* renamed from: a */
    public void mo11035a(int i, String str, String str2, String str3) {
        this.f2578h.mo11009b(i, this.f2572b.mo11015a(str, str2, str3).f2553a);
    }

    /* renamed from: b */
    public void mo11039b(int i, String str, String str2, String str3) {
        boolean z = i == 185;
        Item a = this.f2572b.mo11016a(str, str2, str3, z);
        int i2 = a.f2555c;
        if (z) {
            if (i2 == 0) {
                i2 = Type.m2510b(str3);
                a.f2555c = i2;
            }
            this.f2578h.mo11009b(185, a.f2553a).mo11005a(i2 >> 2, 0);
            return;
        }
        this.f2578h.mo11009b(i, a.f2553a);
    }

    /* renamed from: a */
    public void mo11033a(int i, Label fVar) {
        if ((fVar.f2562a & 2) == 0 || fVar.f2563b - this.f2578h.f2525b >= -32768) {
            this.f2578h.mo11004a(i);
            ByteVector aVar = this.f2578h;
            fVar.mo11027a(this, aVar, aVar.f2525b - 1);
            return;
        }
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public void mo11036a(Label fVar) {
        fVar.mo11026a(this, this.f2578h.f2525b, this.f2578h.f2524a);
    }

    /* renamed from: a */
    public void mo11037a(Object obj) {
        Item a = this.f2572b.mo11013a(obj);
        int i = a.f2553a;
        if (a.f2554b == 5 || a.f2554b == 6) {
            this.f2578h.mo11009b(20, i);
        } else if (i >= 256) {
            this.f2578h.mo11009b(19, i);
        } else {
            this.f2578h.mo11005a(18, i);
        }
    }

    /* renamed from: c */
    public void mo11040c(int i, int i2) {
        this.f2578h.mo11004a(132).mo11005a(i, i2);
    }

    /* renamed from: d */
    public void mo11041d(int i, int i2) {
        this.f2579i = i;
        this.f2580j = i2;
    }

    /* access modifiers changed from: final */
    /* renamed from: b */
    public final int mo11043b() {
        int i;
        if (this.f2578h.f2525b > 0) {
            this.f2572b.mo11012a("Code");
            i = this.f2578h.f2525b + 18 + 0 + 8;
        } else {
            i = 8;
        }
        if (this.f2573c <= 0) {
            return i;
        }
        this.f2572b.mo11012a("Exceptions");
        return i + (this.f2573c * 2) + 8;
    }

    /* access modifiers changed from: final */
    /* renamed from: a */
    public final void mo11042a(ByteVector aVar) {
        aVar.mo11008b(this.f2575e & -393217).mo11008b(this.f2576f).mo11008b(this.f2577g);
        int i = this.f2578h.f2525b > 0 ? 1 : 0;
        if (this.f2573c > 0) {
            i++;
        }
        aVar.mo11008b(i);
        if (this.f2578h.f2525b > 0) {
            aVar.mo11008b(this.f2572b.mo11012a("Code")).mo11010c(this.f2578h.f2525b + 12 + 0);
            aVar.mo11008b(this.f2579i).mo11008b(this.f2580j);
            aVar.mo11010c(this.f2578h.f2525b).mo11007a(this.f2578h.f2524a, 0, this.f2578h.f2525b);
            aVar.mo11008b(0);
            aVar.mo11008b(0);
        }
        if (this.f2573c > 0) {
            aVar.mo11008b(this.f2572b.mo11012a("Exceptions")).mo11010c((this.f2573c * 2) + 2);
            aVar.mo11008b(this.f2573c);
            for (int i2 = 0; i2 < this.f2573c; i2++) {
                aVar.mo11008b(this.f2574d[i2]);
            }
        }
    }
}
