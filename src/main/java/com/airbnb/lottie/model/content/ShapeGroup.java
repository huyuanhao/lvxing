package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.p008a.p009a.Content;
import com.airbnb.lottie.p008a.p009a.ContentGroup;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.airbnb.lottie.model.content.j */
public class ShapeGroup implements ContentModel {
    /* renamed from: a */
    private final String f1673a;
    /* renamed from: b */
    private final List<ContentModel> f1674b;

    public ShapeGroup(String str, List<ContentModel> list) {
        this.f1673a = str;
        this.f1674b = list;
    }

    /* renamed from: a */
    public String mo10111a() {
        return this.f1673a;
    }

    /* renamed from: b */
    public List<ContentModel> mo10112b() {
        return this.f1674b;
    }

    /* renamed from: a */
    public Content mo10020a(LottieDrawable lottieDrawable, BaseLayer aVar) {
        return new ContentGroup(lottieDrawable, aVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShapeGroup{name='");
        sb.append(this.f1673a);
        sb.append("' Shapes: ");
        sb.append(Arrays.toString(this.f1674b.toArray()));
        sb.append('}');
        return sb.toString();
    }
}
