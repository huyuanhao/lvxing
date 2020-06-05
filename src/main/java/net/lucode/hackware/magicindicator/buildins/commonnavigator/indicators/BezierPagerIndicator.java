package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.Arrays;
import java.util.List;
import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.buildins.ArgbEvaluatorHolder;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.p695a.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.p696b.PositionData;

public class BezierPagerIndicator extends View implements IPagerIndicator {
    /* renamed from: a */
    private List<PositionData> f28124a;
    /* renamed from: b */
    private float f28125b;
    /* renamed from: c */
    private float f28126c;
    /* renamed from: d */
    private float f28127d;
    /* renamed from: e */
    private float f28128e;
    /* renamed from: f */
    private float f28129f;
    /* renamed from: g */
    private float f28130g;
    /* renamed from: h */
    private float f28131h;
    /* renamed from: i */
    private Paint f28132i;
    /* renamed from: j */
    private Path f28133j = new Path();
    /* renamed from: k */
    private List<Integer> f28134k;
    /* renamed from: l */
    private Interpolator f28135l = new AccelerateInterpolator();
    /* renamed from: m */
    private Interpolator f28136m = new DecelerateInterpolator();

    /* renamed from: a */
    public void mo20768a(int i) {
    }

    /* renamed from: b */
    public void mo20771b(int i) {
    }

    public BezierPagerIndicator(Context context) {
        super(context);
        m35685a(context);
    }

    /* renamed from: a */
    private void m35685a(Context context) {
        this.f28132i = new Paint(1);
        this.f28132i.setStyle(Style.FILL);
        this.f28130g = (float) UIUtil.m35640a(context, 3.5d);
        this.f28131h = (float) UIUtil.m35640a(context, 2.0d);
        this.f28129f = (float) UIUtil.m35640a(context, 1.5d);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.drawCircle(this.f28126c, (((float) getHeight()) - this.f28129f) - this.f28130g, this.f28125b, this.f28132i);
        canvas.drawCircle(this.f28128e, (((float) getHeight()) - this.f28129f) - this.f28130g, this.f28127d, this.f28132i);
        m35686a(canvas);
    }

    /* renamed from: a */
    private void m35686a(Canvas canvas) {
        this.f28133j.reset();
        float height = (((float) getHeight()) - this.f28129f) - this.f28130g;
        this.f28133j.moveTo(this.f28128e, height);
        this.f28133j.lineTo(this.f28128e, height - this.f28127d);
        Path path = this.f28133j;
        float f = this.f28128e;
        float f2 = this.f28126c;
        path.quadTo(f + ((f2 - f) / 2.0f), height, f2, height - this.f28125b);
        this.f28133j.lineTo(this.f28126c, this.f28125b + height);
        Path path2 = this.f28133j;
        float f3 = this.f28128e;
        path2.quadTo(((this.f28126c - f3) / 2.0f) + f3, height, f3, this.f28127d + height);
        this.f28133j.close();
        canvas.drawPath(this.f28133j, this.f28132i);
    }

    /* renamed from: a */
    public void mo20769a(int i, float f, int i2) {
        List<PositionData> list = this.f28124a;
        if (list != null && !list.isEmpty()) {
            List<Integer> list2 = this.f28134k;
            if (list2 != null && list2.size() > 0) {
                this.f28132i.setColor(ArgbEvaluatorHolder.m35639a(f, ((Integer) this.f28134k.get(Math.abs(i) % this.f28134k.size())).intValue(), ((Integer) this.f28134k.get(Math.abs(i + 1) % this.f28134k.size())).intValue()));
            }
            PositionData a = FragmentContainerHelper.m35616a(this.f28124a, i);
            PositionData a2 = FragmentContainerHelper.m35616a(this.f28124a, i + 1);
            float f2 = (float) (a.f28116a + ((a.f28118c - a.f28116a) / 2));
            float f3 = ((float) (a2.f28116a + ((a2.f28118c - a2.f28116a) / 2))) - f2;
            this.f28126c = (this.f28135l.getInterpolation(f) * f3) + f2;
            this.f28128e = f2 + (f3 * this.f28136m.getInterpolation(f));
            float f4 = this.f28130g;
            this.f28125b = f4 + ((this.f28131h - f4) * this.f28136m.getInterpolation(f));
            float f5 = this.f28131h;
            this.f28127d = f5 + ((this.f28130g - f5) * this.f28135l.getInterpolation(f));
            invalidate();
        }
    }

    /* renamed from: a */
    public void mo20770a(List<PositionData> list) {
        this.f28124a = list;
    }

    public float getMaxCircleRadius() {
        return this.f28130g;
    }

    public void setMaxCircleRadius(float f) {
        this.f28130g = f;
    }

    public float getMinCircleRadius() {
        return this.f28131h;
    }

    public void setMinCircleRadius(float f) {
        this.f28131h = f;
    }

    public float getYOffset() {
        return this.f28129f;
    }

    public void setYOffset(float f) {
        this.f28129f = f;
    }

    public void setColors(Integer... numArr) {
        this.f28134k = Arrays.asList(numArr);
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f28135l = interpolator;
        if (this.f28135l == null) {
            this.f28135l = new AccelerateInterpolator();
        }
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f28136m = interpolator;
        if (this.f28136m == null) {
            this.f28136m = new DecelerateInterpolator();
        }
    }
}
