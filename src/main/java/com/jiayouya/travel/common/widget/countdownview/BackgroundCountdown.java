package com.jiayouya.travel.common.widget.countdownview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import androidx.core.view.ViewCompat;

/* renamed from: com.jiayouya.travel.common.widget.countdownview.a */
class BackgroundCountdown extends BaseCountdown {
    /* renamed from: W */
    private boolean f9698W;
    /* renamed from: X */
    private boolean f9699X;
    /* renamed from: Y */
    private int f9700Y;
    /* renamed from: Z */
    private float f9701Z;
    /* renamed from: aa */
    private float f9702aa;
    /* renamed from: ab */
    private float f9703ab;
    /* renamed from: ac */
    private int f9704ac;
    /* renamed from: ad */
    private Paint f9705ad;
    /* renamed from: ae */
    private Paint f9706ae;
    /* renamed from: af */
    private Paint f9707af;
    /* renamed from: ag */
    private float f9708ag;
    /* renamed from: ah */
    private float f9709ah;
    /* renamed from: ai */
    private RectF f9710ai;
    /* renamed from: aj */
    private RectF f9711aj;
    /* renamed from: ak */
    private RectF f9712ak;
    /* renamed from: al */
    private RectF f9713al;
    /* renamed from: am */
    private RectF f9714am;
    /* renamed from: an */
    private RectF f9715an;
    /* renamed from: ao */
    private RectF f9716ao;
    /* renamed from: ap */
    private RectF f9717ap;
    /* renamed from: aq */
    private RectF f9718aq;
    /* renamed from: ar */
    private RectF f9719ar;
    /* renamed from: as */
    private float f9720as;
    /* renamed from: at */
    private float f9721at;
    /* renamed from: au */
    private boolean f9722au;
    /* renamed from: av */
    private float f9723av;
    /* renamed from: aw */
    private float f9724aw;
    /* renamed from: ax */
    private int f9725ax;

    BackgroundCountdown() {
    }

