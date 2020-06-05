package com.scwang.smartrefresh.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.util.AttributeSet;
import androidx.core.graphics.ColorUtils;
import com.scwang.smartrefresh.header.fungame.FunGameView;
import com.scwang.smartrefresh.layout.p527a.RefreshKernel;
import com.scwang.smartrefresh.layout.p529c.DensityUtil;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FunGameHitBlockHeader extends FunGameView {
    /* renamed from: a */
    protected float f20431a;
    /* renamed from: b */
    protected float f20432b;
    /* renamed from: c */
    protected float f20433c;
    /* renamed from: d */
    protected Paint f20434d;
    /* renamed from: e */
    protected float f20435e;
    /* renamed from: f */
    protected float f20436f;
    /* renamed from: g */
    protected float f20437g;
    /* renamed from: h */
    protected float f20438h;
    /* renamed from: i */
    protected List<Point> f20439i;
    /* renamed from: j */
    protected boolean f20440j;
    /* renamed from: k */
    protected int f20441k;
    /* renamed from: l */
    protected int f20442l;
    /* renamed from: m */
    protected int f20443m;

    public FunGameHitBlockHeader(Context context) {
        this(context, null);
    }

    public FunGameHitBlockHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FunGameHitBlockHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FunGameHitBlockHeader);
        this.f20443m = obtainStyledAttributes.getInt(R.styleable.FunGameHitBlockHeader_fghBallSpeed, DensityUtil.m25572a(3.0f));
        this.f20442l = obtainStyledAttributes.getInt(R.styleable.FunGameHitBlockHeader_fghBlockHorizontalNum, 3);
        obtainStyledAttributes.recycle();
        this.f20434d = new Paint(1);
        this.f20434d.setStyle(Style.FILL);
        this.f20433c = (float) DensityUtil.m25572a(4.0f);
    }

    /* renamed from: a */
    public void mo30677a(RefreshKernel iVar, int i, int i2) {
        int measuredWidth = getMeasuredWidth();
        this.f20431a = ((float) (i / 5)) - 1.0f;
        float f = (float) measuredWidth;
        this.f20432b = 0.01806f * f;
        this.f20435e = 0.08f * f;
        this.f20436f = f * 0.8f;
        this.f20606Q = (int) (this.f20431a * 1.6f);
        super.mo30677a(iVar, i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo30696a() {
        this.f20437g = this.f20436f - (this.f20433c * 3.0f);
        this.f20438h = (float) ((int) (((float) this.f20583s) * 0.5f));
        this.f20605P = 1.0f;
        this.f20441k = 30;
        this.f20440j = true;
        List<Point> list = this.f20439i;
        if (list == null) {
            this.f20439i = new ArrayList();
        } else {
            list.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo30710a(float f) {
        float f2 = f - this.f20605P;
        return f2 >= 0.0f && f2 <= ((float) this.f20606Q);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo30711a(float f, float f2) {
        int i = (int) ((((f - this.f20435e) - this.f20433c) - ((float) this.f20443m)) / this.f20432b);
        if (i == this.f20442l) {
            i--;
        }
        int i2 = (int) (f2 / this.f20431a);
        if (i2 == 5) {
            i2--;
        }
        Point point = new Point();
        point.set(i, i2);
        boolean z = false;
        Iterator it = this.f20439i.iterator();
        while (true) {
            if (it.hasNext()) {
                if (((Point) it.next()).equals(point.x, point.y)) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z) {
            this.f20439i.add(point);
        }
        return !z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo30698a(Canvas canvas, int i, int i2) {
        mo30712b(canvas);
        mo30708a(canvas);
        if (this.f20607R == 1 || this.f20607R == 3 || this.f20607R == 4 || isInEditMode()) {
            mo30709a(canvas, i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo30708a(Canvas canvas) {
        this.f20603N.setColor(this.f20609T);
        canvas.drawRect(this.f20436f, this.f20605P, this.f20436f + this.f20432b, this.f20605P + ((float) this.f20606Q), this.f20603N);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo30709a(Canvas canvas, int i) {
        this.f20603N.setColor(this.f20610U);
        float f = this.f20437g;
        float f2 = this.f20435e;
        int i2 = this.f20442l;
        if (f <= f2 + (((float) i2) * this.f20432b) + (((float) (i2 - 1)) * 1.0f) + this.f20433c && mo30711a(f, this.f20438h)) {
            this.f20440j = false;
        }
        if (this.f20437g <= this.f20435e + this.f20433c) {
            this.f20440j = false;
        }
        float f3 = this.f20437g;
        float f4 = this.f20433c;
        float f5 = f3 + f4;
        float f6 = this.f20436f;
        if (f5 < f6 || f3 - f4 >= f6 + this.f20432b) {
            if (this.f20437g > ((float) i)) {
                this.f20607R = 2;
            }
        } else if (mo30710a(this.f20438h)) {
            if (this.f20439i.size() == this.f20442l * 5) {
                this.f20607R = 2;
                return;
            }
            this.f20440j = true;
        }
        float f7 = this.f20438h;
        if (f7 <= this.f20433c + 1.0f) {
            this.f20441k = TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE;
        } else if (f7 >= (((float) this.f20583s) - this.f20433c) - 1.0f) {
            this.f20441k = 210;
        }
        if (this.f20440j) {
            this.f20437g -= (float) this.f20443m;
        } else {
            this.f20437g += (float) this.f20443m;
        }
        this.f20438h -= ((float) Math.tan(Math.toRadians((double) this.f20441k))) * ((float) this.f20443m);
        canvas.drawCircle(this.f20437g, this.f20438h, this.f20433c, this.f20603N);
        invalidate();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo30712b(Canvas canvas) {
        boolean z;
        int i = 0;
        while (true) {
            int i2 = this.f20442l;
            if (i < i2 * 5) {
                int i3 = i / i2;
                int i4 = i % i2;
                Iterator it = this.f20439i.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((Point) it.next()).equals(i4, i3)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    this.f20434d.setColor(ColorUtils.setAlphaComponent(this.f20608S, 255 / (i4 + 1)));
                    float f = this.f20435e;
                    float f2 = (float) i4;
                    float f3 = this.f20432b;
                    float f4 = f + (f2 * (f3 + 1.0f));
                    float f5 = (float) i3;
                    float f6 = this.f20431a;
                    float f7 = (f5 * (f6 + 1.0f)) + 1.0f;
                    canvas.drawRect(f4, f7, f4 + f3, f7 + f6, this.f20434d);
                }
                i++;
            } else {
                return;
            }
        }
    }
}
