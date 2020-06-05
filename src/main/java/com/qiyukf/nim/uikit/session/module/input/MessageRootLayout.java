package com.qiyukf.nim.uikit.session.module.input;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.nim.uikit.session.emoji.EmoticonPickerView;

public class MessageRootLayout extends FrameLayout implements OnGlobalLayoutListener {
    /* renamed from: a */
    private MessageBottomContainer f17999a;
    /* renamed from: b */
    private EmoticonPickerView f18000b;
    /* renamed from: c */
    private boolean f18001c = false;
    /* renamed from: d */
    private int f18002d = -1;
    /* renamed from: e */
    private int f18003e = 0;
    /* renamed from: f */
    private int f18004f = 0;
    /* renamed from: g */
    private int f18005g = C5412d.m22150d();
    /* renamed from: h */
    private int f18006h = C5412d.m22151e();
    /* renamed from: i */
    private int f18007i = (this.f18005g + this.f18006h);

    public MessageRootLayout(Context context) {
        super(context);
        m22681a();
    }

    public MessageRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22681a();
    }

    public MessageRootLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22681a();
    }

    public MessageRootLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m22681a();
    }

    /* renamed from: a */
    private <T extends View> T m22679a(Class<T> cls, View view) {
        if (cls.isInstance(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                T a = m22679a(cls, viewGroup.getChildAt(i));
                if (a != null) {
                    return a;
                }
                i++;
            }
        }
        return null;
    }

    /* renamed from: a */
    private MessageBottomContainer m22680a(View view) {
        if (this.f17999a == null) {
            this.f17999a = (MessageBottomContainer) m22679a(MessageBottomContainer.class, view);
        }
        return this.f17999a;
    }

    /* renamed from: a */
    private void m22681a() {
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    /* renamed from: a */
    private void m22682a(boolean z) {
        this.f18001c = z;
        MessageBottomContainer a = m22680a((View) this);
        if (a != null) {
            a.mo27736a(z);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f18002d = -1;
        this.f18003e = 0;
        this.f18004f = 0;
        this.f18005g = C5412d.m22150d();
        this.f18006h = C5412d.m22151e();
        this.f18007i = this.f18005g + this.f18006h;
    }

    public void onGlobalLayout() {
        int height = getHeight();
        int i = this.f18004f;
        if (i == 0) {
            this.f18004f = height;
        } else if (i != height) {
            int abs = Math.abs(i - height);
            if (abs > this.f18007i) {
                this.f18004f = height;
                if (C5605d.m22701a(abs)) {
                    MessageBottomContainer a = m22680a((View) this);
                    if (a != null) {
                        a.mo27735a();
                    }
                    if (this.f18000b == null) {
                        this.f18000b = (EmoticonPickerView) m22679a(EmoticonPickerView.class, this);
                    }
                    EmoticonPickerView emoticonPickerView = this.f18000b;
                    if (emoticonPickerView != null) {
                        emoticonPickerView.mo27627a();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = this.f18003e;
        if (i5 != 0) {
            int abs = Math.abs(i5 - i4);
            boolean z2 = (abs == 0 || abs == this.f18005g || abs == this.f18006h || abs == this.f18007i) ? false : true;
            m22682a(z2);
        }
        if (this.f18003e + this.f18007i < i4) {
            this.f18003e = i4;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        MeasureSpec.getSize(i);
        int size = MeasureSpec.getSize(i2);
        if (size >= 0) {
            int i3 = this.f18002d;
            if (i3 < 0) {
                this.f18002d = size;
            } else {
                int i4 = i3 - size;
                this.f18002d = size;
                if (i4 != 0) {
                    MessageBottomContainer a = m22680a((View) this);
                    if (a != null) {
                        int i5 = this.f18007i;
                        if (i4 > i5) {
                            a.mo27737b();
                        } else if (i4 < (-i5) && this.f18001c) {
                            a.mo27738c();
                        }
                    }
                }
            }
        }
        super.onMeasure(i, i2);
    }
}
