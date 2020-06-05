package com.ksad.lottie.model.content;

import com.ksad.lottie.C3721f;
import com.ksad.lottie.model.content.ShapeStroke.LineCapType;
import com.ksad.lottie.model.content.ShapeStroke.LineJoinType;
import com.ksad.lottie.model.layer.C3774a;
import com.ksad.lottie.model.p305a.C3744b;
import com.ksad.lottie.model.p305a.C3745c;
import com.ksad.lottie.model.p305a.C3746d;
import com.ksad.lottie.model.p305a.C3748f;
import com.ksad.lottie.p298a.p299a.C3627b;
import com.ksad.lottie.p298a.p299a.C3633h;
import java.util.List;

/* renamed from: com.ksad.lottie.model.content.e */
public class C3764e implements C3761b {
    /* renamed from: a */
    private final String f12784a;
    /* renamed from: b */
    private final GradientType f12785b;
    /* renamed from: c */
    private final C3745c f12786c;
    /* renamed from: d */
    private final C3746d f12787d;
    /* renamed from: e */
    private final C3748f f12788e;
    /* renamed from: f */
    private final C3748f f12789f;
    /* renamed from: g */
    private final C3744b f12790g;
    /* renamed from: h */
    private final LineCapType f12791h;
    /* renamed from: i */
    private final LineJoinType f12792i;
    /* renamed from: j */
    private final float f12793j;
    /* renamed from: k */
    private final List<C3744b> f12794k;
    /* renamed from: l */
    private final C3744b f12795l;

    public C3764e(String str, GradientType gradientType, C3745c cVar, C3746d dVar, C3748f fVar, C3748f fVar2, C3744b bVar, LineCapType lineCapType, LineJoinType lineJoinType, float f, List<C3744b> list, C3744b bVar2) {
        this.f12784a = str;
        this.f12785b = gradientType;
        this.f12786c = cVar;
        this.f12787d = dVar;
        this.f12788e = fVar;
        this.f12789f = fVar2;
        this.f12790g = bVar;
        this.f12791h = lineCapType;
        this.f12792i = lineJoinType;
        this.f12793j = f;
        this.f12794k = list;
        this.f12795l = bVar2;
    }

    /* renamed from: a */
    public C3627b mo23039a(C3721f fVar, C3774a aVar) {
        return new C3633h(fVar, aVar, this);
    }

    /* renamed from: a */
    public String mo23099a() {
        return this.f12784a;
    }

    /* renamed from: b */
    public GradientType mo23100b() {
        return this.f12785b;
    }

    /* renamed from: c */
    public C3745c mo23101c() {
        return this.f12786c;
    }

    /* renamed from: d */
    public C3746d mo23102d() {
        return this.f12787d;
    }

    /* renamed from: e */
    public C3748f mo23103e() {
        return this.f12788e;
    }

    /* renamed from: f */
    public C3748f mo23104f() {
        return this.f12789f;
    }

    /* renamed from: g */
    public C3744b mo23105g() {
        return this.f12790g;
    }

    /* renamed from: h */
    public LineCapType mo23106h() {
        return this.f12791h;
    }

    /* renamed from: i */
    public LineJoinType mo23107i() {
        return this.f12792i;
    }

    /* renamed from: j */
    public List<C3744b> mo23108j() {
        return this.f12794k;
    }

    /* renamed from: k */
    public C3744b mo23109k() {
        return this.f12795l;
    }

    /* renamed from: l */
    public float mo23110l() {
        return this.f12793j;
    }
}
