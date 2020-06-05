package com.bytedance.sdk.adnet.p159b;

import android.os.SystemClock;
import com.bytedance.sdk.adnet.core.C1982p;
import com.bytedance.sdk.adnet.core.C1982p.C1983a;
import com.bytedance.sdk.adnet.core.Request;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.bytedance.sdk.adnet.b.i */
public class RequestFuture<T> implements C1983a<T>, Future<C1982p<T>> {
    /* renamed from: a */
    private Request<?> f6142a;
    /* renamed from: b */
    private boolean f6143b = false;
    /* renamed from: c */
    private C1982p<T> f6144c;

    /* renamed from: a */
    public static <E> RequestFuture<E> m7746a() {
        return new RequestFuture<>();
    }

    private RequestFuture() {
    }

    public synchronized boolean cancel(boolean z) {
        if (this.f6142a == null) {
            return false;
        }
        if (isDone()) {
            return false;
        }
        this.f6142a.cancel();
        return true;
    }

    /* renamed from: b */
    public C1982p<T> get() throws InterruptedException {
        try {
            return m7747a((Long) null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public C1982p<T> get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        return m7747a(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    /* renamed from: a */
    private synchronized C1982p<T> m7747a(Long l) throws InterruptedException, TimeoutException {
        if (this.f6143b) {
            return this.f6144c;
        }
        if (l == null) {
            while (!isDone()) {
                wait(0);
            }
        } else if (l.longValue() > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long longValue = l.longValue() + uptimeMillis;
            while (!isDone() && uptimeMillis < longValue) {
                wait(longValue - uptimeMillis);
                uptimeMillis = SystemClock.uptimeMillis();
            }
        }
        if (this.f6143b) {
            return this.f6144c;
        }
        throw new TimeoutException();
    }

    public boolean isCancelled() {
        Request<?> request = this.f6142a;
        if (request == null) {
            return false;
        }
        return request.isCanceled();
    }

    public synchronized boolean isDone() {
        boolean z;
        z = this.f6143b || isCancelled();
        return z;
    }

    /* renamed from: a */
    public synchronized void mo14171a(C1982p<T> pVar) {
        this.f6143b = true;
        this.f6144c = pVar;
        notifyAll();
    }

    /* renamed from: b */
    public synchronized void mo14172b(C1982p<T> pVar) {
        this.f6143b = true;
        this.f6144c = pVar;
        notifyAll();
    }
}
