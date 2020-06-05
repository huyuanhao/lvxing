package com.scwang.smartrefresh.layout.internal;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import com.scwang.smartrefresh.layout.p527a.RefreshInternal;
import com.scwang.smartrefresh.layout.p527a.RefreshKernel;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;
import com.scwang.smartrefresh.layout.p529c.DensityUtil;

public abstract class InternalClassics<T extends InternalClassics> extends InternalAbstract implements RefreshInternal {
    /* renamed from: A */
    protected int f20939A;
    /* renamed from: o */
    protected TextView f20940o;
    /* renamed from: p */
    protected ImageView f20941p;
    /* renamed from: q */
    protected ImageView f20942q;
    /* renamed from: r */
    protected LinearLayout f20943r;
    /* renamed from: s */
    protected RefreshKernel f20944s;
    /* renamed from: t */
    protected ArrowDrawable f20945t;
    /* renamed from: u */
    protected ProgressDrawable f20946u;
    /* renamed from: v */
    protected Integer f20947v;
    /* renamed from: w */
    protected Integer f20948w;
    /* renamed from: x */
    protected int f20949x;
    /* renamed from: y */
    protected int f20950y;
    /* renamed from: z */
    protected int f20951z;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public T mo31006a() {
        return this;
    }

    public InternalClassics(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20950y = 500;
        this.f20951z = 20;
        this.f20939A = 20;
        this.f20937ab = SpinnerStyle.Translate;
        this.f20941p = new ImageView(context);
        this.f20942q = new ImageView(context);
        this.f20940o = new TextView(context);
        this.f20940o.setTextColor(-10066330);
        this.f20943r = new LinearLayout(context);
        this.f20943r.setGravity(1);
        this.f20943r.setOrientation(1);
        ImageView imageView = this.f20941p;
        TextView textView = this.f20940o;
        ImageView imageView2 = this.f20942q;
        LinearLayout linearLayout = this.f20943r;
        DensityUtil bVar = new DensityUtil();
        textView.setId(1);
        imageView.setId(2);
        imageView2.setId(3);
        linearLayout.setId(16908312);
        linearLayout.addView(textView, new LayoutParams(-2, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(linearLayout, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(bVar.mo30968b(20.0f), bVar.mo30968b(20.0f));
        layoutParams2.addRule(15);
        layoutParams2.addRule(0, 16908312);
        addView(imageView, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(layoutParams2);
        layoutParams3.addRule(15);
        layoutParams3.addRule(0, 16908312);
        imageView2.animate().setInterpolator(new LinearInterpolator());
        addView(imageView2, layoutParams3);
        if (getPaddingTop() == 0) {
            if (getPaddingBottom() == 0) {
                int paddingLeft = getPaddingLeft();
                int b = bVar.mo30968b(20.0f);
                this.f20951z = b;
                int paddingRight = getPaddingRight();
                int b2 = bVar.mo30968b(20.0f);
                this.f20939A = b2;
                setPadding(paddingLeft, b, paddingRight, b2);
            } else {
                int paddingLeft2 = getPaddingLeft();
                int b3 = bVar.mo30968b(20.0f);
                this.f20951z = b3;
                int paddingRight2 = getPaddingRight();
                int paddingBottom = getPaddingBottom();
                this.f20939A = paddingBottom;
                setPadding(paddingLeft2, b3, paddingRight2, paddingBottom);
            }
        } else if (getPaddingBottom() == 0) {
            int paddingLeft3 = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.f20951z = paddingTop;
            int paddingRight3 = getPaddingRight();
            int b4 = bVar.mo30968b(20.0f);
            this.f20939A = b4;
            setPadding(paddingLeft3, paddingTop, paddingRight3, b4);
        } else {
            this.f20951z = getPaddingTop();
            this.f20939A = getPaddingBottom();
        }
        if (isInEditMode()) {
            imageView.setVisibility(8);
        } else {
            imageView2.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (MeasureSpec.getMode(i2) == 1073741824) {
            setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
        } else {
            setPadding(getPaddingLeft(), this.f20951z, getPaddingRight(), this.f20939A);
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (VERSION.SDK_INT >= 14) {
            ImageView imageView = this.f20941p;
            ImageView imageView2 = this.f20942q;
            imageView.animate().cancel();
            imageView2.animate().cancel();
        }
        Drawable drawable = this.f20942q.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        }
    }

    /* renamed from: a */
    public void mo30677a(RefreshKernel iVar, int i, int i2) {
        this.f20944s = iVar;
        this.f20944s.mo30927a((RefreshInternal) this, this.f20949x);
    }

    /* renamed from: b */
    public void mo30679b(RefreshLayout jVar, int i, int i2) {
        ImageView imageView = this.f20942q;
        if (imageView.getVisibility() != 0) {
            imageView.setVisibility(0);
            Drawable drawable = this.f20942q.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            } else {
                imageView.animate().rotation(36000.0f).setDuration(100000);
            }
        }
    }

    /* renamed from: a */
    public void mo30671a(RefreshLayout jVar, int i, int i2) {
        mo30679b(jVar, i, i2);
    }

    /* renamed from: a */
    public int mo30670a(RefreshLayout jVar, boolean z) {
        ImageView imageView = this.f20942q;
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        } else {
            imageView.animate().rotation(0.0f).setDuration(0);
        }
        imageView.setVisibility(8);
        return this.f20950y;
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            if (!(getBackground() instanceof BitmapDrawable) && this.f20948w == null) {
                mo31007c(iArr[0]);
                this.f20948w = null;
            }
            if (this.f20947v == null) {
                if (iArr.length > 1) {
                    mo30992b(iArr[1]);
                }
                this.f20947v = null;
            }
        }
    }

    /* renamed from: c */
    public T mo31007c(int i) {
        Integer valueOf = Integer.valueOf(i);
        this.f20948w = valueOf;
        this.f20949x = valueOf.intValue();
        RefreshKernel iVar = this.f20944s;
        if (iVar != null) {
            iVar.mo30927a((RefreshInternal) this, this.f20948w.intValue());
        }
        return mo31006a();
    }

    /* renamed from: b */
    public T mo30992b(int i) {
        this.f20947v = Integer.valueOf(i);
        this.f20940o.setTextColor(i);
        ArrowDrawable aVar = this.f20945t;
        if (aVar != null) {
            aVar.mo31011c(i);
        }
        ProgressDrawable cVar = this.f20946u;
        if (cVar != null) {
            cVar.mo31011c(i);
        }
        return mo31006a();
    }
}
