package com.ksad.lottie.model.content;

import android.graphics.PointF;
import com.ksad.lottie.C3721f;
import com.ksad.lottie.model.layer.C3774a;
import com.ksad.lottie.model.p305a.C3744b;
import com.ksad.lottie.model.p305a.C3748f;
import com.ksad.lottie.model.p305a.C3755m;
import com.ksad.lottie.p298a.p299a.C3627b;
import com.ksad.lottie.p298a.p299a.C3641n;

/* renamed from: com.ksad.lottie.model.content.f */
public class C3765f implements C3761b {
    /* renamed from: a */
    private final String f12796a;
    /* renamed from: b */
    private final C3755m<PointF, PointF> f12797b;
    /* renamed from: c */
    private final C3748f f12798c;
    /* renamed from: d */
    private final C3744b f12799d;

    public C3765f(String str, C3755m<PointF, PointF> mVar, C3748f fVar, C3744b bVar) {
        this.f12796a = str;
        this.f12797b = mVar;
        this.f12798c = fVar;
        this.f12799d = bVar;
    }

    /* renamed from: a */
    public C3627b mo23039a(C3721f fVar, C3774a aVar) {
        return new C3641n(fVar, aVar, this);
    }

    /* renamed from: a */
    public String mo23111a() {
        return this.f12796a;
    }

    /* renamed from: b */
    public C3744b mo23112b() {
        return this.f12799d;
    }

    /* renamed from: c */
    public C3748f mo23113c() {
        return this.f12798c;
    }

    /* renamed from: d */
    public C3755m<PointF, PointF> mo23114d() {
        return this.f12797b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RectangleShape{position=");
        sb.append(this.f12797b);
        sb.append(", size=");
        sb.append(this.f12798c);
        sb.append('}');
        return sb.toString();
    }
}
