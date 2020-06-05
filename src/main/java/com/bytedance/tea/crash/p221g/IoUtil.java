package com.bytedance.tea.crash.p221g;

import java.io.Closeable;

/* renamed from: com.bytedance.tea.crash.g.f */
public final class IoUtil {
    /* renamed from: a */
    public static void m12535a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
