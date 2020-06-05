package com.qiyukf.basesdk.p412c.p417d;

import java.math.BigDecimal;

/* renamed from: com.qiyukf.basesdk.c.d.f */
public final class C5414f {
    /* renamed from: a */
    public static long m22157a(long j) {
        return (long) new BigDecimal((double) (((float) j) / 1000.0f)).setScale(0, 4).intValue();
    }

    /* renamed from: a */
    public static String m22158a(int i) {
        if (i < 0 || i >= 10) {
            return String.valueOf(i);
        }
        StringBuilder sb = new StringBuilder("0");
        sb.append(Integer.toString(i));
        return sb.toString();
    }
}
