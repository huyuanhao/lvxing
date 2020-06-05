package com.p368pw.inner.p369a.p378d;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* renamed from: com.pw.inner.a.d.c */
public class C4910c extends FrameLayout {
    /* renamed from: a */
    private final boolean f15869a;

    public C4910c(Context context, boolean z) {
        super(context);
        this.f15869a = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f15869a;
    }
}
