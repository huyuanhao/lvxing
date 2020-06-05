package com.bytedance.sdk.p145a.p146a;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: com.bytedance.sdk.a.a.t */
public class Timeout {
    /* renamed from: c */
    public static final Timeout f5286c = new Timeout() {
        /* renamed from: a */
        public Timeout mo13609a(long j) {
            return this;
        }

        /* renamed from: a */
        public Timeout mo13610a(long j, TimeUnit timeUnit) {
            return this;
        }

        /* renamed from: g */
        public void mo13614g() throws IOException {
        }
    };
    /* renamed from: a */
    private boolean f5287a;
    /* renamed from: b */
    private long f5288b;
    /* renamed from: d */
    private long f5289d;

    /* renamed from: a */
    public Timeout mo13610a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("timeout < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (timeUnit != null) {
            this.f5289d = timeUnit.toNanos(j);
            return this;
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    /* renamed from: j_ */
    public long mo13615j_() {
        return this.f5289d;
    }

    /* renamed from: k_ */
    public boolean mo13616k_() {
        return this.f5287a;
    }

    /* renamed from: d */
    public long mo13611d() {
        if (this.f5287a) {
            return this.f5288b;
        }
        throw new IllegalStateException("No deadline");
    }

    /* renamed from: a */
    public Timeout mo13609a(long j) {
        this.f5287a = true;
        this.f5288b = j;
        return this;
    }

    /* renamed from: e */
    public Timeout mo13612e() {
        this.f5289d = 0;
        return this;
    }

    /* renamed from: f */
    public Timeout mo13613f() {
        this.f5287a = false;
        return this;
    }

    /* renamed from: g */
    public void mo13614g() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        } else if (this.f5287a && this.f5288b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
