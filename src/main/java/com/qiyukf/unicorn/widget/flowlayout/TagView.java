package com.qiyukf.unicorn.widget.flowlayout;

import android.content.Context;
import android.widget.Checkable;
import android.widget.FrameLayout;

public class TagView extends FrameLayout implements Checkable {
    /* renamed from: b */
    private static final int[] f19865b = {16842912};
    /* renamed from: a */
    private boolean f19866a;

    public TagView(Context context) {
        super(context);
    }

    public boolean isChecked() {
        return this.f19866a;
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f19865b);
        }
        return onCreateDrawableState;
    }

    public void setChecked(boolean z) {
        if (this.f19866a != z) {
            this.f19866a = z;
            refreshDrawableState();
        }
    }

    public void toggle() {
        setChecked(!this.f19866a);
    }
}
