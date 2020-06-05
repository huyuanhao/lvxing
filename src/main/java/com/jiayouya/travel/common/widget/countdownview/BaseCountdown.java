package com.jiayouya.travel.common.widget.countdownview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.ViewCompat;

/* renamed from: com.jiayouya.travel.common.widget.countdownview.b */
class BaseCountdown {
    /* renamed from: A */
    protected Paint f9726A;
    /* renamed from: B */
    protected Paint f9727B;
    /* renamed from: C */
    protected Paint f9728C;
    /* renamed from: D */
    protected float f9729D;
    /* renamed from: E */
    protected float f9730E;
    /* renamed from: F */
    protected float f9731F;
    /* renamed from: G */
    protected float f9732G;
    /* renamed from: H */
    protected float f9733H;
    /* renamed from: I */
    protected float f9734I;
    /* renamed from: J */
    protected float f9735J;
    /* renamed from: K */
    protected float f9736K;
    /* renamed from: L */
    protected float f9737L;
    /* renamed from: M */
    protected float f9738M;
    /* renamed from: N */
    protected float f9739N;
    /* renamed from: O */
    protected float f9740O;
    /* renamed from: P */
    protected float f9741P;
    /* renamed from: Q */
    protected float f9742Q;
    /* renamed from: R */
    protected float f9743R;
    /* renamed from: S */
    protected float f9744S;
    /* renamed from: T */
    protected float f9745T;
    /* renamed from: U */
    protected float f9746U;
    /* renamed from: V */
    protected int f9747V;
    /* renamed from: W */
    private boolean f9748W;
    /* renamed from: X */
    private boolean f9749X;
    /* renamed from: Y */
    private boolean f9750Y;
    /* renamed from: Z */
    private boolean f9751Z;
    /* renamed from: a */
    public int f9752a;
    /* renamed from: aa */
    private boolean f9753aa;
    /* renamed from: ab */
    private boolean f9754ab;
    /* renamed from: ac */
    private float f9755ac;
    /* renamed from: ad */
    private int f9756ad;
    /* renamed from: ae */
    private float f9757ae;
    /* renamed from: af */
    private boolean f9758af;
    /* renamed from: ag */
    private int f9759ag;
    /* renamed from: ah */
    private float f9760ah;
    /* renamed from: ai */
    private boolean f9761ai;
    /* renamed from: aj */
    private float f9762aj;
    /* renamed from: ak */
    private float f9763ak;
    /* renamed from: al */
    private float f9764al;
    /* renamed from: am */
    private float f9765am;
    /* renamed from: an */
    private float f9766an;
    /* renamed from: ao */
    private float f9767ao;
    /* renamed from: ap */
    private float f9768ap;
    /* renamed from: aq */
    private float f9769aq;
    /* renamed from: ar */
    private float f9770ar;
    /* renamed from: as */
    private float f9771as;
    /* renamed from: at */
    private float f9772at;
    /* renamed from: au */
    private float f9773au;
    /* renamed from: av */
    private String f9774av;
    /* renamed from: aw */
    private String f9775aw;
    /* renamed from: b */
    public int f9776b;
    /* renamed from: c */
    public int f9777c;
    /* renamed from: d */
    public int f9778d;
    /* renamed from: e */
    public int f9779e;
    /* renamed from: f */
    public boolean f9780f;
    /* renamed from: g */
    public boolean f9781g;
    /* renamed from: h */
    public boolean f9782h;
    /* renamed from: i */
    public boolean f9783i;
    /* renamed from: j */
    public boolean f9784j;
    /* renamed from: k */
    public boolean f9785k;
    /* renamed from: l */
    public boolean f9786l;
    /* renamed from: m */
    public boolean f9787m;
    /* renamed from: n */
    protected Context f9788n;
    /* renamed from: o */
    protected String f9789o;
    /* renamed from: p */
    protected String f9790p;
    /* renamed from: q */
    protected String f9791q;
    /* renamed from: r */
    protected String f9792r;
    /* renamed from: s */
    protected String f9793s;
    /* renamed from: t */
    protected String f9794t;
    /* renamed from: u */
    protected float f9795u;
    /* renamed from: v */
    protected float f9796v;
    /* renamed from: w */
    protected float f9797w;
    /* renamed from: x */
    protected float f9798x;
    /* renamed from: y */
    protected float f9799y;
    /* renamed from: z */
    protected boolean f9800z;

