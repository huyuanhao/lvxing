package com.ksad.lottie;

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
import com.ksad.lottie.model.layer.C3777b;
import com.ksad.lottie.p301b.C3663a;
import com.ksad.lottie.p301b.C3664b;
import com.ksad.lottie.p302c.C3669ac;
import com.ksad.lottie.p303d.C3706c;
import com.ksad.lottie.p303d.C3708e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.ksad.lottie.f */
public class C3721f extends Drawable implements Animatable, Callback {
    /* renamed from: c */
    private static final String f12650c = C3721f.class.getSimpleName();
    /* renamed from: a */
    C3623a f12651a;
    /* renamed from: b */
    C3741m f12652b;
    /* renamed from: d */
    private final Matrix f12653d = new Matrix();
    /* renamed from: e */
    private C3703d f12654e;
    /* access modifiers changed from: private|final */
    /* renamed from: f */
    public final C3706c f12655f = new C3706c();
    /* renamed from: g */
    private float f12656g = 1.0f;
    /* renamed from: h */
    private final Set<Object> f12657h = new HashSet();
    /* renamed from: i */
    private final ArrayList<C3730a> f12658i = new ArrayList<>();
    /* renamed from: j */
    private C3664b f12659j;
    /* renamed from: k */
    private String f12660k;
    /* renamed from: l */
    private C3662b f12661l;
    /* renamed from: m */
    private C3663a f12662m;
    /* renamed from: n */
    private boolean f12663n;
    /* access modifiers changed from: private */
    /* renamed from: o */
    public C3777b f12664o;
    /* renamed from: p */
    private int f12665p = 255;
    /* renamed from: q */
    private boolean f12666q;

    /* renamed from: com.ksad.lottie.f$a */
    private interface C3730a {
        /* renamed from: a */
        void mo23008a(C3703d dVar);
    }

