package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.p015a.AnimatableShapeValue;
import com.airbnb.lottie.p008a.p009a.Content;
import com.airbnb.lottie.p008a.p009a.ShapeContent;

/* renamed from: com.airbnb.lottie.model.content.k */
public class ShapePath implements ContentModel {
    /* renamed from: a */
    private final String f1675a;
    /* renamed from: b */
    private final int f1676b;
    /* renamed from: c */
    private final AnimatableShapeValue f1677c;

    public ShapePath(String str, int i, AnimatableShapeValue hVar) {
        this.f1675a = str;
        this.f1676b = i;
        this.f1677c = hVar;
    }

    /* renamed from: a */
    public String mo10114a() {
        return this.f1675a;
    }

    /* renamed from: b */
    public AnimatableShapeValue mo10115b() {
        return this.f1677c;
    }

    /* renamed from: a */
    public Content mo10020a(LottieDrawable lottieDrawable, BaseLayer aVar) {
        return new ShapeContent(lottieDrawable, aVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShapePath{name=");
        sb.append(this.f1675a);
        sb.append(", index=");
        sb.append(this.f1676b);
        sb.append('}');
        return sb.toString();
    }
}
