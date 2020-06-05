package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.List;
import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.p695a.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.p696b.PositionData;

public class WrapPagerIndicator extends View implements IPagerIndicator {
    /* renamed from: a */
    private int f28166a;
    /* renamed from: b */
    private int f28167b;
    /* renamed from: c */
    private int f28168c;
    /* renamed from: d */
    private float f28169d;
    /* renamed from: e */
    private Interpolator f28170e = new LinearInterpolator();
    /* renamed from: f */
    private Interpolator f28171f = new LinearInterpolator();
    /* renamed from: g */
    private List<PositionData> f28172g;
    /* renamed from: h */
    private Paint f28173h;
    /* renamed from: i */
    private RectF f28174i = new RectF();
    /* renamed from: j */
    private boolean f28175j;

    /* renamed from: a */
    public void mo20768a(int i) {
    }

    /* renamed from: b */
    public void mo20771b(int i) {
    }

    public WrapPagerIndicator(Context context) {
        super(context);
        m35706a(context);
    }

    /* renamed from: a */
    private void m35706a(Context context) {
        this.f28173h = new Paint(1);
        this.f28173h.setStyle(Style.FILL);
        this.f28166a = UIUtil.m35640a(context, 6.0d);
        this.f28167b = UIUtil.m35640a(context, 10.0d);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f28173h.setColor(this.f28168c);
        RectF rectF = this.f28174i;
        float f = this.f28169d;
        canvas.drawRoundRect(rectF, f, f, this.f28173h);
    }

    /* renamed from: a */
    public void mo20769a(int i, float f, int i2) {
        List<PositionData> list = this.f28172g;
        if (list != null && !list.isEmpty()) {
            PositionData a = FragmentContainerHelper.m35616a(this.f28172g, i);
            PositionData a2 = FragmentContainerHelper.m35616a(this.f28172g, i + 1);
            this.f28174i.left = ((float) (a.f28120e - this.f28167b)) + (((float) (a2.f28120e - a.f28120e)) * this.f28171f.getInterpolation(f));
            this.f28174i.top = (float) (a.f28121f - this.f28166a);
            this.f28174i.right = ((float) (a.f28122g + this.f28167b)) + (((float) (a2.f28122g - a.f28122g)) * this.f28170e.getInterpolation(f));
            this.f28174i.bottom = (float) (a.f28123h + this.f28166a);
            if (!this.f28175j) {
                this.f28169d = this.f28174i.height() / 2.0f;
            }
            invalidate();
        }
    }

    /* renamed from: a */
    public void mo20770a(List<PositionData> list) {
        this.f28172g = list;
    }

    public Paint getPaint() {
        return this.f28173h;
    }

    public int getVerticalPadding() {
        return this.f28166a;
    }

    public void setVerticalPadding(int i) {
        this.f28166a = i;
    }

    public int getHorizontalPadding() {
        return this.f28167b;
    }

    public void setHorizontalPadding(int i) {
        this.f28167b = i;
    }

    public int getFillColor() {
        return this.f28168c;
    }

    public void setFillColor(int i) {
        this.f28168c = i;
    }

    public float getRoundRadius() {
        return this.f28169d;
    }

    public void setRoundRadius(float f) {
        this.f28169d = f;
        this.f28175j = true;
    }

    public Interpolator getStartInterpolator() {
        return this.f28170e;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f28170e = interpolator;
        if (this.f28170e == null) {
            this.f28170e = new LinearInterpolator();
        }
    }

    public Interpolator getEndInterpolator() {
        return this.f28171f;
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f28171f = interpolator;
        if (this.f28171f == null) {
            this.f28171f = new LinearInterpolator();
        }
    }
}
