package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.ShapeStroke.LineCapType;
import com.airbnb.lottie.model.content.ShapeStroke.LineJoinType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.p015a.AnimatableFloatValue;
import com.airbnb.lottie.model.p015a.AnimatableGradientColorValue;
import com.airbnb.lottie.model.p015a.AnimatableIntegerValue;
import com.airbnb.lottie.model.p015a.AnimatablePointValue;
import com.airbnb.lottie.p008a.p009a.Content;
import com.airbnb.lottie.p008a.p009a.GradientStrokeContent;
import java.util.List;

/* renamed from: com.airbnb.lottie.model.content.e */
public class GradientStroke implements ContentModel {
    /* renamed from: a */
    private final String f1645a;
    /* renamed from: b */
    private final GradientType f1646b;
    /* renamed from: c */
    private final AnimatableGradientColorValue f1647c;
    /* renamed from: d */
    private final AnimatableIntegerValue f1648d;
    /* renamed from: e */
    private final AnimatablePointValue f1649e;
    /* renamed from: f */
    private final AnimatablePointValue f1650f;
    /* renamed from: g */
    private final AnimatableFloatValue f1651g;
    /* renamed from: h */
    private final LineCapType f1652h;
    /* renamed from: i */
    private final LineJoinType f1653i;
    /* renamed from: j */
    private final float f1654j;
    /* renamed from: k */
    private final List<AnimatableFloatValue> f1655k;
    /* renamed from: l */
    private final AnimatableFloatValue f1656l;

    public GradientStroke(String str, GradientType gradientType, AnimatableGradientColorValue cVar, AnimatableIntegerValue dVar, AnimatablePointValue fVar, AnimatablePointValue fVar2, AnimatableFloatValue bVar, LineCapType lineCapType, LineJoinType lineJoinType, float f, List<AnimatableFloatValue> list, AnimatableFloatValue bVar2) {
        this.f1645a = str;
        this.f1646b = gradientType;
        this.f1647c = cVar;
        this.f1648d = dVar;
        this.f1649e = fVar;
        this.f1650f = fVar2;
        this.f1651g = bVar;
        this.f1652h = lineCapType;
        this.f1653i = lineJoinType;
        this.f1654j = f;
        this.f1655k = list;
        this.f1656l = bVar2;
    }

    /* renamed from: a */
    public String mo10080a() {
        return this.f1645a;
    }

    /* renamed from: b */
    public GradientType mo10081b() {
        return this.f1646b;
    }

    /* renamed from: c */
    public AnimatableGradientColorValue mo10082c() {
        return this.f1647c;
    }

    /* renamed from: d */
    public AnimatableIntegerValue mo10083d() {
        return this.f1648d;
    }

    /* renamed from: e */
    public AnimatablePointValue mo10084e() {
        return this.f1649e;
    }

    /* renamed from: f */
    public AnimatablePointValue mo10085f() {
        return this.f1650f;
    }

    /* renamed from: g */
    public AnimatableFloatValue mo10086g() {
        return this.f1651g;
    }

    /* renamed from: h */
    public LineCapType mo10087h() {
        return this.f1652h;
    }

    /* renamed from: i */
    public LineJoinType mo10088i() {
        return this.f1653i;
    }

    /* renamed from: j */
    public List<AnimatableFloatValue> mo10089j() {
        return this.f1655k;
    }

    /* renamed from: k */
    public AnimatableFloatValue mo10090k() {
        return this.f1656l;
    }

    /* renamed from: l */
    public float mo10091l() {
        return this.f1654j;
    }

    /* renamed from: a */
    public Content mo10020a(LottieDrawable lottieDrawable, BaseLayer aVar) {
        return new GradientStrokeContent(lottieDrawable, aVar, this);
    }
}
