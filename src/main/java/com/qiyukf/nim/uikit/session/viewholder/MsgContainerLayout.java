package com.qiyukf.nim.uikit.session.viewholder;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class MsgContainerLayout extends FrameLayout {
    /* renamed from: a */
    private C5622b f18108a = null;

    public MsgContainerLayout(Context context) {
        super(context);
    }

    public MsgContainerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MsgContainerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MsgContainerLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* renamed from: a */
    public final void mo27798a(C5622b bVar) {
        this.f18108a = bVar;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C5622b bVar = this.f18108a;
        if (bVar != null) {
            bVar.onDetached();
        }
    }
}
