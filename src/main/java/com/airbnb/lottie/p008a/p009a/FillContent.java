package com.airbnb.lottie.p008a.p009a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation.C0925a;
import com.airbnb.lottie.p008a.p010b.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.p013d.MiscUtils;
import com.airbnb.lottie.p014e.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.a.f */
public class FillContent implements DrawingContent, KeyPathElementContent, C0925a {
    /* renamed from: a */
    private final Path f1306a = new Path();
    /* renamed from: b */
    private final Paint f1307b = new Paint(1);
    /* renamed from: c */
    private final BaseLayer f1308c;
    /* renamed from: d */
    private final String f1309d;
    /* renamed from: e */
    private final List<PathContent> f1310e = new ArrayList();
    /* renamed from: f */
    private final BaseKeyframeAnimation<Integer, Integer> f1311f;
    /* renamed from: g */
    private final BaseKeyframeAnimation<Integer, Integer> f1312g;
    /* renamed from: h */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f1313h;
    /* renamed from: i */
    private final LottieDrawable f1314i;

    public FillContent(LottieDrawable lottieDrawable, BaseLayer aVar, ShapeFill iVar) {
        this.f1308c = aVar;
        this.f1309d = iVar.mo10106a();
        this.f1314i = lottieDrawable;
        if (iVar.mo10107b() == null || iVar.mo10108c() == null) {
            this.f1311f = null;
            this.f1312g = null;
            return;
        }
        this.f1306a.setFillType(iVar.mo10109d());
        this.f1311f = iVar.mo10107b().mo10017a();
        this.f1311f.mo9865a((C0925a) this);
        aVar.mo10160a(this.f1311f);
        this.f1312g = iVar.mo10108c().mo10017a();
        this.f1312g.mo9865a((C0925a) this);
        aVar.mo10160a(this.f1312g);
    }

    /* renamed from: a */
    public void mo9846a() {
        this.f1314i.invalidateSelf();
    }

    /* renamed from: a */
    public void mo9851a(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list2.size(); i++) {
            Content bVar = (Content) list2.get(i);
            if (bVar instanceof PathContent) {
                this.f1310e.add((PathContent) bVar);
            }
        }
    }

    /* renamed from: b */
    public String mo9852b() {
        return this.f1309d;
    }

    /* renamed from: a */
    public void mo9847a(Canvas canvas, Matrix matrix, int i) {
        String str = "FillContent#draw";
        L.m1315c(str);
        this.f1307b.setColor(((Integer) this.f1311f.mo9870e()).intValue());
        this.f1307b.setAlpha(MiscUtils.m1444a((int) ((((((float) i) / 255.0f) * ((float) ((Integer) this.f1312g.mo9870e()).intValue())) / 100.0f) * 255.0f), 0, 255));
        BaseKeyframeAnimation<ColorFilter, ColorFilter> aVar = this.f1313h;
        if (aVar != null) {
            this.f1307b.setColorFilter((ColorFilter) aVar.mo9870e());
        }
        this.f1306a.reset();
        for (int i2 = 0; i2 < this.f1310e.size(); i2++) {
            this.f1306a.addPath(((PathContent) this.f1310e.get(i2)).mo9855e(), matrix);
        }
        canvas.drawPath(this.f1306a, this.f1307b);
        L.m1316d(str);
    }

    /* renamed from: a */
    public void mo9848a(RectF rectF, Matrix matrix) {
        this.f1306a.reset();
        for (int i = 0; i < this.f1310e.size(); i++) {
            this.f1306a.addPath(((PathContent) this.f1310e.get(i)).mo9855e(), matrix);
        }
        this.f1306a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    /* renamed from: a */
    public void mo9849a(KeyPath eVar, int i, List<KeyPath> list, KeyPath eVar2) {
        MiscUtils.m1447a(eVar, i, list, eVar2, this);
    }

    /* renamed from: a */
    public <T> void mo9850a(T t, LottieValueCallback<T> cVar) {
        if (t == LottieProperty.f1524a) {
            this.f1311f.mo9866a(cVar);
        } else if (t == LottieProperty.f1527d) {
            this.f1312g.mo9866a(cVar);
        } else if (t != LottieProperty.f1547x) {
        } else {
            if (cVar == null) {
                this.f1313h = null;
                return;
            }
            this.f1313h = new ValueCallbackKeyframeAnimation(cVar);
            this.f1313h.mo9865a((C0925a) this);
            this.f1308c.mo10160a(this.f1313h);
        }
    }
}
