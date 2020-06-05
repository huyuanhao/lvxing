package com.airbnb.lottie.model.content;

import android.graphics.Path.FillType;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.p015a.AnimatableColorValue;
import com.airbnb.lottie.model.p015a.AnimatableIntegerValue;
import com.airbnb.lottie.p008a.p009a.Content;
import com.airbnb.lottie.p008a.p009a.FillContent;

/* renamed from: com.airbnb.lottie.model.content.i */
public class ShapeFill implements ContentModel {
    /* renamed from: a */
    private final boolean f1668a;
    /* renamed from: b */
    private final FillType f1669b;
    /* renamed from: c */
    private final String f1670c;
    /* renamed from: d */
    private final AnimatableColorValue f1671d;
    /* renamed from: e */
    private final AnimatableIntegerValue f1672e;

    public ShapeFill(String str, boolean z, FillType fillType, AnimatableColorValue aVar, AnimatableIntegerValue dVar) {
        this.f1670c = str;
        this.f1668a = z;
        this.f1669b = fillType;
        this.f1671d = aVar;
        this.f1672e = dVar;
    }

    /* renamed from: a */
    public String mo10106a() {
        return this.f1670c;
    }

    /* renamed from: b */
    public AnimatableColorValue mo10107b() {
        return this.f1671d;
    }

    /* renamed from: c */
    public AnimatableIntegerValue mo10108c() {
        return this.f1672e;
    }

    /* renamed from: d */
    public FillType mo10109d() {
        return this.f1669b;
    }

    /* renamed from: a */
    public Content mo10020a(LottieDrawable lottieDrawable, BaseLayer aVar) {
        return new FillContent(lottieDrawable, aVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShapeFill{color=, fillEnabled=");
        sb.append(this.f1668a);
        sb.append('}');
        return sb.toString();
    }
}
