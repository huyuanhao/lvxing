package com.airbnb.lottie.p008a.p009a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation.C0925a;
import com.airbnb.lottie.p013d.MiscUtils;
import com.airbnb.lottie.p013d.Utils;
import com.airbnb.lottie.p014e.LottieValueCallback;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.a.n */
public class RectangleContent implements KeyPathElementContent, PathContent, C0925a {
    /* renamed from: a */
    private final Path f1362a = new Path();
    /* renamed from: b */
    private final RectF f1363b = new RectF();
    /* renamed from: c */
    private final String f1364c;
    /* renamed from: d */
    private final LottieDrawable f1365d;
    /* renamed from: e */
    private final BaseKeyframeAnimation<?, PointF> f1366e;
    /* renamed from: f */
    private final BaseKeyframeAnimation<?, PointF> f1367f;
    /* renamed from: g */
    private final BaseKeyframeAnimation<?, Float> f1368g;
    /* renamed from: h */
    private TrimPathContent f1369h;
    /* renamed from: i */
    private boolean f1370i;

    /* renamed from: a */
    public <T> void mo9850a(T t, LottieValueCallback<T> cVar) {
    }

    public RectangleContent(LottieDrawable lottieDrawable, BaseLayer aVar, RectangleShape fVar) {
        this.f1364c = fVar.mo10092a();
        this.f1365d = lottieDrawable;
        this.f1366e = fVar.mo10095d().mo10017a();
        this.f1367f = fVar.mo10094c().mo10017a();
        this.f1368g = fVar.mo10093b().mo10017a();
        aVar.mo10160a(this.f1366e);
        aVar.mo10160a(this.f1367f);
        aVar.mo10160a(this.f1368g);
        this.f1366e.mo9865a((C0925a) this);
        this.f1367f.mo9865a((C0925a) this);
        this.f1368g.mo9865a((C0925a) this);
    }

    /* renamed from: b */
    public String mo9852b() {
        return this.f1364c;
    }

    /* renamed from: a */
    public void mo9846a() {
        m1217c();
    }

    /* renamed from: c */
    private void m1217c() {
        this.f1370i = false;
        this.f1365d.invalidateSelf();
    }

    /* renamed from: a */
    public void mo9851a(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content bVar = (Content) list.get(i);
            if (bVar instanceof TrimPathContent) {
                TrimPathContent rVar = (TrimPathContent) bVar;
                if (rVar.mo9858c() == Type.Simultaneously) {
                    this.f1369h = rVar;
                    this.f1369h.mo9857a(this);
                }
            }
        }
    }

    /* renamed from: e */
    public Path mo9855e() {
        if (this.f1370i) {
            return this.f1362a;
        }
        this.f1362a.reset();
        PointF pointF = (PointF) this.f1367f.mo9870e();
        float f = pointF.x / 2.0f;
        float f2 = pointF.y / 2.0f;
        BaseKeyframeAnimation<?, Float> aVar = this.f1368g;
        float floatValue = aVar == null ? 0.0f : ((Float) aVar.mo9870e()).floatValue();
        float min = Math.min(f, f2);
        if (floatValue > min) {
            floatValue = min;
        }
        PointF pointF2 = (PointF) this.f1366e.mo9870e();
        this.f1362a.moveTo(pointF2.x + f, (pointF2.y - f2) + floatValue);
        this.f1362a.lineTo(pointF2.x + f, (pointF2.y + f2) - floatValue);
        int i = (floatValue > 0.0f ? 1 : (floatValue == 0.0f ? 0 : -1));
        if (i > 0) {
            float f3 = floatValue * 2.0f;
            this.f1363b.set((pointF2.x + f) - f3, (pointF2.y + f2) - f3, pointF2.x + f, pointF2.y + f2);
            this.f1362a.arcTo(this.f1363b, 0.0f, 90.0f, false);
        }
        this.f1362a.lineTo((pointF2.x - f) + floatValue, pointF2.y + f2);
        if (i > 0) {
            float f4 = floatValue * 2.0f;
            this.f1363b.set(pointF2.x - f, (pointF2.y + f2) - f4, (pointF2.x - f) + f4, pointF2.y + f2);
            this.f1362a.arcTo(this.f1363b, 90.0f, 90.0f, false);
        }
        this.f1362a.lineTo(pointF2.x - f, (pointF2.y - f2) + floatValue);
        if (i > 0) {
            float f5 = floatValue * 2.0f;
            this.f1363b.set(pointF2.x - f, pointF2.y - f2, (pointF2.x - f) + f5, (pointF2.y - f2) + f5);
            this.f1362a.arcTo(this.f1363b, 180.0f, 90.0f, false);
        }
        this.f1362a.lineTo((pointF2.x + f) - floatValue, pointF2.y - f2);
        if (i > 0) {
            float f6 = floatValue * 2.0f;
            this.f1363b.set((pointF2.x + f) - f6, pointF2.y - f2, pointF2.x + f, (pointF2.y - f2) + f6);
            this.f1362a.arcTo(this.f1363b, 270.0f, 90.0f, false);
        }
        this.f1362a.close();
        Utils.m1456a(this.f1362a, this.f1369h);
        this.f1370i = true;
        return this.f1362a;
    }

    /* renamed from: a */
    public void mo9849a(KeyPath eVar, int i, List<KeyPath> list, KeyPath eVar2) {
        MiscUtils.m1447a(eVar, i, list, eVar2, this);
    }
}