    public C3721f() {
        this.f12655f.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (C3721f.this.f12664o != null) {
                    C3721f.this.f12664o.mo23168a(C3721f.this.f12655f.mo22913d());
                }
            }
        });
    }

    /* renamed from: a */
    private float m15427a(Canvas canvas) {
        return Math.min(((float) canvas.getWidth()) / ((float) this.f12654e.mo22878b().width()), ((float) canvas.getHeight()) / ((float) this.f12654e.mo22878b().height()));
    }

    /* renamed from: u */
    private void m15430u() {
        this.f12664o = new C3777b(this, C3669ac.m15265a(this.f12654e), this.f12654e.mo22884g(), this.f12654e);
    }

    /* renamed from: v */
    private void m15431v() {
        if (this.f12654e != null) {
            float q = mo22997q();
            setBounds(0, 0, (int) (((float) this.f12654e.mo22878b().width()) * q), (int) (((float) this.f12654e.mo22878b().height()) * q));
        }
    }

    /* renamed from: w */
    private C3664b m15432w() {
        if (getCallback() == null) {
            return null;
        }
        C3664b bVar = this.f12659j;
        if (bVar != null && !bVar.mo22862a(m15434y())) {
            this.f12659j.mo22860a();
            this.f12659j = null;
        }
        if (this.f12659j == null) {
            this.f12659j = new C3664b(getCallback(), this.f12660k, this.f12661l, this.f12654e.mo22887j());
        }
        return this.f12659j;
    }

    /* renamed from: x */
    private C3663a m15433x() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f12662m == null) {
            this.f12662m = new C3663a(getCallback(), this.f12651a);
        }
        return this.f12662m;
    }

    /* renamed from: y */
    private Context m15434y() {
        Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    /* renamed from: a */
    public Typeface mo22952a(String str, String str2) {
        C3663a x = m15433x();
        if (x != null) {
            return x.mo22857a(str, str2);
        }
        return null;
    }

    /* renamed from: a */
    public void mo22953a(final float f) {
        C3703d dVar = this.f12654e;
        if (dVar == null) {
            this.f12658i.add(new C3730a() {
                /* renamed from: a */
                public void mo23008a(C3703d dVar) {
                    C3721f.this.mo22953a(f);
                }
            });
        } else {
            mo22954a((int) C3708e.m15377a(dVar.mo22881d(), this.f12654e.mo22882e(), f));
        }
    }

    /* renamed from: a */
    public void mo22954a(final int i) {
        if (this.f12654e == null) {
            this.f12658i.add(new C3730a() {
                /* renamed from: a */
                public void mo23008a(C3703d dVar) {
                    C3721f.this.mo22954a(i);
                }
            });
        } else {
            this.f12655f.mo22909b(i);
        }
    }

    /* renamed from: a */
    public void mo22955a(AnimatorListener animatorListener) {
        this.f12655f.addListener(animatorListener);
    }

    /* renamed from: a */
    public void mo22956a(C3623a aVar) {
        this.f12651a = aVar;
        C3663a aVar2 = this.f12662m;
        if (aVar2 != null) {
            aVar2.mo22858a(aVar);
        }
    }

    /* renamed from: a */
    public void mo22957a(C3662b bVar) {
        this.f12661l = bVar;
        C3664b bVar2 = this.f12659j;
        if (bVar2 != null) {
            bVar2.mo22861a(bVar);
        }
    }

    /* renamed from: a */
    public void mo22958a(C3741m mVar) {
        this.f12652b = mVar;
    }

    /* renamed from: a */
    public void mo22959a(String str) {
        this.f12660k = str;
    }

    /* renamed from: a */
    public void mo22960a(boolean z) {
        if (this.f12663n != z) {
            if (VERSION.SDK_INT < 19) {
                Log.w(f12650c, "Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.f12663n = z;
            if (this.f12654e != null) {
                m15430u();
            }
        }
    }

    /* renamed from: a */
    public boolean mo22961a() {
        return this.f12663n;
    }

    /* renamed from: a */
    public boolean mo22962a(C3703d dVar) {
        if (this.f12654e == dVar) {
            return false;
        }
        mo22976e();
        this.f12654e = dVar;
        m15430u();
        this.f12655f.mo22908a(dVar);
        mo22973d(this.f12655f.getAnimatedFraction());
        mo22977e(this.f12656g);
        m15431v();
        Iterator it = new ArrayList(this.f12658i).iterator();
        while (it.hasNext()) {
            ((C3730a) it.next()).mo23008a(dVar);
            it.remove();
        }
        this.f12658i.clear();
        dVar.mo22877a(this.f12666q);
        return true;
    }

    /* renamed from: b */
    public Bitmap mo22963b(String str) {
        C3664b w = m15432w();
        if (w != null) {
            return w.mo22859a(str);
        }
        return null;
    }

    /* renamed from: b */
    public String mo22964b() {
        return this.f12660k;
    }

    /* renamed from: b */
    public void mo22965b(final float f) {
        C3703d dVar = this.f12654e;
        if (dVar == null) {
            this.f12658i.add(new C3730a() {
                /* renamed from: a */
                public void mo23008a(C3703d dVar) {
                    C3721f.this.mo22965b(f);
                }
            });
        } else {
            mo22966b((int) C3708e.m15377a(dVar.mo22881d(), this.f12654e.mo22882e(), f));
        }
    }

    /* renamed from: b */
    public void mo22966b(final int i) {
        if (this.f12654e == null) {
            this.f12658i.add(new C3730a() {
                /* renamed from: a */
                public void mo23008a(C3703d dVar) {
                    C3721f.this.mo22966b(i);
                }
            });
        } else {
            this.f12655f.mo22910c(i);
        }
    }

    /* renamed from: b */
    public void mo22967b(AnimatorListener animatorListener) {
        this.f12655f.removeListener(animatorListener);
    }

    /* renamed from: b */
    public void mo22968b(boolean z) {
        this.f12666q = z;
        C3703d dVar = this.f12654e;
        if (dVar != null) {
            dVar.mo22877a(z);
        }
    }

    /* renamed from: c */
    public void mo22969c() {
        C3664b bVar = this.f12659j;
        if (bVar != null) {
            bVar.mo22860a();
        }
    }

    /* renamed from: c */
    public void mo22970c(float f) {
        this.f12655f.mo22905a(f);
    }

    /* renamed from: c */
    public void mo22971c(final int i) {
        if (this.f12654e == null) {
            this.f12658i.add(new C3730a() {
                /* renamed from: a */
                public void mo23008a(C3703d dVar) {
                    C3721f.this.mo22971c(i);
                }
            });
        } else {
            this.f12655f.mo22906a(i);
        }
    }

    /* renamed from: d */
    public C3738l mo22972d() {
        C3703d dVar = this.f12654e;
        if (dVar != null) {
            return dVar.mo22873a();
        }
        return null;
    }

    /* renamed from: d */
    public void mo22973d(final float f) {
        C3703d dVar = this.f12654e;
        if (dVar == null) {
            this.f12658i.add(new C3730a() {
                /* renamed from: a */
                public void mo23008a(C3703d dVar) {
                    C3721f.this.mo22973d(f);
                }
            });
        } else {
            mo22971c((int) C3708e.m15377a(dVar.mo22881d(), this.f12654e.mo22882e(), f));
        }
    }

    /* renamed from: d */
    public void mo22974d(int i) {
        this.f12655f.setRepeatMode(i);
    }

    public void draw(Canvas canvas) {
        float f;
        String str = "Drawable#draw";
        C3665c.m15252c(str);
        if (this.f12664o != null) {
            float f2 = this.f12656g;
            float a = m15427a(canvas);
            if (f2 > a) {
                f = this.f12656g / a;
            } else {
                a = f2;
                f = 1.0f;
            }
            int i = (f > 1.0f ? 1 : (f == 1.0f ? 0 : -1));
            if (i > 0) {
                canvas.save();
                float width = ((float) this.f12654e.mo22878b().width()) / 2.0f;
                float height = ((float) this.f12654e.mo22878b().height()) / 2.0f;
                float f3 = width * a;
                float f4 = height * a;
                canvas.translate((mo22997q() * width) - f3, (mo22997q() * height) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.f12653d.reset();
            this.f12653d.preScale(a, a);
            this.f12664o.mo22812a(canvas, this.f12653d, this.f12665p);
            C3665c.m15253d(str);
            if (i > 0) {
                canvas.restore();
            }
        }
    }

    /* renamed from: e */
    public void mo22976e() {
        mo22969c();
        if (this.f12655f.isRunning()) {
            this.f12655f.cancel();
        }
        this.f12654e = null;
        this.f12664o = null;
        this.f12659j = null;
        this.f12655f.mo22916f();
        invalidateSelf();
    }

    /* renamed from: e */
    public void mo22977e(float f) {
        this.f12656g = f;
        m15431v();
    }

    /* renamed from: e */
    public void mo22978e(int i) {
        this.f12655f.setRepeatCount(i);
    }

    /* renamed from: f */
    public void mo22979f() {
        if (this.f12664o == null) {
            this.f12658i.add(new C3730a() {
                /* renamed from: a */
                public void mo23008a(C3703d dVar) {
                    C3721f.this.mo22979f();
                }
            });
        } else {
            this.f12655f.mo22922i();
        }
    }

    /* renamed from: g */
    public void mo22980g() {
        this.f12658i.clear();
        this.f12655f.mo22924j();
    }

    public int getAlpha() {
        return this.f12665p;
    }

    public int getIntrinsicHeight() {
        C3703d dVar = this.f12654e;
        if (dVar == null) {
            return -1;
        }
        return (int) (((float) dVar.mo22878b().height()) * mo22997q());
    }

    public int getIntrinsicWidth() {
        C3703d dVar = this.f12654e;
        if (dVar == null) {
            return -1;
        }
        return (int) (((float) dVar.mo22878b().width()) * mo22997q());
    }

    public int getOpacity() {
        return -3;
    }

    /* renamed from: h */
    public float mo22985h() {
        return this.f12655f.mo22925k();
    }

    /* renamed from: i */
    public float mo22986i() {
        return this.f12655f.mo22926l();
    }

    public void invalidateDrawable(Drawable drawable) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void invalidateSelf() {
        Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public boolean isRunning() {
        return mo22994n();
    }

    /* renamed from: j */
    public float mo22990j() {
        return this.f12655f.mo22921h();
    }

    /* renamed from: k */
    public int mo22991k() {
        return (int) this.f12655f.mo22915e();
    }

    /* renamed from: l */
    public int mo22992l() {
        return this.f12655f.getRepeatMode();
    }

    /* renamed from: m */
    public int mo22993m() {
        return this.f12655f.getRepeatCount();
    }

    /* renamed from: n */
    public boolean mo22994n() {
        return this.f12655f.isRunning();
    }

    /* renamed from: o */
    public C3741m mo22995o() {
        return this.f12652b;
    }

    /* renamed from: p */
    public boolean mo22996p() {
        return this.f12652b == null && this.f12654e.mo22885h().size() > 0;
    }

    /* renamed from: q */
    public float mo22997q() {
        return this.f12656g;
    }

    /* renamed from: r */
    public C3703d mo22998r() {
        return this.f12654e;
    }

    /* renamed from: s */
    public void mo22999s() {
        this.f12658i.clear();
        this.f12655f.cancel();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public void setAlpha(int i) {
        this.f12665p = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Log.w("LOTTIE", "Use addColorFilter instead.");
    }

    public void start() {
        mo22979f();
    }

    public void stop() {
        mo22980g();
    }

    /* renamed from: t */
    public float mo23005t() {
        return this.f12655f.mo22913d();
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }
}
