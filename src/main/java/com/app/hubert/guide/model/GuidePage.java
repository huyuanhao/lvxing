package com.app.hubert.guide.model;

import android.view.View;
import android.view.animation.Animation;
import com.app.hubert.guide.model.HighLight.Shape;
import com.app.hubert.guide.p127a.OnLayoutInflatedListener;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.app.hubert.guide.model.a */
public class GuidePage {
    /* renamed from: a */
    private List<HighLight> f4067a = new ArrayList();
    /* renamed from: b */
    private boolean f4068b = true;
    /* renamed from: c */
    private int f4069c;
    /* renamed from: d */
    private int f4070d;
    /* renamed from: e */
    private int[] f4071e;
    /* renamed from: f */
    private OnLayoutInflatedListener f4072f;
    /* renamed from: g */
    private Animation f4073g;
    /* renamed from: h */
    private Animation f4074h;

    /* renamed from: a */
    public static GuidePage m4830a() {
        return new GuidePage();
    }

    /* renamed from: a */
    public GuidePage mo12323a(View view, HighlightOptions bVar) {
        return mo12322a(view, Shape.RECTANGLE, 0, 0, bVar);
    }

    /* renamed from: a */
    public GuidePage mo12322a(View view, Shape shape, int i, int i2, HighlightOptions bVar) {
        HighlightView cVar = new HighlightView(view, shape, i, i2);
        if (!(bVar == null || bVar.f4076b == null)) {
            bVar.f4076b.f4085a = cVar;
        }
        cVar.mo12336a(bVar);
        this.f4067a.add(cVar);
        return this;
    }

    /* renamed from: a */
    public GuidePage mo12321a(int i, int... iArr) {
        this.f4070d = i;
        this.f4071e = iArr;
        return this;
    }

    /* renamed from: a */
    public GuidePage mo12324a(OnLayoutInflatedListener dVar) {
        this.f4072f = dVar;
        return this;
    }

    /* renamed from: b */
    public boolean mo12325b() {
        return this.f4068b;
    }

    /* renamed from: c */
    public List<HighLight> mo12326c() {
        return this.f4067a;
    }

    /* renamed from: d */
    public int mo12327d() {
        return this.f4069c;
    }

    /* renamed from: e */
    public int mo12328e() {
        return this.f4070d;
    }

    /* renamed from: f */
    public int[] mo12329f() {
        return this.f4071e;
    }

    /* renamed from: g */
    public OnLayoutInflatedListener mo12330g() {
        return this.f4072f;
    }

    /* renamed from: h */
    public Animation mo12331h() {
        return this.f4073g;
    }

    /* renamed from: i */
    public Animation mo12332i() {
        return this.f4074h;
    }

    /* renamed from: j */
    public List<RelativeGuide> mo12333j() {
        ArrayList arrayList = new ArrayList();
        for (HighLight d : this.f4067a) {
            HighlightOptions d2 = d.mo12320d();
            if (!(d2 == null || d2.f4076b == null)) {
                arrayList.add(d2.f4076b);
            }
        }
        return arrayList;
    }
}
