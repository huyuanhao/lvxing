package com.alipay.android.phone.mrpc.core;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.alipay.android.phone.mrpc.core.n */
final class C1423n implements ThreadFactory {
    /* renamed from: a */
    private final AtomicInteger f3647a = new AtomicInteger(1);

    C1423n() {
    }

    public final Thread newThread(Runnable runnable) {
        StringBuilder sb = new StringBuilder("com.alipay.mobile.common.transport.http.HttpManager.HttpWorker #");
        sb.append(this.f3647a.getAndIncrement());
        Thread thread = new Thread(runnable, sb.toString());
        thread.setPriority(4);
        return thread;
    }
}
