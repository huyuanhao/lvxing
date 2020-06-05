package com.airbnb.lottie.p008a.p010b;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.b.g */
public class MaskKeyframeAnimation {
    /* renamed from: a */
    private final List<BaseKeyframeAnimation<ShapeData, Path>> f1403a;
    /* renamed from: b */
    private final List<BaseKeyframeAnimation<Integer, Integer>> f1404b;
    /* renamed from: c */
    private final List<Mask> f1405c;

    public MaskKeyframeAnimation(List<Mask> list) {
        this.f1405c = list;
        this.f1403a = new ArrayList(list.size());
        this.f1404b = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.f1403a.add(((Mask) list.get(i)).mo10034b().mo10017a());
            this.f1404b.add(((Mask) list.get(i)).mo10035c().mo10017a());
        }
    }

    /* renamed from: a */
    public List<Mask> mo9876a() {
        return this.f1405c;
    }

    /* renamed from: b */
    public List<BaseKeyframeAnimation<ShapeData, Path>> mo9877b() {
        return this.f1403a;
    }

    /* renamed from: c */
    public List<BaseKeyframeAnimation<Integer, Integer>> mo9878c() {
        return this.f1404b;
    }
}
