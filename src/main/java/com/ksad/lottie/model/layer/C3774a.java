package com.ksad.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import com.ksad.lottie.C3665c;
import com.ksad.lottie.C3703d;
import com.ksad.lottie.C3721f;
import com.ksad.lottie.model.content.Mask;
import com.ksad.lottie.model.content.Mask.MaskMode;
import com.ksad.lottie.model.layer.Layer.MatteType;
import com.ksad.lottie.p298a.p299a.C3627b;
import com.ksad.lottie.p298a.p299a.C3629d;
import com.ksad.lottie.p298a.p300b.C3646a;
import com.ksad.lottie.p298a.p300b.C3646a.C3647a;
import com.ksad.lottie.p298a.p300b.C3649c;
import com.ksad.lottie.p298a.p300b.C3653g;
import com.ksad.lottie.p298a.p300b.C3661o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.ksad.lottie.model.layer.a */
public abstract class C3774a implements C3629d, C3647a {
    /* renamed from: a */
    final Matrix f12848a = new Matrix();
    /* renamed from: b */
    final C3721f f12849b;
    /* renamed from: c */
    final Layer f12850c;
    /* renamed from: d */
    final C3661o f12851d;
    /* renamed from: e */
    private final Path f12852e = new Path();
    /* renamed from: f */
    private final Matrix f12853f = new Matrix();
    /* renamed from: g */
    private final Paint f12854g = new Paint(1);
    /* renamed from: h */
    private final Paint f12855h = new Paint(1);
    /* renamed from: i */
    private final Paint f12856i = new Paint(1);
    /* renamed from: j */
    private final Paint f12857j = new Paint(1);
    /* renamed from: k */
    private final Paint f12858k = new Paint();
    /* renamed from: l */
    private final RectF f12859l = new RectF();
    /* renamed from: m */
    private final RectF f12860m = new RectF();
    /* renamed from: n */
    private final RectF f12861n = new RectF();
    /* renamed from: o */
    private final RectF f12862o = new RectF();
    /* renamed from: p */
    private final String f12863p;
    /* renamed from: q */
    private C3653g f12864q;
    /* renamed from: r */
    private C3774a f12865r;
    /* renamed from: s */
    private C3774a f12866s;
    /* renamed from: t */
    private List<C3774a> f12867t;
    /* renamed from: u */
    private final List<C3646a<?, ?>> f12868u = new ArrayList();
    /* renamed from: v */
    private boolean f12869v = true;

