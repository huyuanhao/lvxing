package com.ksad.lottie.p298a.p299a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.ksad.lottie.C3665c;
import com.ksad.lottie.C3721f;
import com.ksad.lottie.model.content.C3768i;
import com.ksad.lottie.model.layer.C3774a;
import com.ksad.lottie.p298a.p300b.C3646a;
import com.ksad.lottie.p298a.p300b.C3646a.C3647a;
import com.ksad.lottie.p303d.C3708e;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.ksad.lottie.a.a.f */
public class C3631f implements C3629d, C3635j, C3647a {
    /* renamed from: a */
    private final Path f12439a = new Path();
    /* renamed from: b */
    private final Paint f12440b = new Paint(1);
    /* renamed from: c */
    private final C3774a f12441c;
    /* renamed from: d */
    private final String f12442d;
    /* renamed from: e */
    private final List<C3638l> f12443e = new ArrayList();
    /* renamed from: f */
    private final C3646a<Integer, Integer> f12444f;
    /* renamed from: g */
    private final C3646a<Integer, Integer> f12445g;
    /* renamed from: h */
    private C3646a<ColorFilter, ColorFilter> f12446h;
    /* renamed from: i */
    private final C3721f f12447i;

    public C3631f(C3721f fVar, C3774a aVar, C3768i iVar) {
        this.f12441c = aVar;
        this.f12442d = iVar.mo23125a();
        this.f12447i = fVar;
        if (iVar.mo23126b() == null || iVar.mo23127c() == null) {
            this.f12444f = null;
            this.f12445g = null;
            return;
        }
        this.f12439a.setFillType(iVar.mo23128d());
        this.f12444f = iVar.mo23126b().mo23036a();
        this.f12444f.mo22827a((C3647a) this);
        aVar.mo23169a(this.f12444f);
        this.f12445g = iVar.mo23127c().mo23036a();
        this.f12445g.mo22827a((C3647a) this);
        aVar.mo23169a(this.f12445g);
    }

    /* renamed from: a */
    public void mo22811a() {
        this.f12447i.invalidateSelf();
    }

    /* renamed from: a */
    public void mo22812a(Canvas canvas, Matrix matrix, int i) {
        String str = "FillContent#draw";
        C3665c.m15252c(str);
        this.f12440b.setColor(((Integer) this.f12444f.mo22831e()).intValue());
        this.f12440b.setAlpha(C3708e.m15381a((int) ((((((float) i) / 255.0f) * ((float) ((Integer) this.f12445g.mo22831e()).intValue())) / 100.0f) * 255.0f), 0, 255));
        C3646a<ColorFilter, ColorFilter> aVar = this.f12446h;
        if (aVar != null) {
            this.f12440b.setColorFilter((ColorFilter) aVar.mo22831e());
        }
        this.f12439a.reset();
        for (int i2 = 0; i2 < this.f12443e.size(); i2++) {
            this.f12439a.addPath(((C3638l) this.f12443e.get(i2)).mo22817d(), matrix);
        }
        canvas.drawPath(this.f12439a, this.f12440b);
        C3665c.m15253d(str);
    }

    /* renamed from: a */
    public void mo22813a(RectF rectF, Matrix matrix) {
        this.f12439a.reset();
        for (int i = 0; i < this.f12443e.size(); i++) {
            this.f12439a.addPath(((C3638l) this.f12443e.get(i)).mo22817d(), matrix);
        }
        this.f12439a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    /* renamed from: a */
    public void mo22814a(List<C3627b> list, List<C3627b> list2) {
        for (int i = 0; i < list2.size(); i++) {
            C3627b bVar = (C3627b) list2.get(i);
            if (bVar instanceof C3638l) {
                this.f12443e.add((C3638l) bVar);
            }
        }
    }
}
