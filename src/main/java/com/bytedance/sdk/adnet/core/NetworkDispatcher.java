package com.bytedance.sdk.adnet.core;

import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.p162e.ICache;
import com.bytedance.sdk.adnet.p162e.INetwork;
import com.bytedance.sdk.adnet.p162e.IResponseDelivery;
import java.util.concurrent.BlockingQueue;

/* renamed from: com.bytedance.sdk.adnet.core.k */
class NetworkDispatcher extends Thread {
    /* renamed from: a */
    private final BlockingQueue<Request<?>> f6269a;
    /* renamed from: b */
    private final INetwork f6270b;
    /* renamed from: c */
    private final ICache f6271c;
    /* renamed from: d */
    private final IResponseDelivery f6272d;
    /* renamed from: e */
    private volatile boolean f6273e = false;

    public NetworkDispatcher(BlockingQueue<Request<?>> blockingQueue, INetwork cVar, ICache bVar, IResponseDelivery dVar) {
        this.f6269a = blockingQueue;
        this.f6270b = cVar;
        this.f6271c = bVar;
        this.f6272d = dVar;
    }

    /* renamed from: a */
    public void mo14357a() {
        this.f6273e = true;
        interrupt();
    }

    /* renamed from: b */
    private void m7889b(Request<?> request) {
        if (VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(request.getTrafficStatsTag());
        }
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                m7888b();
            } catch (InterruptedException unused) {
                if (this.f6273e) {
                    Thread.currentThread().interrupt();
                    return;
                } else {
                    VNetLog.m7929c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
                }
            }
        }
    }

    /* renamed from: b */
    private void m7888b() throws InterruptedException {
        mo14358a((Request) this.f6269a.take());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo14358a(Request<?> request) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        request.mo14253a(3);
        try {
            request.addMarker("network-queue-take");
            if (request.isCanceled()) {
                request.mo14255a("network-discard-cancelled");
                request.mo14266e();
                request.mo14253a(4);
                return;
            }
            m7889b(request);
            NetworkResponse a = this.f6270b.mo14315a(request);
            request.setNetDuration(a.f6279f);
            request.addMarker("network-http-complete");
            if (!a.f6278e || !request.hasHadResponseDelivered()) {
                C1982p a2 = request.mo14188a(a);
                request.setNetDuration(a.f6279f);
                request.addMarker("network-parse-complete");
                if (request.shouldCache() && a2.f6294b != null) {
                    this.f6271c.mo14338a(request.getCacheKey(), a2.f6294b);
                    request.addMarker("network-cache-written");
                }
                request.markDelivered();
                this.f6272d.mo14347a(request, a2);
                request.mo14259b(a2);
                request.mo14253a(4);
                return;
            }
            request.mo14255a("not-modified");
            request.mo14266e();
            request.mo14253a(4);
        } catch (VAdError e) {
            e.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
            m7887a(request, e);
            request.mo14266e();
        } catch (Exception e2) {
            VNetLog.m7927a(e2, "Unhandled exception %s", e2.toString());
            VAdError vAdError = new VAdError((Throwable) e2);
            vAdError.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.f6272d.mo14349a(request, vAdError);
            request.mo14266e();
        } catch (Throwable th) {
            request.mo14253a(4);
            throw th;
        }
    }

    /* renamed from: a */
    private void m7887a(Request<?> request, VAdError vAdError) {
        this.f6272d.mo14349a(request, request.mo14251a(vAdError));
    }
}
