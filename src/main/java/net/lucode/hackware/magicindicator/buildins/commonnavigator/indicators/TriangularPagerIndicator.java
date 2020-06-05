package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.List;
import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.p695a.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.p696b.PositionData;

public class TriangularPagerIndicator extends View implements IPagerIndicator {
    /* renamed from: a */
    private List<PositionData> f28155a;
    /* renamed from: b */
    private Paint f28156b;
    /* renamed from: c */
    private int f28157c;
    /* renamed from: d */
    private int f28158d;
    /* renamed from: e */
    private int f28159e;
    /* renamed from: f */
    private int f28160f;
    /* renamed from: g */
    private boolean f28161g;
    /* renamed from: h */
    private float f28162h;
    /* renamed from: i */
    private Path f28163i = new Path();
    /* renamed from: j */
    private Interpolator f28164j = new LinearInterpolator();
    /* renamed from: k */
    private float f28165k;

    /* renamed from: a */
    public void mo20768a(int i) {
    }

    /* renamed from: b */
    public void mo20771b(int i) {
    }

    public TriangularPagerIndicator(Context context) {
        super(context);
        m35701a(context);
    }

    /* renamed from: a */
    private void m35701a(Context context) {
        this.f28156b = new Paint(1);
        this.f28156b.setStyle(Style.FILL);
        this.f28157c = UIUtil.m35640a(context, 3.0d);
        this.f28160f = UIUtil.m35640a(context, 14.0d);
        this.f28159e = UIUtil.m35640a(context, 8.0d);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f28156b.setColor(this.f28158d);
        if (this.f28161g) {
            canvas.drawRect(0.0f, (((float) getHeight()) - this.f28162h) - ((float) this.f28159e), (float) getWidth(), ((((float) getHeight()) - this.f28162h) - ((float) this.f28159e)) + ((float) this.f28157c), this.f28156b);
        } else {
            canvas.drawRect(0.0f, ((float) (getHeight() - this.f28157c)) - this.f28162h, (float) getWidth(), ((float) getHeight()) - this.f28162h, this.f28156b);
        }
        this.f28163i.reset();
        if (this.f28161g) {
            this.f28163i.moveTo(this.f28165k - ((float) (this.f28160f / 2)), (((float) getHeight()) - this.f28162h) - ((float) this.f28159e));
            this.f28163i.lineTo(this.f28165k, ((float) getHeight()) - this.f28162h);
            this.f28163i.lineTo(this.f28165k + ((float) (this.f28160f / 2)), (((float) getHeight()) - this.f28162h) - ((float) this.f28159e));
        } else {
            this.f28163i.moveTo(this.f28165k - ((float) (this.f28160f / 2)), ((float) getHeight()) - this.f28162h);
            this.f28163i.lineTo(this.f28165k, ((float) (getHeight() - this.f28159e)) - this.f28162h);
            this.f28163i.lineTo(this.f28165k + ((float) (this.f28160f / 2)), ((float) getHeight()) - this.f28162h);
        }
        this.f28163i.close();
        canvas.drawPath(this.f28163i, this.f28156b);
    }

    /* renamed from: a */
    public void mo20769a(int i, float f, int i2) {
        List<PositionData> list = this.f28155a;
        if (list != null && !list.isEmpty()) {
            PositionData a = FragmentContainerHelper.m35616a(this.f28155a, i);
            PositionData a2 = FragmentContainerHelper.m35616a(this.f28155a, i + 1);
            float f2 = (float) (a.f28116a + ((a.f28118c - a.f28116a) / 2));
            this.f28165k = f2 + ((((float) (a2.f28116a + ((a2.f28118c - a2.f28116a) / 2))) - f2) * this.f28164j.getInterpolation(f));
            invalidate();
        }
    }

    /* renamed from: a */
    public void mo20770a(List<PositionData> list) {
        this.f28155a = list;
    }

    public int getLineHeight() {
        return this.f28157c;
    }

    public void setLineHeight(int i) {
        this.f28157c = i;
    }

    public int getLineColor() {
        return this.f28158d;
    }

    public void setLineColor(int i) {
        this.f28158d = i;
    }

    public int getTriangleHeight() {
        return this.f28159e;
    }

    public void setTriangleHeight(int i) {
        this.f28159e = i;
    }

    public int getTriangleWidth() {
        return this.f28160f;
    }

    public void setTriangleWidth(int i) {
        this.f28160f = i;
    }

    public Interpolator getStartInterpolator() {
        return this.f28164j;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f28164j = interpolator;
        if (this.f28164j == null) {
            this.f28164j = new LinearInterpolator();
        }
    }

    public void setReverse(boolean z) {
        this.f28161g = z;
    }

    public float getYOffset() {
        return this.f28162h;
    }

    public void setYOffset(float f) {
        this.f28162h = f;
    }
}
