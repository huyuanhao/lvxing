package com.airbnb.lottie.p008a.p009a;

import android.graphics.Path;
import android.graphics.Path.FillType;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation.C0925a;
import com.airbnb.lottie.p013d.Utils;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.a.p */
public class ShapeContent implements PathContent, C0925a {
    /* renamed from: a */
    private final Path f1380a = new Path();
    /* renamed from: b */
    private final String f1381b;
    /* renamed from: c */
    private final LottieDrawable f1382c;
    /* renamed from: d */
    private final BaseKeyframeAnimation<?, Path> f1383d;
    /* renamed from: e */
    private boolean f1384e;
    /* renamed from: f */
    private TrimPathContent f1385f;

    public ShapeContent(LottieDrawable lottieDrawable, BaseLayer aVar, ShapePath kVar) {
        this.f1381b = kVar.mo10114a();
        this.f1382c = lottieDrawable;
        this.f1383d = kVar.mo10115b().mo10017a();
        aVar.mo10160a(this.f1383d);
        this.f1383d.mo9865a((C0925a) this);
    }

    /* renamed from: a */
    public void mo9846a() {
        m1233c();
    }

    /* renamed from: c */
    private void m1233c() {
        this.f1384e = false;
        this.f1382c.invalidateSelf();
    }

    /* renamed from: a */
    public void mo9851a(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content bVar = (Content) list.get(i);
            if (bVar instanceof TrimPathContent) {
                TrimPathContent rVar = (TrimPathContent) bVar;
                if (rVar.mo9858c() == Type.Simultaneously) {
                    this.f1385f = rVar;
                    this.f1385f.mo9857a(this);
                }
            }
        }
    }

    /* renamed from: e */
    public Path mo9855e() {
        if (this.f1384e) {
            return this.f1380a;
        }
        this.f1380a.reset();
        this.f1380a.set((Path) this.f1383d.mo9870e());
        this.f1380a.setFillType(FillType.EVEN_ODD);
        Utils.m1456a(this.f1380a, this.f1385f);
        this.f1384e = true;
        return this.f1380a;
    }

    /* renamed from: b */
    public String mo9852b() {
        return this.f1381b;
    }
}
