package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.p015a.AnimatableFloatValue;
import com.airbnb.lottie.p008a.p009a.Content;
import com.airbnb.lottie.p008a.p009a.TrimPathContent;

public class ShapeTrimPath implements ContentModel {
    /* renamed from: a */
    private final String f1625a;
    /* renamed from: b */
    private final Type f1626b;
    /* renamed from: c */
    private final AnimatableFloatValue f1627c;
    /* renamed from: d */
    private final AnimatableFloatValue f1628d;
    /* renamed from: e */
    private final AnimatableFloatValue f1629e;

    /* renamed from: com.airbnb.lottie.model.content.ShapeTrimPath$Type */
    public enum Type {
        Simultaneously,
        Individually;

        public static Type forId(int i) {
            if (i == 1) {
                return Simultaneously;
            }
            if (i == 2) {
                return Individually;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown trim path type ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public ShapeTrimPath(String str, Type type, AnimatableFloatValue bVar, AnimatableFloatValue bVar2, AnimatableFloatValue bVar3) {
        this.f1625a = str;
        this.f1626b = type;
        this.f1627c = bVar;
        this.f1628d = bVar2;
        this.f1629e = bVar3;
    }

    /* renamed from: a */
    public String mo10059a() {
        return this.f1625a;
    }

    /* renamed from: b */
    public Type mo10060b() {
        return this.f1626b;
    }

    /* renamed from: c */
    public AnimatableFloatValue mo10061c() {
        return this.f1628d;
    }

    /* renamed from: d */
    public AnimatableFloatValue mo10062d() {
        return this.f1627c;
    }

    /* renamed from: e */
    public AnimatableFloatValue mo10063e() {
        return this.f1629e;
    }

    /* renamed from: a */
    public Content mo10020a(LottieDrawable lottieDrawable, BaseLayer aVar) {
        return new TrimPathContent(aVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Trim Path: {start: ");
        sb.append(this.f1627c);
        sb.append(", end: ");
        sb.append(this.f1628d);
        sb.append(", offset: ");
        sb.append(this.f1629e);
        sb.append("}");
        return sb.toString();
    }
}
