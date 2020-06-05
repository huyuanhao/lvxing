package com.scwang.smartrefresh.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import androidx.core.graphics.ColorUtils;
import com.scwang.smartrefresh.header.internal.pathview.PathsDrawable;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.p527a.RefreshHeader;
import com.scwang.smartrefresh.layout.p527a.RefreshKernel;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;
import com.scwang.smartrefresh.layout.p529c.DensityUtil;
import com.tencent.bugly.beta.tinker.TinkerReport;

public class DropBoxHeader extends InternalAbstract implements RefreshHeader {
    /* renamed from: a */
    protected static String[] f20369a = {"M3 2h18v20h-18z", "m4,1c-1.105,0 -2,0.895 -2,2v3,11 3,1c0,1.105 0.895,2 2,2h2,12 2c1.105,0 2,-0.895 2,-2v-1,-3 -11,-3c0,-1.105 -0.895,-2 -2,-2h-2,-12 -2zM3.5,3h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,3h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,6h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,6h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,9h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,9h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,12h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,12h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,15h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,15h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,18h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,18h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5z"};
    /* renamed from: b */
    protected static int[] f20370b = {-1249039, -245496};
    /* renamed from: c */
    protected static String[] f20371c = {"M49,16.5l-14,-14l-27,0l0,53l41,0z", "m16,23.5h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1L16,21.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1z", "m16,15.5h10c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1L16,13.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1z", "M41,29.5L16,29.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M41,37.5L16,37.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M41,45.5L16,45.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M49,16.5l-14,-14l0,14z"};
    /* renamed from: d */
    protected static int[] f20372d = {-76695, -2773417};
    /* renamed from: e */
    protected static String[] f20373e = {"M6.021,2.188L6.021,11.362C5.46,11.327 4.843,11.414 4.229,11.663C2.624,12.312 1.696,13.729 2.155,14.825C2.62,15.924 4.294,16.284 5.898,15.634C7.131,15.134 7.856,14.184 7.965,13.272L7.958,4.387L15.02,3.028L15.02,9.406C14.422,9.343 13.746,9.432 13.076,9.703C11.471,10.353 10.544,11.77 11.004,12.866C11.467,13.964 13.141,14.325 14.746,13.675C15.979,13.174 16.836,12.224 16.947,11.313L16.958,0.002L6.021,2.188L6.021,2.188Z"};
    /* renamed from: f */
    protected static int[] f20374f = {-6760607};
    /* renamed from: g */
    protected Path f20375g;
    /* renamed from: h */
    protected Paint f20376h;
    /* renamed from: i */
    protected C6449a f20377i;
    /* renamed from: j */
    protected int f20378j;
    /* renamed from: k */
    protected int f20379k;
    /* renamed from: l */
    protected boolean f20380l;
    /* renamed from: m */
    protected Drawable f20381m;
    /* renamed from: n */
    protected Drawable f20382n;
    /* renamed from: o */
    protected Drawable f20383o;
    /* renamed from: p */
    protected float f20384p;
    /* renamed from: q */
    protected float f20385q;
    /* renamed from: r */
    protected ValueAnimator f20386r;
    /* renamed from: s */
    protected ValueAnimator f20387s;
    /* renamed from: t */
    protected RefreshState f20388t;

    /* renamed from: com.scwang.smartrefresh.header.DropBoxHeader$a */
    private static class C6449a {
        /* renamed from: a */
        int f20393a;
        /* renamed from: b */
        int f20394b;
        /* renamed from: c */
        int f20395c;
        /* renamed from: d */
        int f20396d;
        /* renamed from: e */
        int f20397e;
        /* renamed from: f */
        int f20398f;
        /* renamed from: g */
        int f20399g;
        /* renamed from: h */
        int f20400h;
        /* renamed from: i */
        int f20401i;

        private C6449a() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C6449a mo30688a(int i, int i2, int i3, int i4) {
            this.f20401i = i3;
            this.f20393a = i / 2;
            this.f20395c = i2 - i4;
            this.f20396d = this.f20395c - (i3 * 2);
            this.f20397e = this.f20393a - ((int) (((double) i3) * Math.sin(1.0471975511965976d)));
            int i5 = i3 / 2;
            this.f20398f = this.f20396d + i5;
            int i6 = this.f20395c;
            this.f20399g = i6 - i5;
            this.f20400h = i - this.f20397e;
            this.f20394b = i6 - i3;
            return this;
        }
    }

