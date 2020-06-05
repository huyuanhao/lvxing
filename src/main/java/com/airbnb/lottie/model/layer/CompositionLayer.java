package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.layer.Layer.MatteType;
import com.airbnb.lottie.model.p015a.AnimatableFloatValue;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation.C0925a;
import com.airbnb.lottie.p008a.p010b.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.p014e.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.airbnb.lottie.model.layer.b */
public class CompositionLayer extends BaseLayer {
    /* renamed from: e */
    private BaseKeyframeAnimation<Float, Float> f1737e;
    /* renamed from: f */
    private final List<BaseLayer> f1738f = new ArrayList();
    /* renamed from: g */
    private final RectF f1739g = new RectF();
    /* renamed from: h */
    private final RectF f1740h = new RectF();

    /* compiled from: CompositionLayer */
    /* renamed from: com.airbnb.lottie.model.layer.b$1 */
    static /* synthetic */ class C09391 {
        /* renamed from: a */
        static final /* synthetic */ int[] f1741a = new int[MatteType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
            com.airbnb.lottie.model.layer.Layer$MatteType[] r0 = com.airbnb.lottie.model.layer.Layer.MatteType.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f1741a = r0
            int[] r0 = f1741a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.airbnb.lottie.model.layer.Layer$MatteType r1 = com.airbnb.lottie.model.layer.Layer.MatteType.Add     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f1741a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.airbnb.lottie.model.layer.Layer$MatteType r1 = com.airbnb.lottie.model.layer.Layer.MatteType.Invert     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.CompositionLayer.C09391.m41055clinit():void");
        }
    }

    public CompositionLayer(LottieDrawable lottieDrawable, Layer layer, List<Layer> list, LottieComposition dVar) {
        int i;
        super(lottieDrawable, layer);
        AnimatableFloatValue u = layer.mo10158u();
        if (u != null) {
            this.f1737e = u.mo10017a();
            mo10160a(this.f1737e);
            this.f1737e.mo9865a((C0925a) this);
        } else {
            this.f1737e = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(dVar.mo9924g().size());
        int size = list.size() - 1;
        BaseLayer aVar = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = (Layer) list.get(size);
            BaseLayer a = BaseLayer.m1683a(layer2, lottieDrawable, dVar);
            if (a != null) {
                longSparseArray.put(a.mo10165c().mo10141e(), a);
                if (aVar != null) {
                    aVar.mo10161a(a);
                    aVar = null;
                } else {
                    this.f1738f.add(0, a);
                    int i2 = C09391.f1741a[layer2.mo10148l().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        aVar = a;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            BaseLayer aVar2 = (BaseLayer) longSparseArray.get(longSparseArray.keyAt(i));
            if (aVar2 != null) {
                BaseLayer aVar3 = (BaseLayer) longSparseArray.get(aVar2.mo10165c().mo10149m());
                if (aVar3 != null) {
                    aVar2.mo10164b(aVar3);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo10162b(Canvas canvas, Matrix matrix, int i) {
        String str = "CompositionLayer#draw";
        L.m1315c(str);
        canvas.save();
        this.f1740h.set(0.0f, 0.0f, (float) this.f1713c.mo10144h(), (float) this.f1713c.mo10145i());
        matrix.mapRect(this.f1740h);
        for (int size = this.f1738f.size() - 1; size >= 0; size--) {
            if (!this.f1740h.isEmpty() ? canvas.clipRect(this.f1740h) : true) {
                ((BaseLayer) this.f1738f.get(size)).mo9847a(canvas, matrix, i);
            }
        }
        canvas.restore();
        L.m1316d(str);
    }

    /* renamed from: a */
    public void mo9848a(RectF rectF, Matrix matrix) {
        super.mo9848a(rectF, matrix);
        this.f1739g.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f1738f.size() - 1; size >= 0; size--) {
            ((BaseLayer) this.f1738f.get(size)).mo9848a(this.f1739g, this.f1711a);
            if (rectF.isEmpty()) {
                rectF.set(this.f1739g);
            } else {
                rectF.set(Math.min(rectF.left, this.f1739g.left), Math.min(rectF.top, this.f1739g.top), Math.max(rectF.right, this.f1739g.right), Math.max(rectF.bottom, this.f1739g.bottom));
            }
        }
    }

    /* renamed from: a */
    public void mo10159a(float f) {
        super.mo10159a(f);
        if (this.f1737e != null) {
            f = ((float) ((long) (((Float) this.f1737e.mo9870e()).floatValue() * 1000.0f))) / this.f1712b.mo9833r().mo9920c();
        }
        if (this.f1713c.mo10138b() != 0.0f) {
            f /= this.f1713c.mo10138b();
        }
        float c = f - this.f1713c.mo10139c();
        for (int size = this.f1738f.size() - 1; size >= 0; size--) {
            ((BaseLayer) this.f1738f.get(size)).mo10159a(c);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo10163b(KeyPath eVar, int i, List<KeyPath> list, KeyPath eVar2) {
        for (int i2 = 0; i2 < this.f1738f.size(); i2++) {
            ((BaseLayer) this.f1738f.get(i2)).mo9849a(eVar, i, list, eVar2);
        }
    }

    /* renamed from: a */
    public <T> void mo9850a(T t, LottieValueCallback<T> cVar) {
        super.mo9850a(t, cVar);
        if (t != LottieProperty.f1546w) {
            return;
        }
        if (cVar == null) {
            this.f1737e = null;
            return;
        }
        this.f1737e = new ValueCallbackKeyframeAnimation(cVar);
        mo10160a(this.f1737e);
    }
}
