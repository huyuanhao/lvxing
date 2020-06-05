package com.alibaba.alibclinkpartner.p038a.p039a;

import android.os.Handler;
import android.os.Looper;

/* renamed from: com.alibaba.alibclinkpartner.a.a.a */
public class ALPCallbackCleaner {
    /* access modifiers changed from: private|static */
    /* renamed from: a */
    public static Handler f2222a = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static int f2223b = 300000;
    /* renamed from: c */
    private static C1094a f2224c = null;
    /* renamed from: d */
    private static boolean f2225d = false;

    /* compiled from: ALPCallbackCleaner */
    /* renamed from: com.alibaba.alibclinkpartner.a.a.a$a */
    public static class C1094a implements Runnable {
        public void run() {
            if (ALPCallbackManager.f2230a != null) {
                if (System.currentTimeMillis() - ALPCallbackManager.f2230a.f2229d > ((long) ALPCallbackCleaner.f2223b)) {
                    ALPCallbackManager.f2230a.mo10476a(0);
                    ALPCallbackManager.f2230a = null;
                    return;
                }
                ALPCallbackCleaner.f2222a.postDelayed(this, (long) ALPCallbackCleaner.f2223b);
            }
        }
    }

    /* renamed from: a */
    public static void m2109a() {
        if (f2225d) {
            C1094a aVar = f2224c;
            if (aVar != null) {
                f2222a.removeCallbacks(aVar);
            }
            f2225d = false;
        }
    }
}
