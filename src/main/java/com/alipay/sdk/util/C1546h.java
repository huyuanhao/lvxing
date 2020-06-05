package com.alipay.sdk.util;

import com.alipay.sdk.app.AlipayResultActivity.C1490a;
import com.alipay.sdk.app.C1503j;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.alipay.sdk.util.h */
class C1546h implements C1490a {
    /* renamed from: a */
    final /* synthetic */ CountDownLatch f3961a;
    /* renamed from: b */
    final /* synthetic */ C1543f f3962b;

    C1546h(C1543f fVar, CountDownLatch countDownLatch) {
        this.f3962b = fVar;
        this.f3961a = countDownLatch;
    }

    /* renamed from: a */
    public void mo12099a(int i, String str, String str2) {
        this.f3962b.f3958g = C1503j.m4438a(i, str, str2);
        this.f3961a.countDown();
    }
}
