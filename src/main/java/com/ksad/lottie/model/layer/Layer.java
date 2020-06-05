package com.ksad.lottie.model.layer;

import com.ksad.lottie.C3703d;
import com.ksad.lottie.model.content.C3761b;
import com.ksad.lottie.model.content.Mask;
import com.ksad.lottie.model.p305a.C3744b;
import com.ksad.lottie.model.p305a.C3752j;
import com.ksad.lottie.model.p305a.C3753k;
import com.ksad.lottie.model.p305a.C3754l;
import com.ksad.lottie.p304e.C3717a;
import java.util.List;
import java.util.Locale;

public class Layer {
    /* renamed from: a */
    private final List<C3761b> f12827a;
    /* renamed from: b */
    private final C3703d f12828b;
    /* renamed from: c */
    private final String f12829c;
    /* renamed from: d */
    private final long f12830d;
    /* renamed from: e */
    private final LayerType f12831e;
    /* renamed from: f */
    private final long f12832f;
    /* renamed from: g */
    private final String f12833g;
    /* renamed from: h */
    private final List<Mask> f12834h;
    /* renamed from: i */
    private final C3754l f12835i;
    /* renamed from: j */
    private final int f12836j;
    /* renamed from: k */
    private final int f12837k;
    /* renamed from: l */
    private final int f12838l;
    /* renamed from: m */
    private final float f12839m;
    /* renamed from: n */
    private final float f12840n;
    /* renamed from: o */
    private final int f12841o;
    /* renamed from: p */
    private final int f12842p;
    /* renamed from: q */
    private final C3752j f12843q;
    /* renamed from: r */
    private final C3753k f12844r;
    /* renamed from: s */
    private final C3744b f12845s;
    /* renamed from: t */
    private final List<C3717a<Float>> f12846t;
    /* renamed from: u */
    private final MatteType f12847u;

    /* renamed from: com.ksad.lottie.model.layer.Layer$LayerType */
    public enum LayerType {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    /* renamed from: com.ksad.lottie.model.layer.Layer$MatteType */
    public enum MatteType {
        None,
        Add,
        Invert,
        Unknown
    }

    public Layer(List<C3761b> list, C3703d dVar, String str, long j, LayerType layerType, long j2, String str2, List<Mask> list2, C3754l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, C3752j jVar, C3753k kVar, List<C3717a<Float>> list3, MatteType matteType, C3744b bVar) {
        this.f12827a = list;
        this.f12828b = dVar;
        this.f12829c = str;
        this.f12830d = j;
        this.f12831e = layerType;
        this.f12832f = j2;
        this.f12833g = str2;
        this.f12834h = list2;
        this.f12835i = lVar;
        this.f12836j = i;
        this.f12837k = i2;
        this.f12838l = i3;
        this.f12839m = f;
        this.f12840n = f2;
        this.f12841o = i4;
        this.f12842p = i5;
        this.f12843q = jVar;
        this.f12844r = kVar;
        this.f12846t = list3;
        this.f12847u = matteType;
        this.f12845s = bVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C3703d mo23145a() {
        return this.f12828b;
    }

    /* renamed from: a */
    public String mo23146a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(mo23151f());
        String str2 = "\n";
        sb.append(str2);
        Layer a = this.f12828b.mo22874a(mo23158m());
        if (a != null) {
            String str3 = "\t\tParents: ";
            while (true) {
                sb.append(str3);
                sb.append(a.mo23151f());
                a = this.f12828b.mo22874a(a.mo23158m());
                if (a == null) {
                    break;
                }
                str3 = "->";
            }
            sb.append(str);
            sb.append(str2);
        }
        if (!mo23155j().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(mo23155j().size());
            sb.append(str2);
        }
        if (!(mo23163r() == 0 || mo23162q() == 0)) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", new Object[]{Integer.valueOf(mo23163r()), Integer.valueOf(mo23162q()), Integer.valueOf(mo23161p())}));
        }
        if (!this.f12827a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (Object next : this.f12827a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(next);
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public float mo23147b() {
        return this.f12839m;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public float mo23148c() {
        return this.f12840n / this.f12828b.mo22888k();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public List<C3717a<Float>> mo23149d() {
        return this.f12846t;
    }

    /* renamed from: e */
    public long mo23150e() {
        return this.f12830d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public String mo23151f() {
        return this.f12829c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public String mo23152g() {
        return this.f12833g;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public int mo23153h() {
        return this.f12841o;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public int mo23154i() {
        return this.f12842p;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public List<Mask> mo23155j() {
        return this.f12834h;
    }

    /* renamed from: k */
    public LayerType mo23156k() {
        return this.f12831e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public MatteType mo23157l() {
        return this.f12847u;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public long mo23158m() {
        return this.f12832f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public List<C3761b> mo23159n() {
        return this.f12827a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public C3754l mo23160o() {
        return this.f12835i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: p */
    public int mo23161p() {
        return this.f12838l;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public int mo23162q() {
        return this.f12837k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public int mo23163r() {
        return this.f12836j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: s */
    public C3752j mo23164s() {
        return this.f12843q;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: t */
    public C3753k mo23165t() {
        return this.f12844r;
    }

    public String toString() {
        return mo23146a("");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: u */
    public C3744b mo23167u() {
        return this.f12845s;
    }
}
