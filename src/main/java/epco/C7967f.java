package epco;

import android.text.TextUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* renamed from: epco.f */
public class C7967f {
    /* renamed from: g */
    private static final Set<String> f27072g = new HashSet(Arrays.asList(new String[]{"screenOrientation", "configChanges", "windowSoftInputMode", "launchMode", "installLocation", "protectionLevel"}));
    /* renamed from: a */
    private C7998s f27073a;
    /* renamed from: b */
    private String[] f27074b;
    /* renamed from: c */
    private ByteBuffer f27075c;
    /* renamed from: d */
    private C7982l f27076d;
    /* renamed from: e */
    private final C8012z f27077e;
    /* renamed from: f */
    private Locale f27078f = C7999s0.f27194a;

    public C7967f(ByteBuffer byteBuffer, C8012z zVar) {
        this.f27075c = byteBuffer.duplicate();
        this.f27075c.order(ByteOrder.LITTLE_ENDIAN);
        this.f27077e = zVar;
    }

    /* renamed from: a */
    private String m34469a(String str, String str2) {
        int parseInt = Integer.parseInt(str2);
        return str.equals("screenOrientation") ? C7995q0.m34592e(parseInt) : str.equals("configChanges") ? C7995q0.m34588a(parseInt) : str.equals("windowSoftInputMode") ? C7995q0.m34593f(parseInt) : str.equals("launchMode") ? C7995q0.m34590c(parseInt) : str.equals("installLocation") ? C7995q0.m34589b(parseInt) : str.equals("protectionLevel") ? C7995q0.m34591d(parseInt) : str2;
    }

    /* renamed from: a */
    private long[] m34470a(C7991p0 p0Var) {
        int a = p0Var.mo38395a() / 4;
        long[] jArr = new long[a];
        for (int i = 0; i < a; i++) {
            jArr[i] = C7997r0.m34601b(this.f27075c);
        }
        return jArr;
    }

    /* renamed from: d */
    private C7970g0 m34471d() {
        int i = this.f27075c.getInt();
        int i2 = this.f27075c.getInt();
        C7970g0 g0Var = new C7970g0();
        if (i > 0) {
            g0Var.mo38344b(this.f27073a.mo38424a(i));
        }
        g0Var.mo38342a(this.f27073a.mo38424a(i2));
        if (TextUtils.isEmpty(g0Var.mo38339a())) {
            String[] strArr = this.f27074b;
            if (strArr != null && i2 < strArr.length) {
                g0Var.mo38342a(strArr[i2]);
            }
        }
        int i3 = this.f27075c.getInt();
        if (i3 > 0) {
            g0Var.mo38346c(this.f27073a.mo38424a(i3));
        }
        g0Var.mo38341a(C8003u0.m34634a(this.f27075c, this.f27073a));
        return g0Var;
    }

    /* renamed from: e */
    private C7988o m34472e() {
        C7988o oVar;
        if (!this.f27075c.hasRemaining()) {
            return null;
        }
        long position = (long) this.f27075c.position();
        int c = C7997r0.m34603c(this.f27075c);
        int c2 = C7997r0.m34603c(this.f27075c);
        long b = C7997r0.m34601b(this.f27075c);
        if (c == 1) {
            C8000t tVar = new C8000t(c, c2, b);
            tVar.mo38427c(C7997r0.m34601b(this.f27075c));
            tVar.mo38430e(C7997r0.m34601b(this.f27075c));
            tVar.mo38426b(C7997r0.m34601b(this.f27075c));
            tVar.mo38428d(C7997r0.m34601b(this.f27075c));
            tVar.mo38432f(C7997r0.m34601b(this.f27075c));
            oVar = tVar;
        } else if (c == 3) {
            return new C7977j0(c, c2, b);
        } else {
            if (c != 384) {
                switch (c) {
                    case 256:
                    case 257:
                    case C7990p.f27143h /*258*/:
                    case C7990p.f27144i /*259*/:
                    case C7990p.f27145j /*260*/:
                        C7987n0 n0Var = new C7987n0(c, c2, b);
                        n0Var.mo38392d((int) C7997r0.m34601b(this.f27075c));
                        n0Var.mo38391c((int) C7997r0.m34601b(this.f27075c));
                        oVar = n0Var;
                        break;
                    default:
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unexpected chunk type:");
                        sb.append(c);
                        throw new IOException(sb.toString());
                }
            } else {
                this.f27075c.position((int) (position + ((long) c2)));
                return new C7991p0(c, c2, b);
            }
        }
        this.f27075c.position((int) (position + ((long) c2)));
        return oVar;
    }

