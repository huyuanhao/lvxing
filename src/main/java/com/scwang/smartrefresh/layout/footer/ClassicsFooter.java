package com.scwang.smartrefresh.layout.footer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.ArrowDrawable;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import com.scwang.smartrefresh.layout.internal.ProgressDrawable;
import com.scwang.smartrefresh.layout.p527a.RefreshFooter;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;
import com.scwang.smartrefresh.layout.p529c.DensityUtil;

public class ClassicsFooter extends InternalClassics<ClassicsFooter> implements RefreshFooter {
    /* renamed from: a */
    public static String f20860a;
    /* renamed from: b */
    public static String f20861b;
    /* renamed from: c */
    public static String f20862c;
    /* renamed from: d */
    public static String f20863d;
    /* renamed from: e */
    public static String f20864e;
    /* renamed from: f */
    public static String f20865f;
    /* renamed from: g */
    public static String f20866g;
    /* renamed from: h */
    protected boolean f20867h;

    public ClassicsFooter(Context context) {
        this(context, null);
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20867h = false;
        if (f20860a == null) {
            f20860a = context.getString(R.string.srl_footer_pulling);
        }
        if (f20861b == null) {
            f20861b = context.getString(R.string.srl_footer_release);
        }
        if (f20862c == null) {
            f20862c = context.getString(R.string.srl_footer_loading);
        }
        if (f20863d == null) {
            f20863d = context.getString(R.string.srl_footer_refreshing);
        }
        if (f20864e == null) {
            f20864e = context.getString(R.string.srl_footer_finish);
        }
        if (f20865f == null) {
            f20865f = context.getString(R.string.srl_footer_failed);
        }
        if (f20866g == null) {
            f20866g = context.getString(R.string.srl_footer_nothing);
        }
        ImageView imageView = this.f20941p;
        ImageView imageView2 = this.f20942q;
        DensityUtil bVar = new DensityUtil();
        this.f20940o.setTextColor(-10066330);
        this.f20940o.setText(isInEditMode() ? f20862c : f20860a);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClassicsFooter);
        LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
        LayoutParams layoutParams2 = (LayoutParams) imageView2.getLayoutParams();
        layoutParams2.rightMargin = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsFooter_srlDrawableMarginRight, bVar.mo30968b(20.0f));
        layoutParams.rightMargin = layoutParams2.rightMargin;
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableArrowSize, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableArrowSize, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableProgressSize, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableProgressSize, layoutParams2.height);
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, layoutParams2.height);
        this.f20950y = obtainStyledAttributes.getInt(R.styleable.ClassicsFooter_srlFinishDuration, this.f20950y);
        this.f20937ab = SpinnerStyle.values()[obtainStyledAttributes.getInt(R.styleable.ClassicsFooter_srlClassicsSpinnerStyle, this.f20937ab.ordinal())];
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlDrawableArrow)) {
            this.f20941p.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.ClassicsFooter_srlDrawableArrow));
        } else {
            this.f20945t = new ArrowDrawable();
            this.f20945t.mo31011c(-10066330);
            this.f20941p.setImageDrawable(this.f20945t);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlDrawableProgress)) {
            this.f20942q.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.ClassicsFooter_srlDrawableProgress));
        } else {
            this.f20946u = new ProgressDrawable();
            this.f20946u.mo31011c(-10066330);
            this.f20942q.setImageDrawable(this.f20946u);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextSizeTitle)) {
            this.f20940o.setTextSize(0, (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsFooter_srlTextSizeTitle, DensityUtil.m25572a(16.0f)));
        } else {
            this.f20940o.setTextSize(16.0f);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlPrimaryColor)) {
            mo31007c(obtainStyledAttributes.getColor(R.styleable.ClassicsFooter_srlPrimaryColor, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlAccentColor)) {
            mo30992b(obtainStyledAttributes.getColor(R.styleable.ClassicsFooter_srlAccentColor, 0));
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: b */
    public void mo30679b(RefreshLayout jVar, int i, int i2) {
        if (!this.f20867h) {
            super.mo30679b(jVar, i, i2);
        }
    }

    /* renamed from: a */
    public int mo30670a(RefreshLayout jVar, boolean z) {
        if (this.f20867h) {
            return 0;
        }
        this.f20940o.setText(z ? f20864e : f20865f);
        return super.mo30670a(jVar, z);
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (this.f20937ab == SpinnerStyle.FixedBehind) {
            super.setPrimaryColors(iArr);
        }
    }

    /* renamed from: a */
    public boolean mo30950a(boolean z) {
        if (this.f20867h != z) {
            this.f20867h = z;
            ImageView imageView = this.f20941p;
            if (z) {
                this.f20940o.setText(f20866g);
                imageView.setVisibility(8);
            } else {
                this.f20940o.setText(f20860a);
                imageView.setVisibility(0);
            }
        }
        return true;
    }

    /* renamed from: a */
    public void mo30678a(RefreshLayout jVar, RefreshState refreshState, RefreshState refreshState2) {
        ImageView imageView = this.f20941p;
        if (!this.f20867h) {
            switch (refreshState2) {
                case None:
                    imageView.setVisibility(0);
                    break;
                case PullUpToLoad:
                    break;
                case Loading:
                case LoadReleased:
                    imageView.setVisibility(8);
                    this.f20940o.setText(f20862c);
                    return;
                case ReleaseToLoad:
                    this.f20940o.setText(f20861b);
                    imageView.animate().rotation(0.0f);
                    return;
                case Refreshing:
                    this.f20940o.setText(f20863d);
                    imageView.setVisibility(8);
                    return;
                default:
                    return;
            }
            this.f20940o.setText(f20860a);
            imageView.animate().rotation(180.0f);
        }
    }
}
