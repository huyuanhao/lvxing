package com.airbnb.lottie.p008a.p009a;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation.C0925a;
import com.airbnb.lottie.p013d.MiscUtils;
import com.airbnb.lottie.p013d.Utils;
import com.airbnb.lottie.p014e.LottieValueCallback;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.a.e */
public class EllipseContent implements KeyPathElementContent, PathContent, C0925a {
    /* renamed from: a */
    private final Path f1298a = new Path();
    /* renamed from: b */
    private final String f1299b;
    /* renamed from: c */
    private final LottieDrawable f1300c;
    /* renamed from: d */
    private final BaseKeyframeAnimation<?, PointF> f1301d;
    /* renamed from: e */
    private final BaseKeyframeAnimation<?, PointF> f1302e;
    /* renamed from: f */
    private final CircleShape f1303f;
    /* renamed from: g */
    private TrimPathContent f1304g;
    /* renamed from: h */
    private boolean f1305h;

    public EllipseContent(LottieDrawable lottieDrawable, BaseLayer aVar, CircleShape aVar2) {
        this.f1299b = aVar2.mo10065a();
        this.f1300c = lottieDrawable;
        this.f1301d = aVar2.mo10067c().mo10017a();
        this.f1302e = aVar2.mo10066b().mo10017a();
        this.f1303f = aVar2;
        aVar.mo10160a(this.f1301d);
        aVar.mo10160a(this.f1302e);
        this.f1301d.mo9865a((C0925a) this);
        this.f1302e.mo9865a((C0925a) this);
    }

    /* renamed from: a */
    public void mo9846a() {
        m1171c();
    }

    /* renamed from: c */
    private void m1171c() {
        this.f1305h = false;
        this.f1300c.invalidateSelf();
    }

    /* renamed from: a */
    public void mo9851a(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content bVar = (Content) list.get(i);
            if (bVar instanceof TrimPathContent) {
                TrimPathContent rVar = (TrimPathContent) bVar;
                if (rVar.mo9858c() == Type.Simultaneously) {
                    this.f1304g = rVar;
                    this.f1304g.mo9857a(this);
                }
            }
        }
    }

    /* renamed from: b */
    public String mo9852b() {
        return this.f1299b;
    }

    /* renamed from: e */
    public Path mo9855e() {
        if (this.f1305h) {
            return this.f1298a;
        }
        this.f1298a.reset();
        PointF pointF = (PointF) this.f1301d.mo9870e();
        float f = pointF.x / 2.0f;
        float f2 = pointF.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.f1298a.reset();
        if (this.f1303f.mo10068d()) {
            float f5 = -f2;
            this.f1298a.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.f1298a.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            float f10 = f5;
            this.f1298a.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f11 = f3 + 0.0f;
            this.f1298a.cubicTo(f11, f2, f, f9, f, 0.0f);
            this.f1298a.cubicTo(f, f8, f11, f10, 0.0f, f10);
        } else {
            float f12 = -f2;
            this.f1298a.moveTo(0.0f, f12);
            float f13 = f3 + 0.0f;
            float f14 = 0.0f - f4;
            this.f1298a.cubicTo(f13, f12, f, f14, f, 0.0f);
            float f15 = f4 + 0.0f;
            this.f1298a.cubicTo(f, f15, f13, f2, 0.0f, f2);
            float f16 = 0.0f - f3;
            float f17 = -f;
            this.f1298a.cubicTo(f16, f2, f17, f15, f17, 0.0f);
            float f18 = f12;
            this.f1298a.cubicTo(f17, f14, f16, f18, 0.0f, f18);
        }
        PointF pointF2 = (PointF) this.f1302e.mo9870e();
        this.f1298a.offset(pointF2.x, pointF2.y);
        this.f1298a.close();
        Utils.m1456a(this.f1298a, this.f1304g);
        this.f1305h = true;
        return this.f1298a;
    }

    /* renamed from: a */
    public void mo9849a(KeyPath eVar, int i, List<KeyPath> list, KeyPath eVar2) {
        MiscUtils.m1447a(eVar, i, list, eVar2, this);
    }

    /* renamed from: a */
    public <T> void mo9850a(T t, LottieValueCallback<T> cVar) {
        if (t == LottieProperty.f1530g) {
            this.f1301d.mo9866a(cVar);
        } else if (t == LottieProperty.f1531h) {
            this.f1302e.mo9866a(cVar);
        }
    }
}