    /* renamed from: a */
    public void mo20051a(Context context, TypedArray typedArray) {
        super.mo20051a(context, typedArray);
        this.f9704ac = typedArray.getColor(34, -12303292);
        this.f9702aa = typedArray.getDimension(37, 0.0f);
        this.f9699X = typedArray.getBoolean(8, true);
        this.f9700Y = typedArray.getColor(35, Color.parseColor("#30FFFFFF"));
        this.f9701Z = typedArray.getDimension(36, (float) C2913d.m13172a(context, 0.5f));
        this.f9703ab = typedArray.getDimension(38, 0.0f);
        this.f9708ag = this.f9703ab;
        this.f9723av = typedArray.getDimension(33, (float) C2913d.m13172a(context, 1.0f));
        this.f9724aw = typedArray.getDimension(32, 0.0f);
        this.f9725ax = typedArray.getColor(31, ViewCompat.MEASURED_STATE_MASK);
        boolean z = false;
        this.f9722au = typedArray.getBoolean(7, false);
        if (typedArray.hasValue(34) || !this.f9722au) {
            z = true;
        }
        this.f9698W = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo20050a() {
        super.mo20050a();
        this.f9705ad = new Paint(1);
        this.f9705ad.setStyle(Style.FILL);
        this.f9705ad.setColor(this.f9704ac);
        if (this.f9722au) {
            m13133i();
        }
        if (this.f9699X) {
            m13134j();
        }
    }

    /* renamed from: i */
    private void m13133i() {
        if (this.f9706ae == null) {
            this.f9706ae = new Paint(1);
            this.f9706ae.setColor(this.f9725ax);
            if (!this.f9698W) {
                this.f9706ae.setStrokeWidth(this.f9723av);
                this.f9706ae.setStyle(Style.STROKE);
            }
        }
    }

    /* renamed from: j */
    private void m13134j() {
        if (this.f9707af == null) {
            this.f9707af = new Paint(1);
            this.f9707af.setColor(this.f9700Y);
            this.f9707af.setStrokeWidth(this.f9701Z);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo20054b() {
        super.mo20054b();
        if (this.f9708ag == 0.0f || this.f9703ab < this.f9744S) {
            this.f9703ab = this.f9744S + ((float) (C2913d.m13172a(this.f9788n, 2.0f) * 4));
        }
    }

    /* renamed from: b */
    private void m13132b(float f) {
        float f2;
        boolean z = false;
        if (this.f9780f) {
            if (this.f9722au) {
                float f3 = this.f9729D;
                float f4 = this.f9729D + this.f9709ah;
                float f5 = this.f9723av;
                this.f9715an = new RectF(f3, f, f4 + (f5 * 2.0f), this.f9703ab + f + (f5 * 2.0f));
                float f6 = this.f9729D;
                float f7 = this.f9723av;
                float f8 = f6 + f7;
                float f9 = f7 + f;
                float f10 = this.f9729D + this.f9709ah;
                float f11 = this.f9723av;
                this.f9710ai = new RectF(f8, f9, f10 + f11, this.f9703ab + f + f11);
            } else {
                this.f9710ai = new RectF(this.f9729D, f, this.f9729D + this.f9709ah, this.f9703ab + f);
            }
            f2 = this.f9729D + this.f9709ah + this.f9795u + this.f9730E + this.f9731F + (this.f9723av * 2.0f);
            if (!this.f9781g && !this.f9782h && !this.f9783i) {
                m13131a(this.f9710ai);
                z = true;
            }
        } else {
            f2 = this.f9729D;
        }
        if (this.f9781g) {
            if (this.f9722au) {
                float f12 = this.f9703ab;
                float f13 = f2 + f12;
                float f14 = this.f9723av;
                this.f9716ao = new RectF(f2, f, f13 + (f14 * 2.0f), f12 + f + (f14 * 2.0f));
                float f15 = this.f9723av;
                float f16 = f2 + f15;
                float f17 = f + f15;
                float f18 = this.f9703ab;
                this.f9711aj = new RectF(f16, f17, f2 + f18 + f15, f18 + f + f15);
            } else {
                float f19 = this.f9703ab;
                this.f9711aj = new RectF(f2, f, f2 + f19, f19 + f);
            }
            f2 = f2 + this.f9703ab + this.f9796v + this.f9734I + this.f9735J + (this.f9723av * 2.0f);
            if (!z) {
                m13131a(this.f9711aj);
                z = true;
            }
        }
        if (this.f9782h) {
            if (this.f9722au) {
                float f20 = this.f9703ab;
                float f21 = f2 + f20;
                float f22 = this.f9723av;
                this.f9717ap = new RectF(f2, f, f21 + (f22 * 2.0f), f20 + f + (f22 * 2.0f));
                float f23 = this.f9723av;
                float f24 = f2 + f23;
                float f25 = f + f23;
                float f26 = this.f9703ab;
                this.f9712ak = new RectF(f24, f25, f2 + f26 + f23, f26 + f + f23);
            } else {
                float f27 = this.f9703ab;
                this.f9712ak = new RectF(f2, f, f2 + f27, f27 + f);
            }
            f2 = f2 + this.f9703ab + this.f9797w + this.f9736K + this.f9737L + (this.f9723av * 2.0f);
            if (!z) {
                m13131a(this.f9712ak);
                z = true;
            }
        }
        if (this.f9783i) {
            if (this.f9722au) {
                float f28 = this.f9703ab;
                float f29 = f2 + f28;
                float f30 = this.f9723av;
                this.f9718aq = new RectF(f2, f, f29 + (f30 * 2.0f), f28 + f + (f30 * 2.0f));
                float f31 = this.f9723av;
                float f32 = f2 + f31;
                float f33 = f + f31;
                float f34 = this.f9703ab;
                this.f9713al = new RectF(f32, f33, f2 + f34 + f31, f34 + f + f31);
            } else {
                float f35 = this.f9703ab;
                this.f9713al = new RectF(f2, f, f2 + f35, f35 + f);
            }
            if (this.f9784j) {
                float f36 = f2 + this.f9703ab + this.f9798x + this.f9732G + this.f9733H;
                float f37 = this.f9723av;
                float f38 = f36 + (f37 * 2.0f);
                if (this.f9722au) {
                    float f39 = this.f9703ab;
                    this.f9719ar = new RectF(f38, f, f38 + f39 + (f37 * 2.0f), f39 + f + (f37 * 2.0f));
                    float f40 = this.f9723av;
                    float f41 = f38 + f40;
                    float f42 = f + f40;
                    float f43 = this.f9703ab;
                    this.f9714am = new RectF(f41, f42, f38 + f43 + f40, f + f43 + f40);
                } else {
                    float f44 = this.f9703ab;
                    this.f9714am = new RectF(f38, f, f38 + f44, f44 + f);
                }
            }
            if (!z) {
                m13131a(this.f9713al);
            }
        }
    }

    /* renamed from: a */
    private float m13130a(String str, float f) {
        float f2;
        float f3;
        Rect rect = new Rect();
        this.f9727B.getTextBounds(str, 0, str.length(), rect);
        int i = this.f9747V;
        if (i == 0) {
            return f - ((float) rect.top);
        }
        if (i != 2) {
            float f4 = this.f9703ab;
            f2 = ((f + f4) - (f4 / 2.0f)) + ((float) (rect.height() / 2));
            f3 = this.f9723av;
        } else {
            f2 = (f + this.f9703ab) - ((float) rect.bottom);
            f3 = this.f9723av * 2.0f;
        }
        return f2 + f3;
    }

    /* renamed from: a */
    private void m13131a(RectF rectF) {
        FontMetrics fontMetrics = this.f9726A.getFontMetrics();
        this.f9721at = ((rectF.top + ((((rectF.bottom - rectF.top) - fontMetrics.bottom) + fontMetrics.top) / 2.0f)) - fontMetrics.top) - this.f9746U;
        this.f9720as = rectF.centerY() + (this.f9701Z == ((float) C2913d.m13172a(this.f9788n, 0.5f)) ? this.f9701Z : this.f9701Z / 2.0f);
    }

    /* renamed from: a */
    private float m13129a(int i, int i2, int i3, int i4) {
        float f = i2 == i3 ? (float) ((i - i4) / 2) : (float) i2;
        if (this.f9780f && this.f9795u > 0.0f) {
            this.f9739N = m13130a(this.f9790p, f);
        }
        if (this.f9781g && this.f9796v > 0.0f) {
            this.f9740O = m13130a(this.f9791q, f);
        }
        if (this.f9782h && this.f9797w > 0.0f) {
            this.f9741P = m13130a(this.f9792r, f);
        }
        if (this.f9798x > 0.0f) {
            this.f9742Q = m13130a(this.f9793s, f);
        }
        if (this.f9784j && this.f9799y > 0.0f) {
            this.f9743R = m13130a(this.f9794t, f);
        }
        return f;
    }

    /* renamed from: c */
    public int mo20055c() {
        float f;
        float a = mo20057a(this.f9703ab + (this.f9723av * 2.0f));
        if (this.f9780f) {
            if (this.f9800z) {
                Rect rect = new Rect();
                String valueOf = String.valueOf(this.f9752a);
                this.f9726A.getTextBounds(valueOf, 0, valueOf.length(), rect);
                this.f9709ah = (float) (rect.width() + (C2913d.m13172a(this.f9788n, 2.0f) * 4));
                f = this.f9709ah;
            } else {
                f = this.f9703ab;
                this.f9709ah = f;
            }
            a = a + f + (this.f9723av * 2.0f);
        }
        return (int) Math.ceil((double) a);
    }

    /* renamed from: d */
    public int mo20056d() {
        return (int) (this.f9703ab + (this.f9723av * 2.0f));
    }

    /* renamed from: a */
    public void mo20053a(View view, int i, int i2, int i3, int i4) {
        float a = m13129a(i2, view.getPaddingTop(), view.getPaddingBottom(), i4);
        this.f9729D = view.getPaddingLeft() == view.getPaddingRight() ? (float) ((i - i3) / 2) : (float) view.getPaddingLeft();
        m13132b(a);
    }

    /* renamed from: a */
    public void mo20052a(Canvas canvas) {
        float f;
        if (this.f9780f) {
            if (this.f9722au) {
                RectF rectF = this.f9715an;
                float f2 = this.f9724aw;
                canvas.drawRoundRect(rectF, f2, f2, this.f9706ae);
            }
            if (this.f9698W) {
                RectF rectF2 = this.f9710ai;
                float f3 = this.f9702aa;
                canvas.drawRoundRect(rectF2, f3, f3, this.f9705ad);
                if (this.f9699X) {
                    canvas.drawLine(this.f9729D + this.f9723av, this.f9720as, this.f9729D + this.f9709ah + this.f9723av, this.f9720as, this.f9707af);
                }
            }
            canvas.drawText(C2913d.m13173a(this.f9752a), this.f9710ai.centerX(), this.f9721at, this.f9726A);
            if (this.f9795u > 0.0f) {
                canvas.drawText(this.f9790p, this.f9729D + this.f9709ah + this.f9730E + (this.f9723av * 2.0f), this.f9739N, this.f9727B);
            }
            f = this.f9729D + this.f9709ah + this.f9795u + this.f9730E + this.f9731F + (this.f9723av * 2.0f);
        } else {
            f = this.f9729D;
        }
        if (this.f9781g) {
            if (this.f9722au) {
                RectF rectF3 = this.f9716ao;
                float f4 = this.f9724aw;
                canvas.drawRoundRect(rectF3, f4, f4, this.f9706ae);
            }
            if (this.f9698W) {
                RectF rectF4 = this.f9711aj;
                float f5 = this.f9702aa;
                canvas.drawRoundRect(rectF4, f5, f5, this.f9705ad);
                if (this.f9699X) {
                    float f6 = this.f9723av;
                    float f7 = f + f6;
                    float f8 = this.f9720as;
                    canvas.drawLine(f7, f8, this.f9703ab + f + f6, f8, this.f9707af);
                }
            }
            canvas.drawText(C2913d.m13173a(this.f9776b), this.f9711aj.centerX(), this.f9721at, this.f9726A);
            if (this.f9796v > 0.0f) {
                canvas.drawText(this.f9791q, this.f9703ab + f + this.f9734I + (this.f9723av * 2.0f), this.f9740O, this.f9727B);
            }
            f = f + this.f9703ab + this.f9796v + this.f9734I + this.f9735J + (this.f9723av * 2.0f);
        }
        if (this.f9782h) {
            if (this.f9722au) {
                RectF rectF5 = this.f9717ap;
                float f9 = this.f9724aw;
                canvas.drawRoundRect(rectF5, f9, f9, this.f9706ae);
            }
            if (this.f9698W) {
                RectF rectF6 = this.f9712ak;
                float f10 = this.f9702aa;
                canvas.drawRoundRect(rectF6, f10, f10, this.f9705ad);
                if (this.f9699X) {
                    float f11 = this.f9723av;
                    float f12 = f + f11;
                    float f13 = this.f9720as;
                    canvas.drawLine(f12, f13, this.f9703ab + f + f11, f13, this.f9707af);
                }
            }
            canvas.drawText(C2913d.m13173a(this.f9777c), this.f9712ak.centerX(), this.f9721at, this.f9726A);
            if (this.f9797w > 0.0f) {
                canvas.drawText(this.f9792r, this.f9703ab + f + this.f9736K + (this.f9723av * 2.0f), this.f9741P, this.f9727B);
            }
            f = f + this.f9703ab + this.f9797w + this.f9736K + this.f9737L + (this.f9723av * 2.0f);
        }
        if (this.f9783i) {
            if (this.f9722au) {
                RectF rectF7 = this.f9718aq;
                float f14 = this.f9724aw;
                canvas.drawRoundRect(rectF7, f14, f14, this.f9706ae);
            }
            if (this.f9698W) {
                RectF rectF8 = this.f9713al;
                float f15 = this.f9702aa;
                canvas.drawRoundRect(rectF8, f15, f15, this.f9705ad);
                if (this.f9699X) {
                    float f16 = this.f9723av;
                    float f17 = f + f16;
                    float f18 = this.f9720as;
                    canvas.drawLine(f17, f18, this.f9703ab + f + f16, f18, this.f9707af);
                }
            }
            canvas.drawText(C2913d.m13173a(this.f9778d), this.f9713al.centerX(), this.f9721at, this.f9726A);
            if (this.f9798x > 0.0f) {
                canvas.drawText(this.f9793s, this.f9703ab + f + this.f9732G + (this.f9723av * 2.0f), this.f9742Q, this.f9727B);
            }
            if (this.f9784j) {
                if (this.f9722au) {
                    RectF rectF9 = this.f9719ar;
                    float f19 = this.f9724aw;
                    canvas.drawRoundRect(rectF9, f19, f19, this.f9706ae);
                }
                float f20 = f + this.f9703ab + this.f9798x + this.f9732G + this.f9733H + (this.f9723av * 2.0f);
                if (this.f9698W) {
                    RectF rectF10 = this.f9714am;
                    float f21 = this.f9702aa;
                    canvas.drawRoundRect(rectF10, f21, f21, this.f9705ad);
                    if (this.f9699X) {
                        float f22 = this.f9723av;
                        float f23 = f20 + f22;
                        float f24 = this.f9720as;
                        canvas.drawLine(f23, f24, this.f9703ab + f20 + f22, f24, this.f9707af);
                    }
                }
                canvas.drawText(C2913d.m13175b(this.f9779e), this.f9714am.centerX(), this.f9721at, this.f9726A);
                if (this.f9799y > 0.0f) {
                    canvas.drawText(this.f9794t, f20 + this.f9703ab + this.f9738M + (this.f9723av * 2.0f), this.f9743R, this.f9727B);
                }
            }
        }
    }
}
