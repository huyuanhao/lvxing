package com.jiayouya.travel.module.common.widget.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader.TileMode;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.core.content.ContextCompat;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.GloblaEx;

public class CustomLinePagerIndicator extends LinePagerIndicatorEx {
    /* renamed from: a */
    private int f11360a;
    /* renamed from: b */
    private int f11361b;

    public CustomLinePagerIndicator(Context context) {
        super(context);
        m13619a(context);
    }

    /* renamed from: a */
    private void m13619a(Context context) {
        this.f11360a = ContextCompat.getColor(context, R.color.green_start);
        this.f11361b = ContextCompat.getColor(context, R.color.green_end);
        setMode(1);
        setLineHeight((float) GloblaEx.m12810a(3.0f));
        setRoundRadius((float) GloblaEx.m12810a(1.5f));
        setStartInterpolator(new AccelerateInterpolator());
        setEndInterpolator(new DecelerateInterpolator(2.0f));
    }

    public void setStartColor(int i) {
        this.f11360a = i;
    }

    public void setEndColor(int i) {
        this.f11361b = i;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        LinearGradient linearGradient = new LinearGradient(getLineRect().left, getLineRect().top, getLineRect().right, getLineRect().bottom, this.f11360a, this.f11361b, TileMode.CLAMP);
        getPaint().setShader(linearGradient);
        canvas.drawRoundRect(getLineRect(), getRoundRadius(), getRoundRadius(), getPaint());
    }
}
