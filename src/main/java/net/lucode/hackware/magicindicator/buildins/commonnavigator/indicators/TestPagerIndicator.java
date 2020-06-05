package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import java.util.List;
import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.p695a.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.p696b.PositionData;

public class TestPagerIndicator extends View implements IPagerIndicator {
    /* renamed from: a */
    private Paint f28149a;
    /* renamed from: b */
    private int f28150b;
    /* renamed from: c */
    private int f28151c;
    /* renamed from: d */
    private RectF f28152d = new RectF();
    /* renamed from: e */
    private RectF f28153e = new RectF();
    /* renamed from: f */
    private List<PositionData> f28154f;

    /* renamed from: a */
    public void mo20768a(int i) {
    }

    /* renamed from: b */
    public void mo20771b(int i) {
    }

    public TestPagerIndicator(Context context) {
        super(context);
        m35696a(context);
    }

    /* renamed from: a */
    private void m35696a(Context context) {
        this.f28149a = new Paint(1);
        this.f28149a.setStyle(Style.STROKE);
        this.f28150b = SupportMenu.CATEGORY_MASK;
        this.f28151c = -16711936;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f28149a.setColor(this.f28150b);
        canvas.drawRect(this.f28152d, this.f28149a);
        this.f28149a.setColor(this.f28151c);
        canvas.drawRect(this.f28153e, this.f28149a);
    }

    /* renamed from: a */
    public void mo20769a(int i, float f, int i2) {
        List<PositionData> list = this.f28154f;
        if (list != null && !list.isEmpty()) {
            PositionData a = FragmentContainerHelper.m35616a(this.f28154f, i);
            PositionData a2 = FragmentContainerHelper.m35616a(this.f28154f, i + 1);
            this.f28152d.left = ((float) a.f28116a) + (((float) (a2.f28116a - a.f28116a)) * f);
            this.f28152d.top = ((float) a.f28117b) + (((float) (a2.f28117b - a.f28117b)) * f);
            this.f28152d.right = ((float) a.f28118c) + (((float) (a2.f28118c - a.f28118c)) * f);
            this.f28152d.bottom = ((float) a.f28119d) + (((float) (a2.f28119d - a.f28119d)) * f);
            this.f28153e.left = ((float) a.f28120e) + (((float) (a2.f28120e - a.f28120e)) * f);
            this.f28153e.top = ((float) a.f28121f) + (((float) (a2.f28121f - a.f28121f)) * f);
            this.f28153e.right = ((float) a.f28122g) + (((float) (a2.f28122g - a.f28122g)) * f);
            this.f28153e.bottom = ((float) a.f28123h) + (((float) (a2.f28123h - a.f28123h)) * f);
            invalidate();
        }
    }

    /* renamed from: a */
    public void mo20770a(List<PositionData> list) {
        this.f28154f = list;
    }

    public int getOutRectColor() {
        return this.f28150b;
    }

    public void setOutRectColor(int i) {
        this.f28150b = i;
    }

    public int getInnerRectColor() {
        return this.f28151c;
    }

    public void setInnerRectColor(int i) {
        this.f28151c = i;
    }
}
