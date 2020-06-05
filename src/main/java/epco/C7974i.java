package epco;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* renamed from: epco.i */
public class C7974i {
    /* renamed from: a */
    private C7998s f27092a;
    /* renamed from: b */
    private ByteBuffer f27093b;
    /* renamed from: c */
    private C8012z f27094c;
    /* renamed from: d */
    private Set<Locale> f27095d = new HashSet();

    public C7974i(ByteBuffer byteBuffer) {
        this.f27093b = byteBuffer.duplicate();
        this.f27093b.order(ByteOrder.LITTLE_ENDIAN);
    }

    /* renamed from: a */
    private C8001t0<C8010y, C8002u> m34521a(C8002u uVar) {
        C7988o oVar;
        long j;
        C8001t0<C8010y, C8002u> t0Var = new C8001t0<>();
        C8010y yVar = new C8010y(uVar);
        t0Var.mo38437a(yVar);
        long position = (long) this.f27093b.position();
        if (uVar.mo38451j() > 0) {
            this.f27093b.position((int) ((uVar.mo38451j() + position) - ((long) uVar.mo38401d())));
            yVar.mo38518b(C8003u0.m34635a(this.f27093b, (C8000t) m34522d()));
        }
        if (uVar.mo38446f() > 0) {
            this.f27093b.position((int) ((position + uVar.mo38446f()) - ((long) uVar.mo38401d())));
            yVar.mo38512a(C8003u0.m34635a(this.f27093b, (C8000t) m34522d()));
        }
        while (true) {
            if (this.f27093b.hasRemaining()) {
                C7988o d = m34522d();
                int i = 0;
                switch (d.mo38400c()) {
                    case 512:
                        t0Var.mo38439b((C8002u) d);
                        break;
                    case 513:
                        j = (long) this.f27093b.position();
                        C7962d0 d0Var = (C7962d0) d;
                        long[] jArr = new long[((int) d0Var.mo38307g())];
                        while (((long) i) < d0Var.mo38307g()) {
                            jArr[i] = C7997r0.m34601b(this.f27093b);
                            i++;
                        }
                        C7957c0 c0Var = new C7957c0(d0Var);
                        c0Var.mo38278a(yVar.mo38522e().mo38424a(d0Var.mo38308h() - 1));
                        this.f27093b.position((int) ((d0Var.mo38306f() + j) - ((long) d0Var.mo38401d())));
                        ByteBuffer slice = this.f27093b.slice();
                        slice.order(ByteOrder.LITTLE_ENDIAN);
                        c0Var.mo38279a(slice);
                        c0Var.mo38277a(yVar.mo38516b());
                        c0Var.mo38282a(jArr);
                        c0Var.mo38284b(this.f27092a);
                        yVar.mo38510a(c0Var);
                        this.f27095d.add(c0Var.mo38286d());
                        oVar = d0Var;
                        continue;
                    case C7990p.f27150o /*514*/:
                        j = (long) this.f27093b.position();
                        C7968f0 f0Var = (C7968f0) d;
                        long[] jArr2 = new long[((int) f0Var.mo38334e())];
                        while (((long) i) < f0Var.mo38334e()) {
                            jArr2[i] = C7997r0.m34601b(this.f27093b);
                            i++;
                        }
                        C7965e0 e0Var = new C7965e0(f0Var);
                        e0Var.mo38319a(jArr2);
                        e0Var.mo38317a(yVar.mo38522e().mo38424a(f0Var.mo38335f() - 1));
                        yVar.mo38511a(e0Var);
                        oVar = f0Var;
                        continue;
                    default:
                        StringBuilder sb = new StringBuilder();
                        sb.append("unexpected chunk type:");
                        sb.append(d.mo38400c());
                        throw new IOException(sb.toString());
                }
            }
            this.f27093b.position((int) (j + ((long) oVar.mo38395a())));
        }
        return t0Var;
    }

