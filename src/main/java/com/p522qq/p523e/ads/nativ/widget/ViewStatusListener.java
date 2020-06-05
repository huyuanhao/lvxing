package com.p522qq.p523e.ads.nativ.widget;

import android.view.MotionEvent;

/* renamed from: com.qq.e.ads.nativ.widget.ViewStatusListener */
public interface ViewStatusListener {
    void onAttachToWindow();

    void onDetachFromWindow();

    void onDispatchTouchEvent(MotionEvent motionEvent);

    void onWindowFocusChanged(boolean z);

    void onWindowVisibilityChanged(int i);
}
