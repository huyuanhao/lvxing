package com.p368pw.inner.base.p387d;

import android.os.Build.VERSION;
import android.view.View;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.pw.inner.base.d.u */
public class C5214u {
    /* renamed from: a */
    private static final AtomicInteger f16939a = new AtomicInteger(1);

    /* renamed from: a */
    public static int m21488a() {
        int i;
        int i2;
        if (VERSION.SDK_INT >= 17) {
            View.generateViewId();
        }
        do {
            i = f16939a.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!f16939a.compareAndSet(i, i2));
        return i;
    }
}
