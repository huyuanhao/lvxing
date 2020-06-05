package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.p695a.IMeasurablePagerTitleView;

public class ClipPagerTitleView extends View implements IMeasurablePagerTitleView {
    /* renamed from: a */
    private String f28176a;
    /* renamed from: b */
    private int f28177b;
    /* renamed from: c */
    private int f28178c;
    /* renamed from: d */
    private boolean f28179d;
    /* renamed from: e */
    private float f28180e;
    /* renamed from: f */
    private Paint f28181f;
    /* renamed from: g */
    private Rect f28182g = new Rect();

    /* renamed from: a */
    public void mo20757a(int i, int i2) {
    }

    /* renamed from: b */
    public void mo20758b(int i, int i2) {
    }

    public ClipPagerTitleView(Context context) {
        super(context);
        m35713a(context);
    }

    /* renamed from: a */
    private void m35713a(Context context) {
        int a = UIUtil.m35640a(context, 16.0d);
        this.f28181f = new Paint(1);
        this.f28181f.setTextSize((float) a);
        int a2 = UIUtil.m35640a(context, 10.0d);
        setPadding(a2, 0, a2, 0);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        m35712a();
        setMeasuredDimension(m35711a(i), m35714b(i2));
    }

    /* renamed from: a */
    private int m35711a(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(this.f28182g.width() + getPaddingLeft() + getPaddingRight(), size);
        }
        if (mode != 0) {
            return size;
        }
        return this.f28182g.width() + getPaddingLeft() + getPaddingRight();
    }

    /* renamed from: b */
    private int m35714b(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(this.f28182g.height() + getPaddingTop() + getPaddingBottom(), size);
        }
        if (mode != 0) {
            return size;
        }
        return this.f28182g.height() + getPaddingTop() + getPaddingBottom();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int width = (getWidth() - this.f28182g.width()) / 2;
        FontMetrics fontMetrics = this.f28181f.getFontMetrics();
        int height = (int) (((((float) getHeight()) - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
        this.f28181f.setColor(this.f28177b);
        float f = (float) width;
        float f2 = (float) height;
        canvas.drawText(this.f28176a, f, f2, this.f28181f);
        canvas.save(2);
        if (this.f28179d) {
            canvas.clipRect(0.0f, 0.0f, ((float) getWidth()) * this.f28180e, (float) getHeight());
        } else {
            canvas.clipRect(((float) getWidth()) * (1.0f - this.f28180e), 0.0f, (float) getWidth(), (float) getHeight());
        }
        this.f28181f.setColor(this.f28178c);
        canvas.drawText(this.f28176a, f, f2, this.f28181f);
        canvas.restore();
    }

    /* renamed from: a */
    public void mo39958a(int i, int i2, float f, boolean z) {
        this.f28179d = !z;
        this.f28180e = 1.0f - f;
        invalidate();
    }

    /* renamed from: b */
    public void mo39959b(int i, int i2, float f, boolean z) {
        this.f28179d = z;
        this.f28180e = f;
        invalidate();
    }

    /* renamed from: a */
    private void m35712a() {
        Paint paint = this.f28181f;
        String str = this.f28176a;
        paint.getTextBounds(str, 0, str == null ? 0 : str.length(), this.f28182g);
    }

    public String getText() {
        return this.f28176a;
    }

    public void setText(String str) {
        this.f28176a = str;
        requestLayout();
    }

    public float getTextSize() {
        return this.f28181f.getTextSize();
    }

    public void setTextSize(float f) {
        this.f28181f.setTextSize(f);
        requestLayout();
    }

    public int getTextColor() {
        return this.f28177b;
    }

    public void setTextColor(int i) {
        this.f28177b = i;
        invalidate();
    }

    public int getClipColor() {
        return this.f28178c;
    }

    public void setClipColor(int i) {
        this.f28178c = i;
        invalidate();
    }

    public int getContentLeft() {
        return (getLeft() + (getWidth() / 2)) - (this.f28182g.width() / 2);
    }

    public int getContentTop() {
        FontMetrics fontMetrics = this.f28181f.getFontMetrics();
        return (int) (((float) (getHeight() / 2)) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public int getContentRight() {
        return getLeft() + (getWidth() / 2) + (this.f28182g.width() / 2);
    }

    public int getContentBottom() {
        FontMetrics fontMetrics = this.f28181f.getFontMetrics();
        return (int) (((float) (getHeight() / 2)) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }
}