    BaseCountdown() {
    }

    /* renamed from: a */
    public void mo20051a(Context context, TypedArray typedArray) {
        this.f9788n = context;
        this.f9758af = typedArray.getBoolean(10, false);
        this.f9757ae = typedArray.getDimension(40, C2913d.m13174b(this.f9788n, 12.0f));
        this.f9756ad = typedArray.getColor(39, ViewCompat.MEASURED_STATE_MASK);
        this.f9780f = typedArray.getBoolean(2, false);
        this.f9781g = typedArray.getBoolean(3, false);
        this.f9782h = typedArray.getBoolean(5, true);
        this.f9783i = typedArray.getBoolean(6, true);
        this.f9784j = typedArray.getBoolean(4, false);
        if (typedArray.getBoolean(1, true)) {
            this.f9785k = typedArray.getBoolean(0, false);
        }
        this.f9761ai = typedArray.getBoolean(9, false);
        this.f9760ah = typedArray.getDimension(30, C2913d.m13174b(this.f9788n, 12.0f));
        this.f9759ag = typedArray.getColor(29, ViewCompat.MEASURED_STATE_MASK);
        this.f9789o = typedArray.getString(12);
        this.f9790p = typedArray.getString(13);
        this.f9791q = typedArray.getString(17);
        this.f9792r = typedArray.getString(23);
        this.f9793s = typedArray.getString(26);
        this.f9794t = typedArray.getString(21);
        this.f9747V = typedArray.getInt(16, 1);
        this.f9755ac = typedArray.getDimension(20, -1.0f);
        this.f9730E = typedArray.getDimension(14, -1.0f);
        this.f9731F = typedArray.getDimension(15, -1.0f);
        this.f9734I = typedArray.getDimension(18, -1.0f);
        this.f9735J = typedArray.getDimension(19, -1.0f);
        this.f9736K = typedArray.getDimension(24, -1.0f);
        this.f9737L = typedArray.getDimension(25, -1.0f);
        this.f9732G = typedArray.getDimension(27, -1.0f);
        this.f9733H = typedArray.getDimension(28, -1.0f);
        this.f9738M = typedArray.getDimension(22, -1.0f);
        this.f9786l = typedArray.hasValue(2);
        this.f9787m = typedArray.hasValue(3);
        m13145j();
        if (!this.f9780f && !this.f9781g && !this.f9782h) {
            this.f9783i = true;
        }
        if (!this.f9783i) {
            this.f9784j = false;
        }
    }

    /* renamed from: e */
    public void mo20060e() {
        m13144i();
        mo20050a();
        m13146k();
        if (!this.f9783i) {
            this.f9784j = false;
        }
        mo20054b();
    }

    /* renamed from: i */
    private void m13144i() {
        this.f9748W = !TextUtils.isEmpty(this.f9790p);
        this.f9749X = !TextUtils.isEmpty(this.f9791q);
        this.f9750Y = !TextUtils.isEmpty(this.f9792r);
        this.f9751Z = !TextUtils.isEmpty(this.f9793s);
        this.f9753aa = !TextUtils.isEmpty(this.f9794t);
        if ((this.f9780f && this.f9748W) || ((this.f9781g && this.f9749X) || ((this.f9782h && this.f9750Y) || ((this.f9783i && this.f9751Z) || (this.f9784j && this.f9753aa))))) {
            this.f9754ab = true;
        }
        this.f9774av = this.f9792r;
        this.f9775aw = this.f9793s;
    }

