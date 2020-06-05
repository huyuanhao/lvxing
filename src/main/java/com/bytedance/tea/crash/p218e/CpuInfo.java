package com.bytedance.tea.crash.p218e;

import com.bytedance.tea.crash.p221g.C2593d;

/* renamed from: com.bytedance.tea.crash.e.c */
public class CpuInfo {
    /* renamed from: a */
    public static long m12451a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("/proc/self/task/");
        sb.append(i);
        sb.append("/stat");
        String[] d = C2593d.m12533d(sb.toString());
        if (d == null) {
            return -1;
        }
        return (Long.parseLong(d[11]) * C2588a.m12477a()) + (Long.parseLong(d[12]) * C2588a.m12477a());
    }
}
