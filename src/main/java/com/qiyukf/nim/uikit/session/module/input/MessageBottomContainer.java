package com.qiyukf.nim.uikit.session.module.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class MessageBottomContainer extends FrameLayout {
    /* renamed from: a */
    private boolean f17996a = false;
    /* renamed from: b */
    private boolean f17997b = false;

    public MessageBottomContainer(Context context) {
        super(context);
        mo27735a();
    }

    public MessageBottomContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo27735a();
    }

    public MessageBottomContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo27735a();
    }

    public MessageBottomContainer(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        mo27735a();
    }

    /* renamed from: a */
    public final void mo27735a() {
        if (!isInEditMode() && getHeight() != C5605d.m22699a()) {
            post(new Runnable() {
                public final void run() {
                    LayoutParams layoutParams = MessageBottomContainer.this.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new LayoutParams(-1, C5605d.m22699a());
                    } else {
                        layoutParams.height = C5605d.m22699a();
                    }
                    MessageBottomContainer.this.setLayoutParams(layoutParams);
                }
            });
        }
    }

    /* renamed from: a */
    public final void mo27736a(boolean z) {
        this.f17996a = z;
    }

    /* renamed from: b */
    public final void mo27737b() {
        this.f17997b = true;
    }

    /* renamed from: c */
    public final void mo27738c() {
        super.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        MeasureSpec.getSize(i);
        MeasureSpec.getSize(i2);
        if (this.f17997b) {
            setVisibility(8);
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = MeasureSpec.makeMeasureSpec(0, 1073741824);
            i = makeMeasureSpec;
        }
        super.onMeasure(i, i2);
    }

    public void setVisibility(int i) {
        if (i == 0) {
            this.f17997b = false;
        }
        if (i != getVisibility()) {
            if (!this.f17996a || i != 0) {
                super.setVisibility(i);
            }
        }
    }
}
