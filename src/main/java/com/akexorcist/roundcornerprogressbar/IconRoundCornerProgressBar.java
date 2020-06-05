package com.akexorcist.roundcornerprogressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.akexorcist.roundcornerprogressbar.common.BaseRoundCornerProgressBar;

public class IconRoundCornerProgressBar extends BaseRoundCornerProgressBar implements OnClickListener {
    /* renamed from: a */
    private ImageView f1774a;
    /* renamed from: b */
    private int f1775b;
    /* renamed from: c */
    private int f1776c;
    /* renamed from: d */
    private int f1777d;
    /* renamed from: e */
    private int f1778e;
    /* renamed from: f */
    private int f1779f;
    /* renamed from: g */
    private int f1780g;
    /* renamed from: h */
    private int f1781h;
    /* renamed from: i */
    private int f1782i;
    /* renamed from: j */
    private int f1783j;
    /* renamed from: k */
    private int f1784k;
    /* renamed from: l */
    private C0945a f1785l;

    /* renamed from: com.akexorcist.roundcornerprogressbar.IconRoundCornerProgressBar$SavedState */
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
        int f1786a;
        /* renamed from: b */
        int f1787b;
        /* renamed from: c */
        int f1788c;
        /* renamed from: d */
        int f1789d;
        /* renamed from: e */
        int f1790e;
        /* renamed from: f */
        int f1791f;
        /* renamed from: g */
        int f1792g;
        /* renamed from: h */
        int f1793h;
        /* renamed from: i */
        int f1794i;
        /* renamed from: j */
        int f1795j;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f1786a = parcel.readInt();
            this.f1787b = parcel.readInt();
            this.f1788c = parcel.readInt();
            this.f1789d = parcel.readInt();
            this.f1790e = parcel.readInt();
            this.f1791f = parcel.readInt();
            this.f1792g = parcel.readInt();
            this.f1793h = parcel.readInt();
            this.f1794i = parcel.readInt();
            this.f1795j = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1786a);
            parcel.writeInt(this.f1787b);
            parcel.writeInt(this.f1788c);
            parcel.writeInt(this.f1789d);
            parcel.writeInt(this.f1790e);
            parcel.writeInt(this.f1791f);
            parcel.writeInt(this.f1792g);
            parcel.writeInt(this.f1793h);
            parcel.writeInt(this.f1794i);
            parcel.writeInt(this.f1795j);
        }
    }

    /* renamed from: com.akexorcist.roundcornerprogressbar.IconRoundCornerProgressBar$a */
    public interface C0945a {
        /* renamed from: a */
        void mo10206a();
    }

    public IconRoundCornerProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public IconRoundCornerProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    public int mo10176a() {
        return R.layout.layout_icon_round_corner_progress_bar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10177a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IconRoundCornerProgress);
        this.f1775b = obtainStyledAttributes.getResourceId(R.styleable.IconRoundCornerProgress_rcIconSrc, R.mipmap.round_corner_progress_icon);
        this.f1776c = (int) obtainStyledAttributes.getDimension(R.styleable.IconRoundCornerProgress_rcIconSize, -1.0f);
        this.f1777d = (int) obtainStyledAttributes.getDimension(R.styleable.IconRoundCornerProgress_rcIconWidth, mo10225a(20.0f));
        this.f1778e = (int) obtainStyledAttributes.getDimension(R.styleable.IconRoundCornerProgress_rcIconHeight, mo10225a(20.0f));
        this.f1779f = (int) obtainStyledAttributes.getDimension(R.styleable.IconRoundCornerProgress_rcIconPadding, -1.0f);
        this.f1780g = (int) obtainStyledAttributes.getDimension(R.styleable.IconRoundCornerProgress_rcIconPaddingLeft, mo10225a(0.0f));
        this.f1781h = (int) obtainStyledAttributes.getDimension(R.styleable.IconRoundCornerProgress_rcIconPaddingRight, mo10225a(0.0f));
        this.f1782i = (int) obtainStyledAttributes.getDimension(R.styleable.IconRoundCornerProgress_rcIconPaddingTop, mo10225a(0.0f));
        this.f1783j = (int) obtainStyledAttributes.getDimension(R.styleable.IconRoundCornerProgress_rcIconPaddingBottom, mo10225a(0.0f));
        this.f1784k = obtainStyledAttributes.getColor(R.styleable.IconRoundCornerProgress_rcIconBackgroundColor, context.getResources().getColor(R.color.round_corner_progress_bar_background_default));
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo10179b() {
        this.f1774a = (ImageView) findViewById(R.id.iv_progress_icon);
        this.f1774a.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.iv_progress_icon) {
            C0945a aVar = this.f1785l;
            if (aVar != null) {
                aVar.mo10206a();
            }
        }
    }

    public void setOnIconClickListener(C0945a aVar) {
        this.f1785l = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10178a(LinearLayout linearLayout, float f, float f2, float f3, int i, int i2, int i3, boolean z) {
        LinearLayout linearLayout2 = linearLayout;
        GradientDrawable a = mo10226a(i3);
        int i4 = i - (i2 / 2);
        if (!z || f2 == f) {
            float f4 = (float) i4;
            a.setCornerRadii(new float[]{0.0f, 0.0f, f4, f4, f4, f4, 0.0f, 0.0f});
        } else {
            float f5 = (float) i4;
            a.setCornerRadii(new float[]{f5, f5, f5, f5, f5, f5, f5, f5});
        }
        if (VERSION.SDK_INT >= 16) {
            linearLayout.setBackground(a);
        } else {
            linearLayout.setBackgroundDrawable(a);
        }
        int width = (int) ((f3 - ((float) ((i2 * 2) + this.f1774a.getWidth()))) / (f / f2));
        LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.width = width;
        linearLayout.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo10180c() {
        m1751f();
        m1752g();
        m1753h();
        m1754i();
    }

    /* renamed from: f */
    private void m1751f() {
        this.f1774a.setImageResource(this.f1775b);
    }

    /* renamed from: g */
    private void m1752g() {
        int i = this.f1776c;
        if (i == -1) {
            this.f1774a.setLayoutParams(new LinearLayout.LayoutParams(this.f1777d, this.f1778e));
        } else {
            this.f1774a.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        }
    }

    /* renamed from: h */
    private void m1753h() {
        int i = this.f1779f;
        if (i == -1 || i == 0) {
            this.f1774a.setPadding(this.f1780g, this.f1782i, this.f1781h, this.f1783j);
        } else {
            this.f1774a.setPadding(i, i, i, i);
        }
        this.f1774a.invalidate();
    }

    /* renamed from: i */
    private void m1754i() {
        GradientDrawable a = mo10226a(this.f1784k);
        float radius = (float) (getRadius() - (getPadding() / 2));
        a.setCornerRadii(new float[]{radius, radius, 0.0f, 0.0f, 0.0f, 0.0f, radius, radius});
        if (VERSION.SDK_INT >= 16) {
            this.f1774a.setBackground(a);
        } else {
            this.f1774a.setBackgroundDrawable(a);
        }
    }

    public int getIconImageResource() {
        return this.f1775b;
    }

    public void setIconImageResource(int i) {
        this.f1775b = i;
        m1751f();
    }

    public int getIconSize() {
        return this.f1776c;
    }

    public void setIconSize(int i) {
        if (i >= 0) {
            this.f1776c = i;
        }
        m1752g();
    }

    public int getIconPadding() {
        return this.f1779f;
    }

    public void setIconPadding(int i) {
        if (i >= 0) {
            this.f1779f = i;
        }
        m1753h();
    }

    public int getIconPaddingLeft() {
        return this.f1780g;
    }

    public void setIconPaddingLeft(int i) {
        if (i > 0) {
            this.f1780g = i;
        }
        m1753h();
    }

    public int getIconPaddingRight() {
        return this.f1781h;
    }

    public void setIconPaddingRight(int i) {
        if (i > 0) {
            this.f1781h = i;
        }
        m1753h();
    }

    public int getIconPaddingTop() {
        return this.f1782i;
    }

    public void setIconPaddingTop(int i) {
        if (i > 0) {
            this.f1782i = i;
        }
        m1753h();
    }

    public int getIconPaddingBottom() {
        return this.f1783j;
    }

    public void setIconPaddingBottom(int i) {
        if (i > 0) {
            this.f1783j = i;
        }
        m1753h();
    }

    public int getColorIconBackground() {
        return this.f1784k;
    }

    public void setIconBackgroundColor(int i) {
        this.f1784k = i;
        m1754i();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1786a = this.f1775b;
        savedState.f1787b = this.f1776c;
        savedState.f1788c = this.f1777d;
        savedState.f1789d = this.f1778e;
        savedState.f1790e = this.f1779f;
        savedState.f1791f = this.f1780g;
        savedState.f1792g = this.f1781h;
        savedState.f1793h = this.f1782i;
        savedState.f1794i = this.f1783j;
        savedState.f1795j = this.f1784k;
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
        this.f1775b = savedState.f1786a;
        this.f1776c = savedState.f1787b;
        this.f1777d = savedState.f1788c;
        this.f1778e = savedState.f1789d;
        this.f1779f = savedState.f1790e;
        this.f1780g = savedState.f1791f;
        this.f1781h = savedState.f1792g;
        this.f1782i = savedState.f1793h;
        this.f1783j = savedState.f1794i;
        this.f1784k = savedState.f1795j;
    }
}
