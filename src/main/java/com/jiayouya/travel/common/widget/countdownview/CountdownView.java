package com.jiayouya.travel.common.widget.countdownview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.appcompat.widget.AppCompatTextView;
import com.jiayouya.travel.R;

public class CountdownView extends AppCompatTextView {
    /* renamed from: a */
    private BaseCountdown f9687a;
    /* renamed from: b */
    private CustomCountDownTimer f9688b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public C2910a f9689c;
    /* renamed from: d */
    private C2911b f9690d;
    /* renamed from: e */
    private boolean f9691e;
    /* renamed from: f */
    private long f9692f;
    /* renamed from: g */
    private long f9693g;
    /* renamed from: h */
    private long f9694h;
    /* renamed from: i */
    private int f9695i;
    /* renamed from: j */
    private int f9696j;

    /* renamed from: com.jiayouya.travel.common.widget.countdownview.CountdownView$a */
    public interface C2910a {
        /* renamed from: a */
        void mo20048a(CountdownView countdownView);
    }

    /* renamed from: com.jiayouya.travel.common.widget.countdownview.CountdownView$b */
    public interface C2911b {
        /* renamed from: a */
        void mo20049a(CountdownView countdownView, long j);
    }

    public CountdownView(Context context) {
        this(context, null);
    }

    public CountdownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CountdownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9695i = 1;
        this.f9696j = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CountdownView);
        this.f9691e = obtainStyledAttributes.getBoolean(1, true);
        this.f9696j = (int) obtainStyledAttributes.getDimension(11, 0.0f);
        this.f9687a = this.f9691e ? new BaseCountdown() : new BackgroundCountdown();
        this.f9687a.mo20051a(context, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        this.f9687a.mo20060e();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int c = this.f9687a.mo20055c() + this.f9696j;
        int d = this.f9687a.mo20056d();
        int a = m13117a(1, c, i);
        int a2 = m13117a(2, d, i2);
        setMeasuredDimension(a, a2);
        this.f9687a.mo20053a((View) this, a, a2, c, d);
    }

    public void setManuallyAddWidth(int i) {
        this.f9696j = i;
    }

    /* renamed from: a */
    private int m13117a(int i, int i2, int i3) {
        int i4;
        int i5;
        int mode = MeasureSpec.getMode(i3);
        int size = MeasureSpec.getSize(i3);
        if (mode == 1073741824) {
            return Math.max(i2, size);
        }
        if (i == 1) {
            i5 = getPaddingLeft();
            i4 = getPaddingRight();
        } else {
            i5 = getPaddingTop();
            i4 = getPaddingBottom();
        }
        return i5 + i4 + i2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f9687a.mo20052a(canvas);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo20032a();
    }

    /* renamed from: c */
    private void m13119c() {
        this.f9687a.mo20063h();
        requestLayout();
    }

    public void setSpeed(int i) {
        this.f9695i = i;
    }

    /* renamed from: a */
    public void mo20033a(long j) {
        long j2;
        if (j > 0) {
            this.f9692f = 0;
            CustomCountDownTimer cVar = this.f9688b;
            if (cVar != null) {
                cVar.mo20065c();
                this.f9688b = null;
            }
            if (this.f9687a.f9784j) {
                j2 = 10;
                mo20035b(j);
            } else {
                j2 = 1000;
            }
            int i = this.f9695i;
            if (i > 0) {
                j /= (long) i;
                j2 /= (long) i;
                mo20035b(j);
            }
            C29091 r2 = new CustomCountDownTimer(j, j2) {
                /* renamed from: a */
                public void mo20047a(long j) {
                    CountdownView.this.mo20035b(j);
                }

                /* renamed from: a */
                public void mo20046a() {
                    CountdownView.this.mo20034b();
                    if (CountdownView.this.f9689c != null) {
                        CountdownView.this.f9689c.mo20048a(CountdownView.this);
                    }
                }
            };
            this.f9688b = r2;
            this.f9688b.mo20064b();
        }
    }

    /* renamed from: a */
    public void mo20032a() {
        CustomCountDownTimer cVar = this.f9688b;
        if (cVar != null) {
            cVar.mo20065c();
        }
    }

    /* renamed from: b */
    public void mo20034b() {
        this.f9687a.mo20058a(0, 0, 0, 0, 0);
        invalidate();
    }

    public void setOnCountdownEndListener(C2910a aVar) {
        this.f9689c = aVar;
    }

    public int getDay() {
        return this.f9687a.f9752a;
    }

    public int getHour() {
        return this.f9687a.f9776b;
    }

    public int getMinute() {
        return this.f9687a.f9777c;
    }

    public int getSecond() {
        return this.f9687a.f9778d;
    }

    public long getRemainTime() {
        return this.f9694h;
    }

    /* renamed from: b */
    public void mo20035b(long j) {
        this.f9694h = j;
        m13120c(j);
        long j2 = this.f9693g;
        if (j2 > 0) {
            C2911b bVar = this.f9690d;
            if (bVar != null) {
                long j3 = this.f9692f;
                if (j3 == 0) {
                    this.f9692f = j;
                } else if (j2 + j <= j3) {
                    this.f9692f = j;
                    bVar.mo20049a(this, this.f9694h);
                }
            }
        }
        if (this.f9687a.mo20061f() || this.f9687a.mo20062g()) {
            m13119c();
        } else {
            invalidate();
        }
    }

    /* renamed from: c */
    private void m13120c(long j) {
        int i;
        int i2;
        int i3 = 1000 / this.f9695i;
        if (!this.f9687a.f9785k) {
            int i4 = i3 * 60 * 60;
            long j2 = (long) (i4 * 24);
            i = (int) ((j % j2) / ((long) i4));
            i2 = (int) (j / j2);
        } else {
            i = (int) (j / ((long) ((i3 * 60) * 60)));
            i2 = 0;
        }
        int i5 = i3 * 60;
        long j3 = (long) i5;
        int i6 = (int) ((j % ((long) (i5 * 60))) / j3);
        long j4 = (long) i3;
        this.f9687a.mo20058a(i2, i, i6, (int) ((j % j3) / j4), (int) ((j % j4) / ((long) (100 / this.f9695i))));
    }
}