    /* renamed from: d */
    private C7988o m34522d() {
        C7988o oVar;
        long position = (long) this.f27093b.position();
        int c = C7997r0.m34603c(this.f27093b);
        int c2 = C7997r0.m34603c(this.f27093b);
        long b = C7997r0.m34601b(this.f27093b);
        if (c == 1) {
            C8000t tVar = new C8000t(c, c2, b);
            tVar.mo38427c(C7997r0.m34601b(this.f27093b));
            tVar.mo38430e(C7997r0.m34601b(this.f27093b));
            tVar.mo38426b(C7997r0.m34601b(this.f27093b));
            tVar.mo38428d(C7997r0.m34601b(this.f27093b));
            tVar.mo38432f(C7997r0.m34601b(this.f27093b));
            oVar = tVar;
        } else if (c != 2) {
            switch (c) {
                case 512:
                    C8002u uVar = new C8002u(c, c2, b);
                    uVar.mo38441b(C7997r0.m34601b(this.f27093b));
                    uVar.mo38440a(C8003u0.m34642b(this.f27093b, 128));
                    uVar.mo38447f(C7997r0.m34601b(this.f27093b));
                    uVar.mo38445e(C7997r0.m34601b(this.f27093b));
                    uVar.mo38442c(C7997r0.m34601b(this.f27093b));
                    uVar.mo38443d(C7997r0.m34601b(this.f27093b));
                    oVar = uVar;
                    break;
                case 513:
                    C7962d0 d0Var = new C7962d0(c, c2, b);
                    d0Var.mo38300a(C7997r0.m34599a(this.f27093b));
                    d0Var.mo38302b(C7997r0.m34599a(this.f27093b));
                    d0Var.mo38303c(C7997r0.m34603c(this.f27093b));
                    d0Var.mo38304c(C7997r0.m34601b(this.f27093b));
                    d0Var.mo38301b(C7997r0.m34601b(this.f27093b));
                    d0Var.mo38299a(m34523e());
                    oVar = d0Var;
                    break;
                case C7990p.f27150o /*514*/:
                    C7968f0 f0Var = new C7968f0(c, c2, b);
                    f0Var.mo38330a(C7997r0.m34599a(this.f27093b));
                    f0Var.mo38332b(C7997r0.m34599a(this.f27093b));
                    f0Var.mo38333c(C7997r0.m34603c(this.f27093b));
                    f0Var.mo38331b(C7997r0.m34601b(this.f27093b));
                    oVar = f0Var;
                    break;
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unexpected chunk Type:");
                    sb.append(Integer.toHexString(c));
                    throw new IOException(sb.toString());
            }
        } else {
            C7947a0 a0Var = new C7947a0(c, c2, b);
            a0Var.mo38255b(C7997r0.m34601b(this.f27093b));
            oVar = a0Var;
        }
        this.f27093b.position((int) (position + ((long) c2)));
        return oVar;
    }

    /* renamed from: e */
    private C8004v m34523e() {
        long position = (long) this.f27093b.position();
        C8004v vVar = new C8004v();
        long b = C7997r0.m34601b(this.f27093b);
        C7997r0.m34604c(this.f27093b, 4);
        String str = "";
        String str2 = "\u0000";
        vVar.mo38459b(new String(C7997r0.m34600a(this.f27093b, 2)).replace(str2, str));
        vVar.mo38455a(new String(C7997r0.m34600a(this.f27093b, 2)).replace(str2, str));
        C7997r0.m34604c(this.f27093b, (int) (b - (((long) this.f27093b.position()) - position)));
        return vVar;
    }

    /* renamed from: a */
    public Set<Locale> mo38358a() {
        return this.f27095d;
    }

    /* renamed from: b */
    public C8012z mo38359b() {
        return this.f27094c;
    }

    /* renamed from: c */
    public void mo38360c() {
        C7947a0 a0Var = (C7947a0) m34522d();
        this.f27092a = C8003u0.m34635a(this.f27093b, (C8000t) m34522d());
        this.f27094c = new C8012z();
        this.f27094c.mo38529a(this.f27092a);
        C8002u uVar = (C8002u) m34522d();
        for (int i = 0; ((long) i) < a0Var.mo38256e(); i++) {
            C8001t0 a = m34521a(uVar);
            this.f27094c.mo38530a((C8010y) a.mo38436a());
            uVar = (C8002u) a.mo38438b();
        }
    }
}
