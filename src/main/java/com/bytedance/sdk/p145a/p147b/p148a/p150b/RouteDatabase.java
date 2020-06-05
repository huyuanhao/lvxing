package com.bytedance.sdk.p145a.p147b.p148a.p150b;

import com.bytedance.sdk.p145a.p147b.Route;
import java.util.LinkedHashSet;
import java.util.Set;

/* renamed from: com.bytedance.sdk.a.b.a.b.d */
public final class RouteDatabase {
    /* renamed from: a */
    private final Set<Route> f5369a = new LinkedHashSet();

    /* renamed from: a */
    public synchronized void mo13700a(Route dVar) {
        this.f5369a.add(dVar);
    }

    /* renamed from: b */
    public synchronized void mo13701b(Route dVar) {
        this.f5369a.remove(dVar);
    }

    /* renamed from: c */
    public synchronized boolean mo13702c(Route dVar) {
        return this.f5369a.contains(dVar);
    }
}
