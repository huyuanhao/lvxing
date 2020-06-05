package com.ksad.lottie.model.content;

import com.ksad.lottie.C3721f;
import com.ksad.lottie.model.layer.C3774a;
import com.ksad.lottie.p298a.p299a.C3627b;
import com.ksad.lottie.p298a.p299a.C3628c;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.ksad.lottie.model.content.j */
public class C3769j implements C3761b {
    /* renamed from: a */
    private final String f12812a;
    /* renamed from: b */
    private final List<C3761b> f12813b;

    public C3769j(String str, List<C3761b> list) {
        this.f12812a = str;
        this.f12813b = list;
    }

    /* renamed from: a */
    public C3627b mo23039a(C3721f fVar, C3774a aVar) {
        return new C3628c(fVar, aVar, this);
    }

    /* renamed from: a */
    public String mo23130a() {
        return this.f12812a;
    }

    /* renamed from: b */
    public List<C3761b> mo23131b() {
        return this.f12813b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShapeGroup{name='");
        sb.append(this.f12812a);
        sb.append("' Shapes: ");
        sb.append(Arrays.toString(this.f12813b.toArray()));
        sb.append('}');
        return sb.toString();
    }
}
