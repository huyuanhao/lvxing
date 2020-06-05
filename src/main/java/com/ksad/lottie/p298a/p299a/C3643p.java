package com.ksad.lottie.p298a.p299a;

import android.graphics.Path;
import android.graphics.Path.FillType;
import com.ksad.lottie.C3721f;
import com.ksad.lottie.model.content.C3770k;
import com.ksad.lottie.model.content.ShapeTrimPath.Type;
import com.ksad.lottie.model.layer.C3774a;
import com.ksad.lottie.p298a.p300b.C3646a;
import com.ksad.lottie.p298a.p300b.C3646a.C3647a;
import com.ksad.lottie.p303d.C3709f;
import java.util.List;

/* renamed from: com.ksad.lottie.a.a.p */
public class C3643p implements C3638l, C3647a {
    /* renamed from: a */
    private final Path f12513a = new Path();
    /* renamed from: b */
    private final String f12514b;
    /* renamed from: c */
    private final C3721f f12515c;
    /* renamed from: d */
    private final C3646a<?, Path> f12516d;
    /* renamed from: e */
    private boolean f12517e;
    /* renamed from: f */
    private C3645r f12518f;

    public C3643p(C3721f fVar, C3774a aVar, C3770k kVar) {
        this.f12514b = kVar.mo23133a();
        this.f12515c = fVar;
        this.f12516d = kVar.mo23134b().mo23036a();
        aVar.mo23169a(this.f12516d);
        this.f12516d.mo22827a((C3647a) this);
    }

    /* renamed from: b */
    private void m15180b() {
        this.f12517e = false;
        this.f12515c.invalidateSelf();
    }

    /* renamed from: a */
    public void mo22811a() {
        m15180b();
    }

    /* renamed from: a */
    public void mo22814a(List<C3627b> list, List<C3627b> list2) {
        for (int i = 0; i < list.size(); i++) {
            C3627b bVar = (C3627b) list.get(i);
            if (bVar instanceof C3645r) {
                C3645r rVar = (C3645r) bVar;
                if (rVar.mo22820b() == Type.Simultaneously) {
                    this.f12518f = rVar;
                    this.f12518f.mo22819a(this);
                }
            }
        }
    }

    /* renamed from: d */
    public Path mo22817d() {
        if (this.f12517e) {
            return this.f12513a;
        }
        this.f12513a.reset();
        this.f12513a.set((Path) this.f12516d.mo22831e());
        this.f12513a.setFillType(FillType.EVEN_ODD);
        C3709f.m15392a(this.f12513a, this.f12518f);
        this.f12517e = true;
        return this.f12513a;
    }
}
