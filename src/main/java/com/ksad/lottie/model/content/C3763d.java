package com.ksad.lottie.model.content;

import android.graphics.Path.FillType;
import com.ksad.lottie.C3721f;
import com.ksad.lottie.model.layer.C3774a;
import com.ksad.lottie.model.p305a.C3744b;
import com.ksad.lottie.model.p305a.C3745c;
import com.ksad.lottie.model.p305a.C3746d;
import com.ksad.lottie.model.p305a.C3748f;
import com.ksad.lottie.p298a.p299a.C3627b;
import com.ksad.lottie.p298a.p299a.C3632g;

/* renamed from: com.ksad.lottie.model.content.d */
public class C3763d implements C3761b {
    /* renamed from: a */
    private final GradientType f12775a;
    /* renamed from: b */
    private final FillType f12776b;
    /* renamed from: c */
    private final C3745c f12777c;
    /* renamed from: d */
    private final C3746d f12778d;
    /* renamed from: e */
    private final C3748f f12779e;
    /* renamed from: f */
    private final C3748f f12780f;
    /* renamed from: g */
    private final String f12781g;
    /* renamed from: h */
    private final C3744b f12782h;
    /* renamed from: i */
    private final C3744b f12783i;

    public C3763d(String str, GradientType gradientType, FillType fillType, C3745c cVar, C3746d dVar, C3748f fVar, C3748f fVar2, C3744b bVar, C3744b bVar2) {
        this.f12775a = gradientType;
        this.f12776b = fillType;
        this.f12777c = cVar;
        this.f12778d = dVar;
        this.f12779e = fVar;
        this.f12780f = fVar2;
        this.f12781g = str;
        this.f12782h = bVar;
        this.f12783i = bVar2;
    }

    /* renamed from: a */
    public C3627b mo23039a(C3721f fVar, C3774a aVar) {
        return new C3632g(fVar, aVar, this);
    }

    /* renamed from: a */
    public String mo23092a() {
        return this.f12781g;
    }

    /* renamed from: b */
    public GradientType mo23093b() {
        return this.f12775a;
    }

    /* renamed from: c */
    public FillType mo23094c() {
        return this.f12776b;
    }

    /* renamed from: d */
    public C3745c mo23095d() {
        return this.f12777c;
    }

    /* renamed from: e */
    public C3746d mo23096e() {
        return this.f12778d;
    }

    /* renamed from: f */
    public C3748f mo23097f() {
        return this.f12779e;
    }

    /* renamed from: g */
    public C3748f mo23098g() {
        return this.f12780f;
    }
}