    /* renamed from: com.ksad.lottie.model.layer.a$2 */
    static /* synthetic */ class C37762 {
        /* renamed from: b */
        static final /* synthetic */ int[] f12873b = new int[MaskMode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0051 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0067 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0072 */
        static {
            /*
            com.ksad.lottie.model.content.Mask$MaskMode[] r0 = com.ksad.lottie.model.content.Mask.MaskMode.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f12873b = r0
            r0 = 1
            int[] r1 = f12873b     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.ksad.lottie.model.content.Mask$MaskMode r2 = com.ksad.lottie.model.content.Mask.MaskMode.MaskModeSubtract     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r1 = 2
            int[] r2 = f12873b     // Catch:{ NoSuchFieldError -> 0x001f }
            com.ksad.lottie.model.content.Mask$MaskMode r3 = com.ksad.lottie.model.content.Mask.MaskMode.MaskModeIntersect     // Catch:{ NoSuchFieldError -> 0x001f }
            int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r2 = 3
            int[] r3 = f12873b     // Catch:{ NoSuchFieldError -> 0x002a }
            com.ksad.lottie.model.content.Mask$MaskMode r4 = com.ksad.lottie.model.content.Mask.MaskMode.MaskModeAdd     // Catch:{ NoSuchFieldError -> 0x002a }
            int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            com.ksad.lottie.model.layer.Layer$LayerType[] r3 = com.ksad.lottie.model.layer.Layer.LayerType.values()
            int r3 = r3.length
            int[] r3 = new int[r3]
            f12872a = r3
            int[] r3 = f12872a     // Catch:{ NoSuchFieldError -> 0x003d }
            com.ksad.lottie.model.layer.Layer$LayerType r4 = com.ksad.lottie.model.layer.Layer.LayerType.Shape     // Catch:{ NoSuchFieldError -> 0x003d }
            int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
            r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x003d }
        L_0x003d:
            int[] r0 = f12872a     // Catch:{ NoSuchFieldError -> 0x0047 }
            com.ksad.lottie.model.layer.Layer$LayerType r3 = com.ksad.lottie.model.layer.Layer.LayerType.PreComp     // Catch:{ NoSuchFieldError -> 0x0047 }
            int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
            r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0047 }
        L_0x0047:
            int[] r0 = f12872a     // Catch:{ NoSuchFieldError -> 0x0051 }
            com.ksad.lottie.model.layer.Layer$LayerType r1 = com.ksad.lottie.model.layer.Layer.LayerType.Solid     // Catch:{ NoSuchFieldError -> 0x0051 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0051 }
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0051 }
        L_0x0051:
            int[] r0 = f12872a     // Catch:{ NoSuchFieldError -> 0x005c }
            com.ksad.lottie.model.layer.Layer$LayerType r1 = com.ksad.lottie.model.layer.Layer.LayerType.Image     // Catch:{ NoSuchFieldError -> 0x005c }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005c }
        L_0x005c:
            int[] r0 = f12872a     // Catch:{ NoSuchFieldError -> 0x0067 }
            com.ksad.lottie.model.layer.Layer$LayerType r1 = com.ksad.lottie.model.layer.Layer.LayerType.Null     // Catch:{ NoSuchFieldError -> 0x0067 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0067 }
        L_0x0067:
            int[] r0 = f12872a     // Catch:{ NoSuchFieldError -> 0x0072 }
            com.ksad.lottie.model.layer.Layer$LayerType r1 = com.ksad.lottie.model.layer.Layer.LayerType.Text     // Catch:{ NoSuchFieldError -> 0x0072 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0072 }
            r2 = 6
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0072 }
        L_0x0072:
            int[] r0 = f12872a     // Catch:{ NoSuchFieldError -> 0x007d }
            com.ksad.lottie.model.layer.Layer$LayerType r1 = com.ksad.lottie.model.layer.Layer.LayerType.Unknown     // Catch:{ NoSuchFieldError -> 0x007d }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
            r2 = 7
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007d }
        L_0x007d:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ksad.lottie.model.layer.C3774a.C37762.m47555clinit():void");
        }
    }

    C3774a(C3721f fVar, Layer layer) {
        Paint paint;
        PorterDuffXfermode porterDuffXfermode;
        this.f12849b = fVar;
        this.f12850c = layer;
        StringBuilder sb = new StringBuilder();
        sb.append(layer.mo23151f());
        sb.append("#draw");
        this.f12863p = sb.toString();
        this.f12858k.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        this.f12855h.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        this.f12856i.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
        if (layer.mo23157l() == MatteType.Invert) {
            paint = this.f12857j;
            porterDuffXfermode = new PorterDuffXfermode(Mode.DST_OUT);
        } else {
            paint = this.f12857j;
            porterDuffXfermode = new PorterDuffXfermode(Mode.DST_IN);
        }
        paint.setXfermode(porterDuffXfermode);
        this.f12851d = layer.mo23160o().mo23047h();
        this.f12851d.mo22850a((C3647a) this);
        if (layer.mo23155j() != null && !layer.mo23155j().isEmpty()) {
            this.f12864q = new C3653g(layer.mo23155j());
            for (C3646a a : this.f12864q.mo22838b()) {
                a.mo22827a((C3647a) this);
            }
            for (C3646a aVar : this.f12864q.mo22839c()) {
                mo23169a(aVar);
                aVar.mo22827a((C3647a) this);
            }
        }
        m15674e();
    }

    /* renamed from: a */
    static C3774a m15664a(Layer layer, C3721f fVar, C3703d dVar) {
        switch (layer.mo23156k()) {
            case Shape:
                return new C3781e(fVar, layer);
            case PreComp:
                return new C3777b(fVar, layer, dVar.mo22879b(layer.mo23152g()), dVar);
            case Solid:
                return new C3782f(fVar, layer);
            case Image:
                return new C3779c(fVar, layer);
            case Null:
                return new C3780d(fVar, layer);
            case Text:
                return new C3783g(fVar, layer);
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown layer type ");
                sb.append(layer.mo23156k());
                C3665c.m15251b(sb.toString());
                return null;
        }
    }

    /* renamed from: a */
    private void m15665a(Canvas canvas) {
        String str = "Layer#clearLayer";
        C3665c.m15252c(str);
        canvas.drawRect(this.f12859l.left - 1.0f, this.f12859l.top - 1.0f, this.f12859l.right + 1.0f, this.f12859l.bottom + 1.0f, this.f12858k);
        C3665c.m15253d(str);
    }

    /* renamed from: a */
    private void m15666a(Canvas canvas, Matrix matrix) {
        m15667a(canvas, matrix, MaskMode.MaskModeAdd);
        m15667a(canvas, matrix, MaskMode.MaskModeIntersect);
        m15667a(canvas, matrix, MaskMode.MaskModeSubtract);
    }

    /* renamed from: a */
    private void m15667a(Canvas canvas, Matrix matrix, MaskMode maskMode) {
        boolean z = true;
        Paint paint = C37762.f12873b[maskMode.ordinal()] != 1 ? this.f12855h : this.f12856i;
        int size = this.f12864q.mo22837a().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
                break;
            } else if (((Mask) this.f12864q.mo22837a().get(i)).mo23052a() == maskMode) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            String str = "Layer#drawMask";
            C3665c.m15252c(str);
            String str2 = "Layer#saveLayer";
            C3665c.m15252c(str2);
            m15668a(canvas, this.f12859l, paint, false);
            C3665c.m15253d(str2);
            m15665a(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (((Mask) this.f12864q.mo22837a().get(i2)).mo23052a() == maskMode) {
                    this.f12852e.set((Path) ((C3646a) this.f12864q.mo22838b().get(i2)).mo22831e());
                    this.f12852e.transform(matrix);
                    C3646a aVar = (C3646a) this.f12864q.mo22839c().get(i2);
                    int alpha = this.f12854g.getAlpha();
                    this.f12854g.setAlpha((int) (((float) ((Integer) aVar.mo22831e()).intValue()) * 2.55f));
                    canvas.drawPath(this.f12852e, this.f12854g);
                    this.f12854g.setAlpha(alpha);
                }
            }
            String str3 = "Layer#restoreLayer";
            C3665c.m15252c(str3);
            canvas.restore();
            C3665c.m15253d(str3);
            C3665c.m15253d(str);
        }
    }

    /* renamed from: a */
    private void m15668a(Canvas canvas, RectF rectF, Paint paint, boolean z) {
        if (VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, z ? 31 : 19);
        } else {
            canvas.saveLayer(rectF, paint);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15670a(boolean z) {
        if (z != this.f12869v) {
            this.f12869v = z;
            m15675f();
        }
    }

    /* renamed from: b */
    private void m15671b(float f) {
        this.f12849b.mo22998r().mo22873a().mo23024a(this.f12850c.mo23151f(), f);
    }

    /* renamed from: b */
    private void m15672b(RectF rectF, Matrix matrix) {
        this.f12860m.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (mo23175d()) {
            int size = this.f12864q.mo22837a().size();
            int i = 0;
            while (i < size) {
                Mask mask = (Mask) this.f12864q.mo22837a().get(i);
                this.f12852e.set((Path) ((C3646a) this.f12864q.mo22838b().get(i)).mo22831e());
                this.f12852e.transform(matrix);
                int i2 = C37762.f12873b[mask.mo23052a().ordinal()];
                if (i2 != 1 && i2 != 2) {
                    this.f12852e.computeBounds(this.f12862o, false);
                    RectF rectF2 = this.f12860m;
                    if (i == 0) {
                        rectF2.set(this.f12862o);
                    } else {
                        rectF2.set(Math.min(rectF2.left, this.f12862o.left), Math.min(this.f12860m.top, this.f12862o.top), Math.max(this.f12860m.right, this.f12862o.right), Math.max(this.f12860m.bottom, this.f12862o.bottom));
                    }
                    i++;
                } else {
                    return;
                }
            }
            rectF.set(Math.max(rectF.left, this.f12860m.left), Math.max(rectF.top, this.f12860m.top), Math.min(rectF.right, this.f12860m.right), Math.min(rectF.bottom, this.f12860m.bottom));
        }
    }

    /* renamed from: c */
    private void m15673c(RectF rectF, Matrix matrix) {
        if (mo23174c() && this.f12850c.mo23157l() != MatteType.Invert) {
            this.f12865r.mo22813a(this.f12861n, matrix);
            rectF.set(Math.max(rectF.left, this.f12861n.left), Math.max(rectF.top, this.f12861n.top), Math.min(rectF.right, this.f12861n.right), Math.min(rectF.bottom, this.f12861n.bottom));
        }
    }

    /* renamed from: e */
    private void m15674e() {
        boolean z = true;
        if (!this.f12850c.mo23149d().isEmpty()) {
            final C3649c cVar = new C3649c(this.f12850c.mo23149d());
            cVar.mo22825a();
            cVar.mo22827a((C3647a) new C3647a() {
                /* renamed from: a */
                public void mo22811a() {
                    C3774a.this.m15670a(((Float) cVar.mo22831e()).floatValue() == 1.0f);
                }
            });
            if (((Float) cVar.mo22831e()).floatValue() != 1.0f) {
                z = false;
            }
            m15670a(z);
            mo23169a((C3646a<?, ?>) cVar);
            return;
        }
        m15670a(true);
    }

    /* renamed from: f */
    private void m15675f() {
        this.f12849b.invalidateSelf();
    }

    /* renamed from: g */
    private void m15676g() {
        if (this.f12867t == null) {
            if (this.f12866s == null) {
                this.f12867t = Collections.emptyList();
                return;
            }
            this.f12867t = new ArrayList();
            for (C3774a aVar = this.f12866s; aVar != null; aVar = aVar.f12866s) {
                this.f12867t.add(aVar);
            }
        }
    }

    /* renamed from: a */
    public void mo22811a() {
        m15675f();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23168a(float f) {
        this.f12851d.mo22849a(f);
        if (this.f12864q != null) {
            for (int i = 0; i < this.f12864q.mo22838b().size(); i++) {
                ((C3646a) this.f12864q.mo22838b().get(i)).mo22826a(f);
            }
        }
        if (this.f12850c.mo23147b() != 0.0f) {
            f /= this.f12850c.mo23147b();
        }
        C3774a aVar = this.f12865r;
        if (aVar != null) {
            this.f12865r.mo23168a(aVar.f12850c.mo23147b() * f);
        }
        for (int i2 = 0; i2 < this.f12868u.size(); i2++) {
            ((C3646a) this.f12868u.get(i2)).mo22826a(f);
        }
    }

    /* renamed from: a */
    public void mo22812a(Canvas canvas, Matrix matrix, int i) {
        C3665c.m15252c(this.f12863p);
        if (!this.f12869v) {
            C3665c.m15253d(this.f12863p);
            return;
        }
        m15676g();
        String str = "Layer#parentMatrix";
        C3665c.m15252c(str);
        this.f12853f.reset();
        this.f12853f.set(matrix);
        for (int size = this.f12867t.size() - 1; size >= 0; size--) {
            this.f12853f.preConcat(((C3774a) this.f12867t.get(size)).f12851d.mo22855d());
        }
        C3665c.m15253d(str);
        int intValue = (int) ((((((float) i) / 255.0f) * ((float) ((Integer) this.f12851d.mo22848a().mo22831e()).intValue())) / 100.0f) * 255.0f);
        String str2 = "Layer#drawLayer";
        if (mo23174c() || mo23175d()) {
            String str3 = "Layer#computeBounds";
            C3665c.m15252c(str3);
            this.f12859l.set(0.0f, 0.0f, 0.0f, 0.0f);
            mo22813a(this.f12859l, this.f12853f);
            m15673c(this.f12859l, this.f12853f);
            this.f12853f.preConcat(this.f12851d.mo22855d());
            m15672b(this.f12859l, this.f12853f);
            this.f12859l.set(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
            C3665c.m15253d(str3);
            String str4 = "Layer#saveLayer";
            C3665c.m15252c(str4);
            m15668a(canvas, this.f12859l, this.f12854g, true);
            C3665c.m15253d(str4);
            m15665a(canvas);
            C3665c.m15252c(str2);
            mo23172b(canvas, this.f12853f, intValue);
            C3665c.m15253d(str2);
            if (mo23175d()) {
                m15666a(canvas, this.f12853f);
            }
            String str5 = "Layer#restoreLayer";
            if (mo23174c()) {
                String str6 = "Layer#drawMatte";
                C3665c.m15252c(str6);
                C3665c.m15252c(str4);
                m15668a(canvas, this.f12859l, this.f12857j, false);
                C3665c.m15253d(str4);
                m15665a(canvas);
                this.f12865r.mo22812a(canvas, matrix, intValue);
                C3665c.m15252c(str5);
                canvas.restore();
                C3665c.m15253d(str5);
                C3665c.m15253d(str6);
            }
            C3665c.m15252c(str5);
            canvas.restore();
            C3665c.m15253d(str5);
            m15671b(C3665c.m15253d(this.f12863p));
            return;
        }
        this.f12853f.preConcat(this.f12851d.mo22855d());
        C3665c.m15252c(str2);
        mo23172b(canvas, this.f12853f, intValue);
        C3665c.m15253d(str2);
        m15671b(C3665c.m15253d(this.f12863p));
    }

    /* renamed from: a */
    public void mo22813a(RectF rectF, Matrix matrix) {
        this.f12848a.set(matrix);
        this.f12848a.preConcat(this.f12851d.mo22855d());
    }

    /* renamed from: a */
    public void mo23169a(C3646a<?, ?> aVar) {
        this.f12868u.add(aVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23170a(C3774a aVar) {
        this.f12865r = aVar;
    }

    /* renamed from: a */
    public void mo22814a(List<C3627b> list, List<C3627b> list2) {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Layer mo23171b() {
        return this.f12850c;
    }

    /* renamed from: b */
    public abstract void mo23172b(Canvas canvas, Matrix matrix, int i);

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo23173b(C3774a aVar) {
        this.f12866s = aVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo23174c() {
        return this.f12865r != null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo23175d() {
        C3653g gVar = this.f12864q;
        return gVar != null && !gVar.mo22838b().isEmpty();
    }
}
