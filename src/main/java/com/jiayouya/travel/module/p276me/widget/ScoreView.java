package com.jiayouya.travel.module.p276me.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.GloblaEx;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.C8187k;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u001a\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00072\b\b\u0002\u0010)\u001a\u00020\rH\u0002J\b\u0010*\u001a\u00020\u001fH\u0002J\u0018\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0014J(\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007H\u0014J\u0014\u00103\u001a\u00020\u001f2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\r05R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u00066"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/widget/ScoreView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "centerX", "centerY", "data", "", "", "dataCount", "iconPaint", "Landroid/graphics/Paint;", "mainPaint", "maxValue", "radarMargin", "radian", "radius", "scorePaint", "titlePaint", "titleSize", "titles", "", "", "[Ljava/lang/String;", "valuePaint", "draw", "", "canvas", "Landroid/graphics/Canvas;", "drawPolygon", "drawRegion", "drawScore", "drawText", "getPoint", "Landroid/graphics/Point;", "position", "percent", "init", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "setScore", "list", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ScoreView.kt */
/* renamed from: com.jiayouya.travel.module.me.widget.ScoreView */
public final class ScoreView extends View {
    /* renamed from: a */
    private final int f11780a;
    /* renamed from: b */
    private final float f11781b;
    /* renamed from: c */
    private float f11782c;
    /* renamed from: d */
    private int f11783d;
    /* renamed from: e */
    private int f11784e;
    /* renamed from: f */
    private final String[] f11785f;
    /* renamed from: g */
    private final List<Float> f11786g;
    /* renamed from: h */
    private final float f11787h;
    /* renamed from: i */
    private final int f11788i;
    /* renamed from: j */
    private final Paint f11789j;
    /* renamed from: k */
    private final Paint f11790k;
    /* renamed from: l */
    private final Paint f11791l;
    /* renamed from: m */
    private final Paint f11792m;
    /* renamed from: n */
    private final Paint f11793n;
    /* renamed from: o */
    private final int f11794o;

    public ScoreView(Context context) {
        this(context, null, 0, 6, null);
    }

    public ScoreView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ScoreView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker fVar) {
        if ((i2 & 2) != 0) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public ScoreView(Context context, AttributeSet attributeSet, int i) {
        C8271i.m35386b(context, "context");
        super(context, attributeSet, i);
        this.f11780a = 5;
        this.f11781b = (float) (6.283185307179586d / ((double) this.f11780a));
        this.f11785f = new String[]{"城市解锁", "旅行团收入", "旅伴数量", "狗合成次数", "看视频次数"};
        Float valueOf = Float.valueOf(0.0f);
        this.f11786g = C8187k.m35271b(valueOf, valueOf, valueOf, valueOf, valueOf);
        this.f11787h = 100.0f;
        this.f11788i = GloblaEx.m12810a(15.0f);
        this.f11789j = new Paint();
        this.f11790k = new Paint();
        this.f11791l = new Paint();
        this.f11792m = new Paint();
        this.f11793n = new Paint();
        this.f11794o = GloblaEx.m12817b(12.0f);
        m14290a();
    }

    /* renamed from: a */
    private final void m14290a() {
        Paint paint = this.f11789j;
        paint.setAntiAlias(true);
        paint.setColor(GloblaEx.m12811a((int) R.color.white));
        Paint paint2 = this.f11790k;
        paint2.setAntiAlias(true);
        paint2.setColor(GloblaEx.m12811a((int) R.color.green_49D26B));
        paint2.setStyle(Style.FILL);
        paint2.setShadowLayer((float) GloblaEx.m12810a(3.0f), 0.0f, 0.0f, Color.parseColor("#65DB7B"));
        Paint paint3 = this.f11791l;
        paint3.setAntiAlias(true);
        paint3.setTextSize((float) GloblaEx.m12817b(18.0f));
        paint3.setColor(GloblaEx.m12811a((int) R.color.white));
        paint3.setStyle(Style.FILL);
        paint3.setFakeBoldText(true);
        Paint paint4 = this.f11792m;
        paint4.setAntiAlias(true);
        paint4.setTextSize((float) this.f11794o);
        paint4.setColor(GloblaEx.m12811a((int) R.color.c999999));
        paint4.setStyle(Style.FILL);
        this.f11793n.setAntiAlias(true);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int min = Math.min(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
        setMeasuredDimension(min, min);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.f11782c = (float) GloblaEx.m12810a(70.0f);
        this.f11783d = i / 2;
        this.f11784e = i2 / 2;
        postInvalidate();
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void draw(Canvas canvas) {
        C8271i.m35386b(canvas, "canvas");
        super.draw(canvas);
        m14291a(canvas);
    }

    /* renamed from: a */
    private final void m14291a(Canvas canvas) {
        Path path = new Path();
        int i = this.f11780a;
        for (int i2 = 0; i2 < i; i2++) {
            float min = Math.min(((Number) this.f11786g.get(i2)).floatValue(), this.f11787h) / this.f11787h;
            int i3 = m14289a(i2, min).x;
            int i4 = m14289a(i2, min).y;
            if (i2 == 0) {
                path.moveTo((float) i3, (float) i4);
            } else {
                path.lineTo((float) i3, (float) i4);
            }
        }
        path.close();
        canvas.drawPath(path, this.f11790k);
    }

    /* renamed from: a */
    private final Point m14289a(int i, float f) {
        int i2;
        double d;
        double d2;
        double d3;
        double d4;
        int sin;
        double d5;
        double d6;
        double d7;
        double d8;
        int i3 = 0;
        if (i != 0) {
            if (i == 1) {
                float f2 = (float) 2;
                d5 = (double) f;
                i3 = (int) (((double) this.f11783d) + (((double) this.f11782c) * Math.sin((double) (this.f11781b / f2)) * d5));
                d7 = (double) this.f11784e;
                d6 = (double) this.f11782c;
                d8 = Math.cos((double) (this.f11781b / f2));
            } else if (i == 2) {
                float f3 = (float) 2;
                d5 = (double) f;
                i3 = (int) (((double) this.f11783d) - ((((double) this.f11782c) * Math.sin((double) (this.f11781b / f3))) * d5));
                d7 = (double) this.f11784e;
                d6 = (double) this.f11782c;
                d8 = Math.cos((double) (this.f11781b / f3));
            } else if (i != 3) {
                if (i != 4) {
                    i2 = 0;
                } else {
                    i3 = this.f11783d;
                    i2 = (int) (((float) this.f11784e) - (this.f11782c * f));
                }
                return new Point(i3, i2);
            } else {
                d = (double) f;
                sin = (int) (((double) this.f11783d) - ((((double) this.f11782c) * Math.sin((double) this.f11781b)) * d));
                d4 = (double) this.f11784e;
                d3 = (double) this.f11782c;
                d2 = Math.cos((double) this.f11781b);
            }
            i2 = (int) (d7 + (d6 * d8 * d5));
            return new Point(i3, i2);
        }
        d = (double) f;
        sin = (int) (((double) this.f11783d) + (((double) this.f11782c) * Math.sin((double) this.f11781b) * d));
        d4 = (double) this.f11784e;
        d3 = (double) this.f11782c;
        d2 = Math.cos((double) this.f11781b);
        i2 = (int) (d4 - ((d3 * d2) * d));
        return new Point(i3, i2);
    }

    public final void setScore(List<Float> list) {
        C8271i.m35386b(list, "list");
        this.f11786g.clear();
        this.f11786g.addAll(list);
        invalidate();
    }
}
