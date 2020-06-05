package com.alipay.sdk.widget;

import com.alipay.sdk.util.C1542e;

/* renamed from: com.alipay.sdk.widget.c */
class C1562c implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1559a f3992a;

    C1562c(C1559a aVar) {
        this.f3992a = aVar;
    }

    public void run() {
        if (this.f3992a.f3982b != null && this.f3992a.f3982b.isShowing()) {
            try {
                this.f3992a.f3989i.removeMessages(1);
                this.f3992a.f3982b.dismiss();
            } catch (Exception e) {
                C1542e.m4633a(e);
            }
        }
    }
}
