package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.p015a.AnimatableFloatValue;
import com.airbnb.lottie.model.p015a.AnimatablePointValue;
import com.airbnb.lottie.model.p015a.AnimatableValue;
import com.airbnb.lottie.p008a.p009a.Content;
import com.airbnb.lottie.p008a.p009a.RectangleContent;

/* renamed from: com.airbnb.lottie.model.content.f */
public class RectangleShape implements ContentModel {
    /* renamed from: a */
    private final String f1657a;
    /* renamed from: b */
    private final AnimatableValue<PointF, PointF> f1658b;
    /* renamed from: c */
    private final AnimatablePointValue f1659c;
    /* renamed from: d */
    private final AnimatableFloatValue f1660d;

    public RectangleShape(String str, AnimatableValue<PointF, PointF> mVar, AnimatablePointValue fVar, AnimatableFloatValue bVar) {
        this.f1657a = str;
        this.f1658b = mVar;
        this.f1659c = fVar;
        this.f1660d = bVar;
    }

    /* renamed from: a */
    public String mo10092a() {
        return this.f1657a;
    }

    /* renamed from: b */
    public AnimatableFloatValue mo10093b() {
        return this.f1660d;
    }

    /* renamed from: c */
    public AnimatablePointValue mo10094c() {
        return this.f1659c;
    }

    /* renamed from: d */
    public AnimatableValue<PointF, PointF> mo10095d() {
        return this.f1658b;
    }

    /* renamed from: a */
    public Content mo10020a(LottieDrawable lottieDrawable, BaseLayer aVar) {
        return new RectangleContent(lottieDrawable, aVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RectangleShape{position=");
        sb.append(this.f1658b);
        sb.append(", size=");
        sb.append(this.f1659c);
        sb.append('}');
        return sb.toString();
    }
}
