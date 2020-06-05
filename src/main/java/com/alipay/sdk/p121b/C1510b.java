package com.alipay.sdk.p121b;

import android.content.Context;
import com.alipay.sdk.p124e.C1526b;
import com.alipay.sdk.p124e.p125a.C1523b;
import com.alipay.sdk.util.C1542e;

/* renamed from: com.alipay.sdk.b.b */
class C1510b implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f3876a;
    /* renamed from: b */
    final /* synthetic */ C1508a f3877b;

    C1510b(C1508a aVar, Context context) {
        this.f3877b = aVar;
        this.f3876a = context;
    }

    public void run() {
        try {
            C1526b a = new C1523b().mo12184a(this.f3876a);
            if (a != null) {
                this.f3877b.m4474b(a.mo12177b());
                this.f3877b.m4477i();
            }
        } catch (Throwable th) {
            C1542e.m4633a(th);
        }
    }
}