    /* renamed from: j */
    private void m13145j() {
        this.f9765am = this.f9730E;
        this.f9766an = this.f9731F;
        this.f9767ao = this.f9734I;
        this.f9768ap = this.f9735J;
        this.f9769aq = this.f9736K;
        this.f9770ar = this.f9737L;
        this.f9771as = this.f9732G;
        this.f9772at = this.f9733H;
        this.f9773au = this.f9738M;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo20050a() {
        this.f9726A = new Paint(1);
        this.f9726A.setColor(this.f9756ad);
        this.f9726A.setTextAlign(Align.CENTER);
        this.f9726A.setTextSize(this.f9757ae);
        if (this.f9758af) {
            this.f9726A.setFakeBoldText(true);
        }
        this.f9727B = new Paint(1);
        this.f9727B.setColor(this.f9759ag);
        this.f9727B.setTextSize(this.f9760ah);
        if (this.f9761ai) {
            this.f9727B.setFakeBoldText(true);
        }
        this.f9728C = new Paint();
        this.f9728C.setTextSize(this.f9757ae);
        if (this.f9758af) {
            this.f9728C.setFakeBoldText(true);
        }
    }

    /* renamed from: k */
    private void m13146k() {
        float f;
        boolean z;
        String str = ":";
        float measureText = this.f9727B.measureText(str);
        if (!TextUtils.isEmpty(this.f9789o)) {
            z = false;
            f = this.f9727B.measureText(this.f9789o);
        } else {
            z = true;
            f = 0.0f;
        }
        if (!this.f9780f) {
            this.f9795u = 0.0f;
        } else if (this.f9748W) {
            this.f9795u = this.f9727B.measureText(this.f9790p);
        } else if (!z) {
            this.f9790p = this.f9789o;
            this.f9795u = f;
        } else if (!this.f9754ab) {
            this.f9790p = str;
            this.f9795u = measureText;
        }
        if (!this.f9781g) {
            this.f9796v = 0.0f;
        } else if (this.f9749X) {
            this.f9796v = this.f9727B.measureText(this.f9791q);
        } else if (!z) {
            this.f9791q = this.f9789o;
            this.f9796v = f;
        } else if (!this.f9754ab) {
            this.f9791q = str;
            this.f9796v = measureText;
        }
        if (!this.f9782h) {
            this.f9797w = 0.0f;
        } else if (this.f9750Y) {
            this.f9797w = this.f9727B.measureText(this.f9792r);
        } else if (!this.f9783i) {
            this.f9797w = 0.0f;
        } else if (!z) {
            this.f9792r = this.f9789o;
            this.f9797w = f;
        } else if (!this.f9754ab) {
            this.f9792r = str;
            this.f9797w = measureText;
        }
        if (!this.f9783i) {
            this.f9798x = 0.0f;
        } else if (this.f9751Z) {
            this.f9798x = this.f9727B.measureText(this.f9793s);
        } else if (!this.f9784j) {
            this.f9798x = 0.0f;
        } else if (!z) {
            this.f9793s = this.f9789o;
            this.f9798x = f;
        } else if (!this.f9754ab) {
            this.f9793s = str;
            this.f9798x = measureText;
        }
        if (!this.f9784j || !this.f9754ab || !this.f9753aa) {
            this.f9799y = 0.0f;
        } else {
            this.f9799y = this.f9727B.measureText(this.f9794t);
        }
        m13147l();
    }

    /* renamed from: l */
    private void m13147l() {
        int a = C2913d.m13172a(this.f9788n, 3.0f);
        boolean z = this.f9755ac < 0.0f;
        if (!this.f9780f || this.f9795u <= 0.0f) {
            this.f9730E = 0.0f;
            this.f9731F = 0.0f;
        } else {
            if (this.f9730E < 0.0f) {
                if (!z) {
                    this.f9730E = this.f9755ac;
                } else {
                    this.f9730E = (float) a;
                }
            }
            if (this.f9731F < 0.0f) {
                if (!z) {
                    this.f9731F = this.f9755ac;
                } else {
                    this.f9731F = (float) a;
                }
            }
        }
        if (!this.f9781g || this.f9796v <= 0.0f) {
            this.f9734I = 0.0f;
            this.f9735J = 0.0f;
        } else {
            if (this.f9734I < 0.0f) {
                if (!z) {
                    this.f9734I = this.f9755ac;
                } else {
                    this.f9734I = (float) a;
                }
            }
            if (this.f9735J < 0.0f) {
                if (!z) {
                    this.f9735J = this.f9755ac;
                } else {
                    this.f9735J = (float) a;
                }
            }
        }
        if (!this.f9782h || this.f9797w <= 0.0f) {
            this.f9736K = 0.0f;
            this.f9737L = 0.0f;
        } else {
            if (this.f9736K < 0.0f) {
                if (!z) {
                    this.f9736K = this.f9755ac;
                } else {
                    this.f9736K = (float) a;
                }
            }
            if (!this.f9783i) {
                this.f9737L = 0.0f;
            } else if (this.f9737L < 0.0f) {
                if (!z) {
                    this.f9737L = this.f9755ac;
                } else {
                    this.f9737L = (float) a;
                }
            }
        }
        if (this.f9783i) {
            if (this.f9798x > 0.0f) {
                if (this.f9732G < 0.0f) {
                    if (!z) {
                        this.f9732G = this.f9755ac;
                    } else {
                        this.f9732G = (float) a;
                    }
                }
                if (!this.f9784j) {
                    this.f9733H = 0.0f;
                } else if (this.f9733H < 0.0f) {
                    if (!z) {
                        this.f9733H = this.f9755ac;
                    } else {
                        this.f9733H = (float) a;
                    }
                }
            } else {
                this.f9732G = 0.0f;
                this.f9733H = 0.0f;
            }
            if (!this.f9784j || this.f9799y <= 0.0f) {
                this.f9738M = 0.0f;
            } else if (this.f9738M >= 0.0f) {
            } else {
                if (!z) {
                    this.f9738M = this.f9755ac;
                } else {
                    this.f9738M = (float) a;
                }
            }
        } else {
            this.f9732G = 0.0f;
            this.f9733H = 0.0f;
            this.f9738M = 0.0f;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo20054b() {
        Rect rect = new Rect();
        this.f9726A.getTextBounds("00", 0, 2, rect);
        this.f9744S = (float) rect.width();
        this.f9745T = (float) rect.height();
        this.f9746U = (float) rect.bottom;
    }

    /* renamed from: a */
    private void m13143a(int i, int i2, int i3) {
        if (i2 == i3) {
            this.f9764al = (((float) (i / 2)) + (this.f9745T / 2.0f)) - this.f9746U;
        } else {
            this.f9764al = (((float) (i - (i - i2))) + this.f9745T) - this.f9746U;
        }
        if (this.f9780f && this.f9795u > 0.0f) {
            this.f9739N = m13142a(this.f9790p);
        }
        if (this.f9781g && this.f9796v > 0.0f) {
            this.f9740O = m13142a(this.f9791q);
        }
        if (this.f9782h && this.f9797w > 0.0f) {
            this.f9741P = m13142a(this.f9792r);
        }
        if (this.f9798x > 0.0f) {
            this.f9742Q = m13142a(this.f9793s);
        }
        if (this.f9784j && this.f9799y > 0.0f) {
            this.f9743R = m13142a(this.f9794t);
        }
    }

    /* renamed from: a */
    private float m13142a(String str) {
        float f;
        int i;
        Rect rect = new Rect();
        this.f9727B.getTextBounds(str, 0, str.length(), rect);
        int i2 = this.f9747V;
        if (i2 == 0) {
            f = this.f9764al - this.f9745T;
            i = rect.top;
        } else if (i2 != 2) {
            return (this.f9764al - (this.f9745T / 2.0f)) + ((float) (rect.height() / 2));
        } else {
            f = this.f9764al;
            i = rect.bottom;
        }
        return f - ((float) i);
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final float mo20057a(float f) {
        float f2 = this.f9795u + this.f9796v + this.f9797w + this.f9798x + this.f9799y + this.f9730E + this.f9731F + this.f9734I + this.f9735J + this.f9736K + this.f9737L + this.f9732G + this.f9733H + this.f9738M;
        if (this.f9785k) {
            f2 += m13148m();
        } else if (this.f9781g) {
            f2 += f;
        }
        if (this.f9782h) {
            f2 += f;
        }
        if (this.f9783i) {
            f2 += f;
        }
        return this.f9784j ? f2 + f : f2;
    }

    /* renamed from: m */
    private float m13148m() {
        Rect rect = new Rect();
        float f = 0.0f;
        if (this.f9780f) {
            String a = C2913d.m13173a(this.f9752a);
            this.f9726A.getTextBounds(a, 0, a.length(), rect);
            this.f9762aj = (float) rect.width();
            f = 0.0f + this.f9762aj;
        }
        if (!this.f9781g) {
            return f;
        }
        String a2 = C2913d.m13173a(this.f9776b);
        this.f9728C.getTextBounds(a2, 0, a2.length(), rect);
        this.f9763ak = (float) rect.width();
        return f + this.f9763ak;
    }

    /* renamed from: c */
    public int mo20055c() {
        float f;
        float a = mo20057a(this.f9744S);
        if (!this.f9785k && this.f9780f) {
            if (this.f9800z) {
                Rect rect = new Rect();
                String valueOf = String.valueOf(this.f9752a);
                this.f9726A.getTextBounds(valueOf, 0, valueOf.length(), rect);
                this.f9762aj = (float) rect.width();
                f = this.f9762aj;
            } else {
                f = this.f9744S;
                this.f9762aj = f;
            }
            a += f;
        }
        return (int) Math.ceil((double) a);
    }

    /* renamed from: d */
    public int mo20056d() {
        return (int) this.f9745T;
    }

    /* renamed from: a */
    public void mo20053a(View view, int i, int i2, int i3, int i4) {
        m13143a(i2, view.getPaddingTop(), view.getPaddingBottom());
        this.f9729D = view.getPaddingLeft() == view.getPaddingRight() ? (float) ((i - i3) / 2) : (float) view.getPaddingLeft();
    }

    /* renamed from: a */
    public void mo20052a(Canvas canvas) {
        float f;
        if (this.f9780f) {
            canvas.drawText(C2913d.m13173a(this.f9752a), this.f9729D + (this.f9762aj / 2.0f), this.f9764al, this.f9726A);
            if (this.f9795u > 0.0f) {
                canvas.drawText(this.f9790p, this.f9729D + this.f9762aj + this.f9730E, this.f9739N, this.f9727B);
            }
            f = this.f9729D + this.f9762aj + this.f9795u + this.f9730E + this.f9731F;
        } else {
            f = this.f9729D;
        }
        if (this.f9781g) {
            float f2 = this.f9785k ? this.f9763ak : this.f9744S;
            canvas.drawText(C2913d.m13173a(this.f9776b), (f2 / 2.0f) + f, this.f9764al, this.f9726A);
            if (this.f9796v > 0.0f) {
                canvas.drawText(this.f9791q, f + f2 + this.f9734I, this.f9740O, this.f9727B);
            }
            f = f + f2 + this.f9796v + this.f9734I + this.f9735J;
        }
        if (this.f9782h) {
            canvas.drawText(C2913d.m13173a(this.f9777c), (this.f9744S / 2.0f) + f, this.f9764al, this.f9726A);
            if (this.f9797w > 0.0f) {
                canvas.drawText(this.f9792r, this.f9744S + f + this.f9736K, this.f9741P, this.f9727B);
            }
            f = f + this.f9744S + this.f9797w + this.f9736K + this.f9737L;
        }
        if (this.f9783i) {
            canvas.drawText(C2913d.m13173a(this.f9778d), (this.f9744S / 2.0f) + f, this.f9764al, this.f9726A);
            if (this.f9798x > 0.0f) {
                canvas.drawText(this.f9793s, this.f9744S + f + this.f9732G, this.f9742Q, this.f9727B);
            }
            if (this.f9784j) {
                float f3 = f + this.f9744S + this.f9798x + this.f9732G + this.f9733H;
                canvas.drawText(C2913d.m13175b(this.f9779e), (this.f9744S / 2.0f) + f3, this.f9764al, this.f9726A);
                if (this.f9799y > 0.0f) {
                    canvas.drawText(this.f9794t, f3 + this.f9744S + this.f9738M, this.f9743R, this.f9727B);
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo20059a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6 = false;
        if (!z4) {
            z5 = false;
        }
        if (this.f9780f != z) {
            this.f9780f = z;
            if (z) {
                this.f9730E = this.f9765am;
                this.f9731F = this.f9766an;
            }
        }
        if (this.f9781g != z2) {
            this.f9781g = z2;
            if (z2) {
                this.f9734I = this.f9767ao;
                this.f9735J = this.f9768ap;
            }
        }
        if (this.f9782h != z3) {
            this.f9782h = z3;
            if (z3) {
                this.f9736K = this.f9769aq;
                this.f9737L = this.f9770ar;
                this.f9792r = this.f9774av;
            }
        }
        if (this.f9783i != z4) {
            this.f9783i = z4;
            if (z4) {
                this.f9732G = this.f9771as;
                this.f9733H = this.f9772at;
                this.f9793s = this.f9775aw;
            } else {
                this.f9792r = this.f9774av;
            }
            this.f9736K = this.f9769aq;
            this.f9737L = this.f9770ar;
            z6 = true;
        }
        if (this.f9784j == z5) {
            return z6;
        }
        this.f9784j = z5;
        if (z5) {
            this.f9738M = this.f9773au;
        } else {
            this.f9793s = this.f9775aw;
        }
        this.f9732G = this.f9771as;
        this.f9733H = this.f9772at;
        return true;
    }

    /* renamed from: f */
    public boolean mo20061f() {
        if (!this.f9786l) {
            if (this.f9780f || this.f9752a <= 0) {
                if (this.f9780f && this.f9752a == 0) {
                    mo20059a(false, this.f9781g, this.f9782h, this.f9783i, this.f9784j);
                    return true;
                } else if (!this.f9787m) {
                    if (!this.f9781g && (this.f9752a > 0 || this.f9776b > 0)) {
                        mo20059a(this.f9780f, true, this.f9782h, this.f9783i, this.f9784j);
                        return true;
                    } else if (this.f9781g && this.f9752a == 0 && this.f9776b == 0) {
                        mo20059a(false, false, this.f9782h, this.f9783i, this.f9784j);
                        return true;
                    }
                }
            } else if (!this.f9787m) {
                mo20059a(true, true, this.f9782h, this.f9783i, this.f9784j);
                return true;
            } else {
                mo20059a(true, this.f9781g, this.f9782h, this.f9783i, this.f9784j);
                return true;
            }
        } else if (!this.f9787m) {
            if (!this.f9781g && (this.f9752a > 0 || this.f9776b > 0)) {
                mo20059a(this.f9780f, true, this.f9782h, this.f9783i, this.f9784j);
                return true;
            } else if (this.f9781g && this.f9752a == 0 && this.f9776b == 0) {
                mo20059a(this.f9780f, false, this.f9782h, this.f9783i, this.f9784j);
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    public boolean mo20062g() {
        if (this.f9780f) {
            if (!this.f9800z && this.f9752a > 99) {
                this.f9800z = true;
                return true;
            } else if (this.f9800z && this.f9752a <= 99) {
                this.f9800z = false;
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo20058a(int i, int i2, int i3, int i4, int i5) {
        this.f9752a = i;
        this.f9776b = i2;
        this.f9777c = i3;
        this.f9778d = i4;
        this.f9779e = i5;
    }

    /* renamed from: h */
    public void mo20063h() {
        m13146k();
        mo20054b();
    }
}
