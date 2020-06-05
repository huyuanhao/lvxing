package com.alipay.sdk.widget;

import android.view.View;

/* renamed from: com.alipay.sdk.widget.r */
class C1578r implements Runnable {
    /* renamed from: a */
    final /* synthetic */ View f4017a;
    /* renamed from: b */
    final /* synthetic */ C1577q f4018b;

    C1578r(C1577q qVar, View view) {
        this.f4018b = qVar;
        this.f4017a = view;
    }

    public void run() {
        this.f4017a.setEnabled(true);
    }
}
