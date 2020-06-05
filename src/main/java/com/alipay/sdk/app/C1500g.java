package com.alipay.sdk.app;

/* renamed from: com.alipay.sdk.app.g */
class C1500g implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f3831a;
    /* renamed from: b */
    final /* synthetic */ boolean f3832b;
    /* renamed from: c */
    final /* synthetic */ H5PayCallback f3833c;
    /* renamed from: d */
    final /* synthetic */ PayTask f3834d;

    C1500g(PayTask payTask, String str, boolean z, H5PayCallback h5PayCallback) {
        this.f3834d = payTask;
        this.f3831a = str;
        this.f3832b = z;
        this.f3833c = h5PayCallback;
    }

    public void run() {
        this.f3833c.onPayResult(this.f3834d.h5Pay(this.f3831a, this.f3832b));
    }
}
