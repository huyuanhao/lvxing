package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.p015a.AnimatableFloatValue;
import com.airbnb.lottie.model.p015a.AnimatableTransform;
import com.airbnb.lottie.p008a.p009a.Content;
import com.airbnb.lottie.p008a.p009a.RepeaterContent;

/* renamed from: com.airbnb.lottie.model.content.g */
public class Repeater implements ContentModel {
    /* renamed from: a */
    private final String f1661a;
    /* renamed from: b */
    private final AnimatableFloatValue f1662b;
    /* renamed from: c */
    private final AnimatableFloatValue f1663c;
    /* renamed from: d */
    private final AnimatableTransform f1664d;

    public Repeater(String str, AnimatableFloatValue bVar, AnimatableFloatValue bVar2, AnimatableTransform lVar) {
        this.f1661a = str;
        this.f1662b = bVar;
        this.f1663c = bVar2;
        this.f1664d = lVar;
    }

    /* renamed from: a */
    public String mo10097a() {
        return this.f1661a;
    }

    /* renamed from: b */
    public AnimatableFloatValue mo10098b() {
        return this.f1662b;
    }

    /* renamed from: c */
    public AnimatableFloatValue mo10099c() {
        return this.f1663c;
    }

    /* renamed from: d */
    public AnimatableTransform mo10100d() {
        return this.f1664d;
    }

    /* renamed from: a */
    public Content mo10020a(LottieDrawable lottieDrawable, BaseLayer aVar) {
        return new RepeaterContent(lottieDrawable, aVar, this);
    }
}
