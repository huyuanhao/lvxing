package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.UIUtils;

public class TTRatingBar extends LinearLayout {
    /* renamed from: a */
    private int f8274a = 5;
    /* renamed from: b */
    private int f8275b = 0;
    /* renamed from: c */
    private int f8276c = 0;
    /* renamed from: d */
    private float f8277d;
    /* renamed from: e */
    private float f8278e;
    /* renamed from: f */
    private float f8279f;
    /* renamed from: g */
    private Drawable f8280g;
    /* renamed from: h */
    private Drawable f8281h;
    /* renamed from: i */
    private Drawable f8282i;

    public TTRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        String str = "tt_star_empty_bg";
        this.f8280g = ResourceHelp.m11933c(context, str);
        this.f8281h = ResourceHelp.m11933c(context, "tt_star_full_bg");
        this.f8282i = ResourceHelp.m11933c(context, str);
        this.f8277d = (float) UIUtils.m12079c(context, 15.0f);
        this.f8278e = (float) UIUtils.m12079c(context, 15.0f);
        this.f8279f = (float) UIUtils.m12079c(context, 5.0f);
    }

    public int getStarFillNum() {
        return this.f8274a;
    }

    public void setStarFillNum(int i) {
        this.f8274a = i;
    }

    public int getStarHalfNum() {
        return this.f8275b;
    }

    public void setStarHalfNum(int i) {
        this.f8275b = i;
    }

    public int getStarEmptyNum() {
        return this.f8276c;
    }

    public void setStarEmptyNum(int i) {
        this.f8276c = i;
    }

    public float getStarImageWidth() {
        return this.f8277d;
    }

    public void setStarImageWidth(float f) {
        this.f8277d = f;
    }

    public float getStarImageHeight() {
        return this.f8278e;
    }

    public void setStarImageHeight(float f) {
        this.f8278e = f;
    }

    public float getStarImagePadding() {
        return this.f8279f;
    }

    public void setStarImagePadding(float f) {
        this.f8279f = f;
    }

    public Drawable getStarEmptyDrawable() {
        return this.f8280g;
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.f8280g = drawable;
    }

    public Drawable getStarFillDrawable() {
        return this.f8281h;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.f8281h = drawable;
    }

    public Drawable getStarHalfDrawable() {
        return this.f8282i;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.f8282i = drawable;
    }

    /* renamed from: a */
    public void mo16263a() {
        removeAllViews();
        for (int i = 0; i < getStarFillNum(); i++) {
            ImageView starImageView = getStarImageView();
            starImageView.setImageDrawable(getStarFillDrawable());
            addView(starImageView);
        }
        for (int i2 = 0; i2 < getStarHalfNum(); i2++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setImageDrawable(getStarHalfDrawable());
            addView(starImageView2);
        }
        for (int i3 = 0; i3 < getStarEmptyNum(); i3++) {
            ImageView starImageView3 = getStarImageView();
            starImageView3.setImageDrawable(getStarEmptyDrawable());
            addView(starImageView3);
        }
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new LayoutParams(Math.round(this.f8277d), Math.round(this.f8278e)));
        imageView.setPadding(0, 0, Math.round(this.f8279f), 0);
        return imageView;
    }
}
