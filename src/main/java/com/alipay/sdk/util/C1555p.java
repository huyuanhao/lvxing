package com.alipay.sdk.util;

import android.app.Activity;

/* renamed from: com.alipay.sdk.util.p */
final class C1555p implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Activity f3969a;

    C1555p(Activity activity) {
        this.f3969a = activity;
    }

    public void run() {
        this.f3969a.finish();
    }
}
