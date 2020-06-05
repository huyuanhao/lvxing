package com.alipay.sdk.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* renamed from: com.alipay.sdk.widget.d */
class C1563d extends Handler {
    /* renamed from: a */
    final /* synthetic */ C1559a f3993a;

    C1563d(C1559a aVar, Looper looper) {
        this.f3993a = aVar;
        super(looper);
    }

    public void dispatchMessage(Message message) {
        this.f3993a.mo12246b();
    }
}
