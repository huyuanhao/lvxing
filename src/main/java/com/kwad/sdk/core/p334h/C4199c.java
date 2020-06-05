package com.kwad.sdk.core.p334h;

import android.content.Context;
import android.view.TextureView;
import android.view.View.MeasureSpec;

/* renamed from: com.kwad.sdk.core.h.c */
public class C4199c extends TextureView {
    /* renamed from: a */
    private int f13969a;
    /* renamed from: b */
    private int f13970b;

    public C4199c(Context context) {
        super(context);
    }

    /* renamed from: a */
    public void mo23973a(int i, int i2) {
        if (this.f13970b != i && this.f13969a != i2) {
            this.f13970b = i;
            this.f13969a = i2;
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        float rotation = getRotation();
        if (rotation == 90.0f || rotation == 270.0f) {
            int i6 = i2;
            i2 = i;
            i = i6;
        }
        int defaultSize = getDefaultSize(this.f13970b, i);
        int defaultSize2 = getDefaultSize(this.f13969a, i2);
        if (this.f13970b > 0 && this.f13969a > 0) {
            int mode = MeasureSpec.getMode(i);
            i3 = MeasureSpec.getSize(i);
            int mode2 = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i7 = this.f13970b;
                int i8 = i7 * size;
                int i9 = this.f13969a;
                if (i8 < i3 * i9) {
                    defaultSize = (i7 * size) / i9;
                } else {
                    i4 = i7 * size > i3 * i9 ? (i9 * i3) / i7 : size;
                    setMeasuredDimension(i3, i4);
                }
            } else {
                if (mode == 1073741824) {
                    int i10 = this.f13969a;
                    int i11 = i3 * i10;
                    int i12 = this.f13970b;
                    int i13 = i11 / i12;
                    if (mode2 != Integer.MIN_VALUE || i13 <= size) {
                        i4 = i13;
                    } else {
                        defaultSize = (i12 * size) / i10;
                    }
                } else {
                    if (mode2 == 1073741824) {
                        int i14 = this.f13970b;
                        int i15 = size * i14;
                        int i16 = this.f13969a;
                        i5 = i15 / i16;
                        if (mode != Integer.MIN_VALUE || i5 <= i3) {
                            i4 = size;
                        } else {
                            i4 = (i16 * i3) / i14;
                        }
                    } else {
                        i5 = this.f13970b;
                        int i17 = this.f13969a;
                        if (mode2 != Integer.MIN_VALUE || i17 <= size) {
                            i4 = i17;
                        } else {
                            i5 = (i5 * size) / i17;
                            i4 = size;
                        }
                        if (mode == Integer.MIN_VALUE && i5 > i3) {
                            i4 = (this.f13969a * i3) / this.f13970b;
                        }
                    }
                    i3 = i5;
                }
                setMeasuredDimension(i3, i4);
            }
            defaultSize2 = size;
        }
        i3 = defaultSize;
        setMeasuredDimension(i3, i4);
    }

    public void setRotation(float f) {
        if (f != getRotation()) {
            super.setRotation(f);
            requestLayout();
        }
    }
}
