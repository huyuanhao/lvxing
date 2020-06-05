package com.ksad.lottie.model.content;

import android.graphics.Path.FillType;
import com.ksad.lottie.C3721f;
import com.ksad.lottie.model.layer.C3774a;
import com.ksad.lottie.model.p305a.C3743a;
import com.ksad.lottie.model.p305a.C3746d;
import com.ksad.lottie.p298a.p299a.C3627b;
import com.ksad.lottie.p298a.p299a.C3631f;

/* renamed from: com.ksad.lottie.model.content.i */
public class C3768i implements C3761b {
    /* renamed from: a */
    private final boolean f12807a;
    /* renamed from: b */
    private final FillType f12808b;
    /* renamed from: c */
    private final String f12809c;
    /* renamed from: d */
    private final C3743a f12810d;
    /* renamed from: e */
    private final C3746d f12811e;

    public C3768i(String str, boolean z, FillType fillType, C3743a aVar, C3746d dVar) {
        this.f12809c = str;
        this.f12807a = z;
        this.f12808b = fillType;
        this.f12810d = aVar;
        this.f12811e = dVar;
    }

    /* renamed from: a */
    public C3627b mo23039a(C3721f fVar, C3774a aVar) {
        return new C3631f(fVar, aVar, this);
    }

    /* renamed from: a */
    public String mo23125a() {
        return this.f12809c;
    }

    /* renamed from: b */
    public C3743a mo23126b() {
        return this.f12810d;
    }

    /* renamed from: c */
    public C3746d mo23127c() {
        return this.f12811e;
    }

    /* renamed from: d */
    public FillType mo23128d() {
        return this.f12808b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShapeFill{color=, fillEnabled=");
        sb.append(this.f12807a);
        sb.append('}');
        return sb.toString();
    }
}
