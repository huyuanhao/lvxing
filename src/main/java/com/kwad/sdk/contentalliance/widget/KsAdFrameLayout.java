package com.kwad.sdk.contentalliance.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;

public class KsAdFrameLayout extends FrameLayout {
    /* renamed from: a */
    private final List<GestureDetector> f13615a;

    public KsAdFrameLayout(Context context) {
        this(context, null);
    }

    public KsAdFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KsAdFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13615a = new ArrayList();
    }

    /* renamed from: a */
    public void mo23712a(GestureDetector gestureDetector) {
        if (gestureDetector != null && !this.f13615a.contains(gestureDetector)) {
            this.f13615a.add(gestureDetector);
        }
    }

    /* renamed from: b */
    public void mo23713b(GestureDetector gestureDetector) {
        if (gestureDetector != null) {
            this.f13615a.remove(gestureDetector);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        for (GestureDetector onTouchEvent : this.f13615a) {
            dispatchTouchEvent = onTouchEvent.onTouchEvent(motionEvent) || dispatchTouchEvent;
        }
        return dispatchTouchEvent;
    }
}
