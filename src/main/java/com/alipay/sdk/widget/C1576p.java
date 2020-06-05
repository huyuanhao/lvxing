package com.alipay.sdk.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.alipay.sdk.app.C1503j;
import com.alipay.sdk.app.statistic.C1505a;

/* renamed from: com.alipay.sdk.widget.p */
class C1576p implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1574n f4015a;

    C1576p(C1574n nVar) {
        this.f4015a = nVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4015a.f4012a.cancel();
        this.f4015a.f4013b.f4002e = false;
        C1505a.m4452a("net", "SSLDenied", "2");
        C1503j.m4439a(C1503j.m4442c());
        this.f4015a.f4013b.f3995a.finish();
    }
}
