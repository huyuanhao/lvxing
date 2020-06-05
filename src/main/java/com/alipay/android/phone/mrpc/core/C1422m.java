package com.alipay.android.phone.mrpc.core;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* renamed from: com.alipay.android.phone.mrpc.core.m */
final class C1422m extends FutureTask<C1430u> {
    /* renamed from: a */
    final /* synthetic */ C1426q f3645a;
    /* renamed from: b */
    final /* synthetic */ C1421l f3646b;

    C1422m(C1421l lVar, Callable callable, C1426q qVar) {
        this.f3646b = lVar;
        this.f3645a = qVar;
        super(callable);
    }

    /* access modifiers changed from: protected|final */
    public final void done() {
        C1424o a = this.f3645a.mo11992a();
        if (a.mo11994f() == null) {
            super.done();
            return;
        }
        try {
            get();
            if (isCancelled() || a.mo11996h()) {
                a.mo11995g();
                if (!isCancelled() || !isDone()) {
                    cancel(false);
                }
            }
        } catch (InterruptedException e) {
            new StringBuilder().append(e);
        } catch (ExecutionException e2) {
            if (e2.getCause() == null || !(e2.getCause() instanceof HttpException)) {
                new StringBuilder().append(e2);
                return;
            }
            HttpException httpException = (HttpException) e2.getCause();
            httpException.getCode();
            httpException.getMsg();
        } catch (CancellationException unused) {
            a.mo11995g();
        } catch (Throwable th) {
            throw new RuntimeException("An error occured while executing http request", th);
        }
    }
}
