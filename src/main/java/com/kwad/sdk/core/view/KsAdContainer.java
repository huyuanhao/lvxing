package com.kwad.sdk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.kwad.sdk.p306a.C3803g.C3804a;

public class KsAdContainer extends RelativeLayout {
    /* renamed from: a */
    protected C3804a f14312a = new C3804a();

    public KsAdContainer(Context context) {
        super(context);
    }

    public KsAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsAdContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f14312a = new C3804a(getWidth(), getHeight());
            this.f14312a.mo23197a(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.f14312a.mo23200b(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public C3804a getTouchCoords() {
        return this.f14312a;
    }
}
