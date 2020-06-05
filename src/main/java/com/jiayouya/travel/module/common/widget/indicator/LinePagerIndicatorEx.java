package com.jiayouya.travel.module.common.widget.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.Arrays;
import java.util.List;
import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.buildins.ArgbEvaluatorHolder;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.p695a.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.p696b.PositionData;

public class LinePagerIndicatorEx extends View implements IPagerIndicator {
    /* renamed from: a */
    private int f11362a;
    /* renamed from: b */
    private Interpolator f11363b = new LinearInterpolator();
    /* renamed from: c */
    private Interpolator f11364c = new LinearInterpolator();
    /* renamed from: d */
    private float f11365d;
    /* renamed from: e */
    private float f11366e;
    /* renamed from: f */
    private float f11367f;
    /* renamed from: g */
    private float f11368g;
    /* renamed from: h */
    private float f11369h;
    /* renamed from: i */
    private Paint f11370i;
    /* renamed from: j */
    private List<PositionData> f11371j;
    /* renamed from: k */
    private List<Integer> f11372k;
    /* renamed from: l */
    private RectF f11373l = new RectF();

    /* renamed from: a */
    public void mo20768a(int i) {
    }

    /* renamed from: b */
    public void mo20771b(int i) {
    }

    public LinePagerIndicatorEx(Context context) {
        super(context);
        m13620a(context);
    }

    /* renamed from: a */
    private void m13620a(Context context) {
        this.f11370i = new Paint(1);
        this.f11370i.setStyle(Style.FILL);
        this.f11366e = (float) UIUtil.m35640a(context, 3.0d);
        this.f11368g = (float) UIUtil.m35640a(context, 10.0d);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        RectF rectF = this.f11373l;
        float f = this.f11369h;
        canvas.drawRoundRect(rectF, f, f, this.f11370i);
    }

    /* renamed from: a */
    public void mo20769a(int i, float f, int i2) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        List<PositionData> list = this.f11371j;
        if (list != null && !list.isEmpty()) {
            List<Integer> list2 = this.f11372k;
            if (list2 != null && list2.size() > 0) {
                this.f11370i.setColor(ArgbEvaluatorHolder.m35639a(f, ((Integer) this.f11372k.get(Math.abs(i) % this.f11372k.size())).intValue(), ((Integer) this.f11372k.get(Math.abs(i + 1) % this.f11372k.size())).intValue()));
            }
            PositionData a = FragmentContainerHelper.m35616a(this.f11371j, i);
            PositionData a2 = FragmentContainerHelper.m35616a(this.f11371j, i + 1);
            int i3 = this.f11362a;
            if (i3 == 0) {
                f5 = ((float) a.f28116a) + this.f11367f;
                f4 = ((float) a2.f28116a) + this.f11367f;
                f2 = ((float) a.f28118c) - this.f11367f;
                f6 = (float) a2.f28118c;
                f7 = this.f11367f;
            } else if (i3 == 1) {
                f5 = ((float) a.f28120e) + this.f11367f;
                f4 = ((float) a2.f28120e) + this.f11367f;
                f2 = ((float) a.f28122g) - this.f11367f;
                f6 = (float) a2.f28122g;
                f7 = this.f11367f;
            } else {
                f5 = ((float) a.f28116a) + ((((float) a.mo39960a()) - this.f11368g) / 2.0f);
                f4 = ((float) a2.f28116a) + ((((float) a2.mo39960a()) - this.f11368g) / 2.0f);
                f2 = ((((float) a.mo39960a()) + this.f11368g) / 2.0f) + ((float) a.f28116a);
                f3 = ((((float) a2.mo39960a()) + this.f11368g) / 2.0f) + ((float) a2.f28116a);
                this.f11373l.left = f5 + ((f4 - f5) * this.f11363b.getInterpolation(f));
                this.f11373l.right = f2 + ((f3 - f2) * this.f11364c.getInterpolation(f));
                this.f11373l.top = (((float) getHeight()) - this.f11366e) - this.f11365d;
                this.f11373l.bottom = ((float) getHeight()) - this.f11365d;
                invalidate();
            }
            f3 = f6 - f7;
            this.f11373l.left = f5 + ((f4 - f5) * this.f11363b.getInterpolation(f));
            this.f11373l.right = f2 + ((f3 - f2) * this.f11364c.getInterpolation(f));
            this.f11373l.top = (((float) getHeight()) - this.f11366e) - this.f11365d;
            this.f11373l.bottom = ((float) getHeight()) - this.f11365d;
            invalidate();
        }
    }

    /* renamed from: a */
    public void mo20770a(List<PositionData> list) {
        this.f11371j = list;
    }

    public float getYOffset() {
        return this.f11365d;
    }

    public void setYOffset(float f) {
        this.f11365d = f;
    }

    public float getXOffset() {
        return this.f11367f;
    }

    public void setXOffset(float f) {
        this.f11367f = f;
    }

    public float getLineHeight() {
        return this.f11366e;
    }

    public void setLineHeight(float f) {
        this.f11366e = f;
    }

    public float getLineWidth() {
        return this.f11368g;
    }

    public void setLineWidth(float f) {
        this.f11368g = f;
    }

    public float getRoundRadius() {
        return this.f11369h;
    }

    public void setRoundRadius(float f) {
        this.f11369h = f;
    }

    public int getMode() {
        return this.f11362a;
    }

    public void setMode(int i) {
        if (i == 2 || i == 0 || i == 1) {
            this.f11362a = i;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("mode ");
        sb.append(i);
        sb.append(" not supported.");
        throw new IllegalArgumentException(sb.toString());
    }

    public Paint getPaint() {
        return this.f11370i;
    }

    public RectF getLineRect() {
        return this.f11373l;
    }

    public List<Integer> getColors() {
        return this.f11372k;
    }

    public void setColors(Integer... numArr) {
        this.f11372k = Arrays.asList(numArr);
    }

    public Interpolator getStartInterpolator() {
        return this.f11363b;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f11363b = interpolator;
        if (this.f11363b == null) {
            this.f11363b = new LinearInterpolator();
        }
    }

    public Interpolator getEndInterpolator() {
        return this.f11364c;
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f11364c = interpolator;
        if (this.f11364c == null) {
            this.f11364c = new LinearInterpolator();
        }
    }
}
