package com.bytedance.sdk.openadsdk.utils;

import com.bytedance.sdk.openadsdk.downloadnew.p181a.LibHolder;

/* renamed from: com.bytedance.sdk.openadsdk.utils.l */
public class FreeSpaceHelper {
    /* renamed from: a */
    public static volatile long f9175a;

    /* renamed from: a */
    public static void m12182a() {
        try {
            f9175a = MemorySize.m12227a(LibHolder.f8618a);
        } catch (Throwable unused) {
        }
    }
}
