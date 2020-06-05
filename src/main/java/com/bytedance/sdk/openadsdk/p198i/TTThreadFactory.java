package com.bytedance.sdk.openadsdk.p198i;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.bytedance.sdk.openadsdk.i.d */
public class TTThreadFactory implements ThreadFactory {
    /* renamed from: a */
    private static final AtomicInteger f8973a = new AtomicInteger(1);
    /* renamed from: b */
    private final ThreadGroup f8974b;
    /* renamed from: c */
    private final AtomicInteger f8975c = new AtomicInteger(1);
    /* renamed from: d */
    private final String f8976d;
    /* renamed from: e */
    private final int f8977e;

    TTThreadFactory(int i, String str) {
        ThreadGroup threadGroup;
        this.f8977e = i;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.f8974b = threadGroup;
        String str2 = "-thread-";
        if (TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("ttbackground-");
            sb.append(f8973a.getAndIncrement());
            sb.append(str2);
            this.f8976d = sb.toString();
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(f8973a.getAndIncrement());
        sb2.append(str2);
        this.f8976d = sb2.toString();
    }

    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.f8974b;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8976d);
        sb.append(this.f8975c.getAndIncrement());
        Thread thread = new Thread(threadGroup, runnable, sb.toString(), 0);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (this.f8977e == 1) {
            thread.setPriority(1);
        } else if (thread.getPriority() != 5) {
            thread.setPriority(3);
        } else {
            thread.setPriority(5);
        }
        return thread;
    }
}
