package com.bytedance.tea.crash.p218e;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.bytedance.tea.crash.e.g */
public class LooperTrace {
    /* renamed from: a */
    private static final AtomicReference<Long> f9348a = new AtomicReference<>(Long.valueOf(0));

    /* renamed from: a */
    public static void m12472a(long j) {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (((long) i) < 5) {
                long longValue = ((Long) f9348a.get()).longValue();
                if (!f9348a.compareAndSet(Long.valueOf(longValue), Long.valueOf(longValue | j))) {
                    i = i2;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }
}
