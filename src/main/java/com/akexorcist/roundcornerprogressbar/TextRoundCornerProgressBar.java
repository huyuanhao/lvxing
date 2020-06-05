package com.akexorcist.roundcornerprogressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.akexorcist.roundcornerprogressbar.common.BaseRoundCornerProgressBar;

public class TextRoundCornerProgressBar extends BaseRoundCornerProgressBar implements OnGlobalLayoutListener {
    /* renamed from: a */
    private TextView f1797a;
    /* renamed from: b */
    private int f1798b;
    /* renamed from: c */
    private int f1799c;
    /* renamed from: d */
    private int f1800d;
    /* renamed from: e */
    private String f1801e;

    /* renamed from: com.akexorcist.roundcornerprogressbar.TextRoundCornerProgressBar$SavedState */
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
        int f1802a;
        /* renamed from: b */
        int f1803b;
        /* renamed from: c */
        int f1804c;
        /* renamed from: d */
        String f1805d;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f1802a = parcel.readInt();
            this.f1803b = parcel.readInt();
            this.f1804c = parcel.readInt();
            this.f1805d = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1802a);
            parcel.writeInt(this.f1803b);
            parcel.writeInt(this.f1804c);
            parcel.writeString(this.f1805d);
        }
    }

    public TextRoundCornerProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TextRoundCornerProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo10176a() {
        return R.layout.layout_text_round_corner_progress_bar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10177a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TextRoundCornerProgress);
        this.f1798b = obtainStyledAttributes.getColor(R.styleable.TextRoundCornerProgress_rcTextProgressColor, -1);
        this.f1799c = (int) obtainStyledAttributes.getDimension(R.styleable.TextRoundCornerProgress_rcTextProgressSize, mo10225a(16.0f));
        this.f1800d = (int) obtainStyledAttributes.getDimension(R.styleable.TextRoundCornerProgress_rcTextProgressMargin, mo10225a(10.0f));
        this.f1801e = obtainStyledAttributes.getString(R.styleable.TextRoundCornerProgress_rcTextProgress);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo10179b() {
        this.f1797a = (TextView) findViewById(R.id.tv_progress);
        this.f1797a.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10178a(LinearLayout linearLayout, float f, float f2, float f3, int i, int i2, int i3, boolean z) {
        GradientDrawable a = mo10226a(i3);
        float f4 = (float) (i - (i2 / 2));
        a.setCornerRadii(new float[]{f4, f4, f4, f4, f4, f4, f4, f4});
        if (VERSION.SDK_INT >= 16) {
            linearLayout.setBackground(a);
        } else {
            linearLayout.setBackgroundDrawable(a);
        }
        int i4 = (int) ((f3 - ((float) (i2 * 2))) / (f / f2));
        LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.width = i4;
        linearLayout.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo10180c() {
        m1769f();
        m1771h();
        m1772i();
        m1773j();
        m1770g();
    }

    /* renamed from: f */
    private void m1769f() {
        this.f1797a.setText(this.f1801e);
    }

    /* renamed from: g */
    private void m1770g() {
        this.f1797a.setTextColor(this.f1798b);
    }

    /* renamed from: h */
    private void m1771h() {
        this.f1797a.setTextSize(0, (float) this.f1799c);
    }

    /* renamed from: i */
    private void m1772i() {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1797a.getLayoutParams();
        int i = this.f1800d;
        marginLayoutParams.setMargins(i, 0, i, 0);
        this.f1797a.setLayoutParams(marginLayoutParams);
    }

    /* renamed from: j */
    private void m1773j() {
        m1774k();
        if (this.f1797a.getMeasuredWidth() + (getTextProgressMargin() * 2) + this.f1800d < ((int) ((getLayoutWidth() - ((float) (getPadding() * 2))) / (getMax() / getProgress())))) {
            m1775l();
        } else {
            m1776m();
        }
    }

    /* renamed from: k */
    private void m1774k() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f1797a.getLayoutParams();
        layoutParams.addRule(5, 0);
        layoutParams.addRule(7, 0);
        layoutParams.addRule(0, 0);
        layoutParams.addRule(1, 0);
        if (VERSION.SDK_INT >= 17) {
            layoutParams.removeRule(16);
            layoutParams.removeRule(17);
            layoutParams.removeRule(18);
            layoutParams.removeRule(19);
        }
        this.f1797a.setLayoutParams(layoutParams);
    }

    /* renamed from: l */
    private void m1775l() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f1797a.getLayoutParams();
        if (mo10230e()) {
            layoutParams.addRule(5, R.id.layout_progress);
            if (VERSION.SDK_INT >= 17) {
                layoutParams.addRule(18, R.id.layout_progress);
            }
        } else {
            layoutParams.addRule(7, R.id.layout_progress);
            if (VERSION.SDK_INT >= 17) {
                layoutParams.addRule(19, R.id.layout_progress);
            }
        }
        this.f1797a.setLayoutParams(layoutParams);
    }

    /* renamed from: m */
    private void m1776m() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f1797a.getLayoutParams();
        if (mo10230e()) {
            layoutParams.addRule(0, R.id.layout_progress);
            if (VERSION.SDK_INT >= 17) {
                layoutParams.addRule(16, R.id.layout_progress);
            }
        } else {
            layoutParams.addRule(1, R.id.layout_progress);
            if (VERSION.SDK_INT >= 17) {
                layoutParams.addRule(17, R.id.layout_progress);
            }
        }
        this.f1797a.setLayoutParams(layoutParams);
    }

    public String getProgressText() {
        return this.f1801e;
    }

    public void setProgressText(String str) {
        this.f1801e = str;
        m1769f();
        m1773j();
    }

    public void setProgress(float f) {
        super.setProgress(f);
        m1773j();
    }

    public int getTextProgressColor() {
        return this.f1798b;
    }

    public void setTextProgressColor(int i) {
        this.f1798b = i;
        m1770g();
    }

    public int getTextProgressSize() {
        return this.f1799c;
    }

    public void setTextProgressSize(int i) {
        this.f1799c = i;
        m1771h();
        m1773j();
    }

    public int getTextProgressMargin() {
        return this.f1800d;
    }

    public void setTextProgressMargin(int i) {
        this.f1800d = i;
        m1772i();
        m1773j();
    }

    public void onGlobalLayout() {
        if (VERSION.SDK_INT >= 16) {
            this.f1797a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        } else {
            this.f1797a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
        m1773j();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1802a = this.f1798b;
        savedState.f1803b = this.f1799c;
        savedState.f1804c = this.f1800d;
        savedState.f1805d = this.f1801e;
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
        this.f1798b = savedState.f1802a;
        this.f1799c = savedState.f1803b;
        this.f1800d = savedState.f1804c;
        this.f1801e = savedState.f1805d;
    }
}
