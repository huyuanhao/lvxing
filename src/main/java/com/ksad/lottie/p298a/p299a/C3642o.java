package com.ksad.lottie.p298a.p299a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.ksad.lottie.C3721f;
import com.ksad.lottie.model.content.C3766g;
import com.ksad.lottie.model.layer.C3774a;
import com.ksad.lottie.p298a.p300b.C3646a;
import com.ksad.lottie.p298a.p300b.C3646a.C3647a;
import com.ksad.lottie.p298a.p300b.C3661o;
import com.ksad.lottie.p303d.C3708e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* renamed from: com.ksad.lottie.a.a.o */
public class C3642o implements C3629d, C3634i, C3635j, C3638l, C3647a {
    /* renamed from: a */
    private final Matrix f12504a = new Matrix();
    /* renamed from: b */
    private final Path f12505b = new Path();
    /* renamed from: c */
    private final C3721f f12506c;
    /* renamed from: d */
    private final C3774a f12507d;
    /* renamed from: e */
    private final String f12508e;
    /* renamed from: f */
    private final C3646a<Float, Float> f12509f;
    /* renamed from: g */
    private final C3646a<Float, Float> f12510g;
    /* renamed from: h */
    private final C3661o f12511h;
    /* renamed from: i */
    private C3628c f12512i;

    public C3642o(C3721f fVar, C3774a aVar, C3766g gVar) {
        this.f12506c = fVar;
        this.f12507d = aVar;
        this.f12508e = gVar.mo23116a();
        this.f12509f = gVar.mo23117b().mo23036a();
        aVar.mo23169a(this.f12509f);
        this.f12509f.mo22827a((C3647a) this);
        this.f12510g = gVar.mo23118c().mo23036a();
        aVar.mo23169a(this.f12510g);
        this.f12510g.mo22827a((C3647a) this);
        this.f12511h = gVar.mo23119d().mo23047h();
        this.f12511h.mo22851a(aVar);
        this.f12511h.mo22850a((C3647a) this);
    }

    /* renamed from: a */
    public void mo22811a() {
        this.f12506c.invalidateSelf();
    }

    /* renamed from: a */
    public void mo22812a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = ((Float) this.f12509f.mo22831e()).floatValue();
        float floatValue2 = ((Float) this.f12510g.mo22831e()).floatValue();
        float floatValue3 = ((Float) this.f12511h.mo22853b().mo22831e()).floatValue() / 100.0f;
        float floatValue4 = ((Float) this.f12511h.mo22854c().mo22831e()).floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.f12504a.set(matrix);
            float f = (float) i2;
            this.f12504a.preConcat(this.f12511h.mo22852b(f + floatValue2));
            this.f12512i.mo22812a(canvas, this.f12504a, (int) (((float) i) * C3708e.m15377a(floatValue3, floatValue4, f / floatValue)));
        }
    }

    /* renamed from: a */
    public void mo22813a(RectF rectF, Matrix matrix) {
        this.f12512i.mo22813a(rectF, matrix);
    }

    /* renamed from: a */
    public void mo22814a(List<C3627b> list, List<C3627b> list2) {
        this.f12512i.mo22814a(list, list2);
    }

    /* renamed from: a */
    public void mo22818a(ListIterator<C3627b> listIterator) {
        if (this.f12512i == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            C3628c cVar = new C3628c(this.f12506c, this.f12507d, "Repeater", arrayList, null);
            this.f12512i = cVar;
        }
    }

    /* renamed from: d */
    public Path mo22817d() {
        Path d = this.f12512i.mo22817d();
        this.f12505b.reset();
        float floatValue = ((Float) this.f12509f.mo22831e()).floatValue();
        float floatValue2 = ((Float) this.f12510g.mo22831e()).floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.f12504a.set(this.f12511h.mo22852b(((float) i) + floatValue2));
            this.f12505b.addPath(d, this.f12504a);
        }
        return this.f12505b;
    }
}
