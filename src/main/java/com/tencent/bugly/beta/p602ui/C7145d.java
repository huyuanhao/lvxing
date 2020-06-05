package com.tencent.bugly.beta.p602ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import com.tencent.bugly.beta.global.C7127a;
import com.tencent.bugly.beta.global.C7129c;
import com.tencent.bugly.beta.global.C7131e;
import com.tencent.bugly.proguard.C7226an;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.ui.d */
public class C7145d implements OnPreDrawListener {
    /* renamed from: a */
    final int f23791a;
    /* renamed from: b */
    final Object[] f23792b;
    /* renamed from: c */
    long f23793c;
    /* renamed from: d */
    StringBuilder f23794d;

    public C7145d(int i, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("loading");
        this.f23794d = sb;
        this.f23791a = i;
        this.f23792b = objArr;
    }

    public boolean onPreDraw() {
        int i;
        int i2;
        boolean z = false;
        try {
            int i3 = this.f23791a;
            if (i3 == 1) {
                C7149h hVar = (C7149h) this.f23792b[0];
                TextView textView = (TextView) this.f23792b[1];
                Bitmap bitmap = (Bitmap) this.f23792b[2];
                int intValue = ((Integer) this.f23792b[3]).intValue();
                int measuredWidth = textView.getMeasuredWidth();
                int i4 = (int) (((double) measuredWidth) * 0.42857142857142855d);
                textView.setHeight(i4);
                if (hVar.f23813u == null) {
                    if (intValue == 2) {
                        hVar.f23813u = C7127a.m30543a(bitmap, measuredWidth, i4, (float) C7127a.m30540a(C7131e.f23698E.f23747s, 6.0f));
                    } else {
                        hVar.f23813u = C7127a.m30543a(bitmap, measuredWidth, i4, (float) C7127a.m30540a(C7131e.f23698E.f23747s, 0.0f));
                    }
                    if (hVar.f23813u != null) {
                        textView.setText("");
                        textView.setBackgroundDrawable(hVar.f23813u);
                        textView.getViewTreeObserver().removeOnPreDrawListener(this);
                        return true;
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f23793c > 300) {
                    this.f23793c = currentTimeMillis;
                    if (this.f23794d.length() > 9) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("loading");
                        this.f23794d = sb;
                    } else {
                        this.f23794d.append(".");
                    }
                    textView.setText(this.f23794d.toString());
                }
                return true;
            } else if (i3 == 2) {
                if (((Integer) this.f23792b[2]).intValue() > 0) {
                    int intValue2 = ((Integer) this.f23792b[0]).intValue();
                    TextView textView2 = (TextView) this.f23792b[1];
                    int measuredWidth2 = textView2.getMeasuredWidth();
                    int measuredHeight = textView2.getMeasuredHeight();
                    int i5 = (int) (((float) (C7131e.f23698E.f23701B.widthPixels * C7131e.f23698E.f23701B.heightPixels)) * 0.4f);
                    if (!(measuredWidth2 == 0 || measuredHeight == 0 || measuredWidth2 * measuredHeight > i5)) {
                        this.f23792b[2] = Integer.valueOf(0);
                        Paint paint = new Paint();
                        paint.setStyle(Style.FILL);
                        paint.setAntiAlias(true);
                        if (intValue2 == 2) {
                            i2 = 8;
                            i = 7;
                        } else {
                            i2 = 0;
                            i = 0;
                        }
                        paint.setColor(-3355444);
                        Bitmap createBitmap = Bitmap.createBitmap(measuredWidth2, measuredHeight, Config.ARGB_8888);
                        Canvas canvas = new Canvas(createBitmap);
                        float f = (float) measuredWidth2;
                        float f2 = (float) measuredHeight;
                        RectF rectF = new RectF(0.0f, 0.0f, f, f2);
                        float f3 = (float) i2;
                        canvas.drawRoundRect(rectF, f3, f3, paint);
                        paint.setColor(-1);
                        float f4 = (float) i;
                        canvas.drawRoundRect(new RectF(2.0f, 2.0f, f - 2.0f, f2 - 2.0f), f4, f4, paint);
                        paint.setColor(-3355444);
                        Bitmap createBitmap2 = Bitmap.createBitmap(measuredWidth2, measuredHeight, Config.ARGB_8888);
                        new Canvas(createBitmap2).drawRoundRect(rectF, f3, f3, paint);
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
                        BitmapDrawable bitmapDrawable2 = new BitmapDrawable(createBitmap2);
                        textView2.setBackgroundDrawable(bitmapDrawable);
                        textView2.setOnTouchListener(new C7129c(1, bitmapDrawable2, bitmapDrawable));
                    }
                }
                return true;
            } else if (i3 != 3) {
                return z;
            } else {
                ViewGroup viewGroup = (ViewGroup) this.f23792b[0];
                if (viewGroup.getMeasuredHeight() > C7127a.m30540a((Context) this.f23792b[1], 158.0f)) {
                    LayoutParams layoutParams = viewGroup.getLayoutParams();
                    layoutParams.height = C7127a.m30540a((Context) this.f23792b[1], 200.0f);
                    viewGroup.setLayoutParams(layoutParams);
                }
                return true;
            }
        } catch (Exception e) {
            if (!C7226an.m31145b(e)) {
                e.printStackTrace();
            }
            z = false;
        }
    }
}
