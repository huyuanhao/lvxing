package com.airbnb.lottie.p008a.p009a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.p015a.AnimatableTransform;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation.C0925a;
import com.airbnb.lottie.p008a.p010b.TransformKeyframeAnimation;
import com.airbnb.lottie.p014e.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.a.c */
public class ContentGroup implements DrawingContent, PathContent, C0925a, KeyPathElement {
    /* renamed from: a */
    private final Matrix f1290a;
    /* renamed from: b */
    private final Path f1291b;
    /* renamed from: c */
    private final RectF f1292c;
    /* renamed from: d */
    private final String f1293d;
    /* renamed from: e */
    private final List<Content> f1294e;
    /* renamed from: f */
    private final LottieDrawable f1295f;
    /* renamed from: g */
    private List<PathContent> f1296g;
    /* renamed from: h */
    private TransformKeyframeAnimation f1297h;

    /* renamed from: a */
    private static List<Content> m1158a(LottieDrawable lottieDrawable, BaseLayer aVar, List<ContentModel> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            Content a = ((ContentModel) list.get(i)).mo10020a(lottieDrawable, aVar);
            if (a != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    static AnimatableTransform m1157a(List<ContentModel> list) {
        for (int i = 0; i < list.size(); i++) {
            ContentModel bVar = (ContentModel) list.get(i);
            if (bVar instanceof AnimatableTransform) {
                return (AnimatableTransform) bVar;
            }
        }
        return null;
    }

    public ContentGroup(LottieDrawable lottieDrawable, BaseLayer aVar, ShapeGroup jVar) {
        this(lottieDrawable, aVar, jVar.mo10111a(), m1158a(lottieDrawable, aVar, jVar.mo10112b()), m1157a(jVar.mo10112b()));
    }

    ContentGroup(LottieDrawable lottieDrawable, BaseLayer aVar, String str, List<Content> list, AnimatableTransform lVar) {
        this.f1290a = new Matrix();
        this.f1291b = new Path();
        this.f1292c = new RectF();
        this.f1293d = str;
        this.f1295f = lottieDrawable;
        this.f1294e = list;
        if (lVar != null) {
            this.f1297h = lVar.mo10028h();
            this.f1297h.mo9890a(aVar);
            this.f1297h.mo9889a((C0925a) this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            Content bVar = (Content) list.get(size);
            if (bVar instanceof GreedyContent) {
                arrayList.add((GreedyContent) bVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((GreedyContent) arrayList.get(size2)).mo9856a(list.listIterator(list.size()));
        }
    }

    /* renamed from: a */
    public void mo9846a() {
        this.f1295f.invalidateSelf();
    }

    /* renamed from: b */
    public String mo9852b() {
        return this.f1293d;
    }

    /* renamed from: a */
    public void mo9851a(List<Content> list, List<Content> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f1294e.size());
        arrayList.addAll(list);
        for (int size = this.f1294e.size() - 1; size >= 0; size--) {
            Content bVar = (Content) this.f1294e.get(size);
            bVar.mo9851a(arrayList, this.f1294e.subList(0, size));
            arrayList.add(bVar);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public List<PathContent> mo9853c() {
        if (this.f1296g == null) {
            this.f1296g = new ArrayList();
            for (int i = 0; i < this.f1294e.size(); i++) {
                Content bVar = (Content) this.f1294e.get(i);
                if (bVar instanceof PathContent) {
                    this.f1296g.add((PathContent) bVar);
                }
            }
        }
        return this.f1296g;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public Matrix mo9854d() {
        TransformKeyframeAnimation oVar = this.f1297h;
        if (oVar != null) {
            return oVar.mo9895d();
        }
        this.f1290a.reset();
        return this.f1290a;
    }

    /* renamed from: e */
    public Path mo9855e() {
        this.f1290a.reset();
        TransformKeyframeAnimation oVar = this.f1297h;
        if (oVar != null) {
            this.f1290a.set(oVar.mo9895d());
        }
        this.f1291b.reset();
        for (int size = this.f1294e.size() - 1; size >= 0; size--) {
            Content bVar = (Content) this.f1294e.get(size);
            if (bVar instanceof PathContent) {
                this.f1291b.addPath(((PathContent) bVar).mo9855e(), this.f1290a);
            }
        }
        return this.f1291b;
    }

    /* renamed from: a */
    public void mo9847a(Canvas canvas, Matrix matrix, int i) {
        this.f1290a.set(matrix);
        TransformKeyframeAnimation oVar = this.f1297h;
        if (oVar != null) {
            this.f1290a.preConcat(oVar.mo9895d());
            i = (int) ((((((float) ((Integer) this.f1297h.mo9887a().mo9870e()).intValue()) / 100.0f) * ((float) i)) / 255.0f) * 255.0f);
        }
        for (int size = this.f1294e.size() - 1; size >= 0; size--) {
            Object obj = this.f1294e.get(size);
            if (obj instanceof DrawingContent) {
                ((DrawingContent) obj).mo9847a(canvas, this.f1290a, i);
            }
        }
    }

    /* renamed from: a */
    public void mo9848a(RectF rectF, Matrix matrix) {
        this.f1290a.set(matrix);
        TransformKeyframeAnimation oVar = this.f1297h;
        if (oVar != null) {
            this.f1290a.preConcat(oVar.mo9895d());
        }
        this.f1292c.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f1294e.size() - 1; size >= 0; size--) {
            Content bVar = (Content) this.f1294e.get(size);
            if (bVar instanceof DrawingContent) {
                ((DrawingContent) bVar).mo9848a(this.f1292c, this.f1290a);
                if (rectF.isEmpty()) {
                    rectF.set(this.f1292c);
                } else {
                    rectF.set(Math.min(rectF.left, this.f1292c.left), Math.min(rectF.top, this.f1292c.top), Math.max(rectF.right, this.f1292c.right), Math.max(rectF.bottom, this.f1292c.bottom));
                }
            }
        }
    }

    /* renamed from: a */
    public void mo9849a(KeyPath eVar, int i, List<KeyPath> list, KeyPath eVar2) {
        if (eVar.mo10123a(mo9852b(), i)) {
            if (!"__container".equals(mo9852b())) {
                eVar2 = eVar2.mo10121a(mo9852b());
                if (eVar.mo10125c(mo9852b(), i)) {
                    list.add(eVar2.mo10120a((KeyPathElement) this));
                }
            }
            if (eVar.mo10126d(mo9852b(), i)) {
                int b = i + eVar.mo10124b(mo9852b(), i);
                for (int i2 = 0; i2 < this.f1294e.size(); i2++) {
                    Content bVar = (Content) this.f1294e.get(i2);
                    if (bVar instanceof KeyPathElement) {
                        ((KeyPathElement) bVar).mo9849a(eVar, b, list, eVar2);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public <T> void mo9850a(T t, LottieValueCallback<T> cVar) {
        TransformKeyframeAnimation oVar = this.f1297h;
        if (oVar != null) {
            oVar.mo9891a(t, cVar);
        }
    }
}
