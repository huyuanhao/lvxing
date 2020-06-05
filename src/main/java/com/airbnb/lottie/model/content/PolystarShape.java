package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.p015a.AnimatableFloatValue;
import com.airbnb.lottie.model.p015a.AnimatableValue;
import com.airbnb.lottie.p008a.p009a.Content;
import com.airbnb.lottie.p008a.p009a.PolystarContent;

public class PolystarShape implements ContentModel {
    /* renamed from: a */
    private final String f1605a;
    /* renamed from: b */
    private final Type f1606b;
    /* renamed from: c */
    private final AnimatableFloatValue f1607c;
    /* renamed from: d */
    private final AnimatableValue<PointF, PointF> f1608d;
    /* renamed from: e */
    private final AnimatableFloatValue f1609e;
    /* renamed from: f */
    private final AnimatableFloatValue f1610f;
    /* renamed from: g */
    private final AnimatableFloatValue f1611g;
    /* renamed from: h */
    private final AnimatableFloatValue f1612h;
    /* renamed from: i */
    private final AnimatableFloatValue f1613i;

    /* renamed from: com.airbnb.lottie.model.content.PolystarShape$Type */
    public enum Type {
        Star(1),
        Polygon(2);
        
        private final int value;

        private Type(int i) {
            this.value = i;
        }

        public static Type forValue(int i) {
            Type[] values;
            for (Type type : values()) {
                if (type.value == i) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, AnimatableFloatValue bVar, AnimatableValue<PointF, PointF> mVar, AnimatableFloatValue bVar2, AnimatableFloatValue bVar3, AnimatableFloatValue bVar4, AnimatableFloatValue bVar5, AnimatableFloatValue bVar6) {
        this.f1605a = str;
        this.f1606b = type;
        this.f1607c = bVar;
        this.f1608d = mVar;
        this.f1609e = bVar2;
        this.f1610f = bVar3;
        this.f1611g = bVar4;
        this.f1612h = bVar5;
        this.f1613i = bVar6;
    }

    /* renamed from: a */
    public String mo10039a() {
        return this.f1605a;
    }

    /* renamed from: b */
    public Type mo10040b() {
        return this.f1606b;
    }

    /* renamed from: c */
    public AnimatableFloatValue mo10041c() {
        return this.f1607c;
    }

    /* renamed from: d */
    public AnimatableValue<PointF, PointF> mo10042d() {
        return this.f1608d;
    }

    /* renamed from: e */
    public AnimatableFloatValue mo10043e() {
        return this.f1609e;
    }

    /* renamed from: f */
    public AnimatableFloatValue mo10044f() {
        return this.f1610f;
    }

    /* renamed from: g */
    public AnimatableFloatValue mo10045g() {
        return this.f1611g;
    }

    /* renamed from: h */
    public AnimatableFloatValue mo10046h() {
        return this.f1612h;
    }

    /* renamed from: i */
    public AnimatableFloatValue mo10047i() {
        return this.f1613i;
    }

    /* renamed from: a */
    public Content mo10020a(LottieDrawable lottieDrawable, BaseLayer aVar) {
        return new PolystarContent(lottieDrawable, aVar, this);
    }
}
