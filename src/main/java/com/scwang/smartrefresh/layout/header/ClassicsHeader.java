package com.scwang.smartrefresh.layout.header;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.ArrowDrawable;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import com.scwang.smartrefresh.layout.internal.ProgressDrawable;
import com.scwang.smartrefresh.layout.p527a.RefreshHeader;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;
import com.scwang.smartrefresh.layout.p529c.DensityUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ClassicsHeader extends InternalClassics<ClassicsHeader> implements RefreshHeader {
    /* renamed from: a */
    public static String f20894a;
    /* renamed from: b */
    public static String f20895b;
    /* renamed from: c */
    public static String f20896c;
    /* renamed from: d */
    public static String f20897d;
    /* renamed from: e */
    public static String f20898e;
    /* renamed from: f */
    public static String f20899f;
    /* renamed from: g */
    public static String f20900g;
    /* renamed from: h */
    public static String f20901h;
    /* renamed from: i */
    protected String f20902i;
    /* renamed from: j */
    protected Date f20903j;
    /* renamed from: k */
    protected TextView f20904k;
    /* renamed from: l */
    protected SharedPreferences f20905l;
    /* renamed from: m */
    protected DateFormat f20906m;
    /* renamed from: n */
    protected boolean f20907n;

    public ClassicsHeader(Context context) {
        this(context, null);
    }

    public ClassicsHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClassicsHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20902i = "LAST_UPDATE_TIME";
        this.f20907n = true;
        if (f20894a == null) {
            f20894a = context.getString(R.string.srl_header_pulling);
        }
        if (f20895b == null) {
            f20895b = context.getString(R.string.srl_header_refreshing);
        }
        if (f20896c == null) {
            f20896c = context.getString(R.string.srl_header_loading);
        }
        if (f20897d == null) {
            f20897d = context.getString(R.string.srl_header_release);
        }
        if (f20898e == null) {
            f20898e = context.getString(R.string.srl_header_finish);
        }
        if (f20899f == null) {
            f20899f = context.getString(R.string.srl_header_failed);
        }
        if (f20900g == null) {
            f20900g = context.getString(R.string.srl_header_update);
        }
        if (f20901h == null) {
            f20901h = context.getString(R.string.srl_header_secondary);
        }
        this.f20904k = new TextView(context);
        this.f20904k.setTextColor(-8618884);
        this.f20906m = new SimpleDateFormat(f20900g, Locale.getDefault());
        ImageView imageView = this.f20941p;
        TextView textView = this.f20904k;
        ImageView imageView2 = this.f20942q;
        LinearLayout linearLayout = this.f20943r;
        DensityUtil bVar = new DensityUtil();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClassicsHeader);
        LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
        LayoutParams layoutParams2 = (LayoutParams) imageView2.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsHeader_srlTextTimeMarginTop, bVar.mo30968b(0.0f));
        layoutParams2.rightMargin = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsFooter_srlDrawableMarginRight, bVar.mo30968b(20.0f));
        layoutParams.rightMargin = layoutParams2.rightMargin;
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableArrowSize, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableArrowSize, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableProgressSize, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableProgressSize, layoutParams2.height);
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams2.height);
        this.f20950y = obtainStyledAttributes.getInt(R.styleable.ClassicsHeader_srlFinishDuration, this.f20950y);
        this.f20907n = obtainStyledAttributes.getBoolean(R.styleable.ClassicsHeader_srlEnableLastTime, this.f20907n);
        this.f20937ab = SpinnerStyle.values()[obtainStyledAttributes.getInt(R.styleable.ClassicsHeader_srlClassicsSpinnerStyle, this.f20937ab.ordinal())];
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlDrawableArrow)) {
            this.f20941p.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.ClassicsHeader_srlDrawableArrow));
        } else {
            this.f20945t = new ArrowDrawable();
            this.f20945t.mo31011c(-10066330);
            this.f20941p.setImageDrawable(this.f20945t);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlDrawableProgress)) {
            this.f20942q.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.ClassicsHeader_srlDrawableProgress));
        } else {
            this.f20946u = new ProgressDrawable();
            this.f20946u.mo31011c(-10066330);
            this.f20942q.setImageDrawable(this.f20946u);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextSizeTitle)) {
            this.f20940o.setTextSize(0, (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsHeader_srlTextSizeTitle, DensityUtil.m25572a(16.0f)));
        } else {
            this.f20940o.setTextSize(16.0f);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextSizeTime)) {
            this.f20904k.setTextSize(0, (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsHeader_srlTextSizeTime, DensityUtil.m25572a(12.0f)));
        } else {
            this.f20904k.setTextSize(12.0f);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlPrimaryColor)) {
            mo31007c(obtainStyledAttributes.getColor(R.styleable.ClassicsHeader_srlPrimaryColor, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlAccentColor)) {
            mo30992b(obtainStyledAttributes.getColor(R.styleable.ClassicsHeader_srlAccentColor, 0));
        }
        obtainStyledAttributes.recycle();
        textView.setId(4);
        textView.setVisibility(this.f20907n ? 0 : 8);
        linearLayout.addView(textView, layoutParams3);
        this.f20940o.setText(isInEditMode() ? f20895b : f20894a);
        try {
            if (context instanceof FragmentActivity) {
                FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
                if (supportFragmentManager != null) {
                    List fragments = supportFragmentManager.getFragments();
                    if (fragments != null && fragments.size() > 0) {
                        mo30991a(new Date());
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f20902i);
        sb.append(context.getClass().getName());
        this.f20902i = sb.toString();
        this.f20905l = context.getSharedPreferences("ClassicsHeader", 0);
        mo30991a(new Date(this.f20905l.getLong(this.f20902i, System.currentTimeMillis())));
    }

    /* renamed from: a */
    public int mo30670a(RefreshLayout jVar, boolean z) {
        if (z) {
            this.f20940o.setText(f20898e);
            if (this.f20903j != null) {
                mo30991a(new Date());
            }
        } else {
            this.f20940o.setText(f20899f);
        }
        return super.mo30670a(jVar, z);
    }

    /* renamed from: a */
    public void mo30678a(RefreshLayout jVar, RefreshState refreshState, RefreshState refreshState2) {
        ImageView imageView = this.f20941p;
        TextView textView = this.f20904k;
        int i = 8;
        switch (refreshState2) {
            case None:
                if (this.f20907n) {
                    i = 0;
                }
                textView.setVisibility(i);
                break;
            case PullDownToRefresh:
                break;
            case Refreshing:
            case RefreshReleased:
                this.f20940o.setText(f20895b);
                imageView.setVisibility(8);
                return;
            case ReleaseToRefresh:
                this.f20940o.setText(f20897d);
                imageView.animate().rotation(180.0f);
                return;
            case ReleaseToTwoLevel:
                this.f20940o.setText(f20901h);
                imageView.animate().rotation(0.0f);
                return;
            case Loading:
                imageView.setVisibility(8);
                if (this.f20907n) {
                    i = 4;
                }
                textView.setVisibility(i);
                this.f20940o.setText(f20896c);
                return;
            default:
                return;
        }
        this.f20940o.setText(f20894a);
        imageView.setVisibility(0);
        imageView.animate().rotation(0.0f);
    }

    /* renamed from: a */
    public ClassicsHeader mo30991a(Date date) {
        this.f20903j = date;
        this.f20904k.setText(this.f20906m.format(date));
        if (this.f20905l != null && !isInEditMode()) {
            this.f20905l.edit().putLong(this.f20902i, date.getTime()).apply();
        }
        return this;
    }

    /* renamed from: a */
    public ClassicsHeader mo30992b(int i) {
        this.f20904k.setTextColor((16777215 & i) | -872415232);
        return (ClassicsHeader) super.mo30992b(i);
    }
}
