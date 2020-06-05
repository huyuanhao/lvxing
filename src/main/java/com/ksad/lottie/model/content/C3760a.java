package com.ksad.lottie.model.content;

import android.graphics.PointF;
import com.ksad.lottie.C3721f;
import com.ksad.lottie.model.layer.C3774a;
import com.ksad.lottie.model.p305a.C3748f;
import com.ksad.lottie.model.p305a.C3755m;
import com.ksad.lottie.p298a.p299a.C3627b;
import com.ksad.lottie.p298a.p299a.C3630e;

/* renamed from: com.ksad.lottie.model.content.a */
public class C3760a implements C3761b {
    /* renamed from: a */
    private final String f12769a;
    /* renamed from: b */
    private final C3755m<PointF, PointF> f12770b;
    /* renamed from: c */
    private final C3748f f12771c;
    /* renamed from: d */
    private final boolean f12772d;

    public C3760a(String str, C3755m<PointF, PointF> mVar, C3748f fVar, boolean z) {
        this.f12769a = str;
        this.f12770b = mVar;
        this.f12771c = fVar;
        this.f12772d = z;
    }

    /* renamed from: a */
    public C3627b mo23039a(C3721f fVar, C3774a aVar) {
        return new C3630e(fVar, aVar, this);
    }

    /* renamed from: a */
    public String mo23084a() {
        return this.f12769a;
    }

    /* renamed from: b */
    public C3755m<PointF, PointF> mo23085b() {
        return this.f12770b;
    }

    /* renamed from: c */
    public C3748f mo23086c() {
        return this.f12771c;
    }

    /* renamed from: d */
    public boolean mo23087d() {
        return this.f12772d;
    }
}
