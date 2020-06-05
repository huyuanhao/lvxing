package com.ali.auth.third.p034ui.p037iv;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.ViewCompat;
import com.ali.auth.third.ui.R;

/* renamed from: com.ali.auth.third.ui.iv.AliUserSmsCodeView */
public class AliUserSmsCodeView extends View {
    /* renamed from: a */
    private StringBuilder f2157a;
    /* renamed from: b */
    private int f2158b = ViewCompat.MEASURED_STATE_MASK;
    /* renamed from: c */
    private float f2159c = 36.0f;
    /* renamed from: d */
    private int f2160d = 4;
    /* renamed from: e */
    private Paint f2161e;
    /* renamed from: f */
    private float f2162f = 6.0f;
    /* renamed from: g */
    private int f2163g;
    /* renamed from: h */
    private int f2164h;
    /* renamed from: i */
    private PointF[] f2165i;
    /* renamed from: j */
    private int f2166j = ViewCompat.MEASURED_STATE_MASK;
    /* renamed from: k */
    private int f2167k = ViewCompat.MEASURED_STATE_MASK;
    /* renamed from: l */
    private float f2168l = 1.0f;
    /* renamed from: m */
    private Paint f2169m;
    /* renamed from: n */
    private RectF[] f2170n;
    /* renamed from: o */
    private RectF[] f2171o;
    /* renamed from: p */
    private boolean f2172p = true;
    /* renamed from: q */
    private C1075b f2173q;
    /* renamed from: r */
    private C1074a f2174r;

    /* renamed from: com.ali.auth.third.ui.iv.AliUserSmsCodeView$a */
    public interface C1074a {
        /* renamed from: a */
        void mo10438a(String str);
    }

    /* renamed from: com.ali.auth.third.ui.iv.AliUserSmsCodeView$b */
    public interface C1075b {
        /* renamed from: a */
        void mo10439a(String str);
    }

    public AliUserSmsCodeView(Context context) {
        super(context);
        m2086a(context, null);
    }

