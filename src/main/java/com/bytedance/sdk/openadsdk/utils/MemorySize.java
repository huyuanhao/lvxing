package com.bytedance.sdk.openadsdk.utils;

import android.os.StatFs;
import android.text.TextUtils;

/* renamed from: com.bytedance.sdk.openadsdk.utils.u */
public class MemorySize {
    /* renamed from: a */
    public static long m12227a(String str) {
        StringBuilder sb;
        String str2 = ", ";
        String str3 = "getAvailableSize=";
        String str4 = "MemorySize";
        long j = 0;
        try {
            if (!TextUtils.isEmpty(str)) {
                StatFs statFs = new StatFs(str);
                j = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            }
            sb = new StringBuilder();
        } catch (Throwable unused) {
            sb = new StringBuilder();
        }
        sb.append(str3);
        sb.append(j);
        sb.append(str2);
        sb.append(String.valueOf(str));
        C2564t.m12220b(str4, sb.toString());
        return j;
    }
}
