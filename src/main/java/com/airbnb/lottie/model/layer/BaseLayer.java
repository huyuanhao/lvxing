package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.Mask.MaskMode;
import com.airbnb.lottie.model.layer.Layer.MatteType;
import com.airbnb.lottie.p008a.p009a.Content;
import com.airbnb.lottie.p008a.p009a.DrawingContent;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.BaseKeyframeAnimation.C0925a;
import com.airbnb.lottie.p008a.p010b.FloatKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.MaskKeyframeAnimation;
import com.airbnb.lottie.p008a.p010b.TransformKeyframeAnimation;
import com.airbnb.lottie.p014e.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.airbnb.lottie.model.layer.a */
public abstract class BaseLayer implements DrawingContent, C0925a, KeyPathElement {
    /* renamed from: a */
    final Matrix f1711a = new Matrix();
    /* renamed from: b */
    final LottieDrawable f1712b;
    /* renamed from: c */
    final Layer f1713c;
    /* renamed from: d */
    final TransformKeyframeAnimation f1714d;
    /* renamed from: e */
    private final Path f1715e = new Path();
    /* renamed from: f */
    private final Matrix f1716f = new Matrix();
    /* renamed from: g */
    private final Paint f1717g = new Paint(1);
    /* renamed from: h */
    private final Paint f1718h = new Paint(1);
    /* renamed from: i */
    private final Paint f1719i = new Paint(1);
    /* renamed from: j */
    private final Paint f1720j = new Paint(1);
    /* renamed from: k */
    private final Paint f1721k = new Paint();
    /* renamed from: l */
    private final RectF f1722l = new RectF();
    /* renamed from: m */
    private final RectF f1723m = new RectF();
    /* renamed from: n */
    private final RectF f1724n = new RectF();
    /* renamed from: o */
    private final RectF f1725o = new RectF();
    /* renamed from: p */
    private final String f1726p;
    /* renamed from: q */
    private MaskKeyframeAnimation f1727q;
    /* renamed from: r */
    private BaseLayer f1728r;
    /* renamed from: s */
    private BaseLayer f1729s;
    /* renamed from: t */
    private List<BaseLayer> f1730t;
    /* renamed from: u */
    private final List<BaseKeyframeAnimation<?, ?>> f1731u = new ArrayList();
    /* renamed from: v */
    private boolean f1732v = true;

