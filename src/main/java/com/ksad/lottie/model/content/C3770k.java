package com.ksad.lottie.model.content;

import com.ksad.lottie.C3721f;
import com.ksad.lottie.model.layer.C3774a;
import com.ksad.lottie.model.p305a.C3750h;
import com.ksad.lottie.p298a.p299a.C3627b;
import com.ksad.lottie.p298a.p299a.C3643p;

/* renamed from: com.ksad.lottie.model.content.k */
public class C3770k implements C3761b {
    /* renamed from: a */
    private final String f12814a;
    /* renamed from: b */
    private final int f12815b;
    /* renamed from: c */
    private final C3750h f12816c;

    public C3770k(String str, int i, C3750h hVar) {
        this.f12814a = str;
        this.f12815b = i;
        this.f12816c = hVar;
    }

    /* renamed from: a */
    public C3627b mo23039a(C3721f fVar, C3774a aVar) {
        return new C3643p(fVar, aVar, this);
    }

    /* renamed from: a */
    public String mo23133a() {
        return this.f12814a;
    }

    /* renamed from: b */
    public C3750h mo23134b() {
        return this.f12816c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShapePath{name=");
        sb.append(this.f12814a);
        sb.append(", index=");
        sb.append(this.f12815b);
        sb.append('}');
        return sb.toString();
    }
}
