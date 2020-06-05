package com.alipay.sdk.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.alipay.sdk.app.statistic.C1505a;

/* renamed from: com.alipay.sdk.app.e */
class C1498e implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1496c f3829a;

    C1498e(C1496c cVar) {
        this.f3829a = cVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3829a.f3826b.cancel();
        this.f3829a.f3827c.f3820b = false;
        C1505a.m4452a("net", "SSLDenied", "1");
        C1503j.m4439a(C1503j.m4442c());
        this.f3829a.f3825a.finish();
    }
}
