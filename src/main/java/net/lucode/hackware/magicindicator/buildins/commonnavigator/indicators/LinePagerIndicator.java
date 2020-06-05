package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

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

public class LinePagerIndicator extends View implements IPagerIndicator {
    /* renamed from: a */
    private int f28137a;
    /* renamed from: b */
    private Interpolator f28138b = new LinearInterpolator();
    /* renamed from: c */
    private Interpolator f28139c = new LinearInterpolator();
    /* renamed from: d */
    private float f28140d;
    /* renamed from: e */
    private float f28141e;
    /* renamed from: f */
    private float f28142f;
    /* renamed from: g */
    private float f28143g;
    /* renamed from: h */
    private float f28144h;
    /* renamed from: i */
    private Paint f28145i;
    /* renamed from: j */
    private List<PositionData> f28146j;
    /* renamed from: k */
    private List<Integer> f28147k;
    /* renamed from: l */
    private RectF f28148l = new RectF();

    /* renamed from: a */
    public void mo20768a(int i) {
    }

    /* renamed from: b */
    public void mo20771b(int i) {
    }

    public LinePagerIndicator(Context context) {
        super(context);
        m35691a(context);
    }

    /* renamed from: a */
    private void m35691a(Context context) {
        this.f28145i = new Paint(1);
        this.f28145i.setStyle(Style.FILL);
        this.f28141e = (float) UIUtil.m35640a(context, 3.0d);
        this.f28143g = (float) UIUtil.m35640a(context, 10.0d);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        RectF rectF = this.f28148l;
        float f = this.f28144h;
        canvas.drawRoundRect(rectF, f, f, this.f28145i);
    }

    /* renamed from: a */
    public void mo20769a(int i, float f, int i2) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        List<PositionData> list = this.f28146j;
        if (list != null && !list.isEmpty()) {
            List<Integer> list2 = this.f28147k;
            if (list2 != null && list2.size() > 0) {
                this.f28145i.setColor(ArgbEvaluatorHolder.m35639a(f, ((Integer) this.f28147k.get(Math.abs(i) % this.f28147k.size())).intValue(), ((Integer) this.f28147k.get(Math.abs(i + 1) % this.f28147k.size())).intValue()));
            }
            PositionData a = FragmentContainerHelper.m35616a(this.f28146j, i);
            PositionData a2 = FragmentContainerHelper.m35616a(this.f28146j, i + 1);
            int i3 = this.f28137a;
            if (i3 == 0) {
                f5 = ((float) a.f28116a) + this.f28142f;
                f4 = ((float) a2.f28116a) + this.f28142f;
                f2 = ((float) a.f28118c) - this.f28142f;
                f6 = (float) a2.f28118c;
                f7 = this.f28142f;
            } else if (i3 == 1) {
                f5 = ((float) a.f28120e) + this.f28142f;
                f4 = ((float) a2.f28120e) + this.f28142f;
                f2 = ((float) a.f28122g) - this.f28142f;
                f6 = (float) a2.f28122g;
                f7 = this.f28142f;
            } else {
                f5 = ((float) a.f28116a) + ((((float) a.mo39960a()) - this.f28143g) / 2.0f);
                f4 = ((float) a2.f28116a) + ((((float) a2.mo39960a()) - this.f28143g) / 2.0f);
                f2 = ((((float) a.mo39960a()) + this.f28143g) / 2.0f) + ((float) a.f28116a);
                f3 = ((((float) a2.mo39960a()) + this.f28143g) / 2.0f) + ((float) a2.f28116a);
                this.f28148l.left = f5 + ((f4 - f5) * this.f28138b.getInterpolation(f));
                this.f28148l.right = f2 + ((f3 - f2) * this.f28139c.getInterpolation(f));
                this.f28148l.top = (((float) getHeight()) - this.f28141e) - this.f28140d;
                this.f28148l.bottom = ((float) getHeight()) - this.f28140d;
                invalidate();
            }
            f3 = f6 - f7;
            this.f28148l.left = f5 + ((f4 - f5) * this.f28138b.getInterpolation(f));
            this.f28148l.right = f2 + ((f3 - f2) * this.f28139c.getInterpolation(f));
            this.f28148l.top = (((float) getHeight()) - this.f28141e) - this.f28140d;
            this.f28148l.bottom = ((float) getHeight()) - this.f28140d;
            invalidate();
        }
    }

    /* renamed from: a */
    public void mo20770a(List<PositionData> list) {
        this.f28146j = list;
    }

    public float getYOffset() {
        return this.f28140d;
    }

    public void setYOffset(float f) {
        this.f28140d = f;
    }

    public float getXOffset() {
        return this.f28142f;
    }

    public void setXOffset(float f) {
        this.f28142f = f;
    }

    public float getLineHeight() {
        return this.f28141e;
    }

    public void setLineHeight(float f) {
        this.f28141e = f;
    }

    public float getLineWidth() {
        return this.f28143g;
    }

    public void setLineWidth(float f) {
        this.f28143g = f;
    }

    public float getRoundRadius() {
        return this.f28144h;
    }

    public void setRoundRadius(float f) {
        this.f28144h = f;
    }

    public int getMode() {
        return this.f28137a;
    }

    public void setMode(int i) {
        if (i == 2 || i == 0 || i == 1) {
            this.f28137a = i;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("mode ");
        sb.append(i);
        sb.append(" not supported.");
        throw new IllegalArgumentException(sb.toString());
    }

    public Paint getPaint() {
        return this.f28145i;
    }

    public List<Integer> getColors() {
        return this.f28147k;
    }

    public void setColors(Integer... numArr) {
        this.f28147k = Arrays.asList(numArr);
    }

    public Interpolator getStartInterpolator() {
        return this.f28138b;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f28138b = interpolator;
        if (this.f28138b == null) {
            this.f28138b = new LinearInterpolator();
        }
    }

    public Interpolator getEndInterpolator() {
        return this.f28139c;
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f28139c = interpolator;
        if (this.f28139c == null) {
            this.f28139c = new LinearInterpolator();
        }
    }
}