    /* compiled from: BaseLayer */
    /* renamed from: com.airbnb.lottie.model.layer.a$2 */
    static /* synthetic */ class C09382 {
        /* renamed from: b */
        static final /* synthetic */ int[] f1736b = new int[MaskMode.values().length];

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
            com.airbnb.lottie.model.content.Mask$MaskMode[] r0 = com.airbnb.lottie.model.content.Mask.MaskMode.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f1736b = r0
            r0 = 1
            int[] r1 = f1736b     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.airbnb.lottie.model.content.Mask$MaskMode r2 = com.airbnb.lottie.model.content.Mask.MaskMode.MaskModeSubtract     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r1 = 2
            int[] r2 = f1736b     // Catch:{ NoSuchFieldError -> 0x001f }
            com.airbnb.lottie.model.content.Mask$MaskMode r3 = com.airbnb.lottie.model.content.Mask.MaskMode.MaskModeIntersect     // Catch:{ NoSuchFieldError -> 0x001f }
            int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r2 = 3
            int[] r3 = f1736b     // Catch:{ NoSuchFieldError -> 0x002a }
            com.airbnb.lottie.model.content.Mask$MaskMode r4 = com.airbnb.lottie.model.content.Mask.MaskMode.MaskModeAdd     // Catch:{ NoSuchFieldError -> 0x002a }
            int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            com.airbnb.lottie.model.layer.Layer$LayerType[] r3 = com.airbnb.lottie.model.layer.Layer.LayerType.values()
            int r3 = r3.length
            int[] r3 = new int[r3]
            f1735a = r3
            int[] r3 = f1735a     // Catch:{ NoSuchFieldError -> 0x003d }
            com.airbnb.lottie.model.layer.Layer$LayerType r4 = com.airbnb.lottie.model.layer.Layer.LayerType.Shape     // Catch:{ NoSuchFieldError -> 0x003d }
            int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
            r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x003d }
        L_0x003d:
            int[] r0 = f1735a     // Catch:{ NoSuchFieldError -> 0x0047 }
            com.airbnb.lottie.model.layer.Layer$LayerType r3 = com.airbnb.lottie.model.layer.Layer.LayerType.PreComp     // Catch:{ NoSuchFieldError -> 0x0047 }
            int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
            r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0047 }
        L_0x0047:
            int[] r0 = f1735a     // Catch:{ NoSuchFieldError -> 0x0051 }
            com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.Solid     // Catch:{ NoSuchFieldError -> 0x0051 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0051 }
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0051 }
        L_0x0051:
            int[] r0 = f1735a     // Catch:{ NoSuchFieldError -> 0x005c }
            com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.Image     // Catch:{ NoSuchFieldError -> 0x005c }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005c }
        L_0x005c:
            int[] r0 = f1735a     // Catch:{ NoSuchFieldError -> 0x0067 }
            com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.Null     // Catch:{ NoSuchFieldError -> 0x0067 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0067 }
        L_0x0067:
            int[] r0 = f1735a     // Catch:{ NoSuchFieldError -> 0x0072 }
            com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.Text     // Catch:{ NoSuchFieldError -> 0x0072 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0072 }
            r2 = 6
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0072 }
        L_0x0072:
            int[] r0 = f1735a     // Catch:{ NoSuchFieldError -> 0x007d }
            com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.Unknown     // Catch:{ NoSuchFieldError -> 0x007d }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
            r2 = 7
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007d }
        L_0x007d:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.BaseLayer.C09382.m41053clinit():void");
        }
    }

    /* renamed from: a */
    public void mo9851a(List<Content> list, List<Content> list2) {
    }

    /* renamed from: b */
    public abstract void mo10162b(Canvas canvas, Matrix matrix, int i);

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo10163b(KeyPath eVar, int i, List<KeyPath> list, KeyPath eVar2) {
    }

    /* renamed from: a */
    static BaseLayer m1683a(Layer layer, LottieDrawable lottieDrawable, LottieComposition dVar) {
        switch (layer.mo10147k()) {
            case Shape:
                return new ShapeLayer(lottieDrawable, layer);
            case PreComp:
                return new CompositionLayer(lottieDrawable, layer, dVar.mo9919b(layer.mo10143g()), dVar);
            case Solid:
                return new SolidLayer(lottieDrawable, layer);
            case Image:
                return new ImageLayer(lottieDrawable, layer);
            case Null:
                return new NullLayer(lottieDrawable, layer);
            case Text:
                return new TextLayer(lottieDrawable, layer);
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown layer type ");
                sb.append(layer.mo10147k());
                L.m1314b(sb.toString());
                return null;
        }
    }

    BaseLayer(LottieDrawable lottieDrawable, Layer layer) {
        this.f1712b = lottieDrawable;
        this.f1713c = layer;
        StringBuilder sb = new StringBuilder();
        sb.append(layer.mo10142f());
        sb.append("#draw");
        this.f1726p = sb.toString();
        this.f1721k.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        this.f1718h.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        this.f1719i.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
        if (layer.mo10148l() == MatteType.Invert) {
            this.f1720j.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
        } else {
            this.f1720j.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        }
        this.f1714d = layer.mo10151o().mo10028h();
        this.f1714d.mo9889a((C0925a) this);
        if (layer.mo10146j() != null && !layer.mo10146j().isEmpty()) {
            this.f1727q = new MaskKeyframeAnimation(layer.mo10146j());
            for (BaseKeyframeAnimation a : this.f1727q.mo9877b()) {
                a.mo9865a((C0925a) this);
            }
            for (BaseKeyframeAnimation aVar : this.f1727q.mo9878c()) {
                mo10160a(aVar);
                aVar.mo9865a((C0925a) this);
            }
        }
        m1693f();
    }

    /* renamed from: a */
    public void mo9846a() {
        m1694g();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Layer mo10165c() {
        return this.f1713c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo10161a(BaseLayer aVar) {
        this.f1728r = aVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo10166d() {
        return this.f1728r != null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo10164b(BaseLayer aVar) {
        this.f1729s = aVar;
    }

    /* renamed from: f */
    private void m1693f() {
        boolean z = true;
        if (!this.f1713c.mo10140d().isEmpty()) {
            final FloatKeyframeAnimation cVar = new FloatKeyframeAnimation(this.f1713c.mo10140d());
            cVar.mo9863a();
            cVar.mo9865a((C0925a) new C0925a() {
                /* renamed from: a */
                public void mo9846a() {
                    BaseLayer.this.m1689a(((Float) cVar.mo9870e()).floatValue() == 1.0f);
                }
            });
            if (((Float) cVar.mo9870e()).floatValue() != 1.0f) {
                z = false;
            }
            m1689a(z);
            mo10160a((BaseKeyframeAnimation<?, ?>) cVar);
            return;
        }
        m1689a(true);
    }

    /* renamed from: g */
    private void m1694g() {
        this.f1712b.invalidateSelf();
    }

    /* renamed from: a */
    private void m1687a(Canvas canvas, RectF rectF, Paint paint, boolean z) {
        if (VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, z ? 31 : 19);
        } else {
            canvas.saveLayer(rectF, paint);
        }
    }

    /* renamed from: a */
    public void mo10160a(BaseKeyframeAnimation<?, ?> aVar) {
        this.f1731u.add(aVar);
    }

    /* renamed from: a */
    public void mo9848a(RectF rectF, Matrix matrix) {
        this.f1711a.set(matrix);
        this.f1711a.preConcat(this.f1714d.mo9895d());
    }

    /* renamed from: a */
    public void mo9847a(Canvas canvas, Matrix matrix, int i) {
        L.m1315c(this.f1726p);
        if (!this.f1732v) {
            L.m1316d(this.f1726p);
            return;
        }
        m1695h();
        String str = "Layer#parentMatrix";
        L.m1315c(str);
        this.f1716f.reset();
        this.f1716f.set(matrix);
        for (int size = this.f1730t.size() - 1; size >= 0; size--) {
            this.f1716f.preConcat(((BaseLayer) this.f1730t.get(size)).f1714d.mo9895d());
        }
        L.m1316d(str);
        int intValue = (int) ((((((float) i) / 255.0f) * ((float) ((Integer) this.f1714d.mo9887a().mo9870e()).intValue())) / 100.0f) * 255.0f);
        String str2 = "Layer#drawLayer";
        if (mo10166d() || mo10167e()) {
            String str3 = "Layer#computeBounds";
            L.m1315c(str3);
            this.f1722l.set(0.0f, 0.0f, 0.0f, 0.0f);
            mo9848a(this.f1722l, this.f1716f);
            m1692c(this.f1722l, this.f1716f);
            this.f1716f.preConcat(this.f1714d.mo9895d());
            m1691b(this.f1722l, this.f1716f);
            this.f1722l.set(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
            L.m1316d(str3);
            String str4 = "Layer#saveLayer";
            L.m1315c(str4);
            m1687a(canvas, this.f1722l, this.f1717g, true);
            L.m1316d(str4);
            m1684a(canvas);
            L.m1315c(str2);
            mo10162b(canvas, this.f1716f, intValue);
            L.m1316d(str2);
            if (mo10167e()) {
                m1685a(canvas, this.f1716f);
            }
            String str5 = "Layer#restoreLayer";
            if (mo10166d()) {
                String str6 = "Layer#drawMatte";
                L.m1315c(str6);
                L.m1315c(str4);
                m1687a(canvas, this.f1722l, this.f1720j, false);
                L.m1316d(str4);
                m1684a(canvas);
                this.f1728r.mo9847a(canvas, matrix, intValue);
                L.m1315c(str5);
                canvas.restore();
                L.m1316d(str5);
                L.m1316d(str6);
            }
            L.m1315c(str5);
            canvas.restore();
            L.m1316d(str5);
            m1690b(L.m1316d(this.f1726p));
            return;
        }
        this.f1716f.preConcat(this.f1714d.mo9895d());
        L.m1315c(str2);
        mo10162b(canvas, this.f1716f, intValue);
        L.m1316d(str2);
        m1690b(L.m1316d(this.f1726p));
    }

    /* renamed from: b */
    private void m1690b(float f) {
        this.f1712b.mo9833r().mo9913a().mo10005a(this.f1713c.mo10142f(), f);
    }

    /* renamed from: a */
    private void m1684a(Canvas canvas) {
        String str = "Layer#clearLayer";
        L.m1315c(str);
        canvas.drawRect(this.f1722l.left - 1.0f, this.f1722l.top - 1.0f, this.f1722l.right + 1.0f, this.f1722l.bottom + 1.0f, this.f1721k);
        L.m1316d(str);
    }

    /* renamed from: b */
    private void m1691b(RectF rectF, Matrix matrix) {
        this.f1723m.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (mo10167e()) {
            int size = this.f1727q.mo9876a().size();
            int i = 0;
            while (i < size) {
                Mask mask = (Mask) this.f1727q.mo9876a().get(i);
                this.f1715e.set((Path) ((BaseKeyframeAnimation) this.f1727q.mo9877b().get(i)).mo9870e());
                this.f1715e.transform(matrix);
                int i2 = C09382.f1736b[mask.mo10033a().ordinal()];
                if (i2 != 1 && i2 != 2) {
                    this.f1715e.computeBounds(this.f1725o, false);
                    if (i == 0) {
                        this.f1723m.set(this.f1725o);
                    } else {
                        RectF rectF2 = this.f1723m;
                        rectF2.set(Math.min(rectF2.left, this.f1725o.left), Math.min(this.f1723m.top, this.f1725o.top), Math.max(this.f1723m.right, this.f1725o.right), Math.max(this.f1723m.bottom, this.f1725o.bottom));
                    }
                    i++;
                } else {
                    return;
                }
            }
            rectF.set(Math.max(rectF.left, this.f1723m.left), Math.max(rectF.top, this.f1723m.top), Math.min(rectF.right, this.f1723m.right), Math.min(rectF.bottom, this.f1723m.bottom));
        }
    }

    /* renamed from: c */
    private void m1692c(RectF rectF, Matrix matrix) {
        if (mo10166d() && this.f1713c.mo10148l() != MatteType.Invert) {
            this.f1728r.mo9848a(this.f1724n, matrix);
            rectF.set(Math.max(rectF.left, this.f1724n.left), Math.max(rectF.top, this.f1724n.top), Math.min(rectF.right, this.f1724n.right), Math.min(rectF.bottom, this.f1724n.bottom));
        }
    }

    /* renamed from: a */
    private void m1685a(Canvas canvas, Matrix matrix) {
        m1686a(canvas, matrix, MaskMode.MaskModeAdd);
        m1686a(canvas, matrix, MaskMode.MaskModeIntersect);
        m1686a(canvas, matrix, MaskMode.MaskModeSubtract);
    }

    /* renamed from: a */
    private void m1686a(Canvas canvas, Matrix matrix, MaskMode maskMode) {
        Paint paint;
        boolean z = true;
        if (C09382.f1736b[maskMode.ordinal()] != 1) {
            paint = this.f1718h;
        } else {
            paint = this.f1719i;
        }
        int size = this.f1727q.mo9876a().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
                break;
            } else if (((Mask) this.f1727q.mo9876a().get(i)).mo10033a() == maskMode) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            String str = "Layer#drawMask";
            L.m1315c(str);
            String str2 = "Layer#saveLayer";
            L.m1315c(str2);
            m1687a(canvas, this.f1722l, paint, false);
            L.m1316d(str2);
            m1684a(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (((Mask) this.f1727q.mo9876a().get(i2)).mo10033a() == maskMode) {
                    this.f1715e.set((Path) ((BaseKeyframeAnimation) this.f1727q.mo9877b().get(i2)).mo9870e());
                    this.f1715e.transform(matrix);
                    BaseKeyframeAnimation aVar = (BaseKeyframeAnimation) this.f1727q.mo9878c().get(i2);
                    int alpha = this.f1717g.getAlpha();
                    this.f1717g.setAlpha((int) (((float) ((Integer) aVar.mo9870e()).intValue()) * 2.55f));
                    canvas.drawPath(this.f1715e, this.f1717g);
                    this.f1717g.setAlpha(alpha);
                }
            }
            String str3 = "Layer#restoreLayer";
            L.m1315c(str3);
            canvas.restore();
            L.m1316d(str3);
            L.m1316d(str);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public boolean mo10167e() {
        MaskKeyframeAnimation gVar = this.f1727q;
        return gVar != null && !gVar.mo9877b().isEmpty();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1689a(boolean z) {
        if (z != this.f1732v) {
            this.f1732v = z;
            m1694g();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo10159a(float f) {
        this.f1714d.mo9888a(f);
        if (this.f1727q != null) {
            for (int i = 0; i < this.f1727q.mo9877b().size(); i++) {
                ((BaseKeyframeAnimation) this.f1727q.mo9877b().get(i)).mo9864a(f);
            }
        }
        if (this.f1713c.mo10138b() != 0.0f) {
            f /= this.f1713c.mo10138b();
        }
        BaseLayer aVar = this.f1728r;
        if (aVar != null) {
            this.f1728r.mo10159a(aVar.f1713c.mo10138b() * f);
        }
        for (int i2 = 0; i2 < this.f1731u.size(); i2++) {
            ((BaseKeyframeAnimation) this.f1731u.get(i2)).mo9864a(f);
        }
    }

    /* renamed from: h */
    private void m1695h() {
        if (this.f1730t == null) {
            if (this.f1729s == null) {
                this.f1730t = Collections.emptyList();
                return;
            }
            this.f1730t = new ArrayList();
            for (BaseLayer aVar = this.f1729s; aVar != null; aVar = aVar.f1729s) {
                this.f1730t.add(aVar);
            }
        }
    }

    /* renamed from: b */
    public String mo9852b() {
        return this.f1713c.mo10142f();
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
                mo10163b(eVar, i + eVar.mo10124b(mo9852b(), i), list, eVar2);
            }
        }
    }

    /* renamed from: a */
    public <T> void mo9850a(T t, LottieValueCallback<T> cVar) {
        this.f1714d.mo9891a(t, cVar);
    }
}
