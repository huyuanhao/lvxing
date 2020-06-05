package com.akexorcist.roundcornerprogressbar.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.BaseSavedState;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.akexorcist.roundcornerprogressbar.R;

public abstract class BaseRoundCornerProgressBar extends LinearLayout {
    /* renamed from: a */
    private LinearLayout f1806a;
    /* renamed from: b */
    private LinearLayout f1807b;
    /* renamed from: c */
    private LinearLayout f1808c;
    /* renamed from: d */
    private int f1809d;
    /* renamed from: e */
    private int f1810e;
    /* renamed from: f */
    private int f1811f;
    /* renamed from: g */
    private float f1812g;
    /* renamed from: h */
    private float f1813h;
    /* renamed from: i */
    private float f1814i;
    /* renamed from: j */
    private int f1815j;
    /* renamed from: k */
    private int f1816k;
    /* renamed from: l */
    private int f1817l;
    /* renamed from: m */
    private boolean f1818m;
    /* renamed from: n */
    private C0954a f1819n;

    /* renamed from: com.akexorcist.roundcornerprogressbar.common.BaseRoundCornerProgressBar$SavedState */
    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        /* renamed from: a */
        float f1821a;
        /* renamed from: b */
        float f1822b;
        /* renamed from: c */
        float f1823c;
        /* renamed from: d */
        int f1824d;
        /* renamed from: e */
        int f1825e;
        /* renamed from: f */
        int f1826f;
        /* renamed from: g */
        int f1827g;
        /* renamed from: h */
        int f1828h;
        /* renamed from: i */
        boolean f1829i;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f1821a = parcel.readFloat();
            this.f1822b = parcel.readFloat();
            this.f1823c = parcel.readFloat();
            this.f1824d = parcel.readInt();
            this.f1825e = parcel.readInt();
            this.f1826f = parcel.readInt();
            this.f1827g = parcel.readInt();
            this.f1828h = parcel.readInt();
            this.f1829i = parcel.readByte() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.f1821a);
            parcel.writeFloat(this.f1822b);
            parcel.writeFloat(this.f1823c);
            parcel.writeInt(this.f1824d);
            parcel.writeInt(this.f1825e);
            parcel.writeInt(this.f1826f);
            parcel.writeInt(this.f1827g);
            parcel.writeInt(this.f1828h);
            parcel.writeByte(this.f1829i ? (byte) 1 : 0);
        }
    }

    /* renamed from: com.akexorcist.roundcornerprogressbar.common.BaseRoundCornerProgressBar$a */
    public interface C0954a {
        /* renamed from: a */
        void mo10258a(int i, float f, boolean z, boolean z2);
    }

    /* renamed from: a */
    public abstract int mo10176a();

    /* renamed from: a */
    public abstract void mo10177a(Context context, AttributeSet attributeSet);

    /* renamed from: a */
    public abstract void mo10178a(LinearLayout linearLayout, float f, float f2, float f3, int i, int i2, int i3, boolean z);

    /* renamed from: b */
    public abstract void mo10179b();

    /* renamed from: c */
    public abstract void mo10180c();

    public BaseRoundCornerProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (isInEditMode()) {
            m1784a(context);
        } else {
            mo10227b(context, attributeSet);
        }
    }

    public BaseRoundCornerProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (isInEditMode()) {
            m1784a(context);
        } else {
            mo10227b(context, attributeSet);
        }
    }

    /* renamed from: a */
    private void m1784a(Context context) {
        setGravity(17);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LayoutParams(-1, -1));
        textView.setGravity(17);
        textView.setText(getClass().getSimpleName());
        textView.setTextColor(-1);
        textView.setBackgroundColor(-7829368);
        addView(textView);
    }

    /* renamed from: b */
    public void mo10227b(Context context, AttributeSet attributeSet) {
        mo10228c(context, attributeSet);
        removeAllViews();
        LayoutInflater.from(context).inflate(mo10176a(), this);
        this.f1806a = (LinearLayout) findViewById(R.id.layout_background);
        this.f1807b = (LinearLayout) findViewById(R.id.layout_progress);
        this.f1808c = (LinearLayout) findViewById(R.id.layout_secondary_progress);
        mo10179b();
    }

    /* renamed from: c */
    public void mo10228c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundCornerProgress);
        this.f1809d = (int) obtainStyledAttributes.getDimension(R.styleable.RoundCornerProgress_rcRadius, mo10225a(30.0f));
        this.f1810e = (int) obtainStyledAttributes.getDimension(R.styleable.RoundCornerProgress_rcBackgroundPadding, mo10225a(0.0f));
        this.f1818m = obtainStyledAttributes.getBoolean(R.styleable.RoundCornerProgress_rcReverse, false);
        this.f1812g = obtainStyledAttributes.getFloat(R.styleable.RoundCornerProgress_rcMax, 100.0f);
        this.f1813h = obtainStyledAttributes.getFloat(R.styleable.RoundCornerProgress_rcProgress, 0.0f);
        this.f1814i = obtainStyledAttributes.getFloat(R.styleable.RoundCornerProgress_rcSecondaryProgress, 0.0f);
        this.f1815j = obtainStyledAttributes.getColor(R.styleable.RoundCornerProgress_rcBackgroundColor, context.getResources().getColor(R.color.round_corner_progress_bar_background_default));
        this.f1816k = obtainStyledAttributes.getColor(R.styleable.RoundCornerProgress_rcProgressColor, context.getResources().getColor(R.color.round_corner_progress_bar_progress_default));
        this.f1817l = obtainStyledAttributes.getColor(R.styleable.RoundCornerProgress_rcSecondaryProgressColor, context.getResources().getColor(R.color.round_corner_progress_bar_secondary_progress_default));
        obtainStyledAttributes.recycle();
        mo10177a(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (!isInEditMode()) {
            this.f1811f = i;
            mo10229d();
            postDelayed(new Runnable() {
                public void run() {
                    BaseRoundCornerProgressBar.this.m1789g();
                    BaseRoundCornerProgressBar.this.m1790h();
                }
            }, 5);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo10229d() {
        m1788f();
        m1792j();
        m1791i();
        m1789g();
        m1790h();
        mo10180c();
    }

    /* renamed from: f */
    private void m1788f() {
        GradientDrawable a = mo10226a(this.f1815j);
        float f = (float) (this.f1809d - (this.f1810e / 2));
        a.setCornerRadii(new float[]{f, f, f, f, f, f, f, f});
        if (VERSION.SDK_INT >= 16) {
            this.f1806a.setBackground(a);
        } else {
            this.f1806a.setBackgroundDrawable(a);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public GradientDrawable mo10226a(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m1789g() {
        mo10178a(this.f1807b, this.f1812g, this.f1813h, (float) this.f1811f, this.f1809d, this.f1810e, this.f1816k, this.f1818m);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m1790h() {
        mo10178a(this.f1808c, this.f1812g, this.f1814i, (float) this.f1811f, this.f1809d, this.f1810e, this.f1817l, this.f1818m);
    }

    /* renamed from: i */
    private void m1791i() {
        setupReverse(this.f1807b);
        setupReverse(this.f1808c);
    }

    private void setupReverse(LinearLayout linearLayout) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        m1785a(layoutParams);
        if (this.f1818m) {
            layoutParams.addRule(11);
            if (VERSION.SDK_INT >= 17) {
                layoutParams.addRule(21);
            }
        } else {
            layoutParams.addRule(9);
            if (VERSION.SDK_INT >= 17) {
                layoutParams.addRule(20);
            }
        }
        linearLayout.setLayoutParams(layoutParams);
    }

    /* renamed from: j */
    private void m1792j() {
        LinearLayout linearLayout = this.f1806a;
        int i = this.f1810e;
        linearLayout.setPadding(i, i, i, i);
    }

    /* renamed from: a */
    private void m1785a(RelativeLayout.LayoutParams layoutParams) {
        if (VERSION.SDK_INT >= 17) {
            layoutParams.removeRule(11);
            layoutParams.removeRule(21);
            layoutParams.removeRule(9);
            layoutParams.removeRule(20);
            return;
        }
        layoutParams.addRule(11, 0);
        layoutParams.addRule(9, 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public float mo10225a(float f) {
        return (float) Math.round(f * ((float) (getContext().getResources().getDisplayMetrics().densityDpi / 160)));
    }

    /* renamed from: e */
    public boolean mo10230e() {
        return this.f1818m;
    }

    public void setReverse(boolean z) {
        this.f1818m = z;
        m1791i();
        m1789g();
        m1790h();
    }

    public int getRadius() {
        return this.f1809d;
    }

    public void setRadius(int i) {
        if (i >= 0) {
            this.f1809d = i;
        }
        m1788f();
        m1789g();
        m1790h();
    }

    public int getPadding() {
        return this.f1810e;
    }

    public void setPadding(int i) {
        if (i >= 0) {
            this.f1810e = i;
        }
        m1792j();
        m1789g();
        m1790h();
    }

    public float getMax() {
        return this.f1812g;
    }

    public void setMax(float f) {
        if (f >= 0.0f) {
            this.f1812g = f;
        }
        if (this.f1813h > f) {
            this.f1813h = f;
        }
        m1789g();
        m1790h();
    }

    public float getLayoutWidth() {
        return (float) this.f1811f;
    }

    public float getProgress() {
        return this.f1813h;
    }

    public void setProgress(float f) {
        if (f < 0.0f) {
            this.f1813h = 0.0f;
        } else {
            float f2 = this.f1812g;
            if (f > f2) {
                this.f1813h = f2;
            } else {
                this.f1813h = f;
            }
        }
        m1789g();
        C0954a aVar = this.f1819n;
        if (aVar != null) {
            aVar.mo10258a(getId(), this.f1813h, true, false);
        }
    }

    public float getSecondaryProgressWidth() {
        LinearLayout linearLayout = this.f1808c;
        if (linearLayout != null) {
            return (float) linearLayout.getWidth();
        }
        return 0.0f;
    }

    public float getSecondaryProgress() {
        return this.f1814i;
    }

    public void setSecondaryProgress(float f) {
        if (f < 0.0f) {
            this.f1814i = 0.0f;
        } else {
            float f2 = this.f1812g;
            if (f > f2) {
                this.f1814i = f2;
            } else {
                this.f1814i = f;
            }
        }
        m1790h();
        C0954a aVar = this.f1819n;
        if (aVar != null) {
            aVar.mo10258a(getId(), this.f1814i, false, true);
        }
    }

    public int getProgressBackgroundColor() {
        return this.f1815j;
    }

    public void setProgressBackgroundColor(int i) {
        this.f1815j = i;
        m1788f();
    }

    public int getProgressColor() {
        return this.f1816k;
    }

    public void setProgressColor(int i) {
        this.f1816k = i;
        m1789g();
    }

    public int getSecondaryProgressColor() {
        return this.f1817l;
    }

    public void setSecondaryProgressColor(int i) {
        this.f1817l = i;
        m1790h();
    }

    public void setOnProgressChangedListener(C0954a aVar) {
        this.f1819n = aVar;
    }

    public void invalidate() {
        super.invalidate();
        mo10229d();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1824d = this.f1809d;
        savedState.f1825e = this.f1810e;
        savedState.f1826f = this.f1815j;
        savedState.f1827g = this.f1816k;
        savedState.f1828h = this.f1817l;
        savedState.f1821a = this.f1812g;
        savedState.f1822b = this.f1813h;
        savedState.f1823c = this.f1814i;
        savedState.f1829i = this.f1818m;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f1809d = savedState.f1824d;
        this.f1810e = savedState.f1825e;
        this.f1815j = savedState.f1826f;
        this.f1816k = savedState.f1827g;
        this.f1817l = savedState.f1828h;
        this.f1812g = savedState.f1821a;
        this.f1813h = savedState.f1822b;
        this.f1814i = savedState.f1823c;
        this.f1818m = savedState.f1829i;
    }
}
