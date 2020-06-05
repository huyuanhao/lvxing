package com.ksad.lottie.model.content;

import android.graphics.PointF;
import com.ksad.lottie.C3665c;
import com.ksad.lottie.model.C3742a;
import com.ksad.lottie.p303d.C3708e;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.ksad.lottie.model.content.h */
public class C3767h {
    /* renamed from: a */
    private final List<C3742a> f12804a = new ArrayList();
    /* renamed from: b */
    private PointF f12805b;
    /* renamed from: c */
    private boolean f12806c;

    public C3767h() {
    }

    public C3767h(PointF pointF, boolean z, List<C3742a> list) {
        this.f12805b = pointF;
        this.f12806c = z;
        this.f12804a.addAll(list);
    }

    /* renamed from: a */
    private void m15618a(float f, float f2) {
        if (this.f12805b == null) {
            this.f12805b = new PointF();
        }
        this.f12805b.set(f, f2);
    }

    /* renamed from: a */
    public PointF mo23120a() {
        return this.f12805b;
    }

    /* renamed from: a */
    public void mo23121a(C3767h hVar, C3767h hVar2, float f) {
        if (this.f12805b == null) {
            this.f12805b = new PointF();
        }
        boolean z = hVar.mo23122b() || hVar2.mo23122b();
        this.f12806c = z;
        if (hVar.mo23123c().size() != hVar2.mo23123c().size()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Curves must have the same number of control points. Shape 1: ");
            sb.append(hVar.mo23123c().size());
            sb.append("\tShape 2: ");
            sb.append(hVar2.mo23123c().size());
            C3665c.m15251b(sb.toString());
        }
        if (this.f12804a.isEmpty()) {
            int min = Math.min(hVar.mo23123c().size(), hVar2.mo23123c().size());
            for (int i = 0; i < min; i++) {
                this.f12804a.add(new C3742a());
            }
        }
        PointF a = hVar.mo23120a();
        PointF a2 = hVar2.mo23120a();
        m15618a(C3708e.m15377a(a.x, a2.x, f), C3708e.m15377a(a.y, a2.y, f));
        for (int size = this.f12804a.size() - 1; size >= 0; size--) {
            C3742a aVar = (C3742a) hVar.mo23123c().get(size);
            C3742a aVar2 = (C3742a) hVar2.mo23123c().get(size);
            PointF a3 = aVar.mo23030a();
            PointF b = aVar.mo23032b();
            PointF c = aVar.mo23034c();
            PointF a4 = aVar2.mo23030a();
            PointF b2 = aVar2.mo23032b();
            PointF c2 = aVar2.mo23034c();
            ((C3742a) this.f12804a.get(size)).mo23031a(C3708e.m15377a(a3.x, a4.x, f), C3708e.m15377a(a3.y, a4.y, f));
            ((C3742a) this.f12804a.get(size)).mo23033b(C3708e.m15377a(b.x, b2.x, f), C3708e.m15377a(b.y, b2.y, f));
            ((C3742a) this.f12804a.get(size)).mo23035c(C3708e.m15377a(c.x, c2.x, f), C3708e.m15377a(c.y, c2.y, f));
        }
    }

    /* renamed from: b */
    public boolean mo23122b() {
        return this.f12806c;
    }

    /* renamed from: c */
    public List<C3742a> mo23123c() {
        return this.f12804a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShapeData{numCurves=");
        sb.append(this.f12804a.size());
        sb.append("closed=");
        sb.append(this.f12806c);
        sb.append('}');
        return sb.toString();
    }
}
