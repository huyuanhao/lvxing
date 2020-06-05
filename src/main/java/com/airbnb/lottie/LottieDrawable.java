package com.airbnb.lottie;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.p011b.FontAssetManager;
import com.airbnb.lottie.p011b.ImageAssetManager;
import com.airbnb.lottie.p012c.LayerParser;
import com.airbnb.lottie.p013d.LottieValueAnimator;
import com.airbnb.lottie.p013d.MiscUtils;
import com.airbnb.lottie.p014e.LottieValueCallback;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LottieDrawable extends Drawable implements Animatable, Callback {
    /* renamed from: c */
    private static final String f1239c = LottieDrawable.class.getSimpleName();
    /* renamed from: a */
    FontAssetDelegate f1240a;
    /* renamed from: b */
    TextDelegate f1241b;
    /* renamed from: d */
    private final Matrix f1242d = new Matrix();
    /* renamed from: e */
    private LottieComposition f1243e;
    /* access modifiers changed from: private|final */
    /* renamed from: f */
    public final LottieValueAnimator f1244f = new LottieValueAnimator();
    /* renamed from: g */
    private float f1245g = 1.0f;
    /* renamed from: h */
    private final Set<Object> f1246h = new HashSet();
    /* renamed from: i */
    private final ArrayList<C0916a> f1247i = new ArrayList<>();
    /* renamed from: j */
    private ImageAssetManager f1248j;
    /* renamed from: k */
    private String f1249k;
    /* renamed from: l */
    private ImageAssetDelegate f1250l;
    /* renamed from: m */
    private FontAssetManager f1251m;
    /* renamed from: n */
    private boolean f1252n;
    /* access modifiers changed from: private */
    /* renamed from: o */
    public CompositionLayer f1253o;
    /* renamed from: p */
    private int f1254p = 255;
    /* renamed from: q */
    private boolean f1255q;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.airbnb.lottie.LottieDrawable$RepeatMode */
    public @interface RepeatMode {
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$a */
    private interface C0916a {
        /* renamed from: a */
        void mo9843a(LottieComposition dVar);
    }

    public int getOpacity() {
        return -3;
    }

    public LottieDrawable() {
        this.f1244f.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (LottieDrawable.this.f1253o != null) {
                    LottieDrawable.this.f1253o.mo10159a(LottieDrawable.this.f1244f.mo9953d());
                }
            }
        });
    }

    /* renamed from: a */
    public boolean mo9797a() {
        return this.f1252n;
    }

    /* renamed from: a */
    public void mo9796a(boolean z) {
        if (this.f1252n != z) {
            if (VERSION.SDK_INT < 19) {
                Log.w(f1239c, "Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.f1252n = z;
            if (this.f1243e != null) {
                m1087u();
            }
        }
    }

    /* renamed from: a */
    public void mo9795a(String str) {
        this.f1249k = str;
    }

    /* renamed from: b */
    public String mo9800b() {
        return this.f1249k;
    }

    /* renamed from: c */
    public void mo9804c() {
        ImageAssetManager bVar = this.f1248j;
        if (bVar != null) {
            bVar.mo9900a();
        }
    }

    /* renamed from: a */
    public boolean mo9798a(LottieComposition dVar) {
        if (this.f1243e == dVar) {
            return false;
        }
        mo9811e();
        this.f1243e = dVar;
        m1087u();
        this.f1244f.mo9948a(dVar);
        mo9808d(this.f1244f.getAnimatedFraction());
        mo9812e(this.f1245g);
        m1088v();
        Iterator it = new ArrayList(this.f1247i).iterator();
        while (it.hasNext()) {
            ((C0916a) it.next()).mo9843a(dVar);
            it.remove();
        }
        this.f1247i.clear();
        dVar.mo9917a(this.f1255q);
        return true;
    }

    /* renamed from: b */
    public void mo9803b(boolean z) {
        this.f1255q = z;
        LottieComposition dVar = this.f1243e;
        if (dVar != null) {
            dVar.mo9917a(z);
        }
    }

    /* renamed from: d */
    public PerformanceTracker mo9807d() {
        LottieComposition dVar = this.f1243e;
        if (dVar != null) {
            return dVar.mo9913a();
        }
        return null;
    }

    /* renamed from: u */
    private void m1087u() {
        this.f1253o = new CompositionLayer(this, LayerParser.m1379a(this.f1243e), this.f1243e.mo9924g(), this.f1243e);
    }

    /* renamed from: e */
    public void mo9811e() {
        mo9804c();
        if (this.f1244f.isRunning()) {
            this.f1244f.cancel();
        }
        this.f1243e = null;
        this.f1253o = null;
        this.f1248j = null;
        this.f1244f.mo9956f();
        invalidateSelf();
    }

    public void invalidateSelf() {
        Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void setAlpha(int i) {
        this.f1254p = i;
    }

    public int getAlpha() {
        return this.f1254p;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Log.w("LOTTIE", "Use addColorFilter instead.");
    }

    public void draw(Canvas canvas) {
        float f;
        String str = "Drawable#draw";
        L.m1315c(str);
        if (this.f1253o != null) {
            float f2 = this.f1245g;
            float a = m1084a(canvas);
            if (f2 > a) {
                f = this.f1245g / a;
            } else {
                a = f2;
                f = 1.0f;
            }
            int i = (f > 1.0f ? 1 : (f == 1.0f ? 0 : -1));
            if (i > 0) {
                canvas.save();
                float width = ((float) this.f1243e.mo9918b().width()) / 2.0f;
                float height = ((float) this.f1243e.mo9918b().height()) / 2.0f;
                float f3 = width * a;
                float f4 = height * a;
                canvas.translate((mo9832q() * width) - f3, (mo9832q() * height) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.f1242d.reset();
            this.f1242d.preScale(a, a);
            this.f1253o.mo9847a(canvas, this.f1242d, this.f1254p);
            L.m1316d(str);
            if (i > 0) {
                canvas.restore();
            }
        }
    }

    public void start() {
        mo9814f();
    }

    public void stop() {
        mo9815g();
    }

    public boolean isRunning() {
        return mo9829n();
    }

    /* renamed from: f */
    public void mo9814f() {
        if (this.f1253o == null) {
            this.f1247i.add(new C0916a() {
                /* renamed from: a */
                public void mo9843a(LottieComposition dVar) {
                    LottieDrawable.this.mo9814f();
                }
            });
        } else {
            this.f1244f.mo9962i();
        }
    }

    /* renamed from: g */
    public void mo9815g() {
        this.f1247i.clear();
        this.f1244f.mo9964j();
    }

    /* renamed from: a */
    public void mo9789a(final int i) {
        if (this.f1243e == null) {
            this.f1247i.add(new C0916a() {
                /* renamed from: a */
                public void mo9843a(LottieComposition dVar) {
                    LottieDrawable.this.mo9789a(i);
                }
            });
        } else {
            this.f1244f.mo9949b(i);
        }
    }

    /* renamed from: h */
    public float mo9820h() {
        return this.f1244f.mo9965k();
    }

    /* renamed from: a */
    public void mo9788a(final float f) {
        LottieComposition dVar = this.f1243e;
        if (dVar == null) {
            this.f1247i.add(new C0916a() {
                /* renamed from: a */
                public void mo9843a(LottieComposition dVar) {
                    LottieDrawable.this.mo9788a(f);
                }
            });
        } else {
            mo9789a((int) MiscUtils.m1440a(dVar.mo9921d(), this.f1243e.mo9922e(), f));
        }
    }

    /* renamed from: b */
    public void mo9802b(final int i) {
        if (this.f1243e == null) {
            this.f1247i.add(new C0916a() {
                /* renamed from: a */
                public void mo9843a(LottieComposition dVar) {
                    LottieDrawable.this.mo9802b(i);
                }
            });
        } else {
            this.f1244f.mo9950c(i);
        }
    }

    /* renamed from: i */
    public float mo9821i() {
        return this.f1244f.mo9966l();
    }

    /* renamed from: b */
    public void mo9801b(final float f) {
        LottieComposition dVar = this.f1243e;
        if (dVar == null) {
            this.f1247i.add(new C0916a() {
                /* renamed from: a */
                public void mo9843a(LottieComposition dVar) {
                    LottieDrawable.this.mo9801b(f);
                }
            });
        } else {
            mo9802b((int) MiscUtils.m1440a(dVar.mo9921d(), this.f1243e.mo9922e(), f));
        }
    }

    /* renamed from: c */
    public void mo9805c(float f) {
        this.f1244f.mo9945a(f);
    }

    /* renamed from: j */
    public float mo9825j() {
        return this.f1244f.mo9961h();
    }

    /* renamed from: a */
    public void mo9790a(AnimatorListener animatorListener) {
        this.f1244f.addListener(animatorListener);
    }

    /* renamed from: c */
    public void mo9806c(final int i) {
        if (this.f1243e == null) {
            this.f1247i.add(new C0916a() {
                /* renamed from: a */
                public void mo9843a(LottieComposition dVar) {
                    LottieDrawable.this.mo9806c(i);
                }
            });
        } else {
            this.f1244f.mo9946a(i);
        }
    }

    /* renamed from: k */
    public int mo9826k() {
        return (int) this.f1244f.mo9955e();
    }

    /* renamed from: d */
    public void mo9808d(final float f) {
        LottieComposition dVar = this.f1243e;
        if (dVar == null) {
            this.f1247i.add(new C0916a() {
                /* renamed from: a */
                public void mo9843a(LottieComposition dVar) {
                    LottieDrawable.this.mo9808d(f);
                }
            });
        } else {
            mo9806c((int) MiscUtils.m1440a(dVar.mo9921d(), this.f1243e.mo9922e(), f));
        }
    }

    /* renamed from: d */
    public void mo9809d(int i) {
        this.f1244f.setRepeatMode(i);
    }

    /* renamed from: l */
    public int mo9827l() {
        return this.f1244f.getRepeatMode();
    }

    /* renamed from: e */
    public void mo9813e(int i) {
        this.f1244f.setRepeatCount(i);
    }

    /* renamed from: m */
    public int mo9828m() {
        return this.f1244f.getRepeatCount();
    }

    /* renamed from: n */
    public boolean mo9829n() {
        return this.f1244f.isRunning();
    }

    /* renamed from: e */
    public void mo9812e(float f) {
        this.f1245g = f;
        m1088v();
    }

    /* renamed from: a */
    public void mo9792a(ImageAssetDelegate bVar) {
        this.f1250l = bVar;
        ImageAssetManager bVar2 = this.f1248j;
        if (bVar2 != null) {
            bVar2.mo9901a(bVar);
        }
    }

    /* renamed from: a */
    public void mo9791a(FontAssetDelegate aVar) {
        this.f1240a = aVar;
        FontAssetManager aVar2 = this.f1251m;
        if (aVar2 != null) {
            aVar2.mo9898a(aVar);
        }
    }

    /* renamed from: a */
    public void mo9793a(TextDelegate mVar) {
        this.f1241b = mVar;
    }

    /* renamed from: o */
    public TextDelegate mo9830o() {
        return this.f1241b;
    }

    /* renamed from: p */
    public boolean mo9831p() {
        return this.f1241b == null && this.f1243e.mo9925h().size() > 0;
    }

    /* renamed from: q */
    public float mo9832q() {
        return this.f1245g;
    }

    /* renamed from: r */
    public LottieComposition mo9833r() {
        return this.f1243e;
    }

    /* renamed from: v */
    private void m1088v() {
        if (this.f1243e != null) {
            float q = mo9832q();
            setBounds(0, 0, (int) (((float) this.f1243e.mo9918b().width()) * q), (int) (((float) this.f1243e.mo9918b().height()) * q));
        }
    }

    /* renamed from: s */
    public void mo9834s() {
        this.f1247i.clear();
        this.f1244f.cancel();
    }

    /* renamed from: t */
    public float mo9840t() {
        return this.f1244f.mo9953d();
    }

    public int getIntrinsicWidth() {
        LottieComposition dVar = this.f1243e;
        if (dVar == null) {
            return -1;
        }
        return (int) (((float) dVar.mo9918b().width()) * mo9832q());
    }

    public int getIntrinsicHeight() {
        LottieComposition dVar = this.f1243e;
        if (dVar == null) {
            return -1;
        }
        return (int) (((float) dVar.mo9918b().height()) * mo9832q());
    }

    /* renamed from: a */
    public List<KeyPath> mo9787a(KeyPath eVar) {
        if (this.f1253o == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.f1253o.mo9849a(eVar, 0, (List) arrayList, new KeyPath(new String[0]));
        return arrayList;
    }

    /* renamed from: a */
    public <T> void mo9794a(final KeyPath eVar, final T t, final LottieValueCallback<T> cVar) {
        if (this.f1253o == null) {
            this.f1247i.add(new C0916a() {
                /* renamed from: a */
                public void mo9843a(LottieComposition dVar) {
                    LottieDrawable.this.mo9794a(eVar, t, cVar);
                }
            });
            return;
        }
        boolean z = true;
        if (eVar.mo10122a() != null) {
            eVar.mo10122a().mo9850a(t, cVar);
        } else {
            List a = mo9787a(eVar);
            for (int i = 0; i < a.size(); i++) {
                ((KeyPath) a.get(i)).mo10122a().mo9850a(t, cVar);
            }
            z = true ^ a.isEmpty();
        }
        if (z) {
            invalidateSelf();
            if (t == LottieProperty.f1546w) {
                mo9808d(mo9840t());
            }
        }
    }

    /* renamed from: b */
    public Bitmap mo9799b(String str) {
        ImageAssetManager w = m1089w();
        if (w != null) {
            return w.mo9899a(str);
        }
        return null;
    }

    /* renamed from: w */
    private ImageAssetManager m1089w() {
        if (getCallback() == null) {
            return null;
        }
        ImageAssetManager bVar = this.f1248j;
        if (bVar != null && !bVar.mo9902a(m1091y())) {
            this.f1248j.mo9900a();
            this.f1248j = null;
        }
        if (this.f1248j == null) {
            this.f1248j = new ImageAssetManager(getCallback(), this.f1249k, this.f1250l, this.f1243e.mo9927j());
        }
        return this.f1248j;
    }

    /* renamed from: a */
    public Typeface mo9786a(String str, String str2) {
        FontAssetManager x = m1090x();
        if (x != null) {
            return x.mo9897a(str, str2);
        }
        return null;
    }

    /* renamed from: x */
    private FontAssetManager m1090x() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f1251m == null) {
            this.f1251m = new FontAssetManager(getCallback(), this.f1240a);
        }
        return this.f1251m;
    }

    /* renamed from: y */
    private Context m1091y() {
        Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    public void invalidateDrawable(Drawable drawable) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    /* renamed from: a */
    private float m1084a(Canvas canvas) {
        return Math.min(((float) canvas.getWidth()) / ((float) this.f1243e.mo9918b().width()), ((float) canvas.getHeight()) / ((float) this.f1243e.mo9918b().height()));
    }
}
