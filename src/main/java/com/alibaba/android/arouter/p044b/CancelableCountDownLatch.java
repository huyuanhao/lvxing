package com.alibaba.android.arouter.p044b;

import java.util.concurrent.CountDownLatch;

/* renamed from: com.alibaba.android.arouter.b.a */
public class CancelableCountDownLatch extends CountDownLatch {
    public CancelableCountDownLatch(int i) {
        super(i);
    }

    /* renamed from: a */
    public void mo10498a() {
        while (getCount() > 0) {
            countDown();
        }
    }
}
