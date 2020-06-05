package com.bytedance.sdk.openadsdk.p199j;

import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.j.d */
class TrackAdUrlImplEmpty implements TrackAdUrl {
    /* renamed from: a */
    private static volatile TrackAdUrlImplEmpty f8995a;

    /* renamed from: a */
    public void mo16822a() {
    }

    /* renamed from: a */
    public void mo16823a(String str) {
    }

    /* renamed from: a */
    public void mo16824a(String str, List<String> list, boolean z) {
    }

    /* renamed from: b */
    public static TrackAdUrlImplEmpty m11731b() {
        if (f8995a == null) {
            synchronized (TrackAdUrlImplEmpty.class) {
                if (f8995a == null) {
                    f8995a = new TrackAdUrlImplEmpty();
                }
            }
        }
        return f8995a;
    }

    private TrackAdUrlImplEmpty() {
    }
}
