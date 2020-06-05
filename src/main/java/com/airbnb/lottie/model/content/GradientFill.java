package com.airbnb.lottie.model.content;

import android.graphics.Path.FillType;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.p015a.AnimatableFloatValue;
import com.airbnb.lottie.model.p015a.AnimatableGradientColorValue;
import com.airbnb.lottie.model.p015a.AnimatableIntegerValue;
import com.airbnb.lottie.model.p015a.AnimatablePointValue;
import com.airbnb.lottie.p008a.p009a.Content;
import com.airbnb.lottie.p008a.p009a.GradientFillContent;

/* renamed from: com.airbnb.lottie.model.content.d */
public class GradientFill implements ContentModel {
    /* renamed from: a */
    private final GradientType f1636a;
    /* renamed from: b */
    private final FillType f1637b;
    /* renamed from: c */
    private final AnimatableGradientColorValue f1638c;
    /* renamed from: d */
    private final AnimatableIntegerValue f1639d;
    /* renamed from: e */
    private final AnimatablePointValue f1640e;
    /* renamed from: f */
    private final AnimatablePointValue f1641f;
    /* renamed from: g */
    private final String f1642g;
    /* renamed from: h */
    private final AnimatableFloatValue f1643h;
    /* renamed from: i */
    private final AnimatableFloatValue f1644i;

    public GradientFill(String str, GradientType gradientType, FillType fillType, AnimatableGradientColorValue cVar, AnimatableIntegerValue dVar, AnimatablePointValue fVar, AnimatablePointValue fVar2, AnimatableFloatValue bVar, AnimatableFloatValue bVar2) {
        this.f1636a = gradientType;
        this.f1637b = fillType;
        this.f1638c = cVar;
        this.f1639d = dVar;
        this.f1640e = fVar;
        this.f1641f = fVar2;
        this.f1642g = str;
        this.f1643h = bVar;
        this.f1644i = bVar2;
    }

    /* renamed from: a */
    public String mo10073a() {
        return this.f1642g;
    }

    /* renamed from: b */
    public GradientType mo10074b() {
        return this.f1636a;
    }

    /* renamed from: c */
    public FillType mo10075c() {
        return this.f1637b;
    }

    /* renamed from: d */
    public AnimatableGradientColorValue mo10076d() {
        return this.f1638c;
    }

    /* renamed from: e */
    public AnimatableIntegerValue mo10077e() {
        return this.f1639d;
    }

    /* renamed from: f */
    public AnimatablePointValue mo10078f() {
        return this.f1640e;
    }

    /* renamed from: g */
    public AnimatablePointValue mo10079g() {
        return this.f1641f;
    }

    /* renamed from: a */
    public Content mo10020a(LottieDrawable lottieDrawable, BaseLayer aVar) {
        return new GradientFillContent(lottieDrawable, aVar, this);
    }
}
