package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: Timeout */
/* renamed from: okio.s */
public class C8548s {
    /* renamed from: c */
    public static final C8548s f29055c = new C8548s() {
        /* renamed from: a */
        public C8548s mo40803a(long j) {
            return this;
        }

        /* renamed from: a */
        public C8548s mo40804a(long j, TimeUnit timeUnit) {
            return this;
        }

        /* renamed from: g */
        public void mo40807g() throws IOException {
        }
    };
    /* renamed from: a */
    private boolean f29056a;
    /* renamed from: b */
    private long f29057b;
    /* renamed from: d */
    private long f29058d;

    /* renamed from: a */
    public C8548s mo40804a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("timeout < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (timeUnit != null) {
            this.f29058d = timeUnit.toNanos(j);
            return this;
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    /* renamed from: n_ */
    public long mo40808n_() {
        return this.f29058d;
    }

    /* renamed from: o_ */
    public boolean mo40809o_() {
        return this.f29056a;
    }

    /* renamed from: d */
    public long mo40805d() {
        if (this.f29056a) {
            return this.f29057b;
        }
        throw new IllegalStateException("No deadline");
    }

    /* renamed from: a */
    public C8548s mo40803a(long j) {
        this.f29056a = true;
        this.f29057b = j;
        return this;
    }

    /* renamed from: p_ */
    public C8548s mo40810p_() {
        this.f29058d = 0;
        return this;
    }

    /* renamed from: f */
    public C8548s mo40806f() {
        this.f29056a = false;
        return this;
    }

    /* renamed from: g */
    public void mo40807g() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.f29056a && this.f29057b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
