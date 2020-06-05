package com.bumptech.glide.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* renamed from: com.bumptech.glide.util.d */
public final class Executors {
    /* renamed from: a */
    private static final Executor f4910a = new Executor() {
        /* renamed from: a */
        private final Handler f4912a = new Handler(Looper.getMainLooper());

        public void execute(Runnable runnable) {
            this.f4912a.post(runnable);
        }
    };
    /* renamed from: b */
    private static final Executor f4911b = new Executor() {
        public void execute(Runnable runnable) {
            runnable.run();
        }
    };

    /* renamed from: a */
    public static Executor m6122a() {
        return f4910a;
    }

    /* renamed from: b */
    public static Executor m6123b() {
        return f4911b;
    }
}
