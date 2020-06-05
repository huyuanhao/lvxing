package com.airbnb.lottie.p008a.p009a;

import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation.C0925a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.a.r */
public class TrimPathContent implements Content, C0925a {
    /* renamed from: a */
    private final String f1390a;
    /* renamed from: b */
    private final List<C0925a> f1391b = new ArrayList();
    /* renamed from: c */
    private final Type f1392c;
    /* renamed from: d */
    private final BaseKeyframeAnimation<?, Float> f1393d;
    /* renamed from: e */
    private final BaseKeyframeAnimation<?, Float> f1394e;
    /* renamed from: f */
    private final BaseKeyframeAnimation<?, Float> f1395f;

    /* renamed from: a */
    public void mo9851a(List<Content> list, List<Content> list2) {
    }

    public TrimPathContent(BaseLayer aVar, ShapeTrimPath shapeTrimPath) {
        this.f1390a = shapeTrimPath.mo10059a();
        this.f1392c = shapeTrimPath.mo10060b();
        this.f1393d = shapeTrimPath.mo10062d().mo10017a();
        this.f1394e = shapeTrimPath.mo10061c().mo10017a();
        this.f1395f = shapeTrimPath.mo10063e().mo10017a();
        aVar.mo10160a(this.f1393d);
        aVar.mo10160a(this.f1394e);
        aVar.mo10160a(this.f1395f);
        this.f1393d.mo9865a((C0925a) this);
        this.f1394e.mo9865a((C0925a) this);
        this.f1395f.mo9865a((C0925a) this);
    }

    /* renamed from: a */
    public void mo9846a() {
        for (int i = 0; i < this.f1391b.size(); i++) {
            ((C0925a) this.f1391b.get(i)).mo9846a();
        }
    }

    /* renamed from: b */
    public String mo9852b() {
        return this.f1390a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo9857a(C0925a aVar) {
        this.f1391b.add(aVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Type mo9858c() {
        return this.f1392c;
    }

    /* renamed from: d */
    public BaseKeyframeAnimation<?, Float> mo9859d() {
        return this.f1393d;
    }

    /* renamed from: e */
    public BaseKeyframeAnimation<?, Float> mo9860e() {
        return this.f1394e;
    }

    /* renamed from: f */
    public BaseKeyframeAnimation<?, Float> mo9861f() {
        return this.f1395f;
    }
}
