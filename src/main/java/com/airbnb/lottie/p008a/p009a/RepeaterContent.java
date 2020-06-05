package com.airbnb.lottie.p008a.p009a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation.C0925a;
import com.airbnb.lottie.p008a.p010b.TransformKeyframeAnimation;
import com.airbnb.lottie.p013d.MiscUtils;
import com.airbnb.lottie.p014e.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* renamed from: com.airbnb.lottie.a.a.o */
public class RepeaterContent implements DrawingContent, GreedyContent, KeyPathElementContent, PathContent, C0925a {
    /* renamed from: a */
    private final Matrix f1371a = new Matrix();
    /* renamed from: b */
    private final Path f1372b = new Path();
    /* renamed from: c */
    private final LottieDrawable f1373c;
    /* renamed from: d */
    private final BaseLayer f1374d;
    /* renamed from: e */
    private final String f1375e;
    /* renamed from: f */
    private final BaseKeyframeAnimation<Float, Float> f1376f;
    /* renamed from: g */
    private final BaseKeyframeAnimation<Float, Float> f1377g;
    /* renamed from: h */
    private final TransformKeyframeAnimation f1378h;
    /* renamed from: i */
    private ContentGroup f1379i;

    public RepeaterContent(LottieDrawable lottieDrawable, BaseLayer aVar, Repeater gVar) {
        this.f1373c = lottieDrawable;
        this.f1374d = aVar;
        this.f1375e = gVar.mo10097a();
        this.f1376f = gVar.mo10098b().mo10017a();
        aVar.mo10160a(this.f1376f);
        this.f1376f.mo9865a((C0925a) this);
        this.f1377g = gVar.mo10099c().mo10017a();
        aVar.mo10160a(this.f1377g);
        this.f1377g.mo9865a((C0925a) this);
        this.f1378h = gVar.mo10100d().mo10028h();
        this.f1378h.mo9890a(aVar);
        this.f1378h.mo9889a((C0925a) this);
    }

    /* renamed from: a */
    public void mo9856a(ListIterator<Content> listIterator) {
        if (this.f1379i == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            ContentGroup cVar = new ContentGroup(this.f1373c, this.f1374d, "Repeater", arrayList, null);
            this.f1379i = cVar;
        }
    }

    /* renamed from: b */
    public String mo9852b() {
        return this.f1375e;
    }

    /* renamed from: a */
    public void mo9851a(List<Content> list, List<Content> list2) {
        this.f1379i.mo9851a(list, list2);
    }

    /* renamed from: e */
    public Path mo9855e() {
        Path e = this.f1379i.mo9855e();
        this.f1372b.reset();
        float floatValue = ((Float) this.f1376f.mo9870e()).floatValue();
        float floatValue2 = ((Float) this.f1377g.mo9870e()).floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.f1371a.set(this.f1378h.mo9892b(((float) i) + floatValue2));
            this.f1372b.addPath(e, this.f1371a);
        }
        return this.f1372b;
    }

    /* renamed from: a */
    public void mo9847a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = ((Float) this.f1376f.mo9870e()).floatValue();
        float floatValue2 = ((Float) this.f1377g.mo9870e()).floatValue();
        float floatValue3 = ((Float) this.f1378h.mo9893b().mo9870e()).floatValue() / 100.0f;
        float floatValue4 = ((Float) this.f1378h.mo9894c().mo9870e()).floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.f1371a.set(matrix);
            float f = (float) i2;
            this.f1371a.preConcat(this.f1378h.mo9892b(f + floatValue2));
            this.f1379i.mo9847a(canvas, this.f1371a, (int) (((float) i) * MiscUtils.m1440a(floatValue3, floatValue4, f / floatValue)));
        }
    }

    /* renamed from: a */
    public void mo9848a(RectF rectF, Matrix matrix) {
        this.f1379i.mo9848a(rectF, matrix);
    }

    /* renamed from: a */
    public void mo9846a() {
        this.f1373c.invalidateSelf();
    }

    /* renamed from: a */
    public void mo9849a(KeyPath eVar, int i, List<KeyPath> list, KeyPath eVar2) {
        MiscUtils.m1447a(eVar, i, list, eVar2, this);
    }

    /* renamed from: a */
    public <T> void mo9850a(T t, LottieValueCallback<T> cVar) {
        if (!this.f1378h.mo9891a(t, cVar)) {
            if (t == LottieProperty.f1536m) {
                this.f1376f.mo9866a(cVar);
            } else if (t == LottieProperty.f1537n) {
                this.f1377g.mo9866a(cVar);
            }
        }
    }
}
