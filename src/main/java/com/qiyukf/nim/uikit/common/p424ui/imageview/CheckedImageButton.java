package com.qiyukf.nim.uikit.common.p424ui.imageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* renamed from: com.qiyukf.nim.uikit.common.ui.imageview.CheckedImageButton */
public class CheckedImageButton extends ImageButton {
    /* renamed from: a */
    private boolean f17602a;
    /* renamed from: b */
    private int f17603b;
    /* renamed from: c */
    private int f17604c;
    /* renamed from: d */
    private Drawable f17605d;
    /* renamed from: e */
    private Drawable f17606e;
    /* renamed from: f */
    private int f17607f;
    /* renamed from: g */
    private int f17608g;
    /* renamed from: h */
    private int f17609h;
    /* renamed from: i */
    private int f17610i;

    public CheckedImageButton(Context context) {
        super(context);
    }

    public CheckedImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CheckedImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: f */
    private void m22324f(int i) {
        setBackgroundResource(i);
        setPadding(this.f17607f, this.f17608g, this.f17609h, this.f17610i);
    }

    /* renamed from: a */
    public final void mo27528a(int i) {
        this.f17607f = i;
        this.f17608g = i;
        this.f17609h = i;
        this.f17610i = i;
        setPadding(this.f17607f, this.f17608g, this.f17609h, this.f17610i);
    }

    /* renamed from: a */
    public final void mo27529a(Bitmap bitmap) {
        this.f17605d = new BitmapDrawable(getResources(), bitmap);
        setImageDrawable(this.f17605d);
    }

    /* renamed from: a */
    public final void mo27530a(boolean z) {
        this.f17602a = z;
        Drawable drawable = z ? this.f17606e : this.f17605d;
        if (drawable != null) {
            setImageDrawable(drawable);
        }
        int i = z ? this.f17604c : this.f17603b;
        if (i != 0) {
            m22324f(i);
        }
    }

    /* renamed from: a */
    public final boolean mo27531a() {
        return this.f17602a;
    }

    /* renamed from: b */
    public final void mo27532b(int i) {
        this.f17603b = i;
        m22324f(i);
    }

    /* renamed from: b */
    public final void mo27533b(Bitmap bitmap) {
        this.f17606e = new BitmapDrawable(getResources(), bitmap);
    }

    /* renamed from: c */
    public final void mo27534c(int i) {
        this.f17604c = i;
    }

    /* renamed from: d */
    public final void mo27535d(int i) {
        this.f17605d = getResources().getDrawable(i);
        setImageDrawable(this.f17605d);
    }

    /* renamed from: e */
    public final void mo27536e(int i) {
        this.f17606e = getResources().getDrawable(i);
    }
}
