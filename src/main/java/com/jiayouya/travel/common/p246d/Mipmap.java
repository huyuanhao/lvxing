package com.jiayouya.travel.common.p246d;

import android.content.res.Resources;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.SampleSizeRounding;

/* renamed from: com.jiayouya.travel.common.d.j */
public class Mipmap extends DownsampleStrategy {
    /* renamed from: a */
    public static final Mipmap f9637a = new Mipmap(1.0f);
    /* renamed from: b */
    public static final Mipmap f9638b = new Mipmap(1.5f);
    /* renamed from: c */
    public static final Mipmap f9639c = new Mipmap(2.0f);
    /* renamed from: d */
    public static final Mipmap f9640d = new Mipmap(3.0f);
    /* renamed from: e */
    public static final Mipmap f9641e = new Mipmap(4.0f);
    /* renamed from: f */
    float f9642f = 2.0f;
    /* renamed from: g */
    float f9643g = Resources.getSystem().getDisplayMetrics().density;

    Mipmap() {
    }

    Mipmap(float f) {
        this.f9642f = f;
    }

    public float getScaleFactor(int i, int i2, int i3, int i4) {
        return this.f9643g / this.f9642f;
    }

    public SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4) {
        return SampleSizeRounding.QUALITY;
    }
}
