package com.alipay.sdk.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.alipay.sdk.app.statistic.C1505a;

/* renamed from: com.alipay.sdk.widget.o */
class C1575o implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1574n f4014a;

    C1575o(C1574n nVar) {
        this.f4014a = nVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4014a.f4013b.f4002e = true;
        C1505a.m4452a("net", "SSLProceed", "2");
        this.f4014a.f4012a.proceed();
        dialogInterface.dismiss();
    }
}
