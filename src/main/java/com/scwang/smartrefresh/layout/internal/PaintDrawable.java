package com.scwang.smartrefresh.layout.internal;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;

/* renamed from: com.scwang.smartrefresh.layout.internal.b */
public abstract class PaintDrawable extends Drawable {
    /* renamed from: m */
    protected Paint f20955m = new Paint();

    public int getOpacity() {
        return -3;
    }

    protected PaintDrawable() {
        this.f20955m.setStyle(Style.FILL);
        this.f20955m.setAntiAlias(true);
        this.f20955m.setColor(-5592406);
    }

    /* renamed from: c */
    public void mo31011c(int i) {
        this.f20955m.setColor(i);
    }

    public void setAlpha(int i) {
        this.f20955m.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f20955m.setColorFilter(colorFilter);
    }
}
