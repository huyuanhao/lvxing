package com.kwad.sdk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.kwad.sdk.p306a.C3803g.C3804a;

public class AdBaseFrameLayout extends FrameLayout {
    /* renamed from: a */
    private static final C3804a f14311a = new C3804a();

    public AdBaseFrameLayout(Context context) {
        super(context);
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            f14311a.mo23198a(getWidth(), getHeight());
            f14311a.mo23197a(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            f14311a.mo23200b(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public C3804a getTouchCoords() {
        return f14311a;
    }
}
