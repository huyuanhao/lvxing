package com.kwad.sdk.core.p326e.p327a;

import com.kwad.sdk.core.request.p340a.C4258b;
import com.kwad.sdk.core.response.p341a.C4320a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* renamed from: com.kwad.sdk.core.e.a.a */
public abstract class C4105a<R extends C4258b> {
    /* renamed from: a */
    private static ExecutorService f13764a = Executors.newFixedThreadPool(5);
    /* renamed from: b */
    private Future<?> f13765b;

    /* renamed from: a */
    public abstract R mo23795a();

    /* renamed from: a */
    public abstract void mo23796a(R r, C4320a aVar);

    /* renamed from: b */
    public void mo23797b() {
        this.f13765b = f13764a.submit(new Runnable() {
            public void run() {
                C4105a.this.mo23798c();
            }
        });
    }

    /* renamed from: c */
    public abstract void mo23798c();
}
