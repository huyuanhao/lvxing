package com.alipay.android.phone.mrpc.core;

import java.io.Closeable;
import java.io.IOException;

/* renamed from: com.alipay.android.phone.mrpc.core.r */
public final class C1427r {
    /* renamed from: a */
    public static void m4144a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
