package com.p530ss.android.socialbase.downloader.p568l;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DefaultThreadFactory */
/* renamed from: com.ss.android.socialbase.downloader.l.a */
public class C6745a implements ThreadFactory {
    /* renamed from: a */
    private final String f22303a;
    /* renamed from: b */
    private final AtomicInteger f22304b;
    /* renamed from: c */
    private final boolean f22305c;

    public C6745a(String str) {
        this(str, false);
    }

    public C6745a(String str, boolean z) {
        this.f22304b = new AtomicInteger();
        this.f22303a = str;
        this.f22305c = z;
    }

    public Thread newThread(Runnable runnable) {
        int incrementAndGet = this.f22304b.incrementAndGet();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f22303a);
        sb.append("-");
        sb.append(incrementAndGet);
        Thread thread = new Thread(runnable, sb.toString());
        if (!this.f22305c) {
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
        }
        return thread;
    }
}
