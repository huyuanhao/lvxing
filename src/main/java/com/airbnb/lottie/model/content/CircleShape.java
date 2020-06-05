package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.p015a.AnimatablePointValue;
import com.airbnb.lottie.model.p015a.AnimatableValue;
import com.airbnb.lottie.p008a.p009a.Content;
import com.airbnb.lottie.p008a.p009a.EllipseContent;

/* renamed from: com.airbnb.lottie.model.content.a */
public class CircleShape implements ContentModel {
    /* renamed from: a */
    private final String f1630a;
    /* renamed from: b */
    private final AnimatableValue<PointF, PointF> f1631b;
    /* renamed from: c */
    private final AnimatablePointValue f1632c;
    /* renamed from: d */
    private final boolean f1633d;

    public CircleShape(String str, AnimatableValue<PointF, PointF> mVar, AnimatablePointValue fVar, boolean z) {
        this.f1630a = str;
        this.f1631b = mVar;
        this.f1632c = fVar;
        this.f1633d = z;
    }

    /* renamed from: a */
    public Content mo10020a(LottieDrawable lottieDrawable, BaseLayer aVar) {
        return new EllipseContent(lottieDrawable, aVar, this);
    }

    /* renamed from: a */
    public String mo10065a() {
        return this.f1630a;
    }

    /* renamed from: b */
    public AnimatableValue<PointF, PointF> mo10066b() {
        return this.f1631b;
    }

    /* renamed from: c */
    public AnimatablePointValue mo10067c() {
        return this.f1632c;
    }

    /* renamed from: d */
    public boolean mo10068d() {
        return this.f1633d;
    }
}
