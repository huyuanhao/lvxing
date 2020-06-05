package com.bytedance.sdk.adnet.core;

import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.p160c.TNCBridge;
import com.bytedance.sdk.adnet.p160c.TNCManager;
import com.bytedance.sdk.adnet.p162e.IResponseDelivery;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: com.bytedance.sdk.adnet.core.i */
class ExecutorDelivery implements IResponseDelivery {
    /* renamed from: a */
    private final Executor f6258a;
    /* renamed from: b */
    private final Executor f6259b = Executors.newCachedThreadPool();
    /* renamed from: c */
    private TNCBridge f6260c = TNCManager.m7771a();

    /* compiled from: ExecutorDelivery */
    /* renamed from: com.bytedance.sdk.adnet.core.i$a */
    private static class C1976a implements Runnable {
        /* renamed from: a */
        private final Request f6263a;
        /* renamed from: b */
        private final C1982p f6264b;
        /* renamed from: c */
        private final Runnable f6265c;

        public C1976a(Request request, C1982p pVar, Runnable runnable) {
            this.f6263a = request;
            this.f6264b = pVar;
            this.f6265c = runnable;
        }

        public void run() {
            if (this.f6263a.isCanceled()) {
                this.f6263a.mo14255a("canceled-at-delivery");
                return;
            }
            this.f6264b.f6299g = this.f6263a.getExtra();
            this.f6264b.mo14370a(SystemClock.elapsedRealtime() - this.f6263a.getStartTime());
            this.f6264b.mo14374b(this.f6263a.getNetDuration());
            if (this.f6264b.mo14373a()) {
                try {
                    this.f6263a.mo14190a(this.f6264b);
                } catch (Throwable unused) {
                }
            } else {
                this.f6263a.deliverError(this.f6264b);
            }
            if (this.f6264b.f6296d) {
                this.f6263a.addMarker("intermediate-response");
            } else {
                this.f6263a.mo14255a("done");
            }
            Runnable runnable = this.f6265c;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public ExecutorDelivery(final Handler handler) {
        this.f6258a = new Executor() {
            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    /* renamed from: a */
    private Executor m7869a(Request<?> request) {
        return (request == null || request.isResponseOnMain()) ? this.f6258a : this.f6259b;
    }

    /* renamed from: a */
    public void mo14347a(Request<?> request, C1982p<?> pVar) {
        mo14348a(request, pVar, null);
        TNCBridge cVar = this.f6260c;
        if (cVar != null) {
            cVar.mo14237a((Request) request, (C1982p) pVar);
        }
    }

    /* renamed from: a */
    public void mo14348a(Request<?> request, C1982p<?> pVar, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        m7869a(request).execute(new C1976a(request, pVar, runnable));
        TNCBridge cVar = this.f6260c;
        if (cVar != null) {
            cVar.mo14237a((Request) request, (C1982p) pVar);
        }
    }

    /* renamed from: a */
    public void mo14349a(Request<?> request, VAdError vAdError) {
        request.addMarker("post-error");
        m7869a(request).execute(new C1976a(request, C1982p.m7916a(vAdError), null));
        TNCBridge cVar = this.f6260c;
        if (cVar != null) {
            cVar.mo14238a((Request) request, (Exception) vAdError);
        }
    }
}