    /* renamed from: f */
    private C7975i0 m34473f() {
        C7975i0 i0Var = new C7975i0();
        int i = this.f27075c.getInt();
        if (i > 0) {
            i0Var.mo38364a(this.f27073a.mo38424a(i));
        }
        i0Var.mo38363a(C8003u0.m34634a(this.f27075c, this.f27073a));
        return i0Var;
    }

    /* renamed from: g */
    private C7981k0 m34474g() {
        int i = this.f27075c.getInt();
        int i2 = this.f27075c.getInt();
        C7981k0 k0Var = new C7981k0();
        if (i > 0) {
            k0Var.mo38376a(this.f27073a.mo38424a(i));
        }
        if (i2 > 0) {
            k0Var.mo38378b(this.f27073a.mo38424a(i2));
        }
        return k0Var;
    }

    /* renamed from: h */
    private C7983l0 m34475h() {
        int i = this.f27075c.getInt();
        int i2 = this.f27075c.getInt();
        C7983l0 l0Var = new C7983l0();
        if (i > 0) {
            l0Var.mo38381a(this.f27073a.mo38424a(i));
        }
        if (i2 > 0) {
            l0Var.mo38383b(this.f27073a.mo38424a(i2));
        }
        return l0Var;
    }

    /* renamed from: i */
    private C7985m0 m34476i() {
        C7985m0 m0Var = new C7985m0();
        int i = this.f27075c.getInt();
        int i2 = this.f27075c.getInt();
        if (i > 0) {
            m0Var.mo38389b(this.f27073a.mo38424a(i));
        }
        m0Var.mo38387a(this.f27073a.mo38424a(i2));
        C7982l lVar = this.f27076d;
        if (lVar != null) {
            lVar.mo38315a(m0Var);
        }
        return m0Var;
    }

    /* renamed from: j */
    private C7989o0 m34477j() {
        int i = this.f27075c.getInt();
        int i2 = this.f27075c.getInt();
        C7989o0 o0Var = new C7989o0();
        if (i > 0) {
            o0Var.mo38406b(this.f27073a.mo38424a(i));
        }
        o0Var.mo38404a(this.f27073a.mo38424a(i2));
        C7997r0.m34603c(this.f27075c);
        C7997r0.m34603c(this.f27075c);
        int c = C7997r0.m34603c(this.f27075c);
        C7997r0.m34603c(this.f27075c);
        C7997r0.m34603c(this.f27075c);
        C7997r0.m34603c(this.f27075c);
        C7973h0 h0Var = new C7973h0(c);
        for (int i3 = 0; i3 < c; i3++) {
            C7970g0 d = m34471d();
            if (this.f27076d != null) {
                String a = d.mo38340a(this.f27077e, this.f27078f);
                if (f27072g.contains(d.mo38339a()) && C8007w0.m34702b(a)) {
                    try {
                        a = m34469a(d.mo38339a(), a);
                    } catch (Exception unused) {
                    }
                }
                d.mo38348d(a);
                h0Var.mo38353a(i3, d);
            }
        }
        o0Var.mo38403a(h0Var);
        C7982l lVar = this.f27076d;
        if (lVar != null) {
            lVar.mo38316a(o0Var);
        }
        return o0Var;
    }

    /* renamed from: a */
    public Locale mo38325a() {
        return this.f27078f;
    }

    /* renamed from: a */
    public void mo38326a(C7982l lVar) {
        this.f27076d = lVar;
    }

    /* renamed from: a */
    public void mo38327a(Locale locale) {
        if (locale != null) {
            this.f27078f = locale;
        }
    }

