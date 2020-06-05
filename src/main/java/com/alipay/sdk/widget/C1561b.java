package com.alipay.sdk.widget;

import com.alipay.sdk.util.C1542e;
import com.alipay.sdk.widget.C1559a.C1560a;

/* renamed from: com.alipay.sdk.widget.b */
class C1561b implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1559a f3991a;

    C1561b(C1559a aVar) {
        this.f3991a = aVar;
    }

    public void run() {
        if (this.f3991a.f3982b == null) {
            C1559a aVar = this.f3991a;
            aVar.f3982b = new C1560a(aVar.f3983c);
            this.f3991a.f3982b.setCancelable(this.f3991a.f3988h);
        }
        try {
            if (!this.f3991a.f3982b.isShowing()) {
                this.f3991a.f3982b.show();
                this.f3991a.f3989i.sendEmptyMessageDelayed(1, 15000);
            }
        } catch (Exception e) {
            C1542e.m4633a(e);
        }
    }
}