    public AliUserSmsCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2086a(context, attributeSet);
    }

    public AliUserSmsCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2086a(context, attributeSet);
    }

    /* renamed from: a */
    private void m2086a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AliUserSmsCodeView);
            this.f2160d = obtainStyledAttributes.getInt(R.styleable.AliUserSmsCodeView_scTextCount, this.f2160d);
            this.f2158b = obtainStyledAttributes.getColor(R.styleable.AliUserSmsCodeView_scTextColor, this.f2158b);
            this.f2159c = obtainStyledAttributes.getDimension(R.styleable.AliUserSmsCodeView_scTextSize, TypedValue.applyDimension(2, this.f2159c, context.getResources().getDisplayMetrics()));
            this.f2162f = obtainStyledAttributes.getDimension(R.styleable.AliUserSmsCodeView_scDividerWidth, TypedValue.applyDimension(1, this.f2162f, context.getResources().getDisplayMetrics()));
            this.f2168l = obtainStyledAttributes.getDimension(R.styleable.AliUserSmsCodeView_scUnderLineStrokeWidth, TypedValue.applyDimension(1, this.f2168l, context.getResources().getDisplayMetrics()));
            this.f2166j = obtainStyledAttributes.getColor(R.styleable.AliUserSmsCodeView_scUnderLineColor, this.f2166j);
            this.f2167k = obtainStyledAttributes.getColor(R.styleable.AliUserSmsCodeView_scNextUnderLineColor, this.f2167k);
            obtainStyledAttributes.recycle();
        }
        this.f2157a = new StringBuilder(this.f2160d);
        int i = this.f2160d;
        this.f2165i = new PointF[i];
        this.f2170n = new RectF[i];
        this.f2171o = new RectF[i];
        m2087b();
        setFocusableInTouchMode(true);
    }

    /* renamed from: b */
    private void m2087b() {
        if (this.f2161e == null) {
            this.f2161e = new Paint(1);
        }
        this.f2161e.setStyle(Style.FILL_AND_STROKE);
        this.f2161e.setColor(this.f2158b);
        this.f2161e.setTextSize(this.f2159c);
        this.f2161e.setTextAlign(Align.CENTER);
        this.f2161e.setTypeface(Typeface.DEFAULT_BOLD);
        if (this.f2169m == null) {
            this.f2169m = new Paint(1);
        }
        this.f2169m.setStyle(Style.STROKE);
        this.f2169m.setColor(this.f2166j);
        this.f2169m.setStrokeWidth(this.f2168l);
    }

    /* renamed from: c */
    private void m2088c() {
        FontMetricsInt fontMetricsInt = this.f2161e.getFontMetricsInt();
        float measureText = this.f2161e.measureText("0");
        float f = (((float) (this.f2164h / 2)) + (((float) (fontMetricsInt.bottom - fontMetricsInt.top)) / 2.0f)) - ((float) fontMetricsInt.bottom);
        float f2 = (float) this.f2163g;
        int i = this.f2160d;
        float f3 = (f2 - (((float) (i - 1)) * this.f2162f)) / ((float) i);
        int i2 = 0;
        while (i2 < this.f2160d) {
            float f4 = (float) i2;
            float f5 = f4 * f3;
            this.f2165i[i2] = new PointF((this.f2162f * f4) + f5 + (f3 / 2.0f), f);
            RectF[] rectFArr = this.f2170n;
            float f6 = this.f2162f;
            int i3 = i2 + 1;
            rectFArr[i2] = new RectF(f5 + (f4 * f6), 0.0f, (((float) i3) * f3) + (f4 * f6), (float) this.f2164h);
            float f7 = measureText / 2.0f;
            this.f2171o[i2] = new RectF(this.f2165i[i2].x - f7, this.f2165i[i2].y + ((float) fontMetricsInt.top), this.f2165i[i2].x + f7, this.f2165i[i2].y + ((float) fontMetricsInt.bottom));
            i2 = i3;
        }
    }

    /* renamed from: a */
    public void mo10424a() {
        requestFocus();
        postDelayed(new Runnable() {
            public void run() {
                InputMethodManager inputMethodManager = (InputMethodManager) AliUserSmsCodeView.this.getContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(AliUserSmsCodeView.this, 2);
                }
            }
        }, 100);
    }

    /* renamed from: a */
    public void mo10425a(Canvas canvas, Paint paint, RectF rectF, RectF rectF2) {
        canvas.drawLine(rectF2.left - (rectF2.width() / 2.0f), rectF.bottom, rectF2.right + (rectF2.width() / 2.0f), rectF.bottom, paint);
    }

    public String getText() {
        StringBuilder sb = this.f2157a;
        return sb != null ? sb.toString() : "";
    }

    public int getTextCount() {
        return this.f2160d;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        C10732 r0 = new BaseInputConnection(this, false) {
            public boolean deleteSurroundingText(int i, int i2) {
                return sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67));
            }
        };
        editorInfo.actionLabel = null;
        editorInfo.inputType = 3;
        editorInfo.imeOptions = 5;
        return r0;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m2087b();
        int length = this.f2157a.length();
        int i = 0;
        while (i < this.f2160d) {
            if (i < length) {
                canvas.drawText(this.f2157a.toString(), i, i + 1, this.f2165i[i].x, this.f2165i[i].y, this.f2161e);
            }
            int i2 = this.f2166j;
            if ((hasFocus() && i == length) || i < length) {
                i2 = this.f2167k;
            }
            this.f2169m.setColor(i2);
            mo10425a(canvas, this.f2169m, this.f2170n[i], this.f2171o[i]);
            setBackgroundColor(-1);
            i++;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
            if (r0 != null) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
            if (r0 != null) goto L_0x001b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0070  */
    public boolean onKeyDown(int r4, android.view.KeyEvent r5) {
        /*
        r3 = this;
        r0 = 67
        if (r4 != r0) goto L_0x0028
        java.lang.StringBuilder r0 = r3.f2157a
        int r0 = r0.length()
        if (r0 <= 0) goto L_0x0028
        java.lang.StringBuilder r0 = r3.f2157a
        int r1 = r0.length()
        int r1 = r1 + -1
        r0.deleteCharAt(r1)
        com.ali.auth.third.ui.iv.AliUserSmsCodeView$b r0 = r3.f2173q
        if (r0 == 0) goto L_0x0024
    L_0x001b:
        java.lang.StringBuilder r1 = r3.f2157a
        java.lang.String r1 = r1.toString()
        r0.mo10439a(r1)
    L_0x0024:
        r3.invalidate()
        goto L_0x0047
    L_0x0028:
        r0 = 7
        if (r4 < r0) goto L_0x0047
        r0 = 16
        if (r4 > r0) goto L_0x0047
        java.lang.StringBuilder r0 = r3.f2157a
        int r0 = r0.length()
        int r1 = r3.f2160d
        if (r0 >= r1) goto L_0x0047
        java.lang.StringBuilder r0 = r3.f2157a
        char r1 = r5.getDisplayLabel()
        r0.append(r1)
        com.ali.auth.third.ui.iv.AliUserSmsCodeView$b r0 = r3.f2173q
        if (r0 == 0) goto L_0x0024
        goto L_0x001b
    L_0x0047:
        java.lang.StringBuilder r0 = r3.f2157a
        int r0 = r0.length()
        int r1 = r3.f2160d
        if (r0 < r1) goto L_0x0078
        boolean r0 = r3.f2172p
        if (r0 == 0) goto L_0x0078
        com.ali.auth.third.ui.iv.AliUserSmsCodeView$a r0 = r3.f2174r
        if (r0 == 0) goto L_0x0062
        java.lang.StringBuilder r1 = r3.f2157a
        java.lang.String r1 = r1.toString()
        r0.mo10438a(r1)
    L_0x0062:
        android.content.Context r0 = r3.getContext()
        java.lang.String r1 = "input_method"
        java.lang.Object r0 = r0.getSystemService(r1)
        android.view.inputmethod.InputMethodManager r0 = (android.view.inputmethod.InputMethodManager) r0
        if (r0 == 0) goto L_0x0078
        android.os.IBinder r1 = r3.getWindowToken()
        r2 = 0
        r0.hideSoftInputFromWindow(r1, r2)
    L_0x0078:
        boolean r4 = super.onKeyDown(r4, r5)
        return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.auth.third.p034ui.p037iv.AliUserSmsCodeView.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f2163g = MeasureSpec.getSize(i);
        this.f2164h = MeasureSpec.getSize(i2);
        m2088c();
        setMeasuredDimension(this.f2163g, this.f2164h);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0) {
            mo10424a();
        }
        return true;
    }

    public void setOnCompletedListener(C1074a aVar) {
        this.f2174r = aVar;
    }

    public void setOnTextChangedListener(C1075b bVar) {
        this.f2173q = bVar;
    }

    public void setTextCount(int i) {
        if (this.f2160d != i) {
            this.f2160d = i;
            invalidate();
        }
    }
}