    /* renamed from: b */
    public C7982l mo38328b() {
        return this.f27076d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0059  */
    /* renamed from: c */
    public void mo38329c() {
        /*
        r6 = this;
        epco.o r0 = r6.m34472e()
        if (r0 != 0) goto L_0x0007
        return
    L_0x0007:
        int r0 = r0.mo38400c()
        r1 = 3
        if (r0 == r1) goto L_0x000f
        return
    L_0x000f:
        epco.o r0 = r6.m34472e()
        if (r0 != 0) goto L_0x0016
        return
    L_0x0016:
        int r1 = r0.mo38400c()
        r2 = 1
        epco.C8003u0.m34640a(r2, r1)
        java.nio.ByteBuffer r1 = r6.f27075c
        epco.t r0 = (epco.C8000t) r0
        epco.s r0 = epco.C8003u0.m34635a(r1, r0)
        r6.f27073a = r0
        epco.o r0 = r6.m34472e()
        if (r0 != 0) goto L_0x002f
        return
    L_0x002f:
        int r1 = r0.mo38400c()
        r2 = 384(0x180, float:5.38E-43)
        if (r1 != r2) goto L_0x0057
        epco.p0 r0 = (epco.C7991p0) r0
        long[] r0 = r6.m34470a(r0)
        int r1 = r0.length
        java.lang.String[] r1 = new java.lang.String[r1]
        r6.f27074b = r1
        r1 = 0
    L_0x0043:
        int r2 = r0.length
        if (r1 >= r2) goto L_0x0053
        java.lang.String[] r2 = r6.f27074b
        r3 = r0[r1]
        java.lang.String r3 = epco.C7970g0.C7971a.m34508a(r3)
        r2[r1] = r3
        int r1 = r1 + 1
        goto L_0x0043
    L_0x0053:
        epco.o r0 = r6.m34472e()
    L_0x0057:
        if (r0 == 0) goto L_0x00c8
        java.nio.ByteBuffer r1 = r6.f27075c
        int r1 = r1.position()
        long r1 = (long) r1
        int r3 = r0.mo38400c()
        switch(r3) {
            case 256: goto L_0x0097;
            case 257: goto L_0x008d;
            case 258: goto L_0x0089;
            case 259: goto L_0x0085;
            case 260: goto L_0x0081;
            default: goto L_0x0067;
        }
    L_0x0067:
        int r3 = r0.mo38400c()
        r4 = 256(0x100, float:3.59E-43)
        if (r3 < r4) goto L_0x00ad
        int r3 = r0.mo38400c()
        r4 = 383(0x17f, float:5.37E-43)
        if (r3 > r4) goto L_0x00ad
        java.nio.ByteBuffer r3 = r6.f27075c
        int r4 = r0.mo38395a()
        epco.C7997r0.m34604c(r3, r4)
        goto L_0x00a0
    L_0x0081:
        r6.m34473f()
        goto L_0x00a0
    L_0x0085:
        r6.m34476i()
        goto L_0x00a0
    L_0x0089:
        r6.m34477j()
        goto L_0x00a0
    L_0x008d:
        epco.k0 r3 = r6.m34474g()
        epco.l r4 = r6.f27076d
        r4.mo38313a(r3)
        goto L_0x00a0
    L_0x0097:
        epco.l0 r3 = r6.m34475h()
        epco.l r4 = r6.f27076d
        r4.mo38314a(r3)
    L_0x00a0:
        java.nio.ByteBuffer r3 = r6.f27075c
        int r0 = r0.mo38395a()
        long r4 = (long) r0
        long r1 = r1 + r4
        int r0 = (int) r1
        r3.position(r0)
        goto L_0x0053
    L_0x00ad:
        java.io.IOException r1 = new java.io.IOException
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r3 = "Unexpected chunk type:"
        r2.append(r3)
        int r0 = r0.mo38400c()
        r2.append(r0)
        java.lang.String r0 = r2.toString()
        r1.<init>(r0)
        throw r1
    L_0x00c8:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: epco.C7967f.mo38329c():void");
    }
}
