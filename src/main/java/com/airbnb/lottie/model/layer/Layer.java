package com.airbnb.lottie.model.layer;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.p015a.AnimatableFloatValue;
import com.airbnb.lottie.model.p015a.AnimatableTextFrame;
import com.airbnb.lottie.model.p015a.AnimatableTextProperties;
import com.airbnb.lottie.model.p015a.AnimatableTransform;
import com.airbnb.lottie.p014e.Keyframe;
import java.util.List;
import java.util.Locale;

public class Layer {
    /* renamed from: a */
    private final List<ContentModel> f1690a;
    /* renamed from: b */
    private final LottieComposition f1691b;
    /* renamed from: c */
    private final String f1692c;
    /* renamed from: d */
    private final long f1693d;
    /* renamed from: e */
    private final LayerType f1694e;
    /* renamed from: f */
    private final long f1695f;
    /* renamed from: g */
    private final String f1696g;
    /* renamed from: h */
    private final List<Mask> f1697h;
    /* renamed from: i */
    private final AnimatableTransform f1698i;
    /* renamed from: j */
    private final int f1699j;
    /* renamed from: k */
    private final int f1700k;
    /* renamed from: l */
    private final int f1701l;
    /* renamed from: m */
    private final float f1702m;
    /* renamed from: n */
    private final float f1703n;
    /* renamed from: o */
    private final int f1704o;
    /* renamed from: p */
    private final int f1705p;
    /* renamed from: q */
    private final AnimatableTextFrame f1706q;
    /* renamed from: r */
    private final AnimatableTextProperties f1707r;
    /* renamed from: s */
    private final AnimatableFloatValue f1708s;
    /* renamed from: t */
    private final List<Keyframe<Float>> f1709t;
    /* renamed from: u */
    private final MatteType f1710u;

    /* renamed from: com.airbnb.lottie.model.layer.Layer$LayerType */
    public enum LayerType {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    /* renamed from: com.airbnb.lottie.model.layer.Layer$MatteType */
    public enum MatteType {
        None,
        Add,
        Invert,
        Unknown
    }

    public Layer(List<ContentModel> list, LottieComposition dVar, String str, long j, LayerType layerType, long j2, String str2, List<Mask> list2, AnimatableTransform lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, AnimatableTextFrame jVar, AnimatableTextProperties kVar, List<Keyframe<Float>> list3, MatteType matteType, AnimatableFloatValue bVar) {
        this.f1690a = list;
        this.f1691b = dVar;
        this.f1692c = str;
        this.f1693d = j;
        this.f1694e = layerType;
        this.f1695f = j2;
        this.f1696g = str2;
        this.f1697h = list2;
        this.f1698i = lVar;
        this.f1699j = i;
        this.f1700k = i2;
        this.f1701l = i3;
        this.f1702m = f;
        this.f1703n = f2;
        this.f1704o = i4;
        this.f1705p = i5;
        this.f1706q = jVar;
        this.f1707r = kVar;
        this.f1709t = list3;
        this.f1710u = matteType;
        this.f1708s = bVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public LottieComposition mo10136a() {
        return this.f1691b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public float mo10138b() {
        return this.f1702m;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public float mo10139c() {
        return this.f1703n / this.f1691b.mo9928k();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public List<Keyframe<Float>> mo10140d() {
        return this.f1709t;
    }

    /* renamed from: e */
    public long mo10141e() {
        return this.f1693d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public String mo10142f() {
        return this.f1692c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public String mo10143g() {
        return this.f1696g;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public int mo10144h() {
        return this.f1704o;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public int mo10145i() {
        return this.f1705p;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public List<Mask> mo10146j() {
        return this.f1697h;
    }

    /* renamed from: k */
    public LayerType mo10147k() {
        return this.f1694e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public MatteType mo10148l() {
        return this.f1710u;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public long mo10149m() {
        return this.f1695f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public List<ContentModel> mo10150n() {
        return this.f1690a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public AnimatableTransform mo10151o() {
        return this.f1698i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: p */
    public int mo10152p() {
        return this.f1701l;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public int mo10153q() {
        return this.f1700k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public int mo10154r() {
        return this.f1699j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: s */
    public AnimatableTextFrame mo10155s() {
        return this.f1706q;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: t */
    public AnimatableTextProperties mo10156t() {
        return this.f1707r;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: u */
    public AnimatableFloatValue mo10158u() {
        return this.f1708s;
    }

    public String toString() {
        return mo10137a("");
    }

    /* renamed from: a */
    public String mo10137a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(mo10142f());
        String str2 = "\n";
        sb.append(str2);
        Layer a = this.f1691b.mo9914a(mo10149m());
        if (a != null) {
            sb.append("\t\tParents: ");
            sb.append(a.mo10142f());
            Layer a2 = this.f1691b.mo9914a(a.mo10149m());
            while (a2 != null) {
                sb.append("->");
                sb.append(a2.mo10142f());
                a2 = this.f1691b.mo9914a(a2.mo10149m());
            }
            sb.append(str);
            sb.append(str2);
        }
        if (!mo10146j().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(mo10146j().size());
            sb.append(str2);
        }
        if (!(mo10154r() == 0 || mo10153q() == 0)) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", new Object[]{Integer.valueOf(mo10154r()), Integer.valueOf(mo10153q()), Integer.valueOf(mo10152p())}));
        }
        if (!this.f1690a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (Object next : this.f1690a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(next);
                sb.append(str2);
            }
        }
        return sb.toString();
    }
}
