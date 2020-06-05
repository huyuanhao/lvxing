package com.qiyukf.nimlib.p429a;

import com.qiyukf.basesdk.sdk.ResponseCode;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.qiyukf.nimlib.a.b */
public final class C5648b {
    /* renamed from: a */
    private static AtomicInteger f18178a = new AtomicInteger(1);

    /* renamed from: a */
    private static short m22818a(short s, short s2, boolean z) {
        return f18178a.compareAndSet(s, s2) ? s2 : m22819a(z);
    }

    /* renamed from: a */
    public static short m22819a(boolean z) {
        short addAndGet = (short) f18178a.addAndGet(1);
        return (addAndGet < 1000 || !z) ? (addAndGet >= 1000 || z) ? addAndGet : m22818a(addAndGet, ResponseCode.RES_EXCEPTION, false) : m22818a(addAndGet, 2, true);
    }
}
