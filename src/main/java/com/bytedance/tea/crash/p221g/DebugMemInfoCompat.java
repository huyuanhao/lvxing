package com.bytedance.tea.crash.p221g;

import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;

/* renamed from: com.bytedance.tea.crash.g.b */
public class DebugMemInfoCompat {
    /* renamed from: a */
    static final C2591a f9371a;

    /* compiled from: DebugMemInfoCompat */
    /* renamed from: com.bytedance.tea.crash.g.b$a */
    private static class C2591a {
        /* renamed from: a */
        public int mo17068a(MemoryInfo memoryInfo) {
            return -1;
        }

        /* renamed from: b */
        public int mo17069b(MemoryInfo memoryInfo) {
            return -1;
        }

        /* renamed from: c */
        public int mo17070c(MemoryInfo memoryInfo) {
            return -1;
        }

        private C2591a() {
        }
    }

    /* compiled from: DebugMemInfoCompat */
    /* renamed from: com.bytedance.tea.crash.g.b$b */
    private static class C2592b extends C2591a {
        private C2592b() {
            super();
        }

        /* renamed from: a */
        public int mo17068a(MemoryInfo memoryInfo) {
            return memoryInfo.getTotalPrivateClean();
        }

        /* renamed from: b */
        public int mo17069b(MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSharedClean();
        }

        /* renamed from: c */
        public int mo17070c(MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSwappablePss();
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f9371a = new C2592b();
        } else {
            f9371a = new C2591a();
        }
    }

    /* renamed from: a */
    public static int m12508a(MemoryInfo memoryInfo) {
        return f9371a.mo17068a(memoryInfo);
    }

    /* renamed from: b */
    public static int m12509b(MemoryInfo memoryInfo) {
        return f9371a.mo17069b(memoryInfo);
    }

    /* renamed from: c */
    public static int m12510c(MemoryInfo memoryInfo) {
        return f9371a.mo17070c(memoryInfo);
    }
}
