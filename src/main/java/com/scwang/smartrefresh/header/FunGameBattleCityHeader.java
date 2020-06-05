package com.scwang.smartrefresh.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseArray;
import com.scwang.smartrefresh.header.fungame.FunGameView;
import com.scwang.smartrefresh.layout.p527a.RefreshKernel;
import com.scwang.smartrefresh.layout.p529c.DensityUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class FunGameBattleCityHeader extends FunGameView {
    /* renamed from: a */
    protected static int f20414a = 3;
    /* renamed from: b */
    protected SparseArray<Queue<RectF>> f20415b;
    /* renamed from: c */
    protected Queue<Point> f20416c;
    /* renamed from: d */
    protected Point f20417d;
    /* renamed from: e */
    protected Random f20418e;
    /* renamed from: f */
    protected float f20419f;
    /* renamed from: g */
    protected int f20420g;
    /* renamed from: h */
    protected int f20421h;
    /* renamed from: i */
    protected int f20422i;
    /* renamed from: j */
    protected int f20423j;
    /* renamed from: k */
    protected int f20424k;
    /* renamed from: l */
    protected int f20425l;
    /* renamed from: m */
    protected int f20426m;
    /* renamed from: n */
    protected int f20427n;
    /* renamed from: o */
    protected int f20428o;
    /* renamed from: p */
    protected int f20429p;
    /* renamed from: q */
    protected boolean f20430q;

    public FunGameBattleCityHeader(Context context) {
        this(context, null);
    }

    public FunGameBattleCityHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FunGameBattleCityHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20423j = 1;
        this.f20424k = 4;
        this.f20430q = true;
        this.f20418e = new Random();
    }

    /* renamed from: a */
    public void mo30677a(RefreshKernel iVar, int i, int i2) {
        this.f20606Q = i / f20414a;
        this.f20422i = (int) Math.floor((double) ((((float) this.f20606Q) * 0.33333334f) + 0.5f));
        this.f20419f = (((float) this.f20422i) - (this.f20591B * 2.0f)) * 0.5f;
        super.mo30677a(iVar, i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo30696a() {
        this.f20607R = 0;
        this.f20605P = this.f20591B;
        this.f20423j = DensityUtil.m25572a(1.0f);
        this.f20424k = DensityUtil.m25572a(4.0f);
        this.f20428o = 8;
        this.f20429p = 0;
        this.f20430q = true;
        this.f20420g = this.f20606Q + this.f20422i + 60;
        this.f20421h = 360;
        this.f20415b = new SparseArray<>();
        for (int i = 0; i < f20414a; i++) {
            this.f20415b.put(i, new LinkedList());
        }
        this.f20416c = new LinkedList();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public RectF mo30695a(int i) {
        float f = (float) (-(this.f20606Q + this.f20422i));
        float f2 = ((float) (i * this.f20606Q)) + this.f20591B;
        return new RectF(f, f2, (((float) this.f20422i) * 2.5f) + f, ((float) this.f20606Q) + f2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo30703b(int i) {
        int i2 = this.f20583s;
        int i3 = f20414a;
        int i4 = i / (i2 / i3);
        if (i4 >= i3) {
            i4 = i3 - 1;
        }
        if (i4 < 0) {
            return 0;
        }
        return i4;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo30702a(Point point) {
        int b = mo30703b(point.y);
        RectF rectF = (RectF) ((Queue) this.f20415b.get(b)).peek();
        if (rectF == null || !rectF.contains((float) point.x, (float) point.y)) {
            return false;
        }
        int i = this.f20429p + 1;
        this.f20429p = i;
        if (i == this.f20428o) {
            mo30704b();
        }
        ((Queue) this.f20415b.get(b)).poll();
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo30704b() {
        this.f20428o += 8;
        this.f20423j += DensityUtil.m25572a(1.0f);
        this.f20424k += DensityUtil.m25572a(1.0f);
        this.f20429p = 0;
        int i = this.f20420g;
        if (i > 12) {
            this.f20420g = i - 12;
        }
        int i2 = this.f20421h;
        if (i2 > 30) {
            this.f20421h = i2 - 30;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo30701a(int i, float f, float f2) {
        RectF rectF = (RectF) ((Queue) this.f20415b.get(i)).peek();
        return rectF != null && rectF.contains(f, f2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo30706c() {
        return this.f20418e.nextInt(f20414a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo30698a(Canvas canvas, int i, int i2) {
        mo30705b(canvas, i);
        if (this.f20607R == 1 || this.f20607R == 3 || this.f20607R == 4) {
            mo30707c(canvas, i);
            mo30697a(canvas, i);
        }
        if (isInEditMode()) {
            mo30700a(canvas, new RectF((float) this.f20606Q, 0.0f, (float) (this.f20606Q * 2), (float) this.f20606Q));
            mo30700a(canvas, new RectF(0.0f, (float) this.f20606Q, (float) this.f20606Q, (float) (this.f20606Q * 2)));
            mo30700a(canvas, new RectF((float) (this.f20606Q * 3), (float) (this.f20606Q * 2), (float) (this.f20606Q * 4), (float) (this.f20606Q * 3)));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo30697a(Canvas canvas, int i) {
        this.f20603N.setColor(this.f20610U);
        this.f20426m += this.f20424k;
        boolean z = false;
        if (this.f20426m / this.f20421h == 1) {
            this.f20426m = 0;
        }
        if (this.f20426m == 0) {
            Point point = new Point();
            point.x = (i - this.f20606Q) - this.f20422i;
            point.y = (int) (this.f20605P + (((float) this.f20606Q) * 0.5f));
            this.f20416c.offer(point);
        }
        for (Point point2 : this.f20416c) {
            if (mo30702a(point2)) {
                this.f20417d = point2;
            } else {
                if (((float) point2.x) + this.f20419f <= 0.0f) {
                    z = true;
                }
                mo30699a(canvas, point2);
            }
        }
        if (z) {
            this.f20416c.poll();
        }
        this.f20416c.remove(this.f20417d);
        this.f20417d = null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo30699a(Canvas canvas, Point point) {
        point.x -= this.f20424k;
        canvas.drawCircle((float) point.x, (float) point.y, this.f20419f, this.f20603N);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo30705b(Canvas canvas, int i) {
        this.f20603N.setColor(this.f20609T);
        boolean a = mo30701a(mo30703b((int) this.f20605P), (float) (i - this.f20606Q), this.f20605P);
        boolean a2 = mo30701a(mo30703b((int) (this.f20605P + ((float) this.f20606Q))), (float) (i - this.f20606Q), this.f20605P + ((float) this.f20606Q));
        if (a || a2) {
            this.f20607R = 2;
        }
        canvas.drawRect((float) (i - this.f20606Q), this.f20605P + this.f20591B, (float) i, this.f20605P + ((float) this.f20606Q) + this.f20591B, this.f20603N);
        float f = (float) ((i - this.f20606Q) - this.f20422i);
        float f2 = this.f20605P + (((float) (this.f20606Q - this.f20422i)) * 0.5f);
        float f3 = (float) (i - this.f20606Q);
        float f4 = this.f20605P;
        int i2 = this.f20606Q;
        int i3 = this.f20422i;
        canvas.drawRect(f, f2, f3, f4 + (((float) (i2 - i3)) * 0.5f) + ((float) i3), this.f20603N);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo30707c(Canvas canvas, int i) {
        this.f20603N.setColor(this.f20608S);
        this.f20425l += this.f20423j;
        if (this.f20425l / this.f20420g == 1 || this.f20430q) {
            this.f20425l = 0;
            this.f20430q = false;
        }
        int c = mo30706c();
        int i2 = 0;
        boolean z = false;
        while (i2 < f20414a) {
            Queue queue = (Queue) this.f20415b.get(i2);
            if (this.f20425l == 0 && i2 == c) {
                queue.offer(mo30695a(i2));
            }
            Iterator it = queue.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                RectF rectF = (RectF) it.next();
                if (rectF.left >= ((float) i)) {
                    int i3 = this.f20427n + 1;
                    this.f20427n = i3;
                    if (i3 >= 8) {
                        this.f20607R = 2;
                        z = true;
                        break;
                    }
                    z = true;
                } else {
                    mo30700a(canvas, rectF);
                }
            }
            if (this.f20607R == 2) {
                break;
            }
            if (z) {
                queue.poll();
                z = false;
            }
            i2++;
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo30700a(Canvas canvas, RectF rectF) {
        rectF.set(rectF.left + ((float) this.f20423j), rectF.top, rectF.right + ((float) this.f20423j), rectF.bottom);
        canvas.drawRect(rectF, this.f20603N);
        float f = rectF.top + (((float) (this.f20606Q - this.f20422i)) * 0.5f);
        float f2 = rectF.right;
        float f3 = rectF.right;
        int i = this.f20422i;
        canvas.drawRect(f2, f, f3 + ((float) i), f + ((float) i), this.f20603N);
    }
}
