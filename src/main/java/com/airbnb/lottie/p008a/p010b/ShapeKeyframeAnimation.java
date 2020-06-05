package com.airbnb.lottie.p008a.p010b;

import android.graphics.Path;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.p013d.MiscUtils;
import com.airbnb.lottie.p014e.Keyframe;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.b.l */
public class ShapeKeyframeAnimation extends BaseKeyframeAnimation<ShapeData, Path> {
    /* renamed from: c */
    private final ShapeData f1412c = new ShapeData();
    /* renamed from: d */
    private final Path f1413d = new Path();

    public ShapeKeyframeAnimation(List<Keyframe<ShapeData>> list) {
        super(list);
    }

    /* renamed from: b */
    public Path mo9862a(Keyframe<ShapeData> aVar, float f) {
        this.f1412c.mo10102a((ShapeData) aVar.f1496a, (ShapeData) aVar.f1497b, f);
        MiscUtils.m1446a(this.f1412c, this.f1413d);
        return this.f1413d;
    }
}
