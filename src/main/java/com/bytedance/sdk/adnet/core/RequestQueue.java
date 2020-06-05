package com.bytedance.sdk.adnet.core;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.AdNetSdk;
import com.bytedance.sdk.adnet.p162e.ICache;
import com.bytedance.sdk.adnet.p162e.INetwork;
import com.bytedance.sdk.adnet.p162e.IResponseDelivery;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.bytedance.sdk.adnet.core.o */
public class RequestQueue {
    /* renamed from: a */
    private final AtomicInteger f6282a;
    /* renamed from: b */
    private final Set<Request<?>> f6283b;
    /* renamed from: c */
    private final PriorityBlockingQueue<Request<?>> f6284c;
    /* renamed from: d */
    private final PriorityBlockingQueue<Request<?>> f6285d;
    /* renamed from: e */
    private final ICache f6286e;
    /* renamed from: f */
    private final INetwork f6287f;
    /* renamed from: g */
    private final IResponseDelivery f6288g;
    /* renamed from: h */
    private final NetworkDispatcher[] f6289h;
    /* renamed from: i */
    private CacheDispatcher f6290i;
    /* renamed from: j */
    private final List<C1981b> f6291j;
    /* renamed from: k */
    private final List<C1980a> f6292k;

    /* compiled from: RequestQueue */
    /* renamed from: com.bytedance.sdk.adnet.core.o$a */
    public interface C1980a {
        /* renamed from: a */
        void mo14368a(Request<?> request, int i);
    }

    @Deprecated
    /* compiled from: RequestQueue */
    /* renamed from: com.bytedance.sdk.adnet.core.o$b */
    public interface C1981b<T> {
        /* renamed from: a */
        void mo14369a(Request<T> request);
    }

    public RequestQueue(ICache bVar, INetwork cVar, int i, IResponseDelivery dVar) {
        this.f6282a = new AtomicInteger();
        this.f6283b = new HashSet();
        this.f6284c = new PriorityBlockingQueue<>();
        this.f6285d = new PriorityBlockingQueue<>();
        this.f6291j = new ArrayList();
        this.f6292k = new ArrayList();
        this.f6286e = bVar;
        this.f6287f = cVar;
        this.f6289h = new NetworkDispatcher[i];
        this.f6288g = dVar;
    }

    public RequestQueue(ICache bVar, INetwork cVar, int i) {
        this(bVar, cVar, i, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
    }

    public RequestQueue(ICache bVar, INetwork cVar) {
        this(bVar, cVar, 4);
    }

    /* renamed from: a */
    public void mo14362a() {
        mo14364b();
        this.f6290i = new CacheDispatcher(this.f6284c, this.f6285d, this.f6286e, this.f6288g);
        this.f6290i.start();
        for (int i = 0; i < this.f6289h.length; i++) {
            NetworkDispatcher kVar = new NetworkDispatcher(this.f6285d, this.f6287f, this.f6286e, this.f6288g);
            this.f6289h[i] = kVar;
            kVar.start();
        }
    }

    /* renamed from: b */
    public void mo14364b() {
        NetworkDispatcher[] kVarArr;
        CacheDispatcher fVar = this.f6290i;
        if (fVar != null) {
            fVar.mo14325a();
        }
        for (NetworkDispatcher kVar : this.f6289h) {
            if (kVar != null) {
                kVar.mo14357a();
            }
        }
    }

    /* renamed from: c */
    public int mo14366c() {
        return this.f6282a.incrementAndGet();
    }

    /* renamed from: a */
    public <T> Request<T> mo14361a(Request<T> request) {
        mo14365b(request);
        request.setStartTime();
        request.setRequestQueue(this);
        synchronized (this.f6283b) {
            this.f6283b.add(request);
        }
        request.setSequence(mo14366c());
        request.addMarker("add-to-queue");
        mo14363a(request, 0);
        if (!request.shouldCache()) {
            this.f6285d.add(request);
            return request;
        }
        this.f6284c.add(request);
        return request;
    }

    /* renamed from: b */
    public <T> void mo14365b(Request<T> request) {
        if (request != null && !TextUtils.isEmpty(request.getUrl())) {
            String url = request.getUrl();
            if (AdNetSdk.m7652d() != null) {
                String a = AdNetSdk.m7652d().mo14160a(url);
                if (!TextUtils.isEmpty(a)) {
                    request.setUrl(a);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public <T> void mo14367c(Request<T> request) {
        synchronized (this.f6283b) {
            this.f6283b.remove(request);
        }
        synchronized (this.f6291j) {
            for (C1981b a : this.f6291j) {
                a.mo14369a(request);
            }
        }
        mo14363a(request, 5);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo14363a(Request<?> request, int i) {
        synchronized (this.f6292k) {
            for (C1980a a : this.f6292k) {
                a.mo14368a(request, i);
            }
        }
    }
}
