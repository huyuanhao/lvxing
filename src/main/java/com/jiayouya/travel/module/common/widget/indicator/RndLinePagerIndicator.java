package com.jiayouya.travel.module.common.widget.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.core.content.ContextCompat;
import com.jiayouya.travel.C2835b;
import com.jiayouya.travel.R;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0010"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/widget/indicator/RndLinePagerIndicator;", "Lcom/jiayouya/travel/module/common/widget/indicator/LinePagerIndicatorEx;", "context", "Landroid/content/Context;", "startColor", "", "endColor", "(Landroid/content/Context;II)V", "getEndColor", "()I", "getStartColor", "init", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: RndLinePagerIndicator.kt */
public final class RndLinePagerIndicator extends LinePagerIndicatorEx {
    /* renamed from: a */
    private final int f11374a;
    /* renamed from: b */
    private final int f11375b;

    public /* synthetic */ RndLinePagerIndicator(Context context, int i, int i2, int i3, DefaultConstructorMarker fVar) {
        if ((i3 & 2) != 0) {
            i = ContextCompat.getColor(C2835b.f9544a, R.color.green_start);
        }
        if ((i3 & 4) != 0) {
            i2 = ContextCompat.getColor(C2835b.f9544a, R.color.green_end);
        }
        this(context, i, i2);
    }

    public final int getStartColor() {
        return this.f11374a;
    }

    public final int getEndColor() {
        return this.f11375b;
    }

    public RndLinePagerIndicator(Context context, int i, int i2) {
        C8271i.m35386b(context, "context");
        super(context);
        this.f11374a = i;
        this.f11375b = i2;
        m13625a(context);
    }

    /* renamed from: a */
    private final void m13625a(Context context) {
        setMode(1);
        setLineHeight((float) ezy.p642a.Context.m34741a(context, 3.0f));
        setRoundRadius((float) ezy.p642a.Context.m34741a(context, 1.5f));
        setStartInterpolator(new AccelerateInterpolator());
        setEndInterpolator(new DecelerateInterpolator(2.0f));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        C8271i.m35386b(canvas, "canvas");
        LinearGradient linearGradient = new LinearGradient(getLineRect().left, getLineRect().top, getLineRect().right, getLineRect().bottom, this.f11374a, this.f11375b, TileMode.CLAMP);
        Paint paint = getPaint();
        C8271i.m35382a((Object) paint, "paint");
        paint.setShader(linearGradient);
        canvas.drawRoundRect(getLineRect(), getRoundRadius(), getRoundRadius(), getPaint());
    }
}
