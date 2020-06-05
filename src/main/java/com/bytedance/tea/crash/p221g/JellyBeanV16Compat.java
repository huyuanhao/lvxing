package com.bytedance.tea.crash.p221g;

import android.app.ActivityManager.MemoryInfo;
import android.os.Build.VERSION;

/* renamed from: com.bytedance.tea.crash.g.g */
public class JellyBeanV16Compat {
    /* renamed from: a */
    static final C2595a f9374a;

    /* compiled from: JellyBeanV16Compat */
    /* renamed from: com.bytedance.tea.crash.g.g$a */
    private static class C2595a {
        /* renamed from: a */
        public long mo17071a(MemoryInfo memoryInfo) {
            return 0;
        }

        private C2595a() {
        }
    }

    /* compiled from: JellyBeanV16Compat */
    /* renamed from: com.bytedance.tea.crash.g.g$b */
    private static class C2596b extends C2595a {
        private C2596b() {
            super();
        }

        /* renamed from: a */
        public long mo17071a(MemoryInfo memoryInfo) {
            return memoryInfo.totalMem;
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f9374a = new C2596b();
        } else {
            f9374a = new C2595a();
        }
    }

    /* renamed from: a */
    public static long m12536a(MemoryInfo memoryInfo) {
        return f9374a.mo17071a(memoryInfo);
    }
}
