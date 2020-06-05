package com.ksad.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.ksad.lottie.C3665c;
import com.ksad.lottie.C3703d;
import com.ksad.lottie.C3721f;
import com.ksad.lottie.model.layer.Layer.MatteType;
import com.ksad.lottie.model.p305a.C3744b;
import com.ksad.lottie.p298a.p300b.C3646a;
import com.ksad.lottie.p298a.p300b.C3646a.C3647a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.ksad.lottie.model.layer.b */
public class C3777b extends C3774a {
    /* renamed from: e */
    private C3646a<Float, Float> f12874e;
    /* renamed from: f */
    private final List<C3774a> f12875f = new ArrayList();
    /* renamed from: g */
    private final RectF f12876g = new RectF();
    /* renamed from: h */
    private final RectF f12877h = new RectF();

    /* renamed from: com.ksad.lottie.model.layer.b$1 */
    static /* synthetic */ class C37781 {
        /* renamed from: a */
        static final /* synthetic */ int[] f12878a = new int[MatteType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
            com.ksad.lottie.model.layer.Layer$MatteType[] r0 = com.ksad.lottie.model.layer.Layer.MatteType.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f12878a = r0
            int[] r0 = f12878a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.ksad.lottie.model.layer.Layer$MatteType r1 = com.ksad.lottie.model.layer.Layer.MatteType.Add     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f12878a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.ksad.lottie.model.layer.Layer$MatteType r1 = com.ksad.lottie.model.layer.Layer.MatteType.Invert     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ksad.lottie.model.layer.C3777b.C37781.m47557clinit():void");
        }
    }

    public C3777b(C3721f fVar, Layer layer, List<Layer> list, C3703d dVar) {
        int i;
        super(fVar, layer);
        C3744b u = layer.mo23167u();
        if (u != null) {
            this.f12874e = u.mo23036a();
            mo23169a(this.f12874e);
            this.f12874e.mo22827a((C3647a) this);
        } else {
            this.f12874e = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(dVar.mo22884g().size());
        int size = list.size() - 1;
        C3774a aVar = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = (Layer) list.get(size);
            C3774a a = C3774a.m15664a(layer2, fVar, dVar);
            if (a != null) {
                longSparseArray.put(a.mo23171b().mo23150e(), a);
                if (aVar != null) {
                    aVar.mo23170a(a);
                    aVar = null;
                } else {
                    this.f12875f.add(0, a);
                    int i2 = C37781.f12878a[layer2.mo23157l().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        aVar = a;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            C3774a aVar2 = (C3774a) longSparseArray.get(longSparseArray.keyAt(i));
            if (aVar2 != null) {
                C3774a aVar3 = (C3774a) longSparseArray.get(aVar2.mo23171b().mo23158m());
                if (aVar3 != null) {
                    aVar2.mo23173b(aVar3);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo23168a(float f) {
        super.mo23168a(f);
        if (this.f12874e != null) {
            f = ((float) ((long) (((Float) this.f12874e.mo22831e()).floatValue() * 1000.0f))) / this.f12849b.mo22998r().mo22880c();
        }
        if (this.f12850c.mo23147b() != 0.0f) {
            f /= this.f12850c.mo23147b();
        }
        float c = f - this.f12850c.mo23148c();
        for (int size = this.f12875f.size() - 1; size >= 0; size--) {
            ((C3774a) this.f12875f.get(size)).mo23168a(c);
        }
    }

    /* renamed from: a */
    public void mo22813a(RectF rectF, Matrix matrix) {
        super.mo22813a(rectF, matrix);
        this.f12876g.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f12875f.size() - 1; size >= 0; size--) {
            ((C3774a) this.f12875f.get(size)).mo22813a(this.f12876g, this.f12848a);
            if (rectF.isEmpty()) {
                rectF.set(this.f12876g);
            } else {
                rectF.set(Math.min(rectF.left, this.f12876g.left), Math.min(rectF.top, this.f12876g.top), Math.max(rectF.right, this.f12876g.right), Math.max(rectF.bottom, this.f12876g.bottom));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo23172b(Canvas canvas, Matrix matrix, int i) {
        String str = "CompositionLayer#draw";
        C3665c.m15252c(str);
        canvas.save();
        this.f12877h.set(0.0f, 0.0f, (float) this.f12850c.mo23153h(), (float) this.f12850c.mo23154i());
        matrix.mapRect(this.f12877h);
        for (int size = this.f12875f.size() - 1; size >= 0; size--) {
            if (!this.f12877h.isEmpty() ? canvas.clipRect(this.f12877h) : true) {
                ((C3774a) this.f12875f.get(size)).mo22812a(canvas, matrix, i);
            }
        }
        canvas.restore();
        C3665c.m15253d(str);
    }
}
