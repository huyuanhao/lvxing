package com.ksad.lottie.p298a.p299a;

import android.graphics.Path;
import android.graphics.PointF;
import com.ksad.lottie.C3721f;
import com.ksad.lottie.model.content.C3760a;
import com.ksad.lottie.model.content.ShapeTrimPath.Type;
import com.ksad.lottie.model.layer.C3774a;
import com.ksad.lottie.p298a.p300b.C3646a;
import com.ksad.lottie.p298a.p300b.C3646a.C3647a;
import com.ksad.lottie.p303d.C3709f;
import java.util.List;

/* renamed from: com.ksad.lottie.a.a.e */
public class C3630e implements C3635j, C3638l, C3647a {
    /* renamed from: a */
    private final Path f12431a = new Path();
    /* renamed from: b */
    private final String f12432b;
    /* renamed from: c */
    private final C3721f f12433c;
    /* renamed from: d */
    private final C3646a<?, PointF> f12434d;
    /* renamed from: e */
    private final C3646a<?, PointF> f12435e;
    /* renamed from: f */
    private final C3760a f12436f;
    /* renamed from: g */
    private C3645r f12437g;
    /* renamed from: h */
    private boolean f12438h;

    public C3630e(C3721f fVar, C3774a aVar, C3760a aVar2) {
        this.f12432b = aVar2.mo23084a();
        this.f12433c = fVar;
        this.f12434d = aVar2.mo23086c().mo23036a();
        this.f12435e = aVar2.mo23085b().mo23036a();
        this.f12436f = aVar2;
        aVar.mo23169a(this.f12434d);
        aVar.mo23169a(this.f12435e);
        this.f12434d.mo22827a((C3647a) this);
        this.f12435e.mo22827a((C3647a) this);
    }

    /* renamed from: b */
    private void m15138b() {
        this.f12438h = false;
        this.f12433c.invalidateSelf();
    }

    /* renamed from: a */
    public void mo22811a() {
        m15138b();
    }

    /* renamed from: a */
    public void mo22814a(List<C3627b> list, List<C3627b> list2) {
        for (int i = 0; i < list.size(); i++) {
            C3627b bVar = (C3627b) list.get(i);
            if (bVar instanceof C3645r) {
                C3645r rVar = (C3645r) bVar;
                if (rVar.mo22820b() == Type.Simultaneously) {
                    this.f12437g = rVar;
                    this.f12437g.mo22819a(this);
                }
            }
        }
    }

    /* renamed from: d */
    public Path mo22817d() {
        if (this.f12438h) {
            return this.f12431a;
        }
        this.f12431a.reset();
        PointF pointF = (PointF) this.f12434d.mo22831e();
        float f = pointF.x / 2.0f;
        float f2 = pointF.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.f12431a.reset();
        if (this.f12436f.mo23087d()) {
            float f5 = -f2;
            this.f12431a.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.f12431a.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            float f10 = f5;
            this.f12431a.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f11 = f3 + 0.0f;
            this.f12431a.cubicTo(f11, f2, f, f9, f, 0.0f);
            this.f12431a.cubicTo(f, f8, f11, f10, 0.0f, f10);
        } else {
            float f12 = -f2;
            this.f12431a.moveTo(0.0f, f12);
            float f13 = f3 + 0.0f;
            float f14 = 0.0f - f4;
            this.f12431a.cubicTo(f13, f12, f, f14, f, 0.0f);
            float f15 = f4 + 0.0f;
            this.f12431a.cubicTo(f, f15, f13, f2, 0.0f, f2);
            float f16 = 0.0f - f3;
            float f17 = -f;
            this.f12431a.cubicTo(f16, f2, f17, f15, f17, 0.0f);
            float f18 = f12;
            this.f12431a.cubicTo(f17, f14, f16, f18, 0.0f, f18);
        }
        PointF pointF2 = (PointF) this.f12435e.mo22831e();
        this.f12431a.offset(pointF2.x, pointF2.y);
        this.f12431a.close();
        C3709f.m15392a(this.f12431a, this.f12437g);
        this.f12438h = true;
        return this.f12431a;
    }
}
