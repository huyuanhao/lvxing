package epco;

import java.nio.ByteBuffer;
import java.util.Locale;

/* renamed from: epco.c0 */
public class C7957c0 {
    /* renamed from: a */
    private String f27038a;
    /* renamed from: b */
    private short f27039b;
    /* renamed from: c */
    private Locale f27040c;
    /* renamed from: d */
    private C7998s f27041d;
    /* renamed from: e */
    private ByteBuffer f27042e;
    /* renamed from: f */
    private long[] f27043f;
    /* renamed from: g */
    private C7998s f27044g;

    public C7957c0(C7962d0 d0Var) {
        this.f27039b = d0Var.mo38308h();
        this.f27040c = new Locale(d0Var.mo38305e().mo38470f(), d0Var.mo38305e().mo38452a());
    }

    /* renamed from: h */
    private C8006w m34406h() {
        long position = (long) this.f27042e.position();
        C8006w wVar = new C8006w();
        wVar.mo38498b(C7997r0.m34603c(this.f27042e));
        wVar.mo38494a(C7997r0.m34603c(this.f27042e));
        wVar.mo38496a(this.f27041d.mo38424a((int) ((long) this.f27042e.getInt())));
        if ((wVar.mo38492a() & 1) != 0) {
            C8008x xVar = new C8008x(wVar);
            xVar.mo38504b(C7997r0.m34601b(this.f27042e));
            xVar.mo38502a(C7997r0.m34601b(this.f27042e));
            this.f27042e.position((int) (position + ((long) wVar.mo38499c())));
            C7952b0[] b0VarArr = new C7952b0[((int) xVar.mo38505e())];
            for (int i = 0; ((long) i) < xVar.mo38505e(); i++) {
                b0VarArr[i] = m34407i();
            }
            xVar.mo38503a(b0VarArr);
            return xVar;
        }
        this.f27042e.position((int) (position + ((long) wVar.mo38499c())));
        wVar.mo38495a(C8003u0.m34634a(this.f27042e, this.f27044g));
        return wVar;
    }

    /* renamed from: i */
    private C7952b0 m34407i() {
        C7952b0 b0Var = new C7952b0();
        b0Var.mo38267a(C7997r0.m34601b(this.f27042e));
        b0Var.mo38268a(C8003u0.m34634a(this.f27042e, this.f27044g));
        if ((b0Var.mo38270b() & 33554432) == 0) {
            b0Var.mo38270b();
        }
        return b0Var;
    }

    /* renamed from: a */
    public C8006w mo38275a(int i) {
        long[] jArr = this.f27043f;
        if (i >= jArr.length || jArr[i] == C7962d0.f27060j) {
            return null;
        }
        this.f27042e.position((int) jArr[i]);
        return m34406h();
    }

    /* renamed from: a */
    public ByteBuffer mo38276a() {
        return this.f27042e;
    }

    /* renamed from: a */
    public void mo38277a(C7998s sVar) {
        this.f27041d = sVar;
    }

    /* renamed from: a */
    public void mo38278a(String str) {
        this.f27038a = str;
    }

    /* renamed from: a */
    public void mo38279a(ByteBuffer byteBuffer) {
        this.f27042e = byteBuffer;
    }

    /* renamed from: a */
    public void mo38280a(Locale locale) {
        this.f27040c = locale;
    }

    /* renamed from: a */
    public void mo38281a(short s) {
        this.f27039b = s;
    }

    /* renamed from: a */
    public void mo38282a(long[] jArr) {
        this.f27043f = jArr;
    }

    /* renamed from: b */
    public short mo38283b() {
        return this.f27039b;
    }

    /* renamed from: b */
    public void mo38284b(C7998s sVar) {
        this.f27044g = sVar;
    }

    /* renamed from: c */
    public C7998s mo38285c() {
        return this.f27041d;
    }

    /* renamed from: d */
    public Locale mo38286d() {
        return this.f27040c;
    }

    /* renamed from: e */
    public String mo38287e() {
        return this.f27038a;
    }

    /* renamed from: f */
    public long[] mo38288f() {
        return this.f27043f;
    }

    /* renamed from: g */
    public C7998s mo38289g() {
        return this.f27044g;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Type{name='");
        sb.append(this.f27038a);
        sb.append('\'');
        sb.append(", id=");
        sb.append(this.f27039b);
        sb.append(", locale=");
        sb.append(this.f27040c);
        sb.append('}');
        return sb.toString();
    }
}