    public DropBoxHeader(Context context) {
        this(context, null);
    }

    public DropBoxHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DropBoxHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20375g = new Path();
        this.f20376h = new Paint();
        this.f20377i = new C6449a();
        this.f20376h.setAntiAlias(true);
        this.f20378j = -9524737;
        setBackgroundColor(-14141883);
        setMinimumHeight(DensityUtil.m25572a(150.0f));
        this.f20937ab = SpinnerStyle.Scale;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DropBoxHeader);
        if (obtainStyledAttributes.hasValue(R.styleable.DropBoxHeader_dhDrawable1)) {
            this.f20381m = obtainStyledAttributes.getDrawable(R.styleable.DropBoxHeader_dhDrawable1);
        } else {
            PathsDrawable bVar = new PathsDrawable();
            bVar.mo30807a(f20370b);
            if (!bVar.mo30809a(f20369a)) {
                bVar.mo30806a(2, 1, 20, 22);
            }
            this.f20381m = bVar;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.DropBoxHeader_dhDrawable2)) {
            this.f20382n = obtainStyledAttributes.getDrawable(R.styleable.DropBoxHeader_dhDrawable2);
        } else {
            PathsDrawable bVar2 = new PathsDrawable();
            bVar2.mo30807a(f20372d);
            if (!bVar2.mo30809a(f20371c)) {
                bVar2.mo30806a(8, 3, 41, 53);
            }
            this.f20382n = bVar2;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.DropBoxHeader_dhDrawable3)) {
            this.f20383o = obtainStyledAttributes.getDrawable(R.styleable.DropBoxHeader_dhDrawable3);
        } else {
            PathsDrawable bVar3 = new PathsDrawable();
            bVar3.mo30807a(f20374f);
            if (!bVar3.mo30809a(f20373e)) {
                bVar3.mo30806a(2, 0, 15, 16);
            }
            this.f20383o = bVar3;
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        this.f20386r = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f, 0.0f});
        this.f20386r.setInterpolator(accelerateInterpolator);
        this.f20386r.setDuration(300);
        this.f20386r.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                DropBoxHeader dropBoxHeader = DropBoxHeader.this;
                dropBoxHeader.f20385q = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                dropBoxHeader.invalidate();
            }
        });
        this.f20386r.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (DropBoxHeader.this.f20388t != RefreshState.Refreshing) {
                    DropBoxHeader.this.f20384p = 0.0f;
                } else if (DropBoxHeader.this.f20387s != null) {
                    DropBoxHeader.this.f20387s.start();
                }
            }
        });
        this.f20387s = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f20387s.setInterpolator(accelerateInterpolator);
        this.f20387s.setDuration(300);
        this.f20387s.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (DropBoxHeader.this.f20384p < 1.0f || DropBoxHeader.this.f20384p >= 3.0f) {
                    DropBoxHeader.this.f20384p = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                } else if (DropBoxHeader.this.f20384p < 2.0f) {
                    DropBoxHeader.this.f20384p = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 1.0f;
                } else if (DropBoxHeader.this.f20384p < 3.0f) {
                    DropBoxHeader.this.f20384p = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 2.0f;
                    if (DropBoxHeader.this.f20384p == 3.0f) {
                        DropBoxHeader.this.f20380l = true;
                    }
                }
                DropBoxHeader.this.invalidate();
            }
        });
        this.f20387s.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (DropBoxHeader.this.f20386r != null) {
                    DropBoxHeader.this.f20386r.start();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f20386r;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f20386r.removeAllListeners();
            this.f20386r = null;
        }
        ValueAnimator valueAnimator2 = this.f20387s;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
            this.f20387s.removeAllListeners();
            this.f20387s = null;
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        C6449a a = m25289a(width, getHeight(), m25286a());
        this.f20376h.setColor(ColorUtils.setAlphaComponent(this.f20378j, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE));
        canvas.drawPath(m25290b(a), this.f20376h);
        this.f20376h.setColor(this.f20378j);
        canvas.drawPath(m25287a(a), this.f20376h);
        if (isInEditMode()) {
            this.f20384p = 2.5f;
        }
        if (this.f20384p > 0.0f) {
            canvas.clipPath(m25288a(a, width));
            float min = Math.min(this.f20384p, 1.0f);
            Rect bounds = this.f20381m.getBounds();
            int i = width / 2;
            bounds.offsetTo(i - (bounds.width() / 2), ((int) (((float) ((a.f20394b - (bounds.height() / 2)) + bounds.height())) * min)) - bounds.height());
            this.f20381m.draw(canvas);
            float min2 = Math.min(Math.max(this.f20384p - 1.0f, 0.0f), 1.0f);
            Rect bounds2 = this.f20382n.getBounds();
            bounds2.offsetTo(i - (bounds2.width() / 2), ((int) (((float) ((a.f20394b - (bounds2.height() / 2)) + bounds2.height())) * min2)) - bounds2.height());
            this.f20382n.draw(canvas);
            float min3 = Math.min(Math.max(this.f20384p - 2.0f, 0.0f), 1.0f);
            Rect bounds3 = this.f20383o.getBounds();
            bounds3.offsetTo(i - (bounds3.width() / 2), ((int) (((float) ((a.f20394b - (bounds3.height() / 2)) + bounds3.height())) * min3)) - bounds3.height());
            this.f20383o.draw(canvas);
            if (this.f20380l) {
                bounds.offsetTo(i - (bounds.width() / 2), a.f20394b - (bounds.height() / 2));
                this.f20381m.draw(canvas);
                bounds2.offsetTo(i - (bounds2.width() / 2), a.f20394b - (bounds2.height() / 2));
                this.f20382n.draw(canvas);
                bounds3.offsetTo(i - (bounds3.width() / 2), a.f20394b - (bounds3.height() / 2));
                this.f20383o.draw(canvas);
            }
        }
        super.dispatchDraw(canvas);
    }

    /* renamed from: a */
    private int m25286a() {
        return this.f20379k / 5;
    }

    /* renamed from: a */
    private Path m25288a(C6449a aVar, int i) {
        this.f20375g.reset();
        this.f20375g.lineTo(0.0f, (float) aVar.f20398f);
        this.f20375g.lineTo((float) aVar.f20397e, (float) aVar.f20398f);
        this.f20375g.lineTo((float) aVar.f20393a, (float) aVar.f20394b);
        this.f20375g.lineTo((float) aVar.f20400h, (float) aVar.f20398f);
        float f = (float) i;
        this.f20375g.lineTo(f, (float) aVar.f20398f);
        this.f20375g.lineTo(f, 0.0f);
        this.f20375g.close();
        return this.f20375g;
    }

    /* renamed from: a */
    private C6449a m25289a(int i, int i2, int i3) {
        return this.f20377i.mo30688a(i, i2, i3, i3 / 2);
    }

    /* renamed from: a */
    private Path m25287a(C6449a aVar) {
        this.f20375g.reset();
        double d = ((double) this.f20385q) * 1.2566370614359172d;
        float f = (float) (((aVar.f20393a - aVar.f20397e) * 4) / 5);
        double d2 = 1.0471975511965976d - (d / 2.0d);
        float sin = ((float) Math.sin(d2)) * f;
        float cos = ((float) Math.cos(d2)) * f;
        this.f20375g.moveTo((float) aVar.f20397e, (float) aVar.f20398f);
        this.f20375g.lineTo((float) aVar.f20393a, (float) aVar.f20396d);
        this.f20375g.lineTo(((float) aVar.f20393a) - sin, ((float) aVar.f20396d) - cos);
        this.f20375g.lineTo(((float) aVar.f20397e) - sin, ((float) aVar.f20398f) - cos);
        this.f20375g.close();
        double d3 = d + 1.0471975511965976d;
        float sin2 = ((float) Math.sin(d3)) * f;
        float cos2 = ((float) Math.cos(d3)) * f;
        this.f20375g.moveTo((float) aVar.f20397e, (float) aVar.f20398f);
        this.f20375g.lineTo((float) aVar.f20393a, (float) ((aVar.f20395c + aVar.f20396d) / 2));
        this.f20375g.lineTo(((float) aVar.f20393a) - sin2, ((float) ((aVar.f20395c + aVar.f20396d) / 2)) + cos2);
        this.f20375g.lineTo(((float) aVar.f20397e) - sin2, ((float) aVar.f20398f) + cos2);
        this.f20375g.close();
        float sin3 = ((float) Math.sin(d2)) * f;
        float cos3 = ((float) Math.cos(d2)) * f;
        this.f20375g.moveTo((float) aVar.f20400h, (float) aVar.f20398f);
        this.f20375g.lineTo((float) aVar.f20393a, (float) aVar.f20396d);
        this.f20375g.lineTo(((float) aVar.f20393a) + sin3, ((float) aVar.f20396d) - cos3);
        this.f20375g.lineTo(((float) aVar.f20400h) + sin3, ((float) aVar.f20398f) - cos3);
        this.f20375g.close();
        float sin4 = ((float) Math.sin(d3)) * f;
        float cos4 = f * ((float) Math.cos(d3));
        this.f20375g.moveTo((float) aVar.f20400h, (float) aVar.f20398f);
        this.f20375g.lineTo((float) aVar.f20393a, (float) ((aVar.f20395c + aVar.f20396d) / 2));
        this.f20375g.lineTo(((float) aVar.f20393a) + sin4, ((float) ((aVar.f20395c + aVar.f20396d) / 2)) + cos4);
        this.f20375g.lineTo(((float) aVar.f20400h) + sin4, ((float) aVar.f20398f) + cos4);
        this.f20375g.close();
        return this.f20375g;
    }

    /* renamed from: b */
    private Path m25290b(C6449a aVar) {
        this.f20375g.reset();
        this.f20375g.moveTo((float) aVar.f20397e, (float) aVar.f20399g);
        this.f20375g.lineTo((float) aVar.f20393a, (float) aVar.f20395c);
        this.f20375g.lineTo((float) aVar.f20400h, (float) aVar.f20399g);
        this.f20375g.quadTo(((float) aVar.f20400h) + (((float) (aVar.f20401i / 2)) * this.f20385q), (float) aVar.f20394b, (float) aVar.f20400h, (float) aVar.f20398f);
        this.f20375g.lineTo((float) aVar.f20393a, (float) aVar.f20396d);
        this.f20375g.lineTo((float) aVar.f20397e, (float) aVar.f20398f);
        this.f20375g.quadTo(((float) aVar.f20397e) - (((float) (aVar.f20401i / 2)) * this.f20385q), (float) aVar.f20394b, (float) aVar.f20397e, (float) aVar.f20399g);
        this.f20375g.close();
        return this.f20375g;
    }

    /* renamed from: a */
    public void mo30672a(boolean z, float f, int i, int i2, int i3) {
        if (!z || this.f20388t != RefreshState.Refreshing) {
            this.f20385q = (((float) Math.max(0, i - i2)) * 1.0f) / ((float) i3);
        }
    }

    /* renamed from: a */
    public void mo30678a(RefreshLayout jVar, RefreshState refreshState, RefreshState refreshState2) {
        this.f20388t = refreshState2;
        if (refreshState2 == RefreshState.None) {
            this.f20380l = false;
        }
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            setBackgroundColor(iArr[0]);
            if (iArr.length > 1) {
                this.f20378j = iArr[1];
            }
        }
    }

    /* renamed from: a */
    public void mo30677a(RefreshKernel iVar, int i, int i2) {
        this.f20379k = i;
        int a = m25286a();
        this.f20381m.setBounds(0, 0, a, a);
        this.f20382n.setBounds(0, 0, a, a);
        this.f20383o.setBounds(0, 0, a, a);
    }

    /* renamed from: b */
    public void mo30679b(RefreshLayout jVar, int i, int i2) {
        ValueAnimator valueAnimator = this.f20387s;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    /* renamed from: a */
    public int mo30670a(RefreshLayout jVar, boolean z) {
        this.f20384p = 0.0f;
        return 0;
    }
}
