package com.alipay.sdk.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.alipay.sdk.app.statistic.C1505a;

/* renamed from: com.alipay.sdk.app.d */
class C1497d implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1496c f3828a;

    C1497d(C1496c cVar) {
        this.f3828a = cVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3828a.f3827c.f3820b = true;
        C1505a.m4452a("net", "SSLProceed", "1");
        this.f3828a.f3826b.proceed();
        dialogInterface.dismiss();
    }
}
